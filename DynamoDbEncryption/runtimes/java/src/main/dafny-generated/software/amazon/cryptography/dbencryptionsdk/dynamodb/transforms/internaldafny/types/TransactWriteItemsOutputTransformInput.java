// Class TransactWriteItemsOutputTransformInput
// Dafny class TransactWriteItemsOutputTransformInput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class TransactWriteItemsOutputTransformInput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItemsOutput _sdkOutput;
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItemsInput _originalInput;
  public TransactWriteItemsOutputTransformInput (software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItemsOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItemsInput originalInput) {
    this._sdkOutput = sdkOutput;
    this._originalInput = originalInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    TransactWriteItemsOutputTransformInput o = (TransactWriteItemsOutputTransformInput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.TransactWriteItemsOutputTransformInput.TransactWriteItemsOutputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkOutput));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._originalInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<TransactWriteItemsOutputTransformInput> _TYPE = dafny.TypeDescriptor.<TransactWriteItemsOutputTransformInput>referenceWithInitializer(TransactWriteItemsOutputTransformInput.class, () -> TransactWriteItemsOutputTransformInput.Default());
  public static dafny.TypeDescriptor<TransactWriteItemsOutputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<TransactWriteItemsOutputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final TransactWriteItemsOutputTransformInput theDefault = TransactWriteItemsOutputTransformInput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItemsOutput.Default(), software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItemsInput.Default());
  public static TransactWriteItemsOutputTransformInput Default() {
    return theDefault;
  }
  public static TransactWriteItemsOutputTransformInput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItemsOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItemsInput originalInput) {
    return new TransactWriteItemsOutputTransformInput(sdkOutput, originalInput);
  }
  public static TransactWriteItemsOutputTransformInput create_TransactWriteItemsOutputTransformInput(software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItemsOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItemsInput originalInput) {
    return create(sdkOutput, originalInput);
  }
  public boolean is_TransactWriteItemsOutputTransformInput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItemsOutput dtor_sdkOutput() {
    return this._sdkOutput;
  }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItemsInput dtor_originalInput() {
    return this._originalInput;
  }
}
