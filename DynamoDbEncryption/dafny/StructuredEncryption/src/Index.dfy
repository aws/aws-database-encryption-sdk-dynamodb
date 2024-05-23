// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations.dfy"

module
  {:extern "software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny" }
  StructuredEncryption refines AbstractAwsCryptographyDbEncryptionSdkStructuredEncryptionService
{

  import Operations = AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations
  import Aws.Cryptography.Primitives
  import MaterialProviders

  function method DefaultStructuredEncryptionConfig(): StructuredEncryptionConfig
  {
    StructuredEncryptionConfig
  }

  method StructuredEncryption(config: StructuredEncryptionConfig)
    returns (res: Result<StructuredEncryptionClient, Error>)
  {
    var maybePrimitives := Primitives.AtomicPrimitives();
    var primitives :- maybePrimitives.MapFailure(e => AwsCryptographyPrimitives(e));
    :- Need((primitives as object) is Primitives.AtomicPrimitivesClient, StructuredEncryptionException(message := "Primitives must return an atomic client"));
    var maybeMatProv := MaterialProviders.MaterialProviders();
    var matProv :- maybeMatProv.MapFailure(e => AwsCryptographyMaterialProviders(e));
    :- Need((matProv as object) is MaterialProviders.MaterialProvidersClient, StructuredEncryptionException(message := "matProv must return an providers client"));
    var client := new StructuredEncryptionClient(Operations.Config(primitives := (primitives as object) as Primitives.AtomicPrimitivesClient, materialProviders := (matProv as object) as MaterialProviders.MaterialProvidersClient));
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
