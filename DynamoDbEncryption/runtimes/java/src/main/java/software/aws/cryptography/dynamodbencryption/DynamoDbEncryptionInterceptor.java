package software.aws.cryptography.dynamodbencryption;

import software.amazon.awssdk.awscore.AwsRequest;
import software.amazon.awssdk.awscore.AwsRequestOverrideConfiguration;
import software.amazon.awssdk.core.interceptor.*;
import software.amazon.awssdk.core.SdkRequest;
import software.amazon.awssdk.core.SdkResponse;

import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.model.*;

import software.amazon.awssdk.services.dynamodb.model.UpdateItemResponse;
import software.amazon.awssdk.services.dynamodb.model.TransactWriteItemsResponse;
import software.amazon.awssdk.services.dynamodb.model.TransactGetItemsResponse;
import software.amazon.awssdk.services.dynamodb.model.ScanResponse;
import software.amazon.awssdk.services.dynamodb.model.QueryResponse;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;
import software.amazon.awssdk.services.dynamodb.model.ExecuteTransactionResponse;
import software.amazon.awssdk.services.dynamodb.model.ExecuteStatementResponse;
import software.amazon.awssdk.services.dynamodb.model.BatchWriteItemResponse;
import software.amazon.awssdk.services.dynamodb.model.BatchGetItemResponse;
import software.amazon.awssdk.services.dynamodb.model.BatchExecuteStatementResponse;
import software.amazon.awssdk.services.dynamodb.model.UpdateItemRequest;
import software.amazon.awssdk.services.dynamodb.model.TransactWriteItemsRequest;
import software.amazon.awssdk.services.dynamodb.model.TransactGetItemsRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.QueryRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.ExecuteTransactionRequest;
import software.amazon.awssdk.services.dynamodb.model.ExecuteStatementRequest;
import software.amazon.awssdk.services.dynamodb.model.BatchWriteItemRequest;
import software.amazon.awssdk.services.dynamodb.model.BatchGetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.BatchExecuteStatementRequest;

import software.amazon.cryptography.dynamoDbEncryptionMiddleware.internal.DynamoDbEncryptionMiddlewareInternal;

import java.util.Objects;
import java.util.Optional;

import static software.aws.cryptography.dynamodbencryption.DynamoDbEncryptionExecutionAttribute.ORIGINAL_REQUEST;
import static software.aws.cryptography.dynamodbencryption.SupportedOperations.SUPPORTED_OPERATION_NAMES;

/**
 * Implementation of {@link ExecutionInterceptor} with configurable wait times
 */
public class DynamoDbEncryptionInterceptor implements ExecutionInterceptor {

    private final DynamoDbEncryptionMiddlewareInternalConfig config;
    private DynamoDbEncryptionMiddlewareInternal transformer;

    // TODO find where in sdk we can pull this string from
    static final String DDB_NAME = "DynamoDb";

    protected DynamoDbEncryptionInterceptor(BuilderImpl builder) {
        this.config = builder.config();
        this.transformer = DynamoDbEncryptionMiddlewareInternal.builder()
                .DynamoDbEncryptionMiddlewareInternalConfig(config)
                .build();
    }

    public DynamoDbEncryptionMiddlewareInternalConfig config() {
        return this.config;
    }

    @Override
    public SdkRequest modifyRequest(Context.ModifyRequest context, ExecutionAttributes executionAttributes) {
        SdkRequest originalRequest = context.request();

        // Only transform DDB requests. Otherwise, throw an error.
        if (!executionAttributes.getAttribute(SdkExecutionAttribute.SERVICE_NAME).equals(DDB_NAME)) {
            throw new IllegalStateException("DynamoDbEncryptionInterceptor does not support use with services other than DynamoDb.");
        }

        // Store original request so it can be used when intercepting the response
        executionAttributes.putAttribute(ORIGINAL_REQUEST, originalRequest);

        String operationName = executionAttributes.getAttribute(SdkExecutionAttribute.OPERATION_NAME);
        checkSupportedOperation(operationName);

        SdkRequest outgoingRequest;
        switch(operationName) {
            case "BatchExecuteStatement": {
                BatchExecuteStatementRequest transformedRequest = transformer.BatchExecuteStatementInputTransform(
                        BatchExecuteStatementInputTransformInput.builder()
                                .sdkInput((BatchExecuteStatementRequest) originalRequest)
                                .build()).transformedInput();
                outgoingRequest = copyOverrideConfig((BatchExecuteStatementRequest) originalRequest, transformedRequest);
                break;
            } case "BatchGetItem": {
                BatchGetItemRequest transformedRequest = transformer.BatchGetItemInputTransform(
                        BatchGetItemInputTransformInput.builder()
                                .sdkInput((BatchGetItemRequest) originalRequest)
                                .build()).transformedInput();
                outgoingRequest = copyOverrideConfig((BatchGetItemRequest) originalRequest, transformedRequest);
                break;
            } case "BatchWriteItem": {
                BatchWriteItemRequest transformedRequest = transformer.BatchWriteItemInputTransform(
                        BatchWriteItemInputTransformInput.builder()
                                .sdkInput((BatchWriteItemRequest) originalRequest)
                                .build()).transformedInput();
                outgoingRequest = copyOverrideConfig((BatchWriteItemRequest) originalRequest, transformedRequest);
                break;
            } case "ExecuteStatement": {
                ExecuteStatementRequest transformedRequest = transformer.ExecuteStatementInputTransform(
                        ExecuteStatementInputTransformInput.builder()
                                .sdkInput((ExecuteStatementRequest) originalRequest)
                                .build()).transformedInput();
                outgoingRequest = copyOverrideConfig((ExecuteStatementRequest) originalRequest, transformedRequest);
                break;
            } case "ExecuteTransaction": {
                ExecuteTransactionRequest transformedRequest = transformer.ExecuteTransactionInputTransform(
                        ExecuteTransactionInputTransformInput.builder()
                                .sdkInput((ExecuteTransactionRequest) originalRequest)
                                .build()).transformedInput();
                outgoingRequest = copyOverrideConfig((ExecuteTransactionRequest) originalRequest, transformedRequest);
                break;
            } case "GetItem": {
                GetItemRequest transformedRequest = transformer.GetItemInputTransform(
                        GetItemInputTransformInput.builder()
                                .sdkInput((GetItemRequest) originalRequest)
                                .build()).transformedInput();
                outgoingRequest = copyOverrideConfig((GetItemRequest) originalRequest, transformedRequest);
                break;
            } case "PutItem": {
                PutItemRequest transformedRequest = transformer.PutItemInputTransform(
                        PutItemInputTransformInput.builder()
                                .sdkInput((PutItemRequest) originalRequest)
                                .build()).transformedInput();
                outgoingRequest = copyOverrideConfig((PutItemRequest) originalRequest, transformedRequest);
                break;
            } case "Query": {
                QueryRequest transformedRequest = transformer.QueryInputTransform(
                        QueryInputTransformInput.builder()
                                .sdkInput((QueryRequest) originalRequest)
                                .build()).transformedInput();
                outgoingRequest = copyOverrideConfig((QueryRequest) originalRequest, transformedRequest);
                break;
            } case "Scan": {
                ScanRequest transformedRequest = transformer.ScanInputTransform(
                        ScanInputTransformInput.builder()
                                .sdkInput((ScanRequest) originalRequest)
                                .build()).transformedInput();
                outgoingRequest = copyOverrideConfig((ScanRequest) originalRequest, transformedRequest);
                break;
            } case "TransactGetItems": {
                TransactGetItemsRequest transformedRequest = transformer.TransactGetItemsInputTransform(
                        TransactGetItemsInputTransformInput.builder()
                                .sdkInput((TransactGetItemsRequest) originalRequest)
                                .build()).transformedInput();
                outgoingRequest = copyOverrideConfig((TransactGetItemsRequest) originalRequest, transformedRequest);
                break;
            } case "TransactWriteItems": {
                TransactWriteItemsRequest transformedRequest = transformer.TransactWriteItemsInputTransform(
                        TransactWriteItemsInputTransformInput.builder()
                                .sdkInput((TransactWriteItemsRequest) originalRequest)
                                .build()).transformedInput();
                outgoingRequest = copyOverrideConfig((TransactWriteItemsRequest) originalRequest, transformedRequest);
                break;
            } case "UpdateItem": {
                UpdateItemRequest transformedRequest = transformer.UpdateItemInputTransform(
                        UpdateItemInputTransformInput.builder()
                                .sdkInput((UpdateItemRequest) originalRequest)
                                .build()).transformedInput();
                outgoingRequest = copyOverrideConfig((UpdateItemRequest) originalRequest, transformedRequest);
                break;
            } default: {
                // passthrough
                outgoingRequest = originalRequest;
                break;
            }
        }
        return outgoingRequest;
    }

    @Override
    public SdkResponse modifyResponse(Context.ModifyResponse context, ExecutionAttributes executionAttributes) {
        SdkResponse originalResponse = context.response();

        // Only transform DDB requests. Otherwise, throw an error.
        if (!executionAttributes.getAttribute(SdkExecutionAttribute.SERVICE_NAME).equals(DDB_NAME)) {
            throw new IllegalStateException("DynamoDbEncryptionInterceptor does not support use with services other than DynamoDb.");
        }

        SdkRequest originalRequest = executionAttributes.getAttribute(ORIGINAL_REQUEST);
        String operationName = executionAttributes.getAttribute(SdkExecutionAttribute.OPERATION_NAME);
        checkSupportedOperation(operationName);

        SdkResponse outgoingResponse;
        switch(operationName) {
            case "BatchExecuteStatement": {
                BatchExecuteStatementResponse transformedResponse = transformer.BatchExecuteStatementOutputTransform(
                        BatchExecuteStatementOutputTransformInput.builder()
                                .sdkOutput((BatchExecuteStatementResponse) originalResponse)
                                .originalInput((BatchExecuteStatementRequest) originalRequest)
                                .build()).transformedOutput();
                outgoingResponse = transformedResponse.toBuilder()
                        .responseMetadata(((BatchExecuteStatementResponse) originalResponse).responseMetadata())
                        .sdkHttpResponse(originalResponse.sdkHttpResponse())
                        .build();
                break;
            } case "BatchGetItem": {
                BatchGetItemResponse transformedResponse = transformer.BatchGetItemOutputTransform(
                        BatchGetItemOutputTransformInput.builder()
                                .sdkOutput((BatchGetItemResponse) originalResponse)
                                .originalInput((BatchGetItemRequest) originalRequest)
                                .build()).transformedOutput();
                outgoingResponse = transformedResponse.toBuilder()
                        .responseMetadata(((BatchGetItemResponse) originalResponse).responseMetadata())
                        .sdkHttpResponse(originalResponse.sdkHttpResponse())
                        .build();
                break;
            } case "BatchWriteItem": {
                BatchWriteItemResponse transformedResponse = transformer.BatchWriteItemOutputTransform(
                        BatchWriteItemOutputTransformInput.builder()
                                .sdkOutput((BatchWriteItemResponse) originalResponse)
                                .originalInput((BatchWriteItemRequest) originalRequest)
                                .build()).transformedOutput();
                outgoingResponse = transformedResponse.toBuilder()
                        .responseMetadata(((BatchWriteItemResponse) originalResponse).responseMetadata())
                        .sdkHttpResponse(originalResponse.sdkHttpResponse())
                        .build();
                break;
            } case "ExecuteStatement": {
                ExecuteStatementResponse transformedResponse = transformer.ExecuteStatementOutputTransform(
                        ExecuteStatementOutputTransformInput.builder()
                                .sdkOutput((ExecuteStatementResponse) originalResponse)
                                .originalInput((ExecuteStatementRequest) originalRequest)
                                .build()).transformedOutput();
                outgoingResponse = transformedResponse.toBuilder()
                        .responseMetadata(((ExecuteStatementResponse) originalResponse).responseMetadata())
                        .sdkHttpResponse(originalResponse.sdkHttpResponse())
                        .build();
                break;
            } case "ExecuteTransaction": {
                ExecuteTransactionResponse transformedResponse = transformer.ExecuteTransactionOutputTransform(
                        ExecuteTransactionOutputTransformInput.builder()
                                .sdkOutput((ExecuteTransactionResponse) originalResponse)
                                .originalInput((ExecuteTransactionRequest) originalRequest)
                                .build()).transformedOutput();
                outgoingResponse = transformedResponse.toBuilder()
                        .responseMetadata(((ExecuteTransactionResponse) originalResponse).responseMetadata())
                        .sdkHttpResponse(originalResponse.sdkHttpResponse())
                        .build();
                break;
            } case "GetItem": {
                GetItemResponse transformedResponse = transformer.GetItemOutputTransform(
                        GetItemOutputTransformInput.builder()
                                .sdkOutput((GetItemResponse) originalResponse)
                                .originalInput((GetItemRequest) originalRequest)
                                .build()).transformedOutput();
                outgoingResponse = transformedResponse.toBuilder()
                        .responseMetadata(((GetItemResponse) originalResponse).responseMetadata())
                        .sdkHttpResponse(originalResponse.sdkHttpResponse())
                        .build();
                break;
            } case "PutItem": {
                PutItemResponse transformedResponse = transformer.PutItemOutputTransform(
                        PutItemOutputTransformInput.builder()
                                .sdkOutput((PutItemResponse) originalResponse)
                                .originalInput((PutItemRequest) originalRequest)
                                .build()).transformedOutput();
                outgoingResponse = transformedResponse.toBuilder()
                        .responseMetadata(((PutItemResponse) originalResponse).responseMetadata())
                        .sdkHttpResponse(originalResponse.sdkHttpResponse())
                        .build();
                break;
            } case "Query": {
                QueryResponse transformedResponse = transformer.QueryOutputTransform(
                        QueryOutputTransformInput.builder()
                                .sdkOutput((QueryResponse) originalResponse)
                                .originalInput((QueryRequest) originalRequest)
                                .build()).transformedOutput();
                outgoingResponse = transformedResponse.toBuilder()
                        .responseMetadata(((QueryResponse) originalResponse).responseMetadata())
                        .sdkHttpResponse(originalResponse.sdkHttpResponse())
                        .build();
                break;
            } case "Scan": {
                ScanResponse transformedResponse = transformer.ScanOutputTransform(
                        ScanOutputTransformInput.builder()
                                .sdkOutput((ScanResponse) originalResponse)
                                .originalInput((ScanRequest) originalRequest)
                                .build()).transformedOutput();
                outgoingResponse = transformedResponse.toBuilder()
                        .responseMetadata(((ScanResponse) originalResponse).responseMetadata())
                        .sdkHttpResponse(originalResponse.sdkHttpResponse())
                        .build();
                break;
            } case "TransactGetItems": {
                TransactGetItemsResponse transformedResponse = transformer.TransactGetItemsOutputTransform(
                        TransactGetItemsOutputTransformInput.builder()
                                .sdkOutput((TransactGetItemsResponse) originalResponse)
                                .originalInput((TransactGetItemsRequest) originalRequest)
                                .build()).transformedOutput();
                outgoingResponse = transformedResponse.toBuilder()
                        .responseMetadata(((TransactGetItemsResponse) originalResponse).responseMetadata())
                        .sdkHttpResponse(originalResponse.sdkHttpResponse())
                        .build();
                break;
            } case "TransactWriteItems": {
                TransactWriteItemsResponse transformedResponse = transformer.TransactWriteItemsOutputTransform(
                        TransactWriteItemsOutputTransformInput.builder()
                                .sdkOutput((TransactWriteItemsResponse) originalResponse)
                                .originalInput((TransactWriteItemsRequest) originalRequest)
                                .build()).transformedOutput();
                outgoingResponse = transformedResponse.toBuilder()
                        .responseMetadata(((TransactWriteItemsResponse) originalResponse).responseMetadata())
                        .sdkHttpResponse(originalResponse.sdkHttpResponse())
                        .build();
                break;
            } case "UpdateItem": {
                UpdateItemResponse transformedResponse = transformer.UpdateItemOutputTransform(
                        UpdateItemOutputTransformInput.builder()
                                .sdkOutput((UpdateItemResponse) originalResponse)
                                .originalInput((UpdateItemRequest) originalRequest)
                                .build()).transformedOutput();
                outgoingResponse = transformedResponse.toBuilder()
                        .responseMetadata(((UpdateItemResponse) originalResponse).responseMetadata())
                        .sdkHttpResponse(originalResponse.sdkHttpResponse())
                        .build();
                break;
            } default: {
                // Passthrough
                outgoingResponse = originalResponse;
                break;
            }
        }
        return outgoingResponse;
    }

    private void checkSupportedOperation(String operationName) {
        if (!SUPPORTED_OPERATION_NAMES.contains(operationName)) {
            throw new IllegalStateException(
                    String.format("DynamoDbEncryptionInterceptor does not support use with unrecognized operation: %s",
                            operationName));
        }
    }

    private AwsRequest copyOverrideConfig(AwsRequest original, AwsRequest transformed) {
        Optional<AwsRequestOverrideConfiguration> config = original.overrideConfiguration();
        if (!config.isPresent()) {
            // If there is no config to copy over, this is a no-op
            return transformed;
        }
        return transformed.toBuilder()
                .overrideConfiguration(config.get())
                .build();
    }

    public Builder toBuilder() {
        return new BuilderImpl(this);
    }

    public static Builder builder() {
        return new BuilderImpl();
    }

    public interface Builder {
        Builder config(DynamoDbEncryptionMiddlewareInternalConfig config);
        DynamoDbEncryptionMiddlewareInternalConfig config();
        DynamoDbEncryptionInterceptor build();
    }

    static class BuilderImpl implements Builder {
        protected DynamoDbEncryptionMiddlewareInternalConfig config;

        protected BuilderImpl() {
        }

        protected BuilderImpl(DynamoDbEncryptionInterceptor model) {
            this.config = model.config();
        }

        public Builder config(DynamoDbEncryptionMiddlewareInternalConfig config) {
            this.config = config;
            return this;
        }

        public DynamoDbEncryptionMiddlewareInternalConfig config() {
            return this.config;
        }

        public DynamoDbEncryptionInterceptor build() {
            if (Objects.isNull(this.config())) {
                throw new IllegalArgumentException("Missing value for required field `config`");
            }
            return new DynamoDbEncryptionInterceptor(this);
        }
    }
}
