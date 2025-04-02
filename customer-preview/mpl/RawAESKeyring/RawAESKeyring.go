// Package RawAESKeyring
// Dafny module RawAESKeyring compiled into Go

package RawAESKeyring

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
	m_AwsKmsMrkAreUnique "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkAreUnique"
	m_AwsKmsMrkDiscoveryKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkDiscoveryKeyring"
	m_AwsKmsMrkKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkKeyring"
	m_AwsKmsMrkMatchForDecrypt "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkMatchForDecrypt"
	m_AwsKmsRsaKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsRsaKeyring"
	m_AwsKmsUtils "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsUtils"
	m_CacheConstants "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CacheConstants"
	m_CanonicalEncryptionContext "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CanonicalEncryptionContext"
	m_Constants "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Constants"
	m_CreateKeyStoreTable "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CreateKeyStoreTable"
	m_CreateKeys "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CreateKeys"
	m_DDBKeystoreOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/DDBKeystoreOperations"
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
	m_MaterialWrapping "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/MaterialWrapping"
	m_Materials "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Materials"
	m_MrkAwareDiscoveryMultiKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/MrkAwareDiscoveryMultiKeyring"
	m_MrkAwareStrictMultiKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/MrkAwareStrictMultiKeyring"
	m_MultiKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/MultiKeyring"
	m_RawECDHKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/RawECDHKeyring"
	m_StormTracker "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/StormTracker"
	m_StormTrackingCMC "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/StormTrackingCMC"
	m_StrictMultiKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/StrictMultiKeyring"
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
var _ m_MultiKeyring.Dummy__
var _ m_AwsKmsMrkAreUnique.Dummy__
var _ m_Constants.Dummy__
var _ m_MaterialWrapping.Dummy__
var _ m_CanonicalEncryptionContext.Dummy__
var _ m_IntermediateKeyWrapping.Dummy__
var _ m_EdkWrapping.Dummy__
var _ m_ErrorMessages.Dummy__
var _ m_AwsKmsKeyring.Dummy__
var _ m_StrictMultiKeyring.Dummy__
var _ m_AwsKmsDiscoveryKeyring.Dummy__
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
	return "RawAESKeyring.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) DeserializeEDKCiphertext(ciphertext _dafny.Sequence, tagLen _dafny.Int) m_AwsCryptographyPrimitivesTypes.AESEncryptOutput {
	var _0_encryptedKeyLength _dafny.Int = (_dafny.IntOfUint32((ciphertext).Cardinality())).Minus(tagLen)
	_ = _0_encryptedKeyLength
	return m_AwsCryptographyPrimitivesTypes.Companion_AESEncryptOutput_.Create_AESEncryptOutput_((ciphertext).Take((_0_encryptedKeyLength).Uint32()), (ciphertext).Drop((_0_encryptedKeyLength).Uint32()))
}
func (_static *CompanionStruct_Default___) SerializeEDKCiphertext(encOutput m_AwsCryptographyPrimitivesTypes.AESEncryptOutput) _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate((encOutput).Dtor_cipherText(), (encOutput).Dtor_authTag())
}
func (_static *CompanionStruct_Default___) AUTH__TAG__LEN__LEN() _dafny.Int {
	return _dafny.IntOfInt64(4)
}
func (_static *CompanionStruct_Default___) IV__LEN__LEN() _dafny.Int {
	return _dafny.IntOfInt64(4)
}

// End of class Default__

// Definition of class RawAESKeyring
type RawAESKeyring struct {
	_cryptoPrimitives  *m_AtomicPrimitives.AtomicPrimitivesClient
	_wrappingKey       _dafny.Sequence
	_wrappingAlgorithm m_AwsCryptographyPrimitivesTypes.AES__GCM
	_keyNamespace      _dafny.Sequence
	_keyName           _dafny.Sequence
}

func New_RawAESKeyring_() *RawAESKeyring {
	_this := RawAESKeyring{}

	_this._cryptoPrimitives = (*m_AtomicPrimitives.AtomicPrimitivesClient)(nil)
	_this._wrappingKey = _dafny.EmptySeq
	_this._wrappingAlgorithm = m_AwsCryptographyPrimitivesTypes.AES__GCM{}
	_this._keyNamespace = m_UTF8.Companion_ValidUTF8Bytes_.Witness()
	_this._keyName = m_UTF8.Companion_ValidUTF8Bytes_.Witness()
	return &_this
}

type CompanionStruct_RawAESKeyring_ struct {
}

var Companion_RawAESKeyring_ = CompanionStruct_RawAESKeyring_{}

func (_this *RawAESKeyring) Equals(other *RawAESKeyring) bool {
	return _this == other
}

func (_this *RawAESKeyring) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*RawAESKeyring)
	return ok && _this.Equals(other)
}

func (*RawAESKeyring) String() string {
	return "RawAESKeyring.RawAESKeyring"
}

func Type_RawAESKeyring_() _dafny.TypeDescriptor {
	return type_RawAESKeyring_{}
}

type type_RawAESKeyring_ struct {
}

func (_this type_RawAESKeyring_) Default() interface{} {
	return (*RawAESKeyring)(nil)
}

func (_this type_RawAESKeyring_) String() string {
	return "RawAESKeyring.RawAESKeyring"
}
func (_this *RawAESKeyring) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_Keyring.Companion_VerifiableInterface_.TraitID_, m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.TraitID_}
}

var _ m_Keyring.VerifiableInterface = &RawAESKeyring{}
var _ m_AwsCryptographyMaterialProvidersTypes.IKeyring = &RawAESKeyring{}
var _ _dafny.TraitOffspring = &RawAESKeyring{}

func (_this *RawAESKeyring) OnDecrypt(input m_AwsCryptographyMaterialProvidersTypes.OnDecryptInput) m_Wrappers.Result {
	var _out10 m_Wrappers.Result
	_ = _out10
	_out10 = m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.OnDecrypt(_this, input)
	return _out10
}
func (_this *RawAESKeyring) OnEncrypt(input m_AwsCryptographyMaterialProvidersTypes.OnEncryptInput) m_Wrappers.Result {
	var _out10 m_Wrappers.Result
	_ = _out10
	_out10 = m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.OnEncrypt(_this, input)
	return _out10
}
func (_this *RawAESKeyring) Ctor__(namespace _dafny.Sequence, name _dafny.Sequence, key _dafny.Sequence, wrappingAlgorithm m_AwsCryptographyPrimitivesTypes.AES__GCM, cryptoPrimitives *m_AtomicPrimitives.AtomicPrimitivesClient) {
	{
		(_this)._keyNamespace = namespace
		(_this)._keyName = name
		(_this)._wrappingKey = key
		(_this)._wrappingAlgorithm = wrappingAlgorithm
		(_this)._cryptoPrimitives = cryptoPrimitives
	}
}
func (_this *RawAESKeyring) OnEncrypt_k(input m_AwsCryptographyMaterialProvidersTypes.OnEncryptInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _0_materials m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials
		_ = _0_materials
		_0_materials = (input).Dtor_materials()
		var _1_suite m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo
		_ = _1_suite
		_1_suite = (_0_materials).Dtor_algorithmSuite()
		var _2_wrap *AesWrapKeyMaterial
		_ = _2_wrap
		var _nw0 *AesWrapKeyMaterial = New_AesWrapKeyMaterial_()
		_ = _nw0
		_nw0.Ctor__((_this).WrappingKey(), (_this).WrappingAlgorithm(), (_this).CryptoPrimitives())
		_2_wrap = _nw0
		var _3_generateAndWrap *AesGenerateAndWrapKeyMaterial
		_ = _3_generateAndWrap
		var _nw1 *AesGenerateAndWrapKeyMaterial = New_AesGenerateAndWrapKeyMaterial_()
		_ = _nw1
		_nw1.Ctor__(_2_wrap)
		_3_generateAndWrap = _nw1
		var _4_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_EdkWrapping.Companion_WrapEdkMaterialOutput_.Default(Companion_AesWrapInfo_.Default()))
		_ = _4_valueOrError0
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_EdkWrapping.Companion_Default___.WrapEdkMaterial(_0_materials, _2_wrap, _3_generateAndWrap)
		_4_valueOrError0 = _out0
		if (_4_valueOrError0).IsFailure() {
			output = (_4_valueOrError0).PropagateFailure()
			return output
		}
		var _5_wrapOutput m_EdkWrapping.WrapEdkMaterialOutput
		_ = _5_wrapOutput
		_5_wrapOutput = (_4_valueOrError0).Extract().(m_EdkWrapping.WrapEdkMaterialOutput)
		var _6_symmetricSigningKeyList m_Wrappers.Option
		_ = _6_symmetricSigningKeyList
		if ((_5_wrapOutput).Dtor_symmetricSigningKey()).Is_Some() {
			_6_symmetricSigningKeyList = m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(((_5_wrapOutput).Dtor_symmetricSigningKey()).Dtor_value().(_dafny.Sequence)))
		} else {
			_6_symmetricSigningKeyList = m_Wrappers.Companion_Option_.Create_None_()
		}
		var _7_edk m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey
		_ = _7_edk
		_7_edk = m_AwsCryptographyMaterialProvidersTypes.Companion_EncryptedDataKey_.Create_EncryptedDataKey_((_this).KeyNamespace(), (_this).SerializeProviderInfo(((_5_wrapOutput).Dtor_wrapInfo().(AesWrapInfo)).Dtor_iv()), (_5_wrapOutput).Dtor_wrappedMaterial())
		if (_5_wrapOutput).Is_GenerateAndWrapEdkMaterialOutput() {
			var _8_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
			_ = _8_valueOrError1
			_8_valueOrError1 = m_Materials.Companion_Default___.EncryptionMaterialAddDataKey(_0_materials, (_5_wrapOutput).Dtor_plaintextDataKey(), _dafny.SeqOf(_7_edk), _6_symmetricSigningKeyList)
			if (_8_valueOrError1).IsFailure() {
				output = (_8_valueOrError1).PropagateFailure()
				return output
			}
			var _9_result m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials
			_ = _9_result
			_9_result = (_8_valueOrError1).Extract().(m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials)
			output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyMaterialProvidersTypes.Companion_OnEncryptOutput_.Create_OnEncryptOutput_(_9_result))
			return output
		} else if (_5_wrapOutput).Is_WrapOnlyEdkMaterialOutput() {
			var _10_valueOrError2 m_Wrappers.Result = m_Wrappers.Result{}
			_ = _10_valueOrError2
			_10_valueOrError2 = m_Materials.Companion_Default___.EncryptionMaterialAddEncryptedDataKeys(_0_materials, _dafny.SeqOf(_7_edk), _6_symmetricSigningKeyList)
			if (_10_valueOrError2).IsFailure() {
				output = (_10_valueOrError2).PropagateFailure()
				return output
			}
			var _11_result m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials
			_ = _11_result
			_11_result = (_10_valueOrError2).Extract().(m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials)
			output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyMaterialProvidersTypes.Companion_OnEncryptOutput_.Create_OnEncryptOutput_(_11_result))
			return output
		}
		return output
	}
}
func (_this *RawAESKeyring) OnDecrypt_k(input m_AwsCryptographyMaterialProvidersTypes.OnDecryptInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _0_materials m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials
		_ = _0_materials
		_0_materials = (input).Dtor_materials()
		var _1_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _1_valueOrError0
		_1_valueOrError0 = m_Wrappers.Companion_Default___.Need(m_Materials.Companion_Default___.DecryptionMaterialsWithoutPlaintextDataKey(_0_materials), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Keyring received decryption materials that already contain a plaintext data key.")))
		if (_1_valueOrError0).IsFailure() {
			output = (_1_valueOrError0).PropagateFailure()
			return output
		}
		var _2_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _2_valueOrError1
		_2_valueOrError1 = m_CanonicalEncryptionContext.Companion_Default___.EncryptionContextToAAD(((input).Dtor_materials()).Dtor_encryptionContext())
		if (_2_valueOrError1).IsFailure() {
			output = (_2_valueOrError1).PropagateFailure()
			return output
		}
		var _3_aad _dafny.Sequence
		_ = _3_aad
		_3_aad = (_2_valueOrError1).Extract().(_dafny.Sequence)
		var _4_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _4_valueOrError2
		_4_valueOrError2 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32(((_this).WrappingKey()).Cardinality())).Cmp(_dafny.IntOfInt32(((_this).WrappingAlgorithm()).Dtor_keyLength())) == 0, m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("The wrapping key does not match the wrapping algorithm")))
		if (_4_valueOrError2).IsFailure() {
			output = (_4_valueOrError2).PropagateFailure()
			return output
		}
		var _5_errors _dafny.Sequence
		_ = _5_errors
		_5_errors = _dafny.SeqOf()
		var _hi0 _dafny.Int = _dafny.IntOfUint32(((input).Dtor_encryptedDataKeys()).Cardinality())
		_ = _hi0
		for _6_i := _dafny.Zero; _6_i.Cmp(_hi0) < 0; _6_i = _6_i.Plus(_dafny.One) {
			if (_this).ShouldDecryptEDK(((input).Dtor_encryptedDataKeys()).Select((_6_i).Uint32()).(m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey)) {
				var _7_edk m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey
				_ = _7_edk
				_7_edk = ((input).Dtor_encryptedDataKeys()).Select((_6_i).Uint32()).(m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey)
				var _8_iv _dafny.Sequence
				_ = _8_iv
				_8_iv = (_this).GetIvFromProvInfo((_7_edk).Dtor_keyProviderInfo())
				var _9_unwrap *AesUnwrapKeyMaterial
				_ = _9_unwrap
				var _nw0 *AesUnwrapKeyMaterial = New_AesUnwrapKeyMaterial_()
				_ = _nw0
				_nw0.Ctor__((_this).WrappingKey(), (_this).WrappingAlgorithm(), _8_iv, (_this).CryptoPrimitives())
				_9_unwrap = _nw0
				var _10_unwrapOutput m_Wrappers.Result
				_ = _10_unwrapOutput
				var _out0 m_Wrappers.Result
				_ = _out0
				_out0 = m_EdkWrapping.Companion_Default___.UnwrapEdkMaterial((_7_edk).Dtor_ciphertext(), _0_materials, _9_unwrap)
				_10_unwrapOutput = _out0
				if (_10_unwrapOutput).Is_Success() {
					var _11_valueOrError3 m_Wrappers.Result = m_Wrappers.Result{}
					_ = _11_valueOrError3
					_11_valueOrError3 = m_Materials.Companion_Default___.DecryptionMaterialsAddDataKey(_0_materials, ((_10_unwrapOutput).Dtor_value().(m_EdkWrapping.UnwrapEdkMaterialOutput)).Dtor_plaintextDataKey(), ((_10_unwrapOutput).Dtor_value().(m_EdkWrapping.UnwrapEdkMaterialOutput)).Dtor_symmetricSigningKey())
					if (_11_valueOrError3).IsFailure() {
						output = (_11_valueOrError3).PropagateFailure()
						return output
					}
					var _12_result m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials
					_ = _12_result
					_12_result = (_11_valueOrError3).Extract().(m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials)
					var _13_value m_AwsCryptographyMaterialProvidersTypes.OnDecryptOutput
					_ = _13_value
					_13_value = m_AwsCryptographyMaterialProvidersTypes.Companion_OnDecryptOutput_.Create_OnDecryptOutput_(_12_result)
					output = m_Wrappers.Companion_Result_.Create_Success_(_13_value)
					return output
				} else {
					_5_errors = _dafny.Companion_Sequence_.Concatenate(_5_errors, _dafny.SeqOf((_10_unwrapOutput).Dtor_error().(m_AwsCryptographyMaterialProvidersTypes.Error)))
				}
			} else {
				var _14_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
				_ = _14_valueOrError4
				_14_valueOrError4 = (m_UTF8.Decode((((input).Dtor_encryptedDataKeys()).Select((_6_i).Uint32()).(m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey)).Dtor_keyProviderId())).MapFailure(func(coer120 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
					return func(arg121 interface{}) interface{} {
						return coer120(arg121.(_dafny.Sequence))
					}
				}(func(_15_e _dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error {
					return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_15_e)
				}))
				if (_14_valueOrError4).IsFailure() {
					output = (_14_valueOrError4).PropagateFailure()
					return output
				}
				var _16_extractedKeyProviderId _dafny.Sequence
				_ = _16_extractedKeyProviderId
				_16_extractedKeyProviderId = (_14_valueOrError4).Extract().(_dafny.Sequence)
				_5_errors = _dafny.Companion_Sequence_.Concatenate(_5_errors, _dafny.SeqOf(m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(m_ErrorMessages.Companion_Default___.IncorrectRawDataKeys(m_StandardLibrary_String.Companion_Default___.Base10Int2String(_6_i), _dafny.SeqOfString("AESKeyring"), _16_extractedKeyProviderId))))
			}
		}
		output = m_Wrappers.Companion_Result_.Create_Failure_(m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_CollectionOfErrors_(_5_errors, _dafny.SeqOfString("Raw AES Keyring was unable to decrypt any encrypted data key. The list of encountered Exceptions is avaible via `list`.")))
		return output
		return output
	}
}
func (_this *RawAESKeyring) SerializeProviderInfo(iv _dafny.Sequence) _dafny.Sequence {
	{
		return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate((_this).KeyName(), m_StandardLibrary_UInt.Companion_Default___.UInt32ToSeq(uint32((((_this).WrappingAlgorithm()).Dtor_tagLength())*(int32(8))))), m_StandardLibrary_UInt.Companion_Default___.UInt32ToSeq(uint32(((_this).WrappingAlgorithm()).Dtor_ivLength()))), iv)
	}
}
func (_this *RawAESKeyring) ShouldDecryptEDK(edk m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey) bool {
	{
		return (_dafny.Companion_Sequence_.Equal((edk).Dtor_keyProviderId(), (_this).KeyNamespace())) && ((_this).ValidProviderInfo((edk).Dtor_keyProviderInfo()))
	}
}
func (_this *RawAESKeyring) ValidProviderInfo(info _dafny.Sequence) bool {
	{
		return ((((((_dafny.IntOfUint32((info).Cardinality())).Cmp((((_dafny.IntOfUint32(((_this).KeyName()).Cardinality())).Plus(Companion_Default___.AUTH__TAG__LEN__LEN())).Plus(Companion_Default___.IV__LEN__LEN())).Plus(_dafny.IntOfInt32(((_this).WrappingAlgorithm()).Dtor_ivLength()))) == 0) && (_dafny.Companion_Sequence_.Equal((info).Subsequence(0, (_dafny.IntOfUint32(((_this).KeyName()).Cardinality())).Uint32()), (_this).KeyName()))) && ((m_StandardLibrary_UInt.Companion_Default___.SeqToUInt32((info).Subsequence((_dafny.IntOfUint32(((_this).KeyName()).Cardinality())).Uint32(), ((_dafny.IntOfUint32(((_this).KeyName()).Cardinality())).Plus(Companion_Default___.AUTH__TAG__LEN__LEN())).Uint32()))) == (uint32(128)))) && ((m_StandardLibrary_UInt.Companion_Default___.SeqToUInt32((info).Subsequence((_dafny.IntOfUint32(((_this).KeyName()).Cardinality())).Uint32(), ((_dafny.IntOfUint32(((_this).KeyName()).Cardinality())).Plus(Companion_Default___.AUTH__TAG__LEN__LEN())).Uint32()))) == ((uint32(((_this).WrappingAlgorithm()).Dtor_tagLength())) * (uint32(8))))) && ((m_StandardLibrary_UInt.Companion_Default___.SeqToUInt32((info).Subsequence(((_dafny.IntOfUint32(((_this).KeyName()).Cardinality())).Plus(Companion_Default___.AUTH__TAG__LEN__LEN())).Uint32(), (((_dafny.IntOfUint32(((_this).KeyName()).Cardinality())).Plus(Companion_Default___.AUTH__TAG__LEN__LEN())).Plus(Companion_Default___.IV__LEN__LEN())).Uint32()))) == (uint32(((_this).WrappingAlgorithm()).Dtor_ivLength())))) && ((m_StandardLibrary_UInt.Companion_Default___.SeqToUInt32((info).Subsequence(((_dafny.IntOfUint32(((_this).KeyName()).Cardinality())).Plus(Companion_Default___.AUTH__TAG__LEN__LEN())).Uint32(), (((_dafny.IntOfUint32(((_this).KeyName()).Cardinality())).Plus(Companion_Default___.AUTH__TAG__LEN__LEN())).Plus(Companion_Default___.IV__LEN__LEN())).Uint32()))) == (uint32(12)))
	}
}
func (_this *RawAESKeyring) GetIvFromProvInfo(info _dafny.Sequence) _dafny.Sequence {
	{
		return (info).Drop((((_dafny.IntOfUint32(((_this).KeyName()).Cardinality())).Plus(Companion_Default___.AUTH__TAG__LEN__LEN())).Plus(Companion_Default___.IV__LEN__LEN())).Uint32())
	}
}
func (_this *RawAESKeyring) CryptoPrimitives() *m_AtomicPrimitives.AtomicPrimitivesClient {
	{
		return _this._cryptoPrimitives
	}
}
func (_this *RawAESKeyring) WrappingKey() _dafny.Sequence {
	{
		return _this._wrappingKey
	}
}
func (_this *RawAESKeyring) WrappingAlgorithm() m_AwsCryptographyPrimitivesTypes.AES__GCM {
	{
		return _this._wrappingAlgorithm
	}
}
func (_this *RawAESKeyring) KeyNamespace() _dafny.Sequence {
	{
		return _this._keyNamespace
	}
}
func (_this *RawAESKeyring) KeyName() _dafny.Sequence {
	{
		return _this._keyName
	}
}

// End of class RawAESKeyring

// Definition of datatype AesUnwrapInfo
type AesUnwrapInfo struct {
	Data_AesUnwrapInfo_
}

func (_this AesUnwrapInfo) Get_() Data_AesUnwrapInfo_ {
	return _this.Data_AesUnwrapInfo_
}

type Data_AesUnwrapInfo_ interface {
	isAesUnwrapInfo()
}

type CompanionStruct_AesUnwrapInfo_ struct {
}

var Companion_AesUnwrapInfo_ = CompanionStruct_AesUnwrapInfo_{}

type AesUnwrapInfo_AesUnwrapInfo struct {
}

func (AesUnwrapInfo_AesUnwrapInfo) isAesUnwrapInfo() {}

func (CompanionStruct_AesUnwrapInfo_) Create_AesUnwrapInfo_() AesUnwrapInfo {
	return AesUnwrapInfo{AesUnwrapInfo_AesUnwrapInfo{}}
}

func (_this AesUnwrapInfo) Is_AesUnwrapInfo() bool {
	_, ok := _this.Get_().(AesUnwrapInfo_AesUnwrapInfo)
	return ok
}

func (CompanionStruct_AesUnwrapInfo_) Default() AesUnwrapInfo {
	return Companion_AesUnwrapInfo_.Create_AesUnwrapInfo_()
}

func (_ CompanionStruct_AesUnwrapInfo_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_AesUnwrapInfo_.Create_AesUnwrapInfo_(), true
		default:
			return AesUnwrapInfo{}, false
		}
	}
}

func (_this AesUnwrapInfo) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case AesUnwrapInfo_AesUnwrapInfo:
		{
			return "RawAESKeyring.AesUnwrapInfo.AesUnwrapInfo"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this AesUnwrapInfo) Equals(other AesUnwrapInfo) bool {
	switch _this.Get_().(type) {
	case AesUnwrapInfo_AesUnwrapInfo:
		{
			_, ok := other.Get_().(AesUnwrapInfo_AesUnwrapInfo)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this AesUnwrapInfo) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(AesUnwrapInfo)
	return ok && _this.Equals(typed)
}

func Type_AesUnwrapInfo_() _dafny.TypeDescriptor {
	return type_AesUnwrapInfo_{}
}

type type_AesUnwrapInfo_ struct {
}

func (_this type_AesUnwrapInfo_) Default() interface{} {
	return Companion_AesUnwrapInfo_.Default()
}

func (_this type_AesUnwrapInfo_) String() string {
	return "RawAESKeyring.AesUnwrapInfo"
}
func (_this AesUnwrapInfo) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = AesUnwrapInfo{}

// End of datatype AesUnwrapInfo

// Definition of datatype AesWrapInfo
type AesWrapInfo struct {
	Data_AesWrapInfo_
}

func (_this AesWrapInfo) Get_() Data_AesWrapInfo_ {
	return _this.Data_AesWrapInfo_
}

type Data_AesWrapInfo_ interface {
	isAesWrapInfo()
}

type CompanionStruct_AesWrapInfo_ struct {
}

var Companion_AesWrapInfo_ = CompanionStruct_AesWrapInfo_{}

type AesWrapInfo_AesWrapInfo struct {
	Iv _dafny.Sequence
}

func (AesWrapInfo_AesWrapInfo) isAesWrapInfo() {}

func (CompanionStruct_AesWrapInfo_) Create_AesWrapInfo_(Iv _dafny.Sequence) AesWrapInfo {
	return AesWrapInfo{AesWrapInfo_AesWrapInfo{Iv}}
}

func (_this AesWrapInfo) Is_AesWrapInfo() bool {
	_, ok := _this.Get_().(AesWrapInfo_AesWrapInfo)
	return ok
}

func (CompanionStruct_AesWrapInfo_) Default() AesWrapInfo {
	return Companion_AesWrapInfo_.Create_AesWrapInfo_(_dafny.EmptySeq)
}

func (_this AesWrapInfo) Dtor_iv() _dafny.Sequence {
	return _this.Get_().(AesWrapInfo_AesWrapInfo).Iv
}

func (_this AesWrapInfo) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case AesWrapInfo_AesWrapInfo:
		{
			return "RawAESKeyring.AesWrapInfo.AesWrapInfo" + "(" + _dafny.String(data.Iv) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this AesWrapInfo) Equals(other AesWrapInfo) bool {
	switch data1 := _this.Get_().(type) {
	case AesWrapInfo_AesWrapInfo:
		{
			data2, ok := other.Get_().(AesWrapInfo_AesWrapInfo)
			return ok && data1.Iv.Equals(data2.Iv)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this AesWrapInfo) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(AesWrapInfo)
	return ok && _this.Equals(typed)
}

func Type_AesWrapInfo_() _dafny.TypeDescriptor {
	return type_AesWrapInfo_{}
}

type type_AesWrapInfo_ struct {
}

func (_this type_AesWrapInfo_) Default() interface{} {
	return Companion_AesWrapInfo_.Default()
}

func (_this type_AesWrapInfo_) String() string {
	return "RawAESKeyring.AesWrapInfo"
}
func (_this AesWrapInfo) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = AesWrapInfo{}

// End of datatype AesWrapInfo

// Definition of class AesGenerateAndWrapKeyMaterial
type AesGenerateAndWrapKeyMaterial struct {
	_wrap *AesWrapKeyMaterial
}

func New_AesGenerateAndWrapKeyMaterial_() *AesGenerateAndWrapKeyMaterial {
	_this := AesGenerateAndWrapKeyMaterial{}

	_this._wrap = (*AesWrapKeyMaterial)(nil)
	return &_this
}

type CompanionStruct_AesGenerateAndWrapKeyMaterial_ struct {
}

var Companion_AesGenerateAndWrapKeyMaterial_ = CompanionStruct_AesGenerateAndWrapKeyMaterial_{}

func (_this *AesGenerateAndWrapKeyMaterial) Equals(other *AesGenerateAndWrapKeyMaterial) bool {
	return _this == other
}

func (_this *AesGenerateAndWrapKeyMaterial) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*AesGenerateAndWrapKeyMaterial)
	return ok && _this.Equals(other)
}

func (*AesGenerateAndWrapKeyMaterial) String() string {
	return "RawAESKeyring.AesGenerateAndWrapKeyMaterial"
}

func Type_AesGenerateAndWrapKeyMaterial_() _dafny.TypeDescriptor {
	return type_AesGenerateAndWrapKeyMaterial_{}
}

type type_AesGenerateAndWrapKeyMaterial_ struct {
}

func (_this type_AesGenerateAndWrapKeyMaterial_) Default() interface{} {
	return (*AesGenerateAndWrapKeyMaterial)(nil)
}

func (_this type_AesGenerateAndWrapKeyMaterial_) String() string {
	return "RawAESKeyring.AesGenerateAndWrapKeyMaterial"
}
func (_this *AesGenerateAndWrapKeyMaterial) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_MaterialWrapping.Companion_GenerateAndWrapMaterial_.TraitID_, m_Actions.Companion_ActionWithResult_.TraitID_, m_Actions.Companion_Action_.TraitID_}
}

var _ m_MaterialWrapping.GenerateAndWrapMaterial = &AesGenerateAndWrapKeyMaterial{}
var _ m_Actions.ActionWithResult = &AesGenerateAndWrapKeyMaterial{}
var _ m_Actions.Action = &AesGenerateAndWrapKeyMaterial{}
var _ _dafny.TraitOffspring = &AesGenerateAndWrapKeyMaterial{}

func (_this *AesGenerateAndWrapKeyMaterial) Ctor__(wrap *AesWrapKeyMaterial) {
	{
		(_this)._wrap = wrap
	}
}
func (_this *AesGenerateAndWrapKeyMaterial) Invoke(input interface{}) interface{} {
	{
		var input m_MaterialWrapping.GenerateAndWrapInput = input.(m_MaterialWrapping.GenerateAndWrapInput)
		_ = input
		var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_MaterialWrapping.Companion_GenerateAndWrapOutput_.Default(Companion_AesWrapInfo_.Default()))
		_ = res
		var _0_generateBytesResult m_Wrappers.Result
		_ = _0_generateBytesResult
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = (((_this).Wrap()).CryptoPrimitives()).GenerateRandomBytes(m_AwsCryptographyPrimitivesTypes.Companion_GenerateRandomBytesInput_.Create_GenerateRandomBytesInput_(m_AlgorithmSuites.Companion_Default___.GetEncryptKeyLength((input).Dtor_algorithmSuite())))
		_0_generateBytesResult = _out0
		var _1_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _1_valueOrError0
		_1_valueOrError0 = (_0_generateBytesResult).MapFailure(func(coer121 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg122 interface{}) interface{} {
				return coer121(arg122.(m_AwsCryptographyPrimitivesTypes.Error))
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
		var _4_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_MaterialWrapping.Companion_WrapOutput_.Default(Companion_AesWrapInfo_.Default()))
		_ = _4_valueOrError1
		var _out1 interface{}
		_ = _out1
		_out1 = ((_this).Wrap()).Invoke(m_MaterialWrapping.Companion_WrapInput_.Create_WrapInput_(_3_plaintextMaterial, (input).Dtor_algorithmSuite(), (input).Dtor_encryptionContext()))
		_4_valueOrError1 = _out1.(m_Wrappers.Result)
		if (_4_valueOrError1).IsFailure() {
			res = (_4_valueOrError1).PropagateFailure()
			return res
		}
		var _5_wrapOutput m_MaterialWrapping.WrapOutput
		_ = _5_wrapOutput
		_5_wrapOutput = (_4_valueOrError1).Extract().(m_MaterialWrapping.WrapOutput)
		res = m_Wrappers.Companion_Result_.Create_Success_(m_MaterialWrapping.Companion_GenerateAndWrapOutput_.Create_GenerateAndWrapOutput_(_3_plaintextMaterial, (_5_wrapOutput).Dtor_wrappedMaterial(), (_5_wrapOutput).Dtor_wrapInfo().(AesWrapInfo)))
		return res
	}
}
func (_this *AesGenerateAndWrapKeyMaterial) Wrap() *AesWrapKeyMaterial {
	{
		return _this._wrap
	}
}

// End of class AesGenerateAndWrapKeyMaterial

// Definition of class AesWrapKeyMaterial
type AesWrapKeyMaterial struct {
	_wrappingKey       _dafny.Sequence
	_wrappingAlgorithm m_AwsCryptographyPrimitivesTypes.AES__GCM
	_cryptoPrimitives  *m_AtomicPrimitives.AtomicPrimitivesClient
}

func New_AesWrapKeyMaterial_() *AesWrapKeyMaterial {
	_this := AesWrapKeyMaterial{}

	_this._wrappingKey = _dafny.EmptySeq
	_this._wrappingAlgorithm = m_AwsCryptographyPrimitivesTypes.AES__GCM{}
	_this._cryptoPrimitives = (*m_AtomicPrimitives.AtomicPrimitivesClient)(nil)
	return &_this
}

type CompanionStruct_AesWrapKeyMaterial_ struct {
}

var Companion_AesWrapKeyMaterial_ = CompanionStruct_AesWrapKeyMaterial_{}

func (_this *AesWrapKeyMaterial) Equals(other *AesWrapKeyMaterial) bool {
	return _this == other
}

func (_this *AesWrapKeyMaterial) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*AesWrapKeyMaterial)
	return ok && _this.Equals(other)
}

func (*AesWrapKeyMaterial) String() string {
	return "RawAESKeyring.AesWrapKeyMaterial"
}

func Type_AesWrapKeyMaterial_() _dafny.TypeDescriptor {
	return type_AesWrapKeyMaterial_{}
}

type type_AesWrapKeyMaterial_ struct {
}

func (_this type_AesWrapKeyMaterial_) Default() interface{} {
	return (*AesWrapKeyMaterial)(nil)
}

func (_this type_AesWrapKeyMaterial_) String() string {
	return "RawAESKeyring.AesWrapKeyMaterial"
}
func (_this *AesWrapKeyMaterial) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_MaterialWrapping.Companion_WrapMaterial_.TraitID_, m_Actions.Companion_ActionWithResult_.TraitID_, m_Actions.Companion_Action_.TraitID_}
}

var _ m_MaterialWrapping.WrapMaterial = &AesWrapKeyMaterial{}
var _ m_Actions.ActionWithResult = &AesWrapKeyMaterial{}
var _ m_Actions.Action = &AesWrapKeyMaterial{}
var _ _dafny.TraitOffspring = &AesWrapKeyMaterial{}

func (_this *AesWrapKeyMaterial) Ctor__(wrappingKey _dafny.Sequence, wrappingAlgorithm m_AwsCryptographyPrimitivesTypes.AES__GCM, cryptoPrimitives *m_AtomicPrimitives.AtomicPrimitivesClient) {
	{
		(_this)._wrappingKey = wrappingKey
		(_this)._wrappingAlgorithm = wrappingAlgorithm
		(_this)._cryptoPrimitives = cryptoPrimitives
	}
}
func (_this *AesWrapKeyMaterial) Invoke(input interface{}) interface{} {
	{
		var input m_MaterialWrapping.WrapInput = input.(m_MaterialWrapping.WrapInput)
		_ = input
		var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_MaterialWrapping.Companion_WrapOutput_.Default(Companion_AesWrapInfo_.Default()))
		_ = res
		var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _0_valueOrError0
		_0_valueOrError0 = m_CanonicalEncryptionContext.Companion_Default___.EncryptionContextToAAD((input).Dtor_encryptionContext())
		if (_0_valueOrError0).IsFailure() {
			res = (_0_valueOrError0).PropagateFailure()
			return res
		}
		var _1_aad _dafny.Sequence
		_ = _1_aad
		_1_aad = (_0_valueOrError0).Extract().(_dafny.Sequence)
		var _2_randomIvResult m_Wrappers.Result
		_ = _2_randomIvResult
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = ((_this).CryptoPrimitives()).GenerateRandomBytes(m_AwsCryptographyPrimitivesTypes.Companion_GenerateRandomBytesInput_.Create_GenerateRandomBytesInput_(((_this).WrappingAlgorithm()).Dtor_ivLength()))
		_2_randomIvResult = _out0
		var _3_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _3_valueOrError1
		_3_valueOrError1 = (_2_randomIvResult).MapFailure(func(coer122 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg123 interface{}) interface{} {
				return coer122(arg123.(m_AwsCryptographyPrimitivesTypes.Error))
			}
		}(func(_4_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
			return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_4_e)
		}))
		if (_3_valueOrError1).IsFailure() {
			res = (_3_valueOrError1).PropagateFailure()
			return res
		}
		var _5_iv _dafny.Sequence
		_ = _5_iv
		_5_iv = (_3_valueOrError1).Extract().(_dafny.Sequence)
		var _6_aesEncryptResult m_Wrappers.Result
		_ = _6_aesEncryptResult
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = ((_this).CryptoPrimitives()).AESEncrypt(m_AwsCryptographyPrimitivesTypes.Companion_AESEncryptInput_.Create_AESEncryptInput_((_this).WrappingAlgorithm(), _5_iv, (_this).WrappingKey(), (input).Dtor_plaintextMaterial(), _1_aad))
		_6_aesEncryptResult = _out1
		var _7_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_AESEncryptOutput_.Default())
		_ = _7_valueOrError2
		_7_valueOrError2 = (_6_aesEncryptResult).MapFailure(func(coer123 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg124 interface{}) interface{} {
				return coer123(arg124.(m_AwsCryptographyPrimitivesTypes.Error))
			}
		}(func(_8_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
			return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_8_e)
		}))
		if (_7_valueOrError2).IsFailure() {
			res = (_7_valueOrError2).PropagateFailure()
			return res
		}
		var _9_wrappedMaterialResult m_AwsCryptographyPrimitivesTypes.AESEncryptOutput
		_ = _9_wrappedMaterialResult
		_9_wrappedMaterialResult = (_7_valueOrError2).Extract().(m_AwsCryptographyPrimitivesTypes.AESEncryptOutput)
		var _10_wrappedMaterial _dafny.Sequence
		_ = _10_wrappedMaterial
		_10_wrappedMaterial = Companion_Default___.SerializeEDKCiphertext(_9_wrappedMaterialResult)
		res = m_Wrappers.Companion_Result_.Create_Success_(m_MaterialWrapping.Companion_WrapOutput_.Create_WrapOutput_(_10_wrappedMaterial, Companion_AesWrapInfo_.Create_AesWrapInfo_(_5_iv)))
		return res
		return res
	}
}
func (_this *AesWrapKeyMaterial) WrappingKey() _dafny.Sequence {
	{
		return _this._wrappingKey
	}
}
func (_this *AesWrapKeyMaterial) WrappingAlgorithm() m_AwsCryptographyPrimitivesTypes.AES__GCM {
	{
		return _this._wrappingAlgorithm
	}
}
func (_this *AesWrapKeyMaterial) CryptoPrimitives() *m_AtomicPrimitives.AtomicPrimitivesClient {
	{
		return _this._cryptoPrimitives
	}
}

// End of class AesWrapKeyMaterial

// Definition of class AesUnwrapKeyMaterial
type AesUnwrapKeyMaterial struct {
	_wrappingKey       _dafny.Sequence
	_iv                _dafny.Sequence
	_wrappingAlgorithm m_AwsCryptographyPrimitivesTypes.AES__GCM
	_cryptoPrimitives  *m_AtomicPrimitives.AtomicPrimitivesClient
}

func New_AesUnwrapKeyMaterial_() *AesUnwrapKeyMaterial {
	_this := AesUnwrapKeyMaterial{}

	_this._wrappingKey = _dafny.EmptySeq
	_this._iv = _dafny.EmptySeq
	_this._wrappingAlgorithm = m_AwsCryptographyPrimitivesTypes.AES__GCM{}
	_this._cryptoPrimitives = (*m_AtomicPrimitives.AtomicPrimitivesClient)(nil)
	return &_this
}

type CompanionStruct_AesUnwrapKeyMaterial_ struct {
}

var Companion_AesUnwrapKeyMaterial_ = CompanionStruct_AesUnwrapKeyMaterial_{}

func (_this *AesUnwrapKeyMaterial) Equals(other *AesUnwrapKeyMaterial) bool {
	return _this == other
}

func (_this *AesUnwrapKeyMaterial) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*AesUnwrapKeyMaterial)
	return ok && _this.Equals(other)
}

func (*AesUnwrapKeyMaterial) String() string {
	return "RawAESKeyring.AesUnwrapKeyMaterial"
}

func Type_AesUnwrapKeyMaterial_() _dafny.TypeDescriptor {
	return type_AesUnwrapKeyMaterial_{}
}

type type_AesUnwrapKeyMaterial_ struct {
}

func (_this type_AesUnwrapKeyMaterial_) Default() interface{} {
	return (*AesUnwrapKeyMaterial)(nil)
}

func (_this type_AesUnwrapKeyMaterial_) String() string {
	return "RawAESKeyring.AesUnwrapKeyMaterial"
}
func (_this *AesUnwrapKeyMaterial) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_MaterialWrapping.Companion_UnwrapMaterial_.TraitID_, m_Actions.Companion_ActionWithResult_.TraitID_, m_Actions.Companion_Action_.TraitID_}
}

var _ m_MaterialWrapping.UnwrapMaterial = &AesUnwrapKeyMaterial{}
var _ m_Actions.ActionWithResult = &AesUnwrapKeyMaterial{}
var _ m_Actions.Action = &AesUnwrapKeyMaterial{}
var _ _dafny.TraitOffspring = &AesUnwrapKeyMaterial{}

func (_this *AesUnwrapKeyMaterial) Ctor__(wrappingKey _dafny.Sequence, wrappingAlgorithm m_AwsCryptographyPrimitivesTypes.AES__GCM, iv _dafny.Sequence, cryptoPrimitives *m_AtomicPrimitives.AtomicPrimitivesClient) {
	{
		(_this)._wrappingKey = wrappingKey
		(_this)._iv = iv
		(_this)._wrappingAlgorithm = wrappingAlgorithm
		(_this)._cryptoPrimitives = cryptoPrimitives
	}
}
func (_this *AesUnwrapKeyMaterial) Invoke(input interface{}) interface{} {
	{
		var input m_MaterialWrapping.UnwrapInput = input.(m_MaterialWrapping.UnwrapInput)
		_ = input
		var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_MaterialWrapping.Companion_UnwrapOutput_.Default(Companion_AesUnwrapInfo_.Default()))
		_ = res
		var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _0_valueOrError0
		_0_valueOrError0 = m_CanonicalEncryptionContext.Companion_Default___.EncryptionContextToAAD((input).Dtor_encryptionContext())
		if (_0_valueOrError0).IsFailure() {
			res = (_0_valueOrError0).PropagateFailure()
			return res
		}
		var _1_aad _dafny.Sequence
		_ = _1_aad
		_1_aad = (_0_valueOrError0).Extract().(_dafny.Sequence)
		var _2_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _2_valueOrError1
		_2_valueOrError1 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfInt32(((_this).WrappingAlgorithm()).Dtor_tagLength())).Cmp(_dafny.IntOfUint32(((input).Dtor_wrappedMaterial()).Cardinality())) <= 0, m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Insufficient data to decrypt.")))
		if (_2_valueOrError1).IsFailure() {
			res = (_2_valueOrError1).PropagateFailure()
			return res
		}
		var _3_encryptionOutput m_AwsCryptographyPrimitivesTypes.AESEncryptOutput
		_ = _3_encryptionOutput
		_3_encryptionOutput = Companion_Default___.DeserializeEDKCiphertext((input).Dtor_wrappedMaterial(), _dafny.IntOfInt32(((_this).WrappingAlgorithm()).Dtor_tagLength()))
		var _4_maybePtKey m_Wrappers.Result
		_ = _4_maybePtKey
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = ((_this).CryptoPrimitives()).AESDecrypt(m_AwsCryptographyPrimitivesTypes.Companion_AESDecryptInput_.Create_AESDecryptInput_((_this).WrappingAlgorithm(), (_this).WrappingKey(), (_3_encryptionOutput).Dtor_cipherText(), (_3_encryptionOutput).Dtor_authTag(), (_this).Iv(), _1_aad))
		_4_maybePtKey = _out0
		var _5_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _5_valueOrError2
		_5_valueOrError2 = (_4_maybePtKey).MapFailure(func(coer124 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg125 interface{}) interface{} {
				return coer124(arg125.(m_AwsCryptographyPrimitivesTypes.Error))
			}
		}(func(_6_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
			return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_6_e)
		}))
		if (_5_valueOrError2).IsFailure() {
			res = (_5_valueOrError2).PropagateFailure()
			return res
		}
		var _7_ptKey _dafny.Sequence
		_ = _7_ptKey
		_7_ptKey = (_5_valueOrError2).Extract().(_dafny.Sequence)
		var _8_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _8_valueOrError3
		_8_valueOrError3 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfInt32(m_AlgorithmSuites.Companion_Default___.GetEncryptKeyLength((input).Dtor_algorithmSuite()))).Cmp(_dafny.IntOfUint32((_7_ptKey).Cardinality())) == 0, m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Plaintext Data Key is not the expected length")))
		if (_8_valueOrError3).IsFailure() {
			res = (_8_valueOrError3).PropagateFailure()
			return res
		}
		res = m_Wrappers.Companion_Result_.Create_Success_(m_MaterialWrapping.Companion_UnwrapOutput_.Create_UnwrapOutput_(_7_ptKey, Companion_AesUnwrapInfo_.Create_AesUnwrapInfo_()))
		return res
		return res
	}
}
func (_this *AesUnwrapKeyMaterial) WrappingKey() _dafny.Sequence {
	{
		return _this._wrappingKey
	}
}
func (_this *AesUnwrapKeyMaterial) Iv() _dafny.Sequence {
	{
		return _this._iv
	}
}
func (_this *AesUnwrapKeyMaterial) WrappingAlgorithm() m_AwsCryptographyPrimitivesTypes.AES__GCM {
	{
		return _this._wrappingAlgorithm
	}
}
func (_this *AesUnwrapKeyMaterial) CryptoPrimitives() *m_AtomicPrimitives.AtomicPrimitivesClient {
	{
		return _this._cryptoPrimitives
	}
}

// End of class AesUnwrapKeyMaterial
