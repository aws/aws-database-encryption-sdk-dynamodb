package software.amazon.cryptography.examples;

import java.nio.ByteBuffer;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryption;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetEncryptedDataKeyDescriptionInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetEncryptedDataKeyDescriptionOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetEncryptedDataKeyDescriptionUnion;

public class GetEncryptedDataKeyDescriptionExample {

  public static void getEncryptedDataKeyDescription(
    String tableName,
    String partitionKey,
    String partitionKeyVal,
    String sortKeyName,
    String sortKeyValue,
    String expectedKeyProviderId,
    String expectedKeyProviderInfo,
    String expectedBranchKeyId,
    String expectedBranchKeyVersion
  ) {
    // 1. Create a new AWS SDK DynamoDb client. This client will be used to get item from the DynamoDB table
    DynamoDbClient ddb = DynamoDbClient.builder().build();

    // 2. Get item from the DynamoDB table. This item will be used to Get Encrypted DataKey Description
    HashMap<String, AttributeValue> keyToGet = new HashMap<>();
    keyToGet.put(
      partitionKey,
      AttributeValue.builder().s(partitionKeyVal).build()
    );
    keyToGet.put(sortKeyName, AttributeValue.builder().n(sortKeyValue).build());
    GetItemRequest request = GetItemRequest
      .builder()
      .tableName(tableName)
      .key(keyToGet)
      .build();
    Map<String, AttributeValue> returnedItem = ddb.getItem(request).item();
    if (returnedItem.isEmpty()) System.out.format(
      "No item found with the key %s!\n",
      partitionKey
    );

    // 3. Prepare the input for GetEncryptedDataKeyDescription method.
    // This input can be a DynamoDB item or a header. For now, we are giving input as a DynamoDB item
    // but users can also extract the header from the attribute "aws_dbe_head" in the DynamoDB table
    // and use it for GetEncryptedDataKeyDescription method.
    DynamoDbEncryption ddbEnc = DynamoDbEncryption
      .builder()
      .DynamoDbEncryptionConfig(DynamoDbEncryptionConfig.builder().build())
      .build();
    GetEncryptedDataKeyDescriptionUnion InputUnion =
      GetEncryptedDataKeyDescriptionUnion.builder().item(returnedItem).build();
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetEncryptedDataKeyDescriptionInput input =
      GetEncryptedDataKeyDescriptionInput.builder().input(InputUnion).build();
    GetEncryptedDataKeyDescriptionOutput output =
      ddbEnc.GetEncryptedDataKeyDescription(input);

    // In the following code, we are giving input as header instead of a complete DynamoDB item
    // This code is provided solely to demo how the alternative approach works. So, it is commented.

    // String header_attribute = "aws_dbe_head";
    // ByteBuffer header = returnedItem.get(header_attribute).b().asByteBuffer();
    // GetEncryptedDataKeyDescriptionUnion InputUnion = GetEncryptedDataKeyDescriptionUnion.builder()
    // .header(header)
    // .build();

    // Assert everything
    assert output
      .EncryptedDataKeyDescriptionOutput()
      .get(0)
      .keyProviderId()
      .equals(expectedKeyProviderId);
    if (expectedKeyProviderId.startsWith("aws-kms")) {
      assert output
        .EncryptedDataKeyDescriptionOutput()
        .get(0)
        .keyProviderInfo()
        .equals(expectedKeyProviderInfo);
    }
    if (
      output
        .EncryptedDataKeyDescriptionOutput()
        .get(0)
        .keyProviderId()
        .equals("aws-kms-hierarchy")
    ) {
      assert output
        .EncryptedDataKeyDescriptionOutput()
        .get(0)
        .branchKeyId()
        .equals(expectedBranchKeyId);
      assert output
        .EncryptedDataKeyDescriptionOutput()
        .get(0)
        .branchKeyVersion()
        .equals(expectedBranchKeyVersion);
    }
  }

  public static void main(final String[] args) {
    if (args.length < 9) {
      throw new IllegalArgumentException(
        "To run this example, include the tableName, partitionKey, partitionKeyVal," +
        "sortKeyName, sortKeyValue, expectedKeyProviderId, expectedKeyProviderInfo, expectedBranchKeyId and expectedBranchKeyVersion in args"
      );
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
    getEncryptedDataKeyDescription(
      tableName,
      partitionKey,
      partitionKeyVal,
      sortKeyName,
      sortKeyValue,
      expectedKeyProviderId,
      expectedKeyProviderInfo,
      expectedBranchKeyId,
      expectedBranchKeyVersion
    );
  }
}
