// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms; namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms {
 public class GetItemInputTransformInput {
 private Amazon.DynamoDBv2.Model.GetItemRequest _sdkInput ;
 public Amazon.DynamoDBv2.Model.GetItemRequest SdkInput {
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
