package com.xworkz.ecom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

        public class ProductRunner {

            public static void main(String[] args) {

                // 2. load and register driver class
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    System.out.println("Driver loaded successfully");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("loaded successfully");
                }

                // 3. creating connection
                String url = "jdbc:mysql://localhost:3306/ecom";
                String userName = "root";
                String psw = "neha";

                // 5. organize query
                String insertQuery = "insert into ecom_details value(10,\"darkChocolate\",70,75)";



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
                    // 6. close costly resources
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
