// Class FieldKeyTestItem
// Dafny class FieldKeyTestItem compiled into Java
package TestStructuredEncryptionCrypt_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class FieldKeyTestItem {
  public dafny.DafnySequence<? extends Character> _input;
  public int _offset;
  public dafny.DafnySequence<? extends Character> _output;
  public FieldKeyTestItem (dafny.DafnySequence<? extends Character> input, int offset, dafny.DafnySequence<? extends Character> output) {
    this._input = input;
    this._offset = offset;
    this._output = output;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    FieldKeyTestItem o = (FieldKeyTestItem)other;
    return true && java.util.Objects.equals(this._input, o._input) && this._offset == o._offset && java.util.Objects.equals(this._output, o._output);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._input);
    hash = ((hash << 5) + hash) + java.lang.Integer.hashCode(this._offset);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._output);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("TestStructuredEncryptionCrypt.FieldKeyTestItem.FieldKeyTestItem");
    s.append("(");
    s.append(dafny.Helpers.toString(this._input));
    s.append(", ");
    s.append(this._offset);
    s.append(", ");
    s.append(dafny.Helpers.toString(this._output));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<FieldKeyTestItem> _TYPE = dafny.TypeDescriptor.<FieldKeyTestItem>referenceWithInitializer(FieldKeyTestItem.class, () -> FieldKeyTestItem.Default());
  public static dafny.TypeDescriptor<FieldKeyTestItem> _typeDescriptor() {
    return (dafny.TypeDescriptor<FieldKeyTestItem>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final FieldKeyTestItem theDefault = FieldKeyTestItem.create(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), 0, dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR));
  public static FieldKeyTestItem Default() {
    return theDefault;
  }
  public static FieldKeyTestItem create(dafny.DafnySequence<? extends Character> input, int offset, dafny.DafnySequence<? extends Character> output) {
    return new FieldKeyTestItem(input, offset, output);
  }
  public static FieldKeyTestItem create_FieldKeyTestItem(dafny.DafnySequence<? extends Character> input, int offset, dafny.DafnySequence<? extends Character> output) {
    return create(input, offset, output);
  }
  public boolean is_FieldKeyTestItem() { return true; }
  public dafny.DafnySequence<? extends Character> dtor_input() {
    return this._input;
  }
  public int dtor_offset() {
    return this._offset;
  }
  public dafny.DafnySequence<? extends Character> dtor_output() {
    return this._output;
  }
}
