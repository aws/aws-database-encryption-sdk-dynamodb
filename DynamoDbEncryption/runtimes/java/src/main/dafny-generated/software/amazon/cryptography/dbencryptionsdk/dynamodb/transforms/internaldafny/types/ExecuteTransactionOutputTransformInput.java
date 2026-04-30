// Class ExecuteTransactionOutputTransformInput
// Dafny class ExecuteTransactionOutputTransformInput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class ExecuteTransactionOutputTransformInput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionOutput _sdkOutput;
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionInput _originalInput;
  public ExecuteTransactionOutputTransformInput (software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionInput originalInput) {
    this._sdkOutput = sdkOutput;
    this._originalInput = originalInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    ExecuteTransactionOutputTransformInput o = (ExecuteTransactionOutputTransformInput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ExecuteTransactionOutputTransformInput.ExecuteTransactionOutputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkOutput));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._originalInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<ExecuteTransactionOutputTransformInput> _TYPE = dafny.TypeDescriptor.<ExecuteTransactionOutputTransformInput>referenceWithInitializer(ExecuteTransactionOutputTransformInput.class, () -> ExecuteTransactionOutputTransformInput.Default());
  public static dafny.TypeDescriptor<ExecuteTransactionOutputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<ExecuteTransactionOutputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final ExecuteTransactionOutputTransformInput theDefault = ExecuteTransactionOutputTransformInput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionOutput.Default(), software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionInput.Default());
  public static ExecuteTransactionOutputTransformInput Default() {
    return theDefault;
  }
  public static ExecuteTransactionOutputTransformInput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionInput originalInput) {
    return new ExecuteTransactionOutputTransformInput(sdkOutput, originalInput);
  }
  public static ExecuteTransactionOutputTransformInput create_ExecuteTransactionOutputTransformInput(software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionInput originalInput) {
    return create(sdkOutput, originalInput);
  }
  public boolean is_ExecuteTransactionOutputTransformInput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionOutput dtor_sdkOutput() {
    return this._sdkOutput;
  }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionInput dtor_originalInput() {
    return this._originalInput;
  }
}
