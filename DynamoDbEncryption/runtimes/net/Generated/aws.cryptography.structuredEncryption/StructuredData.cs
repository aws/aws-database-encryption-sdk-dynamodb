// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.StructuredEncryption; namespace AWS.Cryptography.StructuredEncryption {
 public class StructuredData {
 private AWS.Cryptography.StructuredEncryption.StructuredDataContent _content ;
 private System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.StructuredDataTerminal> _attributes ;
 public AWS.Cryptography.StructuredEncryption.StructuredDataContent Content {
 get { return this._content; }
 set { this._content = value; }
}
 public bool IsSetContent () {
 return this._content != null;
}
 public System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.StructuredDataTerminal> Attributes {
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
