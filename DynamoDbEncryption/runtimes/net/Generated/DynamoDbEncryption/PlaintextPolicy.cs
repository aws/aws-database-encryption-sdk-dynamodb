// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DbEncryptionSDK.DynamoDb; namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb {
 using Amazon.Runtime; public class PlaintextPolicy : ConstantClass {

 
 public static readonly PlaintextPolicy REQUIRE_WRITE_ALLOW_READ = new PlaintextPolicy ("REQUIRE_WRITE_ALLOW_READ");
 
 public static readonly PlaintextPolicy FORBID_WRITE_ALLOW_READ = new PlaintextPolicy ("FORBID_WRITE_ALLOW_READ");
 
 public static readonly PlaintextPolicy FORBID_WRITE_FORBID_READ = new PlaintextPolicy ("FORBID_WRITE_FORBID_READ");
 public static readonly  PlaintextPolicy [] Values =  {
 FORBID_WRITE_ALLOW_READ , FORBID_WRITE_FORBID_READ , REQUIRE_WRITE_ALLOW_READ
} ;
 public PlaintextPolicy (string value) : base(value) {}
}
}
