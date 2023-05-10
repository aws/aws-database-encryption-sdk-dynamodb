// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DbEncryptionSDK.DynamoDb; namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb {
 public class CompoundBeacon {
 private string _name ;
 private string _split ;
 private System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.SensitivePart> _sensitive ;
 private System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.NonSensitivePart> _nonSensitive ;
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
 public System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.SensitivePart> Sensitive {
 get { return this._sensitive; }
 set { this._sensitive = value; }
}
 public bool IsSetSensitive () {
 return this._sensitive != null;
}
 public System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.NonSensitivePart> NonSensitive {
 get { return this._nonSensitive; }
 set { this._nonSensitive = value; }
}
 public bool IsSetNonSensitive () {
 return this._nonSensitive != null;
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
