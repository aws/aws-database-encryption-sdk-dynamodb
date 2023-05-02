// Class DecryptItemInput
// Dafny class DecryptItemInput compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class DecryptItemInput {
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _encryptedItem;
  public DecryptItemInput (dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> encryptedItem) {
    this._encryptedItem = encryptedItem;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    DecryptItemInput o = (DecryptItemInput)other;
    return true && java.util.Objects.equals(this._encryptedItem, o._encryptedItem);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._encryptedItem);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types_Compile.DecryptItemInput.DecryptItemInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._encryptedItem));
    s.append(")");
    return s.toString();
  }

  private static final DecryptItemInput theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemInput.create(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> empty());
  public static DecryptItemInput Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<DecryptItemInput> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(DecryptItemInput.class, () -> Default());
  public static dafny.TypeDescriptor<DecryptItemInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<DecryptItemInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static DecryptItemInput create(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> encryptedItem) {
    return new DecryptItemInput(encryptedItem);
  }
  public static DecryptItemInput create_DecryptItemInput(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> encryptedItem) {
    return create(encryptedItem);
  }
  public boolean is_DecryptItemInput() { return true; }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> dtor_encryptedItem() {
    return this._encryptedItem;
  }
}
