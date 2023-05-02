// Class KeyLocation
// Dafny class KeyLocation compiled into Java
package SearchableEncryptionInfo_Compile;

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

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class KeyLocation {
  public KeyLocation() { }

  private static final KeyLocation theDefault = SearchableEncryptionInfo_Compile.KeyLocation.create_LiteralLoc(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,dafny.DafnySequence<? extends java.lang.Byte>> empty());
  public static KeyLocation Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<KeyLocation> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(KeyLocation.class, () -> Default());
  public static dafny.TypeDescriptor<KeyLocation> _typeDescriptor() {
    return (dafny.TypeDescriptor<KeyLocation>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static KeyLocation create_LiteralLoc(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> keys) {
    return new KeyLocation_LiteralLoc(keys);
  }
  public static KeyLocation create_SingleLoc(dafny.DafnySequence<? extends Character> keyId) {
    return new KeyLocation_SingleLoc(keyId);
  }
  public static KeyLocation create_MultiLoc(dafny.DafnySequence<? extends Character> keyName, boolean deleteKey) {
    return new KeyLocation_MultiLoc(keyName, deleteKey);
  }
  public boolean is_LiteralLoc() { return this instanceof KeyLocation_LiteralLoc; }
  public boolean is_SingleLoc() { return this instanceof KeyLocation_SingleLoc; }
  public boolean is_MultiLoc() { return this instanceof KeyLocation_MultiLoc; }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> dtor_keys() {
    KeyLocation d = this;
    return ((KeyLocation_LiteralLoc)d)._keys;
  }
  public dafny.DafnySequence<? extends Character> dtor_keyId() {
    KeyLocation d = this;
    return ((KeyLocation_SingleLoc)d)._keyId;
  }
  public dafny.DafnySequence<? extends Character> dtor_keyName() {
    KeyLocation d = this;
    return ((KeyLocation_MultiLoc)d)._keyName;
  }
  public boolean dtor_deleteKey() {
    KeyLocation d = this;
    return ((KeyLocation_MultiLoc)d)._deleteKey;
  }
}
