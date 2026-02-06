import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.DynamoDBEncryptor;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.EncryptionContext;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.EncryptionFlags;
import software.amazon.cryptools.dynamodbencryptionclientsdk2.encryption.providers.AsymmetricStaticProvider;

/**
 * Example showing use of RSA keys for encryption and signing with DDBEC SDK v2.
 */
public class AsymmetricEncryptedItem {
  private static final String STRING_FIELD_NAME = "example";
  private static final String BINARY_FIELD_NAME = "and some binary";
  private static final String NUMBER_FIELD_NAME = "some numbers";
  private static final String IGNORED_FIELD_NAME = "leave me";

  public static void encryptRecord(
      DynamoDbClient ddbClient,
      String tableName,
      String partitionKeyName,
      String sortKeyName,
      String partitionKeyValue,
      String sortKeyValue)
      throws GeneralSecurityException {
    
    final KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
    keyGen.initialize(2048);
    // You should never use the same key for encryption and signing
    final KeyPair wrappingKeys = keyGen.generateKeyPair();
    final KeyPair signingKeys = keyGen.generateKeyPair();

    // Sample record to be encrypted
    final Map<String, AttributeValue> record = new HashMap<>();
    record.put(partitionKeyName, AttributeValue.builder().s(partitionKeyValue).build());
    record.put(sortKeyName, AttributeValue.builder().n(sortKeyValue).build());
    record.put(STRING_FIELD_NAME, AttributeValue.builder().s("data").build());
    record.put(NUMBER_FIELD_NAME, AttributeValue.builder().n("99").build());
    record.put(
        BINARY_FIELD_NAME,
        AttributeValue.builder().b(SdkBytes.fromByteArray(new byte[] {0x00, 0x01, 0x02})).build());
    record.put(IGNORED_FIELD_NAME, AttributeValue.builder().s("alone").build());

    // Create AsymmetricStaticProvider with wrapping and signing keys
    final AsymmetricStaticProvider cmp = new AsymmetricStaticProvider(wrappingKeys, signingKeys);

    // Create DynamoDBEncryptor
    final DynamoDBEncryptor encryptor = DynamoDBEncryptor.getInstance(cmp);

    // Create EncryptionContext
    final EncryptionContext encryptionContext =
        EncryptionContext.builder()
            .tableName(tableName)
            .hashKeyName(partitionKeyName)
            .rangeKeyName(sortKeyName)
            .build();

    // Configure EncryptionFlags for each attribute
    final EnumSet<EncryptionFlags> signOnly = EnumSet.of(EncryptionFlags.SIGN);
    final EnumSet<EncryptionFlags> encryptAndSign =
        EnumSet.of(EncryptionFlags.ENCRYPT, EncryptionFlags.SIGN);
    final Map<String, Set<EncryptionFlags>> actions = new HashMap<>();

    for (final String attributeName : record.keySet()) {
      switch (attributeName) {
        case "partition_key":
        case "sort_key":
          actions.put(attributeName, signOnly);
          break;
        default:
          if (!attributeName.equals(IGNORED_FIELD_NAME)) {
            actions.put(attributeName, encryptAndSign);
          }
          break;
      }
    }

    // Encrypt the record
    final Map<String, AttributeValue> encrypted_record =
        encryptor.encryptRecord(record, actions, encryptionContext);

    // For demo, verify encryption
    assert encrypted_record.get(STRING_FIELD_NAME).b() != null;
    assert encrypted_record.get(NUMBER_FIELD_NAME).b() != null;
    assert !record.get(BINARY_FIELD_NAME).b().equals(encrypted_record.get(BINARY_FIELD_NAME).b());
    assert record.get(IGNORED_FIELD_NAME).s().equals(encrypted_record.get(IGNORED_FIELD_NAME).s());

    // For demo, the encrypted item is put to DynamoDB. You skip this as needed for their use case.
    ddbClient.putItem(
            PutItemRequest.builder().tableName(tableName).item(encrypted_record).build());

    // Get the item back from DynamoDB
    final Map<String, AttributeValue> keyToGet = new HashMap<>();
    keyToGet.put(partitionKeyName, AttributeValue.builder().s(partitionKeyValue).build());
    keyToGet.put(sortKeyName, AttributeValue.builder().n(sortKeyValue).build());

    final GetItemResponse getResponse =
            ddbClient.getItem(
                    GetItemRequest.builder().tableName(tableName).key(keyToGet).build());

    // Decrypt the record retrieved from DynamoDB
    final Map<String, AttributeValue> decrypted_record =
            encryptor.decryptRecord(getResponse.item(), actions, encryptionContext);

    // For demo, verify decryption
    assert record.get(STRING_FIELD_NAME).s().equals(decrypted_record.get(STRING_FIELD_NAME).s());
    assert record.get(NUMBER_FIELD_NAME).n().equals(decrypted_record.get(NUMBER_FIELD_NAME).n());
    assert record.get(BINARY_FIELD_NAME).b().equals(decrypted_record.get(BINARY_FIELD_NAME).b());
  }

  public static void main(final String[] args) throws GeneralSecurityException {
    if (args.length < 5) {
      throw new IllegalArgumentException(
          "To run this example, include tableName, partitionKeyName, sortKeyName, "
              + "partitionKeyValue, sortKeyValue as args");
    }
    final String tableName = args[0];
    final String partitionKeyName = args[1];
    final String sortKeyName = args[2];
    final String partitionKeyValue = args[3];
    final String sortKeyValue = args[4];
    try (final DynamoDbClient ddbClient = DynamoDbClient.create()) {
      encryptRecord(ddbClient, tableName, partitionKeyName, sortKeyName, partitionKeyValue, sortKeyValue);
    }
  }
}
