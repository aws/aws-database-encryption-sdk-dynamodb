// Interface IStructuredEncryptionClient
// Dafny trait IStructuredEncryptionClient compiled into Java
package Dafny.Aws.Cryptography.StructuredEncryption.Types;


@SuppressWarnings({"unchecked", "deprecation"})
public interface IStructuredEncryptionClient {
  public Wrappers_Compile.Result<EncryptStructureOutput, Error> EncryptStructure(EncryptStructureInput input);
  public Wrappers_Compile.Result<DecryptStructureOutput, Error> DecryptStructure(DecryptStructureInput input);
}
