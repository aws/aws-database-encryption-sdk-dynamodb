// Class AuthItem
// Dafny class AuthItem compiled into Java
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class AuthItem {
  public dafny.DafnySequence<? extends PathSegment> _key;
  public StructuredDataTerminal _data;
  public AuthenticateAction _action;
  public AuthItem (dafny.DafnySequence<? extends PathSegment> key, StructuredDataTerminal data, AuthenticateAction action) {
    this._key = key;
    this._data = data;
    this._action = action;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    AuthItem o = (AuthItem)other;
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
    s.append("AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.AuthItem.AuthItem");
    s.append("(");
    s.append(dafny.Helpers.toString(this._key));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._data));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._action));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<AuthItem> _TYPE = dafny.TypeDescriptor.<AuthItem>referenceWithInitializer(AuthItem.class, () -> AuthItem.Default());
  public static dafny.TypeDescriptor<AuthItem> _typeDescriptor() {
    return (dafny.TypeDescriptor<AuthItem>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final AuthItem theDefault = AuthItem.create(dafny.DafnySequence.<PathSegment> empty(PathSegment._typeDescriptor()), StructuredDataTerminal.Default(), AuthenticateAction.Default());
  public static AuthItem Default() {
    return theDefault;
  }
  public static AuthItem create(dafny.DafnySequence<? extends PathSegment> key, StructuredDataTerminal data, AuthenticateAction action) {
    return new AuthItem(key, data, action);
  }
  public static AuthItem create_AuthItem(dafny.DafnySequence<? extends PathSegment> key, StructuredDataTerminal data, AuthenticateAction action) {
    return create(key, data, action);
  }
  public boolean is_AuthItem() { return true; }
  public dafny.DafnySequence<? extends PathSegment> dtor_key() {
    return this._key;
  }
  public StructuredDataTerminal dtor_data() {
    return this._data;
  }
  public AuthenticateAction dtor_action() {
    return this._action;
  }
}
