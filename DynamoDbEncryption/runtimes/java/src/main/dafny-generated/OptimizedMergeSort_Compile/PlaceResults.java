// Class PlaceResults
// Dafny class PlaceResults compiled into Java
package OptimizedMergeSort_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class PlaceResults {
  public PlaceResults() {
  }
  private static final dafny.TypeDescriptor<PlaceResults> _TYPE = dafny.TypeDescriptor.<PlaceResults>referenceWithInitializer(PlaceResults.class, () -> PlaceResults.Default());
  public static dafny.TypeDescriptor<PlaceResults> _typeDescriptor() {
    return (dafny.TypeDescriptor<PlaceResults>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final PlaceResults theDefault = PlaceResults.create_Left();
  public static PlaceResults Default() {
    return theDefault;
  }
  public static PlaceResults create_Left() {
    return new PlaceResults_Left();
  }
  public static PlaceResults create_Right() {
    return new PlaceResults_Right();
  }
  public static PlaceResults create_Either() {
    return new PlaceResults_Either();
  }
  public boolean is_Left() { return this instanceof PlaceResults_Left; }
  public boolean is_Right() { return this instanceof PlaceResults_Right; }
  public boolean is_Either() { return this instanceof PlaceResults_Either; }
  public static java.util.ArrayList<PlaceResults> AllSingletonConstructors() {
    java.util.ArrayList<PlaceResults> singleton_iterator = new java.util.ArrayList<>();
    singleton_iterator.add(new PlaceResults_Left());
    singleton_iterator.add(new PlaceResults_Right());
    singleton_iterator.add(new PlaceResults_Either());
    return singleton_iterator;
  }
}
