package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainRunner {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver connected successfully");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url =  ("jdbc:mysql://localhost:3306/collage");
        String userName = "root";
        String pws = "neha";

        String query = "insert into  collage_details (collage_name,collage_id,dept_name)values(?,?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;


        try {
            connection= DriverManager.getConnection(url,userName,pws);
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,"ABC");
            preparedStatement.setInt(2,112);
            preparedStatement.setString(3,"CHEMISTRY");
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
