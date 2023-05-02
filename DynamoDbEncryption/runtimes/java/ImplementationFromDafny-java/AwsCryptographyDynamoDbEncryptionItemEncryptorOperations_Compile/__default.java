// Class __default
// Dafny class __default compiled into Java
package AwsCryptographyDynamoDbEncryptionItemEncryptorOperations_Compile;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static boolean AllowedUnauthenticated(Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>> unauthenticatedAttributes, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> unauthenticatedPrefix, dafny.DafnySequence<? extends Character> attr)
  {
    return ((((unauthenticatedAttributes).is_Some()) && (((unauthenticatedAttributes).dtor_value()).contains(attr))) || (((unauthenticatedPrefix).is_Some()) && (((unauthenticatedPrefix).dtor_value()).isPrefixOf(attr)))) || ((DynamoDbItemEncryptorUtil_Compile.__default.ReservedPrefix()).isPrefixOf(attr));
  }
  public static boolean ForwardCompatibleAttributeAction(dafny.DafnySequence<? extends Character> attribute, Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction action, Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>> unauthenticatedAttributes, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> unauthenticatedPrefix)
  {
    if (java.util.Objects.equals(action, Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction.create_DO__NOTHING())) {
      return __default.AllowedUnauthenticated(unauthenticatedAttributes, unauthenticatedPrefix, attribute);
    } else {
      return !(__default.AllowedUnauthenticated(unauthenticatedAttributes, unauthenticatedPrefix, attribute));
    }
  }
  public static dafny.DafnySequence<? extends Character> CryptoActionString(Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction action) {
    Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction _source35 = action;
    if (_source35.is_ENCRYPT__AND__SIGN()) {
      return dafny.DafnySequence.asString("ENCRYPT_AND_SIGN");
    } else if (_source35.is_SIGN__ONLY()) {
      return dafny.DafnySequence.asString("SIGN_ONLY");
    } else {
      return dafny.DafnySequence.asString("DO_NOTHING");
    }
  }
  public static dafny.DafnySequence<? extends Character> ExplainNotForwardCompatible(dafny.DafnySequence<? extends Character> attr, Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction action, Wrappers_Compile.Option<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>> unauthenticatedAttributes, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> unauthenticatedPrefix)
  {
    return dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Attribute "), attr), dafny.DafnySequence.asString(" is configured as ")), __default.CryptoActionString(action)), dafny.DafnySequence.asString(" but ")), ((java.util.Objects.equals(action, Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction.create_DO__NOTHING())) ? (dafny.DafnySequence.asString("it must also be in unauthenticatedAttributes or begin with the unauthenticatedPrefix.")) : (((((unauthenticatedAttributes).is_Some()) && (((unauthenticatedAttributes).dtor_value()).contains(attr))) ? (dafny.DafnySequence.asString("it is also in unauthenticatedAttributes.")) : (((((unauthenticatedPrefix).is_Some()) && (((unauthenticatedPrefix).dtor_value()).isPrefixOf(attr))) ? (dafny.DafnySequence.asString("it also begins with the unauthenticatedPrefix.")) : (dafny.DafnySequence.asString("it also begins with the reserved prefix."))))))));
  }
  public static boolean UnknownAttribute(Config config, dafny.DafnySequence<? extends Character> attr)
  {
    return (__default.InSignatureScope(config, attr)) && (!((config).dtor_attributeActions()).<dafny.DafnySequence<? extends Character>>contains(attr));
  }
  public static boolean IsSignOnly(Config config, dafny.DafnySequence<? extends Character> attr)
  {
    return (((config).dtor_attributeActions()).<dafny.DafnySequence<? extends Character>>contains(attr)) && (java.util.Objects.equals(((Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction)(java.lang.Object)(((config).dtor_attributeActions()).get(attr))), Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction.create_SIGN__ONLY()));
  }
  public static boolean InSignatureScope(Config config, dafny.DafnySequence<? extends Character> attr)
  {
    return !(__default.AllowedUnauthenticated((config).dtor_allowedUnauthenticatedAttributes(), (config).dtor_allowedUnauthenticatedAttributePrefix(), attr));
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> EncodeValue(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue val) {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>> _1613_valueOrError0 = DynamoToStruct_Compile.__default.TopLevelAttributeToBytes(val);
    if ((_1613_valueOrError0).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      return (_1613_valueOrError0).<dafny.DafnySequence<? extends java.lang.Byte>>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), UTF8.ValidUTF8Bytes._typeDescriptor());
    } else {
      dafny.DafnySequence<? extends java.lang.Byte> _1614_nValue = (_1613_valueOrError0).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
      dafny.DafnySequence<? extends Character> _1615_val64 = Base64_Compile.__default.Encode(_1614_nValue);
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends Character>>create_Success(UTF8.__default.EncodeAscii(_1615_val64));
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> MakeSortContext(Config config, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> item)
  {
    if (((config).dtor_sortKeyName()).is_None()) {
      return Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>create_Success(dafny.DafnyMap.fromElements());
    } else {
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1616_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), (item).<dafny.DafnySequence<? extends Character>>contains(((config).dtor_sortKeyName()).dtor_value()), __default.DDBError(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Sort key "), ((config).dtor_sortKeyName()).dtor_value()), dafny.DafnySequence.asString(" not found in Item to be encrypted or decrypted"))));
      if ((_1616_valueOrError0).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor())) {
        return (_1616_valueOrError0).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor())));
      } else {
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1617_valueOrError1 = __default.DDBEncode(((config).dtor_sortKeyName()).dtor_value());
        if ((_1617_valueOrError1).IsFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor())) {
          return (_1617_valueOrError1).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>PropagateFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor())));
        } else {
          dafny.DafnySequence<? extends java.lang.Byte> _1618_sortName = (_1617_valueOrError1).Extract(UTF8.ValidUTF8Bytes._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor());
          return Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>create_Success(dafny.DafnyMap.fromElements(new dafny.Tuple2(__default.SORT__NAME(), _1618_sortName)));
        }
      }
    }
  }
  public static dafny.DafnySequence<? extends Character> ECName(dafny.DafnySequence<? extends Character> k) {
    return dafny.DafnySequence.<Character>concatenate(DynamoDbEncryptionUtil_Compile.__default.DDBEC__ATTR__PREFIX(), k);
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> MakeEncryptionContext(Config config, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> item)
  {
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1619_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), (item).<dafny.DafnySequence<? extends Character>>contains((config).dtor_partitionKeyName()), __default.DDBError(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Partition key "), (config).dtor_partitionKeyName()), dafny.DafnySequence.asString(" not found in Item to be encrypted or decrypted"))));
    if ((_1619_valueOrError0).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor())) {
      return (_1619_valueOrError0).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(UTF8.ValidUTF8Bytes._typeDescriptor(), UTF8.ValidUTF8Bytes._typeDescriptor()));
    } else {
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1620_valueOrError1 = __default.DDBEncode((config).dtor_logicalTableName());
      if ((_1620_valueOrError1).IsFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor())) {
        return (_1620_valueOrError1).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>PropagateFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(UTF8.ValidUTF8Bytes._typeDescriptor(), UTF8.ValidUTF8Bytes._typeDescriptor()));
      } else {
        dafny.DafnySequence<? extends java.lang.Byte> _1621_logicalTableName = (_1620_valueOrError1).Extract(UTF8.ValidUTF8Bytes._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor());
        Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1622_valueOrError2 = __default.DDBEncode((config).dtor_partitionKeyName());
        if ((_1622_valueOrError2).IsFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor())) {
          return (_1622_valueOrError2).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>PropagateFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(UTF8.ValidUTF8Bytes._typeDescriptor(), UTF8.ValidUTF8Bytes._typeDescriptor()));
        } else {
          dafny.DafnySequence<? extends java.lang.Byte> _1623_partitionName = (_1622_valueOrError2).Extract(UTF8.ValidUTF8Bytes._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor());
          Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1624_valueOrError3 = __default.MakeSortContext(config, item);
          if ((_1624_valueOrError3).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(UTF8.ValidUTF8Bytes._typeDescriptor(), UTF8.ValidUTF8Bytes._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor())) {
            return (_1624_valueOrError3).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(UTF8.ValidUTF8Bytes._typeDescriptor(), UTF8.ValidUTF8Bytes._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(UTF8.ValidUTF8Bytes._typeDescriptor(), UTF8.ValidUTF8Bytes._typeDescriptor()));
          } else {
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _1625_sortContext = (_1624_valueOrError3).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(UTF8.ValidUTF8Bytes._typeDescriptor(), UTF8.ValidUTF8Bytes._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor());
            dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _1626_base = dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>>merge(dafny.DafnyMap.fromElements(new dafny.Tuple2(__default.TABLE__NAME(), _1621_logicalTableName), new dafny.Tuple2(__default.PARTITION__NAME(), _1623_partitionName)), _1625_sortContext);
            Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1627_valueOrError4 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, Boolean>)(_1628_item) -> dafny.Helpers.Quantifier((_1628_item).keySet().Elements(), true, ((_forall_var_16_boxed0) -> {
              dafny.DafnySequence<? extends Character> _forall_var_16 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_forall_var_16_boxed0));
              if (true) {
                dafny.DafnySequence<? extends Character> _1629_k = (dafny.DafnySequence<? extends Character>)_forall_var_16;
                return !((_1628_item).<dafny.DafnySequence<? extends Character>>contains(_1629_k)) || ((__default.DDBEncode(__default.ECName(_1629_k))).is_Success());
              } else {
                return true;
              }
            }))).apply(item), __default.DDBError(dafny.DafnySequence.asString("Invalid attribute names")));
            if ((_1627_valueOrError4).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor())) {
              return (_1627_valueOrError4).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(UTF8.ValidUTF8Bytes._typeDescriptor(), UTF8.ValidUTF8Bytes._typeDescriptor()));
            } else {
              dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _1630_signedMap = ((dafny.Function2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, Config, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>)(_1631_item, _1632_config) -> ((dafny.Function0<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>)(() -> {
                java.util.HashMap<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>> _coll33 = new java.util.HashMap<>();
                for (dafny.DafnySequence<? extends Character> _compr_34_boxed0 : (_1631_item).keySet().Elements()) {
                  dafny.DafnySequence<? extends Character> _compr_34 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_compr_34_boxed0));
                  if (true) {
                    dafny.DafnySequence<? extends Character> _1633_k = (dafny.DafnySequence<? extends Character>)_compr_34;
                    if (((_1631_item).<dafny.DafnySequence<? extends Character>>contains(_1633_k)) && (__default.IsSignOnly(_1632_config, _1633_k))) {
                      _coll33.put((__default.DDBEncode(__default.ECName(_1633_k))).dtor_value(),UTF8.__default.EncodeAscii(Base64_Compile.__default.Encode(dafny.DafnySequence.<java.lang.Byte>concatenate((((((Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData)(java.lang.Object)((_1631_item).get(_1633_k)))).dtor_content()).dtor_Terminal()).dtor_typeId(), (((((Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData)(java.lang.Object)((_1631_item).get(_1633_k)))).dtor_content()).dtor_Terminal()).dtor_value()))));
                    }
                  }
                }
                return new dafny.DafnyMap<dafny.DafnySequence<? extends java.lang.Byte>,dafny.DafnySequence<? extends java.lang.Byte>>(_coll33);
              })).apply()).apply(item, config);
              return Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>create_Success(dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>>merge(_1626_base, _1630_signedMap));
            }
          }
        }
      }
    }
  }
  public static Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error DDBError(dafny.DafnySequence<? extends Character> s) {
    return Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error.create_DynamoDbItemEncryptorException(s);
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> DDBEncode(dafny.DafnySequence<? extends Character> s) {
    return (UTF8.__default.Encode(s)).<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>MapFailure(UTF8.ValidUTF8Bytes._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>)(_1634_e_boxed0) -> {
      dafny.DafnySequence<? extends Character> _1634_e = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_1634_e_boxed0));
      return __default.DDBError(_1634_e);
    }));
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction, dafny.DafnySequence<? extends Character>> GetCryptoSchemaActionInner(Config config, dafny.DafnySequence<? extends Character> attr)
  {
    if (((config).dtor_attributeActions()).<dafny.DafnySequence<? extends Character>>contains(attr)) {
      return Wrappers_Compile.Result.<Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction, dafny.DafnySequence<? extends Character>>create_Success(((Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction)(java.lang.Object)(((config).dtor_attributeActions()).get(attr))));
    } else if (!(__default.InSignatureScope(config, attr))) {
      return Wrappers_Compile.Result.<Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction, dafny.DafnySequence<? extends Character>>create_Success(Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction.create_DO__NOTHING());
    } else {
      return Wrappers_Compile.Result.<Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction, dafny.DafnySequence<? extends Character>>create_Failure(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("No Crypto Action configured for attribute "), attr));
    }
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema, dafny.DafnySequence<? extends Character>> GetCryptoSchemaAction(Config config, dafny.DafnySequence<? extends Character> attr)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction, dafny.DafnySequence<? extends Character>> _1635_valueOrError0 = __default.GetCryptoSchemaActionInner(config, attr);
    if ((_1635_valueOrError0).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      return (_1635_valueOrError0).<Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema._typeDescriptor());
    } else {
      Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction _1636_action = (_1635_valueOrError0).Extract(Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR));
      Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchemaContent _1637_newElement = Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchemaContent.create_Action(_1636_action);
      return Wrappers_Compile.Result.<Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema, dafny.DafnySequence<? extends Character>>create_Success(Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema.create(_1637_newElement, Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateAction>>create_None()));
    }
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema, dafny.DafnySequence<? extends Character>> GetAuthenticateSchemaAction(Config config, dafny.DafnySequence<? extends Character> attr)
  {
    Wrappers_Compile.Outcome<dafny.DafnySequence<? extends Character>> _1638_valueOrError0 = Wrappers_Compile.__default.<dafny.DafnySequence<? extends Character>>Need(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), !(__default.UnknownAttribute(config, attr)), dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Attribute "), attr), dafny.DafnySequence.asString(" is not configured")));
    if ((_1638_valueOrError0).IsFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) {
      return (_1638_valueOrError0).<Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema>PropagateFailure(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema._typeDescriptor());
    } else if (__default.InSignatureScope(config, attr)) {
      return Wrappers_Compile.Result.<Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema, dafny.DafnySequence<? extends Character>>create_Success(__default.DoSign());
    } else {
      return Wrappers_Compile.Result.<Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema, dafny.DafnySequence<? extends Character>>create_Success(__default.DoNotSign());
    }
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> ConfigToCryptoSchema(Config config, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item)
  {
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema, dafny.DafnySequence<? extends Character>>> _1639_schema = ((dafny.Function2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Config, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema, dafny.DafnySequence<? extends Character>>>>)(_1640_item, _1641_config) -> ((dafny.Function0<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema, dafny.DafnySequence<? extends Character>>>>)(() -> {
      java.util.HashMap<dafny.DafnySequence<? extends Character>, Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema, dafny.DafnySequence<? extends Character>>> _coll34 = new java.util.HashMap<>();
      for (dafny.Tuple2<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _compr_35_boxed0 : ((_1640_item).<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>entrySet()).Elements()) {
        dafny.Tuple2<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _compr_35 = ((dafny.Tuple2<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>)(java.lang.Object)(_compr_35_boxed0));
        if (true) {
          dafny.Tuple2<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _1642_kv = (dafny.Tuple2<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>)_compr_35;
          if ((((_1640_item).<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>entrySet()).<dafny.Tuple2<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>contains(_1642_kv)) && (true)) {
            _coll34.put((_1642_kv).dtor__0(),__default.GetCryptoSchemaAction(_1641_config, (_1642_kv).dtor__0()));
          }
        }
      }
      return new dafny.DafnyMap<dafny.DafnySequence<? extends Character>,Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema, dafny.DafnySequence<? extends Character>>>(_coll34);
    })).apply()).apply(item, config);
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema>, dafny.DafnySequence<? extends Character>> _1643_actionMapRes = DynamoToStruct_Compile.__default.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema>SimplifyMapValue(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema._typeDescriptor(), _1639_schema);
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1644_valueOrError0 = DynamoToStruct_Compile.__default.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema>>MapError(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema._typeDescriptor()), _1643_actionMapRes);
    if ((_1644_valueOrError0).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
      return (_1644_valueOrError0).<Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema._typeDescriptor());
    } else {
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema> _1645_actionMap = (_1644_valueOrError0).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
      Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchemaContent _1646_schemaContent = Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchemaContent.create_SchemaMap(_1645_actionMap);
      Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema _1647_finalSchema = Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema.create(_1646_schemaContent, Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateAction>>create_None());
      return Wrappers_Compile.Result.<Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(_1647_finalSchema);
    }
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> ConfigToAuthenticateSchema(Config config, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> item)
  {
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema, dafny.DafnySequence<? extends Character>>> _1648_schema = ((dafny.Function2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Config, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema, dafny.DafnySequence<? extends Character>>>>)(_1649_item, _1650_config) -> ((dafny.Function0<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema, dafny.DafnySequence<? extends Character>>>>)(() -> {
      java.util.HashMap<dafny.DafnySequence<? extends Character>, Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema, dafny.DafnySequence<? extends Character>>> _coll35 = new java.util.HashMap<>();
      for (dafny.Tuple2<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _compr_36_boxed0 : ((_1649_item).<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>entrySet()).Elements()) {
        dafny.Tuple2<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _compr_36 = ((dafny.Tuple2<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>)(java.lang.Object)(_compr_36_boxed0));
        if (true) {
          dafny.Tuple2<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _1651_kv = (dafny.Tuple2<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>)_compr_36;
          if ((((_1649_item).<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>entrySet()).<dafny.Tuple2<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>>contains(_1651_kv)) && (true)) {
            _coll35.put((_1651_kv).dtor__0(),__default.GetAuthenticateSchemaAction(_1650_config, (_1651_kv).dtor__0()));
          }
        }
      }
      return new dafny.DafnyMap<dafny.DafnySequence<? extends Character>,Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema, dafny.DafnySequence<? extends Character>>>(_coll35);
    })).apply()).apply(item, config);
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1652_valueOrError0 = DynamoToStruct_Compile.__default.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema>>MapError(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema._typeDescriptor()), DynamoToStruct_Compile.__default.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema>SimplifyMapValue(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema._typeDescriptor(), _1648_schema));
    if ((_1652_valueOrError0).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
      return (_1652_valueOrError0).<Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema._typeDescriptor());
    } else {
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema> _1653_authMap = (_1652_valueOrError0).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
      Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchemaContent _1654_schemaContent = Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchemaContent.create_SchemaMap(_1653_authMap);
      Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema _1655_finalSchema = Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema.create(_1654_schemaContent, Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateAction>>create_None());
      return Wrappers_Compile.Result.<Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(_1655_finalSchema);
    }
  }
  public static boolean IsPlaintextItem(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> ddbItem) {
    return (!((ddbItem).keySet()).<dafny.DafnySequence<? extends Character>>contains(StructuredEncryptionUtil_Compile.__default.HeaderField())) && (!((ddbItem).keySet()).<dafny.DafnySequence<? extends Character>>contains(StructuredEncryptionUtil_Compile.__default.FooterField()));
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction>, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> ConvertCryptoSchemaToAttributeActions(Config config, Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema schema)
  {
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1656_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), ((dafny.Function2<Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema, Config, Boolean>)(_1657_schema, _1658_config) -> dafny.Helpers.Quantifier((((_1657_schema).dtor_content()).dtor_SchemaMap()).keySet().Elements(), true, ((_forall_var_17_boxed0) -> {
      dafny.DafnySequence<? extends Character> _forall_var_17 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_forall_var_17_boxed0));
      if (true) {
        dafny.DafnySequence<? extends Character> _1659_k = (dafny.DafnySequence<? extends Character>)_forall_var_17;
        if (Dafny.Com.Amazonaws.Dynamodb.Types.__default.IsValid__AttributeName(_1659_k)) {
          return !((((_1657_schema).dtor_content()).dtor_SchemaMap()).<dafny.DafnySequence<? extends Character>>contains(_1659_k)) || (__default.InSignatureScope(_1658_config, _1659_k));
        } else {
          return true;
        }
      } else {
        return true;
      }
    }))).apply(schema, config), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error.create_DynamoDbItemEncryptorException(dafny.DafnySequence.asString("Recieved unexpected Crypto Schema: mismatch with signature scope")));
    if ((_1656_valueOrError0).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor())) {
      return (_1656_valueOrError0).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction>>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction._typeDescriptor()));
    } else {
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1660_valueOrError1 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema, Boolean>)(_1661_schema) -> dafny.Helpers.Quantifier((((_1661_schema).dtor_content()).dtor_SchemaMap()).keySet().Elements(), true, ((_forall_var_18_boxed0) -> {
        dafny.DafnySequence<? extends Character> _forall_var_18 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_forall_var_18_boxed0));
        if (true) {
          dafny.DafnySequence<? extends Character> _1662_k = (dafny.DafnySequence<? extends Character>)_forall_var_18;
          return !((((_1661_schema).dtor_content()).dtor_SchemaMap()).<dafny.DafnySequence<? extends Character>>contains(_1662_k)) || (Dafny.Com.Amazonaws.Dynamodb.Types.__default.IsValid__AttributeName(_1662_k));
        } else {
          return true;
        }
      }))).apply(schema), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error.create_DynamoDbItemEncryptorException(dafny.DafnySequence.asString("Recieved unexpected Crypto Schema: Invalid attribute names")));
      if ((_1660_valueOrError1).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor())) {
        return (_1660_valueOrError1).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction>>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction._typeDescriptor()));
      } else {
        return Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction>, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>create_Success(((java.util.function.Function<Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction>>)(_1663_schema) -> ((dafny.Function0<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction>>)(() -> {
  java.util.HashMap<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> _coll36 = new java.util.HashMap<>();
  for (dafny.DafnySequence<? extends Character> _compr_37_boxed0 : ((((_1663_schema).dtor_content()).dtor_SchemaMap()).keySet()).Elements()) {
    dafny.DafnySequence<? extends Character> _compr_37 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_compr_37_boxed0));
    if (true) {
      dafny.DafnySequence<? extends Character> _1664_k = (dafny.DafnySequence<? extends Character>)_compr_37;
      if (Dafny.Com.Amazonaws.Dynamodb.Types.__default.IsValid__AttributeName(_1664_k)) {
        if ((((((_1663_schema).dtor_content()).dtor_SchemaMap()).keySet()).<dafny.DafnySequence<? extends Character>>contains(_1664_k)) && (true)) {
          _coll36.put(_1664_k,((((Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema)(java.lang.Object)((((_1663_schema).dtor_content()).dtor_SchemaMap()).get(_1664_k)))).dtor_content()).dtor_Action());
        }
      }
    }
  }
  return new dafny.DafnyMap<dafny.DafnySequence<? extends Character>,Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction>(_coll36);
})).apply()).apply(schema));
      }
    }
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> EncryptItem(Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput.Default());
    if(true) {
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1665_valueOrError0 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>Default();
      _1665_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), (((input).dtor_plaintextItem()).<dafny.DafnySequence<? extends Character>>contains((config).dtor_partitionKeyName())) && ((((config).dtor_sortKeyName()).is_None()) || (((input).dtor_plaintextItem()).<dafny.DafnySequence<? extends Character>>contains(((config).dtor_sortKeyName()).dtor_value()))), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error.create_DynamoDbItemEncryptorException(dafny.DafnySequence.asString("Configuration missmatch partition or sort key does not exist in item.")));
      if ((_1665_valueOrError0).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor())) {
        output = (_1665_valueOrError0).<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput._typeDescriptor());
        return output;
      }
      if ((((config).dtor_internalLegacyConfig()).is_Some()) && (((((config).dtor_internalLegacyConfig()).dtor_value()).policy()).is_REQUIRE__ENCRYPT__ALLOW__DECRYPT())) {
        Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput _1666_encryptItemOutput;
        Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1667_valueOrError1 = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput.Default());
        Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _out75;
        _out75 = (((config).dtor_internalLegacyConfig()).dtor_value()).EncryptItem(input);
        _1667_valueOrError1 = _out75;
        if ((_1667_valueOrError1).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor())) {
          output = (_1667_valueOrError1).<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput._typeDescriptor());
          return output;
        }
        _1666_encryptItemOutput = (_1667_valueOrError1).Extract(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor());
        output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>create_Success(_1666_encryptItemOutput);
        return output;
      }
      if (((config).dtor_plaintextPolicy()).is_REQUIRE__WRITE__ALLOW__READ()) {
        Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput _1668_passthroughOutput;
        _1668_passthroughOutput = Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput.create((input).dtor_plaintextItem(), Wrappers_Compile.Option.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.ParsedHeader>create_None());
        output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>create_Success(_1668_passthroughOutput);
        return output;
      }
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> _1669_plaintextStructure;
      Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1670_valueOrError2 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> empty());
      _1670_valueOrError2 = (DynamoToStruct_Compile.__default.ItemToStructured((input).dtor_plaintextItem())).<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>MapFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), DynamoToStruct_Compile.StructuredDataTerminalType._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>)(_1671_e_boxed0) -> {
        Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error _1671_e = ((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error)(java.lang.Object)(_1671_e_boxed0));
        return Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error.create_AwsCryptographyDynamoDbEncryption(_1671_e);
      }));
      if ((_1670_valueOrError2).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), DynamoToStruct_Compile.StructuredDataTerminalType._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor())) {
        output = (_1670_valueOrError2).<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), DynamoToStruct_Compile.StructuredDataTerminalType._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput._typeDescriptor());
        return output;
      }
      _1669_plaintextStructure = (_1670_valueOrError2).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), DynamoToStruct_Compile.StructuredDataTerminalType._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor());
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _1672_context;
      Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1673_valueOrError3 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>,dafny.DafnySequence<? extends java.lang.Byte>> empty());
      _1673_valueOrError3 = __default.MakeEncryptionContext(config, _1669_plaintextStructure);
      if ((_1673_valueOrError3).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(UTF8.ValidUTF8Bytes._typeDescriptor(), UTF8.ValidUTF8Bytes._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor())) {
        output = (_1673_valueOrError3).<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(UTF8.ValidUTF8Bytes._typeDescriptor(), UTF8.ValidUTF8Bytes._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput._typeDescriptor());
        return output;
      }
      _1672_context = (_1673_valueOrError3).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(UTF8.ValidUTF8Bytes._typeDescriptor(), UTF8.ValidUTF8Bytes._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor());
      Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema _1674_cryptoSchema;
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1675_valueOrError4 = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>Default(Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema.Default());
      _1675_valueOrError4 = (__default.ConfigToCryptoSchema(config, (input).dtor_plaintextItem())).<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>MapFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>)(_1676_e_boxed0) -> {
        Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error _1676_e = ((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error)(java.lang.Object)(_1676_e_boxed0));
        return Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error.create_AwsCryptographyDynamoDbEncryption(_1676_e);
      }));
      if ((_1675_valueOrError4).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor())) {
        output = (_1675_valueOrError4).<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput._typeDescriptor());
        return output;
      }
      _1674_cryptoSchema = (_1675_valueOrError4).Extract(Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor());
      Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData _1677_wrappedStruct;
      _1677_wrappedStruct = Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData.create(Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredDataContent.create_DataMap(_1669_plaintextStructure), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredDataTerminal>>create_None());
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager, Dafny.Aws.Cryptography.MaterialProviders.Types.Error> _1678_reqCMMR;
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager, Dafny.Aws.Cryptography.MaterialProviders.Types.Error> _out76;
      _out76 = ((config).dtor_cmpClient()).CreateExpectedEncryptionContextCMM(Dafny.Aws.Cryptography.MaterialProviders.Types.CreateExpectedEncryptionContextCMMInput.create(Wrappers_Compile.Option.<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager>create_Some((config).dtor_cmm()), Wrappers_Compile.Option.<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring>create_None(), Sets.__default.<java.lang.Byte>SetToOrderedSequence2(StandardLibrary_mUInt_Compile.uint8._typeDescriptor(), (_1672_context).keySet(), DynamoDbItemEncryptorUtil_Compile.__default::ByteLess)));
      _1678_reqCMMR = _out76;
      Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager _1679_reqCMM;
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1680_valueOrError5 = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>)null;
      _1680_valueOrError5 = (_1678_reqCMMR).<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>MapFailure(Dafny.Aws.Cryptography.MaterialProviders.Types._Companion_ICryptographicMaterialsManager._typeDescriptor(), Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.MaterialProviders.Types.Error, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>)(_1681_e_boxed0) -> {
        Dafny.Aws.Cryptography.MaterialProviders.Types.Error _1681_e = ((Dafny.Aws.Cryptography.MaterialProviders.Types.Error)(java.lang.Object)(_1681_e_boxed0));
        return Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error.create_AwsCryptographyMaterialProviders(_1681_e);
      }));
      if ((_1680_valueOrError5).IsFailure(Dafny.Aws.Cryptography.MaterialProviders.Types._Companion_ICryptographicMaterialsManager._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor())) {
        output = (_1680_valueOrError5).<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput>PropagateFailure(Dafny.Aws.Cryptography.MaterialProviders.Types._Companion_ICryptographicMaterialsManager._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput._typeDescriptor());
        return output;
      }
      _1679_reqCMM = (_1680_valueOrError5).Extract(Dafny.Aws.Cryptography.MaterialProviders.Types._Companion_ICryptographicMaterialsManager._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor());
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _1682_encryptRes;
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _out77;
      _out77 = ((config).dtor_structuredEncryption()).EncryptStructure(Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureInput.create((config).dtor_logicalTableName(), _1677_wrappedStruct, _1674_cryptoSchema, _1679_reqCMM, (config).dtor_algorithmSuiteId(), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>create_Some(_1672_context)));
      _1682_encryptRes = _out77;
      Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput _1683_encryptVal;
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1684_valueOrError6 = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>)null;
      _1684_valueOrError6 = (_1682_encryptRes).<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>MapFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>)(_1685_e_boxed0) -> {
        Dafny.Aws.Cryptography.StructuredEncryption.Types.Error _1685_e = ((Dafny.Aws.Cryptography.StructuredEncryption.Types.Error)(java.lang.Object)(_1685_e_boxed0));
        return Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error.create_AwsCryptographyDynamoDbEncryption(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error.create_AwsCryptographyStructuredEncryption(_1685_e));
      }));
      if ((_1684_valueOrError6).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor())) {
        output = (_1684_valueOrError6).<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput._typeDescriptor());
        return output;
      }
      _1683_encryptVal = (_1684_valueOrError6).Extract(Dafny.Aws.Cryptography.StructuredEncryption.Types.EncryptStructureOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor());
      Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData _1686_encryptedData;
      _1686_encryptedData = (_1683_encryptVal).dtor_encryptedStructure();
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _1687_ddbKey;
      Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1688_valueOrError7 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> empty());
      _1688_valueOrError7 = (DynamoToStruct_Compile.__default.StructuredToItem(((_1686_encryptedData).dtor_content()).dtor_DataMap())).<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>MapFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>)(_1689_e_boxed0) -> {
        Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error _1689_e = ((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error)(java.lang.Object)(_1689_e_boxed0));
        return Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error.create_AwsCryptographyDynamoDbEncryption(_1689_e);
      }));
      if ((_1688_valueOrError7).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor())) {
        output = (_1688_valueOrError7).<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput._typeDescriptor());
        return output;
      }
      _1687_ddbKey = (_1688_valueOrError7).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor());
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> _1690_parsedActions;
      Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction>, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1691_valueOrError8 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction>, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> empty());
      _1691_valueOrError8 = __default.ConvertCryptoSchemaToAttributeActions(config, ((_1683_encryptVal).dtor_parsedHeader()).dtor_cryptoSchema());
      if ((_1691_valueOrError8).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor())) {
        output = (_1691_valueOrError8).<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput._typeDescriptor());
        return output;
      }
      _1690_parsedActions = (_1691_valueOrError8).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor());
      Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.ParsedHeader _1692_parsedHeader;
      _1692_parsedHeader = Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.ParsedHeader.create(_1690_parsedActions, ((_1683_encryptVal).dtor_parsedHeader()).dtor_algorithmSuiteId(), ((_1683_encryptVal).dtor_parsedHeader()).dtor_encryptedDataKeys(), ((_1683_encryptVal).dtor_parsedHeader()).dtor_storedEncryptionContext());
      output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>create_Success(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput.create(_1687_ddbKey, Wrappers_Compile.Option.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.ParsedHeader>create_Some(_1692_parsedHeader)));
    }
    return output;
  }
  public static Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> DecryptItem(Config config, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemInput input)
  {
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput.Default());
    if(true) {
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1693_valueOrError0 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>Default();
      _1693_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), (((input).dtor_encryptedItem()).<dafny.DafnySequence<? extends Character>>contains((config).dtor_partitionKeyName())) && ((((config).dtor_sortKeyName()).is_None()) || (((input).dtor_encryptedItem()).<dafny.DafnySequence<? extends Character>>contains(((config).dtor_sortKeyName()).dtor_value()))), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error.create_DynamoDbItemEncryptorException(dafny.DafnySequence.asString("Configuration missmatch partition or sort key does not exist in item.")));
      if ((_1693_valueOrError0).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor())) {
        output = (_1693_valueOrError0).<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput._typeDescriptor());
        return output;
      }
      if ((((config).dtor_internalLegacyConfig()).is_Some()) && ((((config).dtor_internalLegacyConfig()).dtor_value()).IsLegacyInput(input))) {
        Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput _1694_decryptItemOutput;
        Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1695_valueOrError1 = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>Default(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput.Default());
        Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _out78;
        _out78 = (((config).dtor_internalLegacyConfig()).dtor_value()).DecryptItem(input);
        _1695_valueOrError1 = _out78;
        if ((_1695_valueOrError1).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor())) {
          output = (_1695_valueOrError1).<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput._typeDescriptor());
          return output;
        }
        _1694_decryptItemOutput = (_1695_valueOrError1).Extract(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor());
        output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>create_Success(_1694_decryptItemOutput);
        return output;
      }
      if (((((config).dtor_plaintextPolicy()).is_REQUIRE__WRITE__ALLOW__READ()) || (((config).dtor_plaintextPolicy()).is_FORBID__WRITE__ALLOW__READ())) && (__default.IsPlaintextItem((input).dtor_encryptedItem()))) {
        Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput _1696_passthroughOutput;
        _1696_passthroughOutput = Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput.create((input).dtor_encryptedItem(), Wrappers_Compile.Option.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.ParsedHeader>create_None());
        output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>create_Success(_1696_passthroughOutput);
        return output;
      }
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1697_valueOrError2 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>Default();
      _1697_valueOrError2 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), !(__default.IsPlaintextItem((input).dtor_encryptedItem())), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error.create_DynamoDbItemEncryptorException(dafny.DafnySequence.asString("Encrypted item missing expected header and footer attributes")));
      if ((_1697_valueOrError2).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor())) {
        output = (_1697_valueOrError2).<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput._typeDescriptor());
        return output;
      }
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> _1698_encryptedStructure;
      Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1699_valueOrError3 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> empty());
      _1699_valueOrError3 = (DynamoToStruct_Compile.__default.ItemToStructured((input).dtor_encryptedItem())).<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>MapFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), DynamoToStruct_Compile.StructuredDataTerminalType._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>)(_1700_e_boxed0) -> {
        Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error _1700_e = ((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error)(java.lang.Object)(_1700_e_boxed0));
        return Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error.create_AwsCryptographyDynamoDbEncryption(_1700_e);
      }));
      if ((_1699_valueOrError3).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), DynamoToStruct_Compile.StructuredDataTerminalType._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor())) {
        output = (_1699_valueOrError3).<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), DynamoToStruct_Compile.StructuredDataTerminalType._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput._typeDescriptor());
        return output;
      }
      _1698_encryptedStructure = (_1699_valueOrError3).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), DynamoToStruct_Compile.StructuredDataTerminalType._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor());
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _1701_context;
      Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1702_valueOrError4 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>,dafny.DafnySequence<? extends java.lang.Byte>> empty());
      _1702_valueOrError4 = __default.MakeEncryptionContext(config, _1698_encryptedStructure);
      if ((_1702_valueOrError4).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(UTF8.ValidUTF8Bytes._typeDescriptor(), UTF8.ValidUTF8Bytes._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor())) {
        output = (_1702_valueOrError4).<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(UTF8.ValidUTF8Bytes._typeDescriptor(), UTF8.ValidUTF8Bytes._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput._typeDescriptor());
        return output;
      }
      _1701_context = (_1702_valueOrError4).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>, dafny.DafnySequence<? extends java.lang.Byte>>_typeDescriptor(UTF8.ValidUTF8Bytes._typeDescriptor(), UTF8.ValidUTF8Bytes._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor());
      Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema _1703_authenticateSchema;
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1704_valueOrError5 = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>Default(Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema.Default());
      _1704_valueOrError5 = (__default.ConfigToAuthenticateSchema(config, (input).dtor_encryptedItem())).<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>MapFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>)(_1705_e_boxed0) -> {
        Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error _1705_e = ((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error)(java.lang.Object)(_1705_e_boxed0));
        return Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error.create_AwsCryptographyDynamoDbEncryption(_1705_e);
      }));
      if ((_1704_valueOrError5).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor())) {
        output = (_1704_valueOrError5).<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput._typeDescriptor());
        return output;
      }
      _1703_authenticateSchema = (_1704_valueOrError5).Extract(Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor());
      Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData _1706_wrappedStruct;
      _1706_wrappedStruct = Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData.create(Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredDataContent.create_DataMap(_1698_encryptedStructure), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredDataTerminal>>create_None());
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager, Dafny.Aws.Cryptography.MaterialProviders.Types.Error> _1707_reqCMMR;
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager, Dafny.Aws.Cryptography.MaterialProviders.Types.Error> _out79;
      _out79 = ((config).dtor_cmpClient()).CreateExpectedEncryptionContextCMM(Dafny.Aws.Cryptography.MaterialProviders.Types.CreateExpectedEncryptionContextCMMInput.create(Wrappers_Compile.Option.<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager>create_Some((config).dtor_cmm()), Wrappers_Compile.Option.<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring>create_None(), Sets.__default.<java.lang.Byte>SetToOrderedSequence2(StandardLibrary_mUInt_Compile.uint8._typeDescriptor(), (_1701_context).keySet(), DynamoDbItemEncryptorUtil_Compile.__default::ByteLess)));
      _1707_reqCMMR = _out79;
      Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager _1708_reqCMM;
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1709_valueOrError6 = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>)null;
      _1709_valueOrError6 = (_1707_reqCMMR).<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>MapFailure(Dafny.Aws.Cryptography.MaterialProviders.Types._Companion_ICryptographicMaterialsManager._typeDescriptor(), Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.MaterialProviders.Types.Error, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>)(_1710_e_boxed0) -> {
        Dafny.Aws.Cryptography.MaterialProviders.Types.Error _1710_e = ((Dafny.Aws.Cryptography.MaterialProviders.Types.Error)(java.lang.Object)(_1710_e_boxed0));
        return Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error.create_AwsCryptographyMaterialProviders(_1710_e);
      }));
      if ((_1709_valueOrError6).IsFailure(Dafny.Aws.Cryptography.MaterialProviders.Types._Companion_ICryptographicMaterialsManager._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor())) {
        output = (_1709_valueOrError6).<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput>PropagateFailure(Dafny.Aws.Cryptography.MaterialProviders.Types._Companion_ICryptographicMaterialsManager._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput._typeDescriptor());
        return output;
      }
      _1708_reqCMM = (_1709_valueOrError6).Extract(Dafny.Aws.Cryptography.MaterialProviders.Types._Companion_ICryptographicMaterialsManager._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor());
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _1711_decryptRes;
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _out80;
      _out80 = ((config).dtor_structuredEncryption()).DecryptStructure(Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureInput.create((config).dtor_logicalTableName(), _1706_wrappedStruct, _1703_authenticateSchema, _1708_reqCMM, Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>>>create_Some(_1701_context)));
      _1711_decryptRes = _out80;
      Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput _1712_decryptVal;
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1713_valueOrError7 = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>)null;
      _1713_valueOrError7 = (_1711_decryptRes).<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>MapFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>)(_1714_e_boxed0) -> {
        Dafny.Aws.Cryptography.StructuredEncryption.Types.Error _1714_e = ((Dafny.Aws.Cryptography.StructuredEncryption.Types.Error)(java.lang.Object)(_1714_e_boxed0));
        return Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error.create_AwsCryptographyDynamoDbEncryption(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error.create_AwsCryptographyStructuredEncryption(_1714_e));
      }));
      if ((_1713_valueOrError7).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor())) {
        output = (_1713_valueOrError7).<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput._typeDescriptor());
        return output;
      }
      _1712_decryptVal = (_1713_valueOrError7).Extract(Dafny.Aws.Cryptography.StructuredEncryption.Types.DecryptStructureOutput._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor());
      Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData _1715_decryptedData;
      _1715_decryptedData = (_1712_decryptVal).dtor_plaintextStructure();
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _1716_ddbItem;
      Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1717_valueOrError8 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> empty());
      _1717_valueOrError8 = (DynamoToStruct_Compile.__default.StructuredToItem(((_1715_decryptedData).dtor_content()).dtor_DataMap())).<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>MapFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>)(_1718_e_boxed0) -> {
        Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error _1718_e = ((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error)(java.lang.Object)(_1718_e_boxed0));
        return Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error.create_AwsCryptographyDynamoDbEncryption(_1718_e);
      }));
      if ((_1717_valueOrError8).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor())) {
        output = (_1717_valueOrError8).<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput._typeDescriptor());
        return output;
      }
      _1716_ddbItem = (_1717_valueOrError8).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor());
      Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema _1719_schemaToConvert;
      _1719_schemaToConvert = ((_1712_decryptVal).dtor_parsedHeader()).dtor_cryptoSchema();
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> _1720_parsedAuthActions;
      Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction>, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1721_valueOrError9 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction>, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> empty());
      _1721_valueOrError9 = __default.ConvertCryptoSchemaToAttributeActions(config, _1719_schemaToConvert);
      if ((_1721_valueOrError9).IsFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor())) {
        output = (_1721_valueOrError9).<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput>PropagateFailure(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput._typeDescriptor());
        return output;
      }
      _1720_parsedAuthActions = (_1721_valueOrError9).Extract(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction>_typeDescriptor(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeName._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor());
      Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.ParsedHeader _1722_parsedHeader;
      _1722_parsedHeader = Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.ParsedHeader.create(_1720_parsedAuthActions, ((_1712_decryptVal).dtor_parsedHeader()).dtor_algorithmSuiteId(), ((_1712_decryptVal).dtor_parsedHeader()).dtor_encryptedDataKeys(), ((_1712_decryptVal).dtor_parsedHeader()).dtor_storedEncryptionContext());
      output = Wrappers_Compile.Result.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>create_Success(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput.create(_1716_ddbItem, Wrappers_Compile.Option.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.ParsedHeader>create_Some(_1722_parsedHeader)));
    }
    return output;
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> SORT__NAME()
  {
    return UTF8.__default.EncodeAscii(dafny.DafnySequence.asString("aws-crypto-sort-name"));
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> TABLE__NAME()
  {
    return UTF8.__default.EncodeAscii(dafny.DafnySequence.asString("aws-crypto-table-name"));
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> PARTITION__NAME()
  {
    return UTF8.__default.EncodeAscii(dafny.DafnySequence.asString("aws-crypto-partition-name"));
  }
  public static Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema DoNotSign()
  {
    return Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema.create(Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchemaContent.create_Action(Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateAction.create_DO__NOT__SIGN()), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateAction>>create_None());
  }
  public static Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema DoSign()
  {
    return Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema.create(Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchemaContent.create_Action(Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateAction.create_SIGN()), Wrappers_Compile.Option.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateAction>>create_None());
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "AwsCryptographyDynamoDbEncryptionItemEncryptorOperations_Compile._default";
  }
}
