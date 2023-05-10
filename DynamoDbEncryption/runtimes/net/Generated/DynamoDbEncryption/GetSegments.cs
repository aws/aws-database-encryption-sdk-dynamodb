// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DbEncryptionSDK.DynamoDb; namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb {
 public class GetSegments {
 private string _split ;
 private int? _low ;
 private int? _high ;
 public string Split {
 get { return this._split; }
 set { this._split = value; }
}
 public bool IsSetSplit () {
 return this._split != null;
}
 public int Low {
 get { return this._low.GetValueOrDefault(); }
 set { this._low = value; }
}
 public bool IsSetLow () {
 return this._low.HasValue;
}
 public int High {
 get { return this._high.GetValueOrDefault(); }
 set { this._high = value; }
}
 public bool IsSetHigh () {
 return this._high.HasValue;
}
 public void Validate() {
 if (!IsSetSplit()) throw new System.ArgumentException("Missing value for required property 'Split'");
 if (!IsSetLow()) throw new System.ArgumentException("Missing value for required property 'Low'");
 if (!IsSetHigh()) throw new System.ArgumentException("Missing value for required property 'High'");

}
}
}
