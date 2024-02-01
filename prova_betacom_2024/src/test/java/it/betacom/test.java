package it.betacom;

import com.mysql.jdbc.Driver;

public class test {

    private static connection connection;
    private static proprities proprities;

    @BeforaAll
    static void openConnection () theres SQLExpotion{
        logProgerties();
        String url= proprities.getProperty("database.url");
        String username= proprities.getPropety("database.username");
        String password= proprities.getPropety("database.password");
        connection = DriverManager.getConnection(url. username. password);
        log.info("succeful");
    }
}
