package it.marconi.model;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.DriverManager;

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

    static void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
            log.info("Connessione chiusa");
        }
    }
}
