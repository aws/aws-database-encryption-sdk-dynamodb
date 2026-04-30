// Class _ExternBase___default
// Dafny class __default compiled into Java
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny;

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class _ExternBase___default {
  public _ExternBase___default() {
  }
  public static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredEncryptionConfig DefaultStructuredEncryptionConfig() {
    return software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredEncryptionConfig.create();
  }
  public static Wrappers_Compile.Result<StructuredEncryptionClient, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> StructuredEncryption(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.StructuredEncryptionConfig config)
  {
    Wrappers_Compile.Result<StructuredEncryptionClient, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> res = (Wrappers_Compile.Result<StructuredEncryptionClient, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>)null;
    Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.primitives.internaldafny.types.Error> _0_maybePrimitives;
    Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.primitives.internaldafny.types.Error> _out0;
    _out0 = software.amazon.cryptography.primitives.internaldafny.__default.AtomicPrimitives(software.amazon.cryptography.primitives.internaldafny.__default.DefaultCryptoConfig());
    _0_maybePrimitives = _out0;
    Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _1_valueOrError0 = (Wrappers_Compile.Result<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>)null;
    _1_valueOrError0 = (_0_maybePrimitives).<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>MapFailure(((dafny.TypeDescriptor<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient.class)), software.amazon.cryptography.primitives.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<software.amazon.cryptography.primitives.internaldafny.types.Error, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>)(_2_e_boxed0) -> {
      software.amazon.cryptography.primitives.internaldafny.types.Error _2_e = ((software.amazon.cryptography.primitives.internaldafny.types.Error)(java.lang.Object)(_2_e_boxed0));
      return software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error.create_AwsCryptographyPrimitives(_2_e);
    }));
    if ((_1_valueOrError0).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient.class)), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
      res = (_1_valueOrError0).<StructuredEncryptionClient>PropagateFailure(((dafny.TypeDescriptor<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient.class)), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), ((dafny.TypeDescriptor<StructuredEncryptionClient>)(java.lang.Object)dafny.TypeDescriptor.reference(StructuredEncryptionClient.class)));
      return res;
    }
    software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient _3_primitives;
    _3_primitives = (_1_valueOrError0).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient.class)), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
    Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _4_maybeMatProv;
    Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient, software.amazon.cryptography.materialproviders.internaldafny.types.Error> _out1;
    _out1 = software.amazon.cryptography.materialproviders.internaldafny.__default.MaterialProviders(software.amazon.cryptography.materialproviders.internaldafny.__default.DefaultMaterialProvidersConfig());
    _4_maybeMatProv = _out1;
    Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _5_valueOrError1 = (Wrappers_Compile.Result<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>)null;
    _5_valueOrError1 = (_4_maybeMatProv).<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>MapFailure(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient.class)), software.amazon.cryptography.materialproviders.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), ((java.util.function.Function<software.amazon.cryptography.materialproviders.internaldafny.types.Error, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>)(_6_e_boxed0) -> {
      software.amazon.cryptography.materialproviders.internaldafny.types.Error _6_e = ((software.amazon.cryptography.materialproviders.internaldafny.types.Error)(java.lang.Object)(_6_e_boxed0));
      return software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error.create_AwsCryptographyMaterialProviders(_6_e);
    }));
    if ((_5_valueOrError1).IsFailure(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient.class)), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor())) {
      res = (_5_valueOrError1).<StructuredEncryptionClient>PropagateFailure(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient.class)), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), ((dafny.TypeDescriptor<StructuredEncryptionClient>)(java.lang.Object)dafny.TypeDescriptor.reference(StructuredEncryptionClient.class)));
      return res;
    }
    software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient _7_matProv;
    _7_matProv = (_5_valueOrError1).Extract(((dafny.TypeDescriptor<software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.materialproviders.internaldafny.MaterialProvidersClient.class)), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor());
    StructuredEncryptionClient _8_client;
    StructuredEncryptionClient _nw0 = new StructuredEncryptionClient();
    _nw0.__ctor(AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations_Compile.Config.create(_3_primitives, _7_matProv));
    _8_client = _nw0;
    res = Wrappers_Compile.Result.<StructuredEncryptionClient, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Success(((dafny.TypeDescriptor<StructuredEncryptionClient>)(java.lang.Object)dafny.TypeDescriptor.reference(StructuredEncryptionClient.class)), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), _8_client);
    return res;
  }
  public static Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.IStructuredEncryptionClient, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> CreateSuccessOfClient(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.IStructuredEncryptionClient client) {
    return Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.IStructuredEncryptionClient, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Success(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.IStructuredEncryptionClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.IStructuredEncryptionClient.class)), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), client);
  }
  public static Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.IStructuredEncryptionClient, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> CreateFailureOfError(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error error) {
    return Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.IStructuredEncryptionClient, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>create_Failure(((dafny.TypeDescriptor<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.IStructuredEncryptionClient>)(java.lang.Object)dafny.TypeDescriptor.reference(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.IStructuredEncryptionClient.class)), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), error);
  }
  @Override
  public java.lang.String toString() {
    return "StructuredEncryption._default";
  }
}
