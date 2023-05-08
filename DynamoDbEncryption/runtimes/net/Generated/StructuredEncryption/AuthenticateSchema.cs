// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DbEncryptionSDK.StructuredEncryption; namespace AWS.Cryptography.DbEncryptionSDK.StructuredEncryption {
 public class AuthenticateSchema {
 private AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthenticateSchemaContent _content ;
 private System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthenticateAction> _attributes ;
 public AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthenticateSchemaContent Content {
 get { return this._content; }
 set { this._content = value; }
}
 public bool IsSetContent () {
 return this._content != null;
}
 public System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthenticateAction> Attributes {
 get { return this._attributes; }
 set { this._attributes = value; }
}
 public bool IsSetAttributes () {
 return this._attributes != null;
}
 public void Validate() {
 if (!IsSetContent()) throw new System.ArgumentException("Missing value for required property 'Content'");

}
}
}
