// Class EqualityBeacon
// Dafny class EqualityBeacon compiled into Java
package DynamoDBFilterExpr_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class EqualityBeacon {
  public Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.Beacon> _beacon;
  public boolean _forEquality;
  public boolean _forContains;
  public EqualityBeacon (Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.Beacon> beacon, boolean forEquality, boolean forContains) {
    this._beacon = beacon;
    this._forEquality = forEquality;
    this._forContains = forContains;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    EqualityBeacon o = (EqualityBeacon)other;
    return true && java.util.Objects.equals(this._beacon, o._beacon) && this._forEquality == o._forEquality && this._forContains == o._forContains;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._beacon);
    hash = ((hash << 5) + hash) + Boolean.hashCode(this._forEquality);
    hash = ((hash << 5) + hash) + Boolean.hashCode(this._forContains);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("DynamoDBFilterExpr.EqualityBeacon.EqualityBeacon");
    s.append("(");
    s.append(dafny.Helpers.toString(this._beacon));
    s.append(", ");
    s.append(this._forEquality);
    s.append(", ");
    s.append(this._forContains);
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<EqualityBeacon> _TYPE = dafny.TypeDescriptor.<EqualityBeacon>referenceWithInitializer(EqualityBeacon.class, () -> EqualityBeacon.Default());
  public static dafny.TypeDescriptor<EqualityBeacon> _typeDescriptor() {
    return (dafny.TypeDescriptor<EqualityBeacon>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final EqualityBeacon theDefault = EqualityBeacon.create(Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.Beacon>Default(SearchableEncryptionInfo_Compile.Beacon._typeDescriptor()), false, false);
  public static EqualityBeacon Default() {
    return theDefault;
  }
  public static EqualityBeacon create(Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.Beacon> beacon, boolean forEquality, boolean forContains) {
    return new EqualityBeacon(beacon, forEquality, forContains);
  }
  public static EqualityBeacon create_EqualityBeacon(Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.Beacon> beacon, boolean forEquality, boolean forContains) {
    return create(beacon, forEquality, forContains);
  }
  public boolean is_EqualityBeacon() { return true; }
  public Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.Beacon> dtor_beacon() {
    return this._beacon;
  }
  public boolean dtor_forEquality() {
    return this._forEquality;
  }
  public boolean dtor_forContains() {
    return this._forContains;
  }
}
