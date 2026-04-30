// Interface IDynamoDbKeyBranchKeyIdSupplier
// Dafny trait IDynamoDbKeyBranchKeyIdSupplier compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class _Companion_IDynamoDbKeyBranchKeyIdSupplier {
  public _Companion_IDynamoDbKeyBranchKeyIdSupplier() {
  }
  private static final dafny.TypeDescriptor<IDynamoDbKeyBranchKeyIdSupplier> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(IDynamoDbKeyBranchKeyIdSupplier.class, () -> null);
  public static dafny.TypeDescriptor<IDynamoDbKeyBranchKeyIdSupplier> _typeDescriptor() {
    return (dafny.TypeDescriptor<IDynamoDbKeyBranchKeyIdSupplier>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static Wrappers_Compile.Result<GetBranchKeyIdFromDdbKeyOutput, Error> GetBranchKeyIdFromDdbKey(IDynamoDbKeyBranchKeyIdSupplier _this, GetBranchKeyIdFromDdbKeyInput input)
  {
    Wrappers_Compile.Result<GetBranchKeyIdFromDdbKeyOutput, Error> output = Wrappers_Compile.Result.<GetBranchKeyIdFromDdbKeyOutput, Error>Default(GetBranchKeyIdFromDdbKeyOutput._typeDescriptor(), Error._typeDescriptor(), GetBranchKeyIdFromDdbKeyOutput.Default());
    if(true) {
      Wrappers_Compile.Result<GetBranchKeyIdFromDdbKeyOutput, Error> _out0;
      _out0 = (_this).GetBranchKeyIdFromDdbKey_k(input);
      output = _out0;
    }
    return output;
  }
}
