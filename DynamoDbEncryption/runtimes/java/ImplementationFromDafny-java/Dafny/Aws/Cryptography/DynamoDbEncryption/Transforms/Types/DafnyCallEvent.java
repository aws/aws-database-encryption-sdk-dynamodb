// Class DafnyCallEvent<I, O>
// Dafny class DafnyCallEvent<I, O> compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types;

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
import DynamoDBFilterExpr_Compile.*;
import DynamoDBIndexSupport_Compile.*;
import DynamoDBSupport_Compile.*;
import Dafny.Aws.Cryptography.DynamoDbEncryption.ItemEncryptor.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class DafnyCallEvent<I, O> {
  public I _input;
  public O _output;
  public DafnyCallEvent (I input, O output) {
    this._input = input;
    this._output = output;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    DafnyCallEvent<I, O> o = (DafnyCallEvent<I, O>)other;
    return true && java.util.Objects.equals(this._input, o._input) && java.util.Objects.equals(this._output, o._output);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._input);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._output);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types_Compile.DafnyCallEvent.DafnyCallEvent");
    s.append("(");
    s.append(dafny.Helpers.toString(this._input));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._output));
    s.append(")");
    return s.toString();
  }

  public static <I, O> DafnyCallEvent<I, O> Default(I _default_I, O _default_O) {
    dafny.TypeDescriptor<I> _td_I = (dafny.TypeDescriptor<I>)dafny.TypeDescriptor.OBJECT;
    dafny.TypeDescriptor<O> _td_O = (dafny.TypeDescriptor<O>)dafny.TypeDescriptor.OBJECT;
    return Dafny.Aws.Cryptography.DynamoDbEncryption.Transforms.Types.DafnyCallEvent.<I, O>create(_default_I, _default_O);
  }
  public static <I, O> dafny.TypeDescriptor<DafnyCallEvent<I, O>> _typeDescriptor(dafny.TypeDescriptor<I> _td_I, dafny.TypeDescriptor<O> _td_O) {
    return (dafny.TypeDescriptor<DafnyCallEvent<I, O>>) (dafny.TypeDescriptor<?>) dafny.TypeDescriptor.referenceWithInitializer(DafnyCallEvent.class, () -> Default(_td_I.defaultValue(), _td_O.defaultValue()));
  }
  public static <I, O> DafnyCallEvent<I, O> create(I input, O output) {
    return new DafnyCallEvent<I, O>(input, output);
  }
  public static <I, O> DafnyCallEvent<I, O> create_DafnyCallEvent(I input, O output) {
    return create(input, output);
  }
  public boolean is_DafnyCallEvent() { return true; }
  public I dtor_input() {
    return this._input;
  }
  public O dtor_output() {
    return this._output;
  }
}
