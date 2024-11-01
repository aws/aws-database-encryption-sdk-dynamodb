// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations.dfy"

module
  {:extern "software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny" }
  StructuredEncryption refines AbstractAwsCryptographyDbEncryptionSdkStructuredEncryptionService
{

  import Operations = AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations
  import Primitives = AtomicPrimitives
  import MaterialProviders

  function method DefaultStructuredEncryptionConfig(): StructuredEncryptionConfig
  {
    StructuredEncryptionConfig
  }

  method StructuredEncryption(config: StructuredEncryptionConfig)
    returns (res: Result<StructuredEncryptionClient, Error>)
    ensures res.Success? ==> res.value is StructuredEncryptionClient
  {
    var maybePrimitives := Primitives.AtomicPrimitives();
    var primitives :- maybePrimitives.MapFailure(e => AwsCryptographyPrimitives(e));

    var maybeMatProv := MaterialProviders.MaterialProviders();
    var matProv :- maybeMatProv.MapFailure(e => AwsCryptographyMaterialProviders(e));

    var client := new StructuredEncryptionClient(Operations.Config(primitives := primitives, materialProviders := matProv));
    return Success(client);
  }



  class StructuredEncryptionClient... {

    predicate ValidState()
    {
      && Operations.ValidInternalConfig?(config)
      && History !in Operations.ModifiesInternalConfig(config)
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
