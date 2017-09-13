package io.swagger.api.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteOrder {
    private Connection con;
    
    public DeleteOrder(Long orderID) {
        String url = "jdbc:sqlserver://localhost:1443;databaseName=OrdersBase";
        String name = "sa";
        String password = "Admin123";
        try {
            con = DriverManager.getConnection(url, name, password);
            System.out.println("Connected.");
            Statement st = con.createStatement();
            String query = "DELETE FROM Orders WHERE orderID = "+orderID;
            Statement statement = con.createStatement();
            System.out.println(query);
            statement.executeUpdate(query);
            System.out.println("Disconnected.");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}