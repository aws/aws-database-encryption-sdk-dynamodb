include "../../../../private-aws-encryption-sdk-dafny-staging/src/StandardLibrary/StandardLibrary.dfy"
include "../../Model/AwsCryptographyStructuredEncryptionTypes.dfy"

module EncryptStructureOperation {
  import opened Wrappers
  import opened StandardLibrary
  import Types = AwsCryptographyStructuredEncryptionTypes

  method EncryptStructure(input: Types.EncryptStructureInput)
      returns (output: Result<Types.EncryptStructureOutput, Types.Error>)
    ensures (
        || (input.cmm.Some? && input.keyring.Some?)
        || (input.cmm.None? && input.keyring.None?)
      ) ==> output.Failure?
    ensures
      var encryptionContextFields := if input.encryptionContext.Some? then input.encryptionContext.value.Keys else {};
      var requiredFields := if input.requiredContextFieldsOnDecrypt.Some? then input.requiredContextFieldsOnDecrypt.value else [];
      !(forall k :: k in requiredFields ==> k in encryptionContextFields) ==> output.Failure?
  {
    // Ensure a Keyring XOR a CMM was included on input, otherwise error
    :- Need(input.cmm.Some? || input.keyring.Some?,
      Types.Error.StructuredEncryptionException(
        message := "Invalid input: A Keyring or CMM MUST be supplied on input."));
    :- Need(input.cmm.None? || input.keyring.None?,
      Types.Error.StructuredEncryptionException(
        message := "Invalid input: Cannot recieve both a Keyring and a CMM on input."));

    // TODO Once verified, this information should probably move to some new EC datatype that combines this info
    // This datatype should live in the MPL.
    :- Need(input.requiredContextFieldsOnDecrypt.Some? ==> (
        && input.encryptionContext.Some?
        && forall k :: k in input.requiredContextFieldsOnDecrypt.value ==> k in input.encryptionContext.value.Keys),
      Types.Error.StructuredEncryptionException(
        message := "Invalid input: A Keyring or CMM MUST be supplied on input."));

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
  }
}