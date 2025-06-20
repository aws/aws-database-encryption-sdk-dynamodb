// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "DynamoDbMiddlewareSupport.dfy"

module AttributeResolver {
  import opened DdbMiddlewareConfig
  import opened DynamoDbMiddlewareSupport
  import opened Wrappers
  import opened StandardLibrary.UInt
  import DDB = ComAmazonawsDynamodbTypes
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes
  import EncTypes = AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes
  import Seq
  import DynamoDBSupport

  method Resolve(config: Config, input: ResolveAttributesInput)
    returns (output: Result<ResolveAttributesOutput, Error>)
    requires ValidConfig?(config)
    ensures ValidConfig?(config)
    modifies ModifiesConfig(config)

  {
    if || input.TableName !in config.tableEncryptionConfigs
       || config.tableEncryptionConfigs[input.TableName].search.None?
    {
      return Success(
          ResolveAttributesOutput(
            VirtualFields := map[],
            CompoundBeacons := map[]
          )
        );
    } else {
      var tableConfig := config.tableEncryptionConfigs[input.TableName];
      var bucket :- GetRandomBucket(tableConfig);
      var vf :- GetVirtualFields(tableConfig.search.value, input.Item, input.Version);
      var cb :- GetCompoundBeacons(tableConfig.search.value, input.Item, input.Version, bucket);
      return Success(
          ResolveAttributesOutput(
            VirtualFields := vf,
            CompoundBeacons := cb
          )
        );
    }
  }

}
