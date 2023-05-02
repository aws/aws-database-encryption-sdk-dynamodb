// Class EncryptCanonData
// Dafny class EncryptCanonData compiled into Java
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
public class EncryptCanonData {
  public dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _encFields__c;
  public dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> _signedFields__c;
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> _data__c;
  public Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema _cryptoSchema;
  public EncryptCanonData (dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> encFields__c, dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> signedFields__c, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> data__c, Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema cryptoSchema) {
    this._encFields__c = encFields__c;
    this._signedFields__c = signedFields__c;
    this._data__c = data__c;
    this._cryptoSchema = cryptoSchema;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    EncryptCanonData o = (EncryptCanonData)other;
    return true && java.util.Objects.equals(this._encFields__c, o._encFields__c) && java.util.Objects.equals(this._signedFields__c, o._signedFields__c) && java.util.Objects.equals(this._data__c, o._data__c) && java.util.Objects.equals(this._cryptoSchema, o._cryptoSchema);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._encFields__c);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._signedFields__c);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._data__c);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._cryptoSchema);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyStructuredEncryptionOperations_Compile.EncryptCanonData.EncryptCanonData");
    s.append("(");
    s.append(dafny.Helpers.toString(this._encFields__c));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._signedFields__c));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._data__c));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._cryptoSchema));
    s.append(")");
    return s.toString();
  }

  private static final EncryptCanonData theDefault = AwsCryptographyStructuredEncryptionOperations_Compile.EncryptCanonData.create(dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>> empty(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor())), dafny.DafnySequence.<dafny.DafnySequence<? extends java.lang.Byte>> empty(dafny.DafnySequence.<java.lang.Byte>_typeDescriptor(StandardLibrary_mUInt_Compile.uint8._typeDescriptor())), dafny.DafnyMap.<dafny.DafnySequence<? extends java.lang.Byte>,Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> empty(), Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema.Default());
  public static EncryptCanonData Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<EncryptCanonData> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(EncryptCanonData.class, () -> Default());
  public static dafny.TypeDescriptor<EncryptCanonData> _typeDescriptor() {
    return (dafny.TypeDescriptor<EncryptCanonData>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static EncryptCanonData create(dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> encFields__c, dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> signedFields__c, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> data__c, Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema cryptoSchema) {
    return new EncryptCanonData(encFields__c, signedFields__c, data__c, cryptoSchema);
  }
  public static EncryptCanonData create_EncryptCanonData(dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> encFields__c, dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> signedFields__c, dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> data__c, Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema cryptoSchema) {
    return create(encFields__c, signedFields__c, data__c, cryptoSchema);
  }
  public boolean is_EncryptCanonData() { return true; }
  public dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> dtor_encFields__c() {
    return this._encFields__c;
  }
  public dafny.DafnySequence<? extends dafny.DafnySequence<? extends java.lang.Byte>> dtor_signedFields__c() {
    return this._signedFields__c;
  }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends java.lang.Byte>, ? extends Dafny.Aws.Cryptography.StructuredEncryption.Types.StructuredData> dtor_data__c() {
    return this._data__c;
  }
  public Dafny.Aws.Cryptography.StructuredEncryption.Types.CryptoSchema dtor_cryptoSchema() {
    return this._cryptoSchema;
  }
}
