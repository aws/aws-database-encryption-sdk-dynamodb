/*
  Example class demonstrating an implementation of a custom client supplier.
  This particular implementation will create KMS clients with different IAM roles,
  depending on the region passed.
 */

using System;
using Amazon;
using Amazon.KeyManagementService;
using Amazon.SecurityToken;
using Amazon.SecurityToken.Model;
using AWS.Cryptography.MaterialProviders;

public class RegionalRoleClientSupplier : ClientSupplierBase
{
    private readonly AmazonSecurityTokenServiceClient _stsClient = new AmazonSecurityTokenServiceClient();
    private readonly RegionalRoleClientSupplierConfig _config = new RegionalRoleClientSupplierConfig();

    protected override IAmazonKeyManagementService _GetClient(GetClientInput getClientInput)
    {
        String arn = _config.regionIamRoleMap[getClientInput.Region];
        Credentials creds = _stsClient.AssumeRoleAsync(new AssumeRoleRequest
        {
            RoleArn = arn,
            DurationSeconds = 900, // 15 minutes is the minimum value
            RoleSessionName = "Java-Client-Supplier-Example-Session"
        }
        ).Result.Credentials;

        return new AmazonKeyManagementServiceClient(creds, RegionEndpoint.GetBySystemName(getClientInput.Region));
    }
}
