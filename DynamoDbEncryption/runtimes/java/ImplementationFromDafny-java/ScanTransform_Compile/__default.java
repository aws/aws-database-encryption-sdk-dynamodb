// Class __default
// Dafny class __default compiled into Java
package ScanTransform_Compile;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> Input(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanInputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)null;
    if(true) {
      if (!((config).dtor_tableEncryptionConfigs()).<dafny.DafnySequence<? extends Character>>contains(((input).dtor_sdkInput()).dtor_TableName())) {
        output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>create_Success(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanInputTransformOutput.create((input).dtor_sdkInput()));
        return output;
      } else {
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1918_valueOrError0 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default();
        _1918_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), (((input).dtor_sdkInput()).dtor_AttributesToGet()).is_None(), DdbMiddlewareConfig_Compile.__default.E(dafny.DafnySequence.asString("Legacy parameter 'AttributesToGet' not supported in UpdateItem with Encryption")));
        if ((_1918_valueOrError0).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
          output = (_1918_valueOrError0).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanInputTransformOutput>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanInputTransformOutput._typeDescriptor());
          return output;
        }
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1919_valueOrError1 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default();
        _1919_valueOrError1 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), (((input).dtor_sdkInput()).dtor_ScanFilter()).is_None(), DdbMiddlewareConfig_Compile.__default.E(dafny.DafnySequence.asString("Legacy parameter 'ScanFilter' not supported in UpdateItem with Encryption")));
        if ((_1919_valueOrError1).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
          output = (_1919_valueOrError1).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanInputTransformOutput>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanInputTransformOutput._typeDescriptor());
          return output;
        }
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1920_valueOrError2 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default();
        _1920_valueOrError2 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), (((input).dtor_sdkInput()).dtor_ConditionalOperator()).is_None(), DdbMiddlewareConfig_Compile.__default.E(dafny.DafnySequence.asString("Legacy parameter 'ConditionalOperator' not supported in UpdateItem with Encryption")));
        if ((_1920_valueOrError2).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
          output = (_1920_valueOrError2).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanInputTransformOutput>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanInputTransformOutput._typeDescriptor());
          return output;
        }
        DdbMiddlewareConfig_Compile.TableConfig _1921_tableConfig;
        _1921_tableConfig = ((DdbMiddlewareConfig_Compile.TableConfig)(java.lang.Object)(((config).dtor_tableEncryptionConfigs()).get(((input).dtor_sdkInput()).dtor_TableName())));
        Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput _1922_finalResult;
        Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1923_valueOrError3 = (Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)null;
        Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out105;
        _out105 = DynamoDbMiddlewareSupport_Compile.__default.ScanInputForBeacons(_1921_tableConfig, (input).dtor_sdkInput());
        _1923_valueOrError3 = _out105;
        if ((_1923_valueOrError3).IsFailure(Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
          output = (_1923_valueOrError3).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanInputTransformOutput>PropagateFailure(Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanInputTransformOutput._typeDescriptor());
          return output;
        }
        _1922_finalResult = (_1923_valueOrError3).Extract(Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
        output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanInputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>create_Success(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanInputTransformOutput.create(_1922_finalResult));
        return output;
      }
    }
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> Output(DdbMiddlewareConfig_Compile.Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanOutputTransformInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanOutputTransformOutput.Default());
    dafny.DafnySequence<? extends Character> _1924_tableName;
    _1924_tableName = ((input).dtor_originalInput()).dtor_TableName();
    if ((!((config).dtor_tableEncryptionConfigs()).<dafny.DafnySequence<? extends Character>>contains(_1924_tableName)) || ((((input).dtor_sdkOutput()).dtor_Items()).is_None())) {
      output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>create_Success(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanOutputTransformOutput.create((input).dtor_sdkOutput()));
      return output;
    }
    DdbMiddlewareConfig_Compile.TableConfig _1925_tableConfig;
    _1925_tableConfig = ((DdbMiddlewareConfig_Compile.TableConfig)(java.lang.Object)(((config).dtor_tableEncryptionConfigs()).get(_1924_tableName)));
    dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> _1926_decryptedItems;
    _1926_decryptedItems = dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> empty(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()));
    dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> _1927_encryptedItems;
    _1927_encryptedItems = (((input).dtor_sdkOutput()).dtor_Items()).dtor_value();
    DynamoDbEncryptionUtil_Compile.MaybeKeyId _1928_keyId;
    Wrappers_Compile.Result<DynamoDbEncryptionUtil_Compile.MaybeKeyId, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1929_valueOrError0 = Wrappers_Compile.Result.<DynamoDbEncryptionUtil_Compile.MaybeKeyId, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(DynamoDbEncryptionUtil_Compile.MaybeKeyId.Default());
    _1929_valueOrError0 = DynamoDbMiddlewareSupport_Compile.__default.GetBeaconKeyId(_1925_tableConfig, Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(), ((input).dtor_originalInput()).dtor_FilterExpression(), ((input).dtor_originalInput()).dtor_ExpressionAttributeValues(), ((input).dtor_originalInput()).dtor_ExpressionAttributeNames());
    if ((_1929_valueOrError0).IsFailure(DynamoDbEncryptionUtil_Compile.MaybeKeyId._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
      output = (_1929_valueOrError0).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanOutputTransformOutput>PropagateFailure(DynamoDbEncryptionUtil_Compile.MaybeKeyId._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanOutputTransformOutput._typeDescriptor());
      return output;
    }
    _1928_keyId = (_1929_valueOrError0).Extract(DynamoDbEncryptionUtil_Compile.MaybeKeyId._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
    dafny.DafnySequence<? extends java.lang.Byte> _1930_keyIdUtf8;
    _1930_keyIdUtf8 = dafny.DafnySequence.<java.lang.Byte> empty(StandardLibrary_mUInt_Compile.uint8._typeDescriptor());
    if ((_1928_keyId).is_KeyId()) {
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1931_valueOrError1 = Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(UTF8.ValidUTF8Bytes.defaultValue());
      _1931_valueOrError1 = (UTF8.__default.Encode((_1928_keyId).dtor_value())).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>MapFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)(_1932_e_boxed0) -> {
        dafny.DafnySequence<? extends Character> _1932_e = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_1932_e_boxed0));
        return DdbMiddlewareConfig_Compile.__default.E(_1932_e);
      }));
      if ((_1931_valueOrError1).IsFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
        output = (_1931_valueOrError1).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanOutputTransformOutput>PropagateFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanOutputTransformOutput._typeDescriptor());
        return output;
      }
      _1930_keyIdUtf8 = (_1931_valueOrError1).Extract(UTF8.ValidUTF8Bytes._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
    }
    java.math.BigInteger _hi5 = java.math.BigInteger.valueOf((_1927_encryptedItems).length());
    for (java.math.BigInteger _1933_x = java.math.BigInteger.ZERO; _1933_x.compareTo(_hi5) < 0; _1933_x = _1933_x.add(java.math.BigInteger.ONE)) {
      Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemInput _1934_decryptInput;
      _1934_decryptInput = Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemInput.create(((dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>)(java.lang.Object)((_1927_encryptedItems).select(dafny.Helpers.toInt((_1933_x))))));
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1935_decryptRes;
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _out106;
      _out106 = ((_1925_tableConfig).dtor_itemEncryptor()).DecryptItem(_1934_decryptInput);
      _1935_decryptRes = _out106;
      Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput _1936_decrypted;
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1937_valueOrError2 = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput.Default());
      _1937_valueOrError2 = DdbMiddlewareConfig_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput>MapError(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput._typeDescriptor(), _1935_decryptRes);
      if ((_1937_valueOrError2).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
        output = (_1937_valueOrError2).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanOutputTransformOutput>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanOutputTransformOutput._typeDescriptor());
        return output;
      }
      _1936_decrypted = (_1937_valueOrError2).Extract(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
      if ((_1928_keyId).is_KeyId()) {
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1938_valueOrError3 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default();
        _1938_valueOrError3 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), ((_1936_decrypted).dtor_parsedHeader()).is_Some(), DdbMiddlewareConfig_Compile.__default.E(dafny.DafnySequence.asString("Decrypted scan result has no parsed header.")));
        if ((_1938_valueOrError3).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
          output = (_1938_valueOrError3).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanOutputTransformOutput>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanOutputTransformOutput._typeDescriptor());
          return output;
        }
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1939_valueOrError4 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default();
        _1939_valueOrError4 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), java.util.Objects.equals(java.math.BigInteger.valueOf(((((_1936_decrypted).dtor_parsedHeader()).dtor_value()).dtor_encryptedDataKeys()).length()), java.math.BigInteger.ONE), DdbMiddlewareConfig_Compile.__default.E(dafny.DafnySequence.asString("Scan result has more than one Encrypted Data Key")));
        if ((_1939_valueOrError4).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
          output = (_1939_valueOrError4).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanOutputTransformOutput>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanOutputTransformOutput._typeDescriptor());
          return output;
        }
        if (((((Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey)(java.lang.Object)(((((_1936_decrypted).dtor_parsedHeader()).dtor_value()).dtor_encryptedDataKeys()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_keyProviderInfo()).equals(_1930_keyIdUtf8)) {
          _1926_decryptedItems = dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>concatenate(_1926_decryptedItems, dafny.DafnySequence.of(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), (_1936_decrypted).dtor_plaintextItem()));
        }
      } else {
        _1926_decryptedItems = dafny.DafnySequence.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>concatenate(_1926_decryptedItems, dafny.DafnySequence.of(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), (_1936_decrypted).dtor_plaintextItem()));
      }
    }
    dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> _pat_let_tv28 = _1926_decryptedItems;
    Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput _1940_decryptedOutput;
    _1940_decryptedOutput = ((Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput, Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput>Let((input).dtor_sdkOutput(), boxed186 -> {
      Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput _pat_let93_0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput)(java.lang.Object)(boxed186));
      return ((Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput)(java.lang.Object)(dafny.Helpers.<Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput, Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput>Let(_pat_let93_0, boxed187 -> {
        Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput _1941_dt__update__tmp_h0 = ((Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput)(java.lang.Object)(boxed187));
        return ((Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>>, Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput>Let(Wrappers_Compile.Option.<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>>create_Some(_pat_let_tv28), boxed188 -> {
          Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>> _pat_let94_0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>>)(java.lang.Object)(boxed188));
          return ((Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput)(java.lang.Object)(dafny.Helpers.<Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>>, Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput>Let(_pat_let94_0, boxed189 -> {
            Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>> _1942_dt__update_hItems_h0 = ((Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>>)(java.lang.Object)(boxed189));
            return Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput.create(_1942_dt__update_hItems_h0, (_1941_dt__update__tmp_h0).dtor_Count(), (_1941_dt__update__tmp_h0).dtor_ScannedCount(), (_1941_dt__update__tmp_h0).dtor_LastEvaluatedKey(), (_1941_dt__update__tmp_h0).dtor_ConsumedCapacity());
          }
          )));
        }
        )));
      }
      )));
    }
    )));
    Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput _1943_finalResult;
    Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1944_valueOrError5 = Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput.Default());
    Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _out107;
    _out107 = DynamoDbMiddlewareSupport_Compile.__default.ScanOutputForBeacons(_1925_tableConfig, (input).dtor_originalInput(), _1940_decryptedOutput);
    _1944_valueOrError5 = _out107;
    if ((_1944_valueOrError5).IsFailure(Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
      output = (_1944_valueOrError5).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanOutputTransformOutput>PropagateFailure(Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanOutputTransformOutput._typeDescriptor());
      return output;
    }
    _1943_finalResult = (_1944_valueOrError5).Extract(Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
    output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanOutputTransformOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>create_Success(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ScanOutputTransformOutput.create(_1943_finalResult));
    return output;
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "ScanTransform_Compile._default";
  }
}
