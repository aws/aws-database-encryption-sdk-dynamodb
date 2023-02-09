// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../Model/AwsCryptographyStructuredEncryptionTypes.dfy"

module StructuredEncryptionUtil {
  import opened AwsCryptographyStructuredEncryptionTypes
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import UTF8

  // These two should be part of the DDB layer, and passed in somehow
  // Or maybe part of AwsCryptographyStructuredEncryptionOperations.Config?
  const HeaderField := "aws_ddb_head"
  const FooterField := "aws_ddb_foot"

  const BYTES_TYPE_ID : seq<uint8> := [0xFF, 0xFF];

  type Bytes = seq<uint8>
  type GoodString = x : string | ValidString(x)
  predicate method ValidString(x : string)
  {
    && |x| <  UINT64_LIMIT
    && UTF8.Encode(x).Success?
  }

  // string to Error
  function method E(s : string) : Error {
    StructuredEncryptionException(message := s)
  }

  // Is the CryptoSchemaMap flat, i.e., does it contain only Actions?
  function method CryptoSchemaMapIsFlat(data : CryptoSchemaMap) : (ret : bool)
    ensures ret ==> (forall v <- data.Values :: v.content.Action?)
  {
    forall v <- data.Values :: v.content.Action? 
  }

  // Schema must contain only Actions
  function method AuthSchemaIsFlat(data : AuthenticateSchemaMap) : (ret : bool)
    ensures ret ==> (forall v <- data.Values :: v.content.Action?)
  {
    forall v <- data.Values :: v.content.Action? 
  }

  // Map must contain only Terminals
  function method DataMapIsFlat(data : StructuredDataMap) : (ret : bool)
    ensures ret ==> (forall v <- data.Values :: v.content.Terminal?)
  {
    forall v <- data.Values :: v.content.Terminal? 
  }

  // attibute is "authorized", a.k.a. included in the signature
  predicate method IsAuthAttr(x : CryptoAction)
  {
    x.ENCRYPT_AND_SIGN? || x.SIGN_ONLY?
  }

  // wrap a value in a StructuredData
  function method ValueToData(value : Bytes, typeId : Bytes)
    : StructuredData
    requires IsValid_TerminalTypeId(typeId)
  {
    StructuredData(
      content := StructuredDataContent.Terminal(
        Terminal := StructuredDataTerminal(
          typeId := typeId,
          value := value
        )
      ),
      attributes := None
    )
  }

  // extract a value from a StructuredData
  function method GetValue(data : StructuredData) : Bytes
    requires data.content.Terminal?
  {
    data.content.Terminal.value
  }
}