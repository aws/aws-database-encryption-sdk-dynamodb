// Class PutItemInputTransformInput
// Dafny class PutItemInputTransformInput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class PutItemInputTransformInput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.PutItemInput _sdkInput;
  public PutItemInputTransformInput (software.amazon.cryptography.services.dynamodb.internaldafny.types.PutItemInput sdkInput) {
    this._sdkInput = sdkInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    PutItemInputTransformInput o = (PutItemInputTransformInput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.PutItemInputTransformInput.PutItemInputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<PutItemInputTransformInput> _TYPE = dafny.TypeDescriptor.<PutItemInputTransformInput>referenceWithInitializer(PutItemInputTransformInput.class, () -> PutItemInputTransformInput.Default());
  public static dafny.TypeDescriptor<PutItemInputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<PutItemInputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final PutItemInputTransformInput theDefault = PutItemInputTransformInput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.PutItemInput.Default());
  public static PutItemInputTransformInput Default() {
    return theDefault;
  }
  public static PutItemInputTransformInput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.PutItemInput sdkInput) {
    return new PutItemInputTransformInput(sdkInput);
  }
  public static PutItemInputTransformInput create_PutItemInputTransformInput(software.amazon.cryptography.services.dynamodb.internaldafny.types.PutItemInput sdkInput) {
    return create(sdkInput);
  }
  public boolean is_PutItemInputTransformInput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.PutItemInput dtor_sdkInput() {
    return this._sdkInput;
  }
}
