// Class __default
// Dafny class __default compiled into Java
package Sets_Compile;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.Types.*;
import DynamoDbEncryptionUtil_Compile.*;
import DynamoDbNormalizeNumber_Compile.*;
import DynamoToStruct_Compile.*;
import DynamoDbEncryptionBranchKeyIdSupplier_Compile.*;
import AwsCryptographyDynamoDbEncryptionOperations_Compile.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.*;
import StructuredEncryptionUtil_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static <__X, __Y> dafny.DafnySet<? extends __Y> Map(dafny.TypeDescriptor<__X> _td___X, dafny.TypeDescriptor<__Y> _td___Y, dafny.DafnySet<? extends __X> xs, java.util.function.Function<__X, __Y> f)
  {
    dafny.DafnySet<? extends __Y> _294_ys = ((dafny.Function2<dafny.DafnySet<? extends __X>, java.util.function.Function<__X, __Y>, dafny.DafnySet<? extends __Y>>)(_295_xs, _296_f) -> ((dafny.Function0<dafny.DafnySet<? extends __Y>>)(() -> {
      java.util.ArrayList<__Y> _coll7 = new java.util.ArrayList<>();
      for (__X _compr_7_boxed0 : (_295_xs).Elements()) {
        __X _compr_7 = ((__X)(java.lang.Object)(_compr_7_boxed0));
        if (true) {
          __X _297_x = (__X)_compr_7;
          if ((_295_xs).<__X>contains(_297_x)) {
            _coll7.add(((__Y)(java.lang.Object)((_296_f).apply(_297_x))));
          }
        }
      }
      return new dafny.DafnySet<__Y>(_coll7);
    })).apply()).apply(xs, f);
    return _294_ys;
  }
  public static <__X> dafny.DafnySet<? extends __X> Filter(dafny.TypeDescriptor<__X> _td___X, dafny.DafnySet<? extends __X> xs, java.util.function.Function<__X, Boolean> f)
  {
    dafny.DafnySet<? extends __X> _298_ys = ((dafny.Function2<dafny.DafnySet<? extends __X>, java.util.function.Function<__X, Boolean>, dafny.DafnySet<? extends __X>>)(_299_xs, _300_f) -> ((dafny.Function0<dafny.DafnySet<? extends __X>>)(() -> {
      java.util.ArrayList<__X> _coll8 = new java.util.ArrayList<>();
      for (__X _compr_8_boxed0 : (_299_xs).Elements()) {
        __X _compr_8 = ((__X)(java.lang.Object)(_compr_8_boxed0));
        if (true) {
          __X _301_x = (__X)_compr_8;
          if (((_299_xs).<__X>contains(_301_x)) && (((boolean)(java.lang.Object)((_300_f).apply(_301_x))))) {
            _coll8.add(_301_x);
          }
        }
      }
      return new dafny.DafnySet<__X>(_coll8);
    })).apply()).apply(xs, f);
    return _298_ys;
  }
  public static dafny.DafnySet<? extends java.math.BigInteger> SetRange(java.math.BigInteger a, java.math.BigInteger b)
  {
    dafny.DafnySet<? extends java.math.BigInteger> _302___accumulator = dafny.DafnySet.<java.math.BigInteger> empty();
    TAIL_CALL_START: while (true) {
      if (java.util.Objects.equals(a, b)) {
        return dafny.DafnySet.<java.math.BigInteger>union(dafny.DafnySet.<java.math.BigInteger> empty(), _302___accumulator);
      } else {
        _302___accumulator = dafny.DafnySet.<java.math.BigInteger>union(_302___accumulator, dafny.DafnySet.of(a));
        java.math.BigInteger _in33 = (a).add(java.math.BigInteger.ONE);
        java.math.BigInteger _in34 = b;
        a = _in33;
        b = _in34;
        continue TAIL_CALL_START;
      }
    }
  }
  public static dafny.DafnySet<? extends java.math.BigInteger> SetRangeZeroBound(java.math.BigInteger n) {
    return __default.SetRange(java.math.BigInteger.ZERO, n);
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "Sets_Compile._default";
  }
}
