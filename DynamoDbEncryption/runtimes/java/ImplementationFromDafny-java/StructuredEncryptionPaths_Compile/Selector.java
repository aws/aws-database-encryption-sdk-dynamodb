// Class Selector
// Dafny class Selector compiled into Java
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
public abstract class Selector {
  public Selector() { }

  private static final Selector theDefault = StructuredEncryptionPaths_Compile.Selector.create_List(0L);
  public static Selector Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<Selector> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(Selector.class, () -> Default());
  public static dafny.TypeDescriptor<Selector> _typeDescriptor() {
    return (dafny.TypeDescriptor<Selector>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static Selector create_List(long pos) {
    return new Selector_List(pos);
  }
  public static Selector create_Map(dafny.DafnySequence<? extends Character> key) {
    return new Selector_Map(key);
  }
  public boolean is_List() { return this instanceof Selector_List; }
  public boolean is_Map() { return this instanceof Selector_Map; }
  public long dtor_pos() {
    Selector d = this;
    return ((Selector_List)d)._pos;
  }
  public dafny.DafnySequence<? extends Character> dtor_key() {
    Selector d = this;
    return ((Selector_Map)d)._key;
  }
}
