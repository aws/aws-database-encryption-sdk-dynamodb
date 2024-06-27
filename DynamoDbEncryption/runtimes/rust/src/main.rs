use aws_sdk_dynamodb::operation::get_item::{GetItemInput, GetItemOutput};
use aws_sdk_dynamodb::operation::put_item::{PutItemInput, PutItemOutput};
use aws_sdk_dynamodb::types::AttributeValue;
use aws_sdk_dynamodb::{
    config::{
        interceptors::{BeforeSerializationInterceptorContextMut, FinalizerInterceptorContextMut},
        ConfigBag, Intercept, RuntimeComponents,
    },
    error::BoxError,
};
use aws_smithy_runtime_api::client::interceptors::context::Input;
use aws_smithy_types::config_bag::{Storable, StoreReplace};

#[tokio::main]
async fn main() {
    let sdk_config = aws_config::load_defaults(aws_config::BehaviorVersion::latest()).await;
    // let custom_credentials_provider = aws_config::custom_provider(&sdk_config);
    let dynamo_config = aws_sdk_dynamodb::config::Builder::from(&sdk_config)
        .interceptor(EncryptDecryptInterceptor::new())
        .build();
    let client = aws_sdk_dynamodb::Client::from_conf(dynamo_config);

    let resp = client
        .put_item()
        .table_name("DynamoDbEncryptionInterceptorTestTableCS")
        .item(
            "partition_key",
            AttributeValue::S("MyRustExmaple".to_string()),
        )
        .item("sort_key", AttributeValue::N("1".to_string()))
        .item("attribute1", AttributeValue::S("Some Text".to_string()))
        .send()
        .await;
    println!("Put Item Response : {:?}", resp);

    let resp = client
        .get_item()
        .table_name("DynamoDbEncryptionInterceptorTestTableCS")
        .key(
            "partition_key",
            AttributeValue::S("MyRustExmaple".to_string()),
        )
        .key("sort_key", AttributeValue::N("1".to_string()))
        .send()
        .await;
    println!("Get Item Response : {:?}", resp);
}

fn transform_put_item_request(input: &PutItemInput) -> Result<PutItemInput, BoxError> {
    let mut result = input.clone();
    if let Some(req) = result.item.as_mut() {
        let _ = req.insert(
            "attribute2".to_string(),
            AttributeValue::S("New Secret Value From Put".to_string()),
        );
    }
    Ok(result)
}

fn transform_put_item_response(
    _input: &PutItemInput,
    output: &PutItemOutput,
) -> Result<PutItemOutput, BoxError> {
    Ok(output.clone())
}

fn transform_get_item_request(input: &GetItemInput) -> Result<GetItemInput, BoxError> {
    Ok(input.clone())
}

fn transform_get_item_response(
    _input: &GetItemInput,
    output: &GetItemOutput,
) -> Result<GetItemOutput, BoxError> {
    let mut result = output.clone();
    if let Some(req) = result.item.as_mut() {
        let _ = req.insert(
            "attribute3".to_string(),
            AttributeValue::S("New Secret Value From Get".to_string()),
        );
    }
    Ok(result)
}

#[derive(Debug)]
struct EncryptDecryptInterceptor {}

impl EncryptDecryptInterceptor {
    pub fn new() -> Self {
        EncryptDecryptInterceptor {}
    }
}

#[derive(Debug)]
struct OriginalRequest(Input);

impl Storable for OriginalRequest {
    type Storer = StoreReplace<Self>;
}

impl Intercept for EncryptDecryptInterceptor {
    fn name(&self) -> &'static str {
        "EncryptDecryptInterceptor"
    }

    fn modify_before_serialization(
        &self,
        // https://docs.rs/aws-smithy-runtime-api/latest/aws_smithy_runtime_api/client/interceptors/context/struct.BeforeSerializationInterceptorContextMut.html
        context: &mut BeforeSerializationInterceptorContextMut,
        _rc: &RuntimeComponents,
        cfg: &mut ConfigBag,
    ) -> Result<(), BoxError> {
        eprintln!("Entering modify_before_serialization.");
        if let Some(get_item_request) = context.input_mut().downcast_mut::<GetItemInput>() {
            eprintln!("Found get item request.");
            cfg.interceptor_state()
                .store_put(OriginalRequest(Input::erase(get_item_request.clone())));
            let new = transform_get_item_request(get_item_request)?;
            *get_item_request = new;
        } else if let Some(put_item_request) = context.input_mut().downcast_mut::<PutItemInput>() {
            eprintln!("Found put item request.");
            cfg.interceptor_state()
                .store_put(OriginalRequest(Input::erase(put_item_request.clone())));
            let new = transform_put_item_request(put_item_request)?;
            *put_item_request = new;
        }

        Ok(())
    }

    fn modify_before_attempt_completion(
        &self,
        context: &mut FinalizerInterceptorContextMut,
        _rc: &RuntimeComponents,
        cfg: &mut ConfigBag,
    ) -> Result<(), BoxError> {
        eprintln!("Entering modify_before_attempt_completion.");
        if let Some(Ok(output)) = context.output_or_error_mut() {
            if let Some(get_item_output) = output.downcast_mut::<GetItemOutput>() {
                eprintln!("Found get item response.");
                let original = cfg
                    .load::<OriginalRequest>()
                    .expect("we put this in ourselves");
                let original = original
                    .0
                    .downcast_ref::<GetItemInput>()
                    .expect("we know this type corresponds to the output type");
                eprintln!("Original {:?}.", original);
                let new = transform_get_item_response(original, get_item_output)?;
                *get_item_output = new;
            } else if let Some(put_item_output) = output.downcast_mut::<PutItemOutput>() {
                eprintln!("Found put item response.");
                let original = cfg
                    .load::<OriginalRequest>()
                    .expect("we put this in ourselves");
                let original = original
                    .0
                    .downcast_ref::<PutItemInput>()
                    .expect("we know this type corresponds to the output type");
                eprintln!("Original {:?}.", original);
                let new = transform_put_item_response(original, put_item_output)?;
                *put_item_output = new;
            }
        }
        Ok(())
    }
}
