// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DbEncryptionSDK.DynamoDb; namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb {
 public class CompoundBeacon {
 private string _name ;
 private string _split ;
 private System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedPart> _encrypted ;
 private System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.SignedPart> _signed ;
 private System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.Constructor> _constructors ;
 public string Name {
 get { return this._name; }
 set { this._name = value; }
}
 public bool IsSetName () {
 return this._name != null;
}
 public string Split {
 get { return this._split; }
 set { this._split = value; }
}
 public bool IsSetSplit () {
 return this._split != null;
}
 public System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedPart> Encrypted {
 get { return this._encrypted; }
 set { this._encrypted = value; }
}
 public bool IsSetEncrypted () {
 return this._encrypted != null;
}
 public System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.SignedPart> Signed {
 get { return this._signed; }
 set { this._signed = value; }
}
 public bool IsSetSigned () {
 return this._signed != null;
}
 public System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.Constructor> Constructors {
 get { return this._constructors; }
 set { this._constructors = value; }
}
 public bool IsSetConstructors () {
 return this._constructors != null;
}
 public void Validate() {
 if (!IsSetName()) throw new System.ArgumentException("Missing value for required property 'Name'");
 if (!IsSetSplit()) throw new System.ArgumentException("Missing value for required property 'Split'");

}
}
}
