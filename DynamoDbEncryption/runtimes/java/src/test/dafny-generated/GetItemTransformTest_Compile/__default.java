// Class __default
// Dafny class __default compiled into Java
package GetItemTransformTest_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static void TestGetItemInputPassthrough()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient _0_middlewareUnderTest;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient _out0;
    _out0 = TestFixtures_Compile.__default.GetDynamoDbEncryptionTransforms();
    _0_middlewareUnderTest = _out0;
    dafny.DafnySequence<? extends Character> _1_tableName;
    dafny.DafnySequence<? extends Character> _out1;
    _out1 = TestFixtures_Compile.__default.GetTableName(dafny.DafnySequence.asString("no_such_table"));
    _1_tableName = _out1;
    software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemInput _2_input;
    _2_input = software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemInput.create(_1_tableName, dafny.DafnyMap.fromElements(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeNameList._typeDescriptor()), Wrappers_Compile.Option.<Boolean>create_None(dafny.TypeDescriptor.BOOLEAN), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnConsumedCapacity>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnConsumedCapacity._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>create_None(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor())));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _3_transformed;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out2;
    _out2 = (_0_middlewareUnderTest).GetItemInputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemInputTransformInput.create(_2_input));
    _3_transformed = _out2;
    TestFixtures_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemInputTransformOutput>expect__ok(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemInputTransformOutput._typeDescriptor(), dafny.DafnySequence.asString("GetItemInput"), _3_transformed);
    TestFixtures_Compile.__default.<software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemInput>expect__equal(software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemInput._typeDescriptor(), dafny.DafnySequence.asString("GetItemInput"), ((_3_transformed).dtor_value()).dtor_transformedInput(), _2_input);
  }
  public static void TestGetItemOutputPassthrough()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient _0_middlewareUnderTest;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient _out0;
    _out0 = TestFixtures_Compile.__default.GetDynamoDbEncryptionTransforms();
    _0_middlewareUnderTest = _out0;
    dafny.DafnySequence<? extends Character> _1_tableName;
    dafny.DafnySequence<? extends Character> _out1;
    _out1 = TestFixtures_Compile.__default.GetTableName(dafny.DafnySequence.asString("no_such_table"));
    _1_tableName = _out1;
    software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemInput _2_input;
    _2_input = software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemInput.create(_1_tableName, dafny.DafnyMap.fromElements(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeNameList._typeDescriptor()), Wrappers_Compile.Option.<Boolean>create_None(dafny.TypeDescriptor.BOOLEAN), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnConsumedCapacity>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnConsumedCapacity._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>>create_None(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor())));
    software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemOutput _3_output;
    _3_output = software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemOutput.create(Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>create_None(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor())), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ConsumedCapacity>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.ConsumedCapacity._typeDescriptor()));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _4_transformed;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out2;
    _out2 = (_0_middlewareUnderTest).GetItemOutputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemOutputTransformInput.create(_3_output, _2_input));
    _4_transformed = _out2;
    TestFixtures_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemOutputTransformOutput>expect__ok(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemOutputTransformOutput._typeDescriptor(), dafny.DafnySequence.asString("GetItemOutput"), _4_transformed);
    TestFixtures_Compile.__default.<software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemOutput>expect__equal(software.amazon.cryptography.services.dynamodb.internaldafny.types.GetItemOutput._typeDescriptor(), dafny.DafnySequence.asString("GetItemOutput"), ((_4_transformed).dtor_value()).dtor_transformedOutput(), _3_output);
  }
  @Override
  public java.lang.String toString() {
    return "GetItemTransformTest._default";
  }
}
