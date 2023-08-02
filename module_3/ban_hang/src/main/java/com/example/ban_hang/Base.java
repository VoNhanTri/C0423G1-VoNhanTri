package com.example.ban_hang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Base {
    private static String jdbcUrl = "jdbc:mysql://localhost:3306/thehome";
    private static String username = "root";
    private static String password = "123456";
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private Base() {

    }

    public static Connection getConnection() {
        return connection;
    }
}


