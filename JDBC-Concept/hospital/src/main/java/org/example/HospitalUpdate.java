package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HospitalUpdate {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Connected Successfully");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String query = "UPDATE hospital_details SET totalDoctor = ? WHERE idhospital_details =? ";

        Connection connection = null;

        PreparedStatement ps=null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root","neha");
            ps =connection.prepareStatement(query);
            ps.setInt(1, 110);
            ps.setInt(2,102);

            int num=ps.executeUpdate();
            System.out.println("to check"+num);




        } catch (SQLException e) {

            throw  new RuntimeException(e);
        } finally {
            if (connection!= null) {
                try {
                    connection.close();
                } catch (SQLException e) {

                    throw  new RuntimeException(e);
                }
            }
            if(ps != null){
                try {
                    ps.close();
                }catch (SQLException e){
                    throw  new RuntimeException(e);
                }
            }
        }
    }
}




