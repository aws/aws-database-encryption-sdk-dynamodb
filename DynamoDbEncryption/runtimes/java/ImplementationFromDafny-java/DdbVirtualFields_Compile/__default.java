// Class __default
// Dafny class __default compiled into Java
package DdbVirtualFields_Compile;

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
import TermLoc_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static Wrappers_Compile.Result<VirtField, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> ParseVirtualFieldConfig(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualField vf) {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends VirtPart>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _789_valueOrError0 = Seq_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualPart, VirtPart, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>MapWithResult(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualPart._typeDescriptor(), VirtPart._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualPart, Wrappers_Compile.Result<VirtPart, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>>)(_790_p_boxed0) -> {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualPart _790_p = ((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualPart)(java.lang.Object)(_790_p_boxed0));
      return __default.ParseVirtualPartConfig(_790_p);
    }), (vf).dtor_parts());
    if ((_789_valueOrError0).IsFailure(dafny.DafnySequence.<VirtPart>_typeDescriptor(VirtPart._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
      return (_789_valueOrError0).<VirtField>PropagateFailure(dafny.DafnySequence.<VirtPart>_typeDescriptor(VirtPart._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), VirtField._typeDescriptor());
    } else {
      dafny.DafnySequence<? extends VirtPart> _791_parts = (_789_valueOrError0).Extract(dafny.DafnySequence.<VirtPart>_typeDescriptor(VirtPart._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
      return Wrappers_Compile.Result.<VirtField, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DdbVirtualFields_Compile.VirtField.create((vf).dtor_name(), _791_parts));
    }
  }
  public static Wrappers_Compile.Result<VirtPart, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> ParseVirtualPartConfig(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualPart part) {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends TermLoc_Compile.Selector>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _792_valueOrError0 = TermLoc_Compile.__default.MakeTermLoc((part).dtor_loc());
    if ((_792_valueOrError0).IsFailure(TermLoc_Compile.TermLoc._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
      return (_792_valueOrError0).<VirtPart>PropagateFailure(TermLoc_Compile.TermLoc._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), VirtPart._typeDescriptor());
    } else {
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _793_loc = (_792_valueOrError0).Extract(TermLoc_Compile.TermLoc._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
      if (((part).dtor_trans()).is_None()) {
        return Wrappers_Compile.Result.<VirtPart, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DdbVirtualFields_Compile.VirtPart.create(_793_loc, dafny.DafnySequence.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform> empty(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform._typeDescriptor())));
      } else {
        return Wrappers_Compile.Result.<VirtPart, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(DdbVirtualFields_Compile.VirtPart.create(_793_loc, ((part).dtor_trans()).dtor_value()));
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
        dafny.DafnySequence<? extends VirtPart> _in94 = (parts).drop(java.math.BigInteger.ONE);
        java.util.function.Function<dafny.DafnySequence<? extends TermLoc_Compile.Selector>, Boolean> _in95 = exam;
        parts = _in94;
        exam = _in95;
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
    java.math.BigInteger _794_lo = __default.GetPos(low, java.math.BigInteger.valueOf((s).length()));
    java.math.BigInteger _795_hi = __default.GetPos(high, java.math.BigInteger.valueOf((s).length()));
    if ((_794_lo).compareTo(_795_hi) < 0) {
      return (s).subsequence(dafny.Helpers.toInt((_794_lo)), dafny.Helpers.toInt((_795_hi)));
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
    return Seq_Compile.__default.<Character, Character>Map(dafny.TypeDescriptor.CHAR, dafny.TypeDescriptor.CHAR, ((java.util.function.Function<Character, Character>)(_796_c_boxed0) -> {
      char _796_c = ((char)(java.lang.Object)(_796_c_boxed0));
      return __default.UpperChar(_796_c);
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
    return Seq_Compile.__default.<Character, Character>Map(dafny.TypeDescriptor.CHAR, dafny.TypeDescriptor.CHAR, ((java.util.function.Function<Character, Character>)(_797_c_boxed0) -> {
      char _797_c = ((char)(java.lang.Object)(_797_c_boxed0));
      return __default.LowerChar(_797_c);
    }), s);
  }
  public static dafny.DafnySequence<? extends Character> GetSegment(dafny.DafnySequence<? extends Character> s, char split, java.math.BigInteger index)
  {
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _798_parts = StandardLibrary_Compile.__default.<Character>Split(dafny.TypeDescriptor.CHAR, s, split);
    if (((index).compareTo(java.math.BigInteger.valueOf((_798_parts).length())) >= 0) || (((java.math.BigInteger.ZERO).subtract(index)).compareTo(java.math.BigInteger.valueOf((_798_parts).length())) > 0)) {
      return dafny.DafnySequence.asString("");
    } else {
      return ((dafny.DafnySequence<? extends Character>)(java.lang.Object)((_798_parts).select(dafny.Helpers.toInt((__default.GetPos(index, java.math.BigInteger.valueOf((_798_parts).length())))))));
    }
  }
  public static dafny.DafnySequence<? extends Character> GetSegments(dafny.DafnySequence<? extends Character> s, char split, java.math.BigInteger low, java.math.BigInteger high)
  {
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _799_parts = StandardLibrary_Compile.__default.<Character>Split(dafny.TypeDescriptor.CHAR, s, split);
    java.math.BigInteger _800_lo = __default.GetPos(low, java.math.BigInteger.valueOf((_799_parts).length()));
    java.math.BigInteger _801_hi = __default.GetPos(high, java.math.BigInteger.valueOf((_799_parts).length()));
    if ((_800_lo).compareTo(_801_hi) < 0) {
      return StandardLibrary_Compile.__default.<Character>Join(dafny.TypeDescriptor.CHAR, (_799_parts).subsequence(dafny.Helpers.toInt((_800_lo)), dafny.Helpers.toInt((_801_hi))), dafny.DafnySequence.of(split));
    } else {
      return dafny.DafnySequence.asString("");
    }
  }
  public static dafny.DafnySequence<? extends Character> DoTransform(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform t, dafny.DafnySequence<? extends Character> s)
  {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform _source7 = t;
    if (_source7.is_upper()) {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Upper _802___mcc_h0 = ((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform_upper)_source7)._upper;
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Upper _803_up = _802___mcc_h0;
      return __default.UpperCase(s);
    } else if (_source7.is_lower()) {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Lower _804___mcc_h1 = ((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform_lower)_source7)._lower;
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Lower _805_lo = _804___mcc_h1;
      return __default.LowerCase(s);
    } else if (_source7.is_insert()) {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Insert _806___mcc_h2 = ((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform_insert)_source7)._insert;
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Insert _807_ins = _806___mcc_h2;
      return dafny.DafnySequence.<Character>concatenate(s, (_807_ins).dtor_literal());
    } else if (_source7.is_prefix()) {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetPrefix _808___mcc_h3 = ((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform_prefix)_source7)._prefix;
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetPrefix _809_pre = _808___mcc_h3;
      return __default.GetPrefix(s, java.math.BigInteger.valueOf(((_809_pre).dtor_length())));
    } else if (_source7.is_suffix()) {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSuffix _810___mcc_h4 = ((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform_suffix)_source7)._suffix;
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSuffix _811_suf = _810___mcc_h4;
      return __default.GetSuffix(s, java.math.BigInteger.valueOf(((_811_suf).dtor_length())));
    } else if (_source7.is_substring()) {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSubstring _812___mcc_h5 = ((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform_substring)_source7)._substring;
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSubstring _813_sub = _812___mcc_h5;
      return __default.GetSubstring(s, java.math.BigInteger.valueOf(((_813_sub).dtor_low())), java.math.BigInteger.valueOf(((_813_sub).dtor_high())));
    } else if (_source7.is_segment()) {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSegment _814___mcc_h6 = ((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform_segment)_source7)._segment;
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSegment _815_seg = _814___mcc_h6;
      return __default.GetSegment(s, ((char)(java.lang.Object)(((_815_seg).dtor_split()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), java.math.BigInteger.valueOf(((_815_seg).dtor_index())));
    } else {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSegments _816___mcc_h7 = ((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform_segments)_source7)._segments;
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSegments _817_seg = _816___mcc_h7;
      return __default.GetSegments(s, ((char)(java.lang.Object)(((_817_seg).dtor_split()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), java.math.BigInteger.valueOf(((_817_seg).dtor_low())), java.math.BigInteger.valueOf(((_817_seg).dtor_high())));
    }
  }
  public static dafny.DafnySequence<? extends Character> FullTransform(dafny.DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform> t, dafny.DafnySequence<? extends Character> s)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((t).length())).signum() == 0) {
        return s;
      } else {
        dafny.DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform> _in96 = (t).drop(java.math.BigInteger.ONE);
        dafny.DafnySequence<? extends Character> _in97 = __default.DoTransform(((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform)(java.lang.Object)((t).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), s);
        t = _in96;
        s = _in97;
        continue TAIL_CALL_START;
      }
    }
  }
  public static Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> GetVirtField(VirtField vf, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item)
  {
    return __default.GetVirtField2((vf).dtor_parts(), item, dafny.DafnySequence.asString(""));
  }
  public static Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> GetVirtField2(dafny.DafnySequence<? extends VirtPart> parts, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item, dafny.DafnySequence<? extends Character> acc)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((parts).length())).signum() == 0) {
        return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(acc));
      } else {
        Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _818_valueOrError0 = TermLoc_Compile.__default.TermToString((((VirtPart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_loc(), item);
        if ((_818_valueOrError0).IsFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          return (_818_valueOrError0).<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>>PropagateFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
        } else {
          Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _819_value = (_818_valueOrError0).Extract(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
          if ((_819_value).is_None()) {
            return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None());
          } else {
            dafny.DafnySequence<? extends Character> _820_trans = __default.FullTransform((((VirtPart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_trans(), (_819_value).dtor_value());
            dafny.DafnySequence<? extends VirtPart> _in98 = (parts).drop(java.math.BigInteger.ONE);
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _in99 = item;
            dafny.DafnySequence<? extends Character> _in100 = dafny.DafnySequence.<Character>concatenate(acc, _820_trans);
            parts = _in98;
            item = _in99;
            acc = _in100;
            continue TAIL_CALL_START;
          }
        }
      }
    }
  }
  public static Wrappers_Compile.Result<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> VirtToAttr(dafny.DafnySequence<? extends TermLoc_Compile.Selector> loc, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends VirtField> vf)
  {
    if ((java.util.Objects.equals(java.math.BigInteger.valueOf((loc).length()), java.math.BigInteger.ONE)) && ((vf).<dafny.DafnySequence<? extends Character>>contains((((TermLoc_Compile.Selector)(java.lang.Object)((loc).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key()))) {
      Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _821_valueOrError0 = __default.GetVirtField(((VirtField)(java.lang.Object)((vf).get((((TermLoc_Compile.Selector)(java.lang.Object)((loc).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key()))), item);
      if ((_821_valueOrError0).IsFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        return (_821_valueOrError0).<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>PropagateFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Wrappers_Compile.Option.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()));
      } else {
        Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _822_str = (_821_valueOrError0).Extract(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        if ((_822_str).is_None()) {
          return Wrappers_Compile.Result.<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(Wrappers_Compile.Option.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>create_None());
        } else {
          return Wrappers_Compile.Result.<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(Wrappers_Compile.Option.<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>create_Some(__default.DS((_822_str).dtor_value())));
        }
      }
    } else {
      return Wrappers_Compile.Result.<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(TermLoc_Compile.__default.TermToAttr(loc, item, Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>create_None()));
    }
  }
  public static Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> VirtToBytes(dafny.DafnySequence<? extends TermLoc_Compile.Selector> loc, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends VirtField> vf)
  {
    if ((java.util.Objects.equals(java.math.BigInteger.valueOf((loc).length()), java.math.BigInteger.ONE)) && ((vf).<dafny.DafnySequence<? extends Character>>contains((((TermLoc_Compile.Selector)(java.lang.Object)((loc).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key()))) {
      Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _823_valueOrError0 = __default.GetVirtField(((VirtField)(java.lang.Object)((vf).get((((TermLoc_Compile.Selector)(java.lang.Object)((loc).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key()))), item);
      if ((_823_valueOrError0).IsFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        return (_823_valueOrError0).<Wrappers_Compile.Option<dafny.DafnySequence<? extends java.lang.Byte>>>PropagateFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor())));
      } else {
        Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _824_str = (_823_valueOrError0).Extract(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        if ((_824_str).is_None()) {
          return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>create_None());
        } else {
          Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _825_valueOrError1 = (UTF8.__default.Encode((_824_str).dtor_value())).<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>MapFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)(_826_e_boxed0) -> {
            dafny.DafnySequence<? extends Character> _826_e = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_826_e_boxed0));
            return DynamoDbEncryptionUtil_Compile.__default.E(_826_e);
          }));
          if ((_825_valueOrError1).IsFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
            return (_825_valueOrError1).<Wrappers_Compile.Option<dafny.DafnySequence<? extends java.lang.Byte>>>PropagateFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor())));
          } else {
            dafny.DafnySequence<? extends java.lang.Byte> _827_ustr = (_825_valueOrError1).Extract(UTF8.ValidUTF8Bytes._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
            return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(Wrappers_Compile.Option.<dafny.DafnySequence<? extends java.lang.Byte>>create_Some(_827_ustr));
          }
        }
      }
    } else {
      return TermLoc_Compile.__default.TermToBytes(loc, item);
    }
  }
  public static Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> VirtToString(dafny.DafnySequence<? extends TermLoc_Compile.Selector> loc, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends VirtField> vf)
  {
    if ((java.util.Objects.equals(java.math.BigInteger.valueOf((loc).length()), java.math.BigInteger.ONE)) && ((vf).<dafny.DafnySequence<? extends Character>>contains((((TermLoc_Compile.Selector)(java.lang.Object)((loc).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key()))) {
      return __default.GetVirtField(((VirtField)(java.lang.Object)((vf).get((((TermLoc_Compile.Selector)(java.lang.Object)((loc).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key()))), item);
    } else {
      return TermLoc_Compile.__default.TermToString(loc, item);
    }
  }
  public static Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue DS(dafny.DafnySequence<? extends Character> s) {
    return Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.create_S(s);
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "DdbVirtualFields_Compile._default";
  }
}
