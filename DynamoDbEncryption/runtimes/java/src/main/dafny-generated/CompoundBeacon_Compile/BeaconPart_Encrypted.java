// Class BeaconPart_Encrypted
// Dafny class BeaconPart_Encrypted compiled into Java
package CompoundBeacon_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class BeaconPart_Encrypted extends BeaconPart {
  public dafny.DafnySequence<? extends Character> _prefix;
  public BaseBeacon_Compile.StandardBeacon _beacon;
  public BeaconPart_Encrypted (dafny.DafnySequence<? extends Character> prefix, BaseBeacon_Compile.StandardBeacon beacon) {
    super();
    this._prefix = prefix;
    this._beacon = beacon;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    BeaconPart_Encrypted o = (BeaconPart_Encrypted)other;
    return true && java.util.Objects.equals(this._prefix, o._prefix) && java.util.Objects.equals(this._beacon, o._beacon);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._prefix);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._beacon);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("CompoundBeacon.BeaconPart.Encrypted");
    s.append("(");
    s.append(dafny.Helpers.toString(this._prefix));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._beacon));
    s.append(")");
    return s.toString();
  }
}
