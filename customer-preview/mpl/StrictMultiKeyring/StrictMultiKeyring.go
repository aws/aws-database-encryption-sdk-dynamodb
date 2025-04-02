// Package StrictMultiKeyring
// Dafny module StrictMultiKeyring compiled into Go

package StrictMultiKeyring

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
	m_AwsKmsKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsKeyring"
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
	return "StrictMultiKeyring.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) StrictMultiKeyring(generator m_Wrappers.Option, awsKmsKeys m_Wrappers.Option, clientSupplier m_AwsCryptographyMaterialProvidersTypes.IClientSupplier, grantTokens m_Wrappers.Option) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Result{}
	_ = output
	var _0_allStrings _dafny.Sequence
	_ = _0_allStrings
	var _source0 m_Wrappers.Option = generator
	_ = _source0
	{
		{
			if _source0.Is_Some() {
				var _1_g _dafny.Sequence = _source0.Get_().(m_Wrappers.Option_Some).Value.(_dafny.Sequence)
				_ = _1_g
				_0_allStrings = _dafny.Companion_Sequence_.Concatenate(_dafny.SeqOf(_1_g), (awsKmsKeys).UnwrapOr(_dafny.SeqOf()).(_dafny.Sequence))
				goto Lmatch0
			}
		}
		{
			_0_allStrings = (awsKmsKeys).UnwrapOr(_dafny.SeqOf()).(_dafny.Sequence)
		}
		goto Lmatch0
	}
Lmatch0:
	var _2_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _2_valueOrError0
	_2_valueOrError0 = (m_Seq.Companion_Default___.MapWithResult(func(coer59 func(_dafny.Sequence) m_Wrappers.Result) func(interface{}) m_Wrappers.Result {
		return func(arg60 interface{}) m_Wrappers.Result {
			return coer59(arg60.(_dafny.Sequence))
		}
	}(m_AwsArnParsing.Companion_Default___.IsAwsKmsIdentifierString), _0_allStrings)).MapFailure(func(coer60 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
		return func(arg61 interface{}) interface{} {
			return coer60(arg61.(_dafny.Sequence))
		}
	}(m_AwsKmsUtils.Companion_Default___.WrapStringToError))
	if (_2_valueOrError0).IsFailure() {
		output = (_2_valueOrError0).PropagateFailure()
		return output
	}
	var _3_allIdentifiers _dafny.Sequence
	_ = _3_allIdentifiers
	_3_allIdentifiers = (_2_valueOrError0).Extract().(_dafny.Sequence)
	var _4_generatorKeyring m_Wrappers.Option = m_Wrappers.Companion_Option_.Default()
	_ = _4_generatorKeyring
	var _source1 m_Wrappers.Option = generator
	_ = _source1
	{
		{
			if _source1.Is_Some() {
				var _5_generatorIdentifier _dafny.Sequence = _source1.Get_().(m_Wrappers.Option_Some).Value.(_dafny.Sequence)
				_ = _5_generatorIdentifier
				var _6_valueOrError1 m_Wrappers.Result = m_Wrappers.Result{}
				_ = _6_valueOrError1
				_6_valueOrError1 = (m_AwsArnParsing.Companion_Default___.IsAwsKmsIdentifierString(_5_generatorIdentifier)).MapFailure(func(coer61 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
					return func(arg62 interface{}) interface{} {
						return coer61(arg62.(_dafny.Sequence))
					}
				}(m_AwsKmsUtils.Companion_Default___.WrapStringToError))
				if (_6_valueOrError1).IsFailure() {
					output = (_6_valueOrError1).PropagateFailure()
					return output
				}
				var _7_arn m_AwsArnParsing.AwsKmsIdentifier
				_ = _7_arn
				_7_arn = (_6_valueOrError1).Extract().(m_AwsArnParsing.AwsKmsIdentifier)
				var _8_region m_Wrappers.Option
				_ = _8_region
				_8_region = m_AwsArnParsing.Companion_Default___.GetRegion(_7_arn)
				var _9_valueOrError2 m_Wrappers.Result = m_Wrappers.Result{}
				_ = _9_valueOrError2
				var _out0 m_Wrappers.Result
				_ = _out0
				_out0 = (clientSupplier).GetClient(m_AwsCryptographyMaterialProvidersTypes.Companion_GetClientInput_.Create_GetClientInput_((_8_region).UnwrapOr(_dafny.SeqOfString("")).(_dafny.Sequence)))
				_9_valueOrError2 = _out0
				if (_9_valueOrError2).IsFailure() {
					output = (_9_valueOrError2).PropagateFailure()
					return output
				}
				var _10_client m_ComAmazonawsKmsTypes.IKMSClient
				_ = _10_client
				_10_client = m_ComAmazonawsKmsTypes.Companion_IKMSClient_.CastTo_((_9_valueOrError2).Extract())
				var _11_g *m_AwsKmsKeyring.AwsKmsKeyring
				_ = _11_g
				var _nw0 *m_AwsKmsKeyring.AwsKmsKeyring = m_AwsKmsKeyring.New_AwsKmsKeyring_()
				_ = _nw0
				_nw0.Ctor__(_10_client, _5_generatorIdentifier, (grantTokens).UnwrapOr(_dafny.SeqOf()).(_dafny.Sequence))
				_11_g = _nw0
				_4_generatorKeyring = m_Wrappers.Companion_Option_.Create_Some_(_11_g)
				goto Lmatch1
			}
		}
		{
			_4_generatorKeyring = m_Wrappers.Companion_Option_.Create_None_()
		}
		goto Lmatch1
	}
Lmatch1:
	var _12_children _dafny.Sequence
	_ = _12_children
	_12_children = _dafny.SeqOf()
	var _source2 m_Wrappers.Option = awsKmsKeys
	_ = _source2
	{
		{
			if _source2.Is_Some() {
				var _13_childIdentifiers _dafny.Sequence = _source2.Get_().(m_Wrappers.Option_Some).Value.(_dafny.Sequence)
				_ = _13_childIdentifiers
				var _hi0 _dafny.Int = _dafny.IntOfUint32((_13_childIdentifiers).Cardinality())
				_ = _hi0
				for _14_index := _dafny.Zero; _14_index.Cmp(_hi0) < 0; _14_index = _14_index.Plus(_dafny.One) {
					var _15_childIdentifier _dafny.Sequence
					_ = _15_childIdentifier
					_15_childIdentifier = (_13_childIdentifiers).Select((_14_index).Uint32()).(_dafny.Sequence)
					var _16_valueOrError3 m_Wrappers.Result = m_Wrappers.Result{}
					_ = _16_valueOrError3
					_16_valueOrError3 = (m_AwsArnParsing.Companion_Default___.IsAwsKmsIdentifierString(_15_childIdentifier)).MapFailure(func(coer62 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
						return func(arg63 interface{}) interface{} {
							return coer62(arg63.(_dafny.Sequence))
						}
					}(m_AwsKmsUtils.Companion_Default___.WrapStringToError))
					if (_16_valueOrError3).IsFailure() {
						output = (_16_valueOrError3).PropagateFailure()
						return output
					}
					var _17_info m_AwsArnParsing.AwsKmsIdentifier
					_ = _17_info
					_17_info = (_16_valueOrError3).Extract().(m_AwsArnParsing.AwsKmsIdentifier)
					var _18_region m_Wrappers.Option
					_ = _18_region
					_18_region = m_AwsArnParsing.Companion_Default___.GetRegion(_17_info)
					var _19_valueOrError4 m_Wrappers.Result = m_Wrappers.Result{}
					_ = _19_valueOrError4
					var _out1 m_Wrappers.Result
					_ = _out1
					_out1 = (clientSupplier).GetClient(m_AwsCryptographyMaterialProvidersTypes.Companion_GetClientInput_.Create_GetClientInput_((_18_region).UnwrapOr(_dafny.SeqOfString("")).(_dafny.Sequence)))
					_19_valueOrError4 = _out1
					if (_19_valueOrError4).IsFailure() {
						output = (_19_valueOrError4).PropagateFailure()
						return output
					}
					var _20_client m_ComAmazonawsKmsTypes.IKMSClient
					_ = _20_client
					_20_client = m_ComAmazonawsKmsTypes.Companion_IKMSClient_.CastTo_((_19_valueOrError4).Extract())
					var _21_keyring *m_AwsKmsKeyring.AwsKmsKeyring
					_ = _21_keyring
					var _nw1 *m_AwsKmsKeyring.AwsKmsKeyring = m_AwsKmsKeyring.New_AwsKmsKeyring_()
					_ = _nw1
					_nw1.Ctor__(_20_client, _15_childIdentifier, (grantTokens).UnwrapOr(_dafny.SeqOf()).(_dafny.Sequence))
					_21_keyring = _nw1
					_12_children = _dafny.Companion_Sequence_.Concatenate(_12_children, _dafny.SeqOf(_21_keyring))
				}
				goto Lmatch2
			}
		}
		{
			_12_children = _dafny.SeqOf()
		}
		goto Lmatch2
	}
Lmatch2:
	var _22_valueOrError5 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _22_valueOrError5
	_22_valueOrError5 = m_Wrappers.Companion_Default___.Need(((_4_generatorKeyring).Is_Some()) || ((_dafny.IntOfUint32((_12_children).Cardinality())).Sign() == 1), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("generatorKeyring or child Keryings needed to create a multi keyring")))
	if (_22_valueOrError5).IsFailure() {
		output = (_22_valueOrError5).PropagateFailure()
		return output
	}
	var _23_keyring *m_MultiKeyring.MultiKeyring
	_ = _23_keyring
	var _nw2 *m_MultiKeyring.MultiKeyring = m_MultiKeyring.New_MultiKeyring_()
	_ = _nw2
	_nw2.Ctor__(_4_generatorKeyring, _12_children)
	_23_keyring = _nw2
	output = m_Wrappers.Companion_Result_.Create_Success_(_23_keyring)
	return output
	return output
}

// End of class Default__
