// Class CanonCryptoItem
// Dafny class CanonCryptoItem compiled into Java
package StructuredEncryptionUtil_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class CanonCryptoItem {
  public dafny.DafnySequence<? extends java.lang.Byte> _key;
  public dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment> _origKey;
  public software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal _data;
  public software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction _action;
  public CanonCryptoItem (dafny.DafnySequence<? extends java.lang.Byte> key, dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment> origKey, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal data, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction action) {
    this._key = key;
    this._origKey = origKey;
    this._data = data;
    this._action = action;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    CanonCryptoItem o = (CanonCryptoItem)other;
    return true && java.util.Objects.equals(this._key, o._key) && java.util.Objects.equals(this._origKey, o._origKey) && java.util.Objects.equals(this._data, o._data) && java.util.Objects.equals(this._action, o._action);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._key);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._origKey);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._data);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._action);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("StructuredEncryptionUtil.CanonCryptoItem.CanonCryptoItem");
    s.append("(");
    s.append(dafny.Helpers.toString(this._key));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._origKey));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._data));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._action));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<CanonCryptoItem> _TYPE = dafny.TypeDescriptor.<CanonCryptoItem>referenceWithInitializer(CanonCryptoItem.class, () -> CanonCryptoItem.Default());
  public static dafny.TypeDescriptor<CanonCryptoItem> _typeDescriptor() {
    return (dafny.TypeDescriptor<CanonCryptoItem>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final CanonCryptoItem theDefault = CanonCryptoItem.create(dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment> empty(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal.Default(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.Default());
  public static CanonCryptoItem Default() {
    return theDefault;
  }
  public static CanonCryptoItem create(dafny.DafnySequence<? extends java.lang.Byte> key, dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment> origKey, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal data, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction action) {
    return new CanonCryptoItem(key, origKey, data, action);
  }
  public static CanonCryptoItem create_CanonCryptoItem(dafny.DafnySequence<? extends java.lang.Byte> key, dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment> origKey, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal data, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction action) {
    return create(key, origKey, data, action);
  }
  public boolean is_CanonCryptoItem() { return true; }
  public dafny.DafnySequence<? extends java.lang.Byte> dtor_key() {
    return this._key;
  }
  public dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment> dtor_origKey() {
    return this._origKey;
  }
  public software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal dtor_data() {
    return this._data;
  }
  public software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction dtor_action() {
    return this._action;
  }
}
