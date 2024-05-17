package software.amazon.cryptography.examples.hierarchy.controlPlane;

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
import software.amazon.cryptography.keystore.model.KMSConfiguration;
import software.amazon.cryptography.keystore.model.KeyStoreConfig;

/**
 * This factory class demonstrates various ways to provide
 * a "Strict" Key Store instance.
 * That is a Key Store that only works with a particular KMS Key ARN.
 * Such Key Stores can be used to Create or Version Branch Keys,
 * and thus are REQUIRED for Key Store Administration.
 * <p>
 * These Key Stores are also appropriate for Applications that
 * protect all their tenants with one KMS Key.
 * <p>
 * Or for Searchable Encryption configurations that only use one KMS Key.
 * <p>
 * If an Application needs to use different KMS Keys per Tenant,
 * then the Discovery Configurations are more helpful.
 * See the DiscoveryKeyStoreFactory.
 * <p>
 * However, even these Multi-KMS-Key applications will need to use
 * the Strict KeyStore configurations to Administrate their "conceptual Key Store"
 * (that is, Create or Version Branch Keys).
 * <p>
 * By "conceptual Key Store", we mean all the Branch Keys persisted
 * with the same Logical Table Name
 * in the same backing Table.
 * <p>
 * There are two "strict" configurations:
 * <ul>
 *     <li>{@code kmsKeyArn} : Only use this KMS Key</li>
 *     <li>{@code kmsMRKeyArn} : Only use this Replication of a KMS Multi-Region Key</li>
 * </ul>
 * Both configurations accept Single Region or Multi-Region KMS Keys.
 * <p>
 * Key Stores with a KMS Configuration of {@code kmsKeyArn} reject any Branch Keys
 * encountered that are protected by a different KMS Key.
 * <p>
 * Key Stores with a KMS Configuration of {@code kmsMRKeyArn} reject any Branch Keys
 * encountered that are not protected by any replication of this KMS Multi-Region Key;
 * unless the KMS ARN passed is NOT a KMS Multi-Region Key.
 * If the KMS ARN passed is not a KMS Multi-Region Key,
 * {@code kmsMRKeyArn} behaves as {@code kmsKeyArn}.
 * <p>
 * Note: Neither configuration accepts KMS Aliases.
 */
@ThreadSafe
public class StrictKeyStoreFactory {
    private final SdkHttpClient httpClient;
    private final DynamoDbClient dynamoDbClient;
    private final String backingTableName;
    private final String logicalName;
    // Loading the Default Credentials takes time.
    // If you can do it once, and provide them to future clients,
    // that saves on effort.
    private final AwsCredentialsProvider defaultCreds = DefaultCredentialsProvider.create();

    public StrictKeyStoreFactory(
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

    public KeyStore getKeyStore(@Nonnull String kmsKeyArn)
    {
        return this.getKeyStore(kmsKeyArn, this.defaultCreds, null);
    }

    public KeyStore getKeyStore(
        @Nonnull String kmsKeyArn,
        @Nonnull AwsCredentialsProvider kmsCredentials)
    {
        return this.getKeyStore(kmsKeyArn, kmsCredentials, null);
    }

    public KeyStore getKeyStore(
        @Nonnull String kmsKeyArn,
        @Nonnull AwsCredentialsProvider kmsCredentials,
        @Nullable List<String> grantTokens
    ) {
        KmsClient kmsClient = KmsClient.builder()
            .httpClient(this.httpClient)
            .credentialsProvider(kmsCredentials)
            .build();
        KeyStoreConfig.Builder config = commonBuilder(grantTokens, kmsClient);
        config.kmsConfiguration(KMSConfiguration.builder()
            .kmsKeyArn(kmsKeyArn)
            .build());
        return KeyStore.builder().KeyStoreConfig(config.build()).build();
    }

    public KeyStore getMRKeyStore(
        @Nonnull String kmsKeyArn,
        @Nonnull Region region
    ) {
        return this.getMRKeyStore(kmsKeyArn, this.defaultCreds, region, null);
    }

    public KeyStore getMRKeyStore(
        @Nonnull String kmsKeyArn,
        @Nonnull AwsCredentialsProvider kmsCredentials,
        @Nonnull Region region
    ) {
        return this.getMRKeyStore(kmsKeyArn, kmsCredentials, region, null);
    }

    public KeyStore getMRKeyStore(
        @Nonnull String kmsKeyArn,
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
            .kmsMRKeyArn(kmsKeyArn)
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
