// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "AwsCryptographyStructuredEncryptionOperations.dfy"

module
  {:extern "Dafny.Aws.Cryptography.StructuredEncryption" }
  StructuredEncryption refines AbstractAwsCryptographyStructuredEncryptionService
{

  import Operations = AwsCryptographyStructuredEncryptionOperations
  import Aws.Cryptography.Primitives

  function method DefaultStructuredEncryptionConfig(): StructuredEncryptionConfig
  {
    StructuredEncryptionConfig
  }

  method StructuredEncryption(config: StructuredEncryptionConfig)
    returns (res: Result<StructuredEncryptionClient, Error>)
  {
    var maybePrimatives := Primitives.AtomicPrimitives();
    var primatives :- maybePrimatives.MapFailure(e => AwsCryptographyPrimitives(e));
    var client := new StructuredEncryptionClient(Operations.Config(primatives := primatives));
    return Success(client);
  }

  class StructuredEncryptionClient... {

    predicate ValidState()
    {
      && Operations.ValidInternalConfig?(config)
      && Modifies == Operations.ModifiesInternalConfig(config) + {History}
    }

    constructor(config: Operations.InternalConfig)
    {
      this.config := config;
      History := new IStructuredEncryptionClientCallHistory();
      Modifies := Operations.ModifiesInternalConfig(config) + {History};
    }

  }

}
