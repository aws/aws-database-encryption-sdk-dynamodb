// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using System.IO;
 using System.Collections.Generic;
 using AWS.Cryptography.DynamoDbEncryption;
 using Dafny.Aws.Cryptography.DynamoDbEncryption.Types; namespace AWS.Cryptography.DynamoDbEncryption {
 internal class LegacyDynamoDbEncryptor : LegacyDynamoDbEncryptorBase {
 internal readonly Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ILegacyDynamoDbEncryptor _impl;
 internal LegacyDynamoDbEncryptor(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ILegacyDynamoDbEncryptor impl) { this._impl = impl; }
 
}
}
