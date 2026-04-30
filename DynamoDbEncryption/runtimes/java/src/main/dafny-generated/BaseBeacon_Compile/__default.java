// Class __default
// Dafny class __default compiled into Java
package BaseBeacon_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static Wrappers_Compile.Result<StandardBeacon, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> MakeStandardBeacon(software.amazon.cryptography.primitives.internaldafny.AtomicPrimitivesClient client, dafny.DafnySequence<? extends Character> name, byte length, dafny.DafnySequence<? extends Character> loc, boolean partOnly, boolean asSet, Wrappers_Compile.Option<dafny.DafnySequence<? extends Character>> share)
  {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends TermLoc_Compile.Selector>, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _0_valueOrError0 = TermLoc_Compile.__default.MakeTermLoc(loc);
    if ((_0_valueOrError0).IsFailure(TermLoc_Compile.TermLoc._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
      return (_0_valueOrError0).<StandardBeacon>PropagateFailure(TermLoc_Compile.TermLoc._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), StandardBeacon._typeDescriptor());
    } else {
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _1_termLoc = (_0_valueOrError0).Extract(TermLoc_Compile.TermLoc._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor());
      dafny.DafnySequence<? extends Character> _2_beaconName = dafny.DafnySequence.<Character>concatenate(DynamoDbEncryptionUtil_Compile.__default.BeaconPrefix(), name);
      Wrappers_Compile.Outcome<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error> _3_valueOrError1 = Wrappers_Compile.__default.<software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>Need(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.services.dynamodb.internaldafny.types.__default.IsValid__AttributeName(_2_beaconName), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(_2_beaconName, dafny.DafnySequence.asString(" is not a valid attribute name."))));
      if ((_3_valueOrError1).IsFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor())) {
        return (_3_valueOrError1).<StandardBeacon>PropagateFailure(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), StandardBeacon._typeDescriptor());
      } else {
        return Wrappers_Compile.Result.<StandardBeacon, software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error>create_Success(StandardBeacon._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.Error._typeDescriptor(), StandardBeacon.create(BeaconBase.create(client, name, _2_beaconName), length, _1_termLoc, partOnly, asSet, share));
      }
    }
  }
  public static java.math.BigInteger CharsFromBeaconLength(byte bits) {
    return dafny.Helpers.unsignedToBigInteger(dafny.Helpers.divideUnsignedByte((byte) (byte) ((byte)(((bits)) + ((byte) 3))), (byte) 4));
  }
  public static byte TopBits(byte bits) {
    byte _0_x = dafny.Helpers.remainderUnsignedByte((bits), (byte) 4);
    if (((_0_x) == 0 ? 0 : 1) == 0) {
      return (byte) 4;
    } else {
      return _0_x;
    }
  }
  public static java.math.BigInteger BytesFromBeaconLength(byte bits) {
    return dafny.Helpers.unsignedToBigInteger(dafny.Helpers.divideUnsignedByte((byte) (byte) ((byte)(((bits)) + ((byte) 7))), (byte) 8));
  }
  public static byte TruncateNibble(byte nibble, byte length)
  {
    if ((length) == ((byte) 4)) {
      return nibble;
    } else if ((length) == ((byte) 3)) {
      return dafny.Helpers.remainderUnsignedByte(nibble, (byte) 8);
    } else if ((length) == ((byte) 2)) {
      return dafny.Helpers.remainderUnsignedByte(nibble, (byte) 4);
    } else {
      return dafny.Helpers.remainderUnsignedByte(nibble, (byte) 2);
    }
  }
  public static dafny.DafnySequence<? extends Character> BytesToHex(dafny.DafnySequence<? extends java.lang.Byte> bytes, byte bits)
  {
    java.math.BigInteger _0_numBytes = __default.BytesFromBeaconLength(bits);
    java.math.BigInteger _1_numChars = __default.CharsFromBeaconLength(bits);
    byte _2_topBits = __default.TopBits(bits);
    dafny.DafnySequence<? extends java.lang.Byte> _3_bytes = (bytes).drop((java.math.BigInteger.valueOf(8L)).subtract(_0_numBytes));
    if (java.util.Objects.equals(_1_numChars, (java.math.BigInteger.valueOf(2L)).multiply(_0_numBytes))) {
      byte _4_topNibble = dafny.Helpers.divideUnsignedByte(((byte)(java.lang.Object)((_3_bytes).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), (byte) 16);
      byte _5_bottomNibble = dafny.Helpers.remainderUnsignedByte(((byte)(java.lang.Object)((_3_bytes).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), (byte) 16);
      return dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character> of(HexStrings_Compile.__default.HexChar(__default.TruncateNibble(_4_topNibble, _2_topBits)), HexStrings_Compile.__default.HexChar(_5_bottomNibble)), HexStrings_Compile.__default.ToHexString((_3_bytes).drop(java.math.BigInteger.ONE)));
    } else {
      return dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.<Character> of(HexStrings_Compile.__default.HexChar(__default.TruncateNibble(dafny.Helpers.remainderUnsignedByte(((byte)(java.lang.Object)((_3_bytes).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), (byte) 16), _2_topBits))), HexStrings_Compile.__default.ToHexString((_3_bytes).drop(java.math.BigInteger.ONE)));
    }
  }
  @Override
  public java.lang.String toString() {
    return "BaseBeacon._default";
  }
}
