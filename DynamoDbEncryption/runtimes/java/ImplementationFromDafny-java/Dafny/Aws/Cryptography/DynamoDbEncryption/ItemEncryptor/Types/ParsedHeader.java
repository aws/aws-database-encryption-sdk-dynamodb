// Class ParsedHeader
// Dafny class ParsedHeader compiled into Java
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
public class ParsedHeader {
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> _attributeActions;
  public Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId _algorithmSuiteId;
  public dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey> _encryptedDataKeys;
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _storedEncryptionContext;
  public ParsedHeader (dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> attributeActions, Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId algorithmSuiteId, dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey> encryptedDataKeys, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> storedEncryptionContext) {
    this._attributeActions = attributeActions;
    this._algorithmSuiteId = algorithmSuiteId;
    this._encryptedDataKeys = encryptedDataKeys;
    this._storedEncryptionContext = storedEncryptionContext;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    ParsedHeader o = (ParsedHeader)other;
    return true && java.util.Objects.equals(this._attributeActions, o._attributeActions) && java.util.Objects.equals(this._algorithmSuiteId, o._algorithmSuiteId) && java.util.Objects.equals(this._encryptedDataKeys, o._encryptedDataKeys) && java.util.Objects.equals(this._storedEncryptionContext, o._storedEncryptionContext);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._attributeActions);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._algorithmSuiteId);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._encryptedDataKeys);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._storedEncryptionContext);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types_Compile.ParsedHeader.ParsedHeader");
    s.append("(");
    s.append(dafny.Helpers.toString(this._attributeActions));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._algorithmSuiteId));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._encryptedDataKeys));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._storedEncryptionContext));
    s.append(")");
    return s.toString();
  }

  private static final ParsedHeader theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.ParsedHeader.create(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> empty(), Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId.Default(), dafny.DafnySequence.<Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey> empty(Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey._typeDescriptor()), dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>,dafny.DafnySequence<? extends java.lang.Byte>> empty());
  public static ParsedHeader Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<ParsedHeader> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(ParsedHeader.class, () -> Default());
  public static dafny.TypeDescriptor<ParsedHeader> _typeDescriptor() {
    return (dafny.TypeDescriptor<ParsedHeader>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static ParsedHeader create(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> attributeActions, Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId algorithmSuiteId, dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey> encryptedDataKeys, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> storedEncryptionContext) {
    return new ParsedHeader(attributeActions, algorithmSuiteId, encryptedDataKeys, storedEncryptionContext);
  }
  public static ParsedHeader create_ParsedHeader(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> attributeActions, Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId algorithmSuiteId, dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey> encryptedDataKeys, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> storedEncryptionContext) {
    return create(attributeActions, algorithmSuiteId, encryptedDataKeys, storedEncryptionContext);
  }
  public boolean is_ParsedHeader() { return true; }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoAction> dtor_attributeActions() {
    return this._attributeActions;
  }
  public Dafny.Aws.Cryptography.MaterialProviders.Types.DBEAlgorithmSuiteId dtor_algorithmSuiteId() {
    return this._algorithmSuiteId;
  }
  public dafny.DafnySequence<? extends Dafny.Aws.Cryptography.MaterialProviders.Types.EncryptedDataKey> dtor_encryptedDataKeys() {
    return this._encryptedDataKeys;
  }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> dtor_storedEncryptionContext() {
    return this._storedEncryptionContext;
  }
}
