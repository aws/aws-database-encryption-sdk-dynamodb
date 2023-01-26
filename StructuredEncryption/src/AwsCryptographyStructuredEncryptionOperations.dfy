// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../Model/AwsCryptographyStructuredEncryptionTypes.dfy"
include "../../private-aws-encryption-sdk-dafny-staging/AwsCryptographicMaterialProviders/test/TestUtils.dfy"
include "Header.dfy"

module AwsCryptographyStructuredEncryptionOperations refines AbstractAwsCryptographyStructuredEncryptionOperations {
  import Base64
  import CMP = AwsCryptographyMaterialProvidersTypes
  import Random
  import Aws.Cryptography.Primitives
  import Header
  import MaterialProviders
  import TestUtils

  datatype Config = Config(
    primatives : Primitives.AtomicPrimitivesClient
  )

  type InternalConfig = Config

  // UTF-8 encoded "THIS_IS_NOT_ENCRYPTED"
  // TODO this is temporary, only used for our "fake" encryption
  // in order to make it clear that the value is not actually being encrypted yet.
  const THIS_IS_NOT_ENCRYPTED: UTF8.ValidUTF8Bytes :=
    var s := [0x54, 0x48, 0x49, 0x53, 0x5f, 0x49, 0x53, 0x5f, 0x4e, 0x4f, 0x54, 0x5f, 0x45, 0x4e, 0x43, 0x52, 0x59, 0x50, 0x54, 0x45, 0x44];
    assert UTF8.ValidUTF8Range(s, 0, 21);
    s

  // TODO: This is temporary in order to support "fake" encryption with DDB,
  // which is a placeholder to demonstrate the crypto schema is piping to this
  // layer as expected when testing end to end with the DDB Encryption interceptor.
  const DDB_STRING_TYPE_ID: UTF8.ValidUTF8Bytes :=
    var s := [0x00, 0x01];
    assert UTF8.ValidUTF8Range(s, 0, 2);
    s

  predicate ValidInternalConfig?(config: InternalConfig)
  {config.primatives.ValidState()}

  function ModifiesInternalConfig(config: InternalConfig) : set<object>
  {config.primatives.Modifies}

  predicate EncryptStructureEnsuresPublicly(
    input: EncryptStructureInput, 
    output: Result<EncryptStructureOutput, Error>) {
      // Input and output types must be the same, and this constraint is useful to Dafny users
    && (output.Success? && input.plaintextStructure.content.DataMap? ==> output.value.encryptedStructure.content.DataMap?)
    && (output.Success? && input.plaintextStructure.content.DataList? ==> output.value.encryptedStructure.content.DataList?)
    && (output.Success? && input.plaintextStructure.content.Terminal? ==> output.value.encryptedStructure.content.Terminal?)
  }

  method GetMaterials() returns (ret : Result<CMP.EncryptionMaterials, Error>)
  {
    var mplR := MaterialProviders.MaterialProviders();
    var mpl :- mplR.MapFailure(e => AwsCryptographyMaterialProviders(e));

    var namespace, name := TestUtils.NamespaceAndName(0);
    var rawAESKeyringR := mpl.CreateRawAesKeyring(CMP.CreateRawAesKeyringInput(
      keyNamespace := namespace,
      keyName := name,
      wrappingKey := seq(32, i => 0),
      wrappingAlg := CMP.ALG_AES256_GCM_IV12_TAG16
    ));
    var rawAESKeyring :- rawAESKeyringR.MapFailure(e => AwsCryptographyMaterialProviders(e));
    var encryptionContext := TestUtils.SmallEncryptionContext(TestUtils.SmallEncryptionContextVariation.A);

    var algorithmSuiteId := CMP.AlgorithmSuiteId.ESDK(CMP.ALG_AES_256_GCM_IV12_TAG16_NO_KDF);
    var encryptionMaterialsInR := mpl.InitializeEncryptionMaterials(
      CMP.InitializeEncryptionMaterialsInput(
        algorithmSuiteId := algorithmSuiteId,
        encryptionContext := encryptionContext,
        signingKey := None,
        verificationKey := None
      )
    );
    var encryptionMaterialsIn :- encryptionMaterialsInR.MapFailure(e => AwsCryptographyMaterialProviders(e));
    var encryptionMaterialsOutR := rawAESKeyring.OnEncrypt( 
      CMP.OnEncryptInput(materials:=encryptionMaterialsIn)
    );
    var encryptionMaterialsOut :- encryptionMaterialsOutR.MapFailure(e => AwsCryptographyMaterialProviders(e));

    return Success(encryptionMaterialsOut.materials);
  }

  method EncryptStructure(config: InternalConfig, input: EncryptStructureInput)
    returns (output: Result<EncryptStructureOutput, Error>)
  {
    var mat :- GetMaterials();
    //= specification/structured-encryption/header.md#message-id
    //# Implementations MUST generate a fresh 256-bit random MessageID for each record encrypted. 
    var randBytes := Random.GenerateBytes(32);
    var msgID :- randBytes.MapFailure(e => Error.AwsCryptographyPrimitives(e));
    var head :- Header.Create(input.cryptoSchema, msgID, mat.encryptionContext, mat.encryptedDataKeys);

    // TODO: Currently implemented with "fake" encryption for ddb items.
    // For each attribute that should be encrypted:
    // - Concatenate typeId and value
    // - Base64 encode
    // - Concatenate THIS_IS_NOT_ENCRYPTED and output of the above
    // - Create a new 'Terminal' with typeId 0x0001 (to be interpreted as string in DDB)
    //   and value of the output of the above
    :- Need(input.plaintextStructure.content.DataMap?
        && input.cryptoSchema.content.SchemaMap?, StructuredEncryptionException(
      message := "Unexpected Structured Data Item. Currently only implemented to accept DDB Items."
    ));
    
    // Iterate through presumed DDB Item's attributes to perform "fake" encryption
    var cryptoSchema := input.cryptoSchema.content.SchemaMap;
    var ddbItem := input.plaintextStructure.content.DataMap;
    var attributeValues := map[];
    while cryptoSchema.Keys != {}
    {
      var attributeName :| attributeName in cryptoSchema;
      :- Need(cryptoSchema[attributeName].content.Action?
        && attributeName in ddbItem
        && ddbItem[attributeName].content.Terminal?, StructuredEncryptionException(
        message := "Unexpected Structured Data Item. Currently only implemented to accept DDB Items."
      ));
      if (cryptoSchema[attributeName].content.Action == CryptoAction.ENCRYPT_AND_SIGN) {
        var attributeValue := ddbItem[attributeName].content.Terminal;
        var concatValue := attributeValue.typeId + attributeValue.value;
        var base64Value := Base64.Encode(concatValue);
        var base64ValueAsBytes := UTF8.EncodeAscii(base64Value);
        var finalValue := THIS_IS_NOT_ENCRYPTED + base64ValueAsBytes;
        var transformedAttribute := StructuredData(
          content := StructuredDataContent.Terminal(
            Terminal := StructuredDataTerminal(
              typeId := DDB_STRING_TYPE_ID,
              value := finalValue
            )
          ),
          attributes := None
        );
        attributeValues := attributeValues[attributeName:=transformedAttribute];
      } else {
        // passthrough
        attributeValues := attributeValues[attributeName:=ddbItem[attributeName]];
      }

      cryptoSchema := cryptoSchema - {attributeName};
    }
    var headerSerialized :- Header.FullSerialize(config.primatives, head);
    var headerString := Base64.Encode(headerSerialized);
    var headerBytes := UTF8.EncodeAscii(headerString);
    var headerAttribute := StructuredData(
      content := StructuredDataContent.Terminal(
        Terminal := StructuredDataTerminal(
          typeId := DDB_STRING_TYPE_ID,
          value := headerBytes
        )
      ),
      attributes := None
    );
    //attributeValues := attributeValues["aws_ddb_head" := headerAttribute];

    // TODO call configured cmm to obtain materials after deserializing info from header

    var encryptOutput := EncryptStructureOutput(encryptedStructure := StructuredData(
      content := StructuredDataContent.DataMap(
        DataMap := attributeValues
      ),
      attributes := None
    ));
    output := Success(encryptOutput);
  }

  predicate DecryptStructureEnsuresPublicly(
    input: DecryptStructureInput, 
    output: Result<DecryptStructureOutput, Error>) {
      // Input and output types must be the same, and this constraint is useful to Dafny users
    && (output.Success? && input.encryptedStructure.content.DataMap? ==> output.value.plaintextStructure.content.DataMap?)
    && (output.Success? && input.encryptedStructure.content.DataList? ==> output.value.plaintextStructure.content.DataList?)
    && (output.Success? && input.encryptedStructure.content.Terminal? ==> output.value.plaintextStructure.content.Terminal?)
}
  
  method DecryptStructure(config: InternalConfig, input: DecryptStructureInput)
      returns (output: Result<DecryptStructureOutput, Error>)
  {
    // TODO: Currently implemented with "fake" decryption for ddb itmes. This is currently brittle,
    // but for now is useful to demonstrate that the attribute actions are being properly piped
    // through the system.
    :- Need(input.encryptedStructure.content.DataMap?, StructuredEncryptionException(
      message := "Unexpected Structured Data Item. Currently only implemented to accept DDB Items."
    ));
    
    // Iterate through presumed DDB Item's attributes to perform "fake" encryption
    var cryptoSchema := input.encryptedStructure.content.DataMap;
    var attributeValues := map[];
    while cryptoSchema.Keys != {}
    {
      var attributeName :| attributeName in cryptoSchema;
      :- Need(cryptoSchema[attributeName].content.Terminal?, StructuredEncryptionException(
        message := "Unexpected Structured Data Item. Currently only implemented to accept DDB Items."
      ));
      var attributeValue := cryptoSchema[attributeName].content.Terminal;
      // Since we are not storing the cryptoSchema that was used on encrypt,
      // for our "fake" approach simply look for attributes that appear to be
      // "fake" encrypted. Anyone testing integration with this fake encryption
      // MUST NOT use the value "THIS_IS_NOT_ENCRYPTED" in their data set.
      if (attributeValue.typeId == DDB_STRING_TYPE_ID
          && |attributeValue.value| >= |THIS_IS_NOT_ENCRYPTED|
          && attributeValue.value[..|THIS_IS_NOT_ENCRYPTED|] == THIS_IS_NOT_ENCRYPTED) {
        // To "fake" decrypt:
        // - String "THIS_IS_NOT_ENCRYPTED"
        // - Base64 Decode the rest
        // - Grab the first two bytes as typeId, the rest are the serialized value
        var base64Value := attributeValue.value[|THIS_IS_NOT_ENCRYPTED|..];
        var base64AsChar :- UTF8.Decode(base64Value)
            .MapFailure(e => Types.StructuredEncryptionException( message := e ));
        var concatValue :- Base64.Decode(base64AsChar)
            .MapFailure(e => Types.StructuredEncryptionException( message := e ));
        :- Need(|concatValue| >= 2, StructuredEncryptionException(
          message := "Invalid 'fake' encryption: Missing typeId"
        ));
        var originalTypeId := concatValue[..2];
        var originalValue := concatValue[2..];
        var untransformedAttribute := StructuredData(
          content := StructuredDataContent.Terminal(
            Terminal := StructuredDataTerminal(
              typeId := originalTypeId,
              value := originalValue
            )
          ),
          attributes := None
        );
        attributeValues := attributeValues[attributeName:=untransformedAttribute];
      } else {
        // else it is not "fake" encrypted, so pass through
        attributeValues := attributeValues[attributeName:=cryptoSchema[attributeName]];
      }

      cryptoSchema := cryptoSchema - {attributeName};
    }
    var decryptOutput := DecryptStructureOutput(plaintextStructure := StructuredData(
      content := StructuredDataContent.DataMap(
        DataMap := attributeValues
      ),
      attributes := None
    ));
    output := Success(decryptOutput);
  }
}
