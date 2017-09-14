package io.swagger.api.impl;

import io.swagger.model.OrderRequest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class OrderOperation {
    static public Connection con;
    static public int zip, quantity, id, discount, productID, cardID, customerID, cardTypeID, price, total, checkID;
    static public String customerName, street, city, state, product, queryProductID, queryCustomer, queryCardType, cardNo, card, productName, checkOrder;
    static String url = "jdbc:sqlserver://localhost:1443;databaseName=OrdersBase";
    static String name = "sa";
    static String password = "Admin123";
    
    public static void PostOrder(OrderRequest body) {
        try {
            con = DriverManager.getConnection(url, name, password);
            System.out.println("Connected.");
            Statement st = con.createStatement();
            quantity = body.quantity;
            discount = body.discount;
            customerName = body.customerName;
            street = body.street;
            city = body.city;
            state = body.state;
            zip = body.zip;
            cardNo = body.cardNo;
            product  = body.product.name();
            card = body.card.name();

            queryProductID = "SELECT * FROM Product WHERE productName = '"+product+"'";
            ResultSet rsProduct = st.executeQuery(queryProductID);
            productID = getID(rsProduct, "product");

            queryCardType = "SELECT * FROM CardType WHERE cardType = '"+card+"'";
            ResultSet rsCardTypeID = st.executeQuery(queryCardType);
            cardTypeID = getID(rsCardTypeID, "cardType");

            queryCustomer = "SELECT * FROM CustomerBase WHERE customerName = '"+customerName+"' and street = '"+street+"'";
            ResultSet rsCustomerID = st.executeQuery(queryCustomer);
            customerID = getID(rsCustomerID, "customer");
            if (customerID == -1){
                String queryNewCustomer = "INSERT INTO CustomerBase VALUES( '"+customerName+"', '"+street+"', '"+city+"', '"+state+"', '"+zip+"')";
                st.executeUpdate(queryNewCustomer);
                ResultSet rsCustomer = st.executeQuery(queryCustomer);
                customerID = getID(rsCustomer, "customer");
            } 
            cardID = getCardID(st);
            if (cardID==-1){
                String queryNewCard = "INSERT INTO [Customer'sCard] VALUES("+customerID+", "+cardTypeID+", '"+cardNo+"', '12-12-2020')";
                st.executeUpdate(queryNewCard);
                cardID = getCardID(st);
            }
            String queryNewOrder = "INSERT INTO Orders VALUES("+productID+", "+quantity+", "+discount+", '12-31-2014', "+customerID+", "+cardID+")";
            st.executeUpdate(queryNewOrder);  
            System.out.println("productID:"+productID);
            System.out.println("Disconnected.");
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            }
        }
    
    public static void UpdateOderID(Long orderID, OrderRequest body){
        try{
            con = DriverManager.getConnection(url, name, password);
            System.out.println("Connected.");
            Statement st = con.createStatement();
            checkOrder = "SELECT * FROM Orders WHERE orderID = "+orderID;
            ResultSet rsCheckOrder = st.executeQuery(checkOrder);
            checkID = getID(rsCheckOrder, "order");
            if (checkID != -1) {
                queryProductID = "SELECT * FROM Product WHERE productName = '"+product+"'";
                ResultSet rsProduct = st.executeQuery(queryProductID);
                productID = getID(rsProduct, "product");
                
                String queryUpdateOrder = "UPDATE Orders SET productID";
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void GetOrdersBase(boolean querystatus, Long orderID) {
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
    
    public static void DeleteOrder(Long orderID) {
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
    
    public static void printResults(ResultSet rs) throws SQLException {
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
    
    public static int getCardID(Statement st){
        try{
        String queryGetCardID = "SELECT * FROM [Customer'sCard] WHERE customerID = "+customerID+"and cardNo = '"+cardNo+"'";
        ResultSet rsCardID = st.executeQuery(queryGetCardID);
        return cardID = getID(rsCardID, "card");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cardID;
    }
            
    public static int getID(ResultSet rs, String name) throws SQLException {
        if (rs.next()){
            id = rs.getInt(name+"ID");
            return id;
        } else{
            return id = -1;
        }
    }
}