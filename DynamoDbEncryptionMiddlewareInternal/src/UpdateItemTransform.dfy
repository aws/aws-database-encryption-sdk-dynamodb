// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "DdbMiddlewareConfig.dfy"

module UpdateItemTransform {
  import opened DdbMiddlewareConfig
  import opened Wrappers
  import DDB = ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDynamoDbEncryptionTypes
  import EncTypes = AwsCryptographyDynamoDbItemEncryptorTypes
  import Seq

  method Input(config: Config, input: UpdateItemInputTransformInput)
    returns (output: Result<UpdateItemInputTransformOutput, Error>)
    requires ValidConfig?(config)
    ensures ValidConfig?(config)
    modifies ModifiesConfig(config)

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#validate-before-updateitem
    //= type=implication
    //# Before a [UpdateItem](https://docs.aws.amazon.com/amazondynamodb/latest/APIReference/API_UpdateItem.html)
    //# call is made to DynamoDB,
    //# the request MUST fail, and the client make no network call to DynamoDB,
    //# if there exists an Item Encryptor
    //# specified within the [DynamoDB Encryption Client Config](#dynamodb-encryption-client-configuration)
    //# with a [DynamoDB Table Name](./ddb-item-encryptor.md#dynamodb-table-name)
    //# equal to `TableName` in the request.
    ensures input.sdkInput.TableName in config.tableEncryptionConfigs ==> output.Failure?

    //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#validate-before-updateitem
    //= type=implication
    //# If no such Item Encryptor exists,
    //# there MUST NOT be any modification
    //# to the UpdateItem request.
    ensures input.sdkInput.TableName !in config.tableEncryptionConfigs ==>
      && output.Success?
      && output.value.transformedInput == input.sdkInput
  {
    if input.sdkInput.TableName in config.tableEncryptionConfigs {
      return MakeError("Updates are not supported on tables configured with encryption.");
    } else {
      return Success(UpdateItemInputTransformOutput(transformedInput := input.sdkInput));
    }
  }

  method Output(config: Config, input: UpdateItemOutputTransformInput)
    returns (output: Result<UpdateItemOutputTransformOutput, Error>)
    ensures output.Success? && output.value.transformedOutput == input.sdkOutput
  {
    return Success(UpdateItemOutputTransformOutput(transformedOutput := input.sdkOutput));
  }
}
