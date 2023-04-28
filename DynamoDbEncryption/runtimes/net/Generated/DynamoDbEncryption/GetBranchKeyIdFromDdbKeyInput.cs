// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DynamoDbEncryption; namespace AWS.Cryptography.DynamoDbEncryption {
 public class GetBranchKeyIdFromDdbKeyInput {
 private System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> _ddbKey ;
 public System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> DdbKey {
 get { return this._ddbKey; }
 set { this._ddbKey = value; }
}
 public bool IsSetDdbKey () {
 return this._ddbKey != null;
}
 public void Validate() {
 if (!IsSetDdbKey()) throw new System.ArgumentException("Missing value for required property 'DdbKey'");

}
}
}
