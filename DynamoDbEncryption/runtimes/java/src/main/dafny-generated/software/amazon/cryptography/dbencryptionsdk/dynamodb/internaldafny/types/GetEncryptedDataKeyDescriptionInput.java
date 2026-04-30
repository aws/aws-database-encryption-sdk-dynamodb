// Class GetEncryptedDataKeyDescriptionInput
// Dafny class GetEncryptedDataKeyDescriptionInput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class GetEncryptedDataKeyDescriptionInput {
  public GetEncryptedDataKeyDescriptionUnion _input;
  public GetEncryptedDataKeyDescriptionInput (GetEncryptedDataKeyDescriptionUnion input) {
    this._input = input;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    GetEncryptedDataKeyDescriptionInput o = (GetEncryptedDataKeyDescriptionInput)other;
    return true && java.util.Objects.equals(this._input, o._input);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._input);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetEncryptedDataKeyDescriptionInput.GetEncryptedDataKeyDescriptionInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._input));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<GetEncryptedDataKeyDescriptionInput> _TYPE = dafny.TypeDescriptor.<GetEncryptedDataKeyDescriptionInput>referenceWithInitializer(GetEncryptedDataKeyDescriptionInput.class, () -> GetEncryptedDataKeyDescriptionInput.Default());
  public static dafny.TypeDescriptor<GetEncryptedDataKeyDescriptionInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<GetEncryptedDataKeyDescriptionInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final GetEncryptedDataKeyDescriptionInput theDefault = GetEncryptedDataKeyDescriptionInput.create(GetEncryptedDataKeyDescriptionUnion.Default());
  public static GetEncryptedDataKeyDescriptionInput Default() {
    return theDefault;
  }
  public static GetEncryptedDataKeyDescriptionInput create(GetEncryptedDataKeyDescriptionUnion input) {
    return new GetEncryptedDataKeyDescriptionInput(input);
  }
  public static GetEncryptedDataKeyDescriptionInput create_GetEncryptedDataKeyDescriptionInput(GetEncryptedDataKeyDescriptionUnion input) {
    return create(input);
  }
  public boolean is_GetEncryptedDataKeyDescriptionInput() { return true; }
  public GetEncryptedDataKeyDescriptionUnion dtor_input() {
    return this._input;
  }
}
