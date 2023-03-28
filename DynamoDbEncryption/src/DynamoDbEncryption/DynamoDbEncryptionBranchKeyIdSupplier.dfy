// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../DynamoDbItemEncryptor/DynamoToStruct.dfy"
include "../../Model/AwsCryptographyDynamoDbEncryptionTypes.dfy"

module DynamoDbEncryptionBranchKeyIdSupplier {
  import opened AwsCryptographyDynamoDbEncryptionTypes
  import MPL = AwsCryptographyMaterialProvidersTypes
  import DDB = ComAmazonawsDynamodbTypes
  import opened Seq
  import opened Wrappers
  import DynamoToStruct
  import Base64

  class DynamoDbEncryptionBranchKeyIdSupplier
    extends MPL.IBranchKeyIdSupplier
  {
    const ddbItemBranchKeyIdSupplier: IDynamoDbItemBranchKeyIdSupplier

    predicate ValidState()
      ensures ValidState() ==> History in Modifies
    {
      && History in Modifies
      && ddbItemBranchKeyIdSupplier.ValidState()
      && ddbItemBranchKeyIdSupplier.Modifies <= Modifies
      && History !in ddbItemBranchKeyIdSupplier.Modifies
    }

    constructor(
      ddbItemBranchKeyIdSupplier: IDynamoDbItemBranchKeyIdSupplier
    )
      requires ddbItemBranchKeyIdSupplier.ValidState()
      ensures this.ddbItemBranchKeyIdSupplier == ddbItemBranchKeyIdSupplier
      ensures ValidState() && fresh(this) && fresh(History) && fresh(Modifies - ddbItemBranchKeyIdSupplier.Modifies)
    {
      this.ddbItemBranchKeyIdSupplier := ddbItemBranchKeyIdSupplier;
      History := new MPL.IBranchKeyIdSupplierCallHistory();
      Modifies := {History} + ddbItemBranchKeyIdSupplier.Modifies;
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
      // Get encoded SIGN_ONLY DDB attributes from encryption context
      var context := input.encryptionContext;
      var prefix := UTF8.EncodeAscii("aws-crypto-attr.");

      var attrMap: DDB.AttributeMap := map[];

      var ddbAttrKeys := set k <- context.Keys | prefix < k :: k;
      var s' := ddbAttrKeys;
      while s' != {}
        invariant s' <= ddbAttrKeys
        decreases s'
      {
        var ddbAttrKey :| ddbAttrKey in s';
        var encodedAttrValue := context[ddbAttrKey];

        // Obtain attribute name from EC kvPair key
        var ddbAttrNameBytes := ddbAttrKey[|prefix|..];
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
        attrMap := attrMap[ddbAttrName := ddbAttrValue.val];

        // Pop 'tableName' off the map, so that we may continue iterating
        s' := set k' | k' in s' && k' != ddbAttrKey :: k';
      }

      // Get branch key id from these DDB attributes
      var branchKeyIdR := ddbItemBranchKeyIdSupplier.GetBranchKeyIdFromItem(
            GetBranchKeyIdFromItemInput(ddbItem := attrMap)
          );
      var branchKeyIdOut :- branchKeyIdR.MapFailure(ConvertToMplError);

      return Success(MPL.GetBranchKeyIdOutput(branchKeyId:=branchKeyIdOut.branchKeyId));
    }
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
