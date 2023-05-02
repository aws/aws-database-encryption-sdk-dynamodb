// Class TransactGetItemsInputTransformInput
// Dafny class TransactGetItemsInputTransformInput compiled into Java
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
public class TransactGetItemsInputTransformInput {
  public Dafny.Com.Amazonaws.Dynamodb.Types.TransactGetItemsInput _sdkInput;
  public TransactGetItemsInputTransformInput (Dafny.Com.Amazonaws.Dynamodb.Types.TransactGetItemsInput sdkInput) {
    this._sdkInput = sdkInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    TransactGetItemsInputTransformInput o = (TransactGetItemsInputTransformInput)other;
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
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types_Compile.TransactGetItemsInputTransformInput.TransactGetItemsInputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkInput));
    s.append(")");
    return s.toString();
  }

  private static final TransactGetItemsInputTransformInput theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactGetItemsInputTransformInput.create(Dafny.Com.Amazonaws.Dynamodb.Types.TransactGetItemsInput.Default());
  public static TransactGetItemsInputTransformInput Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<TransactGetItemsInputTransformInput> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(TransactGetItemsInputTransformInput.class, () -> Default());
  public static dafny.TypeDescriptor<TransactGetItemsInputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<TransactGetItemsInputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static TransactGetItemsInputTransformInput create(Dafny.Com.Amazonaws.Dynamodb.Types.TransactGetItemsInput sdkInput) {
    return new TransactGetItemsInputTransformInput(sdkInput);
  }
  public static TransactGetItemsInputTransformInput create_TransactGetItemsInputTransformInput(Dafny.Com.Amazonaws.Dynamodb.Types.TransactGetItemsInput sdkInput) {
    return create(sdkInput);
  }
  public boolean is_TransactGetItemsInputTransformInput() { return true; }
  public Dafny.Com.Amazonaws.Dynamodb.Types.TransactGetItemsInput dtor_sdkInput() {
    return this._sdkInput;
  }
}
