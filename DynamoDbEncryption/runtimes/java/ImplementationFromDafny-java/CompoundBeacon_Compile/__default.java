// Class __default
// Dafny class __default compiled into Java
package CompoundBeacon_Compile;

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
import Dafny.Aws.Cryptography.StructuredEncryption.*;
import TermLoc_Compile.*;
import DdbVirtualFields_Compile.*;
import BaseBeacon_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static Wrappers_Compile.Result<CompoundBeacon, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> MakeCompoundBeacon(BaseBeacon_Compile.BeaconBase base, char split, dafny.DafnySequence<? extends BeaconPart> parts, java.math.BigInteger numNonSensitive, dafny.DafnySequence<? extends Constructor> construct)
  {
    CompoundBeacon _960_x = CompoundBeacon_Compile.CompoundBeacon.create(base, split, parts, numNonSensitive, construct);
    Wrappers_Compile.Result<Boolean, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _961_valueOrError0 = (_960_x).ValidPrefixSetResult();
    if ((_961_valueOrError0).IsFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
      return (_961_valueOrError0).<CompoundBeacon>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), CompoundBeacon._typeDescriptor());
    } else {
      boolean _962___v0 = (_961_valueOrError0).Extract(dafny.TypeDescriptor.BOOLEAN, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
      return Wrappers_Compile.Result.<CompoundBeacon, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(_960_x);
    }
  }
  public static Constructor MakeDefaultConstructor(dafny.DafnySequence<? extends BeaconPart> parts) {
    dafny.DafnySequence<? extends ConstructorPart> _963_cons = Seq_Compile.__default.<BeaconPart, ConstructorPart>Map(BeaconPart._typeDescriptor(), ConstructorPart._typeDescriptor(), ((java.util.function.Function<BeaconPart, ConstructorPart>)(_964_x_boxed0) -> {
      BeaconPart _964_x = ((BeaconPart)(java.lang.Object)(_964_x_boxed0));
      return CompoundBeacon_Compile.ConstructorPart.create(_964_x, true);
    }), parts);
    return CompoundBeacon_Compile.Constructor.create(_963_cons);
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "CompoundBeacon_Compile._default";
  }
}
