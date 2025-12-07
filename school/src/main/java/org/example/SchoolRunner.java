package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SchoolRunner {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver connected successfully");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url =  ("jdbc:mysql://localhost:3306/school");
        String userName = "root";
        String pws = "neha";

        String query = "insert into  school_details (school_id,school_name,teacher_id)values(?,?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;


        try {
            connection= DriverManager.getConnection(url,userName,pws);
            preparedStatement=connection.prepareStatement(query);

            preparedStatement.setInt(1,234);
            preparedStatement.setString(2,"CHE");
            preparedStatement.setInt(3,155);
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


