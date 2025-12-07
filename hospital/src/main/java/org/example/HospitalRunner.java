package org.example;

import java.sql.*;

public class HospitalRunner {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver connected successfully");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url =  ("jdbc:mysql://localhost:3306/hospital");
        String userName = "root";
        String pws = "neha";

        String query = "insert into  hospital_details (idhospital_details,hospital_name,totalDoctor)values(?,?,?);";

        Connection connection = null;
        PreparedStatement preparedStatement = null;


        try {
            connection=DriverManager.getConnection(url,userName,pws);
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,106);
            preparedStatement.setString(2,"NBMCH");
            preparedStatement.setInt(3,150);
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