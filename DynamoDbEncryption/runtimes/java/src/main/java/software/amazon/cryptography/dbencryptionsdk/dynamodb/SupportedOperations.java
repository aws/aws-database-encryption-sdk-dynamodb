package software.amazon.cryptography.dbencryptionsdk.dynamodb;

import java.util.Arrays;
import java.util.List;

// In order to ensure the Encryption Interceptor remains "hard to misuse",
// we must always fail in the case that we encounter an operation we don't
// recognize, which means keeping track of which operations we do support use with.
// Otherwise, it may be possible in the future for a new DDB
// operation to have surprising behavior when used with the interceptor.
public class SupportedOperations {

  public static List<String> SUPPORTED_OPERATION_NAMES = Arrays.asList(
    "BatchExecuteStatement",
    "BatchGetItem",
    "BatchWriteItem",
    "CreateBackup",
    "CreateGlobalTable",
    "CreateTable",
    "DeleteBackup",
    "DeleteItem",
    "DeleteTable",
    "DescribeBackup",
    "DescribeContinuousBackups",
    "DescribeContributorInsights",
    "DescribeEndpoints",
    "DescribeExport",
    "DescribeGlobalTable",
    "DescribeGlobalTableSettings",
    "DescribeImport",
    "DescribeKinesisStreamingDestination",
    "DescribeLimits",
    "DescribeTable",
    "DescribeTableReplicaAutoScaling",
    "DescribeTimeToLive",
    "DisableKinesisStreamingDestination",
    "EnableKinesisStreamingDestination",
    "ExecuteStatement",
    "ExportTableToPointInTime",
    "ExecuteTransaction",
    "GetItem",
    "ImportTable",
    "ListBackups",
    "ListContributorInsights",
    "ListExports",
    "ListGlobalTables",
    "ListImports",
    "ListTables",
    "ListTagsOfResource",
    "PutItem",
    "Query",
    "RestoreTableFromBackup",
    "RestoreTableToPointInTime",
    "Scan",
    "TagResource",
    "TransactGetItems",
    "TransactWriteItems",
    "UntagResource",
    "UpdateContinuousBackups",
    "UpdateContributorInsights",
    "UpdateGlobalTable",
    "UpdateGlobalTableSettings",
    "UpdateItem",
    "UpdateTable",
    "UpdateTableReplicaAutoScaling",
    "UpdateTimeToLive"
  );
}
