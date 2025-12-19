package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class School {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drive loaded successfully");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            System.out.println("loaded not successfully");
        }
        String url = ("jdbc:mysql://localhost:3306/school");
        String userName = "root";
        String password = "neha";

     String insertQuery=("insert into school_details values(108,\"Ideal\",8008,\"Kolkata\",\"Rafia\")");
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connection established successfully" + connection);


            statement = connection.createStatement();
            boolean ref = statement.execute(insertQuery);
            System.out.println("Data inserted successfully" + ref);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("connection attempt finished ");
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();

                }
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
}