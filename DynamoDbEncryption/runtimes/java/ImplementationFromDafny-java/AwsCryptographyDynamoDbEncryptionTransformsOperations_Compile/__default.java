// Class __default
// Dafny class __default compiled into Java
package AwsCryptographyDynamoDbEncryptionTransformsOperations_Compile;

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
import DescribeTableTransform_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> PutItemInputTransform(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemInputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)null;
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out112;
      _out112 = PutItemTransform_Compile.__default.Input(config, input);
      output = _out112;
    }
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> PutItemOutputTransform(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemOutputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemOutputTransformOutput.Default());
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out113;
      _out113 = PutItemTransform_Compile.__default.Output(config, input);
      output = _out113;
    }
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.GetItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> GetItemInputTransform(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.GetItemInputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.GetItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.GetItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)null;
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.GetItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out114;
      _out114 = GetItemTransform_Compile.__default.Input(config, input);
      output = _out114;
    }
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.GetItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> GetItemOutputTransform(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.GetItemOutputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.GetItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.GetItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.GetItemOutputTransformOutput.Default());
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.GetItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out115;
      _out115 = GetItemTransform_Compile.__default.Output(config, input);
      output = _out115;
    }
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> UpdateItemInputTransform(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateItemInputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)null;
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out116;
      _out116 = UpdateItemTransform_Compile.__default.Input(config, input);
      output = _out116;
    }
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> UpdateItemOutputTransform(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateItemOutputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateItemOutputTransformOutput.Default());
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out117;
      _out117 = UpdateItemTransform_Compile.__default.Output(config, input);
      output = _out117;
    }
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> BatchWriteItemInputTransform(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemInputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)null;
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out118;
      _out118 = BatchWriteItemTransform_Compile.__default.Input(config, input);
      output = _out118;
    }
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> BatchWriteItemOutputTransform(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemOutputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemOutputTransformOutput.Default());
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out119;
      _out119 = BatchWriteItemTransform_Compile.__default.Output(config, input);
      output = _out119;
    }
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> TransactWriteItemsInputTransform(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)null;
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out120;
      _out120 = TransactWriteItemsTransform_Compile.__default.Input(config, input);
      output = _out120;
    }
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> TransactWriteItemsOutputTransform(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsOutputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsOutputTransformOutput.Default());
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out121;
      _out121 = TransactWriteItemsTransform_Compile.__default.Output(config, input);
      output = _out121;
    }
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchGetItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> BatchGetItemInputTransform(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchGetItemInputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchGetItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchGetItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)null;
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchGetItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out122;
      _out122 = BatchGetItemTransform_Compile.__default.Input(config, input);
      output = _out122;
    }
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchGetItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> BatchGetItemOutputTransform(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchGetItemOutputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchGetItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchGetItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchGetItemOutputTransformOutput.Default());
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchGetItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out123;
      _out123 = BatchGetItemTransform_Compile.__default.Output(config, input);
      output = _out123;
    }
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> ScanInputTransform(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanInputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)null;
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out124;
      _out124 = ScanTransform_Compile.__default.Input(config, input);
      output = _out124;
    }
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> ScanOutputTransform(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanOutputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanOutputTransformOutput.Default());
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out125;
      _out125 = ScanTransform_Compile.__default.Output(config, input);
      output = _out125;
    }
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> QueryInputTransform(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryInputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)null;
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out126;
      _out126 = QueryTransform_Compile.__default.Input(config, input);
      output = _out126;
    }
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> QueryOutputTransform(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryOutputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryOutputTransformOutput.Default());
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out127;
      _out127 = QueryTransform_Compile.__default.Output(config, input);
      output = _out127;
    }
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactGetItemsInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> TransactGetItemsInputTransform(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactGetItemsInputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactGetItemsInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactGetItemsInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)null;
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactGetItemsInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out128;
      _out128 = TransactGetItemsTransform_Compile.__default.Input(config, input);
      output = _out128;
    }
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactGetItemsOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> TransactGetItemsOutputTransform(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactGetItemsOutputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactGetItemsOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactGetItemsOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactGetItemsOutputTransformOutput.Default());
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactGetItemsOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out129;
      _out129 = TransactGetItemsTransform_Compile.__default.Output(config, input);
      output = _out129;
    }
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DeleteItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> DeleteItemInputTransform(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DeleteItemInputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DeleteItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DeleteItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)null;
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DeleteItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out130;
      _out130 = DeleteItemTransform_Compile.__default.Input(config, input);
      output = _out130;
    }
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DeleteItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> DeleteItemOutputTransform(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DeleteItemOutputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DeleteItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DeleteItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DeleteItemOutputTransformOutput.Default());
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DeleteItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out131;
      _out131 = DeleteItemTransform_Compile.__default.Output(config, input);
      output = _out131;
    }
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ExecuteStatementInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> ExecuteStatementInputTransform(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ExecuteStatementInputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ExecuteStatementInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ExecuteStatementInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)null;
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ExecuteStatementInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out132;
      _out132 = ExecuteStatementTransform_Compile.__default.Input(config, input);
      output = _out132;
    }
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ExecuteStatementOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> ExecuteStatementOutputTransform(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ExecuteStatementOutputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ExecuteStatementOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ExecuteStatementOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ExecuteStatementOutputTransformOutput.Default());
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ExecuteStatementOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out133;
      _out133 = ExecuteStatementTransform_Compile.__default.Output(config, input);
      output = _out133;
    }
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchExecuteStatementInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> BatchExecuteStatementInputTransform(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchExecuteStatementInputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchExecuteStatementInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchExecuteStatementInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)null;
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchExecuteStatementInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out134;
      _out134 = BatchExecuteStatementTransform_Compile.__default.Input(config, input);
      output = _out134;
    }
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchExecuteStatementOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> BatchExecuteStatementOutputTransform(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchExecuteStatementOutputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchExecuteStatementOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchExecuteStatementOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchExecuteStatementOutputTransformOutput.Default());
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchExecuteStatementOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out135;
      _out135 = BatchExecuteStatementTransform_Compile.__default.Output(config, input);
      output = _out135;
    }
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ExecuteTransactionInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> ExecuteTransactionInputTransform(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ExecuteTransactionInputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ExecuteTransactionInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ExecuteTransactionInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)null;
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ExecuteTransactionInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out136;
      _out136 = ExecuteTransactionTransform_Compile.__default.Input(config, input);
      output = _out136;
    }
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ExecuteTransactionOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> ExecuteTransactionOutputTransform(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ExecuteTransactionOutputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ExecuteTransactionOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ExecuteTransactionOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ExecuteTransactionOutputTransformOutput.Default());
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ExecuteTransactionOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out137;
      _out137 = ExecuteTransactionTransform_Compile.__default.Output(config, input);
      output = _out137;
    }
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.CreateTableInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> CreateTableInputTransform(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.CreateTableInputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.CreateTableInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.CreateTableInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)null;
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.CreateTableInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out138;
      _out138 = CreateTableTransform_Compile.__default.Input(config, input);
      output = _out138;
    }
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.CreateTableOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> CreateTableOutputTransform(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.CreateTableOutputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.CreateTableOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.CreateTableOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.CreateTableOutputTransformOutput.Default());
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.CreateTableOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out139;
      _out139 = CreateTableTransform_Compile.__default.Output(config, input);
      output = _out139;
    }
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateTableInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> UpdateTableInputTransform(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateTableInputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateTableInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateTableInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)null;
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateTableInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out140;
      _out140 = UpdateTableTransform_Compile.__default.Input(config, input);
      output = _out140;
    }
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateTableOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> UpdateTableOutputTransform(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateTableOutputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateTableOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateTableOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateTableOutputTransformOutput.Default());
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateTableOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out141;
      _out141 = UpdateTableTransform_Compile.__default.Output(config, input);
      output = _out141;
    }
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DescribeTableInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> DescribeTableInputTransform(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DescribeTableInputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DescribeTableInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DescribeTableInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)null;
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DescribeTableInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out142;
      _out142 = DescribeTableTransform_Compile.__default.Input(config, input);
      output = _out142;
    }
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DescribeTableOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> DescribeTableOutputTransform(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DescribeTableOutputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DescribeTableOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DescribeTableOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DescribeTableOutputTransformOutput.Default());
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DescribeTableOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out143;
      _out143 = DescribeTableTransform_Compile.__default.Output(config, input);
      output = _out143;
    }
    return output;
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "AwsCryptographyDynamoDbEncryptionTransformsOperations_Compile._default";
  }
}
