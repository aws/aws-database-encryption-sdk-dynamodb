// Class BatchWriteItemOutputTransformInput
// Dafny class BatchWriteItemOutputTransformInput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class BatchWriteItemOutputTransformInput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemOutput _sdkOutput;
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemInput _originalInput;
  public BatchWriteItemOutputTransformInput (software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemInput originalInput) {
    this._sdkOutput = sdkOutput;
    this._originalInput = originalInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    BatchWriteItemOutputTransformInput o = (BatchWriteItemOutputTransformInput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchWriteItemOutputTransformInput.BatchWriteItemOutputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkOutput));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._originalInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<BatchWriteItemOutputTransformInput> _TYPE = dafny.TypeDescriptor.<BatchWriteItemOutputTransformInput>referenceWithInitializer(BatchWriteItemOutputTransformInput.class, () -> BatchWriteItemOutputTransformInput.Default());
  public static dafny.TypeDescriptor<BatchWriteItemOutputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<BatchWriteItemOutputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final BatchWriteItemOutputTransformInput theDefault = BatchWriteItemOutputTransformInput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemOutput.Default(), software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemInput.Default());
  public static BatchWriteItemOutputTransformInput Default() {
    return theDefault;
  }
  public static BatchWriteItemOutputTransformInput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemInput originalInput) {
    return new BatchWriteItemOutputTransformInput(sdkOutput, originalInput);
  }
  public static BatchWriteItemOutputTransformInput create_BatchWriteItemOutputTransformInput(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemInput originalInput) {
    return create(sdkOutput, originalInput);
  }
  public boolean is_BatchWriteItemOutputTransformInput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemOutput dtor_sdkOutput() {
    return this._sdkOutput;
  }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemInput dtor_originalInput() {
    return this._originalInput;
  }
}
