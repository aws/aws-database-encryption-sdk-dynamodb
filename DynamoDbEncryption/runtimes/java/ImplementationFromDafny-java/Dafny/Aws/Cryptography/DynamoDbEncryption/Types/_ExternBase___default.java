// Class _ExternBase___default
// Dafny class __default compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class _ExternBase___default {
  public _ExternBase___default() {
  }
  public static boolean IsValid__BeaconBitLength(int x) {
    return ((1) <= (x)) && ((x) <= (63));
  }
  public static boolean IsValid__BeaconVersionList(dafny.DafnySequence<? extends BeaconVersion> x) {
    return ((java.math.BigInteger.ONE).compareTo(java.math.BigInteger.valueOf((x).length())) <= 0) && ((java.math.BigInteger.valueOf((x).length())).compareTo(java.math.BigInteger.ONE) <= 0);
  }
  public static boolean IsValid__Char(dafny.DafnySequence<? extends Character> x) {
    return ((java.math.BigInteger.ONE).compareTo(java.math.BigInteger.valueOf((x).length())) <= 0) && ((java.math.BigInteger.valueOf((x).length())).compareTo(java.math.BigInteger.ONE) <= 0);
  }
  public static boolean IsValid__CompoundBeaconList(dafny.DafnySequence<? extends CompoundBeacon> x) {
    return (java.math.BigInteger.ONE).compareTo(java.math.BigInteger.valueOf((x).length())) <= 0;
  }
  public static boolean IsValid__ConstructorList(dafny.DafnySequence<? extends Constructor> x) {
    return (java.math.BigInteger.ONE).compareTo(java.math.BigInteger.valueOf((x).length())) <= 0;
  }
  public static boolean IsValid__ConstructorPartList(dafny.DafnySequence<? extends ConstructorPart> x) {
    return (java.math.BigInteger.ONE).compareTo(java.math.BigInteger.valueOf((x).length())) <= 0;
  }
  public static boolean IsValid__NonSensitivePartsList(dafny.DafnySequence<? extends NonSensitivePart> x) {
    return (java.math.BigInteger.ONE).compareTo(java.math.BigInteger.valueOf((x).length())) <= 0;
  }
  public static boolean IsValid__Prefix(dafny.DafnySequence<? extends Character> x) {
    return (java.math.BigInteger.ONE).compareTo(java.math.BigInteger.valueOf((x).length())) <= 0;
  }
  public static boolean IsValid__SensitivePartsList(dafny.DafnySequence<? extends SensitivePart> x) {
    return (java.math.BigInteger.ONE).compareTo(java.math.BigInteger.valueOf((x).length())) <= 0;
  }
  public static boolean IsValid__StandardBeaconList(dafny.DafnySequence<? extends StandardBeacon> x) {
    return (java.math.BigInteger.ONE).compareTo(java.math.BigInteger.valueOf((x).length())) <= 0;
  }
  public static boolean IsValid__TerminalLocation(dafny.DafnySequence<? extends Character> x) {
    return (java.math.BigInteger.ONE).compareTo(java.math.BigInteger.valueOf((x).length())) <= 0;
  }
  public static boolean IsValid__VersionNumber(int x) {
    return (1) <= (x);
  }
  public static boolean IsValid__VirtualFieldList(dafny.DafnySequence<? extends VirtualField> x) {
    return (java.math.BigInteger.ONE).compareTo(java.math.BigInteger.valueOf((x).length())) <= 0;
  }
  public static boolean IsValid__VirtualPartList(dafny.DafnySequence<? extends VirtualPart> x) {
    return (java.math.BigInteger.ONE).compareTo(java.math.BigInteger.valueOf((x).length())) <= 0;
  }
  public static boolean IsValid__VirtualTransformList(dafny.DafnySequence<? extends VirtualTransform> x) {
    return (java.math.BigInteger.ONE).compareTo(java.math.BigInteger.valueOf((x).length())) <= 0;
  }
  private static final dafny.TypeDescriptor<__default> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(__default.class, () -> (__default) null);
  public static dafny.TypeDescriptor<__default> _typeDescriptor() {
    return (dafny.TypeDescriptor<__default>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "Dafny.Aws.Cryptography.DynamoDbEncryption.Types_Compile._default";
  }
}
