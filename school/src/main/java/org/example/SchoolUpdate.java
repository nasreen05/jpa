package org.example;

import java.sql.*;

public class SchoolUpdate {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Connected Successfully");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String query = " UPDATE school_details SET teacher_name =? WHERE school_id = ?";
        Connection connection = null;

        PreparedStatement ps=null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root","neha");
            ps =connection.prepareStatement(query);
            ps.setString(1,"Tania");
            ps.setInt(2,102);

            int num=ps.executeUpdate();
            System.out.println("to check"+num);




        } catch (
                SQLException e) {

            throw  new RuntimeException(e);
        } finally {
            if (connection!= null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    //e.printStackTrace();
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


