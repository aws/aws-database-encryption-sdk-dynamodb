// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[derive(Debug, PartialEq, Copy, Clone)]
#[allow(missing_docs)]
pub enum AuthenticateAction {
    Sign,
    DoNotSign,
}

impl ::std::fmt::Display for AuthenticateAction {
    fn fmt(&self, f: &mut ::std::fmt::Formatter) -> ::std::fmt::Result {
        match self {
            AuthenticateAction::Sign => write!(f, "SIGN"),
            AuthenticateAction::DoNotSign => write!(f, "DO_NOT_SIGN"),
        }
    }
}
