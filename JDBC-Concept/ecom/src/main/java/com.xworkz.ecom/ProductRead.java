package com.xworkz.ecom;

import java.sql.*;

public class ProductRead {
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
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/ecom", "root","neha");
            preparedStatement= connection.prepareStatement("SELECT * FROM ecom.ecom_details ");
            // preparedStatement.setInt(1,101);
            resultSet=preparedStatement.executeQuery();
            if(resultSet!=null){
                System.out.println("Connnection stablished successfully "+resultSet);
                System.out.println("product_id | product_name | price | quantity");
                while(resultSet.next()){
                    System.out.println(resultSet.getInt("product_id")+" | "+
                            resultSet.getString("product_name")+" | "+
                            resultSet.getInt("price")+" | "+
                            resultSet.getInt("quantity"));

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

