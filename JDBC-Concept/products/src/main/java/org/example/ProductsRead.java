package org.example;

import java.sql.*;

public class ProductsRead {
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
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/products", "root","neha");
            preparedStatement= connection.prepareStatement("SELECT * FROM products.products_details ");
            // preparedStatement.setInt(1,101);
            resultSet=preparedStatement.executeQuery();
            if(resultSet!=null){
                System.out.println("Connnection stablished successfully "+resultSet);
                System.out.println("products_name | products_id | products_price | products_quantaty | discount");
                while(resultSet.next()){
                    System.out.println(resultSet.getString("products_name")+" | "+
                            resultSet.getString("products_id")+" | "+
                            resultSet.getInt("products_price")+" | "+
                            resultSet.getInt("discount")+" | "+
                            resultSet.getInt("products_quantaty"));

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

