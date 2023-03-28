// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../../Model/AwsCryptographyDynamoDbEncryptionTypes.dfy"

module AwsCryptographyDynamoDbEncryptionOperations refines AbstractAwsCryptographyDynamoDbEncryptionOperations {
  datatype Config = Config()
  type InternalConfig = Config
  type ValidConfig = x : Config | ValidInternalConfig?(x) witness *

  predicate ValidInternalConfig?(config: InternalConfig)
  {true}

  function ModifiesInternalConfig(config: InternalConfig) : set<object>
  { {} }
}
