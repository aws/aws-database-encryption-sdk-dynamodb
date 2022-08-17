// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.StructuredEncryption; namespace AWS.Cryptography.StructuredEncryption {
 public class EncryptStructureOutput {
 private AWS.Cryptography.StructuredEncryption.StructuredData _ciphertextStructure ;
 public AWS.Cryptography.StructuredEncryption.StructuredData CiphertextStructure {
 get { return this._ciphertextStructure; }
 set { this._ciphertextStructure = value; }
}
 internal bool IsSetCiphertextStructure () {
 return this._ciphertextStructure != null;
}
 public void Validate() {
 if (!IsSetCiphertextStructure()) throw new System.ArgumentException("Missing value for required property 'CiphertextStructure'");

}
}
}
