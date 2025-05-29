// Package Materials
// Dafny module Materials compiled into Go

package Materials

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
	m_KmsArn "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KmsArn"
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
	return "Materials.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) InitializeEncryptionMaterials(input m_AwsCryptographyMaterialProvidersTypes.InitializeEncryptionMaterialsInput) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(!((input).Dtor_encryptionContext()).Contains(Companion_Default___.EC__PUBLIC__KEY__FIELD()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Encryption Context ")))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(_dafny.Quantifier(((input).Dtor_requiredEncryptionContextKeys()).UniqueElements(), true, func(_forall_var_0 _dafny.Sequence) bool {
			var _2_key _dafny.Sequence
			_2_key = interface{}(_forall_var_0).(_dafny.Sequence)
			if m_UTF8.Companion_ValidUTF8Bytes_.Is_(_2_key) {
				return !(_dafny.Companion_Sequence_.Contains((input).Dtor_requiredEncryptionContextKeys(), _2_key)) || (((input).Dtor_encryptionContext()).Contains(_2_key))
			} else {
				return true
			}
		}), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Required encryption context keys do not exist in provided encryption context.")))
		_ = _1_valueOrError1
		if (_1_valueOrError1).IsFailure() {
			return (_1_valueOrError1).PropagateFailure()
		} else {
			var _3_suite m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo = m_AlgorithmSuites.Companion_Default___.GetSuite((input).Dtor_algorithmSuiteId())
			_ = _3_suite
			var _4_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((((_3_suite).Dtor_signature()).Is_ECDSA()) == ((((input).Dtor_signingKey()).Is_Some()) && (((input).Dtor_verificationKey()).Is_Some())), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Missing signature key for signed suite.")))
			_ = _4_valueOrError2
			if (_4_valueOrError2).IsFailure() {
				return (_4_valueOrError2).PropagateFailure()
			} else {
				var _5_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((((_3_suite).Dtor_signature()).Is_None()) == ((((input).Dtor_signingKey()).Is_None()) && (((input).Dtor_verificationKey()).Is_None())), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Signature key not allowed for non-signed suites.")))
				_ = _5_valueOrError3
				if (_5_valueOrError3).IsFailure() {
					return (_5_valueOrError3).PropagateFailure()
				} else {
					var _6_valueOrError4 m_Wrappers.Result = func() m_Wrappers.Result {
						var _source0 m_AwsCryptographyMaterialProvidersTypes.SignatureAlgorithm = (_3_suite).Dtor_signature()
						_ = _source0
						{
							if _source0.Is_ECDSA() {
								var _7_curve m_AwsCryptographyMaterialProvidersTypes.ECDSA = _source0.Get_().(m_AwsCryptographyMaterialProvidersTypes.SignatureAlgorithm_ECDSA).ECDSA
								_ = _7_curve
								var _8_valueOrError5 m_Wrappers.Result = (m_UTF8.Encode(m_Base64.Companion_Default___.Encode(((input).Dtor_verificationKey()).Dtor_value().(_dafny.Sequence)))).MapFailure(func(coer29 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
									return func(arg29 interface{}) interface{} {
										return coer29(arg29.(_dafny.Sequence))
									}
								}(func(_9_e _dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error {
									return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_9_e)
								}))
								_ = _8_valueOrError5
								if (_8_valueOrError5).IsFailure() {
									return (_8_valueOrError5).PropagateFailure()
								} else {
									var _10_enc__vk _dafny.Sequence = (_8_valueOrError5).Extract().(_dafny.Sequence)
									_ = _10_enc__vk
									return m_Wrappers.Companion_Result_.Create_Success_(((input).Dtor_encryptionContext()).Update(Companion_Default___.EC__PUBLIC__KEY__FIELD(), _10_enc__vk))
								}
							}
						}
						{
							var _11_None m_AwsCryptographyMaterialProvidersTypes.SignatureAlgorithm = _source0
							_ = _11_None
							return m_Wrappers.Companion_Result_.Create_Success_((input).Dtor_encryptionContext())
						}
					}()
					_ = _6_valueOrError4
					if (_6_valueOrError4).IsFailure() {
						return (_6_valueOrError4).PropagateFailure()
					} else {
						var _12_encryptionContext _dafny.Map = (_6_valueOrError4).Extract().(_dafny.Map)
						_ = _12_encryptionContext
						return m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyMaterialProvidersTypes.Companion_EncryptionMaterials_.Create_EncryptionMaterials_(_3_suite, _12_encryptionContext, _dafny.SeqOf(), (input).Dtor_requiredEncryptionContextKeys(), m_Wrappers.Companion_Option_.Create_None_(), (input).Dtor_signingKey(), (func() m_Wrappers.Option {
							if ((_3_suite).Dtor_symmetricSignature()).Is_None() {
								return m_Wrappers.Companion_Option_.Create_None_()
							}
							return m_Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOf())
						})()))
					}
				}
			}
		}
	}
}
func (_static *CompanionStruct_Default___) InitializeDecryptionMaterials(input m_AwsCryptographyMaterialProvidersTypes.InitializeDecryptionMaterialsInput) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(_dafny.Quantifier(((input).Dtor_requiredEncryptionContextKeys()).UniqueElements(), true, func(_forall_var_0 _dafny.Sequence) bool {
		var _1_key _dafny.Sequence
		_1_key = interface{}(_forall_var_0).(_dafny.Sequence)
		if m_UTF8.Companion_ValidUTF8Bytes_.Is_(_1_key) {
			return !(_dafny.Companion_Sequence_.Contains((input).Dtor_requiredEncryptionContextKeys(), _1_key)) || (((input).Dtor_encryptionContext()).Contains(_1_key))
		} else {
			return true
		}
	}), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Reproduced encryption context key did not exist in provided encryption context.")))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _2_suite m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo = m_AlgorithmSuites.Companion_Default___.GetSuite((input).Dtor_algorithmSuiteId())
		_ = _2_suite
		var _3_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((((_2_suite).Dtor_signature()).Is_ECDSA()) == (((input).Dtor_encryptionContext()).Contains(Companion_Default___.EC__PUBLIC__KEY__FIELD())), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Encryption Context missing verification key.")))
		_ = _3_valueOrError1
		if (_3_valueOrError1).IsFailure() {
			return (_3_valueOrError1).PropagateFailure()
		} else {
			var _4_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((((_2_suite).Dtor_signature()).Is_None()) == (!((input).Dtor_encryptionContext()).Contains(Companion_Default___.EC__PUBLIC__KEY__FIELD())), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Verification key can not exist in non-signed Algorithm Suites.")))
			_ = _4_valueOrError2
			if (_4_valueOrError2).IsFailure() {
				return (_4_valueOrError2).PropagateFailure()
			} else {
				var _5_valueOrError3 m_Wrappers.Result = Companion_Default___.DecodeVerificationKey((input).Dtor_encryptionContext())
				_ = _5_valueOrError3
				if (_5_valueOrError3).IsFailure() {
					return (_5_valueOrError3).PropagateFailure()
				} else {
					var _6_verificationKey m_Wrappers.Option = (_5_valueOrError3).Extract().(m_Wrappers.Option)
					_ = _6_verificationKey
					return m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyMaterialProvidersTypes.Companion_DecryptionMaterials_.Create_DecryptionMaterials_(_2_suite, (input).Dtor_encryptionContext(), (input).Dtor_requiredEncryptionContextKeys(), m_Wrappers.Companion_Option_.Create_None_(), _6_verificationKey, m_Wrappers.Companion_Option_.Create_None_()))
				}
			}
		}
	}
}
func (_static *CompanionStruct_Default___) DecodeVerificationKey(encryptionContext _dafny.Map) m_Wrappers.Result {
	if (encryptionContext).Contains(Companion_Default___.EC__PUBLIC__KEY__FIELD()) {
		var _0_utf8Key _dafny.Sequence = (encryptionContext).Get(Companion_Default___.EC__PUBLIC__KEY__FIELD()).(_dafny.Sequence)
		_ = _0_utf8Key
		var _1_valueOrError0 m_Wrappers.Result = (m_UTF8.Decode(_0_utf8Key)).MapFailure(func(coer30 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg30 interface{}) interface{} {
				return coer30(arg30.(_dafny.Sequence))
			}
		}(func(_2_e _dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error {
			return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_2_e)
		}))
		_ = _1_valueOrError0
		if (_1_valueOrError0).IsFailure() {
			return (_1_valueOrError0).PropagateFailure()
		} else {
			var _3_base64Key _dafny.Sequence = (_1_valueOrError0).Extract().(_dafny.Sequence)
			_ = _3_base64Key
			var _4_valueOrError1 m_Wrappers.Result = (m_Base64.Companion_Default___.Decode(_3_base64Key)).MapFailure(func(coer31 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
				return func(arg31 interface{}) interface{} {
					return coer31(arg31.(_dafny.Sequence))
				}
			}(func(_5_e _dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error {
				return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_5_e)
			}))
			_ = _4_valueOrError1
			if (_4_valueOrError1).IsFailure() {
				return (_4_valueOrError1).PropagateFailure()
			} else {
				var _6_key _dafny.Sequence = (_4_valueOrError1).Extract().(_dafny.Sequence)
				_ = _6_key
				return m_Wrappers.Companion_Result_.Create_Success_(m_Wrappers.Companion_Option_.Create_Some_(_6_key))
			}
		}
	} else {
		return m_Wrappers.Companion_Result_.Create_Success_(m_Wrappers.Companion_Option_.Create_None_())
	}
}
func (_static *CompanionStruct_Default___) ValidEncryptionMaterialsTransition(oldMat m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials, newMat m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials) bool {
	return ((((((((((((newMat).Dtor_algorithmSuite()).Equals((oldMat).Dtor_algorithmSuite())) && (((newMat).Dtor_encryptionContext()).Equals((oldMat).Dtor_encryptionContext()))) && (_dafny.Companion_Sequence_.Equal((newMat).Dtor_requiredEncryptionContextKeys(), (oldMat).Dtor_requiredEncryptionContextKeys()))) && (((newMat).Dtor_signingKey()).Equals((oldMat).Dtor_signingKey()))) && (((((oldMat).Dtor_plaintextDataKey()).Is_None()) && (((newMat).Dtor_plaintextDataKey()).Is_Some())) || (((oldMat).Dtor_plaintextDataKey()).Equals((newMat).Dtor_plaintextDataKey())))) && (((newMat).Dtor_plaintextDataKey()).Is_Some())) && ((uint64(((oldMat).Dtor_encryptedDataKeys()).Cardinality())) <= (uint64(((newMat).Dtor_encryptedDataKeys()).Cardinality())))) && ((_dafny.MultiSetFromSeq((oldMat).Dtor_encryptedDataKeys())).IsSubsetOf(_dafny.MultiSetFromSeq((newMat).Dtor_encryptedDataKeys())))) && (!(!((((oldMat).Dtor_algorithmSuite()).Dtor_symmetricSignature()).Is_None())) || (((((newMat).Dtor_symmetricSigningKeys()).Is_Some()) && ((((oldMat).Dtor_symmetricSigningKeys()).Is_Some()) || ((((oldMat).Dtor_symmetricSigningKeys()).Is_None()) && ((uint64(((oldMat).Dtor_encryptedDataKeys()).Cardinality())) == (uint64(0)))))) && ((_dafny.MultiSetFromSeq(((oldMat).Dtor_symmetricSigningKeys()).UnwrapOr(_dafny.SeqOf()).(_dafny.Sequence))).IsSubsetOf(_dafny.MultiSetFromSeq(((newMat).Dtor_symmetricSigningKeys()).Dtor_value().(_dafny.Sequence))))))) && (Companion_Default___.ValidEncryptionMaterials(oldMat))) && (Companion_Default___.ValidEncryptionMaterials(newMat))
}
func (_static *CompanionStruct_Default___) ValidEncryptionMaterials(encryptionMaterials m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials) bool {
	var _pat_let_tv0 = encryptionMaterials
	_ = _pat_let_tv0
	var _pat_let_tv1 = encryptionMaterials
	_ = _pat_let_tv1
	var _pat_let_tv2 = encryptionMaterials
	_ = _pat_let_tv2
	var _pat_let_tv3 = encryptionMaterials
	_ = _pat_let_tv3
	var _pat_let_tv4 = encryptionMaterials
	_ = _pat_let_tv4
	var _pat_let_tv5 = encryptionMaterials
	_ = _pat_let_tv5
	var _pat_let_tv6 = encryptionMaterials
	_ = _pat_let_tv6
	var _pat_let_tv7 = encryptionMaterials
	_ = _pat_let_tv7
	var _pat_let_tv8 = encryptionMaterials
	_ = _pat_let_tv8
	var _pat_let_tv9 = encryptionMaterials
	_ = _pat_let_tv9
	var _pat_let_tv10 = encryptionMaterials
	_ = _pat_let_tv10
	var _pat_let_tv11 = encryptionMaterials
	_ = _pat_let_tv11
	var _pat_let_tv12 = encryptionMaterials
	_ = _pat_let_tv12
	var _pat_let_tv13 = encryptionMaterials
	_ = _pat_let_tv13
	var _pat_let_tv14 = encryptionMaterials
	_ = _pat_let_tv14
	var _pat_let_tv15 = encryptionMaterials
	_ = _pat_let_tv15
	var _pat_let_tv16 = encryptionMaterials
	_ = _pat_let_tv16
	var _pat_let_tv17 = encryptionMaterials
	_ = _pat_let_tv17
	return (m_AlgorithmSuites.Companion_Default___.AlgorithmSuite_q((encryptionMaterials).Dtor_algorithmSuite())) && (func(_pat_let2_0 m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo) bool {
		return func(_0_suite m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo) bool {
			return ((((((((((((_0_suite).Dtor_signature()).Is_None()) == (((_pat_let_tv0).Dtor_signingKey()).Is_None())) && (!(((_pat_let_tv1).Dtor_plaintextDataKey()).Is_Some()) || ((uint64(m_AlgorithmSuites.Companion_Default___.GetEncryptKeyLength(_0_suite))) == (uint64((((_pat_let_tv2).Dtor_plaintextDataKey()).Dtor_value().(_dafny.Sequence)).Cardinality()))))) && (!(((_pat_let_tv3).Dtor_plaintextDataKey()).Is_None()) || ((uint64(((_pat_let_tv4).Dtor_encryptedDataKeys()).Cardinality())) == (uint64(0))))) && ((!(((_0_suite).Dtor_signature()).Is_None())) == (((_pat_let_tv5).Dtor_encryptionContext()).Contains(Companion_Default___.EC__PUBLIC__KEY__FIELD())))) && ((((_0_suite).Dtor_signature()).Is_ECDSA()) == (((_pat_let_tv6).Dtor_signingKey()).Is_Some()))) && ((!(((_0_suite).Dtor_signature()).Is_None())) == (((_pat_let_tv7).Dtor_encryptionContext()).Contains(Companion_Default___.EC__PUBLIC__KEY__FIELD())))) && (!((((_0_suite).Dtor_symmetricSignature()).Is_HMAC()) && (((_pat_let_tv8).Dtor_symmetricSigningKeys()).Is_Some())) || ((uint64((((_pat_let_tv9).Dtor_symmetricSigningKeys()).Dtor_value().(_dafny.Sequence)).Cardinality())) == (uint64(((_pat_let_tv10).Dtor_encryptedDataKeys()).Cardinality()))))) && (!(((_0_suite).Dtor_symmetricSignature()).Is_HMAC()) || ((((_pat_let_tv11).Dtor_symmetricSigningKeys()).Is_Some()) || (((uint64(((_pat_let_tv12).Dtor_encryptedDataKeys()).Cardinality())) == (uint64(0))) && (((_pat_let_tv13).Dtor_symmetricSigningKeys()).Is_None()))))) && (!(((_0_suite).Dtor_symmetricSignature()).Is_None()) || (((_pat_let_tv14).Dtor_symmetricSigningKeys()).Is_None()))) && (_dafny.Quantifier(((_pat_let_tv15).Dtor_requiredEncryptionContextKeys()).UniqueElements(), true, func(_forall_var_0 _dafny.Sequence) bool {
				var _1_key _dafny.Sequence
				_1_key = interface{}(_forall_var_0).(_dafny.Sequence)
				if m_UTF8.Companion_ValidUTF8Bytes_.Is_(_1_key) {
					return !(_dafny.Companion_Sequence_.Contains((_pat_let_tv16).Dtor_requiredEncryptionContextKeys(), _1_key)) || (((_pat_let_tv17).Dtor_encryptionContext()).Contains(_1_key))
				} else {
					return true
				}
			}))
		}(_pat_let2_0)
	}((encryptionMaterials).Dtor_algorithmSuite()))
}
func (_static *CompanionStruct_Default___) EncryptionMaterialsHasPlaintextDataKey(encryptionMaterials m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials) bool {
	return ((((encryptionMaterials).Dtor_plaintextDataKey()).Is_Some()) && ((uint64(((encryptionMaterials).Dtor_encryptedDataKeys()).Cardinality())) > (uint64(0)))) && (Companion_Default___.ValidEncryptionMaterials(encryptionMaterials))
}
func (_static *CompanionStruct_Default___) EncryptionMaterialAddEncryptedDataKeys(encryptionMaterials m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials, encryptedDataKeysToAdd _dafny.Sequence, symmetricSigningKeysToAdd m_Wrappers.Option) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(Companion_Default___.ValidEncryptionMaterials(encryptionMaterials), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_InvalidEncryptionMaterialsTransition_(_dafny.SeqOfString("Attempt to modify invalid encryption material.")))
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(((encryptionMaterials).Dtor_plaintextDataKey()).Is_Some(), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_InvalidEncryptionMaterialsTransition_(_dafny.SeqOfString("Adding encrypted data keys without a plaintext data key is not allowed.")))
		_ = _1_valueOrError1
		if (_1_valueOrError1).IsFailure() {
			return (_1_valueOrError1).PropagateFailure()
		} else {
			var _2_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(!((symmetricSigningKeysToAdd).Is_None()) || ((((encryptionMaterials).Dtor_algorithmSuite()).Dtor_symmetricSignature()).Is_None()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_InvalidEncryptionMaterialsTransition_(_dafny.SeqOfString("Adding encrypted data keys without a symmetric signing key when using symmetric signing is not allowed.")))
			_ = _2_valueOrError2
			if (_2_valueOrError2).IsFailure() {
				return (_2_valueOrError2).PropagateFailure()
			} else {
				var _3_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(!((symmetricSigningKeysToAdd).Is_Some()) || (!((((encryptionMaterials).Dtor_algorithmSuite()).Dtor_symmetricSignature()).Is_None())), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_InvalidEncryptionMaterialsTransition_(_dafny.SeqOfString("Adding encrypted data keys with a symmetric signing key when not using symmetric signing is not allowed.")))
				_ = _3_valueOrError3
				if (_3_valueOrError3).IsFailure() {
					return (_3_valueOrError3).PropagateFailure()
				} else {
					var _4_symmetricSigningKeys m_Wrappers.Option = (func() m_Wrappers.Option {
						if (symmetricSigningKeysToAdd).Is_None() {
							return (encryptionMaterials).Dtor_symmetricSigningKeys()
						}
						return m_Wrappers.Companion_Option_.Create_Some_(_dafny.Companion_Sequence_.Concatenate(((encryptionMaterials).Dtor_symmetricSigningKeys()).UnwrapOr(_dafny.SeqOf()).(_dafny.Sequence), (symmetricSigningKeysToAdd).Dtor_value().(_dafny.Sequence)))
					})()
					_ = _4_symmetricSigningKeys
					return m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyMaterialProvidersTypes.Companion_EncryptionMaterials_.Create_EncryptionMaterials_((encryptionMaterials).Dtor_algorithmSuite(), (encryptionMaterials).Dtor_encryptionContext(), _dafny.Companion_Sequence_.Concatenate((encryptionMaterials).Dtor_encryptedDataKeys(), encryptedDataKeysToAdd), (encryptionMaterials).Dtor_requiredEncryptionContextKeys(), (encryptionMaterials).Dtor_plaintextDataKey(), (encryptionMaterials).Dtor_signingKey(), _4_symmetricSigningKeys))
				}
			}
		}
	}
}
func (_static *CompanionStruct_Default___) EncryptionMaterialAddDataKey(encryptionMaterials m_AwsCryptographyMaterialProvidersTypes.EncryptionMaterials, plaintextDataKey _dafny.Sequence, encryptedDataKeysToAdd _dafny.Sequence, symmetricSigningKeysToAdd m_Wrappers.Option) m_Wrappers.Result {
	var _0_suite m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo = (encryptionMaterials).Dtor_algorithmSuite()
	_ = _0_suite
	var _1_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(Companion_Default___.ValidEncryptionMaterials(encryptionMaterials), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_InvalidEncryptionMaterialsTransition_(_dafny.SeqOfString("Attempt to modify invalid encryption material.")))
	_ = _1_valueOrError0
	if (_1_valueOrError0).IsFailure() {
		return (_1_valueOrError0).PropagateFailure()
	} else {
		var _2_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(((encryptionMaterials).Dtor_plaintextDataKey()).Is_None(), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_InvalidEncryptionMaterialsTransition_(_dafny.SeqOfString("Attempt to modify plaintextDataKey.")))
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			var _3_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((uint64(m_AlgorithmSuites.Companion_Default___.GetEncryptKeyLength(_0_suite))) == (uint64((plaintextDataKey).Cardinality())), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_InvalidEncryptionMaterialsTransition_(_dafny.SeqOfString("plaintextDataKey does not match Algorithm Suite specification.")))
			_ = _3_valueOrError2
			if (_3_valueOrError2).IsFailure() {
				return (_3_valueOrError2).PropagateFailure()
			} else {
				var _4_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(((symmetricSigningKeysToAdd).Is_None()) == ((((encryptionMaterials).Dtor_algorithmSuite()).Dtor_symmetricSignature()).Is_None()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_InvalidEncryptionMaterialsTransition_(_dafny.SeqOfString("Adding encrypted data keys without a symmetric signing key when using symmetric signing is not allowed.")))
				_ = _4_valueOrError3
				if (_4_valueOrError3).IsFailure() {
					return (_4_valueOrError3).PropagateFailure()
				} else {
					var _5_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(((symmetricSigningKeysToAdd).Is_Some()) == (!((((encryptionMaterials).Dtor_algorithmSuite()).Dtor_symmetricSignature()).Is_None())), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_InvalidEncryptionMaterialsTransition_(_dafny.SeqOfString("Adding encrypted data keys with a symmetric signing key when not using symmetric signing is not allowed.")))
					_ = _5_valueOrError4
					if (_5_valueOrError4).IsFailure() {
						return (_5_valueOrError4).PropagateFailure()
					} else {
						var _6_symmetricSigningKeys m_Wrappers.Option = (func() m_Wrappers.Option {
							if (symmetricSigningKeysToAdd).Is_None() {
								return (encryptionMaterials).Dtor_symmetricSigningKeys()
							}
							return m_Wrappers.Companion_Option_.Create_Some_(_dafny.Companion_Sequence_.Concatenate(((encryptionMaterials).Dtor_symmetricSigningKeys()).UnwrapOr(_dafny.SeqOf()).(_dafny.Sequence), (symmetricSigningKeysToAdd).Dtor_value().(_dafny.Sequence)))
						})()
						_ = _6_symmetricSigningKeys
						return m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyMaterialProvidersTypes.Companion_EncryptionMaterials_.Create_EncryptionMaterials_((encryptionMaterials).Dtor_algorithmSuite(), (encryptionMaterials).Dtor_encryptionContext(), _dafny.Companion_Sequence_.Concatenate((encryptionMaterials).Dtor_encryptedDataKeys(), encryptedDataKeysToAdd), (encryptionMaterials).Dtor_requiredEncryptionContextKeys(), m_Wrappers.Companion_Option_.Create_Some_(plaintextDataKey), (encryptionMaterials).Dtor_signingKey(), _6_symmetricSigningKeys))
					}
				}
			}
		}
	}
}
func (_static *CompanionStruct_Default___) DecryptionMaterialsTransitionIsValid(oldMat m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials, newMat m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials) bool {
	return ((((((((((newMat).Dtor_algorithmSuite()).Equals((oldMat).Dtor_algorithmSuite())) && (((newMat).Dtor_encryptionContext()).Equals((oldMat).Dtor_encryptionContext()))) && (_dafny.Companion_Sequence_.Equal((newMat).Dtor_requiredEncryptionContextKeys(), (oldMat).Dtor_requiredEncryptionContextKeys()))) && (((newMat).Dtor_verificationKey()).Equals((oldMat).Dtor_verificationKey()))) && (((oldMat).Dtor_plaintextDataKey()).Is_None())) && (((newMat).Dtor_plaintextDataKey()).Is_Some())) && (((oldMat).Dtor_symmetricSigningKey()).Is_None())) && (Companion_Default___.ValidDecryptionMaterials(oldMat))) && (Companion_Default___.ValidDecryptionMaterials(newMat))
}
func (_static *CompanionStruct_Default___) ValidDecryptionMaterials(decryptionMaterials m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials) bool {
	var _pat_let_tv0 = decryptionMaterials
	_ = _pat_let_tv0
	var _pat_let_tv1 = decryptionMaterials
	_ = _pat_let_tv1
	var _pat_let_tv2 = decryptionMaterials
	_ = _pat_let_tv2
	var _pat_let_tv3 = decryptionMaterials
	_ = _pat_let_tv3
	var _pat_let_tv4 = decryptionMaterials
	_ = _pat_let_tv4
	var _pat_let_tv5 = decryptionMaterials
	_ = _pat_let_tv5
	var _pat_let_tv6 = decryptionMaterials
	_ = _pat_let_tv6
	var _pat_let_tv7 = decryptionMaterials
	_ = _pat_let_tv7
	var _pat_let_tv8 = decryptionMaterials
	_ = _pat_let_tv8
	var _pat_let_tv9 = decryptionMaterials
	_ = _pat_let_tv9
	var _pat_let_tv10 = decryptionMaterials
	_ = _pat_let_tv10
	return (m_AlgorithmSuites.Companion_Default___.AlgorithmSuite_q((decryptionMaterials).Dtor_algorithmSuite())) && (func(_pat_let3_0 m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo) bool {
		return func(_0_suite m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo) bool {
			return ((((((!(((_pat_let_tv0).Dtor_plaintextDataKey()).Is_Some()) || ((uint64(m_AlgorithmSuites.Companion_Default___.GetEncryptKeyLength(_0_suite))) == (uint64((((_pat_let_tv1).Dtor_plaintextDataKey()).Dtor_value().(_dafny.Sequence)).Cardinality())))) && ((!(((_0_suite).Dtor_signature()).Is_None())) == (((_pat_let_tv2).Dtor_encryptionContext()).Contains(Companion_Default___.EC__PUBLIC__KEY__FIELD())))) && ((((_0_suite).Dtor_signature()).Is_ECDSA()) == (((_pat_let_tv3).Dtor_verificationKey()).Is_Some()))) && ((!(((_0_suite).Dtor_signature()).Is_None())) == (((_pat_let_tv4).Dtor_encryptionContext()).Contains(Companion_Default___.EC__PUBLIC__KEY__FIELD())))) && (!(!(((_0_suite).Dtor_symmetricSignature()).Is_None())) || ((((_pat_let_tv5).Dtor_plaintextDataKey()).Is_Some()) == (((_pat_let_tv6).Dtor_symmetricSigningKey()).Is_Some())))) && (!(((_0_suite).Dtor_symmetricSignature()).Is_None()) || (((_pat_let_tv7).Dtor_symmetricSigningKey()).Is_None()))) && (_dafny.Quantifier(((_pat_let_tv8).Dtor_requiredEncryptionContextKeys()).UniqueElements(), true, func(_forall_var_0 _dafny.Sequence) bool {
				var _1_k _dafny.Sequence
				_1_k = interface{}(_forall_var_0).(_dafny.Sequence)
				if m_UTF8.Companion_ValidUTF8Bytes_.Is_(_1_k) {
					return !(_dafny.Companion_Sequence_.Contains((_pat_let_tv9).Dtor_requiredEncryptionContextKeys(), _1_k)) || (((_pat_let_tv10).Dtor_encryptionContext()).Contains(_1_k))
				} else {
					return true
				}
			}))
		}(_pat_let3_0)
	}((decryptionMaterials).Dtor_algorithmSuite()))
}
func (_static *CompanionStruct_Default___) DecryptionMaterialsAddDataKey(decryptionMaterials m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials, plaintextDataKey _dafny.Sequence, symmetricSigningKey m_Wrappers.Option) m_Wrappers.Result {
	var _0_suite m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo = (decryptionMaterials).Dtor_algorithmSuite()
	_ = _0_suite
	var _1_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(Companion_Default___.ValidDecryptionMaterials(decryptionMaterials), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_InvalidDecryptionMaterialsTransition_(_dafny.SeqOfString("Attempt to modify invalid decryption material.")))
	_ = _1_valueOrError0
	if (_1_valueOrError0).IsFailure() {
		return (_1_valueOrError0).PropagateFailure()
	} else {
		var _2_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(((decryptionMaterials).Dtor_plaintextDataKey()).Is_None(), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_InvalidDecryptionMaterialsTransition_(_dafny.SeqOfString("Attempt to modify plaintextDataKey.")))
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			var _3_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((uint64(m_AlgorithmSuites.Companion_Default___.GetEncryptKeyLength(_0_suite))) == (uint64((plaintextDataKey).Cardinality())), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_InvalidDecryptionMaterialsTransition_(_dafny.SeqOfString("plaintextDataKey does not match Algorithm Suite specification.")))
			_ = _3_valueOrError2
			if (_3_valueOrError2).IsFailure() {
				return (_3_valueOrError2).PropagateFailure()
			} else {
				var _4_valueOrError3 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(((symmetricSigningKey).Is_Some()) == (!((((decryptionMaterials).Dtor_algorithmSuite()).Dtor_symmetricSignature()).Is_None())), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_InvalidDecryptionMaterialsTransition_(_dafny.SeqOfString("symmetric signature key must be added with plaintextDataKey if using an algorithm suite with symmetric signing.")))
				_ = _4_valueOrError3
				if (_4_valueOrError3).IsFailure() {
					return (_4_valueOrError3).PropagateFailure()
				} else {
					var _5_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need(((symmetricSigningKey).Is_None()) == ((((decryptionMaterials).Dtor_algorithmSuite()).Dtor_symmetricSignature()).Is_None()), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_InvalidDecryptionMaterialsTransition_(_dafny.SeqOfString("symmetric signature key cannot be added with plaintextDataKey if using an algorithm suite without symmetric signing.")))
					_ = _5_valueOrError4
					if (_5_valueOrError4).IsFailure() {
						return (_5_valueOrError4).PropagateFailure()
					} else {
						return m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyMaterialProvidersTypes.Companion_DecryptionMaterials_.Create_DecryptionMaterials_((decryptionMaterials).Dtor_algorithmSuite(), (decryptionMaterials).Dtor_encryptionContext(), (decryptionMaterials).Dtor_requiredEncryptionContextKeys(), m_Wrappers.Companion_Option_.Create_Some_(plaintextDataKey), (decryptionMaterials).Dtor_verificationKey(), symmetricSigningKey))
					}
				}
			}
		}
	}
}
func (_static *CompanionStruct_Default___) DecryptionMaterialsWithoutPlaintextDataKey(decryptionMaterials m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials) bool {
	return (((decryptionMaterials).Dtor_plaintextDataKey()).Is_None()) && (Companion_Default___.ValidDecryptionMaterials(decryptionMaterials))
}
func (_static *CompanionStruct_Default___) DecryptionMaterialsWithPlaintextDataKey(decryptionMaterials m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials) bool {
	return (((decryptionMaterials).Dtor_plaintextDataKey()).Is_Some()) && (Companion_Default___.ValidDecryptionMaterials(decryptionMaterials))
}
func (_static *CompanionStruct_Default___) EC__PUBLIC__KEY__FIELD() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(97), uint8(119), uint8(115), uint8(45), uint8(99), uint8(114), uint8(121), uint8(112), uint8(116), uint8(111), uint8(45), uint8(112), uint8(117), uint8(98), uint8(108), uint8(105), uint8(99), uint8(45), uint8(107), uint8(101), uint8(121))
	_ = _0_s
	return _0_s
}
func (_static *CompanionStruct_Default___) RESERVED__KEY__VALUES() _dafny.Set {
	return _dafny.SetOf(Companion_Default___.EC__PUBLIC__KEY__FIELD())
}

// End of class Default__

// Definition of class DecryptionMaterialsPendingPlaintextDataKey
type DecryptionMaterialsPendingPlaintextDataKey struct {
}

func New_DecryptionMaterialsPendingPlaintextDataKey_() *DecryptionMaterialsPendingPlaintextDataKey {
	_this := DecryptionMaterialsPendingPlaintextDataKey{}

	return &_this
}

type CompanionStruct_DecryptionMaterialsPendingPlaintextDataKey_ struct {
}

var Companion_DecryptionMaterialsPendingPlaintextDataKey_ = CompanionStruct_DecryptionMaterialsPendingPlaintextDataKey_{}

func (*DecryptionMaterialsPendingPlaintextDataKey) String() string {
	return "Materials.DecryptionMaterialsPendingPlaintextDataKey"
}

// End of class DecryptionMaterialsPendingPlaintextDataKey

func Type_DecryptionMaterialsPendingPlaintextDataKey_() _dafny.TypeDescriptor {
	return type_DecryptionMaterialsPendingPlaintextDataKey_{}
}

type type_DecryptionMaterialsPendingPlaintextDataKey_ struct {
}

func (_this type_DecryptionMaterialsPendingPlaintextDataKey_) Default() interface{} {
	return m_AwsCryptographyMaterialProvidersTypes.Companion_DecryptionMaterials_.Default()
}

func (_this type_DecryptionMaterialsPendingPlaintextDataKey_) String() string {
	return "Materials.DecryptionMaterialsPendingPlaintextDataKey"
}
func (_this *CompanionStruct_DecryptionMaterialsPendingPlaintextDataKey_) Is_(__source m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials) bool {
	var _0_d m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials = (__source)
	_ = _0_d
	return Companion_Default___.DecryptionMaterialsWithoutPlaintextDataKey(_0_d)
}

// Definition of class SealedDecryptionMaterials
type SealedDecryptionMaterials struct {
}

func New_SealedDecryptionMaterials_() *SealedDecryptionMaterials {
	_this := SealedDecryptionMaterials{}

	return &_this
}

type CompanionStruct_SealedDecryptionMaterials_ struct {
}

var Companion_SealedDecryptionMaterials_ = CompanionStruct_SealedDecryptionMaterials_{}

func (*SealedDecryptionMaterials) String() string {
	return "Materials.SealedDecryptionMaterials"
}

// End of class SealedDecryptionMaterials

func Type_SealedDecryptionMaterials_() _dafny.TypeDescriptor {
	return type_SealedDecryptionMaterials_{}
}

type type_SealedDecryptionMaterials_ struct {
}

func (_this type_SealedDecryptionMaterials_) Default() interface{} {
	return m_AwsCryptographyMaterialProvidersTypes.Companion_DecryptionMaterials_.Default()
}

func (_this type_SealedDecryptionMaterials_) String() string {
	return "Materials.SealedDecryptionMaterials"
}
func (_this *CompanionStruct_SealedDecryptionMaterials_) Is_(__source m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials) bool {
	var _1_d m_AwsCryptographyMaterialProvidersTypes.DecryptionMaterials = (__source)
	_ = _1_d
	return Companion_Default___.DecryptionMaterialsWithPlaintextDataKey(_1_d)
}
