// Class ExecuteTransactionInputTransformInput
// Dafny class ExecuteTransactionInputTransformInput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class ExecuteTransactionInputTransformInput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionInput _sdkInput;
  public ExecuteTransactionInputTransformInput (software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionInput sdkInput) {
    this._sdkInput = sdkInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    ExecuteTransactionInputTransformInput o = (ExecuteTransactionInputTransformInput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ExecuteTransactionInputTransformInput.ExecuteTransactionInputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<ExecuteTransactionInputTransformInput> _TYPE = dafny.TypeDescriptor.<ExecuteTransactionInputTransformInput>referenceWithInitializer(ExecuteTransactionInputTransformInput.class, () -> ExecuteTransactionInputTransformInput.Default());
  public static dafny.TypeDescriptor<ExecuteTransactionInputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<ExecuteTransactionInputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final ExecuteTransactionInputTransformInput theDefault = ExecuteTransactionInputTransformInput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionInput.Default());
  public static ExecuteTransactionInputTransformInput Default() {
    return theDefault;
  }
  public static ExecuteTransactionInputTransformInput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionInput sdkInput) {
    return new ExecuteTransactionInputTransformInput(sdkInput);
  }
  public static ExecuteTransactionInputTransformInput create_ExecuteTransactionInputTransformInput(software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionInput sdkInput) {
    return create(sdkInput);
  }
  public boolean is_ExecuteTransactionInputTransformInput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionInput dtor_sdkInput() {
    return this._sdkInput;
  }
}
