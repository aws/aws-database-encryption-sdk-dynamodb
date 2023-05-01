// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

/*
  Convert from smithy-based SearchConfig configuration to the underlying SearchInfo object

  The only entry point of interest is 

  Convert(outer : DynamoDbTableEncryptionConfig, config : Option<AwsCryptographyDynamoDbEncryptionTypes.SearchConfig>)
    : Option<SearchableEncryptionInfo.SearchInfo>
  
  e.g. client.info :- Convert(config, config.beacons)
*/

include "SearchInfo.dfy"
include "Util.dfy"

module SearchConfigToInfo {
  import opened AwsCryptographyDynamoDbEncryptionTypes
  import opened StandardLibrary
  import opened Wrappers
  import opened StandardLibrary.UInt
  import opened DynamoDbEncryptionUtil
  import opened TermLoc
  import MaterialProviders
  import SortedSets

  import I = SearchableEncryptionInfo
  import V = DdbVirtualFields
  import B = BaseBeacon
  import CB = CompoundBeacon
  import SE = AwsCryptographyStructuredEncryptionTypes
  import MPT = AwsCryptographyMaterialProvidersTypes
  import Aws.Cryptography.Primitives

  // convert configured SearchConfig to internal SearchInfo
  method Convert(outer : DynamoDbTableEncryptionConfig)
    returns (output : Result<Option<I.ValidSearchInfo>, Error>)
    requires ValidSearchConfig(outer.search)
    ensures output.Success? && output.value.Some? ==>
              && output.value.value.ValidState()
              && fresh(output.value.value.versions[0].keySource.client)
    //= specification/searchable-encryption/search-config.md#initialization
    //= type=implication
    //# Initialization MUST fail if the [version number](#version-number) is not `1`.
    ensures outer.search.Some? && outer.search.value.writeVersion != 1 ==> output.Failure?

    //= specification/searchable-encryption/search-config.md#initialization
    //= type=implication
    //# Initialization MUST fail if the length of the list of [beacon versions](#beacon-version) is not 1.
    ensures outer.search.Some? && |outer.search.value.versions| != 1 ==> output.Failure?
  {
    if outer.search.None? {
      return Success(None);
    } else {
      :- Need(outer.search.value.writeVersion == 1, E("writeVersion must be '1'."));
      :- Need(|outer.search.value.versions| == 1, E("search config must be have exactly one version."));
      var version :- ConvertVersion(outer, outer.search.value.versions[0]);
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

  // return true if, `keyFieldName` should be deleted from an item before writing
  function method ShouldDeleteKeyField(outer : DynamoDbTableEncryptionConfig, keyFieldName : string)
    : (ret : Result<bool, Error>)
    ensures
      && keyFieldName in outer.attributeActions
      && outer.attributeActions[keyFieldName] == SE.ENCRYPT_AND_SIGN
      ==> ret.Failure?
  {
    if keyFieldName !in outer.attributeActions then
      Success(true)
    else
      match outer.attributeActions[keyFieldName] {
        case DO_NOTHING => Success(true)
        case SIGN_ONLY => Success(false)
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
    requires client.ValidState()
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
      && config.multi.keyFieldName in outer.attributeActions
      && outer.attributeActions[config.multi.keyFieldName] == SE.ENCRYPT_AND_SIGN
      ==> output.Failure?
  {
    var mplR := MaterialProviders.MaterialProviders();
    var mpl :- mplR.MapFailure(e => AwsCryptographyMaterialProviders(e));

    //= specification/searchable-encryption/search-config.md#key-store-cache
    //# For a [Single Key Store](#single-key-store-initialization) the [Entry Capacity](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/cryptographic-materials-cache.md#entry-capacity)
    //# MUST be 1
    //# For a [Multi Key Store](#multi-key-store-initialization) the [Entry Capacity](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/cryptographic-materials-cache.md#entry-capacity)
    //# MUST be key store's max cache size.
    var cacheSize := if config.multi? then config.multi.maxCacheSize else 1;
    :- Need(0 < cacheSize, E("maxCacheSize must be at least 1."));

    //= specification/searchable-encryption/search-config.md#key-store-cache
    //# For a Beacon Key Source a [CMC](../../submodules/MaterialProviders/aws-encryption-sdk-specification/framework/cryptographic-materials-cache.md)
    //# MUST be created.
    var input := MPT.CreateCryptographicMaterialsCacheInput(
      entryCapacity := cacheSize,
      entryPruningTailSize := None
    );
    var maybeCache := mpl.CreateCryptographicMaterialsCache(input);
    var cache :- maybeCache.MapFailure(e => AwsCryptographyMaterialProviders(e));

    if config.multi? {
      :- Need(0 < config.multi.cacheTTL, E("Beacon Cache TTL must be at least 1."));
      var deleteKey :- ShouldDeleteKeyField(outer, config.multi.keyFieldName);
      output := Success(I.KeySource(client, keyStore, I.MultiLoc(config.multi.keyFieldName, deleteKey), cache, config.multi.cacheTTL as uint32));
    } else {
      :- Need(0 < config.single.cacheTTL, E("Beacon Cache TTL must be at least 1."));
      output := Success(I.KeySource(client, keyStore, I.SingleLoc(config.single.keyId), cache, config.single.cacheTTL as uint32));
    }
  }

  // convert configured BeaconVersion to internal BeaconVersion
  method ConvertVersion(outer : DynamoDbTableEncryptionConfig, config : BeaconVersion)
    returns (output : Result<I.ValidBeaconVersion, Error>)
    requires ValidBeaconVersion(config)
    ensures output.Success? ==>
              && output.value.ValidState()
              && fresh(output.value.keySource.client)

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
    output := ConvertVersionWithSource(outer, config, source);
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
  {
    var virtualFields :- ConvertVirtualFields(outer, config.virtualFields);
    var beacons :- ConvertBeacons(outer, source.client, virtualFields, config.standardBeacons, config.compoundBeacons);

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
    return I.MakeBeaconVersion(
        config.version as I.VersionNumber,
        source,
        beacons,
        virtualFields
      );
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
    && name in outer.attributeActions
    && outer.attributeActions[name] != SE.DO_NOTHING
  }

  // is this terminal location signed, but not encrypted
  predicate method IsSignOnly(outer : DynamoDbTableEncryptionConfig, loc : TermLoc)
  {
    && var name := loc[0].key;
    && name in outer.attributeActions
    && outer.attributeActions[name] == SE.SIGN_ONLY
  }

  // is this terminal location encrypted
  predicate method IsEncrypted(outer : DynamoDbTableEncryptionConfig, loc : TermLoc)
  {
    && var name := loc[0].key;
    && name in outer.attributeActions
    && outer.attributeActions[name] == SE.ENCRYPT_AND_SIGN
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
    ensures name in outer.attributeActions && outer.attributeActions[name] != SE.ENCRYPT_AND_SIGN ==> ret.Failure?
  {
    if name in outer.attributeActions && outer.attributeActions[name] != SE.ENCRYPT_AND_SIGN then
      Failure(E(name + " not allowed as a " + context + " because it is already an unencrypted attribute."))
    else if isSignedBeacon && name in outer.attributeActions then
      Failure(E(name + " not allowed as a " + context + " because a fully nonsensitive beacon cannot have the same name as an existing attribute."))
    else if outer.allowedUnauthenticatedAttributes.Some? && name in outer.allowedUnauthenticatedAttributes.value then
      Failure(E(name + " not allowed as a " + context + " because it is already an allowed unauthenticated attribute."))
    else if outer.allowedUnauthenticatedAttributePrefix.Some? && outer.allowedUnauthenticatedAttributePrefix.value <= name then
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
    if name in outer.attributeActions then
      Failure(E(name + " not allowed as a Virtual Field because it is already a configured attribute."))
    else if outer.allowedUnauthenticatedAttributes.Some? && name in outer.allowedUnauthenticatedAttributes.value then
      Failure(E(name + " not allowed as a Virtual Field because it is already an allowed unauthenticated attribute."))
    else if outer.allowedUnauthenticatedAttributePrefix.Some? && outer.allowedUnauthenticatedAttributePrefix.value <= name then
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
    vf : seq<AwsCryptographyDynamoDbEncryptionTypes.VirtualField>,
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
      var badSeq := SortedSets.ComputeSetToOrderedSequence2(badNames, CharLess);
      Some(badSeq[0])
  }

  // convert configured StandardBeacons to internal Beacons
  method {:tailrecursion} AddStandardBeacons(
    beacons : seq<StandardBeacon>,
    outer : DynamoDbTableEncryptionConfig,
    client: Primitives.AtomicPrimitivesClient,
    virtualFields : V.VirtualFieldMap,
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
    ensures 0 < |beacons| && beacons[0].name in outer.attributeActions && outer.attributeActions[beacons[0].name] != SE.ENCRYPT_AND_SIGN ==> output.Failure?

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
    var newBeacon :- B.MakeStandardBeacon(client, beacons[0].name, beacons[0].length as B.BeaconLength, locString);

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

    output := AddStandardBeacons(beacons[1..], outer, client, virtualFields, converted[beacons[0].name := I.Standard(newBeacon)]);
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

  // convert configured NonSensitivePart to internal BeaconPart
  function method {:tailrecursion} AddNonSensitiveParts(
    parts : seq<NonSensitivePart>,
    outer : DynamoDbTableEncryptionConfig,
    origSize : nat := |parts|,
    converted : seq<CB.BeaconPart> := []
  )
    : (ret : Result<seq<CB.BeaconPart>, Error>)
    requires origSize == |parts| + |converted|
    requires forall p <- converted :: p.NonSensitive?
    ensures ret.Success? ==> |ret.value| == origSize
    ensures ret.Success? ==> forall p <- ret.value :: p.NonSensitive?

    //= specification/searchable-encryption/search-config.md#beacon-version-initialization
    //= type=implication
    //# Initialization MUST fail if the [terminal location](virtual.md#terminal-location)
    //# reference by a [non-sensitive part](beacons.md#non-sensitive-part) is `encrypted`,
    //# or is not `signed`.
    ensures
      (&& 0 < |parts|
          //= specification/searchable-encryption/beacons.md#non-sensitive-part-initialization
          //= type=implication
          //# If no [terminal location](virtual.md#terminal-location) is provided,
          //# the `name` MUST be used as the [terminal location](virtual.md#terminal-location).
       && GetLoc(parts[0].name, parts[0].loc).Success?
       && var loc := GetLoc(parts[0].name, parts[0].loc).value;
       && !IsSignOnly(outer, CB.NonSensitive(parts[0].prefix, parts[0].name, loc).loc))
      ==> ret.Failure?

    //= specification/searchable-encryption/beacons.md#initialization-failure
    //= type=implication
    //# Initialization MUST fail if any [non-sensitive-part](#non-sensitive-part-initialization) contains
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
      var newPart := CB.NonSensitive(parts[0].prefix, parts[0].name, loc);
      :- Need(IsSignOnly(outer, newPart.loc), E("NonSensitive Part " + newPart.name
                                                + " is built from " + GetLocStr(parts[0].name, parts[0].loc) + " which is not SIGN_ONLY."));
      AddNonSensitiveParts(parts[1..], outer,origSize, converted + [newPart])
  }

  // convert configured SensitivePart to internal BeaconPart
  function method AddSensitiveParts(
    parts : seq<SensitivePart>,
    ghost origSize : nat,
    ghost numNonSensitive : nat,
    converted : seq<CB.BeaconPart>,
    std : I.BeaconMap
  )
    : (ret : Result<seq<CB.BeaconPart>, Error>)
    requires origSize == |parts| + |converted|
    requires numNonSensitive <= |converted|
    requires CB.OrderedParts(converted, numNonSensitive)
    ensures ret.Success? ==> |ret.value| == origSize
    //= specification/searchable-encryption/beacons.md#compound-beacon
    //= type=implication
    //# The name MUST be the name of a configured standard beacon.
    ensures ret.Success? && 0 < |parts| ==> parts[0].name in std && std[parts[0].name].Standard?
    ensures ret.Success? ==> CB.OrderedParts(ret.value, numNonSensitive)
  {
    if |parts| == 0 then
      Success(converted)
    else
    if parts[0].name in std && std[parts[0].name].Standard? then
      var newPart := CB.Sensitive(parts[0].prefix, std[parts[0].name].std);
      AddSensitiveParts(parts[1..], origSize, numNonSensitive, converted + [newPart], std)
    else
      Failure(E("Sensitive part needs standard beacon " + parts[0].name + " which is not configured."))
  }

  // create the default constructor, if not constructor is specified
  function method MakeDefaultConstructor(
    parts : seq<CB.BeaconPart>,
    ghost allParts : seq<CB.BeaconPart>,
    ghost numNon : nat,
    converted : seq<CB.ConstructorPart> := []
  )
    : (ret : Result<seq<CB.Constructor>, Error>)
    requires 0 < |parts| + |converted|
    requires |allParts| == |parts| + |converted|
    requires parts == allParts[|converted|..]
    requires numNon <= |allParts|;
    requires CB.OrderedParts(allParts, numNon)
    requires forall i | 0 <= i < |converted| ::
               && converted[i].part == allParts[i]
               && converted[i].required
    ensures ret.Success? ==>
              && |ret.value| == 1
              && |ret.value[0].parts| == |parts| + |converted|
                 //= specification/searchable-encryption/beacons.md#default-construction
                 //= type=implication
                 //# * This default constructor MUST be all of the non-sensitive parts,
                 //# followed by all the sensitive parts, all parts being required.
              && CB.OrderedParts(allParts, numNon)
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
    //# This name MUST match the name of one of the [sensitive](#sensitive-part-initialization) or [non-sensitive](#non-sensitive-part-initialization) parts.

    //= specification/searchable-encryption/beacons.md#initialization-failure
    //= type=implication
    //# Initialization MUST fail if any [constructor](#constructor) is configured with a field name
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
    //# Initialization MUST fail if any [constructor](#constructor) is configured without at least one
    //# required part.
    ensures ret.Success? && 0 < |constructors| ==>
              0 < SeqCount((p : ConstructorPart) => p.required, constructors[0].parts)

    //= specification/searchable-encryption/beacons.md#initialization-failure
    //= type=implication
    //# Initialization MUST fail if two [constructors](#constructor) are configured
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
    ghost numNonSensitive : nat
  )
    : (ret : Result<seq<CB.Constructor>, Error>)
    requires 0 < |parts|
    requires constructors.Some? ==> 0 < |constructors.value|
    requires numNonSensitive <= |parts|
    requires CB.OrderedParts(parts, numNonSensitive)
    ensures ret.Success? ==>
              && (constructors.None? ==> |ret.value| == 1)
              && (constructors.Some? ==> |ret.value| == |constructors.value|)

    //= specification/searchable-encryption/beacons.md#default-construction
    //= type=implication
    //# * If no constructors are configured, a default constructor MUST be generated.
    ensures ret.Success? && constructors.None? ==>
              ret == MakeDefaultConstructor(parts, parts, numNonSensitive)
  {
    if constructors.None? then
      MakeDefaultConstructor(parts, parts, numNonSensitive)
    else
      AddConstructors2(constructors.value, name, parts, |constructors.value|)
  }

  // Construct a CompoundBeacon from its configuration
  function method CreateCompoundBeacon(
    beacon : CompoundBeacon,
    outer : DynamoDbTableEncryptionConfig,
    client: Primitives.AtomicPrimitivesClient,
    virtualFields : V.VirtualFieldMap,
    converted : I.BeaconMap
  )
    : (ret : Result<CB.CompoundBeacon, Error>)

    //= specification/searchable-encryption/beacons.md#signed-beacons
    //= type=implication
    //# The beacon value MUST be stored as `NAME`, rather than the usual `aws_dbe_b_NAME`.
    ensures ret.Success? ==>
      && ret.value.base.name == beacon.name
      && var sensitive := if beacon.sensitive.Some? then beacon.sensitive.value else [];
      && (|sensitive| == 0 ==> ret.value.base.beaconName == beacon.name)
      && (|sensitive| != 0 ==> ret.value.base.beaconName == BeaconPrefix + beacon.name)

  {
    // because UnwrapOr doesn't verify when used on a list with a minimum size
    var nonSensitive := if beacon.nonSensitive.Some? then beacon.nonSensitive.value else [];
    var sensitive := if beacon.sensitive.Some? then beacon.sensitive.value else [];
    var isSignedBeacon := |sensitive| == 0;

    :- Need(beacon.name !in converted, E("Duplicate CompoundBeacon name : " + beacon.name));
    var _ :- BeaconNameAllowed(outer, virtualFields, beacon.name, "CompoundBeacon", isSignedBeacon);

    var parts :- AddNonSensitiveParts(nonSensitive, outer);
    var numNon := |parts|;
    assert CB.OrderedParts(parts, numNon); 

    var parts :- AddSensitiveParts(sensitive, |parts| + |sensitive|, numNon, parts, converted);
    assert CB.OrderedParts(parts, numNon);
    :- Need(0 < |parts|, E("For beacon " + beacon.name + " no parts were supplied."));
    :- Need(beacon.constructors.None? || 0 < |beacon.constructors.value|, E("For beacon " + beacon.name + " an empty constructor list was supplied."));
    var constructors :- AddConstructors(beacon.constructors, beacon.name, parts, numNon);

    var beaconName := if isSignedBeacon then beacon.name else BeaconPrefix + beacon.name;
    :- Need(DDB.IsValid_AttributeName(beaconName), E(beaconName + " is not a valid attribute name."));

    CB.MakeCompoundBeacon(
      B.BeaconBase (
        client := client,
        name := beacon.name,
        beaconName := beaconName
      ),
      beacon.split[0],
      parts,
      numNon,
      constructors
    )
  }
  // convert configured CompoundBeacons to internal BeaconMap
  method {:tailrecursion} AddCompoundBeacons(
    beacons : seq<CompoundBeacon>,
    outer : DynamoDbTableEncryptionConfig,
    client: Primitives.AtomicPrimitivesClient,
    virtualFields : V.VirtualFieldMap,
    converted : I.BeaconMap := map[])
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
    ensures 0 < |beacons| && beacons[0].name in outer.attributeActions && outer.attributeActions[beacons[0].name] != SE.ENCRYPT_AND_SIGN ==> output.Failure?
  {
    if |beacons| == 0 {
      return Success(converted);
    }
    var newBeacon :- CreateCompoundBeacon(beacons[0], outer, client, virtualFields, converted);
    output := AddCompoundBeacons(beacons[1..], outer, client, virtualFields, converted[beacons[0].name := I.Compound(newBeacon)]);
  }

  // convert configured Beacons to internal BeaconMap
  method ConvertBeacons(
    outer : DynamoDbTableEncryptionConfig,
    client: Primitives.AtomicPrimitivesClient,
    virtualFields : V.VirtualFieldMap,
    standard : StandardBeaconList,
    compound : Option<CompoundBeaconList>)
    returns (output : Result<I.BeaconMap, Error>)
    modifies client.Modifies
    requires client.ValidState()
    ensures client.ValidState()
  {
    var std :- AddStandardBeacons(standard, outer, client, virtualFields);
    if compound.Some? {
      output := AddCompoundBeacons(compound.value, outer, client, virtualFields, std);
    } else {
      output := Success(std);
    }
  }
}
