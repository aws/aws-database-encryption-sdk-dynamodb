// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconVersion,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::BeaconVersion,
>{
    ::dafny_runtime::Rc::new(to_dafny_plain(value.clone()))
}

#[allow(dead_code)]
pub fn to_dafny_plain(
    value: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconVersion,
) -> crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::BeaconVersion{
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::BeaconVersion::BeaconVersion {
        version: value.version.clone().unwrap(),
 keyStore: crate::deps::aws_cryptography_keyStore::conversions::client::to_dafny(&value.key_store.clone().unwrap())
,
 keySource: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::beacon_key_source::to_dafny(&value.key_source.clone().unwrap())
,
 standardBeacons: ::dafny_runtime::dafny_runtime_conversions::vec_to_dafny_sequence(&value.standard_beacons.clone().unwrap(),
    |e| crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::standard_beacon::to_dafny(&e.clone())
,
)
,
 compoundBeacons: ::dafny_runtime::Rc::new(match &value.compound_beacons {
    Some(x) => crate::r#_Wrappers_Compile::Option::Some { value :
        ::dafny_runtime::dafny_runtime_conversions::vec_to_dafny_sequence(x,
            |e| crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::compound_beacon::to_dafny(&e.clone())
,
        )
    },
    None => crate::r#_Wrappers_Compile::Option::None {}
})
,
 virtualFields: ::dafny_runtime::Rc::new(match &value.virtual_fields {
    Some(x) => crate::r#_Wrappers_Compile::Option::Some { value :
        ::dafny_runtime::dafny_runtime_conversions::vec_to_dafny_sequence(x,
            |e| crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::virtual_field::to_dafny(&e.clone())
,
        )
    },
    None => crate::r#_Wrappers_Compile::Option::None {}
})
,
 encryptedParts: ::dafny_runtime::Rc::new(match &value.encrypted_parts {
    Some(x) => crate::r#_Wrappers_Compile::Option::Some { value :
        ::dafny_runtime::dafny_runtime_conversions::vec_to_dafny_sequence(x,
            |e| crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::encrypted_part::to_dafny(&e.clone())
,
        )
    },
    None => crate::r#_Wrappers_Compile::Option::None {}
})
,
 signedParts: ::dafny_runtime::Rc::new(match &value.signed_parts {
    Some(x) => crate::r#_Wrappers_Compile::Option::Some { value :
        ::dafny_runtime::dafny_runtime_conversions::vec_to_dafny_sequence(x,
            |e| crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::signed_part::to_dafny(&e.clone())
,
        )
    },
    None => crate::r#_Wrappers_Compile::Option::None {}
})
,
    }
}

#[allow(dead_code)]
pub fn option_to_dafny(
  value: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconVersion>,
) -> ::dafny_runtime::Rc<crate::_Wrappers_Compile::Option<::dafny_runtime::Rc<
  crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::BeaconVersion,
>>>{
    ::dafny_runtime::Rc::new(match value {
        ::std::option::Option::None => crate::_Wrappers_Compile::Option::None {},
        ::std::option::Option::Some(x) => crate::_Wrappers_Compile::Option::Some {
            value: ::dafny_runtime::Rc::new(to_dafny_plain(x)),
        },
    })
}

#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::BeaconVersion,
    >,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconVersion {
    plain_from_dafny(&*dafny_value)
}

#[allow(dead_code)]
pub fn plain_from_dafny(
    dafny_value: &crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::BeaconVersion,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconVersion {
    match dafny_value {
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::BeaconVersion::BeaconVersion {..} =>
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconVersion::builder()
                .set_version(Some( dafny_value.version() .clone() ))
 .set_key_store(Some( crate::deps::aws_cryptography_keyStore::conversions::client::from_dafny(dafny_value.keyStore().clone())
 ))
 .set_key_source(Some( crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::beacon_key_source::from_dafny(dafny_value.keySource().clone())
 ))
 .set_standard_beacons(Some( ::dafny_runtime::dafny_runtime_conversions::dafny_sequence_to_vec(dafny_value.standardBeacons(),
    |e: &::dafny_runtime::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::StandardBeacon>| crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::standard_beacon::from_dafny(e.clone())
,
)
 ))
 .set_compound_beacons(match (*dafny_value.compoundBeacons()).as_ref() {
    crate::r#_Wrappers_Compile::Option::Some { value } =>
        Some(
            ::dafny_runtime::dafny_runtime_conversions::dafny_sequence_to_vec(value,
                |e: &::dafny_runtime::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::CompoundBeacon>| crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::compound_beacon::from_dafny(e.clone())
,
            )
        ),
    _ => None
}
)
 .set_virtual_fields(match (*dafny_value.virtualFields()).as_ref() {
    crate::r#_Wrappers_Compile::Option::Some { value } =>
        Some(
            ::dafny_runtime::dafny_runtime_conversions::dafny_sequence_to_vec(value,
                |e: &::dafny_runtime::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::VirtualField>| crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::virtual_field::from_dafny(e.clone())
,
            )
        ),
    _ => None
}
)
 .set_encrypted_parts(match (*dafny_value.encryptedParts()).as_ref() {
    crate::r#_Wrappers_Compile::Option::Some { value } =>
        Some(
            ::dafny_runtime::dafny_runtime_conversions::dafny_sequence_to_vec(value,
                |e: &::dafny_runtime::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::EncryptedPart>| crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::encrypted_part::from_dafny(e.clone())
,
            )
        ),
    _ => None
}
)
 .set_signed_parts(match (*dafny_value.signedParts()).as_ref() {
    crate::r#_Wrappers_Compile::Option::Some { value } =>
        Some(
            ::dafny_runtime::dafny_runtime_conversions::dafny_sequence_to_vec(value,
                |e: &::dafny_runtime::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::SignedPart>| crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::signed_part::from_dafny(e.clone())
,
            )
        ),
    _ => None
}
)
                .build()
                .unwrap()
    }
}

#[allow(dead_code)]
pub fn option_from_dafny(
    dafny_value: ::dafny_runtime::Rc<crate::_Wrappers_Compile::Option<::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::BeaconVersion,
    >>>,
) -> ::std::option::Option<
    crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconVersion,
> {
    match &*dafny_value {
        crate::_Wrappers_Compile::Option::Some { value } => {
            ::std::option::Option::Some(plain_from_dafny(value))
        }
        _ => ::std::option::Option::None,
    }
}
