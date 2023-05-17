package software.aws.cryptography.examples.migrateexistingtable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.BatchWriteItemEnhancedRequest;
import software.amazon.awssdk.enhanced.dynamodb.model.WriteBatch;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.LegacyConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.PlaintextPolicy;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.MaterialProviders;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsKeyringInput;
import software.amazon.cryptography.materialproviders.model.MaterialProvidersConfig;
import software.aws.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryptionInterceptor;
import software.aws.cryptography.dbencryptionsdk.dynamodb.enhancedclient.CreateDynamoDbEncryptionInterceptorInput;
import software.aws.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEnhancedClientEncryption;
import software.aws.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEnhancedTableEncryptionConfig;
import software.aws.cryptography.examples.migrateexistingtable.examplepojos.PlaintextCatalogItem;

public class PlaintextToEncryptedMigrationExample {


    public static void setupPlaintextTable(String ddbTableName) {
        // To set up the plaintext table for our example,
        // we will add 2 plaintext items to an empty table.

        // 1. Create a DDB enhanced client.
        DynamoDbClient ddb = DynamoDbClient.builder()
            .region(Region.US_EAST_1)
            .build();
        DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
            .dynamoDbClient(ddb)
            .build();

        // 2. Create an object and add it to the table.
        PlaintextCatalogItem firstBook = new PlaintextCatalogItem();
        firstBook.setId(0);
        firstBook.setTitle("Fluid Concepts and Creative Analogies");
        firstBook.setBookAuthors(Collections.singleton("Douglas Hofstadter"));
        firstBook.setISBN("978-0-7450-1065-6");

        List<WriteBatch> writeBatchList = new ArrayList<>();
        writeBatchList.add(WriteBatch.builder(PlaintextCatalogItem.class)
            .addPutItem(firstBook)
            .build());

        enhancedClient.batchWriteItem(BatchWriteItemEnhancedRequest.builder()
            .writeBatches(writeBatchList)
            .build());
    }

    public static void step1() {
        // Create KMS Keyring
        MaterialProviders matProv = MaterialProviders.builder()
            .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
            .build();
        CreateAwsKmsKeyringInput keyringInput = CreateAwsKmsKeyringInput.builder()
            .kmsKeyId("my-kms-key-arn")
            .kmsClient(KmsClient.create())
            .build();
        IKeyring kmsKeyring = matProv.CreateAwsKmsKeyring(keyringInput);

        // Create encryption configuration for table
        TableSchema<PlaintextCatalogItem> tableSchema = TableSchema.fromBean(PlaintextCatalogItem.class);
        Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs = new HashMap<>();
        tableConfigs.put("CatalogItem",
            DynamoDbEnhancedTableEncryptionConfig.builder()
                .keyring(kmsKeyring)
                .tableSchema(tableSchema)
                .allowedUnauthenticatedAttributes(Collections.singletonList("bookAuthors"))
                .build());
        
        // Create DynamoDbEncryptionInterceptor
        DynamoDbEncryptionInterceptor interceptor =
            DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
                CreateDynamoDbEncryptionInterceptorInput.builder()
                    .tableEncryptionConfigs(tableConfigs)
                    .build());

        // Create the EnhancedClient with encryption
        DynamoDbClient ddb = DynamoDbClient.builder()
            .region(Region.US_EAST_1)
            .overrideConfiguration(
                ClientOverrideConfiguration.builder()
                    .addExecutionInterceptor(interceptor)
                    .build())
            .build();
        DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
            .dynamoDbClient(ddb)
            .build();

        // Create DynamoDbEncryptionInterceptor
        DynamoDbEncryptionInterceptor interceptor =
            DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
                CreateDynamoDbEncryptionInterceptorInput.builder()
                    .tableEncryptionConfigs(tableConfigs)
                    .plaintextPolicy(PlaintextPolicy.REQUIRE_WRITE_ALLOW_READ)
                    .build());
    }

    public void step2() {

    }

    public void step3() {

    }

    public static void configureEncryptedReadWritePlaintextReadClient() {
        //

    }

    public static void encryptPlaintextTable() {

    }

    public static void configureEncryptedReadWritePlaintextForbiddenClient() {

    }

    public static void migrateExistingTable(String ddbTableName) {
        step1();
        configureEncryptedReadWritePlaintextReadClient();
        encryptPlaintextTable();
        configureEncryptedReadWritePlaintextForbiddenClient();
    }

    public static void main(final String[] args) {
        migrateExistingTable("testStr");
    }
}
