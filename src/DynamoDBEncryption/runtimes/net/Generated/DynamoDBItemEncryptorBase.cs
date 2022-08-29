// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DynamoDBEncryption; namespace AWS.Cryptography.DynamoDBEncryption {
 public abstract class DynamoDBItemEncryptorBase : IDynamoDBItemEncryptor {
 public AWS.Cryptography.DynamoDBEncryption.EncryptItemOutput EncryptItem ( AWS.Cryptography.DynamoDBEncryption.EncryptItemInput input )
 {
 input.Validate(); return _EncryptItem ( input ) ;
}
 protected abstract AWS.Cryptography.DynamoDBEncryption.EncryptItemOutput _EncryptItem ( AWS.Cryptography.DynamoDBEncryption.EncryptItemInput input ) ;
 public AWS.Cryptography.DynamoDBEncryption.DecryptItemOutput DecryptItem ( AWS.Cryptography.DynamoDBEncryption.DecryptItemInput input )
 {
 input.Validate(); return _DecryptItem ( input ) ;
}
 protected abstract AWS.Cryptography.DynamoDBEncryption.DecryptItemOutput _DecryptItem ( AWS.Cryptography.DynamoDBEncryption.DecryptItemInput input ) ;
}
}
