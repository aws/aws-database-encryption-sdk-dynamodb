// Class GetSuffix
// Dafny class GetSuffix compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class GetSuffix {
  public int _length;
  public GetSuffix (int length) {
    this._length = length;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    GetSuffix o = (GetSuffix)other;
    return true && this._length == o._length;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.lang.Integer.hashCode(this._length);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Types_Compile.GetSuffix.GetSuffix");
    s.append("(");
    s.append(this._length);
    s.append(")");
    return s.toString();
  }

  private static final GetSuffix theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSuffix.create(0);
  public static GetSuffix Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<GetSuffix> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(GetSuffix.class, () -> Default());
  public static dafny.TypeDescriptor<GetSuffix> _typeDescriptor() {
    return (dafny.TypeDescriptor<GetSuffix>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static GetSuffix create(int length) {
    return new GetSuffix(length);
  }
  public static GetSuffix create_GetSuffix(int length) {
    return create(length);
  }
  public boolean is_GetSuffix() { return true; }
  public int dtor_length() {
    return this._length;
  }
}
