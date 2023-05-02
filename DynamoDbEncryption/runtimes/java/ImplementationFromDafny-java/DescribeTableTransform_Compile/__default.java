// Class __default
// Dafny class __default compiled into Java
package DescribeTableTransform_Compile;

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
import BatchExecuteStatementTransform_Compile.*;
import ExecuteTransactionTransform_Compile.*;
import CreateTableTransform_Compile.*;
import UpdateTableTransform_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DescribeTableInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> Input(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DescribeTableInputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DescribeTableInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DescribeTableInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)null;
    output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DescribeTableInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>create_Success(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DescribeTableInputTransformOutput.create((input).dtor_sdkInput()));
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DescribeTableOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> Output(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DescribeTableOutputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DescribeTableOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DescribeTableOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DescribeTableOutputTransformOutput.Default());
    if(true) {
      if (!((config).dtor_tableEncryptionConfigs()).<dafny.DafnySequence<? extends Character>>contains(((input).dtor_originalInput()).dtor_TableName())) {
        output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DescribeTableOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>create_Success(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DescribeTableOutputTransformOutput.create((input).dtor_sdkOutput()));
        return output;
      } else {
        DdbMiddlewareConfig_Compile.TableConfig _2006_tableConfig;
        _2006_tableConfig = ((DdbMiddlewareConfig_Compile.TableConfig)(java.lang.Object)(((config).dtor_tableEncryptionConfigs()).get(((input).dtor_originalInput()).dtor_TableName())));
        Dafny.Com.Amazonaws.Dynamodb.Types.DescribeTableOutput _2007_finalResult;
        Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.DescribeTableOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _2008_valueOrError0 = Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.DescribeTableOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Dafny.Com.Amazonaws.Dynamodb.Types.DescribeTableOutput.Default());
        _2008_valueOrError0 = DynamoDbMiddlewareSupport_Compile.__default.DescribeTableOutputForBeacons(_2006_tableConfig, (input).dtor_sdkOutput());
        if ((_2008_valueOrError0).IsFailure(Dafny.Com.Amazonaws.Dynamodb.Types.DescribeTableOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
          output = (_2008_valueOrError0).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DescribeTableOutputTransformOutput>PropagateFailure(Dafny.Com.Amazonaws.Dynamodb.Types.DescribeTableOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DescribeTableOutputTransformOutput._typeDescriptor());
          return output;
        }
        _2007_finalResult = (_2008_valueOrError0).Extract(Dafny.Com.Amazonaws.Dynamodb.Types.DescribeTableOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
        output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DescribeTableOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>create_Success(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DescribeTableOutputTransformOutput.create(_2007_finalResult));
        return output;
      }
    }
    return output;
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "DescribeTableTransform_Compile._default";
  }
}
