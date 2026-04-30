// Class PartialHeader
// Dafny class PartialHeader compiled into Java
package StructuredEncryptionHeader_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class PartialHeader {
  public byte _version;
  public byte _flavor;
  public dafny.DafnySequence<? extends java.lang.Byte> _msgID;
  public dafny.DafnySequence<? extends java.lang.Byte> _legend;
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> _encContext;
  public dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> _dataKeys;
  public PartialHeader (byte version, byte flavor, dafny.DafnySequence<? extends java.lang.Byte> msgID, dafny.DafnySequence<? extends java.lang.Byte> legend, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> encContext, dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> dataKeys) {
    this._version = version;
    this._flavor = flavor;
    this._msgID = msgID;
    this._legend = legend;
    this._encContext = encContext;
    this._dataKeys = dataKeys;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    PartialHeader o = (PartialHeader)other;
    return true && this._version == o._version && this._flavor == o._flavor && java.util.Objects.equals(this._msgID, o._msgID) && java.util.Objects.equals(this._legend, o._legend) && java.util.Objects.equals(this._encContext, o._encContext) && java.util.Objects.equals(this._dataKeys, o._dataKeys);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.lang.Byte.hashCode(this._version);
    hash = ((hash << 5) + hash) + java.lang.Byte.hashCode(this._flavor);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._msgID);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._legend);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._encContext);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._dataKeys);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("StructuredEncryptionHeader.PartialHeader.PartialHeader");
    s.append("(");
    s.append(this._version);
    s.append(", ");
    s.append(this._flavor);
    s.append(", ");
    s.append(dafny.Helpers.toString(this._msgID));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._legend));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._encContext));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._dataKeys));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<PartialHeader> _TYPE = dafny.TypeDescriptor.<PartialHeader>referenceWithInitializer(PartialHeader.class, () -> PartialHeader.Default());
  public static dafny.TypeDescriptor<PartialHeader> _typeDescriptor() {
    return (dafny.TypeDescriptor<PartialHeader>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final PartialHeader theDefault = PartialHeader.create(Version.defaultValue(), (byte) 0, dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()), dafny.DafnySequence.<java.lang.Byte> empty(LegendByte._typeDescriptor()), dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>,dafny.DafnySequence<? extends java.lang.Byte>> empty(), dafny.DafnySequence.<software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> empty(CMPEncryptedDataKey._typeDescriptor()));
  public static PartialHeader Default() {
    return theDefault;
  }
  public static PartialHeader create(byte version, byte flavor, dafny.DafnySequence<? extends java.lang.Byte> msgID, dafny.DafnySequence<? extends java.lang.Byte> legend, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> encContext, dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> dataKeys) {
    return new PartialHeader(version, flavor, msgID, legend, encContext, dataKeys);
  }
  public static PartialHeader create_PartialHeader(byte version, byte flavor, dafny.DafnySequence<? extends java.lang.Byte> msgID, dafny.DafnySequence<? extends java.lang.Byte> legend, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> encContext, dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> dataKeys) {
    return create(version, flavor, msgID, legend, encContext, dataKeys);
  }
  public boolean is_PartialHeader() { return true; }
  public byte dtor_version() {
    return this._version;
  }
  public byte dtor_flavor() {
    return this._flavor;
  }
  public dafny.DafnySequence<? extends java.lang.Byte> dtor_msgID() {
    return this._msgID;
  }
  public dafny.DafnySequence<? extends java.lang.Byte> dtor_legend() {
    return this._legend;
  }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends dafny.DafnySequence<? extends java.lang.Byte>> dtor_encContext() {
    return this._encContext;
  }
  public dafny.DafnySequence<? extends software.amazon.cryptography.materialproviders.internaldafny.types.EncryptedDataKey> dtor_dataKeys() {
    return this._dataKeys;
  }
  public dafny.DafnySequence<? extends java.lang.Byte> serialize() {
    dafny.DafnySequence<? extends java.lang.Byte> _0_context = __default.SerializeContext((this).dtor_encContext());
    dafny.DafnySequence<? extends java.lang.Byte> _1_keys = __default.SerializeDataKeys((this).dtor_dataKeys());
    dafny.DafnySequence<? extends java.lang.Byte> _2_leg = __default.SerializeLegend((this).dtor_legend());
    return dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte> of((this).dtor_version()), dafny.DafnySequence.<java.lang.Byte> of((this).dtor_flavor())), (this).dtor_msgID()), _2_leg), _0_context), _1_keys);
  }
  public Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> verifyCommitment(software.amazon.cryptography.primitives.internaldafny.types.IAwsCryptographicPrimitivesClient client, software.amazon.cryptography.materialproviders.internaldafny.types.AlgorithmSuiteInfo alg, dafny.DafnySequence<? extends java.lang.Byte> commitKey, dafny.DafnySequence<? extends java.lang.Byte> data)
  {
    Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _0_valueOrError0 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), java.lang.Long.compareUnsigned(__default.COMMITMENT__LEN64(), (long) (data).cardinalityInt()) < 0, StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Serialized header too short")));
    if ((_0_valueOrError0).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
      return (_0_valueOrError0).<Boolean>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
    } else {
      dafny.DafnySequence<? extends java.lang.Byte> _1_storedCommitment = (data).drop((long) (long) (((long) (data).cardinalityInt()) - (__default.COMMITMENT__LEN64())));
      Wrappers_Compile.Result<dafny.DafnySequence<? extends java.lang.Byte>, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _2_valueOrError1 = __default.CalculateHeaderCommitment(client, alg, commitKey, (data).take((long) (long) (((long) (data).cardinalityInt()) - (__default.COMMITMENT__LEN64()))));
      if ((_2_valueOrError1).IsFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
        return (_2_valueOrError1).<Boolean>PropagateFailure(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
      } else {
        dafny.DafnySequence<? extends java.lang.Byte> _3_calcCommitment = (_2_valueOrError1).Extract(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(BoundedInts_Compile.uint8._typeDescriptor()), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
        Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _4_valueOrError2 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), StructuredEncryptionUtil_Compile.__default.ConstantTimeEquals(_1_storedCommitment, _3_calcCommitment), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Key commitment mismatch.")));
        if ((_4_valueOrError2).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
          return (_4_valueOrError2).<Boolean>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), dafny.TypeDescriptor.BOOLEAN);
        } else {
          return Wrappers_Compile.Result.<Boolean, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Success(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), true);
        }
      }
    }
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.AlgorithmSuiteInfo, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> GetAlgorithmSuite(software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient matProv)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.AlgorithmSuiteInfo, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> ret = (Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.AlgorithmSuiteInfo, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>)null;
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.types.AlgorithmSuiteInfo, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _0_algorithmSuiteR;
      _0_algorithmSuiteR = (matProv).GetAlgorithmSuiteInfo(dafny.DafnySequence.<java.lang.Byte> of(StructuredEncryptionUtil_Compile.__default.DbeAlgorithmFamily(), (this).dtor_flavor()));
      if ((_0_algorithmSuiteR).is_Success()) {
        Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _1_valueOrError0 = Wrappers_Compile.Outcome.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
        _1_valueOrError0 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), StructuredEncryptionUtil_Compile.__default.ValidSuite((_0_algorithmSuiteR).dtor_value()), StructuredEncryptionUtil_Compile.__default.E(dafny.DafnySequence.asString("Invalid Algorithm Suite")));
        if ((_1_valueOrError0).IsFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
          ret = (_1_valueOrError0).<software.amazon.cryptography.materialproviders.internaldafny.types.AlgorithmSuiteInfo>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.materialproviders.internaldafny.types.AlgorithmSuiteInfo._typeDescriptor());
          return ret;
        }
        ret = Wrappers_Compile.Result.<software.amazon.cryptography.materialproviders.internaldafny.types.AlgorithmSuiteInfo, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Success(software.amazon.cryptography.materialproviders.internaldafny.types.AlgorithmSuiteInfo._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), (_0_algorithmSuiteR).dtor_value());
        return ret;
      } else {
        ret = (_0_algorithmSuiteR).<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>MapFailure(software.amazon.cryptography.materialproviders.internaldafny.types.AlgorithmSuiteInfo._typeDescriptor(), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<software.amazon.cryptography.materialproviders.internaldafny.types.Error, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>)(_2_e_boxed0) -> {
          software.amazon.cryptography.materialproviders.internaldafny.types.Error _2_e = ((software.amazon.cryptography.materialproviders.internaldafny.types.Error)(java.lang.Object)(_2_e_boxed0));
          return software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error.create_AwsCryptographyMaterialProviders(_2_e);
        }));
        return ret;
      }
    }
    return ret;
  }
}
