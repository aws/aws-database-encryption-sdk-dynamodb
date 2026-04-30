// Class BeaconPart_Signed
// Dafny class BeaconPart_Signed compiled into Java
package CompoundBeacon_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class BeaconPart_Signed extends BeaconPart {
  public dafny.DafnySequence<? extends Character> _prefix;
  public dafny.DafnySequence<? extends Character> _name;
  public dafny.DafnySequence<? extends TermLoc_Compile.Selector> _loc;
  public BeaconPart_Signed (dafny.DafnySequence<? extends Character> prefix, dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends TermLoc_Compile.Selector> loc) {
    super();
    this._prefix = prefix;
    this._name = name;
    this._loc = loc;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    BeaconPart_Signed o = (BeaconPart_Signed)other;
    return true && java.util.Objects.equals(this._prefix, o._prefix) && java.util.Objects.equals(this._name, o._name) && java.util.Objects.equals(this._loc, o._loc);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 1;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._prefix);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._name);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._loc);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("CompoundBeacon.BeaconPart.Signed");
    s.append("(");
    s.append(dafny.Helpers.toString(this._prefix));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._name));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._loc));
    s.append(")");
    return s.toString();
  }
}
