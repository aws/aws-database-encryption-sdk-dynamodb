// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DynamoDbEncryption; namespace AWS.Cryptography.DynamoDbEncryption {
 public class BeaconVersion {
 private int? _version ;
 private AWS.Cryptography.KeyStore.KeyStore _keyStore ;
 private AWS.Cryptography.DynamoDbEncryption.BeaconKeySource _keySource ;
 private System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.StandardBeacon> _standardBeacons ;
 private System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.CompoundBeacon> _compoundBeacons ;
 private System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.VirtualField> _virtualFields ;
 public int Version {
 get { return this._version.GetValueOrDefault(); }
 set { this._version = value; }
}
 public bool IsSetVersion() {
 return this._version.HasValue;
}
 public AWS.Cryptography.KeyStore.KeyStore KeyStore {
 get { return this._keyStore; }
 set { this._keyStore = value; }
}
 public bool IsSetKeyStore() {
 return this._keyStore != null;
}
 public AWS.Cryptography.DynamoDbEncryption.BeaconKeySource KeySource {
 get { return this._keySource; }
 set { this._keySource = value; }
}
 public bool IsSetKeySource() {
 return this._keySource != null;
}
 public System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.StandardBeacon> StandardBeacons {
 get { return this._standardBeacons; }
 set { this._standardBeacons = value; }
}
 public bool IsSetStandardBeacons() {
 return this._standardBeacons != null;
}
 public System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.CompoundBeacon> CompoundBeacons {
 get { return this._compoundBeacons; }
 set { this._compoundBeacons = value; }
}
 public bool IsSetCompoundBeacons() {
 return this._compoundBeacons != null;
}
 public System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.VirtualField> VirtualFields {
 get { return this._virtualFields; }
 set { this._virtualFields = value; }
}
 public bool IsSetVirtualFields() {
 return this._virtualFields != null;
}
 public void Validate() {
 if (!IsSetVersion()) throw new System.ArgumentException("Missing value for required property 'Version'");
 if (!IsSetKeyStore()) throw new System.ArgumentException("Missing value for required property 'KeyStore'");
 if (!IsSetKeySource()) throw new System.ArgumentException("Missing value for required property 'KeySource'");
 if (!IsSetStandardBeacons()) throw new System.ArgumentException("Missing value for required property 'StandardBeacons'");

}
}
}
