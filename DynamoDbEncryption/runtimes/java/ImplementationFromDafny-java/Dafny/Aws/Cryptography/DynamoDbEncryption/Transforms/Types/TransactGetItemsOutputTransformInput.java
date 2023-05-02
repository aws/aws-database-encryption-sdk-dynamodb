// Class TransactGetItemsOutputTransformInput
// Dafny class TransactGetItemsOutputTransformInput compiled into Java
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
public class TransactGetItemsOutputTransformInput {
  public Dafny.Com.Amazonaws.Dynamodb.Types.TransactGetItemsOutput _sdkOutput;
  public Dafny.Com.Amazonaws.Dynamodb.Types.TransactGetItemsInput _originalInput;
  public TransactGetItemsOutputTransformInput (Dafny.Com.Amazonaws.Dynamodb.Types.TransactGetItemsOutput sdkOutput, Dafny.Com.Amazonaws.Dynamodb.Types.TransactGetItemsInput originalInput) {
    this._sdkOutput = sdkOutput;
    this._originalInput = originalInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    TransactGetItemsOutputTransformInput o = (TransactGetItemsOutputTransformInput)other;
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
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types_Compile.TransactGetItemsOutputTransformInput.TransactGetItemsOutputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkOutput));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._originalInput));
    s.append(")");
    return s.toString();
  }

  private static final TransactGetItemsOutputTransformInput theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactGetItemsOutputTransformInput.create(Dafny.Com.Amazonaws.Dynamodb.Types.TransactGetItemsOutput.Default(), Dafny.Com.Amazonaws.Dynamodb.Types.TransactGetItemsInput.Default());
  public static TransactGetItemsOutputTransformInput Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<TransactGetItemsOutputTransformInput> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(TransactGetItemsOutputTransformInput.class, () -> Default());
  public static dafny.TypeDescriptor<TransactGetItemsOutputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<TransactGetItemsOutputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static TransactGetItemsOutputTransformInput create(Dafny.Com.Amazonaws.Dynamodb.Types.TransactGetItemsOutput sdkOutput, Dafny.Com.Amazonaws.Dynamodb.Types.TransactGetItemsInput originalInput) {
    return new TransactGetItemsOutputTransformInput(sdkOutput, originalInput);
  }
  public static TransactGetItemsOutputTransformInput create_TransactGetItemsOutputTransformInput(Dafny.Com.Amazonaws.Dynamodb.Types.TransactGetItemsOutput sdkOutput, Dafny.Com.Amazonaws.Dynamodb.Types.TransactGetItemsInput originalInput) {
    return create(sdkOutput, originalInput);
  }
  public boolean is_TransactGetItemsOutputTransformInput() { return true; }
  public Dafny.Com.Amazonaws.Dynamodb.Types.TransactGetItemsOutput dtor_sdkOutput() {
    return this._sdkOutput;
  }
  public Dafny.Com.Amazonaws.Dynamodb.Types.TransactGetItemsInput dtor_originalInput() {
    return this._originalInput;
  }
}
