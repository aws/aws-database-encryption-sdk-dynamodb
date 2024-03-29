// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DbEncryptionSDK.DynamoDb; namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb {
 using Amazon.Runtime; public class PlaintextOverride : ConstantClass {

 
 public static readonly PlaintextOverride FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ = new PlaintextOverride ("FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ");
 
 public static readonly PlaintextOverride FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ = new PlaintextOverride ("FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ");
 
 public static readonly PlaintextOverride FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ = new PlaintextOverride ("FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ");
 public static readonly  PlaintextOverride [] Values =  {
 FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ , FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ , FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ
} ;
 public PlaintextOverride (string value) : base(value) {}
}
}
