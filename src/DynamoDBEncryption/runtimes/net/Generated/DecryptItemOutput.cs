// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DynamodbEncryption; namespace AWS.Cryptography.DynamodbEncryption {
 public class DecryptItemOutput {
 private System.Collections.Generic.Dictionary<string, Com.Amazonaws.Dynamodb.AttributeValue> _item ;
 public System.Collections.Generic.Dictionary<string, Com.Amazonaws.Dynamodb.AttributeValue> Item {
 get { return this._item; }
 set { this._item = value; }
}
 internal bool IsSetItem () {
 return this._item != null;
}
 public void Validate() {
 if (!IsSetItem()) throw new System.ArgumentException("Missing value for required property 'Item'");

}
}
}
