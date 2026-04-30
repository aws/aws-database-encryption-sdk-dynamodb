// Class Selector_List
// Dafny class Selector_List compiled into Java
package StructuredEncryptionPaths_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class Selector_List extends Selector {
  public long _pos;
  public Selector_List (long pos) {
    super();
    this._pos = pos;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    Selector_List o = (Selector_List)other;
    return true && this._pos == o._pos;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.lang.Long.hashCode(this._pos);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("StructuredEncryptionPaths.Selector.List");
    s.append("(");
    s.append(this._pos);
    s.append(")");
    return s.toString();
  }
}
