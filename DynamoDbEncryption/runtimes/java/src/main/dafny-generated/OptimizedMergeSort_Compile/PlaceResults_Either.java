// Class PlaceResults_Either
// Dafny class PlaceResults_Either compiled into Java
package OptimizedMergeSort_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class PlaceResults_Either extends PlaceResults {
  public PlaceResults_Either () {
    super();
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    PlaceResults_Either o = (PlaceResults_Either)other;
    return true;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 2;
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("OptimizedMergeSort.PlaceResults.Either");
    return s.toString();
  }
}
