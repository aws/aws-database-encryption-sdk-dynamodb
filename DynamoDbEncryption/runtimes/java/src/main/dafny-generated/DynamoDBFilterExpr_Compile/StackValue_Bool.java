// Class StackValue_Bool
// Dafny class StackValue_Bool compiled into Java
package DynamoDBFilterExpr_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class StackValue_Bool extends StackValue {
  public boolean _b;
  public StackValue_Bool (boolean b) {
    super();
    this._b = b;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    StackValue_Bool o = (StackValue_Bool)other;
    return true && this._b == o._b;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + Boolean.hashCode(this._b);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("DynamoDBFilterExpr.StackValue.Bool");
    s.append("(");
    s.append(this._b);
    s.append(")");
    return s.toString();
  }
}
