package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // 2. load and register driver class
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            System.out.println("loaded  not successfully");
        }

        // 3. creating connection
        String url = "jdbc:mysql://localhost:3306/collage";
        String userName = "root";
        String psw = "neha";

        // 5. organize query
        String insertQuery = "insert into collage_details values(\"CMC\",110,\"MBBS\",608,3000,\"Kolkata\");";


        Connection connection = null;
        Statement statement = null;

        try {

            connection = DriverManager.getConnection(url, userName, psw);
            System.out.println("Connection established successfully: " + connection);

            // 4. create statement
            statement = connection.createStatement();
            boolean ref = statement.execute(insertQuery);
            System.out.println("Data inserted successfully: " + ref);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Connection attempt finished");
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
