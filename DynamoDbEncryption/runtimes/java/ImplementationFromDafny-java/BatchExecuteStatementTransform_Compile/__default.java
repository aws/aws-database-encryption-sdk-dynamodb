// Class __default
// Dafny class __default compiled into Java
package BatchExecuteStatementTransform_Compile;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.*;
import DynamoDbEncryptionUtil_Compile.*;
import DynamoDbNormalizeNumber_Compile.*;
import DynamoToStruct_Compile.*;
import DynamoDbEncryptionBranchKeyIdSupplier_Compile.*;
import AwsCryptographyDynamoDbEncryptionOperations_Compile.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.*;
import StructuredEncryptionUtil_Compile.*;
import Sets_Compile.*;
import StructuredEncryptionPaths_Compile.*;
import StructuredEncryptionHeader_Compile.*;
import StructuredEncryptionFooter_Compile.*;
import StructuredEncryptionCrypt_Compile.*;
import Maps_Compile.*;
import AwsCryptographyStructuredEncryptionOperations_Compile.*;
import Dafny.Aws.Cryptography.StructuredEncryption.*;
import TermLoc_Compile.*;
import DdbVirtualFields_Compile.*;
import BaseBeacon_Compile.*;
import CompoundBeacon_Compile.*;
import SearchableEncryptionInfo_Compile.*;
import SearchConfigToInfo_Compile.*;
import DynamoDbUpdateExpr_Compile.*;
import DynamoDBFilterExpr_Compile.*;
import DynamoDBIndexSupport_Compile.*;
import DynamoDBSupport_Compile.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.*;
import DynamoDbItemEncryptorUtil_Compile.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Internal.*;
import AwsCryptographyDynamoDbEncryptionItemEncryptorOperations_Compile.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.*;
import DdbMiddlewareConfig_Compile.*;
import DdbStatement_Compile.*;
import DynamoDbMiddlewareSupport_Compile.*;
import PutItemTransform_Compile.*;
import GetItemTransform_Compile.*;
import UpdateItemTransform_Compile.*;
import BatchWriteItemTransform_Compile.*;
import TransactWriteItemsTransform_Compile.*;
import BatchGetItemTransform_Compile.*;
import ScanTransform_Compile.*;
import QueryTransform_Compile.*;
import TransactGetItemsTransform_Compile.*;
import DeleteItemTransform_Compile.*;
import ExecuteStatementTransform_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchExecuteStatementInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> Input(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchExecuteStatementInputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchExecuteStatementInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchExecuteStatementInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)null;
    java.math.BigInteger _hi8 = java.math.BigInteger.valueOf((((input).dtor_sdkInput()).dtor_Statements()).length());
    for (java.math.BigInteger _1992_i = java.math.BigInteger.ZERO; _1992_i.compareTo(_hi8) < 0; _1992_i = _1992_i.add(java.math.BigInteger.ONE)) {
      dafny.DafnySequence<? extends Character> _1993_statement;
      _1993_statement = (((Dafny.Com.Amazonaws.Dynamodb.Types.BatchStatementRequest)(java.lang.Object)((((input).dtor_sdkInput()).dtor_Statements()).select(dafny.Helpers.toInt((_1992_i)))))).dtor_Statement();
      dafny.DafnySequence<? extends Character> _1994_tableName;
      Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1995_valueOrError0 = (Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)null;
      _1995_valueOrError0 = DdbMiddlewareConfig_Compile.__default.<dafny.DafnySequence<? extends Character>>MapString(Dafny.Com.Amazonaws.Dynamodb.Types.TableName._typeDescriptor(), DdbStatement_Compile.__default.TableFromStatement(_1993_statement));
      if ((_1995_valueOrError0).IsFailure(Dafny.Com.Amazonaws.Dynamodb.Types.TableName._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
        output = (_1995_valueOrError0).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchExecuteStatementInputTransformOutput>PropagateFailure(Dafny.Com.Amazonaws.Dynamodb.Types.TableName._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchExecuteStatementInputTransformOutput._typeDescriptor());
        return output;
      }
      _1994_tableName = (_1995_valueOrError0).Extract(Dafny.Com.Amazonaws.Dynamodb.Types.TableName._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
      if (((config).dtor_tableEncryptionConfigs()).<dafny.DafnySequence<? extends Character>>contains(_1994_tableName)) {
        output = DdbMiddlewareConfig_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchExecuteStatementInputTransformOutput>MakeError(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchExecuteStatementInputTransformOutput._typeDescriptor(), dafny.DafnySequence.asString("BatchExecuteStatement not Supported on encrypted tables."));
        return output;
      }
    }
    output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchExecuteStatementInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>create_Success(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchExecuteStatementInputTransformOutput.create((input).dtor_sdkInput()));
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchExecuteStatementOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> Output(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchExecuteStatementOutputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchExecuteStatementOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchExecuteStatementOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchExecuteStatementOutputTransformOutput.Default());
    output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchExecuteStatementOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>create_Success(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchExecuteStatementOutputTransformOutput.create((input).dtor_sdkOutput()));
    return output;
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "BatchExecuteStatementTransform_Compile._default";
  }
}
