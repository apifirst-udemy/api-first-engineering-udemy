

# ListOrders200ResponseInnerInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **UUID** | The unique identifier of the order |  [optional] [readonly] |
|**customer** | [**ListOrders200ResponseInnerInnerCustomer**](ListOrders200ResponseInnerInnerCustomer.md) |  |  |
|**orderStatus** | [**OrderStatusEnum**](#OrderStatusEnum) |  |  |
|**shipmentInfo** | **String** |  |  [optional] |
|**orderLines** | [**List&lt;ListOrders200ResponseInnerInnerOrderLinesInner&gt;**](ListOrders200ResponseInnerInnerOrderLinesInner.md) | The order lines of the order |  |
|**dateCreated** | **OffsetDateTime** | ISO 8601 Timestamp. Date Created and Date Updated are system managed values, should not be sent in request payloads - will be ignored. |  [optional] [readonly] |
|**dateUpdated** | **OffsetDateTime** | ISO 8601 Timestamp. Date Created and Date Updated are system managed values, should not be sent in request payloads - will be ignored. |  [optional] [readonly] |



## Enum: OrderStatusEnum

| Name | Value |
|---- | -----|
| NEW | &quot;NEW&quot; |
| HOLD | &quot;HOLD&quot; |
| SHIPPED | &quot;SHIPPED&quot; |
| DELIVERED | &quot;DELIVERED&quot; |
| CLOSED | &quot;CLOSED&quot; |



