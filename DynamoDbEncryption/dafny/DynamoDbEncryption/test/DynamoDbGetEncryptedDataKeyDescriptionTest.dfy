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

  const abc : UTF8.ValidUTF8Bytes :=
    var s := [0x61, 0x62, 0x63];
    assert s == UTF8.EncodeAscii("abc");
    s

  const def : UTF8.ValidUTF8Bytes :=
    var s := [0x64, 0x65, 0x66];
    assert s == UTF8.EncodeAscii("def");
    s

  const aws_kms : UTF8.ValidUTF8Bytes :=
    var s := [0x61, 0x77, 0x73, 0x2d, 0x6b, 0x6d, 0x73];
    assert s == UTF8.EncodeAscii("aws-kms");
    s

  const keyproviderInfo : UTF8.ValidUTF8Bytes :=
    var s := [0x6b, 0x65, 0x79, 0x70, 0x72, 0x6f, 0x76, 0x69, 0x64, 0x65, 0x72, 0x49, 0x6e, 0x66, 0x6f];
    assert s == UTF8.EncodeAscii("keyproviderInfo");
    s

  const aws_kms_hierarchy : UTF8.ValidUTF8Bytes :=
    var s := [0x61, 0x77, 0x73, 0x2d, 0x6b, 0x6d, 0x73, 0x2d, 0x68, 0x69, 0x65, 0x72, 0x61, 0x72, 0x63, 0x68, 0x79];
    assert s == UTF8.EncodeAscii("aws-kms-hierarchy");
    s

  const raw_rsa : UTF8.ValidUTF8Bytes :=
    var s := [0x72, 0x61, 0x77, 0x2d, 0x72, 0x73, 0x61];
    assert s == UTF8.EncodeAscii("raw-rsa");
    s

  const aws_kms_rsa : UTF8.ValidUTF8Bytes :=
    var s := [0x61, 0x77, 0x73, 0x2d, 0x6b, 0x6d, 0x73, 0x2d, 0x72, 0x73, 0x61];
    assert s == UTF8.EncodeAscii("aws-kms-rsa");
    s

  // THIS IS A TESTING RESOURCE DO NOT USE IN A PRODUCTION ENVIRONMENT
  const testVersion : Version := 1
  const testFlavor0 : Flavor := 0
  const testFlavor1 : Flavor := 1
  const testMsgID : MessageID := [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32]
  const testLegend : Legend := [0x65, 0x73]
  const testEncContext : CMPEncryptionContext := map[abc := def]
  const testAwsKmsDataKey := CMP.EncryptedDataKey(
                               keyProviderId := aws_kms ,
                               keyProviderInfo := keyproviderInfo,
                               ciphertext := [1, 2, 3, 4, 5])
  const testAwsKmsHDataKey := CMP.EncryptedDataKey(
                                keyProviderId := aws_kms_hierarchy,
                                keyProviderInfo := keyproviderInfo,
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
                               keyProviderId := raw_rsa,
                               keyProviderInfo := [1, 2, 3, 4, 5],
                               ciphertext := [6, 7, 8, 9])
  const testAwsKmsRsaDataKey := CMP.EncryptedDataKey(
                                  keyProviderId := aws_kms_rsa,
                                  keyProviderInfo := keyproviderInfo,
                                  ciphertext := [1, 2, 3, 4, 5])

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
    var expectedHead := CreatePartialHeader(testVersion, testFlavor1, testMsgID, testLegend, testEncContext, [testAwsKmsDataKey]);
    var serializedHeader := expectedHead.serialize() + expectedHead.msgID;
    var ddbEncResources :- expect DynamoDbEncryption.DynamoDbEncryption();
    var inputVariable: Types.GetEncryptedDataKeyDescriptionInput :=
      Types.GetEncryptedDataKeyDescriptionInput(
        input := Types.header(header := serializedHeader)
      );
    var actualDataKeyDescription :- expect ddbEncResources.GetEncryptedDataKeyDescription(inputVariable);

    expect |actualDataKeyDescription.EncryptedDataKeyDescriptionOutput| == 1;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderId == "aws-kms";
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderInfo.Some?;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderInfo.value == "keyproviderInfo";
  }

  method {:test} TestHeaderInputAwsKmsHDataKeyCase()
  {
    var expectedHead := CreatePartialHeader(testVersion, testFlavor1, testMsgID, testLegend, testEncContext, [testAwsKmsHDataKey]);
    var serializedHeader := expectedHead.serialize() + expectedHead.msgID;
    var ddbEncResources :- expect DynamoDbEncryption.DynamoDbEncryption();
    var inputVariable: Types.GetEncryptedDataKeyDescriptionInput :=
      Types.GetEncryptedDataKeyDescriptionInput(
        input := Types.header(header := serializedHeader)
      );
    var actualDataKeyDescription :- expect ddbEncResources.GetEncryptedDataKeyDescription(inputVariable);

    expect |actualDataKeyDescription.EncryptedDataKeyDescriptionOutput| == 1;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderId == "aws-kms-hierarchy";
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderInfo.Some?;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderInfo.value == "keyproviderInfo";

    assertBranchKey(actualDataKeyDescription);
  }

  method {:test} TestHeaderInputRawRsaDataKeyDataKeyCase()
  {
    var expectedHead := CreatePartialHeader(testVersion, testFlavor1, testMsgID, testLegend, testEncContext, [testRawRsaDataKey]);
    var serializedHeader := expectedHead.serialize() + expectedHead.msgID;
    var ddbEncResources :- expect DynamoDbEncryption.DynamoDbEncryption();
    var inputVariable: Types.GetEncryptedDataKeyDescriptionInput :=
      Types.GetEncryptedDataKeyDescriptionInput(
        input := Types.header(header := serializedHeader)
      );
    var actualDataKeyDescription :- expect ddbEncResources.GetEncryptedDataKeyDescription(inputVariable);

    expect |actualDataKeyDescription.EncryptedDataKeyDescriptionOutput| == 1;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderId == "raw-rsa";
  }

  method {:test} TestHeaderInputAwsKmsRsaDataKeyCase()
  {
    var expectedHead := CreatePartialHeader(testVersion, testFlavor1, testMsgID, testLegend, testEncContext, [testAwsKmsRsaDataKey]);
    var serializedHeader := expectedHead.serialize() + expectedHead.msgID;
    var ddbEncResources :- expect DynamoDbEncryption.DynamoDbEncryption();
    var inputVariable: Types.GetEncryptedDataKeyDescriptionInput :=
      Types.GetEncryptedDataKeyDescriptionInput(
        input := Types.header(header := serializedHeader)
      );
    var actualDataKeyDescription :- expect ddbEncResources.GetEncryptedDataKeyDescription(inputVariable);

    expect |actualDataKeyDescription.EncryptedDataKeyDescriptionOutput| == 1;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderId == "aws-kms-rsa";
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderInfo.Some?;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderInfo.value == "keyproviderInfo";
  }


  method {:test} TestDDBItemInputAwsKmsDataKeyCase()
  {
    var expectedHead := CreatePartialHeader(testVersion, testFlavor1, testMsgID, testLegend, testEncContext, [testAwsKmsDataKey]);
    var serializedHeader := expectedHead.serialize() + expectedHead.msgID;
    var attr := map["aws_dbe_head" := ComAmazonawsDynamodbTypes.AttributeValue.B(serializedHeader)];
    var ddbEncResources :- expect DynamoDbEncryption.DynamoDbEncryption();

    var inputVariable: Types.GetEncryptedDataKeyDescriptionInput :=
      Types.GetEncryptedDataKeyDescriptionInput(
        input := Types.item(item := attr)
      );

    var actualDataKeyDescription :- expect ddbEncResources.GetEncryptedDataKeyDescription(inputVariable);

    expect |actualDataKeyDescription.EncryptedDataKeyDescriptionOutput| == 1;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderId == "aws-kms";
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderInfo.Some?;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderInfo.value == "keyproviderInfo";
  }

  method {:test} TestDDBItemInputAwsKmsHDataKeyCase()
  {
    var expectedHead := CreatePartialHeader(testVersion, testFlavor0, testMsgID, testLegend, testEncContext, [testAwsKmsHDataKey]);
    var serializedHeader := expectedHead.serialize() + expectedHead.msgID;
    var attr := map["aws_dbe_head" := ComAmazonawsDynamodbTypes.AttributeValue.B(serializedHeader)];
    var ddbEncResources :- expect DynamoDbEncryption.DynamoDbEncryption();
    var inputVariable: Types.GetEncryptedDataKeyDescriptionInput :=
      Types.GetEncryptedDataKeyDescriptionInput(
        input := Types.item(item := attr)
      );
    var actualDataKeyDescription :- expect ddbEncResources.GetEncryptedDataKeyDescription(inputVariable);

    expect |actualDataKeyDescription.EncryptedDataKeyDescriptionOutput| == 1;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderId == "aws-kms-hierarchy";
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderInfo.Some?;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderInfo.value == "keyproviderInfo";

    assertBranchKey(actualDataKeyDescription);
  }

  method {:test} TestDDBItemInputRawRsaDataKeyCase()
  {
    var expectedHead := CreatePartialHeader(testVersion, testFlavor1, testMsgID, testLegend, testEncContext, [testRawRsaDataKey]);
    var serializedHeader := expectedHead.serialize() + expectedHead.msgID;
    var attr := map["aws_dbe_head" := ComAmazonawsDynamodbTypes.AttributeValue.B(serializedHeader)];
    var ddbEncResources :- expect DynamoDbEncryption.DynamoDbEncryption();
    var inputVariable: Types.GetEncryptedDataKeyDescriptionInput :=
      Types.GetEncryptedDataKeyDescriptionInput(
        input := Types.item(item := attr)
      );
    var actualDataKeyDescription :- expect ddbEncResources.GetEncryptedDataKeyDescription(inputVariable);

    expect |actualDataKeyDescription.EncryptedDataKeyDescriptionOutput| == 1;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderId == "raw-rsa";
  }

  method {:test} TestDDBItemInputAwsKmsRsaDataKeyCase()
  {
    var expectedHead := CreatePartialHeader(testVersion, testFlavor1, testMsgID, testLegend, testEncContext, [testAwsKmsRsaDataKey]);
    var serializedHeader := expectedHead.serialize() + expectedHead.msgID;
    var attr := map["aws_dbe_head" := ComAmazonawsDynamodbTypes.AttributeValue.B(serializedHeader)];
    var ddbEncResources :- expect DynamoDbEncryption.DynamoDbEncryption();
    var inputVariable: Types.GetEncryptedDataKeyDescriptionInput :=
      Types.GetEncryptedDataKeyDescriptionInput(
        input := Types.item(item := attr)
      );
    var actualDataKeyDescription :- expect ddbEncResources.GetEncryptedDataKeyDescription(inputVariable);

    expect |actualDataKeyDescription.EncryptedDataKeyDescriptionOutput| == 1;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderId == "aws-kms-rsa";
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderInfo.Some?;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderInfo.value == "keyproviderInfo";
  }

  method {:test} TestHeaderMultiDataKeyCase()
  {
    var expectedHead := CreatePartialHeader(testVersion, testFlavor1, testMsgID, testLegend, testEncContext, [testAwsKmsDataKey, testAwsKmsRsaDataKey]);
    var serializedHeader := expectedHead.serialize() + expectedHead.msgID;
    var ddbEncResources :- expect DynamoDbEncryption.DynamoDbEncryption();
    var inputVariable: Types.GetEncryptedDataKeyDescriptionInput :=
      Types.GetEncryptedDataKeyDescriptionInput(
        input := Types.header(header := serializedHeader)
      );
    var actualDataKeyDescription :- expect ddbEncResources.GetEncryptedDataKeyDescription(inputVariable);

    expect |actualDataKeyDescription.EncryptedDataKeyDescriptionOutput| == 2;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderInfo.Some?;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderId == "aws-kms";
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderInfo.value == "keyproviderInfo";

    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[1].keyProviderInfo.Some?;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[1].keyProviderId == "aws-kms-rsa";
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[1].keyProviderInfo.value == "keyproviderInfo";
  }

  method {:test} TestDDBItemInputMultiDataKeyCase()
  {
    var expectedHead := CreatePartialHeader(testVersion, testFlavor1, testMsgID, testLegend, testEncContext, [testAwsKmsDataKey, testAwsKmsRsaDataKey]);
    var serializedHeader := expectedHead.serialize() + expectedHead.msgID;
    var attr := map["aws_dbe_head" := ComAmazonawsDynamodbTypes.AttributeValue.B(serializedHeader)];
    var ddbEncResources :- expect DynamoDbEncryption.DynamoDbEncryption();
    var inputVariable: Types.GetEncryptedDataKeyDescriptionInput :=
      Types.GetEncryptedDataKeyDescriptionInput(
        input := Types.item(item := attr)
      );
    var actualDataKeyDescription :- expect ddbEncResources.GetEncryptedDataKeyDescription(inputVariable);

    expect |actualDataKeyDescription.EncryptedDataKeyDescriptionOutput| == 2;

    //= specification/dynamodb-encryption-client/ddb-get-encrypted-data-key-description.md#behavior
    //= type=test
    //# - For every Data Key in Data Keys, the operation MUST attempt to extract a description of the Data Key.
    expect |actualDataKeyDescription.EncryptedDataKeyDescriptionOutput| == 2;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderInfo.Some?;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderId == "aws-kms";
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].keyProviderInfo.value == "keyproviderInfo";

    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[1].keyProviderInfo.Some?;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[1].keyProviderId == "aws-kms-rsa";
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[1].keyProviderInfo.value == "keyproviderInfo";
  }

  method {:test} TestNoHeaderFailureCase()
  {
    var expectedHead := CreatePartialHeader(testVersion, testFlavor1, testMsgID, testLegend, testEncContext, [testAwsKmsDataKey]);
    var serializedHeader := expectedHead.serialize() + expectedHead.msgID;
    var attr := map["wrong_header_attribute" := ComAmazonawsDynamodbTypes.AttributeValue.B(serializedHeader)];
    var ddbEncResources :- expect DynamoDbEncryption.DynamoDbEncryption();
    var inputVariable: Types.GetEncryptedDataKeyDescriptionInput :=
      Types.GetEncryptedDataKeyDescriptionInput(
        input := Types.item(item := attr)
      );
    var actualDataKeyDescription := ddbEncResources.GetEncryptedDataKeyDescription(inputVariable);

    expect actualDataKeyDescription.IsFailure();
    expect actualDataKeyDescription.error.DynamoDbEncryptionException?;
    expect actualDataKeyDescription.error.message == "Header not found in the DynamoDB item.";
  }

  method assertBranchKey(actualDataKeyDescription : Types.GetEncryptedDataKeyDescriptionOutput)
  {
    expect |actualDataKeyDescription.EncryptedDataKeyDescriptionOutput| == 1;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].branchKeyId.Some?;
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].branchKeyVersion.Some?;

    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].branchKeyId.value == "keyproviderInfo";
    expect actualDataKeyDescription.EncryptedDataKeyDescriptionOutput[0].branchKeyVersion.value == "155b7a3d-7625-4826-4302-113d1179075a";
  }
}
