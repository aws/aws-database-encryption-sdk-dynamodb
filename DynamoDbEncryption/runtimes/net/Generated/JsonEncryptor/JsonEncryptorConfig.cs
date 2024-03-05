// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json
{
  public class JsonEncryptorConfig
  {
    private string _domain;
    private System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Action> _memberActionsOnEncrypt;
    private System.Collections.Generic.List<string> _allowedUnsignedMembers;
    private string _allowedUnsignedMemberPrefix;
    private AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.JsonEncrypt _encrypt;
    public string Domain
    {
      get { return this._domain; }
      set { this._domain = value; }
    }
    public bool IsSetDomain()
    {
      return this._domain != null;
    }
    public System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Action> MemberActionsOnEncrypt
    {
      get { return this._memberActionsOnEncrypt; }
      set { this._memberActionsOnEncrypt = value; }
    }
    public bool IsSetMemberActionsOnEncrypt()
    {
      return this._memberActionsOnEncrypt != null;
    }
    public System.Collections.Generic.List<string> AllowedUnsignedMembers
    {
      get { return this._allowedUnsignedMembers; }
      set { this._allowedUnsignedMembers = value; }
    }
    public bool IsSetAllowedUnsignedMembers()
    {
      return this._allowedUnsignedMembers != null;
    }
    public string AllowedUnsignedMemberPrefix
    {
      get { return this._allowedUnsignedMemberPrefix; }
      set { this._allowedUnsignedMemberPrefix = value; }
    }
    public bool IsSetAllowedUnsignedMemberPrefix()
    {
      return this._allowedUnsignedMemberPrefix != null;
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.JsonEncrypt Encrypt
    {
      get { return this._encrypt; }
      set { this._encrypt = value; }
    }
    public bool IsSetEncrypt()
    {
      return this._encrypt != null;
    }
    public void Validate()
    {
      if (!IsSetDomain()) throw new System.ArgumentException("Missing value for required property 'Domain'");
      if (!IsSetMemberActionsOnEncrypt()) throw new System.ArgumentException("Missing value for required property 'MemberActionsOnEncrypt'");
      if (!IsSetEncrypt()) throw new System.ArgumentException("Missing value for required property 'Encrypt'");

    }
  }
}
