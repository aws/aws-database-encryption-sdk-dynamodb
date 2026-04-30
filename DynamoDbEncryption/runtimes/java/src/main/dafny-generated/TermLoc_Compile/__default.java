// Class __default
// Dafny class __default compiled into Java
package TermLoc_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static boolean ValidTermLoc(dafny.DafnySequence<? extends Selector> s) {
    return ((((long) (s).cardinalityInt()) == 0 ? 0 : 1) == 1) && ((((Selector)(java.lang.Object)((s).select(0)))).is_Map());
  }
  public static dafny.DafnySequence<? extends Character> TermLocToString(dafny.DafnySequence<? extends Selector> t) {
    return dafny.DafnySequence.<Character>concatenate((((Selector)(java.lang.Object)((t).select(0)))).dtor_key(), __default.SelectorListToString((t).drop(1)));
  }
  public static dafny.DafnySequence<? extends Character> SelectorListToString(dafny.DafnySequence<? extends Selector> s) {
    dafny.DafnySequence<? extends Character> _0___accumulator = dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR);
    TAIL_CALL_START: while (true) {
      if ((((long) (s).cardinalityInt()) == 0 ? 0 : 1) == 0) {
        return dafny.DafnySequence.<Character>concatenate(_0___accumulator, dafny.DafnySequence.asString(""));
      } else if ((((Selector)(java.lang.Object)((s).select(0)))).is_Map()) {
        _0___accumulator = dafny.DafnySequence.<Character>concatenate(_0___accumulator, dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("."), (((Selector)(java.lang.Object)((s).select(0)))).dtor_key()));
        dafny.DafnySequence<? extends Selector> _in0 = (s).drop(1);
        s = _in0;
        continue TAIL_CALL_START;
      } else {
        _0___accumulator = dafny.DafnySequence.<Character>concatenate(_0___accumulator, dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("["), StandardLibrary_mString_Compile.__default.Base10Int2String(dafny.Helpers.unsignedToBigInteger((((Selector)(java.lang.Object)((s).select(0)))).dtor_pos()))), dafny.DafnySequence.asString("]")));
        dafny.DafnySequence<? extends Selector> _in1 = (s).drop(1);
        s = _in1;
        continue TAIL_CALL_START;
      }
    }
  }
  public static boolean LacksAttribute(dafny.DafnySequence<? extends Selector> t, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item)
  {
    return !(item).<dafny.DafnySequence<? extends Character>>contains((((Selector)(java.lang.Object)((t).select(0)))).dtor_key());
  }
  public static Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> TermToAttr(dafny.DafnySequence<? extends Selector> t, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names)
  {
    if (!(item).<dafny.DafnySequence<? extends Character>>contains((((Selector)(java.lang.Object)((t).select(0)))).dtor_key())) {
      return Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor());
    } else {
      Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_res = __default.GetTerminal(((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((item).get((((Selector)(java.lang.Object)((t).select(0)))).dtor_key()))), (t).drop(1), names);
      if ((_0_res).is_Success()) {
        return Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>create_Some(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), (_0_res).dtor_value());
      } else {
        return Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor());
      }
    }
  }
  public static Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> TermToString(dafny.DafnySequence<? extends Selector> t, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item)
  {
    Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _0_part = __default.TermToAttr(t, item, Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>create_None(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor())));
    if ((_0_part).is_None()) {
      return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
    } else {
      Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _1_valueOrError0 = __default.AttrValueToString((_0_part).dtor_value());
      if ((_1_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        return (_1_valueOrError0).<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
      } else {
        dafny.DafnySequence<? extends Character> _2_res = (_1_valueOrError0).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _2_res));
      }
    }
  }
  public static Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> TermToBytes(dafny.DafnySequence<? extends Selector> t, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item)
  {
    Wrappers_Compile.Option<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _0_part = __default.TermToAttr(t, item, Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>create_None(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor())));
    if ((_0_part).is_None()) {
      return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>create_None(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())));
    } else {
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _1_valueOrError0 = (DynamoToStruct_Compile.__default.TopLevelAttributeToBytes((_0_part).dtor_value())).<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>MapFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)(_2_e_boxed0) -> {
        dafny.DafnySequence<? extends Character> _2_e = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_2_e_boxed0));
        return DynamoDbEncryptionUtil_Compile.__default.E(_2_e);
      }));
      if ((_1_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        return (_1_valueOrError0).<Wrappers_Compile.Option<dafny.DafnySequence<? extends java.lang.Byte>>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())));
      } else {
        dafny.DafnySequence<? extends java.lang.Byte> _3_res = (_1_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends java.lang.Byte>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>create_Some(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), _3_res));
      }
    }
  }
  public static Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GetTerminal(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue v, dafny.DafnySequence<? extends Selector> parts, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names)
  {
    TAIL_CALL_START: while (true) {
      if ((((long) (parts).cardinalityInt()) == 0 ? 0 : 1) == 0) {
        return Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), v);
      } else {
        software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _source0 = v;
        if (_source0.is_S()) {
          dafny.DafnySequence<? extends Character> _0___mcc_h0 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_S)_source0)._S;
          dafny.DafnySequence<? extends Character> _1_s = _0___mcc_h0;
          return Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Found string with parts left over.")));
        } else if (_source0.is_N()) {
          dafny.DafnySequence<? extends Character> _2___mcc_h1 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_N)_source0)._N;
          dafny.DafnySequence<? extends Character> _3_s = _2___mcc_h1;
          return Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Found number with parts left over.")));
        } else if (_source0.is_B()) {
          dafny.DafnySequence<? extends java.lang.Byte> _4___mcc_h2 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_B)_source0)._B;
          dafny.DafnySequence<? extends java.lang.Byte> _5_b = _4___mcc_h2;
          return Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Found binary with parts left over.")));
        } else if (_source0.is_SS()) {
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _6___mcc_h3 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_SS)_source0)._SS;
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _7_s = _6___mcc_h3;
          return Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Found string set with parts left over.")));
        } else if (_source0.is_NS()) {
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _8___mcc_h4 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_NS)_source0)._NS;
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _9_s = _8___mcc_h4;
          return Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Found number set with parts left over.")));
        } else if (_source0.is_BS()) {
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _10___mcc_h5 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_BS)_source0)._BS;
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _11_s = _10___mcc_h5;
          return Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Found binary set with parts left over.")));
        } else if (_source0.is_M()) {
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _12___mcc_h6 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_M)_source0)._M;
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _13_m = _12___mcc_h6;
          if (!((((Selector)(java.lang.Object)((parts).select(0)))).is_Map())) {
            return Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Tried to access map with index")));
          } else if (!(_13_m).<dafny.DafnySequence<? extends Character>>contains((((Selector)(java.lang.Object)((parts).select(0)))).dtor_key())) {
            if ((((names).is_Some()) && (((names).dtor_value()).<dafny.DafnySequence<? extends Character>>contains((((Selector)(java.lang.Object)((parts).select(0)))).dtor_key()))) && ((_13_m).<dafny.DafnySequence<? extends Character>>contains(((dafny.DafnySequence<? extends Character>)(java.lang.Object)(((names).dtor_value()).get((((Selector)(java.lang.Object)((parts).select(0)))).dtor_key())))))) {
              software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _in0 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_13_m).get(((dafny.DafnySequence<? extends Character>)(java.lang.Object)(((names).dtor_value()).get((((Selector)(java.lang.Object)((parts).select(0)))).dtor_key()))))));
              dafny.DafnySequence<? extends Selector> _in1 = (parts).drop(1);
              Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in2 = names;
              v = _in0;
              parts = _in1;
              names = _in2;
              continue TAIL_CALL_START;
            } else {
              return Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Tried to access "), (((Selector)(java.lang.Object)((parts).select(0)))).dtor_key()), dafny.DafnySequence.asString(" which is not in the map."))));
            }
          } else {
            software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _in3 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_13_m).get((((Selector)(java.lang.Object)((parts).select(0)))).dtor_key())));
            dafny.DafnySequence<? extends Selector> _in4 = (parts).drop(1);
            Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in5 = names;
            v = _in3;
            parts = _in4;
            names = _in5;
            continue TAIL_CALL_START;
          }
        } else if (_source0.is_L()) {
          dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _14___mcc_h7 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_L)_source0)._L;
          dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _15_l = _14___mcc_h7;
          if (!((((Selector)(java.lang.Object)((parts).select(0)))).is_List())) {
            return Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Tried to access list with key")));
          } else if (java.lang.Long.compareUnsigned((long) (_15_l).cardinalityInt(), (((Selector)(java.lang.Object)((parts).select(0)))).dtor_pos()) <= 0) {
            return Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Tried to access beyond the end of the list")));
          } else {
            software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _in6 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_15_l).select(dafny.Helpers.unsignedToInt((((Selector)(java.lang.Object)((parts).select(0)))).dtor_pos()))));
            dafny.DafnySequence<? extends Selector> _in7 = (parts).drop(1);
            Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in8 = names;
            v = _in6;
            parts = _in7;
            names = _in8;
            continue TAIL_CALL_START;
          }
        } else if (_source0.is_NULL()) {
          boolean _16___mcc_h8 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_NULL)_source0)._NULL;
          boolean _17_n = _16___mcc_h8;
          return Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Found null with parts left over.")));
        } else {
          boolean _18___mcc_h9 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_BOOL)_source0)._BOOL;
          boolean _19_b = _18___mcc_h9;
          return Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Found boolean with parts left over.")));
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> AttrValueToString(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue v) {
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _source0 = v;
    if (_source0.is_S()) {
      dafny.DafnySequence<? extends Character> _0___mcc_h0 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_S)_source0)._S;
      dafny.DafnySequence<? extends Character> _1_s = _0___mcc_h0;
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), _1_s);
    } else if (_source0.is_N()) {
      dafny.DafnySequence<? extends Character> _2___mcc_h1 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_N)_source0)._N;
      dafny.DafnySequence<? extends Character> _3_s = _2___mcc_h1;
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), _3_s);
    } else if (_source0.is_B()) {
      dafny.DafnySequence<? extends java.lang.Byte> _4___mcc_h2 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_B)_source0)._B;
      dafny.DafnySequence<? extends java.lang.Byte> _5_b = _4___mcc_h2;
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Can't convert Binary to string")));
    } else if (_source0.is_SS()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _6___mcc_h3 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_SS)_source0)._SS;
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _7_s = _6___mcc_h3;
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Can't convert String Set to string.")));
    } else if (_source0.is_NS()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _8___mcc_h4 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_NS)_source0)._NS;
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _9_s = _8___mcc_h4;
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Can't convert Number Set to string.")));
    } else if (_source0.is_BS()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _10___mcc_h5 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_BS)_source0)._BS;
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _11_s = _10___mcc_h5;
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Can't convert Binary Set to string.")));
    } else if (_source0.is_M()) {
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _12___mcc_h6 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_M)_source0)._M;
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _13_m = _12___mcc_h6;
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Can't convert Map to string.")));
    } else if (_source0.is_L()) {
      dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _14___mcc_h7 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_L)_source0)._L;
      dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _15_l = _14___mcc_h7;
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Can't convert List to string.")));
    } else if (_source0.is_NULL()) {
      boolean _16___mcc_h8 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_NULL)_source0)._NULL;
      boolean _17_n = _16___mcc_h8;
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.asString("null"));
    } else {
      boolean _18___mcc_h9 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_BOOL)_source0)._BOOL;
      boolean _19_b = _18___mcc_h9;
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((_19_b) ? (dafny.DafnySequence.asString("true")) : (dafny.DafnySequence.asString("false"))));
    }
  }
  public static Wrappers_Compile.Option<java.lang.Long> FindStartOfNext(dafny.DafnySequence<? extends Character> s) {
    Wrappers_Compile.Option<java.lang.Long> _0_dot = StandardLibrary_Compile.__default.<Character>FindIndexMatching(dafny.TypeDescriptor.CHAR, s, '.', (long) 0L);
    Wrappers_Compile.Option<java.lang.Long> _1_bracket = StandardLibrary_Compile.__default.<Character>FindIndexMatching(dafny.TypeDescriptor.CHAR, s, '[', (long) 0L);
    if (((_0_dot).is_None()) && ((_1_bracket).is_None())) {
      return Wrappers_Compile.Option.<java.lang.Long>create_None(BoundedInts_Compile.uint64._typeDescriptor());
    } else if (((_0_dot).is_Some()) && ((_1_bracket).is_Some())) {
      if (java.lang.Long.compareUnsigned((_0_dot).dtor_value(), (_1_bracket).dtor_value()) < 0) {
        return _0_dot;
      } else {
        return _1_bracket;
      }
    } else if ((_0_dot).is_Some()) {
      return _0_dot;
    } else {
      return _1_bracket;
    }
  }
  public static Wrappers_Compile.Result<java.lang.Long, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GetNumber(dafny.DafnySequence<? extends Character> s, long acc, long pos)
  {
    TAIL_CALL_START: while (true) {
      if (((long) (s).cardinalityInt()) == (pos)) {
        return Wrappers_Compile.Result.<java.lang.Long, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(BoundedInts_Compile.uint64._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), acc);
      } else if ((('0') <= (((char)(java.lang.Object)((s).select(0))))) && ((((char)(java.lang.Object)((s).select(0)))) <= ('9'))) {
        if (java.lang.Long.compareUnsigned(acc, (long) 1152921504606846975L) < 0) {
          dafny.DafnySequence<? extends Character> _in0 = s;
          long _in1 = (long) (long) (((long) (long) (((long) (long) ((acc) * ((long) 10L))) + (((long) (((char)(java.lang.Object)((s).select(0)))))))) - (((long) ('0'))));
          long _in2 = StandardLibrary_mMemoryMath_Compile.__default.Add(pos, (long) 1L);
          s = _in0;
          acc = _in1;
          pos = _in2;
          continue TAIL_CALL_START;
        } else {
          return Wrappers_Compile.Result.<java.lang.Long, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(BoundedInts_Compile.uint64._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Number is too big for list index : "), s)));
        }
      } else {
        return Wrappers_Compile.Result.<java.lang.Long, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(BoundedInts_Compile.uint64._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Unexpected character in number : "), dafny.DafnySequence.<Character> of(((char)(java.lang.Object)((s).select(0)))))));
      }
    }
  }
  public static Wrappers_Compile.Result<Selector, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GetSelector(dafny.DafnySequence<? extends Character> s) {
    if ((((char)(java.lang.Object)((s).select(0)))) == ('.')) {
      return Wrappers_Compile.Result.<Selector, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(Selector._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Selector.create_Map((s).drop(1)));
    } else if ((((char)(java.lang.Object)((s).select(dafny.Helpers.unsignedToInt((long) (long) (((long) (s).cardinalityInt()) - ((long) 1L))))))) != (']')) {
      return Wrappers_Compile.Result.<Selector, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(Selector._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("List index must end with ]")));
    } else {
      Wrappers_Compile.Result<java.lang.Long, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = __default.GetNumber((s).subsequence(1, dafny.Helpers.unsignedToInt((long) (long) (((long) (s).cardinalityInt()) - ((long) 1L)))), (long) 0L, (long) 0L);
      if ((_0_valueOrError0).IsFailure(BoundedInts_Compile.uint64._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        return (_0_valueOrError0).<Selector>PropagateFailure(BoundedInts_Compile.uint64._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Selector._typeDescriptor());
      } else {
        long _1_num = (_0_valueOrError0).Extract(BoundedInts_Compile.uint64._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        return Wrappers_Compile.Result.<Selector, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(Selector._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Selector.create_List(_1_num));
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends Selector>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GetSelectors(dafny.DafnySequence<? extends Character> s, dafny.DafnySequence<? extends Selector> acc)
  {
    TAIL_CALL_START: while (true) {
      Wrappers_Compile.Option<java.lang.Long> _0_pos = __default.FindStartOfNext((s).drop(1));
      long _1_end = (((_0_pos).is_None()) ? ((long) (s).cardinalityInt()) : (StandardLibrary_mMemoryMath_Compile.__default.Add((_0_pos).dtor_value(), (long) 1L)));
      Wrappers_Compile.Result<Selector, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _2_valueOrError0 = __default.GetSelector((s).take(_1_end));
      if ((_2_valueOrError0).IsFailure(Selector._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        return (_2_valueOrError0).<dafny.DafnySequence<? extends Selector>>PropagateFailure(Selector._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<Selector>_typeDescriptor(Selector._typeDescriptor()));
      } else {
        Selector _3_sel = (_2_valueOrError0).Extract(Selector._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        if ((_0_pos).is_None()) {
          return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Selector>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnySequence.<Selector>_typeDescriptor(Selector._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<Selector>concatenate(acc, dafny.DafnySequence.<Selector> of(Selector._typeDescriptor(), _3_sel)));
        } else {
          dafny.DafnySequence<? extends Character> _in0 = (s).drop(_1_end);
          dafny.DafnySequence<? extends Selector> _in1 = dafny.DafnySequence.<Selector>concatenate(acc, dafny.DafnySequence.<Selector> of(Selector._typeDescriptor(), _3_sel));
          s = _in0;
          acc = _in1;
          continue TAIL_CALL_START;
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends Selector>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> MakeTermLoc(dafny.DafnySequence<? extends Character> s) {
    Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), (((long) (s).cardinalityInt()) == 0 ? 0 : 1) == 1, DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Path specification must not be empty.")));
    if ((_0_valueOrError0).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
      return (_0_valueOrError0).<dafny.DafnySequence<? extends Selector>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<Selector>_typeDescriptor(Selector._typeDescriptor()));
    } else {
      Wrappers_Compile.Option<java.lang.Long> _1_pos = __default.FindStartOfNext(s);
      if ((_1_pos).is_None()) {
        Selector _2_m = Selector.create_Map(s);
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Selector>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnySequence.<Selector>_typeDescriptor(Selector._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<Selector> of(Selector._typeDescriptor(), Selector.create_Map(s)));
      } else {
        dafny.DafnySequence<? extends Character> _3_name = (s).take((_1_pos).dtor_value());
        Wrappers_Compile.Result<dafny.DafnySequence<? extends Selector>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _4_valueOrError1 = __default.GetSelectors((s).drop((_1_pos).dtor_value()), dafny.DafnySequence.<Selector> empty(Selector._typeDescriptor()));
        if ((_4_valueOrError1).IsFailure(dafny.DafnySequence.<Selector>_typeDescriptor(Selector._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          return (_4_valueOrError1).<dafny.DafnySequence<? extends Selector>>PropagateFailure(dafny.DafnySequence.<Selector>_typeDescriptor(Selector._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<Selector>_typeDescriptor(Selector._typeDescriptor()));
        } else {
          dafny.DafnySequence<? extends Selector> _5_selectors = (_4_valueOrError1).Extract(dafny.DafnySequence.<Selector>_typeDescriptor(Selector._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
          return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Selector>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnySequence.<Selector>_typeDescriptor(Selector._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<Selector>concatenate(dafny.DafnySequence.<Selector> of(Selector._typeDescriptor(), Selector.create_Map(_3_name)), _5_selectors));
        }
      }
    }
  }
  public static dafny.DafnySequence<? extends Selector> TermLocMap(dafny.DafnySequence<? extends Character> attr) {
    return dafny.DafnySequence.<Selector> of(Selector._typeDescriptor(), Selector.create_Map(attr));
  }
  @Override
  public java.lang.String toString() {
    return "TermLoc._default";
  }
}
