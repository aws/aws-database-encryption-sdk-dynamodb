package software.amazon.cryptography.dbencryptionsdk.dynamodb;

import static software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryptionExecutionAttribute.ORIGINAL_REQUEST;
import static software.amazon.cryptography.dbencryptionsdk.dynamodb.SupportedOperations.SUPPORTED_OPERATION_NAMES;

import java.util.Objects;
import java.util.Optional;
import software.amazon.awssdk.awscore.AwsRequest;
import software.amazon.awssdk.awscore.AwsRequestOverrideConfiguration;
import software.amazon.awssdk.core.ClientType;
import software.amazon.awssdk.core.SdkRequest;
import software.amazon.awssdk.core.SdkResponse;
import software.amazon.awssdk.core.interceptor.*;
import software.amazon.awssdk.services.dynamodb.model.*;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.*;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.DynamoDbEncryptionTransforms;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.*;

/**
 * Implementation of {@link ExecutionInterceptor} that enables client side encryption with DynamoDb.
 */
public class DynamoDbEncryptionInterceptor implements ExecutionInterceptor {

  private final DynamoDbTablesEncryptionConfig config;
  private DynamoDbEncryptionTransforms transformer;

  // This value is protected in DefaultDynamoDbBaseClientBuilder,
  // so hardcode here. We do not expect it to change.
  static final String DDB_NAME = "DynamoDb";

  protected DynamoDbEncryptionInterceptor(BuilderImpl builder) {
    this.config = builder.config();
    this.transformer =
      DynamoDbEncryptionTransforms
        .builder()
        .DynamoDbTablesEncryptionConfig(config)
        .build();
  }

  public DynamoDbTablesEncryptionConfig config() {
    return this.config;
  }

  @Override
  public SdkRequest modifyRequest(
    Context.ModifyRequest context,
    ExecutionAttributes executionAttributes
  ) {
    SdkRequest originalRequest = context.request();

    // Only transform DDB requests. Otherwise, throw an error.
    if (
      !executionAttributes
        .getAttribute(SdkExecutionAttribute.SERVICE_NAME)
        .equals(DDB_NAME)
    ) {
      throw DynamoDbEncryptionTransformsException
        .builder()
        .message(
          "DynamoDbEncryptionInterceptor does not support use with services other than DynamoDb."
        )
        .build();
    }

    // Throw an error if this is not a Sync client.
    if (
      !executionAttributes
        .getAttribute(SdkExecutionAttribute.CLIENT_TYPE)
        .equals(ClientType.SYNC)
    ) {
      throw DynamoDbEncryptionTransformsException
        .builder()
        .message(
          "DynamoDbEncryptionInterceptor does not support use with the Async client."
        )
        .build();
    }

    // Store original request so it can be used when intercepting the response
    executionAttributes.putAttribute(ORIGINAL_REQUEST, originalRequest);

    String operationName = executionAttributes.getAttribute(
      SdkExecutionAttribute.OPERATION_NAME
    );
    // Ensure we are dealing with a known operation. Otherwise, throw an error.
    checkSupportedOperation(operationName);

    SdkRequest outgoingRequest;
    switch (operationName) {
      case "BatchExecuteStatement":
        {
          BatchExecuteStatementRequest transformedRequest = transformer
            .BatchExecuteStatementInputTransform(
              BatchExecuteStatementInputTransformInput
                .builder()
                .sdkInput((BatchExecuteStatementRequest) originalRequest)
                .build()
            )
            .transformedInput();
          outgoingRequest =
            copyOverrideConfig(
              (BatchExecuteStatementRequest) originalRequest,
              transformedRequest
            );
          break;
        }
      case "BatchGetItem":
        {
          BatchGetItemRequest transformedRequest = transformer
            .BatchGetItemInputTransform(
              BatchGetItemInputTransformInput
                .builder()
                .sdkInput((BatchGetItemRequest) originalRequest)
                .build()
            )
            .transformedInput();
          outgoingRequest =
            copyOverrideConfig(
              (BatchGetItemRequest) originalRequest,
              transformedRequest
            );
          break;
        }
      case "BatchWriteItem":
        {
          BatchWriteItemRequest transformedRequest = transformer
            .BatchWriteItemInputTransform(
              BatchWriteItemInputTransformInput
                .builder()
                .sdkInput((BatchWriteItemRequest) originalRequest)
                .build()
            )
            .transformedInput();
          outgoingRequest =
            copyOverrideConfig(
              (BatchWriteItemRequest) originalRequest,
              transformedRequest
            );
          break;
        }
      case "DeleteItem":
        {
          DeleteItemRequest transformedRequest = transformer
            .DeleteItemInputTransform(
              DeleteItemInputTransformInput
                .builder()
                .sdkInput((DeleteItemRequest) originalRequest)
                .build()
            )
            .transformedInput();
          outgoingRequest =
            copyOverrideConfig(
              (DeleteItemRequest) originalRequest,
              transformedRequest
            );
          break;
        }
      case "ExecuteStatement":
        {
          ExecuteStatementRequest transformedRequest = transformer
            .ExecuteStatementInputTransform(
              ExecuteStatementInputTransformInput
                .builder()
                .sdkInput((ExecuteStatementRequest) originalRequest)
                .build()
            )
            .transformedInput();
          outgoingRequest =
            copyOverrideConfig(
              (ExecuteStatementRequest) originalRequest,
              transformedRequest
            );
          break;
        }
      case "ExecuteTransaction":
        {
          ExecuteTransactionRequest transformedRequest = transformer
            .ExecuteTransactionInputTransform(
              ExecuteTransactionInputTransformInput
                .builder()
                .sdkInput((ExecuteTransactionRequest) originalRequest)
                .build()
            )
            .transformedInput();
          outgoingRequest =
            copyOverrideConfig(
              (ExecuteTransactionRequest) originalRequest,
              transformedRequest
            );
          break;
        }
      case "GetItem":
        {
          GetItemRequest transformedRequest = transformer
            .GetItemInputTransform(
              GetItemInputTransformInput
                .builder()
                .sdkInput((GetItemRequest) originalRequest)
                .build()
            )
            .transformedInput();
          outgoingRequest =
            copyOverrideConfig(
              (GetItemRequest) originalRequest,
              transformedRequest
            );
          break;
        }
      case "PutItem":
        {
          PutItemRequest transformedRequest = transformer
            .PutItemInputTransform(
              PutItemInputTransformInput
                .builder()
                .sdkInput((PutItemRequest) originalRequest)
                .build()
            )
            .transformedInput();
          outgoingRequest =
            copyOverrideConfig(
              (PutItemRequest) originalRequest,
              transformedRequest
            );
          break;
        }
      case "Query":
        {
          QueryRequest queryRequest = (QueryRequest) originalRequest;
          QueryRequest transformedRequest = transformer
            .QueryInputTransform(
              QueryInputTransformInput.builder().sdkInput(queryRequest).build()
            )
            .transformedInput();

          // Our current Java->Dafny conversion squashes empty maps into the "None" type.
          // In order to avoid gray failures for invalid `exclusiveStartKey`,
          // and because our transforms do not act on or modify this value currently,
          // copy over the original `exclusiveStartKey`
          // so that the server can correctly reject it as invalid if it is empty.
          transformedRequest =
            transformedRequest
              .toBuilder()
              .exclusiveStartKey(queryRequest.exclusiveStartKey())
              .build();

          outgoingRequest =
            copyOverrideConfig(queryRequest, transformedRequest);
          break;
        }
      case "Scan":
        {
          ScanRequest scanRequest = (ScanRequest) originalRequest;
          ScanRequest transformedRequest = transformer
            .ScanInputTransform(
              ScanInputTransformInput.builder().sdkInput(scanRequest).build()
            )
            .transformedInput();

          // Our current Java->Dafny conversion squashes empty maps into the "None" type.
          // In order to avoid gray failures for invalid `exclusiveStartKey`,
          // and because our transforms do not act on or modify this value currently,
          // copy over the original `exclusiveStartKey`
          // so that the server can correctly reject it as invalid if it is empty.
          transformedRequest =
            transformedRequest
              .toBuilder()
              .exclusiveStartKey(scanRequest.exclusiveStartKey())
              .build();

          outgoingRequest = copyOverrideConfig(scanRequest, transformedRequest);
          break;
        }
      case "TransactGetItems":
        {
          TransactGetItemsRequest transformedRequest = transformer
            .TransactGetItemsInputTransform(
              TransactGetItemsInputTransformInput
                .builder()
                .sdkInput((TransactGetItemsRequest) originalRequest)
                .build()
            )
            .transformedInput();
          outgoingRequest =
            copyOverrideConfig(
              (TransactGetItemsRequest) originalRequest,
              transformedRequest
            );
          break;
        }
      case "TransactWriteItems":
        {
          TransactWriteItemsRequest transformedRequest = transformer
            .TransactWriteItemsInputTransform(
              TransactWriteItemsInputTransformInput
                .builder()
                .sdkInput((TransactWriteItemsRequest) originalRequest)
                .build()
            )
            .transformedInput();
          outgoingRequest =
            copyOverrideConfig(
              (TransactWriteItemsRequest) originalRequest,
              transformedRequest
            );
          break;
        }
      case "UpdateItem":
        {
          UpdateItemRequest transformedRequest = transformer
            .UpdateItemInputTransform(
              UpdateItemInputTransformInput
                .builder()
                .sdkInput((UpdateItemRequest) originalRequest)
                .build()
            )
            .transformedInput();
          outgoingRequest =
            copyOverrideConfig(
              (UpdateItemRequest) originalRequest,
              transformedRequest
            );
          break;
        }
      default:
        {
          // Currently we only transform the above hardcoded set of APIs.
          // Passthrough all others.
          outgoingRequest = originalRequest;
          break;
        }
    }
    return outgoingRequest;
  }

  @Override
  public SdkResponse modifyResponse(
    Context.ModifyResponse context,
    ExecutionAttributes executionAttributes
  ) {
    SdkResponse originalResponse = context.response();

    // Only transform DDB requests. Otherwise, throw an error.
    // It should be impossible to encounter this error. Belt and suspenders.
    if (
      !executionAttributes
        .getAttribute(SdkExecutionAttribute.SERVICE_NAME)
        .equals(DDB_NAME)
    ) {
      throw DynamoDbEncryptionTransformsException
        .builder()
        .message(
          "DynamoDbEncryptionInterceptor does not support use with services other than DynamoDb."
        )
        .build();
    }
    // Throw an error if this is not a Sync client.
    // It should be impossible to encounter this error. Belt and suspenders.
    if (
      !executionAttributes
        .getAttribute(SdkExecutionAttribute.CLIENT_TYPE)
        .equals(ClientType.SYNC)
    ) {
      throw DynamoDbEncryptionTransformsException
        .builder()
        .message(
          "DynamoDbEncryptionInterceptor does not support use with the Async client."
        )
        .build();
    }

    SdkRequest originalRequest = executionAttributes.getAttribute(
      ORIGINAL_REQUEST
    );

    String operationName = executionAttributes.getAttribute(
      SdkExecutionAttribute.OPERATION_NAME
    );
    // Ensure we are dealing with a known operation. Otherwise, throw an error.
    // It should be impossible to encounter this error. Belt and suspenders.
    checkSupportedOperation(operationName);

    SdkResponse outgoingResponse;
    switch (operationName) {
      case "BatchExecuteStatement":
        {
          BatchExecuteStatementResponse transformedResponse = transformer
            .BatchExecuteStatementOutputTransform(
              BatchExecuteStatementOutputTransformInput
                .builder()
                .sdkOutput((BatchExecuteStatementResponse) originalResponse)
                .originalInput((BatchExecuteStatementRequest) originalRequest)
                .build()
            )
            .transformedOutput();
          outgoingResponse =
            transformedResponse
              .toBuilder()
              .responseMetadata(
                ((BatchExecuteStatementResponse) originalResponse).responseMetadata()
              )
              .sdkHttpResponse(originalResponse.sdkHttpResponse())
              .build();
          break;
        }
      case "BatchGetItem":
        {
          BatchGetItemResponse transformedResponse = transformer
            .BatchGetItemOutputTransform(
              BatchGetItemOutputTransformInput
                .builder()
                .sdkOutput((BatchGetItemResponse) originalResponse)
                .originalInput((BatchGetItemRequest) originalRequest)
                .build()
            )
            .transformedOutput();
          outgoingResponse =
            transformedResponse
              .toBuilder()
              .responseMetadata(
                ((BatchGetItemResponse) originalResponse).responseMetadata()
              )
              .sdkHttpResponse(originalResponse.sdkHttpResponse())
              .build();
          break;
        }
      case "BatchWriteItem":
        {
          BatchWriteItemResponse transformedResponse = transformer
            .BatchWriteItemOutputTransform(
              BatchWriteItemOutputTransformInput
                .builder()
                .sdkOutput((BatchWriteItemResponse) originalResponse)
                .originalInput((BatchWriteItemRequest) originalRequest)
                .build()
            )
            .transformedOutput();
          outgoingResponse =
            transformedResponse
              .toBuilder()
              .responseMetadata(
                ((BatchWriteItemResponse) originalResponse).responseMetadata()
              )
              .sdkHttpResponse(originalResponse.sdkHttpResponse())
              .build();
          break;
        }
      case "DeleteItem":
        {
          DeleteItemResponse transformedResponse = transformer
            .DeleteItemOutputTransform(
              DeleteItemOutputTransformInput
                .builder()
                .sdkOutput((DeleteItemResponse) originalResponse)
                .originalInput((DeleteItemRequest) originalRequest)
                .build()
            )
            .transformedOutput();
          outgoingResponse =
            transformedResponse
              .toBuilder()
              .responseMetadata(
                ((DeleteItemResponse) originalResponse).responseMetadata()
              )
              .sdkHttpResponse(originalResponse.sdkHttpResponse())
              .build();
          break;
        }
      case "ExecuteStatement":
        {
          ExecuteStatementResponse transformedResponse = transformer
            .ExecuteStatementOutputTransform(
              ExecuteStatementOutputTransformInput
                .builder()
                .sdkOutput((ExecuteStatementResponse) originalResponse)
                .originalInput((ExecuteStatementRequest) originalRequest)
                .build()
            )
            .transformedOutput();
          outgoingResponse =
            transformedResponse
              .toBuilder()
              .responseMetadata(
                ((ExecuteStatementResponse) originalResponse).responseMetadata()
              )
              .sdkHttpResponse(originalResponse.sdkHttpResponse())
              .build();
          break;
        }
      case "ExecuteTransaction":
        {
          ExecuteTransactionResponse transformedResponse = transformer
            .ExecuteTransactionOutputTransform(
              ExecuteTransactionOutputTransformInput
                .builder()
                .sdkOutput((ExecuteTransactionResponse) originalResponse)
                .originalInput((ExecuteTransactionRequest) originalRequest)
                .build()
            )
            .transformedOutput();
          outgoingResponse =
            transformedResponse
              .toBuilder()
              .responseMetadata(
                ((ExecuteTransactionResponse) originalResponse).responseMetadata()
              )
              .sdkHttpResponse(originalResponse.sdkHttpResponse())
              .build();
          break;
        }
      case "GetItem":
        {
          GetItemResponse transformedResponse = transformer
            .GetItemOutputTransform(
              GetItemOutputTransformInput
                .builder()
                .sdkOutput((GetItemResponse) originalResponse)
                .originalInput((GetItemRequest) originalRequest)
                .build()
            )
            .transformedOutput();
          outgoingResponse =
            transformedResponse
              .toBuilder()
              .responseMetadata(
                ((GetItemResponse) originalResponse).responseMetadata()
              )
              .sdkHttpResponse(originalResponse.sdkHttpResponse())
              .build();
          break;
        }
      case "PutItem":
        {
          PutItemResponse transformedResponse = transformer
            .PutItemOutputTransform(
              PutItemOutputTransformInput
                .builder()
                .sdkOutput((PutItemResponse) originalResponse)
                .originalInput((PutItemRequest) originalRequest)
                .build()
            )
            .transformedOutput();
          outgoingResponse =
            transformedResponse
              .toBuilder()
              .responseMetadata(
                ((PutItemResponse) originalResponse).responseMetadata()
              )
              .sdkHttpResponse(originalResponse.sdkHttpResponse())
              .build();
          break;
        }
      case "Query":
        {
          QueryResponse transformedResponse = transformer
            .QueryOutputTransform(
              QueryOutputTransformInput
                .builder()
                .sdkOutput((QueryResponse) originalResponse)
                .originalInput((QueryRequest) originalRequest)
                .build()
            )
            .transformedOutput();
          outgoingResponse =
            transformedResponse
              .toBuilder()
              .responseMetadata(
                ((QueryResponse) originalResponse).responseMetadata()
              )
              .sdkHttpResponse(originalResponse.sdkHttpResponse())
              .build();
          break;
        }
      case "Scan":
        {
          ScanResponse transformedResponse = transformer
            .ScanOutputTransform(
              ScanOutputTransformInput
                .builder()
                .sdkOutput((ScanResponse) originalResponse)
                .originalInput((ScanRequest) originalRequest)
                .build()
            )
            .transformedOutput();
          outgoingResponse =
            transformedResponse
              .toBuilder()
              .responseMetadata(
                ((ScanResponse) originalResponse).responseMetadata()
              )
              .sdkHttpResponse(originalResponse.sdkHttpResponse())
              .build();
          break;
        }
      case "TransactGetItems":
        {
          TransactGetItemsResponse transformedResponse = transformer
            .TransactGetItemsOutputTransform(
              TransactGetItemsOutputTransformInput
                .builder()
                .sdkOutput((TransactGetItemsResponse) originalResponse)
                .originalInput((TransactGetItemsRequest) originalRequest)
                .build()
            )
            .transformedOutput();
          outgoingResponse =
            transformedResponse
              .toBuilder()
              .responseMetadata(
                ((TransactGetItemsResponse) originalResponse).responseMetadata()
              )
              .sdkHttpResponse(originalResponse.sdkHttpResponse())
              .build();
          break;
        }
      case "TransactWriteItems":
        {
          TransactWriteItemsResponse transformedResponse = transformer
            .TransactWriteItemsOutputTransform(
              TransactWriteItemsOutputTransformInput
                .builder()
                .sdkOutput((TransactWriteItemsResponse) originalResponse)
                .originalInput((TransactWriteItemsRequest) originalRequest)
                .build()
            )
            .transformedOutput();
          outgoingResponse =
            transformedResponse
              .toBuilder()
              .responseMetadata(
                ((TransactWriteItemsResponse) originalResponse).responseMetadata()
              )
              .sdkHttpResponse(originalResponse.sdkHttpResponse())
              .build();
          break;
        }
      case "UpdateItem":
        {
          UpdateItemResponse transformedResponse = transformer
            .UpdateItemOutputTransform(
              UpdateItemOutputTransformInput
                .builder()
                .sdkOutput((UpdateItemResponse) originalResponse)
                .originalInput((UpdateItemRequest) originalRequest)
                .build()
            )
            .transformedOutput();
          outgoingResponse =
            transformedResponse
              .toBuilder()
              .responseMetadata(
                ((UpdateItemResponse) originalResponse).responseMetadata()
              )
              .sdkHttpResponse(originalResponse.sdkHttpResponse())
              .build();
          break;
        }
      default:
        {
          // Currently we only transform the above hardcoded set of APIs.
          // Passthrough all others.
          outgoingResponse = originalResponse;
          break;
        }
    }
    return outgoingResponse;
  }

  private void checkSupportedOperation(String operationName) {
    if (!SUPPORTED_OPERATION_NAMES.contains(operationName)) {
      throw DynamoDbEncryptionTransformsException
        .builder()
        .message(
          String.format(
            "DynamoDbEncryptionInterceptor does not support use with unrecognized operation: %s",
            operationName
          )
        )
        .build();
    }
  }

  // We currently assume that the OverrideConfig is the only non-smithy modelled information that we need to preserve
  private AwsRequest copyOverrideConfig(
    AwsRequest original,
    AwsRequest transformed
  ) {
    Optional<AwsRequestOverrideConfiguration> config =
      original.overrideConfiguration();
    if (!config.isPresent()) {
      // If there is no config to copy over, this is a no-op
      return transformed;
    }
    return transformed.toBuilder().overrideConfiguration(config.get()).build();
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public interface Builder {
    Builder config(DynamoDbTablesEncryptionConfig config);
    DynamoDbTablesEncryptionConfig config();
    DynamoDbEncryptionInterceptor build();
  }

  static class BuilderImpl implements Builder {

    protected DynamoDbTablesEncryptionConfig config;

    protected BuilderImpl() {}

    protected BuilderImpl(DynamoDbEncryptionInterceptor model) {
      this.config = model.config();
    }

    public Builder config(DynamoDbTablesEncryptionConfig config) {
      this.config = config;
      return this;
    }

    public DynamoDbTablesEncryptionConfig config() {
      return this.config;
    }

    public DynamoDbEncryptionInterceptor build() {
      if (Objects.isNull(this.config())) {
        throw DynamoDbEncryptionTransformsException
          .builder()
          .message("Missing value for required field `config`")
          .build();
      }
      return new DynamoDbEncryptionInterceptor(this);
    }
  }
}
