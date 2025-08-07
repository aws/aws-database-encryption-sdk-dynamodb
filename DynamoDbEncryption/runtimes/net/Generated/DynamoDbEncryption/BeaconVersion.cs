// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb
{
  public class BeaconVersion
  {
    private int? _version;
    private AWS.Cryptography.KeyStore.KeyStore _keyStore;
    private AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconKeySource _keySource;
    private System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.StandardBeacon> _standardBeacons;
    private System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.CompoundBeacon> _compoundBeacons;
    private System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualField> _virtualFields;
    private System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedPart> _encryptedParts;
    private System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.SignedPart> _signedParts;
    private int? _maximumNumberOfBuckets;
    private int? _defaultNumberOfBuckets;
    private AWS.Cryptography.DbEncryptionSDK.DynamoDb.IBucketSelector _bucketSelector;
    public int Version
    {
      get { return this._version.GetValueOrDefault(); }
      set { this._version = value; }
    }
    public bool IsSetVersion()
    {
      return this._version.HasValue;
    }
    public AWS.Cryptography.KeyStore.KeyStore KeyStore
    {
      get { return this._keyStore; }
      set { this._keyStore = value; }
    }
    public bool IsSetKeyStore()
    {
      return this._keyStore != null;
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.BeaconKeySource KeySource
    {
      get { return this._keySource; }
      set { this._keySource = value; }
    }
    public bool IsSetKeySource()
    {
      return this._keySource != null;
    }
    public System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.StandardBeacon> StandardBeacons
    {
      get { return this._standardBeacons; }
      set { this._standardBeacons = value; }
    }
    public bool IsSetStandardBeacons()
    {
      return this._standardBeacons != null;
    }
    public System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.CompoundBeacon> CompoundBeacons
    {
      get { return this._compoundBeacons; }
      set { this._compoundBeacons = value; }
    }
    public bool IsSetCompoundBeacons()
    {
      return this._compoundBeacons != null;
    }
    public System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.VirtualField> VirtualFields
    {
      get { return this._virtualFields; }
      set { this._virtualFields = value; }
    }
    public bool IsSetVirtualFields()
    {
      return this._virtualFields != null;
    }
    public System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedPart> EncryptedParts
    {
      get { return this._encryptedParts; }
      set { this._encryptedParts = value; }
    }
    public bool IsSetEncryptedParts()
    {
      return this._encryptedParts != null;
    }
    public System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.SignedPart> SignedParts
    {
      get { return this._signedParts; }
      set { this._signedParts = value; }
    }
    public bool IsSetSignedParts()
    {
      return this._signedParts != null;
    }
    public int MaximumNumberOfBuckets
    {
      get { return this._maximumNumberOfBuckets.GetValueOrDefault(); }
      set { this._maximumNumberOfBuckets = value; }
    }
    public bool IsSetMaximumNumberOfBuckets()
    {
      return this._maximumNumberOfBuckets.HasValue;
    }
    public int DefaultNumberOfBuckets
    {
      get { return this._defaultNumberOfBuckets.GetValueOrDefault(); }
      set { this._defaultNumberOfBuckets = value; }
    }
    public bool IsSetDefaultNumberOfBuckets()
    {
      return this._defaultNumberOfBuckets.HasValue;
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.IBucketSelector BucketSelector
    {
      get { return this._bucketSelector; }
      set { this._bucketSelector = value; }
    }
    public bool IsSetBucketSelector()
    {
      return this._bucketSelector != null;
    }
    public void Validate()
    {
      if (!IsSetVersion()) throw new System.ArgumentException("Missing value for required property 'Version'");
      if (!IsSetKeyStore()) throw new System.ArgumentException("Missing value for required property 'KeyStore'");
      if (!IsSetKeySource()) throw new System.ArgumentException("Missing value for required property 'KeySource'");
      if (!IsSetStandardBeacons()) throw new System.ArgumentException("Missing value for required property 'StandardBeacons'");
      if (IsSetCompoundBeacons())
      {
        if (CompoundBeacons.Count < 1)
        {
          throw new System.ArgumentException(
              String.Format("Member CompoundBeacons of structure BeaconVersion has List type CompoundBeaconList which has a minimum length of 1 but was given a value with length {0}.", CompoundBeacons.Count));
        }
      }
      if (IsSetVirtualFields())
      {
        if (VirtualFields.Count < 1)
        {
          throw new System.ArgumentException(
              String.Format("Member VirtualFields of structure BeaconVersion has List type VirtualFieldList which has a minimum length of 1 but was given a value with length {0}.", VirtualFields.Count));
        }
      }
      if (IsSetEncryptedParts())
      {
        if (EncryptedParts.Count < 1)
        {
          throw new System.ArgumentException(
              String.Format("Member EncryptedParts of structure BeaconVersion has List type EncryptedPartsList which has a minimum length of 1 but was given a value with length {0}.", EncryptedParts.Count));
        }
      }
      if (IsSetSignedParts())
      {
        if (SignedParts.Count < 1)
        {
          throw new System.ArgumentException(
              String.Format("Member SignedParts of structure BeaconVersion has List type SignedPartsList which has a minimum length of 1 but was given a value with length {0}.", SignedParts.Count));
        }
      }
      if (IsSetMaximumNumberOfBuckets())
      {
        if (MaximumNumberOfBuckets < 1)
        {
          throw new System.ArgumentException(
              String.Format("Member MaximumNumberOfBuckets of structure BeaconVersion has type BucketCount which has a minimum of 1 but was given the value {0}.", MaximumNumberOfBuckets));
        }
        if (MaximumNumberOfBuckets > 255)
        {
          throw new System.ArgumentException(
              String.Format("Member MaximumNumberOfBuckets of structure BeaconVersion has type BucketCount which has a maximum of 255 but was given the value {0}.", MaximumNumberOfBuckets));
        }
      }
      if (IsSetDefaultNumberOfBuckets())
      {
        if (DefaultNumberOfBuckets < 1)
        {
          throw new System.ArgumentException(
              String.Format("Member DefaultNumberOfBuckets of structure BeaconVersion has type BucketCount which has a minimum of 1 but was given the value {0}.", DefaultNumberOfBuckets));
        }
        if (DefaultNumberOfBuckets > 255)
        {
          throw new System.ArgumentException(
              String.Format("Member DefaultNumberOfBuckets of structure BeaconVersion has type BucketCount which has a maximum of 255 but was given the value {0}.", DefaultNumberOfBuckets));
        }
      }
    }
  }
}
