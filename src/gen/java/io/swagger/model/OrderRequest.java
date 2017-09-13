/*
 * Swagger Oders
 * This is a sample server Orders server.  You can create,  read, update and delete orders 
 *
 * OpenAPI spec version: 1.0.0
 * Contact: apiteam@swagger.io
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * OrderRequest
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-09-06T07:33:29.605Z")
public class OrderRequest   {
  /**
   * Gets or Sets product
   */
  public enum ProductEnum {
    MYMONEY("My money"),
    
    FAMILYALBUM("Family album"),
    
    SCREENSAVER("Screensaver");

    public String value;

    ProductEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ProductEnum fromValue(String text) {
      for (ProductEnum b : ProductEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("product")
  public ProductEnum product = null;

  @JsonProperty("quantity")
  public Integer quantity = null;

  @JsonProperty("price")
  public Integer price = null;

  @JsonProperty("discount in %")
  public Integer discountIn_ = null;

  @JsonProperty("total")
  public Integer total = null;

  @JsonProperty("date")
  public Date date = null;

  @JsonProperty("customerName")
  public String customerName = null;

  @JsonProperty("street")
  public String street = null;

  @JsonProperty("city")
  public String city = null;

  @JsonProperty("state")
  public String state = null;

  @JsonProperty("zip")
  public Integer zip = null;

  /**
   * Gets or Sets card
   */
  public enum CardEnum {
    VISA("Visa"),
    
    MASTERCARD("MasterCard"),
    
    AMERICAN_EXPRESS("American Express");

    public String value;

    CardEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CardEnum fromValue(String text) {
      for (CardEnum b : CardEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("card")
  public CardEnum card = null;

  @JsonProperty("cardNo")
  public Integer cardNo = null;

  @JsonProperty("expirationDate")
  public Date expirationDate = null;

  public OrderRequest product(ProductEnum product) {
    this.product = product;
    return this;
  }

   /**
   * Get product
   * @return product
  **/
  @ApiModelProperty(value = "")
  public ProductEnum getProduct() {
    return product;
  }

  public void setProduct(ProductEnum product) {
    this.product = product;
  }

  public OrderRequest quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

   /**
   * Get quantity
   * @return quantity
  **/
  @ApiModelProperty(value = "")
  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public OrderRequest price(Integer price) {
    this.price = price;
    return this;
  }

   /**
   * Get price
   * @return price
  **/
  @ApiModelProperty(value = "")
  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public OrderRequest discountIn_(Integer discountIn_) {
    this.discountIn_ = discountIn_;
    return this;
  }

   /**
   * Get discountIn_
   * @return discountIn_
  **/
  @ApiModelProperty(value = "")
  public Integer getDiscountIn_() {
    return discountIn_;
  }

  public void setDiscountIn_(Integer discountIn_) {
    this.discountIn_ = discountIn_;
  }

  public OrderRequest total(Integer total) {
    this.total = total;
    return this;
  }

   /**
   * Get total
   * @return total
  **/
  @ApiModelProperty(value = "")
  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public OrderRequest date(Date date) {
    this.date = date;
    return this;
  }

   /**
   * Get date
   * @return date
  **/
  @ApiModelProperty(value = "")
  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public OrderRequest customerName(String customerName) {
    this.customerName = customerName;
    return this;
  }

   /**
   * Get customerName
   * @return customerName
  **/
  @ApiModelProperty(value = "")
  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public OrderRequest street(String street) {
    this.street = street;
    return this;
  }

   /**
   * Get street
   * @return street
  **/
  @ApiModelProperty(value = "")
  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public OrderRequest city(String city) {
    this.city = city;
    return this;
  }

   /**
   * Get city
   * @return city
  **/
  @ApiModelProperty(value = "")
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public OrderRequest state(String state) {
    this.state = state;
    return this;
  }

   /**
   * Get state
   * @return state
  **/
  @ApiModelProperty(value = "")
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public OrderRequest zip(Integer zip) {
    this.zip = zip;
    return this;
  }

   /**
   * Get zip
   * @return zip
  **/
  @ApiModelProperty(value = "")
  public Integer getZip() {
    return zip;
  }

  public void setZip(Integer zip) {
    this.zip = zip;
  }

  public OrderRequest card(CardEnum card) {
    this.card = card;
    return this;
  }

   /**
   * Get card
   * @return card
  **/
  @ApiModelProperty(value = "")
  public CardEnum getCard() {
    return card;
  }

  public void setCard(CardEnum card) {
    this.card = card;
  }

  public OrderRequest cardNo(Integer cardNo) {
    this.cardNo = cardNo;
    return this;
  }

   /**
   * Get cardNo
   * @return cardNo
  **/
  @ApiModelProperty(value = "")
  public Integer getCardNo() {
    return cardNo;
  }

  public void setCardNo(Integer cardNo) {
    this.cardNo = cardNo;
  }

  public OrderRequest expirationDate(Date expirationDate) {
    this.expirationDate = expirationDate;
    return this;
  }

   /**
   * Get expirationDate
   * @return expirationDate
  **/
  @ApiModelProperty(value = "")
  public Date getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(Date expirationDate) {
    this.expirationDate = expirationDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderRequest orderRequest = (OrderRequest) o;
    return Objects.equals(this.product, orderRequest.product) &&
        Objects.equals(this.quantity, orderRequest.quantity) &&
        Objects.equals(this.price, orderRequest.price) &&
        Objects.equals(this.discountIn_, orderRequest.discountIn_) &&
        Objects.equals(this.total, orderRequest.total) &&
        Objects.equals(this.date, orderRequest.date) &&
        Objects.equals(this.customerName, orderRequest.customerName) &&
        Objects.equals(this.street, orderRequest.street) &&
        Objects.equals(this.city, orderRequest.city) &&
        Objects.equals(this.state, orderRequest.state) &&
        Objects.equals(this.zip, orderRequest.zip) &&
        Objects.equals(this.card, orderRequest.card) &&
        Objects.equals(this.cardNo, orderRequest.cardNo) &&
        Objects.equals(this.expirationDate, orderRequest.expirationDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(product, quantity, price, discountIn_, total, date, customerName, street, city, state, zip, card, cardNo, expirationDate);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderRequest {\n");
    
    sb.append("    product: ").append(toIndentedString(product)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    discountIn_: ").append(toIndentedString(discountIn_)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    customerName: ").append(toIndentedString(customerName)).append("\n");
    sb.append("    street: ").append(toIndentedString(street)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    zip: ").append(toIndentedString(zip)).append("\n");
    sb.append("    card: ").append(toIndentedString(card)).append("\n");
    sb.append("    cardNo: ").append(toIndentedString(cardNo)).append("\n");
    sb.append("    expirationDate: ").append(toIndentedString(expirationDate)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

