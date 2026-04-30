// Class QueryInputTransformOutput
// Dafny class QueryInputTransformOutput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class QueryInputTransformOutput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput _transformedInput;
  public QueryInputTransformOutput (software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput transformedInput) {
    this._transformedInput = transformedInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    QueryInputTransformOutput o = (QueryInputTransformOutput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.QueryInputTransformOutput.QueryInputTransformOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._transformedInput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<QueryInputTransformOutput> _TYPE = dafny.TypeDescriptor.<QueryInputTransformOutput>referenceWithInitializer(QueryInputTransformOutput.class, () -> QueryInputTransformOutput.Default());
  public static dafny.TypeDescriptor<QueryInputTransformOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<QueryInputTransformOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final QueryInputTransformOutput theDefault = QueryInputTransformOutput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput.Default());
  public static QueryInputTransformOutput Default() {
    return theDefault;
  }
  public static QueryInputTransformOutput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput transformedInput) {
    return new QueryInputTransformOutput(transformedInput);
  }
  public static QueryInputTransformOutput create_QueryInputTransformOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput transformedInput) {
    return create(transformedInput);
  }
  public boolean is_QueryInputTransformOutput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput dtor_transformedInput() {
    return this._transformedInput;
  }
}
