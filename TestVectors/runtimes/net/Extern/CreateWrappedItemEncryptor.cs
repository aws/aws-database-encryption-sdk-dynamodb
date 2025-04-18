using AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.Wrapped;
using software.amazon.cryptography.services.dynamodb.internaldafny;
using software.amazon.cryptography.services.dynamodb.internaldafny.types;
using Wrappers_Compile;
using _IError = software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IError;

namespace CreateWrappedItemEncryptor_Compile
{
    public partial class __default
    {
        public static _IResult<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.IDynamoDbItemEncryptorClient, _IError> CreateWrappedItemEncryptor(
            software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types._IDynamoDbItemEncryptorConfig config)
        {
            var nativeConfig = AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor.TypeConversion
                .FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__N13_itemEncryptor__S27_DynamoDbItemEncryptorConfig(
                    config);

            var itemEncryptor = new DynamoDbItemEncryptor(nativeConfig);
            var wrappedEncryptor = new DynamoDbItemEncryptorShim(itemEncryptor);

            return new Result_Success<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.IDynamoDbItemEncryptorClient, _IError>(wrappedEncryptor);
        }
    }
}
