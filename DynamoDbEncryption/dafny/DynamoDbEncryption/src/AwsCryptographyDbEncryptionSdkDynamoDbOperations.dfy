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
  import opened DynamoDbEncryptionUtil

  import Header = StructuredEncryptionHeader

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
    ensures output.Success? ==> (    
      match input.input {
        case plaintextItem(item) => 
          DynamoToStruct.ItemToStructured(item).Success?
          && var extracted := DynamoToStruct.ItemToStructured(item).Extract();
          && var keys := extracted.Keys;
          && "aws_dbe_head" in DynamoToStruct.ItemToStructured(item).Extract()
          && var header := DynamoToStruct.ItemToStructured(item).Extract()["aws_dbe_head"].content.Terminal.value;
          && Header.PartialDeserialize(header).Success?
        case header(header) => 
          Header.PartialDeserialize(header).Success?
      }
    )
  {
    var header;
    match input.input
    {
      case plaintextItem(plaintextItem) =>{
        :- Need(DynamoToStruct.ItemToStructured(plaintextItem).Success?, E("Failed to convert AttributeMap to StructuredDataMap."));
        :- Need("aws_dbe_head" in DynamoToStruct.ItemToStructured(plaintextItem).Extract(), E("aws_dbe_head is not present in the attribute map."));
        header := DynamoToStruct.ItemToStructured(plaintextItem).Extract()["aws_dbe_head"].content.Terminal.value;
      }
      case header(headeritem) =>
        header := headeritem;
    }
    :- Need(Header.PartialDeserialize(header).Success?, E("Failed to deserialize header."));
    var deserializedHeader := Header.PartialDeserialize(header);
    var algorithmSuite;
    
    if deserializedHeader.Extract().flavor == 0{
      algorithmSuite := AlgorithmSuites.DBE_ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384;
    } else {
      algorithmSuite := AlgorithmSuites.DBE_ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384;
    }

    var datakeys := deserializedHeader.Extract().dataKeys;
    var list : EncryptedDataKeyDescriptionList := [];
    for i := 0 to |datakeys| {
      var singleDataKeyOutput : EncryptedDataKeyDescriptionOutput;
      
      :- Need(UTF8.Decode(datakeys[i].keyProviderId).Success?, E("Failed to extract keyProviderId."));
      :- Need(UTF8.Decode(datakeys[i].keyProviderInfo).Success?, E("Failed to extract keyProviderInfo."));

      var extractedKeyProviderId := UTF8.Decode(datakeys[i].keyProviderId).Extract();
      var extractedKeyProviderIdInfo := UTF8.Decode(datakeys[i].keyProviderInfo).Extract();

      if |extractedKeyProviderId| < 7 || extractedKeyProviderId[0..7] != "aws-kms" {
        singleDataKeyOutput := EncryptedDataKeyDescriptionOutput(
          keyProviderId := extractedKeyProviderId,
          keyProviderInfo := None, 
          branchKeyId := None,
          branchKeyVersion := None
        );
      }
      if extractedKeyProviderId == "aws-kms-hierarchy" {
        :- Need(EdkWrapping.GetProviderWrappedMaterial(datakeys[i].ciphertext, algorithmSuite).Success?, E("Failed to get provider wrapped material."));
        
        var providerWrappedMaterial := EdkWrapping.GetProviderWrappedMaterial(datakeys[i].ciphertext, algorithmSuite).Extract();

        // The ciphertext structure in the hierarchy keyring contains Salt and IV before Version.
        // The length of Salt is 16 and IV is 12 bytes. The length of Version is 16 bytes.
        // https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/aws-kms/aws-kms-hierarchical-keyring.md#ciphertext
        
        var EDK_CIPHERTEXT_BRANCH_KEY_VERSION_INDEX := 12 + 16;
        var EDK_CIPHERTEXT_VERSION_INDEX := EDK_CIPHERTEXT_BRANCH_KEY_VERSION_INDEX + 16;

        :- Need(EDK_CIPHERTEXT_BRANCH_KEY_VERSION_INDEX < EDK_CIPHERTEXT_VERSION_INDEX, E("Wrong branch key version index."));
        :- Need(|providerWrappedMaterial| >= EDK_CIPHERTEXT_VERSION_INDEX, E("Incorrect ciphertext structure length."));
        var branchKeyVersionUuid := providerWrappedMaterial[EDK_CIPHERTEXT_BRANCH_KEY_VERSION_INDEX .. EDK_CIPHERTEXT_VERSION_INDEX];
        
        :- Need(UUID.FromByteArray(branchKeyVersionUuid).Success?, E("Failed to convert UUID from byte array."));
        var expectedBranchKeyVersion := UUID.FromByteArray(branchKeyVersionUuid).Extract();

        singleDataKeyOutput := EncryptedDataKeyDescriptionOutput(
          keyProviderId := extractedKeyProviderId,
          keyProviderInfo := Some(extractedKeyProviderIdInfo), 
          branchKeyId := Some(extractedKeyProviderIdInfo),
          branchKeyVersion := Some(expectedBranchKeyVersion)
        );
      }
      else {
        singleDataKeyOutput := EncryptedDataKeyDescriptionOutput(
          keyProviderId := extractedKeyProviderId,
          keyProviderInfo := Some(extractedKeyProviderIdInfo), 
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
