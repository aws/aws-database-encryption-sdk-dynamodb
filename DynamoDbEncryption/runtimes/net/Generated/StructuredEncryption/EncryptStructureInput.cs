// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.StructuredEncryption;
namespace AWS.Cryptography.DbEncryptionSDK.StructuredEncryption
{
  public class EncryptStructureInput
  {
    private string _tableName;
    private System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredDataTerminal> _plaintextStructure;
    private System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction> _cryptoSchema;
    private AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager _cmm;
    private AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId _algorithmSuiteId;
    private System.Collections.Generic.Dictionary<string, string> _encryptionContext;
    public string TableName
    {
      get { return this._tableName; }
      set { this._tableName = value; }
    }
    public bool IsSetTableName()
    {
      return this._tableName != null;
    }
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
    public AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager Cmm
    {
      get { return this._cmm; }
      set { this._cmm = value; }
    }
    public bool IsSetCmm()
    {
      return this._cmm != null;
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
      if (!IsSetTableName()) throw new System.ArgumentException("Missing value for required property 'TableName'");
      if (!IsSetPlaintextStructure()) throw new System.ArgumentException("Missing value for required property 'PlaintextStructure'");
      if (!IsSetCryptoSchema()) throw new System.ArgumentException("Missing value for required property 'CryptoSchema'");
      if (!IsSetCmm()) throw new System.ArgumentException("Missing value for required property 'Cmm'");

    }
  }
}
