// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "DDBSupport.dfy"

module CreateTableTransform {
  import opened DdbMiddlewareConfig
  import opened DynamoDBMiddlewareSupport
  import opened Wrappers
  import DDB = ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDynamoDbEncryptionTypes
  import EncTypes = AwsCryptographyDynamoDbItemEncryptorTypes
  import Seq

  // TODO - implement this
  method Input(config: Config, input: CreateTableInputTransformInput)
    returns (output: Result<CreateTableInputTransformOutput, Error>)
    requires ValidConfig?(config)
    ensures ValidConfig?(config)
    modifies ModifiesConfig(config)
  {
    return Success(CreateTableInputTransformOutput(transformedInput := input.sdkInput));
  }

  method Output(config: Config, input: CreateTableOutputTransformInput)
    returns (output: Result<CreateTableOutputTransformOutput, Error>)
    ensures output.Success? && output.value.transformedOutput == input.sdkOutput
  {
    return Success(CreateTableOutputTransformOutput(transformedOutput := input.sdkOutput));
  }
}