include "Util.dfy"
include "JsonToStruct.dfy"

module Foo {

  import opened StandardLibrary
  import opened JsonEncryptorUtil
  import opened AwsCryptographyDbEncryptionSdkDynamoDbJsonTypes
  import CMP = AwsCryptographyMaterialProvidersTypes
  import CSE = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import opened Wrappers
  import JsonToStruct

  datatype Config = Config(
    nameonly logicalTableName : string,
    nameonly cmpClient : CMP.IAwsCryptographicMaterialProvidersClient,
    nameonly cmm: CMP.ICryptographicMaterialsManager,
    nameonly attributeActionsOnEncrypt: AttributeActions,
    nameonly allowedUnsignedAttributes: Option<seq<string>>,
    nameonly allowedUnsignedAttributePrefix: Option<string>,
    nameonly algorithmSuiteId: Option<CMP.DBEAlgorithmSuiteId>,
    nameonly structuredEncryption: CSE.IStructuredEncryptionClient
  )

  type InternalConfig = Config

  // method {:vcs_split_on_every_assert} EncryptObject2(config: InternalConfig, input: EncryptObjectInput)
  method EncryptObject2(input: EncryptObjectInput)
  {
    //var origJson := JsonToStruct.SmithyJsonToObject(input.plaintextObject).MapFailure(e => E(e));
    var origJson := JsonToStruct.SmithyJsonToObject(input.plaintextObject);
    assert 3 == 3;
  }

}