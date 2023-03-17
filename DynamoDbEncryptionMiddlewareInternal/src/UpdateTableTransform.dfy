// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "DDBSupport.dfy"

module UpdateTableTransform {
  import opened DdbMiddlewareConfig
  import opened DynamoDBMiddlewareSupport
  import opened Wrappers
  import DDB = ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDynamoDbEncryptionTypes
  import EncTypes = AwsCryptographyDynamoDbItemEncryptorTypes
  import Seq

  // TODO - implement this
  method Input(config: Config, input: UpdateTableInputTransformInput)
    returns (output: Result<UpdateTableInputTransformOutput, Error>)
    requires ValidConfig?(config)
    ensures ValidConfig?(config)
    modifies ModifiesConfig(config)
  {
    return Success(UpdateTableInputTransformOutput(transformedInput := input.sdkInput));
  }

  method Output(config: Config, input: UpdateTableOutputTransformInput)
    returns (output: Result<UpdateTableOutputTransformOutput, Error>)
    ensures output.Success? && output.value.transformedOutput == input.sdkOutput
  {
    return Success(UpdateTableOutputTransformOutput(transformedOutput := input.sdkOutput));
  }
}