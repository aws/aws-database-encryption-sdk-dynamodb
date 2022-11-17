// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.StructuredEncryption; namespace AWS.Cryptography.StructuredEncryption {
 public class DecryptStructureInput {
 private AWS.Cryptography.StructuredEncryption.StructuredData _ciphertextStructure ;
 private AWS.Cryptography.StructuredEncryption.AuthenticateSchema _authenticateSchema ;
 private AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager _cmm ;
 private System.Collections.Generic.Dictionary<string, string> _encryptionContext ;
 public AWS.Cryptography.StructuredEncryption.StructuredData CiphertextStructure {
 get { return this._ciphertextStructure; }
 set { this._ciphertextStructure = value; }
}
 internal bool IsSetCiphertextStructure () {
 return this._ciphertextStructure != null;
}
 public AWS.Cryptography.StructuredEncryption.AuthenticateSchema AuthenticateSchema {
 get { return this._authenticateSchema; }
 set { this._authenticateSchema = value; }
}
 internal bool IsSetAuthenticateSchema () {
 return this._authenticateSchema != null;
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
 if (!IsSetAuthenticateSchema()) throw new System.ArgumentException("Missing value for required property 'AuthenticateSchema'");
 if (!IsSetCmm()) throw new System.ArgumentException("Missing value for required property 'Cmm'");

}
}
}
