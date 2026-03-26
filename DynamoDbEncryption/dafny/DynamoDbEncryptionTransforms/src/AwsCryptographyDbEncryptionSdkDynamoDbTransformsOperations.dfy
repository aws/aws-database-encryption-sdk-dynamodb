// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "DdbMiddlewareConfig.dfy"
include "DdbStatement.dfy"
include "PutItemTransform.dfy"
include "GetItemTransform.dfy"
include "UpdateItemTransform.dfy"
include "BatchWriteItemTransform.dfy"
include "TransactWriteItemsTransform.dfy"
include "BatchGetItemTransform.dfy"
include "ScanTransform.dfy"
include "QueryTransform.dfy"
include "TransactGetItemsTransform.dfy"
include "DeleteItemTransform.dfy"
include "ExecuteStatementTransform.dfy"
include "BatchExecuteStatementTransform.dfy"
include "ExecuteTransactionTransform.dfy"
include "AttributeResolver.dfy"
include "GetNumberOfQueries.dfy"

module AwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations refines AbstractAwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations {
  import opened DdbMiddlewareConfig
  import DDB = ComAmazonawsDynamodbTypes
  import AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes
  import DynamoDbItemEncryptor
  import DynamoToStruct
  import ENC = AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations
  import EncTypes = AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes
  import AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import Seq
  import DdbStatement
  import PutItemTransform
  import GetItemTransform
  import UpdateItemTransform
  import BatchWriteItemTransform
  import TransactWriteItemsTransform
  import BatchGetItemTransform
  import ScanTransform
  import QueryTransform
  import TransactGetItemsTransform
  import DeleteItemTransform
  import ExecuteStatementTransform
  import BatchExecuteStatementTransform
  import ExecuteTransactionTransform
  import AttributeResolver
  import NumberOfQueries

  predicate ValidInternalConfig?(config: InternalConfig)
  {
    ValidConfig?(config)
  }

  function ModifiesInternalConfig(config: InternalConfig) : set<object>
  {
    ModifiesConfig(config)
  }

  type InternalConfig = Config

  predicate PutItemInputTransformEnsuresPublicly(input: PutItemInputTransformInput, output: Result<PutItemInputTransformOutput, Error>)
  {true}

  method PutItemInputTransform(config: InternalConfig, input: PutItemInputTransformInput)
    returns (output: Result<PutItemInputTransformOutput, Error>)
  {
    output := PutItemTransform.Input(config, input);
  }

  predicate PutItemOutputTransformEnsuresPublicly(input: PutItemOutputTransformInput, output: Result<PutItemOutputTransformOutput, Error>)
  {true}

  method PutItemOutputTransform(config: InternalConfig, input: PutItemOutputTransformInput)
    returns (output: Result<PutItemOutputTransformOutput, Error>)
  {
    output := PutItemTransform.Output(config, input);
  }

  predicate GetItemInputTransformEnsuresPublicly(input: GetItemInputTransformInput, output: Result<GetItemInputTransformOutput, Error>)
  {true}

  method GetItemInputTransform(config: InternalConfig, input: GetItemInputTransformInput)
    returns (output: Result<GetItemInputTransformOutput, Error>)
  {
    output := GetItemTransform.Input(config, input);
  }

  predicate GetItemOutputTransformEnsuresPublicly(input: GetItemOutputTransformInput, output: Result<GetItemOutputTransformOutput, Error>)
  {true}

  method GetItemOutputTransform(config: InternalConfig, input: GetItemOutputTransformInput)
    returns (output: Result<GetItemOutputTransformOutput, Error>)
  {
    output := GetItemTransform.Output(config, input);
  }

  predicate UpdateItemInputTransformEnsuresPublicly(input: UpdateItemInputTransformInput, output: Result<UpdateItemInputTransformOutput, Error>)
  {true}

  method UpdateItemInputTransform(config: InternalConfig, input: UpdateItemInputTransformInput)
    returns (output: Result<UpdateItemInputTransformOutput, Error>)
  {
    output := UpdateItemTransform.Input(config, input);
  }

  predicate UpdateItemOutputTransformEnsuresPublicly(input: UpdateItemOutputTransformInput, output: Result<UpdateItemOutputTransformOutput, Error>)
  {true}

  method UpdateItemOutputTransform(config: InternalConfig, input: UpdateItemOutputTransformInput)
    returns (output: Result<UpdateItemOutputTransformOutput, Error>)
  {
    output := UpdateItemTransform.Output(config, input);
  }

  predicate BatchWriteItemInputTransformEnsuresPublicly(input: BatchWriteItemInputTransformInput, output: Result<BatchWriteItemInputTransformOutput, Error>)
  {true}

  method BatchWriteItemInputTransform(config: InternalConfig, input: BatchWriteItemInputTransformInput)
    returns (output: Result<BatchWriteItemInputTransformOutput, Error>)
  {
    output := BatchWriteItemTransform.Input(config, input);
  }

  predicate BatchWriteItemOutputTransformEnsuresPublicly(input: BatchWriteItemOutputTransformInput, output: Result<BatchWriteItemOutputTransformOutput, Error>)
  {true}

  method BatchWriteItemOutputTransform(config: InternalConfig, input: BatchWriteItemOutputTransformInput)
    returns (output: Result<BatchWriteItemOutputTransformOutput, Error>)
  {
    output := BatchWriteItemTransform.Output(config, input);
  }

  predicate TransactWriteItemsInputTransformEnsuresPublicly(input: TransactWriteItemsInputTransformInput, output: Result<TransactWriteItemsInputTransformOutput, Error>)
  {true}

  method TransactWriteItemsInputTransform(config: InternalConfig, input: TransactWriteItemsInputTransformInput)
    returns (output: Result<TransactWriteItemsInputTransformOutput, Error>)
  {
    output := TransactWriteItemsTransform.Input(config, input);
  }

  predicate TransactWriteItemsOutputTransformEnsuresPublicly(input: TransactWriteItemsOutputTransformInput, output: Result<TransactWriteItemsOutputTransformOutput, Error>)
  {true}

  method TransactWriteItemsOutputTransform(config: InternalConfig, input: TransactWriteItemsOutputTransformInput)
    returns (output: Result<TransactWriteItemsOutputTransformOutput, Error>)
  {
    output := TransactWriteItemsTransform.Output(config, input);
  }

  predicate BatchGetItemInputTransformEnsuresPublicly(input: BatchGetItemInputTransformInput, output: Result<BatchGetItemInputTransformOutput, Error>)
  {true}

  method BatchGetItemInputTransform(config: InternalConfig, input: BatchGetItemInputTransformInput)
    returns (output: Result<BatchGetItemInputTransformOutput, Error>)
  {
    output := BatchGetItemTransform.Input(config, input);
  }

  predicate BatchGetItemOutputTransformEnsuresPublicly(input: BatchGetItemOutputTransformInput, output: Result<BatchGetItemOutputTransformOutput, Error>)
  {true}

  method BatchGetItemOutputTransform(config: InternalConfig, input: BatchGetItemOutputTransformInput)
    returns (output: Result<BatchGetItemOutputTransformOutput, Error>)
  {
    output := BatchGetItemTransform.Output(config, input);
  }

  predicate ScanInputTransformEnsuresPublicly(input: ScanInputTransformInput, output: Result<ScanInputTransformOutput, Error>)
  {true}

  method ScanInputTransform(config: InternalConfig, input: ScanInputTransformInput)
    returns (output: Result<ScanInputTransformOutput, Error>)
  {
    output := ScanTransform.Input(config, input);
  }

  predicate ScanOutputTransformEnsuresPublicly(input: ScanOutputTransformInput, output: Result<ScanOutputTransformOutput, Error>)
  {true}

  method ScanOutputTransform(config: InternalConfig, input: ScanOutputTransformInput)
    returns (output: Result<ScanOutputTransformOutput, Error>)
  {
    output := ScanTransform.Output(config, input);
  }

  predicate QueryInputTransformEnsuresPublicly(input: QueryInputTransformInput, output: Result<QueryInputTransformOutput, Error>)
  {true}

  method QueryInputTransform(config: InternalConfig, input: QueryInputTransformInput)
    returns (output: Result<QueryInputTransformOutput, Error>)
  {
    output := QueryTransform.Input(config, input);
  }

  predicate QueryOutputTransformEnsuresPublicly(input: QueryOutputTransformInput, output: Result<QueryOutputTransformOutput, Error>)
  {true}

  method QueryOutputTransform(config: InternalConfig, input: QueryOutputTransformInput)
    returns (output: Result<QueryOutputTransformOutput, Error>)
  {
    output := QueryTransform.Output(config, input);
  }

  predicate TransactGetItemsInputTransformEnsuresPublicly(input: TransactGetItemsInputTransformInput, output: Result<TransactGetItemsInputTransformOutput, Error>)
  {true}

  method TransactGetItemsInputTransform(config: InternalConfig, input: TransactGetItemsInputTransformInput)
    returns (output: Result<TransactGetItemsInputTransformOutput, Error>)
  {
    output := TransactGetItemsTransform.Input(config, input);
  }

  predicate TransactGetItemsOutputTransformEnsuresPublicly(input: TransactGetItemsOutputTransformInput, output: Result<TransactGetItemsOutputTransformOutput, Error>)
  {true}

  method TransactGetItemsOutputTransform(config: InternalConfig, input: TransactGetItemsOutputTransformInput)
    returns (output: Result<TransactGetItemsOutputTransformOutput, Error>)
  {
    output := TransactGetItemsTransform.Output(config, input);
  }

  predicate DeleteItemInputTransformEnsuresPublicly(input: DeleteItemInputTransformInput, output: Result<DeleteItemInputTransformOutput, Error>)
  {true}

  method DeleteItemInputTransform(config: InternalConfig, input: DeleteItemInputTransformInput)
    returns (output: Result<DeleteItemInputTransformOutput, Error>)
  {
    output := DeleteItemTransform.Input(config, input);
  }

  predicate DeleteItemOutputTransformEnsuresPublicly(input: DeleteItemOutputTransformInput, output: Result<DeleteItemOutputTransformOutput, Error>)
  {true}

  method DeleteItemOutputTransform(config: InternalConfig, input: DeleteItemOutputTransformInput)
    returns (output: Result<DeleteItemOutputTransformOutput, Error>)
  {
    output := DeleteItemTransform.Output(config, input);
  }

  predicate ExecuteStatementInputTransformEnsuresPublicly(input: ExecuteStatementInputTransformInput, output: Result<ExecuteStatementInputTransformOutput, Error>)
  {true}

  method ExecuteStatementInputTransform(config: InternalConfig, input: ExecuteStatementInputTransformInput)
    returns (output: Result<ExecuteStatementInputTransformOutput, Error>)
  {
    output := ExecuteStatementTransform.Input(config, input);
  }

  predicate ExecuteStatementOutputTransformEnsuresPublicly(input: ExecuteStatementOutputTransformInput, output: Result<ExecuteStatementOutputTransformOutput, Error>)
  {true}

  method ExecuteStatementOutputTransform(config: InternalConfig, input: ExecuteStatementOutputTransformInput)
    returns (output: Result<ExecuteStatementOutputTransformOutput, Error>)
  {
    output := ExecuteStatementTransform.Output(config, input);
  }

  predicate BatchExecuteStatementInputTransformEnsuresPublicly(input: BatchExecuteStatementInputTransformInput, output: Result<BatchExecuteStatementInputTransformOutput, Error>)
  {true}

  method BatchExecuteStatementInputTransform(config: InternalConfig, input: BatchExecuteStatementInputTransformInput)
    returns (output: Result<BatchExecuteStatementInputTransformOutput, Error>)
  {
    output := BatchExecuteStatementTransform.Input(config, input);
  }

  predicate BatchExecuteStatementOutputTransformEnsuresPublicly(input: BatchExecuteStatementOutputTransformInput, output: Result<BatchExecuteStatementOutputTransformOutput, Error>)
  {true}

  method BatchExecuteStatementOutputTransform(config: InternalConfig, input: BatchExecuteStatementOutputTransformInput)
    returns (output: Result<BatchExecuteStatementOutputTransformOutput, Error>)
  {
    output := BatchExecuteStatementTransform.Output(config, input);
  }

  predicate ExecuteTransactionInputTransformEnsuresPublicly(input: ExecuteTransactionInputTransformInput, output: Result<ExecuteTransactionInputTransformOutput, Error>)
  {true}

  method ExecuteTransactionInputTransform(config: InternalConfig, input: ExecuteTransactionInputTransformInput)
    returns (output: Result<ExecuteTransactionInputTransformOutput, Error>)
  {
    output := ExecuteTransactionTransform.Input(config, input);
  }

  predicate ExecuteTransactionOutputTransformEnsuresPublicly(input: ExecuteTransactionOutputTransformInput, output: Result<ExecuteTransactionOutputTransformOutput, Error>)
  {true}

  method ExecuteTransactionOutputTransform(config: InternalConfig, input: ExecuteTransactionOutputTransformInput)
    returns (output: Result<ExecuteTransactionOutputTransformOutput, Error>)
    ensures output.Success? && output.value.transformedOutput == input.sdkOutput
  {
    output := ExecuteTransactionTransform.Output(config, input);
  }

  predicate ResolveAttributesEnsuresPublicly(input: ResolveAttributesInput, output: Result<ResolveAttributesOutput, Error>)
  {true}

  method ResolveAttributes(config: InternalConfig, input: ResolveAttributesInput)
    returns (output: Result<ResolveAttributesOutput, Error>)
  {
    output := AttributeResolver.Resolve(config, input);
  }

  predicate GetNumberOfQueriesEnsuresPublicly(input: GetNumberOfQueriesInput , output: Result<GetNumberOfQueriesOutput, Error>)
  {true}

  method GetNumberOfQueries(config: InternalConfig, input: GetNumberOfQueriesInput)
    returns (output: Result<GetNumberOfQueriesOutput, Error>)
  {
    output := NumberOfQueries.Get(config, input);
  }
}
