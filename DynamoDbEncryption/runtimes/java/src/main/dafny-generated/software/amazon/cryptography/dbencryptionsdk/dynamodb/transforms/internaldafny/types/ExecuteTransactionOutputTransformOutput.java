// Class ExecuteTransactionOutputTransformOutput
// Dafny class ExecuteTransactionOutputTransformOutput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class ExecuteTransactionOutputTransformOutput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionOutput _transformedOutput;
  public ExecuteTransactionOutputTransformOutput (software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionOutput transformedOutput) {
    this._transformedOutput = transformedOutput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    ExecuteTransactionOutputTransformOutput o = (ExecuteTransactionOutputTransformOutput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ExecuteTransactionOutputTransformOutput.ExecuteTransactionOutputTransformOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._transformedOutput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<ExecuteTransactionOutputTransformOutput> _TYPE = dafny.TypeDescriptor.<ExecuteTransactionOutputTransformOutput>referenceWithInitializer(ExecuteTransactionOutputTransformOutput.class, () -> ExecuteTransactionOutputTransformOutput.Default());
  public static dafny.TypeDescriptor<ExecuteTransactionOutputTransformOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<ExecuteTransactionOutputTransformOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final ExecuteTransactionOutputTransformOutput theDefault = ExecuteTransactionOutputTransformOutput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionOutput.Default());
  public static ExecuteTransactionOutputTransformOutput Default() {
    return theDefault;
  }
  public static ExecuteTransactionOutputTransformOutput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionOutput transformedOutput) {
    return new ExecuteTransactionOutputTransformOutput(transformedOutput);
  }
  public static ExecuteTransactionOutputTransformOutput create_ExecuteTransactionOutputTransformOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionOutput transformedOutput) {
    return create(transformedOutput);
  }
  public boolean is_ExecuteTransactionOutputTransformOutput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionOutput dtor_transformedOutput() {
    return this._transformedOutput;
  }
}
