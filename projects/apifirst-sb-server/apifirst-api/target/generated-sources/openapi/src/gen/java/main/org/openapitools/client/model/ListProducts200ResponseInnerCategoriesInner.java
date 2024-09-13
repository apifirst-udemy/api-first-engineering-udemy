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
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.UUID;

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
 * ListProducts200ResponseInnerCategoriesInner
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-09-13T16:50:15.728540814Z[Etc/UTC]", comments = "Generator version: 7.8.0")
public class ListProducts200ResponseInnerCategoriesInner {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private UUID id;

  public static final String SERIALIZED_NAME_CATEGORY = "category";
  @SerializedName(SERIALIZED_NAME_CATEGORY)
  private String category;

  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public static final String SERIALIZED_NAME_DATE_CREATED = "dateCreated";
  @SerializedName(SERIALIZED_NAME_DATE_CREATED)
  private OffsetDateTime dateCreated;

  public static final String SERIALIZED_NAME_DATE_UPDATED = "dateUpdated";
  @SerializedName(SERIALIZED_NAME_DATE_UPDATED)
  private OffsetDateTime dateUpdated;

  public ListProducts200ResponseInnerCategoriesInner() {
  }

  public ListProducts200ResponseInnerCategoriesInner(
     UUID id, 
     OffsetDateTime dateCreated, 
     OffsetDateTime dateUpdated
  ) {
    this();
    this.id = id;
    this.dateCreated = dateCreated;
    this.dateUpdated = dateUpdated;
  }

  /**
   * The unique identifier of the category
   * @return id
   */
  @javax.annotation.Nullable
  public UUID getId() {
    return id;
  }



  public ListProducts200ResponseInnerCategoriesInner category(String category) {
    this.category = category;
    return this;
  }

  /**
   * The category of the product
   * @return category
   */
  @javax.annotation.Nonnull
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }


  public ListProducts200ResponseInnerCategoriesInner description(String description) {
    this.description = description;
    return this;
  }

  /**
   * The description of the category
   * @return description
   */
  @javax.annotation.Nonnull
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  /**
   * ISO 8601 Timestamp. Date Created and Date Updated are system managed values, should not be sent in request payloads - will be ignored.
   * @return dateCreated
   */
  @javax.annotation.Nullable
  public OffsetDateTime getDateCreated() {
    return dateCreated;
  }



  /**
   * ISO 8601 Timestamp. Date Created and Date Updated are system managed values, should not be sent in request payloads - will be ignored.
   * @return dateUpdated
   */
  @javax.annotation.Nullable
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
    ListProducts200ResponseInnerCategoriesInner listProducts200ResponseInnerCategoriesInner = (ListProducts200ResponseInnerCategoriesInner) o;
    return Objects.equals(this.id, listProducts200ResponseInnerCategoriesInner.id) &&
        Objects.equals(this.category, listProducts200ResponseInnerCategoriesInner.category) &&
        Objects.equals(this.description, listProducts200ResponseInnerCategoriesInner.description) &&
        Objects.equals(this.dateCreated, listProducts200ResponseInnerCategoriesInner.dateCreated) &&
        Objects.equals(this.dateUpdated, listProducts200ResponseInnerCategoriesInner.dateUpdated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, category, description, dateCreated, dateUpdated);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListProducts200ResponseInnerCategoriesInner {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("id");
    openapiFields.add("category");
    openapiFields.add("description");
    openapiFields.add("dateCreated");
    openapiFields.add("dateUpdated");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("category");
    openapiRequiredFields.add("description");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to ListProducts200ResponseInnerCategoriesInner
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!ListProducts200ResponseInnerCategoriesInner.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ListProducts200ResponseInnerCategoriesInner is not found in the empty JSON string", ListProducts200ResponseInnerCategoriesInner.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!ListProducts200ResponseInnerCategoriesInner.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ListProducts200ResponseInnerCategoriesInner` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : ListProducts200ResponseInnerCategoriesInner.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("id") != null && !jsonObj.get("id").isJsonNull()) && !jsonObj.get("id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
      }
      if (!jsonObj.get("category").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `category` to be a primitive type in the JSON string but got `%s`", jsonObj.get("category").toString()));
      }
      if (!jsonObj.get("description").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `description` to be a primitive type in the JSON string but got `%s`", jsonObj.get("description").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ListProducts200ResponseInnerCategoriesInner.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ListProducts200ResponseInnerCategoriesInner' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ListProducts200ResponseInnerCategoriesInner> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ListProducts200ResponseInnerCategoriesInner.class));

       return (TypeAdapter<T>) new TypeAdapter<ListProducts200ResponseInnerCategoriesInner>() {
           @Override
           public void write(JsonWriter out, ListProducts200ResponseInnerCategoriesInner value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ListProducts200ResponseInnerCategoriesInner read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of ListProducts200ResponseInnerCategoriesInner given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of ListProducts200ResponseInnerCategoriesInner
   * @throws IOException if the JSON string is invalid with respect to ListProducts200ResponseInnerCategoriesInner
   */
  public static ListProducts200ResponseInnerCategoriesInner fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ListProducts200ResponseInnerCategoriesInner.class);
  }

  /**
   * Convert an instance of ListProducts200ResponseInnerCategoriesInner to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

