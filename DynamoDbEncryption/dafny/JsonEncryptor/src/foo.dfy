include "Util.dfy"
include "JsonToStruct.dfy"

module {:options "-functionSyntax:4"} Foo {

  import opened StandardLibrary
  import opened JsonEncryptorUtil
  import opened AwsCryptographyDbEncryptionSdkDynamoDbJsonTypes
  import CMP = AwsCryptographyMaterialProvidersTypes
  import CSE = AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
  import opened Wrappers
  import JsonToStruct
  import opened JSON.Values

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

  opaque function {:opaque} {:fuel 0,0} SmithyJsonToObject2(item : Json) : (res :Result<JSON, string>)
    ensures res.Success? ==> res.value.Object?
  {
    var json :- if item.text? then
      JsonToStruct.StringToJson(item.text)
    else
      JsonToStruct.Utf8ToJson(item.utf8);

    // :- Need(json.Object?, "JSON to encrypt/decrypt must be an Object : " + JsonToStruct.SmithyJsonToString(item));
    :- Need(json.Object?, "bad");
    Success(json)
  }

  opaque function SmithyJsonToObject4(item : Json) : (res :Result<JSON, string>)
    // ensures res.Success? ==> res.value.Object?
  {
    Failure("foo")
  }

  method SmithyJsonToObject3(item : Json) returns (res :Result<JSON, string>)
    ensures res.Success? ==> res.value.Object?
  {
    var json :- if item.text? then
      JsonToStruct.StringToJson(item.text)
    else
      JsonToStruct.Utf8ToJson(item.utf8);

    :- Need(json.Object?, "JSON to encrypt/decrypt must be an Object : " + JsonToStruct.SmithyJsonToString(item));
    return Success(json);
  }

  // method {:vcs_split_on_every_assert} EncryptObject2(config: InternalConfig, input: EncryptObjectInput)
  method EncryptObject2(input: EncryptObjectInput)
  {
    //var origJson := JsonToStruct.SmithyJsonToObject2(input.plaintextObject).MapFailure(e => E(e));
    var origJson := SmithyJsonToObject2(input.plaintextObject);
    assert 3 == 3;
  }

}