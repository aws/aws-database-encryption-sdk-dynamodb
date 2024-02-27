// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json
{
  public class Json
  {
    private string _utf8;
    private string _text;
    public string Utf8
    {
      get { return this._utf8; }
      set { this._utf8 = value; }
    }
    public bool IsSetUtf8()
    {
      return this._utf8 != null;
    }
    public string Text
    {
      get { return this._text; }
      set { this._text = value; }
    }
    public bool IsSetText()
    {
      return this._text != null;
    }
    public void Validate()
    {
      var numberOfPropertiesSet = Convert.ToUInt16(IsSetUtf8()) +
      Convert.ToUInt16(IsSetText());
      if (numberOfPropertiesSet == 0) throw new System.ArgumentException("No union value set");

      if (numberOfPropertiesSet > 1) throw new System.ArgumentException("Multiple union values set");

    }
  }
}
