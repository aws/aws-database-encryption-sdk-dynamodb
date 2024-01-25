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

  const LEGEND_STRING : char := SE.LEGEND_STRING
  const LEGEND_NUMBER : char := SE.LEGEND_NUMBER
  const LEGEND_LITERAL : char := SE.LEGEND_LITERAL
  const LEGEND_BINARY : char := SE.LEGEND_BINARY

  const TABLE_NAME : UTF8.ValidUTF8Bytes := UTF8.EncodeAscii("aws-crypto-table-name")
  const PARTITION_NAME : UTF8.ValidUTF8Bytes := UTF8.EncodeAscii("aws-crypto-partition-name")
  const SORT_NAME : UTF8.ValidUTF8Bytes := UTF8.EncodeAscii("aws-crypto-sort-name")

  const SELECTOR_TABLE_NAME : DDB.AttributeName := "aws_dbe_table_name"
  const SELECTOR_PARTITION_NAME : DDB.AttributeName := "aws_dbe_partition_name"
  const SELECTOR_SORT_NAME : DDB.AttributeName := "aws_dbe_sort_name"

  function method GetLiteralValue(x : seq<uint8>) : Result<DDB.AttributeValue, string>
  {
    var str :- UTF8.Decode(x);
    match str {
      case "true" => Success(DDB.AttributeValue.BOOL(true))
      case "false" => Success(DDB.AttributeValue.BOOL(false))
      case "null" => Success(DDB.AttributeValue.NULL(false))
      case _ => Failure("Encryption Context literal value has unexpected value : '" + str + "'.")
    }
  }

  method ConvertContextForSelector(context : MPL.EncryptionContext)
    returns (output: Result<DDB.Key, string>)
  {
    var attrMap: DDB.AttributeMap := map[];

    :- Need(PARTITION_NAME in context.Keys, "Invalid encryption context: Missing partition name");

    var keys : seq<UTF8.ValidUTF8Bytes> := SortedSets.ComputeSetToOrderedSequence2(context.Keys, SE.ByteLess);

    if SE.LEGEND_UTF8 in context {
      var legend :- UTF8.Decode(context[SE.LEGEND_UTF8]);

      var attrPos := 0;
      for i := 0 to |keys|
        invariant attrPos <= i
      {
        var key : UTF8.ValidUTF8Bytes := keys[i];
        if SE.EC_ATTR_PREFIX < key {
          :- Need(|legend| > attrPos, "Encryption Context Legend is too short.");
          var ddbAttrName :- GetAttributeName(key);
          match legend[attrPos] {
            case 'S' =>
              var value :- UTF8.Decode(context[key]);
              attrMap := attrMap[ddbAttrName := DDB.AttributeValue.S(value)];
            case 'N' =>
              var value :- UTF8.Decode(context[key]);
              attrMap := attrMap[ddbAttrName := DDB.AttributeValue.N(value)];
            case 'L' =>
              var value :- GetLiteralValue(context[key]);
              attrMap := attrMap[ddbAttrName := value];
            case 'B' => attrMap :- AddAttributeToMap(key, context[key], attrMap);
            case _ => return Failure("Encryption Context Legend has unexpected character : '" + [legend[attrPos]] + "'.");
          }
          attrPos := attrPos + 1;
        }
      }
      :- Need(|legend| == attrPos, "Encryption Context Legend is too long.");

      :- Need(TABLE_NAME in context, "Internal error, table name not in encryption context.");
      var tableName :- UTF8.Decode(context[TABLE_NAME]);
      attrMap := attrMap[SELECTOR_TABLE_NAME := DDB.AttributeValue.S(tableName)];

      :- Need(PARTITION_NAME in context, "Internal error, table name not in encryption context.");
      var partitionName :- UTF8.Decode(context[PARTITION_NAME]);
      attrMap := attrMap[SELECTOR_PARTITION_NAME := DDB.AttributeValue.S(partitionName)];

      if SORT_NAME in context {
        var sortName :- UTF8.Decode(context[SORT_NAME]);
        attrMap := attrMap[SELECTOR_SORT_NAME := DDB.AttributeValue.S(sortName)];
      }
    } else {
      for i := 0 to |keys|
      {
        var key : UTF8.ValidUTF8Bytes := keys[i];
        if SE.EC_ATTR_PREFIX < key {
          attrMap :- AddAttributeToMap(key, context[key], attrMap);
        }
      }
    }
    return Success(attrMap);
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
