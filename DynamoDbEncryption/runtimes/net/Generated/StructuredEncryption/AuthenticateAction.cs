// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.StructuredEncryption;
namespace AWS.Cryptography.DbEncryptionSDK.StructuredEncryption
{
  using Amazon.Runtime;
  public class AuthenticateAction : ConstantClass
  {


    public static readonly AuthenticateAction SIGN = new AuthenticateAction("SIGN");

    public static readonly AuthenticateAction DO_NOT_SIGN = new AuthenticateAction("DO_NOT_SIGN");
    public static readonly AuthenticateAction[] Values =  {
 DO_NOT_SIGN , SIGN
};
    public AuthenticateAction(string value) : base(value) { }
  }
}
