// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DynamoDbEncryption; namespace AWS.Cryptography.DynamoDbEncryption {
 public class BeaconVersion {
 private int? _version ;
 private AWS.Cryptography.MaterialProviders.IKeyring _keyring ;
 private System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.StandardBeacon> _standardBeacons ;
 private System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.CompoundBeacon> _compoundBeacons ;
 public int Version {
 get { return this._version.GetValueOrDefault(); }
 set { this._version = value; }
}
 public bool IsSetVersion () {
 return this._version.HasValue;
}
 public AWS.Cryptography.MaterialProviders.IKeyring Keyring {
 get { return this._keyring; }
 set { this._keyring = value; }
}
 public bool IsSetKeyring () {
 return this._keyring != null;
}
 public System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.StandardBeacon> StandardBeacons {
 get { return this._standardBeacons; }
 set { this._standardBeacons = value; }
}
 public bool IsSetStandardBeacons () {
 return this._standardBeacons != null;
}
 public System.Collections.Generic.List<AWS.Cryptography.DynamoDbEncryption.CompoundBeacon> CompoundBeacons {
 get { return this._compoundBeacons; }
 set { this._compoundBeacons = value; }
}
 public bool IsSetCompoundBeacons () {
 return this._compoundBeacons != null;
}
 public void Validate() {
 if (!IsSetVersion()) throw new System.ArgumentException("Missing value for required property 'Version'");
 if (!IsSetKeyring()) throw new System.ArgumentException("Missing value for required property 'Keyring'");

}
}
}
