using Amazon.DynamoDBv2;
using software.amazon.cryptography.services.dynamodb.internaldafny.types;
using Wrappers_Compile;
using _IError = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IError;

namespace CreateInterceptedDDBClient_Compile
{

    public partial class __default
    {
        public static _IResult<IDynamoDBClient, _IError> CreateInterceptedDDBClient(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IDynamoDbTablesEncryptionConfig config)
        {
            var clientConfig = new AmazonDynamoDBConfig();
            clientConfig.ServiceURL = "http://localhost:8000";

            var native = AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TypeConversion
              .FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S30_DynamoDbTablesEncryptionConfig(
                config);

            var client = new Client.DynamoDbClient(clientConfig, native);
            var c2 = new Com.Amazonaws.Dynamodb.DynamoDBv2Shim(client);
            return new Result_Success<IDynamoDBClient, _IError>(c2);
        }
        public static _IResult<IDynamoDBClient, _IError> CreateVanillaDDBClient()
        {
            var clientConfig = new AmazonDynamoDBConfig();
            clientConfig.ServiceURL = "http://localhost:8000";
            var client = new AmazonDynamoDBClient(clientConfig);
            var c2 = new Com.Amazonaws.Dynamodb.DynamoDBv2Shim(client);
            return new Result_Success<IDynamoDBClient, _IError>(c2);
        }
    }
}

