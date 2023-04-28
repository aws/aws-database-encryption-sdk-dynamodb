// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DynamoDbEncryption; namespace AWS.Cryptography.DynamoDbEncryption {
 public class VirtualField {
 private string _name ;
 private System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.VirtualPart> _parts ;
 public string Name {
 get { return this._name; }
 set { this._name = value; }
}
 public bool IsSetName () {
 return this._name != null;
}
 public System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.VirtualPart> Parts {
 get { return this._parts; }
 set { this._parts = value; }
}
 public bool IsSetParts () {
 return this._parts != null;
}
 public void Validate() {
 if (!IsSetName()) throw new System.ArgumentException("Missing value for required property 'Name'");
 if (!IsSetParts()) throw new System.ArgumentException("Missing value for required property 'Parts'");

}
}
}
