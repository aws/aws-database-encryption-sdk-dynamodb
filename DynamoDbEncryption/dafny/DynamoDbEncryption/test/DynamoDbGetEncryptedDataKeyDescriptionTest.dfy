// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../src/Index.dfy"

module DynamoDbGetEncryptedDataKeyDescriptionTest {
  import DynamoDbEncryption
  import opened StandardLibrary.UInt
  import opened StructuredEncryptionHeader
  import opened StructuredEncryptionUtil
  import opened UTF8
  import Types = AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import UUID
  import ComAmazonawsDynamodbTypes
  import EdkWrapping
  import AlgorithmSuites

  // THIS IS A TESTING RESOURCE DO NOT USE IN A PRODUCTION ENVIRONMENT
  const testVersion : Version := 1
  const testFlavor : Flavor := 1
  const testMsgID : MessageID := [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32]
  const testLegend : Legend := [0x65, 0x73]
  const testEncContext : CMPEncryptionContext := map[EncodeAscii("abc") := EncodeAscii("def")]
  const testAwsKmsDataKey := CMP.EncryptedDataKey(
                               keyProviderId := EncodeAscii("aws-kms") ,
                               keyProviderInfo := EncodeAscii("keyproviderInfo"),
                               ciphertext := [1, 2, 3, 4, 5])
  const testAwsKmsHDataKey := CMP.EncryptedDataKey(
                                keyProviderId := EncodeAscii("aws-kms-hierarchy") ,
                                keyProviderInfo := EncodeAscii("keyproviderInfo"),
                                ciphertext := [
                                  64, 92, 115, 7, 85, 121, 112, 79, 69, 12, 82, 25, 67, 34,
                                  11, 66, 93, 45, 40, 23, 90, 61, 16, 28, 59, 114, 52, 122,
                                  50, 23, 11, 101, 48, 53, 30, 120, 51, 74, 77, 53, 57, 99,
                                  53, 13, 30, 21, 109, 85, 15, 86, 47, 84, 91, 85, 87, 60, 4,
                                  56, 67, 74, 29, 87, 85, 106, 8, 82, 63, 114, 100, 110, 68,
                                  58, 83, 24, 111, 41, 21, 91, 122, 61, 118, 37, 72, 38, 67, 2,
                                  17, 61, 17, 121, 7, 90, 117, 49, 30, 20, 89, 68, 33, 111,
                                  107, 5, 120, 20, 95, 78, 70, 2, 49, 84, 39, 50, 40, 40, 115,
                                  114, 76, 18, 103, 84, 34, 123, 1, 125, 61, 33, 13, 18, 81,
                                  24, 53, 53, 26, 60, 52, 85, 81, 96, 85, 72])
  const testRawRsaDataKey := CMP.EncryptedDataKey(
                               keyProviderId := EncodeAscii("raw-rsa") ,
                               keyProviderInfo := [1, 2, 3, 4, 5],
                               ciphertext := [6, 7, 8, 9])
  const testAwsKmsRsaDataKey := CMP.EncryptedDataKey(
                                  keyProviderId := EncodeAscii("aws-kms-rsa") ,
                                  keyProviderInfo := EncodeAscii("keyproviderInfo"),
                                  ciphertext := [1, 2, 3, 4, 5])
  const algorithmSuite := AlgorithmSuites.DBE_ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384

  method CreatePartialHeader(version : Version, flavor : Flavor, msgID : MessageID, legend : Legend, encContext : CMPEncryptionContext, dataKeyList : CMPEncryptedDataKeyList)
    returns (result: PartialHeader)
    ensures result.version == version
    ensures result.flavor == flavor
    ensures result.msgID == msgID
    ensures result.legend == legend
    ensures result.encContext == encContext
    ensures result.dataKeys == dataKeyList
  {
    result := PartialHeader (
      version := version,
      flavor := flavor,
      msgID := msgID,
      legend := legend,
      encContext := encContext,
      dataKeys := dataKeyList
    );
  }

  method {:test} TestHeaderInputAwsKmsDataKeyCase()
  {
    var expectedHead := CreatePartialHeader(testVersion, testFlavor, testMsgID, testLegend, testEncContext, [testAwsKmsDataKey]);
    var serializedHeader := expectedHead.serialize() + expectedHead.msgID;
    var ddbEncResources :- expect DynamoDbEncryption.DynamoDbEncryption();
    var inputVariable: Types.GetEncryptedDataKeyDescriptionInput :=
      Types.GetEncryptedDataKeyDescriptionInput(
        input := Types.header(header := serializedHeader)
      );
    var actualDataKeyDescription :- expect ddbEncResources.GetEncryptedDataKeyDescription(inputVariable);
    var expectedkeyProviderId :- expect UTF8.Decode(expectedHead.dataKeys[0].keyProviderId);
    var expectedkeyProviderInfo :- expect UTF8.Decode(expectedHead.dataKeys[0].keyProviderInfo);

    expect |actualDataKeyDescription.EncryptedDataKeyDescriptionOutput| > 0;
    expect |actualDataKeyDescription.EncryptedDataKeyDescriptionOutput| == |expectedHead.dataKeys|;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderId == expectedkeyProviderId;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderInfo.Some?;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderInfo.value == expectedkeyProviderInfo;
  }

  method {:test} TestHeaderInputAwsKmsHDataKeyCase()
  {
    var expectedHead := CreatePartialHeader(testVersion, testFlavor, testMsgID, testLegend, testEncContext, [testAwsKmsHDataKey]);
    var serializedHeader := expectedHead.serialize() + expectedHead.msgID;
    var expectedBranchKeyVersion := getBranchKeyVersion(expectedHead);
    var ddbEncResources :- expect DynamoDbEncryption.DynamoDbEncryption();
    var inputVariable: Types.GetEncryptedDataKeyDescriptionInput :=
      Types.GetEncryptedDataKeyDescriptionInput(
        input := Types.header(header := serializedHeader)
      );
    var actualDataKeyDescription :- expect ddbEncResources.GetEncryptedDataKeyDescription(inputVariable);
    var expectedkeyProviderId :- expect UTF8.Decode(expectedHead.dataKeys[0].keyProviderId);
    var expectedkeyProviderInfo :- expect UTF8.Decode(expectedHead.dataKeys[0].keyProviderInfo);

    expect |actualDataKeyDescription.EncryptedDataKeyDescriptionOutput| > 0;
    expect |actualDataKeyDescription.EncryptedDataKeyDescriptionOutput| == |expectedHead.dataKeys|;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderId == expectedkeyProviderId;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderInfo.Some?;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderInfo.value == expectedkeyProviderInfo;

    if actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderId == "aws-kms-hierarchy" {
      expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].branchKeyId.Some?;
      expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].branchKeyVersion.Some?;

      expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].branchKeyId.value == expectedkeyProviderInfo;
      expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].branchKeyVersion.value == expectedBranchKeyVersion;
    }
  }

  method {:test} TestHeaderInputRawRsaDataKeyDataKeyCase()
  {
    var expectedHead := CreatePartialHeader(testVersion, testFlavor, testMsgID, testLegend, testEncContext, [testRawRsaDataKey]);
    var serializedHeader := expectedHead.serialize() + expectedHead.msgID;
    var ddbEncResources :- expect DynamoDbEncryption.DynamoDbEncryption();
    var inputVariable: Types.GetEncryptedDataKeyDescriptionInput :=
      Types.GetEncryptedDataKeyDescriptionInput(
        input := Types.header(header := serializedHeader)
      );
    var actualDataKeyDescription :- expect ddbEncResources.GetEncryptedDataKeyDescription(inputVariable);
    var expectedkeyProviderId :- expect UTF8.Decode(expectedHead.dataKeys[0].keyProviderId);
    var expectedkeyProviderInfo :- expect UTF8.Decode(expectedHead.dataKeys[0].keyProviderInfo);

    expect |actualDataKeyDescription.EncryptedDataKeyDescriptionOutput| > 0;
    expect |actualDataKeyDescription.EncryptedDataKeyDescriptionOutput| == |expectedHead.dataKeys|;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderId == expectedkeyProviderId;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderInfo.Some?;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderInfo.value == expectedkeyProviderInfo;
  }

  method {:test} TestHeaderInputAwsKmsRsaDataKeyCase()
  {
    var expectedHead := CreatePartialHeader(testVersion, testFlavor, testMsgID, testLegend, testEncContext, [testAwsKmsRsaDataKey]);
    var serializedHeader := expectedHead.serialize() + expectedHead.msgID;
    var ddbEncResources :- expect DynamoDbEncryption.DynamoDbEncryption();
    var inputVariable: Types.GetEncryptedDataKeyDescriptionInput :=
      Types.GetEncryptedDataKeyDescriptionInput(
        input := Types.header(header := serializedHeader)
      );
    var actualDataKeyDescription :- expect ddbEncResources.GetEncryptedDataKeyDescription(inputVariable);
    var expectedkeyProviderId :- expect UTF8.Decode(expectedHead.dataKeys[0].keyProviderId);
    var expectedkeyProviderInfo :- expect UTF8.Decode(expectedHead.dataKeys[0].keyProviderInfo);

    expect |actualDataKeyDescription.EncryptedDataKeyDescriptionOutput| > 0;
    expect |actualDataKeyDescription.EncryptedDataKeyDescriptionOutput| == |expectedHead.dataKeys|;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderId == expectedkeyProviderId;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderInfo.Some?;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderInfo.value == expectedkeyProviderInfo;
  }


  method {:test} TestDDBItemInputAwsKmsDataKeyCase()
  {
    var expectedHead := CreatePartialHeader(testVersion, testFlavor, testMsgID, testLegend, testEncContext, [testAwsKmsDataKey]);
    var serializedHeader := expectedHead.serialize() + expectedHead.msgID;
    var attr := map["aws_dbe_head" := ComAmazonawsDynamodbTypes.AttributeValue.B(serializedHeader)];
    var ddbEncResources :- expect DynamoDbEncryption.DynamoDbEncryption();

    var inputVariable: Types.GetEncryptedDataKeyDescriptionInput :=
      Types.GetEncryptedDataKeyDescriptionInput(
        input := Types.plaintextItem(plaintextItem := attr)
      );

    var actualDataKeyDescription :- expect ddbEncResources.GetEncryptedDataKeyDescription(inputVariable);
    var expectedkeyProviderId :- expect UTF8.Decode(expectedHead.dataKeys[0].keyProviderId);
    var expectedkeyProviderInfo :- expect UTF8.Decode(expectedHead.dataKeys[0].keyProviderInfo);

    expect |actualDataKeyDescription.EncryptedDataKeyDescriptionOutput| > 0;
    expect |actualDataKeyDescription.EncryptedDataKeyDescriptionOutput| == |expectedHead.dataKeys|;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderId == expectedkeyProviderId;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderInfo.Some?;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderInfo.value == expectedkeyProviderInfo;
  }

  method {:test} TestDDBItemInputAwsKmsHDataKeyCase()
  {
    var expectedHead := CreatePartialHeader(testVersion, testFlavor, testMsgID, testLegend, testEncContext, [testAwsKmsHDataKey]);
    var serializedHeader := expectedHead.serialize() + expectedHead.msgID;
    var expectedBranchKeyVersion := getBranchKeyVersion(expectedHead);
    var attr := map["aws_dbe_head" := ComAmazonawsDynamodbTypes.AttributeValue.B(serializedHeader)];
    var ddbEncResources :- expect DynamoDbEncryption.DynamoDbEncryption();
    var inputVariable: Types.GetEncryptedDataKeyDescriptionInput :=
      Types.GetEncryptedDataKeyDescriptionInput(
        input := Types.plaintextItem(plaintextItem := attr)
      );
    var actualDataKeyDescription :- expect ddbEncResources.GetEncryptedDataKeyDescription(inputVariable);
    var expectedkeyProviderId :- expect UTF8.Decode(expectedHead.dataKeys[0].keyProviderId);
    var expectedkeyProviderInfo :- expect UTF8.Decode(expectedHead.dataKeys[0].keyProviderInfo);

    expect |actualDataKeyDescription.EncryptedDataKeyDescriptionOutput| > 0;
    expect |actualDataKeyDescription.EncryptedDataKeyDescriptionOutput| == |expectedHead.dataKeys|;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderId == expectedkeyProviderId;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderInfo.Some?;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderInfo.value == expectedkeyProviderInfo;

    if actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderId == "aws-kms-hierarchy" {
      expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].branchKeyId.Some?;
      expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].branchKeyVersion.Some?;

      expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].branchKeyId.value == expectedkeyProviderInfo;
      expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].branchKeyVersion.value == expectedBranchKeyVersion;
    }
  }

  method {:test} TestDDBItemInputRawRsaDataKeyCase()
  {
    var expectedHead := CreatePartialHeader(testVersion, testFlavor, testMsgID, testLegend, testEncContext, [testRawRsaDataKey]);
    var serializedHeader := expectedHead.serialize() + expectedHead.msgID;
    var attr := map["aws_dbe_head" := ComAmazonawsDynamodbTypes.AttributeValue.B(serializedHeader)];
    var ddbEncResources :- expect DynamoDbEncryption.DynamoDbEncryption();
    var inputVariable: Types.GetEncryptedDataKeyDescriptionInput :=
      Types.GetEncryptedDataKeyDescriptionInput(
        input := Types.plaintextItem(plaintextItem := attr)
      );
    var actualDataKeyDescription :- expect ddbEncResources.GetEncryptedDataKeyDescription(inputVariable);
    var expectedkeyProviderId :- expect UTF8.Decode(expectedHead.dataKeys[0].keyProviderId);
    var expectedkeyProviderInfo :- expect UTF8.Decode(expectedHead.dataKeys[0].keyProviderInfo);

    expect |actualDataKeyDescription.EncryptedDataKeyDescriptionOutput| > 0;
    expect |actualDataKeyDescription.EncryptedDataKeyDescriptionOutput| == |expectedHead.dataKeys|;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderId == expectedkeyProviderId;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderInfo.Some?;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderInfo.value == expectedkeyProviderInfo;
  }

  method {:test} TestDDBItemInputAwsKmsRsaDataKeyCase()
  {
    var expectedHead := CreatePartialHeader(testVersion, testFlavor, testMsgID, testLegend, testEncContext, [testAwsKmsRsaDataKey]);
    var serializedHeader := expectedHead.serialize() + expectedHead.msgID;
    var attr := map["aws_dbe_head" := ComAmazonawsDynamodbTypes.AttributeValue.B(serializedHeader)];
    var ddbEncResources :- expect DynamoDbEncryption.DynamoDbEncryption();
    var inputVariable: Types.GetEncryptedDataKeyDescriptionInput :=
      Types.GetEncryptedDataKeyDescriptionInput(
        input := Types.plaintextItem(plaintextItem := attr)
      );
    var actualDataKeyDescription :- expect ddbEncResources.GetEncryptedDataKeyDescription(inputVariable);
    var expectedkeyProviderId :- expect UTF8.Decode(expectedHead.dataKeys[0].keyProviderId);
    var expectedkeyProviderInfo :- expect UTF8.Decode(expectedHead.dataKeys[0].keyProviderInfo);

    expect |actualDataKeyDescription.EncryptedDataKeyDescriptionOutput| > 0;
    expect |actualDataKeyDescription.EncryptedDataKeyDescriptionOutput| == |expectedHead.dataKeys|;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderId == expectedkeyProviderId;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderInfo.Some?;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderInfo.value == expectedkeyProviderInfo;
  }

  method {:test} TestHeaderMultiDataKeyCase()
  {
    var expectedHead := CreatePartialHeader(testVersion, testFlavor, testMsgID, testLegend, testEncContext, [testAwsKmsDataKey, testAwsKmsRsaDataKey]);
    var serializedHeader := expectedHead.serialize() + expectedHead.msgID;
    var ddbEncResources :- expect DynamoDbEncryption.DynamoDbEncryption();
    var inputVariable: Types.GetEncryptedDataKeyDescriptionInput :=
      Types.GetEncryptedDataKeyDescriptionInput(
        input := Types.header(header := serializedHeader)
      );
    var actualDataKeyDescription :- expect ddbEncResources.GetEncryptedDataKeyDescription(inputVariable);

    expect |actualDataKeyDescription.EncryptedDataKeyDescriptionOutput| == |expectedHead.dataKeys|;
    expect |actualDataKeyDescription.EncryptedDataKeyDescriptionOutput| > 0;

    var i := 0;
    while (i < |expectedHead.dataKeys|) {
      var expectedkeyProviderId :- expect UTF8.Decode(expectedHead.dataKeys[i].keyProviderId);
      var expectedkeyProviderInfo :- expect UTF8.Decode(expectedHead.dataKeys[i].keyProviderInfo);

      expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[i].keyProviderInfo.Some?;
      expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[i].keyProviderId == expectedkeyProviderId;
      expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[i].keyProviderInfo.Extract() == expectedkeyProviderInfo;
      i := i + 1;
    }
  }

  method {:test} TestDDBItemInputMultiDataKeyCase()
  {
    var expectedHead := CreatePartialHeader(testVersion, testFlavor, testMsgID, testLegend, testEncContext, [testAwsKmsDataKey, testAwsKmsRsaDataKey]);
    var serializedHeader := expectedHead.serialize() + expectedHead.msgID;
    var attr := map["aws_dbe_head" := ComAmazonawsDynamodbTypes.AttributeValue.B(serializedHeader)];
    var ddbEncResources :- expect DynamoDbEncryption.DynamoDbEncryption();
    var inputVariable: Types.GetEncryptedDataKeyDescriptionInput :=
      Types.GetEncryptedDataKeyDescriptionInput(
        input := Types.plaintextItem(plaintextItem := attr)
      );
    var actualDataKeyDescription :- expect ddbEncResources.GetEncryptedDataKeyDescription(inputVariable);
    var expectedkeyProviderId :- expect UTF8.Decode(expectedHead.dataKeys[0].keyProviderId);
    var expectedkeyProviderInfo :- expect UTF8.Decode(expectedHead.dataKeys[0].keyProviderInfo);

    expect |actualDataKeyDescription.EncryptedDataKeyDescriptionOutput| == |expectedHead.dataKeys|;
    expect |actualDataKeyDescription.EncryptedDataKeyDescriptionOutput| > 0;

    var i := 0;
    while (i < |expectedHead.dataKeys|) {
      var expectedkeyProviderId :- expect UTF8.Decode(expectedHead.dataKeys[i].keyProviderId);
      var expectedkeyProviderInfo :- expect UTF8.Decode(expectedHead.dataKeys[i].keyProviderInfo);

      expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[i].keyProviderInfo.Some?;
      expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[i].keyProviderId == expectedkeyProviderId;
      expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[i].keyProviderInfo.Extract() == expectedkeyProviderInfo;
      i := i + 1;
    }
  }

  method getBranchKeyVersion (expectedHead : PartialHeader)
    returns (expectedBranchKeyVersion : string)
  {
    expect EdkWrapping.GetProviderWrappedMaterial(expectedHead.dataKeys[0].ciphertext, algorithmSuite).Success?;
    var providerWrappedMaterial := EdkWrapping.GetProviderWrappedMaterial(expectedHead.dataKeys[0].ciphertext, algorithmSuite).Extract();
    expect |providerWrappedMaterial| >= (28 + 16);
    var expectedBranchKeyVersionResult := UUID.FromByteArray(providerWrappedMaterial[28 .. (28 + 16)]);
    expect expectedBranchKeyVersionResult.Success?;
    expectedBranchKeyVersion := expectedBranchKeyVersionResult.Extract();
  }
}
