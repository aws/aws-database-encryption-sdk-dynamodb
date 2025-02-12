// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

use aws_db_esdk::dynamodb::operation::get_branch_key_id_from_ddb_key::GetBranchKeyIdFromDdbKeyInput;
use aws_db_esdk::dynamodb::operation::get_branch_key_id_from_ddb_key::GetBranchKeyIdFromDdbKeyOutput;
use aws_db_esdk::dynamodb::types::error::Error;
use aws_db_esdk::dynamodb::types::DynamoDbKeyBranchKeyIdSupplier;

// Used in the 'HierarchicalKeyringExample'.
// In that example, we have a table where we distinguish multiple tenants
// by a tenant ID that is stored in our partition attribute.
// The expectation is that this does not produce a confused deputy
// because the tenants are separated by partition.
// In order to create a Hierarchical Keyring that is capable of encrypting or
// decrypting data for either tenant, we implement this interface
// to map the correct branch key ID to the correct tenant ID.
pub struct ExampleBranchKeyIdSupplier {
    branch_key_id_for_tenant1: String,
    branch_key_id_for_tenant2: String,
}

impl ExampleBranchKeyIdSupplier {
    pub fn new(tenant1_id: &str, tenant2_id: &str) -> Self {
        Self {
            branch_key_id_for_tenant1: tenant1_id.to_string(),
            branch_key_id_for_tenant2: tenant2_id.to_string(),
        }
    }
}

impl DynamoDbKeyBranchKeyIdSupplier for ExampleBranchKeyIdSupplier {
    fn get_branch_key_id_from_ddb_key(
        &self,
        input: GetBranchKeyIdFromDdbKeyInput,
    ) -> Result<GetBranchKeyIdFromDdbKeyOutput, Error> {
        let key = input.ddb_key.unwrap();

        if !key.contains_key("partition_key") {
            return Err(Error::DynamoDbEncryptionException {
                message: "Item invalid, does not contain expected partition key attribute."
                    .to_string(),
            });
        }
        let tenant_key_id = key["partition_key"].as_s().unwrap();

        if tenant_key_id == "tenant1Id" {
            Ok(GetBranchKeyIdFromDdbKeyOutput::builder()
                .branch_key_id(self.branch_key_id_for_tenant1.clone())
                .build()
                .unwrap())
        } else if tenant_key_id == "tenant2Id" {
            Ok(GetBranchKeyIdFromDdbKeyOutput::builder()
                .branch_key_id(self.branch_key_id_for_tenant2.clone())
                .build()
                .unwrap())
        } else {
            Err(Error::DynamoDbEncryptionException {
                message: "Item does not contain valid tenant ID.".to_string(),
            })
        }
    }
}
