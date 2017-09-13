package io.swagger.api.impl;

import io.swagger.model.OrderRequest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class PostOrder {
    private Connection con;
    private int customerID, zip, quantity, productID;
    private String customerName, street, city, state, product, queryProductID, queryCustomer;
    
    public PostOrder(OrderRequest body) {
        String url = "jdbc:sqlserver://localhost:1443;databaseName=OrdersBase";
        String name = "sa";
        String password = "Admin123";
        try {
            con = DriverManager.getConnection(url, name, password);
            System.out.println("Connected.");
            Statement st = con.createStatement();
            quantity = body.quantity;
            customerName = body.customerName;
            street = body.street;
            city = body.city;
            state = body.state;
            zip = body.zip;
//            ProductResult(body);
            //       String cardNo = body.cardNo;
            product  = body.product.name();
            queryProductID = "SELECT * FROM Product WHERE productName = '"+product+"'";
            ResultSet rs = st.executeQuery(queryProductID);
            productID = QueryResults(rs);
            queryCustomer = "SELECT * FROM CustomerBase WHERE customerName = '"+body.customerName+"' and street = '"+body.street+"'";
            try {
                ResultSet resultCustomer = st.executeQuery(queryCustomer);
                while (resultCustomer.next()){
                    customerID = resultCustomer.getInt("customerID");
                }
            } catch(Error e){
                String newCustomer = "INSERT INTO CustomerBase VALUES("+body.customerName+", "+body.street+", "+body.city+", "+body.state+", "+body.zip+")";
                st.executeUpdate(newCustomer);
            }
            System.out.println("productID:"+productID);
            System.out.println("Disconnected.");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int QueryResults(ResultSet rs) throws SQLException {
        productID = -1;
        while (rs.next()){
            productID = rs.getInt("productID");
            return productID;
        }
        return productID;
    }
}