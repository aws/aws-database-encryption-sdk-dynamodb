// Class __default
// Dafny class __default compiled into Java
package BatchExecuteStatementTransformTest_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static void TestBatchExecuteStatementInputPassthrough()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient _0_middlewareUnderTest;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient _out0;
    _out0 = TestFixtures_Compile.__default.GetDynamoDbEncryptionTransforms();
    _0_middlewareUnderTest = _out0;
    dafny.DafnySequence<? extends Character> _1_statement;
    dafny.DafnySequence<? extends Character> _out1;
    _out1 = TestFixtures_Compile.__default.GetStatement(dafny.DafnySequence.asString("update \"no_such_table\""));
    _1_statement = _out1;
    software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementRequest _2_request;
    _2_request = software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementRequest.create(_1_statement, Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.PreparedStatementParameters._typeDescriptor()), Wrappers_Compile.Option.<Boolean>create_None(dafny.TypeDescriptor.BOOLEAN), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnValuesOnConditionCheckFailure>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnValuesOnConditionCheckFailure._typeDescriptor()));
    dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementRequest> _3_requests;
    dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementRequest> _out2;
    _out2 = TestFixtures_Compile.__default.GetPartiQLBatchRequest(dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementRequest> of(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementRequest._typeDescriptor(), _2_request));
    _3_requests = _out2;
    software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementInput _4_good__input;
    _4_good__input = software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementInput.create(_3_requests, Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnConsumedCapacity>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnConsumedCapacity._typeDescriptor()));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _5_good__transformed;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out3;
    _out3 = (_0_middlewareUnderTest).BatchExecuteStatementInputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementInputTransformInput.create(_4_good__input));
    _5_good__transformed = _out3;
    TestFixtures_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementInputTransformOutput>expect__ok(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementInputTransformOutput._typeDescriptor(), dafny.DafnySequence.asString("BatchExecuteStatement"), _5_good__transformed);
    TestFixtures_Compile.__default.<software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementInput>expect__equal(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementInput._typeDescriptor(), dafny.DafnySequence.asString("BatchExecuteStatement"), ((_5_good__transformed).dtor_value()).dtor_transformedInput(), _4_good__input);
  }
  public static void TestBatchExecuteStatementInputEncrypted()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient _0_middlewareUnderTest;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient _out0;
    _out0 = TestFixtures_Compile.__default.GetDynamoDbEncryptionTransforms();
    _0_middlewareUnderTest = _out0;
    dafny.DafnySequence<? extends Character> _1_statement;
    dafny.DafnySequence<? extends Character> _out1;
    _out1 = TestFixtures_Compile.__default.GetStatement(dafny.DafnySequence.asString("update \"foo\""));
    _1_statement = _out1;
    software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementRequest _2_request;
    _2_request = software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementRequest.create(_1_statement, Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.PreparedStatementParameters._typeDescriptor()), Wrappers_Compile.Option.<Boolean>create_None(dafny.TypeDescriptor.BOOLEAN), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnValuesOnConditionCheckFailure>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnValuesOnConditionCheckFailure._typeDescriptor()));
    dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementRequest> _3_requests;
    dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementRequest> _out2;
    _out2 = TestFixtures_Compile.__default.GetPartiQLBatchRequest(dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementRequest> of(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementRequest._typeDescriptor(), _2_request));
    _3_requests = _out2;
    software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementInput _4_bad__input;
    _4_bad__input = software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementInput.create(_3_requests, Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnConsumedCapacity>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnConsumedCapacity._typeDescriptor()));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _5_bad__transformed;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out3;
    _out3 = (_0_middlewareUnderTest).BatchExecuteStatementInputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementInputTransformInput.create(_4_bad__input));
    _5_bad__transformed = _out3;
    if (!((_5_bad__transformed).is_Failure())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryptionTransforms/test/BatchExecuteStatementTransform.dfy(55,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!(((_5_bad__transformed).dtor_error()).is_DynamoDbEncryptionTransformsException())) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryptionTransforms/test/BatchExecuteStatementTransform.dfy(56,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
    if (!((((_5_bad__transformed).dtor_error()).dtor_message()).equals(dafny.DafnySequence.asString("BatchExecuteStatement not Supported on encrypted tables.")))) {
      throw new dafny.DafnyHaltException("dafny/DynamoDbEncryptionTransforms/test/BatchExecuteStatementTransform.dfy(57,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static void TestBatchExecuteStatementOutputTransform()
  {
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient _0_middlewareUnderTest;
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.DynamoDbEncryptionTransformsClient _out0;
    _out0 = TestFixtures_Compile.__default.GetDynamoDbEncryptionTransforms();
    _0_middlewareUnderTest = _out0;
    software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementOutput _1_output;
    _1_output = software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementOutput.create(Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementResponse>>create_None(dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementResponse>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementResponse._typeDescriptor())), Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.ConsumedCapacity>>create_None(dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ConsumedCapacity>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.ConsumedCapacity._typeDescriptor())));
    dafny.DafnySequence<? extends Character> _2_statement;
    dafny.DafnySequence<? extends Character> _out1;
    _out1 = TestFixtures_Compile.__default.GetStatement(dafny.DafnySequence.asString("foo"));
    _2_statement = _out1;
    software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementRequest _3_request;
    _3_request = software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementRequest.create(_2_statement, Wrappers_Compile.Option.<dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.PreparedStatementParameters._typeDescriptor()), Wrappers_Compile.Option.<Boolean>create_None(dafny.TypeDescriptor.BOOLEAN), Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnValuesOnConditionCheckFailure>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnValuesOnConditionCheckFailure._typeDescriptor()));
    dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementRequest> _4_requests;
    dafny.DafnySequence<? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementRequest> _out2;
    _out2 = TestFixtures_Compile.__default.GetPartiQLBatchRequest(dafny.DafnySequence.<software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementRequest> of(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementRequest._typeDescriptor(), _3_request));
    _4_requests = _out2;
    software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementInput _5_input;
    _5_input = software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementInput.create(_4_requests, Wrappers_Compile.Option.<software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnConsumedCapacity>create_None(software.amazon.cryptography.services.dynamodb.internaldafny.types.ReturnConsumedCapacity._typeDescriptor()));
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _6_transformed;
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out3;
    _out3 = (_0_middlewareUnderTest).BatchExecuteStatementOutputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementOutputTransformInput.create(_1_output, _5_input));
    _6_transformed = _out3;
    TestFixtures_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementOutputTransformOutput>expect__ok(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementOutputTransformOutput._typeDescriptor(), dafny.DafnySequence.asString("BatchExecuteStatement"), _6_transformed);
    TestFixtures_Compile.__default.<software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementOutput>expect__equal(software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchExecuteStatementOutput._typeDescriptor(), dafny.DafnySequence.asString("BatchExecuteStatement"), ((_6_transformed).dtor_value()).dtor_transformedOutput(), _1_output);
  }
  @Override
  public java.lang.String toString() {
    return "BatchExecuteStatementTransformTest._default";
  }
}
