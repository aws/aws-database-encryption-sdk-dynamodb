// Class UpdateTableInputTransformInput
// Dafny class UpdateTableInputTransformInput compiled into Java
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
public class UpdateTableInputTransformInput {
  public Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput _sdkInput;
  public UpdateTableInputTransformInput (Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput sdkInput) {
    this._sdkInput = sdkInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    UpdateTableInputTransformInput o = (UpdateTableInputTransformInput)other;
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
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types_Compile.UpdateTableInputTransformInput.UpdateTableInputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkInput));
    s.append(")");
    return s.toString();
  }

  private static final UpdateTableInputTransformInput theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.UpdateTableInputTransformInput.create(Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput.Default());
  public static UpdateTableInputTransformInput Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<UpdateTableInputTransformInput> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(UpdateTableInputTransformInput.class, () -> Default());
  public static dafny.TypeDescriptor<UpdateTableInputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<UpdateTableInputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static UpdateTableInputTransformInput create(Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput sdkInput) {
    return new UpdateTableInputTransformInput(sdkInput);
  }
  public static UpdateTableInputTransformInput create_UpdateTableInputTransformInput(Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput sdkInput) {
    return create(sdkInput);
  }
  public boolean is_UpdateTableInputTransformInput() { return true; }
  public Dafny.Com.Amazonaws.Dynamodb.Types.UpdateTableInput dtor_sdkInput() {
    return this._sdkInput;
  }
}
