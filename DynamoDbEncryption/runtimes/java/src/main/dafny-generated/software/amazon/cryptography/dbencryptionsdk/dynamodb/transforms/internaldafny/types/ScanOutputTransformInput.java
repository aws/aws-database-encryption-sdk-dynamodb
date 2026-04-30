// Class ScanOutputTransformInput
// Dafny class ScanOutputTransformInput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class ScanOutputTransformInput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput _sdkOutput;
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput _originalInput;
  public ScanOutputTransformInput (software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput originalInput) {
    this._sdkOutput = sdkOutput;
    this._originalInput = originalInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    ScanOutputTransformInput o = (ScanOutputTransformInput)other;
    return true && java.util.Objects.equals(this._sdkOutput, o._sdkOutput) && java.util.Objects.equals(this._originalInput, o._originalInput);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._sdkOutput);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._originalInput);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ScanOutputTransformInput.ScanOutputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkOutput));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._originalInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<ScanOutputTransformInput> _TYPE = dafny.TypeDescriptor.<ScanOutputTransformInput>referenceWithInitializer(ScanOutputTransformInput.class, () -> ScanOutputTransformInput.Default());
  public static dafny.TypeDescriptor<ScanOutputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<ScanOutputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final ScanOutputTransformInput theDefault = ScanOutputTransformInput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput.Default(), software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput.Default());
  public static ScanOutputTransformInput Default() {
    return theDefault;
  }
  public static ScanOutputTransformInput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput originalInput) {
    return new ScanOutputTransformInput(sdkOutput, originalInput);
  }
  public static ScanOutputTransformInput create_ScanOutputTransformInput(software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput originalInput) {
    return create(sdkOutput, originalInput);
  }
  public boolean is_ScanOutputTransformInput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput dtor_sdkOutput() {
    return this._sdkOutput;
  }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput dtor_originalInput() {
    return this._originalInput;
  }
}
