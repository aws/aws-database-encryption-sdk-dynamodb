// Class __default
// Dafny class __default compiled into Java
package Maps_Compile;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.*;
import DynamoDbEncryptionUtil_Compile.*;
import DynamoDbNormalizeNumber_Compile.*;
import DynamoToStruct_Compile.*;
import DynamoDbEncryptionBranchKeyIdSupplier_Compile.*;
import AwsCryptographyDynamoDbEncryptionOperations_Compile.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.*;
import StructuredEncryptionUtil_Compile.*;
import Sets_Compile.*;
import StructuredEncryptionPaths_Compile.*;
import StructuredEncryptionHeader_Compile.*;
import StructuredEncryptionFooter_Compile.*;
import StructuredEncryptionCrypt_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static <__X, __Y> Wrappers_Compile.Option<__Y> Get(dafny.TypeDescriptor<__X> _td___X, dafny.TypeDescriptor<__Y> _td___Y, dafny.DafnyMap<? extends __X, ? extends __Y> m, __X x)
  {
    if ((m).<__X>contains(x)) {
      return Wrappers_Compile.Option.<__Y>create_Some(((__Y)(java.lang.Object)((m).get(x))));
    } else {
      return Wrappers_Compile.Option.<__Y>create_None();
    }
  }
  public static <__X, __Y> dafny.DafnyMap<? extends __X, ? extends __Y> ToImap(dafny.TypeDescriptor<__X> _td___X, dafny.TypeDescriptor<__Y> _td___Y, dafny.DafnyMap<? extends __X, ? extends __Y> m)
  {
    return ((java.util.function.Function<dafny.DafnyMap<? extends __X, ? extends __Y>, dafny.DafnyMap<? extends __X, ? extends __Y>>)(_537_m) -> ((dafny.Function0<dafny.DafnyMap<? extends __X, ? extends __Y>>)(() -> {
      java.util.HashMap<__X, __Y> _coll12 = new java.util.HashMap<>();
      for (__X _compr_12_boxed0 : (_537_m).keySet().Elements()) {
        __X _compr_12 = ((__X)(java.lang.Object)(_compr_12_boxed0));
        if (true) {
          __X _538_x = (__X)_compr_12;
          if ((_537_m).<__X>contains(_538_x)) {
            _coll12.put(_538_x,((__Y)(java.lang.Object)((_537_m).get(_538_x))));
          }
        }
      }
      return new dafny.DafnyMap<__X,__Y>(_coll12);
    })).apply()).apply(m);
  }
  public static <__X, __Y> dafny.DafnyMap<? extends __X, ? extends __Y> RemoveKeys(dafny.TypeDescriptor<__X> _td___X, dafny.TypeDescriptor<__Y> _td___Y, dafny.DafnyMap<? extends __X, ? extends __Y> m, dafny.DafnySet<? extends __X> xs)
  {
    return dafny.DafnyMap.<__X, __Y>subtract(m, xs);
  }
  public static <__X, __Y> dafny.DafnyMap<? extends __X, ? extends __Y> Remove(dafny.TypeDescriptor<__X> _td___X, dafny.TypeDescriptor<__Y> _td___Y, dafny.DafnyMap<? extends __X, ? extends __Y> m, __X x)
  {
    dafny.DafnyMap<? extends __X, ? extends __Y> _539_m_k = ((dafny.Function2<dafny.DafnyMap<? extends __X, ? extends __Y>, __X, dafny.DafnyMap<? extends __X, ? extends __Y>>)(_540_m, _541_x) -> ((dafny.Function0<dafny.DafnyMap<? extends __X, ? extends __Y>>)(() -> {
      java.util.HashMap<__X, __Y> _coll13 = new java.util.HashMap<>();
      for (__X _compr_13_boxed0 : (_540_m).keySet().Elements()) {
        __X _compr_13 = ((__X)(java.lang.Object)(_compr_13_boxed0));
        if (true) {
          __X _542_x_k = (__X)_compr_13;
          if (((_540_m).<__X>contains(_542_x_k)) && (!java.util.Objects.equals(_542_x_k, _541_x))) {
            _coll13.put(_542_x_k,((__Y)(java.lang.Object)((_540_m).get(_542_x_k))));
          }
        }
      }
      return new dafny.DafnyMap<__X,__Y>(_coll13);
    })).apply()).apply(m, x);
    return _539_m_k;
  }
  public static <__X, __Y> dafny.DafnyMap<? extends __X, ? extends __Y> Restrict(dafny.TypeDescriptor<__X> _td___X, dafny.TypeDescriptor<__Y> _td___Y, dafny.DafnyMap<? extends __X, ? extends __Y> m, dafny.DafnySet<? extends __X> xs)
  {
    return ((dafny.Function2<dafny.DafnySet<? extends __X>, dafny.DafnyMap<? extends __X, ? extends __Y>, dafny.DafnyMap<? extends __X, ? extends __Y>>)(_543_xs, _544_m) -> ((dafny.Function0<dafny.DafnyMap<? extends __X, ? extends __Y>>)(() -> {
      java.util.HashMap<__X, __Y> _coll14 = new java.util.HashMap<>();
      for (__X _compr_14_boxed0 : (_543_xs).Elements()) {
        __X _compr_14 = ((__X)(java.lang.Object)(_compr_14_boxed0));
        if (true) {
          __X _545_x = (__X)_compr_14;
          if (((_543_xs).<__X>contains(_545_x)) && ((_544_m).<__X>contains(_545_x))) {
            _coll14.put(_545_x,((__Y)(java.lang.Object)((_544_m).get(_545_x))));
          }
        }
      }
      return new dafny.DafnyMap<__X,__Y>(_coll14);
    })).apply()).apply(xs, m);
  }
  public static <__X, __Y> dafny.DafnyMap<? extends __X, ? extends __Y> Union(dafny.TypeDescriptor<__X> _td___X, dafny.TypeDescriptor<__Y> _td___Y, dafny.DafnyMap<? extends __X, ? extends __Y> m, dafny.DafnyMap<? extends __X, ? extends __Y> m_k)
  {
    return dafny.DafnyMap.<__X, __Y>merge(m, m_k);
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "Maps_Compile._default";
  }
}
