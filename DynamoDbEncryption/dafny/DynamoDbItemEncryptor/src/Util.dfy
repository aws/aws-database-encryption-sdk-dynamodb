// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.dfy"

module DynamoDbItemEncryptorUtil {
  import opened AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import UTF8
  import MPL = AwsCryptographyMaterialProvidersTypes
  import DDB = ComAmazonawsDynamodbTypes
  import SortedSets
  import SE = StructuredEncryptionUtil
  import DynamoToStruct

  const ReservedPrefix := "aws_dbe_"
  const BeaconPrefix := ReservedPrefix + "b_"
  const VersionPrefix := ReservedPrefix + "v_"
  const MAX_ATTRIBUTE_COUNT := 100

  function method E(msg : string) : Error
  {
    DynamoDbItemEncryptorException(message := msg)
  }

  predicate method ByteLess(x : uint8, y : uint8)
  {
    x < y
  }

  predicate method CharLess(x : char, y : char)
  {
    x < y
  }

  const TABLE_NAME : UTF8.ValidUTF8Bytes := UTF8.EncodeAscii("aws-crypto-table-name")
  const PARTITION_NAME : UTF8.ValidUTF8Bytes := UTF8.EncodeAscii("aws-crypto-partition-name")
  const SORT_NAME : UTF8.ValidUTF8Bytes := UTF8.EncodeAscii("aws-crypto-sort-name")

  const SELECTOR_TABLE_NAME : DDB.AttributeName := "aws_dbe_table_name"
  const SELECTOR_PARTITION_NAME : DDB.AttributeName := "aws_dbe_partition_name"
  const SELECTOR_SORT_NAME : DDB.AttributeName := "aws_dbe_sort_name"

  function method GetLiteralValue(x : seq<uint8>) : (ret : Result<DDB.AttributeValue, string>)
  {
    var str :- UTF8.Decode(x);
    if str == SE.TRUE_STR then
      Success(DDB.AttributeValue.BOOL(true))
    else if str == SE.FALSE_STR then
      Success(DDB.AttributeValue.BOOL(false))
    else if str == SE.NULL_STR then
      Success(DDB.AttributeValue.NULL(true))
    else
      Failure("Encryption Context literal value has unexpected value : '" + str + "'.")
  }

  function method GetSortKey(context : MPL.EncryptionContext) : Result<Option<UTF8.ValidUTF8Bytes>, string>
  {
    if SORT_NAME in context.Keys then
      var sortName := SE.EC_ATTR_PREFIX + context[SORT_NAME];
      :- Need(UTF8.ValidUTF8Seq(sortName), "Internal Error : bad utf8 in sortName");
      Success(Some(sortName))
    else
      Success(None)
  }

  function method ConvertContextForSelector(context : MPL.EncryptionContext)
    : (output: Result<DDB.Key, string>)
    //= specification/dynamodb-encryption-client/ddb-encryption-branch-key-id-supplier.md#behavior
    //= type=implication
    //# - If the partition name does not exist in the encryption context, this operation MUST fail.
    ensures PARTITION_NAME !in context.Keys ==> output.Failure?

    ensures output.Success? ==>
              //= specification/dynamodb-encryption-client/ddb-encryption-branch-key-id-supplier.md#behavior
              //= type=implication
              //# - It MUST deserialize the "aws-crypto-partition-name" value in the input encryption context to determine the partition name.
              && PARTITION_NAME in context.Keys
              && var partitionName := context[PARTITION_NAME];
              && var partitionValueKey := SE.EC_ATTR_PREFIX + partitionName;
              && partitionValueKey in context.Keys

    //= specification/dynamodb-encryption-client/ddb-encryption-branch-key-id-supplier.md#behavior
    //= type=implication
    //# - It MUST get the serialized partition value by grabbing the `aws-crypto-attr.<partition_name>` from the encryption context.

    //= specification/dynamodb-encryption-client/ddb-encryption-branch-key-id-supplier.md#behavior
    //= type=implication
    //# - If the partition value does not exist in the encryption context, this operation MUST fail.
    ensures PARTITION_NAME in context.Keys ==>
              && var partitionName := context[PARTITION_NAME];
              && var partitionValueKey := SE.EC_ATTR_PREFIX + partitionName;
              && (partitionValueKey !in context.Keys) ==> output.Failure?

    //= specification/dynamodb-encryption-client/ddb-encryption-branch-key-id-supplier.md#behavior
    //= type=implication
    //# - It MUST check for the existence of "aws-crypto-sort-name" in the input encryption context.

    //= specification/dynamodb-encryption-client/ddb-encryption-branch-key-id-supplier.md#behavior
    //= type=implication
    //# - If this key exists, it MUST get the serialized sort value by grabbing the `aws-crypto.attr:<sort_name>` from the encryption context.
    ensures output.Success? && SORT_NAME in context.Keys ==>
              && var sortName := context[SORT_NAME];
              && var sortValueKey := SE.EC_ATTR_PREFIX + sortName;
              && sortValueKey in context.Keys

    //= specification/dynamodb-encryption-client/ddb-encryption-branch-key-id-supplier.md#behavior
    //= type=implication
    //# - If the sort value does not exist in the context, this operation MUST fail.
    ensures SORT_NAME in context.Keys ==>
              && var sortName := context[SORT_NAME];
              && var sortValueKey := SE.EC_ATTR_PREFIX + sortName;
              && (sortValueKey !in context.Keys ==> output.Failure?)
  {
    // Add partition key to map
    :- Need(PARTITION_NAME in context.Keys, "Invalid encryption context: Missing partition name");
    var partitionName := context[PARTITION_NAME];
    var partitionValueKey := SE.EC_ATTR_PREFIX + partitionName;
    :- Need(partitionValueKey in context.Keys, "Invalid encryption context: Missing partition value");

    var sortValueKey :- GetSortKey(context);
    :- Need(sortValueKey.None? || sortValueKey.value in context, "Invalid encryption context: Missing sort value");

    var keys : seq<UTF8.ValidUTF8Bytes> := SortedSets.ComputeSetToOrderedSequence2(context.Keys, SE.ByteLess);

    //= specification/dynamodb-encryption-client/ddb-encryption-branch-key-id-supplier.md#behavior
    //# - If the field "aws-crypto-legend" exists in the encryption context,
    //# it MUST [deserialize](./ddb-attribute-serialization.md), all values with keys beginning "aws-crypto-attr.",
    //# and create a Key with these values, using names with the "aws-crypto-attr." removed.
    if SE.LEGEND_UTF8 in context then
      var legend :- UTF8.Decode(context[SE.LEGEND_UTF8]);
      var attrMap :- GetV2AttrMap(keys, context, legend);

      :- Need(TABLE_NAME in context, "Internal error, table name not in encryption context.");
      var tableName :- UTF8.Decode(context[TABLE_NAME]);
      var attrMap2 := attrMap[SELECTOR_TABLE_NAME := DDB.AttributeValue.S(tableName)];

      :- Need(PARTITION_NAME in context, "Internal error, table name not in encryption context.");
      var partitionName :- UTF8.Decode(context[PARTITION_NAME]);
      var attrMap3 := attrMap2[SELECTOR_PARTITION_NAME := DDB.AttributeValue.S(partitionName)];

      if SORT_NAME in context then
        var sortName :- UTF8.Decode(context[SORT_NAME]);
        Success(attrMap3[SELECTOR_SORT_NAME := DDB.AttributeValue.S(sortName)])
      else
        Success(attrMap3)

    //= specification/dynamodb-encryption-client/ddb-encryption-branch-key-id-supplier.md#behavior
    //# - If the field "aws-crypto-legend" does not exist in the encryption context, it MUST [deserialize the partition (and optionally sort) value](./ddb-attribute-serialization.md), and create a Key with these values.
    else if sortValueKey.None? then
      AddAttributeToMap(partitionValueKey, context[partitionValueKey], map[])
    else
      var attrMap :- AddAttributeToMap(partitionValueKey, context[partitionValueKey], map[]);
      AddAttributeToMap(sortValueKey.value, context[sortValueKey.value], attrMap)
  }

  function method GetAttrValue(ecValue : UTF8.ValidUTF8Bytes, legend : char)
    : Result<DDB.AttributeValue, string>
  {
    if legend == SE.LEGEND_STRING then
      var value :- UTF8.Decode(ecValue);
      Success(DDB.AttributeValue.S(value))
    else if legend == SE.LEGEND_NUMBER then
      var value :- UTF8.Decode(ecValue);
      Success(DDB.AttributeValue.N(value))
    else if legend == SE.LEGEND_LITERAL then
      var value :- GetLiteralValue(ecValue);
      Success(value)
    else if legend == SE.LEGEND_BINARY then
      var terminal :- SE.DecodeTerminal(ecValue);
      var ddbAttrValue :- DynamoToStruct.BytesToAttr(terminal.value, terminal.typeId, false);
      Success(ddbAttrValue.val)
    else
      Failure("Encryption Context Legend has unexpected character : '" + [legend] + "'.")
  }

  function method GetV2AttrMap(
    keys : seq<UTF8.ValidUTF8Bytes>,
    context : MPL.EncryptionContext,
    legend : string,
    attrMap : DDB.AttributeMap := map[]
  )
    : Result<DDB.AttributeMap, string>
    requires forall k <- keys :: k in context
  {
    if |keys| == 0 then
      if |legend| == 0 then
        Success(attrMap)
      else
        Failure("Encryption Context Legend is too long.")
    else
      var key : UTF8.ValidUTF8Bytes := keys[0];
      if SE.EC_ATTR_PREFIX < key then
        :- Need(0 < |legend|, "Encryption Context Legend is too short.");
        var attrName :- GetAttributeName(key);
        var attrValue :- GetAttrValue(context[key], legend[0]);
        GetV2AttrMap(keys[1..], context, legend[1..], attrMap[attrName := attrValue])
      else
        GetV2AttrMap(keys[1..], context, legend, attrMap)
  }

  function method GetAttributeName(ddbAttrKey: UTF8.ValidUTF8Bytes)
    : (res: Result<DDB.AttributeName, string>)
    requires |ddbAttrKey| >= |SE.EC_ATTR_PREFIX|
  {
    // Obtain attribute name from EC kvPair key
    var ddbAttrNameBytes := ddbAttrKey[|SE.EC_ATTR_PREFIX|..];
    var ddbAttrName :- UTF8.Decode(ddbAttrNameBytes);
    :- Need(DDB.IsValid_AttributeName(ddbAttrName), "Invalid serialization of DDB Attribute in encryption context.");
    Success(ddbAttrName)
  }

  function method AddAttributeToMap(ddbAttrKey: UTF8.ValidUTF8Bytes, encodedAttrValue: UTF8.ValidUTF8Bytes, attrMap: DDB.AttributeMap)
    : (res: Result<DDB.AttributeMap, string>)
    requires |ddbAttrKey| >= |SE.EC_ATTR_PREFIX|
  {
    var ddbAttrName :- GetAttributeName(ddbAttrKey);

    // Obtain attribute value from EC kvPair value
    var terminal :- SE.DecodeTerminal(encodedAttrValue);
    var ddbAttrValue :- DynamoToStruct.BytesToAttr(terminal.value, terminal.typeId, false);

    // Add to our AttributeMap
    Success(attrMap[ddbAttrName := ddbAttrValue.val])
  }

}
