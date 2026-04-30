// Class TransactGetItemsInputTransformOutput
// Dafny class TransactGetItemsInputTransformOutput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class TransactGetItemsInputTransformOutput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItemsInput _transformedInput;
  public TransactGetItemsInputTransformOutput (software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItemsInput transformedInput) {
    this._transformedInput = transformedInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    TransactGetItemsInputTransformOutput o = (TransactGetItemsInputTransformOutput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.TransactGetItemsInputTransformOutput.TransactGetItemsInputTransformOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._transformedInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<TransactGetItemsInputTransformOutput> _TYPE = dafny.TypeDescriptor.<TransactGetItemsInputTransformOutput>referenceWithInitializer(TransactGetItemsInputTransformOutput.class, () -> TransactGetItemsInputTransformOutput.Default());
  public static dafny.TypeDescriptor<TransactGetItemsInputTransformOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<TransactGetItemsInputTransformOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final TransactGetItemsInputTransformOutput theDefault = TransactGetItemsInputTransformOutput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItemsInput.Default());
  public static TransactGetItemsInputTransformOutput Default() {
    return theDefault;
  }
  public static TransactGetItemsInputTransformOutput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItemsInput transformedInput) {
    return new TransactGetItemsInputTransformOutput(transformedInput);
  }
  public static TransactGetItemsInputTransformOutput create_TransactGetItemsInputTransformOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItemsInput transformedInput) {
    return create(transformedInput);
  }
  public boolean is_TransactGetItemsInputTransformOutput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItemsInput dtor_transformedInput() {
    return this._transformedInput;
  }
}
