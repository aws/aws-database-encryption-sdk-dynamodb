use aws_config::Region;

fn dafny_tokio_runtime() -> tokio::runtime::Runtime
{
  tokio::runtime::Builder::new_multi_thread()
      .enable_all()
      .build()
      .unwrap()
}

#[allow(non_snake_case)]
impl crate::r#software::amazon::cryptography::services::dynamodb::internaldafny::_default {
  pub fn DDBClientForRegion(region: &::dafny_runtime::Sequence<::dafny_runtime::DafnyCharUTF16>) -> ::std::rc::Rc<
    crate::r#_Wrappers_Compile::Result<
      ::dafny_runtime::Object<dyn crate::r#software::amazon::cryptography::services::dynamodb::internaldafny::types::IDynamoDBClient>,
      ::std::rc::Rc<crate::r#software::amazon::cryptography::services::dynamodb::internaldafny::types::Error>
      >
    > {
    let region = dafny_runtime::dafny_runtime_conversions::unicode_chars_false::dafny_string_to_string(region);
    let shared_config = dafny_tokio_runtime().block_on(aws_config::load_defaults(aws_config::BehaviorVersion::v2024_03_28()));
    let shared_config = shared_config.to_builder().region(Region::new(region)).build();
    let inner = aws_sdk_dynamodb::Client::new(&shared_config);
    let client = crate::deps::com_amazonaws_dynamodb::client::Client { inner };
    let dafny_client = ::dafny_runtime::upcast_object()(::dafny_runtime::object::new(client));
    std::rc::Rc::new(crate::r#_Wrappers_Compile::Result::Success { value: dafny_client })
  }

  pub fn DDBClient() -> ::std::rc::Rc<
  crate::r#_Wrappers_Compile::Result<
    ::dafny_runtime::Object<dyn crate::r#software::amazon::cryptography::services::dynamodb::internaldafny::types::IDynamoDBClient>,
    ::std::rc::Rc<crate::r#software::amazon::cryptography::services::dynamodb::internaldafny::types::Error>
    >
  > {
      let shared_config = dafny_tokio_runtime().block_on(aws_config::load_defaults(aws_config::BehaviorVersion::v2024_03_28()));
      let inner = aws_sdk_dynamodb::Client::new(&shared_config);
      let client = crate::deps::com_amazonaws_dynamodb::client::Client { inner };
      let dafny_client = ::dafny_runtime::upcast_object()(::dafny_runtime::object::new(client));
      std::rc::Rc::new(crate::r#_Wrappers_Compile::Result::Success { value: dafny_client })
    }

}
