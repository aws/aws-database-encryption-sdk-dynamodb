// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb
{
  public class EncryptedDataKeyDescriptionOutput
  {
    private string _keyProviderId;
    private string _keyProviderInfo;
    private string _branchKeyId;
    private string _branchKeyVersion;
    public string KeyProviderId
    {
      get { return this._keyProviderId; }
      set { this._keyProviderId = value; }
    }
    public bool IsSetKeyProviderId()
    {
      return this._keyProviderId != null;
    }
    public string KeyProviderInfo
    {
      get { return this._keyProviderInfo; }
      set { this._keyProviderInfo = value; }
    }
    public bool IsSetKeyProviderInfo()
    {
      return this._keyProviderInfo != null;
    }
    public string BranchKeyId
    {
      get { return this._branchKeyId; }
      set { this._branchKeyId = value; }
    }
    public bool IsSetBranchKeyId()
    {
      return this._branchKeyId != null;
    }
    public string BranchKeyVersion
    {
      get { return this._branchKeyVersion; }
      set { this._branchKeyVersion = value; }
    }
    public bool IsSetBranchKeyVersion()
    {
      return this._branchKeyVersion != null;
    }
    public void Validate()
    {
      if (!IsSetKeyProviderId()) throw new System.ArgumentException("Missing value for required property 'KeyProviderId'");

    }
  }
}
