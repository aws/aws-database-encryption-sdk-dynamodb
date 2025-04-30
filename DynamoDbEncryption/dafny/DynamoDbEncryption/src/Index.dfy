// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "AwsCryptographyDbEncryptionSdkDynamoDbOperations.dfy"
include "Beacon.dfy"
include "CompoundBeacon.dfy"
include "ConfigToInfo.dfy"
include "DDBSupport.dfy"
include "DynamoDbEncryptionBranchKeyIdSupplier.dfy"
include "DynamoToStruct.dfy"
include "FilterExpr.dfy"
include "MemoryMath.dfy"
include "NormalizeNumber.dfy"
include "SearchInfo.dfy"
include "TermLoc.dfy"
include "UpdateExpr.dfy"
include "Util.dfy"
include "Virtual.dfy"

module
  {:extern "software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny" }
  DynamoDbEncryption refines AbstractAwsCryptographyDbEncryptionSdkDynamoDbService
{
  import Operations = AwsCryptographyDbEncryptionSdkDynamoDbOperations

  function method DefaultDynamoDbEncryptionConfig(): DynamoDbEncryptionConfig
  {
    DynamoDbEncryptionConfig()
  }

  method DynamoDbEncryption(config: DynamoDbEncryptionConfig)
    returns (res: Result<DynamoDbEncryptionClient, Error>)
    ensures res.Success? ==> res.value is DynamoDbEncryptionClient
  {
    var internalConfig := Operations.Config();
    var client := new DynamoDbEncryptionClient(internalConfig);
    return Success(client);
  }

  class DynamoDbEncryptionClient... {

    predicate ValidState()
    {
      && Operations.ValidInternalConfig?(config)
      && History !in Operations.ModifiesInternalConfig(config)
      && Modifies == Operations.ModifiesInternalConfig(config) + {History}
    }

    constructor(config: Operations.InternalConfig)
    {
      this.config := config;
      History := new IDynamoDbEncryptionClientCallHistory();
      Modifies := Operations.ModifiesInternalConfig(config) + {History};
    }

  }

}
