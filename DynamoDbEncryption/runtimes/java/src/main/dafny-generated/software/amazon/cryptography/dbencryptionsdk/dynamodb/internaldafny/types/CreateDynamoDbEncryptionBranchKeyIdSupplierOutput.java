// Class CreateDynamoDbEncryptionBranchKeyIdSupplierOutput
// Dafny class CreateDynamoDbEncryptionBranchKeyIdSupplierOutput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class CreateDynamoDbEncryptionBranchKeyIdSupplierOutput {
  public software.amazon.cryptography.materialproviders.internaldafny.types.IBranchKeyIdSupplier _branchKeyIdSupplier;
  public CreateDynamoDbEncryptionBranchKeyIdSupplierOutput (software.amazon.cryptography.materialproviders.internaldafny.types.IBranchKeyIdSupplier branchKeyIdSupplier) {
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
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTypes.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._branchKeyIdSupplier));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<CreateDynamoDbEncryptionBranchKeyIdSupplierOutput> _TYPE = dafny.TypeDescriptor.<CreateDynamoDbEncryptionBranchKeyIdSupplierOutput>referenceWithInitializer(CreateDynamoDbEncryptionBranchKeyIdSupplierOutput.class, () -> CreateDynamoDbEncryptionBranchKeyIdSupplierOutput.Default());
  public static dafny.TypeDescriptor<CreateDynamoDbEncryptionBranchKeyIdSupplierOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<CreateDynamoDbEncryptionBranchKeyIdSupplierOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final CreateDynamoDbEncryptionBranchKeyIdSupplierOutput theDefault = CreateDynamoDbEncryptionBranchKeyIdSupplierOutput.create(null);
  public static CreateDynamoDbEncryptionBranchKeyIdSupplierOutput Default() {
    return theDefault;
  }
  public static CreateDynamoDbEncryptionBranchKeyIdSupplierOutput create(software.amazon.cryptography.materialproviders.internaldafny.types.IBranchKeyIdSupplier branchKeyIdSupplier) {
    return new CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(branchKeyIdSupplier);
  }
  public static CreateDynamoDbEncryptionBranchKeyIdSupplierOutput create_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(software.amazon.cryptography.materialproviders.internaldafny.types.IBranchKeyIdSupplier branchKeyIdSupplier) {
    return create(branchKeyIdSupplier);
  }
  public boolean is_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput() { return true; }
  public software.amazon.cryptography.materialproviders.internaldafny.types.IBranchKeyIdSupplier dtor_branchKeyIdSupplier() {
    return this._branchKeyIdSupplier;
  }
}
