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
 * [HandleBeaconKeyFieldName](#handlebeaconkeyfieldname) - 

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

## AddNonSensitiveBeacons

AddNonSensitiveBeacons examines an AttributeMap and modifies it to be appropriate for Searchable Encryption,
returning a replacement AttributeMap.

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

AddSensitiveBeacons examines the [Encrypt Item Input](./encrypt-item.md#input)
and [Encrypt Item Output](./encrypt-item.md#output).

To obtain [Beacon Key Materials] AddSensitiveBeacons
MUST call [Get beacon key after encrypt](../searchable-encryption/search-config.md#get-beacon-key-after-encrypt).

AddSensitiveBeacons MUST NOT operate on [compound beacons](../searchable-encryption/beacons.md#compound-beacon)
that only have [non-sensitive parts](../searchable-encryption/beacons.md#compound-beacon-initialization).

For all other configured beacons
that can be successfully built from the attributes in the input AttributeMap,
AddSensitiveBeacons MUST add an attribute named aws_dbe_b_NAME,
where NAME is the name of the beacon.
The value of this attribute MUST be a string,
and must have the value defined in [beacons](../searchable-encryption/beacons.md#beacon-value)

The result of AddSensitiveBeacons MUST contain, unaltered,
everything in the [Encrypt Item Output](./encrypt-item.md#output) AttributeMap.

## RemoveBeacons

RemoveBeacons examines an AttributeMap and modifies it to be appropriate for customer use,
returning a replacement AttributeMap.

RemoveBeacons MUST remove any attributes whose name begins with `aws_dbe_`,
and leave all other attributes unchanged.

## HandleBeaconKeyFieldName

HandleBeaconKeyFieldName examines an AttributeMap
the [Search Config](../searchable-encryption/search-config.md),
a [Beacon Key Field Name](../searchable-encryption/search-config.md#beacon-key-field-name),
and the [Attribute Actions](./ddb-table-encryption-config.md#attribute-actions)
to determine how this field should be handled.

If the [Beacon Key Source](../searchable-encryption/search-config.md#beacon-key-source)
is a [Single Key Store](../searchable-encryption/search-config.md#single-key-store-initialization)
HandleBeaconKeyFieldName MUST return a `beacon key id` of None
and the unaltered AttributeMap.

If the [Beacon Key Source](../searchable-encryption/search-config.md#beacon-key-source)
is a [Multi Key Store](../searchable-encryption/search-config.md#multi-key-store-initialization)
then [Beacon Key Field Name](../searchable-encryption/search-config.md#beacon-key-field-name)
MUST be used to find the `beacon key id`.

If the AttributeMap does not have a key
equal to [Beacon Key Field Name](../searchable-encryption/search-config.md#beacon-key-field-name)
HandleBeaconKeyFieldName MUST return a `beacon key id` of None
and the unaltered AttributeMap.

If the AttributeMap does have a key
equal to [Beacon Key Field Name](../searchable-encryption/search-config.md#beacon-key-field-name)
then the `beacon key id` MUST be the value of this Attribute.

If there is not an [Attribute Action](./ddb-table-encryption-config.md#attribute-actions)
configured for the [Beacon Key Field Name](../searchable-encryption/search-config.md#beacon-key-field-name)
HandleBeaconKeyFieldName MUST return the `beacon key id`
and the unaltered AttributeMap.

If there is an [Attribute Action](./ddb-table-encryption-config.md#attribute-actions)
configured for the [Beacon Key Field Name](../searchable-encryption/search-config.md#beacon-key-field-name)
and that action is [DO_NOTHING](../structured-encryption/structures.md#do_nothing)
HandleBeaconKeyFieldName MUST return the `beacon key id`
and the unaltered AttributeMap.

If there is an [Attribute Action](./ddb-table-encryption-config.md#attribute-actions)
configured for the [Beacon Key Field Name](../searchable-encryption/search-config.md#beacon-key-field-name)
and that action is [SIGN_ONLY](../structured-encryption/structures.md#sign_only)
HandleBeaconKeyFieldName MUST remove the [Beacon Key Field Name](../searchable-encryption/search-config.md#beacon-key-field-name)
from the AttributeMap and return the `beacon key id` and the altered AttributeMap.

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

[Beacon Key Materials](../searchable-encryption/search-config.md#beacon-key-materials)
MUST be obtained from [Get beacon key for query](../searchable-encryption/search-config.md#get-beacon-key-for-query).

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
The [hmac key](./search-config.md#hmac-key-generation) used
MUST be obtained from the [Beacon Key Materials](../searchable-encryption/search-config.md#beacon-key-materials)
[HMAC Keys map](../searchable-encryption/search-config.md#hmac-keys) using the beacon name
as the key.

For example if the query is
"MyBeacon < :value" and ExpressionAttributeValues holds (:value = banana),
then the ExpressionAttributeValues must be changed to (:value = 13fd),
where "13fd" is the calculated beacon value.

## QueryOutputForBeacons

Transform an unencrypted QueryOutput object for searchable encryption.

We expect that the list of items returned will contain some extra records
that matched the beacon values, but do not match the plaintext values.

If the [Beacon Key Source](../searchable-encryption/search-config.md#beacon-key-source) for the configured table
is a [Multi Key Store](../searchable-encryption/search-config.md#multi-key-store-initialization)
the `expected beacon key id` MUST be the [Beacon Key Id](../searchable-encryption/search-config.md#beacon-key-materials)
on materials obtained from [Get beacon key for query](../searchable-encryption/search-config.md#get-beacon-key-for-query)
These [Beacon Key Materials](../searchable-encryption/search-config.md#beacon-key-materials)
SHOULD then be discarded.

If we have an `expected beacon key id`,
for each item the result
from [Get beacon key id from Parsed Header](../searchable-encryption/search-config.md#get-beacon-key-id-from-parsed-header)
MUST match the `expected beacon key id`.
If [Get beacon key id from Parsed Header](../searchable-encryption/search-config.md#get-beacon-key-id-from-parsed-header)
fails or an item does not match it MUST be discarded.

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
