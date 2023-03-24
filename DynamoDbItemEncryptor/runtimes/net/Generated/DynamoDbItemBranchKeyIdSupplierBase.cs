// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DynamoDbEncryption.Resources; namespace AWS.Cryptography.DynamoDbEncryption.Resources {
 public abstract class DynamoDbItemBranchKeyIdSupplierBase : IDynamoDbItemBranchKeyIdSupplier {
 public AWS.Cryptography.DynamoDbEncryption.Resources.GetBranchKeyIdFromItemOutput GetBranchKeyIdFromItem ( AWS.Cryptography.DynamoDbEncryption.Resources.GetBranchKeyIdFromItemInput input )
 {
 input.Validate(); return _GetBranchKeyIdFromItem ( input ) ;
}
 protected abstract AWS.Cryptography.DynamoDbEncryption.Resources.GetBranchKeyIdFromItemOutput _GetBranchKeyIdFromItem ( AWS.Cryptography.DynamoDbEncryption.Resources.GetBranchKeyIdFromItemInput input ) ;
}
}
