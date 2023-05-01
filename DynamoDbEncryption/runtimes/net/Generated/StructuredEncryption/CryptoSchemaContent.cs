// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.StructuredEncryption; namespace AWS.Cryptography.StructuredEncryption {
 public class CryptoSchemaContent {
 private AWS.Cryptography.StructuredEncryption.CryptoAction _Action ;
 private System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoSchema> _SchemaMap ;
 private System.Collections.Generic.List<AWS.Cryptography.StructuredEncryption.CryptoSchema> _SchemaList ;
 public AWS.Cryptography.StructuredEncryption.CryptoAction Action {
 get { return this._Action; }
 set { this._Action = value; }
}
 public bool IsSetAction() {
 return this._Action != null;
}
 public System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoSchema> SchemaMap {
 get { return this._SchemaMap; }
 set { this._SchemaMap = value; }
}
 public bool IsSetSchemaMap() {
 return this._SchemaMap != null;
}
 public System.Collections.Generic.List<AWS.Cryptography.StructuredEncryption.CryptoSchema> SchemaList {
 get { return this._SchemaList; }
 set { this._SchemaList = value; }
}
 public bool IsSetSchemaList() {
 return this._SchemaList != null;
}
 public void Validate() {
 var numberOfPropertiesSet = Convert.ToUInt16(IsSetAction()) +
 Convert.ToUInt16(IsSetSchemaMap()) +
 Convert.ToUInt16(IsSetSchemaList()) ;
 if (numberOfPropertiesSet == 0) throw new System.ArgumentException("No union value set");

 if (numberOfPropertiesSet > 1) throw new System.ArgumentException("Multiple union values set");

}
}
}
