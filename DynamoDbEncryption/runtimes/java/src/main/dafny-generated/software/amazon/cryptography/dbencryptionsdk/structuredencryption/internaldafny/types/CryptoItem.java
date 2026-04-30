// Class CryptoItem
// Dafny class CryptoItem compiled into Java
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class CryptoItem {
  public dafny.DafnySequence<? extends PathSegment> _key;
  public StructuredDataTerminal _data;
  public CryptoAction _action;
  public CryptoItem (dafny.DafnySequence<? extends PathSegment> key, StructuredDataTerminal data, CryptoAction action) {
    this._key = key;
    this._data = data;
    this._action = action;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    CryptoItem o = (CryptoItem)other;
    return true && java.util.Objects.equals(this._key, o._key) && java.util.Objects.equals(this._data, o._data) && java.util.Objects.equals(this._action, o._action);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._key);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._data);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._action);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem.CryptoItem");
    s.append("(");
    s.append(dafny.Helpers.toString(this._key));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._data));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._action));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<CryptoItem> _TYPE = dafny.TypeDescriptor.<CryptoItem>referenceWithInitializer(CryptoItem.class, () -> CryptoItem.Default());
  public static dafny.TypeDescriptor<CryptoItem> _typeDescriptor() {
    return (dafny.TypeDescriptor<CryptoItem>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final CryptoItem theDefault = CryptoItem.create(dafny.DafnySequence.<PathSegment> empty(PathSegment._typeDescriptor()), StructuredDataTerminal.Default(), CryptoAction.Default());
  public static CryptoItem Default() {
    return theDefault;
  }
  public static CryptoItem create(dafny.DafnySequence<? extends PathSegment> key, StructuredDataTerminal data, CryptoAction action) {
    return new CryptoItem(key, data, action);
  }
  public static CryptoItem create_CryptoItem(dafny.DafnySequence<? extends PathSegment> key, StructuredDataTerminal data, CryptoAction action) {
    return create(key, data, action);
  }
  public boolean is_CryptoItem() { return true; }
  public dafny.DafnySequence<? extends PathSegment> dtor_key() {
    return this._key;
  }
  public StructuredDataTerminal dtor_data() {
    return this._data;
  }
  public CryptoAction dtor_action() {
    return this._action;
  }
}
