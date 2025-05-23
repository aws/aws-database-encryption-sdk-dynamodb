// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[derive(Debug, PartialEq, Copy, Clone)]
#[allow(missing_docs)]
pub enum PlaintextOverride {
    ForcePlaintextWriteAllowPlaintextRead,
    ForbidPlaintextWriteAllowPlaintextRead,
    ForbidPlaintextWriteForbidPlaintextRead,
}

impl ::std::fmt::Display for PlaintextOverride {
    fn fmt(&self, f: &mut ::std::fmt::Formatter) -> ::std::fmt::Result {
        match self {
            PlaintextOverride::ForcePlaintextWriteAllowPlaintextRead => {
                write!(f, "FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ")
            }
            PlaintextOverride::ForbidPlaintextWriteAllowPlaintextRead => {
                write!(f, "FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ")
            }
            PlaintextOverride::ForbidPlaintextWriteForbidPlaintextRead => {
                write!(f, "FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ")
            }
        }
    }
}
