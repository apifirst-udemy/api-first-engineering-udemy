

# ListOrders200ResponseInnerInnerOrderLinesInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **UUID** | The unique identifier of the order line |  [optional] [readonly] |
|**product** | [**ListOrders200ResponseInnerInnerOrderLinesInnerProduct**](ListOrders200ResponseInnerInnerOrderLinesInnerProduct.md) |  |  |
|**orderQuantity** | **Integer** | The quantity of the product in the order |  |
|**shipQuantity** | **Integer** | The quantity of the product shipped |  [optional] |
|**dateCreated** | **OffsetDateTime** | ISO 8601 Timestamp. Date Created and Date Updated are system managed values, should not be sent in request payloads - will be ignored. |  [optional] [readonly] |
|**dateUpdated** | **OffsetDateTime** | ISO 8601 Timestamp. Date Created and Date Updated are system managed values, should not be sent in request payloads - will be ignored. |  [optional] [readonly] |



