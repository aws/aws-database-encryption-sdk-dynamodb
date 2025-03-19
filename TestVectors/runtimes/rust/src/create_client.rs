// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

use dafny_runtime::Rc;
use dafny_runtime::Object;
use crate::implementation_from_dafny::software::amazon::cryptography::services::dynamodb::internaldafny::types::IDynamoDBClient;
use crate::implementation_from_dafny::software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::Error;
use crate::implementation_from_dafny::_Wrappers_Compile;
use std::sync::LazyLock;
use crate::intercept::DbEsdkInterceptor;

static DAFNY_TOKIO_RUNTIME: LazyLock<tokio::runtime::Runtime> = LazyLock::new(|| {
  tokio::runtime::Builder::new_multi_thread()
      .enable_all()
      .build()
      .unwrap()
});

pub mod _CreateInterceptedDDBClient_Compile {
pub struct _default {}
}
impl _CreateInterceptedDDBClient_Compile::_default {

  pub fn CreateInterceptedDDBClient(config : &Rc<crate::implementation_from_dafny::software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::DynamoDbTablesEncryptionConfig>)
  -> Rc<_Wrappers_Compile::Result<Object<dyn IDynamoDBClient>, Rc<Error>>> 
  {

    let table_configs = crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_transforms::conversions::dynamo_db_tables_encryption_config::_dynamo_db_tables_encryption_config::plain_from_dafny(config);
    let shared_config = DAFNY_TOKIO_RUNTIME.block_on(aws_config::load_defaults(
      aws_config::BehaviorVersion::latest()));

      let shared_config = shared_config
        .to_builder()
        .endpoint_url("http://localhost:8000")
        .build();

        let dynamo_config = aws_sdk_dynamodb::config::Builder::from(&shared_config)
       .interceptor(DbEsdkInterceptor::new(table_configs).unwrap())
        .build();
      let inner = aws_sdk_dynamodb::Client::from_conf(dynamo_config);

      let client = crate::deps::com_amazonaws_dynamodb::client::Client { inner };
      let dafny_client = ::dafny_runtime::upcast_object()(::dafny_runtime::object::new(client));
      Rc::new(crate::r#_Wrappers_Compile::Result::Success {
        value: dafny_client,
      })
}
  pub fn CreateVanillaDDBClient()
  -> Rc<_Wrappers_Compile::Result<Object<dyn IDynamoDBClient>, Rc<Error>>>
  {
    let shared_config = DAFNY_TOKIO_RUNTIME.block_on(aws_config::load_defaults(
            aws_config::BehaviorVersion::latest()));

    let shared_config = shared_config
        .to_builder()
        .endpoint_url("http://localhost:8000")
        .build();
      let inner = aws_sdk_dynamodb::Client::new(&shared_config);
      let client = crate::deps::com_amazonaws_dynamodb::client::Client { inner };
      let dafny_client = ::dafny_runtime::upcast_object()(::dafny_runtime::object::new(client));
      Rc::new(crate::r#_Wrappers_Compile::Result::Success {
        value: dafny_client,
    })
  }

}
