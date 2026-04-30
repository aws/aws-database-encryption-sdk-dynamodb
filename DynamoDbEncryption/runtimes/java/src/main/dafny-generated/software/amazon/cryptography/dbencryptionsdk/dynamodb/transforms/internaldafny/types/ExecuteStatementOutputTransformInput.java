// Class ExecuteStatementOutputTransformInput
// Dafny class ExecuteStatementOutputTransformInput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class ExecuteStatementOutputTransformInput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementOutput _sdkOutput;
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementInput _originalInput;
  public ExecuteStatementOutputTransformInput (software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementInput originalInput) {
    this._sdkOutput = sdkOutput;
    this._originalInput = originalInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    ExecuteStatementOutputTransformInput o = (ExecuteStatementOutputTransformInput)other;
    return true && java.util.Objects.equals(this._sdkOutput, o._sdkOutput) && java.util.Objects.equals(this._originalInput, o._originalInput);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._sdkOutput);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._originalInput);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ExecuteStatementOutputTransformInput.ExecuteStatementOutputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkOutput));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._originalInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<ExecuteStatementOutputTransformInput> _TYPE = dafny.TypeDescriptor.<ExecuteStatementOutputTransformInput>referenceWithInitializer(ExecuteStatementOutputTransformInput.class, () -> ExecuteStatementOutputTransformInput.Default());
  public static dafny.TypeDescriptor<ExecuteStatementOutputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<ExecuteStatementOutputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final ExecuteStatementOutputTransformInput theDefault = ExecuteStatementOutputTransformInput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementOutput.Default(), software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementInput.Default());
  public static ExecuteStatementOutputTransformInput Default() {
    return theDefault;
  }
  public static ExecuteStatementOutputTransformInput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementInput originalInput) {
    return new ExecuteStatementOutputTransformInput(sdkOutput, originalInput);
  }
  public static ExecuteStatementOutputTransformInput create_ExecuteStatementOutputTransformInput(software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementInput originalInput) {
    return create(sdkOutput, originalInput);
  }
  public boolean is_ExecuteStatementOutputTransformInput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementOutput dtor_sdkOutput() {
    return this._sdkOutput;
  }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementInput dtor_originalInput() {
    return this._originalInput;
  }
}
