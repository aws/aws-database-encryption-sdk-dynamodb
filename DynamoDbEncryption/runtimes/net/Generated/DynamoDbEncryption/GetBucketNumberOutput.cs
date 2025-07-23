// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb
{
  public class GetBucketNumberOutput
  {
    private int? _bucketNumber;
    public int BucketNumber
    {
      get { return this._bucketNumber.GetValueOrDefault(); }
      set { this._bucketNumber = value; }
    }
    public bool IsSetBucketNumber()
    {
      return this._bucketNumber.HasValue;
    }
    public void Validate()
    {
      if (!IsSetBucketNumber()) throw new System.ArgumentException("Missing value for required property 'BucketNumber'");

    }
  }
}
