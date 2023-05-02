// Class ConstructorPart
// Dafny class ConstructorPart compiled into Java
package CompoundBeacon_Compile;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class ConstructorPart {
  public BeaconPart _part;
  public boolean _required;
  public ConstructorPart (BeaconPart part, boolean required) {
    this._part = part;
    this._required = required;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    ConstructorPart o = (ConstructorPart)other;
    return true && java.util.Objects.equals(this._part, o._part) && this._required == o._required;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._part);
    hash = ((hash << 5) + hash) + Boolean.hashCode(this._required);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("CompoundBeacon_Compile.ConstructorPart.ConstructorPart");
    s.append("(");
    s.append(dafny.Helpers.toString(this._part));
    s.append(", ");
    s.append(this._required);
    s.append(")");
    return s.toString();
  }

  private static final ConstructorPart theDefault = CompoundBeacon_Compile.ConstructorPart.create(BeaconPart.Default(), false);
  public static ConstructorPart Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<ConstructorPart> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(ConstructorPart.class, () -> Default());
  public static dafny.TypeDescriptor<ConstructorPart> _typeDescriptor() {
    return (dafny.TypeDescriptor<ConstructorPart>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static ConstructorPart create(BeaconPart part, boolean required) {
    return new ConstructorPart(part, required);
  }
  public static ConstructorPart create_ConstructorPart(BeaconPart part, boolean required) {
    return create(part, required);
  }
  public boolean is_ConstructorPart() { return true; }
  public BeaconPart dtor_part() {
    return this._part;
  }
  public boolean dtor_required() {
    return this._required;
  }
}
