// Class QueryInputTransformInput
// Dafny class QueryInputTransformInput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class QueryInputTransformInput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput _sdkInput;
  public QueryInputTransformInput (software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput sdkInput) {
    this._sdkInput = sdkInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    QueryInputTransformInput o = (QueryInputTransformInput)other;
    return true && java.util.Objects.equals(this._sdkInput, o._sdkInput);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._sdkInput);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.QueryInputTransformInput.QueryInputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<QueryInputTransformInput> _TYPE = dafny.TypeDescriptor.<QueryInputTransformInput>referenceWithInitializer(QueryInputTransformInput.class, () -> QueryInputTransformInput.Default());
  public static dafny.TypeDescriptor<QueryInputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<QueryInputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final QueryInputTransformInput theDefault = QueryInputTransformInput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput.Default());
  public static QueryInputTransformInput Default() {
    return theDefault;
  }
  public static QueryInputTransformInput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput sdkInput) {
    return new QueryInputTransformInput(sdkInput);
  }
  public static QueryInputTransformInput create_QueryInputTransformInput(software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput sdkInput) {
    return create(sdkInput);
  }
  public boolean is_QueryInputTransformInput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput dtor_sdkInput() {
    return this._sdkInput;
  }
}
