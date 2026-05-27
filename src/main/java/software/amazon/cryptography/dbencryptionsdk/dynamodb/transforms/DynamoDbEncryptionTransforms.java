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
    java.util.Map<String, String> virtualFields = new java.util.HashMap<>();
    java.util.Map<String, String> compoundBeacons = new java.util.HashMap<>();

    String tableName = input.TableName();
    software.amazon.cryptography.dbencryptionsdk.dynamodb.internal.BeaconConfigResolver.SearchInfo searchInfo =
      config.getSearchInfo(tableName);
    if (searchInfo != null && input.Item() != null) {
      // Resolve virtual fields
      if (searchInfo.beaconVersion.virtualFields() != null) {
        for (software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualField vf : searchInfo.beaconVersion.virtualFields()) {
          String value = resolveVirtualField(vf, input.Item());
          if (value != null) {
            virtualFields.put(vf.name(), value);
          }
        }
      }
      // Resolve compound beacons
      for (software.amazon.cryptography.dbencryptionsdk.dynamodb.internal.CompoundBeaconImpl cb : searchInfo.compoundBeacons) {
        String value = cb.constructPlaintext(input.Item());
        if (value != null) {
          compoundBeacons.put(cb.getName(), value);
        }
      }
    }

    return ResolveAttributesOutput.builder()
      .VirtualFields(virtualFields)
      .CompoundBeacons(compoundBeacons)
      .build();
  }

  private static String resolveVirtualField(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualField vf,
    java.util.Map<String, software.amazon.awssdk.services.dynamodb.model.AttributeValue> item
  ) {
    if (vf.parts() == null) return null;
    StringBuilder sb = new StringBuilder();
    for (software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualPart part : vf.parts()) {
      software.amazon.awssdk.services.dynamodb.model.AttributeValue av = item.get(part.loc());
      if (av == null) return null;
      String value;
      if (av.s() != null) value = av.s();
      else if (av.n() != null) value = av.n();
      else if (av.bool() != null) value = av.bool().toString();
      else return null;
      // Apply transforms
      if (part.trans() != null) {
        for (software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualTransform t : part.trans()) {
          value = applyTransform(value, t);
        }
      }
      sb.append(value);
    }
    return sb.toString();
  }

  private static String applyTransform(String value, software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualTransform t) {
    if (t.upper() != null) return value.toUpperCase();
    if (t.lower() != null) return value.toLowerCase();
    if (t.prefix() != null) {
      int len = t.prefix().length();
      if (len >= 0) return value.substring(0, Math.min(len, value.length()));
      else return value.substring(0, Math.max(0, value.length() + len));
    }
    if (t.suffix() != null) {
      int len = t.suffix().length();
      if (len >= 0) return value.substring(Math.max(0, value.length() - len));
      else return value.substring(Math.min(-len, value.length()));
    }
    if (t.substring() != null) {
      int low = t.substring().low();
      int high = t.substring().high();
      return value.substring(Math.min(low, value.length()), Math.min(high, value.length()));
    }
    return value;
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
