// Class Config
// Dafny class Config compiled into Java
package AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class Config {
  public software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient _primitives;
  public software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient _materialProviders;
  public Config (software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient primitives, software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient materialProviders) {
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
    s.append("AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations.Config.Config");
    s.append("(");
    s.append(dafny.Helpers.toString(this._primitives));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._materialProviders));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<Config> _TYPE = dafny.TypeDescriptor.<Config>referenceWithInitializer(Config.class, () -> Config.Default());
  public static dafny.TypeDescriptor<Config> _typeDescriptor() {
    return (dafny.TypeDescriptor<Config>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final Config theDefault = Config.create(null, null);
  public static Config Default() {
    return theDefault;
  }
  public static Config create(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient primitives, software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient materialProviders) {
    return new Config(primitives, materialProviders);
  }
  public static Config create_Config(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient primitives, software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient materialProviders) {
    return create(primitives, materialProviders);
  }
  public boolean is_Config() { return true; }
  public software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient dtor_primitives() {
    return this._primitives;
  }
  public software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient dtor_materialProviders() {
    return this._materialProviders;
  }
}
