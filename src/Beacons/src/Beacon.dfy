include "../../../private-aws-encryption-sdk-dafny-staging/libraries/src/Wrappers.dfy"
include "../../../private-aws-encryption-sdk-dafny-staging/src/StandardLibrary/StandardLibrary.dfy"
include "../../../private-aws-encryption-sdk-dafny-staging/src/StandardLibrary/UInt.dfy"

module Beacon.Beacon {
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt

  newtype bitlength = x | 0 < x < 64 witness 1
  predicate IsAsciiByte(x : uint8) {x < 128}
  type asciiByte = x : uint8 | IsAsciiByte(x)

  datatype Beacon = Beacon(
    nameonly name:string,
    nameonly key: seq<uint8>,
    nameonly length: bitlength,
    nameonly prefix: Option<asciiByte>,
    nameonly split: Option<asciiByte>,
    nameonly splitLens : seq<bitlength>,
    nameonly inner: Option<asciiByte>,
    nameonly ignore: Option<asciiByte>
  )
}
