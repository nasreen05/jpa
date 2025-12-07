package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SchoolUpdate {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Connected Successfully");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = ("jdbc:mysql://localhost:3306/school");
        String username = "root";
        String pws = "neha";
        String query = ("UPDATE school_details \n" +
                "SET teacher_name =\"Nasreen\"\n" +
                "WHERE school_id = 105");

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(url, username, pws);
            statement = connection.createStatement();
            boolean ref = statement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}



