use aws_config::Region;
use aws_db_esdk::aws_cryptography_materialProviders::types::ClientSupplier;
use aws_db_esdk::deps::aws_cryptography_materialProviders::operation::get_client::GetClientInput;
use aws_db_esdk::deps::aws_cryptography_materialProviders::types::error::Error;
use aws_db_esdk::deps::com_amazonaws_kms::client::Client as kms_client;

/*
 Example class demonstrating an implementation of a custom client supplier.
 This particular implementation will create KMS clients with different IAM roles,
 depending on the region passed.
*/

pub struct RegionalRoleClientSupplier {}

impl ClientSupplier for RegionalRoleClientSupplier {
    fn get_client(&mut self, input: GetClientInput) -> Result<kms_client, Error> {
        let region = input.region.unwrap();
        let arn =
            super::regional_role_client_supplier_config::region_iam_role_map()[&region].clone();

        use aws_config::sts::AssumeRoleProvider;

        let provider = tokio::task::block_in_place(|| {
            tokio::runtime::Handle::current().block_on(async {
                AssumeRoleProvider::builder(arn)
                    .region(Region::new(region.clone()))
                    .session_name("Rust-Client-Supplier-Example-Session")
                    .build()
                    .await
            })
        });

        let sdk_config = tokio::task::block_in_place(|| {
            tokio::runtime::Handle::current().block_on(async {
                aws_config::load_defaults(aws_config::BehaviorVersion::v2024_03_28()).await
            })
        });
        let kms_config = aws_sdk_kms::config::Builder::from(&sdk_config)
            .credentials_provider(provider)
            .region(Region::new(region))
            .build();

        let inner_client = aws_sdk_kms::Client::from_conf(kms_config);
        Ok(aws_db_esdk::deps::com_amazonaws_kms::client::Client {
            inner: inner_client,
        })
    }
}