// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[derive(Debug, PartialEq, Copy, Clone)]
#[allow(missing_docs)]
pub enum CryptoAction {
    EncryptAndSign,
    SignAndIncludeInEncryptionContext,
    SignOnly,
    DoNothing,
}

impl ::std::fmt::Display for CryptoAction {
    fn fmt(&self, f: &mut ::std::fmt::Formatter) -> ::std::fmt::Result {
        match self {
            CryptoAction::EncryptAndSign => write!(f, "ENCRYPT_AND_SIGN"),
            CryptoAction::SignAndIncludeInEncryptionContext => {
                write!(f, "SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT")
            }
            CryptoAction::SignOnly => write!(f, "SIGN_ONLY"),
            CryptoAction::DoNothing => write!(f, "DO_NOTHING"),
        }
    }
}
