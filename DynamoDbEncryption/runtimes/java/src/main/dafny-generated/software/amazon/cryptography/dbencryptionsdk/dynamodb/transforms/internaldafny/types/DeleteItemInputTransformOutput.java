// Class DeleteItemInputTransformOutput
// Dafny class DeleteItemInputTransformOutput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class DeleteItemInputTransformOutput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteItemInput _transformedInput;
  public DeleteItemInputTransformOutput (software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteItemInput transformedInput) {
    this._transformedInput = transformedInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    DeleteItemInputTransformOutput o = (DeleteItemInputTransformOutput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.DeleteItemInputTransformOutput.DeleteItemInputTransformOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._transformedInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<DeleteItemInputTransformOutput> _TYPE = dafny.TypeDescriptor.<DeleteItemInputTransformOutput>referenceWithInitializer(DeleteItemInputTransformOutput.class, () -> DeleteItemInputTransformOutput.Default());
  public static dafny.TypeDescriptor<DeleteItemInputTransformOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<DeleteItemInputTransformOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final DeleteItemInputTransformOutput theDefault = DeleteItemInputTransformOutput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteItemInput.Default());
  public static DeleteItemInputTransformOutput Default() {
    return theDefault;
  }
  public static DeleteItemInputTransformOutput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteItemInput transformedInput) {
    return new DeleteItemInputTransformOutput(transformedInput);
  }
  public static DeleteItemInputTransformOutput create_DeleteItemInputTransformOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteItemInput transformedInput) {
    return create(transformedInput);
  }
  public boolean is_DeleteItemInputTransformOutput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.DeleteItemInput dtor_transformedInput() {
    return this._transformedInput;
  }
}
