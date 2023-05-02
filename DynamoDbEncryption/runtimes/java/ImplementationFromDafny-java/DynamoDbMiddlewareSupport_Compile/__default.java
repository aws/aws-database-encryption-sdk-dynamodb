// Class __default
// Dafny class __default compiled into Java
package DynamoDbMiddlewareSupport_Compile;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> IsWriteable(DdbMiddlewareConfig_Compile.TableConfig config, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item)
  {
    return (DynamoDBSupport_Compile.__default.IsWriteable(item)).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>MapFailure(dafny.TypeDescriptor.BOOLEAN, dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)(_1781_e_boxed0) -> {
      dafny.DafnySequence<? extends Character> _1781_e = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_1781_e_boxed0));
      return DdbMiddlewareConfig_Compile.__default.E(_1781_e);
    }));
  }
  public static Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> TestConditionExpression(DdbMiddlewareConfig_Compile.TableConfig config, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> expr, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> attrNames, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> attrValues)
  {
    return (DynamoDBSupport_Compile.__default.TestConditionExpression((((config).dtor_itemEncryptor()).config()).dtor_attributeActions(), expr, attrNames, attrValues)).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>MapFailure(dafny.TypeDescriptor.BOOLEAN, dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)(_1782_e_boxed0) -> {
      dafny.DafnySequence<? extends Character> _1782_e = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_1782_e_boxed0));
      return DdbMiddlewareConfig_Compile.__default.E(_1782_e);
    }));
  }
  public static Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> TestUpdateExpression(DdbMiddlewareConfig_Compile.TableConfig config, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> expr, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> attrNames, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> attrValues)
  {
    return (DynamoDBSupport_Compile.__default.TestUpdateExpression((((config).dtor_itemEncryptor()).config()).dtor_attributeActions(), expr, attrNames, attrValues)).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>MapFailure(dafny.TypeDescriptor.BOOLEAN, dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)(_1783_e_boxed0) -> {
      dafny.DafnySequence<? extends Character> _1783_e = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_1783_e_boxed0));
      return DdbMiddlewareConfig_Compile.__default.E(_1783_e);
    }));
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> AddSignedBeacons(DdbMiddlewareConfig_Compile.TableConfig config, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> empty());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1784_ret;
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out88;
    _out88 = DynamoDBSupport_Compile.__default.AddSignedBeacons((config).dtor_search(), item);
    _1784_ret = _out88;
    output = (_1784_ret).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>MapFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)(_1785_e_boxed0) -> {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error _1785_e = ((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error)(java.lang.Object)(_1785_e_boxed0));
      return Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error.create_AwsCryptographyDynamoDbEncryption(_1785_e);
    }));
    return output;
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> GetEncryptedBeacons(DdbMiddlewareConfig_Compile.TableConfig config, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item, DynamoDbEncryptionUtil_Compile.MaybeKeyId keyId)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> empty());
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1786_ret;
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out89;
    _out89 = DynamoDBSupport_Compile.__default.GetEncryptedBeacons((config).dtor_search(), item, keyId);
    _1786_ret = _out89;
    output = (_1786_ret).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>MapFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)(_1787_e_boxed0) -> {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error _1787_e = ((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error)(java.lang.Object)(_1787_e_boxed0));
      return Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error.create_AwsCryptographyDynamoDbEncryption(_1787_e);
    }));
    return output;
  }
  public static Wrappers_Compile.Result<DynamoDbEncryptionUtil_Compile.MaybeKeyId, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> GetBeaconKeyId(DdbMiddlewareConfig_Compile.TableConfig config, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> keyExpr, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> filterExpr, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>> values, Wrappers_Compile.Option<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>>> names)
  {
    return (DynamoDBSupport_Compile.__default.GetBeaconKeyId((config).dtor_search(), keyExpr, filterExpr, values, names)).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>MapFailure(DynamoDbEncryptionUtil_Compile.MaybeKeyId._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)(_1788_e_boxed0) -> {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error _1788_e = ((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error)(java.lang.Object)(_1788_e_boxed0));
      return Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error.create_AwsCryptographyDynamoDbEncryption(_1788_e);
    }));
  }
  public static Wrappers_Compile.Result<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> GetKeyIdFromHeader(DdbMiddlewareConfig_Compile.TableConfig config, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput output)
  {
    if ((((config).dtor_search()).is_Some()) && (((((((config).dtor_search()).dtor_value()).curr()).dtor_keySource()).dtor_keyLoc()).is_MultiLoc())) {
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1789_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), ((output).dtor_parsedHeader()).is_Some(), DdbMiddlewareConfig_Compile.__default.E(dafny.DafnySequence.asString("In multi-tenant mode, the parsed header is required.")));
      if ((_1789_valueOrError0).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
        return (_1789_valueOrError0).<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
      } else {
        dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey> _1790_keys = (((output).dtor_parsedHeader()).dtor_value()).dtor_encryptedDataKeys();
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1791_valueOrError1 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), java.util.Objects.equals(java.math.BigInteger.valueOf((_1790_keys).length()), java.math.BigInteger.ONE), DdbMiddlewareConfig_Compile.__default.E(dafny.DafnySequence.asString("Encrypt header has more than one Encrypted Data Key")));
        if ((_1791_valueOrError1).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
          return (_1791_valueOrError1).<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
        } else {
          Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1792_valueOrError2 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), ((((Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey)(java.lang.Object)((_1790_keys).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_keyProviderId()).equals(__default.HierarchicalKeyringId()), DdbMiddlewareConfig_Compile.__default.E(dafny.DafnySequence.asString("In multi-tenant mode, keyProviderId must be aws-kms-hierarchy")));
          if ((_1792_valueOrError2).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
            return (_1792_valueOrError2).<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
          } else {
            Wrappers_Compile.Result<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _1793_valueOrError3 = (UTF8.__default.Decode((((Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey)(java.lang.Object)((_1790_keys).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_keyProviderInfo())).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>MapFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)(_1794_e_boxed0) -> {
              dafny.DafnySequence<? extends Character> _1794_e = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_1794_e_boxed0));
              return DdbMiddlewareConfig_Compile.__default.E(_1794_e);
            }));
            if ((_1793_valueOrError3).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
              return (_1793_valueOrError3).<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>_typeDescriptor(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR)));
            } else {
              dafny.DafnySequence<? extends Character> _1795_keyId = (_1793_valueOrError3).Extract(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
              return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>create_Success(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(_1795_keyId));
            }
          }
        }
      }
    } else {
      return Wrappers_Compile.Result.<Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>create_Success(Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None());
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> RemoveBeacons(DdbMiddlewareConfig_Compile.TableConfig config, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item)
  {
    return (DynamoDBSupport_Compile.__default.RemoveBeacons((config).dtor_search(), item)).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>MapFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)(_1796_e_boxed0) -> {
      dafny.DafnySequence<? extends Character> _1796_e = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_1796_e_boxed0));
      return DdbMiddlewareConfig_Compile.__default.E(_1796_e);
    }));
  }
  public static Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> CreateTableInputForBeacons(DdbMiddlewareConfig_Compile.TableConfig config, Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput req)
  {
    return (DynamoDBSupport_Compile.__default.CreateTableInputForBeacons((config).dtor_search(), (((config).dtor_itemEncryptor()).config()).dtor_attributeActions(), req)).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>MapFailure(Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)(_1797_e_boxed0) -> {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error _1797_e = ((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error)(java.lang.Object)(_1797_e_boxed0));
      return Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error.create_AwsCryptographyDynamoDbEncryption(_1797_e);
    }));
  }
  public static Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> UpdateTableInputForBeacons(DdbMiddlewareConfig_Compile.TableConfig config, Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput req)
  {
    return (DynamoDBSupport_Compile.__default.UpdateTableInputForBeacons((config).dtor_search(), (((config).dtor_itemEncryptor()).config()).dtor_attributeActions(), req)).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>MapFailure(Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)(_1798_e_boxed0) -> {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error _1798_e = ((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error)(java.lang.Object)(_1798_e_boxed0));
      return Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error.create_AwsCryptographyDynamoDbEncryption(_1798_e);
    }));
  }
  public static Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.DescribeTableOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> DescribeTableOutputForBeacons(DdbMiddlewareConfig_Compile.TableConfig config, Dafny.Com.Amazonaws.Dynamodb.Types.DescribeTableOutput req)
  {
    return (DynamoDBSupport_Compile.__default.DescribeTableOutputForBeacons((config).dtor_search(), req)).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>MapFailure(Dafny.Com.Amazonaws.Dynamodb.Types.DescribeTableOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)(_1799_e_boxed0) -> {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error _1799_e = ((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error)(java.lang.Object)(_1799_e_boxed0));
      return Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error.create_AwsCryptographyDynamoDbEncryption(_1799_e);
    }));
  }
  public static Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> QueryInputForBeacons(DdbMiddlewareConfig_Compile.TableConfig config, Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput req)
  {
    Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = (Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)null;
    Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1800_ret;
    Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out90;
    _out90 = DynamoDBSupport_Compile.__default.QueryInputForBeacons((config).dtor_search(), req);
    _1800_ret = _out90;
    output = (_1800_ret).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>MapFailure(Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)(_1801_e_boxed0) -> {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error _1801_e = ((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error)(java.lang.Object)(_1801_e_boxed0));
      return Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error.create_AwsCryptographyDynamoDbEncryption(_1801_e);
    }));
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> QueryOutputForBeacons(DdbMiddlewareConfig_Compile.TableConfig config, Dafny.Com.Amazonaws.Dynamodb.Types.QueryInput req, Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput resp)
  {
    Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput.Default());
    Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1802_ret;
    Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out91;
    _out91 = DynamoDBSupport_Compile.__default.QueryOutputForBeacons((config).dtor_search(), req, resp);
    _1802_ret = _out91;
    output = (_1802_ret).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>MapFailure(Dafny.Com.Amazonaws.Dynamodb.Types.QueryOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)(_1803_e_boxed0) -> {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error _1803_e = ((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error)(java.lang.Object)(_1803_e_boxed0));
      return Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error.create_AwsCryptographyDynamoDbEncryption(_1803_e);
    }));
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> ScanInputForBeacons(DdbMiddlewareConfig_Compile.TableConfig config, Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput req)
  {
    Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = (Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)null;
    Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1804_ret;
    Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out92;
    _out92 = DynamoDBSupport_Compile.__default.ScanInputForBeacons((config).dtor_search(), req);
    _1804_ret = _out92;
    output = (_1804_ret).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>MapFailure(Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)(_1805_e_boxed0) -> {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error _1805_e = ((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error)(java.lang.Object)(_1805_e_boxed0));
      return Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error.create_AwsCryptographyDynamoDbEncryption(_1805_e);
    }));
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> ScanOutputForBeacons(DdbMiddlewareConfig_Compile.TableConfig config, Dafny.Com.Amazonaws.Dynamodb.Types.ScanInput req, Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput resp)
  {
    Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> output = Wrappers_Compile.Result.<Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput.Default());
    Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1806_ret;
    Wrappers_Compile.Result<Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out93;
    _out93 = DynamoDBSupport_Compile.__default.ScanOutputForBeacons((config).dtor_search(), req, resp);
    _1806_ret = _out93;
    output = (_1806_ret).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>MapFailure(Dafny.Com.Amazonaws.Dynamodb.Types.ScanOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)(_1807_e_boxed0) -> {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error _1807_e = ((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error)(java.lang.Object)(_1807_e_boxed0));
      return Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error.create_AwsCryptographyDynamoDbEncryption(_1807_e);
    }));
    return output;
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> HierarchicalKeyringId()
  {
    return UTF8.__default.EncodeAscii(dafny.DafnySequence.asString("aws-kms-hierarchy"));
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "DynamoDbMiddlewareSupport_Compile._default";
  }
}
