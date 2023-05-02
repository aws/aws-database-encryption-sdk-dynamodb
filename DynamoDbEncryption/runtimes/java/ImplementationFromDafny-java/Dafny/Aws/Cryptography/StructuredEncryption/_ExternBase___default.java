// Class _ExternBase___default
// Dafny class __default compiled into Java
package Dafny.Aws.Cryptography.StructuredEncryption;

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
import AwsCryptographyStructuredEncryptionOperations_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class _ExternBase___default {
  public _ExternBase___default() {
  }
  public static Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredEncryptionConfig DefaultStructuredEncryptionConfig() {
    return Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredEncryptionConfig.create();
  }
  public static Wrappers_Compile.Result<StructuredEncryptionClient, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> StructuredEncryption(Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredEncryptionConfig config)
  {
    Wrappers_Compile.Result<StructuredEncryptionClient, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> res = (Wrappers_Compile.Result<StructuredEncryptionClient, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)null;
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient, Dafny.Aws.Cryptography.Primitives.Types.Error> _712_maybePrimitives;
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient, Dafny.Aws.Cryptography.Primitives.Types.Error> _out33;
    _out33 = Dafny.Aws.Cryptography.Primitives.__default.AtomicPrimitives(Dafny.Aws.Cryptography.Primitives.__default.DefaultCryptoConfig());
    _712_maybePrimitives = _out33;
    Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient _713_primitives;
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _714_valueOrError0 = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)null;
    _714_valueOrError0 = (_712_maybePrimitives).<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>MapFailure(Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient._typeDescriptor(), Dafny.Aws.Cryptography.Primitives.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.Primitives.Types.Error, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)(_715_e_boxed0) -> {
      Dafny.Aws.Cryptography.Primitives.Types.Error _715_e = ((Dafny.Aws.Cryptography.Primitives.Types.Error)(java.lang.Object)(_715_e_boxed0));
      return Dafny.Aws.Cryptography.StructuredEncryption.Types.Error.create_AwsCryptographyPrimitives(_715_e);
    }));
    if ((_714_valueOrError0).IsFailure(Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      res = (_714_valueOrError0).<StructuredEncryptionClient>PropagateFailure(Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), StructuredEncryptionClient._typeDescriptor());
      return res;
    }
    _713_primitives = (_714_valueOrError0).Extract(Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient, Dafny.Aws.Cryptography.MaterialProviders.Types.Error> _716_maybeMatProv;
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient, Dafny.Aws.Cryptography.MaterialProviders.Types.Error> _out34;
    _out34 = Dafny.Aws.Cryptography.MaterialProviders.__default.MaterialProviders(Dafny.Aws.Cryptography.MaterialProviders.__default.DefaultMaterialProvidersConfig());
    _716_maybeMatProv = _out34;
    Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient _717_matProv;
    Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error> _718_valueOrError1 = (Wrappers_Compile.Result<Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)null;
    _718_valueOrError1 = (_716_maybeMatProv).<Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>MapFailure(Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient._typeDescriptor(), Dafny.Aws.Cryptography.MaterialProviders.Types.Error._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), ((java.util.function.Function<Dafny.Aws.Cryptography.MaterialProviders.Types.Error, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>)(_719_e_boxed0) -> {
      Dafny.Aws.Cryptography.MaterialProviders.Types.Error _719_e = ((Dafny.Aws.Cryptography.MaterialProviders.Types.Error)(java.lang.Object)(_719_e_boxed0));
      return Dafny.Aws.Cryptography.StructuredEncryption.Types.Error.create_AwsCryptographyMaterialProviders(_719_e);
    }));
    if ((_718_valueOrError1).IsFailure(Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor())) {
      res = (_718_valueOrError1).<StructuredEncryptionClient>PropagateFailure(Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor(), StructuredEncryptionClient._typeDescriptor());
      return res;
    }
    _717_matProv = (_718_valueOrError1).Extract(Dafny.Aws.Cryptography.MaterialProviders.MaterialProvidersClient._typeDescriptor(), Dafny.Aws.Cryptography.StructuredEncryption.Types.Error._typeDescriptor());
    StructuredEncryptionClient _720_client;
    StructuredEncryptionClient _nw2 = new StructuredEncryptionClient();
    _nw2.__ctor(AwsCryptographyStructuredEncryptionOperations_Compile.Config.create(_713_primitives, _717_matProv));
    _720_client = _nw2;
    res = Wrappers_Compile.Result.<StructuredEncryptionClient, Dafny.Aws.Cryptography.StructuredEncryption.Types.Error>create_Success(_720_client);
    return res;
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "Dafny.Aws.Cryptography.StructuredEncryption_Compile._default";
  }
}
