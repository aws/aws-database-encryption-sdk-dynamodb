// Class __default
// Dafny class __default compiled into Java
package CompoundBeacon_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static Wrappers_Compile.Result<CompoundBeacon, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> MakeCompoundBeacon(BaseBeacon_Compile.BeaconBase base, char split, dafny.DafnySequence<? extends BeaconPart> parts, java.math.BigInteger numSigned, dafny.DafnySequence<? extends Constructor> construct)
  {
    CompoundBeacon _0_x = CompoundBeacon.create(base, split, parts, numSigned, construct);
    Wrappers_Compile.Result<Boolean, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _1_valueOrError0 = (_0_x).ValidPrefixSetResult();
    if ((_1_valueOrError0).IsFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
      return (_1_valueOrError0).<CompoundBeacon>PropagateFailure(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), CompoundBeacon._typeDescriptor());
    } else {
      boolean _2___v0 = (_1_valueOrError0).Extract(dafny.TypeDescriptor.BOOLEAN, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      return Wrappers_Compile.Result.<CompoundBeacon, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(CompoundBeacon._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), _0_x);
    }
  }
  public static Constructor MakeDefaultConstructor(dafny.DafnySequence<? extends BeaconPart> parts) {
    dafny.DafnySequence<? extends ConstructorPart> _0_cons = Seq_Compile.__default.<BeaconPart, ConstructorPart>Map(BeaconPart._typeDescriptor(), ConstructorPart._typeDescriptor(), ((java.util.function.Function<BeaconPart, ConstructorPart>)(_1_x_boxed0) -> {
      BeaconPart _1_x = ((BeaconPart)(java.lang.Object)(_1_x_boxed0));
      return ConstructorPart.create(_1_x, true);
    }), parts);
    return Constructor.create(_0_cons);
  }
  @Override
  public java.lang.String toString() {
    return "CompoundBeacon._default";
  }
}
