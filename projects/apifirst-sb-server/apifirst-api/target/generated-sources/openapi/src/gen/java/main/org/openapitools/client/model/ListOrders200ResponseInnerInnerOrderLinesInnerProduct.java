/*
 * API first course on Udemy
 * # Introduction API first course on Udemy 
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: rsouza01@gmail.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * ListOrders200ResponseInnerInnerOrderLinesInnerProduct
 */
@JsonPropertyOrder({
  ListOrders200ResponseInnerInnerOrderLinesInnerProduct.JSON_PROPERTY_ID,
  ListOrders200ResponseInnerInnerOrderLinesInnerProduct.JSON_PROPERTY_DESCRIPTION,
  ListOrders200ResponseInnerInnerOrderLinesInnerProduct.JSON_PROPERTY_PRICE
})
@JsonTypeName("listOrders_200_response_inner_inner_orderLines_inner_product")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-09-13T20:31:19.509005654Z[Etc/UTC]")
public class ListOrders200ResponseInnerInnerOrderLinesInnerProduct {
  public static final String JSON_PROPERTY_ID = "id";
  private UUID id;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  public static final String JSON_PROPERTY_PRICE = "price";
  private String price;

  public ListOrders200ResponseInnerInnerOrderLinesInnerProduct() {
  }

  public ListOrders200ResponseInnerInnerOrderLinesInnerProduct id(UUID id) {
    
    this.id = id;
    return this;
  }

   /**
   * The unique identifier of the product
   * @return id
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public UUID getId() {
    return id;
  }


  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setId(UUID id) {
    this.id = id;
  }


  public ListOrders200ResponseInnerInnerOrderLinesInnerProduct description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * The description of the product
   * @return description
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDescription() {
    return description;
  }


  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDescription(String description) {
    this.description = description;
  }


  public ListOrders200ResponseInnerInnerOrderLinesInnerProduct price(String price) {
    
    this.price = price;
    return this;
  }

   /**
   * Get price
   * @return price
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PRICE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPrice() {
    return price;
  }


  @JsonProperty(JSON_PROPERTY_PRICE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPrice(String price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListOrders200ResponseInnerInnerOrderLinesInnerProduct listOrders200ResponseInnerInnerOrderLinesInnerProduct = (ListOrders200ResponseInnerInnerOrderLinesInnerProduct) o;
    return Objects.equals(this.id, listOrders200ResponseInnerInnerOrderLinesInnerProduct.id) &&
        Objects.equals(this.description, listOrders200ResponseInnerInnerOrderLinesInnerProduct.description) &&
        Objects.equals(this.price, listOrders200ResponseInnerInnerOrderLinesInnerProduct.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, description, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListOrders200ResponseInnerInnerOrderLinesInnerProduct {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

