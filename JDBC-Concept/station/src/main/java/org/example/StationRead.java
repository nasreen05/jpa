package org.example;

import java.sql.*;

public class StationRead {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Connected Successfully");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;

        try{
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/station", "root","neha");
            preparedStatement= connection.prepareStatement("SELECT * FROM station.station_info ");
            // preparedStatement.setInt(1,101);
            resultSet=preparedStatement.executeQuery();
            if(resultSet!=null){
                System.out.println("Connnection stablished successfully "+resultSet);
                System.out.println("id | station_name | city | platforms | station_code");
                while(resultSet.next()){
                    System.out.println(resultSet.getInt("id")+" | "+
                            resultSet.getString("station_name")+" | "+
                            resultSet.getString("city")+" | "+
                            resultSet.getString("station_code")+" | "+
                            resultSet.getInt("platforms"));

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

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
