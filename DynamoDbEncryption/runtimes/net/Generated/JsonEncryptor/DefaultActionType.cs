// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json
{
  public class DefaultActionType
  {
    private AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction _action;
    public AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction Action
    {
      get { return this._action; }
      set { this._action = value; }
    }
    public bool IsSetAction()
    {
      return this._action != null;
    }
    public void Validate()
    {

    }
  }
}
