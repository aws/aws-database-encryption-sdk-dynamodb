// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

use dafny_runtime::Rc;
use dafny_runtime::Object;
use crate::implementation_from_dafny::software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::IDynamoDbItemEncryptorClient;
use crate::implementation_from_dafny::software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::Error;
use crate::implementation_from_dafny::_Wrappers_Compile;
use crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::client as item_encryptor_client;
use crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::wrapped::client as wrapped_item_encryptor_client;
use crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::conversions::error;

pub mod _CreateWrappedItemEncryptor_Compile {
    pub struct _default {}
}

impl _CreateWrappedItemEncryptor_Compile::_default {
    pub fn CreateWrappedItemEncryptor(
        config: &Rc<crate::implementation_from_dafny::software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::DynamoDbItemEncryptorConfig>
    ) -> Rc<_Wrappers_Compile::Result<Object<dyn IDynamoDbItemEncryptorClient>, Rc<Error>>> {
        // from_conf converts Dafny config to native, constructs a native client, and wraps it in a Dafny client
        return wrapped_item_encryptor_client::Client::from_conf(config);
    }
}
