

# CreateCustomer400Response

The Problem Details JSON Object [[RFC7807](https://tools.ietf.org/html/rfc7807)].

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | **URI** | A URI reference [[RFC3986](https://tools.ietf.org/html/rfc3986)] that identifies the problem type. It should provide human-readable documentation for the problem type. When this member is not present, its value is assumed to be \&quot;about:blank\&quot;. |  [optional] |
|**title** | **String** | A short, human-readable summary of the problem type. It SHOULD NOT change from occurrence to occurrence of the problem, except for purposes of localization. |  [optional] |
|**status** | **Integer** | The HTTP status code. |  [optional] |
|**detail** | **String** | A human-readable explanation specific to this occurrence of the problem. |  [optional] |
|**instance** | **String** | A URI reference that identifies the specific occurrence of the problem.  It may or may not yield further information if dereferenced. |  [optional] |



