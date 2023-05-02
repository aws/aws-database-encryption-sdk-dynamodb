// Class CreateDynamoDbEncryptionBranchKeyIdSupplierOutput
// Dafny class CreateDynamoDbEncryptionBranchKeyIdSupplierOutput compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class CreateDynamoDbEncryptionBranchKeyIdSupplierOutput {
  public Dafny.Aws.Cryptography.MaterialProviders.Types.IBranchKeyIdSupplier _branchKeyIdSupplier;
  public CreateDynamoDbEncryptionBranchKeyIdSupplierOutput (Dafny.Aws.Cryptography.MaterialProviders.Types.IBranchKeyIdSupplier branchKeyIdSupplier) {
    this._branchKeyIdSupplier = branchKeyIdSupplier;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    CreateDynamoDbEncryptionBranchKeyIdSupplierOutput o = (CreateDynamoDbEncryptionBranchKeyIdSupplierOutput)other;
    return true && this._branchKeyIdSupplier == o._branchKeyIdSupplier;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._branchKeyIdSupplier);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Types_Compile.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._branchKeyIdSupplier));
    s.append(")");
    return s.toString();
  }

  private static final CreateDynamoDbEncryptionBranchKeyIdSupplierOutput theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Types.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput.create(null);
  public static CreateDynamoDbEncryptionBranchKeyIdSupplierOutput Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<CreateDynamoDbEncryptionBranchKeyIdSupplierOutput> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(CreateDynamoDbEncryptionBranchKeyIdSupplierOutput.class, () -> Default());
  public static dafny.TypeDescriptor<CreateDynamoDbEncryptionBranchKeyIdSupplierOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<CreateDynamoDbEncryptionBranchKeyIdSupplierOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static CreateDynamoDbEncryptionBranchKeyIdSupplierOutput create(Dafny.Aws.Cryptography.MaterialProviders.Types.IBranchKeyIdSupplier branchKeyIdSupplier) {
    return new CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(branchKeyIdSupplier);
  }
  public static CreateDynamoDbEncryptionBranchKeyIdSupplierOutput create_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(Dafny.Aws.Cryptography.MaterialProviders.Types.IBranchKeyIdSupplier branchKeyIdSupplier) {
    return create(branchKeyIdSupplier);
  }
  public boolean is_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput() { return true; }
  public Dafny.Aws.Cryptography.MaterialProviders.Types.IBranchKeyIdSupplier dtor_branchKeyIdSupplier() {
    return this._branchKeyIdSupplier;
  }
}
