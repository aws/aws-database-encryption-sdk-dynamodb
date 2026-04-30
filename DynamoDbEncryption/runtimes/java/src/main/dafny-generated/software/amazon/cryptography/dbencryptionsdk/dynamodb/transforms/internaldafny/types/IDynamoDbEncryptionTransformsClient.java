// Interface IDynamoDbEncryptionTransformsClient
// Dafny trait IDynamoDbEncryptionTransformsClient compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public interface IDynamoDbEncryptionTransformsClient {
  public Wrappers_Compile.Result<PutItemInputTransformOutput, Error> PutItemInputTransform(PutItemInputTransformInput input);
  public Wrappers_Compile.Result<PutItemOutputTransformOutput, Error> PutItemOutputTransform(PutItemOutputTransformInput input);
  public Wrappers_Compile.Result<GetItemInputTransformOutput, Error> GetItemInputTransform(GetItemInputTransformInput input);
  public Wrappers_Compile.Result<GetItemOutputTransformOutput, Error> GetItemOutputTransform(GetItemOutputTransformInput input);
  public Wrappers_Compile.Result<BatchWriteItemInputTransformOutput, Error> BatchWriteItemInputTransform(BatchWriteItemInputTransformInput input);
  public Wrappers_Compile.Result<BatchWriteItemOutputTransformOutput, Error> BatchWriteItemOutputTransform(BatchWriteItemOutputTransformInput input);
  public Wrappers_Compile.Result<BatchGetItemInputTransformOutput, Error> BatchGetItemInputTransform(BatchGetItemInputTransformInput input);
  public Wrappers_Compile.Result<BatchGetItemOutputTransformOutput, Error> BatchGetItemOutputTransform(BatchGetItemOutputTransformInput input);
  public Wrappers_Compile.Result<ScanInputTransformOutput, Error> ScanInputTransform(ScanInputTransformInput input);
  public Wrappers_Compile.Result<ScanOutputTransformOutput, Error> ScanOutputTransform(ScanOutputTransformInput input);
  public Wrappers_Compile.Result<QueryInputTransformOutput, Error> QueryInputTransform(QueryInputTransformInput input);
  public Wrappers_Compile.Result<QueryOutputTransformOutput, Error> QueryOutputTransform(QueryOutputTransformInput input);
  public Wrappers_Compile.Result<TransactWriteItemsInputTransformOutput, Error> TransactWriteItemsInputTransform(TransactWriteItemsInputTransformInput input);
  public Wrappers_Compile.Result<TransactWriteItemsOutputTransformOutput, Error> TransactWriteItemsOutputTransform(TransactWriteItemsOutputTransformInput input);
  public Wrappers_Compile.Result<UpdateItemInputTransformOutput, Error> UpdateItemInputTransform(UpdateItemInputTransformInput input);
  public Wrappers_Compile.Result<UpdateItemOutputTransformOutput, Error> UpdateItemOutputTransform(UpdateItemOutputTransformInput input);
  public Wrappers_Compile.Result<DeleteItemInputTransformOutput, Error> DeleteItemInputTransform(DeleteItemInputTransformInput input);
  public Wrappers_Compile.Result<DeleteItemOutputTransformOutput, Error> DeleteItemOutputTransform(DeleteItemOutputTransformInput input);
  public Wrappers_Compile.Result<TransactGetItemsInputTransformOutput, Error> TransactGetItemsInputTransform(TransactGetItemsInputTransformInput input);
  public Wrappers_Compile.Result<TransactGetItemsOutputTransformOutput, Error> TransactGetItemsOutputTransform(TransactGetItemsOutputTransformInput input);
  public Wrappers_Compile.Result<ExecuteStatementInputTransformOutput, Error> ExecuteStatementInputTransform(ExecuteStatementInputTransformInput input);
  public Wrappers_Compile.Result<ExecuteStatementOutputTransformOutput, Error> ExecuteStatementOutputTransform(ExecuteStatementOutputTransformInput input);
  public Wrappers_Compile.Result<BatchExecuteStatementInputTransformOutput, Error> BatchExecuteStatementInputTransform(BatchExecuteStatementInputTransformInput input);
  public Wrappers_Compile.Result<BatchExecuteStatementOutputTransformOutput, Error> BatchExecuteStatementOutputTransform(BatchExecuteStatementOutputTransformInput input);
  public Wrappers_Compile.Result<ExecuteTransactionInputTransformOutput, Error> ExecuteTransactionInputTransform(ExecuteTransactionInputTransformInput input);
  public Wrappers_Compile.Result<ExecuteTransactionOutputTransformOutput, Error> ExecuteTransactionOutputTransform(ExecuteTransactionOutputTransformInput input);
  public Wrappers_Compile.Result<ResolveAttributesOutput, Error> ResolveAttributes(ResolveAttributesInput input);
}
