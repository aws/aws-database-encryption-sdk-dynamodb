// Class PutItemOutputTransformOutput
// Dafny class PutItemOutputTransformOutput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class PutItemOutputTransformOutput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.PutItemOutput _transformedOutput;
  public PutItemOutputTransformOutput (software.amazon.cryptography.services.dynamodb.internaldafny.types.PutItemOutput transformedOutput) {
    this._transformedOutput = transformedOutput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    PutItemOutputTransformOutput o = (PutItemOutputTransformOutput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.PutItemOutputTransformOutput.PutItemOutputTransformOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._transformedOutput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<PutItemOutputTransformOutput> _TYPE = dafny.TypeDescriptor.<PutItemOutputTransformOutput>referenceWithInitializer(PutItemOutputTransformOutput.class, () -> PutItemOutputTransformOutput.Default());
  public static dafny.TypeDescriptor<PutItemOutputTransformOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<PutItemOutputTransformOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final PutItemOutputTransformOutput theDefault = PutItemOutputTransformOutput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.PutItemOutput.Default());
  public static PutItemOutputTransformOutput Default() {
    return theDefault;
  }
  public static PutItemOutputTransformOutput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.PutItemOutput transformedOutput) {
    return new PutItemOutputTransformOutput(transformedOutput);
  }
  public static PutItemOutputTransformOutput create_PutItemOutputTransformOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types.PutItemOutput transformedOutput) {
    return create(transformedOutput);
  }
  public boolean is_PutItemOutputTransformOutput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.PutItemOutput dtor_transformedOutput() {
    return this._transformedOutput;
  }
}
