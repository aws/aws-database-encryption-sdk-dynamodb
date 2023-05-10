// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DbEncryptionSDK.DynamoDb; namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb {
 using Amazon.Runtime; public class LegacyPolicy : ConstantClass {

 
 public static readonly LegacyPolicy REQUIRE_ENCRYPT_ALLOW_DECRYPT = new LegacyPolicy ("REQUIRE_ENCRYPT_ALLOW_DECRYPT");
 
 public static readonly LegacyPolicy FORBID_ENCRYPT_ALLOW_DECRYPT = new LegacyPolicy ("FORBID_ENCRYPT_ALLOW_DECRYPT");
 
 public static readonly LegacyPolicy FORBID_ENCRYPT_FORBID_DECRYPT = new LegacyPolicy ("FORBID_ENCRYPT_FORBID_DECRYPT");
 public static readonly  LegacyPolicy [] Values =  {
 FORBID_ENCRYPT_ALLOW_DECRYPT , FORBID_ENCRYPT_FORBID_DECRYPT , REQUIRE_ENCRYPT_ALLOW_DECRYPT
} ;
 public LegacyPolicy (string value) : base(value) {}
}
}
