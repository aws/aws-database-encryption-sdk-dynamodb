// Class GetItemInputTransformOutput
// Dafny class GetItemInputTransformOutput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class GetItemInputTransformOutput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemInput _transformedInput;
  public GetItemInputTransformOutput (software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemInput transformedInput) {
    this._transformedInput = transformedInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    GetItemInputTransformOutput o = (GetItemInputTransformOutput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.GetItemInputTransformOutput.GetItemInputTransformOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._transformedInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<GetItemInputTransformOutput> _TYPE = dafny.TypeDescriptor.<GetItemInputTransformOutput>referenceWithInitializer(GetItemInputTransformOutput.class, () -> GetItemInputTransformOutput.Default());
  public static dafny.TypeDescriptor<GetItemInputTransformOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<GetItemInputTransformOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final GetItemInputTransformOutput theDefault = GetItemInputTransformOutput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemInput.Default());
  public static GetItemInputTransformOutput Default() {
    return theDefault;
  }
  public static GetItemInputTransformOutput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemInput transformedInput) {
    return new GetItemInputTransformOutput(transformedInput);
  }
  public static GetItemInputTransformOutput create_GetItemInputTransformOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemInput transformedInput) {
    return create(transformedInput);
  }
  public boolean is_GetItemInputTransformOutput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemInput dtor_transformedInput() {
    return this._transformedInput;
  }
}
