package com.hirelink.util;

import java.sql.*;
import java.io.InputStream;
import java.util.Properties;

public class DBConnection {
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null) return connection;

        try (InputStream input = DBConnection.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (input == null) {
                System.out.println("❌ Sorry, unable to find db.properties");
                return null;
            }

            Properties props = new Properties();
            props.load(input);

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.username");
            String password = props.getProperty("db.password");


            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hirelink?autoReconnect=true&useSSL=false",
                    "root",
                    "root"
            );
            System.out.println("✅ Database Connected Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;

    }
}


