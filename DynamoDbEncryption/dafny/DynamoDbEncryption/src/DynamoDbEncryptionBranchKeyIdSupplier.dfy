// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "DynamoToStruct.dfy"
include "Util.dfy"

module DynamoDbEncryptionBranchKeyIdSupplier {
  import opened AwsCryptographyDynamoDbEncryptionTypes
  import MPL = AwsCryptographyMaterialProvidersTypes
  import DDB = ComAmazonawsDynamodbTypes
  import opened Seq
  import opened Wrappers
  import opened StandardLibrary.UInt
  import DynamoToStruct
  import Base64
  import DynamoDbEncryptionUtil

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
      var partitionECKey := DynamoDbEncryptionUtil.DDBEC_EC_ATTR_PREFIX + MPL_EC_PARTITION_NAME;
      :- Need(partitionECKey in context.Keys,
        MPL.AwsCryptographicMaterialProvidersException(
          message := "Invalid encryption context: Missing partition name"));
      attrMap :- AddAttributeToMap(partitionECKey, context[partitionECKey], attrMap);

      // Add sort key to map if it exists
      var sortECKey := DynamoDbEncryptionUtil.DDBEC_EC_ATTR_PREFIX + MPL_EC_SORT_NAME;
      if sortECKey in context.Keys {
        attrMap :- AddAttributeToMap(sortECKey, context[sortECKey], attrMap);
      }
        
      // Get branch key id from these DDB attributes
      var branchKeyIdR := ddbKeyBranchKeyIdSupplier.GetBranchKeyIdFromDdbKey(
            GetBranchKeyIdFromDdbKeyInput(ddbKey := attrMap)
          );
      var branchKeyIdOut :- branchKeyIdR.MapFailure(ConvertToMplError);

      return Success(MPL.GetBranchKeyIdOutput(branchKeyId:=branchKeyIdOut.branchKeyId));
    }
  }

  method AddAttributeToMap(ddbAttrKey: seq<uint8>, encodedAttrValue: seq<uint8>, attrMap: DDB.AttributeMap)
      returns (res: Result<DDB.AttributeMap, MPL.Error>) 
    requires |ddbAttrKey| > |DynamoDbEncryptionUtil.DDBEC_EC_ATTR_PREFIX|
  {
    // Obtain attribute name from EC kvPair key
    var ddbAttrNameBytes := ddbAttrKey[|DynamoDbEncryptionUtil.DDBEC_EC_ATTR_PREFIX|..];
    var ddbAttrName :- UTF8.Decode(ddbAttrNameBytes)
        .MapFailure(e => MPL.AwsCryptographicMaterialProvidersException(message:=e));
    :- Need(DDB.IsValid_AttributeName(ddbAttrName),
        MPL.AwsCryptographicMaterialProvidersException(
          message := "Invalid serialization of DDB Attribute in encryption context."));

    // Obtain attribute value from EC kvPair value
    var utf8DecodedVal :- UTF8.Decode(encodedAttrValue)
        .MapFailure(e => MPL.AwsCryptographicMaterialProvidersException(message:=e));
    var base64DecodedVal :- Base64.Decode(utf8DecodedVal)
        .MapFailure(e => MPL.AwsCryptographicMaterialProvidersException(message:=e));
    :- Need(|base64DecodedVal| >= 2,
        MPL.AwsCryptographicMaterialProvidersException(
          message := "Invalid serialization of DDB Attribute in encryption context."));
    var typeId := base64DecodedVal[..2];
    var serializedValue := base64DecodedVal[2..];
    var ddbAttrValue :- DynamoToStruct.BytesToAttr(serializedValue, typeId, false)
        .MapFailure(e => MPL.AwsCryptographicMaterialProvidersException(message:=e));

    // Add to our AttributeMap
    return Success(attrMap[ddbAttrName := ddbAttrValue.val]);
  }
  
  function method ConvertToMplError(err: Error)
    :(ret: MPL.Error)
  {
    if err.DynamoDbEncryptionException? then
      MPL.AwsCryptographicMaterialProvidersException(message:=err.message)
    else
      // We expect this interface to be implemented in the native language,
      // so any other error is unexpected.
      MPL.AwsCryptographicMaterialProvidersException(message:="Unexpected error while getting Branch Key ID.")
  }
}
