// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
include "../../../../submodules/MaterialProviders/StandardLibrary/src/Index.dfy"
include "../src/Index.dfy"
abstract module WrappedAbstractAwsCryptographyDbEncryptionSdkDynamoDbService {
  import opened Wrappers
  import opened StandardLibrary.UInt
  import opened UTF8
  import opened Types = AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import WrappedService : AbstractAwsCryptographyDbEncryptionSdkDynamoDbService
  function method WrappedDefaultDynamoDbEncryptionConfig(): DynamoDbEncryptionConfig
  method {:extern} WrappedDynamoDbEncryption(config: DynamoDbEncryptionConfig := WrappedDefaultDynamoDbEncryptionConfig())
    returns (res: Result<IDynamoDbEncryptionClient, Error>)
    ensures res.Success? ==>
              && fresh(res.value)
              && fresh(res.value.Modifies)
              && fresh(res.value.History)
              && res.value.ValidState()
}
