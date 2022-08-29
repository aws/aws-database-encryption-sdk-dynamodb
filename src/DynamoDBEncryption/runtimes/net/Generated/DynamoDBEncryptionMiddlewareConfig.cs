// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DynamoDBEncryption; namespace AWS.Cryptography.DynamoDBEncryption {
 public class DynamoDBEncryptionMiddlewareConfig {
 private AWS.Cryptography.DynamoDBEncryption.IDynamoDBItemEncryptor _encryptor ;
 private System.Collections.Generic.Dictionary<string, AWS.Cryptography.DynamoDBEncryption.KeyAttributeNames> _primaryKeyAttributeNames ;
 public AWS.Cryptography.DynamoDBEncryption.IDynamoDBItemEncryptor Encryptor {
 get { return this._encryptor; }
 set { this._encryptor = value; }
}
 internal bool IsSetEncryptor () {
 return this._encryptor != null;
}
 public System.Collections.Generic.Dictionary<string, AWS.Cryptography.DynamoDBEncryption.KeyAttributeNames> PrimaryKeyAttributeNames {
 get { return this._primaryKeyAttributeNames; }
 set { this._primaryKeyAttributeNames = value; }
}
 internal bool IsSetPrimaryKeyAttributeNames () {
 return this._primaryKeyAttributeNames != null;
}
 public void Validate() {
 if (!IsSetEncryptor()) throw new System.ArgumentException("Missing value for required property 'Encryptor'");
 if (!IsSetPrimaryKeyAttributeNames()) throw new System.ArgumentException("Missing value for required property 'PrimaryKeyAttributeNames'");

}
}
}
