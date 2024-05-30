use aws_sdk_dynamodb::{config::{interceptors::{BeforeSerializationInterceptorContextMut, FinalizerInterceptorContextMut}, ConfigBag, Intercept, RuntimeComponents}, error::BoxError, Client, Config};
use aws_sdk_dynamodb::operation::put_item::{PutItemInput, PutItemOutput};
use aws_smithy_runtime_api::client::interceptors::context::Input;
use aws_smithy_types::config_bag::{Storable, StoreReplace};


#[tokio::main]
async fn main() {
    let config = Config::builder()
        .interceptor(EncryptDecryptInterceptor::new())
        .build();
    
    let client = Client::from_conf(config);
    let _resp = client.put_item().send().await;
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
        
        if let Some(put_item_request) = context.input_mut().downcast_mut::<PutItemInput>() {
            let new = put_item_request.clone();
            cfg.interceptor_state().store_put(OriginalRequest(Input::erase(new.clone())));

            // Do the thing here

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
        if let Some(output_or_error) = context.output_or_error_mut() {
            if let Ok(output) = output_or_error {
                if let Some(put_item_output) = output.downcast_mut::<PutItemOutput>() {
                    let original = cfg.load::<OriginalRequest>().expect("we put this in ourselves");
                    let _original = original.0.downcast_ref::<PutItemInput>().expect("we know this type corresponds to the output type");

                    // Check the original type

                    let new = put_item_output.clone();

                    // Do the thing here

                    *put_item_output = new;
                }
            }
        }

        Ok(())
    }
}