// Class BatchExecuteStatementOutputTransformOutput
// Dafny class BatchExecuteStatementOutputTransformOutput compiled into Java
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
public class BatchExecuteStatementOutputTransformOutput {
  public Dafny.Com.Amazonaws.Dynamodb.Types.BatchExecuteStatementOutput _transformedOutput;
  public BatchExecuteStatementOutputTransformOutput (Dafny.Com.Amazonaws.Dynamodb.Types.BatchExecuteStatementOutput transformedOutput) {
    this._transformedOutput = transformedOutput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    BatchExecuteStatementOutputTransformOutput o = (BatchExecuteStatementOutputTransformOutput)other;
    return true && java.util.Objects.equals(this._transformedOutput, o._transformedOutput);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._transformedOutput);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types_Compile.BatchExecuteStatementOutputTransformOutput.BatchExecuteStatementOutputTransformOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._transformedOutput));
    s.append(")");
    return s.toString();
  }

  private static final BatchExecuteStatementOutputTransformOutput theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchExecuteStatementOutputTransformOutput.create(Dafny.Com.Amazonaws.Dynamodb.Types.BatchExecuteStatementOutput.Default());
  public static BatchExecuteStatementOutputTransformOutput Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<BatchExecuteStatementOutputTransformOutput> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(BatchExecuteStatementOutputTransformOutput.class, () -> Default());
  public static dafny.TypeDescriptor<BatchExecuteStatementOutputTransformOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<BatchExecuteStatementOutputTransformOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static BatchExecuteStatementOutputTransformOutput create(Dafny.Com.Amazonaws.Dynamodb.Types.BatchExecuteStatementOutput transformedOutput) {
    return new BatchExecuteStatementOutputTransformOutput(transformedOutput);
  }
  public static BatchExecuteStatementOutputTransformOutput create_BatchExecuteStatementOutputTransformOutput(Dafny.Com.Amazonaws.Dynamodb.Types.BatchExecuteStatementOutput transformedOutput) {
    return create(transformedOutput);
  }
  public boolean is_BatchExecuteStatementOutputTransformOutput() { return true; }
  public Dafny.Com.Amazonaws.Dynamodb.Types.BatchExecuteStatementOutput dtor_transformedOutput() {
    return this._transformedOutput;
  }
}
