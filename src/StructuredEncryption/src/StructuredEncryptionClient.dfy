include "../../StandardLibrary/StandardLibrary.dfy"
include "../../StandardLibrary/UInt.dfy"
include "../model/AwsCryptographyStructuredEncryptionTypes.dfy"

module {:extern "Dafny.Aws.StructuredEncryption.StructuredEncryptionClient"} StructuredEncryptionClient {
  import opened Wrappers
  import opened UInt = StandardLibrary.UInt
  import opened StandardLibrary
  import opened AwsCryptographyStructuredEncryptionTypes

  class StructuredEncryptionClient extends IStructuredEncryptionClient {
    
    constructor() {}

    predicate EncryptStructureEnsuresPublicly(
      input: EncryptStructureInput, 
      output: Result<EncryptStructureOutput, Error>)
    {
      true // TODO
    }

    predicate DecryptStructureEnsuresPublicly(
      input: DecryptStructureInput, 
      output: Result<DecryptStructureOutput, Error>)
    {
      true // TODO
    }

    method EncryptStructure(input: EncryptStructureInput)
        returns (output: Result<EncryptStructureOutput, Error>)
      modifies this`EncryptStructureHistoricalCallEvents
      ensures EncryptStructureEnsuresPublicly(input, output)
      ensures
      && 0 < |EncryptStructureHistoricalCallEvents|
      && Last(EncryptStructureHistoricalCallEvents) == DafnyCallEvent(input, output)
    {
      // TODO: Currently stubbed out to return a hardcoded StructuredData
      var stubbedBytes := [0x21, 0x64, 0x6c, 0x72, 0x6f, 0x77, 0x20, 0x2c, 0x6f, 0x6c, 0x6c, 0x65, 0x68];
      var stubbedStructure := StructuredData(
        content := StructuredDataContent.dataMap(
          StructuredDataMap := map[
            "foo" := StructuredData(
              content := StructuredDataContent.terminal(Terminal:=stubbedBytes),
              attributes := None()
            ),
            "bar" := StructuredData(
              content := StructuredDataContent.terminal(Terminal:=stubbedBytes),
              attributes := None()
            ),
            "fizzbuzz" := StructuredData(
              content := StructuredDataContent.terminal(Terminal:=stubbedBytes),
              attributes := None()
            )
          ]
        ),
        attributes := None()
      );

      var encryptOutput := EncryptStructureOutput(ciphertextStructure := stubbedStructure);

      output := Success(encryptOutput);
      EncryptStructureHistoricalCallEvents := EncryptStructureHistoricalCallEvents + [DafnyCallEvent(input, output)];
    }
    
    method DecryptStructure(input: DecryptStructureInput)
        returns (output: Result<DecryptStructureOutput, Error>)
      modifies this`DecryptStructureHistoricalCallEvents
      ensures DecryptStructureEnsuresPublicly(input, output)
      ensures
      && 0 < |DecryptStructureHistoricalCallEvents|
      && Last(DecryptStructureHistoricalCallEvents) == DafnyCallEvent(input, output)
    {
      // TODO: Currently stubbed out to return a hardcoded StructuredData
      var stubbedBytes := [0x68, 0x65, 0x6c, 0x6c, 0x6f, 0x2c, 0x20, 0x77, 0x6f, 0x72, 0x6c, 0x64];
      var stubbedStructure := StructuredData(
        content := StructuredDataContent.dataMap(
          StructuredDataMap := map[
            "foo" := StructuredData(
              content := StructuredDataContent.terminal(Terminal:=stubbedBytes),
              attributes := None()
            ),
            "bar" := StructuredData(
              content := StructuredDataContent.terminal(Terminal:=stubbedBytes),
              attributes := None()
            ),
            "fizzbuzz" := StructuredData(
              content := StructuredDataContent.terminal(Terminal:=stubbedBytes),
              attributes := None()
            )
          ]
        ),
        attributes := None()
      );

      var decryptOutput := DecryptStructureOutput(plaintextStructure := stubbedStructure);
      output := Success(decryptOutput);
      DecryptStructureHistoricalCallEvents := DecryptStructureHistoricalCallEvents + [DafnyCallEvent(input, output)];
    }
  }
}