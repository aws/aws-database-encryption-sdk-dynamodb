// Class Token_AttributeType
// Dafny class Token_AttributeType compiled into Java
package DynamoDBFilterExpr_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class Token_AttributeType extends Token {
  public Token_AttributeType () {
    super();
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    Token_AttributeType o = (Token_AttributeType)other;
    return true;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 18;
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("DynamoDBFilterExpr.Token.AttributeType");
    return s.toString();
  }
}
