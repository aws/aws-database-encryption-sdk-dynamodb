// Class BeaconType
// Dafny class BeaconType compiled into Java
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
public abstract class BeaconType {
  public BeaconType() { }

  private static final BeaconType theDefault = SearchableEncryptionInfo_Compile.BeaconType.create_AnyBeacon();
  public static BeaconType Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<BeaconType> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(BeaconType.class, () -> Default());
  public static dafny.TypeDescriptor<BeaconType> _typeDescriptor() {
    return (dafny.TypeDescriptor<BeaconType>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static BeaconType create_AnyBeacon() {
    return new BeaconType_AnyBeacon();
  }
  public static BeaconType create_SignedBeacon() {
    return new BeaconType_SignedBeacon();
  }
  public static BeaconType create_EncryptedBeacon() {
    return new BeaconType_EncryptedBeacon();
  }
  public boolean is_AnyBeacon() { return this instanceof BeaconType_AnyBeacon; }
  public boolean is_SignedBeacon() { return this instanceof BeaconType_SignedBeacon; }
  public boolean is_EncryptedBeacon() { return this instanceof BeaconType_EncryptedBeacon; }
  public static java.util.ArrayList<BeaconType> AllSingletonConstructors() {
    java.util.ArrayList<BeaconType> singleton_iterator = new java.util.ArrayList<>();
    singleton_iterator.add(new BeaconType_AnyBeacon());
    singleton_iterator.add(new BeaconType_SignedBeacon());
    singleton_iterator.add(new BeaconType_EncryptedBeacon());
    return singleton_iterator;
  }
}
