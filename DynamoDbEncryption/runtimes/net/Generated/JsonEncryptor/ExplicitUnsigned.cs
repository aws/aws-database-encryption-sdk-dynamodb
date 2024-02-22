// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json
{
  public class ExplicitUnsigned
  {
    private System.Collections.Generic.List<string> _allowedUnsignedAttributes;
    private string _allowedUnsignedAttributePrefix;
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
    public void Validate()
    {

    }
  }
}
