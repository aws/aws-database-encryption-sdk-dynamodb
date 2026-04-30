// Class GetItemInputTransformInput
// Dafny class GetItemInputTransformInput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class GetItemInputTransformInput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemInput _sdkInput;
  public GetItemInputTransformInput (software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemInput sdkInput) {
    this._sdkInput = sdkInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    GetItemInputTransformInput o = (GetItemInputTransformInput)other;
    return true && java.util.Objects.equals(this._sdkInput, o._sdkInput);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._sdkInput);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.GetItemInputTransformInput.GetItemInputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<GetItemInputTransformInput> _TYPE = dafny.TypeDescriptor.<GetItemInputTransformInput>referenceWithInitializer(GetItemInputTransformInput.class, () -> GetItemInputTransformInput.Default());
  public static dafny.TypeDescriptor<GetItemInputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<GetItemInputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final GetItemInputTransformInput theDefault = GetItemInputTransformInput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemInput.Default());
  public static GetItemInputTransformInput Default() {
    return theDefault;
  }
  public static GetItemInputTransformInput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemInput sdkInput) {
    return new GetItemInputTransformInput(sdkInput);
  }
  public static GetItemInputTransformInput create_GetItemInputTransformInput(software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemInput sdkInput) {
    return create(sdkInput);
  }
  public boolean is_GetItemInputTransformInput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemInput dtor_sdkInput() {
    return this._sdkInput;
  }
}
