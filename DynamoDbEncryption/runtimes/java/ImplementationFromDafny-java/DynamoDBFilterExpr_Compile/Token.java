// Class Token
// Dafny class Token compiled into Java
package DynamoDBFilterExpr_Compile;

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
import Maps_Compile.*;
import AwsCryptographyStructuredEncryptionOperations_Compile.*;
import Dafny.Aws.Cryptography.StructuredEncryption.*;
import TermLoc_Compile.*;
import DdbVirtualFields_Compile.*;
import BaseBeacon_Compile.*;
import CompoundBeacon_Compile.*;
import SearchableEncryptionInfo_Compile.*;
import SearchConfigToInfo_Compile.*;
import DynamoDbUpdateExpr_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public abstract class Token {
  public Token() { }

  private static final Token theDefault = DynamoDBFilterExpr_Compile.Token.create_Attr(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<TermLoc_Compile.Selector> empty(TermLoc_Compile.Selector._typeDescriptor()));
  public static Token Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<Token> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(Token.class, () -> Default());
  public static dafny.TypeDescriptor<Token> _typeDescriptor() {
    return (dafny.TypeDescriptor<Token>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static Token create_Attr(dafny.DafnySequence<? extends Character> s, dafny.DafnySequence<? extends TermLoc_Compile.Selector> loc) {
    return new Token_Attr(s, loc);
  }
  public static Token create_Value(dafny.DafnySequence<? extends Character> s) {
    return new Token_Value(s);
  }
  public static Token create_Eq() {
    return new Token_Eq();
  }
  public static Token create_Ne() {
    return new Token_Ne();
  }
  public static Token create_Lt() {
    return new Token_Lt();
  }
  public static Token create_Gt() {
    return new Token_Gt();
  }
  public static Token create_Le() {
    return new Token_Le();
  }
  public static Token create_Ge() {
    return new Token_Ge();
  }
  public static Token create_Between() {
    return new Token_Between();
  }
  public static Token create_In() {
    return new Token_In();
  }
  public static Token create_Open() {
    return new Token_Open();
  }
  public static Token create_Close() {
    return new Token_Close();
  }
  public static Token create_Comma() {
    return new Token_Comma();
  }
  public static Token create_Not() {
    return new Token_Not();
  }
  public static Token create_And() {
    return new Token_And();
  }
  public static Token create_Or() {
    return new Token_Or();
  }
  public static Token create_AttributeExists() {
    return new Token_AttributeExists();
  }
  public static Token create_AttributeNotExists() {
    return new Token_AttributeNotExists();
  }
  public static Token create_AttributeType() {
    return new Token_AttributeType();
  }
  public static Token create_BeginsWith() {
    return new Token_BeginsWith();
  }
  public static Token create_Contains() {
    return new Token_Contains();
  }
  public static Token create_Size() {
    return new Token_Size();
  }
  public boolean is_Attr() { return this instanceof Token_Attr; }
  public boolean is_Value() { return this instanceof Token_Value; }
  public boolean is_Eq() { return this instanceof Token_Eq; }
  public boolean is_Ne() { return this instanceof Token_Ne; }
  public boolean is_Lt() { return this instanceof Token_Lt; }
  public boolean is_Gt() { return this instanceof Token_Gt; }
  public boolean is_Le() { return this instanceof Token_Le; }
  public boolean is_Ge() { return this instanceof Token_Ge; }
  public boolean is_Between() { return this instanceof Token_Between; }
  public boolean is_In() { return this instanceof Token_In; }
  public boolean is_Open() { return this instanceof Token_Open; }
  public boolean is_Close() { return this instanceof Token_Close; }
  public boolean is_Comma() { return this instanceof Token_Comma; }
  public boolean is_Not() { return this instanceof Token_Not; }
  public boolean is_And() { return this instanceof Token_And; }
  public boolean is_Or() { return this instanceof Token_Or; }
  public boolean is_AttributeExists() { return this instanceof Token_AttributeExists; }
  public boolean is_AttributeNotExists() { return this instanceof Token_AttributeNotExists; }
  public boolean is_AttributeType() { return this instanceof Token_AttributeType; }
  public boolean is_BeginsWith() { return this instanceof Token_BeginsWith; }
  public boolean is_Contains() { return this instanceof Token_Contains; }
  public boolean is_Size() { return this instanceof Token_Size; }
  public dafny.DafnySequence<? extends Character> dtor_s() {
    Token d = this;
    if (d instanceof Token_Attr) { return ((Token_Attr)d)._s; }
    return ((Token_Value)d)._s;
  }
  public dafny.DafnySequence<? extends TermLoc_Compile.Selector> dtor_loc() {
    Token d = this;
    return ((Token_Attr)d)._loc;
  }
}
