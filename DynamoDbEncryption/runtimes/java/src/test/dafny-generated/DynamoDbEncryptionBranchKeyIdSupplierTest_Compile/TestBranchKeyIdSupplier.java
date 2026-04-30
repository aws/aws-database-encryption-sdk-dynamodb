// Class TestBranchKeyIdSupplier
// Dafny class TestBranchKeyIdSupplier compiled into Java
package DynamoDbEncryptionBranchKeyIdSupplierTest_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class TestBranchKeyIdSupplier implements software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbKeyBranchKeyIdSupplier {
  public TestBranchKeyIdSupplier() {
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GetBranchKeyIdFromDdbKey(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out0;
    _out0 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types._Companion_IDynamoDbKeyBranchKeyIdSupplier.GetBranchKeyIdFromDdbKey(this, input);
    return _out0;
  }
  public void __ctor()
  {
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GetBranchKeyIdFromDdbKey_k(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput.Default());
    if(true) {
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _0_item;
      _0_item = (input).dtor_ddbKey();
      if (((((_0_item).keySet()).<dafny.DafnySequence<? extends Character>>contains(__default.BRANCH__KEY())) && ((((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_0_item).get(__default.BRANCH__KEY())))).is_S())) && (((((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_0_item).get(__default.BRANCH__KEY())))).dtor_S()).equals(__default.CASE__A()))) {
        output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput.create(__default.BRANCH__KEY__ID__A()));
        return output;
      } else if (((((_0_item).keySet()).<dafny.DafnySequence<? extends Character>>contains(__default.BRANCH__KEY())) && ((((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_0_item).get(__default.BRANCH__KEY())))).is_S())) && (((((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_0_item).get(__default.BRANCH__KEY())))).dtor_S()).equals(__default.CASE__B()))) {
        output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput.create(__default.BRANCH__KEY__ID__B()));
        return output;
      } else {
        output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error.create_DynamoDbEncryptionException(dafny.DafnySequence.asString("Can't determine branchKeyId from item")));
        return output;
      }
    }
    return output;
  }
  private static final dafny.TypeDescriptor<TestBranchKeyIdSupplier> _TYPE = dafny.TypeDescriptor.<TestBranchKeyIdSupplier>referenceWithInitializer(TestBranchKeyIdSupplier.class, () -> (TestBranchKeyIdSupplier) null);
  public static dafny.TypeDescriptor<TestBranchKeyIdSupplier> _typeDescriptor() {
    return (dafny.TypeDescriptor<TestBranchKeyIdSupplier>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "DynamoDbEncryptionBranchKeyIdSupplierTest.TestBranchKeyIdSupplier";
  }
}
