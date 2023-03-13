// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.StructuredEncryption; namespace AWS.Cryptography.StructuredEncryption {
 public class EncryptStructureOutput {
 private AWS.Cryptography.StructuredEncryption.StructuredData _encryptedStructure ;
 public AWS.Cryptography.StructuredEncryption.StructuredData EncryptedStructure {
 get { return this._encryptedStructure; }
 set { this._encryptedStructure = value; }
}
 public bool IsSetEncryptedStructure () {
 return this._encryptedStructure != null;
}
 public void Validate() {
 if (!IsSetEncryptedStructure()) throw new System.ArgumentException("Missing value for required property 'EncryptedStructure'");

}
}
}
