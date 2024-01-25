// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "DynamoToStruct.dfy"
include "Util.dfy"

module DynamoDbEncryptionBranchKeyIdSupplier {
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import MPL = AwsCryptographyMaterialProvidersTypes
  import DDB = ComAmazonawsDynamodbTypes
  import opened Seq
  import opened Wrappers
  import opened StandardLibrary.UInt
  import DynamoToStruct
  import Base64
  import DynamoDbEncryptionUtil
  import SE = StructuredEncryptionUtil
  import SortedSets

  const MPL_EC_PARTITION_NAME: UTF8.ValidUTF8Bytes := UTF8.EncodeAscii("aws-crypto-partition-name")
  const MPL_EC_SORT_NAME: UTF8.ValidUTF8Bytes := UTF8.EncodeAscii("aws-crypto-sort-name")

    function method ToError(e : string) : MPL.Error
    {
      MPL.AwsCryptographicMaterialProvidersException(message:=e)
    }

    function method Utf8Decode(x : seq<uint8>) : Result<string, MPL.Error>
    {
      UTF8.Decode(x).MapFailure(e => ToError(e))
    }

  class DynamoDbEncryptionBranchKeyIdSupplier
    extends MPL.IBranchKeyIdSupplier
    {
    const ddbKeyBranchKeyIdSupplier: IDynamoDbKeyBranchKeyIdSupplier

    predicate ValidState()
      ensures ValidState() ==> History in Modifies
    {
      && History in Modifies
      && ddbKeyBranchKeyIdSupplier.ValidState()
      && ddbKeyBranchKeyIdSupplier.Modifies <= Modifies
      && History !in ddbKeyBranchKeyIdSupplier.Modifies
    }

    constructor(
      ddbKeyBranchKeyIdSupplier: IDynamoDbKeyBranchKeyIdSupplier
    )
      requires ddbKeyBranchKeyIdSupplier.ValidState()
      ensures this.ddbKeyBranchKeyIdSupplier == ddbKeyBranchKeyIdSupplier
      ensures ValidState() && fresh(this) && fresh(History) && fresh(Modifies - ddbKeyBranchKeyIdSupplier.Modifies)
    {
      this.ddbKeyBranchKeyIdSupplier := ddbKeyBranchKeyIdSupplier;
      History := new MPL.IBranchKeyIdSupplierCallHistory();
      Modifies := {History} + ddbKeyBranchKeyIdSupplier.Modifies;
    }

    predicate GetBranchKeyIdEnsuresPublicly(input: MPL.GetBranchKeyIdInput, output: Result<MPL.GetBranchKeyIdOutput, MPL.Error>)
    {true}

    function method GetLiteralValue(x : seq<uint8>) : Result<DDB.AttributeValue, MPL.Error>
    {
      var str :- Utf8Decode(x);
      match str {
        case "true" => Success(DDB.AttributeValue.BOOL(true))
        case "false" => Success(DDB.AttributeValue.BOOL(false))
        case "null" => Success(DDB.AttributeValue.NULL(false))
        case _ => Failure(ToError("Encryption Context literal value has unexpected value : '" + str + "'."))
      }
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

    method GetBranchKeyId'(input: MPL.GetBranchKeyIdInput)
      returns (output: Result<MPL.GetBranchKeyIdOutput, MPL.Error>)
      requires ValidState()
      modifies Modifies - {History}
      decreases Modifies - {History}
      ensures ValidState()
      ensures GetBranchKeyIdEnsuresPublicly(input, output)
      ensures unchanged(History)
    {
      var context := input.encryptionContext;
      var attrMap: DDB.AttributeMap := map[];

      :- Need(MPL_EC_PARTITION_NAME in context.Keys,
              ToError("Invalid encryption context: Missing partition name"));

      var keys : seq<UTF8.ValidUTF8Bytes> := SortedSets.ComputeSetToOrderedSequence2(context.Keys, SE.ByteLess);

      if SE.LEGEND_UTF8 in context {
        var legend :- Utf8Decode(context[SE.LEGEND_UTF8]);

        var attrPos := 0;
        for i := 0 to |keys|
          invariant ValidState()
          invariant attrPos <= i
        {
          var key : UTF8.ValidUTF8Bytes := keys[i];
          if SE.EC_ATTR_PREFIX < key {
            :- Need(|legend| > attrPos, ToError("Encryption Context Legend is too short."));
            var ddbAttrName :- GetAttributeName(key);
            match legend[attrPos] {
              case 'S' =>
                var value :- Utf8Decode(context[key]);
                attrMap := attrMap[ddbAttrName := DDB.AttributeValue.S(value)];
              case 'N' =>
                var value :- Utf8Decode(context[key]);
                attrMap := attrMap[ddbAttrName := DDB.AttributeValue.N(value)];
              case 'L' =>
                var value :- GetLiteralValue(context[key]);
                attrMap := attrMap[ddbAttrName := value];
              case 'B' => attrMap :- AddAttributeToMap(key, context[key], attrMap);
              case _ => return Failure(ToError("Encryption Context Legend has unexpected character : '" + [legend[attrPos]] + "'."));
            }
            attrPos := attrPos + 1;
          }
        }
        :- Need(|legend| == attrPos, ToError("Encryption Context Legend is too long."));

        :- Need(TABLE_NAME in context, ToError("Internal error, table name not in encryption context."));
        var tableName :- Utf8Decode(context[TABLE_NAME]);
        attrMap := attrMap[SELECTOR_TABLE_NAME := DDB.AttributeValue.S(tableName)];

        :- Need(PARTITION_NAME in context, ToError("Internal error, table name not in encryption context."));
        var partitionName :- Utf8Decode(context[PARTITION_NAME]);
        attrMap := attrMap[SELECTOR_PARTITION_NAME := DDB.AttributeValue.S(partitionName)];

        if SORT_NAME in context {
          var sortName :- Utf8Decode(context[SORT_NAME]);
          attrMap := attrMap[SELECTOR_SORT_NAME := DDB.AttributeValue.S(sortName)];
        }
      } else {
        for i := 0 to |keys|
          invariant ValidState()
        {
          var key : UTF8.ValidUTF8Bytes := keys[i];
          if SE.EC_ATTR_PREFIX < key {
            attrMap :- AddAttributeToMap(key, context[key], attrMap);
          }
        }
      }

      // Get branch key id from these DDB attributes
      var branchKeyIdR := ddbKeyBranchKeyIdSupplier.GetBranchKeyIdFromDdbKey(
        GetBranchKeyIdFromDdbKeyInput(ddbKey := attrMap)
      );
      var branchKeyIdOut :- branchKeyIdR.MapFailure(ConvertToMplError);

      return Success(MPL.GetBranchKeyIdOutput(branchKeyId:=branchKeyIdOut.branchKeyId));
    }
  }

  function method GetAttributeName(ddbAttrKey: UTF8.ValidUTF8Bytes)
    : (res: Result<DDB.AttributeName, MPL.Error>)
    requires |ddbAttrKey| >= |SE.EC_ATTR_PREFIX|
  {
    // Obtain attribute name from EC kvPair key
    var ddbAttrNameBytes := ddbAttrKey[|SE.EC_ATTR_PREFIX|..];
    var ddbAttrName :- Utf8Decode(ddbAttrNameBytes);
    :- Need(DDB.IsValid_AttributeName(ddbAttrName), ToError("Invalid serialization of DDB Attribute in encryption context."));
    Success(ddbAttrName)
  }
  function method AddAttributeToMap(ddbAttrKey: UTF8.ValidUTF8Bytes, encodedAttrValue: UTF8.ValidUTF8Bytes, attrMap: DDB.AttributeMap)
    : (res: Result<DDB.AttributeMap, MPL.Error>)
    requires |ddbAttrKey| >= |SE.EC_ATTR_PREFIX|
  {
    var ddbAttrName :- GetAttributeName(ddbAttrKey);

    // Obtain attribute value from EC kvPair value
    var terminal :- SE.DecodeTerminal(encodedAttrValue)
                    .MapFailure(e => MPL.AwsCryptographicMaterialProvidersException(message:=e));
    var ddbAttrValue :- DynamoToStruct.BytesToAttr(terminal.value, terminal.typeId, false)
                        .MapFailure(e => MPL.AwsCryptographicMaterialProvidersException(message:=e));

    // Add to our AttributeMap
    Success(attrMap[ddbAttrName := ddbAttrValue.val])
  }

  function method ConvertToMplError(err: Error)
    :(ret: MPL.Error)
  {
    // We expect this interface to be implemented in the native language,
    // so any errors thrown by the native implementation will appear as Opaque errors
    if err.Opaque? then
      MPL.Opaque(obj:=err.obj)
    else
      MPL.AwsCryptographicMaterialProvidersException(message:="Unexpected error while getting Branch Key ID.")
  }

  const CHAR_A : char := 'A'
const CHAR_B : char := 'B'

function Thing1(x : char) : int
{
  match x {
    case 'A' => 1
    case 'B' => 2
    case _ => 3
  }
}

function Thing2(x : char) : int
{
  match x {
    case CHAR_A => 1
    case CHAR_B => 2
    case _ => 3
  }
}

lemma foo()
  ensures(Thing1('A') == Thing2('A'))
  ensures(Thing1('B') == Thing2('B'))
  ensures(Thing1('C') == Thing2('C'))
{}

}
