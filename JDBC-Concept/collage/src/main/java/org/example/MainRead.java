package org.example;

import java.sql.*;

public class MainRead {
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
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/collage", "root","neha");
            preparedStatement= connection.prepareStatement("SELECT * FROM collage.collage_details");
            // preparedStatement.setInt(1,101);
            resultSet=preparedStatement.executeQuery();
            if(resultSet!=null){
                System.out.println("Connnection stablished successfully "+resultSet);
                System.out.println("collage_name | collage_id | dept_name | dept_id | fees |place");
                while(resultSet.next()){
                    System.out.println(resultSet.getString("collage_name")+" | "+
                            resultSet.getInt("collage_id")+" | "+
                            resultSet.getString("dept_name")+" | "+
                            resultSet.getInt("dept_id")+" | "+
                            resultSet.getInt("fees")+" | "+
                            resultSet.getString("place"));

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
