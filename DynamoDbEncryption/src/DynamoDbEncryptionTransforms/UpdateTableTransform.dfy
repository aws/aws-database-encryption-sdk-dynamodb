// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "DdbMiddlewareConfig.dfy"

module UpdateTableTransform {
  import opened DdbMiddlewareConfig
  import opened DynamoDbMiddlewareSupport
  import opened Wrappers
  import DDB = ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDynamoDbEncryptionTransformsTypes
  import EncTypes = AwsCryptographyDynamoDbEncryptionItemEncryptorTypes
  import Seq

  method Input(config: Config, input: UpdateTableInputTransformInput)
    returns (output: Result<UpdateTableInputTransformOutput, Error>)
    requires ValidConfig?(config)
    ensures ValidConfig?(config)
  {
    if input.sdkInput.TableName !in config.tableEncryptionConfigs {
      return Success(UpdateTableInputTransformOutput(transformedInput := input.sdkInput));
    } else {
      var tableConfig := config.tableEncryptionConfigs[input.sdkInput.TableName];
      var finalResult :- UpdateTableInputForBeacons(tableConfig, input.sdkInput);
      return Success(UpdateTableInputTransformOutput(transformedInput := finalResult));
    }
  }

  method Output(config: Config, input: UpdateTableOutputTransformInput)
    returns (output: Result<UpdateTableOutputTransformOutput, Error>)
    ensures output.Success? && output.value.transformedOutput == input.sdkOutput
  {
    return Success(UpdateTableOutputTransformOutput(transformedOutput := input.sdkOutput));
  }
}
