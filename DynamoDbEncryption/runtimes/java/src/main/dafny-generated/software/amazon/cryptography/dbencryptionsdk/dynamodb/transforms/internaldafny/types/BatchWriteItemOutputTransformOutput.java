// Class BatchWriteItemOutputTransformOutput
// Dafny class BatchWriteItemOutputTransformOutput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class BatchWriteItemOutputTransformOutput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemOutput _transformedOutput;
  public BatchWriteItemOutputTransformOutput (software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemOutput transformedOutput) {
    this._transformedOutput = transformedOutput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    BatchWriteItemOutputTransformOutput o = (BatchWriteItemOutputTransformOutput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchWriteItemOutputTransformOutput.BatchWriteItemOutputTransformOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._transformedOutput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<BatchWriteItemOutputTransformOutput> _TYPE = dafny.TypeDescriptor.<BatchWriteItemOutputTransformOutput>referenceWithInitializer(BatchWriteItemOutputTransformOutput.class, () -> BatchWriteItemOutputTransformOutput.Default());
  public static dafny.TypeDescriptor<BatchWriteItemOutputTransformOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<BatchWriteItemOutputTransformOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final BatchWriteItemOutputTransformOutput theDefault = BatchWriteItemOutputTransformOutput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemOutput.Default());
  public static BatchWriteItemOutputTransformOutput Default() {
    return theDefault;
  }
  public static BatchWriteItemOutputTransformOutput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemOutput transformedOutput) {
    return new BatchWriteItemOutputTransformOutput(transformedOutput);
  }
  public static BatchWriteItemOutputTransformOutput create_BatchWriteItemOutputTransformOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemOutput transformedOutput) {
    return create(transformedOutput);
  }
  public boolean is_BatchWriteItemOutputTransformOutput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemOutput dtor_transformedOutput() {
    return this._transformedOutput;
  }
}
