// Class CompoundBeacon
// Dafny class CompoundBeacon compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class CompoundBeacon {
  public dafny.DafnySequence<? extends Character> _name;
  public dafny.DafnySequence<? extends Character> _split;
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends SensitivePart>> _sensitive;
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends NonSensitivePart>> _nonSensitive;
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Constructor>> _constructors;
  public CompoundBeacon (dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends Character> split, Wrappers_Compile.Option<dafny.DafnySequence<? extends SensitivePart>> sensitive, Wrappers_Compile.Option<dafny.DafnySequence<? extends NonSensitivePart>> nonSensitive, Wrappers_Compile.Option<dafny.DafnySequence<? extends Constructor>> constructors) {
    this._name = name;
    this._split = split;
    this._sensitive = sensitive;
    this._nonSensitive = nonSensitive;
    this._constructors = constructors;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    CompoundBeacon o = (CompoundBeacon)other;
    return true && java.util.Objects.equals(this._name, o._name) && java.util.Objects.equals(this._split, o._split) && java.util.Objects.equals(this._sensitive, o._sensitive) && java.util.Objects.equals(this._nonSensitive, o._nonSensitive) && java.util.Objects.equals(this._constructors, o._constructors);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._name);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._split);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._sensitive);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._nonSensitive);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._constructors);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Types_Compile.CompoundBeacon.CompoundBeacon");
    s.append("(");
    s.append(dafny.Helpers.toString(this._name));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._split));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._sensitive));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._nonSensitive));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._constructors));
    s.append(")");
    return s.toString();
  }

  private static final CompoundBeacon theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CompoundBeacon.create(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), Wrappers_Compile.Option.<dafny.DafnySequence<? extends SensitivePart>>Default(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends NonSensitivePart>>Default(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Constructor>>Default());
  public static CompoundBeacon Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<CompoundBeacon> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(CompoundBeacon.class, () -> Default());
  public static dafny.TypeDescriptor<CompoundBeacon> _typeDescriptor() {
    return (dafny.TypeDescriptor<CompoundBeacon>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static CompoundBeacon create(dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends Character> split, Wrappers_Compile.Option<dafny.DafnySequence<? extends SensitivePart>> sensitive, Wrappers_Compile.Option<dafny.DafnySequence<? extends NonSensitivePart>> nonSensitive, Wrappers_Compile.Option<dafny.DafnySequence<? extends Constructor>> constructors) {
    return new CompoundBeacon(name, split, sensitive, nonSensitive, constructors);
  }
  public static CompoundBeacon create_CompoundBeacon(dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends Character> split, Wrappers_Compile.Option<dafny.DafnySequence<? extends SensitivePart>> sensitive, Wrappers_Compile.Option<dafny.DafnySequence<? extends NonSensitivePart>> nonSensitive, Wrappers_Compile.Option<dafny.DafnySequence<? extends Constructor>> constructors) {
    return create(name, split, sensitive, nonSensitive, constructors);
  }
  public boolean is_CompoundBeacon() { return true; }
  public dafny.DafnySequence<? extends Character> dtor_name() {
    return this._name;
  }
  public dafny.DafnySequence<? extends Character> dtor_split() {
    return this._split;
  }
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends SensitivePart>> dtor_sensitive() {
    return this._sensitive;
  }
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends NonSensitivePart>> dtor_nonSensitive() {
    return this._nonSensitive;
  }
  public Wrappers_Compile.Option<dafny.DafnySequence<? extends Constructor>> dtor_constructors() {
    return this._constructors;
  }
}
