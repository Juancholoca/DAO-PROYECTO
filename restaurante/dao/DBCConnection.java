package com.restaurante.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.InputStream;

public class DBCConnection {
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null) return connection;

        try {
            Properties props = new Properties();
            InputStream input = DBCConnection.class.getClassLoader()
                               .getResourceAsStream("db.properties");
            props.load(input);

            String driver = props.getProperty("db.driver");
            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
