// Class __default
// Dafny class __default compiled into Java
package DynamoToStruct_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> ItemToStructured2(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> actions)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> ret = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal> empty());
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _0_attrNames;
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _out0;
    _out0 = SortedSets.__default.<dafny.DafnySequence<? extends Character>>SetToSequence(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), (item).keySet());
    _0_attrNames = _out0;
    DafnyLibraries.MutableMap<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal> _1_m;
    DafnyLibraries.MutableMap<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal> _nw0 = new DafnyLibraries.MutableMap<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal>(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal._typeDescriptor(), false);
    _1_m = _nw0;
    long _hi0 = (long) (_0_attrNames).cardinalityInt();
    for (long _2_i = (long) 0L; java.lang.Long.compareUnsigned(_2_i, _hi0) < 0; _2_i++) {
      dafny.DafnySequence<? extends Character> _3_k;
      _3_k = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)((_0_attrNames).select(dafny.Helpers.unsignedToInt(_2_i))));
      if (((!(actions).<dafny.DafnySequence<? extends Character>>contains(_3_k)) || (!java.util.Objects.equals(((software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction)(java.lang.Object)((actions).get(_3_k))), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_DO__NOTHING()))) || ((DynamoDbEncryptionUtil_Compile.__default.ReservedPrefix()).isPrefixOf(_3_k))) {
        Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal, dafny.DafnySequence<? extends Character>> _4_val;
        _4_val = __default.AttrToStructured(((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((item).get(_3_k))));
        if ((_4_val).is_Failure()) {
          Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _5_result;
          _5_result = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E((_4_val).dtor_error()));
          ret = _5_result;
          return ret;
        }
        (_1_m).Put(_3_k, (_4_val).dtor_value());
      }
    }
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _6_result;
    _6_result = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), (_1_m).content());
    ret = _6_result;
    return ret;
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> StructuredToItemEncrypt(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal> s, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> orig, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> actions)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> ret = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty());
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _0_attrNames;
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _out0;
    _out0 = SortedSets.__default.<dafny.DafnySequence<? extends Character>>SetToSequence(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), (orig).keySet());
    _0_attrNames = _out0;
    DafnyLibraries.MutableMap<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _1_m;
    DafnyLibraries.MutableMap<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _nw0 = new DafnyLibraries.MutableMap<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), false);
    _1_m = _nw0;
    long _hi0 = (long) (_0_attrNames).cardinalityInt();
    for (long _2_i = (long) 0L; java.lang.Long.compareUnsigned(_2_i, _hi0) < 0; _2_i++) {
      dafny.DafnySequence<? extends Character> _3_k;
      _3_k = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)((_0_attrNames).select(dafny.Helpers.unsignedToInt(_2_i))));
      if (!((DynamoDbEncryptionUtil_Compile.__default.ReservedPrefix()).isPrefixOf(_3_k))) {
        if ((((s).<dafny.DafnySequence<? extends Character>>contains(_3_k)) && ((actions).<dafny.DafnySequence<? extends Character>>contains(_3_k))) && (java.util.Objects.equals(((software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction)(java.lang.Object)((actions).get(_3_k))), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN()))) {
          Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>> _4_val;
          _4_val = __default.StructuredToAttr(((software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal)(java.lang.Object)((s).get(_3_k))));
          if ((_4_val).is_Failure()) {
            Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _5_result;
            _5_result = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E((_4_val).dtor_error()));
            ret = _5_result;
            return ret;
          }
          (_1_m).Put(_3_k, (_4_val).dtor_value());
        } else {
          (_1_m).Put(_3_k, ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((orig).get(_3_k))));
        }
      }
    }
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _out1;
    _out1 = SortedSets.__default.<dafny.DafnySequence<? extends Character>>SetToSequence(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), (s).keySet());
    _0_attrNames = _out1;
    long _hi1 = (long) (_0_attrNames).cardinalityInt();
    for (long _6_i = (long) 0L; java.lang.Long.compareUnsigned(_6_i, _hi1) < 0; _6_i++) {
      dafny.DafnySequence<? extends Character> _7_k;
      _7_k = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)((_0_attrNames).select(dafny.Helpers.unsignedToInt(_6_i))));
      if (!(orig).<dafny.DafnySequence<? extends Character>>contains(_7_k)) {
        Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>> _8_val;
        _8_val = __default.StructuredToAttr(((software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal)(java.lang.Object)((s).get(_7_k))));
        if ((_8_val).is_Failure()) {
          Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _9_result;
          _9_result = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E((_8_val).dtor_error()));
          ret = _9_result;
          return ret;
        }
        (_1_m).Put(_7_k, (_8_val).dtor_value());
      }
    }
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _10_result;
    _10_result = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), (_1_m).content());
    ret = _10_result;
    return ret;
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> StructuredToItemDecrypt(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal> s, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> orig, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> actions)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> ret = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty());
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _0_attrNames;
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _out0;
    _out0 = SortedSets.__default.<dafny.DafnySequence<? extends Character>>SetToSequence(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), (orig).keySet());
    _0_attrNames = _out0;
    DafnyLibraries.MutableMap<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _1_m;
    DafnyLibraries.MutableMap<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _nw0 = new DafnyLibraries.MutableMap<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), false);
    _1_m = _nw0;
    long _hi0 = (long) (_0_attrNames).cardinalityInt();
    for (long _2_i = (long) 0L; java.lang.Long.compareUnsigned(_2_i, _hi0) < 0; _2_i++) {
      dafny.DafnySequence<? extends Character> _3_k;
      _3_k = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)((_0_attrNames).select(dafny.Helpers.unsignedToInt(_2_i))));
      if (!((DynamoDbEncryptionUtil_Compile.__default.ReservedPrefix()).isPrefixOf(_3_k))) {
        if ((((s).<dafny.DafnySequence<? extends Character>>contains(_3_k)) && ((actions).<dafny.DafnySequence<? extends Character>>contains(_3_k))) && (java.util.Objects.equals(((software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction)(java.lang.Object)((actions).get(_3_k))), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN()))) {
          Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>> _4_val;
          _4_val = __default.StructuredToAttr(((software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal)(java.lang.Object)((s).get(_3_k))));
          if ((_4_val).is_Failure()) {
            Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _5_result;
            _5_result = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E((_4_val).dtor_error()));
            ret = _5_result;
            return ret;
          }
          (_1_m).Put(_3_k, (_4_val).dtor_value());
        } else {
          (_1_m).Put(_3_k, ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((orig).get(_3_k))));
        }
      }
    }
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _6_result;
    _6_result = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), (_1_m).content());
    ret = _6_result;
    return ret;
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> ItemToStructured(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item) {
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal, dafny.DafnySequence<? extends Character>>> _0_structuredMap = ((java.util.function.Function<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal, dafny.DafnySequence<? extends Character>>>>)(_1_item) -> ((dafny.Function0<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal, dafny.DafnySequence<? extends Character>>>>)(() -> {
      java.util.HashMap<dafny.DafnySequence<? extends Character>, Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal, dafny.DafnySequence<? extends Character>>> _coll0 = new java.util.HashMap<>();
      for (dafny.DafnySequence<? extends Character> _compr_0_boxed0 : (_1_item).keySet().Elements()) {
        dafny.DafnySequence<? extends Character> _compr_0 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_compr_0_boxed0));
        dafny.DafnySequence<? extends Character> _2_k = (dafny.DafnySequence<? extends Character>)_compr_0;
        if (software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._Is(_2_k)) {
          if ((_1_item).<dafny.DafnySequence<? extends Character>>contains(_2_k)) {
            _coll0.put(_2_k,__default.AttrToStructured(((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_1_item).get(_2_k)))));
          }
        }
      }
      return new dafny.DafnyMap<dafny.DafnySequence<? extends Character>,Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal, dafny.DafnySequence<? extends Character>>>(_coll0);
    })).apply()).apply(item);
    return __default.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal>>MapError(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal._typeDescriptor()), __default.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal>SimplifyMapValue(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal._typeDescriptor(), _0_structuredMap));
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> StructuredToItem(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal> s) {
    if (((java.util.function.Function<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal>, Boolean>)(_0_s) -> dafny.Helpers.Quantifier((_0_s).keySet().Elements(), true, ((_forall_var_0_boxed0) -> {
      dafny.DafnySequence<? extends Character> _forall_var_0 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_forall_var_0_boxed0));
      dafny.DafnySequence<? extends Character> _1_k = (dafny.DafnySequence<? extends Character>)_forall_var_0;
      return !((_0_s).<dafny.DafnySequence<? extends Character>>contains(_1_k)) || (software.amazon.cryptography.services.dynamodb.internaldafny.types.__default.IsValid__AttributeName(_1_k));
    }))).apply(s)) {
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>>> _2_structuredData = ((java.util.function.Function<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal>, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>>>>)(_3_s) -> ((dafny.Function0<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>>>>)(() -> {
        java.util.HashMap<dafny.DafnySequence<? extends Character>, Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>>> _coll0 = new java.util.HashMap<>();
        for (dafny.DafnySequence<? extends Character> _compr_0_boxed0 : (_3_s).keySet().Elements()) {
          dafny.DafnySequence<? extends Character> _compr_0 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_compr_0_boxed0));
          dafny.DafnySequence<? extends Character> _4_k = (dafny.DafnySequence<? extends Character>)_compr_0;
          if (software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._Is(_4_k)) {
            if ((_3_s).<dafny.DafnySequence<? extends Character>>contains(_4_k)) {
              _coll0.put(_4_k,__default.StructuredToAttr(((software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal)(java.lang.Object)((_3_s).get(_4_k)))));
            }
          }
        }
        return new dafny.DafnyMap<dafny.DafnySequence<? extends Character>,Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>>>(_coll0);
      })).apply()).apply(s);
      return __default.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>MapError(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), __default.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>SimplifyMapValue(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), _2_structuredData));
    } else {
      dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> _5_badNames = ((java.util.function.Function<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal>, dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>>>)(_6_s) -> ((dafny.Function0<dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>>>)(() -> {
        java.util.ArrayList<dafny.DafnySequence<? extends Character>> _coll1 = new java.util.ArrayList<>();
        for (dafny.DafnySequence<? extends Character> _compr_1_boxed0 : (_6_s).keySet().Elements()) {
          dafny.DafnySequence<? extends Character> _compr_1 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_compr_1_boxed0));
          dafny.DafnySequence<? extends Character> _7_k = (dafny.DafnySequence<? extends Character>)_compr_1;
          if (((_6_s).<dafny.DafnySequence<? extends Character>>contains(_7_k)) && (!(software.amazon.cryptography.services.dynamodb.internaldafny.types.__default.IsValid__AttributeName(_7_k)))) {
            _coll1.add(_7_k);
          }
        }
        return new dafny.DafnySet<dafny.DafnySequence<? extends Character>>(_coll1);
      })).apply()).apply(s);
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _8_orderedAttrNames = SortedSets.__default.<Character>SetToOrderedSequence2(dafny.TypeDescriptor.CHAR, _5_badNames, __default::CharLess);
      dafny.DafnySequence<? extends Character> _9_attrNameList = StandardLibrary_Compile.__default.<Character>Join(dafny.TypeDescriptor.CHAR, _8_orderedAttrNames, dafny.DafnySequence.asString(","));
      return __default.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>MakeError(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Not valid attribute names : "), _9_attrNameList));
    }
  }
  public static Wrappers_Compile.Result<java.lang.Integer, dafny.DafnySequence<? extends Character>> BigEndianPosToU32(dafny.DafnySequence<? extends java.lang.Byte> x, long pos)
  {
    if (java.lang.Long.compareUnsigned((long) (x).cardinalityInt(), StandardLibrary_mMemoryMath_Compile.__default.Add(pos, __default.LENGTH__LEN64())) < 0) {
      return Wrappers_Compile.Result.<java.lang.Integer, dafny.DafnySequence<? extends Character>>create_Failure(BoundedInts_Compile.uint32._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("Length of 4-byte integer was less than 4"));
    } else {
      return Wrappers_Compile.Result.<java.lang.Integer, dafny.DafnySequence<? extends Character>>create_Success(BoundedInts_Compile.uint32._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), StandardLibrary_mUInt_Compile.__default.SeqPosToUInt32(x, pos));
    }
  }
  public static Wrappers_Compile.Result<java.lang.Long, dafny.DafnySequence<? extends Character>> BigEndianPosToU32As64(dafny.DafnySequence<? extends java.lang.Byte> x, long pos)
  {
    if (java.lang.Long.compareUnsigned((long) (x).cardinalityInt(), StandardLibrary_mMemoryMath_Compile.__default.Add(pos, __default.LENGTH__LEN64())) < 0) {
      return Wrappers_Compile.Result.<java.lang.Long, dafny.DafnySequence<? extends Character>>create_Failure(BoundedInts_Compile.uint64._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("Length of 4-byte integer was less than 4"));
    } else {
      return Wrappers_Compile.Result.<java.lang.Long, dafny.DafnySequence<? extends Character>>create_Success(BoundedInts_Compile.uint64._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (long) java.lang.Integer.toUnsignedLong(StandardLibrary_mUInt_Compile.__default.SeqPosToUInt32(x, pos)));
    }
  }
  public static <__T> Wrappers_Compile.Result<__T, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> MakeError(dafny.TypeDescriptor<__T> _td___T, dafny.DafnySequence<? extends Character> s)
  {
    return Wrappers_Compile.Result.<__T, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(_td___T, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error.create_DynamoDbEncryptionException(s));
  }
  public static <__T> Wrappers_Compile.Result<__T, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> MapError(dafny.TypeDescriptor<__T> _td___T, Wrappers_Compile.Result<__T, dafny.DafnySequence<? extends Character>> r)
  {
    if ((r).is_Success()) {
      return Wrappers_Compile.Result.<__T, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(_td___T, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), (r).dtor_value());
    } else {
      return __default.<__T>MakeError(_td___T, (r).dtor_error());
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> TopLevelAttributeToBytes(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue a) {
    return __default.AttrToBytes(a, false, (long) 1L);
  }
  public static Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal, dafny.DafnySequence<? extends Character>> AttrToStructured(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue item) {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _0_valueOrError0 = __default.TopLevelAttributeToBytes(item);
    if ((_0_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      return (_0_valueOrError0).<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal._typeDescriptor());
    } else {
      dafny.DafnySequence<? extends java.lang.Byte> _1_body = (_0_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
      return Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal, dafny.DafnySequence<? extends Character>>create_Success(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal.create(_1_body, __default.AttrToTypeId(item)));
    }
  }
  public static Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>> StructuredToAttr(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredDataTerminal s) {
    Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _0_valueOrError0 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((long) ((s).dtor_typeId()).cardinalityInt()) == (__default.TYPEID__LEN64()), dafny.DafnySequence.asString("Type ID must be two bytes"));
    if ((_0_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      return (_0_valueOrError0).<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor());
    } else {
      Wrappers_Compile.Result<AttrValueAndLength, dafny.DafnySequence<? extends Character>> _1_valueOrError1 = __default.BytesToAttr((s).dtor_value(), (s).dtor_typeId(), Wrappers_Compile.Option.<java.lang.Long>create_Some(BoundedInts_Compile.uint64._typeDescriptor(), (long) ((s).dtor_value()).cardinalityInt()), (long) 1L, (long) 0L);
      if ((_1_valueOrError1).IsFailure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_1_valueOrError1).<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>PropagateFailure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor());
      } else {
        AttrValueAndLength _2_attrValueAndLength = (_1_valueOrError1).Extract(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
        if (((_2_attrValueAndLength).dtor_len()) != ((long) ((s).dtor_value()).cardinalityInt())) {
          return Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>>create_Failure(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("Mismatch between length of encoded data and length of data"));
        } else {
          return Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, dafny.DafnySequence<? extends Character>>create_Success(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (_2_attrValueAndLength).dtor_val());
        }
      }
    }
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> AttrToTypeId(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue a) {
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _source0 = a;
    if (_source0.is_S()) {
      dafny.DafnySequence<? extends Character> _0___mcc_h0 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_S)_source0)._S;
      dafny.DafnySequence<? extends Character> _1_s = _0___mcc_h0;
      return StructuredEncryptionUtil_Compile.__default.STRING();
    } else if (_source0.is_N()) {
      dafny.DafnySequence<? extends Character> _2___mcc_h1 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_N)_source0)._N;
      dafny.DafnySequence<? extends Character> _3_n = _2___mcc_h1;
      return StructuredEncryptionUtil_Compile.__default.NUMBER();
    } else if (_source0.is_B()) {
      dafny.DafnySequence<? extends java.lang.Byte> _4___mcc_h2 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_B)_source0)._B;
      dafny.DafnySequence<? extends java.lang.Byte> _5_b = _4___mcc_h2;
      return StructuredEncryptionUtil_Compile.__default.BINARY();
    } else if (_source0.is_SS()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _6___mcc_h3 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_SS)_source0)._SS;
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _7_ss = _6___mcc_h3;
      return StructuredEncryptionUtil_Compile.__default.STRING__SET();
    } else if (_source0.is_NS()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _8___mcc_h4 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_NS)_source0)._NS;
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _9_ns = _8___mcc_h4;
      return StructuredEncryptionUtil_Compile.__default.NUMBER__SET();
    } else if (_source0.is_BS()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _10___mcc_h5 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_BS)_source0)._BS;
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _11_bs = _10___mcc_h5;
      return StructuredEncryptionUtil_Compile.__default.BINARY__SET();
    } else if (_source0.is_M()) {
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _12___mcc_h6 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_M)_source0)._M;
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _13_m = _12___mcc_h6;
      return StructuredEncryptionUtil_Compile.__default.MAP();
    } else if (_source0.is_L()) {
      dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _14___mcc_h7 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_L)_source0)._L;
      dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _15_l = _14___mcc_h7;
      return StructuredEncryptionUtil_Compile.__default.LIST();
    } else if (_source0.is_NULL()) {
      boolean _16___mcc_h8 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_NULL)_source0)._NULL;
      boolean _17_n = _16___mcc_h8;
      return StructuredEncryptionUtil_Compile.__default.NULL();
    } else {
      boolean _18___mcc_h9 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_BOOL)_source0)._BOOL;
      boolean _19_b = _18___mcc_h9;
      return StructuredEncryptionUtil_Compile.__default.BOOLEAN();
    }
  }
  public static boolean CharLess(char x, char y)
  {
    return (x) < (y);
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> AttrToBytes(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue a, boolean prefix, long depth)
  {
    software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _pat_let_tv0 = a;
    long _pat_let_tv1 = depth;
    long _pat_let_tv2 = depth;
    Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _0_valueOrError0 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), java.lang.Long.compareUnsigned(depth, DynamoDbEncryptionUtil_Compile.__default.MAX__STRUCTURE__DEPTH()) <= 0, dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Depth of attribute structure to serialize exceeds limit of "), DynamoDbEncryptionUtil_Compile.__default.MAX__STRUCTURE__DEPTH__STR()));
    if ((_0_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      return (_0_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
    } else {
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _1_valueOrError1 = ((java.util.function.Function<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue, Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>>)(_source0_boxed0) -> {
        software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _source0 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)(_source0_boxed0));
        if (_source0.is_S()) {
          dafny.DafnySequence<? extends Character> _2___mcc_h0 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_S)_source0)._S;
          dafny.DafnySequence<? extends Character> _3_s = _2___mcc_h0;
          return UTF8.__default.Encode(_3_s);
        } else if (_source0.is_N()) {
          dafny.DafnySequence<? extends Character> _4___mcc_h1 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_N)_source0)._N;
          dafny.DafnySequence<? extends Character> _5_n = _4___mcc_h1;
          Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _6_valueOrError2 = DynamoDbNormalizeNumber_Compile.__default.NormalizeNumber(_5_n);
          if ((_6_valueOrError2).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
            return (_6_valueOrError2).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
          } else {
            dafny.DafnySequence<? extends Character> _7_nn = (_6_valueOrError2).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
            return UTF8.__default.Encode(_7_nn);
          }
        } else if (_source0.is_B()) {
          dafny.DafnySequence<? extends java.lang.Byte> _8___mcc_h2 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_B)_source0)._B;
          dafny.DafnySequence<? extends java.lang.Byte> _9_b = _8___mcc_h2;
          return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _9_b);
        } else if (_source0.is_SS()) {
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _10___mcc_h3 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_SS)_source0)._SS;
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _11_ss = _10___mcc_h3;
          return __default.StringSetAttrToBytes(_11_ss);
        } else if (_source0.is_NS()) {
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _12___mcc_h4 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_NS)_source0)._NS;
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _13_ns = _12___mcc_h4;
          return __default.NumberSetAttrToBytes(_13_ns);
        } else if (_source0.is_BS()) {
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _14___mcc_h5 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_BS)_source0)._BS;
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _15_bs = _14___mcc_h5;
          return __default.BinarySetAttrToBytes(_15_bs);
        } else if (_source0.is_M()) {
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _16___mcc_h6 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_M)_source0)._M;
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _17_m = _16___mcc_h6;
          return __default.MapAttrToBytes(_pat_let_tv0, _17_m, _pat_let_tv1);
        } else if (_source0.is_L()) {
          dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _18___mcc_h7 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_L)_source0)._L;
          dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _19_l = _18___mcc_h7;
          return __default.ListAttrToBytes(_19_l, _pat_let_tv2);
        } else if (_source0.is_NULL()) {
          boolean _20___mcc_h8 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_NULL)_source0)._NULL;
          boolean _21_n = _20___mcc_h8;
          return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
        } else {
          boolean _22___mcc_h9 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue_BOOL)_source0)._BOOL;
          boolean _23_b = _22___mcc_h9;
          return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte> of(__default.BoolToUint8(_23_b)));
        }
      }).apply(a);
      if ((_1_valueOrError1).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_1_valueOrError1).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
      } else {
        dafny.DafnySequence<? extends java.lang.Byte> _24_baseBytes = (_1_valueOrError1).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
        if (prefix) {
          Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _25_valueOrError3 = __default.U32ToBigEndian64((long) (_24_baseBytes).cardinalityInt());
          if ((_25_valueOrError3).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
            return (_25_valueOrError3).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
          } else {
            dafny.DafnySequence<? extends java.lang.Byte> _26_len = (_25_valueOrError3).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
            return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(__default.AttrToTypeId(a), _26_len), _24_baseBytes));
          }
        } else {
          return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _24_baseBytes);
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> StringSetAttrToBytes(dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> ss) {
    dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> _0_asSet = Seq_Compile.__default.<dafny.DafnySequence<? extends Character>>ToSet(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ss);
    Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _1_valueOrError0 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((long) (_0_asSet).cardinalityInt()) == ((long) (ss).cardinalityInt()), dafny.DafnySequence.asString("String Set had duplicate values"));
    if ((_1_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      return (_1_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
    } else {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _2_sortedList = SortedSets.__default.<Character>SetToOrderedSequence2(dafny.TypeDescriptor.CHAR, _0_asSet, __default::CharLess);
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _3_valueOrError1 = __default.U32ToBigEndian64((long) (_2_sortedList).cardinalityInt());
      if ((_3_valueOrError1).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_3_valueOrError1).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
      } else {
        dafny.DafnySequence<? extends java.lang.Byte> _4_count = (_3_valueOrError1).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _5_valueOrError2 = __default.CollectString(_2_sortedList, (long) 0L, dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
        if ((_5_valueOrError2).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_5_valueOrError2).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
        } else {
          dafny.DafnySequence<? extends java.lang.Byte> _6_body = (_5_valueOrError2).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
          return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>concatenate(_4_count, _6_body));
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> NumberSetAttrToBytes(dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> ns) {
    dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> _0_asSet = Seq_Compile.__default.<dafny.DafnySequence<? extends Character>>ToSet(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ns);
    Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _1_valueOrError0 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((long) (_0_asSet).cardinalityInt()) == ((long) (ns).cardinalityInt()), dafny.DafnySequence.asString("Number Set had duplicate values"));
    if ((_1_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      return (_1_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
    } else {
      Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, dafny.DafnySequence<? extends Character>> _2_valueOrError1 = StandardLibrary_mSequence_Compile.__default.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>MapWithResult(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>>)(_3_n_boxed0) -> {
        dafny.DafnySequence<? extends Character> _3_n = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_3_n_boxed0));
        return DynamoDbNormalizeNumber_Compile.__default.NormalizeNumber(_3_n);
      }), ns, (long) 0L, dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> empty(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
      if ((_2_valueOrError1).IsFailure(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_2_valueOrError1).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
      } else {
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _4_normList = (_2_valueOrError1).Extract(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
        dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> _5_asSet = Seq_Compile.__default.<dafny.DafnySequence<? extends Character>>ToSet(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _4_normList);
        Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _6_valueOrError2 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((long) (_5_asSet).cardinalityInt()) == ((long) (_4_normList).cardinalityInt()), dafny.DafnySequence.asString("Number Set had duplicate values after normalization."));
        if ((_6_valueOrError2).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_6_valueOrError2).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
        } else {
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _7_sortedList = SortedSets.__default.<Character>SetToOrderedSequence2(dafny.TypeDescriptor.CHAR, _5_asSet, __default::CharLess);
          Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _8_valueOrError3 = __default.U32ToBigEndian64((long) (_7_sortedList).cardinalityInt());
          if ((_8_valueOrError3).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
            return (_8_valueOrError3).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
          } else {
            dafny.DafnySequence<? extends java.lang.Byte> _9_count = (_8_valueOrError3).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
            Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _10_valueOrError4 = __default.CollectString(_7_sortedList, (long) 0L, dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
            if ((_10_valueOrError4).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
              return (_10_valueOrError4).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
            } else {
              dafny.DafnySequence<? extends java.lang.Byte> _11_body = (_10_valueOrError4).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
              return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>concatenate(_9_count, _11_body));
            }
          }
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> BinarySetAttrToBytes(dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> bs) {
    dafny.DafnySet<? extends dafny.DafnySequence<? extends java.lang.Byte>> _0_asSet = Seq_Compile.__default.<dafny.DafnySequence<? extends java.lang.Byte>>ToSet(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), bs);
    Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _1_valueOrError0 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((long) (_0_asSet).cardinalityInt()) == ((long) (bs).cardinalityInt()), dafny.DafnySequence.asString("Binary Set had duplicate values"));
    if ((_1_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      return (_1_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
    } else {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _2_sortedList = SortedSets.__default.<java.lang.Byte>SetToOrderedSequence2(BoundedInts_Compile.uint8._typeDescriptor(), _0_asSet, DynamoDbEncryptionUtil_Compile.__default::ByteLess);
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _3_valueOrError1 = __default.U32ToBigEndian64((long) (_2_sortedList).cardinalityInt());
      if ((_3_valueOrError1).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_3_valueOrError1).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
      } else {
        dafny.DafnySequence<? extends java.lang.Byte> _4_count = (_3_valueOrError1).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _5_valueOrError2 = __default.CollectBinary(_2_sortedList, (long) 0L, dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
        if ((_5_valueOrError2).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_5_valueOrError2).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
        } else {
          dafny.DafnySequence<? extends java.lang.Byte> _6_body = (_5_valueOrError2).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
          return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>concatenate(_4_count, _6_body));
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> MapAttrToBytes(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue parent, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> m, long depth)
  {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> ret = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>Default(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _0_attrNames;
    _0_attrNames = SortedSets.__default.<Character>SetToOrderedSequence2(dafny.TypeDescriptor.CHAR, (m).keySet(), __default::CharLess);
    long _1_len;
    _1_len = (long) (_0_attrNames).cardinalityInt();
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _2_valueOrError0 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>Default(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
    _2_valueOrError0 = __default.U32ToBigEndian64(_1_len);
    if ((_2_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      ret = (_2_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
      return ret;
    }
    dafny.DafnySequence<? extends java.lang.Byte> _3_output;
    _3_output = (_2_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
    long _hi0 = _1_len;
    for (long _4_i = (long) 0L; java.lang.Long.compareUnsigned(_4_i, _hi0) < 0; _4_i++) {
      dafny.DafnySequence<? extends Character> _5_k;
      _5_k = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)((_0_attrNames).select(dafny.Helpers.unsignedToInt(_4_i))));
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _6_val;
      _6_val = __default.AttrToBytes(((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((m).get(_5_k))), true, (long) (long) ((depth) + ((long) 1L)));
      if ((_6_val).is_Failure()) {
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _7_result;
        _7_result = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (_6_val).dtor_error());
        ret = _7_result;
        return ret;
      }
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _8_data;
      _8_data = __default.SerializeMapItem(_5_k, (_6_val).dtor_value());
      if ((_8_data).is_Failure()) {
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _9_result;
        _9_result = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (_8_data).dtor_error());
        ret = _9_result;
        return ret;
      }
      _3_output = dafny.DafnySequence.<java.lang.Byte>concatenate(_3_output, (_8_data).dtor_value());
    }
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _10_result;
    _10_result = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _3_output);
    ret = _10_result;
    return ret;
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> ListAttrToBytes(dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> l, long depth)
  {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _0_valueOrError0 = __default.U32ToBigEndian64((long) (l).cardinalityInt());
    if ((_0_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      return (_0_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
    } else {
      dafny.DafnySequence<? extends java.lang.Byte> _1_count = (_0_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _2_valueOrError1 = __default.CollectList(l, depth, dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
      if ((_2_valueOrError1).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_2_valueOrError1).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
      } else {
        dafny.DafnySequence<? extends java.lang.Byte> _3_body = (_2_valueOrError1).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>concatenate(_1_count, _3_body));
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> U32ToBigEndian64(long x) {
    if (java.lang.Long.compareUnsigned(x, (long) 4294967295L) > 0) {
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("Length was too big"));
    } else {
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), StandardLibrary_mUInt_Compile.__default.UInt32ToSeq(((int) (x))));
    }
  }
  public static Wrappers_Compile.Result<java.lang.Integer, dafny.DafnySequence<? extends Character>> BigEndianToU32As32(dafny.DafnySequence<? extends java.lang.Byte> x) {
    if (java.lang.Long.compareUnsigned((long) (x).cardinalityInt(), __default.LENGTH__LEN64()) < 0) {
      return Wrappers_Compile.Result.<java.lang.Integer, dafny.DafnySequence<? extends Character>>create_Failure(BoundedInts_Compile.uint32._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("Length of 4-byte integer was less than 4"));
    } else {
      return Wrappers_Compile.Result.<java.lang.Integer, dafny.DafnySequence<? extends Character>>create_Success(BoundedInts_Compile.uint32._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), StandardLibrary_mUInt_Compile.__default.SeqToUInt32((x).take(__default.LENGTH__LEN64())));
    }
  }
  public static Wrappers_Compile.Result<java.lang.Long, dafny.DafnySequence<? extends Character>> BigEndianToU32As64(dafny.DafnySequence<? extends java.lang.Byte> x) {
    if (java.lang.Long.compareUnsigned((long) (x).cardinalityInt(), __default.LENGTH__LEN64()) < 0) {
      return Wrappers_Compile.Result.<java.lang.Long, dafny.DafnySequence<? extends Character>>create_Failure(BoundedInts_Compile.uint64._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("Length of 4-byte integer was less than 4"));
    } else {
      return Wrappers_Compile.Result.<java.lang.Long, dafny.DafnySequence<? extends Character>>create_Success(BoundedInts_Compile.uint64._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (long) java.lang.Integer.toUnsignedLong(StandardLibrary_mUInt_Compile.__default.SeqToUInt32((x).take(__default.LENGTH__LEN64()))));
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> EncodeString(dafny.DafnySequence<? extends Character> s) {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _0_valueOrError0 = UTF8.__default.Encode(s);
    if ((_0_valueOrError0).IsFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      return (_0_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
    } else {
      dafny.DafnySequence<? extends java.lang.Byte> _1_val = (_0_valueOrError0).Extract(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _2_valueOrError1 = __default.U32ToBigEndian64((long) (_1_val).cardinalityInt());
      if ((_2_valueOrError1).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_2_valueOrError1).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
      } else {
        dafny.DafnySequence<? extends java.lang.Byte> _3_len = (_2_valueOrError1).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>concatenate(_3_len, _1_val));
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> CollectString(dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> setToSerialize, long pos, dafny.DafnySequence<? extends java.lang.Byte> serialized)
  {
    TAIL_CALL_START: while (true) {
      if (((long) (setToSerialize).cardinalityInt()) == (pos)) {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), serialized);
      } else {
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _0_valueOrError0 = __default.EncodeString(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((setToSerialize).select(dafny.Helpers.unsignedToInt(pos)))));
        if ((_0_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_0_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
        } else {
          dafny.DafnySequence<? extends java.lang.Byte> _1_entry = (_0_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in0 = setToSerialize;
          long _in1 = (long) (long) ((pos) + ((long) 1L));
          dafny.DafnySequence<? extends java.lang.Byte> _in2 = dafny.DafnySequence.<java.lang.Byte>concatenate(serialized, _1_entry);
          setToSerialize = _in0;
          pos = _in1;
          serialized = _in2;
          continue TAIL_CALL_START;
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> SerializeBinaryValue(dafny.DafnySequence<? extends java.lang.Byte> b) {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _0_valueOrError0 = __default.U32ToBigEndian64((long) (b).cardinalityInt());
    if ((_0_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      return (_0_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
    } else {
      dafny.DafnySequence<? extends java.lang.Byte> _1_len = (_0_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>concatenate(_1_len, b));
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> CollectBinary(dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> setToSerialize, long pos, dafny.DafnySequence<? extends java.lang.Byte> serialized)
  {
    TAIL_CALL_START: while (true) {
      if (((long) (setToSerialize).cardinalityInt()) == (pos)) {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), serialized);
      } else {
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _0_valueOrError0 = __default.SerializeBinaryValue(((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((setToSerialize).select(dafny.Helpers.unsignedToInt(pos)))));
        if ((_0_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_0_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
        } else {
          dafny.DafnySequence<? extends java.lang.Byte> _1_item = (_0_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _in0 = setToSerialize;
          long _in1 = (long) (long) ((pos) + ((long) 1L));
          dafny.DafnySequence<? extends java.lang.Byte> _in2 = dafny.DafnySequence.<java.lang.Byte>concatenate(serialized, _1_item);
          setToSerialize = _in0;
          pos = _in1;
          serialized = _in2;
          continue TAIL_CALL_START;
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> CollectList(dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> listToSerialize, long depth, dafny.DafnySequence<? extends java.lang.Byte> serialized)
  {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> ret = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>Default(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
    if(true) {
      dafny.DafnySequence<? extends java.lang.Byte> _0_result;
      _0_result = serialized;
      long _hi0 = (long) (listToSerialize).cardinalityInt();
      for (long _1_i = (long) 0L; java.lang.Long.compareUnsigned(_1_i, _hi0) < 0; _1_i++) {
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _2_val;
        _2_val = __default.AttrToBytes(((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((listToSerialize).select(dafny.Helpers.unsignedToInt(_1_i)))), true, (long) (long) ((depth) + ((long) 1L)));
        if ((_2_val).is_Failure()) {
          ret = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (_2_val).dtor_error());
          return ret;
        }
        _0_result = dafny.DafnySequence.<java.lang.Byte>concatenate(_0_result, (_2_val).dtor_value());
      }
      ret = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _0_result);
    }
    return ret;
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> SerializeMapItem(dafny.DafnySequence<? extends Character> key, dafny.DafnySequence<? extends java.lang.Byte> value)
  {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _0_valueOrError0 = UTF8.__default.Encode(key);
    if ((_0_valueOrError0).IsFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      return (_0_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
    } else {
      dafny.DafnySequence<? extends java.lang.Byte> _1_name = (_0_valueOrError0).Extract(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _2_valueOrError1 = __default.U32ToBigEndian64((long) (_1_name).cardinalityInt());
      if ((_2_valueOrError1).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_2_valueOrError1).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
      } else {
        dafny.DafnySequence<? extends java.lang.Byte> _3_len = (_2_valueOrError1).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
        dafny.DafnySequence<? extends java.lang.Byte> _4_serialized = dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(StructuredEncryptionUtil_Compile.__default.STRING(), _3_len), _1_name), value);
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _4_serialized);
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> CollectMap(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> mapToSerialize, dafny.DafnySequence<? extends java.lang.Byte> serialized)
  {
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _0_keys = SortedSets.__default.<Character>SetToOrderedSequence2(dafny.TypeDescriptor.CHAR, (mapToSerialize).keySet(), __default::CharLess);
    return __default.CollectOrderedMapSubset(_0_keys, mapToSerialize, (long) 0L, serialized);
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> CollectOrderedMapSubset(dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> keys, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> mapToSerialize, long pos, dafny.DafnySequence<? extends java.lang.Byte> serialized)
  {
    TAIL_CALL_START: while (true) {
      if (((long) (keys).cardinalityInt()) == (pos)) {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), serialized);
      } else {
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _0_valueOrError0 = __default.SerializeMapItem(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((keys).select(dafny.Helpers.unsignedToInt(pos)))), ((dafny.DafnySequence<? extends java.lang.Byte>)(java.lang.Object)((mapToSerialize).get(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((keys).select(dafny.Helpers.unsignedToInt(pos))))))));
        if ((_0_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_0_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()));
        } else {
          dafny.DafnySequence<? extends java.lang.Byte> _1_data = (_0_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in0 = keys;
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _in1 = mapToSerialize;
          long _in2 = (long) (long) ((pos) + ((long) 1L));
          dafny.DafnySequence<? extends java.lang.Byte> _in3 = dafny.DafnySequence.<java.lang.Byte>concatenate(serialized, _1_data);
          keys = _in0;
          mapToSerialize = _in1;
          pos = _in2;
          serialized = _in3;
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
    dafny.DafnySet<? extends __T> _0_asSet = Seq_Compile.__default.<__T>ToSet(_td___T, s);
    if (((long) (_0_asSet).cardinalityInt()) == ((long) (s).cardinalityInt())) {
      return true;
    } else {
      return false;
    }
  }
  public static Wrappers_Compile.Result<AttrValueAndLength, dafny.DafnySequence<? extends Character>> DeserializeBinarySet(dafny.DafnySequence<? extends java.lang.Byte> serialized, long remainingCount, long origSerializedSize, AttrValueAndLength resultSet)
  {
    TAIL_CALL_START: while (true) {
      if (((remainingCount) == 0 ? 0 : 1) == 0) {
        Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _0_valueOrError0 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), __default.<dafny.DafnySequence<? extends java.lang.Byte>>IsUnique(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), ((resultSet).dtor_val()).dtor_BS()), dafny.DafnySequence.asString("Binary set values must not have duplicates"));
        if ((_0_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_0_valueOrError0).<AttrValueAndLength>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
        } else {
          return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Success(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), resultSet);
        }
      } else if (java.lang.Long.compareUnsigned((long) (serialized).cardinalityInt(), __default.LENGTH__LEN64()) < 0) {
        return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Failure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("Out of bytes reading Binary Set"));
      } else {
        Wrappers_Compile.Result<java.lang.Long, dafny.DafnySequence<? extends Character>> _1_valueOrError1 = __default.BigEndianToU32As64(serialized);
        if ((_1_valueOrError1).IsFailure(BoundedInts_Compile.uint64._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_1_valueOrError1).<AttrValueAndLength>PropagateFailure(BoundedInts_Compile.uint64._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
        } else {
          long _2_len = (_1_valueOrError1).Extract(BoundedInts_Compile.uint64._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
          dafny.DafnySequence<? extends java.lang.Byte> _3_serialized = (serialized).drop(__default.LENGTH__LEN64());
          if (java.lang.Long.compareUnsigned((long) (_3_serialized).cardinalityInt(), _2_len) < 0) {
            return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Failure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("Binary Set Structured Data has too few bytes"));
          } else {
            software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _4_nattr = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_BS(dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>>concatenate(((resultSet).dtor_val()).dtor_BS(), dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>> of(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), (_3_serialized).take(_2_len))));
            dafny.DafnySequence<? extends java.lang.Byte> _in0 = (_3_serialized).drop(_2_len);
            long _in1 = (long) (long) ((remainingCount) - ((long) 1L));
            long _in2 = origSerializedSize;
            AttrValueAndLength _in3 = AttrValueAndLength.create(_4_nattr, (long) (long) (((long) (long) (((resultSet).dtor_len()) + (_2_len))) + (__default.LENGTH__LEN64())));
            serialized = _in0;
            remainingCount = _in1;
            origSerializedSize = _in2;
            resultSet = _in3;
            continue TAIL_CALL_START;
          }
        }
      }
    }
  }
  public static Wrappers_Compile.Result<AttrValueAndLength, dafny.DafnySequence<? extends Character>> DeserializeStringSet(dafny.DafnySequence<? extends java.lang.Byte> serialized, long remainingCount, long origSerializedSize, AttrValueAndLength resultSet)
  {
    TAIL_CALL_START: while (true) {
      if (((remainingCount) == 0 ? 0 : 1) == 0) {
        Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _0_valueOrError0 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), __default.<dafny.DafnySequence<? extends Character>>IsUnique(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((resultSet).dtor_val()).dtor_SS()), dafny.DafnySequence.asString("String set values must not have duplicates"));
        if ((_0_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_0_valueOrError0).<AttrValueAndLength>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
        } else {
          return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Success(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), resultSet);
        }
      } else if (java.lang.Long.compareUnsigned((long) (serialized).cardinalityInt(), __default.LENGTH__LEN64()) < 0) {
        return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Failure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("Out of bytes reading String Set"));
      } else {
        Wrappers_Compile.Result<java.lang.Long, dafny.DafnySequence<? extends Character>> _1_valueOrError1 = __default.BigEndianToU32As64(serialized);
        if ((_1_valueOrError1).IsFailure(BoundedInts_Compile.uint64._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_1_valueOrError1).<AttrValueAndLength>PropagateFailure(BoundedInts_Compile.uint64._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
        } else {
          long _2_len = (_1_valueOrError1).Extract(BoundedInts_Compile.uint64._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
          dafny.DafnySequence<? extends java.lang.Byte> _3_serialized = (serialized).drop(__default.LENGTH__LEN64());
          if (java.lang.Long.compareUnsigned((long) (_3_serialized).cardinalityInt(), _2_len) < 0) {
            return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Failure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("String Set Structured Data has too few bytes"));
          } else {
            Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _4_valueOrError2 = UTF8.__default.Decode((_3_serialized).take(_2_len));
            if ((_4_valueOrError2).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
              return (_4_valueOrError2).<AttrValueAndLength>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
            } else {
              dafny.DafnySequence<? extends Character> _5_nstring = (_4_valueOrError2).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
              software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _6_nattr = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_SS(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>concatenate(((resultSet).dtor_val()).dtor_SS(), dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _5_nstring)));
              dafny.DafnySequence<? extends java.lang.Byte> _in0 = (_3_serialized).drop(_2_len);
              long _in1 = (long) (long) ((remainingCount) - ((long) 1L));
              long _in2 = origSerializedSize;
              AttrValueAndLength _in3 = AttrValueAndLength.create(_6_nattr, (long) (long) (((long) (long) (((resultSet).dtor_len()) + (_2_len))) + (__default.LENGTH__LEN64())));
              serialized = _in0;
              remainingCount = _in1;
              origSerializedSize = _in2;
              resultSet = _in3;
              continue TAIL_CALL_START;
            }
          }
        }
      }
    }
  }
  public static Wrappers_Compile.Result<AttrValueAndLength, dafny.DafnySequence<? extends Character>> DeserializeNumberSet(dafny.DafnySequence<? extends java.lang.Byte> serialized, long remainingCount, long origSerializedSize, AttrValueAndLength resultSet)
  {
    TAIL_CALL_START: while (true) {
      if (((remainingCount) == 0 ? 0 : 1) == 0) {
        Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _0_valueOrError0 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), __default.<dafny.DafnySequence<? extends Character>>IsUnique(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((resultSet).dtor_val()).dtor_NS()), dafny.DafnySequence.asString("Number set values must not have duplicates"));
        if ((_0_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_0_valueOrError0).<AttrValueAndLength>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
        } else {
          return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Success(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), resultSet);
        }
      } else if (java.lang.Long.compareUnsigned((long) (serialized).cardinalityInt(), __default.LENGTH__LEN64()) < 0) {
        return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Failure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("Out of bytes reading String Set"));
      } else {
        Wrappers_Compile.Result<java.lang.Long, dafny.DafnySequence<? extends Character>> _1_valueOrError1 = __default.BigEndianToU32As64(serialized);
        if ((_1_valueOrError1).IsFailure(BoundedInts_Compile.uint64._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_1_valueOrError1).<AttrValueAndLength>PropagateFailure(BoundedInts_Compile.uint64._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
        } else {
          long _2_len = (_1_valueOrError1).Extract(BoundedInts_Compile.uint64._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
          dafny.DafnySequence<? extends java.lang.Byte> _3_serialized = (serialized).drop(__default.LENGTH__LEN64());
          if (java.lang.Long.compareUnsigned((long) (_3_serialized).cardinalityInt(), _2_len) < 0) {
            return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Failure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("Number Set Structured Data has too few bytes"));
          } else {
            Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _4_valueOrError2 = UTF8.__default.Decode((_3_serialized).take(_2_len));
            if ((_4_valueOrError2).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
              return (_4_valueOrError2).<AttrValueAndLength>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
            } else {
              dafny.DafnySequence<? extends Character> _5_nstring = (_4_valueOrError2).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
              software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _6_nattr = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_NS(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>concatenate(((resultSet).dtor_val()).dtor_NS(), dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _5_nstring)));
              dafny.DafnySequence<? extends java.lang.Byte> _in0 = (_3_serialized).drop(_2_len);
              long _in1 = (long) (long) ((remainingCount) - ((long) 1L));
              long _in2 = origSerializedSize;
              AttrValueAndLength _in3 = AttrValueAndLength.create(_6_nattr, (long) (long) (((long) (long) (((resultSet).dtor_len()) + (_2_len))) + (__default.LENGTH__LEN64())));
              serialized = _in0;
              remainingCount = _in1;
              origSerializedSize = _in2;
              resultSet = _in3;
              continue TAIL_CALL_START;
            }
          }
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.Tuple2<AttrValueAndLength, java.lang.Long>, dafny.DafnySequence<? extends Character>> DeserializeListEntry(dafny.DafnySequence<? extends java.lang.Byte> serialized, long pos, long depth, AttrValueAndLength resultList)
  {
    long _0_serialized__size = (long) (serialized).cardinalityInt();
    if (java.lang.Long.compareUnsigned((long) (long) ((_0_serialized__size) - (pos)), __default.PREFIX__LEN64()) < 0) {
      return Wrappers_Compile.Result.<dafny.Tuple2<AttrValueAndLength, java.lang.Long>, dafny.DafnySequence<? extends Character>>create_Failure(dafny.Tuple2.<AttrValueAndLength, java.lang.Long>_typeDescriptor(AttrValueAndLength._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("Out of bytes reading Type of List element"));
    } else {
      dafny.DafnySequence<? extends java.lang.Byte> _1_TerminalTypeId = (serialized).subsequence(dafny.Helpers.unsignedToInt(pos), dafny.Helpers.unsignedToInt((long) (long) ((pos) + ((long) 2L))));
      Wrappers_Compile.Result<java.lang.Long, dafny.DafnySequence<? extends Character>> _2_valueOrError0 = __default.BigEndianPosToU32As64(serialized, (long) (long) ((pos) + ((long) 2L)));
      if ((_2_valueOrError0).IsFailure(BoundedInts_Compile.uint64._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_2_valueOrError0).<dafny.Tuple2<AttrValueAndLength, java.lang.Long>>PropagateFailure(BoundedInts_Compile.uint64._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.Tuple2.<AttrValueAndLength, java.lang.Long>_typeDescriptor(AttrValueAndLength._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()));
      } else {
        long _3_len = (_2_valueOrError0).Extract(BoundedInts_Compile.uint64._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
        long _4_new__pos = (long) (long) ((pos) + (__default.PREFIX__LEN64()));
        if (java.lang.Long.compareUnsigned((long) (long) ((_0_serialized__size) - (_4_new__pos)), _3_len) < 0) {
          return Wrappers_Compile.Result.<dafny.Tuple2<AttrValueAndLength, java.lang.Long>, dafny.DafnySequence<? extends Character>>create_Failure(dafny.Tuple2.<AttrValueAndLength, java.lang.Long>_typeDescriptor(AttrValueAndLength._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("Out of bytes reading Content of List element"));
        } else {
          Wrappers_Compile.Result<AttrValueAndLength, dafny.DafnySequence<? extends Character>> _5_valueOrError1 = __default.BytesToAttr(serialized, _1_TerminalTypeId, Wrappers_Compile.Option.<java.lang.Long>create_Some(BoundedInts_Compile.uint64._typeDescriptor(), _3_len), (long) (long) ((depth) + ((long) 1L)), _4_new__pos);
          if ((_5_valueOrError1).IsFailure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
            return (_5_valueOrError1).<dafny.Tuple2<AttrValueAndLength, java.lang.Long>>PropagateFailure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.Tuple2.<AttrValueAndLength, java.lang.Long>_typeDescriptor(AttrValueAndLength._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()));
          } else {
            AttrValueAndLength _6_nval = (_5_valueOrError1).Extract(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
            long _7_new__pos = StandardLibrary_mMemoryMath_Compile.__default.Add(_4_new__pos, (_6_nval).dtor_len());
            software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _8_nattr = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_L(dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>concatenate(((resultList).dtor_val()).dtor_L(), dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> of(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor(), (_6_nval).dtor_val())));
            AttrValueAndLength _9_nResultList = AttrValueAndLength.create(_8_nattr, StandardLibrary_mMemoryMath_Compile.__default.Add((resultList).dtor_len(), (long) (long) ((_7_new__pos) - (pos))));
            return Wrappers_Compile.Result.<dafny.Tuple2<AttrValueAndLength, java.lang.Long>, dafny.DafnySequence<? extends Character>>create_Success(dafny.Tuple2.<AttrValueAndLength, java.lang.Long>_typeDescriptor(AttrValueAndLength._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.Tuple2.<AttrValueAndLength, java.lang.Long>create(_9_nResultList, _7_new__pos));
          }
        }
      }
    }
  }
  public static Wrappers_Compile.Result<AttrValueAndLength, dafny.DafnySequence<? extends Character>> DeserializeList(dafny.DafnySequence<? extends java.lang.Byte> serialized, long pos, long remainingCount, long depth, AttrValueAndLength resultList)
  {
    Wrappers_Compile.Result<AttrValueAndLength, dafny.DafnySequence<? extends Character>> ret = Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>Default(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength.Default());
    if(true) {
      long _0_npos;
      _0_npos = pos;
      AttrValueAndLength _1_newResultList;
      _1_newResultList = resultList;
      long _hi0 = remainingCount;
      for (long _2_i = (long) 0L; java.lang.Long.compareUnsigned(_2_i, _hi0) < 0; _2_i++) {
        Wrappers_Compile.Result<dafny.Tuple2<AttrValueAndLength, java.lang.Long>, dafny.DafnySequence<? extends Character>> _3_test;
        _3_test = __default.DeserializeListEntry(serialized, _0_npos, depth, _1_newResultList);
        if ((_3_test).is_Failure()) {
          ret = Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Failure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (_3_test).dtor_error());
          return ret;
        }
        _1_newResultList = ((_3_test).dtor_value()).dtor__0();
        _0_npos = ((_3_test).dtor_value()).dtor__1();
      }
      ret = Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Success(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _1_newResultList);
    }
    return ret;
  }
  public static Wrappers_Compile.Result<dafny.Tuple2<AttrValueAndLength, java.lang.Long>, dafny.DafnySequence<? extends Character>> DeserializeMapEntry(dafny.DafnySequence<? extends java.lang.Byte> serialized, long pos, long depth, AttrValueAndLength resultMap)
  {
    long _0_serialized__size = (long) (serialized).cardinalityInt();
    long _1_orig__pos = pos;
    Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _2_valueOrError0 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), java.lang.Long.compareUnsigned(__default.PREFIX__LEN64(), (long) (long) ((_0_serialized__size) - (pos))) <= 0, dafny.DafnySequence.asString("Out of bytes reading Map Key"));
    if ((_2_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      return (_2_valueOrError0).<dafny.Tuple2<AttrValueAndLength, java.lang.Long>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.Tuple2.<AttrValueAndLength, java.lang.Long>_typeDescriptor(AttrValueAndLength._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()));
    } else {
      dafny.DafnySequence<? extends java.lang.Byte> _3_TerminalTypeId__key = (serialized).subsequence(dafny.Helpers.unsignedToInt(pos), dafny.Helpers.unsignedToInt((long) (long) ((pos) + (__default.TYPEID__LEN64()))));
      Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _4_valueOrError1 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (_3_TerminalTypeId__key).equals(StructuredEncryptionUtil_Compile.__default.STRING()), dafny.DafnySequence.asString("Key of Map is not String"));
      if ((_4_valueOrError1).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_4_valueOrError1).<dafny.Tuple2<AttrValueAndLength, java.lang.Long>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.Tuple2.<AttrValueAndLength, java.lang.Long>_typeDescriptor(AttrValueAndLength._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()));
      } else {
        long _5_pos = (long) (long) ((pos) + (__default.TYPEID__LEN64()));
        Wrappers_Compile.Result<java.lang.Long, dafny.DafnySequence<? extends Character>> _6_valueOrError2 = __default.BigEndianPosToU32As64(serialized, _5_pos);
        if ((_6_valueOrError2).IsFailure(BoundedInts_Compile.uint64._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
          return (_6_valueOrError2).<dafny.Tuple2<AttrValueAndLength, java.lang.Long>>PropagateFailure(BoundedInts_Compile.uint64._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.Tuple2.<AttrValueAndLength, java.lang.Long>_typeDescriptor(AttrValueAndLength._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()));
        } else {
          long _7_len = (_6_valueOrError2).Extract(BoundedInts_Compile.uint64._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
          long _8_pos = (long) (long) ((_5_pos) + (__default.LENGTH__LEN64()));
          Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _9_valueOrError3 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), java.lang.Long.compareUnsigned(_7_len, (long) (long) ((_0_serialized__size) - (_8_pos))) <= 0, dafny.DafnySequence.asString("Key of Map of Structured Data has too few bytes"));
          if ((_9_valueOrError3).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
            return (_9_valueOrError3).<dafny.Tuple2<AttrValueAndLength, java.lang.Long>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.Tuple2.<AttrValueAndLength, java.lang.Long>_typeDescriptor(AttrValueAndLength._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()));
          } else {
            Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _10_valueOrError4 = UTF8.__default.Decode((serialized).subsequence(dafny.Helpers.unsignedToInt(_8_pos), dafny.Helpers.unsignedToInt((long) (long) ((_8_pos) + (_7_len)))));
            if ((_10_valueOrError4).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
              return (_10_valueOrError4).<dafny.Tuple2<AttrValueAndLength, java.lang.Long>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.Tuple2.<AttrValueAndLength, java.lang.Long>_typeDescriptor(AttrValueAndLength._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()));
            } else {
              dafny.DafnySequence<? extends Character> _11_key = (_10_valueOrError4).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
              long _12_pos = (long) (long) ((_8_pos) + (_7_len));
              Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _13_valueOrError5 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), java.lang.Long.compareUnsigned((long) 2L, (long) (long) ((_0_serialized__size) - (_12_pos))) <= 0, dafny.DafnySequence.asString("Out of bytes reading Map Value"));
              if ((_13_valueOrError5).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
                return (_13_valueOrError5).<dafny.Tuple2<AttrValueAndLength, java.lang.Long>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.Tuple2.<AttrValueAndLength, java.lang.Long>_typeDescriptor(AttrValueAndLength._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()));
              } else {
                Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _14_valueOrError6 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.__default.IsValid__AttributeName(_11_key), dafny.DafnySequence.asString("Key is not valid AttributeName"));
                if ((_14_valueOrError6).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
                  return (_14_valueOrError6).<dafny.Tuple2<AttrValueAndLength, java.lang.Long>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.Tuple2.<AttrValueAndLength, java.lang.Long>_typeDescriptor(AttrValueAndLength._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()));
                } else {
                  dafny.DafnySequence<? extends java.lang.Byte> _15_TerminalTypeId__value = (serialized).subsequence(dafny.Helpers.unsignedToInt(_12_pos), dafny.Helpers.unsignedToInt((long) (long) ((_12_pos) + (__default.TYPEID__LEN64()))));
                  long _16_pos = (long) (long) ((_12_pos) + (__default.TYPEID__LEN64()));
                  Wrappers_Compile.Result<AttrValueAndLength, dafny.DafnySequence<? extends Character>> _17_valueOrError7 = __default.BytesToAttr(serialized, _15_TerminalTypeId__value, Wrappers_Compile.Option.<java.lang.Long>create_None(BoundedInts_Compile.uint64._typeDescriptor()), (long) (long) ((depth) + ((long) 1L)), _16_pos);
                  if ((_17_valueOrError7).IsFailure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
                    return (_17_valueOrError7).<dafny.Tuple2<AttrValueAndLength, java.lang.Long>>PropagateFailure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.Tuple2.<AttrValueAndLength, java.lang.Long>_typeDescriptor(AttrValueAndLength._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()));
                  } else {
                    AttrValueAndLength _18_nval = (_17_valueOrError7).Extract(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
                    long _19_pos = StandardLibrary_mMemoryMath_Compile.__default.Add(_16_pos, (_18_nval).dtor_len());
                    Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _20_valueOrError8 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), !(((resultMap).dtor_val()).dtor_M()).<dafny.DafnySequence<? extends Character>>contains(_11_key), dafny.DafnySequence.asString("Duplicate key in map."));
                    if ((_20_valueOrError8).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
                      return (_20_valueOrError8).<dafny.Tuple2<AttrValueAndLength, java.lang.Long>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.Tuple2.<AttrValueAndLength, java.lang.Long>_typeDescriptor(AttrValueAndLength._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()));
                    } else {
                      software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue _21_nattr = software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_M(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>update(((resultMap).dtor_val()).dtor_M(), _11_key, (_18_nval).dtor_val()));
                      AttrValueAndLength _22_newResultMap = AttrValueAndLength.create(_21_nattr, StandardLibrary_mMemoryMath_Compile.__default.Add((resultMap).dtor_len(), (long) (long) ((_19_pos) - (_1_orig__pos))));
                      return Wrappers_Compile.Result.<dafny.Tuple2<AttrValueAndLength, java.lang.Long>, dafny.DafnySequence<? extends Character>>create_Success(dafny.Tuple2.<AttrValueAndLength, java.lang.Long>_typeDescriptor(AttrValueAndLength._typeDescriptor(), BoundedInts_Compile.uint64._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.Tuple2.<AttrValueAndLength, java.lang.Long>create(_22_newResultMap, _19_pos));
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
  public static Wrappers_Compile.Result<AttrValueAndLength, dafny.DafnySequence<? extends Character>> DeserializeMap(dafny.DafnySequence<? extends java.lang.Byte> serialized, long pos, long remainingCount, long depth, AttrValueAndLength resultMap)
  {
    Wrappers_Compile.Result<AttrValueAndLength, dafny.DafnySequence<? extends Character>> ret = Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>Default(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength.Default());
    if(true) {
      long _0_npos;
      _0_npos = pos;
      AttrValueAndLength _1_newResultMap;
      _1_newResultMap = resultMap;
      long _hi0 = remainingCount;
      for (long _2_i = (long) 0L; java.lang.Long.compareUnsigned(_2_i, _hi0) < 0; _2_i++) {
        Wrappers_Compile.Result<dafny.Tuple2<AttrValueAndLength, java.lang.Long>, dafny.DafnySequence<? extends Character>> _3_test;
        _3_test = __default.DeserializeMapEntry(serialized, _0_npos, depth, _1_newResultMap);
        if ((_3_test).is_Failure()) {
          ret = Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Failure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (_3_test).dtor_error());
          return ret;
        }
        _1_newResultMap = ((_3_test).dtor_value()).dtor__0();
        _0_npos = ((_3_test).dtor_value()).dtor__1();
      }
      ret = Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Success(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _1_newResultMap);
    }
    return ret;
  }
  public static Wrappers_Compile.Result<AttrValueAndLength, dafny.DafnySequence<? extends Character>> BytesToAttr(dafny.DafnySequence<? extends java.lang.Byte> value, dafny.DafnySequence<? extends java.lang.Byte> typeId, Wrappers_Compile.Option<java.lang.Long> totalBytes, long depth, long pos)
  {
    long _0_value__size = (long) (value).cardinalityInt();
    Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _1_valueOrError0 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), java.lang.Long.compareUnsigned(depth, DynamoDbEncryptionUtil_Compile.__default.MAX__STRUCTURE__DEPTH()) <= 0, dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Depth of attribute structure to deserialize exceeds limit of "), DynamoDbEncryptionUtil_Compile.__default.MAX__STRUCTURE__DEPTH__STR()));
    if ((_1_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      return (_1_valueOrError0).<AttrValueAndLength>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
    } else {
      Wrappers_Compile.Result<java.lang.Long, dafny.DafnySequence<? extends Character>> _2_valueOrError1 = (((totalBytes).is_None()) ? (__default.BigEndianPosToU32As64(value, pos)) : (Wrappers_Compile.Result.<java.lang.Long, dafny.DafnySequence<? extends Character>>create_Success(BoundedInts_Compile.uint64._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (totalBytes).dtor_value())));
      if ((_2_valueOrError1).IsFailure(BoundedInts_Compile.uint64._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
        return (_2_valueOrError1).<AttrValueAndLength>PropagateFailure(BoundedInts_Compile.uint64._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
      } else {
        long _3_len = (_2_valueOrError1).Extract(BoundedInts_Compile.uint64._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
        long _4_pos = (((totalBytes).is_None()) ? (StandardLibrary_mMemoryMath_Compile.__default.Add(pos, __default.LENGTH__LEN64())) : (pos));
        long _5_lengthBytes = (((totalBytes).is_None()) ? (__default.LENGTH__LEN64()) : ((long) 0L));
        if (java.lang.Long.compareUnsigned((long) (long) ((_0_value__size) - (_4_pos)), _3_len) < 0) {
          return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Failure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("Structured Data has too few bytes"));
        } else if ((typeId).equals(StructuredEncryptionUtil_Compile.__default.NULL())) {
          if (((_3_len) == 0 ? 0 : 1) != 0) {
            return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Failure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("NULL type did not have length zero"));
          } else {
            return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Success(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_NULL(true), _5_lengthBytes));
          }
        } else if ((typeId).equals(StructuredEncryptionUtil_Compile.__default.STRING())) {
          Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _6_valueOrError2 = UTF8.__default.Decode((value).subsequence(dafny.Helpers.unsignedToInt(_4_pos), dafny.Helpers.unsignedToInt((long) (long) ((_4_pos) + (_3_len)))));
          if ((_6_valueOrError2).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
            return (_6_valueOrError2).<AttrValueAndLength>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
          } else {
            dafny.DafnySequence<? extends Character> _7_str = (_6_valueOrError2).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
            return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Success(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_S(_7_str), (long) (long) ((_3_len) + (_5_lengthBytes))));
          }
        } else if ((typeId).equals(StructuredEncryptionUtil_Compile.__default.NUMBER())) {
          Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>> _8_valueOrError3 = UTF8.__default.Decode((value).subsequence(dafny.Helpers.unsignedToInt(_4_pos), dafny.Helpers.unsignedToInt((long) (long) ((_4_pos) + (_3_len)))));
          if ((_8_valueOrError3).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
            return (_8_valueOrError3).<AttrValueAndLength>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
          } else {
            dafny.DafnySequence<? extends Character> _9_str = (_8_valueOrError3).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
            return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Success(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_N(_9_str), (long) (long) ((_3_len) + (_5_lengthBytes))));
          }
        } else if ((typeId).equals(StructuredEncryptionUtil_Compile.__default.BINARY())) {
          return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Success(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_B((value).subsequence(dafny.Helpers.unsignedToInt(_4_pos), dafny.Helpers.unsignedToInt((long) (long) ((_4_pos) + (_3_len))))), (long) (long) ((_3_len) + (_5_lengthBytes))));
        } else if ((typeId).equals(StructuredEncryptionUtil_Compile.__default.BOOLEAN())) {
          if ((_3_len) != (__default.BOOL__LEN64())) {
            return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Failure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("Boolean Structured Data has more than one byte"));
          } else if (((((byte)(java.lang.Object)((value).select(dafny.Helpers.unsignedToInt(_4_pos))))) == 0 ? 0 : 1) == 0) {
            return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Success(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_BOOL(false), (long) (long) ((__default.BOOL__LEN64()) + (_5_lengthBytes))));
          } else if ((((byte)(java.lang.Object)((value).select(dafny.Helpers.unsignedToInt(_4_pos))))) == ((byte) 1)) {
            return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Success(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_BOOL(true), (long) (long) ((__default.BOOL__LEN64()) + (_5_lengthBytes))));
          } else {
            return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Failure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("Boolean Structured Data had inappropriate value"));
          }
        } else if ((typeId).equals(StructuredEncryptionUtil_Compile.__default.STRING__SET())) {
          if (java.lang.Long.compareUnsigned((long) (long) ((_0_value__size) - (_4_pos)), __default.LENGTH__LEN64()) < 0) {
            return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Failure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("String Set Structured Data has less than LENGTH_LEN bytes"));
          } else {
            Wrappers_Compile.Result<java.lang.Long, dafny.DafnySequence<? extends Character>> _10_valueOrError4 = __default.BigEndianPosToU32As64(value, _4_pos);
            if ((_10_valueOrError4).IsFailure(BoundedInts_Compile.uint64._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
              return (_10_valueOrError4).<AttrValueAndLength>PropagateFailure(BoundedInts_Compile.uint64._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
            } else {
              long _11_len = (_10_valueOrError4).Extract(BoundedInts_Compile.uint64._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
              long _12_pos = (long) (long) ((_4_pos) + (__default.LENGTH__LEN64()));
              Wrappers_Compile.Result<AttrValueAndLength, dafny.DafnySequence<? extends Character>> _13_valueOrError5 = __default.DeserializeStringSet((value).drop(_12_pos), _11_len, StandardLibrary_mMemoryMath_Compile.__default.Add3((long) (long) ((_0_value__size) - (_12_pos)), __default.LENGTH__LEN64(), _5_lengthBytes), AttrValueAndLength.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_SS(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> empty(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))), (long) (long) ((__default.LENGTH__LEN64()) + (_5_lengthBytes))));
              if ((_13_valueOrError5).IsFailure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
                return (_13_valueOrError5).<AttrValueAndLength>PropagateFailure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
              } else {
                AttrValueAndLength _14_retval = (_13_valueOrError5).Extract(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
                return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Success(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _14_retval);
              }
            }
          }
        } else if ((typeId).equals(StructuredEncryptionUtil_Compile.__default.NUMBER__SET())) {
          if (java.lang.Long.compareUnsigned((long) (long) ((_0_value__size) - (_4_pos)), __default.LENGTH__LEN64()) < 0) {
            return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Failure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("Number Set Structured Data has less than 4 bytes"));
          } else {
            Wrappers_Compile.Result<java.lang.Long, dafny.DafnySequence<? extends Character>> _15_valueOrError6 = __default.BigEndianPosToU32As64(value, _4_pos);
            if ((_15_valueOrError6).IsFailure(BoundedInts_Compile.uint64._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
              return (_15_valueOrError6).<AttrValueAndLength>PropagateFailure(BoundedInts_Compile.uint64._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
            } else {
              long _16_len = (_15_valueOrError6).Extract(BoundedInts_Compile.uint64._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
              long _17_pos = (long) (long) ((_4_pos) + (__default.LENGTH__LEN64()));
              Wrappers_Compile.Result<AttrValueAndLength, dafny.DafnySequence<? extends Character>> _18_valueOrError7 = __default.DeserializeNumberSet((value).drop(_17_pos), _16_len, StandardLibrary_mMemoryMath_Compile.__default.Add3((long) (long) ((_0_value__size) - (_17_pos)), __default.LENGTH__LEN64(), _5_lengthBytes), AttrValueAndLength.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_NS(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> empty(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))), (long) (long) ((__default.LENGTH__LEN64()) + (_5_lengthBytes))));
              if ((_18_valueOrError7).IsFailure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
                return (_18_valueOrError7).<AttrValueAndLength>PropagateFailure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
              } else {
                AttrValueAndLength _19_retval = (_18_valueOrError7).Extract(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
                return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Success(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _19_retval);
              }
            }
          }
        } else if ((typeId).equals(StructuredEncryptionUtil_Compile.__default.BINARY__SET())) {
          if (java.lang.Long.compareUnsigned((long) (long) ((_0_value__size) - (_4_pos)), __default.LENGTH__LEN64()) < 0) {
            return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Failure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("Binary Set Structured Data has less than LENGTH_LEN bytes"));
          } else {
            Wrappers_Compile.Result<java.lang.Long, dafny.DafnySequence<? extends Character>> _20_valueOrError8 = __default.BigEndianPosToU32As64(value, _4_pos);
            if ((_20_valueOrError8).IsFailure(BoundedInts_Compile.uint64._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
              return (_20_valueOrError8).<AttrValueAndLength>PropagateFailure(BoundedInts_Compile.uint64._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
            } else {
              long _21_len = (_20_valueOrError8).Extract(BoundedInts_Compile.uint64._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
              long _22_pos = (long) (long) ((_4_pos) + (__default.LENGTH__LEN64()));
              Wrappers_Compile.Result<AttrValueAndLength, dafny.DafnySequence<? extends Character>> _23_valueOrError9 = __default.DeserializeBinarySet((value).drop(_22_pos), _21_len, StandardLibrary_mMemoryMath_Compile.__default.Add3((long) (long) ((_0_value__size) - (_22_pos)), __default.LENGTH__LEN64(), _5_lengthBytes), AttrValueAndLength.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_BS(dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>> empty(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()))), (long) (long) ((__default.LENGTH__LEN64()) + (_5_lengthBytes))));
              if ((_23_valueOrError9).IsFailure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
                return (_23_valueOrError9).<AttrValueAndLength>PropagateFailure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
              } else {
                AttrValueAndLength _24_retval = (_23_valueOrError9).Extract(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
                return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Success(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _24_retval);
              }
            }
          }
        } else if ((typeId).equals(StructuredEncryptionUtil_Compile.__default.MAP())) {
          if (java.lang.Long.compareUnsigned(_0_value__size, StandardLibrary_mMemoryMath_Compile.__default.Add(__default.LENGTH__LEN64(), _4_pos)) < 0) {
            return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Failure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("List Structured Data has less than 4 bytes"));
          } else {
            Wrappers_Compile.Result<java.lang.Long, dafny.DafnySequence<? extends Character>> _25_valueOrError10 = __default.BigEndianPosToU32As64(value, _4_pos);
            if ((_25_valueOrError10).IsFailure(BoundedInts_Compile.uint64._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
              return (_25_valueOrError10).<AttrValueAndLength>PropagateFailure(BoundedInts_Compile.uint64._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
            } else {
              long _26_len = (_25_valueOrError10).Extract(BoundedInts_Compile.uint64._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
              long _27_pos = (long) (long) ((_4_pos) + (__default.LENGTH__LEN64()));
              AttrValueAndLength _28_resultMap = AttrValueAndLength.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_M(dafny.DafnyMap.fromElements()), (long) (long) ((__default.LENGTH__LEN64()) + (_5_lengthBytes)));
              Wrappers_Compile.Result<AttrValueAndLength, dafny.DafnySequence<? extends Character>> _29_valueOrError11 = __default.DeserializeMap(value, _27_pos, _26_len, depth, _28_resultMap);
              if ((_29_valueOrError11).IsFailure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
                return (_29_valueOrError11).<AttrValueAndLength>PropagateFailure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
              } else {
                AttrValueAndLength _30_retval = (_29_valueOrError11).Extract(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
                return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Success(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _30_retval);
              }
            }
          }
        } else if ((typeId).equals(StructuredEncryptionUtil_Compile.__default.LIST())) {
          if (java.lang.Long.compareUnsigned(_0_value__size, StandardLibrary_mMemoryMath_Compile.__default.Add(__default.LENGTH__LEN64(), _4_pos)) < 0) {
            return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Failure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("List Structured Data has less than 4 bytes"));
          } else {
            Wrappers_Compile.Result<java.lang.Long, dafny.DafnySequence<? extends Character>> _31_valueOrError12 = __default.BigEndianPosToU32As64(value, _4_pos);
            if ((_31_valueOrError12).IsFailure(BoundedInts_Compile.uint64._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
              return (_31_valueOrError12).<AttrValueAndLength>PropagateFailure(BoundedInts_Compile.uint64._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
            } else {
              long _32_len = (_31_valueOrError12).Extract(BoundedInts_Compile.uint64._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
              long _33_pos = (long) (long) ((_4_pos) + (__default.LENGTH__LEN64()));
              AttrValueAndLength _34_resultList = AttrValueAndLength.create(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_L(dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor())), (long) (long) ((__default.LENGTH__LEN64()) + (_5_lengthBytes)));
              Wrappers_Compile.Result<AttrValueAndLength, dafny.DafnySequence<? extends Character>> _35_valueOrError13 = __default.DeserializeList(value, _33_pos, _32_len, depth, _34_resultList);
              if ((_35_valueOrError13).IsFailure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
                return (_35_valueOrError13).<AttrValueAndLength>PropagateFailure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), AttrValueAndLength._typeDescriptor());
              } else {
                AttrValueAndLength _36_retval = (_35_valueOrError13).Extract(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
                return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Success(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _36_retval);
              }
            }
          }
        } else {
          return Wrappers_Compile.Result.<AttrValueAndLength, dafny.DafnySequence<? extends Character>>create_Failure(AttrValueAndLength._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("Unsupported TerminalTypeId"));
        }
      }
    }
  }
  public static <__X, __Y> dafny.DafnyMap<? extends __X, ? extends __Y> FlattenValueMap(dafny.TypeDescriptor<__X> _td___X, dafny.TypeDescriptor<__Y> _td___Y, dafny.DafnyMap<? extends __X, ? extends Wrappers_Compile.Result<__Y, dafny.DafnySequence<? extends Character>>> m)
  {
    return ((java.util.function.Function<dafny.DafnyMap<? extends __X, ? extends Wrappers_Compile.Result<__Y, dafny.DafnySequence<? extends Character>>>, dafny.DafnyMap<? extends __X, ? extends __Y>>)(_0_m) -> ((dafny.Function0<dafny.DafnyMap<? extends __X, ? extends __Y>>)(() -> {
      java.util.HashMap<__X, __Y> _coll0 = new java.util.HashMap<>();
      for (__X _compr_0_boxed0 : (_0_m).keySet().Elements()) {
        __X _compr_0 = ((__X)(java.lang.Object)(_compr_0_boxed0));
        __X _1_k = (__X)_compr_0;
        if (((_0_m).<__X>contains(_1_k)) && ((((Wrappers_Compile.Result<__Y, dafny.DafnySequence<? extends Character>>)(java.lang.Object)((_0_m).get(_1_k)))).is_Success())) {
          _coll0.put(_1_k,(((Wrappers_Compile.Result<__Y, dafny.DafnySequence<? extends Character>>)(java.lang.Object)((_0_m).get(_1_k)))).dtor_value());
        }
      }
      return new dafny.DafnyMap<__X,__Y>(_coll0);
    })).apply()).apply(m);
  }
  public static <__X, __Y> dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> FlattenErrors(dafny.TypeDescriptor<__X> _td___X, dafny.TypeDescriptor<__Y> _td___Y, dafny.DafnyMap<? extends __X, ? extends Wrappers_Compile.Result<__Y, dafny.DafnySequence<? extends Character>>> m)
  {
    return ((java.util.function.Function<dafny.DafnyMap<? extends __X, ? extends Wrappers_Compile.Result<__Y, dafny.DafnySequence<? extends Character>>>, dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>>>)(_0_m) -> ((dafny.Function0<dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>>>)(() -> {
      java.util.ArrayList<dafny.DafnySequence<? extends Character>> _coll0 = new java.util.ArrayList<>();
      for (__X _compr_0_boxed0 : (_0_m).keySet().Elements()) {
        __X _compr_0 = ((__X)(java.lang.Object)(_compr_0_boxed0));
        __X _1_k = (__X)_compr_0;
        if (((_0_m).<__X>contains(_1_k)) && ((((Wrappers_Compile.Result<__Y, dafny.DafnySequence<? extends Character>>)(java.lang.Object)((_0_m).get(_1_k)))).is_Failure())) {
          _coll0.add((((Wrappers_Compile.Result<__Y, dafny.DafnySequence<? extends Character>>)(java.lang.Object)((_0_m).get(_1_k)))).dtor_error());
        }
      }
      return new dafny.DafnySet<dafny.DafnySequence<? extends Character>>(_coll0);
    })).apply()).apply(m);
  }
  public static <__X, __Y> Wrappers_Compile.Result<dafny.DafnyMap<? extends __X, ? extends __Y>, dafny.DafnySequence<? extends Character>> SimplifyMapValue(dafny.TypeDescriptor<__X> _td___X, dafny.TypeDescriptor<__Y> _td___Y, dafny.DafnyMap<? extends __X, ? extends Wrappers_Compile.Result<__Y, dafny.DafnySequence<? extends Character>>> m)
  {
    if (((java.util.function.Function<dafny.DafnyMap<? extends __X, ? extends Wrappers_Compile.Result<__Y, dafny.DafnySequence<? extends Character>>>, Boolean>)(_0_m) -> dafny.Helpers.Quantifier((_0_m).keySet().Elements(), true, ((_forall_var_0_boxed0) -> {
      __X _forall_var_0 = ((__X)(java.lang.Object)(_forall_var_0_boxed0));
      __X _1_k = (__X)_forall_var_0;
      return !((_0_m).<__X>contains(_1_k)) || ((((Wrappers_Compile.Result<__Y, dafny.DafnySequence<? extends Character>>)(java.lang.Object)((_0_m).get(_1_k)))).is_Success());
    }))).apply(m)) {
      dafny.DafnyMap<? extends __X, ? extends __Y> _2_result = __default.<__X, __Y>FlattenValueMap(_td___X, _td___Y, m);
      return Wrappers_Compile.Result.<dafny.DafnyMap<? extends __X, ? extends __Y>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnyMap.<__X, __Y>_typeDescriptor(_td___X, _td___Y), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _2_result);
    } else {
      dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> _3_badValues = __default.<__X, __Y>FlattenErrors(_td___X, _td___Y, m);
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _4_badValueSeq = SortedSets.__default.<Character>SetToOrderedSequence2(dafny.TypeDescriptor.CHAR, _3_badValues, __default::CharLess);
      return Wrappers_Compile.Result.<dafny.DafnyMap<? extends __X, ? extends __Y>, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnyMap.<__X, __Y>_typeDescriptor(_td___X, _td___Y), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), StandardLibrary_Compile.__default.<Character>Join(dafny.TypeDescriptor.CHAR, _4_badValueSeq, dafny.DafnySequence.asString("\n")));
    }
  }
  public static long LENGTH__LEN64()
  {
    return (long) 4L;
  }
  public static long TYPEID__LEN64()
  {
    return (long) 2L;
  }
  public static long BOOL__LEN64()
  {
    return (long) 1L;
  }
  public static long PREFIX__LEN64()
  {
    return (long) 6L;
  }
  @Override
  public java.lang.String toString() {
    return "DynamoToStruct._default";
  }
}
