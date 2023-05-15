package software.aws.cryptography.examples.clientsupplier;

import java.util.HashMap;
import java.util.Map;
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.awssdk.services.sts.model.AssumeRoleRequest;
import software.amazon.awssdk.services.sts.model.Credentials;
import software.amazon.cryptography.materialproviders.IClientSupplier;
import software.amazon.awssdk.services.sts.StsClient;
import software.amazon.cryptography.materialproviders.model.GetClientInput;

public class RegionalRoleClientSupplier implements IClientSupplier {

  private static Map<String, String> regionIamRoleMap;
  private static StsClient stsClient;

  public RegionalRoleClientSupplier() {
    regionIamRoleMap = new HashMap<>();
    regionIamRoleMap.put("us-east-1", "arn:aws:iam::587316601012:role/GitHub-DotNet-KMS-US-East-1-Only");
    regionIamRoleMap.put("eu-west-1", "AWS_ENCRYPTION_SDK_EXAMPLE_LIMITED_ROLE_ARN_EU_WEST_1");
    stsClient = StsClient.create();
  }

  @Override
  public KmsClient GetClient(GetClientInput getClientInput) {
    System.out.println("Using " + getClientInput.region());
    if (!regionIamRoleMap.containsKey(getClientInput.region())) {
      // TODO: Create a MissingRegionException that extends AwsCryptographicMaterialProvidersException.
      // The generated code for AwsCryptographicMaterialProvidersException cannot be extended as-is,
      // as its constructor requires access to a class private to itself.
      throw new RuntimeException("Missing region");
    }

    String arn = regionIamRoleMap.get(getClientInput.region());
    Credentials creds = stsClient.assumeRole(AssumeRoleRequest.builder()
            .roleArn(arn)
            .durationSeconds(900) // 15 minutes is the minimum value
            .roleSessionName("Session-Name")
        .build()).credentials();

    return KmsClient.builder()
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