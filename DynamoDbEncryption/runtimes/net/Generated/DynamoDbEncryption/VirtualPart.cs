// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DynamoDbEncryption; namespace AWS.Cryptography.DynamoDbEncryption {
 public class VirtualPart {
 private string _loc ;
 private System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.VirtualTransform> _trans ;
 public string Loc {
 get { return this._loc; }
 set { this._loc = value; }
}
 public bool IsSetLoc() {
 return this._loc != null;
}
 public System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.VirtualTransform> Trans {
 get { return this._trans; }
 set { this._trans = value; }
}
 public bool IsSetTrans() {
 return this._trans != null;
}
 public void Validate() {
 if (!IsSetLoc()) throw new System.ArgumentException("Missing value for required property 'Loc'");

}
}
}
