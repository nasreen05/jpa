package org.example;

import java.sql.*;

public class StationUpdate {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Connected Successfully");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
      /*  String url = ("jdbc:mysql://localhost:3306/station");
        String username = "root";
        String pws = "neha"; */
        String query = " UPDATE station_info SET platforms =? WHERE id = ?";

        Connection connection = null;
      //  Statement statement = null;
        PreparedStatement ps=null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/station", "root","neha");
            ps =connection.prepareStatement(query);
            ps.setInt(1, 101);
            ps.setInt(2,101);
          //  ps.setString(3,"pencil");
            int num=ps.executeUpdate();
            System.out.println("to check"+num);



           // statement = connection.createStatement();
           // boolean ref = statement.execute(query);


        } catch (SQLException e) {
         //   e.printStackTrace();
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



