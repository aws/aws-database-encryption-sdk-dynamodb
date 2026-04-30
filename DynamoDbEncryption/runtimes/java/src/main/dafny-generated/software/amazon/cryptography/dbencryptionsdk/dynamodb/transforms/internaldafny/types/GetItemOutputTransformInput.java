// Class GetItemOutputTransformInput
// Dafny class GetItemOutputTransformInput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class GetItemOutputTransformInput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemOutput _sdkOutput;
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemInput _originalInput;
  public GetItemOutputTransformInput (software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemInput originalInput) {
    this._sdkOutput = sdkOutput;
    this._originalInput = originalInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    GetItemOutputTransformInput o = (GetItemOutputTransformInput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.GetItemOutputTransformInput.GetItemOutputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkOutput));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._originalInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<GetItemOutputTransformInput> _TYPE = dafny.TypeDescriptor.<GetItemOutputTransformInput>referenceWithInitializer(GetItemOutputTransformInput.class, () -> GetItemOutputTransformInput.Default());
  public static dafny.TypeDescriptor<GetItemOutputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<GetItemOutputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final GetItemOutputTransformInput theDefault = GetItemOutputTransformInput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemOutput.Default(), software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemInput.Default());
  public static GetItemOutputTransformInput Default() {
    return theDefault;
  }
  public static GetItemOutputTransformInput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemInput originalInput) {
    return new GetItemOutputTransformInput(sdkOutput, originalInput);
  }
  public static GetItemOutputTransformInput create_GetItemOutputTransformInput(software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemInput originalInput) {
    return create(sdkOutput, originalInput);
  }
  public boolean is_GetItemOutputTransformInput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemOutput dtor_sdkOutput() {
    return this._sdkOutput;
  }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemInput dtor_originalInput() {
    return this._originalInput;
  }
}
