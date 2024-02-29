// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json
{
  public class JsonEncryptorConfig
  {
    private string _logicalTableName;
    private System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Action> _attributeActionsOnEncrypt;
    private System.Collections.Generic.List<string> _allowedUnsignedAttributes;
    private string _allowedUnsignedAttributePrefix;
    private AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.DbesdkEncrypt _encrypt;
    private System.Collections.Generic.List<string> _decryptAs;
    public string LogicalTableName
    {
      get { return this._logicalTableName; }
      set { this._logicalTableName = value; }
    }
    public bool IsSetLogicalTableName()
    {
      return this._logicalTableName != null;
    }
    public System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Action> AttributeActionsOnEncrypt
    {
      get { return this._attributeActionsOnEncrypt; }
      set { this._attributeActionsOnEncrypt = value; }
    }
    public bool IsSetAttributeActionsOnEncrypt()
    {
      return this._attributeActionsOnEncrypt != null;
    }
    public System.Collections.Generic.List<string> AllowedUnsignedAttributes
    {
      get { return this._allowedUnsignedAttributes; }
      set { this._allowedUnsignedAttributes = value; }
    }
    public bool IsSetAllowedUnsignedAttributes()
    {
      return this._allowedUnsignedAttributes != null;
    }
    public string AllowedUnsignedAttributePrefix
    {
      get { return this._allowedUnsignedAttributePrefix; }
      set { this._allowedUnsignedAttributePrefix = value; }
    }
    public bool IsSetAllowedUnsignedAttributePrefix()
    {
      return this._allowedUnsignedAttributePrefix != null;
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.DbesdkEncrypt Encrypt
    {
      get { return this._encrypt; }
      set { this._encrypt = value; }
    }
    public bool IsSetEncrypt()
    {
      return this._encrypt != null;
    }
    public System.Collections.Generic.List<string> DecryptAs
    {
      get { return this._decryptAs; }
      set { this._decryptAs = value; }
    }
    public bool IsSetDecryptAs()
    {
      return this._decryptAs != null;
    }
    public void Validate()
    {
      if (!IsSetLogicalTableName()) throw new System.ArgumentException("Missing value for required property 'LogicalTableName'");
      if (!IsSetAttributeActionsOnEncrypt()) throw new System.ArgumentException("Missing value for required property 'AttributeActionsOnEncrypt'");
      if (!IsSetEncrypt()) throw new System.ArgumentException("Missing value for required property 'Encrypt'");

    }
  }
}
