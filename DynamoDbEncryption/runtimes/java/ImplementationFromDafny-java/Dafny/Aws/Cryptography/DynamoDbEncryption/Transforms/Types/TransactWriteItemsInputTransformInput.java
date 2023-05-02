// Class TransactWriteItemsInputTransformInput
// Dafny class TransactWriteItemsInputTransformInput compiled into Java
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
public class TransactWriteItemsInputTransformInput {
  public Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItemsInput _sdkInput;
  public TransactWriteItemsInputTransformInput (Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItemsInput sdkInput) {
    this._sdkInput = sdkInput;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    TransactWriteItemsInputTransformInput o = (TransactWriteItemsInputTransformInput)other;
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
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types_Compile.TransactWriteItemsInputTransformInput.TransactWriteItemsInputTransformInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._sdkInput));
    s.append(")");
    return s.toString();
  }

  private static final TransactWriteItemsInputTransformInput theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.TransactWriteItemsInputTransformInput.create(Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItemsInput.Default());
  public static TransactWriteItemsInputTransformInput Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<TransactWriteItemsInputTransformInput> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(TransactWriteItemsInputTransformInput.class, () -> Default());
  public static dafny.TypeDescriptor<TransactWriteItemsInputTransformInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<TransactWriteItemsInputTransformInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static TransactWriteItemsInputTransformInput create(Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItemsInput sdkInput) {
    return new TransactWriteItemsInputTransformInput(sdkInput);
  }
  public static TransactWriteItemsInputTransformInput create_TransactWriteItemsInputTransformInput(Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItemsInput sdkInput) {
    return create(sdkInput);
  }
  public boolean is_TransactWriteItemsInputTransformInput() { return true; }
  public Dafny.Com.Amazonaws.Dynamodb.Types.TransactWriteItemsInput dtor_sdkInput() {
    return this._sdkInput;
  }
}
