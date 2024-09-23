use aws_config::Region;
use aws_db_esdk::aws_cryptography_materialProviders::types::ClientSupplier;
use aws_db_esdk::deps::aws_cryptography_materialProviders::operation::get_client::GetClientInput;
use aws_db_esdk::deps::aws_cryptography_materialProviders::types::error::Error;
use aws_db_esdk::deps::com_amazonaws_kms::client::Client as kms_client;
use aws_sdk_sts::Client as sts_client;

/*
 Example class demonstrating an implementation of a custom client supplier.
 This particular implementation will create KMS clients with different IAM roles,
 depending on the region passed.
*/

pub struct RegionalRoleClientSupplier {
    sts_client: sts_client, // private readonly AmazonSecurityTokenServiceClient _stsClient = new AmazonSecurityTokenServiceClient();
}

impl RegionalRoleClientSupplier {
    pub fn new() -> Self {
        let sdk_config = tokio::task::block_in_place(|| {
            tokio::runtime::Handle::current().block_on(async {
                aws_config::load_defaults(aws_config::BehaviorVersion::v2024_03_28()).await
            })
        });
        Self {
            sts_client: sts_client::new(&sdk_config),
        }
    }
}

impl ClientSupplier for RegionalRoleClientSupplier {
    fn get_client(&mut self, input: GetClientInput) -> Result<kms_client, Error> {
        let region = input.region.unwrap();
        let arn =
            super::regional_role_client_supplier_config::region_iam_role_map()[&region].clone();
        let creds = tokio::task::block_in_place(|| {
            tokio::runtime::Handle::current().block_on(async {
                self.sts_client
                    .assume_role()
                    .role_arn(arn)
                    .duration_seconds(900)
                    .role_session_name("Rust-Client-Supplier-Example-Session")
                    .send()
                    .await
            })
        })
        .unwrap();

        let types_cred = creds.credentials.unwrap();
        let config_creds = aws_sdk_sts::config::Credentials::new(
            types_cred.access_key_id(),
            types_cred.secret_access_key(),
            Some(types_cred.session_token().to_string()),
            Some(
                std::time::SystemTime::UNIX_EPOCH
                    + std::time::Duration::from_secs(types_cred.expiration().secs() as u64),
            ),
            "SomeProvider",
        );
        let cred_prov = aws_sdk_kms::config::SharedCredentialsProvider::new(config_creds);

        let sdk_config = tokio::task::block_in_place(|| {
            tokio::runtime::Handle::current().block_on(async {
                aws_config::load_defaults(aws_config::BehaviorVersion::v2024_03_28()).await
            })
        });
        let kms_config = aws_sdk_kms::config::Builder::from(&sdk_config)
            .credentials_provider(cred_prov)
            .region(Region::new(region))
            .build();

        let inner_client = aws_sdk_kms::Client::from_conf(kms_config);
        Ok(aws_db_esdk::deps::com_amazonaws_kms::client::Client {
            inner: inner_client,
        })
    }
}
// protected override IAmazonKeyManagementService _GetClient(GetClientInput getClientInput)
// {
//     String arn = _config.regionIamRoleMap[getClientInput.Region];
//     Credentials creds = _stsClient.AssumeRoleAsync(new AssumeRoleRequest
//     {
//         RoleArn = arn,
//         DurationSeconds = 900, // 15 minutes is the minimum value
//         RoleSessionName = "Java-Client-Supplier-Example-Session"
//     }
//     ).Result.Credentials;

//     return new AmazonKeyManagementServiceClient(creds, RegionEndpoint.GetBySystemName(getClientInput.Region));
// }
