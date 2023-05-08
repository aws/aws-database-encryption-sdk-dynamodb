// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DbEncryptionSDK.DynamoDb; namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb {
 public class Constructor {
 private System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.ConstructorPart> _parts ;
 public System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.ConstructorPart> Parts {
 get { return this._parts; }
 set { this._parts = value; }
}
 public bool IsSetParts () {
 return this._parts != null;
}
 public void Validate() {
 if (!IsSetParts()) throw new System.ArgumentException("Missing value for required property 'Parts'");

}
}
}
