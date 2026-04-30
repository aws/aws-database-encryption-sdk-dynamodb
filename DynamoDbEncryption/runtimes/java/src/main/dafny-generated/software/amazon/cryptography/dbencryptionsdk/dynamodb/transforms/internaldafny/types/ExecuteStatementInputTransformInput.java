// Class ExecuteStatementInputTransformInput
// Dafny class ExecuteStatementInputTransformInput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class ExecuteStatementInputTransformInput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementInput _sdkInput;
  public ExecuteStatementInputTransformInput (software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementInput sdkInput) {
    this._sdkInput = sdkInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    ExecuteStatementInputTransformInput o = (ExecuteStatementInputTransformInput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ExecuteStatementInputTransformInput.ExecuteStatementInputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<ExecuteStatementInputTransformInput> _TYPE = dafny.TypeDescriptor.<ExecuteStatementInputTransformInput>referenceWithInitializer(ExecuteStatementInputTransformInput.class, () -> ExecuteStatementInputTransformInput.Default());
  public static dafny.TypeDescriptor<ExecuteStatementInputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<ExecuteStatementInputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final ExecuteStatementInputTransformInput theDefault = ExecuteStatementInputTransformInput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementInput.Default());
  public static ExecuteStatementInputTransformInput Default() {
    return theDefault;
  }
  public static ExecuteStatementInputTransformInput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementInput sdkInput) {
    return new ExecuteStatementInputTransformInput(sdkInput);
  }
  public static ExecuteStatementInputTransformInput create_ExecuteStatementInputTransformInput(software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementInput sdkInput) {
    return create(sdkInput);
  }
  public boolean is_ExecuteStatementInputTransformInput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementInput dtor_sdkInput() {
    return this._sdkInput;
  }
}
