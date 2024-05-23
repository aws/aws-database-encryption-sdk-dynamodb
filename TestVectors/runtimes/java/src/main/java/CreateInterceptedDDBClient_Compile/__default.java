package CreateInterceptedDDBClient_Compile;

import Wrappers_Compile.Result;
import java.net.URI;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.regions.providers.DefaultAwsRegionProviderChain;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryptionInterceptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.ToDafny;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.ToNative;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.services.dynamodb.internaldafny.Shim;

public class __default {

  public static Wrappers_Compile.Result<
    software.amazon.cryptography.services.dynamodb.internaldafny.types.IDynamoDBClient,
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error
  > CreateInterceptedDDBClient(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTablesEncryptionConfig config
  ) {
    try {
      final DynamoDbTablesEncryptionConfig nativeConfig =
        ToNative.DynamoDbTablesEncryptionConfig(config);

      DynamoDbEncryptionInterceptor encryptionInterceptor =
        DynamoDbEncryptionInterceptor.builder().config(nativeConfig).build();

      final Region region = new DefaultAwsRegionProviderChain().getRegion();
      final DynamoDbClient ddb = DynamoDbClient
        .builder()
        .endpointOverride(URI.create("http://localhost:8000"))
        .overrideConfiguration(
          ClientOverrideConfiguration
            .builder()
            .addExecutionInterceptor(encryptionInterceptor)
            .build()
        )
        .build();

      final Shim wrappedClient = new Shim(ddb, region.toString());

      return Result.create_Success(wrappedClient);
    } catch (Exception e) {
      return Result.create_Failure(ToDafny.Error((RuntimeException) e));
    }
  }

  public static Wrappers_Compile.Result<
    software.amazon.cryptography.services.dynamodb.internaldafny.types.IDynamoDBClient,
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error
  > CreateVanillaDDBClient() {
    try {
      final Region region = new DefaultAwsRegionProviderChain().getRegion();
      final DynamoDbClient ddb = DynamoDbClient
        .builder()
        .endpointOverride(URI.create("http://localhost:8000"))
        .build();

      final Shim wrappedClient = new Shim(ddb, region.toString());

      return Result.create_Success(wrappedClient);
    } catch (Exception e) {
      return Result.create_Failure(ToDafny.Error((RuntimeException) e));
    }
  }
}
