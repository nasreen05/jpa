package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CompanyUpdate {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Connected Successfully");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = ("jdbc:mysql://localhost:3306/company_details");
        String username = "root";
        String pws = "neha";
        String query = ("UPDATE company_doc\n" +
                "SET totalEmp = 500 \n" +
                "WHERE companyId = 104");

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

