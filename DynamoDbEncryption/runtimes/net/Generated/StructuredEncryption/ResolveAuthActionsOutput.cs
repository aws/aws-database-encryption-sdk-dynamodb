// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.StructuredEncryption;
namespace AWS.Cryptography.DbEncryptionSDK.StructuredEncryption
{
  public class ResolveAuthActionsOutput
  {
    private System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoItem> _cryptoActions;
    public System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoItem> CryptoActions
    {
      get { return this._cryptoActions; }
      set { this._cryptoActions = value; }
    }
    public bool IsSetCryptoActions()
    {
      return this._cryptoActions != null;
    }
    public void Validate()
    {
      if (!IsSetCryptoActions()) throw new System.ArgumentException("Missing value for required property 'CryptoActions'");

    }
  }
}
