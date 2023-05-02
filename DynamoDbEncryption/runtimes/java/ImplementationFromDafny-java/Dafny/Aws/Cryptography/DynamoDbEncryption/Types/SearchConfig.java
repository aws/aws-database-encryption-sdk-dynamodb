// Class SearchConfig
// Dafny class SearchConfig compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class SearchConfig {
  public dafny.DafnySequence<? extends BeaconVersion> _versions;
  public int _writeVersion;
  public SearchConfig (dafny.DafnySequence<? extends BeaconVersion> versions, int writeVersion) {
    this._versions = versions;
    this._writeVersion = writeVersion;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    SearchConfig o = (SearchConfig)other;
    return true && java.util.Objects.equals(this._versions, o._versions) && this._writeVersion == o._writeVersion;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._versions);
    hash = ((hash << 5) + hash) + java.lang.Integer.hashCode(this._writeVersion);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Types_Compile.SearchConfig.SearchConfig");
    s.append("(");
    s.append(dafny.Helpers.toString(this._versions));
    s.append(", ");
    s.append(this._writeVersion);
    s.append(")");
    return s.toString();
  }

  private static final SearchConfig theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Types.SearchConfig.create(dafny.DafnySequence.<BeaconVersion> empty(BeaconVersion._typeDescriptor()), 0);
  public static SearchConfig Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<SearchConfig> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(SearchConfig.class, () -> Default());
  public static dafny.TypeDescriptor<SearchConfig> _typeDescriptor() {
    return (dafny.TypeDescriptor<SearchConfig>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static SearchConfig create(dafny.DafnySequence<? extends BeaconVersion> versions, int writeVersion) {
    return new SearchConfig(versions, writeVersion);
  }
  public static SearchConfig create_SearchConfig(dafny.DafnySequence<? extends BeaconVersion> versions, int writeVersion) {
    return create(versions, writeVersion);
  }
  public boolean is_SearchConfig() { return true; }
  public dafny.DafnySequence<? extends BeaconVersion> dtor_versions() {
    return this._versions;
  }
  public int dtor_writeVersion() {
    return this._writeVersion;
  }
}
