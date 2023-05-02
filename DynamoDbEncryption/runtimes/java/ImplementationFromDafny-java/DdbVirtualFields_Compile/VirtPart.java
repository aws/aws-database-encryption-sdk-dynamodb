// Class VirtPart
// Dafny class VirtPart compiled into Java
package DdbVirtualFields_Compile;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class VirtPart {
  public dafny.DafnySequence<? extends TermLoc_Compile.Selector> _loc;
  public dafny.DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform> _trans;
  public VirtPart (dafny.DafnySequence<? extends TermLoc_Compile.Selector> loc, dafny.DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform> trans) {
    this._loc = loc;
    this._trans = trans;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    VirtPart o = (VirtPart)other;
    return true && java.util.Objects.equals(this._loc, o._loc) && java.util.Objects.equals(this._trans, o._trans);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._loc);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._trans);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("DdbVirtualFields_Compile.VirtPart.VirtPart");
    s.append("(");
    s.append(dafny.Helpers.toString(this._loc));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._trans));
    s.append(")");
    return s.toString();
  }

  private static final VirtPart theDefault = DdbVirtualFields_Compile.VirtPart.create(dafny.DafnySequence.<TermLoc_Compile.Selector> empty(TermLoc_Compile.Selector._typeDescriptor()), dafny.DafnySequence.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform> empty(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform._typeDescriptor()));
  public static VirtPart Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<VirtPart> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(VirtPart.class, () -> Default());
  public static dafny.TypeDescriptor<VirtPart> _typeDescriptor() {
    return (dafny.TypeDescriptor<VirtPart>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static VirtPart create(dafny.DafnySequence<? extends TermLoc_Compile.Selector> loc, dafny.DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform> trans) {
    return new VirtPart(loc, trans);
  }
  public static VirtPart create_VirtPart(dafny.DafnySequence<? extends TermLoc_Compile.Selector> loc, dafny.DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform> trans) {
    return create(loc, trans);
  }
  public boolean is_VirtPart() { return true; }
  public dafny.DafnySequence<? extends TermLoc_Compile.Selector> dtor_loc() {
    return this._loc;
  }
  public dafny.DafnySequence<? extends Dafny.Aws.Cryptography.DynamoDbEncryption.Types.VirtualTransform> dtor_trans() {
    return this._trans;
  }
}
