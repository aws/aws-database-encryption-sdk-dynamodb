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
  import StructuredEncryptionUtil
  import SortedSets

  const MPL_EC_PARTITION_NAME: UTF8.ValidUTF8Bytes := UTF8.EncodeAscii("aws-crypto-partition-name")
  const MPL_EC_SORT_NAME: UTF8.ValidUTF8Bytes := UTF8.EncodeAscii("aws-crypto-sort-name")

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

        // Add partition key to map
      :- Need(MPL_EC_PARTITION_NAME in context.Keys,
              MPL.AwsCryptographicMaterialProvidersException(
                message := "Invalid encryption context: Missing partition name"));

      var keys : seq<UTF8.ValidUTF8Bytes> := SortedSets.ComputeSetToOrderedSequence2(context.Keys, StructuredEncryptionUtil.ByteLess);
      for i := 0 to |keys|
        invariant ValidState()
      {
        var key : UTF8.ValidUTF8Bytes := keys[i];
        if StructuredEncryptionUtil.SE_EC_ATTR_PREFIX < key {
          attrMap :- AddAttributeToMap(key, context[key], attrMap);
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

  function method AddAttributeToMap(ddbAttrKey: UTF8.ValidUTF8Bytes, encodedAttrValue: UTF8.ValidUTF8Bytes, attrMap: DDB.AttributeMap)
    : (res: Result<DDB.AttributeMap, MPL.Error>)
    requires |ddbAttrKey| >= |StructuredEncryptionUtil.SE_EC_ATTR_PREFIX|
  {
    // Obtain attribute name from EC kvPair key
    var ddbAttrNameBytes := ddbAttrKey[|StructuredEncryptionUtil.SE_EC_ATTR_PREFIX|..];
    var ddbAttrName :- UTF8.Decode(ddbAttrNameBytes)
                       .MapFailure(e => MPL.AwsCryptographicMaterialProvidersException(message:=e));
    :- Need(DDB.IsValid_AttributeName(ddbAttrName),
            MPL.AwsCryptographicMaterialProvidersException(
              message := "Invalid serialization of DDB Attribute in encryption context."));

    // Obtain attribute value from EC kvPair value
    var terminal :- StructuredEncryptionUtil.DecodeTerminal(encodedAttrValue)
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
}
