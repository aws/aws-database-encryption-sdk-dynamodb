// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DynamoDbEncryption.Resources; namespace AWS.Cryptography.DynamoDbEncryption.Resources {
 public class GetBranchKeyIdFromItemInput {
 private System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> _ddbItem ;
 public System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> DdbItem {
 get { return this._ddbItem; }
 set { this._ddbItem = value; }
}
 public bool IsSetDdbItem () {
 return this._ddbItem != null;
}
 public void Validate() {
 if (!IsSetDdbItem()) throw new System.ArgumentException("Missing value for required property 'DdbItem'");

}
}
}
