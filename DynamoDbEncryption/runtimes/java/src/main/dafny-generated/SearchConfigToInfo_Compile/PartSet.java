// Class PartSet
// Dafny class PartSet compiled into Java
package SearchConfigToInfo_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class PartSet {
  public dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart> _parts;
  public dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> _names;
  public dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> _prefixes;
  public PartSet (dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart> parts, dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> names, dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> prefixes) {
    this._parts = parts;
    this._names = names;
    this._prefixes = prefixes;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    PartSet o = (PartSet)other;
    return true && java.util.Objects.equals(this._parts, o._parts) && java.util.Objects.equals(this._names, o._names) && java.util.Objects.equals(this._prefixes, o._prefixes);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._parts);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._names);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._prefixes);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("SearchConfigToInfo.PartSet.PartSet");
    s.append("(");
    s.append(dafny.Helpers.toString(this._parts));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._names));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._prefixes));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<PartSet> _TYPE = dafny.TypeDescriptor.<PartSet>referenceWithInitializer(PartSet.class, () -> PartSet.Default());
  public static dafny.TypeDescriptor<PartSet> _typeDescriptor() {
    return (dafny.TypeDescriptor<PartSet>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final PartSet theDefault = PartSet.create(dafny.DafnySequence.<CompoundBeacon_Compile.BeaconPart> empty(CompoundBeacon_Compile.BeaconPart._typeDescriptor()), dafny.DafnySet.<dafny.DafnySequence<? extends Character>> empty(), dafny.DafnySet.<dafny.DafnySequence<? extends Character>> empty());
  public static PartSet Default() {
    return theDefault;
  }
  public static PartSet create(dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart> parts, dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> names, dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> prefixes) {
    return new PartSet(parts, names, prefixes);
  }
  public static PartSet create_PartSet(dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart> parts, dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> names, dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> prefixes) {
    return create(parts, names, prefixes);
  }
  public boolean is_PartSet() { return true; }
  public dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart> dtor_parts() {
    return this._parts;
  }
  public dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> dtor_names() {
    return this._names;
  }
  public dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> dtor_prefixes() {
    return this._prefixes;
  }
  public Wrappers_Compile.Result<PartSet, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> add(CompoundBeacon_Compile.BeaconPart part, dafny.DafnySequence<? extends Character> name)
  {
    if (((this).dtor_names()).<dafny.DafnySequence<? extends Character>>contains((part).getName())) {
      return Wrappers_Compile.Result.<PartSet, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Duplicate part name "), (part).getName()), dafny.DafnySequence.asString(" in ")), name), dafny.DafnySequence.asString("."))));
    } else if (((this).dtor_prefixes()).<dafny.DafnySequence<? extends Character>>contains((part).getPrefix())) {
      return Wrappers_Compile.Result.<PartSet, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Duplicate prefix "), (part).getPrefix()), dafny.DafnySequence.asString(" in ")), name), dafny.DafnySequence.asString("."))));
    } else {
      return Wrappers_Compile.Result.<PartSet, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), PartSet.create(dafny.DafnySequence.<CompoundBeacon_Compile.BeaconPart>concatenate((this).dtor_parts(), dafny.DafnySequence.<CompoundBeacon_Compile.BeaconPart> of(CompoundBeacon_Compile.BeaconPart._typeDescriptor(), part)), dafny.DafnySet.<dafny.DafnySequence<? extends Character>>union((this).dtor_names(), dafny.DafnySet.<dafny.DafnySequence<? extends Character>> of((part).getName())), dafny.DafnySet.<dafny.DafnySequence<? extends Character>>union((this).dtor_prefixes(), dafny.DafnySet.<dafny.DafnySequence<? extends Character>> of((part).getPrefix()))));
    }
  }
  public dafny.DafnySequence<? extends Character> GetSetAsString(dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> strings) {
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _0_names = SortedSets.__default.<Character>SetToOrderedSequence2(dafny.TypeDescriptor.CHAR, strings, DynamoDbEncryptionUtil_Compile.__default::CharLess);
    return StandardLibrary_Compile.__default.<Character>Join(dafny.TypeDescriptor.CHAR, _0_names, dafny.DafnySequence.asString(", "));
  }
  public Wrappers_Compile.Result<PartSet, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> combine(PartSet other, dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends Character> otherName)
  {
    if ((java.math.BigInteger.valueOf((dafny.DafnySet.<dafny.DafnySequence<? extends Character>>intersection((this).dtor_names(), (other).dtor_names())).size())).signum() != 0) {
      dafny.DafnySequence<? extends Character> _0_tags = (this).GetSetAsString(dafny.DafnySet.<dafny.DafnySequence<? extends Character>>intersection((this).dtor_names(), (other).dtor_names()));
      return Wrappers_Compile.Result.<PartSet, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Duplicate part name(s) "), _0_tags), dafny.DafnySequence.asString(" between ")), name), dafny.DafnySequence.asString(" and ")), otherName), dafny.DafnySequence.asString("."))));
    } else if ((java.math.BigInteger.valueOf((dafny.DafnySet.<dafny.DafnySequence<? extends Character>>intersection((this).dtor_prefixes(), (other).dtor_prefixes())).size())).signum() != 0) {
      dafny.DafnySequence<? extends Character> _1_tags = (this).GetSetAsString(dafny.DafnySet.<dafny.DafnySequence<? extends Character>>intersection((this).dtor_prefixes(), (other).dtor_prefixes()));
      return Wrappers_Compile.Result.<PartSet, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Duplicate prefix(es) "), _1_tags), dafny.DafnySequence.asString(" between ")), name), dafny.DafnySequence.asString(" and ")), otherName), dafny.DafnySequence.asString("."))));
    } else {
      return Wrappers_Compile.Result.<PartSet, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), PartSet.create(dafny.DafnySequence.<CompoundBeacon_Compile.BeaconPart>concatenate((this).dtor_parts(), (other).dtor_parts()), dafny.DafnySet.<dafny.DafnySequence<? extends Character>>union((this).dtor_names(), (other).dtor_names()), dafny.DafnySet.<dafny.DafnySequence<? extends Character>>union((this).dtor_prefixes(), (other).dtor_prefixes())));
    }
  }
}
