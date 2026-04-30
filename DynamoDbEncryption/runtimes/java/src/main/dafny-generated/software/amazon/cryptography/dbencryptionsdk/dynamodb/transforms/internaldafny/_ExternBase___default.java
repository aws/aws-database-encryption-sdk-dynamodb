// Class _ExternBase___default
// Dafny class __default compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny;

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class _ExternBase___default {
  public _ExternBase___default() {
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTablesEncryptionConfig DefaultDynamoDbTablesEncryptionConfig() {
    return software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTablesEncryptionConfig.create(dafny.DafnyMap.fromElements());
  }
  public static dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> AddSignedBeaconActions(dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> names, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> actions, java.math.BigInteger pos)
  {
    TAIL_CALL_START: while (true) {
      if (java.util.Objects.equals(java.math.BigInteger.valueOf((names).length()), pos)) {
        return actions;
      } else {
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in0 = names;
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> _in1 = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction>update(actions, ((dafny.DafnySequence<? extends Character>)(java.lang.Object)((names).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__ONLY());
        java.math.BigInteger _in2 = (pos).add(java.math.BigInteger.ONE);
        names = _in0;
        actions = _in1;
        pos = _in2;
        continue TAIL_CALL_START;
      }
    }
  }
  public static boolean IsConfigured(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig config, dafny.DafnySequence<? extends Character> name)
  {
    return ((((config).dtor_attributeActionsOnEncrypt()).<dafny.DafnySequence<? extends Character>>contains(name)) || ((((config).dtor_allowedUnsignedAttributes()).is_Some()) && ((((config).dtor_allowedUnsignedAttributes()).dtor_value()).contains(name)))) || ((((config).dtor_allowedUnsignedAttributePrefix()).is_Some()) && ((((config).dtor_allowedUnsignedAttributePrefix()).dtor_value()).isPrefixOf(name)));
  }
  public static Wrappers_Compile.Result<DynamoDbEncryptionTransformsClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> DynamoDbEncryptionTransforms(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTablesEncryptionConfig config)
  {
    Wrappers_Compile.Result<DynamoDbEncryptionTransformsClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> res = (Wrappers_Compile.Result<DynamoDbEncryptionTransformsClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>)null;
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbMiddlewareConfig_Compile.TableConfig> _0_internalConfigs;
    _0_internalConfigs = dafny.DafnyMap.fromElements();
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig> _1_m_k;
    _1_m_k = (config).dtor_tableEncryptionConfigs();
    dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> _2_mKeys;
    _2_mKeys = (_1_m_k).keySet();
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _3_tableNamesSeq;
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _out0;
    _out0 = SortedSets.__default.<dafny.DafnySequence<? extends Character>>SetToSequence(software.amazon.cryptography.services.dynamodb.internaldafny.types.TableName._typeDescriptor(), _2_mKeys);
    _3_tableNamesSeq = _out0;
    dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> _4_allLogicalTableNames;
    _4_allLogicalTableNames = dafny.DafnySet.<dafny.DafnySequence<? extends Character>> empty();
    java.math.BigInteger _5_i = java.math.BigInteger.ZERO;
    _5_i = java.math.BigInteger.ZERO;
    while ((_5_i).compareTo(java.math.BigInteger.valueOf((_3_tableNamesSeq).length())) < 0) {
      dafny.DafnySequence<? extends Character> _6_tableName;
      _6_tableName = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)((_3_tableNamesSeq).select(dafny.Helpers.toInt((_5_i)))));
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig _7_inputConfig;
      _7_inputConfig = ((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig)(java.lang.Object)(((config).dtor_tableEncryptionConfigs()).get(_6_tableName)));
      Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _8_valueOrError0 = Wrappers_Compile.Outcome.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor());
      _8_valueOrError0 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), !(_4_allLogicalTableNames).<dafny.DafnySequence<? extends Character>>contains((_7_inputConfig).dtor_logicalTableName()), DdbMiddlewareConfig_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Duplicate logical table mapped to multiple physical tables: "), (_7_inputConfig).dtor_logicalTableName())));
      if ((_8_valueOrError0).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor())) {
        res = (_8_valueOrError0).<DynamoDbEncryptionTransformsClient>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), ((dafny.TypeDescriptor<DynamoDbEncryptionTransformsClient>)(java.lang.Object)dafny.TypeDescriptor.reference(DynamoDbEncryptionTransformsClient.class)));
        return res;
      }
      Wrappers_Compile.Result<Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _9_searchR;
      Wrappers_Compile.Result<Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out1;
      _out1 = SearchConfigToInfo_Compile.__default.Convert(_7_inputConfig);
      _9_searchR = _out1;
      Wrappers_Compile.Result<Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo>, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _10_valueOrError1 = Wrappers_Compile.Result.<Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo>, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>Default(Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.SearchInfo>_typeDescriptor(SearchableEncryptionInfo_Compile.SearchInfo._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.SearchInfo>Default(SearchableEncryptionInfo_Compile.SearchInfo._typeDescriptor()));
      _10_valueOrError1 = (_9_searchR).<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>MapFailure(Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.SearchInfo>_typeDescriptor(SearchableEncryptionInfo_Compile.SearchInfo._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>)(_11_e_boxed0) -> {
        software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error _11_e = ((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error)(java.lang.Object)(_11_e_boxed0));
        return software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error.create_AwsCryptographyDbEncryptionSdkDynamoDb(_11_e);
      }));
      if ((_10_valueOrError1).IsFailure(Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.SearchInfo>_typeDescriptor(SearchableEncryptionInfo_Compile.SearchInfo._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor())) {
        res = (_10_valueOrError1).<DynamoDbEncryptionTransformsClient>PropagateFailure(Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.SearchInfo>_typeDescriptor(SearchableEncryptionInfo_Compile.SearchInfo._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), ((dafny.TypeDescriptor<DynamoDbEncryptionTransformsClient>)(java.lang.Object)dafny.TypeDescriptor.reference(DynamoDbEncryptionTransformsClient.class)));
        return res;
      }
      Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo> _12_search;
      _12_search = (_10_valueOrError1).Extract(Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.SearchInfo>_typeDescriptor(SearchableEncryptionInfo_Compile.SearchInfo._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor());
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _13_signedBeacons;
      if ((_12_search).is_None()) {
        _13_signedBeacons = dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> empty(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
      } else {
        _13_signedBeacons = (((_12_search).dtor_value()).curr()).ListSignedBeacons();
      }
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _14_badBeacons;
      _14_badBeacons = Seq_Compile.__default.<dafny.DafnySequence<? extends Character>>Filter(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((java.util.function.Function<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig, java.util.function.Function<dafny.DafnySequence<? extends Character>, Boolean>>)(_15_inputConfig) -> ((java.util.function.Function<dafny.DafnySequence<? extends Character>, Boolean>)(_16_s_boxed0) -> {
        dafny.DafnySequence<? extends Character> _16_s = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_16_s_boxed0));
        return __default.IsConfigured(_15_inputConfig, _16_s);
      })).apply(_7_inputConfig), _13_signedBeacons);
      if ((java.math.BigInteger.valueOf((_14_badBeacons).length())).signum() == 1) {
        res = Wrappers_Compile.Result.<DynamoDbEncryptionTransformsClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>create_Failure(((dafny.TypeDescriptor<DynamoDbEncryptionTransformsClient>)(java.lang.Object)dafny.TypeDescriptor.reference(DynamoDbEncryptionTransformsClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), DdbMiddlewareConfig_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Signed beacons cannot be configured with CryptoActions or as unauthenticated : "), StandardLibrary_Compile.__default.<Character>Join(dafny.TypeDescriptor.CHAR, _14_badBeacons, dafny.DafnySequence.asString(", ")))));
        return res;
      }
      Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _17_valueOrError2 = Wrappers_Compile.Outcome.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor());
      _17_valueOrError2 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, Boolean>)(_18_signedBeacons) -> dafny.Helpers.Quantifier((_18_signedBeacons).UniqueElements(), true, ((_forall_var_0_boxed0) -> {
        dafny.DafnySequence<? extends Character> _forall_var_0 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_forall_var_0_boxed0));
        dafny.DafnySequence<? extends Character> _19_k = (dafny.DafnySequence<? extends Character>)_forall_var_0;
        return !((_18_signedBeacons).contains(_19_k)) || (software.amazon.cryptography.services.dynamodb.internaldafny.types.__default.IsValid__AttributeName(_19_k));
      }))).apply(_13_signedBeacons), DdbMiddlewareConfig_Compile.__default.E(dafny.DafnySequence.asString("Beacon configured with bad name")));
      if ((_17_valueOrError2).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor())) {
        res = (_17_valueOrError2).<DynamoDbEncryptionTransformsClient>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), ((dafny.TypeDescriptor<DynamoDbEncryptionTransformsClient>)(java.lang.Object)dafny.TypeDescriptor.reference(DynamoDbEncryptionTransformsClient.class)));
        return res;
      }
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> _20_newActions;
      _20_newActions = __default.AddSignedBeaconActions(_13_signedBeacons, (_7_inputConfig).dtor_attributeActionsOnEncrypt(), java.math.BigInteger.ZERO);
      software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig _21_encryptorConfig;
      _21_encryptorConfig = software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig.create((_7_inputConfig).dtor_logicalTableName(), (_7_inputConfig).dtor_partitionKeyName(), (_7_inputConfig).dtor_sortKeyName(), _20_newActions, (_7_inputConfig).dtor_allowedUnsignedAttributes(), (_7_inputConfig).dtor_allowedUnsignedAttributePrefix(), (_7_inputConfig).dtor_algorithmSuiteId(), (_7_inputConfig).dtor_keyring(), (_7_inputConfig).dtor_cmm(), (_7_inputConfig).dtor_legacyOverride(), (_7_inputConfig).dtor_plaintextOverride());
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> _22_itemEncryptorRes;
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> _out2;
      _out2 = software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.__default.DynamoDbItemEncryptor(_21_encryptorConfig);
      _22_itemEncryptorRes = _out2;
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _23_valueOrError3 = (Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>)null;
      _23_valueOrError3 = (_22_itemEncryptorRes).<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>MapFailure(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>)(_24_e_boxed0) -> {
        software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error _24_e = ((software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error)(java.lang.Object)(_24_e_boxed0));
        return software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error.create_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor(_24_e);
      }));
      if ((_23_valueOrError3).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor())) {
        res = (_23_valueOrError3).<DynamoDbEncryptionTransformsClient>PropagateFailure(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), ((dafny.TypeDescriptor<DynamoDbEncryptionTransformsClient>)(java.lang.Object)dafny.TypeDescriptor.reference(DynamoDbEncryptionTransformsClient.class)));
        return res;
      }
      software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.IDynamoDbItemEncryptorClient _25_itemEncryptorX;
      _25_itemEncryptorX = (_23_valueOrError3).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor());
      software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient _26_itemEncryptor;
      _26_itemEncryptor = ((software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient)(java.lang.Object)(_25_itemEncryptorX));
      AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations_Compile.Config _27_encConfig;
      _27_encConfig = (_26_itemEncryptor).config();
      DdbMiddlewareConfig_Compile.TableConfig _28_internalConfig;
      _28_internalConfig = DdbMiddlewareConfig_Compile.TableConfig.create(_6_tableName, (_7_inputConfig).dtor_logicalTableName(), (_7_inputConfig).dtor_partitionKeyName(), (_7_inputConfig).dtor_sortKeyName(), _26_itemEncryptor, _12_search, ((_7_inputConfig).dtor_plaintextOverride()).UnwrapOr(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PlaintextOverride._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PlaintextOverride.create_FORBID__PLAINTEXT__WRITE__FORBID__PLAINTEXT__READ()));
      _0_internalConfigs = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, DdbMiddlewareConfig_Compile.TableConfig>update(_0_internalConfigs, _6_tableName, _28_internalConfig);
      _4_allLogicalTableNames = dafny.DafnySet.<dafny.DafnySequence<? extends Character>>union(_4_allLogicalTableNames, dafny.DafnySet.<dafny.DafnySequence<? extends Character>> of((_28_internalConfig).dtor_logicalTableName()));
      _5_i = (_5_i).add(java.math.BigInteger.ONE);
    }
    DdbMiddlewareConfig_Compile.Config _29_newConfig;
    _29_newConfig = DdbMiddlewareConfig_Compile.Config.create(_0_internalConfigs);
    DynamoDbEncryptionTransformsClient _30_client;
    DynamoDbEncryptionTransformsClient _nw0 = new DynamoDbEncryptionTransformsClient();
    _nw0.__ctor(_29_newConfig);
    _30_client = _nw0;
    res = Wrappers_Compile.Result.<DynamoDbEncryptionTransformsClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>create_Success(((dafny.TypeDescriptor<DynamoDbEncryptionTransformsClient>)(java.lang.Object)dafny.TypeDescriptor.reference(DynamoDbEncryptionTransformsClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), _30_client);
    return res;
  }
  public static Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.IDynamoDbEncryptionTransformsClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> CreateSuccessOfClient(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.IDynamoDbEncryptionTransformsClient client) {
    return Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.IDynamoDbEncryptionTransformsClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>create_Success(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.IDynamoDbEncryptionTransformsClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.IDynamoDbEncryptionTransformsClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), client);
  }
  public static Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.IDynamoDbEncryptionTransformsClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> CreateFailureOfError(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error error) {
    return Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.IDynamoDbEncryptionTransformsClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>create_Failure(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.IDynamoDbEncryptionTransformsClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.IDynamoDbEncryptionTransformsClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), error);
  }
  @Override
  public java.lang.String toString() {
    return "DynamoDbEncryptionTransforms._default";
  }
}
