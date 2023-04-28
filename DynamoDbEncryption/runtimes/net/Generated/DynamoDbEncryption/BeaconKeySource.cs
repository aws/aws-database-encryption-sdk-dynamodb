// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DynamoDbEncryption; namespace AWS.Cryptography.DynamoDbEncryption {
 public class BeaconKeySource {
 private AWS.Cryptography.DynamoDbEncryption.SingleKeyStore _single ;
 private AWS.Cryptography.DynamoDbEncryption.MultiKeyStore _multi ;
 public AWS.Cryptography.DynamoDbEncryption.SingleKeyStore Single {
 get { return this._single; }
 set { this._single = value; }
}
 public bool IsSetSingle () {
 return this._single != null;
}
 public AWS.Cryptography.DynamoDbEncryption.MultiKeyStore Multi {
 get { return this._multi; }
 set { this._multi = value; }
}
 public bool IsSetMulti () {
 return this._multi != null;
}
 public void Validate() {
 var numberOfPropertiesSet = Convert.ToUInt16(IsSetSingle()) +
 Convert.ToUInt16(IsSetMulti()) ;
 if (numberOfPropertiesSet == 0) throw new System.ArgumentException("No union value set");

 if (numberOfPropertiesSet > 1) throw new System.ArgumentException("Multiple union values set");

}
}
}
