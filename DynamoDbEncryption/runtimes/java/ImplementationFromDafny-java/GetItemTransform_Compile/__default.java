// Class __default
// Dafny class __default compiled into Java
package GetItemTransform_Compile;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.GetItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> Input(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.GetItemInputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.GetItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.GetItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)null;
    output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.GetItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>create_Success(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.GetItemInputTransformOutput.create((input).dtor_sdkInput()));
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.GetItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> Output(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.GetItemOutputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.GetItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.GetItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.GetItemOutputTransformOutput.Default());
    dafny.DafnySequence<? extends Character> _1824_tableName;
    _1824_tableName = ((input).dtor_originalInput()).dtor_TableName();
    if ((!((config).dtor_tableEncryptionConfigs()).<dafny.DafnySequence<? extends Character>>contains(_1824_tableName)) || ((((input).dtor_sdkOutput()).dtor_Item()).is_None())) {
      output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.GetItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>create_Success(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.GetItemOutputTransformOutput.create((input).dtor_sdkOutput()));
      return output;
    }
    DdbMiddlewareConfig_Compile.TableConfig _1825_tableConfig;
    _1825_tableConfig = ((DdbMiddlewareConfig_Compile.TableConfig)(java.lang.Object)(((config).dtor_tableEncryptionConfigs()).get(_1824_tableName)));
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1826_decryptRes;
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _out97;
    _out97 = ((_1825_tableConfig).dtor_itemEncryptor()).DecryptItem(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemInput.create((((input).dtor_sdkOutput()).dtor_Item()).dtor_value()));
    _1826_decryptRes = _out97;
    Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput _1827_decrypted;
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1828_valueOrError0 = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput.Default());
    _1828_valueOrError0 = DdbMiddlewareConfig_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput>MapError(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput._typeDescriptor(), _1826_decryptRes);
    if ((_1828_valueOrError0).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
      output = (_1828_valueOrError0).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.GetItemOutputTransformOutput>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.GetItemOutputTransformOutput._typeDescriptor());
      return output;
    }
    _1827_decrypted = (_1828_valueOrError0).Extract(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _1829_item;
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1830_valueOrError1 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> empty());
    _1830_valueOrError1 = DynamoDbMiddlewareSupport_Compile.__default.RemoveBeacons(_1825_tableConfig, (_1827_decrypted).dtor_plaintextItem());
    if ((_1830_valueOrError1).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
      output = (_1830_valueOrError1).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.GetItemOutputTransformOutput>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.GetItemOutputTransformOutput._typeDescriptor());
      return output;
    }
    _1829_item = (_1830_valueOrError1).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _pat_let_tv19 = _1829_item;
    output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.GetItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>create_Success(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.GetItemOutputTransformOutput.create(((Dafny.Com.Amazonaws.Dynamodb.Types.GetItemOutput)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.GetItemOutput, Dafny.Com.Amazonaws.Dynamodb.Types.GetItemOutput>Let((input).dtor_sdkOutput(), boxed158 -> {
  Dafny.Com.Amazonaws.Dynamodb.Types.GetItemOutput _pat_let79_0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.GetItemOutput)(java.lang.Object)(boxed158));
  return ((Dafny.Com.Amazonaws.Dynamodb.Types.GetItemOutput)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.GetItemOutput, Dafny.Com.Amazonaws.Dynamodb.Types.GetItemOutput>Let(_pat_let79_0, boxed159 -> {
    Dafny.Com.Amazonaws.Dynamodb.Types.GetItemOutput _1831_dt__update__tmp_h0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.GetItemOutput)(java.lang.Object)(boxed159));
    return ((Dafny.Com.Amazonaws.Dynamodb.Types.GetItemOutput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>, Dafny.Com.Amazonaws.Dynamodb.Types.GetItemOutput>Let(Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>create_Some(_pat_let_tv19), boxed160 -> {
      Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> _pat_let80_0 = ((Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>)(java.lang.Object)(boxed160));
      return ((Dafny.Com.Amazonaws.Dynamodb.Types.GetItemOutput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>, Dafny.Com.Amazonaws.Dynamodb.Types.GetItemOutput>Let(_pat_let80_0, boxed161 -> {
        Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> _1832_dt__update_hItem_h0 = ((Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>)(java.lang.Object)(boxed161));
        return Dafny.Com.Amazonaws.Dynamodb.Types.GetItemOutput.create(_1832_dt__update_hItem_h0, (_1831_dt__update__tmp_h0).dtor_ConsumedCapacity());
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
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "GetItemTransform_Compile._default";
  }
}
