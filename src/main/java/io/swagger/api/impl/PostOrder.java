package io.swagger.api.impl;

import io.swagger.model.OrderRequest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class PostOrder {
    private Connection con;
    
    public void ProductResult(enum body){
        String result = '';
        switch (body.product){
            case MYMONEY:
                result = 'MYMONEY';
                break;
            case FAMILYALBUM:
                result = 'FAMILYALBUM';
                break;
            case SCREENSAVER:
                result = 'SCREENSAVER';
                break;
            }
        return result;
    }
    
    public PostOrder(OrderRequest body) {
        String url = "jdbc:sqlserver://localhost:1443;databaseName=OrdersBase";
        String name = "sa";
        String password = "Admin123";
        try {
            con = DriverManager.getConnection(url, name, password);
            System.out.println("Connected.");
            Statement st = con.createStatement();
            int quantity = body.quantity;
            String customerName = body.customerName;
            String street = body.street;
            String city = body.city;
            String state = body.state;
            int zip = body.zip;
            String cardNo = body.cardNo;
            String product  = ProductResult.result;
            String query = "SELECT Product.productID FROM Product WHERE productName = "+product;
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