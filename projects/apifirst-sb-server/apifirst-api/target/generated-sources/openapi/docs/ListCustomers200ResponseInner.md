

# ListCustomers200ResponseInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **UUID** | Unique identifier representing a specific customer |  [optional] [readonly] |
|**name** | [**ListCustomers200ResponseInnerName**](ListCustomers200ResponseInnerName.md) |  |  |
|**shipToAddress** | [**ListCustomers200ResponseInnerShipToAddress**](ListCustomers200ResponseInnerShipToAddress.md) |  |  |
|**billToAddress** | [**ListCustomers200ResponseInnerShipToAddress**](ListCustomers200ResponseInnerShipToAddress.md) |  |  |
|**email** | **String** |  |  [optional] |
|**phone** | **String** |  |  [optional] |
|**paymentMethods** | [**List&lt;ListCustomers200ResponseInnerPaymentMethodsInner&gt;**](ListCustomers200ResponseInnerPaymentMethodsInner.md) |  |  [optional] |
|**dateCreated** | **OffsetDateTime** | ISO 8601 Timestamp. Date Created and Date Updated are system managed values, should not be sent in request payloads - will be ignored. |  [optional] [readonly] |
|**dateUpdated** | **OffsetDateTime** | ISO 8601 Timestamp. Date Created and Date Updated are system managed values, should not be sent in request payloads - will be ignored. |  [optional] [readonly] |



