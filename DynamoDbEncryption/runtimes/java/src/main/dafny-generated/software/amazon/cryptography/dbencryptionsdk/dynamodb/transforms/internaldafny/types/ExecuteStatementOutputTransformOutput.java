// Class ExecuteStatementOutputTransformOutput
// Dafny class ExecuteStatementOutputTransformOutput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class ExecuteStatementOutputTransformOutput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementOutput _transformedOutput;
  public ExecuteStatementOutputTransformOutput (software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementOutput transformedOutput) {
    this._transformedOutput = transformedOutput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    ExecuteStatementOutputTransformOutput o = (ExecuteStatementOutputTransformOutput)other;
    return true && java.util.Objects.equals(this._transformedOutput, o._transformedOutput);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._transformedOutput);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ExecuteStatementOutputTransformOutput.ExecuteStatementOutputTransformOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._transformedOutput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<ExecuteStatementOutputTransformOutput> _TYPE = dafny.TypeDescriptor.<ExecuteStatementOutputTransformOutput>referenceWithInitializer(ExecuteStatementOutputTransformOutput.class, () -> ExecuteStatementOutputTransformOutput.Default());
  public static dafny.TypeDescriptor<ExecuteStatementOutputTransformOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<ExecuteStatementOutputTransformOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final ExecuteStatementOutputTransformOutput theDefault = ExecuteStatementOutputTransformOutput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementOutput.Default());
  public static ExecuteStatementOutputTransformOutput Default() {
    return theDefault;
  }
  public static ExecuteStatementOutputTransformOutput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementOutput transformedOutput) {
    return new ExecuteStatementOutputTransformOutput(transformedOutput);
  }
  public static ExecuteStatementOutputTransformOutput create_ExecuteStatementOutputTransformOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementOutput transformedOutput) {
    return create(transformedOutput);
  }
  public boolean is_ExecuteStatementOutputTransformOutput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementOutput dtor_transformedOutput() {
    return this._transformedOutput;
  }
}
