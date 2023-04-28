// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DynamoDbEncryption; namespace AWS.Cryptography.DynamoDbEncryption {
 public class VirtualTransform {
 private AWS.Cryptography.DynamoDbEncryption.Upper _upper ;
 private AWS.Cryptography.DynamoDbEncryption.Lower _lower ;
 private AWS.Cryptography.DynamoDbEncryption.Insert _insert ;
 private AWS.Cryptography.DynamoDbEncryption.GetPrefix _prefix ;
 private AWS.Cryptography.DynamoDbEncryption.GetSuffix _suffix ;
 private AWS.Cryptography.DynamoDbEncryption.GetSubstring _substring ;
 private AWS.Cryptography.DynamoDbEncryption.GetSegment _segment ;
 private AWS.Cryptography.DynamoDbEncryption.GetSegments _segments ;
 public AWS.Cryptography.DynamoDbEncryption.Upper Upper {
 get { return this._upper; }
 set { this._upper = value; }
}
 public bool IsSetUpper () {
 return this._upper != null;
}
 public AWS.Cryptography.DynamoDbEncryption.Lower Lower {
 get { return this._lower; }
 set { this._lower = value; }
}
 public bool IsSetLower () {
 return this._lower != null;
}
 public AWS.Cryptography.DynamoDbEncryption.Insert Insert {
 get { return this._insert; }
 set { this._insert = value; }
}
 public bool IsSetInsert () {
 return this._insert != null;
}
 public AWS.Cryptography.DynamoDbEncryption.GetPrefix Prefix {
 get { return this._prefix; }
 set { this._prefix = value; }
}
 public bool IsSetPrefix () {
 return this._prefix != null;
}
 public AWS.Cryptography.DynamoDbEncryption.GetSuffix Suffix {
 get { return this._suffix; }
 set { this._suffix = value; }
}
 public bool IsSetSuffix () {
 return this._suffix != null;
}
 public AWS.Cryptography.DynamoDbEncryption.GetSubstring Substring {
 get { return this._substring; }
 set { this._substring = value; }
}
 public bool IsSetSubstring () {
 return this._substring != null;
}
 public AWS.Cryptography.DynamoDbEncryption.GetSegment Segment {
 get { return this._segment; }
 set { this._segment = value; }
}
 public bool IsSetSegment () {
 return this._segment != null;
}
 public AWS.Cryptography.DynamoDbEncryption.GetSegments Segments {
 get { return this._segments; }
 set { this._segments = value; }
}
 public bool IsSetSegments () {
 return this._segments != null;
}
 public void Validate() {
 var numberOfPropertiesSet = Convert.ToUInt16(IsSetUpper()) +
 Convert.ToUInt16(IsSetLower()) +
 Convert.ToUInt16(IsSetInsert()) +
 Convert.ToUInt16(IsSetPrefix()) +
 Convert.ToUInt16(IsSetSuffix()) +
 Convert.ToUInt16(IsSetSubstring()) +
 Convert.ToUInt16(IsSetSegment()) +
 Convert.ToUInt16(IsSetSegments()) ;
 if (numberOfPropertiesSet == 0) throw new System.ArgumentException("No union value set");

 if (numberOfPropertiesSet > 1) throw new System.ArgumentException("Multiple union values set");

}
}
}
