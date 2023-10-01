// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor; namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor {
 public class EncryptItemOutput {
 private System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> _encryptedItem ;
 private AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.ParsedHeader _parsedHeader ;
 public System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> EncryptedItem {
 get { return this._encryptedItem; }
 set { this._encryptedItem = value; }
}
 public bool IsSetEncryptedItem () {
 return this._encryptedItem != null;
}
 public AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.ParsedHeader ParsedHeader {
 get { return this._parsedHeader; }
 set { this._parsedHeader = value; }
}
 public bool IsSetParsedHeader () {
 return this._parsedHeader != null;
}
 public void Validate() {
 if (!IsSetEncryptedItem()) throw new System.ArgumentException("Missing value for required property 'EncryptedItem'");

}
}
}
