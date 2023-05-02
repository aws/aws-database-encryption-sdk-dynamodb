// Class EncryptItemOutput
// Dafny class EncryptItemOutput compiled into Java
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
public class EncryptItemOutput {
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _encryptedItem;
  public Wrappers_Compile.Option<ParsedHeader> _parsedHeader;
  public EncryptItemOutput (dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> encryptedItem, Wrappers_Compile.Option<ParsedHeader> parsedHeader) {
    this._encryptedItem = encryptedItem;
    this._parsedHeader = parsedHeader;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    EncryptItemOutput o = (EncryptItemOutput)other;
    return true && java.util.Objects.equals(this._encryptedItem, o._encryptedItem) && java.util.Objects.equals(this._parsedHeader, o._parsedHeader);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._encryptedItem);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._parsedHeader);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types_Compile.EncryptItemOutput.EncryptItemOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._encryptedItem));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._parsedHeader));
    s.append(")");
    return s.toString();
  }

  private static final EncryptItemOutput theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.EncryptItemOutput.create(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> empty(), Wrappers_Compile.Option.<ParsedHeader>Default());
  public static EncryptItemOutput Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<EncryptItemOutput> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(EncryptItemOutput.class, () -> Default());
  public static dafny.TypeDescriptor<EncryptItemOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<EncryptItemOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static EncryptItemOutput create(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> encryptedItem, Wrappers_Compile.Option<ParsedHeader> parsedHeader) {
    return new EncryptItemOutput(encryptedItem, parsedHeader);
  }
  public static EncryptItemOutput create_EncryptItemOutput(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> encryptedItem, Wrappers_Compile.Option<ParsedHeader> parsedHeader) {
    return create(encryptedItem, parsedHeader);
  }
  public boolean is_EncryptItemOutput() { return true; }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> dtor_encryptedItem() {
    return this._encryptedItem;
  }
  public Wrappers_Compile.Option<ParsedHeader> dtor_parsedHeader() {
    return this._parsedHeader;
  }
}
