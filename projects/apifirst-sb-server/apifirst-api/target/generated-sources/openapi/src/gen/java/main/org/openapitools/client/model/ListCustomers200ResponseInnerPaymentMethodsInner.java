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
import java.time.OffsetDateTime;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * ListCustomers200ResponseInnerPaymentMethodsInner
 */
@JsonPropertyOrder({
  ListCustomers200ResponseInnerPaymentMethodsInner.JSON_PROPERTY_ID,
  ListCustomers200ResponseInnerPaymentMethodsInner.JSON_PROPERTY_DISPLAY_NAME,
  ListCustomers200ResponseInnerPaymentMethodsInner.JSON_PROPERTY_CARD_NUMBER,
  ListCustomers200ResponseInnerPaymentMethodsInner.JSON_PROPERTY_EXPIRY_MONTH,
  ListCustomers200ResponseInnerPaymentMethodsInner.JSON_PROPERTY_EXPIRY_YEAR,
  ListCustomers200ResponseInnerPaymentMethodsInner.JSON_PROPERTY_CVV,
  ListCustomers200ResponseInnerPaymentMethodsInner.JSON_PROPERTY_DATE_CREATED,
  ListCustomers200ResponseInnerPaymentMethodsInner.JSON_PROPERTY_DATE_UPDATED
})
@JsonTypeName("listCustomers_200_response_inner_paymentMethods_inner")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-09-13T20:31:19.509005654Z[Etc/UTC]")
public class ListCustomers200ResponseInnerPaymentMethodsInner {
  public static final String JSON_PROPERTY_ID = "id";
  private UUID id;

  public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
  private String displayName;

  public static final String JSON_PROPERTY_CARD_NUMBER = "cardNumber";
  private Integer cardNumber;

  public static final String JSON_PROPERTY_EXPIRY_MONTH = "expiryMonth";
  private Integer expiryMonth;

  public static final String JSON_PROPERTY_EXPIRY_YEAR = "expiryYear";
  private Integer expiryYear;

  public static final String JSON_PROPERTY_CVV = "cvv";
  private Integer cvv;

  public static final String JSON_PROPERTY_DATE_CREATED = "dateCreated";
  private OffsetDateTime dateCreated;

  public static final String JSON_PROPERTY_DATE_UPDATED = "dateUpdated";
  private OffsetDateTime dateUpdated;

  public ListCustomers200ResponseInnerPaymentMethodsInner() {
  }

  @JsonCreator
  public ListCustomers200ResponseInnerPaymentMethodsInner(
    @JsonProperty(JSON_PROPERTY_ID) UUID id, 
    @JsonProperty(JSON_PROPERTY_DATE_CREATED) OffsetDateTime dateCreated, 
    @JsonProperty(JSON_PROPERTY_DATE_UPDATED) OffsetDateTime dateUpdated
  ) {
    this();
    this.id = id;
    this.dateCreated = dateCreated;
    this.dateUpdated = dateUpdated;
  }

   /**
   * Unique identifier representing a specific payment method.
   * @return id
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public UUID getId() {
    return id;
  }




  public ListCustomers200ResponseInnerPaymentMethodsInner displayName(String displayName) {
    
    this.displayName = displayName;
    return this;
  }

   /**
   * Get displayName
   * @return displayName
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getDisplayName() {
    return displayName;
  }


  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }


  public ListCustomers200ResponseInnerPaymentMethodsInner cardNumber(Integer cardNumber) {
    
    this.cardNumber = cardNumber;
    return this;
  }

   /**
   * Get cardNumber
   * @return cardNumber
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_CARD_NUMBER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getCardNumber() {
    return cardNumber;
  }


  @JsonProperty(JSON_PROPERTY_CARD_NUMBER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCardNumber(Integer cardNumber) {
    this.cardNumber = cardNumber;
  }


  public ListCustomers200ResponseInnerPaymentMethodsInner expiryMonth(Integer expiryMonth) {
    
    this.expiryMonth = expiryMonth;
    return this;
  }

   /**
   * Get expiryMonth
   * @return expiryMonth
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_EXPIRY_MONTH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getExpiryMonth() {
    return expiryMonth;
  }


  @JsonProperty(JSON_PROPERTY_EXPIRY_MONTH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setExpiryMonth(Integer expiryMonth) {
    this.expiryMonth = expiryMonth;
  }


  public ListCustomers200ResponseInnerPaymentMethodsInner expiryYear(Integer expiryYear) {
    
    this.expiryYear = expiryYear;
    return this;
  }

   /**
   * Get expiryYear
   * @return expiryYear
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_EXPIRY_YEAR)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getExpiryYear() {
    return expiryYear;
  }


  @JsonProperty(JSON_PROPERTY_EXPIRY_YEAR)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setExpiryYear(Integer expiryYear) {
    this.expiryYear = expiryYear;
  }


  public ListCustomers200ResponseInnerPaymentMethodsInner cvv(Integer cvv) {
    
    this.cvv = cvv;
    return this;
  }

   /**
   * Get cvv
   * @return cvv
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_CVV)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getCvv() {
    return cvv;
  }


  @JsonProperty(JSON_PROPERTY_CVV)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCvv(Integer cvv) {
    this.cvv = cvv;
  }


   /**
   * ISO 8601 Timestamp. Date Created and Date Updated are system managed values, should not be sent in request payloads - will be ignored.
   * @return dateCreated
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DATE_CREATED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getDateCreated() {
    return dateCreated;
  }




   /**
   * ISO 8601 Timestamp. Date Created and Date Updated are system managed values, should not be sent in request payloads - will be ignored.
   * @return dateUpdated
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DATE_UPDATED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getDateUpdated() {
    return dateUpdated;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListCustomers200ResponseInnerPaymentMethodsInner listCustomers200ResponseInnerPaymentMethodsInner = (ListCustomers200ResponseInnerPaymentMethodsInner) o;
    return Objects.equals(this.id, listCustomers200ResponseInnerPaymentMethodsInner.id) &&
        Objects.equals(this.displayName, listCustomers200ResponseInnerPaymentMethodsInner.displayName) &&
        Objects.equals(this.cardNumber, listCustomers200ResponseInnerPaymentMethodsInner.cardNumber) &&
        Objects.equals(this.expiryMonth, listCustomers200ResponseInnerPaymentMethodsInner.expiryMonth) &&
        Objects.equals(this.expiryYear, listCustomers200ResponseInnerPaymentMethodsInner.expiryYear) &&
        Objects.equals(this.cvv, listCustomers200ResponseInnerPaymentMethodsInner.cvv) &&
        Objects.equals(this.dateCreated, listCustomers200ResponseInnerPaymentMethodsInner.dateCreated) &&
        Objects.equals(this.dateUpdated, listCustomers200ResponseInnerPaymentMethodsInner.dateUpdated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, displayName, cardNumber, expiryMonth, expiryYear, cvv, dateCreated, dateUpdated);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListCustomers200ResponseInnerPaymentMethodsInner {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    cardNumber: ").append(toIndentedString(cardNumber)).append("\n");
    sb.append("    expiryMonth: ").append(toIndentedString(expiryMonth)).append("\n");
    sb.append("    expiryYear: ").append(toIndentedString(expiryYear)).append("\n");
    sb.append("    cvv: ").append(toIndentedString(cvv)).append("\n");
    sb.append("    dateCreated: ").append(toIndentedString(dateCreated)).append("\n");
    sb.append("    dateUpdated: ").append(toIndentedString(dateUpdated)).append("\n");
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

