// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb
{
  public class StandardBeacon
  {
    private string _name;
    private int? _length;
    private string _loc;
    private AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconStyle _style;
    private int? _numberOfPartitions;
    public string Name
    {
      get { return this._name; }
      set { this._name = value; }
    }
    public bool IsSetName()
    {
      return this._name != null;
    }
    public int Length
    {
      get { return this._length.GetValueOrDefault(); }
      set { this._length = value; }
    }
    public bool IsSetLength()
    {
      return this._length.HasValue;
    }
    public string Loc
    {
      get { return this._loc; }
      set { this._loc = value; }
    }
    public bool IsSetLoc()
    {
      return this._loc != null;
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconStyle Style
    {
      get { return this._style; }
      set { this._style = value; }
    }
    public bool IsSetStyle()
    {
      return this._style != null;
    }
    public int NumberOfPartitions
    {
      get { return this._numberOfPartitions.GetValueOrDefault(); }
      set { this._numberOfPartitions = value; }
    }
    public bool IsSetNumberOfPartitions()
    {
      return this._numberOfPartitions.HasValue;
    }
    public void Validate()
    {
      if (!IsSetName()) throw new System.ArgumentException("Missing value for required property 'Name'");
      if (!IsSetLength()) throw new System.ArgumentException("Missing value for required property 'Length'");
      if (IsSetLoc())
      {
        if (Loc.Length < 1)
        {
          throw new System.ArgumentException(
              String.Format("Member Loc of structure StandardBeacon has type TerminalLocation which has a minimum length of 1 but was given the value '{0}' which has length {1}.", Loc, Loc.Length));
        }
      }
      if (IsSetNumberOfPartitions())
      {
        if (NumberOfPartitions < 1)
        {
          throw new System.ArgumentException(
              String.Format("Member NumberOfPartitions of structure StandardBeacon has type PartitionCount which has a minimum of 1 but was given the value {0}.", NumberOfPartitions));
        }
        if (NumberOfPartitions > 255)
        {
          throw new System.ArgumentException(
              String.Format("Member NumberOfPartitions of structure StandardBeacon has type PartitionCount which has a maximum of 255 but was given the value {0}.", NumberOfPartitions));
        }
      }
    }
  }
}
