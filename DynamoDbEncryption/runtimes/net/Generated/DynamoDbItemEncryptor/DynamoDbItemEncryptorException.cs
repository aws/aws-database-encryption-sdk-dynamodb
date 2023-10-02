// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor
{
  public class DynamoDbItemEncryptorException : Exception
  {
    public DynamoDbItemEncryptorException(string message) : base(message) { }
    public string getMessage() { return this.Message; }
  }
}
