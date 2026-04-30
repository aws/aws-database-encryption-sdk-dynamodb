// Class SearchInfo
// Dafny class SearchInfo compiled into Java
package SearchableEncryptionInfo_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class SearchInfo {
  public dafny.DafnySequence<? extends BeaconVersion> _versions;
  public java.math.BigInteger _currWrite;
  public SearchInfo (dafny.DafnySequence<? extends BeaconVersion> versions, java.math.BigInteger currWrite) {
    this._versions = versions;
    this._currWrite = currWrite;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    SearchInfo o = (SearchInfo)other;
    return true && java.util.Objects.equals(this._versions, o._versions) && java.util.Objects.equals(this._currWrite, o._currWrite);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._versions);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._currWrite);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("SearchableEncryptionInfo.SearchInfo.SearchInfo");
    s.append("(");
    s.append(dafny.Helpers.toString(this._versions));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._currWrite));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<SearchInfo> _TYPE = dafny.TypeDescriptor.<SearchInfo>referenceWithInitializer(SearchInfo.class, () -> SearchInfo.Default());
  public static dafny.TypeDescriptor<SearchInfo> _typeDescriptor() {
    return (dafny.TypeDescriptor<SearchInfo>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final SearchInfo theDefault = SearchInfo.create(dafny.DafnySequence.<BeaconVersion> empty(BeaconVersion._typeDescriptor()), java.math.BigInteger.ZERO);
  public static SearchInfo Default() {
    return theDefault;
  }
  public static SearchInfo create(dafny.DafnySequence<? extends BeaconVersion> versions, java.math.BigInteger currWrite) {
    return new SearchInfo(versions, currWrite);
  }
  public static SearchInfo create_SearchInfo(dafny.DafnySequence<? extends BeaconVersion> versions, java.math.BigInteger currWrite) {
    return create(versions, currWrite);
  }
  public boolean is_SearchInfo() { return true; }
  public dafny.DafnySequence<? extends BeaconVersion> dtor_versions() {
    return this._versions;
  }
  public java.math.BigInteger dtor_currWrite() {
    return this._currWrite;
  }
  public BeaconVersion curr() {
    return ((BeaconVersion)(java.lang.Object)(((this).dtor_versions()).select(dafny.Helpers.toInt(((this).dtor_currWrite())))));
  }
  public boolean IsBeacon(dafny.DafnySequence<? extends Character> field) {
    return (((BeaconVersion)(java.lang.Object)(((this).dtor_versions()).select(dafny.Helpers.toInt(((this).dtor_currWrite())))))).IsBeacon(field);
  }
  public boolean IsVirtualField(dafny.DafnySequence<? extends Character> field) {
    return (((BeaconVersion)(java.lang.Object)(((this).dtor_versions()).select(dafny.Helpers.toInt(((this).dtor_currWrite())))))).IsVirtualField(field);
  }
  public Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GeneratePlainBeacons(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty());
    if(true) {
      Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out0;
      _out0 = (((BeaconVersion)(java.lang.Object)(((this).dtor_versions()).select(dafny.Helpers.toInt(((this).dtor_currWrite())))))).GeneratePlainBeacons(item);
      output = _out0;
    }
    return output;
  }
  public Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GenerateSignedBeacons(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty());
    if(true) {
      Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out0;
      _out0 = (((BeaconVersion)(java.lang.Object)(((this).dtor_versions()).select(dafny.Helpers.toInt(((this).dtor_currWrite())))))).GenerateSignedBeacons(item);
      output = _out0;
    }
    return output;
  }
  public Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> GenerateEncryptedBeacons(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> item, DynamoDbEncryptionUtil_Compile.MaybeKeyId keyId)
  {
    Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> output = Wrappers_Compile.Result.<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Default(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>, software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>_typeDescriptor(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeName._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty());
    if(true) {
      Wrappers_Compile.Result<dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _out0;
      _out0 = (((BeaconVersion)(java.lang.Object)(((this).dtor_versions()).select(dafny.Helpers.toInt(((this).dtor_currWrite())))))).GenerateEncryptedBeacons(item, keyId);
      output = _out0;
    }
    return output;
  }
}
