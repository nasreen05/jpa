package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StationDelete {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Connected Successfully");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String query = " DELETE FROM station_info WHERE  id=? and platforms=?";

        Connection connection = null;

        PreparedStatement ps=null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/station", "root","neha");
            ps =connection.prepareStatement(query);
            ps.setInt(1, 102);
            ps.setInt(2,9);

            int num=ps.executeUpdate();
            System.out.println("to check"+num);




        } catch (SQLException e) {

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

