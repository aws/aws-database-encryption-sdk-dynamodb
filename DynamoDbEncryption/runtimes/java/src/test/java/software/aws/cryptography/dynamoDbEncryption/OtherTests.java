package software.aws.cryptography.dynamoDbEncryption;

import com.amazonaws.services.kms.AWSKMSClientBuilder;
import org.junit.jupiter.api.Test;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.TableDescription;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.cryptography.materialProviders.Keyring;
import software.amazon.cryptography.materialProviders.MaterialProviders;
import software.amazon.cryptography.materialProviders.model.*;

import java.nio.ByteBuffer;

import static org.junit.jupiter.api.Assertions.*;
import static com.amazonaws.services.kms.model.EncryptionAlgorithmSpec.RSAES_OAEP_SHA_1;
import static software.aws.cryptography.dynamoDbEncryption.TestUtils.KMS_TEST_KEY_ID;

// Here we are testing some manually generated interfaces that don't technically belong to this package,
// but exist alongside this package as a deliverable, and it is easiest to test them here for now.
// TODO these should be moved appropriately when they are properly being generated.
public class OtherTests {

    @Test
    public void TestCreateBranchKeyStore() {
        MaterialProviders materialProviders = MaterialProviders.builder()
                .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
                .build();

        CreateBranchKeyStoreOutput out = materialProviders.CreateBranchKeyStore(
                CreateBranchKeyStoreInput.builder()
                        .tableName("my-branch-keys")
                        .ddbClient(DynamoDbClient.builder().build())
                        .build()
        );
        TableDescription desc = out.tableDescription();
        assertNotNull(desc);
    }

    @Test
    public void TestCreateBranchKey() {
        MaterialProviders materialProviders = MaterialProviders.builder()
                .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
                .build();

        CreateBranchKeyOutput out = materialProviders.CreateBranchKey(
                CreateBranchKeyInput.builder()
                        .tableName("my-branch-keys")
                        .kmsKeyId("<regional-kms-key-id>")
                        .kmsClient(KmsClient.create())
                        .ddbClient(DynamoDbClient.builder().build())
                        .build()
        );

        assertEquals("a89b547a-7062-4048-b455-d850e32ef808", out.branchKeyId());
    }

    @Test
    public void TestVersionBranchKey() {
        MaterialProviders materialProviders = MaterialProviders.builder()
                .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
                .build();

        VersionBranchKeyOutput out = materialProviders.VersionBranchKey(
                VersionBranchKeyInput.builder()
                        .tableName("my-branch-keys")
                        .branchKeyId("a89b547a-7062-4048-b455-d850e32ef808")
                        .kmsKeyId("<regional-kms-key-id>")
                        .kmsClient(KmsClient.builder().build())
                        .ddbClient(DynamoDbClient.builder().build())
                        .build()
        );

        assertEquals(1, out.versionCreated());
    }

    @Test
    public void TestBuildHierarchyKeyringInvalidConfig() {
        MaterialProviders matProv = MaterialProviders.builder()
                .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
                .build();
        BranchKeySupplier branchKeySupplier = matProv.CreateDynamoDbEncryptionBranchKeySupplier(
                CreateDynamoDbEncryptionBranchKeySupplierInput.builder()
                        .branchKeyFromItemSupplier(new TestSupplier())
                        .build());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CreateAwsKmsHierarchicalKeyringInput.builder()
                    .kmsClient(AWSKMSClientBuilder.defaultClient())
                    .kmsKeyId(KMS_TEST_KEY_ID)
                    .branchKeyId("foo")
                    .branchKeySupplier(branchKeySupplier)
                    .branchKeysTableName("branch-keys-table")
                    .ddbClient(DynamoDbClient.create())
                    .ttlMilliseconds(6000l)
                    .maxCacheSize(100)
                    .build();
        });
        assertTrue(exception.getMessage().contains("`branchKeyId` or `branchKeySupplier` cannot both be configured."));

        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> {
            CreateAwsKmsHierarchicalKeyringInput.builder()
                    .kmsClient(AWSKMSClientBuilder.defaultClient())
                    .kmsKeyId(KMS_TEST_KEY_ID)
                    .branchKeysTableName("branch-keys-table")
                    .ddbClient(DynamoDbClient.create())
                    .ttlMilliseconds(6000l)
                    .maxCacheSize(100)
                    .build();
        });
        assertTrue(exception2.getMessage().contains("`branchKeyId` or `branchKeySupplier` must be configured."));
    }

    @Test
    public void TestBuildHierarchyKeyringWithSupplier() {
        MaterialProviders matProv = MaterialProviders.builder()
                .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
                .build();
        BranchKeySupplier branchKeySupplier = matProv.CreateDynamoDbEncryptionBranchKeySupplier(
                CreateDynamoDbEncryptionBranchKeySupplierInput.builder()
                        .branchKeyFromItemSupplier(new TestSupplier())
                        .build());

        CreateAwsKmsHierarchicalKeyringInput keyringInput = CreateAwsKmsHierarchicalKeyringInput.builder()
                .kmsClient(AWSKMSClientBuilder.defaultClient())
                .kmsKeyId(KMS_TEST_KEY_ID)
                .branchKeySupplier(branchKeySupplier)
                .branchKeysTableName("branch-keys-table")
                .ddbClient(DynamoDbClient.create())
                .ttlMilliseconds(6000l)
                .maxCacheSize(100)
                .build();
        Keyring keyring = matProv.CreateAwsKmsHierarchicalKeyring(keyringInput);
        assertNotNull(keyring);
    }

    @Test
    public void TestBuildEncryptDecryptAwsKmsRsaKeyring() {
        MaterialProviders matProv = MaterialProviders.builder()
                .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
                .build();

        ByteBuffer key = ByteBuffer.wrap(new byte[32]);

        CreateAwsKmsRsaKeyringInput input = CreateAwsKmsRsaKeyringInput.builder()
                .kmsClient(AWSKMSClientBuilder.defaultClient())
                .kmsKeyId(KMS_TEST_KEY_ID)
                .encryptionAlgorithm(RSAES_OAEP_SHA_1)
                .publicKey(key)
                .build();
        Keyring keyring = matProv.CreateAwsKmsRsaKeyring(input);
        assertNotNull(keyring);
    }

    class TestSupplier implements BranchKeyFromItemSupplier {
        public String getBranchKeyFromItem(GetBranchKeyFromItemInput input) {
            return "foo";
        }
    }
}
