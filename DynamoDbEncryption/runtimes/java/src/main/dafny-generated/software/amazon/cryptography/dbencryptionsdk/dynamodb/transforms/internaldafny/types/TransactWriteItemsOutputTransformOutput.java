// Class TransactWriteItemsOutputTransformOutput
// Dafny class TransactWriteItemsOutputTransformOutput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class TransactWriteItemsOutputTransformOutput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItemsOutput _transformedOutput;
  public TransactWriteItemsOutputTransformOutput (software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItemsOutput transformedOutput) {
    this._transformedOutput = transformedOutput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    TransactWriteItemsOutputTransformOutput o = (TransactWriteItemsOutputTransformOutput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.TransactWriteItemsOutputTransformOutput.TransactWriteItemsOutputTransformOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._transformedOutput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<TransactWriteItemsOutputTransformOutput> _TYPE = dafny.TypeDescriptor.<TransactWriteItemsOutputTransformOutput>referenceWithInitializer(TransactWriteItemsOutputTransformOutput.class, () -> TransactWriteItemsOutputTransformOutput.Default());
  public static dafny.TypeDescriptor<TransactWriteItemsOutputTransformOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<TransactWriteItemsOutputTransformOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final TransactWriteItemsOutputTransformOutput theDefault = TransactWriteItemsOutputTransformOutput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItemsOutput.Default());
  public static TransactWriteItemsOutputTransformOutput Default() {
    return theDefault;
  }
  public static TransactWriteItemsOutputTransformOutput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItemsOutput transformedOutput) {
    return new TransactWriteItemsOutputTransformOutput(transformedOutput);
  }
  public static TransactWriteItemsOutputTransformOutput create_TransactWriteItemsOutputTransformOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItemsOutput transformedOutput) {
    return create(transformedOutput);
  }
  public boolean is_TransactWriteItemsOutputTransformOutput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItemsOutput dtor_transformedOutput() {
    return this._transformedOutput;
  }
}
