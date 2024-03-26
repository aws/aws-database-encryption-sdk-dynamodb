// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.StructuredEncryption;
namespace AWS.Cryptography.DbEncryptionSDK.StructuredEncryption
{
  using Amazon.Runtime;
  public class CryptoAction : ConstantClass
  {


    public static readonly CryptoAction ENCRYPT_AND_SIGN = new CryptoAction("ENCRYPT_AND_SIGN");

    public static readonly CryptoAction SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT = new CryptoAction("SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT");

    public static readonly CryptoAction SIGN_ONLY = new CryptoAction("SIGN_ONLY");

    public static readonly CryptoAction DO_NOTHING = new CryptoAction("DO_NOTHING");
    public static readonly CryptoAction[] Values =  {
 DO_NOTHING , ENCRYPT_AND_SIGN , SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT , SIGN_ONLY
};
    public CryptoAction(string value) : base(value) { }
  }
}
