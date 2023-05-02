// Class CreateTableOutputTransformInput
// Dafny class CreateTableOutputTransformInput compiled into Java
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
public class CreateTableOutputTransformInput {
  public Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableOutput _sdkOutput;
  public Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput _originalInput;
  public CreateTableOutputTransformInput (Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableOutput sdkOutput, Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput originalInput) {
    this._sdkOutput = sdkOutput;
    this._originalInput = originalInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    CreateTableOutputTransformInput o = (CreateTableOutputTransformInput)other;
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
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types_Compile.CreateTableOutputTransformInput.CreateTableOutputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkOutput));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._originalInput));
    s.append(")");
    return s.toString();
  }

  private static final CreateTableOutputTransformInput theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.CreateTableOutputTransformInput.create(Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableOutput.Default(), Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput.Default());
  public static CreateTableOutputTransformInput Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<CreateTableOutputTransformInput> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(CreateTableOutputTransformInput.class, () -> Default());
  public static dafny.TypeDescriptor<CreateTableOutputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<CreateTableOutputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static CreateTableOutputTransformInput create(Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableOutput sdkOutput, Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput originalInput) {
    return new CreateTableOutputTransformInput(sdkOutput, originalInput);
  }
  public static CreateTableOutputTransformInput create_CreateTableOutputTransformInput(Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableOutput sdkOutput, Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput originalInput) {
    return create(sdkOutput, originalInput);
  }
  public boolean is_CreateTableOutputTransformInput() { return true; }
  public Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableOutput dtor_sdkOutput() {
    return this._sdkOutput;
  }
  public Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput dtor_originalInput() {
    return this._originalInput;
  }
}
