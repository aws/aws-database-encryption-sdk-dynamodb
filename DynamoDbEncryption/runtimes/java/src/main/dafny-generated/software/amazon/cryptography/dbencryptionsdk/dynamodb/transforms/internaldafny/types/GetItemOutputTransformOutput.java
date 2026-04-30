// Class GetItemOutputTransformOutput
// Dafny class GetItemOutputTransformOutput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class GetItemOutputTransformOutput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemOutput _transformedOutput;
  public GetItemOutputTransformOutput (software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemOutput transformedOutput) {
    this._transformedOutput = transformedOutput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    GetItemOutputTransformOutput o = (GetItemOutputTransformOutput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.GetItemOutputTransformOutput.GetItemOutputTransformOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._transformedOutput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<GetItemOutputTransformOutput> _TYPE = dafny.TypeDescriptor.<GetItemOutputTransformOutput>referenceWithInitializer(GetItemOutputTransformOutput.class, () -> GetItemOutputTransformOutput.Default());
  public static dafny.TypeDescriptor<GetItemOutputTransformOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<GetItemOutputTransformOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final GetItemOutputTransformOutput theDefault = GetItemOutputTransformOutput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemOutput.Default());
  public static GetItemOutputTransformOutput Default() {
    return theDefault;
  }
  public static GetItemOutputTransformOutput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemOutput transformedOutput) {
    return new GetItemOutputTransformOutput(transformedOutput);
  }
  public static GetItemOutputTransformOutput create_GetItemOutputTransformOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemOutput transformedOutput) {
    return create(transformedOutput);
  }
  public boolean is_GetItemOutputTransformOutput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemOutput dtor_transformedOutput() {
    return this._transformedOutput;
  }
}
