// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.StructuredEncryption;
namespace AWS.Cryptography.DbEncryptionSDK.StructuredEncryption
{
  public class EncryptStructureOutput
  {
    private System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredDataTerminal> _encryptedStructure;
    private System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction> _cryptoSchema;
    private AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.ParsedHeader _parsedHeader;
    public System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredDataTerminal> EncryptedStructure
    {
      get { return this._encryptedStructure; }
      set { this._encryptedStructure = value; }
    }
    public bool IsSetEncryptedStructure()
    {
      return this._encryptedStructure != null;
    }
    public System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction> CryptoSchema
    {
      get { return this._cryptoSchema; }
      set { this._cryptoSchema = value; }
    }
    public bool IsSetCryptoSchema()
    {
      return this._cryptoSchema != null;
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
      if (!IsSetCryptoSchema()) throw new System.ArgumentException("Missing value for required property 'CryptoSchema'");
      if (!IsSetParsedHeader()) throw new System.ArgumentException("Missing value for required property 'ParsedHeader'");

    }
  }
}
