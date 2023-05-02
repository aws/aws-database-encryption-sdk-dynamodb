// Class EqualityBeacon
// Dafny class EqualityBeacon compiled into Java
package DynamoDBFilterExpr_Compile;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class EqualityBeacon {
  public Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.Beacon> _beacon;
  public boolean _forEquality;
  public EqualityBeacon (Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.Beacon> beacon, boolean forEquality) {
    this._beacon = beacon;
    this._forEquality = forEquality;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    EqualityBeacon o = (EqualityBeacon)other;
    return true && java.util.Objects.equals(this._beacon, o._beacon) && this._forEquality == o._forEquality;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._beacon);
    hash = ((hash << 5) + hash) + Boolean.hashCode(this._forEquality);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("DynamoDBFilterExpr_Compile.EqualityBeacon.EqualityBeacon");
    s.append("(");
    s.append(dafny.Helpers.toString(this._beacon));
    s.append(", ");
    s.append(this._forEquality);
    s.append(")");
    return s.toString();
  }

  private static final EqualityBeacon theDefault = DynamoDBFilterExpr_Compile.EqualityBeacon.create(Wrappers_Compile.Option.<SearchableEncryptionInfo_Compile.Beacon>Default(), false);
  public static EqualityBeacon Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<EqualityBeacon> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(EqualityBeacon.class, () -> Default());
  public static dafny.TypeDescriptor<EqualityBeacon> _typeDescriptor() {
    return (dafny.TypeDescriptor<EqualityBeacon>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static EqualityBeacon create(Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.Beacon> beacon, boolean forEquality) {
    return new EqualityBeacon(beacon, forEquality);
  }
  public static EqualityBeacon create_EqualityBeacon(Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.Beacon> beacon, boolean forEquality) {
    return create(beacon, forEquality);
  }
  public boolean is_EqualityBeacon() { return true; }
  public Wrappers_Compile.Option<SearchableEncryptionInfo_Compile.Beacon> dtor_beacon() {
    return this._beacon;
  }
  public boolean dtor_forEquality() {
    return this._forEquality;
  }
}
