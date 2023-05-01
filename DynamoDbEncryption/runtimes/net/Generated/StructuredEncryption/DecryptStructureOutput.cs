// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.StructuredEncryption; namespace AWS.Cryptography.StructuredEncryption {
 public class DecryptStructureOutput {
 private AWS.Cryptography.StructuredEncryption.StructuredData _plaintextStructure ;
 private AWS.Cryptography.StructuredEncryption.ParsedHeader _parsedHeader ;
 public AWS.Cryptography.StructuredEncryption.StructuredData PlaintextStructure {
 get { return this._plaintextStructure; }
 set { this._plaintextStructure = value; }
}
 public bool IsSetPlaintextStructure() {
 return this._plaintextStructure != null;
}
 public AWS.Cryptography.StructuredEncryption.ParsedHeader ParsedHeader {
 get { return this._parsedHeader; }
 set { this._parsedHeader = value; }
}
 public bool IsSetParsedHeader() {
 return this._parsedHeader != null;
}
 public void Validate() {
 if (!IsSetPlaintextStructure()) throw new System.ArgumentException("Missing value for required property 'PlaintextStructure'");
 if (!IsSetParsedHeader()) throw new System.ArgumentException("Missing value for required property 'ParsedHeader'");

}
}
}
