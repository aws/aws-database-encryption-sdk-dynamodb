// Class __default
// Dafny class __default compiled into Java
package SearchConfigToInfo_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static Wrappers_Compile.Result<Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> Convert(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig outer)
  {
    Wrappers_Compile.Result<Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> output = Wrappers_Compile.Result.<Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.SearchInfo>_typeDescriptor(SearchableEncryptionInfo_Compile.ValidSearchInfo._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.SearchInfo>Default(SearchableEncryptionInfo_Compile.ValidSearchInfo._typeDescriptor()));
    if(true) {
      if (((outer).dtor_search()).is_None()) {
        output = Wrappers_Compile.Result.<Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.SearchInfo>_typeDescriptor(SearchableEncryptionInfo_Compile.ValidSearchInfo._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.SearchInfo>create_None(SearchableEncryptionInfo_Compile.ValidSearchInfo._typeDescriptor()));
        return output;
      } else {
        Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = Wrappers_Compile.Outcome.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        _0_valueOrError0 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((((outer).dtor_search()).dtor_value()).dtor_writeVersion()) == (1), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("writeVersion must be '1'.")));
        if ((_0_valueOrError0).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          output = (_0_valueOrError0).<Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.SearchInfo>_typeDescriptor(SearchableEncryptionInfo_Compile.ValidSearchInfo._typeDescriptor()));
          return output;
        }
        Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _1_valueOrError1 = Wrappers_Compile.Outcome.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        _1_valueOrError1 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), java.util.Objects.equals(java.math.BigInteger.valueOf(((((outer).dtor_search()).dtor_value()).dtor_versions()).length()), java.math.BigInteger.ONE), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("search config must be have exactly one version.")));
        if ((_1_valueOrError1).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          output = (_1_valueOrError1).<Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.SearchInfo>_typeDescriptor(SearchableEncryptionInfo_Compile.ValidSearchInfo._typeDescriptor()));
          return output;
        }
        software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _2_beaconVersionConfig;
        _2_beaconVersionConfig = ((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion)(java.lang.Object)(((((outer).dtor_search()).dtor_value()).dtor_versions()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))));
        Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _3_valueOrError2 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
        Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out0;
        _out0 = __default.ConvertVersion(outer, _2_beaconVersionConfig);
        _3_valueOrError2 = _out0;
        if ((_3_valueOrError2).IsFailure(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          output = (_3_valueOrError2).<Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo>>PropagateFailure(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.SearchInfo>_typeDescriptor(SearchableEncryptionInfo_Compile.ValidSearchInfo._typeDescriptor()));
          return output;
        }
        SearchableEncryptionInfo_Compile.BeaconVersion _4_version;
        _4_version = (_3_valueOrError2).Extract(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        SearchableEncryptionInfo_Compile.SearchInfo _5_info;
        _5_info = SearchableEncryptionInfo_Compile.__default.MakeSearchInfo(_4_version);
        output = Wrappers_Compile.Result.<Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.SearchInfo>_typeDescriptor(SearchableEncryptionInfo_Compile.ValidSearchInfo._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.SearchInfo>create_Some(SearchableEncryptionInfo_Compile.ValidSearchInfo._typeDescriptor(), _5_info));
        return output;
      }
    }
    return output;
  }
  public static Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> ShouldDeleteKeyField(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig outer, dafny.DafnySequence<? extends Character> keyFieldName)
  {
    if (!((outer).dtor_attributeActionsOnEncrypt()).<dafny.DafnySequence<? extends Character>>contains(keyFieldName)) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    } else {
      software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction _source0 = ((software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction)(java.lang.Object)(((outer).dtor_attributeActionsOnEncrypt()).get(keyFieldName)));
      if (_source0.is_ENCRYPT__AND__SIGN()) {
        return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Beacon key field name "), keyFieldName), dafny.DafnySequence.asString(" is configured as ENCRYPT_AND_SIGN which is not allowed."))));
      } else if (_source0.is_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT()) {
        return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), false);
      } else if (_source0.is_SIGN__ONLY()) {
        return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), false);
      } else {
        return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
      }
    }
  }
  public static Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> MakeKeySource(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig outer, software.amazon.cryptography.keystore.internaldafny.types.IKeyStoreClient keyStore, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconKeySource config, software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient client)
  {
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> output = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _0_mplR;
      Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _out0;
      _out0 = software.amazon.cryptography.materialproviders.internaldafny.__default.MaterialProviders(software.amazon.cryptography.materialproviders.internaldafny.__default.DefaultMaterialProvidersConfig());
      _0_mplR = _out0;
      Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _1_valueOrError0 = (Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
      _1_valueOrError0 = (_0_mplR).<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>MapFailure(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient.class)), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<software.amazon.cryptography.materialproviders.internaldafny.types.Error, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)(_2_e_boxed0) -> {
        software.amazon.cryptography.materialproviders.internaldafny.types.Error _2_e = ((software.amazon.cryptography.materialproviders.internaldafny.types.Error)(java.lang.Object)(_2_e_boxed0));
        return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error.create_AwsCryptographyMaterialProviders(_2_e);
      }));
      if ((_1_valueOrError0).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        output = (_1_valueOrError0).<SearchableEncryptionInfo_Compile.KeySource>PropagateFailure(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.KeySource._typeDescriptor());
        return output;
      }
      software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient _3_mpl;
      _3_mpl = (_1_valueOrError0).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      software.amazon.cryptography.materialproviders.internaldafny.types.CacheType _4_cacheType;
      if ((config).is_multi()) {
        if ((((config).dtor_multi()).dtor_cache()).is_Some()) {
          _4_cacheType = (((config).dtor_multi()).dtor_cache()).dtor_value();
        } else {
          _4_cacheType = software.amazon.cryptography.materialproviders.internaldafny.types.CacheType.create_Default(software.amazon.cryptography.materialproviders.internaldafny.types.DefaultCache.create(1000));
        }
      } else if ((((config).dtor_single()).dtor_cache()).is_Some()) {
        _4_cacheType = (((config).dtor_single()).dtor_cache()).dtor_value();
      } else {
        _4_cacheType = software.amazon.cryptography.materialproviders.internaldafny.types.CacheType.create_Default(software.amazon.cryptography.materialproviders.internaldafny.types.DefaultCache.create(1));
      }
      software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache _5_cache = null;
      if ((_4_cacheType).is_Shared()) {
        _5_cache = (_4_cacheType).dtor_Shared();
      } else {
        software.amazon.cryptography.materialproviders.internaldafny.types.CreateCryptographicMaterialsCacheInput _6_input;
        _6_input = software.amazon.cryptography.materialproviders.internaldafny.types.CreateCryptographicMaterialsCacheInput.create(_4_cacheType);
        Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _7_maybeCache;
        Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _out1;
        _out1 = (_3_mpl).CreateCryptographicMaterialsCache(_6_input);
        _7_maybeCache = _out1;
        Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _8_valueOrError1 = (Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
        _8_valueOrError1 = (_7_maybeCache).<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>MapFailure(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache.class)), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<software.amazon.cryptography.materialproviders.internaldafny.types.Error, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)(_9_e_boxed0) -> {
          software.amazon.cryptography.materialproviders.internaldafny.types.Error _9_e = ((software.amazon.cryptography.materialproviders.internaldafny.types.Error)(java.lang.Object)(_9_e_boxed0));
          return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error.create_AwsCryptographyMaterialProviders(_9_e);
        }));
        if ((_8_valueOrError1).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          output = (_8_valueOrError1).<SearchableEncryptionInfo_Compile.KeySource>PropagateFailure(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.KeySource._typeDescriptor());
          return output;
        }
        _5_cache = (_8_valueOrError1).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsCache.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      }
      dafny.DafnySequence<? extends java.lang.Byte> _10_partitionIdBytes = dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor());
      if (((config).is_multi()) && ((((config).dtor_multi()).dtor_partitionId()).is_Some())) {
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _11_valueOrError2 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(UTF8.ValidUTF8Bytes._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), UTF8.ValidUTF8Bytes.defaultValue());
        _11_valueOrError2 = (UTF8.__default.Encode((((config).dtor_multi()).dtor_partitionId()).dtor_value())).<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>MapFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)(_12_e_boxed0) -> {
          dafny.DafnySequence<? extends Character> _12_e = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_12_e_boxed0));
          return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error.create_DynamoDbEncryptionException(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Could not UTF-8 Encode Partition ID from MultiKeyStore: "), _12_e));
        }));
        if ((_11_valueOrError2).IsFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          output = (_11_valueOrError2).<SearchableEncryptionInfo_Compile.KeySource>PropagateFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.KeySource._typeDescriptor());
          return output;
        }
        _10_partitionIdBytes = (_11_valueOrError2).Extract(UTF8.ValidUTF8Bytes._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      } else if (((config).is_single()) && ((((config).dtor_single()).dtor_partitionId()).is_Some())) {
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _13_valueOrError3 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(UTF8.ValidUTF8Bytes._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), UTF8.ValidUTF8Bytes.defaultValue());
        _13_valueOrError3 = (UTF8.__default.Encode((((config).dtor_single()).dtor_partitionId()).dtor_value())).<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>MapFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)(_14_e_boxed0) -> {
          dafny.DafnySequence<? extends Character> _14_e = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_14_e_boxed0));
          return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error.create_DynamoDbEncryptionException(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Could not UTF-8 Encode Partition ID from SingleKeyStore: "), _14_e));
        }));
        if ((_13_valueOrError3).IsFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          output = (_13_valueOrError3).<SearchableEncryptionInfo_Compile.KeySource>PropagateFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.KeySource._typeDescriptor());
          return output;
        }
        _10_partitionIdBytes = (_13_valueOrError3).Extract(UTF8.ValidUTF8Bytes._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      } else {
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _15_valueOrError4 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
        _out2 = SearchableEncryptionInfo_Compile.__default.GenerateUuidBytes();
        _15_valueOrError4 = _out2;
        if ((_15_valueOrError4).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          output = (_15_valueOrError4).<SearchableEncryptionInfo_Compile.KeySource>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.KeySource._typeDescriptor());
          return output;
        }
        _10_partitionIdBytes = (_15_valueOrError4).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      }
      Wrappers_Compile.Result<software.amazon.cryptography.keystore.internaldafny.types.GetKeyStoreInfoOutput, software.amazon.cryptography.keystore.internaldafny.types.Error> _16_getKeyStoreInfoOutput_q;
      Wrappers_Compile.Result<software.amazon.cryptography.keystore.internaldafny.types.GetKeyStoreInfoOutput, software.amazon.cryptography.keystore.internaldafny.types.Error> _out3;
      _out3 = (keyStore).GetKeyStoreInfo();
      _16_getKeyStoreInfoOutput_q = _out3;
      Wrappers_Compile.Result<software.amazon.cryptography.keystore.internaldafny.types.GetKeyStoreInfoOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _17_valueOrError5 = (Wrappers_Compile.Result<software.amazon.cryptography.keystore.internaldafny.types.GetKeyStoreInfoOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
      _17_valueOrError5 = (_16_getKeyStoreInfoOutput_q).<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>MapFailure(software.amazon.cryptography.keystore.internaldafny.types.GetKeyStoreInfoOutput._typeDescriptor(), software.amazon.cryptography.keystore.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<software.amazon.cryptography.keystore.internaldafny.types.Error, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)(_18_e_boxed0) -> {
        software.amazon.cryptography.keystore.internaldafny.types.Error _18_e = ((software.amazon.cryptography.keystore.internaldafny.types.Error)(java.lang.Object)(_18_e_boxed0));
        return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error.create_AwsCryptographyKeyStore(_18_e);
      }));
      if ((_17_valueOrError5).IsFailure(software.amazon.cryptography.keystore.internaldafny.types.GetKeyStoreInfoOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        output = (_17_valueOrError5).<SearchableEncryptionInfo_Compile.KeySource>PropagateFailure(software.amazon.cryptography.keystore.internaldafny.types.GetKeyStoreInfoOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.KeySource._typeDescriptor());
        return output;
      }
      software.amazon.cryptography.keystore.internaldafny.types.GetKeyStoreInfoOutput _19_getKeyStoreInfoOutput;
      _19_getKeyStoreInfoOutput = (_17_valueOrError5).Extract(software.amazon.cryptography.keystore.internaldafny.types.GetKeyStoreInfoOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      dafny.DafnySequence<? extends Character> _20_logicalKeyStoreName;
      _20_logicalKeyStoreName = (_19_getKeyStoreInfoOutput).dtor_logicalKeyStoreName();
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _21_valueOrError6 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(UTF8.ValidUTF8Bytes._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), UTF8.ValidUTF8Bytes.defaultValue());
      _21_valueOrError6 = (UTF8.__default.Encode(_20_logicalKeyStoreName)).<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>MapFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)(_22_e_boxed0) -> {
        dafny.DafnySequence<? extends Character> _22_e = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_22_e_boxed0));
        return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error.create_DynamoDbEncryptionException(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Could not UTF-8 Encode Logical Key Store Name: "), _22_e));
      }));
      if ((_21_valueOrError6).IsFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        output = (_21_valueOrError6).<SearchableEncryptionInfo_Compile.KeySource>PropagateFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.KeySource._typeDescriptor());
        return output;
      }
      dafny.DafnySequence<? extends java.lang.Byte> _23_logicalKeyStoreNameBytes;
      _23_logicalKeyStoreNameBytes = (_21_valueOrError6).Extract(UTF8.ValidUTF8Bytes._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      if ((config).is_multi()) {
        Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _24_valueOrError7 = Wrappers_Compile.Outcome.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        _24_valueOrError7 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), java.lang.Integer.signum((((config).dtor_multi()).dtor_cacheTTL())) == 1, DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Beacon Cache TTL must be at least 1.")));
        if ((_24_valueOrError7).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          output = (_24_valueOrError7).<SearchableEncryptionInfo_Compile.KeySource>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.KeySource._typeDescriptor());
          return output;
        }
        Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _25_valueOrError8 = Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), false);
        _25_valueOrError8 = __default.ShouldDeleteKeyField(outer, ((config).dtor_multi()).dtor_keyFieldName());
        if ((_25_valueOrError8).IsFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          output = (_25_valueOrError8).<SearchableEncryptionInfo_Compile.KeySource>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.KeySource._typeDescriptor());
          return output;
        }
        boolean _26_deleteKey;
        _26_deleteKey = (_25_valueOrError8).Extract(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        output = Wrappers_Compile.Result.<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(SearchableEncryptionInfo_Compile.KeySource._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.KeySource.create(client, keyStore, SearchableEncryptionInfo_Compile.KeyLocation.create_MultiLoc(((config).dtor_multi()).dtor_keyFieldName(), _26_deleteKey), _5_cache, (((config).dtor_multi()).dtor_cacheTTL()), _10_partitionIdBytes, _23_logicalKeyStoreNameBytes));
      } else {
        Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _27_valueOrError9 = Wrappers_Compile.Outcome.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        _27_valueOrError9 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), java.lang.Integer.signum((((config).dtor_single()).dtor_cacheTTL())) == 1, DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Beacon Cache TTL must be at least 1.")));
        if ((_27_valueOrError9).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          output = (_27_valueOrError9).<SearchableEncryptionInfo_Compile.KeySource>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.KeySource._typeDescriptor());
          return output;
        }
        output = Wrappers_Compile.Result.<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(SearchableEncryptionInfo_Compile.KeySource._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.KeySource.create(client, keyStore, SearchableEncryptionInfo_Compile.KeyLocation.create_SingleLoc(((config).dtor_single()).dtor_keyId()), _5_cache, (((config).dtor_single()).dtor_cacheTTL()), _10_partitionIdBytes, _23_logicalKeyStoreNameBytes));
      }
    }
    return output;
  }
  public static Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> ConvertVersion(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig outer, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion config)
  {
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> output = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    if(true) {
      Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = Wrappers_Compile.Outcome.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      _0_valueOrError0 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((config).dtor_version()) == (1), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Version number in BeaconVersion must be '1'.")));
      if ((_0_valueOrError0).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        output = (_0_valueOrError0).<SearchableEncryptionInfo_Compile.BeaconVersion>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor());
        return output;
      }
      Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _1_valueOrError1 = Wrappers_Compile.Outcome.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      _1_valueOrError1 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), (java.math.BigInteger.valueOf(((config).dtor_standardBeacons()).length())).signum() == 1, DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("At least one standard beacon must be configured.")));
      if ((_1_valueOrError1).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        output = (_1_valueOrError1).<SearchableEncryptionInfo_Compile.BeaconVersion>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor());
        return output;
      }
      Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.primitives.internaldafny.types.Error> _2_maybePrimitives;
      Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.primitives.internaldafny.types.Error> _out0;
      _out0 = software.amazon.cryptography.primitives.internaldafny.__default.AtomicPrimitives(software.amazon.cryptography.primitives.internaldafny.__default.DefaultCryptoConfig());
      _2_maybePrimitives = _out0;
      Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _3_valueOrError2 = (Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
      _3_valueOrError2 = (_2_maybePrimitives).<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>MapFailure(((dafny.TypeDescriptor<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient.class)), software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<software.amazon.cryptography.primitives.internaldafny.types.Error, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)(_4_e_boxed0) -> {
        software.amazon.cryptography.primitives.internaldafny.types.Error _4_e = ((software.amazon.cryptography.primitives.internaldafny.types.Error)(java.lang.Object)(_4_e_boxed0));
        return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error.create_AwsCryptographyPrimitives(_4_e);
      }));
      if ((_3_valueOrError2).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        output = (_3_valueOrError2).<SearchableEncryptionInfo_Compile.BeaconVersion>PropagateFailure(((dafny.TypeDescriptor<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor());
        return output;
      }
      software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient _5_primitives;
      _5_primitives = (_3_valueOrError2).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _6_valueOrError3 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
      Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out1;
      _out1 = __default.MakeKeySource(outer, (config).dtor_keyStore(), (config).dtor_keySource(), _5_primitives);
      _6_valueOrError3 = _out1;
      if ((_6_valueOrError3).IsFailure(SearchableEncryptionInfo_Compile.KeySource._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        output = (_6_valueOrError3).<SearchableEncryptionInfo_Compile.BeaconVersion>PropagateFailure(SearchableEncryptionInfo_Compile.KeySource._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor());
        return output;
      }
      SearchableEncryptionInfo_Compile.KeySource _7_source;
      _7_source = (_6_valueOrError3).Extract(SearchableEncryptionInfo_Compile.KeySource._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
      _out2 = __default.ConvertVersionWithSource(outer, config, _7_source);
      output = _out2;
    }
    return output;
  }
  public static Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> ConvertVersionWithSource(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig outer, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion config, SearchableEncryptionInfo_Compile.KeySource source)
  {
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> output = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(DdbVirtualFields_Compile.VirtualFieldMap._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,DdbVirtualFields_Compile.VirtField> empty());
    _0_valueOrError0 = __default.ConvertVirtualFields(outer, (config).dtor_virtualFields());
    if ((_0_valueOrError0).IsFailure(DdbVirtualFields_Compile.VirtualFieldMap._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
      output = (_0_valueOrError0).<SearchableEncryptionInfo_Compile.BeaconVersion>PropagateFailure(DdbVirtualFields_Compile.VirtualFieldMap._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor());
      return output;
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> _1_virtualFields;
    _1_virtualFields = (_0_valueOrError0).Extract(DdbVirtualFields_Compile.VirtualFieldMap._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _2_valueOrError1 = (Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out0;
    _out0 = __default.AddStandardBeacons((config).dtor_standardBeacons(), outer, (source).dtor_client(), _1_virtualFields, dafny.DafnyMap.fromElements());
    _2_valueOrError1 = _out0;
    if ((_2_valueOrError1).IsFailure(SearchableEncryptionInfo_Compile.BeaconMap._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
      output = (_2_valueOrError1).<SearchableEncryptionInfo_Compile.BeaconVersion>PropagateFailure(SearchableEncryptionInfo_Compile.BeaconMap._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor());
      return output;
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon> _3_std;
    _3_std = (_2_valueOrError1).Extract(SearchableEncryptionInfo_Compile.BeaconMap._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart> _4_signed;
    if (((config).dtor_signedParts()).is_Some()) {
      _4_signed = ((config).dtor_signedParts()).dtor_value();
    } else {
      _4_signed = dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart> empty(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart._typeDescriptor());
    }
    Wrappers_Compile.Result<PartSet, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _5_valueOrError2 = Wrappers_Compile.Result.<PartSet, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), PartSet.Default());
    _5_valueOrError2 = __default.GetSignedParts(_4_signed, outer, dafny.DafnySequence.asString("Global Parts List"), PartSet.create(dafny.DafnySequence.<CompoundBeacon_Compile.BeaconPart> empty(CompoundBeacon_Compile.BeaconPart._typeDescriptor()), dafny.DafnySet.<dafny.DafnySequence<? extends Character>> empty(), dafny.DafnySet.<dafny.DafnySequence<? extends Character>> empty()));
    if ((_5_valueOrError2).IsFailure(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
      output = (_5_valueOrError2).<SearchableEncryptionInfo_Compile.BeaconVersion>PropagateFailure(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor());
      return output;
    }
    PartSet _6_globalSignedParts;
    _6_globalSignedParts = (_5_valueOrError2).Extract(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    PartSet _7_globalEncryptedParts;
    _7_globalEncryptedParts = PartSet.create(dafny.DafnySequence.<CompoundBeacon_Compile.BeaconPart> empty(CompoundBeacon_Compile.BeaconPart._typeDescriptor()), dafny.DafnySet.<dafny.DafnySequence<? extends Character>> empty(), dafny.DafnySet.<dafny.DafnySequence<? extends Character>> empty());
    if (((config).dtor_encryptedParts()).is_Some()) {
      Wrappers_Compile.Result<PartSet, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _8_valueOrError3 = Wrappers_Compile.Result.<PartSet, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), PartSet.Default());
      _8_valueOrError3 = __default.GetEncryptedParts(((config).dtor_encryptedParts()).dtor_value(), _3_std, dafny.DafnySequence.asString("Global Parts List"), PartSet.create(dafny.DafnySequence.<CompoundBeacon_Compile.BeaconPart> empty(CompoundBeacon_Compile.BeaconPart._typeDescriptor()), dafny.DafnySet.<dafny.DafnySequence<? extends Character>> empty(), dafny.DafnySet.<dafny.DafnySequence<? extends Character>> empty()));
      if ((_8_valueOrError3).IsFailure(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        output = (_8_valueOrError3).<SearchableEncryptionInfo_Compile.BeaconVersion>PropagateFailure(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor());
        return output;
      }
      _7_globalEncryptedParts = (_8_valueOrError3).Extract(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon> _9_beacons = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,SearchableEncryptionInfo_Compile.Beacon> empty();
    if (((config).dtor_compoundBeacons()).is_Some()) {
      Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _10_valueOrError4 = (Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
      Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out1;
      _out1 = __default.AddCompoundBeacons(((config).dtor_compoundBeacons()).dtor_value(), outer, (source).dtor_client(), _1_virtualFields, _3_std, _6_globalSignedParts, _7_globalEncryptedParts);
      _10_valueOrError4 = _out1;
      if ((_10_valueOrError4).IsFailure(SearchableEncryptionInfo_Compile.BeaconMap._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        output = (_10_valueOrError4).<SearchableEncryptionInfo_Compile.BeaconVersion>PropagateFailure(SearchableEncryptionInfo_Compile.BeaconMap._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor());
        return output;
      }
      _9_beacons = (_10_valueOrError4).Extract(SearchableEncryptionInfo_Compile.BeaconMap._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    } else {
      _9_beacons = _3_std;
    }
    Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _11_valueOrError5 = Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), false);
    _11_valueOrError5 = __default.CheckBeacons(_9_beacons);
    if ((_11_valueOrError5).IsFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
      output = (_11_valueOrError5).<SearchableEncryptionInfo_Compile.BeaconVersion>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor());
      return output;
    }
    boolean _12___v0;
    _12___v0 = (_11_valueOrError5).Extract(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    if (((source).dtor_keyLoc()).is_MultiLoc()) {
      dafny.DafnySequence<? extends Character> _13_name;
      _13_name = ((source).dtor_keyLoc()).dtor_keyName();
      if ((_9_beacons).<dafny.DafnySequence<? extends Character>>contains(_13_name)) {
        output = Wrappers_Compile.Result.<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("A beacon key field name of "), _13_name), dafny.DafnySequence.asString(" was configured, but there's also a beacon of that name."))));
        return output;
      }
      if ((_1_virtualFields).<dafny.DafnySequence<? extends Character>>contains(_13_name)) {
        output = Wrappers_Compile.Result.<SearchableEncryptionInfo_Compile.BeaconVersion, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("A beacon key field name of "), _13_name), dafny.DafnySequence.asString(" was configured, but there's also a virtual field of that name."))));
        return output;
      }
    }
    output = SearchableEncryptionInfo_Compile.__default.MakeBeaconVersion(((byte) ((config).dtor_version())), source, _9_beacons, _1_virtualFields, (outer).dtor_attributeActionsOnEncrypt());
    return output;
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> ConvertVirtualFields(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig outer, Wrappers_Compile.Option<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField>> vf)
  {
    if ((vf).is_None()) {
      return Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, DdbVirtualFields_Compile.VirtField>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), DdbVirtualFields_Compile.ValidVirtualField._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.fromElements());
    } else {
      return __default.AddVirtualFields((vf).dtor_value(), outer, dafny.DafnyMap.fromElements());
    }
  }
  public static boolean IsSigned(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig outer, dafny.DafnySequence<? extends TermLoc_Compile.Selector> loc)
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig _pat_let_tv0 = outer;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig _pat_let_tv1 = outer;
    return (true) && (((boolean)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Character>, Boolean>Let((((TermLoc_Compile.Selector)(java.lang.Object)((loc).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key(), boxed38 -> {
      dafny.DafnySequence<? extends Character> _pat_let20_0 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(boxed38));
      return ((boolean)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Character>, Boolean>Let(_pat_let20_0, boxed39 -> {
        dafny.DafnySequence<? extends Character> _0_name = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(boxed39));
        return (((_pat_let_tv0).dtor_attributeActionsOnEncrypt()).<dafny.DafnySequence<? extends Character>>contains(_0_name)) && (!java.util.Objects.equals(((software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction)(java.lang.Object)(((_pat_let_tv1).dtor_attributeActionsOnEncrypt()).get(_0_name))), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_DO__NOTHING()));
      }
      )));
    }
    ))));
  }
  public static boolean IsSignOnly(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig outer, dafny.DafnySequence<? extends TermLoc_Compile.Selector> loc)
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig _pat_let_tv0 = outer;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig _pat_let_tv1 = outer;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig _pat_let_tv2 = outer;
    return (true) && (((boolean)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Character>, Boolean>Let((((TermLoc_Compile.Selector)(java.lang.Object)((loc).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key(), boxed40 -> {
      dafny.DafnySequence<? extends Character> _pat_let21_0 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(boxed40));
      return ((boolean)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Character>, Boolean>Let(_pat_let21_0, boxed41 -> {
        dafny.DafnySequence<? extends Character> _0_name = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(boxed41));
        return (((_pat_let_tv0).dtor_attributeActionsOnEncrypt()).<dafny.DafnySequence<? extends Character>>contains(_0_name)) && ((java.util.Objects.equals(((software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction)(java.lang.Object)(((_pat_let_tv1).dtor_attributeActionsOnEncrypt()).get(_0_name))), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT())) || (java.util.Objects.equals(((software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction)(java.lang.Object)(((_pat_let_tv2).dtor_attributeActionsOnEncrypt()).get(_0_name))), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__ONLY())));
      }
      )));
    }
    ))));
  }
  public static boolean IsEncrypted(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig outer, dafny.DafnySequence<? extends TermLoc_Compile.Selector> loc)
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig _pat_let_tv0 = outer;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig _pat_let_tv1 = outer;
    return (true) && (((boolean)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Character>, Boolean>Let((((TermLoc_Compile.Selector)(java.lang.Object)((loc).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key(), boxed42 -> {
      dafny.DafnySequence<? extends Character> _pat_let22_0 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(boxed42));
      return ((boolean)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Character>, Boolean>Let(_pat_let22_0, boxed43 -> {
        dafny.DafnySequence<? extends Character> _0_name = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(boxed43));
        return (((_pat_let_tv0).dtor_attributeActionsOnEncrypt()).<dafny.DafnySequence<? extends Character>>contains(_0_name)) && (java.util.Objects.equals(((software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction)(java.lang.Object)(((_pat_let_tv1).dtor_attributeActionsOnEncrypt()).get(_0_name))), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN()));
      }
      )));
    }
    ))));
  }
  public static boolean IsEncryptedV(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig outer, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> virtualFields, dafny.DafnySequence<? extends TermLoc_Compile.Selector> loc)
  {
    return (__default.IsEncrypted(outer, loc)) || (((virtualFields).<dafny.DafnySequence<? extends Character>>contains((((TermLoc_Compile.Selector)(java.lang.Object)((loc).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key())) && ((((DdbVirtualFields_Compile.VirtField)(java.lang.Object)((virtualFields).get((((TermLoc_Compile.Selector)(java.lang.Object)((loc).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key())))).examine(((java.util.function.Function<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig, java.util.function.Function<dafny.DafnySequence<? extends TermLoc_Compile.Selector>, Boolean>>)(_0_outer) -> ((java.util.function.Function<dafny.DafnySequence<? extends TermLoc_Compile.Selector>, Boolean>)(_1_t_boxed0) -> {
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _1_t = ((dafny.DafnySequence<? extends TermLoc_Compile.Selector>)(java.lang.Object)(_1_t_boxed0));
      return __default.IsEncrypted(_0_outer, _1_t);
    })).apply(outer))));
  }
  public static Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> BeaconNameAllowed(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig outer, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> virtualFields, dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends Character> context, boolean isSignedBeacon)
  {
    if ((((outer).dtor_attributeActionsOnEncrypt()).<dafny.DafnySequence<? extends Character>>contains(name)) && (!java.util.Objects.equals(((software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction)(java.lang.Object)(((outer).dtor_attributeActionsOnEncrypt()).get(name))), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN()))) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(name, dafny.DafnySequence.asString(" not allowed as a ")), context), dafny.DafnySequence.asString(" because it is already an unencrypted attribute."))));
    } else if ((isSignedBeacon) && (((outer).dtor_attributeActionsOnEncrypt()).<dafny.DafnySequence<? extends Character>>contains(name))) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(name, dafny.DafnySequence.asString(" not allowed as a ")), context), dafny.DafnySequence.asString(" because a fully signed beacon cannot have the same name as an existing attribute."))));
    } else if ((((outer).dtor_allowedUnsignedAttributes()).is_Some()) && ((((outer).dtor_allowedUnsignedAttributes()).dtor_value()).contains(name))) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(name, dafny.DafnySequence.asString(" not allowed as a ")), context), dafny.DafnySequence.asString(" because it is already an allowed unauthenticated attribute."))));
    } else if ((((outer).dtor_allowedUnsignedAttributePrefix()).is_Some()) && ((((outer).dtor_allowedUnsignedAttributePrefix()).dtor_value()).isPrefixOf(name))) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(name, dafny.DafnySequence.asString(" not allowed as a ")), context), dafny.DafnySequence.asString(" because it begins with the allowed unauthenticated prefix."))));
    } else if ((DynamoDbEncryptionUtil_Compile.__default.ReservedPrefix()).isPrefixOf(name)) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(name, dafny.DafnySequence.asString(" not allowed as a ")), context), dafny.DafnySequence.asString(" because it begins with the reserved prefix."))));
    } else {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    }
  }
  public static Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> VirtualFieldNameAllowed(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig outer, dafny.DafnySequence<? extends Character> name)
  {
    if (((outer).dtor_attributeActionsOnEncrypt()).<dafny.DafnySequence<? extends Character>>contains(name)) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(name, dafny.DafnySequence.asString(" not allowed as a Virtual Field because it is already a configured attribute."))));
    } else if ((((outer).dtor_allowedUnsignedAttributes()).is_Some()) && ((((outer).dtor_allowedUnsignedAttributes()).dtor_value()).contains(name))) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(name, dafny.DafnySequence.asString(" not allowed as a Virtual Field because it is already an allowed unauthenticated attribute."))));
    } else if ((((outer).dtor_allowedUnsignedAttributePrefix()).is_Some()) && ((((outer).dtor_allowedUnsignedAttributePrefix()).dtor_value()).isPrefixOf(name))) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(name, dafny.DafnySequence.asString(" not allowed as a Virtual Field because it begins with the allowed unauthenticated prefix."))));
    } else if ((DynamoDbEncryptionUtil_Compile.__default.ReservedPrefix()).isPrefixOf(name)) {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(name, dafny.DafnySequence.asString(" not allowed as a Virtual Field because it begins with the reserved prefix."))));
    } else {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
    }
  }
  public static Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> FindVirtualFieldWithThisLocation(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> fields, dafny.DafnySet<? extends dafny.DafnySequence<? extends TermLoc_Compile.Selector>> locs)
  {
    dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> _0_badNames = ((dafny.Function2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField>, dafny.DafnySet<? extends dafny.DafnySequence<? extends TermLoc_Compile.Selector>>, dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>>>)(_1_fields, _2_locs) -> ((dafny.Function0<dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>>>)(() -> {
      java.util.ArrayList<dafny.DafnySequence<? extends Character>> _coll0 = new java.util.ArrayList<>();
      for (dafny.DafnySequence<? extends Character> _compr_0_boxed0 : (_1_fields).keySet().Elements()) {
        dafny.DafnySequence<? extends Character> _compr_0 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_compr_0_boxed0));
        dafny.DafnySequence<? extends Character> _3_b = (dafny.DafnySequence<? extends Character>)_compr_0;
        if (((_1_fields).<dafny.DafnySequence<? extends Character>>contains(_3_b)) && (((((DdbVirtualFields_Compile.VirtField)(java.lang.Object)((_1_fields).get(_3_b)))).GetLocs()).equals(_2_locs))) {
          _coll0.add(_3_b);
        }
      }
      return new dafny.DafnySet<dafny.DafnySequence<? extends Character>>(_coll0);
    })).apply()).apply(fields, locs);
    if ((java.math.BigInteger.valueOf((_0_badNames).size())).signum() == 0) {
      return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
    } else {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _4_badSeq = SortedSets.__default.<Character>SetToOrderedSequence2(dafny.TypeDescriptor.CHAR, _0_badNames, DynamoDbEncryptionUtil_Compile.__default::CharLess);
      return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((dafny.DafnySequence<? extends Character>)(java.lang.Object)((_4_badSeq).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))));
    }
  }
  public static boolean ExistsConstructorWithTheseRequired(dafny.DafnySequence<? extends CompoundBeacon_Compile.Constructor> cons, dafny.DafnySet<? extends CompoundBeacon_Compile.BeaconPart> locs)
  {
    return (__default.<CompoundBeacon_Compile.Constructor>SeqCount(CompoundBeacon_Compile.Constructor._typeDescriptor(), ((java.util.function.Function<dafny.DafnySet<? extends CompoundBeacon_Compile.BeaconPart>, java.util.function.Function<CompoundBeacon_Compile.Constructor, Boolean>>)(_0_locs) -> ((java.util.function.Function<CompoundBeacon_Compile.Constructor, Boolean>)(_1_c_boxed0) -> {
      CompoundBeacon_Compile.Constructor _1_c = ((CompoundBeacon_Compile.Constructor)(java.lang.Object)(_1_c_boxed0));
      return ((_1_c).getReqParts()).equals(_0_locs);
    })).apply(locs), cons)).signum() == 1;
  }
  public static dafny.DafnySequence<? extends Character> getPartsString(CompoundBeacon_Compile.Constructor c) {
    dafny.DafnySequence<? extends CompoundBeacon_Compile.ConstructorPart> _0_req = Seq_Compile.__default.<CompoundBeacon_Compile.ConstructorPart>Filter(CompoundBeacon_Compile.ConstructorPart._typeDescriptor(), ((java.util.function.Function<CompoundBeacon_Compile.ConstructorPart, Boolean>)(_1_p_boxed0) -> {
      CompoundBeacon_Compile.ConstructorPart _1_p = ((CompoundBeacon_Compile.ConstructorPart)(java.lang.Object)(_1_p_boxed0));
      return (_1_p).dtor_required();
    }), (c).dtor_parts());
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _2_names = Seq_Compile.__default.<CompoundBeacon_Compile.ConstructorPart, dafny.DafnySequence<? extends Character>>Map(CompoundBeacon_Compile.ConstructorPart._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((java.util.function.Function<CompoundBeacon_Compile.ConstructorPart, dafny.DafnySequence<? extends Character>>)(_3_p_boxed0) -> {
      CompoundBeacon_Compile.ConstructorPart _3_p = ((CompoundBeacon_Compile.ConstructorPart)(java.lang.Object)(_3_p_boxed0));
      return ((_3_p).dtor_part()).getName();
    }), _0_req);
    if ((java.math.BigInteger.valueOf((_2_names).length())).signum() == 0) {
      return dafny.DafnySequence.asString("");
    } else {
      return StandardLibrary_Compile.__default.<Character>Join(dafny.TypeDescriptor.CHAR, _2_names, dafny.DafnySequence.asString(", "));
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> AddVirtualFields(dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField> vf, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig outer, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> converted)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((vf).length())).signum() == 0) {
        return Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(DdbVirtualFields_Compile.VirtualFieldMap._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), converted);
      } else {
        Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), !(converted).<dafny.DafnySequence<? extends Character>>contains((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField)(java.lang.Object)((vf).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name()), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Duplicate VirtualField name : "), (((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField)(java.lang.Object)((vf).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name())));
        if ((_0_valueOrError0).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          return (_0_valueOrError0).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DdbVirtualFields_Compile.VirtualFieldMap._typeDescriptor());
        } else {
          Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _1_valueOrError1 = __default.VirtualFieldNameAllowed(outer, (((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField)(java.lang.Object)((vf).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name());
          if ((_1_valueOrError1).IsFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
            return (_1_valueOrError1).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField>>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DdbVirtualFields_Compile.VirtualFieldMap._typeDescriptor());
          } else {
            boolean _2___v1 = (_1_valueOrError1).Extract(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
            Wrappers_Compile.Result<DdbVirtualFields_Compile.VirtField, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _3_valueOrError2 = DdbVirtualFields_Compile.__default.ParseVirtualFieldConfig(((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField)(java.lang.Object)((vf).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))));
            if ((_3_valueOrError2).IsFailure(DdbVirtualFields_Compile.VirtField._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
              return (_3_valueOrError2).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField>>PropagateFailure(DdbVirtualFields_Compile.VirtField._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DdbVirtualFields_Compile.VirtualFieldMap._typeDescriptor());
            } else {
              DdbVirtualFields_Compile.VirtField _4_newField = (_3_valueOrError2).Extract(DdbVirtualFields_Compile.VirtField._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
              Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _5_valueOrError3 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), !((_4_newField).examine(((java.util.function.Function<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig, java.util.function.Function<dafny.DafnySequence<? extends TermLoc_Compile.Selector>, Boolean>>)(_6_outer) -> ((java.util.function.Function<dafny.DafnySequence<? extends TermLoc_Compile.Selector>, Boolean>)(_7_t_boxed0) -> {
                dafny.DafnySequence<? extends TermLoc_Compile.Selector> _7_t = ((dafny.DafnySequence<? extends TermLoc_Compile.Selector>)(java.lang.Object)(_7_t_boxed0));
                return !(__default.IsSigned(_6_outer, _7_t));
              })).apply(outer))), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("VirtualField "), (((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField)(java.lang.Object)((vf).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name()), dafny.DafnySequence.asString(" must be defined on signed fields."))));
              if ((_5_valueOrError3).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
                return (_5_valueOrError3).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DdbVirtualFields_Compile.VirtualFieldMap._typeDescriptor());
              } else {
                Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _8_badField = __default.FindVirtualFieldWithThisLocation(converted, (_4_newField).GetLocs());
                if ((_8_badField).is_Some()) {
                  return Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(DdbVirtualFields_Compile.VirtualFieldMap._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Virtual field "), (((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField)(java.lang.Object)((vf).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name()), dafny.DafnySequence.asString(" is defined on the same locations as ")), (_8_badField).dtor_value()), dafny.DafnySequence.asString("."))));
                } else {
                  dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField> _in0 = (vf).drop(java.math.BigInteger.ONE);
                  software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig _in1 = outer;
                  dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> _in2 = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, DdbVirtualFields_Compile.VirtField>update(converted, (((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VirtualField)(java.lang.Object)((vf).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name(), _4_newField);
                  vf = _in0;
                  outer = _in1;
                  converted = _in2;
                  continue TAIL_CALL_START;
                }
              }
            }
          }
        }
      }
    }
  }
  public static Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> FindBeaconWithThisLocation(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon> beacons, dafny.DafnySequence<? extends TermLoc_Compile.Selector> loc)
  {
    dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> _0_badNames = ((dafny.Function2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, dafny.DafnySequence<? extends TermLoc_Compile.Selector>, dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>>>)(_1_beacons, _2_loc) -> ((dafny.Function0<dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>>>)(() -> {
      java.util.ArrayList<dafny.DafnySequence<? extends Character>> _coll0 = new java.util.ArrayList<>();
      for (dafny.DafnySequence<? extends Character> _compr_0_boxed0 : (_1_beacons).keySet().Elements()) {
        dafny.DafnySequence<? extends Character> _compr_0 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_compr_0_boxed0));
        dafny.DafnySequence<? extends Character> _3_b = (dafny.DafnySequence<? extends Character>)_compr_0;
        if ((((_1_beacons).<dafny.DafnySequence<? extends Character>>contains(_3_b)) && ((((SearchableEncryptionInfo_Compile.Beacon)(java.lang.Object)((_1_beacons).get(_3_b)))).is_Standard())) && ((((((SearchableEncryptionInfo_Compile.Beacon)(java.lang.Object)((_1_beacons).get(_3_b)))).dtor_std()).dtor_loc()).equals(_2_loc))) {
          _coll0.add(_3_b);
        }
      }
      return new dafny.DafnySet<dafny.DafnySequence<? extends Character>>(_coll0);
    })).apply()).apply(beacons, loc);
    if ((java.math.BigInteger.valueOf((_0_badNames).size())).signum() == 0) {
      return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
    } else {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _4_badSeq = SortedSets.__default.<Character>SetToOrderedSequence2(dafny.TypeDescriptor.CHAR, _0_badNames, DynamoDbEncryptionUtil_Compile.__default::CharLess);
      return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((dafny.DafnySequence<? extends Character>)(java.lang.Object)((_4_badSeq).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))));
    }
  }
  public static Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> IsValidShare(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon> converted, dafny.DafnySequence<? extends Character> name, byte length, dafny.DafnySequence<? extends Character> share)
  {
    if ((converted).<dafny.DafnySequence<? extends Character>>contains(share)) {
      SearchableEncryptionInfo_Compile.Beacon _0_tb = ((SearchableEncryptionInfo_Compile.Beacon)(java.lang.Object)((converted).get(share)));
      if ((_0_tb).is_Standard()) {
        if ((((_0_tb).dtor_std()).dtor_share()).is_Some()) {
          if ((name).equals(share)) {
            return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Beacon "), name), dafny.DafnySequence.asString(" is shared to itself."))));
          } else {
            return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Beacon "), name), dafny.DafnySequence.asString(" is shared to ")), share), dafny.DafnySequence.asString(" which is in turn shared to ")), (((_0_tb).dtor_std()).dtor_share()).dtor_value()), dafny.DafnySequence.asString(". Share chains are not allowed."))));
          }
        } else if ((((_0_tb).dtor_std()).dtor_length()) == (length)) {
          return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
        } else {
          return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Beacon "), name), dafny.DafnySequence.asString(" is shared to ")), share), dafny.DafnySequence.asString(" but ")), name), dafny.DafnySequence.asString(" has length ")), StandardLibrary_mString_Compile.__default.Base10Int2String(dafny.Helpers.unsignedToBigInteger(length))), dafny.DafnySequence.asString(" and ")), share), dafny.DafnySequence.asString(" has length ")), StandardLibrary_mString_Compile.__default.Base10Int2String(dafny.Helpers.unsignedToBigInteger(((_0_tb).dtor_std()).dtor_length()))), dafny.DafnySequence.asString("."))));
        }
      } else {
        return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Beacon "), name), dafny.DafnySequence.asString(" is shared to ")), share), dafny.DafnySequence.asString(" but ")), share), dafny.DafnySequence.asString(" is a compound beacon."))));
      }
    } else {
      return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Beacon "), name), dafny.DafnySequence.asString(" is shared to ")), share), dafny.DafnySequence.asString(" which is not defined."))));
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> AddStandardBeacons(dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon> beacons, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig outer, software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient client, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> virtualFields, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon> converted)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> output = (Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    if(true) {
      if ((java.math.BigInteger.valueOf((beacons).length())).signum() == 0) {
        output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(SearchableEncryptionInfo_Compile.BeaconMap._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), converted);
        return output;
      }
      Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = Wrappers_Compile.Outcome.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      _0_valueOrError0 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), !(converted).<dafny.DafnySequence<? extends Character>>contains((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon)(java.lang.Object)((beacons).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name()), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Duplicate StandardBeacon name : "), (((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon)(java.lang.Object)((beacons).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name())));
      if ((_0_valueOrError0).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        output = (_0_valueOrError0).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.BeaconMap._typeDescriptor());
        return output;
      }
      Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _1_valueOrError1 = Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), false);
      _1_valueOrError1 = __default.BeaconNameAllowed(outer, virtualFields, (((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon)(java.lang.Object)((beacons).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name(), dafny.DafnySequence.asString("StandardBeacon"), false);
      if ((_1_valueOrError1).IsFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        output = (_1_valueOrError1).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.BeaconMap._typeDescriptor());
        return output;
      }
      boolean _2___v2;
      _2___v2 = (_1_valueOrError1).Extract(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      dafny.DafnySequence<? extends Character> _3_locString;
      _3_locString = __default.GetLocStr((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon)(java.lang.Object)((beacons).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name(), (((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon)(java.lang.Object)((beacons).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_loc());
      boolean _4_isPartOnly;
      _4_isPartOnly = false;
      boolean _5_isAsSet;
      _5_isAsSet = false;
      Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _6_share;
      _6_share = Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
      if (((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon)(java.lang.Object)((beacons).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_style()).is_Some()) {
        software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle _source0 = ((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon)(java.lang.Object)((beacons).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_style()).dtor_value();
        if (_source0.is_partOnly()) {
          software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PartOnly _7___mcc_h0 = ((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle_partOnly)_source0)._partOnly;
          software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PartOnly _8_t = _7___mcc_h0;
          _4_isPartOnly = true;
        } else if (_source0.is_shared()) {
          software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Shared _9___mcc_h1 = ((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle_shared)_source0)._shared;
          software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Shared _10_t = _9___mcc_h1;
          _6_share = Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (_10_t).dtor_other());
        } else if (_source0.is_asSet()) {
          software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.AsSet _11___mcc_h2 = ((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle_asSet)_source0)._asSet;
          software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.AsSet _12_t = _11___mcc_h2;
          _5_isAsSet = true;
        } else {
          software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SharedSet _13___mcc_h3 = ((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconStyle_sharedSet)_source0)._sharedSet;
          software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SharedSet _14_t = _13___mcc_h3;
          _6_share = Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), (_14_t).dtor_other());
          _5_isAsSet = true;
        }
      }
      Wrappers_Compile.Result<BaseBeacon_Compile.StandardBeacon, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _15_valueOrError2 = (Wrappers_Compile.Result<BaseBeacon_Compile.StandardBeacon, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
      _15_valueOrError2 = BaseBeacon_Compile.__default.MakeStandardBeacon(client, (((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon)(java.lang.Object)((beacons).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name(), ((byte) ((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon)(java.lang.Object)((beacons).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_length())), _3_locString, _4_isPartOnly, _5_isAsSet, _6_share);
      if ((_15_valueOrError2).IsFailure(BaseBeacon_Compile.ValidStandardBeacon._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        output = (_15_valueOrError2).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>>PropagateFailure(BaseBeacon_Compile.ValidStandardBeacon._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.BeaconMap._typeDescriptor());
        return output;
      }
      BaseBeacon_Compile.StandardBeacon _16_newBeacon;
      _16_newBeacon = (_15_valueOrError2).Extract(BaseBeacon_Compile.ValidStandardBeacon._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _17_valueOrError3 = Wrappers_Compile.Outcome.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      _17_valueOrError3 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), __default.IsEncryptedV(outer, virtualFields, (_16_newBeacon).dtor_loc()), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("StandardBeacon "), (((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon)(java.lang.Object)((beacons).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name()), dafny.DafnySequence.asString(" not defined on an encrypted field."))));
      if ((_17_valueOrError3).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        output = (_17_valueOrError3).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.BeaconMap._typeDescriptor());
        return output;
      }
      Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _18_badBeacon;
      _18_badBeacon = __default.FindBeaconWithThisLocation(converted, (_16_newBeacon).dtor_loc());
      if ((_18_badBeacon).is_Some()) {
        output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(SearchableEncryptionInfo_Compile.BeaconMap._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Beacon "), (((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon)(java.lang.Object)((beacons).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name()), dafny.DafnySequence.asString(" is defined on location ")), TermLoc_Compile.__default.TermLocToString((_16_newBeacon).dtor_loc())), dafny.DafnySequence.asString(", but beacon ")), (_18_badBeacon).dtor_value()), dafny.DafnySequence.asString(" is already defined on that location."))));
        return output;
      }
      Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _19_badField;
      _19_badField = __default.FindVirtualFieldWithThisLocation(virtualFields, dafny.DafnySet.<dafny.DafnySequence<? extends TermLoc_Compile.Selector>> of((_16_newBeacon).dtor_loc()));
      if ((_19_badField).is_Some()) {
        output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(SearchableEncryptionInfo_Compile.BeaconMap._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Beacon "), (((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon)(java.lang.Object)((beacons).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name()), dafny.DafnySequence.asString(" is defined on location ")), TermLoc_Compile.__default.TermLocToString((_16_newBeacon).dtor_loc())), dafny.DafnySequence.asString(", but virtual field ")), (_19_badField).dtor_value()), dafny.DafnySequence.asString(" is already defined on that single location."))));
        return output;
      }
      Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out0;
      _out0 = __default.AddStandardBeacons((beacons).drop(java.math.BigInteger.ONE), outer, client, virtualFields, dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, SearchableEncryptionInfo_Compile.Beacon>update(converted, (((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.StandardBeacon)(java.lang.Object)((beacons).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name(), SearchableEncryptionInfo_Compile.Beacon.create_Standard(_16_newBeacon)));
      output = _out0;
    }
    return output;
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends TermLoc_Compile.Selector>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GetLoc(dafny.DafnySequence<? extends Character> name, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> loc)
  {
    if ((loc).is_None()) {
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends TermLoc_Compile.Selector>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(TermLoc_Compile.TermLoc._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), TermLoc_Compile.__default.TermLocMap(name));
    } else {
      return TermLoc_Compile.__default.MakeTermLoc((loc).dtor_value());
    }
  }
  public static dafny.DafnySequence<? extends Character> GetLocStr(dafny.DafnySequence<? extends Character> name, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> loc)
  {
    if ((loc).is_None()) {
      return name;
    } else {
      return (loc).dtor_value();
    }
  }
  public static Wrappers_Compile.Result<PartSet, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GetSignedParts(dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart> parts, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig outer, dafny.DafnySequence<? extends Character> name, PartSet converted)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((parts).length())).signum() == 0) {
        return Wrappers_Compile.Result.<PartSet, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), converted);
      } else {
        Wrappers_Compile.Result<dafny.DafnySequence<? extends TermLoc_Compile.Selector>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = __default.GetLoc((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name(), (((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_loc());
        if ((_0_valueOrError0).IsFailure(TermLoc_Compile.TermLoc._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          return (_0_valueOrError0).<PartSet>PropagateFailure(TermLoc_Compile.TermLoc._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), PartSet._typeDescriptor());
        } else {
          dafny.DafnySequence<? extends TermLoc_Compile.Selector> _1_loc = (_0_valueOrError0).Extract(TermLoc_Compile.TermLoc._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
          CompoundBeacon_Compile.BeaconPart _2_newPart = CompoundBeacon_Compile.BeaconPart.create_Signed((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_prefix(), (((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name(), _1_loc);
          Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _3_valueOrError1 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), __default.IsSignOnly(outer, (_2_newPart).dtor_loc()), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Signed Part "), (_2_newPart).dtor_name()), dafny.DafnySequence.asString(" is built from ")), __default.GetLocStr((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name(), (((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_loc())), dafny.DafnySequence.asString(" which is not SIGN_ONLY."))));
          if ((_3_valueOrError1).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
            return (_3_valueOrError1).<PartSet>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), PartSet._typeDescriptor());
          } else {
            Wrappers_Compile.Result<PartSet, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _4_valueOrError2 = (converted).add(_2_newPart, name);
            if ((_4_valueOrError2).IsFailure(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
              return (_4_valueOrError2).<PartSet>PropagateFailure(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), PartSet._typeDescriptor());
            } else {
              PartSet _5_newParts = (_4_valueOrError2).Extract(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
              dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart> _in0 = (parts).drop(java.math.BigInteger.ONE);
              software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig _in1 = outer;
              dafny.DafnySequence<? extends Character> _in2 = name;
              PartSet _in3 = _5_newParts;
              parts = _in0;
              outer = _in1;
              name = _in2;
              converted = _in3;
              continue TAIL_CALL_START;
            }
          }
        }
      }
    }
  }
  public static Wrappers_Compile.Result<PartSet, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GetEncryptedParts(dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart> parts, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon> std, dafny.DafnySequence<? extends Character> name, PartSet converted)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((parts).length())).signum() == 0) {
        return Wrappers_Compile.Result.<PartSet, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), converted);
      } else if ((((std).<dafny.DafnySequence<? extends Character>>contains((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name())) && ((((SearchableEncryptionInfo_Compile.Beacon)(java.lang.Object)((std).get((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name())))).is_Standard())) && (((((SearchableEncryptionInfo_Compile.Beacon)(java.lang.Object)((std).get((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name())))).dtor_std()).dtor_asSet())) {
        return Wrappers_Compile.Result.<PartSet, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(name, dafny.DafnySequence.asString(" uses ")), (((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name()), dafny.DafnySequence.asString(" which is an AsSet beacon, and therefore cannot be used in a Compound Beacon."))));
      } else if (((std).<dafny.DafnySequence<? extends Character>>contains((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name())) && ((((SearchableEncryptionInfo_Compile.Beacon)(java.lang.Object)((std).get((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name())))).is_Standard())) {
        CompoundBeacon_Compile.BeaconPart _0_newPart = CompoundBeacon_Compile.BeaconPart.create_Encrypted((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_prefix(), (((SearchableEncryptionInfo_Compile.Beacon)(java.lang.Object)((std).get((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name())))).dtor_std());
        Wrappers_Compile.Result<PartSet, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _1_valueOrError0 = (converted).add(_0_newPart, name);
        if ((_1_valueOrError0).IsFailure(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          return (_1_valueOrError0).<PartSet>PropagateFailure(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), PartSet._typeDescriptor());
        } else {
          PartSet _2_newParts = (_1_valueOrError0).Extract(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
          dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart> _in0 = (parts).drop(java.math.BigInteger.ONE);
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon> _in1 = std;
          dafny.DafnySequence<? extends Character> _in2 = name;
          PartSet _in3 = _2_newParts;
          parts = _in0;
          std = _in1;
          name = _in2;
          converted = _in3;
          continue TAIL_CALL_START;
        }
      } else {
        return Wrappers_Compile.Result.<PartSet, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(name, dafny.DafnySequence.asString(" refers to standard beacon ")), (((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name()), dafny.DafnySequence.asString(" which is not configured."))));
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends CompoundBeacon_Compile.Constructor>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> MakeDefaultConstructor(dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart> parts, dafny.DafnySequence<? extends CompoundBeacon_Compile.ConstructorPart> converted)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((parts).length())).signum() == 0) {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends CompoundBeacon_Compile.Constructor>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnySequence.<CompoundBeacon_Compile.Constructor>_typeDescriptor(CompoundBeacon_Compile.Constructor._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<CompoundBeacon_Compile.Constructor> of(CompoundBeacon_Compile.Constructor._typeDescriptor(), CompoundBeacon_Compile.Constructor.create(converted)));
      } else {
        dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart> _in0 = (parts).drop(java.math.BigInteger.ONE);
        dafny.DafnySequence<? extends CompoundBeacon_Compile.ConstructorPart> _in1 = dafny.DafnySequence.<CompoundBeacon_Compile.ConstructorPart>concatenate(converted, dafny.DafnySequence.<CompoundBeacon_Compile.ConstructorPart> of(CompoundBeacon_Compile.ConstructorPart._typeDescriptor(), CompoundBeacon_Compile.ConstructorPart.create(((CompoundBeacon_Compile.BeaconPart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), true)));
        parts = _in0;
        converted = _in1;
        continue TAIL_CALL_START;
      }
    }
  }
  public static <__T> dafny.DafnySequence<? extends __T> MyFilter(dafny.TypeDescriptor<__T> _td___T, java.util.function.Function<__T, Boolean> f, dafny.DafnySequence<? extends __T> xs)
  {
    dafny.DafnySequence<? extends __T> _0___accumulator = dafny.DafnySequence.<__T> empty(_td___T);
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((xs).length())).signum() == 0) {
        return dafny.DafnySequence.<__T>concatenate(_0___accumulator, dafny.DafnySequence.<__T> empty(_td___T));
      } else {
        _0___accumulator = dafny.DafnySequence.<__T>concatenate(_0___accumulator, ((((boolean)(java.lang.Object)((f).apply(((__T)(java.lang.Object)((xs).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))))) ? (dafny.DafnySequence.<__T> of(_td___T, ((__T)(java.lang.Object)((xs).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))) : (dafny.DafnySequence.<__T> empty(_td___T))));
        java.util.function.Function<__T, Boolean> _in0 = f;
        dafny.DafnySequence<? extends __T> _in1 = (xs).drop(java.math.BigInteger.ONE);
        f = _in0;
        xs = _in1;
        continue TAIL_CALL_START;
      }
    }
  }
  public static <__T> java.math.BigInteger SeqCount(dafny.TypeDescriptor<__T> _td___T, java.util.function.Function<__T, Boolean> f, dafny.DafnySequence<? extends __T> xs)
  {
    java.math.BigInteger _0___accumulator = java.math.BigInteger.ZERO;
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((xs).length())).signum() == 0) {
        return (java.math.BigInteger.ZERO).add(_0___accumulator);
      } else {
        _0___accumulator = (_0___accumulator).add(((((boolean)(java.lang.Object)((f).apply(((__T)(java.lang.Object)((xs).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))))) ? (java.math.BigInteger.ONE) : (java.math.BigInteger.ZERO)));
        java.util.function.Function<__T, Boolean> _in0 = f;
        dafny.DafnySequence<? extends __T> _in1 = (xs).drop(java.math.BigInteger.ONE);
        f = _in0;
        xs = _in1;
        continue TAIL_CALL_START;
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends CompoundBeacon_Compile.ConstructorPart>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> MakeConstructor2(dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart> c, dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart> parts, java.math.BigInteger origSize, dafny.DafnySequence<? extends CompoundBeacon_Compile.ConstructorPart> converted)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((c).length())).signum() == 0) {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends CompoundBeacon_Compile.ConstructorPart>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnySequence.<CompoundBeacon_Compile.ConstructorPart>_typeDescriptor(CompoundBeacon_Compile.ConstructorPart._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), converted);
      } else {
        dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart> _0_thePart = __default.<CompoundBeacon_Compile.BeaconPart>MyFilter(CompoundBeacon_Compile.BeaconPart._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart>, java.util.function.Function<CompoundBeacon_Compile.BeaconPart, Boolean>>)(_1_c) -> ((java.util.function.Function<CompoundBeacon_Compile.BeaconPart, Boolean>)(_2_p_boxed0) -> {
          CompoundBeacon_Compile.BeaconPart _2_p = ((CompoundBeacon_Compile.BeaconPart)(java.lang.Object)(_2_p_boxed0));
          return ((_2_p).getName()).equals((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart)(java.lang.Object)((_1_c).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name());
        })).apply(c), parts);
        Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _3_valueOrError0 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), (java.math.BigInteger.valueOf((_0_thePart).length())).signum() == 1, DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Constructor refers to part name "), (((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart)(java.lang.Object)((c).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name()), dafny.DafnySequence.asString(" but there is no part by that name."))));
        if ((_3_valueOrError0).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          return (_3_valueOrError0).<dafny.DafnySequence<? extends CompoundBeacon_Compile.ConstructorPart>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<CompoundBeacon_Compile.ConstructorPart>_typeDescriptor(CompoundBeacon_Compile.ConstructorPart._typeDescriptor()));
        } else {
          CompoundBeacon_Compile.ConstructorPart _4_newPart = CompoundBeacon_Compile.ConstructorPart.create(((CompoundBeacon_Compile.BeaconPart)(java.lang.Object)((_0_thePart).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), (((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart)(java.lang.Object)((c).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_required());
          dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart> _in0 = (c).drop(java.math.BigInteger.ONE);
          dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart> _in1 = parts;
          java.math.BigInteger _in2 = origSize;
          dafny.DafnySequence<? extends CompoundBeacon_Compile.ConstructorPart> _in3 = dafny.DafnySequence.<CompoundBeacon_Compile.ConstructorPart>concatenate(converted, dafny.DafnySequence.<CompoundBeacon_Compile.ConstructorPart> of(CompoundBeacon_Compile.ConstructorPart._typeDescriptor(), _4_newPart));
          c = _in0;
          parts = _in1;
          origSize = _in2;
          converted = _in3;
          continue TAIL_CALL_START;
        }
      }
    }
  }
  public static Wrappers_Compile.Result<CompoundBeacon_Compile.Constructor, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> MakeConstructor(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor c, dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart> parts)
  {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends CompoundBeacon_Compile.ConstructorPart>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = __default.MakeConstructor2((c).dtor_parts(), parts, java.math.BigInteger.valueOf(((c).dtor_parts()).length()), dafny.DafnySequence.<CompoundBeacon_Compile.ConstructorPart> empty(CompoundBeacon_Compile.ConstructorPart._typeDescriptor()));
    if ((_0_valueOrError0).IsFailure(dafny.DafnySequence.<CompoundBeacon_Compile.ConstructorPart>_typeDescriptor(CompoundBeacon_Compile.ConstructorPart._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
      return (_0_valueOrError0).<CompoundBeacon_Compile.Constructor>PropagateFailure(dafny.DafnySequence.<CompoundBeacon_Compile.ConstructorPart>_typeDescriptor(CompoundBeacon_Compile.ConstructorPart._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), CompoundBeacon_Compile.Constructor._typeDescriptor());
    } else {
      dafny.DafnySequence<? extends CompoundBeacon_Compile.ConstructorPart> _1_newParts = (_0_valueOrError0).Extract(dafny.DafnySequence.<CompoundBeacon_Compile.ConstructorPart>_typeDescriptor(CompoundBeacon_Compile.ConstructorPart._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      return Wrappers_Compile.Result.<CompoundBeacon_Compile.Constructor, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(CompoundBeacon_Compile.Constructor._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), CompoundBeacon_Compile.Constructor.create(_1_newParts));
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends CompoundBeacon_Compile.Constructor>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> AddConstructors2(dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor> constructors, dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart> parts, java.math.BigInteger origSize, dafny.DafnySequence<? extends CompoundBeacon_Compile.Constructor> converted)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((constructors).length())).signum() == 0) {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends CompoundBeacon_Compile.Constructor>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnySequence.<CompoundBeacon_Compile.Constructor>_typeDescriptor(CompoundBeacon_Compile.Constructor._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), converted);
      } else {
        Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), (java.math.BigInteger.valueOf(((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor)(java.lang.Object)((constructors).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_parts()).length())).signum() == 1, DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Every constructor must have at least one part.")));
        if ((_0_valueOrError0).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          return (_0_valueOrError0).<dafny.DafnySequence<? extends CompoundBeacon_Compile.Constructor>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<CompoundBeacon_Compile.Constructor>_typeDescriptor(CompoundBeacon_Compile.Constructor._typeDescriptor()));
        } else {
          Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _1_valueOrError1 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), (__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart>SeqCount(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart._typeDescriptor(), ((java.util.function.Function<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart, Boolean>)(_2_p_boxed0) -> {
            software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart _2_p = ((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart)(java.lang.Object)(_2_p_boxed0));
            return (_2_p).dtor_required();
          }), (((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor)(java.lang.Object)((constructors).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_parts())).signum() == 1, DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("A Constructor for beacon "), name), dafny.DafnySequence.asString(" lacks any required parts"))));
          if ((_1_valueOrError1).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
            return (_1_valueOrError1).<dafny.DafnySequence<? extends CompoundBeacon_Compile.Constructor>>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<CompoundBeacon_Compile.Constructor>_typeDescriptor(CompoundBeacon_Compile.Constructor._typeDescriptor()));
          } else {
            Wrappers_Compile.Result<CompoundBeacon_Compile.Constructor, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _3_valueOrError2 = __default.MakeConstructor(((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor)(java.lang.Object)((constructors).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), parts);
            if ((_3_valueOrError2).IsFailure(CompoundBeacon_Compile.Constructor._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
              return (_3_valueOrError2).<dafny.DafnySequence<? extends CompoundBeacon_Compile.Constructor>>PropagateFailure(CompoundBeacon_Compile.Constructor._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<CompoundBeacon_Compile.Constructor>_typeDescriptor(CompoundBeacon_Compile.Constructor._typeDescriptor()));
            } else {
              CompoundBeacon_Compile.Constructor _4_c = (_3_valueOrError2).Extract(CompoundBeacon_Compile.Constructor._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
              if (__default.ExistsConstructorWithTheseRequired(converted, (_4_c).getReqParts())) {
                dafny.DafnySequence<? extends Character> _5_p = __default.getPartsString(_4_c);
                return Wrappers_Compile.Result.<dafny.DafnySequence<? extends CompoundBeacon_Compile.Constructor>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.DafnySequence.<CompoundBeacon_Compile.Constructor>_typeDescriptor(CompoundBeacon_Compile.Constructor._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Multiple constructors for "), name), dafny.DafnySequence.asString(" have the same set of required parts : ")), _5_p)));
              } else {
                dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor> _in0 = (constructors).drop(java.math.BigInteger.ONE);
                dafny.DafnySequence<? extends Character> _in1 = name;
                dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart> _in2 = parts;
                java.math.BigInteger _in3 = origSize;
                dafny.DafnySequence<? extends CompoundBeacon_Compile.Constructor> _in4 = dafny.DafnySequence.<CompoundBeacon_Compile.Constructor>concatenate(converted, dafny.DafnySequence.<CompoundBeacon_Compile.Constructor> of(CompoundBeacon_Compile.Constructor._typeDescriptor(), _4_c));
                constructors = _in0;
                name = _in1;
                parts = _in2;
                origSize = _in3;
                converted = _in4;
                continue TAIL_CALL_START;
              }
            }
          }
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends CompoundBeacon_Compile.Constructor>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> AddConstructors(Wrappers_Compile.Option<dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor>> constructors, dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart> parts)
  {
    if ((constructors).is_None()) {
      return __default.MakeDefaultConstructor(parts, dafny.DafnySequence.<CompoundBeacon_Compile.ConstructorPart> empty(CompoundBeacon_Compile.ConstructorPart._typeDescriptor()));
    } else {
      return __default.AddConstructors2((constructors).dtor_value(), name, parts, java.math.BigInteger.valueOf(((constructors).dtor_value()).length()), dafny.DafnySequence.<CompoundBeacon_Compile.Constructor> empty(CompoundBeacon_Compile.Constructor._typeDescriptor()));
    }
  }
  public static Wrappers_Compile.Result<PartSet, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GetGlobalPartsFrom(dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart> cons, PartSet globalParts, boolean signed, PartSet parts)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((cons).length())).signum() == 0) {
        return Wrappers_Compile.Result.<PartSet, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), parts);
      } else {
        Wrappers_Compile.Option<CompoundBeacon_Compile.BeaconPart> _0_newPart = __default.FindGlobalPart((globalParts).dtor_parts(), ((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart)(java.lang.Object)((cons).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), signed);
        if ((_0_newPart).is_Some()) {
          Wrappers_Compile.Result<PartSet, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _1_valueOrError0 = (parts).add((_0_newPart).dtor_value(), dafny.DafnySequence.asString("Global Parts List"));
          if ((_1_valueOrError0).IsFailure(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
            return (_1_valueOrError0).<PartSet>PropagateFailure(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), PartSet._typeDescriptor());
          } else {
            PartSet _2_newParts = (_1_valueOrError0).Extract(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
            dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart> _in0 = (cons).drop(java.math.BigInteger.ONE);
            PartSet _in1 = globalParts;
            boolean _in2 = signed;
            PartSet _in3 = _2_newParts;
            cons = _in0;
            globalParts = _in1;
            signed = _in2;
            parts = _in3;
            continue TAIL_CALL_START;
          }
        } else {
          dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart> _in4 = (cons).drop(java.math.BigInteger.ONE);
          PartSet _in5 = globalParts;
          boolean _in6 = signed;
          PartSet _in7 = parts;
          cons = _in4;
          globalParts = _in5;
          signed = _in6;
          parts = _in7;
          continue TAIL_CALL_START;
        }
      }
    }
  }
  public static Wrappers_Compile.Result<PartSet, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GetGlobalParts(dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor> cons, PartSet globalParts, boolean signed, PartSet parts)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((cons).length())).signum() == 0) {
        return Wrappers_Compile.Result.<PartSet, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), parts);
      } else {
        Wrappers_Compile.Result<PartSet, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = __default.GetGlobalPartsFrom((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor)(java.lang.Object)((cons).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_parts(), globalParts, signed, parts);
        if ((_0_valueOrError0).IsFailure(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          return (_0_valueOrError0).<PartSet>PropagateFailure(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), PartSet._typeDescriptor());
        } else {
          PartSet _1_newParts = (_0_valueOrError0).Extract(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
          dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor> _in0 = (cons).drop(java.math.BigInteger.ONE);
          PartSet _in1 = globalParts;
          boolean _in2 = signed;
          PartSet _in3 = _1_newParts;
          cons = _in0;
          globalParts = _in1;
          signed = _in2;
          parts = _in3;
          continue TAIL_CALL_START;
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GetAllEncryptedParts(dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart> parts, dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor> cons, PartSet globalEncryptedParts, dafny.DafnySequence<? extends Character> name, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon> std)
  {
    Wrappers_Compile.Result<PartSet, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = __default.GetEncryptedParts(parts, std, dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Compound beacon "), name), PartSet.create(dafny.DafnySequence.<CompoundBeacon_Compile.BeaconPart> empty(CompoundBeacon_Compile.BeaconPart._typeDescriptor()), dafny.DafnySet.<dafny.DafnySequence<? extends Character>> empty(), dafny.DafnySet.<dafny.DafnySequence<? extends Character>> empty()));
    if ((_0_valueOrError0).IsFailure(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
      return (_0_valueOrError0).<dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart>>PropagateFailure(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<CompoundBeacon_Compile.BeaconPart>_typeDescriptor(CompoundBeacon_Compile.BeaconPart._typeDescriptor()));
    } else {
      PartSet _1_p1 = (_0_valueOrError0).Extract(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      Wrappers_Compile.Result<PartSet, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _2_valueOrError1 = __default.GetGlobalParts(cons, globalEncryptedParts, false, PartSet.create(dafny.DafnySequence.<CompoundBeacon_Compile.BeaconPart> empty(CompoundBeacon_Compile.BeaconPart._typeDescriptor()), dafny.DafnySet.<dafny.DafnySequence<? extends Character>> empty(), dafny.DafnySet.<dafny.DafnySequence<? extends Character>> empty()));
      if ((_2_valueOrError1).IsFailure(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        return (_2_valueOrError1).<dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart>>PropagateFailure(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<CompoundBeacon_Compile.BeaconPart>_typeDescriptor(CompoundBeacon_Compile.BeaconPart._typeDescriptor()));
      } else {
        PartSet _3_p2 = (_2_valueOrError1).Extract(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        Wrappers_Compile.Result<PartSet, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _4_valueOrError2 = (_1_p1).combine(_3_p2, name, dafny.DafnySequence.asString("Global Parts List"));
        if ((_4_valueOrError2).IsFailure(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          return (_4_valueOrError2).<dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart>>PropagateFailure(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<CompoundBeacon_Compile.BeaconPart>_typeDescriptor(CompoundBeacon_Compile.BeaconPart._typeDescriptor()));
        } else {
          PartSet _5_both = (_4_valueOrError2).Extract(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
          return Wrappers_Compile.Result.<dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnySequence.<CompoundBeacon_Compile.BeaconPart>_typeDescriptor(CompoundBeacon_Compile.BeaconPart._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), (_5_both).dtor_parts());
        }
      }
    }
  }
  public static boolean IsSignedPart(CompoundBeacon_Compile.BeaconPart part, boolean signed)
  {
    if (signed) {
      return (part).is_Signed();
    } else {
      return (part).is_Encrypted();
    }
  }
  public static Wrappers_Compile.Option<CompoundBeacon_Compile.BeaconPart> FindGlobalPart(dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart> globalParts, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart cons, boolean signed)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((globalParts).length())).signum() == 0) {
        return Wrappers_Compile.Option.<CompoundBeacon_Compile.BeaconPart>create_None(CompoundBeacon_Compile.BeaconPart._typeDescriptor());
      } else if ((__default.IsSignedPart(((CompoundBeacon_Compile.BeaconPart)(java.lang.Object)((globalParts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), signed)) && (((((CompoundBeacon_Compile.BeaconPart)(java.lang.Object)((globalParts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).getName()).equals((cons).dtor_name()))) {
        return Wrappers_Compile.Option.<CompoundBeacon_Compile.BeaconPart>create_Some(CompoundBeacon_Compile.BeaconPart._typeDescriptor(), ((CompoundBeacon_Compile.BeaconPart)(java.lang.Object)((globalParts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))));
      } else {
        dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart> _in0 = (globalParts).drop(java.math.BigInteger.ONE);
        software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.ConstructorPart _in1 = cons;
        boolean _in2 = signed;
        globalParts = _in0;
        cons = _in1;
        signed = _in2;
        continue TAIL_CALL_START;
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GetAllSignedParts(dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart> parts, dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor> cons, PartSet globalSignedParts, dafny.DafnySequence<? extends Character> name, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig outer)
  {
    Wrappers_Compile.Result<PartSet, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = __default.GetSignedParts(parts, outer, name, PartSet.create(dafny.DafnySequence.<CompoundBeacon_Compile.BeaconPart> empty(CompoundBeacon_Compile.BeaconPart._typeDescriptor()), dafny.DafnySet.<dafny.DafnySequence<? extends Character>> empty(), dafny.DafnySet.<dafny.DafnySequence<? extends Character>> empty()));
    if ((_0_valueOrError0).IsFailure(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
      return (_0_valueOrError0).<dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart>>PropagateFailure(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<CompoundBeacon_Compile.BeaconPart>_typeDescriptor(CompoundBeacon_Compile.BeaconPart._typeDescriptor()));
    } else {
      PartSet _1_p1 = (_0_valueOrError0).Extract(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      Wrappers_Compile.Result<PartSet, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _2_valueOrError1 = __default.GetGlobalParts(cons, globalSignedParts, true, PartSet.create(dafny.DafnySequence.<CompoundBeacon_Compile.BeaconPart> empty(CompoundBeacon_Compile.BeaconPart._typeDescriptor()), dafny.DafnySet.<dafny.DafnySequence<? extends Character>> empty(), dafny.DafnySet.<dafny.DafnySequence<? extends Character>> empty()));
      if ((_2_valueOrError1).IsFailure(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        return (_2_valueOrError1).<dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart>>PropagateFailure(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<CompoundBeacon_Compile.BeaconPart>_typeDescriptor(CompoundBeacon_Compile.BeaconPart._typeDescriptor()));
      } else {
        PartSet _3_p2 = (_2_valueOrError1).Extract(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        Wrappers_Compile.Result<PartSet, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _4_valueOrError2 = (_1_p1).combine(_3_p2, name, dafny.DafnySequence.asString("Global Parts List"));
        if ((_4_valueOrError2).IsFailure(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          return (_4_valueOrError2).<dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart>>PropagateFailure(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnySequence.<CompoundBeacon_Compile.BeaconPart>_typeDescriptor(CompoundBeacon_Compile.BeaconPart._typeDescriptor()));
        } else {
          PartSet _5_both = (_4_valueOrError2).Extract(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
          return Wrappers_Compile.Result.<dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.DafnySequence.<CompoundBeacon_Compile.BeaconPart>_typeDescriptor(CompoundBeacon_Compile.BeaconPart._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), (_5_both).dtor_parts());
        }
      }
    }
  }
  public static Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> CheckSignedParts(dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart> parts, PartSet globals, dafny.DafnySequence<? extends Character> name)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((parts).length())).signum() == 0) {
        return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
      } else if (((globals).dtor_names()).<dafny.DafnySequence<? extends Character>>contains((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name())) {
        return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Compound beacon "), name), dafny.DafnySequence.asString(" defines signed part ")), (((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name()), dafny.DafnySequence.asString(" which is already defined as a global part."))));
      } else if (((globals).dtor_prefixes()).<dafny.DafnySequence<? extends Character>>contains((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_prefix())) {
        return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Compound beacon "), name), dafny.DafnySequence.asString(" defines signed part ")), (((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name()), dafny.DafnySequence.asString(" with prefix ")), (((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_prefix()), dafny.DafnySequence.asString(" which is already defined as the prefix of a global part."))));
      } else {
        dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart> _in0 = (parts).drop(java.math.BigInteger.ONE);
        PartSet _in1 = globals;
        dafny.DafnySequence<? extends Character> _in2 = name;
        parts = _in0;
        globals = _in1;
        name = _in2;
        continue TAIL_CALL_START;
      }
    }
  }
  public static Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> CheckEncryptedParts(dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart> parts, PartSet globals, dafny.DafnySequence<? extends Character> name)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((parts).length())).signum() == 0) {
        return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
      } else if (((globals).dtor_names()).<dafny.DafnySequence<? extends Character>>contains((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name())) {
        return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Compound beacon "), name), dafny.DafnySequence.asString(" defines encrypted part ")), (((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name()), dafny.DafnySequence.asString(" which is already defined as a global part."))));
      } else if (((globals).dtor_prefixes()).<dafny.DafnySequence<? extends Character>>contains((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_prefix())) {
        return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Compound beacon "), name), dafny.DafnySequence.asString(" defines encrypted part ")), (((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name()), dafny.DafnySequence.asString(" with prefix ")), (((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_prefix()), dafny.DafnySequence.asString(" which is already defined as the prefix of a global part."))));
      } else {
        dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart> _in0 = (parts).drop(java.math.BigInteger.ONE);
        PartSet _in1 = globals;
        dafny.DafnySequence<? extends Character> _in2 = name;
        parts = _in0;
        globals = _in1;
        name = _in2;
        continue TAIL_CALL_START;
      }
    }
  }
  public static Wrappers_Compile.Result<CompoundBeacon_Compile.CompoundBeacon, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> CreateCompoundBeacon(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon beacon, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig outer, software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient client, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> virtualFields, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon> converted, PartSet globalSignedParts, PartSet globalEncryptedParts)
  {
    dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart> _0_signedParts = ((((beacon).dtor_signed()).is_Some()) ? (((beacon).dtor_signed()).dtor_value()) : (dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart> empty(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SignedPart._typeDescriptor())));
    dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart> _1_encryptedParts = ((((beacon).dtor_encrypted()).is_Some()) ? (((beacon).dtor_encrypted()).dtor_value()) : (dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart> empty(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedPart._typeDescriptor())));
    dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor> _2_constructors = ((((beacon).dtor_constructors()).is_Some()) ? (((beacon).dtor_constructors()).dtor_value()) : (dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor> empty(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Constructor._typeDescriptor())));
    Wrappers_Compile.Result<PartSet, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _3_valueOrError0 = (globalSignedParts).combine(globalEncryptedParts, dafny.DafnySequence.asString("Global Signed Parts List"), dafny.DafnySequence.asString("Global Encrypted Parts List"));
    if ((_3_valueOrError0).IsFailure(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
      return (_3_valueOrError0).<CompoundBeacon_Compile.CompoundBeacon>PropagateFailure(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), CompoundBeacon_Compile.ValidCompoundBeacon._typeDescriptor());
    } else {
      PartSet _4_globalParts = (_3_valueOrError0).Extract(PartSet._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _5_valueOrError1 = __default.CheckSignedParts(_0_signedParts, _4_globalParts, (beacon).dtor_name());
      if ((_5_valueOrError1).IsFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        return (_5_valueOrError1).<CompoundBeacon_Compile.CompoundBeacon>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), CompoundBeacon_Compile.ValidCompoundBeacon._typeDescriptor());
      } else {
        boolean _6___v3 = (_5_valueOrError1).Extract(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
        Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _7_valueOrError2 = __default.CheckEncryptedParts(_1_encryptedParts, _4_globalParts, (beacon).dtor_name());
        if ((_7_valueOrError2).IsFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
          return (_7_valueOrError2).<CompoundBeacon_Compile.CompoundBeacon>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), CompoundBeacon_Compile.ValidCompoundBeacon._typeDescriptor());
        } else {
          boolean _8___v4 = (_7_valueOrError2).Extract(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
          Wrappers_Compile.Result<dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _9_valueOrError3 = __default.GetAllSignedParts(_0_signedParts, _2_constructors, globalSignedParts, (beacon).dtor_name(), outer);
          if ((_9_valueOrError3).IsFailure(dafny.DafnySequence.<CompoundBeacon_Compile.BeaconPart>_typeDescriptor(CompoundBeacon_Compile.BeaconPart._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
            return (_9_valueOrError3).<CompoundBeacon_Compile.CompoundBeacon>PropagateFailure(dafny.DafnySequence.<CompoundBeacon_Compile.BeaconPart>_typeDescriptor(CompoundBeacon_Compile.BeaconPart._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), CompoundBeacon_Compile.ValidCompoundBeacon._typeDescriptor());
          } else {
            dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart> _10_signed = (_9_valueOrError3).Extract(dafny.DafnySequence.<CompoundBeacon_Compile.BeaconPart>_typeDescriptor(CompoundBeacon_Compile.BeaconPart._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
            Wrappers_Compile.Result<dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _11_valueOrError4 = __default.GetAllEncryptedParts(_1_encryptedParts, _2_constructors, globalEncryptedParts, (beacon).dtor_name(), converted);
            if ((_11_valueOrError4).IsFailure(dafny.DafnySequence.<CompoundBeacon_Compile.BeaconPart>_typeDescriptor(CompoundBeacon_Compile.BeaconPart._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
              return (_11_valueOrError4).<CompoundBeacon_Compile.CompoundBeacon>PropagateFailure(dafny.DafnySequence.<CompoundBeacon_Compile.BeaconPart>_typeDescriptor(CompoundBeacon_Compile.BeaconPart._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), CompoundBeacon_Compile.ValidCompoundBeacon._typeDescriptor());
            } else {
              dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart> _12_encrypted = (_11_valueOrError4).Extract(dafny.DafnySequence.<CompoundBeacon_Compile.BeaconPart>_typeDescriptor(CompoundBeacon_Compile.BeaconPart._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
              Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _13_valueOrError5 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), !(converted).<dafny.DafnySequence<? extends Character>>contains((beacon).dtor_name()), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Duplicate CompoundBeacon name : "), (beacon).dtor_name())));
              if ((_13_valueOrError5).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
                return (_13_valueOrError5).<CompoundBeacon_Compile.CompoundBeacon>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), CompoundBeacon_Compile.ValidCompoundBeacon._typeDescriptor());
              } else {
                Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _14_valueOrError6 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), (((beacon).dtor_constructors()).is_None()) || ((java.math.BigInteger.valueOf((((beacon).dtor_constructors()).dtor_value()).length())).signum() == 1), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("For beacon "), (beacon).dtor_name()), dafny.DafnySequence.asString(" an empty constructor list was supplied."))));
                if ((_14_valueOrError6).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
                  return (_14_valueOrError6).<CompoundBeacon_Compile.CompoundBeacon>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), CompoundBeacon_Compile.ValidCompoundBeacon._typeDescriptor());
                } else {
                  Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _15_valueOrError7 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), ((((beacon).dtor_constructors()).is_Some()) || ((java.math.BigInteger.valueOf((_0_signedParts).length())).signum() != 0)) || ((java.math.BigInteger.valueOf((_1_encryptedParts).length())).signum() != 0), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Compound beacon "), (beacon).dtor_name()), dafny.DafnySequence.asString(" defines no constructors, and also no local parts. Cannot make a default constructor from global parts."))));
                  if ((_15_valueOrError7).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
                    return (_15_valueOrError7).<CompoundBeacon_Compile.CompoundBeacon>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), CompoundBeacon_Compile.ValidCompoundBeacon._typeDescriptor());
                  } else {
                    long _16_numNon = (long) (_10_signed).cardinalityInt();
                    dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart> _17_allParts = dafny.DafnySequence.<CompoundBeacon_Compile.BeaconPart>concatenate(_10_signed, _12_encrypted);
                    boolean _18_isSignedBeacon = (java.math.BigInteger.valueOf((_12_encrypted).length())).signum() == 0;
                    Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _19_valueOrError8 = __default.BeaconNameAllowed(outer, virtualFields, (beacon).dtor_name(), dafny.DafnySequence.asString("CompoundBeacon"), _18_isSignedBeacon);
                    if ((_19_valueOrError8).IsFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
                      return (_19_valueOrError8).<CompoundBeacon_Compile.CompoundBeacon>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), CompoundBeacon_Compile.ValidCompoundBeacon._typeDescriptor());
                    } else {
                      boolean _20___v5 = (_19_valueOrError8).Extract(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
                      Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _21_valueOrError9 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), (java.math.BigInteger.valueOf((_17_allParts).length())).signum() == 1, DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("For beacon "), (beacon).dtor_name()), dafny.DafnySequence.asString(" no parts were supplied."))));
                      if ((_21_valueOrError9).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
                        return (_21_valueOrError9).<CompoundBeacon_Compile.CompoundBeacon>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), CompoundBeacon_Compile.ValidCompoundBeacon._typeDescriptor());
                      } else {
                        Wrappers_Compile.Result<dafny.DafnySequence<? extends CompoundBeacon_Compile.Constructor>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _22_valueOrError10 = __default.AddConstructors((beacon).dtor_constructors(), (beacon).dtor_name(), _17_allParts);
                        if ((_22_valueOrError10).IsFailure(dafny.DafnySequence.<CompoundBeacon_Compile.Constructor>_typeDescriptor(CompoundBeacon_Compile.Constructor._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
                          return (_22_valueOrError10).<CompoundBeacon_Compile.CompoundBeacon>PropagateFailure(dafny.DafnySequence.<CompoundBeacon_Compile.Constructor>_typeDescriptor(CompoundBeacon_Compile.Constructor._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), CompoundBeacon_Compile.ValidCompoundBeacon._typeDescriptor());
                        } else {
                          dafny.DafnySequence<? extends CompoundBeacon_Compile.Constructor> _23_constructors = (_22_valueOrError10).Extract(dafny.DafnySequence.<CompoundBeacon_Compile.Constructor>_typeDescriptor(CompoundBeacon_Compile.Constructor._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
                          dafny.DafnySequence<? extends Character> _24_beaconName = ((_18_isSignedBeacon) ? ((beacon).dtor_name()) : (dafny.DafnySequence.<Character>concatenate(DynamoDbEncryptionUtil_Compile.__default.BeaconPrefix(), (beacon).dtor_name())));
                          Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _25_valueOrError11 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.__default.IsValid__AttributeName(_24_beaconName), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(_24_beaconName, dafny.DafnySequence.asString(" is not a valid attribute name."))));
                          if ((_25_valueOrError11).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
                            return (_25_valueOrError11).<CompoundBeacon_Compile.CompoundBeacon>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), CompoundBeacon_Compile.ValidCompoundBeacon._typeDescriptor());
                          } else {
                            return CompoundBeacon_Compile.__default.MakeCompoundBeacon(BaseBeacon_Compile.BeaconBase.create(client, (beacon).dtor_name(), _24_beaconName), ((char)(java.lang.Object)(((beacon).dtor_split()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), _17_allParts, dafny.Helpers.unsignedToBigInteger(_16_numNon), _23_constructors);
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
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> AddCompoundBeacons(dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon> beacons, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig outer, software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient client, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> virtualFields, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon> converted, PartSet globalSignedParts, PartSet globalEncryptedParts)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> output = (Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    if(true) {
      if ((java.math.BigInteger.valueOf((beacons).length())).signum() == 0) {
        output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(SearchableEncryptionInfo_Compile.BeaconMap._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), converted);
        return output;
      }
      Wrappers_Compile.Result<CompoundBeacon_Compile.CompoundBeacon, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = (Wrappers_Compile.Result<CompoundBeacon_Compile.CompoundBeacon, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
      _0_valueOrError0 = __default.CreateCompoundBeacon(((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon)(java.lang.Object)((beacons).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), outer, client, virtualFields, converted, globalSignedParts, globalEncryptedParts);
      if ((_0_valueOrError0).IsFailure(CompoundBeacon_Compile.ValidCompoundBeacon._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        output = (_0_valueOrError0).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>>PropagateFailure(CompoundBeacon_Compile.ValidCompoundBeacon._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.BeaconMap._typeDescriptor());
        return output;
      }
      CompoundBeacon_Compile.CompoundBeacon _1_newBeacon;
      _1_newBeacon = (_0_valueOrError0).Extract(CompoundBeacon_Compile.ValidCompoundBeacon._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out0;
      _out0 = __default.AddCompoundBeacons((beacons).drop(java.math.BigInteger.ONE), outer, client, virtualFields, dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, SearchableEncryptionInfo_Compile.Beacon>update(converted, (((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.CompoundBeacon)(java.lang.Object)((beacons).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name(), SearchableEncryptionInfo_Compile.Beacon.create_Compound(_1_newBeacon)), globalSignedParts, globalEncryptedParts);
      output = _out0;
    }
    return output;
  }
  public static boolean ExistsInCompound(dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> names, dafny.DafnySequence<? extends Character> name, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon> data)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((names).length())).signum() == 0) {
        return false;
      } else {
        SearchableEncryptionInfo_Compile.Beacon _0_b = ((SearchableEncryptionInfo_Compile.Beacon)(java.lang.Object)((data).get(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((names).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))));
        if (((_0_b).is_Compound()) && (((_0_b).dtor_cmp()).HasBeacon(name))) {
          return true;
        } else {
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in0 = (names).drop(java.math.BigInteger.ONE);
          dafny.DafnySequence<? extends Character> _in1 = name;
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon> _in2 = data;
          names = _in0;
          name = _in1;
          data = _in2;
          continue TAIL_CALL_START;
        }
      }
    }
  }
  public static Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> CheckAllBeacons(dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> names, dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> allNames, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon> data)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((names).length())).signum() == 0) {
        return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), true);
      } else {
        SearchableEncryptionInfo_Compile.Beacon _0_b = ((SearchableEncryptionInfo_Compile.Beacon)(java.lang.Object)((data).get(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((names).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))));
        if ((SearchableEncryptionInfo_Compile.__default.IsPartOnly(_0_b)) && (!(__default.ExistsInCompound(allNames, ((dafny.DafnySequence<? extends Character>)(java.lang.Object)((names).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), data)))) {
          return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Failure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("PartOnly beacon "), ((dafny.DafnySequence<? extends Character>)(java.lang.Object)((names).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))), dafny.DafnySequence.asString(" MUST be used in a compound beacon."))));
        } else if (((_0_b).is_Standard()) && ((((_0_b).dtor_std()).dtor_share()).is_Some())) {
          Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _1_valueOrError0 = __default.IsValidShare(data, ((dafny.DafnySequence<? extends Character>)(java.lang.Object)((names).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), ((_0_b).dtor_std()).dtor_length(), (((_0_b).dtor_std()).dtor_share()).dtor_value());
          if ((_1_valueOrError0).IsFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
            return (_1_valueOrError0).<Boolean>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
          } else {
            boolean _2___v6 = (_1_valueOrError0).Extract(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
            dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in0 = (names).drop(java.math.BigInteger.ONE);
            dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in1 = allNames;
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon> _in2 = data;
            names = _in0;
            allNames = _in1;
            data = _in2;
            continue TAIL_CALL_START;
          }
        } else {
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in3 = (names).drop(java.math.BigInteger.ONE);
          dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in4 = allNames;
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon> _in5 = data;
          names = _in3;
          allNames = _in4;
          data = _in5;
          continue TAIL_CALL_START;
        }
      }
    }
  }
  public static Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> CheckBeacons(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon> data) {
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _0_beaconNames = SortedSets.__default.<Character>SetToOrderedSequence2(dafny.TypeDescriptor.CHAR, (data).keySet(), DynamoDbEncryptionUtil_Compile.__default::CharLess);
    return __default.CheckAllBeacons(_0_beaconNames, _0_beaconNames, data);
  }
  @Override
  public java.lang.String toString() {
    return "SearchConfigToInfo._default";
  }
}
