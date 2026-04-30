// Class __default
// Dafny class __default compiled into Java
package OptimizedMergeSort_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static <__T> dafny.DafnySequence<? extends __T> MergeSort(dafny.TypeDescriptor<__T> _td___T, dafny.DafnySequence<? extends __T> s, dafny.Function2<__T, __T, Boolean> lessThanOrEq)
  {
    dafny.DafnySequence<? extends __T> result = dafny.DafnySequence.<__T> empty(_td___T);
    if(true) {
      if (java.lang.Long.compareUnsigned((long) (s).cardinalityInt(), (long) 1L) <= 0) {
        result = s;
        return result;
      } else {
        java.lang.Object _0_left;
        java.util.function.Function<java.math.BigInteger, __T> _init0 = ((java.util.function.Function<dafny.DafnySequence<? extends __T>, java.util.function.Function<java.math.BigInteger, __T>>)(_1_s) -> ((java.util.function.Function<java.math.BigInteger, __T>)(_2_i_boxed0) -> {
          java.math.BigInteger _2_i = ((java.math.BigInteger)(java.lang.Object)(_2_i_boxed0));
          return ((__T)(java.lang.Object)((_1_s).select(dafny.Helpers.unsignedToInt((_2_i).longValue()))));
        })).apply(s);
        java.lang.Object _nw0 = (java.lang.Object) _td___T.newArray(dafny.Helpers.toIntChecked(((long) (s).cardinalityInt()), "Java arrays may be no larger than the maximum 32-bit signed int"));
        for (java.math.BigInteger _i0_0 = java.math.BigInteger.ZERO; _i0_0.compareTo(java.math.BigInteger.valueOf(java.lang.reflect.Array.getLength(_nw0))) < 0; _i0_0 = _i0_0.add(java.math.BigInteger.ONE)) {
          _td___T.setArrayElement(_nw0, dafny.Helpers.toInt(_i0_0), ((__T)(java.lang.Object)(_init0.apply(_i0_0))));
        }
        _0_left = _nw0;
        java.lang.Object _3_right;
        java.util.function.Function<java.math.BigInteger, __T> _init1 = ((java.util.function.Function<dafny.DafnySequence<? extends __T>, java.util.function.Function<java.math.BigInteger, __T>>)(_4_s) -> ((java.util.function.Function<java.math.BigInteger, __T>)(_5_i_boxed0) -> {
          java.math.BigInteger _5_i = ((java.math.BigInteger)(java.lang.Object)(_5_i_boxed0));
          return ((__T)(java.lang.Object)((_4_s).select(dafny.Helpers.unsignedToInt((_5_i).longValue()))));
        })).apply(s);
        java.lang.Object _nw1 = (java.lang.Object) _td___T.newArray(dafny.Helpers.toIntChecked(((long) (s).cardinalityInt()), "Java arrays may be no larger than the maximum 32-bit signed int"));
        for (java.math.BigInteger _i0_1 = java.math.BigInteger.ZERO; _i0_1.compareTo(java.math.BigInteger.valueOf(java.lang.reflect.Array.getLength(_nw1))) < 0; _i0_1 = _i0_1.add(java.math.BigInteger.ONE)) {
          _td___T.setArrayElement(_nw1, dafny.Helpers.toInt(_i0_1), ((__T)(java.lang.Object)(_init1.apply(_i0_1))));
        }
        _3_right = _nw1;
        long _6_boundedLo;
        long _7_boundedHi;
        long _rhs0 = (long) 0L;
        long _rhs1 = (long) _td___T.getArrayLength((_3_right));
        _6_boundedLo = _rhs0;
        _7_boundedHi = _rhs1;
        PlaceResults _out0;
        _out0 = __default.<__T>MergeSortMethod(_td___T, _0_left, _3_right, lessThanOrEq, _6_boundedLo, _7_boundedHi, PlaceResults.create_Right());
        result = dafny.DafnySequence.fromRawArrayRange(_td___T, (_3_right), 0, java.lang.reflect.Array.getLength(_3_right));
      }
    }
    return result;
  }
  public static <__T> dafny.DafnySequence<? extends __T> MergeSortNat(dafny.TypeDescriptor<__T> _td___T, dafny.DafnySequence<? extends __T> s, dafny.Function2<__T, __T, Boolean> lessThanOrEq)
  {
    return __default.<__T>MergeSort(_td___T, s, lessThanOrEq);
  }
  public static <__T> PlaceResults MergeSortMethod(dafny.TypeDescriptor<__T> _td___T, java.lang.Object left, java.lang.Object right, dafny.Function2<__T, __T, Boolean> lessThanOrEq, long lo, long hi, PlaceResults where)
  {
    PlaceResults resultPlacement = (PlaceResults)null;
    if(true) {
      if (((long) (long) ((hi) - (lo))) == ((long) 1L)) {
        if (java.util.Objects.equals(where, PlaceResults.create_Right())) {
          _td___T.setArrayElement((right), dafny.Helpers.toInt(dafny.Helpers.unsignedToInt((lo))), _td___T.getArrayElement((left), (dafny.Helpers.unsignedToInt(lo))));
          resultPlacement = PlaceResults.create_Right();
          return resultPlacement;
        } else {
          resultPlacement = PlaceResults.create_Left();
          return resultPlacement;
        }
      }
      long _0_mid;
      _0_mid = (long) (long) (((long) java.lang.Long.divideUnsigned((long) (long) ((hi) - (lo)), (long) 2L)) + (lo));
      PlaceResults _1_placement_q;
      PlaceResults _out0;
      _out0 = __default.<__T>MergeSortMethod(_td___T, left, right, lessThanOrEq, lo, _0_mid, PlaceResults.create_Either());
      _1_placement_q = _out0;
      PlaceResults _out1;
      _out1 = __default.<__T>MergeSortMethod(_td___T, left, right, lessThanOrEq, _0_mid, hi, _1_placement_q);
      if ((_1_placement_q).is_Left()) {
        __default.<__T>MergeIntoRight(_td___T, left, right, lessThanOrEq, lo, _0_mid, hi);
        PlaceResults _rhs0 = PlaceResults.create_Right();
        resultPlacement = _rhs0;
      } else {
        __default.<__T>MergeIntoRight(_td___T, right, left, lessThanOrEq, lo, _0_mid, hi);
        PlaceResults _rhs1 = PlaceResults.create_Left();
        resultPlacement = _rhs1;
      }
      goto_1: {
      }
      if (((resultPlacement).is_Left()) && (java.util.Objects.equals(where, PlaceResults.create_Right()))) {
        long _hi0 = hi;
        for (long _2_i = lo; java.lang.Long.compareUnsigned(_2_i, _hi0) < 0; _2_i++) {
          _td___T.setArrayElement((right), dafny.Helpers.toInt(dafny.Helpers.unsignedToInt((_2_i))), _td___T.getArrayElement((left), (dafny.Helpers.unsignedToInt(_2_i))));
        }
        resultPlacement = PlaceResults.create_Right();
      }
      if (((resultPlacement).is_Right()) && (java.util.Objects.equals(where, PlaceResults.create_Left()))) {
        long _hi1 = hi;
        for (long _3_i = lo; java.lang.Long.compareUnsigned(_3_i, _hi1) < 0; _3_i++) {
          _td___T.setArrayElement((left), dafny.Helpers.toInt(dafny.Helpers.unsignedToInt((_3_i))), _td___T.getArrayElement((right), (dafny.Helpers.unsignedToInt(_3_i))));
        }
        resultPlacement = PlaceResults.create_Left();
      }
    }
    return resultPlacement;
  }
  public static <__T> void MergeIntoRight(dafny.TypeDescriptor<__T> _td___T, java.lang.Object left, java.lang.Object right, dafny.Function2<__T, __T, Boolean> lessThanOrEq, long lo, long mid, long hi)
  {
    long _0_leftPosition;
    long _1_rightPosition;
    long _2_iter;
    long _rhs0 = lo;
    long _rhs1 = mid;
    long _rhs2 = lo;
    _0_leftPosition = _rhs0;
    _1_rightPosition = _rhs1;
    _2_iter = _rhs2;
    while (java.lang.Long.compareUnsigned(_2_iter, hi) < 0) {
      if (((_0_leftPosition) == (mid)) || ((java.lang.Long.compareUnsigned(_1_rightPosition, hi) < 0) && (((boolean)(java.lang.Object)((lessThanOrEq).apply(_td___T.getArrayElement((left), (dafny.Helpers.unsignedToInt(_1_rightPosition))), _td___T.getArrayElement((left), (dafny.Helpers.unsignedToInt(_0_leftPosition))))))))) {
        _td___T.setArrayElement((right), dafny.Helpers.toInt(dafny.Helpers.unsignedToInt((_2_iter))), _td___T.getArrayElement((left), (dafny.Helpers.unsignedToInt(_1_rightPosition))));
        long _rhs3 = (long) (long) ((_1_rightPosition) + ((long) 1L));
        long _rhs4 = (long) (long) ((_2_iter) + ((long) 1L));
        _1_rightPosition = _rhs3;
        _2_iter = _rhs4;
      } else {
        _td___T.setArrayElement((right), dafny.Helpers.toInt(dafny.Helpers.unsignedToInt((_2_iter))), _td___T.getArrayElement((left), (dafny.Helpers.unsignedToInt(_0_leftPosition))));
        long _rhs5 = (long) (long) ((_0_leftPosition) + ((long) 1L));
        long _rhs6 = (long) (long) ((_2_iter) + ((long) 1L));
        _0_leftPosition = _rhs5;
        _2_iter = _rhs6;
      }
    }
  }
  @Override
  public java.lang.String toString() {
    return "OptimizedMergeSort._default";
  }
}
