// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
include "../../../../submodules/MaterialProviders/StandardLibrary/src/Index.dfy"
include "../src/Index.dfy"
abstract module WrappedAbstractAwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorService {
  import opened Wrappers
  import opened StandardLibrary.UInt
  import opened UTF8
  import opened Types = AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes
  import WrappedService : AbstractAwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorService
  function method WrappedDefaultDynamoDbItemEncryptorConfig(): DynamoDbItemEncryptorConfig
  method {:extern} WrappedDynamoDbItemEncryptor(config: DynamoDbItemEncryptorConfig := WrappedDefaultDynamoDbItemEncryptorConfig())
    returns (res: Result<IDynamoDbItemEncryptorClient, Error>)
    ensures res.Success? ==>
              && fresh(res.value)
              && fresh(res.value.Modifies)
              && fresh(res.value.History)
              && res.value.ValidState()
}
