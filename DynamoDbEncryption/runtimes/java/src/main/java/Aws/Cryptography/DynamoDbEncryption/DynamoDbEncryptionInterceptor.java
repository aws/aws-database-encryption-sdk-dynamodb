package software.amazon.awssdk.core.internal.http.request;

import software.amazon.awssdk.core.interceptor.Context;
import software.amazon.awssdk.core.interceptor.ExecutionAttributes;
import software.amazon.awssdk.core.interceptor.ExecutionInterceptor;

/**
 * Implementation of {@link ExecutionInterceptor} with configurable wait times
 */
public class DynamoDbEncryptionInterceptor implements ExecutionInterceptor {
    @Override
    public SdkRequest modifyRequest(Context.ModifyRequest context, ExecutionAttributes executionAttributes) {
        // foo
        SdkRequest originalRequest = context.request;
        SdkRequest transformedRequest;
        if (context.request() instanceof BatchExecuteStatementRequest) {

        } else if (context.request() instanceof BatchGetItemRequest) {

        } else if (context.request() instanceof BatchWriteItemRequest) {

        } else if (context.request() instanceof CreateBackupRequest) {

        } else if (context.request() instanceof CreateGlobalTableRequest) {

        } else if (context.request() instanceof CreateTableRequest) {

        } else if (context.request() instanceof DeleteBackupRequest) {

        } else if (context.request() instanceof DeleteItemRequest) {

        } else if (context.request() instanceof DeleteTableRequest) {

        } else if (context.request() instanceof DescribeBackupRequest) {

        } else if (context.request() instanceof DescribeContinuousBackupsRequest) {

        } else if (context.request() instanceof DescribeContributorInsightsRequest) {

        } else if (context.request() instanceof DescribeEndpointsRequest) {

        } else if (context.request() instanceof DescribeExportRequest) {

        } else if (context.request() instanceof DescribeGlobalTableRequest) {

        } else if (context.request() instanceof DescribeGlobalTableSettingsRequest) {

        } else if (context.request() instanceof DescribeImportRequest) {

        } else if (context.request() instanceof DescribeKinesisStreamingDestinationRequest) {

        } else if (context.request() instanceof DescribeLimitsRequest) {

        } else if (context.request() instanceof DescribeTableRequest) {

        } else if (context.request() instanceof DescribeTableReplicaAutoScalingRequest) {

        } else if (context.request() instanceof DescribeTimeToLiveRequest) {

        } else if (context.request() instanceof DisableKinesisStreamingDestinationRequest) {

        } else if (context.request() instanceof EnableKinesisStreamingDestinationRequest) {

        } else if (context.request() instanceof ExecuteStatementRequest) {

        } else if (context.request() instanceof ExecuteTransactionRequest) {

        } else if (context.request() instanceof ExportTableToPointInTimeRequest) {

        } else if (context.request() instanceof GetItemRequest) {

        } else if (context.request() instanceof ImportTableRequest) {

        } else if (context.request() instanceof ListBackupsRequest) {

        } else if (context.request() instanceof ListContributorInsightsRequest) {

        } else if (context.request() instanceof ListExportsRequest) {

        } else if (context.request() instanceof ListGlobalTablesRequest) {

        } else if (context.request() instanceof ListImportsRequest) {

        } else if (context.request() instanceof ListTablesRequest) {

        } else if (context.request() instanceof ListTagsOfResourceRequest) {

        } else if (context.request() instanceof PutItemRequest) {

        } else if (context.request() instanceof QueryRequest) {

        } else if (context.request() instanceof RestoreTableFromBackupRequest) {

        } else if (context.request() instanceof RestoreTableToPointInTimeRequest) {

        } else if (context.request() instanceof ScanRequest) {

        } else if (context.request() instanceof TagResourceRequest) {

        } else if (context.request() instanceof TransactGetItemRequest) {

        } else if (context.request() instanceof TransactWriteItemsRequest) {

        } else if (context.request() instanceof UntagResourceRequest) {

        } else if (context.request() instanceof UpdateContinuousBackupsRequest) {

        } else if (context.request() instanceof UpdateContributorInsightsRequest) {

        } else if (context.request() instanceof UpdateGlobalTableRequest) {

        } else if (context.request() instanceof UpdateGlobalTableSettingsRequest) {

        } else if (context.request() instanceof UpdateItemRequest) {

        } else if (context.request() instanceof UpdateTableRequest) {

        } else if (context.request() instanceof UpdateTableReplicaAutoScalingRequest) {

        } else if (context.request() instanceof UpdateTimeToLiveRequest) {

        } else {
            // don't support
        }
    }

    @Override
    public SdkResponse modifyResponse(Context.ModifyResponse context, ExecutionAttributes executionAttributes) {
        // foo
    }
}
