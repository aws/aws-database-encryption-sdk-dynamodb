// Class __default
// Dafny class __default compiled into Java
package StructuredEncryptionPaths_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static boolean ValidTerminalSelector(dafny.DafnySequence<? extends Selector> s) {
    return ((((long) (s).cardinalityInt()) == 0 ? 0 : 1) == 1) && ((((Selector)(java.lang.Object)((s).select(0)))).is_Map());
  }
  public static dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment> StringToUniPath(dafny.DafnySequence<? extends Character> x) {
    return dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment> of(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment.create(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructureSegment.create(x)));
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> UniPathToString(dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment> x) {
    return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Success(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), ((((software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment)(java.lang.Object)((x).select(0)))).dtor_member()).dtor_key());
  }
  public static boolean ValidPath(dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment> path) {
    return ((java.util.function.Function<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment>, Boolean>)(_0_path) -> dafny.Helpers.Quantifier((_0_path).UniqueElements(), true, ((_forall_var_0_boxed0) -> {
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment _forall_var_0 = ((software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment)(java.lang.Object)(_forall_var_0_boxed0));
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment _1_x = (software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment)_forall_var_0;
      return !((_0_path).contains(_1_x)) || (StructuredEncryptionUtil_Compile.__default.ValidString(((_1_x).dtor_member()).dtor_key()));
    }))).apply(path);
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> CanonPath(dafny.DafnySequence<? extends Character> table, dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment> path)
  {
    dafny.DafnySequence<? extends java.lang.Byte> _0_tableName = (UTF8.__default.Encode(table)).dtor_value();
    dafny.DafnySequence<? extends java.lang.Byte> _1_depth = StandardLibrary_mUInt_Compile.__default.UInt64ToSeq((long) (path).cardinalityInt());
    dafny.DafnySequence<? extends java.lang.Byte> _2_path = __default.MakeCanonicalPath(path);
    return dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(_0_tableName, _1_depth), _2_path);
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> TermLocMap_q(dafny.DafnySequence<? extends Character> attr) {
    Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _0_valueOrError0 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), StructuredEncryptionUtil_Compile.__default.ValidString(attr), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("invalid string : "), attr)));
    if ((_0_valueOrError0).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
      return (_0_valueOrError0).<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment._typeDescriptor()));
    } else {
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Success(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment> of(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment.create(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructureSegment.create(attr))));
    }
  }
  public static dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment> TermLocMap(dafny.DafnySequence<? extends Character> attr) {
    return dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment> of(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment.create(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructureSegment.create(attr)));
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> SimpleCanon(dafny.DafnySequence<? extends Character> table, dafny.DafnySequence<? extends Character> attr)
  {
    return __default.CanonPath(table, __default.TermLocMap(attr));
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> CanonicalPart(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment s) {
    return dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte> of(__default.MAP__TAG()), StandardLibrary_mUInt_Compile.__default.UInt64ToSeq((long) (((s).dtor_member()).dtor_key()).cardinalityInt())), (UTF8.__default.Encode(((s).dtor_member()).dtor_key())).dtor_value());
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> MakeCanonicalPath(dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment> path)
  {
    dafny.DafnySequence<? extends java.lang.Byte> ret = dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor());
    dafny.DafnySequence<? extends java.lang.Byte> _0_result;
    _0_result = dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor());
    long _lo0 = (long) 0L;
    for (long _1_i = (long) (path).cardinalityInt(); java.lang.Long.compareUnsigned(_lo0, _1_i) < 0; ) {
      _1_i--;
      _0_result = dafny.DafnySequence.<java.lang.Byte>concatenate(__default.CanonicalPart(((software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment)(java.lang.Object)((path).select(dafny.Helpers.unsignedToInt(_1_i))))), _0_result);
    }
    ret = _0_result;
    return ret;
  }
  public static dafny.DafnySequence<? extends Character> PathToString(dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment> path) {
    dafny.DafnySequence<? extends Character> _0___accumulator = dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR);
    TAIL_CALL_START: while (true) {
      if ((((long) (path).cardinalityInt()) == 0 ? 0 : 1) == 0) {
        return dafny.DafnySequence.<Character>concatenate(_0___accumulator, dafny.DafnySequence.asString(""));
      } else if (((long) (path).cardinalityInt()) == ((long) 1L)) {
        return dafny.DafnySequence.<Character>concatenate(_0___accumulator, ((((software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment)(java.lang.Object)((path).select(0)))).dtor_member()).dtor_key());
      } else {
        _0___accumulator = dafny.DafnySequence.<Character>concatenate(_0___accumulator, dafny.DafnySequence.<Character>concatenate(((((software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment)(java.lang.Object)((path).select(0)))).dtor_member()).dtor_key(), dafny.DafnySequence.asString(".")));
        dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment> _in0 = (path).drop(1);
        path = _in0;
        continue TAIL_CALL_START;
      }
    }
  }
  public static byte MAP__TAG()
  {
    return ((byte) ('$'));
  }
  public static byte ARRAY__TAG()
  {
    return ((byte) ('#'));
  }
  @Override
  public java.lang.String toString() {
    return "StructuredEncryptionPaths._default";
  }
}
