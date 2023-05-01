// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DynamoDbEncryption.Transforms; namespace AWS.Cryptography.DynamoDbEncryption.Transforms {
 public class GetItemOutputTransformOutput {
 private Amazon.DynamoDBv2.Model.GetItemResponse _transformedOutput ;
 public Amazon.DynamoDBv2.Model.GetItemResponse TransformedOutput {
 get { return this._transformedOutput; }
 set { this._transformedOutput = value; }
}
 public bool IsSetTransformedOutput() {
 return this._transformedOutput != null;
}
 public void Validate() {
 if (!IsSetTransformedOutput()) throw new System.ArgumentException("Missing value for required property 'TransformedOutput'");

}
}
}
