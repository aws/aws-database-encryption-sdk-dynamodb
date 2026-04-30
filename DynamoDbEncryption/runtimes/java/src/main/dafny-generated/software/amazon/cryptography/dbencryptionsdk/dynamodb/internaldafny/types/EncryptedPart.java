// Class EncryptedPart
// Dafny class EncryptedPart compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class EncryptedPart {
  public dafny.DafnySequence<? extends Character> _name;
  public dafny.DafnySequence<? extends Character> _prefix;
  public EncryptedPart (dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends Character> prefix) {
    this._name = name;
    this._prefix = prefix;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    EncryptedPart o = (EncryptedPart)other;
    return true && java.util.Objects.equals(this._name, o._name) && java.util.Objects.equals(this._prefix, o._prefix);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._name);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._prefix);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedPart.EncryptedPart");
    s.append("(");
    s.append(dafny.Helpers.toString(this._name));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._prefix));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<EncryptedPart> _TYPE = dafny.TypeDescriptor.<EncryptedPart>referenceWithInitializer(EncryptedPart.class, () -> EncryptedPart.Default());
  public static dafny.TypeDescriptor<EncryptedPart> _typeDescriptor() {
    return (dafny.TypeDescriptor<EncryptedPart>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final EncryptedPart theDefault = EncryptedPart.create(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR));
  public static EncryptedPart Default() {
    return theDefault;
  }
  public static EncryptedPart create(dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends Character> prefix) {
    return new EncryptedPart(name, prefix);
  }
  public static EncryptedPart create_EncryptedPart(dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends Character> prefix) {
    return create(name, prefix);
  }
  public boolean is_EncryptedPart() { return true; }
  public dafny.DafnySequence<? extends Character> dtor_name() {
    return this._name;
  }
  public dafny.DafnySequence<? extends Character> dtor_prefix() {
    return this._prefix;
  }
}
