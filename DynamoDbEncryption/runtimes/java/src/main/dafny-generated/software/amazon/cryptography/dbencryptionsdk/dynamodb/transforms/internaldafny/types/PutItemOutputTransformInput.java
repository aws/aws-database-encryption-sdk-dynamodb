// Class PutItemOutputTransformInput
// Dafny class PutItemOutputTransformInput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class PutItemOutputTransformInput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.PutItemOutput _sdkOutput;
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.PutItemInput _originalInput;
  public PutItemOutputTransformInput (software.amazon.cryptography.services.dynamodb.internaldafny.types.PutItemOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.PutItemInput originalInput) {
    this._sdkOutput = sdkOutput;
    this._originalInput = originalInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    PutItemOutputTransformInput o = (PutItemOutputTransformInput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.PutItemOutputTransformInput.PutItemOutputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkOutput));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._originalInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<PutItemOutputTransformInput> _TYPE = dafny.TypeDescriptor.<PutItemOutputTransformInput>referenceWithInitializer(PutItemOutputTransformInput.class, () -> PutItemOutputTransformInput.Default());
  public static dafny.TypeDescriptor<PutItemOutputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<PutItemOutputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final PutItemOutputTransformInput theDefault = PutItemOutputTransformInput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.PutItemOutput.Default(), software.amazon.cryptography.services.dynamodb.internaldafny.types.PutItemInput.Default());
  public static PutItemOutputTransformInput Default() {
    return theDefault;
  }
  public static PutItemOutputTransformInput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.PutItemOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.PutItemInput originalInput) {
    return new PutItemOutputTransformInput(sdkOutput, originalInput);
  }
  public static PutItemOutputTransformInput create_PutItemOutputTransformInput(software.amazon.cryptography.services.dynamodb.internaldafny.types.PutItemOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.PutItemInput originalInput) {
    return create(sdkOutput, originalInput);
  }
  public boolean is_PutItemOutputTransformInput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.PutItemOutput dtor_sdkOutput() {
    return this._sdkOutput;
  }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.PutItemInput dtor_originalInput() {
    return this._originalInput;
  }
}
