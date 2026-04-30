// Class __default
// Dafny class __default compiled into Java
package ExecuteStatementTransformTest_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static void TestExecuteStatementInputPassthrough()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient _0_middlewareUnderTest;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient _out0;
    _out0 = TestFixtures_Compile.__default.GetDynamoDbEncryptionTransforms();
    _0_middlewareUnderTest = _out0;
    dafny.DafnySequence<? extends Character> _1_statement;
    dafny.DafnySequence<? extends Character> _out1;
    _out1 = TestFixtures_Compile.__default.GetStatement(dafny.DafnySequence.asString("update \"no_such_table\""));
    _1_statement = _out1;
    software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementInput _2_good__input;
    _2_good__input = software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementInput.create(_1_statement, Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.PreparedStatementParameters._typeDescriptor()), Wrappers_Compile.Option.<Boolean>create_None(dafny.TypeDescriptor.BOOLEAN), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.PartiQLNextToken._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnConsumedCapacity>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnConsumedCapacity._typeDescriptor()), Wrappers_Compile.Option.<java.lang.Integer>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.PositiveIntegerObject._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnValuesOnConditionCheckFailure>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnValuesOnConditionCheckFailure._typeDescriptor()));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _3_good__transformed;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out2;
    _out2 = (_0_middlewareUnderTest).ExecuteStatementInputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementInputTransformInput.create(_2_good__input));
    _3_good__transformed = _out2;
    TestFixtures_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementInputTransformOutput>expect__ok(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementInputTransformOutput._typeDescriptor(), dafny.DafnySequence.asString("ExecuteStatement"), _3_good__transformed);
    TestFixtures_Compile.__default.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementInput>expect__equal(software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementInput._typeDescriptor(), dafny.DafnySequence.asString("ExecuteStatement"), ((_3_good__transformed).dtor_value()).dtor_transformedInput(), _2_good__input);
  }
  public static void TestExecuteStatementInputEncrypted()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient _0_middlewareUnderTest;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient _out0;
    _out0 = TestFixtures_Compile.__default.GetDynamoDbEncryptionTransforms();
    _0_middlewareUnderTest = _out0;
    dafny.DafnySequence<? extends Character> _1_statement;
    dafny.DafnySequence<? extends Character> _out1;
    _out1 = TestFixtures_Compile.__default.GetStatement(dafny.DafnySequence.asString("update \"foo\""));
    _1_statement = _out1;
    software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementInput _2_bad__input;
    _2_bad__input = software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementInput.create(_1_statement, Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.PreparedStatementParameters._typeDescriptor()), Wrappers_Compile.Option.<Boolean>create_None(dafny.TypeDescriptor.BOOLEAN), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.PartiQLNextToken._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnConsumedCapacity>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnConsumedCapacity._typeDescriptor()), Wrappers_Compile.Option.<java.lang.Integer>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.PositiveIntegerObject._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnValuesOnConditionCheckFailure>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnValuesOnConditionCheckFailure._typeDescriptor()));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _3_bad__transformed;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out2;
    _out2 = (_0_middlewareUnderTest).ExecuteStatementInputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementInputTransformInput.create(_2_bad__input));
    _3_bad__transformed = _out2;
    if (!((_3_bad__transformed).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryptionTransforms/test/ExecuteStatementTransform.dfy(51,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((_3_bad__transformed).dtor_error()).is_DynamoDbEncryptionTransformsException())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryptionTransforms/test/ExecuteStatementTransform.dfy(52,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((((_3_bad__transformed).dtor_error()).dtor_message()).equals(dafny.DafnySequence.asString("ExecuteStatement not Supported on encrypted tables.")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryptionTransforms/test/ExecuteStatementTransform.dfy(53,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestExecuteStatementOutput()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient _0_middlewareUnderTest;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient _out0;
    _out0 = TestFixtures_Compile.__default.GetDynamoDbEncryptionTransforms();
    _0_middlewareUnderTest = _out0;
    software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementOutput _1_output;
    _1_output = software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementOutput.create(Wrappers_Compile.Option.<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>>create_None(dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>_typeDescriptor(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()))), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.PartiQLNextToken._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ConsumedCapacity>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.ConsumedCapacity._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>create_None(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor())));
    dafny.DafnySequence<? extends Character> _2_statement;
    dafny.DafnySequence<? extends Character> _out1;
    _out1 = TestFixtures_Compile.__default.GetStatement(dafny.DafnySequence.asString("foo"));
    _2_statement = _out1;
    software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementInput _3_input;
    _3_input = software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementInput.create(_2_statement, Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.PreparedStatementParameters._typeDescriptor()), Wrappers_Compile.Option.<Boolean>create_None(dafny.TypeDescriptor.BOOLEAN), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.PartiQLNextToken._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnConsumedCapacity>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnConsumedCapacity._typeDescriptor()), Wrappers_Compile.Option.<java.lang.Integer>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.PositiveIntegerObject._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnValuesOnConditionCheckFailure>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnValuesOnConditionCheckFailure._typeDescriptor()));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _4_transformed;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out2;
    _out2 = (_0_middlewareUnderTest).ExecuteStatementOutputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementOutputTransformInput.create(_1_output, _3_input));
    _4_transformed = _out2;
    TestFixtures_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementOutputTransformOutput>expect__ok(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementOutputTransformOutput._typeDescriptor(), dafny.DafnySequence.asString("ExecuteStatement"), _4_transformed);
    TestFixtures_Compile.__default.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementOutput>expect__equal(software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteStatementOutput._typeDescriptor(), dafny.DafnySequence.asString("ExecuteStatement"), ((_4_transformed).dtor_value()).dtor_transformedOutput(), _1_output);
  }
  @Override
  public java.lang.String toString() {
    return "ExecuteStatementTransformTest._default";
  }
}
