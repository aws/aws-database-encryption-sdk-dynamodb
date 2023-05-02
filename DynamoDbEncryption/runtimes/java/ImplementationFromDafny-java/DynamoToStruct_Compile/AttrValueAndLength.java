// Class AttrValueAndLength
// Dafny class AttrValueAndLength compiled into Java
package DynamoToStruct_Compile;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.*;
import DynamoDbEncryptionUtil_Compile.*;
import DynamoDbNormalizeNumber_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class AttrValueAndLength {
  public Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue _val;
  public java.math.BigInteger _len;
  public AttrValueAndLength (Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue val, java.math.BigInteger len) {
    this._val = val;
    this._len = len;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    AttrValueAndLength o = (AttrValueAndLength)other;
    return true && java.util.Objects.equals(this._val, o._val) && java.util.Objects.equals(this._len, o._len);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._val);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._len);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("DynamoToStruct_Compile.AttrValueAndLength.AttrValueAndLength");
    s.append("(");
    s.append(dafny.Helpers.toString(this._val));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._len));
    s.append(")");
    return s.toString();
  }

  private static final AttrValueAndLength theDefault = DynamoToStruct_Compile.AttrValueAndLength.create(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue.Default(), java.math.BigInteger.ZERO);
  public static AttrValueAndLength Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<AttrValueAndLength> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(AttrValueAndLength.class, () -> Default());
  public static dafny.TypeDescriptor<AttrValueAndLength> _typeDescriptor() {
    return (dafny.TypeDescriptor<AttrValueAndLength>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static AttrValueAndLength create(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue val, java.math.BigInteger len) {
    return new AttrValueAndLength(val, len);
  }
  public static AttrValueAndLength create_AttrValueAndLength(Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue val, java.math.BigInteger len) {
    return create(val, len);
  }
  public boolean is_AttrValueAndLength() { return true; }
  public Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue dtor_val() {
    return this._val;
  }
  public java.math.BigInteger dtor_len() {
    return this._len;
  }
}
