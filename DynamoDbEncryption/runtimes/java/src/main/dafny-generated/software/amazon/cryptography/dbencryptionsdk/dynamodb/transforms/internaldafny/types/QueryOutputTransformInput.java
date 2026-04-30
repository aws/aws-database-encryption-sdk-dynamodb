// Class QueryOutputTransformInput
// Dafny class QueryOutputTransformInput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class QueryOutputTransformInput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput _sdkOutput;
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput _originalInput;
  public QueryOutputTransformInput (software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput originalInput) {
    this._sdkOutput = sdkOutput;
    this._originalInput = originalInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    QueryOutputTransformInput o = (QueryOutputTransformInput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.QueryOutputTransformInput.QueryOutputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkOutput));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._originalInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<QueryOutputTransformInput> _TYPE = dafny.TypeDescriptor.<QueryOutputTransformInput>referenceWithInitializer(QueryOutputTransformInput.class, () -> QueryOutputTransformInput.Default());
  public static dafny.TypeDescriptor<QueryOutputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<QueryOutputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final QueryOutputTransformInput theDefault = QueryOutputTransformInput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput.Default(), software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput.Default());
  public static QueryOutputTransformInput Default() {
    return theDefault;
  }
  public static QueryOutputTransformInput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput originalInput) {
    return new QueryOutputTransformInput(sdkOutput, originalInput);
  }
  public static QueryOutputTransformInput create_QueryOutputTransformInput(software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput sdkOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput originalInput) {
    return create(sdkOutput, originalInput);
  }
  public boolean is_QueryOutputTransformInput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput dtor_sdkOutput() {
    return this._sdkOutput;
  }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput dtor_originalInput() {
    return this._originalInput;
  }
}
