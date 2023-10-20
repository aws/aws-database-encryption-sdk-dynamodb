using System;
using System.Collections.Generic;
using Amazon;

/*
  Class containing config for the RegionalRoleClientSupplier.
  In your own code, this might be hardcoded, or reference
  an external source, e.g. environment variables or AWS AppConfig.
 */

public class RegionalRoleClientSupplierConfig
{
    private static String US_EAST_1_IAM_ROLE =
        "arn:aws:iam::370957321024:role/GitHub-CI-DDBEC-Dafny-Role-only-us-east-1-KMS-keys";

    private static String EU_WEST_1_IAM_ROLE =
        "arn:aws:iam::370957321024:role/GitHub-CI-DDBEC-Dafny-Role-only-eu-west-1-KMS-keys";

    public Dictionary<String, String> regionIamRoleMap = new Dictionary<String, String>
    {
        [RegionEndpoint.USEast1.SystemName] = US_EAST_1_IAM_ROLE,
        [RegionEndpoint.EUWest1.SystemName] = EU_WEST_1_IAM_ROLE
    };
}