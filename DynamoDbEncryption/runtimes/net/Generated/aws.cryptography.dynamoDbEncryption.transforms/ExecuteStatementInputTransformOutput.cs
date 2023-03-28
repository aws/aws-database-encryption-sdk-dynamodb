// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DynamoDbEncryption.Transforms; namespace AWS.Cryptography.DynamoDbEncryption.Transforms {
 public class ExecuteStatementInputTransformOutput {
 private Amazon.DynamoDBv2.Model.ExecuteStatementRequest _transformedInput ;
 public Amazon.DynamoDBv2.Model.ExecuteStatementRequest TransformedInput {
 get { return this._transformedInput; }
 set { this._transformedInput = value; }
}
 public bool IsSetTransformedInput () {
 return this._transformedInput != null;
}
 public void Validate() {
 if (!IsSetTransformedInput()) throw new System.ArgumentException("Missing value for required property 'TransformedInput'");

}
}
}
