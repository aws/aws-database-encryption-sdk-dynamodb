// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using System.IO;
 using System.Collections.Generic;
 using AWS.Cryptography.DynamoDBEncryption;
 using Dafny.Aws.Cryptography.DynamoDBEncryption.Types; namespace AWS.Cryptography.DynamoDBEncryption {
 internal class DynamoDBEncryptionMiddleware : DynamoDBEncryptionMiddlewareBase {
 internal readonly Dafny.Aws.Cryptography.DynamoDBEncryption.Types.IDynamoDBEncryptionMiddleware _impl;
 internal DynamoDBEncryptionMiddleware(Dafny.Aws.Cryptography.DynamoDBEncryption.Types.IDynamoDBEncryptionMiddleware impl) { this._impl = impl; }
 
}
}
