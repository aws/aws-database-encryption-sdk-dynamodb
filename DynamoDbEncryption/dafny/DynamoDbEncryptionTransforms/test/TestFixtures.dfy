// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Index.dfy"

module TestFixtures {
  import opened Wrappers
  import opened StandardLibrary
  import opened UInt = StandardLibrary.UInt
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes
  import opened AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import DynamoDbEncryptionTransforms
  import DynamoDbItemEncryptor
  import AwsCryptographyMaterialProvidersTypes
  import MaterialProviders
  import CSE = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import DDB = ComAmazonawsDynamodbTypes

  method GetTableName(s : string) returns (output : DDB.TableName)
  {
    expect DDB.IsValid_TableName(s);
    return s;
  }
  method GetAttrName(s : string) returns (output : DDB.AttributeName)
  {
    expect DDB.IsValid_AttributeName(s);
    return s;
  }
  method GetStatement(s : string) returns (output : DDB.PartiQLStatement)
  {
    expect DDB.IsValid_PartiQLStatement(s);
    return s;
  }
  method GetPStatements(s : seq<DDB.ParameterizedStatement>) returns (output : DDB.ParameterizedStatements)
  {
    expect DDB.IsValid_ParameterizedStatements(s);
    return s;
  }

  method GetTransactWriteItemList(s : seq<DDB.TransactWriteItem>) returns (output : DDB.TransactWriteItemList)
  {
    expect DDB.IsValid_TransactWriteItemList(s);
    return s;
  }
  method GetBatchWriteItemRequestMap(s : map<DDB.TableName, DDB.WriteRequests>) returns (output : DDB.BatchWriteItemRequestMap)
  {
    expect DDB.IsValid_BatchWriteItemRequestMap(s);
    return s;
  }
  method GetWriteRequests(s : seq<DDB.WriteRequest>) returns (output : DDB.WriteRequests)
  {
    expect DDB.IsValid_WriteRequests(s);
    return s;
  }
  method GetBatchGetRequestMap(s : map<DDB.TableName, DDB.KeysAndAttributes>) returns (output : DDB.BatchGetRequestMap)
  {
    expect DDB.IsValid_BatchGetRequestMap(s);
    return s;
  }
  method GetKeyList(s : seq<DDB.Key>) returns (output : DDB.KeyList)
  {
    expect DDB.IsValid_KeyList(s);
    return s;
  }
  method GetTransactGetItemList(s : seq<DDB.TransactGetItem>) returns (output : DDB.TransactGetItemList)
  {
    expect DDB.IsValid_TransactGetItemList(s);
    return s;
  }
  method GetPartiQLBatchRequest(s : seq<DDB.BatchStatementRequest>) returns (output : DDB.PartiQLBatchRequest)
  {
    expect DDB.IsValid_PartiQLBatchRequest(s);
    return s;
  }

  const PUBLIC_US_WEST_2_KMS_TEST_KEY := "arn:aws:kms:us-west-2:658956600833:key/b3537ef1-d8dc-4780-9f5a-55776cbb2f7f"

  function method GetAttributeActions() : AttributeActions {
    map["bar" := CSE.SIGN_ONLY, "encrypt" := CSE.ENCRYPT_AND_SIGN, "sign" := CSE.SIGN_ONLY, "nothing" := CSE.DO_NOTHING]
  }
  function method GetV2AttributeActions() : AttributeActions {
    map["bar" := CSE.CONTEXT_AND_SIGN, "encrypt" := CSE.ENCRYPT_AND_SIGN, "sign" := CSE.CONTEXT_AND_SIGN, "nothing" := CSE.DO_NOTHING]
  }

  function method GetSignedAttributeActions() : AttributeActions {
    map["bar" := CSE.SIGN_ONLY, "encrypt" := CSE.ENCRYPT_AND_SIGN, "sign" := CSE.SIGN_ONLY]
  }

  method GetEncryptorConfigFromActions(actions : AttributeActions, sortKeyName : Option<DDB.KeySchemaAttributeName> := None) returns (output : DynamoDbItemEncryptorConfig) {
    var keyring := GetKmsKeyring();
    var logicalTableName := GetTableName("foo");
    output := DynamoDbItemEncryptorConfig(
      logicalTableName := logicalTableName,
      partitionKeyName := "bar",
      sortKeyName := sortKeyName,
      attributeActionsOnEncrypt := actions,
      allowedUnsignedAttributes := Some(["nothing"]),
      allowedUnsignedAttributePrefix := None,
      keyring := Some(keyring),
      cmm := None,
      algorithmSuiteId := None,
      plaintextOverride := None,
      legacyOverride := None
    );
  }

  method GetEncryptorConfig() returns (output : DynamoDbItemEncryptorConfig) {
    output := GetEncryptorConfigFromActions(GetAttributeActions());
  }

  method GetDynamoDbItemEncryptorFrom(config : DynamoDbItemEncryptorConfig)
    returns (encryptor: DynamoDbItemEncryptor.DynamoDbItemEncryptorClient)
    ensures encryptor.ValidState()
    ensures fresh(encryptor)
    ensures fresh(encryptor.Modifies)
  {
    var keyring := GetKmsKeyring();
    var encryptorConfig := DynamoDbItemEncryptorConfig(
      logicalTableName := config.logicalTableName,
      partitionKeyName := config.partitionKeyName,
      sortKeyName := config.sortKeyName,
      attributeActionsOnEncrypt := config.attributeActionsOnEncrypt,
      allowedUnsignedAttributes := config.allowedUnsignedAttributes,
      allowedUnsignedAttributePrefix := config.allowedUnsignedAttributePrefix,
      keyring := Some(keyring),
      cmm := None(),
      algorithmSuiteId := None(),
      legacyOverride := None(),
      plaintextOverride := None()
    );
    var encryptor2 : IDynamoDbItemEncryptorClient :- expect DynamoDbItemEncryptor.DynamoDbItemEncryptor(encryptorConfig);
    assert encryptor2 is DynamoDbItemEncryptor.DynamoDbItemEncryptorClient;
    encryptor := encryptor2 as DynamoDbItemEncryptor.DynamoDbItemEncryptorClient;
  }

  method GetDynamoDbItemEncryptor()
      returns (encryptor: DynamoDbItemEncryptor.DynamoDbItemEncryptorClient)
    ensures encryptor.ValidState()
    ensures fresh(encryptor)
    ensures fresh(encryptor.Modifies)
  {
    var config := GetEncryptorConfig();
    encryptor := GetDynamoDbItemEncryptorFrom(config);
  }


  method expect_ok<X>(tag : string, actual : Result<X, AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Error>)
    ensures actual.Success?
  {
    if actual.Failure? {
      print tag, "\t", actual;
    }
    expect actual.Success?;
  }
  method expect_equal<X(==)>(tag : string, actual : X, expected : X)
  {
    if actual != expected {
      print tag, "\texpected\n", expected, "\ngot\n", actual, "\n";
    }
    expect actual == expected;
  }

  method ExpectFailure<X>(ret : Result<X, AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Error>, s : string)
  {
    if !ret.Failure? {
      print "Got Success when expected failure ", s, "\n";
    }
    expect ret.Failure?;
    if !ret.error.DynamoDbEncryptionTransformsException? {
      print "Error type not DynamoDbEncryptionTransformsException : ", ret, "\n";
    }
    expect ret.error.DynamoDbEncryptionTransformsException?;
    if ret.error.message != s {
      print "Expected error message '", s, "' got message '", ret.error.message, "'\n";
    }
    expect ret.error.message == s;
  }

  method GetKmsKeyring()
      returns (keyring: AwsCryptographyMaterialProvidersTypes.IKeyring)
    ensures keyring.ValidState()
    ensures fresh(keyring)
    ensures fresh(keyring.Modifies)
  {
    var matProv :- expect MaterialProviders.MaterialProviders(MaterialProviders.DefaultMaterialProvidersConfig());
    var keyringInput := AwsCryptographyMaterialProvidersTypes.CreateAwsKmsMultiKeyringInput(
      generator := Some(PUBLIC_US_WEST_2_KMS_TEST_KEY),
      kmsKeyIds := None(),
      clientSupplier := None(),
      grantTokens := None()
    );
    keyring :- expect matProv.CreateAwsKmsMultiKeyring(keyringInput);
  }

  method GetStaticKeyring()
      returns (keyring: AwsCryptographyMaterialProvidersTypes.IKeyring)
    ensures keyring.ValidState()
    ensures fresh(keyring)
    ensures fresh(keyring.Modifies)
  {
    var matProv :- expect MaterialProviders.MaterialProviders();
    keyring :- expect matProv.CreateRawAesKeyring(
      AwsCryptographyMaterialProvidersTypes.CreateRawAesKeyringInput(
        keyNamespace := "foo",
        keyName := "bar",
        wrappingKey := seq(32, i => 0),
        wrappingAlg := AwsCryptographyMaterialProvidersTypes.ALG_AES256_GCM_IV12_TAG16
      )
    );
  }

  method GetDynamoDbEncryptionTransforms()
      returns (encryption: DynamoDbEncryptionTransforms.DynamoDbEncryptionTransformsClient)
    ensures encryption.ValidState()
    ensures fresh(encryption)
    ensures fresh(encryption.Modifies)
  {
    var keyring := GetKmsKeyring();
    var encryption2 : IDynamoDbEncryptionTransformsClient :- expect DynamoDbEncryptionTransforms.DynamoDbEncryptionTransforms(
      DynamoDbTablesEncryptionConfig(
        tableEncryptionConfigs := map[
          "foo" := DynamoDbTableEncryptionConfig(
            logicalTableName := "foo",
            partitionKeyName := "bar",
            sortKeyName := None(),
            attributeActionsOnEncrypt := map[
              "bar" := CSE.SIGN_ONLY,
              "sign" := CSE.SIGN_ONLY,
              "encrypt" := CSE.ENCRYPT_AND_SIGN,
              "plain" := CSE.DO_NOTHING
              ],
            allowedUnsignedAttributes := Some(["plain"]),
            allowedUnsignedAttributePrefix := None(),
            algorithmSuiteId := None(),
            keyring := Some(keyring),
            cmm := None(),
            search := None,
            legacyOverride := None,
            plaintextOverride := None
          )
        ]
      )
    );
    assert encryption2 is DynamoDbEncryptionTransforms.DynamoDbEncryptionTransformsClient;
    encryption := encryption2 as DynamoDbEncryptionTransforms.DynamoDbEncryptionTransformsClient;
    assume {:axiom} fresh(encryption.Modifies);
  }
}
