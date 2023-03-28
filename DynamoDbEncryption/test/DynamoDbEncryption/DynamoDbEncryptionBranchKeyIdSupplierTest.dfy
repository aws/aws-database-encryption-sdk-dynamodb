// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../../../submodules/MaterialProviders/StandardLibrary/src/StandardLibrary.dfy"
include "../../src/DynamoDbEncryption/Index.dfy"
include "../../Model/AwsCryptographyDynamoDbEncryptionTypes.dfy"
include "../../../submodules/MaterialProviders/ComAmazonawsDynamodb/Model/ComAmazonawsDynamodbTypes.dfy"
include "../../../submodules/MaterialProviders/AwsCryptographicMaterialProviders/Model/AwsCryptographyMaterialProvidersTypes.dfy"
include "../TestFixtures.dfy"

module DynamoDbEncryptionBranchKeyIdSupplierTest {
  import opened Wrappers
  import opened StandardLibrary.UInt
  import MaterialProviders
  import DynamoDbEncryption
  import Types = AwsCryptographyDynamoDbEncryptionTypes
  import MPL = AwsCryptographyMaterialProvidersTypes
  import KMS = Com.Amazonaws.Kms
  import DDB = Com.Amazonaws.Dynamodb
  import UTF8
  import TestFixtures
  import CSE = AwsCryptographyStructuredEncryptionTypes
  import SE = StructuredEncryptionUtil
  import Base64

  const TEST_DBE_ALG_SUITE_ID := MPL.AlgorithmSuiteId.DBE(MPL.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384);

  // THIS IS A TESTING RESOURCE DO NOT USE IN A PRODUCTION ENVIRONMENT
  const keyArn := "arn:aws:kms:us-west-2:370957321024:key/9d989aa2-2f9c-438c-a745-cc57d3ad0126";
  const branchKeyStoreArn := "arn:aws:dynamodb:us-west-2:370957321024:table/HierarchicalKeyringTestTable";

  // These tests require a keystore populated with a key with this Id
  const BRANCH_KEY_ID := "hierarchy-test-v1";
  const BRANCH_KEY_ID_UTF8 := UTF8.EncodeAscii("hierarchy-test-v1");
  const ACTIVE_ACTIVE_BRANCH_KEY_ID := "hierarchy-test-active-active";

  // Constants for TestBranchKeySupplier
  const BRANCH_KEY := "branchKey";
  const STRING_TYPE_ID: seq<uint8> := [0x00, 0x01];
  const CASE_A := "CASE_A";
  const CASE_B := "CASE_B";
  // "CASE_A" encoded as a DDB S
  const CASE_A_BYTES: seq<uint8> := STRING_TYPE_ID + [0x43, 0x41, 0x53, 0x45, 0x5f, 0x41];
  // "CASE_B" encoded as a DDB S
  const CASE_B_BYTES: seq<uint8> := STRING_TYPE_ID + [0x43, 0x41, 0x53, 0x45, 0x5f, 0x42];
  const BRANCH_KEY_ID_A := BRANCH_KEY_ID
  const BRANCH_KEY_ID_B := ACTIVE_ACTIVE_BRANCH_KEY_ID
  const RESERVED_PREFIX := "aws-crypto-attr.";

  method {:test} TestHappyCase() 
  {
    var ddbItemToBranchKeyId: Types.IDynamoDbItemBranchKeyIdSupplier := new TestBranchKeyIdSupplier();
    var ddbEncResources :- expect DynamoDbEncryption.DynamoDbEncryption();
    var branchKeyIdSupplierOut :- expect ddbEncResources.CreateDynamoDbEncryptionBranchKeyIdSupplier(
      Types.CreateDynamoDbEncryptionBranchKeyIdSupplierInput(
        ddbItemBranchKeyIdSupplier := ddbItemToBranchKeyId
      )
    );
    var branchKeyIdSupplier := branchKeyIdSupplierOut.branchKeyIdSupplier;

    var ttl : int64 := (1 * 60000) * 10;
    var mpl :- expect MaterialProviders.MaterialProviders();
    var kmsClient :- expect KMS.KMSClient();
    var dynamodbClient :- expect DDB.DynamoDBClient();
    var hierarchyKeyring :- expect mpl.CreateAwsKmsHierarchicalKeyring(
      MPL.CreateAwsKmsHierarchicalKeyringInput(
        branchKeyId := None,
        branchKeyIdSupplier := Some(branchKeyIdSupplier),
        kmsKeyId := keyArn,
        kmsClient := kmsClient,
        ddbClient := dynamodbClient,
        branchKeyStoreArn := branchKeyStoreArn,
        ttlSeconds := ttl,
        maxCacheSize := Option.Some(10),
        grantTokens := Option.None
      )
    );

    var keyAttrName := UTF8.EncodeAscii(RESERVED_PREFIX + BRANCH_KEY);
    
    // Test Encryption Context with Case A
    var materials :- expect mpl.InitializeEncryptionMaterials(
      MPL.InitializeEncryptionMaterialsInput(
        algorithmSuiteId := TEST_DBE_ALG_SUITE_ID,
        encryptionContext := map[],
        requiredEncryptionContextKeys := [],
        signingKey := None,
        verificationKey := None
      )
    );
    var caseA :- expect UTF8.Encode(Base64.Encode(CASE_A_BYTES));
    var contextCaseA := materials.encryptionContext[keyAttrName := caseA];
    var materialsA := materials.(encryptionContext := contextCaseA);
    TestRoundtrip(hierarchyKeyring, materialsA, TEST_DBE_ALG_SUITE_ID, BRANCH_KEY_ID_A); 

    // Test Encryption Context with Case B
    var caseB :- expect UTF8.Encode(Base64.Encode(CASE_B_BYTES));
    var contextCaseB := materials.encryptionContext[keyAttrName := caseB];
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

    //= compliance/framework/raw-aes-keyring.txt#2.7.2
    //= type=test
    //# If a decryption succeeds, this keyring MUST add the resulting
    //# plaintext data key to the decryption materials and return the
    //# modified materials.
    expect encryptionMaterialsOut.materials.plaintextDataKey
    == decryptionMaterialsOut.materials.plaintextDataKey;
  }

  // returns "branchKeyIdA" when item contains "branchKey":"caseA"
  // returns "branchKeyIdB" when item contains "branchKey":"caseB"
  // otherwise returns a Failure
  class TestBranchKeyIdSupplier extends Types.IDynamoDbItemBranchKeyIdSupplier
  {
    predicate ValidState()
      ensures ValidState() ==> History in Modifies
    {
      History in Modifies
    }

    constructor()
      ensures ValidState() && fresh(this) && fresh(History) && fresh(Modifies)
    {
      History := new Types.IDynamoDbItemBranchKeyIdSupplierCallHistory();
      Modifies := {History};
    }

    predicate GetBranchKeyIdFromItemEnsuresPublicly(input: Types.GetBranchKeyIdFromItemInput, output: Result<Types.GetBranchKeyIdFromItemOutput, Types.Error>)
    {true}

    method GetBranchKeyIdFromItem'(input: Types.GetBranchKeyIdFromItemInput)
        returns (output: Result<Types.GetBranchKeyIdFromItemOutput, Types.Error>)
      requires ValidState()
      modifies Modifies - {History}
      decreases Modifies - {History}
      ensures ValidState()
      ensures GetBranchKeyIdFromItemEnsuresPublicly(input, output)
      ensures unchanged(History)
    {
      var item := input.ddbItem;

      if BRANCH_KEY in item.Keys && item[BRANCH_KEY].S? && item[BRANCH_KEY].S == CASE_A {
        return Success(Types.GetBranchKeyIdFromItemOutput(branchKeyId:=BRANCH_KEY_ID_A));
      } else if BRANCH_KEY in item.Keys && item[BRANCH_KEY].S? && item[BRANCH_KEY].S == CASE_B {
        return Success(Types.GetBranchKeyIdFromItemOutput(branchKeyId:=BRANCH_KEY_ID_B));
      } else {
        return Failure(Types.DynamoDbEncryptionException(message := "Can't determine branchKeyId from item"));
      }
    }
  }
}
