// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json
{
  public class Actions
  {
    private System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction> _attributeActionsOnEncrypt;
    private System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Actions> _nestedActionsOnEncrypt;
    private System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.JsonEncryptorConfig> _nestedEncryptors;
    private System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.KeyAccess> _eSDKActions;
    private AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.DefaultAction _defaultAction;
    public System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction> AttributeActionsOnEncrypt
    {
      get { return this._attributeActionsOnEncrypt; }
      set { this._attributeActionsOnEncrypt = value; }
    }
    public bool IsSetAttributeActionsOnEncrypt()
    {
      return this._attributeActionsOnEncrypt != null;
    }
    public System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Actions> NestedActionsOnEncrypt
    {
      get { return this._nestedActionsOnEncrypt; }
      set { this._nestedActionsOnEncrypt = value; }
    }
    public bool IsSetNestedActionsOnEncrypt()
    {
      return this._nestedActionsOnEncrypt != null;
    }
    public System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.JsonEncryptorConfig> NestedEncryptors
    {
      get { return this._nestedEncryptors; }
      set { this._nestedEncryptors = value; }
    }
    public bool IsSetNestedEncryptors()
    {
      return this._nestedEncryptors != null;
    }
    public System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.KeyAccess> ESDKActions
    {
      get { return this._eSDKActions; }
      set { this._eSDKActions = value; }
    }
    public bool IsSetESDKActions()
    {
      return this._eSDKActions != null;
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.DefaultAction DefaultAction
    {
      get { return this._defaultAction; }
      set { this._defaultAction = value; }
    }
    public bool IsSetDefaultAction()
    {
      return this._defaultAction != null;
    }
    public void Validate()
    {
      if (!IsSetAttributeActionsOnEncrypt()) throw new System.ArgumentException("Missing value for required property 'AttributeActionsOnEncrypt'");

    }
  }
}
