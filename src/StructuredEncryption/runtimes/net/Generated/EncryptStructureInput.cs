// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.StructuredEncryption; namespace AWS.Cryptography.StructuredEncryption {
 public class EncryptStructureInput {
 private AWS.Cryptography.StructuredEncryption.StructuredData _plaintextStructure ;
 private AWS.Cryptography.StructuredEncryption.CryptoSchema _cryptoSchema ;
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
 public void Validate() {
 if (!IsSetPlaintextStructure()) throw new System.ArgumentException("Missing value for required property 'PlaintextStructure'");
 if (!IsSetCryptoSchema()) throw new System.ArgumentException("Missing value for required property 'CryptoSchema'");

}
}
}
