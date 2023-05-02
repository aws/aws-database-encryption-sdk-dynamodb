// Class _ExternBase___default
// Dafny class __default compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms;

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
import TransactGetItemsTransform_Compile.*;
import DeleteItemTransform_Compile.*;
import ExecuteStatementTransform_Compile.*;
import BatchExecuteStatementTransform_Compile.*;
import ExecuteTransactionTransform_Compile.*;
import CreateTableTransform_Compile.*;
import UpdateTableTransform_Compile.*;
import DescribeTableTransform_Compile.*;
import AwsCryptographyDynamoDbEncryptionTransformsOperations_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class _ExternBase___default {
  public _ExternBase___default() {
  }
  public static Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTablesEncryptionConfig DefaultDynamoDbTablesEncryptionConfig() {
    return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTablesEncryptionConfig.create(dafny.DafnyMap.fromElements());
  }
  public static dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> AddSignedBeaconActions(dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> names, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> actions)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((names).length())).signum() == 0) {
        return actions;
      } else {
        dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _in409 = (names).drop(java.math.BigInteger.ONE);
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> _in410 = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction>update(actions, ((dafny.DafnySequence<? extends Character>)(java.lang.Object)((names).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction.create_SIGN__ONLY());
        names = _in409;
        actions = _in410;
        continue TAIL_CALL_START;
      }
    }
  }
  public static boolean IsConfigured(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig config, dafny.DafnySequence<? extends Character> name)
  {
    return ((((config).dtor_attributeActions()).<dafny.DafnySequence<? extends Character>>contains(name)) || ((((config).dtor_allowedUnauthenticatedAttributes()).is_Some()) && ((((config).dtor_allowedUnauthenticatedAttributes()).dtor_value()).contains(name)))) || ((((config).dtor_allowedUnauthenticatedAttributePrefix()).is_Some()) && ((((config).dtor_allowedUnauthenticatedAttributePrefix()).dtor_value()).isPrefixOf(name)));
  }
  public static Wrappers_Compile.Result<DynamoDbEncryptionTransformsClient, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> DynamoDbEncryptionTransforms(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTablesEncryptionConfig config)
  {
    Wrappers_Compile.Result<DynamoDbEncryptionTransformsClient, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> res = (Wrappers_Compile.Result<DynamoDbEncryptionTransformsClient, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)null;
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbMiddlewareConfig_Compile.TableConfig> _2009_internalConfigs;
    _2009_internalConfigs = dafny.DafnyMap.fromElements();
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig> _2010_m_k;
    _2010_m_k = (config).dtor_tableEncryptionConfigs();
    dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> _2011_allLogicalTableNames;
    _2011_allLogicalTableNames = dafny.DafnySet.<dafny.DafnySequence<? extends Character>> empty();
    while (!((_2010_m_k).keySet()).equals(dafny.DafnySet.<dafny.DafnySequence<? extends Character>> empty())) {
      dafny.DafnySequence<? extends Character> _2012_tableName;
      goto__ASSIGN_SUCH_THAT_3: {
        for (dafny.DafnySequence<? extends Character> _assign_such_that_3_boxed0 : (_2010_m_k).keySet().Elements()) {
          dafny.DafnySequence<? extends Character> _assign_such_that_3 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_assign_such_that_3_boxed0));
          if (true) {
            _2012_tableName = (dafny.DafnySequence<? extends Character>)_assign_such_that_3;
            if ((_2010_m_k).<dafny.DafnySequence<? extends Character>>contains(_2012_tableName)) {
              break goto__ASSIGN_SUCH_THAT_3;
            }
          }
        }
        throw new IllegalArgumentException("assign-such-that search produced no value (line 146)");
      }
      Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig _2013_inputConfig;
      _2013_inputConfig = ((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig)(java.lang.Object)(((config).dtor_tableEncryptionConfigs()).get(_2012_tableName)));
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _2014_valueOrError0 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default();
      _2014_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), !(_2011_allLogicalTableNames).<dafny.DafnySequence<? extends Character>>contains((_2013_inputConfig).dtor_logicalTableName()), DdbMiddlewareConfig_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Duplicate logical table maped to multipule physical tables: "), (_2013_inputConfig).dtor_logicalTableName())));
      if ((_2014_valueOrError0).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
        res = (_2014_valueOrError0).<DynamoDbEncryptionTransformsClient>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), DynamoDbEncryptionTransformsClient._typeDescriptor());
        return res;
      }
      Wrappers_Compile.Result<Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _2015_searchR;
      Wrappers_Compile.Result<Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out176;
      _out176 = SearchConfigToInfo_Compile.__default.Convert(_2013_inputConfig);
      _2015_searchR = _out176;
      Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo> _2016_search;
      Wrappers_Compile.Result<Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _2017_valueOrError1 = Wrappers_Compile.Result.<Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo>, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default(Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.SearchInfo>Default());
      _2017_valueOrError1 = (_2015_searchR).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>MapFailure(Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.SearchInfo>_typeDescriptor(SearchableEncryptionInfo_Compile.SearchInfo._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)(_2018_e_boxed0) -> {
        Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error _2018_e = ((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error)(java.lang.Object)(_2018_e_boxed0));
        return Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error.create_AwsCryptographyDynamoDbEncryption(_2018_e);
      }));
      if ((_2017_valueOrError1).IsFailure(Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.SearchInfo>_typeDescriptor(SearchableEncryptionInfo_Compile.SearchInfo._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
        res = (_2017_valueOrError1).<DynamoDbEncryptionTransformsClient>PropagateFailure(Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.SearchInfo>_typeDescriptor(SearchableEncryptionInfo_Compile.SearchInfo._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), DynamoDbEncryptionTransformsClient._typeDescriptor());
        return res;
      }
      _2016_search = (_2017_valueOrError1).Extract(Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.SearchInfo>_typeDescriptor(SearchableEncryptionInfo_Compile.SearchInfo._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _2019_signedBeacons;
      _2019_signedBeacons = (((_2016_search).is_None()) ? (dafny.DafnySequence.<dafny.DafnySequence<? extends Character>> empty(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR))) : ((((_2016_search).dtor_value()).curr()).ListSignedBeacons()));
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _2020_badBeacons;
      _2020_badBeacons = Seq_Compile.__default.<dafny.DafnySequence<? extends Character>>Filter(dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((java.util.function.Function<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig, java.util.function.Function<dafny.DafnySequence<? extends Character>, Boolean>>)(_2021_inputConfig) -> ((java.util.function.Function<dafny.DafnySequence<? extends Character>, Boolean>)(_2022_s_boxed0) -> {
        dafny.DafnySequence<? extends Character> _2022_s = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_2022_s_boxed0));
        return __default.IsConfigured(_2021_inputConfig, _2022_s);
      })).apply(_2013_inputConfig), _2019_signedBeacons);
      if ((java.math.BigInteger.valueOf((_2020_badBeacons).length())).signum() == 1) {
        res = Wrappers_Compile.Result.<DynamoDbEncryptionTransformsClient, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>create_Failure(DdbMiddlewareConfig_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Signed beacons cannot be configured with CryptoActions or as unauthenticated : "), StandardLibrary_Compile.__default.<Character>Join(dafny.TypeDescriptor.CHAR, _2020_badBeacons, dafny.DafnySequence.asString(", ")))));
        return res;
      }
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _2023_valueOrError2 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Default();
      _2023_valueOrError2 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>>, Boolean>)(_2024_signedBeacons) -> dafny.Helpers.Quantifier((_2024_signedBeacons).UniqueElements(), true, ((_forall_var_20_boxed0) -> {
        dafny.DafnySequence<? extends Character> _forall_var_20 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_forall_var_20_boxed0));
        if (true) {
          dafny.DafnySequence<? extends Character> _2025_k = (dafny.DafnySequence<? extends Character>)_forall_var_20;
          return !((_2024_signedBeacons).contains(_2025_k)) || (Dafny.Com.Amazonaws.Dynamodb.Types.__default.IsValid__AttributeName(_2025_k));
        } else {
          return true;
        }
      }))).apply(_2019_signedBeacons), DdbMiddlewareConfig_Compile.__default.E(dafny.DafnySequence.asString("Beacon configured with bad name")));
      if ((_2023_valueOrError2).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
        res = (_2023_valueOrError2).<DynamoDbEncryptionTransformsClient>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), DynamoDbEncryptionTransformsClient._typeDescriptor());
        return res;
      }
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> _2026_newActions;
      _2026_newActions = __default.AddSignedBeaconActions(_2019_signedBeacons, (_2013_inputConfig).dtor_attributeActions());
      Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DynamoDbItemEncryptorConfig _2027_encryptorConfig;
      _2027_encryptorConfig = Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DynamoDbItemEncryptorConfig.create((_2013_inputConfig).dtor_logicalTableName(), (_2013_inputConfig).dtor_partitionKeyName(), (_2013_inputConfig).dtor_sortKeyName(), _2026_newActions, (_2013_inputConfig).dtor_allowedUnauthenticatedAttributes(), (_2013_inputConfig).dtor_allowedUnauthenticatedAttributePrefix(), (_2013_inputConfig).dtor_algorithmSuiteId(), (_2013_inputConfig).dtor_keyring(), (_2013_inputConfig).dtor_cmm(), (_2013_inputConfig).dtor_legacyConfig(), (_2013_inputConfig).dtor_plaintextPolicy());
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.DynamoDbItemEncryptorClient, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _2028_itemEncryptorRes;
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.DynamoDbItemEncryptorClient, Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error> _out177;
      _out177 = Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.__default.DynamoDbItemEncryptor(_2027_encryptorConfig);
      _2028_itemEncryptorRes = _out177;
      Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.DynamoDbItemEncryptorClient _2029_itemEncryptor;
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.DynamoDbItemEncryptorClient, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error> _2030_valueOrError3 = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.DynamoDbItemEncryptorClient, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)null;
      _2030_valueOrError3 = (_2028_itemEncryptorRes).<Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>MapFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.DynamoDbItemEncryptorClient._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>)(_2031_e_boxed0) -> {
        Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error _2031_e = ((Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.Error)(java.lang.Object)(_2031_e_boxed0));
        return Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error.create_AwsCryptographyDynamoDbEncryptionItemEncryptor(_2031_e);
      }));
      if ((_2030_valueOrError3).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.DynamoDbItemEncryptorClient._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor())) {
        res = (_2030_valueOrError3).<DynamoDbEncryptionTransformsClient>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.DynamoDbItemEncryptorClient._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor(), DynamoDbEncryptionTransformsClient._typeDescriptor());
        return res;
      }
      _2029_itemEncryptor = (_2030_valueOrError3).Extract(Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.DynamoDbItemEncryptorClient._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error._typeDescriptor());
      DdbMiddlewareConfig_Compile.TableConfig _2032_internalConfig;
      _2032_internalConfig = DdbMiddlewareConfig_Compile.TableConfig.create(_2012_tableName, (_2013_inputConfig).dtor_logicalTableName(), (_2013_inputConfig).dtor_partitionKeyName(), (_2013_inputConfig).dtor_sortKeyName(), _2029_itemEncryptor, _2016_search);
      _2009_internalConfigs = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, DdbMiddlewareConfig_Compile.TableConfig>update(_2009_internalConfigs, _2012_tableName, _2032_internalConfig);
      _2011_allLogicalTableNames = dafny.DafnySet.<dafny.DafnySequence<? extends Character>>union(_2011_allLogicalTableNames, dafny.DafnySet.of((_2032_internalConfig).dtor_logicalTableName()));
      _2010_m_k = ((dafny.Function2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig>, dafny.DafnySequence<? extends Character>, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig>>)(_2033_m_k, _2034_tableName) -> ((dafny.Function0<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig>>)(() -> {
        java.util.HashMap<dafny.DafnySequence<? extends Character>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig> _coll37 = new java.util.HashMap<>();
        for (dafny.DafnySequence<? extends Character> _compr_38_boxed0 : (_2033_m_k).keySet().Elements()) {
          dafny.DafnySequence<? extends Character> _compr_38 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_compr_38_boxed0));
          if (true) {
            dafny.DafnySequence<? extends Character> _2035_k_k = (dafny.DafnySequence<? extends Character>)_compr_38;
            if (((_2033_m_k).<dafny.DafnySequence<? extends Character>>contains(_2035_k_k)) && (!(_2035_k_k).equals(_2034_tableName))) {
              _coll37.put(_2035_k_k,((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig)(java.lang.Object)((_2033_m_k).get(_2035_k_k))));
            }
          }
        }
        return new dafny.DafnyMap<dafny.DafnySequence<? extends Character>,Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig>(_coll37);
      })).apply()).apply(_2010_m_k, _2012_tableName);
    }
    DdbMiddlewareConfig_Compile.Config _2036_newConfig;
    _2036_newConfig = DdbMiddlewareConfig_Compile.Config.create(_2009_internalConfigs);
    DynamoDbEncryptionTransformsClient _2037_client;
    DynamoDbEncryptionTransformsClient _nw4 = new DynamoDbEncryptionTransformsClient();
    _nw4.__ctor(_2036_newConfig);
    _2037_client = _nw4;
    res = Wrappers_Compile.Result.<DynamoDbEncryptionTransformsClient, Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.Error>create_Success(_2037_client);
    return res;
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms_Compile._default";
  }
}
