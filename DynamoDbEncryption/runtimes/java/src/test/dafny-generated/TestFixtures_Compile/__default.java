// Class __default
// Dafny class __default compiled into Java
package TestFixtures_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static dafny.DafnySequence<? extends Character> GetTableName(dafny.DafnySequence<? extends Character> s)
  {
    dafny.DafnySequence<? extends Character> output = dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR);
    if (!(software.amazon.cryptography.services.dynamodb.internaldafny.types.__default.IsValid__TableName(s))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(24,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    output = s;
    return output;
  }
  public static dafny.DafnySequence<? extends Character> GetAttrName(dafny.DafnySequence<? extends Character> s) {
    if (software.amazon.cryptography.services.dynamodb.internaldafny.types.__default.IsValid__AttributeName(s)) {
      return s;
    } else {
      return dafny.DafnySequence.asString("abc");
    }
  }
  public static dafny.DafnySequence<? extends Character> GetStatement(dafny.DafnySequence<? extends Character> s)
  {
    dafny.DafnySequence<? extends Character> output = dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR);
    if (!(software.amazon.cryptography.services.dynamodb.internaldafny.types.__default.IsValid__PartiQLStatement(s))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(36,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    output = s;
    return output;
  }
  public static dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.ParameterizedStatement> GetPStatements(dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.ParameterizedStatement> s)
  {
    dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.ParameterizedStatement> output = dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ParameterizedStatement> empty(software.amazon.cryptography.services.dynamodb.internaldafny.types.ParameterizedStatement._typeDescriptor());
    if (!(software.amazon.cryptography.services.dynamodb.internaldafny.types.__default.IsValid__ParameterizedStatements(s))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(41,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    output = s;
    return output;
  }
  public static dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItem> GetTransactWriteItemList(dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItem> s)
  {
    dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItem> output = dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItem> empty(software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactWriteItem._typeDescriptor());
    if (!(software.amazon.cryptography.services.dynamodb.internaldafny.types.__default.IsValid__TransactWriteItemList(s))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(47,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    output = s;
    return output;
  }
  public static dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest>> GetBatchWriteItemRequestMap(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest>> s)
  {
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest>> output = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest>> empty();
    if (!(software.amazon.cryptography.services.dynamodb.internaldafny.types.__default.IsValid__BatchWriteItemRequestMap(s))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(52,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    output = s;
    return output;
  }
  public static dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest> GetWriteRequests(dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest> s)
  {
    dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest> output = dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest> empty(software.amazon.cryptography.services.dynamodb.internaldafny.types.WriteRequest._typeDescriptor());
    if (!(software.amazon.cryptography.services.dynamodb.internaldafny.types.__default.IsValid__WriteRequests(s))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(57,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    output = s;
    return output;
  }
  public static dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.KeysAndAttributes> GetBatchGetRequestMap(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.KeysAndAttributes> s)
  {
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.KeysAndAttributes> output = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.KeysAndAttributes> empty();
    if (!(software.amazon.cryptography.services.dynamodb.internaldafny.types.__default.IsValid__BatchGetRequestMap(s))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(62,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    output = s;
    return output;
  }
  public static dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> GetKeyList(dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> s)
  {
    dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> output = dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> empty(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()));
    if (!(software.amazon.cryptography.services.dynamodb.internaldafny.types.__default.IsValid__KeyList(s))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(67,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    output = s;
    return output;
  }
  public static dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItem> GetTransactGetItemList(dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItem> s)
  {
    dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItem> output = dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItem> empty(software.amazon.cryptography.services.dynamodb.internaldafny.types.TransactGetItem._typeDescriptor());
    if (!(software.amazon.cryptography.services.dynamodb.internaldafny.types.__default.IsValid__TransactGetItemList(s))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(72,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    output = s;
    return output;
  }
  public static dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementRequest> GetPartiQLBatchRequest(dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementRequest> s)
  {
    dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementRequest> output = dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementRequest> empty(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementRequest._typeDescriptor());
    if (!(software.amazon.cryptography.services.dynamodb.internaldafny.types.__default.IsValid__PartiQLBatchRequest(s))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(77,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    output = s;
    return output;
  }
  public static dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> GetAttributeActions() {
    return dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("bar"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__ONLY()), new dafny.Tuple2(dafny.DafnySequence.asString("encrypt"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN()), new dafny.Tuple2(dafny.DafnySequence.asString("sign"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__ONLY()), new dafny.Tuple2(dafny.DafnySequence.asString("nothing"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_DO__NOTHING()));
  }
  public static dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> GetV2AttributeActions() {
    return dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("bar"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT()), new dafny.Tuple2(dafny.DafnySequence.asString("encrypt"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN()), new dafny.Tuple2(dafny.DafnySequence.asString("sign"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT()), new dafny.Tuple2(dafny.DafnySequence.asString("nothing"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_DO__NOTHING()));
  }
  public static dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> GetSignedAttributeActions() {
    return dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("bar"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__ONLY()), new dafny.Tuple2(dafny.DafnySequence.asString("encrypt"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN()), new dafny.Tuple2(dafny.DafnySequence.asString("sign"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__ONLY()));
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig GetEncryptorConfigFromActions(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> actions, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> sortKeyName)
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig output = (software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig)null;
    if(true) {
      software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring _0_keyring;
      software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring _out0;
      _out0 = __default.GetKmsKeyring();
      _0_keyring = _out0;
      dafny.DafnySequence<? extends Character> _1_logicalTableName;
      dafny.DafnySequence<? extends Character> _out1;
      _out1 = __default.GetTableName(dafny.DafnySequence.asString("foo"));
      _1_logicalTableName = _out1;
      output = software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig.create(_1_logicalTableName, dafny.DafnySequence.asString("bar"), sortKeyName, actions, Wrappers_Compile.Option.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>create_Some(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("nothing"))), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Wrappers_Compile.Option.<software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId>create_None(software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring>create_Some(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring.class)), _0_keyring), Wrappers_Compile.Option.<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager>create_None(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager.class))), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.LegacyOverride>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.LegacyOverride._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PlaintextOverride>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PlaintextOverride._typeDescriptor()));
    }
    return output;
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig GetEncryptorConfig()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig output = (software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig)null;
    if(true) {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig _out0;
      _out0 = __default.GetEncryptorConfigFromActions(__default.GetAttributeActions(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.KeySchemaAttributeName._typeDescriptor()));
      output = _out0;
    }
    return output;
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient GetDynamoDbItemEncryptorFrom(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig config)
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient encryptor = null;
    if(true) {
      software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring _0_keyring;
      software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring _out0;
      _out0 = __default.GetKmsKeyring();
      _0_keyring = _out0;
      software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig _1_encryptorConfig;
      _1_encryptorConfig = software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig.create((config).dtor_logicalTableName(), (config).dtor_partitionKeyName(), (config).dtor_sortKeyName(), (config).dtor_attributeActionsOnEncrypt(), (config).dtor_allowedUnsignedAttributes(), (config).dtor_allowedUnsignedAttributePrefix(), Wrappers_Compile.Option.<software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId>create_None(software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring>create_Some(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring.class)), _0_keyring), Wrappers_Compile.Option.<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager>create_None(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager.class))), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.LegacyOverride>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.LegacyOverride._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PlaintextOverride>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PlaintextOverride._typeDescriptor()));
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> _2_valueOrError0 = (Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error>)null;
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error> _out1;
      _out1 = software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.__default.DynamoDbItemEncryptor(_1_encryptorConfig);
      _2_valueOrError0 = _out1;
      if (!(!((_2_valueOrError0).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error._typeDescriptor())))) {
        throw new dafny.DafnyHaltException("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(132,53): " + java.lang.String.valueOf(_2_valueOrError0));
      }
      software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.IDynamoDbItemEncryptorClient _3_encryptor2;
      _3_encryptor2 = (_2_valueOrError0).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.Error._typeDescriptor());
      encryptor = ((software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient)(java.lang.Object)(_3_encryptor2));
    }
    return encryptor;
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient GetDynamoDbItemEncryptor()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient encryptor = null;
    if(true) {
      software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig _0_config;
      software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.types.DynamoDbItemEncryptorConfig _out0;
      _out0 = __default.GetEncryptorConfig();
      _0_config = _out0;
      software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.internaldafny.DynamoDbItemEncryptorClient _out1;
      _out1 = __default.GetDynamoDbItemEncryptorFrom(_0_config);
      encryptor = _out1;
    }
    return encryptor;
  }
  public static <__X> void expect__ok(dafny.TypeDescriptor<__X> _td___X, dafny.DafnySequence<? extends Character> tag, Wrappers_Compile.Result<__X, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> actual)
  {
    if ((actual).is_Failure()) {
      System.out.print((tag).verbatimString());
      System.out.print((dafny.DafnySequence.asString("\t")).verbatimString());
      System.out.print(java.lang.String.valueOf(actual));
    }
    if (!((actual).is_Success())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(154,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static <__X> void expect__equal(dafny.TypeDescriptor<__X> _td___X, dafny.DafnySequence<? extends Character> tag, __X actual, __X expected)
  {
    if (!java.util.Objects.equals(actual, expected)) {
      System.out.print((tag).verbatimString());
      System.out.print((dafny.DafnySequence.asString("\texpected\n")).verbatimString());
      System.out.print(java.lang.String.valueOf(expected));
      System.out.print((dafny.DafnySequence.asString("\ngot\n")).verbatimString());
      System.out.print(java.lang.String.valueOf(actual));
      System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
    }
    if (!(java.util.Objects.equals(actual, expected))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(161,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static <__X> void ExpectFailure(dafny.TypeDescriptor<__X> _td___X, Wrappers_Compile.Result<__X, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> ret, dafny.DafnySequence<? extends Character> s)
  {
    if (!((ret).is_Failure())) {
      System.out.print((dafny.DafnySequence.asString("Got Success when expected failure ")).verbatimString());
      System.out.print((s).verbatimString());
      System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
    }
    if (!((ret).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(169,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((ret).dtor_error()).is_DynamoDbEncryptionTransformsException())) {
      System.out.print((dafny.DafnySequence.asString("Error type not DynamoDbEncryptionTransformsException : ")).verbatimString());
      System.out.print(java.lang.String.valueOf(ret));
      System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
    }
    if (!(((ret).dtor_error()).is_DynamoDbEncryptionTransformsException())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(173,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((ret).dtor_error()).dtor_message()).equals(s)) {
      System.out.print((dafny.DafnySequence.asString("Expected error message '")).verbatimString());
      System.out.print((s).verbatimString());
      System.out.print((dafny.DafnySequence.asString("' got message '")).verbatimString());
      System.out.print((((ret).dtor_error()).dtor_message()).verbatimString());
      System.out.print((dafny.DafnySequence.asString("'\n")).verbatimString());
    }
    if (!((((ret).dtor_error()).dtor_message()).equals(s))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(177,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring GetKmsKeyring()
  {
    software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring keyring = null;
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _0_valueOrError0 = (Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient, software.amazon.cryptography.materialproviders.internaldafny.types.Error>)null;
      Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _out0;
      _out0 = software.amazon.cryptography.materialproviders.internaldafny.__default.MaterialProviders(software.amazon.cryptography.materialproviders.internaldafny.__default.DefaultMaterialProvidersConfig());
      _0_valueOrError0 = _out0;
      if (!(!((_0_valueOrError0).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient.class)), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor())))) {
        throw new dafny.DafnyHaltException("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(186,19): " + java.lang.String.valueOf(_0_valueOrError0));
      }
      software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient _1_matProv;
      _1_matProv = (_0_valueOrError0).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient.class)), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor());
      software.amazon.cryptography.materialproviders.internaldafny.types.CreateAwsKmsMultiKeyringInput _2_keyringInput;
      _2_keyringInput = software.amazon.cryptography.materialproviders.internaldafny.types.CreateAwsKmsMultiKeyringInput.create(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), __default.PUBLIC__US__WEST__2__KMS__TEST__KEY()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>create_None(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))), Wrappers_Compile.Option.<software.amazon.cryptography.materialproviders.internaldafny.types.IClientSupplier>create_None(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.IClientSupplier>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.types.IClientSupplier.class))), Wrappers_Compile.Option.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>create_None(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))));
      Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _3_valueOrError1 = (Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring, software.amazon.cryptography.materialproviders.internaldafny.types.Error>)null;
      Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _out1;
      _out1 = (_1_matProv).CreateAwsKmsMultiKeyring(_2_keyringInput);
      _3_valueOrError1 = _out1;
      if (!(!((_3_valueOrError1).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring.class)), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor())))) {
        throw new dafny.DafnyHaltException("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(190,15): " + java.lang.String.valueOf(_3_valueOrError1));
      }
      keyring = (_3_valueOrError1).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring.class)), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor());
    }
    return keyring;
  }
  public static software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring GetStaticKeyring()
  {
    software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring keyring = null;
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _0_valueOrError0 = (Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient, software.amazon.cryptography.materialproviders.internaldafny.types.Error>)null;
      Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _out0;
      _out0 = software.amazon.cryptography.materialproviders.internaldafny.__default.MaterialProviders(software.amazon.cryptography.materialproviders.internaldafny.__default.DefaultMaterialProvidersConfig());
      _0_valueOrError0 = _out0;
      if (!(!((_0_valueOrError0).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient.class)), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor())))) {
        throw new dafny.DafnyHaltException("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(199,19): " + java.lang.String.valueOf(_0_valueOrError0));
      }
      software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient _1_matProv;
      _1_matProv = (_0_valueOrError0).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient.class)), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor());
      Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _2_valueOrError1 = (Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring, software.amazon.cryptography.materialproviders.internaldafny.types.Error>)null;
      Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _out1;
      _out1 = (_1_matProv).CreateRawAesKeyring(software.amazon.cryptography.materialproviders.internaldafny.types.CreateRawAesKeyringInput.create(dafny.DafnySequence.asString("foo"), dafny.DafnySequence.asString("bar"), dafny.DafnySequence.Create(BoundedInts_Compile.uint8._typeDescriptor(), java.math.BigInteger.valueOf(32L), ((java.util.function.Function<java.math.BigInteger, java.lang.Byte>)(_3_i_boxed0) -> {
  java.math.BigInteger _3_i = ((java.math.BigInteger)(java.lang.Object)(_3_i_boxed0));
  return (byte) 0;
})), software.amazon.cryptography.materialproviders.internaldafny.types.AesWrappingAlg.create_ALG__AES256__GCM__IV12__TAG16()));
      _2_valueOrError1 = _out1;
      if (!(!((_2_valueOrError1).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring.class)), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor())))) {
        throw new dafny.DafnyHaltException("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(200,15): " + java.lang.String.valueOf(_2_valueOrError1));
      }
      keyring = (_2_valueOrError1).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring.class)), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor());
    }
    return keyring;
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient GetDynamoDbEncryptionTransforms()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient encryption = null;
    if(true) {
      software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring _0_keyring;
      software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring _out0;
      _out0 = __default.GetKmsKeyring();
      _0_keyring = _out0;
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _1_valueOrError0 = (Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>)null;
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out1;
      _out1 = software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.__default.DynamoDbEncryptionTransforms(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTablesEncryptionConfig.create(dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("foo"), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig.create(dafny.DafnySequence.asString("foo"), dafny.DafnySequence.asString("bar"), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.KeySchemaAttributeName._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SearchConfig>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SearchConfig._typeDescriptor()), dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("bar"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__ONLY()), new dafny.Tuple2(dafny.DafnySequence.asString("sign"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__ONLY()), new dafny.Tuple2(dafny.DafnySequence.asString("encrypt"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN()), new dafny.Tuple2(dafny.DafnySequence.asString("plain"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_DO__NOTHING())), Wrappers_Compile.Option.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>create_Some(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("plain"))), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Wrappers_Compile.Option.<software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId>create_None(software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring>create_Some(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring.class)), _0_keyring), Wrappers_Compile.Option.<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager>create_None(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager.class))), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.LegacyOverride>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.LegacyOverride._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PlaintextOverride>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PlaintextOverride._typeDescriptor()))))));
      _1_valueOrError0 = _out1;
      if (!(!((_1_valueOrError0).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor())))) {
        throw new dafny.DafnyHaltException("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(217,18): " + java.lang.String.valueOf(_1_valueOrError0));
      }
      encryption = (_1_valueOrError0).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor());
    }
    return encryption;
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient GetDynamoDbEncryptionTransforms2()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient encryption = null;
    if(true) {
      if (!(software.amazon.cryptography.services.dynamodb.internaldafny.types.__default.IsValid__TableName(dafny.DafnySequence.asString("foo")))) {
        throw new dafny.DafnyHaltException("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(247,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
      }
      software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring _0_keyring;
      software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring _out0;
      _out0 = __default.GetKmsKeyring();
      _0_keyring = _out0;
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _1_valueOrError0 = (Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>)null;
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out1;
      _out1 = software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.__default.DynamoDbEncryptionTransforms(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTablesEncryptionConfig.create(dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("foo"), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig.create(dafny.DafnySequence.asString("foo"), dafny.DafnySequence.asString("bar"), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("sign")), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SearchConfig>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SearchConfig._typeDescriptor()), dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("bar"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__ONLY()), new dafny.Tuple2(dafny.DafnySequence.asString("sign"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__ONLY()), new dafny.Tuple2(dafny.DafnySequence.asString("encrypt"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN()), new dafny.Tuple2(dafny.DafnySequence.asString("plain"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_DO__NOTHING())), Wrappers_Compile.Option.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>create_Some(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("plain"))), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Wrappers_Compile.Option.<software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId>create_None(software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring>create_Some(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring.class)), _0_keyring), Wrappers_Compile.Option.<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager>create_None(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager.class))), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.LegacyOverride>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.LegacyOverride._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PlaintextOverride>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PlaintextOverride._typeDescriptor()))))));
      _1_valueOrError0 = _out1;
      if (!(!((_1_valueOrError0).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor())))) {
        throw new dafny.DafnyHaltException("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(249,18): " + java.lang.String.valueOf(_1_valueOrError0));
      }
      encryption = (_1_valueOrError0).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor());
    }
    return encryption;
  }
  public static software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient GetDynamoDbEncryptionTransformsMulti(Wrappers_Compile.Option<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.PlaintextOverride> plaintextOverride)
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient encryption = null;
    if(true) {
      software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring _0_keyring;
      software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring _out0;
      _out0 = __default.GetKmsKeyring();
      _0_keyring = _out0;
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _1_beacons;
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion _out1;
      _out1 = BeaconTestFixtures_Compile.__default.GetLotsaBeaconsMulti();
      _1_beacons = _out1;
      software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SearchConfig _2_search;
      _2_search = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SearchConfig.create(dafny.DafnySequence.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion> of(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.BeaconVersion._typeDescriptor(), _1_beacons), 1);
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _3_valueOrError0 = (Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>)null;
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out2;
      _out2 = software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.__default.DynamoDbEncryptionTransforms(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTablesEncryptionConfig.create(dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("foo"), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.DynamoDbTableEncryptionConfig.create(dafny.DafnySequence.asString("foo"), dafny.DafnySequence.asString("bar"), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.KeySchemaAttributeName._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SearchConfig>create_Some(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.SearchConfig._typeDescriptor(), _2_search), __default.MultiActions(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>create_Some(dafny.DafnySequence.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> of(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.asString("plain"))), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Wrappers_Compile.Option.<software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId>create_None(software.amazon.cryptography.materialproviders.internaldafny.types.DBEAlgorithmSuiteId._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring>create_Some(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.types.IKeyring.class)), _0_keyring), Wrappers_Compile.Option.<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager>create_None(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.types.ICryptographicMaterialsManager.class))), Wrappers_Compile.Option.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.LegacyOverride>create_None(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.LegacyOverride._typeDescriptor()), plaintextOverride)))));
      _3_valueOrError0 = _out2;
      if (!(!((_3_valueOrError0).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor())))) {
        throw new dafny.DafnyHaltException("dafny/DynamoDbEncryptionTransforms/test/TestFixtures.dfy(301,18): " + java.lang.String.valueOf(_3_valueOrError0));
      }
      encryption = (_3_valueOrError0).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor());
    }
    return encryption;
  }
  public static dafny.DafnySequence<? extends Character> PUBLIC__US__WEST__2__KMS__TEST__KEY()
  {
    return dafny.DafnySequence.asString("arn:aws:kms:us-west-2:658956600833:key/b3537ef1-d8dc-4780-9f5a-55776cbb2f7f");
  }
  public static dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction> MultiActions()
  {
    return dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("bar"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__ONLY()), new dafny.Tuple2(dafny.DafnySequence.asString("std2"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN()), new dafny.Tuple2(dafny.DafnySequence.asString("std4"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN()), new dafny.Tuple2(dafny.DafnySequence.asString("std6"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN()), new dafny.Tuple2(dafny.DafnySequence.asString("Name"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN()), new dafny.Tuple2(dafny.DafnySequence.asString("Title"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN()), new dafny.Tuple2(dafny.DafnySequence.asString("TooBad"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_ENCRYPT__AND__SIGN()), new dafny.Tuple2(dafny.DafnySequence.asString("Year"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__ONLY()), new dafny.Tuple2(dafny.DafnySequence.asString("Date"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__ONLY()), new dafny.Tuple2(dafny.DafnySequence.asString("TheKeyField"), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.CryptoAction.create_SIGN__ONLY()));
  }
  @Override
  public java.lang.String toString() {
    return "TestFixtures._default";
  }
}
