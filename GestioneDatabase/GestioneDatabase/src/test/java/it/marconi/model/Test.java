package it.marconi.model;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import static junit.framework.Assert.assertEquals;

@Slf4j

public class Test {

    private static Connection connection;
    private static Properties properties;
    private static void loadProperties() {
        properties = new Properties();
        try (InputStream input = Test.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                log.error("Impossibile trovare config.properties");
                return;
            }
            properties.load(input);
        } catch (IOException e) {
            log.error("Errore durante il caricamento di config.properties");
        }
    }

    static void createConnection() throws SQLException {
        loadProperties();
        String url = properties.getProperty("database.url");
        String username = properties.getProperty("database.username");
        String password = properties.getProperty("database.password");
        connection = DriverManager.getConnection(url, username, password);
        log.info("Connessione al DB riuscita");
    }

    @AfterAll
    static void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
            log.info("Connessione chiusa");
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/query.csv", numLinesToSkip = 1)
    void testQuery(String query, String expectedValue) throws SQLException {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            resultSet.next();
            String actualValue = resultSet.getString(1);
            assertEquals(expectedValue, actualValue);
            log.info("Il valore aspettato è lo stesso di quello attuale.");
        }
    }
}
