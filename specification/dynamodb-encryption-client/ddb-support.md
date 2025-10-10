[//]: # "Copyright Amazon.com Inc. or its affiliates. All Rights Reserved."
[//]: # "SPDX-License-Identifier: CC-BY-SA-4.0"

# DynamoDB Support Layer

The DynamoDB Support Layer provides everything necessary to the middleware interceptors,
with the exception of encryption and decryption.

This document specifies the interface and high level semantics of these entry points.

[DynamoDB SDK Integration](ddb-sdk-integration.md) should be specified in terms of
these operations.

There are two categories of support functions.

The first category is for general support, used across multiple DynamoDB API transformations.

- [Writable](#writable) - are the attributes in this item ok to write
- [TestConditionExpression](#testconditionexpression) - Is this condition expression suitable for use
- [TestUpdateExpression](#testupdateexpression) - Is this update expression suitable for use
- [AddSignedBeacons](#addsignedbeacons) - Add non encrypted attributes to an item to enable searchable encryption
- [GetEncryptedBeacons](#getencryptedbeacons) - Get new attributes for an item to enable searchable encryption
- [RemoveBeacons](#removebeacons) - Remove all private attributes from an item,
  e.g. the ones added in [AddSignedBeacons](#addsignedbeacons) and [GetEncryptedBeacons](#getencryptedbeacons)
- [HandleBeaconKeyFieldName](#handlebeaconkeyfieldname) - Handle the beacon key field name for Multi Key Store configurations

The second category is support for specific interceptors, where the whole input or output structure is modified.

- [QueryInputForBeacons](#queryinputforbeacons)
- [QueryOutputForBeacons](#queryoutputforbeacons)
- [ScanInputForBeacons](#scaninputforbeacons)
- [ScanOutputForBeacons](#scanoutputforbeacons)

## Writable

Writeable MUST reject any item containing an attribute which begins with `aws_dbe_`.

One needn't worry about attributes with the same names as beacons or virtual fields,
because elsewhere we make sure that the beacons do not overlap with configured fields,
and so trying to write those fields will result in "writing unconfigured field" errors already.

## TestConditionExpression

TestConditionExpression MUST fail if any operand in the condition expression is an encrypted attribute name.

## TestUpdateExpression

TestUpdateExpression MUST fail if any operand in the update expression is a signed attribute name.

## AddSignedBeacons

AddSignedBeacons examines an AttributeMap and modifies it to be appropriate for Searchable Encryption,
returning a replacement AttributeMap.

AddSignedBeacons MUST only operate on [compound beacons](../searchable-encryption/beacons.md#compound-beacon)
that do not have any [encrypted parts](../searchable-encryption/beacons.md#compound-beacon-initialization).

For every configured compound beacons which only contains non encrypted parts
that can be successfully built from the attributes in the input AttributeMap,
AddSignedBeacons MUST add an attribute named NAME,
where NAME is the name of the beacon.
The value of this attribute MUST be a string,
and must have the value defined in [beacons](../searchable-encryption/beacons.md#beacon-value).

If the attribute NAME already exists,
if the constructed compound beacon does not match
the existing attribute value AddSignedBeacons MUST fail.

AddSignedBeacons MUST also add an attribute with name `aws_dbe_v_1` and whose value is a string containing a single space.

The result of AddSignedBeacons MUST be a super set of everything in the input AttributeMap.

## GetEncryptedBeacons

GetEncryptedBeacons examines the [Encrypt Item Input](./encrypt-item.md#input)
and [Encrypt Item Output](./encrypt-item.md#output).

To obtain [Beacon Key Materials] GetEncryptedBeacons
MUST call [Get beacon key after encrypt](../searchable-encryption/search-config.md#get-beacon-key-after-encrypt).

A [partition number](search-config.md#partitionnumber) MUST be generated
by calling the [partition selector](search-config.md#partition-selector).
This [partition number](search-config.md#partitionnumber) is to be used for all [standard beacons](./searchable-encryption/beacons.md#standard-beacon) in the item.

GetEncryptedBeacons MUST NOT operate on [compound beacons](../searchable-encryption/beacons.md#compound-beacon)
that only have [signed parts](../searchable-encryption/beacons.md#compound-beacon-initialization).

For all other configured beacons
that can be successfully built from the attributes in the input AttributeMap,
GetEncryptedBeacons MUST add an attribute named aws_dbe_b_NAME,
where NAME is the name of the beacon.
The value of this attribute MUST be a string,
and must have the value defined in [beacons](../searchable-encryption/beacons.md#beacon-value)

The result of GetEncryptedBeacons MUST NOT contain any keys
in the [Encrypt Item Output](./encrypt-item.md#output) AttributeMap.

## RemoveBeacons

RemoveBeacons examines an AttributeMap and modifies it to be appropriate for customer use,
returning a replacement AttributeMap.

RemoveBeacons MUST remove any attributes whose name begins with `aws_dbe_`,
and leave all other attributes unchanged.

## HandleBeaconKeyFieldName

HandleBeaconKeyFieldName examines an AttributeMap,
the [Beacon Key Source](../searchable-encryption/search-config.md#beacon-key-source)
and the [Attribute Actions](./ddb-table-encryption-config.md#attribute-actions) to determine
how the [Beacon Key Field Name](../searchable-encryption/search-config.md#beacon-key-field-name) should be handled.

The [Beacon Key Source](../searchable-encryption/search-config.md#beacon-key-source)
MUST be [Multi Key Store](../searchable-encryption/search-config.md#multi-key-store-initialization)
or HandleBeaconKeyFieldName MUST fail.

If the AttributeMap does not have a key
equal to [Beacon Key Field Name](../searchable-encryption/search-config.md#beacon-key-field-name)
HandleBeaconKeyFieldName MUST return a `beacon key id` of None
and the unaltered AttributeMap.
This case is because a specific item
may not have any beacons that need to be constructed.

If the AttributeMap does have a key
equal to [Beacon Key Field Name](../searchable-encryption/search-config.md#beacon-key-field-name)
then the `beacon key id` MUST be the value of this Attribute.

If there is not an [Attribute Action](./ddb-table-encryption-config.md#attribute-actions)
configured for the [Beacon Key Field Name](../searchable-encryption/search-config.md#beacon-key-field-name)
HandleBeaconKeyFieldName MUST remove the [Beacon Key Field Name](../searchable-encryption/search-config.md#beacon-key-field-name)
from the AttributeMap and return the `beacon key id` and the altered AttributeMap.

If there is an [Attribute Action](./ddb-table-encryption-config.md#attribute-actions)
configured for the [Beacon Key Field Name](../searchable-encryption/search-config.md#beacon-key-field-name)
and that action is [DO_NOTHING](../structured-encryption/structures.md#do_nothing)
HandleBeaconKeyFieldName MUST remove the [Beacon Key Field Name](../searchable-encryption/search-config.md#beacon-key-field-name)
from the AttributeMap and return the `beacon key id` and the altered AttributeMap.

If there is an [Attribute Action](./ddb-table-encryption-config.md#attribute-actions)
configured for the [Beacon Key Field Name](../searchable-encryption/search-config.md#beacon-key-field-name)
and that action is [SIGN_ONLY](../structured-encryption/structures.md#sign_only)
HandleBeaconKeyFieldName MUST return the `beacon key id`
and the unaltered AttributeMap.

Having an attribute action of [ENCRYPT_AND_SIGN](../structured-encryption/structures.md#encrypt_and_sign)
for the [Beacon Key Field Name](../searchable-encryption/search-config.md#beacon-key-field-name)
is [not a valid configuration](../searchable-encryption/search-config.md#beacon-version-initialization).

## QueryInputForBeacons

Transform an unencrypted [QueryInput](#queryinput) object for searchable encryption.

The KeyConditions property MUST NOT be defined on [QueryInput](#queryinput).

If the [QueryObject has encrypted values](#queryobject-has-encrypted-values)
then QueryInputForBeacons MUST obtain [Beacon Key Materials](../searchable-encryption/search-config.md#beacon-key-materials)
from [Get beacon key for query](../searchable-encryption/search-config.md#get-beacon-key-for-query).
If the [QueryObject does not have encrypted values](#queryobject-has-encrypted-values)
then QueryInputForBeacons MUST NOT attempt to obtain [Beacon Key Materials](../searchable-encryption/search-config.md#beacon-key-materials).

When querying, a [partition number](search-config.md#partitionnumber) MUST be determined by examining
the `:aws_dbe_partition` value in the `ExpressionAttributeValues`.

If this value is absent, a partition number of `0` MUST be used.

If this value is not of type `N` or fails to hold an integer value
greater than or equal to zero and less than the [max partitions](search-config.md#max-partitions),
an error MUST be returned.

If this value is valid, then this value is used and the `:aws_dbe_partition` field MUST
be removed from the `ExpressionAttributeValues`.

For any operand in the KeyConditionExpression or FilterExpression which is a beacon name,
the name MUST be replaced by the internal beacon name (i.e. NAME replaced by aws_dbe_b_NAME).

If the name is used directly in the expression, the name MUST be changed in the expression.
For example the expression "MyBeacon = :value" must be changed to "aws_dbe_b_MyBeacon = :value".

If the name is used indirectly through the ExpressionAttributeNames mapping,
the name MUST be changed in the ExpressionAttributeNames. For example if the query is
"#Beacon = :value" and ExpressionAttributeNames holds (#Beacon = MyBeacon),
the query must remain unchanged and ExpressionAttributeNames changed to (#Beacon = aws_dbe_b_MyBeacon).

In this regard, each use of each operand is handled separately.

Similarly, any values in ExpressionAttributeValues that are referred to by a beacon name
MUST be changed to the beacon value, as calculated defined in [beacons](../searchable-encryption/beacons.md#beacon-value).
The [hmac key](./search-config.md#hmac-key-generation) used
MUST be obtained from the [Beacon Key Materials](../searchable-encryption/search-config.md#beacon-key-materials)
[HMAC Keys map](../searchable-encryption/search-config.md#hmac-keys) using the beacon name
as the key.

If [Partition Beacons](../changes/2025-08-25-partition-beacons/background.md) are being used,
then the [FilterExpression](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Query.FilterExpression.html) must be augmented as described in [Filter Expressions for Query](#filter-expressions-for-query).

For example if the query is
"MyBeacon = :value" and ExpressionAttributeValues holds (:value = banana),
then the ExpressionAttributeValues must be changed to (:value = 13fd),
where "13fd" is the calculated beacon value.

If a single value in ExpressionAttributeValues is used in more than one context,
for example an expression of `this = :foo OR that = :foo` where `this` and `that`
are both beacons, this operation MUST fail.
This includes the case where the KeyConditionExpression contains `this = :foo`
and the FilterExpression includes `that = :foo`.
This is because `:foo` can only hold one value, but the beaconization of `:foo`
would be different for different beacons.

Hypothetically, this operation could split `:foo` into `:foo1` and `:foo2`
in this situation, but that risks leaking the connection between the two beacons and spoiling k-anonymity.
Similarly, if one of the two was not a beacon, then we would be leaking the fact that
this beacon came from that text.

### Filter Expressions for Query

if [GetNumberOfQueries](./ddb-get-number-of-queries.md) returns a number less than the configured
[maximum number of partitions](../searchable-encryption/search-config.md#max-partitions)
then the FilterExpression MUST be augmented to match against partitions greater than
the limit returned from GetNumberOfQueries.

For each partition number that would map to the current partition,
calculate the Filter Expression as for that partition.
The FilterExpression sent to DynamoDB MUST be the `OR` combination of all of these expressions.

The text of the FilterExpression is unlikely to change between partitions.
What will change is the values in the ExpressionAttributeValues,
which will be different if they involve standard beacons calculated with different partitions.
This implies that additional unique values will need to be added to ExpressionAttributeValues.

As an example, if a table is configured with five partitions,
and GetNumberOfQueries returns two, and `foo[n]` represents the expression as calculated for partition `n`,
then when `:aws_dbe_partition = 0` the filter expression must be `(foo[0]) OR (foo[2]) OR (foo[4])`
ands when `:aws_dbe_partition = 1` the filter expression must be `(foo[1]) OR (foo[3])`.

The resulting FilterExpression might look something like this:

`(aws_dbe_b_Attr3 = :attr3 AND aws_dbe_b_Attr4 = :attr4) OR (aws_dbe_b_Attr3 = :attr3AA AND aws_dbe_b_Attr4 = :attr4AA) OR (aws_dbe_b_Attr3 = :attr3AB AND aws_dbe_b_Attr4 = :attr4AB)`

### QueryObject has encrypted values

Determines if a Query Object has encrypted values (ENCRYPT_AND_SIGN fields)

If there are any ExpressionAttributeValues that are referred to by
a beacon name that contain encrypted values (ENCRYPT_AND_SIGN field)
then QueryObject has encrypted values MUST return true.
Otherwise it MUST return false.

### QueryInput

This is the original Query request that was made by the customer.

## QueryOutputForBeacons

Transform an unencrypted QueryOutput object for searchable encryption.

We expect that the list of items returned will contain some extra records
that matched the beacon values, but do not match the plaintext values
if the customer has made a query over any encrypted fields.

If the [QueryObject does not have encrypted values](#queryobject-has-encrypted-values)
then QueryOutputForBeacons MUST not filter the results and MUST return.
This is because the query may not have a beacon key id filed.

If the [Beacon Key Source](../searchable-encryption/search-config.md#beacon-key-source) for the configured table
is a [Multi Key Store](../searchable-encryption/search-config.md#multi-key-store-initialization)
you MUST construct an `expected beacon key id` equal to the [Beacon Key Id](../searchable-encryption/search-config.md#beacon-key-materials)
on materials obtained from [Get beacon key for query](../searchable-encryption/search-config.md#get-beacon-key-for-query)
These [Beacon Key Materials](../searchable-encryption/search-config.md#beacon-key-materials)
SHOULD then be discarded.
Using the constructed `expected beacon key id`,
for each item the result
the [Get beacon key id from Parsed Header](../searchable-encryption/search-config.md#get-beacon-key-id-from-parsed-header)
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

The ScanInput is transformed in the same way as [QueryInputForBeacons](#queryinputforbeacons),
except that [Filter Expressions for Query](#filter-expressions-for-query) is calculated
as if GetNumberOfQueries returned `1`.

## ScanOutputForBeacons

Transform an unencrypted ScanOutput object for searchable encryption.

The ScanOutput is transformed in the same way as [QueryOutputForBeacons](#queryoutputforbeacons).
