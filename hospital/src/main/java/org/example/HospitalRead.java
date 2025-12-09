package org.example;

import java.sql.*;

public class HospitalRead {
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
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root","neha");
            preparedStatement= connection.prepareStatement("SELECT * FROM hospital.hospital_details ");
           // preparedStatement.setInt(1,101);
            resultSet=preparedStatement.executeQuery();
            if(resultSet!=null){
                System.out.println("Connnection stablished successfully "+resultSet);
                System.out.println("idhospital_details | hospital_name | totalDoctor | total_patient");
                while(resultSet.next()){
                    System.out.println(resultSet.getInt("idhospital_details")+" | "+
                            resultSet.getString("hospital_name")+" | "+
                            resultSet.getInt("totalDoctor")+" | "+
                            resultSet.getInt("total_patient"));

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
