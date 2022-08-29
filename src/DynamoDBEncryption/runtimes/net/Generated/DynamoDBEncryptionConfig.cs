// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DynamodbEncryption; namespace AWS.Cryptography.DynamodbEncryption {
 public class DynamoDBEncryptionConfig {
 private System.Collections.Generic.Dictionary<string, AWS.Cryptography.DynamodbEncryption.DynamoDBTableEncryptionConfig> _tableConfigs ;
 public System.Collections.Generic.Dictionary<string, AWS.Cryptography.DynamodbEncryption.DynamoDBTableEncryptionConfig> TableConfigs {
 get { return this._tableConfigs; }
 set { this._tableConfigs = value; }
}
 internal bool IsSetTableConfigs () {
 return this._tableConfigs != null;
}
 public void Validate() {
 if (!IsSetTableConfigs()) throw new System.ArgumentException("Missing value for required property 'TableConfigs'");

}
}
}
