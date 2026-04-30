// Class Token_Or
// Dafny class Token_Or compiled into Java
package DynamoDBFilterExpr_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class Token_Or extends Token {
  public Token_Or () {
    super();
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    Token_Or o = (Token_Or)other;
    return true;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 15;
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("DynamoDBFilterExpr.Token.Or");
    return s.toString();
  }
}
