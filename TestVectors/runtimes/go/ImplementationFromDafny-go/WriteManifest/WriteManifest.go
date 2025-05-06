// Package WriteManifest
// Dafny module WriteManifest compiled into Go

package WriteManifest

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
	m_UTF8 "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/UTF8"
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
	m_DdbItemJson "github.com/aws/aws-database-encryption-sdk-dynamodb/testvectors/DdbItemJson"
	m_JsonConfig "github.com/aws/aws-database-encryption-sdk-dynamodb/testvectors/JsonConfig"
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
var _ m_JsonConfig.Dummy__

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
	return "WriteManifest.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) Manifest() _dafny.Tuple {
	var _0_result _dafny.Sequence = _dafny.SeqOf(_dafny.TupleOf(_dafny.SeqOfString("type"), m_JSON_Values.Companion_JSON_.Create_String_(Companion_Default___.ENCRYPT__TYPE())), _dafny.TupleOf(_dafny.SeqOfString("version"), m_JSON_Values.Companion_JSON_.Create_String_(_dafny.SeqOfString("1"))))
	_ = _0_result
	return _dafny.TupleOf(_dafny.SeqOfString("manifest"), m_JSON_Values.Companion_JSON_.Create_Object_(_0_result))
}
func (_static *CompanionStruct_Default___) TextToJson(x _dafny.Sequence) m_JSON_Values.JSON {
	var output m_JSON_Values.JSON = m_JSON_Values.Companion_JSON_.Default()
	_ = output
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_UTF8.Companion_ValidUTF8Bytes_.Witness())
	_ = _0_valueOrError0
	_0_valueOrError0 = m_UTF8.Encode(x)
	if !(!((_0_valueOrError0).IsFailure())) {
		panic("dafny/DDBEncryption/src/WriteManifest.dfy(133,15): " + (_0_valueOrError0).String())
	}
	var _1_str _dafny.Sequence
	_ = _1_str
	_1_str = (_0_valueOrError0).Extract().(_dafny.Sequence)
	var _2_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_JSON_Values.Companion_JSON_.Default())
	_ = _2_valueOrError1
	_2_valueOrError1 = m_JSON_API.Companion_Default___.Deserialize(_1_str)
	if !(!((_2_valueOrError1).IsFailure())) {
		panic("dafny/DDBEncryption/src/WriteManifest.dfy(134,16): " + (_2_valueOrError1).String())
	}
	var _3_json m_JSON_Values.JSON
	_ = _3_json
	_3_json = (_2_valueOrError1).Extract().(m_JSON_Values.JSON)
	output = _3_json
	return output
	return output
}
func (_static *CompanionStruct_Default___) MakeTest(name _dafny.Sequence, typ _dafny.Sequence, desc _dafny.Sequence, configJson _dafny.Sequence, recordJson _dafny.Sequence, decryptConfigJson m_Wrappers.Option) _dafny.Tuple {
	var output _dafny.Tuple = _dafny.TupleOf(_dafny.EmptySeq.SetString(), m_JSON_Values.Companion_JSON_.Default())
	_ = output
	var _0_config m_JSON_Values.JSON
	_ = _0_config
	var _out0 m_JSON_Values.JSON
	_ = _out0
	_out0 = Companion_Default___.TextToJson(configJson)
	_0_config = _out0
	var _1_record m_JSON_Values.JSON
	_ = _1_record
	var _out1 m_JSON_Values.JSON
	_ = _out1
	_out1 = Companion_Default___.TextToJson(recordJson)
	_1_record = _out1
	var _2_result _dafny.Sequence
	_ = _2_result
	_2_result = _dafny.SeqOf(_dafny.TupleOf(_dafny.SeqOfString("type"), m_JSON_Values.Companion_JSON_.Create_String_(typ)), _dafny.TupleOf(_dafny.SeqOfString("description"), m_JSON_Values.Companion_JSON_.Create_String_(desc)), _dafny.TupleOf(_dafny.SeqOfString("config"), _0_config), _dafny.TupleOf(_dafny.SeqOfString("record"), _1_record))
	if (decryptConfigJson).Is_Some() {
		var _3_decryptConfig m_JSON_Values.JSON
		_ = _3_decryptConfig
		var _out2 m_JSON_Values.JSON
		_ = _out2
		_out2 = Companion_Default___.TextToJson((decryptConfigJson).Dtor_value().(_dafny.Sequence))
		_3_decryptConfig = _out2
		_2_result = _dafny.Companion_Sequence_.Concatenate(_2_result, _dafny.SeqOf(_dafny.TupleOf(_dafny.SeqOfString("decryptConfig"), _3_decryptConfig)))
	}
	output = _dafny.TupleOf(name, m_JSON_Values.Companion_JSON_.Create_Object_(_2_result))
	return output
	return output
}
func (_static *CompanionStruct_Default___) MakeConfig(actions _dafny.Sequence) m_JSON_Values.JSON {
	var output m_JSON_Values.JSON = m_JSON_Values.Companion_JSON_.Default()
	_ = output
	var _0_configActions _dafny.Sequence
	_ = _0_configActions
	_0_configActions = _dafny.SeqOf()
	var _1_notSigned _dafny.Sequence
	_ = _1_notSigned
	_1_notSigned = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfInt64(6)
	_ = _hi0
	for _2_i := _dafny.Zero; _2_i.Cmp(_hi0) < 0; _2_i = _2_i.Plus(_dafny.One) {
		var _3_myAction _dafny.Int
		_ = _3_myAction
		_3_myAction = (actions).Select((_2_i).Uint32()).(_dafny.Int)
		_0_configActions = _dafny.Companion_Sequence_.Concatenate(_0_configActions, _dafny.SeqOf(_dafny.TupleOf((Companion_Default___.MyAttrNames()).Select((_2_i).Uint32()).(_dafny.Sequence), m_JSON_Values.Companion_JSON_.Create_String_((Companion_Default___.MyActionNames()).Select((_3_myAction).Uint32()).(_dafny.Sequence)))))
		if (_3_myAction).Cmp(Companion_Default___.DoNothing()) == 0 {
			_1_notSigned = _dafny.Companion_Sequence_.Concatenate(_1_notSigned, _dafny.SeqOf(m_JSON_Values.Companion_JSON_.Create_String_((Companion_Default___.MyAttrNames()).Select((_2_i).Uint32()).(_dafny.Sequence))))
		}
	}
	var _4_result _dafny.Sequence
	_ = _4_result
	_4_result = _dafny.SeqOf(_dafny.TupleOf(_dafny.SeqOfString("attributeActionsOnEncrypt"), m_JSON_Values.Companion_JSON_.Create_Object_(_0_configActions)), _dafny.TupleOf(_dafny.SeqOfString("allowedUnsignedAttributes"), m_JSON_Values.Companion_JSON_.Create_Array_(_1_notSigned)))
	output = m_JSON_Values.Companion_JSON_.Create_Object_(_4_result)
	return output
	return output
}
func (_static *CompanionStruct_Default___) MakeConfigTest(name _dafny.Sequence, config m_JSON_Values.JSON, record m_JSON_Values.JSON, decryptConfigJson m_Wrappers.Option) _dafny.Tuple {
	var output _dafny.Tuple = _dafny.TupleOf(_dafny.EmptySeq.SetString(), m_JSON_Values.Companion_JSON_.Default())
	_ = output
	var _0_result _dafny.Sequence
	_ = _0_result
	_0_result = _dafny.SeqOf(_dafny.TupleOf(_dafny.SeqOfString("type"), m_JSON_Values.Companion_JSON_.Create_String_(_dafny.SeqOfString("positive-encrypt"))), _dafny.TupleOf(_dafny.SeqOfString("description"), m_JSON_Values.Companion_JSON_.Create_String_(_dafny.SeqOfString("config test"))), _dafny.TupleOf(_dafny.SeqOfString("config"), config), _dafny.TupleOf(_dafny.SeqOfString("record"), record))
	if (decryptConfigJson).Is_Some() {
		var _1_decryptConfig m_JSON_Values.JSON
		_ = _1_decryptConfig
		_1_decryptConfig = (decryptConfigJson).Dtor_value().(m_JSON_Values.JSON)
		_0_result = _dafny.Companion_Sequence_.Concatenate(_0_result, _dafny.SeqOf(_dafny.TupleOf(_dafny.SeqOfString("decryptConfig"), _1_decryptConfig)))
	}
	output = _dafny.TupleOf(name, m_JSON_Values.Companion_JSON_.Create_Object_(_0_result))
	return output
	return output
}
func (_static *CompanionStruct_Default___) Increment(x _dafny.Sequence) _dafny.Sequence {
	if ((x).Select(5).(_dafny.Int)).Cmp(_dafny.IntOfInt64(3)) < 0 {
		return _dafny.SeqOf((x).Select(0).(_dafny.Int), (x).Select(1).(_dafny.Int), (x).Select(2).(_dafny.Int), (x).Select(3).(_dafny.Int), (x).Select(4).(_dafny.Int), ((x).Select(5).(_dafny.Int)).Plus(_dafny.One))
	} else if ((x).Select(4).(_dafny.Int)).Cmp(_dafny.IntOfInt64(3)) < 0 {
		return _dafny.SeqOf((x).Select(0).(_dafny.Int), (x).Select(1).(_dafny.Int), (x).Select(2).(_dafny.Int), (x).Select(3).(_dafny.Int), ((x).Select(4).(_dafny.Int)).Plus(_dafny.One), _dafny.Zero)
	} else if ((x).Select(3).(_dafny.Int)).Cmp(_dafny.IntOfInt64(3)) < 0 {
		return _dafny.SeqOf((x).Select(0).(_dafny.Int), (x).Select(1).(_dafny.Int), (x).Select(2).(_dafny.Int), ((x).Select(3).(_dafny.Int)).Plus(_dafny.One), _dafny.Zero, _dafny.Zero)
	} else if ((x).Select(2).(_dafny.Int)).Cmp(_dafny.IntOfInt64(3)) < 0 {
		return _dafny.SeqOf((x).Select(0).(_dafny.Int), (x).Select(1).(_dafny.Int), ((x).Select(2).(_dafny.Int)).Plus(_dafny.One), _dafny.Zero, _dafny.Zero, _dafny.Zero)
	} else if ((x).Select(1).(_dafny.Int)).Cmp(_dafny.IntOfInt64(3)) < 0 {
		return _dafny.SeqOf((x).Select(0).(_dafny.Int), ((x).Select(1).(_dafny.Int)).Plus(_dafny.One), _dafny.Zero, _dafny.Zero, _dafny.Zero, _dafny.Zero)
	} else if ((x).Select(0).(_dafny.Int)).Cmp(_dafny.IntOfInt64(3)) < 0 {
		return _dafny.SeqOf(((x).Select(0).(_dafny.Int)).Plus(_dafny.One), _dafny.Zero, _dafny.Zero, _dafny.Zero, _dafny.Zero, _dafny.Zero)
	} else {
		return _dafny.SeqOf(_dafny.Zero, _dafny.Zero, _dafny.Zero, _dafny.Zero, _dafny.Zero, _dafny.Zero)
	}
}
func (_static *CompanionStruct_Default___) IsConsistent(actions _dafny.Sequence) bool {
	if _dafny.Companion_Sequence_.Contains(_dafny.SeqOf(Companion_Default___.DoNothing(), Companion_Default___.Encrypt()), (actions).Select(0).(_dafny.Int)) {
		return false
	} else if (((actions).Select(0).(_dafny.Int)).Cmp(Companion_Default___.SignOnly()) == 0) && (_dafny.Quantifier(_dafny.SingleValue(Companion_Default___.SignInclude()), false, func(_exists_var_0 _dafny.Int) bool {
		var _0_x _dafny.Int
		_0_x = interface{}(_exists_var_0).(_dafny.Int)
		return (_dafny.Companion_Sequence_.Contains(actions, _0_x)) && ((_0_x).Cmp(Companion_Default___.SignInclude()) == 0)
	})) {
		return false
	} else {
		return true
	}
}
func (_static *CompanionStruct_Default___) IsConsistentWith(oldActions _dafny.Sequence, newActions _dafny.Sequence) bool {
	if (!(Companion_Default___.IsConsistent(oldActions))) || (!(Companion_Default___.IsConsistent(newActions))) {
		return false
	} else {
		return !(_dafny.Quantifier(_dafny.IntegerRange(_dafny.Zero, _dafny.IntOfInt64(6)), false, func(_exists_var_0 _dafny.Int) bool {
			var _0_i _dafny.Int
			_0_i = interface{}(_exists_var_0).(_dafny.Int)
			return (((_0_i).Sign() != -1) && ((_0_i).Cmp(_dafny.IntOfInt64(6)) < 0)) && ((((oldActions).Select((_0_i).Uint32()).(_dafny.Int)).Cmp(Companion_Default___.DoNothing()) == 0) != (((newActions).Select((_0_i).Uint32()).(_dafny.Int)).Cmp(Companion_Default___.DoNothing()) == 0) /* dircomp */)
		}))
	}
}
func (_static *CompanionStruct_Default___) MakeConfigTests() _dafny.Sequence {
	var output _dafny.Sequence = _dafny.EmptySeq
	_ = output
	var _0_actions _dafny.Sequence
	_ = _0_actions
	_0_actions = _dafny.SeqOf(_dafny.Zero, _dafny.Zero, _dafny.Zero, _dafny.Zero, _dafny.Zero, _dafny.Zero)
	var _1_result _dafny.Sequence
	_ = _1_result
	_1_result = _dafny.SeqOf()
	var _2_record m_JSON_Values.JSON
	_ = _2_record
	var _out0 m_JSON_Values.JSON
	_ = _out0
	_out0 = Companion_Default___.TextToJson(Companion_Default___.ConfigRecord())
	_2_record = _out0
	var _3_actionWrittenOuter _dafny.Int
	_ = _3_actionWrittenOuter
	_3_actionWrittenOuter = _dafny.Zero
	var _4_actionWrittenInner _dafny.Int
	_ = _4_actionWrittenInner
	_4_actionWrittenInner = _dafny.Zero
	var _hi0 _dafny.Int = _dafny.IntOfInt64(4096)
	_ = _hi0
	for _5_i := _dafny.Zero; _5_i.Cmp(_hi0) < 0; _5_i = _5_i.Plus(_dafny.One) {
		_0_actions = Companion_Default___.Increment(_0_actions)
		if Companion_Default___.IsConsistent(_0_actions) {
			var _6_name _dafny.Sequence
			_ = _6_name
			_6_name = _dafny.SeqOfString("ConfigTest_")
			var _hi1 _dafny.Int = _dafny.IntOfInt64(6)
			_ = _hi1
			for _7_j := _dafny.Zero; _7_j.Cmp(_hi1) < 0; _7_j = _7_j.Plus(_dafny.One) {
				_6_name = _dafny.Companion_Sequence_.Concatenate(_6_name, (Companion_Default___.CryptoActionStr()).Select(((_0_actions).Select((_7_j).Uint32()).(_dafny.Int)).Uint32()).(_dafny.Sequence))
			}
			var _8_config m_JSON_Values.JSON
			_ = _8_config
			var _out1 m_JSON_Values.JSON
			_ = _out1
			_out1 = Companion_Default___.MakeConfig(_0_actions)
			_8_config = _out1
			var _9_theTest _dafny.Tuple
			_ = _9_theTest
			var _out2 _dafny.Tuple
			_ = _out2
			_out2 = Companion_Default___.MakeConfigTest(_6_name, _8_config, _2_record, m_Wrappers.Companion_Option_.Create_None_())
			_9_theTest = _out2
			_1_result = _dafny.Companion_Sequence_.Concatenate(_1_result, _dafny.SeqOf(_9_theTest))
			_3_actionWrittenOuter = (_3_actionWrittenOuter).Plus(_dafny.One)
			if ((_3_actionWrittenOuter).Modulo(_dafny.IntOfInt64(100))).Sign() == 0 {
				var _10_otherActions _dafny.Sequence
				_ = _10_otherActions
				_10_otherActions = _dafny.SeqOf(_dafny.Zero, _dafny.Zero, _dafny.Zero, _dafny.Zero, _dafny.Zero, _dafny.Zero)
				var _hi2 _dafny.Int = _dafny.IntOfInt64(4096)
				_ = _hi2
				for _11_j := _dafny.Zero; _11_j.Cmp(_hi2) < 0; _11_j = _11_j.Plus(_dafny.One) {
					_10_otherActions = Companion_Default___.Increment(_10_otherActions)
					if Companion_Default___.IsConsistentWith(_0_actions, _10_otherActions) {
						var _12_newConfig m_JSON_Values.JSON
						_ = _12_newConfig
						var _out3 m_JSON_Values.JSON
						_ = _out3
						_out3 = Companion_Default___.MakeConfig(_10_otherActions)
						_12_newConfig = _out3
						var _13_newName _dafny.Sequence
						_ = _13_newName
						_13_newName = _dafny.Companion_Sequence_.Concatenate(_6_name, _dafny.SeqOfString("_"))
						var _hi3 _dafny.Int = _dafny.IntOfInt64(6)
						_ = _hi3
						for _14_k := _dafny.Zero; _14_k.Cmp(_hi3) < 0; _14_k = _14_k.Plus(_dafny.One) {
							_13_newName = _dafny.Companion_Sequence_.Concatenate(_13_newName, (Companion_Default___.CryptoActionStr()).Select(((_10_otherActions).Select((_14_k).Uint32()).(_dafny.Int)).Uint32()).(_dafny.Sequence))
						}
						var _15_newTest _dafny.Tuple
						_ = _15_newTest
						var _out4 _dafny.Tuple
						_ = _out4
						_out4 = Companion_Default___.MakeConfigTest(_13_newName, _8_config, _2_record, m_Wrappers.Companion_Option_.Create_Some_(_12_newConfig))
						_15_newTest = _out4
						_1_result = _dafny.Companion_Sequence_.Concatenate(_1_result, _dafny.SeqOf(_15_newTest))
						_4_actionWrittenInner = (_4_actionWrittenInner).Plus(_dafny.One)
					}
				}
			}
		}
	}
	_dafny.Print((_dafny.SeqOfString("MakeConfigTests : ")).SetString())
	_dafny.Print(_3_actionWrittenOuter)
	_dafny.Print((_dafny.SeqOfString(" outer and ")).SetString())
	_dafny.Print(_4_actionWrittenInner)
	_dafny.Print((_dafny.SeqOfString(" inner for ")).SetString())
	_dafny.Print(_dafny.IntOfUint32((_1_result).Cardinality()))
	_dafny.Print((_dafny.SeqOfString(" total.\n")).SetString())
	output = _1_result
	return output
	return output
}
func (_static *CompanionStruct_Default___) Write(fileName _dafny.Sequence) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
	_ = output
	_dafny.Print((_dafny.SeqOfString("Write : ")).SetString())
	_dafny.Print((fileName).SetString())
	_dafny.Print((_dafny.SeqOfString("\n")).SetString())
	var _0_result _dafny.Sequence
	_ = _0_result
	_0_result = _dafny.SeqOf(Companion_Default___.Manifest(), _dafny.TupleOf(_dafny.SeqOfString("keys"), m_JSON_Values.Companion_JSON_.Create_String_(_dafny.SeqOfString("file://keys.json"))))
	var _1_test1 _dafny.Tuple
	_ = _1_test1
	var _out0 _dafny.Tuple
	_ = _out0
	_out0 = Companion_Default___.MakeTest(_dafny.SeqOfString("1"), _dafny.SeqOfString("positive-encrypt"), _dafny.SeqOfString("Basic encrypt"), Companion_Default___.BasicConfig(), Companion_Default___.BasicRecord(), m_Wrappers.Companion_Option_.Create_None_())
	_1_test1 = _out0
	var _2_test2 _dafny.Tuple
	_ = _2_test2
	var _out1 _dafny.Tuple
	_ = _out1
	_out1 = Companion_Default___.MakeTest(_dafny.SeqOfString("2"), _dafny.SeqOfString("positive-encrypt"), _dafny.SeqOfString("Change ENCRYPT_AND_SIGN to SIGN_ONLY"), Companion_Default___.BasicConfig(), Companion_Default___.BasicRecord(), m_Wrappers.Companion_Option_.Create_Some_(Companion_Default___.SignConfig()))
	_2_test2 = _out1
	var _3_test3 _dafny.Tuple
	_ = _3_test3
	var _out2 _dafny.Tuple
	_ = _out2
	_out2 = Companion_Default___.MakeTest(_dafny.SeqOfString("3"), _dafny.SeqOfString("positive-encrypt"), _dafny.SeqOfString("Change SIGN_ONLY to ENCRYPT_AND_SIGN"), Companion_Default___.SignConfig(), Companion_Default___.BasicRecord(), m_Wrappers.Companion_Option_.Create_Some_(Companion_Default___.BasicConfig()))
	_3_test3 = _out2
	var _4_test4 _dafny.Tuple
	_ = _4_test4
	var _out3 _dafny.Tuple
	_ = _out3
	_out3 = Companion_Default___.MakeTest(_dafny.SeqOfString("4"), _dafny.SeqOfString("negative-decrypt"), _dafny.SeqOfString("Change ENCRYPT_AND_SIGN to DO_NOTHING"), Companion_Default___.BasicConfig(), Companion_Default___.BasicRecord(), m_Wrappers.Companion_Option_.Create_Some_(Companion_Default___.NothingConfig()))
	_4_test4 = _out3
	var _5_test5 _dafny.Tuple
	_ = _5_test5
	var _out4 _dafny.Tuple
	_ = _out4
	_out4 = Companion_Default___.MakeTest(_dafny.SeqOfString("5"), _dafny.SeqOfString("negative-encrypt"), _dafny.SeqOfString("Lacks primary key"), Companion_Default___.BasicConfig(), Companion_Default___.BadRecord(), m_Wrappers.Companion_Option_.Create_None_())
	_5_test5 = _out4
	var _6_test6 _dafny.Tuple
	_ = _6_test6
	var _out5 _dafny.Tuple
	_ = _out5
	_out5 = Companion_Default___.MakeTest(_dafny.SeqOfString("6"), _dafny.SeqOfString("positive-encrypt"), _dafny.SeqOfString("Basic With Sig"), Companion_Default___.BasicConfigSig(), Companion_Default___.BasicRecord(), m_Wrappers.Companion_Option_.Create_None_())
	_6_test6 = _out5
	var _7_test7 _dafny.Tuple
	_ = _7_test7
	var _out6 _dafny.Tuple
	_ = _out6
	_out6 = Companion_Default___.MakeTest(_dafny.SeqOfString("7"), _dafny.SeqOfString("positive-encrypt"), _dafny.SeqOfString("Basic Without Sig"), Companion_Default___.BasicConfigNoSig(), Companion_Default___.BasicRecord(), m_Wrappers.Companion_Option_.Create_None_())
	_7_test7 = _out6
	var _8_test8 _dafny.Tuple
	_ = _8_test8
	var _out7 _dafny.Tuple
	_ = _out7
	_out7 = Companion_Default___.MakeTest(_dafny.SeqOfString("8"), _dafny.SeqOfString("positive-encrypt"), _dafny.SeqOfString("Change Sig to NoSig"), Companion_Default___.BasicConfigSig(), Companion_Default___.BasicRecord(), m_Wrappers.Companion_Option_.Create_Some_(Companion_Default___.BasicConfigNoSig()))
	_8_test8 = _out7
	var _9_test9 _dafny.Tuple
	_ = _9_test9
	var _out8 _dafny.Tuple
	_ = _out8
	_out8 = Companion_Default___.MakeTest(_dafny.SeqOfString("9"), _dafny.SeqOfString("positive-encrypt"), _dafny.SeqOfString("Change NoSig to Sig"), Companion_Default___.BasicConfigNoSig(), Companion_Default___.BasicRecord(), m_Wrappers.Companion_Option_.Create_Some_(Companion_Default___.BasicConfigSig()))
	_9_test9 = _out8
	var _10_test10 _dafny.Tuple
	_ = _10_test10
	var _out9 _dafny.Tuple
	_ = _out9
	_out9 = Companion_Default___.MakeTest(_dafny.SeqOfString("10"), _dafny.SeqOfString("positive-encrypt"), _dafny.SeqOfString("Complex encrypt"), Companion_Default___.MixedConfig(), Companion_Default___.ComplexRecord(), m_Wrappers.Companion_Option_.Create_None_())
	_10_test10 = _out9
	var _11_test11 _dafny.Tuple
	_ = _11_test11
	var _out10 _dafny.Tuple
	_ = _out10
	_out10 = Companion_Default___.MakeTest(_dafny.SeqOfString("11"), _dafny.SeqOfString("positive-encrypt"), _dafny.SeqOfString("Basic encrypt V2"), Companion_Default___.BasicV2Config(), Companion_Default___.BasicRecord(), m_Wrappers.Companion_Option_.Create_None_())
	_11_test11 = _out10
	var _12_test12 _dafny.Tuple
	_ = _12_test12
	var _out11 _dafny.Tuple
	_ = _out11
	_out11 = Companion_Default___.MakeTest(_dafny.SeqOfString("12"), _dafny.SeqOfString("positive-encrypt"), _dafny.SeqOfString("Basic encrypt V2 switching1"), Companion_Default___.LongerV2Config1(), Companion_Default___.BasicRecord(), m_Wrappers.Companion_Option_.Create_Some_(Companion_Default___.LongerV2Config2()))
	_12_test12 = _out11
	var _13_test13 _dafny.Tuple
	_ = _13_test13
	var _out12 _dafny.Tuple
	_ = _out12
	_out12 = Companion_Default___.MakeTest(_dafny.SeqOfString("13"), _dafny.SeqOfString("positive-encrypt"), _dafny.SeqOfString("Basic encrypt V2 switching2"), Companion_Default___.LongerV2Config2(), Companion_Default___.BasicRecord(), m_Wrappers.Companion_Option_.Create_Some_(Companion_Default___.LongerV2Config1()))
	_13_test13 = _out12
	var _14_test14 _dafny.Tuple
	_ = _14_test14
	var _out13 _dafny.Tuple
	_ = _out13
	_out13 = Companion_Default___.MakeTest(_dafny.SeqOfString("14"), _dafny.SeqOfString("positive-encrypt"), _dafny.SeqOfString("Special characters in attribute names"), Companion_Default___.SpecialConfig(), Companion_Default___.SpecialRecord(), m_Wrappers.Companion_Option_.Create_None_())
	_14_test14 = _out13
	var _15_configTests _dafny.Sequence
	_ = _15_configTests
	var _out14 _dafny.Sequence
	_ = _out14
	_out14 = Companion_Default___.MakeConfigTests()
	_15_configTests = _out14
	var _16_tests _dafny.Sequence
	_ = _16_tests
	_16_tests = _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOf(_1_test1, _2_test2, _3_test3, _4_test4, _5_test5, _6_test6, _7_test7, _8_test8, _9_test9, _10_test10, _11_test11, _12_test12, _13_test13, _14_test14), _15_configTests)
	var _17_final m_JSON_Values.JSON
	_ = _17_final
	_17_final = m_JSON_Values.Companion_JSON_.Create_Object_(_dafny.Companion_Sequence_.Concatenate(_0_result, _dafny.SeqOf(_dafny.TupleOf(_dafny.SeqOfString("tests"), m_JSON_Values.Companion_JSON_.Create_Object_(_16_tests)))))
	var _18_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _18_valueOrError0
	_18_valueOrError0 = m_JSON_API.Companion_Default___.Serialize(_17_final)
	if !(!((_18_valueOrError0).IsFailure())) {
		panic("dafny/DDBEncryption/src/WriteManifest.dfy(403,21): " + (_18_valueOrError0).String())
	}
	var _19_jsonBytes _dafny.Sequence
	_ = _19_jsonBytes
	_19_jsonBytes = (_18_valueOrError0).Extract().(_dafny.Sequence)
	var _20_x m_Wrappers.Result
	_ = _20_x
	var _out15 m_Wrappers.Result
	_ = _out15
	_out15 = m_FileIO.Companion_Default___.WriteBytesToFile(fileName, _19_jsonBytes)
	_20_x = _out15
	if !((_20_x).Is_Success()) {
		panic("dafny/DDBEncryption/src/WriteManifest.dfy(405,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(true)
	return output
	return output
}
func (_static *CompanionStruct_Default___) ENCRYPT__TYPE() _dafny.Sequence {
	return _dafny.SeqOfString("aws-dbesdk-encrypt")
}
func (_static *CompanionStruct_Default___) QUOTE() _dafny.Sequence {
	return _dafny.SeqOfString("\"")
}
func (_static *CompanionStruct_Default___) F() _dafny.Sequence {
	return _dafny.SeqOfChars(55360, 56322)
}
func (_static *CompanionStruct_Default___) D() _dafny.Sequence {
	return _dafny.SeqOfChars(55296, 56321)
}
func (_static *CompanionStruct_Default___) Attr1() _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate(Companion_Default___.F(), Companion_Default___.D())
}
func (_static *CompanionStruct_Default___) A() _dafny.Sequence {
	return _dafny.SeqOfString("A")
}
func (_static *CompanionStruct_Default___) B() _dafny.Sequence {
	return _dafny.SeqOfChars(53248)
}
func (_static *CompanionStruct_Default___) C() _dafny.Sequence {
	return _dafny.SeqOfChars(65100)
}
func (_static *CompanionStruct_Default___) Attr2() _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(Companion_Default___.A(), Companion_Default___.B()), Companion_Default___.C()), Companion_Default___.D())
}
func (_static *CompanionStruct_Default___) E() _dafny.Sequence {
	return _dafny.SeqOfChars(55296, 56322)
}
func (_static *CompanionStruct_Default___) Attr3() _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate(Companion_Default___.E(), Companion_Default___.D())
}
func (_static *CompanionStruct_Default___) Attr4() _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate(Companion_Default___.C(), Companion_Default___.D())
}
func (_static *CompanionStruct_Default___) Attr5() _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(Companion_Default___.D(), Companion_Default___.C()), Companion_Default___.B()), Companion_Default___.A())
}
func (_static *CompanionStruct_Default___) ConfigRecord() _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("{\"RecNum\": 1,"), Companion_Default___.QUOTE()), Companion_Default___.Attr1()), Companion_Default___.QUOTE()), _dafny.SeqOfString(": \"aaa\",")), Companion_Default___.QUOTE()), Companion_Default___.Attr2()), Companion_Default___.QUOTE()), _dafny.SeqOfString(": {\"M\" : {\"A\":\"B\", \"C\":\"D\"}},")), Companion_Default___.QUOTE()), Companion_Default___.Attr3()), Companion_Default___.QUOTE()), _dafny.SeqOfString(":  {\"L\" : [{\"M\" : {\"A\":\"B\", \"C\":\"D\"}}, {\"NS\":[\"00.0011\", \"0000\", \"2000.000\", \"10.01\"]}, {\"SS\":[\"00.0011\", \"0000\", \"2000.000\", \"10.01\"]}]},")), Companion_Default___.QUOTE()), Companion_Default___.Attr4()), Companion_Default___.QUOTE()), _dafny.SeqOfString(": {\"SS\":[\"00.0011\", \"0000\", \"2000.000\", \"10.01\"]},")), Companion_Default___.QUOTE()), Companion_Default___.Attr5()), Companion_Default___.QUOTE()), _dafny.SeqOfString(": {\"NS\":[\"00.0011\", \"0000\", \"2000.000\", \"10.01\"]}}"))
}
func (_static *CompanionStruct_Default___) Encrypt() _dafny.Int {
	return _dafny.Zero
}
func (_static *CompanionStruct_Default___) SignOnly() _dafny.Int {
	return _dafny.One
}
func (_static *CompanionStruct_Default___) SignInclude() _dafny.Int {
	return _dafny.IntOfInt64(2)
}
func (_static *CompanionStruct_Default___) DoNothing() _dafny.Int {
	return _dafny.IntOfInt64(3)
}
func (_static *CompanionStruct_Default___) MyAttrNames() _dafny.Sequence {
	return _dafny.SeqOf(_dafny.SeqOfString("RecNum"), Companion_Default___.Attr1(), Companion_Default___.Attr2(), Companion_Default___.Attr3(), Companion_Default___.Attr4(), Companion_Default___.Attr5())
}
func (_static *CompanionStruct_Default___) MyActionNames() _dafny.Sequence {
	return _dafny.SeqOf(_dafny.SeqOfString("ENCRYPT_AND_SIGN"), _dafny.SeqOfString("SIGN_ONLY"), _dafny.SeqOfString("SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT"), _dafny.SeqOfString("DO_NOTHING"))
}
func (_static *CompanionStruct_Default___) CryptoActionStr() _dafny.Sequence {
	return _dafny.SeqOf(_dafny.SeqOfString("0"), _dafny.SeqOfString("1"), _dafny.SeqOfString("2"), _dafny.SeqOfString("3"))
}
func (_static *CompanionStruct_Default___) BasicConfig() _dafny.Sequence {
	return _dafny.SeqOfString("{\n        \"attributeActionsOnEncrypt\": {\n          \"RecNum\": \"SIGN_ONLY\",\n          \"Stuff\": \"ENCRYPT_AND_SIGN\",\n          \"Junk\": \"ENCRYPT_AND_SIGN\"\n        }\n      }")
}
func (_static *CompanionStruct_Default___) BasicRecord() _dafny.Sequence {
	return _dafny.SeqOfString("{\n          \"RecNum\": 1,\n          \"Stuff\": \"StuffData\",\n          \"Junk\": \"JunkData\"\n        }")
}
func (_static *CompanionStruct_Default___) SignConfig() _dafny.Sequence {
	return _dafny.SeqOfString("{\n        \"attributeActionsOnEncrypt\": {\n          \"RecNum\": \"SIGN_ONLY\",\n          \"Stuff\": \"SIGN_ONLY\",\n          \"Junk\": \"SIGN_ONLY\"\n        }\n      }")
}
func (_static *CompanionStruct_Default___) NothingConfig() _dafny.Sequence {
	return _dafny.SeqOfString("{\n        \"attributeActionsOnEncrypt\": {\n          \"RecNum\": \"SIGN_ONLY\",\n          \"Stuff\": \"DO_NOTHING\",\n          \"Junk\": \"DO_NOTHING\"\n        },\n        \"allowedUnsignedAttributes\" : [\"Stuff\", \"Junk\"]\n      }")
}
func (_static *CompanionStruct_Default___) BadRecord() _dafny.Sequence {
	return _dafny.SeqOfString("{\n          \"Stuff\": \"StuffData\",\n          \"Junk\": \"JunkData\"\n        }")
}
func (_static *CompanionStruct_Default___) BasicConfigSig() _dafny.Sequence {
	return _dafny.SeqOfString("{\n        \"attributeActionsOnEncrypt\": {\n          \"RecNum\": \"SIGN_ONLY\",\n          \"Stuff\": \"ENCRYPT_AND_SIGN\",\n          \"Junk\": \"ENCRYPT_AND_SIGN\"\n        },\n        \"algorithmSuiteId\" : \"ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384\"\n      }")
}
func (_static *CompanionStruct_Default___) BasicConfigNoSig() _dafny.Sequence {
	return _dafny.SeqOfString("{\n        \"attributeActionsOnEncrypt\": {\n          \"RecNum\": \"SIGN_ONLY\",\n          \"Stuff\": \"ENCRYPT_AND_SIGN\",\n          \"Junk\": \"ENCRYPT_AND_SIGN\"\n        },\n        \"algorithmSuiteId\" : \"ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384\"\n      }")
}
func (_static *CompanionStruct_Default___) MixedConfig() _dafny.Sequence {
	return _dafny.SeqOfString("{\n        \"attributeActionsOnEncrypt\": {\n          \"RecNum\": \"SIGN_ONLY\",\n          \"Stuff\": \"SIGN_ONLY\",\n          \"Junk\": \"ENCRYPT_AND_SIGN\"\n        }\n      }")
}
func (_static *CompanionStruct_Default___) ComplexRecord() _dafny.Sequence {
	return _dafny.SeqOfString("{\n          \"RecNum\": 1,\n          \"Stuff\": {\"L\" : [{\"M\" : {\"A\":\"B\", \"C\":\"D\"}}, {\"NS\":[\"00.0011\", \"0000\", \"2000.000\", \"10.01\"]}, {\"SS\":[\"00.0011\", \"0000\", \"2000.000\", \"10.01\"]}]},\n          \"Junk\": {\"L\" : [{\"M\" : {\"A\":\"B\", \"C\":\"D\"}}, {\"NS\":[\"00.0011\", \"0000\", \"2000.000\", \"10.01\"]}, {\"SS\":[\"00.0011\", \"0000\", \"2000.000\", \"10.01\"]}]}\n        }")
}
func (_static *CompanionStruct_Default___) BasicV2Config() _dafny.Sequence {
	return _dafny.SeqOfString("{\n        \"attributeActionsOnEncrypt\": {\n          \"RecNum\": \"SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT\",\n          \"Stuff\": \"ENCRYPT_AND_SIGN\",\n          \"Junk\": \"ENCRYPT_AND_SIGN\"\n        }\n      }")
}
func (_static *CompanionStruct_Default___) LongerV2Config1() _dafny.Sequence {
	return _dafny.SeqOfString("{\n        \"attributeActionsOnEncrypt\": {\n          \"RecNum\": \"SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT\",\n          \"Stuff\": \"ENCRYPT_AND_SIGN\",\n          \"Junk\": \"SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT\",\n          \"Thing2\": \"ENCRYPT_AND_SIGN\",\n          \"Thing3\": \"ENCRYPT_AND_SIGN\"\n        }\n      }")
}
func (_static *CompanionStruct_Default___) LongerV2Config2() _dafny.Sequence {
	return _dafny.SeqOfString("{\n        \"attributeActionsOnEncrypt\": {\n          \"RecNum\": \"SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT\",\n          \"Stuff\": \"SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT\",\n          \"Junk\": \"ENCRYPT_AND_SIGN\",\n          \"Thing2\": \"ENCRYPT_AND_SIGN\",\n          \"Thing3\": \"ENCRYPT_AND_SIGN\"\n        }\n      }")
}
func (_static *CompanionStruct_Default___) SpecialConfig() _dafny.Sequence {
	return _dafny.SeqOfString("{\n        \"attributeActionsOnEncrypt\": {\n          \"RecNum\": \"SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT\",\n          \"a.b\": \"SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT\",\n          \"a[2]\": \"SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT\",\n          \"a#b\": \"SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT\",\n          \"'a'\": \"SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT\",\n          \"'a\": \"SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT\",\n          \"a'\": \"SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT\",\n          \"'a.b'\": \"SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT\",\n          \"$'a'\": \"SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT\",\n          \"$.a\": \"SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT\",\n          \"$.[a]\": \"SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT\",\n          \"$.['a']\": \"SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT\",\n          \"$.['a\": \"SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT\",\n          \"\\\"a\\\"\": \"SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT\",\n          \"\\\"a\": \"SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT\",\n          \"a\\\"\": \"SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT\",\n          \"\\\"a.b\\\"\": \"SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT\",\n          \"$\\\"a\\\"\": \"SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT\",\n          \"$.a\": \"SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT\",\n          \"$.[a]\": \"SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT\",\n          \"$.[\\\"a\\\"]\": \"SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT\",\n          \"$.[\\\"a\": \"SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT\"\n        }\n      }")
}
func (_static *CompanionStruct_Default___) SpecialRecord() _dafny.Sequence {
	return _dafny.SeqOfString("{\n          \"RecNum\": 1,\n          \"a.b\": \"aaa\",\n          \"a[2]\": \"bbb\",\n          \"a#b\": \"ccc\",\n          \"'a'\": \"ddd\",\n          \"'a\": \"eee\",\n          \"a'\": \"fff\",\n          \"'a.b'\": \"ggg\",\n          \"$'a'\": \"hhh\",\n          \"$.a\": \"iii\",\n          \"$.[a]\": \"jjj\",\n          \"$.['a']\": \"kkk\",\n          \"$.['a\": \"lll\",\n          \"\\\"a\\\"\": \"mmm\",\n          \"\\\"a\": \"nnn\",\n          \"a\\\"\": \"ooo\",\n          \"\\\"a.b\\\"\": \"ppp\",\n          \"$\\\"a\\\"\": \"qqq\",\n          \"$.a\": \"rrr\",\n          \"$.[a]\": \"sss\",\n          \"$.[\\\"a\\\"]\": \"ttt\",\n          \"$.[\\\"a\": \"uuu\"\n        }")
}
func (_static *CompanionStruct_Default___) DECRYPT__TYPE() _dafny.Sequence {
	return _dafny.SeqOfString("aws-dbesdk-decrypt")
}
func (_static *CompanionStruct_Default___) LIB__PREFIX() _dafny.Sequence {
	return _dafny.SeqOfString("aws/aws-dbesdk-")
}

// End of class Default__

// Definition of class CryptoAction
type CryptoAction struct {
}

func New_CryptoAction_() *CryptoAction {
	_this := CryptoAction{}

	return &_this
}

type CompanionStruct_CryptoAction_ struct {
}

var Companion_CryptoAction_ = CompanionStruct_CryptoAction_{}

func (*CryptoAction) String() string {
	return "WriteManifest.CryptoAction"
}

// End of class CryptoAction

func Type_CryptoAction_() _dafny.TypeDescriptor {
	return type_CryptoAction_{}
}

type type_CryptoAction_ struct {
}

func (_this type_CryptoAction_) Default() interface{} {
	return _dafny.Zero
}

func (_this type_CryptoAction_) String() string {
	return "WriteManifest.CryptoAction"
}
func (_this *CompanionStruct_CryptoAction_) Is_(__source _dafny.Int) bool {
	var _0_x _dafny.Int = (__source)
	_ = _0_x
	return ((_0_x).Sign() != -1) && ((_0_x).Cmp(_dafny.IntOfInt64(4)) < 0)
}

// Definition of class CryptoActions
type CryptoActions struct {
}

func New_CryptoActions_() *CryptoActions {
	_this := CryptoActions{}

	return &_this
}

type CompanionStruct_CryptoActions_ struct {
}

var Companion_CryptoActions_ = CompanionStruct_CryptoActions_{}

func (*CryptoActions) String() string {
	return "WriteManifest.CryptoActions"
}
func (_this *CompanionStruct_CryptoActions_) Witness() _dafny.Sequence {
	return _dafny.SeqOf(_dafny.Zero, _dafny.Zero, _dafny.Zero, _dafny.Zero, _dafny.Zero, _dafny.Zero)
}

// End of class CryptoActions

func Type_CryptoActions_() _dafny.TypeDescriptor {
	return type_CryptoActions_{}
}

type type_CryptoActions_ struct {
}

func (_this type_CryptoActions_) Default() interface{} {
	return Companion_CryptoActions_.Witness()
}

func (_this type_CryptoActions_) String() string {
	return "WriteManifest.CryptoActions"
}
func (_this *CompanionStruct_CryptoActions_) Is_(__source _dafny.Sequence) bool {
	var _1_x _dafny.Sequence = (__source)
	_ = _1_x
	return (_dafny.IntOfUint32((_1_x).Cardinality())).Cmp(_dafny.IntOfInt64(6)) == 0
}
