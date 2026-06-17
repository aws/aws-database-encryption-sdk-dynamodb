// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb
{
  public abstract class PartitionSelectorBase : IPartitionSelector
  {
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetPartitionNumberOutput GetPartitionNumber(AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetPartitionNumberInput input)
    {
      input.Validate(); return _GetPartitionNumber(input);
    }
    protected abstract AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetPartitionNumberOutput _GetPartitionNumber(AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetPartitionNumberInput input);
  }
}
