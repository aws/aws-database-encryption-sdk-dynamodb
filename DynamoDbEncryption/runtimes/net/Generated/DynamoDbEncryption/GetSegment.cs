// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DynamoDbEncryption; namespace AWS.Cryptography.DynamoDbEncryption {
 public class GetSegment {
 private string _split ;
 private int? _index ;
 public string Split {
 get { return this._split; }
 set { this._split = value; }
}
 public bool IsSetSplit() {
 return this._split != null;
}
 public int Index {
 get { return this._index.GetValueOrDefault(); }
 set { this._index = value; }
}
 public bool IsSetIndex() {
 return this._index.HasValue;
}
 public void Validate() {
 if (!IsSetSplit()) throw new System.ArgumentException("Missing value for required property 'Split'");
 if (!IsSetIndex()) throw new System.ArgumentException("Missing value for required property 'Index'");

}
}
}
