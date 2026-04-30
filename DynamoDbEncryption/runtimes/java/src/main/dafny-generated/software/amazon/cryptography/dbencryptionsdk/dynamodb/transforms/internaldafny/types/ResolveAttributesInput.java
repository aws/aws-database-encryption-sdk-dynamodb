// Class ResolveAttributesInput
// Dafny class ResolveAttributesInput compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public class ResolveAttributesInput {
  public dafny.DafnySequence<? extends Character> _TableName;
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> _Item;
  public Wrappers_Compile.Option<java.lang.Integer> _Version;
  public ResolveAttributesInput (dafny.DafnySequence<? extends Character> TableName, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> Item, Wrappers_Compile.Option<java.lang.Integer> Version) {
    this._TableName = TableName;
    this._Item = Item;
    this._Version = Version;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    ResolveAttributesInput o = (ResolveAttributesInput)other;
    return true && java.util.Objects.equals(this._TableName, o._TableName) && java.util.Objects.equals(this._Item, o._Item) && java.util.Objects.equals(this._Version, o._Version);
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._TableName);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._Item);
    hash = ((hash << 5) + hash) + java.util.Objects.hashCode(this._Version);
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.ResolveAttributesInput.ResolveAttributesInput");
    s.append("(");
    s.append(dafny.Helpers.toString(this._TableName));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._Item));
    s.append(", ");
    s.append(dafny.Helpers.toString(this._Version));
    s.append(")");
    return s.toString();
  }
  private static final dafny.TypeDescriptor<ResolveAttributesInput> _TYPE = dafny.TypeDescriptor.<ResolveAttributesInput>referenceWithInitializer(ResolveAttributesInput.class, () -> ResolveAttributesInput.Default());
  public static dafny.TypeDescriptor<ResolveAttributesInput> _typeDescriptor() {
    return (dafny.TypeDescriptor<ResolveAttributesInput>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  private static final ResolveAttributesInput theDefault = ResolveAttributesInput.create(dafny.DafnySequence.<Character> empty(dafny.TypeDescriptor.CHAR), dafny.DafnyMap.<dafny.DafnySequence<? extends Character>,software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> empty(), Wrappers_Compile.Option.<java.lang.Integer>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.internaldafny.types.VersionNumber._typeDescriptor()));
  public static ResolveAttributesInput Default() {
    return theDefault;
  }
  public static ResolveAttributesInput create(dafny.DafnySequence<? extends Character> TableName, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> Item, Wrappers_Compile.Option<java.lang.Integer> Version) {
    return new ResolveAttributesInput(TableName, Item, Version);
  }
  public static ResolveAttributesInput create_ResolveAttributesInput(dafny.DafnySequence<? extends Character> TableName, dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> Item, Wrappers_Compile.Option<java.lang.Integer> Version) {
    return create(TableName, Item, Version);
  }
  public boolean is_ResolveAttributesInput() { return true; }
  public dafny.DafnySequence<? extends Character> dtor_TableName() {
    return this._TableName;
  }
  public dafny.DafnyMap<? extends dafny.DafnySequence<? extends Character>, ? extends software.amazon.cryptography.services.dynamodb.internaldafny.types.AttributeValue> dtor_Item() {
    return this._Item;
  }
  public Wrappers_Compile.Option<java.lang.Integer> dtor_Version() {
    return this._Version;
  }
}
