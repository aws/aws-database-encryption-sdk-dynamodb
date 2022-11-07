include "../../../private-aws-encryption-sdk-dafny-staging/libraries/src/Wrappers.dfy"
include "../../../private-aws-encryption-sdk-dafny-staging/src/StandardLibrary/StandardLibrary.dfy"
include "../../../private-aws-encryption-sdk-dafny-staging/src/StandardLibrary/UInt.dfy"

module Beacon.Beacon {
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt

  newtype bitlength = x | 0 < x < 64 witness 1

  datatype Beacon = Beacon(
    nameonly name:string,
    nameonly key: seq<uint8>,
    nameonly length: bitlength,
    nameonly prefix: Option<char>,
    nameonly split: Option<char>,
    nameonly splitLens : seq<bitlength>,
    nameonly inner: Option<char>,
    nameonly ignore: Option<char>
  )
}
