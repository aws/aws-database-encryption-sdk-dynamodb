// Class Token_Value
// Dafny class Token_Value compiled into Java
package DynamoDBFilterExpr_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class Token_Value extends Token {
  public dafny.DafnySequence<? extends Character> _s;
  public Token_Value (dafny.DafnySequence<? extends Character> s) {
    super();
    this._s = s;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    Token_Value o = (Token_Value)other;
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
    ss.append("DynamoDBFilterExpr.Token.Value");
    ss.append("(");
    ss.append(dafny.Helpers.toString(this._s));
    ss.append(")");
    return ss.toString();
  }
}
