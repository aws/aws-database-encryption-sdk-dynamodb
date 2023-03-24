// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
namespace aws.cryptography.dynamoDbEncryption.resources

use aws.polymorph#localService
use aws.polymorph#reference
use aws.polymorph#extendable

use com.amazonaws.dynamodb#AttributeMap
use aws.cryptography.materialProviders#BranchKeyIdSupplierReference

@localService(
  sdkId: "DynamoDbEncryptionResources",
  config: DynamoDbEncryptionResourcesConfig,
)
service DynamoDbEncryptionResources {
    version: "2022-08-26",
    operations: [CreateDynamoDbEncryptionBranchKeyIdSupplier],
    errors: [DynamoDbEncryptionResourcesException],
}

structure DynamoDbEncryptionResourcesConfig{
}

@extendable
resource DynamoDbItemBranchKeyIdSupplier{
  operations: [GetBranchKeyIdFromItem]
}

@reference(resource: DynamoDbItemBranchKeyIdSupplier)
structure DynamoDbItemBranchKeyIdSupplierReference {}

operation GetBranchKeyIdFromItem {
  input: GetBranchKeyIdFromItemInput,
  output: GetBranchKeyIdFromItemOutput
}

structure GetBranchKeyIdFromItemInput {
  @required
  ddbItem: AttributeMap
}

structure GetBranchKeyIdFromItemOutput {
  @required
  branchKeyId: String
}

operation CreateDynamoDbEncryptionBranchKeyIdSupplier {
  input: CreateDynamoDbEncryptionBranchKeyIdSupplierInput,
  output: CreateDynamoDbEncryptionBranchKeyIdSupplierOutput
}

structure CreateDynamoDbEncryptionBranchKeyIdSupplierInput {
  @required
  ddbItemBranchKeyIdSupplier: DynamoDbItemBranchKeyIdSupplierReference,
}

structure CreateDynamoDbEncryptionBranchKeyIdSupplierOutput {
  @required
  branchKeyIdSupplier: BranchKeyIdSupplierReference 
}

/////////////
// Errors

@error("client")
structure DynamoDbEncryptionResourcesException {
  @required
  message: String,
}
