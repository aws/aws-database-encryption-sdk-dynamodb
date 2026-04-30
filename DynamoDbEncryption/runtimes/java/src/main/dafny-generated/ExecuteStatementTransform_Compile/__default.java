// Class __default
// Dafny class __default compiled into Java
package ExecuteStatementTransform_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> Input(DdbMiddlewareConfig_Compile.Config config, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementInputTransformInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> output = (Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>)null;
    if(true) {
      Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _0_valueOrError0 = (Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>)null;
      _0_valueOrError0 = DdbMiddlewareConfig_Compile.__default.<dafny.DafnySequence<? extends Character>>MapString(software.amazon.cryptography.services.dynamodb.internaldafny.types.TableName._typeDescriptor(), DdbStatement_Compile.__default.TableFromStatement(((input).dtor_sdkInput()).dtor_Statement()));
      if ((_0_valueOrError0).IsFailure(software.amazon.cryptography.services.dynamodb.internaldafny.types.TableName._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor())) {
        output = (_0_valueOrError0).<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementInputTransformOutput>PropagateFailure(software.amazon.cryptography.services.dynamodb.internaldafny.types.TableName._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementInputTransformOutput._typeDescriptor());
        return output;
      }
      dafny.DafnySequence<? extends Character> _1_tableName;
      _1_tableName = (_0_valueOrError0).Extract(software.amazon.cryptography.services.dynamodb.internaldafny.types.TableName._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor());
      if (((config).dtor_tableEncryptionConfigs()).<dafny.DafnySequence<? extends Character>>contains(_1_tableName)) {
        output = DdbMiddlewareConfig_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementInputTransformOutput>MakeError(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementInputTransformOutput._typeDescriptor(), dafny.DafnySequence.asString("ExecuteStatement not Supported on encrypted tables."));
        return output;
      } else {
        output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>create_Success(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementInputTransformOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementInputTransformOutput.create((input).dtor_sdkInput()));
        return output;
      }
    }
    return output;
  }
  public static Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> Output(DdbMiddlewareConfig_Compile.Config config, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementOutputTransformInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementOutputTransformOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementOutputTransformOutput.Default());
    output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>create_Success(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementOutputTransformOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementOutputTransformOutput.create((input).dtor_sdkOutput()));
    return output;
  }
  @Override
  public java.lang.String toString() {
    return "ExecuteStatementTransform._default";
  }
}
