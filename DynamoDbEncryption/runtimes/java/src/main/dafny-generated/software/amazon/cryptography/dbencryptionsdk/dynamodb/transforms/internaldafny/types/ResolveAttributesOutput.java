// Class ResolveAttributesOutput
// Dafny class ResolveAttributesOutput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class ResolveAttributesOutput {
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>> _VirtualFields;
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>> _CompoundBeacons;
  public ResolveAttributesOutput (dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>> VirtualFields, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>> CompoundBeacons) {
    this._VirtualFields = VirtualFields;
    this._CompoundBeacons = CompoundBeacons;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    ResolveAttributesOutput o = (ResolveAttributesOutput)other;
    return true && java.util.Objects.equals(this._VirtualFields, o._VirtualFields) && java.util.Objects.equals(this._CompoundBeacons, o._CompoundBeacons);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._VirtualFields);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._CompoundBeacons);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ResolveAttributesOutput.ResolveAttributesOutput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._VirtualFields));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._CompoundBeacons));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<ResolveAttributesOutput> _TYPE = dafny.TypeDescriptor.<ResolveAttributesOutput>referenceWithInitializer(ResolveAttributesOutput.class, () -> ResolveAttributesOutput.Default());
  public static dafny.TypeDescriptor<ResolveAttributesOutput> _typeDescriptor() {
    return (dafny.TypeDescriptor<ResolveAttributesOutput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final ResolveAttributesOutput theDefault = ResolveAttributesOutput.create(dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,dafny.DafnySequence<? extends Character>> empty(), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,dafny.DafnySequence<? extends Character>> empty());
  public static ResolveAttributesOutput Default() {
    return theDefault;
  }
  public static ResolveAttributesOutput create(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>> VirtualFields, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>> CompoundBeacons) {
    return new ResolveAttributesOutput(VirtualFields, CompoundBeacons);
  }
  public static ResolveAttributesOutput create_ResolveAttributesOutput(dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>> VirtualFields, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>> CompoundBeacons) {
    return create(VirtualFields, CompoundBeacons);
  }
  public boolean is_ResolveAttributesOutput() { return true; }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>> dtor_VirtualFields() {
    return this._VirtualFields;
  }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends dafny.DafnySequence<? extends Character>> dtor_CompoundBeacons() {
    return this._CompoundBeacons;
  }
}
