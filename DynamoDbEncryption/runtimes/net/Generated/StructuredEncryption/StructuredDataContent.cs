// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.StructuredEncryption; namespace AWS.Cryptography.StructuredEncryption {
 public class StructuredDataContent {
 private AWS.Cryptography.StructuredEncryption.StructuredDataTerminal _terminal ;
 private System.Collections.Generic.List<AWS.Cryptography.StructuredEncryption.StructuredData> _dataList ;
 private System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.StructuredData> _dataMap ;
 public AWS.Cryptography.StructuredEncryption.StructuredDataTerminal Terminal {
 get { return this._terminal; }
 set { this._terminal = value; }
}
 public bool IsSetTerminal() {
 return this._terminal != null;
}
 public System.Collections.Generic.List<AWS.Cryptography.StructuredEncryption.StructuredData> DataList {
 get { return this._dataList; }
 set { this._dataList = value; }
}
 public bool IsSetDataList() {
 return this._dataList != null;
}
 public System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.StructuredData> DataMap {
 get { return this._dataMap; }
 set { this._dataMap = value; }
}
 public bool IsSetDataMap() {
 return this._dataMap != null;
}
 public void Validate() {
 var numberOfPropertiesSet = Convert.ToUInt16(IsSetTerminal()) +
 Convert.ToUInt16(IsSetDataList()) +
 Convert.ToUInt16(IsSetDataMap()) ;
 if (numberOfPropertiesSet == 0) throw new System.ArgumentException("No union value set");

 if (numberOfPropertiesSet > 1) throw new System.ArgumentException("Multiple union values set");

}
}
}
