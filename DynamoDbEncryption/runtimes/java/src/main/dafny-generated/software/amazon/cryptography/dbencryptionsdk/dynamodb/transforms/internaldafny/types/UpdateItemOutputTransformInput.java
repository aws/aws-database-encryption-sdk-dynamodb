// Class UpdateItemOutputTransformInput
// Dafny class UpdateItemOutputTransformInput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class UpdateItemOutputTransformInput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.UpdateItemOutput _sdkOutput;
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.UpdateItemInput _originalInput;
  public UpdateItemOutputTransformInput (software.amazon.cryptography.services.dynamodb.internaldafny.types.UpdateItemOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.UpdateItemInput originalInput) {
    this._sdkOutput = sdkOutput;
    this._originalInput = originalInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    UpdateItemOutputTransformInput o = (UpdateItemOutputTransformInput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.UpdateItemOutputTransformInput.UpdateItemOutputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkOutput));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._originalInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<UpdateItemOutputTransformInput> _TYPE = dafny.TypeDescriptor.<UpdateItemOutputTransformInput>referenceWithInitializer(UpdateItemOutputTransformInput.class, () -> UpdateItemOutputTransformInput.Default());
  public static dafny.TypeDescriptor<UpdateItemOutputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<UpdateItemOutputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final UpdateItemOutputTransformInput theDefault = UpdateItemOutputTransformInput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.UpdateItemOutput.Default(), software.amazon.cryptography.services.dynamodb.internaldafny.types.UpdateItemInput.Default());
  public static UpdateItemOutputTransformInput Default() {
    return theDefault;
  }
  public static UpdateItemOutputTransformInput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.UpdateItemOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.UpdateItemInput originalInput) {
    return new UpdateItemOutputTransformInput(sdkOutput, originalInput);
  }
  public static UpdateItemOutputTransformInput create_UpdateItemOutputTransformInput(software.amazon.cryptography.services.dynamodb.internaldafny.types.UpdateItemOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.UpdateItemInput originalInput) {
    return create(sdkOutput, originalInput);
  }
  public boolean is_UpdateItemOutputTransformInput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.UpdateItemOutput dtor_sdkOutput() {
    return this._sdkOutput;
  }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.UpdateItemInput dtor_originalInput() {
    return this._originalInput;
  }
}
