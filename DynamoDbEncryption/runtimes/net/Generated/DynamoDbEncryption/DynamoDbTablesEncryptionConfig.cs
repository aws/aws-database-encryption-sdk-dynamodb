// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DynamoDbEncryption; namespace AWS.Cryptography.DynamoDbEncryption {
 public class DynamoDbTablesEncryptionConfig {
 private System.Collections.Generic.Dictionary<string, AWS.Cryptography.DynamoDbEncryption.DynamoDbTableEncryptionConfig> _tableEncryptionConfigs ;
 public System.Collections.Generic.Dictionary<string, AWS.Cryptography.DynamoDbEncryption.DynamoDbTableEncryptionConfig> TableEncryptionConfigs {
 get { return this._tableEncryptionConfigs; }
 set { this._tableEncryptionConfigs = value; }
}
 public bool IsSetTableEncryptionConfigs() {
 return this._tableEncryptionConfigs != null;
}
 public void Validate() {
 if (!IsSetTableEncryptionConfigs()) throw new System.ArgumentException("Missing value for required property 'TableEncryptionConfigs'");

}
}
}
