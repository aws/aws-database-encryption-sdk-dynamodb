// Class UpdateItemInputTransformInput
// Dafny class UpdateItemInputTransformInput compiled into Java
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
public class UpdateItemInputTransformInput {
  public Dafny.Com.Amazonaws.Dynamodb.Types.UpdateItemInput _sdkInput;
  public UpdateItemInputTransformInput (Dafny.Com.Amazonaws.Dynamodb.Types.UpdateItemInput sdkInput) {
    this._sdkInput = sdkInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    UpdateItemInputTransformInput o = (UpdateItemInputTransformInput)other;
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
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types_Compile.UpdateItemInputTransformInput.UpdateItemInputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkInput));
    s.append(")");
    return s.toString();
  }

  private static final UpdateItemInputTransformInput theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateItemInputTransformInput.create(Dafny.Com.Amazonaws.Dynamodb.Types.UpdateItemInput.Default());
  public static UpdateItemInputTransformInput Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<UpdateItemInputTransformInput> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(UpdateItemInputTransformInput.class, () -> Default());
  public static dafny.TypeDescriptor<UpdateItemInputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<UpdateItemInputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static UpdateItemInputTransformInput create(Dafny.Com.Amazonaws.Dynamodb.Types.UpdateItemInput sdkInput) {
    return new UpdateItemInputTransformInput(sdkInput);
  }
  public static UpdateItemInputTransformInput create_UpdateItemInputTransformInput(Dafny.Com.Amazonaws.Dynamodb.Types.UpdateItemInput sdkInput) {
    return create(sdkInput);
  }
  public boolean is_UpdateItemInputTransformInput() { return true; }
  public Dafny.Com.Amazonaws.Dynamodb.Types.UpdateItemInput dtor_sdkInput() {
    return this._sdkInput;
  }
}
