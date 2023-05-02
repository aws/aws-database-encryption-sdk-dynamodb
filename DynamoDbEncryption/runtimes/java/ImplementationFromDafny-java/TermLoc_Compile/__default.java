// Class __default
// Dafny class __default compiled into Java
package TermLoc_Compile;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.*;
import DynamoDbEncryptionUtil_Compile.*;
import DynamoDbNormalizeNumber_Compile.*;
import DynamoToStruct_Compile.*;
import DynamoDbEncryptionBranchKeyIdSupplier_Compile.*;
import AwsCryptographyDynamoDbEncryptionOperations_Compile.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.*;
import StructuredEncryptionUtil_Compile.*;
import Sets_Compile.*;
import StructuredEncryptionPaths_Compile.*;
import StructuredEncryptionHeader_Compile.*;
import StructuredEncryptionFooter_Compile.*;
import StructuredEncryptionCrypt_Compile.*;
import Maps_Compile.*;
import AwsCryptographyStructuredEncryptionOperations_Compile.*;
import Dafny.Aws.Cryptography.StructuredEncryption.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static boolean ValidTermLoc(dafny.DafnySequence<? extends Selector> s) {
    return (((java.math.BigInteger.valueOf((s).length())).signum() == 1) && ((java.math.BigInteger.valueOf((s).length())).compareTo(StandardLibrary_mUInt_Compile.__default.UINT64__LIMIT()) < 0)) && ((((Selector)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).is_Map());
  }
  public static dafny.DafnySequence<? extends Character> TermLocToString(dafny.DafnySequence<? extends Selector> t) {
    return dafny.DafnySequence.<Character>concatenate((((Selector)(java.lang.Object)((t).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key(), __default.SelectorListToString((t).drop(java.math.BigInteger.ONE)));
  }
  public static dafny.DafnySequence<? extends Character> SelectorListToString(dafny.DafnySequence<? extends Selector> s) {
    dafny.DafnySequence<? extends Character> _721___accumulator = dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR);
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((s).length())).signum() == 0) {
        return dafny.DafnySequence.<Character>concatenate(_721___accumulator, dafny.DafnySequence.asString(""));
      } else if ((((Selector)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).is_Map()) {
        _721___accumulator = dafny.DafnySequence.<Character>concatenate(_721___accumulator, dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("."), (((Selector)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key()));
        dafny.DafnySequence<? extends Selector> _in79 = (s).drop(java.math.BigInteger.ONE);
        s = _in79;
        continue TAIL_CALL_START;
      } else {
        _721___accumulator = dafny.DafnySequence.<Character>concatenate(_721___accumulator, dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("["), String_Compile.__default.Base10Int2String(dafny.Helpers.unsignedLongToBigInteger((((Selector)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_pos()))), dafny.DafnySequence.asString("]")));
        dafny.DafnySequence<? extends Selector> _in80 = (s).drop(java.math.BigInteger.ONE);
        s = _in80;
        continue TAIL_CALL_START;
      }
    }
  }
  public static boolean LacksAttribute(dafny.DafnySequence<? extends Selector> t, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item)
  {
    return !(item).<dafny.DafnySequence<? extends Character>>contains((((Selector)(java.lang.Object)((t).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key());
  }
  public static Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> TermToAttr(dafny.DafnySequence<? extends Selector> t, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names)
  {
    if (!(item).<dafny.DafnySequence<? extends Character>>contains((((Selector)(java.lang.Object)((t).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key())) {
      return Wrappers_Compile.Option.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>create_None();
    } else {
      Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _722_res = __default.GetTerminal(((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue)(java.lang.Object)((item).get((((Selector)(java.lang.Object)((t).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key()))), (t).drop(java.math.BigInteger.ONE), names);
      if ((_722_res).is_Success()) {
        return Wrappers_Compile.Option.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>create_Some((_722_res).dtor_value());
      } else {
        return Wrappers_Compile.Option.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>create_None();
      }
    }
  }
  public static Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> TermToString(dafny.DafnySequence<? extends Selector> t, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item)
  {
    Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _723_part = __default.TermToAttr(t, item, Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>create_None());
    if ((_723_part).is_None()) {
      return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None());
    } else {
      Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _724_valueOrError0 = __default.AttrValueToString((_723_part).dtor_value());
      if ((_724_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        return (_724_valueOrError0).<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
      } else {
        dafny.DafnySequence<? extends Character> _725_res = (_724_valueOrError0).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(_725_res));
      }
    }
  }
  public static Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> TermToBytes(dafny.DafnySequence<? extends Selector> t, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item)
  {
    Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _726_part = __default.TermToAttr(t, item, Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>create_None());
    if ((_726_part).is_None()) {
      return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>create_None());
    } else {
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _727_valueOrError0 = (DynamoToStruct_Compile.__default.TopLevelAttributeToBytes((_726_part).dtor_value())).<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>MapFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)(_728_e_boxed0) -> {
        dafny.DafnySequence<? extends Character> _728_e = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_728_e_boxed0));
        return DynamoDbEncryptionUtil_Compile.__default.E(_728_e);
      }));
      if ((_727_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        return (_727_valueOrError0).<Wrappers_Compile.Option<dafny.DafnySequence<? extends java.lang.Byte>>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor())));
      } else {
        dafny.DafnySequence<? extends java.lang.Byte> _729_res = (_727_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>create_Some(_729_res));
      }
    }
  }
  public static Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> GetTerminal(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue v, dafny.DafnySequence<? extends Selector> parts, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((parts).length())).signum() == 0) {
        return Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(v);
      } else {
        Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue _source5 = v;
        if (_source5.is_S()) {
          dafny.DafnySequence<? extends Character> _730___mcc_h0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_S)_source5)._S;
          dafny.DafnySequence<? extends Character> _731_s = _730___mcc_h0;
          return Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Found string with parts left over.")));
        } else if (_source5.is_N()) {
          dafny.DafnySequence<? extends Character> _732___mcc_h1 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_N)_source5)._N;
          dafny.DafnySequence<? extends Character> _733_s = _732___mcc_h1;
          return Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Found number with parts left over.")));
        } else if (_source5.is_B()) {
          dafny.DafnySequence<? extends java.lang.Byte> _734___mcc_h2 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_B)_source5)._B;
          dafny.DafnySequence<? extends java.lang.Byte> _735_b = _734___mcc_h2;
          return Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Found binary with parts left over.")));
        } else if (_source5.is_SS()) {
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _736___mcc_h3 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_SS)_source5)._SS;
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _737_s = _736___mcc_h3;
          return Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Found string set with parts left over.")));
        } else if (_source5.is_NS()) {
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _738___mcc_h4 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_NS)_source5)._NS;
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _739_s = _738___mcc_h4;
          return Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Found number set with parts left over.")));
        } else if (_source5.is_BS()) {
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _740___mcc_h5 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_BS)_source5)._BS;
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _741_s = _740___mcc_h5;
          return Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Found binary set with parts left over.")));
        } else if (_source5.is_M()) {
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _742___mcc_h6 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_M)_source5)._M;
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _743_m = _742___mcc_h6;
          if (!((((Selector)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).is_Map())) {
            return Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Tried to access map with index")));
          } else if (!(_743_m).<dafny.DafnySequence<? extends Character>>contains((((Selector)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key())) {
            if ((((names).is_Some()) && (((names).dtor_value()).<dafny.DafnySequence<? extends Character>>contains((((Selector)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key()))) && ((_743_m).<dafny.DafnySequence<? extends Character>>contains(((dafny.DafnySequence<? extends Character>)(java.lang.Object)(((names).dtor_value()).get((((Selector)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key())))))) {
              Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue _in81 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue)(java.lang.Object)((_743_m).get(((dafny.DafnySequence<? extends Character>)(java.lang.Object)(((names).dtor_value()).get((((Selector)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key()))))));
              dafny.DafnySequence<? extends Selector> _in82 = (parts).drop(java.math.BigInteger.ONE);
              Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in83 = names;
              v = _in81;
              parts = _in82;
              names = _in83;
              continue TAIL_CALL_START;
            } else {
              return Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Tried to access "), (((Selector)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key()), dafny.DafnySequence.asString(" which is not in the map."))));
            }
          } else {
            Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue _in84 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue)(java.lang.Object)((_743_m).get((((Selector)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key())));
            dafny.DafnySequence<? extends Selector> _in85 = (parts).drop(java.math.BigInteger.ONE);
            Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in86 = names;
            v = _in84;
            parts = _in85;
            names = _in86;
            continue TAIL_CALL_START;
          }
        } else if (_source5.is_L()) {
          dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _744___mcc_h7 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_L)_source5)._L;
          dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _745_l = _744___mcc_h7;
          if (!((((Selector)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).is_List())) {
            return Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Tried to access list with key")));
          } else if ((java.math.BigInteger.valueOf((_745_l).length())).compareTo(dafny.Helpers.unsignedLongToBigInteger((((Selector)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_pos())) <= 0) {
            return Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Tried to access beyond the end of the list")));
          } else {
            Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue _in87 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue)(java.lang.Object)((_745_l).select(dafny.Helpers.unsignedToInt((((Selector)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_pos()))));
            dafny.DafnySequence<? extends Selector> _in88 = (parts).drop(java.math.BigInteger.ONE);
            Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _in89 = names;
            v = _in87;
            parts = _in88;
            names = _in89;
            continue TAIL_CALL_START;
          }
        } else if (_source5.is_NULL()) {
          boolean _746___mcc_h8 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_NULL)_source5)._NULL;
          boolean _747_n = _746___mcc_h8;
          return Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Found null with parts left over.")));
        } else {
          boolean _748___mcc_h9 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_BOOL)_source5)._BOOL;
          boolean _749_b = _748___mcc_h9;
          return Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Found boolean with parts left over.")));
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> AttrValueToString(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue v) {
    Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue _source6 = v;
    if (_source6.is_S()) {
      dafny.DafnySequence<? extends Character> _750___mcc_h0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_S)_source6)._S;
      dafny.DafnySequence<? extends Character> _751_s = _750___mcc_h0;
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(_751_s);
    } else if (_source6.is_N()) {
      dafny.DafnySequence<? extends Character> _752___mcc_h1 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_N)_source6)._N;
      dafny.DafnySequence<? extends Character> _753_s = _752___mcc_h1;
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(_753_s);
    } else if (_source6.is_B()) {
      dafny.DafnySequence<? extends java.lang.Byte> _754___mcc_h2 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_B)_source6)._B;
      dafny.DafnySequence<? extends java.lang.Byte> _755_b = _754___mcc_h2;
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Can't convert Binary to string")));
    } else if (_source6.is_SS()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _756___mcc_h3 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_SS)_source6)._SS;
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _757_s = _756___mcc_h3;
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Can't convert String Set to string.")));
    } else if (_source6.is_NS()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _758___mcc_h4 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_NS)_source6)._NS;
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _759_s = _758___mcc_h4;
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Can't convert Number Set to string.")));
    } else if (_source6.is_BS()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _760___mcc_h5 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_BS)_source6)._BS;
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _761_s = _760___mcc_h5;
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Can't convert Binary Set to string.")));
    } else if (_source6.is_M()) {
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _762___mcc_h6 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_M)_source6)._M;
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _763_m = _762___mcc_h6;
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Can't convert Map to string.")));
    } else if (_source6.is_L()) {
      dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _764___mcc_h7 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_L)_source6)._L;
      dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _765_l = _764___mcc_h7;
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Can't convert List to string.")));
    } else if (_source6.is_NULL()) {
      boolean _766___mcc_h8 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_NULL)_source6)._NULL;
      boolean _767_n = _766___mcc_h8;
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(dafny.DafnySequence.asString("null"));
    } else {
      boolean _768___mcc_h9 = ((Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue_BOOL)_source6)._BOOL;
      boolean _769_b = _768___mcc_h9;
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(((_769_b) ? (dafny.DafnySequence.asString("true")) : (dafny.DafnySequence.asString("false"))));
    }
  }
  public static Wrappers_Compile.Option<java.math.BigInteger> FindStartOfNext(dafny.DafnySequence<? extends Character> s) {
    Wrappers_Compile.Option<java.math.BigInteger> _770_dot = StandardLibrary_Compile.__default.<Character>FindIndexMatching(dafny.TypeDescriptor.CHAR, s, '.', java.math.BigInteger.ZERO);
    Wrappers_Compile.Option<java.math.BigInteger> _771_bracket = StandardLibrary_Compile.__default.<Character>FindIndexMatching(dafny.TypeDescriptor.CHAR, s, '[', java.math.BigInteger.ZERO);
    if (((_770_dot).is_None()) && ((_771_bracket).is_None())) {
      return Wrappers_Compile.Option.<java.math.BigInteger>create_None();
    } else if (((_770_dot).is_Some()) && ((_771_bracket).is_Some())) {
      if (((_770_dot).dtor_value()).compareTo((_771_bracket).dtor_value()) < 0) {
        return _770_dot;
      } else {
        return _771_bracket;
      }
    } else if ((_770_dot).is_Some()) {
      return _770_dot;
    } else {
      return _771_bracket;
    }
  }
  public static Wrappers_Compile.Result<java.math.BigInteger, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> GetNumber(dafny.DafnySequence<? extends Character> s, java.math.BigInteger acc)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((s).length())).signum() == 0) {
        return Wrappers_Compile.Result.<java.math.BigInteger, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(acc);
      } else if ((('0') <= (((char)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))) && ((((char)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))) <= ('9'))) {
        dafny.DafnySequence<? extends Character> _in90 = (s).drop(java.math.BigInteger.ONE);
        java.math.BigInteger _in91 = (((acc).multiply(java.math.BigInteger.valueOf(10L))).add(java.math.BigInteger.valueOf(((char)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))))).subtract(java.math.BigInteger.valueOf('0'));
        s = _in90;
        acc = _in91;
        continue TAIL_CALL_START;
      } else {
        return Wrappers_Compile.Result.<java.math.BigInteger, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Unexpected character in number : "), dafny.DafnySequence.of(((char)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))))));
      }
    }
  }
  public static Wrappers_Compile.Result<Selector, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> GetSelector(dafny.DafnySequence<? extends Character> s) {
    if ((((char)(java.lang.Object)((s).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))) == ('.')) {
      return Wrappers_Compile.Result.<Selector, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(TermLoc_Compile.Selector.create_Map((s).drop(java.math.BigInteger.ONE)));
    } else if ((((char)(java.lang.Object)((s).select(dafny.Helpers.toInt(((java.math.BigInteger.valueOf((s).length())).subtract(java.math.BigInteger.ONE))))))) != (']')) {
      return Wrappers_Compile.Result.<Selector, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("List index must end with ]")));
    } else {
      Wrappers_Compile.Result<java.math.BigInteger, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _772_valueOrError0 = __default.GetNumber((s).subsequence(dafny.Helpers.toInt((java.math.BigInteger.ONE)), dafny.Helpers.toInt(((java.math.BigInteger.valueOf((s).length())).subtract(java.math.BigInteger.ONE)))), java.math.BigInteger.ZERO);
      if ((_772_valueOrError0).IsFailure(_System.nat._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        return (_772_valueOrError0).<Selector>PropagateFailure(_System.nat._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Selector._typeDescriptor());
      } else {
        java.math.BigInteger _773_num = (_772_valueOrError0).Extract(_System.nat._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _774_valueOrError1 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), (_773_num).compareTo(StandardLibrary_mUInt_Compile.__default.UINT64__LIMIT()) < 0, DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Array selector exceeds maximum.")));
        if ((_774_valueOrError1).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          return (_774_valueOrError1).<Selector>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Selector._typeDescriptor());
        } else {
          return Wrappers_Compile.Result.<Selector, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(TermLoc_Compile.Selector.create_List((_773_num).longValue()));
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends Selector>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> GetSelectors(dafny.DafnySequence<? extends Character> s, dafny.DafnySequence<? extends Selector> acc)
  {
    TAIL_CALL_START: while (true) {
      Wrappers_Compile.Option<java.math.BigInteger> _775_pos = __default.FindStartOfNext((s).drop(java.math.BigInteger.ONE));
      java.math.BigInteger _776_end = (((_775_pos).is_None()) ? (java.math.BigInteger.valueOf((s).length())) : (((_775_pos).dtor_value()).add(java.math.BigInteger.ONE)));
      Wrappers_Compile.Result<Selector, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _777_valueOrError0 = __default.GetSelector((s).take(_776_end));
      if ((_777_valueOrError0).IsFailure(Selector._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        return (_777_valueOrError0).<dafny.DafnySequence<? extends Selector>>PropagateFailure(Selector._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<Selector>_typeDescriptor(Selector._typeDescriptor()));
      } else {
        Selector _778_sel = (_777_valueOrError0).Extract(Selector._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _779_valueOrError1 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), ((java.math.BigInteger.valueOf((acc).length())).add(java.math.BigInteger.ONE)).compareTo(StandardLibrary_mUInt_Compile.__default.UINT64__LIMIT()) < 0, DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Selector Overflow")));
        if ((_779_valueOrError1).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          return (_779_valueOrError1).<dafny.DafnySequence<? extends Selector>>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<Selector>_typeDescriptor(Selector._typeDescriptor()));
        } else if ((_775_pos).is_None()) {
          return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Selector>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(dafny.DafnySequence.<Selector>concatenate(acc, dafny.DafnySequence.of(Selector._typeDescriptor(), _778_sel)));
        } else {
          dafny.DafnySequence<? extends Character> _in92 = (s).drop(_776_end);
          dafny.DafnySequence<? extends Selector> _in93 = dafny.DafnySequence.<Selector>concatenate(acc, dafny.DafnySequence.of(Selector._typeDescriptor(), _778_sel));
          s = _in92;
          acc = _in93;
          continue TAIL_CALL_START;
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends Selector>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> MakeTermLoc(dafny.DafnySequence<? extends Character> s) {
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _780_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), (java.math.BigInteger.valueOf((s).length())).signum() == 1, DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Path specification must not be empty.")));
    if ((_780_valueOrError0).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
      return (_780_valueOrError0).<dafny.DafnySequence<? extends Selector>>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<Selector>_typeDescriptor(Selector._typeDescriptor()));
    } else {
      Wrappers_Compile.Option<java.math.BigInteger> _781_pos = __default.FindStartOfNext(s);
      if ((_781_pos).is_None()) {
        Selector _782_m = TermLoc_Compile.Selector.create_Map(s);
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Selector>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(dafny.DafnySequence.of(Selector._typeDescriptor(), TermLoc_Compile.Selector.create_Map(s)));
      } else {
        dafny.DafnySequence<? extends Character> _783_name = (s).take((_781_pos).dtor_value());
        Wrappers_Compile.Result<dafny.DafnySequence<? extends Selector>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _784_valueOrError1 = __default.GetSelectors((s).drop((_781_pos).dtor_value()), dafny.DafnySequence.<Selector> empty(Selector._typeDescriptor()));
        if ((_784_valueOrError1).IsFailure(SelectorList._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          return (_784_valueOrError1).<dafny.DafnySequence<? extends Selector>>PropagateFailure(SelectorList._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<Selector>_typeDescriptor(Selector._typeDescriptor()));
        } else {
          dafny.DafnySequence<? extends Selector> _785_selectors = (_784_valueOrError1).Extract(SelectorList._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
          Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _786_valueOrError2 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), ((java.math.BigInteger.valueOf((_785_selectors).length())).add(java.math.BigInteger.ONE)).compareTo(StandardLibrary_mUInt_Compile.__default.UINT64__LIMIT()) < 0, DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Selector Overflow")));
          if ((_786_valueOrError2).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
            return (_786_valueOrError2).<dafny.DafnySequence<? extends Selector>>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<Selector>_typeDescriptor(Selector._typeDescriptor()));
          } else {
            return Wrappers_Compile.Result.<dafny.DafnySequence<? extends Selector>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(dafny.DafnySequence.<Selector>concatenate(dafny.DafnySequence.of(Selector._typeDescriptor(), TermLoc_Compile.Selector.create_Map(_783_name)), _785_selectors));
          }
        }
      }
    }
  }
  public static dafny.DafnySequence<? extends Selector> TermLocMap(dafny.DafnySequence<? extends Character> attr) {
    return dafny.DafnySequence.of(Selector._typeDescriptor(), TermLoc_Compile.Selector.create_Map(attr));
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "TermLoc_Compile._default";
  }
}
