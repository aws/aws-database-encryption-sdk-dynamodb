// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../../DynamoDbItemEncryptor/src/Util.dfy"

module DynamoDbEncryptionBranchKeyIdSupplier {
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import opened Wrappers
  import MPL = AwsCryptographyMaterialProvidersTypes
  import DynamoDbItemEncryptorUtil

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
      var attrMapR := DynamoDbItemEncryptorUtil.ConvertContextForSelector(input.encryptionContext);
      var attrMap :- attrMapR.MapFailure(e => MPL.AwsCryptographicMaterialProvidersException(message:=e));

      // Get branch key id from these DDB attributes
      var branchKeyIdR := ddbKeyBranchKeyIdSupplier.GetBranchKeyIdFromDdbKey(
        GetBranchKeyIdFromDdbKeyInput(ddbKey := attrMap)
      );
      //= specification/dynamodb-encryption-client/ddb-encryption-branch-key-id-supplier.md#behavior
      //# - Otherwise, this operation MUST fail.
      var branchKeyIdOut :- branchKeyIdR.MapFailure(ConvertToMplError);

      //= specification/dynamodb-encryption-client/ddb-encryption-branch-key-id-supplier.md#behavior
      //# - If successful, the resulting string MUST be outputted by this operation.
      return Success(MPL.GetBranchKeyIdOutput(branchKeyId:=branchKeyIdOut.branchKeyId));
    }
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
