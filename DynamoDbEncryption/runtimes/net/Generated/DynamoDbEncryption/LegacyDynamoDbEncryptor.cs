// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using System.IO;
 using System.Collections.Generic;
 using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
 using software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types; namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb {
 internal class LegacyDynamoDbEncryptor : LegacyDynamoDbEncryptorBase {
 internal readonly software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ILegacyDynamoDbEncryptor _impl;
 internal LegacyDynamoDbEncryptor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ILegacyDynamoDbEncryptor impl) { this._impl = impl; }
 
}
}
