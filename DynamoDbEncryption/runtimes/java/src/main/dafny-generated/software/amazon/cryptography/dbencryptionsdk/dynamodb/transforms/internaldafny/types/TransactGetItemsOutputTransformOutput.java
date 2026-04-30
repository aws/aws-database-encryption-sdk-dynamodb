// Class TransactGetItemsOutputTransformOutput
// Dafny class TransactGetItemsOutputTransformOutput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class TransactGetItemsOutputTransformOutput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItemsOutput _transformedOutput;
  public TransactGetItemsOutputTransformOutput (software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItemsOutput transformedOutput) {
    this._transformedOutput = transformedOutput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    TransactGetItemsOutputTransformOutput o = (TransactGetItemsOutputTransformOutput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.TransactGetItemsOutputTransformOutput.TransactGetItemsOutputTransformOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._transformedOutput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<TransactGetItemsOutputTransformOutput> _TYPE = dafny.TypeDescriptor.<TransactGetItemsOutputTransformOutput>referenceWithInitializer(TransactGetItemsOutputTransformOutput.class, () -> TransactGetItemsOutputTransformOutput.Default());
  public static dafny.TypeDescriptor<TransactGetItemsOutputTransformOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<TransactGetItemsOutputTransformOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final TransactGetItemsOutputTransformOutput theDefault = TransactGetItemsOutputTransformOutput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItemsOutput.Default());
  public static TransactGetItemsOutputTransformOutput Default() {
    return theDefault;
  }
  public static TransactGetItemsOutputTransformOutput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItemsOutput transformedOutput) {
    return new TransactGetItemsOutputTransformOutput(transformedOutput);
  }
  public static TransactGetItemsOutputTransformOutput create_TransactGetItemsOutputTransformOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItemsOutput transformedOutput) {
    return create(transformedOutput);
  }
  public boolean is_TransactGetItemsOutputTransformOutput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItemsOutput dtor_transformedOutput() {
    return this._transformedOutput;
  }
}
