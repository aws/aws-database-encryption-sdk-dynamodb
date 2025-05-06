// Package StructuredEncryptionFooter
// Dafny module StructuredEncryptionFooter compiled into Go

package StructuredEncryptionFooter

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
	m_Sets "github.com/aws/aws-database-encryption-sdk-dynamodb/Sets"
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
	return "StructuredEncryptionFooter.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) GetCanonicalType(value m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal, isEncrypted bool) m_Wrappers.Result {
	if isEncrypted {
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(((_dafny.IntOfInt64(2)).Cmp(_dafny.IntOfUint32(((value).Dtor_value()).Cardinality())) <= 0) && ((_dafny.IntOfUint32(((value).Dtor_value()).Cardinality())).Cmp(m_StandardLibrary_UInt.Companion_Default___.UINT64__LIMIT()) < 0), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Bad length.")))
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Concatenate(m_StandardLibrary_UInt.Companion_Default___.UInt64ToSeq(((_dafny.IntOfUint32(((value).Dtor_value()).Cardinality())).Minus(_dafny.IntOfInt64(2))).Uint64()), Companion_Default___.ENCRYPTED()))
		}
	} else {
		var _1_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32(((value).Dtor_value()).Cardinality())).Cmp(m_StandardLibrary_UInt.Companion_Default___.UINT64__LIMIT()) < 0, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Bad length.")))
		_ = _1_valueOrError1
		if (_1_valueOrError1).IsFailure() {
			return (_1_valueOrError1).PropagateFailure()
		} else {
			return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(m_StandardLibrary_UInt.Companion_Default___.UInt64ToSeq(uint64(((value).Dtor_value()).Cardinality())), Companion_Default___.PLAINTEXT()), (value).Dtor_typeId()))
		}
	}
}
func (_static *CompanionStruct_Default___) GetCanonicalEncryptedField(fieldName _dafny.Sequence, value m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(((_dafny.IntOfInt64(2)).Cmp(_dafny.IntOfUint32(((value).Dtor_value()).Cardinality())) <= 0) && ((_dafny.IntOfUint32(((value).Dtor_value()).Cardinality())).Cmp(m_StandardLibrary_UInt.Companion_Default___.UINT64__LIMIT()) < 0), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Bad length.")))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(fieldName, m_StandardLibrary_UInt.Companion_Default___.UInt64ToSeq(((_dafny.IntOfUint32(((value).Dtor_value()).Cardinality())).Minus(_dafny.IntOfInt64(2))).Uint64())), Companion_Default___.ENCRYPTED()), (value).Dtor_value()))
	}
}
func (_static *CompanionStruct_Default___) GetCanonicalPlaintextField(fieldName _dafny.Sequence, value m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32(((value).Dtor_value()).Cardinality())).Cmp(m_StandardLibrary_UInt.Companion_Default___.UINT64__LIMIT()) < 0, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Bad length.")))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(fieldName, m_StandardLibrary_UInt.Companion_Default___.UInt64ToSeq(uint64(((value).Dtor_value()).Cardinality()))), Companion_Default___.PLAINTEXT()), (value).Dtor_typeId()), (value).Dtor_value()))
	}
}
func (_static *CompanionStruct_Default___) GetCanonicalItem(data m_StructuredEncryptionUtil.CanonCryptoItem) m_Wrappers.Result {
	if ((data).Dtor_action()).Equals(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_()) {
		return Companion_Default___.GetCanonicalEncryptedField((data).Dtor_key(), (data).Dtor_data())
	} else {
		return Companion_Default___.GetCanonicalPlaintextField((data).Dtor_key(), (data).Dtor_data())
	}
}
func (_static *CompanionStruct_Default___) CanonContent(data _dafny.Sequence) m_Wrappers.Result {
	var _hresult m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _hresult
	var _0_i _dafny.Int
	_ = _0_i
	_0_i = _dafny.IntOfUint32((data).Cardinality())
	var _1_vectors _dafny.Sequence
	_ = _1_vectors
	_1_vectors = _dafny.SeqOf()
	for (_0_i).Sign() != 0 {
		_0_i = (_0_i).Minus(_dafny.One)
		if !(((data).Select((_0_i).Uint32()).(m_StructuredEncryptionUtil.CanonCryptoItem)).Dtor_action()).Equals(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_DO__NOTHING_()) {
			var _2_test m_Wrappers.Result
			_ = _2_test
			_2_test = Companion_Default___.GetCanonicalItem((data).Select((_0_i).Uint32()).(m_StructuredEncryptionUtil.CanonCryptoItem))
			if (_2_test).Is_Failure() {
				_hresult = m_Wrappers.Companion_Result_.Create_Failure_((_2_test).Dtor_error().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error))
				return _hresult
			}
			_1_vectors = _dafny.Companion_Sequence_.Concatenate((_2_test).Dtor_value().(_dafny.Sequence), _1_vectors)
		}
	}
	_hresult = m_Wrappers.Companion_Result_.Create_Success_(_1_vectors)
	return _hresult
	return _hresult
}
func (_static *CompanionStruct_Default___) CanonRecord(data _dafny.Sequence, header _dafny.Sequence, enc _dafny.Map) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = Companion_Default___.CanonContent(data)
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_canon _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
		_ = _1_canon
		var _2_AAD _dafny.Sequence = m_StructuredEncryptionHeader.Companion_Default___.SerializeContext(enc)
		_ = _2_AAD
		var _3_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((_2_AAD).Cardinality())).Cmp(m_StandardLibrary_UInt.Companion_Default___.UINT64__LIMIT()) < 0, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("AAD too long.")))
		_ = _3_valueOrError1
		if (_3_valueOrError1).IsFailure() {
			return (_3_valueOrError1).PropagateFailure()
		} else {
			var _4_len _dafny.Sequence = m_StandardLibrary_UInt.Companion_Default___.UInt64ToSeq(uint64((_2_AAD).Cardinality()))
			_ = _4_len
			return m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(header, _4_len), _2_AAD), _1_canon))
		}
	}
}
func (_static *CompanionStruct_Default___) CanonHash(data _dafny.Sequence, header _dafny.Sequence, enc _dafny.Map) m_Wrappers.Result {
	var ret m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = ret
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _0_valueOrError0
	_0_valueOrError0 = Companion_Default___.CanonRecord(data, header, enc)
	if (_0_valueOrError0).IsFailure() {
		ret = (_0_valueOrError0).PropagateFailure()
		return ret
	}
	var _1_data _dafny.Sequence
	_ = _1_data
	_1_data = (_0_valueOrError0).Extract().(_dafny.Sequence)
	var _2_resultR m_Wrappers.Result
	_ = _2_resultR
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_Digest.Companion_Default___.Digest(m_AwsCryptographyPrimitivesTypes.Companion_DigestInput_.Create_DigestInput_(m_AwsCryptographyPrimitivesTypes.Companion_DigestAlgorithm_.Create_SHA__384_(), _1_data))
	_2_resultR = _out0
	ret = (_2_resultR).MapFailure(func(coer5 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error) func(interface{}) interface{} {
		return func(arg8 interface{}) interface{} {
			return coer5(arg8.(m_AwsCryptographyPrimitivesTypes.Error))
		}
	}(func(_3_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error {
		return m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_3_e)
	}))
	return ret
	return ret
}
func (_static *CompanionStruct_Default___) CreateFooter(client *m_AtomicPrimitives.AtomicPrimitivesClient, mat m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials, data _dafny.Sequence, header _dafny.Sequence) m_Wrappers.Result {
	var ret m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(Companion_Footer_.Default())
	_ = ret
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _0_valueOrError0
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = Companion_Default___.CanonHash(data, header, (mat).Dtor_encryptionContext())
	_0_valueOrError0 = _out0
	if (_0_valueOrError0).IsFailure() {
		ret = (_0_valueOrError0).PropagateFailure()
		return ret
	}
	var _1_canonicalHash _dafny.Sequence
	_ = _1_canonicalHash
	_1_canonicalHash = (_0_valueOrError0).Extract().(_dafny.Sequence)
	var _2_tags _dafny.Sequence
	_ = _2_tags
	_2_tags = _dafny.SeqOf()
	var _hi0 _dafny.Int = _dafny.IntOfUint32(((mat).Dtor_encryptedDataKeys()).Cardinality())
	_ = _hi0
	for _3_i := _dafny.Zero; _3_i.Cmp(_hi0) < 0; _3_i = _3_i.Plus(_dafny.One) {
		var _4_input m_AwsCryptographyPrimitivesTypes.HMacInput
		_ = _4_input
		_4_input = m_AwsCryptographyPrimitivesTypes.Companion_HMacInput_.Create_HMacInput_((((mat).Dtor_algorithmSuite()).Dtor_symmetricSignature()).Dtor_HMAC(), (((mat).Dtor_symmetricSigningKeys()).Dtor_value().(_dafny.Sequence)).Select((_3_i).Uint32()).(_dafny.Sequence), _1_canonicalHash)
		var _5_hashR m_Wrappers.Result
		_ = _5_hashR
		_5_hashR = (client).HMac(_4_input)
		var _6_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _6_valueOrError1
		_6_valueOrError1 = (_5_hashR).MapFailure(func(coer6 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error) func(interface{}) interface{} {
			return func(arg9 interface{}) interface{} {
				return coer6(arg9.(m_AwsCryptographyPrimitivesTypes.Error))
			}
		}(func(_7_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error {
			return m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_7_e)
		}))
		if (_6_valueOrError1).IsFailure() {
			ret = (_6_valueOrError1).PropagateFailure()
			return ret
		}
		var _8_hash _dafny.Sequence
		_ = _8_hash
		_8_hash = (_6_valueOrError1).Extract().(_dafny.Sequence)
		var _9_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _9_valueOrError2
		_9_valueOrError2 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((_8_hash).Cardinality())).Cmp(_dafny.IntOfInt64(48)) == 0, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Bad hash length")))
		if (_9_valueOrError2).IsFailure() {
			ret = (_9_valueOrError2).PropagateFailure()
			return ret
		}
		_2_tags = _dafny.Companion_Sequence_.Concatenate(_2_tags, _dafny.SeqOf(_8_hash))
	}
	if (((mat).Dtor_algorithmSuite()).Dtor_signature()).Is_ECDSA() {
		var _10_verInput m_AwsCryptographyPrimitivesTypes.ECDSASignInput
		_ = _10_verInput
		_10_verInput = m_AwsCryptographyPrimitivesTypes.Companion_ECDSASignInput_.Create_ECDSASignInput_(((((mat).Dtor_algorithmSuite()).Dtor_signature()).Dtor_ECDSA()).Dtor_curve(), ((mat).Dtor_signingKey()).Dtor_value().(_dafny.Sequence), _1_canonicalHash)
		var _11_sigR m_Wrappers.Result
		_ = _11_sigR
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = (client).ECDSASign(_10_verInput)
		_11_sigR = _out1
		var _12_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _12_valueOrError3
		_12_valueOrError3 = (_11_sigR).MapFailure(func(coer7 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error) func(interface{}) interface{} {
			return func(arg10 interface{}) interface{} {
				return coer7(arg10.(m_AwsCryptographyPrimitivesTypes.Error))
			}
		}(func(_13_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error {
			return m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_13_e)
		}))
		if (_12_valueOrError3).IsFailure() {
			ret = (_12_valueOrError3).PropagateFailure()
			return ret
		}
		var _14_sig _dafny.Sequence
		_ = _14_sig
		_14_sig = (_12_valueOrError3).Extract().(_dafny.Sequence)
		var _15_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _15_valueOrError4
		_15_valueOrError4 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((_14_sig).Cardinality())).Cmp(Companion_Default___.SignatureSize()) == 0, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("Signature is "), m_StandardLibrary_String.Companion_Default___.Base10Int2String(_dafny.IntOfUint32((_14_sig).Cardinality()))), _dafny.SeqOfString(" bytes, should have been ")), m_StandardLibrary_String.Companion_Default___.Base10Int2String(Companion_Default___.SignatureSize())), _dafny.SeqOfString(" bytes."))))
		if (_15_valueOrError4).IsFailure() {
			ret = (_15_valueOrError4).PropagateFailure()
			return ret
		}
		ret = m_Wrappers.Companion_Result_.Create_Success_(Companion_Footer_.Create_Footer_(_2_tags, m_Wrappers.Companion_Option_.Create_Some_(_14_sig)))
		return ret
	} else {
		ret = m_Wrappers.Companion_Result_.Create_Success_(Companion_Footer_.Create_Footer_(_2_tags, m_Wrappers.Companion_Option_.Create_None_()))
		return ret
	}
	return ret
}
func (_static *CompanionStruct_Default___) SerializeTags(tags _dafny.Sequence) _dafny.Sequence {
	var _hresult _dafny.Sequence = _dafny.EmptySeq
	_ = _hresult
	var _0_result _dafny.Sequence
	_ = _0_result
	_0_result = _dafny.SeqOf()
	var _lo0 _dafny.Int = _dafny.Zero
	_ = _lo0
	for _1_i := _dafny.IntOfUint32((tags).Cardinality()); _lo0.Cmp(_1_i) < 0; {
		_1_i = _1_i.Minus(_dafny.One)
		_0_result = _dafny.Companion_Sequence_.Concatenate((tags).Select((_1_i).Uint32()).(_dafny.Sequence), _0_result)
	}
	_hresult = _0_result
	return _hresult
	return _hresult
}
func (_static *CompanionStruct_Default___) SerializeSig(sig m_Wrappers.Option) _dafny.Sequence {
	if (sig).Is_Some() {
		return (sig).Dtor_value().(_dafny.Sequence)
	} else {
		return _dafny.SeqOf()
	}
}
func (_static *CompanionStruct_Default___) GatherTags(data _dafny.Sequence) _dafny.Sequence {
	var _0___accumulator _dafny.Sequence = _dafny.SeqOf()
	_ = _0___accumulator
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (_dafny.IntOfUint32((data).Cardinality())).Sign() == 0 {
		return _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOf())
	} else {
		_0___accumulator = _dafny.Companion_Sequence_.Concatenate(_0___accumulator, _dafny.SeqOf((data).Subsequence(0, (Companion_Default___.RecipientTagSize()).Uint32())))
		var _in0 _dafny.Sequence = (data).Drop((Companion_Default___.RecipientTagSize()).Uint32())
		_ = _in0
		data = _in0
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) DeserializeFooter(data _dafny.Sequence, hasSig bool) m_Wrappers.Result {
	if hasSig {
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((((_dafny.IntOfUint32((data).Cardinality())).Minus(Companion_Default___.SignatureSize())).Modulo(Companion_Default___.RecipientTagSize())).Sign() == 0, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Mangled signed footer has strange size")))
		_ = _0_valueOrError0
		if (_0_valueOrError0).IsFailure() {
			return (_0_valueOrError0).PropagateFailure()
		} else {
			var _1_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((data).Cardinality())).Cmp((Companion_Default___.RecipientTagSize()).Plus(Companion_Default___.SignatureSize())) >= 0, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Footer too short.")))
			_ = _1_valueOrError1
			if (_1_valueOrError1).IsFailure() {
				return (_1_valueOrError1).PropagateFailure()
			} else {
				return m_Wrappers.Companion_Result_.Create_Success_(Companion_Footer_.Create_Footer_(Companion_Default___.GatherTags((data).Take(((_dafny.IntOfUint32((data).Cardinality())).Minus(Companion_Default___.SignatureSize())).Uint32())), m_Wrappers.Companion_Option_.Create_Some_((data).Drop(((_dafny.IntOfUint32((data).Cardinality())).Minus(Companion_Default___.SignatureSize())).Uint32()))))
			}
		}
	} else {
		var _2_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(((_dafny.IntOfUint32((data).Cardinality())).Modulo(Companion_Default___.RecipientTagSize())).Sign() == 0, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Mangled unsigned footer has strange size")))
		_ = _2_valueOrError2
		if (_2_valueOrError2).IsFailure() {
			return (_2_valueOrError2).PropagateFailure()
		} else {
			var _3_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((data).Cardinality())).Cmp(Companion_Default___.RecipientTagSize()) >= 0, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Footer too short.")))
			_ = _3_valueOrError3
			if (_3_valueOrError3).IsFailure() {
				return (_3_valueOrError3).PropagateFailure()
			} else {
				return m_Wrappers.Companion_Result_.Create_Success_(Companion_Footer_.Create_Footer_(Companion_Default___.GatherTags(data), m_Wrappers.Companion_Option_.Create_None_()))
			}
		}
	}
}
func (_static *CompanionStruct_Default___) ENCRYPTED() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(69), uint8(78), uint8(67), uint8(82), uint8(89), uint8(80), uint8(84), uint8(69), uint8(68))
	_ = _0_s
	return _0_s
}
func (_static *CompanionStruct_Default___) PLAINTEXT() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(80), uint8(76), uint8(65), uint8(73), uint8(78), uint8(84), uint8(69), uint8(88), uint8(84))
	_ = _0_s
	return _0_s
}
func (_static *CompanionStruct_Default___) RecipientTagSize() _dafny.Int {
	return _dafny.IntOfInt64(48)
}
func (_static *CompanionStruct_Default___) SignatureSize() _dafny.Int {
	return _dafny.IntOfInt64(103)
}

// End of class Default__

// Definition of class RecipientTag
type RecipientTag struct {
}

func New_RecipientTag_() *RecipientTag {
	_this := RecipientTag{}

	return &_this
}

type CompanionStruct_RecipientTag_ struct {
}

var Companion_RecipientTag_ = CompanionStruct_RecipientTag_{}

func (*RecipientTag) String() string {
	return "StructuredEncryptionFooter.RecipientTag"
}

// End of class RecipientTag

func Type_RecipientTag_() _dafny.TypeDescriptor {
	return type_RecipientTag_{}
}

type type_RecipientTag_ struct {
}

func (_this type_RecipientTag_) Default() interface{} {
	return _dafny.EmptySeq
}

func (_this type_RecipientTag_) String() string {
	return "StructuredEncryptionFooter.RecipientTag"
}
func (_this *CompanionStruct_RecipientTag_) Is_(__source _dafny.Sequence) bool {
	var _0_x _dafny.Sequence = (__source)
	_ = _0_x
	return (_dafny.IntOfUint32((_0_x).Cardinality())).Cmp(Companion_Default___.RecipientTagSize()) == 0
}

// Definition of class Signature
type Signature struct {
}

func New_Signature_() *Signature {
	_this := Signature{}

	return &_this
}

type CompanionStruct_Signature_ struct {
}

var Companion_Signature_ = CompanionStruct_Signature_{}

func (*Signature) String() string {
	return "StructuredEncryptionFooter.Signature"
}

// End of class Signature

func Type_Signature_() _dafny.TypeDescriptor {
	return type_Signature_{}
}

type type_Signature_ struct {
}

func (_this type_Signature_) Default() interface{} {
	return _dafny.EmptySeq
}

func (_this type_Signature_) String() string {
	return "StructuredEncryptionFooter.Signature"
}
func (_this *CompanionStruct_Signature_) Is_(__source _dafny.Sequence) bool {
	var _1_x _dafny.Sequence = (__source)
	_ = _1_x
	return (_dafny.IntOfUint32((_1_x).Cardinality())).Cmp(Companion_Default___.SignatureSize()) == 0
}

// Definition of datatype Footer
type Footer struct {
	Data_Footer_
}

func (_this Footer) Get_() Data_Footer_ {
	return _this.Data_Footer_
}

type Data_Footer_ interface {
	isFooter()
}

type CompanionStruct_Footer_ struct {
}

var Companion_Footer_ = CompanionStruct_Footer_{}

type Footer_Footer struct {
	Tags _dafny.Sequence
	Sig  m_Wrappers.Option
}

func (Footer_Footer) isFooter() {}

func (CompanionStruct_Footer_) Create_Footer_(Tags _dafny.Sequence, Sig m_Wrappers.Option) Footer {
	return Footer{Footer_Footer{Tags, Sig}}
}

func (_this Footer) Is_Footer() bool {
	_, ok := _this.Get_().(Footer_Footer)
	return ok
}

func (CompanionStruct_Footer_) Default() Footer {
	return Companion_Footer_.Create_Footer_(_dafny.EmptySeq, m_Wrappers.Companion_Option_.Default())
}

func (_this Footer) Dtor_tags() _dafny.Sequence {
	return _this.Get_().(Footer_Footer).Tags
}

func (_this Footer) Dtor_sig() m_Wrappers.Option {
	return _this.Get_().(Footer_Footer).Sig
}

func (_this Footer) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case Footer_Footer:
		{
			return "StructuredEncryptionFooter.Footer.Footer" + "(" + _dafny.String(data.Tags) + ", " + _dafny.String(data.Sig) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Footer) Equals(other Footer) bool {
	switch data1 := _this.Get_().(type) {
	case Footer_Footer:
		{
			data2, ok := other.Get_().(Footer_Footer)
			return ok && data1.Tags.Equals(data2.Tags) && data1.Sig.Equals(data2.Sig)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this Footer) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(Footer)
	return ok && _this.Equals(typed)
}

func Type_Footer_() _dafny.TypeDescriptor {
	return type_Footer_{}
}

type type_Footer_ struct {
}

func (_this type_Footer_) Default() interface{} {
	return Companion_Footer_.Default()
}

func (_this type_Footer_) String() string {
	return "StructuredEncryptionFooter.Footer"
}
func (_this Footer) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Footer{}

func (_this Footer) Serialize() _dafny.Sequence {
	{
		return _dafny.Companion_Sequence_.Concatenate(Companion_Default___.SerializeTags((_this).Dtor_tags()), Companion_Default___.SerializeSig((_this).Dtor_sig()))
	}
}
func (_this Footer) MakeTerminal() m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal {
	{
		return m_StructuredEncryptionUtil.Companion_Default___.ValueToData((_this).Serialize(), m_StructuredEncryptionUtil.Companion_Default___.BYTES__TYPE__ID())
	}
}
func (_this Footer) Validate(client *m_AtomicPrimitives.AtomicPrimitivesClient, mat m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials, edks _dafny.Sequence, data _dafny.Sequence, header _dafny.Sequence) m_Wrappers.Result {
	{
		var ret m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
		_ = ret
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _0_valueOrError0
		_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((edks).Cardinality())).Cmp(_dafny.IntOfUint32(((_this).Dtor_tags()).Cardinality())) == 0, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("There are a different number of recipient tags in the stored header than there are in the decryption materials.")))
		if (_0_valueOrError0).IsFailure() {
			ret = (_0_valueOrError0).PropagateFailure()
			return ret
		}
		var _1_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _1_valueOrError1
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = Companion_Default___.CanonHash(data, header, (mat).Dtor_encryptionContext())
		_1_valueOrError1 = _out0
		if (_1_valueOrError1).IsFailure() {
			ret = (_1_valueOrError1).PropagateFailure()
			return ret
		}
		var _2_canonicalHash _dafny.Sequence
		_ = _2_canonicalHash
		_2_canonicalHash = (_1_valueOrError1).Extract().(_dafny.Sequence)
		var _3_input m_AwsCryptographyPrimitivesTypes.HMacInput
		_ = _3_input
		_3_input = m_AwsCryptographyPrimitivesTypes.Companion_HMacInput_.Create_HMacInput_((((mat).Dtor_algorithmSuite()).Dtor_symmetricSignature()).Dtor_HMAC(), ((mat).Dtor_symmetricSigningKey()).Dtor_value().(_dafny.Sequence), _2_canonicalHash)
		var _4_hashR m_Wrappers.Result
		_ = _4_hashR
		_4_hashR = (client).HMac(_3_input)
		var _5_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _5_valueOrError2
		_5_valueOrError2 = (_4_hashR).MapFailure(func(coer8 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error) func(interface{}) interface{} {
			return func(arg11 interface{}) interface{} {
				return coer8(arg11.(m_AwsCryptographyPrimitivesTypes.Error))
			}
		}(func(_6_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error {
			return m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_6_e)
		}))
		if (_5_valueOrError2).IsFailure() {
			ret = (_5_valueOrError2).PropagateFailure()
			return ret
		}
		var _7_hash _dafny.Sequence
		_ = _7_hash
		_7_hash = (_5_valueOrError2).Extract().(_dafny.Sequence)
		var _8_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _8_valueOrError3
		_8_valueOrError3 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((_7_hash).Cardinality())).Cmp(_dafny.IntOfInt64(48)) == 0, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Bad hash length")))
		if (_8_valueOrError3).IsFailure() {
			ret = (_8_valueOrError3).PropagateFailure()
			return ret
		}
		var _9_foundTag bool
		_ = _9_foundTag
		_9_foundTag = false
		{
			var _hi0 _dafny.Int = _dafny.IntOfUint32(((_this).Dtor_tags()).Cardinality())
			_ = _hi0
			for _10_i := _dafny.Zero; _10_i.Cmp(_hi0) < 0; _10_i = _10_i.Plus(_dafny.One) {
				{
					if m_StructuredEncryptionUtil.Companion_Default___.ConstantTimeEquals(_7_hash, ((_this).Dtor_tags()).Select((_10_i).Uint32()).(_dafny.Sequence)) {
						_9_foundTag = true
						goto L0
					}
					goto C0
				}
			C0:
			}
			goto L0
		}
	L0:
		var _11_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _11_valueOrError4
		_11_valueOrError4 = m_Wrappers.Companion_Default___.Need(_9_foundTag, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Signature of record does not match the signature computed when the record was encrypted.")))
		if (_11_valueOrError4).IsFailure() {
			ret = (_11_valueOrError4).PropagateFailure()
			return ret
		}
		var _12_valueOrError5 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _12_valueOrError5
		_12_valueOrError5 = m_Wrappers.Companion_Default___.Need((((_this).Dtor_sig()).Is_Some()) == ((((mat).Dtor_algorithmSuite()).Dtor_signature()).Is_ECDSA()), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Internal error. Signature both does and does not exist.")))
		if (_12_valueOrError5).IsFailure() {
			ret = (_12_valueOrError5).PropagateFailure()
			return ret
		}
		if ((_this).Dtor_sig()).Is_Some() {
			var _13_verInput m_AwsCryptographyPrimitivesTypes.ECDSAVerifyInput
			_ = _13_verInput
			_13_verInput = m_AwsCryptographyPrimitivesTypes.Companion_ECDSAVerifyInput_.Create_ECDSAVerifyInput_(((((mat).Dtor_algorithmSuite()).Dtor_signature()).Dtor_ECDSA()).Dtor_curve(), ((mat).Dtor_verificationKey()).Dtor_value().(_dafny.Sequence), _2_canonicalHash, ((_this).Dtor_sig()).Dtor_value().(_dafny.Sequence))
			var _14_verR m_Wrappers.Result
			_ = _14_verR
			var _out1 m_Wrappers.Result
			_ = _out1
			_out1 = (client).ECDSAVerify(_13_verInput)
			_14_verR = _out1
			var _15_valueOrError6 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
			_ = _15_valueOrError6
			_15_valueOrError6 = (_14_verR).MapFailure(func(coer9 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error) func(interface{}) interface{} {
				return func(arg12 interface{}) interface{} {
					return coer9(arg12.(m_AwsCryptographyPrimitivesTypes.Error))
				}
			}(func(_16_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error {
				return m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_16_e)
			}))
			if (_15_valueOrError6).IsFailure() {
				ret = (_15_valueOrError6).PropagateFailure()
				return ret
			}
			var _17_ver bool
			_ = _17_ver
			_17_ver = (_15_valueOrError6).Extract().(bool)
			var _18_valueOrError7 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
			_ = _18_valueOrError7
			_18_valueOrError7 = m_Wrappers.Companion_Default___.Need(_17_ver, m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Signature did not verify")))
			if (_18_valueOrError7).IsFailure() {
				ret = (_18_valueOrError7).PropagateFailure()
				return ret
			}
		}
		ret = m_Wrappers.Companion_Result_.Create_Success_(true)
		return ret
		return ret
	}
}

// End of datatype Footer
