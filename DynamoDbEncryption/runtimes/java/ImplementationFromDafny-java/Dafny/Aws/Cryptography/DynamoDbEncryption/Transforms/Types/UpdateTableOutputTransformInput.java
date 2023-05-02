// Class UpdateTableOutputTransformInput
// Dafny class UpdateTableOutputTransformInput compiled into Java
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
public class UpdateTableOutputTransformInput {
  public Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableOutput _sdkOutput;
  public Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput _originalInput;
  public UpdateTableOutputTransformInput (Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableOutput sdkOutput, Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput originalInput) {
    this._sdkOutput = sdkOutput;
    this._originalInput = originalInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    UpdateTableOutputTransformInput o = (UpdateTableOutputTransformInput)other;
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
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types_Compile.UpdateTableOutputTransformInput.UpdateTableOutputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkOutput));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._originalInput));
    s.append(")");
    return s.toString();
  }

  private static final UpdateTableOutputTransformInput theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateTableOutputTransformInput.create(Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableOutput.Default(), Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput.Default());
  public static UpdateTableOutputTransformInput Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<UpdateTableOutputTransformInput> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(UpdateTableOutputTransformInput.class, () -> Default());
  public static dafny.TypeDescriptor<UpdateTableOutputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<UpdateTableOutputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static UpdateTableOutputTransformInput create(Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableOutput sdkOutput, Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput originalInput) {
    return new UpdateTableOutputTransformInput(sdkOutput, originalInput);
  }
  public static UpdateTableOutputTransformInput create_UpdateTableOutputTransformInput(Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableOutput sdkOutput, Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput originalInput) {
    return create(sdkOutput, originalInput);
  }
  public boolean is_UpdateTableOutputTransformInput() { return true; }
  public Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableOutput dtor_sdkOutput() {
    return this._sdkOutput;
  }
  public Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput dtor_originalInput() {
    return this._originalInput;
  }
}
