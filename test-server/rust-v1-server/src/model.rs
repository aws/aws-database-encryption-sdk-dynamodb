// The rpcv2Cbor wire model, hand-mapped from
// aws-crypto-tools-commons/dbesdk/test-server/model/dbesdk-test-server.smithy.
//
// rpcv2Cbor encodes each structure as a CBOR map keyed by member name, so every
// field here renames to its exact Smithy member name. The polymorphic shapes
// (Keyring, CryptographicMaterialsManager, AttributeValue) are modeled in the
// Smithy file as *structures* with all-optional members (exactly one set at
// runtime), not as Smithy unions — so they are plain structs here too, and
// serialize as a one-key map, which is byte-identical to the wire.
//
// serde treats a missing `Option<T>` field as `None`, and ignores unknown map
// keys, so absent optional members and forward-compatible additions both
// deserialize cleanly. `serde_bytes::ByteBuf` forces Blob members to CBOR byte
// strings (major type 2) rather than arrays of integers.

use serde::{Deserialize, Serialize};
use serde_bytes::ByteBuf;
use std::collections::HashMap;

pub type DdbItem = HashMap<String, AttributeValue>;

// ---------------------------------------------------------------------------
// Operation request / response shapes
// ---------------------------------------------------------------------------

#[derive(Debug, Deserialize)]
pub struct CreateClientRequest {
    pub config: DbeClientConfig,
}

#[derive(Debug, Serialize)]
pub struct CreateClientResponse {
    #[serde(rename = "clientId")]
    pub client_id: String,
}

#[derive(Debug, Deserialize)]
pub struct EncryptItemRequest {
    #[serde(rename = "clientId")]
    pub client_id: String,
    #[serde(rename = "plaintextItem")]
    pub plaintext_item: DdbItem,
}

#[derive(Debug, Serialize)]
pub struct EncryptItemResponse {
    #[serde(rename = "encryptedItem")]
    pub encrypted_item: DdbItem,
}

#[derive(Debug, Deserialize)]
pub struct DecryptItemRequest {
    #[serde(rename = "clientId")]
    pub client_id: String,
    #[serde(rename = "encryptedItem")]
    pub encrypted_item: DdbItem,
}

#[derive(Debug, Serialize)]
pub struct DecryptItemResponse {
    #[serde(rename = "plaintextItem")]
    pub plaintext_item: DdbItem,
}

// ---------------------------------------------------------------------------
// DDB SDK transforms — minimal wire shapes + operation request/response.
// PutItemInput / GetItemInput / GetItemOutput carry only the fields the
// encrypt-before / decrypt-after round-trip needs; handlers.rs maps them onto
// the real aws_sdk_dynamodb request/response types the transforms client uses.
// ---------------------------------------------------------------------------

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct PutItemInput {
    #[serde(rename = "tableName")]
    pub table_name: String,
    pub item: DdbItem,
}

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct GetItemInput {
    #[serde(rename = "tableName")]
    pub table_name: String,
    pub key: DdbItem,
}

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct GetItemOutput {
    #[serde(skip_serializing_if = "Option::is_none", default)]
    pub item: Option<DdbItem>,
}

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct UpdateItemInput {
    #[serde(rename = "tableName")]
    pub table_name: String,
    pub key: DdbItem,
    #[serde(rename = "updateExpression", skip_serializing_if = "Option::is_none", default)]
    pub update_expression: Option<String>,
    #[serde(rename = "conditionExpression", skip_serializing_if = "Option::is_none", default)]
    pub condition_expression: Option<String>,
    #[serde(rename = "expressionAttributeNames", skip_serializing_if = "Option::is_none", default)]
    pub expression_attribute_names: Option<HashMap<String, String>>,
    #[serde(rename = "expressionAttributeValues", skip_serializing_if = "Option::is_none", default)]
    pub expression_attribute_values: Option<DdbItem>,
}

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct DeleteItemInput {
    #[serde(rename = "tableName")]
    pub table_name: String,
    pub key: DdbItem,
    #[serde(rename = "conditionExpression", skip_serializing_if = "Option::is_none", default)]
    pub condition_expression: Option<String>,
    #[serde(rename = "expressionAttributeNames", skip_serializing_if = "Option::is_none", default)]
    pub expression_attribute_names: Option<HashMap<String, String>>,
    #[serde(rename = "expressionAttributeValues", skip_serializing_if = "Option::is_none", default)]
    pub expression_attribute_values: Option<DdbItem>,
}

#[derive(Debug, Deserialize)]
pub struct UpdateItemInputTransformRequest {
    #[serde(rename = "clientId")]
    pub client_id: String,
    #[serde(rename = "sdkInput")]
    pub sdk_input: UpdateItemInput,
}

#[derive(Debug, Serialize)]
pub struct UpdateItemInputTransformResponse {
    #[serde(rename = "transformedInput")]
    pub transformed_input: UpdateItemInput,
}

#[derive(Debug, Deserialize)]
pub struct DeleteItemInputTransformRequest {
    #[serde(rename = "clientId")]
    pub client_id: String,
    #[serde(rename = "sdkInput")]
    pub sdk_input: DeleteItemInput,
}

#[derive(Debug, Serialize)]
pub struct DeleteItemInputTransformResponse {
    #[serde(rename = "transformedInput")]
    pub transformed_input: DeleteItemInput,
}

#[derive(Debug, Deserialize)]
pub struct CreateTransformsClientRequest {
    pub config: DbeClientConfig,
    #[serde(rename = "tableName")]
    pub table_name: String,
    #[serde(rename = "additionalTables", default)]
    pub additional_tables: Option<Vec<TransformsTableConfig>>,
}

#[derive(Debug, Deserialize)]
pub struct TransformsTableConfig {
    #[serde(rename = "tableName")]
    pub table_name: String,
    pub config: DbeClientConfig,
}

#[derive(Debug, Serialize)]
pub struct CreateTransformsClientResponse {
    #[serde(rename = "clientId")]
    pub client_id: String,
}

#[derive(Debug, Deserialize)]
pub struct PutItemInputTransformRequest {
    #[serde(rename = "clientId")]
    pub client_id: String,
    #[serde(rename = "sdkInput")]
    pub sdk_input: PutItemInput,
}

#[derive(Debug, Serialize)]
pub struct PutItemInputTransformResponse {
    #[serde(rename = "transformedInput")]
    pub transformed_input: PutItemInput,
}

#[derive(Debug, Deserialize)]
pub struct GetItemOutputTransformRequest {
    #[serde(rename = "clientId")]
    pub client_id: String,
    #[serde(rename = "sdkOutput")]
    pub sdk_output: GetItemOutput,
    #[serde(rename = "originalInput")]
    pub original_input: GetItemInput,
}

#[derive(Debug, Serialize)]
pub struct GetItemOutputTransformResponse {
    #[serde(rename = "transformedOutput")]
    pub transformed_output: GetItemOutput,
}

// ---- BatchWriteItem / TransactWriteItems encrypt-before wire shapes ----

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct BatchWriteItemInput {
    #[serde(rename = "requestItems")]
    pub request_items: HashMap<String, Vec<WriteRequest>>,
}

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct WriteRequest {
    #[serde(rename = "putRequest", skip_serializing_if = "Option::is_none", default)]
    pub put_request: Option<PutRequest>,
    #[serde(rename = "deleteRequest", skip_serializing_if = "Option::is_none", default)]
    pub delete_request: Option<DeleteRequest>,
}

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct PutRequest {
    pub item: DdbItem,
}

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct DeleteRequest {
    pub key: DdbItem,
}

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct TransactWriteItemsInput {
    #[serde(rename = "transactItems")]
    pub transact_items: Vec<TransactWriteItem>,
}

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct TransactWriteItem {
    #[serde(skip_serializing_if = "Option::is_none", default)]
    pub put: Option<Put>,
    #[serde(skip_serializing_if = "Option::is_none", default)]
    pub delete: Option<Delete>,
    #[serde(skip_serializing_if = "Option::is_none", default)]
    pub update: Option<Update>,
    #[serde(rename = "conditionCheck", skip_serializing_if = "Option::is_none", default)]
    pub condition_check: Option<ConditionCheck>,
}

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct Delete {
    #[serde(rename = "tableName")]
    pub table_name: String,
    pub key: DdbItem,
    #[serde(rename = "conditionExpression", skip_serializing_if = "Option::is_none", default)]
    pub condition_expression: Option<String>,
    #[serde(rename = "expressionAttributeNames", skip_serializing_if = "Option::is_none", default)]
    pub expression_attribute_names: Option<HashMap<String, String>>,
    #[serde(rename = "expressionAttributeValues", skip_serializing_if = "Option::is_none", default)]
    pub expression_attribute_values: Option<DdbItem>,
}

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct Update {
    #[serde(rename = "tableName")]
    pub table_name: String,
    pub key: DdbItem,
    #[serde(rename = "updateExpression")]
    pub update_expression: String,
    #[serde(rename = "conditionExpression", skip_serializing_if = "Option::is_none", default)]
    pub condition_expression: Option<String>,
    #[serde(rename = "expressionAttributeNames", skip_serializing_if = "Option::is_none", default)]
    pub expression_attribute_names: Option<HashMap<String, String>>,
    #[serde(rename = "expressionAttributeValues", skip_serializing_if = "Option::is_none", default)]
    pub expression_attribute_values: Option<DdbItem>,
}

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct ConditionCheck {
    #[serde(rename = "tableName")]
    pub table_name: String,
    pub key: DdbItem,
    #[serde(rename = "conditionExpression")]
    pub condition_expression: String,
    #[serde(rename = "expressionAttributeNames", skip_serializing_if = "Option::is_none", default)]
    pub expression_attribute_names: Option<HashMap<String, String>>,
    #[serde(rename = "expressionAttributeValues", skip_serializing_if = "Option::is_none", default)]
    pub expression_attribute_values: Option<DdbItem>,
}

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct Put {
    #[serde(rename = "tableName")]
    pub table_name: String,
    pub item: DdbItem,
}

#[derive(Debug, Deserialize)]
pub struct BatchWriteItemInputTransformRequest {
    #[serde(rename = "clientId")]
    pub client_id: String,
    #[serde(rename = "sdkInput")]
    pub sdk_input: BatchWriteItemInput,
}

#[derive(Debug, Serialize)]
pub struct BatchWriteItemInputTransformResponse {
    #[serde(rename = "transformedInput")]
    pub transformed_input: BatchWriteItemInput,
}

#[derive(Debug, Deserialize)]
pub struct TransactWriteItemsInputTransformRequest {
    #[serde(rename = "clientId")]
    pub client_id: String,
    #[serde(rename = "sdkInput")]
    pub sdk_input: TransactWriteItemsInput,
}

#[derive(Debug, Serialize)]
pub struct TransactWriteItemsInputTransformResponse {
    #[serde(rename = "transformedInput")]
    pub transformed_input: TransactWriteItemsInput,
}

// ---- Scan / Query / BatchGetItem decrypt-after wire shapes ----

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct ScanInput {
    #[serde(rename = "tableName")]
    pub table_name: String,
    #[serde(rename = "filterExpression", skip_serializing_if = "Option::is_none", default)]
    pub filter_expression: Option<String>,
    #[serde(rename = "expressionAttributeNames", skip_serializing_if = "Option::is_none", default)]
    pub expression_attribute_names: Option<HashMap<String, String>>,
    #[serde(rename = "expressionAttributeValues", skip_serializing_if = "Option::is_none", default)]
    pub expression_attribute_values: Option<DdbItem>,
}

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct ScanOutput {
    #[serde(skip_serializing_if = "Option::is_none", default)]
    pub items: Option<Vec<DdbItem>>,
}

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct QueryInput {
    #[serde(rename = "tableName")]
    pub table_name: String,
    #[serde(rename = "keyConditionExpression", skip_serializing_if = "Option::is_none", default)]
    pub key_condition_expression: Option<String>,
    #[serde(rename = "filterExpression", skip_serializing_if = "Option::is_none", default)]
    pub filter_expression: Option<String>,
    #[serde(rename = "expressionAttributeNames", skip_serializing_if = "Option::is_none", default)]
    pub expression_attribute_names: Option<HashMap<String, String>>,
    #[serde(rename = "expressionAttributeValues", skip_serializing_if = "Option::is_none", default)]
    pub expression_attribute_values: Option<DdbItem>,
}

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct QueryOutput {
    #[serde(skip_serializing_if = "Option::is_none", default)]
    pub items: Option<Vec<DdbItem>>,
}

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct BatchGetItemInput {
    #[serde(rename = "requestItems")]
    pub request_items: HashMap<String, KeysAndAttributes>,
}

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct KeysAndAttributes {
    pub keys: Vec<DdbItem>,
}

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct BatchGetItemOutput {
    #[serde(skip_serializing_if = "Option::is_none", default)]
    pub responses: Option<HashMap<String, Vec<DdbItem>>>,
}

#[derive(Debug, Deserialize)]
pub struct ScanOutputTransformRequest {
    #[serde(rename = "clientId")]
    pub client_id: String,
    #[serde(rename = "sdkOutput")]
    pub sdk_output: ScanOutput,
    #[serde(rename = "originalInput")]
    pub original_input: ScanInput,
}

#[derive(Debug, Serialize)]
pub struct ScanOutputTransformResponse {
    #[serde(rename = "transformedOutput")]
    pub transformed_output: ScanOutput,
}

#[derive(Debug, Deserialize)]
pub struct QueryOutputTransformRequest {
    #[serde(rename = "clientId")]
    pub client_id: String,
    #[serde(rename = "sdkOutput")]
    pub sdk_output: QueryOutput,
    #[serde(rename = "originalInput")]
    pub original_input: QueryInput,
}

#[derive(Debug, Serialize)]
pub struct QueryOutputTransformResponse {
    #[serde(rename = "transformedOutput")]
    pub transformed_output: QueryOutput,
}

#[derive(Debug, Deserialize)]
pub struct BatchGetItemOutputTransformRequest {
    #[serde(rename = "clientId")]
    pub client_id: String,
    #[serde(rename = "sdkOutput")]
    pub sdk_output: BatchGetItemOutput,
    #[serde(rename = "originalInput")]
    pub original_input: BatchGetItemInput,
}

#[derive(Debug, Serialize)]
pub struct BatchGetItemOutputTransformResponse {
    #[serde(rename = "transformedOutput")]
    pub transformed_output: BatchGetItemOutput,
}

// ---- PartiQL validate-before wire shapes ----

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct ExecuteStatementInput {
    pub statement: String,
}

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct BatchExecuteStatementInput {
    pub statements: Vec<BatchStatementRequest>,
}

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct BatchStatementRequest {
    pub statement: String,
}

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct ExecuteTransactionInput {
    #[serde(rename = "transactStatements")]
    pub transact_statements: Vec<ParameterizedStatement>,
}

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct ParameterizedStatement {
    pub statement: String,
}

#[derive(Debug, Deserialize)]
pub struct ExecuteStatementInputTransformRequest {
    #[serde(rename = "clientId")]
    pub client_id: String,
    #[serde(rename = "sdkInput")]
    pub sdk_input: ExecuteStatementInput,
}

#[derive(Debug, Serialize)]
pub struct ExecuteStatementInputTransformResponse {
    #[serde(rename = "transformedInput")]
    pub transformed_input: ExecuteStatementInput,
}

#[derive(Debug, Deserialize)]
pub struct BatchExecuteStatementInputTransformRequest {
    #[serde(rename = "clientId")]
    pub client_id: String,
    #[serde(rename = "sdkInput")]
    pub sdk_input: BatchExecuteStatementInput,
}

#[derive(Debug, Serialize)]
pub struct BatchExecuteStatementInputTransformResponse {
    #[serde(rename = "transformedInput")]
    pub transformed_input: BatchExecuteStatementInput,
}

#[derive(Debug, Deserialize)]
pub struct ExecuteTransactionInputTransformRequest {
    #[serde(rename = "clientId")]
    pub client_id: String,
    #[serde(rename = "sdkInput")]
    pub sdk_input: ExecuteTransactionInput,
}

#[derive(Debug, Serialize)]
pub struct ExecuteTransactionInputTransformResponse {
    #[serde(rename = "transformedInput")]
    pub transformed_input: ExecuteTransactionInput,
}

// ---- BatchWriteItem decrypt-after (UnprocessedItems restoration) ----

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct BatchWriteItemOutput {
    #[serde(rename = "unprocessedItems", skip_serializing_if = "Option::is_none", default)]
    pub unprocessed_items: Option<HashMap<String, Vec<WriteRequest>>>,
}

#[derive(Debug, Deserialize)]
pub struct BatchWriteItemOutputTransformRequest {
    #[serde(rename = "clientId")]
    pub client_id: String,
    #[serde(rename = "sdkOutput")]
    pub sdk_output: BatchWriteItemOutput,
    #[serde(rename = "originalInput")]
    pub original_input: BatchWriteItemInput,
}

#[derive(Debug, Serialize)]
pub struct BatchWriteItemOutputTransformResponse {
    #[serde(rename = "transformedOutput")]
    pub transformed_output: BatchWriteItemOutput,
}

#[derive(Debug, Deserialize)]
pub struct ScanInputTransformRequest {
    #[serde(rename = "clientId")]
    pub client_id: String,
    #[serde(rename = "sdkInput")]
    pub sdk_input: ScanInput,
}

#[derive(Debug, Serialize)]
pub struct ScanInputTransformResponse {
    #[serde(rename = "transformedInput")]
    pub transformed_input: ScanInput,
}

#[derive(Debug, Deserialize)]
pub struct QueryInputTransformRequest {
    #[serde(rename = "clientId")]
    pub client_id: String,
    #[serde(rename = "sdkInput")]
    pub sdk_input: QueryInput,
}

#[derive(Debug, Serialize)]
pub struct QueryInputTransformResponse {
    #[serde(rename = "transformedInput")]
    pub transformed_input: QueryInput,
}

// ---------------------------------------------------------------------------
// AttributeValue — DDB data-plane shape. Scalars (S / N / B / BOOL / NULL),
// typed sets (SS / NS / BS), and the recursive collections (L / M). L and M
// reference AttributeValue; Vec and HashMap already provide the heap
// indirection recursion needs, so no explicit Box is required.
// ---------------------------------------------------------------------------

#[derive(Debug, Clone, Default, Serialize, Deserialize)]
pub struct AttributeValue {
    #[serde(rename = "S", skip_serializing_if = "Option::is_none", default)]
    pub s: Option<String>,
    #[serde(rename = "N", skip_serializing_if = "Option::is_none", default)]
    pub n: Option<String>,
    #[serde(rename = "B", skip_serializing_if = "Option::is_none", default)]
    pub b: Option<ByteBuf>,
    #[serde(rename = "BOOL", skip_serializing_if = "Option::is_none", default)]
    pub bool_value: Option<bool>,
    #[serde(rename = "NULL", skip_serializing_if = "Option::is_none", default)]
    pub null: Option<bool>,
    #[serde(rename = "SS", skip_serializing_if = "Option::is_none", default)]
    pub ss: Option<Vec<String>>,
    #[serde(rename = "NS", skip_serializing_if = "Option::is_none", default)]
    pub ns: Option<Vec<String>>,
    #[serde(rename = "BS", skip_serializing_if = "Option::is_none", default)]
    pub bs: Option<Vec<ByteBuf>>,
    #[serde(rename = "L", skip_serializing_if = "Option::is_none", default)]
    pub l: Option<Vec<AttributeValue>>,
    #[serde(rename = "M", skip_serializing_if = "Option::is_none", default)]
    pub m: Option<HashMap<String, AttributeValue>>,
}

// ---------------------------------------------------------------------------
// DBE client configuration
// ---------------------------------------------------------------------------

#[derive(Debug, Deserialize)]
pub struct DbeClientConfig {
    #[serde(rename = "logicalTableName")]
    pub logical_table_name: String,
    #[serde(rename = "partitionKeyName")]
    pub partition_key_name: String,
    #[serde(rename = "sortKeyName", default)]
    pub sort_key_name: Option<String>,
    #[serde(rename = "attributeActionsOnEncrypt")]
    pub attribute_actions_on_encrypt: HashMap<String, CryptoAction>,
    #[serde(rename = "allowedUnsignedAttributePrefix", default)]
    pub allowed_unsigned_attribute_prefix: Option<String>,
    #[serde(rename = "allowedUnsignedAttributes", default)]
    pub allowed_unsigned_attributes: Option<Vec<String>>,
    #[serde(rename = "algorithmSuiteId", default)]
    pub algorithm_suite_id: Option<DbeAlgorithmSuiteId>,
    #[serde(rename = "plaintextOverride", default)]
    pub plaintext_override: Option<PlaintextOverride>,
    #[serde(default)]
    pub keyring: Option<Keyring>,
    #[serde(default)]
    pub cmm: Option<CryptographicMaterialsManager>,
    #[serde(default)]
    pub search: Option<SearchConfig>,
}

// ---------------------------------------------------------------------------
// Searchable encryption (beacons) — minimal: one beacon version, standard
// beacons, single key store. Only honored by a transforms client.
// ---------------------------------------------------------------------------

#[derive(Debug, Clone, Deserialize)]
pub struct SearchConfig {
    pub versions: Vec<BeaconVersion>,
    #[serde(rename = "writeVersion", default)]
    pub write_version: Option<i32>,
}

#[derive(Debug, Clone, Deserialize)]
pub struct BeaconVersion {
    pub version: i32,
    #[serde(rename = "keyStore")]
    pub key_store: BeaconKeyStore,
    #[serde(rename = "keySource")]
    pub key_source: BeaconKeySource,
    #[serde(rename = "standardBeacons", default)]
    pub standard_beacons: Option<Vec<StandardBeacon>>,
    #[serde(rename = "compoundBeacons", default)]
    pub compound_beacons: Option<Vec<CompoundBeacon>>,
    #[serde(rename = "virtualFields", default)]
    pub virtual_fields: Option<Vec<VirtualField>>,
    #[serde(rename = "encryptedParts", default)]
    pub encrypted_parts: Option<Vec<EncryptedPart>>,
    #[serde(rename = "signedParts", default)]
    pub signed_parts: Option<Vec<SignedPart>>,
    #[serde(rename = "maximumNumberOfPartitions", default)]
    pub maximum_number_of_partitions: Option<i32>,
    #[serde(rename = "defaultNumberOfPartitions", default)]
    pub default_number_of_partitions: Option<i32>,
}

#[derive(Debug, Clone, Deserialize)]
pub struct BeaconKeyStore {
    #[serde(rename = "ddbTableName")]
    pub ddb_table_name: String,
    #[serde(rename = "logicalKeyStoreName")]
    pub logical_key_store_name: String,
    #[serde(rename = "kmsKeyArn")]
    pub kms_key_arn: String,
}

#[derive(Debug, Clone, Deserialize)]
pub struct BeaconKeySource {
    #[serde(default)]
    pub single: Option<SingleKeyStore>,
}

#[derive(Debug, Clone, Deserialize)]
pub struct SingleKeyStore {
    #[serde(rename = "keyId")]
    pub key_id: String,
    #[serde(rename = "cacheTtlSeconds")]
    pub cache_ttl_seconds: i32,
}

#[derive(Debug, Clone, Deserialize)]
pub struct StandardBeacon {
    pub name: String,
    pub length: i32,
    #[serde(rename = "loc", default)]
    pub loc: Option<String>,
    #[serde(rename = "numberOfPartitions", default)]
    pub number_of_partitions: Option<i32>,
    #[serde(rename = "style", default)]
    pub style: Option<BeaconStyle>,
}

/// A standard beacon's style (exactly one member set — union on the wire).
#[derive(Debug, Clone, Deserialize)]
pub struct BeaconStyle {
    #[serde(rename = "partOnly", default)]
    pub part_only: Option<PartOnly>,
    #[serde(rename = "shared", default)]
    pub shared: Option<Shared>,
    #[serde(rename = "asSet", default)]
    pub as_set: Option<AsSet>,
    #[serde(rename = "sharedSet", default)]
    pub shared_set: Option<SharedSet>,
}

#[derive(Debug, Clone, Deserialize)]
pub struct PartOnly {}

#[derive(Debug, Clone, Deserialize)]
pub struct AsSet {}

#[derive(Debug, Clone, Deserialize)]
pub struct Shared {
    pub other: String,
}

#[derive(Debug, Clone, Deserialize)]
pub struct SharedSet {
    pub other: String,
}

#[derive(Debug, Clone, Deserialize)]
pub struct CompoundBeacon {
    pub name: String,
    pub split: String,
    #[serde(rename = "constructors", default)]
    pub constructors: Option<Vec<Constructor>>,
    #[serde(rename = "encrypted", default)]
    pub encrypted: Option<Vec<EncryptedPart>>,
    #[serde(rename = "signed", default)]
    pub signed: Option<Vec<SignedPart>>,
}

#[derive(Debug, Clone, Deserialize)]
pub struct Constructor {
    pub parts: Vec<ConstructorPart>,
}

#[derive(Debug, Clone, Deserialize)]
pub struct ConstructorPart {
    pub name: String,
    pub required: bool,
}

#[derive(Debug, Clone, Deserialize)]
pub struct EncryptedPart {
    pub name: String,
    pub prefix: String,
}

#[derive(Debug, Clone, Deserialize)]
pub struct SignedPart {
    pub name: String,
    pub prefix: String,
    #[serde(rename = "loc", default)]
    pub loc: Option<String>,
}

#[derive(Debug, Clone, Deserialize)]
pub struct VirtualField {
    pub name: String,
    pub parts: Vec<VirtualPart>,
}

#[derive(Debug, Clone, Deserialize)]
pub struct VirtualPart {
    pub loc: String,
    #[serde(rename = "trans", default)]
    pub trans: Option<Vec<VirtualTransform>>,
}

/// A virtual-part transform (exactly one member set — union on the wire).
#[derive(Debug, Clone, Deserialize)]
pub struct VirtualTransform {
    #[serde(rename = "upper", default)]
    pub upper: Option<Upper>,
    #[serde(rename = "lower", default)]
    pub lower: Option<Lower>,
    #[serde(rename = "insert", default)]
    pub insert: Option<Insert>,
    #[serde(rename = "prefix", default)]
    pub prefix: Option<GetPrefix>,
    #[serde(rename = "suffix", default)]
    pub suffix: Option<GetSuffix>,
    #[serde(rename = "substring", default)]
    pub substring: Option<GetSubstring>,
    #[serde(rename = "segment", default)]
    pub segment: Option<GetSegment>,
    #[serde(rename = "segments", default)]
    pub segments: Option<GetSegments>,
}

#[derive(Debug, Clone, Deserialize)]
pub struct Upper {}

#[derive(Debug, Clone, Deserialize)]
pub struct Lower {}

#[derive(Debug, Clone, Deserialize)]
pub struct Insert {
    pub literal: String,
}

#[derive(Debug, Clone, Deserialize)]
pub struct GetPrefix {
    pub length: i32,
}

#[derive(Debug, Clone, Deserialize)]
pub struct GetSuffix {
    pub length: i32,
}

#[derive(Debug, Clone, Deserialize)]
pub struct GetSubstring {
    pub low: i32,
    pub high: i32,
}

#[derive(Debug, Clone, Deserialize)]
pub struct GetSegment {
    pub split: String,
    pub index: i32,
}

#[derive(Debug, Clone, Deserialize)]
pub struct GetSegments {
    pub split: String,
    pub low: i32,
    pub high: i32,
}

#[derive(Debug, Clone, Copy, Deserialize)]
pub enum CryptoAction {
    #[serde(rename = "ENCRYPT_AND_SIGN")]
    EncryptAndSign,
    #[serde(rename = "SIGN_ONLY")]
    SignOnly,
    #[serde(rename = "SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT")]
    SignAndIncludeInEncryptionContext,
    #[serde(rename = "DO_NOTHING")]
    DoNothing,
}

#[derive(Debug, Clone, Copy, Deserialize)]
pub enum DbeAlgorithmSuiteId {
    #[serde(rename = "ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384")]
    Symsig,
    #[serde(rename = "ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384")]
    EcdsaSymsig,
}

#[derive(Debug, Clone, Copy, Deserialize)]
pub enum PlaintextOverride {
    #[serde(rename = "FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ")]
    ForceWriteAllowRead,
    #[serde(rename = "FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ")]
    ForbidWriteAllowRead,
    #[serde(rename = "FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ")]
    ForbidWriteForbidRead,
}

// ---------------------------------------------------------------------------
// Cryptographic Materials Managers (recursive; one member set)
// ---------------------------------------------------------------------------

#[derive(Debug, Deserialize)]
pub struct CryptographicMaterialsManager {
    #[serde(rename = "Default", default)]
    pub default: Option<DefaultCmmConfig>,
    #[serde(rename = "RequiredEncryptionContext", default)]
    pub required_encryption_context: Option<RequiredEncryptionContextCmmConfig>,
    #[serde(rename = "Caching", default)]
    pub caching: Option<CachingCmmConfig>,
}

#[derive(Debug, Deserialize)]
pub struct DefaultCmmConfig {
    pub keyring: Keyring,
}

#[derive(Debug, Deserialize)]
pub struct RequiredEncryptionContextCmmConfig {
    #[serde(rename = "underlyingCMM")]
    pub underlying_cmm: Box<CryptographicMaterialsManager>,
    #[serde(rename = "requiredEncryptionContextKeys")]
    pub required_encryption_context_keys: Vec<String>,
}

#[derive(Debug, Deserialize)]
// Wire-complete but deferred in factory.rs (returns GenericServerError); the
// Java factory also leaves the Caching CMM unwired.
#[allow(dead_code)]
pub struct CachingCmmConfig {
    #[serde(rename = "underlyingCMM")]
    pub underlying_cmm: Box<CryptographicMaterialsManager>,
    #[serde(rename = "cacheLimitTtlSeconds")]
    pub cache_limit_ttl_seconds: i32,
    #[serde(rename = "partitionId", default)]
    pub partition_id: Option<String>,
    #[serde(rename = "limitBytes", default)]
    pub limit_bytes: Option<i64>,
    #[serde(rename = "limitMessages", default)]
    pub limit_messages: Option<i64>,
}

// ---------------------------------------------------------------------------
// Keyrings (recursive via Multi; one member set)
// ---------------------------------------------------------------------------

#[derive(Debug, Deserialize)]
pub struct Keyring {
    #[serde(rename = "AwsKms", default)]
    pub aws_kms: Option<AwsKmsKeyringConfig>,
    #[serde(rename = "AwsKmsMrk", default)]
    pub aws_kms_mrk: Option<AwsKmsMrkKeyringConfig>,
    #[serde(rename = "AwsKmsMultiKeyring", default)]
    pub aws_kms_multi: Option<AwsKmsMultiKeyringConfig>,
    #[serde(rename = "AwsKmsMrkMultiKeyring", default)]
    pub aws_kms_mrk_multi: Option<AwsKmsMrkMultiKeyringConfig>,
    #[serde(rename = "AwsKmsDiscovery", default)]
    pub aws_kms_discovery: Option<AwsKmsDiscoveryKeyringConfig>,
    #[serde(rename = "AwsKmsMrkDiscovery", default)]
    pub aws_kms_mrk_discovery: Option<AwsKmsMrkDiscoveryKeyringConfig>,
    #[serde(rename = "AwsKmsRsa", default)]
    pub aws_kms_rsa: Option<AwsKmsRsaKeyringConfig>,
    #[serde(rename = "RawAes", default)]
    pub raw_aes: Option<RawAesKeyringConfig>,
    #[serde(rename = "RawRsa", default)]
    pub raw_rsa: Option<RawRsaKeyringConfig>,
    #[serde(rename = "AwsKmsHierarchical", default)]
    pub aws_kms_hierarchical: Option<AwsKmsHierarchicalKeyringConfig>,
    #[serde(rename = "Multi", default)]
    pub multi: Option<MultiKeyringConfig>,
}

#[derive(Debug, Deserialize)]
pub struct AwsKmsKeyringConfig {
    #[serde(rename = "kmsKeyId")]
    pub kms_key_id: String,
    #[serde(rename = "grantTokens", default)]
    pub grant_tokens: Option<Vec<String>>,
}

#[derive(Debug, Deserialize)]
pub struct AwsKmsMrkKeyringConfig {
    #[serde(rename = "kmsKeyId")]
    pub kms_key_id: String,
    #[serde(rename = "grantTokens", default)]
    pub grant_tokens: Option<Vec<String>>,
}

#[derive(Debug, Deserialize)]
pub struct AwsKmsMultiKeyringConfig {
    #[serde(rename = "generator", default)]
    pub generator: Option<String>,
    #[serde(rename = "kmsKeyIds", default)]
    pub kms_key_ids: Option<Vec<String>>,
    #[serde(rename = "grantTokens", default)]
    pub grant_tokens: Option<Vec<String>>,
}

#[derive(Debug, Deserialize)]
pub struct AwsKmsMrkMultiKeyringConfig {
    #[serde(rename = "generator", default)]
    pub generator: Option<String>,
    #[serde(rename = "kmsKeyIds", default)]
    pub kms_key_ids: Option<Vec<String>>,
    #[serde(rename = "grantTokens", default)]
    pub grant_tokens: Option<Vec<String>>,
}

#[derive(Debug, Deserialize)]
pub struct AwsKmsDiscoveryKeyringConfig {
    #[serde(rename = "discoveryFilter", default)]
    pub discovery_filter: Option<DiscoveryFilter>,
    #[serde(rename = "grantTokens", default)]
    pub grant_tokens: Option<Vec<String>>,
}

#[derive(Debug, Deserialize)]
pub struct AwsKmsMrkDiscoveryKeyringConfig {
    pub region: String,
    #[serde(rename = "discoveryFilter", default)]
    pub discovery_filter: Option<DiscoveryFilter>,
    #[serde(rename = "grantTokens", default)]
    pub grant_tokens: Option<Vec<String>>,
}

#[derive(Debug, Deserialize)]
pub struct AwsKmsRsaKeyringConfig {
    #[serde(rename = "kmsKeyId")]
    pub kms_key_id: String,
    #[serde(rename = "publicKey", default)]
    pub public_key: Option<ByteBuf>,
    #[serde(rename = "encryptionAlgorithm", default)]
    pub encryption_algorithm: Option<KmsRsaEncryptionAlgorithm>,
    #[serde(rename = "grantTokens", default)]
    pub grant_tokens: Option<Vec<String>>,
}

#[derive(Debug, Deserialize)]
pub struct DiscoveryFilter {
    pub partition: String,
    #[serde(rename = "accountIds")]
    pub account_ids: Vec<String>,
}

#[derive(Debug, Clone, Copy, Deserialize)]
pub enum KmsRsaEncryptionAlgorithm {
    #[serde(rename = "RSAES_OAEP_SHA_1")]
    OaepSha1,
    #[serde(rename = "RSAES_OAEP_SHA_256")]
    OaepSha256,
}

#[derive(Debug, Deserialize)]
pub struct RawAesKeyringConfig {
    #[serde(rename = "keyNamespace")]
    pub key_namespace: String,
    #[serde(rename = "keyName")]
    pub key_name: String,
    #[serde(rename = "wrappingKey")]
    pub wrapping_key: ByteBuf,
    #[serde(rename = "wrappingAlg")]
    pub wrapping_alg: AesWrappingAlg,
}

#[derive(Debug, Clone, Copy, Deserialize)]
pub enum AesWrappingAlg {
    #[serde(rename = "ALG_AES128_GCM_IV12_TAG16")]
    Aes128,
    #[serde(rename = "ALG_AES192_GCM_IV12_TAG16")]
    Aes192,
    #[serde(rename = "ALG_AES256_GCM_IV12_TAG16")]
    Aes256,
}

#[derive(Debug, Deserialize)]
pub struct RawRsaKeyringConfig {
    #[serde(rename = "keyNamespace")]
    pub key_namespace: String,
    #[serde(rename = "keyName")]
    pub key_name: String,
    #[serde(rename = "paddingScheme")]
    pub padding_scheme: PaddingScheme,
    #[serde(rename = "publicKey", default)]
    pub public_key: Option<ByteBuf>,
    #[serde(rename = "privateKey", default)]
    pub private_key: Option<ByteBuf>,
}

#[derive(Debug, Clone, Copy, Deserialize)]
pub enum PaddingScheme {
    #[serde(rename = "PKCS1")]
    Pkcs1,
    #[serde(rename = "OAEP_SHA1_MGF1")]
    OaepSha1Mgf1,
    #[serde(rename = "OAEP_SHA256_MGF1")]
    OaepSha256Mgf1,
    #[serde(rename = "OAEP_SHA384_MGF1")]
    OaepSha384Mgf1,
    #[serde(rename = "OAEP_SHA512_MGF1")]
    OaepSha512Mgf1,
}

#[derive(Debug, Deserialize)]
pub struct AwsKmsHierarchicalKeyringConfig {
    // Exactly one of `branchKeyId` (a fixed branch key) or `branchKeyIdSupplier`
    // (a declarative, per-item branch key selector) is set on the wire; both are
    // optional here so the factory can pick the corresponding construction path.
    #[serde(rename = "branchKeyId", default)]
    pub branch_key_id: Option<String>,
    #[serde(rename = "branchKeyIdSupplier", default)]
    pub branch_key_id_supplier: Option<DdbKeyBranchKeyIdSupplier>,
    #[serde(rename = "keyStoreTableName")]
    pub key_store_table_name: String,
    #[serde(rename = "logicalKeyStoreName")]
    pub logical_key_store_name: String,
    #[serde(rename = "kmsKeyArn")]
    pub kms_key_arn: String,
    #[serde(rename = "ttlSeconds")]
    pub ttl_seconds: i32,
}

/// Declarative branch-key-id supplier: reads the (String) value of
/// `routeAttribute` from the DynamoDB key and maps it through `routes` to the
/// branch key id to use for that item. Wire-equivalent to a hand-written
/// `DynamoDbKeyBranchKeyIdSupplier` implementation (see factory.rs).
#[derive(Debug, Deserialize)]
pub struct DdbKeyBranchKeyIdSupplier {
    #[serde(rename = "routeAttribute")]
    pub route_attribute: String,
    #[serde(rename = "routes")]
    pub routes: HashMap<String, String>,
}

#[derive(Debug, Deserialize)]
pub struct MultiKeyringConfig {
    #[serde(rename = "generator", default)]
    pub generator: Option<Box<Keyring>>,
    #[serde(rename = "childKeyrings")]
    pub child_keyrings: Vec<Keyring>,
}

// ---------------------------------------------------------------------------
// GetEncryptedDataKeyDescription
// ---------------------------------------------------------------------------

#[derive(Debug, Deserialize)]
pub struct GetEncryptedDataKeyDescriptionRequest {
    pub input: EncryptedDataKeyDescriptionSource,
}

/// Smithy union: exactly one of `header` (a raw serialized header) or `item`
/// (an encrypted item whose `aws_dbe_head` carries the header). Like the other
/// polymorphic wire shapes here (AttributeValue, Keyring), it is modeled as a
/// struct with all-optional members — byte-identical on the wire to a union
/// (a one-key map) and what ciborium deserializes cleanly.
#[derive(Debug, Deserialize, Default)]
pub struct EncryptedDataKeyDescriptionSource {
    #[serde(rename = "header", skip_serializing_if = "Option::is_none", default)]
    pub header: Option<ByteBuf>,
    #[serde(rename = "item", skip_serializing_if = "Option::is_none", default)]
    pub item: Option<DdbItem>,
}

#[derive(Debug, Serialize)]
pub struct GetEncryptedDataKeyDescriptionResponse {
    pub descriptions: Vec<EncryptedDataKeyDescription>,
}

#[derive(Debug, Serialize)]
pub struct EncryptedDataKeyDescription {
    #[serde(rename = "keyProviderId")]
    pub key_provider_id: String,
    #[serde(rename = "keyProviderInfo", skip_serializing_if = "Option::is_none")]
    pub key_provider_info: Option<String>,
    #[serde(rename = "branchKeyId", skip_serializing_if = "Option::is_none")]
    pub branch_key_id: Option<String>,
    #[serde(rename = "branchKeyVersion", skip_serializing_if = "Option::is_none")]
    pub branch_key_version: Option<String>,
}

// ---------------------------------------------------------------------------
// GetNumberOfQueries (DynamoDbEncryptionTransforms op)
// ---------------------------------------------------------------------------

#[derive(Debug, Deserialize)]
pub struct GetNumberOfQueriesRequest {
    #[serde(rename = "clientId")]
    pub client_id: String,
    #[serde(rename = "sdkInput")]
    pub sdk_input: QueryInput,
}

#[derive(Debug, Serialize)]
pub struct GetNumberOfQueriesResponse {
    #[serde(rename = "numberOfQueries")]
    pub number_of_queries: i32,
}

// ---------------------------------------------------------------------------
// GetItemInputTransform
// ---------------------------------------------------------------------------

#[derive(Debug, Deserialize)]
pub struct GetItemInputTransformRequest {
    #[serde(rename = "clientId")]
    pub client_id: String,
    #[serde(rename = "sdkInput")]
    pub sdk_input: GetItemInput,
}

#[derive(Debug, Serialize)]
pub struct GetItemInputTransformResponse {
    #[serde(rename = "transformedInput")]
    pub transformed_input: GetItemInput,
}

// ---------------------------------------------------------------------------
// PutItemOutputTransform
// ---------------------------------------------------------------------------

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct PutItemOutput {
    #[serde(skip_serializing_if = "Option::is_none", default)]
    pub attributes: Option<DdbItem>,
}

#[derive(Debug, Deserialize)]
pub struct PutItemOutputTransformRequest {
    #[serde(rename = "clientId")]
    pub client_id: String,
    #[serde(rename = "sdkOutput")]
    pub sdk_output: PutItemOutput,
    #[serde(rename = "originalInput")]
    pub original_input: PutItemInput,
}

#[derive(Debug, Serialize)]
pub struct PutItemOutputTransformResponse {
    #[serde(rename = "transformedOutput")]
    pub transformed_output: PutItemOutput,
}

// ---------------------------------------------------------------------------
// UpdateItemOutputTransform / DeleteItemOutputTransform
// ---------------------------------------------------------------------------

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct UpdateItemOutput {
    #[serde(skip_serializing_if = "Option::is_none", default)]
    pub attributes: Option<DdbItem>,
}

#[derive(Debug, Deserialize)]
pub struct UpdateItemOutputTransformRequest {
    #[serde(rename = "clientId")]
    pub client_id: String,
    #[serde(rename = "sdkOutput")]
    pub sdk_output: UpdateItemOutput,
    #[serde(rename = "originalInput")]
    pub original_input: UpdateItemInput,
}

#[derive(Debug, Serialize)]
pub struct UpdateItemOutputTransformResponse {
    #[serde(rename = "transformedOutput")]
    pub transformed_output: UpdateItemOutput,
}

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct DeleteItemOutput {
    #[serde(skip_serializing_if = "Option::is_none", default)]
    pub attributes: Option<DdbItem>,
}

#[derive(Debug, Deserialize)]
pub struct DeleteItemOutputTransformRequest {
    #[serde(rename = "clientId")]
    pub client_id: String,
    #[serde(rename = "sdkOutput")]
    pub sdk_output: DeleteItemOutput,
    #[serde(rename = "originalInput")]
    pub original_input: DeleteItemInput,
}

#[derive(Debug, Serialize)]
pub struct DeleteItemOutputTransformResponse {
    #[serde(rename = "transformedOutput")]
    pub transformed_output: DeleteItemOutput,
}

// ---------------------------------------------------------------------------
// TransactWriteItemsOutputTransform (no item content -> empty passthrough)
// ---------------------------------------------------------------------------

#[derive(Debug, Clone, Serialize, Deserialize, Default)]
pub struct TransactWriteItemsOutput {}

#[derive(Debug, Deserialize)]
pub struct TransactWriteItemsOutputTransformRequest {
    #[serde(rename = "clientId")]
    pub client_id: String,
    #[serde(rename = "sdkOutput")]
    pub sdk_output: TransactWriteItemsOutput,
    #[serde(rename = "originalInput")]
    pub original_input: TransactWriteItemsInput,
}

#[derive(Debug, Serialize)]
pub struct TransactWriteItemsOutputTransformResponse {
    #[serde(rename = "transformedOutput")]
    pub transformed_output: TransactWriteItemsOutput,
}

// ---------------------------------------------------------------------------
// ExecuteStatementOutputTransform (items list)
// ---------------------------------------------------------------------------

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct ExecuteStatementOutput {
    #[serde(skip_serializing_if = "Option::is_none", default)]
    pub items: Option<Vec<DdbItem>>,
}

#[derive(Debug, Deserialize)]
pub struct ExecuteStatementOutputTransformRequest {
    #[serde(rename = "clientId")]
    pub client_id: String,
    #[serde(rename = "sdkOutput")]
    pub sdk_output: ExecuteStatementOutput,
    #[serde(rename = "originalInput")]
    pub original_input: ExecuteStatementInput,
}

#[derive(Debug, Serialize)]
pub struct ExecuteStatementOutputTransformResponse {
    #[serde(rename = "transformedOutput")]
    pub transformed_output: ExecuteStatementOutput,
}

// ---------------------------------------------------------------------------
// ExecuteTransactionOutputTransform (responses: list of ItemResponse{item})
// ---------------------------------------------------------------------------

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct ItemResponse {
    #[serde(skip_serializing_if = "Option::is_none", default)]
    pub item: Option<DdbItem>,
}

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct ExecuteTransactionOutput {
    #[serde(skip_serializing_if = "Option::is_none", default)]
    pub responses: Option<Vec<ItemResponse>>,
}

#[derive(Debug, Deserialize)]
pub struct ExecuteTransactionOutputTransformRequest {
    #[serde(rename = "clientId")]
    pub client_id: String,
    #[serde(rename = "sdkOutput")]
    pub sdk_output: ExecuteTransactionOutput,
    #[serde(rename = "originalInput")]
    pub original_input: ExecuteTransactionInput,
}

#[derive(Debug, Serialize)]
pub struct ExecuteTransactionOutputTransformResponse {
    #[serde(rename = "transformedOutput")]
    pub transformed_output: ExecuteTransactionOutput,
}

// ---------------------------------------------------------------------------
// BatchExecuteStatementOutputTransform (responses: list of {tableName, item})
// ---------------------------------------------------------------------------

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct BatchStatementResponse {
    #[serde(rename = "tableName", skip_serializing_if = "Option::is_none", default)]
    pub table_name: Option<String>,
    #[serde(skip_serializing_if = "Option::is_none", default)]
    pub item: Option<DdbItem>,
}

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct BatchExecuteStatementOutput {
    #[serde(skip_serializing_if = "Option::is_none", default)]
    pub responses: Option<Vec<BatchStatementResponse>>,
}

#[derive(Debug, Deserialize)]
pub struct BatchExecuteStatementOutputTransformRequest {
    #[serde(rename = "clientId")]
    pub client_id: String,
    #[serde(rename = "sdkOutput")]
    pub sdk_output: BatchExecuteStatementOutput,
    #[serde(rename = "originalInput")]
    pub original_input: BatchExecuteStatementInput,
}

#[derive(Debug, Serialize)]
pub struct BatchExecuteStatementOutputTransformResponse {
    #[serde(rename = "transformedOutput")]
    pub transformed_output: BatchExecuteStatementOutput,
}

// ---------------------------------------------------------------------------
// BatchGetItemInputTransform
// ---------------------------------------------------------------------------

#[derive(Debug, Deserialize)]
pub struct BatchGetItemInputTransformRequest {
    #[serde(rename = "clientId")]
    pub client_id: String,
    #[serde(rename = "sdkInput")]
    pub sdk_input: BatchGetItemInput,
}

#[derive(Debug, Serialize)]
pub struct BatchGetItemInputTransformResponse {
    #[serde(rename = "transformedInput")]
    pub transformed_input: BatchGetItemInput,
}

// ---------------------------------------------------------------------------
// TransactGetItems transforms
// ---------------------------------------------------------------------------

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct Get {
    #[serde(rename = "tableName")]
    pub table_name: String,
    pub key: DdbItem,
}

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct TransactGetItem {
    pub get: Get,
}

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct TransactGetItemsInput {
    #[serde(rename = "transactItems")]
    pub transact_items: Vec<TransactGetItem>,
}

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct TransactGetItemsOutput {
    #[serde(skip_serializing_if = "Option::is_none", default)]
    pub responses: Option<Vec<ItemResponse>>,
}

#[derive(Debug, Deserialize)]
pub struct TransactGetItemsInputTransformRequest {
    #[serde(rename = "clientId")]
    pub client_id: String,
    #[serde(rename = "sdkInput")]
    pub sdk_input: TransactGetItemsInput,
}

#[derive(Debug, Serialize)]
pub struct TransactGetItemsInputTransformResponse {
    #[serde(rename = "transformedInput")]
    pub transformed_input: TransactGetItemsInput,
}

#[derive(Debug, Deserialize)]
pub struct TransactGetItemsOutputTransformRequest {
    #[serde(rename = "clientId")]
    pub client_id: String,
    #[serde(rename = "sdkOutput")]
    pub sdk_output: TransactGetItemsOutput,
    #[serde(rename = "originalInput")]
    pub original_input: TransactGetItemsInput,
}

#[derive(Debug, Serialize)]
pub struct TransactGetItemsOutputTransformResponse {
    #[serde(rename = "transformedOutput")]
    pub transformed_output: TransactGetItemsOutput,
}
