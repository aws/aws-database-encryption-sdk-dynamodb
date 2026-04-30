// Class CompoundBeacon
// Dafny class CompoundBeacon compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class CompoundBeacon {
  public dafny.DafnySequence<? extends Character> _name;
  public dafny.DafnySequence<? extends Character> _split;
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends EncryptedPart>> _encrypted;
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends SignedPart>> _signed;
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Constructor>> _constructors;
  public CompoundBeacon (dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends Character> split, Wrappers_Compile.Option<dafny.DafnySequence<? extends EncryptedPart>> encrypted, Wrappers_Compile.Option<dafny.DafnySequence<? extends SignedPart>> signed, Wrappers_Compile.Option<dafny.DafnySequence<? extends Constructor>> constructors) {
    this._name = name;
    this._split = split;
    this._encrypted = encrypted;
    this._signed = signed;
    this._constructors = constructors;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    CompoundBeacon o = (CompoundBeacon)other;
    return true && java.util.Objects.equals(this._name, o._name) && java.util.Objects.equals(this._split, o._split) && java.util.Objects.equals(this._encrypted, o._encrypted) && java.util.Objects.equals(this._signed, o._signed) && java.util.Objects.equals(this._constructors, o._constructors);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._name);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._split);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._encrypted);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._signed);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._constructors);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTypes.CompoundBeacon.CompoundBeacon");
    s.append("(");
    s.append(dafny.Helpers.toString(this._name));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._split));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._encrypted));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._signed));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._constructors));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<CompoundBeacon> _TYPE = dafny.TypeDescriptor.<CompoundBeacon>referenceWithInitializer(CompoundBeacon.class, () -> CompoundBeacon.Default());
  public static dafny.TypeDescriptor<CompoundBeacon> _typeDescriptor() {
    return (dafny.TypeDescriptor<CompoundBeacon>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final CompoundBeacon theDefault = CompoundBeacon.create(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), Wrappers_Compile.Option.<dafny.DafnySequence<? extends EncryptedPart>>Default(EncryptedPartsList._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends SignedPart>>Default(SignedPartsList._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Constructor>>Default(ConstructorList._typeDescriptor()));
  public static CompoundBeacon Default() {
    return theDefault;
  }
  public static CompoundBeacon create(dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends Character> split, Wrappers_Compile.Option<dafny.DafnySequence<? extends EncryptedPart>> encrypted, Wrappers_Compile.Option<dafny.DafnySequence<? extends SignedPart>> signed, Wrappers_Compile.Option<dafny.DafnySequence<? extends Constructor>> constructors) {
    return new CompoundBeacon(name, split, encrypted, signed, constructors);
  }
  public static CompoundBeacon create_CompoundBeacon(dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends Character> split, Wrappers_Compile.Option<dafny.DafnySequence<? extends EncryptedPart>> encrypted, Wrappers_Compile.Option<dafny.DafnySequence<? extends SignedPart>> signed, Wrappers_Compile.Option<dafny.DafnySequence<? extends Constructor>> constructors) {
    return create(name, split, encrypted, signed, constructors);
  }
  public boolean is_CompoundBeacon() { return true; }
  public dafny.DafnySequence<? extends Character> dtor_name() {
    return this._name;
  }
  public dafny.DafnySequence<? extends Character> dtor_split() {
    return this._split;
  }
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends EncryptedPart>> dtor_encrypted() {
    return this._encrypted;
  }
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends SignedPart>> dtor_signed() {
    return this._signed;
  }
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Constructor>> dtor_constructors() {
    return this._constructors;
  }
}
