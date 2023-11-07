// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "AwsCryptographyDbEncryptionSdkDecryptWithPermuteOperations.dfy"
include "AltDecryptStructure.dfy"
include "AltDynamoToStruct.dfy"
include "Permute.dfy"
include "ValidatePermuted.dfy"

module
  {:extern "software.amazon.cryptography.dbencryptionsdk.decryptwithpermute.internaldafny" }
  DynamoDbPermuteDecryptor refines AbstractAwsCryptographyDbEncryptionSdkDecryptWithPermuteService
{
  import opened DynamoDbItemEncryptorUtil
  import StructuredEncryption
  import CSE = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import DDBE = AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import MaterialProviders
  import Operations = AwsCryptographyDbEncryptionSdkDecryptWithPermuteOperations
  import SE =  StructuredEncryptionUtil
  import InternalLegacyOverride
  import SortedSets
  import DDB = ComAmazonawsDynamodbTypes
  import DynamoDbItemEncryptor


  // There is no sensible default, so construct something simple but invalid at runtime.
  function method DefaultDynamoDbPermuteDecryptorConfig(): DynamoDbPermuteDecryptorConfig
  {
    DynamoDbPermuteDecryptorConfig(
      inner := DynamoDbItemEncryptor.DefaultDynamoDbItemEncryptorConfig()
    )
  }

  method {:vcs_split_on_every_assert} DynamoDbPermuteDecryptor(config: DynamoDbPermuteDecryptorConfig)
    returns (res: Result<DynamoDbPermuteDecryptorClient, Error>)
  {
    var innerClientR := DynamoDbItemEncryptor.DynamoDbItemEncryptor(config.inner);
    var innerClient :- innerClientR.MapFailure(e => AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor(e));
    var internalConfig := Operations.Config(
      inner := innerClient.config
    );
    var client := new DynamoDbPermuteDecryptorClient(internalConfig);
    return Success(client);
  }

  class DynamoDbPermuteDecryptorClient... {

    predicate ValidState()
    {
      && Operations.ValidInternalConfig?(config)
      && History !in Operations.ModifiesInternalConfig(config)
      && Modifies == Operations.ModifiesInternalConfig(config) + {History}
    }

    constructor(config: Operations.InternalConfig)
    {
      this.config := config;
      History := new IDynamoDbPermuteDecryptorClientCallHistory();
      Modifies := Operations.ModifiesInternalConfig(config) + {History};
    }

  }

}
