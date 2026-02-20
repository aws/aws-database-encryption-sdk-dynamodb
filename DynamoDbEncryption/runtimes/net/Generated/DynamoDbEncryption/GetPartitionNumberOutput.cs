// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb
{
  public class GetPartitionNumberOutput
  {
    private int? _partitionNumber;
    public int PartitionNumber
    {
      get { return this._partitionNumber.GetValueOrDefault(); }
      set { this._partitionNumber = value; }
    }
    public bool IsSetPartitionNumber()
    {
      return this._partitionNumber.HasValue;
    }
    public void Validate()
    {
      if (!IsSetPartitionNumber()) throw new System.ArgumentException("Missing value for required property 'PartitionNumber'");

    }
  }
}
