// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

/*
  Modified DDB calls share a lot of infrastructure.
  This file captures that commonality, implementing the things in ddb-support.md
*/

include "DdbMiddlewareConfig.dfy"
include "../../DynamoDbEncryption/src/DDBSupport.dfy"

module DynamoDbMiddlewareSupport {

  import DDB = ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened StandardLibrary.MemoryMath
  import opened BS = DynamoDBSupport
  import opened DdbMiddlewareConfig
  import AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations
  import ET = AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import Util = DynamoDbEncryptionUtil
  import SI = SearchableEncryptionInfo


  method GetNumberOfQueries(config : ValidTableConfig, query : DDB.QueryInput) returns (output : Result<ET.PartitionCount, Error>)
    requires config.search.Some?
  {
    var numQueries := BS.GetNumberOfQueries(config.search.value.versions[0], query);
    return numQueries.MapFailure(e => AwsCryptographyDbEncryptionSdkDynamoDb(e));
  }

  predicate method NoMap<X,Y>(m : Option<map<X,Y>>)
  {
    OptionalMapIsSafeBecauseItIsInMemory(m);
    m.None? || |m.value| as uint64 == 0
  }

  predicate method NoList<X>(m : Option<seq<X>>)
  {
    OptionalSequenceIsSafeBecauseItIsInMemory(m);
    m.None? || |m.value| as uint64 == 0
  }

  // IsWritable examines an AttributeMap and fails if it is unsuitable for writing.
  // Generally this means that no attribute names starts with "aws_dbe_"
  method {:opaque} IsWriteable(config : ValidTableConfig, item : DDB.AttributeMap)
    returns (ret : Result<bool, Error>)
  {
    var is_writable := BS.IsWriteable(item);
    return is_writable.MapFailure(e => E(e));
  }

  // IsSigned returned whether this attribute is signed according to this config
  predicate method {:opaque} IsSigned(
    config : ValidTableConfig,
    attr : string
  )
  {
    BS.IsSigned(config.itemEncryptor.config.attributeActionsOnEncrypt, attr)
  }

  // TestConditionExpression fails if a condition expression is not suitable for the
  // given encryption schema.
  // Generally this means no encrypted attribute is referenced.
  function method {:opaque} TestConditionExpression(
    config : ValidTableConfig,
    expr: Option<DDB.ConditionExpression>,
    attrNames: Option<DDB.ExpressionAttributeNameMap>,
    attrValues: Option<DDB.ExpressionAttributeValueMap>
  )
    : Result<bool, Error>
  {
    BS.TestConditionExpression(config.itemEncryptor.config.attributeActionsOnEncrypt, expr, attrNames, attrValues)
    .MapFailure(e => E(e))
  }

  // TestUpdateExpression fails if an update expression is not suitable for the
  // given encryption schema.
  // Generally this means no signed attribute is referenced.
  function method {:opaque} TestUpdateExpression(
    config : ValidTableConfig,
    expr: Option<DDB.UpdateExpression>,
    attrNames: Option<DDB.ExpressionAttributeNameMap>,
    attrValues: Option<DDB.ExpressionAttributeValueMap>
  )
    : Result<bool, Error>
  {
    BS.TestUpdateExpression(config.itemEncryptor.config.attributeActionsOnEncrypt, expr, attrNames, attrValues)
    .MapFailure(e => E(e))
  }

  // AddSignedBeacons examines an AttributeMap and modifies it to be appropriate for Searchable Encryption,
  // returning a replacement AttributeMap.
  method AddSignedBeacons(config : ValidTableConfig, item : DDB.AttributeMap, partition : ET.PartitionNumber)
    returns (output : Result<DDB.AttributeMap, Error>)
    requires AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations.ValidInternalConfig?(config.itemEncryptor.config)
    requires OneSearchValidState(config)
    ensures OneSearchValidState(config)
    modifies OneSearchModifies(config)
  {
    var ret := BS.AddSignedBeacons(config.search, item, partition);
    return ret.MapFailure(e => AwsCryptographyDbEncryptionSdkDynamoDb(e));
  }

  // GetEncryptedBeacons examines an AttributeMap and modifies it to be appropriate for Searchable Encryption,
  // returning just the new items.
  method GetEncryptedBeacons(config : ValidTableConfig, item : DDB.AttributeMap, keyId : Util.MaybeKeyId, partition : ET.PartitionNumber)
    returns (output : Result<DDB.AttributeMap, Error>)
    requires AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations.ValidInternalConfig?(config.itemEncryptor.config)
    requires OneSearchValidState(config)
    ensures OneSearchValidState(config)
    modifies OneSearchModifies(config)
  {
    var ret := BS.GetEncryptedBeacons(config.search, item, keyId, partition);
    return ret.MapFailure(e => AwsCryptographyDbEncryptionSdkDynamoDb(e));
  }

  function method GetBeaconKeyId(
    config : ValidTableConfig,
    keyExpr : Option<DDB.ConditionExpression>,
    filterExpr : Option<DDB.ConditionExpression>,
    values: Option<DDB.ExpressionAttributeValueMap>,
    names : Option<DDB.ExpressionAttributeNameMap>
  )
    : Result<Util.MaybeKeyId, Error>
  {
    BS.GetBeaconKeyId(config.search, keyExpr, filterExpr, values, names)
    .MapFailure(e => AwsCryptographyDbEncryptionSdkDynamoDb(e))
  }

  const HierarchicalKeyringId : UTF8.ValidUTF8Bytes :=
    var s := [0x61, 0x77, 0x73, 0x2d, 0x6b, 0x6d, 0x73, 0x2d, 0x68, 0x69, 0x65, 0x72, 0x61, 0x72, 0x63, 0x68, 0x79];
    assert s == UTF8.EncodeAscii("aws-kms-hierarchy");
    s

  // Return Beacon Key ID for use in beaconizing records to be written
  function method GetKeyIdFromHeader(config : ValidTableConfig, output : AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.EncryptItemOutput) :
    (ret : Result<Option<string>, Error>)
    ensures ret.Success? && config.search.Some? && config.search.value.curr().keySource.keyLoc.MultiLoc? ==>
              && output.parsedHeader.Some?
                 //= specification/searchable-encryption/search-config.md#get-beacon-key-id-from-parsed-header
                 //= type=implication
                 //# If the [Parsed Header](../dynamodb-encryption-client/encrypt-item.md#parsed-header)'s encrypted data keys
                 //# do not contain only one encrypted data key
                 //# this function MUST fail.
              && var keys := output.parsedHeader.value.encryptedDataKeys;
              && |keys| == 1

              //= specification/searchable-encryption/search-config.md#get-beacon-key-id-from-parsed-header
              //= type=implication
              //# If this single encrypted data key's
              //# [Key Provider ID](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/../structured-encryption/structures.md#key-provider-id)
              //# does not equal the provider ID
              //# for the [AWS KMS Hierarchical Keyring](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/aws-kms/aws-kms-hierarchical-keyring.md#ondecrypt)
              //# this function MUST fail.
              && keys[0].keyProviderId == HierarchicalKeyringId

              //= specification/searchable-encryption/search-config.md#get-beacon-key-id-from-parsed-header
              //= type=implication
              //# This function MUST return the [Key Provider Information](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/../structured-encryption/structures.md#key-provider-id).
              && UTF8.Decode(keys[0].keyProviderInfo).Success?
              && ret.value == Some(UTF8.Decode(keys[0].keyProviderInfo).value)
  {
    if config.search.Some? && config.search.value.curr().keySource.keyLoc.MultiLoc? then
      //= specification/searchable-encryption/search-config.md#get-beacon-key-after-encrypt
      //# If the [Beacon Key Source](#beacon-key-source) is a [Multi Key Store](#multi-key-store-initialization)
      //# then `beacon key id` MUST be obtained from [Get beacon key id from parsed header](#get-beacon-key-id-from-parsed-header).
      :- Need(output.parsedHeader.Some?, E("In multi-tenant mode, the parsed header is required."));
      var keys := output.parsedHeader.value.encryptedDataKeys;
      SequenceIsSafeBecauseItIsInMemory(keys);
      :- Need(|keys| as uint64 == 1, E("Encrypt header has more than one Encrypted Data Key"));
      :- Need(keys[0 as uint32].keyProviderId == HierarchicalKeyringId, E("In multi-tenant mode, keyProviderId must be aws-kms-hierarchy"));
      var keyId :- UTF8.Decode(keys[0 as uint32].keyProviderInfo).MapFailure(e => E(e));
      Success(Some(keyId))
    else
      //= specification/searchable-encryption/search-config.md#get-beacon-key-after-encrypt
      //# If the [Beacon Key Source](#beacon-key-source) is a [Single Key Store](#single-key-store-initialization)
      //# then `beacon key id` MUST be the configured [beacon key id](#beacon-key-id)
      Success(None)
  }

  // RemoveBeacons examines an AttributeMap and modifies it to be appropriate for customer use,
  // returning a replacement AttributeMap.
  function method {:opaque} RemoveBeacons(config : ValidTableConfig, item : DDB.AttributeMap)
    : Result<DDB.AttributeMap, Error>
  {
    BS.RemoveBeacons(config.search, item)
    .MapFailure(e => E(e))
  }

  // Transform a QueryInput object for searchable encryption.
  method {:opaque} QueryInputForBeacons(config : ValidTableConfig, req : DDB.QueryInput)
    returns (output : Result<DDB.QueryInput, Error>)
    requires OneSearchValidState(config)
    ensures OneSearchValidState(config)
    modifies OneSearchModifies(config)
  {
    var ret := BS.QueryInputForBeacons(config.search, config.itemEncryptor.config.attributeActionsOnEncrypt, req);
    return ret.MapFailure(e => AwsCryptographyDbEncryptionSdkDynamoDb(e));
  }

  // Transform a QueryOutput object for searchable encryption.
  method QueryOutputForBeacons(config : ValidTableConfig, req : DDB.QueryInput, resp : DDB.QueryOutput)
    returns (output : Result<DDB.QueryOutput, Error>)
    requires resp.Items.Some?
    ensures output.Success? ==> output.value.Items.Some?
    requires OneSearchValidState(config)
    ensures OneSearchValidState(config)
    modifies OneSearchModifies(config)
  {
    var ret := BS.QueryOutputForBeacons(config.search, req, resp);
    return ret.MapFailure(e => AwsCryptographyDbEncryptionSdkDynamoDb(e));
  }

  // Transform a ScanInput object for searchable encryption.
  method ScanInputForBeacons(config : ValidTableConfig, req : DDB.ScanInput)
    returns (output : Result<DDB.ScanInput, Error>)
    requires OneSearchValidState(config)
    ensures OneSearchValidState(config)
    modifies OneSearchModifies(config)
  {
    var ret := BS.ScanInputForBeacons(config.search, config.itemEncryptor.config.attributeActionsOnEncrypt, req);
    return ret.MapFailure(e => AwsCryptographyDbEncryptionSdkDynamoDb(e));
  }

  // Transform a ScanOutput object for searchable encryption.
  method ScanOutputForBeacons(config : ValidTableConfig, req : DDB.ScanInput, resp : DDB.ScanOutput)
    returns (output : Result<DDB.ScanOutput, Error>)
    requires resp.Items.Some?
    ensures output.Success? ==> output.value.Items.Some?
    requires OneSearchValidState(config)
    ensures OneSearchValidState(config)
    modifies OneSearchModifies(config)
  {
    var ret := BS.ScanOutputForBeacons(config.search, req, resp);
    return ret.MapFailure(e => AwsCryptographyDbEncryptionSdkDynamoDb(e));
  }

  method GetVirtualFields(search : SearchableEncryptionInfo.ValidSearchInfo, item : DDB.AttributeMap, version : Option<ET.VersionNumber>)
    returns (output : Result<map<string, string>, Error>)
  {
    if version.Some? && version.value != 1 {
      return Failure(E("Beacon Version Number must be '1'"));
    }
    var ret := BS.GetVirtualFields(search.curr(), item);
    return ret.MapFailure(e => AwsCryptographyDbEncryptionSdkDynamoDb(e));
  }

  method GetCompoundBeacons(search : SearchableEncryptionInfo.ValidSearchInfo, item : DDB.AttributeMap, version : Option<ET.VersionNumber>, partition : ET.PartitionNumber)
    returns (output : Result<map<string, string>, Error>)
  {
    if version.Some? && version.value != 1 {
      return Failure(E("Beacon Version Number must be '1'"));
    }
    var ret := BS.GetCompoundBeacons(search.curr(), item, partition);
    return ret.MapFailure(e => AwsCryptographyDbEncryptionSdkDynamoDb(e));
  }

}
