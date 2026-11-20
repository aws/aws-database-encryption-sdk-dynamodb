package aws.cryptography.dbesdk.testserver.server.registry;

import aws.cryptography.dbesdk.testserver.server.error.DbesdkClientException;
import software.amazon.awssdk.services.dynamodb.model.BatchExecuteStatementRequest;
import software.amazon.awssdk.services.dynamodb.model.BatchExecuteStatementResponse;
import software.amazon.awssdk.services.dynamodb.model.BatchGetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.BatchGetItemResponse;
import software.amazon.awssdk.services.dynamodb.model.BatchWriteItemRequest;
import software.amazon.awssdk.services.dynamodb.model.BatchWriteItemResponse;
import software.amazon.awssdk.services.dynamodb.model.DeleteItemRequest;
import software.amazon.awssdk.services.dynamodb.model.DeleteItemResponse;
import software.amazon.awssdk.services.dynamodb.model.ExecuteStatementRequest;
import software.amazon.awssdk.services.dynamodb.model.ExecuteStatementResponse;
import software.amazon.awssdk.services.dynamodb.model.ExecuteTransactionRequest;
import software.amazon.awssdk.services.dynamodb.model.ExecuteTransactionResponse;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;
import software.amazon.awssdk.services.dynamodb.model.QueryRequest;
import software.amazon.awssdk.services.dynamodb.model.QueryResponse;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanResponse;
import software.amazon.awssdk.services.dynamodb.model.TransactGetItemsRequest;
import software.amazon.awssdk.services.dynamodb.model.TransactGetItemsResponse;
import software.amazon.awssdk.services.dynamodb.model.TransactWriteItemsRequest;
import software.amazon.awssdk.services.dynamodb.model.TransactWriteItemsResponse;
import software.amazon.awssdk.services.dynamodb.model.UpdateItemRequest;
import software.amazon.awssdk.services.dynamodb.model.UpdateItemResponse;

/**
 * A single configured DBE DDB-SDK transforms client stored in the
 * {@link TransformsClientRegistry}. On the Java server this wraps a real
 * {@link software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.DynamoDbEncryptionTransforms}
 * (see {@code RealTransformsClient}).
 *
 * <p>Unlike the {@link DbesdkClient} item encryptor, which operates on an
 * already-materialized item map, the transforms client operates on real AWS SDK
 * DynamoDB request/response objects — the interceptor hooks a DDB call would
 * pass through. This sub-round wires the encrypt-before {@code PutItemInput}
 * transform and the decrypt-after {@code GetItemOutput} transform; the remaining
 * DDB operations are added in later sub-rounds.
 *
 * <p>Both methods declare {@link DbesdkClientException}: implementations catch
 * exceptions thrown by the underlying DBE library and rethrow them wrapped, so
 * the operation wrapper forwards them as {@code DBESDKClientError} with the DBE
 * message unmodified.
 */
public interface TransformsClient {
  /**
   * Transform a DynamoDB PutItem input, encrypting the item per the table's
   * Crypto Actions.
   *
   * @param sdkInput the PutItem request to transform.
   * @return the transformed PutItem request whose item is now encrypted.
   * @throws DbesdkClientException if the DBE library fails.
   */
  PutItemRequest putItemInputTransform(PutItemRequest sdkInput)
    throws DbesdkClientException;

  /**
   * Transform a DynamoDB PutItem output. With no beacon config it returns the
   * output unchanged.
   *
   * @throws DbesdkClientException if the DBE library fails.
   */
  PutItemResponse putItemOutputTransform(
    PutItemRequest originalInput,
    PutItemResponse sdkOutput
  ) throws DbesdkClientException;

  /**
   * Transform a DynamoDB GetItem output, decrypting the returned item.
   *
   * @param originalInput the GetItem request that produced {@code sdkOutput}.
   * @param sdkOutput the GetItem response to transform.
   * @return the transformed GetItem response whose item (when present) is
   *     decrypted.
   * @throws DbesdkClientException if the DBE library fails.
   */
  GetItemResponse getItemOutputTransform(
    GetItemRequest originalInput,
    GetItemResponse sdkOutput
  ) throws DbesdkClientException;

  /**
   * Transform a DynamoDB GetItem input. With no beacon config it returns the
   * input unchanged.
   *
   * @throws DbesdkClientException if the DBE library fails.
   */
  GetItemRequest getItemInputTransform(GetItemRequest sdkInput)
    throws DbesdkClientException;

  /**
   * Transform a DynamoDB BatchWriteItem input, encrypting the item of every
   * PutRequest and passing DeleteRequests through unchanged.
   *
   * @param sdkInput the BatchWriteItem request to transform.
   * @return the transformed request whose PutRequest items are encrypted.
   * @throws DbesdkClientException if the DBE library fails.
   */
  BatchWriteItemRequest batchWriteItemInputTransform(
    BatchWriteItemRequest sdkInput
  ) throws DbesdkClientException;

  /**
   * Transform a DynamoDB BatchWriteItem output, restoring each unprocessed
   * PutRequest item to its original plaintext value (matched against
   * {@code originalInput} by primary key). A response with no UnprocessedItems
   * is returned unchanged.
   *
   * @param originalInput the original (plaintext) BatchWriteItem request.
   * @param sdkOutput the BatchWriteItem response to transform.
   * @return the transformed response whose UnprocessedItems are plaintext.
   * @throws DbesdkClientException if the DBE library fails.
   */
  BatchWriteItemResponse batchWriteItemOutputTransform(
    BatchWriteItemRequest originalInput,
    BatchWriteItemResponse sdkOutput
  ) throws DbesdkClientException;

  /**
   * Transform a DynamoDB TransactWriteItems input, encrypting the item of
   * every Put action.
   *
   * @param sdkInput the TransactWriteItems request to transform.
   * @return the transformed request whose Put items are encrypted.
   * @throws DbesdkClientException if the DBE library fails.
   */
  TransactWriteItemsRequest transactWriteItemsInputTransform(
    TransactWriteItemsRequest sdkInput
  ) throws DbesdkClientException;

  /**
   * Transform a DynamoDB Scan output, decrypting every returned item.
   *
   * @param originalInput the Scan request that produced {@code sdkOutput}.
   * @param sdkOutput the Scan response to transform.
   * @return the transformed response whose items are decrypted.
   * @throws DbesdkClientException if the DBE library fails.
   */
  ScanResponse scanOutputTransform(
    ScanRequest originalInput,
    ScanResponse sdkOutput
  ) throws DbesdkClientException;

  /**
   * Transform a DynamoDB Query output, decrypting every returned item.
   *
   * @param originalInput the Query request that produced {@code sdkOutput}.
   * @param sdkOutput the Query response to transform.
   * @return the transformed response whose items are decrypted.
   * @throws DbesdkClientException if the DBE library fails.
   */
  QueryResponse queryOutputTransform(
    QueryRequest originalInput,
    QueryResponse sdkOutput
  ) throws DbesdkClientException;

  /**
   * Transform a DynamoDB BatchGetItem output, decrypting every returned item
   * across all tables.
   *
   * @param originalInput the BatchGetItem request that produced {@code sdkOutput}.
   * @param sdkOutput the BatchGetItem response to transform.
   * @return the transformed response whose items are decrypted.
   * @throws DbesdkClientException if the DBE library fails.
   */
  BatchGetItemResponse batchGetItemOutputTransform(
    BatchGetItemRequest originalInput,
    BatchGetItemResponse sdkOutput
  ) throws DbesdkClientException;

  /**
   * Validate a PartiQL ExecuteStatement input. Throws when the statement
   * targets an encrypted table; otherwise returns the input unchanged.
   *
   * @throws DbesdkClientException if the DBE library rejects the statement.
   */
  ExecuteStatementRequest executeStatementInputTransform(
    ExecuteStatementRequest sdkInput
  ) throws DbesdkClientException;

  /**
   * Validate a PartiQL BatchExecuteStatement input. Throws when any statement
   * targets an encrypted table; otherwise returns the input unchanged.
   *
   * @throws DbesdkClientException if the DBE library rejects a statement.
   */
  BatchExecuteStatementRequest batchExecuteStatementInputTransform(
    BatchExecuteStatementRequest sdkInput
  ) throws DbesdkClientException;

  /**
   * Validate a PartiQL ExecuteTransaction input. Throws when any transact
   * statement targets an encrypted table; otherwise returns the input
   * unchanged.
   *
   * @throws DbesdkClientException if the DBE library rejects a statement.
   */
  ExecuteTransactionRequest executeTransactionInputTransform(
    ExecuteTransactionRequest sdkInput
  ) throws DbesdkClientException;

  /**
   * Transform a DynamoDB Scan input, rewriting FilterExpression references to
   * beaconed attributes into their beacons.
   *
   * @throws DbesdkClientException if the DBE library fails.
   */
  ScanRequest scanInputTransform(ScanRequest sdkInput)
    throws DbesdkClientException;

  /**
   * Transform a DynamoDB Query input, rewriting KeyCondition/Filter expression
   * references to beaconed attributes into their beacons.
   *
   * @throws DbesdkClientException if the DBE library fails.
   */
  QueryRequest queryInputTransform(QueryRequest sdkInput)
    throws DbesdkClientException;

  /**
   * Validate a DynamoDB UpdateItem input. Throws when the UpdateExpression
   * references a signed attribute; otherwise returns the input unchanged.
   *
   * @throws DbesdkClientException if the DBE library rejects the update.
   */
  UpdateItemRequest updateItemInputTransform(UpdateItemRequest sdkInput)
    throws DbesdkClientException;

  /**
   * Transform an UpdateItem output. With no beacon config it returns the
   * output unchanged.
   *
   * @throws DbesdkClientException if the DBE library fails.
   */
  UpdateItemResponse updateItemOutputTransform(
    UpdateItemRequest originalInput,
    UpdateItemResponse sdkOutput
  ) throws DbesdkClientException;

  /**
   * Validate a DynamoDB DeleteItem input. Throws when the ConditionExpression
   * references an encrypted attribute; otherwise returns the input unchanged.
   *
   * @throws DbesdkClientException if the DBE library rejects the delete.
   */
  DeleteItemRequest deleteItemInputTransform(DeleteItemRequest sdkInput)
    throws DbesdkClientException;

  /**
   * Transform a DeleteItem output. With no beacon config it returns the
   * output unchanged.
   *
   * @throws DbesdkClientException if the DBE library fails.
   */
  DeleteItemResponse deleteItemOutputTransform(
    DeleteItemRequest originalInput,
    DeleteItemResponse sdkOutput
  ) throws DbesdkClientException;

  /**
   * Transform a TransactWriteItems output. The response carries no item
   * content, so this is a passthrough.
   *
   * @throws DbesdkClientException if the DBE library fails.
   */
  TransactWriteItemsResponse transactWriteItemsOutputTransform(
    TransactWriteItemsRequest originalInput,
    TransactWriteItemsResponse sdkOutput
  ) throws DbesdkClientException;

  /**
   * Transform an ExecuteStatement output, decrypting the returned items. With
   * no beacon config it returns the output unchanged.
   *
   * @throws DbesdkClientException if the DBE library fails.
   */
  ExecuteStatementResponse executeStatementOutputTransform(
    ExecuteStatementRequest originalInput,
    ExecuteStatementResponse sdkOutput
  ) throws DbesdkClientException;

  /**
   * Transform an ExecuteTransaction output, decrypting each returned item.
   * With no beacon config it returns the output unchanged.
   *
   * @throws DbesdkClientException if the DBE library fails.
   */
  ExecuteTransactionResponse executeTransactionOutputTransform(
    ExecuteTransactionRequest originalInput,
    ExecuteTransactionResponse sdkOutput
  ) throws DbesdkClientException;

  /**
   * Transform a BatchExecuteStatement output, decrypting each returned item.
   * With no beacon config it returns the output unchanged.
   *
   * @throws DbesdkClientException if the DBE library fails.
   */
  BatchExecuteStatementResponse batchExecuteStatementOutputTransform(
    BatchExecuteStatementRequest originalInput,
    BatchExecuteStatementResponse sdkOutput
  ) throws DbesdkClientException;

  /**
   * Transform a BatchGetItem input. With no beacon config it returns the
   * input unchanged.
   *
   * @throws DbesdkClientException if the DBE library fails.
   */
  BatchGetItemRequest batchGetItemInputTransform(BatchGetItemRequest sdkInput)
    throws DbesdkClientException;

  /**
   * Transform a TransactGetItems input. With no beacon config it returns the
   * input unchanged.
   *
   * @throws DbesdkClientException if the DBE library fails.
   */
  TransactGetItemsRequest transactGetItemsInputTransform(
    TransactGetItemsRequest sdkInput
  ) throws DbesdkClientException;

  /**
   * Transform a TransactGetItems output, decrypting each returned item. With
   * no beacon config it returns the output unchanged.
   *
   * @throws DbesdkClientException if the DBE library fails.
   */
  TransactGetItemsResponse transactGetItemsOutputTransform(
    TransactGetItemsRequest originalInput,
    TransactGetItemsResponse sdkOutput
  ) throws DbesdkClientException;
}
