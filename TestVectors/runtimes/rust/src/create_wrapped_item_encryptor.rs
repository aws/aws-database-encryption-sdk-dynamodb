// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

use dafny_runtime::Rc;
use dafny_runtime::Object;
use crate::implementation_from_dafny::software::amazon::cryptography::services::dynamodb::internaldafny::types::IItemEncryptor;
use crate::implementation_from_dafny::software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::Error;
use crate::implementation_from_dafny::_Wrappers_Compile;

pub mod _CreateWrappedItemEncryptor_Compile {
    pub struct _default {}
}

impl _CreateWrappedItemEncryptor_Compile::_default {
    pub fn CreateWrappedItemEncryptor(
        config: &Rc<crate::implementation_from_dafny::software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::DynamoDbItemEncryptorConfig>
    ) -> Rc<_Wrappers_Compile::Result<Object<dyn IItemEncryptor>, Rc<Error>>> {
        let native_config = crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_transforms::conversions::dynamo_db_item_encryptor_config::_dynamo_db_item_encryptor_config::plain_from_dafny(config);
        
        let item_encryptor = aws_cryptography_dbencryptionsdk_dynamodb::item_encryptor::DynamoDbItemEncryptor::new(native_config);
        let wrapped_encryptor = crate::deps::com_amazonaws_dynamodb::item_encryptor::ItemEncryptor { inner: item_encryptor };
        let dafny_encryptor = ::dafny_runtime::upcast_object()(::dafny_runtime::object::new(wrapped_encryptor));
        
        Rc::new(crate::r#_Wrappers_Compile::Result::Success {
            value: dafny_encryptor,
        })
    }
}
