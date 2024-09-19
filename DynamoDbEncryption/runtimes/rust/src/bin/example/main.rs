
pub mod basic_get_put_example;
pub mod test_utils;

#[tokio::main]
pub async fn main() {
    basic_get_put_example::put_item_get_item().await;
}
