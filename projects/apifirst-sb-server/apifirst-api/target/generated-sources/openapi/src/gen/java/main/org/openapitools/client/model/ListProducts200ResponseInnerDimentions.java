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
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openapitools.client.JSON;

/**
 * The dimentions of the product
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-09-13T16:50:15.728540814Z[Etc/UTC]", comments = "Generator version: 7.8.0")
public class ListProducts200ResponseInnerDimentions {
  public static final String SERIALIZED_NAME_LENGTH = "length";
  @SerializedName(SERIALIZED_NAME_LENGTH)
  private BigDecimal length;

  public static final String SERIALIZED_NAME_WIDTH = "width";
  @SerializedName(SERIALIZED_NAME_WIDTH)
  private BigDecimal width;

  public static final String SERIALIZED_NAME_HEIGHT = "height";
  @SerializedName(SERIALIZED_NAME_HEIGHT)
  private BigDecimal height;

  public ListProducts200ResponseInnerDimentions() {
  }

  public ListProducts200ResponseInnerDimentions length(BigDecimal length) {
    this.length = length;
    return this;
  }

  /**
   * The length of the product
   * minimum: 1
   * maximum: 999
   * @return length
   */
  @javax.annotation.Nonnull
  public BigDecimal getLength() {
    return length;
  }

  public void setLength(BigDecimal length) {
    this.length = length;
  }


  public ListProducts200ResponseInnerDimentions width(BigDecimal width) {
    this.width = width;
    return this;
  }

  /**
   * The width of the product
   * minimum: 1
   * maximum: 999
   * @return width
   */
  @javax.annotation.Nonnull
  public BigDecimal getWidth() {
    return width;
  }

  public void setWidth(BigDecimal width) {
    this.width = width;
  }


  public ListProducts200ResponseInnerDimentions height(BigDecimal height) {
    this.height = height;
    return this;
  }

  /**
   * The height of the product
   * minimum: 1
   * maximum: 999
   * @return height
   */
  @javax.annotation.Nonnull
  public BigDecimal getHeight() {
    return height;
  }

  public void setHeight(BigDecimal height) {
    this.height = height;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListProducts200ResponseInnerDimentions listProducts200ResponseInnerDimentions = (ListProducts200ResponseInnerDimentions) o;
    return Objects.equals(this.length, listProducts200ResponseInnerDimentions.length) &&
        Objects.equals(this.width, listProducts200ResponseInnerDimentions.width) &&
        Objects.equals(this.height, listProducts200ResponseInnerDimentions.height);
  }

  @Override
  public int hashCode() {
    return Objects.hash(length, width, height);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListProducts200ResponseInnerDimentions {\n");
    sb.append("    length: ").append(toIndentedString(length)).append("\n");
    sb.append("    width: ").append(toIndentedString(width)).append("\n");
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
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


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("length");
    openapiFields.add("width");
    openapiFields.add("height");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("length");
    openapiRequiredFields.add("width");
    openapiRequiredFields.add("height");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to ListProducts200ResponseInnerDimentions
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!ListProducts200ResponseInnerDimentions.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ListProducts200ResponseInnerDimentions is not found in the empty JSON string", ListProducts200ResponseInnerDimentions.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!ListProducts200ResponseInnerDimentions.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ListProducts200ResponseInnerDimentions` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : ListProducts200ResponseInnerDimentions.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ListProducts200ResponseInnerDimentions.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ListProducts200ResponseInnerDimentions' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ListProducts200ResponseInnerDimentions> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ListProducts200ResponseInnerDimentions.class));

       return (TypeAdapter<T>) new TypeAdapter<ListProducts200ResponseInnerDimentions>() {
           @Override
           public void write(JsonWriter out, ListProducts200ResponseInnerDimentions value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ListProducts200ResponseInnerDimentions read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of ListProducts200ResponseInnerDimentions given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of ListProducts200ResponseInnerDimentions
   * @throws IOException if the JSON string is invalid with respect to ListProducts200ResponseInnerDimentions
   */
  public static ListProducts200ResponseInnerDimentions fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ListProducts200ResponseInnerDimentions.class);
  }

  /**
   * Convert an instance of ListProducts200ResponseInnerDimentions to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

