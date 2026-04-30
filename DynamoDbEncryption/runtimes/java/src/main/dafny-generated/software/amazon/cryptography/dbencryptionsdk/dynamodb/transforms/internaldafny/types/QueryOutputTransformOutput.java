// Class QueryOutputTransformOutput
// Dafny class QueryOutputTransformOutput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class QueryOutputTransformOutput {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput _transformedOutput;
  public QueryOutputTransformOutput (software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput transformedOutput) {
    this._transformedOutput = transformedOutput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    QueryOutputTransformOutput o = (QueryOutputTransformOutput)other;
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.QueryOutputTransformOutput.QueryOutputTransformOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._transformedOutput));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<QueryOutputTransformOutput> _TYPE = dafny.TypeDescriptor.<QueryOutputTransformOutput>referenceWithInitializer(QueryOutputTransformOutput.class, () -> QueryOutputTransformOutput.Default());
  public static dafny.TypeDescriptor<QueryOutputTransformOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<QueryOutputTransformOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final QueryOutputTransformOutput theDefault = QueryOutputTransformOutput.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput.Default());
  public static QueryOutputTransformOutput Default() {
    return theDefault;
  }
  public static QueryOutputTransformOutput create(software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput transformedOutput) {
    return new QueryOutputTransformOutput(transformedOutput);
  }
  public static QueryOutputTransformOutput create_QueryOutputTransformOutput(software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput transformedOutput) {
    return create(transformedOutput);
  }
  public boolean is_QueryOutputTransformOutput() { return true; }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput dtor_transformedOutput() {
    return this._transformedOutput;
  }
}
