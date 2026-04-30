// Class UpdateItemInputTransformOutput
// Dafny class UpdateItemInputTransformOutput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class UpdateItemInputTransformOutput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.UpdateItemInput _transformedInput;
  public UpdateItemInputTransformOutput (software.amazon.cryptography.services.dynamodb.internaldafny.types.UpdateItemInput transformedInput) {
    this._transformedInput = transformedInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    UpdateItemInputTransformOutput o = (UpdateItemInputTransformOutput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.UpdateItemInputTransformOutput.UpdateItemInputTransformOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._transformedInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<UpdateItemInputTransformOutput> _TYPE = dafny.TypeDescriptor.<UpdateItemInputTransformOutput>referenceWithInitializer(UpdateItemInputTransformOutput.class, () -> UpdateItemInputTransformOutput.Default());
  public static dafny.TypeDescriptor<UpdateItemInputTransformOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<UpdateItemInputTransformOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final UpdateItemInputTransformOutput theDefault = UpdateItemInputTransformOutput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.UpdateItemInput.Default());
  public static UpdateItemInputTransformOutput Default() {
    return theDefault;
  }
  public static UpdateItemInputTransformOutput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.UpdateItemInput transformedInput) {
    return new UpdateItemInputTransformOutput(transformedInput);
  }
  public static UpdateItemInputTransformOutput create_UpdateItemInputTransformOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types.UpdateItemInput transformedInput) {
    return create(transformedInput);
  }
  public boolean is_UpdateItemInputTransformOutput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.UpdateItemInput dtor_transformedInput() {
    return this._transformedInput;
  }
}
