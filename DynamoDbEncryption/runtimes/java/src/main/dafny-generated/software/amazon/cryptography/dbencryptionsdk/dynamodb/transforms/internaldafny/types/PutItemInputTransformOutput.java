// Class PutItemInputTransformOutput
// Dafny class PutItemInputTransformOutput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class PutItemInputTransformOutput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.PutItemInput _transformedInput;
  public PutItemInputTransformOutput (software.amazon.cryptography.services.dynamodb.internaldafny.types.PutItemInput transformedInput) {
    this._transformedInput = transformedInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    PutItemInputTransformOutput o = (PutItemInputTransformOutput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.PutItemInputTransformOutput.PutItemInputTransformOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._transformedInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<PutItemInputTransformOutput> _TYPE = dafny.TypeDescriptor.<PutItemInputTransformOutput>referenceWithInitializer(PutItemInputTransformOutput.class, () -> PutItemInputTransformOutput.Default());
  public static dafny.TypeDescriptor<PutItemInputTransformOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<PutItemInputTransformOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final PutItemInputTransformOutput theDefault = PutItemInputTransformOutput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.PutItemInput.Default());
  public static PutItemInputTransformOutput Default() {
    return theDefault;
  }
  public static PutItemInputTransformOutput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.PutItemInput transformedInput) {
    return new PutItemInputTransformOutput(transformedInput);
  }
  public static PutItemInputTransformOutput create_PutItemInputTransformOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types.PutItemInput transformedInput) {
    return create(transformedInput);
  }
  public boolean is_PutItemInputTransformOutput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.PutItemInput dtor_transformedInput() {
    return this._transformedInput;
  }
}
