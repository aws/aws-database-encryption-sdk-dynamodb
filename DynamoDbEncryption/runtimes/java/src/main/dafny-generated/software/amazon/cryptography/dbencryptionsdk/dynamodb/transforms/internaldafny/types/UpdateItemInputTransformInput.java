// Class UpdateItemInputTransformInput
// Dafny class UpdateItemInputTransformInput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class UpdateItemInputTransformInput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.UpdateItemInput _sdkInput;
  public UpdateItemInputTransformInput (software.amazon.cryptography.services.dynamodb.internaldafny.types.UpdateItemInput sdkInput) {
    this._sdkInput = sdkInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    UpdateItemInputTransformInput o = (UpdateItemInputTransformInput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.UpdateItemInputTransformInput.UpdateItemInputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<UpdateItemInputTransformInput> _TYPE = dafny.TypeDescriptor.<UpdateItemInputTransformInput>referenceWithInitializer(UpdateItemInputTransformInput.class, () -> UpdateItemInputTransformInput.Default());
  public static dafny.TypeDescriptor<UpdateItemInputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<UpdateItemInputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final UpdateItemInputTransformInput theDefault = UpdateItemInputTransformInput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.UpdateItemInput.Default());
  public static UpdateItemInputTransformInput Default() {
    return theDefault;
  }
  public static UpdateItemInputTransformInput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.UpdateItemInput sdkInput) {
    return new UpdateItemInputTransformInput(sdkInput);
  }
  public static UpdateItemInputTransformInput create_UpdateItemInputTransformInput(software.amazon.cryptography.services.dynamodb.internaldafny.types.UpdateItemInput sdkInput) {
    return create(sdkInput);
  }
  public boolean is_UpdateItemInputTransformInput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.UpdateItemInput dtor_sdkInput() {
    return this._sdkInput;
  }
}
