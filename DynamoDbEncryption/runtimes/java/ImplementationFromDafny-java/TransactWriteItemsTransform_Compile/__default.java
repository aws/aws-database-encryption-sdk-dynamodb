// Class __default
// Dafny class __default compiled into Java
package TransactWriteItemsTransform_Compile;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static boolean IsValid(Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItem item) {
    return (((((item).dtor_Put()).is_Some()) || (((item).dtor_Update()).is_Some())) || (((item).dtor_Delete()).is_Some())) || (((item).dtor_ConditionCheck()).is_Some());
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> Input(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)null;
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1863_valueOrError0 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default();
    _1863_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformInput, Boolean>)(_1864_input) -> dafny.Helpers.Quantifier((((_1864_input).dtor_sdkInput()).dtor_TransactItems()).UniqueElements(), true, ((_forall_var_19_boxed0) -> {
      Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItem _forall_var_19 = ((Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItem)(java.lang.Object)(_forall_var_19_boxed0));
      if (true) {
        Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItem _1865_item = (Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItem)_forall_var_19;
        return !((((_1864_input).dtor_sdkInput()).dtor_TransactItems()).contains(_1865_item)) || (__default.IsValid(_1865_item));
      } else {
        return true;
      }
    }))).apply(input), DdbMiddlewareConfig_Compile.__default.E(dafny.DafnySequence.asString("Each item in TransactWriteItems must specify at least one supported operation")));
    if ((_1863_valueOrError0).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
      output = (_1863_valueOrError0).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformOutput>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformOutput._typeDescriptor());
      return output;
    }
    dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItem> _1866_result;
    _1866_result = dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItem> empty(Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItem._typeDescriptor());
    java.math.BigInteger _hi3 = java.math.BigInteger.valueOf((((input).dtor_sdkInput()).dtor_TransactItems()).length());
    for (java.math.BigInteger _1867_x = java.math.BigInteger.ZERO; _1867_x.compareTo(_hi3) < 0; _1867_x = _1867_x.add(java.math.BigInteger.ONE)) {
      Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItem _1868_item;
      _1868_item = ((Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItem)(java.lang.Object)((((input).dtor_sdkInput()).dtor_TransactItems()).select(dafny.Helpers.toInt((_1867_x)))));
      if ((((_1868_item).dtor_ConditionCheck()).is_Some()) && (((config).dtor_tableEncryptionConfigs()).<dafny.DafnySequence<? extends Character>>contains((((_1868_item).dtor_ConditionCheck()).dtor_value()).dtor_TableName()))) {
        DdbMiddlewareConfig_Compile.TableConfig _1869_tableConfig;
        _1869_tableConfig = ((DdbMiddlewareConfig_Compile.TableConfig)(java.lang.Object)(((config).dtor_tableEncryptionConfigs()).get((((_1868_item).dtor_ConditionCheck()).dtor_value()).dtor_TableName())));
        boolean _1870___v0;
        Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1871_valueOrError1 = Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(false);
        _1871_valueOrError1 = DynamoDbMiddlewareSupport_Compile.__default.TestConditionExpression(_1869_tableConfig, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some((((_1868_item).dtor_ConditionCheck()).dtor_value()).dtor_ConditionExpression()), (((_1868_item).dtor_ConditionCheck()).dtor_value()).dtor_ExpressionAttributeNames(), (((_1868_item).dtor_ConditionCheck()).dtor_value()).dtor_ExpressionAttributeValues());
        if ((_1871_valueOrError1).IsFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
          output = (_1871_valueOrError1).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformOutput>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformOutput._typeDescriptor());
          return output;
        }
        _1870___v0 = (_1871_valueOrError1).Extract(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
      }
      if ((((_1868_item).dtor_Delete()).is_Some()) && (((config).dtor_tableEncryptionConfigs()).<dafny.DafnySequence<? extends Character>>contains((((_1868_item).dtor_Delete()).dtor_value()).dtor_TableName()))) {
        DdbMiddlewareConfig_Compile.TableConfig _1872_tableConfig;
        _1872_tableConfig = ((DdbMiddlewareConfig_Compile.TableConfig)(java.lang.Object)(((config).dtor_tableEncryptionConfigs()).get((((_1868_item).dtor_Delete()).dtor_value()).dtor_TableName())));
        boolean _1873___v1;
        Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1874_valueOrError2 = Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(false);
        _1874_valueOrError2 = DynamoDbMiddlewareSupport_Compile.__default.TestConditionExpression(_1872_tableConfig, (((_1868_item).dtor_Delete()).dtor_value()).dtor_ConditionExpression(), (((_1868_item).dtor_Delete()).dtor_value()).dtor_ExpressionAttributeNames(), (((_1868_item).dtor_Delete()).dtor_value()).dtor_ExpressionAttributeValues());
        if ((_1874_valueOrError2).IsFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
          output = (_1874_valueOrError2).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformOutput>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformOutput._typeDescriptor());
          return output;
        }
        _1873___v1 = (_1874_valueOrError2).Extract(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
      }
      if ((((_1868_item).dtor_Update()).is_Some()) && (((config).dtor_tableEncryptionConfigs()).<dafny.DafnySequence<? extends Character>>contains((((_1868_item).dtor_Update()).dtor_value()).dtor_TableName()))) {
        DdbMiddlewareConfig_Compile.TableConfig _1875_tableConfig;
        _1875_tableConfig = ((DdbMiddlewareConfig_Compile.TableConfig)(java.lang.Object)(((config).dtor_tableEncryptionConfigs()).get((((_1868_item).dtor_Update()).dtor_value()).dtor_TableName())));
        boolean _1876___v2;
        Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1877_valueOrError3 = Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(false);
        _1877_valueOrError3 = DynamoDbMiddlewareSupport_Compile.__default.TestUpdateExpression(_1875_tableConfig, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some((((_1868_item).dtor_Update()).dtor_value()).dtor_UpdateExpression()), (((_1868_item).dtor_Update()).dtor_value()).dtor_ExpressionAttributeNames(), (((_1868_item).dtor_Update()).dtor_value()).dtor_ExpressionAttributeValues());
        if ((_1877_valueOrError3).IsFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
          output = (_1877_valueOrError3).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformOutput>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformOutput._typeDescriptor());
          return output;
        }
        _1876___v2 = (_1877_valueOrError3).Extract(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
        boolean _1878___v3;
        Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1879_valueOrError4 = Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(false);
        _1879_valueOrError4 = DynamoDbMiddlewareSupport_Compile.__default.TestConditionExpression(_1875_tableConfig, (((_1868_item).dtor_Update()).dtor_value()).dtor_ConditionExpression(), (((_1868_item).dtor_Update()).dtor_value()).dtor_ExpressionAttributeNames(), (((_1868_item).dtor_Update()).dtor_value()).dtor_ExpressionAttributeValues());
        if ((_1879_valueOrError4).IsFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
          output = (_1879_valueOrError4).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformOutput>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformOutput._typeDescriptor());
          return output;
        }
        _1878___v3 = (_1879_valueOrError4).Extract(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
      }
      if ((((_1868_item).dtor_Put()).is_Some()) && (((config).dtor_tableEncryptionConfigs()).<dafny.DafnySequence<? extends Character>>contains((((_1868_item).dtor_Put()).dtor_value()).dtor_TableName()))) {
        DdbMiddlewareConfig_Compile.TableConfig _1880_tableConfig;
        _1880_tableConfig = ((DdbMiddlewareConfig_Compile.TableConfig)(java.lang.Object)(((config).dtor_tableEncryptionConfigs()).get((((_1868_item).dtor_Put()).dtor_value()).dtor_TableName())));
        boolean _1881___v4;
        Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1882_valueOrError5 = Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(false);
        _1882_valueOrError5 = DynamoDbMiddlewareSupport_Compile.__default.IsWriteable(_1880_tableConfig, (((_1868_item).dtor_Put()).dtor_value()).dtor_Item());
        if ((_1882_valueOrError5).IsFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
          output = (_1882_valueOrError5).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformOutput>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformOutput._typeDescriptor());
          return output;
        }
        _1881___v4 = (_1882_valueOrError5).Extract(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
        boolean _1883___v5;
        Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1884_valueOrError6 = Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(false);
        _1884_valueOrError6 = DynamoDbMiddlewareSupport_Compile.__default.TestConditionExpression(_1880_tableConfig, (((_1868_item).dtor_Put()).dtor_value()).dtor_ConditionExpression(), (((_1868_item).dtor_Put()).dtor_value()).dtor_ExpressionAttributeNames(), (((_1868_item).dtor_Put()).dtor_value()).dtor_ExpressionAttributeValues());
        if ((_1884_valueOrError6).IsFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
          output = (_1884_valueOrError6).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformOutput>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformOutput._typeDescriptor());
          return output;
        }
        _1883___v5 = (_1884_valueOrError6).Extract(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _1885_beaconItem;
        Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1886_valueOrError7 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> empty());
        Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out101;
        _out101 = DynamoDbMiddlewareSupport_Compile.__default.AddSignedBeacons(_1880_tableConfig, (((_1868_item).dtor_Put()).dtor_value()).dtor_Item());
        _1886_valueOrError7 = _out101;
        if ((_1886_valueOrError7).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
          output = (_1886_valueOrError7).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformOutput>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformOutput._typeDescriptor());
          return output;
        }
        _1885_beaconItem = (_1886_valueOrError7).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
        Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1887_encryptRes;
        Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _out102;
        _out102 = ((_1880_tableConfig).dtor_itemEncryptor()).EncryptItem(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemInput.create(_1885_beaconItem));
        _1887_encryptRes = _out102;
        Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput _1888_encrypted;
        Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1889_valueOrError8 = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput.Default());
        _1889_valueOrError8 = DdbMiddlewareConfig_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput>MapError(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput._typeDescriptor(), _1887_encryptRes);
        if ((_1889_valueOrError8).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
          output = (_1889_valueOrError8).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformOutput>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformOutput._typeDescriptor());
          return output;
        }
        _1888_encrypted = (_1889_valueOrError8).Extract(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
        Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _1890_keyId;
        Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1891_valueOrError9 = Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>Default());
        _1891_valueOrError9 = DynamoDbMiddlewareSupport_Compile.__default.GetKeyIdFromHeader(_1880_tableConfig, _1888_encrypted);
        if ((_1891_valueOrError9).IsFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
          output = (_1891_valueOrError9).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformOutput>PropagateFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformOutput._typeDescriptor());
          return output;
        }
        _1890_keyId = (_1891_valueOrError9).Extract(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _1892_beaconAttrs;
        Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1893_valueOrError10 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> empty());
        Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out103;
        _out103 = DynamoDbMiddlewareSupport_Compile.__default.GetEncryptedBeacons(_1880_tableConfig, (((_1868_item).dtor_Put()).dtor_value()).dtor_Item(), DynamoDbEncryptionUtil_Compile.__default.MaybeFromOptionKeyId(_1890_keyId));
        _1893_valueOrError10 = _out103;
        if ((_1893_valueOrError10).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
          output = (_1893_valueOrError10).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformOutput>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformOutput._typeDescriptor());
          return output;
        }
        _1892_beaconAttrs = (_1893_valueOrError10).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
        Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput _pat_let_tv23 = _1888_encrypted;
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _pat_let_tv24 = _1892_beaconAttrs;
        Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Put> _1894_put;
        _1894_put = Wrappers_Compile.Option.<Dafny.Com.Amazonaws.Dynamodb.Types.Put>create_Some(((Dafny.Com.Amazonaws.Dynamodb.Types.Put)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.Put, Dafny.Com.Amazonaws.Dynamodb.Types.Put>Let(((_1868_item).dtor_Put()).dtor_value(), boxed170 -> {
  Dafny.Com.Amazonaws.Dynamodb.Types.Put _pat_let85_0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.Put)(java.lang.Object)(boxed170));
  return ((Dafny.Com.Amazonaws.Dynamodb.Types.Put)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.Put, Dafny.Com.Amazonaws.Dynamodb.Types.Put>Let(_pat_let85_0, boxed171 -> {
    Dafny.Com.Amazonaws.Dynamodb.Types.Put _1895_dt__update__tmp_h0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.Put)(java.lang.Object)(boxed171));
    return ((Dafny.Com.Amazonaws.Dynamodb.Types.Put)(java.lang.Object)(dafny.Helpers.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Com.Amazonaws.Dynamodb.Types.Put>Let(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>merge((_pat_let_tv23).dtor_encryptedItem(), _pat_let_tv24), boxed172 -> {
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _pat_let86_0 = ((dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>)(java.lang.Object)(boxed172));
      return ((Dafny.Com.Amazonaws.Dynamodb.Types.Put)(java.lang.Object)(dafny.Helpers.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Com.Amazonaws.Dynamodb.Types.Put>Let(_pat_let86_0, boxed173 -> {
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _1896_dt__update_hItem_h0 = ((dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>)(java.lang.Object)(boxed173));
        return Dafny.Com.Amazonaws.Dynamodb.Types.Put.create(_1896_dt__update_hItem_h0, (_1895_dt__update__tmp_h0).dtor_TableName(), (_1895_dt__update__tmp_h0).dtor_ConditionExpression(), (_1895_dt__update__tmp_h0).dtor_ExpressionAttributeNames(), (_1895_dt__update__tmp_h0).dtor_ExpressionAttributeValues(), (_1895_dt__update__tmp_h0).dtor_ReturnValuesOnConditionCheckFailure());
      }
      )));
    }
    )));
  }
  )));
}
))));
        Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Put> _pat_let_tv25 = _1894_put;
        Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItem _1897_newItem;
        _1897_newItem = ((Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItem)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItem, Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItem>Let(_1868_item, boxed174 -> {
          Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItem _pat_let87_0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItem)(java.lang.Object)(boxed174));
          return ((Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItem)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItem, Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItem>Let(_pat_let87_0, boxed175 -> {
            Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItem _1898_dt__update__tmp_h1 = ((Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItem)(java.lang.Object)(boxed175));
            return ((Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItem)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Put>, Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItem>Let(_pat_let_tv25, boxed176 -> {
              Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Put> _pat_let88_0 = ((Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Put>)(java.lang.Object)(boxed176));
              return ((Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItem)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Put>, Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItem>Let(_pat_let88_0, boxed177 -> {
                Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Put> _1899_dt__update_hPut_h0 = ((Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.Put>)(java.lang.Object)(boxed177));
                return Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItem.create((_1898_dt__update__tmp_h1).dtor_ConditionCheck(), _1899_dt__update_hPut_h0, (_1898_dt__update__tmp_h1).dtor_Delete(), (_1898_dt__update__tmp_h1).dtor_Update());
              }
              )));
            }
            )));
          }
          )));
        }
        )));
        _1866_result = dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItem>concatenate(_1866_result, dafny.DafnySequence.of(Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItem._typeDescriptor(), _1897_newItem));
      } else {
        _1866_result = dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItem>concatenate(_1866_result, dafny.DafnySequence.of(Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItem._typeDescriptor(), _1868_item));
      }
    }
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1900_valueOrError11 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default();
    _1900_valueOrError11 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), java.util.Objects.equals(java.math.BigInteger.valueOf((((input).dtor_sdkInput()).dtor_TransactItems()).length()), java.math.BigInteger.valueOf((_1866_result).length())), DdbMiddlewareConfig_Compile.__default.E(dafny.DafnySequence.asString("")));
    if ((_1900_valueOrError11).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
      output = (_1900_valueOrError11).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformOutput>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformOutput._typeDescriptor());
      return output;
    }
    dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItem> _pat_let_tv26 = _1866_result;
    output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>create_Success(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformOutput.create(((Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItemsInput)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItemsInput, Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItemsInput>Let((input).dtor_sdkInput(), boxed178 -> {
  Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItemsInput _pat_let89_0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItemsInput)(java.lang.Object)(boxed178));
  return ((Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItemsInput)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItemsInput, Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItemsInput>Let(_pat_let89_0, boxed179 -> {
    Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItemsInput _1901_dt__update__tmp_h2 = ((Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItemsInput)(java.lang.Object)(boxed179));
    return ((Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItemsInput)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItem>, Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItemsInput>Let(_pat_let_tv26, boxed180 -> {
      dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItem> _pat_let90_0 = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItem>)(java.lang.Object)(boxed180));
      return ((Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItemsInput)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItem>, Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItemsInput>Let(_pat_let90_0, boxed181 -> {
        dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItem> _1902_dt__update_hTransactItems_h0 = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItem>)(java.lang.Object)(boxed181));
        return Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItemsInput.create(_1902_dt__update_hTransactItems_h0, (_1901_dt__update__tmp_h2).dtor_ReturnConsumedCapacity(), (_1901_dt__update__tmp_h2).dtor_ReturnItemCollectionMetrics(), (_1901_dt__update__tmp_h2).dtor_ClientRequestToken());
      }
      )));
    }
    )));
  }
  )));
}
)))));
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> Output(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsOutputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsOutputTransformOutput.Default());
    Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItemsOutput _1903_finalResult;
    _1903_finalResult = (input).dtor_sdkOutput();
    output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>create_Success(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsOutputTransformOutput.create(_1903_finalResult));
    return output;
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "TransactWriteItemsTransform_Compile._default";
  }
}
