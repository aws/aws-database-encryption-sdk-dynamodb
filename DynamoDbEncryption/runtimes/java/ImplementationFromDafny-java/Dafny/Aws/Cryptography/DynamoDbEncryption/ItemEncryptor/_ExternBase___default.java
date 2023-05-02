// Class _ExternBase___default
// Dafny class __default compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor;

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

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class _ExternBase___default {
  public _ExternBase___default() {
  }
  public static Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DynamoDbItemEncryptorConfig DefaultDynamoDbItemEncryptorConfig() {
    return Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DynamoDbItemEncryptorConfig.create(dafny.DafnySequence.asString("foo"), dafny.DafnySequence.asString("bar"), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(), dafny.DafnyMap.fromElements(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>>create_None(), Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None(), Wrappers_Compile.Option.<Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId>create_None(), Wrappers_Compile.Option.<Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring>create_None(), Wrappers_Compile.Option.<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager>create_None(), Wrappers_Compile.Option.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.LegacyConfig>create_None(), Wrappers_Compile.Option.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.PlaintextPolicy>create_None());
  }
  public static boolean UnreservedPrefix(dafny.DafnySequence<? extends Character> attr) {
    return !((DynamoDbItemEncryptorUtil_Compile.__default.ReservedPrefix()).isPrefixOf(attr));
  }
  public static Wrappers_Compile.Result<DynamoDbItemEncryptorClient, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> DynamoDbItemEncryptor(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DynamoDbItemEncryptorConfig config)
  {
    Wrappers_Compile.Result<DynamoDbItemEncryptorClient, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> res = (Wrappers_Compile.Result<DynamoDbItemEncryptorClient, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>)null;
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1723_valueOrError0 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>Default();
    _1723_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), (((config).dtor_keyring()).is_None()) || (((config).dtor_cmm()).is_None()), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error.create_DynamoDbItemEncryptorException(dafny.DafnySequence.asString("Cannot provide both a keyring and a CMM")));
    if ((_1723_valueOrError0).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor())) {
      res = (_1723_valueOrError0).<DynamoDbItemEncryptorClient>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), DynamoDbItemEncryptorClient._typeDescriptor());
      return res;
    }
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1724_valueOrError1 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>Default();
    _1724_valueOrError1 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), (((config).dtor_keyring()).is_Some()) || (((config).dtor_cmm()).is_Some()), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error.create_DynamoDbItemEncryptorException(dafny.DafnySequence.asString("Must provide either a keyring or a CMM")));
    if ((_1724_valueOrError1).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor())) {
      res = (_1724_valueOrError1).<DynamoDbItemEncryptorClient>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), DynamoDbItemEncryptorClient._typeDescriptor());
      return res;
    }
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1725_valueOrError2 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>Default();
    _1725_valueOrError2 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), (((config).dtor_attributeActions()).<dafny.DafnySequence<? extends Character>>contains((config).dtor_partitionKeyName())) && (java.util.Objects.equals(((Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction)(java.lang.Object)(((config).dtor_attributeActions()).get((config).dtor_partitionKeyName()))), Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction.create_SIGN__ONLY())), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error.create_DynamoDbItemEncryptorException(dafny.DafnySequence.asString("Partition key attribute action MUST be SIGN_ONLY")));
    if ((_1725_valueOrError2).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor())) {
      res = (_1725_valueOrError2).<DynamoDbItemEncryptorClient>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), DynamoDbItemEncryptorClient._typeDescriptor());
      return res;
    }
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1726_valueOrError3 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>Default();
    _1726_valueOrError3 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), !(((config).dtor_sortKeyName()).is_Some()) || ((((config).dtor_attributeActions()).<dafny.DafnySequence<? extends Character>>contains(((config).dtor_sortKeyName()).dtor_value())) && (java.util.Objects.equals(((Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction)(java.lang.Object)(((config).dtor_attributeActions()).get(((config).dtor_sortKeyName()).dtor_value()))), Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction.create_SIGN__ONLY()))), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error.create_DynamoDbItemEncryptorException(dafny.DafnySequence.asString("Sort key attribute action MUST be SIGN_ONLY")));
    if ((_1726_valueOrError3).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor())) {
      res = (_1726_valueOrError3).<DynamoDbItemEncryptorClient>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), DynamoDbItemEncryptorClient._typeDescriptor());
      return res;
    }
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> _1727_attributeActions_k;
    _1727_attributeActions_k = (config).dtor_attributeActions();
    while (!((_1727_attributeActions_k).keySet()).equals(dafny.DafnySet.<dafny.DafnySequence<? extends Character>> empty())) {
      dafny.DafnySequence<? extends Character> _1728_attribute;
      goto__ASSIGN_SUCH_THAT_0: {
        for (dafny.DafnySequence<? extends Character> _assign_such_that_0_boxed0 : (_1727_attributeActions_k).keySet().Elements()) {
          dafny.DafnySequence<? extends Character> _assign_such_that_0 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_assign_such_that_0_boxed0));
          if (true) {
            _1728_attribute = (dafny.DafnySequence<? extends Character>)_assign_such_that_0;
            if ((_1727_attributeActions_k).<dafny.DafnySequence<? extends Character>>contains(_1728_attribute)) {
              break goto__ASSIGN_SUCH_THAT_0;
            }
          }
        }
        throw new IllegalArgumentException("assign-such-that search produced no value (line 106)");
      }
      Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction _1729_action;
      _1729_action = ((Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction)(java.lang.Object)(((config).dtor_attributeActions()).get(_1728_attribute)));
      if (!(AwsCryptographyDynamoDbEncryptionItemEncryptorOperations_Compile.__default.ForwardCompatibleAttributeAction(_1728_attribute, _1729_action, (config).dtor_allowedUnauthenticatedAttributes(), (config).dtor_allowedUnauthenticatedAttributePrefix()))) {
        res = Wrappers_Compile.Result.<DynamoDbItemEncryptorClient, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>create_Failure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error.create_DynamoDbItemEncryptorException(AwsCryptographyDynamoDbEncryptionItemEncryptorOperations_Compile.__default.ExplainNotForwardCompatible(_1728_attribute, _1729_action, (config).dtor_allowedUnauthenticatedAttributes(), (config).dtor_allowedUnauthenticatedAttributePrefix())));
        return res;
      }
      if (!(__default.UnreservedPrefix(_1728_attribute))) {
        res = Wrappers_Compile.Result.<DynamoDbItemEncryptorClient, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>create_Failure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error.create_DynamoDbItemEncryptorException(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Attribute: "), _1728_attribute), dafny.DafnySequence.asString(" is reserved, and may not be configured."))));
        return res;
      }
      _1727_attributeActions_k = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction>subtract(_1727_attributeActions_k, dafny.DafnySet.of(_1728_attribute));
    }
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.StructuredEncryptionClient, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _1730_structuredEncryptionRes;
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.StructuredEncryptionClient, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _out83;
    _out83 = Dafny.Aws.Cryptography.StructuredEncryption.__default.StructuredEncryption(Dafny.Aws.Cryptography.StructuredEncryption.__default.DefaultStructuredEncryptionConfig());
    _1730_structuredEncryptionRes = _out83;
    Dafny.Aws.Cryptography.StructuredEncryption.StructuredEncryptionClient _1731_structuredEncryption;
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.StructuredEncryptionClient, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1732_valueOrError4 = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.StructuredEncryption.StructuredEncryptionClient, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>)null;
    _1732_valueOrError4 = (_1730_structuredEncryptionRes).<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>MapFailure(Dafny.Aws.Cryptography.StructuredEncryption.StructuredEncryptionClient._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>)(_1733_e_boxed0) -> {
      Dafny.Aws.Cryptography.StructuredEncryption.Types.Error _1733_e = ((Dafny.Aws.Cryptography.StructuredEncryption.Types.Error)(java.lang.Object)(_1733_e_boxed0));
      return Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error.create_AwsCryptographyDynamoDbEncryption(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error.create_AwsCryptographyStructuredEncryption(_1733_e));
    }));
    if ((_1732_valueOrError4).IsFailure(Dafny.Aws.Cryptography.StructuredEncryption.StructuredEncryptionClient._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor())) {
      res = (_1732_valueOrError4).<DynamoDbItemEncryptorClient>PropagateFailure(Dafny.Aws.Cryptography.StructuredEncryption.StructuredEncryptionClient._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), DynamoDbItemEncryptorClient._typeDescriptor());
      return res;
    }
    _1731_structuredEncryption = (_1732_valueOrError4).Extract(Dafny.Aws.Cryptography.StructuredEncryption.StructuredEncryptionClient._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor());
    Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager _1734_cmm = null;
    if (((config).dtor_cmm()).is_Some()) {
      _1734_cmm = ((config).dtor_cmm()).dtor_value();
    } else {
      Dafny.Aws.Cryptography.MaterialProviders.Types.IKeyring _1735_keyring;
      _1735_keyring = ((config).dtor_keyring()).dtor_value();
      Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient _1736_matProv;
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient, Dafny.Aws.Cryptography.MaterialProviders.Types.Error> _1737_valueOrError5 = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient, Dafny.Aws.Cryptography.MaterialProviders.Types.Error>)null;
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient, Dafny.Aws.Cryptography.MaterialProviders.Types.Error> _out84;
      _out84 = Dafny.Aws.Cryptography.MaterialProviders.__default.MaterialProviders(Dafny.Aws.Cryptography.MaterialProviders.__default.DefaultMaterialProvidersConfig());
      _1737_valueOrError5 = _out84;
      if (!(!((_1737_valueOrError5).IsFailure(Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient._typeDescriptor(), Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor())))) {
        throw new dafny.DafnyHaltException("/Users/lavaleri/github/aws-dynamodb-encryption-dafny/DynamoDbEncryption/dafny/DynamoDbItemEncryptor/src/Index.dfy(144,18): " + java.lang.String.valueOf(_1737_valueOrError5));
      }
      _1736_matProv = (_1737_valueOrError5).Extract(Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient._typeDescriptor(), Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor());
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager, Dafny.Aws.Cryptography.MaterialProviders.Types.Error> _1738_maybeCmm;
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager, Dafny.Aws.Cryptography.MaterialProviders.Types.Error> _out85;
      _out85 = (_1736_matProv).CreateDefaultCryptographicMaterialsManager(Dafny.Aws.Cryptography.MaterialProviders.Types.CreateDefaultCryptographicMaterialsManagerInput.create(_1735_keyring));
      _1738_maybeCmm = _out85;
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1739_valueOrError6 = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsManager, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>)null;
      _1739_valueOrError6 = (_1738_maybeCmm).<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>MapFailure(Dafny.Aws.Cryptography.MaterialProviders.Types._Companion_ICryptographicMaterialsManager._typeDescriptor(), Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.MaterialProviders.Types.Error, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>)(_1740_e_boxed0) -> {
        Dafny.Aws.Cryptography.MaterialProviders.Types.Error _1740_e = ((Dafny.Aws.Cryptography.MaterialProviders.Types.Error)(java.lang.Object)(_1740_e_boxed0));
        return Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error.create_AwsCryptographyMaterialProviders(_1740_e);
      }));
      if ((_1739_valueOrError6).IsFailure(Dafny.Aws.Cryptography.MaterialProviders.Types._Companion_ICryptographicMaterialsManager._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor())) {
        res = (_1739_valueOrError6).<DynamoDbItemEncryptorClient>PropagateFailure(Dafny.Aws.Cryptography.MaterialProviders.Types._Companion_ICryptographicMaterialsManager._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), DynamoDbItemEncryptorClient._typeDescriptor());
        return res;
      }
      _1734_cmm = (_1739_valueOrError6).Extract(Dafny.Aws.Cryptography.MaterialProviders.Types._Companion_ICryptographicMaterialsManager._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor());
    }
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient, Dafny.Aws.Cryptography.MaterialProviders.Types.Error> _1741_maybeCmpClient;
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient, Dafny.Aws.Cryptography.MaterialProviders.Types.Error> _out86;
    _out86 = Dafny.Aws.Cryptography.MaterialProviders.__default.MaterialProviders(Dafny.Aws.Cryptography.MaterialProviders.__default.DefaultMaterialProvidersConfig());
    _1741_maybeCmpClient = _out86;
    Wrappers_Compile.Option<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Internal.InternalLegacyConfig> _1742_internalLegacyConfig;
    Wrappers_Compile.Result<Wrappers_Compile.Option<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Internal.InternalLegacyConfig>, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1743_valueOrError7 = Wrappers_Compile.Result.<Wrappers_Compile.Option<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Internal.InternalLegacyConfig>, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>Default(Wrappers_Compile.Option.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Internal.InternalLegacyConfig>Default());
    Wrappers_Compile.Result<Wrappers_Compile.Option<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Internal.InternalLegacyConfig>, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _out87;
    _out87 = Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Internal.InternalLegacyConfig.Build(config);
    _1743_valueOrError7 = _out87;
    if ((_1743_valueOrError7).IsFailure(Wrappers_Compile.Option.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Internal.InternalLegacyConfig>_typeDescriptor(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Internal.InternalLegacyConfig._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor())) {
      res = (_1743_valueOrError7).<DynamoDbItemEncryptorClient>PropagateFailure(Wrappers_Compile.Option.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Internal.InternalLegacyConfig>_typeDescriptor(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Internal.InternalLegacyConfig._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), DynamoDbItemEncryptorClient._typeDescriptor());
      return res;
    }
    _1742_internalLegacyConfig = (_1743_valueOrError7).Extract(Wrappers_Compile.Option.<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Internal.InternalLegacyConfig>_typeDescriptor(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Internal.InternalLegacyConfig._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor());
    Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient _1744_cmpClient;
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _1745_valueOrError8 = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>)null;
    _1745_valueOrError8 = (_1741_maybeCmpClient).<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>MapFailure(Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient._typeDescriptor(), Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.MaterialProviders.Types.Error, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>)(_1746_e_boxed0) -> {
      Dafny.Aws.Cryptography.MaterialProviders.Types.Error _1746_e = ((Dafny.Aws.Cryptography.MaterialProviders.Types.Error)(java.lang.Object)(_1746_e_boxed0));
      return Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error.create_AwsCryptographyMaterialProviders(_1746_e);
    }));
    if ((_1745_valueOrError8).IsFailure(Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor())) {
      res = (_1745_valueOrError8).<DynamoDbItemEncryptorClient>PropagateFailure(Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), DynamoDbItemEncryptorClient._typeDescriptor());
      return res;
    }
    _1744_cmpClient = (_1745_valueOrError8).Extract(Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor());
    if (!(((_1742_internalLegacyConfig).is_None()) || (((config).dtor_plaintextPolicy()).is_None()))) {
      res = Wrappers_Compile.Result.<DynamoDbItemEncryptorClient, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>create_Failure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error.create_DynamoDbItemEncryptorException(dafny.DafnySequence.asString("Cannot configure both a plaintext policy and a legacy config.")));
      return res;
    }
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.PlaintextPolicy _1747_plaintextPolicy;
    _1747_plaintextPolicy = ((((config).dtor_plaintextPolicy()).is_Some()) ? (((config).dtor_plaintextPolicy()).dtor_value()) : (Dafny.Aws.Cryptography.DynamoDbEncryption.Types.PlaintextPolicy.create_FORBID__WRITE__FORBID__READ()));
    AwsCryptographyDynamoDbEncryptionItemEncryptorOperations_Compile.Config _1748_internalConfig;
    _1748_internalConfig = AwsCryptographyDynamoDbEncryptionItemEncryptorOperations_Compile.Config.create(_1744_cmpClient, (config).dtor_logicalTableName(), (config).dtor_partitionKeyName(), (config).dtor_sortKeyName(), _1734_cmm, (config).dtor_attributeActions(), (config).dtor_allowedUnauthenticatedAttributes(), (config).dtor_allowedUnauthenticatedAttributePrefix(), (config).dtor_algorithmSuiteId(), _1731_structuredEncryption, _1747_plaintextPolicy, _1742_internalLegacyConfig);
    DynamoDbItemEncryptorClient _1749_client;
    DynamoDbItemEncryptorClient _nw3 = new DynamoDbItemEncryptorClient();
    _nw3.__ctor(_1748_internalConfig);
    _1749_client = _nw3;
    res = Wrappers_Compile.Result.<DynamoDbItemEncryptorClient, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error>create_Success(_1749_client);
    return res;
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor_Compile._default";
  }
}
