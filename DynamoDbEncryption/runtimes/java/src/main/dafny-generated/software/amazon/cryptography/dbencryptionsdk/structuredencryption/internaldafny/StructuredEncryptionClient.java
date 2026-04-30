// Class StructuredEncryptionClient
// Dafny class StructuredEncryptionClient compiled into Java
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny;

@SuppressWarnings({"unchecked", "deprecation"})
public class StructuredEncryptionClient implements software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.IStructuredEncryptionClient {
  public StructuredEncryptionClient() {
    this._config = (AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations_Compile.Config)null;
  }
  public void __ctor(AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations_Compile.Config config)
  {
    (this)._config = config;
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptStructureOutput, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> EncryptStructure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptStructureInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptStructureOutput, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptStructureOutput, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptStructureOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptStructureOutput.Default());
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptStructureOutput, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _out0;
      _out0 = AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations_Compile.__default.EncryptStructure((this).config(), input);
      output = _out0;
    }
    return output;
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptStructureOutput, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> DecryptStructure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptStructureInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptStructureOutput, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptStructureOutput, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptStructureOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptStructureOutput.Default());
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptStructureOutput, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _out0;
      _out0 = AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations_Compile.__default.DecryptStructure((this).config(), input);
      output = _out0;
    }
    return output;
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptPathStructureOutput, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> EncryptPathStructure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptPathStructureInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptPathStructureOutput, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptPathStructureOutput, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptPathStructureOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptPathStructureOutput.Default());
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.EncryptPathStructureOutput, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _out0;
      _out0 = AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations_Compile.__default.EncryptPathStructure((this).config(), input);
      output = _out0;
    }
    return output;
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptPathStructureOutput, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> DecryptPathStructure(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptPathStructureInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptPathStructureOutput, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptPathStructureOutput, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptPathStructureOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptPathStructureOutput.Default());
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.DecryptPathStructureOutput, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _out0;
      _out0 = AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations_Compile.__default.DecryptPathStructure((this).config(), input);
      output = _out0;
    }
    return output;
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.ResolveAuthActionsOutput, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> ResolveAuthActions(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.ResolveAuthActionsInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.ResolveAuthActionsOutput, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.ResolveAuthActionsOutput, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.ResolveAuthActionsOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.ResolveAuthActionsOutput.Default());
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.ResolveAuthActionsOutput, software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types.Error> _out0;
      _out0 = AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations_Compile.__default.ResolveAuthActions((this).config(), input);
      output = _out0;
    }
    return output;
  }
  public AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations_Compile.Config _config;
  public AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations_Compile.Config config()
  {
    return this._config;
  }
  private static final dafny.TypeDescriptor<StructuredEncryptionClient> _TYPE = dafny.TypeDescriptor.<StructuredEncryptionClient>referenceWithInitializer(StructuredEncryptionClient.class, () -> (StructuredEncryptionClient) null);
  public static dafny.TypeDescriptor<StructuredEncryptionClient> _typeDescriptor() {
    return (dafny.TypeDescriptor<StructuredEncryptionClient>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "StructuredEncryption.StructuredEncryptionClient";
  }
}
