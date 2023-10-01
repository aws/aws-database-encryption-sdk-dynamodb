// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DbEncryptionSDK.DynamoDb; namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb {
 public class ConstructorPart {
 private string _name ;
 private bool? _required ;
 public string Name {
 get { return this._name; }
 set { this._name = value; }
}
 public bool IsSetName () {
 return this._name != null;
}
 public bool Required {
 get { return this._required.GetValueOrDefault(); }
 set { this._required = value; }
}
 public bool IsSetRequired () {
 return this._required.HasValue;
}
 public void Validate() {
 if (!IsSetName()) throw new System.ArgumentException("Missing value for required property 'Name'");
 if (!IsSetRequired()) throw new System.ArgumentException("Missing value for required property 'Required'");

}
}
}
