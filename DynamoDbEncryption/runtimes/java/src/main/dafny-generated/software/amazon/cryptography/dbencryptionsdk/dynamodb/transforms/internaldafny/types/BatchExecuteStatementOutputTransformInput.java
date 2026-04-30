// Class BatchExecuteStatementOutputTransformInput
// Dafny class BatchExecuteStatementOutputTransformInput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class BatchExecuteStatementOutputTransformInput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementOutput _sdkOutput;
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementInput _originalInput;
  public BatchExecuteStatementOutputTransformInput (software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementInput originalInput) {
    this._sdkOutput = sdkOutput;
    this._originalInput = originalInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    BatchExecuteStatementOutputTransformInput o = (BatchExecuteStatementOutputTransformInput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchExecuteStatementOutputTransformInput.BatchExecuteStatementOutputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkOutput));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._originalInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<BatchExecuteStatementOutputTransformInput> _TYPE = dafny.TypeDescriptor.<BatchExecuteStatementOutputTransformInput>referenceWithInitializer(BatchExecuteStatementOutputTransformInput.class, () -> BatchExecuteStatementOutputTransformInput.Default());
  public static dafny.TypeDescriptor<BatchExecuteStatementOutputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<BatchExecuteStatementOutputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final BatchExecuteStatementOutputTransformInput theDefault = BatchExecuteStatementOutputTransformInput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementOutput.Default(), software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementInput.Default());
  public static BatchExecuteStatementOutputTransformInput Default() {
    return theDefault;
  }
  public static BatchExecuteStatementOutputTransformInput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementInput originalInput) {
    return new BatchExecuteStatementOutputTransformInput(sdkOutput, originalInput);
  }
  public static BatchExecuteStatementOutputTransformInput create_BatchExecuteStatementOutputTransformInput(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementInput originalInput) {
    return create(sdkOutput, originalInput);
  }
  public boolean is_BatchExecuteStatementOutputTransformInput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementOutput dtor_sdkOutput() {
    return this._sdkOutput;
  }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementInput dtor_originalInput() {
    return this._originalInput;
  }
}
