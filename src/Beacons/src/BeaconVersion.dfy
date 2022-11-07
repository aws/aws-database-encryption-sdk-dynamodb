include "Beacon.dfy"
include "../../../private-aws-encryption-sdk-dafny-staging/libraries/src/Wrappers.dfy"
include "../../../private-aws-encryption-sdk-dafny-staging/src/StandardLibrary/StandardLibrary.dfy"
include "../../../private-aws-encryption-sdk-dafny-staging/src/StandardLibrary/UInt.dfy"

module Beacon.BeaconVersion {
import opened Beacon
import opened Wrappers
import opened StandardLibrary
import opened StandardLibrary.UInt

  datatype PrimaryKey = PrimaryKey(
    nameonly primary : string,   // the attribute we're constructing
    nameonly partition : string, // the encrypted partition key we wish we could use
    nameonly sort : Option<string> // the encrypted sort key we wish we could use
  )

  datatype LsiStyle = NARROW | WIDE
  datatype BeaconVersion = BeaconVersion(
    nameonly version : uint32,
    nameonly key : string, // magic designator for hierarchy keyring
    nameonly write : bool, // exactly one vesion must be write
    nameonly beacons : seq<Beacon>,
    nameonly primary : Option<PrimaryKey>,
    nameonly LSIs : map<string, LsiStyle>
  )

  // The remaining types are placeholders, really provided by Gazelle
  datatype EncryptMode = ENCRYPT | SIGN | NOTHING
  datatype TableConfig = TableConfig (
    nameonly name : string,
    nameonly attrs : map<string, EncryptMode>,
    nameonly beacons : seq<BeaconVersion>
  )

  datatype DynamoConfig = DynamoConfig (
    nameonly tables : seq<TableConfig>
  )
}
