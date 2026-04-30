// Class ScanInputTransformInput
// Dafny class ScanInputTransformInput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class ScanInputTransformInput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput _sdkInput;
  public ScanInputTransformInput (software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput sdkInput) {
    this._sdkInput = sdkInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    ScanInputTransformInput o = (ScanInputTransformInput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ScanInputTransformInput.ScanInputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<ScanInputTransformInput> _TYPE = dafny.TypeDescriptor.<ScanInputTransformInput>referenceWithInitializer(ScanInputTransformInput.class, () -> ScanInputTransformInput.Default());
  public static dafny.TypeDescriptor<ScanInputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<ScanInputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final ScanInputTransformInput theDefault = ScanInputTransformInput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput.Default());
  public static ScanInputTransformInput Default() {
    return theDefault;
  }
  public static ScanInputTransformInput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput sdkInput) {
    return new ScanInputTransformInput(sdkInput);
  }
  public static ScanInputTransformInput create_ScanInputTransformInput(software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput sdkInput) {
    return create(sdkInput);
  }
  public boolean is_ScanInputTransformInput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput dtor_sdkInput() {
    return this._sdkInput;
  }
}
