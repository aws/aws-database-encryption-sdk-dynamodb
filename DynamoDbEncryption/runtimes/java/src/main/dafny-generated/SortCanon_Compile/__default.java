// Class __default
// Dafny class __default compiled into Java
package SortCanon_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static boolean AuthBelow(StructuredEncryptionUtil_Compile.CanonAuthItem x, StructuredEncryptionUtil_Compile.CanonAuthItem y)
  {
    return __default.Below((x).dtor_key(), (y).dtor_key());
  }
  public static boolean CryptoBelow(StructuredEncryptionUtil_Compile.CanonCryptoItem x, StructuredEncryptionUtil_Compile.CanonCryptoItem y)
  {
    return __default.Below((x).dtor_key(), (y).dtor_key());
  }
  public static boolean Below(dafny.DafnySequence<? extends java.lang.Byte> x, dafny.DafnySequence<? extends java.lang.Byte> y)
  {
    boolean _hresult = false;
    _hresult = __default.BoundedBelow(x, y);
    return _hresult;
  }
  public static boolean BoundedBelow(dafny.DafnySequence<? extends java.lang.Byte> x, dafny.DafnySequence<? extends java.lang.Byte> y)
  {
    boolean _hresult = false;
    long _0_xLength;
    _0_xLength = (long) (x).cardinalityInt();
    long _1_yLength;
    _1_yLength = (long) (y).cardinalityInt();
    if (((_0_xLength) == 0 ? 0 : 1) == 0) {
      _hresult = true;
      return _hresult;
    }
    if (((_1_yLength) == 0 ? 0 : 1) == 0) {
      _hresult = false;
      return _hresult;
    }
    long _hi0 = _0_xLength;
    for (long _2_i = (long) 0L; java.lang.Long.compareUnsigned(_2_i, _hi0) < 0; _2_i++) {
      if (java.lang.Long.compareUnsigned(_1_yLength, _2_i) <= 0) {
        _hresult = false;
        return _hresult;
      } else if (java.lang.Integer.compareUnsigned(((byte)(java.lang.Object)((y).select(dafny.Helpers.unsignedToInt(_2_i)))), ((byte)(java.lang.Object)((x).select(dafny.Helpers.unsignedToInt(_2_i))))) < 0) {
        _hresult = false;
        return _hresult;
      } else if (java.lang.Integer.compareUnsigned(((byte)(java.lang.Object)((x).select(dafny.Helpers.unsignedToInt(_2_i)))), ((byte)(java.lang.Object)((y).select(dafny.Helpers.unsignedToInt(_2_i))))) < 0) {
        _hresult = true;
        return _hresult;
      } else {
      }
    }
    _hresult = true;
    return _hresult;
  }
  public static dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonAuthItem> AuthSort(dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonAuthItem> x)
  {
    dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonAuthItem> result = dafny.DafnySequence.<StructuredEncryptionUtil_Compile.CanonAuthItem> empty(StructuredEncryptionUtil_Compile.CanonAuthItem._typeDescriptor());
    if(true) {
      result = OptimizedMergeSort_Compile.__default.<StructuredEncryptionUtil_Compile.CanonAuthItem>MergeSortNat(StructuredEncryptionUtil_Compile.CanonAuthItem._typeDescriptor(), x, __default::AuthBelow);
    }
    return result;
  }
  public static dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem> CryptoSort(dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem> x)
  {
    dafny.DafnySequence<? extends StructuredEncryptionUtil_Compile.CanonCryptoItem> result = dafny.DafnySequence.<StructuredEncryptionUtil_Compile.CanonCryptoItem> empty(StructuredEncryptionUtil_Compile.CanonCryptoItem._typeDescriptor());
    if(true) {
      result = OptimizedMergeSort_Compile.__default.<StructuredEncryptionUtil_Compile.CanonCryptoItem>MergeSortNat(StructuredEncryptionUtil_Compile.CanonCryptoItem._typeDescriptor(), x, __default::CryptoBelow);
    }
    return result;
  }
  @Override
  public java.lang.String toString() {
    return "SortCanon._default";
  }
}
