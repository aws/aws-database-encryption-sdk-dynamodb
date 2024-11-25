// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyDynamoDbEncryptionTypesWrapped.dfy"

module {:extern} CreateInterceptedDDBClient {
  import opened Wrappers
  import AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import ComAmazonawsDynamodbTypes

  method {:extern} CreateInterceptedDDBClient(config: AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTablesEncryptionConfig)
    returns (output: Result<ComAmazonawsDynamodbTypes.IDynamoDBClient, AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error>)
    ensures output.Success? ==>
              && fresh(output.value)
              && fresh(output.value.Modifies)
              && fresh(output.value.History)
              && output.value.ValidState()

  method {:extern} CreateVanillaDDBClient()
    returns (output: Result<ComAmazonawsDynamodbTypes.IDynamoDBClient, AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error>)
    ensures output.Success? ==>
              && fresh(output.value)
              && fresh(output.value.Modifies)
              && fresh(output.value.History)
              && output.value.ValidState()

}
