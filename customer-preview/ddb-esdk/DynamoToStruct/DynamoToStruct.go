// Package DynamoToStruct
// Dafny module DynamoToStruct compiled into Go

package DynamoToStruct

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
	m_SortedSets "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/SortedSets"
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
	m_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/ddb-esdk/AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes"
	m_AwsCryptographyDbEncryptionSdkDynamoDbTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/ddb-esdk/AwsCryptographyDbEncryptionSdkDynamoDbTypes"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/ddb-esdk/AwsCryptographyDbEncryptionSdkStructuredEncryptionOperations"
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/ddb-esdk/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes"
	m_Canonize "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/ddb-esdk/Canonize"
	m_DynamoDbEncryptionUtil "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/ddb-esdk/DynamoDbEncryptionUtil"
	m_DynamoDbNormalizeNumber "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/ddb-esdk/DynamoDbNormalizeNumber"
	m__Maps "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/ddb-esdk/Maps_"
	m_Sets "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/ddb-esdk/Sets"
	m_SortCanon "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/ddb-esdk/SortCanon"
	m_StructuredEncryption "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/ddb-esdk/StructuredEncryption"
	m_StructuredEncryptionCrypt "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/ddb-esdk/StructuredEncryptionCrypt"
	m_StructuredEncryptionFooter "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/ddb-esdk/StructuredEncryptionFooter"
	m_StructuredEncryptionHeader "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/ddb-esdk/StructuredEncryptionHeader"
	m_StructuredEncryptionPaths "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/ddb-esdk/StructuredEncryptionPaths"
	m_StructuredEncryptionUtil "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/ddb-esdk/StructuredEncryptionUtil"
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
var _ m_MultiKeyring.Dummy__
var _ m_AwsArnParsing.Dummy__
var _ m_AwsKmsMrkAreUnique.Dummy__
var _ m_Actions.Dummy__
var _ m_AwsKmsMrkMatchForDecrypt.Dummy__
var _ m_AwsKmsUtils.Dummy__
var _ m_Constants.Dummy__
var _ m_MaterialWrapping.Dummy__
var _ m_CanonicalEncryptionContext.Dummy__
var _ m_IntermediateKeyWrapping.Dummy__
var _ m_EdkWrapping.Dummy__
var _ m_ErrorMessages.Dummy__
var _ m_AwsKmsKeyring.Dummy__
var _ m_StrictMultiKeyring.Dummy__
var _ m_AwsKmsDiscoveryKeyring.Dummy__
var _ m_Com_Amazonaws_Kms.Dummy__
var _ m_Com_Amazonaws_Dynamodb.Dummy__
var _ m_DiscoveryMultiKeyring.Dummy__
var _ m_AwsKmsMrkDiscoveryKeyring.Dummy__
var _ m_MrkAwareDiscoveryMultiKeyring.Dummy__
var _ m_AwsKmsMrkKeyring.Dummy__
var _ m_MrkAwareStrictMultiKeyring.Dummy__
var _ m_LocalCMC.Dummy__
var _ m_SynchronizedLocalCMC.Dummy__
var _ m_StormTracker.Dummy__
var _ m_StormTrackingCMC.Dummy__
var _ m_CacheConstants.Dummy__
var _ m_AwsKmsHierarchicalKeyring.Dummy__
var _ m_AwsKmsRsaKeyring.Dummy__
var _ m_EcdhEdkWrapping.Dummy__
var _ m_RawECDHKeyring.Dummy__
var _ m_AwsKmsEcdhKeyring.Dummy__
var _ m_RawAESKeyring.Dummy__
var _ m_RawRSAKeyring.Dummy__
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
var _ m_FileIO.Dummy__
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
	return "DynamoToStruct.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) ItemToStructured(item _dafny.Map) m_Wrappers.Result {
	var _0_structuredMap _dafny.Map = func() _dafny.Map {
		var _coll0 = _dafny.NewMapBuilder()
		_ = _coll0
		for _iter11 := _dafny.Iterate((item).Keys().Elements()); ; {
			_compr_0, _ok11 := _iter11()
			if !_ok11 {
				break
			}
			var _1_k _dafny.Sequence
			_1_k = interface{}(_compr_0).(_dafny.Sequence)
			if m_ComAmazonawsDynamodbTypes.Companion_AttributeName_.Is_(_1_k) {
				if (item).Contains(_1_k) {
					_coll0.Add(_1_k, Companion_Default___.AttrToStructured((item).Get(_1_k).(m_ComAmazonawsDynamodbTypes.AttributeValue)))
				}
			}
		}
		return _coll0.ToMap()
	}()
	_ = _0_structuredMap
	return Companion_Default___.MapError(Companion_Default___.SimplifyMapValue(_0_structuredMap))
}
func (_static *CompanionStruct_Default___) StructuredToItem(s _dafny.Map) m_Wrappers.Result {
	if _dafny.Quantifier(((s).Keys()).Elements(), true, func(_forall_var_0 _dafny.Sequence) bool {
		var _0_k _dafny.Sequence
		_0_k = interface{}(_forall_var_0).(_dafny.Sequence)
		return !(((s).Keys()).Contains(_0_k)) || (m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__AttributeName(_0_k))
	}) {
		var _1_structuredData _dafny.Map = func() _dafny.Map {
			var _coll0 = _dafny.NewMapBuilder()
			_ = _coll0
			for _iter12 := _dafny.Iterate((s).Keys().Elements()); ; {
				_compr_0, _ok12 := _iter12()
				if !_ok12 {
					break
				}
				var _2_k _dafny.Sequence
				_2_k = interface{}(_compr_0).(_dafny.Sequence)
				if m_ComAmazonawsDynamodbTypes.Companion_AttributeName_.Is_(_2_k) {
					if (s).Contains(_2_k) {
						_coll0.Add(_2_k, Companion_Default___.StructuredToAttr((s).Get(_2_k).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal)))
					}
				}
			}
			return _coll0.ToMap()
		}()
		_ = _1_structuredData
		return Companion_Default___.MapError(Companion_Default___.SimplifyMapValue(_1_structuredData))
	} else {
		var _3_badNames _dafny.Set = func() _dafny.Set {
			var _coll1 = _dafny.NewBuilder()
			_ = _coll1
			for _iter13 := _dafny.Iterate((s).Keys().Elements()); ; {
				_compr_1, _ok13 := _iter13()
				if !_ok13 {
					break
				}
				var _4_k _dafny.Sequence
				_4_k = interface{}(_compr_1).(_dafny.Sequence)
				if ((s).Contains(_4_k)) && (!(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__AttributeName(_4_k))) {
					_coll1.Add(_4_k)
				}
			}
			return _coll1.ToSet()
		}()
		_ = _3_badNames
		var _5_orderedAttrNames _dafny.Sequence = m_StandardLibrary.Companion_Default___.SetToOrderedSequence(_3_badNames, func(coer40 func(_dafny.Char, _dafny.Char) bool) func(interface{}, interface{}) bool {
			return func(arg52 interface{}, arg53 interface{}) bool {
				return coer40(arg52.(_dafny.Char), arg53.(_dafny.Char))
			}
		}(Companion_Default___.CharLess))
		_ = _5_orderedAttrNames
		var _6_attrNameList _dafny.Sequence = m_StandardLibrary.Companion_Default___.Join(_5_orderedAttrNames, _dafny.SeqOfString(","))
		_ = _6_attrNameList
		return Companion_Default___.MakeError(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Not valid attribute names : "), _6_attrNameList))
	}
}
func (_static *CompanionStruct_Default___) MakeError(s _dafny.Sequence) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Failure_(m_AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_Error_.Create_DynamoDbEncryptionException_(s))
}
func (_static *CompanionStruct_Default___) MapError(r m_Wrappers.Result) m_Wrappers.Result {
	if (r).Is_Success() {
		return m_Wrappers.Companion_Result_.Create_Success_((r).Dtor_value())
	} else {
		return Companion_Default___.MakeError((r).Dtor_error().(_dafny.Sequence))
	}
}
func (_static *CompanionStruct_Default___) TopLevelAttributeToBytes(a m_ComAmazonawsDynamodbTypes.AttributeValue) m_Wrappers.Result {
	return Companion_Default___.AttrToBytes(a, false, _dafny.One)
}
func (_static *CompanionStruct_Default___) AttrToStructured(item m_ComAmazonawsDynamodbTypes.AttributeValue) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.TopLevelAttributeToBytes(item)
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_body _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
		_ = _1_body
		return m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_StructuredDataTerminal_.Create_StructuredDataTerminal_(_1_body, Companion_Default___.AttrToTypeId(item)))
	}
}
func (_static *CompanionStruct_Default___) StructuredToAttr(s m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32(((s).Dtor_typeId()).Cardinality())).Cmp(_dafny.IntOfInt64(2)) == 0, _dafny.SeqOfString("Type ID must be two bytes"))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_valueOrError1 m_Wrappers.Result = Companion_Default___.BytesToAttr((s).Dtor_value(), (s).Dtor_typeId(), false, _dafny.One)
		_ = _1_valueOrError1
		if (_1_valueOrError1).IsFailure() {
			return (_1_valueOrError1).PropagateFailure()
		} else {
			var _2_attrValueAndLength AttrValueAndLength = (_1_valueOrError1).Extract().(AttrValueAndLength)
			_ = _2_attrValueAndLength
			var _3_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(((_2_attrValueAndLength).Dtor_len()).Cmp(_dafny.IntOfUint32(((s).Dtor_value()).Cardinality())) == 0, _dafny.SeqOfString("Mismatch between length of encoded data and length of data"))
			_ = _3_valueOrError2
			if (_3_valueOrError2).IsFailure() {
				return (_3_valueOrError2).PropagateFailure()
			} else {
				return m_Wrappers.Companion_Result_.Create_Success_((_2_attrValueAndLength).Dtor_val())
			}
		}
	}
}
func (_static *CompanionStruct_Default___) AttrToTypeId(a m_ComAmazonawsDynamodbTypes.AttributeValue) _dafny.Sequence {
	var _source0 m_ComAmazonawsDynamodbTypes.AttributeValue = a
	_ = _source0
	{
		if _source0.Is_S() {
			var _0_s _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_S).S
			_ = _0_s
			return m_StructuredEncryptionUtil.Companion_Default___.STRING()
		}
	}
	{
		if _source0.Is_N() {
			var _1_n _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_N).N
			_ = _1_n
			return m_StructuredEncryptionUtil.Companion_Default___.NUMBER()
		}
	}
	{
		if _source0.Is_B() {
			var _2_b _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_B).B
			_ = _2_b
			return m_StructuredEncryptionUtil.Companion_Default___.BINARY()
		}
	}
	{
		if _source0.Is_SS() {
			var _3_ss _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_SS).SS
			_ = _3_ss
			return m_StructuredEncryptionUtil.Companion_Default___.STRING__SET()
		}
	}
	{
		if _source0.Is_NS() {
			var _4_ns _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_NS).NS
			_ = _4_ns
			return m_StructuredEncryptionUtil.Companion_Default___.NUMBER__SET()
		}
	}
	{
		if _source0.Is_BS() {
			var _5_bs _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_BS).BS
			_ = _5_bs
			return m_StructuredEncryptionUtil.Companion_Default___.BINARY__SET()
		}
	}
	{
		if _source0.Is_M() {
			var _6_m _dafny.Map = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_M).M
			_ = _6_m
			return m_StructuredEncryptionUtil.Companion_Default___.MAP()
		}
	}
	{
		if _source0.Is_L() {
			var _7_l _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_L).L
			_ = _7_l
			return m_StructuredEncryptionUtil.Companion_Default___.LIST()
		}
	}
	{
		if _source0.Is_NULL() {
			var _8_n bool = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_NULL).NULL
			_ = _8_n
			return m_StructuredEncryptionUtil.Companion_Default___.NULL()
		}
	}
	{
		var _9_b bool = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_BOOL).BOOL
		_ = _9_b
		return m_StructuredEncryptionUtil.Companion_Default___.BOOLEAN()
	}
}
func (_static *CompanionStruct_Default___) CharLess(x _dafny.Char, y _dafny.Char) bool {
	return (x) < (y)
}
func (_static *CompanionStruct_Default___) AttrToBytes(a m_ComAmazonawsDynamodbTypes.AttributeValue, prefix bool, depth _dafny.Int) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((depth).Cmp(m_DynamoDbEncryptionUtil.Companion_Default___.MAX__STRUCTURE__DEPTH()) <= 0, _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Depth of attribute structure to serialize exceeds limit of "), m_DynamoDbEncryptionUtil.Companion_Default___.MAX__STRUCTURE__DEPTH__STR()))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_valueOrError1 m_Wrappers.Result = func() m_Wrappers.Result {
			var _source0 m_ComAmazonawsDynamodbTypes.AttributeValue = a
			_ = _source0
			{
				if _source0.Is_S() {
					var _2_s _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_S).S
					_ = _2_s
					return m_UTF8.Encode(_2_s)
				}
			}
			{
				if _source0.Is_N() {
					var _3_n _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_N).N
					_ = _3_n
					var _4_valueOrError2 m_Wrappers.Result = m_DynamoDbNormalizeNumber.Companion_Default___.NormalizeNumber(_3_n)
					_ = _4_valueOrError2
					if (_4_valueOrError2).IsFailure() {
						return (_4_valueOrError2).PropagateFailure()
					} else {
						var _5_nn _dafny.Sequence = (_4_valueOrError2).Extract().(_dafny.Sequence)
						_ = _5_nn
						return m_UTF8.Encode(_5_nn)
					}
				}
			}
			{
				if _source0.Is_B() {
					var _6_b _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_B).B
					_ = _6_b
					return m_Wrappers.Companion_Result_.Create_Success_(_6_b)
				}
			}
			{
				if _source0.Is_SS() {
					var _7_ss _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_SS).SS
					_ = _7_ss
					return Companion_Default___.StringSetAttrToBytes(_7_ss)
				}
			}
			{
				if _source0.Is_NS() {
					var _8_ns _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_NS).NS
					_ = _8_ns
					return Companion_Default___.NumberSetAttrToBytes(_8_ns)
				}
			}
			{
				if _source0.Is_BS() {
					var _9_bs _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_BS).BS
					_ = _9_bs
					return Companion_Default___.BinarySetAttrToBytes(_9_bs)
				}
			}
			{
				if _source0.Is_M() {
					var _10_m _dafny.Map = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_M).M
					_ = _10_m
					return Companion_Default___.MapAttrToBytes(_10_m, depth)
				}
			}
			{
				if _source0.Is_L() {
					var _11_l _dafny.Sequence = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_L).L
					_ = _11_l
					return Companion_Default___.ListAttrToBytes(_11_l, depth)
				}
			}
			{
				if _source0.Is_NULL() {
					var _12_n bool = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_NULL).NULL
					_ = _12_n
					return m_Wrappers.Companion_Result_.Create_Success_(_dafny.SeqOf())
				}
			}
			{
				var _13_b bool = _source0.Get_().(m_ComAmazonawsDynamodbTypes.AttributeValue_BOOL).BOOL
				_ = _13_b
				return m_Wrappers.Companion_Result_.Create_Success_(_dafny.SeqOf(Companion_Default___.BoolToUint8(_13_b)))
			}
		}()
		_ = _1_valueOrError1
		if (_1_valueOrError1).IsFailure() {
			return (_1_valueOrError1).PropagateFailure()
		} else {
			var _14_baseBytes _dafny.Sequence = (_1_valueOrError1).Extract().(_dafny.Sequence)
			_ = _14_baseBytes
			if prefix {
				var _15_valueOrError3 m_Wrappers.Result = Companion_Default___.U32ToBigEndian(_dafny.IntOfUint32((_14_baseBytes).Cardinality()))
				_ = _15_valueOrError3
				if (_15_valueOrError3).IsFailure() {
					return (_15_valueOrError3).PropagateFailure()
				} else {
					var _16_len _dafny.Sequence = (_15_valueOrError3).Extract().(_dafny.Sequence)
					_ = _16_len
					return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(Companion_Default___.AttrToTypeId(a), _16_len), _14_baseBytes))
				}
			} else {
				return m_Wrappers.Companion_Result_.Create_Success_(_14_baseBytes)
			}
		}
	}
}
func (_static *CompanionStruct_Default___) StringSetAttrToBytes(ss _dafny.Sequence) m_Wrappers.Result {
	var _0_asSet _dafny.Set = m_Seq.Companion_Default___.ToSet(ss)
	_ = _0_asSet
	var _1_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(((_0_asSet).Cardinality()).Cmp(_dafny.IntOfUint32((ss).Cardinality())) == 0, _dafny.SeqOfString("String Set had duplicate values"))
	_ = _1_valueOrError0
	if (_1_valueOrError0).IsFailure() {
		return (_1_valueOrError0).PropagateFailure()
	} else {
		var _2_sortedList _dafny.Sequence = m_SortedSets.SetToOrderedSequence2(_0_asSet, func(coer41 func(_dafny.Char, _dafny.Char) bool) func(interface{}, interface{}) bool {
			return func(arg54 interface{}, arg55 interface{}) bool {
				return coer41(arg54.(_dafny.Char), arg55.(_dafny.Char))
			}
		}(Companion_Default___.CharLess))
		_ = _2_sortedList
		var _3_valueOrError1 m_Wrappers.Result = Companion_Default___.U32ToBigEndian(_dafny.IntOfUint32((_2_sortedList).Cardinality()))
		_ = _3_valueOrError1
		if (_3_valueOrError1).IsFailure() {
			return (_3_valueOrError1).PropagateFailure()
		} else {
			var _4_count _dafny.Sequence = (_3_valueOrError1).Extract().(_dafny.Sequence)
			_ = _4_count
			var _5_valueOrError2 m_Wrappers.Result = Companion_Default___.CollectString(_2_sortedList, _dafny.SeqOf())
			_ = _5_valueOrError2
			if (_5_valueOrError2).IsFailure() {
				return (_5_valueOrError2).PropagateFailure()
			} else {
				var _6_body _dafny.Sequence = (_5_valueOrError2).Extract().(_dafny.Sequence)
				_ = _6_body
				return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Concatenate(_4_count, _6_body))
			}
		}
	}
}
func (_static *CompanionStruct_Default___) NumberSetAttrToBytes(ns _dafny.Sequence) m_Wrappers.Result {
	var _0_asSet _dafny.Set = m_Seq.Companion_Default___.ToSet(ns)
	_ = _0_asSet
	var _1_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(((_0_asSet).Cardinality()).Cmp(_dafny.IntOfUint32((ns).Cardinality())) == 0, _dafny.SeqOfString("Number Set had duplicate values"))
	_ = _1_valueOrError0
	if (_1_valueOrError0).IsFailure() {
		return (_1_valueOrError0).PropagateFailure()
	} else {
		var _2_valueOrError1 m_Wrappers.Result = m_Seq.Companion_Default___.MapWithResult(func(coer42 func(_dafny.Sequence) m_Wrappers.Result) func(interface{}) m_Wrappers.Result {
			return func(arg56 interface{}) m_Wrappers.Result {
				return coer42(arg56.(_dafny.Sequence))
			}
		}(func(_3_n _dafny.Sequence) m_Wrappers.Result {
			return m_DynamoDbNormalizeNumber.Companion_Default___.NormalizeNumber(_3_n)
		}), ns)
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			var _4_normList _dafny.Sequence = (_2_valueOrError1).Extract().(_dafny.Sequence)
			_ = _4_normList
			var _5_asSet _dafny.Set = m_Seq.Companion_Default___.ToSet(_4_normList)
			_ = _5_asSet
			var _6_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(((_5_asSet).Cardinality()).Cmp(_dafny.IntOfUint32((_4_normList).Cardinality())) == 0, _dafny.SeqOfString("Number Set had duplicate values after normalization."))
			_ = _6_valueOrError2
			if (_6_valueOrError2).IsFailure() {
				return (_6_valueOrError2).PropagateFailure()
			} else {
				var _7_sortedList _dafny.Sequence = m_SortedSets.SetToOrderedSequence2(_5_asSet, func(coer43 func(_dafny.Char, _dafny.Char) bool) func(interface{}, interface{}) bool {
					return func(arg57 interface{}, arg58 interface{}) bool {
						return coer43(arg57.(_dafny.Char), arg58.(_dafny.Char))
					}
				}(Companion_Default___.CharLess))
				_ = _7_sortedList
				var _8_valueOrError3 m_Wrappers.Result = Companion_Default___.U32ToBigEndian(_dafny.IntOfUint32((_7_sortedList).Cardinality()))
				_ = _8_valueOrError3
				if (_8_valueOrError3).IsFailure() {
					return (_8_valueOrError3).PropagateFailure()
				} else {
					var _9_count _dafny.Sequence = (_8_valueOrError3).Extract().(_dafny.Sequence)
					_ = _9_count
					var _10_valueOrError4 m_Wrappers.Result = Companion_Default___.CollectString(_7_sortedList, _dafny.SeqOf())
					_ = _10_valueOrError4
					if (_10_valueOrError4).IsFailure() {
						return (_10_valueOrError4).PropagateFailure()
					} else {
						var _11_body _dafny.Sequence = (_10_valueOrError4).Extract().(_dafny.Sequence)
						_ = _11_body
						return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Concatenate(_9_count, _11_body))
					}
				}
			}
		}
	}
}
func (_static *CompanionStruct_Default___) BinarySetAttrToBytes(bs _dafny.Sequence) m_Wrappers.Result {
	var _0_asSet _dafny.Set = m_Seq.Companion_Default___.ToSet(bs)
	_ = _0_asSet
	var _1_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(((_0_asSet).Cardinality()).Cmp(_dafny.IntOfUint32((bs).Cardinality())) == 0, _dafny.SeqOfString("Binary Set had duplicate values"))
	_ = _1_valueOrError0
	if (_1_valueOrError0).IsFailure() {
		return (_1_valueOrError0).PropagateFailure()
	} else {
		var _2_sortedList _dafny.Sequence = m_SortedSets.SetToOrderedSequence2(_0_asSet, func(coer44 func(uint8, uint8) bool) func(interface{}, interface{}) bool {
			return func(arg59 interface{}, arg60 interface{}) bool {
				return coer44(arg59.(uint8), arg60.(uint8))
			}
		}(m_DynamoDbEncryptionUtil.Companion_Default___.ByteLess))
		_ = _2_sortedList
		var _3_valueOrError1 m_Wrappers.Result = Companion_Default___.U32ToBigEndian(_dafny.IntOfUint32((_2_sortedList).Cardinality()))
		_ = _3_valueOrError1
		if (_3_valueOrError1).IsFailure() {
			return (_3_valueOrError1).PropagateFailure()
		} else {
			var _4_count _dafny.Sequence = (_3_valueOrError1).Extract().(_dafny.Sequence)
			_ = _4_count
			var _5_valueOrError2 m_Wrappers.Result = Companion_Default___.CollectBinary(_2_sortedList, _dafny.SeqOf())
			_ = _5_valueOrError2
			if (_5_valueOrError2).IsFailure() {
				return (_5_valueOrError2).PropagateFailure()
			} else {
				var _6_body _dafny.Sequence = (_5_valueOrError2).Extract().(_dafny.Sequence)
				_ = _6_body
				return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Concatenate(_4_count, _6_body))
			}
		}
	}
}
func (_static *CompanionStruct_Default___) MapAttrToBytes(m _dafny.Map, depth _dafny.Int) m_Wrappers.Result {
	var _0_bytesResults _dafny.Map = func() _dafny.Map {
		var _coll0 = _dafny.NewMapBuilder()
		_ = _coll0
		for _iter14 := _dafny.Iterate(((m).Items()).Elements()); ; {
			_compr_0, _ok14 := _iter14()
			if !_ok14 {
				break
			}
			var _1_kv _dafny.Tuple
			_1_kv = interface{}(_compr_0).(_dafny.Tuple)
			if ((m).Items()).Contains(_1_kv) {
				_coll0.Add((*(_1_kv).IndexInt(0)).(_dafny.Sequence), Companion_Default___.AttrToBytes((*(_1_kv).IndexInt(1)).(m_ComAmazonawsDynamodbTypes.AttributeValue), true, (depth).Plus(_dafny.One)))
			}
		}
		return _coll0.ToMap()
	}()
	_ = _0_bytesResults
	var _2_valueOrError0 m_Wrappers.Result = Companion_Default___.U32ToBigEndian((m).Cardinality())
	_ = _2_valueOrError0
	if (_2_valueOrError0).IsFailure() {
		return (_2_valueOrError0).PropagateFailure()
	} else {
		var _3_count _dafny.Sequence = (_2_valueOrError0).Extract().(_dafny.Sequence)
		_ = _3_count
		var _4_valueOrError1 m_Wrappers.Result = Companion_Default___.SimplifyMapValue(_0_bytesResults)
		_ = _4_valueOrError1
		if (_4_valueOrError1).IsFailure() {
			return (_4_valueOrError1).PropagateFailure()
		} else {
			var _5_bytes _dafny.Map = (_4_valueOrError1).Extract().(_dafny.Map)
			_ = _5_bytes
			var _6_valueOrError2 m_Wrappers.Result = Companion_Default___.CollectMap(_5_bytes, _dafny.SeqOf())
			_ = _6_valueOrError2
			if (_6_valueOrError2).IsFailure() {
				return (_6_valueOrError2).PropagateFailure()
			} else {
				var _7_body _dafny.Sequence = (_6_valueOrError2).Extract().(_dafny.Sequence)
				_ = _7_body
				return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Concatenate(_3_count, _7_body))
			}
		}
	}
}
func (_static *CompanionStruct_Default___) ListAttrToBytes(l _dafny.Sequence, depth _dafny.Int) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.U32ToBigEndian(_dafny.IntOfUint32((l).Cardinality()))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_count _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
		_ = _1_count
		var _2_valueOrError1 m_Wrappers.Result = Companion_Default___.CollectList(l, depth, _dafny.SeqOf())
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			var _3_body _dafny.Sequence = (_2_valueOrError1).Extract().(_dafny.Sequence)
			_ = _3_body
			return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Concatenate(_1_count, _3_body))
		}
	}
}
func (_static *CompanionStruct_Default___) U32ToBigEndian(x _dafny.Int) m_Wrappers.Result {
	if (x).Cmp(_dafny.IntOfInt64(4294967295)) > 0 {
		return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Length was too big"))
	} else {
		return m_Wrappers.Companion_Result_.Create_Success_(m_StandardLibrary_UInt.Companion_Default___.UInt32ToSeq((x).Uint32()))
	}
}
func (_static *CompanionStruct_Default___) BigEndianToU32(x _dafny.Sequence) m_Wrappers.Result {
	if (_dafny.IntOfUint32((x).Cardinality())).Cmp(Companion_Default___.LENGTH__LEN()) < 0 {
		return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Length of 4-byte integer was less than 4"))
	} else {
		return m_Wrappers.Companion_Result_.Create_Success_(_dafny.IntOfUint32(m_StandardLibrary_UInt.Companion_Default___.SeqToUInt32((x).Take((Companion_Default___.LENGTH__LEN()).Uint32()))))
	}
}
func (_static *CompanionStruct_Default___) EncodeString(s _dafny.Sequence) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = m_UTF8.Encode(s)
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_val _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
		_ = _1_val
		var _2_valueOrError1 m_Wrappers.Result = Companion_Default___.U32ToBigEndian(_dafny.IntOfUint32((_1_val).Cardinality()))
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			var _3_len _dafny.Sequence = (_2_valueOrError1).Extract().(_dafny.Sequence)
			_ = _3_len
			return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Concatenate(_3_len, _1_val))
		}
	}
}
func (_static *CompanionStruct_Default___) CollectString(setToSerialize _dafny.Sequence, serialized _dafny.Sequence) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((setToSerialize).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(serialized)
	} else {
		var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.EncodeString((setToSerialize).Select(0).(_dafny.Sequence))
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_entry _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
			_ = _1_entry
			var _in0 _dafny.Sequence = (setToSerialize).Drop(1)
			_ = _in0
			var _in1 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(serialized, _1_entry)
			_ = _in1
			setToSerialize = _in0
			serialized = _in1
			goto TAIL_CALL_START
		}
	}
}
func (_static *CompanionStruct_Default___) SerializeBinaryValue(b _dafny.Sequence) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.U32ToBigEndian(_dafny.IntOfUint32((b).Cardinality()))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_len _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
		_ = _1_len
		return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Concatenate(_1_len, b))
	}
}
func (_static *CompanionStruct_Default___) CollectBinary(setToSerialize _dafny.Sequence, serialized _dafny.Sequence) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((setToSerialize).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(serialized)
	} else {
		var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.SerializeBinaryValue((setToSerialize).Select(0).(_dafny.Sequence))
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_item _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
			_ = _1_item
			var _in0 _dafny.Sequence = (setToSerialize).Drop(1)
			_ = _in0
			var _in1 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(serialized, _1_item)
			_ = _in1
			setToSerialize = _in0
			serialized = _in1
			goto TAIL_CALL_START
		}
	}
}
func (_static *CompanionStruct_Default___) CollectList(listToSerialize _dafny.Sequence, depth _dafny.Int, serialized _dafny.Sequence) m_Wrappers.Result {
	if (_dafny.IntOfUint32((listToSerialize).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(serialized)
	} else {
		var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.AttrToBytes((listToSerialize).Select(0).(m_ComAmazonawsDynamodbTypes.AttributeValue), true, (depth).Plus(_dafny.One))
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_val _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
			_ = _1_val
			return Companion_Default___.CollectList((listToSerialize).Drop(1), depth, _dafny.Companion_Sequence_.Concatenate(serialized, _1_val))
		}
	}
}
func (_static *CompanionStruct_Default___) SerializeMapItem(key _dafny.Sequence, value _dafny.Sequence) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = m_UTF8.Encode(key)
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_name _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
		_ = _1_name
		var _2_valueOrError1 m_Wrappers.Result = Companion_Default___.U32ToBigEndian(_dafny.IntOfUint32((_1_name).Cardinality()))
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			var _3_len _dafny.Sequence = (_2_valueOrError1).Extract().(_dafny.Sequence)
			_ = _3_len
			var _4_serialized _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(m_StructuredEncryptionUtil.Companion_Default___.STRING(), _3_len), _1_name), value)
			_ = _4_serialized
			return m_Wrappers.Companion_Result_.Create_Success_(_4_serialized)
		}
	}
}
func (_static *CompanionStruct_Default___) CollectMap(mapToSerialize _dafny.Map, serialized _dafny.Sequence) m_Wrappers.Result {
	var _0_keys _dafny.Sequence = m_SortedSets.SetToOrderedSequence2((mapToSerialize).Keys(), func(coer45 func(_dafny.Char, _dafny.Char) bool) func(interface{}, interface{}) bool {
		return func(arg61 interface{}, arg62 interface{}) bool {
			return coer45(arg61.(_dafny.Char), arg62.(_dafny.Char))
		}
	}(Companion_Default___.CharLess))
	_ = _0_keys
	return Companion_Default___.CollectOrderedMapSubset(_0_keys, mapToSerialize, serialized)
}
func (_static *CompanionStruct_Default___) CollectOrderedMapSubset(keys _dafny.Sequence, mapToSerialize _dafny.Map, serialized _dafny.Sequence) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((keys).Cardinality())).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(serialized)
	} else {
		var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.SerializeMapItem((keys).Select(0).(_dafny.Sequence), (mapToSerialize).Get((keys).Select(0).(_dafny.Sequence)).(_dafny.Sequence))
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_data _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
			_ = _1_data
			var _in0 _dafny.Sequence = (keys).Drop(1)
			_ = _in0
			var _in1 _dafny.Map = mapToSerialize
			_ = _in1
			var _in2 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(serialized, _1_data)
			_ = _in2
			keys = _in0
			mapToSerialize = _in1
			serialized = _in2
			goto TAIL_CALL_START
		}
	}
}
func (_static *CompanionStruct_Default___) BoolToUint8(b bool) uint8 {
	if b {
		return uint8(1)
	} else {
		return uint8(0)
	}
}
func (_static *CompanionStruct_Default___) IsUnique(s _dafny.Sequence) bool {
	return ((func() _dafny.Set {
		var _coll0 = _dafny.NewBuilder()
		_ = _coll0
		for _iter15 := _dafny.Iterate((s).Elements()); ; {
			_compr_0, _ok15 := _iter15()
			if !_ok15 {
				break
			}
			var _0_x interface{}
			_0_x = interface{}(_compr_0).(interface{})
			if _dafny.Companion_Sequence_.Contains(s, _0_x) {
				_coll0.Add(_0_x)
			}
		}
		return _coll0.ToSet()
	}()).Cardinality()).Cmp(_dafny.IntOfUint32((s).Cardinality())) == 0
}
func (_static *CompanionStruct_Default___) DeserializeBinarySet(serialized _dafny.Sequence, remainingCount _dafny.Int, origSerializedSize _dafny.Int, resultSet AttrValueAndLength) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (remainingCount).Sign() == 0 {
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(Companion_Default___.IsUnique(((resultSet).Dtor_val()).Dtor_BS()), _dafny.SeqOfString("Binary set values must not have duplicates"))
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			return m_Wrappers.Companion_Result_.Create_Success_(resultSet)
		}
	} else if (_dafny.IntOfUint32((serialized).Cardinality())).Cmp(Companion_Default___.LENGTH__LEN()) < 0 {
		return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Out of bytes reading Binary Set"))
	} else {
		var _1_valueOrError1 m_Wrappers.Result = Companion_Default___.BigEndianToU32(serialized)
		_ = _1_valueOrError1
		if (_1_valueOrError1).IsFailure() {
			return (_1_valueOrError1).PropagateFailure()
		} else {
			var _2_len _dafny.Int = (_1_valueOrError1).Extract().(_dafny.Int)
			_ = _2_len
			var _3_serialized _dafny.Sequence = (serialized).Drop((Companion_Default___.LENGTH__LEN()).Uint32())
			_ = _3_serialized
			if (_dafny.IntOfUint32((_3_serialized).Cardinality())).Cmp(_2_len) < 0 {
				return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Binary Set Structured Data has too few bytes"))
			} else {
				var _4_nattr m_ComAmazonawsDynamodbTypes.AttributeValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_BS_(_dafny.Companion_Sequence_.Concatenate(((resultSet).Dtor_val()).Dtor_BS(), _dafny.SeqOf((_3_serialized).Take((_2_len).Uint32()))))
				_ = _4_nattr
				var _in0 _dafny.Sequence = (_3_serialized).Drop((_2_len).Uint32())
				_ = _in0
				var _in1 _dafny.Int = (remainingCount).Minus(_dafny.One)
				_ = _in1
				var _in2 _dafny.Int = origSerializedSize
				_ = _in2
				var _in3 AttrValueAndLength = Companion_AttrValueAndLength_.Create_AttrValueAndLength_(_4_nattr, (((resultSet).Dtor_len()).Plus(_2_len)).Plus(Companion_Default___.LENGTH__LEN()))
				_ = _in3
				serialized = _in0
				remainingCount = _in1
				origSerializedSize = _in2
				resultSet = _in3
				goto TAIL_CALL_START
			}
		}
	}
}
func (_static *CompanionStruct_Default___) DeserializeStringSet(serialized _dafny.Sequence, remainingCount _dafny.Int, origSerializedSize _dafny.Int, resultSet AttrValueAndLength) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (remainingCount).Sign() == 0 {
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(Companion_Default___.IsUnique(((resultSet).Dtor_val()).Dtor_SS()), _dafny.SeqOfString("String set values must not have duplicates"))
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			return m_Wrappers.Companion_Result_.Create_Success_(resultSet)
		}
	} else if (_dafny.IntOfUint32((serialized).Cardinality())).Cmp(Companion_Default___.LENGTH__LEN()) < 0 {
		return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Out of bytes reading String Set"))
	} else {
		var _1_valueOrError1 m_Wrappers.Result = Companion_Default___.BigEndianToU32(serialized)
		_ = _1_valueOrError1
		if (_1_valueOrError1).IsFailure() {
			return (_1_valueOrError1).PropagateFailure()
		} else {
			var _2_len _dafny.Int = (_1_valueOrError1).Extract().(_dafny.Int)
			_ = _2_len
			var _3_serialized _dafny.Sequence = (serialized).Drop((Companion_Default___.LENGTH__LEN()).Uint32())
			_ = _3_serialized
			if (_dafny.IntOfUint32((_3_serialized).Cardinality())).Cmp(_2_len) < 0 {
				return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("String Set Structured Data has too few bytes"))
			} else {
				var _4_valueOrError2 m_Wrappers.Result = m_UTF8.Decode((_3_serialized).Take((_2_len).Uint32()))
				_ = _4_valueOrError2
				if (_4_valueOrError2).IsFailure() {
					return (_4_valueOrError2).PropagateFailure()
				} else {
					var _5_nstring _dafny.Sequence = (_4_valueOrError2).Extract().(_dafny.Sequence)
					_ = _5_nstring
					var _6_nattr m_ComAmazonawsDynamodbTypes.AttributeValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_SS_(_dafny.Companion_Sequence_.Concatenate(((resultSet).Dtor_val()).Dtor_SS(), _dafny.SeqOf(_5_nstring)))
					_ = _6_nattr
					var _in0 _dafny.Sequence = (_3_serialized).Drop((_2_len).Uint32())
					_ = _in0
					var _in1 _dafny.Int = (remainingCount).Minus(_dafny.One)
					_ = _in1
					var _in2 _dafny.Int = origSerializedSize
					_ = _in2
					var _in3 AttrValueAndLength = Companion_AttrValueAndLength_.Create_AttrValueAndLength_(_6_nattr, (((resultSet).Dtor_len()).Plus(_2_len)).Plus(Companion_Default___.LENGTH__LEN()))
					_ = _in3
					serialized = _in0
					remainingCount = _in1
					origSerializedSize = _in2
					resultSet = _in3
					goto TAIL_CALL_START
				}
			}
		}
	}
}
func (_static *CompanionStruct_Default___) DeserializeNumberSet(serialized _dafny.Sequence, remainingCount _dafny.Int, origSerializedSize _dafny.Int, resultSet AttrValueAndLength) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (remainingCount).Sign() == 0 {
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(Companion_Default___.IsUnique(((resultSet).Dtor_val()).Dtor_NS()), _dafny.SeqOfString("Number set values must not have duplicates"))
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			return m_Wrappers.Companion_Result_.Create_Success_(resultSet)
		}
	} else if (_dafny.IntOfUint32((serialized).Cardinality())).Cmp(Companion_Default___.LENGTH__LEN()) < 0 {
		return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Out of bytes reading String Set"))
	} else {
		var _1_valueOrError1 m_Wrappers.Result = Companion_Default___.BigEndianToU32(serialized)
		_ = _1_valueOrError1
		if (_1_valueOrError1).IsFailure() {
			return (_1_valueOrError1).PropagateFailure()
		} else {
			var _2_len _dafny.Int = (_1_valueOrError1).Extract().(_dafny.Int)
			_ = _2_len
			var _3_serialized _dafny.Sequence = (serialized).Drop((Companion_Default___.LENGTH__LEN()).Uint32())
			_ = _3_serialized
			if (_dafny.IntOfUint32((_3_serialized).Cardinality())).Cmp(_2_len) < 0 {
				return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Number Set Structured Data has too few bytes"))
			} else {
				var _4_valueOrError2 m_Wrappers.Result = m_UTF8.Decode((_3_serialized).Take((_2_len).Uint32()))
				_ = _4_valueOrError2
				if (_4_valueOrError2).IsFailure() {
					return (_4_valueOrError2).PropagateFailure()
				} else {
					var _5_nstring _dafny.Sequence = (_4_valueOrError2).Extract().(_dafny.Sequence)
					_ = _5_nstring
					var _6_nattr m_ComAmazonawsDynamodbTypes.AttributeValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_NS_(_dafny.Companion_Sequence_.Concatenate(((resultSet).Dtor_val()).Dtor_NS(), _dafny.SeqOf(_5_nstring)))
					_ = _6_nattr
					var _in0 _dafny.Sequence = (_3_serialized).Drop((_2_len).Uint32())
					_ = _in0
					var _in1 _dafny.Int = (remainingCount).Minus(_dafny.One)
					_ = _in1
					var _in2 _dafny.Int = origSerializedSize
					_ = _in2
					var _in3 AttrValueAndLength = Companion_AttrValueAndLength_.Create_AttrValueAndLength_(_6_nattr, (((resultSet).Dtor_len()).Plus(_2_len)).Plus(Companion_Default___.LENGTH__LEN()))
					_ = _in3
					serialized = _in0
					remainingCount = _in1
					origSerializedSize = _in2
					resultSet = _in3
					goto TAIL_CALL_START
				}
			}
		}
	}
}
func (_static *CompanionStruct_Default___) DeserializeList(serialized _dafny.Sequence, remainingCount _dafny.Int, depth _dafny.Int, resultList AttrValueAndLength) m_Wrappers.Result {
	if (remainingCount).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(resultList)
	} else if (_dafny.IntOfUint32((serialized).Cardinality())).Cmp(_dafny.IntOfInt64(6)) < 0 {
		return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Out of bytes reading Type of List element"))
	} else {
		var _0_TerminalTypeId _dafny.Sequence = (serialized).Subsequence(0, 2)
		_ = _0_TerminalTypeId
		var _1_serialized _dafny.Sequence = (serialized).Drop(2)
		_ = _1_serialized
		var _2_valueOrError0 m_Wrappers.Result = Companion_Default___.BigEndianToU32(_1_serialized)
		_ = _2_valueOrError0
		if (_2_valueOrError0).IsFailure() {
			return (_2_valueOrError0).PropagateFailure()
		} else {
			var _3_len _dafny.Int = (_2_valueOrError0).Extract().(_dafny.Int)
			_ = _3_len
			var _4_serialized _dafny.Sequence = (_1_serialized).Drop((Companion_Default___.LENGTH__LEN()).Uint32())
			_ = _4_serialized
			if (_dafny.IntOfUint32((_4_serialized).Cardinality())).Cmp(_3_len) < 0 {
				return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Out of bytes reading Content of List element"))
			} else {
				var _5_valueOrError1 m_Wrappers.Result = Companion_Default___.BytesToAttr((_4_serialized).Take((_3_len).Uint32()), _0_TerminalTypeId, false, (depth).Plus(_dafny.One))
				_ = _5_valueOrError1
				if (_5_valueOrError1).IsFailure() {
					return (_5_valueOrError1).PropagateFailure()
				} else {
					var _6_nval AttrValueAndLength = (_5_valueOrError1).Extract().(AttrValueAndLength)
					_ = _6_nval
					var _7_nattr m_ComAmazonawsDynamodbTypes.AttributeValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_L_(_dafny.Companion_Sequence_.Concatenate(((resultList).Dtor_val()).Dtor_L(), _dafny.SeqOf((_6_nval).Dtor_val())))
					_ = _7_nattr
					return Companion_Default___.DeserializeList((_4_serialized).Drop((_3_len).Uint32()), (remainingCount).Minus(_dafny.One), depth, Companion_AttrValueAndLength_.Create_AttrValueAndLength_(_7_nattr, (((resultList).Dtor_len()).Plus(_3_len)).Plus(_dafny.IntOfInt64(6))))
				}
			}
		}
	}
}
func (_static *CompanionStruct_Default___) DeserializeMap(serialized _dafny.Sequence, remainingCount _dafny.Int, depth _dafny.Int, resultMap AttrValueAndLength) m_Wrappers.Result {
	if (remainingCount).Sign() == 0 {
		return m_Wrappers.Companion_Result_.Create_Success_(resultMap)
	} else {
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((_dafny.IntOfInt64(6)).Cmp(_dafny.IntOfUint32((serialized).Cardinality())) <= 0, _dafny.SeqOfString("Out of bytes reading Map Key"))
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_TerminalTypeId__key _dafny.Sequence = (serialized).Subsequence(0, 2)
			_ = _1_TerminalTypeId__key
			var _2_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(_dafny.Companion_Sequence_.Equal(_1_TerminalTypeId__key, m_StructuredEncryptionUtil.Companion_Default___.STRING()), _dafny.SeqOfString("Key of Map is not String"))
			_ = _2_valueOrError1
			if (_2_valueOrError1).IsFailure() {
				return (_2_valueOrError1).PropagateFailure()
			} else {
				var _3_serialized _dafny.Sequence = (serialized).Drop(2)
				_ = _3_serialized
				var _4_valueOrError2 m_Wrappers.Result = Companion_Default___.BigEndianToU32(_3_serialized)
				_ = _4_valueOrError2
				if (_4_valueOrError2).IsFailure() {
					return (_4_valueOrError2).PropagateFailure()
				} else {
					var _5_len _dafny.Int = (_4_valueOrError2).Extract().(_dafny.Int)
					_ = _5_len
					var _6_serialized _dafny.Sequence = (_3_serialized).Drop((Companion_Default___.LENGTH__LEN()).Uint32())
					_ = _6_serialized
					var _7_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((_5_len).Cmp(_dafny.IntOfUint32((_6_serialized).Cardinality())) <= 0, _dafny.SeqOfString("Key of Map of Structured Data has too few bytes"))
					_ = _7_valueOrError3
					if (_7_valueOrError3).IsFailure() {
						return (_7_valueOrError3).PropagateFailure()
					} else {
						var _8_valueOrError4 m_Wrappers.Result = m_UTF8.Decode((_6_serialized).Take((_5_len).Uint32()))
						_ = _8_valueOrError4
						if (_8_valueOrError4).IsFailure() {
							return (_8_valueOrError4).PropagateFailure()
						} else {
							var _9_key _dafny.Sequence = (_8_valueOrError4).Extract().(_dafny.Sequence)
							_ = _9_key
							var _10_serialized _dafny.Sequence = (_6_serialized).Drop((_5_len).Uint32())
							_ = _10_serialized
							var _11_valueOrError5 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((_dafny.IntOfInt64(2)).Cmp(_dafny.IntOfUint32((_10_serialized).Cardinality())) <= 0, _dafny.SeqOfString("Out of bytes reading Map Value"))
							_ = _11_valueOrError5
							if (_11_valueOrError5).IsFailure() {
								return (_11_valueOrError5).PropagateFailure()
							} else {
								var _12_valueOrError6 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__AttributeName(_9_key), _dafny.SeqOfString("Key is not valid AttributeName"))
								_ = _12_valueOrError6
								if (_12_valueOrError6).IsFailure() {
									return (_12_valueOrError6).PropagateFailure()
								} else {
									var _13_TerminalTypeId__value _dafny.Sequence = (_10_serialized).Subsequence(0, 2)
									_ = _13_TerminalTypeId__value
									var _14_serialized _dafny.Sequence = (_10_serialized).Drop(2)
									_ = _14_serialized
									var _15_valueOrError7 m_Wrappers.Result = Companion_Default___.BytesToAttr(_14_serialized, _13_TerminalTypeId__value, true, (depth).Plus(_dafny.One))
									_ = _15_valueOrError7
									if (_15_valueOrError7).IsFailure() {
										return (_15_valueOrError7).PropagateFailure()
									} else {
										var _16_nval AttrValueAndLength = (_15_valueOrError7).Extract().(AttrValueAndLength)
										_ = _16_nval
										var _17_serialized _dafny.Sequence = (_14_serialized).Drop(((_16_nval).Dtor_len()).Uint32())
										_ = _17_serialized
										var _18_valueOrError8 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(!(((resultMap).Dtor_val()).Dtor_M()).Contains(_9_key), _dafny.SeqOfString("Duplicate key in map."))
										_ = _18_valueOrError8
										if (_18_valueOrError8).IsFailure() {
											return (_18_valueOrError8).PropagateFailure()
										} else {
											var _19_nattr m_ComAmazonawsDynamodbTypes.AttributeValue = m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_M_((((resultMap).Dtor_val()).Dtor_M()).Update(_9_key, (_16_nval).Dtor_val()))
											_ = _19_nattr
											var _20_newResultMap AttrValueAndLength = Companion_AttrValueAndLength_.Create_AttrValueAndLength_(_19_nattr, ((((resultMap).Dtor_len()).Plus((_16_nval).Dtor_len())).Plus(_dafny.IntOfInt64(8))).Plus(_5_len))
											_ = _20_newResultMap
											return Companion_Default___.DeserializeMap(_17_serialized, (remainingCount).Minus(_dafny.One), depth, _20_newResultMap)
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
func (_static *CompanionStruct_Default___) BytesToAttr(value _dafny.Sequence, typeId _dafny.Sequence, hasLen bool, depth _dafny.Int) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((depth).Cmp(m_DynamoDbEncryptionUtil.Companion_Default___.MAX__STRUCTURE__DEPTH()) <= 0, _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Depth of attribute structure to deserialize exceeds limit of "), m_DynamoDbEncryptionUtil.Companion_Default___.MAX__STRUCTURE__DEPTH__STR()))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_valueOrError1 m_Wrappers.Result = (func() m_Wrappers.Result {
			if hasLen {
				return (func() m_Wrappers.Result {
					if (_dafny.IntOfUint32((value).Cardinality())).Cmp(Companion_Default___.LENGTH__LEN()) < 0 {
						return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Out of bytes reading length"))
					}
					return Companion_Default___.BigEndianToU32(value)
				})()
			}
			return m_Wrappers.Companion_Result_.Create_Success_(_dafny.IntOfUint32((value).Cardinality()))
		})()
		_ = _1_valueOrError1
		if (_1_valueOrError1).IsFailure() {
			return (_1_valueOrError1).PropagateFailure()
		} else {
			var _2_len _dafny.Int = (_1_valueOrError1).Extract().(_dafny.Int)
			_ = _2_len
			var _3_value _dafny.Sequence = (func() _dafny.Sequence {
				if hasLen {
					return (value).Drop((Companion_Default___.LENGTH__LEN()).Uint32())
				}
				return value
			})()
			_ = _3_value
			var _4_lengthBytes _dafny.Int = (func() _dafny.Int {
				if hasLen {
					return Companion_Default___.LENGTH__LEN()
				}
				return _dafny.Zero
			})()
			_ = _4_lengthBytes
			if (_dafny.IntOfUint32((_3_value).Cardinality())).Cmp(_2_len) < 0 {
				return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Structured Data has too few bytes"))
			} else if _dafny.Companion_Sequence_.Equal(typeId, m_StructuredEncryptionUtil.Companion_Default___.NULL()) {
				if (_2_len).Sign() != 0 {
					return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("NULL type did not have length zero"))
				} else {
					return m_Wrappers.Companion_Result_.Create_Success_(Companion_AttrValueAndLength_.Create_AttrValueAndLength_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_NULL_(true), _4_lengthBytes))
				}
			} else if _dafny.Companion_Sequence_.Equal(typeId, m_StructuredEncryptionUtil.Companion_Default___.STRING()) {
				var _5_valueOrError2 m_Wrappers.Result = m_UTF8.Decode((_3_value).Take((_2_len).Uint32()))
				_ = _5_valueOrError2
				if (_5_valueOrError2).IsFailure() {
					return (_5_valueOrError2).PropagateFailure()
				} else {
					var _6_str _dafny.Sequence = (_5_valueOrError2).Extract().(_dafny.Sequence)
					_ = _6_str
					return m_Wrappers.Companion_Result_.Create_Success_(Companion_AttrValueAndLength_.Create_AttrValueAndLength_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_S_(_6_str), (_2_len).Plus(_4_lengthBytes)))
				}
			} else if _dafny.Companion_Sequence_.Equal(typeId, m_StructuredEncryptionUtil.Companion_Default___.NUMBER()) {
				var _7_valueOrError3 m_Wrappers.Result = m_UTF8.Decode((_3_value).Take((_2_len).Uint32()))
				_ = _7_valueOrError3
				if (_7_valueOrError3).IsFailure() {
					return (_7_valueOrError3).PropagateFailure()
				} else {
					var _8_str _dafny.Sequence = (_7_valueOrError3).Extract().(_dafny.Sequence)
					_ = _8_str
					return m_Wrappers.Companion_Result_.Create_Success_(Companion_AttrValueAndLength_.Create_AttrValueAndLength_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_N_(_8_str), (_2_len).Plus(_4_lengthBytes)))
				}
			} else if _dafny.Companion_Sequence_.Equal(typeId, m_StructuredEncryptionUtil.Companion_Default___.BINARY()) {
				return m_Wrappers.Companion_Result_.Create_Success_(Companion_AttrValueAndLength_.Create_AttrValueAndLength_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_B_((_3_value).Take((_2_len).Uint32())), (_2_len).Plus(_4_lengthBytes)))
			} else if _dafny.Companion_Sequence_.Equal(typeId, m_StructuredEncryptionUtil.Companion_Default___.BOOLEAN()) {
				if (_2_len).Cmp(Companion_Default___.BOOL__LEN()) != 0 {
					return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Boolean Structured Data has more than one byte"))
				} else if ((_3_value).Select(0).(uint8)) == (uint8(0)) {
					return m_Wrappers.Companion_Result_.Create_Success_(Companion_AttrValueAndLength_.Create_AttrValueAndLength_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_BOOL_(false), (Companion_Default___.BOOL__LEN()).Plus(_4_lengthBytes)))
				} else if ((_3_value).Select(0).(uint8)) == (uint8(1)) {
					return m_Wrappers.Companion_Result_.Create_Success_(Companion_AttrValueAndLength_.Create_AttrValueAndLength_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_BOOL_(true), (Companion_Default___.BOOL__LEN()).Plus(_4_lengthBytes)))
				} else {
					return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Boolean Structured Data had inappropriate value"))
				}
			} else if _dafny.Companion_Sequence_.Equal(typeId, m_StructuredEncryptionUtil.Companion_Default___.STRING__SET()) {
				if (_dafny.IntOfUint32((_3_value).Cardinality())).Cmp(Companion_Default___.LENGTH__LEN()) < 0 {
					return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("String Set Structured Data has less than LENGTH_LEN bytes"))
				} else {
					var _9_valueOrError4 m_Wrappers.Result = Companion_Default___.BigEndianToU32(_3_value)
					_ = _9_valueOrError4
					if (_9_valueOrError4).IsFailure() {
						return (_9_valueOrError4).PropagateFailure()
					} else {
						var _10_len _dafny.Int = (_9_valueOrError4).Extract().(_dafny.Int)
						_ = _10_len
						var _11_value _dafny.Sequence = (_3_value).Drop((Companion_Default___.LENGTH__LEN()).Uint32())
						_ = _11_value
						return Companion_Default___.DeserializeStringSet(_11_value, _10_len, ((_dafny.IntOfUint32((_11_value).Cardinality())).Plus(Companion_Default___.LENGTH__LEN())).Plus(_4_lengthBytes), Companion_AttrValueAndLength_.Create_AttrValueAndLength_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_SS_(_dafny.SeqOf()), (Companion_Default___.LENGTH__LEN()).Plus(_4_lengthBytes)))
					}
				}
			} else if _dafny.Companion_Sequence_.Equal(typeId, m_StructuredEncryptionUtil.Companion_Default___.NUMBER__SET()) {
				if (_dafny.IntOfUint32((_3_value).Cardinality())).Cmp(Companion_Default___.LENGTH__LEN()) < 0 {
					return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Number Set Structured Data has less than 4 bytes"))
				} else {
					var _12_valueOrError5 m_Wrappers.Result = Companion_Default___.BigEndianToU32(_3_value)
					_ = _12_valueOrError5
					if (_12_valueOrError5).IsFailure() {
						return (_12_valueOrError5).PropagateFailure()
					} else {
						var _13_len _dafny.Int = (_12_valueOrError5).Extract().(_dafny.Int)
						_ = _13_len
						var _14_value _dafny.Sequence = (_3_value).Drop((Companion_Default___.LENGTH__LEN()).Uint32())
						_ = _14_value
						return Companion_Default___.DeserializeNumberSet(_14_value, _13_len, ((_dafny.IntOfUint32((_14_value).Cardinality())).Plus(Companion_Default___.LENGTH__LEN())).Plus(_4_lengthBytes), Companion_AttrValueAndLength_.Create_AttrValueAndLength_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_NS_(_dafny.SeqOf()), (Companion_Default___.LENGTH__LEN()).Plus(_4_lengthBytes)))
					}
				}
			} else if _dafny.Companion_Sequence_.Equal(typeId, m_StructuredEncryptionUtil.Companion_Default___.BINARY__SET()) {
				if (_dafny.IntOfUint32((_3_value).Cardinality())).Cmp(Companion_Default___.LENGTH__LEN()) < 0 {
					return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Binary Set Structured Data has less than LENGTH_LEN bytes"))
				} else {
					var _15_valueOrError6 m_Wrappers.Result = Companion_Default___.BigEndianToU32(_3_value)
					_ = _15_valueOrError6
					if (_15_valueOrError6).IsFailure() {
						return (_15_valueOrError6).PropagateFailure()
					} else {
						var _16_len _dafny.Int = (_15_valueOrError6).Extract().(_dafny.Int)
						_ = _16_len
						var _17_value _dafny.Sequence = (_3_value).Drop((Companion_Default___.LENGTH__LEN()).Uint32())
						_ = _17_value
						return Companion_Default___.DeserializeBinarySet(_17_value, _16_len, ((_dafny.IntOfUint32((_17_value).Cardinality())).Plus(Companion_Default___.LENGTH__LEN())).Plus(_4_lengthBytes), Companion_AttrValueAndLength_.Create_AttrValueAndLength_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_BS_(_dafny.SeqOf()), (Companion_Default___.LENGTH__LEN()).Plus(_4_lengthBytes)))
					}
				}
			} else if _dafny.Companion_Sequence_.Equal(typeId, m_StructuredEncryptionUtil.Companion_Default___.MAP()) {
				if (_dafny.IntOfUint32((_3_value).Cardinality())).Cmp(Companion_Default___.LENGTH__LEN()) < 0 {
					return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("List Structured Data has less than 4 bytes"))
				} else {
					var _18_valueOrError7 m_Wrappers.Result = Companion_Default___.BigEndianToU32(_3_value)
					_ = _18_valueOrError7
					if (_18_valueOrError7).IsFailure() {
						return (_18_valueOrError7).PropagateFailure()
					} else {
						var _19_len _dafny.Int = (_18_valueOrError7).Extract().(_dafny.Int)
						_ = _19_len
						var _20_value _dafny.Sequence = (_3_value).Drop((Companion_Default___.LENGTH__LEN()).Uint32())
						_ = _20_value
						return Companion_Default___.DeserializeMap(_20_value, _19_len, depth, Companion_AttrValueAndLength_.Create_AttrValueAndLength_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_M_(_dafny.NewMapBuilder().ToMap()), (Companion_Default___.LENGTH__LEN()).Plus(_4_lengthBytes)))
					}
				}
			} else if _dafny.Companion_Sequence_.Equal(typeId, m_StructuredEncryptionUtil.Companion_Default___.LIST()) {
				if (_dafny.IntOfUint32((_3_value).Cardinality())).Cmp(Companion_Default___.LENGTH__LEN()) < 0 {
					return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("List Structured Data has less than 4 bytes"))
				} else {
					var _21_valueOrError8 m_Wrappers.Result = Companion_Default___.BigEndianToU32(_3_value)
					_ = _21_valueOrError8
					if (_21_valueOrError8).IsFailure() {
						return (_21_valueOrError8).PropagateFailure()
					} else {
						var _22_len _dafny.Int = (_21_valueOrError8).Extract().(_dafny.Int)
						_ = _22_len
						var _23_value _dafny.Sequence = (_3_value).Drop((Companion_Default___.LENGTH__LEN()).Uint32())
						_ = _23_value
						return Companion_Default___.DeserializeList(_23_value, _22_len, depth, Companion_AttrValueAndLength_.Create_AttrValueAndLength_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Create_L_(_dafny.SeqOf()), (Companion_Default___.LENGTH__LEN()).Plus(_4_lengthBytes)))
					}
				}
			} else {
				return m_Wrappers.Companion_Result_.Create_Failure_(_dafny.SeqOfString("Unsupported TerminalTypeId"))
			}
		}
	}
}
func (_static *CompanionStruct_Default___) FlattenValueMap(m _dafny.Map) _dafny.Map {
	return func() _dafny.Map {
		var _coll0 = _dafny.NewMapBuilder()
		_ = _coll0
		for _iter16 := _dafny.Iterate((m).Keys().Elements()); ; {
			_compr_0, _ok16 := _iter16()
			if !_ok16 {
				break
			}
			var _0_k interface{}
			_0_k = interface{}(_compr_0).(interface{})
			if ((m).Contains(_0_k)) && (((m).Get(_0_k).(m_Wrappers.Result)).Is_Success()) {
				_coll0.Add(_0_k, ((m).Get(_0_k).(m_Wrappers.Result)).Dtor_value())
			}
		}
		return _coll0.ToMap()
	}()
}
func (_static *CompanionStruct_Default___) FlattenErrors(m _dafny.Map) _dafny.Set {
	return func() _dafny.Set {
		var _coll0 = _dafny.NewBuilder()
		_ = _coll0
		for _iter17 := _dafny.Iterate((m).Keys().Elements()); ; {
			_compr_0, _ok17 := _iter17()
			if !_ok17 {
				break
			}
			var _0_k interface{}
			_0_k = interface{}(_compr_0).(interface{})
			if ((m).Contains(_0_k)) && (((m).Get(_0_k).(m_Wrappers.Result)).Is_Failure()) {
				_coll0.Add(((m).Get(_0_k).(m_Wrappers.Result)).Dtor_error().(_dafny.Sequence))
			}
		}
		return _coll0.ToSet()
	}()
}
func (_static *CompanionStruct_Default___) SimplifyMapValue(m _dafny.Map) m_Wrappers.Result {
	if _dafny.Quantifier((m).Keys().Elements(), true, func(_forall_var_0 interface{}) bool {
		var _0_k interface{}
		_0_k = interface{}(_forall_var_0).(interface{})
		return !((m).Contains(_0_k)) || (((m).Get(_0_k).(m_Wrappers.Result)).Is_Success())
	}) {
		var _1_result _dafny.Map = Companion_Default___.FlattenValueMap(m)
		_ = _1_result
		return m_Wrappers.Companion_Result_.Create_Success_(_1_result)
	} else {
		var _2_badValues _dafny.Set = Companion_Default___.FlattenErrors(m)
		_ = _2_badValues
		var _3_badValueSeq _dafny.Sequence = m_StandardLibrary.Companion_Default___.SetToOrderedSequence(_2_badValues, func(coer46 func(_dafny.Char, _dafny.Char) bool) func(interface{}, interface{}) bool {
			return func(arg63 interface{}, arg64 interface{}) bool {
				return coer46(arg63.(_dafny.Char), arg64.(_dafny.Char))
			}
		}(Companion_Default___.CharLess))
		_ = _3_badValueSeq
		return m_Wrappers.Companion_Result_.Create_Failure_(m_StandardLibrary.Companion_Default___.Join(_3_badValueSeq, _dafny.SeqOfString("\n")))
	}
}
func (_static *CompanionStruct_Default___) BOOL__LEN() _dafny.Int {
	return _dafny.One
}
func (_static *CompanionStruct_Default___) PREFIX__LEN() _dafny.Int {
	return _dafny.IntOfInt64(6)
}
func (_static *CompanionStruct_Default___) TYPEID__LEN() _dafny.Int {
	return _dafny.IntOfInt64(2)
}
func (_static *CompanionStruct_Default___) LENGTH__LEN() _dafny.Int {
	return _dafny.IntOfInt64(4)
}

// End of class Default__

// Definition of datatype AttrValueAndLength
type AttrValueAndLength struct {
	Data_AttrValueAndLength_
}

func (_this AttrValueAndLength) Get_() Data_AttrValueAndLength_ {
	return _this.Data_AttrValueAndLength_
}

type Data_AttrValueAndLength_ interface {
	isAttrValueAndLength()
}

type CompanionStruct_AttrValueAndLength_ struct {
}

var Companion_AttrValueAndLength_ = CompanionStruct_AttrValueAndLength_{}

type AttrValueAndLength_AttrValueAndLength struct {
	Val m_ComAmazonawsDynamodbTypes.AttributeValue
	Len _dafny.Int
}

func (AttrValueAndLength_AttrValueAndLength) isAttrValueAndLength() {}

func (CompanionStruct_AttrValueAndLength_) Create_AttrValueAndLength_(Val m_ComAmazonawsDynamodbTypes.AttributeValue, Len _dafny.Int) AttrValueAndLength {
	return AttrValueAndLength{AttrValueAndLength_AttrValueAndLength{Val, Len}}
}

func (_this AttrValueAndLength) Is_AttrValueAndLength() bool {
	_, ok := _this.Get_().(AttrValueAndLength_AttrValueAndLength)
	return ok
}

func (CompanionStruct_AttrValueAndLength_) Default() AttrValueAndLength {
	return Companion_AttrValueAndLength_.Create_AttrValueAndLength_(m_ComAmazonawsDynamodbTypes.Companion_AttributeValue_.Default(), _dafny.Zero)
}

func (_this AttrValueAndLength) Dtor_val() m_ComAmazonawsDynamodbTypes.AttributeValue {
	return _this.Get_().(AttrValueAndLength_AttrValueAndLength).Val
}

func (_this AttrValueAndLength) Dtor_len() _dafny.Int {
	return _this.Get_().(AttrValueAndLength_AttrValueAndLength).Len
}

func (_this AttrValueAndLength) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case AttrValueAndLength_AttrValueAndLength:
		{
			return "DynamoToStruct.AttrValueAndLength.AttrValueAndLength" + "(" + _dafny.String(data.Val) + ", " + _dafny.String(data.Len) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this AttrValueAndLength) Equals(other AttrValueAndLength) bool {
	switch data1 := _this.Get_().(type) {
	case AttrValueAndLength_AttrValueAndLength:
		{
			data2, ok := other.Get_().(AttrValueAndLength_AttrValueAndLength)
			return ok && data1.Val.Equals(data2.Val) && data1.Len.Cmp(data2.Len) == 0
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this AttrValueAndLength) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(AttrValueAndLength)
	return ok && _this.Equals(typed)
}

func Type_AttrValueAndLength_() _dafny.TypeDescriptor {
	return type_AttrValueAndLength_{}
}

type type_AttrValueAndLength_ struct {
}

func (_this type_AttrValueAndLength_) Default() interface{} {
	return Companion_AttrValueAndLength_.Default()
}

func (_this type_AttrValueAndLength_) String() string {
	return "DynamoToStruct.AttrValueAndLength"
}
func (_this AttrValueAndLength) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = AttrValueAndLength{}

// End of datatype AttrValueAndLength
