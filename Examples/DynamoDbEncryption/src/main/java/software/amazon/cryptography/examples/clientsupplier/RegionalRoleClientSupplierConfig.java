package software.amazon.cryptography.examples.clientsupplier;

import java.util.HashMap;
import java.util.Map;
import software.amazon.awssdk.regions.Region;

/*
  Class containing config for the RegionalRoleClientSupplier.
  In your own code, this might be hardcoded, or reference
  an external source, e.g. environment variables or AWS AppConfig.
 */

public class RegionalRoleClientSupplierConfig {

  private static final String US_EAST_1_IAM_ROLE =
    "arn:aws:iam::370957321024:role/GitHub-CI-DDBEC-Dafny-Role-only-us-east-1-KMS-keys";
  private static final String EU_WEST_1_IAM_ROLE =
    "arn:aws:iam::370957321024:role/GitHub-CI-DDBEC-Dafny-Role-only-eu-west-1-KMS-keys";

  public Map<String, String> regionIamRoleMap;

  public RegionalRoleClientSupplierConfig() {
    regionIamRoleMap = new HashMap<>();
    regionIamRoleMap.put(Region.US_EAST_1.id(), US_EAST_1_IAM_ROLE);
    regionIamRoleMap.put(Region.EU_WEST_1.id(), EU_WEST_1_IAM_ROLE);
  }
}
