// Package AwsKmsKeyring
// Dafny module AwsKmsKeyring compiled into Go

package AwsKmsKeyring

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
	m_AwsKmsMrkAreUnique "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkAreUnique"
	m_AwsKmsMrkMatchForDecrypt "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkMatchForDecrypt"
	m_AwsKmsUtils "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsUtils"
	m_CanonicalEncryptionContext "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CanonicalEncryptionContext"
	m_Constants "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Constants"
	m_CreateKeyStoreTable "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CreateKeyStoreTable"
	m_CreateKeys "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CreateKeys"
	m_DDBKeystoreOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/DDBKeystoreOperations"
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
	m_MultiKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/MultiKeyring"
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

type Dummy__ struct{}

// Definition of class AwsKmsKeyring
type AwsKmsKeyring struct {
	_client      m_ComAmazonawsKmsTypes.IKMSClient
	_awsKmsKey   _dafny.Sequence
	_grantTokens _dafny.Sequence
	_awsKmsArn   m_AwsArnParsing.AwsKmsIdentifier
}

func New_AwsKmsKeyring_() *AwsKmsKeyring {
	_this := AwsKmsKeyring{}

	_this._client = (m_ComAmazonawsKmsTypes.IKMSClient)(nil)
	_this._awsKmsKey = _dafny.EmptySeq.SetString()
	_this._grantTokens = _dafny.EmptySeq
	_this._awsKmsArn = m_AwsArnParsing.AwsKmsIdentifier{}
	return &_this
}

type CompanionStruct_AwsKmsKeyring_ struct {
}

var Companion_AwsKmsKeyring_ = CompanionStruct_AwsKmsKeyring_{}

func (_this *AwsKmsKeyring) Equals(other *AwsKmsKeyring) bool {
	return _this == other
}

func (_this *AwsKmsKeyring) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*AwsKmsKeyring)
	return ok && _this.Equals(other)
}

func (*AwsKmsKeyring) String() string {
	return "AwsKmsKeyring.AwsKmsKeyring"
}

func Type_AwsKmsKeyring_() _dafny.TypeDescriptor {
	return type_AwsKmsKeyring_{}
}

type type_AwsKmsKeyring_ struct {
}

func (_this type_AwsKmsKeyring_) Default() interface{} {
	return (*AwsKmsKeyring)(nil)
}

func (_this type_AwsKmsKeyring_) String() string {
	return "AwsKmsKeyring.AwsKmsKeyring"
}
func (_this *AwsKmsKeyring) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_Keyring.Companion_VerifiableInterface_.TraitID_, m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.TraitID_}
}

var _ m_Keyring.VerifiableInterface = &AwsKmsKeyring{}
var _ m_AwsCryptographyMaterialProvidersTypes.IKeyring = &AwsKmsKeyring{}
var _ _dafny.TraitOffspring = &AwsKmsKeyring{}

func (_this *AwsKmsKeyring) OnDecrypt(input m_AwsCryptographyMaterialProvidersTypes.OnDecryptInput) m_Wrappers.Result {
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.OnDecrypt(_this, input)
	return _out2
}
func (_this *AwsKmsKeyring) OnEncrypt(input m_AwsCryptographyMaterialProvidersTypes.OnEncryptInput) m_Wrappers.Result {
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.OnEncrypt(_this, input)
	return _out2
}
func (_this *AwsKmsKeyring) Ctor__(client m_ComAmazonawsKmsTypes.IKMSClient, awsKmsKey _dafny.Sequence, grantTokens _dafny.Sequence) {
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
func (_this *AwsKmsKeyring) OnEncrypt_k(input m_AwsCryptographyMaterialProvidersTypes.OnEncryptInput) m_Wrappers.Result {
	{
		var res m_Wrappers.Result = m_Wrappers.Result{}
		_ = res
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
			res = (_2_valueOrError0).PropagateFailure()
			return res
		}
		var _3_stringifiedEncCtx _dafny.Map
		_ = _3_stringifiedEncCtx
		_3_stringifiedEncCtx = (_2_valueOrError0).Extract().(_dafny.Map)
		var _4_kmsGenerateAndWrap *KmsGenerateAndWrapKeyMaterial
		_ = _4_kmsGenerateAndWrap
		var _nw0 *KmsGenerateAndWrapKeyMaterial = New_KmsGenerateAndWrapKeyMaterial_()
		_ = _nw0
		_nw0.Ctor__((_this).Client(), (_this).AwsKmsKey(), (_this).GrantTokens())
		_4_kmsGenerateAndWrap = _nw0
		var _5_kmsWrap *KmsWrapKeyMaterial
		_ = _5_kmsWrap
		var _nw1 *KmsWrapKeyMaterial = New_KmsWrapKeyMaterial_()
		_ = _nw1
		_nw1.Ctor__((_this).Client(), (_this).AwsKmsKey(), (_this).GrantTokens())
		_5_kmsWrap = _nw1
		var _6_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_EdkWrapping.Companion_WrapEdkMaterialOutput_.Default(Companion_KmsWrapInfo_.Default()))
		_ = _6_valueOrError1
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_EdkWrapping.Companion_Default___.WrapEdkMaterial(_0_materials, _5_kmsWrap, _4_kmsGenerateAndWrap)
		_6_valueOrError1 = _out0
		if (_6_valueOrError1).IsFailure() {
			res = (_6_valueOrError1).PropagateFailure()
			return res
		}
		var _7_wrapOutput m_EdkWrapping.WrapEdkMaterialOutput
		_ = _7_wrapOutput
		_7_wrapOutput = (_6_valueOrError1).Extract().(m_EdkWrapping.WrapEdkMaterialOutput)
		var _8_kmsKeyArn _dafny.Sequence
		_ = _8_kmsKeyArn
		_8_kmsKeyArn = ((_7_wrapOutput).Dtor_wrapInfo().(KmsWrapInfo)).Dtor_kmsKeyArn()
		var _9_symmetricSigningKeyList m_Wrappers.Option
		_ = _9_symmetricSigningKeyList
		if ((_7_wrapOutput).Dtor_symmetricSigningKey()).Is_Some() {
			_9_symmetricSigningKeyList = m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf(((_7_wrapOutput).Dtor_symmetricSigningKey()).Dtor_value().(_dafny.Sequence)))
		} else {
			_9_symmetricSigningKeyList = m_Wrappers.Companion_Option_.Create_None_()
		}
		var _10_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_UTF8.Companion_ValidUTF8Bytes_.Witness())
		_ = _10_valueOrError2
		_10_valueOrError2 = (m_UTF8.Encode(_8_kmsKeyArn)).MapFailure(func(coer52 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg53 interface{}) interface{} {
				return coer52(arg53.(_dafny.Sequence))
			}
		}(m_AwsKmsUtils.Companion_Default___.WrapStringToError))
		if (_10_valueOrError2).IsFailure() {
			res = (_10_valueOrError2).PropagateFailure()
			return res
		}
		var _11_providerInfo _dafny.Sequence
		_ = _11_providerInfo
		_11_providerInfo = (_10_valueOrError2).Extract().(_dafny.Sequence)
		var _12_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _12_valueOrError3
		_12_valueOrError3 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((_11_providerInfo).Cardinality())).Cmp(m_StandardLibrary_UInt.Companion_Default___.UINT16__LIMIT()) < 0, m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Invalid response from AWS KMS GenerateDataKey: Key ID too long.")))
		if (_12_valueOrError3).IsFailure() {
			res = (_12_valueOrError3).PropagateFailure()
			return res
		}
		var _13_edk m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey
		_ = _13_edk
		_13_edk = m_AwsCryptographyMaterialProvidersTypes.Companion_EncryptedDataKey_.Create_EncryptedDataKey_(m_Constants.Companion_Default___.PROVIDER__ID(), _11_providerInfo, (_7_wrapOutput).Dtor_wrappedMaterial())
		if (_7_wrapOutput).Is_GenerateAndWrapEdkMaterialOutput() {
			var _14_valueOrError4 m_Wrappers.Result = m_Wrappers.Result{}
			_ = _14_valueOrError4
			_14_valueOrError4 = m_Materials.Companion_Default___.EncryptionMaterialAddDataKey(_0_materials, (_7_wrapOutput).Dtor_plaintextDataKey(), _dafny.SeqOf(_13_edk), _9_symmetricSigningKeyList)
			if (_14_valueOrError4).IsFailure() {
				res = (_14_valueOrError4).PropagateFailure()
				return res
			}
			var _15_result m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials
			_ = _15_result
			_15_result = (_14_valueOrError4).Extract().(m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials)
			res = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyMaterialProvidersTypes.Companion_OnEncryptOutput_.Create_OnEncryptOutput_(_15_result))
			return res
		} else if (_7_wrapOutput).Is_WrapOnlyEdkMaterialOutput() {
			var _16_valueOrError5 m_Wrappers.Result = m_Wrappers.Result{}
			_ = _16_valueOrError5
			_16_valueOrError5 = m_Materials.Companion_Default___.EncryptionMaterialAddEncryptedDataKeys(_0_materials, _dafny.SeqOf(_13_edk), _9_symmetricSigningKeyList)
			if (_16_valueOrError5).IsFailure() {
				res = (_16_valueOrError5).PropagateFailure()
				return res
			}
			var _17_result m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials
			_ = _17_result
			_17_result = (_16_valueOrError5).Extract().(m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials)
			res = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyMaterialProvidersTypes.Companion_OnEncryptOutput_.Create_OnEncryptOutput_(_17_result))
			return res
		}
		return res
	}
}
func (_this *AwsKmsKeyring) OnDecrypt_k(input m_AwsCryptographyMaterialProvidersTypes.OnDecryptInput) m_Wrappers.Result {
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
		_2_valueOrError0 = m_Wrappers.Companion_Default___.Need(m_Materials.Companion_Default___.DecryptionMaterialsWithoutPlaintextDataKey(_0_materials), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Keyring received decryption materials that already contain a plaintext data key.")))
		if (_2_valueOrError0).IsFailure() {
			res = (_2_valueOrError0).PropagateFailure()
			return res
		}
		var _3_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _3_valueOrError1
		_3_valueOrError1 = m_AwsKmsUtils.Companion_Default___.OkForDecrypt((_this).AwsKmsArn(), (_this).AwsKmsKey())
		if (_3_valueOrError1).IsFailure() {
			res = (_3_valueOrError1).PropagateFailure()
			return res
		}
		var _4_filter *OnDecryptEncryptedDataKeyFilter
		_ = _4_filter
		var _nw0 *OnDecryptEncryptedDataKeyFilter = New_OnDecryptEncryptedDataKeyFilter_()
		_ = _nw0
		_nw0.Ctor__((_this).AwsKmsKey())
		_4_filter = _nw0
		var _5_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _5_valueOrError2
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_Actions.Companion_Default___.FilterWithResult(_4_filter, (input).Dtor_encryptedDataKeys())
		_5_valueOrError2 = _out0
		if (_5_valueOrError2).IsFailure() {
			res = (_5_valueOrError2).PropagateFailure()
			return res
		}
		var _6_edksToAttempt _dafny.Sequence
		_ = _6_edksToAttempt
		_6_edksToAttempt = (_5_valueOrError2).Extract().(_dafny.Sequence)
		if (_dafny.IntOfUint32((_6_edksToAttempt).Cardinality())).Sign() == 0 {
			var _7_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
			_ = _7_valueOrError3
			_7_valueOrError3 = m_ErrorMessages.Companion_Default___.IncorrectDataKeys((input).Dtor_encryptedDataKeys(), ((input).Dtor_materials()).Dtor_algorithmSuite(), _dafny.SeqOfString(""))
			if (_7_valueOrError3).IsFailure() {
				res = (_7_valueOrError3).PropagateFailure()
				return res
			}
			var _8_errorMessage _dafny.Sequence
			_ = _8_errorMessage
			_8_errorMessage = (_7_valueOrError3).Extract().(_dafny.Sequence)
			res = m_Wrappers.Companion_Result_.Create_Failure_(m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_8_errorMessage))
			return res
		}
		var _9_decryptClosure m_Actions.ActionWithResult
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
		_11_valueOrError4 = (_10_outcome).MapFailure(func(coer53 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg54 interface{}) interface{} {
				return coer53(arg54.(_dafny.Sequence))
			}
		}(func(_12_errors _dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error {
			return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_CollectionOfErrors_(_12_errors, _dafny.SeqOfString("No Configured KMS Key was able to decrypt the Data Key. The list of encountered Exceptions is available via `list`."))
		}))
		if (_11_valueOrError4).IsFailure() {
			res = (_11_valueOrError4).PropagateFailure()
			return res
		}
		var _13_SealedDecryptionMaterials m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials
		_ = _13_SealedDecryptionMaterials
		_13_SealedDecryptionMaterials = (_11_valueOrError4).Extract().(m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials)
		res = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyMaterialProvidersTypes.Companion_OnDecryptOutput_.Create_OnDecryptOutput_(_13_SealedDecryptionMaterials))
		return res
		return res
	}
}
func (_this *AwsKmsKeyring) Client() m_ComAmazonawsKmsTypes.IKMSClient {
	{
		return _this._client
	}
}
func (_this *AwsKmsKeyring) AwsKmsKey() _dafny.Sequence {
	{
		return _this._awsKmsKey
	}
}
func (_this *AwsKmsKeyring) GrantTokens() _dafny.Sequence {
	{
		return _this._grantTokens
	}
}
func (_this *AwsKmsKeyring) AwsKmsArn() m_AwsArnParsing.AwsKmsIdentifier {
	{
		return _this._awsKmsArn
	}
}

// End of class AwsKmsKeyring

// Definition of class OnDecryptEncryptedDataKeyFilter
type OnDecryptEncryptedDataKeyFilter struct {
	_awsKmsKey _dafny.Sequence
}

func New_OnDecryptEncryptedDataKeyFilter_() *OnDecryptEncryptedDataKeyFilter {
	_this := OnDecryptEncryptedDataKeyFilter{}

	_this._awsKmsKey = _dafny.EmptySeq.SetString()
	return &_this
}

type CompanionStruct_OnDecryptEncryptedDataKeyFilter_ struct {
}

var Companion_OnDecryptEncryptedDataKeyFilter_ = CompanionStruct_OnDecryptEncryptedDataKeyFilter_{}

func (_this *OnDecryptEncryptedDataKeyFilter) Equals(other *OnDecryptEncryptedDataKeyFilter) bool {
	return _this == other
}

func (_this *OnDecryptEncryptedDataKeyFilter) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*OnDecryptEncryptedDataKeyFilter)
	return ok && _this.Equals(other)
}

func (*OnDecryptEncryptedDataKeyFilter) String() string {
	return "AwsKmsKeyring.OnDecryptEncryptedDataKeyFilter"
}

func Type_OnDecryptEncryptedDataKeyFilter_() _dafny.TypeDescriptor {
	return type_OnDecryptEncryptedDataKeyFilter_{}
}

type type_OnDecryptEncryptedDataKeyFilter_ struct {
}

func (_this type_OnDecryptEncryptedDataKeyFilter_) Default() interface{} {
	return (*OnDecryptEncryptedDataKeyFilter)(nil)
}

func (_this type_OnDecryptEncryptedDataKeyFilter_) String() string {
	return "AwsKmsKeyring.OnDecryptEncryptedDataKeyFilter"
}
func (_this *OnDecryptEncryptedDataKeyFilter) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_Actions.Companion_DeterministicActionWithResult_.TraitID_, m_Actions.Companion_DeterministicAction_.TraitID_}
}

var _ m_Actions.DeterministicActionWithResult = &OnDecryptEncryptedDataKeyFilter{}
var _ m_Actions.DeterministicAction = &OnDecryptEncryptedDataKeyFilter{}
var _ _dafny.TraitOffspring = &OnDecryptEncryptedDataKeyFilter{}

func (_this *OnDecryptEncryptedDataKeyFilter) Ctor__(awsKmsKey _dafny.Sequence) {
	{
		(_this)._awsKmsKey = awsKmsKey
	}
}
func (_this *OnDecryptEncryptedDataKeyFilter) Invoke(edk interface{}) interface{} {
	{
		var edk m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey = edk.(m_AwsCryptographyMaterialProvidersTypes.EncryptedDataKey)
		_ = edk
		var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(false)
		_ = res
		if !_dafny.Companion_Sequence_.Equal((edk).Dtor_keyProviderId(), m_Constants.Companion_Default___.PROVIDER__ID()) {
			res = m_Wrappers.Companion_Result_.Create_Success_(false)
			return res
		}
		if !(m_UTF8.Companion_Default___.ValidUTF8Seq((edk).Dtor_keyProviderInfo())) {
			res = m_Wrappers.Companion_Result_.Create_Failure_(m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Invalid AWS KMS encoding, provider info is not UTF8.")))
			return res
		}
		var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
		_ = _0_valueOrError0
		_0_valueOrError0 = (m_UTF8.Decode((edk).Dtor_keyProviderInfo())).MapFailure(func(coer54 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg55 interface{}) interface{} {
				return coer54(arg55.(_dafny.Sequence))
			}
		}(m_AwsKmsUtils.Companion_Default___.WrapStringToError))
		if (_0_valueOrError0).IsFailure() {
			res = (_0_valueOrError0).PropagateFailure()
			return res
		}
		var _1_keyId _dafny.Sequence
		_ = _1_keyId
		_1_keyId = (_0_valueOrError0).Extract().(_dafny.Sequence)
		var _2_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _2_valueOrError1
		_2_valueOrError1 = (m_AwsArnParsing.Companion_Default___.ParseAwsKmsArn(_1_keyId)).MapFailure(func(coer55 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg56 interface{}) interface{} {
				return coer55(arg56.(_dafny.Sequence))
			}
		}(m_AwsKmsUtils.Companion_Default___.WrapStringToError))
		if (_2_valueOrError1).IsFailure() {
			res = (_2_valueOrError1).PropagateFailure()
			return res
		}
		var _3___v0 m_AwsArnParsing.AwsArn
		_ = _3___v0
		_3___v0 = (_2_valueOrError1).Extract().(m_AwsArnParsing.AwsArn)
		res = m_Wrappers.Companion_Result_.Create_Success_(_dafny.Companion_Sequence_.Equal((_this).AwsKmsKey(), _1_keyId))
		return res
		return res
	}
}
func (_this *OnDecryptEncryptedDataKeyFilter) AwsKmsKey() _dafny.Sequence {
	{
		return _this._awsKmsKey
	}
}

// End of class OnDecryptEncryptedDataKeyFilter

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
	return "AwsKmsKeyring.DecryptSingleEncryptedDataKey"
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
	return "AwsKmsKeyring.DecryptSingleEncryptedDataKey"
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
		var _0_kmsUnwrap *KmsUnwrapKeyMaterial
		_ = _0_kmsUnwrap
		var _nw0 *KmsUnwrapKeyMaterial = New_KmsUnwrapKeyMaterial_()
		_ = _nw0
		_nw0.Ctor__((_this).Client(), (_this).AwsKmsKey(), (_this).GrantTokens())
		_0_kmsUnwrap = _nw0
		var _1_unwrapOutputRes m_Wrappers.Result
		_ = _1_unwrapOutputRes
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_EdkWrapping.Companion_Default___.UnwrapEdkMaterial((edk).Dtor_ciphertext(), (_this).Materials(), _0_kmsUnwrap)
		_1_unwrapOutputRes = _out0
		var _2_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_EdkWrapping.Companion_UnwrapEdkMaterialOutput_.Default(Companion_KmsUnwrapInfo_.Default()))
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

// Definition of datatype KmsUnwrapInfo
type KmsUnwrapInfo struct {
	Data_KmsUnwrapInfo_
}

func (_this KmsUnwrapInfo) Get_() Data_KmsUnwrapInfo_ {
	return _this.Data_KmsUnwrapInfo_
}

type Data_KmsUnwrapInfo_ interface {
	isKmsUnwrapInfo()
}

type CompanionStruct_KmsUnwrapInfo_ struct {
}

var Companion_KmsUnwrapInfo_ = CompanionStruct_KmsUnwrapInfo_{}

type KmsUnwrapInfo_KmsUnwrapInfo struct {
}

func (KmsUnwrapInfo_KmsUnwrapInfo) isKmsUnwrapInfo() {}

func (CompanionStruct_KmsUnwrapInfo_) Create_KmsUnwrapInfo_() KmsUnwrapInfo {
	return KmsUnwrapInfo{KmsUnwrapInfo_KmsUnwrapInfo{}}
}

func (_this KmsUnwrapInfo) Is_KmsUnwrapInfo() bool {
	_, ok := _this.Get_().(KmsUnwrapInfo_KmsUnwrapInfo)
	return ok
}

func (CompanionStruct_KmsUnwrapInfo_) Default() KmsUnwrapInfo {
	return Companion_KmsUnwrapInfo_.Create_KmsUnwrapInfo_()
}

func (_ CompanionStruct_KmsUnwrapInfo_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_KmsUnwrapInfo_.Create_KmsUnwrapInfo_(), true
		default:
			return KmsUnwrapInfo{}, false
		}
	}
}

func (_this KmsUnwrapInfo) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case KmsUnwrapInfo_KmsUnwrapInfo:
		{
			return "AwsKmsKeyring.KmsUnwrapInfo.KmsUnwrapInfo"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this KmsUnwrapInfo) Equals(other KmsUnwrapInfo) bool {
	switch _this.Get_().(type) {
	case KmsUnwrapInfo_KmsUnwrapInfo:
		{
			_, ok := other.Get_().(KmsUnwrapInfo_KmsUnwrapInfo)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this KmsUnwrapInfo) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(KmsUnwrapInfo)
	return ok && _this.Equals(typed)
}

func Type_KmsUnwrapInfo_() _dafny.TypeDescriptor {
	return type_KmsUnwrapInfo_{}
}

type type_KmsUnwrapInfo_ struct {
}

func (_this type_KmsUnwrapInfo_) Default() interface{} {
	return Companion_KmsUnwrapInfo_.Default()
}

func (_this type_KmsUnwrapInfo_) String() string {
	return "AwsKmsKeyring.KmsUnwrapInfo"
}
func (_this KmsUnwrapInfo) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = KmsUnwrapInfo{}

// End of datatype KmsUnwrapInfo

// Definition of datatype KmsWrapInfo
type KmsWrapInfo struct {
	Data_KmsWrapInfo_
}

func (_this KmsWrapInfo) Get_() Data_KmsWrapInfo_ {
	return _this.Data_KmsWrapInfo_
}

type Data_KmsWrapInfo_ interface {
	isKmsWrapInfo()
}

type CompanionStruct_KmsWrapInfo_ struct {
}

var Companion_KmsWrapInfo_ = CompanionStruct_KmsWrapInfo_{}

type KmsWrapInfo_KmsWrapInfo struct {
	KmsKeyArn _dafny.Sequence
}

func (KmsWrapInfo_KmsWrapInfo) isKmsWrapInfo() {}

func (CompanionStruct_KmsWrapInfo_) Create_KmsWrapInfo_(KmsKeyArn _dafny.Sequence) KmsWrapInfo {
	return KmsWrapInfo{KmsWrapInfo_KmsWrapInfo{KmsKeyArn}}
}

func (_this KmsWrapInfo) Is_KmsWrapInfo() bool {
	_, ok := _this.Get_().(KmsWrapInfo_KmsWrapInfo)
	return ok
}

func (CompanionStruct_KmsWrapInfo_) Default() KmsWrapInfo {
	return Companion_KmsWrapInfo_.Create_KmsWrapInfo_(_dafny.EmptySeq.SetString())
}

func (_this KmsWrapInfo) Dtor_kmsKeyArn() _dafny.Sequence {
	return _this.Get_().(KmsWrapInfo_KmsWrapInfo).KmsKeyArn
}

func (_this KmsWrapInfo) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case KmsWrapInfo_KmsWrapInfo:
		{
			return "AwsKmsKeyring.KmsWrapInfo.KmsWrapInfo" + "(" + _dafny.String(data.KmsKeyArn) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this KmsWrapInfo) Equals(other KmsWrapInfo) bool {
	switch data1 := _this.Get_().(type) {
	case KmsWrapInfo_KmsWrapInfo:
		{
			data2, ok := other.Get_().(KmsWrapInfo_KmsWrapInfo)
			return ok && data1.KmsKeyArn.Equals(data2.KmsKeyArn)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this KmsWrapInfo) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(KmsWrapInfo)
	return ok && _this.Equals(typed)
}

func Type_KmsWrapInfo_() _dafny.TypeDescriptor {
	return type_KmsWrapInfo_{}
}

type type_KmsWrapInfo_ struct {
}

func (_this type_KmsWrapInfo_) Default() interface{} {
	return Companion_KmsWrapInfo_.Default()
}

func (_this type_KmsWrapInfo_) String() string {
	return "AwsKmsKeyring.KmsWrapInfo"
}
func (_this KmsWrapInfo) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = KmsWrapInfo{}

// End of datatype KmsWrapInfo

// Definition of class KmsUnwrapKeyMaterial
type KmsUnwrapKeyMaterial struct {
	_client      m_ComAmazonawsKmsTypes.IKMSClient
	_grantTokens _dafny.Sequence
	_awsKmsKey   _dafny.Sequence
}

func New_KmsUnwrapKeyMaterial_() *KmsUnwrapKeyMaterial {
	_this := KmsUnwrapKeyMaterial{}

	_this._client = (m_ComAmazonawsKmsTypes.IKMSClient)(nil)
	_this._grantTokens = _dafny.EmptySeq
	_this._awsKmsKey = _dafny.EmptySeq.SetString()
	return &_this
}

type CompanionStruct_KmsUnwrapKeyMaterial_ struct {
}

var Companion_KmsUnwrapKeyMaterial_ = CompanionStruct_KmsUnwrapKeyMaterial_{}

func (_this *KmsUnwrapKeyMaterial) Equals(other *KmsUnwrapKeyMaterial) bool {
	return _this == other
}

func (_this *KmsUnwrapKeyMaterial) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*KmsUnwrapKeyMaterial)
	return ok && _this.Equals(other)
}

func (*KmsUnwrapKeyMaterial) String() string {
	return "AwsKmsKeyring.KmsUnwrapKeyMaterial"
}

func Type_KmsUnwrapKeyMaterial_() _dafny.TypeDescriptor {
	return type_KmsUnwrapKeyMaterial_{}
}

type type_KmsUnwrapKeyMaterial_ struct {
}

func (_this type_KmsUnwrapKeyMaterial_) Default() interface{} {
	return (*KmsUnwrapKeyMaterial)(nil)
}

func (_this type_KmsUnwrapKeyMaterial_) String() string {
	return "AwsKmsKeyring.KmsUnwrapKeyMaterial"
}
func (_this *KmsUnwrapKeyMaterial) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_MaterialWrapping.Companion_UnwrapMaterial_.TraitID_, m_Actions.Companion_ActionWithResult_.TraitID_, m_Actions.Companion_Action_.TraitID_}
}

var _ m_MaterialWrapping.UnwrapMaterial = &KmsUnwrapKeyMaterial{}
var _ m_Actions.ActionWithResult = &KmsUnwrapKeyMaterial{}
var _ m_Actions.Action = &KmsUnwrapKeyMaterial{}
var _ _dafny.TraitOffspring = &KmsUnwrapKeyMaterial{}

func (_this *KmsUnwrapKeyMaterial) Ctor__(client m_ComAmazonawsKmsTypes.IKMSClient, awsKmsKey _dafny.Sequence, grantTokens _dafny.Sequence) {
	{
		(_this)._client = client
		(_this)._awsKmsKey = awsKmsKey
		(_this)._grantTokens = grantTokens
	}
}
func (_this *KmsUnwrapKeyMaterial) Invoke(input interface{}) interface{} {
	{
		var input m_MaterialWrapping.UnwrapInput = input.(m_MaterialWrapping.UnwrapInput)
		_ = input
		var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_MaterialWrapping.Companion_UnwrapOutput_.Default(Companion_KmsUnwrapInfo_.Default()))
		_ = res
		var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _0_valueOrError0
		_0_valueOrError0 = m_Wrappers.Companion_Default___.Need(m_ComAmazonawsKmsTypes.Companion_Default___.IsValid__CiphertextType((input).Dtor_wrappedMaterial()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Ciphertext length invalid")))
		if (_0_valueOrError0).IsFailure() {
			res = (_0_valueOrError0).PropagateFailure()
			return res
		}
		var _1_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
		_ = _1_valueOrError1
		_1_valueOrError1 = m_AwsKmsUtils.Companion_Default___.StringifyEncryptionContext((input).Dtor_encryptionContext())
		if (_1_valueOrError1).IsFailure() {
			res = (_1_valueOrError1).PropagateFailure()
			return res
		}
		var _2_stringifiedEncCtx _dafny.Map
		_ = _2_stringifiedEncCtx
		_2_stringifiedEncCtx = (_1_valueOrError1).Extract().(_dafny.Map)
		var _3_decryptRequest m_ComAmazonawsKmsTypes.DecryptRequest
		_ = _3_decryptRequest
		_3_decryptRequest = m_ComAmazonawsKmsTypes.Companion_DecryptRequest_.Create_DecryptRequest_((input).Dtor_wrappedMaterial(), m_Wrappers.Companion_Option_.Create_Some_(_2_stringifiedEncCtx), m_Wrappers.Companion_Option_.Create_Some_((_this).GrantTokens()), m_Wrappers.Companion_Option_.Create_Some_((_this).AwsKmsKey()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
		var _4_maybeDecryptResponse m_Wrappers.Result
		_ = _4_maybeDecryptResponse
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = ((_this).Client()).Decrypt(_3_decryptRequest)
		_4_maybeDecryptResponse = _out0
		var _5_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsKmsTypes.Companion_DecryptResponse_.Default())
		_ = _5_valueOrError2
		_5_valueOrError2 = (_4_maybeDecryptResponse).MapFailure(func(coer56 func(m_ComAmazonawsKmsTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg57 interface{}) interface{} {
				return coer56(arg57.(m_ComAmazonawsKmsTypes.Error))
			}
		}(func(_6_e m_ComAmazonawsKmsTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
			return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_ComAmazonawsKms_(_6_e)
		}))
		if (_5_valueOrError2).IsFailure() {
			res = (_5_valueOrError2).PropagateFailure()
			return res
		}
		var _7_decryptResponse m_ComAmazonawsKmsTypes.DecryptResponse
		_ = _7_decryptResponse
		_7_decryptResponse = (_5_valueOrError2).Extract().(m_ComAmazonawsKmsTypes.DecryptResponse)
		var _8_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _8_valueOrError3
		_8_valueOrError3 = m_Wrappers.Companion_Default___.Need((((((_7_decryptResponse).Dtor_KeyId()).Is_Some()) && (_dafny.Companion_Sequence_.Equal(((_7_decryptResponse).Dtor_KeyId()).Dtor_value().(_dafny.Sequence), (_this).AwsKmsKey()))) && (((_7_decryptResponse).Dtor_Plaintext()).Is_Some())) && ((_dafny.IntOfInt32(m_AlgorithmSuites.Companion_Default___.GetEncryptKeyLength((input).Dtor_algorithmSuite()))).Cmp(_dafny.IntOfUint32((((_7_decryptResponse).Dtor_Plaintext()).Dtor_value().(_dafny.Sequence)).Cardinality())) == 0), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Invalid response from KMS Decrypt")))
		if (_8_valueOrError3).IsFailure() {
			res = (_8_valueOrError3).PropagateFailure()
			return res
		}
		var _9_output m_MaterialWrapping.UnwrapOutput
		_ = _9_output
		_9_output = m_MaterialWrapping.Companion_UnwrapOutput_.Create_UnwrapOutput_(((_7_decryptResponse).Dtor_Plaintext()).Dtor_value().(_dafny.Sequence), Companion_KmsUnwrapInfo_.Create_KmsUnwrapInfo_())
		res = m_Wrappers.Companion_Result_.Create_Success_(_9_output)
		return res
		return res
	}
}
func (_this *KmsUnwrapKeyMaterial) Client() m_ComAmazonawsKmsTypes.IKMSClient {
	{
		return _this._client
	}
}
func (_this *KmsUnwrapKeyMaterial) GrantTokens() _dafny.Sequence {
	{
		return _this._grantTokens
	}
}
func (_this *KmsUnwrapKeyMaterial) AwsKmsKey() _dafny.Sequence {
	{
		return _this._awsKmsKey
	}
}

// End of class KmsUnwrapKeyMaterial

// Definition of class KmsGenerateAndWrapKeyMaterial
type KmsGenerateAndWrapKeyMaterial struct {
	_client      m_ComAmazonawsKmsTypes.IKMSClient
	_awsKmsKey   _dafny.Sequence
	_grantTokens _dafny.Sequence
}

func New_KmsGenerateAndWrapKeyMaterial_() *KmsGenerateAndWrapKeyMaterial {
	_this := KmsGenerateAndWrapKeyMaterial{}

	_this._client = (m_ComAmazonawsKmsTypes.IKMSClient)(nil)
	_this._awsKmsKey = _dafny.EmptySeq.SetString()
	_this._grantTokens = _dafny.EmptySeq
	return &_this
}

type CompanionStruct_KmsGenerateAndWrapKeyMaterial_ struct {
}

var Companion_KmsGenerateAndWrapKeyMaterial_ = CompanionStruct_KmsGenerateAndWrapKeyMaterial_{}

func (_this *KmsGenerateAndWrapKeyMaterial) Equals(other *KmsGenerateAndWrapKeyMaterial) bool {
	return _this == other
}

func (_this *KmsGenerateAndWrapKeyMaterial) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*KmsGenerateAndWrapKeyMaterial)
	return ok && _this.Equals(other)
}

func (*KmsGenerateAndWrapKeyMaterial) String() string {
	return "AwsKmsKeyring.KmsGenerateAndWrapKeyMaterial"
}

func Type_KmsGenerateAndWrapKeyMaterial_() _dafny.TypeDescriptor {
	return type_KmsGenerateAndWrapKeyMaterial_{}
}

type type_KmsGenerateAndWrapKeyMaterial_ struct {
}

func (_this type_KmsGenerateAndWrapKeyMaterial_) Default() interface{} {
	return (*KmsGenerateAndWrapKeyMaterial)(nil)
}

func (_this type_KmsGenerateAndWrapKeyMaterial_) String() string {
	return "AwsKmsKeyring.KmsGenerateAndWrapKeyMaterial"
}
func (_this *KmsGenerateAndWrapKeyMaterial) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_MaterialWrapping.Companion_GenerateAndWrapMaterial_.TraitID_, m_Actions.Companion_ActionWithResult_.TraitID_, m_Actions.Companion_Action_.TraitID_}
}

var _ m_MaterialWrapping.GenerateAndWrapMaterial = &KmsGenerateAndWrapKeyMaterial{}
var _ m_Actions.ActionWithResult = &KmsGenerateAndWrapKeyMaterial{}
var _ m_Actions.Action = &KmsGenerateAndWrapKeyMaterial{}
var _ _dafny.TraitOffspring = &KmsGenerateAndWrapKeyMaterial{}

func (_this *KmsGenerateAndWrapKeyMaterial) Ctor__(client m_ComAmazonawsKmsTypes.IKMSClient, awsKmsKey _dafny.Sequence, grantTokens _dafny.Sequence) {
	{
		(_this)._client = client
		(_this)._awsKmsKey = awsKmsKey
		(_this)._grantTokens = grantTokens
	}
}
func (_this *KmsGenerateAndWrapKeyMaterial) Invoke(input interface{}) interface{} {
	{
		var input m_MaterialWrapping.GenerateAndWrapInput = input.(m_MaterialWrapping.GenerateAndWrapInput)
		_ = input
		var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_MaterialWrapping.Companion_GenerateAndWrapOutput_.Default(Companion_KmsWrapInfo_.Default()))
		_ = res
		var _0_suite m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo
		_ = _0_suite
		_0_suite = (input).Dtor_algorithmSuite()
		var _1_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
		_ = _1_valueOrError0
		_1_valueOrError0 = m_AwsKmsUtils.Companion_Default___.StringifyEncryptionContext((input).Dtor_encryptionContext())
		if (_1_valueOrError0).IsFailure() {
			res = (_1_valueOrError0).PropagateFailure()
			return res
		}
		var _2_stringifiedEncCtx _dafny.Map
		_ = _2_stringifiedEncCtx
		_2_stringifiedEncCtx = (_1_valueOrError0).Extract().(_dafny.Map)
		var _3_generatorRequest m_ComAmazonawsKmsTypes.GenerateDataKeyRequest
		_ = _3_generatorRequest
		_3_generatorRequest = m_ComAmazonawsKmsTypes.Companion_GenerateDataKeyRequest_.Create_GenerateDataKeyRequest_((_this).AwsKmsKey(), m_Wrappers.Companion_Option_.Create_Some_(_2_stringifiedEncCtx), m_Wrappers.Companion_Option_.Create_Some_(m_AlgorithmSuites.Companion_Default___.GetEncryptKeyLength(_0_suite)), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_Some_((_this).GrantTokens()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
		var _4_maybeGenerateResponse m_Wrappers.Result
		_ = _4_maybeGenerateResponse
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = ((_this).Client()).GenerateDataKey(_3_generatorRequest)
		_4_maybeGenerateResponse = _out0
		var _5_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsKmsTypes.Companion_GenerateDataKeyResponse_.Default())
		_ = _5_valueOrError1
		_5_valueOrError1 = (_4_maybeGenerateResponse).MapFailure(func(coer57 func(m_ComAmazonawsKmsTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg58 interface{}) interface{} {
				return coer57(arg58.(m_ComAmazonawsKmsTypes.Error))
			}
		}(func(_6_e m_ComAmazonawsKmsTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
			return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_ComAmazonawsKms_(_6_e)
		}))
		if (_5_valueOrError1).IsFailure() {
			res = (_5_valueOrError1).PropagateFailure()
			return res
		}
		var _7_generateResponse m_ComAmazonawsKmsTypes.GenerateDataKeyResponse
		_ = _7_generateResponse
		_7_generateResponse = (_5_valueOrError1).Extract().(m_ComAmazonawsKmsTypes.GenerateDataKeyResponse)
		var _8_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _8_valueOrError2
		_8_valueOrError2 = m_Wrappers.Companion_Default___.Need((((_7_generateResponse).Dtor_KeyId()).Is_Some()) && ((m_AwsArnParsing.Companion_Default___.ParseAwsKmsIdentifier(((_7_generateResponse).Dtor_KeyId()).Dtor_value().(_dafny.Sequence))).Is_Success()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Invalid response from KMS GenerateDataKey:: Invalid Key Id")))
		if (_8_valueOrError2).IsFailure() {
			res = (_8_valueOrError2).PropagateFailure()
			return res
		}
		var _9_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _9_valueOrError3
		_9_valueOrError3 = m_Wrappers.Companion_Default___.Need((((_7_generateResponse).Dtor_Plaintext()).Is_Some()) && ((_dafny.IntOfInt32(m_AlgorithmSuites.Companion_Default___.GetEncryptKeyLength(_0_suite))).Cmp(_dafny.IntOfUint32((((_7_generateResponse).Dtor_Plaintext()).Dtor_value().(_dafny.Sequence)).Cardinality())) == 0), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Invalid response from AWS KMS GenerateDataKey: Invalid data key")))
		if (_9_valueOrError3).IsFailure() {
			res = (_9_valueOrError3).PropagateFailure()
			return res
		}
		var _10_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _10_valueOrError4
		_10_valueOrError4 = m_Wrappers.Companion_Default___.Need((((_7_generateResponse).Dtor_CiphertextBlob()).Is_Some()) && (m_ComAmazonawsKmsTypes.Companion_Default___.IsValid__CiphertextType(((_7_generateResponse).Dtor_CiphertextBlob()).Dtor_value().(_dafny.Sequence))), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Invalid response from AWS KMS GeneratedDataKey: Invalid ciphertext")))
		if (_10_valueOrError4).IsFailure() {
			res = (_10_valueOrError4).PropagateFailure()
			return res
		}
		var _11_valueOrError5 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _11_valueOrError5
		_11_valueOrError5 = m_Wrappers.Companion_Default___.Need((true) && (((_7_generateResponse).Dtor_CiphertextForRecipient()).Is_None()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Invalid response from AWS KMS GeneratedDataKey: Invalid CiphertextForRecipient")))
		if (_11_valueOrError5).IsFailure() {
			res = (_11_valueOrError5).PropagateFailure()
			return res
		}
		var _12_output m_MaterialWrapping.GenerateAndWrapOutput
		_ = _12_output
		_12_output = m_MaterialWrapping.Companion_GenerateAndWrapOutput_.Create_GenerateAndWrapOutput_(((_7_generateResponse).Dtor_Plaintext()).Dtor_value().(_dafny.Sequence), ((_7_generateResponse).Dtor_CiphertextBlob()).Dtor_value().(_dafny.Sequence), Companion_KmsWrapInfo_.Create_KmsWrapInfo_(((_7_generateResponse).Dtor_KeyId()).Dtor_value().(_dafny.Sequence)))
		res = m_Wrappers.Companion_Result_.Create_Success_(_12_output)
		return res
		return res
	}
}
func (_this *KmsGenerateAndWrapKeyMaterial) Client() m_ComAmazonawsKmsTypes.IKMSClient {
	{
		return _this._client
	}
}
func (_this *KmsGenerateAndWrapKeyMaterial) AwsKmsKey() _dafny.Sequence {
	{
		return _this._awsKmsKey
	}
}
func (_this *KmsGenerateAndWrapKeyMaterial) GrantTokens() _dafny.Sequence {
	{
		return _this._grantTokens
	}
}

// End of class KmsGenerateAndWrapKeyMaterial

// Definition of class KmsWrapKeyMaterial
type KmsWrapKeyMaterial struct {
	_client      m_ComAmazonawsKmsTypes.IKMSClient
	_awsKmsKey   _dafny.Sequence
	_grantTokens _dafny.Sequence
}

func New_KmsWrapKeyMaterial_() *KmsWrapKeyMaterial {
	_this := KmsWrapKeyMaterial{}

	_this._client = (m_ComAmazonawsKmsTypes.IKMSClient)(nil)
	_this._awsKmsKey = _dafny.EmptySeq.SetString()
	_this._grantTokens = _dafny.EmptySeq
	return &_this
}

type CompanionStruct_KmsWrapKeyMaterial_ struct {
}

var Companion_KmsWrapKeyMaterial_ = CompanionStruct_KmsWrapKeyMaterial_{}

func (_this *KmsWrapKeyMaterial) Equals(other *KmsWrapKeyMaterial) bool {
	return _this == other
}

func (_this *KmsWrapKeyMaterial) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*KmsWrapKeyMaterial)
	return ok && _this.Equals(other)
}

func (*KmsWrapKeyMaterial) String() string {
	return "AwsKmsKeyring.KmsWrapKeyMaterial"
}

func Type_KmsWrapKeyMaterial_() _dafny.TypeDescriptor {
	return type_KmsWrapKeyMaterial_{}
}

type type_KmsWrapKeyMaterial_ struct {
}

func (_this type_KmsWrapKeyMaterial_) Default() interface{} {
	return (*KmsWrapKeyMaterial)(nil)
}

func (_this type_KmsWrapKeyMaterial_) String() string {
	return "AwsKmsKeyring.KmsWrapKeyMaterial"
}
func (_this *KmsWrapKeyMaterial) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_MaterialWrapping.Companion_WrapMaterial_.TraitID_, m_Actions.Companion_ActionWithResult_.TraitID_, m_Actions.Companion_Action_.TraitID_}
}

var _ m_MaterialWrapping.WrapMaterial = &KmsWrapKeyMaterial{}
var _ m_Actions.ActionWithResult = &KmsWrapKeyMaterial{}
var _ m_Actions.Action = &KmsWrapKeyMaterial{}
var _ _dafny.TraitOffspring = &KmsWrapKeyMaterial{}

func (_this *KmsWrapKeyMaterial) Ctor__(client m_ComAmazonawsKmsTypes.IKMSClient, awsKmsKey _dafny.Sequence, grantTokens _dafny.Sequence) {
	{
		(_this)._client = client
		(_this)._awsKmsKey = awsKmsKey
		(_this)._grantTokens = grantTokens
	}
}
func (_this *KmsWrapKeyMaterial) Invoke(input interface{}) interface{} {
	{
		var input m_MaterialWrapping.WrapInput = input.(m_MaterialWrapping.WrapInput)
		_ = input
		var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_MaterialWrapping.Companion_WrapOutput_.Default(Companion_KmsWrapInfo_.Default()))
		_ = res
		var _0_suite m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo
		_ = _0_suite
		_0_suite = (input).Dtor_algorithmSuite()
		var _1_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptyMap)
		_ = _1_valueOrError0
		_1_valueOrError0 = m_AwsKmsUtils.Companion_Default___.StringifyEncryptionContext((input).Dtor_encryptionContext())
		if (_1_valueOrError0).IsFailure() {
			res = (_1_valueOrError0).PropagateFailure()
			return res
		}
		var _2_stringifiedEncCtx _dafny.Map
		_ = _2_stringifiedEncCtx
		_2_stringifiedEncCtx = (_1_valueOrError0).Extract().(_dafny.Map)
		var _3_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _3_valueOrError1
		_3_valueOrError1 = m_Wrappers.Companion_Default___.Need(m_ComAmazonawsKmsTypes.Companion_Default___.IsValid__PlaintextType((input).Dtor_plaintextMaterial()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Invalid Plaintext on KMS Encrypt")))
		if (_3_valueOrError1).IsFailure() {
			res = (_3_valueOrError1).PropagateFailure()
			return res
		}
		var _4_encryptRequest m_ComAmazonawsKmsTypes.EncryptRequest
		_ = _4_encryptRequest
		_4_encryptRequest = m_ComAmazonawsKmsTypes.Companion_EncryptRequest_.Create_EncryptRequest_((_this).AwsKmsKey(), (input).Dtor_plaintextMaterial(), m_Wrappers.Companion_Option_.Create_Some_(_2_stringifiedEncCtx), m_Wrappers.Companion_Option_.Create_Some_((_this).GrantTokens()), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
		var _5_maybeEncryptResponse m_Wrappers.Result
		_ = _5_maybeEncryptResponse
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = ((_this).Client()).Encrypt(_4_encryptRequest)
		_5_maybeEncryptResponse = _out0
		var _6_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsKmsTypes.Companion_EncryptResponse_.Default())
		_ = _6_valueOrError2
		_6_valueOrError2 = (_5_maybeEncryptResponse).MapFailure(func(coer58 func(m_ComAmazonawsKmsTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg59 interface{}) interface{} {
				return coer58(arg59.(m_ComAmazonawsKmsTypes.Error))
			}
		}(func(_7_e m_ComAmazonawsKmsTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
			return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_ComAmazonawsKms_(_7_e)
		}))
		if (_6_valueOrError2).IsFailure() {
			res = (_6_valueOrError2).PropagateFailure()
			return res
		}
		var _8_encryptResponse m_ComAmazonawsKmsTypes.EncryptResponse
		_ = _8_encryptResponse
		_8_encryptResponse = (_6_valueOrError2).Extract().(m_ComAmazonawsKmsTypes.EncryptResponse)
		var _9_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _9_valueOrError3
		_9_valueOrError3 = m_Wrappers.Companion_Default___.Need((((_8_encryptResponse).Dtor_KeyId()).Is_Some()) && ((m_AwsArnParsing.Companion_Default___.ParseAwsKmsIdentifier(((_8_encryptResponse).Dtor_KeyId()).Dtor_value().(_dafny.Sequence))).Is_Success()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Invalid response from AWS KMS Encrypt:: Invalid Key Id")))
		if (_9_valueOrError3).IsFailure() {
			res = (_9_valueOrError3).PropagateFailure()
			return res
		}
		var _10_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _10_valueOrError4
		_10_valueOrError4 = m_Wrappers.Companion_Default___.Need(((_8_encryptResponse).Dtor_CiphertextBlob()).Is_Some(), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Invalid response from AWS KMS Encrypt: Invalid Ciphertext Blob")))
		if (_10_valueOrError4).IsFailure() {
			res = (_10_valueOrError4).PropagateFailure()
			return res
		}
		var _11_output m_MaterialWrapping.WrapOutput
		_ = _11_output
		_11_output = m_MaterialWrapping.Companion_WrapOutput_.Create_WrapOutput_(((_8_encryptResponse).Dtor_CiphertextBlob()).Dtor_value().(_dafny.Sequence), Companion_KmsWrapInfo_.Create_KmsWrapInfo_(((_8_encryptResponse).Dtor_KeyId()).Dtor_value().(_dafny.Sequence)))
		res = m_Wrappers.Companion_Result_.Create_Success_(_11_output)
		return res
		return res
	}
}
func (_this *KmsWrapKeyMaterial) Client() m_ComAmazonawsKmsTypes.IKMSClient {
	{
		return _this._client
	}
}
func (_this *KmsWrapKeyMaterial) AwsKmsKey() _dafny.Sequence {
	{
		return _this._awsKmsKey
	}
}
func (_this *KmsWrapKeyMaterial) GrantTokens() _dafny.Sequence {
	{
		return _this._grantTokens
	}
}

// End of class KmsWrapKeyMaterial
