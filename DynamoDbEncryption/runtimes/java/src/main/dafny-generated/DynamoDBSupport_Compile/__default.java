// Class __default
// Dafny class __default compiled into Java
package DynamoDBSupport_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static Wrappers_Compile.Result<Boolean, dafny.DafnySequence<? extends Character>> IsWriteable(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item)
  {
    Wrappers_Compile.Result<Boolean, dafny.DafnySequence<? extends Character>> ret = Wrappers_Compile.Result.<Boolean, dafny.DafnySequence<? extends Character>>Default(dafny.TypeDescriptor.BOOLEAN, dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), false);
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _0_keys;
    _0_keys = SortedSets.__default.<Character>SetToOrderedSequence2(dafny.TypeDescriptor.CHAR, (item).keySet(), DynamoDbEncryptionUtil_Compile.__default::CharLess);
    dafny.DafnySequence<? extends Character> _1_rp;
    _1_rp = DynamoDbEncryptionUtil_Compile.__default.ReservedPrefix();
    long _hi0 = (long) (_0_keys).cardinalityInt();
    for (long _2_i = (long) 0L; java.lang.Long.compareUnsigned(_2_i, _hi0) < 0; _2_i++) {
      if ((_1_rp).isPrefixOf(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((_0_keys).select(dafny.Helpers.unsignedToInt(_2_i)))))) {
        dafny.DafnySequence<? extends Character> _3_result;
        _3_result = dafny.DafnySequence.asString("Writing reserved attributes not allowed : ");
        long _hi1 = (long) (_0_keys).cardinalityInt();
        for (long _4_j = _2_i; java.lang.Long.compareUnsigned(_4_j, _hi1) < 0; _4_j++) {
          if ((_1_rp).isPrefixOf(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((_0_keys).select(dafny.Helpers.unsignedToInt(_2_i)))))) {
            _3_result = dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(_3_result, ((dafny.DafnySequence<? extends Character>)(java.lang.Object)((_0_keys).select(dafny.Helpers.unsignedToInt(_2_i))))), dafny.DafnySequence.asString("\n"));
          }
        }
        ret = Wrappers_Compile.Result.<Boolean, dafny.DafnySequence<? extends Character>>create_Failure(dafny.TypeDescriptor.BOOLEAN, dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), _3_result);
        return ret;
      }
    }
    ret = Wrappers_Compile.Result.<Boolean, dafny.DafnySequence<? extends Character>>create_Success(dafny.TypeDescriptor.BOOLEAN, dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), true);
    return ret;
  }
  public static dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> GetEncryptedAttributes(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> actions, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> expr, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> attrNames)
  {
    if ((expr).is_None()) {
      return dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> empty(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
    } else {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _0_attrs = DynamoDBFilterExpr_Compile.__default.ExtractAttributes((expr).dtor_value(), attrNames);
      return Seq_Compile.__default.<dafny.DafnySequence<? extends Character>>Filter(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((java.util.function.Function<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction>, java.util.function.Function<dafny.DafnySequence<? extends Character>, Boolean>>)(_1_actions) -> ((java.util.function.Function<dafny.DafnySequence<? extends Character>, Boolean>)(_2_attr_boxed0) -> {
        dafny.DafnySequence<? extends Character> _2_attr = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_2_attr_boxed0));
        return __default.IsEncrypted(_1_actions, _2_attr);
      })).apply(actions), _0_attrs);
    }
  }
  public static Wrappers_Compile.Result<Boolean, dafny.DafnySequence<? extends Character>> TestConditionExpression(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> actions, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> expr, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> attrNames, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> attrValues)
  {
    if ((expr).is_Some()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _0_attrs = __default.GetEncryptedAttributes(actions, expr, attrNames);
      if ((((long) (_0_attrs).cardinalityInt()) == 0 ? 0 : 1) == 0) {
        return Wrappers_Compile.Result.<Boolean, dafny.DafnySequence<? extends Character>>create_Success(dafny.TypeDescriptor.BOOLEAN, dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), true);
      } else {
        return Wrappers_Compile.Result.<Boolean, dafny.DafnySequence<? extends Character>>create_Failure(dafny.TypeDescriptor.BOOLEAN, dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Condition Expressions forbidden on encrypted attributes : "), StandardLibrary_Compile.__default.<Character>Join(dafny.TypeDescriptor.CHAR, _0_attrs, dafny.DafnySequence.asString(","))));
      }
    } else {
      return Wrappers_Compile.Result.<Boolean, dafny.DafnySequence<? extends Character>>create_Success(dafny.TypeDescriptor.BOOLEAN, dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), true);
    }
  }
  public static boolean IsSigned(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> actions, dafny.DafnySequence<? extends Character> attr)
  {
    return ((actions).<dafny.DafnySequence<? extends Character>>contains(attr)) && (!java.util.Objects.equals(((software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction)(java.lang.Object)((actions).get(attr))), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_DO__NOTHING()));
  }
  public static boolean IsEncrypted(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> actions, dafny.DafnySequence<? extends Character> attr)
  {
    return ((actions).<dafny.DafnySequence<? extends Character>>contains(attr)) && (java.util.Objects.equals(((software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction)(java.lang.Object)((actions).get(attr))), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN()));
  }
  public static Wrappers_Compile.Result<Boolean, dafny.DafnySequence<? extends Character>> TestUpdateExpression(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> actions, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> expr, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> attrNames, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> attrValues)
  {
    if ((expr).is_Some()) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _0_attrs = DynamoDbUpdateExpr_Compile.__default.ExtractAttributes((expr).dtor_value(), attrNames);
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1_encryptedAttrs = Seq_Compile.__default.<dafny.DafnySequence<? extends Character>>Filter(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((java.util.function.Function<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction>, java.util.function.Function<dafny.DafnySequence<? extends Character>, Boolean>>)(_2_actions) -> ((java.util.function.Function<dafny.DafnySequence<? extends Character>, Boolean>)(_3_s_boxed0) -> {
        dafny.DafnySequence<? extends Character> _3_s = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_3_s_boxed0));
        return __default.IsSigned(_2_actions, _3_s);
      })).apply(actions), _0_attrs);
      if ((((long) (_1_encryptedAttrs).cardinalityInt()) == 0 ? 0 : 1) == 0) {
        return Wrappers_Compile.Result.<Boolean, dafny.DafnySequence<? extends Character>>create_Success(dafny.TypeDescriptor.BOOLEAN, dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), true);
      } else {
        return Wrappers_Compile.Result.<Boolean, dafny.DafnySequence<? extends Character>>create_Failure(dafny.TypeDescriptor.BOOLEAN, dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Update Expressions forbidden on signed attributes : "), StandardLibrary_Compile.__default.<Character>Join(dafny.TypeDescriptor.CHAR, _1_encryptedAttrs, dafny.DafnySequence.asString(","))));
      }
    } else {
      return Wrappers_Compile.Result.<Boolean, dafny.DafnySequence<? extends Character>>create_Success(dafny.TypeDescriptor.BOOLEAN, dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), true);
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GetEncryptedBeacons(Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo> search, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item, DynamoDbEncryptionUtil_Compile.MaybeKeyId keyId)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty());
    if(true) {
      if ((search).is_None()) {
        output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.fromElements());
        return output;
      } else {
        Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out0;
        _out0 = ((search).dtor_value()).GenerateEncryptedBeacons(item, keyId);
        output = _out0;
      }
    }
    return output;
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> AddSignedBeacons(Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo> search, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty());
    if(true) {
      if ((search).is_None()) {
        output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), item);
        return output;
      } else {
        Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty());
        Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out0;
        _out0 = ((search).dtor_value()).GenerateSignedBeacons(item);
        _0_valueOrError0 = _out0;
        if ((_0_valueOrError0).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          output = (_0_valueOrError0).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()));
          return output;
        }
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _1_newAttrs;
        _1_newAttrs = (_0_valueOrError0).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> _2_badAttrs;
        _2_badAttrs = ((dafny.Function2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>>>)(_3_newAttrs, _4_item) -> ((dafny.Function0<dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>>>)(() -> {
          java.util.ArrayList<dafny.DafnySequence<? extends Character>> _coll0 = new java.util.ArrayList<>();
          for (dafny.DafnySequence<? extends Character> _compr_0_boxed0 : (_3_newAttrs).keySet().Elements()) {
            dafny.DafnySequence<? extends Character> _compr_0 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_compr_0_boxed0));
            dafny.DafnySequence<? extends Character> _5_k = (dafny.DafnySequence<? extends Character>)_compr_0;
            if (software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._Is(_5_k)) {
              if ((((_3_newAttrs).<dafny.DafnySequence<? extends Character>>contains(_5_k)) && ((_4_item).<dafny.DafnySequence<? extends Character>>contains(_5_k))) && (!java.util.Objects.equals(((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_4_item).get(_5_k))), ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_3_newAttrs).get(_5_k)))))) {
                _coll0.add(_5_k);
              }
            }
          }
          return new dafny.DafnySet<dafny.DafnySequence<? extends Character>>(_coll0);
        })).apply()).apply(_1_newAttrs, item);
        Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _6_valueOrError1 = Wrappers_Compile.Outcome.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        _6_valueOrError1 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), (((long) (_2_badAttrs).cardinalityInt()) == 0 ? 0 : 1) == 0, DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Signed beacons have generated values different from supplied values.")));
        if ((_6_valueOrError1).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          output = (_6_valueOrError1).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()));
          return output;
        }
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _7_version;
        _7_version = dafny.DafnyMap.fromElements(new dafny.Tuple2(__default.VersionTag(), DdbVirtualFields_Compile.__default.DS(dafny.DafnySequence.asString(" "))));
        dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> _8_both;
        _8_both = dafny.DafnySet.<dafny.DafnySequence<? extends Character>>intersection((_1_newAttrs).keySet(), (item).keySet());
        dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> _9_bad;
        _9_bad = ((dafny.Function3<dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>>, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>>>)(_10_both, _11_newAttrs, _12_item) -> ((dafny.Function0<dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>>>)(() -> {
          java.util.ArrayList<dafny.DafnySequence<? extends Character>> _coll1 = new java.util.ArrayList<>();
          for (dafny.DafnySequence<? extends Character> _compr_1_boxed0 : (_10_both).Elements()) {
            dafny.DafnySequence<? extends Character> _compr_1 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_compr_1_boxed0));
            dafny.DafnySequence<? extends Character> _13_k = (dafny.DafnySequence<? extends Character>)_compr_1;
            if (software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._Is(_13_k)) {
              if (((_10_both).<dafny.DafnySequence<? extends Character>>contains(_13_k)) && (!java.util.Objects.equals(((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_11_newAttrs).get(_13_k))), ((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_12_item).get(_13_k)))))) {
                _coll1.add(_13_k);
              }
            }
          }
          return new dafny.DafnySet<dafny.DafnySequence<? extends Character>>(_coll1);
        })).apply()).apply(_8_both, _1_newAttrs, item);
        if ((((long) (_9_bad).cardinalityInt()) == 0 ? 0 : 1) == 1) {
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _14_badSeq;
          _14_badSeq = SortedSets.__default.<Character>SetToOrderedSequence2(dafny.TypeDescriptor.CHAR, _9_bad, DynamoDbEncryptionUtil_Compile.__default::CharLess);
          output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Supplied Beacons do not match calculated beacons : "), StandardLibrary_Compile.__default.<Character>Join(dafny.TypeDescriptor.CHAR, _14_badSeq, dafny.DafnySequence.asString(", ")))));
          return output;
        }
        if (((((((search).dtor_value()).curr()).dtor_keySource()).dtor_keyLoc()).is_MultiLoc()) && ((((((search).dtor_value()).curr()).dtor_keySource()).dtor_keyLoc()).dtor_deleteKey())) {
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _15_newItem;
          _15_newItem = ((dafny.Function2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo>, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>)(_16_item, _17_search) -> ((dafny.Function0<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>)(() -> {
            java.util.HashMap<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _coll2 = new java.util.HashMap<>();
            for (dafny.DafnySequence<? extends Character> _compr_2_boxed0 : (_16_item).keySet().Elements()) {
              dafny.DafnySequence<? extends Character> _compr_2 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_compr_2_boxed0));
              dafny.DafnySequence<? extends Character> _18_k = (dafny.DafnySequence<? extends Character>)_compr_2;
              if (software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._Is(_18_k)) {
                if (((_16_item).<dafny.DafnySequence<? extends Character>>contains(_18_k)) && (!(_18_k).equals((((((_17_search).dtor_value()).curr()).dtor_keySource()).dtor_keyLoc()).dtor_keyName()))) {
                  _coll2.put(_18_k,((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_16_item).get(_18_k))));
                }
              }
            }
            return new dafny.DafnyMap<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>(_coll2);
          })).apply()).apply(item, search);
          output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>merge(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>merge(_15_newItem, _1_newAttrs), _7_version));
          return output;
        } else {
          output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>merge(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>merge(item, _1_newAttrs), _7_version));
          return output;
        }
      }
    }
    return output;
  }
  public static dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> DoRemoveBeacons(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item) {
    return ((java.util.function.Function<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>)(_0_item) -> ((dafny.Function0<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>)(() -> {
      java.util.HashMap<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _coll0 = new java.util.HashMap<>();
      for (dafny.DafnySequence<? extends Character> _compr_0_boxed0 : (_0_item).keySet().Elements()) {
        dafny.DafnySequence<? extends Character> _compr_0 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_compr_0_boxed0));
        dafny.DafnySequence<? extends Character> _1_k = (dafny.DafnySequence<? extends Character>)_compr_0;
        if (software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._Is(_1_k)) {
          if (((_0_item).<dafny.DafnySequence<? extends Character>>contains(_1_k)) && (!((DynamoDbEncryptionUtil_Compile.__default.ReservedPrefix()).isPrefixOf(_1_k)))) {
            _coll0.put(_1_k,((software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue)(java.lang.Object)((_0_item).get(_1_k))));
          }
        }
      }
      return new dafny.DafnyMap<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>(_coll0);
    })).apply()).apply(item);
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, dafny.DafnySequence<? extends Character>> RemoveBeacons(Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo> search, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item)
  {
    return Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, dafny.DafnySequence<? extends Character>>create_Success(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), __default.DoRemoveBeacons(item));
  }
  public static Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> QueryInputForBeacons(Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo> search, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> actions, software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput req)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> output = (Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    if(true) {
      if ((search).is_None()) {
        Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), false);
        Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out0;
        _out0 = DynamoDBFilterExpr_Compile.__default.TestBeaconize(actions, (req).dtor_KeyConditionExpression(), (req).dtor_FilterExpression(), (req).dtor_ExpressionAttributeNames());
        _0_valueOrError0 = _out0;
        if ((_0_valueOrError0).IsFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          output = (_0_valueOrError0).<software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput._typeDescriptor());
          return output;
        }
        boolean _1___v0;
        _1___v0 = (_0_valueOrError0).Extract(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        output = Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), req);
        return output;
      } else {
        Wrappers_Compile.Result<DynamoDbEncryptionUtil_Compile.MaybeKeyId, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _2_valueOrError1 = Wrappers_Compile.Result.<DynamoDbEncryptionUtil_Compile.MaybeKeyId, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(DynamoDbEncryptionUtil_Compile.MaybeKeyId._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.MaybeKeyId.Default());
        _2_valueOrError1 = DynamoDBFilterExpr_Compile.__default.GetBeaconKeyId(((search).dtor_value()).curr(), (req).dtor_KeyConditionExpression(), (req).dtor_FilterExpression(), (req).dtor_ExpressionAttributeValues(), (req).dtor_ExpressionAttributeNames());
        if ((_2_valueOrError1).IsFailure(DynamoDbEncryptionUtil_Compile.MaybeKeyId._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          output = (_2_valueOrError1).<software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput>PropagateFailure(DynamoDbEncryptionUtil_Compile.MaybeKeyId._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput._typeDescriptor());
          return output;
        }
        DynamoDbEncryptionUtil_Compile.MaybeKeyId _3_keyId;
        _3_keyId = (_2_valueOrError1).Extract(DynamoDbEncryptionUtil_Compile.MaybeKeyId._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        DynamoDBFilterExpr_Compile.ExprContext _4_oldContext;
        _4_oldContext = DynamoDBFilterExpr_Compile.ExprContext.create((req).dtor_KeyConditionExpression(), (req).dtor_FilterExpression(), (req).dtor_ExpressionAttributeValues(), (req).dtor_ExpressionAttributeNames());
        Wrappers_Compile.Result<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _5_valueOrError2 = Wrappers_Compile.Result.<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDBFilterExpr_Compile.ExprContext.Default());
        Wrappers_Compile.Result<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out1;
        _out1 = DynamoDBFilterExpr_Compile.__default.Beaconize(((search).dtor_value()).curr(), _4_oldContext, _3_keyId, false);
        _5_valueOrError2 = _out1;
        if ((_5_valueOrError2).IsFailure(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          output = (_5_valueOrError2).<software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput>PropagateFailure(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput._typeDescriptor());
          return output;
        }
        DynamoDBFilterExpr_Compile.ExprContext _6_newContext;
        _6_newContext = (_5_valueOrError2).Extract(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        DynamoDBFilterExpr_Compile.ExprContext _pat_let_tv0 = _6_newContext;
        DynamoDBFilterExpr_Compile.ExprContext _pat_let_tv1 = _6_newContext;
        DynamoDBFilterExpr_Compile.ExprContext _pat_let_tv2 = _6_newContext;
        DynamoDBFilterExpr_Compile.ExprContext _pat_let_tv3 = _6_newContext;
        output = Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput)(java.lang.Object)(dafny.Helpers.<software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput, software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput>Let(req, boxed0 -> {
  software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput _pat_let1_0 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput)(java.lang.Object)(boxed0));
  return ((software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput)(java.lang.Object)(dafny.Helpers.<software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput, software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput>Let(_pat_let1_0, boxed1 -> {
    software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput _7_dt__update__tmp_h0 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput)(java.lang.Object)(boxed1));
    return ((software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>, software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput>Let((_pat_let_tv0).dtor_values(), boxed2 -> {
      Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> _pat_let2_0 = ((Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>)(java.lang.Object)(boxed2));
      return ((software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>, software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput>Let(_pat_let2_0, boxed3 -> {
        Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> _8_dt__update_hExpressionAttributeValues_h0 = ((Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>)(java.lang.Object)(boxed3));
        return ((software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>, software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput>Let((_pat_let_tv1).dtor_names(), boxed4 -> {
          Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _pat_let3_0 = ((Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>)(java.lang.Object)(boxed4));
          return ((software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>, software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput>Let(_pat_let3_0, boxed5 -> {
            Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _9_dt__update_hExpressionAttributeNames_h0 = ((Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>)(java.lang.Object)(boxed5));
            return ((software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput>Let((_pat_let_tv2).dtor_filterExpr(), boxed6 -> {
              Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _pat_let4_0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>)(java.lang.Object)(boxed6));
              return ((software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput>Let(_pat_let4_0, boxed7 -> {
                Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _10_dt__update_hFilterExpression_h0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>)(java.lang.Object)(boxed7));
                return ((software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput>Let((_pat_let_tv3).dtor_keyExpr(), boxed8 -> {
                  Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _pat_let5_0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>)(java.lang.Object)(boxed8));
                  return ((software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput>Let(_pat_let5_0, boxed9 -> {
                    Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _11_dt__update_hKeyConditionExpression_h0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>)(java.lang.Object)(boxed9));
                    return software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput.create((_7_dt__update__tmp_h0).dtor_TableName(), (_7_dt__update__tmp_h0).dtor_IndexName(), (_7_dt__update__tmp_h0).dtor_Select(), (_7_dt__update__tmp_h0).dtor_AttributesToGet(), (_7_dt__update__tmp_h0).dtor_Limit(), (_7_dt__update__tmp_h0).dtor_ConsistentRead(), (_7_dt__update__tmp_h0).dtor_KeyConditions(), (_7_dt__update__tmp_h0).dtor_QueryFilter(), (_7_dt__update__tmp_h0).dtor_ConditionalOperator(), (_7_dt__update__tmp_h0).dtor_ScanIndexForward(), (_7_dt__update__tmp_h0).dtor_ExclusiveStartKey(), (_7_dt__update__tmp_h0).dtor_ReturnConsumedCapacity(), (_7_dt__update__tmp_h0).dtor_ProjectionExpression(), _10_dt__update_hFilterExpression_h0, _11_dt__update_hKeyConditionExpression_h0, _9_dt__update_hExpressionAttributeNames_h0, _8_dt__update_hExpressionAttributeValues_h0);
                  }
                  )));
                }
                )));
              }
              )));
            }
            )));
          }
          )));
        }
        )));
      }
      )));
    }
    )));
  }
  )));
}
))));
        return output;
      }
    }
    return output;
  }
  public static Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> QueryOutputForBeacons(Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo> search, software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryInput req, software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput resp)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> output = Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput.Default());
    if(true) {
      if ((search).is_None()) {
        dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> _0_trimmedItems;
        _0_trimmedItems = Seq_Compile.__default.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>Map(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), ((java.util.function.Function<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>)(_1_i_boxed0) -> {
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _1_i = ((dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>)(java.lang.Object)(_1_i_boxed0));
          return __default.DoRemoveBeacons(_1_i);
        }), ((resp).dtor_Items()).dtor_value());
        dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> _pat_let_tv0 = _0_trimmedItems;
        output = Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput)(java.lang.Object)(dafny.Helpers.<software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput>Let(resp, boxed10 -> {
  software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput _pat_let6_0 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput)(java.lang.Object)(boxed10));
  return ((software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput)(java.lang.Object)(dafny.Helpers.<software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput>Let(_pat_let6_0, boxed11 -> {
    software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput _2_dt__update__tmp_h0 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput)(java.lang.Object)(boxed11));
    return ((software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>>, software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput>Let(Wrappers_Compile.Option.<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>>create_Some(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor())), _pat_let_tv0), boxed12 -> {
      Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>> _pat_let7_0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>>)(java.lang.Object)(boxed12));
      return ((software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>>, software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput>Let(_pat_let7_0, boxed13 -> {
        Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>> _3_dt__update_hItems_h0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>>)(java.lang.Object)(boxed13));
        return software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput.create(_3_dt__update_hItems_h0, (_2_dt__update__tmp_h0).dtor_Count(), (_2_dt__update__tmp_h0).dtor_ScannedCount(), (_2_dt__update__tmp_h0).dtor_LastEvaluatedKey(), (_2_dt__update__tmp_h0).dtor_ConsumedCapacity());
      }
      )));
    }
    )));
  }
  )));
}
))));
        return output;
      } else {
        Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _4_valueOrError0 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> empty(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor())));
        Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out0;
        _out0 = DynamoDBFilterExpr_Compile.__default.FilterResults(((search).dtor_value()).curr(), ((resp).dtor_Items()).dtor_value(), (req).dtor_KeyConditionExpression(), (req).dtor_FilterExpression(), (req).dtor_ExpressionAttributeNames(), (req).dtor_ExpressionAttributeValues());
        _4_valueOrError0 = _out0;
        if ((_4_valueOrError0).IsFailure(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          output = (_4_valueOrError0).<software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput>PropagateFailure(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput._typeDescriptor());
          return output;
        }
        dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> _5_newItems;
        _5_newItems = (_4_valueOrError0).Extract(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _6_valueOrError1 = Wrappers_Compile.Outcome.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        _6_valueOrError1 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), java.lang.Long.compareUnsigned((long) (_5_newItems).cardinalityInt(), (StandardLibrary_mUInt_Compile.__default.INT32__MAX__LIMIT()).longValue()) < 0, DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("This is impossible.")));
        if ((_6_valueOrError1).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          output = (_6_valueOrError1).<software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput._typeDescriptor());
          return output;
        }
        dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> _7_trimmedItems;
        _7_trimmedItems = Seq_Compile.__default.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>Map(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), ((java.util.function.Function<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>)(_8_i_boxed0) -> {
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _8_i = ((dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>)(java.lang.Object)(_8_i_boxed0));
          return __default.DoRemoveBeacons(_8_i);
        }), _5_newItems);
        Wrappers_Compile.Option<java.lang.Integer> _9_count;
        if (((resp).dtor_Count()).is_Some()) {
          _9_count = Wrappers_Compile.Option.<java.lang.Integer>create_Some(BoundedInts_Compile.int32._typeDescriptor(), (_7_trimmedItems).cardinalityInt());
        } else {
          _9_count = Wrappers_Compile.Option.<java.lang.Integer>create_None(BoundedInts_Compile.int32._typeDescriptor());
        }
        Wrappers_Compile.Option<java.lang.Integer> _pat_let_tv1 = _9_count;
        dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> _pat_let_tv2 = _7_trimmedItems;
        output = Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput)(java.lang.Object)(dafny.Helpers.<software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput>Let(resp, boxed14 -> {
  software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput _pat_let8_0 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput)(java.lang.Object)(boxed14));
  return ((software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput)(java.lang.Object)(dafny.Helpers.<software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput>Let(_pat_let8_0, boxed15 -> {
    software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput _10_dt__update__tmp_h1 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput)(java.lang.Object)(boxed15));
    return ((software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<java.lang.Integer>, software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput>Let(_pat_let_tv1, boxed16 -> {
      Wrappers_Compile.Option<java.lang.Integer> _pat_let9_0 = ((Wrappers_Compile.Option<java.lang.Integer>)(java.lang.Object)(boxed16));
      return ((software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<java.lang.Integer>, software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput>Let(_pat_let9_0, boxed17 -> {
        Wrappers_Compile.Option<java.lang.Integer> _11_dt__update_hCount_h0 = ((Wrappers_Compile.Option<java.lang.Integer>)(java.lang.Object)(boxed17));
        return ((software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>>, software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput>Let(Wrappers_Compile.Option.<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>>create_Some(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor())), _pat_let_tv2), boxed18 -> {
          Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>> _pat_let10_0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>>)(java.lang.Object)(boxed18));
          return ((software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>>, software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput>Let(_pat_let10_0, boxed19 -> {
            Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>> _12_dt__update_hItems_h1 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>>)(java.lang.Object)(boxed19));
            return software.amazon.cryptography.services.dynamodb.internaldafny.types.QueryOutput.create(_12_dt__update_hItems_h1, _11_dt__update_hCount_h0, (_10_dt__update__tmp_h1).dtor_ScannedCount(), (_10_dt__update__tmp_h1).dtor_LastEvaluatedKey(), (_10_dt__update__tmp_h1).dtor_ConsumedCapacity());
          }
          )));
        }
        )));
      }
      )));
    }
    )));
  }
  )));
}
))));
        return output;
      }
    }
    return output;
  }
  public static Wrappers_Compile.Result<DynamoDbEncryptionUtil_Compile.MaybeKeyId, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GetBeaconKeyId(Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo> search, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> keyExpr, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> filterExpr, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> values, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names)
  {
    if ((search).is_None()) {
      return Wrappers_Compile.Result.<DynamoDbEncryptionUtil_Compile.MaybeKeyId, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(DynamoDbEncryptionUtil_Compile.MaybeKeyId._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.MaybeKeyId.create_DontUseKeyId());
    } else {
      return DynamoDBFilterExpr_Compile.__default.GetBeaconKeyId(((search).dtor_value()).curr(), keyExpr, filterExpr, values, names);
    }
  }
  public static Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> ScanInputForBeacons(Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo> search, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> actions, software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput req)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> output = (Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    if(true) {
      if ((search).is_None()) {
        Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), false);
        Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out0;
        _out0 = DynamoDBFilterExpr_Compile.__default.TestBeaconize(actions, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), (req).dtor_FilterExpression(), (req).dtor_ExpressionAttributeNames());
        _0_valueOrError0 = _out0;
        if ((_0_valueOrError0).IsFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          output = (_0_valueOrError0).<software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput._typeDescriptor());
          return output;
        }
        boolean _1___v1;
        _1___v1 = (_0_valueOrError0).Extract(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        output = Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), req);
        return output;
      } else {
        Wrappers_Compile.Result<DynamoDbEncryptionUtil_Compile.MaybeKeyId, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _2_valueOrError1 = Wrappers_Compile.Result.<DynamoDbEncryptionUtil_Compile.MaybeKeyId, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(DynamoDbEncryptionUtil_Compile.MaybeKeyId._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.MaybeKeyId.Default());
        _2_valueOrError1 = DynamoDBFilterExpr_Compile.__default.GetBeaconKeyId(((search).dtor_value()).curr(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), (req).dtor_FilterExpression(), (req).dtor_ExpressionAttributeValues(), (req).dtor_ExpressionAttributeNames());
        if ((_2_valueOrError1).IsFailure(DynamoDbEncryptionUtil_Compile.MaybeKeyId._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          output = (_2_valueOrError1).<software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput>PropagateFailure(DynamoDbEncryptionUtil_Compile.MaybeKeyId._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput._typeDescriptor());
          return output;
        }
        DynamoDbEncryptionUtil_Compile.MaybeKeyId _3_keyId;
        _3_keyId = (_2_valueOrError1).Extract(DynamoDbEncryptionUtil_Compile.MaybeKeyId._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        DynamoDBFilterExpr_Compile.ExprContext _4_context;
        _4_context = DynamoDBFilterExpr_Compile.ExprContext.create(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), (req).dtor_FilterExpression(), (req).dtor_ExpressionAttributeValues(), (req).dtor_ExpressionAttributeNames());
        Wrappers_Compile.Result<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _5_valueOrError2 = Wrappers_Compile.Result.<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDBFilterExpr_Compile.ExprContext.Default());
        Wrappers_Compile.Result<DynamoDBFilterExpr_Compile.ExprContext, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out1;
        _out1 = DynamoDBFilterExpr_Compile.__default.Beaconize(((search).dtor_value()).curr(), _4_context, _3_keyId, false);
        _5_valueOrError2 = _out1;
        if ((_5_valueOrError2).IsFailure(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          output = (_5_valueOrError2).<software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput>PropagateFailure(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput._typeDescriptor());
          return output;
        }
        DynamoDBFilterExpr_Compile.ExprContext _6_newContext;
        _6_newContext = (_5_valueOrError2).Extract(DynamoDBFilterExpr_Compile.ExprContext._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        DynamoDBFilterExpr_Compile.ExprContext _pat_let_tv0 = _6_newContext;
        DynamoDBFilterExpr_Compile.ExprContext _pat_let_tv1 = _6_newContext;
        DynamoDBFilterExpr_Compile.ExprContext _pat_let_tv2 = _6_newContext;
        output = Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput)(java.lang.Object)(dafny.Helpers.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput, software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput>Let(req, boxed20 -> {
  software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput _pat_let11_0 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput)(java.lang.Object)(boxed20));
  return ((software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput)(java.lang.Object)(dafny.Helpers.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput, software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput>Let(_pat_let11_0, boxed21 -> {
    software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput _7_dt__update__tmp_h0 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput)(java.lang.Object)(boxed21));
    return ((software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>, software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput>Let((_pat_let_tv0).dtor_values(), boxed22 -> {
      Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> _pat_let12_0 = ((Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>)(java.lang.Object)(boxed22));
      return ((software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>, software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput>Let(_pat_let12_0, boxed23 -> {
        Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> _8_dt__update_hExpressionAttributeValues_h0 = ((Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>)(java.lang.Object)(boxed23));
        return ((software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>, software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput>Let((_pat_let_tv1).dtor_names(), boxed24 -> {
          Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _pat_let13_0 = ((Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>)(java.lang.Object)(boxed24));
          return ((software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>, software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput>Let(_pat_let13_0, boxed25 -> {
            Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> _9_dt__update_hExpressionAttributeNames_h0 = ((Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>)(java.lang.Object)(boxed25));
            return ((software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput>Let((_pat_let_tv2).dtor_filterExpr(), boxed26 -> {
              Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _pat_let14_0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>)(java.lang.Object)(boxed26));
              return ((software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput>Let(_pat_let14_0, boxed27 -> {
                Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _10_dt__update_hFilterExpression_h0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>)(java.lang.Object)(boxed27));
                return software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput.create((_7_dt__update__tmp_h0).dtor_TableName(), (_7_dt__update__tmp_h0).dtor_IndexName(), (_7_dt__update__tmp_h0).dtor_AttributesToGet(), (_7_dt__update__tmp_h0).dtor_Limit(), (_7_dt__update__tmp_h0).dtor_Select(), (_7_dt__update__tmp_h0).dtor_ScanFilter(), (_7_dt__update__tmp_h0).dtor_ConditionalOperator(), (_7_dt__update__tmp_h0).dtor_ExclusiveStartKey(), (_7_dt__update__tmp_h0).dtor_ReturnConsumedCapacity(), (_7_dt__update__tmp_h0).dtor_TotalSegments(), (_7_dt__update__tmp_h0).dtor_Segment(), (_7_dt__update__tmp_h0).dtor_ProjectionExpression(), _10_dt__update_hFilterExpression_h0, _9_dt__update_hExpressionAttributeNames_h0, _8_dt__update_hExpressionAttributeValues_h0, (_7_dt__update__tmp_h0).dtor_ConsistentRead());
              }
              )));
            }
            )));
          }
          )));
        }
        )));
      }
      )));
    }
    )));
  }
  )));
}
))));
        return output;
      }
    }
    return output;
  }
  public static Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> ScanOutputForBeacons(Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo> search, software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanInput req, software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput resp)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> ret = Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput.Default());
    if(true) {
      if ((search).is_None()) {
        dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> _0_trimmedItems;
        _0_trimmedItems = Seq_Compile.__default.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>Map(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), ((java.util.function.Function<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>)(_1_i_boxed0) -> {
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _1_i = ((dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>)(java.lang.Object)(_1_i_boxed0));
          return __default.DoRemoveBeacons(_1_i);
        }), ((resp).dtor_Items()).dtor_value());
        dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> _pat_let_tv0 = _0_trimmedItems;
        ret = Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput)(java.lang.Object)(dafny.Helpers.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput>Let(resp, boxed28 -> {
  software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput _pat_let15_0 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput)(java.lang.Object)(boxed28));
  return ((software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput)(java.lang.Object)(dafny.Helpers.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput>Let(_pat_let15_0, boxed29 -> {
    software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput _2_dt__update__tmp_h0 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput)(java.lang.Object)(boxed29));
    return ((software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>>, software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput>Let(Wrappers_Compile.Option.<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>>create_Some(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor())), _pat_let_tv0), boxed30 -> {
      Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>> _pat_let16_0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>>)(java.lang.Object)(boxed30));
      return ((software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>>, software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput>Let(_pat_let16_0, boxed31 -> {
        Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>> _3_dt__update_hItems_h0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>>)(java.lang.Object)(boxed31));
        return software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput.create(_3_dt__update_hItems_h0, (_2_dt__update__tmp_h0).dtor_Count(), (_2_dt__update__tmp_h0).dtor_ScannedCount(), (_2_dt__update__tmp_h0).dtor_LastEvaluatedKey(), (_2_dt__update__tmp_h0).dtor_ConsumedCapacity());
      }
      )));
    }
    )));
  }
  )));
}
))));
        return ret;
      } else {
        Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _4_valueOrError0 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> empty(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor())));
        Wrappers_Compile.Result<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out0;
        _out0 = DynamoDBFilterExpr_Compile.__default.FilterResults(((search).dtor_value()).curr(), ((resp).dtor_Items()).dtor_value(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), (req).dtor_FilterExpression(), (req).dtor_ExpressionAttributeNames(), (req).dtor_ExpressionAttributeValues());
        _4_valueOrError0 = _out0;
        if ((_4_valueOrError0).IsFailure(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          ret = (_4_valueOrError0).<software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput>PropagateFailure(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput._typeDescriptor());
          return ret;
        }
        dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> _5_newItems;
        _5_newItems = (_4_valueOrError0).Extract(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor())), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _6_valueOrError1 = Wrappers_Compile.Outcome.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        _6_valueOrError1 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), java.lang.Long.compareUnsigned((long) (_5_newItems).cardinalityInt(), (StandardLibrary_mUInt_Compile.__default.INT32__MAX__LIMIT()).longValue()) < 0, DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("This is impossible.")));
        if ((_6_valueOrError1).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          ret = (_6_valueOrError1).<software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput._typeDescriptor());
          return ret;
        }
        dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> _7_trimmedItems;
        _7_trimmedItems = Seq_Compile.__default.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>Map(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), ((java.util.function.Function<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>)(_8_i_boxed0) -> {
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _8_i = ((dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>)(java.lang.Object)(_8_i_boxed0));
          return __default.DoRemoveBeacons(_8_i);
        }), _5_newItems);
        Wrappers_Compile.Option<java.lang.Integer> _9_count;
        if (((resp).dtor_Count()).is_Some()) {
          _9_count = Wrappers_Compile.Option.<java.lang.Integer>create_Some(BoundedInts_Compile.int32._typeDescriptor(), (_7_trimmedItems).cardinalityInt());
        } else {
          _9_count = Wrappers_Compile.Option.<java.lang.Integer>create_None(BoundedInts_Compile.int32._typeDescriptor());
        }
        Wrappers_Compile.Option<java.lang.Integer> _pat_let_tv1 = _9_count;
        dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> _pat_let_tv2 = _7_trimmedItems;
        ret = Wrappers_Compile.Result.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput)(java.lang.Object)(dafny.Helpers.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput>Let(resp, boxed32 -> {
  software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput _pat_let17_0 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput)(java.lang.Object)(boxed32));
  return ((software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput)(java.lang.Object)(dafny.Helpers.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput, software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput>Let(_pat_let17_0, boxed33 -> {
    software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput _10_dt__update__tmp_h1 = ((software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput)(java.lang.Object)(boxed33));
    return ((software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<java.lang.Integer>, software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput>Let(_pat_let_tv1, boxed34 -> {
      Wrappers_Compile.Option<java.lang.Integer> _pat_let18_0 = ((Wrappers_Compile.Option<java.lang.Integer>)(java.lang.Object)(boxed34));
      return ((software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<java.lang.Integer>, software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput>Let(_pat_let18_0, boxed35 -> {
        Wrappers_Compile.Option<java.lang.Integer> _11_dt__update_hCount_h0 = ((Wrappers_Compile.Option<java.lang.Integer>)(java.lang.Object)(boxed35));
        return ((software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>>, software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput>Let(Wrappers_Compile.Option.<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>>create_Some(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor())), _pat_let_tv2), boxed36 -> {
          Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>> _pat_let19_0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>>)(java.lang.Object)(boxed36));
          return ((software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>>, software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput>Let(_pat_let19_0, boxed37 -> {
            Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>> _12_dt__update_hItems_h1 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>>)(java.lang.Object)(boxed37));
            return software.amazon.cryptography.services.dynamodb.internaldafny.types.ScanOutput.create(_12_dt__update_hItems_h1, _11_dt__update_hCount_h0, (_10_dt__update__tmp_h1).dtor_ScannedCount(), (_10_dt__update__tmp_h1).dtor_LastEvaluatedKey(), (_10_dt__update__tmp_h1).dtor_ConsumedCapacity());
          }
          )));
        }
        )));
      }
      )));
    }
    )));
  }
  )));
}
))));
        return ret;
      }
    }
    return ret;
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GetVirtualFieldsLoop(dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> fields, SearchableEncryptionInfo_Compile.BeaconVersion bv, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>> results)
  {
    TAIL_CALL_START: while (true) {
      if ((((long) (fields).cardinalityInt()) == 0 ? 0 : 1) == 0) {
        return Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), results);
      } else {
        Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = DdbVirtualFields_Compile.__default.GetVirtField(((DdbVirtualFields_Compile.VirtField)(java.lang.Object)(((bv).dtor_virtualFields()).get(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((fields).select(0)))))), item);
        if ((_0_valueOrError0).IsFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          return (_0_valueOrError0).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>PropagateFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
        } else {
          Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _1_optValue = (_0_valueOrError0).Extract(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
          if ((_1_optValue).is_Some()) {
            dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in0 = (fields).drop(1);
            SearchableEncryptionInfo_Compile.BeaconVersion _in1 = bv;
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _in2 = item;
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>> _in3 = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>update(results, ((dafny.DafnySequence<? extends Character>)(java.lang.Object)((fields).select(0))), (_1_optValue).dtor_value());
            fields = _in0;
            bv = _in1;
            item = _in2;
            results = _in3;
            continue TAIL_CALL_START;
          } else {
            dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in4 = (fields).drop(1);
            SearchableEncryptionInfo_Compile.BeaconVersion _in5 = bv;
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _in6 = item;
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>> _in7 = results;
            fields = _in4;
            bv = _in5;
            item = _in6;
            results = _in7;
            continue TAIL_CALL_START;
          }
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GetVirtualFields(SearchableEncryptionInfo_Compile.BeaconVersion beaconVersion, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,dafny.DafnySequence<? extends Character>> empty());
    if(true) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _0_fieldNames;
      _0_fieldNames = SortedSets.__default.<Character>SetToOrderedSequence2(dafny.TypeDescriptor.CHAR, ((beaconVersion).dtor_virtualFields()).keySet(), DynamoDbEncryptionUtil_Compile.__default::CharLess);
      output = __default.GetVirtualFieldsLoop(_0_fieldNames, beaconVersion, item, dafny.DafnyMap.fromElements());
    }
    return output;
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GetCompoundBeaconsLoop(dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> fields, SearchableEncryptionInfo_Compile.BeaconVersion bv, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>> results)
  {
    TAIL_CALL_START: while (true) {
      if ((((long) (fields).cardinalityInt()) == 0 ? 0 : 1) == 0) {
        return Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), results);
      } else {
        SearchableEncryptionInfo_Compile.Beacon _0_beacon = ((SearchableEncryptionInfo_Compile.Beacon)(java.lang.Object)(((bv).dtor_beacons()).get(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((fields).select(0))))));
        if ((_0_beacon).is_Compound()) {
          Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _1_valueOrError0 = ((_0_beacon).dtor_cmp()).getNaked(item, (bv).dtor_virtualFields());
          if ((_1_valueOrError0).IsFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
            return (_1_valueOrError0).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>PropagateFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
          } else {
            Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _2_optValue = (_1_valueOrError0).Extract(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
            if ((_2_optValue).is_Some()) {
              dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in0 = (fields).drop(1);
              SearchableEncryptionInfo_Compile.BeaconVersion _in1 = bv;
              dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _in2 = item;
              dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>> _in3 = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>update(results, ((dafny.DafnySequence<? extends Character>)(java.lang.Object)((fields).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), (_2_optValue).dtor_value());
              fields = _in0;
              bv = _in1;
              item = _in2;
              results = _in3;
              continue TAIL_CALL_START;
            } else {
              dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in4 = (fields).drop(1);
              SearchableEncryptionInfo_Compile.BeaconVersion _in5 = bv;
              dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _in6 = item;
              dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>> _in7 = results;
              fields = _in4;
              bv = _in5;
              item = _in6;
              results = _in7;
              continue TAIL_CALL_START;
            }
          }
        } else {
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in8 = (fields).drop(1);
          SearchableEncryptionInfo_Compile.BeaconVersion _in9 = bv;
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _in10 = item;
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>> _in11 = results;
          fields = _in8;
          bv = _in9;
          item = _in10;
          results = _in11;
          continue TAIL_CALL_START;
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GetCompoundBeacons(SearchableEncryptionInfo_Compile.BeaconVersion beaconVersion, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,dafny.DafnySequence<? extends Character>> empty());
    if(true) {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _0_beaconNames;
      _0_beaconNames = SortedSets.__default.<Character>SetToOrderedSequence2(dafny.TypeDescriptor.CHAR, ((beaconVersion).dtor_beacons()).keySet(), DynamoDbEncryptionUtil_Compile.__default::CharLess);
      output = __default.GetCompoundBeaconsLoop(_0_beaconNames, beaconVersion, item, dafny.DafnyMap.fromElements());
    }
    return output;
  }
  public static dafny.DafnySequence<? extends Character> VersionTag()
  {
    return dafny.DafnySequence.<Character>concatenate(DynamoDbEncryptionUtil_Compile.__default.VersionPrefix(), dafny.DafnySequence.asString("1"));
  }
  @Override
  public java.lang.String toString() {
    return "DynamoDBSupport._default";
  }
}
