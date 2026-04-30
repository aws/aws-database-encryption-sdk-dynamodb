// Class DeleteItemInputTransformInput
// Dafny class DeleteItemInputTransformInput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class DeleteItemInputTransformInput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteItemInput _sdkInput;
  public DeleteItemInputTransformInput (software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteItemInput sdkInput) {
    this._sdkInput = sdkInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    DeleteItemInputTransformInput o = (DeleteItemInputTransformInput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.DeleteItemInputTransformInput.DeleteItemInputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<DeleteItemInputTransformInput> _TYPE = dafny.TypeDescriptor.<DeleteItemInputTransformInput>referenceWithInitializer(DeleteItemInputTransformInput.class, () -> DeleteItemInputTransformInput.Default());
  public static dafny.TypeDescriptor<DeleteItemInputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<DeleteItemInputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final DeleteItemInputTransformInput theDefault = DeleteItemInputTransformInput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteItemInput.Default());
  public static DeleteItemInputTransformInput Default() {
    return theDefault;
  }
  public static DeleteItemInputTransformInput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteItemInput sdkInput) {
    return new DeleteItemInputTransformInput(sdkInput);
  }
  public static DeleteItemInputTransformInput create_DeleteItemInputTransformInput(software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteItemInput sdkInput) {
    return create(sdkInput);
  }
  public boolean is_DeleteItemInputTransformInput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteItemInput dtor_sdkInput() {
    return this._sdkInput;
  }
}
