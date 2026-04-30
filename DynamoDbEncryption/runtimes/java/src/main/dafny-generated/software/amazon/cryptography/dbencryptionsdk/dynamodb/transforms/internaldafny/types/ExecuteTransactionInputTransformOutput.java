// Class ExecuteTransactionInputTransformOutput
// Dafny class ExecuteTransactionInputTransformOutput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class ExecuteTransactionInputTransformOutput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionInput _transformedInput;
  public ExecuteTransactionInputTransformOutput (software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionInput transformedInput) {
    this._transformedInput = transformedInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    ExecuteTransactionInputTransformOutput o = (ExecuteTransactionInputTransformOutput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ExecuteTransactionInputTransformOutput.ExecuteTransactionInputTransformOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._transformedInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<ExecuteTransactionInputTransformOutput> _TYPE = dafny.TypeDescriptor.<ExecuteTransactionInputTransformOutput>referenceWithInitializer(ExecuteTransactionInputTransformOutput.class, () -> ExecuteTransactionInputTransformOutput.Default());
  public static dafny.TypeDescriptor<ExecuteTransactionInputTransformOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<ExecuteTransactionInputTransformOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final ExecuteTransactionInputTransformOutput theDefault = ExecuteTransactionInputTransformOutput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionInput.Default());
  public static ExecuteTransactionInputTransformOutput Default() {
    return theDefault;
  }
  public static ExecuteTransactionInputTransformOutput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionInput transformedInput) {
    return new ExecuteTransactionInputTransformOutput(transformedInput);
  }
  public static ExecuteTransactionInputTransformOutput create_ExecuteTransactionInputTransformOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionInput transformedInput) {
    return create(transformedInput);
  }
  public boolean is_ExecuteTransactionInputTransformOutput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionInput dtor_transformedInput() {
    return this._transformedInput;
  }
}
