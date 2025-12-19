package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Station {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            System.out.println("loaded  not successfully");
        }


        String url = "jdbc:mysql://localhost:3306/station";
        String userName = "root";
        String psw = "neha";


        String insertQuery = "INSERT INTO station_info VALUES\n" +
                "(111, 'Delhi Station', 'Delhi', 5, 'DEMC')";

        Connection connection = null;
        Statement statement = null;

        try {

            connection = DriverManager.getConnection(url, userName, psw);
            System.out.println("Connection established successfully: " + connection);


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
