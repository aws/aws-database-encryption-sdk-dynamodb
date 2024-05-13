// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.StructuredEncryption;
namespace AWS.Cryptography.DbEncryptionSDK.StructuredEncryption
{
  public class PathSegment
  {
    private AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructureSegment _member;
    public AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructureSegment Member
    {
      get { return this._member; }
      set { this._member = value; }
    }
    public bool IsSetMember()
    {
      return this._member != null;
    }
    public void Validate()
    {
      var numberOfPropertiesSet = Convert.ToUInt16(IsSetMember());
      if (numberOfPropertiesSet == 0) throw new System.ArgumentException("No union value set");

      if (numberOfPropertiesSet > 1) throw new System.ArgumentException("Multiple union values set");

    }
  }
}
