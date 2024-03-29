// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DbEncryptionSDK.DynamoDb; namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb {
 public class GetEncryptedDataKeyDescriptionUnion {
 private System.IO.MemoryStream _header ;
 private System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> _plaintextItem ;
 public System.IO.MemoryStream Header {
 get { return this._header; }
 set { this._header = value; }
}
 public bool IsSetHeader () {
 return this._header != null;
}
 public System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> PlaintextItem {
 get { return this._plaintextItem; }
 set { this._plaintextItem = value; }
}
 public bool IsSetPlaintextItem () {
 return this._plaintextItem != null;
}
 public void Validate() {
 var numberOfPropertiesSet = Convert.ToUInt16(IsSetHeader()) +
 Convert.ToUInt16(IsSetPlaintextItem()) ;
 if (numberOfPropertiesSet == 0) throw new System.ArgumentException("No union value set");

 if (numberOfPropertiesSet > 1) throw new System.ArgumentException("Multiple union values set");

}
}
}
