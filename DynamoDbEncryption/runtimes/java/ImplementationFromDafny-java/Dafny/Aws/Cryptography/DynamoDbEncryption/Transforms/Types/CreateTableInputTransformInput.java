// Class CreateTableInputTransformInput
// Dafny class CreateTableInputTransformInput compiled into Java
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
public class CreateTableInputTransformInput {
  public Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput _sdkInput;
  public CreateTableInputTransformInput (Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput sdkInput) {
    this._sdkInput = sdkInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    CreateTableInputTransformInput o = (CreateTableInputTransformInput)other;
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
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types_Compile.CreateTableInputTransformInput.CreateTableInputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkInput));
    s.append(")");
    return s.toString();
  }

  private static final CreateTableInputTransformInput theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.CreateTableInputTransformInput.create(Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput.Default());
  public static CreateTableInputTransformInput Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<CreateTableInputTransformInput> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(CreateTableInputTransformInput.class, () -> Default());
  public static dafny.TypeDescriptor<CreateTableInputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<CreateTableInputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static CreateTableInputTransformInput create(Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput sdkInput) {
    return new CreateTableInputTransformInput(sdkInput);
  }
  public static CreateTableInputTransformInput create_CreateTableInputTransformInput(Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput sdkInput) {
    return create(sdkInput);
  }
  public boolean is_CreateTableInputTransformInput() { return true; }
  public Dafny.Com.Amazonaws.Dynamodb.Types.CreateTableInput dtor_sdkInput() {
    return this._sdkInput;
  }
}
