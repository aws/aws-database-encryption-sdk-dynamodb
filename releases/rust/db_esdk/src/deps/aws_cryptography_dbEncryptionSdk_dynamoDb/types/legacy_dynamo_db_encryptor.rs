// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.

pub trait LegacyDynamoDbEncryptor {}

#[derive(::std::clone::Clone)]
pub struct LegacyDynamoDbEncryptorRef {
    pub inner: ::std::rc::Rc<std::cell::RefCell<dyn LegacyDynamoDbEncryptor>>,
}

impl ::std::cmp::PartialEq for LegacyDynamoDbEncryptorRef {
    fn eq(&self, other: &LegacyDynamoDbEncryptorRef) -> bool {
        ::std::rc::Rc::ptr_eq(&self.inner, &other.inner)
    }
}

impl ::std::fmt::Debug for LegacyDynamoDbEncryptorRef {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        write!(f, "<LegacyDynamoDbEncryptorRef>")
    }
}
