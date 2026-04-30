// Class DynamoDbEncryptionBranchKeyIdSupplier
// Dafny class DynamoDbEncryptionBranchKeyIdSupplier compiled into Java
package DynamoDbEncryptionBranchKeyIdSupplier_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class DynamoDbEncryptionBranchKeyIdSupplier implements software.amazon.cryptography.materialproviders.internaldafny.types.IBranchKeyIdSupplier {
  public DynamoDbEncryptionBranchKeyIdSupplier() {
    this._ddbKeyBranchKeyIdSupplier = null;
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.GetBranchKeyIdOutput, software.amazon.cryptography.materialproviders.internaldafny.types.Error> GetBranchKeyId(software.amazon.cryptography.materialproviders.internaldafny.types.GetBranchKeyIdInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.GetBranchKeyIdOutput, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _out0;
    _out0 = software.amazon.cryptography.materialproviders.internaldafny.types._Companion_IBranchKeyIdSupplier.GetBranchKeyId(this, input);
    return _out0;
  }
  public void __ctor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbKeyBranchKeyIdSupplier ddbKeyBranchKeyIdSupplier)
  {
    (this)._ddbKeyBranchKeyIdSupplier = ddbKeyBranchKeyIdSupplier;
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.GetBranchKeyIdOutput, software.amazon.cryptography.materialproviders.internaldafny.types.Error> GetBranchKeyId_k(software.amazon.cryptography.materialproviders.internaldafny.types.GetBranchKeyIdInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.GetBranchKeyIdOutput, software.amazon.cryptography.materialproviders.internaldafny.types.Error> output = Wrappers_Compile.Result.<software.amazon.cryptography.materialproviders.internaldafny.types.GetBranchKeyIdOutput, software.amazon.cryptography.materialproviders.internaldafny.types.Error>Default(software.amazon.cryptography.materialproviders.internaldafny.types.GetBranchKeyIdOutput._typeDescriptor(), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.materialproviders.internaldafny.types.GetBranchKeyIdOutput.Default());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, dafny.DafnySequence<? extends Character>> _0_attrMapR;
    _0_attrMapR = DynamoDbItemEncryptorUtil_Compile.__default.ConvertContextForSelector((input).dtor_encryptionContext());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _1_valueOrError0 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.materialproviders.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty());
    _1_valueOrError0 = (_0_attrMapR).<software.amazon.cryptography.materialproviders.internaldafny.types.Error>MapFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.materialproviders.internaldafny.types.Error>)(_2_e_boxed0) -> {
      dafny.DafnySequence<? extends Character> _2_e = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_2_e_boxed0));
      return software.amazon.cryptography.materialproviders.internaldafny.types.Error.create_AwsCryptographicMaterialProvidersException(_2_e);
    }));
    if ((_1_valueOrError0).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor())) {
      output = (_1_valueOrError0).<software.amazon.cryptography.materialproviders.internaldafny.types.GetBranchKeyIdOutput>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.materialproviders.internaldafny.types.GetBranchKeyIdOutput._typeDescriptor());
      return output;
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _3_attrMap;
    _3_attrMap = (_1_valueOrError0).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _4_branchKeyIdR;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out0;
    _out0 = ((this).ddbKeyBranchKeyIdSupplier()).GetBranchKeyIdFromDdbKey(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyInput.create(_3_attrMap));
    _4_branchKeyIdR = _out0;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _5_valueOrError1 = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput, software.amazon.cryptography.materialproviders.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput._typeDescriptor(), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput.Default());
    _5_valueOrError1 = (_4_branchKeyIdR).<software.amazon.cryptography.materialproviders.internaldafny.types.Error>MapFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor(), __default::ConvertToMplError);
    if ((_5_valueOrError1).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput._typeDescriptor(), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor())) {
      output = (_5_valueOrError1).<software.amazon.cryptography.materialproviders.internaldafny.types.GetBranchKeyIdOutput>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput._typeDescriptor(), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.materialproviders.internaldafny.types.GetBranchKeyIdOutput._typeDescriptor());
      return output;
    }
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput _6_branchKeyIdOut;
    _6_branchKeyIdOut = (_5_valueOrError1).Extract(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetBranchKeyIdFromDdbKeyOutput._typeDescriptor(), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor());
    output = Wrappers_Compile.Result.<software.amazon.cryptography.materialproviders.internaldafny.types.GetBranchKeyIdOutput, software.amazon.cryptography.materialproviders.internaldafny.types.Error>create_Success(software.amazon.cryptography.materialproviders.internaldafny.types.GetBranchKeyIdOutput._typeDescriptor(), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.materialproviders.internaldafny.types.GetBranchKeyIdOutput.create((_6_branchKeyIdOut).dtor_branchKeyId()));
    return output;
  }
  public software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbKeyBranchKeyIdSupplier _ddbKeyBranchKeyIdSupplier;
  public software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.IDynamoDbKeyBranchKeyIdSupplier ddbKeyBranchKeyIdSupplier()
  {
    return this._ddbKeyBranchKeyIdSupplier;
  }
  private static final dafny.TypeDescriptor<DynamoDbEncryptionBranchKeyIdSupplier> _TYPE = dafny.TypeDescriptor.<DynamoDbEncryptionBranchKeyIdSupplier>referenceWithInitializer(DynamoDbEncryptionBranchKeyIdSupplier.class, () -> (DynamoDbEncryptionBranchKeyIdSupplier) null);
  public static dafny.TypeDescriptor<DynamoDbEncryptionBranchKeyIdSupplier> _typeDescriptor() {
    return (dafny.TypeDescriptor<DynamoDbEncryptionBranchKeyIdSupplier>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "DynamoDbEncryptionBranchKeyIdSupplier.DynamoDbEncryptionBranchKeyIdSupplier";
  }
}
