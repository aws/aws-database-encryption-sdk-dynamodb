// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb
{
  public class VirtualPart
  {
    private string _loc;
    private System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualTransform> _trans;
    public string Loc
    {
      get { return this._loc; }
      set { this._loc = value; }
    }
    public bool IsSetLoc()
    {
      return this._loc != null;
    }
    public System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualTransform> Trans
    {
      get { return this._trans; }
      set { this._trans = value; }
    }
    public bool IsSetTrans()
    {
      return this._trans != null;
    }
    public void Validate()
    {
      if (!IsSetLoc()) throw new System.ArgumentException("Missing value for required property 'Loc'");
      if (IsSetTrans())
      {
        if (Trans.Count < 1)
        {
          throw new System.ArgumentException(
              String.Format("Member Trans of structure VirtualPart has List type VirtualTransformList which has a minimum length of 1 but was given a value with length {0}.", Trans.Count));
        }
      }
    }
  }
}
