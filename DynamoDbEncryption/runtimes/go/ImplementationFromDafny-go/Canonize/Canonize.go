// Package Canonize
// Dafny module Canonize compiled into Go

package Canonize

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
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes"
	m_OptimizedMergeSort "github.com/aws/aws-database-encryption-sdk-dynamodb/OptimizedMergeSort"
	m_Sets "github.com/aws/aws-database-encryption-sdk-dynamodb/Sets"
	m_SortCanon "github.com/aws/aws-database-encryption-sdk-dynamodb/SortCanon"
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
	return "Canonize.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) IsCanonPath(table _dafny.Sequence, origKey _dafny.Sequence, key _dafny.Sequence) bool {
	return _dafny.Companion_Sequence_.Equal(key, m_StructuredEncryptionPaths.Companion_Default___.CanonPath(table, origKey))
}
func (_static *CompanionStruct_Default___) MakeCanon(tableName _dafny.Sequence, data m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem) m_StructuredEncryptionUtil.CanonCryptoItem {
	return m_StructuredEncryptionUtil.Companion_CanonCryptoItem_.Create_CanonCryptoItem_(m_StructuredEncryptionPaths.Companion_Default___.CanonPath(tableName, (data).Dtor_key()), (data).Dtor_key(), (data).Dtor_data(), (data).Dtor_action())
}
func (_static *CompanionStruct_Default___) MakeCanonAuth(tableName _dafny.Sequence, data m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.AuthItem) m_StructuredEncryptionUtil.CanonAuthItem {
	return m_StructuredEncryptionUtil.Companion_CanonAuthItem_.Create_CanonAuthItem_(m_StructuredEncryptionPaths.Companion_Default___.CanonPath(tableName, (data).Dtor_key()), (data).Dtor_key(), (data).Dtor_data(), (data).Dtor_action())
}
func (_static *CompanionStruct_Default___) Same(x m_StructuredEncryptionUtil.CanonAuthItem, y m_StructuredEncryptionUtil.CanonCryptoItem) bool {
	return ((_dafny.Companion_Sequence_.Equal((x).Dtor_key(), (y).Dtor_key())) && (_dafny.Companion_Sequence_.Equal((x).Dtor_origKey(), (y).Dtor_origKey()))) && (((x).Dtor_data()).Equals((y).Dtor_data()))
}
func (_static *CompanionStruct_Default___) MakeCryptoItem(x m_StructuredEncryptionUtil.CanonAuthItem, action m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction) m_StructuredEncryptionUtil.CanonCryptoItem {
	return m_StructuredEncryptionUtil.Companion_CanonCryptoItem_.Create_CanonCryptoItem_((x).Dtor_key(), (x).Dtor_origKey(), (x).Dtor_data(), action)
}
func (_static *CompanionStruct_Default___) LegendToAction(v uint8) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction {
	if (v) == (m_StructuredEncryptionHeader.Companion_Default___.ENCRYPT__AND__SIGN__LEGEND()) {
		return m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_()
	} else if (v) == (m_StructuredEncryptionHeader.Companion_Default___.SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT__LEGEND()) {
		return m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_()
	} else {
		return m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_SIGN__ONLY_()
	}
}
func (_static *CompanionStruct_Default___) ResolveLegend(fields _dafny.Sequence, legend _dafny.Sequence, pos _dafny.Int, legendPos _dafny.Int, acc _dafny.Sequence) m_Wrappers.Result {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((fields).Cardinality())).Cmp(pos) == 0 {
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((legend).Cardinality())).Cmp(legendPos) == 0, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Schema changed : something that was signed is now unsigned.")))
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			return m_Wrappers.Companion_Result_.Create_Success_(acc)
		}
	} else if (((fields).Select((pos).Uint32()).(m_StructuredEncryptionUtil.CanonAuthItem)).Dtor_action()).Equals(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_AuthenticateAction_.Create_DO__NOT__SIGN_()) {
		var _in0 _dafny.Sequence = fields
		_ = _in0
		var _in1 _dafny.Sequence = legend
		_ = _in1
		var _in2 _dafny.Int = (pos).Plus(_dafny.One)
		_ = _in2
		var _in3 _dafny.Int = legendPos
		_ = _in3
		var _in4 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(acc, _dafny.SeqOf(Companion_Default___.MakeCryptoItem((fields).Select((pos).Uint32()).(m_StructuredEncryptionUtil.CanonAuthItem), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_DO__NOTHING_())))
		_ = _in4
		fields = _in0
		legend = _in1
		pos = _in2
		legendPos = _in3
		acc = _in4
		goto TAIL_CALL_START
	} else {
		var _1_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((legendPos).Cmp(_dafny.IntOfUint32((legend).Cardinality())) < 0, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Schema changed : something that was unsigned is now signed.")))
		_ = _1_valueOrError1
		if (_1_valueOrError1).IsFailure() {
			return (_1_valueOrError1).PropagateFailure()
		} else {
			var _in5 _dafny.Sequence = fields
			_ = _in5
			var _in6 _dafny.Sequence = legend
			_ = _in6
			var _in7 _dafny.Int = (pos).Plus(_dafny.One)
			_ = _in7
			var _in8 _dafny.Int = (legendPos).Plus(_dafny.One)
			_ = _in8
			var _in9 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(acc, _dafny.SeqOf(Companion_Default___.MakeCryptoItem((fields).Select((pos).Uint32()).(m_StructuredEncryptionUtil.CanonAuthItem), Companion_Default___.LegendToAction((legend).Select((legendPos).Uint32()).(uint8)))))
			_ = _in9
			fields = _in5
			legend = _in6
			pos = _in7
			legendPos = _in8
			acc = _in9
			goto TAIL_CALL_START
		}
	}
}
func (_static *CompanionStruct_Default___) ForEncrypt(tableName _dafny.Sequence, data _dafny.Sequence) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(_dafny.Quantifier((data).UniqueElements(), true, func(_forall_var_0 m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem) bool {
		var _1_k m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem
		_1_k = interface{}(_forall_var_0).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem)
		return !(_dafny.Companion_Sequence_.Contains(data, _1_k)) || (m_StructuredEncryptionPaths.Companion_Default___.ValidPath((_1_k).Dtor_key()))
	}), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Invalid Paths")))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _2_canonList _dafny.Sequence = Companion_Default___.CryptoToCanonCrypto(tableName, data)
		_ = _2_canonList
		return m_Wrappers.Companion_Result_.Create_Success_(Companion_Default___.CryptoSort(_2_canonList))
	}
}
func (_static *CompanionStruct_Default___) AuthToCanonAuth(tableName _dafny.Sequence, data _dafny.Sequence) _dafny.Sequence {
	var _0_canonList _dafny.Sequence = m_Seq.Companion_Default___.Map(func(coer19 func(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.AuthItem) m_StructuredEncryptionUtil.CanonAuthItem) func(interface{}) interface{} {
		return func(arg31 interface{}) interface{} {
			return coer19(arg31.(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.AuthItem))
		}
	}((func(_1_tableName _dafny.Sequence) func(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.AuthItem) m_StructuredEncryptionUtil.CanonAuthItem {
		return func(_2_s m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.AuthItem) m_StructuredEncryptionUtil.CanonAuthItem {
			return Companion_Default___.MakeCanonAuth(_1_tableName, _2_s)
		}
	})(tableName)), data)
	_ = _0_canonList
	return _0_canonList
}
func (_static *CompanionStruct_Default___) CryptoToCanonCrypto(tableName _dafny.Sequence, data _dafny.Sequence) _dafny.Sequence {
	var _0_canonList _dafny.Sequence = m_Seq.Companion_Default___.Map(func(coer20 func(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem) m_StructuredEncryptionUtil.CanonCryptoItem) func(interface{}) interface{} {
		return func(arg32 interface{}) interface{} {
			return coer20(arg32.(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem))
		}
	}((func(_1_tableName _dafny.Sequence) func(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem) m_StructuredEncryptionUtil.CanonCryptoItem {
		return func(_2_s m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem) m_StructuredEncryptionUtil.CanonCryptoItem {
			return Companion_Default___.MakeCanon(_1_tableName, _2_s)
		}
	})(tableName)), data)
	_ = _0_canonList
	return _0_canonList
}
func (_static *CompanionStruct_Default___) AuthSort(canonList _dafny.Sequence) _dafny.Sequence {
	var _0_canonSorted _dafny.Sequence = m_SortCanon.Companion_Default___.AuthSort(canonList)
	_ = _0_canonSorted
	return _0_canonSorted
}
func (_static *CompanionStruct_Default___) CryptoSort(canonList _dafny.Sequence) _dafny.Sequence {
	var _0_canonSorted _dafny.Sequence = m_SortCanon.Companion_Default___.CryptoSort(canonList)
	_ = _0_canonSorted
	return _0_canonSorted
}
func (_static *CompanionStruct_Default___) DoResolveLegend(canonSorted _dafny.Sequence, legend _dafny.Sequence) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.ResolveLegend(canonSorted, legend, _dafny.Zero, _dafny.Zero, _dafny.SeqOf())
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_canonResolved _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
		_ = _1_canonResolved
		return m_Wrappers.Companion_Result_.Create_Success_(_1_canonResolved)
	}
}
func (_static *CompanionStruct_Default___) ForDecrypt(tableName _dafny.Sequence, data _dafny.Sequence, legend _dafny.Sequence) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(_dafny.Quantifier((data).UniqueElements(), true, func(_forall_var_0 m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.AuthItem) bool {
		var _1_k m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.AuthItem
		_1_k = interface{}(_forall_var_0).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.AuthItem)
		return !(_dafny.Companion_Sequence_.Contains(data, _1_k)) || (m_StructuredEncryptionPaths.Companion_Default___.ValidPath((_1_k).Dtor_key()))
	}), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Invalid Paths")))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _2_canonList _dafny.Sequence = Companion_Default___.AuthToCanonAuth(tableName, data)
		_ = _2_canonList
		var _3_canonSorted _dafny.Sequence = Companion_Default___.AuthSort(_2_canonList)
		_ = _3_canonSorted
		return Companion_Default___.DoResolveLegend(_3_canonSorted, legend)
	}
}
func (_static *CompanionStruct_Default___) SameUnCanon(x m_StructuredEncryptionUtil.CanonCryptoItem, y m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem) bool {
	return ((_dafny.Companion_Sequence_.Equal((x).Dtor_origKey(), (y).Dtor_key())) && (((x).Dtor_data()).Equals((y).Dtor_data()))) && (((x).Dtor_action()).Equals((y).Dtor_action()))
}
func (_static *CompanionStruct_Default___) UnCanon(input _dafny.Sequence, pos _dafny.Int, acc _dafny.Sequence) _dafny.Sequence {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((input).Cardinality())).Cmp(pos) == 0 {
		return acc
	} else {
		var _0_newItem m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem = m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoItem_.Create_CryptoItem_(((input).Select((pos).Uint32()).(m_StructuredEncryptionUtil.CanonCryptoItem)).Dtor_origKey(), ((input).Select((pos).Uint32()).(m_StructuredEncryptionUtil.CanonCryptoItem)).Dtor_data(), ((input).Select((pos).Uint32()).(m_StructuredEncryptionUtil.CanonCryptoItem)).Dtor_action())
		_ = _0_newItem
		var _in0 _dafny.Sequence = input
		_ = _in0
		var _in1 _dafny.Int = (pos).Plus(_dafny.One)
		_ = _in1
		var _in2 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(acc, _dafny.SeqOf(_0_newItem))
		_ = _in2
		input = _in0
		pos = _in1
		acc = _in2
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) UnCanonDecrypt(input _dafny.Sequence) _dafny.Sequence {
	var _0_results _dafny.Sequence = Companion_Default___.UnCanon(input, _dafny.Zero, _dafny.SeqOf())
	_ = _0_results
	return _0_results
}
func (_static *CompanionStruct_Default___) UnCanonEncrypt(input _dafny.Sequence) _dafny.Sequence {
	var _0_results _dafny.Sequence = Companion_Default___.UnCanon(input, _dafny.Zero, _dafny.SeqOf())
	_ = _0_results
	return _0_results
}
func (_static *CompanionStruct_Default___) AddHeaders(input _dafny.Sequence, headerData m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal, footerData m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal) _dafny.Sequence {
	var _0_headItem m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem = m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoItem_.Create_CryptoItem_(m_StructuredEncryptionUtil.Companion_Default___.HeaderPath(), headerData, m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_DO__NOTHING_())
	_ = _0_headItem
	var _1_footItem m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem = m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoItem_.Create_CryptoItem_(m_StructuredEncryptionUtil.Companion_Default___.FooterPath(), footerData, m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_DO__NOTHING_())
	_ = _1_footItem
	var _2_largeResult _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(input, _dafny.SeqOf(_0_headItem, _1_footItem))
	_ = _2_largeResult
	return _2_largeResult
}
func (_static *CompanionStruct_Default___) RemoveHeaderPaths(xs _dafny.Sequence, pos _dafny.Int, acc _dafny.Sequence) _dafny.Sequence {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((xs).Cardinality())).Cmp(pos) == 0 {
		return acc
	} else if _dafny.Companion_Sequence_.Contains(_dafny.SeqOf(m_StructuredEncryptionUtil.Companion_Default___.HeaderPath(), m_StructuredEncryptionUtil.Companion_Default___.FooterPath()), ((xs).Select((pos).Uint32()).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem)).Dtor_key()) {
		var _in0 _dafny.Sequence = xs
		_ = _in0
		var _in1 _dafny.Int = (pos).Plus(_dafny.One)
		_ = _in1
		var _in2 _dafny.Sequence = acc
		_ = _in2
		xs = _in0
		pos = _in1
		acc = _in2
		goto TAIL_CALL_START
	} else {
		var _in3 _dafny.Sequence = xs
		_ = _in3
		var _in4 _dafny.Int = (pos).Plus(_dafny.One)
		_ = _in4
		var _in5 _dafny.Sequence = _dafny.Companion_Sequence_.Concatenate(acc, _dafny.SeqOf((xs).Select((pos).Uint32()).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem)))
		_ = _in5
		xs = _in3
		pos = _in4
		acc = _in5
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) RemoveHeaders(input _dafny.Sequence) _dafny.Sequence {
	var _0_finalData _dafny.Sequence = Companion_Default___.RemoveHeaderPaths(input, _dafny.Zero, _dafny.SeqOf())
	_ = _0_finalData
	return _0_finalData
}

// End of class Default__

// Definition of datatype EncryptionSelector
type EncryptionSelector struct {
	Data_EncryptionSelector_
}

func (_this EncryptionSelector) Get_() Data_EncryptionSelector_ {
	return _this.Data_EncryptionSelector_
}

type Data_EncryptionSelector_ interface {
	isEncryptionSelector()
}

type CompanionStruct_EncryptionSelector_ struct {
}

var Companion_EncryptionSelector_ = CompanionStruct_EncryptionSelector_{}

type EncryptionSelector_DoEncrypt struct {
}

func (EncryptionSelector_DoEncrypt) isEncryptionSelector() {}

func (CompanionStruct_EncryptionSelector_) Create_DoEncrypt_() EncryptionSelector {
	return EncryptionSelector{EncryptionSelector_DoEncrypt{}}
}

func (_this EncryptionSelector) Is_DoEncrypt() bool {
	_, ok := _this.Get_().(EncryptionSelector_DoEncrypt)
	return ok
}

type EncryptionSelector_DoDecrypt struct {
}

func (EncryptionSelector_DoDecrypt) isEncryptionSelector() {}

func (CompanionStruct_EncryptionSelector_) Create_DoDecrypt_() EncryptionSelector {
	return EncryptionSelector{EncryptionSelector_DoDecrypt{}}
}

func (_this EncryptionSelector) Is_DoDecrypt() bool {
	_, ok := _this.Get_().(EncryptionSelector_DoDecrypt)
	return ok
}

func (CompanionStruct_EncryptionSelector_) Default() EncryptionSelector {
	return Companion_EncryptionSelector_.Create_DoEncrypt_()
}

func (_ CompanionStruct_EncryptionSelector_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_EncryptionSelector_.Create_DoEncrypt_(), true
		case 1:
			return Companion_EncryptionSelector_.Create_DoDecrypt_(), true
		default:
			return EncryptionSelector{}, false
		}
	}
}

func (_this EncryptionSelector) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case EncryptionSelector_DoEncrypt:
		{
			return "Canonize.EncryptionSelector.DoEncrypt"
		}
	case EncryptionSelector_DoDecrypt:
		{
			return "Canonize.EncryptionSelector.DoDecrypt"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this EncryptionSelector) Equals(other EncryptionSelector) bool {
	switch _this.Get_().(type) {
	case EncryptionSelector_DoEncrypt:
		{
			_, ok := other.Get_().(EncryptionSelector_DoEncrypt)
			return ok
		}
	case EncryptionSelector_DoDecrypt:
		{
			_, ok := other.Get_().(EncryptionSelector_DoDecrypt)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this EncryptionSelector) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(EncryptionSelector)
	return ok && _this.Equals(typed)
}

func Type_EncryptionSelector_() _dafny.TypeDescriptor {
	return type_EncryptionSelector_{}
}

type type_EncryptionSelector_ struct {
}

func (_this type_EncryptionSelector_) Default() interface{} {
	return Companion_EncryptionSelector_.Default()
}

func (_this type_EncryptionSelector_) String() string {
	return "Canonize.EncryptionSelector"
}
func (_this EncryptionSelector) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = EncryptionSelector{}

// End of datatype EncryptionSelector
