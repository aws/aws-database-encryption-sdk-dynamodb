// Class ResolveAuthActionsInput
// Dafny class ResolveAuthActionsInput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class ResolveAuthActionsInput {
  public dafny.DafnySequence<? extends Character> _tableName;
  public dafny.DafnySequence<? extends AuthItem> _authActions;
  public dafny.DafnySequence<? extends java.lang.Byte> _headerBytes;
  public ResolveAuthActionsInput (dafny.DafnySequence<? extends Character> tableName, dafny.DafnySequence<? extends AuthItem> authActions, dafny.DafnySequence<? extends java.lang.Byte> headerBytes) {
    this._tableName = tableName;
    this._authActions = authActions;
    this._headerBytes = headerBytes;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    ResolveAuthActionsInput o = (ResolveAuthActionsInput)other;
    return true && java.util.Objects.equals(this._tableName, o._tableName) && java.util.Objects.equals(this._authActions, o._authActions) && java.util.Objects.equals(this._headerBytes, o._headerBytes);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._tableName);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._authActions);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._headerBytes);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.ResolveAuthActionsInput.ResolveAuthActionsInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._tableName));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._authActions));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._headerBytes));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<ResolveAuthActionsInput> _TYPE = dafny.TypeDescriptor.<ResolveAuthActionsInput>referenceWithInitializer(ResolveAuthActionsInput.class, () -> ResolveAuthActionsInput.Default());
  public static dafny.TypeDescriptor<ResolveAuthActionsInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<ResolveAuthActionsInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final ResolveAuthActionsInput theDefault = ResolveAuthActionsInput.create(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), dafny.DafnySequence.<AuthItem> empty(AuthItem._typeDescriptor()), dafny.DafnySequence.<java.lang.Byte> empty(BoundedInts_Compile.uint8._typeDescriptor()));
  public static ResolveAuthActionsInput Default() {
    return theDefault;
  }
  public static ResolveAuthActionsInput create(dafny.DafnySequence<? extends Character> tableName, dafny.DafnySequence<? extends AuthItem> authActions, dafny.DafnySequence<? extends java.lang.Byte> headerBytes) {
    return new ResolveAuthActionsInput(tableName, authActions, headerBytes);
  }
  public static ResolveAuthActionsInput create_ResolveAuthActionsInput(dafny.DafnySequence<? extends Character> tableName, dafny.DafnySequence<? extends AuthItem> authActions, dafny.DafnySequence<? extends java.lang.Byte> headerBytes) {
    return create(tableName, authActions, headerBytes);
  }
  public boolean is_ResolveAuthActionsInput() { return true; }
  public dafny.DafnySequence<? extends Character> dtor_tableName() {
    return this._tableName;
  }
  public dafny.DafnySequence<? extends AuthItem> dtor_authActions() {
    return this._authActions;
  }
  public dafny.DafnySequence<? extends java.lang.Byte> dtor_headerBytes() {
    return this._headerBytes;
  }
}
