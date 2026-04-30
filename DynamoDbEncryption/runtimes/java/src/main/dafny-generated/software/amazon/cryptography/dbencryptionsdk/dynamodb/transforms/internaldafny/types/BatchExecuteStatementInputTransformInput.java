// Class BatchExecuteStatementInputTransformInput
// Dafny class BatchExecuteStatementInputTransformInput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class BatchExecuteStatementInputTransformInput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementInput _sdkInput;
  public BatchExecuteStatementInputTransformInput (software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementInput sdkInput) {
    this._sdkInput = sdkInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    BatchExecuteStatementInputTransformInput o = (BatchExecuteStatementInputTransformInput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.BatchExecuteStatementInputTransformInput.BatchExecuteStatementInputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<BatchExecuteStatementInputTransformInput> _TYPE = dafny.TypeDescriptor.<BatchExecuteStatementInputTransformInput>referenceWithInitializer(BatchExecuteStatementInputTransformInput.class, () -> BatchExecuteStatementInputTransformInput.Default());
  public static dafny.TypeDescriptor<BatchExecuteStatementInputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<BatchExecuteStatementInputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final BatchExecuteStatementInputTransformInput theDefault = BatchExecuteStatementInputTransformInput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementInput.Default());
  public static BatchExecuteStatementInputTransformInput Default() {
    return theDefault;
  }
  public static BatchExecuteStatementInputTransformInput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementInput sdkInput) {
    return new BatchExecuteStatementInputTransformInput(sdkInput);
  }
  public static BatchExecuteStatementInputTransformInput create_BatchExecuteStatementInputTransformInput(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementInput sdkInput) {
    return create(sdkInput);
  }
  public boolean is_BatchExecuteStatementInputTransformInput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementInput dtor_sdkInput() {
    return this._sdkInput;
  }
}
