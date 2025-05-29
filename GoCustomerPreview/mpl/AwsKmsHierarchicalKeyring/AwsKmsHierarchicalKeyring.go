// Package AwsKmsHierarchicalKeyring
// Dafny module AwsKmsHierarchicalKeyring compiled into Go

package AwsKmsHierarchicalKeyring

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
	m_AwsCryptographyMaterialProvidersTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsCryptographyMaterialProvidersTypes"
	m_AwsKmsDiscoveryKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsDiscoveryKeyring"
	m_AwsKmsEcdhKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsEcdhKeyring"
	m_AwsKmsKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsKeyring"
	m_AwsKmsMrkMatchForDecrypt "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkMatchForDecrypt"
	m_AwsKmsUtils "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsUtils"
	m_CacheConstants "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CacheConstants"
	m_CanonicalEncryptionContext "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CanonicalEncryptionContext"
	m_Constants "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Constants"
	m_CreateKeyStoreTable "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CreateKeyStoreTable"
	m_CreateKeys "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CreateKeys"
	m_DDBKeystoreOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/DDBKeystoreOperations"
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
	m_MaterialWrapping "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/MaterialWrapping"
	m_Materials "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Materials"
	m_RawAESKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/RawAESKeyring"
	m_RawECDHKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/RawECDHKeyring"
	m_RawRSAKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/RawRSAKeyring"
	m_StormTracker "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/StormTracker"
	m_StormTrackingCMC "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/StormTrackingCMC"
	m_Structure "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Structure"
	m_SynchronizedLocalCMC "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/SynchronizedLocalCMC"
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
	m__Time "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Time_"
	m_UTF8 "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/UTF8"
	m_UUID "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/UUID"
	m_UnicodeStrings "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/UnicodeStrings"
	m__Unicode "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Unicode_"
	m_Utf16EncodingForm "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Utf16EncodingForm"
	m_Utf8EncodingForm "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Utf8EncodingForm"
	m_Wrappers "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Wrappers"
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
var _ m_Relations.Dummy__
var _ m_Seq_MergeSort.Dummy__
var _ m__Math.Dummy__
var _ m_Seq.Dummy__
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
var _ m_Base64.Dummy__
var _ m_Base64Lemmas.Dummy__
var _ m_Actions.Dummy__
var _ m_AwsCryptographyKeyStoreTypes.Dummy__
var _ m_AwsCryptographyMaterialProvidersTypes.Dummy__
var _ m_AwsArnParsing.Dummy__
var _ m_AwsKmsMrkMatchForDecrypt.Dummy__
var _ m_AwsKmsUtils.Dummy__
var _ m_KeyStoreErrorMessages.Dummy__
var _ m_KmsArn.Dummy__
var _ m_Structure.Dummy__
var _ m_KMSKeystoreOperations.Dummy__
var _ m_DDBKeystoreOperations.Dummy__
var _ m_CreateKeys.Dummy__
var _ m_CreateKeyStoreTable.Dummy__
var _ m_GetKeys.Dummy__
var _ m_AwsCryptographyKeyStoreOperations.Dummy__
var _ m_Com_Amazonaws_Kms.Dummy__
var _ m_Com_Amazonaws_Dynamodb.Dummy__
var _ m_KeyStore.Dummy__
var _ m_AlgorithmSuites.Dummy__
var _ m_Materials.Dummy__
var _ m_Keyring.Dummy__
var _ m_CanonicalEncryptionContext.Dummy__
var _ m_MaterialWrapping.Dummy__
var _ m_IntermediateKeyWrapping.Dummy__
var _ m_EdkWrapping.Dummy__
var _ m_ErrorMessages.Dummy__
var _ m_RawAESKeyring.Dummy__
var _ m_Constants.Dummy__
var _ m_EcdhEdkWrapping.Dummy__
var _ m_RawECDHKeyring.Dummy__
var _ m_RawRSAKeyring.Dummy__
var _ m_AwsKmsKeyring.Dummy__
var _ m_AwsKmsDiscoveryKeyring.Dummy__
var _ m_AwsKmsEcdhKeyring.Dummy__
var _ m_LocalCMC.Dummy__
var _ m_SynchronizedLocalCMC.Dummy__
var _ m_StormTracker.Dummy__
var _ m_StormTrackingCMC.Dummy__
var _ m_CacheConstants.Dummy__

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
	return "AwsKmsHierarchicalKeyring.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) CacheEntryWithinLimits(creationTime int64, now int64, ttlSeconds int64) bool {
	return ((now) - (creationTime)) <= (ttlSeconds)
}
func (_static *CompanionStruct_Default___) DeriveEncryptionKeyFromBranchKey(branchKey _dafny.Sequence, salt _dafny.Sequence, purpose m_Wrappers.Option, cryptoPrimitives *m_AtomicPrimitives.AtomicPrimitivesClient) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _0_maybeDerivedBranchKey m_Wrappers.Result
	_ = _0_maybeDerivedBranchKey
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = (cryptoPrimitives).KdfCounterMode(m_AwsCryptographyPrimitivesTypes.Companion_KdfCtrInput_.Create_KdfCtrInput_(m_AwsCryptographyPrimitivesTypes.Companion_DigestAlgorithm_.Create_SHA__256_(), branchKey, Companion_Default___.DERIVED__BRANCH__KEY__EXPECTED__LENGTH(), purpose, m_Wrappers.Companion_Option_.Create_Some_(salt)))
	_0_maybeDerivedBranchKey = _out0
	var _1_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _1_valueOrError0
	_1_valueOrError0 = (_0_maybeDerivedBranchKey).MapFailure(func(coer85 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
		return func(arg86 interface{}) interface{} {
			return coer85(arg86.(m_AwsCryptographyPrimitivesTypes.Error))
		}
	}(func(_2_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
		return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_2_e)
	}))
	if (_1_valueOrError0).IsFailure() {
		output = (_1_valueOrError0).PropagateFailure()
		return output
	}
	var _3_derivedBranchKey _dafny.Sequence
	_ = _3_derivedBranchKey
	_3_derivedBranchKey = (_1_valueOrError0).Extract().(_dafny.Sequence)
	output = m_Wrappers.Companion_Result_.Create_Success_(_3_derivedBranchKey)
	return output
}
func (_static *CompanionStruct_Default___) WrappingAad(branchKeyId _dafny.Sequence, branchKeyVersion _dafny.Sequence, aad _dafny.Sequence) _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(m_Constants.Companion_Default___.PROVIDER__ID__HIERARCHY(), branchKeyId), branchKeyVersion), aad)
}
func (_static *CompanionStruct_Default___) SerializeEDKCiphertext(encOutput m_AwsCryptographyPrimitivesTypes.AESEncryptOutput) _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate((encOutput).Dtor_cipherText(), (encOutput).Dtor_authTag())
}
func (_static *CompanionStruct_Default___) E(s _dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error {
	return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(s)
}
func (_static *CompanionStruct_Default___) AES__256__ENC__KEY__LENGTH() int32 {
	return int32(32)
}
func (_static *CompanionStruct_Default___) AES__256__ENC__TAG__LENGTH() int32 {
	return int32(16)
}
func (_static *CompanionStruct_Default___) AES__256__ENC__IV__LENGTH() int32 {
	return int32(12)
}
func (_static *CompanionStruct_Default___) AES__256__ENC__ALG() m_AwsCryptographyPrimitivesTypes.AES__GCM {
	return m_AwsCryptographyPrimitivesTypes.Companion_AES__GCM_.Create_AES__GCM_(Companion_Default___.AES__256__ENC__KEY__LENGTH(), Companion_Default___.AES__256__ENC__TAG__LENGTH(), Companion_Default___.AES__256__ENC__IV__LENGTH())
}
func (_static *CompanionStruct_Default___) H__WRAP__SALT__LEN() int32 {
	return int32(16)
}
func (_static *CompanionStruct_Default___) H__WRAP__NONCE__LEN() int32 {
	return int32(12)
}
func (_static *CompanionStruct_Default___) EDK__CIPHERTEXT__BRANCH__KEY__VERSION__INDEX() int32 {
	return (Companion_Default___.H__WRAP__SALT__LEN()) + (Companion_Default___.H__WRAP__NONCE__LEN())
}
func (_static *CompanionStruct_Default___) EDK__CIPHERTEXT__VERSION__LENGTH() int32 {
	return int32(16)
}
func (_static *CompanionStruct_Default___) EDK__CIPHERTEXT__VERSION__INDEX() int32 {
	return (Companion_Default___.EDK__CIPHERTEXT__BRANCH__KEY__VERSION__INDEX()) + (Companion_Default___.EDK__CIPHERTEXT__VERSION__LENGTH())
}
func (_static *CompanionStruct_Default___) EXPECTED__EDK__CIPHERTEXT__OVERHEAD() int32 {
	return (Companion_Default___.EDK__CIPHERTEXT__VERSION__INDEX()) + (Companion_Default___.AES__256__ENC__TAG__LENGTH())
}
func (_static *CompanionStruct_Default___) DERIVED__BRANCH__KEY__EXPECTED__LENGTH() int32 {
	return int32(32)
}
func (_static *CompanionStruct_Default___) BRANCH__KEY__STORE__GSI() _dafny.Sequence {
	return _dafny.SeqOfString("Active-Keys")
}
func (_static *CompanionStruct_Default___) BRANCH__KEY__FIELD() _dafny.Sequence {
	return _dafny.SeqOfString("enc")
}
func (_static *CompanionStruct_Default___) VERSION__FIELD() _dafny.Sequence {
	return _dafny.SeqOfString("version")
}
func (_static *CompanionStruct_Default___) BRANCH__KEY__IDENTIFIER__FIELD() _dafny.Sequence {
	return _dafny.SeqOfString("branch-key-id")
}
func (_static *CompanionStruct_Default___) KEY__CONDITION__EXPRESSION() _dafny.Sequence {
	return _dafny.SeqOfString("#status = :status and #branch_key_id = :branch_key_id")
}
func (_static *CompanionStruct_Default___) EXPRESSION__ATTRIBUTE__NAMES() _dafny.Map {
	return _dafny.NewMapBuilder().ToMap().UpdateUnsafe(_dafny.SeqOfString("#status"), _dafny.SeqOfString("status")).UpdateUnsafe(_dafny.SeqOfString("#branch_key_id"), _dafny.SeqOfString("branch-key-id"))
}
func (_static *CompanionStruct_Default___) EXPRESSION__ATTRIBUTE__VALUE__STATUS__KEY() _dafny.Sequence {
	return _dafny.SeqOfString(":status")
}
func (_static *CompanionStruct_Default___) EXPRESSION__ATTRIBUTE__VALUE__STATUS__VALUE() _dafny.Sequence {
	return _dafny.SeqOfString("ACTIVE")
}
func (_static *CompanionStruct_Default___) EXPRESSION__ATTRIBUTE__VALUE__BRANCH__KEY() _dafny.Sequence {
	return _dafny.SeqOfString(":branch_key_id")
}

// End of class Default__

// Definition of class AwsKmsHierarchicalKeyring
type AwsKmsHierarchicalKeyring struct {
	_keyStore                 m_AwsCryptographyKeyStoreTypes.IKeyStoreClient
	_cryptoPrimitives         *m_AtomicPrimitives.AtomicPrimitivesClient
	_cache                    m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsCache
	_branchKeyIdSupplier      m_Wrappers.Option
	_branchKeyId              m_Wrappers.Option
	_ttlSeconds               int64
	_partitionIdBytes         _dafny.Sequence
	_logicalKeyStoreNameBytes _dafny.Sequence
}

func New_AwsKmsHierarchicalKeyring_() *AwsKmsHierarchicalKeyring {
	_this := AwsKmsHierarchicalKeyring{}

	_this._keyStore = (m_AwsCryptographyKeyStoreTypes.IKeyStoreClient)(nil)
	_this._cryptoPrimitives = (*m_AtomicPrimitives.AtomicPrimitivesClient)(nil)
	_this._cache = (m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsCache)(nil)
	_this._branchKeyIdSupplier = m_Wrappers.Companion_Option_.Default()
	_this._branchKeyId = m_Wrappers.Companion_Option_.Default()
	_this._ttlSeconds = int64(0)
	_this._partitionIdBytes = _dafny.EmptySeq
	_this._logicalKeyStoreNameBytes = _dafny.EmptySeq
	return &_this
}

type CompanionStruct_AwsKmsHierarchicalKeyring_ struct {
}

var Companion_AwsKmsHierarchicalKeyring_ = CompanionStruct_AwsKmsHierarchicalKeyring_{}

func (_this *AwsKmsHierarchicalKeyring) Equals(other *AwsKmsHierarchicalKeyring) bool {
	return _this == other
}

func (_this *AwsKmsHierarchicalKeyring) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*AwsKmsHierarchicalKeyring)
	return ok && _this.Equals(other)
}

func (*AwsKmsHierarchicalKeyring) String() string {
	return "AwsKmsHierarchicalKeyring.AwsKmsHierarchicalKeyring"
}

func Type_AwsKmsHierarchicalKeyring_() _dafny.TypeDescriptor {
	return type_AwsKmsHierarchicalKeyring_{}
}

type type_AwsKmsHierarchicalKeyring_ struct {
}

func (_this type_AwsKmsHierarchicalKeyring_) Default() interface{} {
	return (*AwsKmsHierarchicalKeyring)(nil)
}

func (_this type_AwsKmsHierarchicalKeyring_) String() string {
	return "AwsKmsHierarchicalKeyring.AwsKmsHierarchicalKeyring"
}
func (_this *AwsKmsHierarchicalKeyring) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_Keyring.Companion_VerifiableInterface_.TraitID_, m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.TraitID_}
}

var _ m_Keyring.VerifiableInterface = &AwsKmsHierarchicalKeyring{}
var _ m_AwsCryptographyMaterialProvidersTypes.IKeyring = &AwsKmsHierarchicalKeyring{}
var _ _dafny.TraitOffspring = &AwsKmsHierarchicalKeyring{}

func (_this *AwsKmsHierarchicalKeyring) OnDecrypt(input m_AwsCryptographyMaterialProvidersTypes.OnDecryptInput) m_Wrappers.Result {
	var _out7 m_Wrappers.Result
	_ = _out7
	_out7 = m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.OnDecrypt(_this, input)
	return _out7
}
func (_this *AwsKmsHierarchicalKeyring) OnEncrypt(input m_AwsCryptographyMaterialProvidersTypes.OnEncryptInput) m_Wrappers.Result {
	var _out7 m_Wrappers.Result
	_ = _out7
	_out7 = m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.OnEncrypt(_this, input)
	return _out7
}
func (_this *AwsKmsHierarchicalKeyring) Ctor__(keyStore m_AwsCryptographyKeyStoreTypes.IKeyStoreClient, branchKeyId m_Wrappers.Option, branchKeyIdSupplier m_Wrappers.Option, ttlSeconds int64, cmc m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsCache, partitionIdBytes _dafny.Sequence, logicalKeyStoreNameBytes _dafny.Sequence, cryptoPrimitives *m_AtomicPrimitives.AtomicPrimitivesClient) {
	{
		(_this)._keyStore = keyStore
		(_this)._branchKeyId = branchKeyId
		(_this)._branchKeyIdSupplier = branchKeyIdSupplier
		(_this)._ttlSeconds = ttlSeconds
		(_this)._cryptoPrimitives = cryptoPrimitives
		(_this)._cache = cmc
		(_this)._partitionIdBytes = partitionIdBytes
		(_this)._logicalKeyStoreNameBytes = logicalKeyStoreNameBytes
	}
}
func (_this *AwsKmsHierarchicalKeyring) GetBranchKeyId(context _dafny.Map) m_Wrappers.Result {
	{
		var ret m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
		_ = ret
		if ((_this).BranchKeyId()).Is_Some() {
			ret = m_Wrappers.Companion_Result_.Create_Success_(((_this).BranchKeyId()).Dtor_value().(_dafny.Sequence))
			return ret
		} else {
			var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyMaterialProvidersTypes.Companion_GetBranchKeyIdOutput_.Default())
			_ = _0_valueOrError0
			var _out0 m_Wrappers.Result
			_ = _out0
			_out0 = (m_AwsCryptographyMaterialProvidersTypes.Companion_IBranchKeyIdSupplier_.CastTo_(((_this).BranchKeyIdSupplier()).Dtor_value())).GetBranchKeyId(m_AwsCryptographyMaterialProvidersTypes.Companion_GetBranchKeyIdInput_.Create_GetBranchKeyIdInput_(context))
			_0_valueOrError0 = _out0
			if (_0_valueOrError0).IsFailure() {
				ret = (_0_valueOrError0).PropagateFailure()
				return ret
			}
			var _1_GetBranchKeyIdOut m_AwsCryptographyMaterialProvidersTypes.GetBranchKeyIdOutput
			_ = _1_GetBranchKeyIdOut
			_1_GetBranchKeyIdOut = (_0_valueOrError0).Extract().(m_AwsCryptographyMaterialProvidersTypes.GetBranchKeyIdOutput)
			ret = m_Wrappers.Companion_Result_.Create_Success_((_1_GetBranchKeyIdOut).Dtor_branchKeyId())
			return ret
		}
		return ret
	}
}
func (_this *AwsKmsHierarchicalKeyring) OnEncrypt_k(input m_AwsCryptographyMaterialProvidersTypes.OnEncryptInput) m_Wrappers.Result {
	{
		var res m_Wrappers.Result = m_Wrappers.Result{}
		_ = res
		var _0_materials m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials
		_ = _0_materials
		_0_materials = (input).Dtor_materials()
		var _1_suite m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo
		_ = _1_suite
		_1_suite = (_0_materials).Dtor_algorithmSuite()
		var _2_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
		_ = _2_valueOrError0
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = (_this).GetBranchKeyId((_0_materials).Dtor_encryptionContext())
		_2_valueOrError0 = _out0
		if (_2_valueOrError0).IsFailure() {
			res = (_2_valueOrError0).PropagateFailure()
			return res
		}
		var _3_branchKeyIdForEncrypt _dafny.Sequence
		_ = _3_branchKeyIdForEncrypt
		_3_branchKeyIdForEncrypt = (_2_valueOrError0).Extract().(_dafny.Sequence)
		var _4_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_UTF8.Companion_ValidUTF8Bytes_.Witness())
		_ = _4_valueOrError1
		_4_valueOrError1 = (m_UTF8.Encode(_3_branchKeyIdForEncrypt)).MapFailure(func(coer86 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg87 interface{}) interface{} {
				return coer86(arg87.(_dafny.Sequence))
			}
		}(m_AwsKmsUtils.Companion_Default___.WrapStringToError))
		if (_4_valueOrError1).IsFailure() {
			res = (_4_valueOrError1).PropagateFailure()
			return res
		}
		var _5_branchKeyIdUtf8 _dafny.Sequence
		_ = _5_branchKeyIdUtf8
		_5_branchKeyIdUtf8 = (_4_valueOrError1).Extract().(_dafny.Sequence)
		var _6_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _6_valueOrError2
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = (_this).GetActiveCacheId(_3_branchKeyIdForEncrypt, _5_branchKeyIdUtf8, (_this).CryptoPrimitives())
		_6_valueOrError2 = _out1
		if (_6_valueOrError2).IsFailure() {
			res = (_6_valueOrError2).PropagateFailure()
			return res
		}
		var _7_cacheId _dafny.Sequence
		_ = _7_cacheId
		_7_cacheId = (_6_valueOrError2).Extract().(_dafny.Sequence)
		var _8_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyKeyStoreTypes.Companion_BranchKeyMaterials_.Default())
		_ = _8_valueOrError3
		var _out2 m_Wrappers.Result
		_ = _out2
		_out2 = (_this).GetActiveHierarchicalMaterials(_3_branchKeyIdForEncrypt, _7_cacheId, (_this).KeyStore())
		_8_valueOrError3 = _out2
		if (_8_valueOrError3).IsFailure() {
			res = (_8_valueOrError3).PropagateFailure()
			return res
		}
		var _9_hierarchicalMaterials m_AwsCryptographyKeyStoreTypes.BranchKeyMaterials
		_ = _9_hierarchicalMaterials
		_9_hierarchicalMaterials = (_8_valueOrError3).Extract().(m_AwsCryptographyKeyStoreTypes.BranchKeyMaterials)
		var _10_branchKey _dafny.Sequence
		_ = _10_branchKey
		_10_branchKey = (_9_hierarchicalMaterials).Dtor_branchKey()
		var _11_branchKeyVersion _dafny.Sequence
		_ = _11_branchKeyVersion
		_11_branchKeyVersion = (_9_hierarchicalMaterials).Dtor_branchKeyVersion()
		var _12_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
		_ = _12_valueOrError4
		_12_valueOrError4 = (m_UTF8.Decode(_11_branchKeyVersion)).MapFailure(func(coer87 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg88 interface{}) interface{} {
				return coer87(arg88.(_dafny.Sequence))
			}
		}(m_AwsKmsUtils.Companion_Default___.WrapStringToError))
		if (_12_valueOrError4).IsFailure() {
			res = (_12_valueOrError4).PropagateFailure()
			return res
		}
		var _13_branchKeyVersionAsString _dafny.Sequence
		_ = _13_branchKeyVersionAsString
		_13_branchKeyVersionAsString = (_12_valueOrError4).Extract().(_dafny.Sequence)
		var _14_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _14_valueOrError5
		_14_valueOrError5 = (m_UUID.ToByteArray(_13_branchKeyVersionAsString)).MapFailure(func(coer88 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg89 interface{}) interface{} {
				return coer88(arg89.(_dafny.Sequence))
			}
		}(m_AwsKmsUtils.Companion_Default___.WrapStringToError))
		if (_14_valueOrError5).IsFailure() {
			res = (_14_valueOrError5).PropagateFailure()
			return res
		}
		var _15_branchKeyVersionAsBytes _dafny.Sequence
		_ = _15_branchKeyVersionAsBytes
		_15_branchKeyVersionAsBytes = (_14_valueOrError5).Extract().(_dafny.Sequence)
		var _16_kmsHierarchyGenerateAndWrap *KmsHierarchyGenerateAndWrapKeyMaterial
		_ = _16_kmsHierarchyGenerateAndWrap
		var _nw0 *KmsHierarchyGenerateAndWrapKeyMaterial = New_KmsHierarchyGenerateAndWrapKeyMaterial_()
		_ = _nw0
		_nw0.Ctor__((_9_hierarchicalMaterials).Dtor_branchKey(), _5_branchKeyIdUtf8, _15_branchKeyVersionAsBytes, (_this).CryptoPrimitives())
		_16_kmsHierarchyGenerateAndWrap = _nw0
		var _17_kmsHierarchyWrap *KmsHierarchyWrapKeyMaterial
		_ = _17_kmsHierarchyWrap
		var _nw1 *KmsHierarchyWrapKeyMaterial = New_KmsHierarchyWrapKeyMaterial_()
		_ = _nw1
		_nw1.Ctor__((_9_hierarchicalMaterials).Dtor_branchKey(), _5_branchKeyIdUtf8, _15_branchKeyVersionAsBytes, (_this).CryptoPrimitives())
		_17_kmsHierarchyWrap = _nw1
		var _18_valueOrError6 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_EdkWrapping.Companion_WrapEdkMaterialOutput_.Default(Companion_HierarchyWrapInfo_.Default()))
		_ = _18_valueOrError6
		var _out3 m_Wrappers.Result
		_ = _out3
		_out3 = m_EdkWrapping.Companion_Default___.WrapEdkMaterial(_0_materials, _17_kmsHierarchyWrap, _16_kmsHierarchyGenerateAndWrap)
		_18_valueOrError6 = _out3
		if (_18_valueOrError6).IsFailure() {
			res = (_18_valueOrError6).PropagateFailure()
			return res
		}
		var _19_wrapOutput m_EdkWrapping.WrapEdkMaterialOutput
		_ = _19_wrapOutput
		_19_wrapOutput = (_18_valueOrError6).Extract().(m_EdkWrapping.WrapEdkMaterialOutput)
		var _20_symmetricSigningKeyList m_Wrappers.Option
		_ = _20_symmetricSigningKeyList
		if ((_19_wrapOutput).Dtor_symmetricSigningKey()).Is_Some() {
			_20_symmetricSigningKeyList = m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(((_19_wrapOutput).Dtor_symmetricSigningKey()).Dtor_value().(_dafny.Sequence)))
		} else {
			_20_symmetricSigningKeyList = m_Wrappers.Companion_Option_.Create_None_()
		}
		var _21_edk m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey
		_ = _21_edk
		_21_edk = m_AwsCryptographyMaterialProvidersTypes.Companion_EncryptedDataKey_.Create_EncryptedDataKey_(m_Constants.Companion_Default___.PROVIDER__ID__HIERARCHY(), _5_branchKeyIdUtf8, (_19_wrapOutput).Dtor_wrappedMaterial())
		if (_19_wrapOutput).Is_GenerateAndWrapEdkMaterialOutput() {
			var _22_valueOrError7 m_Wrappers.Result = m_Wrappers.Result{}
			_ = _22_valueOrError7
			_22_valueOrError7 = m_Materials.Companion_Default___.EncryptionMaterialAddDataKey(_0_materials, (_19_wrapOutput).Dtor_plaintextDataKey(), _dafny.SeqOf(_21_edk), _20_symmetricSigningKeyList)
			if (_22_valueOrError7).IsFailure() {
				res = (_22_valueOrError7).PropagateFailure()
				return res
			}
			var _23_result m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials
			_ = _23_result
			_23_result = (_22_valueOrError7).Extract().(m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials)
			res = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyMaterialProvidersTypes.Companion_OnEncryptOutput_.Create_OnEncryptOutput_(_23_result))
			return res
		} else if (_19_wrapOutput).Is_WrapOnlyEdkMaterialOutput() {
			var _24_valueOrError8 m_Wrappers.Result = m_Wrappers.Result{}
			_ = _24_valueOrError8
			_24_valueOrError8 = m_Materials.Companion_Default___.EncryptionMaterialAddEncryptedDataKeys(_0_materials, _dafny.SeqOf(_21_edk), _20_symmetricSigningKeyList)
			if (_24_valueOrError8).IsFailure() {
				res = (_24_valueOrError8).PropagateFailure()
				return res
			}
			var _25_result m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials
			_ = _25_result
			_25_result = (_24_valueOrError8).Extract().(m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials)
			res = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyMaterialProvidersTypes.Companion_OnEncryptOutput_.Create_OnEncryptOutput_(_25_result))
			return res
		}
		return res
	}
}
func (_this *AwsKmsHierarchicalKeyring) OnDecrypt_k(input m_AwsCryptographyMaterialProvidersTypes.OnDecryptInput) m_Wrappers.Result {
	{
		var res m_Wrappers.Result = m_Wrappers.Result{}
		_ = res
		var _0_materials m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials
		_ = _0_materials
		_0_materials = (input).Dtor_materials()
		var _1_suite m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo
		_ = _1_suite
		_1_suite = ((input).Dtor_materials()).Dtor_algorithmSuite()
		var _2_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _2_valueOrError0
		_2_valueOrError0 = m_Wrappers.Companion_Default___.Need(m_Materials.Companion_Default___.DecryptionMaterialsWithoutPlaintextDataKey(_0_materials), Companion_Default___.E(_dafny.SeqOfString("Keyring received decryption materials that already contain a plaintext data key.")))
		if (_2_valueOrError0).IsFailure() {
			res = (_2_valueOrError0).PropagateFailure()
			return res
		}
		var _3_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
		_ = _3_valueOrError1
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = (_this).GetBranchKeyId((_0_materials).Dtor_encryptionContext())
		_3_valueOrError1 = _out0
		if (_3_valueOrError1).IsFailure() {
			res = (_3_valueOrError1).PropagateFailure()
			return res
		}
		var _4_branchKeyIdForDecrypt _dafny.Sequence
		_ = _4_branchKeyIdForDecrypt
		_4_branchKeyIdForDecrypt = (_3_valueOrError1).Extract().(_dafny.Sequence)
		var _5_filter *OnDecryptHierarchyEncryptedDataKeyFilter
		_ = _5_filter
		var _nw0 *OnDecryptHierarchyEncryptedDataKeyFilter = New_OnDecryptHierarchyEncryptedDataKeyFilter_()
		_ = _nw0
		_nw0.Ctor__(_4_branchKeyIdForDecrypt)
		_5_filter = _nw0
		var _6_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _6_valueOrError2
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = m_Actions.Companion_Default___.FilterWithResult(_5_filter, (input).Dtor_encryptedDataKeys())
		_6_valueOrError2 = _out1
		if (_6_valueOrError2).IsFailure() {
			res = (_6_valueOrError2).PropagateFailure()
			return res
		}
		var _7_edksToAttempt _dafny.Sequence
		_ = _7_edksToAttempt
		_7_edksToAttempt = (_6_valueOrError2).Extract().(_dafny.Sequence)
		if (uint64(0)) == (uint64((_7_edksToAttempt).Cardinality())) {
			var _8_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
			_ = _8_valueOrError3
			_8_valueOrError3 = m_ErrorMessages.Companion_Default___.IncorrectDataKeys((input).Dtor_encryptedDataKeys(), ((input).Dtor_materials()).Dtor_algorithmSuite(), _dafny.SeqOfString(""))
			if (_8_valueOrError3).IsFailure() {
				res = (_8_valueOrError3).PropagateFailure()
				return res
			}
			var _9_errorMessage _dafny.Sequence
			_ = _9_errorMessage
			_9_errorMessage = (_8_valueOrError3).Extract().(_dafny.Sequence)
			res = m_Wrappers.Companion_Result_.Create_Failure_(m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_9_errorMessage))
			return res
		}
		var _10_decryptClosure m_Actions.ActionWithResult
		_ = _10_decryptClosure
		var _nw1 *DecryptSingleEncryptedDataKey = New_DecryptSingleEncryptedDataKey_()
		_ = _nw1
		_nw1.Ctor__(_0_materials, (_this).KeyStore(), (_this).CryptoPrimitives(), _4_branchKeyIdForDecrypt, (_this).TtlSeconds(), (_this).Cache(), (_this).PartitionIdBytes(), (_this).LogicalKeyStoreNameBytes())
		_10_decryptClosure = _nw1
		var _11_outcome m_Wrappers.Result
		_ = _11_outcome
		var _out2 m_Wrappers.Result
		_ = _out2
		_out2 = m_Actions.Companion_Default___.ReduceToSuccess(_10_decryptClosure, _7_edksToAttempt)
		_11_outcome = _out2
		var _12_valueOrError4 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _12_valueOrError4
		_12_valueOrError4 = (_11_outcome).MapFailure(func(coer89 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg90 interface{}) interface{} {
				return coer89(arg90.(_dafny.Sequence))
			}
		}(func(_13_errors _dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error {
			return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_CollectionOfErrors_(_13_errors, _dafny.SeqOfString("No Configured KMS Key was able to decrypt the Data Key. The list of encountered Exceptions is available via `list`."))
		}))
		if (_12_valueOrError4).IsFailure() {
			res = (_12_valueOrError4).PropagateFailure()
			return res
		}
		var _14_SealedDecryptionMaterials m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials
		_ = _14_SealedDecryptionMaterials
		_14_SealedDecryptionMaterials = (_12_valueOrError4).Extract().(m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials)
		res = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyMaterialProvidersTypes.Companion_OnDecryptOutput_.Create_OnDecryptOutput_(_14_SealedDecryptionMaterials))
		return res
		return res
	}
}
func (_this *AwsKmsHierarchicalKeyring) GetActiveCacheId(branchKeyId _dafny.Sequence, branchKeyIdUtf8 _dafny.Sequence, cryptoPrimitives *m_AtomicPrimitives.AtomicPrimitivesClient) m_Wrappers.Result {
	{
		var cacheId m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = cacheId
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _0_valueOrError0
		_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((true) && (func(_pat_let6_0 m_Wrappers.Result) bool {
			return func(_1_branchKeyId m_Wrappers.Result) bool {
				return ((_1_branchKeyId).Is_Success()) && (((uint64(0)) <= (uint64(((_1_branchKeyId).Dtor_value().(_dafny.Sequence)).Cardinality()))) && ((uint64(((_1_branchKeyId).Dtor_value().(_dafny.Sequence)).Cardinality())) < ((m_StandardLibrary_UInt.Companion_Default___.UINT32__LIMIT()).Uint64())))
			}(_pat_let6_0)
		}(m_UTF8.Decode(branchKeyIdUtf8))), Companion_Default___.E(_dafny.SeqOfString("Invalid Branch Key ID Length")))
		if (_0_valueOrError0).IsFailure() {
			cacheId = (_0_valueOrError0).PropagateFailure()
			return cacheId
		}
		var _2_hashAlgorithm m_AwsCryptographyPrimitivesTypes.DigestAlgorithm
		_ = _2_hashAlgorithm
		_2_hashAlgorithm = m_AwsCryptographyPrimitivesTypes.Companion_DigestAlgorithm_.Create_SHA__384_()
		var _3_resourceId _dafny.Sequence
		_ = _3_resourceId
		_3_resourceId = m_CacheConstants.Companion_Default___.RESOURCE__ID__HIERARCHICAL__KEYRING()
		var _4_scopeId _dafny.Sequence
		_ = _4_scopeId
		_4_scopeId = m_CacheConstants.Companion_Default___.SCOPE__ID__ENCRYPT()
		var _5_suffix _dafny.Sequence
		_ = _5_suffix
		_5_suffix = _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate((_this).LogicalKeyStoreNameBytes(), m_CacheConstants.Companion_Default___.NULL__BYTE()), branchKeyIdUtf8)
		var _6_identifier _dafny.Sequence
		_ = _6_identifier
		_6_identifier = _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_3_resourceId, m_CacheConstants.Companion_Default___.NULL__BYTE()), _4_scopeId), m_CacheConstants.Companion_Default___.NULL__BYTE()), (_this).PartitionIdBytes()), m_CacheConstants.Companion_Default___.NULL__BYTE()), _5_suffix)
		var _7_maybeCacheIdDigest m_Wrappers.Result
		_ = _7_maybeCacheIdDigest
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = (cryptoPrimitives).Digest(m_AwsCryptographyPrimitivesTypes.Companion_DigestInput_.Create_DigestInput_(_2_hashAlgorithm, _6_identifier))
		_7_maybeCacheIdDigest = _out0
		var _8_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _8_valueOrError1
		_8_valueOrError1 = (_7_maybeCacheIdDigest).MapFailure(func(coer90 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg91 interface{}) interface{} {
				return coer90(arg91.(m_AwsCryptographyPrimitivesTypes.Error))
			}
		}(func(_9_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
			return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_9_e)
		}))
		if (_8_valueOrError1).IsFailure() {
			cacheId = (_8_valueOrError1).PropagateFailure()
			return cacheId
		}
		var _10_cacheDigest _dafny.Sequence
		_ = _10_cacheDigest
		_10_cacheDigest = (_8_valueOrError1).Extract().(_dafny.Sequence)
		var _11_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _11_valueOrError2
		_11_valueOrError2 = m_Wrappers.Companion_Default___.Need((uint64((_10_cacheDigest).Cardinality())) == (m_Digest.Companion_Default___.Length(_2_hashAlgorithm)), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Digest generated a message not equal to the expected length.")))
		if (_11_valueOrError2).IsFailure() {
			cacheId = (_11_valueOrError2).PropagateFailure()
			return cacheId
		}
		cacheId = m_Wrappers.Companion_Result_.Create_Success_(_10_cacheDigest)
		return cacheId
		return cacheId
	}
}
func (_this *AwsKmsHierarchicalKeyring) GetActiveHierarchicalMaterials(branchKeyId _dafny.Sequence, cacheId _dafny.Sequence, keyStore m_AwsCryptographyKeyStoreTypes.IKeyStoreClient) m_Wrappers.Result {
	{
		var material m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyKeyStoreTypes.Companion_BranchKeyMaterials_.Default())
		_ = material
		var _0_getCacheInput m_AwsCryptographyMaterialProvidersTypes.GetCacheEntryInput
		_ = _0_getCacheInput
		_0_getCacheInput = m_AwsCryptographyMaterialProvidersTypes.Companion_GetCacheEntryInput_.Create_GetCacheEntryInput_(cacheId, m_Wrappers.Companion_Option_.Create_None_())
		var _1_getCacheOutput m_Wrappers.Result
		_ = _1_getCacheOutput
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = ((_this).Cache()).GetCacheEntry(_0_getCacheInput)
		_1_getCacheOutput = _out0
		if ((_1_getCacheOutput).Is_Failure()) && (!(((_1_getCacheOutput).Dtor_error().(m_AwsCryptographyMaterialProvidersTypes.Error)).Is_EntryDoesNotExist())) {
			material = m_Wrappers.Companion_Result_.Create_Failure_((_1_getCacheOutput).Dtor_error().(m_AwsCryptographyMaterialProvidersTypes.Error))
			return material
		}
		var _2_now int64
		_ = _2_now
		var _out1 int64
		_ = _out1
		_out1 = m__Time.CurrentRelativeTime()
		_2_now = _out1
		if ((_1_getCacheOutput).Is_Failure()) || (!(Companion_Default___.CacheEntryWithinLimits(((_1_getCacheOutput).Dtor_value().(m_AwsCryptographyMaterialProvidersTypes.GetCacheEntryOutput)).Dtor_creationTime(), _2_now, (_this).TtlSeconds()))) {
			var _3_maybeGetActiveBranchKeyOutput m_Wrappers.Result
			_ = _3_maybeGetActiveBranchKeyOutput
			var _out2 m_Wrappers.Result
			_ = _out2
			_out2 = (keyStore).GetActiveBranchKey(m_AwsCryptographyKeyStoreTypes.Companion_GetActiveBranchKeyInput_.Create_GetActiveBranchKeyInput_(branchKeyId))
			_3_maybeGetActiveBranchKeyOutput = _out2
			var _4_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyKeyStoreTypes.Companion_GetActiveBranchKeyOutput_.Default())
			_ = _4_valueOrError0
			_4_valueOrError0 = (_3_maybeGetActiveBranchKeyOutput).MapFailure(func(coer91 func(m_AwsCryptographyKeyStoreTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
				return func(arg92 interface{}) interface{} {
					return coer91(arg92.(m_AwsCryptographyKeyStoreTypes.Error))
				}
			}(func(_5_e m_AwsCryptographyKeyStoreTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
				return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyKeyStore_(_5_e)
			}))
			if (_4_valueOrError0).IsFailure() {
				material = (_4_valueOrError0).PropagateFailure()
				return material
			}
			var _6_getActiveBranchKeyOutput m_AwsCryptographyKeyStoreTypes.GetActiveBranchKeyOutput
			_ = _6_getActiveBranchKeyOutput
			_6_getActiveBranchKeyOutput = (_4_valueOrError0).Extract().(m_AwsCryptographyKeyStoreTypes.GetActiveBranchKeyOutput)
			var _7_branchKeyMaterials m_AwsCryptographyKeyStoreTypes.BranchKeyMaterials
			_ = _7_branchKeyMaterials
			_7_branchKeyMaterials = (_6_getActiveBranchKeyOutput).Dtor_branchKeyMaterials()
			var _8_now int64
			_ = _8_now
			var _out3 int64
			_ = _out3
			_out3 = m__Time.CurrentRelativeTime()
			_8_now = _out3
			var _9_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
			_ = _9_valueOrError1
			_9_valueOrError1 = m_Wrappers.Companion_Default___.Need(((_dafny.IntOfInt64(_8_now)).Plus(_dafny.IntOfInt64((_this).TtlSeconds()))).Cmp(m_StandardLibrary_UInt.Companion_Default___.INT64__MAX__LIMIT()) < 0, m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("INT64 Overflow when putting cache entry.")))
			if (_9_valueOrError1).IsFailure() {
				material = (_9_valueOrError1).PropagateFailure()
				return material
			}
			var _10_putCacheEntryInput m_AwsCryptographyMaterialProvidersTypes.PutCacheEntryInput
			_ = _10_putCacheEntryInput
			_10_putCacheEntryInput = m_AwsCryptographyMaterialProvidersTypes.Companion_PutCacheEntryInput_.Create_PutCacheEntryInput_(cacheId, m_AwsCryptographyMaterialProvidersTypes.Companion_Materials_.Create_BranchKey_(_7_branchKeyMaterials), _8_now, ((_this).TtlSeconds())+(_8_now), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
			var _11_putResult m_Wrappers.Result
			_ = _11_putResult
			var _out4 m_Wrappers.Result
			_ = _out4
			_out4 = ((_this).Cache()).PutCacheEntry(_10_putCacheEntryInput)
			_11_putResult = _out4
			if ((_11_putResult).Is_Failure()) && (!(((_11_putResult).Dtor_error().(m_AwsCryptographyMaterialProvidersTypes.Error)).Is_EntryAlreadyExists())) {
				material = m_Wrappers.Companion_Result_.Create_Failure_((_11_putResult).Dtor_error().(m_AwsCryptographyMaterialProvidersTypes.Error))
				return material
			}
			material = m_Wrappers.Companion_Result_.Create_Success_(_7_branchKeyMaterials)
			return material
		} else {
			var _12_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
			_ = _12_valueOrError2
			_12_valueOrError2 = m_Wrappers.Companion_Default___.Need((((_1_getCacheOutput).Dtor_value().(m_AwsCryptographyMaterialProvidersTypes.GetCacheEntryOutput)).Dtor_materials()).Is_BranchKey(), Companion_Default___.E(_dafny.SeqOfString("Invalid Material Type.")))
			if (_12_valueOrError2).IsFailure() {
				material = (_12_valueOrError2).PropagateFailure()
				return material
			}
			material = m_Wrappers.Companion_Result_.Create_Success_((((_1_getCacheOutput).Dtor_value().(m_AwsCryptographyMaterialProvidersTypes.GetCacheEntryOutput)).Dtor_materials()).Dtor_BranchKey())
			return material
		}
		return material
	}
}
func (_this *AwsKmsHierarchicalKeyring) KeyStore() m_AwsCryptographyKeyStoreTypes.IKeyStoreClient {
	{
		return _this._keyStore
	}
}
func (_this *AwsKmsHierarchicalKeyring) CryptoPrimitives() *m_AtomicPrimitives.AtomicPrimitivesClient {
	{
		return _this._cryptoPrimitives
	}
}
func (_this *AwsKmsHierarchicalKeyring) Cache() m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsCache {
	{
		return _this._cache
	}
}
func (_this *AwsKmsHierarchicalKeyring) BranchKeyIdSupplier() m_Wrappers.Option {
	{
		return _this._branchKeyIdSupplier
	}
}
func (_this *AwsKmsHierarchicalKeyring) BranchKeyId() m_Wrappers.Option {
	{
		return _this._branchKeyId
	}
}
func (_this *AwsKmsHierarchicalKeyring) TtlSeconds() int64 {
	{
		return _this._ttlSeconds
	}
}
func (_this *AwsKmsHierarchicalKeyring) PartitionIdBytes() _dafny.Sequence {
	{
		return _this._partitionIdBytes
	}
}
func (_this *AwsKmsHierarchicalKeyring) LogicalKeyStoreNameBytes() _dafny.Sequence {
	{
		return _this._logicalKeyStoreNameBytes
	}
}

// End of class AwsKmsHierarchicalKeyring

// Definition of class OnDecryptHierarchyEncryptedDataKeyFilter
type OnDecryptHierarchyEncryptedDataKeyFilter struct {
	_branchKeyId _dafny.Sequence
}

func New_OnDecryptHierarchyEncryptedDataKeyFilter_() *OnDecryptHierarchyEncryptedDataKeyFilter {
	_this := OnDecryptHierarchyEncryptedDataKeyFilter{}

	_this._branchKeyId = _dafny.EmptySeq.SetString()
	return &_this
}

type CompanionStruct_OnDecryptHierarchyEncryptedDataKeyFilter_ struct {
}

var Companion_OnDecryptHierarchyEncryptedDataKeyFilter_ = CompanionStruct_OnDecryptHierarchyEncryptedDataKeyFilter_{}

func (_this *OnDecryptHierarchyEncryptedDataKeyFilter) Equals(other *OnDecryptHierarchyEncryptedDataKeyFilter) bool {
	return _this == other
}

func (_this *OnDecryptHierarchyEncryptedDataKeyFilter) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*OnDecryptHierarchyEncryptedDataKeyFilter)
	return ok && _this.Equals(other)
}

func (*OnDecryptHierarchyEncryptedDataKeyFilter) String() string {
	return "AwsKmsHierarchicalKeyring.OnDecryptHierarchyEncryptedDataKeyFilter"
}

func Type_OnDecryptHierarchyEncryptedDataKeyFilter_() _dafny.TypeDescriptor {
	return type_OnDecryptHierarchyEncryptedDataKeyFilter_{}
}

type type_OnDecryptHierarchyEncryptedDataKeyFilter_ struct {
}

func (_this type_OnDecryptHierarchyEncryptedDataKeyFilter_) Default() interface{} {
	return (*OnDecryptHierarchyEncryptedDataKeyFilter)(nil)
}

func (_this type_OnDecryptHierarchyEncryptedDataKeyFilter_) String() string {
	return "AwsKmsHierarchicalKeyring.OnDecryptHierarchyEncryptedDataKeyFilter"
}
func (_this *OnDecryptHierarchyEncryptedDataKeyFilter) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_Actions.Companion_DeterministicActionWithResult_.TraitID_, m_Actions.Companion_DeterministicAction_.TraitID_}
}

var _ m_Actions.DeterministicActionWithResult = &OnDecryptHierarchyEncryptedDataKeyFilter{}
var _ m_Actions.DeterministicAction = &OnDecryptHierarchyEncryptedDataKeyFilter{}
var _ _dafny.TraitOffspring = &OnDecryptHierarchyEncryptedDataKeyFilter{}

func (_this *OnDecryptHierarchyEncryptedDataKeyFilter) Ctor__(branchKeyId _dafny.Sequence) {
	{
		(_this)._branchKeyId = branchKeyId
	}
}
func (_this *OnDecryptHierarchyEncryptedDataKeyFilter) Invoke(edk interface{}) interface{} {
	{
		var edk m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey = edk.(m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey)
		_ = edk
		var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
		_ = res
		var _0_providerInfo _dafny.Sequence
		_ = _0_providerInfo
		_0_providerInfo = (edk).Dtor_keyProviderInfo()
		var _1_providerId _dafny.Sequence
		_ = _1_providerId
		_1_providerId = (edk).Dtor_keyProviderId()
		if !_dafny.Companion_Sequence_.Equal(_1_providerId, m_Constants.Companion_Default___.PROVIDER__ID__HIERARCHY()) {
			res = m_Wrappers.Companion_Result_.Create_Success_(false)
			return res
		}
		var _2_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
		_ = _2_valueOrError0
		_2_valueOrError0 = (m_UTF8.Decode(_0_providerInfo)).MapFailure(func(coer92 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg93 interface{}) interface{} {
				return coer92(arg93.(_dafny.Sequence))
			}
		}(func(_3_e _dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error {
			return Companion_Default___.E(_dafny.SeqOfString("Invalid encoding, provider info is not UTF8."))
		}))
		if (_2_valueOrError0).IsFailure() {
			res = (_2_valueOrError0).PropagateFailure()
			return res
		}
		var _4_branchKeyId _dafny.Sequence
		_ = _4_branchKeyId
		_4_branchKeyId = (_2_valueOrError0).Extract().(_dafny.Sequence)
		res = m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Equal((_this).BranchKeyId(), _4_branchKeyId))
		return res
		return res
	}
}
func (_this *OnDecryptHierarchyEncryptedDataKeyFilter) BranchKeyId() _dafny.Sequence {
	{
		return _this._branchKeyId
	}
}

// End of class OnDecryptHierarchyEncryptedDataKeyFilter

// Definition of class DecryptSingleEncryptedDataKey
type DecryptSingleEncryptedDataKey struct {
	_materials                m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials
	_keyStore                 m_AwsCryptographyKeyStoreTypes.IKeyStoreClient
	_cryptoPrimitives         *m_AtomicPrimitives.AtomicPrimitivesClient
	_branchKeyId              _dafny.Sequence
	_ttlSeconds               int64
	_cache                    m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsCache
	_partitionIdBytes         _dafny.Sequence
	_logicalKeyStoreNameBytes _dafny.Sequence
}

func New_DecryptSingleEncryptedDataKey_() *DecryptSingleEncryptedDataKey {
	_this := DecryptSingleEncryptedDataKey{}

	_this._materials = m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials{}
	_this._keyStore = (m_AwsCryptographyKeyStoreTypes.IKeyStoreClient)(nil)
	_this._cryptoPrimitives = (*m_AtomicPrimitives.AtomicPrimitivesClient)(nil)
	_this._branchKeyId = _dafny.EmptySeq.SetString()
	_this._ttlSeconds = int64(0)
	_this._cache = (m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsCache)(nil)
	_this._partitionIdBytes = _dafny.EmptySeq
	_this._logicalKeyStoreNameBytes = _dafny.EmptySeq
	return &_this
}

type CompanionStruct_DecryptSingleEncryptedDataKey_ struct {
}

var Companion_DecryptSingleEncryptedDataKey_ = CompanionStruct_DecryptSingleEncryptedDataKey_{}

func (_this *DecryptSingleEncryptedDataKey) Equals(other *DecryptSingleEncryptedDataKey) bool {
	return _this == other
}

func (_this *DecryptSingleEncryptedDataKey) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*DecryptSingleEncryptedDataKey)
	return ok && _this.Equals(other)
}

func (*DecryptSingleEncryptedDataKey) String() string {
	return "AwsKmsHierarchicalKeyring.DecryptSingleEncryptedDataKey"
}

func Type_DecryptSingleEncryptedDataKey_() _dafny.TypeDescriptor {
	return type_DecryptSingleEncryptedDataKey_{}
}

type type_DecryptSingleEncryptedDataKey_ struct {
}

func (_this type_DecryptSingleEncryptedDataKey_) Default() interface{} {
	return (*DecryptSingleEncryptedDataKey)(nil)
}

func (_this type_DecryptSingleEncryptedDataKey_) String() string {
	return "AwsKmsHierarchicalKeyring.DecryptSingleEncryptedDataKey"
}
func (_this *DecryptSingleEncryptedDataKey) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_Actions.Companion_ActionWithResult_.TraitID_, m_Actions.Companion_Action_.TraitID_}
}

var _ m_Actions.ActionWithResult = &DecryptSingleEncryptedDataKey{}
var _ m_Actions.Action = &DecryptSingleEncryptedDataKey{}
var _ _dafny.TraitOffspring = &DecryptSingleEncryptedDataKey{}

func (_this *DecryptSingleEncryptedDataKey) Ctor__(materials m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials, keyStore m_AwsCryptographyKeyStoreTypes.IKeyStoreClient, cryptoPrimitives *m_AtomicPrimitives.AtomicPrimitivesClient, branchKeyId _dafny.Sequence, ttlSeconds int64, cache m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsCache, partitionIdBytes _dafny.Sequence, logicalKeyStoreNameBytes _dafny.Sequence) {
	{
		(_this)._materials = materials
		(_this)._keyStore = keyStore
		(_this)._cryptoPrimitives = cryptoPrimitives
		(_this)._branchKeyId = branchKeyId
		(_this)._ttlSeconds = ttlSeconds
		(_this)._cache = cache
		(_this)._partitionIdBytes = partitionIdBytes
		(_this)._logicalKeyStoreNameBytes = logicalKeyStoreNameBytes
	}
}
func (_this *DecryptSingleEncryptedDataKey) Invoke(edk interface{}) interface{} {
	{
		var edk m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey = edk.(m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey)
		_ = edk
		var res m_Wrappers.Result = m_Wrappers.Result{}
		_ = res
		var _0_suite m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo
		_ = _0_suite
		_0_suite = ((_this).Materials()).Dtor_algorithmSuite()
		var _1_keyProviderId _dafny.Sequence
		_ = _1_keyProviderId
		_1_keyProviderId = (edk).Dtor_keyProviderId()
		var _2_branchKeyIdUtf8 _dafny.Sequence
		_ = _2_branchKeyIdUtf8
		_2_branchKeyIdUtf8 = (edk).Dtor_keyProviderInfo()
		var _3_ciphertext _dafny.Sequence
		_ = _3_ciphertext
		_3_ciphertext = (edk).Dtor_ciphertext()
		var _4_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _4_valueOrError0
		_4_valueOrError0 = m_EdkWrapping.Companion_Default___.GetProviderWrappedMaterial(_3_ciphertext, _0_suite)
		if (_4_valueOrError0).IsFailure() {
			res = (_4_valueOrError0).PropagateFailure()
			return res
		}
		var _5_providerWrappedMaterial _dafny.Sequence
		_ = _5_providerWrappedMaterial
		_5_providerWrappedMaterial = (_4_valueOrError0).Extract().(_dafny.Sequence)
		var _6_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _6_valueOrError1
		_6_valueOrError1 = m_Wrappers.Companion_Default___.Need((uint64((_5_providerWrappedMaterial).Cardinality())) >= (uint64(Companion_Default___.EDK__CIPHERTEXT__VERSION__INDEX())), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Received EDK Ciphertext of incorrect length.")))
		if (_6_valueOrError1).IsFailure() {
			res = (_6_valueOrError1).PropagateFailure()
			return res
		}
		var _7_branchKeyVersionUuid _dafny.Sequence
		_ = _7_branchKeyVersionUuid
		_7_branchKeyVersionUuid = (_5_providerWrappedMaterial).Subsequence(uint32(Companion_Default___.EDK__CIPHERTEXT__BRANCH__KEY__VERSION__INDEX()), uint32(Companion_Default___.EDK__CIPHERTEXT__VERSION__INDEX()))
		var _8_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
		_ = _8_valueOrError2
		_8_valueOrError2 = (m_UUID.FromByteArray(_7_branchKeyVersionUuid)).MapFailure(func(coer93 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg94 interface{}) interface{} {
				return coer93(arg94.(_dafny.Sequence))
			}
		}(m_AwsKmsUtils.Companion_Default___.WrapStringToError))
		if (_8_valueOrError2).IsFailure() {
			res = (_8_valueOrError2).PropagateFailure()
			return res
		}
		var _9_version _dafny.Sequence
		_ = _9_version
		_9_version = (_8_valueOrError2).Extract().(_dafny.Sequence)
		var _10_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _10_valueOrError3
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = (_this).GetVersionCacheId(_2_branchKeyIdUtf8, _9_version, (_this).CryptoPrimitives())
		_10_valueOrError3 = _out0
		if (_10_valueOrError3).IsFailure() {
			res = (_10_valueOrError3).PropagateFailure()
			return res
		}
		var _11_cacheId _dafny.Sequence
		_ = _11_cacheId
		_11_cacheId = (_10_valueOrError3).Extract().(_dafny.Sequence)
		var _12_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyKeyStoreTypes.Companion_BranchKeyMaterials_.Default())
		_ = _12_valueOrError4
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = (_this).GetHierarchicalMaterialsVersion((_this).BranchKeyId(), _2_branchKeyIdUtf8, _9_version, _11_cacheId)
		_12_valueOrError4 = _out1
		if (_12_valueOrError4).IsFailure() {
			res = (_12_valueOrError4).PropagateFailure()
			return res
		}
		var _13_hierarchicalMaterials m_AwsCryptographyKeyStoreTypes.BranchKeyMaterials
		_ = _13_hierarchicalMaterials
		_13_hierarchicalMaterials = (_12_valueOrError4).Extract().(m_AwsCryptographyKeyStoreTypes.BranchKeyMaterials)
		var _14_branchKey _dafny.Sequence
		_ = _14_branchKey
		_14_branchKey = (_13_hierarchicalMaterials).Dtor_branchKey()
		var _15_branchKeyVersion _dafny.Sequence
		_ = _15_branchKeyVersion
		_15_branchKeyVersion = (_13_hierarchicalMaterials).Dtor_branchKeyVersion()
		var _16_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
		_ = _16_valueOrError5
		_16_valueOrError5 = (m_UTF8.Decode(_15_branchKeyVersion)).MapFailure(func(coer94 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg95 interface{}) interface{} {
				return coer94(arg95.(_dafny.Sequence))
			}
		}(m_AwsKmsUtils.Companion_Default___.WrapStringToError))
		if (_16_valueOrError5).IsFailure() {
			res = (_16_valueOrError5).PropagateFailure()
			return res
		}
		var _17_branchKeyVersionAsString _dafny.Sequence
		_ = _17_branchKeyVersionAsString
		_17_branchKeyVersionAsString = (_16_valueOrError5).Extract().(_dafny.Sequence)
		var _18_valueOrError6 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _18_valueOrError6
		_18_valueOrError6 = (m_UUID.ToByteArray(_17_branchKeyVersionAsString)).MapFailure(func(coer95 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg96 interface{}) interface{} {
				return coer95(arg96.(_dafny.Sequence))
			}
		}(m_AwsKmsUtils.Companion_Default___.WrapStringToError))
		if (_18_valueOrError6).IsFailure() {
			res = (_18_valueOrError6).PropagateFailure()
			return res
		}
		var _19_branchKeyVersionAsBytes _dafny.Sequence
		_ = _19_branchKeyVersionAsBytes
		_19_branchKeyVersionAsBytes = (_18_valueOrError6).Extract().(_dafny.Sequence)
		var _20_maybeCrypto m_Wrappers.Result
		_ = _20_maybeCrypto
		var _out2 m_Wrappers.Result
		_ = _out2
		_out2 = m_AtomicPrimitives.Companion_Default___.AtomicPrimitives(m_AtomicPrimitives.Companion_Default___.DefaultCryptoConfig())
		_20_maybeCrypto = _out2
		var _21_valueOrError7 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _21_valueOrError7
		_21_valueOrError7 = (_20_maybeCrypto).MapFailure(func(coer96 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg97 interface{}) interface{} {
				return coer96(arg97.(m_AwsCryptographyPrimitivesTypes.Error))
			}
		}(func(_22_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
			return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_22_e)
		}))
		if (_21_valueOrError7).IsFailure() {
			res = (_21_valueOrError7).PropagateFailure()
			return res
		}
		var _23_cryptoPrimitivesX m_AwsCryptographyPrimitivesTypes.IAwsCryptographicPrimitivesClient
		_ = _23_cryptoPrimitivesX
		_23_cryptoPrimitivesX = (_21_valueOrError7).Extract().(*m_AtomicPrimitives.AtomicPrimitivesClient)
		var _24_cryptoPrimitives *m_AtomicPrimitives.AtomicPrimitivesClient
		_ = _24_cryptoPrimitives
		_24_cryptoPrimitives = _23_cryptoPrimitivesX.(*m_AtomicPrimitives.AtomicPrimitivesClient)
		var _25_kmsHierarchyUnwrap *KmsHierarchyUnwrapKeyMaterial
		_ = _25_kmsHierarchyUnwrap
		var _nw0 *KmsHierarchyUnwrapKeyMaterial = New_KmsHierarchyUnwrapKeyMaterial_()
		_ = _nw0
		_nw0.Ctor__(_14_branchKey, _2_branchKeyIdUtf8, _19_branchKeyVersionAsBytes, _24_cryptoPrimitives)
		_25_kmsHierarchyUnwrap = _nw0
		var _26_unwrapOutputRes m_Wrappers.Result
		_ = _26_unwrapOutputRes
		var _out3 m_Wrappers.Result
		_ = _out3
		_out3 = m_EdkWrapping.Companion_Default___.UnwrapEdkMaterial((edk).Dtor_ciphertext(), (_this).Materials(), _25_kmsHierarchyUnwrap)
		_26_unwrapOutputRes = _out3
		var _27_valueOrError8 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_EdkWrapping.Companion_UnwrapEdkMaterialOutput_.Default(Companion_HierarchyUnwrapInfo_.Default()))
		_ = _27_valueOrError8
		_27_valueOrError8 = _26_unwrapOutputRes
		if (_27_valueOrError8).IsFailure() {
			res = (_27_valueOrError8).PropagateFailure()
			return res
		}
		var _28_unwrapOutput m_EdkWrapping.UnwrapEdkMaterialOutput
		_ = _28_unwrapOutput
		_28_unwrapOutput = (_27_valueOrError8).Extract().(m_EdkWrapping.UnwrapEdkMaterialOutput)
		var _29_valueOrError9 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _29_valueOrError9
		_29_valueOrError9 = m_Materials.Companion_Default___.DecryptionMaterialsAddDataKey((_this).Materials(), (_28_unwrapOutput).Dtor_plaintextDataKey(), (_28_unwrapOutput).Dtor_symmetricSigningKey())
		if (_29_valueOrError9).IsFailure() {
			res = (_29_valueOrError9).PropagateFailure()
			return res
		}
		var _30_result m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials
		_ = _30_result
		_30_result = (_29_valueOrError9).Extract().(m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials)
		res = m_Wrappers.Companion_Result_.Create_Success_(_30_result)
		return res
		return res
	}
}
func (_this *DecryptSingleEncryptedDataKey) GetVersionCacheId(branchKeyIdUtf8 _dafny.Sequence, branchKeyVersion _dafny.Sequence, cryptoPrimitives *m_AtomicPrimitives.AtomicPrimitivesClient) m_Wrappers.Result {
	{
		var cacheId m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = cacheId
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _0_valueOrError0
		_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((true) && (func(_pat_let7_0 m_Wrappers.Result) bool {
			return func(_1_branchKeyId m_Wrappers.Result) bool {
				return ((_1_branchKeyId).Is_Success()) && (((uint64(0)) <= (uint64(((_1_branchKeyId).Dtor_value().(_dafny.Sequence)).Cardinality()))) && ((uint64(((_1_branchKeyId).Dtor_value().(_dafny.Sequence)).Cardinality())) < ((m_StandardLibrary_UInt.Companion_Default___.UINT32__LIMIT()).Uint64())))
			}(_pat_let7_0)
		}(m_UTF8.Decode(branchKeyIdUtf8))), Companion_Default___.E(_dafny.SeqOfString("Invalid Branch Key ID Length")))
		if (_0_valueOrError0).IsFailure() {
			cacheId = (_0_valueOrError0).PropagateFailure()
			return cacheId
		}
		var _2_hashAlgorithm m_AwsCryptographyPrimitivesTypes.DigestAlgorithm
		_ = _2_hashAlgorithm
		_2_hashAlgorithm = m_AwsCryptographyPrimitivesTypes.Companion_DigestAlgorithm_.Create_SHA__384_()
		var _3_resourceId _dafny.Sequence
		_ = _3_resourceId
		_3_resourceId = m_CacheConstants.Companion_Default___.RESOURCE__ID__HIERARCHICAL__KEYRING()
		var _4_scopeId _dafny.Sequence
		_ = _4_scopeId
		_4_scopeId = m_CacheConstants.Companion_Default___.SCOPE__ID__DECRYPT()
		var _5_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _5_valueOrError1
		_5_valueOrError1 = m_Wrappers.Companion_Default___.Need(m_UTF8.Companion_Default___.IsASCIIString(branchKeyVersion), Companion_Default___.E(_dafny.SeqOfString("Unable to represent as an ASCII string.")))
		if (_5_valueOrError1).IsFailure() {
			cacheId = (_5_valueOrError1).PropagateFailure()
			return cacheId
		}
		var _6_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_UTF8.Companion_ValidUTF8Bytes_.Witness())
		_ = _6_valueOrError2
		_6_valueOrError2 = (m_UTF8.Encode(branchKeyVersion)).MapFailure(func(coer97 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg98 interface{}) interface{} {
				return coer97(arg98.(_dafny.Sequence))
			}
		}(func(_7_e _dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error {
			return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_7_e)
		}))
		if (_6_valueOrError2).IsFailure() {
			cacheId = (_6_valueOrError2).PropagateFailure()
			return cacheId
		}
		var _8_versionBytes _dafny.Sequence
		_ = _8_versionBytes
		_8_versionBytes = (_6_valueOrError2).Extract().(_dafny.Sequence)
		var _9_suffix _dafny.Sequence
		_ = _9_suffix
		_9_suffix = _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate((_this).LogicalKeyStoreNameBytes(), m_CacheConstants.Companion_Default___.NULL__BYTE()), branchKeyIdUtf8), m_CacheConstants.Companion_Default___.NULL__BYTE()), _8_versionBytes)
		var _10_identifier _dafny.Sequence
		_ = _10_identifier
		_10_identifier = _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_3_resourceId, m_CacheConstants.Companion_Default___.NULL__BYTE()), _4_scopeId), m_CacheConstants.Companion_Default___.NULL__BYTE()), (_this).PartitionIdBytes()), m_CacheConstants.Companion_Default___.NULL__BYTE()), _9_suffix)
		var _11_identifierDigestInput m_AwsCryptographyPrimitivesTypes.DigestInput
		_ = _11_identifierDigestInput
		_11_identifierDigestInput = m_AwsCryptographyPrimitivesTypes.Companion_DigestInput_.Create_DigestInput_(_2_hashAlgorithm, _10_identifier)
		var _12_maybeCacheDigest m_Wrappers.Result
		_ = _12_maybeCacheDigest
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_Digest.Companion_Default___.Digest(_11_identifierDigestInput)
		_12_maybeCacheDigest = _out0
		var _13_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _13_valueOrError3
		_13_valueOrError3 = (_12_maybeCacheDigest).MapFailure(func(coer98 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg99 interface{}) interface{} {
				return coer98(arg99.(m_AwsCryptographyPrimitivesTypes.Error))
			}
		}(func(_14_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
			return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_14_e)
		}))
		if (_13_valueOrError3).IsFailure() {
			cacheId = (_13_valueOrError3).PropagateFailure()
			return cacheId
		}
		var _15_cacheDigest _dafny.Sequence
		_ = _15_cacheDigest
		_15_cacheDigest = (_13_valueOrError3).Extract().(_dafny.Sequence)
		cacheId = m_Wrappers.Companion_Result_.Create_Success_(_15_cacheDigest)
		return cacheId
		return cacheId
	}
}
func (_this *DecryptSingleEncryptedDataKey) GetHierarchicalMaterialsVersion(branchKeyId _dafny.Sequence, branchKeyIdUtf8 _dafny.Sequence, version _dafny.Sequence, cacheId _dafny.Sequence) m_Wrappers.Result {
	{
		var material m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyKeyStoreTypes.Companion_BranchKeyMaterials_.Default())
		_ = material
		var _0_getCacheInput m_AwsCryptographyMaterialProvidersTypes.GetCacheEntryInput
		_ = _0_getCacheInput
		_0_getCacheInput = m_AwsCryptographyMaterialProvidersTypes.Companion_GetCacheEntryInput_.Create_GetCacheEntryInput_(cacheId, m_Wrappers.Companion_Option_.Create_None_())
		var _1_getCacheOutput m_Wrappers.Result
		_ = _1_getCacheOutput
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = ((_this).Cache()).GetCacheEntry(_0_getCacheInput)
		_1_getCacheOutput = _out0
		if ((_1_getCacheOutput).Is_Failure()) && (!(((_1_getCacheOutput).Dtor_error().(m_AwsCryptographyMaterialProvidersTypes.Error)).Is_EntryDoesNotExist())) {
			material = m_Wrappers.Companion_Result_.Create_Failure_((_1_getCacheOutput).Dtor_error().(m_AwsCryptographyMaterialProvidersTypes.Error))
			return material
		}
		var _2_now int64
		_ = _2_now
		var _out1 int64
		_ = _out1
		_out1 = m__Time.CurrentRelativeTime()
		_2_now = _out1
		if ((_1_getCacheOutput).Is_Failure()) || (!(Companion_Default___.CacheEntryWithinLimits(((_1_getCacheOutput).Dtor_value().(m_AwsCryptographyMaterialProvidersTypes.GetCacheEntryOutput)).Dtor_creationTime(), _2_now, (_this).TtlSeconds()))) {
			var _3_maybeGetBranchKeyVersionOutput m_Wrappers.Result
			_ = _3_maybeGetBranchKeyVersionOutput
			var _out2 m_Wrappers.Result
			_ = _out2
			_out2 = ((_this).KeyStore()).GetBranchKeyVersion(m_AwsCryptographyKeyStoreTypes.Companion_GetBranchKeyVersionInput_.Create_GetBranchKeyVersionInput_(branchKeyId, version))
			_3_maybeGetBranchKeyVersionOutput = _out2
			var _4_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyKeyStoreTypes.Companion_GetBranchKeyVersionOutput_.Default())
			_ = _4_valueOrError0
			_4_valueOrError0 = (_3_maybeGetBranchKeyVersionOutput).MapFailure(func(coer99 func(m_AwsCryptographyKeyStoreTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
				return func(arg100 interface{}) interface{} {
					return coer99(arg100.(m_AwsCryptographyKeyStoreTypes.Error))
				}
			}(func(_5_e m_AwsCryptographyKeyStoreTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
				return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyKeyStore_(_5_e)
			}))
			if (_4_valueOrError0).IsFailure() {
				material = (_4_valueOrError0).PropagateFailure()
				return material
			}
			var _6_getBranchKeyVersionOutput m_AwsCryptographyKeyStoreTypes.GetBranchKeyVersionOutput
			_ = _6_getBranchKeyVersionOutput
			_6_getBranchKeyVersionOutput = (_4_valueOrError0).Extract().(m_AwsCryptographyKeyStoreTypes.GetBranchKeyVersionOutput)
			var _7_branchKeyMaterials m_AwsCryptographyKeyStoreTypes.BranchKeyMaterials
			_ = _7_branchKeyMaterials
			_7_branchKeyMaterials = (_6_getBranchKeyVersionOutput).Dtor_branchKeyMaterials()
			var _8_now int64
			_ = _8_now
			var _out3 int64
			_ = _out3
			_out3 = m__Time.CurrentRelativeTime()
			_8_now = _out3
			var _9_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
			_ = _9_valueOrError1
			_9_valueOrError1 = m_Wrappers.Companion_Default___.Need(((_dafny.IntOfInt64(_8_now)).Plus(_dafny.IntOfInt64((_this).TtlSeconds()))).Cmp(m_StandardLibrary_UInt.Companion_Default___.INT64__MAX__LIMIT()) < 0, m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("INT64 Overflow when putting cache entry.")))
			if (_9_valueOrError1).IsFailure() {
				material = (_9_valueOrError1).PropagateFailure()
				return material
			}
			var _10_putCacheEntryInput m_AwsCryptographyMaterialProvidersTypes.PutCacheEntryInput
			_ = _10_putCacheEntryInput
			_10_putCacheEntryInput = m_AwsCryptographyMaterialProvidersTypes.Companion_PutCacheEntryInput_.Create_PutCacheEntryInput_(cacheId, m_AwsCryptographyMaterialProvidersTypes.Companion_Materials_.Create_BranchKey_(_7_branchKeyMaterials), _8_now, ((_this).TtlSeconds())+(_8_now), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
			var _11_putResult m_Wrappers.Result
			_ = _11_putResult
			var _out4 m_Wrappers.Result
			_ = _out4
			_out4 = ((_this).Cache()).PutCacheEntry(_10_putCacheEntryInput)
			_11_putResult = _out4
			if ((_11_putResult).Is_Failure()) && (!(((_11_putResult).Dtor_error().(m_AwsCryptographyMaterialProvidersTypes.Error)).Is_EntryAlreadyExists())) {
				material = m_Wrappers.Companion_Result_.Create_Failure_((_11_putResult).Dtor_error().(m_AwsCryptographyMaterialProvidersTypes.Error))
				return material
			}
			material = m_Wrappers.Companion_Result_.Create_Success_(_7_branchKeyMaterials)
			return material
		} else {
			var _12_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
			_ = _12_valueOrError2
			_12_valueOrError2 = m_Wrappers.Companion_Default___.Need((((_1_getCacheOutput).Dtor_value().(m_AwsCryptographyMaterialProvidersTypes.GetCacheEntryOutput)).Dtor_materials()).Is_BranchKey(), Companion_Default___.E(_dafny.SeqOfString("Invalid Material Type.")))
			if (_12_valueOrError2).IsFailure() {
				material = (_12_valueOrError2).PropagateFailure()
				return material
			}
			material = m_Wrappers.Companion_Result_.Create_Success_((((_1_getCacheOutput).Dtor_value().(m_AwsCryptographyMaterialProvidersTypes.GetCacheEntryOutput)).Dtor_materials()).Dtor_BranchKey())
			return material
		}
		return material
	}
}
func (_this *DecryptSingleEncryptedDataKey) Materials() m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials {
	{
		return _this._materials
	}
}
func (_this *DecryptSingleEncryptedDataKey) KeyStore() m_AwsCryptographyKeyStoreTypes.IKeyStoreClient {
	{
		return _this._keyStore
	}
}
func (_this *DecryptSingleEncryptedDataKey) CryptoPrimitives() *m_AtomicPrimitives.AtomicPrimitivesClient {
	{
		return _this._cryptoPrimitives
	}
}
func (_this *DecryptSingleEncryptedDataKey) BranchKeyId() _dafny.Sequence {
	{
		return _this._branchKeyId
	}
}
func (_this *DecryptSingleEncryptedDataKey) TtlSeconds() int64 {
	{
		return _this._ttlSeconds
	}
}
func (_this *DecryptSingleEncryptedDataKey) Cache() m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsCache {
	{
		return _this._cache
	}
}
func (_this *DecryptSingleEncryptedDataKey) PartitionIdBytes() _dafny.Sequence {
	{
		return _this._partitionIdBytes
	}
}
func (_this *DecryptSingleEncryptedDataKey) LogicalKeyStoreNameBytes() _dafny.Sequence {
	{
		return _this._logicalKeyStoreNameBytes
	}
}

// End of class DecryptSingleEncryptedDataKey

// Definition of datatype HierarchyUnwrapInfo
type HierarchyUnwrapInfo struct {
	Data_HierarchyUnwrapInfo_
}

func (_this HierarchyUnwrapInfo) Get_() Data_HierarchyUnwrapInfo_ {
	return _this.Data_HierarchyUnwrapInfo_
}

type Data_HierarchyUnwrapInfo_ interface {
	isHierarchyUnwrapInfo()
}

type CompanionStruct_HierarchyUnwrapInfo_ struct {
}

var Companion_HierarchyUnwrapInfo_ = CompanionStruct_HierarchyUnwrapInfo_{}

type HierarchyUnwrapInfo_HierarchyUnwrapInfo struct {
}

func (HierarchyUnwrapInfo_HierarchyUnwrapInfo) isHierarchyUnwrapInfo() {}

func (CompanionStruct_HierarchyUnwrapInfo_) Create_HierarchyUnwrapInfo_() HierarchyUnwrapInfo {
	return HierarchyUnwrapInfo{HierarchyUnwrapInfo_HierarchyUnwrapInfo{}}
}

func (_this HierarchyUnwrapInfo) Is_HierarchyUnwrapInfo() bool {
	_, ok := _this.Get_().(HierarchyUnwrapInfo_HierarchyUnwrapInfo)
	return ok
}

func (CompanionStruct_HierarchyUnwrapInfo_) Default() HierarchyUnwrapInfo {
	return Companion_HierarchyUnwrapInfo_.Create_HierarchyUnwrapInfo_()
}

func (_ CompanionStruct_HierarchyUnwrapInfo_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_HierarchyUnwrapInfo_.Create_HierarchyUnwrapInfo_(), true
		default:
			return HierarchyUnwrapInfo{}, false
		}
	}
}

func (_this HierarchyUnwrapInfo) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case HierarchyUnwrapInfo_HierarchyUnwrapInfo:
		{
			return "AwsKmsHierarchicalKeyring.HierarchyUnwrapInfo.HierarchyUnwrapInfo"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this HierarchyUnwrapInfo) Equals(other HierarchyUnwrapInfo) bool {
	switch _this.Get_().(type) {
	case HierarchyUnwrapInfo_HierarchyUnwrapInfo:
		{
			_, ok := other.Get_().(HierarchyUnwrapInfo_HierarchyUnwrapInfo)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this HierarchyUnwrapInfo) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(HierarchyUnwrapInfo)
	return ok && _this.Equals(typed)
}

func Type_HierarchyUnwrapInfo_() _dafny.TypeDescriptor {
	return type_HierarchyUnwrapInfo_{}
}

type type_HierarchyUnwrapInfo_ struct {
}

func (_this type_HierarchyUnwrapInfo_) Default() interface{} {
	return Companion_HierarchyUnwrapInfo_.Default()
}

func (_this type_HierarchyUnwrapInfo_) String() string {
	return "AwsKmsHierarchicalKeyring.HierarchyUnwrapInfo"
}
func (_this HierarchyUnwrapInfo) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = HierarchyUnwrapInfo{}

// End of datatype HierarchyUnwrapInfo

// Definition of datatype HierarchyWrapInfo
type HierarchyWrapInfo struct {
	Data_HierarchyWrapInfo_
}

func (_this HierarchyWrapInfo) Get_() Data_HierarchyWrapInfo_ {
	return _this.Data_HierarchyWrapInfo_
}

type Data_HierarchyWrapInfo_ interface {
	isHierarchyWrapInfo()
}

type CompanionStruct_HierarchyWrapInfo_ struct {
}

var Companion_HierarchyWrapInfo_ = CompanionStruct_HierarchyWrapInfo_{}

type HierarchyWrapInfo_HierarchyWrapInfo struct {
}

func (HierarchyWrapInfo_HierarchyWrapInfo) isHierarchyWrapInfo() {}

func (CompanionStruct_HierarchyWrapInfo_) Create_HierarchyWrapInfo_() HierarchyWrapInfo {
	return HierarchyWrapInfo{HierarchyWrapInfo_HierarchyWrapInfo{}}
}

func (_this HierarchyWrapInfo) Is_HierarchyWrapInfo() bool {
	_, ok := _this.Get_().(HierarchyWrapInfo_HierarchyWrapInfo)
	return ok
}

func (CompanionStruct_HierarchyWrapInfo_) Default() HierarchyWrapInfo {
	return Companion_HierarchyWrapInfo_.Create_HierarchyWrapInfo_()
}

func (_ CompanionStruct_HierarchyWrapInfo_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_HierarchyWrapInfo_.Create_HierarchyWrapInfo_(), true
		default:
			return HierarchyWrapInfo{}, false
		}
	}
}

func (_this HierarchyWrapInfo) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case HierarchyWrapInfo_HierarchyWrapInfo:
		{
			return "AwsKmsHierarchicalKeyring.HierarchyWrapInfo.HierarchyWrapInfo"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this HierarchyWrapInfo) Equals(other HierarchyWrapInfo) bool {
	switch _this.Get_().(type) {
	case HierarchyWrapInfo_HierarchyWrapInfo:
		{
			_, ok := other.Get_().(HierarchyWrapInfo_HierarchyWrapInfo)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this HierarchyWrapInfo) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(HierarchyWrapInfo)
	return ok && _this.Equals(typed)
}

func Type_HierarchyWrapInfo_() _dafny.TypeDescriptor {
	return type_HierarchyWrapInfo_{}
}

type type_HierarchyWrapInfo_ struct {
}

func (_this type_HierarchyWrapInfo_) Default() interface{} {
	return Companion_HierarchyWrapInfo_.Default()
}

func (_this type_HierarchyWrapInfo_) String() string {
	return "AwsKmsHierarchicalKeyring.HierarchyWrapInfo"
}
func (_this HierarchyWrapInfo) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = HierarchyWrapInfo{}

// End of datatype HierarchyWrapInfo

// Definition of class KmsHierarchyUnwrapKeyMaterial
type KmsHierarchyUnwrapKeyMaterial struct {
	_crypto                  *m_AtomicPrimitives.AtomicPrimitivesClient
	_branchKeyIdUtf8         _dafny.Sequence
	_branchKeyVersionAsBytes _dafny.Sequence
	_branchKey               _dafny.Sequence
}

func New_KmsHierarchyUnwrapKeyMaterial_() *KmsHierarchyUnwrapKeyMaterial {
	_this := KmsHierarchyUnwrapKeyMaterial{}

	_this._crypto = (*m_AtomicPrimitives.AtomicPrimitivesClient)(nil)
	_this._branchKeyIdUtf8 = m_UTF8.Companion_ValidUTF8Bytes_.Witness()
	_this._branchKeyVersionAsBytes = _dafny.EmptySeq
	_this._branchKey = _dafny.EmptySeq
	return &_this
}

type CompanionStruct_KmsHierarchyUnwrapKeyMaterial_ struct {
}

var Companion_KmsHierarchyUnwrapKeyMaterial_ = CompanionStruct_KmsHierarchyUnwrapKeyMaterial_{}

func (_this *KmsHierarchyUnwrapKeyMaterial) Equals(other *KmsHierarchyUnwrapKeyMaterial) bool {
	return _this == other
}

func (_this *KmsHierarchyUnwrapKeyMaterial) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*KmsHierarchyUnwrapKeyMaterial)
	return ok && _this.Equals(other)
}

func (*KmsHierarchyUnwrapKeyMaterial) String() string {
	return "AwsKmsHierarchicalKeyring.KmsHierarchyUnwrapKeyMaterial"
}

func Type_KmsHierarchyUnwrapKeyMaterial_() _dafny.TypeDescriptor {
	return type_KmsHierarchyUnwrapKeyMaterial_{}
}

type type_KmsHierarchyUnwrapKeyMaterial_ struct {
}

func (_this type_KmsHierarchyUnwrapKeyMaterial_) Default() interface{} {
	return (*KmsHierarchyUnwrapKeyMaterial)(nil)
}

func (_this type_KmsHierarchyUnwrapKeyMaterial_) String() string {
	return "AwsKmsHierarchicalKeyring.KmsHierarchyUnwrapKeyMaterial"
}
func (_this *KmsHierarchyUnwrapKeyMaterial) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_MaterialWrapping.Companion_UnwrapMaterial_.TraitID_, m_Actions.Companion_ActionWithResult_.TraitID_, m_Actions.Companion_Action_.TraitID_}
}

var _ m_MaterialWrapping.UnwrapMaterial = &KmsHierarchyUnwrapKeyMaterial{}
var _ m_Actions.ActionWithResult = &KmsHierarchyUnwrapKeyMaterial{}
var _ m_Actions.Action = &KmsHierarchyUnwrapKeyMaterial{}
var _ _dafny.TraitOffspring = &KmsHierarchyUnwrapKeyMaterial{}

func (_this *KmsHierarchyUnwrapKeyMaterial) Ctor__(branchKey _dafny.Sequence, branchKeyIdUtf8 _dafny.Sequence, branchKeyVersionAsBytes _dafny.Sequence, crypto *m_AtomicPrimitives.AtomicPrimitivesClient) {
	{
		(_this)._branchKey = branchKey
		(_this)._branchKeyIdUtf8 = branchKeyIdUtf8
		(_this)._branchKeyVersionAsBytes = branchKeyVersionAsBytes
		(_this)._crypto = crypto
	}
}
func (_this *KmsHierarchyUnwrapKeyMaterial) Invoke(input interface{}) interface{} {
	{
		var input m_MaterialWrapping.UnwrapInput = input.(m_MaterialWrapping.UnwrapInput)
		_ = input
		var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_MaterialWrapping.Companion_UnwrapOutput_.Default(Companion_HierarchyUnwrapInfo_.Default()))
		_ = res
		var _0_suite m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo
		_ = _0_suite
		_0_suite = (input).Dtor_algorithmSuite()
		var _1_wrappedMaterial _dafny.Sequence
		_ = _1_wrappedMaterial
		_1_wrappedMaterial = (input).Dtor_wrappedMaterial()
		var _2_aad _dafny.Map
		_ = _2_aad
		_2_aad = (input).Dtor_encryptionContext()
		var _3_KeyLength int32
		_ = _3_KeyLength
		_3_KeyLength = m_AlgorithmSuites.Companion_Default___.GetEncryptKeyLength(_0_suite)
		var _4_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _4_valueOrError0
		_4_valueOrError0 = m_Wrappers.Companion_Default___.Need((uint64((_1_wrappedMaterial).Cardinality())) == ((uint64(Companion_Default___.EXPECTED__EDK__CIPHERTEXT__OVERHEAD()))+(uint64(_3_KeyLength))), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Received EDK Ciphertext of incorrect length2.")))
		if (_4_valueOrError0).IsFailure() {
			res = (_4_valueOrError0).PropagateFailure()
			return res
		}
		var _5_salt _dafny.Sequence
		_ = _5_salt
		_5_salt = (_1_wrappedMaterial).Take(uint32(Companion_Default___.H__WRAP__SALT__LEN()))
		var _6_iv _dafny.Sequence
		_ = _6_iv
		_6_iv = (_1_wrappedMaterial).Subsequence(uint32(Companion_Default___.H__WRAP__SALT__LEN()), uint32(Companion_Default___.EDK__CIPHERTEXT__BRANCH__KEY__VERSION__INDEX()))
		var _7_branchKeyVersionUuid _dafny.Sequence
		_ = _7_branchKeyVersionUuid
		_7_branchKeyVersionUuid = (_1_wrappedMaterial).Subsequence(uint32(Companion_Default___.EDK__CIPHERTEXT__BRANCH__KEY__VERSION__INDEX()), uint32(Companion_Default___.EDK__CIPHERTEXT__VERSION__INDEX()))
		var _8_wrappedKey _dafny.Sequence
		_ = _8_wrappedKey
		_8_wrappedKey = (_1_wrappedMaterial).Subsequence(uint32(Companion_Default___.EDK__CIPHERTEXT__VERSION__INDEX()), uint32((Companion_Default___.EDK__CIPHERTEXT__VERSION__INDEX())+(_3_KeyLength)))
		var _9_authTag _dafny.Sequence
		_ = _9_authTag
		_9_authTag = (_1_wrappedMaterial).Drop(uint32((Companion_Default___.EDK__CIPHERTEXT__VERSION__INDEX()) + (_3_KeyLength)))
		var _10_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _10_valueOrError1
		_10_valueOrError1 = (input).Dtor_serializedEC()
		if (_10_valueOrError1).IsFailure() {
			res = (_10_valueOrError1).PropagateFailure()
			return res
		}
		var _11_serializedEC _dafny.Sequence
		_ = _11_serializedEC
		_11_serializedEC = (_10_valueOrError1).Extract().(_dafny.Sequence)
		var _12_wrappingAad _dafny.Sequence
		_ = _12_wrappingAad
		_12_wrappingAad = Companion_Default___.WrappingAad((_this).BranchKeyIdUtf8(), (_this).BranchKeyVersionAsBytes(), _11_serializedEC)
		var _13_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _13_valueOrError2
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = Companion_Default___.DeriveEncryptionKeyFromBranchKey((_this).BranchKey(), _5_salt, m_Wrappers.Companion_Option_.Create_Some_(m_Constants.Companion_Default___.PROVIDER__ID__HIERARCHY()), (_this).Crypto())
		_13_valueOrError2 = _out0
		if (_13_valueOrError2).IsFailure() {
			res = (_13_valueOrError2).PropagateFailure()
			return res
		}
		var _14_derivedBranchKey _dafny.Sequence
		_ = _14_derivedBranchKey
		_14_derivedBranchKey = (_13_valueOrError2).Extract().(_dafny.Sequence)
		var _15_maybeUnwrappedPdk m_Wrappers.Result
		_ = _15_maybeUnwrappedPdk
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = ((_this).Crypto()).AESDecrypt(m_AwsCryptographyPrimitivesTypes.Companion_AESDecryptInput_.Create_AESDecryptInput_(Companion_Default___.AES__256__ENC__ALG(), _14_derivedBranchKey, _8_wrappedKey, _9_authTag, _6_iv, _12_wrappingAad))
		_15_maybeUnwrappedPdk = _out1
		var _16_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _16_valueOrError3
		_16_valueOrError3 = (_15_maybeUnwrappedPdk).MapFailure(func(coer100 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg101 interface{}) interface{} {
				return coer100(arg101.(m_AwsCryptographyPrimitivesTypes.Error))
			}
		}(func(_17_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
			return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_17_e)
		}))
		if (_16_valueOrError3).IsFailure() {
			res = (_16_valueOrError3).PropagateFailure()
			return res
		}
		var _18_unwrappedPdk _dafny.Sequence
		_ = _18_unwrappedPdk
		_18_unwrappedPdk = (_16_valueOrError3).Extract().(_dafny.Sequence)
		var _19_output m_MaterialWrapping.UnwrapOutput
		_ = _19_output
		_19_output = m_MaterialWrapping.Companion_UnwrapOutput_.Create_UnwrapOutput_(_18_unwrappedPdk, Companion_HierarchyUnwrapInfo_.Create_HierarchyUnwrapInfo_())
		res = m_Wrappers.Companion_Result_.Create_Success_(_19_output)
		return res
		return res
	}
}
func (_this *KmsHierarchyUnwrapKeyMaterial) Crypto() *m_AtomicPrimitives.AtomicPrimitivesClient {
	{
		return _this._crypto
	}
}
func (_this *KmsHierarchyUnwrapKeyMaterial) BranchKeyIdUtf8() _dafny.Sequence {
	{
		return _this._branchKeyIdUtf8
	}
}
func (_this *KmsHierarchyUnwrapKeyMaterial) BranchKeyVersionAsBytes() _dafny.Sequence {
	{
		return _this._branchKeyVersionAsBytes
	}
}
func (_this *KmsHierarchyUnwrapKeyMaterial) BranchKey() _dafny.Sequence {
	{
		return _this._branchKey
	}
}

// End of class KmsHierarchyUnwrapKeyMaterial

// Definition of class KmsHierarchyGenerateAndWrapKeyMaterial
type KmsHierarchyGenerateAndWrapKeyMaterial struct {
	_branchKey               _dafny.Sequence
	_branchKeyIdUtf8         _dafny.Sequence
	_branchKeyVersionAsBytes _dafny.Sequence
	_crypto                  *m_AtomicPrimitives.AtomicPrimitivesClient
}

func New_KmsHierarchyGenerateAndWrapKeyMaterial_() *KmsHierarchyGenerateAndWrapKeyMaterial {
	_this := KmsHierarchyGenerateAndWrapKeyMaterial{}

	_this._branchKey = _dafny.EmptySeq
	_this._branchKeyIdUtf8 = m_UTF8.Companion_ValidUTF8Bytes_.Witness()
	_this._branchKeyVersionAsBytes = _dafny.EmptySeq
	_this._crypto = (*m_AtomicPrimitives.AtomicPrimitivesClient)(nil)
	return &_this
}

type CompanionStruct_KmsHierarchyGenerateAndWrapKeyMaterial_ struct {
}

var Companion_KmsHierarchyGenerateAndWrapKeyMaterial_ = CompanionStruct_KmsHierarchyGenerateAndWrapKeyMaterial_{}

func (_this *KmsHierarchyGenerateAndWrapKeyMaterial) Equals(other *KmsHierarchyGenerateAndWrapKeyMaterial) bool {
	return _this == other
}

func (_this *KmsHierarchyGenerateAndWrapKeyMaterial) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*KmsHierarchyGenerateAndWrapKeyMaterial)
	return ok && _this.Equals(other)
}

func (*KmsHierarchyGenerateAndWrapKeyMaterial) String() string {
	return "AwsKmsHierarchicalKeyring.KmsHierarchyGenerateAndWrapKeyMaterial"
}

func Type_KmsHierarchyGenerateAndWrapKeyMaterial_() _dafny.TypeDescriptor {
	return type_KmsHierarchyGenerateAndWrapKeyMaterial_{}
}

type type_KmsHierarchyGenerateAndWrapKeyMaterial_ struct {
}

func (_this type_KmsHierarchyGenerateAndWrapKeyMaterial_) Default() interface{} {
	return (*KmsHierarchyGenerateAndWrapKeyMaterial)(nil)
}

func (_this type_KmsHierarchyGenerateAndWrapKeyMaterial_) String() string {
	return "AwsKmsHierarchicalKeyring.KmsHierarchyGenerateAndWrapKeyMaterial"
}
func (_this *KmsHierarchyGenerateAndWrapKeyMaterial) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_MaterialWrapping.Companion_GenerateAndWrapMaterial_.TraitID_, m_Actions.Companion_ActionWithResult_.TraitID_, m_Actions.Companion_Action_.TraitID_}
}

var _ m_MaterialWrapping.GenerateAndWrapMaterial = &KmsHierarchyGenerateAndWrapKeyMaterial{}
var _ m_Actions.ActionWithResult = &KmsHierarchyGenerateAndWrapKeyMaterial{}
var _ m_Actions.Action = &KmsHierarchyGenerateAndWrapKeyMaterial{}
var _ _dafny.TraitOffspring = &KmsHierarchyGenerateAndWrapKeyMaterial{}

func (_this *KmsHierarchyGenerateAndWrapKeyMaterial) Ctor__(branchKey _dafny.Sequence, branchKeyIdUtf8 _dafny.Sequence, branchKeyVersionAsBytes _dafny.Sequence, crypto *m_AtomicPrimitives.AtomicPrimitivesClient) {
	{
		(_this)._branchKey = branchKey
		(_this)._branchKeyIdUtf8 = branchKeyIdUtf8
		(_this)._branchKeyVersionAsBytes = branchKeyVersionAsBytes
		(_this)._crypto = crypto
	}
}
func (_this *KmsHierarchyGenerateAndWrapKeyMaterial) Invoke(input interface{}) interface{} {
	{
		var input m_MaterialWrapping.GenerateAndWrapInput = input.(m_MaterialWrapping.GenerateAndWrapInput)
		_ = input
		var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_MaterialWrapping.Companion_GenerateAndWrapOutput_.Default(Companion_HierarchyWrapInfo_.Default()))
		_ = res
		var _0_suite m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo
		_ = _0_suite
		_0_suite = (input).Dtor_algorithmSuite()
		var _1_pdkResult m_Wrappers.Result
		_ = _1_pdkResult
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = ((_this).Crypto()).GenerateRandomBytes(m_AwsCryptographyPrimitivesTypes.Companion_GenerateRandomBytesInput_.Create_GenerateRandomBytesInput_(m_AlgorithmSuites.Companion_Default___.GetEncryptKeyLength(_0_suite)))
		_1_pdkResult = _out0
		var _2_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _2_valueOrError0
		_2_valueOrError0 = (_1_pdkResult).MapFailure(func(coer101 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg102 interface{}) interface{} {
				return coer101(arg102.(m_AwsCryptographyPrimitivesTypes.Error))
			}
		}(func(_3_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
			return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_3_e)
		}))
		if (_2_valueOrError0).IsFailure() {
			res = (_2_valueOrError0).PropagateFailure()
			return res
		}
		var _4_pdk _dafny.Sequence
		_ = _4_pdk
		_4_pdk = (_2_valueOrError0).Extract().(_dafny.Sequence)
		var _5_wrap *KmsHierarchyWrapKeyMaterial
		_ = _5_wrap
		var _nw0 *KmsHierarchyWrapKeyMaterial = New_KmsHierarchyWrapKeyMaterial_()
		_ = _nw0
		_nw0.Ctor__((_this).BranchKey(), (_this).BranchKeyIdUtf8(), (_this).BranchKeyVersionAsBytes(), (_this).Crypto())
		_5_wrap = _nw0
		var _6_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_MaterialWrapping.Companion_WrapOutput_.Default(Companion_HierarchyWrapInfo_.Default()))
		_ = _6_valueOrError1
		var _out1 interface{}
		_ = _out1
		_out1 = (_5_wrap).Invoke(m_MaterialWrapping.Companion_WrapInput_.Create_WrapInput_(_4_pdk, (input).Dtor_algorithmSuite(), (input).Dtor_encryptionContext(), (input).Dtor_serializedEC()))
		_6_valueOrError1 = _out1.(m_Wrappers.Result)
		if (_6_valueOrError1).IsFailure() {
			res = (_6_valueOrError1).PropagateFailure()
			return res
		}
		var _7_wrapOutput m_MaterialWrapping.WrapOutput
		_ = _7_wrapOutput
		_7_wrapOutput = (_6_valueOrError1).Extract().(m_MaterialWrapping.WrapOutput)
		var _8_output m_MaterialWrapping.GenerateAndWrapOutput
		_ = _8_output
		_8_output = m_MaterialWrapping.Companion_GenerateAndWrapOutput_.Create_GenerateAndWrapOutput_(_4_pdk, (_7_wrapOutput).Dtor_wrappedMaterial(), Companion_HierarchyWrapInfo_.Create_HierarchyWrapInfo_())
		res = m_Wrappers.Companion_Result_.Create_Success_(_8_output)
		return res
		return res
	}
}
func (_this *KmsHierarchyGenerateAndWrapKeyMaterial) BranchKey() _dafny.Sequence {
	{
		return _this._branchKey
	}
}
func (_this *KmsHierarchyGenerateAndWrapKeyMaterial) BranchKeyIdUtf8() _dafny.Sequence {
	{
		return _this._branchKeyIdUtf8
	}
}
func (_this *KmsHierarchyGenerateAndWrapKeyMaterial) BranchKeyVersionAsBytes() _dafny.Sequence {
	{
		return _this._branchKeyVersionAsBytes
	}
}
func (_this *KmsHierarchyGenerateAndWrapKeyMaterial) Crypto() *m_AtomicPrimitives.AtomicPrimitivesClient {
	{
		return _this._crypto
	}
}

// End of class KmsHierarchyGenerateAndWrapKeyMaterial

// Definition of class KmsHierarchyWrapKeyMaterial
type KmsHierarchyWrapKeyMaterial struct {
	_branchKey               _dafny.Sequence
	_branchKeyIdUtf8         _dafny.Sequence
	_branchKeyVersionAsBytes _dafny.Sequence
	_crypto                  *m_AtomicPrimitives.AtomicPrimitivesClient
}

func New_KmsHierarchyWrapKeyMaterial_() *KmsHierarchyWrapKeyMaterial {
	_this := KmsHierarchyWrapKeyMaterial{}

	_this._branchKey = _dafny.EmptySeq
	_this._branchKeyIdUtf8 = m_UTF8.Companion_ValidUTF8Bytes_.Witness()
	_this._branchKeyVersionAsBytes = _dafny.EmptySeq
	_this._crypto = (*m_AtomicPrimitives.AtomicPrimitivesClient)(nil)
	return &_this
}

type CompanionStruct_KmsHierarchyWrapKeyMaterial_ struct {
}

var Companion_KmsHierarchyWrapKeyMaterial_ = CompanionStruct_KmsHierarchyWrapKeyMaterial_{}

func (_this *KmsHierarchyWrapKeyMaterial) Equals(other *KmsHierarchyWrapKeyMaterial) bool {
	return _this == other
}

func (_this *KmsHierarchyWrapKeyMaterial) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*KmsHierarchyWrapKeyMaterial)
	return ok && _this.Equals(other)
}

func (*KmsHierarchyWrapKeyMaterial) String() string {
	return "AwsKmsHierarchicalKeyring.KmsHierarchyWrapKeyMaterial"
}

func Type_KmsHierarchyWrapKeyMaterial_() _dafny.TypeDescriptor {
	return type_KmsHierarchyWrapKeyMaterial_{}
}

type type_KmsHierarchyWrapKeyMaterial_ struct {
}

func (_this type_KmsHierarchyWrapKeyMaterial_) Default() interface{} {
	return (*KmsHierarchyWrapKeyMaterial)(nil)
}

func (_this type_KmsHierarchyWrapKeyMaterial_) String() string {
	return "AwsKmsHierarchicalKeyring.KmsHierarchyWrapKeyMaterial"
}
func (_this *KmsHierarchyWrapKeyMaterial) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_MaterialWrapping.Companion_WrapMaterial_.TraitID_, m_Actions.Companion_ActionWithResult_.TraitID_, m_Actions.Companion_Action_.TraitID_}
}

var _ m_MaterialWrapping.WrapMaterial = &KmsHierarchyWrapKeyMaterial{}
var _ m_Actions.ActionWithResult = &KmsHierarchyWrapKeyMaterial{}
var _ m_Actions.Action = &KmsHierarchyWrapKeyMaterial{}
var _ _dafny.TraitOffspring = &KmsHierarchyWrapKeyMaterial{}

func (_this *KmsHierarchyWrapKeyMaterial) Ctor__(branchKey _dafny.Sequence, branchKeyIdUtf8 _dafny.Sequence, branchKeyVersionAsBytes _dafny.Sequence, crypto *m_AtomicPrimitives.AtomicPrimitivesClient) {
	{
		(_this)._branchKey = branchKey
		(_this)._branchKeyIdUtf8 = branchKeyIdUtf8
		(_this)._branchKeyVersionAsBytes = branchKeyVersionAsBytes
		(_this)._crypto = crypto
	}
}
func (_this *KmsHierarchyWrapKeyMaterial) Invoke(input interface{}) interface{} {
	{
		var input m_MaterialWrapping.WrapInput = input.(m_MaterialWrapping.WrapInput)
		_ = input
		var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_MaterialWrapping.Companion_WrapOutput_.Default(Companion_HierarchyWrapInfo_.Default()))
		_ = res
		var _0_suite m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo
		_ = _0_suite
		_0_suite = (input).Dtor_algorithmSuite()
		var _1_maybeNonceSalt m_Wrappers.Result
		_ = _1_maybeNonceSalt
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = ((_this).Crypto()).GenerateRandomBytes(m_AwsCryptographyPrimitivesTypes.Companion_GenerateRandomBytesInput_.Create_GenerateRandomBytesInput_((Companion_Default___.H__WRAP__SALT__LEN()) + (Companion_Default___.H__WRAP__NONCE__LEN())))
		_1_maybeNonceSalt = _out0
		var _2_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _2_valueOrError0
		_2_valueOrError0 = (_1_maybeNonceSalt).MapFailure(func(coer102 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg103 interface{}) interface{} {
				return coer102(arg103.(m_AwsCryptographyPrimitivesTypes.Error))
			}
		}(func(_3_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
			return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_3_e)
		}))
		if (_2_valueOrError0).IsFailure() {
			res = (_2_valueOrError0).PropagateFailure()
			return res
		}
		var _4_saltAndNonce _dafny.Sequence
		_ = _4_saltAndNonce
		_4_saltAndNonce = (_2_valueOrError0).Extract().(_dafny.Sequence)
		var _5_salt _dafny.Sequence
		_ = _5_salt
		_5_salt = (_4_saltAndNonce).Take(uint32(Companion_Default___.H__WRAP__SALT__LEN()))
		var _6_nonce _dafny.Sequence
		_ = _6_nonce
		_6_nonce = (_4_saltAndNonce).Drop(uint32(Companion_Default___.H__WRAP__SALT__LEN()))
		var _7_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _7_valueOrError1
		_7_valueOrError1 = (input).Dtor_serializedEC()
		if (_7_valueOrError1).IsFailure() {
			res = (_7_valueOrError1).PropagateFailure()
			return res
		}
		var _8_serializedEC _dafny.Sequence
		_ = _8_serializedEC
		_8_serializedEC = (_7_valueOrError1).Extract().(_dafny.Sequence)
		var _9_wrappingAad _dafny.Sequence
		_ = _9_wrappingAad
		_9_wrappingAad = Companion_Default___.WrappingAad((_this).BranchKeyIdUtf8(), (_this).BranchKeyVersionAsBytes(), _8_serializedEC)
		var _10_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _10_valueOrError2
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = Companion_Default___.DeriveEncryptionKeyFromBranchKey((_this).BranchKey(), _5_salt, m_Wrappers.Companion_Option_.Create_Some_(m_Constants.Companion_Default___.PROVIDER__ID__HIERARCHY()), (_this).Crypto())
		_10_valueOrError2 = _out1
		if (_10_valueOrError2).IsFailure() {
			res = (_10_valueOrError2).PropagateFailure()
			return res
		}
		var _11_derivedBranchKey _dafny.Sequence
		_ = _11_derivedBranchKey
		_11_derivedBranchKey = (_10_valueOrError2).Extract().(_dafny.Sequence)
		var _12_maybeWrappedPdk m_Wrappers.Result
		_ = _12_maybeWrappedPdk
		var _out2 m_Wrappers.Result
		_ = _out2
		_out2 = ((_this).Crypto()).AESEncrypt(m_AwsCryptographyPrimitivesTypes.Companion_AESEncryptInput_.Create_AESEncryptInput_(Companion_Default___.AES__256__ENC__ALG(), _6_nonce, _11_derivedBranchKey, (input).Dtor_plaintextMaterial(), _9_wrappingAad))
		_12_maybeWrappedPdk = _out2
		var _13_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_AESEncryptOutput_.Default())
		_ = _13_valueOrError3
		_13_valueOrError3 = (_12_maybeWrappedPdk).MapFailure(func(coer103 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg104 interface{}) interface{} {
				return coer103(arg104.(m_AwsCryptographyPrimitivesTypes.Error))
			}
		}(func(_14_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
			return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_14_e)
		}))
		if (_13_valueOrError3).IsFailure() {
			res = (_13_valueOrError3).PropagateFailure()
			return res
		}
		var _15_wrappedPdk m_AwsCryptographyPrimitivesTypes.AESEncryptOutput
		_ = _15_wrappedPdk
		_15_wrappedPdk = (_13_valueOrError3).Extract().(m_AwsCryptographyPrimitivesTypes.AESEncryptOutput)
		var _16_output m_MaterialWrapping.WrapOutput
		_ = _16_output
		_16_output = m_MaterialWrapping.Companion_WrapOutput_.Create_WrapOutput_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_5_salt, _6_nonce), (_this).BranchKeyVersionAsBytes()), (_15_wrappedPdk).Dtor_cipherText()), (_15_wrappedPdk).Dtor_authTag()), Companion_HierarchyWrapInfo_.Create_HierarchyWrapInfo_())
		res = m_Wrappers.Companion_Result_.Create_Success_(_16_output)
		return res
		return res
	}
}
func (_this *KmsHierarchyWrapKeyMaterial) BranchKey() _dafny.Sequence {
	{
		return _this._branchKey
	}
}
func (_this *KmsHierarchyWrapKeyMaterial) BranchKeyIdUtf8() _dafny.Sequence {
	{
		return _this._branchKeyIdUtf8
	}
}
func (_this *KmsHierarchyWrapKeyMaterial) BranchKeyVersionAsBytes() _dafny.Sequence {
	{
		return _this._branchKeyVersionAsBytes
	}
}
func (_this *KmsHierarchyWrapKeyMaterial) Crypto() *m_AtomicPrimitives.AtomicPrimitivesClient {
	{
		return _this._crypto
	}
}

// End of class KmsHierarchyWrapKeyMaterial
