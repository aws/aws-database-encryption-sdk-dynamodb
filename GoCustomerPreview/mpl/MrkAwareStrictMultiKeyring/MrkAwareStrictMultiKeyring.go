// Package MrkAwareStrictMultiKeyring
// Dafny module MrkAwareStrictMultiKeyring compiled into Go

package MrkAwareStrictMultiKeyring

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
	m_MultiKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/MultiKeyring"
	m_RawAESKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/RawAESKeyring"
	m_RawECDHKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/RawECDHKeyring"
	m_RawRSAKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/RawRSAKeyring"
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
var _ m_AwsKmsRsaKeyring.Dummy__
var _ m_MultiKeyring.Dummy__
var _ m_AwsKmsMrkAreUnique.Dummy__
var _ m_StrictMultiKeyring.Dummy__
var _ m_DiscoveryMultiKeyring.Dummy__
var _ m_MrkAwareDiscoveryMultiKeyring.Dummy__

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
	return "MrkAwareStrictMultiKeyring.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) MrkAwareStrictMultiKeyring(generator m_Wrappers.Option, awsKmsKeys m_Wrappers.Option, clientSupplier m_AwsCryptographyMaterialProvidersTypes.IClientSupplier, grantTokens m_Wrappers.Option) m_Wrappers.Result {
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
	_2_valueOrError0 = (m_Seq.Companion_Default___.MapWithResult(func(coer121 func(_dafny.Sequence) m_Wrappers.Result) func(interface{}) m_Wrappers.Result {
		return func(arg122 interface{}) m_Wrappers.Result {
			return coer121(arg122.(_dafny.Sequence))
		}
	}(m_AwsArnParsing.Companion_Default___.IsAwsKmsIdentifierString), _0_allStrings)).MapFailure(func(coer122 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
		return func(arg123 interface{}) interface{} {
			return coer122(arg123.(_dafny.Sequence))
		}
	}(m_AwsKmsUtils.Companion_Default___.WrapStringToError))
	if (_2_valueOrError0).IsFailure() {
		output = (_2_valueOrError0).PropagateFailure()
		return output
	}
	var _3_allIdentifiers _dafny.Sequence
	_ = _3_allIdentifiers
	_3_allIdentifiers = (_2_valueOrError0).Extract().(_dafny.Sequence)
	var _4_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _4_valueOrError1
	_4_valueOrError1 = m_AwsKmsMrkAreUnique.Companion_Default___.AwsKmsMrkAreUnique(_3_allIdentifiers)
	if (_4_valueOrError1).IsFailure() {
		output = (_4_valueOrError1).PropagateFailure()
		return output
	}
	var _5_generatorKeyring m_Wrappers.Option = m_Wrappers.Companion_Option_.Default()
	_ = _5_generatorKeyring
	var _source1 m_Wrappers.Option = generator
	_ = _source1
	{
		{
			if _source1.Is_Some() {
				var _6_generatorIdentifier _dafny.Sequence = _source1.Get_().(m_Wrappers.Option_Some).Value.(_dafny.Sequence)
				_ = _6_generatorIdentifier
				var _7_valueOrError2 m_Wrappers.Result = m_Wrappers.Result{}
				_ = _7_valueOrError2
				_7_valueOrError2 = (m_AwsArnParsing.Companion_Default___.IsAwsKmsIdentifierString(_6_generatorIdentifier)).MapFailure(func(coer123 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
					return func(arg124 interface{}) interface{} {
						return coer123(arg124.(_dafny.Sequence))
					}
				}(m_AwsKmsUtils.Companion_Default___.WrapStringToError))
				if (_7_valueOrError2).IsFailure() {
					output = (_7_valueOrError2).PropagateFailure()
					return output
				}
				var _8_arn m_AwsArnParsing.AwsKmsIdentifier
				_ = _8_arn
				_8_arn = (_7_valueOrError2).Extract().(m_AwsArnParsing.AwsKmsIdentifier)
				var _9_region m_Wrappers.Option
				_ = _9_region
				_9_region = m_AwsArnParsing.Companion_Default___.GetRegion(_8_arn)
				var _10_valueOrError3 m_Wrappers.Result = m_Wrappers.Result{}
				_ = _10_valueOrError3
				var _out0 m_Wrappers.Result
				_ = _out0
				_out0 = (clientSupplier).GetClient(m_AwsCryptographyMaterialProvidersTypes.Companion_GetClientInput_.Create_GetClientInput_((_9_region).UnwrapOr(_dafny.SeqOfString("")).(_dafny.Sequence)))
				_10_valueOrError3 = _out0
				if (_10_valueOrError3).IsFailure() {
					output = (_10_valueOrError3).PropagateFailure()
					return output
				}
				var _11_client m_ComAmazonawsKmsTypes.IKMSClient
				_ = _11_client
				_11_client = m_ComAmazonawsKmsTypes.Companion_IKMSClient_.CastTo_((_10_valueOrError3).Extract())
				var _12_g *m_AwsKmsMrkKeyring.AwsKmsMrkKeyring
				_ = _12_g
				var _nw0 *m_AwsKmsMrkKeyring.AwsKmsMrkKeyring = m_AwsKmsMrkKeyring.New_AwsKmsMrkKeyring_()
				_ = _nw0
				_nw0.Ctor__(_11_client, _6_generatorIdentifier, (grantTokens).UnwrapOr(_dafny.SeqOf()).(_dafny.Sequence))
				_12_g = _nw0
				_5_generatorKeyring = m_Wrappers.Companion_Option_.Create_Some_(_12_g)
				goto Lmatch1
			}
		}
		{
			_5_generatorKeyring = m_Wrappers.Companion_Option_.Create_None_()
		}
		goto Lmatch1
	}
Lmatch1:
	var _13_children _dafny.Sequence
	_ = _13_children
	_13_children = _dafny.SeqOf()
	var _source2 m_Wrappers.Option = awsKmsKeys
	_ = _source2
	{
		{
			if _source2.Is_Some() {
				var _14_childIdentifiers _dafny.Sequence = _source2.Get_().(m_Wrappers.Option_Some).Value.(_dafny.Sequence)
				_ = _14_childIdentifiers
				var _hi0 uint64 = uint64((_14_childIdentifiers).Cardinality())
				_ = _hi0
				for _15_index := uint64(0); _15_index < _hi0; _15_index++ {
					var _16_childIdentifier _dafny.Sequence
					_ = _16_childIdentifier
					_16_childIdentifier = (_14_childIdentifiers).Select(uint32(_15_index)).(_dafny.Sequence)
					var _17_valueOrError4 m_Wrappers.Result = m_Wrappers.Result{}
					_ = _17_valueOrError4
					_17_valueOrError4 = (m_AwsArnParsing.Companion_Default___.IsAwsKmsIdentifierString(_16_childIdentifier)).MapFailure(func(coer124 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
						return func(arg125 interface{}) interface{} {
							return coer124(arg125.(_dafny.Sequence))
						}
					}(m_AwsKmsUtils.Companion_Default___.WrapStringToError))
					if (_17_valueOrError4).IsFailure() {
						output = (_17_valueOrError4).PropagateFailure()
						return output
					}
					var _18_info m_AwsArnParsing.AwsKmsIdentifier
					_ = _18_info
					_18_info = (_17_valueOrError4).Extract().(m_AwsArnParsing.AwsKmsIdentifier)
					var _19_region m_Wrappers.Option
					_ = _19_region
					_19_region = m_AwsArnParsing.Companion_Default___.GetRegion(_18_info)
					var _20_valueOrError5 m_Wrappers.Result = m_Wrappers.Result{}
					_ = _20_valueOrError5
					var _out1 m_Wrappers.Result
					_ = _out1
					_out1 = (clientSupplier).GetClient(m_AwsCryptographyMaterialProvidersTypes.Companion_GetClientInput_.Create_GetClientInput_((_19_region).UnwrapOr(_dafny.SeqOfString("")).(_dafny.Sequence)))
					_20_valueOrError5 = _out1
					if (_20_valueOrError5).IsFailure() {
						output = (_20_valueOrError5).PropagateFailure()
						return output
					}
					var _21_client m_ComAmazonawsKmsTypes.IKMSClient
					_ = _21_client
					_21_client = m_ComAmazonawsKmsTypes.Companion_IKMSClient_.CastTo_((_20_valueOrError5).Extract())
					var _22_keyring *m_AwsKmsMrkKeyring.AwsKmsMrkKeyring
					_ = _22_keyring
					var _nw1 *m_AwsKmsMrkKeyring.AwsKmsMrkKeyring = m_AwsKmsMrkKeyring.New_AwsKmsMrkKeyring_()
					_ = _nw1
					_nw1.Ctor__(_21_client, _16_childIdentifier, (grantTokens).UnwrapOr(_dafny.SeqOf()).(_dafny.Sequence))
					_22_keyring = _nw1
					_13_children = _dafny.Companion_Sequence_.Concatenate(_13_children, _dafny.SeqOf(_22_keyring))
				}
				goto Lmatch2
			}
		}
		{
			_13_children = _dafny.SeqOf()
		}
		goto Lmatch2
	}
Lmatch2:
	var _23_valueOrError6 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _23_valueOrError6
	_23_valueOrError6 = m_Wrappers.Companion_Default___.Need(((_5_generatorKeyring).Is_Some()) || ((uint64((_13_children).Cardinality())) > (uint64(0))), m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("generatorKeyring or child Keyrings needed to create a multi keyring")))
	if (_23_valueOrError6).IsFailure() {
		output = (_23_valueOrError6).PropagateFailure()
		return output
	}
	var _24_keyring *m_MultiKeyring.MultiKeyring
	_ = _24_keyring
	var _nw2 *m_MultiKeyring.MultiKeyring = m_MultiKeyring.New_MultiKeyring_()
	_ = _nw2
	_nw2.Ctor__(_5_generatorKeyring, _13_children)
	_24_keyring = _nw2
	output = m_Wrappers.Companion_Result_.Create_Success_(_24_keyring)
	return output
	return output
}

// End of class Default__
