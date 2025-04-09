// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb
{
  public class SingleKeyStore
  {
    private string _keyId;
    private int? _cacheTTL;
    private AWS.Cryptography.MaterialProviders.CacheType _cache;
    private string _partitionId;
    public string KeyId
    {
      get { return this._keyId; }
      set { this._keyId = value; }
    }
    public bool IsSetKeyId()
    {
      return this._keyId != null;
    }
    public int CacheTTL
    {
      get { return this._cacheTTL.GetValueOrDefault(); }
      set { this._cacheTTL = value; }
    }
    public bool IsSetCacheTTL()
    {
      return this._cacheTTL.HasValue;
    }
    public AWS.Cryptography.MaterialProviders.CacheType Cache
    {
      get { return this._cache; }
      set { this._cache = value; }
    }
    public bool IsSetCache()
    {
      return this._cache != null;
    }
    public string PartitionId
    {
      get { return this._partitionId; }
      set { this._partitionId = value; }
    }
    public bool IsSetPartitionId()
    {
      return this._partitionId != null;
    }
    public void Validate()
    {
      if (!IsSetKeyId()) throw new System.ArgumentException("Missing value for required property 'KeyId'");
      if (!IsSetCacheTTL()) throw new System.ArgumentException("Missing value for required property 'CacheTTL'");

    }
  }
}
