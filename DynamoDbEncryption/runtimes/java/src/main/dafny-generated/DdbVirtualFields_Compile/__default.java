// Class __default
// Dafny class __default compiled into Java
package DdbVirtualFields_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static Wrappers_Compile.Result<VirtField, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> ParseVirtualFieldConfig(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField vf) {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends VirtPart>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = StandardLibrary_mSequence_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualPart, VirtPart, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>MapWithResult(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualPart._typeDescriptor(), VirtPart._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualPart, Wrappers_Compile.Result<VirtPart, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>>)(_1_p_boxed0) -> {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualPart _1_p = ((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualPart)(java.lang.Object)(_1_p_boxed0));
      return __default.ParseVirtualPartConfig(_1_p);
    }), (vf).dtor_parts(), (long) 0L, dafny.DafnySequence.<VirtPart> empty(VirtPart._typeDescriptor()));
    if ((_0_valueOrError0).IsFailure(dafny.DafnySequence.<VirtPart>_typeDescriptor(VirtPart._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
      return (_0_valueOrError0).<VirtField>PropagateFailure(dafny.DafnySequence.<VirtPart>_typeDescriptor(VirtPart._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), VirtField._typeDescriptor());
    } else {
      dafny.DafnySequence<? extends VirtPart> _2_parts = (_0_valueOrError0).Extract(dafny.DafnySequence.<VirtPart>_typeDescriptor(VirtPart._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      return Wrappers_Compile.Result.<VirtField, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(VirtField._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), VirtField.create((vf).dtor_name(), _2_parts));
    }
  }
  public static Wrappers_Compile.Result<VirtPart, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> ParseVirtualPartConfig(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualPart part) {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends TermLoc_Compile.Selector>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = TermLoc_Compile.__default.MakeTermLoc((part).dtor_loc());
    if ((_0_valueOrError0).IsFailure(TermLoc_Compile.TermLoc._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
      return (_0_valueOrError0).<VirtPart>PropagateFailure(TermLoc_Compile.TermLoc._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), VirtPart._typeDescriptor());
    } else {
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _1_loc = (_0_valueOrError0).Extract(TermLoc_Compile.TermLoc._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      if (((part).dtor_trans()).is_None()) {
        return Wrappers_Compile.Result.<VirtPart, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(VirtPart._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), VirtPart.create(_1_loc, dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform> empty(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform._typeDescriptor())));
      } else {
        return Wrappers_Compile.Result.<VirtPart, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(VirtPart._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), VirtPart.create(_1_loc, ((part).dtor_trans()).dtor_value()));
      }
    }
  }
  public static boolean Examine(dafny.DafnySequence<? extends VirtPart> parts, java.util.function.Function<dafny.DafnySequence<? extends TermLoc_Compile.Selector>, Boolean> exam)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((parts).length())).signum() == 0) {
        return false;
      } else if (((boolean)(java.lang.Object)((exam).apply((((VirtPart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_loc())))) {
        return true;
      } else {
        dafny.DafnySequence<? extends VirtPart> _in0 = (parts).drop(java.math.BigInteger.ONE);
        java.util.function.Function<dafny.DafnySequence<? extends TermLoc_Compile.Selector>, Boolean> _in1 = exam;
        parts = _in0;
        exam = _in1;
        continue TAIL_CALL_START;
      }
    }
  }
  public static java.math.BigInteger Min(java.math.BigInteger x, java.math.BigInteger y)
  {
    if ((y).compareTo(x) < 0) {
      return y;
    } else {
      return x;
    }
  }
  public static dafny.DafnySequence<? extends Character> GetPrefix(dafny.DafnySequence<? extends Character> s, java.math.BigInteger length)
  {
    if ((length).signum() != -1) {
      return (s).take(__default.Min(length, java.math.BigInteger.valueOf((s).length())));
    } else {
      return (s).take((java.math.BigInteger.valueOf((s).length())).subtract(__default.Min((java.math.BigInteger.ZERO).subtract(length), java.math.BigInteger.valueOf((s).length()))));
    }
  }
  public static dafny.DafnySequence<? extends Character> GetSuffix(dafny.DafnySequence<? extends Character> s, java.math.BigInteger length)
  {
    if ((length).signum() != -1) {
      return (s).drop((java.math.BigInteger.valueOf((s).length())).subtract(__default.Min(length, java.math.BigInteger.valueOf((s).length()))));
    } else {
      return (s).drop(__default.Min((java.math.BigInteger.ZERO).subtract(length), java.math.BigInteger.valueOf((s).length())));
    }
  }
  public static java.math.BigInteger GetPos(java.math.BigInteger pos, java.math.BigInteger limit)
  {
    if ((limit).signum() == 0) {
      return java.math.BigInteger.ZERO;
    } else if ((pos).signum() != -1) {
      return __default.Min(pos, (limit).subtract(java.math.BigInteger.ONE));
    } else if (((limit).add(pos)).signum() == -1) {
      return java.math.BigInteger.ZERO;
    } else {
      return (limit).add(pos);
    }
  }
  public static dafny.DafnySequence<? extends Character> GetSubstring(dafny.DafnySequence<? extends Character> s, java.math.BigInteger low, java.math.BigInteger high)
  {
    java.math.BigInteger _0_lo = __default.GetPos(low, java.math.BigInteger.valueOf((s).length()));
    java.math.BigInteger _1_hi = __default.GetPos(high, java.math.BigInteger.valueOf((s).length()));
    if ((_0_lo).compareTo(_1_hi) < 0) {
      return (s).subsequence(dafny.Helpers.toInt((_0_lo)), dafny.Helpers.toInt((_1_hi)));
    } else {
      return dafny.DafnySequence.asString("");
    }
  }
  public static char UpperChar(char ch) {
    if ((('a') <= (ch)) && ((ch) <= ('z'))) {
      return (char) (((char) ((ch) - ('a'))) + ('A'));
    } else {
      return ch;
    }
  }
  public static dafny.DafnySequence<? extends Character> UpperCase(dafny.DafnySequence<? extends Character> s) {
    return Seq_Compile.__default.<Character, Character>Map(dafny.TypeDescriptor.CHAR, dafny.TypeDescriptor.CHAR, ((java.util.function.Function<Character, Character>)(_0_c_boxed0) -> {
      char _0_c = ((char)(java.lang.Object)(_0_c_boxed0));
      return __default.UpperChar(_0_c);
    }), s);
  }
  public static char LowerChar(char ch) {
    if ((('A') <= (ch)) && ((ch) <= ('Z'))) {
      return (char) (((char) ((ch) - ('A'))) + ('a'));
    } else {
      return ch;
    }
  }
  public static dafny.DafnySequence<? extends Character> LowerCase(dafny.DafnySequence<? extends Character> s) {
    return Seq_Compile.__default.<Character, Character>Map(dafny.TypeDescriptor.CHAR, dafny.TypeDescriptor.CHAR, ((java.util.function.Function<Character, Character>)(_0_c_boxed0) -> {
      char _0_c = ((char)(java.lang.Object)(_0_c_boxed0));
      return __default.LowerChar(_0_c);
    }), s);
  }
  public static dafny.DafnySequence<? extends Character> GetSegment(dafny.DafnySequence<? extends Character> s, char split, java.math.BigInteger index)
  {
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _0_parts = StandardLibrary_Compile.__default.<Character>Split(dafny.TypeDescriptor.CHAR, s, split);
    if (((index).compareTo(java.math.BigInteger.valueOf((_0_parts).length())) >= 0) || (((java.math.BigInteger.ZERO).subtract(index)).compareTo(java.math.BigInteger.valueOf((_0_parts).length())) > 0)) {
      return dafny.DafnySequence.asString("");
    } else {
      return ((dafny.DafnySequence<? extends Character>)(java.lang.Object)((_0_parts).select(dafny.Helpers.toInt((__default.GetPos(index, java.math.BigInteger.valueOf((_0_parts).length())))))));
    }
  }
  public static dafny.DafnySequence<? extends Character> GetSegments(dafny.DafnySequence<? extends Character> s, char split, java.math.BigInteger low, java.math.BigInteger high)
  {
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _0_parts = StandardLibrary_Compile.__default.<Character>Split(dafny.TypeDescriptor.CHAR, s, split);
    java.math.BigInteger _1_lo = __default.GetPos(low, java.math.BigInteger.valueOf((_0_parts).length()));
    java.math.BigInteger _2_hi = __default.GetPos(high, java.math.BigInteger.valueOf((_0_parts).length()));
    if ((_1_lo).compareTo(_2_hi) < 0) {
      return StandardLibrary_Compile.__default.<Character>Join(dafny.TypeDescriptor.CHAR, (_0_parts).subsequence(dafny.Helpers.toInt((_1_lo)), dafny.Helpers.toInt((_2_hi))), dafny.DafnySequence.<Character> of(split));
    } else {
      return dafny.DafnySequence.asString("");
    }
  }
  public static dafny.DafnySequence<? extends Character> DoTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform t, dafny.DafnySequence<? extends Character> s)
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform _source0 = t;
    if (_source0.is_upper()) {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Upper _0___mcc_h0 = ((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform_upper)_source0)._upper;
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Upper _1_up = _0___mcc_h0;
      return __default.UpperCase(s);
    } else if (_source0.is_lower()) {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Lower _2___mcc_h1 = ((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform_lower)_source0)._lower;
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Lower _3_lo = _2___mcc_h1;
      return __default.LowerCase(s);
    } else if (_source0.is_insert()) {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Insert _4___mcc_h2 = ((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform_insert)_source0)._insert;
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Insert _5_ins = _4___mcc_h2;
      return dafny.DafnySequence.<Character>concatenate(s, (_5_ins).dtor_literal());
    } else if (_source0.is_prefix()) {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetPrefix _6___mcc_h3 = ((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform_prefix)_source0)._prefix;
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetPrefix _7_pre = _6___mcc_h3;
      return __default.GetPrefix(s, java.math.BigInteger.valueOf((_7_pre).dtor_length()));
    } else if (_source0.is_suffix()) {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSuffix _8___mcc_h4 = ((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform_suffix)_source0)._suffix;
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSuffix _9_suf = _8___mcc_h4;
      return __default.GetSuffix(s, java.math.BigInteger.valueOf((_9_suf).dtor_length()));
    } else if (_source0.is_substring()) {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSubstring _10___mcc_h5 = ((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform_substring)_source0)._substring;
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSubstring _11_sub = _10___mcc_h5;
      return __default.GetSubstring(s, java.math.BigInteger.valueOf((_11_sub).dtor_low()), java.math.BigInteger.valueOf((_11_sub).dtor_high()));
    } else if (_source0.is_segment()) {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegment _12___mcc_h6 = ((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform_segment)_source0)._segment;
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegment _13_seg = _12___mcc_h6;
      return __default.GetSegment(s, ((char)(java.lang.Object)(((_13_seg).dtor_split()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), java.math.BigInteger.valueOf((_13_seg).dtor_index()));
    } else {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegments _14___mcc_h7 = ((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform_segments)_source0)._segments;
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetSegments _15_seg = _14___mcc_h7;
      return __default.GetSegments(s, ((char)(java.lang.Object)(((_15_seg).dtor_split()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), java.math.BigInteger.valueOf((_15_seg).dtor_low()), java.math.BigInteger.valueOf((_15_seg).dtor_high()));
    }
  }
  public static dafny.DafnySequence<? extends Character> FullTransform(dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform> t, dafny.DafnySequence<? extends Character> s)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((t).length())).signum() == 0) {
        return s;
      } else {
        dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform> _in0 = (t).drop(java.math.BigInteger.ONE);
        dafny.DafnySequence<? extends Character> _in1 = __default.DoTransform(((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualTransform)(java.lang.Object)((t).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), s);
        t = _in0;
        s = _in1;
        continue TAIL_CALL_START;
      }
    }
  }
  public static Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GetVirtField(VirtField vf, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item)
  {
    return __default.GetVirtField2((vf).dtor_parts(), item, dafny.DafnySequence.asString(""));
  }
  public static Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GetVirtField2(dafny.DafnySequence<? extends VirtPart> parts, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item, dafny.DafnySequence<? extends Character> acc)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((parts).length())).signum() == 0) {
        return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), acc));
      } else {
        Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = TermLoc_Compile.__default.TermToString((((VirtPart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_loc(), item);
        if ((_0_valueOrError0).IsFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          return (_0_valueOrError0).<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>>PropagateFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
        } else {
          Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _1_value = (_0_valueOrError0).Extract(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
          if ((_1_value).is_None()) {
            return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
          } else {
            dafny.DafnySequence<? extends Character> _2_trans = __default.FullTransform((((VirtPart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_trans(), (_1_value).dtor_value());
            dafny.DafnySequence<? extends VirtPart> _in0 = (parts).drop(java.math.BigInteger.ONE);
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _in1 = item;
            dafny.DafnySequence<? extends Character> _in2 = dafny.DafnySequence.<Character>concatenate(acc, _2_trans);
            parts = _in0;
            item = _in1;
            acc = _in2;
            continue TAIL_CALL_START;
          }
        }
      }
    }
  }
  public static Wrappers_Compile.Result<Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> VirtToAttr(dafny.DafnySequence<? extends TermLoc_Compile.Selector> loc, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends VirtField> vf)
  {
    if ((java.util.Objects.equals(java.math.BigInteger.valueOf((loc).length()), java.math.BigInteger.ONE)) && ((vf).<dafny.DafnySequence<? extends Character>>contains((((TermLoc_Compile.Selector)(java.lang.Object)((loc).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key()))) {
      Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = __default.GetVirtField(((VirtField)(java.lang.Object)((vf).get((((TermLoc_Compile.Selector)(java.lang.Object)((loc).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key()))), item);
      if ((_0_valueOrError0).IsFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        return (_0_valueOrError0).<Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>PropagateFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()));
      } else {
        Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _1_str = (_0_valueOrError0).Extract(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        if ((_1_str).is_None()) {
          return Wrappers_Compile.Result.<Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()));
        } else {
          return Wrappers_Compile.Result.<Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>create_Some(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), __default.DS((_1_str).dtor_value())));
        }
      }
    } else {
      return Wrappers_Compile.Result.<Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), TermLoc_Compile.__default.TermToAttr(loc, item, Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>create_None(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor()))));
    }
  }
  public static Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> VirtToBytes(dafny.DafnySequence<? extends TermLoc_Compile.Selector> loc, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends VirtField> vf)
  {
    if ((java.util.Objects.equals(java.math.BigInteger.valueOf((loc).length()), java.math.BigInteger.ONE)) && ((vf).<dafny.DafnySequence<? extends Character>>contains((((TermLoc_Compile.Selector)(java.lang.Object)((loc).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key()))) {
      Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = __default.GetVirtField(((VirtField)(java.lang.Object)((vf).get((((TermLoc_Compile.Selector)(java.lang.Object)((loc).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key()))), item);
      if ((_0_valueOrError0).IsFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        return (_0_valueOrError0).<Wrappers_Compile.Option<dafny.DafnySequence<? extends java.lang.Byte>>>PropagateFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())));
      } else {
        Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _1_str = (_0_valueOrError0).Extract(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        if ((_1_str).is_None()) {
          return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>create_None(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())));
        } else {
          Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _2_valueOrError1 = (UTF8.__default.Encode((_1_str).dtor_value())).<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>MapFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)(_3_e_boxed0) -> {
            dafny.DafnySequence<? extends Character> _3_e = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_3_e_boxed0));
            return DynamoDbEncryptionUtil_Compile.__default.E(_3_e);
          }));
          if ((_2_valueOrError1).IsFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
            return (_2_valueOrError1).<Wrappers_Compile.Option<dafny.DafnySequence<? extends java.lang.Byte>>>PropagateFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())));
          } else {
            dafny.DafnySequence<? extends java.lang.Byte> _4_ustr = (_2_valueOrError1).Extract(UTF8.ValidUTF8Bytes._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
            return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>create_Some(UTF8.ValidUTF8Bytes._typeDescriptor(), _4_ustr));
          }
        }
      }
    } else {
      return TermLoc_Compile.__default.TermToBytes(loc, item);
    }
  }
  public static Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> VirtToString(dafny.DafnySequence<? extends TermLoc_Compile.Selector> loc, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends VirtField> vf)
  {
    if ((java.util.Objects.equals(java.math.BigInteger.valueOf((loc).length()), java.math.BigInteger.ONE)) && ((vf).<dafny.DafnySequence<? extends Character>>contains((((TermLoc_Compile.Selector)(java.lang.Object)((loc).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key()))) {
      return __default.GetVirtField(((VirtField)(java.lang.Object)((vf).get((((TermLoc_Compile.Selector)(java.lang.Object)((loc).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key()))), item);
    } else {
      return TermLoc_Compile.__default.TermToString(loc, item);
    }
  }
  public static software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue DS(dafny.DafnySequence<? extends Character> s) {
    return software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(s);
  }
  @Override
  public java.lang.String toString() {
    return "DdbVirtualFields._default";
  }
}
