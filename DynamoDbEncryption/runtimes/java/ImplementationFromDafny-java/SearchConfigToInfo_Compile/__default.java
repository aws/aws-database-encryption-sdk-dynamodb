// Class __default
// Dafny class __default compiled into Java
package SearchConfigToInfo_Compile;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static Wrappers_Compile.Result<Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> Convert(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig outer)
  {
    Wrappers_Compile.Result<Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> output = Wrappers_Compile.Result.<Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.SearchInfo>Default());
    if(true) {
      if (((outer).dtor_search()).is_None()) {
        output = Wrappers_Compile.Result.<Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.SearchInfo>create_None());
        return output;
      } else {
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1027_valueOrError0 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default();
        _1027_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), ((((outer).dtor_search()).dtor_value()).dtor_writeVersion()) == (1), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("writeVersion must be '1'.")));
        if ((_1027_valueOrError0).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          output = (_1027_valueOrError0).<Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo>>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.SearchInfo>_typeDescriptor(SearchableEncryptionInfo_Compile.ValidSearchInfo._typeDescriptor()));
          return output;
        }
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1028_valueOrError1 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default();
        _1028_valueOrError1 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), java.util.Objects.equals(java.math.BigInteger.valueOf(((((outer).dtor_search()).dtor_value()).dtor_versions()).length()), java.math.BigInteger.ONE), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("search config must be have exactly one version.")));
        if ((_1028_valueOrError1).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          output = (_1028_valueOrError1).<Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo>>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.SearchInfo>_typeDescriptor(SearchableEncryptionInfo_Compile.ValidSearchInfo._typeDescriptor()));
          return output;
        }
        SearchableEncryptionInfo_Compile.BeaconVersion _1029_version;
        Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1030_valueOrError2 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)null;
        Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out53;
        _out53 = __default.ConvertVersion(outer, ((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BeaconVersion)(java.lang.Object)(((((outer).dtor_search()).dtor_value()).dtor_versions()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))));
        _1030_valueOrError2 = _out53;
        if ((_1030_valueOrError2).IsFailure(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          output = (_1030_valueOrError2).<Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo>>PropagateFailure(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.SearchInfo>_typeDescriptor(SearchableEncryptionInfo_Compile.ValidSearchInfo._typeDescriptor()));
          return output;
        }
        _1029_version = (_1030_valueOrError2).Extract(SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        SearchableEncryptionInfo_Compile.SearchInfo _1031_info;
        _1031_info = SearchableEncryptionInfo_Compile.__default.MakeSearchInfo(_1029_version);
        output = Wrappers_Compile.Result.<Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.SearchInfo>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.SearchInfo>create_Some(_1031_info));
        return output;
      }
    }
    return output;
  }
  public static Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> ShouldDeleteKeyField(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig outer, dafny.DafnySequence<? extends Character> keyFieldName)
  {
    if (!((outer).dtor_attributeActions()).<dafny.DafnySequence<? extends Character>>contains(keyFieldName)) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    } else {
      Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction _source15 = ((Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction)(java.lang.Object)(((outer).dtor_attributeActions()).get(keyFieldName)));
      if (_source15.is_ENCRYPT__AND__SIGN()) {
        return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Beacon key field name "), keyFieldName), dafny.DafnySequence.asString(" is configured as ENCRYPT_AND_SIGN which is not allowed."))));
      } else if (_source15.is_SIGN__ONLY()) {
        return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(false);
      } else {
        return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
      }
    }
  }
  public static Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> MakeKeySource(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig outer, Dafny.Aws.Cryptography.KeyStore.Types.IKeyStoreClient keyStore, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BeaconKeySource config, Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient client)
  {
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> output = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)null;
    if(true) {
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient, Dafny.Aws.Cryptography.MaterialProviders.Types.Error> _1032_mplR;
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient, Dafny.Aws.Cryptography.MaterialProviders.Types.Error> _out54;
      _out54 = Dafny.Aws.Cryptography.MaterialProviders.__default.MaterialProviders(Dafny.Aws.Cryptography.MaterialProviders.__default.DefaultMaterialProvidersConfig());
      _1032_mplR = _out54;
      Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient _1033_mpl;
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1034_valueOrError0 = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)null;
      _1034_valueOrError0 = (_1032_mplR).<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>MapFailure(Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient._typeDescriptor(), Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.MaterialProviders.Types.Error, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)(_1035_e_boxed0) -> {
        Dafny.Aws.Cryptography.MaterialProviders.Types.Error _1035_e = ((Dafny.Aws.Cryptography.MaterialProviders.Types.Error)(java.lang.Object)(_1035_e_boxed0));
        return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error.create_AwsCryptographyMaterialProviders(_1035_e);
      }));
      if ((_1034_valueOrError0).IsFailure(Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        output = (_1034_valueOrError0).<SearchableEncryptionInfo_Compile.KeySource>PropagateFailure(Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.KeySource._typeDescriptor());
        return output;
      }
      _1033_mpl = (_1034_valueOrError0).Extract(Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
      int _1036_cacheSize;
      _1036_cacheSize = (((config).is_multi()) ? (((config).dtor_multi()).dtor_maxCacheSize()) : (1));
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1037_valueOrError1 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default();
      _1037_valueOrError1 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), java.lang.Integer.signum((_1036_cacheSize)) == 1, DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("maxCacheSize must be at least 1.")));
      if ((_1037_valueOrError1).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        output = (_1037_valueOrError1).<SearchableEncryptionInfo_Compile.KeySource>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.KeySource._typeDescriptor());
        return output;
      }
      Dafny.Aws.Cryptography.MaterialProviders.Types.CreateCryptographicMaterialsCacheInput _1038_input;
      _1038_input = Dafny.Aws.Cryptography.MaterialProviders.Types.CreateCryptographicMaterialsCacheInput.create(_1036_cacheSize, Wrappers_Compile.Option.<java.lang.Integer>create_None());
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsCache, Dafny.Aws.Cryptography.MaterialProviders.Types.Error> _1039_maybeCache;
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsCache, Dafny.Aws.Cryptography.MaterialProviders.Types.Error> _out55;
      _out55 = (_1033_mpl).CreateCryptographicMaterialsCache(_1038_input);
      _1039_maybeCache = _out55;
      Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsCache _1040_cache;
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsCache, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1041_valueOrError2 = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.Types.ICryptographicMaterialsCache, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)null;
      _1041_valueOrError2 = (_1039_maybeCache).<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>MapFailure(Dafny.Aws.Cryptography.MaterialProviders.Types._Companion_ICryptographicMaterialsCache._typeDescriptor(), Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.MaterialProviders.Types.Error, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)(_1042_e_boxed0) -> {
        Dafny.Aws.Cryptography.MaterialProviders.Types.Error _1042_e = ((Dafny.Aws.Cryptography.MaterialProviders.Types.Error)(java.lang.Object)(_1042_e_boxed0));
        return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error.create_AwsCryptographyMaterialProviders(_1042_e);
      }));
      if ((_1041_valueOrError2).IsFailure(Dafny.Aws.Cryptography.MaterialProviders.Types._Companion_ICryptographicMaterialsCache._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        output = (_1041_valueOrError2).<SearchableEncryptionInfo_Compile.KeySource>PropagateFailure(Dafny.Aws.Cryptography.MaterialProviders.Types._Companion_ICryptographicMaterialsCache._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.KeySource._typeDescriptor());
        return output;
      }
      _1040_cache = (_1041_valueOrError2).Extract(Dafny.Aws.Cryptography.MaterialProviders.Types._Companion_ICryptographicMaterialsCache._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
      if ((config).is_multi()) {
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1043_valueOrError3 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default();
        _1043_valueOrError3 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), java.lang.Integer.signum((((config).dtor_multi()).dtor_cacheTTL())) == 1, DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Beacon Cache TTL must be at least 1.")));
        if ((_1043_valueOrError3).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          output = (_1043_valueOrError3).<SearchableEncryptionInfo_Compile.KeySource>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.KeySource._typeDescriptor());
          return output;
        }
        boolean _1044_deleteKey;
        Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1045_valueOrError4 = Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(false);
        _1045_valueOrError4 = __default.ShouldDeleteKeyField(outer, ((config).dtor_multi()).dtor_keyFieldName());
        if ((_1045_valueOrError4).IsFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          output = (_1045_valueOrError4).<SearchableEncryptionInfo_Compile.KeySource>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.KeySource._typeDescriptor());
          return output;
        }
        _1044_deleteKey = (_1045_valueOrError4).Extract(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        output = Wrappers_Compile.Result.<SearchableEncryptionInfo_Compile.KeySource, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(SearchableEncryptionInfo_Compile.KeySource.create(client, keyStore, SearchableEncryptionInfo_Compile.KeyLocation.create_MultiLoc(((config).dtor_multi()).dtor_keyFieldName(), _1044_deleteKey), _1040_cache, (((config).dtor_multi()).dtor_cacheTTL())));
      } else {
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1046_valueOrError5 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default();
        _1046_valueOrError5 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), java.lang.Integer.signum((((config).dtor_single()).dtor_cacheTTL())) == 1, DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Beacon Cache TTL must be at least 1.")));
        if ((_1046_valueOrError5).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          output = (_1046_valueOrError5).<SearchableEncryptionInfo_Compile.KeySource>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.KeySource._typeDescriptor());
          return output;
        }
        output = Wrappers_Compile.Result.<SearchableEncryptionInfo_Compile.KeySource, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(SearchableEncryptionInfo_Compile.KeySource.create(client, keyStore, SearchableEncryptionInfo_Compile.KeyLocation.create_SingleLoc(((config).dtor_single()).dtor_keyId()), _1040_cache, (((config).dtor_single()).dtor_cacheTTL())));
      }
    }
    return output;
  }
  public static Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> ConvertVersion(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig outer, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BeaconVersion config)
  {
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> output = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)null;
    if(true) {
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1047_valueOrError0 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default();
      _1047_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), ((config).dtor_version()) == (1), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Version number in BeaconVersion must be '1'.")));
      if ((_1047_valueOrError0).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        output = (_1047_valueOrError0).<SearchableEncryptionInfo_Compile.BeaconVersion>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor());
        return output;
      }
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1048_valueOrError1 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default();
      _1048_valueOrError1 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), (java.math.BigInteger.valueOf(((config).dtor_standardBeacons()).length())).signum() == 1, DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("At least one standard beacon must be configured.")));
      if ((_1048_valueOrError1).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        output = (_1048_valueOrError1).<SearchableEncryptionInfo_Compile.BeaconVersion>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor());
        return output;
      }
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient, Dafny.Aws.Cryptography.Primitives.Types.Error> _1049_maybePrimitives;
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient, Dafny.Aws.Cryptography.Primitives.Types.Error> _out56;
      _out56 = Dafny.Aws.Cryptography.Primitives.__default.AtomicPrimitives(Dafny.Aws.Cryptography.Primitives.__default.DefaultCryptoConfig());
      _1049_maybePrimitives = _out56;
      Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient _1050_primitives;
      Wrappers_Compile.Result<Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1051_valueOrError2 = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)null;
      _1051_valueOrError2 = (_1049_maybePrimitives).<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>MapFailure(Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient._typeDescriptor(), Dafny.Aws.Cryptography.Primitives.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.Primitives.Types.Error, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)(_1052_e_boxed0) -> {
        Dafny.Aws.Cryptography.Primitives.Types.Error _1052_e = ((Dafny.Aws.Cryptography.Primitives.Types.Error)(java.lang.Object)(_1052_e_boxed0));
        return Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error.create_AwsCryptographyPrimitives(_1052_e);
      }));
      if ((_1051_valueOrError2).IsFailure(Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        output = (_1051_valueOrError2).<SearchableEncryptionInfo_Compile.BeaconVersion>PropagateFailure(Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor());
        return output;
      }
      _1050_primitives = (_1051_valueOrError2).Extract(Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
      SearchableEncryptionInfo_Compile.KeySource _1053_source;
      Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1054_valueOrError3 = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)null;
      Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.KeySource, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out57;
      _out57 = __default.MakeKeySource(outer, (config).dtor_keyStore(), (config).dtor_keySource(), _1050_primitives);
      _1054_valueOrError3 = _out57;
      if ((_1054_valueOrError3).IsFailure(SearchableEncryptionInfo_Compile.KeySource._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        output = (_1054_valueOrError3).<SearchableEncryptionInfo_Compile.BeaconVersion>PropagateFailure(SearchableEncryptionInfo_Compile.KeySource._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor());
        return output;
      }
      _1053_source = (_1054_valueOrError3).Extract(SearchableEncryptionInfo_Compile.KeySource._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
      Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out58;
      _out58 = __default.ConvertVersionWithSource(outer, config, _1053_source);
      output = _out58;
    }
    return output;
  }
  public static Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> ConvertVersionWithSource(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig outer, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.BeaconVersion config, SearchableEncryptionInfo_Compile.KeySource source)
  {
    Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> output = (Wrappers_Compile.Result<SearchableEncryptionInfo_Compile.BeaconVersion, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)null;
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> _1055_virtualFields;
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1056_valueOrError0 = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,DdbVirtualFields_Compile.VirtField> empty());
    _1056_valueOrError0 = __default.ConvertVirtualFields(outer, (config).dtor_virtualFields());
    if ((_1056_valueOrError0).IsFailure(DdbVirtualFields_Compile.VirtualFieldMap._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
      output = (_1056_valueOrError0).<SearchableEncryptionInfo_Compile.BeaconVersion>PropagateFailure(DdbVirtualFields_Compile.VirtualFieldMap._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor());
      return output;
    }
    _1055_virtualFields = (_1056_valueOrError0).Extract(DdbVirtualFields_Compile.VirtualFieldMap._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
    dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon> _1057_beacons;
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1058_valueOrError1 = (Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)null;
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out59;
    _out59 = __default.ConvertBeacons(outer, (source).dtor_client(), _1055_virtualFields, (config).dtor_standardBeacons(), (config).dtor_compoundBeacons());
    _1058_valueOrError1 = _out59;
    if ((_1058_valueOrError1).IsFailure(SearchableEncryptionInfo_Compile.BeaconMap._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
      output = (_1058_valueOrError1).<SearchableEncryptionInfo_Compile.BeaconVersion>PropagateFailure(SearchableEncryptionInfo_Compile.BeaconMap._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.ValidBeaconVersion._typeDescriptor());
      return output;
    }
    _1057_beacons = (_1058_valueOrError1).Extract(SearchableEncryptionInfo_Compile.BeaconMap._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
    if (((source).dtor_keyLoc()).is_MultiLoc()) {
      dafny.DafnySequence<? extends Character> _1059_name;
      _1059_name = ((source).dtor_keyLoc()).dtor_keyName();
      if ((_1057_beacons).<dafny.DafnySequence<? extends Character>>contains(_1059_name)) {
        output = Wrappers_Compile.Result.<SearchableEncryptionInfo_Compile.BeaconVersion, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("A beacon key field name of "), _1059_name), dafny.DafnySequence.asString(" was configured, but there's also a beacon of that name."))));
        return output;
      }
      if ((_1055_virtualFields).<dafny.DafnySequence<? extends Character>>contains(_1059_name)) {
        output = Wrappers_Compile.Result.<SearchableEncryptionInfo_Compile.BeaconVersion, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("A beacon key field name of "), _1059_name), dafny.DafnySequence.asString(" was configured, but there's also a virtual field of that name."))));
        return output;
      }
    }
    output = SearchableEncryptionInfo_Compile.__default.MakeBeaconVersion(((long) ((config).dtor_version())), source, _1057_beacons, _1055_virtualFields);
    return output;
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> ConvertVirtualFields(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig outer, Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualField>> vf)
  {
    if ((vf).is_None()) {
      return Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(dafny.DafnyMap.fromElements());
    } else {
      return __default.AddVirtualFields((vf).dtor_value(), outer, dafny.DafnyMap.fromElements());
    }
  }
  public static boolean IsSigned(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig outer, dafny.DafnySequence<? extends TermLoc_Compile.Selector> loc)
  {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig _pat_let_tv0 = outer;
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig _pat_let_tv1 = outer;
    return (true) && (((boolean)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Character>, Boolean>Let((((TermLoc_Compile.Selector)(java.lang.Object)((loc).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key(), boxed30 -> {
      dafny.DafnySequence<? extends Character> _pat_let15_0 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(boxed30));
      return ((boolean)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Character>, Boolean>Let(_pat_let15_0, boxed31 -> {
        dafny.DafnySequence<? extends Character> _1060_name = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(boxed31));
        return (((_pat_let_tv0).dtor_attributeActions()).<dafny.DafnySequence<? extends Character>>contains(_1060_name)) && (!java.util.Objects.equals(((Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction)(java.lang.Object)(((_pat_let_tv1).dtor_attributeActions()).get(_1060_name))), Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction.create_DO__NOTHING()));
      }
      )));
    }
    ))));
  }
  public static boolean IsSignOnly(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig outer, dafny.DafnySequence<? extends TermLoc_Compile.Selector> loc)
  {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig _pat_let_tv2 = outer;
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig _pat_let_tv3 = outer;
    return (true) && (((boolean)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Character>, Boolean>Let((((TermLoc_Compile.Selector)(java.lang.Object)((loc).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key(), boxed32 -> {
      dafny.DafnySequence<? extends Character> _pat_let16_0 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(boxed32));
      return ((boolean)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Character>, Boolean>Let(_pat_let16_0, boxed33 -> {
        dafny.DafnySequence<? extends Character> _1061_name = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(boxed33));
        return (((_pat_let_tv2).dtor_attributeActions()).<dafny.DafnySequence<? extends Character>>contains(_1061_name)) && (java.util.Objects.equals(((Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction)(java.lang.Object)(((_pat_let_tv3).dtor_attributeActions()).get(_1061_name))), Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction.create_SIGN__ONLY()));
      }
      )));
    }
    ))));
  }
  public static boolean IsEncrypted(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig outer, dafny.DafnySequence<? extends TermLoc_Compile.Selector> loc)
  {
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig _pat_let_tv4 = outer;
    Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig _pat_let_tv5 = outer;
    return (true) && (((boolean)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Character>, Boolean>Let((((TermLoc_Compile.Selector)(java.lang.Object)((loc).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key(), boxed34 -> {
      dafny.DafnySequence<? extends Character> _pat_let17_0 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(boxed34));
      return ((boolean)(java.lang.Object)(dafny.Helpers.<dafny.DafnySequence<? extends Character>, Boolean>Let(_pat_let17_0, boxed35 -> {
        dafny.DafnySequence<? extends Character> _1062_name = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(boxed35));
        return (((_pat_let_tv4).dtor_attributeActions()).<dafny.DafnySequence<? extends Character>>contains(_1062_name)) && (java.util.Objects.equals(((Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction)(java.lang.Object)(((_pat_let_tv5).dtor_attributeActions()).get(_1062_name))), Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction.create_ENCRYPT__AND__SIGN()));
      }
      )));
    }
    ))));
  }
  public static boolean IsEncryptedV(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig outer, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> virtualFields, dafny.DafnySequence<? extends TermLoc_Compile.Selector> loc)
  {
    return (__default.IsEncrypted(outer, loc)) || (((virtualFields).<dafny.DafnySequence<? extends Character>>contains((((TermLoc_Compile.Selector)(java.lang.Object)((loc).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key())) && ((((DdbVirtualFields_Compile.VirtField)(java.lang.Object)((virtualFields).get((((TermLoc_Compile.Selector)(java.lang.Object)((loc).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key())))).examine(((java.util.function.Function<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig, java.util.function.Function<dafny.DafnySequence<? extends TermLoc_Compile.Selector>, Boolean>>)(_1063_outer) -> ((java.util.function.Function<dafny.DafnySequence<? extends TermLoc_Compile.Selector>, Boolean>)(_1064_t_boxed0) -> {
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _1064_t = ((dafny.DafnySequence<? extends TermLoc_Compile.Selector>)(java.lang.Object)(_1064_t_boxed0));
      return __default.IsEncrypted(_1063_outer, _1064_t);
    })).apply(outer))));
  }
  public static Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> BeaconNameAllowed(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig outer, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> virtualFields, dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends Character> context, boolean isSignedBeacon)
  {
    if ((((outer).dtor_attributeActions()).<dafny.DafnySequence<? extends Character>>contains(name)) && (!java.util.Objects.equals(((Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction)(java.lang.Object)(((outer).dtor_attributeActions()).get(name))), Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction.create_ENCRYPT__AND__SIGN()))) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(name, dafny.DafnySequence.asString(" not allowed as a ")), context), dafny.DafnySequence.asString(" because it is already an unencrypted attribute."))));
    } else if ((isSignedBeacon) && (((outer).dtor_attributeActions()).<dafny.DafnySequence<? extends Character>>contains(name))) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(name, dafny.DafnySequence.asString(" not allowed as a ")), context), dafny.DafnySequence.asString(" because a fully nonsensitive beacon cannot have the same name as an existing attribute."))));
    } else if ((((outer).dtor_allowedUnauthenticatedAttributes()).is_Some()) && ((((outer).dtor_allowedUnauthenticatedAttributes()).dtor_value()).contains(name))) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(name, dafny.DafnySequence.asString(" not allowed as a ")), context), dafny.DafnySequence.asString(" because it is already an allowed unauthenticated attribute."))));
    } else if ((((outer).dtor_allowedUnauthenticatedAttributePrefix()).is_Some()) && ((((outer).dtor_allowedUnauthenticatedAttributePrefix()).dtor_value()).isPrefixOf(name))) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(name, dafny.DafnySequence.asString(" not allowed as a ")), context), dafny.DafnySequence.asString(" because it begins with the allowed unauthenticated prefix."))));
    } else if ((DynamoDbEncryptionUtil_Compile.__default.ReservedPrefix()).isPrefixOf(name)) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(name, dafny.DafnySequence.asString(" not allowed as a ")), context), dafny.DafnySequence.asString(" because it begins with the reserved prefix."))));
    } else {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    }
  }
  public static Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> VirtualFieldNameAllowed(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig outer, dafny.DafnySequence<? extends Character> name)
  {
    if (((outer).dtor_attributeActions()).<dafny.DafnySequence<? extends Character>>contains(name)) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(name, dafny.DafnySequence.asString(" not allowed as a Virtual Field because it is already a configured attribute."))));
    } else if ((((outer).dtor_allowedUnauthenticatedAttributes()).is_Some()) && ((((outer).dtor_allowedUnauthenticatedAttributes()).dtor_value()).contains(name))) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(name, dafny.DafnySequence.asString(" not allowed as a Virtual Field because it is already an allowed unauthenticated attribute."))));
    } else if ((((outer).dtor_allowedUnauthenticatedAttributePrefix()).is_Some()) && ((((outer).dtor_allowedUnauthenticatedAttributePrefix()).dtor_value()).isPrefixOf(name))) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(name, dafny.DafnySequence.asString(" not allowed as a Virtual Field because it begins with the allowed unauthenticated prefix."))));
    } else if ((DynamoDbEncryptionUtil_Compile.__default.ReservedPrefix()).isPrefixOf(name)) {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(name, dafny.DafnySequence.asString(" not allowed as a Virtual Field because it begins with the reserved prefix."))));
    } else {
      return Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(true);
    }
  }
  public static Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> FindVirtualFieldWithThisLocation(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> fields, dafny.DafnySet<? extends dafny.DafnySequence<? extends TermLoc_Compile.Selector>> locs)
  {
    dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> _1065_badNames = ((dafny.Function2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField>, dafny.DafnySet<? extends dafny.DafnySequence<? extends TermLoc_Compile.Selector>>, dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>>>)(_1066_fields, _1067_locs) -> ((dafny.Function0<dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>>>)(() -> {
      java.util.ArrayList<dafny.DafnySequence<? extends Character>> _coll26 = new java.util.ArrayList<>();
      for (dafny.DafnySequence<? extends Character> _compr_27_boxed0 : (_1066_fields).keySet().Elements()) {
        dafny.DafnySequence<? extends Character> _compr_27 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_compr_27_boxed0));
        if (true) {
          dafny.DafnySequence<? extends Character> _1068_b = (dafny.DafnySequence<? extends Character>)_compr_27;
          if (((_1066_fields).<dafny.DafnySequence<? extends Character>>contains(_1068_b)) && (((((DdbVirtualFields_Compile.VirtField)(java.lang.Object)((_1066_fields).get(_1068_b)))).GetLocs()).equals(_1067_locs))) {
            _coll26.add(_1068_b);
          }
        }
      }
      return new dafny.DafnySet<dafny.DafnySequence<? extends Character>>(_coll26);
    })).apply()).apply(fields, locs);
    if ((java.math.BigInteger.valueOf((_1065_badNames).size())).signum() == 0) {
      return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None();
    } else {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1069_badSeq = Sets.__default.<Character>SetToOrderedSequence2(dafny.TypeDescriptor.CHAR, _1065_badNames, DynamoDbEncryptionUtil_Compile.__default::CharLess);
      return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((_1069_badSeq).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))));
    }
  }
  public static boolean ExistsConstructorWithTheseRequired(dafny.DafnySequence<? extends CompoundBeacon_Compile.Constructor> cons, dafny.DafnySet<? extends CompoundBeacon_Compile.BeaconPart> locs)
  {
    return (__default.<CompoundBeacon_Compile.Constructor>SeqCount(CompoundBeacon_Compile.Constructor._typeDescriptor(), ((java.util.function.Function<dafny.DafnySet<? extends CompoundBeacon_Compile.BeaconPart>, java.util.function.Function<CompoundBeacon_Compile.Constructor, Boolean>>)(_1070_locs) -> ((java.util.function.Function<CompoundBeacon_Compile.Constructor, Boolean>)(_1071_c_boxed0) -> {
      CompoundBeacon_Compile.Constructor _1071_c = ((CompoundBeacon_Compile.Constructor)(java.lang.Object)(_1071_c_boxed0));
      return ((_1071_c).getReqParts()).equals(_1070_locs);
    })).apply(locs), cons)).signum() == 1;
  }
  public static dafny.DafnySequence<? extends Character> getPartsString(CompoundBeacon_Compile.Constructor c) {
    dafny.DafnySequence<? extends CompoundBeacon_Compile.ConstructorPart> _1072_req = Seq_Compile.__default.<CompoundBeacon_Compile.ConstructorPart>Filter(CompoundBeacon_Compile.ConstructorPart._typeDescriptor(), ((java.util.function.Function<CompoundBeacon_Compile.ConstructorPart, Boolean>)(_1073_p_boxed0) -> {
      CompoundBeacon_Compile.ConstructorPart _1073_p = ((CompoundBeacon_Compile.ConstructorPart)(java.lang.Object)(_1073_p_boxed0));
      return (_1073_p).dtor_required();
    }), (c).dtor_parts());
    dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1074_names = Seq_Compile.__default.<CompoundBeacon_Compile.ConstructorPart, dafny.DafnySequence<? extends Character>>Map(CompoundBeacon_Compile.ConstructorPart._typeDescriptor(), dafny.DafnySequence.<Character>_typeDescriptor(dafny.TypeDescriptor.CHAR), ((java.util.function.Function<CompoundBeacon_Compile.ConstructorPart, dafny.DafnySequence<? extends Character>>)(_1075_p_boxed0) -> {
      CompoundBeacon_Compile.ConstructorPart _1075_p = ((CompoundBeacon_Compile.ConstructorPart)(java.lang.Object)(_1075_p_boxed0));
      return ((_1075_p).dtor_part()).getName();
    }), _1072_req);
    if ((java.math.BigInteger.valueOf((_1074_names).length())).signum() == 0) {
      return dafny.DafnySequence.asString("");
    } else {
      return StandardLibrary_Compile.__default.<Character>Join(dafny.TypeDescriptor.CHAR, _1074_names, dafny.DafnySequence.asString(", "));
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> AddVirtualFields(dafny.DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualField> vf, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig outer, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> converted)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((vf).length())).signum() == 0) {
        return Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(converted);
      } else {
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1076_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), !(converted).<dafny.DafnySequence<? extends Character>>contains((((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualField)(java.lang.Object)((vf).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name()), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Duplicate VirtualField name : "), (((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualField)(java.lang.Object)((vf).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name())));
        if ((_1076_valueOrError0).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          return (_1076_valueOrError0).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField>>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), DdbVirtualFields_Compile.VirtualFieldMap._typeDescriptor());
        } else {
          Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1077_valueOrError1 = __default.VirtualFieldNameAllowed(outer, (((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualField)(java.lang.Object)((vf).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name());
          if ((_1077_valueOrError1).IsFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
            return (_1077_valueOrError1).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField>>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), DdbVirtualFields_Compile.VirtualFieldMap._typeDescriptor());
          } else {
            boolean _1078___v0 = (_1077_valueOrError1).Extract(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
            Wrappers_Compile.Result<DdbVirtualFields_Compile.VirtField, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1079_valueOrError2 = DdbVirtualFields_Compile.__default.ParseVirtualFieldConfig(((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualField)(java.lang.Object)((vf).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))));
            if ((_1079_valueOrError2).IsFailure(DdbVirtualFields_Compile.VirtField._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
              return (_1079_valueOrError2).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField>>PropagateFailure(DdbVirtualFields_Compile.VirtField._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), DdbVirtualFields_Compile.VirtualFieldMap._typeDescriptor());
            } else {
              DdbVirtualFields_Compile.VirtField _1080_newField = (_1079_valueOrError2).Extract(DdbVirtualFields_Compile.VirtField._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
              Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1081_valueOrError3 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), !((_1080_newField).examine(((java.util.function.Function<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig, java.util.function.Function<dafny.DafnySequence<? extends TermLoc_Compile.Selector>, Boolean>>)(_1082_outer) -> ((java.util.function.Function<dafny.DafnySequence<? extends TermLoc_Compile.Selector>, Boolean>)(_1083_t_boxed0) -> {
                dafny.DafnySequence<? extends TermLoc_Compile.Selector> _1083_t = ((dafny.DafnySequence<? extends TermLoc_Compile.Selector>)(java.lang.Object)(_1083_t_boxed0));
                return !(__default.IsSigned(_1082_outer, _1083_t));
              })).apply(outer))), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("VirtualField "), (((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualField)(java.lang.Object)((vf).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name()), dafny.DafnySequence.asString(" must be defined on signed fields."))));
              if ((_1081_valueOrError3).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
                return (_1081_valueOrError3).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField>>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), DdbVirtualFields_Compile.VirtualFieldMap._typeDescriptor());
              } else {
                Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _1084_badField = __default.FindVirtualFieldWithThisLocation(converted, (_1080_newField).GetLocs());
                if ((_1084_badField).is_Some()) {
                  return Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Virtual field "), (((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualField)(java.lang.Object)((vf).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name()), dafny.DafnySequence.asString(" is defined on the same locations as ")), (_1084_badField).dtor_value()), dafny.DafnySequence.asString("."))));
                } else {
                  dafny.DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualField> _in157 = (vf).drop(java.math.BigInteger.ONE);
                  Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig _in158 = outer;
                  dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> _in159 = dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, DdbVirtualFields_Compile.VirtField>update(converted, (((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualField)(java.lang.Object)((vf).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name(), _1080_newField);
                  vf = _in157;
                  outer = _in158;
                  converted = _in159;
                  continue TAIL_CALL_START;
                }
              }
            }
          }
        }
      }
    }
  }
  public static Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> FindBeaconWithThisLocation(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon> beacons, dafny.DafnySequence<? extends TermLoc_Compile.Selector> loc)
  {
    dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>> _1085_badNames = ((dafny.Function2<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, dafny.DafnySequence<? extends TermLoc_Compile.Selector>, dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>>>)(_1086_beacons, _1087_loc) -> ((dafny.Function0<dafny.DafnySet<? extends dafny.DafnySequence<? extends Character>>>)(() -> {
      java.util.ArrayList<dafny.DafnySequence<? extends Character>> _coll27 = new java.util.ArrayList<>();
      for (dafny.DafnySequence<? extends Character> _compr_28_boxed0 : (_1086_beacons).keySet().Elements()) {
        dafny.DafnySequence<? extends Character> _compr_28 = ((dafny.DafnySequence<? extends Character>)(java.lang.Object)(_compr_28_boxed0));
        if (true) {
          dafny.DafnySequence<? extends Character> _1088_b = (dafny.DafnySequence<? extends Character>)_compr_28;
          if (((_1086_beacons).<dafny.DafnySequence<? extends Character>>contains(_1088_b)) && (((((SearchableEncryptionInfo_Compile.Beacon)(java.lang.Object)((_1086_beacons).get(_1088_b)))).is_Standard()) && ((((((SearchableEncryptionInfo_Compile.Beacon)(java.lang.Object)((_1086_beacons).get(_1088_b)))).dtor_std()).dtor_loc()).equals(_1087_loc)))) {
            _coll27.add(_1088_b);
          }
        }
      }
      return new dafny.DafnySet<dafny.DafnySequence<? extends Character>>(_coll27);
    })).apply()).apply(beacons, loc);
    if ((java.math.BigInteger.valueOf((_1085_badNames).size())).signum() == 0) {
      return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_None();
    } else {
      dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> _1089_badSeq = Sets.__default.<Character>SetToOrderedSequence2(dafny.TypeDescriptor.CHAR, _1085_badNames, DynamoDbEncryptionUtil_Compile.__default::CharLess);
      return Wrappers_Compile.Option.<dafny.DafnySequence<? extends Character>>create_Some(((dafny.DafnySequence<? extends Character>)(java.lang.Object)((_1089_badSeq).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))));
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> AddStandardBeacons(dafny.DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.StandardBeacon> beacons, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig outer, Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient client, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> virtualFields, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon> converted)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> output = (Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)null;
    if(true) {
      if ((java.math.BigInteger.valueOf((beacons).length())).signum() == 0) {
        output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(converted);
        return output;
      }
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1090_valueOrError0 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default();
      _1090_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), !(converted).<dafny.DafnySequence<? extends Character>>contains((((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.StandardBeacon)(java.lang.Object)((beacons).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name()), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Duplicate StandardBeacon name : "), (((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.StandardBeacon)(java.lang.Object)((beacons).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name())));
      if ((_1090_valueOrError0).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        output = (_1090_valueOrError0).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.BeaconMap._typeDescriptor());
        return output;
      }
      boolean _1091___v1;
      Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1092_valueOrError1 = Wrappers_Compile.Result.<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default(false);
      _1092_valueOrError1 = __default.BeaconNameAllowed(outer, virtualFields, (((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.StandardBeacon)(java.lang.Object)((beacons).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name(), dafny.DafnySequence.asString("StandardBeacon"), false);
      if ((_1092_valueOrError1).IsFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        output = (_1092_valueOrError1).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.BeaconMap._typeDescriptor());
        return output;
      }
      _1091___v1 = (_1092_valueOrError1).Extract(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
      dafny.DafnySequence<? extends Character> _1093_locString;
      _1093_locString = __default.GetLocStr((((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.StandardBeacon)(java.lang.Object)((beacons).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name(), (((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.StandardBeacon)(java.lang.Object)((beacons).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_loc());
      BaseBeacon_Compile.StandardBeacon _1094_newBeacon;
      Wrappers_Compile.Result<BaseBeacon_Compile.StandardBeacon, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1095_valueOrError2 = (Wrappers_Compile.Result<BaseBeacon_Compile.StandardBeacon, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)null;
      _1095_valueOrError2 = BaseBeacon_Compile.__default.MakeStandardBeacon(client, (((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.StandardBeacon)(java.lang.Object)((beacons).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name(), ((byte) ((((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.StandardBeacon)(java.lang.Object)((beacons).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_length())), _1093_locString);
      if ((_1095_valueOrError2).IsFailure(BaseBeacon_Compile.ValidStandardBeacon._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        output = (_1095_valueOrError2).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>>PropagateFailure(BaseBeacon_Compile.ValidStandardBeacon._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.BeaconMap._typeDescriptor());
        return output;
      }
      _1094_newBeacon = (_1095_valueOrError2).Extract(BaseBeacon_Compile.ValidStandardBeacon._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1096_valueOrError3 = Wrappers_Compile.Outcome.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Default();
      _1096_valueOrError3 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), __default.IsEncryptedV(outer, virtualFields, (_1094_newBeacon).dtor_loc()), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("StandardBeacon "), (((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.StandardBeacon)(java.lang.Object)((beacons).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name()), dafny.DafnySequence.asString(" not defined on an encrypted field."))));
      if ((_1096_valueOrError3).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        output = (_1096_valueOrError3).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.BeaconMap._typeDescriptor());
        return output;
      }
      Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _1097_badBeacon;
      _1097_badBeacon = __default.FindBeaconWithThisLocation(converted, (_1094_newBeacon).dtor_loc());
      if ((_1097_badBeacon).is_Some()) {
        output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Beacon "), (((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.StandardBeacon)(java.lang.Object)((beacons).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name()), dafny.DafnySequence.asString(" is defined on location ")), TermLoc_Compile.__default.TermLocToString((_1094_newBeacon).dtor_loc())), dafny.DafnySequence.asString(", but beacon ")), (_1097_badBeacon).dtor_value()), dafny.DafnySequence.asString(" is already defined on that location."))));
        return output;
      }
      Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> _1098_badField;
      _1098_badField = __default.FindVirtualFieldWithThisLocation(virtualFields, dafny.DafnySet.of((_1094_newBeacon).dtor_loc()));
      if ((_1098_badField).is_Some()) {
        output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Beacon "), (((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.StandardBeacon)(java.lang.Object)((beacons).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name()), dafny.DafnySequence.asString(" is defined on location ")), TermLoc_Compile.__default.TermLocToString((_1094_newBeacon).dtor_loc())), dafny.DafnySequence.asString(", but virtual field ")), (_1098_badField).dtor_value()), dafny.DafnySequence.asString(" is already defined on that single location."))));
        return output;
      }
      Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out60;
      _out60 = __default.AddStandardBeacons((beacons).drop(java.math.BigInteger.ONE), outer, client, virtualFields, dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, SearchableEncryptionInfo_Compile.Beacon>update(converted, (((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.StandardBeacon)(java.lang.Object)((beacons).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name(), SearchableEncryptionInfo_Compile.Beacon.create_Standard(_1094_newBeacon)));
      output = _out60;
    }
    return output;
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends TermLoc_Compile.Selector>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> GetLoc(dafny.DafnySequence<? extends Character> name, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> loc)
  {
    if ((loc).is_None()) {
      return Wrappers_Compile.Result.<dafny.DafnySequence<? extends TermLoc_Compile.Selector>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(TermLoc_Compile.__default.TermLocMap(name));
    } else {
      return TermLoc_Compile.__default.MakeTermLoc((loc).dtor_value());
    }
  }
  public static dafny.DafnySequence<? extends Character> GetLocStr(dafny.DafnySequence<? extends Character> name, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> loc)
  {
    if ((loc).is_None()) {
      return name;
    } else {
      return (loc).dtor_value();
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> AddNonSensitiveParts(dafny.DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.NonSensitivePart> parts, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig outer, java.math.BigInteger origSize, dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart> converted)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((parts).length())).signum() == 0) {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(converted);
      } else {
        Wrappers_Compile.Result<dafny.DafnySequence<? extends TermLoc_Compile.Selector>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1099_valueOrError0 = __default.GetLoc((((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.NonSensitivePart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name(), (((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.NonSensitivePart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_loc());
        if ((_1099_valueOrError0).IsFailure(TermLoc_Compile.TermLoc._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          return (_1099_valueOrError0).<dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart>>PropagateFailure(TermLoc_Compile.TermLoc._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<CompoundBeacon_Compile.BeaconPart>_typeDescriptor(CompoundBeacon_Compile.BeaconPart._typeDescriptor()));
        } else {
          dafny.DafnySequence<? extends TermLoc_Compile.Selector> _1100_loc = (_1099_valueOrError0).Extract(TermLoc_Compile.TermLoc._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
          CompoundBeacon_Compile.BeaconPart _1101_newPart = CompoundBeacon_Compile.BeaconPart.create_NonSensitive((((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.NonSensitivePart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_prefix(), (((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.NonSensitivePart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name(), _1100_loc);
          Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1102_valueOrError1 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), __default.IsSignOnly(outer, (_1101_newPart).dtor_loc()), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("NonSensitive Part "), (_1101_newPart).dtor_name()), dafny.DafnySequence.asString(" is built from ")), __default.GetLocStr((((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.NonSensitivePart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name(), (((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.NonSensitivePart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_loc())), dafny.DafnySequence.asString(" which is not SIGN_ONLY."))));
          if ((_1102_valueOrError1).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
            return (_1102_valueOrError1).<dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart>>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<CompoundBeacon_Compile.BeaconPart>_typeDescriptor(CompoundBeacon_Compile.BeaconPart._typeDescriptor()));
          } else {
            dafny.DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.NonSensitivePart> _in160 = (parts).drop(java.math.BigInteger.ONE);
            Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig _in161 = outer;
            java.math.BigInteger _in162 = origSize;
            dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart> _in163 = dafny.DafnySequence.<CompoundBeacon_Compile.BeaconPart>concatenate(converted, dafny.DafnySequence.of(CompoundBeacon_Compile.BeaconPart._typeDescriptor(), _1101_newPart));
            parts = _in160;
            outer = _in161;
            origSize = _in162;
            converted = _in163;
            continue TAIL_CALL_START;
          }
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> AddSensitiveParts(dafny.DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.SensitivePart> parts, dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart> converted, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon> std)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((parts).length())).signum() == 0) {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(converted);
      } else if (((std).<dafny.DafnySequence<? extends Character>>contains((((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.SensitivePart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name())) && ((((SearchableEncryptionInfo_Compile.Beacon)(java.lang.Object)((std).get((((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.SensitivePart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name())))).is_Standard())) {
        CompoundBeacon_Compile.BeaconPart _1103_newPart = CompoundBeacon_Compile.BeaconPart.create_Sensitive((((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.SensitivePart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_prefix(), (((SearchableEncryptionInfo_Compile.Beacon)(java.lang.Object)((std).get((((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.SensitivePart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name())))).dtor_std());
        dafny.DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.SensitivePart> _in164 = (parts).drop(java.math.BigInteger.ONE);
        dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart> _in165 = dafny.DafnySequence.<CompoundBeacon_Compile.BeaconPart>concatenate(converted, dafny.DafnySequence.of(CompoundBeacon_Compile.BeaconPart._typeDescriptor(), _1103_newPart));
        dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon> _in166 = std;
        parts = _in164;
        converted = _in165;
        std = _in166;
        continue TAIL_CALL_START;
      } else {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Sensitive part needs standard beacon "), (((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.SensitivePart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name()), dafny.DafnySequence.asString(" which is not configured."))));
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends CompoundBeacon_Compile.Constructor>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> MakeDefaultConstructor(dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart> parts, dafny.DafnySequence<? extends CompoundBeacon_Compile.ConstructorPart> converted)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((parts).length())).signum() == 0) {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends CompoundBeacon_Compile.Constructor>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(dafny.DafnySequence.of(CompoundBeacon_Compile.Constructor._typeDescriptor(), CompoundBeacon_Compile.Constructor.create(converted)));
      } else {
        dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart> _in167 = (parts).drop(java.math.BigInteger.ONE);
        dafny.DafnySequence<? extends CompoundBeacon_Compile.ConstructorPart> _in168 = dafny.DafnySequence.<CompoundBeacon_Compile.ConstructorPart>concatenate(converted, dafny.DafnySequence.of(CompoundBeacon_Compile.ConstructorPart._typeDescriptor(), CompoundBeacon_Compile.ConstructorPart.create(((CompoundBeacon_Compile.BeaconPart)(java.lang.Object)((parts).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), true)));
        parts = _in167;
        converted = _in168;
        continue TAIL_CALL_START;
      }
    }
  }
  public static <__T> dafny.DafnySequence<? extends __T> MyFilter(dafny.TypeDescriptor<__T> _td___T, java.util.function.Function<__T, Boolean> f, dafny.DafnySequence<? extends __T> xs)
  {
    dafny.DafnySequence<? extends __T> _1104___accumulator = dafny.DafnySequence.<__T> empty(_td___T);
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((xs).length())).signum() == 0) {
        return dafny.DafnySequence.<__T>concatenate(_1104___accumulator, dafny.DafnySequence.<__T> empty(_td___T));
      } else {
        _1104___accumulator = dafny.DafnySequence.<__T>concatenate(_1104___accumulator, ((((boolean)(java.lang.Object)((f).apply(((__T)(java.lang.Object)((xs).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))))) ? (dafny.DafnySequence.of(_td___T, ((__T)(java.lang.Object)((xs).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))) : (dafny.DafnySequence.<__T> empty(_td___T))));
        java.util.function.Function<__T, Boolean> _in169 = f;
        dafny.DafnySequence<? extends __T> _in170 = (xs).drop(java.math.BigInteger.ONE);
        f = _in169;
        xs = _in170;
        continue TAIL_CALL_START;
      }
    }
  }
  public static <__T> java.math.BigInteger SeqCount(dafny.TypeDescriptor<__T> _td___T, java.util.function.Function<__T, Boolean> f, dafny.DafnySequence<? extends __T> xs)
  {
    java.math.BigInteger _1105___accumulator = java.math.BigInteger.ZERO;
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((xs).length())).signum() == 0) {
        return (java.math.BigInteger.ZERO).add(_1105___accumulator);
      } else {
        _1105___accumulator = (_1105___accumulator).add(((((boolean)(java.lang.Object)((f).apply(((__T)(java.lang.Object)((xs).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))))))) ? (java.math.BigInteger.ONE) : (java.math.BigInteger.ZERO)));
        java.util.function.Function<__T, Boolean> _in171 = f;
        dafny.DafnySequence<? extends __T> _in172 = (xs).drop(java.math.BigInteger.ONE);
        f = _in171;
        xs = _in172;
        continue TAIL_CALL_START;
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends CompoundBeacon_Compile.ConstructorPart>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> MakeConstructor2(dafny.DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ConstructorPart> c, dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart> parts, java.math.BigInteger origSize, dafny.DafnySequence<? extends CompoundBeacon_Compile.ConstructorPart> converted)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((c).length())).signum() == 0) {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends CompoundBeacon_Compile.ConstructorPart>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(converted);
      } else {
        dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart> _1106_thePart = __default.<CompoundBeacon_Compile.BeaconPart>MyFilter(CompoundBeacon_Compile.BeaconPart._typeDescriptor(), ((java.util.function.Function<dafny.DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ConstructorPart>, java.util.function.Function<CompoundBeacon_Compile.BeaconPart, Boolean>>)(_1107_c) -> ((java.util.function.Function<CompoundBeacon_Compile.BeaconPart, Boolean>)(_1108_p_boxed0) -> {
          CompoundBeacon_Compile.BeaconPart _1108_p = ((CompoundBeacon_Compile.BeaconPart)(java.lang.Object)(_1108_p_boxed0));
          return ((_1108_p).getName()).equals((((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ConstructorPart)(java.lang.Object)((_1107_c).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name());
        })).apply(c), parts);
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1109_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), (java.math.BigInteger.valueOf((_1106_thePart).length())).signum() == 1, DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Constructor refers to part name "), (((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ConstructorPart)(java.lang.Object)((c).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name()), dafny.DafnySequence.asString(" but there is no part by that name."))));
        if ((_1109_valueOrError0).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          return (_1109_valueOrError0).<dafny.DafnySequence<? extends CompoundBeacon_Compile.ConstructorPart>>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<CompoundBeacon_Compile.ConstructorPart>_typeDescriptor(CompoundBeacon_Compile.ConstructorPart._typeDescriptor()));
        } else {
          CompoundBeacon_Compile.ConstructorPart _1110_newPart = CompoundBeacon_Compile.ConstructorPart.create(((CompoundBeacon_Compile.BeaconPart)(java.lang.Object)((_1106_thePart).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), (((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ConstructorPart)(java.lang.Object)((c).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_required());
          dafny.DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ConstructorPart> _in173 = (c).drop(java.math.BigInteger.ONE);
          dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart> _in174 = parts;
          java.math.BigInteger _in175 = origSize;
          dafny.DafnySequence<? extends CompoundBeacon_Compile.ConstructorPart> _in176 = dafny.DafnySequence.<CompoundBeacon_Compile.ConstructorPart>concatenate(converted, dafny.DafnySequence.of(CompoundBeacon_Compile.ConstructorPart._typeDescriptor(), _1110_newPart));
          c = _in173;
          parts = _in174;
          origSize = _in175;
          converted = _in176;
          continue TAIL_CALL_START;
        }
      }
    }
  }
  public static Wrappers_Compile.Result<CompoundBeacon_Compile.Constructor, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> MakeConstructor(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Constructor c, dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart> parts)
  {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends CompoundBeacon_Compile.ConstructorPart>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1111_valueOrError0 = __default.MakeConstructor2((c).dtor_parts(), parts, java.math.BigInteger.valueOf(((c).dtor_parts()).length()), dafny.DafnySequence.<CompoundBeacon_Compile.ConstructorPart> empty(CompoundBeacon_Compile.ConstructorPart._typeDescriptor()));
    if ((_1111_valueOrError0).IsFailure(dafny.DafnySequence.<CompoundBeacon_Compile.ConstructorPart>_typeDescriptor(CompoundBeacon_Compile.ConstructorPart._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
      return (_1111_valueOrError0).<CompoundBeacon_Compile.Constructor>PropagateFailure(dafny.DafnySequence.<CompoundBeacon_Compile.ConstructorPart>_typeDescriptor(CompoundBeacon_Compile.ConstructorPart._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), CompoundBeacon_Compile.Constructor._typeDescriptor());
    } else {
      dafny.DafnySequence<? extends CompoundBeacon_Compile.ConstructorPart> _1112_newParts = (_1111_valueOrError0).Extract(dafny.DafnySequence.<CompoundBeacon_Compile.ConstructorPart>_typeDescriptor(CompoundBeacon_Compile.ConstructorPart._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
      return Wrappers_Compile.Result.<CompoundBeacon_Compile.Constructor, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(CompoundBeacon_Compile.Constructor.create(_1112_newParts));
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends CompoundBeacon_Compile.Constructor>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> AddConstructors2(dafny.DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Constructor> constructors, dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart> parts, java.math.BigInteger origSize, dafny.DafnySequence<? extends CompoundBeacon_Compile.Constructor> converted)
  {
    TAIL_CALL_START: while (true) {
      if ((java.math.BigInteger.valueOf((constructors).length())).signum() == 0) {
        return Wrappers_Compile.Result.<dafny.DafnySequence<? extends CompoundBeacon_Compile.Constructor>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(converted);
      } else {
        Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1113_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), (java.math.BigInteger.valueOf(((((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Constructor)(java.lang.Object)((constructors).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_parts()).length())).signum() == 1, DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Every constructor must have at least one part.")));
        if ((_1113_valueOrError0).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          return (_1113_valueOrError0).<dafny.DafnySequence<? extends CompoundBeacon_Compile.Constructor>>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<CompoundBeacon_Compile.Constructor>_typeDescriptor(CompoundBeacon_Compile.Constructor._typeDescriptor()));
        } else {
          Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1114_valueOrError1 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), (__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ConstructorPart>SeqCount(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ConstructorPart._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ConstructorPart, Boolean>)(_1115_p_boxed0) -> {
            Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ConstructorPart _1115_p = ((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.ConstructorPart)(java.lang.Object)(_1115_p_boxed0));
            return (_1115_p).dtor_required();
          }), (((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Constructor)(java.lang.Object)((constructors).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_parts())).signum() == 1, DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("A Constructor for beacon "), name), dafny.DafnySequence.asString(" lacks any required parts"))));
          if ((_1114_valueOrError1).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
            return (_1114_valueOrError1).<dafny.DafnySequence<? extends CompoundBeacon_Compile.Constructor>>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<CompoundBeacon_Compile.Constructor>_typeDescriptor(CompoundBeacon_Compile.Constructor._typeDescriptor()));
          } else {
            Wrappers_Compile.Result<CompoundBeacon_Compile.Constructor, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1116_valueOrError2 = __default.MakeConstructor(((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Constructor)(java.lang.Object)((constructors).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), parts);
            if ((_1116_valueOrError2).IsFailure(CompoundBeacon_Compile.Constructor._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
              return (_1116_valueOrError2).<dafny.DafnySequence<? extends CompoundBeacon_Compile.Constructor>>PropagateFailure(CompoundBeacon_Compile.Constructor._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), dafny.DafnySequence.<CompoundBeacon_Compile.Constructor>_typeDescriptor(CompoundBeacon_Compile.Constructor._typeDescriptor()));
            } else {
              CompoundBeacon_Compile.Constructor _1117_c = (_1116_valueOrError2).Extract(CompoundBeacon_Compile.Constructor._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
              if (__default.ExistsConstructorWithTheseRequired(converted, (_1117_c).getReqParts())) {
                dafny.DafnySequence<? extends Character> _1118_p = __default.getPartsString(_1117_c);
                return Wrappers_Compile.Result.<dafny.DafnySequence<? extends CompoundBeacon_Compile.Constructor>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Failure(DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Multiple constructors for "), name), dafny.DafnySequence.asString(" have the same set of required parts : ")), _1118_p)));
              } else {
                dafny.DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Constructor> _in177 = (constructors).drop(java.math.BigInteger.ONE);
                dafny.DafnySequence<? extends Character> _in178 = name;
                dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart> _in179 = parts;
                java.math.BigInteger _in180 = origSize;
                dafny.DafnySequence<? extends CompoundBeacon_Compile.Constructor> _in181 = dafny.DafnySequence.<CompoundBeacon_Compile.Constructor>concatenate(converted, dafny.DafnySequence.of(CompoundBeacon_Compile.Constructor._typeDescriptor(), _1117_c));
                constructors = _in177;
                name = _in178;
                parts = _in179;
                origSize = _in180;
                converted = _in181;
                continue TAIL_CALL_START;
              }
            }
          }
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnySequence<? extends CompoundBeacon_Compile.Constructor>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> AddConstructors(Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Constructor>> constructors, dafny.DafnySequence<? extends Character> name, dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart> parts)
  {
    if ((constructors).is_None()) {
      return __default.MakeDefaultConstructor(parts, dafny.DafnySequence.<CompoundBeacon_Compile.ConstructorPart> empty(CompoundBeacon_Compile.ConstructorPart._typeDescriptor()));
    } else {
      return __default.AddConstructors2((constructors).dtor_value(), name, parts, java.math.BigInteger.valueOf(((constructors).dtor_value()).length()), dafny.DafnySequence.<CompoundBeacon_Compile.Constructor> empty(CompoundBeacon_Compile.Constructor._typeDescriptor()));
    }
  }
  public static Wrappers_Compile.Result<CompoundBeacon_Compile.CompoundBeacon, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> CreateCompoundBeacon(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CompoundBeacon beacon, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig outer, Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient client, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> virtualFields, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon> converted)
  {
    dafny.DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.NonSensitivePart> _1119_nonSensitive = ((((beacon).dtor_nonSensitive()).is_Some()) ? (((beacon).dtor_nonSensitive()).dtor_value()) : (dafny.DafnySequence.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.NonSensitivePart> empty(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.NonSensitivePart._typeDescriptor())));
    dafny.DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.SensitivePart> _1120_sensitive = ((((beacon).dtor_sensitive()).is_Some()) ? (((beacon).dtor_sensitive()).dtor_value()) : (dafny.DafnySequence.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.SensitivePart> empty(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.SensitivePart._typeDescriptor())));
    boolean _1121_isSignedBeacon = (java.math.BigInteger.valueOf((_1120_sensitive).length())).signum() == 0;
    Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1122_valueOrError0 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), !(converted).<dafny.DafnySequence<? extends Character>>contains((beacon).dtor_name()), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("Duplicate CompoundBeacon name : "), (beacon).dtor_name())));
    if ((_1122_valueOrError0).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
      return (_1122_valueOrError0).<CompoundBeacon_Compile.CompoundBeacon>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), CompoundBeacon_Compile.ValidCompoundBeacon._typeDescriptor());
    } else {
      Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1123_valueOrError1 = __default.BeaconNameAllowed(outer, virtualFields, (beacon).dtor_name(), dafny.DafnySequence.asString("CompoundBeacon"), _1121_isSignedBeacon);
      if ((_1123_valueOrError1).IsFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        return (_1123_valueOrError1).<CompoundBeacon_Compile.CompoundBeacon>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), CompoundBeacon_Compile.ValidCompoundBeacon._typeDescriptor());
      } else {
        boolean _1124___v2 = (_1123_valueOrError1).Extract(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
        Wrappers_Compile.Result<dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1125_valueOrError2 = __default.AddNonSensitiveParts(_1119_nonSensitive, outer, java.math.BigInteger.valueOf((_1119_nonSensitive).length()), dafny.DafnySequence.<CompoundBeacon_Compile.BeaconPart> empty(CompoundBeacon_Compile.BeaconPart._typeDescriptor()));
        if ((_1125_valueOrError2).IsFailure(dafny.DafnySequence.<CompoundBeacon_Compile.BeaconPart>_typeDescriptor(CompoundBeacon_Compile.BeaconPart._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
          return (_1125_valueOrError2).<CompoundBeacon_Compile.CompoundBeacon>PropagateFailure(dafny.DafnySequence.<CompoundBeacon_Compile.BeaconPart>_typeDescriptor(CompoundBeacon_Compile.BeaconPart._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), CompoundBeacon_Compile.ValidCompoundBeacon._typeDescriptor());
        } else {
          dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart> _1126_parts = (_1125_valueOrError2).Extract(dafny.DafnySequence.<CompoundBeacon_Compile.BeaconPart>_typeDescriptor(CompoundBeacon_Compile.BeaconPart._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
          java.math.BigInteger _1127_numNon = java.math.BigInteger.valueOf((_1126_parts).length());
          Wrappers_Compile.Result<dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1128_valueOrError3 = __default.AddSensitiveParts(_1120_sensitive, _1126_parts, converted);
          if ((_1128_valueOrError3).IsFailure(dafny.DafnySequence.<CompoundBeacon_Compile.BeaconPart>_typeDescriptor(CompoundBeacon_Compile.BeaconPart._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
            return (_1128_valueOrError3).<CompoundBeacon_Compile.CompoundBeacon>PropagateFailure(dafny.DafnySequence.<CompoundBeacon_Compile.BeaconPart>_typeDescriptor(CompoundBeacon_Compile.BeaconPart._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), CompoundBeacon_Compile.ValidCompoundBeacon._typeDescriptor());
          } else {
            dafny.DafnySequence<? extends CompoundBeacon_Compile.BeaconPart> _1129_parts = (_1128_valueOrError3).Extract(dafny.DafnySequence.<CompoundBeacon_Compile.BeaconPart>_typeDescriptor(CompoundBeacon_Compile.BeaconPart._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
            Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1130_valueOrError4 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), (java.math.BigInteger.valueOf((_1129_parts).length())).signum() == 1, DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("For beacon "), (beacon).dtor_name()), dafny.DafnySequence.asString(" no parts were supplied."))));
            if ((_1130_valueOrError4).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
              return (_1130_valueOrError4).<CompoundBeacon_Compile.CompoundBeacon>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), CompoundBeacon_Compile.ValidCompoundBeacon._typeDescriptor());
            } else {
              Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1131_valueOrError5 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), (((beacon).dtor_constructors()).is_None()) || ((java.math.BigInteger.valueOf((((beacon).dtor_constructors()).dtor_value()).length())).signum() == 1), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.asString("For beacon "), (beacon).dtor_name()), dafny.DafnySequence.asString(" an empty constructor list was supplied."))));
              if ((_1131_valueOrError5).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
                return (_1131_valueOrError5).<CompoundBeacon_Compile.CompoundBeacon>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), CompoundBeacon_Compile.ValidCompoundBeacon._typeDescriptor());
              } else {
                Wrappers_Compile.Result<dafny.DafnySequence<? extends CompoundBeacon_Compile.Constructor>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1132_valueOrError6 = __default.AddConstructors((beacon).dtor_constructors(), (beacon).dtor_name(), _1129_parts);
                if ((_1132_valueOrError6).IsFailure(dafny.DafnySequence.<CompoundBeacon_Compile.Constructor>_typeDescriptor(CompoundBeacon_Compile.Constructor._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
                  return (_1132_valueOrError6).<CompoundBeacon_Compile.CompoundBeacon>PropagateFailure(dafny.DafnySequence.<CompoundBeacon_Compile.Constructor>_typeDescriptor(CompoundBeacon_Compile.Constructor._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), CompoundBeacon_Compile.ValidCompoundBeacon._typeDescriptor());
                } else {
                  dafny.DafnySequence<? extends CompoundBeacon_Compile.Constructor> _1133_constructors = (_1132_valueOrError6).Extract(dafny.DafnySequence.<CompoundBeacon_Compile.Constructor>_typeDescriptor(CompoundBeacon_Compile.Constructor._typeDescriptor()), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
                  dafny.DafnySequence<? extends Character> _1134_beaconName = ((_1121_isSignedBeacon) ? ((beacon).dtor_name()) : (dafny.DafnySequence.<Character>concatenate(DynamoDbEncryptionUtil_Compile.__default.BeaconPrefix(), (beacon).dtor_name())));
                  Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1135_valueOrError7 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.__default.IsValid__AttributeName(_1134_beaconName), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(_1134_beaconName, dafny.DafnySequence.asString(" is not a valid attribute name."))));
                  if ((_1135_valueOrError7).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
                    return (_1135_valueOrError7).<CompoundBeacon_Compile.CompoundBeacon>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), CompoundBeacon_Compile.ValidCompoundBeacon._typeDescriptor());
                  } else {
                    return CompoundBeacon_Compile.__default.MakeCompoundBeacon(BaseBeacon_Compile.BeaconBase.create(client, (beacon).dtor_name(), _1134_beaconName), ((char)(java.lang.Object)(((beacon).dtor_split()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), _1129_parts, _1127_numNon, _1133_constructors);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> AddCompoundBeacons(dafny.DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CompoundBeacon> beacons, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig outer, Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient client, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> virtualFields, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon> converted)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> output = (Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)null;
    if(true) {
      if ((java.math.BigInteger.valueOf((beacons).length())).signum() == 0) {
        output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(converted);
        return output;
      }
      CompoundBeacon_Compile.CompoundBeacon _1136_newBeacon;
      Wrappers_Compile.Result<CompoundBeacon_Compile.CompoundBeacon, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1137_valueOrError0 = (Wrappers_Compile.Result<CompoundBeacon_Compile.CompoundBeacon, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)null;
      _1137_valueOrError0 = __default.CreateCompoundBeacon(((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CompoundBeacon)(java.lang.Object)((beacons).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), outer, client, virtualFields, converted);
      if ((_1137_valueOrError0).IsFailure(CompoundBeacon_Compile.CompoundBeacon._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        output = (_1137_valueOrError0).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>>PropagateFailure(CompoundBeacon_Compile.CompoundBeacon._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.BeaconMap._typeDescriptor());
        return output;
      }
      _1136_newBeacon = (_1137_valueOrError0).Extract(CompoundBeacon_Compile.CompoundBeacon._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
      Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out61;
      _out61 = __default.AddCompoundBeacons((beacons).drop(java.math.BigInteger.ONE), outer, client, virtualFields, dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, SearchableEncryptionInfo_Compile.Beacon>update(converted, (((Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CompoundBeacon)(java.lang.Object)((beacons).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_name(), SearchableEncryptionInfo_Compile.Beacon.create_Compound(_1136_newBeacon)));
      output = _out61;
    }
    return output;
  }
  public static Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> ConvertBeacons(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.DynamoDbTableEncryptionConfig outer, Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient client, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends DdbVirtualFields_Compile.VirtField> virtualFields, dafny.DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.StandardBeacon> standard, Wrappers_Compile.Option<dafny.DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CompoundBeacon>> compound)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> output = (Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)null;
    if(true) {
      dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon> _1138_std;
      Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _1139_valueOrError0 = (Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>)null;
      Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out62;
      _out62 = __default.AddStandardBeacons(standard, outer, client, virtualFields, dafny.DafnyMap.fromElements());
      _1139_valueOrError0 = _out62;
      if ((_1139_valueOrError0).IsFailure(SearchableEncryptionInfo_Compile.BeaconMap._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        output = (_1139_valueOrError0).<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>>PropagateFailure(SearchableEncryptionInfo_Compile.BeaconMap._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), SearchableEncryptionInfo_Compile.BeaconMap._typeDescriptor());
        return output;
      }
      _1138_std = (_1139_valueOrError0).Extract(SearchableEncryptionInfo_Compile.BeaconMap._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
      if ((compound).is_Some()) {
        Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _out63;
        _out63 = __default.AddCompoundBeacons((compound).dtor_value(), outer, client, virtualFields, _1138_std);
        output = _out63;
      } else {
        output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends SearchableEncryptionInfo_Compile.Beacon>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(_1138_std);
      }
    }
    return output;
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "SearchConfigToInfo_Compile._default";
  }
}
