// Class PutItemOutputTransformInput
// Dafny class PutItemOutputTransformInput compiled into Java
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
public class PutItemOutputTransformInput {
  public Dafny.Com.Amazonaws.Dynamodb.Types.PutItemOutput _sdkOutput;
  public Dafny.Com.Amazonaws.Dynamodb.Types.PutItemInput _originalInput;
  public PutItemOutputTransformInput (Dafny.Com.Amazonaws.Dynamodb.Types.PutItemOutput sdkOutput, Dafny.Com.Amazonaws.Dynamodb.Types.PutItemInput originalInput) {
    this._sdkOutput = sdkOutput;
    this._originalInput = originalInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    PutItemOutputTransformInput o = (PutItemOutputTransformInput)other;
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
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types_Compile.PutItemOutputTransformInput.PutItemOutputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkOutput));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._originalInput));
    s.append(")");
    return s.toString();
  }

  private static final PutItemOutputTransformInput theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.PutItemOutputTransformInput.create(Dafny.Com.Amazonaws.Dynamodb.Types.PutItemOutput.Default(), Dafny.Com.Amazonaws.Dynamodb.Types.PutItemInput.Default());
  public static PutItemOutputTransformInput Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<PutItemOutputTransformInput> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(PutItemOutputTransformInput.class, () -> Default());
  public static dafny.TypeDescriptor<PutItemOutputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<PutItemOutputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static PutItemOutputTransformInput create(Dafny.Com.Amazonaws.Dynamodb.Types.PutItemOutput sdkOutput, Dafny.Com.Amazonaws.Dynamodb.Types.PutItemInput originalInput) {
    return new PutItemOutputTransformInput(sdkOutput, originalInput);
  }
  public static PutItemOutputTransformInput create_PutItemOutputTransformInput(Dafny.Com.Amazonaws.Dynamodb.Types.PutItemOutput sdkOutput, Dafny.Com.Amazonaws.Dynamodb.Types.PutItemInput originalInput) {
    return create(sdkOutput, originalInput);
  }
  public boolean is_PutItemOutputTransformInput() { return true; }
  public Dafny.Com.Amazonaws.Dynamodb.Types.PutItemOutput dtor_sdkOutput() {
    return this._sdkOutput;
  }
  public Dafny.Com.Amazonaws.Dynamodb.Types.PutItemInput dtor_originalInput() {
    return this._originalInput;
  }
}
