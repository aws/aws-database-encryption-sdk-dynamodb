// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json
{
  public class JsonEncryptorConfig
  {
    private string _logicalTableName;
    private AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Actions _actions;
    private AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId _algorithmSuiteId;
    private AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.KeyAccess _keyAccess;
    public string LogicalTableName
    {
      get { return this._logicalTableName; }
      set { this._logicalTableName = value; }
    }
    public bool IsSetLogicalTableName()
    {
      return this._logicalTableName != null;
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Actions Actions
    {
      get { return this._actions; }
      set { this._actions = value; }
    }
    public bool IsSetActions()
    {
      return this._actions != null;
    }
    public AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId AlgorithmSuiteId
    {
      get { return this._algorithmSuiteId; }
      set { this._algorithmSuiteId = value; }
    }
    public bool IsSetAlgorithmSuiteId()
    {
      return this._algorithmSuiteId != null;
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.KeyAccess KeyAccess
    {
      get { return this._keyAccess; }
      set { this._keyAccess = value; }
    }
    public bool IsSetKeyAccess()
    {
      return this._keyAccess != null;
    }
    public void Validate()
    {
      if (!IsSetLogicalTableName()) throw new System.ArgumentException("Missing value for required property 'LogicalTableName'");
      if (!IsSetActions()) throw new System.ArgumentException("Missing value for required property 'Actions'");
      if (!IsSetKeyAccess()) throw new System.ArgumentException("Missing value for required property 'KeyAccess'");

    }
  }
}
