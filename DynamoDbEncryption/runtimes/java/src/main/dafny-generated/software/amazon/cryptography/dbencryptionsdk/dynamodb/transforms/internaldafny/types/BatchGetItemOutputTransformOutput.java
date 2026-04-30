// Class BatchGetItemOutputTransformOutput
// Dafny class BatchGetItemOutputTransformOutput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class BatchGetItemOutputTransformOutput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemOutput _transformedOutput;
  public BatchGetItemOutputTransformOutput (software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemOutput transformedOutput) {
    this._transformedOutput = transformedOutput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    BatchGetItemOutputTransformOutput o = (BatchGetItemOutputTransformOutput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchGetItemOutputTransformOutput.BatchGetItemOutputTransformOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._transformedOutput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<BatchGetItemOutputTransformOutput> _TYPE = dafny.TypeDescriptor.<BatchGetItemOutputTransformOutput>referenceWithInitializer(BatchGetItemOutputTransformOutput.class, () -> BatchGetItemOutputTransformOutput.Default());
  public static dafny.TypeDescriptor<BatchGetItemOutputTransformOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<BatchGetItemOutputTransformOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final BatchGetItemOutputTransformOutput theDefault = BatchGetItemOutputTransformOutput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemOutput.Default());
  public static BatchGetItemOutputTransformOutput Default() {
    return theDefault;
  }
  public static BatchGetItemOutputTransformOutput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemOutput transformedOutput) {
    return new BatchGetItemOutputTransformOutput(transformedOutput);
  }
  public static BatchGetItemOutputTransformOutput create_BatchGetItemOutputTransformOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemOutput transformedOutput) {
    return create(transformedOutput);
  }
  public boolean is_BatchGetItemOutputTransformOutput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemOutput dtor_transformedOutput() {
    return this._transformedOutput;
  }
}
