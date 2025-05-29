// Package AwsKmsRsaKeyring
// Dafny module AwsKmsRsaKeyring compiled into Go

package AwsKmsRsaKeyring

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
	m_AwsKmsHierarchicalKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsHierarchicalKeyring"
	m_AwsKmsKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsKeyring"
	m_AwsKmsMrkDiscoveryKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkDiscoveryKeyring"
	m_AwsKmsMrkKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkKeyring"
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
	m_UTF8 "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/UTF8"
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
var _ m_AwsKmsHierarchicalKeyring.Dummy__
var _ m_AwsKmsMrkDiscoveryKeyring.Dummy__
var _ m_AwsKmsMrkKeyring.Dummy__

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
	return "AwsKmsRsaKeyring.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) EncryptionContextDigest(cryptoPrimitives *m_AtomicPrimitives.AtomicPrimitivesClient, encryptionContext _dafny.Map) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = output
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _0_valueOrError0
	_0_valueOrError0 = m_CanonicalEncryptionContext.Companion_Default___.EncryptionContextToAAD(encryptionContext)
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_canonicalEC _dafny.Sequence
	_ = _1_canonicalEC
	_1_canonicalEC = (_0_valueOrError0).Extract().(_dafny.Sequence)
	var _2_DigestInput m_AwsCryptographyPrimitivesTypes.DigestInput
	_ = _2_DigestInput
	_2_DigestInput = m_AwsCryptographyPrimitivesTypes.Companion_DigestInput_.Create_DigestInput_(m_AwsCryptographyPrimitivesTypes.Companion_DigestAlgorithm_.Create_SHA__384_(), _1_canonicalEC)
	var _3_maybeDigest m_Wrappers.Result
	_ = _3_maybeDigest
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = (cryptoPrimitives).Digest(_2_DigestInput)
	_3_maybeDigest = _out0
	var _4_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _4_valueOrError1
	_4_valueOrError1 = (_3_maybeDigest).MapFailure(func(coer108 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
		return func(arg109 interface{}) interface{} {
			return coer108(arg109.(m_AwsCryptographyPrimitivesTypes.Error))
		}
	}(func(_5_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
		return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_5_e)
	}))
	if (_4_valueOrError1).IsFailure() {
		output = (_4_valueOrError1).PropagateFailure()
		return output
	}
	var _6_digest _dafny.Sequence
	_ = _6_digest
	_6_digest = (_4_valueOrError1).Extract().(_dafny.Sequence)
	output = m_Wrappers.Companion_Result_.Create_Success_(_6_digest)
	return output
	return output
}
func (_static *CompanionStruct_Default___) MIN__KMS__RSA__KEY__LEN() int32 {
	return int32(2048)
}

// End of class Default__

// Definition of class AwsKmsRsaKeyring
type AwsKmsRsaKeyring struct {
	_cryptoPrimitives *m_AtomicPrimitives.AtomicPrimitivesClient
	_client           m_Wrappers.Option
	_paddingScheme    m_ComAmazonawsKmsTypes.EncryptionAlgorithmSpec
	_awsKmsKey        _dafny.Sequence
	_publicKey        m_Wrappers.Option
	_awsKmsArn        m_AwsArnParsing.AwsKmsIdentifier
	_grantTokens      _dafny.Sequence
}

func New_AwsKmsRsaKeyring_() *AwsKmsRsaKeyring {
	_this := AwsKmsRsaKeyring{}

	_this._cryptoPrimitives = (*m_AtomicPrimitives.AtomicPrimitivesClient)(nil)
	_this._client = m_Wrappers.Companion_Option_.Default()
	_this._paddingScheme = m_ComAmazonawsKmsTypes.Companion_EncryptionAlgorithmSpec_.Default()
	_this._awsKmsKey = _dafny.EmptySeq.SetString()
	_this._publicKey = m_Wrappers.Companion_Option_.Default()
	_this._awsKmsArn = m_AwsArnParsing.AwsKmsIdentifier{}
	_this._grantTokens = _dafny.EmptySeq
	return &_this
}

type CompanionStruct_AwsKmsRsaKeyring_ struct {
}

var Companion_AwsKmsRsaKeyring_ = CompanionStruct_AwsKmsRsaKeyring_{}

func (_this *AwsKmsRsaKeyring) Equals(other *AwsKmsRsaKeyring) bool {
	return _this == other
}

func (_this *AwsKmsRsaKeyring) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*AwsKmsRsaKeyring)
	return ok && _this.Equals(other)
}

func (*AwsKmsRsaKeyring) String() string {
	return "AwsKmsRsaKeyring.AwsKmsRsaKeyring"
}

func Type_AwsKmsRsaKeyring_() _dafny.TypeDescriptor {
	return type_AwsKmsRsaKeyring_{}
}

type type_AwsKmsRsaKeyring_ struct {
}

func (_this type_AwsKmsRsaKeyring_) Default() interface{} {
	return (*AwsKmsRsaKeyring)(nil)
}

func (_this type_AwsKmsRsaKeyring_) String() string {
	return "AwsKmsRsaKeyring.AwsKmsRsaKeyring"
}
func (_this *AwsKmsRsaKeyring) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_Keyring.Companion_VerifiableInterface_.TraitID_, m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.TraitID_}
}

var _ m_Keyring.VerifiableInterface = &AwsKmsRsaKeyring{}
var _ m_AwsCryptographyMaterialProvidersTypes.IKeyring = &AwsKmsRsaKeyring{}
var _ _dafny.TraitOffspring = &AwsKmsRsaKeyring{}

func (_this *AwsKmsRsaKeyring) OnDecrypt(input m_AwsCryptographyMaterialProvidersTypes.OnDecryptInput) m_Wrappers.Result {
	var _out10 m_Wrappers.Result
	_ = _out10
	_out10 = m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.OnDecrypt(_this, input)
	return _out10
}
func (_this *AwsKmsRsaKeyring) OnEncrypt(input m_AwsCryptographyMaterialProvidersTypes.OnEncryptInput) m_Wrappers.Result {
	var _out10 m_Wrappers.Result
	_ = _out10
	_out10 = m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.OnEncrypt(_this, input)
	return _out10
}
func (_this *AwsKmsRsaKeyring) Ctor__(publicKey m_Wrappers.Option, awsKmsKey _dafny.Sequence, paddingScheme m_ComAmazonawsKmsTypes.EncryptionAlgorithmSpec, client m_Wrappers.Option, cryptoPrimitives *m_AtomicPrimitives.AtomicPrimitivesClient, grantTokens _dafny.Sequence) {
	{
		var _0_parsedAwsKmsId m_Wrappers.Result
		_ = _0_parsedAwsKmsId
		_0_parsedAwsKmsId = m_AwsArnParsing.Companion_Default___.ParseAwsKmsIdentifier(awsKmsKey)
		(_this)._publicKey = publicKey
		(_this)._awsKmsKey = awsKmsKey
		(_this)._awsKmsArn = (_0_parsedAwsKmsId).Dtor_value().(m_AwsArnParsing.AwsKmsIdentifier)
		(_this)._paddingScheme = paddingScheme
		(_this)._client = client
		(_this)._cryptoPrimitives = cryptoPrimitives
		(_this)._grantTokens = grantTokens
	}
}
func (_this *AwsKmsRsaKeyring) OnEncrypt_k(input m_AwsCryptographyMaterialProvidersTypes.OnEncryptInput) m_Wrappers.Result {
	{
		var res m_Wrappers.Result = m_Wrappers.Result{}
		_ = res
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _0_valueOrError0
		_0_valueOrError0 = m_Wrappers.Companion_Default___.Need((((_this).PublicKey()).Is_Some()) && ((uint64((((_this).PublicKey()).Extract().(_dafny.Sequence)).Cardinality())) > (uint64(0))), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("A AwsKmsRsaKeyring without a public key cannot provide OnEncrypt")))
		if (_0_valueOrError0).IsFailure() {
			res = (_0_valueOrError0).PropagateFailure()
			return res
		}
		var _1_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _1_valueOrError1
		_1_valueOrError1 = m_Wrappers.Companion_Default___.Need(((((input).Dtor_materials()).Dtor_algorithmSuite()).Dtor_signature()).Is_None(), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("AwsKmsRsaKeyring cannot be used with an Algorithm Suite with asymmetric signing."), _dafny.SeqOfString(" Please specify an algorithm suite without asymmetric signing."))))
		if (_1_valueOrError1).IsFailure() {
			res = (_1_valueOrError1).PropagateFailure()
			return res
		}
		var _2_wrap *KmsRsaWrapKeyMaterial
		_ = _2_wrap
		var _nw0 *KmsRsaWrapKeyMaterial = New_KmsRsaWrapKeyMaterial_()
		_ = _nw0
		_nw0.Ctor__(((_this).PublicKey()).Dtor_value().(_dafny.Sequence), (_this).PaddingScheme(), (_this).CryptoPrimitives())
		_2_wrap = _nw0
		var _3_generateAndWrap *KmsRsaGenerateAndWrapKeyMaterial
		_ = _3_generateAndWrap
		var _nw1 *KmsRsaGenerateAndWrapKeyMaterial = New_KmsRsaGenerateAndWrapKeyMaterial_()
		_ = _nw1
		_nw1.Ctor__(((_this).PublicKey()).Dtor_value().(_dafny.Sequence), (_this).PaddingScheme(), (_this).CryptoPrimitives())
		_3_generateAndWrap = _nw1
		var _4_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_EdkWrapping.Companion_WrapEdkMaterialOutput_.Default(Companion_KmsRsaWrapInfo_.Default()))
		_ = _4_valueOrError2
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_EdkWrapping.Companion_Default___.WrapEdkMaterial((input).Dtor_materials(), _2_wrap, _3_generateAndWrap)
		_4_valueOrError2 = _out0
		if (_4_valueOrError2).IsFailure() {
			res = (_4_valueOrError2).PropagateFailure()
			return res
		}
		var _5_wrapOutput m_EdkWrapping.WrapEdkMaterialOutput
		_ = _5_wrapOutput
		_5_wrapOutput = (_4_valueOrError2).Extract().(m_EdkWrapping.WrapEdkMaterialOutput)
		var _6_symmetricSigningKeyList m_Wrappers.Option
		_ = _6_symmetricSigningKeyList
		if ((_5_wrapOutput).Dtor_symmetricSigningKey()).Is_Some() {
			_6_symmetricSigningKeyList = m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(((_5_wrapOutput).Dtor_symmetricSigningKey()).Dtor_value().(_dafny.Sequence)))
		} else {
			_6_symmetricSigningKeyList = m_Wrappers.Companion_Option_.Create_None_()
		}
		var _7_edk m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey
		_ = _7_edk
		_7_edk = m_AwsCryptographyMaterialProvidersTypes.Companion_EncryptedDataKey_.Create_EncryptedDataKey_(m_Constants.Companion_Default___.RSA__PROVIDER__ID(), (m_UTF8.Encode((_this).AwsKmsKey())).Dtor_value().(_dafny.Sequence), (_5_wrapOutput).Dtor_wrappedMaterial())
		var _8_returnMaterials m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials = m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials{}
		_ = _8_returnMaterials
		if (_5_wrapOutput).Is_GenerateAndWrapEdkMaterialOutput() {
			var _9_valueOrError3 m_Wrappers.Result = m_Wrappers.Result{}
			_ = _9_valueOrError3
			_9_valueOrError3 = m_Materials.Companion_Default___.EncryptionMaterialAddDataKey((input).Dtor_materials(), (_5_wrapOutput).Dtor_plaintextDataKey(), _dafny.SeqOf(_7_edk), _6_symmetricSigningKeyList)
			if (_9_valueOrError3).IsFailure() {
				res = (_9_valueOrError3).PropagateFailure()
				return res
			}
			_8_returnMaterials = (_9_valueOrError3).Extract().(m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials)
		} else if (_5_wrapOutput).Is_WrapOnlyEdkMaterialOutput() {
			var _10_valueOrError4 m_Wrappers.Result = m_Wrappers.Result{}
			_ = _10_valueOrError4
			_10_valueOrError4 = m_Materials.Companion_Default___.EncryptionMaterialAddEncryptedDataKeys((input).Dtor_materials(), _dafny.SeqOf(_7_edk), _6_symmetricSigningKeyList)
			if (_10_valueOrError4).IsFailure() {
				res = (_10_valueOrError4).PropagateFailure()
				return res
			}
			_8_returnMaterials = (_10_valueOrError4).Extract().(m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials)
		}
		res = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyMaterialProvidersTypes.Companion_OnEncryptOutput_.Create_OnEncryptOutput_(_8_returnMaterials))
		return res
		return res
	}
}
func (_this *AwsKmsRsaKeyring) OnDecrypt_k(input m_AwsCryptographyMaterialProvidersTypes.OnDecryptInput) m_Wrappers.Result {
	{
		var res m_Wrappers.Result = m_Wrappers.Result{}
		_ = res
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _0_valueOrError0
		_0_valueOrError0 = m_Wrappers.Companion_Default___.Need(((_this).Client()).Is_Some(), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("An AwsKmsRsaKeyring without an AWS KMS client cannot provide OnDecrypt")))
		if (_0_valueOrError0).IsFailure() {
			res = (_0_valueOrError0).PropagateFailure()
			return res
		}
		var _1_materials m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials
		_ = _1_materials
		_1_materials = (input).Dtor_materials()
		var _2_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _2_valueOrError1
		_2_valueOrError1 = m_Wrappers.Companion_Default___.Need(m_Materials.Companion_Default___.DecryptionMaterialsWithoutPlaintextDataKey(_1_materials), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Keyring received decryption materials that already contain a plaintext data key.")))
		if (_2_valueOrError1).IsFailure() {
			res = (_2_valueOrError1).PropagateFailure()
			return res
		}
		var _3_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _3_valueOrError2
		_3_valueOrError2 = m_AwsKmsUtils.Companion_Default___.OkForDecrypt((_this).AwsKmsArn(), (_this).AwsKmsKey())
		if (_3_valueOrError2).IsFailure() {
			res = (_3_valueOrError2).PropagateFailure()
			return res
		}
		var _4_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _4_valueOrError3
		_4_valueOrError3 = m_Wrappers.Companion_Default___.Need(((((input).Dtor_materials()).Dtor_algorithmSuite()).Dtor_signature()).Is_None(), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.Companion_Sequence_.Concatenate(_dafny.SeqOfString("AwsKmsRsaKeyring cannot be used with an Algorithm Suite with asymmetric signing."), _dafny.SeqOfString(" Please specify an algorithm suite without asymmetric signing."))))
		if (_4_valueOrError3).IsFailure() {
			res = (_4_valueOrError3).PropagateFailure()
			return res
		}
		var _5_filter *m_AwsKmsUtils.OnDecryptMrkAwareEncryptedDataKeyFilter
		_ = _5_filter
		var _nw0 *m_AwsKmsUtils.OnDecryptMrkAwareEncryptedDataKeyFilter = m_AwsKmsUtils.New_OnDecryptMrkAwareEncryptedDataKeyFilter_()
		_ = _nw0
		_nw0.Ctor__((_this).AwsKmsArn(), m_Constants.Companion_Default___.RSA__PROVIDER__ID())
		_5_filter = _nw0
		var _6_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _6_valueOrError4
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_Actions.Companion_Default___.FilterWithResult(_5_filter, (input).Dtor_encryptedDataKeys())
		_6_valueOrError4 = _out0
		if (_6_valueOrError4).IsFailure() {
			res = (_6_valueOrError4).PropagateFailure()
			return res
		}
		var _7_edksToAttempt _dafny.Sequence
		_ = _7_edksToAttempt
		_7_edksToAttempt = (_6_valueOrError4).Extract().(_dafny.Sequence)
		if (uint64(0)) == (uint64((_7_edksToAttempt).Cardinality())) {
			var _8_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
			_ = _8_valueOrError5
			_8_valueOrError5 = m_ErrorMessages.Companion_Default___.IncorrectDataKeys((input).Dtor_encryptedDataKeys(), ((input).Dtor_materials()).Dtor_algorithmSuite(), _dafny.SeqOfString(""))
			if (_8_valueOrError5).IsFailure() {
				res = (_8_valueOrError5).PropagateFailure()
				return res
			}
			var _9_errorMessage _dafny.Sequence
			_ = _9_errorMessage
			_9_errorMessage = (_8_valueOrError5).Extract().(_dafny.Sequence)
			res = m_Wrappers.Companion_Result_.Create_Failure_(m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_9_errorMessage))
			return res
		}
		var _10_valueOrError6 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _10_valueOrError6
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = Companion_Default___.EncryptionContextDigest((_this).CryptoPrimitives(), (_1_materials).Dtor_encryptionContext())
		_10_valueOrError6 = _out1
		if (_10_valueOrError6).IsFailure() {
			res = (_10_valueOrError6).PropagateFailure()
			return res
		}
		var _11_encryptionContextDigest _dafny.Sequence
		_ = _11_encryptionContextDigest
		_11_encryptionContextDigest = (_10_valueOrError6).Extract().(_dafny.Sequence)
		var _12_decryptClosure m_Actions.ActionWithResult
		_ = _12_decryptClosure
		var _nw1 *DecryptSingleAWSRSAEncryptedDataKey = New_DecryptSingleAWSRSAEncryptedDataKey_()
		_ = _nw1
		_nw1.Ctor__(_1_materials, m_ComAmazonawsKmsTypes.Companion_IKMSClient_.CastTo_(((_this).Client()).Dtor_value()), (_this).AwsKmsKey(), (_this).PaddingScheme(), _11_encryptionContextDigest, (_this).GrantTokens())
		_12_decryptClosure = _nw1
		var _13_outcome m_Wrappers.Result
		_ = _13_outcome
		var _out2 m_Wrappers.Result
		_ = _out2
		_out2 = m_Actions.Companion_Default___.ReduceToSuccess(_12_decryptClosure, _7_edksToAttempt)
		_13_outcome = _out2
		var _14_valueOrError7 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _14_valueOrError7
		_14_valueOrError7 = (_13_outcome).MapFailure(func(coer109 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg110 interface{}) interface{} {
				return coer109(arg110.(_dafny.Sequence))
			}
		}(func(_15_errors _dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error {
			return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_CollectionOfErrors_(_15_errors, _dafny.SeqOfString("No Configured KMS Key was able to decrypt the Data Key. The list of encountered Exceptions is available via `list`."))
		}))
		if (_14_valueOrError7).IsFailure() {
			res = (_14_valueOrError7).PropagateFailure()
			return res
		}
		var _16_SealedDecryptionMaterials m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials
		_ = _16_SealedDecryptionMaterials
		_16_SealedDecryptionMaterials = (_14_valueOrError7).Extract().(m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials)
		res = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyMaterialProvidersTypes.Companion_OnDecryptOutput_.Create_OnDecryptOutput_(_16_SealedDecryptionMaterials))
		return res
		return res
	}
}
func (_this *AwsKmsRsaKeyring) CryptoPrimitives() *m_AtomicPrimitives.AtomicPrimitivesClient {
	{
		return _this._cryptoPrimitives
	}
}
func (_this *AwsKmsRsaKeyring) Client() m_Wrappers.Option {
	{
		return _this._client
	}
}
func (_this *AwsKmsRsaKeyring) PaddingScheme() m_ComAmazonawsKmsTypes.EncryptionAlgorithmSpec {
	{
		return _this._paddingScheme
	}
}
func (_this *AwsKmsRsaKeyring) AwsKmsKey() _dafny.Sequence {
	{
		return _this._awsKmsKey
	}
}
func (_this *AwsKmsRsaKeyring) PublicKey() m_Wrappers.Option {
	{
		return _this._publicKey
	}
}
func (_this *AwsKmsRsaKeyring) AwsKmsArn() m_AwsArnParsing.AwsKmsIdentifier {
	{
		return _this._awsKmsArn
	}
}
func (_this *AwsKmsRsaKeyring) GrantTokens() _dafny.Sequence {
	{
		return _this._grantTokens
	}
}

// End of class AwsKmsRsaKeyring

// Definition of class DecryptSingleAWSRSAEncryptedDataKey
type DecryptSingleAWSRSAEncryptedDataKey struct {
	_materials               m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials
	_client                  m_ComAmazonawsKmsTypes.IKMSClient
	_awsKmsKey               _dafny.Sequence
	_paddingScheme           m_ComAmazonawsKmsTypes.EncryptionAlgorithmSpec
	_encryptionContextDigest _dafny.Sequence
	_grantTokens             _dafny.Sequence
}

func New_DecryptSingleAWSRSAEncryptedDataKey_() *DecryptSingleAWSRSAEncryptedDataKey {
	_this := DecryptSingleAWSRSAEncryptedDataKey{}

	_this._materials = m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials{}
	_this._client = (m_ComAmazonawsKmsTypes.IKMSClient)(nil)
	_this._awsKmsKey = _dafny.EmptySeq.SetString()
	_this._paddingScheme = m_ComAmazonawsKmsTypes.Companion_EncryptionAlgorithmSpec_.Default()
	_this._encryptionContextDigest = _dafny.EmptySeq
	_this._grantTokens = _dafny.EmptySeq
	return &_this
}

type CompanionStruct_DecryptSingleAWSRSAEncryptedDataKey_ struct {
}

var Companion_DecryptSingleAWSRSAEncryptedDataKey_ = CompanionStruct_DecryptSingleAWSRSAEncryptedDataKey_{}

func (_this *DecryptSingleAWSRSAEncryptedDataKey) Equals(other *DecryptSingleAWSRSAEncryptedDataKey) bool {
	return _this == other
}

func (_this *DecryptSingleAWSRSAEncryptedDataKey) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*DecryptSingleAWSRSAEncryptedDataKey)
	return ok && _this.Equals(other)
}

func (*DecryptSingleAWSRSAEncryptedDataKey) String() string {
	return "AwsKmsRsaKeyring.DecryptSingleAWSRSAEncryptedDataKey"
}

func Type_DecryptSingleAWSRSAEncryptedDataKey_() _dafny.TypeDescriptor {
	return type_DecryptSingleAWSRSAEncryptedDataKey_{}
}

type type_DecryptSingleAWSRSAEncryptedDataKey_ struct {
}

func (_this type_DecryptSingleAWSRSAEncryptedDataKey_) Default() interface{} {
	return (*DecryptSingleAWSRSAEncryptedDataKey)(nil)
}

func (_this type_DecryptSingleAWSRSAEncryptedDataKey_) String() string {
	return "AwsKmsRsaKeyring.DecryptSingleAWSRSAEncryptedDataKey"
}
func (_this *DecryptSingleAWSRSAEncryptedDataKey) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_Actions.Companion_ActionWithResult_.TraitID_, m_Actions.Companion_Action_.TraitID_}
}

var _ m_Actions.ActionWithResult = &DecryptSingleAWSRSAEncryptedDataKey{}
var _ m_Actions.Action = &DecryptSingleAWSRSAEncryptedDataKey{}
var _ _dafny.TraitOffspring = &DecryptSingleAWSRSAEncryptedDataKey{}

func (_this *DecryptSingleAWSRSAEncryptedDataKey) Ctor__(materials m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials, client m_ComAmazonawsKmsTypes.IKMSClient, awsKmsKey _dafny.Sequence, paddingScheme m_ComAmazonawsKmsTypes.EncryptionAlgorithmSpec, encryptionContextDigest _dafny.Sequence, grantTokens _dafny.Sequence) {
	{
		(_this)._materials = materials
		(_this)._client = client
		(_this)._awsKmsKey = awsKmsKey
		(_this)._paddingScheme = paddingScheme
		(_this)._encryptionContextDigest = encryptionContextDigest
		(_this)._grantTokens = grantTokens
	}
}
func (_this *DecryptSingleAWSRSAEncryptedDataKey) Invoke(edk interface{}) interface{} {
	{
		var edk m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey = edk.(m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey)
		_ = edk
		var res m_Wrappers.Result = m_Wrappers.Result{}
		_ = res
		var _0_unwrap *KmsRsaUnwrapKeyMaterial
		_ = _0_unwrap
		var _nw0 *KmsRsaUnwrapKeyMaterial = New_KmsRsaUnwrapKeyMaterial_()
		_ = _nw0
		_nw0.Ctor__((_this).Client(), (_this).AwsKmsKey(), (_this).PaddingScheme(), (_this).EncryptionContextDigest(), (_this).GrantTokens())
		_0_unwrap = _nw0
		var _1_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_EdkWrapping.Companion_UnwrapEdkMaterialOutput_.Default(Companion_KmsRsaUnwrapInfo_.Default()))
		_ = _1_valueOrError0
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_EdkWrapping.Companion_Default___.UnwrapEdkMaterial((edk).Dtor_ciphertext(), (_this).Materials(), _0_unwrap)
		_1_valueOrError0 = _out0
		if (_1_valueOrError0).IsFailure() {
			res = (_1_valueOrError0).PropagateFailure()
			return res
		}
		var _2_unwrapOutput m_EdkWrapping.UnwrapEdkMaterialOutput
		_ = _2_unwrapOutput
		_2_unwrapOutput = (_1_valueOrError0).Extract().(m_EdkWrapping.UnwrapEdkMaterialOutput)
		var _3_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _3_valueOrError1
		_3_valueOrError1 = m_Materials.Companion_Default___.DecryptionMaterialsAddDataKey((_this).Materials(), (_2_unwrapOutput).Dtor_plaintextDataKey(), (_2_unwrapOutput).Dtor_symmetricSigningKey())
		if (_3_valueOrError1).IsFailure() {
			res = (_3_valueOrError1).PropagateFailure()
			return res
		}
		var _4_result m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials
		_ = _4_result
		_4_result = (_3_valueOrError1).Extract().(m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials)
		res = m_Wrappers.Companion_Result_.Create_Success_(_4_result)
		return res
		return res
	}
}
func (_this *DecryptSingleAWSRSAEncryptedDataKey) Materials() m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials {
	{
		return _this._materials
	}
}
func (_this *DecryptSingleAWSRSAEncryptedDataKey) Client() m_ComAmazonawsKmsTypes.IKMSClient {
	{
		return _this._client
	}
}
func (_this *DecryptSingleAWSRSAEncryptedDataKey) AwsKmsKey() _dafny.Sequence {
	{
		return _this._awsKmsKey
	}
}
func (_this *DecryptSingleAWSRSAEncryptedDataKey) PaddingScheme() m_ComAmazonawsKmsTypes.EncryptionAlgorithmSpec {
	{
		return _this._paddingScheme
	}
}
func (_this *DecryptSingleAWSRSAEncryptedDataKey) EncryptionContextDigest() _dafny.Sequence {
	{
		return _this._encryptionContextDigest
	}
}
func (_this *DecryptSingleAWSRSAEncryptedDataKey) GrantTokens() _dafny.Sequence {
	{
		return _this._grantTokens
	}
}

// End of class DecryptSingleAWSRSAEncryptedDataKey

// Definition of datatype KmsRsaUnwrapInfo
type KmsRsaUnwrapInfo struct {
	Data_KmsRsaUnwrapInfo_
}

func (_this KmsRsaUnwrapInfo) Get_() Data_KmsRsaUnwrapInfo_ {
	return _this.Data_KmsRsaUnwrapInfo_
}

type Data_KmsRsaUnwrapInfo_ interface {
	isKmsRsaUnwrapInfo()
}

type CompanionStruct_KmsRsaUnwrapInfo_ struct {
}

var Companion_KmsRsaUnwrapInfo_ = CompanionStruct_KmsRsaUnwrapInfo_{}

type KmsRsaUnwrapInfo_KmsRsaUnwrapInfo struct {
}

func (KmsRsaUnwrapInfo_KmsRsaUnwrapInfo) isKmsRsaUnwrapInfo() {}

func (CompanionStruct_KmsRsaUnwrapInfo_) Create_KmsRsaUnwrapInfo_() KmsRsaUnwrapInfo {
	return KmsRsaUnwrapInfo{KmsRsaUnwrapInfo_KmsRsaUnwrapInfo{}}
}

func (_this KmsRsaUnwrapInfo) Is_KmsRsaUnwrapInfo() bool {
	_, ok := _this.Get_().(KmsRsaUnwrapInfo_KmsRsaUnwrapInfo)
	return ok
}

func (CompanionStruct_KmsRsaUnwrapInfo_) Default() KmsRsaUnwrapInfo {
	return Companion_KmsRsaUnwrapInfo_.Create_KmsRsaUnwrapInfo_()
}

func (_ CompanionStruct_KmsRsaUnwrapInfo_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_KmsRsaUnwrapInfo_.Create_KmsRsaUnwrapInfo_(), true
		default:
			return KmsRsaUnwrapInfo{}, false
		}
	}
}

func (_this KmsRsaUnwrapInfo) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case KmsRsaUnwrapInfo_KmsRsaUnwrapInfo:
		{
			return "AwsKmsRsaKeyring.KmsRsaUnwrapInfo.KmsRsaUnwrapInfo"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this KmsRsaUnwrapInfo) Equals(other KmsRsaUnwrapInfo) bool {
	switch _this.Get_().(type) {
	case KmsRsaUnwrapInfo_KmsRsaUnwrapInfo:
		{
			_, ok := other.Get_().(KmsRsaUnwrapInfo_KmsRsaUnwrapInfo)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this KmsRsaUnwrapInfo) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(KmsRsaUnwrapInfo)
	return ok && _this.Equals(typed)
}

func Type_KmsRsaUnwrapInfo_() _dafny.TypeDescriptor {
	return type_KmsRsaUnwrapInfo_{}
}

type type_KmsRsaUnwrapInfo_ struct {
}

func (_this type_KmsRsaUnwrapInfo_) Default() interface{} {
	return Companion_KmsRsaUnwrapInfo_.Default()
}

func (_this type_KmsRsaUnwrapInfo_) String() string {
	return "AwsKmsRsaKeyring.KmsRsaUnwrapInfo"
}
func (_this KmsRsaUnwrapInfo) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = KmsRsaUnwrapInfo{}

// End of datatype KmsRsaUnwrapInfo

// Definition of datatype KmsRsaWrapInfo
type KmsRsaWrapInfo struct {
	Data_KmsRsaWrapInfo_
}

func (_this KmsRsaWrapInfo) Get_() Data_KmsRsaWrapInfo_ {
	return _this.Data_KmsRsaWrapInfo_
}

type Data_KmsRsaWrapInfo_ interface {
	isKmsRsaWrapInfo()
}

type CompanionStruct_KmsRsaWrapInfo_ struct {
}

var Companion_KmsRsaWrapInfo_ = CompanionStruct_KmsRsaWrapInfo_{}

type KmsRsaWrapInfo_KmsRsaWrapInfo struct {
}

func (KmsRsaWrapInfo_KmsRsaWrapInfo) isKmsRsaWrapInfo() {}

func (CompanionStruct_KmsRsaWrapInfo_) Create_KmsRsaWrapInfo_() KmsRsaWrapInfo {
	return KmsRsaWrapInfo{KmsRsaWrapInfo_KmsRsaWrapInfo{}}
}

func (_this KmsRsaWrapInfo) Is_KmsRsaWrapInfo() bool {
	_, ok := _this.Get_().(KmsRsaWrapInfo_KmsRsaWrapInfo)
	return ok
}

func (CompanionStruct_KmsRsaWrapInfo_) Default() KmsRsaWrapInfo {
	return Companion_KmsRsaWrapInfo_.Create_KmsRsaWrapInfo_()
}

func (_ CompanionStruct_KmsRsaWrapInfo_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_KmsRsaWrapInfo_.Create_KmsRsaWrapInfo_(), true
		default:
			return KmsRsaWrapInfo{}, false
		}
	}
}

func (_this KmsRsaWrapInfo) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case KmsRsaWrapInfo_KmsRsaWrapInfo:
		{
			return "AwsKmsRsaKeyring.KmsRsaWrapInfo.KmsRsaWrapInfo"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this KmsRsaWrapInfo) Equals(other KmsRsaWrapInfo) bool {
	switch _this.Get_().(type) {
	case KmsRsaWrapInfo_KmsRsaWrapInfo:
		{
			_, ok := other.Get_().(KmsRsaWrapInfo_KmsRsaWrapInfo)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this KmsRsaWrapInfo) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(KmsRsaWrapInfo)
	return ok && _this.Equals(typed)
}

func Type_KmsRsaWrapInfo_() _dafny.TypeDescriptor {
	return type_KmsRsaWrapInfo_{}
}

type type_KmsRsaWrapInfo_ struct {
}

func (_this type_KmsRsaWrapInfo_) Default() interface{} {
	return Companion_KmsRsaWrapInfo_.Default()
}

func (_this type_KmsRsaWrapInfo_) String() string {
	return "AwsKmsRsaKeyring.KmsRsaWrapInfo"
}
func (_this KmsRsaWrapInfo) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = KmsRsaWrapInfo{}

// End of datatype KmsRsaWrapInfo

// Definition of class KmsRsaGenerateAndWrapKeyMaterial
type KmsRsaGenerateAndWrapKeyMaterial struct {
	_publicKey        _dafny.Sequence
	_cryptoPrimitives *m_AtomicPrimitives.AtomicPrimitivesClient
	_paddingScheme    m_ComAmazonawsKmsTypes.EncryptionAlgorithmSpec
}

func New_KmsRsaGenerateAndWrapKeyMaterial_() *KmsRsaGenerateAndWrapKeyMaterial {
	_this := KmsRsaGenerateAndWrapKeyMaterial{}

	_this._publicKey = _dafny.EmptySeq
	_this._cryptoPrimitives = (*m_AtomicPrimitives.AtomicPrimitivesClient)(nil)
	_this._paddingScheme = m_ComAmazonawsKmsTypes.Companion_EncryptionAlgorithmSpec_.Default()
	return &_this
}

type CompanionStruct_KmsRsaGenerateAndWrapKeyMaterial_ struct {
}

var Companion_KmsRsaGenerateAndWrapKeyMaterial_ = CompanionStruct_KmsRsaGenerateAndWrapKeyMaterial_{}

func (_this *KmsRsaGenerateAndWrapKeyMaterial) Equals(other *KmsRsaGenerateAndWrapKeyMaterial) bool {
	return _this == other
}

func (_this *KmsRsaGenerateAndWrapKeyMaterial) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*KmsRsaGenerateAndWrapKeyMaterial)
	return ok && _this.Equals(other)
}

func (*KmsRsaGenerateAndWrapKeyMaterial) String() string {
	return "AwsKmsRsaKeyring.KmsRsaGenerateAndWrapKeyMaterial"
}

func Type_KmsRsaGenerateAndWrapKeyMaterial_() _dafny.TypeDescriptor {
	return type_KmsRsaGenerateAndWrapKeyMaterial_{}
}

type type_KmsRsaGenerateAndWrapKeyMaterial_ struct {
}

func (_this type_KmsRsaGenerateAndWrapKeyMaterial_) Default() interface{} {
	return (*KmsRsaGenerateAndWrapKeyMaterial)(nil)
}

func (_this type_KmsRsaGenerateAndWrapKeyMaterial_) String() string {
	return "AwsKmsRsaKeyring.KmsRsaGenerateAndWrapKeyMaterial"
}
func (_this *KmsRsaGenerateAndWrapKeyMaterial) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_MaterialWrapping.Companion_GenerateAndWrapMaterial_.TraitID_, m_Actions.Companion_ActionWithResult_.TraitID_, m_Actions.Companion_Action_.TraitID_}
}

var _ m_MaterialWrapping.GenerateAndWrapMaterial = &KmsRsaGenerateAndWrapKeyMaterial{}
var _ m_Actions.ActionWithResult = &KmsRsaGenerateAndWrapKeyMaterial{}
var _ m_Actions.Action = &KmsRsaGenerateAndWrapKeyMaterial{}
var _ _dafny.TraitOffspring = &KmsRsaGenerateAndWrapKeyMaterial{}

func (_this *KmsRsaGenerateAndWrapKeyMaterial) Ctor__(publicKey _dafny.Sequence, paddingScheme m_ComAmazonawsKmsTypes.EncryptionAlgorithmSpec, cryptoPrimitives *m_AtomicPrimitives.AtomicPrimitivesClient) {
	{
		(_this)._publicKey = publicKey
		(_this)._cryptoPrimitives = cryptoPrimitives
		(_this)._paddingScheme = paddingScheme
	}
}
func (_this *KmsRsaGenerateAndWrapKeyMaterial) Invoke(input interface{}) interface{} {
	{
		var input m_MaterialWrapping.GenerateAndWrapInput = input.(m_MaterialWrapping.GenerateAndWrapInput)
		_ = input
		var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_MaterialWrapping.Companion_GenerateAndWrapOutput_.Default(Companion_KmsRsaWrapInfo_.Default()))
		_ = res
		var _0_generateBytesResult m_Wrappers.Result
		_ = _0_generateBytesResult
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = ((_this).CryptoPrimitives()).GenerateRandomBytes(m_AwsCryptographyPrimitivesTypes.Companion_GenerateRandomBytesInput_.Create_GenerateRandomBytesInput_(m_AlgorithmSuites.Companion_Default___.GetEncryptKeyLength((input).Dtor_algorithmSuite())))
		_0_generateBytesResult = _out0
		var _1_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _1_valueOrError0
		_1_valueOrError0 = (_0_generateBytesResult).MapFailure(func(coer110 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg111 interface{}) interface{} {
				return coer110(arg111.(m_AwsCryptographyPrimitivesTypes.Error))
			}
		}(func(_2_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
			return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_2_e)
		}))
		if (_1_valueOrError0).IsFailure() {
			res = (_1_valueOrError0).PropagateFailure()
			return res
		}
		var _3_plaintextMaterial _dafny.Sequence
		_ = _3_plaintextMaterial
		_3_plaintextMaterial = (_1_valueOrError0).Extract().(_dafny.Sequence)
		var _4_wrap *KmsRsaWrapKeyMaterial
		_ = _4_wrap
		var _nw0 *KmsRsaWrapKeyMaterial = New_KmsRsaWrapKeyMaterial_()
		_ = _nw0
		_nw0.Ctor__((_this).PublicKey(), (_this).PaddingScheme(), (_this).CryptoPrimitives())
		_4_wrap = _nw0
		var _5_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_MaterialWrapping.Companion_WrapOutput_.Default(Companion_KmsRsaWrapInfo_.Default()))
		_ = _5_valueOrError1
		var _out1 interface{}
		_ = _out1
		_out1 = (_4_wrap).Invoke(m_MaterialWrapping.Companion_WrapInput_.Create_WrapInput_(_3_plaintextMaterial, (input).Dtor_algorithmSuite(), (input).Dtor_encryptionContext(), (input).Dtor_serializedEC()))
		_5_valueOrError1 = _out1.(m_Wrappers.Result)
		if (_5_valueOrError1).IsFailure() {
			res = (_5_valueOrError1).PropagateFailure()
			return res
		}
		var _6_wrapOutput m_MaterialWrapping.WrapOutput
		_ = _6_wrapOutput
		_6_wrapOutput = (_5_valueOrError1).Extract().(m_MaterialWrapping.WrapOutput)
		var _7_output m_MaterialWrapping.GenerateAndWrapOutput
		_ = _7_output
		_7_output = m_MaterialWrapping.Companion_GenerateAndWrapOutput_.Create_GenerateAndWrapOutput_(_3_plaintextMaterial, (_6_wrapOutput).Dtor_wrappedMaterial(), Companion_KmsRsaWrapInfo_.Create_KmsRsaWrapInfo_())
		res = m_Wrappers.Companion_Result_.Create_Success_(_7_output)
		return res
		return res
	}
}
func (_this *KmsRsaGenerateAndWrapKeyMaterial) PublicKey() _dafny.Sequence {
	{
		return _this._publicKey
	}
}
func (_this *KmsRsaGenerateAndWrapKeyMaterial) CryptoPrimitives() *m_AtomicPrimitives.AtomicPrimitivesClient {
	{
		return _this._cryptoPrimitives
	}
}
func (_this *KmsRsaGenerateAndWrapKeyMaterial) PaddingScheme() m_ComAmazonawsKmsTypes.EncryptionAlgorithmSpec {
	{
		return _this._paddingScheme
	}
}

// End of class KmsRsaGenerateAndWrapKeyMaterial

// Definition of class KmsRsaWrapKeyMaterial
type KmsRsaWrapKeyMaterial struct {
	_publicKey        _dafny.Sequence
	_cryptoPrimitives *m_AtomicPrimitives.AtomicPrimitivesClient
	_paddingScheme    m_ComAmazonawsKmsTypes.EncryptionAlgorithmSpec
}

func New_KmsRsaWrapKeyMaterial_() *KmsRsaWrapKeyMaterial {
	_this := KmsRsaWrapKeyMaterial{}

	_this._publicKey = _dafny.EmptySeq
	_this._cryptoPrimitives = (*m_AtomicPrimitives.AtomicPrimitivesClient)(nil)
	_this._paddingScheme = m_ComAmazonawsKmsTypes.Companion_EncryptionAlgorithmSpec_.Default()
	return &_this
}

type CompanionStruct_KmsRsaWrapKeyMaterial_ struct {
}

var Companion_KmsRsaWrapKeyMaterial_ = CompanionStruct_KmsRsaWrapKeyMaterial_{}

func (_this *KmsRsaWrapKeyMaterial) Equals(other *KmsRsaWrapKeyMaterial) bool {
	return _this == other
}

func (_this *KmsRsaWrapKeyMaterial) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*KmsRsaWrapKeyMaterial)
	return ok && _this.Equals(other)
}

func (*KmsRsaWrapKeyMaterial) String() string {
	return "AwsKmsRsaKeyring.KmsRsaWrapKeyMaterial"
}

func Type_KmsRsaWrapKeyMaterial_() _dafny.TypeDescriptor {
	return type_KmsRsaWrapKeyMaterial_{}
}

type type_KmsRsaWrapKeyMaterial_ struct {
}

func (_this type_KmsRsaWrapKeyMaterial_) Default() interface{} {
	return (*KmsRsaWrapKeyMaterial)(nil)
}

func (_this type_KmsRsaWrapKeyMaterial_) String() string {
	return "AwsKmsRsaKeyring.KmsRsaWrapKeyMaterial"
}
func (_this *KmsRsaWrapKeyMaterial) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_MaterialWrapping.Companion_WrapMaterial_.TraitID_, m_Actions.Companion_ActionWithResult_.TraitID_, m_Actions.Companion_Action_.TraitID_}
}

var _ m_MaterialWrapping.WrapMaterial = &KmsRsaWrapKeyMaterial{}
var _ m_Actions.ActionWithResult = &KmsRsaWrapKeyMaterial{}
var _ m_Actions.Action = &KmsRsaWrapKeyMaterial{}
var _ _dafny.TraitOffspring = &KmsRsaWrapKeyMaterial{}

func (_this *KmsRsaWrapKeyMaterial) Ctor__(publicKey _dafny.Sequence, paddingScheme m_ComAmazonawsKmsTypes.EncryptionAlgorithmSpec, cryptoPrimitives *m_AtomicPrimitives.AtomicPrimitivesClient) {
	{
		(_this)._publicKey = publicKey
		(_this)._cryptoPrimitives = cryptoPrimitives
		(_this)._paddingScheme = paddingScheme
	}
}
func (_this *KmsRsaWrapKeyMaterial) Invoke(input interface{}) interface{} {
	{
		var input m_MaterialWrapping.WrapInput = input.(m_MaterialWrapping.WrapInput)
		_ = input
		var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_MaterialWrapping.Companion_WrapOutput_.Default(Companion_KmsRsaWrapInfo_.Default()))
		_ = res
		var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _0_valueOrError0
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = Companion_Default___.EncryptionContextDigest((_this).CryptoPrimitives(), (input).Dtor_encryptionContext())
		_0_valueOrError0 = _out0
		if (_0_valueOrError0).IsFailure() {
			res = (_0_valueOrError0).PropagateFailure()
			return res
		}
		var _1_encryptionContextDigest _dafny.Sequence
		_ = _1_encryptionContextDigest
		_1_encryptionContextDigest = (_0_valueOrError0).Extract().(_dafny.Sequence)
		var _2_padding m_AwsCryptographyPrimitivesTypes.RSAPaddingMode
		_ = _2_padding
		var _source0 m_ComAmazonawsKmsTypes.EncryptionAlgorithmSpec = (_this).PaddingScheme()
		_ = _source0
		{
			{
				if _source0.Is_RSAES__OAEP__SHA__1() {
					_2_padding = m_AwsCryptographyPrimitivesTypes.Companion_RSAPaddingMode_.Create_OAEP__SHA1_()
					goto Lmatch0
				}
			}
			{
				_2_padding = m_AwsCryptographyPrimitivesTypes.Companion_RSAPaddingMode_.Create_OAEP__SHA256_()
			}
			goto Lmatch0
		}
	Lmatch0:
		var _3_RSAEncryptOutput m_Wrappers.Result
		_ = _3_RSAEncryptOutput
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = ((_this).CryptoPrimitives()).RSAEncrypt(m_AwsCryptographyPrimitivesTypes.Companion_RSAEncryptInput_.Create_RSAEncryptInput_(_2_padding, (_this).PublicKey(), _dafny.Companion_Sequence_.Concatenate(_1_encryptionContextDigest, (input).Dtor_plaintextMaterial())))
		_3_RSAEncryptOutput = _out1
		var _4_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _4_valueOrError1
		_4_valueOrError1 = (_3_RSAEncryptOutput).MapFailure(func(coer111 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg112 interface{}) interface{} {
				return coer111(arg112.(m_AwsCryptographyPrimitivesTypes.Error))
			}
		}(func(_5_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
			return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_5_e)
		}))
		if (_4_valueOrError1).IsFailure() {
			res = (_4_valueOrError1).PropagateFailure()
			return res
		}
		var _6_ciphertext _dafny.Sequence
		_ = _6_ciphertext
		_6_ciphertext = (_4_valueOrError1).Extract().(_dafny.Sequence)
		var _7_output m_MaterialWrapping.WrapOutput
		_ = _7_output
		_7_output = m_MaterialWrapping.Companion_WrapOutput_.Create_WrapOutput_(_6_ciphertext, Companion_KmsRsaWrapInfo_.Create_KmsRsaWrapInfo_())
		res = m_Wrappers.Companion_Result_.Create_Success_(_7_output)
		return res
		return res
	}
}
func (_this *KmsRsaWrapKeyMaterial) PublicKey() _dafny.Sequence {
	{
		return _this._publicKey
	}
}
func (_this *KmsRsaWrapKeyMaterial) CryptoPrimitives() *m_AtomicPrimitives.AtomicPrimitivesClient {
	{
		return _this._cryptoPrimitives
	}
}
func (_this *KmsRsaWrapKeyMaterial) PaddingScheme() m_ComAmazonawsKmsTypes.EncryptionAlgorithmSpec {
	{
		return _this._paddingScheme
	}
}

// End of class KmsRsaWrapKeyMaterial

// Definition of class KmsRsaUnwrapKeyMaterial
type KmsRsaUnwrapKeyMaterial struct {
	_client                  m_ComAmazonawsKmsTypes.IKMSClient
	_grantTokens             _dafny.Sequence
	_awsKmsKey               _dafny.Sequence
	_paddingScheme           m_ComAmazonawsKmsTypes.EncryptionAlgorithmSpec
	_encryptionContextDigest _dafny.Sequence
}

func New_KmsRsaUnwrapKeyMaterial_() *KmsRsaUnwrapKeyMaterial {
	_this := KmsRsaUnwrapKeyMaterial{}

	_this._client = (m_ComAmazonawsKmsTypes.IKMSClient)(nil)
	_this._grantTokens = _dafny.EmptySeq
	_this._awsKmsKey = _dafny.EmptySeq.SetString()
	_this._paddingScheme = m_ComAmazonawsKmsTypes.Companion_EncryptionAlgorithmSpec_.Default()
	_this._encryptionContextDigest = _dafny.EmptySeq
	return &_this
}

type CompanionStruct_KmsRsaUnwrapKeyMaterial_ struct {
}

var Companion_KmsRsaUnwrapKeyMaterial_ = CompanionStruct_KmsRsaUnwrapKeyMaterial_{}

func (_this *KmsRsaUnwrapKeyMaterial) Equals(other *KmsRsaUnwrapKeyMaterial) bool {
	return _this == other
}

func (_this *KmsRsaUnwrapKeyMaterial) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*KmsRsaUnwrapKeyMaterial)
	return ok && _this.Equals(other)
}

func (*KmsRsaUnwrapKeyMaterial) String() string {
	return "AwsKmsRsaKeyring.KmsRsaUnwrapKeyMaterial"
}

func Type_KmsRsaUnwrapKeyMaterial_() _dafny.TypeDescriptor {
	return type_KmsRsaUnwrapKeyMaterial_{}
}

type type_KmsRsaUnwrapKeyMaterial_ struct {
}

func (_this type_KmsRsaUnwrapKeyMaterial_) Default() interface{} {
	return (*KmsRsaUnwrapKeyMaterial)(nil)
}

func (_this type_KmsRsaUnwrapKeyMaterial_) String() string {
	return "AwsKmsRsaKeyring.KmsRsaUnwrapKeyMaterial"
}
func (_this *KmsRsaUnwrapKeyMaterial) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_MaterialWrapping.Companion_UnwrapMaterial_.TraitID_, m_Actions.Companion_ActionWithResult_.TraitID_, m_Actions.Companion_Action_.TraitID_}
}

var _ m_MaterialWrapping.UnwrapMaterial = &KmsRsaUnwrapKeyMaterial{}
var _ m_Actions.ActionWithResult = &KmsRsaUnwrapKeyMaterial{}
var _ m_Actions.Action = &KmsRsaUnwrapKeyMaterial{}
var _ _dafny.TraitOffspring = &KmsRsaUnwrapKeyMaterial{}

func (_this *KmsRsaUnwrapKeyMaterial) Ctor__(client m_ComAmazonawsKmsTypes.IKMSClient, awsKmsKey _dafny.Sequence, paddingScheme m_ComAmazonawsKmsTypes.EncryptionAlgorithmSpec, encryptionContextDigest _dafny.Sequence, grantTokens _dafny.Sequence) {
	{
		(_this)._client = client
		(_this)._awsKmsKey = awsKmsKey
		(_this)._paddingScheme = paddingScheme
		(_this)._encryptionContextDigest = encryptionContextDigest
		(_this)._grantTokens = grantTokens
	}
}
func (_this *KmsRsaUnwrapKeyMaterial) Invoke(input interface{}) interface{} {
	{
		var input m_MaterialWrapping.UnwrapInput = input.(m_MaterialWrapping.UnwrapInput)
		_ = input
		var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_MaterialWrapping.Companion_UnwrapOutput_.Default(Companion_KmsRsaUnwrapInfo_.Default()))
		_ = res
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _0_valueOrError0
		_0_valueOrError0 = m_Wrappers.Companion_Default___.Need(m_ComAmazonawsKmsTypes.Companion_Default___.IsValid__CiphertextType((input).Dtor_wrappedMaterial()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Ciphertext length invalid")))
		if (_0_valueOrError0).IsFailure() {
			res = (_0_valueOrError0).PropagateFailure()
			return res
		}
		var _1_decryptRequest m_ComAmazonawsKmsTypes.DecryptRequest
		_ = _1_decryptRequest
		_1_decryptRequest = m_ComAmazonawsKmsTypes.Companion_DecryptRequest_.Create_DecryptRequest_((input).Dtor_wrappedMaterial(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_((_this).GrantTokens()), m_Wrappers.Companion_Option_.Create_Some_((_this).AwsKmsKey()), m_Wrappers.Companion_Option_.Create_Some_((_this).PaddingScheme()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
		var _2_maybeDecryptResponse m_Wrappers.Result
		_ = _2_maybeDecryptResponse
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = ((_this).Client()).Decrypt(_1_decryptRequest)
		_2_maybeDecryptResponse = _out0
		var _3_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsKmsTypes.Companion_DecryptResponse_.Default())
		_ = _3_valueOrError1
		_3_valueOrError1 = (_2_maybeDecryptResponse).MapFailure(func(coer112 func(m_ComAmazonawsKmsTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg113 interface{}) interface{} {
				return coer112(arg113.(m_ComAmazonawsKmsTypes.Error))
			}
		}(func(_4_e m_ComAmazonawsKmsTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
			return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_ComAmazonawsKms_(_4_e)
		}))
		if (_3_valueOrError1).IsFailure() {
			res = (_3_valueOrError1).PropagateFailure()
			return res
		}
		var _5_decryptResponse m_ComAmazonawsKmsTypes.DecryptResponse
		_ = _5_decryptResponse
		_5_decryptResponse = (_3_valueOrError1).Extract().(m_ComAmazonawsKmsTypes.DecryptResponse)
		var _6_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _6_valueOrError2
		_6_valueOrError2 = m_Wrappers.Companion_Default___.Need(((((_5_decryptResponse).Dtor_KeyId()).Is_Some()) && (_dafny.Companion_Sequence_.Equal(((_5_decryptResponse).Dtor_KeyId()).Dtor_value().(_dafny.Sequence), (_this).AwsKmsKey()))) && (((_5_decryptResponse).Dtor_Plaintext()).Is_Some()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Invalid response from KMS Decrypt")))
		if (_6_valueOrError2).IsFailure() {
			res = (_6_valueOrError2).PropagateFailure()
			return res
		}
		var _7_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _7_valueOrError3
		_7_valueOrError3 = m_Wrappers.Companion_Default___.Need((_dafny.Companion_Sequence_.IsPrefixOf((_this).EncryptionContextDigest(), ((_5_decryptResponse).Dtor_Plaintext()).Dtor_value().(_dafny.Sequence))) && (((uint64(m_AlgorithmSuites.Companion_Default___.GetEncryptKeyLength((input).Dtor_algorithmSuite())))+(uint64(((_this).EncryptionContextDigest()).Cardinality()))) == (uint64((((_5_decryptResponse).Dtor_Plaintext()).Dtor_value().(_dafny.Sequence)).Cardinality()))), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Encryption context digest does not match expected value.")))
		if (_7_valueOrError3).IsFailure() {
			res = (_7_valueOrError3).PropagateFailure()
			return res
		}
		var _8_output m_MaterialWrapping.UnwrapOutput
		_ = _8_output
		_8_output = m_MaterialWrapping.Companion_UnwrapOutput_.Create_UnwrapOutput_((((_5_decryptResponse).Dtor_Plaintext()).Dtor_value().(_dafny.Sequence)).Drop(uint32(uint64(((_this).EncryptionContextDigest()).Cardinality()))), Companion_KmsRsaUnwrapInfo_.Create_KmsRsaUnwrapInfo_())
		res = m_Wrappers.Companion_Result_.Create_Success_(_8_output)
		return res
		return res
	}
}
func (_this *KmsRsaUnwrapKeyMaterial) Client() m_ComAmazonawsKmsTypes.IKMSClient {
	{
		return _this._client
	}
}
func (_this *KmsRsaUnwrapKeyMaterial) GrantTokens() _dafny.Sequence {
	{
		return _this._grantTokens
	}
}
func (_this *KmsRsaUnwrapKeyMaterial) AwsKmsKey() _dafny.Sequence {
	{
		return _this._awsKmsKey
	}
}
func (_this *KmsRsaUnwrapKeyMaterial) PaddingScheme() m_ComAmazonawsKmsTypes.EncryptionAlgorithmSpec {
	{
		return _this._paddingScheme
	}
}
func (_this *KmsRsaUnwrapKeyMaterial) EncryptionContextDigest() _dafny.Sequence {
	{
		return _this._encryptionContextDigest
	}
}

// End of class KmsRsaUnwrapKeyMaterial
