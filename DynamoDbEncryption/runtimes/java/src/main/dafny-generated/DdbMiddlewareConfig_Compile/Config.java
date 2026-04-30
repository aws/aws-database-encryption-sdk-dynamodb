// Class Config
// Dafny class Config compiled into Java
package DdbMiddlewareConfig_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class Config {
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends TableConfig> _tableEncryptionConfigs;
  public Config (dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends TableConfig> tableEncryptionConfigs) {
    this._tableEncryptionConfigs = tableEncryptionConfigs;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    Config o = (Config)other;
    return true && java.util.Objects.equals(this._tableEncryptionConfigs, o._tableEncryptionConfigs);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._tableEncryptionConfigs);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("DdbMiddlewareConfig.Config.Config");
    s.append("(");
    s.append(dafny.Helpers.toString(this._tableEncryptionConfigs));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<Config> _TYPE = dafny.TypeDescriptor.<Config>referenceWithInitializer(Config.class, () -> Config.Default());
  public static dafny.TypeDescriptor<Config> _typeDescriptor() {
    return (dafny.TypeDescriptor<Config>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final Config theDefault = Config.create(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,TableConfig> empty());
  public static Config Default() {
    return theDefault;
  }
  public static Config create(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends TableConfig> tableEncryptionConfigs) {
    return new Config(tableEncryptionConfigs);
  }
  public static Config create_Config(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends TableConfig> tableEncryptionConfigs) {
    return create(tableEncryptionConfigs);
  }
  public boolean is_Config() { return true; }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends TableConfig> dtor_tableEncryptionConfigs() {
    return this._tableEncryptionConfigs;
  }
}
