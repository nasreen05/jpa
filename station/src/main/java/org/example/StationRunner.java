package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StationRunner {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver connected successfully");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url =  ("jdbc:mysql://localhost:3306/station");
        String userName = "root";
        String pws = "neha";

        String query = "INSERT INTO station_info(id,station_name,city) VALUES\n" +
                "(?,?,?)";
                Connection connection = null;
        PreparedStatement preparedStatement = null;


        try {
            connection= DriverManager.getConnection(url,userName,pws);
            preparedStatement=connection.prepareStatement(query);

            preparedStatement.setInt(1,112);
            preparedStatement.setString(2,"Siliguri station");
            preparedStatement.setString(3,"Siliguri");
            preparedStatement.execute();
            System.out.println("Data inserted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection!=null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement!=null){
                try{
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        }

    }
}


