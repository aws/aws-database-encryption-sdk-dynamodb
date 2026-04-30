// Class __default
// Dafny class __default compiled into Java
package PathsTests_Compile;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static void TestSpecExamples()
  {
    dafny.DafnySequence<? extends Character> _0_tableName;
    _0_tableName = dafny.DafnySequence.asString("example_table");
    dafny.DafnySequence<? extends software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.PathSegment> _1_pathToTest;
    _1_pathToTest = StructuredEncryptionPaths_Compile.__default.StringToUniPath(dafny.DafnySequence.asString("name"));
    if (!((StructuredEncryptionPaths_Compile.__default.CanonPath(_0_tableName, _1_pathToTest)).equals(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(dafny.DafnySequence.<java.lang.Byte>concatenate(__default.example__table(), dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 1)), dafny.DafnySequence.<java.lang.Byte> of(((byte) ('$')))), dafny.DafnySequence.<java.lang.Byte> of((byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 4)), __default.name())))) {
      throw new dafny.DafnyHaltException("dafny/StructuredEncryption/test/Paths.dfy(26,4): " + (dafny.DafnySequence.asString("expectation violation")).verbatimString());
    }
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> example__table()
  {
    dafny.DafnySequence<? extends java.lang.Byte> _0_s = dafny.DafnySequence.<java.lang.Byte> of((byte) 101, (byte) 120, (byte) 97, (byte) 109, (byte) 112, (byte) 108, (byte) 101, (byte) 95, (byte) 116, (byte) 97, (byte) 98, (byte) 108, (byte) 101);
    return _0_s;
  }
  public static dafny.DafnySequence<? extends java.lang.Byte> name()
  {
    dafny.DafnySequence<? extends java.lang.Byte> _0_s = dafny.DafnySequence.<java.lang.Byte> of((byte) 110, (byte) 97, (byte) 109, (byte) 101);
    return _0_s;
  }
  @Override
  public java.lang.String toString() {
    return "PathsTests._default";
  }
}
