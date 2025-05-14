The Python AWS DBESDK for DynamoDB has the following encrypted interfaces for boto3 clients:
* `EncryptedClient`
    * TestVectors test through `client/`
* `EncryptedPaginator`
    * Can't write items; will not test via TestVectors
* `EncryptedResource`
    * TestVectors test through `resource/`
* `EncryptedTable`
    * TestVectors test through `table/`
* `EncryptedTablesManager`
    * Can't write items by itself; provides EncryptedTables which are tested via `table/`

The Python AWS DBESDK for DynamoDB's `ItemEncryptor` interface provides the following APIs:
* encrypt_python_item / decrypt_python_item
  * Standard dictionary JSON; e.g. `{"key": "value"}`
  * Tested explicitly via `test/resource/` and `test/table` calling `CreateWrappedDictItemEncryptor` and calling its operations
* encrypt_dynamodb_item / decrypt_dynamodb_item
  * DynamoDB JSON; e.g. `{"key": {"S": "value"}}`
  * Tested implicitly via `test/resource/` and `test/table` calling `CreateWrappedDictItemEncryptor`. Calls to the dict-formatted APIs pass through the DynamoDB-formatted APIs.
* encrypt_item / decrypt_item
  * DBESDK EncryptItemInput; e.g. `EncryptItemInput({"key": {"S": "value"}})`
  * Tested explicitly via `test/client/` calling `CreateWrappedDynamoDbItemEncryptor`
