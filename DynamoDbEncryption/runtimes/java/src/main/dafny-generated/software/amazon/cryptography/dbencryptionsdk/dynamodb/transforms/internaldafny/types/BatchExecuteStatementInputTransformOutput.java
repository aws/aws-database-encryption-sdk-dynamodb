// Class BatchExecuteStatementInputTransformOutput
// Dafny class BatchExecuteStatementInputTransformOutput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class BatchExecuteStatementInputTransformOutput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementInput _transformedInput;
  public BatchExecuteStatementInputTransformOutput (software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementInput transformedInput) {
    this._transformedInput = transformedInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    BatchExecuteStatementInputTransformOutput o = (BatchExecuteStatementInputTransformOutput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchExecuteStatementInputTransformOutput.BatchExecuteStatementInputTransformOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._transformedInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<BatchExecuteStatementInputTransformOutput> _TYPE = dafny.TypeDescriptor.<BatchExecuteStatementInputTransformOutput>referenceWithInitializer(BatchExecuteStatementInputTransformOutput.class, () -> BatchExecuteStatementInputTransformOutput.Default());
  public static dafny.TypeDescriptor<BatchExecuteStatementInputTransformOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<BatchExecuteStatementInputTransformOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final BatchExecuteStatementInputTransformOutput theDefault = BatchExecuteStatementInputTransformOutput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementInput.Default());
  public static BatchExecuteStatementInputTransformOutput Default() {
    return theDefault;
  }
  public static BatchExecuteStatementInputTransformOutput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementInput transformedInput) {
    return new BatchExecuteStatementInputTransformOutput(transformedInput);
  }
  public static BatchExecuteStatementInputTransformOutput create_BatchExecuteStatementInputTransformOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementInput transformedInput) {
    return create(transformedInput);
  }
  public boolean is_BatchExecuteStatementInputTransformOutput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementInput dtor_transformedInput() {
    return this._transformedInput;
  }
}
