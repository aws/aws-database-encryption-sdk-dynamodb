// Class ExecuteStatementInputTransformOutput
// Dafny class ExecuteStatementInputTransformOutput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class ExecuteStatementInputTransformOutput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementInput _transformedInput;
  public ExecuteStatementInputTransformOutput (software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementInput transformedInput) {
    this._transformedInput = transformedInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    ExecuteStatementInputTransformOutput o = (ExecuteStatementInputTransformOutput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ExecuteStatementInputTransformOutput.ExecuteStatementInputTransformOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._transformedInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<ExecuteStatementInputTransformOutput> _TYPE = dafny.TypeDescriptor.<ExecuteStatementInputTransformOutput>referenceWithInitializer(ExecuteStatementInputTransformOutput.class, () -> ExecuteStatementInputTransformOutput.Default());
  public static dafny.TypeDescriptor<ExecuteStatementInputTransformOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<ExecuteStatementInputTransformOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final ExecuteStatementInputTransformOutput theDefault = ExecuteStatementInputTransformOutput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementInput.Default());
  public static ExecuteStatementInputTransformOutput Default() {
    return theDefault;
  }
  public static ExecuteStatementInputTransformOutput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementInput transformedInput) {
    return new ExecuteStatementInputTransformOutput(transformedInput);
  }
  public static ExecuteStatementInputTransformOutput create_ExecuteStatementInputTransformOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementInput transformedInput) {
    return create(transformedInput);
  }
  public boolean is_ExecuteStatementInputTransformOutput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementInput dtor_transformedInput() {
    return this._transformedInput;
  }
}
