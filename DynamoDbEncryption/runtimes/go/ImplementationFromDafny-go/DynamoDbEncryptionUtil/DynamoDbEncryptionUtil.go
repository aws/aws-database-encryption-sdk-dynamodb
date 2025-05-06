// Package DynamoDbEncryptionUtil
// Dafny module DynamoDbEncryptionUtil compiled into Go

package DynamoDbEncryptionUtil

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
	m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes"
	m_AwsCryptographyDbEncryptionSdkDynamoDbTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbTypes"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes"
	m_Canonize "github.com/aws/aws-database-encryption-sdk-dynamodb/Canonize"
	m__Maps "github.com/aws/aws-database-encryption-sdk-dynamodb/Maps_"
	m_OptimizedMergeSort "github.com/aws/aws-database-encryption-sdk-dynamodb/OptimizedMergeSort"
	m_Sets "github.com/aws/aws-database-encryption-sdk-dynamodb/Sets"
	m_SortCanon "github.com/aws/aws-database-encryption-sdk-dynamodb/SortCanon"
	m_StructuredEncryption "github.com/aws/aws-database-encryption-sdk-dynamodb/StructuredEncryption"
	m_StructuredEncryptionCrypt "github.com/aws/aws-database-encryption-sdk-dynamodb/StructuredEncryptionCrypt"
	m_StructuredEncryptionFooter "github.com/aws/aws-database-encryption-sdk-dynamodb/StructuredEncryptionFooter"
	m_StructuredEncryptionHeader "github.com/aws/aws-database-encryption-sdk-dynamodb/StructuredEncryptionHeader"
	m_StructuredEncryptionPaths "github.com/aws/aws-database-encryption-sdk-dynamodb/StructuredEncryptionPaths"
	m_StructuredEncryptionUtil "github.com/aws/aws-database-encryption-sdk-dynamodb/StructuredEncryptionUtil"
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
var _ m__Unicode.Dummy__
var _ m_Functions.Dummy__
var _ m_Utf8EncodingForm.Dummy__
var _ m_Utf16EncodingForm.Dummy__
var _ m_UnicodeStrings.Dummy__
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
var _ m_StandardLibraryInterop.Dummy__
var _ m_Streams.Dummy__
var _ m_Sorting.Dummy__
var _ m_HexStrings.Dummy__
var _ m_GetOpt.Dummy__
var _ m_FloatCompare.Dummy__
var _ m_Base64Lemmas.Dummy__
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
	return "DynamoDbEncryptionUtil.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) MaybeFromOptionKeyId(x m_Wrappers.Option) MaybeKeyId {
	if (x).Is_Some() {
		return Companion_MaybeKeyId_.Create_KeyId_((x).Dtor_value().(_dafny.Sequence))
	} else {
		return Companion_MaybeKeyId_.Create_DontUseKeyId_()
	}
}
func (_static *CompanionStruct_Default___) E(s _dafny.Sequence) m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Error {
	return m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Error_.Create_DynamoDbEncryptionException_(s)
}
func (_static *CompanionStruct_Default___) CharLess(x _dafny.Char, y _dafny.Char) bool {
	return (x) < (y)
}
func (_static *CompanionStruct_Default___) ByteLess(x uint8, y uint8) bool {
	return (x) < (y)
}
func (_static *CompanionStruct_Default___) AttrTypeToStr(attr m_ComAmazonawsDynamodbTypes.AttributeValue) _dafny.Sequence {
	var _source0 m_ComAmazonawsDynamodbTypes.AttributeValue = attr
	_ = _source0
	{
		if _source0.Is_S() {
			var _0_s _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_S).S
			_ = _0_s
			return _dafny.SeqOfString("S")
		}
	}
	{
		if _source0.Is_N() {
			var _1_n _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_N).N
			_ = _1_n
			return _dafny.SeqOfString("N")
		}
	}
	{
		if _source0.Is_B() {
			var _2_n _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_B).B
			_ = _2_n
			return _dafny.SeqOfString("B")
		}
	}
	{
		if _source0.Is_SS() {
			var _3_n _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_SS).SS
			_ = _3_n
			return _dafny.SeqOfString("SS")
		}
	}
	{
		if _source0.Is_NS() {
			var _4_n _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_NS).NS
			_ = _4_n
			return _dafny.SeqOfString("NS")
		}
	}
	{
		if _source0.Is_BS() {
			var _5_n _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_BS).BS
			_ = _5_n
			return _dafny.SeqOfString("BS")
		}
	}
	{
		if _source0.Is_M() {
			var _6_n _dafny.Map = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_M).M
			_ = _6_n
			return _dafny.SeqOfString("M")
		}
	}
	{
		if _source0.Is_L() {
			var _7_n _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_L).L
			_ = _7_n
			return _dafny.SeqOfString("L")
		}
	}
	{
		if _source0.Is_NULL() {
			var _8_n bool = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_NULL).NULL
			_ = _8_n
			return _dafny.SeqOfString("NULL")
		}
	}
	{
		var _9_n bool = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_BOOL).BOOL
		_ = _9_n
		return _dafny.SeqOfString("BOOL")
	}
}
func (_static *CompanionStruct_Default___) PrintFromFunction(x interface{}) _dafny.Tuple {
	var _hresult _dafny.Tuple = _dafny.TupleOf()
	_ = _hresult
	_dafny.Print(x)
	_dafny.Print((_dafny.SeqOfString("\n")).SetString())
	_hresult = _dafny.TupleOf()
	return _hresult
	return _hresult
}
func (_static *CompanionStruct_Default___) ReservedPrefix() _dafny.Sequence {
	return _dafny.SeqOfString("aws_dbe_")
}
func (_static *CompanionStruct_Default___) BeaconPrefix() _dafny.Sequence {
	return _dafny.SeqOfString("aws_dbe_b_")
}
func (_static *CompanionStruct_Default___) VersionPrefix() _dafny.Sequence {
	return _dafny.SeqOfString("aws_dbe_v_")
}
func (_static *CompanionStruct_Default___) MAX__STRUCTURE__DEPTH() uint64 {
	return uint64(32)
}
func (_static *CompanionStruct_Default___) MAX__STRUCTURE__DEPTH__STR() _dafny.Sequence {
	return _dafny.SeqOfString("32")
}

// End of class Default__

// Definition of datatype MaybeKeyMap
type MaybeKeyMap struct {
	Data_MaybeKeyMap_
}

func (_this MaybeKeyMap) Get_() Data_MaybeKeyMap_ {
	return _this.Data_MaybeKeyMap_
}

type Data_MaybeKeyMap_ interface {
	isMaybeKeyMap()
}

type CompanionStruct_MaybeKeyMap_ struct {
}

var Companion_MaybeKeyMap_ = CompanionStruct_MaybeKeyMap_{}

type MaybeKeyMap_DontUseKeys struct {
}

func (MaybeKeyMap_DontUseKeys) isMaybeKeyMap() {}

func (CompanionStruct_MaybeKeyMap_) Create_DontUseKeys_() MaybeKeyMap {
	return MaybeKeyMap{MaybeKeyMap_DontUseKeys{}}
}

func (_this MaybeKeyMap) Is_DontUseKeys() bool {
	_, ok := _this.Get_().(MaybeKeyMap_DontUseKeys)
	return ok
}

type MaybeKeyMap_ShouldHaveKeys struct {
}

func (MaybeKeyMap_ShouldHaveKeys) isMaybeKeyMap() {}

func (CompanionStruct_MaybeKeyMap_) Create_ShouldHaveKeys_() MaybeKeyMap {
	return MaybeKeyMap{MaybeKeyMap_ShouldHaveKeys{}}
}

func (_this MaybeKeyMap) Is_ShouldHaveKeys() bool {
	_, ok := _this.Get_().(MaybeKeyMap_ShouldHaveKeys)
	return ok
}

type MaybeKeyMap_Keys struct {
	Value _dafny.Map
}

func (MaybeKeyMap_Keys) isMaybeKeyMap() {}

func (CompanionStruct_MaybeKeyMap_) Create_Keys_(Value _dafny.Map) MaybeKeyMap {
	return MaybeKeyMap{MaybeKeyMap_Keys{Value}}
}

func (_this MaybeKeyMap) Is_Keys() bool {
	_, ok := _this.Get_().(MaybeKeyMap_Keys)
	return ok
}

func (CompanionStruct_MaybeKeyMap_) Default() MaybeKeyMap {
	return Companion_MaybeKeyMap_.Create_DontUseKeys_()
}

func (_this MaybeKeyMap) Dtor_value() _dafny.Map {
	return _this.Get_().(MaybeKeyMap_Keys).Value
}

func (_this MaybeKeyMap) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case MaybeKeyMap_DontUseKeys:
		{
			return "DynamoDbEncryptionUtil.MaybeKeyMap.DontUseKeys"
		}
	case MaybeKeyMap_ShouldHaveKeys:
		{
			return "DynamoDbEncryptionUtil.MaybeKeyMap.ShouldHaveKeys"
		}
	case MaybeKeyMap_Keys:
		{
			return "DynamoDbEncryptionUtil.MaybeKeyMap.Keys" + "(" + _dafny.String(data.Value) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this MaybeKeyMap) Equals(other MaybeKeyMap) bool {
	switch data1 := _this.Get_().(type) {
	case MaybeKeyMap_DontUseKeys:
		{
			_, ok := other.Get_().(MaybeKeyMap_DontUseKeys)
			return ok
		}
	case MaybeKeyMap_ShouldHaveKeys:
		{
			_, ok := other.Get_().(MaybeKeyMap_ShouldHaveKeys)
			return ok
		}
	case MaybeKeyMap_Keys:
		{
			data2, ok := other.Get_().(MaybeKeyMap_Keys)
			return ok && data1.Value.Equals(data2.Value)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this MaybeKeyMap) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(MaybeKeyMap)
	return ok && _this.Equals(typed)
}

func Type_MaybeKeyMap_() _dafny.TypeDescriptor {
	return type_MaybeKeyMap_{}
}

type type_MaybeKeyMap_ struct {
}

func (_this type_MaybeKeyMap_) Default() interface{} {
	return Companion_MaybeKeyMap_.Default()
}

func (_this type_MaybeKeyMap_) String() string {
	return "DynamoDbEncryptionUtil.MaybeKeyMap"
}
func (_this MaybeKeyMap) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = MaybeKeyMap{}

// End of datatype MaybeKeyMap

// Definition of datatype MaybeKeyId
type MaybeKeyId struct {
	Data_MaybeKeyId_
}

func (_this MaybeKeyId) Get_() Data_MaybeKeyId_ {
	return _this.Data_MaybeKeyId_
}

type Data_MaybeKeyId_ interface {
	isMaybeKeyId()
}

type CompanionStruct_MaybeKeyId_ struct {
}

var Companion_MaybeKeyId_ = CompanionStruct_MaybeKeyId_{}

type MaybeKeyId_DontUseKeyId struct {
}

func (MaybeKeyId_DontUseKeyId) isMaybeKeyId() {}

func (CompanionStruct_MaybeKeyId_) Create_DontUseKeyId_() MaybeKeyId {
	return MaybeKeyId{MaybeKeyId_DontUseKeyId{}}
}

func (_this MaybeKeyId) Is_DontUseKeyId() bool {
	_, ok := _this.Get_().(MaybeKeyId_DontUseKeyId)
	return ok
}

type MaybeKeyId_ShouldHaveKeyId struct {
}

func (MaybeKeyId_ShouldHaveKeyId) isMaybeKeyId() {}

func (CompanionStruct_MaybeKeyId_) Create_ShouldHaveKeyId_() MaybeKeyId {
	return MaybeKeyId{MaybeKeyId_ShouldHaveKeyId{}}
}

func (_this MaybeKeyId) Is_ShouldHaveKeyId() bool {
	_, ok := _this.Get_().(MaybeKeyId_ShouldHaveKeyId)
	return ok
}

type MaybeKeyId_KeyId struct {
	Value _dafny.Sequence
}

func (MaybeKeyId_KeyId) isMaybeKeyId() {}

func (CompanionStruct_MaybeKeyId_) Create_KeyId_(Value _dafny.Sequence) MaybeKeyId {
	return MaybeKeyId{MaybeKeyId_KeyId{Value}}
}

func (_this MaybeKeyId) Is_KeyId() bool {
	_, ok := _this.Get_().(MaybeKeyId_KeyId)
	return ok
}

func (CompanionStruct_MaybeKeyId_) Default() MaybeKeyId {
	return Companion_MaybeKeyId_.Create_DontUseKeyId_()
}

func (_this MaybeKeyId) Dtor_value() _dafny.Sequence {
	return _this.Get_().(MaybeKeyId_KeyId).Value
}

func (_this MaybeKeyId) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case MaybeKeyId_DontUseKeyId:
		{
			return "DynamoDbEncryptionUtil.MaybeKeyId.DontUseKeyId"
		}
	case MaybeKeyId_ShouldHaveKeyId:
		{
			return "DynamoDbEncryptionUtil.MaybeKeyId.ShouldHaveKeyId"
		}
	case MaybeKeyId_KeyId:
		{
			return "DynamoDbEncryptionUtil.MaybeKeyId.KeyId" + "(" + _dafny.String(data.Value) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this MaybeKeyId) Equals(other MaybeKeyId) bool {
	switch data1 := _this.Get_().(type) {
	case MaybeKeyId_DontUseKeyId:
		{
			_, ok := other.Get_().(MaybeKeyId_DontUseKeyId)
			return ok
		}
	case MaybeKeyId_ShouldHaveKeyId:
		{
			_, ok := other.Get_().(MaybeKeyId_ShouldHaveKeyId)
			return ok
		}
	case MaybeKeyId_KeyId:
		{
			data2, ok := other.Get_().(MaybeKeyId_KeyId)
			return ok && data1.Value.Equals(data2.Value)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this MaybeKeyId) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(MaybeKeyId)
	return ok && _this.Equals(typed)
}

func Type_MaybeKeyId_() _dafny.TypeDescriptor {
	return type_MaybeKeyId_{}
}

type type_MaybeKeyId_ struct {
}

func (_this type_MaybeKeyId_) Default() interface{} {
	return Companion_MaybeKeyId_.Default()
}

func (_this type_MaybeKeyId_) String() string {
	return "DynamoDbEncryptionUtil.MaybeKeyId"
}
func (_this MaybeKeyId) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = MaybeKeyId{}

// End of datatype MaybeKeyId
