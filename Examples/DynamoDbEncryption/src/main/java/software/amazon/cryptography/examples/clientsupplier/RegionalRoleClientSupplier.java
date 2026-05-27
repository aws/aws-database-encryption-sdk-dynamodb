package software.amazon.cryptography.examples.clientsupplier;

import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.awssdk.services.sts.StsClient;
import software.amazon.awssdk.services.sts.model.AssumeRoleRequest;
import software.amazon.awssdk.services.sts.model.Credentials;
import software.amazon.cryptography.materialproviders.IClientSupplier;
import software.amazon.cryptography.materialproviders.model.GetClientInput;

/*
  Example class demonstrating an implementation of a custom client supplier.
  This particular implementation will create KMS clients with different IAM roles,
  depending on the region passed.
 */
public class RegionalRoleClientSupplier implements IClientSupplier {

  private static StsClient stsClient;
  private static RegionalRoleClientSupplierConfig config;

  public RegionalRoleClientSupplier() {
    stsClient = StsClient.create();
    config = new RegionalRoleClientSupplierConfig();
  }

  @Override
  public KmsClient GetClient(GetClientInput getClientInput) {
    if (!config.regionIamRoleMap.containsKey(getClientInput.region())) {
      throw new RuntimeException("Missing region");
    }

    String arn = config.regionIamRoleMap.get(getClientInput.region());
    Credentials creds = stsClient
      .assumeRole(
        AssumeRoleRequest
          .builder()
          .roleArn(arn)
          .durationSeconds(900) // 15 minutes is the minimum value
          .roleSessionName("Java-Client-Supplier-Example-Session")
          .build()
      )
      .credentials();

    return KmsClient
      .builder()
      .credentialsProvider(
        StaticCredentialsProvider.create(
          AwsSessionCredentials.create(
            creds.accessKeyId(),
            creds.secretAccessKey(),
            creds.sessionToken()
          )
        )
      )
      .region(Region.of(getClientInput.region()))
      .build();
  }
}
