// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DynamoDbEncryption.ItemEncryptor; namespace AWS.Cryptography.DynamoDbEncryption.ItemEncryptor {
 public class DecryptItemOutput {
 private System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> _plaintextItem ;
 private AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.ParsedHeader _parsedHeader ;
 public System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> PlaintextItem {
 get { return this._plaintextItem; }
 set { this._plaintextItem = value; }
}
 public bool IsSetPlaintextItem () {
 return this._plaintextItem != null;
}
 public AWS.Cryptography.DynamoDbEncryption.ItemEncryptor.ParsedHeader ParsedHeader {
 get { return this._parsedHeader; }
 set { this._parsedHeader = value; }
}
 public bool IsSetParsedHeader () {
 return this._parsedHeader != null;
}
 public void Validate() {
 if (!IsSetPlaintextItem()) throw new System.ArgumentException("Missing value for required property 'PlaintextItem'");

}
}
}
