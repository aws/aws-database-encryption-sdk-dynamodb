// Class CreateDynamoDbEncryptionBranchKeyIdSupplierInput
// Dafny class CreateDynamoDbEncryptionBranchKeyIdSupplierInput compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class CreateDynamoDbEncryptionBranchKeyIdSupplierInput {
  public IDynamoDbKeyBranchKeyIdSupplier _ddbKeyBranchKeyIdSupplier;
  public CreateDynamoDbEncryptionBranchKeyIdSupplierInput (IDynamoDbKeyBranchKeyIdSupplier ddbKeyBranchKeyIdSupplier) {
    this._ddbKeyBranchKeyIdSupplier = ddbKeyBranchKeyIdSupplier;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    CreateDynamoDbEncryptionBranchKeyIdSupplierInput o = (CreateDynamoDbEncryptionBranchKeyIdSupplierInput)other;
    return true && this._ddbKeyBranchKeyIdSupplier == o._ddbKeyBranchKeyIdSupplier;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._ddbKeyBranchKeyIdSupplier);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Types_Compile.CreateDynamoDbEncryptionBranchKeyIdSupplierInput.CreateDynamoDbEncryptionBranchKeyIdSupplierInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._ddbKeyBranchKeyIdSupplier));
    s.append(")");
    return s.toString();
  }

  private static final CreateDynamoDbEncryptionBranchKeyIdSupplierInput theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierInput.create(null);
  public static CreateDynamoDbEncryptionBranchKeyIdSupplierInput Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<CreateDynamoDbEncryptionBranchKeyIdSupplierInput> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(CreateDynamoDbEncryptionBranchKeyIdSupplierInput.class, () -> Default());
  public static dafny.TypeDescriptor<CreateDynamoDbEncryptionBranchKeyIdSupplierInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<CreateDynamoDbEncryptionBranchKeyIdSupplierInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static CreateDynamoDbEncryptionBranchKeyIdSupplierInput create(IDynamoDbKeyBranchKeyIdSupplier ddbKeyBranchKeyIdSupplier) {
    return new CreateDynamoDbEncryptionBranchKeyIdSupplierInput(ddbKeyBranchKeyIdSupplier);
  }
  public static CreateDynamoDbEncryptionBranchKeyIdSupplierInput create_CreateDynamoDbEncryptionBranchKeyIdSupplierInput(IDynamoDbKeyBranchKeyIdSupplier ddbKeyBranchKeyIdSupplier) {
    return create(ddbKeyBranchKeyIdSupplier);
  }
  public boolean is_CreateDynamoDbEncryptionBranchKeyIdSupplierInput() { return true; }
  public IDynamoDbKeyBranchKeyIdSupplier dtor_ddbKeyBranchKeyIdSupplier() {
    return this._ddbKeyBranchKeyIdSupplier;
  }
}
