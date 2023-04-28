// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DynamoDbEncryption; namespace AWS.Cryptography.DynamoDbEncryption {
 public class Insert {
 private string _literal ;
 public string Literal {
 get { return this._literal; }
 set { this._literal = value; }
}
 public bool IsSetLiteral () {
 return this._literal != null;
}
 public void Validate() {
 if (!IsSetLiteral()) throw new System.ArgumentException("Missing value for required property 'Literal'");

}
}
}
