// Package DecryptManifest
// Dafny module DecryptManifest compiled into Go

package DecryptManifest

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
	m__Time "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Time_"
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
	m_EncryptManifest "github.com/aws/aws-database-encryption-sdk-dynamodb/testvectors/EncryptManifest"
	m_JsonConfig "github.com/aws/aws-database-encryption-sdk-dynamodb/testvectors/JsonConfig"
	m_WrappedItemEncryptor "github.com/aws/aws-database-encryption-sdk-dynamodb/testvectors/WrappedItemEncryptor"
	m_WriteManifest "github.com/aws/aws-database-encryption-sdk-dynamodb/testvectors/WriteManifest"
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
var _ m_WriteManifest.Dummy__
var _ m_EncryptManifest.Dummy__

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
	return "DecryptManifest.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) OnePositiveTest(name _dafny.Sequence, config m_JSON_Values.JSON, encrypted m_JSON_Values.JSON, plaintext m_JSON_Values.JSON, keys *m_KeyVectors.KeyVectorsClient) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
	_ = output
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_JsonConfig.Companion_Record_.Default())
	_ = _0_valueOrError0
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_JsonConfig.Companion_Default___.GetRecord(encrypted)
	_0_valueOrError0 = _out0
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_enc m_JsonConfig.Record
	_ = _1_enc
	_1_enc = (_0_valueOrError0).Extract().(m_JsonConfig.Record)
	var _2_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_JsonConfig.Companion_Record_.Default())
	_ = _2_valueOrError1
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_JsonConfig.Companion_Default___.GetRecord(plaintext)
	_2_valueOrError1 = _out1
	if (_2_valueOrError1).IsFailure() {
		output = (_2_valueOrError1).PropagateFailure()
		return output
	}
	var _3_plain m_JsonConfig.Record
	_ = _3_plain
	_3_plain = (_2_valueOrError1).Extract().(m_JsonConfig.Record)
	var _4_valueOrError2 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _4_valueOrError2
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_JsonConfig.Companion_Default___.GetItemEncryptor(name, config, keys)
	_4_valueOrError2 = _out2
	if (_4_valueOrError2).IsFailure() {
		output = (_4_valueOrError2).PropagateFailure()
		return output
	}
	var _5_encryptor m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.IDynamoDbItemEncryptorClient
	_ = _5_encryptor
	_5_encryptor = m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_IDynamoDbItemEncryptorClient_.CastTo_((_4_valueOrError2).Extract())
	var _6_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_DecryptItemOutput_.Default())
	_ = _6_valueOrError3
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = (_5_encryptor).DecryptItem(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_DecryptItemInput_.Create_DecryptItemInput_((_1_enc).Dtor_item()))
	_6_valueOrError3 = _out3
	if !(!((_6_valueOrError3).IsFailure())) {
		panic("dafny/DDBEncryption/src/DecryptManifest.dfy(35,21): " + (_6_valueOrError3).String())
	}
	var _7_decrypted m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DecryptItemOutput
	_ = _7_decrypted
	_7_decrypted = (_6_valueOrError3).Extract().(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DecryptItemOutput)
	if !((m_DdbItemJson.Companion_Default___.NormalizeItem((_7_decrypted).Dtor_plaintextItem())).Equals(m_DdbItemJson.Companion_Default___.NormalizeItem((_3_plain).Dtor_item()))) {
		panic("dafny/DDBEncryption/src/DecryptManifest.dfy(40,4): " + (_dafny.SeqOfString("expectation violation")).String())
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(true)
	return output
	return output
}
func (_static *CompanionStruct_Default___) OneNegativeTest(name _dafny.Sequence, config m_JSON_Values.JSON, encrypted m_JSON_Values.JSON, keys *m_KeyVectors.KeyVectorsClient) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
	_ = output
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_JsonConfig.Companion_Record_.Default())
	_ = _0_valueOrError0
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_JsonConfig.Companion_Default___.GetRecord(encrypted)
	_0_valueOrError0 = _out0
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_enc m_JsonConfig.Record
	_ = _1_enc
	_1_enc = (_0_valueOrError0).Extract().(m_JsonConfig.Record)
	var _2_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _2_valueOrError1
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_JsonConfig.Companion_Default___.GetItemEncryptor(name, config, keys)
	_2_valueOrError1 = _out1
	if (_2_valueOrError1).IsFailure() {
		output = (_2_valueOrError1).PropagateFailure()
		return output
	}
	var _3_encryptor m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.IDynamoDbItemEncryptorClient
	_ = _3_encryptor
	_3_encryptor = m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_IDynamoDbItemEncryptorClient_.CastTo_((_2_valueOrError1).Extract())
	var _4_decrypted m_Wrappers.Result
	_ = _4_decrypted
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = (_3_encryptor).DecryptItem(m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.Companion_DecryptItemInput_.Create_DecryptItemInput_((_1_enc).Dtor_item()))
	_4_decrypted = _out2
	if (_4_decrypted).Is_Success() {
		output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Failed to fail to decrypt "), name))
		return output
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(true)
	return output
	return output
}
func (_static *CompanionStruct_Default___) OneTest(name _dafny.Sequence, value m_JSON_Values.JSON, keys *m_KeyVectors.KeyVectorsClient) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((value).Is_Object(), _dafny.SeqOfString("Test must be an object"))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_types m_Wrappers.Option
	_ = _1_types
	_1_types = m_Wrappers.Companion_Option_.Create_None_()
	var _2_description m_Wrappers.Option
	_ = _2_description
	_2_description = m_Wrappers.Companion_Option_.Create_None_()
	var _3_config m_Wrappers.Option
	_ = _3_config
	_3_config = m_Wrappers.Companion_Option_.Create_None_()
	var _4_encrypted m_Wrappers.Option
	_ = _4_encrypted
	_4_encrypted = m_Wrappers.Companion_Option_.Create_None_()
	var _5_plaintext m_Wrappers.Option
	_ = _5_plaintext
	_5_plaintext = m_Wrappers.Companion_Option_.Create_None_()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((value).Dtor_obj()).Cardinality())
	_ = _hi0
	for _6_i := _dafny.Zero; _6_i.Cmp(_hi0) < 0; _6_i = _6_i.Plus(_dafny.One) {
		var _7_obj _dafny.Tuple
		_ = _7_obj
		_7_obj = ((value).Dtor_obj()).Select((_6_i).Uint32()).(_dafny.Tuple)
		var _source0 _dafny.Sequence = (*(_7_obj).IndexInt(0)).(_dafny.Sequence)
		_ = _source0
		{
			{
				if (_source0).Equals(_dafny.SeqOfString("type")) {
					var _8_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _8_valueOrError1
					_8_valueOrError1 = m_Wrappers.Companion_Default___.Need(((*(_7_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("Value of 'type' must be a string."))
					if (_8_valueOrError1).IsFailure() {
						output = (_8_valueOrError1).PropagateFailure()
						return output
					}
					_1_types = m_Wrappers.Companion_Option_.Create_Some_(((*(_7_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str())
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("description")) {
					var _9_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _9_valueOrError2
					_9_valueOrError2 = m_Wrappers.Companion_Default___.Need(((*(_7_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("Value of 'description' must be a string."))
					if (_9_valueOrError2).IsFailure() {
						output = (_9_valueOrError2).PropagateFailure()
						return output
					}
					_2_description = m_Wrappers.Companion_Option_.Create_Some_(((*(_7_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str())
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("config")) {
					var _10_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _10_valueOrError3
					_10_valueOrError3 = m_Wrappers.Companion_Default___.Need(((*(_7_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_Object(), _dafny.SeqOfString("Value of 'config' must be an object."))
					if (_10_valueOrError3).IsFailure() {
						output = (_10_valueOrError3).PropagateFailure()
						return output
					}
					_3_config = m_Wrappers.Companion_Option_.Create_Some_((*(_7_obj).IndexInt(1)).(m_JSON_Values.JSON))
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("encrypted")) {
					var _11_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _11_valueOrError4
					_11_valueOrError4 = m_Wrappers.Companion_Default___.Need(((*(_7_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_Object(), _dafny.SeqOfString("Value of 'record' must be an object."))
					if (_11_valueOrError4).IsFailure() {
						output = (_11_valueOrError4).PropagateFailure()
						return output
					}
					_4_encrypted = m_Wrappers.Companion_Option_.Create_Some_((*(_7_obj).IndexInt(1)).(m_JSON_Values.JSON))
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("plaintext")) {
					var _12_valueOrError5 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _12_valueOrError5
					_12_valueOrError5 = m_Wrappers.Companion_Default___.Need(((*(_7_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_Object(), _dafny.SeqOfString("Value of 'record' must be an object."))
					if (_12_valueOrError5).IsFailure() {
						output = (_12_valueOrError5).PropagateFailure()
						return output
					}
					_5_plaintext = m_Wrappers.Companion_Option_.Create_Some_((*(_7_obj).IndexInt(1)).(m_JSON_Values.JSON))
					goto Lmatch0
				}
			}
			{
				output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Unknown test member : "), (*(_7_obj).IndexInt(0)).(_dafny.Sequence)), _dafny.SeqOfString(" in ")), name))
				return output
			}
			goto Lmatch0
		}
	Lmatch0:
	}
	var _13_valueOrError6 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _13_valueOrError6
	_13_valueOrError6 = m_Wrappers.Companion_Default___.Need((_1_types).Is_Some(), _dafny.SeqOfString("Test requires a 'type' member."))
	if (_13_valueOrError6).IsFailure() {
		output = (_13_valueOrError6).PropagateFailure()
		return output
	}
	var _14_valueOrError7 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _14_valueOrError7
	_14_valueOrError7 = m_Wrappers.Companion_Default___.Need((_2_description).Is_Some(), _dafny.SeqOfString("Test requires a 'description' member."))
	if (_14_valueOrError7).IsFailure() {
		output = (_14_valueOrError7).PropagateFailure()
		return output
	}
	var _15_valueOrError8 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _15_valueOrError8
	_15_valueOrError8 = m_Wrappers.Companion_Default___.Need((_3_config).Is_Some(), _dafny.SeqOfString("Test requires a 'config' member."))
	if (_15_valueOrError8).IsFailure() {
		output = (_15_valueOrError8).PropagateFailure()
		return output
	}
	var _16_valueOrError9 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _16_valueOrError9
	_16_valueOrError9 = m_Wrappers.Companion_Default___.Need((_4_encrypted).Is_Some(), _dafny.SeqOfString("Test requires a 'encrypted' member."))
	if (_16_valueOrError9).IsFailure() {
		output = (_16_valueOrError9).PropagateFailure()
		return output
	}
	if _dafny.Companion_Sequence_.Equal((_1_types).Dtor_value().(_dafny.Sequence), _dafny.SeqOfString("positive-decrypt")) {
		var _17_valueOrError10 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _17_valueOrError10
		_17_valueOrError10 = m_Wrappers.Companion_Default___.Need((_5_plaintext).Is_Some(), _dafny.SeqOfString("positive-decrypt Test requires a 'plaintext' member."))
		if (_17_valueOrError10).IsFailure() {
			output = (_17_valueOrError10).PropagateFailure()
			return output
		}
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = Companion_Default___.OnePositiveTest(name, (_3_config).Dtor_value().(m_JSON_Values.JSON), (_4_encrypted).Dtor_value().(m_JSON_Values.JSON), (_5_plaintext).Dtor_value().(m_JSON_Values.JSON), keys)
		output = _out0
	} else if _dafny.Companion_Sequence_.Equal((_1_types).Dtor_value().(_dafny.Sequence), _dafny.SeqOfString("negative-decrypt")) {
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = Companion_Default___.OneNegativeTest(name, (_3_config).Dtor_value().(m_JSON_Values.JSON), (_4_encrypted).Dtor_value().(m_JSON_Values.JSON), keys)
		output = _out1
	} else {
		output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Invalid encrypt type : '"), (_1_types).Dtor_value().(_dafny.Sequence)), _dafny.SeqOfString("'.")))
		return output
	}
	return output
}
func (_static *CompanionStruct_Default___) LogFileName() m_Wrappers.Option {
	return m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfString("../../PerfLog.txt"))
}
func (_static *CompanionStruct_Default___) Decrypt(inFile _dafny.Sequence, keyVectors *m_KeyVectors.KeyVectorsClient) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
	_ = output
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
	_ = _0_valueOrError0
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m__Time.GetCurrentTimeStamp()
	_0_valueOrError0 = _out0
	if !(!((_0_valueOrError0).IsFailure())) {
		panic("dafny/DDBEncryption/src/DecryptManifest.dfy(125,21): " + (_0_valueOrError0).String())
	}
	var _1_timeStamp _dafny.Sequence
	_ = _1_timeStamp
	_1_timeStamp = (_0_valueOrError0).Extract().(_dafny.Sequence)
	_dafny.Print((_dafny.Companion_Sequence_.Concatenate(_1_timeStamp, _dafny.SeqOfString(" Decrypt : "))).SetString())
	_dafny.Print((inFile).SetString())
	_dafny.Print((_dafny.SeqOfString("\n")).SetString())
	var _2_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _2_valueOrError1
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_FileIO.Companion_Default___.ReadBytesFromFile(inFile)
	_2_valueOrError1 = _out1
	if !(!((_2_valueOrError1).IsFailure())) {
		panic("dafny/DDBEncryption/src/DecryptManifest.dfy(127,23): " + (_2_valueOrError1).String())
	}
	var _3_configBytes _dafny.Sequence
	_ = _3_configBytes
	_3_configBytes = (_2_valueOrError1).Extract().(_dafny.Sequence)
	var _4_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
	_ = _4_valueOrError2
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m__Time.GetCurrentTimeStamp()
	_4_valueOrError2 = _out2
	if !(!((_4_valueOrError2).IsFailure())) {
		panic("dafny/DDBEncryption/src/DecryptManifest.dfy(128,17): " + (_4_valueOrError2).String())
	}
	_1_timeStamp = (_4_valueOrError2).Extract().(_dafny.Sequence)
	_dafny.Print((_dafny.Companion_Sequence_.Concatenate(_1_timeStamp, _dafny.SeqOfString(" File Read.\n"))).SetString())
	var _5_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_JSON_Values.Companion_JSON_.Default())
	_ = _5_valueOrError3
	_5_valueOrError3 = m_JSON_API.Companion_Default___.Deserialize(_3_configBytes)
	if !(!((_5_valueOrError3).IsFailure())) {
		panic("dafny/DDBEncryption/src/DecryptManifest.dfy(130,16): " + (_5_valueOrError3).String())
	}
	var _6_json m_JSON_Values.JSON
	_ = _6_json
	_6_json = (_5_valueOrError3).Extract().(m_JSON_Values.JSON)
	var _7_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
	_ = _7_valueOrError4
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m__Time.GetCurrentTimeStamp()
	_7_valueOrError4 = _out3
	if !(!((_7_valueOrError4).IsFailure())) {
		panic("dafny/DDBEncryption/src/DecryptManifest.dfy(131,17): " + (_7_valueOrError4).String())
	}
	_1_timeStamp = (_7_valueOrError4).Extract().(_dafny.Sequence)
	_dafny.Print((_dafny.Companion_Sequence_.Concatenate(_1_timeStamp, _dafny.SeqOfString(" JSON Parsed.\n"))).SetString())
	var _8_valueOrError5 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _8_valueOrError5
	_8_valueOrError5 = m_Wrappers.Companion_Default___.Need((_6_json).Is_Object(), _dafny.SeqOfString("Decrypt file must contain a JSON object."))
	if (_8_valueOrError5).IsFailure() {
		output = (_8_valueOrError5).PropagateFailure()
		return output
	}
	var _9_keys m_Wrappers.Option
	_ = _9_keys
	_9_keys = m_Wrappers.Companion_Option_.Create_None_()
	var _10_client m_Wrappers.Option
	_ = _10_client
	_10_client = m_Wrappers.Companion_Option_.Create_None_()
	var _11_manifest m_Wrappers.Option
	_ = _11_manifest
	_11_manifest = m_Wrappers.Companion_Option_.Create_None_()
	var _12_tests m_Wrappers.Option
	_ = _12_tests
	_12_tests = m_Wrappers.Companion_Option_.Create_None_()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((_6_json).Dtor_obj()).Cardinality())
	_ = _hi0
	for _13_i := _dafny.Zero; _13_i.Cmp(_hi0) < 0; _13_i = _13_i.Plus(_dafny.One) {
		var _14_obj _dafny.Tuple
		_ = _14_obj
		_14_obj = ((_6_json).Dtor_obj()).Select((_13_i).Uint32()).(_dafny.Tuple)
		var _source0 _dafny.Sequence = (*(_14_obj).IndexInt(0)).(_dafny.Sequence)
		_ = _source0
		{
			{
				if (_source0).Equals(_dafny.SeqOfString("keys")) {
					var _15_valueOrError6 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _15_valueOrError6
					_15_valueOrError6 = m_Wrappers.Companion_Default___.Need(((*(_14_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("Value of 'keys' must be a string."))
					if (_15_valueOrError6).IsFailure() {
						output = (_15_valueOrError6).PropagateFailure()
						return output
					}
					_9_keys = m_Wrappers.Companion_Option_.Create_Some_(((*(_14_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str())
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("client")) {
					var _16_valueOrError7 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _16_valueOrError7
					_16_valueOrError7 = m_Wrappers.Companion_Default___.Need(((*(_14_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_Object(), _dafny.SeqOfString("Value of 'client' must be an Object."))
					if (_16_valueOrError7).IsFailure() {
						output = (_16_valueOrError7).PropagateFailure()
						return output
					}
					_10_client = m_Wrappers.Companion_Option_.Create_Some_(((*(_14_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_obj())
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("manifest")) {
					var _17_valueOrError8 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _17_valueOrError8
					_17_valueOrError8 = m_Wrappers.Companion_Default___.Need(((*(_14_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_Object(), _dafny.SeqOfString("Value of 'manifest' must be an object."))
					if (_17_valueOrError8).IsFailure() {
						output = (_17_valueOrError8).PropagateFailure()
						return output
					}
					_11_manifest = m_Wrappers.Companion_Option_.Create_Some_(((*(_14_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_obj())
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("tests")) {
					var _18_valueOrError9 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _18_valueOrError9
					_18_valueOrError9 = m_Wrappers.Companion_Default___.Need(((*(_14_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_Object(), _dafny.SeqOfString("Value of 'tests' must be an object."))
					if (_18_valueOrError9).IsFailure() {
						output = (_18_valueOrError9).PropagateFailure()
						return output
					}
					_12_tests = m_Wrappers.Companion_Option_.Create_Some_(((*(_14_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_obj())
					goto Lmatch0
				}
			}
			{
				output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Unknown top level encrypt tag : "), (*(_14_obj).IndexInt(0)).(_dafny.Sequence)))
				return output
			}
			goto Lmatch0
		}
	Lmatch0:
	}
	var _19_valueOrError10 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _19_valueOrError10
	_19_valueOrError10 = m_Wrappers.Companion_Default___.Need((_9_keys).Is_Some(), _dafny.SeqOfString("Decrypt manifest requires a 'keys' member."))
	if (_19_valueOrError10).IsFailure() {
		output = (_19_valueOrError10).PropagateFailure()
		return output
	}
	var _20_valueOrError11 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _20_valueOrError11
	_20_valueOrError11 = m_Wrappers.Companion_Default___.Need((_10_client).Is_Some(), _dafny.SeqOfString("Decrypt manifest requires a 'client' member."))
	if (_20_valueOrError11).IsFailure() {
		output = (_20_valueOrError11).PropagateFailure()
		return output
	}
	var _21_valueOrError12 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _21_valueOrError12
	_21_valueOrError12 = m_Wrappers.Companion_Default___.Need((_11_manifest).Is_Some(), _dafny.SeqOfString("Decrypt manifest requires a 'manifest' member."))
	if (_21_valueOrError12).IsFailure() {
		output = (_21_valueOrError12).PropagateFailure()
		return output
	}
	var _22_valueOrError13 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _22_valueOrError13
	_22_valueOrError13 = m_Wrappers.Companion_Default___.Need((_12_tests).Is_Some(), _dafny.SeqOfString("Decrypt manifest requires a 'tests' member."))
	if (_22_valueOrError13).IsFailure() {
		output = (_22_valueOrError13).PropagateFailure()
		return output
	}
	var _hi1 _dafny.Int = _dafny.IntOfUint32(((_11_manifest).Dtor_value().(_dafny.Sequence)).Cardinality())
	_ = _hi1
	for _23_i := _dafny.Zero; _23_i.Cmp(_hi1) < 0; _23_i = _23_i.Plus(_dafny.One) {
		var _24_obj _dafny.Tuple
		_ = _24_obj
		_24_obj = ((_11_manifest).Dtor_value().(_dafny.Sequence)).Select((_23_i).Uint32()).(_dafny.Tuple)
		var _source1 _dafny.Sequence = (*(_24_obj).IndexInt(0)).(_dafny.Sequence)
		_ = _source1
		{
			{
				if (_source1).Equals(_dafny.SeqOfString("type")) {
					var _25_valueOrError14 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _25_valueOrError14
					_25_valueOrError14 = m_Wrappers.Companion_Default___.Need(((*(_24_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("Value of 'type' must be a string."))
					if (_25_valueOrError14).IsFailure() {
						output = (_25_valueOrError14).PropagateFailure()
						return output
					}
					var _26_valueOrError15 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _26_valueOrError15
					_26_valueOrError15 = m_Wrappers.Companion_Default___.Need(_dafny.Companion_Sequence_.Equal(((*(_24_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str(), m_WriteManifest.Companion_Default___.DECRYPT__TYPE()), _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Value of 'type' must be '"), m_WriteManifest.Companion_Default___.DECRYPT__TYPE()), _dafny.SeqOfString("'.")))
					if (_26_valueOrError15).IsFailure() {
						output = (_26_valueOrError15).PropagateFailure()
						return output
					}
					goto Lmatch1
				}
			}
			{
				if (_source1).Equals(_dafny.SeqOfString("version")) {
					var _27_valueOrError16 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _27_valueOrError16
					_27_valueOrError16 = m_Wrappers.Companion_Default___.Need(((*(_24_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("Value of 'version' must be a string."))
					if (_27_valueOrError16).IsFailure() {
						output = (_27_valueOrError16).PropagateFailure()
						return output
					}
					var _28_valueOrError17 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _28_valueOrError17
					_28_valueOrError17 = m_Wrappers.Companion_Default___.Need(_dafny.Companion_Sequence_.Equal(((*(_24_obj).IndexInt(1)).(m_JSON_Values.JSON)).Dtor_str(), _dafny.SeqOfString("1")), _dafny.SeqOfString("Value of 'version' must be '1'"))
					if (_28_valueOrError17).IsFailure() {
						output = (_28_valueOrError17).PropagateFailure()
						return output
					}
					goto Lmatch1
				}
			}
			{
				output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Unknown manifest member : "), (*(_24_obj).IndexInt(0)).(_dafny.Sequence)))
				return output
			}
			goto Lmatch1
		}
	Lmatch1:
	}
	var _29_time m__Time.AbsoluteTime
	_ = _29_time
	var _out4 m__Time.AbsoluteTime
	_ = _out4
	_out4 = m__Time.Companion_Default___.GetAbsoluteTime()
	_29_time = _out4
	var _hi2 _dafny.Int = _dafny.IntOfUint32(((_12_tests).Dtor_value().(_dafny.Sequence)).Cardinality())
	_ = _hi2
	for _30_i := _dafny.Zero; _30_i.Cmp(_hi2) < 0; _30_i = _30_i.Plus(_dafny.One) {
		var _31_obj _dafny.Tuple
		_ = _31_obj
		_31_obj = ((_12_tests).Dtor_value().(_dafny.Sequence)).Select((_30_i).Uint32()).(_dafny.Tuple)
		var _32_valueOrError18 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _32_valueOrError18
		_32_valueOrError18 = m_Wrappers.Companion_Default___.Need(((*(_31_obj).IndexInt(1)).(m_JSON_Values.JSON)).Is_Object(), _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Value of test '"), (*(_31_obj).IndexInt(0)).(_dafny.Sequence)), _dafny.SeqOfString("' must be an Object.")))
		if (_32_valueOrError18).IsFailure() {
			output = (_32_valueOrError18).PropagateFailure()
			return output
		}
		var _33_valueOrError19 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
		_ = _33_valueOrError19
		var _out5 m_Wrappers.Result
		_ = _out5
		_out5 = Companion_Default___.OneTest((*(_31_obj).IndexInt(0)).(_dafny.Sequence), (*(_31_obj).IndexInt(1)).(m_JSON_Values.JSON), keyVectors)
		_33_valueOrError19 = _out5
		if (_33_valueOrError19).IsFailure() {
			output = (_33_valueOrError19).PropagateFailure()
			return output
		}
		var _34___v3 bool
		_ = _34___v3
		_34___v3 = (_33_valueOrError19).Extract().(bool)
	}
	m__Time.Companion_Default___.PrintTimeSinceLong(_29_time, _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("DB-ESDK-TV-Decrypt-"), inFile), Companion_Default___.LogFileName())
	var _35_valueOrError20 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
	_ = _35_valueOrError20
	var _out6 m_Wrappers.Result
	_ = _out6
	_out6 = m__Time.GetCurrentTimeStamp()
	_35_valueOrError20 = _out6
	if !(!((_35_valueOrError20).IsFailure())) {
		panic("dafny/DDBEncryption/src/DecryptManifest.dfy(184,17): " + (_35_valueOrError20).String())
	}
	_1_timeStamp = (_35_valueOrError20).Extract().(_dafny.Sequence)
	_dafny.Print((_dafny.Companion_Sequence_.Concatenate(_1_timeStamp, _dafny.SeqOfString(" Tests Complete.\n"))).SetString())
	output = m_Wrappers.Companion_Result_.Create_Success_(true)
	return output
	return output
}

// End of class Default__
