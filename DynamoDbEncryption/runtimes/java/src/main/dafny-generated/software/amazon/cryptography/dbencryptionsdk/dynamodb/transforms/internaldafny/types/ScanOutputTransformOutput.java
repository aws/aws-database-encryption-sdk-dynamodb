// Class ScanOutputTransformOutput
// Dafny class ScanOutputTransformOutput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class ScanOutputTransformOutput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput _transformedOutput;
  public ScanOutputTransformOutput (software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput transformedOutput) {
    this._transformedOutput = transformedOutput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    ScanOutputTransformOutput o = (ScanOutputTransformOutput)other;
    return true && java.util.Objects.equals(this._transformedOutput, o._transformedOutput);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._transformedOutput);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ScanOutputTransformOutput.ScanOutputTransformOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._transformedOutput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<ScanOutputTransformOutput> _TYPE = dafny.TypeDescriptor.<ScanOutputTransformOutput>referenceWithInitializer(ScanOutputTransformOutput.class, () -> ScanOutputTransformOutput.Default());
  public static dafny.TypeDescriptor<ScanOutputTransformOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<ScanOutputTransformOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final ScanOutputTransformOutput theDefault = ScanOutputTransformOutput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput.Default());
  public static ScanOutputTransformOutput Default() {
    return theDefault;
  }
  public static ScanOutputTransformOutput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput transformedOutput) {
    return new ScanOutputTransformOutput(transformedOutput);
  }
  public static ScanOutputTransformOutput create_ScanOutputTransformOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput transformedOutput) {
    return create(transformedOutput);
  }
  public boolean is_ScanOutputTransformOutput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput dtor_transformedOutput() {
    return this._transformedOutput;
  }
}
