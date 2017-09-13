package io.swagger.api.impl;

import io.swagger.api.ApiResponseMessage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.ws.rs.core.Response;
import io.swagger.api.*;
import io.swagger.model.*;

public class GetOrdersBase {
    private Connection con;
    String productName, customerName, street, city, state, cardNo, cardType;
    int price, quantity, discount, total, zip;
    public GetOrdersBase(boolean querystatus, Long orderID) {
        String url = "jdbc:sqlserver://localhost:1443;databaseName=OrdersBase";
        String name = "sa";
        String password = "Admin123";
        try {
            con = DriverManager.getConnection(url, name, password);
            System.out.println("Connected.");
            Statement st = con.createStatement();
            if (querystatus == true){
                String query = "SELECT Product.productName, Product.price, Orders.quantity, Orders.discount, CustomerBase.customerName, "
                        + "CustomerBase.street, CustomerBase.city, CustomerBase.state, CustomerBase.zip, [Customer'sCard].cardNo, CardType.cardType "
                        + "FROM Orders, Product, CustomerBase, [Customer'sCard], CardType WHERE Product.productID = Orders.productID "
                        + "and CustomerBase.customerID = Orders.customerID and [Customer'sCard].cardID = Orders.cardId "
                        + "and CardType.cardTypeID = [Customer'sCard].cardTypeID";
                ResultSet rs = st.executeQuery(query);
                printResults(rs);
            }
            else{
                String query = "SELECT * FROM Orders, Product, CustomerBase, [Customer'sCard], CardType WHERE Orders.orderID = "+orderID+
                "and Product.productID IN (SELECT productID FROM Orders WHERE OrderID= "+orderID+
                ") and CustomerBase.customerID IN (SELECT customerID FROM Orders WHERE orderID = "+orderID+
                ") and [Customer'sCard].cardID IN (SELECT cardID FROM Orders WHERE orderID = "+orderID+
                ") and CardType.cardTypeID IN (SELECT cardTypeID FROM [Customer'sCard] WHERE cardID IN(SELECT cardID FROM Orders WHERE orderID = "+orderID+"))";
                ResultSet rs = st.executeQuery(query);
                printResults(rs);
            }
            System.out.println("Disconnected.");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void printResults(ResultSet rs) throws SQLException {
        while (rs.next()) {
                productName = rs.getString("productName");
                price = rs.getInt("price");
                quantity = rs.getInt("quantity");
                discount = rs.getInt("discount");
                total = price*quantity*(100-discount)/100;
                customerName = rs.getString("customerName");
                street = rs.getString("street");
                city = rs.getString("city");
                state = rs.getString("state");
                zip = rs.getInt("zip");
                String cardNo = rs.getString("cardNo");
                String cardType = rs.getString("cardType");
                System.out.println("******************************");
                System.out.println("Product name: " + productName);
                System.out.println("Price: " + price);
                System.out.println("Quantity: " + quantity);
                System.out.println("Discount: " + discount);
                System.out.println("Total: " + total);
                System.out.println("Customer Name: " + customerName);
                System.out.println("Street: " + street);
                System.out.println("City: " + city);
                System.out.println("State: "+ state);
                System.out.println("Zip: " + zip);
                System.out.println("CardNo: " + cardNo);
                System.out.println("Card type: " + cardType);
                System.out.println("******************************");
        }
   }

}
