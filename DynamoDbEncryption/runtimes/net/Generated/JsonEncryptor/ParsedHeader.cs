// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json
{
  public class ParsedHeader
  {
    private System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Action> _memberActionsOnEncrypt;
    private AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId _algorithmSuiteId;
    private System.Collections.Generic.List<AWS.Cryptography.MaterialProviders.EncryptedDataKey> _encryptedDataKeys;
    private System.Collections.Generic.Dictionary<string, string> _storedEncryptionContext;
    private System.Collections.Generic.Dictionary<string, string> _encryptionContext;
    public System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Action> MemberActionsOnEncrypt
    {
      get { return this._memberActionsOnEncrypt; }
      set { this._memberActionsOnEncrypt = value; }
    }
    public bool IsSetMemberActionsOnEncrypt()
    {
      return this._memberActionsOnEncrypt != null;
    }
    public AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId AlgorithmSuiteId
    {
      get { return this._algorithmSuiteId; }
      set { this._algorithmSuiteId = value; }
    }
    public bool IsSetAlgorithmSuiteId()
    {
      return this._algorithmSuiteId != null;
    }
    public System.Collections.Generic.List<AWS.Cryptography.MaterialProviders.EncryptedDataKey> EncryptedDataKeys
    {
      get { return this._encryptedDataKeys; }
      set { this._encryptedDataKeys = value; }
    }
    public bool IsSetEncryptedDataKeys()
    {
      return this._encryptedDataKeys != null;
    }
    public System.Collections.Generic.Dictionary<string, string> StoredEncryptionContext
    {
      get { return this._storedEncryptionContext; }
      set { this._storedEncryptionContext = value; }
    }
    public bool IsSetStoredEncryptionContext()
    {
      return this._storedEncryptionContext != null;
    }
    public System.Collections.Generic.Dictionary<string, string> EncryptionContext
    {
      get { return this._encryptionContext; }
      set { this._encryptionContext = value; }
    }
    public bool IsSetEncryptionContext()
    {
      return this._encryptionContext != null;
    }
    public void Validate()
    {
      if (!IsSetMemberActionsOnEncrypt()) throw new System.ArgumentException("Missing value for required property 'MemberActionsOnEncrypt'");
      if (!IsSetAlgorithmSuiteId()) throw new System.ArgumentException("Missing value for required property 'AlgorithmSuiteId'");
      if (!IsSetEncryptedDataKeys()) throw new System.ArgumentException("Missing value for required property 'EncryptedDataKeys'");
      if (!IsSetStoredEncryptionContext()) throw new System.ArgumentException("Missing value for required property 'StoredEncryptionContext'");
      if (!IsSetEncryptionContext()) throw new System.ArgumentException("Missing value for required property 'EncryptionContext'");

    }
  }
}