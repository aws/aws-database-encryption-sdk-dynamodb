// Class BatchGetItemOutputTransformInput
// Dafny class BatchGetItemOutputTransformInput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class BatchGetItemOutputTransformInput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemOutput _sdkOutput;
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemInput _originalInput;
  public BatchGetItemOutputTransformInput (software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemInput originalInput) {
    this._sdkOutput = sdkOutput;
    this._originalInput = originalInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    BatchGetItemOutputTransformInput o = (BatchGetItemOutputTransformInput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchGetItemOutputTransformInput.BatchGetItemOutputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkOutput));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._originalInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<BatchGetItemOutputTransformInput> _TYPE = dafny.TypeDescriptor.<BatchGetItemOutputTransformInput>referenceWithInitializer(BatchGetItemOutputTransformInput.class, () -> BatchGetItemOutputTransformInput.Default());
  public static dafny.TypeDescriptor<BatchGetItemOutputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<BatchGetItemOutputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final BatchGetItemOutputTransformInput theDefault = BatchGetItemOutputTransformInput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemOutput.Default(), software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemInput.Default());
  public static BatchGetItemOutputTransformInput Default() {
    return theDefault;
  }
  public static BatchGetItemOutputTransformInput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemInput originalInput) {
    return new BatchGetItemOutputTransformInput(sdkOutput, originalInput);
  }
  public static BatchGetItemOutputTransformInput create_BatchGetItemOutputTransformInput(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemInput originalInput) {
    return create(sdkOutput, originalInput);
  }
  public boolean is_BatchGetItemOutputTransformInput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemOutput dtor_sdkOutput() {
    return this._sdkOutput;
  }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemInput dtor_originalInput() {
    return this._originalInput;
  }
}
