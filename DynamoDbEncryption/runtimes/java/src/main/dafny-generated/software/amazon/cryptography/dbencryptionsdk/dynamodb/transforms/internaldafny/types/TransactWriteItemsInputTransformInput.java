// Class TransactWriteItemsInputTransformInput
// Dafny class TransactWriteItemsInputTransformInput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class TransactWriteItemsInputTransformInput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItemsInput _sdkInput;
  public TransactWriteItemsInputTransformInput (software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItemsInput sdkInput) {
    this._sdkInput = sdkInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    TransactWriteItemsInputTransformInput o = (TransactWriteItemsInputTransformInput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.TransactWriteItemsInputTransformInput.TransactWriteItemsInputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<TransactWriteItemsInputTransformInput> _TYPE = dafny.TypeDescriptor.<TransactWriteItemsInputTransformInput>referenceWithInitializer(TransactWriteItemsInputTransformInput.class, () -> TransactWriteItemsInputTransformInput.Default());
  public static dafny.TypeDescriptor<TransactWriteItemsInputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<TransactWriteItemsInputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final TransactWriteItemsInputTransformInput theDefault = TransactWriteItemsInputTransformInput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItemsInput.Default());
  public static TransactWriteItemsInputTransformInput Default() {
    return theDefault;
  }
  public static TransactWriteItemsInputTransformInput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItemsInput sdkInput) {
    return new TransactWriteItemsInputTransformInput(sdkInput);
  }
  public static TransactWriteItemsInputTransformInput create_TransactWriteItemsInputTransformInput(software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItemsInput sdkInput) {
    return create(sdkInput);
  }
  public boolean is_TransactWriteItemsInputTransformInput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItemsInput dtor_sdkInput() {
    return this._sdkInput;
  }
}
