// Class BatchGetItemInputTransformInput
// Dafny class BatchGetItemInputTransformInput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class BatchGetItemInputTransformInput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemInput _sdkInput;
  public BatchGetItemInputTransformInput (software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemInput sdkInput) {
    this._sdkInput = sdkInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    BatchGetItemInputTransformInput o = (BatchGetItemInputTransformInput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchGetItemInputTransformInput.BatchGetItemInputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<BatchGetItemInputTransformInput> _TYPE = dafny.TypeDescriptor.<BatchGetItemInputTransformInput>referenceWithInitializer(BatchGetItemInputTransformInput.class, () -> BatchGetItemInputTransformInput.Default());
  public static dafny.TypeDescriptor<BatchGetItemInputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<BatchGetItemInputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final BatchGetItemInputTransformInput theDefault = BatchGetItemInputTransformInput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemInput.Default());
  public static BatchGetItemInputTransformInput Default() {
    return theDefault;
  }
  public static BatchGetItemInputTransformInput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemInput sdkInput) {
    return new BatchGetItemInputTransformInput(sdkInput);
  }
  public static BatchGetItemInputTransformInput create_BatchGetItemInputTransformInput(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemInput sdkInput) {
    return create(sdkInput);
  }
  public boolean is_BatchGetItemInputTransformInput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemInput dtor_sdkInput() {
    return this._sdkInput;
  }
}
