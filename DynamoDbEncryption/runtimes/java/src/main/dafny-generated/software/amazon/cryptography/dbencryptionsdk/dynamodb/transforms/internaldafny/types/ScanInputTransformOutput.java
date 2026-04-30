// Class ScanInputTransformOutput
// Dafny class ScanInputTransformOutput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class ScanInputTransformOutput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput _transformedInput;
  public ScanInputTransformOutput (software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput transformedInput) {
    this._transformedInput = transformedInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    ScanInputTransformOutput o = (ScanInputTransformOutput)other;
    return true && java.util.Objects.equals(this._transformedInput, o._transformedInput);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._transformedInput);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ScanInputTransformOutput.ScanInputTransformOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._transformedInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<ScanInputTransformOutput> _TYPE = dafny.TypeDescriptor.<ScanInputTransformOutput>referenceWithInitializer(ScanInputTransformOutput.class, () -> ScanInputTransformOutput.Default());
  public static dafny.TypeDescriptor<ScanInputTransformOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<ScanInputTransformOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final ScanInputTransformOutput theDefault = ScanInputTransformOutput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput.Default());
  public static ScanInputTransformOutput Default() {
    return theDefault;
  }
  public static ScanInputTransformOutput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput transformedInput) {
    return new ScanInputTransformOutput(transformedInput);
  }
  public static ScanInputTransformOutput create_ScanInputTransformOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput transformedInput) {
    return create(transformedInput);
  }
  public boolean is_ScanInputTransformOutput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput dtor_transformedInput() {
    return this._transformedInput;
  }
}
