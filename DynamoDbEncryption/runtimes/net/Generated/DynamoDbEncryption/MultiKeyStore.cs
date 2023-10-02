// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb
{
  public class MultiKeyStore
  {
    private string _keyFieldName;
    private int? _cacheTTL;
    private AWS.Cryptography.MaterialProviders.CacheType _cache;
    public string KeyFieldName
    {
      get { return this._keyFieldName; }
      set { this._keyFieldName = value; }
    }
    public bool IsSetKeyFieldName()
    {
      return this._keyFieldName != null;
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
    public void Validate()
    {
      if (!IsSetKeyFieldName()) throw new System.ArgumentException("Missing value for required property 'KeyFieldName'");
      if (!IsSetCacheTTL()) throw new System.ArgumentException("Missing value for required property 'CacheTTL'");

    }
  }
}
