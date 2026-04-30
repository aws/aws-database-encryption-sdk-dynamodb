// Class SignedPart
// Dafny class SignedPart compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class SignedPart {
  public dafny.DafnySequence<? extends Character> _name;
  public dafny.DafnySequence<? extends Character> _prefix;
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _loc;
  public SignedPart (dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends Character> prefix, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> loc) {
    this._name = name;
    this._prefix = prefix;
    this._loc = loc;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    SignedPart o = (SignedPart)other;
    return true && java.util.Objects.equals(this._name, o._name) && java.util.Objects.equals(this._prefix, o._prefix) && java.util.Objects.equals(this._loc, o._loc);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._name);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._prefix);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._loc);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTypes.SignedPart.SignedPart");
    s.append("(");
    s.append(dafny.Helpers.toString(this._name));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._prefix));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._loc));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<SignedPart> _TYPE = dafny.TypeDescriptor.<SignedPart>referenceWithInitializer(SignedPart.class, () -> SignedPart.Default());
  public static dafny.TypeDescriptor<SignedPart> _typeDescriptor() {
    return (dafny.TypeDescriptor<SignedPart>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final SignedPart theDefault = SignedPart.create(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>Default(TerminalLocation._typeDescriptor()));
  public static SignedPart Default() {
    return theDefault;
  }
  public static SignedPart create(dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends Character> prefix, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> loc) {
    return new SignedPart(name, prefix, loc);
  }
  public static SignedPart create_SignedPart(dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends Character> prefix, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> loc) {
    return create(name, prefix, loc);
  }
  public boolean is_SignedPart() { return true; }
  public dafny.DafnySequence<? extends Character> dtor_name() {
    return this._name;
  }
  public dafny.DafnySequence<? extends Character> dtor_prefix() {
    return this._prefix;
  }
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> dtor_loc() {
    return this._loc;
  }
}
