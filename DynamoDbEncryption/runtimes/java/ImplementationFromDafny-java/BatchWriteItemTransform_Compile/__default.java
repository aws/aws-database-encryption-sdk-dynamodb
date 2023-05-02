// Class __default
// Dafny class __default compiled into Java
package BatchWriteItemTransform_Compile;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> Input(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemInputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)null;
    dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> _1839_tableNames;
    _1839_tableNames = (((input).dtor_sdkInput()).dtor_RequestItems()).keySet();
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.WriteRequest>> _1840_result;
    _1840_result = dafny.DafnyMap.fromElements();
    while (!(_1839_tableNames).equals(dafny.DafnySet.<dafny.DafnySequence<? extends Character>> empty())) {
      dafny.DafnySequence<? extends Character> _1841_tableName;
      goto__ASSIGN_SUCH_THAT_1: {
        for (dafny.DafnySequence<? extends Character> _assign_such_that_1_boxed0 : (_1839_tableNames).Elements()) {
          dafny.DafnySequence<? extends Character> _assign_such_that_1 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_assign_such_that_1_boxed0));
          if (true) {
            _1841_tableName = (dafny.DafnySequence<? extends Character>)_assign_such_that_1;
            if ((_1839_tableNames).<dafny.DafnySequence<? extends Character>>contains(_1841_tableName)) {
              break goto__ASSIGN_SUCH_THAT_1;
            }
          }
        }
        throw new IllegalArgumentException("assign-such-that search produced no value (line 28)");
      }
      _1839_tableNames = dafny.DafnySet.<dafny.DafnySequence<? extends Character>>difference(_1839_tableNames, dafny.DafnySet.of(_1841_tableName));
      dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.WriteRequest> _1842_writeRequests;
      _1842_writeRequests = ((dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.WriteRequest>)(java.lang.Object)((((input).dtor_sdkInput()).dtor_RequestItems()).get(_1841_tableName)));
      if (((config).dtor_tableEncryptionConfigs()).<dafny.DafnySequence<? extends Character>>contains(_1841_tableName)) {
        DdbMiddlewareConfig_Compile.TableConfig _1843_tableConfig;
        _1843_tableConfig = ((DdbMiddlewareConfig_Compile.TableConfig)(java.lang.Object)(((config).dtor_tableEncryptionConfigs()).get(_1841_tableName)));
        dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.WriteRequest> _1844_encryptedItems;
        _1844_encryptedItems = dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.WriteRequest> empty(Dafny.Com.Amazonaws.Dynamodb.Types.WriteRequest._typeDescriptor());
        java.math.BigInteger _hi2 = java.math.BigInteger.valueOf((_1842_writeRequests).length());
        for (java.math.BigInteger _1845_x = java.math.BigInteger.ZERO; _1845_x.compareTo(_hi2) < 0; _1845_x = _1845_x.add(java.math.BigInteger.ONE)) {
          Dafny.Com.Amazonaws.Dynamodb.Types.WriteRequest _1846_req;
          _1846_req = ((Dafny.Com.Amazonaws.Dynamodb.Types.WriteRequest)(java.lang.Object)((_1842_writeRequests).select(dafny.Helpers.toInt((_1845_x)))));
          if (((_1846_req).dtor_PutRequest()).is_None()) {
            _1844_encryptedItems = dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.WriteRequest>concatenate(_1844_encryptedItems, dafny.DafnySequence.of(Dafny.Com.Amazonaws.Dynamodb.Types.WriteRequest._typeDescriptor(), _1846_req));
          } else {
            boolean _1847___v0;
            Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1848_valueOrError0 = Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(false);
            _1848_valueOrError0 = DynamoDbMiddlewareSupport_Compile.__default.IsWriteable(_1843_tableConfig, (((_1846_req).dtor_PutRequest()).dtor_value()).dtor_Item());
            if ((_1848_valueOrError0).IsFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
              output = (_1848_valueOrError0).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemInputTransformOutput>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemInputTransformOutput._typeDescriptor());
              return output;
            }
            _1847___v0 = (_1848_valueOrError0).Extract(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _1849_item;
            Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1850_valueOrError1 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> empty());
            Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out98;
            _out98 = DynamoDbMiddlewareSupport_Compile.__default.AddSignedBeacons(_1843_tableConfig, (((_1846_req).dtor_PutRequest()).dtor_value()).dtor_Item());
            _1850_valueOrError1 = _out98;
            if ((_1850_valueOrError1).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
              output = (_1850_valueOrError1).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemInputTransformOutput>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemInputTransformOutput._typeDescriptor());
              return output;
            }
            _1849_item = (_1850_valueOrError1).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
            Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1851_encryptRes;
            Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _out99;
            _out99 = ((_1843_tableConfig).dtor_itemEncryptor()).EncryptItem(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemInput.create(_1849_item));
            _1851_encryptRes = _out99;
            Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput _1852_encrypted;
            Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1853_valueOrError2 = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput.Default());
            _1853_valueOrError2 = DdbMiddlewareConfig_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput>MapError(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput._typeDescriptor(), _1851_encryptRes);
            if ((_1853_valueOrError2).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
              output = (_1853_valueOrError2).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemInputTransformOutput>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemInputTransformOutput._typeDescriptor());
              return output;
            }
            _1852_encrypted = (_1853_valueOrError2).Extract(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
            Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _1854_keyId;
            Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1855_valueOrError3 = Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>Default());
            _1855_valueOrError3 = DynamoDbMiddlewareSupport_Compile.__default.GetKeyIdFromHeader(_1843_tableConfig, _1852_encrypted);
            if ((_1855_valueOrError3).IsFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
              output = (_1855_valueOrError3).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemInputTransformOutput>PropagateFailure(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemInputTransformOutput._typeDescriptor());
              return output;
            }
            _1854_keyId = (_1855_valueOrError3).Extract(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _1856_beaconAttrs;
            Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1857_valueOrError4 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> empty());
            Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out100;
            _out100 = DynamoDbMiddlewareSupport_Compile.__default.GetEncryptedBeacons(_1843_tableConfig, (((_1846_req).dtor_PutRequest()).dtor_value()).dtor_Item(), DynamoDbEncryptionUtil_Compile.__default.MaybeFromOptionKeyId(_1854_keyId));
            _1857_valueOrError4 = _out100;
            if ((_1857_valueOrError4).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
              output = (_1857_valueOrError4).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemInputTransformOutput>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemInputTransformOutput._typeDescriptor());
              return output;
            }
            _1856_beaconAttrs = (_1857_valueOrError4).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
            Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput _pat_let_tv20 = _1852_encrypted;
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _pat_let_tv21 = _1856_beaconAttrs;
            _1844_encryptedItems = dafny.DafnySequence.<Dafny.Com.Amazonaws.Dynamodb.Types.WriteRequest>concatenate(_1844_encryptedItems, dafny.DafnySequence.of(Dafny.Com.Amazonaws.Dynamodb.Types.WriteRequest._typeDescriptor(), ((Dafny.Com.Amazonaws.Dynamodb.Types.WriteRequest)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.WriteRequest, Dafny.Com.Amazonaws.Dynamodb.Types.WriteRequest>Let(_1846_req, boxed162 -> {
              Dafny.Com.Amazonaws.Dynamodb.Types.WriteRequest _pat_let81_0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.WriteRequest)(java.lang.Object)(boxed162));
              return ((Dafny.Com.Amazonaws.Dynamodb.Types.WriteRequest)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.WriteRequest, Dafny.Com.Amazonaws.Dynamodb.Types.WriteRequest>Let(_pat_let81_0, boxed163 -> {
                Dafny.Com.Amazonaws.Dynamodb.Types.WriteRequest _1858_dt__update__tmp_h0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.WriteRequest)(java.lang.Object)(boxed163));
                return ((Dafny.Com.Amazonaws.Dynamodb.Types.WriteRequest)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.PutRequest>, Dafny.Com.Amazonaws.Dynamodb.Types.WriteRequest>Let(Wrappers_Compile.Option.<Dafny.Com.Amazonaws.Dynamodb.Types.PutRequest>create_Some(Dafny.Com.Amazonaws.Dynamodb.Types.PutRequest.create(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>merge((_pat_let_tv20).dtor_encryptedItem(), _pat_let_tv21))), boxed164 -> {
                  Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.PutRequest> _pat_let82_0 = ((Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.PutRequest>)(java.lang.Object)(boxed164));
                  return ((Dafny.Com.Amazonaws.Dynamodb.Types.WriteRequest)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.PutRequest>, Dafny.Com.Amazonaws.Dynamodb.Types.WriteRequest>Let(_pat_let82_0, boxed165 -> {
                    Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.PutRequest> _1859_dt__update_hPutRequest_h0 = ((Wrappers_Compile.Option<Dafny.Com.Amazonaws.Dynamodb.Types.PutRequest>)(java.lang.Object)(boxed165));
                    return Dafny.Com.Amazonaws.Dynamodb.Types.WriteRequest.create(_1859_dt__update_hPutRequest_h0, (_1858_dt__update__tmp_h0).dtor_DeleteRequest());
                  }
                  )));
                }
                )));
              }
              )));
            }
            )))));
          }
        }
        _1842_writeRequests = _1844_encryptedItems;
      }
      _1840_result = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.WriteRequest>>update(_1840_result, _1841_tableName, _1842_writeRequests);
    }
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1860_valueOrError5 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default();
    _1860_valueOrError5 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), java.util.Objects.equals(java.math.BigInteger.valueOf((_1840_result).size()), java.math.BigInteger.valueOf((((input).dtor_sdkInput()).dtor_RequestItems()).size())), DdbMiddlewareConfig_Compile.__default.E(dafny.DafnySequence.asString("Internal Error")));
    if ((_1860_valueOrError5).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
      output = (_1860_valueOrError5).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemInputTransformOutput>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemInputTransformOutput._typeDescriptor());
      return output;
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.WriteRequest>> _pat_let_tv22 = _1840_result;
    output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>create_Success(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemInputTransformOutput.create(((Dafny.Com.Amazonaws.Dynamodb.Types.BatchWriteItemInput)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.BatchWriteItemInput, Dafny.Com.Amazonaws.Dynamodb.Types.BatchWriteItemInput>Let((input).dtor_sdkInput(), boxed166 -> {
  Dafny.Com.Amazonaws.Dynamodb.Types.BatchWriteItemInput _pat_let83_0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.BatchWriteItemInput)(java.lang.Object)(boxed166));
  return ((Dafny.Com.Amazonaws.Dynamodb.Types.BatchWriteItemInput)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.BatchWriteItemInput, Dafny.Com.Amazonaws.Dynamodb.Types.BatchWriteItemInput>Let(_pat_let83_0, boxed167 -> {
    Dafny.Com.Amazonaws.Dynamodb.Types.BatchWriteItemInput _1861_dt__update__tmp_h1 = ((Dafny.Com.Amazonaws.Dynamodb.Types.BatchWriteItemInput)(java.lang.Object)(boxed167));
    return ((Dafny.Com.Amazonaws.Dynamodb.Types.BatchWriteItemInput)(java.lang.Object)(dafny.Helpers.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.WriteRequest>>, Dafny.Com.Amazonaws.Dynamodb.Types.BatchWriteItemInput>Let(_pat_let_tv22, boxed168 -> {
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.WriteRequest>> _pat_let84_0 = ((dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.WriteRequest>>)(java.lang.Object)(boxed168));
      return ((Dafny.Com.Amazonaws.Dynamodb.Types.BatchWriteItemInput)(java.lang.Object)(dafny.Helpers.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.WriteRequest>>, Dafny.Com.Amazonaws.Dynamodb.Types.BatchWriteItemInput>Let(_pat_let84_0, boxed169 -> {
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.WriteRequest>> _1862_dt__update_hRequestItems_h0 = ((dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Dafny.Com.Amazonaws.Dynamodb.Types.WriteRequest>>)(java.lang.Object)(boxed169));
        return Dafny.Com.Amazonaws.Dynamodb.Types.BatchWriteItemInput.create(_1862_dt__update_hRequestItems_h0, (_1861_dt__update__tmp_h1).dtor_ReturnConsumedCapacity(), (_1861_dt__update__tmp_h1).dtor_ReturnItemCollectionMetrics());
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
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> Output(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemOutputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemOutputTransformOutput.Default());
    output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>create_Success(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchWriteItemOutputTransformOutput.create((input).dtor_sdkOutput()));
    return output;
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "BatchWriteItemTransform_Compile._default";
  }
}
