// Class __default
// Dafny class __default compiled into Java
package Maps_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static <__X, __Y> Wrappers_Compile.Option<__Y> Get(dafny.TypeDescriptor<__X> _td___X, dafny.TypeDescriptor<__Y> _td___Y, dafny.DafnyMap<? extends __X, ? extends __Y> m, __X x)
  {
    if ((m).<__X>contains(x)) {
      return Wrappers_Compile.Option.<__Y>create_Some(_td___Y, ((__Y)(java.lang.Object)((m).get(x))));
    } else {
      return Wrappers_Compile.Option.<__Y>create_None(_td___Y);
    }
  }
  public static <__X, __Y> dafny.DafnyMap<? extends __X, ? extends __Y> ToImap(dafny.TypeDescriptor<__X> _td___X, dafny.TypeDescriptor<__Y> _td___Y, dafny.DafnyMap<? extends __X, ? extends __Y> m)
  {
    return ((java.util.function.Function<dafny.DafnyMap<? extends __X, ? extends __Y>, dafny.DafnyMap<? extends __X, ? extends __Y>>)(_0_m) -> ((dafny.Function0<dafny.DafnyMap<? extends __X, ? extends __Y>>)(() -> {
      java.util.HashMap<__X, __Y> _coll0 = new java.util.HashMap<>();
      for (__X _compr_0_boxed0 : (_0_m).keySet().Elements()) {
        __X _compr_0 = ((__X)(java.lang.Object)(_compr_0_boxed0));
        __X _1_x = (__X)_compr_0;
        if ((_0_m).<__X>contains(_1_x)) {
          _coll0.put(_1_x,((__Y)(java.lang.Object)((_0_m).get(_1_x))));
        }
      }
      return new dafny.DafnyMap<__X,__Y>(_coll0);
    })).apply()).apply(m);
  }
  public static <__X, __Y> dafny.DafnyMap<? extends __X, ? extends __Y> RemoveKeys(dafny.TypeDescriptor<__X> _td___X, dafny.TypeDescriptor<__Y> _td___Y, dafny.DafnyMap<? extends __X, ? extends __Y> m, dafny.DafnySet<? extends __X> xs)
  {
    return dafny.DafnyMap.<__X, __Y>subtract(m, xs);
  }
  public static <__X, __Y> dafny.DafnyMap<? extends __X, ? extends __Y> Remove(dafny.TypeDescriptor<__X> _td___X, dafny.TypeDescriptor<__Y> _td___Y, dafny.DafnyMap<? extends __X, ? extends __Y> m, __X x)
  {
    dafny.DafnyMap<? extends __X, ? extends __Y> _0_m_k = ((dafny.Function2<dafny.DafnyMap<? extends __X, ? extends __Y>, __X, dafny.DafnyMap<? extends __X, ? extends __Y>>)(_1_m, _2_x) -> ((dafny.Function0<dafny.DafnyMap<? extends __X, ? extends __Y>>)(() -> {
      java.util.HashMap<__X, __Y> _coll0 = new java.util.HashMap<>();
      for (__X _compr_0_boxed0 : (_1_m).keySet().Elements()) {
        __X _compr_0 = ((__X)(java.lang.Object)(_compr_0_boxed0));
        __X _3_x_k = (__X)_compr_0;
        if (((_1_m).<__X>contains(_3_x_k)) && (!java.util.Objects.equals(_3_x_k, _2_x))) {
          _coll0.put(_3_x_k,((__Y)(java.lang.Object)((_1_m).get(_3_x_k))));
        }
      }
      return new dafny.DafnyMap<__X,__Y>(_coll0);
    })).apply()).apply(m, x);
    return _0_m_k;
  }
  public static <__X, __Y> dafny.DafnyMap<? extends __X, ? extends __Y> Restrict(dafny.TypeDescriptor<__X> _td___X, dafny.TypeDescriptor<__Y> _td___Y, dafny.DafnyMap<? extends __X, ? extends __Y> m, dafny.DafnySet<? extends __X> xs)
  {
    return ((dafny.Function2<dafny.DafnySet<? extends __X>, dafny.DafnyMap<? extends __X, ? extends __Y>, dafny.DafnyMap<? extends __X, ? extends __Y>>)(_0_xs, _1_m) -> ((dafny.Function0<dafny.DafnyMap<? extends __X, ? extends __Y>>)(() -> {
      java.util.HashMap<__X, __Y> _coll0 = new java.util.HashMap<>();
      for (__X _compr_0_boxed0 : (_0_xs).Elements()) {
        __X _compr_0 = ((__X)(java.lang.Object)(_compr_0_boxed0));
        __X _2_x = (__X)_compr_0;
        if (((_0_xs).<__X>contains(_2_x)) && ((_1_m).<__X>contains(_2_x))) {
          _coll0.put(_2_x,((__Y)(java.lang.Object)((_1_m).get(_2_x))));
        }
      }
      return new dafny.DafnyMap<__X,__Y>(_coll0);
    })).apply()).apply(xs, m);
  }
  public static <__X, __Y> dafny.DafnyMap<? extends __X, ? extends __Y> Union(dafny.TypeDescriptor<__X> _td___X, dafny.TypeDescriptor<__Y> _td___Y, dafny.DafnyMap<? extends __X, ? extends __Y> m, dafny.DafnyMap<? extends __X, ? extends __Y> m_k)
  {
    return dafny.DafnyMap.<__X, __Y>merge(m, m_k);
  }
  @Override
  public java.lang.String toString() {
    return "Maps._default";
  }
}
