package it.betacom;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@Slf4j
public class AppTest {
    private static Properties properties;
    private static Connection connection;

    public static void loadProperties(){
        properties = new Properties();
        try {
            properties.load(AppTest.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            log.error("Unexpected error");
            e.printStackTrace();
            fail();
        }
    }
    @BeforeAll
    public static void openConnection() throws SQLException {
        loadProperties();
        String url = properties.getProperty("database.url");
        String username = properties.getProperty("database.username");
        String pass = properties.getProperty("database.password");
        connection = DriverManager.getConnection(url, username, pass);
        log.info("Opening connection...");
    }

    @AfterAll
    static void closeConnection() throws SQLException {
        if (connection != null){
            connection.close();
            log.info("Connection closed");
        }
    }

    /*@Test
    public void testOnePlusTwo(){
        System.out.println("1+2 == 3!");
        assertEquals(1+2, 3);
    }*/

    @ParameterizedTest
    @CsvFileSource(resources="/queries.csv", numLinesToSkip=1, delimiter=';')
    void executeQueryTest(String q, String expected){
        try{
            log.info(String.format("Executing '%s'", q));
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery(q);
            res.next();

            String s = res.getString(1);
            assertEquals(expected, s);
            log.info(String.format("'%s' ok", q));
        }catch(SQLException e){
            log.error("Something went wrong");
            e.printStackTrace();
            fail();
        }
    }
}