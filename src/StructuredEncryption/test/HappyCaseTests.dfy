include "../../StandardLibrary/StandardLibrary.dfy"
include "../../StandardLibrary/UInt.dfy"
include "../src/StructuredEncryptionClient.dfy"
include "../model/AwsCryptographyStructuredEncryptionTypes.dfy"

module HappyCaseTests {
  import opened Wrappers
  import opened UInt = StandardLibrary.UInt
  import opened StandardLibrary
  import opened AwsCryptographyStructuredEncryptionTypes
  import StructuredEncryptionClient

  method {:test} TestEncryptStructure() {
    var client := new StructuredEncryptionClient.StructuredEncryptionClient();
    
    // This method is currently stubbed, so it doesn't matter what our input is
    var inputStructure := StructuredData(
      content := StructuredDataContent.terminal(Terminal := []),
      attributes := None()
    );
    var schema := CryptoSchema(
      content := CryptoSchemaContent.action(CryptoAction := CryptoAction.ENCRYPT_AND_SIGN),
      attributes := None()
    );

    var encryptRes := client.EncryptStructure(
      EncryptStructureInput(
        plaintextStructure:=inputStructure,
        cryptoSchema:=schema
      )
    );
    
    var stubbedBytes := [0x21, 0x64, 0x6c, 0x72, 0x6f, 0x77, 0x20, 0x2c, 0x6f, 0x6c, 0x6c, 0x65, 0x68];
    var expectedValue := StructuredData(
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

    expect encryptRes.Success?;
    expect encryptRes.value.ciphertextStructure == expectedValue;
  }

  method {:test} TestDecryptStructure() {
    var client := new StructuredEncryptionClient.StructuredEncryptionClient();
    
    // This method is currently stubbed, so it doesn't matter what our input is
    var inputStructure := StructuredData(
      content := StructuredDataContent.terminal(Terminal := []),
      attributes := None()
    );
    var schema := CryptoSchema(
      content := CryptoSchemaContent.action(CryptoAction := CryptoAction.ENCRYPT_AND_SIGN),
      attributes := None()
    );

    var encryptRes := client.DecryptStructure(
      DecryptStructureInput(
        ciphertextStructure:=inputStructure,
        cryptoSchema:=schema
      )
    );
    
    var stubbedBytes := [0x68, 0x65, 0x6c, 0x6c, 0x6f, 0x2c, 0x20, 0x77, 0x6f, 0x72, 0x6c, 0x64];
    var expectedValue := StructuredData(
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

    expect encryptRes.Success?;
    expect encryptRes.value.plaintextStructure == expectedValue;
  }
}
