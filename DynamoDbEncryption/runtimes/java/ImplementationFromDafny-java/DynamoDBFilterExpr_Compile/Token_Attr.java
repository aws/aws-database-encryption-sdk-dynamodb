// Class Token_Attr
// Dafny class Token_Attr compiled into Java
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
public class Token_Attr extends Token {
  public dafny.DafnySequence<? extends Character> _s;
  public dafny.DafnySequence<? extends TermLoc_Compile.Selector> _loc;
  public Token_Attr (dafny.DafnySequence<? extends Character> s, dafny.DafnySequence<? extends TermLoc_Compile.Selector> loc) {
    this._s = s;
    this._loc = loc;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    Token_Attr o = (Token_Attr)other;
    return true && java.util.Objects.equals(this._s, o._s) && java.util.Objects.equals(this._loc, o._loc);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._s);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._loc);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder ss = new StringBuilder();
    ss.append("DynamoDBFilterExpr_Compile.Token.Attr");
    ss.append("(");
    ss.append(dafny.Helpers.toString(this._s));
    ss.append(", ");
    ss.append(dafny.Helpers.toString(this._loc));
    ss.append(")");
    return ss.toString();
  }
}
