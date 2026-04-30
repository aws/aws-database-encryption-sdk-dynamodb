// Class ResultPlacement
// Dafny class ResultPlacement compiled into Java
package OptimizedMergeSort_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class ResultPlacement {
  public ResultPlacement() {
  }
  public static boolean _Is(PlaceResults __source) {
    PlaceResults _0_r = __source;
    return !((_0_r).is_Either());
  }
  private static final dafny.TypeDescriptor<PlaceResults> _TYPE = dafny.TypeDescriptor.<PlaceResults>referenceWithInitializer(PlaceResults.class, () -> PlaceResults.Default());
  public static dafny.TypeDescriptor<PlaceResults> _typeDescriptor() {
    return (dafny.TypeDescriptor<PlaceResults>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
