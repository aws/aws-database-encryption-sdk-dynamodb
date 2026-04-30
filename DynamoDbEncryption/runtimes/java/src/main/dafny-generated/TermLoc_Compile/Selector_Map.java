// Class Selector_Map
// Dafny class Selector_Map compiled into Java
package TermLoc_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class Selector_Map extends Selector {
  public dafny.DafnySequence<? extends Character> _key;
  public Selector_Map (dafny.DafnySequence<? extends Character> key) {
    super();
    this._key = key;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    Selector_Map o = (Selector_Map)other;
    return true && java.util.Objects.equals(this._key, o._key);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 1;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._key);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("TermLoc.Selector.Map");
    s.append("(");
    s.append(dafny.Helpers.toString(this._key));
    s.append(")");
    return s.toString();
  }
}
