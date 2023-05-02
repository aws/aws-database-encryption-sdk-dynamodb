// Class TransactWriteItemsOutputTransformInput
// Dafny class TransactWriteItemsOutputTransformInput compiled into Java
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
public class TransactWriteItemsOutputTransformInput {
  public Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItemsOutput _sdkOutput;
  public Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItemsInput _originalInput;
  public TransactWriteItemsOutputTransformInput (Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItemsOutput sdkOutput, Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItemsInput originalInput) {
    this._sdkOutput = sdkOutput;
    this._originalInput = originalInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    TransactWriteItemsOutputTransformInput o = (TransactWriteItemsOutputTransformInput)other;
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
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types_Compile.TransactWriteItemsOutputTransformInput.TransactWriteItemsOutputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkOutput));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._originalInput));
    s.append(")");
    return s.toString();
  }

  private static final TransactWriteItemsOutputTransformInput theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsOutputTransformInput.create(Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItemsOutput.Default(), Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItemsInput.Default());
  public static TransactWriteItemsOutputTransformInput Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<TransactWriteItemsOutputTransformInput> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(TransactWriteItemsOutputTransformInput.class, () -> Default());
  public static dafny.TypeDescriptor<TransactWriteItemsOutputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<TransactWriteItemsOutputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static TransactWriteItemsOutputTransformInput create(Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItemsOutput sdkOutput, Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItemsInput originalInput) {
    return new TransactWriteItemsOutputTransformInput(sdkOutput, originalInput);
  }
  public static TransactWriteItemsOutputTransformInput create_TransactWriteItemsOutputTransformInput(Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItemsOutput sdkOutput, Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItemsInput originalInput) {
    return create(sdkOutput, originalInput);
  }
  public boolean is_TransactWriteItemsOutputTransformInput() { return true; }
  public Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItemsOutput dtor_sdkOutput() {
    return this._sdkOutput;
  }
  public Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItemsInput dtor_originalInput() {
    return this._originalInput;
  }
}
