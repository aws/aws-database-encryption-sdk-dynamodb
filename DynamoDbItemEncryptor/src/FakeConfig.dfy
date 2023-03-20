// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyDynamoDbItemEncryptorTypes.dfy"


module SearchableEncryptionParseConfig {

  import opened AwsCryptographyDynamoDbItemEncryptorTypes
  import opened StandardLibrary
  import opened Wrappers
  import opened StandardLibrary.UInt

 datatype BeaconVersion = | BeaconVersion (
 nameonly version: VersionNumber ,
 nameonly keyring: AwsCryptographyMaterialProvidersTypes.IKeyring ,
 nameonly standardBeacons: Option<StandardBeaconList> ,
 nameonly compoundBeacons: Option<CompoundBeaconList> ,
 nameonly virtualFields: Option<VirtualFieldList>
 )
 type BeaconVersionList = seq<BeaconVersion>
 type BitLength = x: int32 | IsValid_BitLength(x) witness *
 predicate method IsValid_BitLength(x: int32) {
 ( 1 <= x <= 63 )
}
 type Char = x: string | IsValid_Char(x) witness *
 predicate method IsValid_Char(x: string) {
 ( 1 <= |x| <= 1 )
}
 datatype CompoundBeacon = | CompoundBeacon (
 nameonly name: string ,
 nameonly split: Char ,
 nameonly sensitive: SensitivePartsList ,
 nameonly nonSensitive: Option<NonSensitivePartsList> ,
 nameonly constructors: Option<ConstructorList>
 )
 type CompoundBeaconList = seq<CompoundBeacon>
 datatype Constructor = | Constructor (
 nameonly parts: ConstructorPartList
 )
 type ConstructorList = seq<Constructor>
 datatype ConstructorPart = | ConstructorPart (
 nameonly name: string ,
 nameonly required: bool
 )
 type ConstructorPartList = seq<ConstructorPart>

 type VersionNumber = x: int32 | IsValid_VersionNumber(x) witness *
 predicate method IsValid_VersionNumber(x: int32) {
 ( 1 <= x  )
}
 datatype VirtualField = | VirtualField (
 nameonly name: string ,
 nameonly config: string
 )
 type VirtualFieldList = seq<VirtualField>


 datatype SearchConfig = | SearchConfig (
 nameonly versions: BeaconVersionList ,
 nameonly writeVersion: VersionNumber
 )
 datatype SensitivePart = | SensitivePart (
 nameonly name: string ,
 nameonly length: BitLength ,
 nameonly loc: Option<TerminalLocation>
 )
 type SensitivePartsList = seq<SensitivePart>
 datatype StandardBeacon = | StandardBeacon (
 nameonly name: string ,
 nameonly length: BitLength ,
 nameonly loc: Option<TerminalLocation>
 )
 type StandardBeaconList = seq<StandardBeacon>
 type TerminalLocation = x: string | IsValid_TerminalLocation(x) witness *
 predicate method IsValid_TerminalLocation(x: string) {
 ( 1 <= |x|  )
}


 datatype NonSensitivePart = | NonSensitivePart (
 nameonly name: string ,
 nameonly loc: Option<TerminalLocation>
 )
 type NonSensitivePartsList = seq<NonSensitivePart>

}