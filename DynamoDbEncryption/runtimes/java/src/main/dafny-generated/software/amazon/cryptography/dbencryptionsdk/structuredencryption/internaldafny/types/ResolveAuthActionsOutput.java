// Class ResolveAuthActionsOutput
// Dafny class ResolveAuthActionsOutput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class ResolveAuthActionsOutput {
  public dafny.DafnySequence<? extends CryptoItem> _cryptoActions;
  public ResolveAuthActionsOutput (dafny.DafnySequence<? extends CryptoItem> cryptoActions) {
    this._cryptoActions = cryptoActions;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    ResolveAuthActionsOutput o = (ResolveAuthActionsOutput)other;
    return true && java.util.Objects.equals(this._cryptoActions, o._cryptoActions);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._cryptoActions);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.ResolveAuthActionsOutput.ResolveAuthActionsOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._cryptoActions));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<ResolveAuthActionsOutput> _TYPE = dafny.TypeDescriptor.<ResolveAuthActionsOutput>referenceWithInitializer(ResolveAuthActionsOutput.class, () -> ResolveAuthActionsOutput.Default());
  public static dafny.TypeDescriptor<ResolveAuthActionsOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<ResolveAuthActionsOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final ResolveAuthActionsOutput theDefault = ResolveAuthActionsOutput.create(dafny.DafnySequence.<CryptoItem> empty(CryptoItem._typeDescriptor()));
  public static ResolveAuthActionsOutput Default() {
    return theDefault;
  }
  public static ResolveAuthActionsOutput create(dafny.DafnySequence<? extends CryptoItem> cryptoActions) {
    return new ResolveAuthActionsOutput(cryptoActions);
  }
  public static ResolveAuthActionsOutput create_ResolveAuthActionsOutput(dafny.DafnySequence<? extends CryptoItem> cryptoActions) {
    return create(cryptoActions);
  }
  public boolean is_ResolveAuthActionsOutput() { return true; }
  public dafny.DafnySequence<? extends CryptoItem> dtor_cryptoActions() {
    return this._cryptoActions;
  }
}
