// Class GetBranchKeyIdFromDdbKeyOutput
// Dafny class GetBranchKeyIdFromDdbKeyOutput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class GetBranchKeyIdFromDdbKeyOutput {
  public dafny.DafnySequence<? extends Character> _branchKeyId;
  public GetBranchKeyIdFromDdbKeyOutput (dafny.DafnySequence<? extends Character> branchKeyId) {
    this._branchKeyId = branchKeyId;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    GetBranchKeyIdFromDdbKeyOutput o = (GetBranchKeyIdFromDdbKeyOutput)other;
    return true && java.util.Objects.equals(this._branchKeyId, o._branchKeyId);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._branchKeyId);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTypes.GetBranchKeyIdFromDdbKeyOutput.GetBranchKeyIdFromDdbKeyOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._branchKeyId));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<GetBranchKeyIdFromDdbKeyOutput> _TYPE = dafny.TypeDescriptor.<GetBranchKeyIdFromDdbKeyOutput>referenceWithInitializer(GetBranchKeyIdFromDdbKeyOutput.class, () -> GetBranchKeyIdFromDdbKeyOutput.Default());
  public static dafny.TypeDescriptor<GetBranchKeyIdFromDdbKeyOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<GetBranchKeyIdFromDdbKeyOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final GetBranchKeyIdFromDdbKeyOutput theDefault = GetBranchKeyIdFromDdbKeyOutput.create(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR));
  public static GetBranchKeyIdFromDdbKeyOutput Default() {
    return theDefault;
  }
  public static GetBranchKeyIdFromDdbKeyOutput create(dafny.DafnySequence<? extends Character> branchKeyId) {
    return new GetBranchKeyIdFromDdbKeyOutput(branchKeyId);
  }
  public static GetBranchKeyIdFromDdbKeyOutput create_GetBranchKeyIdFromDdbKeyOutput(dafny.DafnySequence<? extends Character> branchKeyId) {
    return create(branchKeyId);
  }
  public boolean is_GetBranchKeyIdFromDdbKeyOutput() { return true; }
  public dafny.DafnySequence<? extends Character> dtor_branchKeyId() {
    return this._branchKeyId;
  }
}
