package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.model.ConditionCheck;
import aws.cryptography.dbesdk.testserver.server.model.Delete;
import aws.cryptography.dbesdk.testserver.server.model.Put;
import aws.cryptography.dbesdk.testserver.server.model.TransactWriteItem;
import aws.cryptography.dbesdk.testserver.server.model.Update;

/**
 * Maps a wire {@link TransactWriteItem} to/from the AWS SDK type, covering all
 * four member actions (Put, Delete, Update, ConditionCheck). An item that sets
 * no action is mapped to an empty SDK item, which the DBE library rejects with
 * "must specify at least one supported operation" — matching the Dafny contract.
 */
final class TransactWriteItemCodec {

  private TransactWriteItemCodec() {}

  static software.amazon.awssdk.services.dynamodb.model.TransactWriteItem toSdk(
    TransactWriteItem item,
    DdbItemCodec itemCodec
  ) {
    software.amazon.awssdk.services.dynamodb.model.TransactWriteItem.Builder b =
      software.amazon.awssdk.services.dynamodb.model.TransactWriteItem.builder();
    if (item.getPut() != null) {
      Put put = item.getPut();
      b.put(
        software.amazon.awssdk.services.dynamodb.model.Put
          .builder()
          .tableName(put.getTableName())
          .item(itemCodec.toDdb(put.getItem()))
          .build()
      );
    }
    if (item.getDelete() != null) {
      Delete d = item.getDelete();
      software.amazon.awssdk.services.dynamodb.model.Delete.Builder db =
        software.amazon.awssdk.services.dynamodb.model.Delete
          .builder()
          .tableName(d.getTableName())
          .key(itemCodec.toDdb(d.getKey()));
      if (d.getConditionExpression() != null) {
        db.conditionExpression(d.getConditionExpression());
      }
      if (d.getExpressionAttributeNames() != null) {
        db.expressionAttributeNames(d.getExpressionAttributeNames());
      }
      if (d.getExpressionAttributeValues() != null) {
        db.expressionAttributeValues(
          itemCodec.toDdb(d.getExpressionAttributeValues())
        );
      }
      b.delete(db.build());
    }
    if (item.getUpdate() != null) {
      Update u = item.getUpdate();
      software.amazon.awssdk.services.dynamodb.model.Update.Builder ub =
        software.amazon.awssdk.services.dynamodb.model.Update
          .builder()
          .tableName(u.getTableName())
          .key(itemCodec.toDdb(u.getKey()))
          .updateExpression(u.getUpdateExpression());
      if (u.getConditionExpression() != null) {
        ub.conditionExpression(u.getConditionExpression());
      }
      if (u.getExpressionAttributeNames() != null) {
        ub.expressionAttributeNames(u.getExpressionAttributeNames());
      }
      if (u.getExpressionAttributeValues() != null) {
        ub.expressionAttributeValues(
          itemCodec.toDdb(u.getExpressionAttributeValues())
        );
      }
      b.update(ub.build());
    }
    if (item.getConditionCheck() != null) {
      ConditionCheck c = item.getConditionCheck();
      software.amazon.awssdk.services.dynamodb.model.ConditionCheck.Builder cb =
        software.amazon.awssdk.services.dynamodb.model.ConditionCheck
          .builder()
          .tableName(c.getTableName())
          .key(itemCodec.toDdb(c.getKey()))
          .conditionExpression(c.getConditionExpression());
      if (c.getExpressionAttributeNames() != null) {
        cb.expressionAttributeNames(c.getExpressionAttributeNames());
      }
      if (c.getExpressionAttributeValues() != null) {
        cb.expressionAttributeValues(
          itemCodec.toDdb(c.getExpressionAttributeValues())
        );
      }
      b.conditionCheck(cb.build());
    }
    return b.build();
  }

  static TransactWriteItem toWire(
    software.amazon.awssdk.services.dynamodb.model.TransactWriteItem item,
    DdbItemCodec itemCodec
  ) {
    TransactWriteItem.Builder b = TransactWriteItem.builder();
    if (item.put() != null) {
      b.put(
        Put
          .builder()
          .tableName(item.put().tableName())
          .item(itemCodec.toModel(item.put().item()))
          .build()
      );
    }
    if (item.delete() != null) {
      software.amazon.awssdk.services.dynamodb.model.Delete d = item.delete();
      Delete.Builder db = Delete
        .builder()
        .tableName(d.tableName())
        .key(itemCodec.toModel(d.key()));
      if (d.conditionExpression() != null) {
        db.conditionExpression(d.conditionExpression());
      }
      if (d.hasExpressionAttributeNames()) {
        db.expressionAttributeNames(d.expressionAttributeNames());
      }
      if (d.hasExpressionAttributeValues()) {
        db.expressionAttributeValues(
          itemCodec.toModel(d.expressionAttributeValues())
        );
      }
      b.delete(db.build());
    }
    if (item.update() != null) {
      software.amazon.awssdk.services.dynamodb.model.Update u = item.update();
      Update.Builder ub = Update
        .builder()
        .tableName(u.tableName())
        .key(itemCodec.toModel(u.key()))
        .updateExpression(u.updateExpression());
      if (u.conditionExpression() != null) {
        ub.conditionExpression(u.conditionExpression());
      }
      if (u.hasExpressionAttributeNames()) {
        ub.expressionAttributeNames(u.expressionAttributeNames());
      }
      if (u.hasExpressionAttributeValues()) {
        ub.expressionAttributeValues(
          itemCodec.toModel(u.expressionAttributeValues())
        );
      }
      b.update(ub.build());
    }
    if (item.conditionCheck() != null) {
      software.amazon.awssdk.services.dynamodb.model.ConditionCheck c =
        item.conditionCheck();
      ConditionCheck.Builder cb = ConditionCheck
        .builder()
        .tableName(c.tableName())
        .key(itemCodec.toModel(c.key()))
        .conditionExpression(c.conditionExpression());
      if (c.hasExpressionAttributeNames()) {
        cb.expressionAttributeNames(c.expressionAttributeNames());
      }
      if (c.hasExpressionAttributeValues()) {
        cb.expressionAttributeValues(
          itemCodec.toModel(c.expressionAttributeValues())
        );
      }
      b.conditionCheck(cb.build());
    }
    return b.build();
  }
}
