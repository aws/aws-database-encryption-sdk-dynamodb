// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DynamoDBEncryption; namespace AWS.Cryptography.DynamoDBEncryption {
 public interface IDynamoDBItemEncryptor {
 AWS.Cryptography.DynamoDBEncryption.EncryptItemOutput EncryptItem ( AWS.Cryptography.DynamoDBEncryption.EncryptItemInput input ) ;
 AWS.Cryptography.DynamoDBEncryption.DecryptItemOutput DecryptItem ( AWS.Cryptography.DynamoDBEncryption.DecryptItemInput input ) ;
}
}
