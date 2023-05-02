// Class __default
// Dafny class __default compiled into Java
package QueryTransform_Compile;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> Input(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryInputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)null;
    if(true) {
      if (!((config).dtor_tableEncryptionConfigs()).<dafny.DafnySequence<? extends Character>>contains(((input).dtor_sdkInput()).dtor_TableName())) {
        output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>create_Success(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryInputTransformOutput.create((input).dtor_sdkInput()));
        return output;
      } else {
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1945_valueOrError0 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default();
        _1945_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), (((input).dtor_sdkInput()).dtor_AttributesToGet()).is_None(), DdbMiddlewareConfig_Compile.__default.E(dafny.DafnySequence.asString("Legacy parameter 'AttributesToGet' not supported in UpdateItem with Encryption")));
        if ((_1945_valueOrError0).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
          output = (_1945_valueOrError0).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryInputTransformOutput>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryInputTransformOutput._typeDescriptor());
          return output;
        }
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1946_valueOrError1 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default();
        _1946_valueOrError1 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), (((input).dtor_sdkInput()).dtor_KeyConditions()).is_None(), DdbMiddlewareConfig_Compile.__default.E(dafny.DafnySequence.asString("Legacy parameter 'ScanFilter' not supported in UpdateItem with Encryption")));
        if ((_1946_valueOrError1).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
          output = (_1946_valueOrError1).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryInputTransformOutput>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryInputTransformOutput._typeDescriptor());
          return output;
        }
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1947_valueOrError2 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default();
        _1947_valueOrError2 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), (((input).dtor_sdkInput()).dtor_QueryFilter()).is_None(), DdbMiddlewareConfig_Compile.__default.E(dafny.DafnySequence.asString("Legacy parameter 'ScanFilter' not supported in UpdateItem with Encryption")));
        if ((_1947_valueOrError2).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
          output = (_1947_valueOrError2).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryInputTransformOutput>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryInputTransformOutput._typeDescriptor());
          return output;
        }
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1948_valueOrError3 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default();
        _1948_valueOrError3 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), (((input).dtor_sdkInput()).dtor_ConditionalOperator()).is_None(), DdbMiddlewareConfig_Compile.__default.E(dafny.DafnySequence.asString("Legacy parameter 'ConditionalOperator' not supported in UpdateItem with Encryption")));
        if ((_1948_valueOrError3).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
          output = (_1948_valueOrError3).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryInputTransformOutput>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryInputTransformOutput._typeDescriptor());
          return output;
        }
        DdbMiddlewareConfig_Compile.TableConfig _1949_tableConfig;
        _1949_tableConfig = ((DdbMiddlewareConfig_Compile.TableConfig)(java.lang.Object)(((config).dtor_tableEncryptionConfigs()).get(((input).dtor_sdkInput()).dtor_TableName())));
        Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput _1950_finalResult;
        Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1951_valueOrError4 = (Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)null;
        Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out108;
        _out108 = DynamoDbMiddlewareSupport_Compile.__default.QueryInputForBeacons(_1949_tableConfig, (input).dtor_sdkInput());
        _1951_valueOrError4 = _out108;
        if ((_1951_valueOrError4).IsFailure(Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
          output = (_1951_valueOrError4).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryInputTransformOutput>PropagateFailure(Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryInputTransformOutput._typeDescriptor());
          return output;
        }
        _1950_finalResult = (_1951_valueOrError4).Extract(Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
        output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>create_Success(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryInputTransformOutput.create(_1950_finalResult));
        return output;
      }
    }
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> Output(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryOutputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryOutputTransformOutput.Default());
    dafny.DafnySequence<? extends Character> _1952_tableName;
    _1952_tableName = ((input).dtor_originalInput()).dtor_TableName();
    if ((!((config).dtor_tableEncryptionConfigs()).<dafny.DafnySequence<? extends Character>>contains(_1952_tableName)) || ((((input).dtor_sdkOutput()).dtor_Items()).is_None())) {
      output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>create_Success(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryOutputTransformOutput.create((input).dtor_sdkOutput()));
      return output;
    }
    DdbMiddlewareConfig_Compile.TableConfig _1953_tableConfig;
    _1953_tableConfig = ((DdbMiddlewareConfig_Compile.TableConfig)(java.lang.Object)(((config).dtor_tableEncryptionConfigs()).get(_1952_tableName)));
    dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> _1954_decryptedItems;
    _1954_decryptedItems = dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> empty(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()));
    dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> _1955_encryptedItems;
    _1955_encryptedItems = (((input).dtor_sdkOutput()).dtor_Items()).dtor_value();
    DynamoDbEncryptionUtil_Compile.MaybeKeyId _1956_keyId;
    Wrappers_Compile.Result<DynamoDbEncryptionUtil_Compile.MaybeKeyId, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1957_valueOrError0 = Wrappers_Compile.Result.<DynamoDbEncryptionUtil_Compile.MaybeKeyId, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(DynamoDbEncryptionUtil_Compile.MaybeKeyId.Default());
    _1957_valueOrError0 = DynamoDbMiddlewareSupport_Compile.__default.GetBeaconKeyId(_1953_tableConfig, ((input).dtor_originalInput()).dtor_KeyConditionExpression(), ((input).dtor_originalInput()).dtor_FilterExpression(), ((input).dtor_originalInput()).dtor_ExpressionAttributeValues(), ((input).dtor_originalInput()).dtor_ExpressionAttributeNames());
    if ((_1957_valueOrError0).IsFailure(DynamoDbEncryptionUtil_Compile.MaybeKeyId._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
      output = (_1957_valueOrError0).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryOutputTransformOutput>PropagateFailure(DynamoDbEncryptionUtil_Compile.MaybeKeyId._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryOutputTransformOutput._typeDescriptor());
      return output;
    }
    _1956_keyId = (_1957_valueOrError0).Extract(DynamoDbEncryptionUtil_Compile.MaybeKeyId._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
    dafny.DafnySequence<? extends java.lang.Byte> _1958_keyIdUtf8;
    _1958_keyIdUtf8 = dafny.DafnySequence.<java.lang.Byte> empty(StandardLibrary_mUInt_Compile.uint8._typeDescriptor());
    if ((_1956_keyId).is_KeyId()) {
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1959_valueOrError1 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(UTF8.ValidUTF8Bytes.defaultValue());
      _1959_valueOrError1 = (UTF8.__default.Encode((_1956_keyId).dtor_value())).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>MapFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)(_1960_e_boxed0) -> {
        dafny.DafnySequence<? extends Character> _1960_e = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_1960_e_boxed0));
        return DdbMiddlewareConfig_Compile.__default.E(_1960_e);
      }));
      if ((_1959_valueOrError1).IsFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
        output = (_1959_valueOrError1).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryOutputTransformOutput>PropagateFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryOutputTransformOutput._typeDescriptor());
        return output;
      }
      _1958_keyIdUtf8 = (_1959_valueOrError1).Extract(UTF8.ValidUTF8Bytes._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
    }
    java.math.BigInteger _hi6 = java.math.BigInteger.valueOf((_1955_encryptedItems).length());
    for (java.math.BigInteger _1961_x = java.math.BigInteger.ZERO; _1961_x.compareTo(_hi6) < 0; _1961_x = _1961_x.add(java.math.BigInteger.ONE)) {
      Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemInput _1962_decryptInput;
      _1962_decryptInput = Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemInput.create(((dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>)(java.lang.Object)((_1955_encryptedItems).select(dafny.Helpers.toInt((_1961_x))))));
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1963_decryptRes;
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _out109;
      _out109 = ((_1953_tableConfig).dtor_itemEncryptor()).DecryptItem(_1962_decryptInput);
      _1963_decryptRes = _out109;
      Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput _1964_decrypted;
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1965_valueOrError2 = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput.Default());
      _1965_valueOrError2 = DdbMiddlewareConfig_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput>MapError(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput._typeDescriptor(), _1963_decryptRes);
      if ((_1965_valueOrError2).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
        output = (_1965_valueOrError2).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryOutputTransformOutput>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryOutputTransformOutput._typeDescriptor());
        return output;
      }
      _1964_decrypted = (_1965_valueOrError2).Extract(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
      if ((_1956_keyId).is_KeyId()) {
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1966_valueOrError3 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default();
        _1966_valueOrError3 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), ((_1964_decrypted).dtor_parsedHeader()).is_Some(), DdbMiddlewareConfig_Compile.__default.E(dafny.DafnySequence.asString("Decrypted query result has no parsed header.")));
        if ((_1966_valueOrError3).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
          output = (_1966_valueOrError3).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryOutputTransformOutput>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryOutputTransformOutput._typeDescriptor());
          return output;
        }
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1967_valueOrError4 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default();
        _1967_valueOrError4 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), java.util.Objects.equals(java.math.BigInteger.valueOf(((((_1964_decrypted).dtor_parsedHeader()).dtor_value()).dtor_encryptedDataKeys()).length()), java.math.BigInteger.ONE), DdbMiddlewareConfig_Compile.__default.E(dafny.DafnySequence.asString("Query result has more than one Encrypted Data Key")));
        if ((_1967_valueOrError4).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
          output = (_1967_valueOrError4).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryOutputTransformOutput>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryOutputTransformOutput._typeDescriptor());
          return output;
        }
        if (((((Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey)(java.lang.Object)(((((_1964_decrypted).dtor_parsedHeader()).dtor_value()).dtor_encryptedDataKeys()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_keyProviderInfo()).equals(_1958_keyIdUtf8)) {
          _1954_decryptedItems = dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>concatenate(_1954_decryptedItems, dafny.DafnySequence.of(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), (_1964_decrypted).dtor_plaintextItem()));
        }
      } else {
        _1954_decryptedItems = dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>concatenate(_1954_decryptedItems, dafny.DafnySequence.of(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), (_1964_decrypted).dtor_plaintextItem()));
      }
    }
    dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> _pat_let_tv29 = _1954_decryptedItems;
    Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput _1968_decryptedOutput;
    _1968_decryptedOutput = ((Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput, Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput>Let((input).dtor_sdkOutput(), boxed190 -> {
      Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput _pat_let95_0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput)(java.lang.Object)(boxed190));
      return ((Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput, Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput>Let(_pat_let95_0, boxed191 -> {
        Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput _1969_dt__update__tmp_h0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput)(java.lang.Object)(boxed191));
        return ((Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>>, Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput>Let(Wrappers_Compile.Option.<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>>create_Some(_pat_let_tv29), boxed192 -> {
          Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>> _pat_let96_0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>>)(java.lang.Object)(boxed192));
          return ((Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>>, Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput>Let(_pat_let96_0, boxed193 -> {
            Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>> _1970_dt__update_hItems_h0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>>)(java.lang.Object)(boxed193));
            return Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput.create(_1970_dt__update_hItems_h0, (_1969_dt__update__tmp_h0).dtor_Count(), (_1969_dt__update__tmp_h0).dtor_ScannedCount(), (_1969_dt__update__tmp_h0).dtor_LastEvaluatedKey(), (_1969_dt__update__tmp_h0).dtor_ConsumedCapacity());
          }
          )));
        }
        )));
      }
      )));
    }
    )));
    Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput _1971_finalResult;
    Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1972_valueOrError5 = Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput.Default());
    Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out110;
    _out110 = DynamoDbMiddlewareSupport_Compile.__default.QueryOutputForBeacons(_1953_tableConfig, (input).dtor_originalInput(), _1968_decryptedOutput);
    _1972_valueOrError5 = _out110;
    if ((_1972_valueOrError5).IsFailure(Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
      output = (_1972_valueOrError5).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryOutputTransformOutput>PropagateFailure(Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryOutputTransformOutput._typeDescriptor());
      return output;
    }
    _1971_finalResult = (_1972_valueOrError5).Extract(Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
    output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>create_Success(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.QueryOutputTransformOutput.create(_1971_finalResult));
    return output;
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "QueryTransform_Compile._default";
  }
}
