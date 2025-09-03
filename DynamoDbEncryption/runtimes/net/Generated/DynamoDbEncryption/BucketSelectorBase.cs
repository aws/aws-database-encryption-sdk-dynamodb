// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb
{
  public abstract class BucketSelectorBase : IBucketSelector
  {
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetBucketNumberOutput GetBucketNumber(AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetBucketNumberInput input)
    {
      input.Validate(); return _GetBucketNumber(input);
    }
    protected abstract AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetBucketNumberOutput _GetBucketNumber(AWS.Cryptography.DbEncryptionSDK.DynamoDb.GetBucketNumberInput input);
  }
}
