// Class KeyLocation
// Dafny class KeyLocation compiled into Java
package SearchableEncryptionInfo_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class KeyLocation {
  public KeyLocation() {
  }
  private static final dafny.TypeDescriptor<KeyLocation> _TYPE = dafny.TypeDescriptor.<KeyLocation>referenceWithInitializer(KeyLocation.class, () -> KeyLocation.Default());
  public static dafny.TypeDescriptor<KeyLocation> _typeDescriptor() {
    return (dafny.TypeDescriptor<KeyLocation>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final KeyLocation theDefault = KeyLocation.create_LiteralLoc(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,dafny.DafnySequence<? extends java.lang.Byte>> empty());
  public static KeyLocation Default() {
    return theDefault;
  }
  public static KeyLocation create_LiteralLoc(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> keys) {
    return new KeyLocation_LiteralLoc(keys);
  }
  public static KeyLocation create_SingleLoc(dafny.DafnySequence<? extends Character> keyId) {
    return new KeyLocation_SingleLoc(keyId);
  }
  public static KeyLocation create_MultiLoc(dafny.DafnySequence<? extends Character> keyName, boolean deleteKey) {
    return new KeyLocation_MultiLoc(keyName, deleteKey);
  }
  public boolean is_LiteralLoc() { return this instanceof KeyLocation_LiteralLoc; }
  public boolean is_SingleLoc() { return this instanceof KeyLocation_SingleLoc; }
  public boolean is_MultiLoc() { return this instanceof KeyLocation_MultiLoc; }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> dtor_keys() {
    KeyLocation d = this;
    return ((KeyLocation_LiteralLoc)d)._keys;
  }
  public dafny.DafnySequence<? extends Character> dtor_keyId() {
    KeyLocation d = this;
    return ((KeyLocation_SingleLoc)d)._keyId;
  }
  public dafny.DafnySequence<? extends Character> dtor_keyName() {
    KeyLocation d = this;
    return ((KeyLocation_MultiLoc)d)._keyName;
  }
  public boolean dtor_deleteKey() {
    KeyLocation d = this;
    return ((KeyLocation_MultiLoc)d)._deleteKey;
  }
}
