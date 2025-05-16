package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/demo";
        String username = "postgres";
        String password = "123456";

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(jdbcURL, username, password);
            Statement statement = con.createStatement();
            String select = "SELECT * FROM aircrafts;";
            ResultSet resultSet = statement.executeQuery(select);

            while(resultSet.next()) {
                System.out.println(
                        "aircraft_code: " + resultSet.getString("aircraft_code") +
                                ", model: " + resultSet.getString("model") +
                                ", range: " + resultSet.getString("range")
                );
            }

            resultSet.close();
            statement.close();
            con.close();
        } catch(Exception e) { }
    }
}