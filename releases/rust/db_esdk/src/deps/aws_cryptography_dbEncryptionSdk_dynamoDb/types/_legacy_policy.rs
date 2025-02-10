// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[derive(Debug, PartialEq, Copy, Clone)]
#[allow(missing_docs)]
pub enum LegacyPolicy {
    ForceLegacyEncryptAllowLegacyDecrypt,
    ForbidLegacyEncryptAllowLegacyDecrypt,
    ForbidLegacyEncryptForbidLegacyDecrypt,
}

impl ::std::fmt::Display for LegacyPolicy {
    fn fmt(&self, f: &mut ::std::fmt::Formatter) -> ::std::fmt::Result {
        match self {
            LegacyPolicy::ForceLegacyEncryptAllowLegacyDecrypt => {
                write!(f, "FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT")
            }
            LegacyPolicy::ForbidLegacyEncryptAllowLegacyDecrypt => {
                write!(f, "FORBID_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT")
            }
            LegacyPolicy::ForbidLegacyEncryptForbidLegacyDecrypt => {
                write!(f, "FORBID_LEGACY_ENCRYPT_FORBID_LEGACY_DECRYPT")
            }
        }
    }
}
