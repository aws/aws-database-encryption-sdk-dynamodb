include "../src/Index.dfy"

module DynamoDbGetEncryptedDataKeyDescriptionTest {
    import DynamoDbEncryption
    import opened StandardLibrary.UInt
    import opened StructuredEncryptionHeader
    import opened UTF8
    import Types = AwsCryptographyDbEncryptionSdkDynamoDbTypes
    import UUID
    import ComAmazonawsDynamodbTypes
    import EdkWrapping
    import AlgorithmSuites

    const expectedHead := PartialHeader (
            version := 1,
            flavor := 1,
            msgID := [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32],
            legend := [0x65, 0x73],
            encContext := map[EncodeAscii("abc") := EncodeAscii("def")],
            dataKeys := [CMP.EncryptedDataKey(
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
                            24, 53, 53, 26, 60, 52, 85, 81, 96, 85, 72])]
            )
    const serializedHeader := expectedHead.serialize() + expectedHead.msgID
    const algorithmSuite := AlgorithmSuites.DBE_ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384

    method {:test} TestHeaderInputCase() 
    {
        expect EdkWrapping.GetProviderWrappedMaterial(expectedHead.dataKeys[0].ciphertext, algorithmSuite).Success?;
        var providerWrappedMaterial := EdkWrapping.GetProviderWrappedMaterial(expectedHead.dataKeys[0].ciphertext, algorithmSuite).Extract();
        
        expect |providerWrappedMaterial| >= (28 + 16);
        var expectedBranchKeyVersionUuid := UUID.FromByteArray(providerWrappedMaterial[28 .. (28 + 16)]);
        var ddbEncResources :- expect DynamoDbEncryption.DynamoDbEncryption();

        var inputVariable: Types.GetEncryptedDataKeyDescriptionInput :=
            Types.GetEncryptedDataKeyDescriptionInput(
                input := Types.header(header := serializedHeader)
            );

        var actualDataKeyDescription := ddbEncResources.GetEncryptedDataKeyDescription(inputVariable);

        expect expectedBranchKeyVersionUuid.Success?;
        expect UTF8.Decode(expectedHead.dataKeys[0].keyProviderId).Success?;
        expect UTF8.Decode(expectedHead.dataKeys[0].keyProviderInfo).Success?;
        expect actualDataKeyDescription.Success?;
        expect |actualDataKeyDescription.Extract().EncryptedDataKeyDescriptionOutput| > 0;
    
        expect |actualDataKeyDescription.Extract().EncryptedDataKeyDescriptionOutput| == |expectedHead.dataKeys|;
        expect actualDataKeyDescription.Extract().EncryptedDataKeyDescriptionOutput[0].keyProviderId == UTF8.Decode(expectedHead.dataKeys[0].keyProviderId).Extract();
        
        expect actualDataKeyDescription.Extract().EncryptedDataKeyDescriptionOutput[0].keyProviderInfo.Some?;
        expect actualDataKeyDescription.Extract().EncryptedDataKeyDescriptionOutput[0].keyProviderInfo.Extract() == UTF8.Decode(expectedHead.dataKeys[0].keyProviderInfo).Extract();

        if actualDataKeyDescription.Extract().EncryptedDataKeyDescriptionOutput[0].keyProviderId == "aws-kms-hierarchy"{
            expect actualDataKeyDescription.Extract().EncryptedDataKeyDescriptionOutput[0].branchKeyId.Some?;
            expect actualDataKeyDescription.Extract().EncryptedDataKeyDescriptionOutput[0].branchKeyVersion.Some?;

            expect actualDataKeyDescription.Extract().EncryptedDataKeyDescriptionOutput[0].branchKeyId.Extract() == UTF8.Decode(expectedHead.dataKeys[0].keyProviderInfo).Extract();
            expect actualDataKeyDescription.Extract().EncryptedDataKeyDescriptionOutput[0].branchKeyVersion.Extract() == expectedBranchKeyVersionUuid.Extract();
        }
    }

    method {:test} TestDDBItemInputCase() 
    {
        expect EdkWrapping.GetProviderWrappedMaterial(expectedHead.dataKeys[0].ciphertext, algorithmSuite).Success?;
        var providerWrappedMaterial := EdkWrapping.GetProviderWrappedMaterial(expectedHead.dataKeys[0].ciphertext, algorithmSuite).Extract();
        
        expect |providerWrappedMaterial| >= (28 + 16);

        var expectedBranchKeyVersionUuid := UUID.FromByteArray(providerWrappedMaterial[28 .. (28 + 16)]);
        var attr := map["aws_dbe_head" := ComAmazonawsDynamodbTypes.AttributeValue.B(serializedHeader)];
        var ddbEncResources :- expect DynamoDbEncryption.DynamoDbEncryption();
        

        var inputVariable: Types.GetEncryptedDataKeyDescriptionInput :=
            Types.GetEncryptedDataKeyDescriptionInput(
                input := Types.plaintextItem(plaintextItem := attr)
            );

        var actualDataKeyDescription := ddbEncResources.GetEncryptedDataKeyDescription(inputVariable);
        
        expect expectedBranchKeyVersionUuid.Success?;
        expect UTF8.Decode(expectedHead.dataKeys[0].keyProviderId).Success?;
        expect UTF8.Decode(expectedHead.dataKeys[0].keyProviderInfo).Success?;
        expect actualDataKeyDescription.Success?;
        expect |actualDataKeyDescription.Extract().EncryptedDataKeyDescriptionOutput| > 0;

        expect |actualDataKeyDescription.Extract().EncryptedDataKeyDescriptionOutput| == |expectedHead.dataKeys|;
        expect actualDataKeyDescription.Extract().EncryptedDataKeyDescriptionOutput[0].keyProviderId == UTF8.Decode(expectedHead.dataKeys[0].keyProviderId).Extract();

        expect actualDataKeyDescription.Extract().EncryptedDataKeyDescriptionOutput[0].keyProviderInfo.Some?;
        expect actualDataKeyDescription.Extract().EncryptedDataKeyDescriptionOutput[0].keyProviderInfo.Extract() == UTF8.Decode(expectedHead.dataKeys[0].keyProviderInfo).Extract();
        
        if actualDataKeyDescription.Extract().EncryptedDataKeyDescriptionOutput[0].keyProviderId == "aws-kms-hierarchy"{
            expect actualDataKeyDescription.Extract().EncryptedDataKeyDescriptionOutput[0].branchKeyId.Some?;
            expect actualDataKeyDescription.Extract().EncryptedDataKeyDescriptionOutput[0].branchKeyVersion.Some?;

            expect actualDataKeyDescription.Extract().EncryptedDataKeyDescriptionOutput[0].branchKeyId.Extract() == UTF8.Decode(expectedHead.dataKeys[0].keyProviderInfo).Extract();
            expect actualDataKeyDescription.Extract().EncryptedDataKeyDescriptionOutput[0].branchKeyVersion.Extract() == expectedBranchKeyVersionUuid.Extract();
        }
    }

}