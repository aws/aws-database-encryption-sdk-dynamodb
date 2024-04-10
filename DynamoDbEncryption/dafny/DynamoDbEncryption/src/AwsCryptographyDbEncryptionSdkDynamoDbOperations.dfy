// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../Model/AwsCryptographyDbEncryptionSdkDynamoDbTypes.dfy"
include "DynamoDbEncryptionBranchKeyIdSupplier.dfy"

module AwsCryptographyDbEncryptionSdkDynamoDbOperations refines AbstractAwsCryptographyDbEncryptionSdkDynamoDbOperations {
  import DynamoDbEncryptionBranchKeyIdSupplier
  import EdkWrapping
  import UUID
  import AlgorithmSuites
  import DynamoToStruct
  import Header = StructuredEncryptionHeader
  import opened DynamoDbEncryptionUtil

  const SALT_LENGTH := 16
  const IV_LENGTH := 12
  const VERSION_LENGTH := 16

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
      case plaintextItem(plaintextItem) =>{
        :- Need(DynamoToStruct.ItemToStructured(plaintextItem).Success?, E("Failed to convert AttributeMap to StructuredDataMap."));
        :- Need("aws_dbe_head" in DynamoToStruct.ItemToStructured(plaintextItem).Extract(), E("aws_dbe_head is not present in the attribute map."));
        header := DynamoToStruct.ItemToStructured(plaintextItem).Extract()["aws_dbe_head"].content.Terminal.value;
      }
      case header(headerItem) =>
        header := headerItem;
    }
    var deserializedHeader :- Header.PartialDeserialize(header).MapFailure(e => E("Failed to deserialize header."));
    var datakeys := deserializedHeader.dataKeys;
    var list : EncryptedDataKeyDescriptionList := [];
    for i := 0 to |datakeys| {
      var singleDataKeyOutput : EncryptedDataKeyDescriptionOutput;
      var extractedKeyProviderId :- UTF8.Decode(datakeys[i].keyProviderId).MapFailure(e => E(e));
      if !("aws-kms" < extractedKeyProviderId) {
        singleDataKeyOutput := EncryptedDataKeyDescriptionOutput(
          keyProviderId := extractedKeyProviderId,
          keyProviderInfo := None,
          branchKeyId := None,
          branchKeyVersion := None
        );
      }

      // Format flavor is either 0 or 1
      // https://github.com/aws/aws-database-encryption-sdk-dynamodb/blob/main/specification/structured-encryption/header.md#format-flavor
      :- Need(deserializedHeader.flavor == 0 || deserializedHeader.flavor == 1, E("Invalid format flavor."));
      var algorithmSuite;
      if deserializedHeader.flavor == 0{
        algorithmSuite := AlgorithmSuites.DBE_ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384;
      } else {
        algorithmSuite := AlgorithmSuites.DBE_ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384;
      }

      :- Need(UTF8.Decode(datakeys[i].keyProviderInfo).Success?, E("Failed to extract keyProviderInfo."));
      var extractedKeyProviderIdInfo := UTF8.Decode(datakeys[i].keyProviderInfo).MapFailure(e => E("Failed to deserialize header."));

      if extractedKeyProviderId == "aws-kms-hierarchy" {
        var providerWrappedMaterial :- EdkWrapping.GetProviderWrappedMaterial(datakeys[i].ciphertext, algorithmSuite).MapFailure(e => E("Failed to get provider wrapped material" ));

        // The ciphertext structure in the hierarchy keyring contains Salt and IV before Version.
        // The length of Salt is 16 and IV is 12 bytes. The length of Version is 16 bytes.
        // https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/aws-kms/aws-kms-hierarchical-keyring.md#ciphertext
        var EDK_CIPHERTEXT_BRANCH_KEY_VERSION_INDEX := SALT_LENGTH + IV_LENGTH;
        var EDK_CIPHERTEXT_VERSION_INDEX := EDK_CIPHERTEXT_BRANCH_KEY_VERSION_INDEX + VERSION_LENGTH;
        :- Need(EDK_CIPHERTEXT_BRANCH_KEY_VERSION_INDEX < EDK_CIPHERTEXT_VERSION_INDEX, E("Wrong branch key version index."));
        :- Need(|providerWrappedMaterial| >= EDK_CIPHERTEXT_VERSION_INDEX, E("Incorrect ciphertext structure length."));
        var branchKeyVersionUuid := providerWrappedMaterial[EDK_CIPHERTEXT_BRANCH_KEY_VERSION_INDEX .. EDK_CIPHERTEXT_VERSION_INDEX];
        var expectedBranchKeyVersion :- UUID.FromByteArray(branchKeyVersionUuid).MapFailure(e => E("Failed to convert UUID from byte array."));
        singleDataKeyOutput := EncryptedDataKeyDescriptionOutput(
          keyProviderId := extractedKeyProviderId,
          keyProviderInfo := Some(extractedKeyProviderIdInfo.value),
          branchKeyId := Some(extractedKeyProviderIdInfo.value),
          branchKeyVersion := Some(expectedBranchKeyVersion)
        );
      }
      else {
        singleDataKeyOutput := EncryptedDataKeyDescriptionOutput(
          keyProviderId := extractedKeyProviderId,
          keyProviderInfo := Some(extractedKeyProviderIdInfo.value),
          branchKeyId := None,
          branchKeyVersion := None
        );
      }
      list := list + [singleDataKeyOutput];
    }

    output := Success(GetEncryptedDataKeyDescriptionOutput(
                        EncryptedDataKeyDescriptionOutput := list
                      ));
  }
}
