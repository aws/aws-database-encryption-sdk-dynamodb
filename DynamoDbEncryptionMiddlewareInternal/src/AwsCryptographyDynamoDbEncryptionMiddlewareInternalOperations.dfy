// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../../private-aws-encryption-sdk-dafny-staging/ComAmazonawsDynamodb/Model/ComAmazonawsDynamodbTypes.dfy"
include "../Model/AwsCryptographyDynamoDbEncryptionMiddlewareInternalTypes.dfy"

// TODO break this into multiple files
module AwsCryptographyDynamoDbEncryptionMiddlewareInternalOperations refines AbstractAwsCryptographyDynamoDbEncryptionMiddlewareInternalOperations {
  import DDB = ComAmazonawsDynamodbTypes
  import AwsCryptographyDynamoDbItemEncryptorTypes
  import DynamoDbItemEncryptor

  datatype TableConfig = TableConfig(
    partitionKeyName: string,
    sortKeyName: Option<string>,
    itemEncryptor: DynamoDbItemEncryptor.DynamoDbItemEncryptorClient
    // TODO scan beacon config
  )

  predicate ValidTableConfig?(config: TableConfig) {
    var encryptoConfig := config.itemEncryptor.config;
    && config.partitionKeyName == encryptoConfig.partitionKeyName
    && config.sortKeyName == encryptoConfig.sortKeyName
  }

  type ValidTableConfig = c: TableConfig | ValidTableConfig?(c) witness *

  datatype Config = Config(
    tableEncryptionConfigs: map<string, ValidTableConfig>
    // TODO allowed passthrough tables
  )
  predicate ValidInternalConfig?(config: InternalConfig)
  {
    forall tableName <- config.tableEncryptionConfigs
    ::
      config.tableEncryptionConfigs[tableName].itemEncryptor.config.tableName == tableName
  }

  type InternalConfig = Config

  // TODO Not sure why the verifier is not complaining that I am not modeling the itemEncryptor.Modifies...
  function ModifiesInternalConfig(config: InternalConfig) : set<object>
  {{}}

  predicate PutItemInputTransformEnsuresPublicly(input: PutItemInputTransformInput, output: Result<PutItemInputTransformOutput, Error>)
  {true}

  method PutItemInputTransform(config: InternalConfig, input: PutItemInputTransformInput)
    returns (output: Result<PutItemInputTransformOutput, Error>)
  {
      return Failure(DynamoDbEncryptionMiddlewareInternalException(message:="Unimplemented"));
  }

  predicate PutItemOutputTransformEnsuresPublicly(input: PutItemOutputTransformInput, output: Result<PutItemOutputTransformOutput, Error>)
  {true}

  method PutItemOutputTransform(config: InternalConfig, input: PutItemOutputTransformInput)
    returns (output: Result<PutItemOutputTransformOutput, Error>)
  {
      return Failure(DynamoDbEncryptionMiddlewareInternalException(message:="Unimplemented"));
  }

  predicate GetItemInputTransformEnsuresPublicly(input: GetItemInputTransformInput, output: Result<GetItemInputTransformOutput, Error>)
  {true}

  method GetItemInputTransform(config: InternalConfig, input: GetItemInputTransformInput)
    returns (output: Result<GetItemInputTransformOutput, Error>)
  {
      return Failure(DynamoDbEncryptionMiddlewareInternalException(message:="Unimplemented"));
  }

  predicate GetItemOutputTransformEnsuresPublicly(input: GetItemOutputTransformInput, output: Result<GetItemOutputTransformOutput, Error>)
  {true}

  method GetItemOutputTransform(config: InternalConfig, input: GetItemOutputTransformInput)
    returns (output: Result<GetItemOutputTransformOutput, Error>)
  {
      return Failure(DynamoDbEncryptionMiddlewareInternalException(message:="Unimplemented"));
  }

  predicate UpdateItemInputTransformEnsuresPublicly(input: UpdateItemInputTransformInput, output: Result<UpdateItemInputTransformOutput, Error>)
  {true}

  method UpdateItemInputTransform(config: InternalConfig, input: UpdateItemInputTransformInput)
    returns (output: Result<UpdateItemInputTransformOutput, Error>)
  {
      return Failure(DynamoDbEncryptionMiddlewareInternalException(message:="Unimplemented"));
  }

  predicate UpdateItemOutputTransformEnsuresPublicly(input: UpdateItemOutputTransformInput, output: Result<UpdateItemOutputTransformOutput, Error>)
  {true}

  method UpdateItemOutputTransform(config: InternalConfig, input: UpdateItemOutputTransformInput)
    returns (output: Result<UpdateItemOutputTransformOutput, Error>)
  {
      return Failure(DynamoDbEncryptionMiddlewareInternalException(message:="Unimplemented"));
  }

  predicate BatchWriteItemInputTransformEnsuresPublicly(input: BatchWriteItemInputTransformInput, output: Result<BatchWriteItemInputTransformOutput, Error>)
  {true}

  method BatchWriteItemInputTransform(config: InternalConfig, input: BatchWriteItemInputTransformInput)
    returns (output: Result<BatchWriteItemInputTransformOutput, Error>)
  {
      return Failure(DynamoDbEncryptionMiddlewareInternalException(message:="Unimplemented"));
  }

  predicate BatchWriteItemOutputTransformEnsuresPublicly(input: BatchWriteItemOutputTransformInput, output: Result<BatchWriteItemOutputTransformOutput, Error>)
  {true}

  method BatchWriteItemOutputTransform(config: InternalConfig, input: BatchWriteItemOutputTransformInput)
    returns (output: Result<BatchWriteItemOutputTransformOutput, Error>)
  {
      return Failure(DynamoDbEncryptionMiddlewareInternalException(message:="Unimplemented"));
  }

  predicate TransactWriteItemsInputTransformEnsuresPublicly(input: TransactWriteItemsInputTransformInput, output: Result<TransactWriteItemsInputTransformOutput, Error>)
  {true}

  method TransactWriteItemsInputTransform(config: InternalConfig, input: TransactWriteItemsInputTransformInput)
    returns (output: Result<TransactWriteItemsInputTransformOutput, Error>)
  {
      return Failure(DynamoDbEncryptionMiddlewareInternalException(message:="Unimplemented"));
  }

  predicate TransactWriteItemsOutputTransformEnsuresPublicly(input: TransactWriteItemsOutputTransformInput, output: Result<TransactWriteItemsOutputTransformOutput, Error>)
  {true}

  method TransactWriteItemsOutputTransform(config: InternalConfig, input: TransactWriteItemsOutputTransformInput)
    returns (output: Result<TransactWriteItemsOutputTransformOutput, Error>)
  {
      return Failure(DynamoDbEncryptionMiddlewareInternalException(message:="Unimplemented"));
  }

  predicate BatchGetItemInputTransformEnsuresPublicly(input: BatchGetItemInputTransformInput, output: Result<BatchGetItemInputTransformOutput, Error>)
  {true}

  method BatchGetItemInputTransform(config: InternalConfig, input: BatchGetItemInputTransformInput)
    returns (output: Result<BatchGetItemInputTransformOutput, Error>)
  {
      return Failure(DynamoDbEncryptionMiddlewareInternalException(message:="Unimplemented"));
  }

  predicate BatchGetItemOutputTransformEnsuresPublicly(input: BatchGetItemOutputTransformInput, output: Result<BatchGetItemOutputTransformOutput, Error>)
  {true}

  method BatchGetItemOutputTransform(config: InternalConfig, input: BatchGetItemOutputTransformInput)
    returns (output: Result<BatchGetItemOutputTransformOutput, Error>)
  {
      return Failure(DynamoDbEncryptionMiddlewareInternalException(message:="Unimplemented"));
  }

  predicate ScanInputTransformEnsuresPublicly(input: ScanInputTransformInput, output: Result<ScanInputTransformOutput, Error>)
  {true}

  method ScanInputTransform(config: InternalConfig, input: ScanInputTransformInput)
    returns (output: Result<ScanInputTransformOutput, Error>)
  {
      return Failure(DynamoDbEncryptionMiddlewareInternalException(message:="Unimplemented"));
  }

  predicate ScanOutputTransformEnsuresPublicly(input: ScanOutputTransformInput, output: Result<ScanOutputTransformOutput, Error>)
  {true}

  method ScanOutputTransform(config: InternalConfig, input: ScanOutputTransformInput)
    returns (output: Result<ScanOutputTransformOutput, Error>)
  {
      return Failure(DynamoDbEncryptionMiddlewareInternalException(message:="Unimplemented"));
  }

  predicate QueryInputTransformEnsuresPublicly(input: QueryInputTransformInput, output: Result<QueryInputTransformOutput, Error>)
  {true}

  method QueryInputTransform(config: InternalConfig, input: QueryInputTransformInput)
    returns (output: Result<QueryInputTransformOutput, Error>)
  {
      return Failure(DynamoDbEncryptionMiddlewareInternalException(message:="Unimplemented"));
  }

  predicate QueryOutputTransformEnsuresPublicly(input: QueryOutputTransformInput, output: Result<QueryOutputTransformOutput, Error>)
  {true}

  method QueryOutputTransform(config: InternalConfig, input: QueryOutputTransformInput)
    returns (output: Result<QueryOutputTransformOutput, Error>)
  {
      return Failure(DynamoDbEncryptionMiddlewareInternalException(message:="Unimplemented"));
  }

  predicate TransactGetItemsInputTransformEnsuresPublicly(input: TransactGetItemsInputTransformInput, output: Result<TransactGetItemsInputTransformOutput, Error>)
  {true}

  method TransactGetItemsInputTransform(config: InternalConfig, input: TransactGetItemsInputTransformInput)
    returns (output: Result<TransactGetItemsInputTransformOutput, Error>)
  {
      return Failure(DynamoDbEncryptionMiddlewareInternalException(message:="Unimplemented"));
  }

  predicate TransactGetItemsOutputTransformEnsuresPublicly(input: TransactGetItemsOutputTransformInput, output: Result<TransactGetItemsOutputTransformOutput, Error>)
  {true}

  method TransactGetItemsOutputTransform(config: InternalConfig, input: TransactGetItemsOutputTransformInput)
    returns (output: Result<TransactGetItemsOutputTransformOutput, Error>)
  {
      return Failure(DynamoDbEncryptionMiddlewareInternalException(message:="Unimplemented"));
  }

  predicate DeleteItemInputTransformEnsuresPublicly(input: DeleteItemInputTransformInput, output: Result<DeleteItemInputTransformOutput, Error>)
  {true}

  method DeleteItemInputTransform(config: InternalConfig, input: DeleteItemInputTransformInput)
    returns (output: Result<DeleteItemInputTransformOutput, Error>)
  {
      return Failure(DynamoDbEncryptionMiddlewareInternalException(message:="Unimplemented"));
  }

  predicate DeleteItemOutputTransformEnsuresPublicly(input: DeleteItemOutputTransformInput, output: Result<DeleteItemOutputTransformOutput, Error>)
  {true}

  method DeleteItemOutputTransform(config: InternalConfig, input: DeleteItemOutputTransformInput)
    returns (output: Result<DeleteItemOutputTransformOutput, Error>)
  {
      return Failure(DynamoDbEncryptionMiddlewareInternalException(message:="Unimplemented"));
  }

    predicate ExecuteStatementInputTransformEnsuresPublicly(input: ExecuteStatementInputTransformInput, output: Result<ExecuteStatementInputTransformOutput, Error>)
  {true}

  method ExecuteStatementInputTransform(config: InternalConfig, input: ExecuteStatementInputTransformInput)
    returns (output: Result<ExecuteStatementInputTransformOutput, Error>)
  {
      return Failure(DynamoDbEncryptionMiddlewareInternalException(message:="Not Supported"));
  }

  predicate ExecuteStatementOutputTransformEnsuresPublicly(input: ExecuteStatementOutputTransformInput, output: Result<ExecuteStatementOutputTransformOutput, Error>)
  {true}

  method ExecuteStatementOutputTransform(config: InternalConfig, input: ExecuteStatementOutputTransformInput)
    returns (output: Result<ExecuteStatementOutputTransformOutput, Error>)
  {
      return Failure(DynamoDbEncryptionMiddlewareInternalException(message:="Not Supported"));
  }
    predicate BatchExecuteStatementInputTransformEnsuresPublicly(input: BatchExecuteStatementInputTransformInput, output: Result<BatchExecuteStatementInputTransformOutput, Error>)
  {true}

  method BatchExecuteStatementInputTransform(config: InternalConfig, input: BatchExecuteStatementInputTransformInput)
    returns (output: Result<BatchExecuteStatementInputTransformOutput, Error>)
  {
      return Failure(DynamoDbEncryptionMiddlewareInternalException(message:="Not Supported"));
  }

  predicate BatchExecuteStatementOutputTransformEnsuresPublicly(input: BatchExecuteStatementOutputTransformInput, output: Result<BatchExecuteStatementOutputTransformOutput, Error>)
  {true}

  method BatchExecuteStatementOutputTransform(config: InternalConfig, input: BatchExecuteStatementOutputTransformInput)
    returns (output: Result<BatchExecuteStatementOutputTransformOutput, Error>)
  {
      return Failure(DynamoDbEncryptionMiddlewareInternalException(message:="Not Supported"));
  }
    predicate ExecuteTransactionInputTransformEnsuresPublicly(input: ExecuteTransactionInputTransformInput, output: Result<ExecuteTransactionInputTransformOutput, Error>)
  {true}

  method ExecuteTransactionInputTransform(config: InternalConfig, input: ExecuteTransactionInputTransformInput)
    returns (output: Result<ExecuteTransactionInputTransformOutput, Error>)
  {
      return Failure(DynamoDbEncryptionMiddlewareInternalException(message:="Not Supported"));
  }

  predicate ExecuteTransactionOutputTransformEnsuresPublicly(input: ExecuteTransactionOutputTransformInput, output: Result<ExecuteTransactionOutputTransformOutput, Error>)
  {true}

  method ExecuteTransactionOutputTransform(config: InternalConfig, input: ExecuteTransactionOutputTransformInput)
    returns (output: Result<ExecuteTransactionOutputTransformOutput, Error>)
  {
      return Failure(DynamoDbEncryptionMiddlewareInternalException(message:="Not Supported"));
  }
}
