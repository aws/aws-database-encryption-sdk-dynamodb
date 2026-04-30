// Class BatchGetItemInputTransformOutput
// Dafny class BatchGetItemInputTransformOutput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class BatchGetItemInputTransformOutput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemInput _transformedInput;
  public BatchGetItemInputTransformOutput (software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemInput transformedInput) {
    this._transformedInput = transformedInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    BatchGetItemInputTransformOutput o = (BatchGetItemInputTransformOutput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchGetItemInputTransformOutput.BatchGetItemInputTransformOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._transformedInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<BatchGetItemInputTransformOutput> _TYPE = dafny.TypeDescriptor.<BatchGetItemInputTransformOutput>referenceWithInitializer(BatchGetItemInputTransformOutput.class, () -> BatchGetItemInputTransformOutput.Default());
  public static dafny.TypeDescriptor<BatchGetItemInputTransformOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<BatchGetItemInputTransformOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final BatchGetItemInputTransformOutput theDefault = BatchGetItemInputTransformOutput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemInput.Default());
  public static BatchGetItemInputTransformOutput Default() {
    return theDefault;
  }
  public static BatchGetItemInputTransformOutput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemInput transformedInput) {
    return new BatchGetItemInputTransformOutput(transformedInput);
  }
  public static BatchGetItemInputTransformOutput create_BatchGetItemInputTransformOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemInput transformedInput) {
    return create(transformedInput);
  }
  public boolean is_BatchGetItemInputTransformOutput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemInput dtor_transformedInput() {
    return this._transformedInput;
  }
}
