// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "DDBSupport.dfy"

module DescribeTableTransform {
  import opened DdbMiddlewareConfig
  import opened DynamoDBMiddlewareSupport
  import opened Wrappers
  import DDB = ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDynamoDbEncryptionTypes
  import EncTypes = AwsCryptographyDynamoDbItemEncryptorTypes
  import Seq

  method Input(config: Config, input: DescribeTableInputTransformInput)
    returns (output: Result<DescribeTableInputTransformOutput, Error>)
    ensures output.Success? && output.value.transformedInput == input.sdkInput
  {
    return Success(DescribeTableInputTransformOutput(transformedInput := input.sdkInput));
  }

  // TODO - implement this
  method Output(config: Config, input: DescribeTableOutputTransformInput)
    returns (output: Result<DescribeTableOutputTransformOutput, Error>)
    requires ValidConfig?(config)
    ensures ValidConfig?(config)
    modifies ModifiesConfig(config)
  {
    return Success(DescribeTableOutputTransformOutput(transformedOutput := input.sdkOutput));
  }
}