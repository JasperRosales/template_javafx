package com.template.template.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseSetup {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = DatabaseSetup.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                throw new IOException("Property file 'application.properties' not found in the classpath");
            }
            properties.load(input);

            Class.forName(properties.getProperty("db.driver"));
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = properties.getProperty("db.url");
        String username = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");

        return DriverManager.getConnection(url, username, password);
    }
}
