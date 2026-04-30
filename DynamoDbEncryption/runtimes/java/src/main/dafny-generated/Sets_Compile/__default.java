// Class __default
// Dafny class __default compiled into Java
package Sets_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static <__T> __T ExtractFromSingleton(dafny.TypeDescriptor<__T> _td___T, dafny.DafnySet<? extends __T> s)
  {
    return ((java.util.function.Function<java.math.BigInteger, __T>)((_let_dummy_0) -> {
      @SuppressWarnings({"unchecked", "deprecation"})
      __T _0_x = null;
      goto__ASSIGN_SUCH_THAT_0: {
        for (__T _assign_such_that_0_boxed0 : (s).Elements()) {
          __T _assign_such_that_0 = ((__T)(java.lang.Object)(_assign_such_that_0_boxed0));
          _0_x = (__T)_assign_such_that_0;
          if ((s).<__T>contains(_0_x)) {
            break goto__ASSIGN_SUCH_THAT_0;
          }
        }
        if (true) {
          throw new IllegalArgumentException("assign-such-that search produced no value");
        }
      }
      return _0_x;
    })).apply(java.math.BigInteger.valueOf(0));
  }
  public static <__X, __Y> dafny.DafnySet<? extends __Y> Map(dafny.TypeDescriptor<__X> _td___X, dafny.TypeDescriptor<__Y> _td___Y, dafny.DafnySet<? extends __X> xs, java.util.function.Function<__X, __Y> f)
  {
    dafny.DafnySet<? extends __Y> _0_ys = ((dafny.Function2<dafny.DafnySet<? extends __X>, java.util.function.Function<__X, __Y>, dafny.DafnySet<? extends __Y>>)(_1_xs, _2_f) -> ((dafny.Function0<dafny.DafnySet<? extends __Y>>)(() -> {
      java.util.ArrayList<__Y> _coll0 = new java.util.ArrayList<>();
      for (__X _compr_0_boxed0 : (_1_xs).Elements()) {
        __X _compr_0 = ((__X)(java.lang.Object)(_compr_0_boxed0));
        __X _3_x = (__X)_compr_0;
        if ((_1_xs).<__X>contains(_3_x)) {
          _coll0.add(((__Y)(java.lang.Object)((_2_f).apply(_3_x))));
        }
      }
      return new dafny.DafnySet<__Y>(_coll0);
    })).apply()).apply(xs, f);
    return _0_ys;
  }
  public static <__X> dafny.DafnySet<? extends __X> Filter(dafny.TypeDescriptor<__X> _td___X, dafny.DafnySet<? extends __X> xs, java.util.function.Function<__X, Boolean> f)
  {
    dafny.DafnySet<? extends __X> _0_ys = ((dafny.Function2<dafny.DafnySet<? extends __X>, java.util.function.Function<__X, Boolean>, dafny.DafnySet<? extends __X>>)(_1_xs, _2_f) -> ((dafny.Function0<dafny.DafnySet<? extends __X>>)(() -> {
      java.util.ArrayList<__X> _coll0 = new java.util.ArrayList<>();
      for (__X _compr_0_boxed0 : (_1_xs).Elements()) {
        __X _compr_0 = ((__X)(java.lang.Object)(_compr_0_boxed0));
        __X _3_x = (__X)_compr_0;
        if (((_1_xs).<__X>contains(_3_x)) && (((boolean)(java.lang.Object)((_2_f).apply(_3_x))))) {
          _coll0.add(_3_x);
        }
      }
      return new dafny.DafnySet<__X>(_coll0);
    })).apply()).apply(xs, f);
    return _0_ys;
  }
  public static dafny.DafnySet<? extends java.math.BigInteger> SetRange(java.math.BigInteger a, java.math.BigInteger b)
  {
    dafny.DafnySet<? extends java.math.BigInteger> _0___accumulator = dafny.DafnySet.<java.math.BigInteger> empty();
    TAIL_CALL_START: while (true) {
      if (java.util.Objects.equals(a, b)) {
        return dafny.DafnySet.<java.math.BigInteger>union(dafny.DafnySet.<java.math.BigInteger> empty(), _0___accumulator);
      } else {
        _0___accumulator = dafny.DafnySet.<java.math.BigInteger>union(_0___accumulator, dafny.DafnySet.<java.math.BigInteger> of(a));
        java.math.BigInteger _in0 = (a).add(java.math.BigInteger.ONE);
        java.math.BigInteger _in1 = b;
        a = _in0;
        b = _in1;
        continue TAIL_CALL_START;
      }
    }
  }
  public static dafny.DafnySet<? extends java.math.BigInteger> SetRangeZeroBound(java.math.BigInteger n) {
    return __default.SetRange(java.math.BigInteger.ZERO, n);
  }
  @Override
  public java.lang.String toString() {
    return "Sets._default";
  }
}
