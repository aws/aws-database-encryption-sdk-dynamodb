// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DynamoDbEncryption; namespace AWS.Cryptography.DynamoDbEncryption {
 public class CreateDynamoDbEncryptionBranchKeyIdSupplierOutput {
 private AWS.Cryptography.MaterialProviders.IBranchKeyIdSupplier _branchKeyIdSupplier ;
 public AWS.Cryptography.MaterialProviders.IBranchKeyIdSupplier BranchKeyIdSupplier {
 get { return this._branchKeyIdSupplier; }
 set { this._branchKeyIdSupplier = value; }
}
 public bool IsSetBranchKeyIdSupplier () {
 return this._branchKeyIdSupplier != null;
}
 public void Validate() {
 if (!IsSetBranchKeyIdSupplier()) throw new System.ArgumentException("Missing value for required property 'BranchKeyIdSupplier'");

}
}
}
