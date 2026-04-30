// Class BatchWriteItemInputTransformOutput
// Dafny class BatchWriteItemInputTransformOutput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class BatchWriteItemInputTransformOutput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemInput _transformedInput;
  public BatchWriteItemInputTransformOutput (software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemInput transformedInput) {
    this._transformedInput = transformedInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    BatchWriteItemInputTransformOutput o = (BatchWriteItemInputTransformOutput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchWriteItemInputTransformOutput.BatchWriteItemInputTransformOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._transformedInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<BatchWriteItemInputTransformOutput> _TYPE = dafny.TypeDescriptor.<BatchWriteItemInputTransformOutput>referenceWithInitializer(BatchWriteItemInputTransformOutput.class, () -> BatchWriteItemInputTransformOutput.Default());
  public static dafny.TypeDescriptor<BatchWriteItemInputTransformOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<BatchWriteItemInputTransformOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final BatchWriteItemInputTransformOutput theDefault = BatchWriteItemInputTransformOutput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemInput.Default());
  public static BatchWriteItemInputTransformOutput Default() {
    return theDefault;
  }
  public static BatchWriteItemInputTransformOutput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemInput transformedInput) {
    return new BatchWriteItemInputTransformOutput(transformedInput);
  }
  public static BatchWriteItemInputTransformOutput create_BatchWriteItemInputTransformOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemInput transformedInput) {
    return create(transformedInput);
  }
  public boolean is_BatchWriteItemInputTransformOutput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemInput dtor_transformedInput() {
    return this._transformedInput;
  }
}
