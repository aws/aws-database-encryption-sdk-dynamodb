// Class __default
// Dafny class __default compiled into Java
package BatchGetItemTransformTest_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static void TestBatchGetItemInputTransform()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient _0_middlewareUnderTest;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient _out0;
    _out0 = TestFixtures_Compile.__default.GetDynamoDbEncryptionTransforms();
    _0_middlewareUnderTest = _out0;
    dafny.DafnySequence<? extends Character> _1_tableName;
    dafny.DafnySequence<? extends Character> _out1;
    _out1 = TestFixtures_Compile.__default.GetTableName(dafny.DafnySequence.asString("foo"));
    _1_tableName = _out1;
    dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> _2_keyList;
    dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> _out2;
    _out2 = TestFixtures_Compile.__default.GetKeyList(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> of(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnyMap.fromElements()));
    _2_keyList = _out2;
    software.amazon.cryptography.services.dynamodb.internaldafny.types.KeysAndAttributes _3_val;
    _3_val = software.amazon.cryptography.services.dynamodb.internaldafny.types.KeysAndAttributes.create(_2_keyList, Wrappers_Compile.Option.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeNameList._typeDescriptor()), Wrappers_Compile.Option.<Boolean>create_None(dafny.TypeDescriptor.BOOLEAN), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>create_None(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor())));
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.KeysAndAttributes> _4_theMap;
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.KeysAndAttributes> _out3;
    _out3 = TestFixtures_Compile.__default.GetBatchGetRequestMap(dafny.DafnyMap.fromElements(new dafny.Tuple2(_1_tableName, _3_val)));
    _4_theMap = _out3;
    software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemInput _5_input;
    _5_input = software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemInput.create(_4_theMap, Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnConsumedCapacity>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnConsumedCapacity._typeDescriptor()));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _6_transformed;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out4;
    _out4 = (_0_middlewareUnderTest).BatchGetItemInputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemInputTransformInput.create(_5_input));
    _6_transformed = _out4;
    TestFixtures_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemInputTransformOutput>expect__ok(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemInputTransformOutput._typeDescriptor(), dafny.DafnySequence.asString("BatchGetItemInput"), _6_transformed);
    TestFixtures_Compile.__default.<software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemInput>expect__equal(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemInput._typeDescriptor(), dafny.DafnySequence.asString("BatchGetItemInput"), ((_6_transformed).dtor_value()).dtor_transformedInput(), _5_input);
  }
  public static void TestBatchGetItemOutputTransform()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient _0_middlewareUnderTest;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient _out0;
    _out0 = TestFixtures_Compile.__default.GetDynamoDbEncryptionTransforms();
    _0_middlewareUnderTest = _out0;
    software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemOutput _1_output;
    _1_output = software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemOutput.create(Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>>>create_None(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.TableArn._typeDescriptor(), dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor())))), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.KeysAndAttributes>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetRequestMap._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.ConsumedCapacity>>create_None(dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ConsumedCapacity>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.ConsumedCapacity._typeDescriptor())));
    dafny.DafnySequence<? extends Character> _2_tableName;
    dafny.DafnySequence<? extends Character> _out1;
    _out1 = TestFixtures_Compile.__default.GetTableName(dafny.DafnySequence.asString("foo"));
    _2_tableName = _out1;
    dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> _3_keyList;
    dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> _out2;
    _out2 = TestFixtures_Compile.__default.GetKeyList(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>> of(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), dafny.DafnyMap.fromElements()));
    _3_keyList = _out2;
    software.amazon.cryptography.services.dynamodb.internaldafny.types.KeysAndAttributes _4_val;
    _4_val = software.amazon.cryptography.services.dynamodb.internaldafny.types.KeysAndAttributes.create(_3_keyList, Wrappers_Compile.Option.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeNameList._typeDescriptor()), Wrappers_Compile.Option.<Boolean>create_None(dafny.TypeDescriptor.BOOLEAN), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>create_None(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor())));
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.KeysAndAttributes> _5_theMap;
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.KeysAndAttributes> _out3;
    _out3 = TestFixtures_Compile.__default.GetBatchGetRequestMap(dafny.DafnyMap.fromElements(new dafny.Tuple2(_2_tableName, _4_val)));
    _5_theMap = _out3;
    software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemInput _6_input;
    _6_input = software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemInput.create(_5_theMap, Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnConsumedCapacity>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnConsumedCapacity._typeDescriptor()));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _7_transformed;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out4;
    _out4 = (_0_middlewareUnderTest).BatchGetItemOutputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemOutputTransformInput.create(_1_output, _6_input));
    _7_transformed = _out4;
    TestFixtures_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemOutputTransformOutput>expect__ok(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemOutputTransformOutput._typeDescriptor(), dafny.DafnySequence.asString("BatchGetItemOutput"), _7_transformed);
    TestFixtures_Compile.__default.<software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemOutput>expect__equal(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchGetItemOutput._typeDescriptor(), dafny.DafnySequence.asString("BatchGetItemOutput"), ((_7_transformed).dtor_value()).dtor_transformedOutput(), _1_output);
  }
  @Override
  public java.lang.String toString() {
    return "BatchGetItemTransformTest._default";
  }
}
