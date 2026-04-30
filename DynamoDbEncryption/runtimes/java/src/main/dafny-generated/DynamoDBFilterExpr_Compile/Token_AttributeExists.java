// Class Token_AttributeExists
// Dafny class Token_AttributeExists compiled into Java
package DynamoDBFilterExpr_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class Token_AttributeExists extends Token {
  public Token_AttributeExists () {
    super();
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    Token_AttributeExists o = (Token_AttributeExists)other;
    return true;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 16;
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("DynamoDBFilterExpr.Token.AttributeExists");
    return s.toString();
  }
}
