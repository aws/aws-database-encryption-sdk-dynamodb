// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.StructuredEncryption;
namespace AWS.Cryptography.DbEncryptionSDK.StructuredEncryption
{
  public class EncryptPathStructureOutput
  {
    private System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoItem> _encryptedStructure;
    private AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.ParsedHeader _parsedHeader;
    public System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoItem> EncryptedStructure
    {
      get { return this._encryptedStructure; }
      set { this._encryptedStructure = value; }
    }
    public bool IsSetEncryptedStructure()
    {
      return this._encryptedStructure != null;
    }
    public AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.ParsedHeader ParsedHeader
    {
      get { return this._parsedHeader; }
      set { this._parsedHeader = value; }
    }
    public bool IsSetParsedHeader()
    {
      return this._parsedHeader != null;
    }
    public void Validate()
    {
      if (!IsSetEncryptedStructure()) throw new System.ArgumentException("Missing value for required property 'EncryptedStructure'");
      if (!IsSetParsedHeader()) throw new System.ArgumentException("Missing value for required property 'ParsedHeader'");

    }
  }
}
