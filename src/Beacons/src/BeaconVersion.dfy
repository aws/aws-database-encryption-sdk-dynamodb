include "Beacon.dfy"
include "../../../private-aws-encryption-sdk-dafny-staging/libraries/src/Wrappers.dfy"
include "../../../private-aws-encryption-sdk-dafny-staging/src/StandardLibrary/StandardLibrary.dfy"
include "../../../private-aws-encryption-sdk-dafny-staging/src/StandardLibrary/UInt.dfy"

module Beacon.BeaconVersion {
import opened Beacon
import opened Wrappers
import opened StandardLibrary
import opened StandardLibrary.UInt

  datatype LsiStyle = LsiStyle(
    nameonly name : string, // name of the Local Secondary Index
    nameonly narrow : bool // should we treat it as NARROW
  )

  datatype PrimaryKey = PrimaryKey(
    nameonly primary : string,   // the attribute we're constructing
    nameonly partition : string, // the encrypted partition key we wish we could use
    nameonly sort : Option<string> // the encrypted sort key we wish we could use
  )

  datatype BeaconVersion = BeaconVersion(
    nameonly version : uint32,
    nameonly key : string, // magic designator for hierarchy keyring
    nameonly write : bool, // exactly one vesion must be write
    nameonly beacons : seq<Beacon>,
    nameonly primary : Option<PrimaryKey>,
    nameonly LSIs : seq<LsiStyle>
  )

  // The remaining types are placeholders, really provided by Gazelle
  datatype EncryptMode = ENCRYPT | SIGN | NOTHING
  datatype Attribute = Attribute(
    nameonly name : string,
    nameonly mode : EncryptMode
  )

  datatype TableConfig = TableConfig (
    nameonly name : string,
    nameonly attrs : seq<Attribute>,
    nameonly beacons : seq<BeaconVersion>
  )

  datatype DynamoConfig = DynamoConfig (
    nameonly tables : seq<TableConfig>
  )
}
