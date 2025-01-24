package software.amazon.cryptography.examples;

import static software.amazon.cryptography.services.dynamodb.internaldafny.ToDafny.DynamoDB_20120810;
import static software.amazon.smithy.dafny.conversion.ToDafny.Simple.CharacterSequence;
import static software.amazon.smithy.dafny.conversion.ToDafny.Simple.DafnyUtf8Bytes;

import software.amazon.awssdk.annotations.SdkInternalApi;
import software.amazon.awssdk.annotations.SdkTestInternalApi;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.cryptography.keystore.KeyStorageInterface;
import software.amazon.cryptography.services.dynamodb.internaldafny.types.IDynamoDBClient;

@SdkInternalApi
@SdkTestInternalApi
public class CustomStorageWrapper {

  @SdkInternalApi
  @SdkTestInternalApi
  public static KeyStorageInterface create(
    DynamoDbClient ddbClient,
    String physicalName,
    String logicalName
  ) {
    final IDynamoDBClient _ddbClient = DynamoDB_20120810(ddbClient);
    final dafny.DafnySequence<Character> _physicalName = CharacterSequence(
      physicalName
    );
    final dafny.DafnySequence<Character> _logicalName = CharacterSequence(
      logicalName
    );
    final dafny.DafnySequence<Byte> _physicalBytes = DafnyUtf8Bytes(
      physicalName
    );
    final dafny.DafnySequence<Byte> _logicalBytes = DafnyUtf8Bytes(logicalName);
    final DefaultKeyStorageInterface_Compile.DynamoDBKeyStorageInterface _nw0 =
      new DefaultKeyStorageInterface_Compile.DynamoDBKeyStorageInterface();
    _nw0.__ctor(
      _physicalName,
      _ddbClient,
      _logicalName,
      _physicalBytes,
      _logicalBytes
    );
    return KeyStorageInterface.wrap(_nw0);
  }
}
