// Class __default
// Dafny class __default compiled into Java
package DynamoToStruct_Compile;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.*;
import DynamoDbEncryptionUtil_Compile.*;
import DynamoDbNormalizeNumber_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> ItemToStructured(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item) {
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData, dafny.DafnySequence<? extends Character>>> _55_structuredMap = ((java.util.function.Function<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData, dafny.DafnySequence<? extends Character>>>>)(_56_item) -> ((dafny.Function0<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData, dafny.DafnySequence<? extends Character>>>>)(() -> {
      java.util.HashMap<dafny.DafnySequence<? extends Character>, Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData, dafny.DafnySequence<? extends Character>>> _coll0 = new java.util.HashMap<>();
      for (dafny.Tuple2<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _compr_0_boxed0 : ((_56_item).<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>entrySet()).Elements()) {
        dafny.Tuple2<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _compr_0 = ((dafny.Tuple2<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>)(java.lang.Object)(_compr_0_boxed0));
        if (true) {
          dafny.Tuple2<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _57_kv = (dafny.Tuple2<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>)_compr_0;
          if ((((_56_item).<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>entrySet()).<dafny.Tuple2<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>contains(_57_kv)) && (true)) {
            _coll0.put((_57_kv).dtor__0(),__default.AttrToStructured((_57_kv).dtor__1()));
          }
        }
      }
      return new dafny.DafnyMap<dafny.DafnySequence<? extends Character>,Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData, dafny.DafnySequence<? extends Character>>>(_coll0);
    })).apply()).apply(item);
    return __default.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>>MapError(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData._typeDescriptor()), __default.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>SimplifyMapValue(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData._typeDescriptor(), _55_structuredMap));
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> StructuredToItem(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> s) {
    if (((java.util.function.Function<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, Boolean>)(_58_s) -> dafny.Helpers.Quantifier(((_58_s).keySet()).Elements(), true, ((_forall_var_0_boxed0) -> {
      dafny.DafnySequence<? extends Character> _forall_var_0 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_forall_var_0_boxed0));
      if (true) {
        dafny.DafnySequence<? extends Character> _59_k = (dafny.DafnySequence<? extends Character>)_forall_var_0;
        return !(((_58_s).keySet()).<dafny.DafnySequence<? extends Character>>contains(_59_k)) || (Dafny.Com.Amazonaws.Dynamodb.Types.__default.IsValid__AttributeName(_59_k));
      } else {
        return true;
      }
    }))).apply(s)) {
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue, dafny.DafnySequence<? extends Character>>> _60_structuredData = ((java.util.function.Function<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue, dafny.DafnySequence<? extends Character>>>>)(_61_s) -> ((dafny.Function0<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue, dafny.DafnySequence<? extends Character>>>>)(() -> {
        java.util.HashMap<dafny.DafnySequence<? extends Character>, Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue, dafny.DafnySequence<? extends Character>>> _coll1 = new java.util.HashMap<>();
        for (dafny.Tuple2<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> _compr_1_boxed0 : ((_61_s).<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>entrySet()).Elements()) {
          dafny.Tuple2<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> _compr_1 = ((dafny.Tuple2<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>)(java.lang.Object)(_compr_1_boxed0));
          if (true) {
            dafny.Tuple2<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> _62_kv = (dafny.Tuple2<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>)_compr_1;
            if ((((_61_s).<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>entrySet()).<dafny.Tuple2<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>>contains(_62_kv)) && (true)) {
              _coll1.put((_62_kv).dtor__0(),__default.StructuredToAttr((_62_kv).dtor__1()));
            }
          }
        }
        return new dafny.DafnyMap<dafny.DafnySequence<? extends Character>,Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue, dafny.DafnySequence<? extends Character>>>(_coll1);
      })).apply()).apply(s);
      return __default.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>MapError(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), __default.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>SimplifyMapValue(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor(), _60_structuredData));
    } else {
      dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> _63_badNames = ((java.util.function.Function<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>>>)(_64_s) -> ((dafny.Function0<dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>>>)(() -> {
        java.util.ArrayList<dafny.DafnySequence<? extends Character>> _coll2 = new java.util.ArrayList<>();
        for (dafny.DafnySequence<? extends Character> _compr_2_boxed0 : ((_64_s).keySet()).Elements()) {
          dafny.DafnySequence<? extends Character> _compr_2 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_compr_2_boxed0));
          if (true) {
            dafny.DafnySequence<? extends Character> _65_k = (dafny.DafnySequence<? extends Character>)_compr_2;
            if ((((_64_s).keySet()).<dafny.DafnySequence<? extends Character>>contains(_65_k)) && (!(Dafny.Com.Amazonaws.Dynamodb.Types.__default.IsValid__AttributeName(_65_k)))) {
              _coll2.add(_65_k);
            }
          }
        }
        return new dafny.DafnySet<dafny.DafnySequence<? extends Character>>(_coll2);
      })).apply()).apply(s);
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _66_orderedAttrNames = StandardLibrary_Compile.__default.<Character>SetToOrderedSequence(dafny.TypeDescriptor.CHAR, _63_badNames, __default::CharLess);
      dafny.DafnySequence<? extends Character> _67_attrNameList = StandardLibrary_Compile.__default.<Character>Join(dafny.TypeDescriptor.CHAR, _66_orderedAttrNames, dafny.DafnySequence.asString(","));
      return __default.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>MakeError(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Not valid attribute names : "), _67_attrNameList));
    }
  }
  public static <__T> Wrappers_Compile.Result<__T, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> MakeError(dafny.TypeDescriptor<__T> _td___T, dafny.DafnySequence<? extends Character> s)
  {
    return Wrappers_Compile.Result.<__T, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error.create_DynamoDbEncryptionException(s));
  }
  public static <__T> Wrappers_Compile.Result<__T, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> MapError(dafny.TypeDescriptor<__T> _td___T, Wrappers_Compile.Result<__T, dafny.DafnySequence<? extends Character>> r)
  {
    if ((r).is_Success()) {
      return Wrappers_Compile.Result.<__T, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success((r).dtor_value());
    } else {
      return __default.<__T>MakeError(_td___T, (r).dtor_error());
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> TopLevelAttributeToBytes(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue a) {
    return __default.AttrToBytes(a, false);
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData, dafny.DafnySequence<? extends Character>> AttrToStructured(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue item) {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _68_valueOrError0 = __default.TopLevelAttributeToBytes(item);
    if ((_68_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      return (_68_valueOrError0).<Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData._typeDescriptor());
    } else {
      dafny.DafnySequence<? extends java.lang.Byte> _69_body = (_68_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
      return Wrappers_Compile.Result.<Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData, dafny.DafnySequence<? extends Character>>create_Success(Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData.create(Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredDataContent.create_Terminal(Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredDataTerminal.create(_69_body, __default.AttrToTypeId(item))), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredDataTerminal>>create_None()));
    }
  }
  public static Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue, dafny.DafnySequence<? extends Character>> StructuredToAttr(Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData s) {
    Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _70_valueOrError0 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((s).dtor_attributes()).is_None(), dafny.DafnySequence.asString("attributes must be None"));
    if ((_70_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      return (_70_valueOrError0).<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor());
    } else {
      Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _71_valueOrError1 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((s).dtor_content()).is_Terminal(), dafny.DafnySequence.asString("StructuredData to AttributeValue only works on Terminal data"));
      if ((_71_valueOrError1).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_71_valueOrError1).<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor());
      } else {
        Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredDataContent _let_tmp_rhs3 = (s).dtor_content();
        Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredDataTerminal _72_s = ((Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredDataContent_Terminal)_let_tmp_rhs3)._Terminal;
        Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _73_valueOrError2 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), java.util.Objects.equals(java.math.BigInteger.valueOf(((_72_s).dtor_typeId()).length()), java.math.BigInteger.valueOf(2L)), dafny.DafnySequence.asString("Type ID must be two bytes"));
        if ((_73_valueOrError2).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_73_valueOrError2).<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor());
        } else {
          Wrappers_Compile.Result<AttrValueAndLength, dafny.DafnySequence<? extends Character>> _74_valueOrError3 = __default.BytesToAttr((_72_s).dtor_value(), (_72_s).dtor_typeId(), false);
          if ((_74_valueOrError3).IsFailure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
            return (_74_valueOrError3).<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>PropagateFailure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor());
          } else {
            AttrValueAndLength _75_attrValueAndLength = (_74_valueOrError3).Extract(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
            Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _76_valueOrError4 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), java.util.Objects.equals((_75_attrValueAndLength).dtor_len(), java.math.BigInteger.valueOf(((_72_s).dtor_value()).length())), dafny.DafnySequence.asString("Mismatch between length of encoded data and length of data"));
            if ((_76_valueOrError4).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
              return (_76_valueOrError4).<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor());
            } else {
              return Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue, dafny.DafnySequence<? extends Character>>create_Success((_75_attrValueAndLength).dtor_val());
            }
          }
        }
      }
    }
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> AttrToTypeId(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue a) {
    Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue _source1 = a;
    if (_source1.is_S()) {
      dafny.DafnySequence<? extends Character> _77___mcc_h0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_S)_source1)._S;
      dafny.DafnySequence<? extends Character> _78_s = _77___mcc_h0;
      return __default.STRING();
    } else if (_source1.is_N()) {
      dafny.DafnySequence<? extends Character> _79___mcc_h1 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_N)_source1)._N;
      dafny.DafnySequence<? extends Character> _80_n = _79___mcc_h1;
      return __default.NUMBER();
    } else if (_source1.is_B()) {
      dafny.DafnySequence<? extends java.lang.Byte> _81___mcc_h2 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_B)_source1)._B;
      dafny.DafnySequence<? extends java.lang.Byte> _82_b = _81___mcc_h2;
      return __default.BINARY();
    } else if (_source1.is_SS()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _83___mcc_h3 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_SS)_source1)._SS;
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _84_ss = _83___mcc_h3;
      return __default.STRING__SET();
    } else if (_source1.is_NS()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _85___mcc_h4 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_NS)_source1)._NS;
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _86_ns = _85___mcc_h4;
      return __default.NUMBER__SET();
    } else if (_source1.is_BS()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _87___mcc_h5 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_BS)_source1)._BS;
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _88_bs = _87___mcc_h5;
      return __default.BINARY__SET();
    } else if (_source1.is_M()) {
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _89___mcc_h6 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_M)_source1)._M;
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _90_m = _89___mcc_h6;
      return __default.MAP();
    } else if (_source1.is_L()) {
      dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _91___mcc_h7 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_L)_source1)._L;
      dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _92_l = _91___mcc_h7;
      return __default.LIST();
    } else if (_source1.is_NULL()) {
      boolean _93___mcc_h8 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_NULL)_source1)._NULL;
      boolean _94_n = _93___mcc_h8;
      return __default.NULL();
    } else {
      boolean _95___mcc_h9 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_BOOL)_source1)._BOOL;
      boolean _96_b = _95___mcc_h9;
      return __default.BOOLEAN();
    }
  }
  public static boolean CharLess(char x, char y)
  {
    return (x) < (y);
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> AttrToBytes(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue a, boolean prefix)
  {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _97_valueOrError0 = ((java.util.function.Function<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue, Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>>)(_source2_boxed0) -> {
      Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue _source2 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue)(java.lang.Object)(_source2_boxed0));
      if (_source2.is_S()) {
        dafny.DafnySequence<? extends Character> _98___mcc_h0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_S)_source2)._S;
        return ((Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Character>, Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>>Let(_98___mcc_h0, boxed0 -> {
          dafny.DafnySequence<? extends Character> _pat_let0_0 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(boxed0));
          return ((Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Character>, Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>>Let(_pat_let0_0, boxed1 -> {
            dafny.DafnySequence<? extends Character> _99_s = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(boxed1));
            return UTF8.__default.Encode(_99_s);
          }
          )));
        }
        )));
      } else if (_source2.is_N()) {
        dafny.DafnySequence<? extends Character> _100___mcc_h1 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_N)_source2)._N;
        return ((Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Character>, Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>>Let(_100___mcc_h1, boxed2 -> {
          dafny.DafnySequence<? extends Character> _pat_let1_0 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(boxed2));
          return ((Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Character>, Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>>Let(_pat_let1_0, boxed3 -> {
            dafny.DafnySequence<? extends Character> _101_n = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(boxed3));
            return ((Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>, Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>>Let(DynamoDbNormalizeNumber_Compile.__default.NormalizeNumber(_101_n), boxed4 -> {
              Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _pat_let2_0 = ((Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>)(java.lang.Object)(boxed4));
              return ((Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>, Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>>Let(_pat_let2_0, boxed5 -> {
                Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _102_valueOrError1 = ((Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>)(java.lang.Object)(boxed5));
                return (((_102_valueOrError1).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) ? ((_102_valueOrError1).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()))) : (((Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Character>, Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>>Let((_102_valueOrError1).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), boxed6 -> {
                  dafny.DafnySequence<? extends Character> _pat_let3_0 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(boxed6));
                  return ((Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Character>, Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>>Let(_pat_let3_0, boxed7 -> {
                    dafny.DafnySequence<? extends Character> _103_nn = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(boxed7));
                    return UTF8.__default.Encode(_103_nn);
                  }
                  )));
                }
                )))));
              }
              )));
            }
            )));
          }
          )));
        }
        )));
      } else if (_source2.is_B()) {
        dafny.DafnySequence<? extends java.lang.Byte> _104___mcc_h2 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_B)_source2)._B;
        return ((Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends java.lang.Byte>, Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>>Let(_104___mcc_h2, boxed8 -> {
          dafny.DafnySequence<? extends java.lang.Byte> _pat_let4_0 = ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)(boxed8));
          return ((Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends java.lang.Byte>, Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>>Let(_pat_let4_0, boxed9 -> {
            dafny.DafnySequence<? extends java.lang.Byte> _105_b = ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)(boxed9));
            return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Success(_105_b);
          }
          )));
        }
        )));
      } else if (_source2.is_SS()) {
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _106___mcc_h3 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_SS)_source2)._SS;
        return ((Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>>Let(_106___mcc_h3, boxed10 -> {
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _pat_let5_0 = ((dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>)(java.lang.Object)(boxed10));
          return ((Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>>Let(_pat_let5_0, boxed11 -> {
            dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _107_ss = ((dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>)(java.lang.Object)(boxed11));
            return __default.StringSetAttrToBytes(_107_ss);
          }
          )));
        }
        )));
      } else if (_source2.is_NS()) {
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _108___mcc_h4 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_NS)_source2)._NS;
        return ((Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>>Let(_108___mcc_h4, boxed12 -> {
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _pat_let6_0 = ((dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>)(java.lang.Object)(boxed12));
          return ((Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>>Let(_pat_let6_0, boxed13 -> {
            dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _109_ns = ((dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>)(java.lang.Object)(boxed13));
            return __default.NumberSetAttrToBytes(_109_ns);
          }
          )));
        }
        )));
      } else if (_source2.is_BS()) {
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _110___mcc_h5 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_BS)_source2)._BS;
        return ((Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>>, Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>>Let(_110___mcc_h5, boxed14 -> {
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _pat_let7_0 = ((dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>>)(java.lang.Object)(boxed14));
          return ((Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>>, Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>>Let(_pat_let7_0, boxed15 -> {
            dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _111_bs = ((dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>>)(java.lang.Object)(boxed15));
            return __default.BinarySetAttrToBytes(_111_bs);
          }
          )));
        }
        )));
      } else if (_source2.is_M()) {
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _112___mcc_h6 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_M)_source2)._M;
        return ((Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>)(java.lang.Object)(dafny.Helpers.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>>Let(_112___mcc_h6, boxed16 -> {
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _pat_let8_0 = ((dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>)(java.lang.Object)(boxed16));
          return ((Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>)(java.lang.Object)(dafny.Helpers.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>>Let(_pat_let8_0, boxed17 -> {
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _113_m = ((dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>)(java.lang.Object)(boxed17));
            return __default.MapAttrToBytes(_113_m);
          }
          )));
        }
        )));
      } else if (_source2.is_L()) {
        dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _114___mcc_h7 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_L)_source2)._L;
        return ((Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>>Let(_114___mcc_h7, boxed18 -> {
          dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _pat_let9_0 = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>)(java.lang.Object)(boxed18));
          return ((Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>>Let(_pat_let9_0, boxed19 -> {
            dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _115_l = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>)(java.lang.Object)(boxed19));
            return __default.ListAttrToBytes(_115_l);
          }
          )));
        }
        )));
      } else if (_source2.is_NULL()) {
        boolean _116___mcc_h8 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_NULL)_source2)._NULL;
        return ((Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>)(java.lang.Object)(dafny.Helpers.<Boolean, Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>>Let(_116___mcc_h8, boxed20 -> {
          boolean _pat_let10_0 = ((boolean)(java.lang.Object)(boxed20));
          return ((Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>)(java.lang.Object)(dafny.Helpers.<Boolean, Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>>Let(_pat_let10_0, boxed21 -> {
            boolean _117_n = ((boolean)(java.lang.Object)(boxed21));
            return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.<java.lang.Byte> empty(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
          }
          )));
        }
        )));
      } else {
        boolean _118___mcc_h9 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_BOOL)_source2)._BOOL;
        return ((Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>)(java.lang.Object)(dafny.Helpers.<Boolean, Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>>Let(_118___mcc_h9, boxed22 -> {
          boolean _pat_let11_0 = ((boolean)(java.lang.Object)(boxed22));
          return ((Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>)(java.lang.Object)(dafny.Helpers.<Boolean, Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>>Let(_pat_let11_0, boxed23 -> {
            boolean _119_b = ((boolean)(java.lang.Object)(boxed23));
            return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.of(__default.BoolToUint8(_119_b)));
          }
          )));
        }
        )));
      }
    }).apply(a);
    if ((_97_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      return (_97_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
    } else {
      dafny.DafnySequence<? extends java.lang.Byte> _120_baseBytes = (_97_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
      if (prefix) {
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _121_valueOrError2 = __default.U32ToBigEndian(java.math.BigInteger.valueOf((_120_baseBytes).length()));
        if ((_121_valueOrError2).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_121_valueOrError2).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
        } else {
          dafny.DafnySequence<? extends java.lang.Byte> _122_len = (_121_valueOrError2).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
          return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(__default.AttrToTypeId(a), _122_len), _120_baseBytes));
        }
      } else {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Success(_120_baseBytes);
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> StringSetAttrToBytes(dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> ss) {
    Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _123_valueOrError0 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), java.util.Objects.equals(java.math.BigInteger.valueOf((Seq_Compile.__default.<dafny.DafnySequence<? extends Character>>ToSet(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ss)).size()), java.math.BigInteger.valueOf((ss).length())), dafny.DafnySequence.asString("String Set had duplicate values"));
    if ((_123_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      return (_123_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
    } else {
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _124_valueOrError1 = __default.U32ToBigEndian(java.math.BigInteger.valueOf((ss).length()));
      if ((_124_valueOrError1).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_124_valueOrError1).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
      } else {
        dafny.DafnySequence<? extends java.lang.Byte> _125_count = (_124_valueOrError1).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _126_valueOrError2 = __default.CollectString(ss, dafny.DafnySequence.<java.lang.Byte> empty(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
        if ((_126_valueOrError2).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_126_valueOrError2).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
        } else {
          dafny.DafnySequence<? extends java.lang.Byte> _127_body = (_126_valueOrError2).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
          return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.<java.lang.Byte>concatenate(_125_count, _127_body));
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> NumberSetAttrToBytes(dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> ns) {
    Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _128_valueOrError0 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), java.util.Objects.equals(java.math.BigInteger.valueOf((Seq_Compile.__default.<dafny.DafnySequence<? extends Character>>ToSet(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ns)).size()), java.math.BigInteger.valueOf((ns).length())), dafny.DafnySequence.asString("Number Set had duplicate values"));
    if ((_128_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      return (_128_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
    } else {
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _129_valueOrError1 = __default.U32ToBigEndian(java.math.BigInteger.valueOf((ns).length()));
      if ((_129_valueOrError1).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_129_valueOrError1).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
      } else {
        dafny.DafnySequence<? extends java.lang.Byte> _130_count = (_129_valueOrError1).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _131_valueOrError2 = __default.CollectString(ns, dafny.DafnySequence.<java.lang.Byte> empty(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
        if ((_131_valueOrError2).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_131_valueOrError2).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
        } else {
          dafny.DafnySequence<? extends java.lang.Byte> _132_body = (_131_valueOrError2).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
          return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.<java.lang.Byte>concatenate(_130_count, _132_body));
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> BinarySetAttrToBytes(dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> bs) {
    Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _133_valueOrError0 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), java.util.Objects.equals(java.math.BigInteger.valueOf((Seq_Compile.__default.<dafny.DafnySequence<? extends java.lang.Byte>>ToSet(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), bs)).size()), java.math.BigInteger.valueOf((bs).length())), dafny.DafnySequence.asString("Binary Set had duplicate values"));
    if ((_133_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      return (_133_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
    } else {
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _134_valueOrError1 = __default.U32ToBigEndian(java.math.BigInteger.valueOf((bs).length()));
      if ((_134_valueOrError1).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_134_valueOrError1).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
      } else {
        dafny.DafnySequence<? extends java.lang.Byte> _135_count = (_134_valueOrError1).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _136_valueOrError2 = __default.CollectBinary(bs, dafny.DafnySequence.<java.lang.Byte> empty(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
        if ((_136_valueOrError2).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_136_valueOrError2).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
        } else {
          dafny.DafnySequence<? extends java.lang.Byte> _137_body = (_136_valueOrError2).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
          return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.<java.lang.Byte>concatenate(_135_count, _137_body));
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> MapAttrToBytes(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> m) {
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>> _138_bytesResults = ((java.util.function.Function<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>>>)(_139_m) -> ((dafny.Function0<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>>>)(() -> {
      java.util.HashMap<dafny.DafnySequence<? extends Character>, Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>> _coll3 = new java.util.HashMap<>();
      for (dafny.Tuple2<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _compr_3_boxed0 : ((_139_m).<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>entrySet()).Elements()) {
        dafny.Tuple2<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _compr_3 = ((dafny.Tuple2<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>)(java.lang.Object)(_compr_3_boxed0));
        if (true) {
          dafny.Tuple2<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _140_kv = (dafny.Tuple2<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>)_compr_3;
          if (((_139_m).<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>entrySet()).<dafny.Tuple2<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>contains(_140_kv)) {
            _coll3.put((_140_kv).dtor__0(),__default.AttrToBytes((_140_kv).dtor__1(), true));
          }
        }
      }
      return new dafny.DafnyMap<dafny.DafnySequence<? extends Character>,Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>>(_coll3);
    })).apply()).apply(m);
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _141_valueOrError0 = __default.U32ToBigEndian(java.math.BigInteger.valueOf((m).size()));
    if ((_141_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      return (_141_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
    } else {
      dafny.DafnySequence<? extends java.lang.Byte> _142_count = (_141_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
      Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, dafny.DafnySequence<? extends Character>> _143_valueOrError1 = __default.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>SimplifyMapValue(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), _138_bytesResults);
      if ((_143_valueOrError1).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor())), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_143_valueOrError1).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor())), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
      } else {
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _144_bytes = (_143_valueOrError1).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor())), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _145_valueOrError2 = __default.CollectMap(_144_bytes, dafny.DafnySequence.<java.lang.Byte> empty(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
        if ((_145_valueOrError2).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_145_valueOrError2).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
        } else {
          dafny.DafnySequence<? extends java.lang.Byte> _146_body = (_145_valueOrError2).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
          return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.<java.lang.Byte>concatenate(_142_count, _146_body));
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> ListAttrToBytes(dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> l) {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _147_valueOrError0 = __default.U32ToBigEndian(java.math.BigInteger.valueOf((l).length()));
    if ((_147_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      return (_147_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
    } else {
      dafny.DafnySequence<? extends java.lang.Byte> _148_count = (_147_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _149_valueOrError1 = __default.CollectList(l, dafny.DafnySequence.<java.lang.Byte> empty(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
      if ((_149_valueOrError1).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_149_valueOrError1).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
      } else {
        dafny.DafnySequence<? extends java.lang.Byte> _150_body = (_149_valueOrError1).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.<java.lang.Byte>concatenate(_148_count, _150_body));
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> U32ToBigEndian(java.math.BigInteger x) {
    if ((x).compareTo(java.math.BigInteger.valueOf(4294967295L)) > 0) {
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnySequence.asString("Length was too big"));
    } else {
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Success(StandardLibrary_mUInt_Compile.__default.UInt32ToSeq((x).intValue()));
    }
  }
  public static Wrappers_Compile.Result<java.math.BigInteger, dafny.DafnySequence<? extends Character>> BigEndianToU32(dafny.DafnySequence<? extends java.lang.Byte> x) {
    if ((java.math.BigInteger.valueOf((x).length())).compareTo(__default.LENGTH__LEN()) < 0) {
      return Wrappers_Compile.Result.<java.math.BigInteger, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnySequence.asString("Length of 4-byte integer was less than 4"));
    } else {
      return Wrappers_Compile.Result.<java.math.BigInteger, dafny.DafnySequence<? extends Character>>create_Success(java.math.BigInteger.valueOf(java.lang.Integer.toUnsignedLong(StandardLibrary_mUInt_Compile.__default.SeqToUInt32((x).take(__default.LENGTH__LEN())))));
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> EncodeString(dafny.DafnySequence<? extends Character> s) {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _151_valueOrError0 = UTF8.__default.Encode(s);
    if ((_151_valueOrError0).IsFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      return (_151_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
    } else {
      dafny.DafnySequence<? extends java.lang.Byte> _152_val = (_151_valueOrError0).Extract(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _153_valueOrError1 = __default.U32ToBigEndian(java.math.BigInteger.valueOf((_152_val).length()));
      if ((_153_valueOrError1).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_153_valueOrError1).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
      } else {
        dafny.DafnySequence<? extends java.lang.Byte> _154_len = (_153_valueOrError1).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.<java.lang.Byte>concatenate(_154_len, _152_val));
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> CollectString(dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> setToSerialize, dafny.DafnySequence<? extends java.lang.Byte> serialized)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((setToSerialize).length())).signum() == 0) {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Success(serialized);
      } else {
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _155_valueOrError0 = __default.EncodeString(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((setToSerialize).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))));
        if ((_155_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_155_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
        } else {
          dafny.DafnySequence<? extends java.lang.Byte> _156_entry = (_155_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in11 = (setToSerialize).drop(java.math.BigInteger.ONE);
          dafny.DafnySequence<? extends java.lang.Byte> _in12 = dafny.DafnySequence.<java.lang.Byte>concatenate(serialized, _156_entry);
          setToSerialize = _in11;
          serialized = _in12;
          continue TAIL_CALL_START;
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> SerializeBinaryValue(dafny.DafnySequence<? extends java.lang.Byte> b) {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _157_valueOrError0 = __default.U32ToBigEndian(java.math.BigInteger.valueOf((b).length()));
    if ((_157_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      return (_157_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
    } else {
      dafny.DafnySequence<? extends java.lang.Byte> _158_len = (_157_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.<java.lang.Byte>concatenate(_158_len, b));
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> CollectBinary(dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> setToSerialize, dafny.DafnySequence<? extends java.lang.Byte> serialized)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((setToSerialize).length())).signum() == 0) {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Success(serialized);
      } else {
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _159_valueOrError0 = __default.SerializeBinaryValue(((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((setToSerialize).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))));
        if ((_159_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_159_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
        } else {
          dafny.DafnySequence<? extends java.lang.Byte> _160_item = (_159_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _in13 = (setToSerialize).drop(java.math.BigInteger.ONE);
          dafny.DafnySequence<? extends java.lang.Byte> _in14 = dafny.DafnySequence.<java.lang.Byte>concatenate(serialized, _160_item);
          setToSerialize = _in13;
          serialized = _in14;
          continue TAIL_CALL_START;
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> CollectList(dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> listToSerialize, dafny.DafnySequence<? extends java.lang.Byte> serialized)
  {
    if ((java.math.BigInteger.valueOf((listToSerialize).length())).signum() == 0) {
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Success(serialized);
    } else {
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _161_valueOrError0 = __default.AttrToBytes(((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue)(java.lang.Object)((listToSerialize).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), true);
      if ((_161_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_161_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
      } else {
        dafny.DafnySequence<? extends java.lang.Byte> _162_val = (_161_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
        return __default.CollectList((listToSerialize).drop(java.math.BigInteger.ONE), dafny.DafnySequence.<java.lang.Byte>concatenate(serialized, _162_val));
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> SerializeMapItem(dafny.DafnySequence<? extends Character> key, dafny.DafnySequence<? extends java.lang.Byte> value)
  {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _163_valueOrError0 = UTF8.__default.Encode(key);
    if ((_163_valueOrError0).IsFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      return (_163_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
    } else {
      dafny.DafnySequence<? extends java.lang.Byte> _164_name = (_163_valueOrError0).Extract(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _165_valueOrError1 = __default.U32ToBigEndian(java.math.BigInteger.valueOf((_164_name).length()));
      if ((_165_valueOrError1).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_165_valueOrError1).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
      } else {
        dafny.DafnySequence<? extends java.lang.Byte> _166_len = (_165_valueOrError1).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
        dafny.DafnySequence<? extends java.lang.Byte> _167_serialized = dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(__default.STRING(), _166_len), _164_name), value);
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Success(_167_serialized);
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> CollectMap(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> mapToSerialize, dafny.DafnySequence<? extends java.lang.Byte> serialized)
  {
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _168_keys = Sets.__default.<Character>SetToOrderedSequence2(dafny.TypeDescriptor.CHAR, (mapToSerialize).keySet(), __default::CharLess);
    return __default.CollectOrderedMapSubset(_168_keys, mapToSerialize, serialized);
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> CollectOrderedMapSubset(dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> keys, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> mapToSerialize, dafny.DafnySequence<? extends java.lang.Byte> serialized)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((keys).length())).signum() == 0) {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Success(serialized);
      } else {
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _169_valueOrError0 = __default.SerializeMapItem(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((keys).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((mapToSerialize).get(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((keys).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))))));
        if ((_169_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_169_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()));
        } else {
          dafny.DafnySequence<? extends java.lang.Byte> _170_data = (_169_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in15 = (keys).drop(java.math.BigInteger.ONE);
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _in16 = mapToSerialize;
          dafny.DafnySequence<? extends java.lang.Byte> _in17 = dafny.DafnySequence.<java.lang.Byte>concatenate(serialized, _170_data);
          keys = _in15;
          mapToSerialize = _in16;
          serialized = _in17;
          continue TAIL_CALL_START;
        }
      }
    }
  }
  public static byte BoolToUint8(boolean b) {
    if (b) {
      return (byte) 1;
    } else {
      return (byte) 0;
    }
  }
  public static <__T> boolean IsUnique(dafny.TypeDescriptor<__T> _td___T, dafny.DafnySequence<? extends __T> s)
  {
    return java.util.Objects.equals(java.math.BigInteger.valueOf((((java.util.function.Function<dafny.DafnySequence<? extends __T>, dafny.DafnySet<? extends __T>>)(_171_s) -> ((dafny.Function0<dafny.DafnySet<? extends __T>>)(() -> {
      java.util.ArrayList<__T> _coll4 = new java.util.ArrayList<>();
      for (__T _compr_4_boxed0 : (_171_s).Elements()) {
        __T _compr_4 = ((__T)(java.lang.Object)(_compr_4_boxed0));
        if (true) {
          __T _172_x = (__T)_compr_4;
          if ((_171_s).contains(_172_x)) {
            _coll4.add(_172_x);
          }
        }
      }
      return new dafny.DafnySet<__T>(_coll4);
    })).apply()).apply(s)).size()), java.math.BigInteger.valueOf((s).length()));
  }
  public static Wrappers_Compile.Result<AttrValueAndLength, dafny.DafnySequence<? extends Character>> DeserializeBinarySet(dafny.DafnySequence<? extends java.lang.Byte> serialized, java.math.BigInteger remainingCount, java.math.BigInteger origSerializedSize, AttrValueAndLength resultSet)
  {
    TAIL_CALL_START: while (true) {
      if ((remainingCount).signum() == 0) {
        Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _173_valueOrError0 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), __default.<dafny.DafnySequence<? extends java.lang.Byte>>IsUnique(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), ((resultSet).dtor_val()).dtor_BS()), dafny.DafnySequence.asString("Binary set values must not have duplicates"));
        if ((_173_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_173_valueOrError0).<AttrValueAndLength>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
        } else {
          return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Success(resultSet);
        }
      } else if ((java.math.BigInteger.valueOf((serialized).length())).compareTo(__default.LENGTH__LEN()) < 0) {
        return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnySequence.asString("Out of bytes reading Binary Set"));
      } else {
        Wrappers_Compile.Result<java.math.BigInteger, dafny.DafnySequence<? extends Character>> _174_valueOrError1 = __default.BigEndianToU32(serialized);
        if ((_174_valueOrError1).IsFailure(_System.nat._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_174_valueOrError1).<AttrValueAndLength>PropagateFailure(_System.nat._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
        } else {
          java.math.BigInteger _175_len = (_174_valueOrError1).Extract(_System.nat._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
          dafny.DafnySequence<? extends java.lang.Byte> _176_serialized = (serialized).drop(__default.LENGTH__LEN());
          if ((java.math.BigInteger.valueOf((_176_serialized).length())).compareTo(_175_len) < 0) {
            return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnySequence.asString("Binary Set Structured Data has too few bytes"));
          } else {
            Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue _177_nattr = Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_BS(dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>>concatenate(((resultSet).dtor_val()).dtor_BS(), dafny.DafnySequence.of(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), (_176_serialized).take(_175_len))));
            dafny.DafnySequence<? extends java.lang.Byte> _in18 = (_176_serialized).drop(_175_len);
            java.math.BigInteger _in19 = (remainingCount).subtract(java.math.BigInteger.ONE);
            java.math.BigInteger _in20 = origSerializedSize;
            AttrValueAndLength _in21 = DynamoToStruct_Compile.AttrValueAndLength.create(_177_nattr, (((resultSet).dtor_len()).add(_175_len)).add(__default.LENGTH__LEN()));
            serialized = _in18;
            remainingCount = _in19;
            origSerializedSize = _in20;
            resultSet = _in21;
            continue TAIL_CALL_START;
          }
        }
      }
    }
  }
  public static Wrappers_Compile.Result<AttrValueAndLength, dafny.DafnySequence<? extends Character>> DeserializeStringSet(dafny.DafnySequence<? extends java.lang.Byte> serialized, java.math.BigInteger remainingCount, java.math.BigInteger origSerializedSize, AttrValueAndLength resultSet)
  {
    TAIL_CALL_START: while (true) {
      if ((remainingCount).signum() == 0) {
        Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _178_valueOrError0 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), __default.<dafny.DafnySequence<? extends Character>>IsUnique(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((resultSet).dtor_val()).dtor_SS()), dafny.DafnySequence.asString("String set values must not have duplicates"));
        if ((_178_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_178_valueOrError0).<AttrValueAndLength>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
        } else {
          return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Success(resultSet);
        }
      } else if ((java.math.BigInteger.valueOf((serialized).length())).compareTo(__default.LENGTH__LEN()) < 0) {
        return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnySequence.asString("Out of bytes reading String Set"));
      } else {
        Wrappers_Compile.Result<java.math.BigInteger, dafny.DafnySequence<? extends Character>> _179_valueOrError1 = __default.BigEndianToU32(serialized);
        if ((_179_valueOrError1).IsFailure(_System.nat._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_179_valueOrError1).<AttrValueAndLength>PropagateFailure(_System.nat._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
        } else {
          java.math.BigInteger _180_len = (_179_valueOrError1).Extract(_System.nat._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
          dafny.DafnySequence<? extends java.lang.Byte> _181_serialized = (serialized).drop(__default.LENGTH__LEN());
          if ((java.math.BigInteger.valueOf((_181_serialized).length())).compareTo(_180_len) < 0) {
            return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnySequence.asString("String Set Structured Data has too few bytes"));
          } else {
            Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _182_valueOrError2 = UTF8.__default.Decode((_181_serialized).take(_180_len));
            if ((_182_valueOrError2).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
              return (_182_valueOrError2).<AttrValueAndLength>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
            } else {
              dafny.DafnySequence<? extends Character> _183_nstring = (_182_valueOrError2).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
              Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue _184_nattr = Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_SS(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>concatenate(((resultSet).dtor_val()).dtor_SS(), dafny.DafnySequence.of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _183_nstring)));
              dafny.DafnySequence<? extends java.lang.Byte> _in22 = (_181_serialized).drop(_180_len);
              java.math.BigInteger _in23 = (remainingCount).subtract(java.math.BigInteger.ONE);
              java.math.BigInteger _in24 = origSerializedSize;
              AttrValueAndLength _in25 = DynamoToStruct_Compile.AttrValueAndLength.create(_184_nattr, (((resultSet).dtor_len()).add(_180_len)).add(__default.LENGTH__LEN()));
              serialized = _in22;
              remainingCount = _in23;
              origSerializedSize = _in24;
              resultSet = _in25;
              continue TAIL_CALL_START;
            }
          }
        }
      }
    }
  }
  public static Wrappers_Compile.Result<AttrValueAndLength, dafny.DafnySequence<? extends Character>> DeserializeNumberSet(dafny.DafnySequence<? extends java.lang.Byte> serialized, java.math.BigInteger remainingCount, java.math.BigInteger origSerializedSize, AttrValueAndLength resultSet)
  {
    TAIL_CALL_START: while (true) {
      if ((remainingCount).signum() == 0) {
        Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _185_valueOrError0 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), __default.<dafny.DafnySequence<? extends Character>>IsUnique(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((resultSet).dtor_val()).dtor_NS()), dafny.DafnySequence.asString("Number set values must not have duplicates"));
        if ((_185_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_185_valueOrError0).<AttrValueAndLength>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
        } else {
          return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Success(resultSet);
        }
      } else if ((java.math.BigInteger.valueOf((serialized).length())).compareTo(__default.LENGTH__LEN()) < 0) {
        return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnySequence.asString("Out of bytes reading String Set"));
      } else {
        Wrappers_Compile.Result<java.math.BigInteger, dafny.DafnySequence<? extends Character>> _186_valueOrError1 = __default.BigEndianToU32(serialized);
        if ((_186_valueOrError1).IsFailure(_System.nat._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_186_valueOrError1).<AttrValueAndLength>PropagateFailure(_System.nat._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
        } else {
          java.math.BigInteger _187_len = (_186_valueOrError1).Extract(_System.nat._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
          dafny.DafnySequence<? extends java.lang.Byte> _188_serialized = (serialized).drop(__default.LENGTH__LEN());
          if ((java.math.BigInteger.valueOf((_188_serialized).length())).compareTo(_187_len) < 0) {
            return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnySequence.asString("Number Set Structured Data has too few bytes"));
          } else {
            Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _189_valueOrError2 = UTF8.__default.Decode((_188_serialized).take(_187_len));
            if ((_189_valueOrError2).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
              return (_189_valueOrError2).<AttrValueAndLength>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
            } else {
              dafny.DafnySequence<? extends Character> _190_nstring = (_189_valueOrError2).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
              Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue _191_nattr = Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_NS(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>concatenate(((resultSet).dtor_val()).dtor_NS(), dafny.DafnySequence.of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _190_nstring)));
              dafny.DafnySequence<? extends java.lang.Byte> _in26 = (_188_serialized).drop(_187_len);
              java.math.BigInteger _in27 = (remainingCount).subtract(java.math.BigInteger.ONE);
              java.math.BigInteger _in28 = origSerializedSize;
              AttrValueAndLength _in29 = DynamoToStruct_Compile.AttrValueAndLength.create(_191_nattr, (((resultSet).dtor_len()).add(_187_len)).add(__default.LENGTH__LEN()));
              serialized = _in26;
              remainingCount = _in27;
              origSerializedSize = _in28;
              resultSet = _in29;
              continue TAIL_CALL_START;
            }
          }
        }
      }
    }
  }
  public static Wrappers_Compile.Result<AttrValueAndLength, dafny.DafnySequence<? extends Character>> DeserializeList(dafny.DafnySequence<? extends java.lang.Byte> serialized, java.math.BigInteger remainingCount, java.math.BigInteger origSerializedSize, AttrValueAndLength resultList)
  {
    if ((remainingCount).signum() == 0) {
      return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Success(resultList);
    } else if ((java.math.BigInteger.valueOf((serialized).length())).compareTo(java.math.BigInteger.valueOf(6L)) < 0) {
      return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnySequence.asString("Out of bytes reading Type of List element"));
    } else {
      dafny.DafnySequence<? extends java.lang.Byte> _192_TerminalTypeId = (serialized).subsequence(dafny.Helpers.toInt((java.math.BigInteger.ZERO)), dafny.Helpers.toInt((java.math.BigInteger.valueOf(2L))));
      dafny.DafnySequence<? extends java.lang.Byte> _193_serialized = (serialized).drop(java.math.BigInteger.valueOf(2L));
      Wrappers_Compile.Result<java.math.BigInteger, dafny.DafnySequence<? extends Character>> _194_valueOrError0 = __default.BigEndianToU32(_193_serialized);
      if ((_194_valueOrError0).IsFailure(_System.nat._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_194_valueOrError0).<AttrValueAndLength>PropagateFailure(_System.nat._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
      } else {
        java.math.BigInteger _195_len = (_194_valueOrError0).Extract(_System.nat._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
        dafny.DafnySequence<? extends java.lang.Byte> _196_serialized = (_193_serialized).drop(__default.LENGTH__LEN());
        if ((java.math.BigInteger.valueOf((_196_serialized).length())).compareTo(_195_len) < 0) {
          return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnySequence.asString("Out of bytes reading Content of List element"));
        } else {
          Wrappers_Compile.Result<AttrValueAndLength, dafny.DafnySequence<? extends Character>> _197_valueOrError1 = __default.BytesToAttr((_196_serialized).take(_195_len), _192_TerminalTypeId, false);
          if ((_197_valueOrError1).IsFailure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
            return (_197_valueOrError1).<AttrValueAndLength>PropagateFailure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
          } else {
            AttrValueAndLength _198_nval = (_197_valueOrError1).Extract(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
            Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue _199_nattr = Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_L(dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>concatenate(((resultList).dtor_val()).dtor_L(), dafny.DafnySequence.of(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor(), (_198_nval).dtor_val())));
            return __default.DeserializeList((_196_serialized).drop(_195_len), (remainingCount).subtract(java.math.BigInteger.ONE), origSerializedSize, DynamoToStruct_Compile.AttrValueAndLength.create(_199_nattr, (((resultList).dtor_len()).add(_195_len)).add(java.math.BigInteger.valueOf(6L))));
          }
        }
      }
    }
  }
  public static Wrappers_Compile.Result<AttrValueAndLength, dafny.DafnySequence<? extends Character>> DeserializeMap(dafny.DafnySequence<? extends java.lang.Byte> serialized, java.math.BigInteger remainingCount, java.math.BigInteger origSerializedSize, AttrValueAndLength resultMap)
  {
    if ((remainingCount).signum() == 0) {
      return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Success(resultMap);
    } else {
      Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _200_valueOrError0 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (java.math.BigInteger.valueOf(6L)).compareTo(java.math.BigInteger.valueOf((serialized).length())) <= 0, dafny.DafnySequence.asString("Out of bytes reading Map Key"));
      if ((_200_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_200_valueOrError0).<AttrValueAndLength>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
      } else {
        dafny.DafnySequence<? extends java.lang.Byte> _201_TerminalTypeId__key = (serialized).subsequence(dafny.Helpers.toInt((java.math.BigInteger.ZERO)), dafny.Helpers.toInt((java.math.BigInteger.valueOf(2L))));
        Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _202_valueOrError1 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (_201_TerminalTypeId__key).equals(__default.STRING()), dafny.DafnySequence.asString("Key of Map is not String"));
        if ((_202_valueOrError1).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_202_valueOrError1).<AttrValueAndLength>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
        } else {
          dafny.DafnySequence<? extends java.lang.Byte> _203_serialized = (serialized).drop(java.math.BigInteger.valueOf(2L));
          Wrappers_Compile.Result<java.math.BigInteger, dafny.DafnySequence<? extends Character>> _204_valueOrError2 = __default.BigEndianToU32(_203_serialized);
          if ((_204_valueOrError2).IsFailure(_System.nat._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
            return (_204_valueOrError2).<AttrValueAndLength>PropagateFailure(_System.nat._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
          } else {
            java.math.BigInteger _205_len = (_204_valueOrError2).Extract(_System.nat._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
            dafny.DafnySequence<? extends java.lang.Byte> _206_serialized = (_203_serialized).drop(__default.LENGTH__LEN());
            Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _207_valueOrError3 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (_205_len).compareTo(java.math.BigInteger.valueOf((_206_serialized).length())) <= 0, dafny.DafnySequence.asString("Key of Map of Structured Data has too few bytes"));
            if ((_207_valueOrError3).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
              return (_207_valueOrError3).<AttrValueAndLength>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
            } else {
              Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _208_valueOrError4 = UTF8.__default.Decode((_206_serialized).take(_205_len));
              if ((_208_valueOrError4).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
                return (_208_valueOrError4).<AttrValueAndLength>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
              } else {
                dafny.DafnySequence<? extends Character> _209_key = (_208_valueOrError4).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
                dafny.DafnySequence<? extends java.lang.Byte> _210_serialized = (_206_serialized).drop(_205_len);
                Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _211_valueOrError5 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (java.math.BigInteger.valueOf(2L)).compareTo(java.math.BigInteger.valueOf((_210_serialized).length())) <= 0, dafny.DafnySequence.asString("Out of bytes reading Map Value"));
                if ((_211_valueOrError5).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
                  return (_211_valueOrError5).<AttrValueAndLength>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
                } else {
                  Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _212_valueOrError6 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Com.Amazonaws.Dynamodb.Types.__default.IsValid__AttributeName(_209_key), dafny.DafnySequence.asString("Key is not valid AttributeName"));
                  if ((_212_valueOrError6).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
                    return (_212_valueOrError6).<AttrValueAndLength>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
                  } else {
                    dafny.DafnySequence<? extends java.lang.Byte> _213_TerminalTypeId__value = (_210_serialized).subsequence(dafny.Helpers.toInt((java.math.BigInteger.ZERO)), dafny.Helpers.toInt((java.math.BigInteger.valueOf(2L))));
                    dafny.DafnySequence<? extends java.lang.Byte> _214_serialized = (_210_serialized).drop(java.math.BigInteger.valueOf(2L));
                    Wrappers_Compile.Result<AttrValueAndLength, dafny.DafnySequence<? extends Character>> _215_valueOrError7 = __default.BytesToAttr(_214_serialized, _213_TerminalTypeId__value, true);
                    if ((_215_valueOrError7).IsFailure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
                      return (_215_valueOrError7).<AttrValueAndLength>PropagateFailure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
                    } else {
                      AttrValueAndLength _216_nval = (_215_valueOrError7).Extract(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
                      dafny.DafnySequence<? extends java.lang.Byte> _217_serialized = (_214_serialized).drop((_216_nval).dtor_len());
                      Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _218_valueOrError8 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), !(((resultMap).dtor_val()).dtor_M()).<dafny.DafnySequence<? extends Character>>contains(_209_key), dafny.DafnySequence.asString("Duplicate key in map."));
                      if ((_218_valueOrError8).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
                        return (_218_valueOrError8).<AttrValueAndLength>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
                      } else {
                        Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue _219_nattr = Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_M(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>update(((resultMap).dtor_val()).dtor_M(), _209_key, (_216_nval).dtor_val()));
                        AttrValueAndLength _220_newResultMap = DynamoToStruct_Compile.AttrValueAndLength.create(_219_nattr, ((((resultMap).dtor_len()).add((_216_nval).dtor_len())).add(java.math.BigInteger.valueOf(8L))).add(_205_len));
                        return __default.DeserializeMap(_217_serialized, (remainingCount).subtract(java.math.BigInteger.ONE), origSerializedSize, _220_newResultMap);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  public static Wrappers_Compile.Result<AttrValueAndLength, dafny.DafnySequence<? extends Character>> BytesToAttr(dafny.DafnySequence<? extends java.lang.Byte> value, dafny.DafnySequence<? extends java.lang.Byte> typeId, boolean hasLen)
  {
    Wrappers_Compile.Result<java.math.BigInteger, dafny.DafnySequence<? extends Character>> _221_valueOrError0 = ((hasLen) ? ((((java.math.BigInteger.valueOf((value).length())).compareTo(__default.LENGTH__LEN()) < 0) ? (Wrappers_Compile.Result.<java.math.BigInteger, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnySequence.asString("Out of bytes reading length"))) : (__default.BigEndianToU32(value)))) : (Wrappers_Compile.Result.<java.math.BigInteger, dafny.DafnySequence<? extends Character>>create_Success(java.math.BigInteger.valueOf((value).length()))));
    if ((_221_valueOrError0).IsFailure(dafny.TypeDescriptor.BIG_INTEGER, dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      return (_221_valueOrError0).<AttrValueAndLength>PropagateFailure(dafny.TypeDescriptor.BIG_INTEGER, dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
    } else {
      java.math.BigInteger _222_len = (_221_valueOrError0).Extract(dafny.TypeDescriptor.BIG_INTEGER, dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
      dafny.DafnySequence<? extends java.lang.Byte> _223_value = ((hasLen) ? ((value).drop(__default.LENGTH__LEN())) : (value));
      java.math.BigInteger _224_lengthBytes = ((hasLen) ? (__default.LENGTH__LEN()) : (java.math.BigInteger.ZERO));
      if ((java.math.BigInteger.valueOf((_223_value).length())).compareTo(_222_len) < 0) {
        return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnySequence.asString("Structured Data has too few bytes"));
      } else if ((typeId).equals(__default.NULL())) {
        if ((_222_len).signum() != 0) {
          return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnySequence.asString("NULL type did not have length zero"));
        } else {
          return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Success(DynamoToStruct_Compile.AttrValueAndLength.create(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_NULL(true), _224_lengthBytes));
        }
      } else if ((typeId).equals(__default.STRING())) {
        Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _225_valueOrError1 = UTF8.__default.Decode((_223_value).take(_222_len));
        if ((_225_valueOrError1).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_225_valueOrError1).<AttrValueAndLength>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
        } else {
          dafny.DafnySequence<? extends Character> _226_str = (_225_valueOrError1).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
          return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Success(DynamoToStruct_Compile.AttrValueAndLength.create(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_S(_226_str), (_222_len).add(_224_lengthBytes)));
        }
      } else if ((typeId).equals(__default.NUMBER())) {
        Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _227_valueOrError2 = UTF8.__default.Decode((_223_value).take(_222_len));
        if ((_227_valueOrError2).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_227_valueOrError2).<AttrValueAndLength>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
        } else {
          dafny.DafnySequence<? extends Character> _228_str = (_227_valueOrError2).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
          return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Success(DynamoToStruct_Compile.AttrValueAndLength.create(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_N(_228_str), (_222_len).add(_224_lengthBytes)));
        }
      } else if ((typeId).equals(__default.BINARY())) {
        return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Success(DynamoToStruct_Compile.AttrValueAndLength.create(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_B((_223_value).take(_222_len)), (_222_len).add(_224_lengthBytes)));
      } else if ((typeId).equals(__default.BOOLEAN())) {
        if (!java.util.Objects.equals(_222_len, __default.BOOL__LEN())) {
          return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnySequence.asString("Boolean Structured Data has more than one byte"));
        } else if (((((byte)(java.lang.Object)((_223_value).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))) == 0 ? 0 : 1) == 0) {
          return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Success(DynamoToStruct_Compile.AttrValueAndLength.create(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_BOOL(false), (__default.BOOL__LEN()).add(_224_lengthBytes)));
        } else if ((((byte)(java.lang.Object)((_223_value).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))) == ((byte) 1)) {
          return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Success(DynamoToStruct_Compile.AttrValueAndLength.create(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_BOOL(true), (__default.BOOL__LEN()).add(_224_lengthBytes)));
        } else {
          return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnySequence.asString("Boolean Structured Data had inappropriate value"));
        }
      } else if ((typeId).equals(__default.STRING__SET())) {
        if ((java.math.BigInteger.valueOf((_223_value).length())).compareTo(__default.LENGTH__LEN()) < 0) {
          return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnySequence.asString("String Set Structured Data has less than LENGTH_LEN bytes"));
        } else {
          Wrappers_Compile.Result<java.math.BigInteger, dafny.DafnySequence<? extends Character>> _229_valueOrError3 = __default.BigEndianToU32(_223_value);
          if ((_229_valueOrError3).IsFailure(_System.nat._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
            return (_229_valueOrError3).<AttrValueAndLength>PropagateFailure(_System.nat._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
          } else {
            java.math.BigInteger _230_len = (_229_valueOrError3).Extract(_System.nat._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
            dafny.DafnySequence<? extends java.lang.Byte> _231_value = (_223_value).drop(__default.LENGTH__LEN());
            return __default.DeserializeStringSet(_231_value, _230_len, ((java.math.BigInteger.valueOf((_231_value).length())).add(__default.LENGTH__LEN())).add(_224_lengthBytes), DynamoToStruct_Compile.AttrValueAndLength.create(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_SS(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> empty(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))), (__default.LENGTH__LEN()).add(_224_lengthBytes)));
          }
        }
      } else if ((typeId).equals(__default.NUMBER__SET())) {
        if ((java.math.BigInteger.valueOf((_223_value).length())).compareTo(__default.LENGTH__LEN()) < 0) {
          return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnySequence.asString("Number Set Structured Data has less than 4 bytes"));
        } else {
          Wrappers_Compile.Result<java.math.BigInteger, dafny.DafnySequence<? extends Character>> _232_valueOrError4 = __default.BigEndianToU32(_223_value);
          if ((_232_valueOrError4).IsFailure(_System.nat._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
            return (_232_valueOrError4).<AttrValueAndLength>PropagateFailure(_System.nat._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
          } else {
            java.math.BigInteger _233_len = (_232_valueOrError4).Extract(_System.nat._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
            dafny.DafnySequence<? extends java.lang.Byte> _234_value = (_223_value).drop(__default.LENGTH__LEN());
            return __default.DeserializeNumberSet(_234_value, _233_len, ((java.math.BigInteger.valueOf((_234_value).length())).add(__default.LENGTH__LEN())).add(_224_lengthBytes), DynamoToStruct_Compile.AttrValueAndLength.create(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_NS(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> empty(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))), (__default.LENGTH__LEN()).add(_224_lengthBytes)));
          }
        }
      } else if ((typeId).equals(__default.BINARY__SET())) {
        if ((java.math.BigInteger.valueOf((_223_value).length())).compareTo(__default.LENGTH__LEN()) < 0) {
          return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnySequence.asString("Binary Set Structured Data has less than LENGTH_LEN bytes"));
        } else {
          Wrappers_Compile.Result<java.math.BigInteger, dafny.DafnySequence<? extends Character>> _235_valueOrError5 = __default.BigEndianToU32(_223_value);
          if ((_235_valueOrError5).IsFailure(_System.nat._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
            return (_235_valueOrError5).<AttrValueAndLength>PropagateFailure(_System.nat._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
          } else {
            java.math.BigInteger _236_len = (_235_valueOrError5).Extract(_System.nat._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
            dafny.DafnySequence<? extends java.lang.Byte> _237_value = (_223_value).drop(__default.LENGTH__LEN());
            return __default.DeserializeBinarySet(_237_value, _236_len, ((java.math.BigInteger.valueOf((_237_value).length())).add(__default.LENGTH__LEN())).add(_224_lengthBytes), DynamoToStruct_Compile.AttrValueAndLength.create(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_BS(dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>> empty(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()))), (__default.LENGTH__LEN()).add(_224_lengthBytes)));
          }
        }
      } else if ((typeId).equals(__default.MAP())) {
        if ((java.math.BigInteger.valueOf((_223_value).length())).compareTo(__default.LENGTH__LEN()) < 0) {
          return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnySequence.asString("List Structured Data has less than 4 bytes"));
        } else {
          Wrappers_Compile.Result<java.math.BigInteger, dafny.DafnySequence<? extends Character>> _238_valueOrError6 = __default.BigEndianToU32(_223_value);
          if ((_238_valueOrError6).IsFailure(_System.nat._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
            return (_238_valueOrError6).<AttrValueAndLength>PropagateFailure(_System.nat._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
          } else {
            java.math.BigInteger _239_len = (_238_valueOrError6).Extract(_System.nat._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
            dafny.DafnySequence<? extends java.lang.Byte> _240_value = (_223_value).drop(__default.LENGTH__LEN());
            return __default.DeserializeMap(_240_value, _239_len, ((java.math.BigInteger.valueOf((_240_value).length())).add(__default.LENGTH__LEN())).add(_224_lengthBytes), DynamoToStruct_Compile.AttrValueAndLength.create(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_M(dafny.DafnyMap.fromElements()), (__default.LENGTH__LEN()).add(_224_lengthBytes)));
          }
        }
      } else if ((typeId).equals(__default.LIST())) {
        if ((java.math.BigInteger.valueOf((_223_value).length())).compareTo(__default.LENGTH__LEN()) < 0) {
          return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnySequence.asString("List Structured Data has less than 4 bytes"));
        } else {
          Wrappers_Compile.Result<java.math.BigInteger, dafny.DafnySequence<? extends Character>> _241_valueOrError7 = __default.BigEndianToU32(_223_value);
          if ((_241_valueOrError7).IsFailure(_System.nat._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
            return (_241_valueOrError7).<AttrValueAndLength>PropagateFailure(_System.nat._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
          } else {
            java.math.BigInteger _242_len = (_241_valueOrError7).Extract(_System.nat._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
            dafny.DafnySequence<? extends java.lang.Byte> _243_value = (_223_value).drop(__default.LENGTH__LEN());
            return __default.DeserializeList(_243_value, _242_len, ((java.math.BigInteger.valueOf((_243_value).length())).add(__default.LENGTH__LEN())).add(_224_lengthBytes), DynamoToStruct_Compile.AttrValueAndLength.create(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_L(dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> empty(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor())), (__default.LENGTH__LEN()).add(_224_lengthBytes)));
          }
        }
      } else {
        return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnySequence.asString("Unsupported TerminalTypeId"));
      }
    }
  }
  public static <__X, __Y> dafny.DafnyMap<? extends __X, ? extends __Y> FlattenValueMap(dafny.TypeDescriptor<__X> _td___X, dafny.TypeDescriptor<__Y> _td___Y, dafny.DafnyMap<? extends __X, ? extends Wrappers_Compile.Result<__Y, dafny.DafnySequence<? extends Character>>> m)
  {
    return ((java.util.function.Function<dafny.DafnyMap<? extends __X, ? extends Wrappers_Compile.Result<__Y, dafny.DafnySequence<? extends Character>>>, dafny.DafnyMap<? extends __X, ? extends __Y>>)(_244_m) -> ((dafny.Function0<dafny.DafnyMap<? extends __X, ? extends __Y>>)(() -> {
      java.util.HashMap<__X, __Y> _coll5 = new java.util.HashMap<>();
      for (dafny.Tuple2<__X, Wrappers_Compile.Result<__Y, dafny.DafnySequence<? extends Character>>> _compr_5_boxed0 : ((_244_m).<__X, Wrappers_Compile.Result<__Y, dafny.DafnySequence<? extends Character>>>entrySet()).Elements()) {
        dafny.Tuple2<__X, Wrappers_Compile.Result<__Y, dafny.DafnySequence<? extends Character>>> _compr_5 = ((dafny.Tuple2<__X, Wrappers_Compile.Result<__Y, dafny.DafnySequence<? extends Character>>>)(java.lang.Object)(_compr_5_boxed0));
        if (true) {
          dafny.Tuple2<__X, Wrappers_Compile.Result<__Y, dafny.DafnySequence<? extends Character>>> _245_kv = (dafny.Tuple2<__X, Wrappers_Compile.Result<__Y, dafny.DafnySequence<? extends Character>>>)_compr_5;
          if ((((_244_m).<__X, Wrappers_Compile.Result<__Y, dafny.DafnySequence<? extends Character>>>entrySet()).<dafny.Tuple2<__X, Wrappers_Compile.Result<__Y, dafny.DafnySequence<? extends Character>>>>contains(_245_kv)) && (((_245_kv).dtor__1()).is_Success())) {
            _coll5.put((_245_kv).dtor__0(),((_245_kv).dtor__1()).dtor_value());
          }
        }
      }
      return new dafny.DafnyMap<__X,__Y>(_coll5);
    })).apply()).apply(m);
  }
  public static <__X, __Y> dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> FlattenErrors(dafny.TypeDescriptor<__X> _td___X, dafny.TypeDescriptor<__Y> _td___Y, dafny.DafnyMap<? extends __X, ? extends Wrappers_Compile.Result<__Y, dafny.DafnySequence<? extends Character>>> m)
  {
    return ((java.util.function.Function<dafny.DafnyMap<? extends __X, ? extends Wrappers_Compile.Result<__Y, dafny.DafnySequence<? extends Character>>>, dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>>>)(_246_m) -> ((dafny.Function0<dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>>>)(() -> {
      java.util.ArrayList<dafny.DafnySequence<? extends Character>> _coll6 = new java.util.ArrayList<>();
      for (Wrappers_Compile.Result<__Y, dafny.DafnySequence<? extends Character>> _compr_6_boxed0 : ((_246_m).valueSet()).Elements()) {
        Wrappers_Compile.Result<__Y, dafny.DafnySequence<? extends Character>> _compr_6 = ((Wrappers_Compile.Result<__Y, dafny.DafnySequence<? extends Character>>)(java.lang.Object)(_compr_6_boxed0));
        if (true) {
          Wrappers_Compile.Result<__Y, dafny.DafnySequence<? extends Character>> _247_k = (Wrappers_Compile.Result<__Y, dafny.DafnySequence<? extends Character>>)_compr_6;
          if ((((_246_m).valueSet()).<Wrappers_Compile.Result<__Y, dafny.DafnySequence<? extends Character>>>contains(_247_k)) && ((_247_k).is_Failure())) {
            _coll6.add((_247_k).dtor_error());
          }
        }
      }
      return new dafny.DafnySet<dafny.DafnySequence<? extends Character>>(_coll6);
    })).apply()).apply(m);
  }
  public static <__X, __Y> Wrappers_Compile.Result<dafny.DafnyMap<? extends __X, ? extends __Y>, dafny.DafnySequence<? extends Character>> SimplifyMapValue(dafny.TypeDescriptor<__X> _td___X, dafny.TypeDescriptor<__Y> _td___Y, dafny.DafnyMap<? extends __X, ? extends Wrappers_Compile.Result<__Y, dafny.DafnySequence<? extends Character>>> m)
  {
    if (((java.util.function.Function<dafny.DafnyMap<? extends __X, ? extends Wrappers_Compile.Result<__Y, dafny.DafnySequence<? extends Character>>>, Boolean>)(_248_m) -> dafny.Helpers.Quantifier(((_248_m).valueSet()).Elements(), true, ((_forall_var_1_boxed0) -> {
      Wrappers_Compile.Result<__Y, dafny.DafnySequence<? extends Character>> _forall_var_1 = ((Wrappers_Compile.Result<__Y, dafny.DafnySequence<? extends Character>>)(java.lang.Object)(_forall_var_1_boxed0));
      if (true) {
        Wrappers_Compile.Result<__Y, dafny.DafnySequence<? extends Character>> _249_v = (Wrappers_Compile.Result<__Y, dafny.DafnySequence<? extends Character>>)_forall_var_1;
        return !(((_248_m).valueSet()).<Wrappers_Compile.Result<__Y, dafny.DafnySequence<? extends Character>>>contains(_249_v)) || ((_249_v).is_Success());
      } else {
        return true;
      }
    }))).apply(m)) {
      dafny.DafnyMap<? extends __X, ? extends __Y> _250_result = __default.<__X, __Y>FlattenValueMap(_td___X, _td___Y, m);
      return Wrappers_Compile.Result.<dafny.DafnyMap<? extends __X, ? extends __Y>, dafny.DafnySequence<? extends Character>>create_Success(_250_result);
    } else {
      dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> _251_badValues = __default.<__X, __Y>FlattenErrors(_td___X, _td___Y, m);
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _252_badValueSeq = StandardLibrary_Compile.__default.<Character>SetToOrderedSequence(dafny.TypeDescriptor.CHAR, _251_badValues, __default::CharLess);
      return Wrappers_Compile.Result.<dafny.DafnyMap<? extends __X, ? extends __Y>, dafny.DafnySequence<? extends Character>>create_Failure(StandardLibrary_Compile.__default.<Character>Join(dafny.TypeDescriptor.CHAR, _252_badValueSeq, dafny.DafnySequence.asString("\n")));
    }
  }
  public static byte TERM__T()
  {
    return (byte) 0;
  }
  public static byte STRING__T()
  {
    return (byte) 1;
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> STRING()
  {
    return dafny.DafnySequence.of(__default.TERM__T(), __default.STRING__T());
  }
  public static byte NUMBER__T()
  {
    return (byte) 2;
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> NUMBER()
  {
    return dafny.DafnySequence.of(__default.TERM__T(), __default.NUMBER__T());
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> BINARY()
  {
    return dafny.DafnySequence.of((byte) 255, (byte) 255);
  }
  public static byte SET__T()
  {
    return (byte) 1;
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> STRING__SET()
  {
    return dafny.DafnySequence.of(__default.SET__T(), __default.STRING__T());
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> NUMBER__SET()
  {
    return dafny.DafnySequence.of(__default.SET__T(), __default.NUMBER__T());
  }
  public static byte BINARY__T()
  {
    return (byte) 255;
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> BINARY__SET()
  {
    return dafny.DafnySequence.of(__default.SET__T(), __default.BINARY__T());
  }
  public static byte MAP__T()
  {
    return (byte) 2;
  }
  public static byte NULL__T()
  {
    return (byte) 0;
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> MAP()
  {
    return dafny.DafnySequence.of(__default.MAP__T(), __default.NULL__T());
  }
  public static byte LIST__T()
  {
    return (byte) 3;
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> LIST()
  {
    return dafny.DafnySequence.of(__default.LIST__T(), __default.NULL__T());
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> NULL()
  {
    return dafny.DafnySequence.of(__default.TERM__T(), __default.NULL__T());
  }
  public static byte BOOLEAN__T()
  {
    return (byte) 4;
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> BOOLEAN()
  {
    return dafny.DafnySequence.of(__default.TERM__T(), __default.BOOLEAN__T());
  }
  public static java.math.BigInteger BOOL__LEN()
  {
    return java.math.BigInteger.ONE;
  }
  public static java.math.BigInteger PREFIX__LEN()
  {
    return java.math.BigInteger.valueOf(6L);
  }
  public static java.math.BigInteger TYPEID__LEN()
  {
    return java.math.BigInteger.valueOf(2L);
  }
  public static java.math.BigInteger LENGTH__LEN()
  {
    return java.math.BigInteger.valueOf(4L);
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "DynamoToStruct_Compile._default";
  }
}
