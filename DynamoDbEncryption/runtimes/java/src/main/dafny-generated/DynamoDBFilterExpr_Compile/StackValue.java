// Class StackValue
// Dafny class StackValue compiled into Java
package DynamoDBFilterExpr_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class StackValue {
  public StackValue() {
  }
  private static final dafny.TypeDescriptor<StackValue> _TYPE = dafny.TypeDescriptor.<StackValue>referenceWithInitializer(StackValue.class, () -> StackValue.Default());
  public static dafny.TypeDescriptor<StackValue> _typeDescriptor() {
    return (dafny.TypeDescriptor<StackValue>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final StackValue theDefault = StackValue.create_Bool(false);
  public static StackValue Default() {
    return theDefault;
  }
  public static StackValue create_Bool(boolean b) {
    return new StackValue_Bool(b);
  }
  public static StackValue create_Str(software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue s) {
    return new StackValue_Str(s);
  }
  public static StackValue create_DoesNotExist() {
    return new StackValue_DoesNotExist();
  }
  public boolean is_Bool() { return this instanceof StackValue_Bool; }
  public boolean is_Str() { return this instanceof StackValue_Str; }
  public boolean is_DoesNotExist() { return this instanceof StackValue_DoesNotExist; }
  public boolean dtor_b() {
    StackValue d = this;
    return ((StackValue_Bool)d)._b;
  }
  public software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue dtor_s() {
    StackValue d = this;
    return ((StackValue_Str)d)._s;
  }
}
