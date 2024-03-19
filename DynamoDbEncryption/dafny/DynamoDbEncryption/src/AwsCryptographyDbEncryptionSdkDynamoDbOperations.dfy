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
          "aws_dbe_head" in DynamoToStruct.ItemToStructured(item).Extract().Keys
          && Header.PartialDeserialize(DynamoToStruct.ItemToStructured(item).Extract()["aws_dbe_head"].content.Terminal.value).Success?
        case header(header) => 
          Header.PartialDeserialize(header).Success?
      }
    )
  {
    var header;
    match input.input
    {
      case plaintextItem(plaintextItem) =>{
        header := DynamoToStruct.ItemToStructured(plaintextItem).Extract()["aws_dbe_head"].content.Terminal.value;
      }
      case header(headeritem) => {
        header := headeritem;
      } 
    }
    var deserializedHeader := Header.PartialDeserialize(header);
    print deserializedHeader;

    var algorithmSuite;
    if deserializedHeader.Extract().flavor == 0{
      algorithmSuite := AlgorithmSuites.DBE_ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384;
    }
    else{
      algorithmSuite := AlgorithmSuites.DBE_ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384;
    }

    var datakeys := deserializedHeader.Extract().dataKeys;
    var list : EncryptedDataKeyDescriptionList;
    for i := 0 to |datakeys| {
      var singleDataKeyOutput : EncryptedDataKeyDescriptionOutput;
      if UTF8.Decode(datakeys[i].keyProviderId).Extract() == "aws-kms-hierarchy" {

        var providerWrappedMaterial := EdkWrapping.GetProviderWrappedMaterial(datakeys[i].ciphertext, algorithmSuite).Extract();

        var EDK_CIPHERTEXT_BRANCH_KEY_VERSION_INDEX := 12 + 16;
        var EDK_CIPHERTEXT_VERSION_INDEX := EDK_CIPHERTEXT_BRANCH_KEY_VERSION_INDEX + 16;

        var branchKeyVersionUuid := providerWrappedMaterial[EDK_CIPHERTEXT_BRANCH_KEY_VERSION_INDEX .. EDK_CIPHERTEXT_VERSION_INDEX];
      
        singleDataKeyOutput := EncryptedDataKeyDescriptionOutput(
          keyProviderId := UTF8.Decode(datakeys[i].keyProviderId).Extract(),
          keyProviderInfo := UTF8.Decode(datakeys[i].keyProviderInfo).Extract(), 
          branchKeyId := Some(UTF8.Decode(datakeys[i].keyProviderInfo).Extract()),
          branchKeyVersion := Some(UUID.FromByteArray(branchKeyVersionUuid).Extract())
        );
      }
      else {
        singleDataKeyOutput := EncryptedDataKeyDescriptionOutput(
          keyProviderId := UTF8.Decode(datakeys[i].keyProviderId).Extract(),
          keyProviderInfo := UTF8.Decode(datakeys[i].keyProviderInfo).Extract(), 
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
