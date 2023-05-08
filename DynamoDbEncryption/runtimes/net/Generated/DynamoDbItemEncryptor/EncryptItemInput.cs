// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor; namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor {
 public class EncryptItemInput {
 private System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> _plaintextItem ;
 public System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> PlaintextItem {
 get { return this._plaintextItem; }
 set { this._plaintextItem = value; }
}
 public bool IsSetPlaintextItem () {
 return this._plaintextItem != null;
}
 public void Validate() {
 if (!IsSetPlaintextItem()) throw new System.ArgumentException("Missing value for required property 'PlaintextItem'");

}
}
}
