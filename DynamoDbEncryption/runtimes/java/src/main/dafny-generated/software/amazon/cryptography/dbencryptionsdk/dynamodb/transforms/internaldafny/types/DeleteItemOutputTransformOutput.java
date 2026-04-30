// Class DeleteItemOutputTransformOutput
// Dafny class DeleteItemOutputTransformOutput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class DeleteItemOutputTransformOutput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteItemOutput _transformedOutput;
  public DeleteItemOutputTransformOutput (software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteItemOutput transformedOutput) {
    this._transformedOutput = transformedOutput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    DeleteItemOutputTransformOutput o = (DeleteItemOutputTransformOutput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.DeleteItemOutputTransformOutput.DeleteItemOutputTransformOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._transformedOutput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<DeleteItemOutputTransformOutput> _TYPE = dafny.TypeDescriptor.<DeleteItemOutputTransformOutput>referenceWithInitializer(DeleteItemOutputTransformOutput.class, () -> DeleteItemOutputTransformOutput.Default());
  public static dafny.TypeDescriptor<DeleteItemOutputTransformOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<DeleteItemOutputTransformOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final DeleteItemOutputTransformOutput theDefault = DeleteItemOutputTransformOutput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteItemOutput.Default());
  public static DeleteItemOutputTransformOutput Default() {
    return theDefault;
  }
  public static DeleteItemOutputTransformOutput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteItemOutput transformedOutput) {
    return new DeleteItemOutputTransformOutput(transformedOutput);
  }
  public static DeleteItemOutputTransformOutput create_DeleteItemOutputTransformOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteItemOutput transformedOutput) {
    return create(transformedOutput);
  }
  public boolean is_DeleteItemOutputTransformOutput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteItemOutput dtor_transformedOutput() {
    return this._transformedOutput;
  }
}
