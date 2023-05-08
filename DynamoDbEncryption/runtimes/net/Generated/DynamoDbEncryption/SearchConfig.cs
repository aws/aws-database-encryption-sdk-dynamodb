// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DbEncryptionSDK.DynamoDb; namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb {
 public class SearchConfig {
 private System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconVersion> _versions ;
 private int? _writeVersion ;
 public System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconVersion> Versions {
 get { return this._versions; }
 set { this._versions = value; }
}
 public bool IsSetVersions () {
 return this._versions != null;
}
 public int WriteVersion {
 get { return this._writeVersion.GetValueOrDefault(); }
 set { this._writeVersion = value; }
}
 public bool IsSetWriteVersion () {
 return this._writeVersion.HasValue;
}
 public void Validate() {
 if (!IsSetVersions()) throw new System.ArgumentException("Missing value for required property 'Versions'");
 if (!IsSetWriteVersion()) throw new System.ArgumentException("Missing value for required property 'WriteVersion'");

}
}
}
