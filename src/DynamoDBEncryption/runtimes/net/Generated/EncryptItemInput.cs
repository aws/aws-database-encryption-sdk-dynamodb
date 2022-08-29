// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DynamodbEncryption; namespace AWS.Cryptography.DynamodbEncryption {
 public class EncryptItemInput {
 private System.Collections.Generic.Dictionary<string, Com.Amazonaws.Dynamodb.AttributeValue> _item ;
 private System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction> _cryptoSchema ;
 private System.Collections.Generic.Dictionary<string, string> _encryptionContext ;
 private System.Collections.Generic.List<string> _requiredContextFieldsOnDecrypt ;
 private AWS.Cryptography.MaterialProviders.IKeyring _keyring ;
 private AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager _cmm ;
 public System.Collections.Generic.Dictionary<string, Com.Amazonaws.Dynamodb.AttributeValue> Item {
 get { return this._item; }
 set { this._item = value; }
}
 internal bool IsSetItem () {
 return this._item != null;
}
 public System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction> CryptoSchema {
 get { return this._cryptoSchema; }
 set { this._cryptoSchema = value; }
}
 internal bool IsSetCryptoSchema () {
 return this._cryptoSchema != null;
}
 public System.Collections.Generic.Dictionary<string, string> EncryptionContext {
 get { return this._encryptionContext; }
 set { this._encryptionContext = value; }
}
 internal bool IsSetEncryptionContext () {
 return this._encryptionContext != null;
}
 public System.Collections.Generic.List<string> RequiredContextFieldsOnDecrypt {
 get { return this._requiredContextFieldsOnDecrypt; }
 set { this._requiredContextFieldsOnDecrypt = value; }
}
 internal bool IsSetRequiredContextFieldsOnDecrypt () {
 return this._requiredContextFieldsOnDecrypt != null;
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
 if (!IsSetItem()) throw new System.ArgumentException("Missing value for required property 'Item'");
 if (!IsSetCryptoSchema()) throw new System.ArgumentException("Missing value for required property 'CryptoSchema'");

}
}
}
