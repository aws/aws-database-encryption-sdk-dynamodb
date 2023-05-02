// Class Config
// Dafny class Config compiled into Java
package AwsCryptographyDynamoDbEncryptionOperations_Compile;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.*;
import DynamoDbEncryptionUtil_Compile.*;
import DynamoDbNormalizeNumber_Compile.*;
import DynamoToStruct_Compile.*;
import DynamoDbEncryptionBranchKeyIdSupplier_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class Config {
  public Config () {
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    Config o = (Config)other;
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
    s.append("AwsCryptographyDynamoDbEncryptionOperations_Compile.Config.Config");
    return s.toString();
  }

  private static final Config theDefault = AwsCryptographyDynamoDbEncryptionOperations_Compile.Config.create();
  public static Config Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<Config> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(Config.class, () -> Default());
  public static dafny.TypeDescriptor<Config> _typeDescriptor() {
    return (dafny.TypeDescriptor<Config>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static Config create() {
    return new Config();
  }
  public static Config create_Config() {
    return create();
  }
  public boolean is_Config() { return true; }
  public static java.util.ArrayList<Config> AllSingletonConstructors() {
    java.util.ArrayList<Config> singleton_iterator = new java.util.ArrayList<>();
    singleton_iterator.add(new Config());
    return singleton_iterator;
  }
}
