// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DynamoDbEncryption; namespace AWS.Cryptography.DynamoDbEncryption {
 public class LegacyConfig {
 private AWS.Cryptography.DynamoDbEncryption.LegacyPolicy _policy ;
 private AWS.Cryptography.DynamoDbEncryption.ILegacyDynamoDbEncryptor _encryptor ;
 private System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction> _attributeFlags ;
 private AWS.Cryptography.StructuredEncryption.CryptoAction _defaultAttributeFlag ;
 public AWS.Cryptography.DynamoDbEncryption.LegacyPolicy Policy {
 get { return this._policy; }
 set { this._policy = value; }
}
 public bool IsSetPolicy() {
 return this._policy != null;
}
 public AWS.Cryptography.DynamoDbEncryption.ILegacyDynamoDbEncryptor Encryptor {
 get { return this._encryptor; }
 set { this._encryptor = value; }
}
 public bool IsSetEncryptor() {
 return this._encryptor != null;
}
 public System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction> AttributeFlags {
 get { return this._attributeFlags; }
 set { this._attributeFlags = value; }
}
 public bool IsSetAttributeFlags() {
 return this._attributeFlags != null;
}
 public AWS.Cryptography.StructuredEncryption.CryptoAction DefaultAttributeFlag {
 get { return this._defaultAttributeFlag; }
 set { this._defaultAttributeFlag = value; }
}
 public bool IsSetDefaultAttributeFlag() {
 return this._defaultAttributeFlag != null;
}
 public void Validate() {
 if (!IsSetPolicy()) throw new System.ArgumentException("Missing value for required property 'Policy'");
 if (!IsSetEncryptor()) throw new System.ArgumentException("Missing value for required property 'Encryptor'");
 if (!IsSetAttributeFlags()) throw new System.ArgumentException("Missing value for required property 'AttributeFlags'");

}
}
}
