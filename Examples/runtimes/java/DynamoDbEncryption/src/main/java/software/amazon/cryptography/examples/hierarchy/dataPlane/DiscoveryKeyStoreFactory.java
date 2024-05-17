package software.amazon.cryptography.examples.hierarchy.dataPlane;

import java.util.List;
import java.util.Objects;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.http.SdkHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.cryptography.keystore.KeyStore;
import software.amazon.cryptography.keystore.model.Discovery;
import software.amazon.cryptography.keystore.model.KMSConfiguration;
import software.amazon.cryptography.keystore.model.KeyStoreConfig;
import software.amazon.cryptography.keystore.model.MRDiscovery;

/**
 * This factory class demonstrates various ways to provide
 * a "Discovery" Key Store instance.
 * That is a Key Store that MAY use the KMS Key ARNs already persisted to
 * the backing table,
 * provided they are in records created with an identical Logical Key Store name
 * (i.e: in the same "conceptual Key Store").
 * Such Key Stores can NOT be used to Create or Version Branch Keys.
 * <p>
 * These Key Stores are also appropriate for applications that
 * protect different tenants with different KMS Keys.
 * <p>
 * However, even these Multi-KMS-Key applications will need to use
 * the Strict KeyStore configurations to Administrate their "conceptual Key Store"
 * (that is, Create or Version Branch Keys).
 * <p>
 * By "conceptual Key Store", we mean all the Branch Keys persisted
 * with the same Logical Table Name in the same backing Table.
 * <p>
 * There are two "Discovery" configurations:
 * <ul>
 *     <li>{@code discovery} : Use the KMS Key recorded in the requested Branch Key's record as is.</li>
 *     <li>{@code mrDiscovery} : If the KMS Key recorded in the requested Branch Key's record is a KMS Multi-Region Key, replace the region with this region.</li>
 * </ul>
 * Both configurations work with Single Region or Multi-Region KMS Keys.
 * <p>
 * Key Stores with a KMS Configuration of {@code mrDiscovery} enable Multi-Region applications
 * to use a local replication of the KMS Multi-Region Key.
 * <p>
 * Note: Neither configuration works with KMS Aliases.
 */
@ThreadSafe
public class DiscoveryKeyStoreFactory {
    private final SdkHttpClient httpClient;
    private final DynamoDbClient dynamoDbClient;
    private final String backingTableName;
    private final String logicalName;
    // Loading the Default Credentials takes time.
    // If you can do it once, and provide them to future clients,
    // that saves on effort.
    private final AwsCredentialsProvider defaultCreds = DefaultCredentialsProvider.create();

    public DiscoveryKeyStoreFactory(
        @Nonnull SdkHttpClient httpClient,
        @Nonnull DynamoDbClient dynamoDbClient,
        @Nonnull String backingTableName,
        @Nonnull String logicalKeyStoreName
    ) {
        // Some Applications may need to use specific credentials,
        // like Grant Tokens, for a KMS Key.
        // By re-using an HTTP Client across KMS Clients,
        // we can customize the credentials without re-doing
        // the TLS handshake.
        this.httpClient = httpClient;
        this.dynamoDbClient = dynamoDbClient;
        this.backingTableName = backingTableName;
        this.logicalName = logicalKeyStoreName;
    }

    public KeyStore getKeyStore()
    {
        return this.getKeyStore(this.defaultCreds, null);
    }

    public KeyStore getKeyStore(
        @Nonnull AwsCredentialsProvider kmsCredentials)
    {
        return this.getKeyStore(kmsCredentials, null);
    }

    public KeyStore getKeyStore(
        @Nonnull AwsCredentialsProvider kmsCredentials,
        @Nullable List<String> grantTokens
    ) {
        KmsClient kmsClient = KmsClient.builder()
            .httpClient(this.httpClient)
            .credentialsProvider(kmsCredentials)
            .build();
        KeyStoreConfig.Builder config = commonBuilder(grantTokens, kmsClient);
        config.kmsConfiguration(KMSConfiguration.builder()
            .discovery(Discovery.builder().build())
            .build());
        return KeyStore.builder().KeyStoreConfig(config.build()).build();
    }

    public KeyStore getMRKeyStore(
        @Nonnull Region region
    ) {
        return this.getMRKeyStore(this.defaultCreds, region, null);
    }

    public KeyStore getMRKeyStore(
        @Nonnull AwsCredentialsProvider kmsCredentials,
        @Nonnull Region region
    ) {
        return this.getMRKeyStore(kmsCredentials, region, null);
    }

    public KeyStore getMRKeyStore(
        @Nonnull AwsCredentialsProvider kmsCredentials,
        @Nonnull Region region,
        @Nullable List<String> grantTokens
    ) {
        KmsClient kmsClient = KmsClient.builder()
            .httpClient(this.httpClient)
            .credentialsProvider(kmsCredentials)
            .region(region)
            .build();
        KeyStoreConfig.Builder config = commonBuilder(grantTokens, kmsClient);
        config.kmsConfiguration(KMSConfiguration.builder()
            .mrDiscovery(MRDiscovery.builder().region(region.toString()).build())
            .build());
        return KeyStore.builder().KeyStoreConfig(config.build()).build();
    }

    private KeyStoreConfig.Builder commonBuilder(List<String> grantTokens, KmsClient kmsClient) {
        KeyStoreConfig.Builder config = KeyStoreConfig.builder()
            .ddbClient(this.dynamoDbClient)
            .kmsClient(kmsClient)
            .logicalKeyStoreName(this.logicalName)
            .ddbTableName(this.backingTableName);
        if (Objects.nonNull(grantTokens) && grantTokens.size() > 0) {
            config.grantTokens(grantTokens);
        }
        return config;
    }
}
