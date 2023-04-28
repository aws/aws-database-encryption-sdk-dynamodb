// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DynamoDbEncryption; namespace AWS.Cryptography.DynamoDbEncryption {
 public abstract class DynamoDbKeyBranchKeyIdSupplierBase : IDynamoDbKeyBranchKeyIdSupplier {
 public AWS.Cryptography.DynamoDbEncryption.GetBranchKeyIdFromDdbKeyOutput GetBranchKeyIdFromDdbKey ( AWS.Cryptography.DynamoDbEncryption.GetBranchKeyIdFromDdbKeyInput input )
 {
 input.Validate(); return _GetBranchKeyIdFromDdbKey ( input ) ;
}
 protected abstract AWS.Cryptography.DynamoDbEncryption.GetBranchKeyIdFromDdbKeyOutput _GetBranchKeyIdFromDdbKey ( AWS.Cryptography.DynamoDbEncryption.GetBranchKeyIdFromDdbKeyInput input ) ;
}
}
