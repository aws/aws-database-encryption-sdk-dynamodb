// Class TransactGetItemsOutputTransformInput
// Dafny class TransactGetItemsOutputTransformInput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class TransactGetItemsOutputTransformInput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItemsOutput _sdkOutput;
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItemsInput _originalInput;
  public TransactGetItemsOutputTransformInput (software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItemsOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItemsInput originalInput) {
    this._sdkOutput = sdkOutput;
    this._originalInput = originalInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    TransactGetItemsOutputTransformInput o = (TransactGetItemsOutputTransformInput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.TransactGetItemsOutputTransformInput.TransactGetItemsOutputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkOutput));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._originalInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<TransactGetItemsOutputTransformInput> _TYPE = dafny.TypeDescriptor.<TransactGetItemsOutputTransformInput>referenceWithInitializer(TransactGetItemsOutputTransformInput.class, () -> TransactGetItemsOutputTransformInput.Default());
  public static dafny.TypeDescriptor<TransactGetItemsOutputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<TransactGetItemsOutputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final TransactGetItemsOutputTransformInput theDefault = TransactGetItemsOutputTransformInput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItemsOutput.Default(), software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItemsInput.Default());
  public static TransactGetItemsOutputTransformInput Default() {
    return theDefault;
  }
  public static TransactGetItemsOutputTransformInput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItemsOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItemsInput originalInput) {
    return new TransactGetItemsOutputTransformInput(sdkOutput, originalInput);
  }
  public static TransactGetItemsOutputTransformInput create_TransactGetItemsOutputTransformInput(software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItemsOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItemsInput originalInput) {
    return create(sdkOutput, originalInput);
  }
  public boolean is_TransactGetItemsOutputTransformInput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItemsOutput dtor_sdkOutput() {
    return this._sdkOutput;
  }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItemsInput dtor_originalInput() {
    return this._originalInput;
  }
}
