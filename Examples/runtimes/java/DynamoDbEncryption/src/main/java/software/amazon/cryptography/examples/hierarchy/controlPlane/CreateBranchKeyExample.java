package software.amazon.cryptography.examples.hierarchy.controlPlane;

import java.time.Duration;

import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.http.SdkHttpClient;
import software.amazon.awssdk.http.apache.ApacheHttpClient;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.cryptography.keystore.KeyStore;
import software.amazon.cryptography.keystore.model.CreateKeyInput;

/*
  The Hierarchical Keyring Example and Searchable Encryption Examples
  rely on the existence of a DDB-backed key store with pre-existing
  branch key material or beacon key material.

  See the "Create KeyStore Table Example" for how to first set up
  the DDB Table that will back this KeyStore.

  This example demonstrates configuring a KeyStore and then
  using a helper method to create a branch key and beacon key
  that share the same Id, then return that Id.
  We will always create a new beacon key alongside a new branch key,
  even if you are not using searchable encryption.

  This key creation should occur within your control plane.
 */
@SuppressWarnings("UnnecessaryLocalVariable")
public class CreateBranchKeyExample {
    public static String KeyStoreCreateKey(
        String keyStoreTableName,
        String logicalKeyStoreName,
        String kmsKeyArn,
        DynamoDbClient keystoreAdminDDBClient,
        SdkHttpClient kmsHTTPClient,
        AwsCredentialsProvider kmsCredentials
    ) {
        final StrictKeyStoreFactory factory = new StrictKeyStoreFactory(
            kmsHTTPClient,
            keystoreAdminDDBClient,
            keyStoreTableName,
            logicalKeyStoreName);
        // 1. Configure your KeyStore resource.
        //    See StrictKeyStoreFactory.
        //    Only Strict KeyStores can Create or Version Branch Keys
        final KeyStore keystore = factory.getKeyStore(kmsKeyArn, kmsCredentials);

        // 2. Create a new branch key and beacon key in our KeyStore.
        //    Both the branch key and the beacon key will share an Id.
        //    This creation is eventually consistent.
        //    This MUST be done before data can be encrypted or decrypted with this Branch Key.
        //    Ideally, for the Multi-Tenant use case,
        //    Branch Key Creation is executed when a tenant
        //    onboards to the service or application.
        final String branchKeyId = keystore.CreateKey(CreateKeyInput.builder().build()).branchKeyIdentifier();

        return branchKeyId;
    }

    public static void main(final String[] args) {
        if (args.length <= 1) {
            throw new IllegalArgumentException("To run this example, include the keyStoreTableName, logicalKeyStoreName, and kmsKeyArn in args");
        }
        final String keyStoreTableName = args[0];
        final String logicalKeyStoreName = args[1];
        final String kmsKeyArn = args[2];
        // It is more efficient to re-use these than create unique ones for DDB & KMS.
        final AwsCredentialsProvider defaultCreds = DefaultCredentialsProvider.create();
        final SdkHttpClient httpClient = ApacheHttpClient.builder()
            .connectionTimeToLive(Duration.ofSeconds(5)).build();
        final DynamoDbClient keystoreAdminDDBClient = DynamoDbClient.builder()
            .httpClient(httpClient)
            .credentialsProvider(defaultCreds)
            .build();
        KeyStoreCreateKey(keyStoreTableName, logicalKeyStoreName, kmsKeyArn, keystoreAdminDDBClient, httpClient, defaultCreds);
    }
}
