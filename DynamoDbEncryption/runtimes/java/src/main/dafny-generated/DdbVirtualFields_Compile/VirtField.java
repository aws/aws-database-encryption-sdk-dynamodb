// Class VirtField
// Dafny class VirtField compiled into Java
package DdbVirtualFields_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class VirtField {
  public dafny.DafnySequence<? extends Character> _name;
  public dafny.DafnySequence<? extends VirtPart> _parts;
  public VirtField (dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends VirtPart> parts) {
    this._name = name;
    this._parts = parts;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    VirtField o = (VirtField)other;
    return true && java.util.Objects.equals(this._name, o._name) && java.util.Objects.equals(this._parts, o._parts);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._name);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._parts);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("DdbVirtualFields.VirtField.VirtField");
    s.append("(");
    s.append(dafny.Helpers.toString(this._name));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._parts));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<VirtField> _TYPE = dafny.TypeDescriptor.<VirtField>referenceWithInitializer(VirtField.class, () -> VirtField.Default());
  public static dafny.TypeDescriptor<VirtField> _typeDescriptor() {
    return (dafny.TypeDescriptor<VirtField>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final VirtField theDefault = VirtField.create(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<VirtPart> empty(VirtPart._typeDescriptor()));
  public static VirtField Default() {
    return theDefault;
  }
  public static VirtField create(dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends VirtPart> parts) {
    return new VirtField(name, parts);
  }
  public static VirtField create_VirtField(dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends VirtPart> parts) {
    return create(name, parts);
  }
  public boolean is_VirtField() { return true; }
  public dafny.DafnySequence<? extends Character> dtor_name() {
    return this._name;
  }
  public dafny.DafnySequence<? extends VirtPart> dtor_parts() {
    return this._parts;
  }
  public boolean examine(java.util.function.Function<dafny.DafnySequence<? extends TermLoc_Compile.Selector>, Boolean> exam) {
    return __default.Examine((this).dtor_parts(), exam);
  }
  public dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> GetFields() {
    return Seq_Compile.__default.<VirtPart, dafny.DafnySequence<? extends Character>>Map(VirtPart._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((java.util.function.Function<VirtPart, dafny.DafnySequence<? extends Character>>)(_0_p_boxed0) -> {
      VirtPart _0_p = ((VirtPart)(java.lang.Object)(_0_p_boxed0));
      return (((TermLoc_Compile.Selector)(java.lang.Object)(((_0_p).dtor_loc()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key();
    }), (this).dtor_parts());
  }
  public dafny.DafnySet<? extends dafny.DafnySequence<? extends TermLoc_Compile.Selector>> GetLocs() {
    return ((dafny.Function0<dafny.DafnySet<? extends dafny.DafnySequence<? extends TermLoc_Compile.Selector>>>)(() -> {
      java.util.ArrayList<dafny.DafnySequence<? extends TermLoc_Compile.Selector>> _coll0 = new java.util.ArrayList<>();
      for (VirtPart _compr_0_boxed0 : ((this).dtor_parts()).Elements()) {
        VirtPart _compr_0 = ((VirtPart)(java.lang.Object)(_compr_0_boxed0));
        VirtPart _0_p = (VirtPart)_compr_0;
        if (((this).dtor_parts()).contains(_0_p)) {
          _coll0.add((_0_p).dtor_loc());
        }
      }
      return new dafny.DafnySet<dafny.DafnySequence<? extends TermLoc_Compile.Selector>>(_coll0);
    })).apply();
  }
  public boolean HasSingleLoc(dafny.DafnySequence<? extends TermLoc_Compile.Selector> loc) {
    return (java.util.Objects.equals(java.math.BigInteger.valueOf(((this).dtor_parts()).length()), java.math.BigInteger.ONE)) && (((((VirtPart)(java.lang.Object)(((this).dtor_parts()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_loc()).equals(loc));
  }
}
