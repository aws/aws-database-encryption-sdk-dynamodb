st significant bit of each byte is first.

## Writing

Whenever a record is written, if the source field is written then the scan beacon field must also be written,
holding the Scan Beacon Hash of the unencrypted source field.

## Reading

To retrieve a record based on the value of an encrypted source field,
search instead for the scan beacon hash in the scan beacon field.

Note that only exact matches can be supported. No ranged queries or inequalities.

This may return false positive results.
After retrieving records in this way, you must decrypt the record and compare
the source field value to the query value, and discard any records where they don't match.

### DynamoDB Support
To make life easier, formulate requests that search the original attribute, and transform them into requests that search the new hash. 

 * CreateTableRequest 
 * UpdateTableRequest
 * PutItemRequest
 * BatchWriteItemRequest
 * TransactWriteItemsRequest
 * GetItemRequest
 * BatchGetItemRequest
 * TransactGetItemsRequest
 * QueryRequest
 * ScanRequest


Filter Results From
 * GetItemResponse
 * BatchGetItemResponse
 * TransactGetItemsResponse
 * QueryResponse
 * ScanResponse
