package io.swagger.api.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class UpdateOrder {
    private Connection con;
    
    public UpdateOrder(int orderID) {
        String url = "jdbc:sqlserver://localhost:1443;databaseName=OrdersBase";
        String name = "sa";
        String password = "Admin123";
        try {
            con = DriverManager.getConnection(url, name, password);
            System.out.println("Connected.");
            Statement st = con.createStatement();
            String query = "SELECT Product.productName, Product.price, Orders.quantity, Orders.discount, CustomerBase.customerName, "
                + "CustomerBase.street, CustomerBase.city, CustomerBase.state, CustomerBase.zip, [Customer'sCard].cardNo, CardType.cardType "
                + "FROM Orders, Product, CustomerBase, [Customer'sCard], CardType WHERE Product.productID = Orders.productID "
                + "and CustomerBase.customerID = Orders.customerID and [Customer'sCard].cardID = Orders.cardId "
                + "and CardType.cardTypeID = [Customer'sCard].cardTypeID";
            ResultSet rs = st.executeQuery(query);
            System.out.println("Disconnected.");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}