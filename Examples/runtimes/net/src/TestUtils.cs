using System;
using System.Linq;
using System.Collections.Generic;
using Amazon.DynamoDBv2.Model;

public class TestUtils
{
    public static readonly string TEST_KEYSTORE_NAME = "KeyStoreDdbTable";
    public static readonly string TEST_LOGICAL_KEYSTORE_NAME = "KeyStoreDdbTable";

    public static readonly string TEST_PARTITION_ID = "91c1b6a2-6fc3-4539-ad5e-938d597ed730";

    public static readonly string TEST_KEYSTORE_KMS_KEY_ID =
        "arn:aws:kms:us-west-2:370957321024:key/9d989aa2-2f9c-438c-a745-cc57d3ad0126";

    public static readonly string TEST_AWS_ACCOUNT_ID = "658956600833";

    public static readonly string TEST_AWS_REGION = "us-west-2";

    // These are public KMS Keys that MUST only be used for testing, and MUST NOT be used for any production data
    public static readonly string TEST_KMS_KEY_ID =
        "arn:aws:kms:us-west-2:658956600833:key/b3537ef1-d8dc-4780-9f5a-55776cbb2f7f";

    public static readonly string TEST_MRK_KEY_ID =
        "arn:aws:kms:us-west-2:658956600833:key/mrk-80bd8ecdcd4342aebd84b7dc9da498a7";

    public static readonly string TEST_KMS_RSA_KEY_ID =
        "arn:aws:kms:us-west-2:658956600833:key/8b432da4-dde4-4bc3-a794-c7d68cbab5a6";

    public static readonly string TEST_KMS_ECDH_KEY_ID_P256_SENDER =
        "arn:aws:kms:us-west-2:370957321024:key/eabdf483-6be2-4d2d-8ee4-8c2583d416e9";

    public static readonly string TEST_KMS_ECDH_KEY_ID_P256_RECIPIENT =
        "arn:aws:kms:us-west-2:370957321024:key/0265c8e9-5b6a-4055-8f70-63719e09fda5";

    public static readonly string TEST_MRK_REPLICA_KEY_ID_US_EAST_1 =
        "arn:aws:kms:us-east-1:658956600833:key/mrk-80bd8ecdcd4342aebd84b7dc9da498a7";

    public static readonly string TEST_MRK_REPLICA_KEY_ID_EU_WEST_1 =
        "arn:aws:kms:eu-west-1:658956600833:key/mrk-80bd8ecdcd4342aebd84b7dc9da498a7";

    // Our tests require access to DDB Table with this name
    public static readonly string TEST_DDB_TABLE_NAME = "DynamoDbEncryptionInterceptorTestTableCS";
    public static string TEST_COMPLEX_TABLE_NAME = "ComplexBeaconTestTableCS";

    // Our tests require access to DDB Tables with these name
    public static string SIMPLE_BEACON_TEST_DDB_TABLE_NAME = "SimpleBeaconTestTable";
    public static string UNIT_INSPECTION_TEST_DDB_TABLE_NAME = "UnitInspectionTestTableCS";

    // The branch key must have been created using this KMS key
    // Note: This is a public resource that anyone can access.
    // This MUST NOT be used to encrypt any production data.
    public static string TEST_BRANCH_KEY_WRAPPING_KMS_KEY_ARN =
        "arn:aws:kms:us-west-2:370957321024:key/9d989aa2-2f9c-438c-a745-cc57d3ad0126";

    // Our tests require access to DDB Table with this name configured as a branch keystore
    public static string TEST_BRANCH_KEYSTORE_DDB_TABLE_NAME = "KeyStoreDdbTable";
    public static string TEST_COMPLEX_DDB_TABLE_NAME = "ComplexBeaconTestTable";
    public static String AttributeType(AttributeValue value)
    {
        if (value.S != null) return "S";
        if (value.N != null) return "N";
        if (value.B != null) return "B";
        if (value.SS.Any()) return "SS";
        if (value.NS.Any()) return "NS";
        if (value.BS.Any()) return "BS";
        if (value.IsMSet) return "M";
        if (value.IsLSet) return "L";
        if (value.NULL == true) return "NULL";
        if (value.IsBOOLSet) return "BOOL";
        return "UNKNOWN";
    }

    public static void PrintAttributeValue(AttributeValue value)
    {
        if (value.S != null) Console.Write($"S {value.S}\n");
        if (value.N != null) Console.Write($"N {value.N}\n");
        if (value.B != null) Console.Write($"B {value.B}\n");
        if (value.SS.Any()) Console.Write($"SS {value.SS}\n");
        if (value.NS.Any()) Console.Write($"NS {value.NS}\n");
        if (value.BS.Any()) Console.Write($"BS {value.BS}\n");
        if (value.IsMSet) Console.Write($"M {value.M}\n");
        if (value.IsLSet) Console.Write($"L {value.L}\n");
        if (value.NULL == true) Console.Write($"NULL {value.NULL}\n");
        if (value.IsBOOLSet) Console.Write($"BOOL {value.BOOL}\n");
        Console.Write("UNKNOWN\n");
    }

    // Helper method to clean up test items
    public static async System.Threading.Tasks.Task CleanupItems(string tableName, string partitionKey, string sortKey)
    {
        var ddb = new Amazon.DynamoDBv2.AmazonDynamoDBClient();
        var key = new Dictionary<string, AttributeValue>
        {
            ["partition_key"] = new AttributeValue { S = partitionKey },
            ["sort_key"] = new AttributeValue { N = sortKey }
        };
        var deleteRequest = new DeleteItemRequest
        {
            TableName = tableName,
            Key = key
        };
        await ddb.DeleteItemAsync(deleteRequest);
    }
}