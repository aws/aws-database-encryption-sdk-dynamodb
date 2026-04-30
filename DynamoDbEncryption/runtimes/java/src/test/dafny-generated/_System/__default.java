// Class __default
// Dafny class __default compiled into Java
package _System;

@SuppressWarnings({"unchecked", "deprecation"})
public class __default {
  public __default() {
  }
  public static void __Test____Main__(dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> __noArgsParameter)
  {
    boolean _0_success;
    _0_success = true;
    System.out.print((dafny.DafnySequence.asString("HappyCaseTests.TestRoundTrip: ")).verbatimString());
    try {
      {
        HappyCaseTests_Compile.__default.TestRoundTrip();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _1_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_1_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("PathsTests.TestSpecExamples: ")).verbatimString());
    try {
      {
        PathsTests_Compile.__default.TestSpecExamples();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _2_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_2_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestHeader.TestRoundTrip: ")).verbatimString());
    try {
      {
        TestHeader_Compile.__default.TestRoundTrip();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _3_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_3_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestHeader.TestRoundTripWithCommit: ")).verbatimString());
    try {
      {
        TestHeader_Compile.__default.TestRoundTripWithCommit();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _4_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_4_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestHeader.TestDuplicateContext: ")).verbatimString());
    try {
      {
        TestHeader_Compile.__default.TestDuplicateContext();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _5_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_5_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestHeader.TestOutOfOrderContext: ")).verbatimString());
    try {
      {
        TestHeader_Compile.__default.TestOutOfOrderContext();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _6_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_6_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestHeader.TestSchemaOrderAlpha: ")).verbatimString());
    try {
      {
        TestHeader_Compile.__default.TestSchemaOrderAlpha();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _7_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_7_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestHeader.TestSchemaOrderLength: ")).verbatimString());
    try {
      {
        TestHeader_Compile.__default.TestSchemaOrderLength();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _8_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_8_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestHeader.TestSchemaOrderLength2: ")).verbatimString());
    try {
      {
        TestHeader_Compile.__default.TestSchemaOrderLength2();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _9_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_9_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestStructuredEncryptionCrypt.TestFieldKey: ")).verbatimString());
    try {
      {
        TestStructuredEncryptionCrypt_Compile.__default.TestFieldKey();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _10_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_10_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoDbItemEncryptorTest.TestUnexpectedField: ")).verbatimString());
    try {
      {
        DynamoDbItemEncryptorTest_Compile.__default.TestUnexpectedField();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _11_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_11_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoDbItemEncryptorTest.TestMissingSortKey: ")).verbatimString());
    try {
      {
        DynamoDbItemEncryptorTest_Compile.__default.TestMissingSortKey();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _12_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_12_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoDbItemEncryptorTest.TestV2RoundTripComplexSwitch: ")).verbatimString());
    try {
      {
        DynamoDbItemEncryptorTest_Compile.__default.TestV2RoundTripComplexSwitch();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _13_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_13_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoDbItemEncryptorTest.TestV2RoundTripComplex: ")).verbatimString());
    try {
      {
        DynamoDbItemEncryptorTest_Compile.__default.TestV2RoundTripComplex();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _14_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_14_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoDbItemEncryptorTest.TestMissingContext: ")).verbatimString());
    try {
      {
        DynamoDbItemEncryptorTest_Compile.__default.TestMissingContext();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _15_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_15_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoDbItemEncryptorTest.TestV2RoundTrip: ")).verbatimString());
    try {
      {
        DynamoDbItemEncryptorTest_Compile.__default.TestV2RoundTrip();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _16_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_16_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoDbItemEncryptorTest.TestV2RoundTripSpecial: ")).verbatimString());
    try {
      {
        DynamoDbItemEncryptorTest_Compile.__default.TestV2RoundTripSpecial();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _17_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_17_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoDbItemEncryptorTest.TestRoundTrip: ")).verbatimString());
    try {
      {
        DynamoDbItemEncryptorTest_Compile.__default.TestRoundTrip();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _18_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_18_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoDbItemEncryptorTest.TestLargeRoundTrip: ")).verbatimString());
    try {
      {
        DynamoDbItemEncryptorTest_Compile.__default.TestLargeRoundTrip();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _19_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_19_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("GetItemTransformTest.TestGetItemInputPassthrough: ")).verbatimString());
    try {
      {
        GetItemTransformTest_Compile.__default.TestGetItemInputPassthrough();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _20_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_20_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("GetItemTransformTest.TestGetItemOutputPassthrough: ")).verbatimString());
    try {
      {
        GetItemTransformTest_Compile.__default.TestGetItemOutputPassthrough();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _21_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_21_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DdbStatementTest.TestEmptyStatement: ")).verbatimString());
    try {
      {
        DdbStatementTest_Compile.__default.TestEmptyStatement();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _22_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_22_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DdbStatementTest.TestInvalidStatement: ")).verbatimString());
    try {
      {
        DdbStatementTest_Compile.__default.TestInvalidStatement();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _23_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_23_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DdbStatementTest.TestStatementInvalidTable: ")).verbatimString());
    try {
      {
        DdbStatementTest_Compile.__default.TestStatementInvalidTable();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _24_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_24_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DdbStatementTest.TestSelectStatementCase: ")).verbatimString());
    try {
      {
        DdbStatementTest_Compile.__default.TestSelectStatementCase();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _25_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_25_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DdbStatementTest.TestInvalidStatements: ")).verbatimString());
    try {
      {
        DdbStatementTest_Compile.__default.TestInvalidStatements();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _26_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_26_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DdbStatementTest.TestTableQuotes: ")).verbatimString());
    try {
      {
        DdbStatementTest_Compile.__default.TestTableQuotes();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _27_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_27_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DdbStatementTest.TestExistsStatement: ")).verbatimString());
    try {
      {
        DdbStatementTest_Compile.__default.TestExistsStatement();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _28_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_28_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DdbStatementTest.TestExistsStatementErrors: ")).verbatimString());
    try {
      {
        DdbStatementTest_Compile.__default.TestExistsStatementErrors();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _29_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_29_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DdbStatementTest.TestSelectStatement: ")).verbatimString());
    try {
      {
        DdbStatementTest_Compile.__default.TestSelectStatement();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _30_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_30_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DdbStatementTest.TestSelectStatementWithIndex: ")).verbatimString());
    try {
      {
        DdbStatementTest_Compile.__default.TestSelectStatementWithIndex();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _31_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_31_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DdbStatementTest.TestUpdateFromDocs: ")).verbatimString());
    try {
      {
        DdbStatementTest_Compile.__default.TestUpdateFromDocs();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _32_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_32_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DdbStatementTest.TestSelectFromDocs: ")).verbatimString());
    try {
      {
        DdbStatementTest_Compile.__default.TestSelectFromDocs();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _33_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_33_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DdbStatementTest.TestDeleteFromDocs: ")).verbatimString());
    try {
      {
        DdbStatementTest_Compile.__default.TestDeleteFromDocs();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _34_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_34_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DdbStatementTest.TestExistsFromDocs: ")).verbatimString());
    try {
      {
        DdbStatementTest_Compile.__default.TestExistsFromDocs();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _35_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_35_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DdbStatementTest.TestInsertFromDocs: ")).verbatimString());
    try {
      {
        DdbStatementTest_Compile.__default.TestInsertFromDocs();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _36_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_36_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("ExecuteTransactionTransformTest.TestExecuteTransactionInputPassthrough: ")).verbatimString());
    try {
      {
        ExecuteTransactionTransformTest_Compile.__default.TestExecuteTransactionInputPassthrough();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _37_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_37_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("ExecuteTransactionTransformTest.TestExecuteTransactionInput: ")).verbatimString());
    try {
      {
        ExecuteTransactionTransformTest_Compile.__default.TestExecuteTransactionInput();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _38_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_38_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("ExecuteTransactionTransformTest.TestExecuteTransactionOutputTransform: ")).verbatimString());
    try {
      {
        ExecuteTransactionTransformTest_Compile.__default.TestExecuteTransactionOutputTransform();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _39_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_39_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("BatchWriteItemTransformTest.TestBatchWriteItemInputTransform: ")).verbatimString());
    try {
      {
        BatchWriteItemTransformTest_Compile.__default.TestBatchWriteItemInputTransform();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _40_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_40_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("BatchWriteItemTransformTest.TestBatchWriteItemOutputTransform: ")).verbatimString());
    try {
      {
        BatchWriteItemTransformTest_Compile.__default.TestBatchWriteItemOutputTransform();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _41_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_41_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("BatchWriteItemTransformTest.TestBatchWriteItemOutputTransformUnprocessed: ")).verbatimString());
    try {
      {
        BatchWriteItemTransformTest_Compile.__default.TestBatchWriteItemOutputTransformUnprocessed();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _42_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_42_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("BatchWriteItemTransformTest.TestBatchWriteItemOutputTransformUnprocessed2: ")).verbatimString());
    try {
      {
        BatchWriteItemTransformTest_Compile.__default.TestBatchWriteItemOutputTransformUnprocessed2();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _43_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_43_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("BatchWriteItemTransformTest.TestBatchWriteItemOutputTransformUnprocessed3: ")).verbatimString());
    try {
      {
        BatchWriteItemTransformTest_Compile.__default.TestBatchWriteItemOutputTransformUnprocessed3();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _44_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_44_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("BatchWriteItemTransformTest.TestBatchWriteItemOutputTransformUnprocessed4: ")).verbatimString());
    try {
      {
        BatchWriteItemTransformTest_Compile.__default.TestBatchWriteItemOutputTransformUnprocessed4();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _45_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_45_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TransactGetItemsTransformTest.TestTransactGetItemsInputPassthrough: ")).verbatimString());
    try {
      {
        TransactGetItemsTransformTest_Compile.__default.TestTransactGetItemsInputPassthrough();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _46_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_46_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TransactGetItemsTransformTest.TestTransactGetItemsOutputPassthrough: ")).verbatimString());
    try {
      {
        TransactGetItemsTransformTest_Compile.__default.TestTransactGetItemsOutputPassthrough();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _47_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_47_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("BatchExecuteStatementTransformTest.TestBatchExecuteStatementInputPassthrough: ")).verbatimString());
    try {
      {
        BatchExecuteStatementTransformTest_Compile.__default.TestBatchExecuteStatementInputPassthrough();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _48_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_48_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("BatchExecuteStatementTransformTest.TestBatchExecuteStatementInputEncrypted: ")).verbatimString());
    try {
      {
        BatchExecuteStatementTransformTest_Compile.__default.TestBatchExecuteStatementInputEncrypted();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _49_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_49_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("BatchExecuteStatementTransformTest.TestBatchExecuteStatementOutputTransform: ")).verbatimString());
    try {
      {
        BatchExecuteStatementTransformTest_Compile.__default.TestBatchExecuteStatementOutputTransform();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _50_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_50_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("BatchGetItemTransformTest.TestBatchGetItemInputTransform: ")).verbatimString());
    try {
      {
        BatchGetItemTransformTest_Compile.__default.TestBatchGetItemInputTransform();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _51_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_51_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("BatchGetItemTransformTest.TestBatchGetItemOutputTransform: ")).verbatimString());
    try {
      {
        BatchGetItemTransformTest_Compile.__default.TestBatchGetItemOutputTransform();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _52_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_52_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("ScanTransformTest.TestScanInputPassthrough: ")).verbatimString());
    try {
      {
        ScanTransformTest_Compile.__default.TestScanInputPassthrough();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _53_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_53_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("ScanTransformTest.TestScanOutputPassthrough: ")).verbatimString());
    try {
      {
        ScanTransformTest_Compile.__default.TestScanOutputPassthrough();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _54_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_54_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("UpdateItemTransformTest.TestUpdateItemInputPassthrough: ")).verbatimString());
    try {
      {
        UpdateItemTransformTest_Compile.__default.TestUpdateItemInputPassthrough();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _55_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_55_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("UpdateItemTransformTest.TestUpdateItemInputUpdateExpressionSigned: ")).verbatimString());
    try {
      {
        UpdateItemTransformTest_Compile.__default.TestUpdateItemInputUpdateExpressionSigned();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _56_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_56_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("UpdateItemTransformTest.TestUpdateItemInputUpdateExpressionEncrypted: ")).verbatimString());
    try {
      {
        UpdateItemTransformTest_Compile.__default.TestUpdateItemInputUpdateExpressionEncrypted();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _57_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_57_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("UpdateItemTransformTest.TestUpdateItemInputUpdateExpressionPlain: ")).verbatimString());
    try {
      {
        UpdateItemTransformTest_Compile.__default.TestUpdateItemInputUpdateExpressionPlain();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _58_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_58_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("UpdateItemTransformTest.TestUpdateItemOutputPassthrough: ")).verbatimString());
    try {
      {
        UpdateItemTransformTest_Compile.__default.TestUpdateItemOutputPassthrough();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _59_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_59_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("ExecuteStatementTransformTest.TestExecuteStatementInputPassthrough: ")).verbatimString());
    try {
      {
        ExecuteStatementTransformTest_Compile.__default.TestExecuteStatementInputPassthrough();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _60_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_60_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("ExecuteStatementTransformTest.TestExecuteStatementInputEncrypted: ")).verbatimString());
    try {
      {
        ExecuteStatementTransformTest_Compile.__default.TestExecuteStatementInputEncrypted();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _61_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_61_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("ExecuteStatementTransformTest.TestExecuteStatementOutput: ")).verbatimString());
    try {
      {
        ExecuteStatementTransformTest_Compile.__default.TestExecuteStatementOutput();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _62_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_62_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TransactWriteItemsTransformTest.TestTransactWriteItemsInputPassthrough: ")).verbatimString());
    try {
      {
        TransactWriteItemsTransformTest_Compile.__default.TestTransactWriteItemsInputPassthrough();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _63_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_63_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TransactWriteItemsTransformTest.TestTransactWriteItemsInputEmpty: ")).verbatimString());
    try {
      {
        TransactWriteItemsTransformTest_Compile.__default.TestTransactWriteItemsInputEmpty();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _64_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_64_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TransactWriteItemsTransformTest.TestTransactWriteItemsOutputTransform: ")).verbatimString());
    try {
      {
        TransactWriteItemsTransformTest_Compile.__default.TestTransactWriteItemsOutputTransform();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _65_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_65_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("PutItemTransformTest.TestPutItemInputPassthrough: ")).verbatimString());
    try {
      {
        PutItemTransformTest_Compile.__default.TestPutItemInputPassthrough();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _66_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_66_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("PutItemTransformTest.TestPutItemInputMulti: ")).verbatimString());
    try {
      {
        PutItemTransformTest_Compile.__default.TestPutItemInputMulti();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _67_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_67_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("PutItemTransformTest.TestPutItemInputMultiForceAllow: ")).verbatimString());
    try {
      {
        PutItemTransformTest_Compile.__default.TestPutItemInputMultiForceAllow();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _68_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_68_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("PutItemTransformTest.TestPutItemOutputPassthrough: ")).verbatimString());
    try {
      {
        PutItemTransformTest_Compile.__default.TestPutItemOutputPassthrough();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _69_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_69_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DeleteItemTransformTest.TestDeleteItemInputPassthrough: ")).verbatimString());
    try {
      {
        DeleteItemTransformTest_Compile.__default.TestDeleteItemInputPassthrough();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _70_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_70_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DeleteItemTransformTest.TestDeleteItemOutputPassthrough: ")).verbatimString());
    try {
      {
        DeleteItemTransformTest_Compile.__default.TestDeleteItemOutputPassthrough();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _71_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_71_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("QueryTransformTest.TestQueryInputPassthrough: ")).verbatimString());
    try {
      {
        QueryTransformTest_Compile.__default.TestQueryInputPassthrough();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _72_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_72_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("QueryTransformTest.TestQueryOutputPassthrough: ")).verbatimString());
    try {
      {
        QueryTransformTest_Compile.__default.TestQueryOutputPassthrough();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _73_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_73_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDynamoDBFilterExpr.UnicodeLessTest: ")).verbatimString());
    try {
      {
        TestDynamoDBFilterExpr_Compile.__default.UnicodeLessTest();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _74_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_74_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDynamoDBFilterExpr.LowLevelTests: ")).verbatimString());
    try {
      {
        TestDynamoDBFilterExpr_Compile.__default.LowLevelTests();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _75_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_75_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDynamoDBFilterExpr.TestExtractAttributes: ")).verbatimString());
    try {
      {
        TestDynamoDBFilterExpr_Compile.__default.TestExtractAttributes();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _76_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_76_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDynamoDBFilterExpr.TestNoBeacons: ")).verbatimString());
    try {
      {
        TestDynamoDBFilterExpr_Compile.__default.TestNoBeacons();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _77_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_77_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDynamoDBFilterExpr.TestBasicParse: ")).verbatimString());
    try {
      {
        TestDynamoDBFilterExpr_Compile.__default.TestBasicParse();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _78_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_78_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDynamoDBFilterExpr.TestNoBeaconFail: ")).verbatimString());
    try {
      {
        TestDynamoDBFilterExpr_Compile.__default.TestNoBeaconFail();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _79_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_79_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDynamoDBFilterExpr.TestBasicBeacons: ")).verbatimString());
    try {
      {
        TestDynamoDBFilterExpr_Compile.__default.TestBasicBeacons();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _80_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_80_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDynamoDBFilterExpr.TestMultiContextFailures: ")).verbatimString());
    try {
      {
        TestDynamoDBFilterExpr_Compile.__default.TestMultiContextFailures();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _81_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_81_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDynamoDBFilterExpr.TestFilterCompare: ")).verbatimString());
    try {
      {
        TestDynamoDBFilterExpr_Compile.__default.TestFilterCompare();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _82_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_82_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDynamoDBFilterExpr.TestFilterFailNumeric: ")).verbatimString());
    try {
      {
        TestDynamoDBFilterExpr_Compile.__default.TestFilterFailNumeric();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _83_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_83_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDynamoDBFilterExpr.TestFilterCompareNumeric: ")).verbatimString());
    try {
      {
        TestDynamoDBFilterExpr_Compile.__default.TestFilterCompareNumeric();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _84_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_84_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDynamoDBFilterExpr.TestFilterIn: ")).verbatimString());
    try {
      {
        TestDynamoDBFilterExpr_Compile.__default.TestFilterIn();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _85_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_85_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDynamoDBFilterExpr.TestFilterBetweenAlpha: ")).verbatimString());
    try {
      {
        TestDynamoDBFilterExpr_Compile.__default.TestFilterBetweenAlpha();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _86_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_86_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDynamoDBFilterExpr.TestFilterBetweenNumber: ")).verbatimString());
    try {
      {
        TestDynamoDBFilterExpr_Compile.__default.TestFilterBetweenNumber();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _87_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_87_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDynamoDBFilterExpr.TestFilterSize: ")).verbatimString());
    try {
      {
        TestDynamoDBFilterExpr_Compile.__default.TestFilterSize();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _88_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_88_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDynamoDBFilterExpr.TestFilterContains: ")).verbatimString());
    try {
      {
        TestDynamoDBFilterExpr_Compile.__default.TestFilterContains();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _89_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_89_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDynamoDBFilterExpr.TestFilterBegins: ")).verbatimString());
    try {
      {
        TestDynamoDBFilterExpr_Compile.__default.TestFilterBegins();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _90_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_90_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDynamoDBFilterExpr.TestFilterComplex: ")).verbatimString());
    try {
      {
        TestDynamoDBFilterExpr_Compile.__default.TestFilterComplex();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _91_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_91_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDynamoDBFilterExpr.TestFilterIndirectNames: ")).verbatimString());
    try {
      {
        TestDynamoDBFilterExpr_Compile.__default.TestFilterIndirectNames();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _92_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_92_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDynamoDBFilterExpr.TestFilterIndirectNamesWithLoc: ")).verbatimString());
    try {
      {
        TestDynamoDBFilterExpr_Compile.__default.TestFilterIndirectNamesWithLoc();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _93_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_93_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDynamoDBFilterExpr.TestFilterAttrOps: ")).verbatimString());
    try {
      {
        TestDynamoDBFilterExpr_Compile.__default.TestFilterAttrOps();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _94_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_94_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDynamoDBFilterExpr.TestFilterSizeIn: ")).verbatimString());
    try {
      {
        TestDynamoDBFilterExpr_Compile.__default.TestFilterSizeIn();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _95_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_95_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDynamoDBFilterExpr.TestFilterBeacons: ")).verbatimString());
    try {
      {
        TestDynamoDBFilterExpr_Compile.__default.TestFilterBeacons();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _96_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_96_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDynamoDBFilterExpr.TestBadBetween: ")).verbatimString());
    try {
      {
        TestDynamoDBFilterExpr_Compile.__default.TestBadBetween();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _97_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_97_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDynamoDBFilterExpr.TestBadStandard: ")).verbatimString());
    try {
      {
        TestDynamoDBFilterExpr_Compile.__default.TestBadStandard();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _98_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_98_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDynamoDBFilterExpr.TestComparisons: ")).verbatimString());
    try {
      {
        TestDynamoDBFilterExpr_Compile.__default.TestComparisons();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _99_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_99_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestBaseBeacon.TestBeacon: ")).verbatimString());
    try {
      {
        TestBaseBeacon_Compile.__default.TestBeacon();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _100_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_100_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestBaseBeacon.TestBadPrefix: ")).verbatimString());
    try {
      {
        TestBaseBeacon_Compile.__default.TestBadPrefix();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _101_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_101_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestBaseBeacon.TestContainsSplit: ")).verbatimString());
    try {
      {
        TestBaseBeacon_Compile.__default.TestContainsSplit();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _102_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_102_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestBaseBeacon.TestOneBeaconValue: ")).verbatimString());
    try {
      {
        TestBaseBeacon_Compile.__default.TestOneBeaconValue();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _103_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_103_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestBaseBeacon.TestNumbersNormalize: ")).verbatimString());
    try {
      {
        TestBaseBeacon_Compile.__default.TestNumbersNormalize();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _104_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_104_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestBaseBeacon.TestSharedCacheBeaconsSingleKeyStoreWithSamePartitionId: ")).verbatimString());
    try {
      {
        TestBaseBeacon_Compile.__default.TestSharedCacheBeaconsSingleKeyStoreWithSamePartitionId();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _105_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_105_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestBaseBeacon.TestSharedCacheBeaconsSingleKeyStoreWithDifferentPartitionId: ")).verbatimString());
    try {
      {
        TestBaseBeacon_Compile.__default.TestSharedCacheBeaconsSingleKeyStoreWithDifferentPartitionId();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _106_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_106_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestBaseBeacon.TestSharedCacheBeaconsSingleKeyStoreWithUnspecifiedPartitionId: ")).verbatimString());
    try {
      {
        TestBaseBeacon_Compile.__default.TestSharedCacheBeaconsSingleKeyStoreWithUnspecifiedPartitionId();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _107_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_107_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestBaseBeacon.TestSharedCacheBeaconsMultiKeyStoreWithSamePartitionId: ")).verbatimString());
    try {
      {
        TestBaseBeacon_Compile.__default.TestSharedCacheBeaconsMultiKeyStoreWithSamePartitionId();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _108_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_108_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestBaseBeacon.TestSharedCacheBeaconsMultiKeyStoreWithDifferentPartitionId: ")).verbatimString());
    try {
      {
        TestBaseBeacon_Compile.__default.TestSharedCacheBeaconsMultiKeyStoreWithDifferentPartitionId();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _109_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_109_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestBaseBeacon.TestSharedCacheBeaconsMultiKeyStoreWithUnspecifiedPartitionId: ")).verbatimString());
    try {
      {
        TestBaseBeacon_Compile.__default.TestSharedCacheBeaconsMultiKeyStoreWithUnspecifiedPartitionId();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _110_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_110_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestBaseBeacon.TestBeaconValues: ")).verbatimString());
    try {
      {
        TestBaseBeacon_Compile.__default.TestBeaconValues();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _111_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_111_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestBaseBeacon.TestCompoundQueries: ")).verbatimString());
    try {
      {
        TestBaseBeacon_Compile.__default.TestCompoundQueries();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _112_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_112_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestBaseBeacon.TestQueryBeacons: ")).verbatimString());
    try {
      {
        TestBaseBeacon_Compile.__default.TestQueryBeacons();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _113_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_113_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestBaseBeacon.TestUnusedPartOnly: ")).verbatimString());
    try {
      {
        TestBaseBeacon_Compile.__default.TestUnusedPartOnly();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _114_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_114_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestBaseBeacon.TestCompoundWithUnknown: ")).verbatimString());
    try {
      {
        TestBaseBeacon_Compile.__default.TestCompoundWithUnknown();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _115_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_115_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestBaseBeacon.TesSetInCompound: ")).verbatimString());
    try {
      {
        TestBaseBeacon_Compile.__default.TesSetInCompound();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _116_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_116_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestBaseBeacon.SharedBadReferenceToCompound: ")).verbatimString());
    try {
      {
        TestBaseBeacon_Compile.__default.SharedBadReferenceToCompound();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _117_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_117_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestBaseBeacon.ChainedShare: ")).verbatimString());
    try {
      {
        TestBaseBeacon_Compile.__default.ChainedShare();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _118_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_118_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestBaseBeacon.SelfShare: ")).verbatimString());
    try {
      {
        TestBaseBeacon_Compile.__default.SelfShare();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _119_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_119_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestBaseBeacon.SharedBadReferenceNonExistent: ")).verbatimString());
    try {
      {
        TestBaseBeacon_Compile.__default.SharedBadReferenceNonExistent();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _120_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_120_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestBaseBeacon.SharedBadLength: ")).verbatimString());
    try {
      {
        TestBaseBeacon_Compile.__default.SharedBadLength();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _121_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_121_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestBaseBeacon.TestPartOnlyNotStored: ")).verbatimString());
    try {
      {
        TestBaseBeacon_Compile.__default.TestPartOnlyNotStored();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _122_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_122_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestBaseBeacon.TestShareSameBeacon: ")).verbatimString());
    try {
      {
        TestBaseBeacon_Compile.__default.TestShareSameBeacon();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _123_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_123_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestBaseBeacon.TestBeaconSetQuery: ")).verbatimString());
    try {
      {
        TestBaseBeacon_Compile.__default.TestBeaconSetQuery();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _124_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_124_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestBaseBeacon.TestSetNotSet: ")).verbatimString());
    try {
      {
        TestBaseBeacon_Compile.__default.TestSetNotSet();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _125_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_125_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestBaseBeacon.TestSharedSet: ")).verbatimString());
    try {
      {
        TestBaseBeacon_Compile.__default.TestSharedSet();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _126_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_126_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestBaseBeacon.GlobalPartNotExist: ")).verbatimString());
    try {
      {
        TestBaseBeacon_Compile.__default.GlobalPartNotExist();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _127_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_127_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestBaseBeacon.DuplicateGlobalSigned: ")).verbatimString());
    try {
      {
        TestBaseBeacon_Compile.__default.DuplicateGlobalSigned();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _128_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_128_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestBaseBeacon.DuplicateGlobalEncrypted: ")).verbatimString());
    try {
      {
        TestBaseBeacon_Compile.__default.DuplicateGlobalEncrypted();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _129_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_129_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestBaseBeacon.DuplicateGlobalPrefix: ")).verbatimString());
    try {
      {
        TestBaseBeacon_Compile.__default.DuplicateGlobalPrefix();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _130_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_130_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestBaseBeacon.DuplicateGlobalVsLocalEncrypted: ")).verbatimString());
    try {
      {
        TestBaseBeacon_Compile.__default.DuplicateGlobalVsLocalEncrypted();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _131_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_131_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestBaseBeacon.DuplicateGlobalVsLocalSigned: ")).verbatimString());
    try {
      {
        TestBaseBeacon_Compile.__default.DuplicateGlobalVsLocalSigned();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _132_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_132_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestBaseBeacon.CompoundNoConstructor: ")).verbatimString());
    try {
      {
        TestBaseBeacon_Compile.__default.CompoundNoConstructor();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _133_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_133_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestBaseBeacon.CompoundMixed: ")).verbatimString());
    try {
      {
        TestBaseBeacon_Compile.__default.CompoundMixed();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _134_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_134_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestBaseBeacon.CheckBytesToHex: ")).verbatimString());
    try {
      {
        TestBaseBeacon_Compile.__default.CheckBytesToHex();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _135_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_135_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoToStructTest.TestZeroBytes: ")).verbatimString());
    try {
      {
        DynamoToStructTest_Compile.__default.TestZeroBytes();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _136_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_136_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoToStructTest.TestBadType: ")).verbatimString());
    try {
      {
        DynamoToStructTest_Compile.__default.TestBadType();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _137_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_137_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoToStructTest.TestBadLengthList: ")).verbatimString());
    try {
      {
        DynamoToStructTest_Compile.__default.TestBadLengthList();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _138_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_138_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoToStructTest.TestBadLengthMap: ")).verbatimString());
    try {
      {
        DynamoToStructTest_Compile.__default.TestBadLengthMap();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _139_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_139_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoToStructTest.TestBadDupKeys: ")).verbatimString());
    try {
      {
        DynamoToStructTest_Compile.__default.TestBadDupKeys();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _140_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_140_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoToStructTest.TestEncode2: ")).verbatimString());
    try {
      {
        DynamoToStructTest_Compile.__default.TestEncode2();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _141_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_141_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoToStructTest.TestEncode: ")).verbatimString());
    try {
      {
        DynamoToStructTest_Compile.__default.TestEncode();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _142_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_142_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoToStructTest.TestNormalizeNAttr: ")).verbatimString());
    try {
      {
        DynamoToStructTest_Compile.__default.TestNormalizeNAttr();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _143_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_143_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoToStructTest.TestNormalizeNInSet: ")).verbatimString());
    try {
      {
        DynamoToStructTest_Compile.__default.TestNormalizeNInSet();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _144_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_144_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoToStructTest.TestNormalizeNInList: ")).verbatimString());
    try {
      {
        DynamoToStructTest_Compile.__default.TestNormalizeNInList();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _145_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_145_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoToStructTest.TestNormalizeNInMap: ")).verbatimString());
    try {
      {
        DynamoToStructTest_Compile.__default.TestNormalizeNInMap();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _146_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_146_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoToStructTest.TestSortNSAttr: ")).verbatimString());
    try {
      {
        DynamoToStructTest_Compile.__default.TestSortNSAttr();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _147_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_147_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoToStructTest.TestSortNSAfterNormalize: ")).verbatimString());
    try {
      {
        DynamoToStructTest_Compile.__default.TestSortNSAfterNormalize();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _148_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_148_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoToStructTest.TestSortSSAttr: ")).verbatimString());
    try {
      {
        DynamoToStructTest_Compile.__default.TestSortSSAttr();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _149_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_149_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoToStructTest.TestSortBSAttr: ")).verbatimString());
    try {
      {
        DynamoToStructTest_Compile.__default.TestSortBSAttr();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _150_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_150_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoToStructTest.TestSetsInListAreSorted: ")).verbatimString());
    try {
      {
        DynamoToStructTest_Compile.__default.TestSetsInListAreSorted();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _151_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_151_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoToStructTest.TestSetsInMapAreSorted: ")).verbatimString());
    try {
      {
        DynamoToStructTest_Compile.__default.TestSetsInMapAreSorted();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _152_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_152_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoToStructTest.TestSortMapKeys: ")).verbatimString());
    try {
      {
        DynamoToStructTest_Compile.__default.TestSortMapKeys();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _153_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_153_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoToStructTest.TestRoundTrip: ")).verbatimString());
    try {
      {
        DynamoToStructTest_Compile.__default.TestRoundTrip();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _154_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_154_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoToStructTest.TestMaxDepth: ")).verbatimString());
    try {
      {
        DynamoToStructTest_Compile.__default.TestMaxDepth();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _155_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_155_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoToStructTest.TestTooDeep: ")).verbatimString());
    try {
      {
        DynamoToStructTest_Compile.__default.TestTooDeep();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _156_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_156_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestUpdateExpr.TestExamples: ")).verbatimString());
    try {
      {
        TestUpdateExpr_Compile.__default.TestExamples();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _157_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_157_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDdbVirtualFields.TestUpper: ")).verbatimString());
    try {
      {
        TestDdbVirtualFields_Compile.__default.TestUpper();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _158_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_158_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDdbVirtualFields.TestLower: ")).verbatimString());
    try {
      {
        TestDdbVirtualFields_Compile.__default.TestLower();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _159_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_159_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDdbVirtualFields.TestInsert: ")).verbatimString());
    try {
      {
        TestDdbVirtualFields_Compile.__default.TestInsert();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _160_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_160_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDdbVirtualFields.TestPrefix: ")).verbatimString());
    try {
      {
        TestDdbVirtualFields_Compile.__default.TestPrefix();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _161_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_161_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDdbVirtualFields.TestSuffix: ")).verbatimString());
    try {
      {
        TestDdbVirtualFields_Compile.__default.TestSuffix();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _162_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_162_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDdbVirtualFields.TestSubstring: ")).verbatimString());
    try {
      {
        TestDdbVirtualFields_Compile.__default.TestSubstring();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _163_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_163_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDdbVirtualFields.TestSegment: ")).verbatimString());
    try {
      {
        TestDdbVirtualFields_Compile.__default.TestSegment();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _164_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_164_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDdbVirtualFields.TestSegments: ")).verbatimString());
    try {
      {
        TestDdbVirtualFields_Compile.__default.TestSegments();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _165_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_165_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDdbVirtualFields.TestVirtualField: ")).verbatimString());
    try {
      {
        TestDdbVirtualFields_Compile.__default.TestVirtualField();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _166_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_166_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDynamoDBConfigToInfo.TestTwoBeaconsOneLoc: ")).verbatimString());
    try {
      {
        TestDynamoDBConfigToInfo_Compile.__default.TestTwoBeaconsOneLoc();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _167_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_167_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDynamoDBConfigToInfo.TestTwoVirtOneLoc: ")).verbatimString());
    try {
      {
        TestDynamoDBConfigToInfo_Compile.__default.TestTwoVirtOneLoc();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _168_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_168_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDynamoDBConfigToInfo.TestVirtAndBeaconSameLoc: ")).verbatimString());
    try {
      {
        TestDynamoDBConfigToInfo_Compile.__default.TestVirtAndBeaconSameLoc();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _169_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_169_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDynamoDBConfigToInfo.TestNSwithEB: ")).verbatimString());
    try {
      {
        TestDynamoDBConfigToInfo_Compile.__default.TestNSwithEB();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _170_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_170_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDDBSupport.TestAddSignedBeacons: ")).verbatimString());
    try {
      {
        TestDDBSupport_Compile.__default.TestAddSignedBeacons();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _171_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_171_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestDDBSupport.TestMulti: ")).verbatimString());
    try {
      {
        TestDDBSupport_Compile.__default.TestMulti();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _172_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_172_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestNormalizeNumber.TestExtremes: ")).verbatimString());
    try {
      {
        TestNormalizeNumber_Compile.__default.TestExtremes();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _173_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_173_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestNormalizeNumber.TestFailures: ")).verbatimString());
    try {
      {
        TestNormalizeNumber_Compile.__default.TestFailures();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _174_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_174_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("TestNormalizeNumber.TestExamples: ")).verbatimString());
    try {
      {
        TestNormalizeNumber_Compile.__default.TestExamples();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _175_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_175_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoDbEncryptionBranchKeyIdSupplierTest.TestHappyCase: ")).verbatimString());
    try {
      {
        DynamoDbEncryptionBranchKeyIdSupplierTest_Compile.__default.TestHappyCase();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _176_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_176_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoDbGetEncryptedDataKeyDescriptionTest.TestHeaderInputAwsKmsDataKeyCase: ")).verbatimString());
    try {
      {
        DynamoDbGetEncryptedDataKeyDescriptionTest_Compile.__default.TestHeaderInputAwsKmsDataKeyCase();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _177_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_177_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoDbGetEncryptedDataKeyDescriptionTest.TestHeaderInputAwsKmsHDataKeyCase: ")).verbatimString());
    try {
      {
        DynamoDbGetEncryptedDataKeyDescriptionTest_Compile.__default.TestHeaderInputAwsKmsHDataKeyCase();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _178_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_178_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoDbGetEncryptedDataKeyDescriptionTest.TestHeaderInputRawRsaDataKeyDataKeyCase: ")).verbatimString());
    try {
      {
        DynamoDbGetEncryptedDataKeyDescriptionTest_Compile.__default.TestHeaderInputRawRsaDataKeyDataKeyCase();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _179_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_179_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoDbGetEncryptedDataKeyDescriptionTest.TestHeaderInputAwsKmsRsaDataKeyCase: ")).verbatimString());
    try {
      {
        DynamoDbGetEncryptedDataKeyDescriptionTest_Compile.__default.TestHeaderInputAwsKmsRsaDataKeyCase();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _180_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_180_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoDbGetEncryptedDataKeyDescriptionTest.TestDDBItemInputAwsKmsDataKeyCase: ")).verbatimString());
    try {
      {
        DynamoDbGetEncryptedDataKeyDescriptionTest_Compile.__default.TestDDBItemInputAwsKmsDataKeyCase();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _181_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_181_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoDbGetEncryptedDataKeyDescriptionTest.TestDDBItemInputAwsKmsHDataKeyCase: ")).verbatimString());
    try {
      {
        DynamoDbGetEncryptedDataKeyDescriptionTest_Compile.__default.TestDDBItemInputAwsKmsHDataKeyCase();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _182_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_182_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoDbGetEncryptedDataKeyDescriptionTest.TestDDBItemInputRawRsaDataKeyCase: ")).verbatimString());
    try {
      {
        DynamoDbGetEncryptedDataKeyDescriptionTest_Compile.__default.TestDDBItemInputRawRsaDataKeyCase();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _183_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_183_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoDbGetEncryptedDataKeyDescriptionTest.TestDDBItemInputAwsKmsRsaDataKeyCase: ")).verbatimString());
    try {
      {
        DynamoDbGetEncryptedDataKeyDescriptionTest_Compile.__default.TestDDBItemInputAwsKmsRsaDataKeyCase();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _184_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_184_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoDbGetEncryptedDataKeyDescriptionTest.TestHeaderMultiDataKeyCase: ")).verbatimString());
    try {
      {
        DynamoDbGetEncryptedDataKeyDescriptionTest_Compile.__default.TestHeaderMultiDataKeyCase();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _185_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_185_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoDbGetEncryptedDataKeyDescriptionTest.TestDDBItemInputMultiDataKeyCase: ")).verbatimString());
    try {
      {
        DynamoDbGetEncryptedDataKeyDescriptionTest_Compile.__default.TestDDBItemInputMultiDataKeyCase();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _186_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_186_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    System.out.print((dafny.DafnySequence.asString("DynamoDbGetEncryptedDataKeyDescriptionTest.TestNoHeaderFailureCase: ")).verbatimString());
    try {
      {
        DynamoDbGetEncryptedDataKeyDescriptionTest_Compile.__default.TestNoHeaderFailureCase();
        {
          System.out.print((dafny.DafnySequence.asString("PASSED\n")).verbatimString());
        }
      }
    }
    catch (dafny.DafnyHaltException e) {
      dafny.DafnySequence<Character> _187_haltMessage = dafny.DafnySequence.asString(e.getMessage());
      {
        System.out.print((dafny.DafnySequence.asString("FAILED\n	")).verbatimString());
        System.out.print((_187_haltMessage).verbatimString());
        System.out.print((dafny.DafnySequence.asString("\n")).verbatimString());
        _0_success = false;
      }
    }
    if (!(_0_success)) {
      throw new dafny.DafnyHaltException("<stdin>(1,0): " + (dafny.DafnySequence.asString("Test failures occurred: see above.\n")).verbatimString());
    }
  }
  public static void __Main(dafny.DafnySequence<? extends dafny.DafnySequence<? extends Character>> args) {
    __default.__Test____Main__(args);
  }
  @Override
  public java.lang.String toString() {
    return "_module._default";
  }
}
