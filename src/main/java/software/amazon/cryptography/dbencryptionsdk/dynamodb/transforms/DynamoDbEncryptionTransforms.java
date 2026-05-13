// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms;

import java.util.Objects;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internal.*;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.*;

public class DynamoDbEncryptionTransforms {

  private final TransformConfig config;

  protected DynamoDbEncryptionTransforms(BuilderImpl builder) {
    this.config = new TransformConfig(builder.config);
  }

  public static Builder builder() {
    return new BuilderImpl();
  }

  public PutItemInputTransformOutput PutItemInputTransform(PutItemInputTransformInput input) {
    return PutItemTransform.inputTransform(input, config);
  }

  public PutItemOutputTransformOutput PutItemOutputTransform(PutItemOutputTransformInput input) {
    return PutItemTransform.outputTransform(input, config);
  }

  public GetItemInputTransformOutput GetItemInputTransform(GetItemInputTransformInput input) {
    return GetItemTransform.inputTransform(input, config);
  }

  public GetItemOutputTransformOutput GetItemOutputTransform(GetItemOutputTransformInput input) {
    return GetItemTransform.outputTransform(input, config);
  }

  public BatchWriteItemInputTransformOutput BatchWriteItemInputTransform(BatchWriteItemInputTransformInput input) {
    return BatchWriteItemTransform.inputTransform(input, config);
  }

  public BatchWriteItemOutputTransformOutput BatchWriteItemOutputTransform(BatchWriteItemOutputTransformInput input) {
    return BatchWriteItemTransform.outputTransform(input, config);
  }

  public BatchGetItemInputTransformOutput BatchGetItemInputTransform(BatchGetItemInputTransformInput input) {
    return BatchGetItemTransform.inputTransform(input, config);
  }

  public BatchGetItemOutputTransformOutput BatchGetItemOutputTransform(BatchGetItemOutputTransformInput input) {
    return BatchGetItemTransform.outputTransform(input, config);
  }

  public ScanInputTransformOutput ScanInputTransform(ScanInputTransformInput input) {
    return QueryScanTransform.scanInputTransform(input, config);
  }

  public ScanOutputTransformOutput ScanOutputTransform(ScanOutputTransformInput input) {
    return QueryScanTransform.scanOutputTransform(input, config);
  }

  public QueryInputTransformOutput QueryInputTransform(QueryInputTransformInput input) {
    return QueryScanTransform.queryInputTransform(input, config);
  }

  public QueryOutputTransformOutput QueryOutputTransform(QueryOutputTransformInput input) {
    return QueryScanTransform.queryOutputTransform(input, config);
  }

  public TransactWriteItemsInputTransformOutput TransactWriteItemsInputTransform(TransactWriteItemsInputTransformInput input) {
    return OtherTransforms.transactWriteInput(input, config);
  }

  public TransactWriteItemsOutputTransformOutput TransactWriteItemsOutputTransform(TransactWriteItemsOutputTransformInput input) {
    return OtherTransforms.transactWriteOutput(input, config);
  }

  public TransactGetItemsInputTransformOutput TransactGetItemsInputTransform(TransactGetItemsInputTransformInput input) {
    return OtherTransforms.transactGetInput(input, config);
  }

  public TransactGetItemsOutputTransformOutput TransactGetItemsOutputTransform(TransactGetItemsOutputTransformInput input) {
    return OtherTransforms.transactGetOutput(input, config);
  }

  public UpdateItemInputTransformOutput UpdateItemInputTransform(UpdateItemInputTransformInput input) {
    return OtherTransforms.updateItemInput(input, config);
  }

  public UpdateItemOutputTransformOutput UpdateItemOutputTransform(UpdateItemOutputTransformInput input) {
    return OtherTransforms.updateItemOutput(input, config);
  }

  public DeleteItemInputTransformOutput DeleteItemInputTransform(DeleteItemInputTransformInput input) {
    return OtherTransforms.deleteItemInput(input, config);
  }

  public DeleteItemOutputTransformOutput DeleteItemOutputTransform(DeleteItemOutputTransformInput input) {
    return OtherTransforms.deleteItemOutput(input, config);
  }

  public ExecuteStatementInputTransformOutput ExecuteStatementInputTransform(ExecuteStatementInputTransformInput input) {
    return OtherTransforms.executeStatementInput(input, config);
  }

  public ExecuteStatementOutputTransformOutput ExecuteStatementOutputTransform(ExecuteStatementOutputTransformInput input) {
    return OtherTransforms.executeStatementOutput(input, config);
  }

  public BatchExecuteStatementInputTransformOutput BatchExecuteStatementInputTransform(BatchExecuteStatementInputTransformInput input) {
    return OtherTransforms.batchExecuteStatementInput(input, config);
  }

  public BatchExecuteStatementOutputTransformOutput BatchExecuteStatementOutputTransform(BatchExecuteStatementOutputTransformInput input) {
    return OtherTransforms.batchExecuteStatementOutput(input, config);
  }

  public ExecuteTransactionInputTransformOutput ExecuteTransactionInputTransform(ExecuteTransactionInputTransformInput input) {
    return OtherTransforms.executeTransactionInput(input, config);
  }

  public ExecuteTransactionOutputTransformOutput ExecuteTransactionOutputTransform(ExecuteTransactionOutputTransformInput input) {
    return OtherTransforms.executeTransactionOutput(input, config);
  }

  public ResolveAttributesOutput ResolveAttributes(ResolveAttributesInput input) {
    // Returns empty maps — virtual fields and compound beacons are only populated
    // when searchable encryption (beacon) config is active for the table.
    // Without beacon config, there's nothing to resolve.
    java.util.Map<String, String> virtualFields = new java.util.HashMap<>();
    java.util.Map<String, String> compoundBeacons = new java.util.HashMap<>();
    return ResolveAttributesOutput.builder()
      .VirtualFields(virtualFields)
      .CompoundBeacons(compoundBeacons)
      .build();
  }

  public interface Builder {
    Builder DynamoDbTablesEncryptionConfig(DynamoDbTablesEncryptionConfig config);
    DynamoDbEncryptionTransforms build();
  }

  static class BuilderImpl implements Builder {

    protected DynamoDbTablesEncryptionConfig config;

    protected BuilderImpl() {}

    public Builder DynamoDbTablesEncryptionConfig(DynamoDbTablesEncryptionConfig config) {
      this.config = config;
      return this;
    }

    public DynamoDbEncryptionTransforms build() {
      if (Objects.isNull(this.config)) {
        throw new IllegalArgumentException(
          "Missing value for required field `DynamoDbTablesEncryptionConfig`"
        );
      }
      return new DynamoDbEncryptionTransforms(this);
    }
  }
}
