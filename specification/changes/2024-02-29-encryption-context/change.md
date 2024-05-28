[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# Richer Encryption Context

## Summary

A new "version 2" record format will be introduced, to provide a better encryption context experience.

In version 1 records, the values in the encryption context are somewhat obfuscated, e.g. `AAFrZXk=` instead of `key`,
which makes it difficult to use in a KMS Key Policy, and difficult for humans to inspect.
In a version 2 record, if the corresponding attribute value is a string,
then the encryption context value for that attribute will be exactly that same string.

In version 1 records, the only field values stored in the encryption context are
the table's primary partition and sort keys.
As the encryption context is the only input to the Branch Key Selector,
this limits the Branch Key Selector to only those two fields.
In a version 2 record, a customer can designate additional fields to be included
in the encryption context,
and therefore available to the Branch Key Selector.

## Customer Facing Changes

### New Crypto Action

A fourth Crypto Action will be made available : `SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT`, to join the existing `DO_NOTHING`, `SIGN_ONLY` and `ENCRYPT_AND_SIGN`.

The presence of any SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT attribute in the configuration
will cause a version 2 record to be written.

If any SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT attribute is configured,
then the primary partition and sort keys must also be SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT.

And like the primary partition and sort keys, an attribute configured as SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
is required in any item to be encrypted.

If any SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT attribute is configured,

- All SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT attributes will be included in the encryption context
- All SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT attributes will be available to the Branch Key Selector
- The values of the attributes in the encryption context will be more human readable. Specifically :

| Type          | attribute value | encryption context value                               |
| ------------- | --------------- | ------------------------------------------------------ |
| String        | "abc"           | "abc"                                                  |
| Number        | "123"           | "123"                                                  |
| Null          |                 | "null"                                                 |
| Boolean       | true            | "true"                                                 |
| Boolean       | false           | "false"                                                |
| Anything else | n/a             | the version 1 value, looking something like "AAFrZXk=" |

Note that the values presented to the Branch Key Selector were always, and still are, DynamoDB AttributeValues.
The changes in encryption context values refer only to the raw encryption context.

An additional item, "aws-crypto-legend", will also be included in the encryption context,
providing the types of the attributes in the encryption context.
This is necessary to distinguish the number "123" from the string "123";
the string "false" from the boolean value false; and similar things.
This allows the Branch Key Supplier to determine the correct AttributeValues,
based solely on the encryption context -- since no configuration or version numbers are available to it.

### Parsed Header

For both record versions, the Parsed Header returned from Structured Encryption operations now
contains an additional field : the full encryption context.

Similarly, the Parsed Header returned from Item Encryptor operations now
contains two additional fields : the full encryption context,
and the value map that would be passed to the Branch Key Selector.

## Implementation Changes

For version 1 records, only the Item Encryptor operations know which attributes should
be in the encryption context,
The logical table name, plus the names and values of the primary hash and sort keys,
and so the full encryption context,
along with the associated RequiredEncryptionContextCMM,
is constructed at the Item Encryptor level and passed through to the Structured Encryption.
This remains unchanged.

For version 2 records, some things are known only to the Item Encryptor level,
and other things only to the Structured Encryption.
Thus the Item Encryptor constructs a slightly smaller encryption context,
The logical table name, plus just the names of the primary hash and sort keys,
and an associated RequiredEncryptionContextCMM.
Then Structured Encryption adds all of the appropriate values to the encryption context,
which includes at least the primary hash and sort keys, possibly others,
and wraps the RequiredEncryptionContextCMM passed in from the Item Encryptor in
another layer of RequiredEncryptionContextCMM to include those value.

# Java Enhanced Client

To use this new functionality with the DynamoDB Enhanced Client in Java,
tag your attribute with `@DynamoDbEncryptionSignAndIncludeInEncryptionContext`

## Single Table Design

To better handle [Single-Table Design](https://aws.amazon.com/blogs/compute/creating-a-single-table-design-with-amazon-dynamodb/),
one can now specify multiple schemas when building a DynamoDbEnhancedTableEncryptionConfig
as shown below.

```java
TableSchema<SimpleClass> tableSchema1 = TableSchema.fromBean(Class1.class);
TableSchema<SimpleClass2> tableSchema2 = TableSchema.fromBean(Class2.class);
TableSchema<SimpleClass3> tableSchema3 = TableSchema.fromBean(Class3.class);

DynamoDbEnhancedTableEncryptionConfig.builder()
  .logicalTableName(MyTableName)
  .schemaOnEncrypt(tableSchema1)
  .schemaOnEncrypt(tableSchema2)
  .schemaOnEncrypt(tableSchema3)
  ...
  .build());

DynamoDbTable<Class1> table1 = enhancedClient.table(MyTableName, tableSchema1);
DynamoDbTable<Class2> table2 = enhancedClient.table(MyTableName, tableSchema2);
DynamoDbTable<Class3> table3 = enhancedClient.table(MyTableName, tableSchema3);

TransactWriteItemsEnhancedRequest.builder()
  .addPutItem(table1, item1)
  .addPutItem(table2, item2)
  .addPutItem(table3, item3)
  .build();
```
