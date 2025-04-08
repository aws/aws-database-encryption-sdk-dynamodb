// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Index.dfy"

module DynamoDbEncryptionBranchKeyIdSupplierTest {
  import opened Wrappers
  import opened StandardLibrary.UInt
  import MaterialProviders
  import DynamoDbEncryption
  import Types = AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import MPL = AwsCryptographyMaterialProvidersTypes
  import KMS = Com.Amazonaws.Kms
  import DDB = Com.Amazonaws.Dynamodb
  import UTF8
  import CSE = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import SE = StructuredEncryptionUtil
  import Base64
  import KeyStore
  import KeyStoreTypes = AwsCryptographyKeyStoreTypes

  const TEST_DBE_ALG_SUITE_ID := MPL.AlgorithmSuiteId.DBE(MPL.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384)

  // THIS IS A TESTING RESOURCE DO NOT USE IN A PRODUCTION ENVIRONMENT
  const keyArn := "arn:aws:kms:us-west-2:370957321024:key/9d989aa2-2f9c-438c-a745-cc57d3ad0126"
  const branchKeyStoreName := "KeyStoreDdbTable"
  const logicalKeyStoreName := branchKeyStoreName

  // These tests require a keystore populated with a key with this Id
  const BRANCH_KEY_ID := "3f43a9af-08c5-4317-b694-3d3e883dcaef"
  const BRANCH_KEY_ID_UTF8 := UTF8.EncodeAscii(BRANCH_KEY_ID)
  const ALTERNATE_BRANCH_KEY_ID := "4bb57643-07c1-419e-92ad-0df0df149d7c"

  // Constants for TestBranchKeySupplier
  const BRANCH_KEY := "branchKey"
  const STRING_TYPE_ID: seq<uint8> := [0x00, 0x01]
  const CASE_A := "CASE_A"
  const CASE_B := "CASE_B"
  // "CASE_A" encoded as a DDB S
  const CASE_A_BYTES: seq<uint8> := STRING_TYPE_ID + [0x43, 0x41, 0x53, 0x45, 0x5f, 0x41]
  // "CASE_B" encoded as a DDB S
  const CASE_B_BYTES: seq<uint8> := STRING_TYPE_ID + [0x43, 0x41, 0x53, 0x45, 0x5f, 0x42]
  const BRANCH_KEY_ID_A := BRANCH_KEY_ID
  const BRANCH_KEY_ID_B := ALTERNATE_BRANCH_KEY_ID
  const EC_PARTITION_NAME := UTF8.EncodeAscii("aws-crypto-partition-name")
  const RESERVED_PREFIX := "aws-crypto-attr."
  const KEY_ATTR_NAME := UTF8.EncodeAscii(RESERVED_PREFIX + BRANCH_KEY)
  const BRANCH_KEY_NAME := UTF8.EncodeAscii(BRANCH_KEY)

  method {:test} {:vcs_split_on_every_assert} TestHappyCase()
  {
    var ddbKeyToBranchKeyId: Types.IDynamoDbKeyBranchKeyIdSupplier := new TestBranchKeyIdSupplier();
    var ddbEncResources :- expect DynamoDbEncryption.DynamoDbEncryption();
    var branchKeyIdSupplierOut :- expect ddbEncResources.CreateDynamoDbEncryptionBranchKeyIdSupplier(
      Types.CreateDynamoDbEncryptionBranchKeyIdSupplierInput(
        ddbKeyBranchKeyIdSupplier := ddbKeyToBranchKeyId
      )
    );
    var branchKeyIdSupplier := branchKeyIdSupplierOut.branchKeyIdSupplier;

    var ttl : int64 := (1 * 60000) * 10;
    var mpl :- expect MaterialProviders.MaterialProviders();
    var kmsClient :- expect KMS.KMSClient();
    var dynamodbClient :- expect DDB.DynamoDBClient();
    var kmsConfig := KeyStoreTypes.KMSConfiguration.kmsKeyArn(keyArn);
    var keyStoreConfig := KeyStoreTypes.KeyStoreConfig(
      id := None,
      kmsConfiguration := kmsConfig,
      logicalKeyStoreName := logicalKeyStoreName,
      grantTokens := None,
      ddbTableName := branchKeyStoreName,
      ddbClient := Some(dynamodbClient),
      kmsClient := Some(kmsClient)
    );
    var keyStore :- expect KeyStore.KeyStore(keyStoreConfig);
    var hierarchyKeyring :- expect mpl.CreateAwsKmsHierarchicalKeyring(
      MPL.CreateAwsKmsHierarchicalKeyringInput(
        branchKeyId := None,
        branchKeyIdSupplier := Some(branchKeyIdSupplier),
        keyStore := keyStore,
        ttlSeconds := ttl,
        cache := None
      )
    );


    // Test Encryption Context with Case A
    var materials :- expect mpl.InitializeEncryptionMaterials(
      MPL.InitializeEncryptionMaterialsInput(
        algorithmSuiteId := TEST_DBE_ALG_SUITE_ID,
        encryptionContext := map[EC_PARTITION_NAME := BRANCH_KEY_NAME],
        requiredEncryptionContextKeys := [],
        signingKey := None,
        verificationKey := None
      )
    );

    var caseA :- expect UTF8.Encode(Base64.Encode(CASE_A_BYTES));
    var contextCaseA := materials.encryptionContext[KEY_ATTR_NAME := caseA];
    var materialsA := materials.(encryptionContext := contextCaseA);
    TestRoundtrip(hierarchyKeyring, materialsA, TEST_DBE_ALG_SUITE_ID, BRANCH_KEY_ID_A);

    // Test Encryption Context with Case B
    var caseB :- expect UTF8.Encode(Base64.Encode(CASE_B_BYTES));
    var contextCaseB := materials.encryptionContext[KEY_ATTR_NAME := caseB];
    var materialsB := materials.(encryptionContext := contextCaseB);
    TestRoundtrip(hierarchyKeyring, materialsB, TEST_DBE_ALG_SUITE_ID, BRANCH_KEY_ID_B);
  }

  method TestRoundtrip(
    hierarchyKeyring: MPL.IKeyring,
    encryptionMaterialsIn: MPL.EncryptionMaterials,
    algorithmSuiteId: MPL.AlgorithmSuiteId,
    expectedBranchKeyId: string
  )
    requires hierarchyKeyring.ValidState()
    modifies hierarchyKeyring.Modifies
    ensures hierarchyKeyring.ValidState()
  {
    var encryptionMaterialsOut :- expect hierarchyKeyring.OnEncrypt(
      MPL.OnEncryptInput(materials:=encryptionMaterialsIn)
    );

    var mpl :- expect MaterialProviders.MaterialProviders();
    var _ :- expect mpl.EncryptionMaterialsHasPlaintextDataKey(encryptionMaterialsOut.materials);

    expect |encryptionMaterialsOut.materials.encryptedDataKeys| == 1;

    var edk := encryptionMaterialsOut.materials.encryptedDataKeys[0];

    // Verify the edk was created with the expected branch key
    var expectedBranchKeyIdUTF8 :- expect UTF8.Encode(expectedBranchKeyId);
    expect edk.keyProviderInfo == expectedBranchKeyIdUTF8;

    var decryptionMaterialsIn :- expect mpl.InitializeDecryptionMaterials(
      MPL.InitializeDecryptionMaterialsInput(
        algorithmSuiteId := algorithmSuiteId,
        encryptionContext := encryptionMaterialsIn.encryptionContext,
        requiredEncryptionContextKeys := []
      )
    );
    var decryptionMaterialsOut :- expect hierarchyKeyring.OnDecrypt(
      MPL.OnDecryptInput(
        materials:=decryptionMaterialsIn,
        encryptedDataKeys:=[edk]
      )
    );

    expect encryptionMaterialsOut.materials.plaintextDataKey
        == decryptionMaterialsOut.materials.plaintextDataKey;
  }

  // returns "branchKeyIdA" when item contains "branchKey":"caseA"
  // returns "branchKeyIdB" when item contains "branchKey":"caseB"
  // otherwise returns a Failure
  class TestBranchKeyIdSupplier extends Types.IDynamoDbKeyBranchKeyIdSupplier
  {
    predicate ValidState()
      ensures ValidState() ==> History in Modifies
    {
      History in Modifies
    }

    constructor()
      ensures ValidState() && fresh(this) && fresh(History) && fresh(Modifies)
    {
      History := new Types.IDynamoDbKeyBranchKeyIdSupplierCallHistory();
      Modifies := {History};
    }

    predicate GetBranchKeyIdFromDdbKeyEnsuresPublicly(input: Types.GetBranchKeyIdFromDdbKeyInput, output: Result<Types.GetBranchKeyIdFromDdbKeyOutput, Types.Error>)
    {true}

    method GetBranchKeyIdFromDdbKey'(input: Types.GetBranchKeyIdFromDdbKeyInput)
      returns (output: Result<Types.GetBranchKeyIdFromDdbKeyOutput, Types.Error>)
      requires ValidState()
      modifies Modifies - {History}
      decreases Modifies - {History}
      ensures ValidState()
      ensures GetBranchKeyIdFromDdbKeyEnsuresPublicly(input, output)
      ensures unchanged(History)
    {
      var item := input.ddbKey;

      if BRANCH_KEY in item.Keys && item[BRANCH_KEY].S? && item[BRANCH_KEY].S == CASE_A {
        return Success(Types.GetBranchKeyIdFromDdbKeyOutput(branchKeyId:=BRANCH_KEY_ID_A));
      } else if BRANCH_KEY in item.Keys && item[BRANCH_KEY].S? && item[BRANCH_KEY].S == CASE_B {
        return Success(Types.GetBranchKeyIdFromDdbKeyOutput(branchKeyId:=BRANCH_KEY_ID_B));
      } else {
        return Failure(Types.DynamoDbEncryptionException(message := "Can't determine branchKeyId from item"));
      }
    }
  }
}
