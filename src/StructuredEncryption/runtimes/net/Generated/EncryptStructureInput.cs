// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.StructuredEncryption; namespace AWS.Cryptography.StructuredEncryption {
 public class EncryptStructureInput {
 private AWS.Cryptography.StructuredEncryption.StructuredData _plaintextStructure ;
 private AWS.Cryptography.StructuredEncryption.CryptoSchema _cryptoSchema ;
 private AWS.Cryptography.MaterialProviders.IKeyring _keyring ;
 private AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager _cmm ;
 private System.Collections.Generic.Dictionary<string, string> _implicitEncryptionContext ;
 private System.Collections.Generic.Dictionary<string, string> _explicitEncryptionContext ;
 public AWS.Cryptography.StructuredEncryption.StructuredData PlaintextStructure {
 get { return this._plaintextStructure; }
 set { this._plaintextStructure = value; }
}
 internal bool IsSetPlaintextStructure () {
 return this._plaintextStructure != null;
}
 public AWS.Cryptography.StructuredEncryption.CryptoSchema CryptoSchema {
 get { return this._cryptoSchema; }
 set { this._cryptoSchema = value; }
}
 internal bool IsSetCryptoSchema () {
 return this._cryptoSchema != null;
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
 public System.Collections.Generic.Dictionary<string, string> ImplicitEncryptionContext {
 get { return this._implicitEncryptionContext; }
 set { this._implicitEncryptionContext = value; }
}
 internal bool IsSetImplicitEncryptionContext () {
 return this._implicitEncryptionContext != null;
}
 public System.Collections.Generic.Dictionary<string, string> ExplicitEncryptionContext {
 get { return this._explicitEncryptionContext; }
 set { this._explicitEncryptionContext = value; }
}
 internal bool IsSetExplicitEncryptionContext () {
 return this._explicitEncryptionContext != null;
}
 public void Validate() {
 if (!IsSetPlaintextStructure()) throw new System.ArgumentException("Missing value for required property 'PlaintextStructure'");
 if (!IsSetCryptoSchema()) throw new System.ArgumentException("Missing value for required property 'CryptoSchema'");

}
}
}
