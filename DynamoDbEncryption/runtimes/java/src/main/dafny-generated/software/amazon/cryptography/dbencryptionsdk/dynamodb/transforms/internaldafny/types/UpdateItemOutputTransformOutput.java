// Class UpdateItemOutputTransformOutput
// Dafny class UpdateItemOutputTransformOutput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class UpdateItemOutputTransformOutput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.UpdateItemOutput _transformedOutput;
  public UpdateItemOutputTransformOutput (software.amazon.cryptography.services.dynamodb.internaldafny.types.UpdateItemOutput transformedOutput) {
    this._transformedOutput = transformedOutput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    UpdateItemOutputTransformOutput o = (UpdateItemOutputTransformOutput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.UpdateItemOutputTransformOutput.UpdateItemOutputTransformOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._transformedOutput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<UpdateItemOutputTransformOutput> _TYPE = dafny.TypeDescriptor.<UpdateItemOutputTransformOutput>referenceWithInitializer(UpdateItemOutputTransformOutput.class, () -> UpdateItemOutputTransformOutput.Default());
  public static dafny.TypeDescriptor<UpdateItemOutputTransformOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<UpdateItemOutputTransformOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final UpdateItemOutputTransformOutput theDefault = UpdateItemOutputTransformOutput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.UpdateItemOutput.Default());
  public static UpdateItemOutputTransformOutput Default() {
    return theDefault;
  }
  public static UpdateItemOutputTransformOutput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.UpdateItemOutput transformedOutput) {
    return new UpdateItemOutputTransformOutput(transformedOutput);
  }
  public static UpdateItemOutputTransformOutput create_UpdateItemOutputTransformOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types.UpdateItemOutput transformedOutput) {
    return create(transformedOutput);
  }
  public boolean is_UpdateItemOutputTransformOutput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.UpdateItemOutput dtor_transformedOutput() {
    return this._transformedOutput;
  }
}
