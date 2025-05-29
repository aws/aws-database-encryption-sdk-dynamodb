// Package StructuredEncryptionCrypt
// Dafny module StructuredEncryptionCrypt compiled into Go

package StructuredEncryptionCrypt

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
	m_AesKdfCtr "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/AesKdfCtr"
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
	m_StandardLibrary_MemoryMath "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/StandardLibrary_MemoryMath"
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
	m_Canonize "github.com/aws/aws-database-encryption-sdk-dynamodb/Canonize"
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
var _ m_StandardLibrary_MemoryMath.Dummy__
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
	return "StructuredEncryptionCrypt.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) FieldKey(HKDFOutput _dafny.Sequence, offset uint32) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((offset) < (Companion_Default___.ONE__THIRD__MAX__INT()), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Too many encrypted fields.")))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_keyR m_Wrappers.Result = m_AesKdfCtr.AesKdfCtrStream(Companion_Default___.FieldKeyNonce((offset)*(uint32(3))), HKDFOutput, uint32((m_StructuredEncryptionUtil.Companion_Default___.KeySize64())+(m_StructuredEncryptionUtil.Companion_Default___.NonceSize64())))
		_ = _1_keyR
		return (_1_keyR).MapFailure(func(coer18 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error) func(interface{}) interface{} {
			return func(arg27 interface{}) interface{} {
				return coer18(arg27.(m_AwsCryptographyPrimitivesTypes.Error))
			}
		}(func(_2_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error {
			return m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_2_e)
		}))
	}
}
func (_static *CompanionStruct_Default___) FieldKeyNonce(offset uint32) _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(Companion_Default___.AwsDbeField(), _dafny.SeqOf(uint8((m_StructuredEncryptionUtil.Companion_Default___.KeySize64())+(m_StructuredEncryptionUtil.Companion_Default___.NonceSize64())))), m_StandardLibrary_UInt.Companion_Default___.UInt32ToSeq(offset))
}
func (_static *CompanionStruct_Default___) GetCommitKey(client *m_AtomicPrimitives.AtomicPrimitivesClient, alg m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo, key _dafny.Sequence, msgID _dafny.Sequence) m_Wrappers.Result {
	var ret m_Wrappers.Result = m_Wrappers.Result{}
	_ = ret
	var _0_commitKey m_Wrappers.Result
	_ = _0_commitKey
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = (client).Hkdf(m_AwsCryptographyPrimitivesTypes.Companion_HkdfInput_.Create_HkdfInput_((((alg).Dtor_commitment()).Dtor_HKDF()).Dtor_hmac(), m_Wrappers.Companion_Option_.Create_None_(), key, _dafny.Companion_Sequence_.Concatenate(Companion_Default___.LABEL__COMMITMENT__KEY(), msgID), (((alg).Dtor_commitment()).Dtor_HKDF()).Dtor_outputKeyLength()))
	_0_commitKey = _out0
	ret = (_0_commitKey).MapFailure(func(coer19 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error) func(interface{}) interface{} {
		return func(arg28 interface{}) interface{} {
			return coer19(arg28.(m_AwsCryptographyPrimitivesTypes.Error))
		}
	}(func(_1_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error {
		return m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_1_e)
	}))
	return ret
	return ret
}
func (_static *CompanionStruct_Default___) Encrypt(client *m_AtomicPrimitives.AtomicPrimitivesClient, alg m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo, key _dafny.Sequence, head m_StructuredEncryptionHeader.PartialHeader, data _dafny.Sequence) m_Wrappers.Result {
	var ret m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = ret
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _0_valueOrError0
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = Companion_Default___.Crypt(m_Canonize.Companion_EncryptionSelector_.Create_DoEncrypt_(), client, alg, key, head, data)
	_0_valueOrError0 = _out0
	if (_0_valueOrError0).IsFailure() {
		ret = (_0_valueOrError0).PropagateFailure()
		return ret
	}
	var _1_result _dafny.Sequence
	_ = _1_result
	_1_result = (_0_valueOrError0).Extract().(_dafny.Sequence)
	ret = m_Wrappers.Companion_Result_.Create_Success_(_1_result)
	return ret
	return ret
}
func (_static *CompanionStruct_Default___) Decrypt(client *m_AtomicPrimitives.AtomicPrimitivesClient, alg m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo, key _dafny.Sequence, head m_StructuredEncryptionHeader.PartialHeader, data _dafny.Sequence) m_Wrappers.Result {
	var ret m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = ret
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _0_valueOrError0
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = Companion_Default___.Crypt(m_Canonize.Companion_EncryptionSelector_.Create_DoDecrypt_(), client, alg, key, head, data)
	_0_valueOrError0 = _out0
	if (_0_valueOrError0).IsFailure() {
		ret = (_0_valueOrError0).PropagateFailure()
		return ret
	}
	var _1_result _dafny.Sequence
	_ = _1_result
	_1_result = (_0_valueOrError0).Extract().(_dafny.Sequence)
	ret = m_Wrappers.Companion_Result_.Create_Success_(_1_result)
	return ret
	return ret
}
func (_static *CompanionStruct_Default___) Crypt(mode m_Canonize.EncryptionSelector, client *m_AtomicPrimitives.AtomicPrimitivesClient, alg m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo, key _dafny.Sequence, head m_StructuredEncryptionHeader.PartialHeader, data _dafny.Sequence) m_Wrappers.Result {
	var ret m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = ret
	var _0_fieldRootKeyR m_Wrappers.Result
	_ = _0_fieldRootKeyR
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = (client).Hkdf(m_AwsCryptographyPrimitivesTypes.Companion_HkdfInput_.Create_HkdfInput_((((alg).Dtor_kdf()).Dtor_HKDF()).Dtor_hmac(), m_Wrappers.Companion_Option_.Create_None_(), key, _dafny.Companion_Sequence_.Concatenate(Companion_Default___.LABEL__ENCRYPTION__KEY(), (head).Dtor_msgID()), (((alg).Dtor_kdf()).Dtor_HKDF()).Dtor_outputKeyLength()))
	_0_fieldRootKeyR = _out0
	var _1_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _1_valueOrError0
	_1_valueOrError0 = (_0_fieldRootKeyR).MapFailure(func(coer20 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error) func(interface{}) interface{} {
		return func(arg29 interface{}) interface{} {
			return coer20(arg29.(m_AwsCryptographyPrimitivesTypes.Error))
		}
	}(func(_2_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error {
		return m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_2_e)
	}))
	if (_1_valueOrError0).IsFailure() {
		ret = (_1_valueOrError0).PropagateFailure()
		return ret
	}
	var _3_fieldRootKey _dafny.Sequence
	_ = _3_fieldRootKey
	_3_fieldRootKey = (_1_valueOrError0).Extract().(_dafny.Sequence)
	var _4_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _4_valueOrError1
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = Companion_Default___.CryptList(mode, client, alg, _3_fieldRootKey, data)
	_4_valueOrError1 = _out1
	if (_4_valueOrError1).IsFailure() {
		ret = (_4_valueOrError1).PropagateFailure()
		return ret
	}
	var _5_result _dafny.Sequence
	_ = _5_result
	_5_result = (_4_valueOrError1).Extract().(_dafny.Sequence)
	ret = m_Wrappers.Companion_Result_.Create_Success_(_5_result)
	return ret
	return ret
}
func (_static *CompanionStruct_Default___) CryptList(mode m_Canonize.EncryptionSelector, client *m_AtomicPrimitives.AtomicPrimitivesClient, alg m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo, fieldRootKey _dafny.Sequence, data _dafny.Sequence) m_Wrappers.Result {
	var ret m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = ret
	var _0_result _dafny.Sequence
	_ = _0_result
	_0_result = _dafny.SeqOf()
	var _1_pos uint32
	_ = _1_pos
	_1_pos = uint32(0)
	var _2_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _2_valueOrError0
	_2_valueOrError0 = m_Wrappers.Companion_Default___.Need((uint64((data).Cardinality())) < ((m_StandardLibrary_UInt.Companion_Default___.UINT32__LIMIT()).Uint64()), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Too many fields.")))
	if (_2_valueOrError0).IsFailure() {
		ret = (_2_valueOrError0).PropagateFailure()
		return ret
	}
	var _hi0 uint64 = uint64((data).Cardinality())
	_ = _hi0
	for _3_i := uint64(0); _3_i < _hi0; _3_i++ {
		if (((data).Select(uint32(_3_i)).(m_StructuredEncryptionUtil.CanonCryptoItem)).Dtor_action()).Equals(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_()) {
			var _4_newTerminal m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal = m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal{}
			_ = _4_newTerminal
			if (mode).Equals(m_Canonize.Companion_EncryptionSelector_.Create_DoEncrypt_()) {
				var _5_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
				_ = _5_valueOrError1
				var _out0 m_Wrappers.Result
				_ = _out0
				_out0 = Companion_Default___.EncryptTerminal(client, alg, fieldRootKey, _1_pos, ((data).Select(uint32(_3_i)).(m_StructuredEncryptionUtil.CanonCryptoItem)).Dtor_key(), ((data).Select(uint32(_3_i)).(m_StructuredEncryptionUtil.CanonCryptoItem)).Dtor_data())
				_5_valueOrError1 = _out0
				if (_5_valueOrError1).IsFailure() {
					ret = (_5_valueOrError1).PropagateFailure()
					return ret
				}
				_4_newTerminal = (_5_valueOrError1).Extract().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal)
			} else {
				var _6_valueOrError2 m_Wrappers.Result = m_Wrappers.Result{}
				_ = _6_valueOrError2
				var _out1 m_Wrappers.Result
				_ = _out1
				_out1 = Companion_Default___.DecryptTerminal(client, alg, fieldRootKey, _1_pos, ((data).Select(uint32(_3_i)).(m_StructuredEncryptionUtil.CanonCryptoItem)).Dtor_key(), ((data).Select(uint32(_3_i)).(m_StructuredEncryptionUtil.CanonCryptoItem)).Dtor_data())
				_6_valueOrError2 = _out1
				if (_6_valueOrError2).IsFailure() {
					ret = (_6_valueOrError2).PropagateFailure()
					return ret
				}
				_4_newTerminal = (_6_valueOrError2).Extract().(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal)
			}
			_1_pos = (_1_pos) + (uint32(1))
			var _7_newItem m_StructuredEncryptionUtil.CanonCryptoItem
			_ = _7_newItem
			var _8_dt__update__tmp_h0 m_StructuredEncryptionUtil.CanonCryptoItem = (data).Select(uint32(_3_i)).(m_StructuredEncryptionUtil.CanonCryptoItem)
			_ = _8_dt__update__tmp_h0
			var _9_dt__update_hdata_h0 m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal = _4_newTerminal
			_ = _9_dt__update_hdata_h0
			_7_newItem = m_StructuredEncryptionUtil.Companion_CanonCryptoItem_.Create_CanonCryptoItem_((_8_dt__update__tmp_h0).Dtor_key(), (_8_dt__update__tmp_h0).Dtor_origKey(), _9_dt__update_hdata_h0, (_8_dt__update__tmp_h0).Dtor_action())
			_0_result = _dafny.Companion_Sequence_.Concatenate(_0_result, _dafny.SeqOf(_7_newItem))
		} else {
			_0_result = _dafny.Companion_Sequence_.Concatenate(_0_result, _dafny.SeqOf((data).Select(uint32(_3_i)).(m_StructuredEncryptionUtil.CanonCryptoItem)))
		}
	}
	ret = m_Wrappers.Companion_Result_.Create_Success_(_0_result)
	return ret
	return ret
}
func (_static *CompanionStruct_Default___) EncryptTerminal(client *m_AtomicPrimitives.AtomicPrimitivesClient, alg m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo, fieldRootKey _dafny.Sequence, offset uint32, path _dafny.Sequence, data m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal) m_Wrappers.Result {
	var ret m_Wrappers.Result = m_Wrappers.Result{}
	_ = ret
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _0_valueOrError0
	_0_valueOrError0 = Companion_Default___.FieldKey(fieldRootKey, offset)
	if (_0_valueOrError0).IsFailure() {
		ret = (_0_valueOrError0).PropagateFailure()
		return ret
	}
	var _1_fieldKey _dafny.Sequence
	_ = _1_fieldKey
	_1_fieldKey = (_0_valueOrError0).Extract().(_dafny.Sequence)
	var _2_cipherkey _dafny.Sequence
	_ = _2_cipherkey
	_2_cipherkey = (_1_fieldKey).Take(uint32(m_StructuredEncryptionUtil.Companion_Default___.KeySize64()))
	var _3_nonce _dafny.Sequence
	_ = _3_nonce
	_3_nonce = (_1_fieldKey).Drop(uint32(m_StructuredEncryptionUtil.Companion_Default___.KeySize64()))
	var _4_value _dafny.Sequence
	_ = _4_value
	_4_value = (data).Dtor_value()
	var _5_encInput m_AwsCryptographyPrimitivesTypes.AESEncryptInput
	_ = _5_encInput
	_5_encInput = m_AwsCryptographyPrimitivesTypes.Companion_AESEncryptInput_.Create_AESEncryptInput_(((alg).Dtor_encrypt()).Dtor_AES__GCM(), _3_nonce, _2_cipherkey, _4_value, path)
	var _6_encOutR m_Wrappers.Result
	_ = _6_encOutR
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = (client).AESEncrypt(_5_encInput)
	_6_encOutR = _out0
	var _7_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_AESEncryptOutput_.Default())
	_ = _7_valueOrError1
	_7_valueOrError1 = (_6_encOutR).MapFailure(func(coer21 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error) func(interface{}) interface{} {
		return func(arg30 interface{}) interface{} {
			return coer21(arg30.(m_AwsCryptographyPrimitivesTypes.Error))
		}
	}(func(_8_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error {
		return m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_8_e)
	}))
	if (_7_valueOrError1).IsFailure() {
		ret = (_7_valueOrError1).PropagateFailure()
		return ret
	}
	var _9_encOut m_AwsCryptographyPrimitivesTypes.AESEncryptOutput
	_ = _9_encOut
	_9_encOut = (_7_valueOrError1).Extract().(m_AwsCryptographyPrimitivesTypes.AESEncryptOutput)
	var _10_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _10_valueOrError2
	_10_valueOrError2 = m_Wrappers.Companion_Default___.Need((uint64(((_9_encOut).Dtor_authTag()).Cardinality())) == (m_StructuredEncryptionUtil.Companion_Default___.AuthTagSize64()), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("Auth Tag Wrong Size.")))
	if (_10_valueOrError2).IsFailure() {
		ret = (_10_valueOrError2).PropagateFailure()
		return ret
	}
	ret = m_Wrappers.Companion_Result_.Create_Success_(m_StructuredEncryptionUtil.Companion_Default___.ValueToData(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate((data).Dtor_typeId(), (_9_encOut).Dtor_cipherText()), (_9_encOut).Dtor_authTag()), m_StructuredEncryptionUtil.Companion_Default___.BYTES__TYPE__ID()))
	return ret
	return ret
}
func (_static *CompanionStruct_Default___) DecryptTerminal(client *m_AtomicPrimitives.AtomicPrimitivesClient, alg m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo, fieldRootKey _dafny.Sequence, offset uint32, path _dafny.Sequence, data m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal) m_Wrappers.Result {
	var ret m_Wrappers.Result = m_Wrappers.Result{}
	_ = ret
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _0_valueOrError0
	_0_valueOrError0 = Companion_Default___.FieldKey(fieldRootKey, offset)
	if (_0_valueOrError0).IsFailure() {
		ret = (_0_valueOrError0).PropagateFailure()
		return ret
	}
	var _1_dataKey _dafny.Sequence
	_ = _1_dataKey
	_1_dataKey = (_0_valueOrError0).Extract().(_dafny.Sequence)
	var _2_encryptionKey _dafny.Sequence
	_ = _2_encryptionKey
	_2_encryptionKey = (_1_dataKey).Take(uint32(m_StructuredEncryptionUtil.Companion_Default___.KeySize64()))
	var _3_nonce _dafny.Sequence
	_ = _3_nonce
	_3_nonce = (_1_dataKey).Drop(uint32(m_StructuredEncryptionUtil.Companion_Default___.KeySize64()))
	var _4_value _dafny.Sequence
	_ = _4_value
	_4_value = (data).Dtor_value()
	var _5_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _5_valueOrError1
	_5_valueOrError1 = m_Wrappers.Companion_Default___.Need(((m_StructuredEncryptionUtil.Companion_Default___.AuthTagSize64())+(uint64(2))) <= (uint64((_4_value).Cardinality())), m_StructuredEncryptionUtil.Companion_Default___.E(_dafny.SeqOfString("cipherTxt too short.")))
	if (_5_valueOrError1).IsFailure() {
		ret = (_5_valueOrError1).PropagateFailure()
		return ret
	}
	var _6_decInput m_AwsCryptographyPrimitivesTypes.AESDecryptInput
	_ = _6_decInput
	_6_decInput = m_AwsCryptographyPrimitivesTypes.Companion_AESDecryptInput_.Create_AESDecryptInput_(((alg).Dtor_encrypt()).Dtor_AES__GCM(), _2_encryptionKey, (_4_value).Subsequence(uint32(m_StructuredEncryptionUtil.Companion_Default___.TYPEID__LEN64()), uint32((uint64((_4_value).Cardinality()))-(func() uint64 { return (m_StructuredEncryptionUtil.Companion_Default___.AuthTagSize64()) })())), (_4_value).Drop(uint32((uint64((_4_value).Cardinality()))-(func() uint64 { return (m_StructuredEncryptionUtil.Companion_Default___.AuthTagSize64()) })())), _3_nonce, path)
	var _7_decOutR m_Wrappers.Result
	_ = _7_decOutR
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = (client).AESDecrypt(_6_decInput)
	_7_decOutR = _out0
	var _8_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _8_valueOrError2
	_8_valueOrError2 = (_7_decOutR).MapFailure(func(coer22 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error) func(interface{}) interface{} {
		return func(arg31 interface{}) interface{} {
			return coer22(arg31.(m_AwsCryptographyPrimitivesTypes.Error))
		}
	}(func(_9_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error {
		return m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_9_e)
	}))
	if (_8_valueOrError2).IsFailure() {
		ret = (_8_valueOrError2).PropagateFailure()
		return ret
	}
	var _10_decOut _dafny.Sequence
	_ = _10_decOut
	_10_decOut = (_8_valueOrError2).Extract().(_dafny.Sequence)
	ret = m_Wrappers.Companion_Result_.Create_Success_(m_StructuredEncryptionUtil.Companion_Default___.ValueToData(_10_decOut, (_4_value).Take(uint32(m_StructuredEncryptionUtil.Companion_Default___.TYPEID__LEN64()))))
	return ret
	return ret
}
func (_static *CompanionStruct_Default___) ONE__THIRD__MAX__INT() uint32 {
	return uint32(1431655765)
}
func (_static *CompanionStruct_Default___) AwsDbeField() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(65), uint8(119), uint8(115), uint8(68), uint8(98), uint8(101), uint8(70), uint8(105), uint8(101), uint8(108), uint8(100))
	_ = _0_s
	return _0_s
}
func (_static *CompanionStruct_Default___) LABEL__COMMITMENT__KEY() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(65), uint8(87), uint8(83), uint8(95), uint8(68), uint8(66), uint8(69), uint8(95), uint8(67), uint8(79), uint8(77), uint8(77), uint8(73), uint8(84), uint8(95), uint8(75), uint8(69), uint8(89))
	_ = _0_s
	return _0_s
}
func (_static *CompanionStruct_Default___) LABEL__ENCRYPTION__KEY() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(65), uint8(87), uint8(83), uint8(95), uint8(68), uint8(66), uint8(69), uint8(95), uint8(68), uint8(69), uint8(82), uint8(73), uint8(86), uint8(69), uint8(95), uint8(75), uint8(69), uint8(89))
	_ = _0_s
	return _0_s
}

// End of class Default__
