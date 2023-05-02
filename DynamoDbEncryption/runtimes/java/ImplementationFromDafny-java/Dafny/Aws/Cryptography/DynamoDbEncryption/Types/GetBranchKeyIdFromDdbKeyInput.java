// Class GetBranchKeyIdFromDdbKeyInput
// Dafny class GetBranchKeyIdFromDdbKeyInput compiled into Java
package Dafny.Aws.Cryptography.DynamoDbEncryption.Types;

import Dafny.Aws.Cryptography.StructuredEncryption.Types.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class GetBranchKeyIdFromDdbKeyInput {
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> _ddbKey;
  public GetBranchKeyIdFromDdbKeyInput (dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> ddbKey) {
    this._ddbKey = ddbKey;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    GetBranchKeyIdFromDdbKeyInput o = (GetBranchKeyIdFromDdbKeyInput)other;
    return true && java.util.Objects.equals(this._ddbKey, o._ddbKey);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._ddbKey);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Dafny.Aws.Cryptography.DynamoDbEncryption.Types_Compile.GetBranchKeyIdFromDdbKeyInput.GetBranchKeyIdFromDdbKeyInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._ddbKey));
    s.append(")");
    return s.toString();
  }

  private static final GetBranchKeyIdFromDdbKeyInput theDefault = Dafny.Aws.Cryptography.DynamoDbEncryption.Types.GetBranchKeyIdFromDdbKeyInput.create(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> empty());
  public static GetBranchKeyIdFromDdbKeyInput Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<GetBranchKeyIdFromDdbKeyInput> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(GetBranchKeyIdFromDdbKeyInput.class, () -> Default());
  public static dafny.TypeDescriptor<GetBranchKeyIdFromDdbKeyInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<GetBranchKeyIdFromDdbKeyInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static GetBranchKeyIdFromDdbKeyInput create(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> ddbKey) {
    return new GetBranchKeyIdFromDdbKeyInput(ddbKey);
  }
  public static GetBranchKeyIdFromDdbKeyInput create_GetBranchKeyIdFromDdbKeyInput(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> ddbKey) {
    return create(ddbKey);
  }
  public boolean is_GetBranchKeyIdFromDdbKeyInput() { return true; }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends Dafny.Com.Amazonaws.Dynamodb.Types.AttributeValue> dtor_ddbKey() {
    return this._ddbKey;
  }
}
