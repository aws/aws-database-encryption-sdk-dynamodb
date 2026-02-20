// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../Model/AwsCryptographyDbEncryptionSdkDynamoDbTypes.dfy"
include "DynamoDbEncryptionBranchKeyIdSupplier.dfy"

module AwsCryptographyDbEncryptionSdkDynamoDbOperations refines AbstractAwsCryptographyDbEncryptionSdkDynamoDbOperations {
  import DynamoDbEncryptionBranchKeyIdSupplier
  import EdkWrapping
  import UUID
  import AlgorithmSuites
  import Header = StructuredEncryptionHeader
  import opened DynamoDbEncryptionUtil
  import opened StandardLibrary.MemoryMath

  const SALT_LENGTH : uint64 := 16
  const IV_LENGTH : uint64 := 12
  const VERSION_LENGTH : uint64 := 16

  predicate ValidInternalConfig?(config: InternalConfig)
  {true}

  function ModifiesInternalConfig(config: InternalConfig) : set<object>
  { {} }

  datatype Config = Config(
                    )

  type InternalConfig = Config

  predicate CreateDynamoDbEncryptionBranchKeyIdSupplierEnsuresPublicly(input: CreateDynamoDbEncryptionBranchKeyIdSupplierInput , output: Result<CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, Error>)
  {true}

  method CreateDynamoDbEncryptionBranchKeyIdSupplier(
    config: InternalConfig,
    input: CreateDynamoDbEncryptionBranchKeyIdSupplierInput
  ) returns (output: Result<CreateDynamoDbEncryptionBranchKeyIdSupplierOutput, Error>) {
    var supplier := new DynamoDbEncryptionBranchKeyIdSupplier.DynamoDbEncryptionBranchKeyIdSupplier(
      input.ddbKeyBranchKeyIdSupplier
    );
    return Success(
        CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(
          branchKeyIdSupplier := supplier
        )
      );
  }

  predicate GetEncryptedDataKeyDescriptionEnsuresPublicly(input: GetEncryptedDataKeyDescriptionInput , output: Result<GetEncryptedDataKeyDescriptionOutput, Error>)
  {true}

  method GetEncryptedDataKeyDescription(config: InternalConfig, input: GetEncryptedDataKeyDescriptionInput)
    returns (output: Result<GetEncryptedDataKeyDescriptionOutput, Error>)
    ensures GetEncryptedDataKeyDescriptionEnsuresPublicly(input, output)
  {
    var header;
    match input.input
    {
      //= specification/dynamodb-encryption-client/ddb-get-encrypted-data-key-description.md#behavior
      //# - If the input is an encrypted DynamoDB item, it MUST attempt to extract "aws_dbe_head" attribute from the DynamoDB item to get the binary header.
      case item(item) =>{
        :- Need("aws_dbe_head" in item && item["aws_dbe_head"].B?, E("Header not found in the DynamoDB item."));
        header := item["aws_dbe_head"].B;
      }
      case header(headerItem) =>
        header := headerItem;
    }
    //= specification/dynamodb-encryption-client/ddb-get-encrypted-data-key-description.md#behavior
    //# - This operation MUST deserialize the header bytes according to the header format.
    var deserializedHeader :- Header.PartialDeserialize(header).MapFailure(e => AwsCryptographyDbEncryptionSdkStructuredEncryption(e));
    //= specification/dynamodb-encryption-client/ddb-get-encrypted-data-key-description.md#behavior
    //# - This operation MUST extract the dataKeys from the deserialize header.
    var datakeys := deserializedHeader.dataKeys;
    var list : EncryptedDataKeyDescriptionList := [];
    //= specification/dynamodb-encryption-client/ddb-get-encrypted-data-key-description.md#behavior
    //# - For every Data Key in Data Keys, the operation MUST attempt to extract a description of the Data Key.
    for i : uint64 := 0 to |datakeys| as uint64 {
      var extractedKeyProviderId :- UTF8.Decode(datakeys[i].keyProviderId).MapFailure(e => E(e));
      var extractedKeyProviderIdInfo:= Option.None;
      var expectedBranchKeyVersion := Option.None;
      if ("aws-kms" <= extractedKeyProviderId) {
        :- Need(deserializedHeader.flavor == 0 || deserializedHeader.flavor == 1, E("Invalid format flavor."));
        var algorithmSuite;
        //= specification/dynamodb-encryption-client/ddb-get-encrypted-data-key-description.md#behavior
        //# - This operation MUST extract the Format Flavor from the deserialize header.
        if deserializedHeader.flavor == 0{
          algorithmSuite := AlgorithmSuites.DBE_ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384;
        } else {
          algorithmSuite := AlgorithmSuites.DBE_ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384;
        }
        var maybeKeyProviderIdInfo :- UTF8.Decode(datakeys[i].keyProviderInfo).MapFailure(e => E(e));
        extractedKeyProviderIdInfo := Some(maybeKeyProviderIdInfo);
        if extractedKeyProviderId == "aws-kms-hierarchy" {
          var providerWrappedMaterial :- EdkWrapping.GetProviderWrappedMaterial(datakeys[i].ciphertext, algorithmSuite).MapFailure(e => AwsCryptographyMaterialProviders(e));
          var EDK_CIPHERTEXT_BRANCH_KEY_VERSION_INDEX := SALT_LENGTH + IV_LENGTH;
          var EDK_CIPHERTEXT_VERSION_INDEX := EDK_CIPHERTEXT_BRANCH_KEY_VERSION_INDEX + VERSION_LENGTH;
          :- Need(EDK_CIPHERTEXT_BRANCH_KEY_VERSION_INDEX < EDK_CIPHERTEXT_VERSION_INDEX, E("Wrong branch key version index."));
          SequenceIsSafeBecauseItIsInMemory(providerWrappedMaterial);
          :- Need(|providerWrappedMaterial| as uint64 >= EDK_CIPHERTEXT_VERSION_INDEX, E("Incorrect ciphertext structure length."));
          var branchKeyVersionUuid := providerWrappedMaterial[EDK_CIPHERTEXT_BRANCH_KEY_VERSION_INDEX .. EDK_CIPHERTEXT_VERSION_INDEX];
          var maybeBranchKeyVersion :- UUID.FromByteArray(branchKeyVersionUuid).MapFailure(e => E(e));
          expectedBranchKeyVersion := Some(maybeBranchKeyVersion);
        }
      }
      var singleDataKeyOutput := EncryptedDataKeyDescription(
        keyProviderId := extractedKeyProviderId,
        keyProviderInfo := extractedKeyProviderIdInfo,
        branchKeyId := extractedKeyProviderIdInfo,
        branchKeyVersion := expectedBranchKeyVersion
      );
      list := list + [singleDataKeyOutput];
    }

    output := Success(GetEncryptedDataKeyDescriptionOutput(
                        EncryptedDataKeyDescriptionOutput := list
                      ));
  }
}
