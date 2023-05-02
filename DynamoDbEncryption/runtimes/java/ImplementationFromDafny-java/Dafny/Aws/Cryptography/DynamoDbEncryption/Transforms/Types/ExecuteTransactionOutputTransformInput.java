// Class ExecuteTransactionOutputTransformInput
// Dafny class ExecuteTransactionOutputTransformInput compiled into Java
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
public class ExecuteTransactionOutputTransformInput {
  public Dafny.Com.Amazonaws.Dynamodb.Types.ExecuteTransactionOutput _sdkOutput;
  public Dafny.Com.Amazonaws.Dynamodb.Types.ExecuteTransactionInput _originalInput;
  public ExecuteTransactionOutputTransformInput (Dafny.Com.Amazonaws.Dynamodb.Types.ExecuteTransactionOutput sdkOutput, Dafny.Com.Amazonaws.Dynamodb.Types.ExecuteTransactionInput originalInput) {
    this._sdkOutput = sdkOutput;
    this._originalInput = originalInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    ExecuteTransactionOutputTransformInput o = (ExecuteTransactionOutputTransformInput)other;
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
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types_Compile.ExecuteTransactionOutputTransformInput.ExecuteTransactionOutputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkOutput));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._originalInput));
    s.append(")");
    return s.toString();
  }

  private static final ExecuteTransactionOutputTransformInput theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.ExecuteTransactionOutputTransformInput.create(Dafny.Com.Amazonaws.Dynamodb.Types.ExecuteTransactionOutput.Default(), Dafny.Com.Amazonaws.Dynamodb.Types.ExecuteTransactionInput.Default());
  public static ExecuteTransactionOutputTransformInput Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<ExecuteTransactionOutputTransformInput> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(ExecuteTransactionOutputTransformInput.class, () -> Default());
  public static dafny.TypeDescriptor<ExecuteTransactionOutputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<ExecuteTransactionOutputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static ExecuteTransactionOutputTransformInput create(Dafny.Com.Amazonaws.Dynamodb.Types.ExecuteTransactionOutput sdkOutput, Dafny.Com.Amazonaws.Dynamodb.Types.ExecuteTransactionInput originalInput) {
    return new ExecuteTransactionOutputTransformInput(sdkOutput, originalInput);
  }
  public static ExecuteTransactionOutputTransformInput create_ExecuteTransactionOutputTransformInput(Dafny.Com.Amazonaws.Dynamodb.Types.ExecuteTransactionOutput sdkOutput, Dafny.Com.Amazonaws.Dynamodb.Types.ExecuteTransactionInput originalInput) {
    return create(sdkOutput, originalInput);
  }
  public boolean is_ExecuteTransactionOutputTransformInput() { return true; }
  public Dafny.Com.Amazonaws.Dynamodb.Types.ExecuteTransactionOutput dtor_sdkOutput() {
    return this._sdkOutput;
  }
  public Dafny.Com.Amazonaws.Dynamodb.Types.ExecuteTransactionInput dtor_originalInput() {
    return this._originalInput;
  }
}
