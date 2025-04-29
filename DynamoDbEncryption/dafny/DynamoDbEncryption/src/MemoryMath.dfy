// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

// When dealing with actual data in actual memory, we can be confident that
// none of the numbers will exceed an exabyte, so we can use uint64, rather than nat.
// To convince Dafny that this is true, we have the following functions
// with assumptions as needed.


include "../Model/AwsCryptographyDbEncryptionSdkDynamoDbTypes.dfy"

module {:options "--function-syntax:4"} MemoryMath {

  import opened BoundedInts


  // This is safe because it is being held in memory
  lemma {:axiom} ValueIsSafeBecauseItIsInMemory(value : nat)
    ensures value < UINT64_MAX as nat

  function {:opaque} Add(x : uint64, y : uint64) : (ret : uint64)
    ensures ret < UINT64_MAX as uint64
    ensures ret as nat == x as nat + y as nat
  {
    ValueIsSafeBecauseItIsInMemory(x as nat + y as nat);
    x + y
  }

  function {:opaque} Add3(x : uint64, y : uint64, z : uint64) : (ret : uint64)
    ensures ret < UINT64_MAX as uint64
    ensures ret as nat == x as nat + y as nat + z as nat
  {
    ValueIsSafeBecauseItIsInMemory(x as nat + y as nat + z as nat);
    x + y + z
  }


}