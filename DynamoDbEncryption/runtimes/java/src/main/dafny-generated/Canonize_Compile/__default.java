// Class __default
// Dafny class __default compiled into Java
package Canonize_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static boolean IsCanonPath(dafny.DafnySequence<? extends Character> table, dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment> origKey, dafny.DafnySequence<? extends java.lang.Byte> key)
  {
    return (key).equals(StructuredEncryptionPaths_Compile.__default.CanonPath(table, origKey));
  }
  public static StructuredEncryptionUtil_Compile.CanonCryptoItem MakeCanon(dafny.DafnySequence<? extends Character> tableName, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem data)
  {
    return StructuredEncryptionUtil_Compile.CanonCryptoItem.create(StructuredEncryptionPaths_Compile.__default.CanonPath(tableName, (data).dtor_key()), (data).dtor_key(), (data).dtor_data(), (data).dtor_action());
  }
  public static StructuredEncryptionUtil_Compile.CanonAuthItem MakeCanonAuth(dafny.DafnySequence<? extends Character> tableName, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthItem data)
  {
    return StructuredEncryptionUtil_Compile.CanonAuthItem.create(StructuredEncryptionPaths_Compile.__default.CanonPath(tableName, (data).dtor_key()), (data).dtor_key(), (data).dtor_data(), (data).dtor_action());
  }
  public static boolean Same(StructuredEncryptionUtil_Compile.CanonAuthItem x, StructuredEncryptionUtil_Compile.CanonCryptoItem y)
  {
    return ((((x).dtor_key()).equals((y).dtor_key())) && (((x).dtor_origKey()).equals((y).dtor_origKey()))) && (java.util.Objects.equals((x).dtor_data(), (y).dtor_data()));
  }
  public static StructuredEncryptionUtil_Compile.CanonCryptoItem MakeCryptoItem(StructuredEncryptionUtil_Compile.CanonAuthItem x, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction action)
  {
    return StructuredEncryptionUtil_Compile.CanonCryptoItem.create((x).dtor_key(), (x).dtor_origKey(), (x).dtor_data(), action);
  }
  public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction LegendToAction(byte v) {
    if ((v) == (StructuredEncryptionHeader_Compile.__default.ENCRYPT__AND__SIGN__LEGEND())) {
      return software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN();
    } else if ((v) == (StructuredEncryptionHeader_Compile.__default.SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT__LEGEND())) {
      return software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT();
    } else {
      return software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__ONLY();
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> ResolveLegend(dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonAuthItem> fields, dafny.DafnySequence<? extends java.lang.Byte> legend, long pos, long legendPos, dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem> acc)
  {
    TAIL_CALL_START: while (true) {
      if (((long) (fields).cardinalityInt()) == (pos)) {
        Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _0_valueOrError0 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), ((long) (legend).cardinalityInt()) == (legendPos), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Schema changed : something that was signed is now unsigned.")));
        if ((_0_valueOrError0).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
          return (_0_valueOrError0).<dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<StructuredEncryptionUtil_Compile.CanonCryptoItem>_typeDescriptor(StructuredEncryptionUtil_Compile.CanonCryptoItem._typeDescriptor()));
        } else {
          return Wrappers_Compile.Result.<dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Success(dafny.DafnySequence.<StructuredEncryptionUtil_Compile.CanonCryptoItem>_typeDescriptor(StructuredEncryptionUtil_Compile.CanonCryptoItem._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), acc);
        }
      } else if (java.util.Objects.equals((((StructuredEncryptionUtil_Compile.CanonAuthItem)(java.lang.Object)((fields).select(dafny.Helpers.unsignedToInt(pos))))).dtor_action(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthenticateAction.create_DO__NOT__SIGN())) {
        dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonAuthItem> _in0 = fields;
        dafny.DafnySequence<? extends java.lang.Byte> _in1 = legend;
        long _in2 = (long) (long) ((pos) + ((long) 1L));
        long _in3 = legendPos;
        dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem> _in4 = dafny.DafnySequence.<StructuredEncryptionUtil_Compile.CanonCryptoItem>concatenate(acc, dafny.DafnySequence.<StructuredEncryptionUtil_Compile.CanonCryptoItem> of(StructuredEncryptionUtil_Compile.CanonCryptoItem._typeDescriptor(), __default.MakeCryptoItem(((StructuredEncryptionUtil_Compile.CanonAuthItem)(java.lang.Object)((fields).select(dafny.Helpers.unsignedToInt(pos)))), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_DO__NOTHING())));
        fields = _in0;
        legend = _in1;
        pos = _in2;
        legendPos = _in3;
        acc = _in4;
        continue TAIL_CALL_START;
      } else {
        Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _1_valueOrError1 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), java.lang.Long.compareUnsigned(legendPos, (long) (legend).cardinalityInt()) < 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Schema changed : something that was unsigned is now signed.")));
        if ((_1_valueOrError1).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
          return (_1_valueOrError1).<dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<StructuredEncryptionUtil_Compile.CanonCryptoItem>_typeDescriptor(StructuredEncryptionUtil_Compile.CanonCryptoItem._typeDescriptor()));
        } else {
          dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonAuthItem> _in5 = fields;
          dafny.DafnySequence<? extends java.lang.Byte> _in6 = legend;
          long _in7 = (long) (long) ((pos) + ((long) 1L));
          long _in8 = (long) (long) ((legendPos) + ((long) 1L));
          dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem> _in9 = dafny.DafnySequence.<StructuredEncryptionUtil_Compile.CanonCryptoItem>concatenate(acc, dafny.DafnySequence.<StructuredEncryptionUtil_Compile.CanonCryptoItem> of(StructuredEncryptionUtil_Compile.CanonCryptoItem._typeDescriptor(), __default.MakeCryptoItem(((StructuredEncryptionUtil_Compile.CanonAuthItem)(java.lang.Object)((fields).select(dafny.Helpers.unsignedToInt(pos)))), __default.LegendToAction(((byte)(java.lang.Object)((legend).select(dafny.Helpers.unsignedToInt(legendPos))))))));
          fields = _in5;
          legend = _in6;
          pos = _in7;
          legendPos = _in8;
          acc = _in9;
          continue TAIL_CALL_START;
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> ForEncrypt(dafny.DafnySequence<? extends Character> tableName, dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem> data)
  {
    Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _0_valueOrError0 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem>, Boolean>)(_1_data) -> dafny.Helpers.Quantifier((_1_data).UniqueElements(), true, ((_forall_var_0_boxed0) -> {
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem _forall_var_0 = ((software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem)(java.lang.Object)(_forall_var_0_boxed0));
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem _2_k = (software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem)_forall_var_0;
      return !((_1_data).contains(_2_k)) || (StructuredEncryptionPaths_Compile.__default.ValidPath((_2_k).dtor_key()));
    }))).apply(data), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Invalid Paths")));
    if ((_0_valueOrError0).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
      return (_0_valueOrError0).<dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<StructuredEncryptionUtil_Compile.CanonCryptoItem>_typeDescriptor(StructuredEncryptionUtil_Compile.CanonCryptoItem._typeDescriptor()));
    } else {
      dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem> _3_canonList = __default.CryptoToCanonCrypto(tableName, data);
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Success(dafny.DafnySequence.<StructuredEncryptionUtil_Compile.CanonCryptoItem>_typeDescriptor(StructuredEncryptionUtil_Compile.CanonCryptoItem._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), __default.CryptoSort(_3_canonList));
    }
  }
  public static dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonAuthItem> AuthToCanonAuth(dafny.DafnySequence<? extends Character> tableName, dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthItem> data)
  {
    dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonAuthItem> _0_canonList = Seq_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthItem, StructuredEncryptionUtil_Compile.CanonAuthItem>Map(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthItem._typeDescriptor(), StructuredEncryptionUtil_Compile.CanonAuthItem._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, java.util.function.Function<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthItem, StructuredEncryptionUtil_Compile.CanonAuthItem>>)(_1_tableName) -> ((java.util.function.Function<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthItem, StructuredEncryptionUtil_Compile.CanonAuthItem>)(_2_s_boxed0) -> {
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthItem _2_s = ((software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthItem)(java.lang.Object)(_2_s_boxed0));
      return __default.MakeCanonAuth(_1_tableName, _2_s);
    })).apply(tableName), data);
    return _0_canonList;
  }
  public static dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem> CryptoToCanonCrypto(dafny.DafnySequence<? extends Character> tableName, dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem> data)
  {
    dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem> _0_canonList = Seq_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem, StructuredEncryptionUtil_Compile.CanonCryptoItem>Map(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem._typeDescriptor(), StructuredEncryptionUtil_Compile.CanonCryptoItem._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, java.util.function.Function<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem, StructuredEncryptionUtil_Compile.CanonCryptoItem>>)(_1_tableName) -> ((java.util.function.Function<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem, StructuredEncryptionUtil_Compile.CanonCryptoItem>)(_2_s_boxed0) -> {
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem _2_s = ((software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem)(java.lang.Object)(_2_s_boxed0));
      return __default.MakeCanon(_1_tableName, _2_s);
    })).apply(tableName), data);
    return _0_canonList;
  }
  public static dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonAuthItem> AuthSort(dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonAuthItem> canonList) {
    dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonAuthItem> _0_canonSorted = SortCanon_Compile.__default.AuthSort(canonList);
    return _0_canonSorted;
  }
  public static dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem> CryptoSort(dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem> canonList) {
    dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem> _0_canonSorted = SortCanon_Compile.__default.CryptoSort(canonList);
    return _0_canonSorted;
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> DoResolveLegend(dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonAuthItem> canonSorted, dafny.DafnySequence<? extends java.lang.Byte> legend)
  {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _0_valueOrError0 = __default.ResolveLegend(canonSorted, legend, (long) 0L, (long) 0L, dafny.DafnySequence.<StructuredEncryptionUtil_Compile.CanonCryptoItem> empty(StructuredEncryptionUtil_Compile.CanonCryptoItem._typeDescriptor()));
    if ((_0_valueOrError0).IsFailure(dafny.DafnySequence.<StructuredEncryptionUtil_Compile.CanonCryptoItem>_typeDescriptor(StructuredEncryptionUtil_Compile.CanonCryptoItem._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
      return (_0_valueOrError0).<dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem>>PropagateFailure(dafny.DafnySequence.<StructuredEncryptionUtil_Compile.CanonCryptoItem>_typeDescriptor(StructuredEncryptionUtil_Compile.CanonCryptoItem._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<StructuredEncryptionUtil_Compile.CanonCryptoItem>_typeDescriptor(StructuredEncryptionUtil_Compile.CanonCryptoItem._typeDescriptor()));
    } else {
      dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem> _1_canonResolved = (_0_valueOrError0).Extract(dafny.DafnySequence.<StructuredEncryptionUtil_Compile.CanonCryptoItem>_typeDescriptor(StructuredEncryptionUtil_Compile.CanonCryptoItem._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Success(dafny.DafnySequence.<StructuredEncryptionUtil_Compile.CanonCryptoItem>_typeDescriptor(StructuredEncryptionUtil_Compile.CanonCryptoItem._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), _1_canonResolved);
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> ForDecrypt(dafny.DafnySequence<? extends Character> tableName, dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthItem> data, dafny.DafnySequence<? extends java.lang.Byte> legend)
  {
    Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _0_valueOrError0 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthItem>, Boolean>)(_1_data) -> dafny.Helpers.Quantifier((_1_data).UniqueElements(), true, ((_forall_var_0_boxed0) -> {
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthItem _forall_var_0 = ((software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthItem)(java.lang.Object)(_forall_var_0_boxed0));
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthItem _2_k = (software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.AuthItem)_forall_var_0;
      return !((_1_data).contains(_2_k)) || (StructuredEncryptionPaths_Compile.__default.ValidPath((_2_k).dtor_key()));
    }))).apply(data), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Invalid Paths")));
    if ((_0_valueOrError0).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
      return (_0_valueOrError0).<dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<StructuredEncryptionUtil_Compile.CanonCryptoItem>_typeDescriptor(StructuredEncryptionUtil_Compile.CanonCryptoItem._typeDescriptor()));
    } else {
      dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonAuthItem> _3_canonList = __default.AuthToCanonAuth(tableName, data);
      dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonAuthItem> _4_canonSorted = __default.AuthSort(_3_canonList);
      return __default.DoResolveLegend(_4_canonSorted, legend);
    }
  }
  public static boolean SameUnCanon(StructuredEncryptionUtil_Compile.CanonCryptoItem x, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem y)
  {
    return ((((x).dtor_origKey()).equals((y).dtor_key())) && (java.util.Objects.equals((x).dtor_data(), (y).dtor_data()))) && (java.util.Objects.equals((x).dtor_action(), (y).dtor_action()));
  }
  public static dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem> UnCanon(dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem> input, long pos, dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem> acc)
  {
    TAIL_CALL_START: while (true) {
      if (((long) (input).cardinalityInt()) == (pos)) {
        return acc;
      } else {
        software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem _0_newItem = software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem.create((((StructuredEncryptionUtil_Compile.CanonCryptoItem)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos))))).dtor_origKey(), (((StructuredEncryptionUtil_Compile.CanonCryptoItem)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos))))).dtor_data(), (((StructuredEncryptionUtil_Compile.CanonCryptoItem)(java.lang.Object)((input).select(dafny.Helpers.unsignedToInt(pos))))).dtor_action());
        dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem> _in0 = input;
        long _in1 = (long) (long) ((pos) + ((long) 1L));
        dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem> _in2 = dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem>concatenate(acc, dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem> of(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem._typeDescriptor(), _0_newItem));
        input = _in0;
        pos = _in1;
        acc = _in2;
        continue TAIL_CALL_START;
      }
    }
  }
  public static dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem> UnCanonDecrypt(dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem> input) {
    dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem> _0_results = __default.UnCanon(input, (long) 0L, dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem> empty(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem._typeDescriptor()));
    return _0_results;
  }
  public static dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem> UnCanonEncrypt(dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem> input) {
    dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem> _0_results = __default.UnCanon(input, (long) 0L, dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem> empty(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem._typeDescriptor()));
    return _0_results;
  }
  public static dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem> AddHeaders(dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem> input, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal headerData, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal footerData)
  {
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem _0_headItem = software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem.create(StructuredEncryptionUtil_Compile.__default.HeaderPath(), headerData, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_DO__NOTHING());
    software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem _1_footItem = software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem.create(StructuredEncryptionUtil_Compile.__default.FooterPath(), footerData, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_DO__NOTHING());
    dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem> _2_largeResult = dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem>concatenate(input, dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem> of(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem._typeDescriptor(), _0_headItem, _1_footItem));
    return _2_largeResult;
  }
  public static dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem> RemoveHeaderPaths(dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem> xs, long pos, dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem> acc)
  {
    TAIL_CALL_START: while (true) {
      if (((long) (xs).cardinalityInt()) == (pos)) {
        return acc;
      } else if ((dafny.DafnySequence.<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment>> of(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment>_typeDescriptor(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment._typeDescriptor()), StructuredEncryptionUtil_Compile.__default.HeaderPath(), StructuredEncryptionUtil_Compile.__default.FooterPath())).contains((((software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem)(java.lang.Object)((xs).select(dafny.Helpers.unsignedToInt(pos))))).dtor_key())) {
        dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem> _in0 = xs;
        long _in1 = (long) (long) ((pos) + ((long) 1L));
        dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem> _in2 = acc;
        xs = _in0;
        pos = _in1;
        acc = _in2;
        continue TAIL_CALL_START;
      } else {
        dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem> _in3 = xs;
        long _in4 = (long) (long) ((pos) + ((long) 1L));
        dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem> _in5 = dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem>concatenate(acc, dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem> of(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem._typeDescriptor(), ((software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem)(java.lang.Object)((xs).select(dafny.Helpers.unsignedToInt(pos))))));
        xs = _in3;
        pos = _in4;
        acc = _in5;
        continue TAIL_CALL_START;
      }
    }
  }
  public static dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem> RemoveHeaders(dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem> input) {
    dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem> _0_finalData = __default.RemoveHeaderPaths(input, (long) 0L, dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem> empty(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoItem._typeDescriptor()));
    return _0_finalData;
  }
  @Override
  public java.lang.String toString() {
    return "Canonize._default";
  }
}
