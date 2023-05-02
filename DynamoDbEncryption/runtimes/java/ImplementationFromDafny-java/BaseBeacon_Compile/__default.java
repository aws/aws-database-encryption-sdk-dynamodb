// Class __default
// Dafny class __default compiled into Java
package BaseBeacon_Compile;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static Wrappers_Compile.Result<StandardBeacon, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> MakeStandardBeacon(Dafny.Aws.Cryptography.Primitives.AtomicPrimitivesClient client, dafny.DafnySequence<? extends Character> name, byte length, dafny.DafnySequence<? extends Character> loc)
  {
    Wrappers_Compile.Result<dafny.DafnySequence<? extends TermLoc_Compile.Selector>, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _846_valueOrError0 = TermLoc_Compile.__default.MakeTermLoc(loc);
    if ((_846_valueOrError0).IsFailure(TermLoc_Compile.TermLoc._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
      return (_846_valueOrError0).<StandardBeacon>PropagateFailure(TermLoc_Compile.TermLoc._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), StandardBeacon._typeDescriptor());
    } else {
      dafny.DafnySequence<? extends TermLoc_Compile.Selector> _847_termLoc = (_846_valueOrError0).Extract(TermLoc_Compile.TermLoc._typeDescriptor(), Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor());
      dafny.DafnySequence<? extends Character> _848_beaconName = dafny.DafnySequence.<Character>concatenate(DynamoDbEncryptionUtil_Compile.__default.BeaconPrefix(), name);
      Wrappers_Compile.Outcome<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error> _849_valueOrError1 = Wrappers_Compile.__default.<Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>Need(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), Dafny.Com.Amazonaws.Dynamodb.Types.__default.IsValid__AttributeName(_848_beaconName), DynamoDbEncryptionUtil_Compile.__default.E(dafny.DafnySequence.<Character>concatenate(_848_beaconName, dafny.DafnySequence.asString(" is not a valid attribute name."))));
      if ((_849_valueOrError1).IsFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor())) {
        return (_849_valueOrError1).<StandardBeacon>PropagateFailure(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error._typeDescriptor(), StandardBeacon._typeDescriptor());
      } else {
        return Wrappers_Compile.Result.<StandardBeacon, Dafny.Aws.Cryptography.DynamoDbEncryption.Types.Error>create_Success(BaseBeacon_Compile.StandardBeacon.create(BaseBeacon_Compile.BeaconBase.create(client, name, _848_beaconName), length, _847_termLoc));
      }
    }
  }
  public static java.math.BigInteger CharsFromBeaconLength(byte bits) {
    return java.math.BigInteger.valueOf(java.lang.Byte.toUnsignedLong(dafny.Helpers.divideUnsignedByte((byte) (byte)  ((byte)(((bits)) + ((byte) 3))), (byte) 4)));
  }
  public static byte TopBits(byte bits) {
    byte _850_x = dafny.Helpers.remainderUnsignedByte((bits), (byte) 4);
    if (((_850_x) == 0 ? 0 : 1) == 0) {
      return (byte) 4;
    } else {
      return _850_x;
    }
  }
  public static java.math.BigInteger BytesFromBeaconLength(byte bits) {
    return java.math.BigInteger.valueOf(java.lang.Byte.toUnsignedLong(dafny.Helpers.divideUnsignedByte((byte) (byte)  ((byte)(((bits)) + ((byte) 7))), (byte) 8)));
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
    java.math.BigInteger _851_numBytes = __default.BytesFromBeaconLength(bits);
    java.math.BigInteger _852_numChars = __default.CharsFromBeaconLength(bits);
    byte _853_topBits = __default.TopBits(bits);
    dafny.DafnySequence<? extends java.lang.Byte> _854_bytes = (bytes).drop((java.math.BigInteger.valueOf(8L)).subtract(_851_numBytes));
    if (java.util.Objects.equals(_852_numChars, (java.math.BigInteger.valueOf(2L)).multiply(_851_numBytes))) {
      byte _855_topNibble = dafny.Helpers.divideUnsignedByte(((byte)(java.lang.Object)((_854_bytes).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), (byte) 16);
      byte _856_bottomNibble = dafny.Helpers.remainderUnsignedByte(((byte)(java.lang.Object)((_854_bytes).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), (byte) 16);
      return dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.of(HexStrings_Compile.__default.HexChar(__default.TruncateNibble(_855_topNibble, _853_topBits)), HexStrings_Compile.__default.HexChar(_856_bottomNibble)), HexStrings_Compile.__default.ToHexString((_854_bytes).drop(java.math.BigInteger.ONE)));
    } else {
      return dafny.DafnySequence.<Character>concatenate(dafny.DafnySequence.of(HexStrings_Compile.__default.HexChar(__default.TruncateNibble(dafny.Helpers.remainderUnsignedByte(((byte)(java.lang.Object)((_854_bytes).select(dafny.Helpers.toInt((java.math.BigInteger.ZERO))))), (byte) 16), _853_topBits))), HexStrings_Compile.__default.ToHexString((_854_bytes).drop(java.math.BigInteger.ONE)));
    }
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "BaseBeacon_Compile._default";
  }
}
