// Package DdbItemJson
// Dafny module DdbItemJson compiled into Go

package DdbItemJson

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
	m_SortedSets "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/SortedSets"
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
	return "DdbItemJson.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) IsDecimalDigit(ch _dafny.Char) bool {
	return ((_dafny.Char('0')) <= (ch)) && ((ch) <= (_dafny.Char('9')))
}
func (_static *CompanionStruct_Default___) StrToNat(s _dafny.Sequence, acc _dafny.Int) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((s).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(acc)
	} else if Companion_Default___.IsDecimalDigit((s).Select(0).(_dafny.Char)) {
		var _in0 _dafny.Sequence = (s).Drop(1)
		_ = _in0
		var _in1 _dafny.Int = (((acc).Times(_dafny.IntOfInt64(10))).Plus(_dafny.IntOfInt32(rune((s).Select(0).(_dafny.Char))))).Minus(_dafny.IntOfInt32(rune(_dafny.Char('0'))))
		_ = _in1
		s = _in0
		acc = _in1
		goto TAIL_CALL_START
	} else {
		return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("The character '"), (s).Take(1)), _dafny.SeqOfString("' is not a valid decimal digit.")))
	}
}
func (_static *CompanionStruct_Default___) StrToInt(s _dafny.Sequence) m_Wrappers.Result {
	if (_dafny.IntOfUint32((s).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("An empty string is not a valid number."))
	} else if ((s).Select(0).(_dafny.Char)) == (_dafny.Char('-')) {
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((_dafny.One).Cmp(_dafny.IntOfUint32((s).Cardinality())) < 0, _dafny.SeqOfString("An empty string is not a valid number."))
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_valueOrError1 m_Wrappers.Result = Companion_Default___.StrToNat((s).Drop(1), _dafny.Zero)
			_ = _1_valueOrError1
			if (_1_valueOrError1).IsFailure() {
				return (_1_valueOrError1).PropagateFailure()
			} else {
				var _2_x _dafny.Int = (_1_valueOrError1).Extract().(_dafny.Int)
				_ = _2_x
				return m_Wrappers.Companion_Result_.Create_Success_((_dafny.Zero).Minus(_2_x))
			}
		}
	} else if ((s).Select(0).(_dafny.Char)) == (_dafny.Char('+')) {
		var _3_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((_dafny.One).Cmp(_dafny.IntOfUint32((s).Cardinality())) < 0, _dafny.SeqOfString("An empty string is not a valid number."))
		_ = _3_valueOrError2
		if (_3_valueOrError2).IsFailure() {
			return (_3_valueOrError2).PropagateFailure()
		} else {
			return Companion_Default___.StrToNat((s).Drop(1), _dafny.Zero)
		}
	} else {
		return Companion_Default___.StrToNat(s, _dafny.Zero)
	}
}
func (_static *CompanionStruct_Default___) Zeros(n _dafny.Int) _dafny.Sequence {
	return _dafny.SeqCreate((n).Uint32(), func(coer0 func(_dafny.Int) _dafny.Char) func(_dafny.Int) interface{} {
		return func(arg0 _dafny.Int) interface{} {
			return coer0(arg0)
		}
	}(func(_0_i _dafny.Int) _dafny.Char {
		return _dafny.Char('0')
	})).SetString()
}
func (_static *CompanionStruct_Default___) SkipLeadingZeros(val _dafny.Sequence) _dafny.Sequence {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (((_dafny.One).Cmp(_dafny.IntOfUint32((val).Cardinality())) < 0) && (((val).Select(0).(_dafny.Char)) == (_dafny.Char('0')))) && (((val).Select(1).(_dafny.Char)) != (_dafny.Char('.')) /* dircomp */) {
		var _in0 _dafny.Sequence = (val).Drop(1)
		_ = _in0
		val = _in0
		goto TAIL_CALL_START
	} else {
		return val
	}
}
func (_static *CompanionStruct_Default___) SkipTrailingZeros(val _dafny.Sequence) _dafny.Sequence {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if ((_dafny.IntOfUint32((val).Cardinality())).Sign() == 1) && (((val).Select(((_dafny.IntOfUint32((val).Cardinality())).Minus(_dafny.One)).Uint32()).(_dafny.Char)) == (_dafny.Char('0'))) {
		var _in0 _dafny.Sequence = (val).Take(((_dafny.IntOfUint32((val).Cardinality())).Minus(_dafny.One)).Uint32())
		_ = _in0
		val = _in0
		goto TAIL_CALL_START
	} else {
		return val
	}
}
func (_static *CompanionStruct_Default___) Pow10(val _dafny.Int, exp _dafny.Int) _dafny.Int {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (exp).Sign() == 0 {
		return val
	} else {
		var _in0 _dafny.Int = (val).Times(_dafny.IntOfInt64(10))
		_ = _in0
		var _in1 _dafny.Int = (exp).Minus(_dafny.One)
		_ = _in1
		val = _in0
		exp = _in1
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) DigitsToDecimal(num _dafny.Sequence, sign _dafny.Int, exp _dafny.Int) m_Wrappers.Result {
	if (_dafny.IntOfUint32((num).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(m_JSON_Values.Companion_Decimal_.Create_Decimal_(sign, exp))
	} else if _dafny.Companion_Sequence_.Contains(num, _dafny.Char('.')) {
		var _let_tmp_rhs0 _dafny.Tuple = m_StandardLibrary.Companion_Default___.SplitOnce(num, _dafny.Char('.'))
		_ = _let_tmp_rhs0
		var _0_pre _dafny.Sequence = (*(_let_tmp_rhs0).IndexInt(0)).(_dafny.Sequence)
		_ = _0_pre
		var _1_post _dafny.Sequence = (*(_let_tmp_rhs0).IndexInt(1)).(_dafny.Sequence)
		_ = _1_post
		var _2_pre _dafny.Sequence = Companion_Default___.SkipLeadingZeros(_0_pre)
		_ = _2_pre
		var _3_post _dafny.Sequence = Companion_Default___.SkipTrailingZeros(_1_post)
		_ = _3_post
		var _4_valueOrError0 m_Wrappers.Result = Companion_Default___.StrToInt(num)
		_ = _4_valueOrError0
		if (_4_valueOrError0).IsFailure() {
			return (_4_valueOrError0).PropagateFailure()
		} else {
			var _5_val _dafny.Int = (_4_valueOrError0).Extract().(_dafny.Int)
			_ = _5_val
			if (_dafny.IntOfUint32((_3_post).Cardinality())).Sign() == 0 {
				return m_Wrappers.Companion_Result_.Create_Success_(m_JSON_Values.Companion_Decimal_.Create_Decimal_((sign).Times(_5_val), exp))
			} else if (_dafny.IntOfUint32((_2_pre).Cardinality())).Sign() == 0 {
				var _6_valueOrError1 m_Wrappers.Result = Companion_Default___.StrToInt(_3_post)
				_ = _6_valueOrError1
				if (_6_valueOrError1).IsFailure() {
					return (_6_valueOrError1).PropagateFailure()
				} else {
					var _7_val _dafny.Int = (_6_valueOrError1).Extract().(_dafny.Int)
					_ = _7_val
					return m_Wrappers.Companion_Result_.Create_Success_(m_JSON_Values.Companion_Decimal_.Create_Decimal_((sign).Times(_7_val), (exp).Minus(_dafny.IntOfUint32((_3_post).Cardinality()))))
				}
			} else {
				var _8_exp _dafny.Int = (exp).Minus(_dafny.IntOfUint32((_3_post).Cardinality()))
				_ = _8_exp
				var _9_val _dafny.Int = Companion_Default___.Pow10(_5_val, _dafny.IntOfUint32((_3_post).Cardinality()))
				_ = _9_val
				var _10_valueOrError2 m_Wrappers.Result = Companion_Default___.StrToInt(_3_post)
				_ = _10_valueOrError2
				if (_10_valueOrError2).IsFailure() {
					return (_10_valueOrError2).PropagateFailure()
				} else {
					var _11_frac _dafny.Int = (_10_valueOrError2).Extract().(_dafny.Int)
					_ = _11_frac
					return m_Wrappers.Companion_Result_.Create_Success_(m_JSON_Values.Companion_Decimal_.Create_Decimal_(((sign).Times(_9_val)).Plus(_11_frac), _8_exp))
				}
			}
		}
	} else {
		var _12_valueOrError3 m_Wrappers.Result = Companion_Default___.StrToInt(num)
		_ = _12_valueOrError3
		if (_12_valueOrError3).IsFailure() {
			return (_12_valueOrError3).PropagateFailure()
		} else {
			var _13_val _dafny.Int = (_12_valueOrError3).Extract().(_dafny.Int)
			_ = _13_val
			return m_Wrappers.Companion_Result_.Create_Success_(m_JSON_Values.Companion_Decimal_.Create_Decimal_((sign).Times(_13_val), exp))
		}
	}
}
func (_static *CompanionStruct_Default___) StringToDecimalUnsigned(num _dafny.Sequence, sign _dafny.Int) m_Wrappers.Result {
	if (_dafny.IntOfUint32((num).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("An empty string is not a number"))
	} else if _dafny.Companion_Sequence_.Contains(num, _dafny.Char('e')) {
		var _let_tmp_rhs0 _dafny.Tuple = m_StandardLibrary.Companion_Default___.SplitOnce(num, _dafny.Char('e'))
		_ = _let_tmp_rhs0
		var _0_digits _dafny.Sequence = (*(_let_tmp_rhs0).IndexInt(0)).(_dafny.Sequence)
		_ = _0_digits
		var _1_exp _dafny.Sequence = (*(_let_tmp_rhs0).IndexInt(1)).(_dafny.Sequence)
		_ = _1_exp
		var _2_valueOrError0 m_Wrappers.Result = Companion_Default___.StrToInt(_1_exp)
		_ = _2_valueOrError0
		if (_2_valueOrError0).IsFailure() {
			return (_2_valueOrError0).PropagateFailure()
		} else {
			var _3_expInt _dafny.Int = (_2_valueOrError0).Extract().(_dafny.Int)
			_ = _3_expInt
			return Companion_Default___.DigitsToDecimal(_0_digits, sign, _3_expInt)
		}
	} else if _dafny.Companion_Sequence_.Contains(num, _dafny.Char('E')) {
		var _let_tmp_rhs1 _dafny.Tuple = m_StandardLibrary.Companion_Default___.SplitOnce(num, _dafny.Char('E'))
		_ = _let_tmp_rhs1
		var _4_digits _dafny.Sequence = (*(_let_tmp_rhs1).IndexInt(0)).(_dafny.Sequence)
		_ = _4_digits
		var _5_exp _dafny.Sequence = (*(_let_tmp_rhs1).IndexInt(1)).(_dafny.Sequence)
		_ = _5_exp
		var _6_valueOrError1 m_Wrappers.Result = Companion_Default___.StrToInt(_5_exp)
		_ = _6_valueOrError1
		if (_6_valueOrError1).IsFailure() {
			return (_6_valueOrError1).PropagateFailure()
		} else {
			var _7_expInt _dafny.Int = (_6_valueOrError1).Extract().(_dafny.Int)
			_ = _7_expInt
			return Companion_Default___.DigitsToDecimal(_4_digits, sign, _7_expInt)
		}
	} else {
		return Companion_Default___.DigitsToDecimal(num, sign, _dafny.Zero)
	}
}
func (_static *CompanionStruct_Default___) StringToDecimal(num _dafny.Sequence) m_Wrappers.Result {
	if (_dafny.IntOfUint32((num).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("An empty string is not a number"))
	} else if ((num).Select(0).(_dafny.Char)) == (_dafny.Char('+')) {
		return Companion_Default___.StringToDecimalUnsigned((num).Drop(1), _dafny.One)
	} else if ((num).Select(0).(_dafny.Char)) == (_dafny.Char('-')) {
		return Companion_Default___.StringToDecimalUnsigned((num).Drop(1), _dafny.IntOfInt64(-1))
	} else if Companion_Default___.IsDecimalDigit((num).Select(0).(_dafny.Char)) {
		return Companion_Default___.StringToDecimalUnsigned(num, _dafny.One)
	} else {
		return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Invalid character in number : "), num))
	}
}
func (_static *CompanionStruct_Default___) BinaryToString(data _dafny.Sequence) _dafny.Sequence {
	return m_Base64.Companion_Default___.Encode(data)
}
func (_static *CompanionStruct_Default___) StringToBinary(str _dafny.Sequence) m_Wrappers.Result {
	return m_Base64.Companion_Default___.Decode(str)
}
func (_static *CompanionStruct_Default___) DdbStringType(s _dafny.Sequence) m_JSON_Values.JSON {
	return m_JSON_Values.Companion_JSON_.Create_Object_(_dafny.SeqOf(_dafny.TupleOf(_dafny.SeqOfString("S"), m_JSON_Values.Companion_JSON_.Create_String_(s))))
}
func (_static *CompanionStruct_Default___) DdbNumberType(s _dafny.Sequence) m_JSON_Values.JSON {
	return m_JSON_Values.Companion_JSON_.Create_Object_(_dafny.SeqOf(_dafny.TupleOf(_dafny.SeqOfString("N"), m_JSON_Values.Companion_JSON_.Create_String_(s))))
}
func (_static *CompanionStruct_Default___) DdbBinaryType(b _dafny.Sequence) m_JSON_Values.JSON {
	return m_JSON_Values.Companion_JSON_.Create_Object_(_dafny.SeqOf(_dafny.TupleOf(_dafny.SeqOfString("B"), m_JSON_Values.Companion_JSON_.Create_String_(Companion_Default___.BinaryToString(b)))))
}
func (_static *CompanionStruct_Default___) DdbMapType(b _dafny.Sequence) m_JSON_Values.JSON {
	return m_JSON_Values.Companion_JSON_.Create_Object_(_dafny.SeqOf(_dafny.TupleOf(_dafny.SeqOfString("M"), m_JSON_Values.Companion_JSON_.Create_Object_(b))))
}
func (_static *CompanionStruct_Default___) DdbListType(b _dafny.Sequence) m_JSON_Values.JSON {
	return m_JSON_Values.Companion_JSON_.Create_Object_(_dafny.SeqOf(_dafny.TupleOf(_dafny.SeqOfString("L"), m_JSON_Values.Companion_JSON_.Create_Array_(b))))
}
func (_static *CompanionStruct_Default___) DdbBoolType(b bool) m_JSON_Values.JSON {
	return m_JSON_Values.Companion_JSON_.Create_Object_(_dafny.SeqOf(_dafny.TupleOf(_dafny.SeqOfString("BOOL"), m_JSON_Values.Companion_JSON_.Create_Bool_(b))))
}
func (_static *CompanionStruct_Default___) DdbNullType() m_JSON_Values.JSON {
	return m_JSON_Values.Companion_JSON_.Create_Object_(_dafny.SeqOf(_dafny.TupleOf(_dafny.SeqOfString("NULL"), m_JSON_Values.Companion_JSON_.Create_Bool_(true))))
}
func (_static *CompanionStruct_Default___) DdbStringSetType(s _dafny.Sequence) m_JSON_Values.JSON {
	return m_JSON_Values.Companion_JSON_.Create_Object_(_dafny.SeqOf(_dafny.TupleOf(_dafny.SeqOfString("SS"), m_JSON_Values.Companion_JSON_.Create_Array_(s))))
}
func (_static *CompanionStruct_Default___) DdbNumberSetType(s _dafny.Sequence) m_JSON_Values.JSON {
	return m_JSON_Values.Companion_JSON_.Create_Object_(_dafny.SeqOf(_dafny.TupleOf(_dafny.SeqOfString("NS"), m_JSON_Values.Companion_JSON_.Create_Array_(s))))
}
func (_static *CompanionStruct_Default___) DdbBinarySetType(s _dafny.Sequence) m_JSON_Values.JSON {
	return m_JSON_Values.Companion_JSON_.Create_Object_(_dafny.SeqOf(_dafny.TupleOf(_dafny.SeqOfString("BS"), m_JSON_Values.Companion_JSON_.Create_Array_(s))))
}
func (_static *CompanionStruct_Default___) DdbValueToJson(item m_ComAmazonawsDynamodbTypes.AttributeValue) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_JSON_Values.Companion_JSON_.Default())
	_ = output
	var _source0 m_ComAmazonawsDynamodbTypes.AttributeValue = item
	_ = _source0
	{
		{
			if _source0.Is_S() {
				var _0_s _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_S).S
				_ = _0_s
				output = m_Wrappers.Companion_Result_.Create_Success_(Companion_Default___.DdbStringType(_0_s))
				return output
				goto Lmatch0
			}
		}
		{
			if _source0.Is_N() {
				var _1_n _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_N).N
				_ = _1_n
				output = m_Wrappers.Companion_Result_.Create_Success_(Companion_Default___.DdbNumberType(_1_n))
				return output
				goto Lmatch0
			}
		}
		{
			if _source0.Is_B() {
				var _2_b _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_B).B
				_ = _2_b
				output = m_Wrappers.Companion_Result_.Create_Success_(Companion_Default___.DdbBinaryType(_2_b))
				return output
				goto Lmatch0
			}
		}
		{
			if _source0.Is_SS() {
				var _3_ss _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_SS).SS
				_ = _3_ss
				var _4_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
				_ = _4_valueOrError0
				var _out0 m_Wrappers.Result
				_ = _out0
				_out0 = Companion_Default___.DdbStringSetToJson(_3_ss)
				_4_valueOrError0 = _out0
				if (_4_valueOrError0).IsFailure() {
					output = (_4_valueOrError0).PropagateFailure()
					return output
				}
				var _5_x _dafny.Sequence
				_ = _5_x
				_5_x = (_4_valueOrError0).Extract().(_dafny.Sequence)
				output = m_Wrappers.Companion_Result_.Create_Success_(Companion_Default___.DdbStringSetType(_5_x))
				return output
				goto Lmatch0
			}
		}
		{
			if _source0.Is_NS() {
				var _6_ss _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_NS).NS
				_ = _6_ss
				var _7_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
				_ = _7_valueOrError1
				var _out1 m_Wrappers.Result
				_ = _out1
				_out1 = Companion_Default___.DdbStringSetToJson(_6_ss)
				_7_valueOrError1 = _out1
				if (_7_valueOrError1).IsFailure() {
					output = (_7_valueOrError1).PropagateFailure()
					return output
				}
				var _8_x _dafny.Sequence
				_ = _8_x
				_8_x = (_7_valueOrError1).Extract().(_dafny.Sequence)
				output = m_Wrappers.Companion_Result_.Create_Success_(Companion_Default___.DdbNumberSetType(_8_x))
				return output
				goto Lmatch0
			}
		}
		{
			if _source0.Is_BS() {
				var _9_ss _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_BS).BS
				_ = _9_ss
				var _10_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
				_ = _10_valueOrError2
				var _out2 m_Wrappers.Result
				_ = _out2
				_out2 = Companion_Default___.DdbBinarySetToJson(_9_ss)
				_10_valueOrError2 = _out2
				if (_10_valueOrError2).IsFailure() {
					output = (_10_valueOrError2).PropagateFailure()
					return output
				}
				var _11_x _dafny.Sequence
				_ = _11_x
				_11_x = (_10_valueOrError2).Extract().(_dafny.Sequence)
				output = m_Wrappers.Companion_Result_.Create_Success_(Companion_Default___.DdbBinarySetType(_11_x))
				return output
				goto Lmatch0
			}
		}
		{
			if _source0.Is_M() {
				var _12_m _dafny.Map = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_M).M
				_ = _12_m
				var _13_keys _dafny.Sequence
				_ = _13_keys
				var _out3 _dafny.Sequence
				_ = _out3
				_out3 = m_SortedSets.SetToSequence((_12_m).Keys())
				_13_keys = _out3
				var _14_result _dafny.Sequence
				_ = _14_result
				_14_result = _dafny.SeqOf()
				var _hi0 _dafny.Int = _dafny.IntOfUint32((_13_keys).Cardinality())
				_ = _hi0
				for _15_i := _dafny.Zero; _15_i.Cmp(_hi0) < 0; _15_i = _15_i.Plus(_dafny.One) {
					var _16_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_JSON_Values.Companion_JSON_.Default())
					_ = _16_valueOrError3
					var _out4 m_Wrappers.Result
					_ = _out4
					_out4 = Companion_Default___.DdbValueToJson((_12_m).Get((_13_keys).Select((_15_i).Uint32()).(_dafny.Sequence)).(m_ComAmazonawsDynamodbTypes.AttributeValue))
					_16_valueOrError3 = _out4
					if (_16_valueOrError3).IsFailure() {
						output = (_16_valueOrError3).PropagateFailure()
						return output
					}
					var _17_json m_JSON_Values.JSON
					_ = _17_json
					_17_json = (_16_valueOrError3).Extract().(m_JSON_Values.JSON)
					_14_result = _dafny.Companion_Sequence_.Concatenate(_14_result, _dafny.SeqOf(_dafny.TupleOf((_13_keys).Select((_15_i).Uint32()).(_dafny.Sequence), _17_json)))
				}
				output = m_Wrappers.Companion_Result_.Create_Success_(Companion_Default___.DdbMapType(_14_result))
				return output
				goto Lmatch0
			}
		}
		{
			if _source0.Is_L() {
				var _18_l _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_L).L
				_ = _18_l
				var _19_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
				_ = _19_valueOrError4
				var _out5 m_Wrappers.Result
				_ = _out5
				_out5 = Companion_Default___.DdbListToJson(_18_l)
				_19_valueOrError4 = _out5
				if (_19_valueOrError4).IsFailure() {
					output = (_19_valueOrError4).PropagateFailure()
					return output
				}
				var _20_x _dafny.Sequence
				_ = _20_x
				_20_x = (_19_valueOrError4).Extract().(_dafny.Sequence)
				output = m_Wrappers.Companion_Result_.Create_Success_(Companion_Default___.DdbListType(_20_x))
				goto Lmatch0
			}
		}
		{
			if _source0.Is_NULL() {
				var _21_n bool = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_NULL).NULL
				_ = _21_n
				output = m_Wrappers.Companion_Result_.Create_Success_(Companion_Default___.DdbNullType())
				return output
				goto Lmatch0
			}
		}
		{
			var _22_b bool = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_BOOL).BOOL
			_ = _22_b
			output = m_Wrappers.Companion_Result_.Create_Success_(Companion_Default___.DdbBoolType(_22_b))
			return output
		}
		goto Lmatch0
	}
Lmatch0:
	return output
}
func (_static *CompanionStruct_Default___) DdbListToJson(list _dafny.Sequence) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _0_result _dafny.Sequence
	_ = _0_result
	_0_result = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32((list).Cardinality())
	_ = _hi0
	for _1_i := _dafny.Zero; _1_i.Cmp(_hi0) < 0; _1_i = _1_i.Plus(_dafny.One) {
		var _2_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_JSON_Values.Companion_JSON_.Default())
		_ = _2_valueOrError0
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = Companion_Default___.DdbValueToJson((list).Select((_1_i).Uint32()).(m_ComAmazonawsDynamodbTypes.AttributeValue))
		_2_valueOrError0 = _out0
		if (_2_valueOrError0).IsFailure() {
			output = (_2_valueOrError0).PropagateFailure()
			return output
		}
		var _3_val m_JSON_Values.JSON
		_ = _3_val
		_3_val = (_2_valueOrError0).Extract().(m_JSON_Values.JSON)
		_0_result = _dafny.Companion_Sequence_.Concatenate(_0_result, _dafny.SeqOf(_3_val))
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(_0_result)
	return output
	return output
}
func (_static *CompanionStruct_Default___) DdbStringSetToJson(list _dafny.Sequence) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _0_result _dafny.Sequence
	_ = _0_result
	_0_result = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32((list).Cardinality())
	_ = _hi0
	for _1_i := _dafny.Zero; _1_i.Cmp(_hi0) < 0; _1_i = _1_i.Plus(_dafny.One) {
		_0_result = _dafny.Companion_Sequence_.Concatenate(_0_result, _dafny.SeqOf(m_JSON_Values.Companion_JSON_.Create_String_((list).Select((_1_i).Uint32()).(_dafny.Sequence))))
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(_0_result)
	return output
	return output
}
func (_static *CompanionStruct_Default___) DdbBinarySetToJson(list _dafny.Sequence) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _0_result _dafny.Sequence
	_ = _0_result
	_0_result = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32((list).Cardinality())
	_ = _hi0
	for _1_i := _dafny.Zero; _1_i.Cmp(_hi0) < 0; _1_i = _1_i.Plus(_dafny.One) {
		_0_result = _dafny.Companion_Sequence_.Concatenate(_0_result, _dafny.SeqOf(m_JSON_Values.Companion_JSON_.Create_String_(Companion_Default___.BinaryToString((list).Select((_1_i).Uint32()).(_dafny.Sequence)))))
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(_0_result)
	return output
	return output
}
func (_static *CompanionStruct_Default___) DdbItemToJson(item _dafny.Map) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_JSON_Values.Companion_JSON_.Default())
	_ = output
	var _0_keys _dafny.Sequence
	_ = _0_keys
	var _out0 _dafny.Sequence
	_ = _out0
	_out0 = m_SortedSets.SetToSequence((item).Keys())
	_0_keys = _out0
	var _1_result _dafny.Sequence
	_ = _1_result
	_1_result = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32((_0_keys).Cardinality())
	_ = _hi0
	for _2_i := _dafny.Zero; _2_i.Cmp(_hi0) < 0; _2_i = _2_i.Plus(_dafny.One) {
		var _3_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_JSON_Values.Companion_JSON_.Default())
		_ = _3_valueOrError0
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = Companion_Default___.DdbValueToJson((item).Get((_0_keys).Select((_2_i).Uint32()).(_dafny.Sequence)).(m_ComAmazonawsDynamodbTypes.AttributeValue))
		_3_valueOrError0 = _out1
		if (_3_valueOrError0).IsFailure() {
			output = (_3_valueOrError0).PropagateFailure()
			return output
		}
		var _4_json m_JSON_Values.JSON
		_ = _4_json
		_4_json = (_3_valueOrError0).Extract().(m_JSON_Values.JSON)
		_1_result = _dafny.Companion_Sequence_.Concatenate(_1_result, _dafny.SeqOf(_dafny.TupleOf((_0_keys).Select((_2_i).Uint32()).(_dafny.Sequence), _4_json)))
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(m_JSON_Values.Companion_JSON_.Create_Object_(_1_result))
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetAttrValue(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Default())
	_ = output
	if (data).Is_String() {
		output = m_Wrappers.Companion_Result_.Create_Success_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_((data).Dtor_str()))
		return output
	} else if (data).Is_Number() {
		var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
		_ = _0_valueOrError0
		_0_valueOrError0 = Companion_Default___.DecimalToStr((data).Dtor_num())
		if (_0_valueOrError0).IsFailure() {
			output = (_0_valueOrError0).PropagateFailure()
			return output
		}
		var _1_n _dafny.Sequence
		_ = _1_n
		_1_n = (_0_valueOrError0).Extract().(_dafny.Sequence)
		output = m_Wrappers.Companion_Result_.Create_Success_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_N_(_1_n))
		return output
	} else if (data).Is_Object() {
		var _2_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _2_valueOrError1
		_2_valueOrError1 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32(((data).Dtor_obj()).Cardinality())).Cmp(_dafny.One) == 0, _dafny.SeqOfString("Attribute Value Objects must contain only one thing."))
		if (_2_valueOrError1).IsFailure() {
			output = (_2_valueOrError1).PropagateFailure()
			return output
		}
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = Companion_Default___.GetAttrValueObj((*(((data).Dtor_obj()).Select(0).(_dafny.Tuple)).IndexInt(0)).(_dafny.Sequence), (*(((data).Dtor_obj()).Select(0).(_dafny.Tuple)).IndexInt(1)).(m_JSON_Values.JSON))
		output = _out0
	} else {
		output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Attribute Value must be a string or an object."))
		return output
	}
	return output
}
func (_static *CompanionStruct_Default___) GetAttrValueObj(typeStr _dafny.Sequence, data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Default())
	_ = output
	var _source0 _dafny.Sequence = typeStr
	_ = _source0
	{
		{
			if (_source0).Equals(_dafny.SeqOfString("S")) {
				var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
				_ = _0_valueOrError0
				_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_String(), _dafny.SeqOfString("Value for 'S' must be a string"))
				if (_0_valueOrError0).IsFailure() {
					output = (_0_valueOrError0).PropagateFailure()
					return output
				}
				output = m_Wrappers.Companion_Result_.Create_Success_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_((data).Dtor_str()))
				return output
				goto Lmatch0
			}
		}
		{
			if (_source0).Equals(_dafny.SeqOfString("SS")) {
				var _1_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
				_ = _1_valueOrError1
				_1_valueOrError1 = m_Wrappers.Companion_Default___.Need((data).Is_Array(), _dafny.SeqOfString("Value for 'SS' must be a Array"))
				if (_1_valueOrError1).IsFailure() {
					output = (_1_valueOrError1).PropagateFailure()
					return output
				}
				var _2_result _dafny.Sequence
				_ = _2_result
				_2_result = _dafny.SeqOf()
				var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_arr()).Cardinality())
				_ = _hi0
				for _3_i := _dafny.Zero; _3_i.Cmp(_hi0) < 0; _3_i = _3_i.Plus(_dafny.One) {
					var _4_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _4_valueOrError2
					_4_valueOrError2 = m_Wrappers.Companion_Default___.Need((((data).Dtor_arr()).Select((_3_i).Uint32()).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("Values for 'SS' must be Strings"))
					if (_4_valueOrError2).IsFailure() {
						output = (_4_valueOrError2).PropagateFailure()
						return output
					}
					_2_result = _dafny.Companion_Sequence_.Concatenate(_2_result, _dafny.SeqOf((((data).Dtor_arr()).Select((_3_i).Uint32()).(m_JSON_Values.JSON)).Dtor_str()))
				}
				output = m_Wrappers.Companion_Result_.Create_Success_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_SS_(_2_result))
				return output
				goto Lmatch0
			}
		}
		{
			if (_source0).Equals(_dafny.SeqOfString("N")) {
				var _5_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
				_ = _5_valueOrError3
				_5_valueOrError3 = m_Wrappers.Companion_Default___.Need((data).Is_String(), _dafny.SeqOfString("Value for 'S' must be a string"))
				if (_5_valueOrError3).IsFailure() {
					output = (_5_valueOrError3).PropagateFailure()
					return output
				}
				output = m_Wrappers.Companion_Result_.Create_Success_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_N_((data).Dtor_str()))
				return output
				goto Lmatch0
			}
		}
		{
			if (_source0).Equals(_dafny.SeqOfString("NS")) {
				var _6_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
				_ = _6_valueOrError4
				_6_valueOrError4 = m_Wrappers.Companion_Default___.Need((data).Is_Array(), _dafny.SeqOfString("Value for 'NS' must be a Array"))
				if (_6_valueOrError4).IsFailure() {
					output = (_6_valueOrError4).PropagateFailure()
					return output
				}
				var _7_result _dafny.Sequence
				_ = _7_result
				_7_result = _dafny.SeqOf()
				var _hi1 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_arr()).Cardinality())
				_ = _hi1
				for _8_i := _dafny.Zero; _8_i.Cmp(_hi1) < 0; _8_i = _8_i.Plus(_dafny.One) {
					if (((data).Dtor_arr()).Select((_8_i).Uint32()).(m_JSON_Values.JSON)).Is_String() {
						_7_result = _dafny.Companion_Sequence_.Concatenate(_7_result, _dafny.SeqOf((((data).Dtor_arr()).Select((_8_i).Uint32()).(m_JSON_Values.JSON)).Dtor_str()))
					} else if (((data).Dtor_arr()).Select((_8_i).Uint32()).(m_JSON_Values.JSON)).Is_Number() {
						var _9_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
						_ = _9_valueOrError5
						_9_valueOrError5 = Companion_Default___.DecimalToStr((((data).Dtor_arr()).Select((_8_i).Uint32()).(m_JSON_Values.JSON)).Dtor_num())
						if (_9_valueOrError5).IsFailure() {
							output = (_9_valueOrError5).PropagateFailure()
							return output
						}
						var _10_val _dafny.Sequence
						_ = _10_val
						_10_val = (_9_valueOrError5).Extract().(_dafny.Sequence)
						_7_result = _dafny.Companion_Sequence_.Concatenate(_7_result, _dafny.SeqOf(_10_val))
					} else {
						output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Values for 'NS' must be Strings or Numbers"))
						return output
					}
				}
				output = m_Wrappers.Companion_Result_.Create_Success_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_NS_(_7_result))
				return output
				goto Lmatch0
			}
		}
		{
			if (_source0).Equals(_dafny.SeqOfString("B")) {
				var _11_valueOrError6 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
				_ = _11_valueOrError6
				_11_valueOrError6 = m_Wrappers.Companion_Default___.Need((data).Is_String(), _dafny.SeqOfString("Value for 'B' must be a string"))
				if (_11_valueOrError6).IsFailure() {
					output = (_11_valueOrError6).PropagateFailure()
					return output
				}
				var _12_valueOrError7 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
				_ = _12_valueOrError7
				_12_valueOrError7 = Companion_Default___.StringToBinary((data).Dtor_str())
				if (_12_valueOrError7).IsFailure() {
					output = (_12_valueOrError7).PropagateFailure()
					return output
				}
				var _13_val _dafny.Sequence
				_ = _13_val
				_13_val = (_12_valueOrError7).Extract().(_dafny.Sequence)
				output = m_Wrappers.Companion_Result_.Create_Success_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_B_(_13_val))
				return output
				goto Lmatch0
			}
		}
		{
			if (_source0).Equals(_dafny.SeqOfString("BS")) {
				var _14_valueOrError8 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
				_ = _14_valueOrError8
				_14_valueOrError8 = m_Wrappers.Companion_Default___.Need((data).Is_Array(), _dafny.SeqOfString("Value for 'BS' must be a Array"))
				if (_14_valueOrError8).IsFailure() {
					output = (_14_valueOrError8).PropagateFailure()
					return output
				}
				var _15_result _dafny.Sequence
				_ = _15_result
				_15_result = _dafny.SeqOf()
				var _hi2 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_arr()).Cardinality())
				_ = _hi2
				for _16_i := _dafny.Zero; _16_i.Cmp(_hi2) < 0; _16_i = _16_i.Plus(_dafny.One) {
					var _17_valueOrError9 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _17_valueOrError9
					_17_valueOrError9 = m_Wrappers.Companion_Default___.Need((((data).Dtor_arr()).Select((_16_i).Uint32()).(m_JSON_Values.JSON)).Is_String(), _dafny.SeqOfString("Values for 'BS' must be Strings"))
					if (_17_valueOrError9).IsFailure() {
						output = (_17_valueOrError9).PropagateFailure()
						return output
					}
					var _18_valueOrError10 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _18_valueOrError10
					_18_valueOrError10 = Companion_Default___.StringToBinary((((data).Dtor_arr()).Select((_16_i).Uint32()).(m_JSON_Values.JSON)).Dtor_str())
					if (_18_valueOrError10).IsFailure() {
						output = (_18_valueOrError10).PropagateFailure()
						return output
					}
					var _19_val _dafny.Sequence
					_ = _19_val
					_19_val = (_18_valueOrError10).Extract().(_dafny.Sequence)
					_15_result = _dafny.Companion_Sequence_.Concatenate(_15_result, _dafny.SeqOf(_19_val))
				}
				output = m_Wrappers.Companion_Result_.Create_Success_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_BS_(_15_result))
				return output
				goto Lmatch0
			}
		}
		{
			if (_source0).Equals(_dafny.SeqOfString("L")) {
				var _20_valueOrError11 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
				_ = _20_valueOrError11
				_20_valueOrError11 = m_Wrappers.Companion_Default___.Need((data).Is_Array(), _dafny.SeqOfString("Value for 'L' must be a Array"))
				if (_20_valueOrError11).IsFailure() {
					output = (_20_valueOrError11).PropagateFailure()
					return output
				}
				var _21_result _dafny.Sequence
				_ = _21_result
				_21_result = _dafny.SeqOf()
				var _hi3 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_arr()).Cardinality())
				_ = _hi3
				for _22_i := _dafny.Zero; _22_i.Cmp(_hi3) < 0; _22_i = _22_i.Plus(_dafny.One) {
					var _23_valueOrError12 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Default())
					_ = _23_valueOrError12
					var _out0 m_Wrappers.Result
					_ = _out0
					_out0 = Companion_Default___.GetAttrValue(((data).Dtor_arr()).Select((_22_i).Uint32()).(m_JSON_Values.JSON))
					_23_valueOrError12 = _out0
					if (_23_valueOrError12).IsFailure() {
						output = (_23_valueOrError12).PropagateFailure()
						return output
					}
					var _24_val m_ComAmazonawsDynamodbTypes.AttributeValue
					_ = _24_val
					_24_val = (_23_valueOrError12).Extract().(m_ComAmazonawsDynamodbTypes.AttributeValue)
					_21_result = _dafny.Companion_Sequence_.Concatenate(_21_result, _dafny.SeqOf(_24_val))
				}
				output = m_Wrappers.Companion_Result_.Create_Success_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_L_(_21_result))
				return output
				goto Lmatch0
			}
		}
		{
			if (_source0).Equals(_dafny.SeqOfString("M")) {
				var _25_valueOrError13 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
				_ = _25_valueOrError13
				_25_valueOrError13 = m_Wrappers.Companion_Default___.Need((data).Is_Object(), _dafny.SeqOfString("Value for 'M' must be an Object"))
				if (_25_valueOrError13).IsFailure() {
					output = (_25_valueOrError13).PropagateFailure()
					return output
				}
				var _26_result _dafny.Map
				_ = _26_result
				_26_result = _dafny.NewMapBuilder().ToMap()
				var _hi4 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_obj()).Cardinality())
				_ = _hi4
				for _27_i := _dafny.Zero; _27_i.Cmp(_hi4) < 0; _27_i = _27_i.Plus(_dafny.One) {
					var _28_obj _dafny.Tuple
					_ = _28_obj
					_28_obj = ((data).Dtor_obj()).Select((_27_i).Uint32()).(_dafny.Tuple)
					var _29_valueOrError14 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
					_ = _29_valueOrError14
					_29_valueOrError14 = m_Wrappers.Companion_Default___.Need(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__AttributeName((*(_28_obj).IndexInt(0)).(_dafny.Sequence)), _dafny.Companion_Sequence_.Concatenate((*(_28_obj).IndexInt(0)).(_dafny.Sequence), _dafny.SeqOfString(" is not a valid attribute name.")))
					if (_29_valueOrError14).IsFailure() {
						output = (_29_valueOrError14).PropagateFailure()
						return output
					}
					var _30_valueOrError15 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Default())
					_ = _30_valueOrError15
					var _out1 m_Wrappers.Result
					_ = _out1
					_out1 = Companion_Default___.GetAttrValue((*(_28_obj).IndexInt(1)).(m_JSON_Values.JSON))
					_30_valueOrError15 = _out1
					if (_30_valueOrError15).IsFailure() {
						output = (_30_valueOrError15).PropagateFailure()
						return output
					}
					var _31_val m_ComAmazonawsDynamodbTypes.AttributeValue
					_ = _31_val
					_31_val = (_30_valueOrError15).Extract().(m_ComAmazonawsDynamodbTypes.AttributeValue)
					_26_result = (_26_result).Update((*(_28_obj).IndexInt(0)).(_dafny.Sequence), _31_val)
				}
				output = m_Wrappers.Companion_Result_.Create_Success_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_M_(_26_result))
				return output
				goto Lmatch0
			}
		}
		{
			if (_source0).Equals(_dafny.SeqOfString("BOOL")) {
				var _32_valueOrError16 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
				_ = _32_valueOrError16
				_32_valueOrError16 = m_Wrappers.Companion_Default___.Need((data).Is_Bool(), _dafny.SeqOfString("Value for 'BOOL' must be a Bool"))
				if (_32_valueOrError16).IsFailure() {
					output = (_32_valueOrError16).PropagateFailure()
					return output
				}
				output = m_Wrappers.Companion_Result_.Create_Success_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_BOOL_((data).Dtor_b()))
				return output
				goto Lmatch0
			}
		}
		{
			if (_source0).Equals(_dafny.SeqOfString("NULL")) {
				output = m_Wrappers.Companion_Result_.Create_Success_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_NULL_(true))
				return output
				goto Lmatch0
			}
		}
		{
			output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Unexpected Attribute Type '"), typeStr), _dafny.SeqOfString("'.\n")))
			return output
		}
		goto Lmatch0
	}
Lmatch0:
	return output
}
func (_static *CompanionStruct_Default___) JsonToDdbItem(data m_JSON_Values.JSON) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Object(), _dafny.SeqOfString("Value for a ddb item must be a JSON object."))
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
		var _4_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _4_valueOrError1
		_4_valueOrError1 = m_Wrappers.Companion_Default___.Need(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__AttributeName((*(_3_obj).IndexInt(0)).(_dafny.Sequence)), _dafny.Companion_Sequence_.Concatenate((*(_3_obj).IndexInt(0)).(_dafny.Sequence), _dafny.SeqOfString(" is not a valid attribute name")))
		if (_4_valueOrError1).IsFailure() {
			output = (_4_valueOrError1).PropagateFailure()
			return output
		}
		var _5_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Default())
		_ = _5_valueOrError2
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = Companion_Default___.GetAttrValue((*(_3_obj).IndexInt(1)).(m_JSON_Values.JSON))
		_5_valueOrError2 = _out0
		if (_5_valueOrError2).IsFailure() {
			output = (_5_valueOrError2).PropagateFailure()
			return output
		}
		var _6_value m_ComAmazonawsDynamodbTypes.AttributeValue
		_ = _6_value
		_6_value = (_5_valueOrError2).Extract().(m_ComAmazonawsDynamodbTypes.AttributeValue)
		_1_item = (_1_item).Update((*(_3_obj).IndexInt(0)).(_dafny.Sequence), _6_value)
	}
	output = m_Wrappers.Companion_Result_.Create_Success_(_1_item)
	return output
	return output
}
func (_static *CompanionStruct_Default___) DecimalToStr(num m_JSON_Values.Decimal) m_Wrappers.Result {
	if ((num).Dtor_n()).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(_dafny.SeqOfString("0"))
	} else {
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(((_dafny.IntOfInt64(-1000)).Cmp((num).Dtor_e10()) < 0) && (((num).Dtor_e10()).Cmp(_dafny.IntOfInt64(1000)) < 0), _dafny.SeqOfString("Exponent must be between -1000 and 1000"))
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_str _dafny.Sequence = m_StandardLibrary_String.Companion_Default___.Base10Int2String((num).Dtor_n())
			_ = _1_str
			if ((num).Dtor_e10()).Sign() != -1 {
				return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Concatenate(_1_str, Companion_Default___.Zeros((num).Dtor_e10())))
			} else if ((_dafny.Zero).Minus((num).Dtor_e10())).Cmp(_dafny.IntOfUint32((_1_str).Cardinality())) < 0 {
				var _2_pos _dafny.Int = (_dafny.IntOfUint32((_1_str).Cardinality())).Plus((num).Dtor_e10())
				_ = _2_pos
				return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate((_1_str).Take((_2_pos).Uint32()), _dafny.SeqOfString(".")), (_1_str).Drop((_2_pos).Uint32())))
			} else {
				return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("0."), Companion_Default___.Zeros((_dafny.IntOfUint32((_1_str).Cardinality())).Minus((num).Dtor_e10()))), _1_str))
			}
		}
	}
}
func (_static *CompanionStruct_Default___) NormalizeItem(value _dafny.Map) _dafny.Map {
	return func() _dafny.Map {
		var _coll0 = _dafny.NewMapBuilder()
		_ = _coll0
		for _iter0 := _dafny.Iterate((value).Keys().Elements()); ; {
			_compr_0, _ok0 := _iter0()
			if !_ok0 {
				break
			}
			var _0_k _dafny.Sequence
			_0_k = interface{}(_compr_0).(_dafny.Sequence)
			if m_ComAmazonawsDynamodbTypes.Companion_AttributeName_.Is_(_0_k) {
				if (value).Contains(_0_k) {
					_coll0.Add(_0_k, Companion_Default___.Normalize((value).Get(_0_k).(m_ComAmazonawsDynamodbTypes.AttributeValue)))
				}
			}
		}
		return _coll0.ToMap()
	}()
}
func (_static *CompanionStruct_Default___) Normalize(value m_ComAmazonawsDynamodbTypes.AttributeValue) m_ComAmazonawsDynamodbTypes.AttributeValue {
	var _source0 m_ComAmazonawsDynamodbTypes.AttributeValue = value
	_ = _source0
	{
		if _source0.Is_N() {
			var _0_n _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_N).N
			_ = _0_n
			var _1_nn m_Wrappers.Result = m_DynamoDbNormalizeNumber.Companion_Default___.NormalizeNumber(_0_n)
			_ = _1_nn
			if (_1_nn).Is_Success() {
				return m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_N_((_1_nn).Dtor_value().(_dafny.Sequence))
			} else {
				return value
			}
		}
	}
	{
		if _source0.Is_SS() {
			var _2_s _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_SS).SS
			_ = _2_s
			var _3_asSet _dafny.Set = m_Seq.Companion_Default___.ToSet(_2_s)
			_ = _3_asSet
			return m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_SS_(m_SortedSets.SetToOrderedSequence2(_3_asSet, func(coer1 func(_dafny.Char, _dafny.Char) bool) func(interface{}, interface{}) bool {
				return func(arg1 interface{}, arg2 interface{}) bool {
					return coer1(arg1.(_dafny.Char), arg2.(_dafny.Char))
				}
			}(m_DynamoDbEncryptionUtil.Companion_Default___.CharLess)))
		}
	}
	{
		if _source0.Is_NS() {
			var _4_s _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_NS).NS
			_ = _4_s
			var _5_normList m_Wrappers.Result = m_Seq.Companion_Default___.MapWithResult(func(coer2 func(_dafny.Sequence) m_Wrappers.Result) func(interface{}) m_Wrappers.Result {
				return func(arg3 interface{}) m_Wrappers.Result {
					return coer2(arg3.(_dafny.Sequence))
				}
			}(func(_6_n _dafny.Sequence) m_Wrappers.Result {
				return m_DynamoDbNormalizeNumber.Companion_Default___.NormalizeNumber(_6_n)
			}), _4_s)
			_ = _5_normList
			if (_5_normList).Is_Success() {
				var _7_asSet _dafny.Set = m_Seq.Companion_Default___.ToSet((_5_normList).Dtor_value().(_dafny.Sequence))
				_ = _7_asSet
				return m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_NS_(m_SortedSets.SetToOrderedSequence2(_7_asSet, func(coer3 func(_dafny.Char, _dafny.Char) bool) func(interface{}, interface{}) bool {
					return func(arg4 interface{}, arg5 interface{}) bool {
						return coer3(arg4.(_dafny.Char), arg5.(_dafny.Char))
					}
				}(m_DynamoDbEncryptionUtil.Companion_Default___.CharLess)))
			} else {
				return value
			}
		}
	}
	{
		if _source0.Is_BS() {
			var _8_s _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_BS).BS
			_ = _8_s
			var _9_asSet _dafny.Set = m_Seq.Companion_Default___.ToSet(_8_s)
			_ = _9_asSet
			return m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_BS_(m_SortedSets.SetToOrderedSequence2(_9_asSet, func(coer4 func(uint8, uint8) bool) func(interface{}, interface{}) bool {
				return func(arg6 interface{}, arg7 interface{}) bool {
					return coer4(arg6.(uint8), arg7.(uint8))
				}
			}(m_DynamoDbEncryptionUtil.Companion_Default___.ByteLess)))
		}
	}
	{
		if _source0.Is_L() {
			var _10_list _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_L).L
			_ = _10_list
			var _11_value _dafny.Sequence = _dafny.SeqCreate((_dafny.IntOfUint32((_10_list).Cardinality())).Uint32(), func(coer5 func(_dafny.Int) m_ComAmazonawsDynamodbTypes.AttributeValue) func(_dafny.Int) interface{} {
				return func(arg8 _dafny.Int) interface{} {
					return coer5(arg8)
				}
			}((func(_12_list _dafny.Sequence) func(_dafny.Int) m_ComAmazonawsDynamodbTypes.AttributeValue {
				return func(_13_i _dafny.Int) m_ComAmazonawsDynamodbTypes.AttributeValue {
					return Companion_Default___.Normalize((_12_list).Select((_13_i).Uint32()).(m_ComAmazonawsDynamodbTypes.AttributeValue))
				}
			})(_10_list)))
			_ = _11_value
			return m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_L_(_11_value)
		}
	}
	{
		if _source0.Is_M() {
			var _14_m _dafny.Map = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_M).M
			_ = _14_m
			return m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_M_(func() _dafny.Map {
				var _coll0 = _dafny.NewMapBuilder()
				_ = _coll0
				for _iter1 := _dafny.Iterate((_14_m).Keys().Elements()); ; {
					_compr_0, _ok1 := _iter1()
					if !_ok1 {
						break
					}
					var _15_k _dafny.Sequence
					_15_k = interface{}(_compr_0).(_dafny.Sequence)
					if m_ComAmazonawsDynamodbTypes.Companion_AttributeName_.Is_(_15_k) {
						if (_14_m).Contains(_15_k) {
							_coll0.Add(_15_k, Companion_Default___.Normalize((_14_m).Get(_15_k).(m_ComAmazonawsDynamodbTypes.AttributeValue)))
						}
					}
				}
				return _coll0.ToMap()
			}())
		}
	}
	{
		return value
	}
}

// End of class Default__
