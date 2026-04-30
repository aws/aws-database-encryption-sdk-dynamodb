// Class __default
// Dafny class __default compiled into Java
package ExecuteTransactionTransformTest_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static void TestExecuteTransactionInputPassthrough()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient _0_middlewareUnderTest;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient _out0;
    _out0 = TestFixtures_Compile.__default.GetDynamoDbEncryptionTransforms();
    _0_middlewareUnderTest = _out0;
    dafny.DafnySequence<? extends Character> _1_statement;
    dafny.DafnySequence<? extends Character> _out1;
    _out1 = TestFixtures_Compile.__default.GetStatement(dafny.DafnySequence.asString("update \"no_such_table\""));
    _1_statement = _out1;
    software.amazon.cryptography.services.dynamodb.internaldafny.types.ParameterizedStatement _2_pstatement;
    _2_pstatement = software.amazon.cryptography.services.dynamodb.internaldafny.types.ParameterizedStatement.create(_1_statement, Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.PreparedStatementParameters._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnValuesOnConditionCheckFailure>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnValuesOnConditionCheckFailure._typeDescriptor()));
    dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.ParameterizedStatement> _3_pstatements;
    dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.ParameterizedStatement> _out2;
    _out2 = TestFixtures_Compile.__default.GetPStatements(dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ParameterizedStatement> of(software.amazon.cryptography.services.dynamodb.internaldafny.types.ParameterizedStatement._typeDescriptor(), _2_pstatement));
    _3_pstatements = _out2;
    software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionInput _4_good__input;
    _4_good__input = software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionInput.create(_3_pstatements, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.ClientRequestToken._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnConsumedCapacity>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnConsumedCapacity._typeDescriptor()));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _5_good__transformed;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out3;
    _out3 = (_0_middlewareUnderTest).ExecuteTransactionInputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionInputTransformInput.create(_4_good__input));
    _5_good__transformed = _out3;
    TestFixtures_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionInputTransformOutput>expect__ok(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionInputTransformOutput._typeDescriptor(), dafny.DafnySequence.asString("ExecuteTransaction"), _5_good__transformed);
    TestFixtures_Compile.__default.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionInput>expect__equal(software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionInput._typeDescriptor(), dafny.DafnySequence.asString("ExecuteTransaction"), ((_5_good__transformed).dtor_value()).dtor_transformedInput(), _4_good__input);
  }
  public static void TestExecuteTransactionInput()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient _0_middlewareUnderTest;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient _out0;
    _out0 = TestFixtures_Compile.__default.GetDynamoDbEncryptionTransforms();
    _0_middlewareUnderTest = _out0;
    dafny.DafnySequence<? extends Character> _1_statement;
    dafny.DafnySequence<? extends Character> _out1;
    _out1 = TestFixtures_Compile.__default.GetStatement(dafny.DafnySequence.asString("update foo"));
    _1_statement = _out1;
    software.amazon.cryptography.services.dynamodb.internaldafny.types.ParameterizedStatement _2_pstatement;
    _2_pstatement = software.amazon.cryptography.services.dynamodb.internaldafny.types.ParameterizedStatement.create(_1_statement, Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.PreparedStatementParameters._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnValuesOnConditionCheckFailure>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnValuesOnConditionCheckFailure._typeDescriptor()));
    dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.ParameterizedStatement> _3_pstatements;
    dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.ParameterizedStatement> _out2;
    _out2 = TestFixtures_Compile.__default.GetPStatements(dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ParameterizedStatement> of(software.amazon.cryptography.services.dynamodb.internaldafny.types.ParameterizedStatement._typeDescriptor(), _2_pstatement));
    _3_pstatements = _out2;
    software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionInput _4_bad__input;
    _4_bad__input = software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionInput.create(_3_pstatements, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.ClientRequestToken._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnConsumedCapacity>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnConsumedCapacity._typeDescriptor()));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _5_bad__transformed;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out3;
    _out3 = (_0_middlewareUnderTest).ExecuteTransactionInputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionInputTransformInput.create(_4_bad__input));
    _5_bad__transformed = _out3;
    TestFixtures_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionInputTransformOutput>ExpectFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionInputTransformOutput._typeDescriptor(), _5_bad__transformed, dafny.DafnySequence.asString("ExecuteTransaction not Supported on encrypted tables."));
  }
  public static void TestExecuteTransactionOutputTransform()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient _0_middlewareUnderTest;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient _out0;
    _out0 = TestFixtures_Compile.__default.GetDynamoDbEncryptionTransforms();
    _0_middlewareUnderTest = _out0;
    software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionOutput _1_output;
    _1_output = software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionOutput.create(Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.ItemResponse>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.ItemResponseList._typeDescriptor()), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.ConsumedCapacity>>create_None(dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ConsumedCapacity>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.ConsumedCapacity._typeDescriptor())));
    dafny.DafnySequence<? extends Character> _2_statement;
    dafny.DafnySequence<? extends Character> _out1;
    _out1 = TestFixtures_Compile.__default.GetStatement(dafny.DafnySequence.asString("foo"));
    _2_statement = _out1;
    software.amazon.cryptography.services.dynamodb.internaldafny.types.ParameterizedStatement _3_pstatement;
    _3_pstatement = software.amazon.cryptography.services.dynamodb.internaldafny.types.ParameterizedStatement.create(_2_statement, Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.PreparedStatementParameters._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnValuesOnConditionCheckFailure>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnValuesOnConditionCheckFailure._typeDescriptor()));
    dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.ParameterizedStatement> _4_pstatements;
    dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.ParameterizedStatement> _out2;
    _out2 = TestFixtures_Compile.__default.GetPStatements(dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ParameterizedStatement> of(software.amazon.cryptography.services.dynamodb.internaldafny.types.ParameterizedStatement._typeDescriptor(), _3_pstatement));
    _4_pstatements = _out2;
    software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionInput _5_input;
    _5_input = software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionInput.create(_4_pstatements, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.ClientRequestToken._typeDescriptor()), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnConsumedCapacity>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnConsumedCapacity._typeDescriptor()));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _6_transformed;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out3;
    _out3 = (_0_middlewareUnderTest).ExecuteTransactionOutputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionOutputTransformInput.create(_1_output, _5_input));
    _6_transformed = _out3;
    TestFixtures_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionOutputTransformOutput>expect__ok(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionOutputTransformOutput._typeDescriptor(), dafny.DafnySequence.asString("ExecuteTransactionOutput"), _6_transformed);
    TestFixtures_Compile.__default.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionOutput>expect__equal(software.amazon.cryptography.services.dynamodb.internaldafny.types.ExecuteTransactionOutput._typeDescriptor(), dafny.DafnySequence.asString("ExecuteTransactionOutput"), ((_6_transformed).dtor_value()).dtor_transformedOutput(), _1_output);
  }
  @Override
  public java.lang.String toString() {
    return "ExecuteTransactionTransformTest._default";
  }
}
