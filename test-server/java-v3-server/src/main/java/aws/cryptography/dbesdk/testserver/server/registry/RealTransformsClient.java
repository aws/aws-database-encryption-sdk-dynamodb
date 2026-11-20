package aws.cryptography.dbesdk.testserver.server.registry;

import aws.cryptography.dbesdk.testserver.server.error.DbesdkClientException;
import software.amazon.awssdk.services.dynamodb.model.BatchExecuteStatementRequest;
import software.amazon.awssdk.services.dynamodb.model.BatchExecuteStatementResponse;
import software.amazon.awssdk.services.dynamodb.model.BatchGetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.BatchGetItemResponse;
import software.amazon.awssdk.services.dynamodb.model.BatchWriteItemRequest;
import software.amazon.awssdk.services.dynamodb.model.BatchWriteItemResponse;
import software.amazon.awssdk.services.dynamodb.model.DeleteItemRequest;
import software.amazon.awssdk.services.dynamodb.model.DeleteItemResponse;
import software.amazon.awssdk.services.dynamodb.model.ExecuteStatementRequest;
import software.amazon.awssdk.services.dynamodb.model.ExecuteStatementResponse;
import software.amazon.awssdk.services.dynamodb.model.ExecuteTransactionRequest;
import software.amazon.awssdk.services.dynamodb.model.ExecuteTransactionResponse;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;
import software.amazon.awssdk.services.dynamodb.model.QueryRequest;
import software.amazon.awssdk.services.dynamodb.model.QueryResponse;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanResponse;
import software.amazon.awssdk.services.dynamodb.model.TransactGetItemsRequest;
import software.amazon.awssdk.services.dynamodb.model.TransactGetItemsResponse;
import software.amazon.awssdk.services.dynamodb.model.TransactWriteItemsRequest;
import software.amazon.awssdk.services.dynamodb.model.TransactWriteItemsResponse;
import software.amazon.awssdk.services.dynamodb.model.UpdateItemRequest;
import software.amazon.awssdk.services.dynamodb.model.UpdateItemResponse;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.DynamoDbEncryptionTransforms;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchExecuteStatementInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchExecuteStatementOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchGetItemInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchGetItemOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchWriteItemInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchWriteItemOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.DeleteItemInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.DeleteItemOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ExecuteStatementInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ExecuteStatementOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ExecuteTransactionInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ExecuteTransactionOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.GetItemInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.GetItemOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.PutItemInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.PutItemOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.QueryInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.QueryOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ScanInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ScanOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.TransactGetItemsInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.TransactGetItemsOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.TransactWriteItemsInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.TransactWriteItemsOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.UpdateItemInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.UpdateItemOutputTransformInput;

/**
 * A configured {@link TransformsClient} backed by the real
 * {@link DynamoDbEncryptionTransforms} from the AWS Database Encryption SDK for
 * DynamoDB. Every call reaches the real DBE library. Any exception the library
 * throws is caught and rethrown as {@link DbesdkClientException} so the
 * operation wrapper forwards it as {@code DBESDKClientError} carrying the DBE
 * message unmodified.
 */
public final class RealTransformsClient implements TransformsClient {

  private final DynamoDbEncryptionTransforms transforms;

  public RealTransformsClient(DynamoDbEncryptionTransforms transforms) {
    this.transforms = transforms;
  }

  @Override
  public PutItemRequest putItemInputTransform(PutItemRequest sdkInput)
    throws DbesdkClientException {
    try {
      return transforms
        .PutItemInputTransform(
          PutItemInputTransformInput.builder().sdkInput(sdkInput).build()
        )
        .transformedInput();
    } catch (Exception dbeFailure) {
      throw new DbesdkClientException(dbeFailure);
    }
  }

  @Override
  public PutItemResponse putItemOutputTransform(
    PutItemRequest originalInput,
    PutItemResponse sdkOutput
  ) throws DbesdkClientException {
    try {
      return transforms
        .PutItemOutputTransform(
          PutItemOutputTransformInput
            .builder()
            .originalInput(originalInput)
            .sdkOutput(sdkOutput)
            .build()
        )
        .transformedOutput();
    } catch (Exception dbeFailure) {
      throw new DbesdkClientException(dbeFailure);
    }
  }

  @Override
  public GetItemResponse getItemOutputTransform(
    GetItemRequest originalInput,
    GetItemResponse sdkOutput
  ) throws DbesdkClientException {
    try {
      return transforms
        .GetItemOutputTransform(
          GetItemOutputTransformInput
            .builder()
            .originalInput(originalInput)
            .sdkOutput(sdkOutput)
            .build()
        )
        .transformedOutput();
    } catch (Exception dbeFailure) {
      throw new DbesdkClientException(dbeFailure);
    }
  }

  @Override
  public GetItemRequest getItemInputTransform(GetItemRequest sdkInput)
    throws DbesdkClientException {
    try {
      return transforms
        .GetItemInputTransform(
          GetItemInputTransformInput.builder().sdkInput(sdkInput).build()
        )
        .transformedInput();
    } catch (Exception dbeFailure) {
      throw new DbesdkClientException(dbeFailure);
    }
  }

  @Override
  public BatchWriteItemRequest batchWriteItemInputTransform(
    BatchWriteItemRequest sdkInput
  ) throws DbesdkClientException {
    try {
      return transforms
        .BatchWriteItemInputTransform(
          BatchWriteItemInputTransformInput.builder().sdkInput(sdkInput).build()
        )
        .transformedInput();
    } catch (Exception dbeFailure) {
      throw new DbesdkClientException(dbeFailure);
    }
  }

  @Override
  public TransactWriteItemsRequest transactWriteItemsInputTransform(
    TransactWriteItemsRequest sdkInput
  ) throws DbesdkClientException {
    try {
      return transforms
        .TransactWriteItemsInputTransform(
          TransactWriteItemsInputTransformInput
            .builder()
            .sdkInput(sdkInput)
            .build()
        )
        .transformedInput();
    } catch (Exception dbeFailure) {
      throw new DbesdkClientException(dbeFailure);
    }
  }

  @Override
  public ScanResponse scanOutputTransform(
    ScanRequest originalInput,
    ScanResponse sdkOutput
  ) throws DbesdkClientException {
    try {
      return transforms
        .ScanOutputTransform(
          ScanOutputTransformInput
            .builder()
            .originalInput(originalInput)
            .sdkOutput(sdkOutput)
            .build()
        )
        .transformedOutput();
    } catch (Exception dbeFailure) {
      throw new DbesdkClientException(dbeFailure);
    }
  }

  @Override
  public QueryResponse queryOutputTransform(
    QueryRequest originalInput,
    QueryResponse sdkOutput
  ) throws DbesdkClientException {
    try {
      return transforms
        .QueryOutputTransform(
          QueryOutputTransformInput
            .builder()
            .originalInput(originalInput)
            .sdkOutput(sdkOutput)
            .build()
        )
        .transformedOutput();
    } catch (Exception dbeFailure) {
      throw new DbesdkClientException(dbeFailure);
    }
  }

  @Override
  public BatchGetItemResponse batchGetItemOutputTransform(
    BatchGetItemRequest originalInput,
    BatchGetItemResponse sdkOutput
  ) throws DbesdkClientException {
    try {
      return transforms
        .BatchGetItemOutputTransform(
          BatchGetItemOutputTransformInput
            .builder()
            .originalInput(originalInput)
            .sdkOutput(sdkOutput)
            .build()
        )
        .transformedOutput();
    } catch (Exception dbeFailure) {
      throw new DbesdkClientException(dbeFailure);
    }
  }

  @Override
  public BatchWriteItemResponse batchWriteItemOutputTransform(
    BatchWriteItemRequest originalInput,
    BatchWriteItemResponse sdkOutput
  ) throws DbesdkClientException {
    try {
      return transforms
        .BatchWriteItemOutputTransform(
          BatchWriteItemOutputTransformInput
            .builder()
            .originalInput(originalInput)
            .sdkOutput(sdkOutput)
            .build()
        )
        .transformedOutput();
    } catch (Exception dbeFailure) {
      throw new DbesdkClientException(dbeFailure);
    }
  }

  @Override
  public ExecuteStatementRequest executeStatementInputTransform(
    ExecuteStatementRequest sdkInput
  ) throws DbesdkClientException {
    try {
      return transforms
        .ExecuteStatementInputTransform(
          ExecuteStatementInputTransformInput
            .builder()
            .sdkInput(sdkInput)
            .build()
        )
        .transformedInput();
    } catch (Exception dbeFailure) {
      throw new DbesdkClientException(dbeFailure);
    }
  }

  @Override
  public BatchExecuteStatementRequest batchExecuteStatementInputTransform(
    BatchExecuteStatementRequest sdkInput
  ) throws DbesdkClientException {
    try {
      return transforms
        .BatchExecuteStatementInputTransform(
          BatchExecuteStatementInputTransformInput
            .builder()
            .sdkInput(sdkInput)
            .build()
        )
        .transformedInput();
    } catch (Exception dbeFailure) {
      throw new DbesdkClientException(dbeFailure);
    }
  }

  @Override
  public ExecuteTransactionRequest executeTransactionInputTransform(
    ExecuteTransactionRequest sdkInput
  ) throws DbesdkClientException {
    try {
      return transforms
        .ExecuteTransactionInputTransform(
          ExecuteTransactionInputTransformInput
            .builder()
            .sdkInput(sdkInput)
            .build()
        )
        .transformedInput();
    } catch (Exception dbeFailure) {
      throw new DbesdkClientException(dbeFailure);
    }
  }

  @Override
  public ScanRequest scanInputTransform(ScanRequest sdkInput)
    throws DbesdkClientException {
    try {
      return transforms
        .ScanInputTransform(
          ScanInputTransformInput.builder().sdkInput(sdkInput).build()
        )
        .transformedInput();
    } catch (Exception dbeFailure) {
      throw new DbesdkClientException(dbeFailure);
    }
  }

  @Override
  public QueryRequest queryInputTransform(QueryRequest sdkInput)
    throws DbesdkClientException {
    try {
      return transforms
        .QueryInputTransform(
          QueryInputTransformInput.builder().sdkInput(sdkInput).build()
        )
        .transformedInput();
    } catch (Exception dbeFailure) {
      throw new DbesdkClientException(dbeFailure);
    }
  }

  @Override
  public UpdateItemRequest updateItemInputTransform(UpdateItemRequest sdkInput)
    throws DbesdkClientException {
    try {
      return transforms
        .UpdateItemInputTransform(
          UpdateItemInputTransformInput.builder().sdkInput(sdkInput).build()
        )
        .transformedInput();
    } catch (Exception dbeFailure) {
      throw new DbesdkClientException(dbeFailure);
    }
  }

  @Override
  public UpdateItemResponse updateItemOutputTransform(
    UpdateItemRequest originalInput,
    UpdateItemResponse sdkOutput
  ) throws DbesdkClientException {
    try {
      return transforms
        .UpdateItemOutputTransform(
          UpdateItemOutputTransformInput
            .builder()
            .originalInput(originalInput)
            .sdkOutput(sdkOutput)
            .build()
        )
        .transformedOutput();
    } catch (Exception dbeFailure) {
      throw new DbesdkClientException(dbeFailure);
    }
  }

  @Override
  public DeleteItemRequest deleteItemInputTransform(DeleteItemRequest sdkInput)
    throws DbesdkClientException {
    try {
      return transforms
        .DeleteItemInputTransform(
          DeleteItemInputTransformInput.builder().sdkInput(sdkInput).build()
        )
        .transformedInput();
    } catch (Exception dbeFailure) {
      throw new DbesdkClientException(dbeFailure);
    }
  }

  @Override
  public DeleteItemResponse deleteItemOutputTransform(
    DeleteItemRequest originalInput,
    DeleteItemResponse sdkOutput
  ) throws DbesdkClientException {
    try {
      return transforms
        .DeleteItemOutputTransform(
          DeleteItemOutputTransformInput
            .builder()
            .originalInput(originalInput)
            .sdkOutput(sdkOutput)
            .build()
        )
        .transformedOutput();
    } catch (Exception dbeFailure) {
      throw new DbesdkClientException(dbeFailure);
    }
  }

  @Override
  public TransactWriteItemsResponse transactWriteItemsOutputTransform(
    TransactWriteItemsRequest originalInput,
    TransactWriteItemsResponse sdkOutput
  ) throws DbesdkClientException {
    try {
      return transforms
        .TransactWriteItemsOutputTransform(
          TransactWriteItemsOutputTransformInput
            .builder()
            .originalInput(originalInput)
            .sdkOutput(sdkOutput)
            .build()
        )
        .transformedOutput();
    } catch (Exception dbeFailure) {
      throw new DbesdkClientException(dbeFailure);
    }
  }

  @Override
  public ExecuteStatementResponse executeStatementOutputTransform(
    ExecuteStatementRequest originalInput,
    ExecuteStatementResponse sdkOutput
  ) throws DbesdkClientException {
    try {
      return transforms
        .ExecuteStatementOutputTransform(
          ExecuteStatementOutputTransformInput
            .builder()
            .originalInput(originalInput)
            .sdkOutput(sdkOutput)
            .build()
        )
        .transformedOutput();
    } catch (Exception dbeFailure) {
      throw new DbesdkClientException(dbeFailure);
    }
  }

  @Override
  public ExecuteTransactionResponse executeTransactionOutputTransform(
    ExecuteTransactionRequest originalInput,
    ExecuteTransactionResponse sdkOutput
  ) throws DbesdkClientException {
    try {
      return transforms
        .ExecuteTransactionOutputTransform(
          ExecuteTransactionOutputTransformInput
            .builder()
            .originalInput(originalInput)
            .sdkOutput(sdkOutput)
            .build()
        )
        .transformedOutput();
    } catch (Exception dbeFailure) {
      throw new DbesdkClientException(dbeFailure);
    }
  }

  @Override
  public BatchExecuteStatementResponse batchExecuteStatementOutputTransform(
    BatchExecuteStatementRequest originalInput,
    BatchExecuteStatementResponse sdkOutput
  ) throws DbesdkClientException {
    try {
      return transforms
        .BatchExecuteStatementOutputTransform(
          BatchExecuteStatementOutputTransformInput
            .builder()
            .originalInput(originalInput)
            .sdkOutput(sdkOutput)
            .build()
        )
        .transformedOutput();
    } catch (Exception dbeFailure) {
      throw new DbesdkClientException(dbeFailure);
    }
  }

  @Override
  public BatchGetItemRequest batchGetItemInputTransform(
    BatchGetItemRequest sdkInput
  ) throws DbesdkClientException {
    try {
      return transforms
        .BatchGetItemInputTransform(
          BatchGetItemInputTransformInput.builder().sdkInput(sdkInput).build()
        )
        .transformedInput();
    } catch (Exception dbeFailure) {
      throw new DbesdkClientException(dbeFailure);
    }
  }

  @Override
  public TransactGetItemsRequest transactGetItemsInputTransform(
    TransactGetItemsRequest sdkInput
  ) throws DbesdkClientException {
    try {
      return transforms
        .TransactGetItemsInputTransform(
          TransactGetItemsInputTransformInput
            .builder()
            .sdkInput(sdkInput)
            .build()
        )
        .transformedInput();
    } catch (Exception dbeFailure) {
      throw new DbesdkClientException(dbeFailure);
    }
  }

  @Override
  public TransactGetItemsResponse transactGetItemsOutputTransform(
    TransactGetItemsRequest originalInput,
    TransactGetItemsResponse sdkOutput
  ) throws DbesdkClientException {
    try {
      return transforms
        .TransactGetItemsOutputTransform(
          TransactGetItemsOutputTransformInput
            .builder()
            .originalInput(originalInput)
            .sdkOutput(sdkOutput)
            .build()
        )
        .transformedOutput();
    } catch (Exception dbeFailure) {
      throw new DbesdkClientException(dbeFailure);
    }
  }
}
