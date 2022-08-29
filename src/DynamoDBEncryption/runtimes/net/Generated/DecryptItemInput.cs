// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DynamodbEncryption; namespace AWS.Cryptography.DynamodbEncryption {
 public class DecryptItemInput {
 private System.Collections.Generic.Dictionary<string, Com.Amazonaws.Dynamodb.AttributeValue> _encryptedItem ;
 private System.Collections.Generic.Dictionary<string, string> _encryptionContext ;
 private AWS.Cryptography.MaterialProviders.IKeyring _keyring ;
 private AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager _cmm ;
 public System.Collections.Generic.Dictionary<string, Com.Amazonaws.Dynamodb.AttributeValue> EncryptedItem {
 get { return this._encryptedItem; }
 set { this._encryptedItem = value; }
}
 internal bool IsSetEncryptedItem () {
 return this._encryptedItem != null;
}
 public System.Collections.Generic.Dictionary<string, string> EncryptionContext {
 get { return this._encryptionContext; }
 set { this._encryptionContext = value; }
}
 internal bool IsSetEncryptionContext () {
 return this._encryptionContext != null;
}
 public AWS.Cryptography.MaterialProviders.IKeyring Keyring {
 get { return this._keyring; }
 set { this._keyring = value; }
}
 internal bool IsSetKeyring () {
 return this._keyring != null;
}
 public AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager Cmm {
 get { return this._cmm; }
 set { this._cmm = value; }
}
 internal bool IsSetCmm () {
 return this._cmm != null;
}
 public void Validate() {
 if (!IsSetEncryptedItem()) throw new System.ArgumentException("Missing value for required property 'EncryptedItem'");

}
}
}
