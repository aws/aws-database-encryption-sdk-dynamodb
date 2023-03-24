// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "AwsCryptographyDynamoDbEncryptionResourcesOperations.dfy"

module
  {:extern "Dafny.Aws.Cryptography.DynamoDbEncryption.Resources" }
  DynamoDbEncryptionResources refines AbstractAwsCryptographyDynamoDbEncryptionResourcesService
{
  import StructuredEncryption
  import CSE = AwsCryptographyStructuredEncryptionTypes
  import MaterialProviders
  import Operations = AwsCryptographyDynamoDbEncryptionResourcesOperations
  import SE =  StructuredEncryptionUtil

  function method DefaultDynamoDbEncryptionResourcesConfig(): DynamoDbEncryptionResourcesConfig
  {
    DynamoDbEncryptionResourcesConfig
  }

  method DynamoDbEncryptionResources(config: DynamoDbEncryptionResourcesConfig)
    returns (res: Result<DynamoDbEncryptionResourcesClient, Error>)
  {
    var client := new DynamoDbEncryptionResourcesClient(Operations.Config);
    return Success(client);
  }

  class DynamoDbEncryptionResourcesClient... {

    predicate ValidState()
    {
      && Operations.ValidInternalConfig?(config)
      && History !in Operations.ModifiesInternalConfig(config)
      && Modifies == Operations.ModifiesInternalConfig(config) + {History}
    }

    constructor(config: Operations.InternalConfig)
    {
      this.config := config;
      History := new IDynamoDbEncryptionResourcesClientCallHistory();
      Modifies := Operations.ModifiesInternalConfig(config) + {History};
    }

  }

}
