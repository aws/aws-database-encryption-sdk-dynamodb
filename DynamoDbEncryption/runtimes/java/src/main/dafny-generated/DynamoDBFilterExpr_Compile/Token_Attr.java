// Class Token_Attr
// Dafny class Token_Attr compiled into Java
package DynamoDBFilterExpr_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class Token_Attr extends Token {
  public dafny.DafnySequence<? extends Character> _s;
  public dafny.DafnySequence<? extends TermLoc_Compile.Selector> _loc;
  public Token_Attr (dafny.DafnySequence<? extends Character> s, dafny.DafnySequence<? extends TermLoc_Compile.Selector> loc) {
    super();
    this._s = s;
    this._loc = loc;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    Token_Attr o = (Token_Attr)other;
    return true && java.util.Objects.equals(this._s, o._s) && java.util.Objects.equals(this._loc, o._loc);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._s);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._loc);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder ss = new StringBuilder();
    ss.append("DynamoDBFilterExpr.Token.Attr");
    ss.append("(");
    ss.append(dafny.Helpers.toString(this._s));
    ss.append(", ");
    ss.append(dafny.Helpers.toString(this._loc));
    ss.append(")");
    return ss.toString();
  }
}
