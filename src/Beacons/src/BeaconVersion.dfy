include "Beacon.dfy"
include "../../../private-aws-encryption-sdk-dafny-staging/libraries/src/Wrappers.dfy"
include "../../../private-aws-encryption-sdk-dafny-staging/src/StandardLibrary/StandardLibrary.dfy"
include "../../../private-aws-encryption-sdk-dafny-staging/src/StandardLibrary/UInt.dfy"

module Beacon.BeaconVersion {
import opened Beacon
import opened Wrappers
import opened StandardLibrary
import opened StandardLibrary.UInt

class LsiStyle {
  const name : string; // name of the Local Secondary Index
  const narrow : bool; // should we treat it as NARROW
}
class PrimaryKey {
  const primary : string;   // the attribute we're constructing
  const partition : string; // the encrypted partition key we wish we could use
  const sort : Option<string>; // the encrypted sort key we wish we could use
}
class BeaconVersion {
  const version : uint32;
  const key : string; // magic designator for hierarchy keyring
  const write : bool; // exactly one vesion must be write
  const beacons : seq<Beacon>;
  const primary : Option<PrimaryKey>;
  const LSIs : seq<LsiStyle>;
}

// The remaining types are placeholders, really provided by Gazelle
datatype EncryptMode = ENCRYPT | SIGN | NOTHING
class Attribute {
  const name : string;
  const mode : EncryptMode;
}

class TableConfig {
  const name : string;
  const attrs : seq<Attribute>;
  const beacons : seq<BeaconVersion>;
}

class DynamoConfig {
  const tables : seq<TableConfig>;
}

}
