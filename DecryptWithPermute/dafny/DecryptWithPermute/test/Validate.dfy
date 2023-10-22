// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

/*
This test should be executed within a DB-ESDK 3.1 package,
to create example records that fail to decrypt.
*/

include "../src/Index.dfy"
include "../../../../DynamoDbEncryption/dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy"

module ValidateTests {
  import opened Wrappers
  import opened StandardLibrary.UInt
  import opened DynamoDbItemEncryptorUtil
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes
  import opened AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import opened AwsCryptographyDbEncryptionSdkDecryptWithPermuteTypes

  import DynamoDbPermuteDecryptor
  import MaterialProviders
  import opened DynamoDbItemEncryptor
  import AwsCryptographyMaterialProvidersTypes
  import Types = AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes
  import DDB = ComAmazonawsDynamodbTypes
  import TestFixtures
  import AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations
  import CSE = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import SE = StructuredEncryptionUtil
  import DDBE = AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import AlgorithmSuites
  import StandardLibrary.String
  import opened Com.Amazonaws.Dynamodb

  // round trip
  // encrypt => encrypted fields changed, others did not
  // various errors

  function method DDBS(x : string) : DDB.AttributeValue {
    DDB.AttributeValue.S(x)
  }

  method GetEncryptorConfig() returns (output : DynamoDbItemEncryptorConfig) {
    var keyring := TestFixtures.GetKmsKeyring();
    var logicalTableName := TestFixtures.GetTableName("SetTests");
    output := DynamoDbItemEncryptorConfig(
      logicalTableName := logicalTableName,
      partitionKeyName := "Name",
      sortKeyName := None(),
      attributeActionsOnEncrypt := map[
        "Name" := CSE.SIGN_ONLY,
        "Encrypted" := CSE.ENCRYPT_AND_SIGN,
        "TheSet" := CSE.SIGN_ONLY,
        "Set2" := CSE.SIGN_ONLY,
        "Set3" := CSE.SIGN_ONLY,
        "TheMap" := CSE.SIGN_ONLY,
        "TheList" := CSE.SIGN_ONLY
      ],
      allowedUnsignedAttributes := None(),
      allowedUnsignedAttributePrefix := None(),
      keyring := Some(keyring),
      cmm := None(),
      algorithmSuiteId := None(),
      plaintextOverride := None(),
      legacyOverride := None()
    );
  }

  method GetDynamoDbItemEncryptorFrom(config : DynamoDbItemEncryptorConfig)
    returns (encryptor: DynamoDbPermuteDecryptor.DynamoDbPermuteDecryptorClient)
    ensures encryptor.ValidState()
    ensures fresh(encryptor)
    ensures fresh(encryptor.Modifies)
  {
    var keyring := TestFixtures.GetKmsKeyring();
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
    encryptor :- expect DynamoDbPermuteDecryptor.DynamoDbPermuteDecryptor(DynamoDbPermuteDecryptorConfig(inner := encryptorConfig));
  }

  method GetDynamoDbItemEncryptor()
    returns (encryptor: DynamoDbPermuteDecryptor.DynamoDbPermuteDecryptorClient)
    ensures encryptor.ValidState()
    ensures fresh(encryptor)
    ensures fresh(encryptor.Modifies)
  {
    var config := GetEncryptorConfig();
    encryptor := GetDynamoDbItemEncryptorFrom(config);
  }

  function method MakeGetInput(name : string) : DDB.GetItemInput
  {
    DDB.GetItemInput(
      TableName := "SetTests",
      Key := map["Name" := DDB.AttributeValue.S(name)],
      AttributesToGet := None,
      ConsistentRead := Some(true),
      ReturnConsumedCapacity := None,
      ProjectionExpression := None,
      ExpressionAttributeNames := None
    )
  }

  datatype DecryptStatus = DecryptOk | DecryptBad

  method TestGet(
    client : DDB.IDynamoDBClient,
    encryptor : DynamoDbPermuteDecryptor.DynamoDbPermuteDecryptorClient,
    name : string,
    stat : DecryptStatus,
    permuted : bool
  )
    requires client.ValidState()
    ensures client.ValidState()
    modifies client.Modifies
    requires encryptor.ValidState()
    ensures encryptor.ValidState()
    modifies encryptor.Modifies
  {
    print "TestGet ", name, " ", stat, " ", permuted, "\n";
    var resp :- expect client.GetItem(MakeGetInput(name));
    expect resp.Item.Some?;

    var decryptRes := encryptor.PermuteDecrypt(
      PermuteDecryptInput(
        inner := Types.DecryptItemInput(encryptedItem:=resp.Item.value),
        maxSetSize := 7
      )
    );

    if stat == DecryptBad {
      if decryptRes.Success? {
        print("Accidental Success with " + name + "\n");
      }
      expect decryptRes.Failure?;
    } else {
      if decryptRes.Failure? {
        print("Accidental Failure with " + name + "\n");
        print "\n\n",decryptRes,"\n\n";
      }
      expect decryptRes.Success?;

      if permuted != decryptRes.value.didPermute {
        print(name + " expected didPermute " + (if permuted then "true" else "false") + " but got the opposite.\n");

      }
      expect permuted == decryptRes.value.didPermute;
    }
  }

  method TestNum32a1(
    client : DDB.IDynamoDBClient,
    encryptor : DynamoDbPermuteDecryptor.DynamoDbPermuteDecryptorClient
  )
    requires client.ValidState()
    ensures client.ValidState()
    modifies client.Modifies
    requires encryptor.ValidState()
    ensures encryptor.ValidState()
    modifies encryptor.Modifies
  {
    print "TestNum32a1\n";
    var resp :- expect client.GetItem(MakeGetInput("Num32a1"));
    expect resp.Item.Some?;
    expect "TheSet" in resp.Item.value;
    expect resp.Item.value["TheSet"].NS?;
    expect multiset(resp.Item.value["TheSet"].NS) == multiset(["1", "2", "3"]);
    var newItem := resp.Item.value["TheSet" := DDB.AttributeValue.NS(["1", "0002", "3"])];

    var decryptRes := encryptor.PermuteDecrypt(
      PermuteDecryptInput(
        inner := Types.DecryptItemInput(encryptedItem:=newItem),
        maxSetSize := 7
      )
    );

    if decryptRes.Failure? {
      print("Accidental Failure with TestNum32a1\n");
      print "\n\n",decryptRes,"\n\n";
    }
    expect decryptRes.Success?;

    if decryptRes.value.didPermute != true {
      print("TestNum32a1 expected didPermute of true but got the opposite.\n");
    }
    expect decryptRes.value.didPermute == true;
  }

  method {:test} TestValidate() {
    var encryptor := GetDynamoDbItemEncryptor();
    var client :- expect DDBClientForRegion("us-west-2");

    TestGet(client, encryptor, "BasicX", DecryptOk, false);
    TestGet(client, encryptor, "BasicXY", DecryptOk, false);
    TestGet(client, encryptor, "BasicXYZ", DecryptOk, false);
    TestGet(client, encryptor, "Num1", DecryptOk, false);
    TestGet(client, encryptor, "BinA", DecryptOk, false);
    TestGet(client, encryptor, "BinAB", DecryptOk, false);
    TestGet(client, encryptor, "BinABC", DecryptOk, false);
    TestGet(client, encryptor, "BasicE", DecryptOk, false);
    TestGet(client, encryptor, "BasicEX", DecryptOk, false);
    TestGet(client, encryptor, "BinE", DecryptOk, false);
    TestGet(client, encryptor, "BinEC", DecryptOk, false);
    TestGet(client, encryptor, "TwoSetsGood", DecryptOk, false);
    TestGet(client, encryptor, "SetInList1", DecryptOk, false);

    TestGet(client, encryptor, "BasicYX", DecryptOk, true);
    TestGet(client, encryptor, "BasicXZY", DecryptOk, true);
    TestGet(client, encryptor, "BasicZXY", DecryptOk, true);
    TestGet(client, encryptor, "BasicZYX", DecryptOk, true);
    TestGet(client, encryptor, "BasicYXZ", DecryptOk, true);
    TestGet(client, encryptor, "BasicYZX", DecryptOk, true);

    TestGet(client, encryptor, "BinBA", DecryptOk, true);
    TestGet(client, encryptor, "BinACB", DecryptOk, true);
    TestGet(client, encryptor, "BinBAC", DecryptOk, true);
    TestGet(client, encryptor, "BinBCA", DecryptOk, true);
    TestGet(client, encryptor, "BinCAB", DecryptOk, true);
    TestGet(client, encryptor, "BinCBA", DecryptOk, true);
    TestGet(client, encryptor, "SetInList2", DecryptOk, true);
    TestGet(client, encryptor, "SetInList3", DecryptOk, true);
    TestGet(client, encryptor, "SetInList4", DecryptOk, true);
    TestGet(client, encryptor, "SetInMap1", DecryptOk, true);
    TestGet(client, encryptor, "SetInListInMap1", DecryptOk, true);
    TestGet(client, encryptor, "SetInMapInList1", DecryptOk, true);
    TestGet(client, encryptor, "TwoSets", DecryptOk, true);
    TestGet(client, encryptor, "ThreeSets", DecryptOk, true);

    TestGet(client, encryptor, "Num32a1", DecryptBad, true);
    TestNum32a1(client, encryptor);
  }
}
