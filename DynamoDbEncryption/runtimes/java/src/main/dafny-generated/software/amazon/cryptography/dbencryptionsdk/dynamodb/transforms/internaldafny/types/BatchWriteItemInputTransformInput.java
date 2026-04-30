// Class BatchWriteItemInputTransformInput
// Dafny class BatchWriteItemInputTransformInput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class BatchWriteItemInputTransformInput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemInput _sdkInput;
  public BatchWriteItemInputTransformInput (software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemInput sdkInput) {
    this._sdkInput = sdkInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    BatchWriteItemInputTransformInput o = (BatchWriteItemInputTransformInput)other;
    return true && java.util.Objects.equals(this._sdkInput, o._sdkInput);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._sdkInput);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchWriteItemInputTransformInput.BatchWriteItemInputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<BatchWriteItemInputTransformInput> _TYPE = dafny.TypeDescriptor.<BatchWriteItemInputTransformInput>referenceWithInitializer(BatchWriteItemInputTransformInput.class, () -> BatchWriteItemInputTransformInput.Default());
  public static dafny.TypeDescriptor<BatchWriteItemInputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<BatchWriteItemInputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final BatchWriteItemInputTransformInput theDefault = BatchWriteItemInputTransformInput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemInput.Default());
  public static BatchWriteItemInputTransformInput Default() {
    return theDefault;
  }
  public static BatchWriteItemInputTransformInput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemInput sdkInput) {
    return new BatchWriteItemInputTransformInput(sdkInput);
  }
  public static BatchWriteItemInputTransformInput create_BatchWriteItemInputTransformInput(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemInput sdkInput) {
    return create(sdkInput);
  }
  public boolean is_BatchWriteItemInputTransformInput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchWriteItemInput dtor_sdkInput() {
    return this._sdkInput;
  }
}
