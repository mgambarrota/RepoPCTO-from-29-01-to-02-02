package it.betacom;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.jupiter.api.*;

import java.util.*;
import java.io.*;
import java.sql.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase {
    private static Properties properties;
    private static Connection connection;

    public static void loadProperties(){
        Properties prop = new Properties();
        try {
            prop.load(AppTest.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    static void openConnection() throws SQLException {
        loadProperties();
        String url = properties.getProperty("database.url");
        String username = properties.getProperty("database.username");
        String pass = properties.getProperty("database.password");
        connection = DriverManager.getConnection(url, username, pass);
    }

    static void closeConnection() throws SQLException {
        if (connection != null){
            connection.close();
        }
    }



}
