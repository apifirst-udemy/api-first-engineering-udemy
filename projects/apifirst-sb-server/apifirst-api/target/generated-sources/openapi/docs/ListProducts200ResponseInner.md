

# ListProducts200ResponseInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **UUID** | The unique identifier of the product |  [optional] [readonly] |
|**description** | **String** | The description of the product |  |
|**dimentions** | [**ListProducts200ResponseInnerDimentions**](ListProducts200ResponseInnerDimentions.md) |  |  [optional] |
|**categories** | [**List&lt;ListProducts200ResponseInnerCategoriesInner&gt;**](ListProducts200ResponseInnerCategoriesInner.md) |  |  [optional] |
|**images** | [**List&lt;ListProducts200ResponseInnerImagesInner&gt;**](ListProducts200ResponseInnerImagesInner.md) |  |  [optional] |
|**price** | **String** |  |  |
|**cost** | **String** |  |  [optional] |
|**dateCreated** | **OffsetDateTime** | ISO 8601 Timestamp. Date Created and Date Updated are system managed values, should not be sent in request payloads - will be ignored. |  [optional] [readonly] |
|**dateUpdated** | **OffsetDateTime** | ISO 8601 Timestamp. Date Created and Date Updated are system managed values, should not be sent in request payloads - will be ignored. |  [optional] [readonly] |



