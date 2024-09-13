# OrderApi

All URIs are relative to *https://www/api/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**listOrders**](OrderApi.md#listOrders) | **GET** /v1/orders | List Orders |


<a id="listOrders"></a>
# **listOrders**
> List&lt;List&lt;ListOrders200ResponseInnerInner&gt;&gt; listOrders()

List Orders

List Orders endpoint via some parameter

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.OrderApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://www/api/v1");
    
    // Configure HTTP basic authorization: basic_auth
    HttpBasicAuth basic_auth = (HttpBasicAuth) defaultClient.getAuthentication("basic_auth");
    basic_auth.setUsername("YOUR USERNAME");
    basic_auth.setPassword("YOUR PASSWORD");

    OrderApi apiInstance = new OrderApi(defaultClient);
    try {
      List<List<ListOrders200ResponseInnerInner>> result = apiInstance.listOrders();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling OrderApi#listOrders");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;List&lt;ListOrders200ResponseInnerInner&gt;&gt;**](List.md)

### Authorization

[basic_auth](../README.md#basic_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | successful operation |  -  |
| **400** | Bad Request |  -  |
| **404** | Not Found |  -  |

