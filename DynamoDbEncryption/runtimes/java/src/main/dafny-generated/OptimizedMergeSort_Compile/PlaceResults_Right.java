// Class PlaceResults_Right
// Dafny class PlaceResults_Right compiled into Java
package OptimizedMergeSort_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class PlaceResults_Right extends PlaceResults {
  public PlaceResults_Right () {
    super();
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    PlaceResults_Right o = (PlaceResults_Right)other;
    return true;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 1;
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("OptimizedMergeSort.PlaceResults.Right");
    return s.toString();
  }
}
