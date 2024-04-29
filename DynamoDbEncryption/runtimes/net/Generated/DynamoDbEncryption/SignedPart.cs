// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb
{
  public class SignedPart
  {
    private string _name;
    private string _prefix;
    private string _loc;
    public string Name
    {
      get { return this._name; }
      set { this._name = value; }
    }
    public bool IsSetName()
    {
      return this._name != null;
    }
    public string Prefix
    {
      get { return this._prefix; }
      set { this._prefix = value; }
    }
    public bool IsSetPrefix()
    {
      return this._prefix != null;
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
    public void Validate()
    {
      if (!IsSetName()) throw new System.ArgumentException("Missing value for required property 'Name'");
      if (!IsSetPrefix()) throw new System.ArgumentException("Missing value for required property 'Prefix'");
      if (IsSetLoc())
      {
        if (Loc.Length < 1)
        {
          throw new System.ArgumentException(
              String.Format("Member Loc of structure SignedPart has type TerminalLocation which has a minimum length of 1 but was given the value '{0}' which has length {1}.", Loc, Loc.Length));
        }
      }
    }
  }
}
