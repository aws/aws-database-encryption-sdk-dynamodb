// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using System.IO;
 using System.Collections.Generic;
 using AWS.Cryptography.DynamoDbEncryption;
 using Dafny.Aws.Cryptography.DynamoDbEncryption.Types; namespace AWS.Cryptography.DynamoDbEncryption {
 public class DynamoDbEncryption {
 private readonly Dafny.Aws.Cryptography.DynamoDbEncryption.Types.IDynamoDbEncryptionClient _impl;
 public DynamoDbEncryption(AWS.Cryptography.DynamoDbEncryption.DynamoDbEncryptionConfig input)
 {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IDynamoDbEncryptionConfig internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S24_DynamoDbEncryptionConfig(input);
 var result = Dafny.Aws.Cryptography.DynamoDbEncryption.__default.DynamoDbEncryption(internalInput);
 if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
 this._impl = result.dtor_value;
}
 
}
}
