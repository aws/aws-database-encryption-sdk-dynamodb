// Class Selector
// Dafny class Selector compiled into Java
package StructuredEncryptionPaths_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class Selector {
  public Selector() {
  }
  private static final dafny.TypeDescriptor<Selector> _TYPE = dafny.TypeDescriptor.<Selector>referenceWithInitializer(Selector.class, () -> Selector.Default());
  public static dafny.TypeDescriptor<Selector> _typeDescriptor() {
    return (dafny.TypeDescriptor<Selector>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final Selector theDefault = Selector.create_List(0L);
  public static Selector Default() {
    return theDefault;
  }
  public static Selector create_List(long pos) {
    return new Selector_List(pos);
  }
  public static Selector create_Map(dafny.DafnySequence<? extends Character> key) {
    return new Selector_Map(key);
  }
  public boolean is_List() { return this instanceof Selector_List; }
  public boolean is_Map() { return this instanceof Selector_Map; }
  public long dtor_pos() {
    Selector d = this;
    return ((Selector_List)d)._pos;
  }
  public dafny.DafnySequence<? extends Character> dtor_key() {
    Selector d = this;
    return ((Selector_Map)d)._key;
  }
}
