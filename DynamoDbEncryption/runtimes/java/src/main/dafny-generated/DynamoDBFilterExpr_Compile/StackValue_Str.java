// Class StackValue_Str
// Dafny class StackValue_Str compiled into Java
package DynamoDBFilterExpr_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class StackValue_Str extends StackValue {
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _s;
  public StackValue_Str (software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue s) {
    super();
    this._s = s;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    StackValue_Str o = (StackValue_Str)other;
    return true && java.util.Objects.equals(this._s, o._s);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 1;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._s);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder ss = new StringBuilder();
    ss.append("DynamoDBFilterExpr.StackValue.Str");
    ss.append("(");
    ss.append(dafny.Helpers.toString(this._s));
    ss.append(")");
    return ss.toString();
  }
}
