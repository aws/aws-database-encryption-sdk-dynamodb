// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DynamoDbEncryption; namespace AWS.Cryptography.DynamoDbEncryption {
 public class SingleKeyStore {
 private string _keyId ;
 private int? _cacheTTL ;
 public string KeyId {
 get { return this._keyId; }
 set { this._keyId = value; }
}
 public bool IsSetKeyId () {
 return this._keyId != null;
}
 public int CacheTTL {
 get { return this._cacheTTL.GetValueOrDefault(); }
 set { this._cacheTTL = value; }
}
 public bool IsSetCacheTTL () {
 return this._cacheTTL.HasValue;
}
 public void Validate() {
 if (!IsSetKeyId()) throw new System.ArgumentException("Missing value for required property 'KeyId'");
 if (!IsSetCacheTTL()) throw new System.ArgumentException("Missing value for required property 'CacheTTL'");

}
}
}
