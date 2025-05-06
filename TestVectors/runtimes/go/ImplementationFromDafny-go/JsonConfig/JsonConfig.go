// Package JsonConfig
// Dafny module JsonConfig compiled into Go

package JsonConfig

import (
	os "os"

	m_ComAmazonawsDynamodbTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/dynamodb/ComAmazonawsDynamodbTypes"
	m_Com_Amazonaws_Dynamodb "github.com/aws/aws-cryptographic-material-providers-library/releases/go/dynamodb/Com_Amazonaws_Dynamodb"
	m_ComAmazonawsKmsTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/kms/ComAmazonawsKmsTypes"
	m_Com_Amazonaws_Kms "github.com/aws/aws-cryptographic-material-providers-library/releases/go/kms/Com_Amazonaws_Kms"
	m_AlgorithmSuites "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AlgorithmSuites"
	m_AwsArnParsing "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsArnParsing"
	m_AwsCryptographyKeyStoreOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsCryptographyKeyStoreOperations"
	m_AwsCryptographyKeyStoreTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsCryptographyKeyStoreTypes"
	m_AwsCryptographyMaterialProvidersOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsCryptographyMaterialProvidersOperations"
	m_AwsCryptographyMaterialProvidersTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsCryptographyMaterialProvidersTypes"
	m_AwsKmsDiscoveryKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsDiscoveryKeyring"
	m_AwsKmsEcdhKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsEcdhKeyring"
	m_AwsKmsHierarchicalKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsHierarchicalKeyring"
	m_AwsKmsKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsKeyring"
	m_AwsKmsMrkAreUnique "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkAreUnique"
	m_AwsKmsMrkDiscoveryKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkDiscoveryKeyring"
	m_AwsKmsMrkKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkKeyring"
	m_AwsKmsMrkMatchForDecrypt "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkMatchForDecrypt"
	m_AwsKmsRsaKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsRsaKeyring"
	m_AwsKmsUtils "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsUtils"
	m_CMM "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CMM"
	m_CacheConstants "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CacheConstants"
	m_CanonicalEncryptionContext "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CanonicalEncryptionContext"
	m_Commitment "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Commitment"
	m_Constants "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Constants"
	m_CreateKeyStoreTable "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CreateKeyStoreTable"
	m_CreateKeys "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CreateKeys"
	m_DDBKeystoreOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/DDBKeystoreOperations"
	m_DefaultCMM "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/DefaultCMM"
	m_DefaultClientSupplier "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/DefaultClientSupplier"
	m_Defaults "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Defaults"
	m_DiscoveryMultiKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/DiscoveryMultiKeyring"
	m_EcdhEdkWrapping "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/EcdhEdkWrapping"
	m_EdkWrapping "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/EdkWrapping"
	m_ErrorMessages "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/ErrorMessages"
	m_GetKeys "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/GetKeys"
	m_IntermediateKeyWrapping "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/IntermediateKeyWrapping"
	m_KMSKeystoreOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KMSKeystoreOperations"
	m_KeyStore "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KeyStore"
	m_KeyStoreErrorMessages "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KeyStoreErrorMessages"
	m_Keyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Keyring"
	m_KmsArn "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KmsArn"
	m_LocalCMC "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/LocalCMC"
	m_MaterialProviders "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/MaterialProviders"
	m_MaterialWrapping "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/MaterialWrapping"
	m_Materials "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Materials"
	m_MrkAwareDiscoveryMultiKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/MrkAwareDiscoveryMultiKeyring"
	m_MrkAwareStrictMultiKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/MrkAwareStrictMultiKeyring"
	m_MultiKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/MultiKeyring"
	m_RawAESKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/RawAESKeyring"
	m_RawECDHKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/RawECDHKeyring"
	m_RawRSAKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/RawRSAKeyring"
	m_RequiredEncryptionContextCMM "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/RequiredEncryptionContextCMM"
	m_StormTracker "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/StormTracker"
	m_StormTrackingCMC "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/StormTrackingCMC"
	m_StrictMultiKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/StrictMultiKeyring"
	m_Structure "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Structure"
	m_SynchronizedLocalCMC "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/SynchronizedLocalCMC"
	m_Utils "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Utils"
	m_AtomicPrimitives "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/AtomicPrimitives"
	m_AwsCryptographyPrimitivesOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/AwsCryptographyPrimitivesOperations"
	m_AwsCryptographyPrimitivesTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/AwsCryptographyPrimitivesTypes"
	m_Digest "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/Digest"
	m_HKDF "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/HKDF"
	m_KdfCtr "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/KdfCtr"
	m_Random "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/Random"
	m_WrappedHKDF "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/WrappedHKDF"
	m_WrappedHMAC "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/WrappedHMAC"
	m_Actions "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Actions"
	m_Base64 "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Base64"
	m_Base64Lemmas "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Base64Lemmas"
	m_BoundedInts "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/BoundedInts"
	m_DivInternals "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/DivInternals"
	m_DivInternalsNonlinear "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/DivInternalsNonlinear"
	m_DivMod "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/DivMod"
	m_FileIO "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/FileIO"
	m_FloatCompare "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/FloatCompare"
	m_Functions "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Functions"
	m_GeneralInternals "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/GeneralInternals"
	m_GetOpt "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/GetOpt"
	m_HexStrings "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/HexStrings"
	m_JSON_API "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_API"
	m_JSON_ConcreteSyntax_Spec "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_ConcreteSyntax_Spec"
	m_JSON_ConcreteSyntax_SpecProperties "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_ConcreteSyntax_SpecProperties"
	m_JSON_Deserializer "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Deserializer"
	m_JSON_Deserializer_ByteStrConversion "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Deserializer_ByteStrConversion"
	m_JSON_Deserializer_Uint16StrConversion "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Deserializer_Uint16StrConversion"
	m_JSON_Errors "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Errors"
	m_JSON_Grammar "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Grammar"
	m_JSON_Serializer "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Serializer"
	m_JSON_Serializer_ByteStrConversion "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Serializer_ByteStrConversion"
	m_JSON_Spec "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Spec"
	m_JSON_Utils_Cursors "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Utils_Cursors"
	m_JSON_Utils_Lexers_Core "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Utils_Lexers_Core"
	m_JSON_Utils_Lexers_Strings "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Utils_Lexers_Strings"
	m_JSON_Utils_Parsers "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Utils_Parsers"
	m_JSON_Utils_Seq "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Utils_Seq"
	m_JSON_Utils_Str "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Utils_Str"
	m_JSON_Utils_Str_CharStrConversion "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Utils_Str_CharStrConversion"
	m_JSON_Utils_Str_CharStrEscaping "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Utils_Str_CharStrEscaping"
	m_JSON_Utils_Vectors "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Utils_Vectors"
	m_JSON_Utils_Views_Core "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Utils_Views_Core"
	m_JSON_Utils_Views_Writers "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Utils_Views_Writers"
	m_JSON_Values "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_Values"
	m_JSON_ZeroCopy_API "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_ZeroCopy_API"
	m_JSON_ZeroCopy_Deserializer "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_ZeroCopy_Deserializer"
	m_JSON_ZeroCopy_Deserializer_API "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_ZeroCopy_Deserializer_API"
	m_JSON_ZeroCopy_Deserializer_ArrayParams "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_ZeroCopy_Deserializer_ArrayParams"
	m_JSON_ZeroCopy_Deserializer_Arrays "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_ZeroCopy_Deserializer_Arrays"
	m_JSON_ZeroCopy_Deserializer_Constants "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_ZeroCopy_Deserializer_Constants"
	m_JSON_ZeroCopy_Deserializer_Core "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_ZeroCopy_Deserializer_Core"
	m_JSON_ZeroCopy_Deserializer_Numbers "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_ZeroCopy_Deserializer_Numbers"
	m_JSON_ZeroCopy_Deserializer_ObjectParams "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_ZeroCopy_Deserializer_ObjectParams"
	m_JSON_ZeroCopy_Deserializer_Objects "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_ZeroCopy_Deserializer_Objects"
	m_JSON_ZeroCopy_Deserializer_Strings "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_ZeroCopy_Deserializer_Strings"
	m_JSON_ZeroCopy_Deserializer_Values "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_ZeroCopy_Deserializer_Values"
	m_JSON_ZeroCopy_Serializer "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/JSON_ZeroCopy_Serializer"
	m_Logarithm "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Logarithm"
	m__Math "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Math_"
	m_ModInternals "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/ModInternals"
	m_ModInternalsNonlinear "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/ModInternalsNonlinear"
	m_Mul "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Mul"
	m_MulInternals "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/MulInternals"
	m_MulInternalsNonlinear "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/MulInternalsNonlinear"
	m_Power "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Power"
	m_Relations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Relations"
	m_Seq "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Seq"
	m_Seq_MergeSort "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Seq_MergeSort"
	m_Sorting "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Sorting"
	m_StandardLibrary "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary"
	m_StandardLibraryInterop "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibraryInterop"
	m_StandardLibrary_Sequence "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_Sequence"
	m_StandardLibrary_String "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_String"
	m_StandardLibrary_UInt "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_UInt"
	m_Streams "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Streams"
	m_UnicodeStrings "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/UnicodeStrings"
	m__Unicode "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Unicode_"
	m_Utf16EncodingForm "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Utf16EncodingForm"
	m_Utf8EncodingForm "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Utf8EncodingForm"
	m_Wrappers "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Wrappers"
	m_AllAlgorithmSuites "github.com/aws/aws-cryptographic-material-providers-library/testvectors/AllAlgorithmSuites"
	m_AllDefaultCmm "github.com/aws/aws-cryptographic-material-providers-library/testvectors/AllDefaultCmm"
	m_AllHierarchy "github.com/aws/aws-cryptographic-material-providers-library/testvectors/AllHierarchy"
	m_AllKms "github.com/aws/aws-cryptographic-material-providers-library/testvectors/AllKms"
	m_AllKmsEcdh "github.com/aws/aws-cryptographic-material-providers-library/testvectors/AllKmsEcdh"
	m_AllKmsMrkAware "github.com/aws/aws-cryptographic-material-providers-library/testvectors/AllKmsMrkAware"
	m_AllKmsMrkAwareDiscovery "github.com/aws/aws-cryptographic-material-providers-library/testvectors/AllKmsMrkAwareDiscovery"
	m_AllKmsRsa "github.com/aws/aws-cryptographic-material-providers-library/testvectors/AllKmsRsa"
	m_AllMulti "github.com/aws/aws-cryptographic-material-providers-library/testvectors/AllMulti"
	m_AllRawAES "github.com/aws/aws-cryptographic-material-providers-library/testvectors/AllRawAES"
	m_AllRawECDH "github.com/aws/aws-cryptographic-material-providers-library/testvectors/AllRawECDH"
	m_AllRawRSA "github.com/aws/aws-cryptographic-material-providers-library/testvectors/AllRawRSA"
	m_AllRequiredEncryptionContextCmm "github.com/aws/aws-cryptographic-material-providers-library/testvectors/AllRequiredEncryptionContextCmm"
	m_AwsCryptographyMaterialProvidersTestVectorKeysTypes "github.com/aws/aws-cryptographic-material-providers-library/testvectors/AwsCryptographyMaterialProvidersTestVectorKeysTypes"
	m_CmmFromKeyDescription "github.com/aws/aws-cryptographic-material-providers-library/testvectors/CmmFromKeyDescription"
	m_CompleteVectors "github.com/aws/aws-cryptographic-material-providers-library/testvectors/CompleteVectors"
	m_CreateStaticKeyStores "github.com/aws/aws-cryptographic-material-providers-library/testvectors/CreateStaticKeyStores"
	m_CreateStaticKeyrings "github.com/aws/aws-cryptographic-material-providers-library/testvectors/CreateStaticKeyrings"
	m_EncryptionContextUtils "github.com/aws/aws-cryptographic-material-providers-library/testvectors/EncryptionContextUtils"
	m_JSONHelpers "github.com/aws/aws-cryptographic-material-providers-library/testvectors/JSONHelpers"
	m_KeyDescription "github.com/aws/aws-cryptographic-material-providers-library/testvectors/KeyDescription"
	m_KeyMaterial "github.com/aws/aws-cryptographic-material-providers-library/testvectors/KeyMaterial"
	m_KeyVectors "github.com/aws/aws-cryptographic-material-providers-library/testvectors/KeyVectors"
	m_KeyringFromKeyDescription "github.com/aws/aws-cryptographic-material-providers-library/testvectors/KeyringFromKeyDescription"
	m_KeysVectorOperations "github.com/aws/aws-cryptographic-material-providers-library/testvectors/KeysVectorOperations"
	m_MplManifestOptions "github.com/aws/aws-cryptographic-material-providers-library/testvectors/MplManifestOptions"
	m_ParseJsonManifests "github.com/aws/aws-cryptographic-material-providers-library/testvectors/ParseJsonManifests"
	m_TestManifests "github.com/aws/aws-cryptographic-material-providers-library/testvectors/TestManifests"
	m_TestVectors "github.com/aws/aws-cryptographic-material-providers-library/testvectors/TestVectors"
	m_WrappedMaterialProviders "github.com/aws/aws-cryptographic-material-providers-library/testvectors/WrappedMaterialProviders"
	m_WrappedMaterialProvidersMain "github.com/aws/aws-cryptographic-material-providers-library/testvectors/WrappedMaterialProvidersMain"
	m_WriteJsonManifests "github.com/aws/aws-cryptographic-material-providers-library/testvectors/WriteJsonManifests"
	m_AttributeResolver "github.com/aws/aws-database-encryption-sdk-dynamodb/AttributeResolver"
	m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations"
	m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes"
	m_AwsCryptographyDbEncryptionSdkDynamoDbOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbOperations"
	m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations"
	m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes"
	m_AwsCryptographyDbEncryptionSdkDynamoDbTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbTypes"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes"
	m_BaseBeacon "github.com/aws/aws-database-encryption-sdk-dynamodb/BaseBeacon"
	m_BatchExecuteStatementTransform "github.com/aws/aws-database-encryption-sdk-dynamodb/BatchExecuteStatementTransform"
	m_BatchGetItemTransform "github.com/aws/aws-database-encryption-sdk-dynamodb/BatchGetItemTransform"
	m_BatchWriteItemTransform "github.com/aws/aws-database-encryption-sdk-dynamodb/BatchWriteItemTransform"
	m_Canonize "github.com/aws/aws-database-encryption-sdk-dynamodb/Canonize"
	m_CompoundBeacon "github.com/aws/aws-database-encryption-sdk-dynamodb/CompoundBeacon"
	m_DdbMiddlewareConfig "github.com/aws/aws-database-encryption-sdk-dynamodb/DdbMiddlewareConfig"
	m_DdbStatement "github.com/aws/aws-database-encryption-sdk-dynamodb/DdbStatement"
	m_DdbVirtualFields "github.com/aws/aws-database-encryption-sdk-dynamodb/DdbVirtualFields"
	m_DeleteItemTransform "github.com/aws/aws-database-encryption-sdk-dynamodb/DeleteItemTransform"
	m_DynamoDBFilterExpr "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDBFilterExpr"
	m_DynamoDBSupport "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDBSupport"
	m_DynamoDbEncryption "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbEncryption"
	m_DynamoDbEncryptionBranchKeyIdSupplier "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbEncryptionBranchKeyIdSupplier"
	m_DynamoDbEncryptionTransforms "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbEncryptionTransforms"
	m_DynamoDbEncryptionUtil "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbEncryptionUtil"
	m_DynamoDbItemEncryptor "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbItemEncryptor"
	m_DynamoDbItemEncryptorUtil "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbItemEncryptorUtil"
	m_DynamoDbMiddlewareSupport "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbMiddlewareSupport"
	m_DynamoDbNormalizeNumber "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbNormalizeNumber"
	m_DynamoDbUpdateExpr "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoDbUpdateExpr"
	m_DynamoToStruct "github.com/aws/aws-database-encryption-sdk-dynamodb/DynamoToStruct"
	m_ExecuteStatementTransform "github.com/aws/aws-database-encryption-sdk-dynamodb/ExecuteStatementTransform"
	m_ExecuteTransactionTransform "github.com/aws/aws-database-encryption-sdk-dynamodb/ExecuteTransactionTransform"
	m_GetItemTransform "github.com/aws/aws-database-encryption-sdk-dynamodb/GetItemTransform"
	m_InternalLegacyOverride "github.com/aws/aws-database-encryption-sdk-dynamodb/InternalLegacyOverride"
	m__Maps "github.com/aws/aws-database-encryption-sdk-dynamodb/Maps_"
	m_MemoryMath "github.com/aws/aws-database-encryption-sdk-dynamodb/MemoryMath"
	m_OptimizedMergeSort "github.com/aws/aws-database-encryption-sdk-dynamodb/OptimizedMergeSort"
	m_PutItemTransform "github.com/aws/aws-database-encryption-sdk-dynamodb/PutItemTransform"
	m_QueryTransform "github.com/aws/aws-database-encryption-sdk-dynamodb/QueryTransform"
	m_ScanTransform "github.com/aws/aws-database-encryption-sdk-dynamodb/ScanTransform"
	m_SearchConfigToInfo "github.com/aws/aws-database-encryption-sdk-dynamodb/SearchConfigToInfo"
	m_SearchableEncryptionInfo "github.com/aws/aws-database-encryption-sdk-dynamodb/SearchableEncryptionInfo"
	m_Sets "github.com/aws/aws-database-encryption-sdk-dynamodb/Sets"
	m_SortCanon "github.com/aws/aws-database-encryption-sdk-dynamodb/SortCanon"
	m_StructuredEncryption "github.com/aws/aws-database-encryption-sdk-dynamodb/StructuredEncryption"
	m_StructuredEncryptionCrypt "github.com/aws/aws-database-encryption-sdk-dynamodb/StructuredEncryptionCrypt"
	m_StructuredEncryptionFooter "github.com/aws/aws-database-encryption-sdk-dynamodb/StructuredEncryptionFooter"
	m_StructuredEncryptionHeader "github.com/aws/aws-database-encryption-sdk-dynamodb/StructuredEncryptionHeader"
	m_StructuredEncryptionPaths "github.com/aws/aws-database-encryption-sdk-dynamodb/StructuredEncryptionPaths"
	m_StructuredEncryptionUtil "github.com/aws/aws-database-encryption-sdk-dynamodb/StructuredEncryptionUtil"
	m_TermLoc "github.com/aws/aws-database-encryption-sdk-dynamodb/TermLoc"
	m_TransactGetItemsTransform "github.com/aws/aws-database-encryption-sdk-dynamodb/TransactGetItemsTransform"
	m_TransactWriteItemsTransform "github.com/aws/aws-database-encryption-sdk-dynamodb/TransactWriteItemsTransform"
	m_UpdateItemTransform "github.com/aws/aws-database-encryption-sdk-dynamodb/UpdateItemTransform"
	m_CreateInterceptedDDBClient "github.com/aws/aws-database-encryption-sdk-dynamodb/testvectors/CreateInterceptedDDBClient"
	m_CreateWrappedItemEncryptor "github.com/aws/aws-database-encryption-sdk-dynamodb/testvectors/CreateWrappedItemEncryptor"
	m_DdbItemJson "github.com/aws/aws-database-encryption-sdk-dynamodb/testvectors/DdbItemJson"
	m_WrappedItemEncryptor "github.com/aws/aws-database-encryption-sdk-dynamodb/testvectors/WrappedItemEncryptor"
	m__System "github.com/dafny-lang/DafnyRuntimeGo/v4/System_"
	_dafny "github.com/dafny-lang/DafnyRuntimeGo/v4/dafny"
)

var _ = os.Args
var _ _dafny.Dummy__
var _ m__System.Dummy__
var _ m_Wrappers.Dummy__
var _ m_BoundedInts.Dummy__
var _ m_StandardLibrary_UInt.Dummy__
var _ m_StandardLibrary_Sequence.Dummy__
var _ m_StandardLibrary_String.Dummy__
var _ m_StandardLibrary.Dummy__
var _ m_AwsCryptographyPrimitivesTypes.Dummy__
var _ m_Random.Dummy__
var _ m_Digest.Dummy__
var _ m_WrappedHMAC.Dummy__
var _ m_HKDF.Dummy__
var _ m_WrappedHKDF.Dummy__
var _ m_KdfCtr.Dummy__
var _ m_AwsCryptographyPrimitivesOperations.Dummy__
var _ m_AtomicPrimitives.Dummy__
var _ m_ComAmazonawsDynamodbTypes.Dummy__
var _ m_ComAmazonawsKmsTypes.Dummy__
var _ m_AwsCryptographyKeyStoreTypes.Dummy__
var _ m_AwsCryptographyMaterialProvidersTypes.Dummy__
var _ m_Base64.Dummy__
var _ m_AlgorithmSuites.Dummy__
var _ m_Materials.Dummy__
var _ m_Keyring.Dummy__
var _ m_Relations.Dummy__
var _ m_Seq_MergeSort.Dummy__
var _ m__Math.Dummy__
var _ m_Seq.Dummy__
var _ m_Actions.Dummy__
var _ m_CanonicalEncryptionContext.Dummy__
var _ m_MaterialWrapping.Dummy__
var _ m_IntermediateKeyWrapping.Dummy__
var _ m_EdkWrapping.Dummy__
var _ m_ErrorMessages.Dummy__
var _ m_RawAESKeyring.Dummy__
var _ m_AwsArnParsing.Dummy__
var _ m_Constants.Dummy__
var _ m_EcdhEdkWrapping.Dummy__
var _ m_RawECDHKeyring.Dummy__
var _ m_RawRSAKeyring.Dummy__
var _ m_AwsKmsMrkMatchForDecrypt.Dummy__
var _ m_AwsKmsUtils.Dummy__
var _ m_AwsKmsKeyring.Dummy__
var _ m_AwsKmsDiscoveryKeyring.Dummy__
var _ m_AwsKmsEcdhKeyring.Dummy__
var _ m_FileIO.Dummy__
var _ m_LocalCMC.Dummy__
var _ m_SynchronizedLocalCMC.Dummy__
var _ m_StormTracker.Dummy__
var _ m_StormTrackingCMC.Dummy__
var _ m_CacheConstants.Dummy__
var _ m_AwsKmsHierarchicalKeyring.Dummy__
var _ m_AwsKmsMrkDiscoveryKeyring.Dummy__
var _ m_AwsKmsMrkKeyring.Dummy__
var _ m_AwsKmsRsaKeyring.Dummy__
var _ m_MultiKeyring.Dummy__
var _ m_AwsKmsMrkAreUnique.Dummy__
var _ m_StrictMultiKeyring.Dummy__
var _ m_Com_Amazonaws_Kms.Dummy__
var _ m_Com_Amazonaws_Dynamodb.Dummy__
var _ m_DiscoveryMultiKeyring.Dummy__
var _ m_MrkAwareDiscoveryMultiKeyring.Dummy__
var _ m_MrkAwareStrictMultiKeyring.Dummy__
var _ m_CMM.Dummy__
var _ m_Defaults.Dummy__
var _ m_Commitment.Dummy__
var _ m_DefaultCMM.Dummy__
var _ m_DefaultClientSupplier.Dummy__
var _ m_Utils.Dummy__
var _ m_RequiredEncryptionContextCMM.Dummy__
var _ m_AwsCryptographyMaterialProvidersOperations.Dummy__
var _ m_MaterialProviders.Dummy__
var _ m_KeyStoreErrorMessages.Dummy__
var _ m_KmsArn.Dummy__
var _ m_Structure.Dummy__
var _ m_KMSKeystoreOperations.Dummy__
var _ m_DDBKeystoreOperations.Dummy__
var _ m_CreateKeys.Dummy__
var _ m_CreateKeyStoreTable.Dummy__
var _ m_GetKeys.Dummy__
var _ m_AwsCryptographyKeyStoreOperations.Dummy__
var _ m_KeyStore.Dummy__
var _ m_AwsCryptographyMaterialProvidersTestVectorKeysTypes.Dummy__
var _ m_JSON_Utils_Views_Core.Dummy__
var _ m_JSON_Utils_Views_Writers.Dummy__
var _ m_JSON_Utils_Lexers_Core.Dummy__
var _ m_JSON_Utils_Lexers_Strings.Dummy__
var _ m_JSON_Utils_Cursors.Dummy__
var _ m_JSON_Utils_Parsers.Dummy__
var _ m_GeneralInternals.Dummy__
var _ m_MulInternalsNonlinear.Dummy__
var _ m_MulInternals.Dummy__
var _ m_Mul.Dummy__
var _ m_ModInternalsNonlinear.Dummy__
var _ m_DivInternalsNonlinear.Dummy__
var _ m_ModInternals.Dummy__
var _ m_DivInternals.Dummy__
var _ m_DivMod.Dummy__
var _ m_Power.Dummy__
var _ m_Logarithm.Dummy__
var _ m_JSON_Utils_Str_CharStrConversion.Dummy__
var _ m_JSON_Utils_Str_CharStrEscaping.Dummy__
var _ m_JSON_Utils_Str.Dummy__
var _ m_JSON_Utils_Seq.Dummy__
var _ m_JSON_Utils_Vectors.Dummy__
var _ m_JSON_Errors.Dummy__
var _ m_JSON_Values.Dummy__
var _ m__Unicode.Dummy__
var _ m_Functions.Dummy__
var _ m_Utf8EncodingForm.Dummy__
var _ m_Utf16EncodingForm.Dummy__
var _ m_UnicodeStrings.Dummy__
var _ m_JSON_Spec.Dummy__
var _ m_JSON_Grammar.Dummy__
var _ m_JSON_Serializer_ByteStrConversion.Dummy__
var _ m_JSON_Serializer.Dummy__
var _ m_JSON_Deserializer_Uint16StrConversion.Dummy__
var _ m_JSON_Deserializer_ByteStrConversion.Dummy__
var _ m_JSON_Deserializer.Dummy__
var _ m_JSON_ConcreteSyntax_Spec.Dummy__
var _ m_JSON_ConcreteSyntax_SpecProperties.Dummy__
var _ m_JSON_ZeroCopy_Serializer.Dummy__
var _ m_JSON_ZeroCopy_Deserializer_Core.Dummy__
var _ m_JSON_ZeroCopy_Deserializer_Strings.Dummy__
var _ m_JSON_ZeroCopy_Deserializer_Numbers.Dummy__
var _ m_JSON_ZeroCopy_Deserializer_ObjectParams.Dummy__
var _ m_JSON_ZeroCopy_Deserializer_Objects.Dummy__
var _ m_JSON_ZeroCopy_Deserializer_ArrayParams.Dummy__
var _ m_JSON_ZeroCopy_Deserializer_Arrays.Dummy__
var _ m_JSON_ZeroCopy_Deserializer_Constants.Dummy__
var _ m_JSON_ZeroCopy_Deserializer_Values.Dummy__
var _ m_JSON_ZeroCopy_Deserializer_API.Dummy__
var _ m_JSON_ZeroCopy_Deserializer.Dummy__
var _ m_JSON_ZeroCopy_API.Dummy__
var _ m_JSON_API.Dummy__
var _ m_JSONHelpers.Dummy__
var _ m_KeyDescription.Dummy__
var _ m_HexStrings.Dummy__
var _ m_KeyMaterial.Dummy__
var _ m_CreateStaticKeyrings.Dummy__
var _ m_CreateStaticKeyStores.Dummy__
var _ m_KeyringFromKeyDescription.Dummy__
var _ m_CmmFromKeyDescription.Dummy__
var _ m_WrappedMaterialProviders.Dummy__
var _ m_KeysVectorOperations.Dummy__
var _ m_KeyVectors.Dummy__
var _ m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Dummy__
var _ m_StructuredEncryptionUtil.Dummy__
var _ m_Sets.Dummy__
var _ m_StructuredEncryptionPaths.Dummy__
var _ m_StructuredEncryptionHeader.Dummy__
var _ m_StructuredEncryptionFooter.Dummy__
var _ m_OptimizedMergeSort.Dummy__
var _ m_SortCanon.Dummy__
var _ m_Canonize.Dummy__
var _ m_StructuredEncryptionCrypt.Dummy__
var _ m__Maps.Dummy__
var _ m_AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations.Dummy__
var _ m_StructuredEncryption.Dummy__
var _ m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Dummy__
var _ m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Dummy__
var _ m_DynamoDbEncryptionUtil.Dummy__
var _ m_DynamoDbNormalizeNumber.Dummy__
var _ m_MemoryMath.Dummy__
var _ m_DynamoToStruct.Dummy__
var _ m_DynamoDbItemEncryptorUtil.Dummy__
var _ m_InternalLegacyOverride.Dummy__
var _ m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorOperations.Dummy__
var _ m_DynamoDbItemEncryptor.Dummy__
var _ m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Dummy__
var _ m_TermLoc.Dummy__
var _ m_DdbVirtualFields.Dummy__
var _ m_BaseBeacon.Dummy__
var _ m_CompoundBeacon.Dummy__
var _ m_SearchableEncryptionInfo.Dummy__
var _ m_DdbMiddlewareConfig.Dummy__
var _ m_DdbStatement.Dummy__
var _ m_DynamoDbUpdateExpr.Dummy__
var _ m_FloatCompare.Dummy__
var _ m_DynamoDBFilterExpr.Dummy__
var _ m_DynamoDBSupport.Dummy__
var _ m_DynamoDbMiddlewareSupport.Dummy__
var _ m_PutItemTransform.Dummy__
var _ m_GetItemTransform.Dummy__
var _ m_UpdateItemTransform.Dummy__
var _ m_BatchWriteItemTransform.Dummy__
var _ m_TransactWriteItemsTransform.Dummy__
var _ m_BatchGetItemTransform.Dummy__
var _ m_ScanTransform.Dummy__
var _ m_QueryTransform.Dummy__
var _ m_TransactGetItemsTransform.Dummy__
var _ m_DeleteItemTransform.Dummy__
var _ m_ExecuteStatementTransform.Dummy__
var _ m_BatchExecuteStatementTransform.Dummy__
var _ m_ExecuteTransactionTransform.Dummy__
var _ m_AttributeResolver.Dummy__
var _ m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations.Dummy__
var _ m_SearchConfigToInfo.Dummy__
var _ m_DynamoDbEncryptionTransforms.Dummy__
var _ m_DynamoDbEncryptionBranchKeyIdSupplier.Dummy__
var _ m_AwsCryptographyDbEncryptionSdkDynamoDbOperations.Dummy__
var _ m_DynamoDbEncryption.Dummy__
var _ m_MplManifestOptions.Dummy__
var _ m_GetOpt.Dummy__
var _ m_AllAlgorithmSuites.Dummy__
var _ m_TestVectors.Dummy__
var _ m_AllHierarchy.Dummy__
var _ m_EncryptionContextUtils.Dummy__
var _ m_AllKms.Dummy__
var _ m_AllKmsMrkAware.Dummy__
var _ m_AllKmsMrkAwareDiscovery.Dummy__
var _ m_AllKmsRsa.Dummy__
var _ m_AllKmsEcdh.Dummy__
var _ m_AllRawAES.Dummy__
var _ m_AllRawRSA.Dummy__
var _ m_AllRawECDH.Dummy__
var _ m_AllDefaultCmm.Dummy__
var _ m_AllRequiredEncryptionContextCmm.Dummy__
var _ m_AllMulti.Dummy__
var _ m_WriteJsonManifests.Dummy__
var _ m_CompleteVectors.Dummy__
var _ m_ParseJsonManifests.Dummy__
var _ m_TestManifests.Dummy__
var _ m_WrappedMaterialProvidersMain.Dummy__
var _ m_StandardLibraryInterop.Dummy__
var _ m_Streams.Dummy__
var _ m_Sorting.Dummy__
var _ m_Base64Lemmas.Dummy__
var _ m_WrappedItemEncryptor.Dummy__
var _ m_DdbItemJson.Dummy__

type Dummy__ struct{}

// Definition of class Default__
type Default__ struct {
	dummy byte
}

func New_Default___() *Default__ {
	_this := Default__{}

	return &_this
}

type CompanionStruct_Default___ struct {
}

var Companion_Default___ = CompanionStruct_Default___{}

func (_this *Default__) Equals(other *Default__) bool {
	return _this == other
}

func (_this *Default__) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*Default__)
	return ok && _this.Equals(other)
}

func (*Default__) String() string {
	return "JsonConfig.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) IsValidInt32(x _dafny.Int) bool {
	return ((_dafny.IntOfInt64(-2147483648)).Cmp(x) <= 0) && ((x).Cmp(_dafny.IntOfInt64(2147483648)) < 0)
}
func (_static *CompanionStruct_Default___) NewGazelle(config TableConfig) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	if (config).Dtor_vanilla() {
		var _0_res m_Wrappers.Result
		_ = _0_res
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_CreateInterceptedDDBClient.CreateVanillaDDBClient()
		_0_res = _out0
		if (_0_res).Is_Success() {
			output = m_Wrappers.Companion_Result_.Create_Success_(m_ComAmazonawsDynamodbTypes.Companion_IDynamoDBClient_.CastTo_((_0_res).Dtor_value()))
			return output
		} else {
			_dafny.Print((_0_res).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error))
			_dafny.Print((_dafny.SeqOfString("\n")).SetString())
			output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Failed to create vanilla client."))
			return output
		}
	} else {
		var _1_configs m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTablesEncryptionConfig
		_ = _1_configs
		_1_configs = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_DynamoDbTablesEncryptionConfig_.Create_DynamoDbTablesEncryptionConfig_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(Companion_Default___.TableName(), (config).Dtor_config()))
		var _2_res m_Wrappers.Result
		_ = _2_res
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = m_CreateInterceptedDDBClient.CreateInterceptedDDBClient(_1_configs)
		_2_res = _out1
		if (_2_res).Is_Success() {
			output = m_Wrappers.Companion_Result_.Create_Success_(m_ComAmazonawsDynamodbTypes.Companion_IDynamoDBClient_.CastTo_((_2_res).Dtor_value()))
			return output
		} else {
			_dafny.Print((_2_res).Dtor_error().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error))
			_dafny.Print((_dafny.SeqOfString("\n")).SetString())
			output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Failed to create DbEsdk client."))
			return output
		}
	}
	return output
}
func (_static *CompanionStruct_Default___) GetRoundTripTests(data m_JSON_Values.JSON, keys *m_KeyVectors.KeyVectorsClient) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Object(), _dafny.SeqOfString("RoundTripTest Test must be an object."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_configs _dafny.Map
	_ = _1_configs
	_1_configs = _dafny.NewMapBuilder().ToMap()
	var _2_records _dafny.Sequence
	_ = _2_records
	_2_records = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_obj()).Cardinality())
	_ = _hi0
	for _3_i := _dafny.Zero; _3_i.Cmp(_hi0) < 0; _3_i = _3_i.Plus(_dafny.One) {
		var _4_obj _dafny.Tuple
		_ = _4_obj
		_4_obj = ((data).Dtor_obj()).Select((_3_i).Uint32()).(_dafny.Tuple)
		var _source0 _dafny.Sequence = (*(_4_obj).IndexInt(0)).(_dafny.Sequence)
		_ = _source0
		{
			{
				if (_source0).Equals(_dafny.SeqOfString("Configs")) {
					var _5_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
					_ = _5_valueOrError1
					var _out0 m_Wrappers.Result
					_ = _out0
					_out0 = Companion_Default___.GetTableConfigs((*(_4_obj).IndexInt(1)).(m_JSON_Values.JSON), keys)
					_5_valueOrError1 = _out0
					if (_5_valueOrError1).IsFailure() {
						output = (_5_valueOrError1).PropagateFailure()
						return output
					}
					var _6_src _dafny.Map
					_ = _6_src
					_6_src = (_5_valueOrError1).Extract().(_dafny.Map)
					_1_configs = _6_src
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("Records")) {
					var _7_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _7_valueOrError2
					var _out1 m_Wrappers.Result
					_ = _out1
					_out1 = Companion_Default___.GetRecords((*(_4_obj).IndexInt(1)).(m_JSON_Values.JSON))
					_7_valueOrError2 = _out1
					if (_7_valueOrError2).IsFailure() {
						output = (_7_valueOrError2).PropagateFailure()
						return output
					}
					var _8_src _dafny.Sequence
					_ = _8_src
					_8_src = (_7_valueOrError2).Extract().(_dafny.Sequence)
					_2_records = _8_src
					goto Lmatch0
				}
			}
			{
				output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Unexpected part of a write test : '"), (*(_4_obj).IndexInt(0)).(_dafny.Sequence)), _dafny.SeqOfString("'")))
				return output
			}
			goto Lmatch0
		}
	Lmatch0:
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(_dafny.SeqOf(Companion_RoundTripTest_.Create_RoundTripTest_(_1_configs, _2_records)))
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetWriteTests(data m_JSON_Values.JSON, keys *m_KeyVectors.KeyVectorsClient) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Array(), _dafny.SeqOfString("Write Test list must be an array."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_results _dafny.Sequence
	_ = _1_results
	_1_results = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_arr()).Cardinality())
	_ = _hi0
	for _2_i := _dafny.Zero; _2_i.Cmp(_hi0) < 0; _2_i = _2_i.Plus(_dafny.One) {
		var _3_obj m_JSON_Values.JSON
		_ = _3_obj
		_3_obj = ((data).Dtor_arr()).Select((_2_i).Uint32()).(m_JSON_Values.JSON)
		var _4_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _4_valueOrError1
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = Companion_Default___.GetOneWriteTest(_3_obj, keys)
		_4_valueOrError1 = _out0
		if (_4_valueOrError1).IsFailure() {
			output = (_4_valueOrError1).PropagateFailure()
			return output
		}
		var _5_item WriteTest
		_ = _5_item
		_5_item = (_4_valueOrError1).Extract().(WriteTest)
		_1_results = _dafny.Companion_Sequence_.Concatenate(_1_results, _dafny.SeqOf(_5_item))
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(_1_results)
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetOneWriteTest(data m_JSON_Values.JSON, keys *m_KeyVectors.KeyVectorsClient) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Object(), _dafny.SeqOfString("A Write Test must be an object."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_config m_Wrappers.Option
	_ = _1_config
	_1_config = m_Wrappers.Companion_Option_.Create_None_()
	var _2_fileName _dafny.Sequence
	_ = _2_fileName
	_2_fileName = _dafny.SeqOfString("")
	var _3_records _dafny.Sequence
	_ = _3_records
	_3_records = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_obj()).Cardinality())
	_ = _hi0
	for _4_i := _dafny.Zero; _4_i.Cmp(_hi0) < 0; _4_i = _4_i.Plus(_dafny.One) {
		var _5_obj _dafny.Tuple
		_ = _5_obj
		_5_obj = ((data).Dtor_obj()).Select((_4_i).Uint32()).(_dafny.Tuple)
		var _source0 _dafny.Sequence = (*(_5_obj).IndexInt(0)).(_dafny.Sequence)
		_ = _source0
		{
			{
				if (_source0).Equals(_dafny.SeqOfString("Config")) {
					var _6_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
					_ = _6_valueOrError1
					var _out0 m_Wrappers.Result
					_ = _out0
					_out0 = Companion_Default___.GetOneTableConfig(_dafny.SeqOfString("foo"), (*(_5_obj).IndexInt(1)).(m_JSON_Values.JSON), keys)
					_6_valueOrError1 = _out0
					if (_6_valueOrError1).IsFailure() {
						output = (_6_valueOrError1).PropagateFailure()
						return output
					}
					var _7_src TableConfig
					_ = _7_src
					_7_src = (_6_valueOrError1).Extract().(TableConfig)
					_1_config = m_Wrappers.Companion_Option_.Create_Some_(_7_src)
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("FileName")) {
					var _8_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _8_valueOrError2
					_8_valueOrError2 = m_Wrappers.Companion_Default___.Need(((*(_5_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("Write Test file name must be a string."))
					if (_8_valueOrError2).IsFailure() {
						output = (_8_valueOrError2).PropagateFailure()
						return output
					}
					_2_fileName = ((*(_5_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str()
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("Records")) {
					var _9_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _9_valueOrError3
					var _out1 m_Wrappers.Result
					_ = _out1
					_out1 = Companion_Default___.GetRecords((*(_5_obj).IndexInt(1)).(m_JSON_Values.JSON))
					_9_valueOrError3 = _out1
					if (_9_valueOrError3).IsFailure() {
						output = (_9_valueOrError3).PropagateFailure()
						return output
					}
					_3_records = (_9_valueOrError3).Extract().(_dafny.Sequence)
					goto Lmatch0
				}
			}
			{
				output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Unexpected part of a write test : '"), (*(_5_obj).IndexInt(0)).(_dafny.Sequence)), _dafny.SeqOfString("'")))
				return output
			}
			goto Lmatch0
		}
	Lmatch0:
	}
	var _10_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _10_valueOrError4
	_10_valueOrError4 = m_Wrappers.Companion_Default___.Need((_1_config).Is_Some(), _dafny.SeqOfString("Every Write Test needs a config."))
	if (_10_valueOrError4).IsFailure() {
		output = (_10_valueOrError4).PropagateFailure()
		return output
	}
	var _11_valueOrError5 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _11_valueOrError5
	_11_valueOrError5 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((_2_fileName).Cardinality())).Sign() == 1, _dafny.SeqOfString("Every Write Test needs a file name."))
	if (_11_valueOrError5).IsFailure() {
		output = (_11_valueOrError5).PropagateFailure()
		return output
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(Companion_WriteTest_.Create_WriteTest_((_1_config).Dtor_value().(TableConfig), _3_records, _2_fileName))
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetDecryptTests(data m_JSON_Values.JSON, keys *m_KeyVectors.KeyVectorsClient) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Array(), _dafny.SeqOfString("Decrypt Test list must be an array."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_results _dafny.Sequence
	_ = _1_results
	_1_results = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_arr()).Cardinality())
	_ = _hi0
	for _2_i := _dafny.Zero; _2_i.Cmp(_hi0) < 0; _2_i = _2_i.Plus(_dafny.One) {
		var _3_obj m_JSON_Values.JSON
		_ = _3_obj
		_3_obj = ((data).Dtor_arr()).Select((_2_i).Uint32()).(m_JSON_Values.JSON)
		var _4_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _4_valueOrError1
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = Companion_Default___.GetOneDecryptTest(_3_obj, keys)
		_4_valueOrError1 = _out0
		if (_4_valueOrError1).IsFailure() {
			output = (_4_valueOrError1).PropagateFailure()
			return output
		}
		var _5_item DecryptTest
		_ = _5_item
		_5_item = (_4_valueOrError1).Extract().(DecryptTest)
		_1_results = _dafny.Companion_Sequence_.Concatenate(_1_results, _dafny.SeqOf(_5_item))
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(_1_results)
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetOneDecryptTest(data m_JSON_Values.JSON, keys *m_KeyVectors.KeyVectorsClient) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Object(), _dafny.SeqOfString("A Decrypt Test must be an object."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_config m_Wrappers.Option
	_ = _1_config
	_1_config = m_Wrappers.Companion_Option_.Create_None_()
	var _2_encRecords _dafny.Sequence
	_ = _2_encRecords
	_2_encRecords = _dafny.SeqOf()
	var _3_plainRecords _dafny.Sequence
	_ = _3_plainRecords
	_3_plainRecords = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_obj()).Cardinality())
	_ = _hi0
	for _4_i := _dafny.Zero; _4_i.Cmp(_hi0) < 0; _4_i = _4_i.Plus(_dafny.One) {
		var _5_obj _dafny.Tuple
		_ = _5_obj
		_5_obj = ((data).Dtor_obj()).Select((_4_i).Uint32()).(_dafny.Tuple)
		var _source0 _dafny.Sequence = (*(_5_obj).IndexInt(0)).(_dafny.Sequence)
		_ = _source0
		{
			{
				if (_source0).Equals(_dafny.SeqOfString("Config")) {
					var _6_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
					_ = _6_valueOrError1
					var _out0 m_Wrappers.Result
					_ = _out0
					_out0 = Companion_Default___.GetOneTableConfig(_dafny.SeqOfString("foo"), (*(_5_obj).IndexInt(1)).(m_JSON_Values.JSON), keys)
					_6_valueOrError1 = _out0
					if (_6_valueOrError1).IsFailure() {
						output = (_6_valueOrError1).PropagateFailure()
						return output
					}
					var _7_src TableConfig
					_ = _7_src
					_7_src = (_6_valueOrError1).Extract().(TableConfig)
					_1_config = m_Wrappers.Companion_Option_.Create_Some_(_7_src)
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("EncryptedRecords")) {
					var _8_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _8_valueOrError2
					var _out1 m_Wrappers.Result
					_ = _out1
					_out1 = Companion_Default___.GetRecords((*(_5_obj).IndexInt(1)).(m_JSON_Values.JSON))
					_8_valueOrError2 = _out1
					if (_8_valueOrError2).IsFailure() {
						output = (_8_valueOrError2).PropagateFailure()
						return output
					}
					_2_encRecords = (_8_valueOrError2).Extract().(_dafny.Sequence)
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("PlainTextRecords")) {
					var _9_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _9_valueOrError3
					var _out2 m_Wrappers.Result
					_ = _out2
					_out2 = Companion_Default___.GetRecords((*(_5_obj).IndexInt(1)).(m_JSON_Values.JSON))
					_9_valueOrError3 = _out2
					if (_9_valueOrError3).IsFailure() {
						output = (_9_valueOrError3).PropagateFailure()
						return output
					}
					_3_plainRecords = (_9_valueOrError3).Extract().(_dafny.Sequence)
					goto Lmatch0
				}
			}
			{
				output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Unexpected part of a encrypt test : '"), (*(_5_obj).IndexInt(0)).(_dafny.Sequence)), _dafny.SeqOfString("'")))
				return output
			}
			goto Lmatch0
		}
	Lmatch0:
	}
	var _10_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _10_valueOrError4
	_10_valueOrError4 = m_Wrappers.Companion_Default___.Need((_1_config).Is_Some(), _dafny.SeqOfString("Every Decrypt Test needs a config."))
	if (_10_valueOrError4).IsFailure() {
		output = (_10_valueOrError4).PropagateFailure()
		return output
	}
	var _11_valueOrError5 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _11_valueOrError5
	_11_valueOrError5 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((_2_encRecords).Cardinality())).Cmp(_dafny.IntOfUint32((_3_plainRecords).Cardinality())) == 0, _dafny.SeqOfString("A Decrypt Test needs the same number of EncryptedRecords and PlainTextRecords."))
	if (_11_valueOrError5).IsFailure() {
		output = (_11_valueOrError5).PropagateFailure()
		return output
	}
	var _12_valueOrError6 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _12_valueOrError6
	_12_valueOrError6 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((_2_encRecords).Cardinality())).Sign() == 1, _dafny.SeqOfString("Every Decrypt Test needs at least on record."))
	if (_12_valueOrError6).IsFailure() {
		output = (_12_valueOrError6).PropagateFailure()
		return output
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(Companion_DecryptTest_.Create_DecryptTest_((_1_config).Dtor_value().(TableConfig), _2_encRecords, _3_plainRecords))
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetTableConfigs(data m_JSON_Values.JSON, keys *m_KeyVectors.KeyVectorsClient) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Object(), _dafny.SeqOfString("Search Config list must be an object."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_results _dafny.Map
	_ = _1_results
	_1_results = _dafny.NewMapBuilder().ToMap()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_obj()).Cardinality())
	_ = _hi0
	for _2_i := _dafny.Zero; _2_i.Cmp(_hi0) < 0; _2_i = _2_i.Plus(_dafny.One) {
		var _3_obj _dafny.Tuple
		_ = _3_obj
		_3_obj = ((data).Dtor_obj()).Select((_2_i).Uint32()).(_dafny.Tuple)
		var _4_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _4_valueOrError1
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = Companion_Default___.GetOneTableConfig((*(_3_obj).IndexInt(0)).(_dafny.Sequence), (*(_3_obj).IndexInt(1)).(m_JSON_Values.JSON), keys)
		_4_valueOrError1 = _out0
		if (_4_valueOrError1).IsFailure() {
			output = (_4_valueOrError1).PropagateFailure()
			return output
		}
		var _5_item TableConfig
		_ = _5_item
		_5_item = (_4_valueOrError1).Extract().(TableConfig)
		_1_results = (_1_results).Update((*(_3_obj).IndexInt(0)).(_dafny.Sequence), _5_item)
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(_1_results)
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetItemEncryptor(name _dafny.Sequence, data m_JSON_Values.JSON, keys *m_KeyVectors.KeyVectorsClient) m_Wrappers.Result {
	var encryptor m_Wrappers.Result = m_Wrappers.Result{}
	_ = encryptor
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Object(), _dafny.SeqOfString("A Table Config must be an object."))
	if (_0_valueOrError0).IsFailure() {
		encryptor = (_0_valueOrError0).PropagateFailure()
		return encryptor
	}
	var _1_logicalTableName _dafny.Sequence
	_ = _1_logicalTableName
	_1_logicalTableName = Companion_Default___.TableName()
	var _2_partitionKeyName _dafny.Sequence
	_ = _2_partitionKeyName
	_2_partitionKeyName = Companion_Default___.HashName()
	var _3_sortKeyName m_Wrappers.Option
	_ = _3_sortKeyName
	_3_sortKeyName = m_Wrappers.Companion_Option_.Create_None_()
	var _4_algorithmSuiteId m_Wrappers.Option
	_ = _4_algorithmSuiteId
	_4_algorithmSuiteId = m_Wrappers.Companion_Option_.Create_None_()
	var _5_encrypt _dafny.Sequence
	_ = _5_encrypt
	_5_encrypt = _dafny.SeqOf()
	var _6_attributeActionsOnEncrypt _dafny.Map
	_ = _6_attributeActionsOnEncrypt
	_6_attributeActionsOnEncrypt = _dafny.NewMapBuilder().ToMap()
	var _7_allowed _dafny.Sequence
	_ = _7_allowed
	_7_allowed = _dafny.SeqOf()
	var _8_prefix _dafny.Sequence
	_ = _8_prefix
	_8_prefix = _dafny.SeqOfString("")
	var _9_key _dafny.Sequence
	_ = _9_key
	_9_key = _dafny.SeqOf()
	var _10_stdBeacons _dafny.Sequence
	_ = _10_stdBeacons
	_10_stdBeacons = _dafny.SeqOf()
	var _11_compoundBeacons _dafny.Sequence
	_ = _11_compoundBeacons
	_11_compoundBeacons = _dafny.SeqOf()
	var _12_virtualFields _dafny.Sequence
	_ = _12_virtualFields
	_12_virtualFields = _dafny.SeqOf()
	var _13_keySource m_Wrappers.Option
	_ = _13_keySource
	_13_keySource = m_Wrappers.Companion_Option_.Create_None_()
	var _14_legacyOverride m_Wrappers.Option
	_ = _14_legacyOverride
	_14_legacyOverride = m_Wrappers.Companion_Option_.Create_None_()
	var _15_plaintextOverride m_Wrappers.Option
	_ = _15_plaintextOverride
	_15_plaintextOverride = m_Wrappers.Companion_Option_.Create_None_()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_obj()).Cardinality())
	_ = _hi0
	for _16_i := _dafny.Zero; _16_i.Cmp(_hi0) < 0; _16_i = _16_i.Plus(_dafny.One) {
		var _17_obj _dafny.Tuple
		_ = _17_obj
		_17_obj = ((data).Dtor_obj()).Select((_16_i).Uint32()).(_dafny.Tuple)
		var _source0 _dafny.Sequence = (*(_17_obj).IndexInt(0)).(_dafny.Sequence)
		_ = _source0
		{
			{
				if (_source0).Equals(_dafny.SeqOfString("logicalTableName")) {
					var _18_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _18_valueOrError1
					_18_valueOrError1 = m_Wrappers.Companion_Default___.Need(((*(_17_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("logicalTableName must be of type String."))
					if (_18_valueOrError1).IsFailure() {
						encryptor = (_18_valueOrError1).PropagateFailure()
						return encryptor
					}
					_1_logicalTableName = ((*(_17_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str()
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("partitionKeyName")) {
					var _19_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _19_valueOrError2
					_19_valueOrError2 = m_Wrappers.Companion_Default___.Need(((*(_17_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("partitionKeyName must be of type String."))
					if (_19_valueOrError2).IsFailure() {
						encryptor = (_19_valueOrError2).PropagateFailure()
						return encryptor
					}
					var _20_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _20_valueOrError3
					_20_valueOrError3 = m_Wrappers.Companion_Default___.Need(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__KeySchemaAttributeName(((*(_17_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str()), _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("partitionKeyName '"), ((*(_17_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str()), _dafny.SeqOfString("' is not a valid KeySchemaAttributeName.")))
					if (_20_valueOrError3).IsFailure() {
						encryptor = (_20_valueOrError3).PropagateFailure()
						return encryptor
					}
					_2_partitionKeyName = ((*(_17_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str()
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("sortKeyName")) {
					var _21_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _21_valueOrError4
					_21_valueOrError4 = m_Wrappers.Companion_Default___.Need(((*(_17_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("sortKeyName must be of type String."))
					if (_21_valueOrError4).IsFailure() {
						encryptor = (_21_valueOrError4).PropagateFailure()
						return encryptor
					}
					var _22_valueOrError5 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _22_valueOrError5
					_22_valueOrError5 = m_Wrappers.Companion_Default___.Need(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__KeySchemaAttributeName(((*(_17_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str()), _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("sortKeyName '"), ((*(_17_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str()), _dafny.SeqOfString("' is not a valid KeySchemaAttributeName.")))
					if (_22_valueOrError5).IsFailure() {
						encryptor = (_22_valueOrError5).PropagateFailure()
						return encryptor
					}
					_3_sortKeyName = m_Wrappers.Companion_Option_.Create_Some_(((*(_17_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str())
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("key")) {
					var _23_valueOrError6 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _23_valueOrError6
					_23_valueOrError6 = (m_JSON_API.Companion_Default___.Serialize((*(_17_obj).IndexInt(1)).(m_JSON_Values.JSON))).MapFailure(func(coer6 func(m_JSON_Errors.SerializationError) _dafny.Sequence) func(interface{}) interface{} {
						return func(arg9 interface{}) interface{} {
							return coer6(arg9.(m_JSON_Errors.SerializationError))
						}
					}(func(_24_e m_JSON_Errors.SerializationError) _dafny.Sequence {
						return (_24_e).ToString()
					}))
					if (_23_valueOrError6).IsFailure() {
						encryptor = (_23_valueOrError6).PropagateFailure()
						return encryptor
					}
					_9_key = (_23_valueOrError6).Extract().(_dafny.Sequence)
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("algorithmSuiteId")) {
					var _25_valueOrError7 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _25_valueOrError7
					_25_valueOrError7 = m_Wrappers.Companion_Default___.Need(((*(_17_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("algorithmSuiteId must be of type String."))
					if (_25_valueOrError7).IsFailure() {
						encryptor = (_25_valueOrError7).PropagateFailure()
						return encryptor
					}
					if _dafny.Companion_Sequence_.Equal(((*(_17_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str(), _dafny.SeqOfString("ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384")) {
						_4_algorithmSuiteId = m_Wrappers.Companion_Option_.Create_Some_(m_AwsCryptographyMaterialProvidersTypes.Companion_DBEAlgorithmSuiteId_.Create_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__SYMSIG__HMAC__SHA384_())
					} else if _dafny.Companion_Sequence_.Equal(((*(_17_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str(), _dafny.SeqOfString("ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384")) {
						_4_algorithmSuiteId = m_Wrappers.Companion_Option_.Create_Some_(m_AwsCryptographyMaterialProvidersTypes.Companion_DBEAlgorithmSuiteId_.Create_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384__SYMSIG__HMAC__SHA384_())
					} else {
						encryptor = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("algorithmSuiteId '"), ((*(_17_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str()), _dafny.SeqOfString("' must be either ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384 or ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384")))
						return encryptor
					}
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("plaintextOverride")) {
					var _26_valueOrError8 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _26_valueOrError8
					_26_valueOrError8 = m_Wrappers.Companion_Default___.Need(((*(_17_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("plaintextOverride must be of type String."))
					if (_26_valueOrError8).IsFailure() {
						encryptor = (_26_valueOrError8).PropagateFailure()
						return encryptor
					}
					if _dafny.Companion_Sequence_.Equal(((*(_17_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str(), _dafny.SeqOfString("FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ")) {
						_15_plaintextOverride = m_Wrappers.Companion_Option_.Create_Some_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_PlaintextOverride_.Create_FORCE__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ_())
					} else if _dafny.Companion_Sequence_.Equal(((*(_17_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str(), _dafny.SeqOfString("FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ")) {
						_15_plaintextOverride = m_Wrappers.Companion_Option_.Create_Some_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_PlaintextOverride_.Create_FORBID__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ_())
					} else if _dafny.Companion_Sequence_.Equal(((*(_17_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str(), _dafny.SeqOfString("FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ")) {
						_15_plaintextOverride = m_Wrappers.Companion_Option_.Create_Some_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_PlaintextOverride_.Create_FORBID__PLAINTEXT__WRITE__FORBID__PLAINTEXT__READ_())
					} else {
						encryptor = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("plaintextOverride '"), ((*(_17_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str()), _dafny.SeqOfString("' must be one of FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ, FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ or FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ")))
						return encryptor
					}
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("attributeActionsOnEncrypt")) {
					var _27_valueOrError9 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
					_ = _27_valueOrError9
					var _out0 m_Wrappers.Result
					_ = _out0
					_out0 = Companion_Default___.GetAttributeActions((*(_17_obj).IndexInt(1)).(m_JSON_Values.JSON))
					_27_valueOrError9 = _out0
					if (_27_valueOrError9).IsFailure() {
						encryptor = (_27_valueOrError9).PropagateFailure()
						return encryptor
					}
					_6_attributeActionsOnEncrypt = (_27_valueOrError9).Extract().(_dafny.Map)
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("allowedUnsignedAttributePrefix")) {
					var _28_valueOrError10 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _28_valueOrError10
					_28_valueOrError10 = m_Wrappers.Companion_Default___.Need(((*(_17_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("allowedUnsignedAttributePrefix must be of type String."))
					if (_28_valueOrError10).IsFailure() {
						encryptor = (_28_valueOrError10).PropagateFailure()
						return encryptor
					}
					_8_prefix = ((*(_17_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str()
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("allowedUnsignedAttributes")) {
					var _29_valueOrError11 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _29_valueOrError11
					var _out1 m_Wrappers.Result
					_ = _out1
					_out1 = Companion_Default___.GetAttrNames((*(_17_obj).IndexInt(1)).(m_JSON_Values.JSON))
					_29_valueOrError11 = _out1
					if (_29_valueOrError11).IsFailure() {
						encryptor = (_29_valueOrError11).PropagateFailure()
						return encryptor
					}
					_7_allowed = (_29_valueOrError11).Extract().(_dafny.Sequence)
					goto Lmatch0
				}
			}
			{
				encryptor = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Unexpected part of a table config : '"), (*(_17_obj).IndexInt(0)).(_dafny.Sequence)), _dafny.SeqOfString("'")))
				return encryptor
			}
			goto Lmatch0
		}
	Lmatch0:
	}
	var _30_valueOrError13 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyMaterialProvidersTestVectorKeysTypes.Companion_KeyDescription_.Default())
	_ = _30_valueOrError13
	if (_dafny.IntOfUint32((_9_key).Cardinality())).Sign() == 0 {
		_30_valueOrError13 = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyMaterialProvidersTestVectorKeysTypes.Companion_KeyDescription_.Create_Hierarchy_(m_AwsCryptographyMaterialProvidersTestVectorKeysTypes.Companion_HierarchyKeyring_.Create_HierarchyKeyring_(_dafny.SeqOfString("static-branch-key-1"))))
	} else {
		var _31_valueOrError12 m_Wrappers.Result = ((keys).GetKeyDescription(m_AwsCryptographyMaterialProvidersTestVectorKeysTypes.Companion_GetKeyDescriptionInput_.Create_GetKeyDescriptionInput_(_9_key))).MapFailure(func(coer7 func(m_AwsCryptographyMaterialProvidersTestVectorKeysTypes.Error) _dafny.Sequence) func(interface{}) interface{} {
			return func(arg10 interface{}) interface{} {
				return coer7(arg10.(m_AwsCryptographyMaterialProvidersTestVectorKeysTypes.Error))
			}
		}(m_ParseJsonManifests.Companion_Default___.ErrorToString))
		_ = _31_valueOrError12
		if (_31_valueOrError12).IsFailure() {
			_30_valueOrError13 = (_31_valueOrError12).PropagateFailure()
		} else {
			var _32_keyOut m_AwsCryptographyMaterialProvidersTestVectorKeysTypes.GetKeyDescriptionOutput = (_31_valueOrError12).Extract().(m_AwsCryptographyMaterialProvidersTestVectorKeysTypes.GetKeyDescriptionOutput)
			_ = _32_keyOut
			_30_valueOrError13 = m_Wrappers.Companion_Result_.Create_Success_((_32_keyOut).Dtor_keyDescription())
		}
	}
	if (_30_valueOrError13).IsFailure() {
		encryptor = (_30_valueOrError13).PropagateFailure()
		return encryptor
	}
	var _33_keyDescription m_AwsCryptographyMaterialProvidersTestVectorKeysTypes.KeyDescription
	_ = _33_keyDescription
	_33_keyDescription = (_30_valueOrError13).Extract().(m_AwsCryptographyMaterialProvidersTestVectorKeysTypes.KeyDescription)
	var _34_valueOrError14 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _34_valueOrError14
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = (keys).CreateWrappedTestVectorKeyring(m_AwsCryptographyMaterialProvidersTestVectorKeysTypes.Companion_TestVectorKeyringInput_.Create_TestVectorKeyringInput_(_33_keyDescription))
	_34_valueOrError14 = _out2
	if !(!((_34_valueOrError14).IsFailure())) {
		panic("dafny/DDBEncryption/src/JsonConfig.dfy(347,19): " + (_34_valueOrError14).String())
	}
	var _35_keyring m_AwsCryptographyMaterialProvidersTypes.IKeyring
	_ = _35_keyring
	_35_keyring = m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.CastTo_((_34_valueOrError14).Extract())
	var _36_encryptorConfig m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DynamoDbItemEncryptorConfig
	_ = _36_encryptorConfig
	_36_encryptorConfig = m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_DynamoDbItemEncryptorConfig_.Create_DynamoDbItemEncryptorConfig_(_1_logicalTableName, _2_partitionKeyName, _3_sortKeyName, _6_attributeActionsOnEncrypt, Companion_Default___.OptSeq(_7_allowed), Companion_Default___.OptSeq(_8_prefix), _4_algorithmSuiteId, m_Wrappers.Companion_Option_.Create_Some_(_35_keyring), m_Wrappers.Companion_Option_.Create_None_(), _14_legacyOverride, _15_plaintextOverride)
	var _37_valueOrError15 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _37_valueOrError15
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_CreateWrappedItemEncryptor.CreateWrappedItemEncryptor(_36_encryptorConfig)
	_37_valueOrError15 = _out3
	if !(!((_37_valueOrError15).IsFailure())) {
		panic("dafny/DDBEncryption/src/JsonConfig.dfy(363,50): " + (_37_valueOrError15).String())
	}
	var _38_enc m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.IDynamoDbItemEncryptorClient
	_ = _38_enc
	_38_enc = m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_IDynamoDbItemEncryptorClient_.CastTo_((_37_valueOrError15).Extract())
	encryptor = m_Wrappers.Companion_Result_.Create_Success_(_38_enc)
	return encryptor
	return encryptor
}
func (_static *CompanionStruct_Default___) GetOneTableConfig(name _dafny.Sequence, data m_JSON_Values.JSON, keys *m_KeyVectors.KeyVectorsClient) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Object(), _dafny.SeqOfString("A Table Config must be an object."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_logicalTableName _dafny.Sequence
	_ = _1_logicalTableName
	_1_logicalTableName = Companion_Default___.TableName()
	var _2_partitionKeyName _dafny.Sequence
	_ = _2_partitionKeyName
	_2_partitionKeyName = Companion_Default___.HashName()
	var _3_sortKeyName m_Wrappers.Option
	_ = _3_sortKeyName
	_3_sortKeyName = m_Wrappers.Companion_Option_.Create_None_()
	var _4_algorithmSuiteId m_Wrappers.Option
	_ = _4_algorithmSuiteId
	_4_algorithmSuiteId = m_Wrappers.Companion_Option_.Create_None_()
	var _5_encrypt _dafny.Sequence
	_ = _5_encrypt
	_5_encrypt = _dafny.SeqOf()
	var _6_attributeActionsOnEncrypt _dafny.Map
	_ = _6_attributeActionsOnEncrypt
	_6_attributeActionsOnEncrypt = _dafny.NewMapBuilder().ToMap()
	var _7_allowed _dafny.Sequence
	_ = _7_allowed
	_7_allowed = _dafny.SeqOf()
	var _8_prefix _dafny.Sequence
	_ = _8_prefix
	_8_prefix = _dafny.SeqOfString("")
	var _9_key _dafny.Sequence
	_ = _9_key
	_9_key = _dafny.SeqOf()
	var _10_stdBeacons _dafny.Sequence
	_ = _10_stdBeacons
	_10_stdBeacons = _dafny.SeqOf()
	var _11_compoundBeacons _dafny.Sequence
	_ = _11_compoundBeacons
	_11_compoundBeacons = _dafny.SeqOf()
	var _12_virtualFields _dafny.Sequence
	_ = _12_virtualFields
	_12_virtualFields = _dafny.SeqOf()
	var _13_keySource m_Wrappers.Option
	_ = _13_keySource
	_13_keySource = m_Wrappers.Companion_Option_.Create_None_()
	var _14_search m_Wrappers.Option
	_ = _14_search
	_14_search = m_Wrappers.Companion_Option_.Create_None_()
	var _15_legacyOverride m_Wrappers.Option
	_ = _15_legacyOverride
	_15_legacyOverride = m_Wrappers.Companion_Option_.Create_None_()
	var _16_plaintextOverride m_Wrappers.Option
	_ = _16_plaintextOverride
	_16_plaintextOverride = m_Wrappers.Companion_Option_.Create_None_()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_obj()).Cardinality())
	_ = _hi0
	for _17_i := _dafny.Zero; _17_i.Cmp(_hi0) < 0; _17_i = _17_i.Plus(_dafny.One) {
		var _18_obj _dafny.Tuple
		_ = _18_obj
		_18_obj = ((data).Dtor_obj()).Select((_17_i).Uint32()).(_dafny.Tuple)
		var _source0 _dafny.Sequence = (*(_18_obj).IndexInt(0)).(_dafny.Sequence)
		_ = _source0
		{
			{
				if (_source0).Equals(_dafny.SeqOfString("logicalTableName")) {
					var _19_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _19_valueOrError1
					_19_valueOrError1 = m_Wrappers.Companion_Default___.Need(((*(_18_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("logicalTableName must be of type String."))
					if (_19_valueOrError1).IsFailure() {
						output = (_19_valueOrError1).PropagateFailure()
						return output
					}
					_1_logicalTableName = ((*(_18_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str()
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("partitionKeyName")) {
					var _20_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _20_valueOrError2
					_20_valueOrError2 = m_Wrappers.Companion_Default___.Need(((*(_18_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("partitionKeyName must be of type String."))
					if (_20_valueOrError2).IsFailure() {
						output = (_20_valueOrError2).PropagateFailure()
						return output
					}
					var _21_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _21_valueOrError3
					_21_valueOrError3 = m_Wrappers.Companion_Default___.Need(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__KeySchemaAttributeName(((*(_18_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str()), _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("partitionKeyName '"), ((*(_18_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str()), _dafny.SeqOfString("' is not a valid KeySchemaAttributeName.")))
					if (_21_valueOrError3).IsFailure() {
						output = (_21_valueOrError3).PropagateFailure()
						return output
					}
					_2_partitionKeyName = ((*(_18_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str()
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("sortKeyName")) {
					var _22_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _22_valueOrError4
					_22_valueOrError4 = m_Wrappers.Companion_Default___.Need(((*(_18_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("sortKeyName must be of type String."))
					if (_22_valueOrError4).IsFailure() {
						output = (_22_valueOrError4).PropagateFailure()
						return output
					}
					var _23_valueOrError5 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _23_valueOrError5
					_23_valueOrError5 = m_Wrappers.Companion_Default___.Need(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__KeySchemaAttributeName(((*(_18_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str()), _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("sortKeyName '"), ((*(_18_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str()), _dafny.SeqOfString("' is not a valid KeySchemaAttributeName.")))
					if (_23_valueOrError5).IsFailure() {
						output = (_23_valueOrError5).PropagateFailure()
						return output
					}
					_3_sortKeyName = m_Wrappers.Companion_Option_.Create_Some_(((*(_18_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str())
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("key")) {
					var _24_valueOrError6 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _24_valueOrError6
					_24_valueOrError6 = (m_JSON_API.Companion_Default___.Serialize((*(_18_obj).IndexInt(1)).(m_JSON_Values.JSON))).MapFailure(func(coer8 func(m_JSON_Errors.SerializationError) _dafny.Sequence) func(interface{}) interface{} {
						return func(arg11 interface{}) interface{} {
							return coer8(arg11.(m_JSON_Errors.SerializationError))
						}
					}(func(_25_e m_JSON_Errors.SerializationError) _dafny.Sequence {
						return (_25_e).ToString()
					}))
					if (_24_valueOrError6).IsFailure() {
						output = (_24_valueOrError6).PropagateFailure()
						return output
					}
					_9_key = (_24_valueOrError6).Extract().(_dafny.Sequence)
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("algorithmSuiteId")) {
					var _26_valueOrError7 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _26_valueOrError7
					_26_valueOrError7 = m_Wrappers.Companion_Default___.Need(((*(_18_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("algorithmSuiteId must be of type String."))
					if (_26_valueOrError7).IsFailure() {
						output = (_26_valueOrError7).PropagateFailure()
						return output
					}
					if _dafny.Companion_Sequence_.Equal(((*(_18_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str(), _dafny.SeqOfString("ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384")) {
						_4_algorithmSuiteId = m_Wrappers.Companion_Option_.Create_Some_(m_AwsCryptographyMaterialProvidersTypes.Companion_DBEAlgorithmSuiteId_.Create_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__SYMSIG__HMAC__SHA384_())
					} else if _dafny.Companion_Sequence_.Equal(((*(_18_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str(), _dafny.SeqOfString("ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384")) {
						_4_algorithmSuiteId = m_Wrappers.Companion_Option_.Create_Some_(m_AwsCryptographyMaterialProvidersTypes.Companion_DBEAlgorithmSuiteId_.Create_ALG__AES__256__GCM__HKDF__SHA512__COMMIT__KEY__ECDSA__P384__SYMSIG__HMAC__SHA384_())
					} else {
						output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("algorithmSuiteId '"), ((*(_18_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str()), _dafny.SeqOfString("' must be either ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384 or ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384")))
						return output
					}
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("plaintextOverride")) {
					var _27_valueOrError8 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _27_valueOrError8
					_27_valueOrError8 = m_Wrappers.Companion_Default___.Need(((*(_18_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("plaintextOverride must be of type String."))
					if (_27_valueOrError8).IsFailure() {
						output = (_27_valueOrError8).PropagateFailure()
						return output
					}
					if _dafny.Companion_Sequence_.Equal(((*(_18_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str(), _dafny.SeqOfString("FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ")) {
						_16_plaintextOverride = m_Wrappers.Companion_Option_.Create_Some_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_PlaintextOverride_.Create_FORCE__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ_())
					} else if _dafny.Companion_Sequence_.Equal(((*(_18_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str(), _dafny.SeqOfString("FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ")) {
						_16_plaintextOverride = m_Wrappers.Companion_Option_.Create_Some_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_PlaintextOverride_.Create_FORBID__PLAINTEXT__WRITE__ALLOW__PLAINTEXT__READ_())
					} else if _dafny.Companion_Sequence_.Equal(((*(_18_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str(), _dafny.SeqOfString("FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ")) {
						_16_plaintextOverride = m_Wrappers.Companion_Option_.Create_Some_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_PlaintextOverride_.Create_FORBID__PLAINTEXT__WRITE__FORBID__PLAINTEXT__READ_())
					} else {
						output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("plaintextOverride '"), ((*(_18_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str()), _dafny.SeqOfString("' must be one of FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ, FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ or FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ")))
						return output
					}
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("attributeActionsOnEncrypt")) {
					var _28_valueOrError9 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
					_ = _28_valueOrError9
					var _out0 m_Wrappers.Result
					_ = _out0
					_out0 = Companion_Default___.GetAttributeActions((*(_18_obj).IndexInt(1)).(m_JSON_Values.JSON))
					_28_valueOrError9 = _out0
					if (_28_valueOrError9).IsFailure() {
						output = (_28_valueOrError9).PropagateFailure()
						return output
					}
					_6_attributeActionsOnEncrypt = (_28_valueOrError9).Extract().(_dafny.Map)
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("allowedUnsignedAttributePrefix")) {
					var _29_valueOrError10 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _29_valueOrError10
					_29_valueOrError10 = m_Wrappers.Companion_Default___.Need(((*(_18_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("allowedUnsignedAttributePrefix must be of type String."))
					if (_29_valueOrError10).IsFailure() {
						output = (_29_valueOrError10).PropagateFailure()
						return output
					}
					_8_prefix = ((*(_18_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str()
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("allowedUnsignedAttributes")) {
					var _30_valueOrError11 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _30_valueOrError11
					var _out1 m_Wrappers.Result
					_ = _out1
					_out1 = Companion_Default___.GetAttrNames((*(_18_obj).IndexInt(1)).(m_JSON_Values.JSON))
					_30_valueOrError11 = _out1
					if (_30_valueOrError11).IsFailure() {
						output = (_30_valueOrError11).PropagateFailure()
						return output
					}
					_7_allowed = (_30_valueOrError11).Extract().(_dafny.Sequence)
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("search")) {
					var _31_valueOrError12 m_Wrappers.Result = m_Wrappers.Result{}
					_ = _31_valueOrError12
					var _out2 m_Wrappers.Result
					_ = _out2
					_out2 = Companion_Default___.GetOneSearchConfig((*(_18_obj).IndexInt(1)).(m_JSON_Values.JSON))
					_31_valueOrError12 = _out2
					if (_31_valueOrError12).IsFailure() {
						output = (_31_valueOrError12).PropagateFailure()
						return output
					}
					var _32_src m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.SearchConfig
					_ = _32_src
					_32_src = (_31_valueOrError12).Extract().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.SearchConfig)
					_14_search = m_Wrappers.Companion_Option_.Create_Some_(_32_src)
					goto Lmatch0
				}
			}
			{
				output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Unexpected part of a table config : '"), (*(_18_obj).IndexInt(0)).(_dafny.Sequence)), _dafny.SeqOfString("'")))
				return output
			}
			goto Lmatch0
		}
	Lmatch0:
	}
	var _33_valueOrError14 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyMaterialProvidersTestVectorKeysTypes.Companion_KeyDescription_.Default())
	_ = _33_valueOrError14
	if (_dafny.IntOfUint32((_9_key).Cardinality())).Sign() == 0 {
		_33_valueOrError14 = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyMaterialProvidersTestVectorKeysTypes.Companion_KeyDescription_.Create_Hierarchy_(m_AwsCryptographyMaterialProvidersTestVectorKeysTypes.Companion_HierarchyKeyring_.Create_HierarchyKeyring_(_dafny.SeqOfString("static-branch-key-1"))))
	} else {
		var _34_valueOrError13 m_Wrappers.Result = ((keys).GetKeyDescription(m_AwsCryptographyMaterialProvidersTestVectorKeysTypes.Companion_GetKeyDescriptionInput_.Create_GetKeyDescriptionInput_(_9_key))).MapFailure(func(coer9 func(m_AwsCryptographyMaterialProvidersTestVectorKeysTypes.Error) _dafny.Sequence) func(interface{}) interface{} {
			return func(arg12 interface{}) interface{} {
				return coer9(arg12.(m_AwsCryptographyMaterialProvidersTestVectorKeysTypes.Error))
			}
		}(m_ParseJsonManifests.Companion_Default___.ErrorToString))
		_ = _34_valueOrError13
		if (_34_valueOrError13).IsFailure() {
			_33_valueOrError14 = (_34_valueOrError13).PropagateFailure()
		} else {
			var _35_keyOut m_AwsCryptographyMaterialProvidersTestVectorKeysTypes.GetKeyDescriptionOutput = (_34_valueOrError13).Extract().(m_AwsCryptographyMaterialProvidersTestVectorKeysTypes.GetKeyDescriptionOutput)
			_ = _35_keyOut
			_33_valueOrError14 = m_Wrappers.Companion_Result_.Create_Success_((_35_keyOut).Dtor_keyDescription())
		}
	}
	if (_33_valueOrError14).IsFailure() {
		output = (_33_valueOrError14).PropagateFailure()
		return output
	}
	var _36_keyDescription m_AwsCryptographyMaterialProvidersTestVectorKeysTypes.KeyDescription
	_ = _36_keyDescription
	_36_keyDescription = (_33_valueOrError14).Extract().(m_AwsCryptographyMaterialProvidersTestVectorKeysTypes.KeyDescription)
	var _37_valueOrError15 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _37_valueOrError15
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = (keys).CreateWrappedTestVectorKeyring(m_AwsCryptographyMaterialProvidersTestVectorKeysTypes.Companion_TestVectorKeyringInput_.Create_TestVectorKeyringInput_(_36_keyDescription))
	_37_valueOrError15 = _out3
	if !(!((_37_valueOrError15).IsFailure())) {
		panic("dafny/DDBEncryption/src/JsonConfig.dfy(448,19): " + (_37_valueOrError15).String())
	}
	var _38_keyring m_AwsCryptographyMaterialProvidersTypes.IKeyring
	_ = _38_keyring
	_38_keyring = m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.CastTo_((_37_valueOrError15).Extract())
	var _39_config m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig
	_ = _39_config
	_39_config = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_DynamoDbTableEncryptionConfig_.Create_DynamoDbTableEncryptionConfig_(_1_logicalTableName, _2_partitionKeyName, _3_sortKeyName, _14_search, _6_attributeActionsOnEncrypt, Companion_Default___.OptSeq(_7_allowed), Companion_Default___.OptSeq(_8_prefix), _4_algorithmSuiteId, m_Wrappers.Companion_Option_.Create_Some_(_38_keyring), m_Wrappers.Companion_Option_.Create_None_(), _15_legacyOverride, _16_plaintextOverride)
	output = m_Wrappers.Companion_Result_.Create_Success_(Companion_TableConfig_.Create_TableConfig_(name, _39_config, (_dafny.IntOfUint32(((data).Dtor_obj()).Cardinality())).Sign() == 0))
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetOneSearchConfig(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Object(), _dafny.SeqOfString("A Search Config must be an object."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_writeVersion _dafny.Int
	_ = _1_writeVersion
	_1_writeVersion = _dafny.One
	var _2_versions _dafny.Sequence
	_ = _2_versions
	_2_versions = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_obj()).Cardinality())
	_ = _hi0
	for _3_i := _dafny.Zero; _3_i.Cmp(_hi0) < 0; _3_i = _3_i.Plus(_dafny.One) {
		var _4_obj _dafny.Tuple
		_ = _4_obj
		_4_obj = ((data).Dtor_obj()).Select((_3_i).Uint32()).(_dafny.Tuple)
		var _source0 _dafny.Sequence = (*(_4_obj).IndexInt(0)).(_dafny.Sequence)
		_ = _source0
		{
			{
				if (_source0).Equals(_dafny.SeqOfString("versions")) {
					var _5_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _5_valueOrError1
					_5_valueOrError1 = m_Wrappers.Companion_Default___.Need(((*(_4_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_Array(), _dafny.SeqOfString("versions must be an Array."))
					if (_5_valueOrError1).IsFailure() {
						output = (_5_valueOrError1).PropagateFailure()
						return output
					}
					var _hi1 _dafny.Int = _dafny.IntOfUint32((((*(_4_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_arr()).Cardinality())
					_ = _hi1
					for _6_j := _dafny.Zero; _6_j.Cmp(_hi1) < 0; _6_j = _6_j.Plus(_dafny.One) {
						var _7_valueOrError2 m_Wrappers.Result = m_Wrappers.Result{}
						_ = _7_valueOrError2
						var _out0 m_Wrappers.Result
						_ = _out0
						_out0 = Companion_Default___.GetOneBeaconVersion((((*(_4_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_arr()).Select((_6_j).Uint32()).(m_JSON_Values.JSON))
						_7_valueOrError2 = _out0
						if (_7_valueOrError2).IsFailure() {
							output = (_7_valueOrError2).PropagateFailure()
							return output
						}
						var _8_v m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion
						_ = _8_v
						_8_v = (_7_valueOrError2).Extract().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconVersion)
						_2_versions = _dafny.Companion_Sequence_.Concatenate(_2_versions, _dafny.SeqOf(_8_v))
					}
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("writeVersion")) {
					var _9_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _9_valueOrError3
					_9_valueOrError3 = m_Wrappers.Companion_Default___.Need(((*(_4_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_Number(), _dafny.SeqOfString("writeVersion must be a number"))
					if (_9_valueOrError3).IsFailure() {
						output = (_9_valueOrError3).PropagateFailure()
						return output
					}
					var _10_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.Zero)
					_ = _10_valueOrError4
					_10_valueOrError4 = Companion_Default___.DecimalToNat(((*(_4_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_num())
					if (_10_valueOrError4).IsFailure() {
						output = (_10_valueOrError4).PropagateFailure()
						return output
					}
					_1_writeVersion = (_10_valueOrError4).Extract().(_dafny.Int)
					goto Lmatch0
				}
			}
			{
				output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Unexpected part of a search config : '"), (*(_4_obj).IndexInt(0)).(_dafny.Sequence)), _dafny.SeqOfString("'")))
				return output
			}
			goto Lmatch0
		}
	Lmatch0:
	}
	var _11_valueOrError5 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _11_valueOrError5
	_11_valueOrError5 = m_Wrappers.Companion_Default___.Need(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Default___.IsValid__BeaconVersionList(_2_versions), _dafny.SeqOfString("versions needs at least one version"))
	if (_11_valueOrError5).IsFailure() {
		output = (_11_valueOrError5).PropagateFailure()
		return output
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_SearchConfig_.Create_SearchConfig_(_2_versions, int32(1)))
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetOneBeaconVersion(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Object(), _dafny.SeqOfString("A Beacon Version must be an object."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_standardBeacons _dafny.Sequence
	_ = _1_standardBeacons
	_1_standardBeacons = _dafny.SeqOf()
	var _2_compoundBeacons _dafny.Sequence
	_ = _2_compoundBeacons
	_2_compoundBeacons = _dafny.SeqOf()
	var _3_virtualFields _dafny.Sequence
	_ = _3_virtualFields
	_3_virtualFields = _dafny.SeqOf()
	var _4_keySource m_Wrappers.Option
	_ = _4_keySource
	_4_keySource = m_Wrappers.Companion_Option_.Create_None_()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_obj()).Cardinality())
	_ = _hi0
	for _5_i := _dafny.Zero; _5_i.Cmp(_hi0) < 0; _5_i = _5_i.Plus(_dafny.One) {
		var _6_obj _dafny.Tuple
		_ = _6_obj
		_6_obj = ((data).Dtor_obj()).Select((_5_i).Uint32()).(_dafny.Tuple)
		var _source0 _dafny.Sequence = (*(_6_obj).IndexInt(0)).(_dafny.Sequence)
		_ = _source0
		{
			{
				if (_source0).Equals(_dafny.SeqOfString("keySource")) {
					var _7_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconKeySource_.Default())
					_ = _7_valueOrError1
					var _out0 m_Wrappers.Result
					_ = _out0
					_out0 = Companion_Default___.GetKeySource((*(_6_obj).IndexInt(1)).(m_JSON_Values.JSON))
					_7_valueOrError1 = _out0
					if (_7_valueOrError1).IsFailure() {
						output = (_7_valueOrError1).PropagateFailure()
						return output
					}
					var _8_src m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconKeySource
					_ = _8_src
					_8_src = (_7_valueOrError1).Extract().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconKeySource)
					_4_keySource = m_Wrappers.Companion_Option_.Create_Some_(_8_src)
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("standardBeacons")) {
					var _9_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _9_valueOrError2
					var _out1 m_Wrappers.Result
					_ = _out1
					_out1 = Companion_Default___.GetStandardBeacons((*(_6_obj).IndexInt(1)).(m_JSON_Values.JSON))
					_9_valueOrError2 = _out1
					if (_9_valueOrError2).IsFailure() {
						output = (_9_valueOrError2).PropagateFailure()
						return output
					}
					_1_standardBeacons = (_9_valueOrError2).Extract().(_dafny.Sequence)
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("compoundBeacons")) {
					var _10_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _10_valueOrError3
					var _out2 m_Wrappers.Result
					_ = _out2
					_out2 = Companion_Default___.GetCompoundBeacons((*(_6_obj).IndexInt(1)).(m_JSON_Values.JSON))
					_10_valueOrError3 = _out2
					if (_10_valueOrError3).IsFailure() {
						output = (_10_valueOrError3).PropagateFailure()
						return output
					}
					_2_compoundBeacons = (_10_valueOrError3).Extract().(_dafny.Sequence)
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("virtualFields")) {
					var _11_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _11_valueOrError4
					var _out3 m_Wrappers.Result
					_ = _out3
					_out3 = Companion_Default___.GetVirtualFields((*(_6_obj).IndexInt(1)).(m_JSON_Values.JSON))
					_11_valueOrError4 = _out3
					if (_11_valueOrError4).IsFailure() {
						output = (_11_valueOrError4).PropagateFailure()
						return output
					}
					_3_virtualFields = (_11_valueOrError4).Extract().(_dafny.Sequence)
					goto Lmatch0
				}
			}
			{
				output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Unexpected part of a beacon version : '"), (*(_6_obj).IndexInt(0)).(_dafny.Sequence)), _dafny.SeqOfString("'")))
				return output
			}
			goto Lmatch0
		}
	Lmatch0:
	}
	var _12_valueOrError5 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _12_valueOrError5
	_12_valueOrError5 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((_1_standardBeacons).Cardinality())).Sign() == 1, _dafny.SeqOfString("A Search Config needs at least one standard beacon."))
	if (_12_valueOrError5).IsFailure() {
		output = (_12_valueOrError5).PropagateFailure()
		return output
	}
	var _13_keyMaterial m_KeyMaterial.KeyMaterial
	_ = _13_keyMaterial
	_13_keyMaterial = m_KeyMaterial.Companion_KeyMaterial_.Create_StaticKeyStoreInformation_(_dafny.SeqOfString("abc"), Companion_Default___.Abc(), _dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)))
	var _14_store m_AwsCryptographyKeyStoreTypes.IKeyStoreClient
	_ = _14_store
	var _out4 m_AwsCryptographyKeyStoreTypes.IKeyStoreClient
	_ = _out4
	_out4 = m_CreateStaticKeyStores.Companion_Default___.CreateStaticKeyStore(_13_keyMaterial)
	_14_store = _out4
	var _15_source m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconKeySource
	_ = _15_source
	if (_4_keySource).Is_Some() {
		_15_source = (_4_keySource).Dtor_value().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconKeySource)
	} else {
		_15_source = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconKeySource_.Create_single_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_SingleKeyStore_.Create_SingleKeyStore_(_dafny.SeqOfString("foo"), int32(42), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_()))
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconVersion_.Create_BeaconVersion_(int32(1), _14_store, _15_source, _1_standardBeacons, Companion_Default___.OptSeq(_2_compoundBeacons), Companion_Default___.OptSeq(_3_virtualFields), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_()))
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetFakeBeaconVersion() m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_keyMaterial m_KeyMaterial.KeyMaterial
	_ = _0_keyMaterial
	_0_keyMaterial = m_KeyMaterial.Companion_KeyMaterial_.Create_StaticKeyStoreInformation_(_dafny.SeqOfString("abc"), Companion_Default___.Abc(), _dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)), _dafny.SeqOf(uint8(1), uint8(2), uint8(3), uint8(4), uint8(5)))
	var _1_store m_AwsCryptographyKeyStoreTypes.IKeyStoreClient
	_ = _1_store
	var _out0 m_AwsCryptographyKeyStoreTypes.IKeyStoreClient
	_ = _out0
	_out0 = m_CreateStaticKeyStores.Companion_Default___.CreateStaticKeyStore(_0_keyMaterial)
	_1_store = _out0
	var _2_source m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.BeaconKeySource
	_ = _2_source
	_2_source = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconKeySource_.Create_single_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_SingleKeyStore_.Create_SingleKeyStore_(_dafny.SeqOfString("foo"), int32(42), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_()))
	var _3_sb m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon
	_ = _3_sb
	_3_sb = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_StandardBeacon_.Create_StandardBeacon_(_dafny.SeqOfString("name"), int32(5), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
	var _4_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _4_valueOrError0
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_MaterialProviders.Companion_Default___.MaterialProviders(m_MaterialProviders.Companion_Default___.DefaultMaterialProvidersConfig())
	_4_valueOrError0 = _out1
	if !(!((_4_valueOrError0).IsFailure())) {
		panic("dafny/DDBEncryption/src/JsonConfig.dfy(547,15): " + (_4_valueOrError0).String())
	}
	var _5_mpl *m_MaterialProviders.MaterialProvidersClient
	_ = _5_mpl
	_5_mpl = (_4_valueOrError0).Extract().(*m_MaterialProviders.MaterialProvidersClient)
	var _6_cacheType m_AwsCryptographyMaterialProvidersTypes.CacheType
	_ = _6_cacheType
	_6_cacheType = m_AwsCryptographyMaterialProvidersTypes.Companion_CacheType_.Create_Default_(m_AwsCryptographyMaterialProvidersTypes.Companion_DefaultCache_.Create_DefaultCache_(int32(1)))
	var _7_input m_AwsCryptographyMaterialProvidersTypes.CreateCryptographicMaterialsCacheInput
	_ = _7_input
	_7_input = m_AwsCryptographyMaterialProvidersTypes.Companion_CreateCryptographicMaterialsCacheInput_.Create_CreateCryptographicMaterialsCacheInput_(_6_cacheType)
	var _8_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _8_valueOrError1
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = (_5_mpl).CreateCryptographicMaterialsCache(_7_input)
	_8_valueOrError1 = _out2
	if !(!((_8_valueOrError1).IsFailure())) {
		panic("dafny/DDBEncryption/src/JsonConfig.dfy(554,17): " + (_8_valueOrError1).String())
	}
	var _9_cache m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsCache
	_ = _9_cache
	_9_cache = m_AwsCryptographyMaterialProvidersTypes.Companion_ICryptographicMaterialsCache_.CastTo_((_8_valueOrError1).Extract())
	var _10_valueOrError2 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _10_valueOrError2
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_AtomicPrimitives.Companion_Default___.AtomicPrimitives(m_AtomicPrimitives.Companion_Default___.DefaultCryptoConfig())
	_10_valueOrError2 = _out3
	if !(!((_10_valueOrError2).IsFailure())) {
		panic("dafny/DDBEncryption/src/JsonConfig.dfy(556,18): " + (_10_valueOrError2).String())
	}
	var _11_client *m_AtomicPrimitives.AtomicPrimitivesClient
	_ = _11_client
	_11_client = (_10_valueOrError2).Extract().(*m_AtomicPrimitives.AtomicPrimitivesClient)
	var _12_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _12_valueOrError3
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = m_SearchableEncryptionInfo.Companion_Default___.GenerateUuidBytes()
	_12_valueOrError3 = _out4
	if !(!((_12_valueOrError3).IsFailure())) {
		panic("dafny/DDBEncryption/src/JsonConfig.dfy(559,41): " + (_12_valueOrError3).String())
	}
	var _13_partitionIdBytes _dafny.Sequence
	_ = _13_partitionIdBytes
	_13_partitionIdBytes = (_12_valueOrError3).Extract().(_dafny.Sequence)
	var _14_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _14_valueOrError4
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = m_SearchableEncryptionInfo.Companion_Default___.GenerateUuidBytes()
	_14_valueOrError4 = _out5
	if !(!((_14_valueOrError4).IsFailure())) {
		panic("dafny/DDBEncryption/src/JsonConfig.dfy(570,49): " + (_14_valueOrError4).String())
	}
	var _15_logicalKeyStoreNameBytes _dafny.Sequence
	_ = _15_logicalKeyStoreNameBytes
	_15_logicalKeyStoreNameBytes = (_14_valueOrError4).Extract().(_dafny.Sequence)
	var _16_src m_SearchableEncryptionInfo.KeySource
	_ = _16_src
	_16_src = m_SearchableEncryptionInfo.Companion_KeySource_.Create_KeySource_(_11_client, _1_store, m_SearchableEncryptionInfo.Companion_KeyLocation_.Create_SingleLoc_(_dafny.SeqOfString("foo")), _9_cache, uint32(100), _13_partitionIdBytes, _15_logicalKeyStoreNameBytes)
	var _17_valueOrError5 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _17_valueOrError5
	_17_valueOrError5 = m_SearchableEncryptionInfo.Companion_Default___.MakeBeaconVersion(uint8(1), _16_src, _dafny.NewMapBuilder().ToMap(), _dafny.NewMapBuilder().ToMap(), _dafny.NewMapBuilder().ToMap())
	if !(!((_17_valueOrError5).IsFailure())) {
		panic("dafny/DDBEncryption/src/JsonConfig.dfy(574,14): " + (_17_valueOrError5).String())
	}
	var _18_bv m_SearchableEncryptionInfo.BeaconVersion
	_ = _18_bv
	_18_bv = (_17_valueOrError5).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
	output = m_Wrappers.Companion_Result_.Create_Success_(_18_bv)
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetAttributeActions(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Object(), _dafny.SeqOfString("attributeActionsOnEncrypt must be an object"))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_result _dafny.Map
	_ = _1_result
	_1_result = _dafny.NewMapBuilder().ToMap()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_obj()).Cardinality())
	_ = _hi0
	for _2_i := _dafny.Zero; _2_i.Cmp(_hi0) < 0; _2_i = _2_i.Plus(_dafny.One) {
		var _3_obj _dafny.Tuple
		_ = _3_obj
		_3_obj = ((data).Dtor_obj()).Select((_2_i).Uint32()).(_dafny.Tuple)
		var _4_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _4_valueOrError1
		_4_valueOrError1 = m_Wrappers.Companion_Default___.Need(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__AttributeName((*(_3_obj).IndexInt(0)).(_dafny.Sequence)), _dafny.Companion_Sequence_.Concatenate((*(_3_obj).IndexInt(0)).(_dafny.Sequence), _dafny.SeqOfString(" is not a valid attribute name.")))
		if (_4_valueOrError1).IsFailure() {
			output = (_4_valueOrError1).PropagateFailure()
			return output
		}
		var _5_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Default())
		_ = _5_valueOrError2
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = Companion_Default___.GetAttributeAction((*(_3_obj).IndexInt(1)).(m_JSON_Values.JSON))
		_5_valueOrError2 = _out0
		if (_5_valueOrError2).IsFailure() {
			output = (_5_valueOrError2).PropagateFailure()
			return output
		}
		var _6_action m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction
		_ = _6_action
		_6_action = (_5_valueOrError2).Extract().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction)
		_1_result = (_1_result).Update((*(_3_obj).IndexInt(0)).(_dafny.Sequence), _6_action)
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(_1_result)
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetAttributeAction(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Default())
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_String(), _dafny.SeqOfString("Attribute Action must be a string"))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _source0 _dafny.Sequence = (data).Dtor_str()
	_ = _source0
	{
		{
			if (_source0).Equals(_dafny.SeqOfString("ENCRYPT_AND_SIGN")) {
				output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_())
				return output
				goto Lmatch0
			}
		}
		{
			if (_source0).Equals(_dafny.SeqOfString("SIGN_ONLY")) {
				output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__ONLY_())
				return output
				goto Lmatch0
			}
		}
		{
			if (_source0).Equals(_dafny.SeqOfString("CONTEXT_AND_SIGN")) {
				output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_())
				return output
				goto Lmatch0
			}
		}
		{
			if (_source0).Equals(_dafny.SeqOfString("SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT")) {
				output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_())
				return output
				goto Lmatch0
			}
		}
		{
			if (_source0).Equals(_dafny.SeqOfString("DO_NOTHING")) {
				output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_DO__NOTHING_())
				return output
				goto Lmatch0
			}
		}
		{
			output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate((data).Dtor_str(), _dafny.SeqOfString(" is not a valid CryptoAction.")))
			return output
		}
		goto Lmatch0
	}
Lmatch0:
	return output
}
func (_static *CompanionStruct_Default___) GetStrings(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Array(), _dafny.SeqOfString("List of strings must be an array"))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_results _dafny.Sequence
	_ = _1_results
	_1_results = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_arr()).Cardinality())
	_ = _hi0
	for _2_i := _dafny.Zero; _2_i.Cmp(_hi0) < 0; _2_i = _2_i.Plus(_dafny.One) {
		var _3_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _3_valueOrError1
		_3_valueOrError1 = m_Wrappers.Companion_Default___.Need((((data).Dtor_arr()).Select((_2_i).Uint32()).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("Each item in a string list must be a string"))
		if (_3_valueOrError1).IsFailure() {
			output = (_3_valueOrError1).PropagateFailure()
			return output
		}
		_1_results = _dafny.Companion_Sequence_.Concatenate(_1_results, _dafny.SeqOf((((data).Dtor_arr()).Select((_2_i).Uint32()).(m_JSON_Values.JSON)).Dtor_str()))
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(_1_results)
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetAttrNames(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Array(), _dafny.SeqOfString("List of Attribute Names must be an array"))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_results _dafny.Sequence
	_ = _1_results
	_1_results = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_arr()).Cardinality())
	_ = _hi0
	for _2_i := _dafny.Zero; _2_i.Cmp(_hi0) < 0; _2_i = _2_i.Plus(_dafny.One) {
		var _3_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _3_valueOrError1
		_3_valueOrError1 = m_Wrappers.Companion_Default___.Need((((data).Dtor_arr()).Select((_2_i).Uint32()).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("Each item in a string list must be a string"))
		if (_3_valueOrError1).IsFailure() {
			output = (_3_valueOrError1).PropagateFailure()
			return output
		}
		var _4_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _4_valueOrError2
		_4_valueOrError2 = m_Wrappers.Companion_Default___.Need(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__AttributeName((((data).Dtor_arr()).Select((_2_i).Uint32()).(m_JSON_Values.JSON)).Dtor_str()), _dafny.Companion_Sequence_.Concatenate((((data).Dtor_arr()).Select((_2_i).Uint32()).(m_JSON_Values.JSON)).Dtor_str(), _dafny.SeqOfString(" is not a valid attribute name.")))
		if (_4_valueOrError2).IsFailure() {
			output = (_4_valueOrError2).PropagateFailure()
			return output
		}
		_1_results = _dafny.Companion_Sequence_.Concatenate(_1_results, _dafny.SeqOf((((data).Dtor_arr()).Select((_2_i).Uint32()).(m_JSON_Values.JSON)).Dtor_str()))
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(_1_results)
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetAttributesFromGSI(prev _dafny.Sequence, gsi _dafny.Sequence) _dafny.Sequence {
	var output _dafny.Sequence = _dafny.EmptySeq
	_ = output
	var _0_results _dafny.Sequence
	_ = _0_results
	_0_results = prev
	var _hi0 _dafny.Int = _dafny.IntOfUint32((gsi).Cardinality())
	_ = _hi0
	for _1_i := _dafny.Zero; _1_i.Cmp(_hi0) < 0; _1_i = _1_i.Plus(_dafny.One) {
		var _hi1 _dafny.Int = _dafny.IntOfUint32((((gsi).Select((_1_i).Uint32()).(m_ComAmazonawsDynamodbTypes.GlobalSecondaryIndex)).Dtor_KeySchema()).Cardinality())
		_ = _hi1
		for _2_j := _dafny.Zero; _2_j.Cmp(_hi1) < 0; _2_j = _2_j.Plus(_dafny.One) {
			if _dafny.Quantifier((prev).UniqueElements(), true, func(_forall_var_0 m_ComAmazonawsDynamodbTypes.AttributeDefinition) bool {
				var _3_k m_ComAmazonawsDynamodbTypes.AttributeDefinition
				_3_k = interface{}(_forall_var_0).(m_ComAmazonawsDynamodbTypes.AttributeDefinition)
				return !(_dafny.Companion_Sequence_.Contains(prev, _3_k)) || (!_dafny.Companion_Sequence_.Equal((_3_k).Dtor_AttributeName(), ((((gsi).Select((_1_i).Uint32()).(m_ComAmazonawsDynamodbTypes.GlobalSecondaryIndex)).Dtor_KeySchema()).Select((_2_j).Uint32()).(m_ComAmazonawsDynamodbTypes.KeySchemaElement)).Dtor_AttributeName()))
			}) {
				_0_results = _dafny.Companion_Sequence_.Concatenate(_0_results, _dafny.SeqOf(m_ComAmazonawsDynamodbTypes.Companion_AttributeDefinition_.Create_AttributeDefinition_(((((gsi).Select((_1_i).Uint32()).(m_ComAmazonawsDynamodbTypes.GlobalSecondaryIndex)).Dtor_KeySchema()).Select((_2_j).Uint32()).(m_ComAmazonawsDynamodbTypes.KeySchemaElement)).Dtor_AttributeName(), m_ComAmazonawsDynamodbTypes.Companion_ScalarAttributeType_.Create_S_())))
			}
		}
	}
	output = _0_results
	return output
	return output
}
func (_static *CompanionStruct_Default___) MergeGSI(prev m_ComAmazonawsDynamodbTypes.CreateTableInput, gsi _dafny.Sequence) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	if (_dafny.IntOfUint32((gsi).Cardinality())).Sign() == 0 {
		output = m_Wrappers.Companion_Result_.Create_Success_(prev)
		return output
	}
	var _0_newAttr _dafny.Sequence
	_ = _0_newAttr
	var _out0 _dafny.Sequence
	_ = _out0
	_out0 = Companion_Default___.GetAttributesFromGSI((prev).Dtor_AttributeDefinitions(), gsi)
	_0_newAttr = _out0
	if ((prev).Dtor_GlobalSecondaryIndexes()).Is_None() {
		var _pat_let_tv0 = gsi
		_ = _pat_let_tv0
		var _pat_let_tv1 = _0_newAttr
		_ = _pat_let_tv1
		output = m_Wrappers.Companion_Result_.Create_Success_(func(_pat_let0_0 m_ComAmazonawsDynamodbTypes.CreateTableInput) m_ComAmazonawsDynamodbTypes.CreateTableInput {
			return func(_1_dt__update__tmp_h0 m_ComAmazonawsDynamodbTypes.CreateTableInput) m_ComAmazonawsDynamodbTypes.CreateTableInput {
				return func(_pat_let1_0 m_Wrappers.Option) m_ComAmazonawsDynamodbTypes.CreateTableInput {
					return func(_2_dt__update_hGlobalSecondaryIndexes_h0 m_Wrappers.Option) m_ComAmazonawsDynamodbTypes.CreateTableInput {
						return func(_pat_let2_0 _dafny.Sequence) m_ComAmazonawsDynamodbTypes.CreateTableInput {
							return func(_3_dt__update_hAttributeDefinitions_h0 _dafny.Sequence) m_ComAmazonawsDynamodbTypes.CreateTableInput {
								return m_ComAmazonawsDynamodbTypes.Companion_CreateTableInput_.Create_CreateTableInput_(_3_dt__update_hAttributeDefinitions_h0, (_1_dt__update__tmp_h0).Dtor_TableName(), (_1_dt__update__tmp_h0).Dtor_KeySchema(), (_1_dt__update__tmp_h0).Dtor_LocalSecondaryIndexes(), _2_dt__update_hGlobalSecondaryIndexes_h0, (_1_dt__update__tmp_h0).Dtor_BillingMode(), (_1_dt__update__tmp_h0).Dtor_ProvisionedThroughput(), (_1_dt__update__tmp_h0).Dtor_StreamSpecification(), (_1_dt__update__tmp_h0).Dtor_SSESpecification(), (_1_dt__update__tmp_h0).Dtor_Tags(), (_1_dt__update__tmp_h0).Dtor_TableClass(), (_1_dt__update__tmp_h0).Dtor_DeletionProtectionEnabled(), (_1_dt__update__tmp_h0).Dtor_ResourcePolicy(), (_1_dt__update__tmp_h0).Dtor_OnDemandThroughput())
							}(_pat_let2_0)
						}(_pat_let_tv1)
					}(_pat_let1_0)
				}(m_Wrappers.Companion_Option_.Create_Some_(_pat_let_tv0))
			}(_pat_let0_0)
		}(prev))
		return output
	} else {
		var _pat_let_tv2 = prev
		_ = _pat_let_tv2
		var _pat_let_tv3 = gsi
		_ = _pat_let_tv3
		var _pat_let_tv4 = _0_newAttr
		_ = _pat_let_tv4
		output = m_Wrappers.Companion_Result_.Create_Success_(func(_pat_let3_0 m_ComAmazonawsDynamodbTypes.CreateTableInput) m_ComAmazonawsDynamodbTypes.CreateTableInput {
			return func(_4_dt__update__tmp_h1 m_ComAmazonawsDynamodbTypes.CreateTableInput) m_ComAmazonawsDynamodbTypes.CreateTableInput {
				return func(_pat_let4_0 m_Wrappers.Option) m_ComAmazonawsDynamodbTypes.CreateTableInput {
					return func(_5_dt__update_hGlobalSecondaryIndexes_h1 m_Wrappers.Option) m_ComAmazonawsDynamodbTypes.CreateTableInput {
						return func(_pat_let5_0 _dafny.Sequence) m_ComAmazonawsDynamodbTypes.CreateTableInput {
							return func(_6_dt__update_hAttributeDefinitions_h1 _dafny.Sequence) m_ComAmazonawsDynamodbTypes.CreateTableInput {
								return m_ComAmazonawsDynamodbTypes.Companion_CreateTableInput_.Create_CreateTableInput_(_6_dt__update_hAttributeDefinitions_h1, (_4_dt__update__tmp_h1).Dtor_TableName(), (_4_dt__update__tmp_h1).Dtor_KeySchema(), (_4_dt__update__tmp_h1).Dtor_LocalSecondaryIndexes(), _5_dt__update_hGlobalSecondaryIndexes_h1, (_4_dt__update__tmp_h1).Dtor_BillingMode(), (_4_dt__update__tmp_h1).Dtor_ProvisionedThroughput(), (_4_dt__update__tmp_h1).Dtor_StreamSpecification(), (_4_dt__update__tmp_h1).Dtor_SSESpecification(), (_4_dt__update__tmp_h1).Dtor_Tags(), (_4_dt__update__tmp_h1).Dtor_TableClass(), (_4_dt__update__tmp_h1).Dtor_DeletionProtectionEnabled(), (_4_dt__update__tmp_h1).Dtor_ResourcePolicy(), (_4_dt__update__tmp_h1).Dtor_OnDemandThroughput())
							}(_pat_let5_0)
						}(_pat_let_tv4)
					}(_pat_let4_0)
				}(m_Wrappers.Companion_Option_.Create_Some_(_dafny.Companion_Sequence_.Concatenate(((_pat_let_tv2).Dtor_GlobalSecondaryIndexes()).Dtor_value().(_dafny.Sequence), _pat_let_tv3)))
			}(_pat_let3_0)
		}(prev))
		return output
	}
	return output
}
func (_static *CompanionStruct_Default___) GetVirtualFields(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Array(), _dafny.SeqOfString("Virtual Field list must be an array."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_results _dafny.Sequence
	_ = _1_results
	_1_results = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_arr()).Cardinality())
	_ = _hi0
	for _2_i := _dafny.Zero; _2_i.Cmp(_hi0) < 0; _2_i = _2_i.Plus(_dafny.One) {
		var _3_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _3_valueOrError1
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = Companion_Default___.GetOneVirtualField(((data).Dtor_arr()).Select((_2_i).Uint32()).(m_JSON_Values.JSON))
		_3_valueOrError1 = _out0
		if (_3_valueOrError1).IsFailure() {
			output = (_3_valueOrError1).PropagateFailure()
			return output
		}
		var _4_item m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualField
		_ = _4_item
		_4_item = (_3_valueOrError1).Extract().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualField)
		_1_results = _dafny.Companion_Sequence_.Concatenate(_1_results, _dafny.SeqOf(_4_item))
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(_1_results)
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetKeySource(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconKeySource_.Default())
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Object(), _dafny.SeqOfString("keySource must be an object."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_keyFieldName _dafny.Sequence
	_ = _1_keyFieldName
	_1_keyFieldName = _dafny.SeqOfString("")
	var _2_keyId _dafny.Sequence
	_ = _2_keyId
	_2_keyId = _dafny.SeqOfString("")
	var _3_cacheTTL _dafny.Int
	_ = _3_cacheTTL
	_3_cacheTTL = _dafny.IntOfInt64(42)
	var _4_maxCacheSize _dafny.Int
	_ = _4_maxCacheSize
	_4_maxCacheSize = _dafny.One
	var _5_parts _dafny.Sequence
	_ = _5_parts
	_5_parts = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_obj()).Cardinality())
	_ = _hi0
	for _6_i := _dafny.Zero; _6_i.Cmp(_hi0) < 0; _6_i = _6_i.Plus(_dafny.One) {
		var _7_obj _dafny.Tuple
		_ = _7_obj
		_7_obj = ((data).Dtor_obj()).Select((_6_i).Uint32()).(_dafny.Tuple)
		var _source0 _dafny.Sequence = (*(_7_obj).IndexInt(0)).(_dafny.Sequence)
		_ = _source0
		{
			{
				if (_source0).Equals(_dafny.SeqOfString("keyFieldName")) {
					var _8_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _8_valueOrError1
					_8_valueOrError1 = m_Wrappers.Companion_Default___.Need(((*(_7_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("keyFieldName must be a string."))
					if (_8_valueOrError1).IsFailure() {
						output = (_8_valueOrError1).PropagateFailure()
						return output
					}
					_1_keyFieldName = ((*(_7_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str()
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("keyId")) {
					var _9_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _9_valueOrError2
					_9_valueOrError2 = m_Wrappers.Companion_Default___.Need(((*(_7_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("keyId must be a string."))
					if (_9_valueOrError2).IsFailure() {
						output = (_9_valueOrError2).PropagateFailure()
						return output
					}
					_2_keyId = ((*(_7_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str()
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("cacheTTL")) {
					var _10_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _10_valueOrError3
					_10_valueOrError3 = m_Wrappers.Companion_Default___.Need(((*(_7_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_Number(), _dafny.SeqOfString("cacheTTL must be a number."))
					if (_10_valueOrError3).IsFailure() {
						output = (_10_valueOrError3).PropagateFailure()
						return output
					}
					var _11_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.Zero)
					_ = _11_valueOrError4
					_11_valueOrError4 = Companion_Default___.DecimalToNat(((*(_7_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_num())
					if (_11_valueOrError4).IsFailure() {
						output = (_11_valueOrError4).PropagateFailure()
						return output
					}
					_3_cacheTTL = (_11_valueOrError4).Extract().(_dafny.Int)
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("maxCacheSize")) {
					var _12_valueOrError5 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _12_valueOrError5
					_12_valueOrError5 = m_Wrappers.Companion_Default___.Need(((*(_7_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_Number(), _dafny.SeqOfString("maxCacheSize must be a number."))
					if (_12_valueOrError5).IsFailure() {
						output = (_12_valueOrError5).PropagateFailure()
						return output
					}
					var _13_valueOrError6 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.Zero)
					_ = _13_valueOrError6
					_13_valueOrError6 = Companion_Default___.DecimalToNat(((*(_7_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_num())
					if (_13_valueOrError6).IsFailure() {
						output = (_13_valueOrError6).PropagateFailure()
						return output
					}
					_4_maxCacheSize = (_13_valueOrError6).Extract().(_dafny.Int)
					goto Lmatch0
				}
			}
			{
				output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Unexpected part of a key source : '"), (*(((data).Dtor_obj()).Select((_6_i).Uint32()).(_dafny.Tuple)).IndexInt(0)).(_dafny.Sequence)), _dafny.SeqOfString("'")))
				return output
			}
			goto Lmatch0
		}
	Lmatch0:
	}
	var _14_valueOrError7 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _14_valueOrError7
	_14_valueOrError7 = m_Wrappers.Companion_Default___.Need((_3_cacheTTL).Cmp(m_StandardLibrary_UInt.Companion_Default___.INT32__MAX__LIMIT()) < 0, _dafny.SeqOfString("cacheTTL must fit in an int32"))
	if (_14_valueOrError7).IsFailure() {
		output = (_14_valueOrError7).PropagateFailure()
		return output
	}
	var _15_valueOrError8 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _15_valueOrError8
	_15_valueOrError8 = m_Wrappers.Companion_Default___.Need((_4_maxCacheSize).Cmp(m_StandardLibrary_UInt.Companion_Default___.INT32__MAX__LIMIT()) < 0, _dafny.SeqOfString("maxCacheSize must fit in an int32"))
	if (_15_valueOrError8).IsFailure() {
		output = (_15_valueOrError8).PropagateFailure()
		return output
	}
	var _16_valueOrError9 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _16_valueOrError9
	_16_valueOrError9 = m_Wrappers.Companion_Default___.Need(((_dafny.IntOfUint32((_1_keyFieldName).Cardinality())).Sign() == 1) || ((_dafny.IntOfUint32((_2_keyId).Cardinality())).Sign() == 1), _dafny.SeqOfString("Each key source needs a either a keyFieldName or a keyId."))
	if (_16_valueOrError9).IsFailure() {
		output = (_16_valueOrError9).PropagateFailure()
		return output
	}
	var _17_valueOrError10 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _17_valueOrError10
	_17_valueOrError10 = m_Wrappers.Companion_Default___.Need(((_dafny.IntOfUint32((_1_keyFieldName).Cardinality())).Sign() == 0) || ((_dafny.IntOfUint32((_2_keyId).Cardinality())).Sign() == 0), _dafny.SeqOfString("Each key source cannot have both a keyFieldName and a keyId."))
	if (_17_valueOrError10).IsFailure() {
		output = (_17_valueOrError10).PropagateFailure()
		return output
	}
	if (_dafny.IntOfUint32((_2_keyId).Cardinality())).Sign() == 1 {
		output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconKeySource_.Create_single_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_SingleKeyStore_.Create_SingleKeyStore_(_2_keyId, (_3_cacheTTL).Int32(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())))
		return output
	} else {
		output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_BeaconKeySource_.Create_multi_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_MultiKeyStore_.Create_MultiKeyStore_(_1_keyFieldName, (_3_cacheTTL).Int32(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())))
		return output
	}
	return output
}
func (_static *CompanionStruct_Default___) GetOneVirtualField(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Object(), _dafny.SeqOfString("Virtual Field must be an object."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_name _dafny.Sequence
	_ = _1_name
	_1_name = _dafny.SeqOfString("")
	var _2_parts _dafny.Sequence
	_ = _2_parts
	_2_parts = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_obj()).Cardinality())
	_ = _hi0
	for _3_i := _dafny.Zero; _3_i.Cmp(_hi0) < 0; _3_i = _3_i.Plus(_dafny.One) {
		var _4_obj _dafny.Tuple
		_ = _4_obj
		_4_obj = ((data).Dtor_obj()).Select((_3_i).Uint32()).(_dafny.Tuple)
		var _source0 _dafny.Sequence = (*(_4_obj).IndexInt(0)).(_dafny.Sequence)
		_ = _source0
		{
			{
				if (_source0).Equals(_dafny.SeqOfString("name")) {
					var _5_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _5_valueOrError1
					_5_valueOrError1 = m_Wrappers.Companion_Default___.Need(((*(_4_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("Virtual Field Name must be a string."))
					if (_5_valueOrError1).IsFailure() {
						output = (_5_valueOrError1).PropagateFailure()
						return output
					}
					_1_name = ((*(_4_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str()
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("parts")) {
					var _6_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _6_valueOrError2
					var _out0 m_Wrappers.Result
					_ = _out0
					_out0 = Companion_Default___.GetVirtualParts((*(_4_obj).IndexInt(1)).(m_JSON_Values.JSON))
					_6_valueOrError2 = _out0
					if (_6_valueOrError2).IsFailure() {
						output = (_6_valueOrError2).PropagateFailure()
						return output
					}
					_2_parts = (_6_valueOrError2).Extract().(_dafny.Sequence)
					goto Lmatch0
				}
			}
			{
				output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Unexpected part of a virtual field : '"), (*(((data).Dtor_obj()).Select((_3_i).Uint32()).(_dafny.Tuple)).IndexInt(0)).(_dafny.Sequence)), _dafny.SeqOfString("'")))
				return output
			}
			goto Lmatch0
		}
	Lmatch0:
	}
	var _7_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _7_valueOrError3
	_7_valueOrError3 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((_1_name).Cardinality())).Sign() == 1, _dafny.SeqOfString("Each Virtual Field needs a name."))
	if (_7_valueOrError3).IsFailure() {
		output = (_7_valueOrError3).PropagateFailure()
		return output
	}
	var _8_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _8_valueOrError4
	_8_valueOrError4 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((_2_parts).Cardinality())).Sign() == 1, _dafny.SeqOfString("Each Virtual Field needs at least 1 part."))
	if (_8_valueOrError4).IsFailure() {
		output = (_8_valueOrError4).PropagateFailure()
		return output
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualField_.Create_VirtualField_(_1_name, _2_parts))
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetVirtualParts(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Array(), _dafny.SeqOfString("Virtual Field Parts list must be an array."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_results _dafny.Sequence
	_ = _1_results
	_1_results = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_arr()).Cardinality())
	_ = _hi0
	for _2_i := _dafny.Zero; _2_i.Cmp(_hi0) < 0; _2_i = _2_i.Plus(_dafny.One) {
		var _3_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _3_valueOrError1
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = Companion_Default___.GetOneVirtualPart(((data).Dtor_arr()).Select((_2_i).Uint32()).(m_JSON_Values.JSON))
		_3_valueOrError1 = _out0
		if (_3_valueOrError1).IsFailure() {
			output = (_3_valueOrError1).PropagateFailure()
			return output
		}
		var _4_item m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualPart
		_ = _4_item
		_4_item = (_3_valueOrError1).Extract().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualPart)
		_1_results = _dafny.Companion_Sequence_.Concatenate(_1_results, _dafny.SeqOf(_4_item))
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(_1_results)
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetOneVirtualPart(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Object(), _dafny.SeqOfString("Virtual Part must be an object."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_loc _dafny.Sequence
	_ = _1_loc
	_1_loc = _dafny.SeqOfString("")
	var _2_trans _dafny.Sequence
	_ = _2_trans
	_2_trans = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_obj()).Cardinality())
	_ = _hi0
	for _3_i := _dafny.Zero; _3_i.Cmp(_hi0) < 0; _3_i = _3_i.Plus(_dafny.One) {
		var _4_obj _dafny.Tuple
		_ = _4_obj
		_4_obj = ((data).Dtor_obj()).Select((_3_i).Uint32()).(_dafny.Tuple)
		var _source0 _dafny.Sequence = (*(_4_obj).IndexInt(0)).(_dafny.Sequence)
		_ = _source0
		{
			{
				if (_source0).Equals(_dafny.SeqOfString("loc")) {
					var _5_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _5_valueOrError1
					_5_valueOrError1 = m_Wrappers.Companion_Default___.Need(((*(_4_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("Virtual Part Location must be a string."))
					if (_5_valueOrError1).IsFailure() {
						output = (_5_valueOrError1).PropagateFailure()
						return output
					}
					_1_loc = ((*(_4_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str()
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("trans")) {
					var _6_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _6_valueOrError2
					var _out0 m_Wrappers.Result
					_ = _out0
					_out0 = Companion_Default___.GetVirtualTransforms((*(_4_obj).IndexInt(1)).(m_JSON_Values.JSON))
					_6_valueOrError2 = _out0
					if (_6_valueOrError2).IsFailure() {
						output = (_6_valueOrError2).PropagateFailure()
						return output
					}
					_2_trans = (_6_valueOrError2).Extract().(_dafny.Sequence)
					goto Lmatch0
				}
			}
			{
				output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Unexpected part of a virtual part : '"), (*(((data).Dtor_obj()).Select((_3_i).Uint32()).(_dafny.Tuple)).IndexInt(0)).(_dafny.Sequence)), _dafny.SeqOfString("'")))
				return output
			}
			goto Lmatch0
		}
	Lmatch0:
	}
	var _7_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _7_valueOrError3
	_7_valueOrError3 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((_1_loc).Cardinality())).Sign() == 1, _dafny.SeqOfString("Each Virtual Part needs a loc."))
	if (_7_valueOrError3).IsFailure() {
		output = (_7_valueOrError3).PropagateFailure()
		return output
	}
	var _8_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _8_valueOrError4
	_8_valueOrError4 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((_2_trans).Cardinality())).Sign() == 1, _dafny.SeqOfString("Each Virtual Part needs at least 1 transform."))
	if (_8_valueOrError4).IsFailure() {
		output = (_8_valueOrError4).PropagateFailure()
		return output
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualPart_.Create_VirtualPart_(_1_loc, Companion_Default___.OptSeq(_2_trans)))
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetVirtualTransforms(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Array(), _dafny.SeqOfString("Virtual Field Parts list must be an array."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_results _dafny.Sequence
	_ = _1_results
	_1_results = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_arr()).Cardinality())
	_ = _hi0
	for _2_i := _dafny.Zero; _2_i.Cmp(_hi0) < 0; _2_i = _2_i.Plus(_dafny.One) {
		var _3_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Default())
		_ = _3_valueOrError1
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = Companion_Default___.GetOneVirtualTransform(((data).Dtor_arr()).Select((_2_i).Uint32()).(m_JSON_Values.JSON))
		_3_valueOrError1 = _out0
		if (_3_valueOrError1).IsFailure() {
			output = (_3_valueOrError1).PropagateFailure()
			return output
		}
		var _4_item m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform
		_ = _4_item
		_4_item = (_3_valueOrError1).Extract().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.VirtualTransform)
		_1_results = _dafny.Companion_Sequence_.Concatenate(_1_results, _dafny.SeqOf(_4_item))
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(_1_results)
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetOneVirtualTransform(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Default())
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Object(), _dafny.SeqOfString("Virtual Transform must be an object."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _1_valueOrError1
	_1_valueOrError1 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32(((data).Dtor_obj()).Cardinality())).Cmp(_dafny.One) == 0, _dafny.SeqOfString("Virtual Transform object must be length 1."))
	if (_1_valueOrError1).IsFailure() {
		output = (_1_valueOrError1).PropagateFailure()
		return output
	}
	var _2_obj _dafny.Tuple
	_ = _2_obj
	_2_obj = ((data).Dtor_obj()).Select(0).(_dafny.Tuple)
	var _source0 _dafny.Sequence = (*(_2_obj).IndexInt(0)).(_dafny.Sequence)
	_ = _source0
	{
		{
			if (_source0).Equals(_dafny.SeqOfString("upper")) {
				var _3_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
				_ = _3_valueOrError2
				_3_valueOrError2 = m_Wrappers.Companion_Default___.Need(((*(_2_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_Null(), _dafny.SeqOfString("Value of upper transform must be null"))
				if (_3_valueOrError2).IsFailure() {
					output = (_3_valueOrError2).PropagateFailure()
					return output
				}
				output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_upper_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Upper_.Create_Upper_()))
				return output
				goto Lmatch0
			}
		}
		{
			if (_source0).Equals(_dafny.SeqOfString("lower")) {
				var _4_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
				_ = _4_valueOrError3
				_4_valueOrError3 = m_Wrappers.Companion_Default___.Need(((*(_2_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_Null(), _dafny.SeqOfString("Value of lower transform must be null"))
				if (_4_valueOrError3).IsFailure() {
					output = (_4_valueOrError3).PropagateFailure()
					return output
				}
				output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_lower_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Lower_.Create_Lower_()))
				return output
				goto Lmatch0
			}
		}
		{
			if (_source0).Equals(_dafny.SeqOfString("insert")) {
				var _out0 m_Wrappers.Result
				_ = _out0
				_out0 = Companion_Default___.GetInsert((*(_2_obj).IndexInt(1)).(m_JSON_Values.JSON))
				output = _out0
				goto Lmatch0
			}
		}
		{
			if (_source0).Equals(_dafny.SeqOfString("prefix")) {
				var _out1 m_Wrappers.Result
				_ = _out1
				_out1 = Companion_Default___.GetPrefix((*(_2_obj).IndexInt(1)).(m_JSON_Values.JSON))
				output = _out1
				goto Lmatch0
			}
		}
		{
			if (_source0).Equals(_dafny.SeqOfString("suffix")) {
				var _out2 m_Wrappers.Result
				_ = _out2
				_out2 = Companion_Default___.GetSuffix((*(_2_obj).IndexInt(1)).(m_JSON_Values.JSON))
				output = _out2
				goto Lmatch0
			}
		}
		{
			if (_source0).Equals(_dafny.SeqOfString("substring")) {
				var _out3 m_Wrappers.Result
				_ = _out3
				_out3 = Companion_Default___.GetSubstring((*(_2_obj).IndexInt(1)).(m_JSON_Values.JSON))
				output = _out3
				goto Lmatch0
			}
		}
		{
			if (_source0).Equals(_dafny.SeqOfString("segment")) {
				var _out4 m_Wrappers.Result
				_ = _out4
				_out4 = Companion_Default___.GetSegment((*(_2_obj).IndexInt(1)).(m_JSON_Values.JSON))
				output = _out4
				goto Lmatch0
			}
		}
		{
			if (_source0).Equals(_dafny.SeqOfString("segments")) {
				var _out5 m_Wrappers.Result
				_ = _out5
				_out5 = Companion_Default___.GetSegments((*(_2_obj).IndexInt(1)).(m_JSON_Values.JSON))
				output = _out5
				goto Lmatch0
			}
		}
		{
			output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Unexpected Virtual Transform : '"), (*(_2_obj).IndexInt(0)).(_dafny.Sequence)), _dafny.SeqOfString("'")))
			return output
		}
		goto Lmatch0
	}
Lmatch0:
	return output
}
func (_static *CompanionStruct_Default___) GetInsert(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Default())
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Object(), _dafny.SeqOfString("GetInsert Value must be an object."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_literal m_Wrappers.Option
	_ = _1_literal
	_1_literal = m_Wrappers.Companion_Option_.Create_None_()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_obj()).Cardinality())
	_ = _hi0
	for _2_i := _dafny.Zero; _2_i.Cmp(_hi0) < 0; _2_i = _2_i.Plus(_dafny.One) {
		var _3_obj _dafny.Tuple
		_ = _3_obj
		_3_obj = ((data).Dtor_obj()).Select((_2_i).Uint32()).(_dafny.Tuple)
		var _source0 _dafny.Sequence = (*(_3_obj).IndexInt(0)).(_dafny.Sequence)
		_ = _source0
		{
			{
				if (_source0).Equals(_dafny.SeqOfString("literal")) {
					var _4_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _4_valueOrError1
					_4_valueOrError1 = m_Wrappers.Companion_Default___.Need(((*(_3_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("GetInsert literal must be a string"))
					if (_4_valueOrError1).IsFailure() {
						output = (_4_valueOrError1).PropagateFailure()
						return output
					}
					_1_literal = m_Wrappers.Companion_Option_.Create_Some_(((*(_3_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str())
					goto Lmatch0
				}
			}
			{
				output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Unexpected part of a GetInsert : '"), (*(_3_obj).IndexInt(0)).(_dafny.Sequence)), _dafny.SeqOfString("'")))
				return output
			}
			goto Lmatch0
		}
	Lmatch0:
	}
	var _5_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _5_valueOrError2
	_5_valueOrError2 = m_Wrappers.Companion_Default___.Need((_1_literal).Is_Some(), _dafny.SeqOfString("Each GetInsert needs a literal."))
	if (_5_valueOrError2).IsFailure() {
		output = (_5_valueOrError2).PropagateFailure()
		return output
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_insert_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Insert_.Create_Insert_((_1_literal).Dtor_value().(_dafny.Sequence))))
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetPrefix(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Default())
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Object(), _dafny.SeqOfString("GetPrefix Value must be an object."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_length m_Wrappers.Option
	_ = _1_length
	_1_length = m_Wrappers.Companion_Option_.Create_None_()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_obj()).Cardinality())
	_ = _hi0
	for _2_i := _dafny.Zero; _2_i.Cmp(_hi0) < 0; _2_i = _2_i.Plus(_dafny.One) {
		var _3_obj _dafny.Tuple
		_ = _3_obj
		_3_obj = ((data).Dtor_obj()).Select((_2_i).Uint32()).(_dafny.Tuple)
		var _source0 _dafny.Sequence = (*(_3_obj).IndexInt(0)).(_dafny.Sequence)
		_ = _source0
		{
			{
				if (_source0).Equals(_dafny.SeqOfString("length")) {
					var _4_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _4_valueOrError1
					_4_valueOrError1 = m_Wrappers.Companion_Default___.Need(((*(_3_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_Number(), _dafny.SeqOfString("GetPrefix length must be a number"))
					if (_4_valueOrError1).IsFailure() {
						output = (_4_valueOrError1).PropagateFailure()
						return output
					}
					var _5_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.Zero)
					_ = _5_valueOrError2
					_5_valueOrError2 = Companion_Default___.DecimalToInt(((*(_3_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_num())
					if (_5_valueOrError2).IsFailure() {
						output = (_5_valueOrError2).PropagateFailure()
						return output
					}
					var _6_len _dafny.Int
					_ = _6_len
					_6_len = (_5_valueOrError2).Extract().(_dafny.Int)
					var _7_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _7_valueOrError3
					_7_valueOrError3 = m_Wrappers.Companion_Default___.Need(Companion_Default___.IsValidInt32(_6_len), _dafny.SeqOfString("GetPrefix length must be an int32."))
					if (_7_valueOrError3).IsFailure() {
						output = (_7_valueOrError3).PropagateFailure()
						return output
					}
					_1_length = m_Wrappers.Companion_Option_.Create_Some_((_6_len).Int32())
					goto Lmatch0
				}
			}
			{
				output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Unexpected part of a GetPrefix : '"), (*(_3_obj).IndexInt(0)).(_dafny.Sequence)), _dafny.SeqOfString("'")))
				return output
			}
			goto Lmatch0
		}
	Lmatch0:
	}
	var _8_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _8_valueOrError4
	_8_valueOrError4 = m_Wrappers.Companion_Default___.Need((_1_length).Is_Some(), _dafny.SeqOfString("Each GetPrefix needs a length."))
	if (_8_valueOrError4).IsFailure() {
		output = (_8_valueOrError4).PropagateFailure()
		return output
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_prefix_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetPrefix_.Create_GetPrefix_((_1_length).Dtor_value().(int32))))
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetSuffix(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Default())
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Object(), _dafny.SeqOfString("GetSuffix Value must be an object."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_length m_Wrappers.Option
	_ = _1_length
	_1_length = m_Wrappers.Companion_Option_.Create_None_()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_obj()).Cardinality())
	_ = _hi0
	for _2_i := _dafny.Zero; _2_i.Cmp(_hi0) < 0; _2_i = _2_i.Plus(_dafny.One) {
		var _3_obj _dafny.Tuple
		_ = _3_obj
		_3_obj = ((data).Dtor_obj()).Select((_2_i).Uint32()).(_dafny.Tuple)
		var _source0 _dafny.Sequence = (*(_3_obj).IndexInt(0)).(_dafny.Sequence)
		_ = _source0
		{
			{
				if (_source0).Equals(_dafny.SeqOfString("length")) {
					var _4_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _4_valueOrError1
					_4_valueOrError1 = m_Wrappers.Companion_Default___.Need(((*(_3_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_Number(), _dafny.SeqOfString("GetSuffix length must be a number"))
					if (_4_valueOrError1).IsFailure() {
						output = (_4_valueOrError1).PropagateFailure()
						return output
					}
					var _5_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.Zero)
					_ = _5_valueOrError2
					_5_valueOrError2 = Companion_Default___.DecimalToInt(((*(_3_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_num())
					if (_5_valueOrError2).IsFailure() {
						output = (_5_valueOrError2).PropagateFailure()
						return output
					}
					var _6_len _dafny.Int
					_ = _6_len
					_6_len = (_5_valueOrError2).Extract().(_dafny.Int)
					var _7_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _7_valueOrError3
					_7_valueOrError3 = m_Wrappers.Companion_Default___.Need(Companion_Default___.IsValidInt32(_6_len), _dafny.SeqOfString("GetSuffix length must be an int32."))
					if (_7_valueOrError3).IsFailure() {
						output = (_7_valueOrError3).PropagateFailure()
						return output
					}
					_1_length = m_Wrappers.Companion_Option_.Create_Some_((_6_len).Int32())
					goto Lmatch0
				}
			}
			{
				output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Unexpected part of a GetSuffix : '"), (*(_3_obj).IndexInt(0)).(_dafny.Sequence)), _dafny.SeqOfString("'")))
				return output
			}
			goto Lmatch0
		}
	Lmatch0:
	}
	var _8_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _8_valueOrError4
	_8_valueOrError4 = m_Wrappers.Companion_Default___.Need((_1_length).Is_Some(), _dafny.SeqOfString("Each GetSuffix needs a length."))
	if (_8_valueOrError4).IsFailure() {
		output = (_8_valueOrError4).PropagateFailure()
		return output
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_suffix_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetSuffix_.Create_GetSuffix_((_1_length).Dtor_value().(int32))))
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetSubstring(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Default())
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Object(), _dafny.SeqOfString("GetSubstring Value must be an object."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_low m_Wrappers.Option
	_ = _1_low
	_1_low = m_Wrappers.Companion_Option_.Create_None_()
	var _2_high m_Wrappers.Option
	_ = _2_high
	_2_high = m_Wrappers.Companion_Option_.Create_None_()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_obj()).Cardinality())
	_ = _hi0
	for _3_i := _dafny.Zero; _3_i.Cmp(_hi0) < 0; _3_i = _3_i.Plus(_dafny.One) {
		var _4_obj _dafny.Tuple
		_ = _4_obj
		_4_obj = ((data).Dtor_obj()).Select((_3_i).Uint32()).(_dafny.Tuple)
		var _source0 _dafny.Sequence = (*(_4_obj).IndexInt(0)).(_dafny.Sequence)
		_ = _source0
		{
			{
				if (_source0).Equals(_dafny.SeqOfString("low")) {
					var _5_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _5_valueOrError1
					_5_valueOrError1 = m_Wrappers.Companion_Default___.Need(((*(_4_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_Number(), _dafny.SeqOfString("GetSubstring low must be a number"))
					if (_5_valueOrError1).IsFailure() {
						output = (_5_valueOrError1).PropagateFailure()
						return output
					}
					var _6_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.Zero)
					_ = _6_valueOrError2
					_6_valueOrError2 = Companion_Default___.DecimalToInt(((*(_4_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_num())
					if (_6_valueOrError2).IsFailure() {
						output = (_6_valueOrError2).PropagateFailure()
						return output
					}
					var _7_len _dafny.Int
					_ = _7_len
					_7_len = (_6_valueOrError2).Extract().(_dafny.Int)
					var _8_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _8_valueOrError3
					_8_valueOrError3 = m_Wrappers.Companion_Default___.Need(Companion_Default___.IsValidInt32(_7_len), _dafny.SeqOfString("GetSubstring low must be an int32."))
					if (_8_valueOrError3).IsFailure() {
						output = (_8_valueOrError3).PropagateFailure()
						return output
					}
					_1_low = m_Wrappers.Companion_Option_.Create_Some_((_7_len).Int32())
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("high")) {
					var _9_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _9_valueOrError4
					_9_valueOrError4 = m_Wrappers.Companion_Default___.Need(((*(_4_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_Number(), _dafny.SeqOfString("GetSubstring high must be a number"))
					if (_9_valueOrError4).IsFailure() {
						output = (_9_valueOrError4).PropagateFailure()
						return output
					}
					var _10_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.Zero)
					_ = _10_valueOrError5
					_10_valueOrError5 = Companion_Default___.DecimalToInt(((*(_4_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_num())
					if (_10_valueOrError5).IsFailure() {
						output = (_10_valueOrError5).PropagateFailure()
						return output
					}
					var _11_len _dafny.Int
					_ = _11_len
					_11_len = (_10_valueOrError5).Extract().(_dafny.Int)
					var _12_valueOrError6 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _12_valueOrError6
					_12_valueOrError6 = m_Wrappers.Companion_Default___.Need(Companion_Default___.IsValidInt32(_11_len), _dafny.SeqOfString("GetSubstring high must be an int32."))
					if (_12_valueOrError6).IsFailure() {
						output = (_12_valueOrError6).PropagateFailure()
						return output
					}
					_2_high = m_Wrappers.Companion_Option_.Create_Some_((_11_len).Int32())
					goto Lmatch0
				}
			}
			{
				output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Unexpected part of a GetSubstring : '"), (*(_4_obj).IndexInt(0)).(_dafny.Sequence)), _dafny.SeqOfString("'")))
				return output
			}
			goto Lmatch0
		}
	Lmatch0:
	}
	var _13_valueOrError7 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _13_valueOrError7
	_13_valueOrError7 = m_Wrappers.Companion_Default___.Need((_1_low).Is_Some(), _dafny.SeqOfString("Each GetSubstring needs a low."))
	if (_13_valueOrError7).IsFailure() {
		output = (_13_valueOrError7).PropagateFailure()
		return output
	}
	var _14_valueOrError8 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _14_valueOrError8
	_14_valueOrError8 = m_Wrappers.Companion_Default___.Need((_2_high).Is_Some(), _dafny.SeqOfString("Each GetSubstring needs a high."))
	if (_14_valueOrError8).IsFailure() {
		output = (_14_valueOrError8).PropagateFailure()
		return output
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_substring_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetSubstring_.Create_GetSubstring_((_1_low).Dtor_value().(int32), (_2_high).Dtor_value().(int32))))
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetSegments(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Default())
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Object(), _dafny.SeqOfString("GetSegments Value must be an object."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_low m_Wrappers.Option
	_ = _1_low
	_1_low = m_Wrappers.Companion_Option_.Create_None_()
	var _2_high m_Wrappers.Option
	_ = _2_high
	_2_high = m_Wrappers.Companion_Option_.Create_None_()
	var _3_split m_Wrappers.Option
	_ = _3_split
	_3_split = m_Wrappers.Companion_Option_.Create_None_()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_obj()).Cardinality())
	_ = _hi0
	for _4_i := _dafny.Zero; _4_i.Cmp(_hi0) < 0; _4_i = _4_i.Plus(_dafny.One) {
		var _5_obj _dafny.Tuple
		_ = _5_obj
		_5_obj = ((data).Dtor_obj()).Select((_4_i).Uint32()).(_dafny.Tuple)
		var _source0 _dafny.Sequence = (*(_5_obj).IndexInt(0)).(_dafny.Sequence)
		_ = _source0
		{
			{
				if (_source0).Equals(_dafny.SeqOfString("low")) {
					var _6_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _6_valueOrError1
					_6_valueOrError1 = m_Wrappers.Companion_Default___.Need(((*(_5_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_Number(), _dafny.SeqOfString("GetSegments low must be a number"))
					if (_6_valueOrError1).IsFailure() {
						output = (_6_valueOrError1).PropagateFailure()
						return output
					}
					var _7_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.Zero)
					_ = _7_valueOrError2
					_7_valueOrError2 = Companion_Default___.DecimalToInt(((*(_5_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_num())
					if (_7_valueOrError2).IsFailure() {
						output = (_7_valueOrError2).PropagateFailure()
						return output
					}
					var _8_len _dafny.Int
					_ = _8_len
					_8_len = (_7_valueOrError2).Extract().(_dafny.Int)
					var _9_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _9_valueOrError3
					_9_valueOrError3 = m_Wrappers.Companion_Default___.Need(Companion_Default___.IsValidInt32(_8_len), _dafny.SeqOfString("GetSegments low must be an int32."))
					if (_9_valueOrError3).IsFailure() {
						output = (_9_valueOrError3).PropagateFailure()
						return output
					}
					_1_low = m_Wrappers.Companion_Option_.Create_Some_((_8_len).Int32())
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("high")) {
					var _10_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _10_valueOrError4
					_10_valueOrError4 = m_Wrappers.Companion_Default___.Need(((*(_5_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_Number(), _dafny.SeqOfString("GetSegments high must be a number"))
					if (_10_valueOrError4).IsFailure() {
						output = (_10_valueOrError4).PropagateFailure()
						return output
					}
					var _11_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.Zero)
					_ = _11_valueOrError5
					_11_valueOrError5 = Companion_Default___.DecimalToInt(((*(_5_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_num())
					if (_11_valueOrError5).IsFailure() {
						output = (_11_valueOrError5).PropagateFailure()
						return output
					}
					var _12_len _dafny.Int
					_ = _12_len
					_12_len = (_11_valueOrError5).Extract().(_dafny.Int)
					var _13_valueOrError6 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _13_valueOrError6
					_13_valueOrError6 = m_Wrappers.Companion_Default___.Need(Companion_Default___.IsValidInt32(_12_len), _dafny.SeqOfString("GetSegments high must be an int32."))
					if (_13_valueOrError6).IsFailure() {
						output = (_13_valueOrError6).PropagateFailure()
						return output
					}
					_2_high = m_Wrappers.Companion_Option_.Create_Some_((_12_len).Int32())
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("split")) {
					var _14_valueOrError7 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _14_valueOrError7
					_14_valueOrError7 = m_Wrappers.Companion_Default___.Need(((*(_5_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("GetSegments split must be a string"))
					if (_14_valueOrError7).IsFailure() {
						output = (_14_valueOrError7).PropagateFailure()
						return output
					}
					_3_split = m_Wrappers.Companion_Option_.Create_Some_(((*(_5_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str())
					goto Lmatch0
				}
			}
			{
				output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Unexpected part of a GetSegments : '"), (*(_5_obj).IndexInt(0)).(_dafny.Sequence)), _dafny.SeqOfString("'")))
				return output
			}
			goto Lmatch0
		}
	Lmatch0:
	}
	var _15_valueOrError8 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _15_valueOrError8
	_15_valueOrError8 = m_Wrappers.Companion_Default___.Need((_1_low).Is_Some(), _dafny.SeqOfString("Each GetSegments needs a low."))
	if (_15_valueOrError8).IsFailure() {
		output = (_15_valueOrError8).PropagateFailure()
		return output
	}
	var _16_valueOrError9 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _16_valueOrError9
	_16_valueOrError9 = m_Wrappers.Companion_Default___.Need((_2_high).Is_Some(), _dafny.SeqOfString("Each GetSegments needs a high."))
	if (_16_valueOrError9).IsFailure() {
		output = (_16_valueOrError9).PropagateFailure()
		return output
	}
	var _17_valueOrError10 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _17_valueOrError10
	_17_valueOrError10 = m_Wrappers.Companion_Default___.Need((_3_split).Is_Some(), _dafny.SeqOfString("Each GetSegments needs a split."))
	if (_17_valueOrError10).IsFailure() {
		output = (_17_valueOrError10).PropagateFailure()
		return output
	}
	var _18_valueOrError11 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _18_valueOrError11
	_18_valueOrError11 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32(((_3_split).Dtor_value().(_dafny.Sequence)).Cardinality())).Cmp(_dafny.One) == 0, _dafny.SeqOfString("GetSegments split must be length 1."))
	if (_18_valueOrError11).IsFailure() {
		output = (_18_valueOrError11).PropagateFailure()
		return output
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_segments_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetSegments_.Create_GetSegments_((_3_split).Dtor_value().(_dafny.Sequence), (_1_low).Dtor_value().(int32), (_2_high).Dtor_value().(int32))))
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetSegment(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Default())
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Object(), _dafny.SeqOfString("GetSegment Value must be an object."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_index m_Wrappers.Option
	_ = _1_index
	_1_index = m_Wrappers.Companion_Option_.Create_None_()
	var _2_split m_Wrappers.Option
	_ = _2_split
	_2_split = m_Wrappers.Companion_Option_.Create_None_()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_obj()).Cardinality())
	_ = _hi0
	for _3_i := _dafny.Zero; _3_i.Cmp(_hi0) < 0; _3_i = _3_i.Plus(_dafny.One) {
		var _4_obj _dafny.Tuple
		_ = _4_obj
		_4_obj = ((data).Dtor_obj()).Select((_3_i).Uint32()).(_dafny.Tuple)
		var _source0 _dafny.Sequence = (*(_4_obj).IndexInt(0)).(_dafny.Sequence)
		_ = _source0
		{
			{
				if (_source0).Equals(_dafny.SeqOfString("index")) {
					var _5_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _5_valueOrError1
					_5_valueOrError1 = m_Wrappers.Companion_Default___.Need(((*(_4_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_Number(), _dafny.SeqOfString("GetSegment index must be a number"))
					if (_5_valueOrError1).IsFailure() {
						output = (_5_valueOrError1).PropagateFailure()
						return output
					}
					var _6_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.Zero)
					_ = _6_valueOrError2
					_6_valueOrError2 = Companion_Default___.DecimalToInt(((*(_4_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_num())
					if (_6_valueOrError2).IsFailure() {
						output = (_6_valueOrError2).PropagateFailure()
						return output
					}
					var _7_len _dafny.Int
					_ = _7_len
					_7_len = (_6_valueOrError2).Extract().(_dafny.Int)
					var _8_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _8_valueOrError3
					_8_valueOrError3 = m_Wrappers.Companion_Default___.Need(Companion_Default___.IsValidInt32(_7_len), _dafny.SeqOfString("GetSegments low must be an int32."))
					if (_8_valueOrError3).IsFailure() {
						output = (_8_valueOrError3).PropagateFailure()
						return output
					}
					_1_index = m_Wrappers.Companion_Option_.Create_Some_((_7_len).Int32())
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("split")) {
					var _9_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _9_valueOrError4
					_9_valueOrError4 = m_Wrappers.Companion_Default___.Need(((*(_4_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("GetSegments split must be a string"))
					if (_9_valueOrError4).IsFailure() {
						output = (_9_valueOrError4).PropagateFailure()
						return output
					}
					_2_split = m_Wrappers.Companion_Option_.Create_Some_(((*(_4_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str())
					goto Lmatch0
				}
			}
			{
				output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Unexpected part of a GetSegment : '"), (*(_4_obj).IndexInt(0)).(_dafny.Sequence)), _dafny.SeqOfString("'")))
				return output
			}
			goto Lmatch0
		}
	Lmatch0:
	}
	var _10_valueOrError5 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _10_valueOrError5
	_10_valueOrError5 = m_Wrappers.Companion_Default___.Need((_1_index).Is_Some(), _dafny.SeqOfString("Each GetSegments needs a low."))
	if (_10_valueOrError5).IsFailure() {
		output = (_10_valueOrError5).PropagateFailure()
		return output
	}
	var _11_valueOrError6 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _11_valueOrError6
	_11_valueOrError6 = m_Wrappers.Companion_Default___.Need((_2_split).Is_Some(), _dafny.SeqOfString("Each GetSegments needs a split."))
	if (_11_valueOrError6).IsFailure() {
		output = (_11_valueOrError6).PropagateFailure()
		return output
	}
	var _12_valueOrError7 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _12_valueOrError7
	_12_valueOrError7 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32(((_2_split).Dtor_value().(_dafny.Sequence)).Cardinality())).Cmp(_dafny.One) == 0, _dafny.SeqOfString("GetSegments split must be length 1."))
	if (_12_valueOrError7).IsFailure() {
		output = (_12_valueOrError7).PropagateFailure()
		return output
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_VirtualTransform_.Create_segment_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_GetSegment_.Create_GetSegment_((_2_split).Dtor_value().(_dafny.Sequence), (_1_index).Dtor_value().(int32))))
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetCompoundBeacons(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Array(), _dafny.SeqOfString("Compound Beacon list must be an array."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_results _dafny.Sequence
	_ = _1_results
	_1_results = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_arr()).Cardinality())
	_ = _hi0
	for _2_i := _dafny.Zero; _2_i.Cmp(_hi0) < 0; _2_i = _2_i.Plus(_dafny.One) {
		var _3_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _3_valueOrError1
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = Companion_Default___.GetOneCompoundBeacon(((data).Dtor_arr()).Select((_2_i).Uint32()).(m_JSON_Values.JSON))
		_3_valueOrError1 = _out0
		if (_3_valueOrError1).IsFailure() {
			output = (_3_valueOrError1).PropagateFailure()
			return output
		}
		var _4_item m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.CompoundBeacon
		_ = _4_item
		_4_item = (_3_valueOrError1).Extract().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.CompoundBeacon)
		_1_results = _dafny.Companion_Sequence_.Concatenate(_1_results, _dafny.SeqOf(_4_item))
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(_1_results)
	return output
	return output
}
func (_static *CompanionStruct_Default___) OptSeq(s _dafny.Sequence) m_Wrappers.Option {
	if (_dafny.IntOfUint32((s).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Option_.Create_None_()
	} else {
		return m_Wrappers.Companion_Option_.Create_Some_(s)
	}
}
func (_static *CompanionStruct_Default___) GetOneCompoundBeacon(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Object(), _dafny.SeqOfString("Compound Beacon must be an object."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_name _dafny.Sequence
	_ = _1_name
	_1_name = _dafny.SeqOfString("")
	var _2_split _dafny.Sequence
	_ = _2_split
	_2_split = _dafny.SeqOfString(".")
	var _3_Encrypted _dafny.Sequence
	_ = _3_Encrypted
	_3_Encrypted = _dafny.SeqOf()
	var _4_Signed _dafny.Sequence
	_ = _4_Signed
	_4_Signed = _dafny.SeqOf()
	var _5_constructors _dafny.Sequence
	_ = _5_constructors
	_5_constructors = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_obj()).Cardinality())
	_ = _hi0
	for _6_i := _dafny.Zero; _6_i.Cmp(_hi0) < 0; _6_i = _6_i.Plus(_dafny.One) {
		var _7_obj _dafny.Tuple
		_ = _7_obj
		_7_obj = ((data).Dtor_obj()).Select((_6_i).Uint32()).(_dafny.Tuple)
		var _source0 _dafny.Sequence = (*(_7_obj).IndexInt(0)).(_dafny.Sequence)
		_ = _source0
		{
			{
				if (_source0).Equals(_dafny.SeqOfString("Name")) {
					var _8_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _8_valueOrError1
					_8_valueOrError1 = m_Wrappers.Companion_Default___.Need(((*(_7_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("Compound Beacon Name must be a string."))
					if (_8_valueOrError1).IsFailure() {
						output = (_8_valueOrError1).PropagateFailure()
						return output
					}
					_1_name = ((*(_7_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str()
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("Split")) {
					var _9_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _9_valueOrError2
					_9_valueOrError2 = m_Wrappers.Companion_Default___.Need(((*(_7_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("Compound Beacon Split must be a string."))
					if (_9_valueOrError2).IsFailure() {
						output = (_9_valueOrError2).PropagateFailure()
						return output
					}
					var _10_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _10_valueOrError3
					_10_valueOrError3 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((((*(_7_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str()).Cardinality())).Cmp(_dafny.One) == 0, _dafny.SeqOfString("Compound Beacon Split must be a string of length 1."))
					if (_10_valueOrError3).IsFailure() {
						output = (_10_valueOrError3).PropagateFailure()
						return output
					}
					_2_split = ((*(_7_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str()
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("Signed")) {
					var _11_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _11_valueOrError4
					var _out0 m_Wrappers.Result
					_ = _out0
					_out0 = Companion_Default___.GetSignedParts((*(_7_obj).IndexInt(1)).(m_JSON_Values.JSON))
					_11_valueOrError4 = _out0
					if (_11_valueOrError4).IsFailure() {
						output = (_11_valueOrError4).PropagateFailure()
						return output
					}
					_4_Signed = (_11_valueOrError4).Extract().(_dafny.Sequence)
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("Encrypted")) {
					var _12_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _12_valueOrError5
					var _out1 m_Wrappers.Result
					_ = _out1
					_out1 = Companion_Default___.GetEncryptedParts((*(_7_obj).IndexInt(1)).(m_JSON_Values.JSON))
					_12_valueOrError5 = _out1
					if (_12_valueOrError5).IsFailure() {
						output = (_12_valueOrError5).PropagateFailure()
						return output
					}
					_3_Encrypted = (_12_valueOrError5).Extract().(_dafny.Sequence)
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("Constructors")) {
					var _13_valueOrError6 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _13_valueOrError6
					var _out2 m_Wrappers.Result
					_ = _out2
					_out2 = Companion_Default___.GetConstructors((*(_7_obj).IndexInt(1)).(m_JSON_Values.JSON))
					_13_valueOrError6 = _out2
					if (_13_valueOrError6).IsFailure() {
						output = (_13_valueOrError6).PropagateFailure()
						return output
					}
					_5_constructors = (_13_valueOrError6).Extract().(_dafny.Sequence)
					goto Lmatch0
				}
			}
			{
				output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Unexpected part of a standard beacon : '"), (*(((data).Dtor_obj()).Select((_6_i).Uint32()).(_dafny.Tuple)).IndexInt(0)).(_dafny.Sequence)), _dafny.SeqOfString("'")))
				return output
			}
			goto Lmatch0
		}
	Lmatch0:
	}
	var _14_valueOrError7 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _14_valueOrError7
	_14_valueOrError7 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((_1_name).Cardinality())).Sign() == 1, _dafny.SeqOfString("Each Compound Beacon needs a name."))
	if (_14_valueOrError7).IsFailure() {
		output = (_14_valueOrError7).PropagateFailure()
		return output
	}
	var _15_valueOrError8 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _15_valueOrError8
	_15_valueOrError8 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((_2_split).Cardinality())).Cmp(_dafny.One) == 0, _dafny.SeqOfString("Split for Compound Beacon must be length 1."))
	if (_15_valueOrError8).IsFailure() {
		output = (_15_valueOrError8).PropagateFailure()
		return output
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_CompoundBeacon_.Create_CompoundBeacon_(_1_name, _2_split, Companion_Default___.OptSeq(_3_Encrypted), Companion_Default___.OptSeq(_4_Signed), Companion_Default___.OptSeq(_5_constructors)))
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetConstructors(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Array(), _dafny.SeqOfString("Constructor list must be an array."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_results _dafny.Sequence
	_ = _1_results
	_1_results = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_arr()).Cardinality())
	_ = _hi0
	for _2_i := _dafny.Zero; _2_i.Cmp(_hi0) < 0; _2_i = _2_i.Plus(_dafny.One) {
		var _3_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _3_valueOrError1
		_3_valueOrError1 = m_Wrappers.Companion_Default___.Need((((data).Dtor_arr()).Select((_2_i).Uint32()).(m_JSON_Values.JSON)).Is_Array(), _dafny.SeqOfString("Constructors must be an arrays."))
		if (_3_valueOrError1).IsFailure() {
			output = (_3_valueOrError1).PropagateFailure()
			return output
		}
		var _4_result _dafny.Sequence
		_ = _4_result
		_4_result = _dafny.SeqOf()
		var _hi1 _dafny.Int = _dafny.IntOfUint32(((((data).Dtor_arr()).Select((_2_i).Uint32()).(m_JSON_Values.JSON)).Dtor_arr()).Cardinality())
		_ = _hi1
		for _5_j := _dafny.Zero; _5_j.Cmp(_hi1) < 0; _5_j = _5_j.Plus(_dafny.One) {
			var _6_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_ConstructorPart_.Default())
			_ = _6_valueOrError2
			var _out0 m_Wrappers.Result
			_ = _out0
			_out0 = Companion_Default___.GetOneConstructorPart(((((data).Dtor_arr()).Select((_2_i).Uint32()).(m_JSON_Values.JSON)).Dtor_arr()).Select((_5_j).Uint32()).(m_JSON_Values.JSON))
			_6_valueOrError2 = _out0
			if (_6_valueOrError2).IsFailure() {
				output = (_6_valueOrError2).PropagateFailure()
				return output
			}
			var _7_item m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.ConstructorPart
			_ = _7_item
			_7_item = (_6_valueOrError2).Extract().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.ConstructorPart)
			_4_result = _dafny.Companion_Sequence_.Concatenate(_4_result, _dafny.SeqOf(_7_item))
		}
		var _8_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _8_valueOrError3
		_8_valueOrError3 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((_4_result).Cardinality())).Sign() == 1, _dafny.SeqOfString("Constructor Part List must have at least one item."))
		if (_8_valueOrError3).IsFailure() {
			output = (_8_valueOrError3).PropagateFailure()
			return output
		}
		_1_results = _dafny.Companion_Sequence_.Concatenate(_1_results, _dafny.SeqOf(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Constructor_.Create_Constructor_(_4_result)))
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(_1_results)
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetOneConstructorPart(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_ConstructorPart_.Default())
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Object(), _dafny.SeqOfString("Constructor Part must be an object."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_name _dafny.Sequence
	_ = _1_name
	_1_name = _dafny.SeqOfString("")
	var _2_req bool
	_ = _2_req
	_2_req = true
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_obj()).Cardinality())
	_ = _hi0
	for _3_i := _dafny.Zero; _3_i.Cmp(_hi0) < 0; _3_i = _3_i.Plus(_dafny.One) {
		var _4_obj _dafny.Tuple
		_ = _4_obj
		_4_obj = ((data).Dtor_obj()).Select((_3_i).Uint32()).(_dafny.Tuple)
		var _source0 _dafny.Sequence = (*(_4_obj).IndexInt(0)).(_dafny.Sequence)
		_ = _source0
		{
			{
				if (_source0).Equals(_dafny.SeqOfString("Name")) {
					var _5_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _5_valueOrError1
					_5_valueOrError1 = m_Wrappers.Companion_Default___.Need(((*(_4_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("Constructor Part Name must be a string"))
					if (_5_valueOrError1).IsFailure() {
						output = (_5_valueOrError1).PropagateFailure()
						return output
					}
					_1_name = ((*(_4_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str()
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("Required")) {
					var _6_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _6_valueOrError2
					_6_valueOrError2 = m_Wrappers.Companion_Default___.Need(((*(_4_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_Bool(), _dafny.SeqOfString("Constructor Part Required must be a bool"))
					if (_6_valueOrError2).IsFailure() {
						output = (_6_valueOrError2).PropagateFailure()
						return output
					}
					_2_req = ((*(_4_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_b()
					goto Lmatch0
				}
			}
			{
				output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Unexpected part of a constructor part : '"), (*(_4_obj).IndexInt(0)).(_dafny.Sequence)), _dafny.SeqOfString("'")))
				return output
			}
			goto Lmatch0
		}
	Lmatch0:
	}
	var _7_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _7_valueOrError3
	_7_valueOrError3 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((_1_name).Cardinality())).Sign() == 1, _dafny.SeqOfString("Each Constructor Part needs a name."))
	if (_7_valueOrError3).IsFailure() {
		output = (_7_valueOrError3).PropagateFailure()
		return output
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_ConstructorPart_.Create_ConstructorPart_(_1_name, _2_req))
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetSignedParts(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Array(), _dafny.SeqOfString("Signed Parts list must be an array."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_results _dafny.Sequence
	_ = _1_results
	_1_results = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_arr()).Cardinality())
	_ = _hi0
	for _2_i := _dafny.Zero; _2_i.Cmp(_hi0) < 0; _2_i = _2_i.Plus(_dafny.One) {
		var _3_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _3_valueOrError1
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = Companion_Default___.GetOneSignedPart(((data).Dtor_arr()).Select((_2_i).Uint32()).(m_JSON_Values.JSON))
		_3_valueOrError1 = _out0
		if (_3_valueOrError1).IsFailure() {
			output = (_3_valueOrError1).PropagateFailure()
			return output
		}
		var _4_item m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.SignedPart
		_ = _4_item
		_4_item = (_3_valueOrError1).Extract().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.SignedPart)
		_1_results = _dafny.Companion_Sequence_.Concatenate(_1_results, _dafny.SeqOf(_4_item))
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(_1_results)
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetOneSignedPart(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Object(), _dafny.SeqOfString("Signed Part must be an object."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_name _dafny.Sequence
	_ = _1_name
	_1_name = _dafny.SeqOfString("")
	var _2_prefix _dafny.Sequence
	_ = _2_prefix
	_2_prefix = _dafny.SeqOfString("")
	var _3_loc m_Wrappers.Option
	_ = _3_loc
	_3_loc = m_Wrappers.Companion_Option_.Create_None_()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_obj()).Cardinality())
	_ = _hi0
	for _4_i := _dafny.Zero; _4_i.Cmp(_hi0) < 0; _4_i = _4_i.Plus(_dafny.One) {
		var _5_obj _dafny.Tuple
		_ = _5_obj
		_5_obj = ((data).Dtor_obj()).Select((_4_i).Uint32()).(_dafny.Tuple)
		var _source0 _dafny.Sequence = (*(_5_obj).IndexInt(0)).(_dafny.Sequence)
		_ = _source0
		{
			{
				if (_source0).Equals(_dafny.SeqOfString("Name")) {
					var _6_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _6_valueOrError1
					_6_valueOrError1 = m_Wrappers.Companion_Default___.Need(((*(_5_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("Signed Part Name must be a string"))
					if (_6_valueOrError1).IsFailure() {
						output = (_6_valueOrError1).PropagateFailure()
						return output
					}
					_1_name = ((*(_5_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str()
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("Prefix")) {
					var _7_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _7_valueOrError2
					_7_valueOrError2 = m_Wrappers.Companion_Default___.Need(((*(_5_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("Signed Part Prefix must be a string"))
					if (_7_valueOrError2).IsFailure() {
						output = (_7_valueOrError2).PropagateFailure()
						return output
					}
					_2_prefix = ((*(_5_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str()
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("Loc")) {
					var _8_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _8_valueOrError3
					_8_valueOrError3 = m_Wrappers.Companion_Default___.Need(((*(_5_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("Signed Part Location must be a string"))
					if (_8_valueOrError3).IsFailure() {
						output = (_8_valueOrError3).PropagateFailure()
						return output
					}
					var _9_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _9_valueOrError4
					_9_valueOrError4 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((((*(_5_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str()).Cardinality())).Sign() == 1, _dafny.SeqOfString("Signed Part Location must be a non-empty string"))
					if (_9_valueOrError4).IsFailure() {
						output = (_9_valueOrError4).PropagateFailure()
						return output
					}
					_3_loc = m_Wrappers.Companion_Option_.Create_Some_(((*(_5_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str())
					goto Lmatch0
				}
			}
			{
				output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Unexpected part of a Signed part : '"), (*(_5_obj).IndexInt(0)).(_dafny.Sequence)), _dafny.SeqOfString("'")))
				return output
			}
			goto Lmatch0
		}
	Lmatch0:
	}
	var _10_valueOrError5 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _10_valueOrError5
	_10_valueOrError5 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((_1_name).Cardinality())).Sign() == 1, _dafny.SeqOfString("Each Signed Part needs a name."))
	if (_10_valueOrError5).IsFailure() {
		output = (_10_valueOrError5).PropagateFailure()
		return output
	}
	var _11_valueOrError6 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _11_valueOrError6
	_11_valueOrError6 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((_2_prefix).Cardinality())).Sign() == 1, _dafny.SeqOfString("Each Signed Part needs a prefix."))
	if (_11_valueOrError6).IsFailure() {
		output = (_11_valueOrError6).PropagateFailure()
		return output
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_SignedPart_.Create_SignedPart_(_1_name, _2_prefix, _3_loc))
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetEncryptedParts(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Array(), _dafny.SeqOfString("Encrypted Parts list must be an array."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_results _dafny.Sequence
	_ = _1_results
	_1_results = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_arr()).Cardinality())
	_ = _hi0
	for _2_i := _dafny.Zero; _2_i.Cmp(_hi0) < 0; _2_i = _2_i.Plus(_dafny.One) {
		var _3_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _3_valueOrError1
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = Companion_Default___.GetOneEncryptedPart(((data).Dtor_arr()).Select((_2_i).Uint32()).(m_JSON_Values.JSON))
		_3_valueOrError1 = _out0
		if (_3_valueOrError1).IsFailure() {
			output = (_3_valueOrError1).PropagateFailure()
			return output
		}
		var _4_item m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedPart
		_ = _4_item
		_4_item = (_3_valueOrError1).Extract().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.EncryptedPart)
		_1_results = _dafny.Companion_Sequence_.Concatenate(_1_results, _dafny.SeqOf(_4_item))
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(_1_results)
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetOneEncryptedPart(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Object(), _dafny.SeqOfString("Encrypted Part must be an object."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_name _dafny.Sequence
	_ = _1_name
	_1_name = _dafny.SeqOfString("")
	var _2_prefix _dafny.Sequence
	_ = _2_prefix
	_2_prefix = _dafny.SeqOfString("")
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_obj()).Cardinality())
	_ = _hi0
	for _3_i := _dafny.Zero; _3_i.Cmp(_hi0) < 0; _3_i = _3_i.Plus(_dafny.One) {
		var _4_obj _dafny.Tuple
		_ = _4_obj
		_4_obj = ((data).Dtor_obj()).Select((_3_i).Uint32()).(_dafny.Tuple)
		var _source0 _dafny.Sequence = (*(_4_obj).IndexInt(0)).(_dafny.Sequence)
		_ = _source0
		{
			{
				if (_source0).Equals(_dafny.SeqOfString("Name")) {
					var _5_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _5_valueOrError1
					_5_valueOrError1 = m_Wrappers.Companion_Default___.Need(((*(_4_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("Encrypted Part Name must be a string"))
					if (_5_valueOrError1).IsFailure() {
						output = (_5_valueOrError1).PropagateFailure()
						return output
					}
					_1_name = ((*(_4_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str()
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("Prefix")) {
					var _6_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _6_valueOrError2
					_6_valueOrError2 = m_Wrappers.Companion_Default___.Need(((*(_4_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("Encrypted Part Prefix must be a string"))
					if (_6_valueOrError2).IsFailure() {
						output = (_6_valueOrError2).PropagateFailure()
						return output
					}
					_2_prefix = ((*(_4_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str()
					goto Lmatch0
				}
			}
			{
				output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Unexpected part of an Encrypted part : '"), (*(_4_obj).IndexInt(0)).(_dafny.Sequence)), _dafny.SeqOfString("'")))
				return output
			}
			goto Lmatch0
		}
	Lmatch0:
	}
	var _7_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _7_valueOrError3
	_7_valueOrError3 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((_1_name).Cardinality())).Sign() == 1, _dafny.SeqOfString("Each Encrypted Part needs a name."))
	if (_7_valueOrError3).IsFailure() {
		output = (_7_valueOrError3).PropagateFailure()
		return output
	}
	var _8_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _8_valueOrError4
	_8_valueOrError4 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((_2_prefix).Cardinality())).Sign() == 1, _dafny.SeqOfString("Each Encrypted Part needs a prefix."))
	if (_8_valueOrError4).IsFailure() {
		output = (_8_valueOrError4).PropagateFailure()
		return output
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_EncryptedPart_.Create_EncryptedPart_(_1_name, _2_prefix))
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetStandardBeacons(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Array(), _dafny.SeqOfString("Standard Beacon list must be an array."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_results _dafny.Sequence
	_ = _1_results
	_1_results = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_arr()).Cardinality())
	_ = _hi0
	for _2_i := _dafny.Zero; _2_i.Cmp(_hi0) < 0; _2_i = _2_i.Plus(_dafny.One) {
		var _3_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _3_valueOrError1
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = Companion_Default___.GetOneStandardBeacon(((data).Dtor_arr()).Select((_2_i).Uint32()).(m_JSON_Values.JSON))
		_3_valueOrError1 = _out0
		if (_3_valueOrError1).IsFailure() {
			output = (_3_valueOrError1).PropagateFailure()
			return output
		}
		var _4_item m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon
		_ = _4_item
		_4_item = (_3_valueOrError1).Extract().(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.StandardBeacon)
		_1_results = _dafny.Companion_Sequence_.Concatenate(_1_results, _dafny.SeqOf(_4_item))
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(_1_results)
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetOneStandardBeacon(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Object(), _dafny.SeqOfString("Standard Beacon must be an object."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_name _dafny.Sequence
	_ = _1_name
	_1_name = _dafny.SeqOfString("")
	var _2_length _dafny.Int
	_ = _2_length
	_2_length = _dafny.IntOfInt64(-1)
	var _3_loc m_Wrappers.Option
	_ = _3_loc
	_3_loc = m_Wrappers.Companion_Option_.Create_None_()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_obj()).Cardinality())
	_ = _hi0
	for _4_i := _dafny.Zero; _4_i.Cmp(_hi0) < 0; _4_i = _4_i.Plus(_dafny.One) {
		var _5_obj _dafny.Tuple
		_ = _5_obj
		_5_obj = ((data).Dtor_obj()).Select((_4_i).Uint32()).(_dafny.Tuple)
		var _source0 _dafny.Sequence = (*(_5_obj).IndexInt(0)).(_dafny.Sequence)
		_ = _source0
		{
			{
				if (_source0).Equals(_dafny.SeqOfString("Name")) {
					var _6_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _6_valueOrError1
					_6_valueOrError1 = m_Wrappers.Companion_Default___.Need(((*(_5_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("Standard Beacon Name must be a string"))
					if (_6_valueOrError1).IsFailure() {
						output = (_6_valueOrError1).PropagateFailure()
						return output
					}
					_1_name = ((*(_5_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str()
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("Length")) {
					var _7_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _7_valueOrError2
					_7_valueOrError2 = m_Wrappers.Companion_Default___.Need(((*(_5_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_Number(), _dafny.SeqOfString("Standard Beacon length must be a number"))
					if (_7_valueOrError2).IsFailure() {
						output = (_7_valueOrError2).PropagateFailure()
						return output
					}
					var _8_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.Zero)
					_ = _8_valueOrError3
					_8_valueOrError3 = Companion_Default___.DecimalToNat(((*(_5_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_num())
					if (_8_valueOrError3).IsFailure() {
						output = (_8_valueOrError3).PropagateFailure()
						return output
					}
					_2_length = (_8_valueOrError3).Extract().(_dafny.Int)
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("Loc")) {
					var _9_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _9_valueOrError4
					_9_valueOrError4 = m_Wrappers.Companion_Default___.Need(((*(_5_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("Standard Beacon Location must be a string"))
					if (_9_valueOrError4).IsFailure() {
						output = (_9_valueOrError4).PropagateFailure()
						return output
					}
					var _10_valueOrError5 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _10_valueOrError5
					_10_valueOrError5 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((((*(_5_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str()).Cardinality())).Sign() == 1, _dafny.SeqOfString("Standard Beacon Location must nt be an empty string."))
					if (_10_valueOrError5).IsFailure() {
						output = (_10_valueOrError5).PropagateFailure()
						return output
					}
					_3_loc = m_Wrappers.Companion_Option_.Create_Some_(((*(_5_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str())
					goto Lmatch0
				}
			}
			{
				output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Unexpected part of a standard beacon : '"), (*(((data).Dtor_obj()).Select((_4_i).Uint32()).(_dafny.Tuple)).IndexInt(0)).(_dafny.Sequence)), _dafny.SeqOfString("'")))
				return output
			}
			goto Lmatch0
		}
	Lmatch0:
	}
	var _11_valueOrError6 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _11_valueOrError6
	_11_valueOrError6 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((_1_name).Cardinality())).Sign() == 1, _dafny.SeqOfString("Each Standard Beacon needs a name."))
	if (_11_valueOrError6).IsFailure() {
		output = (_11_valueOrError6).PropagateFailure()
		return output
	}
	var _12_valueOrError7 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _12_valueOrError7
	_12_valueOrError7 = m_Wrappers.Companion_Default___.Need((((_2_length).Sign() == 1) && ((_2_length).Cmp(_dafny.IntOfInt64(100)) < 0)) && (m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Default___.IsValid__BeaconBitLength((_2_length).Int32())), _dafny.SeqOfString("Each Standard Beacon needs a length between 1 and 63."))
	if (_12_valueOrError7).IsFailure() {
		output = (_12_valueOrError7).PropagateFailure()
		return output
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_StandardBeacon_.Create_StandardBeacon_(_1_name, (_2_length).Int32(), _3_loc, m_Wrappers.Companion_Option_.Create_None_()))
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetGSIs(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Array(), _dafny.SeqOfString("GSI list must be an array."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_results _dafny.Sequence
	_ = _1_results
	_1_results = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_arr()).Cardinality())
	_ = _hi0
	for _2_i := _dafny.Zero; _2_i.Cmp(_hi0) < 0; _2_i = _2_i.Plus(_dafny.One) {
		var _3_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _3_valueOrError1
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = Companion_Default___.GetOneGSI(((data).Dtor_arr()).Select((_2_i).Uint32()).(m_JSON_Values.JSON))
		_3_valueOrError1 = _out0
		if (_3_valueOrError1).IsFailure() {
			output = (_3_valueOrError1).PropagateFailure()
			return output
		}
		var _4_item m_ComAmazonawsDynamodbTypes.GlobalSecondaryIndex
		_ = _4_item
		_4_item = (_3_valueOrError1).Extract().(m_ComAmazonawsDynamodbTypes.GlobalSecondaryIndex)
		_1_results = _dafny.Companion_Sequence_.Concatenate(_1_results, _dafny.SeqOf(_4_item))
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(_1_results)
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetOneGSI(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Array(), _dafny.SeqOfString("Each GSI must be an array."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _1_valueOrError1
	_1_valueOrError1 = m_Wrappers.Companion_Default___.Need(((_dafny.IntOfInt64(2)).Cmp(_dafny.IntOfUint32(((data).Dtor_arr()).Cardinality())) <= 0) && ((_dafny.IntOfUint32(((data).Dtor_arr()).Cardinality())).Cmp(_dafny.IntOfInt64(3)) <= 0), _dafny.SeqOfString("Each GSI must be an array of length 2 or 3."))
	if (_1_valueOrError1).IsFailure() {
		output = (_1_valueOrError1).PropagateFailure()
		return output
	}
	var _2_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _2_valueOrError2
	_2_valueOrError2 = m_Wrappers.Companion_Default___.Need(_dafny.Quantifier(((data).Dtor_arr()).UniqueElements(), true, func(_forall_var_0 m_JSON_Values.JSON) bool {
		var _3_k m_JSON_Values.JSON
		_3_k = interface{}(_forall_var_0).(m_JSON_Values.JSON)
		return !(_dafny.Companion_Sequence_.Contains((data).Dtor_arr(), _3_k)) || ((_3_k).Is_String())
	}), _dafny.SeqOfString("Each GSI must be an array of strings"))
	if (_2_valueOrError2).IsFailure() {
		output = (_2_valueOrError2).PropagateFailure()
		return output
	}
	var _4_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _4_valueOrError3
	_4_valueOrError3 = m_Wrappers.Companion_Default___.Need(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__IndexName((((data).Dtor_arr()).Select(0).(m_JSON_Values.JSON)).Dtor_str()), _dafny.Companion_Sequence_.Concatenate((((data).Dtor_arr()).Select(0).(m_JSON_Values.JSON)).Dtor_str(), _dafny.SeqOfString(" is not a valid IndexName.")))
	if (_4_valueOrError3).IsFailure() {
		output = (_4_valueOrError3).PropagateFailure()
		return output
	}
	var _5_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _5_valueOrError4
	_5_valueOrError4 = m_Wrappers.Companion_Default___.Need(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__KeySchemaAttributeName((((data).Dtor_arr()).Select(1).(m_JSON_Values.JSON)).Dtor_str()), _dafny.Companion_Sequence_.Concatenate((((data).Dtor_arr()).Select(1).(m_JSON_Values.JSON)).Dtor_str(), _dafny.SeqOfString(" is not a valid KeySchemaAttributeName.")))
	if (_5_valueOrError4).IsFailure() {
		output = (_5_valueOrError4).PropagateFailure()
		return output
	}
	var _6_schema _dafny.Sequence
	_ = _6_schema
	_6_schema = _dafny.SeqOf(m_ComAmazonawsDynamodbTypes.Companion_KeySchemaElement_.Create_KeySchemaElement_((((data).Dtor_arr()).Select(1).(m_JSON_Values.JSON)).Dtor_str(), m_ComAmazonawsDynamodbTypes.Companion_KeyType_.Create_HASH_()))
	if (_dafny.IntOfUint32(((data).Dtor_arr()).Cardinality())).Cmp(_dafny.IntOfInt64(3)) == 0 {
		var _7_valueOrError5 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _7_valueOrError5
		_7_valueOrError5 = m_Wrappers.Companion_Default___.Need(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__KeySchemaAttributeName((((data).Dtor_arr()).Select(2).(m_JSON_Values.JSON)).Dtor_str()), _dafny.Companion_Sequence_.Concatenate((((data).Dtor_arr()).Select(2).(m_JSON_Values.JSON)).Dtor_str(), _dafny.SeqOfString(" is not a valid KeySchemaAttributeName.")))
		if (_7_valueOrError5).IsFailure() {
			output = (_7_valueOrError5).PropagateFailure()
			return output
		}
		var _8_range m_ComAmazonawsDynamodbTypes.KeySchemaElement
		_ = _8_range
		_8_range = m_ComAmazonawsDynamodbTypes.Companion_KeySchemaElement_.Create_KeySchemaElement_((((data).Dtor_arr()).Select(2).(m_JSON_Values.JSON)).Dtor_str(), m_ComAmazonawsDynamodbTypes.Companion_KeyType_.Create_RANGE_())
		_6_schema = _dafny.Companion_Sequence_.Concatenate(_6_schema, _dafny.SeqOf(_8_range))
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(m_ComAmazonawsDynamodbTypes.Companion_GlobalSecondaryIndex_.Create_GlobalSecondaryIndex_((((data).Dtor_arr()).Select(0).(m_JSON_Values.JSON)).Dtor_str(), _6_schema, m_ComAmazonawsDynamodbTypes.Companion_Projection_.Create_Projection_(m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_()))
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetIoTests(data m_JSON_Values.JSON, keys *m_KeyVectors.KeyVectorsClient) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Object(), _dafny.SeqOfString("IoTests must be an object."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_results _dafny.Sequence
	_ = _1_results
	_1_results = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_obj()).Cardinality())
	_ = _hi0
	for _2_i := _dafny.Zero; _2_i.Cmp(_hi0) < 0; _2_i = _2_i.Plus(_dafny.One) {
		var _3_obj _dafny.Tuple
		_ = _3_obj
		_3_obj = ((data).Dtor_obj()).Select((_2_i).Uint32()).(_dafny.Tuple)
		var _4_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _4_valueOrError1
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = Companion_Default___.GetOneIoTest((*(_3_obj).IndexInt(0)).(_dafny.Sequence), (*(_3_obj).IndexInt(1)).(m_JSON_Values.JSON), keys)
		_4_valueOrError1 = _out0
		if (_4_valueOrError1).IsFailure() {
			output = (_4_valueOrError1).PropagateFailure()
			return output
		}
		var _5_item IoTest
		_ = _5_item
		_5_item = (_4_valueOrError1).Extract().(IoTest)
		_1_results = _dafny.Companion_Sequence_.Concatenate(_1_results, _dafny.SeqOf(_5_item))
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(_1_results)
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetOneIoTest(name _dafny.Sequence, data m_JSON_Values.JSON, keys *m_KeyVectors.KeyVectorsClient) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Object(), _dafny.SeqOfString("IoTest must be an object."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_readConfig m_Wrappers.Option
	_ = _1_readConfig
	_1_readConfig = m_Wrappers.Companion_Option_.Create_None_()
	var _2_writeConfig m_Wrappers.Option
	_ = _2_writeConfig
	_2_writeConfig = m_Wrappers.Companion_Option_.Create_None_()
	var _3_names _dafny.Map
	_ = _3_names
	_3_names = _dafny.NewMapBuilder().ToMap()
	var _4_values _dafny.Map
	_ = _4_values
	_4_values = _dafny.NewMapBuilder().ToMap()
	var _5_queries _dafny.Sequence
	_ = _5_queries
	_5_queries = _dafny.SeqOf()
	var _6_records _dafny.Sequence
	_ = _6_records
	_6_records = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_obj()).Cardinality())
	_ = _hi0
	for _7_i := _dafny.Zero; _7_i.Cmp(_hi0) < 0; _7_i = _7_i.Plus(_dafny.One) {
		var _8_obj _dafny.Tuple
		_ = _8_obj
		_8_obj = ((data).Dtor_obj()).Select((_7_i).Uint32()).(_dafny.Tuple)
		var _source0 _dafny.Sequence = (*(_8_obj).IndexInt(0)).(_dafny.Sequence)
		_ = _source0
		{
			{
				if (_source0).Equals(_dafny.SeqOfString("WriteConfig")) {
					var _9_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
					_ = _9_valueOrError1
					var _out0 m_Wrappers.Result
					_ = _out0
					_out0 = Companion_Default___.GetOneTableConfig((*(_8_obj).IndexInt(0)).(_dafny.Sequence), (*(_8_obj).IndexInt(1)).(m_JSON_Values.JSON), keys)
					_9_valueOrError1 = _out0
					if (_9_valueOrError1).IsFailure() {
						output = (_9_valueOrError1).PropagateFailure()
						return output
					}
					var _10_config TableConfig
					_ = _10_config
					_10_config = (_9_valueOrError1).Extract().(TableConfig)
					_2_writeConfig = m_Wrappers.Companion_Option_.Create_Some_(_10_config)
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("ReadConfig")) {
					var _11_valueOrError2 m_Wrappers.Result = m_Wrappers.Result{}
					_ = _11_valueOrError2
					var _out1 m_Wrappers.Result
					_ = _out1
					_out1 = Companion_Default___.GetOneTableConfig((*(_8_obj).IndexInt(0)).(_dafny.Sequence), (*(_8_obj).IndexInt(1)).(m_JSON_Values.JSON), keys)
					_11_valueOrError2 = _out1
					if (_11_valueOrError2).IsFailure() {
						output = (_11_valueOrError2).PropagateFailure()
						return output
					}
					var _12_config TableConfig
					_ = _12_config
					_12_config = (_11_valueOrError2).Extract().(TableConfig)
					_1_readConfig = m_Wrappers.Companion_Option_.Create_Some_(_12_config)
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("Records")) {
					var _13_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _13_valueOrError3
					var _out2 m_Wrappers.Result
					_ = _out2
					_out2 = Companion_Default___.GetRecords((*(_8_obj).IndexInt(1)).(m_JSON_Values.JSON))
					_13_valueOrError3 = _out2
					if (_13_valueOrError3).IsFailure() {
						output = (_13_valueOrError3).PropagateFailure()
						return output
					}
					_6_records = (_13_valueOrError3).Extract().(_dafny.Sequence)
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("Values")) {
					var _14_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
					_ = _14_valueOrError4
					var _out3 m_Wrappers.Result
					_ = _out3
					_out3 = Companion_Default___.GetValueMap((*(((data).Dtor_obj()).Select((_7_i).Uint32()).(_dafny.Tuple)).IndexInt(1)).(m_JSON_Values.JSON))
					_14_valueOrError4 = _out3
					if (_14_valueOrError4).IsFailure() {
						output = (_14_valueOrError4).PropagateFailure()
						return output
					}
					_4_values = (_14_valueOrError4).Extract().(_dafny.Map)
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("Queries")) {
					var _15_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _15_valueOrError5
					var _out4 m_Wrappers.Result
					_ = _out4
					_out4 = Companion_Default___.GetSimpleQueries((*(((data).Dtor_obj()).Select((_7_i).Uint32()).(_dafny.Tuple)).IndexInt(1)).(m_JSON_Values.JSON))
					_15_valueOrError5 = _out4
					if (_15_valueOrError5).IsFailure() {
						output = (_15_valueOrError5).PropagateFailure()
						return output
					}
					_5_queries = (_15_valueOrError5).Extract().(_dafny.Sequence)
					goto Lmatch0
				}
			}
			{
				output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Unexpected part of a complex test : '"), (*(_8_obj).IndexInt(0)).(_dafny.Sequence)), _dafny.SeqOfString("'")))
				return output
			}
			goto Lmatch0
		}
	Lmatch0:
	}
	var _16_valueOrError6 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _16_valueOrError6
	_16_valueOrError6 = m_Wrappers.Companion_Default___.Need((_2_writeConfig).Is_Some(), _dafny.SeqOfString("An IoTest needs a writeConfig"))
	if (_16_valueOrError6).IsFailure() {
		output = (_16_valueOrError6).PropagateFailure()
		return output
	}
	var _17_valueOrError7 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _17_valueOrError7
	_17_valueOrError7 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((_6_records).Cardinality())).Sign() == 1, _dafny.SeqOfString("An IoTest needs at least one record"))
	if (_17_valueOrError7).IsFailure() {
		output = (_17_valueOrError7).PropagateFailure()
		return output
	}
	if (_1_readConfig).Is_Some() {
		output = m_Wrappers.Companion_Result_.Create_Success_(Companion_IoTest_.Create_IoTest_(name, (_2_writeConfig).Dtor_value().(TableConfig), (_1_readConfig).Dtor_value().(TableConfig), _6_records, _3_names, _4_values, _5_queries))
		return output
	} else {
		output = m_Wrappers.Companion_Result_.Create_Success_(Companion_IoTest_.Create_IoTest_(name, (_2_writeConfig).Dtor_value().(TableConfig), (_2_writeConfig).Dtor_value().(TableConfig), _6_records, _3_names, _4_values, _5_queries))
		return output
	}
	return output
}
func (_static *CompanionStruct_Default___) GetComplexTests(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Array(), _dafny.SeqOfString("Queries must be an array."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_results _dafny.Sequence
	_ = _1_results
	_1_results = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_arr()).Cardinality())
	_ = _hi0
	for _2_i := _dafny.Zero; _2_i.Cmp(_hi0) < 0; _2_i = _2_i.Plus(_dafny.One) {
		var _3_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(Companion_ComplexTest_.Default())
		_ = _3_valueOrError1
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = Companion_Default___.GetOneComplexTest(((data).Dtor_arr()).Select((_2_i).Uint32()).(m_JSON_Values.JSON))
		_3_valueOrError1 = _out0
		if (_3_valueOrError1).IsFailure() {
			output = (_3_valueOrError1).PropagateFailure()
			return output
		}
		var _4_item ComplexTest
		_ = _4_item
		_4_item = (_3_valueOrError1).Extract().(ComplexTest)
		_1_results = _dafny.Companion_Sequence_.Concatenate(_1_results, _dafny.SeqOf(_4_item))
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(_1_results)
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetOneComplexTest(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(Companion_ComplexTest_.Default())
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Object(), _dafny.SeqOfString("Complex Query must be an object."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_config _dafny.Sequence
	_ = _1_config
	_1_config = _dafny.SeqOfString("")
	var _2_queries _dafny.Sequence
	_ = _2_queries
	_2_queries = _dafny.SeqOf()
	var _3_failures _dafny.Sequence
	_ = _3_failures
	_3_failures = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_obj()).Cardinality())
	_ = _hi0
	for _4_i := _dafny.Zero; _4_i.Cmp(_hi0) < 0; _4_i = _4_i.Plus(_dafny.One) {
		var _5_obj _dafny.Tuple
		_ = _5_obj
		_5_obj = ((data).Dtor_obj()).Select((_4_i).Uint32()).(_dafny.Tuple)
		var _source0 _dafny.Sequence = (*(_5_obj).IndexInt(0)).(_dafny.Sequence)
		_ = _source0
		{
			{
				if (_source0).Equals(_dafny.SeqOfString("Config")) {
					var _6_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _6_valueOrError1
					_6_valueOrError1 = m_Wrappers.Companion_Default___.Need(((*(_5_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("Complex config name must be a string."))
					if (_6_valueOrError1).IsFailure() {
						output = (_6_valueOrError1).PropagateFailure()
						return output
					}
					_1_config = ((*(_5_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str()
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("Queries")) {
					var _7_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _7_valueOrError2
					var _out0 m_Wrappers.Result
					_ = _out0
					_out0 = Companion_Default___.GetComplexQueries((*(_5_obj).IndexInt(1)).(m_JSON_Values.JSON))
					_7_valueOrError2 = _out0
					if (_7_valueOrError2).IsFailure() {
						output = (_7_valueOrError2).PropagateFailure()
						return output
					}
					_2_queries = (_7_valueOrError2).Extract().(_dafny.Sequence)
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("Failing")) {
					var _8_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _8_valueOrError3
					var _out1 m_Wrappers.Result
					_ = _out1
					_out1 = Companion_Default___.GetSimpleQueries((*(_5_obj).IndexInt(1)).(m_JSON_Values.JSON))
					_8_valueOrError3 = _out1
					if (_8_valueOrError3).IsFailure() {
						output = (_8_valueOrError3).PropagateFailure()
						return output
					}
					_3_failures = (_8_valueOrError3).Extract().(_dafny.Sequence)
					goto Lmatch0
				}
			}
			{
				output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Unexpected part of a complex test : '"), (*(_5_obj).IndexInt(0)).(_dafny.Sequence)), _dafny.SeqOfString("'")))
				return output
			}
			goto Lmatch0
		}
	Lmatch0:
	}
	var _9_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _9_valueOrError4
	_9_valueOrError4 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((_1_config).Cardinality())).Sign() != -1, _dafny.SeqOfString("Every complex test must specify a config"))
	if (_9_valueOrError4).IsFailure() {
		output = (_9_valueOrError4).PropagateFailure()
		return output
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(Companion_ComplexTest_.Create_ComplexTest_(_1_config, _2_queries, _3_failures))
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetValueMap(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Object(), _dafny.SeqOfString("Value Map must be an object."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_results _dafny.Map
	_ = _1_results
	_1_results = _dafny.NewMapBuilder().ToMap()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_obj()).Cardinality())
	_ = _hi0
	for _2_i := _dafny.Zero; _2_i.Cmp(_hi0) < 0; _2_i = _2_i.Plus(_dafny.One) {
		var _3_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Default())
		_ = _3_valueOrError1
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_DdbItemJson.Companion_Default___.GetAttrValue((*(((data).Dtor_obj()).Select((_2_i).Uint32()).(_dafny.Tuple)).IndexInt(1)).(m_JSON_Values.JSON))
		_3_valueOrError1 = _out0
		if (_3_valueOrError1).IsFailure() {
			output = (_3_valueOrError1).PropagateFailure()
			return output
		}
		var _4_value m_ComAmazonawsDynamodbTypes.AttributeValue
		_ = _4_value
		_4_value = (_3_valueOrError1).Extract().(m_ComAmazonawsDynamodbTypes.AttributeValue)
		_1_results = (_1_results).Update((*(((data).Dtor_obj()).Select((_2_i).Uint32()).(_dafny.Tuple)).IndexInt(0)).(_dafny.Sequence), _4_value)
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(_1_results)
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetNameMap(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Object(), _dafny.SeqOfString("Name Map must be an object."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_results _dafny.Map
	_ = _1_results
	_1_results = _dafny.NewMapBuilder().ToMap()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_obj()).Cardinality())
	_ = _hi0
	for _2_i := _dafny.Zero; _2_i.Cmp(_hi0) < 0; _2_i = _2_i.Plus(_dafny.One) {
		var _3_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _3_valueOrError1
		_3_valueOrError1 = m_Wrappers.Companion_Default___.Need(((*(((data).Dtor_obj()).Select((_2_i).Uint32()).(_dafny.Tuple)).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString(""))
		if (_3_valueOrError1).IsFailure() {
			output = (_3_valueOrError1).PropagateFailure()
			return output
		}
		var _4_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _4_valueOrError2
		_4_valueOrError2 = m_Wrappers.Companion_Default___.Need(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__AttributeName(((*(((data).Dtor_obj()).Select((_2_i).Uint32()).(_dafny.Tuple)).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str()), _dafny.SeqOfString(""))
		if (_4_valueOrError2).IsFailure() {
			output = (_4_valueOrError2).PropagateFailure()
			return output
		}
		_1_results = (_1_results).Update((*(((data).Dtor_obj()).Select((_2_i).Uint32()).(_dafny.Tuple)).IndexInt(0)).(_dafny.Sequence), ((*(((data).Dtor_obj()).Select((_2_i).Uint32()).(_dafny.Tuple)).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str())
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(_1_results)
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetComplexQueries(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Array(), _dafny.SeqOfString("Queries must be an array."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_results _dafny.Sequence
	_ = _1_results
	_1_results = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_arr()).Cardinality())
	_ = _hi0
	for _2_i := _dafny.Zero; _2_i.Cmp(_hi0) < 0; _2_i = _2_i.Plus(_dafny.One) {
		var _3_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(Companion_ComplexQuery_.Default())
		_ = _3_valueOrError1
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = Companion_Default___.GetOneComplex(((data).Dtor_arr()).Select((_2_i).Uint32()).(m_JSON_Values.JSON))
		_3_valueOrError1 = _out0
		if (_3_valueOrError1).IsFailure() {
			output = (_3_valueOrError1).PropagateFailure()
			return output
		}
		var _4_item ComplexQuery
		_ = _4_item
		_4_item = (_3_valueOrError1).Extract().(ComplexQuery)
		_1_results = _dafny.Companion_Sequence_.Concatenate(_1_results, _dafny.SeqOf(_4_item))
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(_1_results)
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetOneComplex(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(Companion_ComplexQuery_.Default())
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Object(), _dafny.SeqOfString(""))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_query m_Wrappers.Option
	_ = _1_query
	_1_query = m_Wrappers.Companion_Option_.Create_None_()
	var _2_pass _dafny.Sequence
	_ = _2_pass
	_2_pass = _dafny.SeqOf()
	var _3_fail _dafny.Sequence
	_ = _3_fail
	_3_fail = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_obj()).Cardinality())
	_ = _hi0
	for _4_i := _dafny.Zero; _4_i.Cmp(_hi0) < 0; _4_i = _4_i.Plus(_dafny.One) {
		var _5_obj _dafny.Tuple
		_ = _5_obj
		_5_obj = ((data).Dtor_obj()).Select((_4_i).Uint32()).(_dafny.Tuple)
		var _source0 _dafny.Sequence = (*(_5_obj).IndexInt(0)).(_dafny.Sequence)
		_ = _source0
		{
			{
				if (_source0).Equals(_dafny.SeqOfString("Query")) {
					var _6_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(Companion_SimpleQuery_.Default())
					_ = _6_valueOrError1
					var _out0 m_Wrappers.Result
					_ = _out0
					_out0 = Companion_Default___.GetOneQuery((*(_5_obj).IndexInt(1)).(m_JSON_Values.JSON))
					_6_valueOrError1 = _out0
					if (_6_valueOrError1).IsFailure() {
						output = (_6_valueOrError1).PropagateFailure()
						return output
					}
					var _7_q SimpleQuery
					_ = _7_q
					_7_q = (_6_valueOrError1).Extract().(SimpleQuery)
					_1_query = m_Wrappers.Companion_Option_.Create_Some_(_7_q)
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("Pass")) {
					var _8_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _8_valueOrError2
					var _out1 m_Wrappers.Result
					_ = _out1
					_out1 = Companion_Default___.GetNumberStrings((*(_5_obj).IndexInt(1)).(m_JSON_Values.JSON))
					_8_valueOrError2 = _out1
					if (_8_valueOrError2).IsFailure() {
						output = (_8_valueOrError2).PropagateFailure()
						return output
					}
					_2_pass = (_8_valueOrError2).Extract().(_dafny.Sequence)
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("Fail")) {
					var _9_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _9_valueOrError3
					var _out2 m_Wrappers.Result
					_ = _out2
					_out2 = Companion_Default___.GetNumberStrings((*(_5_obj).IndexInt(1)).(m_JSON_Values.JSON))
					_9_valueOrError3 = _out2
					if (_9_valueOrError3).IsFailure() {
						output = (_9_valueOrError3).PropagateFailure()
						return output
					}
					_3_fail = (_9_valueOrError3).Extract().(_dafny.Sequence)
					goto Lmatch0
				}
			}
			{
				output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Unexpected part of a query : '"), (*(((data).Dtor_obj()).Select((_4_i).Uint32()).(_dafny.Tuple)).IndexInt(0)).(_dafny.Sequence)), _dafny.SeqOfString("'")))
				return output
			}
			goto Lmatch0
		}
	Lmatch0:
	}
	var _10_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _10_valueOrError4
	_10_valueOrError4 = m_Wrappers.Companion_Default___.Need((_1_query).Is_Some(), _dafny.SeqOfString(""))
	if (_10_valueOrError4).IsFailure() {
		output = (_10_valueOrError4).PropagateFailure()
		return output
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(Companion_ComplexQuery_.Create_ComplexQuery_((_1_query).Dtor_value().(SimpleQuery), _2_pass, _3_fail))
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetNumberStrings(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Array(), _dafny.SeqOfString("Number lists must be arrays"))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_results _dafny.Sequence
	_ = _1_results
	_1_results = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_arr()).Cardinality())
	_ = _hi0
	for _2_i := _dafny.Zero; _2_i.Cmp(_hi0) < 0; _2_i = _2_i.Plus(_dafny.One) {
		var _3_obj m_JSON_Values.JSON
		_ = _3_obj
		_3_obj = ((data).Dtor_arr()).Select((_2_i).Uint32()).(m_JSON_Values.JSON)
		var _4_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _4_valueOrError1
		_4_valueOrError1 = m_Wrappers.Companion_Default___.Need((_3_obj).Is_Number(), _dafny.SeqOfString(""))
		if (_4_valueOrError1).IsFailure() {
			output = (_4_valueOrError1).PropagateFailure()
			return output
		}
		var _5_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.Zero)
		_ = _5_valueOrError2
		_5_valueOrError2 = Companion_Default___.DecimalToNat((_3_obj).Dtor_num())
		if (_5_valueOrError2).IsFailure() {
			output = (_5_valueOrError2).PropagateFailure()
			return output
		}
		var _6_val _dafny.Int
		_ = _6_val
		_6_val = (_5_valueOrError2).Extract().(_dafny.Int)
		_1_results = _dafny.Companion_Sequence_.Concatenate(_1_results, _dafny.SeqOf(m_StandardLibrary_String.Companion_Default___.Base10Int2String(_6_val)))
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(_1_results)
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetNumbers(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Array(), _dafny.SeqOfString("Number lists must be arrays"))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_results _dafny.Sequence
	_ = _1_results
	_1_results = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_arr()).Cardinality())
	_ = _hi0
	for _2_i := _dafny.Zero; _2_i.Cmp(_hi0) < 0; _2_i = _2_i.Plus(_dafny.One) {
		var _3_obj m_JSON_Values.JSON
		_ = _3_obj
		_3_obj = ((data).Dtor_arr()).Select((_2_i).Uint32()).(m_JSON_Values.JSON)
		var _4_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _4_valueOrError1
		_4_valueOrError1 = m_Wrappers.Companion_Default___.Need((_3_obj).Is_Number(), _dafny.SeqOfString(""))
		if (_4_valueOrError1).IsFailure() {
			output = (_4_valueOrError1).PropagateFailure()
			return output
		}
		var _5_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.Zero)
		_ = _5_valueOrError2
		_5_valueOrError2 = Companion_Default___.DecimalToNat((_3_obj).Dtor_num())
		if (_5_valueOrError2).IsFailure() {
			output = (_5_valueOrError2).PropagateFailure()
			return output
		}
		var _6_val _dafny.Int
		_ = _6_val
		_6_val = (_5_valueOrError2).Extract().(_dafny.Int)
		_1_results = _dafny.Companion_Sequence_.Concatenate(_1_results, _dafny.SeqOf(_6_val))
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(_1_results)
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetSimpleQueries(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Array(), _dafny.SeqOfString("Queries must be an array."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_results _dafny.Sequence
	_ = _1_results
	_1_results = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_arr()).Cardinality())
	_ = _hi0
	for _2_i := _dafny.Zero; _2_i.Cmp(_hi0) < 0; _2_i = _2_i.Plus(_dafny.One) {
		var _3_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(Companion_SimpleQuery_.Default())
		_ = _3_valueOrError1
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = Companion_Default___.GetOneQuery(((data).Dtor_arr()).Select((_2_i).Uint32()).(m_JSON_Values.JSON))
		_3_valueOrError1 = _out0
		if (_3_valueOrError1).IsFailure() {
			output = (_3_valueOrError1).PropagateFailure()
			return output
		}
		var _4_item SimpleQuery
		_ = _4_item
		_4_item = (_3_valueOrError1).Extract().(SimpleQuery)
		_1_results = _dafny.Companion_Sequence_.Concatenate(_1_results, _dafny.SeqOf(_4_item))
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(_1_results)
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetOneQuery(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(Companion_SimpleQuery_.Default())
	_ = output
	if (data).Is_String() {
		output = m_Wrappers.Companion_Result_.Create_Success_(Companion_SimpleQuery_.Create_SimpleQuery_(m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_((data).Dtor_str()), _dafny.SeqOf()))
		return output
	} else if (data).Is_Object() {
		var _0_index m_Wrappers.Option
		_ = _0_index
		_0_index = m_Wrappers.Companion_Option_.Create_None_()
		var _1_keyExpr m_Wrappers.Option
		_ = _1_keyExpr
		_1_keyExpr = m_Wrappers.Companion_Option_.Create_None_()
		var _2_filterExpr m_Wrappers.Option
		_ = _2_filterExpr
		_2_filterExpr = m_Wrappers.Companion_Option_.Create_None_()
		var _3_failConfigs _dafny.Sequence
		_ = _3_failConfigs
		_3_failConfigs = _dafny.SeqOf()
		var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_obj()).Cardinality())
		_ = _hi0
		for _4_i := _dafny.Zero; _4_i.Cmp(_hi0) < 0; _4_i = _4_i.Plus(_dafny.One) {
			var _source0 _dafny.Sequence = (*(((data).Dtor_obj()).Select((_4_i).Uint32()).(_dafny.Tuple)).IndexInt(0)).(_dafny.Sequence)
			_ = _source0
			{
				{
					if (_source0).Equals(_dafny.SeqOfString("Index")) {
						var _5_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
						_ = _5_valueOrError0
						_5_valueOrError0 = m_Wrappers.Companion_Default___.Need(((*(((data).Dtor_obj()).Select((_4_i).Uint32()).(_dafny.Tuple)).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("Index for query ust be of type string."))
						if (_5_valueOrError0).IsFailure() {
							output = (_5_valueOrError0).PropagateFailure()
							return output
						}
						var _6_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
						_ = _6_valueOrError1
						_6_valueOrError1 = m_Wrappers.Companion_Default___.Need(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__IndexName(((*(((data).Dtor_obj()).Select((_4_i).Uint32()).(_dafny.Tuple)).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str()), _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Not a valid index name : '"), ((*(((data).Dtor_obj()).Select((_4_i).Uint32()).(_dafny.Tuple)).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str()), _dafny.SeqOfString("'")))
						if (_6_valueOrError1).IsFailure() {
							output = (_6_valueOrError1).PropagateFailure()
							return output
						}
						_0_index = m_Wrappers.Companion_Option_.Create_Some_(((*(((data).Dtor_obj()).Select((_4_i).Uint32()).(_dafny.Tuple)).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str())
						goto Lmatch0
					}
				}
				{
					if (_source0).Equals(_dafny.SeqOfString("Key")) {
						var _7_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
						_ = _7_valueOrError2
						_7_valueOrError2 = m_Wrappers.Companion_Default___.Need(((*(((data).Dtor_obj()).Select((_4_i).Uint32()).(_dafny.Tuple)).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("Key expression for query ust be of type string."))
						if (_7_valueOrError2).IsFailure() {
							output = (_7_valueOrError2).PropagateFailure()
							return output
						}
						_1_keyExpr = m_Wrappers.Companion_Option_.Create_Some_(((*(((data).Dtor_obj()).Select((_4_i).Uint32()).(_dafny.Tuple)).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str())
						goto Lmatch0
					}
				}
				{
					if (_source0).Equals(_dafny.SeqOfString("Filter")) {
						var _8_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
						_ = _8_valueOrError3
						_8_valueOrError3 = m_Wrappers.Companion_Default___.Need(((*(((data).Dtor_obj()).Select((_4_i).Uint32()).(_dafny.Tuple)).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("Filter expression for query ust be of type string."))
						if (_8_valueOrError3).IsFailure() {
							output = (_8_valueOrError3).PropagateFailure()
							return output
						}
						_2_filterExpr = m_Wrappers.Companion_Option_.Create_Some_(((*(((data).Dtor_obj()).Select((_4_i).Uint32()).(_dafny.Tuple)).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str())
						goto Lmatch0
					}
				}
				{
					if (_source0).Equals(_dafny.SeqOfString("Fail")) {
						var _9_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
						_ = _9_valueOrError4
						var _out0 m_Wrappers.Result
						_ = _out0
						_out0 = Companion_Default___.GetStrings((*(((data).Dtor_obj()).Select((_4_i).Uint32()).(_dafny.Tuple)).IndexInt(1)).(m_JSON_Values.JSON))
						_9_valueOrError4 = _out0
						if (_9_valueOrError4).IsFailure() {
							output = (_9_valueOrError4).PropagateFailure()
							return output
						}
						_3_failConfigs = (_9_valueOrError4).Extract().(_dafny.Sequence)
						goto Lmatch0
					}
				}
				{
					output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Unexpected part of a query : '"), (*(((data).Dtor_obj()).Select((_4_i).Uint32()).(_dafny.Tuple)).IndexInt(0)).(_dafny.Sequence)), _dafny.SeqOfString("'")))
					return output
				}
				goto Lmatch0
			}
		Lmatch0:
		}
		output = m_Wrappers.Companion_Result_.Create_Success_(Companion_SimpleQuery_.Create_SimpleQuery_(_0_index, _1_keyExpr, _2_filterExpr, _3_failConfigs))
		return output
	} else {
		output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Individual Query must be a string or an object."))
		return output
	}
	return output
}
func (_static *CompanionStruct_Default___) GetPairs(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Array(), _dafny.SeqOfString("Config Pairs must be an array of arrays."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_results _dafny.Sequence
	_ = _1_results
	_1_results = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_arr()).Cardinality())
	_ = _hi0
	for _2_i := _dafny.Zero; _2_i.Cmp(_hi0) < 0; _2_i = _2_i.Plus(_dafny.One) {
		var _3_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.TupleOf(_dafny.EmptySeq.SetString(), _dafny.EmptySeq.SetString()))
		_ = _3_valueOrError1
		_3_valueOrError1 = Companion_Default___.GetOnePair(((data).Dtor_arr()).Select((_2_i).Uint32()).(m_JSON_Values.JSON))
		if (_3_valueOrError1).IsFailure() {
			output = (_3_valueOrError1).PropagateFailure()
			return output
		}
		var _4_item _dafny.Tuple
		_ = _4_item
		_4_item = (_3_valueOrError1).Extract().(_dafny.Tuple)
		_1_results = _dafny.Companion_Sequence_.Concatenate(_1_results, _dafny.SeqOf(_4_item))
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(_1_results)
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetPower(n _dafny.Int, pow _dafny.Int) _dafny.Int {
	var _0___accumulator _dafny.Int = _dafny.One
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (pow).Sign() == 0 {
		return (n).Times(_0___accumulator)
	} else {
		_0___accumulator = (_0___accumulator).Times(_dafny.IntOfInt64(10))
		var _in0 _dafny.Int = n
		_ = _in0
		var _in1 _dafny.Int = (pow).Minus(_dafny.One)
		_ = _in1
		n = _in0
		pow = _in1
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) DecimalToNat(num m_JSON_Values.Decimal) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.DecimalToInt(num)
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_val _dafny.Int = (_0_valueOrError0).Extract().(_dafny.Int)
		_ = _1_val
		var _2_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((_1_val).Sign() != -1, _dafny.SeqOfString("Number must be > 0"))
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			return m_Wrappers.Companion_Result_.Create_Success_(_1_val)
		}
	}
}
func (_static *CompanionStruct_Default___) DecimalToInt(num m_JSON_Values.Decimal) m_Wrappers.Result {
	if ((num).Dtor_n()).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Zero)
	} else {
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(((num).Dtor_e10()).Sign() != -1, _dafny.SeqOfString("Number must be a whole number"))
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(((num).Dtor_e10()).Cmp(_dafny.IntOfInt64(100)) < 0, _dafny.SeqOfString("Number must be less than a googol"))
			_ = _1_valueOrError1
			if (_1_valueOrError1).IsFailure() {
				return (_1_valueOrError1).PropagateFailure()
			} else {
				return m_Wrappers.Companion_Result_.Create_Success_(Companion_Default___.GetPower((num).Dtor_n(), (num).Dtor_e10()))
			}
		}
	}
}
func (_static *CompanionStruct_Default___) GetOnePair(data m_JSON_Values.JSON) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(((((data).Is_Array()) && ((_dafny.IntOfUint32(((data).Dtor_arr()).Cardinality())).Cmp(_dafny.IntOfInt64(2)) == 0)) && ((((data).Dtor_arr()).Select(0).(m_JSON_Values.JSON)).Is_String())) && ((((data).Dtor_arr()).Select(1).(m_JSON_Values.JSON)).Is_String()), _dafny.SeqOfString("A Config Pair must be an array of two strings."))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_p1 _dafny.Sequence = (((data).Dtor_arr()).Select(0).(m_JSON_Values.JSON)).Dtor_str()
		_ = _1_p1
		var _2_p2 _dafny.Sequence = (((data).Dtor_arr()).Select(1).(m_JSON_Values.JSON)).Dtor_str()
		_ = _2_p2
		return m_Wrappers.Companion_Result_.Create_Success_(_dafny.TupleOf(_1_p1, _2_p2))
	}
}
func (_static *CompanionStruct_Default___) GetRecords(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Array(), _dafny.SeqOfString("Records must be an array of JSON objects."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_results _dafny.Sequence
	_ = _1_results
	_1_results = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_arr()).Cardinality())
	_ = _hi0
	for _2_i := _dafny.Zero; _2_i.Cmp(_hi0) < 0; _2_i = _2_i.Plus(_dafny.One) {
		var _3_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(Companion_Record_.Default())
		_ = _3_valueOrError1
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = Companion_Default___.GetRecord(((data).Dtor_arr()).Select((_2_i).Uint32()).(m_JSON_Values.JSON))
		_3_valueOrError1 = _out0
		if (_3_valueOrError1).IsFailure() {
			output = (_3_valueOrError1).PropagateFailure()
			return output
		}
		var _4_item Record
		_ = _4_item
		_4_item = (_3_valueOrError1).Extract().(Record)
		_1_results = _dafny.Companion_Sequence_.Concatenate(_1_results, _dafny.SeqOf(_4_item))
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(_1_results)
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetRecord(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(Companion_Record_.Default())
	_ = output
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = _0_valueOrError0
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_DdbItemJson.Companion_Default___.JsonToDdbItem(data)
	_0_valueOrError0 = _out0
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_item _dafny.Map
	_ = _1_item
	_1_item = (_0_valueOrError0).Extract().(_dafny.Map)
	if !(_1_item).Contains(Companion_Default___.HashName()) {
		output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Every record must specify the "), Companion_Default___.HashName()), _dafny.SeqOfString(" field")))
		return output
	}
	var _2_hash m_ComAmazonawsDynamodbTypes.AttributeValue
	_ = _2_hash
	_2_hash = (_1_item).Get(Companion_Default___.HashName()).(m_ComAmazonawsDynamodbTypes.AttributeValue)
	if !((_2_hash).Is_N()) {
		output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Value for "), Companion_Default___.HashName()), _dafny.SeqOfString(" must be a number")))
		return output
	}
	var _3_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.Zero)
	_ = _3_valueOrError1
	_3_valueOrError1 = m_DdbItemJson.Companion_Default___.StrToNat((_2_hash).Dtor_N(), _dafny.Zero)
	if (_3_valueOrError1).IsFailure() {
		output = (_3_valueOrError1).PropagateFailure()
		return output
	}
	var _4_num _dafny.Int
	_ = _4_num
	_4_num = (_3_valueOrError1).Extract().(_dafny.Int)
	output = m_Wrappers.Companion_Result_.Create_Success_(Companion_Record_.Create_Record_(_4_num, _1_item))
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetLarge(name _dafny.Sequence, data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(Companion_LargeRecord_.Default())
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Object(), _dafny.SeqOfString("LargeRecord must be a JSON object."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_item _dafny.Map
	_ = _1_item
	_1_item = _dafny.NewMapBuilder().ToMap()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_obj()).Cardinality())
	_ = _hi0
	for _2_i := _dafny.Zero; _2_i.Cmp(_hi0) < 0; _2_i = _2_i.Plus(_dafny.One) {
		var _3_obj _dafny.Tuple
		_ = _3_obj
		_3_obj = ((data).Dtor_obj()).Select((_2_i).Uint32()).(_dafny.Tuple)
		var _source0 _dafny.Sequence = (*(_3_obj).IndexInt(0)).(_dafny.Sequence)
		_ = _source0
		{
			{
				if (_source0).Equals(_dafny.SeqOfString("Item")) {
					var _4_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
					_ = _4_valueOrError1
					var _out0 m_Wrappers.Result
					_ = _out0
					_out0 = m_DdbItemJson.Companion_Default___.JsonToDdbItem((*(_3_obj).IndexInt(1)).(m_JSON_Values.JSON))
					_4_valueOrError1 = _out0
					if (_4_valueOrError1).IsFailure() {
						output = (_4_valueOrError1).PropagateFailure()
						return output
					}
					var _5_src _dafny.Map
					_ = _5_src
					_5_src = (_4_valueOrError1).Extract().(_dafny.Map)
					_1_item = _5_src
					goto Lmatch0
				}
			}
			{
				output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Unexpected part of a LargeRecord : '"), (*(_3_obj).IndexInt(0)).(_dafny.Sequence)), _dafny.SeqOfString("'")))
				return output
			}
			goto Lmatch0
		}
	Lmatch0:
	}
	if ((_1_item).Cardinality()).Sign() == 0 {
		output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Missing or Empty LargeRecord : '"), name), _dafny.SeqOfString("'")))
		return output
	}
	var _6_record LargeRecord
	_ = _6_record
	_6_record = Companion_LargeRecord_.Create_LargeRecord_(name, _1_item)
	output = m_Wrappers.Companion_Result_.Create_Success_(_6_record)
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetLarges(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Object(), _dafny.SeqOfString("Larges must be a JSON object."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_results _dafny.Sequence
	_ = _1_results
	_1_results = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_obj()).Cardinality())
	_ = _hi0
	for _2_i := _dafny.Zero; _2_i.Cmp(_hi0) < 0; _2_i = _2_i.Plus(_dafny.One) {
		var _3_obj _dafny.Tuple
		_ = _3_obj
		_3_obj = ((data).Dtor_obj()).Select((_2_i).Uint32()).(_dafny.Tuple)
		var _4_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(Companion_LargeRecord_.Default())
		_ = _4_valueOrError1
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = Companion_Default___.GetLarge((*(_3_obj).IndexInt(0)).(_dafny.Sequence), (*(_3_obj).IndexInt(1)).(m_JSON_Values.JSON))
		_4_valueOrError1 = _out0
		if (_4_valueOrError1).IsFailure() {
			output = (_4_valueOrError1).PropagateFailure()
			return output
		}
		var _5_record LargeRecord
		_ = _5_record
		_5_record = (_4_valueOrError1).Extract().(LargeRecord)
		_1_results = _dafny.Companion_Sequence_.Concatenate(_1_results, _dafny.SeqOf(_5_record))
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(_1_results)
	return output
	return output
}
func (_static *CompanionStruct_Default___) TableName() _dafny.Sequence {
	return _dafny.SeqOfString("GazelleVectorTable")
}
func (_static *CompanionStruct_Default___) HashName() _dafny.Sequence {
	return _dafny.SeqOfString("RecNum")
}
func (_static *CompanionStruct_Default___) Abc() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(97), uint8(98), uint8(99))
	_ = _0_s
	return _0_s
}

// End of class Default__

// Definition of datatype Record
type Record struct {
	Data_Record_
}

func (_this Record) Get_() Data_Record_ {
	return _this.Data_Record_
}

type Data_Record_ interface {
	isRecord()
}

type CompanionStruct_Record_ struct {
}

var Companion_Record_ = CompanionStruct_Record_{}

type Record_Record struct {
	Number _dafny.Int
	Item   _dafny.Map
}

func (Record_Record) isRecord() {}

func (CompanionStruct_Record_) Create_Record_(Number _dafny.Int, Item _dafny.Map) Record {
	return Record{Record_Record{Number, Item}}
}

func (_this Record) Is_Record() bool {
	_, ok := _this.Get_().(Record_Record)
	return ok
}

func (CompanionStruct_Record_) Default() Record {
	return Companion_Record_.Create_Record_(_dafny.Zero, _dafny.EmptyMap)
}

func (_this Record) Dtor_number() _dafny.Int {
	return _this.Get_().(Record_Record).Number
}

func (_this Record) Dtor_item() _dafny.Map {
	return _this.Get_().(Record_Record).Item
}

func (_this Record) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case Record_Record:
		{
			return "JsonConfig.Record.Record" + "(" + _dafny.String(data.Number) + ", " + _dafny.String(data.Item) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Record) Equals(other Record) bool {
	switch data1 := _this.Get_().(type) {
	case Record_Record:
		{
			data2, ok := other.Get_().(Record_Record)
			return ok && data1.Number.Cmp(data2.Number) == 0 && data1.Item.Equals(data2.Item)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this Record) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(Record)
	return ok && _this.Equals(typed)
}

func Type_Record_() _dafny.TypeDescriptor {
	return type_Record_{}
}

type type_Record_ struct {
}

func (_this type_Record_) Default() interface{} {
	return Companion_Record_.Default()
}

func (_this type_Record_) String() string {
	return "JsonConfig.Record"
}
func (_this Record) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Record{}

// End of datatype Record

// Definition of datatype LargeRecord
type LargeRecord struct {
	Data_LargeRecord_
}

func (_this LargeRecord) Get_() Data_LargeRecord_ {
	return _this.Data_LargeRecord_
}

type Data_LargeRecord_ interface {
	isLargeRecord()
}

type CompanionStruct_LargeRecord_ struct {
}

var Companion_LargeRecord_ = CompanionStruct_LargeRecord_{}

type LargeRecord_LargeRecord struct {
	Name _dafny.Sequence
	Item _dafny.Map
}

func (LargeRecord_LargeRecord) isLargeRecord() {}

func (CompanionStruct_LargeRecord_) Create_LargeRecord_(Name _dafny.Sequence, Item _dafny.Map) LargeRecord {
	return LargeRecord{LargeRecord_LargeRecord{Name, Item}}
}

func (_this LargeRecord) Is_LargeRecord() bool {
	_, ok := _this.Get_().(LargeRecord_LargeRecord)
	return ok
}

func (CompanionStruct_LargeRecord_) Default() LargeRecord {
	return Companion_LargeRecord_.Create_LargeRecord_(_dafny.EmptySeq.SetString(), _dafny.EmptyMap)
}

func (_this LargeRecord) Dtor_name() _dafny.Sequence {
	return _this.Get_().(LargeRecord_LargeRecord).Name
}

func (_this LargeRecord) Dtor_item() _dafny.Map {
	return _this.Get_().(LargeRecord_LargeRecord).Item
}

func (_this LargeRecord) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case LargeRecord_LargeRecord:
		{
			return "JsonConfig.LargeRecord.LargeRecord" + "(" + _dafny.String(data.Name) + ", " + _dafny.String(data.Item) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this LargeRecord) Equals(other LargeRecord) bool {
	switch data1 := _this.Get_().(type) {
	case LargeRecord_LargeRecord:
		{
			data2, ok := other.Get_().(LargeRecord_LargeRecord)
			return ok && data1.Name.Equals(data2.Name) && data1.Item.Equals(data2.Item)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this LargeRecord) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(LargeRecord)
	return ok && _this.Equals(typed)
}

func Type_LargeRecord_() _dafny.TypeDescriptor {
	return type_LargeRecord_{}
}

type type_LargeRecord_ struct {
}

func (_this type_LargeRecord_) Default() interface{} {
	return Companion_LargeRecord_.Default()
}

func (_this type_LargeRecord_) String() string {
	return "JsonConfig.LargeRecord"
}
func (_this LargeRecord) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = LargeRecord{}

// End of datatype LargeRecord

// Definition of datatype TableConfig
type TableConfig struct {
	Data_TableConfig_
}

func (_this TableConfig) Get_() Data_TableConfig_ {
	return _this.Data_TableConfig_
}

type Data_TableConfig_ interface {
	isTableConfig()
}

type CompanionStruct_TableConfig_ struct {
}

var Companion_TableConfig_ = CompanionStruct_TableConfig_{}

type TableConfig_TableConfig struct {
	Name    _dafny.Sequence
	Config  m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig
	Vanilla bool
}

func (TableConfig_TableConfig) isTableConfig() {}

func (CompanionStruct_TableConfig_) Create_TableConfig_(Name _dafny.Sequence, Config m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig, Vanilla bool) TableConfig {
	return TableConfig{TableConfig_TableConfig{Name, Config, Vanilla}}
}

func (_this TableConfig) Is_TableConfig() bool {
	_, ok := _this.Get_().(TableConfig_TableConfig)
	return ok
}

func (CompanionStruct_TableConfig_) Default() TableConfig {
	return Companion_TableConfig_.Create_TableConfig_(_dafny.EmptySeq.SetString(), m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_DynamoDbTableEncryptionConfig_.Default(), false)
}

func (_this TableConfig) Dtor_name() _dafny.Sequence {
	return _this.Get_().(TableConfig_TableConfig).Name
}

func (_this TableConfig) Dtor_config() m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTableEncryptionConfig {
	return _this.Get_().(TableConfig_TableConfig).Config
}

func (_this TableConfig) Dtor_vanilla() bool {
	return _this.Get_().(TableConfig_TableConfig).Vanilla
}

func (_this TableConfig) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case TableConfig_TableConfig:
		{
			return "JsonConfig.TableConfig.TableConfig" + "(" + _dafny.String(data.Name) + ", " + _dafny.String(data.Config) + ", " + _dafny.String(data.Vanilla) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this TableConfig) Equals(other TableConfig) bool {
	switch data1 := _this.Get_().(type) {
	case TableConfig_TableConfig:
		{
			data2, ok := other.Get_().(TableConfig_TableConfig)
			return ok && data1.Name.Equals(data2.Name) && data1.Config.Equals(data2.Config) && data1.Vanilla == data2.Vanilla
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this TableConfig) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(TableConfig)
	return ok && _this.Equals(typed)
}

func Type_TableConfig_() _dafny.TypeDescriptor {
	return type_TableConfig_{}
}

type type_TableConfig_ struct {
}

func (_this type_TableConfig_) Default() interface{} {
	return Companion_TableConfig_.Default()
}

func (_this type_TableConfig_) String() string {
	return "JsonConfig.TableConfig"
}
func (_this TableConfig) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = TableConfig{}

// End of datatype TableConfig

// Definition of datatype SimpleQuery
type SimpleQuery struct {
	Data_SimpleQuery_
}

func (_this SimpleQuery) Get_() Data_SimpleQuery_ {
	return _this.Data_SimpleQuery_
}

type Data_SimpleQuery_ interface {
	isSimpleQuery()
}

type CompanionStruct_SimpleQuery_ struct {
}

var Companion_SimpleQuery_ = CompanionStruct_SimpleQuery_{}

type SimpleQuery_SimpleQuery struct {
	Index       m_Wrappers.Option
	KeyExpr     m_Wrappers.Option
	FilterExpr  m_Wrappers.Option
	FailConfigs _dafny.Sequence
}

func (SimpleQuery_SimpleQuery) isSimpleQuery() {}

func (CompanionStruct_SimpleQuery_) Create_SimpleQuery_(Index m_Wrappers.Option, KeyExpr m_Wrappers.Option, FilterExpr m_Wrappers.Option, FailConfigs _dafny.Sequence) SimpleQuery {
	return SimpleQuery{SimpleQuery_SimpleQuery{Index, KeyExpr, FilterExpr, FailConfigs}}
}

func (_this SimpleQuery) Is_SimpleQuery() bool {
	_, ok := _this.Get_().(SimpleQuery_SimpleQuery)
	return ok
}

func (CompanionStruct_SimpleQuery_) Default() SimpleQuery {
	return Companion_SimpleQuery_.Create_SimpleQuery_(m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default(), _dafny.EmptySeq)
}

func (_this SimpleQuery) Dtor_index() m_Wrappers.Option {
	return _this.Get_().(SimpleQuery_SimpleQuery).Index
}

func (_this SimpleQuery) Dtor_keyExpr() m_Wrappers.Option {
	return _this.Get_().(SimpleQuery_SimpleQuery).KeyExpr
}

func (_this SimpleQuery) Dtor_filterExpr() m_Wrappers.Option {
	return _this.Get_().(SimpleQuery_SimpleQuery).FilterExpr
}

func (_this SimpleQuery) Dtor_failConfigs() _dafny.Sequence {
	return _this.Get_().(SimpleQuery_SimpleQuery).FailConfigs
}

func (_this SimpleQuery) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case SimpleQuery_SimpleQuery:
		{
			return "JsonConfig.SimpleQuery.SimpleQuery" + "(" + _dafny.String(data.Index) + ", " + _dafny.String(data.KeyExpr) + ", " + _dafny.String(data.FilterExpr) + ", " + _dafny.String(data.FailConfigs) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this SimpleQuery) Equals(other SimpleQuery) bool {
	switch data1 := _this.Get_().(type) {
	case SimpleQuery_SimpleQuery:
		{
			data2, ok := other.Get_().(SimpleQuery_SimpleQuery)
			return ok && data1.Index.Equals(data2.Index) && data1.KeyExpr.Equals(data2.KeyExpr) && data1.FilterExpr.Equals(data2.FilterExpr) && data1.FailConfigs.Equals(data2.FailConfigs)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this SimpleQuery) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(SimpleQuery)
	return ok && _this.Equals(typed)
}

func Type_SimpleQuery_() _dafny.TypeDescriptor {
	return type_SimpleQuery_{}
}

type type_SimpleQuery_ struct {
}

func (_this type_SimpleQuery_) Default() interface{} {
	return Companion_SimpleQuery_.Default()
}

func (_this type_SimpleQuery_) String() string {
	return "JsonConfig.SimpleQuery"
}
func (_this SimpleQuery) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = SimpleQuery{}

// End of datatype SimpleQuery

// Definition of datatype ComplexQuery
type ComplexQuery struct {
	Data_ComplexQuery_
}

func (_this ComplexQuery) Get_() Data_ComplexQuery_ {
	return _this.Data_ComplexQuery_
}

type Data_ComplexQuery_ interface {
	isComplexQuery()
}

type CompanionStruct_ComplexQuery_ struct {
}

var Companion_ComplexQuery_ = CompanionStruct_ComplexQuery_{}

type ComplexQuery_ComplexQuery struct {
	Query SimpleQuery
	Pass  _dafny.Sequence
	Fail  _dafny.Sequence
}

func (ComplexQuery_ComplexQuery) isComplexQuery() {}

func (CompanionStruct_ComplexQuery_) Create_ComplexQuery_(Query SimpleQuery, Pass _dafny.Sequence, Fail _dafny.Sequence) ComplexQuery {
	return ComplexQuery{ComplexQuery_ComplexQuery{Query, Pass, Fail}}
}

func (_this ComplexQuery) Is_ComplexQuery() bool {
	_, ok := _this.Get_().(ComplexQuery_ComplexQuery)
	return ok
}

func (CompanionStruct_ComplexQuery_) Default() ComplexQuery {
	return Companion_ComplexQuery_.Create_ComplexQuery_(Companion_SimpleQuery_.Default(), _dafny.EmptySeq, _dafny.EmptySeq)
}

func (_this ComplexQuery) Dtor_query() SimpleQuery {
	return _this.Get_().(ComplexQuery_ComplexQuery).Query
}

func (_this ComplexQuery) Dtor_pass() _dafny.Sequence {
	return _this.Get_().(ComplexQuery_ComplexQuery).Pass
}

func (_this ComplexQuery) Dtor_fail() _dafny.Sequence {
	return _this.Get_().(ComplexQuery_ComplexQuery).Fail
}

func (_this ComplexQuery) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ComplexQuery_ComplexQuery:
		{
			return "JsonConfig.ComplexQuery.ComplexQuery" + "(" + _dafny.String(data.Query) + ", " + _dafny.String(data.Pass) + ", " + _dafny.String(data.Fail) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ComplexQuery) Equals(other ComplexQuery) bool {
	switch data1 := _this.Get_().(type) {
	case ComplexQuery_ComplexQuery:
		{
			data2, ok := other.Get_().(ComplexQuery_ComplexQuery)
			return ok && data1.Query.Equals(data2.Query) && data1.Pass.Equals(data2.Pass) && data1.Fail.Equals(data2.Fail)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ComplexQuery) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ComplexQuery)
	return ok && _this.Equals(typed)
}

func Type_ComplexQuery_() _dafny.TypeDescriptor {
	return type_ComplexQuery_{}
}

type type_ComplexQuery_ struct {
}

func (_this type_ComplexQuery_) Default() interface{} {
	return Companion_ComplexQuery_.Default()
}

func (_this type_ComplexQuery_) String() string {
	return "JsonConfig.ComplexQuery"
}
func (_this ComplexQuery) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ComplexQuery{}

// End of datatype ComplexQuery

// Definition of datatype ComplexTest
type ComplexTest struct {
	Data_ComplexTest_
}

func (_this ComplexTest) Get_() Data_ComplexTest_ {
	return _this.Data_ComplexTest_
}

type Data_ComplexTest_ interface {
	isComplexTest()
}

type CompanionStruct_ComplexTest_ struct {
}

var Companion_ComplexTest_ = CompanionStruct_ComplexTest_{}

type ComplexTest_ComplexTest struct {
	Config   _dafny.Sequence
	Queries  _dafny.Sequence
	Failures _dafny.Sequence
}

func (ComplexTest_ComplexTest) isComplexTest() {}

func (CompanionStruct_ComplexTest_) Create_ComplexTest_(Config _dafny.Sequence, Queries _dafny.Sequence, Failures _dafny.Sequence) ComplexTest {
	return ComplexTest{ComplexTest_ComplexTest{Config, Queries, Failures}}
}

func (_this ComplexTest) Is_ComplexTest() bool {
	_, ok := _this.Get_().(ComplexTest_ComplexTest)
	return ok
}

func (CompanionStruct_ComplexTest_) Default() ComplexTest {
	return Companion_ComplexTest_.Create_ComplexTest_(_dafny.EmptySeq.SetString(), _dafny.EmptySeq, _dafny.EmptySeq)
}

func (_this ComplexTest) Dtor_config() _dafny.Sequence {
	return _this.Get_().(ComplexTest_ComplexTest).Config
}

func (_this ComplexTest) Dtor_queries() _dafny.Sequence {
	return _this.Get_().(ComplexTest_ComplexTest).Queries
}

func (_this ComplexTest) Dtor_failures() _dafny.Sequence {
	return _this.Get_().(ComplexTest_ComplexTest).Failures
}

func (_this ComplexTest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ComplexTest_ComplexTest:
		{
			return "JsonConfig.ComplexTest.ComplexTest" + "(" + _dafny.String(data.Config) + ", " + _dafny.String(data.Queries) + ", " + _dafny.String(data.Failures) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ComplexTest) Equals(other ComplexTest) bool {
	switch data1 := _this.Get_().(type) {
	case ComplexTest_ComplexTest:
		{
			data2, ok := other.Get_().(ComplexTest_ComplexTest)
			return ok && data1.Config.Equals(data2.Config) && data1.Queries.Equals(data2.Queries) && data1.Failures.Equals(data2.Failures)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ComplexTest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ComplexTest)
	return ok && _this.Equals(typed)
}

func Type_ComplexTest_() _dafny.TypeDescriptor {
	return type_ComplexTest_{}
}

type type_ComplexTest_ struct {
}

func (_this type_ComplexTest_) Default() interface{} {
	return Companion_ComplexTest_.Default()
}

func (_this type_ComplexTest_) String() string {
	return "JsonConfig.ComplexTest"
}
func (_this ComplexTest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ComplexTest{}

// End of datatype ComplexTest

// Definition of datatype RoundTripTest
type RoundTripTest struct {
	Data_RoundTripTest_
}

func (_this RoundTripTest) Get_() Data_RoundTripTest_ {
	return _this.Data_RoundTripTest_
}

type Data_RoundTripTest_ interface {
	isRoundTripTest()
}

type CompanionStruct_RoundTripTest_ struct {
}

var Companion_RoundTripTest_ = CompanionStruct_RoundTripTest_{}

type RoundTripTest_RoundTripTest struct {
	Configs _dafny.Map
	Records _dafny.Sequence
}

func (RoundTripTest_RoundTripTest) isRoundTripTest() {}

func (CompanionStruct_RoundTripTest_) Create_RoundTripTest_(Configs _dafny.Map, Records _dafny.Sequence) RoundTripTest {
	return RoundTripTest{RoundTripTest_RoundTripTest{Configs, Records}}
}

func (_this RoundTripTest) Is_RoundTripTest() bool {
	_, ok := _this.Get_().(RoundTripTest_RoundTripTest)
	return ok
}

func (CompanionStruct_RoundTripTest_) Default() RoundTripTest {
	return Companion_RoundTripTest_.Create_RoundTripTest_(_dafny.EmptyMap, _dafny.EmptySeq)
}

func (_this RoundTripTest) Dtor_configs() _dafny.Map {
	return _this.Get_().(RoundTripTest_RoundTripTest).Configs
}

func (_this RoundTripTest) Dtor_records() _dafny.Sequence {
	return _this.Get_().(RoundTripTest_RoundTripTest).Records
}

func (_this RoundTripTest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case RoundTripTest_RoundTripTest:
		{
			return "JsonConfig.RoundTripTest.RoundTripTest" + "(" + _dafny.String(data.Configs) + ", " + _dafny.String(data.Records) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this RoundTripTest) Equals(other RoundTripTest) bool {
	switch data1 := _this.Get_().(type) {
	case RoundTripTest_RoundTripTest:
		{
			data2, ok := other.Get_().(RoundTripTest_RoundTripTest)
			return ok && data1.Configs.Equals(data2.Configs) && data1.Records.Equals(data2.Records)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this RoundTripTest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(RoundTripTest)
	return ok && _this.Equals(typed)
}

func Type_RoundTripTest_() _dafny.TypeDescriptor {
	return type_RoundTripTest_{}
}

type type_RoundTripTest_ struct {
}

func (_this type_RoundTripTest_) Default() interface{} {
	return Companion_RoundTripTest_.Default()
}

func (_this type_RoundTripTest_) String() string {
	return "JsonConfig.RoundTripTest"
}
func (_this RoundTripTest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = RoundTripTest{}

// End of datatype RoundTripTest

// Definition of datatype WriteTest
type WriteTest struct {
	Data_WriteTest_
}

func (_this WriteTest) Get_() Data_WriteTest_ {
	return _this.Data_WriteTest_
}

type Data_WriteTest_ interface {
	isWriteTest()
}

type CompanionStruct_WriteTest_ struct {
}

var Companion_WriteTest_ = CompanionStruct_WriteTest_{}

type WriteTest_WriteTest struct {
	Config   TableConfig
	Records  _dafny.Sequence
	FileName _dafny.Sequence
}

func (WriteTest_WriteTest) isWriteTest() {}

func (CompanionStruct_WriteTest_) Create_WriteTest_(Config TableConfig, Records _dafny.Sequence, FileName _dafny.Sequence) WriteTest {
	return WriteTest{WriteTest_WriteTest{Config, Records, FileName}}
}

func (_this WriteTest) Is_WriteTest() bool {
	_, ok := _this.Get_().(WriteTest_WriteTest)
	return ok
}

func (CompanionStruct_WriteTest_) Default() WriteTest {
	return Companion_WriteTest_.Create_WriteTest_(Companion_TableConfig_.Default(), _dafny.EmptySeq, _dafny.EmptySeq.SetString())
}

func (_this WriteTest) Dtor_config() TableConfig {
	return _this.Get_().(WriteTest_WriteTest).Config
}

func (_this WriteTest) Dtor_records() _dafny.Sequence {
	return _this.Get_().(WriteTest_WriteTest).Records
}

func (_this WriteTest) Dtor_fileName() _dafny.Sequence {
	return _this.Get_().(WriteTest_WriteTest).FileName
}

func (_this WriteTest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case WriteTest_WriteTest:
		{
			return "JsonConfig.WriteTest.WriteTest" + "(" + _dafny.String(data.Config) + ", " + _dafny.String(data.Records) + ", " + _dafny.String(data.FileName) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this WriteTest) Equals(other WriteTest) bool {
	switch data1 := _this.Get_().(type) {
	case WriteTest_WriteTest:
		{
			data2, ok := other.Get_().(WriteTest_WriteTest)
			return ok && data1.Config.Equals(data2.Config) && data1.Records.Equals(data2.Records) && data1.FileName.Equals(data2.FileName)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this WriteTest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(WriteTest)
	return ok && _this.Equals(typed)
}

func Type_WriteTest_() _dafny.TypeDescriptor {
	return type_WriteTest_{}
}

type type_WriteTest_ struct {
}

func (_this type_WriteTest_) Default() interface{} {
	return Companion_WriteTest_.Default()
}

func (_this type_WriteTest_) String() string {
	return "JsonConfig.WriteTest"
}
func (_this WriteTest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = WriteTest{}

// End of datatype WriteTest

// Definition of datatype DecryptTest
type DecryptTest struct {
	Data_DecryptTest_
}

func (_this DecryptTest) Get_() Data_DecryptTest_ {
	return _this.Data_DecryptTest_
}

type Data_DecryptTest_ interface {
	isDecryptTest()
}

type CompanionStruct_DecryptTest_ struct {
}

var Companion_DecryptTest_ = CompanionStruct_DecryptTest_{}

type DecryptTest_DecryptTest struct {
	Config           TableConfig
	EncryptedRecords _dafny.Sequence
	PlaintextRecords _dafny.Sequence
}

func (DecryptTest_DecryptTest) isDecryptTest() {}

func (CompanionStruct_DecryptTest_) Create_DecryptTest_(Config TableConfig, EncryptedRecords _dafny.Sequence, PlaintextRecords _dafny.Sequence) DecryptTest {
	return DecryptTest{DecryptTest_DecryptTest{Config, EncryptedRecords, PlaintextRecords}}
}

func (_this DecryptTest) Is_DecryptTest() bool {
	_, ok := _this.Get_().(DecryptTest_DecryptTest)
	return ok
}

func (CompanionStruct_DecryptTest_) Default() DecryptTest {
	return Companion_DecryptTest_.Create_DecryptTest_(Companion_TableConfig_.Default(), _dafny.EmptySeq, _dafny.EmptySeq)
}

func (_this DecryptTest) Dtor_config() TableConfig {
	return _this.Get_().(DecryptTest_DecryptTest).Config
}

func (_this DecryptTest) Dtor_encryptedRecords() _dafny.Sequence {
	return _this.Get_().(DecryptTest_DecryptTest).EncryptedRecords
}

func (_this DecryptTest) Dtor_plaintextRecords() _dafny.Sequence {
	return _this.Get_().(DecryptTest_DecryptTest).PlaintextRecords
}

func (_this DecryptTest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DecryptTest_DecryptTest:
		{
			return "JsonConfig.DecryptTest.DecryptTest" + "(" + _dafny.String(data.Config) + ", " + _dafny.String(data.EncryptedRecords) + ", " + _dafny.String(data.PlaintextRecords) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DecryptTest) Equals(other DecryptTest) bool {
	switch data1 := _this.Get_().(type) {
	case DecryptTest_DecryptTest:
		{
			data2, ok := other.Get_().(DecryptTest_DecryptTest)
			return ok && data1.Config.Equals(data2.Config) && data1.EncryptedRecords.Equals(data2.EncryptedRecords) && data1.PlaintextRecords.Equals(data2.PlaintextRecords)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DecryptTest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DecryptTest)
	return ok && _this.Equals(typed)
}

func Type_DecryptTest_() _dafny.TypeDescriptor {
	return type_DecryptTest_{}
}

type type_DecryptTest_ struct {
}

func (_this type_DecryptTest_) Default() interface{} {
	return Companion_DecryptTest_.Default()
}

func (_this type_DecryptTest_) String() string {
	return "JsonConfig.DecryptTest"
}
func (_this DecryptTest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DecryptTest{}

// End of datatype DecryptTest

// Definition of datatype IoTest
type IoTest struct {
	Data_IoTest_
}

func (_this IoTest) Get_() Data_IoTest_ {
	return _this.Data_IoTest_
}

type Data_IoTest_ interface {
	isIoTest()
}

type CompanionStruct_IoTest_ struct {
}

var Companion_IoTest_ = CompanionStruct_IoTest_{}

type IoTest_IoTest struct {
	Name        _dafny.Sequence
	WriteConfig TableConfig
	ReadConfig  TableConfig
	Records     _dafny.Sequence
	Names       _dafny.Map
	Values      _dafny.Map
	Queries     _dafny.Sequence
}

func (IoTest_IoTest) isIoTest() {}

func (CompanionStruct_IoTest_) Create_IoTest_(Name _dafny.Sequence, WriteConfig TableConfig, ReadConfig TableConfig, Records _dafny.Sequence, Names _dafny.Map, Values _dafny.Map, Queries _dafny.Sequence) IoTest {
	return IoTest{IoTest_IoTest{Name, WriteConfig, ReadConfig, Records, Names, Values, Queries}}
}

func (_this IoTest) Is_IoTest() bool {
	_, ok := _this.Get_().(IoTest_IoTest)
	return ok
}

func (CompanionStruct_IoTest_) Default() IoTest {
	return Companion_IoTest_.Create_IoTest_(_dafny.EmptySeq.SetString(), Companion_TableConfig_.Default(), Companion_TableConfig_.Default(), _dafny.EmptySeq, _dafny.EmptyMap, _dafny.EmptyMap, _dafny.EmptySeq)
}

func (_this IoTest) Dtor_name() _dafny.Sequence {
	return _this.Get_().(IoTest_IoTest).Name
}

func (_this IoTest) Dtor_writeConfig() TableConfig {
	return _this.Get_().(IoTest_IoTest).WriteConfig
}

func (_this IoTest) Dtor_readConfig() TableConfig {
	return _this.Get_().(IoTest_IoTest).ReadConfig
}

func (_this IoTest) Dtor_records() _dafny.Sequence {
	return _this.Get_().(IoTest_IoTest).Records
}

func (_this IoTest) Dtor_names() _dafny.Map {
	return _this.Get_().(IoTest_IoTest).Names
}

func (_this IoTest) Dtor_values() _dafny.Map {
	return _this.Get_().(IoTest_IoTest).Values
}

func (_this IoTest) Dtor_queries() _dafny.Sequence {
	return _this.Get_().(IoTest_IoTest).Queries
}

func (_this IoTest) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case IoTest_IoTest:
		{
			return "JsonConfig.IoTest.IoTest" + "(" + _dafny.String(data.Name) + ", " + _dafny.String(data.WriteConfig) + ", " + _dafny.String(data.ReadConfig) + ", " + _dafny.String(data.Records) + ", " + _dafny.String(data.Names) + ", " + _dafny.String(data.Values) + ", " + _dafny.String(data.Queries) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this IoTest) Equals(other IoTest) bool {
	switch data1 := _this.Get_().(type) {
	case IoTest_IoTest:
		{
			data2, ok := other.Get_().(IoTest_IoTest)
			return ok && data1.Name.Equals(data2.Name) && data1.WriteConfig.Equals(data2.WriteConfig) && data1.ReadConfig.Equals(data2.ReadConfig) && data1.Records.Equals(data2.Records) && data1.Names.Equals(data2.Names) && data1.Values.Equals(data2.Values) && data1.Queries.Equals(data2.Queries)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this IoTest) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(IoTest)
	return ok && _this.Equals(typed)
}

func Type_IoTest_() _dafny.TypeDescriptor {
	return type_IoTest_{}
}

type type_IoTest_ struct {
}

func (_this type_IoTest_) Default() interface{} {
	return Companion_IoTest_.Default()
}

func (_this type_IoTest_) String() string {
	return "JsonConfig.IoTest"
}
func (_this IoTest) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = IoTest{}

// End of datatype IoTest
