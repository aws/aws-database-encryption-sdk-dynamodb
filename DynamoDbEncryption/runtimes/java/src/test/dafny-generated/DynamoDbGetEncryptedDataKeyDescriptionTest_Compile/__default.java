// Class __default
// Dafny class __default compiled into Java
package DynamoDbGetEncryptedDataKeyDescriptionTest_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static StructuredEncryptionHeader_Compile.PartialHeader CreatePartialHeader(byte version, byte flavor, dafny.DafnySequence<? extends java.lang.Byte> msgID, dafny.DafnySequence<? extends java.lang.Byte> legend, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> encContext, dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> dataKeyList)
  {
    StructuredEncryptionHeader_Compile.PartialHeader result = (StructuredEncryptionHeader_Compile.PartialHeader)null;
    if(true) {
      result = StructuredEncryptionHeader_Compile.PartialHeader.create(version, flavor, msgID, legend, encContext, dataKeyList);
    }
    return result;
  }
  public static void TestHeaderInputAwsKmsDataKeyCase()
  {
    StructuredEncryptionHeader_Compile.PartialHeader _0_expectedHead;
    StructuredEncryptionHeader_Compile.PartialHeader _out0;
    _out0 = __default.CreatePartialHeader(__default.testVersion(), __default.testFlavor1(), __default.testMsgID(), __default.testLegend(), __default.testEncContext(), dafny.DafnySequence.<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> of(software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey._typeDescriptor(), __default.testAwsKmsDataKey()));
    _0_expectedHead = _out0;
    dafny.DafnySequence<? extends java.lang.Byte> _1_serializedHeader;
    _1_serializedHeader = dafny.DafnySequence.<java.lang.Byte>concatenate((_0_expectedHead).serialize(), (_0_expectedHead).dtor_msgID());
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _2_valueOrError0 = (Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out1;
    _out1 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.__default.DynamoDbEncryption(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.__default.DefaultDynamoDbEncryptionConfig());
    _2_valueOrError0 = _out1;
    if (!(!((_2_valueOrError0).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(109,27): " + java.lang.String.valueOf(_2_valueOrError0));
    }
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient _3_ddbEncResources;
    _3_ddbEncResources = (_2_valueOrError0).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionInput _4_inputVariable;
    _4_inputVariable = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionInput.create(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionUnion.create_header(_1_serializedHeader));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _5_valueOrError1 = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput.Default());
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = (_3_ddbEncResources).GetEncryptedDataKeyDescription(_4_inputVariable);
    _5_valueOrError1 = _out2;
    if (!(!((_5_valueOrError1).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(114,36): " + java.lang.String.valueOf(_5_valueOrError1));
    }
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput _6_actualDataKeyDescription;
    _6_actualDataKeyDescription = (_5_valueOrError1).Extract(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    if (!(java.util.Objects.equals(java.math.BigInteger.valueOf(((_6_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).length()), java.math.BigInteger.ONE))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(116,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription)(java.lang.Object)(((_6_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_keyProviderId()).equals(dafny.DafnySequence.asString("aws-kms")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(117,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription)(java.lang.Object)(((_6_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_keyProviderInfo()).is_Some())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(118,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription)(java.lang.Object)(((_6_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_keyProviderInfo()).dtor_value()).equals(dafny.DafnySequence.asString("keyproviderInfo")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(119,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestHeaderInputAwsKmsHDataKeyCase()
  {
    StructuredEncryptionHeader_Compile.PartialHeader _0_expectedHead;
    StructuredEncryptionHeader_Compile.PartialHeader _out0;
    _out0 = __default.CreatePartialHeader(__default.testVersion(), __default.testFlavor1(), __default.testMsgID(), __default.testLegend(), __default.testEncContext(), dafny.DafnySequence.<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> of(software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey._typeDescriptor(), __default.testAwsKmsHDataKey()));
    _0_expectedHead = _out0;
    dafny.DafnySequence<? extends java.lang.Byte> _1_serializedHeader;
    _1_serializedHeader = dafny.DafnySequence.<java.lang.Byte>concatenate((_0_expectedHead).serialize(), (_0_expectedHead).dtor_msgID());
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _2_valueOrError0 = (Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out1;
    _out1 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.__default.DynamoDbEncryption(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.__default.DefaultDynamoDbEncryptionConfig());
    _2_valueOrError0 = _out1;
    if (!(!((_2_valueOrError0).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(126,27): " + java.lang.String.valueOf(_2_valueOrError0));
    }
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient _3_ddbEncResources;
    _3_ddbEncResources = (_2_valueOrError0).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionInput _4_inputVariable;
    _4_inputVariable = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionInput.create(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionUnion.create_header(_1_serializedHeader));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _5_valueOrError1 = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput.Default());
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = (_3_ddbEncResources).GetEncryptedDataKeyDescription(_4_inputVariable);
    _5_valueOrError1 = _out2;
    if (!(!((_5_valueOrError1).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(131,36): " + java.lang.String.valueOf(_5_valueOrError1));
    }
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput _6_actualDataKeyDescription;
    _6_actualDataKeyDescription = (_5_valueOrError1).Extract(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    if (!(java.util.Objects.equals(java.math.BigInteger.valueOf(((_6_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).length()), java.math.BigInteger.ONE))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(133,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription)(java.lang.Object)(((_6_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_keyProviderId()).equals(dafny.DafnySequence.asString("aws-kms-hierarchy")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(134,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription)(java.lang.Object)(((_6_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_keyProviderInfo()).is_Some())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(135,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription)(java.lang.Object)(((_6_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_keyProviderInfo()).dtor_value()).equals(dafny.DafnySequence.asString("keyproviderInfo")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(136,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    __default.assertBranchKey(_6_actualDataKeyDescription);
  }
  public static void TestHeaderInputRawRsaDataKeyDataKeyCase()
  {
    StructuredEncryptionHeader_Compile.PartialHeader _0_expectedHead;
    StructuredEncryptionHeader_Compile.PartialHeader _out0;
    _out0 = __default.CreatePartialHeader(__default.testVersion(), __default.testFlavor1(), __default.testMsgID(), __default.testLegend(), __default.testEncContext(), dafny.DafnySequence.<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> of(software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey._typeDescriptor(), __default.testRawRsaDataKey()));
    _0_expectedHead = _out0;
    dafny.DafnySequence<? extends java.lang.Byte> _1_serializedHeader;
    _1_serializedHeader = dafny.DafnySequence.<java.lang.Byte>concatenate((_0_expectedHead).serialize(), (_0_expectedHead).dtor_msgID());
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _2_valueOrError0 = (Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out1;
    _out1 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.__default.DynamoDbEncryption(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.__default.DefaultDynamoDbEncryptionConfig());
    _2_valueOrError0 = _out1;
    if (!(!((_2_valueOrError0).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(145,27): " + java.lang.String.valueOf(_2_valueOrError0));
    }
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient _3_ddbEncResources;
    _3_ddbEncResources = (_2_valueOrError0).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionInput _4_inputVariable;
    _4_inputVariable = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionInput.create(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionUnion.create_header(_1_serializedHeader));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _5_valueOrError1 = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput.Default());
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = (_3_ddbEncResources).GetEncryptedDataKeyDescription(_4_inputVariable);
    _5_valueOrError1 = _out2;
    if (!(!((_5_valueOrError1).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(150,36): " + java.lang.String.valueOf(_5_valueOrError1));
    }
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput _6_actualDataKeyDescription;
    _6_actualDataKeyDescription = (_5_valueOrError1).Extract(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    if (!(java.util.Objects.equals(java.math.BigInteger.valueOf(((_6_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).length()), java.math.BigInteger.ONE))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(152,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription)(java.lang.Object)(((_6_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_keyProviderId()).equals(dafny.DafnySequence.asString("raw-rsa")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(153,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestHeaderInputAwsKmsRsaDataKeyCase()
  {
    StructuredEncryptionHeader_Compile.PartialHeader _0_expectedHead;
    StructuredEncryptionHeader_Compile.PartialHeader _out0;
    _out0 = __default.CreatePartialHeader(__default.testVersion(), __default.testFlavor1(), __default.testMsgID(), __default.testLegend(), __default.testEncContext(), dafny.DafnySequence.<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> of(software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey._typeDescriptor(), __default.testAwsKmsRsaDataKey()));
    _0_expectedHead = _out0;
    dafny.DafnySequence<? extends java.lang.Byte> _1_serializedHeader;
    _1_serializedHeader = dafny.DafnySequence.<java.lang.Byte>concatenate((_0_expectedHead).serialize(), (_0_expectedHead).dtor_msgID());
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _2_valueOrError0 = (Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out1;
    _out1 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.__default.DynamoDbEncryption(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.__default.DefaultDynamoDbEncryptionConfig());
    _2_valueOrError0 = _out1;
    if (!(!((_2_valueOrError0).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(160,27): " + java.lang.String.valueOf(_2_valueOrError0));
    }
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient _3_ddbEncResources;
    _3_ddbEncResources = (_2_valueOrError0).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionInput _4_inputVariable;
    _4_inputVariable = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionInput.create(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionUnion.create_header(_1_serializedHeader));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _5_valueOrError1 = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput.Default());
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = (_3_ddbEncResources).GetEncryptedDataKeyDescription(_4_inputVariable);
    _5_valueOrError1 = _out2;
    if (!(!((_5_valueOrError1).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(165,36): " + java.lang.String.valueOf(_5_valueOrError1));
    }
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput _6_actualDataKeyDescription;
    _6_actualDataKeyDescription = (_5_valueOrError1).Extract(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    if (!(java.util.Objects.equals(java.math.BigInteger.valueOf(((_6_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).length()), java.math.BigInteger.ONE))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(167,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription)(java.lang.Object)(((_6_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_keyProviderId()).equals(dafny.DafnySequence.asString("aws-kms-rsa")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(168,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription)(java.lang.Object)(((_6_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_keyProviderInfo()).is_Some())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(169,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription)(java.lang.Object)(((_6_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_keyProviderInfo()).dtor_value()).equals(dafny.DafnySequence.asString("keyproviderInfo")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(170,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestDDBItemInputAwsKmsDataKeyCase()
  {
    StructuredEncryptionHeader_Compile.PartialHeader _0_expectedHead;
    StructuredEncryptionHeader_Compile.PartialHeader _out0;
    _out0 = __default.CreatePartialHeader(__default.testVersion(), __default.testFlavor1(), __default.testMsgID(), __default.testLegend(), __default.testEncContext(), dafny.DafnySequence.<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> of(software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey._typeDescriptor(), __default.testAwsKmsDataKey()));
    _0_expectedHead = _out0;
    dafny.DafnySequence<? extends java.lang.Byte> _1_serializedHeader;
    _1_serializedHeader = dafny.DafnySequence.<java.lang.Byte>concatenate((_0_expectedHead).serialize(), (_0_expectedHead).dtor_msgID());
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _2_attr;
    _2_attr = dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_head"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_B(_1_serializedHeader)));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _3_valueOrError0 = (Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out1;
    _out1 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.__default.DynamoDbEncryption(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.__default.DefaultDynamoDbEncryptionConfig());
    _3_valueOrError0 = _out1;
    if (!(!((_3_valueOrError0).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(179,27): " + java.lang.String.valueOf(_3_valueOrError0));
    }
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient _4_ddbEncResources;
    _4_ddbEncResources = (_3_valueOrError0).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionInput _5_inputVariable;
    _5_inputVariable = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionInput.create(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionUnion.create_item(_2_attr));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _6_valueOrError1 = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput.Default());
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = (_4_ddbEncResources).GetEncryptedDataKeyDescription(_5_inputVariable);
    _6_valueOrError1 = _out2;
    if (!(!((_6_valueOrError1).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(186,36): " + java.lang.String.valueOf(_6_valueOrError1));
    }
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput _7_actualDataKeyDescription;
    _7_actualDataKeyDescription = (_6_valueOrError1).Extract(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    if (!(java.util.Objects.equals(java.math.BigInteger.valueOf(((_7_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).length()), java.math.BigInteger.ONE))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(188,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription)(java.lang.Object)(((_7_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_keyProviderId()).equals(dafny.DafnySequence.asString("aws-kms")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(189,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription)(java.lang.Object)(((_7_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_keyProviderInfo()).is_Some())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(190,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription)(java.lang.Object)(((_7_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_keyProviderInfo()).dtor_value()).equals(dafny.DafnySequence.asString("keyproviderInfo")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(191,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestDDBItemInputAwsKmsHDataKeyCase()
  {
    StructuredEncryptionHeader_Compile.PartialHeader _0_expectedHead;
    StructuredEncryptionHeader_Compile.PartialHeader _out0;
    _out0 = __default.CreatePartialHeader(__default.testVersion(), __default.testFlavor0(), __default.testMsgID(), __default.testLegend(), __default.testEncContext(), dafny.DafnySequence.<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> of(software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey._typeDescriptor(), __default.testAwsKmsHDataKey()));
    _0_expectedHead = _out0;
    dafny.DafnySequence<? extends java.lang.Byte> _1_serializedHeader;
    _1_serializedHeader = dafny.DafnySequence.<java.lang.Byte>concatenate((_0_expectedHead).serialize(), (_0_expectedHead).dtor_msgID());
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _2_attr;
    _2_attr = dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_head"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_B(_1_serializedHeader)));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _3_valueOrError0 = (Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out1;
    _out1 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.__default.DynamoDbEncryption(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.__default.DefaultDynamoDbEncryptionConfig());
    _3_valueOrError0 = _out1;
    if (!(!((_3_valueOrError0).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(199,27): " + java.lang.String.valueOf(_3_valueOrError0));
    }
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient _4_ddbEncResources;
    _4_ddbEncResources = (_3_valueOrError0).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionInput _5_inputVariable;
    _5_inputVariable = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionInput.create(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionUnion.create_item(_2_attr));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _6_valueOrError1 = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput.Default());
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = (_4_ddbEncResources).GetEncryptedDataKeyDescription(_5_inputVariable);
    _6_valueOrError1 = _out2;
    if (!(!((_6_valueOrError1).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(204,36): " + java.lang.String.valueOf(_6_valueOrError1));
    }
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput _7_actualDataKeyDescription;
    _7_actualDataKeyDescription = (_6_valueOrError1).Extract(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    if (!(java.util.Objects.equals(java.math.BigInteger.valueOf(((_7_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).length()), java.math.BigInteger.ONE))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(206,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription)(java.lang.Object)(((_7_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_keyProviderId()).equals(dafny.DafnySequence.asString("aws-kms-hierarchy")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(207,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription)(java.lang.Object)(((_7_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_keyProviderInfo()).is_Some())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(208,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription)(java.lang.Object)(((_7_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_keyProviderInfo()).dtor_value()).equals(dafny.DafnySequence.asString("keyproviderInfo")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(209,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    __default.assertBranchKey(_7_actualDataKeyDescription);
  }
  public static void TestDDBItemInputRawRsaDataKeyCase()
  {
    StructuredEncryptionHeader_Compile.PartialHeader _0_expectedHead;
    StructuredEncryptionHeader_Compile.PartialHeader _out0;
    _out0 = __default.CreatePartialHeader(__default.testVersion(), __default.testFlavor1(), __default.testMsgID(), __default.testLegend(), __default.testEncContext(), dafny.DafnySequence.<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> of(software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey._typeDescriptor(), __default.testRawRsaDataKey()));
    _0_expectedHead = _out0;
    dafny.DafnySequence<? extends java.lang.Byte> _1_serializedHeader;
    _1_serializedHeader = dafny.DafnySequence.<java.lang.Byte>concatenate((_0_expectedHead).serialize(), (_0_expectedHead).dtor_msgID());
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _2_attr;
    _2_attr = dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_head"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_B(_1_serializedHeader)));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _3_valueOrError0 = (Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out1;
    _out1 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.__default.DynamoDbEncryption(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.__default.DefaultDynamoDbEncryptionConfig());
    _3_valueOrError0 = _out1;
    if (!(!((_3_valueOrError0).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(219,27): " + java.lang.String.valueOf(_3_valueOrError0));
    }
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient _4_ddbEncResources;
    _4_ddbEncResources = (_3_valueOrError0).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionInput _5_inputVariable;
    _5_inputVariable = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionInput.create(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionUnion.create_item(_2_attr));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _6_valueOrError1 = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput.Default());
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = (_4_ddbEncResources).GetEncryptedDataKeyDescription(_5_inputVariable);
    _6_valueOrError1 = _out2;
    if (!(!((_6_valueOrError1).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(224,36): " + java.lang.String.valueOf(_6_valueOrError1));
    }
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput _7_actualDataKeyDescription;
    _7_actualDataKeyDescription = (_6_valueOrError1).Extract(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    if (!(java.util.Objects.equals(java.math.BigInteger.valueOf(((_7_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).length()), java.math.BigInteger.ONE))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(226,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription)(java.lang.Object)(((_7_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_keyProviderId()).equals(dafny.DafnySequence.asString("raw-rsa")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(227,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestDDBItemInputAwsKmsRsaDataKeyCase()
  {
    StructuredEncryptionHeader_Compile.PartialHeader _0_expectedHead;
    StructuredEncryptionHeader_Compile.PartialHeader _out0;
    _out0 = __default.CreatePartialHeader(__default.testVersion(), __default.testFlavor1(), __default.testMsgID(), __default.testLegend(), __default.testEncContext(), dafny.DafnySequence.<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> of(software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey._typeDescriptor(), __default.testAwsKmsRsaDataKey()));
    _0_expectedHead = _out0;
    dafny.DafnySequence<? extends java.lang.Byte> _1_serializedHeader;
    _1_serializedHeader = dafny.DafnySequence.<java.lang.Byte>concatenate((_0_expectedHead).serialize(), (_0_expectedHead).dtor_msgID());
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _2_attr;
    _2_attr = dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_head"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_B(_1_serializedHeader)));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _3_valueOrError0 = (Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out1;
    _out1 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.__default.DynamoDbEncryption(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.__default.DefaultDynamoDbEncryptionConfig());
    _3_valueOrError0 = _out1;
    if (!(!((_3_valueOrError0).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(235,27): " + java.lang.String.valueOf(_3_valueOrError0));
    }
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient _4_ddbEncResources;
    _4_ddbEncResources = (_3_valueOrError0).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionInput _5_inputVariable;
    _5_inputVariable = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionInput.create(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionUnion.create_item(_2_attr));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _6_valueOrError1 = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput.Default());
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = (_4_ddbEncResources).GetEncryptedDataKeyDescription(_5_inputVariable);
    _6_valueOrError1 = _out2;
    if (!(!((_6_valueOrError1).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(240,36): " + java.lang.String.valueOf(_6_valueOrError1));
    }
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput _7_actualDataKeyDescription;
    _7_actualDataKeyDescription = (_6_valueOrError1).Extract(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    if (!(java.util.Objects.equals(java.math.BigInteger.valueOf(((_7_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).length()), java.math.BigInteger.ONE))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(242,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription)(java.lang.Object)(((_7_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_keyProviderId()).equals(dafny.DafnySequence.asString("aws-kms-rsa")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(243,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription)(java.lang.Object)(((_7_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_keyProviderInfo()).is_Some())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(244,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription)(java.lang.Object)(((_7_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_keyProviderInfo()).dtor_value()).equals(dafny.DafnySequence.asString("keyproviderInfo")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(245,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestHeaderMultiDataKeyCase()
  {
    StructuredEncryptionHeader_Compile.PartialHeader _0_expectedHead;
    StructuredEncryptionHeader_Compile.PartialHeader _out0;
    _out0 = __default.CreatePartialHeader(__default.testVersion(), __default.testFlavor1(), __default.testMsgID(), __default.testLegend(), __default.testEncContext(), dafny.DafnySequence.<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> of(software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey._typeDescriptor(), __default.testAwsKmsDataKey(), __default.testAwsKmsRsaDataKey()));
    _0_expectedHead = _out0;
    dafny.DafnySequence<? extends java.lang.Byte> _1_serializedHeader;
    _1_serializedHeader = dafny.DafnySequence.<java.lang.Byte>concatenate((_0_expectedHead).serialize(), (_0_expectedHead).dtor_msgID());
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _2_valueOrError0 = (Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out1;
    _out1 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.__default.DynamoDbEncryption(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.__default.DefaultDynamoDbEncryptionConfig());
    _2_valueOrError0 = _out1;
    if (!(!((_2_valueOrError0).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(252,27): " + java.lang.String.valueOf(_2_valueOrError0));
    }
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient _3_ddbEncResources;
    _3_ddbEncResources = (_2_valueOrError0).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionInput _4_inputVariable;
    _4_inputVariable = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionInput.create(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionUnion.create_header(_1_serializedHeader));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _5_valueOrError1 = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput.Default());
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = (_3_ddbEncResources).GetEncryptedDataKeyDescription(_4_inputVariable);
    _5_valueOrError1 = _out2;
    if (!(!((_5_valueOrError1).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(257,36): " + java.lang.String.valueOf(_5_valueOrError1));
    }
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput _6_actualDataKeyDescription;
    _6_actualDataKeyDescription = (_5_valueOrError1).Extract(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    if (!(java.util.Objects.equals(java.math.BigInteger.valueOf(((_6_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).length()), java.math.BigInteger.valueOf(2L)))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(259,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription)(java.lang.Object)(((_6_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_keyProviderInfo()).is_Some())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(260,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription)(java.lang.Object)(((_6_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_keyProviderId()).equals(dafny.DafnySequence.asString("aws-kms")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(261,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription)(java.lang.Object)(((_6_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_keyProviderInfo()).dtor_value()).equals(dafny.DafnySequence.asString("keyproviderInfo")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(262,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription)(java.lang.Object)(((_6_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).select(dafny.Helpers.toInt((java.math.BigInteger.ONE)))))).dtor_keyProviderInfo()).is_Some())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(264,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription)(java.lang.Object)(((_6_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).select(dafny.Helpers.toInt((java.math.BigInteger.ONE)))))).dtor_keyProviderId()).equals(dafny.DafnySequence.asString("aws-kms-rsa")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(265,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription)(java.lang.Object)(((_6_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).select(dafny.Helpers.toInt((java.math.BigInteger.ONE)))))).dtor_keyProviderInfo()).dtor_value()).equals(dafny.DafnySequence.asString("keyproviderInfo")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(266,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestDDBItemInputMultiDataKeyCase()
  {
    StructuredEncryptionHeader_Compile.PartialHeader _0_expectedHead;
    StructuredEncryptionHeader_Compile.PartialHeader _out0;
    _out0 = __default.CreatePartialHeader(__default.testVersion(), __default.testFlavor1(), __default.testMsgID(), __default.testLegend(), __default.testEncContext(), dafny.DafnySequence.<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> of(software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey._typeDescriptor(), __default.testAwsKmsDataKey(), __default.testAwsKmsRsaDataKey()));
    _0_expectedHead = _out0;
    dafny.DafnySequence<? extends java.lang.Byte> _1_serializedHeader;
    _1_serializedHeader = dafny.DafnySequence.<java.lang.Byte>concatenate((_0_expectedHead).serialize(), (_0_expectedHead).dtor_msgID());
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _2_attr;
    _2_attr = dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("aws_dbe_head"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_B(_1_serializedHeader)));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _3_valueOrError0 = (Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out1;
    _out1 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.__default.DynamoDbEncryption(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.__default.DefaultDynamoDbEncryptionConfig());
    _3_valueOrError0 = _out1;
    if (!(!((_3_valueOrError0).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(274,27): " + java.lang.String.valueOf(_3_valueOrError0));
    }
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient _4_ddbEncResources;
    _4_ddbEncResources = (_3_valueOrError0).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionInput _5_inputVariable;
    _5_inputVariable = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionInput.create(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionUnion.create_item(_2_attr));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _6_valueOrError1 = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput.Default());
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = (_4_ddbEncResources).GetEncryptedDataKeyDescription(_5_inputVariable);
    _6_valueOrError1 = _out2;
    if (!(!((_6_valueOrError1).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(279,36): " + java.lang.String.valueOf(_6_valueOrError1));
    }
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput _7_actualDataKeyDescription;
    _7_actualDataKeyDescription = (_6_valueOrError1).Extract(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    if (!(java.util.Objects.equals(java.math.BigInteger.valueOf(((_7_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).length()), java.math.BigInteger.valueOf(2L)))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(281,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(java.util.Objects.equals(java.math.BigInteger.valueOf(((_7_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).length()), java.math.BigInteger.valueOf(2L)))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(286,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription)(java.lang.Object)(((_7_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_keyProviderInfo()).is_Some())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(287,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription)(java.lang.Object)(((_7_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_keyProviderId()).equals(dafny.DafnySequence.asString("aws-kms")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(288,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription)(java.lang.Object)(((_7_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_keyProviderInfo()).dtor_value()).equals(dafny.DafnySequence.asString("keyproviderInfo")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(289,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription)(java.lang.Object)(((_7_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).select(dafny.Helpers.toInt((java.math.BigInteger.ONE)))))).dtor_keyProviderInfo()).is_Some())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(291,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription)(java.lang.Object)(((_7_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).select(dafny.Helpers.toInt((java.math.BigInteger.ONE)))))).dtor_keyProviderId()).equals(dafny.DafnySequence.asString("aws-kms-rsa")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(292,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription)(java.lang.Object)(((_7_actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).select(dafny.Helpers.toInt((java.math.BigInteger.ONE)))))).dtor_keyProviderInfo()).dtor_value()).equals(dafny.DafnySequence.asString("keyproviderInfo")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(293,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestNoHeaderFailureCase()
  {
    StructuredEncryptionHeader_Compile.PartialHeader _0_expectedHead;
    StructuredEncryptionHeader_Compile.PartialHeader _out0;
    _out0 = __default.CreatePartialHeader(__default.testVersion(), __default.testFlavor1(), __default.testMsgID(), __default.testLegend(), __default.testEncContext(), dafny.DafnySequence.<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> of(software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey._typeDescriptor(), __default.testAwsKmsDataKey()));
    _0_expectedHead = _out0;
    dafny.DafnySequence<? extends java.lang.Byte> _1_serializedHeader;
    _1_serializedHeader = dafny.DafnySequence.<java.lang.Byte>concatenate((_0_expectedHead).serialize(), (_0_expectedHead).dtor_msgID());
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _2_attr;
    _2_attr = dafny.DafnyMap.fromElements(new dafny.Tuple2(dafny.DafnySequence.asString("wrong_header_attribute"), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue.create_B(_1_serializedHeader)));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _3_valueOrError0 = (Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out1;
    _out1 = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.__default.DynamoDbEncryption(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.__default.DefaultDynamoDbEncryptionConfig());
    _3_valueOrError0 = _out1;
    if (!(!((_3_valueOrError0).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(301,27): " + java.lang.String.valueOf(_3_valueOrError0));
    }
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient _4_ddbEncResources;
    _4_ddbEncResources = (_3_valueOrError0).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.DynamoDbEncryptionClient.class)), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionInput _5_inputVariable;
    _5_inputVariable = software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionInput.create(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionUnion.create_item(_2_attr));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _6_actualDataKeyDescription;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out2;
    _out2 = (_4_ddbEncResources).GetEncryptedDataKeyDescription(_5_inputVariable);
    _6_actualDataKeyDescription = _out2;
    if (!((_6_actualDataKeyDescription).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor()))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(308,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((_6_actualDataKeyDescription).dtor_error()).is_DynamoDbEncryptionException())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(309,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((((_6_actualDataKeyDescription).dtor_error()).dtor_message()).equals(dafny.DafnySequence.asString("Header not found in the DynamoDB item.")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(310,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void assertBranchKey(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.GetEncryptedDataKeyDescriptionOutput actualDataKeyDescription)
  {
    if (!(java.util.Objects.equals(java.math.BigInteger.valueOf(((actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).length()), java.math.BigInteger.ONE))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(315,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription)(java.lang.Object)(((actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_branchKeyId()).is_Some())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(316,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription)(java.lang.Object)(((actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_branchKeyVersion()).is_Some())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(317,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription)(java.lang.Object)(((actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_branchKeyId()).dtor_value()).equals(dafny.DafnySequence.asString("keyproviderInfo")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(319,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((((((software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.EncryptedDataKeyDescription)(java.lang.Object)(((actualDataKeyDescription).dtor_EncryptedDataKeyDescriptionOutput()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_branchKeyVersion()).dtor_value()).equals(dafny.DafnySequence.asString("155b7a3d-7625-4826-4302-113d1179075a")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryption/test/DynamoDbGetEncryptedDataKeyDescriptionTest.dfy(320,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> abc()
  {
    dafny.DafnySequence<? extends java.lang.Byte> _0_s = dafny.DafnySequence.<java.lang.Byte> of((byte) 97, (byte) 98, (byte) 99);
    return _0_s;
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> def()
  {
    dafny.DafnySequence<? extends java.lang.Byte> _0_s = dafny.DafnySequence.<java.lang.Byte> of((byte) 100, (byte) 101, (byte) 102);
    return _0_s;
  }
  public static dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> testEncContext()
  {
    return dafny.DafnyMap.fromElements(new dafny.Tuple2(__default.abc(), __default.def()));
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> aws__kms()
  {
    dafny.DafnySequence<? extends java.lang.Byte> _0_s = dafny.DafnySequence.<java.lang.Byte> of((byte) 97, (byte) 119, (byte) 115, (byte) 45, (byte) 107, (byte) 109, (byte) 115);
    return _0_s;
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> keyproviderInfo()
  {
    dafny.DafnySequence<? extends java.lang.Byte> _0_s = dafny.DafnySequence.<java.lang.Byte> of((byte) 107, (byte) 101, (byte) 121, (byte) 112, (byte) 114, (byte) 111, (byte) 118, (byte) 105, (byte) 100, (byte) 101, (byte) 114, (byte) 73, (byte) 110, (byte) 102, (byte) 111);
    return _0_s;
  }
  public static software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey testAwsKmsDataKey()
  {
    return software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey.create(__default.aws__kms(), __default.keyproviderInfo(), dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> aws__kms__hierarchy()
  {
    dafny.DafnySequence<? extends java.lang.Byte> _0_s = dafny.DafnySequence.<java.lang.Byte> of((byte) 97, (byte) 119, (byte) 115, (byte) 45, (byte) 107, (byte) 109, (byte) 115, (byte) 45, (byte) 104, (byte) 105, (byte) 101, (byte) 114, (byte) 97, (byte) 114, (byte) 99, (byte) 104, (byte) 121);
    return _0_s;
  }
  public static software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey testAwsKmsHDataKey()
  {
    return software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey.create(__default.aws__kms__hierarchy(), __default.keyproviderInfo(), dafny.DafnySequence.<java.lang.Byte> of((byte) 64, (byte) 92, (byte) 115, (byte) 7, (byte) 85, (byte) 121, (byte) 112, (byte) 79, (byte) 69, (byte) 12, (byte) 82, (byte) 25, (byte) 67, (byte) 34, (byte) 11, (byte) 66, (byte) 93, (byte) 45, (byte) 40, (byte) 23, (byte) 90, (byte) 61, (byte) 16, (byte) 28, (byte) 59, (byte) 114, (byte) 52, (byte) 122, (byte) 50, (byte) 23, (byte) 11, (byte) 101, (byte) 48, (byte) 53, (byte) 30, (byte) 120, (byte) 51, (byte) 74, (byte) 77, (byte) 53, (byte) 57, (byte) 99, (byte) 53, (byte) 13, (byte) 30, (byte) 21, (byte) 109, (byte) 85, (byte) 15, (byte) 86, (byte) 47, (byte) 84, (byte) 91, (byte) 85, (byte) 87, (byte) 60, (byte) 4, (byte) 56, (byte) 67, (byte) 74, (byte) 29, (byte) 87, (byte) 85, (byte) 106, (byte) 8, (byte) 82, (byte) 63, (byte) 114, (byte) 100, (byte) 110, (byte) 68, (byte) 58, (byte) 83, (byte) 24, (byte) 111, (byte) 41, (byte) 21, (byte) 91, (byte) 122, (byte) 61, (byte) 118, (byte) 37, (byte) 72, (byte) 38, (byte) 67, (byte) 2, (byte) 17, (byte) 61, (byte) 17, (byte) 121, (byte) 7, (byte) 90, (byte) 117, (byte) 49, (byte) 30, (byte) 20, (byte) 89, (byte) 68, (byte) 33, (byte) 111, (byte) 107, (byte) 5, (byte) 120, (byte) 20, (byte) 95, (byte) 78, (byte) 70, (byte) 2, (byte) 49, (byte) 84, (byte) 39, (byte) 50, (byte) 40, (byte) 40, (byte) 115, (byte) 114, (byte) 76, (byte) 18, (byte) 103, (byte) 84, (byte) 34, (byte) 123, (byte) 1, (byte) 125, (byte) 61, (byte) 33, (byte) 13, (byte) 18, (byte) 81, (byte) 24, (byte) 53, (byte) 53, (byte) 26, (byte) 60, (byte) 52, (byte) 85, (byte) 81, (byte) 96, (byte) 85, (byte) 72));
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> raw__rsa()
  {
    dafny.DafnySequence<? extends java.lang.Byte> _0_s = dafny.DafnySequence.<java.lang.Byte> of((byte) 114, (byte) 97, (byte) 119, (byte) 45, (byte) 114, (byte) 115, (byte) 97);
    return _0_s;
  }
  public static software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey testRawRsaDataKey()
  {
    return software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey.create(__default.raw__rsa(), dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), dafny.DafnySequence.<java.lang.Byte> of((byte) 6, (byte) 7, (byte) 8, (byte) 9));
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> aws__kms__rsa()
  {
    dafny.DafnySequence<? extends java.lang.Byte> _0_s = dafny.DafnySequence.<java.lang.Byte> of((byte) 97, (byte) 119, (byte) 115, (byte) 45, (byte) 107, (byte) 109, (byte) 115, (byte) 45, (byte) 114, (byte) 115, (byte) 97);
    return _0_s;
  }
  public static software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey testAwsKmsRsaDataKey()
  {
    return software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey.create(__default.aws__kms__rsa(), __default.keyproviderInfo(), dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
  }
  public static byte testVersion()
  {
    return (byte) 1;
  }
  public static byte testFlavor1()
  {
    return (byte) 1;
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> testMsgID()
  {
    return dafny.DafnySequence.<java.lang.Byte> of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) 11, (byte) 12, (byte) 13, (byte) 14, (byte) 15, (byte) 16, (byte) 17, (byte) 18, (byte) 19, (byte) 20, (byte) 21, (byte) 22, (byte) 23, (byte) 24, (byte) 25, (byte) 26, (byte) 27, (byte) 28, (byte) 29, (byte) 30, (byte) 31, (byte) 32);
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> testLegend()
  {
    return dafny.DafnySequence.<java.lang.Byte> of((byte) 101, (byte) 115);
  }
  public static byte testFlavor0()
  {
    return (byte) 0;
  }
  @Override
  public java.lang.String toString() {
    return "DynamoDbGetEncryptedDataKeyDescriptionTest._default";
  }
}
