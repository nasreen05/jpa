package org.example;

import java.sql.*;

public class SchoolRead {
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
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root","neha");
            preparedStatement= connection.prepareStatement("SELECT * FROM school.school_details ");
            // preparedStatement.setInt(1,101);
            resultSet=preparedStatement.executeQuery();
            if(resultSet!=null){
                System.out.println("Connnection stablished successfully "+resultSet);
                System.out.println("school_id | school_name | teacher_id | place | teacher_name");
                while(resultSet.next()){
                    System.out.println(resultSet.getInt("school_id")+" | "+
                            resultSet.getString("school_name")+" | "+
                            resultSet.getInt("teacher_id")+" | "+
                            resultSet.getString("place")+" | "+
                            resultSet.getString("teacher_name"));

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
