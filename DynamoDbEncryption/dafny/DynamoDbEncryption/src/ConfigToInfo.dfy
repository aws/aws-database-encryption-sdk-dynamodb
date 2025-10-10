// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

/*
  Convert from smithy-based SearchConfig configuration to the underlying SearchInfo object

  The only entry point of interest is 

  Convert(outer : DynamoDbTableEncryptionConfig, config : Option<AwsCryptographyDbEncryptionSdkDynamoDbTypes.SearchConfig>)
    : Option<SearchableEncryptionInfo.SearchInfo>
  
  e.g. client.info :- Convert(config, config.beacons)
*/

include "SearchInfo.dfy"
include "Util.dfy"

module SearchConfigToInfo {
  import opened AwsCryptographyDbEncryptionSdkDynamoDbTypes
  import opened StandardLibrary
  import opened Wrappers
  import opened StandardLibrary.UInt
  import opened DynamoDbEncryptionUtil
  import opened TermLoc
  import opened StandardLibrary.String
  import opened StandardLibrary.MemoryMath
  import MaterialProviders
  import SortedSets
  import Random

  import I = SearchableEncryptionInfo
  import V = DdbVirtualFields
  import B = BaseBeacon
  import CB = CompoundBeacon
  import SE = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import MPT = AwsCryptographyMaterialProvidersTypes
  import Primitives = AtomicPrimitives

  // convert configured SearchConfig to internal SearchInfo
  method Convert(outer : DynamoDbTableEncryptionConfig)
    returns (output : Result<Option<I.ValidSearchInfo>, Error>)
    requires ValidSearchConfig(outer.search)
    requires outer.search.Some? ==> ValidSharedCache(outer.search.value.versions[0].keySource)
    modifies if outer.search.Some? then outer.search.value.versions[0].keyStore.Modifies else {}
    modifies if outer.search.Some? && outer.search.value.versions[0].partitionSelector.Some? then outer.search.value.versions[0].partitionSelector.value.Modifies else {}
    ensures outer.search.Some? ==> ValidSharedCache(outer.search.value.versions[0].keySource)
    ensures output.Success? && output.value.Some? ==>
              && output.value.value.ValidState()
              && fresh(output.value.value.versions[0].keySource.client)
              && fresh(output.value.value.versions[0].partitionSelector)
    //= specification/searchable-encryption/search-config.md#initialization
    //= type=implication
    //# Initialization MUST fail if the [version number](#version-number) is not `1`.
    ensures outer.search.Some? && outer.search.value.writeVersion != 1 ==> output.Failure?

    //= specification/searchable-encryption/search-config.md#initialization
    //= type=implication
    //# Initialization MUST fail if the length of the list of [beacon versions](#beacon-version-initialization) is not 1.
    ensures outer.search.Some? && |outer.search.value.versions| != 1 ==> output.Failure?
  {
    if outer.search.None? {
      return Success(None);
    } else {
      :- Need(outer.search.value.writeVersion == 1, E("writeVersion must be '1'."));
      :- Need(|outer.search.value.versions| == 1, E("search config must be have exactly one version."));
      var beaconVersionConfig := outer.search.value.versions[0];
      var version :- ConvertVersion(outer, beaconVersionConfig);
      var info := I.MakeSearchInfo(version);
      return Success(Some(info));
    }
  }

  predicate ValidBeaconVersion(config : BeaconVersion)
  {
    config.keyStore.ValidState()
  }
  predicate ValidSearchConfig(config : Option<SearchConfig>)
  {
    if config.None? then
      true
    else
      forall b <- config.value.versions :: ValidBeaconVersion(b)
  }

  // Valid state of the provided shared cache, if it exists
  predicate {:opaque} ValidSharedCache(config: BeaconKeySource)
  {
    && (&& config.single?
        && config.single.cache.Some?
        && config.single.cache.value.Shared?
        ==> && config.single.cache.value.Shared.ValidState())
    && (&& config.multi?
        && config.multi.cache.Some?
        && config.multi.cache.value.Shared?
        ==> && config.multi.cache.value.Shared.ValidState())
  }

  // return true if, `keyFieldName` should be deleted from an item before writing
  function method ShouldDeleteKeyField(outer : DynamoDbTableEncryptionConfig, keyFieldName : string)
    : (ret : Result<bool, Error>)
    ensures
      && keyFieldName in outer.attributeActionsOnEncrypt
      && outer.attributeActionsOnEncrypt[keyFieldName] == SE.ENCRYPT_AND_SIGN
      ==> ret.Failure?
  {
    if keyFieldName !in outer.attributeActionsOnEncrypt then
      Success(true)
    else
      match outer.attributeActionsOnEncrypt[keyFieldName] {
        case DO_NOTHING => Success(true)
        case SIGN_ONLY => Success(false)
        case SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT => Success(false)
        case ENCRYPT_AND_SIGN => Failure(E("Beacon key field name " + keyFieldName + " is configured as ENCRYPT_AND_SIGN which is not allowed."))
      }
  }

  method MakeKeySource(
    outer : DynamoDbTableEncryptionConfig,
    keyStore : I.ValidStore,
    config : BeaconKeySource,
    client: Primitives.AtomicPrimitivesClient
  )
    returns (output : Result<I.KeySource, Error>)
    modifies client.Modifies
    modifies keyStore.Modifies
    requires client.ValidState()
    requires ValidSharedCache(config)
    ensures ValidSharedCache(config)
    ensures client.ValidState()
    ensures output.Success? ==>
              && output.value.ValidState()
              && output.value.client == client
              && output.value.store == keyStore

    //= specification/searchable-encryption/search-config.md#beacon-version-initialization
    //= type=implication
    //# Initialization MUST fail if the [beacon key source](#beacon-key-source) is a [multi key store](#multi-key-store-initialization)
    //# and the [beacon key field name](#beacon-key-field-name)
    //# is a [configured field](#configured-field)
    //# with [ENCRYPT_AND_SIGN](../structured-encryption/structures.md#encrypt_and_sign).
    ensures
      && config.multi?
      && config.multi.keyFieldName in outer.attributeActionsOnEncrypt
      && outer.attributeActionsOnEncrypt[config.multi.keyFieldName] == SE.ENCRYPT_AND_SIGN
      ==> output.Failure?
  {
    // FutureCleanUp : https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1510
    // It is not-good that the MPL is initialized here;
    // The MPL has a config object that could hold customer intent that affects behavior.
    // Today, it does not. But tomorrow?
    var mplR := MaterialProviders.MaterialProviders();
    var mpl :- mplR.MapFailure(e => AwsCryptographyMaterialProviders(e));

    //= specification/searchable-encryption/search-config.md#key-store-cache
    //# For a Beacon Key Source a [CMC](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/cryptographic-materials-cache.md)
    //# MUST be created.
    //# For a [Single Key Store](#single-key-store-initialization), either the user provides a cache, or we create a cache that has [Entry Capacity](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/cryptographic-materials-cache.md#entry-capacity)
    //# equal to 1.
    //# For a [Multi Key Store](#multi-key-store-initialization), either the user provides a cache, or we create a cache that has [Entry Capacity](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/cryptographic-materials-cache.md#entry-capacity)
    //# equal to 1000.
    var cacheType : MPT.CacheType :=
      if config.multi? then
        if config.multi.cache.Some? then
          config.multi.cache.value
        else
          MPT.Default(Default := MPT.DefaultCache(entryCapacity := 1000))
      else
      if config.single.cache.Some? then
        // If the user provides a CacheType, and it is NOT Shared,
        // we SHOULD only allow an entryCapacity = 1
        // because the SingleKeyStore only ever caches one value.
        // That is, we SHOULD add a check here for entryCapacity = 1.
        // However, that requires us to write an if block for each CacheType.
        // Also, it does NOT matter what the entryCapacity is, because the cache
        // can only hold one element at a time.
        config.single.cache.value
      else
        MPT.Default(Default := MPT.DefaultCache(entryCapacity := 1));

    var cache;
    if cacheType.Shared? {
      cache := cacheType.Shared;
      reveal ValidSharedCache();
    } else {
      //= specification/searchable-encryption/search-config.md#key-store-cache
      //# For a Beacon Key Source a [CMC](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/cryptographic-materials-cache.md)
      //# MUST be created.
      var input := MPT.CreateCryptographicMaterialsCacheInput(
        cache := cacheType
      );
      var maybeCache := mpl.CreateCryptographicMaterialsCache(input);
      cache :- maybeCache.MapFailure(e => AwsCryptographyMaterialProviders(e));
    }

    var partitionIdBytes : seq<uint8>;

    if config.multi? && config.multi.partitionId.Some? {
      partitionIdBytes :- UTF8.Encode(config.multi.partitionId.value)
      .MapFailure(
        e => Error.DynamoDbEncryptionException(
            message := "Could not UTF-8 Encode Partition ID from MultiKeyStore: " + e
          )
      );
    }
    else if config.single? && config.single.partitionId.Some? {
      partitionIdBytes :- UTF8.Encode(config.single.partitionId.value)
      .MapFailure(
        e => Error.DynamoDbEncryptionException(
            message := "Could not UTF-8 Encode Partition ID from SingleKeyStore: " + e
          )
      );
    }
    else {
      partitionIdBytes :- I.GenerateUuidBytes();
    }
    var getKeyStoreInfoOutput? := keyStore.GetKeyStoreInfo();
    var getKeyStoreInfoOutput :- getKeyStoreInfoOutput?.MapFailure(e => Error.AwsCryptographyKeyStore(e));
    var logicalKeyStoreName : string := getKeyStoreInfoOutput.logicalKeyStoreName;
    var logicalKeyStoreNameBytes : seq<uint8> :- UTF8.Encode(logicalKeyStoreName)
    .MapFailure(
      e => Error.DynamoDbEncryptionException(
          message := "Could not UTF-8 Encode Logical Key Store Name: " + e
        )
    );

    if config.multi? {
      :- Need(0 < config.multi.cacheTTL, E("Beacon Cache TTL must be at least 1."));
      var deleteKey :- ShouldDeleteKeyField(outer, config.multi.keyFieldName);
      output := Success(I.KeySource(client, keyStore, I.MultiLoc(config.multi.keyFieldName, deleteKey), cache, config.multi.cacheTTL as uint32, partitionIdBytes, logicalKeyStoreNameBytes));
    } else {
      :- Need(0 < config.single.cacheTTL, E("Beacon Cache TTL must be at least 1."));
      output := Success(I.KeySource(client, keyStore, I.SingleLoc(config.single.keyId), cache, config.single.cacheTTL as uint32, partitionIdBytes, logicalKeyStoreNameBytes));
    }
    assert output.value.ValidState() by {
      // This axiom is important because it is not easy to prove
      // keyStore.Modifies !! cache.Modifies for a shared cache.
      assume {:axiom} keyStore.Modifies !! cache.Modifies;
    }
  }

  // convert configured BeaconVersion to internal BeaconVersion
  method ConvertVersion(outer : DynamoDbTableEncryptionConfig, config : BeaconVersion)
    returns (output : Result<I.ValidBeaconVersion, Error>)
    requires ValidBeaconVersion(config)
    requires ValidSharedCache(config.keySource)
    modifies config.keyStore.Modifies
    modifies if config.partitionSelector.Some? then config.partitionSelector.value.Modifies else {}
    ensures ValidSharedCache(config.keySource)
    ensures output.Success? ==>
              && output.value.ValidState()
              && fresh(output.value.keySource.client)
              && fresh(output.value.partitionSelector)
              && fresh (output.value.partitionSelector.Modifies)

    //= specification/searchable-encryption/search-config.md#beacon-version-initialization
    //= type=implication
    //# Initialization MUST fail if the [version number](#version number) is not `1`.
    ensures config.version != 1 ==> output.Failure?

    //= specification/searchable-encryption/search-config.md#beacon-version-initialization
    //= type=implication
    //# Initialization MUST fail if at least one [standard beacon](beacons.md#standard-beacon)
    //# is not provided.
    ensures |config.standardBeacons| == 0 ==> output.Failure?
  {
    :- Need(config.version == 1, E("Version number in BeaconVersion must be '1'."));
    :- Need(0 < |config.standardBeacons|, E("At least one standard beacon must be configured."));

    var maybePrimitives := Primitives.AtomicPrimitives();
    var primitives :- maybePrimitives.MapFailure(e => AwsCryptographyPrimitives(e));
    var source :- MakeKeySource(outer, config.keyStore, config.keySource, primitives);
    var version :- ConvertVersionWithSource(outer, config, source);
    return Success(version);
  }

  class DefaultPartitionSelector extends IPartitionSelector
  {
    predicate ValidState()
      ensures ValidState() ==> History in Modifies
    { History in Modifies }

    constructor ()
      ensures ValidState() && fresh(History) && fresh(Modifies)
    {
      History := new IPartitionSelectorCallHistory();
      Modifies := { History };
    }

    predicate GetPartitionNumberEnsuresPublicly (
      input: GetPartitionNumberInput ,
      output: Result<GetPartitionNumberOutput, Error> )
      : (outcome: bool)
    {
      true
    }

    //= specification/searchable-encryption/search-config.md#partition-selector
    //# The default implementation of the Partition Selector MUST return a random number within the acceptable range, i.e.
    method GetPartitionNumber'(input: GetPartitionNumberInput)
      returns (output: Result<GetPartitionNumberOutput, Error> )
      requires ValidState()
      modifies Modifies - {History}
      decreases Modifies - {History}
      ensures ValidState()
      ensures GetPartitionNumberEnsuresPublicly(input, output)
      ensures unchanged(History)
    {
      if input.numberOfPartitions == 1 {
        return Success(GetPartitionNumberOutput(partitionNumber := 0));
      } else {
        var randR := Random.GenerateBytes(1);
        var rand : seq<uint8> :- randR.MapFailure(e => DynamoDbEncryptionException(message := "Failed to get random byte"));
        var partition := (rand[0] % (input.numberOfPartitions as uint8)) as PartitionNumber;
        return Success(GetPartitionNumberOutput(partitionNumber := partition));
      }
    }
  }

  // convert configured BeaconVersion to internal BeaconVersion
  method ConvertVersionWithSource(
    outer : DynamoDbTableEncryptionConfig,
    config : BeaconVersion,
    source : I.KeySource
  )
    returns (output : Result<I.ValidBeaconVersion, Error>)
    requires config.version == 1
    modifies source.client.Modifies
    requires source.ValidState()
    ensures output.Success? ==>
              && output.value.ValidState()
              && output.value.keySource == source
              && fresh(output.value.partitionSelector)
              && fresh(output.value.partitionSelector.Modifies)
  {
    var maxPartitions : PartitionCount := config.maximumNumberOfPartitions.UnwrapOr(1);
    :- Need(0 <= maxPartitions as nat < MAX_PARTITION_COUNT, E("Invalid maximumNumberOfPartitions specified, " + Base10Int2String(maxPartitions as int) + ", must be 0 < maximumNumberOfPartitions <= 255."));
    // Zero is invalid, but in Java we can't distinguish None from Some(0)
    if maxPartitions == 0 {
      maxPartitions := 1;
    }

    var defaultPartitionsOpt : Option<PartitionCount> := config.defaultNumberOfPartitions;
    var defaultPartitions;

    //= specification/searchable-encryption/search-config.md#default-partitions
    //# If not set, Default Partitions MUST default to [Max Partitions](#max-partitions).
    if defaultPartitionsOpt.None? || defaultPartitionsOpt.value == 0 {
      defaultPartitions := maxPartitions;

      //= specification/searchable-encryption/search-config.md#beacon-version-initialization
      //# Initialization MUST fail if [default number of partitions](#default-partitions) is greater than or equal to [maximum number of partitions](#max-partitions).

      // if maximumNumberOfPartitions is not set, then maxPartitions == 1, and so this is also covered
      //= specification/searchable-encryption/search-config.md#beacon-version-initialization
      //# Initialization MUST fail if [default number of partitions](#default-partitions) is supplied but [maximum number of partitions](#max-partitions) is not.
    } else if maxPartitions <= defaultPartitionsOpt.value {
      return(Failure(E("Invalid defaultNumberOfPartitions specified, " + Base10Int2String(defaultPartitionsOpt.value as int) + ", must be 0 < defaultNumberOfPartitions < maximumNumberOfPartitions.")));
    } else {
      defaultPartitions := defaultPartitionsOpt.value;
    }

    var virtualFields :- ConvertVirtualFields(outer, config.virtualFields);
    var std :- AddStandardBeacons(config.standardBeacons, outer, source.client, virtualFields, maxPartitions, defaultPartitions);

    var signed := if config.signedParts.Some? then config.signedParts.value else [];

    var globalSignedParts :- GetSignedParts(signed, outer, "Global Parts List");

    var globalEncryptedParts : PartSet := PartSet([], {}, {});
    if config.encryptedParts.Some? {
      globalEncryptedParts :- GetEncryptedParts(config.encryptedParts.value, std, "Global Parts List");
    }

    var beacons : I.BeaconMap;
    if config.compoundBeacons.Some? {
      beacons :- AddCompoundBeacons(config.compoundBeacons.value, outer, source.client, virtualFields, std, globalSignedParts, globalEncryptedParts);
    } else {
      beacons := std;
    }
    var _ :- CheckBeacons(beacons);

    //= specification/searchable-encryption/search-config.md#beacon-version-initialization
    //# Initialization MUST fail if the [beacon key source](#beacon-key-source) is a [multi key store](#multi-key-store-initialization)
    //# and the name of any of the following match the [beacon key field name](#beacon-key-field-name)
    //# - [virtual fields](virtual.md#virtual-field)
    //# - [standard beacons](beacons.md#standard-beacon)
    //# - [compound beacons](beacons.md#compound-beacon)
    if source.keyLoc.MultiLoc? {
      var name := source.keyLoc.keyName;
      if name in beacons {
        return Failure(E("A beacon key field name of " + name + " was configured, but there's also a beacon of that name."));
      }
      if name in virtualFields {
        return Failure(E("A beacon key field name of " + name + " was configured, but there's also a virtual field of that name."));
      }
    }
    var partitionSelector;
    if outer.search.Some? && outer.search.value.versions[0].partitionSelector.Some? {
      partitionSelector := outer.search.value.versions[0].partitionSelector.value;
      assume {:axiom} partitionSelector.ValidState();
    } else {
      partitionSelector := new DefaultPartitionSelector();
    }

    var ret :- I.MakeBeaconVersion(
      config.version as I.VersionNumber,
      source,
      beacons,
      virtualFields,
      outer.attributeActionsOnEncrypt,
      partitionSelector,
      maxPartitions
    );
    assume {:axiom} fresh(ret.partitionSelector);
    return Success(ret);
  }

  // convert configured VirtualFieldList to internal VirtualFieldMap
  function method ConvertVirtualFields(outer : DynamoDbTableEncryptionConfig, vf : Option<VirtualFieldList>)
    : Result<V.VirtualFieldMap, Error>
  {
    if vf.None? then
      Success(map[])
    else
      AddVirtualFields(vf.value, outer)
  }

  // is this terminal location signed
  predicate method IsSigned(outer : DynamoDbTableEncryptionConfig, loc : TermLoc)
  {
    && var name := loc[0].key;
    && name in outer.attributeActionsOnEncrypt
    && outer.attributeActionsOnEncrypt[name] != SE.DO_NOTHING
  }

  // is this terminal location signed, but not encrypted
  predicate method IsSignOnly(outer : DynamoDbTableEncryptionConfig, loc : TermLoc)
  {
    && var name := loc[0].key;
    && name in outer.attributeActionsOnEncrypt
    && (
         || outer.attributeActionsOnEncrypt[name] == SE.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT
         || outer.attributeActionsOnEncrypt[name] == SE.SIGN_ONLY
       )
  }

  // is this terminal location encrypted
  predicate method IsEncrypted(outer : DynamoDbTableEncryptionConfig, loc : TermLoc)
  {
    && var name := loc[0].key;
    && name in outer.attributeActionsOnEncrypt
    && outer.attributeActionsOnEncrypt[name] == SE.ENCRYPT_AND_SIGN
  }

  // is this terminal location encrypted, OR does it refer to an encrypted virtual field
  predicate method IsEncryptedV(outer : DynamoDbTableEncryptionConfig, virtualFields : V.VirtualFieldMap, loc : TermLoc)
  {
    || IsEncrypted(outer, loc)
    || (loc[0].key in virtualFields && virtualFields[loc[0].key].examine((t : TermLoc) => IsEncrypted(outer, t)))
  }

  // does this name already exists as a configured attribute, or virtual field
  function method {:opaque} BeaconNameAllowed(
    outer : DynamoDbTableEncryptionConfig,
    virtualFields : V.VirtualFieldMap,
    name : string,
    context : string,
    isSignedBeacon : bool := false)
    : (ret : Result<bool, Error>)
    ensures name in outer.attributeActionsOnEncrypt && outer.attributeActionsOnEncrypt[name] != SE.ENCRYPT_AND_SIGN ==> ret.Failure?
  {
    if name in outer.attributeActionsOnEncrypt && outer.attributeActionsOnEncrypt[name] != SE.ENCRYPT_AND_SIGN then
      Failure(E(name + " not allowed as a " + context + " because it is already an unencrypted attribute."))
    else if isSignedBeacon && name in outer.attributeActionsOnEncrypt then
      Failure(E(name + " not allowed as a " + context + " because a fully signed beacon cannot have the same name as an existing attribute."))
    else if outer.allowedUnsignedAttributes.Some? && name in outer.allowedUnsignedAttributes.value then
      Failure(E(name + " not allowed as a " + context + " because it is already an allowed unauthenticated attribute."))
    else if outer.allowedUnsignedAttributePrefix.Some? && outer.allowedUnsignedAttributePrefix.value <= name then
      Failure(E(name + " not allowed as a " + context + " because it begins with the allowed unauthenticated prefix."))
    else if ReservedPrefix <= name then
      Failure(E(name + " not allowed as a " + context + " because it begins with the reserved prefix."))
    else
      Success(true)
  }

  // does this name already exists as a configured attribute
  function method VirtualFieldNameAllowed(outer : DynamoDbTableEncryptionConfig, name : string)
    : Result<bool, Error>
  {
    if name in outer.attributeActionsOnEncrypt then
      Failure(E(name + " not allowed as a Virtual Field because it is already a configured attribute."))
    else if outer.allowedUnsignedAttributes.Some? && name in outer.allowedUnsignedAttributes.value then
      Failure(E(name + " not allowed as a Virtual Field because it is already an allowed unauthenticated attribute."))
    else if outer.allowedUnsignedAttributePrefix.Some? && outer.allowedUnsignedAttributePrefix.value <= name then
      Failure(E(name + " not allowed as a Virtual Field because it begins with the allowed unauthenticated prefix."))
    else if ReservedPrefix <= name then
      Failure(E(name + " not allowed as a Virtual Field because it begins with the reserved prefix."))
    else
      Success(true)
  }

  function method FindVirtualFieldWithThisLocation(fields : V.VirtualFieldMap, locs : set<TermLoc>) : Option<string>
  {
    var badNames := set b <- fields | fields[b].GetLocs() == locs :: b;
    if |badNames| == 0 then
      None
    else
      // We happen to order these values, but this ordering MUST NOT be relied upon.
      var badSeq := SortedSets.ComputeSetToOrderedSequence2(badNames, CharLess);
      Some(badSeq[0])
  }

  predicate method ExistsConstructorWithTheseRequired(cons : seq<CB.Constructor> , locs : set<CB.BeaconPart>)
  {
    0 < SeqCount((c : CB.Constructor) => c.getReqParts() == locs, cons)
  }

  function method getPartsString(c : CB.Constructor) : string
  {
    var req := Seq.Filter((p : CB.ConstructorPart) => p.required, c.parts);
    var names := Seq.Map((p : CB.ConstructorPart) => p.part.getName(), req);
    if |names| == 0 then
      ""
    else
      Join(names, ", ")
  }
  // convert configured VirtualFields to internal VirtualFields
  function method {:tailrecursion} AddVirtualFields(
    vf : seq<AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualField>,
    outer : DynamoDbTableEncryptionConfig,
    converted : V.VirtualFieldMap := map[])
    : (ret : Result<V.VirtualFieldMap, Error>)

    //= specification/searchable-encryption/search-config.md#beacon-version-initialization
    //= type=implication
    //# Initialization MUST fail if the name of any [virtual fields](virtual.md#virtual-field) matches that
    //# of any [configured field](#configured-field).
    ensures 0 < |vf| && VirtualFieldNameAllowed(outer, vf[0].name).Failure? ==> ret.Failure?

    //= specification/searchable-encryption/search-config.md#beacon-version-initialization
    //= type=implication
    //# Initialization MUST fail if any [virtual field](virtual.md#virtual-field) is not signed.
    ensures (0 < |vf| && (
               || V.ParseVirtualFieldConfig(vf[0]).Failure?
               || V.ParseVirtualFieldConfig(vf[0]).value.examine((t : TermLoc) => !IsSigned(outer, t))
             )) ==> ret.Failure?

    //= specification/searchable-encryption/virtual.md#virtual-field-initialization
    //= type=implication
    //# Initialization MUST fail if two virtual fields are defined with the same set of locations.
    ensures ret.Success? && 0 < |vf| ==>
              && vf[0].name !in converted
              && V.ParseVirtualFieldConfig(vf[0]).Success?
              && var newField := V.ParseVirtualFieldConfig(vf[0]).value;
              && !newField.examine((t : TermLoc) => !IsSigned(outer, t))
              && FindVirtualFieldWithThisLocation(converted, newField.GetLocs()).None?
  {
    if |vf| == 0 then
      Success(converted)
    else
      :- Need(vf[0].name !in converted, E("Duplicate VirtualField name : " + vf[0].name));
      var _ :- VirtualFieldNameAllowed(outer, vf[0].name);
      var newField :- V.ParseVirtualFieldConfig(vf[0]);
      // need all parts signed
      :- Need(!newField.examine((t : TermLoc) => !IsSigned(outer, t)),
              E("VirtualField " + vf[0].name + " must be defined on signed fields."));
      var badField := FindVirtualFieldWithThisLocation(converted, newField.GetLocs());
      if badField.Some? then
        Failure(E("Virtual field " + vf[0].name + " is defined on the same locations as " + badField.value + "."))
      else
        AddVirtualFields(vf[1..], outer, converted[vf[0].name := newField])
  }

  function method FindBeaconWithThisLocation(beacons : I.BeaconMap, loc : TermLoc) : Option<string>
  {
    var badNames := set b <- beacons | beacons[b].Standard? && beacons[b].std.loc == loc :: b;
    if |badNames| == 0 then
      None
    else
      // We happen to order these values, but this ordering MUST NOT be relied upon.
      var badSeq := SortedSets.ComputeSetToOrderedSequence2(badNames, CharLess);
      Some(badSeq[0])
  }

  function method IsValidShare(converted : I.BeaconMap, name : string, length : B.BeaconLength, share : string)
    : (ret : Result<bool, Error>)
    ensures ret.Success? ==>
              && share in converted
              && converted[share].Standard?
              && converted[share].std.length == length
  {
    if share in converted then
      var tb := converted[share];
      if tb.Standard? then
        if tb.std.share.Some? then
          if name == share then
            Failure(E("Beacon " + name + " is shared to itself."))
          else
            Failure(E("Beacon " + name + " is shared to " + share + " which is in turn shared to " + tb.std.share.value
                      + ". Share chains are not allowed."))
        else if tb.std.length == length then
          Success(true)
        else
          Failure(E("Beacon " + name + " is shared to " + share + " but " + name + " has length " + Base10Int2String(length as int)
                    + " and " + share + " has length " + Base10Int2String(tb.std.length as int) + "."))
      else
        Failure(E("Beacon " + name + " is shared to " + share + " but " + share + " is a compound beacon."))
    else
      Failure(E("Beacon " + name + " is shared to " + share + " which is not defined."))
  }

  function method GetPartitionCount(outer : DynamoDbTableEncryptionConfig, inner : Option<PartitionCount>, name : string, maxPartitions : PartitionCount, defaultPartitions : PartitionCount) :
    Result<PartitionCount,Error>
  {
    if outer.search.None? || |outer.search.value.versions| == 0 then
      Success(1)
    else
    if PartitionCountNone(inner) then
      Success(defaultPartitions)
    else if inner.value < maxPartitions then
      Success(inner.value)
    else
      //= specification/searchable-encryption/beacons.md#standard-beacon-initialization
      //# Initialization MUST fail if [number of partitions](#beacon-constraint) is specified, and is greater than or equal to
      //# the maximum number of partitions specified in the [beacon version](search-config.md#beacon-version-initialization).
      Failure(E("Constrained numberOfPartitions for  " + name + " is " + Base10Int2String(inner.value as int) + " but it must be less than the maximumNumberOfPartitions " + Base10Int2String(maxPartitions as int)))
  }

  // convert configured StandardBeacons to internal Beacons
  method {:tailrecursion} AddStandardBeacons(
    beacons : seq<StandardBeacon>,
    outer : DynamoDbTableEncryptionConfig,
    client: Primitives.AtomicPrimitivesClient,
    virtualFields : V.VirtualFieldMap,
    maxPartitions : PartitionCount,
    defaultPartitions : PartitionCount,
    converted : I.BeaconMap := map[])
    returns (output : Result<I.BeaconMap, Error>)
    modifies client.Modifies
    requires client.ValidState()
    ensures client.ValidState()

    //= specification/searchable-encryption/search-config.md#beacon-version-initialization
    //= type=implication
    //# Initialization MUST fail if there is any duplicates among the names of the
    //# [standard beacons](beacons.md#standard-beacon)
    ensures 0 < |beacons| && beacons[0].name in converted ==> output.Failure?

    //= specification/searchable-encryption/search-config.md#beacon-version-initialization
    //= type=implication
    //# Initialization MUST fail if the name of any [standard beacon](beacons.md#standard-beacon)
    //# matches that of any unencrypted [configured field](#configured-field).
    ensures 0 < |beacons| && beacons[0].name in outer.attributeActionsOnEncrypt && outer.attributeActionsOnEncrypt[beacons[0].name] != SE.ENCRYPT_AND_SIGN ==> output.Failure?

    ensures output.Success? && 0 < |beacons| ==>
              && beacons[0].name !in converted
              && var locString := GetLocStr(beacons[0].name, beacons[0].loc);
              //= specification/searchable-encryption/beacons.md#standard-beacon-initialization
              //= type=implication
              //# If no [terminal location](virtual.md#terminal-location) is provided,
              //# the `name` MUST be used as the [terminal location](virtual.md#terminal-location).
              && locString == (if beacons[0].loc.Some? then beacons[0].loc.value else beacons[0].name)
              && MakeTermLoc(locString).Success?
              && var loc := MakeTermLoc(locString).value;
              //= specification/searchable-encryption/beacons.md#standard-beacon-initialization
              //= type=implication
              //# Initialization MUST fail if two standard beacons are configured with the same location.
              && FindBeaconWithThisLocation(converted, loc).None?
                 //= specification/searchable-encryption/virtual.md#virtual-field-initialization
                 //= type=implication
                 //# Initialization MUST fail if a virtual field is defined with only one location,
                 //# and also a [standard beacon](beacons.md#standard-beacon) is defined with that same location.
              && FindVirtualFieldWithThisLocation(virtualFields, {loc}).None?
  {
    if |beacons| == 0 {
      return Success(converted);
    }
    :- Need(beacons[0].name !in converted, E("Duplicate StandardBeacon name : " + beacons[0].name));
    var _ :- BeaconNameAllowed(outer, virtualFields, beacons[0].name, "StandardBeacon");
    var locString := GetLocStr(beacons[0].name, beacons[0].loc);
    var isPartOnly := false;
    var isAsSet := false;
    var share : Option<string> := None;
    if beacons[0].style.Some? {
      match beacons[0].style.value {
        case partOnly(t) => isPartOnly := true;
        case shared(t) => share := Some(t.other);
        case asSet(t) => isAsSet := true;
        //= specification/searchable-encryption/beacons.md#sharedset-initialization
        //# A SharedSet Beacon MUST behave both as [Shared](#shared-initialization) and [AsSet](#asset-initialization).
        case sharedSet(t) => share := Some(t.other); isAsSet := true;
      }
    }
    var partitionCount :- GetPartitionCount(outer, beacons[0].numberOfPartitions, beacons[0].name, maxPartitions, defaultPartitions);
    var newBeacon :- B.MakeStandardBeacon(client, beacons[0].name, beacons[0].length as B.BeaconLength, locString,
                                          isPartOnly, isAsSet, share, partitionCount);

    //= specification/searchable-encryption/search-config.md#beacon-version-initialization
    //# Initialization MUST fail if the [terminal location](virtual.md#terminal-location)
    //# reference by a [standard beacon](beacons.md#standard-beacon) is not `encrypted`.
    :- Need(IsEncryptedV(outer, virtualFields, newBeacon.loc), E("StandardBeacon " + beacons[0].name + " not defined on an encrypted field."));

    var badBeacon := FindBeaconWithThisLocation(converted, newBeacon.loc);
    if badBeacon.Some? {
      return Failure(E("Beacon " + beacons[0].name + " is defined on location " + TermLocToString(newBeacon.loc)
                       + ", but beacon " + badBeacon.value + " is already defined on that location."));
    }
    var badField := FindVirtualFieldWithThisLocation(virtualFields, {newBeacon.loc});
    if badField.Some? {
      return Failure(E("Beacon " + beacons[0].name + " is defined on location " + TermLocToString(newBeacon.loc)
                       + ", but virtual field " + badField.value + " is already defined on that single location."));
    }

    output := AddStandardBeacons(beacons[1..], outer, client, virtualFields, maxPartitions, defaultPartitions, converted[beacons[0].name := I.Standard(newBeacon)]);
  }

  // optional location, defaults to name
  function method GetLoc(name : string, loc : Option<string>)
    : Result<TermLoc, Error>
  {
    if loc.None? then
      Success(TermLocMap(name))
    else
      MakeTermLoc(loc.value)
  }
  // optional location, defaults to name
  function method GetLocStr(name : string, loc : Option<string>)
    : string
  {
    if loc.None? then
      name
    else
      loc.value
  }

  datatype PartSet = PartSet (
    parts : seq<CB.BeaconPart>,
    names : set<string>,
    prefixes : set<string>
  ) {
    function method add(part : CB.BeaconPart, name : string) : Result<PartSet, Error>
    {
      if part.getName() in names then
        Failure(E("Duplicate part name " + part.getName() + " in " + name + "."))
      else if part.getPrefix() in prefixes then
        Failure(E("Duplicate prefix " + part.getPrefix() + " in " + name + "."))
      else
        Success(PartSet(
                  parts := parts + [part],
                  names := names + {part.getName()},
                  prefixes := prefixes + {part.getPrefix()}
                ))
    }

    function method GetSetAsString(strings : set<string>) : string
      requires |strings| != 0
    {
      var names := SortedSets.ComputeSetToOrderedSequence2(strings, CharLess);
      Join(names, ", ")
    }

    function method combine(other : PartSet, name : string, otherName : string) : Result<PartSet, Error>
    {
      if |names * other.names| != 0 then
        var tags := GetSetAsString(names * other.names);
        Failure(E("Duplicate part name(s) " + tags + " between " + name + " and " + otherName + "."))
      else if |prefixes * other.prefixes| != 0 then
        var tags := GetSetAsString(prefixes * other.prefixes);
        Failure(E("Duplicate prefix(es) " + tags + " between " + name + " and " + otherName + "."))
      else
        Success(PartSet(
                  parts := parts + other.parts,
                  names := names + other.names,
                  prefixes := prefixes + other.prefixes
                ))

    }
  }

  // convert configured SignedPart to internal BeaconPart
  function method {:tailrecursion} GetSignedParts(
    parts : seq<SignedPart>,
    outer : DynamoDbTableEncryptionConfig,
    name : string,
    ghost origSize : nat := |parts|,
    converted : PartSet := PartSet([], {}, {})
  )
    : (ret : Result<PartSet, Error>)
    requires origSize == |parts| + |converted.parts|
    requires forall p <- converted.parts :: p.Signed?
    ensures ret.Success? ==> |ret.value.parts| == origSize
    ensures ret.Success? ==> forall p <- ret.value.parts :: p.Signed?

    //= specification/searchable-encryption/search-config.md#beacon-version-initialization
    //= type=implication
    //# Initialization MUST fail if the [terminal location](virtual.md#terminal-location)
    //# reference by a [signed part](beacons.md#signed-part) is `encrypted`,
    //# or is not `signed`.
    ensures
      (&& 0 < |parts|
          //= specification/searchable-encryption/beacons.md#signed-part-initialization
          //= type=implication
          //# If no [terminal location](virtual.md#terminal-location) is provided,
          //# the `name` MUST be used as the [terminal location](virtual.md#terminal-location).
       && GetLoc(parts[0].name, parts[0].loc).Success?
       && var loc := GetLoc(parts[0].name, parts[0].loc).value;
       && !IsSignOnly(outer, CB.Signed(parts[0].prefix, parts[0].name, loc).loc))
      ==> ret.Failure?

    //= specification/searchable-encryption/beacons.md#initialization-failure
    //= type=implication
    //# Initialization MUST fail if any [signed-part](#signed-part-initialization) contains
    //# anything but SIGN_ONLY fields.
    ensures ret.Success? && 0 < |parts| ==>
              && GetLoc(parts[0].name, parts[0].loc).Success?
              && var loc := GetLoc(parts[0].name, parts[0].loc).value;
              && IsSignOnly(outer, loc)
  {
    if |parts| == 0 then
      Success(converted)
    else
      var loc :- GetLoc(parts[0].name, parts[0].loc);
      var newPart := CB.Signed(parts[0].prefix, parts[0].name, loc);
      :- Need(IsSignOnly(outer, newPart.loc), E("Signed Part " + newPart.name
                                                + " is built from " + GetLocStr(parts[0].name, parts[0].loc) + " which is not SIGN_ONLY."));
      var newParts :- converted.add(newPart, name);
      GetSignedParts(parts[1..], outer, name, origSize, newParts)
  }

  // convert configured EncryptedPart to internal BeaconPart
  function method GetEncryptedParts(
    parts : seq<EncryptedPart>,
    std : I.BeaconMap,
    name : string,
    ghost origSize : nat := |parts|,
    converted : PartSet := PartSet([], {}, {})
  )
    : (ret : Result<PartSet, Error>)
    requires origSize == |parts| + |converted.parts|
    requires forall x <- converted.parts :: x.Encrypted?

    ensures ret.Success? ==> |ret.value.parts| == origSize
    //= specification/searchable-encryption/beacons.md#compound-beacon
    //= type=implication
    //# The name MUST be the name of a configured standard beacon.
    ensures ret.Success? && 0 < |parts| ==> parts[0].name in std && std[parts[0].name].Standard?
    ensures ret.Success? ==> forall x <- ret.value.parts :: x.Encrypted?

    //= specification/searchable-encryption/beacons.md#asset-initialization
    //= type=implication
    //# * initialization MUST fail if any compound beacon has an AsSet beacon as a part.
    ensures |parts| != 0 && parts[0].name in std && std[parts[0].name].Standard?  && std[parts[0].name].std.asSet ==> ret.Failure?
  {
    if |parts| == 0 then
      Success(converted)
    else
    if parts[0].name in std && std[parts[0].name].Standard?  && std[parts[0].name].std.asSet then
      Failure(E(name + " uses " + parts[0].name + " which is an AsSet beacon, and therefore cannot be used in a Compound Beacon."))
    else if parts[0].name in std && std[parts[0].name].Standard? then
      var newPart := CB.Encrypted(parts[0].prefix, std[parts[0].name].std);
      var newParts :- converted.add(newPart, name);
      GetEncryptedParts(parts[1..], std, name, origSize, newParts)
    else
      Failure(E(name + " refers to standard beacon " + parts[0].name + " which is not configured."))
  }

  // create the default constructor, if not constructor is specified
  function method MakeDefaultConstructor(
    parts : seq<CB.BeaconPart>,
    ghost allParts : seq<CB.BeaconPart>,
    ghost numNon : uint64,
    converted : seq<CB.ConstructorPart> := []
  )
    : (ret : Result<seq<CB.Constructor>, Error>)
    requires 0 < |parts| + |converted|
    requires |allParts| == |parts| + |converted|
    requires parts == allParts[|converted|..]
    requires numNon as nat <= |allParts|
    requires CB.OrderedParts(allParts, numNon as nat)
    requires forall i | 0 <= i < |converted| ::
               && converted[i].part == allParts[i]
               && converted[i].required
    ensures ret.Success? ==>
              && |ret.value| == 1
              && |ret.value[0].parts| == |parts| + |converted|
                 //= specification/searchable-encryption/beacons.md#default-construction
                 //= type=implication
                 //# * This default constructor MUST be all of the signed parts,
                 //# followed by all the encrypted parts, all parts being required.
              && CB.OrderedParts(allParts, numNon as nat)
              && (forall i | 0 <= i < |ret.value[0].parts| ::
                    && ret.value[0].parts[i].part == allParts[i]
                    && ret.value[0].parts[i].required)
  {
    if |parts| == 0 then
      Success([CB.Constructor(converted)])
    else
      MakeDefaultConstructor(parts[1..], allParts, numNon, converted + [CB.ConstructorPart(parts[0], true)])
  }
  /* Returns the subsequence consisting of those elements of a sequence that satisfy a given 
     predicate. */
  function method MyFilter<T>(f: (T ~> bool), xs: seq<T>): (result: seq<T>)
    requires forall i :: 0 <= i < |xs| ==> f.requires(xs[i])
    ensures |result| <= |xs|
    ensures forall i: nat :: i < |result| && f.requires(result[i]) ==> f(result[i])
    reads set i, o | 0 <= i < |xs| && o in f.reads(xs[i]) :: o
    ensures forall x <- result :: x in xs
  {
    if |xs| == 0 then []
    else (if f(xs[0]) then [xs[0]] else []) + MyFilter(f, xs[1..])
  }

  function method SeqCount<T>(f: (T ~> bool), xs: seq<T>): (result: nat)
    requires forall i :: 0 <= i < |xs| ==> f.requires(xs[i])
    ensures result <= |xs|
    reads set i, o | 0 <= i < |xs| && o in f.reads(xs[i]) :: o
  {
    if |xs| == 0 then 0
    else (if f(xs[0]) then 1 else 0) + SeqCount(f, xs[1..])
  }

  // convert configured ConstructorParts to internal ConstructorParts
  function method MakeConstructor2(c : seq<ConstructorPart>, parts : seq<CB.BeaconPart>, origSize : nat, converted : seq<CB.ConstructorPart> := [])
    : (ret : Result<seq<CB.ConstructorPart>, Error>)
    requires origSize == |c| + |converted|
    ensures ret.Success? ==> |ret.value| == origSize
    //= specification/searchable-encryption/beacons.md#constructor-part-initialization
    //= type=implication
    //# This name MUST match the name of one of the [encrypted](#encrypted-part-initialization) or [signed](#signed-part-initialization) parts.

    //= specification/searchable-encryption/beacons.md#initialization-failure
    //= type=implication
    //# Initialization MUST fail if any [constructor](#constructor-initialization) is configured with a field name
    //# that is not a defined [part](#part).
    ensures ret.Success? && 0 < |c| ==>
              exists p : CB.BeaconPart | p in parts :: p.getName() == c[0].name
  {
    if |c| == 0 then
      Success(converted)
    else
      var thePart := MyFilter((p : CB.BeaconPart) => p.getName() == c[0].name, parts);
      :- Need(0 < |thePart|, E("Constructor refers to part name " + c[0].name + " but there is no part by that name."));
      assert thePart[0] in parts;
      assert thePart[0].getName() == c[0].name;
      var newPart := CB.ConstructorPart(thePart[0], c[0].required);
      MakeConstructor2(c[1..], parts, origSize, converted + [newPart])
  }

  // convert configured Constructor to internal Constructor
  function method MakeConstructor(c : Constructor, parts : seq<CB.BeaconPart>)
    : (ret : Result<CB.Constructor, Error>)
    requires 0 < |c.parts|
    ensures ret.Success? ==>
              |ret.value.parts| == |c.parts|
  {
    var newParts :- MakeConstructor2(c.parts, parts, |c.parts|);
    Success(CB.Constructor(newParts))
  }

  // convert configured Constructors to internal Constructors
  function method AddConstructors2(constructors : seq<Constructor>, name : string, parts : seq<CB.BeaconPart>, origSize : nat, converted : seq<CB.Constructor> := [])
    : (ret : Result<seq<CB.Constructor>, Error>)
    requires 0 < origSize
    requires origSize == |constructors| + |converted|
    ensures ret.Success? ==> |ret.value| == origSize
    //= specification/searchable-encryption/beacons.md#initialization-failure
    //= type=implication
    //# Initialization MUST fail if any [constructor](#constructor-initialization) is configured without at least one
    //# required part.
    ensures ret.Success? && 0 < |constructors| ==>
              0 < SeqCount((p : ConstructorPart) => p.required, constructors[0].parts)

    //= specification/searchable-encryption/beacons.md#initialization-failure
    //= type=implication
    //# Initialization MUST fail if two [constructors](#constructor-initialization) are configured
    //# with the same set of required parts.
    ensures ret.Success? && 0 < |constructors| ==>
              && MakeConstructor(constructors[0], parts).Success?
              && var c := MakeConstructor(constructors[0], parts).value;
              && !ExistsConstructorWithTheseRequired(converted, c.getReqParts())
  {
    if |constructors| == 0 then
      Success(converted)
    else
      :- Need(0 < |constructors[0].parts|, E("Every constructor must have at least one part."));
      :- Need(0 < SeqCount((p : ConstructorPart) => p.required, constructors[0].parts),
              E("A Constructor for beacon " + name + " lacks any required parts"));
      var c :- MakeConstructor(constructors[0], parts);
      if ExistsConstructorWithTheseRequired(converted, c.getReqParts()) then
        var p := getPartsString(c);
        Failure(E("Multiple constructors for " + name + " have the same set of required parts : " + p))
      else
        AddConstructors2(constructors[1..], name, parts, origSize, converted + [c])
  }

  // convert configured Constructors to internal Constructors
  function method AddConstructors(
    constructors : Option<ConstructorList>,
    name : string,
    parts : seq<CB.BeaconPart>,
    ghost numSigned : uint64
  )
    : (ret : Result<seq<CB.Constructor>, Error>)
    requires 0 < |parts|
    requires constructors.Some? ==> 0 < |constructors.value|
    requires numSigned as nat <= |parts|
    requires CB.OrderedParts(parts, numSigned as nat)
    ensures ret.Success? ==>
              && (constructors.None? ==> |ret.value| == 1)
              && (constructors.Some? ==> |ret.value| == |constructors.value|)

    //= specification/searchable-encryption/beacons.md#default-construction
    //= type=implication
    //# * If no constructors are configured, a default constructor MUST be generated.
    ensures ret.Success? && constructors.None? ==>
              ret == MakeDefaultConstructor(parts, parts, numSigned)
  {
    if constructors.None? then
      MakeDefaultConstructor(parts, parts, numSigned)
    else
      AddConstructors2(constructors.value, name, parts, |constructors.value|)
  }

  function method {:tailrecursion} GetGlobalPartsFrom(cons : seq<ConstructorPart>, globalParts : PartSet, signed : bool, parts : PartSet)
    : (ret : Result<PartSet, Error>)
    requires forall x <- parts.parts :: IsSignedPart(x, signed)
    ensures ret.Success? ==> forall x <- ret.value.parts :: IsSignedPart(x, signed)
  {
    if |cons| == 0 then
      Success(parts)
    else
      var newPart := FindGlobalPart(globalParts.parts, cons[0], signed);
      if newPart.Some? then
        var newParts :- parts.add(newPart.value, "Global Parts List");
        GetGlobalPartsFrom(cons[1..], globalParts, signed, newParts)
      else
        GetGlobalPartsFrom(cons[1..], globalParts, signed, parts)
  }

  function method {:tailrecursion} GetGlobalParts(cons : seq<Constructor>, globalParts : PartSet, signed : bool, parts : PartSet := PartSet([], {}, {}))
    : (ret : Result<PartSet, Error>)
    requires forall x <- parts.parts :: IsSignedPart(x, signed)
    ensures ret.Success? ==> forall x <- ret.value.parts :: IsSignedPart(x, signed)
  {
    if |cons| == 0 then
      Success(parts)
    else
      var newParts :- GetGlobalPartsFrom(cons[0].parts, globalParts, signed, parts);
      GetGlobalParts(cons[1..], globalParts, signed, newParts)
  }

  function method {:opaque} GetAllEncryptedParts(
    parts : seq<EncryptedPart>,
    cons : seq<Constructor>,
    globalEncryptedParts : PartSet,
    name : string,
    std : I.BeaconMap
  )
    : (ret : Result<seq<CB.BeaconPart>, Error>)
    ensures ret.Success? ==> forall x <- ret.value :: x.Encrypted?
  {
    var p1 :- GetEncryptedParts(parts, std, "Compound beacon " + name);
    var p2 :- GetGlobalParts(cons, globalEncryptedParts, false);
    var both :- p1.combine(p2, name, "Global Parts List");
    Success(both.parts)
  }

  predicate method IsSignedPart(part : CB.BeaconPart, signed : bool)
  {
    if signed then
      part.Signed?
    else
      part.Encrypted?
  }

  function method {:tailrecursion} FindGlobalPart(globalParts : seq<CB.BeaconPart>, cons : ConstructorPart, signed : bool)
    : (ret : Option<CB.BeaconPart>)
    ensures ret.Some? && signed ==> ret.value.Signed?
    ensures ret.Some? && !signed ==> ret.value.Encrypted?
  {
    if |globalParts| == 0 then
      None
    else if IsSignedPart(globalParts[0], signed) && globalParts[0].getName() == cons.name then
      Some(globalParts[0])
    else
      FindGlobalPart(globalParts[1..], cons, signed)
  }

  function method {:opaque} GetAllSignedParts(
    parts : seq<SignedPart>,
    cons : seq<Constructor>,
    globalSignedParts : PartSet,
    name : string,
    outer : DynamoDbTableEncryptionConfig
  )
    : (ret : Result<seq<CB.BeaconPart>, Error>)
    ensures ret.Success? ==> forall x <- ret.value :: x.Signed?
  {
    var p1 :- GetSignedParts(parts, outer, name);
    var p2 :- GetGlobalParts(cons, globalSignedParts, true);
    var both :- p1.combine(p2, name, "Global Parts List");
    Success(both.parts)
  }

  function method {:opaque} {:tailrecursion} CheckSignedParts(parts : seq<SignedPart>, globals : PartSet, name : string) : Result<bool, Error>
  {
    if |parts| == 0 then
      Success(true)
    else if parts[0].name in globals.names then
      Failure(E("Compound beacon " + name + " defines signed part " + parts[0].name + " which is already defined as a global part."))
    else if parts[0].prefix in globals.prefixes then
      Failure(E("Compound beacon " + name + " defines signed part " + parts[0].name + " with prefix " + parts[0].prefix + " which is already defined as the prefix of a global part."))
    else
      CheckSignedParts(parts[1..], globals, name)
  }

  function method {:opaque} {:tailrecursion} CheckEncryptedParts(parts : seq<EncryptedPart>, globals : PartSet, name : string) : Result<bool, Error>
  {
    if |parts| == 0 then
      Success(true)
    else if parts[0].name in globals.names then
      Failure(E("Compound beacon " + name + " defines encrypted part " + parts[0].name + " which is already defined as a global part."))
    else if parts[0].prefix in globals.prefixes then
      Failure(E("Compound beacon " + name + " defines encrypted part " + parts[0].name + " with prefix " + parts[0].prefix + " which is already defined as the prefix of a global part."))
    else
      CheckEncryptedParts(parts[1..], globals, name)
  }

  // Construct a CompoundBeacon from its configuration
  function method {:opaque} CreateCompoundBeacon(
    beacon : CompoundBeacon,
    outer : DynamoDbTableEncryptionConfig,
    client: Primitives.AtomicPrimitivesClient,
    virtualFields : V.VirtualFieldMap,
    converted : I.BeaconMap,
    globalSignedParts : PartSet,
    globalEncryptedParts : PartSet
  )
    : (ret : Result<CB.ValidCompoundBeacon, Error>)

    ensures beacon.name in converted ==> ret.Failure?
    ensures beacon.name in outer.attributeActionsOnEncrypt && outer.attributeActionsOnEncrypt[beacon.name] != SE.ENCRYPT_AND_SIGN ==> ret.Failure?

    //= specification/searchable-encryption/beacons.md#signed-beacons
    //= type=implication
    //# The beacon value MUST be stored as `NAME`, rather than the usual `aws_dbe_b_NAME`.
    ensures ret.Success? ==>
              && var encryptedParts := if beacon.encrypted.Some? then beacon.encrypted.value else [];
              && var constructors := if beacon.constructors.Some? then beacon.constructors.value else [];
              && var encrypted := GetAllEncryptedParts(encryptedParts, constructors, globalEncryptedParts, beacon.name, converted);
              && encrypted.Success?
              && ret.value.base.name == beacon.name
              && (|encrypted.value| == 0 ==> ret.value.base.beaconName == beacon.name)
              && (|encrypted.value| != 0 ==> ret.value.base.beaconName == BeaconPrefix + beacon.name)

    //= specification/searchable-encryption/beacons.md#default-construction
    //= type=implication
    //# * Initialization MUST fail if no constructors are configured, and no local parts are configured.
    ensures
      && var encryptedParts := if beacon.encrypted.Some? then beacon.encrypted.value else [];
      && var signedParts := if beacon.signed.Some? then beacon.signed.value else [];
      && (!(beacon.constructors.Some? || |signedParts| != 0 || |encryptedParts| != 0) ==> ret.Failure?)
  {
    // because UnwrapOr doesn't verify when used on a list with a minimum size
    var signedParts := if beacon.signed.Some? then beacon.signed.value else [];
    var encryptedParts := if beacon.encrypted.Some? then beacon.encrypted.value else [];
    var constructors := if beacon.constructors.Some? then beacon.constructors.value else [];
    var globalParts :- globalSignedParts.combine(globalEncryptedParts, "Global Signed Parts List", "Global Encrypted Parts List");
    var _ :- CheckSignedParts(signedParts, globalParts, beacon.name);
    var _ :- CheckEncryptedParts(encryptedParts, globalParts, beacon.name);
    var signed :-    GetAllSignedParts(   signedParts,    constructors, globalSignedParts,    beacon.name, outer);
    var encrypted :- GetAllEncryptedParts(encryptedParts, constructors, globalEncryptedParts, beacon.name, converted);

    :- Need(beacon.name !in converted, E("Duplicate CompoundBeacon name : " + beacon.name));
    :- Need(beacon.constructors.None? || 0 < |beacon.constructors.value|, E("For beacon " + beacon.name + " an empty constructor list was supplied."));
    :- Need(beacon.constructors.Some? || |signedParts| != 0 || |encryptedParts| != 0,
            E("Compound beacon " + beacon.name + " defines no constructors, and also no local parts. Cannot make a default constructor from global parts."));

    SequenceIsSafeBecauseItIsInMemory(signed);
    var numNon := |signed| as uint64;
    assert CB.OrderedParts(signed, numNon as nat);
    var allParts := signed + encrypted;
    assert CB.OrderedParts(allParts, numNon as nat);

    var isSignedBeacon := |encrypted| == 0;
    var _ :- BeaconNameAllowed(outer, virtualFields, beacon.name, "CompoundBeacon", isSignedBeacon);

    :- Need(0 < |allParts|, E("For beacon " + beacon.name + " no parts were supplied."));
    var constructors :- AddConstructors(beacon.constructors, beacon.name, allParts, numNon);

    var beaconName := if isSignedBeacon then beacon.name else BeaconPrefix + beacon.name;
    :- Need(DDB.IsValid_AttributeName(beaconName), E(beaconName + " is not a valid attribute name."));

    CB.MakeCompoundBeacon(
      B.BeaconBase (
        client := client,
        name := beacon.name,
        beaconName := beaconName
      ),
      beacon.split[0],
      allParts,
      numNon as nat,
      constructors
    )
  }
  // convert configured CompoundBeacons to internal BeaconMap
  method {:tailrecursion} AddCompoundBeacons(
    beacons : seq<CompoundBeacon>,
    outer : DynamoDbTableEncryptionConfig,
    client: Primitives.AtomicPrimitivesClient,
    virtualFields : V.VirtualFieldMap,
    converted : I.BeaconMap,
    globalSignedParts : PartSet,
    globalEncryptedParts : PartSet
  )
    returns (output : Result<I.BeaconMap, Error>)
    modifies client.Modifies
    requires client.ValidState()
    ensures client.ValidState()

    //= specification/searchable-encryption/search-config.md#beacon-version-initialization
    //= type=implication
    //# Initialization MUST fail if there is any duplicates among the names of the
    //# [compound beacons](beacons.md#compound-beacon)

    //= specification/searchable-encryption/search-config.md#beacon-version-initialization
    //= type=implication
    //# Initialization MUST fail if the name of a
    //# [compound beacons](beacons.md#compound-beacon)
    //# matches the name of a
    //# [standard beacons](beacons.md#standard-beacon)
    ensures 0 < |beacons| && beacons[0].name in converted ==> output.Failure?

    //= specification/searchable-encryption/search-config.md#beacon-version-initialization
    //= type=implication
    //# Initialization MUST fail if the name of any [compound beacon](beacons.md#compound-beacon)
    //# matches that of any unencrypted [configured field](#configured-field).
    ensures 0 < |beacons| && beacons[0].name in outer.attributeActionsOnEncrypt && outer.attributeActionsOnEncrypt[beacons[0].name] != SE.ENCRYPT_AND_SIGN ==> output.Failure?
  {
    if |beacons| == 0 {
      return Success(converted);
    }
    var newBeacon :- CreateCompoundBeacon(beacons[0], outer, client, virtualFields, converted, globalSignedParts, globalEncryptedParts);
    output := AddCompoundBeacons(beacons[1..], outer, client, virtualFields, converted[beacons[0].name := I.Compound(newBeacon)], globalSignedParts, globalEncryptedParts);
  }

  // Is `name` referred to by some compound beacon in `data`
  predicate method ExistsInCompound(names : seq<string>, name : string, data : I.BeaconMap)
    requires forall x <- names :: x in data
  {
    if |names| == 0 then
      false
    else
      var b := data[names[0]];
      if b.Compound? && b.cmp.HasBeacon(name) then
        true
      else
        ExistsInCompound(names[1..], name, data)
  }

  // Are all beacons internally consistent?
  // Are all PartOnly beacons referred to by some compound beacon?
  function method CheckAllBeacons(names : seq<string>, allNames : seq<string>, data : I.BeaconMap) : (ret : Result<bool, Error>)
    requires forall x <- names :: x in data
    requires forall x <- allNames :: x in data

    //= specification/searchable-encryption/beacons.md#partonly-initialization
    //= type=implication
    //# Initialization MUST fail if the configuration does not use a PartOnly in a [compound beacon](#compound-beacon).
    ensures |names| != 0 && I.IsPartOnly(data[names[0]]) && !ExistsInCompound(allNames, names[0], data) ==> ret.Failure?

    ensures ret.Success? && 0 < |names| && data[names[0]].Standard? && data[names[0]].std.share.Some? ==>
              && var share := data[names[0]].std.share.value;
              && IsValidShare(data, names[0], data[names[0]].std.length, share).Success?
                 //= specification/searchable-encryption/beacons.md#shared-initialization
                 //= type=implication
                 //# This name MUST be the name of a previously defined Standard Beacon.
              && share in data
              && data[share].Standard?
                 //= specification/searchable-encryption/beacons.md#shared-initialization
                 //= type=implication
                 //# This beacon's [length](#beacon-length) MUST be equal to the `other` beacon's [length](#beacon-length).
              && data[share].std.length == data[names[0]].std.length
  {
    if |names| == 0 then
      Success(true)
    else
      var b := data[names[0]];
      if I.IsPartOnly(b) && !ExistsInCompound(allNames, names[0], data) then
        Failure(E("PartOnly beacon " + names[0] + " MUST be used in a compound beacon."))
      else if b.Standard? && b.std.share.Some? then
        var _ :- IsValidShare(data, names[0], b.std.length, b.std.share.value);
        CheckAllBeacons(names[1..], allNames, data)
      else
        CheckAllBeacons(names[1..], allNames, data)
  }

  // Are all beacons internally consistent?
  function method CheckBeacons(data : I.BeaconMap) : Result<bool, Error>
  {
    var beaconNames := SortedSets.ComputeSetToOrderedSequence2(data.Keys, CharLess);
    CheckAllBeacons(beaconNames, beaconNames, data)
  }
}
