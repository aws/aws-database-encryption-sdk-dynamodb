// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms
{
  public class ResolveAttributesOutput
  {
    private System.Collections.Generic.Dictionary<string, string> _virtualFields;
    private System.Collections.Generic.Dictionary<string, string> _compoundBeacons;
    public System.Collections.Generic.Dictionary<string, string> VirtualFields
    {
      get { return this._virtualFields; }
      set { this._virtualFields = value; }
    }
    public bool IsSetVirtualFields()
    {
      return this._virtualFields != null;
    }
    public System.Collections.Generic.Dictionary<string, string> CompoundBeacons
    {
      get { return this._compoundBeacons; }
      set { this._compoundBeacons = value; }
    }
    public bool IsSetCompoundBeacons()
    {
      return this._compoundBeacons != null;
    }
    public void Validate()
    {
      if (!IsSetVirtualFields()) throw new System.ArgumentException("Missing value for required property 'VirtualFields'");
      if (!IsSetCompoundBeacons()) throw new System.ArgumentException("Missing value for required property 'CompoundBeacons'");

    }
  }
}
