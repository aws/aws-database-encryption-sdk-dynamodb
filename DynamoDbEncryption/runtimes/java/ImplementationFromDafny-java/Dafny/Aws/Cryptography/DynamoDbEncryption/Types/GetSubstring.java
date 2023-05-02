// Class GetSubstring
// Dafny class GetSubstring compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class GetSubstring {
  public int _low;
  public int _high;
  public GetSubstring (int low, int high) {
    this._low = low;
    this._high = high;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    GetSubstring o = (GetSubstring)other;
    return true && this._low == o._low && this._high == o._high;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.lang.Integer.hashCode(this._low);
    hash = ((hash << 5) + hash) + java.lang.Integer.hashCode(this._high);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Types_Compile.GetSubstring.GetSubstring");
    s.append("(");
    s.append(this._low);
    s.append(", ");
    s.append(this._high);
    s.append(")");
    return s.toString();
  }

  private static final GetSubstring theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSubstring.create(0, 0);
  public static GetSubstring Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<GetSubstring> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(GetSubstring.class, () -> Default());
  public static dafny.TypeDescriptor<GetSubstring> _typeDescriptor() {
    return (dafny.TypeDescriptor<GetSubstring>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static GetSubstring create(int low, int high) {
    return new GetSubstring(low, high);
  }
  public static GetSubstring create_GetSubstring(int low, int high) {
    return create(low, high);
  }
  public boolean is_GetSubstring() { return true; }
  public int dtor_low() {
    return this._low;
  }
  public int dtor_high() {
    return this._high;
  }
}
