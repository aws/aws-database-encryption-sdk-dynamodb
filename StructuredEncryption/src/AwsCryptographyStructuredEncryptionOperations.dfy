// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../Model/AwsCryptographyStructuredEncryptionTypes.dfy"

module AwsCryptographyStructuredEncryptionOperations refines AbstractAwsCryptographyStructuredEncryptionOperations {

  datatype Config = Config()

  type InternalConfig = Config

  predicate ValidInternalConfig?(config: InternalConfig)
  {true}

  function ModifiesInternalConfig(config: InternalConfig) : set<object>
  {{}}

  predicate EncryptStructureEnsuresPublicly(
    input: EncryptStructureInput, 
    output: Result<EncryptStructureOutput, Error>) {
      // Input and output types must be the same, and this constraint is useful to Dafny users
    && (output.Success? && input.plaintextStructure.content.DataMap? ==> output.value.encryptedStructure.content.DataMap?)
    && (output.Success? && input.plaintextStructure.content.DataList? ==> output.value.encryptedStructure.content.DataList?)
    && (output.Success? && input.plaintextStructure.content.Terminal? ==> output.value.encryptedStructure.content.Terminal?)
  }

  method EncryptStructure(config: InternalConfig, input: EncryptStructureInput)
      returns (output: Result<EncryptStructureOutput, Error>)
  {
    // TODO: Currently is a no-op, and just returns the inputted data
    var encryptOutput := EncryptStructureOutput(encryptedStructure := input.plaintextStructure);
    output := Success(encryptOutput);
  }

  predicate DecryptStructureEnsuresPublicly(
    input: DecryptStructureInput, 
    output: Result<DecryptStructureOutput, Error>) {
      // Input and output types must be the same, and this constraint is useful to Dafny users
    && (output.Success? && input.encryptedStructure.content.DataMap? ==> output.value.plaintextStructure.content.DataMap?)
    && (output.Success? && input.encryptedStructure.content.DataList? ==> output.value.plaintextStructure.content.DataList?)
    && (output.Success? && input.encryptedStructure.content.Terminal? ==> output.value.plaintextStructure.content.Terminal?)
}
  
  method DecryptStructure(config: InternalConfig, input: DecryptStructureInput)
      returns (output: Result<DecryptStructureOutput, Error>)
  {
    // TODO: Currently is a no-op, and just returns the inputted data
    var decryptOutput := DecryptStructureOutput(plaintextStructure := input.encryptedStructure);
    output := Success(decryptOutput);
  }
}
