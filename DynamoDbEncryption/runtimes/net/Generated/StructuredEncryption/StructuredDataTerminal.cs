// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DbEncryptionSDK.StructuredEncryption; namespace AWS.Cryptography.DbEncryptionSDK.StructuredEncryption {
 public class StructuredDataTerminal {
 private System.IO.MemoryStream _value ;
 private System.IO.MemoryStream _typeId ;
 public System.IO.MemoryStream Value {
 get { return this._value; }
 set { this._value = value; }
}
 public bool IsSetValue () {
 return this._value != null;
}
 public System.IO.MemoryStream TypeId {
 get { return this._typeId; }
 set { this._typeId = value; }
}
 public bool IsSetTypeId () {
 return this._typeId != null;
}
 public void Validate() {
 if (!IsSetValue()) throw new System.ArgumentException("Missing value for required property 'Value'");
 if (!IsSetTypeId()) throw new System.ArgumentException("Missing value for required property 'TypeId'");

}
}
}
