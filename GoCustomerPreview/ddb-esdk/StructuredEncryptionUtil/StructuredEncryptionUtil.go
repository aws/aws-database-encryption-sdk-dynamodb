// Package StructuredEncryptionUtil
// Dafny module StructuredEncryptionUtil compiled into Go

package StructuredEncryptionUtil

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
	m_SortedSets "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/SortedSets"
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
	m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes "github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes"
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
	return "StructuredEncryptionUtil.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) CryptoListToSet(xs _dafny.Sequence) _dafny.Set {
	return func() _dafny.Set {
		var _coll0 = _dafny.NewBuilder()
		_ = _coll0
		for _iter0 := _dafny.Iterate((xs).Elements()); ; {
			_compr_0, _ok0 := _iter0()
			if !_ok0 {
				break
			}
			var _0_k m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem
			_0_k = interface{}(_compr_0).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem)
			if _dafny.Companion_Sequence_.Contains(xs, _0_k) {
				_coll0.Add((_0_k).Dtor_key())
			}
		}
		return _coll0.ToSet()
	}()
}
func (_static *CompanionStruct_Default___) CanonCryptoListToSet(xs _dafny.Sequence) _dafny.Set {
	return func() _dafny.Set {
		var _coll0 = _dafny.NewBuilder()
		_ = _coll0
		for _iter1 := _dafny.Iterate((xs).Elements()); ; {
			_compr_0, _ok1 := _iter1()
			if !_ok1 {
				break
			}
			var _0_k CanonCryptoItem
			_0_k = interface{}(_compr_0).(CanonCryptoItem)
			if _dafny.Companion_Sequence_.Contains(xs, _0_k) {
				_coll0.Add((_0_k).Dtor_origKey())
			}
		}
		return _coll0.ToSet()
	}()
}
func (_static *CompanionStruct_Default___) AuthListToSet(xs _dafny.Sequence) _dafny.Set {
	return func() _dafny.Set {
		var _coll0 = _dafny.NewBuilder()
		_ = _coll0
		for _iter2 := _dafny.Iterate((xs).Elements()); ; {
			_compr_0, _ok2 := _iter2()
			if !_ok2 {
				break
			}
			var _0_k m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.AuthItem
			_0_k = interface{}(_compr_0).(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.AuthItem)
			if _dafny.Companion_Sequence_.Contains(xs, _0_k) {
				_coll0.Add((_0_k).Dtor_key())
			}
		}
		return _coll0.ToSet()
	}()
}
func (_static *CompanionStruct_Default___) CryptoListHasNoDuplicatesFromSet(xs _dafny.Sequence) bool {
	return (uint64((Companion_Default___.CryptoListToSet(xs)).CardinalityInt())) == (uint64((xs).Cardinality()))
}
func (_static *CompanionStruct_Default___) AuthListHasNoDuplicatesFromSet(xs _dafny.Sequence) bool {
	return (uint64((Companion_Default___.AuthListToSet(xs)).CardinalityInt())) == (uint64((xs).Cardinality()))
}
func (_static *CompanionStruct_Default___) ValidString(x _dafny.Sequence) bool {
	return (m_StandardLibrary_UInt.Companion_Default___.HasUint64Len(x)) && ((m_UTF8.Encode(x)).Is_Success())
}
func (_static *CompanionStruct_Default___) ValidSuite(alg m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo) bool {
	return (((alg).Dtor_id()).Is_DBE()) && (m_AlgorithmSuites.Companion_Default___.DBEAlgorithmSuite_q(alg))
}
func (_static *CompanionStruct_Default___) E(s _dafny.Sequence) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error {
	return m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_Error_.Create_StructuredEncryptionException_(s)
}
func (_static *CompanionStruct_Default___) ConstantTimeCompare(a _dafny.Sequence, b _dafny.Sequence, pos uint64, acc uint8) uint8 {
	goto TAIL_CALL_START
TAIL_CALL_START:
	if (uint64((a).Cardinality())) == (pos) {
		return acc
	} else {
		var _0_x uint8 = (uint8((a).Select(uint32(pos)).(uint8))) ^ (uint8((b).Select(uint32(pos)).(uint8)))
		_ = _0_x
		var _in0 _dafny.Sequence = a
		_ = _in0
		var _in1 _dafny.Sequence = b
		_ = _in1
		var _in2 uint64 = (pos) + (uint64(1))
		_ = _in2
		var _in3 uint8 = (_0_x) | (acc)
		_ = _in3
		a = _in0
		b = _in1
		pos = _in2
		acc = _in3
		goto TAIL_CALL_START
	}
}
func (_static *CompanionStruct_Default___) ConstantTimeEquals(a _dafny.Sequence, b _dafny.Sequence) bool {
	return (Companion_Default___.ConstantTimeCompare(a, b, uint64(0), uint8(0))) == (uint8(0))
}
func (_static *CompanionStruct_Default___) IsAuthAttr(x m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction) bool {
	return !((x).Is_DO__NOTHING())
}
func (_static *CompanionStruct_Default___) ValueToData(value _dafny.Sequence, typeId _dafny.Sequence) m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal {
	return m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_StructuredDataTerminal_.Create_StructuredDataTerminal_(value, typeId)
}
func (_static *CompanionStruct_Default___) GetValue(data m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal) _dafny.Sequence {
	return (data).Dtor_value()
}
func (_static *CompanionStruct_Default___) ByteLess(x uint8, y uint8) bool {
	return (x) < (y)
}
func (_static *CompanionStruct_Default___) CharLess(x _dafny.Char, y _dafny.Char) bool {
	return (x) < (y)
}
func (_static *CompanionStruct_Default___) EcAsString(ec _dafny.Map) _dafny.Map {
	var output _dafny.Map = _dafny.EmptyMap
	_ = output
	var _0_keys _dafny.Sequence
	_ = _0_keys
	_0_keys = m_SortedSets.SetToOrderedSequence2((ec).Keys(), func(coer0 func(uint8, uint8) bool) func(interface{}, interface{}) bool {
		return func(arg0 interface{}, arg1 interface{}) bool {
			return coer0(arg0.(uint8), arg1.(uint8))
		}
	}(Companion_Default___.ByteLess))
	var _1_ret _dafny.Map
	_ = _1_ret
	_1_ret = _dafny.NewMapBuilder().ToMap()
	var _hi0 uint64 = uint64((_0_keys).Cardinality())
	_ = _hi0
	for _2_i := uint64(0); _2_i < _hi0; _2_i++ {
		var _3_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
		_ = _3_valueOrError0
		_3_valueOrError0 = m_UTF8.Decode((_0_keys).Select(uint32(_2_i)).(_dafny.Sequence))
		if !(!((_3_valueOrError0).IsFailure())) {
			panic("dafny/StructuredEncryption/src/Util.dfy(304,17): " + (_3_valueOrError0).String())
		}
		var _4_key _dafny.Sequence
		_ = _4_key
		_4_key = (_3_valueOrError0).Extract().(_dafny.Sequence)
		var _5_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
		_ = _5_valueOrError1
		_5_valueOrError1 = m_UTF8.Decode((ec).Get((_0_keys).Select(uint32(_2_i)).(_dafny.Sequence)).(_dafny.Sequence))
		if !(!((_5_valueOrError1).IsFailure())) {
			panic("dafny/StructuredEncryption/src/Util.dfy(305,19): " + (_5_valueOrError1).String())
		}
		var _6_value _dafny.Sequence
		_ = _6_value
		_6_value = (_5_valueOrError1).Extract().(_dafny.Sequence)
		_1_ret = (_1_ret).Update(_4_key, _6_value)
	}
	output = _1_ret
	return output
	return output
}
func (_static *CompanionStruct_Default___) PrintEncryptionContext(ec _dafny.Map, name _dafny.Sequence) {
	var _0_keys _dafny.Sequence
	_ = _0_keys
	_0_keys = m_SortedSets.SetToOrderedSequence2((ec).Keys(), func(coer1 func(uint8, uint8) bool) func(interface{}, interface{}) bool {
		return func(arg2 interface{}, arg3 interface{}) bool {
			return coer1(arg2.(uint8), arg3.(uint8))
		}
	}(Companion_Default___.ByteLess))
	_dafny.Print((name).SetString())
	_dafny.Print((_dafny.SeqOfString(" := {\n")).SetString())
	var _hi0 _dafny.Int = _dafny.IntOfUint32((_0_keys).Cardinality())
	_ = _hi0
	for _1_i := _dafny.Zero; _1_i.Cmp(_hi0) < 0; _1_i = _1_i.Plus(_dafny.One) {
		var _2_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
		_ = _2_valueOrError0
		_2_valueOrError0 = m_UTF8.Decode((_0_keys).Select((_1_i).Uint32()).(_dafny.Sequence))
		if !(!((_2_valueOrError0).IsFailure())) {
			panic("dafny/StructuredEncryption/src/Util.dfy(316,17): " + (_2_valueOrError0).String())
		}
		var _3_key _dafny.Sequence
		_ = _3_key
		_3_key = (_2_valueOrError0).Extract().(_dafny.Sequence)
		var _4_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
		_ = _4_valueOrError1
		_4_valueOrError1 = m_UTF8.Decode((ec).Get((_0_keys).Select((_1_i).Uint32()).(_dafny.Sequence)).(_dafny.Sequence))
		if !(!((_4_valueOrError1).IsFailure())) {
			panic("dafny/StructuredEncryption/src/Util.dfy(317,19): " + (_4_valueOrError1).String())
		}
		var _5_value _dafny.Sequence
		_ = _5_value
		_5_value = (_4_valueOrError1).Extract().(_dafny.Sequence)
		_dafny.Print((_dafny.SeqOfString("  ")).SetString())
		_dafny.Print((_3_key).SetString())
		_dafny.Print((_dafny.SeqOfString(" := ")).SetString())
		_dafny.Print((_5_value).SetString())
		_dafny.Print((_dafny.SeqOfString("\n")).SetString())
	}
	_dafny.Print((_dafny.SeqOfString("}\n")).SetString())
}
func (_static *CompanionStruct_Default___) EncodeTerminal(t m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal) _dafny.Sequence {
	var _0_base _dafny.Sequence = m_Base64.Companion_Default___.Encode(_dafny.Companion_Sequence_.Concatenate((t).Dtor_typeId(), (t).Dtor_value()))
	_ = _0_base
	return (m_UTF8.Encode(_0_base)).Dtor_value().(_dafny.Sequence)
}
func (_static *CompanionStruct_Default___) DecodeTerminal(t _dafny.Sequence) m_Wrappers.Result {
	var _0_valueOrError0 m_Wrappers.Result = m_UTF8.Decode(t)
	_ = _0_valueOrError0
	if (_0_valueOrError0).IsFailure() {
		return (_0_valueOrError0).PropagateFailure()
	} else {
		var _1_utf8DecodedVal _dafny.Sequence = (_0_valueOrError0).Extract().(_dafny.Sequence)
		_ = _1_utf8DecodedVal
		var _2_valueOrError1 m_Wrappers.Result = m_Base64.Companion_Default___.Decode(_1_utf8DecodedVal)
		_ = _2_valueOrError1
		if (_2_valueOrError1).IsFailure() {
			return (_2_valueOrError1).PropagateFailure()
		} else {
			var _3_base64DecodedVal _dafny.Sequence = (_2_valueOrError1).Extract().(_dafny.Sequence)
			_ = _3_base64DecodedVal
			var _4_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Default___.Need((uint64((_3_base64DecodedVal).Cardinality())) >= (uint64(2)), _dafny.SeqOfString("Invalid serialization of DDB Attribute in encryption context."))
			_ = _4_valueOrError2
			if (_4_valueOrError2).IsFailure() {
				return (_4_valueOrError2).PropagateFailure()
			} else {
				var _5_typeId _dafny.Sequence = (_3_base64DecodedVal).Take(uint32(uint32(2)))
				_ = _5_typeId
				var _6_serializedValue _dafny.Sequence = (_3_base64DecodedVal).Drop(uint32(uint32(2)))
				_ = _6_serializedValue
				return m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_StructuredDataTerminal_.Create_StructuredDataTerminal_(_6_serializedValue, _5_typeId))
			}
		}
	}
}
func (_static *CompanionStruct_Default___) ReservedPrefix() _dafny.Sequence {
	return _dafny.SeqOfString("aws_dbe_")
}
func (_static *CompanionStruct_Default___) HeaderField() _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate(Companion_Default___.ReservedPrefix(), _dafny.SeqOfString("head"))
}
func (_static *CompanionStruct_Default___) FooterField() _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate(Companion_Default___.ReservedPrefix(), _dafny.SeqOfString("foot"))
}
func (_static *CompanionStruct_Default___) HeaderPath() _dafny.Sequence {
	return _dafny.SeqOf(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_PathSegment_.Create_member_(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_StructureSegment_.Create_StructureSegment_(Companion_Default___.HeaderField())))
}
func (_static *CompanionStruct_Default___) FooterPath() _dafny.Sequence {
	return _dafny.SeqOf(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_PathSegment_.Create_member_(m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_StructureSegment_.Create_StructureSegment_(Companion_Default___.FooterField())))
}
func (_static *CompanionStruct_Default___) HeaderPaths() _dafny.Sequence {
	return _dafny.SeqOf(Companion_Default___.HeaderPath(), Companion_Default___.FooterPath())
}
func (_static *CompanionStruct_Default___) ReservedCryptoContextPrefixString() _dafny.Sequence {
	return _dafny.SeqOfString("aws-crypto-")
}
func (_static *CompanionStruct_Default___) ReservedCryptoContextPrefixUTF8() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(97), uint8(119), uint8(115), uint8(45), uint8(99), uint8(114), uint8(121), uint8(112), uint8(116), uint8(111), uint8(45))
	_ = _0_s
	return _0_s
}
func (_static *CompanionStruct_Default___) ATTR__PREFIX() _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate(Companion_Default___.ReservedCryptoContextPrefixString(), _dafny.SeqOfString("attr."))
}
func (_static *CompanionStruct_Default___) EC__ATTR__PREFIX() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(97), uint8(119), uint8(115), uint8(45), uint8(99), uint8(114), uint8(121), uint8(112), uint8(116), uint8(111), uint8(45), uint8(97), uint8(116), uint8(116), uint8(114), uint8(46))
	_ = _0_s
	return _0_s
}
func (_static *CompanionStruct_Default___) LEGEND() _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate(Companion_Default___.ReservedCryptoContextPrefixString(), _dafny.SeqOfString("legend"))
}
func (_static *CompanionStruct_Default___) LEGEND__UTF8() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(97), uint8(119), uint8(115), uint8(45), uint8(99), uint8(114), uint8(121), uint8(112), uint8(116), uint8(111), uint8(45), uint8(108), uint8(101), uint8(103), uint8(101), uint8(110), uint8(100))
	_ = _0_s
	return _0_s
}
func (_static *CompanionStruct_Default___) NULL__STR() _dafny.Sequence {
	return _dafny.SeqOfString("null")
}
func (_static *CompanionStruct_Default___) NULL__UTF8() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(110), uint8(117), uint8(108), uint8(108))
	_ = _0_s
	return _0_s
}
func (_static *CompanionStruct_Default___) TRUE__STR() _dafny.Sequence {
	return _dafny.SeqOfString("true")
}
func (_static *CompanionStruct_Default___) TRUE__UTF8() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(116), uint8(114), uint8(117), uint8(101))
	_ = _0_s
	return _0_s
}
func (_static *CompanionStruct_Default___) FALSE__STR() _dafny.Sequence {
	return _dafny.SeqOfString("false")
}
func (_static *CompanionStruct_Default___) FALSE__UTF8() _dafny.Sequence {
	var _0_s _dafny.Sequence = _dafny.SeqOf(uint8(102), uint8(97), uint8(108), uint8(115), uint8(101))
	_ = _0_s
	return _0_s
}
func (_static *CompanionStruct_Default___) BYTES__TYPE__ID() _dafny.Sequence {
	return _dafny.SeqOf(uint8(255), uint8(255))
}
func (_static *CompanionStruct_Default___) TERM__T() uint8 {
	return uint8(0)
}
func (_static *CompanionStruct_Default___) NULL__T() uint8 {
	return uint8(0)
}
func (_static *CompanionStruct_Default___) NULL() _dafny.Sequence {
	return _dafny.SeqOf(Companion_Default___.TERM__T(), Companion_Default___.NULL__T())
}
func (_static *CompanionStruct_Default___) STRING__T() uint8 {
	return uint8(1)
}
func (_static *CompanionStruct_Default___) STRING() _dafny.Sequence {
	return _dafny.SeqOf(Companion_Default___.TERM__T(), Companion_Default___.STRING__T())
}
func (_static *CompanionStruct_Default___) NUMBER__T() uint8 {
	return uint8(2)
}
func (_static *CompanionStruct_Default___) NUMBER() _dafny.Sequence {
	return _dafny.SeqOf(Companion_Default___.TERM__T(), Companion_Default___.NUMBER__T())
}
func (_static *CompanionStruct_Default___) BOOLEAN__T() uint8 {
	return uint8(4)
}
func (_static *CompanionStruct_Default___) BOOLEAN() _dafny.Sequence {
	return _dafny.SeqOf(Companion_Default___.TERM__T(), Companion_Default___.BOOLEAN__T())
}
func (_static *CompanionStruct_Default___) SET__T() uint8 {
	return uint8(1)
}
func (_static *CompanionStruct_Default___) STRING__SET() _dafny.Sequence {
	return _dafny.SeqOf(Companion_Default___.SET__T(), Companion_Default___.STRING__T())
}
func (_static *CompanionStruct_Default___) NUMBER__SET() _dafny.Sequence {
	return _dafny.SeqOf(Companion_Default___.SET__T(), Companion_Default___.NUMBER__T())
}
func (_static *CompanionStruct_Default___) BINARY__T() uint8 {
	return uint8(255)
}
func (_static *CompanionStruct_Default___) BINARY__SET() _dafny.Sequence {
	return _dafny.SeqOf(Companion_Default___.SET__T(), Companion_Default___.BINARY__T())
}
func (_static *CompanionStruct_Default___) MAP__T() uint8 {
	return uint8(2)
}
func (_static *CompanionStruct_Default___) MAP() _dafny.Sequence {
	return _dafny.SeqOf(Companion_Default___.MAP__T(), Companion_Default___.NULL__T())
}
func (_static *CompanionStruct_Default___) LIST__T() uint8 {
	return uint8(3)
}
func (_static *CompanionStruct_Default___) LIST() _dafny.Sequence {
	return _dafny.SeqOf(Companion_Default___.LIST__T(), Companion_Default___.NULL__T())
}
func (_static *CompanionStruct_Default___) LEGEND__STRING() _dafny.Char {
	return _dafny.Char('S')
}
func (_static *CompanionStruct_Default___) LEGEND__NUMBER() _dafny.Char {
	return _dafny.Char('N')
}
func (_static *CompanionStruct_Default___) LEGEND__LITERAL() _dafny.Char {
	return _dafny.Char('L')
}
func (_static *CompanionStruct_Default___) LEGEND__BINARY() _dafny.Char {
	return _dafny.Char('B')
}
func (_static *CompanionStruct_Default___) TYPEID__LEN64() uint64 {
	return uint64(2)
}
func (_static *CompanionStruct_Default___) KeySize64() uint64 {
	return uint64(32)
}
func (_static *CompanionStruct_Default___) NonceSize64() uint64 {
	return uint64(12)
}
func (_static *CompanionStruct_Default___) AuthTagSize64() uint64 {
	return uint64(16)
}
func (_static *CompanionStruct_Default___) MSGID__LEN64() uint64 {
	return uint64(32)
}
func (_static *CompanionStruct_Default___) DbeAlgorithmFamily() uint8 {
	return uint8(103)
}
func (_static *CompanionStruct_Default___) BINARY() _dafny.Sequence {
	return _dafny.SeqOf(uint8(255), uint8(255))
}

// End of class Default__

// Definition of datatype CanonCryptoItem
type CanonCryptoItem struct {
	Data_CanonCryptoItem_
}

func (_this CanonCryptoItem) Get_() Data_CanonCryptoItem_ {
	return _this.Data_CanonCryptoItem_
}

type Data_CanonCryptoItem_ interface {
	isCanonCryptoItem()
}

type CompanionStruct_CanonCryptoItem_ struct {
}

var Companion_CanonCryptoItem_ = CompanionStruct_CanonCryptoItem_{}

type CanonCryptoItem_CanonCryptoItem struct {
	Key     _dafny.Sequence
	OrigKey _dafny.Sequence
	Data    m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal
	Action  m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction
}

func (CanonCryptoItem_CanonCryptoItem) isCanonCryptoItem() {}

func (CompanionStruct_CanonCryptoItem_) Create_CanonCryptoItem_(Key _dafny.Sequence, OrigKey _dafny.Sequence, Data m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal, Action m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction) CanonCryptoItem {
	return CanonCryptoItem{CanonCryptoItem_CanonCryptoItem{Key, OrigKey, Data, Action}}
}

func (_this CanonCryptoItem) Is_CanonCryptoItem() bool {
	_, ok := _this.Get_().(CanonCryptoItem_CanonCryptoItem)
	return ok
}

func (CompanionStruct_CanonCryptoItem_) Default() CanonCryptoItem {
	return Companion_CanonCryptoItem_.Create_CanonCryptoItem_(_dafny.EmptySeq, _dafny.EmptySeq, m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_StructuredDataTerminal_.Default(), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_CryptoAction_.Default())
}

func (_this CanonCryptoItem) Dtor_key() _dafny.Sequence {
	return _this.Get_().(CanonCryptoItem_CanonCryptoItem).Key
}

func (_this CanonCryptoItem) Dtor_origKey() _dafny.Sequence {
	return _this.Get_().(CanonCryptoItem_CanonCryptoItem).OrigKey
}

func (_this CanonCryptoItem) Dtor_data() m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal {
	return _this.Get_().(CanonCryptoItem_CanonCryptoItem).Data
}

func (_this CanonCryptoItem) Dtor_action() m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction {
	return _this.Get_().(CanonCryptoItem_CanonCryptoItem).Action
}

func (_this CanonCryptoItem) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CanonCryptoItem_CanonCryptoItem:
		{
			return "StructuredEncryptionUtil.CanonCryptoItem.CanonCryptoItem" + "(" + _dafny.String(data.Key) + ", " + _dafny.String(data.OrigKey) + ", " + _dafny.String(data.Data) + ", " + _dafny.String(data.Action) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CanonCryptoItem) Equals(other CanonCryptoItem) bool {
	switch data1 := _this.Get_().(type) {
	case CanonCryptoItem_CanonCryptoItem:
		{
			data2, ok := other.Get_().(CanonCryptoItem_CanonCryptoItem)
			return ok && data1.Key.Equals(data2.Key) && data1.OrigKey.Equals(data2.OrigKey) && data1.Data.Equals(data2.Data) && data1.Action.Equals(data2.Action)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CanonCryptoItem) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CanonCryptoItem)
	return ok && _this.Equals(typed)
}

func Type_CanonCryptoItem_() _dafny.TypeDescriptor {
	return type_CanonCryptoItem_{}
}

type type_CanonCryptoItem_ struct {
}

func (_this type_CanonCryptoItem_) Default() interface{} {
	return Companion_CanonCryptoItem_.Default()
}

func (_this type_CanonCryptoItem_) String() string {
	return "StructuredEncryptionUtil.CanonCryptoItem"
}
func (_this CanonCryptoItem) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CanonCryptoItem{}

// End of datatype CanonCryptoItem

// Definition of datatype CanonAuthItem
type CanonAuthItem struct {
	Data_CanonAuthItem_
}

func (_this CanonAuthItem) Get_() Data_CanonAuthItem_ {
	return _this.Data_CanonAuthItem_
}

type Data_CanonAuthItem_ interface {
	isCanonAuthItem()
}

type CompanionStruct_CanonAuthItem_ struct {
}

var Companion_CanonAuthItem_ = CompanionStruct_CanonAuthItem_{}

type CanonAuthItem_CanonAuthItem struct {
	Key     _dafny.Sequence
	OrigKey _dafny.Sequence
	Data    m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal
	Action  m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.AuthenticateAction
}

func (CanonAuthItem_CanonAuthItem) isCanonAuthItem() {}

func (CompanionStruct_CanonAuthItem_) Create_CanonAuthItem_(Key _dafny.Sequence, OrigKey _dafny.Sequence, Data m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal, Action m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.AuthenticateAction) CanonAuthItem {
	return CanonAuthItem{CanonAuthItem_CanonAuthItem{Key, OrigKey, Data, Action}}
}

func (_this CanonAuthItem) Is_CanonAuthItem() bool {
	_, ok := _this.Get_().(CanonAuthItem_CanonAuthItem)
	return ok
}

func (CompanionStruct_CanonAuthItem_) Default() CanonAuthItem {
	return Companion_CanonAuthItem_.Create_CanonAuthItem_(_dafny.EmptySeq, _dafny.EmptySeq, m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_StructuredDataTerminal_.Default(), m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Companion_AuthenticateAction_.Default())
}

func (_this CanonAuthItem) Dtor_key() _dafny.Sequence {
	return _this.Get_().(CanonAuthItem_CanonAuthItem).Key
}

func (_this CanonAuthItem) Dtor_origKey() _dafny.Sequence {
	return _this.Get_().(CanonAuthItem_CanonAuthItem).OrigKey
}

func (_this CanonAuthItem) Dtor_data() m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal {
	return _this.Get_().(CanonAuthItem_CanonAuthItem).Data
}

func (_this CanonAuthItem) Dtor_action() m_AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.AuthenticateAction {
	return _this.Get_().(CanonAuthItem_CanonAuthItem).Action
}

func (_this CanonAuthItem) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CanonAuthItem_CanonAuthItem:
		{
			return "StructuredEncryptionUtil.CanonAuthItem.CanonAuthItem" + "(" + _dafny.String(data.Key) + ", " + _dafny.String(data.OrigKey) + ", " + _dafny.String(data.Data) + ", " + _dafny.String(data.Action) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CanonAuthItem) Equals(other CanonAuthItem) bool {
	switch data1 := _this.Get_().(type) {
	case CanonAuthItem_CanonAuthItem:
		{
			data2, ok := other.Get_().(CanonAuthItem_CanonAuthItem)
			return ok && data1.Key.Equals(data2.Key) && data1.OrigKey.Equals(data2.OrigKey) && data1.Data.Equals(data2.Data) && data1.Action.Equals(data2.Action)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CanonAuthItem) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CanonAuthItem)
	return ok && _this.Equals(typed)
}

func Type_CanonAuthItem_() _dafny.TypeDescriptor {
	return type_CanonAuthItem_{}
}

type type_CanonAuthItem_ struct {
}

func (_this type_CanonAuthItem_) Default() interface{} {
	return Companion_CanonAuthItem_.Default()
}

func (_this type_CanonAuthItem_) String() string {
	return "StructuredEncryptionUtil.CanonAuthItem"
}
func (_this CanonAuthItem) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CanonAuthItem{}

// End of datatype CanonAuthItem

// Definition of class Key
type Key struct {
}

func New_Key_() *Key {
	_this := Key{}

	return &_this
}

type CompanionStruct_Key_ struct {
}

var Companion_Key_ = CompanionStruct_Key_{}

func (*Key) String() string {
	return "StructuredEncryptionUtil.Key"
}

// End of class Key

func Type_Key_() _dafny.TypeDescriptor {
	return type_Key_{}
}

type type_Key_ struct {
}

func (_this type_Key_) Default() interface{} {
	return _dafny.EmptySeq
}

func (_this type_Key_) String() string {
	return "StructuredEncryptionUtil.Key"
}

// Definition of class Nonce
type Nonce struct {
}

func New_Nonce_() *Nonce {
	_this := Nonce{}

	return &_this
}

type CompanionStruct_Nonce_ struct {
}

var Companion_Nonce_ = CompanionStruct_Nonce_{}

func (*Nonce) String() string {
	return "StructuredEncryptionUtil.Nonce"
}

// End of class Nonce

func Type_Nonce_() _dafny.TypeDescriptor {
	return type_Nonce_{}
}

type type_Nonce_ struct {
}

func (_this type_Nonce_) Default() interface{} {
	return _dafny.EmptySeq
}

func (_this type_Nonce_) String() string {
	return "StructuredEncryptionUtil.Nonce"
}

// Definition of class AuthTag
type AuthTag struct {
}

func New_AuthTag_() *AuthTag {
	_this := AuthTag{}

	return &_this
}

type CompanionStruct_AuthTag_ struct {
}

var Companion_AuthTag_ = CompanionStruct_AuthTag_{}

func (*AuthTag) String() string {
	return "StructuredEncryptionUtil.AuthTag"
}

// End of class AuthTag

func Type_AuthTag_() _dafny.TypeDescriptor {
	return type_AuthTag_{}
}

type type_AuthTag_ struct {
}

func (_this type_AuthTag_) Default() interface{} {
	return _dafny.EmptySeq
}

func (_this type_AuthTag_) String() string {
	return "StructuredEncryptionUtil.AuthTag"
}

// Definition of class MessageID
type MessageID struct {
}

func New_MessageID_() *MessageID {
	_this := MessageID{}

	return &_this
}

type CompanionStruct_MessageID_ struct {
}

var Companion_MessageID_ = CompanionStruct_MessageID_{}

func (*MessageID) String() string {
	return "StructuredEncryptionUtil.MessageID"
}

// End of class MessageID

func Type_MessageID_() _dafny.TypeDescriptor {
	return type_MessageID_{}
}

type type_MessageID_ struct {
}

func (_this type_MessageID_) Default() interface{} {
	return _dafny.EmptySeq
}

func (_this type_MessageID_) String() string {
	return "StructuredEncryptionUtil.MessageID"
}

// Definition of class GoodString
type GoodString struct {
}

func New_GoodString_() *GoodString {
	_this := GoodString{}

	return &_this
}

type CompanionStruct_GoodString_ struct {
}

var Companion_GoodString_ = CompanionStruct_GoodString_{}

func (*GoodString) String() string {
	return "StructuredEncryptionUtil.GoodString"
}

// End of class GoodString

func Type_GoodString_() _dafny.TypeDescriptor {
	return type_GoodString_{}
}

type type_GoodString_ struct {
}

func (_this type_GoodString_) Default() interface{} {
	return _dafny.EmptySeq.SetString()
}

func (_this type_GoodString_) String() string {
	return "StructuredEncryptionUtil.GoodString"
}
func (_this *CompanionStruct_GoodString_) Is_(__source _dafny.Sequence) bool {
	var _0_x _dafny.Sequence = (__source)
	_ = _0_x
	return Companion_Default___.ValidString(_0_x)
}
