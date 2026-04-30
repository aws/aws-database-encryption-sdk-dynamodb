// Class BatchExecuteStatementOutputTransformOutput
// Dafny class BatchExecuteStatementOutputTransformOutput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class BatchExecuteStatementOutputTransformOutput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementOutput _transformedOutput;
  public BatchExecuteStatementOutputTransformOutput (software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementOutput transformedOutput) {
    this._transformedOutput = transformedOutput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    BatchExecuteStatementOutputTransformOutput o = (BatchExecuteStatementOutputTransformOutput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchExecuteStatementOutputTransformOutput.BatchExecuteStatementOutputTransformOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._transformedOutput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<BatchExecuteStatementOutputTransformOutput> _TYPE = dafny.TypeDescriptor.<BatchExecuteStatementOutputTransformOutput>referenceWithInitializer(BatchExecuteStatementOutputTransformOutput.class, () -> BatchExecuteStatementOutputTransformOutput.Default());
  public static dafny.TypeDescriptor<BatchExecuteStatementOutputTransformOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<BatchExecuteStatementOutputTransformOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final BatchExecuteStatementOutputTransformOutput theDefault = BatchExecuteStatementOutputTransformOutput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementOutput.Default());
  public static BatchExecuteStatementOutputTransformOutput Default() {
    return theDefault;
  }
  public static BatchExecuteStatementOutputTransformOutput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementOutput transformedOutput) {
    return new BatchExecuteStatementOutputTransformOutput(transformedOutput);
  }
  public static BatchExecuteStatementOutputTransformOutput create_BatchExecuteStatementOutputTransformOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementOutput transformedOutput) {
    return create(transformedOutput);
  }
  public boolean is_BatchExecuteStatementOutputTransformOutput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementOutput dtor_transformedOutput() {
    return this._transformedOutput;
  }
}
