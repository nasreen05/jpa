package org.example;

import java.sql.*;

public class ProductsRunner {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drive loaded successfully");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = ("jdbc:mysql://localhost:3306/products");
        String userName = "root";
        String password = "neha";

        String query = "insert into  products_details ( products_name,products_id,products_price,products_quantaty) values(?,?,?,?);";
        Connection connection = null;
        PreparedStatement preparedStatement=null;

        try {
            connection = DriverManager.getConnection(url, userName, password);
                      preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setString(1, "Ink");
                        preparedStatement.setInt(2, 20);
                        preparedStatement.setInt(3, 120);
                        preparedStatement.setInt(4,500);
                        preparedStatement.execute();
                        System.out.println("Data inserted successfully");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } finally {
                        if (connection != null) {
                            try {
                                connection.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                        if (preparedStatement != null) {
                            try {
                                preparedStatement.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }