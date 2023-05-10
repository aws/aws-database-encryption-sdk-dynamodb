// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "DynamoDbMiddlewareSupport.dfy"

module DescribeTableTransform {
  import opened DdbMiddlewareConfig
  import opened DynamoDbMiddlewareSupport
  import opened Wrappers
  import DDB = ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes
  import EncTypes = AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes
  import Seq

  method Input(config: Config, input: DescribeTableInputTransformInput)
    returns (output: Result<DescribeTableInputTransformOutput, Error>)
    ensures output.Success? && output.value.transformedInput == input.sdkInput
  {
    return Success(DescribeTableInputTransformOutput(transformedInput := input.sdkInput));
  }

  method Output(config: Config, input: DescribeTableOutputTransformInput)
    returns (output: Result<DescribeTableOutputTransformOutput, Error>)
    requires ValidConfig?(config)
    ensures ValidConfig?(config)
  {
    if input.originalInput.TableName !in config.tableEncryptionConfigs {
      return Success(DescribeTableOutputTransformOutput(transformedOutput := input.sdkOutput));
    } else {
      var tableConfig := config.tableEncryptionConfigs[input.originalInput.TableName];
      var finalResult :- DescribeTableOutputForBeacons(tableConfig, input.sdkOutput);
      return Success(DescribeTableOutputTransformOutput(transformedOutput := finalResult));
    }
  }
}
