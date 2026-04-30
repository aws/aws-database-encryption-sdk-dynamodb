// Interface IStructuredEncryptionClient
// Dafny trait IStructuredEncryptionClient compiled into Java
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internaldafny.types;

@SuppressWarnings({"unchecked", "deprecation"})
public interface IStructuredEncryptionClient {
  public Wrappers_Compile.Result<EncryptStructureOutput, Error> EncryptStructure(EncryptStructureInput input);
  public Wrappers_Compile.Result<DecryptStructureOutput, Error> DecryptStructure(DecryptStructureInput input);
  public Wrappers_Compile.Result<EncryptPathStructureOutput, Error> EncryptPathStructure(EncryptPathStructureInput input);
  public Wrappers_Compile.Result<DecryptPathStructureOutput, Error> DecryptPathStructure(DecryptPathStructureInput input);
  public Wrappers_Compile.Result<ResolveAuthActionsOutput, Error> ResolveAuthActions(ResolveAuthActionsInput input);
}
