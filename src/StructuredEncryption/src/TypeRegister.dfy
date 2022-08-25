// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../../../private-aws-encryption-sdk-dafny-staging/src/StandardLibrary/StandardLibrary.dfy"
include "../Model/AwsCryptographyStructuredEncryptionTypes.dfy"

module TypeRegister {
  import opened Wrappers
  import opened StandardLibrary.UInt
  import Types = AwsCryptographyStructuredEncryptionTypes

  // TODO can this be part of the smithy model?
  const BYTES_TYPE_ID := [0x00 as uint8, 0x62 as uint8];

  type TypeRegister = register : map<Types.TerminalTypeId, Types.TypeEntry> | ValidTypeRegister(register)
    witness *

  predicate ValidTypeRegister(register: map<Types.TerminalTypeId, Types.TypeEntry>) {
    // Type safety here will be really annoying :(
    && (forall k :: k in register.Keys ==> register[k].typeId == k)
    && (BYTES_TYPE_ID !in register.Keys)
  }
}
