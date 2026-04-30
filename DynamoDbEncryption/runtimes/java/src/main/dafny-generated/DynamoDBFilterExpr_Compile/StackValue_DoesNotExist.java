// Class StackValue_DoesNotExist
// Dafny class StackValue_DoesNotExist compiled into Java
package DynamoDBFilterExpr_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class StackValue_DoesNotExist extends StackValue {
  public StackValue_DoesNotExist () {
    super();
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    StackValue_DoesNotExist o = (StackValue_DoesNotExist)other;
    return true;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 2;
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("DynamoDBFilterExpr.StackValue.DoesNotExist");
    return s.toString();
  }
}
