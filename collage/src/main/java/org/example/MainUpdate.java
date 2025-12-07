package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MainUpdate {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Connected Successfully");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = ("jdbc:mysql://localhost:3306/collage");
        String username = "root";
        String pws = "neha";
        String query = ("UPDATE collage_details \n" +
                "SET fees = 8760 \n" +
                "WHERE collage_id = 101");

        Connection connection = null;
        Statement statement = null;

            try {
                connection = DriverManager.getConnection(url, username, pws);
                statement = connection.createStatement();
                boolean ref = statement.execute(query);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

