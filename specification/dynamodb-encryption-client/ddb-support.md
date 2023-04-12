# DynamoDB Support Layer

The DynamoDB Support Layer provides everything necessary to the middleware interceptors,
with the exception of encryption and decryption.

This document specifies the interface and high level semantics of these entry points.

[DynamoDB SDK Integration](ddb-sdk-integration.md) should be specified in terms of
these operations.

There are two categories of support functions.

The first category is for general support, used across multiple DynamoDB API transformations.

 * [Writable](#writable) - are the attributes in this item ok to write
 * [TestConditionExpression](#testconditionexpression) - Is this condition expression suitable for use
 * [TestUpdateExpression](#testupdateexpression) - Is this update expression suitable for use
 * [AddNonSensitiveBeacons](#addnonsensitivebeacons) - Add non sensitive attributes to an item to enable searchable encryption
 * [AddSensitiveBeacons](#addsensitivebeacons) - Add attributes to an item to enable searchable encryption
 * [RemoveBeacons](#removebeacons) - Remove all private attributes from an item,
 e.g. the ones added in [AddNonSensitiveBeacons](#addnonsensitivebeacons) and [AddSensitiveBeacons](#addsensitivebeacons)

The second category is support for specific interceptors, where the whole input or output structure is modified.
 * [CreateTableInputForBeacons](#createtableinputforbeacons)
 * [UpdateTableInputForBeacons](#updatetableinputforbeacons)
 * [DescribeTableOutputForBeacons](#describetableoutputforbeacons)
 * [QueryInputForBeacons](#queryinputforbeacons)
 * [QueryOutputForBeacons](#queryoutputforbeacons)
 * [ScanInputForBeacons](#scaninputforbeacons)
 * [ScanOutputForBeacons](#scanoutputforbeacons)

## Writable

Writeable MUST reject any item containing an attribute which
* begins with `aws_dbe_`
* has the same name as a [virtual field](../searchable-encryption/virtual.md)
* has the same name as a [compound beacon](../searchable-encryption/beacons.md#compound-beacon)

## TestConditionExpression

TestConditionExpression MUST fail if any operand in the condition expression is an encrypted attribute name.

## TestUpdateExpression

TestUpdateExpression MUST fail if any operand in the update expression is a signed attribute name.

AddSensitiveBeacons

## AddNonSensitiveBeacons

AddNonSensitiveBeacons examines an AttributeMap and modifies it to be appropriate for Searchable Encryption,
returning a replacement AttributeMap.

The [Beacon Key Source](../searchable-encryption/search-config.md#beacon-key-source) for the configured table
MUST be used to obtain the correct beacon key information needed to add non sensitive beacons.

AddNonSensitiveBeacons MUST only operate on [compound beacons](../searchable-encryption/beacons.md#compound-beacon)
that do not have any [sensitive parts](../searchable-encryption/beacons.md#compound-beacon-initialization).

For every configured compound beacons which only contains non sensitive parts
that can be successfully built from the attributes in the input AttributeMap,
AddNonSensitiveBeacons MUST add an attribute named aws_dbe_b_NAME,
where NAME is the name of the beacon.
The value of this attribute MUST be a string,
and must have the value defined in [beacons](../searchable-encryption/beacons.md#beacon-value)

AddNonSensitiveBeacons MUST also add an attribute with name `aws_dbe_v_1` and whose value is a string containing a single space.

The result of AddNonSensitiveBeacons MUST contain, unaltered, everything in the input AttributeMap.

## AddSensitiveBeacons

AddSensitiveBeacons examines the [Encrypt Item Input](./encrypt-item.md#input) and [Encrypt Item Output](./encrypt-item.md#output).

The [Beacon Key Source](../searchable-encryption/search-config.md#beacon-key-source) for the configured table
MUST be used to obtain the correct beacon key information needed to add sensitive beacons.

The [Parsed Header](./encrypt-item.md#parsed-header)'s encrypted data keys MUST contain only one encrypted data key.
It's [Key Provider ID](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/structures.md#key-provider-id)
MUST equal the provider ID for the [AWS KMS Hierarchical Keyring](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/aws-kms/aws-kms-hierarchical-keyring.md#ondecrypt).

If Beacon Key Source configuration is [multi key store](../searchable-encryption/search-config.md#multi-key-store-initialization)
and an attribute exists with the name of the configured Key Field Name
then the [Key Provider Information](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/structures.md#key-provider-id)
MUST match this value and this value.

AddSensitiveBeacons examines [DynamoDB Item](./encrypt-item.md#dynamodb-item) AttributeMap
and modifies the [Encrypted DynamoDB Item](./encrypt-item.md#encrypted-dynamodb-item)
it to be appropriate for Searchable Encryption,
returning a replacement AttributeMap.

AddSensitiveBeacons MUST NOT operate on [compound beacons](../searchable-encryption/beacons.md#compound-beacon)
that only have [non-sensitive parts](../searchable-encryption/beacons.md#compound-beacon-initialization).

For every configured compound beacons which does not only contain non sensitive parts
that can be successfully built from the attributes in the input AttributeMap,
AddSensitiveBeacons MUST add an attribute named aws_dbe_b_NAME,
where NAME is the name of the beacon.
The value of this attribute MUST be a string,
and must have the value defined in [beacons](../searchable-encryption/beacons.md#beacon-value)

The result of AddSensitiveBeacons MUST contain, unaltered, everything in the input AttributeMap
unless the Beacon Key Source configuration
is [multi key store](../searchable-encryption/search-config.md#multi-key-store-initialization)
in which case the Key Field Name MUST be removed.

## RemoveBeacons

RemoveBeacons examines an AttributeMap and modifies it to be appropriate for customer use,
returning a replacement AttributeMap.

AddBeacons MUST remove any attributes whose name begins with `aws_dbe_`,
and leave all other attributes unchanged.

## CreateTableInputForBeacons

Transform a CreateTableInput object for searchable encryption.

If the KeySchema of the table, or the KeySchema of one of the associated
global or local indexes, have an AttributeName equal to the name of a configured beacon,
the AttributeName MUST be replaced by the internal beacon name
(i.e. NAME replaced by aws_dbe_b_NAME) and the AttributeType MUST be changed to string.

The same name changes MUST be made to the AttributeDefinitions.

## UpdateTableInputForBeacons

Transform an UpdateTableInput object for searchable encryption.

If a Global Secondary Index is being created, and its KeySchema
has an AttributeName equal to the name of a configured beacon,
the AttributeName MUST be replaced by the internal beacon name
(i.e. NAME replaced by aws_dbe_b_NAME) and the AttributeType MUST be changed to string.

The same name changes MUST be made to the AttributeDefinitions.

## DescribeTableOutputForBeacons

Transform a DescribeTableOutput object for searchable encryption.

Any internal beacon name used in the KeySchema, LocalSecondaryIndexes or GlobalSecondaryIndexes
MUST be replaced by the beacon name. (i.e. aws_dbe_b_NAME replaced by NAME).

## QueryInputForBeacons

Transform an unencrypted QueryInput object for searchable encryption.

The [Beacon Key Source](../searchable-encryption/search-config.md#beacon-key-source) for the configured table
MUST be used to obtain the correct beacon key information needed for query.

For any operand in the KeyConditionExpression or FilterExpression which is a beacon name,
the name MUST be replaced by the internal beacon name (i.e. NAME replaced by aws_dbe_b_NAME).

If the name is used directly in the expression, the name MUST be changed in the expression.
For example the expression "MyBeacon < :value" must be changed to "aws_dbe_b_MyBeacon < :value".

If the name is used indirectly through the ExpressionAttributeNames mapping,
the name MUST be changed in the ExpressionAttributeNames. For example if the query is
"#Beacon < :value" and ExpressionAttributeNames holds (#Beacon = MyBeacon),
the query must remain unchanged and ExpressionAttributeNames changed to (#Beacon = aws_dbe_b_MyBeacon).

In this regard, each use of each operand is handled separately.

Similarly, any values in ExpressionAttributeValues that are referred to by a beacon name
MUST be changed to the beacon value, as calculated defined in [beacons](../searchable-encryption/beacons.md#beacon-value).
For example if the query is
"MyBeacon < :value" and ExpressionAttributeValues holds (:value = banana),
then the ExpressionAttributeValues must be changed to (:value = 13fd),
where "13fd" is the calculated beacon value.

## QueryOutputForBeacons

Transform an unencrypted QueryOutput object for searchable encryption.

We expect that the list of items returned will contain some extra records
that matched the beacon values, but do not match the plaintext values.

We currently only support beacon keys bound to branch keys in the [AWS KMS Hierarchical Keyring](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/aws-kms/aws-kms-hierarchical-keyring.md#ondecrypt).
Therefore the [Parsed Header](./encrypt-item.md#parsed-header)'s encrypted data keys MUST contain only one encrypted data key.
It's [Key Provider ID](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/structures.md#key-provider-id)
MUST equal the provider ID for the [AWS KMS Hierarchical Keyring](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/aws-kms/aws-kms-hierarchical-keyring.md#ondecrypt).

Additionally if the [Beacon Key Source](../searchable-encryption/search-config.md#beacon-key-source) for the configured table
is [Multi Key Store](../searchable-encryption/search-config.md#multi-key-store-initialization)
we expect some extra records from other beacon keys.
These values opaqued with a beacon key different from the beacon key used to search
MUST be filtered out if the [Key Provider Information](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/structures.md#key-provider-id)
does not match the beacon used to search.

For each item, we MUST evaluate the query expressions supplied in the QueryInput
against the decrypted field values returned by the query.
That is, we must filter the decrypted records exactly the way that
the DynamoDB server would have, if the server had access to the plaintext values
of the item.
Any items that do not match MUST be discarded.

For example, imagine that the query input used the expression "Fruit = :fruit"
with the value map containing (:fruit = banana).

The actual query resolved by the server will be "aws_dbe_b_Fruit = :fruit"
with the value map containing (:fruit = 12345).

Further imagine that two records were returned, one with fruit = banana, 
and one with fruit = orange (but both with aws_dbe_b_Fruit = 12345).

This operation must look at the field "fruit" and keep only the record
where fruit = banana.

The `Count` field, MUST be updated to reflect the new item count.

In this context, the DynamoDB server has already verified that the query is
well formed, and so any errors encountered during this filtering step
must reflect some more fundamental system error. For this reason,
any error encountered during filtering MUST result in a failure of the query operation.

## ScanInputForBeacons

Transform an unencrypted ScanInput object for searchable encryption.

The ScanInput is transformed in the same way as [QueryInputForBeacons](#queryinputforbeacons).

## ScanOutputForBeacons

Transform an unencrypted ScanOutput object for searchable encryption.

The ScanOutput is transformed in the same way as [QueryOutputForBeacons](#queryoutputforbeacons).
