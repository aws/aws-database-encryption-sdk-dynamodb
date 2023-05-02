// Class CanonizeForDecryptInput
// Dafny class CanonizeForDecryptInput compiled into Java
package AwsCryptographyStructuredEncryptionOperations_Compile;

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

@SuppressWarnings({"unchecked", "deprecation"})
public class CanonizeForDecryptInput {
  public dafny.DafnySequence<? extends Character> _tableName;
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> _data;
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema> _authSchema;
  public dafny.DafnySequence<? extends java.lang.Byte> _legend;
  public CanonizeForDecryptInput (dafny.DafnySequence<? extends Character> tableName, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> data, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema> authSchema, dafny.DafnySequence<? extends java.lang.Byte> legend) {
    this._tableName = tableName;
    this._data = data;
    this._authSchema = authSchema;
    this._legend = legend;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    CanonizeForDecryptInput o = (CanonizeForDecryptInput)other;
    return true && java.util.Objects.equals(this._tableName, o._tableName) && java.util.Objects.equals(this._data, o._data) && java.util.Objects.equals(this._authSchema, o._authSchema) && java.util.Objects.equals(this._legend, o._legend);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._tableName);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._data);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._authSchema);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._legend);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyStructuredEncryptionOperations_Compile.CanonizeForDecryptInput.CanonizeForDecryptInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._tableName));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._data));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._authSchema));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._legend));
    s.append(")");
    return s.toString();
  }

  private static final CanonizeForDecryptInput theDefault = AwsCryptographyStructuredEncryptionOperations_Compile.CanonizeForDecryptInput.create(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> empty(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema> empty(), dafny.DafnySequence.<java.lang.Byte> empty(StructuredEncryptionHeader_Compile.LegendByte._typeDescriptor()));
  public static CanonizeForDecryptInput Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<CanonizeForDecryptInput> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(CanonizeForDecryptInput.class, () -> Default());
  public static dafny.TypeDescriptor<CanonizeForDecryptInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<CanonizeForDecryptInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static CanonizeForDecryptInput create(dafny.DafnySequence<? extends Character> tableName, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> data, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema> authSchema, dafny.DafnySequence<? extends java.lang.Byte> legend) {
    return new CanonizeForDecryptInput(tableName, data, authSchema, legend);
  }
  public static CanonizeForDecryptInput create_CanonizeForDecryptInput(dafny.DafnySequence<? extends Character> tableName, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> data, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema> authSchema, dafny.DafnySequence<? extends java.lang.Byte> legend) {
    return create(tableName, data, authSchema, legend);
  }
  public boolean is_CanonizeForDecryptInput() { return true; }
  public dafny.DafnySequence<? extends Character> dtor_tableName() {
    return this._tableName;
  }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> dtor_data() {
    return this._data;
  }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.AuthenticateSchema> dtor_authSchema() {
    return this._authSchema;
  }
  public dafny.DafnySequence<? extends java.lang.Byte> dtor_legend() {
    return this._legend;
  }
}
