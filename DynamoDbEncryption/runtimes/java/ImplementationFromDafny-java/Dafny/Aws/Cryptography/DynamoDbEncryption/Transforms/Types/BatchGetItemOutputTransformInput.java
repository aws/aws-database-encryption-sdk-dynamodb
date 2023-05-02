// Class BatchGetItemOutputTransformInput
// Dafny class BatchGetItemOutputTransformInput compiled into Java
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
public class BatchGetItemOutputTransformInput {
  public Dafny.Com.Amazonaws.Dynamodb.Types.BatchGetItemOutput _sdkOutput;
  public Dafny.Com.Amazonaws.Dynamodb.Types.BatchGetItemInput _originalInput;
  public BatchGetItemOutputTransformInput (Dafny.Com.Amazonaws.Dynamodb.Types.BatchGetItemOutput sdkOutput, Dafny.Com.Amazonaws.Dynamodb.Types.BatchGetItemInput originalInput) {
    this._sdkOutput = sdkOutput;
    this._originalInput = originalInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    BatchGetItemOutputTransformInput o = (BatchGetItemOutputTransformInput)other;
    return true && java.util.Objects.equals(this._sdkOutput, o._sdkOutput) && java.util.Objects.equals(this._originalInput, o._originalInput);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._sdkOutput);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._originalInput);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types_Compile.BatchGetItemOutputTransformInput.BatchGetItemOutputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkOutput));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._originalInput));
    s.append(")");
    return s.toString();
  }

  private static final BatchGetItemOutputTransformInput theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.BatchGetItemOutputTransformInput.create(Dafny.Com.Amazonaws.Dynamodb.Types.BatchGetItemOutput.Default(), Dafny.Com.Amazonaws.Dynamodb.Types.BatchGetItemInput.Default());
  public static BatchGetItemOutputTransformInput Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<BatchGetItemOutputTransformInput> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(BatchGetItemOutputTransformInput.class, () -> Default());
  public static dafny.TypeDescriptor<BatchGetItemOutputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<BatchGetItemOutputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static BatchGetItemOutputTransformInput create(Dafny.Com.Amazonaws.Dynamodb.Types.BatchGetItemOutput sdkOutput, Dafny.Com.Amazonaws.Dynamodb.Types.BatchGetItemInput originalInput) {
    return new BatchGetItemOutputTransformInput(sdkOutput, originalInput);
  }
  public static BatchGetItemOutputTransformInput create_BatchGetItemOutputTransformInput(Dafny.Com.Amazonaws.Dynamodb.Types.BatchGetItemOutput sdkOutput, Dafny.Com.Amazonaws.Dynamodb.Types.BatchGetItemInput originalInput) {
    return create(sdkOutput, originalInput);
  }
  public boolean is_BatchGetItemOutputTransformInput() { return true; }
  public Dafny.Com.Amazonaws.Dynamodb.Types.BatchGetItemOutput dtor_sdkOutput() {
    return this._sdkOutput;
  }
  public Dafny.Com.Amazonaws.Dynamodb.Types.BatchGetItemInput dtor_originalInput() {
    return this._originalInput;
  }
}
