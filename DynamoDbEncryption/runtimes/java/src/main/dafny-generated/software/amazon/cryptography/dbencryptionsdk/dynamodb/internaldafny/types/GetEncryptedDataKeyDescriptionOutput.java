// Class GetEncryptedDataKeyDescriptionOutput
// Dafny class GetEncryptedDataKeyDescriptionOutput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class GetEncryptedDataKeyDescriptionOutput {
  public dafny.DafnySequence<? extends EncryptedDataKeyDescription> _EncryptedDataKeyDescriptionOutput;
  public GetEncryptedDataKeyDescriptionOutput (dafny.DafnySequence<? extends EncryptedDataKeyDescription> EncryptedDataKeyDescriptionOutput) {
    this._EncryptedDataKeyDescriptionOutput = EncryptedDataKeyDescriptionOutput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    GetEncryptedDataKeyDescriptionOutput o = (GetEncryptedDataKeyDescriptionOutput)other;
    return true && java.util.Objects.equals(this._EncryptedDataKeyDescriptionOutput, o._EncryptedDataKeyDescriptionOutput);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._EncryptedDataKeyDescriptionOutput);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionOutput.GetEncryptedDataKeyDescriptionOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._EncryptedDataKeyDescriptionOutput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<GetEncryptedDataKeyDescriptionOutput> _TYPE = dafny.TypeDescriptor.<GetEncryptedDataKeyDescriptionOutput>referenceWithInitializer(GetEncryptedDataKeyDescriptionOutput.class, () -> GetEncryptedDataKeyDescriptionOutput.Default());
  public static dafny.TypeDescriptor<GetEncryptedDataKeyDescriptionOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<GetEncryptedDataKeyDescriptionOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final GetEncryptedDataKeyDescriptionOutput theDefault = GetEncryptedDataKeyDescriptionOutput.create(dafny.DafnySequence.<EncryptedDataKeyDescription> empty(EncryptedDataKeyDescription._typeDescriptor()));
  public static GetEncryptedDataKeyDescriptionOutput Default() {
    return theDefault;
  }
  public static GetEncryptedDataKeyDescriptionOutput create(dafny.DafnySequence<? extends EncryptedDataKeyDescription> EncryptedDataKeyDescriptionOutput) {
    return new GetEncryptedDataKeyDescriptionOutput(EncryptedDataKeyDescriptionOutput);
  }
  public static GetEncryptedDataKeyDescriptionOutput create_GetEncryptedDataKeyDescriptionOutput(dafny.DafnySequence<? extends EncryptedDataKeyDescription> EncryptedDataKeyDescriptionOutput) {
    return create(EncryptedDataKeyDescriptionOutput);
  }
  public boolean is_GetEncryptedDataKeyDescriptionOutput() { return true; }
  public dafny.DafnySequence<? extends EncryptedDataKeyDescription> dtor_EncryptedDataKeyDescriptionOutput() {
    return this._EncryptedDataKeyDescriptionOutput;
  }
}
