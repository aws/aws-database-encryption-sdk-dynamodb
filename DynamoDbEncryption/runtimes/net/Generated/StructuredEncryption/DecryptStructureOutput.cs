// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.StructuredEncryption;
namespace AWS.Cryptography.DbEncryptionSDK.StructuredEncryption
{
  public class DecryptStructureOutput
  {
    private System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredDataTerminal> _plaintextStructure;
    private System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction> _cryptoSchema;
    private AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.ParsedHeader _parsedHeader;
    public System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredDataTerminal> PlaintextStructure
    {
      get { return this._plaintextStructure; }
      set { this._plaintextStructure = value; }
    }
    public bool IsSetPlaintextStructure()
    {
      return this._plaintextStructure != null;
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
      if (!IsSetPlaintextStructure()) throw new System.ArgumentException("Missing value for required property 'PlaintextStructure'");
      if (!IsSetCryptoSchema()) throw new System.ArgumentException("Missing value for required property 'CryptoSchema'");
      if (!IsSetParsedHeader()) throw new System.ArgumentException("Missing value for required property 'ParsedHeader'");

    }
  }
}
