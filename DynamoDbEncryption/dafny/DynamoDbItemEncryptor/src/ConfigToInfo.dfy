// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

/*
  Convert from smithy-based SearchConfig configuration to the underlying SearchInfo object

  The only entry point of interest is 

<<<<<<<< HEAD:DynamoDbEncryption/dafny/DynamoDbEncryption/src/ConfigToInfo.dfy
  Convert(outer : DynamoDbTableEncryptionConfig, config : Option<AwsCryptographyDynamoDbEncryptionTransformsTypes.SearchConfig>)
========
  Convert(outer : DynamoDbItemEncryptorConfig, config : Option<AwsCryptographyDynamoDbEncryptionTypes.SearchConfig>)
>>>>>>>> 9f84138 (refactor: Refactor danfy local service dir structure):DynamoDbEncryption/dafny/DynamoDbItemEncryptor/src/ConfigToInfo.dfy
    : Option<SearchableEncryptionInfo.SearchInfo>
  
  e.g. client.info :- Convert(config, config.beacons)
*/


<<<<<<<< HEAD:DynamoDbEncryption/dafny/DynamoDbEncryption/src/ConfigToInfo.dfy
include "Util.dfy"
include "SearchInfo.dfy"
========
include "../Model/AwsCryptographyDynamoDbEncryptionItemEncryptorTypes.dfy"
include "../../StructuredEncryption/src/SearchInfo.dfy"
include "Util.dfy"
>>>>>>>> 9f84138 (refactor: Refactor danfy local service dir structure):DynamoDbEncryption/dafny/DynamoDbItemEncryptor/src/ConfigToInfo.dfy

module SearchConfigToInfo {
  import opened AwsCryptographyDynamoDbEncryptionTypes
  import opened StandardLibrary
  import opened Wrappers
  import opened StandardLibrary.UInt
  import opened DynamoDbEncryptionUtil
  import opened TermLoc

  import I = SearchableEncryptionInfo
  import V = DdbVirtualFields
  import B = BaseBeacon
  import CB = CompoundBeacon
  import SE = AwsCryptographyStructuredEncryptionTypes
  import Prim = AwsCryptographyPrimitivesTypes
  import Aws.Cryptography.Primitives

  // convert configured SearchConfig to internal SearchInfo
  method Convert(outer : DynamoDbTableEncryptionConfig, config : Option<SearchConfig>)
    returns (ret : Result<Option<I.SearchInfo>, Error>)
    ensures ret.Success? && ret.value.Some? ==>
      && ret.value.value.ValidState()
  {
    if config.None? {
      return Success(None);
    } else {
      :- Need(config.value.writeVersion == 1, E("writeVersion must be '1'."));
      :- Need(|config.value.versions| == 1, E("search config must be have exactly one version."));
      var version :- ConvertVersion(outer, config.value.versions[0]);
      var info := I.SearchInfo(versions := [version], currWrite := 0);
      var _ :- info.CheckValid();
      return Success(Some(info));
    }
  }
  
  // TODO : Placeholder
  function method GetPersistentKey(keyring: AwsCryptographyMaterialProvidersTypes.IKeyring)
    : Result<Bytes, Error>
  {
    Success([1,2,3,4,5])
  }

  // convert persistent key to the derived key for this beacon
  method GetBeaconKey(client : Primitives.AtomicPrimitivesClient, key : Bytes, name : string)
    returns (output : Result<Bytes, Error>)
    modifies client.Modifies
    requires client.ValidState()
    ensures client.ValidState()
  {
    var info :- UTF8.Encode("AWS_DBE_SCAN_BEACON" + name).MapFailure(e => E(e));
    var foo := client.Hkdf(Prim.HkdfInput(
      digestAlgorithm := Prim.SHA_512,
      salt := None,
      ikm := key,
      info := info,
      expectedLength := 64
    ));
    return Failure(E(""));
  }

  // convert configured BeaconVersion to internal BeaconVersion
  method ConvertVersion(outer : DynamoDbTableEncryptionConfig, config : BeaconVersion)
    returns (output : Result<I.BeaconVersion, Error>)
  {
    :- Need(config.version == 1, E("Version number in BeaconVersion must be '1'."));
    :- Need((config.standardBeacons.Some? && 0 < |config.standardBeacons.value|)
         && (config.compoundBeacons.Some? && 0 < |config.compoundBeacons.value|),
         E("At least one beacon must be configured."));
    var maybePrimitives := Primitives.AtomicPrimitives();
    // TODO var primitives :- maybePrimitives.MapFailure(e => AwsCryptographyPrimitives(e));
    var primitives :- maybePrimitives.MapFailure(e => E("Bad primitives construction"));

    var configVirtualFields: Option<VirtualFieldList> := None;
    var virtualFields :- ConvertVirtualFields(outer, configVirtualFields);
    var key :- GetPersistentKey(config.keyring);
    var beacons :- ConvertBeacons(outer, key, primitives, virtualFields, config.standardBeacons, config.compoundBeacons);
    return Success(I.BeaconVersion(
      version := config.version as I.VersionNumber,
      beacons := beacons,
      virtualFields := virtualFields
    ));
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

  // is this terminal location encrypted
  predicate method IsEncrypted(outer : DynamoDbTableEncryptionConfig, loc : TermLoc)
  {
    && var name := loc[0].key;
    && name in outer.attributeActions
    && outer.attributeActions[name] != SE.DO_NOTHING
  }

  // is this terminal location encrypted, OR does it refer to an encrypted virtual field
  predicate method IsEncryptedV(outer : DynamoDbTableEncryptionConfig, virtualFields : V.VirtualFieldMap, loc : TermLoc)
  {
    var name := loc[0].key;
    if name in outer.attributeActions then
      outer.attributeActions[name] != SE.ENCRYPT_AND_SIGN
    else if name in virtualFields then
      var vf := virtualFields[name];
      // A virtual field is encrypted if any part is encrypted
      vf.examine((t : TermLoc) => IsEncrypted(outer, t))
    else
      false
  }


  // does this name already exists as a configured attribute, or virtual field
  function method CheckExists2(outer : DynamoDbTableEncryptionConfig, virtualFields : V.VirtualFieldMap, name : string, context : string)
    : Result<bool, Error>
  {
    var _ :- CheckExists(outer, name, context);
    if name in virtualFields then
      Failure(E(name + " not allowed as a " + context + " because it already exists as a virtual field."))
    else
      Success(true)
  }

  // does this name already exists as a configured attribute
  function method CheckExists(outer : DynamoDbTableEncryptionConfig, name : string, context : string)
    : Result<bool, Error>
  {
    if name in outer.attributeActions then
      Failure(E(name + " not allowed as a " + context + " because it is already a configured attribute."))
    else if outer.allowedUnauthenticatedAttributes.Some? && name in outer.allowedUnauthenticatedAttributes.value then
      Failure(E(name + " not allowed as a " + context + " because it is already an allowed unauthenticated attribute."))
    else if outer.allowedUnauthenticatedAttributePrefix.Some? && outer.allowedUnauthenticatedAttributePrefix.value <= name then
      Failure(E(name + " not allowed as a " + context + " because it begins with the allowed unauthenticated prefix."))
    else if ReservedPrefix <= name then
      Failure(E(name + " not allowed as a " + context + " because it begins with the reserved prefix."))
    else
      Success(true)
  }

  // convert configured VirtualFields to internal VirtualFields
  function method {:tailrecursion} AddVirtualFields(
      vf : seq<AwsCryptographyDynamoDbEncryptionTypes.VirtualField>,
      outer : DynamoDbTableEncryptionConfig,
      converted : V.VirtualFieldMap := map[])
    : Result<V.VirtualFieldMap, Error>
  {
    if |vf| == 0 then
      Success(converted)
    else
      :- Need(vf[0].name !in converted, E("Duplicate VirtualField name : " + vf[0].name));
      var _ :- CheckExists(outer, vf[0].name, "VirtualField");
      var newField :- V.ParseVirtualFieldConfig(vf[0]);
      // need all parts signed
      :- Need(!newField.examine((t : TermLoc) => !IsSigned(outer, t)),
        E("VirtualField " + vf[0].name + " must be defined on signed fields."));
      AddVirtualFields(vf[1..], outer, converted[vf[0].name := newField])
  }

  // convert configured StandardBeacons to internal Beacons
  method {:tailrecursion} AddStandardBeacons(
      beacons : seq<StandardBeacon>,
      outer : DynamoDbTableEncryptionConfig,
      key : Bytes,
      client: Primitives.AtomicPrimitivesClient,
      virtualFields : V.VirtualFieldMap,
      converted : I.BeaconMap := map[])
    returns (output : Result<I.BeaconMap, Error>)
    modifies client.Modifies
    requires client.ValidState()
    ensures client.ValidState()
  {
    if |beacons| == 0 {
      return Success(converted);
    }
    :- Need(beacons[0].name !in converted, E("Duplicate StandardBeacon name : " + beacons[0].name));
    var _ :- CheckExists2(outer, virtualFields, beacons[0].name, "StandardBeacon");
    var newKey :- GetBeaconKey(client, key, beacons[0].name);
    var locString := if beacons[0].loc.Some? then beacons[0].loc.value else beacons[0].name;
    var newBeacon :- B.MakeStandardBeacon(client, beacons[0].name, newKey, beacons[0].length as B.BeaconLength, locString);
    :- Need(IsEncryptedV(outer, virtualFields, newBeacon.loc), E("StandardBeacon " + beacons[0].name + " not defined on an encrypted field."));
    output := AddStandardBeacons(beacons[1..], outer, key, client, virtualFields, converted[beacons[0].name := I.Standard(newBeacon)]);
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

  // convert configured NonSensitivePart to internal BeaconPart
  function method {:tailrecursion} AddNonSensitiveParts(parts : seq<NonSensitivePart>, origSize : nat := |parts|, converted : seq<CB.BeaconPart> := [])
    : (ret : Result<seq<CB.BeaconPart>, Error>)
    requires origSize == |parts| + |converted|
    ensures ret.Success? ==> |ret.value| == origSize
  {
    if |parts| == 0 then
      Success(converted)
    else
      var loc :- GetLoc(parts[0].name, parts[0].loc);
      var newPart := CB.BeaconPart(parts[0].name, loc, parts[0].prefix, None);
      AddNonSensitiveParts(parts[1..], origSize, converted + [newPart])
  }

  // convert configured SensitivePart to internal BeaconPart
  function method AddSensitiveParts(parts : seq<SensitivePart>, origSize : nat, converted : seq<CB.BeaconPart>)
    : (ret : Result<seq<CB.BeaconPart>, Error>)
    requires origSize == |parts| + |converted|
    ensures ret.Success? ==> |ret.value| == origSize
  {
    if |parts| == 0 then
      Success(converted)
    else
      var loc :- GetLoc(parts[0].name, parts[0].loc);
      var newPart := CB.BeaconPart(parts[0].name, loc, parts[0].prefix, Some(parts[0].length as B.BeaconLength));
      AddSensitiveParts(parts[1..], origSize, converted + [newPart])
  }

  // create the default constructor, if not constructor is specified
  function method MakeDefaultConstructor(parts : seq<CB.BeaconPart>, converted : seq<CB.ConstructorPart> := [])
    : (ret : Result<seq<CB.Constructor>, Error>)
    requires 0 < |parts| + |converted|
    ensures ret.Success? ==>
      && |ret.value| == 1
      && |ret.value[0].parts| == |parts| + |converted|
  {
    if |parts| == 0 then
      Success([CB.Constructor(converted)])
    else
      MakeDefaultConstructor(parts[1..], converted + [CB.ConstructorPart(parts[0].name, true)])
  }

  // convert configured ConstructorParts to internal ConstructorParts
  function method MakeConstructor2(c : seq<ConstructorPart>, parts : seq<CB.BeaconPart>, origSize : nat, converted : seq<CB.ConstructorPart> := [])
    : (ret : Result<seq<CB.ConstructorPart>, Error>)
    requires origSize == |c| + |converted|
    ensures ret.Success? ==> |ret.value| == origSize
  {
    if |c| == 0 then
      Success(converted)
    else
      :- Need(exists p <- parts :: p.name == c[0].name, E("Constructor refers to part name " + c[0].name + " but there is no part by that name."));
      var newPart := CB.ConstructorPart(c[0].name, c[0].required);
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
  function method AddConstructors2(constructors : seq<Constructor>, parts : seq<CB.BeaconPart>, origSize : nat, converted : seq<CB.Constructor> := [])
    : (ret : Result<seq<CB.Constructor>, Error>)
    requires 0 < origSize
    requires origSize == |constructors| + |converted|
    ensures ret.Success? ==> |ret.value| == origSize
  {
    if |constructors| == 0 then
      Success(converted)
    else
      :- Need(0 < |constructors[0].parts|, E("Every constructor must have at least one part."));
      var c :- MakeConstructor(constructors[0], parts);
      AddConstructors2(constructors[1..], parts, origSize, converted + [c])
  }

  // convert configured Constructors to internal Constructors
  function method AddConstructors(constructors : Option<ConstructorList>, parts : seq<CB.BeaconPart>)
    : (ret : Result<seq<CB.Constructor>, Error>)
    requires 0 < |parts|
    requires constructors.Some? ==> 0 < |constructors.value|
    ensures ret.Success? ==>
      && (constructors.None? ==> |ret.value| == 1)
      && (constructors.Some? ==> |ret.value| == |constructors.value|)
  {
    if constructors.None? then
      MakeDefaultConstructor(parts)
    else
      AddConstructors2(constructors.value, parts, |constructors.value|)
  }

  // convert configured CompoundBeacons to internal BeaconMap
  method {:tailrecursion} AddCompoundBeacons(
      beacons : seq<CompoundBeacon>,
      outer : DynamoDbTableEncryptionConfig,
      key : Bytes,
      client: Primitives.AtomicPrimitivesClient,
      virtualFields : V.VirtualFieldMap,
      converted : I.BeaconMap := map[])
    returns (output : Result<I.BeaconMap, Error>)
    modifies client.Modifies
    requires client.ValidState()
    ensures client.ValidState()
  {
    if |beacons| == 0 {
      return Success(converted);
    }
    :- Need(beacons[0].name !in converted, E("Duplicate CompoundBeacon name : " + beacons[0].name));
    var _ :- CheckExists(outer, beacons[0].name, "CompoundBeacon");
    var newKey :- GetBeaconKey(client, key, beacons[0].name);

    // because UnwrapOr doesn't verify when used on a list with a minimum size
    var parts :- AddNonSensitiveParts(
      if beacons[0].nonSensitive.Some? then beacons[0].nonSensitive.value else []);
    :- Need(0 < |beacons[0].sensitive|, E("Beacon " + beacons[0].name + " failed to provide a sensitive part."));
    parts :- AddSensitiveParts(beacons[0].sensitive, |parts| + |beacons[0].sensitive|, parts);
    :- Need(beacons[0].constructors.None? || 0 < |beacons[0].constructors.value|, E("For beacon " + beacons[0].name + " an empty constructor list was supplied."));
    var constructors :- AddConstructors(beacons[0].constructors, parts);
    var beaconName := BeaconPrefix + beacons[0].name;
    :- Need(DDB.IsValid_AttributeName(beaconName), E(beaconName + " is not a valid attribute name."));

    var newBeacon := CB.CompoundBeacon(
      B.BeaconBase (
        client := client,
        name := beacons[0].name,
        beaconName := beaconName,
        key := key
      ),
      beacons[0].split[0],
      parts,
      constructors
    );
    output := AddCompoundBeacons(beacons[1..], outer, key, client, virtualFields, converted[beacons[0].name := I.Compound(newBeacon)]);
  }

  // convert configured Beacons to internal BeaconMap
  method ConvertBeacons(
    outer : DynamoDbTableEncryptionConfig,
    key : Bytes,
    client: Primitives.AtomicPrimitivesClient,
    virtualFields : V.VirtualFieldMap,
    standard : Option<StandardBeaconList>,
    compound : Option<CompoundBeaconList>)
    returns (output : Result<I.BeaconMap, Error>)
    modifies client.Modifies
    requires client.ValidState()
    ensures client.ValidState()
  {
    if standard.None? && compound.None? {
      return Failure(E("At least one beacon must be configured."));
    } else if standard.Some? && compound.Some? {
      var std :- AddStandardBeacons(standard.value, outer, key, client, virtualFields);
      output := AddCompoundBeacons(compound.value, outer, key, client, virtualFields, std);
    } else if standard.Some? {
      output := AddStandardBeacons(standard.value, outer, key, client, virtualFields);
    } else {
      output := AddCompoundBeacons(compound.value, outer, key, client, virtualFields, map[]);
    }
  }
}
