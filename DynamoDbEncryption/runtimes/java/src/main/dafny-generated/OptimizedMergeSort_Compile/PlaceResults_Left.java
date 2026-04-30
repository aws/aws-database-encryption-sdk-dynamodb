// Class PlaceResults_Left
// Dafny class PlaceResults_Left compiled into Java
package OptimizedMergeSort_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class PlaceResults_Left extends PlaceResults {
  public PlaceResults_Left () {
    super();
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    PlaceResults_Left o = (PlaceResults_Left)other;
    return true;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("OptimizedMergeSort.PlaceResults.Left");
    return s.toString();
  }
}
