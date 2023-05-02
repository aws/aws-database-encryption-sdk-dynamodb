// Class DecryptItemOutput
// Dafny class DecryptItemOutput compiled into Java
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
public class DecryptItemOutput {
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _plaintextItem;
  public Wrappers_Compile.Option<ParsedHeader> _parsedHeader;
  public DecryptItemOutput (dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> plaintextItem, Wrappers_Compile.Option<ParsedHeader> parsedHeader) {
    this._plaintextItem = plaintextItem;
    this._parsedHeader = parsedHeader;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    DecryptItemOutput o = (DecryptItemOutput)other;
    return true && java.util.Objects.equals(this._plaintextItem, o._plaintextItem) && java.util.Objects.equals(this._parsedHeader, o._parsedHeader);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._plaintextItem);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._parsedHeader);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types_Compile.DecryptItemOutput.DecryptItemOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._plaintextItem));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._parsedHeader));
    s.append(")");
    return s.toString();
  }

  private static final DecryptItemOutput theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.DecryptItemOutput.create(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> empty(), Wrappers_Compile.Option.<ParsedHeader>Default());
  public static DecryptItemOutput Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<DecryptItemOutput> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(DecryptItemOutput.class, () -> Default());
  public static dafny.TypeDescriptor<DecryptItemOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<DecryptItemOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static DecryptItemOutput create(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> plaintextItem, Wrappers_Compile.Option<ParsedHeader> parsedHeader) {
    return new DecryptItemOutput(plaintextItem, parsedHeader);
  }
  public static DecryptItemOutput create_DecryptItemOutput(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> plaintextItem, Wrappers_Compile.Option<ParsedHeader> parsedHeader) {
    return create(plaintextItem, parsedHeader);
  }
  public boolean is_DecryptItemOutput() { return true; }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> dtor_plaintextItem() {
    return this._plaintextItem;
  }
  public Wrappers_Compile.Option<ParsedHeader> dtor_parsedHeader() {
    return this._parsedHeader;
  }
}
