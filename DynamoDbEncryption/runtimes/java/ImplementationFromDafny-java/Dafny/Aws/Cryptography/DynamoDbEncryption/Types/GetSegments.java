// Class GetSegments
// Dafny class GetSegments compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class GetSegments {
  public dafny.DafnySequence<? extends Character> _split;
  public int _low;
  public int _high;
  public GetSegments (dafny.DafnySequence<? extends Character> split, int low, int high) {
    this._split = split;
    this._low = low;
    this._high = high;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    GetSegments o = (GetSegments)other;
    return true && java.util.Objects.equals(this._split, o._split) && this._low == o._low && this._high == o._high;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._split);
    hash = ((hash << 5) + hash) + java.lang.Integer.hashCode(this._low);
    hash = ((hash << 5) + hash) + java.lang.Integer.hashCode(this._high);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Types_Compile.GetSegments.GetSegments");
    s.append("(");
    s.append(dafny.Helpers.toString(this._split));
    s.append(", ");
    s.append(this._low);
    s.append(", ");
    s.append(this._high);
    s.append(")");
    return s.toString();
  }

  private static final GetSegments theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetSegments.create(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), 0, 0);
  public static GetSegments Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<GetSegments> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(GetSegments.class, () -> Default());
  public static dafny.TypeDescriptor<GetSegments> _typeDescriptor() {
    return (dafny.TypeDescriptor<GetSegments>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static GetSegments create(dafny.DafnySequence<? extends Character> split, int low, int high) {
    return new GetSegments(split, low, high);
  }
  public static GetSegments create_GetSegments(dafny.DafnySequence<? extends Character> split, int low, int high) {
    return create(split, low, high);
  }
  public boolean is_GetSegments() { return true; }
  public dafny.DafnySequence<? extends Character> dtor_split() {
    return this._split;
  }
  public int dtor_low() {
    return this._low;
  }
  public int dtor_high() {
    return this._high;
  }
}
