// Class TransactWriteItemsInputTransformOutput
// Dafny class TransactWriteItemsInputTransformOutput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class TransactWriteItemsInputTransformOutput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItemsInput _transformedInput;
  public TransactWriteItemsInputTransformOutput (software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItemsInput transformedInput) {
    this._transformedInput = transformedInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    TransactWriteItemsInputTransformOutput o = (TransactWriteItemsInputTransformOutput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.TransactWriteItemsInputTransformOutput.TransactWriteItemsInputTransformOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._transformedInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<TransactWriteItemsInputTransformOutput> _TYPE = dafny.TypeDescriptor.<TransactWriteItemsInputTransformOutput>referenceWithInitializer(TransactWriteItemsInputTransformOutput.class, () -> TransactWriteItemsInputTransformOutput.Default());
  public static dafny.TypeDescriptor<TransactWriteItemsInputTransformOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<TransactWriteItemsInputTransformOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final TransactWriteItemsInputTransformOutput theDefault = TransactWriteItemsInputTransformOutput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItemsInput.Default());
  public static TransactWriteItemsInputTransformOutput Default() {
    return theDefault;
  }
  public static TransactWriteItemsInputTransformOutput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItemsInput transformedInput) {
    return new TransactWriteItemsInputTransformOutput(transformedInput);
  }
  public static TransactWriteItemsInputTransformOutput create_TransactWriteItemsInputTransformOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItemsInput transformedInput) {
    return create(transformedInput);
  }
  public boolean is_TransactWriteItemsInputTransformOutput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItemsInput dtor_transformedInput() {
    return this._transformedInput;
  }
}
