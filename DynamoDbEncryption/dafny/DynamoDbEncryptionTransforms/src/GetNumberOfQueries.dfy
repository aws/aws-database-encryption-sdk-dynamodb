// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "DynamoDbMiddlewareSupport.dfy"

module NumberOfQueries {
  import opened DdbMiddlewareConfig
  import DynamoDbMiddlewareSupport
  import opened Wrappers
  import opened StandardLibrary.UInt
  import DDB = ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes
  import EncTypes = AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes
  import Seq
  import DynamoDBSupport

  method Get(config: Config, input: GetNumberOfQueriesInput)
    returns (output: Result<GetNumberOfQueriesOutput, Error>)
    requires ValidConfig?(config)
    ensures ValidConfig?(config)
    modifies ModifiesConfig(config)
  {
    if || input.input.TableName !in config.tableEncryptionConfigs
       || config.tableEncryptionConfigs[input.input.TableName].search.None?
    {
      return Success(GetNumberOfQueriesOutput(numberOfQueries := 1));
    }
    var conf := config.tableEncryptionConfigs[input.input.TableName];
    var numQueries :- DynamoDbMiddlewareSupport.GetNumberOfQueries(conf, input.input);
    return Success(GetNumberOfQueriesOutput(numberOfQueries := numQueries));
  }
}
