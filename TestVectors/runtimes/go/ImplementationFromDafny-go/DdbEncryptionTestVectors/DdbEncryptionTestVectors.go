// Package DdbEncryptionTestVectors
// Dafny module DdbEncryptionTestVectors compiled into Go

package DdbEncryptionTestVectors

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
	m_CreateInterceptedDDBClient "github.com/aws/aws-database-encryption-sdk-dynamodb/testvectors/CreateInterceptedDDBClient"
	m_DdbItemJson "github.com/aws/aws-database-encryption-sdk-dynamodb/testvectors/DdbItemJson"
	m_DecryptManifest "github.com/aws/aws-database-encryption-sdk-dynamodb/testvectors/DecryptManifest"
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
var _ m_DecryptManifest.Dummy__

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
	return "DdbEncryptionTestVectors.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) TrimMaps(keyExpr _dafny.Sequence, filterExpr _dafny.Sequence, names _dafny.Map, values _dafny.Map) _dafny.Tuple {
	var _0_keyParsed _dafny.Sequence = m_DynamoDBFilterExpr.Companion_Default___.ParseExpr(keyExpr)
	_ = _0_keyParsed
	var _1_filterParsed _dafny.Sequence = m_DynamoDBFilterExpr.Companion_Default___.ParseExpr(filterExpr)
	_ = _1_filterParsed
	return Companion_Default___.TrimMaps2(_dafny.Companion_Sequence_.Concatenate(_0_keyParsed, _1_filterParsed), names, values, _dafny.NewMapBuilder().ToMap(), _dafny.NewMapBuilder().ToMap())
}
func (_static *CompanionStruct_Default___) TrimMaps2(query _dafny.Sequence, origNames _dafny.Map, origValues _dafny.Map, newNames _dafny.Map, newValues _dafny.Map) _dafny.Tuple {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((query).Cardinality())).Sign() == 0 {
		return _dafny.TupleOf(newNames, newValues)
	} else {
		var _in0 _dafny.Sequence = (query).Drop(1)
		_ = _in0
		var _in1 _dafny.Map = origNames
		_ = _in1
		var _in2 _dafny.Map = origValues
		_ = _in2
		var _in3 _dafny.Map = (func() _dafny.Map {
			if (((query).Select(0).(m_DynamoDBFilterExpr.Token)).Is_Attr()) && ((origNames).Contains(((query).Select(0).(m_DynamoDBFilterExpr.Token)).Dtor_s())) {
				return (newNames).Update(((query).Select(0).(m_DynamoDBFilterExpr.Token)).Dtor_s(), (origNames).Get(((query).Select(0).(m_DynamoDBFilterExpr.Token)).Dtor_s()).(_dafny.Sequence))
			}
			return newNames
		})()
		_ = _in3
		var _in4 _dafny.Map = (func() _dafny.Map {
			if (((query).Select(0).(m_DynamoDBFilterExpr.Token)).Is_Value()) && ((origValues).Contains(((query).Select(0).(m_DynamoDBFilterExpr.Token)).Dtor_s())) {
				return (newValues).Update(((query).Select(0).(m_DynamoDBFilterExpr.Token)).Dtor_s(), (origValues).Get(((query).Select(0).(m_DynamoDBFilterExpr.Token)).Dtor_s()).(m_ComAmazonawsDynamodbTypes.AttributeValue))
			}
			return newValues
		})()
		_ = _in4
		query = _in0
		origNames = _in1
		origValues = _in2
		newNames = _in3
		newValues = _in4
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) MakeCreateTableInput() m_ComAmazonawsDynamodbTypes.CreateTableInput {
	return m_ComAmazonawsDynamodbTypes.Companion_CreateTableInput_.Create_CreateTableInput_(_dafny.SeqOf(m_ComAmazonawsDynamodbTypes.Companion_AttributeDefinition_.Create_AttributeDefinition_(m_JsonConfig.Companion_Default___.HashName(), m_ComAmazonawsDynamodbTypes.Companion_ScalarAttributeType_.Create_N_())), m_JsonConfig.Companion_Default___.TableName(), _dafny.SeqOf(m_ComAmazonawsDynamodbTypes.Companion_KeySchemaElement_.Create_KeySchemaElement_(m_JsonConfig.Companion_Default___.HashName(), m_ComAmazonawsDynamodbTypes.Companion_KeyType_.Create_HASH_())), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(m_ComAmazonawsDynamodbTypes.Companion_ProvisionedThroughput_.Create_ProvisionedThroughput_(int64(100), int64(100))), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
}
func (_static *CompanionStruct_Default___) MakeEmptyTestVector() TestVectorConfig {
	return Companion_TestVectorConfig_.Create_TestVectorConfig_(Companion_Default___.MakeCreateTableInput(), _dafny.SeqOf(), _dafny.NewMapBuilder().ToMap(), _dafny.NewMapBuilder().ToMap(), _dafny.SeqOf(), _dafny.NewMapBuilder().ToMap(), _dafny.NewMapBuilder().ToMap(), _dafny.SeqOf(), _dafny.SeqOf(), _dafny.SeqOf(), _dafny.SeqOf(), _dafny.SeqOf(), _dafny.SeqOf(), _dafny.SeqOf(), _dafny.SeqOf(), _dafny.SeqOf(), _dafny.SeqOf())
}
func (_static *CompanionStruct_Default___) ParseTestVector(data m_JSON_Values.JSON, prev TestVectorConfig, keyVectors *m_KeyVectors.KeyVectorsClient) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _0_valueOrError0
	_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((data).Is_Object(), _dafny.SeqOfString("Top Level JSON must be an object."))
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_records _dafny.Sequence
	_ = _1_records
	_1_records = _dafny.SeqOf()
	var _2_ioPairs _dafny.Sequence
	_ = _2_ioPairs
	_2_ioPairs = _dafny.SeqOf()
	var _3_queryPairs _dafny.Sequence
	_ = _3_queryPairs
	_3_queryPairs = _dafny.SeqOf()
	var _4_queries _dafny.Sequence
	_ = _4_queries
	_4_queries = _dafny.SeqOf()
	var _5_failingQueries _dafny.Sequence
	_ = _5_failingQueries
	_5_failingQueries = _dafny.SeqOf()
	var _6_names _dafny.Map
	_ = _6_names
	_6_names = _dafny.NewMapBuilder().ToMap()
	var _7_values _dafny.Map
	_ = _7_values
	_7_values = _dafny.NewMapBuilder().ToMap()
	var _8_complexTests _dafny.Sequence
	_ = _8_complexTests
	_8_complexTests = _dafny.SeqOf()
	var _9_ioTests _dafny.Sequence
	_ = _9_ioTests
	_9_ioTests = _dafny.SeqOf()
	var _10_gsi _dafny.Sequence
	_ = _10_gsi
	_10_gsi = _dafny.SeqOf()
	var _11_tableEncryptionConfigs _dafny.Map
	_ = _11_tableEncryptionConfigs
	_11_tableEncryptionConfigs = _dafny.NewMapBuilder().ToMap()
	var _12_largeEncryptionConfigs _dafny.Map
	_ = _12_largeEncryptionConfigs
	_12_largeEncryptionConfigs = _dafny.NewMapBuilder().ToMap()
	var _13_writeTests _dafny.Sequence
	_ = _13_writeTests
	_13_writeTests = _dafny.SeqOf()
	var _14_roundTripTests _dafny.Sequence
	_ = _14_roundTripTests
	_14_roundTripTests = _dafny.SeqOf()
	var _15_decryptTests _dafny.Sequence
	_ = _15_decryptTests
	_15_decryptTests = _dafny.SeqOf()
	var _16_strings _dafny.Sequence
	_ = _16_strings
	_16_strings = _dafny.SeqOf()
	var _17_large _dafny.Sequence
	_ = _17_large
	_17_large = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((data).Dtor_obj()).Cardinality())
	_ = _hi0
	for _18_i := _dafny.Zero; _18_i.Cmp(_hi0) < 0; _18_i = _18_i.Plus(_dafny.One) {
		var _source0 _dafny.Sequence = (*(((data).Dtor_obj()).Select((_18_i).Uint32()).(_dafny.Tuple)).IndexInt(0)).(_dafny.Sequence)
		_ = _source0
		{
			{
				if (_source0).Equals(_dafny.SeqOfString("Records")) {
					var _19_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _19_valueOrError1
					var _out0 m_Wrappers.Result
					_ = _out0
					_out0 = m_JsonConfig.Companion_Default___.GetRecords((*(((data).Dtor_obj()).Select((_18_i).Uint32()).(_dafny.Tuple)).IndexInt(1)).(m_JSON_Values.JSON))
					_19_valueOrError1 = _out0
					if (_19_valueOrError1).IsFailure() {
						output = (_19_valueOrError1).PropagateFailure()
						return output
					}
					_1_records = (_19_valueOrError1).Extract().(_dafny.Sequence)
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("IoPairs")) {
					var _20_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _20_valueOrError2
					var _out1 m_Wrappers.Result
					_ = _out1
					_out1 = m_JsonConfig.Companion_Default___.GetPairs((*(((data).Dtor_obj()).Select((_18_i).Uint32()).(_dafny.Tuple)).IndexInt(1)).(m_JSON_Values.JSON))
					_20_valueOrError2 = _out1
					if (_20_valueOrError2).IsFailure() {
						output = (_20_valueOrError2).PropagateFailure()
						return output
					}
					_2_ioPairs = (_20_valueOrError2).Extract().(_dafny.Sequence)
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("QueryPairs")) {
					var _21_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _21_valueOrError3
					var _out2 m_Wrappers.Result
					_ = _out2
					_out2 = m_JsonConfig.Companion_Default___.GetPairs((*(((data).Dtor_obj()).Select((_18_i).Uint32()).(_dafny.Tuple)).IndexInt(1)).(m_JSON_Values.JSON))
					_21_valueOrError3 = _out2
					if (_21_valueOrError3).IsFailure() {
						output = (_21_valueOrError3).PropagateFailure()
						return output
					}
					_3_queryPairs = (_21_valueOrError3).Extract().(_dafny.Sequence)
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("Queries")) {
					var _22_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _22_valueOrError4
					var _out3 m_Wrappers.Result
					_ = _out3
					_out3 = m_JsonConfig.Companion_Default___.GetSimpleQueries((*(((data).Dtor_obj()).Select((_18_i).Uint32()).(_dafny.Tuple)).IndexInt(1)).(m_JSON_Values.JSON))
					_22_valueOrError4 = _out3
					if (_22_valueOrError4).IsFailure() {
						output = (_22_valueOrError4).PropagateFailure()
						return output
					}
					_4_queries = (_22_valueOrError4).Extract().(_dafny.Sequence)
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("Failing")) {
					var _23_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _23_valueOrError5
					var _out4 m_Wrappers.Result
					_ = _out4
					_out4 = m_JsonConfig.Companion_Default___.GetSimpleQueries((*(((data).Dtor_obj()).Select((_18_i).Uint32()).(_dafny.Tuple)).IndexInt(1)).(m_JSON_Values.JSON))
					_23_valueOrError5 = _out4
					if (_23_valueOrError5).IsFailure() {
						output = (_23_valueOrError5).PropagateFailure()
						return output
					}
					_5_failingQueries = (_23_valueOrError5).Extract().(_dafny.Sequence)
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("Names")) {
					var _24_valueOrError6 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
					_ = _24_valueOrError6
					var _out5 m_Wrappers.Result
					_ = _out5
					_out5 = m_JsonConfig.Companion_Default___.GetNameMap((*(((data).Dtor_obj()).Select((_18_i).Uint32()).(_dafny.Tuple)).IndexInt(1)).(m_JSON_Values.JSON))
					_24_valueOrError6 = _out5
					if (_24_valueOrError6).IsFailure() {
						output = (_24_valueOrError6).PropagateFailure()
						return output
					}
					_6_names = (_24_valueOrError6).Extract().(_dafny.Map)
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("Values")) {
					var _25_valueOrError7 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
					_ = _25_valueOrError7
					var _out6 m_Wrappers.Result
					_ = _out6
					_out6 = m_JsonConfig.Companion_Default___.GetValueMap((*(((data).Dtor_obj()).Select((_18_i).Uint32()).(_dafny.Tuple)).IndexInt(1)).(m_JSON_Values.JSON))
					_25_valueOrError7 = _out6
					if (_25_valueOrError7).IsFailure() {
						output = (_25_valueOrError7).PropagateFailure()
						return output
					}
					_7_values = (_25_valueOrError7).Extract().(_dafny.Map)
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("Complex")) {
					var _26_valueOrError8 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _26_valueOrError8
					var _out7 m_Wrappers.Result
					_ = _out7
					_out7 = m_JsonConfig.Companion_Default___.GetComplexTests((*(((data).Dtor_obj()).Select((_18_i).Uint32()).(_dafny.Tuple)).IndexInt(1)).(m_JSON_Values.JSON))
					_26_valueOrError8 = _out7
					if (_26_valueOrError8).IsFailure() {
						output = (_26_valueOrError8).PropagateFailure()
						return output
					}
					_8_complexTests = (_26_valueOrError8).Extract().(_dafny.Sequence)
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("IoTests")) {
					var _27_valueOrError9 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _27_valueOrError9
					var _out8 m_Wrappers.Result
					_ = _out8
					_out8 = m_JsonConfig.Companion_Default___.GetIoTests((*(((data).Dtor_obj()).Select((_18_i).Uint32()).(_dafny.Tuple)).IndexInt(1)).(m_JSON_Values.JSON), keyVectors)
					_27_valueOrError9 = _out8
					if (_27_valueOrError9).IsFailure() {
						output = (_27_valueOrError9).PropagateFailure()
						return output
					}
					_9_ioTests = (_27_valueOrError9).Extract().(_dafny.Sequence)
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("GSI")) {
					var _28_valueOrError10 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _28_valueOrError10
					var _out9 m_Wrappers.Result
					_ = _out9
					_out9 = m_JsonConfig.Companion_Default___.GetGSIs((*(((data).Dtor_obj()).Select((_18_i).Uint32()).(_dafny.Tuple)).IndexInt(1)).(m_JSON_Values.JSON))
					_28_valueOrError10 = _out9
					if (_28_valueOrError10).IsFailure() {
						output = (_28_valueOrError10).PropagateFailure()
						return output
					}
					_10_gsi = (_28_valueOrError10).Extract().(_dafny.Sequence)
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("tableEncryptionConfigs")) {
					var _29_valueOrError11 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
					_ = _29_valueOrError11
					var _out10 m_Wrappers.Result
					_ = _out10
					_out10 = m_JsonConfig.Companion_Default___.GetTableConfigs((*(((data).Dtor_obj()).Select((_18_i).Uint32()).(_dafny.Tuple)).IndexInt(1)).(m_JSON_Values.JSON), keyVectors)
					_29_valueOrError11 = _out10
					if (_29_valueOrError11).IsFailure() {
						output = (_29_valueOrError11).PropagateFailure()
						return output
					}
					_11_tableEncryptionConfigs = (_29_valueOrError11).Extract().(_dafny.Map)
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("largeEncryptionConfigs")) {
					var _30_valueOrError12 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
					_ = _30_valueOrError12
					var _out11 m_Wrappers.Result
					_ = _out11
					_out11 = m_JsonConfig.Companion_Default___.GetTableConfigs((*(((data).Dtor_obj()).Select((_18_i).Uint32()).(_dafny.Tuple)).IndexInt(1)).(m_JSON_Values.JSON), keyVectors)
					_30_valueOrError12 = _out11
					if (_30_valueOrError12).IsFailure() {
						output = (_30_valueOrError12).PropagateFailure()
						return output
					}
					_12_largeEncryptionConfigs = (_30_valueOrError12).Extract().(_dafny.Map)
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("WriteTests")) {
					var _31_valueOrError13 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _31_valueOrError13
					var _out12 m_Wrappers.Result
					_ = _out12
					_out12 = m_JsonConfig.Companion_Default___.GetWriteTests((*(((data).Dtor_obj()).Select((_18_i).Uint32()).(_dafny.Tuple)).IndexInt(1)).(m_JSON_Values.JSON), keyVectors)
					_31_valueOrError13 = _out12
					if (_31_valueOrError13).IsFailure() {
						output = (_31_valueOrError13).PropagateFailure()
						return output
					}
					_13_writeTests = (_31_valueOrError13).Extract().(_dafny.Sequence)
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("RoundTripTest")) {
					var _32_valueOrError14 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _32_valueOrError14
					var _out13 m_Wrappers.Result
					_ = _out13
					_out13 = m_JsonConfig.Companion_Default___.GetRoundTripTests((*(((data).Dtor_obj()).Select((_18_i).Uint32()).(_dafny.Tuple)).IndexInt(1)).(m_JSON_Values.JSON), keyVectors)
					_32_valueOrError14 = _out13
					if (_32_valueOrError14).IsFailure() {
						output = (_32_valueOrError14).PropagateFailure()
						return output
					}
					_14_roundTripTests = (_32_valueOrError14).Extract().(_dafny.Sequence)
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("DecryptTests")) {
					var _33_valueOrError15 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _33_valueOrError15
					var _out14 m_Wrappers.Result
					_ = _out14
					_out14 = m_JsonConfig.Companion_Default___.GetDecryptTests((*(((data).Dtor_obj()).Select((_18_i).Uint32()).(_dafny.Tuple)).IndexInt(1)).(m_JSON_Values.JSON), keyVectors)
					_33_valueOrError15 = _out14
					if (_33_valueOrError15).IsFailure() {
						output = (_33_valueOrError15).PropagateFailure()
						return output
					}
					_15_decryptTests = (_33_valueOrError15).Extract().(_dafny.Sequence)
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("Strings")) {
					var _34_valueOrError16 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _34_valueOrError16
					var _out15 m_Wrappers.Result
					_ = _out15
					_out15 = m_JsonConfig.Companion_Default___.GetStrings((*(((data).Dtor_obj()).Select((_18_i).Uint32()).(_dafny.Tuple)).IndexInt(1)).(m_JSON_Values.JSON))
					_34_valueOrError16 = _out15
					if (_34_valueOrError16).IsFailure() {
						output = (_34_valueOrError16).PropagateFailure()
						return output
					}
					_16_strings = (_34_valueOrError16).Extract().(_dafny.Sequence)
					goto Lmatch0
				}
			}
			{
				if (_source0).Equals(_dafny.SeqOfString("Large")) {
					var _35_valueOrError17 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
					_ = _35_valueOrError17
					var _out16 m_Wrappers.Result
					_ = _out16
					_out16 = m_JsonConfig.Companion_Default___.GetLarges((*(((data).Dtor_obj()).Select((_18_i).Uint32()).(_dafny.Tuple)).IndexInt(1)).(m_JSON_Values.JSON))
					_35_valueOrError17 = _out16
					if (_35_valueOrError17).IsFailure() {
						output = (_35_valueOrError17).PropagateFailure()
						return output
					}
					_17_large = (_35_valueOrError17).Extract().(_dafny.Sequence)
					goto Lmatch0
				}
			}
			{
				output = m_Wrappers.Companion_Result_.Create_Failure_(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Unexpected top level tag "), (*(((data).Dtor_obj()).Select((_18_i).Uint32()).(_dafny.Tuple)).IndexInt(0)).(_dafny.Sequence)))
				return output
			}
			goto Lmatch0
		}
	Lmatch0:
	}
	var _36_valueOrError18 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _36_valueOrError18
	var _out17 m_Wrappers.Result
	_ = _out17
	_out17 = m_JsonConfig.Companion_Default___.MergeGSI((prev).Dtor_schemaOnEncrypt(), _10_gsi)
	_36_valueOrError18 = _out17
	if (_36_valueOrError18).IsFailure() {
		output = (_36_valueOrError18).PropagateFailure()
		return output
	}
	var _37_newSchema m_ComAmazonawsDynamodbTypes.CreateTableInput
	_ = _37_newSchema
	_37_newSchema = (_36_valueOrError18).Extract().(m_ComAmazonawsDynamodbTypes.CreateTableInput)
	output = m_Wrappers.Companion_Result_.Create_Success_(Companion_TestVectorConfig_.Create_TestVectorConfig_(_37_newSchema, _dafny.Companion_Sequence_.Concatenate((prev).Dtor_globalRecords(), _1_records), ((prev).Dtor_tableEncryptionConfigs()).Merge(_11_tableEncryptionConfigs), ((prev).Dtor_largeEncryptionConfigs()).Merge(_12_largeEncryptionConfigs), _dafny.Companion_Sequence_.Concatenate((prev).Dtor_queries(), _4_queries), ((prev).Dtor_names()).Merge(_6_names), ((prev).Dtor_values()).Merge(_7_values), _dafny.Companion_Sequence_.Concatenate((prev).Dtor_failingQueries(), _5_failingQueries), _dafny.Companion_Sequence_.Concatenate((prev).Dtor_complexTests(), _8_complexTests), _dafny.Companion_Sequence_.Concatenate((prev).Dtor_ioTests(), _9_ioTests), _dafny.Companion_Sequence_.Concatenate((prev).Dtor_configsForIoTest(), _2_ioPairs), _dafny.Companion_Sequence_.Concatenate((prev).Dtor_configsForModTest(), _3_queryPairs), _dafny.Companion_Sequence_.Concatenate((prev).Dtor_writeTests(), _13_writeTests), _dafny.Companion_Sequence_.Concatenate((prev).Dtor_roundTripTests(), _14_roundTripTests), _dafny.Companion_Sequence_.Concatenate((prev).Dtor_decryptTests(), _15_decryptTests), _dafny.Companion_Sequence_.Concatenate((prev).Dtor_strings(), _16_strings), _dafny.Companion_Sequence_.Concatenate((prev).Dtor_large(), _17_large)))
	return output
}
func (_static *CompanionStruct_Default___) PerfIterations() uint32 {
	return uint32(1000)
}

// End of class Default__

// Definition of datatype TestVectorConfig
type TestVectorConfig struct {
	Data_TestVectorConfig_
}

func (_this TestVectorConfig) Get_() Data_TestVectorConfig_ {
	return _this.Data_TestVectorConfig_
}

type Data_TestVectorConfig_ interface {
	isTestVectorConfig()
}

type CompanionStruct_TestVectorConfig_ struct {
}

var Companion_TestVectorConfig_ = CompanionStruct_TestVectorConfig_{}

type TestVectorConfig_TestVectorConfig struct {
	SchemaOnEncrypt        m_ComAmazonawsDynamodbTypes.CreateTableInput
	GlobalRecords          _dafny.Sequence
	TableEncryptionConfigs _dafny.Map
	LargeEncryptionConfigs _dafny.Map
	Queries                _dafny.Sequence
	Names                  _dafny.Map
	Values                 _dafny.Map
	FailingQueries         _dafny.Sequence
	ComplexTests           _dafny.Sequence
	IoTests                _dafny.Sequence
	ConfigsForIoTest       _dafny.Sequence
	ConfigsForModTest      _dafny.Sequence
	WriteTests             _dafny.Sequence
	RoundTripTests         _dafny.Sequence
	DecryptTests           _dafny.Sequence
	Strings                _dafny.Sequence
	Large                  _dafny.Sequence
}

func (TestVectorConfig_TestVectorConfig) isTestVectorConfig() {}

func (CompanionStruct_TestVectorConfig_) Create_TestVectorConfig_(SchemaOnEncrypt m_ComAmazonawsDynamodbTypes.CreateTableInput, GlobalRecords _dafny.Sequence, TableEncryptionConfigs _dafny.Map, LargeEncryptionConfigs _dafny.Map, Queries _dafny.Sequence, Names _dafny.Map, Values _dafny.Map, FailingQueries _dafny.Sequence, ComplexTests _dafny.Sequence, IoTests _dafny.Sequence, ConfigsForIoTest _dafny.Sequence, ConfigsForModTest _dafny.Sequence, WriteTests _dafny.Sequence, RoundTripTests _dafny.Sequence, DecryptTests _dafny.Sequence, Strings _dafny.Sequence, Large _dafny.Sequence) TestVectorConfig {
	return TestVectorConfig{TestVectorConfig_TestVectorConfig{SchemaOnEncrypt, GlobalRecords, TableEncryptionConfigs, LargeEncryptionConfigs, Queries, Names, Values, FailingQueries, ComplexTests, IoTests, ConfigsForIoTest, ConfigsForModTest, WriteTests, RoundTripTests, DecryptTests, Strings, Large}}
}

func (_this TestVectorConfig) Is_TestVectorConfig() bool {
	_, ok := _this.Get_().(TestVectorConfig_TestVectorConfig)
	return ok
}

func (CompanionStruct_TestVectorConfig_) Default() TestVectorConfig {
	return Companion_TestVectorConfig_.Create_TestVectorConfig_(m_ComAmazonawsDynamodbTypes.Companion_CreateTableInput_.Default(), _dafny.EmptySeq, _dafny.EmptyMap, _dafny.EmptyMap, _dafny.EmptySeq, _dafny.EmptyMap, _dafny.EmptyMap, _dafny.EmptySeq, _dafny.EmptySeq, _dafny.EmptySeq, _dafny.EmptySeq, _dafny.EmptySeq, _dafny.EmptySeq, _dafny.EmptySeq, _dafny.EmptySeq, _dafny.EmptySeq, _dafny.EmptySeq)
}

func (_this TestVectorConfig) Dtor_schemaOnEncrypt() m_ComAmazonawsDynamodbTypes.CreateTableInput {
	return _this.Get_().(TestVectorConfig_TestVectorConfig).SchemaOnEncrypt
}

func (_this TestVectorConfig) Dtor_globalRecords() _dafny.Sequence {
	return _this.Get_().(TestVectorConfig_TestVectorConfig).GlobalRecords
}

func (_this TestVectorConfig) Dtor_tableEncryptionConfigs() _dafny.Map {
	return _this.Get_().(TestVectorConfig_TestVectorConfig).TableEncryptionConfigs
}

func (_this TestVectorConfig) Dtor_largeEncryptionConfigs() _dafny.Map {
	return _this.Get_().(TestVectorConfig_TestVectorConfig).LargeEncryptionConfigs
}

func (_this TestVectorConfig) Dtor_queries() _dafny.Sequence {
	return _this.Get_().(TestVectorConfig_TestVectorConfig).Queries
}

func (_this TestVectorConfig) Dtor_names() _dafny.Map {
	return _this.Get_().(TestVectorConfig_TestVectorConfig).Names
}

func (_this TestVectorConfig) Dtor_values() _dafny.Map {
	return _this.Get_().(TestVectorConfig_TestVectorConfig).Values
}

func (_this TestVectorConfig) Dtor_failingQueries() _dafny.Sequence {
	return _this.Get_().(TestVectorConfig_TestVectorConfig).FailingQueries
}

func (_this TestVectorConfig) Dtor_complexTests() _dafny.Sequence {
	return _this.Get_().(TestVectorConfig_TestVectorConfig).ComplexTests
}

func (_this TestVectorConfig) Dtor_ioTests() _dafny.Sequence {
	return _this.Get_().(TestVectorConfig_TestVectorConfig).IoTests
}

func (_this TestVectorConfig) Dtor_configsForIoTest() _dafny.Sequence {
	return _this.Get_().(TestVectorConfig_TestVectorConfig).ConfigsForIoTest
}

func (_this TestVectorConfig) Dtor_configsForModTest() _dafny.Sequence {
	return _this.Get_().(TestVectorConfig_TestVectorConfig).ConfigsForModTest
}

func (_this TestVectorConfig) Dtor_writeTests() _dafny.Sequence {
	return _this.Get_().(TestVectorConfig_TestVectorConfig).WriteTests
}

func (_this TestVectorConfig) Dtor_roundTripTests() _dafny.Sequence {
	return _this.Get_().(TestVectorConfig_TestVectorConfig).RoundTripTests
}

func (_this TestVectorConfig) Dtor_decryptTests() _dafny.Sequence {
	return _this.Get_().(TestVectorConfig_TestVectorConfig).DecryptTests
}

func (_this TestVectorConfig) Dtor_strings() _dafny.Sequence {
	return _this.Get_().(TestVectorConfig_TestVectorConfig).Strings
}

func (_this TestVectorConfig) Dtor_large() _dafny.Sequence {
	return _this.Get_().(TestVectorConfig_TestVectorConfig).Large
}

func (_this TestVectorConfig) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case TestVectorConfig_TestVectorConfig:
		{
			return "DdbEncryptionTestVectors.TestVectorConfig.TestVectorConfig" + "(" + _dafny.String(data.SchemaOnEncrypt) + ", " + _dafny.String(data.GlobalRecords) + ", " + _dafny.String(data.TableEncryptionConfigs) + ", " + _dafny.String(data.LargeEncryptionConfigs) + ", " + _dafny.String(data.Queries) + ", " + _dafny.String(data.Names) + ", " + _dafny.String(data.Values) + ", " + _dafny.String(data.FailingQueries) + ", " + _dafny.String(data.ComplexTests) + ", " + _dafny.String(data.IoTests) + ", " + _dafny.String(data.ConfigsForIoTest) + ", " + _dafny.String(data.ConfigsForModTest) + ", " + _dafny.String(data.WriteTests) + ", " + _dafny.String(data.RoundTripTests) + ", " + _dafny.String(data.DecryptTests) + ", " + _dafny.String(data.Strings) + ", " + _dafny.String(data.Large) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this TestVectorConfig) Equals(other TestVectorConfig) bool {
	switch data1 := _this.Get_().(type) {
	case TestVectorConfig_TestVectorConfig:
		{
			data2, ok := other.Get_().(TestVectorConfig_TestVectorConfig)
			return ok && data1.SchemaOnEncrypt.Equals(data2.SchemaOnEncrypt) && data1.GlobalRecords.Equals(data2.GlobalRecords) && data1.TableEncryptionConfigs.Equals(data2.TableEncryptionConfigs) && data1.LargeEncryptionConfigs.Equals(data2.LargeEncryptionConfigs) && data1.Queries.Equals(data2.Queries) && data1.Names.Equals(data2.Names) && data1.Values.Equals(data2.Values) && data1.FailingQueries.Equals(data2.FailingQueries) && data1.ComplexTests.Equals(data2.ComplexTests) && data1.IoTests.Equals(data2.IoTests) && data1.ConfigsForIoTest.Equals(data2.ConfigsForIoTest) && data1.ConfigsForModTest.Equals(data2.ConfigsForModTest) && data1.WriteTests.Equals(data2.WriteTests) && data1.RoundTripTests.Equals(data2.RoundTripTests) && data1.DecryptTests.Equals(data2.DecryptTests) && data1.Strings.Equals(data2.Strings) && data1.Large.Equals(data2.Large)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this TestVectorConfig) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(TestVectorConfig)
	return ok && _this.Equals(typed)
}

func Type_TestVectorConfig_() _dafny.TypeDescriptor {
	return type_TestVectorConfig_{}
}

type type_TestVectorConfig_ struct {
}

func (_this type_TestVectorConfig_) Default() interface{} {
	return Companion_TestVectorConfig_.Default()
}

func (_this type_TestVectorConfig_) String() string {
	return "DdbEncryptionTestVectors.TestVectorConfig"
}
func (_this TestVectorConfig) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = TestVectorConfig{}

func (_this TestVectorConfig) RunAllTests(keyVectors *m_KeyVectors.KeyVectorsClient) {
	{
		_dafny.Print((_dafny.SeqOfString("DBE Test Vectors\n")).SetString())
		_dafny.Print(_dafny.IntOfUint32(((_this).Dtor_globalRecords()).Cardinality()))
		_dafny.Print((_dafny.SeqOfString(" records.\n")).SetString())
		_dafny.Print(((_this).Dtor_tableEncryptionConfigs()).Cardinality())
		_dafny.Print((_dafny.SeqOfString(" tableEncryptionConfigs.\n")).SetString())
		_dafny.Print(((_this).Dtor_largeEncryptionConfigs()).Cardinality())
		_dafny.Print((_dafny.SeqOfString(" largeEncryptionConfigs.\n")).SetString())
		_dafny.Print(_dafny.IntOfUint32(((_this).Dtor_queries()).Cardinality()))
		_dafny.Print((_dafny.SeqOfString(" queries.\n")).SetString())
		_dafny.Print(((_this).Dtor_names()).Cardinality())
		_dafny.Print((_dafny.SeqOfString(" names.\n")).SetString())
		_dafny.Print(((_this).Dtor_values()).Cardinality())
		_dafny.Print((_dafny.SeqOfString(" values.\n")).SetString())
		_dafny.Print(_dafny.IntOfUint32(((_this).Dtor_failingQueries()).Cardinality()))
		_dafny.Print((_dafny.SeqOfString(" failingQueries.\n")).SetString())
		_dafny.Print(_dafny.IntOfUint32(((_this).Dtor_complexTests()).Cardinality()))
		_dafny.Print((_dafny.SeqOfString(" complexTests.\n")).SetString())
		_dafny.Print(_dafny.IntOfUint32(((_this).Dtor_ioTests()).Cardinality()))
		_dafny.Print((_dafny.SeqOfString(" ioTests.\n")).SetString())
		_dafny.Print(_dafny.IntOfUint32(((_this).Dtor_configsForIoTest()).Cardinality()))
		_dafny.Print((_dafny.SeqOfString(" configsForIoTest.\n")).SetString())
		_dafny.Print(_dafny.IntOfUint32(((_this).Dtor_configsForModTest()).Cardinality()))
		_dafny.Print((_dafny.SeqOfString(" configsForModTest.\n")).SetString())
		_dafny.Print(_dafny.IntOfUint32(((_this).Dtor_strings()).Cardinality()))
		_dafny.Print((_dafny.SeqOfString(" strings.\n")).SetString())
		_dafny.Print(_dafny.IntOfUint32(((_this).Dtor_large()).Cardinality()))
		_dafny.Print((_dafny.SeqOfString(" large.\n")).SetString())
		if (_dafny.IntOfUint32(((_this).Dtor_roundTripTests()).Cardinality())).Sign() != 0 {
			_dafny.Print(((((_this).Dtor_roundTripTests()).Select(0).(m_JsonConfig.RoundTripTest)).Dtor_configs()).Cardinality())
			_dafny.Print((_dafny.SeqOfString(" configs and ")).SetString())
			_dafny.Print(_dafny.IntOfUint32(((((_this).Dtor_roundTripTests()).Select(0).(m_JsonConfig.RoundTripTest)).Dtor_records()).Cardinality()))
			_dafny.Print((_dafny.SeqOfString(" records for round trip.\n")).SetString())
		}
		if (_dafny.IntOfUint32(((_this).Dtor_roundTripTests()).Cardinality())).Cmp(_dafny.One) > 0 {
			_dafny.Print(((((_this).Dtor_roundTripTests()).Select(1).(m_JsonConfig.RoundTripTest)).Dtor_configs()).Cardinality())
			_dafny.Print((_dafny.SeqOfString(" configs and ")).SetString())
			_dafny.Print(_dafny.IntOfUint32(((((_this).Dtor_roundTripTests()).Select(1).(m_JsonConfig.RoundTripTest)).Dtor_records()).Cardinality()))
			_dafny.Print((_dafny.SeqOfString(" records for round trip.\n")).SetString())
		}
		var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
		_ = _0_valueOrError0
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_DecryptManifest.Companion_Default___.Decrypt(_dafny.SeqOfString("decrypt_dotnet_32.json"), keyVectors)
		_0_valueOrError0 = _out0
		if !(!((_0_valueOrError0).IsFailure())) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(98,15): " + (_0_valueOrError0).String())
		}
		var _1___v0 bool
		_ = _1___v0
		_1___v0 = (_0_valueOrError0).Extract().(bool)
		var _2_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
		_ = _2_valueOrError1
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = m_DecryptManifest.Companion_Default___.Decrypt(_dafny.SeqOfString("decrypt_java_32.json"), keyVectors)
		_2_valueOrError1 = _out1
		if !(!((_2_valueOrError1).IsFailure())) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(99,15): " + (_2_valueOrError1).String())
		}
		var _3___v1 bool
		_ = _3___v1
		_3___v1 = (_2_valueOrError1).Extract().(bool)
		var _4_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
		_ = _4_valueOrError2
		var _out2 m_Wrappers.Result
		_ = _out2
		_out2 = m_DecryptManifest.Companion_Default___.Decrypt(_dafny.SeqOfString("decrypt_dotnet_33.json"), keyVectors)
		_4_valueOrError2 = _out2
		if !(!((_4_valueOrError2).IsFailure())) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(100,15): " + (_4_valueOrError2).String())
		}
		var _5___v2 bool
		_ = _5___v2
		_5___v2 = (_4_valueOrError2).Extract().(bool)
		var _6_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
		_ = _6_valueOrError3
		var _out3 m_Wrappers.Result
		_ = _out3
		_out3 = m_DecryptManifest.Companion_Default___.Decrypt(_dafny.SeqOfString("decrypt_java_33.json"), keyVectors)
		_6_valueOrError3 = _out3
		if !(!((_6_valueOrError3).IsFailure())) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(101,15): " + (_6_valueOrError3).String())
		}
		var _7___v3 bool
		_ = _7___v3
		_7___v3 = (_6_valueOrError3).Extract().(bool)
		var _8_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
		_ = _8_valueOrError4
		var _out4 m_Wrappers.Result
		_ = _out4
		_out4 = m_DecryptManifest.Companion_Default___.Decrypt(_dafny.SeqOfString("decrypt_dotnet_33a.json"), keyVectors)
		_8_valueOrError4 = _out4
		if !(!((_8_valueOrError4).IsFailure())) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(102,15): " + (_8_valueOrError4).String())
		}
		var _9___v4 bool
		_ = _9___v4
		_9___v4 = (_8_valueOrError4).Extract().(bool)
		var _10_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
		_ = _10_valueOrError5
		var _out5 m_Wrappers.Result
		_ = _out5
		_out5 = m_DecryptManifest.Companion_Default___.Decrypt(_dafny.SeqOfString("decrypt_java_33a.json"), keyVectors)
		_10_valueOrError5 = _out5
		if !(!((_10_valueOrError5).IsFailure())) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(103,15): " + (_10_valueOrError5).String())
		}
		var _11___v5 bool
		_ = _11___v5
		_11___v5 = (_10_valueOrError5).Extract().(bool)
		var _12_valueOrError6 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
		_ = _12_valueOrError6
		var _out6 m_Wrappers.Result
		_ = _out6
		_out6 = m_DecryptManifest.Companion_Default___.Decrypt(_dafny.SeqOfString("decrypt_rust_38.json"), keyVectors)
		_12_valueOrError6 = _out6
		if !(!((_12_valueOrError6).IsFailure())) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(104,15): " + (_12_valueOrError6).String())
		}
		var _13___v6 bool
		_ = _13___v6
		_13___v6 = (_12_valueOrError6).Extract().(bool)
		var _14_valueOrError7 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
		_ = _14_valueOrError7
		var _out7 m_Wrappers.Result
		_ = _out7
		_out7 = m_WriteManifest.Companion_Default___.Write(_dafny.SeqOfString("encrypt.json"))
		_14_valueOrError7 = _out7
		if !(!((_14_valueOrError7).IsFailure())) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(105,15): " + (_14_valueOrError7).String())
		}
		var _15___v7 bool
		_ = _15___v7
		_15___v7 = (_14_valueOrError7).Extract().(bool)
		var _16_valueOrError8 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
		_ = _16_valueOrError8
		var _out8 m_Wrappers.Result
		_ = _out8
		_out8 = m_EncryptManifest.Companion_Default___.Encrypt(_dafny.SeqOfString("encrypt.json"), _dafny.SeqOfString("decrypt.json"), _dafny.SeqOfString("java"), _dafny.SeqOfString("3.3"), keyVectors)
		_16_valueOrError8 = _out8
		if !(!((_16_valueOrError8).IsFailure())) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(106,15): " + (_16_valueOrError8).String())
		}
		var _17___v8 bool
		_ = _17___v8
		_17___v8 = (_16_valueOrError8).Extract().(bool)
		var _18_valueOrError9 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
		_ = _18_valueOrError9
		var _out9 m_Wrappers.Result
		_ = _out9
		_out9 = m_DecryptManifest.Companion_Default___.Decrypt(_dafny.SeqOfString("decrypt.json"), keyVectors)
		_18_valueOrError9 = _out9
		if !(!((_18_valueOrError9).IsFailure())) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(107,15): " + (_18_valueOrError9).String())
		}
		var _19___v9 bool
		_ = _19___v9
		_19___v9 = (_18_valueOrError9).Extract().(bool)
		if (((_dafny.IntOfUint32(((_this).Dtor_globalRecords()).Cardinality())).Plus(((_this).Dtor_tableEncryptionConfigs()).Cardinality())).Plus(_dafny.IntOfUint32(((_this).Dtor_queries()).Cardinality()))).Sign() == 0 {
			_dafny.Print((_dafny.SeqOfString("\nRunning no tests\n")).SetString())
			return
		}
		(_this).Validate()
		(_this).StringOrdering()
		(_this).LargeTests()
		(_this).BasicIoTest()
		(_this).RunIoTests()
		(_this).BasicQueryTest()
		(_this).ConfigModTest()
		(_this).ComplexTests()
		(_this).WriteTests()
		(_this).RoundTripTests()
		(_this).DecryptTests()
		var _20_valueOrError10 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _20_valueOrError10
		var _out10 m_Wrappers.Result
		_ = _out10
		_out10 = m_CreateInterceptedDDBClient.CreateVanillaDDBClient()
		_20_valueOrError10 = _out10
		if !(!((_20_valueOrError10).IsFailure())) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(123,20): " + (_20_valueOrError10).String())
		}
		var _21_client m_ComAmazonawsDynamodbTypes.IDynamoDBClient
		_ = _21_client
		_21_client = m_ComAmazonawsDynamodbTypes.Companion_IDynamoDBClient_.CastTo_((_20_valueOrError10).Extract())
		(_this).DeleteTable(_21_client)
	}
}
func (_this TestVectorConfig) NewOrderRecord(i _dafny.Int, str _dafny.Sequence) m_JsonConfig.Record {
	{
		var _0_n _dafny.Sequence = m_StandardLibrary_String.Companion_Default___.Base10Int2String(i)
		_ = _0_n
		var _1_m _dafny.Map = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(m_JsonConfig.Companion_Default___.HashName(), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_N_(_0_n)).UpdateUnsafe(_dafny.SeqOfString("StrValue"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(str))
		_ = _1_m
		return m_JsonConfig.Companion_Record_.Create_Record_(i, _1_m)
	}
}
func (_this TestVectorConfig) StringOrdering() {
	{
		_dafny.Print((_dafny.SeqOfString("StringOrdering\n")).SetString())
		var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _0_valueOrError0
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_CreateInterceptedDDBClient.CreateVanillaDDBClient()
		_0_valueOrError0 = _out0
		if !(!((_0_valueOrError0).IsFailure())) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(136,20): " + (_0_valueOrError0).String())
		}
		var _1_client m_ComAmazonawsDynamodbTypes.IDynamoDBClient
		_ = _1_client
		_1_client = m_ComAmazonawsDynamodbTypes.Companion_IDynamoDBClient_.CastTo_((_0_valueOrError0).Extract())
		var _2_records _dafny.Sequence
		_ = _2_records
		_2_records = _dafny.SeqOf()
		var _hi0 _dafny.Int = _dafny.IntOfUint32(((_this).Dtor_strings()).Cardinality())
		_ = _hi0
		for _3_i := _dafny.Zero; _3_i.Cmp(_hi0) < 0; _3_i = _3_i.Plus(_dafny.One) {
			_2_records = _dafny.Companion_Sequence_.Concatenate(_2_records, _dafny.SeqOf((_this).NewOrderRecord(_3_i, ((_this).Dtor_strings()).Select((_3_i).Uint32()).(_dafny.Sequence))))
		}
		(_this).WriteAllRecords(_1_client, _2_records)
		var _4_subRecords _dafny.Sequence
		_ = _4_subRecords
		_4_subRecords = m_Seq.Companion_Default___.Map(func(coer10 func(m_JsonConfig.Record) _dafny.Map) func(interface{}) interface{} {
			return func(arg13 interface{}) interface{} {
				return coer10(arg13.(m_JsonConfig.Record))
			}
		}(func(_5_r m_JsonConfig.Record) _dafny.Map {
			return (_5_r).Dtor_item()
		}), _2_records)
		var _6_ops _dafny.Sequence
		_ = _6_ops
		_6_ops = _dafny.SeqOf(_dafny.SeqOfString("<"), _dafny.SeqOfString("<="), _dafny.SeqOfString(">"), _dafny.SeqOfString(">="), _dafny.SeqOfString("="), _dafny.SeqOfString("<>"))
		var _hi1 _dafny.Int = _dafny.IntOfUint32(((_this).Dtor_strings()).Cardinality())
		_ = _hi1
		for _7_i := _dafny.Zero; _7_i.Cmp(_hi1) < 0; _7_i = _7_i.Plus(_dafny.One) {
			var _hi2 _dafny.Int = _dafny.IntOfUint32((_6_ops).Cardinality())
			_ = _hi2
			for _8_j := _dafny.Zero; _8_j.Cmp(_hi2) < 0; _8_j = _8_j.Plus(_dafny.One) {
				var _9_expr m_Wrappers.Option
				_ = _9_expr
				_9_expr = m_Wrappers.Companion_Option_.Create_Some_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("StrValue "), (_6_ops).Select((_8_j).Uint32()).(_dafny.Sequence)), _dafny.SeqOfString(" :val")))
				var _10_vals m_Wrappers.Option
				_ = _10_vals
				_10_vals = m_Wrappers.Companion_Option_.Create_Some_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString(":val"), m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(((_this).Dtor_strings()).Select((_7_i).Uint32()).(_dafny.Sequence))))
				var _11_query m_JsonConfig.SimpleQuery
				_ = _11_query
				_11_query = m_JsonConfig.Companion_SimpleQuery_.Create_SimpleQuery_(m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), _9_expr, _dafny.SeqOf())
				var _12_items1 _dafny.Sequence
				_ = _12_items1
				var _out1 _dafny.Sequence
				_ = _out1
				_out1 = (_this).FullScan(_1_client, _11_query, m_Wrappers.Companion_Option_.Create_Some_(_dafny.NewMapBuilder().ToMap()), _10_vals)
				_12_items1 = _out1
				var _13_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
				_ = _13_valueOrError1
				var _out2 m_Wrappers.Result
				_ = _out2
				_out2 = m_JsonConfig.Companion_Default___.GetFakeBeaconVersion()
				_13_valueOrError1 = _out2
				if !(!((_13_valueOrError1).IsFailure())) {
					panic("dafny/DDBEncryption/src/TestVectors.dfy(150,20): " + (_13_valueOrError1).String())
				}
				var _14_bv m_SearchableEncryptionInfo.BeaconVersion
				_ = _14_bv
				_14_bv = (_13_valueOrError1).Extract().(m_SearchableEncryptionInfo.BeaconVersion)
				var _15_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
				_ = _15_valueOrError2
				var _out3 m_Wrappers.Result
				_ = _out3
				_out3 = m_DynamoDBFilterExpr.Companion_Default___.FilterResults(_14_bv, _4_subRecords, m_Wrappers.Companion_Option_.Create_None_(), _9_expr, m_Wrappers.Companion_Option_.Create_None_(), _10_vals)
				_15_valueOrError2 = _out3
				if !(!((_15_valueOrError2).IsFailure())) {
					panic("dafny/DDBEncryption/src/TestVectors.dfy(151,24): " + (_15_valueOrError2).String())
				}
				var _16_items2 _dafny.Sequence
				_ = _16_items2
				_16_items2 = (_15_valueOrError2).Extract().(_dafny.Sequence)
				(_this).CompareRecordsDisordered2(_12_items1, _16_items2)
			}
		}
	}
}
func (_this TestVectorConfig) Validate() {
	{
		var _0_bad bool
		_ = _0_bad
		_0_bad = false
		var _hi0 _dafny.Int = _dafny.IntOfUint32(((_this).Dtor_globalRecords()).Cardinality())
		_ = _hi0
		for _1_i := _dafny.Zero; _1_i.Cmp(_hi0) < 0; _1_i = _1_i.Plus(_dafny.One) {
			if ((((_this).Dtor_globalRecords()).Select((_1_i).Uint32()).(m_JsonConfig.Record)).Dtor_number()).Cmp(_1_i) != 0 {
				_dafny.Print((_dafny.SeqOfString("Record number ")).SetString())
				_dafny.Print(_1_i)
				_dafny.Print((_dafny.SeqOfString(" has number ")).SetString())
				_dafny.Print((((_this).Dtor_globalRecords()).Select((_1_i).Uint32()).(m_JsonConfig.Record)).Dtor_number())
				_dafny.Print((_dafny.SeqOfString("\n")).SetString())
				_0_bad = true
			}
		}
		var _hi1 _dafny.Int = _dafny.IntOfUint32(((_this).Dtor_complexTests()).Cardinality())
		_ = _hi1
		for _2_i := _dafny.Zero; _2_i.Cmp(_hi1) < 0; _2_i = _2_i.Plus(_dafny.One) {
			if !((_this).Dtor_tableEncryptionConfigs()).Contains((((_this).Dtor_complexTests()).Select((_2_i).Uint32()).(m_JsonConfig.ComplexTest)).Dtor_config()) {
				_dafny.Print((_dafny.SeqOfString("Complex Test number ")).SetString())
				_dafny.Print(_2_i)
				_dafny.Print((_dafny.SeqOfString(" refers to search config, ")).SetString())
				_dafny.Print(((((_this).Dtor_complexTests()).Select((_2_i).Uint32()).(m_JsonConfig.ComplexTest)).Dtor_config()).SetString())
				_dafny.Print((_dafny.SeqOfString(" which does not exist.\n")).SetString())
				_0_bad = true
			}
		}
		var _hi2 _dafny.Int = _dafny.IntOfUint32(((_this).Dtor_queries()).Cardinality())
		_ = _hi2
		for _3_i := _dafny.Zero; _3_i.Cmp(_hi2) < 0; _3_i = _3_i.Plus(_dafny.One) {
			var _hi3 _dafny.Int = _dafny.IntOfUint32(((((_this).Dtor_queries()).Select((_3_i).Uint32()).(m_JsonConfig.SimpleQuery)).Dtor_failConfigs()).Cardinality())
			_ = _hi3
			for _4_j := _dafny.Zero; _4_j.Cmp(_hi3) < 0; _4_j = _4_j.Plus(_dafny.One) {
				if !((_this).Dtor_tableEncryptionConfigs()).Contains(((((_this).Dtor_queries()).Select((_3_i).Uint32()).(m_JsonConfig.SimpleQuery)).Dtor_failConfigs()).Select((_4_j).Uint32()).(_dafny.Sequence)) {
					_dafny.Print((_dafny.SeqOfString("Simple query number ")).SetString())
					_dafny.Print(_3_i)
					_dafny.Print((_dafny.SeqOfString(" refers to search config ")).SetString())
					_dafny.Print((((((_this).Dtor_queries()).Select((_3_i).Uint32()).(m_JsonConfig.SimpleQuery)).Dtor_failConfigs()).Select((_4_j).Uint32()).(_dafny.Sequence)).SetString())
					_dafny.Print((_dafny.SeqOfString(" which does not exist.\n")).SetString())
					_0_bad = true
				}
			}
		}
		var _hi4 _dafny.Int = _dafny.IntOfUint32(((_this).Dtor_configsForIoTest()).Cardinality())
		_ = _hi4
		for _5_i := _dafny.Zero; _5_i.Cmp(_hi4) < 0; _5_i = _5_i.Plus(_dafny.One) {
			if !((_this).Dtor_tableEncryptionConfigs()).Contains((*(((_this).Dtor_configsForIoTest()).Select((_5_i).Uint32()).(_dafny.Tuple)).IndexInt(0)).(_dafny.Sequence)) {
				_dafny.Print((_dafny.SeqOfString("configsForIoTest number ")).SetString())
				_dafny.Print(_5_i)
				_dafny.Print((_dafny.SeqOfString(" refers to search config ")).SetString())
				_dafny.Print(((*(((_this).Dtor_configsForIoTest()).Select((_5_i).Uint32()).(_dafny.Tuple)).IndexInt(0)).(_dafny.Sequence)).SetString())
				_dafny.Print((_dafny.SeqOfString(" which does not exist.\n")).SetString())
				_0_bad = true
			}
			if !((_this).Dtor_tableEncryptionConfigs()).Contains((*(((_this).Dtor_configsForIoTest()).Select((_5_i).Uint32()).(_dafny.Tuple)).IndexInt(1)).(_dafny.Sequence)) {
				_dafny.Print((_dafny.SeqOfString("configsForIoTest number ")).SetString())
				_dafny.Print(_5_i)
				_dafny.Print((_dafny.SeqOfString(" refers to search config ")).SetString())
				_dafny.Print(((*(((_this).Dtor_configsForIoTest()).Select((_5_i).Uint32()).(_dafny.Tuple)).IndexInt(1)).(_dafny.Sequence)).SetString())
				_dafny.Print((_dafny.SeqOfString(" which does not exist.\n")).SetString())
				_0_bad = true
			}
		}
		var _hi5 _dafny.Int = _dafny.IntOfUint32(((_this).Dtor_configsForModTest()).Cardinality())
		_ = _hi5
		for _6_i := _dafny.Zero; _6_i.Cmp(_hi5) < 0; _6_i = _6_i.Plus(_dafny.One) {
			if !((_this).Dtor_tableEncryptionConfigs()).Contains((*(((_this).Dtor_configsForModTest()).Select((_6_i).Uint32()).(_dafny.Tuple)).IndexInt(0)).(_dafny.Sequence)) {
				_dafny.Print((_dafny.SeqOfString("configsForModTest number ")).SetString())
				_dafny.Print(_6_i)
				_dafny.Print((_dafny.SeqOfString(" refers to search config ")).SetString())
				_dafny.Print(((*(((_this).Dtor_configsForModTest()).Select((_6_i).Uint32()).(_dafny.Tuple)).IndexInt(0)).(_dafny.Sequence)).SetString())
				_dafny.Print((_dafny.SeqOfString(" which does not exist.\n")).SetString())
				_0_bad = true
			}
			if !((_this).Dtor_tableEncryptionConfigs()).Contains((*(((_this).Dtor_configsForModTest()).Select((_6_i).Uint32()).(_dafny.Tuple)).IndexInt(1)).(_dafny.Sequence)) {
				_dafny.Print((_dafny.SeqOfString("configsForModTest number ")).SetString())
				_dafny.Print(_6_i)
				_dafny.Print((_dafny.SeqOfString(" refers to search config ")).SetString())
				_dafny.Print(((*(((_this).Dtor_configsForModTest()).Select((_6_i).Uint32()).(_dafny.Tuple)).IndexInt(1)).(_dafny.Sequence)).SetString())
				_dafny.Print((_dafny.SeqOfString(" which does not exist.\n")).SetString())
				_0_bad = true
			}
		}
		if !(!(_0_bad)) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(200,6): " + (_dafny.SeqOfString("expectation violation")).String())
		}
	}
}
func (_this TestVectorConfig) DeleteTable(client m_ComAmazonawsDynamodbTypes.IDynamoDBClient) {
	{
		var _0_res m_Wrappers.Result
		_ = _0_res
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = (client).DeleteTable(m_ComAmazonawsDynamodbTypes.Companion_DeleteTableInput_.Create_DeleteTableInput_(m_JsonConfig.Companion_Default___.TableName()))
		_0_res = _out0
	}
}
func (_this TestVectorConfig) GetUsed(q m_JsonConfig.SimpleQuery) _dafny.Tuple {
	{
		return Companion_Default___.TrimMaps(((q).Dtor_keyExpr()).UnwrapOr(_dafny.SeqOfString("")).(_dafny.Sequence), ((q).Dtor_filterExpr()).UnwrapOr(_dafny.SeqOfString("")).(_dafny.Sequence), (_this).Dtor_names(), (_this).Dtor_values())
	}
}
func (_this TestVectorConfig) GetUsed2(q m_JsonConfig.SimpleQuery, names m_Wrappers.Option, values m_Wrappers.Option) _dafny.Tuple {
	{
		var output _dafny.Tuple = _dafny.TupleOf(_dafny.EmptyMap, _dafny.EmptyMap)
		_ = output
		if !(((names).Is_Some()) == ((values).Is_Some())) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(218,6): " + (_dafny.SeqOfString("expectation violation")).String())
		}
		if (names).Is_Some() {
			output = _dafny.TupleOf((names).Dtor_value().(_dafny.Map), (values).Dtor_value().(_dafny.Map))
			return output
		} else {
			output = (_this).GetUsed(q)
			return output
		}
		return output
	}
}
func (_this TestVectorConfig) FullSearch(client m_ComAmazonawsDynamodbTypes.IDynamoDBClient, q m_JsonConfig.SimpleQuery, names m_Wrappers.Option, values m_Wrappers.Option) _dafny.Sequence {
	{
		var output _dafny.Sequence = _dafny.EmptySeq
		_ = output
		if ((q).Dtor_keyExpr()).Is_Some() {
			var _out0 _dafny.Sequence
			_ = _out0
			_out0 = (_this).FullQuery(client, q, names, values)
			output = _out0
		} else {
			var _out1 _dafny.Sequence
			_ = _out1
			_out1 = (_this).FullScan(client, q, names, values)
			output = _out1
		}
		return output
	}
}
func (_this TestVectorConfig) FullQuery(client m_ComAmazonawsDynamodbTypes.IDynamoDBClient, q m_JsonConfig.SimpleQuery, names m_Wrappers.Option, values m_Wrappers.Option) _dafny.Sequence {
	{
		var output _dafny.Sequence = _dafny.EmptySeq
		_ = output
		var _0_zzz _dafny.Tuple
		_ = _0_zzz
		var _out0 _dafny.Tuple
		_ = _out0
		_out0 = (_this).GetUsed2(q, names, values)
		_0_zzz = _out0
		var _let_tmp_rhs0 _dafny.Tuple = _0_zzz
		_ = _let_tmp_rhs0
		var _1_usedNames _dafny.Map = (*(_let_tmp_rhs0).IndexInt(0)).(_dafny.Map)
		_ = _1_usedNames
		var _2_usedValues _dafny.Map = (*(_let_tmp_rhs0).IndexInt(1)).(_dafny.Map)
		_ = _2_usedValues
		output = _dafny.SeqOf()
		var _3_lastKey m_Wrappers.Option
		_ = _3_lastKey
		_3_lastKey = m_Wrappers.Companion_Option_.Create_None_()
		{
			var _hi0 _dafny.Int = _dafny.IntOfInt64(100)
			_ = _hi0
			for _4_i := _dafny.Zero; _4_i.Cmp(_hi0) < 0; _4_i = _4_i.Plus(_dafny.One) {
				{
					var _5_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsDynamodbTypes.Companion_QueryOutput_.Default())
					_ = _5_valueOrError0
					var _out1 m_Wrappers.Result
					_ = _out1
					_out1 = (client).Query((_this).GetQueryInput(q, _1_usedNames, _2_usedValues, _3_lastKey))
					_5_valueOrError0 = _out1
					if !(!((_5_valueOrError0).IsFailure())) {
						panic("dafny/DDBEncryption/src/TestVectors.dfy(256,22): " + (_5_valueOrError0).String())
					}
					var _6_result m_ComAmazonawsDynamodbTypes.QueryOutput
					_ = _6_result
					_6_result = (_5_valueOrError0).Extract().(m_ComAmazonawsDynamodbTypes.QueryOutput)
					if (((_6_result).Dtor_Items()).Is_Some()) && ((_dafny.IntOfUint32((((_6_result).Dtor_Items()).Dtor_value().(_dafny.Sequence)).Cardinality())).Sign() != 0) {
						output = _dafny.Companion_Sequence_.Concatenate(output, ((_6_result).Dtor_Items()).Dtor_value().(_dafny.Sequence))
					}
					if (((_6_result).Dtor_LastEvaluatedKey()).Is_Some()) && (((((_6_result).Dtor_LastEvaluatedKey()).Dtor_value().(_dafny.Map)).Cardinality()).Sign() == 1) {
						_3_lastKey = (_6_result).Dtor_LastEvaluatedKey()
						_dafny.Print((_dafny.SeqOfString("FullQuery had lastKey\n")).SetString())
					} else {
						goto L0
					}
					goto C0
				}
			C0:
			}
			goto L0
		}
	L0:
		return output
	}
}
func (_this TestVectorConfig) FullScan(client m_ComAmazonawsDynamodbTypes.IDynamoDBClient, q m_JsonConfig.SimpleQuery, names m_Wrappers.Option, values m_Wrappers.Option) _dafny.Sequence {
	{
		var output _dafny.Sequence = _dafny.EmptySeq
		_ = output
		var _0_zzz _dafny.Tuple
		_ = _0_zzz
		var _out0 _dafny.Tuple
		_ = _out0
		_out0 = (_this).GetUsed2(q, names, values)
		_0_zzz = _out0
		var _let_tmp_rhs0 _dafny.Tuple = _0_zzz
		_ = _let_tmp_rhs0
		var _1_usedNames _dafny.Map = (*(_let_tmp_rhs0).IndexInt(0)).(_dafny.Map)
		_ = _1_usedNames
		var _2_usedValues _dafny.Map = (*(_let_tmp_rhs0).IndexInt(1)).(_dafny.Map)
		_ = _2_usedValues
		output = _dafny.SeqOf()
		var _3_lastKey m_Wrappers.Option
		_ = _3_lastKey
		_3_lastKey = m_Wrappers.Companion_Option_.Create_None_()
		{
			var _hi0 _dafny.Int = _dafny.IntOfInt64(100)
			_ = _hi0
			for _4_i := _dafny.Zero; _4_i.Cmp(_hi0) < 0; _4_i = _4_i.Plus(_dafny.One) {
				{
					var _5_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsDynamodbTypes.Companion_ScanOutput_.Default())
					_ = _5_valueOrError0
					var _out1 m_Wrappers.Result
					_ = _out1
					_out1 = (client).Scan((_this).GetScanInput(q, _1_usedNames, _2_usedValues, _3_lastKey))
					_5_valueOrError0 = _out1
					if !(!((_5_valueOrError0).IsFailure())) {
						panic("dafny/DDBEncryption/src/TestVectors.dfy(281,22): " + (_5_valueOrError0).String())
					}
					var _6_result m_ComAmazonawsDynamodbTypes.ScanOutput
					_ = _6_result
					_6_result = (_5_valueOrError0).Extract().(m_ComAmazonawsDynamodbTypes.ScanOutput)
					if (((_6_result).Dtor_Items()).Is_Some()) && ((_dafny.IntOfUint32((((_6_result).Dtor_Items()).Dtor_value().(_dafny.Sequence)).Cardinality())).Sign() != 0) {
						output = _dafny.Companion_Sequence_.Concatenate(output, ((_6_result).Dtor_Items()).Dtor_value().(_dafny.Sequence))
					}
					if (((_6_result).Dtor_LastEvaluatedKey()).Is_Some()) && (((((_6_result).Dtor_LastEvaluatedKey()).Dtor_value().(_dafny.Map)).Cardinality()).Sign() == 1) {
						_3_lastKey = (_6_result).Dtor_LastEvaluatedKey()
					} else {
						goto L1
					}
					goto C1
				}
			C1:
			}
			goto L1
		}
	L1:
		return output
	}
}
func (_this TestVectorConfig) GetQueryInput(q m_JsonConfig.SimpleQuery, usedNames _dafny.Map, usedValues _dafny.Map, lastKey m_Wrappers.Option) m_ComAmazonawsDynamodbTypes.QueryInput {
	{
		return m_ComAmazonawsDynamodbTypes.Companion_QueryInput_.Create_QueryInput_(m_JsonConfig.Companion_Default___.TableName(), (q).Dtor_index(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), lastKey, m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), (q).Dtor_filterExpr(), (q).Dtor_keyExpr(), (func() m_Wrappers.Option {
			if ((usedNames).Cardinality()).Sign() == 0 {
				return m_Wrappers.Companion_Option_.Create_None_()
			}
			return m_Wrappers.Companion_Option_.Create_Some_(usedNames)
		})(), (func() m_Wrappers.Option {
			if ((usedValues).Cardinality()).Sign() == 0 {
				return m_Wrappers.Companion_Option_.Create_None_()
			}
			return m_Wrappers.Companion_Option_.Create_Some_(usedValues)
		})())
	}
}
func (_this TestVectorConfig) GetScanInput(q m_JsonConfig.SimpleQuery, usedNames _dafny.Map, usedValues _dafny.Map, lastKey m_Wrappers.Option) m_ComAmazonawsDynamodbTypes.ScanInput {
	{
		return m_ComAmazonawsDynamodbTypes.Companion_ScanInput_.Create_ScanInput_(m_JsonConfig.Companion_Default___.TableName(), (q).Dtor_index(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), lastKey, m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), (q).Dtor_filterExpr(), (func() m_Wrappers.Option {
			if ((usedNames).Cardinality()).Sign() == 0 {
				return m_Wrappers.Companion_Option_.Create_None_()
			}
			return m_Wrappers.Companion_Option_.Create_Some_(usedNames)
		})(), (func() m_Wrappers.Option {
			if ((usedValues).Cardinality()).Sign() == 0 {
				return m_Wrappers.Companion_Option_.Create_None_()
			}
			return m_Wrappers.Companion_Option_.Create_Some_(usedValues)
		})(), m_Wrappers.Companion_Option_.Create_None_())
	}
}
func (_this TestVectorConfig) WriteAllRecords(client m_ComAmazonawsDynamodbTypes.IDynamoDBClient, records _dafny.Sequence) {
	{
		(_this).DeleteTable(client)
		var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsDynamodbTypes.Companion_CreateTableOutput_.Default())
		_ = _0_valueOrError0
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = (client).CreateTable((_this).Dtor_schemaOnEncrypt())
		_0_valueOrError0 = _out0
		if !(!((_0_valueOrError0).IsFailure())) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(356,16): " + (_0_valueOrError0).String())
		}
		var _1___v10 m_ComAmazonawsDynamodbTypes.CreateTableOutput
		_ = _1___v10
		_1___v10 = (_0_valueOrError0).Extract().(m_ComAmazonawsDynamodbTypes.CreateTableOutput)
		var _hi0 _dafny.Int = _dafny.IntOfUint32((records).Cardinality())
		_ = _hi0
		for _2_i := _dafny.Zero; _2_i.Cmp(_hi0) < 0; _2_i = _2_i.Plus(_dafny.One) {
			var _3_input m_ComAmazonawsDynamodbTypes.PutItemInput
			_ = _3_input
			_3_input = m_ComAmazonawsDynamodbTypes.Companion_PutItemInput_.Create_PutItemInput_(m_JsonConfig.Companion_Default___.TableName(), ((records).Select((_2_i).Uint32()).(m_JsonConfig.Record)).Dtor_item(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
			var _4_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsDynamodbTypes.Companion_PutItemOutput_.Default())
			_ = _4_valueOrError1
			var _out1 m_Wrappers.Result
			_ = _out1
			_out1 = (client).PutItem(_3_input)
			_4_valueOrError1 = _out1
			if !(!((_4_valueOrError1).IsFailure())) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(370,18): " + (_4_valueOrError1).String())
			}
			var _5___v11 m_ComAmazonawsDynamodbTypes.PutItemOutput
			_ = _5___v11
			_5___v11 = (_4_valueOrError1).Extract().(m_ComAmazonawsDynamodbTypes.PutItemOutput)
		}
	}
}
func (_this TestVectorConfig) BasicIoTest() {
	{
		_dafny.Print((_dafny.SeqOfString("BasicIoTest\n")).SetString())
		var _hi0 _dafny.Int = _dafny.IntOfUint32(((_this).Dtor_configsForIoTest()).Cardinality())
		_ = _hi0
		for _0_x := _dafny.Zero; _0_x.Cmp(_hi0) < 0; _0_x = _0_x.Plus(_dafny.One) {
			if !(((_this).Dtor_tableEncryptionConfigs()).Contains((*(((_this).Dtor_configsForIoTest()).Select((_0_x).Uint32()).(_dafny.Tuple)).IndexInt(0)).(_dafny.Sequence))) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(378,8): " + (_dafny.SeqOfString("expectation violation")).String())
			}
			if !(((_this).Dtor_tableEncryptionConfigs()).Contains((*(((_this).Dtor_configsForIoTest()).Select((_0_x).Uint32()).(_dafny.Tuple)).IndexInt(1)).(_dafny.Sequence))) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(379,8): " + (_dafny.SeqOfString("expectation violation")).String())
			}
			var _1_c1 m_JsonConfig.TableConfig
			_ = _1_c1
			_1_c1 = ((_this).Dtor_tableEncryptionConfigs()).Get((*(((_this).Dtor_configsForIoTest()).Select((_0_x).Uint32()).(_dafny.Tuple)).IndexInt(0)).(_dafny.Sequence)).(m_JsonConfig.TableConfig)
			var _2_c2 m_JsonConfig.TableConfig
			_ = _2_c2
			_2_c2 = ((_this).Dtor_tableEncryptionConfigs()).Get((*(((_this).Dtor_configsForIoTest()).Select((_0_x).Uint32()).(_dafny.Tuple)).IndexInt(1)).(_dafny.Sequence)).(m_JsonConfig.TableConfig)
			(_this).BasicIoTestBatchWriteItem(_1_c1, _2_c2, (_this).Dtor_globalRecords())
			(_this).BasicIoTestPutItem(_1_c1, _2_c2, (_this).Dtor_globalRecords())
			(_this).BasicIoTestTransactWriteItems(_1_c1, _2_c2, (_this).Dtor_globalRecords())
		}
	}
}
func (_this TestVectorConfig) RunIoTests() {
	{
		_dafny.Print((_dafny.SeqOfString("RunIoTests\n")).SetString())
		var _hi0 _dafny.Int = _dafny.IntOfUint32(((_this).Dtor_ioTests()).Cardinality())
		_ = _hi0
		for _0_i := _dafny.Zero; _0_i.Cmp(_hi0) < 0; _0_i = _0_i.Plus(_dafny.One) {
			(_this).BasicIoTestBatchWriteItem((((_this).Dtor_ioTests()).Select((_0_i).Uint32()).(m_JsonConfig.IoTest)).Dtor_writeConfig(), (((_this).Dtor_ioTests()).Select((_0_i).Uint32()).(m_JsonConfig.IoTest)).Dtor_readConfig(), (((_this).Dtor_ioTests()).Select((_0_i).Uint32()).(m_JsonConfig.IoTest)).Dtor_records())
			(_this).BasicIoTestPutItem((((_this).Dtor_ioTests()).Select((_0_i).Uint32()).(m_JsonConfig.IoTest)).Dtor_writeConfig(), (((_this).Dtor_ioTests()).Select((_0_i).Uint32()).(m_JsonConfig.IoTest)).Dtor_readConfig(), (((_this).Dtor_ioTests()).Select((_0_i).Uint32()).(m_JsonConfig.IoTest)).Dtor_records())
			(_this).BasicIoTestTransactWriteItems((((_this).Dtor_ioTests()).Select((_0_i).Uint32()).(m_JsonConfig.IoTest)).Dtor_writeConfig(), (((_this).Dtor_ioTests()).Select((_0_i).Uint32()).(m_JsonConfig.IoTest)).Dtor_readConfig(), (((_this).Dtor_ioTests()).Select((_0_i).Uint32()).(m_JsonConfig.IoTest)).Dtor_records())
			var _1_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
			_ = _1_valueOrError0
			var _out0 m_Wrappers.Result
			_ = _out0
			_out0 = m_JsonConfig.Companion_Default___.NewGazelle((((_this).Dtor_ioTests()).Select((_0_i).Uint32()).(m_JsonConfig.IoTest)).Dtor_readConfig())
			_1_valueOrError0 = _out0
			if !(!((_1_valueOrError0).IsFailure())) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(396,23): " + (_1_valueOrError0).String())
			}
			var _2_rClient m_ComAmazonawsDynamodbTypes.IDynamoDBClient
			_ = _2_rClient
			_2_rClient = m_ComAmazonawsDynamodbTypes.Companion_IDynamoDBClient_.CastTo_((_1_valueOrError0).Extract())
			var _hi1 _dafny.Int = _dafny.IntOfUint32(((((_this).Dtor_ioTests()).Select((_0_i).Uint32()).(m_JsonConfig.IoTest)).Dtor_queries()).Cardinality())
			_ = _hi1
			for _3_j := _dafny.Zero; _3_j.Cmp(_hi1) < 0; _3_j = _3_j.Plus(_dafny.One) {
				var _4_results _dafny.Sequence
				_ = _4_results
				var _out1 _dafny.Sequence
				_ = _out1
				_out1 = (_this).FullSearch(_2_rClient, ((((_this).Dtor_ioTests()).Select((_0_i).Uint32()).(m_JsonConfig.IoTest)).Dtor_queries()).Select((_3_j).Uint32()).(m_JsonConfig.SimpleQuery), m_Wrappers.Companion_Option_.Create_Some_((((_this).Dtor_ioTests()).Select((_0_i).Uint32()).(m_JsonConfig.IoTest)).Dtor_names()), m_Wrappers.Companion_Option_.Create_Some_((((_this).Dtor_ioTests()).Select((_0_i).Uint32()).(m_JsonConfig.IoTest)).Dtor_values()))
				_4_results = _out1
			}
		}
	}
}
func (_this TestVectorConfig) ConfigModTest() {
	{
		_dafny.Print((_dafny.SeqOfString("ConfigModTest\n")).SetString())
		var _hi0 _dafny.Int = _dafny.IntOfUint32(((_this).Dtor_configsForModTest()).Cardinality())
		_ = _hi0
		for _0_x := _dafny.Zero; _0_x.Cmp(_hi0) < 0; _0_x = _0_x.Plus(_dafny.One) {
			if !(((_this).Dtor_tableEncryptionConfigs()).Contains((*(((_this).Dtor_configsForModTest()).Select((_0_x).Uint32()).(_dafny.Tuple)).IndexInt(0)).(_dafny.Sequence))) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(407,8): " + (_dafny.SeqOfString("expectation violation")).String())
			}
			if !(((_this).Dtor_tableEncryptionConfigs()).Contains((*(((_this).Dtor_configsForModTest()).Select((_0_x).Uint32()).(_dafny.Tuple)).IndexInt(1)).(_dafny.Sequence))) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(408,8): " + (_dafny.SeqOfString("expectation violation")).String())
			}
			(_this).ConfigModPairTest(((_this).Dtor_tableEncryptionConfigs()).Get((*(((_this).Dtor_configsForModTest()).Select((_0_x).Uint32()).(_dafny.Tuple)).IndexInt(0)).(_dafny.Sequence)).(m_JsonConfig.TableConfig), ((_this).Dtor_tableEncryptionConfigs()).Get((*(((_this).Dtor_configsForModTest()).Select((_0_x).Uint32()).(_dafny.Tuple)).IndexInt(1)).(_dafny.Sequence)).(m_JsonConfig.TableConfig))
		}
	}
}
func (_this TestVectorConfig) ConfigModPairTest(x m_JsonConfig.TableConfig, y m_JsonConfig.TableConfig) {
	{
		_dafny.Print((_dafny.SeqOfString("ConfigModPairTest ")).SetString())
		_dafny.Print(((x).Dtor_name()).SetString())
		_dafny.Print((_dafny.SeqOfString(", ")).SetString())
		_dafny.Print(((y).Dtor_name()).SetString())
		_dafny.Print((_dafny.SeqOfString("\n")).SetString())
		var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _0_valueOrError0
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_JsonConfig.Companion_Default___.NewGazelle(x)
		_0_valueOrError0 = _out0
		if !(!((_0_valueOrError0).IsFailure())) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(416,21): " + (_0_valueOrError0).String())
		}
		var _1_client1 m_ComAmazonawsDynamodbTypes.IDynamoDBClient
		_ = _1_client1
		_1_client1 = m_ComAmazonawsDynamodbTypes.Companion_IDynamoDBClient_.CastTo_((_0_valueOrError0).Extract())
		var _2_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _2_valueOrError1
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = m_JsonConfig.Companion_Default___.NewGazelle(y)
		_2_valueOrError1 = _out1
		if !(!((_2_valueOrError1).IsFailure())) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(417,21): " + (_2_valueOrError1).String())
		}
		var _3_client2 m_ComAmazonawsDynamodbTypes.IDynamoDBClient
		_ = _3_client2
		_3_client2 = m_ComAmazonawsDynamodbTypes.Companion_IDynamoDBClient_.CastTo_((_2_valueOrError1).Extract())
		(_this).WriteAllRecords(_1_client1, (_this).Dtor_globalRecords())
		var _hi0 _dafny.Int = _dafny.IntOfUint32(((_this).Dtor_queries()).Cardinality())
		_ = _hi0
		for _4_i := _dafny.Zero; _4_i.Cmp(_hi0) < 0; _4_i = _4_i.Plus(_dafny.One) {
			if (!_dafny.Companion_Sequence_.Contains((((_this).Dtor_queries()).Select((_4_i).Uint32()).(m_JsonConfig.SimpleQuery)).Dtor_failConfigs(), (x).Dtor_name())) && (!_dafny.Companion_Sequence_.Contains((((_this).Dtor_queries()).Select((_4_i).Uint32()).(m_JsonConfig.SimpleQuery)).Dtor_failConfigs(), (y).Dtor_name())) {
				var _5_result1 _dafny.Sequence
				_ = _5_result1
				var _out2 _dafny.Sequence
				_ = _out2
				_out2 = (_this).FullSearch(_1_client1, ((_this).Dtor_queries()).Select((_4_i).Uint32()).(m_JsonConfig.SimpleQuery), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
				_5_result1 = _out2
				var _6_result2 _dafny.Sequence
				_ = _6_result2
				var _out3 _dafny.Sequence
				_ = _out3
				_out3 = (_this).FullSearch(_3_client2, ((_this).Dtor_queries()).Select((_4_i).Uint32()).(m_JsonConfig.SimpleQuery), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
				_6_result2 = _out3
				if !((_this).QueryOutputEqual(_5_result1, _6_result2)) {
					panic("dafny/DDBEncryption/src/TestVectors.dfy(423,10): " + (_dafny.SeqOfString("expectation violation")).String())
				}
			}
		}
	}
}
func (_this TestVectorConfig) ComplexTests() {
	{
		_dafny.Print((_dafny.SeqOfString("ComplexTests\n")).SetString())
		var _hi0 _dafny.Int = _dafny.IntOfUint32(((_this).Dtor_complexTests()).Cardinality())
		_ = _hi0
		for _0_i := _dafny.Zero; _0_i.Cmp(_hi0) < 0; _0_i = _0_i.Plus(_dafny.One) {
			(_this).DoComplexTest(((_this).Dtor_complexTests()).Select((_0_i).Uint32()).(m_JsonConfig.ComplexTest))
		}
	}
}
func (_this TestVectorConfig) InResult(num _dafny.Sequence, results _dafny.Sequence) bool {
	{
		var output bool = false
		_ = output
		var _hi0 _dafny.Int = _dafny.IntOfUint32((results).Cardinality())
		_ = _hi0
		for _0_i := _dafny.Zero; _0_i.Cmp(_hi0) < 0; _0_i = _0_i.Plus(_dafny.One) {
			var _1_item _dafny.Map
			_ = _1_item
			_1_item = (results).Select((_0_i).Uint32()).(_dafny.Map)
			if (((results).Select((_0_i).Uint32()).(_dafny.Map)).Contains(m_JsonConfig.Companion_Default___.HashName())) && ((((results).Select((_0_i).Uint32()).(_dafny.Map)).Get(m_JsonConfig.Companion_Default___.HashName()).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_N_(num))) {
				output = true
				return output
			}
		}
		output = false
		return output
		return output
	}
}
func (_this TestVectorConfig) DoComplexTest(test m_JsonConfig.ComplexTest) {
	{
		if !(((_this).Dtor_tableEncryptionConfigs()).Contains((test).Dtor_config())) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(449,6): " + (_dafny.SeqOfString("expectation violation")).String())
		}
		var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _0_valueOrError0
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_JsonConfig.Companion_Default___.NewGazelle(((_this).Dtor_tableEncryptionConfigs()).Get((test).Dtor_config()).(m_JsonConfig.TableConfig))
		_0_valueOrError0 = _out0
		if !(!((_0_valueOrError0).IsFailure())) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(450,20): " + (_0_valueOrError0).String())
		}
		var _1_client m_ComAmazonawsDynamodbTypes.IDynamoDBClient
		_ = _1_client
		_1_client = m_ComAmazonawsDynamodbTypes.Companion_IDynamoDBClient_.CastTo_((_0_valueOrError0).Extract())
		(_this).WriteAllRecords(_1_client, (_this).Dtor_globalRecords())
		var _hi0 _dafny.Int = _dafny.IntOfUint32(((test).Dtor_failures()).Cardinality())
		_ = _hi0
		for _2_i := _dafny.Zero; _2_i.Cmp(_hi0) < 0; _2_i = _2_i.Plus(_dafny.One) {
			var _let_tmp_rhs0 _dafny.Tuple = (_this).GetUsed(((test).Dtor_failures()).Select((_2_i).Uint32()).(m_JsonConfig.SimpleQuery))
			_ = _let_tmp_rhs0
			var _3_usedNames _dafny.Map = (*(_let_tmp_rhs0).IndexInt(0)).(_dafny.Map)
			_ = _3_usedNames
			var _4_usedValues _dafny.Map = (*(_let_tmp_rhs0).IndexInt(1)).(_dafny.Map)
			_ = _4_usedValues
			var _5_result m_Wrappers.Result
			_ = _5_result
			var _out1 m_Wrappers.Result
			_ = _out1
			_out1 = (_1_client).Query((_this).GetQueryInput(((test).Dtor_failures()).Select((_2_i).Uint32()).(m_JsonConfig.SimpleQuery), _3_usedNames, _4_usedValues, m_Wrappers.Companion_Option_.Create_None_()))
			_5_result = _out1
			if !((_5_result).Is_Failure()) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(456,8): " + (_dafny.SeqOfString("expectation violation")).String())
			}
		}
		var _hi1 _dafny.Int = _dafny.IntOfUint32(((test).Dtor_queries()).Cardinality())
		_ = _hi1
		for _6_i := _dafny.Zero; _6_i.Cmp(_hi1) < 0; _6_i = _6_i.Plus(_dafny.One) {
			var _7_result _dafny.Sequence
			_ = _7_result
			var _out2 _dafny.Sequence
			_ = _out2
			_out2 = (_this).FullSearch(_1_client, (((test).Dtor_queries()).Select((_6_i).Uint32()).(m_JsonConfig.ComplexQuery)).Dtor_query(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
			_7_result = _out2
			var _hi2 _dafny.Int = _dafny.IntOfUint32(((((test).Dtor_queries()).Select((_6_i).Uint32()).(m_JsonConfig.ComplexQuery)).Dtor_pass()).Cardinality())
			_ = _hi2
			for _8_j := _dafny.Zero; _8_j.Cmp(_hi2) < 0; _8_j = _8_j.Plus(_dafny.One) {
				var _9_res bool
				_ = _9_res
				var _out3 bool
				_ = _out3
				_out3 = (_this).InResult(((((test).Dtor_queries()).Select((_6_i).Uint32()).(m_JsonConfig.ComplexQuery)).Dtor_pass()).Select((_8_j).Uint32()).(_dafny.Sequence), _7_result)
				_9_res = _out3
				if !(_9_res) {
					_dafny.Print((_dafny.SeqOfString("Failure in DoComplexTest.\n")).SetString())
					_dafny.Print((((test).Dtor_queries()).Select((_6_i).Uint32()).(m_JsonConfig.ComplexQuery)).Dtor_query())
					_dafny.Print((_dafny.SeqOfString("\n had ")).SetString())
					_dafny.Print(_dafny.IntOfUint32((_7_result).Cardinality()))
					_dafny.Print((_dafny.SeqOfString(" results. Failed to include ")).SetString())
					_dafny.Print((((((test).Dtor_queries()).Select((_6_i).Uint32()).(m_JsonConfig.ComplexQuery)).Dtor_pass()).Select((_8_j).Uint32()).(_dafny.Sequence)).SetString())
					_dafny.Print((_dafny.SeqOfString("\n")).SetString())
				}
				if !(_9_res) {
					panic("dafny/DDBEncryption/src/TestVectors.dfy(466,10): " + (_dafny.SeqOfString("expectation violation")).String())
				}
			}
			var _hi3 _dafny.Int = _dafny.IntOfUint32(((((test).Dtor_queries()).Select((_6_i).Uint32()).(m_JsonConfig.ComplexQuery)).Dtor_fail()).Cardinality())
			_ = _hi3
			for _10_j := _dafny.Zero; _10_j.Cmp(_hi3) < 0; _10_j = _10_j.Plus(_dafny.One) {
				var _11_res bool
				_ = _11_res
				var _out4 bool
				_ = _out4
				_out4 = (_this).InResult(((((test).Dtor_queries()).Select((_6_i).Uint32()).(m_JsonConfig.ComplexQuery)).Dtor_fail()).Select((_10_j).Uint32()).(_dafny.Sequence), _7_result)
				_11_res = _out4
				if _11_res {
					_dafny.Print((_dafny.SeqOfString("Failure in DoComplexTest.\n")).SetString())
					_dafny.Print((((test).Dtor_queries()).Select((_6_i).Uint32()).(m_JsonConfig.ComplexQuery)).Dtor_query())
					_dafny.Print((_dafny.SeqOfString("\n had ")).SetString())
					_dafny.Print(_dafny.IntOfUint32((_7_result).Cardinality()))
					_dafny.Print((_dafny.SeqOfString(" results. Erroneously included ")).SetString())
					_dafny.Print((((((test).Dtor_queries()).Select((_6_i).Uint32()).(m_JsonConfig.ComplexQuery)).Dtor_fail()).Select((_10_j).Uint32()).(_dafny.Sequence)).SetString())
					_dafny.Print((_dafny.SeqOfString("\n")).SetString())
				}
				if !(!(_11_res)) {
					panic("dafny/DDBEncryption/src/TestVectors.dfy(474,10): " + (_dafny.SeqOfString("expectation violation")).String())
				}
			}
		}
	}
}
func (_this TestVectorConfig) WriteTests() {
	{
		_dafny.Print((_dafny.SeqOfString("WriteTests\n")).SetString())
		var _hi0 _dafny.Int = _dafny.IntOfUint32(((_this).Dtor_writeTests()).Cardinality())
		_ = _hi0
		for _0_i := _dafny.Zero; _0_i.Cmp(_hi0) < 0; _0_i = _0_i.Plus(_dafny.One) {
			var _1_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
			_ = _1_valueOrError0
			var _out0 m_Wrappers.Result
			_ = _out0
			_out0 = m_JsonConfig.Companion_Default___.NewGazelle((((_this).Dtor_writeTests()).Select((_0_i).Uint32()).(m_JsonConfig.WriteTest)).Dtor_config())
			_1_valueOrError0 = _out0
			if !(!((_1_valueOrError0).IsFailure())) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(483,22): " + (_1_valueOrError0).String())
			}
			var _2_client m_ComAmazonawsDynamodbTypes.IDynamoDBClient
			_ = _2_client
			_2_client = m_ComAmazonawsDynamodbTypes.Companion_IDynamoDBClient_.CastTo_((_1_valueOrError0).Extract())
			(_this).WriteAllRecords(_2_client, (((_this).Dtor_writeTests()).Select((_0_i).Uint32()).(m_JsonConfig.WriteTest)).Dtor_records())
			var _3_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
			_ = _3_valueOrError1
			var _out1 m_Wrappers.Result
			_ = _out1
			_out1 = m_CreateInterceptedDDBClient.CreateVanillaDDBClient()
			_3_valueOrError1 = _out1
			if !(!((_3_valueOrError1).IsFailure())) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(485,29): " + (_3_valueOrError1).String())
			}
			var _4_vanillaClient m_ComAmazonawsDynamodbTypes.IDynamoDBClient
			_ = _4_vanillaClient
			_4_vanillaClient = m_ComAmazonawsDynamodbTypes.Companion_IDynamoDBClient_.CastTo_((_3_valueOrError1).Extract())
			var _5_encRecords _dafny.Sequence
			_ = _5_encRecords
			var _out2 _dafny.Sequence
			_ = _out2
			_out2 = (_this).ReadAllRecords(_4_vanillaClient)
			_5_encRecords = _out2
			if !((_dafny.IntOfUint32((_5_encRecords).Cardinality())).Cmp(_dafny.IntOfUint32(((((_this).Dtor_writeTests()).Select((_0_i).Uint32()).(m_JsonConfig.WriteTest)).Dtor_records()).Cardinality())) == 0) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(487,8): " + (_dafny.SeqOfString("expectation violation")).String())
			}
			(_this).WriteJsonRecords(_5_encRecords, (((_this).Dtor_writeTests()).Select((_0_i).Uint32()).(m_JsonConfig.WriteTest)).Dtor_fileName())
		}
	}
}
func (_this TestVectorConfig) DoTestConfig(name _dafny.Sequence) bool {
	{
		return (((_this).TestConfigs()).Contains(_dafny.SeqOfString("all"))) || (((_this).TestConfigs()).Contains(name))
	}
}
func (_this TestVectorConfig) DoTestRecord(name _dafny.Sequence) bool {
	{
		return (((_this).TestRecords()).Contains(_dafny.SeqOfString("all"))) || (((_this).TestRecords()).Contains(name))
	}
}
func (_this TestVectorConfig) LargeTests() {
	{
		_dafny.Print((_dafny.SeqOfString("LargeTests\n")).SetString())
		(_this).DoLargeTest(_dafny.SeqOfString("do_nothing"))
		(_this).DoLargeTest(_dafny.SeqOfString("do_nothing_nosign"))
		(_this).DoLargeTest(_dafny.SeqOfString("full_encrypt"))
		(_this).DoLargeTest(_dafny.SeqOfString("full_encrypt_nosign"))
		(_this).DoLargeTest(_dafny.SeqOfString("full_sign"))
		(_this).DoLargeTest(_dafny.SeqOfString("full_sign_nosign"))
	}
}
func (_this TestVectorConfig) DoLargeTest(config _dafny.Sequence) {
	{
		if !((_this).DoTestConfig(config)) {
			return
		}
		if !(((_this).Dtor_largeEncryptionConfigs()).Contains(config)) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(521,6): " + (_dafny.SeqOfString("expectation violation")).String())
		}
		var _0_tconfig m_JsonConfig.TableConfig
		_ = _0_tconfig
		_0_tconfig = ((_this).Dtor_largeEncryptionConfigs()).Get(config).(m_JsonConfig.TableConfig)
		var _1_configs m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTablesEncryptionConfig
		_ = _1_configs
		_1_configs = m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_DynamoDbTablesEncryptionConfig_.Create_DynamoDbTablesEncryptionConfig_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(m_JsonConfig.Companion_Default___.TableName(), (_0_tconfig).Dtor_config()))
		var _2_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _2_valueOrError0
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_DynamoDbEncryptionTransforms.Companion_Default___.DynamoDbEncryptionTransforms(_1_configs)
		_2_valueOrError0 = _out0
		if !(!((_2_valueOrError0).IsFailure())) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(528,20): " + (_2_valueOrError0).String())
		}
		var _3_client *m_DynamoDbEncryptionTransforms.DynamoDbEncryptionTransformsClient
		_ = _3_client
		_3_client = (_2_valueOrError0).Extract().(*m_DynamoDbEncryptionTransforms.DynamoDbEncryptionTransformsClient)
		(_this).LargeTestsClient(_3_client, config)
	}
}
func (_this TestVectorConfig) LargeTestsClient(client m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.IDynamoDbEncryptionTransformsClient, config _dafny.Sequence) {
	{
		var _hi0 _dafny.Int = _dafny.IntOfUint32(((_this).Dtor_large()).Cardinality())
		_ = _hi0
		for _0_i := _dafny.Zero; _0_i.Cmp(_hi0) < 0; _0_i = _0_i.Plus(_dafny.One) {
			(_this).RunLargeTest(((_this).Dtor_large()).Select((_0_i).Uint32()).(m_JsonConfig.LargeRecord), client, config)
		}
	}
}
func (_this TestVectorConfig) RunLargeTest(record m_JsonConfig.LargeRecord, client m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.IDynamoDbEncryptionTransformsClient, config _dafny.Sequence) {
	{
		if !((_this).DoTestRecord((record).Dtor_name())) {
			return
		}
		var _0_time m__Time.AbsoluteTime
		_ = _0_time
		var _out0 m__Time.AbsoluteTime
		_ = _out0
		_out0 = m__Time.Companion_Default___.GetAbsoluteTime()
		_0_time = _out0
		var _hi0 uint32 = Companion_Default___.PerfIterations()
		_ = _hi0
		for _1_i := uint32(0); _1_i < _hi0; _1_i++ {
			var _2_put__input__input m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.PutItemInputTransformInput
			_ = _2_put__input__input
			_2_put__input__input = m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Companion_PutItemInputTransformInput_.Create_PutItemInputTransformInput_(m_ComAmazonawsDynamodbTypes.Companion_PutItemInput_.Create_PutItemInput_(m_JsonConfig.Companion_Default___.TableName(), (record).Dtor_item(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_()))
			var _3_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
			_ = _3_valueOrError0
			var _out1 m_Wrappers.Result
			_ = _out1
			_out1 = (client).PutItemInputTransform(_2_put__input__input)
			_3_valueOrError0 = _out1
			if !(!((_3_valueOrError0).IsFailure())) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(554,32): " + (_3_valueOrError0).String())
			}
			var _4_put__input__output m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.PutItemInputTransformOutput
			_ = _4_put__input__output
			_4_put__input__output = (_3_valueOrError0).Extract().(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.PutItemInputTransformOutput)
		}
		m__Time.Companion_Default___.PrintTimeSinceLong(_0_time, _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Large Encrypt "), (record).Dtor_name()), _dafny.SeqOfString(" ")), config), m_DecryptManifest.Companion_Default___.LogFileName())
		var _5_put__input__input m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.PutItemInputTransformInput
		_ = _5_put__input__input
		_5_put__input__input = m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Companion_PutItemInputTransformInput_.Create_PutItemInputTransformInput_(m_ComAmazonawsDynamodbTypes.Companion_PutItemInput_.Create_PutItemInput_(m_JsonConfig.Companion_Default___.TableName(), (record).Dtor_item(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_()))
		var _6_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _6_valueOrError1
		var _out2 m_Wrappers.Result
		_ = _out2
		_out2 = (client).PutItemInputTransform(_5_put__input__input)
		_6_valueOrError1 = _out2
		if !(!((_6_valueOrError1).IsFailure())) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(559,30): " + (_6_valueOrError1).String())
		}
		var _7_put__input__output m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.PutItemInputTransformOutput
		_ = _7_put__input__output
		_7_put__input__output = (_6_valueOrError1).Extract().(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.PutItemInputTransformOutput)
		var _out3 m__Time.AbsoluteTime
		_ = _out3
		_out3 = m__Time.Companion_Default___.GetAbsoluteTime()
		_0_time = _out3
		var _hi1 uint32 = Companion_Default___.PerfIterations()
		_ = _hi1
		for _8_i := uint32(0); _8_i < _hi1; _8_i++ {
			var _9_orig__get__input m_ComAmazonawsDynamodbTypes.GetItemInput
			_ = _9_orig__get__input
			_9_orig__get__input = m_ComAmazonawsDynamodbTypes.Companion_GetItemInput_.Create_GetItemInput_(m_JsonConfig.Companion_Default___.TableName(), _dafny.NewMapBuilder().ToMap(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
			var _10_get__output m_ComAmazonawsDynamodbTypes.GetItemOutput
			_ = _10_get__output
			_10_get__output = m_ComAmazonawsDynamodbTypes.Companion_GetItemOutput_.Create_GetItemOutput_(m_Wrappers.Companion_Option_.Create_Some_(((_7_put__input__output).Dtor_transformedInput()).Dtor_Item()), m_Wrappers.Companion_Option_.Create_None_())
			var _11_trans__get__input m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.GetItemOutputTransformInput
			_ = _11_trans__get__input
			_11_trans__get__input = m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Companion_GetItemOutputTransformInput_.Create_GetItemOutputTransformInput_(_10_get__output, _9_orig__get__input)
			var _12_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.Companion_GetItemOutputTransformOutput_.Default())
			_ = _12_valueOrError2
			var _out4 m_Wrappers.Result
			_ = _out4
			_out4 = (client).GetItemOutputTransform(_11_trans__get__input)
			_12_valueOrError2 = _out4
			if !(!((_12_valueOrError2).IsFailure())) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(565,26): " + (_12_valueOrError2).String())
			}
			var _13_put__output m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.GetItemOutputTransformOutput
			_ = _13_put__output
			_13_put__output = (_12_valueOrError2).Extract().(m_AwsCryptographyDbEncryptionSdkDynamoDbTransformsTypes.GetItemOutputTransformOutput)
		}
		m__Time.Companion_Default___.PrintTimeSinceLong(_0_time, _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Large Decrypt "), (record).Dtor_name()), _dafny.SeqOfString(" ")), config), m_DecryptManifest.Companion_Default___.LogFileName())
	}
}
func (_this TestVectorConfig) RoundTripTests() {
	{
		_dafny.Print((_dafny.SeqOfString("RoundTripTests\n")).SetString())
		var _hi0 _dafny.Int = _dafny.IntOfUint32(((_this).Dtor_roundTripTests()).Cardinality())
		_ = _hi0
		for _0_i := _dafny.Zero; _0_i.Cmp(_hi0) < 0; _0_i = _0_i.Plus(_dafny.One) {
			var _1_configs _dafny.Map
			_ = _1_configs
			_1_configs = (((_this).Dtor_roundTripTests()).Select((_0_i).Uint32()).(m_JsonConfig.RoundTripTest)).Dtor_configs()
			var _2_records _dafny.Sequence
			_ = _2_records
			_2_records = (((_this).Dtor_roundTripTests()).Select((_0_i).Uint32()).(m_JsonConfig.RoundTripTest)).Dtor_records()
			var _3_keys _dafny.Sequence
			_ = _3_keys
			_3_keys = m_SortedSets.SetToOrderedSequence2((_1_configs).Keys(), func(coer11 func(_dafny.Char, _dafny.Char) bool) func(interface{}, interface{}) bool {
				return func(arg14 interface{}, arg15 interface{}) bool {
					return coer11(arg14.(_dafny.Char), arg15.(_dafny.Char))
				}
			}(m_DynamoDbEncryptionUtil.Companion_Default___.CharLess))
			var _hi1 _dafny.Int = _dafny.IntOfUint32((_3_keys).Cardinality())
			_ = _hi1
			for _4_j := _dafny.Zero; _4_j.Cmp(_hi1) < 0; _4_j = _4_j.Plus(_dafny.One) {
				var _5_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
				_ = _5_valueOrError0
				var _out0 m_Wrappers.Result
				_ = _out0
				_out0 = m_JsonConfig.Companion_Default___.NewGazelle((_1_configs).Get((_3_keys).Select((_4_j).Uint32()).(_dafny.Sequence)).(m_JsonConfig.TableConfig))
				_5_valueOrError0 = _out0
				if !(!((_5_valueOrError0).IsFailure())) {
					panic("dafny/DDBEncryption/src/TestVectors.dfy(581,24): " + (_5_valueOrError0).String())
				}
				var _6_client m_ComAmazonawsDynamodbTypes.IDynamoDBClient
				_ = _6_client
				_6_client = m_ComAmazonawsDynamodbTypes.Companion_IDynamoDBClient_.CastTo_((_5_valueOrError0).Extract())
				var _hi2 _dafny.Int = _dafny.IntOfUint32((_2_records).Cardinality())
				_ = _hi2
				for _7_k := _dafny.Zero; _7_k.Cmp(_hi2) < 0; _7_k = _7_k.Plus(_dafny.One) {
					(_this).OneRoundTripTest(_6_client, (_2_records).Select((_7_k).Uint32()).(m_JsonConfig.Record))
				}
			}
		}
	}
}
func (_this TestVectorConfig) OneRoundTripTest(client m_ComAmazonawsDynamodbTypes.IDynamoDBClient, record m_JsonConfig.Record) {
	{
		var _0_putInput m_ComAmazonawsDynamodbTypes.PutItemInput
		_ = _0_putInput
		_0_putInput = m_ComAmazonawsDynamodbTypes.Companion_PutItemInput_.Create_PutItemInput_(m_JsonConfig.Companion_Default___.TableName(), (record).Dtor_item(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
		var _1_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsDynamodbTypes.Companion_PutItemOutput_.Default())
		_ = _1_valueOrError0
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = (client).PutItem(_0_putInput)
		_1_valueOrError0 = _out0
		if !(!((_1_valueOrError0).IsFailure())) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(606,16): " + (_1_valueOrError0).String())
		}
		var _2___v12 m_ComAmazonawsDynamodbTypes.PutItemOutput
		_ = _2___v12
		_2___v12 = (_1_valueOrError0).Extract().(m_ComAmazonawsDynamodbTypes.PutItemOutput)
		if !(((record).Dtor_item()).Contains(m_JsonConfig.Companion_Default___.HashName())) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(607,6): " + (_dafny.SeqOfString("expectation violation")).String())
		}
		var _3_getInput m_ComAmazonawsDynamodbTypes.GetItemInput
		_ = _3_getInput
		_3_getInput = m_ComAmazonawsDynamodbTypes.Companion_GetItemInput_.Create_GetItemInput_(m_JsonConfig.Companion_Default___.TableName(), _dafny.NewMapBuilder().ToMap().UpdateUnsafe(m_JsonConfig.Companion_Default___.HashName(), ((record).Dtor_item()).Get(m_JsonConfig.Companion_Default___.HashName()).(m_ComAmazonawsDynamodbTypes.AttributeValue)), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
		var _4_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsDynamodbTypes.Companion_GetItemOutput_.Default())
		_ = _4_valueOrError1
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = (client).GetItem(_3_getInput)
		_4_valueOrError1 = _out1
		if !(!((_4_valueOrError1).IsFailure())) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(617,17): " + (_4_valueOrError1).String())
		}
		var _5_out m_ComAmazonawsDynamodbTypes.GetItemOutput
		_ = _5_out
		_5_out = (_4_valueOrError1).Extract().(m_ComAmazonawsDynamodbTypes.GetItemOutput)
		if !(((_5_out).Dtor_Item()).Is_Some()) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(618,6): " + (_dafny.SeqOfString("expectation violation")).String())
		}
		if !(m_DdbItemJson.Companion_Default___.NormalizeItem(((_5_out).Dtor_Item()).Dtor_value().(_dafny.Map))).Equals(m_DdbItemJson.Companion_Default___.NormalizeItem((record).Dtor_item())) {
			_dafny.Print((_dafny.SeqOfString("\n")).SetString())
			_dafny.Print(m_DdbItemJson.Companion_Default___.NormalizeItem(((_5_out).Dtor_Item()).Dtor_value().(_dafny.Map)))
			_dafny.Print((_dafny.SeqOfString("\n")).SetString())
			_dafny.Print(m_DdbItemJson.Companion_Default___.NormalizeItem((record).Dtor_item()))
			_dafny.Print((_dafny.SeqOfString("\n")).SetString())
		}
		if !((m_DdbItemJson.Companion_Default___.NormalizeItem(((_5_out).Dtor_Item()).Dtor_value().(_dafny.Map))).Equals(m_DdbItemJson.Companion_Default___.NormalizeItem((record).Dtor_item()))) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(622,6): " + (_dafny.SeqOfString("expectation violation")).String())
		}
	}
}
func (_this TestVectorConfig) DecryptTests() {
	{
		_dafny.Print((_dafny.SeqOfString("DecryptTests\n")).SetString())
		var _hi0 _dafny.Int = _dafny.IntOfUint32(((_this).Dtor_decryptTests()).Cardinality())
		_ = _hi0
		for _0_i := _dafny.Zero; _0_i.Cmp(_hi0) < 0; _0_i = _0_i.Plus(_dafny.One) {
			var _1_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
			_ = _1_valueOrError0
			var _out0 m_Wrappers.Result
			_ = _out0
			_out0 = m_CreateInterceptedDDBClient.CreateVanillaDDBClient()
			_1_valueOrError0 = _out0
			if !(!((_1_valueOrError0).IsFailure())) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(630,29): " + (_1_valueOrError0).String())
			}
			var _2_vanillaClient m_ComAmazonawsDynamodbTypes.IDynamoDBClient
			_ = _2_vanillaClient
			_2_vanillaClient = m_ComAmazonawsDynamodbTypes.Companion_IDynamoDBClient_.CastTo_((_1_valueOrError0).Extract())
			(_this).WriteAllRecords(_2_vanillaClient, (((_this).Dtor_decryptTests()).Select((_0_i).Uint32()).(m_JsonConfig.DecryptTest)).Dtor_encryptedRecords())
			var _3_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
			_ = _3_valueOrError1
			var _out1 m_Wrappers.Result
			_ = _out1
			_out1 = m_JsonConfig.Companion_Default___.NewGazelle((((_this).Dtor_decryptTests()).Select((_0_i).Uint32()).(m_JsonConfig.DecryptTest)).Dtor_config())
			_3_valueOrError1 = _out1
			if !(!((_3_valueOrError1).IsFailure())) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(632,22): " + (_3_valueOrError1).String())
			}
			var _4_client m_ComAmazonawsDynamodbTypes.IDynamoDBClient
			_ = _4_client
			_4_client = m_ComAmazonawsDynamodbTypes.Companion_IDynamoDBClient_.CastTo_((_3_valueOrError1).Extract())
			var _5_plainRecords _dafny.Sequence
			_ = _5_plainRecords
			var _out2 _dafny.Sequence
			_ = _out2
			_out2 = (_this).ReadAllRecords(_4_client)
			_5_plainRecords = _out2
			if !((_dafny.IntOfUint32((_5_plainRecords).Cardinality())).Cmp(_dafny.IntOfUint32(((((_this).Dtor_decryptTests()).Select((_0_i).Uint32()).(m_JsonConfig.DecryptTest)).Dtor_plaintextRecords()).Cardinality())) == 0) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(634,8): " + (_dafny.SeqOfString("expectation violation")).String())
			}
			(_this).CompareRecordsDisordered((((_this).Dtor_decryptTests()).Select((_0_i).Uint32()).(m_JsonConfig.DecryptTest)).Dtor_plaintextRecords(), _5_plainRecords)
		}
	}
}
func (_this TestVectorConfig) WriteJsonRecords(records _dafny.Sequence, fileName _dafny.Sequence) {
	{
		var _0_jsonItems _dafny.Sequence
		_ = _0_jsonItems
		_0_jsonItems = _dafny.SeqOf()
		var _hi0 _dafny.Int = _dafny.IntOfUint32((records).Cardinality())
		_ = _hi0
		for _1_i := _dafny.Zero; _1_i.Cmp(_hi0) < 0; _1_i = _1_i.Plus(_dafny.One) {
			var _2_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_JSON_Values.Companion_JSON_.Default())
			_ = _2_valueOrError0
			var _out0 m_Wrappers.Result
			_ = _out0
			_out0 = m_DdbItemJson.Companion_Default___.DdbItemToJson((records).Select((_1_i).Uint32()).(_dafny.Map))
			_2_valueOrError0 = _out0
			if !(!((_2_valueOrError0).IsFailure())) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(643,20): " + (_2_valueOrError0).String())
			}
			var _3_item m_JSON_Values.JSON
			_ = _3_item
			_3_item = (_2_valueOrError0).Extract().(m_JSON_Values.JSON)
			_0_jsonItems = _dafny.Companion_Sequence_.Concatenate(_0_jsonItems, _dafny.SeqOf(_3_item))
		}
		var _4_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _4_valueOrError1
		_4_valueOrError1 = m_JSON_API.Companion_Default___.Serialize(m_JSON_Values.Companion_JSON_.Create_Array_(_0_jsonItems))
		if !(!((_4_valueOrError1).IsFailure())) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(646,23): " + (_4_valueOrError1).String())
		}
		var _5_jsonBytes _dafny.Sequence
		_ = _5_jsonBytes
		_5_jsonBytes = (_4_valueOrError1).Extract().(_dafny.Sequence)
		var _6_x m_Wrappers.Result
		_ = _6_x
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = m_FileIO.Companion_Default___.WriteBytesToFile(fileName, _5_jsonBytes)
		_6_x = _out1
		if !((_6_x).Is_Success()) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(648,6): " + (_dafny.SeqOfString("expectation violation")).String())
		}
	}
}
func (_this TestVectorConfig) BasicQueryTest() {
	{
		_dafny.Print((_dafny.SeqOfString("BasicQueryTest\n")).SetString())
		var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _0_valueOrError0
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_CreateInterceptedDDBClient.CreateVanillaDDBClient()
		_0_valueOrError0 = _out0
		if !(!((_0_valueOrError0).IsFailure())) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(655,20): " + (_0_valueOrError0).String())
		}
		var _1_client m_ComAmazonawsDynamodbTypes.IDynamoDBClient
		_ = _1_client
		_1_client = m_ComAmazonawsDynamodbTypes.Companion_IDynamoDBClient_.CastTo_((_0_valueOrError0).Extract())
		(_this).WriteAllRecords(_1_client, (_this).Dtor_globalRecords())
		var _hi0 _dafny.Int = _dafny.IntOfUint32(((_this).Dtor_failingQueries()).Cardinality())
		_ = _hi0
		for _2_i := _dafny.Zero; _2_i.Cmp(_hi0) < 0; _2_i = _2_i.Plus(_dafny.One) {
			var _let_tmp_rhs0 _dafny.Tuple = (_this).GetUsed(((_this).Dtor_failingQueries()).Select((_2_i).Uint32()).(m_JsonConfig.SimpleQuery))
			_ = _let_tmp_rhs0
			var _3_usedNames _dafny.Map = (*(_let_tmp_rhs0).IndexInt(0)).(_dafny.Map)
			_ = _3_usedNames
			var _4_usedValues _dafny.Map = (*(_let_tmp_rhs0).IndexInt(1)).(_dafny.Map)
			_ = _4_usedValues
			var _5_res m_Wrappers.Result
			_ = _5_res
			var _out1 m_Wrappers.Result
			_ = _out1
			_out1 = (_1_client).Query((_this).GetQueryInput(((_this).Dtor_failingQueries()).Select((_2_i).Uint32()).(m_JsonConfig.SimpleQuery), _3_usedNames, _4_usedValues, m_Wrappers.Companion_Option_.Create_None_()))
			_5_res = _out1
			if !((_5_res).Is_Failure()) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(661,8): " + (_dafny.SeqOfString("expectation violation")).String())
			}
		}
		var _6_results _dafny.Array
		_ = _6_results
		var _len0_0 _dafny.Int = _dafny.IntOfUint32(((_this).Dtor_queries()).Cardinality())
		_ = _len0_0
		var _nw0 _dafny.Array
		_ = _nw0
		if _len0_0.Cmp(_dafny.Zero) == 0 {
			_nw0 = _dafny.NewArray(_len0_0)
		} else {
			var _init0 func(_dafny.Int) _dafny.Sequence = func(_7_i _dafny.Int) _dafny.Sequence {
				return _dafny.SeqOf()
			}
			_ = _init0
			var _element0_0 = _init0(_dafny.Zero)
			_ = _element0_0
			_nw0 = _dafny.NewArrayFromExample(_element0_0, nil, _len0_0)
			(_nw0).ArraySet1(_element0_0, 0)
			var _nativeLen0_0 = (_len0_0).Int()
			_ = _nativeLen0_0
			for _i0_0 := 1; _i0_0 < _nativeLen0_0; _i0_0++ {
				(_nw0).ArraySet1(_init0(_dafny.IntOf(_i0_0)), _i0_0)
			}
		}
		_6_results = _nw0
		var _hi1 _dafny.Int = _dafny.IntOfUint32(((_this).Dtor_queries()).Cardinality())
		_ = _hi1
		for _8_i := _dafny.Zero; _8_i.Cmp(_hi1) < 0; _8_i = _8_i.Plus(_dafny.One) {
			var _out2 _dafny.Sequence
			_ = _out2
			_out2 = (_this).FullSearch(_1_client, ((_this).Dtor_queries()).Select((_8_i).Uint32()).(m_JsonConfig.SimpleQuery), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
			(_6_results).ArraySet1(_out2, (_8_i).Int())
		}
		var _9_configs _dafny.Sequence
		_ = _9_configs
		_9_configs = m_SortedSets.SetToOrderedSequence2(((_this).Dtor_tableEncryptionConfigs()).Keys(), func(coer12 func(_dafny.Char, _dafny.Char) bool) func(interface{}, interface{}) bool {
			return func(arg16 interface{}, arg17 interface{}) bool {
				return coer12(arg16.(_dafny.Char), arg17.(_dafny.Char))
			}
		}(m_DynamoDbEncryptionUtil.Companion_Default___.CharLess))
		var _hi2 _dafny.Int = _dafny.IntOfUint32((_9_configs).Cardinality())
		_ = _hi2
		for _10_i := _dafny.Zero; _10_i.Cmp(_hi2) < 0; _10_i = _10_i.Plus(_dafny.One) {
			var _11_config _dafny.Sequence
			_ = _11_config
			_11_config = (_9_configs).Select((_10_i).Uint32()).(_dafny.Sequence)
			(_this).BasicQueryTestConfig(((_this).Dtor_tableEncryptionConfigs()).Get(_11_config).(m_JsonConfig.TableConfig), _6_results, (_this).Dtor_globalRecords())
		}
	}
}
func (_this TestVectorConfig) QueryOutputEqual(actual _dafny.Sequence, expected _dafny.Sequence) bool {
	{
		return _dafny.Companion_Sequence_.Equal(actual, expected)
	}
}
func (_this TestVectorConfig) BasicQueryTestConfig(config m_JsonConfig.TableConfig, expected _dafny.Array, records _dafny.Sequence) {
	{
		var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _0_valueOrError0
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_JsonConfig.Companion_Default___.NewGazelle(config)
		_0_valueOrError0 = _out0
		if !(!((_0_valueOrError0).IsFailure())) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(683,20): " + (_0_valueOrError0).String())
		}
		var _1_client m_ComAmazonawsDynamodbTypes.IDynamoDBClient
		_ = _1_client
		_1_client = m_ComAmazonawsDynamodbTypes.Companion_IDynamoDBClient_.CastTo_((_0_valueOrError0).Extract())
		(_this).WriteAllRecords(_1_client, records)
		var _hi0 _dafny.Int = _dafny.IntOfUint32(((_this).Dtor_failingQueries()).Cardinality())
		_ = _hi0
		for _2_i := _dafny.Zero; _2_i.Cmp(_hi0) < 0; _2_i = _2_i.Plus(_dafny.One) {
			var _let_tmp_rhs0 _dafny.Tuple = (_this).GetUsed(((_this).Dtor_failingQueries()).Select((_2_i).Uint32()).(m_JsonConfig.SimpleQuery))
			_ = _let_tmp_rhs0
			var _3_usedNames _dafny.Map = (*(_let_tmp_rhs0).IndexInt(0)).(_dafny.Map)
			_ = _3_usedNames
			var _4_usedValues _dafny.Map = (*(_let_tmp_rhs0).IndexInt(1)).(_dafny.Map)
			_ = _4_usedValues
			var _5_res m_Wrappers.Result
			_ = _5_res
			var _out1 m_Wrappers.Result
			_ = _out1
			_out1 = (_1_client).Query((_this).GetQueryInput(((_this).Dtor_failingQueries()).Select((_2_i).Uint32()).(m_JsonConfig.SimpleQuery), _3_usedNames, _4_usedValues, m_Wrappers.Companion_Option_.Create_None_()))
			_5_res = _out1
			if !((_5_res).Is_Failure()) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(688,8): " + (_dafny.SeqOfString("expectation violation")).String())
			}
		}
		var _hi1 _dafny.Int = _dafny.IntOfUint32(((_this).Dtor_queries()).Cardinality())
		_ = _hi1
		for _6_i := _dafny.Zero; _6_i.Cmp(_hi1) < 0; _6_i = _6_i.Plus(_dafny.One) {
			if _dafny.Companion_Sequence_.Contains((((_this).Dtor_queries()).Select((_6_i).Uint32()).(m_JsonConfig.SimpleQuery)).Dtor_failConfigs(), (config).Dtor_name()) {
			} else {
				var _7_result _dafny.Sequence
				_ = _7_result
				var _out2 _dafny.Sequence
				_ = _out2
				_out2 = (_this).FullSearch(_1_client, ((_this).Dtor_queries()).Select((_6_i).Uint32()).(m_JsonConfig.SimpleQuery), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
				_7_result = _out2
				if !((_this).QueryOutputEqual(_7_result, (expected).ArrayGet1((_6_i).Int()).(_dafny.Sequence))) {
					_dafny.Print((_dafny.SeqOfString("Query : ")).SetString())
					_dafny.Print(((_this).Dtor_queries()).Select((_6_i).Uint32()).(m_JsonConfig.SimpleQuery))
					_dafny.Print((_dafny.SeqOfString("\nconfig : ")).SetString())
					_dafny.Print(((config).Dtor_name()).SetString())
					_dafny.Print((_dafny.SeqOfString(" result : ")).SetString())
					_dafny.Print(_dafny.IntOfUint32((_7_result).Cardinality()))
					_dafny.Print((_dafny.SeqOfString(", expected : ")).SetString())
					_dafny.Print(_dafny.IntOfUint32(((expected).ArrayGet1((_6_i).Int()).(_dafny.Sequence)).Cardinality()))
					_dafny.Print((_dafny.SeqOfString(", \n")).SetString())
				}
				if !((_this).QueryOutputEqual(_7_result, (expected).ArrayGet1((_6_i).Int()).(_dafny.Sequence))) {
					panic("dafny/DDBEncryption/src/TestVectors.dfy(703,10): " + (_dafny.SeqOfString("expectation violation")).String())
				}
			}
		}
	}
}
func (_this TestVectorConfig) BasicIoTestBatchWriteItem(writeConfig m_JsonConfig.TableConfig, readConfig m_JsonConfig.TableConfig, records _dafny.Sequence) {
	{
		var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _0_valueOrError0
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_JsonConfig.Companion_Default___.NewGazelle(writeConfig)
		_0_valueOrError0 = _out0
		if !(!((_0_valueOrError0).IsFailure())) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(710,21): " + (_0_valueOrError0).String())
		}
		var _1_wClient m_ComAmazonawsDynamodbTypes.IDynamoDBClient
		_ = _1_wClient
		_1_wClient = m_ComAmazonawsDynamodbTypes.Companion_IDynamoDBClient_.CastTo_((_0_valueOrError0).Extract())
		var _2_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _2_valueOrError1
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = m_JsonConfig.Companion_Default___.NewGazelle(readConfig)
		_2_valueOrError1 = _out1
		if !(!((_2_valueOrError1).IsFailure())) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(711,21): " + (_2_valueOrError1).String())
		}
		var _3_rClient m_ComAmazonawsDynamodbTypes.IDynamoDBClient
		_ = _3_rClient
		_3_rClient = m_ComAmazonawsDynamodbTypes.Companion_IDynamoDBClient_.CastTo_((_2_valueOrError1).Extract())
		(_this).DeleteTable(_1_wClient)
		var _4_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsDynamodbTypes.Companion_CreateTableOutput_.Default())
		_ = _4_valueOrError2
		var _out2 m_Wrappers.Result
		_ = _out2
		_out2 = (_1_wClient).CreateTable((_this).Dtor_schemaOnEncrypt())
		_4_valueOrError2 = _out2
		if !(!((_4_valueOrError2).IsFailure())) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(713,16): " + (_4_valueOrError2).String())
		}
		var _5___v13 m_ComAmazonawsDynamodbTypes.CreateTableOutput
		_ = _5___v13
		_5___v13 = (_4_valueOrError2).Extract().(m_ComAmazonawsDynamodbTypes.CreateTableOutput)
		var _6_i _dafny.Int
		_ = _6_i
		_6_i = _dafny.Zero
		for (_6_i).Cmp(_dafny.IntOfUint32((records).Cardinality())) < 0 {
			var _7_count _dafny.Int
			_ = _7_count
			_7_count = _dafny.IntOfInt64(10)
			if ((_dafny.IntOfUint32((records).Cardinality())).Minus(_6_i)).Cmp(_dafny.IntOfInt64(10)) < 0 {
				_7_count = (_dafny.IntOfUint32((records).Cardinality())).Minus(_6_i)
			}
			var _8_requests _dafny.Sequence
			_ = _8_requests
			_8_requests = _dafny.SeqOf()
			var _hi0 _dafny.Int = _7_count
			_ = _hi0
			for _9_j := _dafny.Zero; _9_j.Cmp(_hi0) < 0; _9_j = _9_j.Plus(_dafny.One) {
				var _10_req m_ComAmazonawsDynamodbTypes.WriteRequest
				_ = _10_req
				_10_req = m_ComAmazonawsDynamodbTypes.Companion_WriteRequest_.Create_WriteRequest_(m_Wrappers.Companion_Option_.Create_Some_(m_ComAmazonawsDynamodbTypes.Companion_PutRequest_.Create_PutRequest_(((records).Select(((_6_i).Plus(_9_j)).Uint32()).(m_JsonConfig.Record)).Dtor_item())), m_Wrappers.Companion_Option_.Create_None_())
				_8_requests = _dafny.Companion_Sequence_.Concatenate(_8_requests, _dafny.SeqOf(_10_req))
			}
			if !(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__WriteRequests(_8_requests)) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(730,8): " + (_dafny.SeqOfString("expectation violation")).String())
			}
			var _11_reqMap _dafny.Map
			_ = _11_reqMap
			_11_reqMap = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(m_JsonConfig.Companion_Default___.TableName(), _8_requests)
			if !(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__BatchWriteItemRequestMap(_11_reqMap)) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(732,8): " + (_dafny.SeqOfString("expectation violation")).String())
			}
			var _12_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsDynamodbTypes.Companion_BatchWriteItemOutput_.Default())
			_ = _12_valueOrError3
			var _out3 m_Wrappers.Result
			_ = _out3
			_out3 = (_1_wClient).BatchWriteItem(m_ComAmazonawsDynamodbTypes.Companion_BatchWriteItemInput_.Create_BatchWriteItemInput_(_11_reqMap, m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_()))
			_12_valueOrError3 = _out3
			if !(!((_12_valueOrError3).IsFailure())) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(733,17): " + (_12_valueOrError3).String())
			}
			var _13___v14 m_ComAmazonawsDynamodbTypes.BatchWriteItemOutput
			_ = _13___v14
			_13___v14 = (_12_valueOrError3).Extract().(m_ComAmazonawsDynamodbTypes.BatchWriteItemOutput)
			_6_i = (_6_i).Plus(_7_count)
		}
		(_this).BasicIoTestGetItem(_3_rClient, records)
		(_this).BasicIoTestBatchGetItems(_3_rClient, records)
		(_this).BasicIoTestScan(_3_rClient, records)
		(_this).BasicIoTestTransactGetItems(_3_rClient, records)
	}
}
func (_this TestVectorConfig) BasicIoTestTransactWriteItems(writeConfig m_JsonConfig.TableConfig, readConfig m_JsonConfig.TableConfig, records _dafny.Sequence) {
	{
		var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _0_valueOrError0
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_JsonConfig.Companion_Default___.NewGazelle(writeConfig)
		_0_valueOrError0 = _out0
		if !(!((_0_valueOrError0).IsFailure())) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(749,21): " + (_0_valueOrError0).String())
		}
		var _1_wClient m_ComAmazonawsDynamodbTypes.IDynamoDBClient
		_ = _1_wClient
		_1_wClient = m_ComAmazonawsDynamodbTypes.Companion_IDynamoDBClient_.CastTo_((_0_valueOrError0).Extract())
		var _2_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _2_valueOrError1
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = m_JsonConfig.Companion_Default___.NewGazelle(readConfig)
		_2_valueOrError1 = _out1
		if !(!((_2_valueOrError1).IsFailure())) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(750,21): " + (_2_valueOrError1).String())
		}
		var _3_rClient m_ComAmazonawsDynamodbTypes.IDynamoDBClient
		_ = _3_rClient
		_3_rClient = m_ComAmazonawsDynamodbTypes.Companion_IDynamoDBClient_.CastTo_((_2_valueOrError1).Extract())
		(_this).DeleteTable(_1_wClient)
		var _4_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsDynamodbTypes.Companion_CreateTableOutput_.Default())
		_ = _4_valueOrError2
		var _out2 m_Wrappers.Result
		_ = _out2
		_out2 = (_1_wClient).CreateTable((_this).Dtor_schemaOnEncrypt())
		_4_valueOrError2 = _out2
		if !(!((_4_valueOrError2).IsFailure())) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(752,16): " + (_4_valueOrError2).String())
		}
		var _5___v15 m_ComAmazonawsDynamodbTypes.CreateTableOutput
		_ = _5___v15
		_5___v15 = (_4_valueOrError2).Extract().(m_ComAmazonawsDynamodbTypes.CreateTableOutput)
		var _6_i _dafny.Int
		_ = _6_i
		_6_i = _dafny.Zero
		for (_6_i).Cmp(_dafny.IntOfUint32((records).Cardinality())) < 0 {
			var _7_count _dafny.Int
			_ = _7_count
			_7_count = _dafny.IntOfInt64(10)
			if ((_dafny.IntOfUint32((records).Cardinality())).Minus(_6_i)).Cmp(_dafny.IntOfInt64(10)) < 0 {
				_7_count = (_dafny.IntOfUint32((records).Cardinality())).Minus(_6_i)
			}
			var _8_requests _dafny.Sequence
			_ = _8_requests
			_8_requests = _dafny.SeqOf()
			var _hi0 _dafny.Int = _7_count
			_ = _hi0
			for _9_j := _dafny.Zero; _9_j.Cmp(_hi0) < 0; _9_j = _9_j.Plus(_dafny.One) {
				var _10_item m_ComAmazonawsDynamodbTypes.Put
				_ = _10_item
				_10_item = m_ComAmazonawsDynamodbTypes.Companion_Put_.Create_Put_(((records).Select(((_6_i).Plus(_9_j)).Uint32()).(m_JsonConfig.Record)).Dtor_item(), m_JsonConfig.Companion_Default___.TableName(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
				var _11_wItem m_ComAmazonawsDynamodbTypes.TransactWriteItem
				_ = _11_wItem
				_11_wItem = m_ComAmazonawsDynamodbTypes.Companion_TransactWriteItem_.Create_TransactWriteItem_(m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_(_10_item), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
				_8_requests = _dafny.Companion_Sequence_.Concatenate(_8_requests, _dafny.SeqOf(_11_wItem))
			}
			if !(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__TransactWriteItemList(_8_requests)) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(777,8): " + (_dafny.SeqOfString("expectation violation")).String())
			}
			var _12_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsDynamodbTypes.Companion_TransactWriteItemsOutput_.Default())
			_ = _12_valueOrError3
			var _out3 m_Wrappers.Result
			_ = _out3
			_out3 = (_1_wClient).TransactWriteItems(m_ComAmazonawsDynamodbTypes.Companion_TransactWriteItemsInput_.Create_TransactWriteItemsInput_(_8_requests, m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_()))
			_12_valueOrError3 = _out3
			if !(!((_12_valueOrError3).IsFailure())) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(778,17): " + (_12_valueOrError3).String())
			}
			var _13___v16 m_ComAmazonawsDynamodbTypes.TransactWriteItemsOutput
			_ = _13___v16
			_13___v16 = (_12_valueOrError3).Extract().(m_ComAmazonawsDynamodbTypes.TransactWriteItemsOutput)
			_6_i = (_6_i).Plus(_7_count)
		}
		(_this).BasicIoTestBatchGetItems(_3_rClient, records)
		(_this).BasicIoTestGetItem(_3_rClient, records)
		(_this).BasicIoTestScan(_3_rClient, records)
		(_this).BasicIoTestTransactGetItems(_3_rClient, records)
	}
}
func (_this TestVectorConfig) BasicIoTestPutItem(writeConfig m_JsonConfig.TableConfig, readConfig m_JsonConfig.TableConfig, records _dafny.Sequence) {
	{
		var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _0_valueOrError0
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_JsonConfig.Companion_Default___.NewGazelle(writeConfig)
		_0_valueOrError0 = _out0
		if !(!((_0_valueOrError0).IsFailure())) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(796,21): " + (_0_valueOrError0).String())
		}
		var _1_wClient m_ComAmazonawsDynamodbTypes.IDynamoDBClient
		_ = _1_wClient
		_1_wClient = m_ComAmazonawsDynamodbTypes.Companion_IDynamoDBClient_.CastTo_((_0_valueOrError0).Extract())
		var _2_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _2_valueOrError1
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = m_JsonConfig.Companion_Default___.NewGazelle(readConfig)
		_2_valueOrError1 = _out1
		if !(!((_2_valueOrError1).IsFailure())) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(797,21): " + (_2_valueOrError1).String())
		}
		var _3_rClient m_ComAmazonawsDynamodbTypes.IDynamoDBClient
		_ = _3_rClient
		_3_rClient = m_ComAmazonawsDynamodbTypes.Companion_IDynamoDBClient_.CastTo_((_2_valueOrError1).Extract())
		(_this).WriteAllRecords(_1_wClient, records)
		(_this).BasicIoTestBatchGetItems(_3_rClient, records)
		(_this).BasicIoTestGetItem(_3_rClient, records)
		(_this).BasicIoTestScan(_3_rClient, records)
		(_this).BasicIoTestTransactGetItems(_3_rClient, records)
	}
}
func (_this TestVectorConfig) FindMatchingRecord(expected _dafny.Map, actual _dafny.Sequence) bool {
	{
		var output bool = false
		_ = output
		var _0_exp _dafny.Map
		_ = _0_exp
		_0_exp = m_DdbItemJson.Companion_Default___.NormalizeItem(expected)
		var _hi0 _dafny.Int = _dafny.IntOfUint32((actual).Cardinality())
		_ = _hi0
		for _1_i := _dafny.Zero; _1_i.Cmp(_hi0) < 0; _1_i = _1_i.Plus(_dafny.One) {
			if (m_DdbItemJson.Companion_Default___.NormalizeItem((actual).Select((_1_i).Uint32()).(_dafny.Map))).Equals(_0_exp) {
				output = true
				return output
			}
		}
		output = false
		return output
		return output
	}
}
func (_this TestVectorConfig) CompareRecordsDisordered(expected _dafny.Sequence, actual _dafny.Sequence) {
	{
		if !((_dafny.IntOfUint32((expected).Cardinality())).Cmp(_dafny.IntOfUint32((actual).Cardinality())) == 0) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(818,6): " + (_dafny.SeqOfString("expectation violation")).String())
		}
		var _0_bad bool
		_ = _0_bad
		_0_bad = false
		var _hi0 _dafny.Int = _dafny.IntOfUint32((expected).Cardinality())
		_ = _hi0
		for _1_i := _dafny.Zero; _1_i.Cmp(_hi0) < 0; _1_i = _1_i.Plus(_dafny.One) {
			var _2_found bool
			_ = _2_found
			var _out0 bool
			_ = _out0
			_out0 = (_this).FindMatchingRecord(((expected).Select((_1_i).Uint32()).(m_JsonConfig.Record)).Dtor_item(), actual)
			_2_found = _out0
			if !(_2_found) {
				_dafny.Print((_dafny.SeqOfString("Did not find result for record ")).SetString())
				_dafny.Print(((expected).Select((_1_i).Uint32()).(m_JsonConfig.Record)).Dtor_number())
				_dafny.Print((_dafny.SeqOfString("\n")).SetString())
				_0_bad = true
			}
		}
		if !(!(_0_bad)) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(827,6): " + (_dafny.SeqOfString("expectation violation")).String())
		}
	}
}
func (_this TestVectorConfig) CompareRecordsDisordered2(expected _dafny.Sequence, actual _dafny.Sequence) {
	{
		if !((_dafny.IntOfUint32((expected).Cardinality())).Cmp(_dafny.IntOfUint32((actual).Cardinality())) == 0) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(831,6): " + (_dafny.SeqOfString("expectation violation")).String())
		}
		var _0_bad bool
		_ = _0_bad
		_0_bad = false
		var _hi0 _dafny.Int = _dafny.IntOfUint32((expected).Cardinality())
		_ = _hi0
		for _1_i := _dafny.Zero; _1_i.Cmp(_hi0) < 0; _1_i = _1_i.Plus(_dafny.One) {
			var _2_found bool
			_ = _2_found
			var _out0 bool
			_ = _out0
			_out0 = (_this).FindMatchingRecord((expected).Select((_1_i).Uint32()).(_dafny.Map), actual)
			_2_found = _out0
			if !(_2_found) {
				_dafny.Print((_dafny.SeqOfString("Did not find result for record ")).SetString())
				_dafny.Print((expected).Select((_1_i).Uint32()).(_dafny.Map))
				_dafny.Print((_dafny.SeqOfString("\n")).SetString())
				_0_bad = true
			}
		}
		if !(!(_0_bad)) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(840,6): " + (_dafny.SeqOfString("expectation violation")).String())
		}
	}
}
func (_this TestVectorConfig) BasicIoTestScan(client m_ComAmazonawsDynamodbTypes.IDynamoDBClient, records _dafny.Sequence) {
	{
		var _0_emptyQuery m_JsonConfig.SimpleQuery
		_ = _0_emptyQuery
		_0_emptyQuery = m_JsonConfig.Companion_SimpleQuery_.Create_SimpleQuery_(m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), _dafny.SeqOf())
		var _1_results _dafny.Sequence
		_ = _1_results
		var _out0 _dafny.Sequence
		_ = _out0
		_out0 = (_this).FullScan(client, _0_emptyQuery, m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
		_1_results = _out0
		if !((_dafny.IntOfUint32((_1_results).Cardinality())).Cmp(_dafny.IntOfUint32((records).Cardinality())) == 0) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(850,6): " + (_dafny.SeqOfString("expectation violation")).String())
		}
		(_this).CompareRecordsDisordered(records, _1_results)
	}
}
func (_this TestVectorConfig) ReadAllRecords(client m_ComAmazonawsDynamodbTypes.IDynamoDBClient) _dafny.Sequence {
	{
		var output _dafny.Sequence = _dafny.EmptySeq
		_ = output
		var _0_emptyQuery m_JsonConfig.SimpleQuery
		_ = _0_emptyQuery
		_0_emptyQuery = m_JsonConfig.Companion_SimpleQuery_.Create_SimpleQuery_(m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), _dafny.SeqOf())
		var _out0 _dafny.Sequence
		_ = _out0
		_out0 = (_this).FullScan(client, _0_emptyQuery, m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
		output = _out0
		return output
	}
}
func (_this TestVectorConfig) BasicIoTestGetItem(client m_ComAmazonawsDynamodbTypes.IDynamoDBClient, records _dafny.Sequence) {
	{
		var _hi0 _dafny.Int = _dafny.IntOfUint32((records).Cardinality())
		_ = _hi0
		for _0_i := _dafny.Zero; _0_i.Cmp(_hi0) < 0; _0_i = _0_i.Plus(_dafny.One) {
			var _1_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
			_ = _1_valueOrError0
			_1_valueOrError0 = m_Wrappers.Companion_Default___.Need((((records).Select((_0_i).Uint32()).(m_JsonConfig.Record)).Dtor_item()).Contains(m_JsonConfig.Companion_Default___.HashName()), _dafny.SeqOfString(""))
			if !(!((_1_valueOrError0).IsFailure())) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(869,11): " + (_1_valueOrError0).String())
			}
			var _2_input m_ComAmazonawsDynamodbTypes.GetItemInput
			_ = _2_input
			_2_input = m_ComAmazonawsDynamodbTypes.Companion_GetItemInput_.Create_GetItemInput_(m_JsonConfig.Companion_Default___.TableName(), _dafny.NewMapBuilder().ToMap().UpdateUnsafe(m_JsonConfig.Companion_Default___.HashName(), (((records).Select((_0_i).Uint32()).(m_JsonConfig.Record)).Dtor_item()).Get(m_JsonConfig.Companion_Default___.HashName()).(m_ComAmazonawsDynamodbTypes.AttributeValue)), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
			var _3_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsDynamodbTypes.Companion_GetItemOutput_.Default())
			_ = _3_valueOrError1
			var _out0 m_Wrappers.Result
			_ = _out0
			_out0 = (client).GetItem(_2_input)
			_3_valueOrError1 = _out0
			if !(!((_3_valueOrError1).IsFailure())) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(879,19): " + (_3_valueOrError1).String())
			}
			var _4_out m_ComAmazonawsDynamodbTypes.GetItemOutput
			_ = _4_out
			_4_out = (_3_valueOrError1).Extract().(m_ComAmazonawsDynamodbTypes.GetItemOutput)
			if !(((_4_out).Dtor_Item()).Is_Some()) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(880,8): " + (_dafny.SeqOfString("expectation violation")).String())
			}
			if !((((_4_out).Dtor_Item()).Dtor_value().(_dafny.Map)).Equals(m_DdbItemJson.Companion_Default___.NormalizeItem(((records).Select((_0_i).Uint32()).(m_JsonConfig.Record)).Dtor_item()))) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(881,8): " + (_dafny.SeqOfString("expectation violation")).String())
			}
		}
	}
}
func (_this TestVectorConfig) PrintAllRecords(records _dafny.Sequence) {
	{
		var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _0_valueOrError0
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_CreateInterceptedDDBClient.CreateVanillaDDBClient()
		_0_valueOrError0 = _out0
		if !(!((_0_valueOrError0).IsFailure())) {
			panic("dafny/DDBEncryption/src/TestVectors.dfy(887,20): " + (_0_valueOrError0).String())
		}
		var _1_client m_ComAmazonawsDynamodbTypes.IDynamoDBClient
		_ = _1_client
		_1_client = m_ComAmazonawsDynamodbTypes.Companion_IDynamoDBClient_.CastTo_((_0_valueOrError0).Extract())
		var _hi0 _dafny.Int = _dafny.IntOfUint32((records).Cardinality())
		_ = _hi0
		for _2_i := _dafny.Zero; _2_i.Cmp(_hi0) < 0; _2_i = _2_i.Plus(_dafny.One) {
			var _3_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
			_ = _3_valueOrError1
			_3_valueOrError1 = m_Wrappers.Companion_Default___.Need((((records).Select((_2_i).Uint32()).(m_JsonConfig.Record)).Dtor_item()).Contains(m_JsonConfig.Companion_Default___.HashName()), _dafny.SeqOfString(""))
			if !(!((_3_valueOrError1).IsFailure())) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(889,11): " + (_3_valueOrError1).String())
			}
			var _4_input m_ComAmazonawsDynamodbTypes.GetItemInput
			_ = _4_input
			_4_input = m_ComAmazonawsDynamodbTypes.Companion_GetItemInput_.Create_GetItemInput_(m_JsonConfig.Companion_Default___.TableName(), _dafny.NewMapBuilder().ToMap().UpdateUnsafe(m_JsonConfig.Companion_Default___.HashName(), (((records).Select((_2_i).Uint32()).(m_JsonConfig.Record)).Dtor_item()).Get(m_JsonConfig.Companion_Default___.HashName()).(m_ComAmazonawsDynamodbTypes.AttributeValue)), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
			var _5_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsDynamodbTypes.Companion_GetItemOutput_.Default())
			_ = _5_valueOrError2
			var _out1 m_Wrappers.Result
			_ = _out1
			_out1 = (_1_client).GetItem(_4_input)
			_5_valueOrError2 = _out1
			if !(!((_5_valueOrError2).IsFailure())) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(899,19): " + (_5_valueOrError2).String())
			}
			var _6_out m_ComAmazonawsDynamodbTypes.GetItemOutput
			_ = _6_out
			_6_out = (_5_valueOrError2).Extract().(m_ComAmazonawsDynamodbTypes.GetItemOutput)
			if !(((_6_out).Dtor_Item()).Is_Some()) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(900,8): " + (_dafny.SeqOfString("expectation violation")).String())
			}
			_dafny.Print(((_6_out).Dtor_Item()).Dtor_value().(_dafny.Map))
			_dafny.Print((_dafny.SeqOfString("\n\n")).SetString())
		}
	}
}
func (_this TestVectorConfig) ItemExists(number m_ComAmazonawsDynamodbTypes.AttributeValue, record m_JsonConfig.Record, resp _dafny.Sequence) bool {
	{
		goto TAIL_CALL_START
	TAIL_CALL_START:
		var output bool = false
		_ = output
		if (_dafny.IntOfUint32((resp).Cardinality())).Sign() == 0 {
			output = false
			return output
		} else if (((resp).Select(0).(_dafny.Map)).Contains(m_JsonConfig.Companion_Default___.HashName())) && ((((resp).Select(0).(_dafny.Map)).Get(m_JsonConfig.Companion_Default___.HashName()).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals(number)) {
			if !(((resp).Select(0).(_dafny.Map)).Equals(m_DdbItemJson.Companion_Default___.NormalizeItem((record).Dtor_item()))) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(911,8): " + (_dafny.SeqOfString("expectation violation")).String())
			}
			output = true
			return output
		} else {
			var _in0 TestVectorConfig = _this
			_ = _in0
			var _in1 m_ComAmazonawsDynamodbTypes.AttributeValue = number
			_ = _in1
			var _in2 m_JsonConfig.Record = record
			_ = _in2
			var _in3 _dafny.Sequence = (resp).Drop(1)
			_ = _in3
			_this = _in0

			number = _in1
			record = _in2
			resp = _in3
			goto TAIL_CALL_START
		}
		return output
	}
}
func (_this TestVectorConfig) ItemExists2(number m_ComAmazonawsDynamodbTypes.AttributeValue, record m_JsonConfig.Record, resp _dafny.Sequence) bool {
	{
		goto TAIL_CALL_START
	TAIL_CALL_START:
		var output bool = false
		_ = output
		if (_dafny.IntOfUint32((resp).Cardinality())).Sign() == 0 {
			output = false
			return output
		} else if (((((resp).Select(0).(m_ComAmazonawsDynamodbTypes.ItemResponse)).Dtor_Item()).Is_Some()) && (((((resp).Select(0).(m_ComAmazonawsDynamodbTypes.ItemResponse)).Dtor_Item()).Dtor_value().(_dafny.Map)).Contains(m_JsonConfig.Companion_Default___.HashName()))) && ((((((resp).Select(0).(m_ComAmazonawsDynamodbTypes.ItemResponse)).Dtor_Item()).Dtor_value().(_dafny.Map)).Get(m_JsonConfig.Companion_Default___.HashName()).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Equals(number)) {
			if !(((((resp).Select(0).(m_ComAmazonawsDynamodbTypes.ItemResponse)).Dtor_Item()).Dtor_value().(_dafny.Map)).Equals(m_DdbItemJson.Companion_Default___.NormalizeItem((record).Dtor_item()))) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(922,8): " + (_dafny.SeqOfString("expectation violation")).String())
			}
			output = true
			return output
		} else {
			var _in0 TestVectorConfig = _this
			_ = _in0
			var _in1 m_ComAmazonawsDynamodbTypes.AttributeValue = number
			_ = _in1
			var _in2 m_JsonConfig.Record = record
			_ = _in2
			var _in3 _dafny.Sequence = (resp).Drop(1)
			_ = _in3
			_this = _in0

			number = _in1
			record = _in2
			resp = _in3
			goto TAIL_CALL_START
		}
		return output
	}
}
func (_this TestVectorConfig) BasicIoTestBatchGetItems(client m_ComAmazonawsDynamodbTypes.IDynamoDBClient, records _dafny.Sequence) {
	{
		var _0_i _dafny.Int
		_ = _0_i
		_0_i = _dafny.Zero
		for (_0_i).Cmp(_dafny.IntOfUint32((records).Cardinality())) < 0 {
			var _1_count _dafny.Int
			_ = _1_count
			_1_count = _dafny.IntOfInt64(10)
			if ((_dafny.IntOfUint32((records).Cardinality())).Minus(_0_i)).Cmp(_dafny.IntOfInt64(10)) < 0 {
				_1_count = (_dafny.IntOfUint32((records).Cardinality())).Minus(_0_i)
			}
			var _2_requests _dafny.Sequence
			_ = _2_requests
			_2_requests = _dafny.SeqOf()
			var _hi0 _dafny.Int = _1_count
			_ = _hi0
			for _3_j := _dafny.Zero; _3_j.Cmp(_hi0) < 0; _3_j = _3_j.Plus(_dafny.One) {
				var _4_val m_ComAmazonawsDynamodbTypes.AttributeValue
				_ = _4_val
				_4_val = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_N_(m_StandardLibrary_String.Companion_Default___.Base10Int2String((_0_i).Plus(_3_j)))
				var _5_item _dafny.Map
				_ = _5_item
				_5_item = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(m_JsonConfig.Companion_Default___.HashName(), _4_val)
				_2_requests = _dafny.Companion_Sequence_.Concatenate(_2_requests, _dafny.SeqOf(_5_item))
			}
			if !(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__KeyList(_2_requests)) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(946,8): " + (_dafny.SeqOfString("expectation violation")).String())
			}
			var _6_keyAttr m_ComAmazonawsDynamodbTypes.KeysAndAttributes
			_ = _6_keyAttr
			_6_keyAttr = m_ComAmazonawsDynamodbTypes.Companion_KeysAndAttributes_.Create_KeysAndAttributes_(_2_requests, m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
			var _7_reqMap _dafny.Map
			_ = _7_reqMap
			_7_reqMap = _dafny.NewMapBuilder().ToMap().UpdateUnsafe(m_JsonConfig.Companion_Default___.TableName(), _6_keyAttr)
			if !(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__BatchGetRequestMap(_7_reqMap)) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(955,8): " + (_dafny.SeqOfString("expectation violation")).String())
			}
			var _8_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsDynamodbTypes.Companion_BatchGetItemOutput_.Default())
			_ = _8_valueOrError0
			var _out0 m_Wrappers.Result
			_ = _out0
			_out0 = (client).BatchGetItem(m_ComAmazonawsDynamodbTypes.Companion_BatchGetItemInput_.Create_BatchGetItemInput_(_7_reqMap, m_Wrappers.Companion_Option_.Create_None_()))
			_8_valueOrError0 = _out0
			if !(!((_8_valueOrError0).IsFailure())) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(956,22): " + (_8_valueOrError0).String())
			}
			var _9_result m_ComAmazonawsDynamodbTypes.BatchGetItemOutput
			_ = _9_result
			_9_result = (_8_valueOrError0).Extract().(m_ComAmazonawsDynamodbTypes.BatchGetItemOutput)
			if !((((_9_result).Dtor_UnprocessedKeys()).Is_None()) || (((((_9_result).Dtor_UnprocessedKeys()).Dtor_value().(_dafny.Map)).Cardinality()).Sign() == 0)) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(962,8): " + (_dafny.SeqOfString("expectation violation")).String())
			}
			if !(((_9_result).Dtor_Responses()).Is_Some()) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(963,8): " + (_dafny.SeqOfString("expectation violation")).String())
			}
			if !(((((_9_result).Dtor_Responses()).Dtor_value().(_dafny.Map)).Cardinality()).Cmp(_dafny.One) == 0) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(964,8): " + (_dafny.SeqOfString("expectation violation")).String())
			}
			if !((((_9_result).Dtor_Responses()).Dtor_value().(_dafny.Map)).Contains(m_JsonConfig.Companion_Default___.TableName())) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(965,8): " + (_dafny.SeqOfString("expectation violation")).String())
			}
			var _10_resp _dafny.Sequence
			_ = _10_resp
			_10_resp = (((_9_result).Dtor_Responses()).Dtor_value().(_dafny.Map)).Get(m_JsonConfig.Companion_Default___.TableName()).(_dafny.Sequence)
			var _hi1 _dafny.Int = _1_count
			_ = _hi1
			for _11_j := _dafny.Zero; _11_j.Cmp(_hi1) < 0; _11_j = _11_j.Plus(_dafny.One) {
				if !((((records).Select(((_0_i).Plus(_11_j)).Uint32()).(m_JsonConfig.Record)).Dtor_item()).Contains(m_JsonConfig.Companion_Default___.HashName())) {
					panic("dafny/DDBEncryption/src/TestVectors.dfy(968,10): " + (_dafny.SeqOfString("expectation violation")).String())
				}
				var _12_val m_ComAmazonawsDynamodbTypes.AttributeValue
				_ = _12_val
				_12_val = (((records).Select(((_0_i).Plus(_11_j)).Uint32()).(m_JsonConfig.Record)).Dtor_item()).Get(m_JsonConfig.Companion_Default___.HashName()).(m_ComAmazonawsDynamodbTypes.AttributeValue)
				var _13_doesExist bool
				_ = _13_doesExist
				var _out1 bool
				_ = _out1
				_out1 = (_this).ItemExists(_12_val, (records).Select(((_0_i).Plus(_11_j)).Uint32()).(m_JsonConfig.Record), _10_resp)
				_13_doesExist = _out1
				if !(_13_doesExist) {
					panic("dafny/DDBEncryption/src/TestVectors.dfy(971,10): " + (_dafny.SeqOfString("expectation violation")).String())
				}
			}
			_0_i = (_0_i).Plus(_1_count)
		}
	}
}
func (_this TestVectorConfig) BasicIoTestTransactGetItems(client m_ComAmazonawsDynamodbTypes.IDynamoDBClient, records _dafny.Sequence) {
	{
		var _0_i _dafny.Int
		_ = _0_i
		_0_i = _dafny.Zero
		for (_0_i).Cmp(_dafny.IntOfUint32((records).Cardinality())) < 0 {
			var _1_count _dafny.Int
			_ = _1_count
			_1_count = _dafny.IntOfInt64(10)
			if ((_dafny.IntOfUint32((records).Cardinality())).Minus(_0_i)).Cmp(_dafny.IntOfInt64(10)) < 0 {
				_1_count = (_dafny.IntOfUint32((records).Cardinality())).Minus(_0_i)
			}
			var _2_requests _dafny.Sequence
			_ = _2_requests
			_2_requests = _dafny.SeqOf()
			var _hi0 _dafny.Int = _1_count
			_ = _hi0
			for _3_j := _dafny.Zero; _3_j.Cmp(_hi0) < 0; _3_j = _3_j.Plus(_dafny.One) {
				if !((((records).Select(((_0_i).Plus(_3_j)).Uint32()).(m_JsonConfig.Record)).Dtor_item()).Contains(m_JsonConfig.Companion_Default___.HashName())) {
					panic("dafny/DDBEncryption/src/TestVectors.dfy(990,10): " + (_dafny.SeqOfString("expectation violation")).String())
				}
				var _4_item m_ComAmazonawsDynamodbTypes.TransactGetItem
				_ = _4_item
				_4_item = m_ComAmazonawsDynamodbTypes.Companion_TransactGetItem_.Create_TransactGetItem_(m_ComAmazonawsDynamodbTypes.Companion_Get_.Create_Get_(_dafny.NewMapBuilder().ToMap().UpdateUnsafe(m_JsonConfig.Companion_Default___.HashName(), (((records).Select(((_0_i).Plus(_3_j)).Uint32()).(m_JsonConfig.Record)).Dtor_item()).Get(m_JsonConfig.Companion_Default___.HashName()).(m_ComAmazonawsDynamodbTypes.AttributeValue)), m_JsonConfig.Companion_Default___.TableName(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_()))
				_2_requests = _dafny.Companion_Sequence_.Concatenate(_2_requests, _dafny.SeqOf(_4_item))
			}
			if !(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__TransactGetItemList(_2_requests)) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(1001,8): " + (_dafny.SeqOfString("expectation violation")).String())
			}
			var _5_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsDynamodbTypes.Companion_TransactGetItemsOutput_.Default())
			_ = _5_valueOrError0
			var _out0 m_Wrappers.Result
			_ = _out0
			_out0 = (client).TransactGetItems(m_ComAmazonawsDynamodbTypes.Companion_TransactGetItemsInput_.Create_TransactGetItemsInput_(_2_requests, m_Wrappers.Companion_Option_.Create_None_()))
			_5_valueOrError0 = _out0
			if !(!((_5_valueOrError0).IsFailure())) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(1002,22): " + (_5_valueOrError0).String())
			}
			var _6_result m_ComAmazonawsDynamodbTypes.TransactGetItemsOutput
			_ = _6_result
			_6_result = (_5_valueOrError0).Extract().(m_ComAmazonawsDynamodbTypes.TransactGetItemsOutput)
			if !(((_6_result).Dtor_Responses()).Is_Some()) {
				panic("dafny/DDBEncryption/src/TestVectors.dfy(1008,8): " + (_dafny.SeqOfString("expectation violation")).String())
			}
			var _7_resp _dafny.Sequence
			_ = _7_resp
			_7_resp = ((_6_result).Dtor_Responses()).Dtor_value().(_dafny.Sequence)
			var _hi1 _dafny.Int = _1_count
			_ = _hi1
			for _8_j := _dafny.Zero; _8_j.Cmp(_hi1) < 0; _8_j = _8_j.Plus(_dafny.One) {
				if !((((records).Select(((_0_i).Plus(_8_j)).Uint32()).(m_JsonConfig.Record)).Dtor_item()).Contains(m_JsonConfig.Companion_Default___.HashName())) {
					panic("dafny/DDBEncryption/src/TestVectors.dfy(1011,10): " + (_dafny.SeqOfString("expectation violation")).String())
				}
				var _9_val m_ComAmazonawsDynamodbTypes.AttributeValue
				_ = _9_val
				_9_val = (((records).Select(((_0_i).Plus(_8_j)).Uint32()).(m_JsonConfig.Record)).Dtor_item()).Get(m_JsonConfig.Companion_Default___.HashName()).(m_ComAmazonawsDynamodbTypes.AttributeValue)
				var _10_doesExist bool
				_ = _10_doesExist
				var _out1 bool
				_ = _out1
				_out1 = (_this).ItemExists2(_9_val, (records).Select(((_0_i).Plus(_8_j)).Uint32()).(m_JsonConfig.Record), _7_resp)
				_10_doesExist = _out1
				if !(_10_doesExist) {
					panic("dafny/DDBEncryption/src/TestVectors.dfy(1014,10): " + (_dafny.SeqOfString("expectation violation")).String())
				}
			}
			_0_i = (_0_i).Plus(_1_count)
		}
	}
}
func (_this TestVectorConfig) TestConfigs() _dafny.Set {
	{
		return _dafny.SetOf(_dafny.SeqOfString("all"))
	}
}
func (_this TestVectorConfig) TestRecords() _dafny.Set {
	{
		return _dafny.SetOf(_dafny.SeqOfString("all"))
	}
}

// End of datatype TestVectorConfig
