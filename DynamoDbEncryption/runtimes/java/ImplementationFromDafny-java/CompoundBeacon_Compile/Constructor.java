// Class Constructor
// Dafny class Constructor compiled into Java
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
public class Constructor {
  public dafny.DafnySequence<? extends ConstructorPart> _parts;
  public Constructor (dafny.DafnySequence<? extends ConstructorPart> parts) {
    this._parts = parts;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    Constructor o = (Constructor)other;
    return true && java.util.Objects.equals(this._parts, o._parts);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._parts);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("CompoundBeacon_Compile.Constructor.Constructor");
    s.append("(");
    s.append(dafny.Helpers.toString(this._parts));
    s.append(")");
    return s.toString();
  }

  private static final Constructor theDefault = CompoundBeacon_Compile.Constructor.create(dafny.DafnySequence.<ConstructorPart> empty(ConstructorPart._typeDescriptor()));
  public static Constructor Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<Constructor> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(Constructor.class, () -> Default());
  public static dafny.TypeDescriptor<Constructor> _typeDescriptor() {
    return (dafny.TypeDescriptor<Constructor>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static Constructor create(dafny.DafnySequence<? extends ConstructorPart> parts) {
    return new Constructor(parts);
  }
  public static Constructor create_Constructor(dafny.DafnySequence<? extends ConstructorPart> parts) {
    return create(parts);
  }
  public boolean is_Constructor() { return true; }
  public dafny.DafnySequence<? extends ConstructorPart> dtor_parts() {
    return this._parts;
  }
  public dafny.DafnySet<? extends BeaconPart> getReqParts() {
    return ((dafny.Function0<dafny.DafnySet<? extends BeaconPart>>)(() -> {
      java.util.ArrayList<BeaconPart> _coll24 = new java.util.ArrayList<>();
      for (ConstructorPart _compr_24_boxed0 : ((this).dtor_parts()).Elements()) {
        ConstructorPart _compr_24 = ((ConstructorPart)(java.lang.Object)(_compr_24_boxed0));
        if (true) {
          ConstructorPart _897_k = (ConstructorPart)_compr_24;
          if ((((this).dtor_parts()).contains(_897_k)) && ((_897_k).dtor_required())) {
            _coll24.add((_897_k).dtor_part());
          }
        }
      }
      return new dafny.DafnySet<BeaconPart>(_coll24);
    })).apply();
  }
}
