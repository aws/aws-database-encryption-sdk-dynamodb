// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.StructuredEncryption; namespace AWS.Cryptography.StructuredEncryption {
 public class StructuredDataContent {
 private AWS.Cryptography.StructuredEncryption.StructuredDataTerminal _Terminal ;
 private System.Collections.Generic.List<AWS.Cryptography.StructuredEncryption.StructuredData> _DataList ;
 private System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.StructuredData> _DataMap ;
 public AWS.Cryptography.StructuredEncryption.StructuredDataTerminal Terminal {
 get { return this._Terminal; }
 set { this._Terminal = value; }
}
 public bool IsSetTerminal() {
 return this._Terminal != null;
}
 public System.Collections.Generic.List<AWS.Cryptography.StructuredEncryption.StructuredData> DataList {
 get { return this._DataList; }
 set { this._DataList = value; }
}
 public bool IsSetDataList() {
 return this._DataList != null;
}
 public System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.StructuredData> DataMap {
 get { return this._DataMap; }
 set { this._DataMap = value; }
}
 public bool IsSetDataMap() {
 return this._DataMap != null;
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
