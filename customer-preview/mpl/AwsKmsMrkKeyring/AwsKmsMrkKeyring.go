// Package AwsKmsMrkKeyring
// Dafny module AwsKmsMrkKeyring compiled into Go

package AwsKmsMrkKeyring

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
	m_AwsKmsKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsKeyring"
	m_AwsKmsMrkAreUnique "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkAreUnique"
	m_AwsKmsMrkDiscoveryKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkDiscoveryKeyring"
	m_AwsKmsMrkMatchForDecrypt "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkMatchForDecrypt"
	m_AwsKmsUtils "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsUtils"
	m_CanonicalEncryptionContext "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CanonicalEncryptionContext"
	m_Constants "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Constants"
	m_CreateKeyStoreTable "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CreateKeyStoreTable"
	m_CreateKeys "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CreateKeys"
	m_DDBKeystoreOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/DDBKeystoreOperations"
	m_DiscoveryMultiKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/DiscoveryMultiKeyring"
	m_EdkWrapping "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/EdkWrapping"
	m_ErrorMessages "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/ErrorMessages"
	m_GetKeys "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/GetKeys"
	m_IntermediateKeyWrapping "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/IntermediateKeyWrapping"
	m_KMSKeystoreOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KMSKeystoreOperations"
	m_KeyStore "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KeyStore"
	m_KeyStoreErrorMessages "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KeyStoreErrorMessages"
	m_Keyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Keyring"
	m_KmsArn "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KmsArn"
	m_MaterialWrapping "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/MaterialWrapping"
	m_Materials "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Materials"
	m_MrkAwareDiscoveryMultiKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/MrkAwareDiscoveryMultiKeyring"
	m_MultiKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/MultiKeyring"
	m_StrictMultiKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/StrictMultiKeyring"
	m_Structure "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Structure"
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

type Dummy__ struct{}

// Definition of class AwsKmsMrkKeyring
type AwsKmsMrkKeyring struct {
	_client      m_ComAmazonawsKmsTypes.IKMSClient
	_awsKmsKey   _dafny.Sequence
	_grantTokens _dafny.Sequence
	_awsKmsArn   m_AwsArnParsing.AwsKmsIdentifier
}

func New_AwsKmsMrkKeyring_() *AwsKmsMrkKeyring {
	_this := AwsKmsMrkKeyring{}

	_this._client = (m_ComAmazonawsKmsTypes.IKMSClient)(nil)
	_this._awsKmsKey = _dafny.EmptySeq.SetString()
	_this._grantTokens = _dafny.EmptySeq
	_this._awsKmsArn = m_AwsArnParsing.AwsKmsIdentifier{}
	return &_this
}

type CompanionStruct_AwsKmsMrkKeyring_ struct {
}

var Companion_AwsKmsMrkKeyring_ = CompanionStruct_AwsKmsMrkKeyring_{}

func (_this *AwsKmsMrkKeyring) Equals(other *AwsKmsMrkKeyring) bool {
	return _this == other
}

func (_this *AwsKmsMrkKeyring) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*AwsKmsMrkKeyring)
	return ok && _this.Equals(other)
}

func (*AwsKmsMrkKeyring) String() string {
	return "AwsKmsMrkKeyring.AwsKmsMrkKeyring"
}

func Type_AwsKmsMrkKeyring_() _dafny.TypeDescriptor {
	return type_AwsKmsMrkKeyring_{}
}

type type_AwsKmsMrkKeyring_ struct {
}

func (_this type_AwsKmsMrkKeyring_) Default() interface{} {
	return (*AwsKmsMrkKeyring)(nil)
}

func (_this type_AwsKmsMrkKeyring_) String() string {
	return "AwsKmsMrkKeyring.AwsKmsMrkKeyring"
}
func (_this *AwsKmsMrkKeyring) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_Keyring.Companion_VerifiableInterface_.TraitID_, m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.TraitID_}
}

var _ m_Keyring.VerifiableInterface = &AwsKmsMrkKeyring{}
var _ m_AwsCryptographyMaterialProvidersTypes.IKeyring = &AwsKmsMrkKeyring{}
var _ _dafny.TraitOffspring = &AwsKmsMrkKeyring{}

func (_this *AwsKmsMrkKeyring) OnDecrypt(input m_AwsCryptographyMaterialProvidersTypes.OnDecryptInput) m_Wrappers.Result {
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.OnDecrypt(_this, input)
	return _out5
}
func (_this *AwsKmsMrkKeyring) OnEncrypt(input m_AwsCryptographyMaterialProvidersTypes.OnEncryptInput) m_Wrappers.Result {
	var _out5 m_Wrappers.Result
	_ = _out5
	_out5 = m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.OnEncrypt(_this, input)
	return _out5
}
func (_this *AwsKmsMrkKeyring) Ctor__(client m_ComAmazonawsKmsTypes.IKMSClient, awsKmsKey _dafny.Sequence, grantTokens _dafny.Sequence) {
	{
		var _0_parsedAwsKmsId m_Wrappers.Result
		_ = _0_parsedAwsKmsId
		_0_parsedAwsKmsId = m_AwsArnParsing.Companion_Default___.ParseAwsKmsIdentifier(awsKmsKey)
		(_this)._client = client
		(_this)._awsKmsKey = awsKmsKey
		(_this)._awsKmsArn = (_0_parsedAwsKmsId).Dtor_value().(m_AwsArnParsing.AwsKmsIdentifier)
		(_this)._grantTokens = grantTokens
	}
}
func (_this *AwsKmsMrkKeyring) OnEncrypt_k(input m_AwsCryptographyMaterialProvidersTypes.OnEncryptInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _0_materials m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials
		_ = _0_materials
		_0_materials = (input).Dtor_materials()
		var _1_suite m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo
		_ = _1_suite
		_1_suite = ((input).Dtor_materials()).Dtor_algorithmSuite()
		var _2_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
		_ = _2_valueOrError0
		_2_valueOrError0 = m_AwsKmsUtils.Companion_Default___.StringifyEncryptionContext(((input).Dtor_materials()).Dtor_encryptionContext())
		if (_2_valueOrError0).IsFailure() {
			output = (_2_valueOrError0).PropagateFailure()
			return output
		}
		var _3_stringifiedEncCtx _dafny.Map
		_ = _3_stringifiedEncCtx
		_3_stringifiedEncCtx = (_2_valueOrError0).Extract().(_dafny.Map)
		var _4_kmsGenerateAndWrap *m_AwsKmsKeyring.KmsGenerateAndWrapKeyMaterial
		_ = _4_kmsGenerateAndWrap
		var _nw0 *m_AwsKmsKeyring.KmsGenerateAndWrapKeyMaterial = m_AwsKmsKeyring.New_KmsGenerateAndWrapKeyMaterial_()
		_ = _nw0
		_nw0.Ctor__((_this).Client(), (_this).AwsKmsKey(), (_this).GrantTokens())
		_4_kmsGenerateAndWrap = _nw0
		var _5_kmsWrap *m_AwsKmsKeyring.KmsWrapKeyMaterial
		_ = _5_kmsWrap
		var _nw1 *m_AwsKmsKeyring.KmsWrapKeyMaterial = m_AwsKmsKeyring.New_KmsWrapKeyMaterial_()
		_ = _nw1
		_nw1.Ctor__((_this).Client(), (_this).AwsKmsKey(), (_this).GrantTokens())
		_5_kmsWrap = _nw1
		var _6_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_EdkWrapping.Companion_WrapEdkMaterialOutput_.Default(m_AwsKmsKeyring.Companion_KmsWrapInfo_.Default()))
		_ = _6_valueOrError1
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_EdkWrapping.Companion_Default___.WrapEdkMaterial(_0_materials, _5_kmsWrap, _4_kmsGenerateAndWrap)
		_6_valueOrError1 = _out0
		if (_6_valueOrError1).IsFailure() {
			output = (_6_valueOrError1).PropagateFailure()
			return output
		}
		var _7_wrapOutput m_EdkWrapping.WrapEdkMaterialOutput
		_ = _7_wrapOutput
		_7_wrapOutput = (_6_valueOrError1).Extract().(m_EdkWrapping.WrapEdkMaterialOutput)
		var _8_kmsKeyArn _dafny.Sequence
		_ = _8_kmsKeyArn
		_8_kmsKeyArn = ((_7_wrapOutput).Dtor_wrapInfo().(m_AwsKmsKeyring.KmsWrapInfo)).Dtor_kmsKeyArn()
		var _9_symmetricSigningKeyList m_Wrappers.Option
		_ = _9_symmetricSigningKeyList
		if ((_7_wrapOutput).Dtor_symmetricSigningKey()).Is_Some() {
			_9_symmetricSigningKeyList = m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(((_7_wrapOutput).Dtor_symmetricSigningKey()).Dtor_value().(_dafny.Sequence)))
		} else {
			_9_symmetricSigningKeyList = m_Wrappers.Companion_Option_.Create_None_()
		}
		var _10_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_UTF8.Companion_ValidUTF8Bytes_.Witness())
		_ = _10_valueOrError2
		_10_valueOrError2 = (m_UTF8.Encode(_8_kmsKeyArn)).MapFailure(func(coer69 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg70 interface{}) interface{} {
				return coer69(arg70.(_dafny.Sequence))
			}
		}(m_AwsKmsUtils.Companion_Default___.WrapStringToError))
		if (_10_valueOrError2).IsFailure() {
			output = (_10_valueOrError2).PropagateFailure()
			return output
		}
		var _11_providerInfo _dafny.Sequence
		_ = _11_providerInfo
		_11_providerInfo = (_10_valueOrError2).Extract().(_dafny.Sequence)
		var _12_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _12_valueOrError3
		_12_valueOrError3 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((_11_providerInfo).Cardinality())).Cmp(m_StandardLibrary_UInt.Companion_Default___.UINT16__LIMIT()) < 0, m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Invalid response from AWS KMS GenerateDataKey: Key ID too long.")))
		if (_12_valueOrError3).IsFailure() {
			output = (_12_valueOrError3).PropagateFailure()
			return output
		}
		var _13_edk m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey
		_ = _13_edk
		_13_edk = m_AwsCryptographyMaterialProvidersTypes.Companion_EncryptedDataKey_.Create_EncryptedDataKey_(m_Constants.Companion_Default___.PROVIDER__ID(), _11_providerInfo, (_7_wrapOutput).Dtor_wrappedMaterial())
		if (_7_wrapOutput).Is_GenerateAndWrapEdkMaterialOutput() {
			var _14_valueOrError4 m_Wrappers.Result = m_Wrappers.Result{}
			_ = _14_valueOrError4
			_14_valueOrError4 = m_Materials.Companion_Default___.EncryptionMaterialAddDataKey(_0_materials, (_7_wrapOutput).Dtor_plaintextDataKey(), _dafny.SeqOf(_13_edk), _9_symmetricSigningKeyList)
			if (_14_valueOrError4).IsFailure() {
				output = (_14_valueOrError4).PropagateFailure()
				return output
			}
			var _15_result m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials
			_ = _15_result
			_15_result = (_14_valueOrError4).Extract().(m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials)
			output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyMaterialProvidersTypes.Companion_OnEncryptOutput_.Create_OnEncryptOutput_(_15_result))
			return output
		} else if (_7_wrapOutput).Is_WrapOnlyEdkMaterialOutput() {
			var _16_valueOrError5 m_Wrappers.Result = m_Wrappers.Result{}
			_ = _16_valueOrError5
			_16_valueOrError5 = m_Materials.Companion_Default___.EncryptionMaterialAddEncryptedDataKeys(_0_materials, _dafny.SeqOf(_13_edk), _9_symmetricSigningKeyList)
			if (_16_valueOrError5).IsFailure() {
				output = (_16_valueOrError5).PropagateFailure()
				return output
			}
			var _17_result m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials
			_ = _17_result
			_17_result = (_16_valueOrError5).Extract().(m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials)
			output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyMaterialProvidersTypes.Companion_OnEncryptOutput_.Create_OnEncryptOutput_(_17_result))
			return output
		}
		return output
	}
}
func (_this *AwsKmsMrkKeyring) OnDecrypt_k(input m_AwsCryptographyMaterialProvidersTypes.OnDecryptInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _0_materials m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials
		_ = _0_materials
		_0_materials = (input).Dtor_materials()
		var _1_suite m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo
		_ = _1_suite
		_1_suite = ((input).Dtor_materials()).Dtor_algorithmSuite()
		var _2_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _2_valueOrError0
		_2_valueOrError0 = m_Wrappers.Companion_Default___.Need(m_Materials.Companion_Default___.DecryptionMaterialsWithoutPlaintextDataKey(_0_materials), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Keyring received decryption materials that already contain a plaintext data key.")))
		if (_2_valueOrError0).IsFailure() {
			output = (_2_valueOrError0).PropagateFailure()
			return output
		}
		var _3_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _3_valueOrError1
		_3_valueOrError1 = m_AwsKmsUtils.Companion_Default___.OkForDecrypt((_this).AwsKmsArn(), (_this).AwsKmsKey())
		if (_3_valueOrError1).IsFailure() {
			output = (_3_valueOrError1).PropagateFailure()
			return output
		}
		var _4_filter *m_AwsKmsUtils.OnDecryptMrkAwareEncryptedDataKeyFilter
		_ = _4_filter
		var _nw0 *m_AwsKmsUtils.OnDecryptMrkAwareEncryptedDataKeyFilter = m_AwsKmsUtils.New_OnDecryptMrkAwareEncryptedDataKeyFilter_()
		_ = _nw0
		_nw0.Ctor__((_this).AwsKmsArn(), m_Constants.Companion_Default___.PROVIDER__ID())
		_4_filter = _nw0
		var _5_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _5_valueOrError2
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_Actions.Companion_Default___.FilterWithResult(_4_filter, (input).Dtor_encryptedDataKeys())
		_5_valueOrError2 = _out0
		if (_5_valueOrError2).IsFailure() {
			output = (_5_valueOrError2).PropagateFailure()
			return output
		}
		var _6_edksToAttempt _dafny.Sequence
		_ = _6_edksToAttempt
		_6_edksToAttempt = (_5_valueOrError2).Extract().(_dafny.Sequence)
		if (_dafny.IntOfUint32((_6_edksToAttempt).Cardinality())).Sign() == 0 {
			var _7_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
			_ = _7_valueOrError3
			_7_valueOrError3 = m_ErrorMessages.Companion_Default___.IncorrectDataKeys((input).Dtor_encryptedDataKeys(), ((input).Dtor_materials()).Dtor_algorithmSuite(), _dafny.SeqOfString(""))
			if (_7_valueOrError3).IsFailure() {
				output = (_7_valueOrError3).PropagateFailure()
				return output
			}
			var _8_errorMessage _dafny.Sequence
			_ = _8_errorMessage
			_8_errorMessage = (_7_valueOrError3).Extract().(_dafny.Sequence)
			output = m_Wrappers.Companion_Result_.Create_Failure_(m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_8_errorMessage))
			return output
		}
		var _9_decryptClosure *DecryptSingleEncryptedDataKey
		_ = _9_decryptClosure
		var _nw1 *DecryptSingleEncryptedDataKey = New_DecryptSingleEncryptedDataKey_()
		_ = _nw1
		_nw1.Ctor__(_0_materials, (_this).Client(), (_this).AwsKmsKey(), (_this).GrantTokens())
		_9_decryptClosure = _nw1
		var _10_outcome m_Wrappers.Result
		_ = _10_outcome
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = m_Actions.Companion_Default___.ReduceToSuccess(_9_decryptClosure, _6_edksToAttempt)
		_10_outcome = _out1
		var _11_valueOrError4 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _11_valueOrError4
		_11_valueOrError4 = (_10_outcome).MapFailure(func(coer70 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg71 interface{}) interface{} {
				return coer70(arg71.(_dafny.Sequence))
			}
		}(func(_12_errors _dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error {
			return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_CollectionOfErrors_(_12_errors, _dafny.SeqOfString("No Configured KMS Key was able to decrypt the Data Key. The list of encountered Exceptions is available via `list`."))
		}))
		if (_11_valueOrError4).IsFailure() {
			output = (_11_valueOrError4).PropagateFailure()
			return output
		}
		var _13_SealedDecryptionMaterials m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials
		_ = _13_SealedDecryptionMaterials
		_13_SealedDecryptionMaterials = (_11_valueOrError4).Extract().(m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials)
		output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyMaterialProvidersTypes.Companion_OnDecryptOutput_.Create_OnDecryptOutput_(_13_SealedDecryptionMaterials))
		return output
		return output
	}
}
func (_this *AwsKmsMrkKeyring) Client() m_ComAmazonawsKmsTypes.IKMSClient {
	{
		return _this._client
	}
}
func (_this *AwsKmsMrkKeyring) AwsKmsKey() _dafny.Sequence {
	{
		return _this._awsKmsKey
	}
}
func (_this *AwsKmsMrkKeyring) GrantTokens() _dafny.Sequence {
	{
		return _this._grantTokens
	}
}
func (_this *AwsKmsMrkKeyring) AwsKmsArn() m_AwsArnParsing.AwsKmsIdentifier {
	{
		return _this._awsKmsArn
	}
}

// End of class AwsKmsMrkKeyring

// Definition of class DecryptSingleEncryptedDataKey
type DecryptSingleEncryptedDataKey struct {
	_materials   m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials
	_client      m_ComAmazonawsKmsTypes.IKMSClient
	_awsKmsKey   _dafny.Sequence
	_grantTokens _dafny.Sequence
}

func New_DecryptSingleEncryptedDataKey_() *DecryptSingleEncryptedDataKey {
	_this := DecryptSingleEncryptedDataKey{}

	_this._materials = m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials{}
	_this._client = (m_ComAmazonawsKmsTypes.IKMSClient)(nil)
	_this._awsKmsKey = _dafny.EmptySeq.SetString()
	_this._grantTokens = _dafny.EmptySeq
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
	return "AwsKmsMrkKeyring.DecryptSingleEncryptedDataKey"
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
	return "AwsKmsMrkKeyring.DecryptSingleEncryptedDataKey"
}
func (_this *DecryptSingleEncryptedDataKey) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_Actions.Companion_ActionWithResult_.TraitID_, m_Actions.Companion_Action_.TraitID_}
}

var _ m_Actions.ActionWithResult = &DecryptSingleEncryptedDataKey{}
var _ m_Actions.Action = &DecryptSingleEncryptedDataKey{}
var _ _dafny.TraitOffspring = &DecryptSingleEncryptedDataKey{}

func (_this *DecryptSingleEncryptedDataKey) Ctor__(materials m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials, client m_ComAmazonawsKmsTypes.IKMSClient, awsKmsKey _dafny.Sequence, grantTokens _dafny.Sequence) {
	{
		(_this)._materials = materials
		(_this)._client = client
		(_this)._awsKmsKey = awsKmsKey
		(_this)._grantTokens = grantTokens
	}
}
func (_this *DecryptSingleEncryptedDataKey) Invoke(edk interface{}) interface{} {
	{
		var edk m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey = edk.(m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey)
		_ = edk
		var res m_Wrappers.Result = m_Wrappers.Result{}
		_ = res
		var _0_kmsUnwrap *m_AwsKmsKeyring.KmsUnwrapKeyMaterial
		_ = _0_kmsUnwrap
		var _nw0 *m_AwsKmsKeyring.KmsUnwrapKeyMaterial = m_AwsKmsKeyring.New_KmsUnwrapKeyMaterial_()
		_ = _nw0
		_nw0.Ctor__((_this).Client(), (_this).AwsKmsKey(), (_this).GrantTokens())
		_0_kmsUnwrap = _nw0
		var _1_unwrapOutputRes m_Wrappers.Result
		_ = _1_unwrapOutputRes
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_EdkWrapping.Companion_Default___.UnwrapEdkMaterial((edk).Dtor_ciphertext(), (_this).Materials(), _0_kmsUnwrap)
		_1_unwrapOutputRes = _out0
		var _2_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_EdkWrapping.Companion_UnwrapEdkMaterialOutput_.Default(m_AwsKmsKeyring.Companion_KmsUnwrapInfo_.Default()))
		_ = _2_valueOrError0
		_2_valueOrError0 = _1_unwrapOutputRes
		if (_2_valueOrError0).IsFailure() {
			res = (_2_valueOrError0).PropagateFailure()
			return res
		}
		var _3_unwrapOutput m_EdkWrapping.UnwrapEdkMaterialOutput
		_ = _3_unwrapOutput
		_3_unwrapOutput = (_2_valueOrError0).Extract().(m_EdkWrapping.UnwrapEdkMaterialOutput)
		var _4_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _4_valueOrError1
		_4_valueOrError1 = m_Materials.Companion_Default___.DecryptionMaterialsAddDataKey((_this).Materials(), (_3_unwrapOutput).Dtor_plaintextDataKey(), (_3_unwrapOutput).Dtor_symmetricSigningKey())
		if (_4_valueOrError1).IsFailure() {
			res = (_4_valueOrError1).PropagateFailure()
			return res
		}
		var _5_result m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials
		_ = _5_result
		_5_result = (_4_valueOrError1).Extract().(m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials)
		res = m_Wrappers.Companion_Result_.Create_Success_(_5_result)
		return res
		return res
	}
}
func (_this *DecryptSingleEncryptedDataKey) Materials() m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials {
	{
		return _this._materials
	}
}
func (_this *DecryptSingleEncryptedDataKey) Client() m_ComAmazonawsKmsTypes.IKMSClient {
	{
		return _this._client
	}
}
func (_this *DecryptSingleEncryptedDataKey) AwsKmsKey() _dafny.Sequence {
	{
		return _this._awsKmsKey
	}
}
func (_this *DecryptSingleEncryptedDataKey) GrantTokens() _dafny.Sequence {
	{
		return _this._grantTokens
	}
}

// End of class DecryptSingleEncryptedDataKey
