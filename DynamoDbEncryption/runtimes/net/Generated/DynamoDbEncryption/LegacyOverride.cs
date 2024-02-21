// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb
{
  public class LegacyOverride
  {
    private AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyPolicy _policy;
    private AWS.Cryptography.DbEncryptionSDK.DynamoDb.ILegacyDynamoDbEncryptor _encryptor;
    private System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction> _attributeActionsOnEncrypt;
    private AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction _defaultAttributeFlag;
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyPolicy Policy
    {
      get { return this._policy; }
      set { this._policy = value; }
    }
    public bool IsSetPolicy()
    {
      return this._policy != null;
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.ILegacyDynamoDbEncryptor Encryptor
    {
      get { return this._encryptor; }
      set { this._encryptor = value; }
    }
    public bool IsSetEncryptor()
    {
      return this._encryptor != null;
    }
    public System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction> AttributeActionsOnEncrypt
    {
      get { return this._attributeActionsOnEncrypt; }
      set { this._attributeActionsOnEncrypt = value; }
    }
    public bool IsSetAttributeActionsOnEncrypt()
    {
      return this._attributeActionsOnEncrypt != null;
    }
    public AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction DefaultAttributeFlag
    {
      get { return this._defaultAttributeFlag; }
      set { this._defaultAttributeFlag = value; }
    }
    public bool IsSetDefaultAttributeFlag()
    {
      return this._defaultAttributeFlag != null;
    }
    public void Validate()
    {
      if (!IsSetPolicy()) throw new System.ArgumentException("Missing value for required property 'Policy'");
      if (!IsSetEncryptor()) throw new System.ArgumentException("Missing value for required property 'Encryptor'");
      if (!IsSetAttributeActionsOnEncrypt()) throw new System.ArgumentException("Missing value for required property 'AttributeActionsOnEncrypt'");

    }
  }
}
