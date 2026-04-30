// Class DeleteItemOutputTransformInput
// Dafny class DeleteItemOutputTransformInput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class DeleteItemOutputTransformInput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteItemOutput _sdkOutput;
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteItemInput _originalInput;
  public DeleteItemOutputTransformInput (software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteItemOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteItemInput originalInput) {
    this._sdkOutput = sdkOutput;
    this._originalInput = originalInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    DeleteItemOutputTransformInput o = (DeleteItemOutputTransformInput)other;
    return true && java.util.Objects.equals(this._sdkOutput, o._sdkOutput) && java.util.Objects.equals(this._originalInput, o._originalInput);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._sdkOutput);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._originalInput);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.DeleteItemOutputTransformInput.DeleteItemOutputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkOutput));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._originalInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<DeleteItemOutputTransformInput> _TYPE = dafny.TypeDescriptor.<DeleteItemOutputTransformInput>referenceWithInitializer(DeleteItemOutputTransformInput.class, () -> DeleteItemOutputTransformInput.Default());
  public static dafny.TypeDescriptor<DeleteItemOutputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<DeleteItemOutputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final DeleteItemOutputTransformInput theDefault = DeleteItemOutputTransformInput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteItemOutput.Default(), software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteItemInput.Default());
  public static DeleteItemOutputTransformInput Default() {
    return theDefault;
  }
  public static DeleteItemOutputTransformInput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteItemOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteItemInput originalInput) {
    return new DeleteItemOutputTransformInput(sdkOutput, originalInput);
  }
  public static DeleteItemOutputTransformInput create_DeleteItemOutputTransformInput(software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteItemOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteItemInput originalInput) {
    return create(sdkOutput, originalInput);
  }
  public boolean is_DeleteItemOutputTransformInput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteItemOutput dtor_sdkOutput() {
    return this._sdkOutput;
  }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteItemInput dtor_originalInput() {
    return this._originalInput;
  }
}
