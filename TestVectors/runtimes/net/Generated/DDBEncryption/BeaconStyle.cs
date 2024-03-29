// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DbEncryptionSDK.DynamoDb; namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb {
 public class BeaconStyle {
 private AWS.Cryptography.DbEncryptionSDK.DynamoDb.PartOnly _partOnly ;
 private AWS.Cryptography.DbEncryptionSDK.DynamoDb.Shared _shared ;
 private AWS.Cryptography.DbEncryptionSDK.DynamoDb.AsSet _asSet ;
 private AWS.Cryptography.DbEncryptionSDK.DynamoDb.SharedSet _sharedSet ;
 public AWS.Cryptography.DbEncryptionSDK.DynamoDb.PartOnly PartOnly {
 get { return this._partOnly; }
 set { this._partOnly = value; }
}
 public bool IsSetPartOnly () {
 return this._partOnly != null;
}
 public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Shared Shared {
 get { return this._shared; }
 set { this._shared = value; }
}
 public bool IsSetShared () {
 return this._shared != null;
}
 public AWS.Cryptography.DbEncryptionSDK.DynamoDb.AsSet AsSet {
 get { return this._asSet; }
 set { this._asSet = value; }
}
 public bool IsSetAsSet () {
 return this._asSet != null;
}
 public AWS.Cryptography.DbEncryptionSDK.DynamoDb.SharedSet SharedSet {
 get { return this._sharedSet; }
 set { this._sharedSet = value; }
}
 public bool IsSetSharedSet () {
 return this._sharedSet != null;
}
 public void Validate() {
 var numberOfPropertiesSet = Convert.ToUInt16(IsSetPartOnly()) +
 Convert.ToUInt16(IsSetShared()) +
 Convert.ToUInt16(IsSetAsSet()) +
 Convert.ToUInt16(IsSetSharedSet()) ;
 if (numberOfPropertiesSet == 0) throw new System.ArgumentException("No union value set");

 if (numberOfPropertiesSet > 1) throw new System.ArgumentException("Multiple union values set");

}
}
}
