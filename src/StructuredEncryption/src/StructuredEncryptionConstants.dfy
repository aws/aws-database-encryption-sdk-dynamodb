// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
include "../../../private-aws-encryption-sdk-dafny-staging/src/StandardLibrary/StandardLibrary.dfy"

// TODO due to how we are building right now, we can't just name this "Constants"
// or we run into a "duplicate module" error
module StructuredEncryptionConstants {
    import opened StandardLibrary.UInt
    const BYTES_TYPE_ID : seq<uint8> := [0x62, 0x73];
}
