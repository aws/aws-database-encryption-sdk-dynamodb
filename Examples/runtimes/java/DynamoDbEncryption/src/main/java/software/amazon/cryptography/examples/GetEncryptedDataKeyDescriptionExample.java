package software.amazon.cryptography.examples;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.model.*;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryption;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbEncryptionConfig;

import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetEncryptedDataKeyDescriptionUnion;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetEncryptedDataKeyDescriptionInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetEncryptedDataKeyDescriptionOutput;
import java.nio.ByteBuffer;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class GetEncryptedDataKeyDescriptionExample{
    public static void getEncryptedDataKeyDescription(
                String tableName, String partitionKey, String partitionKeyVal, String sortKeyName, String sortKeyValue, 
                String expectedKeyProviderId, String expectedKeyProviderInfo, String expectedBranchKeyId, String expectedBranchKeyVersion
        ) {
        DynamoDbEncryption ddbEnc = DynamoDbEncryption.builder()
                .DynamoDbEncryptionConfig(DynamoDbEncryptionConfig.builder().build())
                .build();

        String header_column = "aws_dbe_head";

        DynamoDbClient ddb = DynamoDbClient.builder()
                .region(Region.US_WEST_2)
                .build();

        HashMap<String, AttributeValue> keyToGet = new HashMap<>();
        keyToGet.put(partitionKey, AttributeValue.builder()
                .s(partitionKeyVal)
                .build());

        keyToGet.put(sortKeyName, AttributeValue.builder()
                .n(sortKeyValue)
                .build());

        // ddbEnc.GetHeader(ddbEnc.GetHeaderInput.builder().build());
        GetItemRequest request = GetItemRequest.builder()
        .tableName(tableName)
        .key(keyToGet)
        .build();

        Map<String, AttributeValue> returnedItem = ddb.getItem(request).item();

        if (returnedItem.isEmpty())
                System.out.format("No item found with the key %s!\n", partitionKey);

        ByteBuffer header = returnedItem.get(header_column).b().asByteBuffer();

        GetEncryptedDataKeyDescriptionUnion InputUnion = GetEncryptedDataKeyDescriptionUnion.builder()
        .plaintextItem(returnedItem)
        .build();

        // GetEncryptedDataKeyDescriptionUnion InputUnion = GetEncryptedDataKeyDescriptionUnion.builder()
        // .header(header)
        // .build();
        
        // Create input 
        software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetEncryptedDataKeyDescriptionInput input = GetEncryptedDataKeyDescriptionInput.builder()
        .input(InputUnion)
        .build();
        
        // Call GetHeader method
        GetEncryptedDataKeyDescriptionOutput output = ddbEnc.GetEncryptedDataKeyDescription(input);

        assert output.EncryptedDataKeyDescriptionOutput().get(0).keyProviderId().equals(expectedKeyProviderId);

        if(expectedKeyProviderId.startsWith("aws-kms")) {
                assert output.EncryptedDataKeyDescriptionOutput().get(0).keyProviderInfo().equals(expectedKeyProviderInfo);
        } else {
                assert output.EncryptedDataKeyDescriptionOutput().get(0).keyProviderInfo() == expectedKeyProviderInfo; 
        }

        if(output.EncryptedDataKeyDescriptionOutput().get(0).keyProviderId().equals("aws-kms-hierarchy")) {
                assert output.EncryptedDataKeyDescriptionOutput().get(0).branchKeyId().equals(expectedBranchKeyId);
                assert output.EncryptedDataKeyDescriptionOutput().get(0).branchKeyVersion().equals(expectedBranchKeyVersion);
        } else {
                assert output.EncryptedDataKeyDescriptionOutput().get(0).branchKeyId() == expectedBranchKeyId;
                assert output.EncryptedDataKeyDescriptionOutput().get(0).branchKeyVersion() == expectedBranchKeyVersion;
        }
    }
    public static void main(final String[] args) {
        if (args.length < 9) {
            throw new IllegalArgumentException("To run this example, include the tableName, partitionKey, partitionKeyVal,"
                    + "sortKeyName, sortKeyValue, expectedKeyProviderId, expectedKeyProviderInfo, expectedBranchKeyId and expectedBranchKeyVersion in args");
        }
        final String tableName = args[0];
        final String partitionKey = args[1];
        final String partitionKeyVal = args[2];
        final String sortKeyName = args[3];
        final String sortKeyValue = args[4];
        final String expectedKeyProviderId = args[5];
        final String expectedKeyProviderInfo = args[6];
        final String expectedBranchKeyId = args[7];
        final String expectedBranchKeyVersion = args[8];
        getEncryptedDataKeyDescription(tableName, partitionKey, partitionKeyVal, sortKeyName, sortKeyValue, expectedKeyProviderId, expectedKeyProviderInfo, expectedBranchKeyId, expectedBranchKeyVersion);
    }
}