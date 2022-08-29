// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DynamoDBEncryption; namespace AWS.Cryptography.DynamoDBEncryption {
 public class CreateDynamoDBItemEncryptorOutput {
 private AWS.Cryptography.DynamoDBEncryption.IDynamoDBItemEncryptor _itemEncryptor ;
 public AWS.Cryptography.DynamoDBEncryption.IDynamoDBItemEncryptor ItemEncryptor {
 get { return this._itemEncryptor; }
 set { this._itemEncryptor = value; }
}
 internal bool IsSetItemEncryptor () {
 return this._itemEncryptor != null;
}
 public void Validate() {
 
}
}
}
