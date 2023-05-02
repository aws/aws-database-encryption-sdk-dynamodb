// Class Upper
// Dafny class Upper compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class Upper {
  public Upper () {
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    Upper o = (Upper)other;
    return true;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Types_Compile.Upper.Upper");
    return s.toString();
  }

  private static final Upper theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Upper.create();
  public static Upper Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<Upper> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(Upper.class, () -> Default());
  public static dafny.TypeDescriptor<Upper> _typeDescriptor() {
    return (dafny.TypeDescriptor<Upper>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static Upper create() {
    return new Upper();
  }
  public static Upper create_Upper() {
    return create();
  }
  public boolean is_Upper() { return true; }
  public static java.util.ArrayList<Upper> AllSingletonConstructors() {
    java.util.ArrayList<Upper> singleton_iterator = new java.util.ArrayList<>();
    singleton_iterator.add(new Upper());
    return singleton_iterator;
  }
}
