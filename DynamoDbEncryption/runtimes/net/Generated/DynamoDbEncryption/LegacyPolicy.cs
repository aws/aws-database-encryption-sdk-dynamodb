// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb
{
  using Amazon.Runtime;
  public class LegacyPolicy : ConstantClass
  {


    public static readonly LegacyPolicy FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT = new LegacyPolicy("FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT");

    public static readonly LegacyPolicy FORBID_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT = new LegacyPolicy("FORBID_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT");

    public static readonly LegacyPolicy FORBID_LEGACY_ENCRYPT_FORBID_LEGACY_DECRYPT = new LegacyPolicy("FORBID_LEGACY_ENCRYPT_FORBID_LEGACY_DECRYPT");
    public static readonly LegacyPolicy[] Values =  {
 FORBID_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT , FORBID_LEGACY_ENCRYPT_FORBID_LEGACY_DECRYPT , FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT
};
    public LegacyPolicy(string value) : base(value) { }
  }
}
