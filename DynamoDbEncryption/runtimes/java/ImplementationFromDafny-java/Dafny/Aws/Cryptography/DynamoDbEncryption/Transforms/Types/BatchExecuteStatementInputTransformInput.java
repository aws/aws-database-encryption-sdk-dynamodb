// Class BatchExecuteStatementInputTransformInput
// Dafny class BatchExecuteStatementInputTransformInput compiled into Java
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
public class BatchExecuteStatementInputTransformInput {
  public Dafny.Com.Amazonaws.Dynamodb.Types.BatchExecuteStatementInput _sdkInput;
  public BatchExecuteStatementInputTransformInput (Dafny.Com.Amazonaws.Dynamodb.Types.BatchExecuteStatementInput sdkInput) {
    this._sdkInput = sdkInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    BatchExecuteStatementInputTransformInput o = (BatchExecuteStatementInputTransformInput)other;
    return true && java.util.Objects.equals(this._sdkInput, o._sdkInput);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._sdkInput);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types_Compile.BatchExecuteStatementInputTransformInput.BatchExecuteStatementInputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkInput));
    s.append(")");
    return s.toString();
  }

  private static final BatchExecuteStatementInputTransformInput theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchExecuteStatementInputTransformInput.create(Dafny.Com.Amazonaws.Dynamodb.Types.BatchExecuteStatementInput.Default());
  public static BatchExecuteStatementInputTransformInput Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<BatchExecuteStatementInputTransformInput> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(BatchExecuteStatementInputTransformInput.class, () -> Default());
  public static dafny.TypeDescriptor<BatchExecuteStatementInputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<BatchExecuteStatementInputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static BatchExecuteStatementInputTransformInput create(Dafny.Com.Amazonaws.Dynamodb.Types.BatchExecuteStatementInput sdkInput) {
    return new BatchExecuteStatementInputTransformInput(sdkInput);
  }
  public static BatchExecuteStatementInputTransformInput create_BatchExecuteStatementInputTransformInput(Dafny.Com.Amazonaws.Dynamodb.Types.BatchExecuteStatementInput sdkInput) {
    return create(sdkInput);
  }
  public boolean is_BatchExecuteStatementInputTransformInput() { return true; }
  public Dafny.Com.Amazonaws.Dynamodb.Types.BatchExecuteStatementInput dtor_sdkInput() {
    return this._sdkInput;
  }
}
