// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DynamoDbEncryption.Internal.Transforms; namespace AWS.Cryptography.DynamoDbEncryption.Internal.Transforms {
 public class UpdateItemInputTransformInput {
 private Amazon.DynamoDBv2.Model.UpdateItemRequest _sdkInput ;
 public Amazon.DynamoDBv2.Model.UpdateItemRequest SdkInput {
 get { return this._sdkInput; }
 set { this._sdkInput = value; }
}
 public bool IsSetSdkInput () {
 return this._sdkInput != null;
}
 public void Validate() {
 if (!IsSetSdkInput()) throw new System.ArgumentException("Missing value for required property 'SdkInput'");

}
}
}
