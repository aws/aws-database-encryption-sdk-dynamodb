// Class _ExternBase_InternalLegacyOverride
// Dafny class InternalLegacyOverride compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.legacy;

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class _ExternBase_InternalLegacyOverride {
  public _ExternBase_InternalLegacyOverride() {
  }
  public abstract Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> EncryptItem(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemInput input);
  public abstract Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> DecryptItem(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemInput input);
  public abstract boolean IsLegacyInput(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemInput input);
  public static Wrappers_Compile.Result<Wrappers_Compile.Option<InternalLegacyOverride>, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> CreateBuildSuccess(Wrappers_Compile.Option<InternalLegacyOverride> value) {
    return Wrappers_Compile.Result.<Wrappers_Compile.Option<InternalLegacyOverride>, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error>create_Success(Wrappers_Compile.Option.<InternalLegacyOverride>_typeDescriptor(((dafny.TypeDescriptor<InternalLegacyOverride>)(java.lang.Object)dafny.TypeDescriptor.reference(InternalLegacyOverride.class))), software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error._typeDescriptor(), value);
  }
  public static Wrappers_Compile.Result<Wrappers_Compile.Option<InternalLegacyOverride>, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> CreateBuildFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error error) {
    return Wrappers_Compile.Result.<Wrappers_Compile.Option<InternalLegacyOverride>, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error>create_Failure(Wrappers_Compile.Option.<InternalLegacyOverride>_typeDescriptor(((dafny.TypeDescriptor<InternalLegacyOverride>)(java.lang.Object)dafny.TypeDescriptor.reference(InternalLegacyOverride.class))), software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error._typeDescriptor(), error);
  }
  public static Wrappers_Compile.Option<InternalLegacyOverride> CreateInternalLegacyOverrideSome(InternalLegacyOverride value) {
    return Wrappers_Compile.Option.<InternalLegacyOverride>create_Some(((dafny.TypeDescriptor<InternalLegacyOverride>)(java.lang.Object)dafny.TypeDescriptor.reference(InternalLegacyOverride.class)), value);
  }
  public static Wrappers_Compile.Option<InternalLegacyOverride> CreateInternalLegacyOverrideNone() {
    return Wrappers_Compile.Option.<InternalLegacyOverride>create_None(((dafny.TypeDescriptor<InternalLegacyOverride>)(java.lang.Object)dafny.TypeDescriptor.reference(InternalLegacyOverride.class)));
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> CreateEncryptItemSuccess(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput value) {
    return Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error>create_Success(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error._typeDescriptor(), value);
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> CreateEncryptItemFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error error) {
    return Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error>create_Failure(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.EncryptItemOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error._typeDescriptor(), error);
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> CreateDecryptItemSuccess(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemOutput value) {
    return Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error>create_Success(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error._typeDescriptor(), value);
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> CreateDecryptItemFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error error) {
    return Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error>create_Failure(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DecryptItemOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error._typeDescriptor(), error);
  }
  private static final dafny.TypeDescriptor<InternalLegacyOverride> _TYPE = dafny.TypeDescriptor.<InternalLegacyOverride>referenceWithInitializer(InternalLegacyOverride.class, () -> (InternalLegacyOverride) null);
  public static dafny.TypeDescriptor<InternalLegacyOverride> _typeDescriptor() {
    return (dafny.TypeDescriptor<InternalLegacyOverride>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "InternalLegacyOverride.InternalLegacyOverride";
  }
}
