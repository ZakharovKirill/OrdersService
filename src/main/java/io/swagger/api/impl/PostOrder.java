package io.swagger.api.impl;

import io.swagger.model.OrderRequest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class PostOrder {
    private Connection con;
    
    public PostOrder(OrderRequest body) {
        String url = "jdbc:sqlserver://localhost:1443;databaseName=OrdersBase";
        String name = "sa";
        String password = "Admin123";
        try {
            con = DriverManager.getConnection(url, name, password);
            System.out.println("Connected.");
            Statement st = con.createStatement();
            String rqst = body.product.toString();
            int quantity = body.quantity;
            String query = "SELECT Product.productID FROM Product WHERE productName = "+rqst;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int productID = rs.getInt("productID");
            }
            System.out.println("Disconnected.");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}