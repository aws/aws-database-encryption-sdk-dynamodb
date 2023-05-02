// Class TerminalLocation
// Dafny class TerminalLocation compiled into Java
package StructuredEncryptionPaths_Compile;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class TerminalLocation {
  public dafny.DafnySequence<? extends Selector> _parts;
  public TerminalLocation (dafny.DafnySequence<? extends Selector> parts) {
    this._parts = parts;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    TerminalLocation o = (TerminalLocation)other;
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
    s.append("StructuredEncryptionPaths_Compile.TerminalLocation.TerminalLocation");
    s.append("(");
    s.append(dafny.Helpers.toString(this._parts));
    s.append(")");
    return s.toString();
  }

  private static final TerminalLocation theDefault = StructuredEncryptionPaths_Compile.TerminalLocation.create(dafny.DafnySequence.<Selector> empty(Selector._typeDescriptor()));
  public static TerminalLocation Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<TerminalLocation> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(TerminalLocation.class, () -> Default());
  public static dafny.TypeDescriptor<TerminalLocation> _typeDescriptor() {
    return (dafny.TypeDescriptor<TerminalLocation>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static TerminalLocation create(dafny.DafnySequence<? extends Selector> parts) {
    return new TerminalLocation(parts);
  }
  public static TerminalLocation create_TerminalLocation(dafny.DafnySequence<? extends Selector> parts) {
    return create(parts);
  }
  public boolean is_TerminalLocation() { return true; }
  public dafny.DafnySequence<? extends Selector> dtor_parts() {
    return this._parts;
  }
  public dafny.DafnySequence<? extends java.lang.Byte> canonicalPath(dafny.DafnySequence<? extends Character> table) {
    dafny.DafnySequence<? extends java.lang.Byte> _303_tableName = (UTF8.__default.Encode(table)).dtor_value();
    dafny.DafnySequence<? extends java.lang.Byte> _304_depth = StandardLibrary_mUInt_Compile.__default.UInt64ToSeq(((this).dtor_parts()).cardinalityInt());
    dafny.DafnySequence<? extends java.lang.Byte> _305_path = __default.MakeCanonicalPath((this).dtor_parts());
    return dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(_303_tableName, _304_depth), _305_path);
  }
  public boolean isRoot() {
    return java.util.Objects.equals(java.math.BigInteger.valueOf(((this).dtor_parts()).length()), java.math.BigInteger.ONE);
  }
  public dafny.DafnySequence<? extends Character> getRoot() {
    return (((Selector)(java.lang.Object)(((this).dtor_parts()).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO)))))).dtor_key();
  }
}
