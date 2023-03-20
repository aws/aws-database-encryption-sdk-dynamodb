// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyDynamoDbItemEncryptorTypes.dfy"
include "../../StructuredEncryption/src/SearchInfo.dfy"
include "Util.dfy"
include "FakeConfig.dfy"

module SearchConfigToInfo {
  import opened AwsCryptographyDynamoDbItemEncryptorTypes
  import opened StandardLibrary
  import opened Wrappers
  import opened StandardLibrary.UInt
  import opened DynamoDbItemEncryptorUtil

  import C = SearchableEncryptionParseConfig
  import I = SearchableEncryptionInfo
  import V = VirtualFields
  import U = StructuredEncryptionUtil
  import P = StructuredEncryptionPaths
  import B = BaseBeacon
  import CB = CompoundBeacon
  import SE = AwsCryptographyStructuredEncryptionTypes
  import Prim = AwsCryptographyPrimitivesTypes
  import Aws.Cryptography.Primitives

  method Convert(outer : DynamoDbItemEncryptorConfig, config : Option<C.SearchConfig>)
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
      var _ :- info.CheckValid().MapFailure(e => AwsCryptographyStructuredEncryption(e));
      return Success(Some(info));
    }
  }
  
  function method GetPersistentKey(keyring: AwsCryptographyMaterialProvidersTypes.IKeyring)
    : Result<U.Bytes, Error>
  {
    Success([1,2,3,4,5])
  }

  method GetBeaconKey(client : Primitives.AtomicPrimitivesClient, key : U.Bytes, name : string)
    returns (output : Result<U.Bytes, Error>)
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

  method ConvertVersion(outer : DynamoDbItemEncryptorConfig, config : C.BeaconVersion)
    returns (output : Result<I.BeaconVersion, Error>)
  {
    :- Need(config.version == 1, E("Version number in BeaconVersion must be '1'."));
    :- Need((config.standardBeacons.Some? && 0 < |config.standardBeacons.value|)
         && (config.compoundBeacons.Some? && 0 < |config.compoundBeacons.value|),
         E("At least one beacon must be configured."));
    var maybePrimitives := Primitives.AtomicPrimitives();
    // TODO var primitives :- maybePrimitives.MapFailure(e => AwsCryptographyPrimitives(e));
    var primitives :- maybePrimitives.MapFailure(e => E("Bad primitives construction"));

    var virtualFields :- ConvertVirtualFields(outer, config.virtualFields);
    var key :- GetPersistentKey(config.keyring);
    var beacons :- ConvertBeacons(outer, key, primitives, virtualFields, config.standardBeacons.UnwrapOr([]), config.compoundBeacons.UnwrapOr([]));
    return Success(I.BeaconVersion(
      version := config.version as I.VersionNumber,
      beacons := beacons,
      virtualFields := virtualFields
    ));
  }

  function method ConvertVirtualFields(outer : DynamoDbItemEncryptorConfig, vf : Option<C.VirtualFieldList>)
    : Result<I.VirtualFieldMap, Error>
  {
    if vf.None? then
      Success(map[])
    else
      AddVirtualFields(vf.value, outer)
  }

  predicate method IsSigned(outer : DynamoDbItemEncryptorConfig, loc : P.TerminalLocation)
  {
    && var name := loc.parts[0].key;
    && name in outer.attributeActions
    && outer.attributeActions[name] != SE.DO_NOTHING
  }

  predicate method IsEncrypted(outer : DynamoDbItemEncryptorConfig, loc : P.TerminalLocation)
  {
    && var name := loc.parts[0].key;
    && name in outer.attributeActions
    && outer.attributeActions[name] != SE.DO_NOTHING
  }

  predicate method IsEncryptedV(outer : DynamoDbItemEncryptorConfig, virtualFields : I.VirtualFieldMap, loc : P.TerminalLocation)
  {
    var name := loc.parts[0].key;
    if name in outer.attributeActions then
      outer.attributeActions[name] != SE.ENCRYPT_AND_SIGN
    else if name in virtualFields then
      var vf := virtualFields[name];
      // A virtual field is encrypted if any part is encrypted
      vf.examine((t : P.TerminalLocation) => IsEncrypted(outer, t))
    else
      false
  }

  function method CheckExists(outer : DynamoDbItemEncryptorConfig, name : string, context : string)
    : Result<bool, Error>
  {
    if name in outer.attributeActions then
      Failure(E(name + " not allowed as a " + context + " because it is already a configured attribute."))
    else if outer.allowedUnauthenticatedAttributes.Some? && name in outer.allowedUnauthenticatedAttributes.value then
      Failure(E(name + " not allowed as a " + context + " because it is already an allowed unauthenticated attribute."))
    else if outer.allowedUnauthenticatedAttributePrefix.Some? && outer.allowedUnauthenticatedAttributePrefix.value <= name then
      Failure(E(name + " not allowed as a " + context + " because it begins with the allowed unauthenticated prefix."))
    else if U.ReservedPrefix <= name then
      Failure(E(name + " not allowed as a " + context + " because it begins with the reserved prefix."))
    else
      Success(true)
  }

  function method {:tailrecursion} AddVirtualFields(
      vf : seq<C.VirtualField>,
      outer : DynamoDbItemEncryptorConfig,
      converted : I.VirtualFieldMap := map[])
    : Result<I.VirtualFieldMap, Error>
  {
    if |vf| == 0 then
      Success(converted)
    else
      :- Need(vf[0].name !in converted, E("Duplicate VirtualField name : " + vf[0].name));
      var _ :- CheckExists(outer, vf[0].name, "VirtualField");
      var newField :- V.GetVirtualField(vf[0].name, vf[0].config).MapFailure(e => E(e));
      // need all parts signed
      :- Need(!newField.examine((t : P.TerminalLocation) => !IsSigned(outer, t)),
        E("VirtualField " + vf[0].name + " must be defined on signed fields."));
      AddVirtualFields(vf[1..], outer, converted[vf[0].name := newField])
  }

  method {:tailrecursion} AddStandardBeacons(
      beacons : seq<C.StandardBeacon>,
      outer : DynamoDbItemEncryptorConfig,
      key : U.Bytes,
      client: Primitives.AtomicPrimitivesClient,
      virtualFields : I.VirtualFieldMap,
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
    var _ :- CheckExists(outer, beacons[0].name, "StandardBeacon");
    var newKey :- GetBeaconKey(client, key, beacons[0].name);
    var locString := if beacons[0].loc.Some? then beacons[0].loc.value else beacons[0].name;
    var newBeacon :- B.MakeStandardBeacon(client, beacons[0].name, newKey, beacons[0].length as B.BeaconLength, locString)
      .MapFailure(e => AwsCryptographyStructuredEncryption(e));
    :- Need(IsEncryptedV(outer, virtualFields, newBeacon.loc), E("StandardBeacon " + beacons[0].name + " not defined on an encrypted field."));
    output := AddStandardBeacons(beacons[1..], outer, key, client, virtualFields, converted[beacons[0].name := I.Standard(newBeacon)]);
  }

/*
C.CompoundBeacon
  nameonly name: string ,
  nameonly split: Char ,
  nameonly sensitive: SensitivePartsList ,
  nameonly nonSensitive: Option<NonSensitivePartsList> ,
  nameonly constructors: Option<ConstructorList>
C.SensitivePart
  nameonly name: string ,
  nameonly length: BitLength ,
  nameonly loc: Option<TerminalLocation>
C.Constructor
  parts: ConstructorPartList
C.ConstructorPart
  nameonly name: string ,
  nameonly required: bool

I.CompoundBeacon
  base : BeaconBase,
  split : char,
  parts : seq<BeaconPart>, // Non-Sensitive followed by Sensitive
  construct : ConstructorList
I.BeaconPart
  fieldName : FieldName,
  loc : TerminalLocation,
  prefix : Prefix,
  length : Option<BeaconLength>
IConstructorPart
  fieldName : FieldName,
  required : bool
*/

  function method AddNonSensitiveParts(parts : seq<C.NonSensitivePart>, converted : seq<CB.BeaconPart> := [])
    : (ret : Result<seq<CB.BeaconPart>, Error>)

  function method AddSensitiveParts(parts : seq<C.SensitivePart>, converted : seq<CB.BeaconPart>)
    : (ret : Result<seq<CB.BeaconPart>, Error>)
    ensures ret.Success? ==> 0 < |ret.value|

  function method MakeDefaultConstructor(parts : seq<CB.BeaconPart>, converted : seq<CB.ConstructorPart> := [])
    : Result<seq<CB.Constructor>, Error>
    requires 0 < |parts| + |converted|
  {
    if |parts| == 0 then
      Success([CB.Constructor(converted)])
    else
      Failure(E(""))
  }

  function method AddConstructors2(constructors : seq<C.Constructor>, parts : seq<CB.BeaconPart>, converted : seq<CB.Constructor> := [])
    : Result<seq<CB.Constructor>, Error>
  {
    if |constructors| == 0 then
      Success(converted)
    else
      Failure(E(""))
  }
  function method AddConstructors(constructors : Option<C.ConstructorList>, parts : seq<CB.BeaconPart>)
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
      AddConstructors2(constructors.value, parts)
  }

  method {:tailrecursion} AddCompoundBeacons(
      beacons : seq<C.CompoundBeacon>,
      outer : DynamoDbItemEncryptorConfig,
      key : U.Bytes,
      client: Primitives.AtomicPrimitivesClient,
      virtualFields : I.VirtualFieldMap,
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

    var parts :- AddNonSensitiveParts(beacons[0].nonSensitive.UnwrapOr([]));
    parts :- AddSensitiveParts(beacons[0].sensitive, parts);
    :- Need(beacons[0].constructors.None? || 0 < |beacons[0].constructors.value|, E("For beacon " + beacons[0].name + " an empty constructor list was supplied."));
    var constructors :- AddConstructors(beacons[0].constructors, parts);
    var newBeacon := CB.CompoundBeacon(
      B.BeaconBase (
        client := client,
        name := beacons[0].name,
        key := key
      ),
      beacons[0].split[0],
      parts,
      constructors
    );
    output := AddCompoundBeacons(beacons[1..], outer, key, client, virtualFields, converted[beacons[0].name := I.Compound(newBeacon)]);
  }

  method ConvertBeacons(
    outer : DynamoDbItemEncryptorConfig,
    key : U.Bytes,
    client: Primitives.AtomicPrimitivesClient,
    virtualFields : I.VirtualFieldMap,
    standard : seq<C.StandardBeacon>,
    compound : seq<C.CompoundBeacon>)
    returns (output : Result<I.BeaconMap, Error>)
    modifies client.Modifies
    requires client.ValidState()
    ensures client.ValidState()
  {
    var std :- AddStandardBeacons(standard, outer, key, client, virtualFields);
    output := AddCompoundBeacons(compound, outer, key, client, virtualFields, std);
  }
}
