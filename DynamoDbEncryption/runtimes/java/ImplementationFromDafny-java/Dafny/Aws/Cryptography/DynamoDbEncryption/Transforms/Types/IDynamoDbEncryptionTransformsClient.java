// Interface IDynamoDbEncryptionTransformsClient
// Dafny trait IDynamoDbEncryptionTransformsClient compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.*;
import DynamoDbEncryptionUtil_Compile.*;
import DynamoDbNormalizeNumber_Compile.*;
import DynamoToStruct_Compile.*;
import DynamoDbEncryptionBranchKeyIdSupplier_Compile.*;
import AwsCryptographyDynamoDbEncryptionOperations_Compile.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.*;
import StructuredEncryptionUtil_Compile.*;
import Sets_Compile.*;
import StructuredEncryptionPaths_Compile.*;
import StructuredEncryptionHeader_Compile.*;
import StructuredEncryptionFooter_Compile.*;
import StructuredEncryptionCrypt_Compile.*;
import Maps_Compile.*;
import AwsCryptographyStructuredEncryptionOperations_Compile.*;
import Dafny.Aws.Cryptography.StructuredEncryption.*;
import TermLoc_Compile.*;
import DdbVirtualFields_Compile.*;
import BaseBeacon_Compile.*;
import CompoundBeacon_Compile.*;
import SearchableEncryptionInfo_Compile.*;
import SearchConfigToInfo_Compile.*;
import DynamoDbUpdateExpr_Compile.*;
import DynamoDBFilterExpr_Compile.*;
import DynamoDBIndexSupport_Compile.*;
import DynamoDBSupport_Compile.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.*;

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
  public Wrappers_Compile.Result<CreateTableInputTransformOutput, Error> CreateTableInputTransform(CreateTableInputTransformInput input);
  public Wrappers_Compile.Result<CreateTableOutputTransformOutput, Error> CreateTableOutputTransform(CreateTableOutputTransformInput input);
  public Wrappers_Compile.Result<UpdateTableInputTransformOutput, Error> UpdateTableInputTransform(UpdateTableInputTransformInput input);
  public Wrappers_Compile.Result<UpdateTableOutputTransformOutput, Error> UpdateTableOutputTransform(UpdateTableOutputTransformInput input);
  public Wrappers_Compile.Result<DescribeTableInputTransformOutput, Error> DescribeTableInputTransform(DescribeTableInputTransformInput input);
  public Wrappers_Compile.Result<DescribeTableOutputTransformOutput, Error> DescribeTableOutputTransform(DescribeTableOutputTransformInput input);
}
