// Class Config
// Dafny class Config compiled into Java
package AwsCryptographyStructuredEncryptionOperations_Compile;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class Config {
  public Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient _primitives;
  public Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient _materialProviders;
  public Config (Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient primitives, Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient materialProviders) {
    this._primitives = primitives;
    this._materialProviders = materialProviders;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    Config o = (Config)other;
    return true && this._primitives == o._primitives && this._materialProviders == o._materialProviders;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._primitives);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._materialProviders);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyStructuredEncryptionOperations_Compile.Config.Config");
    s.append("(");
    s.append(dafny.Helpers.toString(this._primitives));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._materialProviders));
    s.append(")");
    return s.toString();
  }

  private static final Config theDefault = AwsCryptographyStructuredEncryptionOperations_Compile.Config.create(null, null);
  public static Config Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<Config> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(Config.class, () -> Default());
  public static dafny.TypeDescriptor<Config> _typeDescriptor() {
    return (dafny.TypeDescriptor<Config>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static Config create(Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient primitives, Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient materialProviders) {
    return new Config(primitives, materialProviders);
  }
  public static Config create_Config(Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient primitives, Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient materialProviders) {
    return create(primitives, materialProviders);
  }
  public boolean is_Config() { return true; }
  public Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient dtor_primitives() {
    return this._primitives;
  }
  public Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient dtor_materialProviders() {
    return this._materialProviders;
  }
}
