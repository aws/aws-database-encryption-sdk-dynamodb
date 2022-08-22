// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.StructuredEncryption; namespace AWS.Cryptography.StructuredEncryption {
 public class DecryptStructureInput {
 private AWS.Cryptography.StructuredEncryption.StructuredData _ciphertextStructure ;
 private System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoSchema> _cryptoSchemas ;
 private AWS.Cryptography.MaterialProviders.IKeyring _keyring ;
 private AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager _cmm ;
 private System.Collections.Generic.Dictionary<string, string> _encryptionContext ;
 public AWS.Cryptography.StructuredEncryption.StructuredData CiphertextStructure {
 get { return this._ciphertextStructure; }
 set { this._ciphertextStructure = value; }
}
 internal bool IsSetCiphertextStructure () {
 return this._ciphertextStructure != null;
}
 public System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoSchema> CryptoSchemas {
 get { return this._cryptoSchemas; }
 set { this._cryptoSchemas = value; }
}
 internal bool IsSetCryptoSchemas () {
 return this._cryptoSchemas != null;
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
 public System.Collections.Generic.Dictionary<string, string> EncryptionContext {
 get { return this._encryptionContext; }
 set { this._encryptionContext = value; }
}
 internal bool IsSetEncryptionContext () {
 return this._encryptionContext != null;
}
 public void Validate() {
 if (!IsSetCiphertextStructure()) throw new System.ArgumentException("Missing value for required property 'CiphertextStructure'");
 if (!IsSetCryptoSchemas()) throw new System.ArgumentException("Missing value for required property 'CryptoSchemas'");

}
}
}
