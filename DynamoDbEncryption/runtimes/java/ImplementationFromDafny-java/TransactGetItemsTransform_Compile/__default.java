// Class __default
// Dafny class __default compiled into Java
package TransactGetItemsTransform_Compile;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactGetItemsInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> Input(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactGetItemsInputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactGetItemsInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactGetItemsInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)null;
    output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactGetItemsInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>create_Success(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactGetItemsInputTransformOutput.create((input).dtor_sdkInput()));
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactGetItemsOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> Output(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactGetItemsOutputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactGetItemsOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactGetItemsOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactGetItemsOutputTransformOutput.Default());
    if ((((input).dtor_sdkOutput()).dtor_Responses()).is_None()) {
      output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactGetItemsOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>create_Success(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactGetItemsOutputTransformOutput.create((input).dtor_sdkOutput()));
      return output;
    }
    if (!java.util.Objects.equals(java.math.BigInteger.valueOf(((((input).dtor_sdkOutput()).dtor_Responses()).dtor_value()).length()), java.math.BigInteger.valueOf((((input).dtor_originalInput()).dtor_TransactItems()).length()))) {
      output = DdbMiddlewareConfig_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactGetItemsOutputTransformOutput>MakeError(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactGetItemsOutputTransformOutput._typeDescriptor(), dafny.DafnySequence.asString("Invalid TransactGetItems response for original request: Number of items returned must equal number of items requested."));
      return output;
    }
    dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.ItemResponse> _1973_decryptedItems;
    _1973_decryptedItems = dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.ItemResponse> empty(Dafny.Com.Amazonaws.Dynamodb.Types.ItemResponse._typeDescriptor());
    dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.ItemResponse> _1974_encryptedItems;
    _1974_encryptedItems = (((input).dtor_sdkOutput()).dtor_Responses()).dtor_value();
    java.math.BigInteger _hi7 = java.math.BigInteger.valueOf((_1974_encryptedItems).length());
    for (java.math.BigInteger _1975_x = java.math.BigInteger.ZERO; _1975_x.compareTo(_hi7) < 0; _1975_x = _1975_x.add(java.math.BigInteger.ONE)) {
      dafny.DafnySequence<? extends Character> _1976_tableName;
      _1976_tableName = ((((Dafny.Com.Amazonaws.Dynamodb.Types.TransactGetItem)(java.lang.Object)((((input).dtor_originalInput()).dtor_TransactItems()).select(dafny.Helpers.toInt((_1975_x)))))).dtor_Get()).dtor_TableName();
      if (!((config).dtor_tableEncryptionConfigs()).<dafny.DafnySequence<? extends Character>>contains(_1976_tableName)) {
        _1973_decryptedItems = dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.ItemResponse>concatenate(_1973_decryptedItems, dafny.DafnySequence.of(Dafny.Com.Amazonaws.Dynamodb.Types.ItemResponse._typeDescriptor(), ((Dafny.Com.Amazonaws.Dynamodb.Types.ItemResponse)(java.lang.Object)((_1974_encryptedItems).select(dafny.Helpers.toInt((_1975_x)))))));
      } else {
        DdbMiddlewareConfig_Compile.TableConfig _1977_tableConfig;
        _1977_tableConfig = ((DdbMiddlewareConfig_Compile.TableConfig)(java.lang.Object)(((config).dtor_tableEncryptionConfigs()).get(_1976_tableName)));
        if (((((Dafny.Com.Amazonaws.Dynamodb.Types.ItemResponse)(java.lang.Object)((_1974_encryptedItems).select(dafny.Helpers.toInt((_1975_x)))))).dtor_Item()).is_None()) {
          _1973_decryptedItems = dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.ItemResponse>concatenate(_1973_decryptedItems, dafny.DafnySequence.of(Dafny.Com.Amazonaws.Dynamodb.Types.ItemResponse._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.ItemResponse.create(Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>create_None())));
        } else {
          Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1978_decryptRes;
          Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _out111;
          _out111 = ((_1977_tableConfig).dtor_itemEncryptor()).DecryptItem(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemInput.create(((((Dafny.Com.Amazonaws.Dynamodb.Types.ItemResponse)(java.lang.Object)((_1974_encryptedItems).select(dafny.Helpers.toInt((_1975_x)))))).dtor_Item()).dtor_value()));
          _1978_decryptRes = _out111;
          Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput _1979_decrypted;
          Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1980_valueOrError0 = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput.Default());
          _1980_valueOrError0 = DdbMiddlewareConfig_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput>MapError(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput._typeDescriptor(), _1978_decryptRes);
          if ((_1980_valueOrError0).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
            output = (_1980_valueOrError0).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactGetItemsOutputTransformOutput>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactGetItemsOutputTransformOutput._typeDescriptor());
            return output;
          }
          _1979_decrypted = (_1980_valueOrError0).Extract(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
          dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _1981_item;
          Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1982_valueOrError1 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> empty());
          _1982_valueOrError1 = DynamoDbMiddlewareSupport_Compile.__default.RemoveBeacons(_1977_tableConfig, (_1979_decrypted).dtor_plaintextItem());
          if ((_1982_valueOrError1).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
            output = (_1982_valueOrError1).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactGetItemsOutputTransformOutput>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactGetItemsOutputTransformOutput._typeDescriptor());
            return output;
          }
          _1981_item = (_1982_valueOrError1).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
          _1973_decryptedItems = dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.ItemResponse>concatenate(_1973_decryptedItems, dafny.DafnySequence.of(Dafny.Com.Amazonaws.Dynamodb.Types.ItemResponse._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.ItemResponse.create(Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>create_Some(_1981_item))));
        }
      }
    }
    dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.ItemResponse> _pat_let_tv30 = _1973_decryptedItems;
    output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactGetItemsOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>create_Success(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactGetItemsOutputTransformOutput.create(((Dafny.Com.Amazonaws.Dynamodb.Types.TransactGetItemsOutput)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.TransactGetItemsOutput, Dafny.Com.Amazonaws.Dynamodb.Types.TransactGetItemsOutput>Let((input).dtor_sdkOutput(), boxed194 -> {
  Dafny.Com.Amazonaws.Dynamodb.Types.TransactGetItemsOutput _pat_let97_0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.TransactGetItemsOutput)(java.lang.Object)(boxed194));
  return ((Dafny.Com.Amazonaws.Dynamodb.Types.TransactGetItemsOutput)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.TransactGetItemsOutput, Dafny.Com.Amazonaws.Dynamodb.Types.TransactGetItemsOutput>Let(_pat_let97_0, boxed195 -> {
    Dafny.Com.Amazonaws.Dynamodb.Types.TransactGetItemsOutput _1983_dt__update__tmp_h0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.TransactGetItemsOutput)(java.lang.Object)(boxed195));
    return ((Dafny.Com.Amazonaws.Dynamodb.Types.TransactGetItemsOutput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.ItemResponse>>, Dafny.Com.Amazonaws.Dynamodb.Types.TransactGetItemsOutput>Let(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.ItemResponse>>create_Some(_pat_let_tv30), boxed196 -> {
      Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.ItemResponse>> _pat_let98_0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.ItemResponse>>)(java.lang.Object)(boxed196));
      return ((Dafny.Com.Amazonaws.Dynamodb.Types.TransactGetItemsOutput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.ItemResponse>>, Dafny.Com.Amazonaws.Dynamodb.Types.TransactGetItemsOutput>Let(_pat_let98_0, boxed197 -> {
        Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.ItemResponse>> _1984_dt__update_hResponses_h0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.ItemResponse>>)(java.lang.Object)(boxed197));
        return Dafny.Com.Amazonaws.Dynamodb.Types.TransactGetItemsOutput.create((_1983_dt__update__tmp_h0).dtor_ConsumedCapacity(), _1984_dt__update_hResponses_h0);
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
    return "TransactGetItemsTransform_Compile._default";
  }
}
