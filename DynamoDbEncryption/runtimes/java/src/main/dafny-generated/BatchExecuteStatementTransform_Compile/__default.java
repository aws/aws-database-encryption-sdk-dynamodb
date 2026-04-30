// Class __default
// Dafny class __default compiled into Java
package BatchExecuteStatementTransform_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> Input(DdbMiddlewareConfig_Compile.Config config, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementInputTransformInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> output = (Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>)null;
    java.math.BigInteger _hi0 = java.math.BigInteger.valueOf((((input).dtor_sdkInput()).dtor_Statements()).length());
    for (java.math.BigInteger _0_i = java.math.BigInteger.ZERO; _0_i.compareTo(_hi0) < 0; _0_i = _0_i.add(java.math.BigInteger.ONE)) {
      dafny.DafnySequence<? extends Character> _1_statement;
      _1_statement = (((software.amazon.cryptography.services.dynamodb.internaldafny.types.BatchStatementRequest)(java.lang.Object)((((input).dtor_sdkInput()).dtor_Statements()).select(dafny.Helpers.toInt((_0_i)))))).dtor_Statement();
      Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _2_valueOrError0 = (Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>)null;
      _2_valueOrError0 = DdbMiddlewareConfig_Compile.__default.<dafny.DafnySequence<? extends Character>>MapString(software.amazon.cryptography.services.dynamodb.internaldafny.types.TableName._typeDescriptor(), DdbStatement_Compile.__default.TableFromStatement(_1_statement));
      if ((_2_valueOrError0).IsFailure(software.amazon.cryptography.services.dynamodb.internaldafny.types.TableName._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor())) {
        output = (_2_valueOrError0).<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementInputTransformOutput>PropagateFailure(software.amazon.cryptography.services.dynamodb.internaldafny.types.TableName._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementInputTransformOutput._typeDescriptor());
        return output;
      }
      dafny.DafnySequence<? extends Character> _3_tableName;
      _3_tableName = (_2_valueOrError0).Extract(software.amazon.cryptography.services.dynamodb.internaldafny.types.TableName._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor());
      if (((config).dtor_tableEncryptionConfigs()).<dafny.DafnySequence<? extends Character>>contains(_3_tableName)) {
        output = DdbMiddlewareConfig_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementInputTransformOutput>MakeError(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementInputTransformOutput._typeDescriptor(), dafny.DafnySequence.asString("BatchExecuteStatement not Supported on encrypted tables."));
        return output;
      }
    }
    output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>create_Success(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementInputTransformOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementInputTransformOutput.create((input).dtor_sdkInput()));
    return output;
  }
  public static Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> Output(DdbMiddlewareConfig_Compile.Config config, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementOutputTransformInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementOutputTransformOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementOutputTransformOutput.Default());
    output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>create_Success(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementOutputTransformOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementOutputTransformOutput.create((input).dtor_sdkOutput()));
    return output;
  }
  @Override
  public java.lang.String toString() {
    return "BatchExecuteStatementTransform._default";
  }
}
