using AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor;
using AWS.Cryptography.DbEncryptionSDK.Dynamodb;
using software.amazon.cryptography.services.dynamodb.internaldafny;
using software.amazon.cryptography.services.dynamodb.internaldafny.types;
using Wrappers_Compile;
using _IError = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IError;

namespace CreateWrappedItemEncryptor_Compile
{
    public partial class __default
    {
        public static _IResult<IItemEncryptor, _IError> CreateWrappedItemEncryptor(
            software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._IDynamoDbItemEncryptorConfig config)
        {
            var nativeConfig = AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms.TypeConversion
                .FromDafny_N3_aws__N12_cryptography__N15_dbEncryptionSdk__N8_dynamoDb__S30_DynamoDbItemEncryptorConfig(
                    config);

            var itemEncryptor = DynamoDbItemEncryptor.Create(nativeConfig);
            var wrappedEncryptor = new Com.Amazonaws.Dynamodb.ItemEncryptorShim(itemEncryptor);

            return new Result_Success<IItemEncryptor, _IError>(wrappedEncryptor);
        }
    }
}
