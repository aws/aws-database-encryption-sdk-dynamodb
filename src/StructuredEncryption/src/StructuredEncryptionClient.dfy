include "../../../private-aws-encryption-sdk-dafny-staging/src/StandardLibrary/StandardLibrary.dfy"
// TODO including UInt in this file causes build issues. It complains of duplicate UInt modules...
include "../Model/AwsCryptographyStructuredEncryptionTypes.dfy"

module {:extern "Dafny.Aws.StructuredEncryption.StructuredEncryptionClient"} StructuredEncryptionClient {
  import opened Wrappers
  import opened StandardLibrary
  import Types = AwsCryptographyStructuredEncryptionTypes

  class StructuredEncryptionClient extends Types.IStructuredEncryptionClient {
    predicate ValidState()
    ensures ValidState() ==> History in Modifies
    {
      History in Modifies
    }
  
    constructor()
      ensures ValidState() && fresh(Modifies) && fresh(History)
    {
      History := new Types.IStructuredEncryptionClientCallHistory();
      Modifies := {History};
    }

    predicate EncryptStructureEnsuresPublicly(
      input: Types.EncryptStructureInput, 
      output: Result<Types.EncryptStructureOutput, Types.Error>)
    {
      true
    }

    predicate DecryptStructureEnsuresPublicly(
      input: Types.DecryptStructureInput, 
      output: Result<Types.DecryptStructureOutput, Types.Error>)
    {
      true
    }

    method EncryptStructure(input: Types.EncryptStructureInput)
        returns (output: Result<Types.EncryptStructureOutput, Types.Error>)
      requires ValidState()
      modifies Modifies - {History},
        History`EncryptStructure
      ensures EncryptStructureEnsuresPublicly(input, output)
      ensures History.EncryptStructure == old(History.EncryptStructure) + [Types.DafnyCallEvent(input, output)]
    {
      // Ensure a Keyring XOR a CMM was included on input, otherwise error
      :- Need(input.cmm.Some? || input.keyring.Some?,
        Types.Error.StructuredEncryptionException(
          message := "Invalid input: A Keyring or CMM MUST be supplied on input."));
      :- Need(input.cmm.None? || input.keyring.None?,
        Types.Error.StructuredEncryptionException(
          message := "Invalid input: Cannot recieve both a Keyring and a CMM on input."));

      // TODO: Currently stubbed out to return a hardcoded StructuredData
      var stubbedBytes := [0x21, 0x64, 0x6c, 0x72, 0x6f, 0x77, 0x20, 0x2c, 0x6f, 0x6c, 0x6c, 0x65, 0x68];
      var stubbedStructure := Types.StructuredData(
        content := Types.StructuredDataContent.dataMap(
          StructuredDataMap := map[
            "foo" := Types.StructuredData(
              content := Types.StructuredDataContent.terminal(Terminal:=stubbedBytes),
              attributes := None()
            ),
            "bar" := Types.StructuredData(
              content := Types.StructuredDataContent.terminal(Terminal:=stubbedBytes),
              attributes := None()
            ),
            "fizzbuzz" := Types.StructuredData(
              content := Types.StructuredDataContent.terminal(Terminal:=stubbedBytes),
              attributes := None()
            )
          ]
        ),
        attributes := None()
      );

      var encryptOutput := Types.EncryptStructureOutput(ciphertextStructure := stubbedStructure);

      output := Success(encryptOutput);
      History.EncryptStructure := History.EncryptStructure + [Types.DafnyCallEvent(input, output)];
    }
    
    method DecryptStructure(input: Types.DecryptStructureInput)
        returns (output: Result<Types.DecryptStructureOutput, Types.Error>)
      requires ValidState()
      modifies Modifies - {History},
        History`DecryptStructure
      ensures DecryptStructureEnsuresPublicly(input, output)
      ensures History.DecryptStructure == old(History.DecryptStructure) + [Types.DafnyCallEvent(input, output)]
    {
      // Ensure a Keyring XOR a CMM was included on input, otherwise error
      :- Need(input.cmm.Some? || input.keyring.Some?,
        Types.Error.StructuredEncryptionException(
          message := "Invalid input: A Keyring or CMM MUST be supplied on input."));
      :- Need(input.cmm.None? || input.keyring.None?,
        Types.Error.StructuredEncryptionException(
          message := "Invalid input: Cannot recieve both a Keyring and a CMM on input."));

      // Ensure CryptoSchemas is not empty
      :- Need(|input.cryptoSchemas| > 0,
        Types.Error.StructuredEncryptionException(
          message := "Invalid input: a non-empty Crypto Schema map must be supplied on input."));

      // TODO: Currently stubbed out to return a hardcoded StructuredData
      var stubbedBytes := [0x68, 0x65, 0x6c, 0x6c, 0x6f, 0x2c, 0x20, 0x77, 0x6f, 0x72, 0x6c, 0x64];
      var stubbedStructure := Types.StructuredData(
        content := Types.StructuredDataContent.dataMap(
          StructuredDataMap := map[
            "foo" := Types.StructuredData(
              content := Types.StructuredDataContent.terminal(Terminal:=stubbedBytes),
              attributes := None()
            ),
            "bar" := Types.StructuredData(
              content := Types.StructuredDataContent.terminal(Terminal:=stubbedBytes),
              attributes := None()
            ),
            "fizzbuzz" := Types.StructuredData(
              content := Types.StructuredDataContent.terminal(Terminal:=stubbedBytes),
              attributes := None()
            )
          ]
        ),
        attributes := None()
      );

      var decryptOutput := Types.DecryptStructureOutput(plaintextStructure := stubbedStructure);
      output := Success(decryptOutput);
      History.DecryptStructure := History.DecryptStructure + [Types.DafnyCallEvent(input, output)];
    }
  }
}