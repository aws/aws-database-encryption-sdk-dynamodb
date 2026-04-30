// Class TransactGetItemsInputTransformInput
// Dafny class TransactGetItemsInputTransformInput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class TransactGetItemsInputTransformInput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItemsInput _sdkInput;
  public TransactGetItemsInputTransformInput (software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItemsInput sdkInput) {
    this._sdkInput = sdkInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    TransactGetItemsInputTransformInput o = (TransactGetItemsInputTransformInput)other;
    return true && java.util.Objects.equals(this._sdkInput, o._sdkInput);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._sdkInput);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.TransactGetItemsInputTransformInput.TransactGetItemsInputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<TransactGetItemsInputTransformInput> _TYPE = dafny.TypeDescriptor.<TransactGetItemsInputTransformInput>referenceWithInitializer(TransactGetItemsInputTransformInput.class, () -> TransactGetItemsInputTransformInput.Default());
  public static dafny.TypeDescriptor<TransactGetItemsInputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<TransactGetItemsInputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final TransactGetItemsInputTransformInput theDefault = TransactGetItemsInputTransformInput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItemsInput.Default());
  public static TransactGetItemsInputTransformInput Default() {
    return theDefault;
  }
  public static TransactGetItemsInputTransformInput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItemsInput sdkInput) {
    return new TransactGetItemsInputTransformInput(sdkInput);
  }
  public static TransactGetItemsInputTransformInput create_TransactGetItemsInputTransformInput(software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItemsInput sdkInput) {
    return create(sdkInput);
  }
  public boolean is_TransactGetItemsInputTransformInput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItemsInput dtor_sdkInput() {
    return this._sdkInput;
  }
}
