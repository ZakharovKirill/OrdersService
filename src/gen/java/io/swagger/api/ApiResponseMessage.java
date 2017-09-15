package io.swagger.api;

import io.swagger.api.impl.OrderOperation;
import javax.xml.bind.annotation.XmlTransient;

@javax.xml.bind.annotation.XmlRootElement
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-09-06T07:33:29.605Z")
public class ApiResponseMessage {
    public static final int ERROR = 1;
    public static final int WARNING = 2;
    public static final int INFO = 3;
    public static final int OK = 4;
    public static final int TOO_BUSY = 5;
    int code;
    String type, productName, customerName, street, city, state, cardNo, card, cardType;
    int zip, quantity, discount, price, total;
    
    public ApiResponseMessage(){}

    public ApiResponseMessage(int code){
        switch(code){
        case ERROR:
            setType("error");
            break;
        case WARNING:
            setType("warning");
            break;
        case INFO:
            setType("info");
            break;
        case OK:
            setType("OK");
            this.productName = OrderOperation.productName;
            this.price = OrderOperation.price;
            this.quantity = OrderOperation.quantity;
            this.discount = OrderOperation.discount;
            this.total = OrderOperation.total;
            this.customerName = OrderOperation.customerName;
            this.street = OrderOperation.street;
            this.city = OrderOperation.city;
            this.state = OrderOperation.state;
            this.cardNo = OrderOperation.cardNo;
            this.cardType = OrderOperation.card;
            break;
        case TOO_BUSY:
            setType("too busy");
            break;
        default:
            setType("unknown");
            break;
        }
    }

    @XmlTransient
    
    
    public int getDiscount(){
        return discount;
    }
    
    public void setDiscount(int discount){
        this.discount = OrderOperation.discount;
    }
    
    public int getZip(){
        return zip;
    }
    
    public void setZip(int zip){
        this.zip = OrderOperation.zip;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public void setQuantity(int quantity){
        this.quantity = OrderOperation.quantity;
    }
    
    public int getPrice(){
        return price;
    }
    
    public void setPrice(int price){
        this.price = OrderOperation.price;
    }
    
    public int getTotal(){
        return total;
    }
    
    public void setTotal(int total){
        this.total = OrderOperation.total;
    }
    
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public String getProductName(){
        return productName;
    }
    
    public void setProductName(String productName){
        this.productName = OrderOperation.productName;
    }

    public String getCardNo(){
        return cardNo;
    }
    
    public void setCardNo(String cardNo){
        this.cardNo = OrderOperation.cardNo;
    }
    
    public String getCustomerName(){
        return customerName;
    }
    
    public void setCustomerName(String customerName){
        this.customerName = OrderOperation.customerName;
    }
    
    public String getStreet(){
        return street;
    }
    
    public void setStreet(String street){
        this.street = OrderOperation.street;
    }
    
    public String getCity(){
        return city;
    }
    
    public void setCity(String city){
        this.city = OrderOperation.city;
    }
    
    public String getState(){
        return state;
    }
    
    public void setState(String state){
        this.state = OrderOperation.state;
    }
    
    public String getCardType(){
        return card;
    }
    
    public void setCard(String cardType){
        this.cardType = OrderOperation.card;
    }
}
