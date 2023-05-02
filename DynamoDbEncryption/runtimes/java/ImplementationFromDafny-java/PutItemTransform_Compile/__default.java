// Class __default
// Dafny class __default compiled into Java
package PutItemTransform_Compile;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> Input(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemInputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)null;
    if (!((config).dtor_tableEncryptionConfigs()).<dafny.DafnySequence<? extends Character>>contains(((input).dtor_sdkInput()).dtor_TableName())) {
      output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>create_Success(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemInputTransformOutput.create((input).dtor_sdkInput()));
      return output;
    }
    DdbMiddlewareConfig_Compile.TableConfig _1808_tableConfig;
    _1808_tableConfig = ((DdbMiddlewareConfig_Compile.TableConfig)(java.lang.Object)(((config).dtor_tableEncryptionConfigs()).get(((input).dtor_sdkInput()).dtor_TableName())));
    if ((((input).dtor_sdkInput()).dtor_Expected()).is_Some()) {
      output = DdbMiddlewareConfig_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemInputTransformOutput>MakeError(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemInputTransformOutput._typeDescriptor(), dafny.DafnySequence.asString("Legacy parameter 'Expected' not supported in PutItem with Encryption."));
      return output;
    }
    if ((((input).dtor_sdkInput()).dtor_ConditionalOperator()).is_Some()) {
      output = DdbMiddlewareConfig_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemInputTransformOutput>MakeError(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemInputTransformOutput._typeDescriptor(), dafny.DafnySequence.asString("Legacy parameter 'ConditionalOperator' not supported in PutItem with Encryption."));
      return output;
    }
    boolean _1809___v0;
    Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1810_valueOrError0 = Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(false);
    _1810_valueOrError0 = DynamoDbMiddlewareSupport_Compile.__default.IsWriteable(_1808_tableConfig, ((input).dtor_sdkInput()).dtor_Item());
    if ((_1810_valueOrError0).IsFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
      output = (_1810_valueOrError0).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemInputTransformOutput>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemInputTransformOutput._typeDescriptor());
      return output;
    }
    _1809___v0 = (_1810_valueOrError0).Extract(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
    boolean _1811___v1;
    Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1812_valueOrError1 = Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(false);
    _1812_valueOrError1 = DynamoDbMiddlewareSupport_Compile.__default.TestConditionExpression(_1808_tableConfig, ((input).dtor_sdkInput()).dtor_ConditionExpression(), ((input).dtor_sdkInput()).dtor_ExpressionAttributeNames(), ((input).dtor_sdkInput()).dtor_ExpressionAttributeValues());
    if ((_1812_valueOrError1).IsFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
      output = (_1812_valueOrError1).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemInputTransformOutput>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemInputTransformOutput._typeDescriptor());
      return output;
    }
    _1811___v1 = (_1812_valueOrError1).Extract(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _1813_item;
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1814_valueOrError2 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> empty());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out94;
    _out94 = DynamoDbMiddlewareSupport_Compile.__default.AddSignedBeacons(_1808_tableConfig, ((input).dtor_sdkInput()).dtor_Item());
    _1814_valueOrError2 = _out94;
    if ((_1814_valueOrError2).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
      output = (_1814_valueOrError2).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemInputTransformOutput>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemInputTransformOutput._typeDescriptor());
      return output;
    }
    _1813_item = (_1814_valueOrError2).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1815_encryptRes;
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _out95;
    _out95 = ((_1808_tableConfig).dtor_itemEncryptor()).EncryptItem(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemInput.create(_1813_item));
    _1815_encryptRes = _out95;
    Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput _1816_encrypted;
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1817_valueOrError3 = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput.Default());
    _1817_valueOrError3 = DdbMiddlewareConfig_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput>MapError(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput._typeDescriptor(), _1815_encryptRes);
    if ((_1817_valueOrError3).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
      output = (_1817_valueOrError3).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemInputTransformOutput>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemInputTransformOutput._typeDescriptor());
      return output;
    }
    _1816_encrypted = (_1817_valueOrError3).Extract(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
    Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _1818_keyId;
    Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1819_valueOrError4 = Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>Default());
    _1819_valueOrError4 = DynamoDbMiddlewareSupport_Compile.__default.GetKeyIdFromHeader(_1808_tableConfig, _1816_encrypted);
    if ((_1819_valueOrError4).IsFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
      output = (_1819_valueOrError4).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemInputTransformOutput>PropagateFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemInputTransformOutput._typeDescriptor());
      return output;
    }
    _1818_keyId = (_1819_valueOrError4).Extract(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _1820_beacons;
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1821_valueOrError5 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> empty());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out96;
    _out96 = DynamoDbMiddlewareSupport_Compile.__default.GetEncryptedBeacons(_1808_tableConfig, ((input).dtor_sdkInput()).dtor_Item(), DynamoDbEncryptionUtil_Compile.__default.MaybeFromOptionKeyId(_1818_keyId));
    _1821_valueOrError5 = _out96;
    if ((_1821_valueOrError5).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
      output = (_1821_valueOrError5).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemInputTransformOutput>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemInputTransformOutput._typeDescriptor());
      return output;
    }
    _1820_beacons = (_1821_valueOrError5).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
    Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput _pat_let_tv17 = _1816_encrypted;
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _pat_let_tv18 = _1820_beacons;
    output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>create_Success(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemInputTransformOutput.create(((Dafny.Com.Amazonaws.Dynamodb.Types.PutItemInput)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.PutItemInput, Dafny.Com.Amazonaws.Dynamodb.Types.PutItemInput>Let((input).dtor_sdkInput(), boxed154 -> {
  Dafny.Com.Amazonaws.Dynamodb.Types.PutItemInput _pat_let77_0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.PutItemInput)(java.lang.Object)(boxed154));
  return ((Dafny.Com.Amazonaws.Dynamodb.Types.PutItemInput)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.PutItemInput, Dafny.Com.Amazonaws.Dynamodb.Types.PutItemInput>Let(_pat_let77_0, boxed155 -> {
    Dafny.Com.Amazonaws.Dynamodb.Types.PutItemInput _1822_dt__update__tmp_h0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.PutItemInput)(java.lang.Object)(boxed155));
    return ((Dafny.Com.Amazonaws.Dynamodb.Types.PutItemInput)(java.lang.Object)(dafny.Helpers.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Com.Amazonaws.Dynamodb.Types.PutItemInput>Let(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>merge((_pat_let_tv17).dtor_encryptedItem(), _pat_let_tv18), boxed156 -> {
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _pat_let78_0 = ((dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>)(java.lang.Object)(boxed156));
      return ((Dafny.Com.Amazonaws.Dynamodb.Types.PutItemInput)(java.lang.Object)(dafny.Helpers.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Com.Amazonaws.Dynamodb.Types.PutItemInput>Let(_pat_let78_0, boxed157 -> {
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _1823_dt__update_hItem_h0 = ((dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>)(java.lang.Object)(boxed157));
        return Dafny.Com.Amazonaws.Dynamodb.Types.PutItemInput.create((_1822_dt__update__tmp_h0).dtor_TableName(), _1823_dt__update_hItem_h0, (_1822_dt__update__tmp_h0).dtor_Expected(), (_1822_dt__update__tmp_h0).dtor_ReturnValues(), (_1822_dt__update__tmp_h0).dtor_ReturnConsumedCapacity(), (_1822_dt__update__tmp_h0).dtor_ReturnItemCollectionMetrics(), (_1822_dt__update__tmp_h0).dtor_ConditionalOperator(), (_1822_dt__update__tmp_h0).dtor_ConditionExpression(), (_1822_dt__update__tmp_h0).dtor_ExpressionAttributeNames(), (_1822_dt__update__tmp_h0).dtor_ExpressionAttributeValues());
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
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> Output(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemOutputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemOutputTransformOutput.Default());
    output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>create_Success(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemOutputTransformOutput.create((input).dtor_sdkOutput()));
    return output;
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "PutItemTransform_Compile._default";
  }
}
