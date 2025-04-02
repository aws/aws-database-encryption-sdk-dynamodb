// Package MultiKeyring
// Dafny module MultiKeyring compiled into Go

package MultiKeyring

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
	m_AwsKmsMrkMatchForDecrypt "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkMatchForDecrypt"
	m_AwsKmsUtils "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsUtils"
	m_CreateKeyStoreTable "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CreateKeyStoreTable"
	m_CreateKeys "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CreateKeys"
	m_DDBKeystoreOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/DDBKeystoreOperations"
	m_GetKeys "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/GetKeys"
	m_KMSKeystoreOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KMSKeystoreOperations"
	m_KeyStore "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KeyStore"
	m_KeyStoreErrorMessages "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KeyStoreErrorMessages"
	m_Keyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Keyring"
	m_KmsArn "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KmsArn"
	m_Materials "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/Materials"
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
	return "MultiKeyring.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) AttemptDecryptDataKey(keyring m_AwsCryptographyMaterialProvidersTypes.IKeyring, input m_AwsCryptographyMaterialProvidersTypes.OnDecryptInput) m_Wrappers.Result {
	var res m_Wrappers.Result = m_Wrappers.Result{}
	_ = res
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _0_valueOrError0
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = (keyring).OnDecrypt(input)
	_0_valueOrError0 = _out0
	if (_0_valueOrError0).IsFailure() {
		res = (_0_valueOrError0).PropagateFailure()
		return res
	}
	var _1_output m_AwsCryptographyMaterialProvidersTypes.OnDecryptOutput
	_ = _1_output
	_1_output = (_0_valueOrError0).Extract().(m_AwsCryptographyMaterialProvidersTypes.OnDecryptOutput)
	var _2_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _2_valueOrError1
	_2_valueOrError1 = m_Wrappers.Companion_Default___.Need(m_Materials.Companion_Default___.DecryptionMaterialsTransitionIsValid((input).Dtor_materials(), (_1_output).Dtor_materials()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Keyring performed invalid material transition")))
	if (_2_valueOrError1).IsFailure() {
		res = (_2_valueOrError1).PropagateFailure()
		return res
	}
	res = m_Wrappers.Companion_Result_.Create_Success_(_1_output)
	return res
	return res
}

// End of class Default__

// Definition of class MultiKeyring
type MultiKeyring struct {
	_generatorKeyring m_Wrappers.Option
	_childKeyrings    _dafny.Sequence
}

func New_MultiKeyring_() *MultiKeyring {
	_this := MultiKeyring{}

	_this._generatorKeyring = m_Wrappers.Companion_Option_.Default()
	_this._childKeyrings = _dafny.EmptySeq
	return &_this
}

type CompanionStruct_MultiKeyring_ struct {
}

var Companion_MultiKeyring_ = CompanionStruct_MultiKeyring_{}

func (_this *MultiKeyring) Equals(other *MultiKeyring) bool {
	return _this == other
}

func (_this *MultiKeyring) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*MultiKeyring)
	return ok && _this.Equals(other)
}

func (*MultiKeyring) String() string {
	return "MultiKeyring.MultiKeyring"
}

func Type_MultiKeyring_() _dafny.TypeDescriptor {
	return type_MultiKeyring_{}
}

type type_MultiKeyring_ struct {
}

func (_this type_MultiKeyring_) Default() interface{} {
	return (*MultiKeyring)(nil)
}

func (_this type_MultiKeyring_) String() string {
	return "MultiKeyring.MultiKeyring"
}
func (_this *MultiKeyring) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_Keyring.Companion_VerifiableInterface_.TraitID_, m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.TraitID_}
}

var _ m_Keyring.VerifiableInterface = &MultiKeyring{}
var _ m_AwsCryptographyMaterialProvidersTypes.IKeyring = &MultiKeyring{}
var _ _dafny.TraitOffspring = &MultiKeyring{}

func (_this *MultiKeyring) OnDecrypt(input m_AwsCryptographyMaterialProvidersTypes.OnDecryptInput) m_Wrappers.Result {
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.OnDecrypt(_this, input)
	return _out1
}
func (_this *MultiKeyring) OnEncrypt(input m_AwsCryptographyMaterialProvidersTypes.OnEncryptInput) m_Wrappers.Result {
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.OnEncrypt(_this, input)
	return _out1
}
func (_this *MultiKeyring) Ctor__(generatorKeyring m_Wrappers.Option, childKeyrings _dafny.Sequence) {
	{
		(_this)._generatorKeyring = generatorKeyring
		(_this)._childKeyrings = childKeyrings
	}
}
func (_this *MultiKeyring) OnEncrypt_k(input m_AwsCryptographyMaterialProvidersTypes.OnEncryptInput) m_Wrappers.Result {
	{
		var res m_Wrappers.Result = m_Wrappers.Result{}
		_ = res
		if (((_this).GeneratorKeyring()).Is_None()) && ((((input).Dtor_materials()).Dtor_plaintextDataKey()).Is_None()) {
			var _0_exception _dafny.Sequence
			_ = _0_exception
			_0_exception = _dafny.SeqOfString("Need either a generator keyring or input encryption materials which contain a plaintext data key")
			res = m_Wrappers.Companion_Result_.Create_Failure_(m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_0_exception))
			return res
		}
		var _1_returnMaterials m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials
		_ = _1_returnMaterials
		_1_returnMaterials = (input).Dtor_materials()
		if ((_this).GeneratorKeyring()).Is_Some() {
			var _2_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
			_ = _2_valueOrError0
			_2_valueOrError0 = m_Wrappers.Companion_Default___.Need((((input).Dtor_materials()).Dtor_plaintextDataKey()).Is_None(), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("This multi keyring has a generator but provided Encryption Materials already contain plaintext data key")))
			if (_2_valueOrError0).IsFailure() {
				res = (_2_valueOrError0).PropagateFailure()
				return res
			}
			var _3_onEncryptOutput m_Wrappers.Result
			_ = _3_onEncryptOutput
			var _out0 m_Wrappers.Result
			_ = _out0
			_out0 = (m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.CastTo_(((_this).GeneratorKeyring()).Dtor_value())).OnEncrypt(input)
			_3_onEncryptOutput = _out0
			var _4_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
			_ = _4_valueOrError1
			_4_valueOrError1 = m_Wrappers.Companion_Default___.Need((_3_onEncryptOutput).Is_Success(), (func() m_AwsCryptographyMaterialProvidersTypes.Error {
				if (_3_onEncryptOutput).Is_Failure() {
					return (_3_onEncryptOutput).Dtor_error().(m_AwsCryptographyMaterialProvidersTypes.Error)
				}
				return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Unexpected failure. Input to Need is !Success."))
			})())
			if (_4_valueOrError1).IsFailure() {
				res = (_4_valueOrError1).PropagateFailure()
				return res
			}
			var _5_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
			_ = _5_valueOrError2
			_5_valueOrError2 = m_Wrappers.Companion_Default___.Need(m_Materials.Companion_Default___.ValidEncryptionMaterialsTransition((input).Dtor_materials(), ((_3_onEncryptOutput).Dtor_value().(m_AwsCryptographyMaterialProvidersTypes.OnEncryptOutput)).Dtor_materials()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Generator keyring returned invalid encryption materials")))
			if (_5_valueOrError2).IsFailure() {
				res = (_5_valueOrError2).PropagateFailure()
				return res
			}
			_1_returnMaterials = ((_3_onEncryptOutput).Dtor_value().(m_AwsCryptographyMaterialProvidersTypes.OnEncryptOutput)).Dtor_materials()
		}
		var _hi0 _dafny.Int = _dafny.IntOfUint32(((_this).ChildKeyrings()).Cardinality())
		_ = _hi0
		for _6_i := _dafny.Zero; _6_i.Cmp(_hi0) < 0; _6_i = _6_i.Plus(_dafny.One) {
			var _7_onEncryptInput m_AwsCryptographyMaterialProvidersTypes.OnEncryptInput
			_ = _7_onEncryptInput
			_7_onEncryptInput = m_AwsCryptographyMaterialProvidersTypes.Companion_OnEncryptInput_.Create_OnEncryptInput_(_1_returnMaterials)
			var _8_onEncryptOutput m_Wrappers.Result
			_ = _8_onEncryptOutput
			var _out1 m_Wrappers.Result
			_ = _out1
			_out1 = (((_this).ChildKeyrings()).Select((_6_i).Uint32()).(m_AwsCryptographyMaterialProvidersTypes.IKeyring)).OnEncrypt(_7_onEncryptInput)
			_8_onEncryptOutput = _out1
			var _9_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
			_ = _9_valueOrError3
			_9_valueOrError3 = m_Wrappers.Companion_Default___.Need((_8_onEncryptOutput).Is_Success(), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Child keyring failed to encrypt plaintext data key")))
			if (_9_valueOrError3).IsFailure() {
				res = (_9_valueOrError3).PropagateFailure()
				return res
			}
			var _10_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
			_ = _10_valueOrError4
			_10_valueOrError4 = m_Wrappers.Companion_Default___.Need(m_Materials.Companion_Default___.ValidEncryptionMaterialsTransition(_1_returnMaterials, ((_8_onEncryptOutput).Dtor_value().(m_AwsCryptographyMaterialProvidersTypes.OnEncryptOutput)).Dtor_materials()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Child keyring performed invalid transition on encryption materials")))
			if (_10_valueOrError4).IsFailure() {
				res = (_10_valueOrError4).PropagateFailure()
				return res
			}
			_1_returnMaterials = ((_8_onEncryptOutput).Dtor_value().(m_AwsCryptographyMaterialProvidersTypes.OnEncryptOutput)).Dtor_materials()
		}
		var _11_valueOrError5 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _11_valueOrError5
		_11_valueOrError5 = m_Wrappers.Companion_Default___.Need(m_Materials.Companion_Default___.ValidEncryptionMaterialsTransition((input).Dtor_materials(), _1_returnMaterials), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("A child or generator keyring modified the encryption materials in illegal ways.")))
		if (_11_valueOrError5).IsFailure() {
			res = (_11_valueOrError5).PropagateFailure()
			return res
		}
		res = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyMaterialProvidersTypes.Companion_OnEncryptOutput_.Create_OnEncryptOutput_(_1_returnMaterials))
		return res
		return res
	}
}
func (_this *MultiKeyring) OnDecrypt_k(input m_AwsCryptographyMaterialProvidersTypes.OnDecryptInput) m_Wrappers.Result {
	{
		var res m_Wrappers.Result = m_Wrappers.Result{}
		_ = res
		var _0_materials m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials
		_ = _0_materials
		_0_materials = (input).Dtor_materials()
		var _1_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _1_valueOrError0
		_1_valueOrError0 = m_Wrappers.Companion_Default___.Need(m_Materials.Companion_Default___.DecryptionMaterialsWithoutPlaintextDataKey((input).Dtor_materials()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Keyring received decryption materials that already contain a plaintext data key.")))
		if (_1_valueOrError0).IsFailure() {
			res = (_1_valueOrError0).PropagateFailure()
			return res
		}
		var _2_failures _dafny.Sequence
		_ = _2_failures
		_2_failures = _dafny.SeqOf()
		if ((_this).GeneratorKeyring()).Is_Some() {
			var _3_result m_Wrappers.Result
			_ = _3_result
			var _out0 m_Wrappers.Result
			_ = _out0
			_out0 = Companion_Default___.AttemptDecryptDataKey(m_AwsCryptographyMaterialProvidersTypes.Companion_IKeyring_.CastTo_(((_this).GeneratorKeyring()).Dtor_value()), input)
			_3_result = _out0
			if (_3_result).Is_Success() {
				if ((((_3_result).Dtor_value().(m_AwsCryptographyMaterialProvidersTypes.OnDecryptOutput)).Dtor_materials()).Dtor_plaintextDataKey()).Is_Some() {
					res = m_Wrappers.Companion_Result_.Create_Success_((_3_result).Dtor_value().(m_AwsCryptographyMaterialProvidersTypes.OnDecryptOutput))
					return res
				}
			} else {
				_2_failures = _dafny.Companion_Sequence_.Concatenate(_2_failures, _dafny.SeqOf((_3_result).Dtor_error().(m_AwsCryptographyMaterialProvidersTypes.Error)))
			}
		}
		var _hi0 _dafny.Int = _dafny.IntOfUint32(((_this).ChildKeyrings()).Cardinality())
		_ = _hi0
		for _4_j := _dafny.Zero; _4_j.Cmp(_hi0) < 0; _4_j = _4_j.Plus(_dafny.One) {
			var _5_result m_Wrappers.Result
			_ = _5_result
			var _out1 m_Wrappers.Result
			_ = _out1
			_out1 = Companion_Default___.AttemptDecryptDataKey(((_this).ChildKeyrings()).Select((_4_j).Uint32()).(m_AwsCryptographyMaterialProvidersTypes.IKeyring), input)
			_5_result = _out1
			if (_5_result).Is_Success() {
				res = m_Wrappers.Companion_Result_.Create_Success_((_5_result).Dtor_value().(m_AwsCryptographyMaterialProvidersTypes.OnDecryptOutput))
				return res
			} else {
				_2_failures = _dafny.Companion_Sequence_.Concatenate(_2_failures, _dafny.SeqOf((_5_result).Dtor_error().(m_AwsCryptographyMaterialProvidersTypes.Error)))
			}
		}
		var _6_combinedResult m_AwsCryptographyMaterialProvidersTypes.Error
		_ = _6_combinedResult
		_6_combinedResult = m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_CollectionOfErrors_(_2_failures, _dafny.SeqOfString("No Configured Keyring was able to decrypt the Data Key. The list of encountered Exceptions is available via `list`."))
		res = m_Wrappers.Companion_Result_.Create_Failure_(_6_combinedResult)
		return res
		return res
	}
}
func (_this *MultiKeyring) GeneratorKeyring() m_Wrappers.Option {
	{
		return _this._generatorKeyring
	}
}
func (_this *MultiKeyring) ChildKeyrings() _dafny.Sequence {
	{
		return _this._childKeyrings
	}
}

// End of class MultiKeyring
