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

  class Beacon {
    const name: string;
    const key: seq<uint8>;
    const length: bitlength;
    const prefix: Option<asciiByte>;
    const split: Option<asciiByte>;
    const splitLens : seq<bitlength>;
    const inner: Option<asciiByte>;
    const ignore: Option<asciiByte>;
  }
}
