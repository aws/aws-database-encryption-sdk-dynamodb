package CreateInterceptedDDBClient_Compile;

import software.amazon.cryptography.services.dynamodb.internaldafny.Shim;
import Wrappers_Compile.Result;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.regions.providers.DefaultAwsRegionProviderChain;
import software.amazon.cryptography.dynamoDbEncryption.ToDafny;
import software.amazon.cryptography.dynamoDbEncryption.ToNative;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbTablesEncryptionConfig;

import software.aws.cryptography.dynamoDbEncryption.DynamoDbEncryptionInterceptor;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import java.net.URI;

public class __default {
  public static
  Wrappers_Compile.Result<
  software.amazon.cryptography.services.dynamodb.internaldafny.types.IDynamoDBClient,
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error
    >
  CreateInterceptedDDBClient(
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTablesEncryptionConfig config
  ) {
    try {
    final DynamoDbTablesEncryptionConfig nativeConfig = ToNative.DynamoDbTablesEncryptionConfig(config);

    DynamoDbEncryptionInterceptor encryptionInterceptor = DynamoDbEncryptionInterceptor.builder()
      .config(nativeConfig)
      .build();

    final Region region = new DefaultAwsRegionProviderChain().getRegion();
    final DynamoDbClient ddb = DynamoDbClient.builder()
      .endpointOverride(URI.create("http://localhost:8000"))
      .overrideConfiguration(
        ClientOverrideConfiguration.builder()
          .addExecutionInterceptor(encryptionInterceptor)
          .build())
      .build();

    final Shim wrappedClient = new Shim(ddb, region.toString());

    return Result.create_Success(wrappedClient);
    } catch (Exception e) {
      return Result.create_Failure(ToDafny.Error((RuntimeException)e));
    }
  }

  public static
  Wrappers_Compile.Result<
    Dafny.Com.Amazonaws.Dynamodb.Types.IDynamoDBClient,
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error
    >
  CreateVanillaDDBClient() {
    try {
    final Region region = new DefaultAwsRegionProviderChain().getRegion();
    final DynamoDbClient ddb = DynamoDbClient.builder()
      .endpointOverride(URI.create("http://localhost:8000"))
      .build();

    final Shim wrappedClient = new Shim(ddb, region.toString());

    return Result.create_Success(wrappedClient);
    } catch (Exception e) {
      return Result.create_Failure(ToDafny.Error((RuntimeException)e));
    }
  }

}
/*
DynamoDbClient client = DynamoDbClient.builder()
                        .region(Region.US_WEST_2)
                        .endpointOverride(URI.create("http://localhost:8000"))
                        .build();

DynamoDB dynamoDB = new DynamoDB(client);
*/