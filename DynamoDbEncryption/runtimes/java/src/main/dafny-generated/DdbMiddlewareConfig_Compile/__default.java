// Class __default
// Dafny class __default compiled into Java
package DdbMiddlewareConfig_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static boolean IsPlainWrite(Config config, dafny.DafnySequence<? extends Character> tableName)
  {
    return (!((config).dtor_tableEncryptionConfigs()).<dafny.DafnySequence<? extends Character>>contains(tableName)) || (java.util.Objects.equals((((TableConfig)(java.lang.Object)(((config).dtor_tableEncryptionConfigs()).get(tableName)))).dtor_plaintextOverride(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PlaintextOverride.create_FORCE__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ()));
  }
  public static dafny.DafnySequence<? extends Character> AttrToString(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue attr) {
    if ((attr).is_S()) {
      return (attr).dtor_S();
    } else if ((attr).is_N()) {
      return (attr).dtor_N();
    } else if ((attr).is_B()) {
      return HexStrings_Compile.__default.ToHexString((attr).dtor_B());
    } else {
      return dafny.DafnySequence.asString("unexpected key type");
    }
  }
  public static dafny.DafnySequence<? extends Character> KeyString(TableConfig config, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item)
  {
    dafny.DafnySequence<? extends Character> _0_partition = (((item).<dafny.DafnySequence<? extends Character>>contains((config).dtor_partitionKeyName())) ? (dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate((config).dtor_partitionKeyName(), dafny.DafnySequence.asString(" = ")), __default.AttrToString(((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((item).get((config).dtor_partitionKeyName())))))) : (dafny.DafnySequence.asString("")));
    dafny.DafnySequence<? extends Character> _1_sort = (((((config).dtor_sortKeyName()).is_Some()) && ((item).<dafny.DafnySequence<? extends Character>>contains(((config).dtor_sortKeyName()).dtor_value()))) ? (dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("; "), ((config).dtor_sortKeyName()).dtor_value()), dafny.DafnySequence.asString(" = ")), __default.AttrToString(((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((item).get(((config).dtor_sortKeyName()).dtor_value())))))) : (dafny.DafnySequence.asString("")));
    return dafny.DafnySequence.<Character>concatenate(_0_partition, _1_sort);
  }
  public static <__T> Wrappers_Compile.Result<__T, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> MapError(dafny.TypeDescriptor<__T> _td___T, Wrappers_Compile.Result<__T, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> r)
  {
    return (r).<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>MapFailure(_td___T, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>)(_0_e_boxed0) -> {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error _0_e = ((software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error)(java.lang.Object)(_0_e_boxed0));
      return software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error.create_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor(_0_e);
    }));
  }
  public static <__T> Wrappers_Compile.Result<__T, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> MapString(dafny.TypeDescriptor<__T> _td___T, Wrappers_Compile.Result<__T, dafny.DafnySequence<? extends Character>> r)
  {
    return (r).<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>MapFailure(_td___T, dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>)(_0_e_boxed0) -> {
      dafny.DafnySequence<? extends Character> _0_e = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_0_e_boxed0));
      return software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error.create_DynamoDbEncryptionTransformsException(_0_e);
    }));
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error E(dafny.DafnySequence<? extends Character> s) {
    return software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error.create_DynamoDbEncryptionTransformsException(s);
  }
  public static <__X> Wrappers_Compile.Result<__X, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> MakeError(dafny.TypeDescriptor<__X> _td___X, dafny.DafnySequence<? extends Character> s)
  {
    return Wrappers_Compile.Result.<__X, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>create_Failure(_td___X, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error.create_DynamoDbEncryptionTransformsException(s));
  }
  @Override
  public java.lang.String toString() {
    return "DdbMiddlewareConfig._default";
  }
}
