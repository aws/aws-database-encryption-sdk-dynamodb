// Package EcdhEdkWrapping
// Dafny module EcdhEdkWrapping compiled into Go

package EcdhEdkWrapping

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
	m_RawAESKeyring "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/RawAESKeyring"
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
var _ m_Materials.Dummy__
var _ m_Keyring.Dummy__
var _ m_CanonicalEncryptionContext.Dummy__
var _ m_MaterialWrapping.Dummy__
var _ m_IntermediateKeyWrapping.Dummy__
var _ m_EdkWrapping.Dummy__
var _ m_ErrorMessages.Dummy__
var _ m_RawAESKeyring.Dummy__
var _ m_Constants.Dummy__

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
	return "EcdhEdkWrapping.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) DeriveSharedKeyingMaterial(sharedSecret _dafny.Sequence, fixedInfo _dafny.Sequence, salt _dafny.Sequence, crypto *m_AtomicPrimitives.AtomicPrimitivesClient) m_Wrappers.Result {
	var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = res
	var _0_maybeDerivedKeyingMaterial m_Wrappers.Result
	_ = _0_maybeDerivedKeyingMaterial
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = (crypto).KdfCounterMode(m_AwsCryptographyPrimitivesTypes.Companion_KdfCtrInput_.Create_KdfCtrInput_(m_AwsCryptographyPrimitivesTypes.Companion_DigestAlgorithm_.Create_SHA__384_(), sharedSecret, m_Constants.Companion_Default___.KDF__EXPECTED__LEN(), m_Wrappers.Companion_Option_.Create_Some_(fixedInfo), m_Wrappers.Companion_Option_.Create_Some_(salt)))
	_0_maybeDerivedKeyingMaterial = _out0
	var _1_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
	_ = _1_valueOrError0
	_1_valueOrError0 = (_0_maybeDerivedKeyingMaterial).MapFailure(func(coer52 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
		return func(arg53 interface{}) interface{} {
			return coer52(arg53.(m_AwsCryptographyPrimitivesTypes.Error))
		}
	}(func(_2_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
		return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_2_e)
	}))
	if (_1_valueOrError0).IsFailure() {
		res = (_1_valueOrError0).PropagateFailure()
		return res
	}
	var _3_derivedKeyingMaterial _dafny.Sequence
	_ = _3_derivedKeyingMaterial
	_3_derivedKeyingMaterial = (_1_valueOrError0).Extract().(_dafny.Sequence)
	res = m_Wrappers.Companion_Result_.Create_Success_(_3_derivedKeyingMaterial)
	return res
}
func (_static *CompanionStruct_Default___) SerializeFixedInfo(ecdhKeyDerivationUtf8 _dafny.Sequence, curveSpecUtf8 _dafny.Sequence, senderPublicKey _dafny.Sequence, recipientPublicKey _dafny.Sequence, canonicalizedEC _dafny.Sequence, keyringVersion _dafny.Sequence) _dafny.Sequence {
	return _dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(ecdhKeyDerivationUtf8, m_Constants.Companion_Default___.ECDH__KDF__DELIMITER()), curveSpecUtf8), m_Constants.Companion_Default___.ECDH__KDF__DELIMITER()), m_Constants.Companion_Default___.ECDH__KDF__PRF__NAME()), m_Constants.Companion_Default___.ECDH__KDF__DELIMITER()), senderPublicKey), recipientPublicKey), m_Constants.Companion_Default___.ECDH__KDF__DELIMITER()), keyringVersion), m_Constants.Companion_Default___.ECDH__KDF__DELIMITER()), canonicalizedEC)
}
func (_static *CompanionStruct_Default___) CurveSpecTypeToString(c m_AwsCryptographyPrimitivesTypes.ECDHCurveSpec) _dafny.Sequence {
	var _source0 m_AwsCryptographyPrimitivesTypes.ECDHCurveSpec = c
	_ = _source0
	{
		if _source0.Is_ECC__NIST__P256() {
			return _dafny.SeqOfString("p256")
		}
	}
	{
		if _source0.Is_ECC__NIST__P384() {
			return _dafny.SeqOfString("p384")
		}
	}
	{
		if _source0.Is_ECC__NIST__P521() {
			return _dafny.SeqOfString("p521")
		}
	}
	{
		return _dafny.SeqOfString("sm2")
	}
}
func (_static *CompanionStruct_Default___) E(s _dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error {
	return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(s)
}

// End of class Default__

// Definition of datatype EcdhUnwrapInfo
type EcdhUnwrapInfo struct {
	Data_EcdhUnwrapInfo_
}

func (_this EcdhUnwrapInfo) Get_() Data_EcdhUnwrapInfo_ {
	return _this.Data_EcdhUnwrapInfo_
}

type Data_EcdhUnwrapInfo_ interface {
	isEcdhUnwrapInfo()
}

type CompanionStruct_EcdhUnwrapInfo_ struct {
}

var Companion_EcdhUnwrapInfo_ = CompanionStruct_EcdhUnwrapInfo_{}

type EcdhUnwrapInfo_EcdhUnwrapInfo struct {
}

func (EcdhUnwrapInfo_EcdhUnwrapInfo) isEcdhUnwrapInfo() {}

func (CompanionStruct_EcdhUnwrapInfo_) Create_EcdhUnwrapInfo_() EcdhUnwrapInfo {
	return EcdhUnwrapInfo{EcdhUnwrapInfo_EcdhUnwrapInfo{}}
}

func (_this EcdhUnwrapInfo) Is_EcdhUnwrapInfo() bool {
	_, ok := _this.Get_().(EcdhUnwrapInfo_EcdhUnwrapInfo)
	return ok
}

func (CompanionStruct_EcdhUnwrapInfo_) Default() EcdhUnwrapInfo {
	return Companion_EcdhUnwrapInfo_.Create_EcdhUnwrapInfo_()
}

func (_ CompanionStruct_EcdhUnwrapInfo_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_EcdhUnwrapInfo_.Create_EcdhUnwrapInfo_(), true
		default:
			return EcdhUnwrapInfo{}, false
		}
	}
}

func (_this EcdhUnwrapInfo) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case EcdhUnwrapInfo_EcdhUnwrapInfo:
		{
			return "EcdhEdkWrapping.EcdhUnwrapInfo.EcdhUnwrapInfo"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this EcdhUnwrapInfo) Equals(other EcdhUnwrapInfo) bool {
	switch _this.Get_().(type) {
	case EcdhUnwrapInfo_EcdhUnwrapInfo:
		{
			_, ok := other.Get_().(EcdhUnwrapInfo_EcdhUnwrapInfo)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this EcdhUnwrapInfo) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(EcdhUnwrapInfo)
	return ok && _this.Equals(typed)
}

func Type_EcdhUnwrapInfo_() _dafny.TypeDescriptor {
	return type_EcdhUnwrapInfo_{}
}

type type_EcdhUnwrapInfo_ struct {
}

func (_this type_EcdhUnwrapInfo_) Default() interface{} {
	return Companion_EcdhUnwrapInfo_.Default()
}

func (_this type_EcdhUnwrapInfo_) String() string {
	return "EcdhEdkWrapping.EcdhUnwrapInfo"
}
func (_this EcdhUnwrapInfo) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = EcdhUnwrapInfo{}

// End of datatype EcdhUnwrapInfo

// Definition of datatype EcdhWrapInfo
type EcdhWrapInfo struct {
	Data_EcdhWrapInfo_
}

func (_this EcdhWrapInfo) Get_() Data_EcdhWrapInfo_ {
	return _this.Data_EcdhWrapInfo_
}

type Data_EcdhWrapInfo_ interface {
	isEcdhWrapInfo()
}

type CompanionStruct_EcdhWrapInfo_ struct {
}

var Companion_EcdhWrapInfo_ = CompanionStruct_EcdhWrapInfo_{}

type EcdhWrapInfo_EcdhWrapInfo struct {
}

func (EcdhWrapInfo_EcdhWrapInfo) isEcdhWrapInfo() {}

func (CompanionStruct_EcdhWrapInfo_) Create_EcdhWrapInfo_() EcdhWrapInfo {
	return EcdhWrapInfo{EcdhWrapInfo_EcdhWrapInfo{}}
}

func (_this EcdhWrapInfo) Is_EcdhWrapInfo() bool {
	_, ok := _this.Get_().(EcdhWrapInfo_EcdhWrapInfo)
	return ok
}

func (CompanionStruct_EcdhWrapInfo_) Default() EcdhWrapInfo {
	return Companion_EcdhWrapInfo_.Create_EcdhWrapInfo_()
}

func (_ CompanionStruct_EcdhWrapInfo_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_EcdhWrapInfo_.Create_EcdhWrapInfo_(), true
		default:
			return EcdhWrapInfo{}, false
		}
	}
}

func (_this EcdhWrapInfo) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case EcdhWrapInfo_EcdhWrapInfo:
		{
			return "EcdhEdkWrapping.EcdhWrapInfo.EcdhWrapInfo"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this EcdhWrapInfo) Equals(other EcdhWrapInfo) bool {
	switch _this.Get_().(type) {
	case EcdhWrapInfo_EcdhWrapInfo:
		{
			_, ok := other.Get_().(EcdhWrapInfo_EcdhWrapInfo)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this EcdhWrapInfo) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(EcdhWrapInfo)
	return ok && _this.Equals(typed)
}

func Type_EcdhWrapInfo_() _dafny.TypeDescriptor {
	return type_EcdhWrapInfo_{}
}

type type_EcdhWrapInfo_ struct {
}

func (_this type_EcdhWrapInfo_) Default() interface{} {
	return Companion_EcdhWrapInfo_.Default()
}

func (_this type_EcdhWrapInfo_) String() string {
	return "EcdhEdkWrapping.EcdhWrapInfo"
}
func (_this EcdhWrapInfo) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = EcdhWrapInfo{}

// End of datatype EcdhWrapInfo

// Definition of class EcdhUnwrap
type EcdhUnwrap struct {
	_senderPublicKey    _dafny.Sequence
	_recipientPublicKey _dafny.Sequence
	_sharedSecret       _dafny.Sequence
	_keyringVersion     _dafny.Sequence
	_curveSpec          m_AwsCryptographyPrimitivesTypes.ECDHCurveSpec
	_crypto             *m_AtomicPrimitives.AtomicPrimitivesClient
}

func New_EcdhUnwrap_() *EcdhUnwrap {
	_this := EcdhUnwrap{}

	_this._senderPublicKey = _dafny.EmptySeq
	_this._recipientPublicKey = _dafny.EmptySeq
	_this._sharedSecret = _dafny.EmptySeq
	_this._keyringVersion = _dafny.EmptySeq
	_this._curveSpec = m_AwsCryptographyPrimitivesTypes.Companion_ECDHCurveSpec_.Default()
	_this._crypto = (*m_AtomicPrimitives.AtomicPrimitivesClient)(nil)
	return &_this
}

type CompanionStruct_EcdhUnwrap_ struct {
}

var Companion_EcdhUnwrap_ = CompanionStruct_EcdhUnwrap_{}

func (_this *EcdhUnwrap) Equals(other *EcdhUnwrap) bool {
	return _this == other
}

func (_this *EcdhUnwrap) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*EcdhUnwrap)
	return ok && _this.Equals(other)
}

func (*EcdhUnwrap) String() string {
	return "EcdhEdkWrapping.EcdhUnwrap"
}

func Type_EcdhUnwrap_() _dafny.TypeDescriptor {
	return type_EcdhUnwrap_{}
}

type type_EcdhUnwrap_ struct {
}

func (_this type_EcdhUnwrap_) Default() interface{} {
	return (*EcdhUnwrap)(nil)
}

func (_this type_EcdhUnwrap_) String() string {
	return "EcdhEdkWrapping.EcdhUnwrap"
}
func (_this *EcdhUnwrap) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_MaterialWrapping.Companion_UnwrapMaterial_.TraitID_, m_Actions.Companion_ActionWithResult_.TraitID_, m_Actions.Companion_Action_.TraitID_}
}

var _ m_MaterialWrapping.UnwrapMaterial = &EcdhUnwrap{}
var _ m_Actions.ActionWithResult = &EcdhUnwrap{}
var _ m_Actions.Action = &EcdhUnwrap{}
var _ _dafny.TraitOffspring = &EcdhUnwrap{}

func (_this *EcdhUnwrap) Ctor__(senderPublicKey _dafny.Sequence, recipientPublicKey _dafny.Sequence, sharedSecret _dafny.Sequence, keyringVersion _dafny.Sequence, curveSpec m_AwsCryptographyPrimitivesTypes.ECDHCurveSpec, crypto *m_AtomicPrimitives.AtomicPrimitivesClient) {
	{
		(_this)._senderPublicKey = senderPublicKey
		(_this)._recipientPublicKey = recipientPublicKey
		(_this)._sharedSecret = sharedSecret
		(_this)._keyringVersion = keyringVersion
		(_this)._curveSpec = curveSpec
		(_this)._crypto = crypto
	}
}
func (_this *EcdhUnwrap) Invoke(input interface{}) interface{} {
	{
		var input m_MaterialWrapping.UnwrapInput = input.(m_MaterialWrapping.UnwrapInput)
		_ = input
		var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_MaterialWrapping.Companion_UnwrapOutput_.Default(Companion_EcdhUnwrapInfo_.Default()))
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
		var _3_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _3_valueOrError0
		_3_valueOrError0 = m_Wrappers.Companion_Default___.Need((uint64((_1_wrappedMaterial).Cardinality())) > (m_Constants.Companion_Default___.CIPHERTEXT__WRAPPED__MATERIAL__INDEX()), Companion_Default___.E(_dafny.SeqOfString("Received ciphertext is shorter than expected.")))
		if (_3_valueOrError0).IsFailure() {
			res = (_3_valueOrError0).PropagateFailure()
			return res
		}
		var _4_KeyLength int32
		_ = _4_KeyLength
		_4_KeyLength = m_AlgorithmSuites.Companion_Default___.GetEncryptKeyLength(_0_suite)
		var _5_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _5_valueOrError1
		_5_valueOrError1 = m_Wrappers.Companion_Default___.Need((_dafny.IntOfUint32((_1_wrappedMaterial).Cardinality())).Cmp((_dafny.IntOfUint64(m_Constants.Companion_Default___.ECDH__WRAPPED__KEY__MATERIAL__INDEX())).Plus(_dafny.IntOfInt32(_4_KeyLength))) > 0, m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographicMaterialProvidersException_(_dafny.SeqOfString("Received EDK Ciphertext of incorrect length3.")))
		if (_5_valueOrError1).IsFailure() {
			res = (_5_valueOrError1).PropagateFailure()
			return res
		}
		var _6_kdfNonce _dafny.Sequence
		_ = _6_kdfNonce
		_6_kdfNonce = (_1_wrappedMaterial).Take(uint32(m_Constants.Companion_Default___.ECDH__COMMITMENT__KEY__INDEX()))
		var _7_iv _dafny.Sequence
		_ = _7_iv
		_7_iv = _dafny.SeqCreate((_dafny.IntOfInt32((m_Constants.Companion_Default___.ECDH__AES__256__ENC__ALG()).Dtor_ivLength())).Uint32(), func(coer53 func(_dafny.Int) uint8) func(_dafny.Int) interface{} {
			return func(arg54 _dafny.Int) interface{} {
				return coer53(arg54)
			}
		}(func(_8___v0 _dafny.Int) uint8 {
			return uint8(0)
		}))
		var _9_commitmentKey _dafny.Sequence
		_ = _9_commitmentKey
		_9_commitmentKey = (_1_wrappedMaterial).Subsequence(uint32(m_Constants.Companion_Default___.ECDH__COMMITMENT__KEY__INDEX()), uint32(m_Constants.Companion_Default___.ECDH__WRAPPED__KEY__MATERIAL__INDEX()))
		var _10_wrappedKey _dafny.Sequence
		_ = _10_wrappedKey
		_10_wrappedKey = (_1_wrappedMaterial).Subsequence(uint32(m_Constants.Companion_Default___.ECDH__WRAPPED__KEY__MATERIAL__INDEX()), uint32((m_Constants.Companion_Default___.ECDH__WRAPPED__KEY__MATERIAL__INDEX())+(uint64(_4_KeyLength))))
		var _11_authTag _dafny.Sequence
		_ = _11_authTag
		_11_authTag = (_1_wrappedMaterial).Drop(uint32((m_Constants.Companion_Default___.ECDH__WRAPPED__KEY__MATERIAL__INDEX()) + (uint64(_4_KeyLength))))
		var _12_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_UTF8.Companion_ValidUTF8Bytes_.Witness())
		_ = _12_valueOrError2
		_12_valueOrError2 = (m_UTF8.Encode(Companion_Default___.CurveSpecTypeToString((_this).CurveSpec()))).MapFailure(func(coer54 func(_dafny.Sequence) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg55 interface{}) interface{} {
				return coer54(arg55.(_dafny.Sequence))
			}
		}(Companion_Default___.E))
		if (_12_valueOrError2).IsFailure() {
			res = (_12_valueOrError2).PropagateFailure()
			return res
		}
		var _13_curveSpecUtf8 _dafny.Sequence
		_ = _13_curveSpecUtf8
		_13_curveSpecUtf8 = (_12_valueOrError2).Extract().(_dafny.Sequence)
		var _14_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _14_valueOrError3
		_14_valueOrError3 = m_CanonicalEncryptionContext.Companion_Default___.EncryptionContextToAAD((input).Dtor_encryptionContext())
		if (_14_valueOrError3).IsFailure() {
			res = (_14_valueOrError3).PropagateFailure()
			return res
		}
		var _15_canonicalizedEC _dafny.Sequence
		_ = _15_canonicalizedEC
		_15_canonicalizedEC = (_14_valueOrError3).Extract().(_dafny.Sequence)
		var _16_fixedInfo _dafny.Sequence
		_ = _16_fixedInfo
		_16_fixedInfo = Companion_Default___.SerializeFixedInfo(m_Constants.Companion_Default___.ECDH__KDF__UTF8(), _13_curveSpecUtf8, (_this).SenderPublicKey(), (_this).RecipientPublicKey(), _15_canonicalizedEC, (_this).KeyringVersion())
		var _17_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _17_valueOrError4
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = Companion_Default___.DeriveSharedKeyingMaterial((_this).SharedSecret(), _16_fixedInfo, _6_kdfNonce, (_this).Crypto())
		_17_valueOrError4 = _out0
		if (_17_valueOrError4).IsFailure() {
			res = (_17_valueOrError4).PropagateFailure()
			return res
		}
		var _18_derivedKeyingMaterial _dafny.Sequence
		_ = _18_derivedKeyingMaterial
		_18_derivedKeyingMaterial = (_17_valueOrError4).Extract().(_dafny.Sequence)
		var _19_calculatedCommitmentKey _dafny.Sequence
		_ = _19_calculatedCommitmentKey
		_19_calculatedCommitmentKey = (_18_derivedKeyingMaterial).Take(uint32(uint32(32)))
		var _20_sharedKeyingMaterial _dafny.Sequence
		_ = _20_sharedKeyingMaterial
		_20_sharedKeyingMaterial = (_18_derivedKeyingMaterial).Drop(uint32(uint32(32)))
		var _21_valueOrError5 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _21_valueOrError5
		_21_valueOrError5 = m_Wrappers.Companion_Default___.Need((uint64((_19_calculatedCommitmentKey).Cardinality())) == (uint64((_9_commitmentKey).Cardinality())), Companion_Default___.E(_dafny.SeqOfString("Calculated commitment key length does NOT match expected commitment key length")))
		if (_21_valueOrError5).IsFailure() {
			res = (_21_valueOrError5).PropagateFailure()
			return res
		}
		var _22_check_q bool
		_ = _22_check_q
		var _out1 bool
		_ = _out1
		_out1 = (_this).CommitmentKeyCheck(_19_calculatedCommitmentKey, _9_commitmentKey)
		_22_check_q = _out1
		var _23_valueOrError6 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _23_valueOrError6
		_23_valueOrError6 = m_Wrappers.Companion_Default___.Need(_22_check_q, Companion_Default___.E(_dafny.SeqOfString("Commitment keys do not match")))
		if (_23_valueOrError6).IsFailure() {
			res = (_23_valueOrError6).PropagateFailure()
			return res
		}
		var _24_maybeUnwrappedPdk m_Wrappers.Result
		_ = _24_maybeUnwrappedPdk
		var _out2 m_Wrappers.Result
		_ = _out2
		_out2 = ((_this).Crypto()).AESDecrypt(m_AwsCryptographyPrimitivesTypes.Companion_AESDecryptInput_.Create_AESDecryptInput_(m_Constants.Companion_Default___.ECDH__AES__256__ENC__ALG(), _20_sharedKeyingMaterial, _10_wrappedKey, _11_authTag, _7_iv, _16_fixedInfo))
		_24_maybeUnwrappedPdk = _out2
		var _25_valueOrError7 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _25_valueOrError7
		_25_valueOrError7 = (_24_maybeUnwrappedPdk).MapFailure(func(coer55 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg56 interface{}) interface{} {
				return coer55(arg56.(m_AwsCryptographyPrimitivesTypes.Error))
			}
		}(func(_26_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
			return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_26_e)
		}))
		if (_25_valueOrError7).IsFailure() {
			res = (_25_valueOrError7).PropagateFailure()
			return res
		}
		var _27_unwrappedPdk _dafny.Sequence
		_ = _27_unwrappedPdk
		_27_unwrappedPdk = (_25_valueOrError7).Extract().(_dafny.Sequence)
		var _28_valueOrError8 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
		_ = _28_valueOrError8
		_28_valueOrError8 = m_Wrappers.Companion_Default___.Need((uint64((_27_unwrappedPdk).Cardinality())) == (uint64(m_AlgorithmSuites.Companion_Default___.GetEncryptKeyLength((input).Dtor_algorithmSuite()))), Companion_Default___.E(_dafny.SeqOfString("Invalid Key Length")))
		if (_28_valueOrError8).IsFailure() {
			res = (_28_valueOrError8).PropagateFailure()
			return res
		}
		var _29_output m_MaterialWrapping.UnwrapOutput
		_ = _29_output
		_29_output = m_MaterialWrapping.Companion_UnwrapOutput_.Create_UnwrapOutput_(_27_unwrappedPdk, Companion_EcdhUnwrapInfo_.Create_EcdhUnwrapInfo_())
		res = m_Wrappers.Companion_Result_.Create_Success_(_29_output)
		return res
		return res
	}
}
func (_this *EcdhUnwrap) CommitmentKeyCheck(calculatedCommitmentKey _dafny.Sequence, serializedCommitmentKey _dafny.Sequence) bool {
	{
		var res bool = false
		_ = res
		var _0_diff_q uint8
		_ = _0_diff_q
		_0_diff_q = uint8(0)
		var _hi0 uint64 = uint64((serializedCommitmentKey).Cardinality())
		_ = _hi0
		for _1_i := uint64(0); _1_i < _hi0; _1_i++ {
			_0_diff_q = (_0_diff_q) | ((uint8((calculatedCommitmentKey).Select(uint32(_1_i)).(uint8))) ^ (uint8((serializedCommitmentKey).Select(uint32(_1_i)).(uint8))))
		}
		res = (_0_diff_q) == (uint8(0))
		return res
	}
}
func (_this *EcdhUnwrap) SenderPublicKey() _dafny.Sequence {
	{
		return _this._senderPublicKey
	}
}
func (_this *EcdhUnwrap) RecipientPublicKey() _dafny.Sequence {
	{
		return _this._recipientPublicKey
	}
}
func (_this *EcdhUnwrap) SharedSecret() _dafny.Sequence {
	{
		return _this._sharedSecret
	}
}
func (_this *EcdhUnwrap) KeyringVersion() _dafny.Sequence {
	{
		return _this._keyringVersion
	}
}
func (_this *EcdhUnwrap) CurveSpec() m_AwsCryptographyPrimitivesTypes.ECDHCurveSpec {
	{
		return _this._curveSpec
	}
}
func (_this *EcdhUnwrap) Crypto() *m_AtomicPrimitives.AtomicPrimitivesClient {
	{
		return _this._crypto
	}
}

// End of class EcdhUnwrap

// Definition of class EcdhGenerateAndWrapKeyMaterial
type EcdhGenerateAndWrapKeyMaterial struct {
	_crypto       *m_AtomicPrimitives.AtomicPrimitivesClient
	_sharedSecret _dafny.Sequence
	_fixedInfo    _dafny.Sequence
}

func New_EcdhGenerateAndWrapKeyMaterial_() *EcdhGenerateAndWrapKeyMaterial {
	_this := EcdhGenerateAndWrapKeyMaterial{}

	_this._crypto = (*m_AtomicPrimitives.AtomicPrimitivesClient)(nil)
	_this._sharedSecret = _dafny.EmptySeq
	_this._fixedInfo = _dafny.EmptySeq
	return &_this
}

type CompanionStruct_EcdhGenerateAndWrapKeyMaterial_ struct {
}

var Companion_EcdhGenerateAndWrapKeyMaterial_ = CompanionStruct_EcdhGenerateAndWrapKeyMaterial_{}

func (_this *EcdhGenerateAndWrapKeyMaterial) Equals(other *EcdhGenerateAndWrapKeyMaterial) bool {
	return _this == other
}

func (_this *EcdhGenerateAndWrapKeyMaterial) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*EcdhGenerateAndWrapKeyMaterial)
	return ok && _this.Equals(other)
}

func (*EcdhGenerateAndWrapKeyMaterial) String() string {
	return "EcdhEdkWrapping.EcdhGenerateAndWrapKeyMaterial"
}

func Type_EcdhGenerateAndWrapKeyMaterial_() _dafny.TypeDescriptor {
	return type_EcdhGenerateAndWrapKeyMaterial_{}
}

type type_EcdhGenerateAndWrapKeyMaterial_ struct {
}

func (_this type_EcdhGenerateAndWrapKeyMaterial_) Default() interface{} {
	return (*EcdhGenerateAndWrapKeyMaterial)(nil)
}

func (_this type_EcdhGenerateAndWrapKeyMaterial_) String() string {
	return "EcdhEdkWrapping.EcdhGenerateAndWrapKeyMaterial"
}
func (_this *EcdhGenerateAndWrapKeyMaterial) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_MaterialWrapping.Companion_GenerateAndWrapMaterial_.TraitID_, m_Actions.Companion_ActionWithResult_.TraitID_, m_Actions.Companion_Action_.TraitID_}
}

var _ m_MaterialWrapping.GenerateAndWrapMaterial = &EcdhGenerateAndWrapKeyMaterial{}
var _ m_Actions.ActionWithResult = &EcdhGenerateAndWrapKeyMaterial{}
var _ m_Actions.Action = &EcdhGenerateAndWrapKeyMaterial{}
var _ _dafny.TraitOffspring = &EcdhGenerateAndWrapKeyMaterial{}

func (_this *EcdhGenerateAndWrapKeyMaterial) Ctor__(sharedSecret _dafny.Sequence, fixedInfo _dafny.Sequence, crypto *m_AtomicPrimitives.AtomicPrimitivesClient) {
	{
		(_this)._sharedSecret = sharedSecret
		(_this)._fixedInfo = fixedInfo
		(_this)._crypto = crypto
	}
}
func (_this *EcdhGenerateAndWrapKeyMaterial) Invoke(input interface{}) interface{} {
	{
		var input m_MaterialWrapping.GenerateAndWrapInput = input.(m_MaterialWrapping.GenerateAndWrapInput)
		_ = input
		var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_MaterialWrapping.Companion_GenerateAndWrapOutput_.Default(Companion_EcdhWrapInfo_.Default()))
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
		_2_valueOrError0 = (_1_pdkResult).MapFailure(func(coer56 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg57 interface{}) interface{} {
				return coer56(arg57.(m_AwsCryptographyPrimitivesTypes.Error))
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
		var _5_wrap *EcdhWrapKeyMaterial
		_ = _5_wrap
		var _nw0 *EcdhWrapKeyMaterial = New_EcdhWrapKeyMaterial_()
		_ = _nw0
		_nw0.Ctor__((_this).SharedSecret(), (_this).FixedInfo(), (_this).Crypto())
		_5_wrap = _nw0
		var _6_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_MaterialWrapping.Companion_WrapOutput_.Default(Companion_EcdhWrapInfo_.Default()))
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
		_8_output = m_MaterialWrapping.Companion_GenerateAndWrapOutput_.Create_GenerateAndWrapOutput_(_4_pdk, (_7_wrapOutput).Dtor_wrappedMaterial(), (_7_wrapOutput).Dtor_wrapInfo().(EcdhWrapInfo))
		res = m_Wrappers.Companion_Result_.Create_Success_(_8_output)
		return res
		return res
	}
}
func (_this *EcdhGenerateAndWrapKeyMaterial) Crypto() *m_AtomicPrimitives.AtomicPrimitivesClient {
	{
		return _this._crypto
	}
}
func (_this *EcdhGenerateAndWrapKeyMaterial) SharedSecret() _dafny.Sequence {
	{
		return _this._sharedSecret
	}
}
func (_this *EcdhGenerateAndWrapKeyMaterial) FixedInfo() _dafny.Sequence {
	{
		return _this._fixedInfo
	}
}

// End of class EcdhGenerateAndWrapKeyMaterial

// Definition of class EcdhWrapKeyMaterial
type EcdhWrapKeyMaterial struct {
	_crypto       *m_AtomicPrimitives.AtomicPrimitivesClient
	_fixedInfo    _dafny.Sequence
	_sharedSecret _dafny.Sequence
}

func New_EcdhWrapKeyMaterial_() *EcdhWrapKeyMaterial {
	_this := EcdhWrapKeyMaterial{}

	_this._crypto = (*m_AtomicPrimitives.AtomicPrimitivesClient)(nil)
	_this._fixedInfo = _dafny.EmptySeq
	_this._sharedSecret = _dafny.EmptySeq
	return &_this
}

type CompanionStruct_EcdhWrapKeyMaterial_ struct {
}

var Companion_EcdhWrapKeyMaterial_ = CompanionStruct_EcdhWrapKeyMaterial_{}

func (_this *EcdhWrapKeyMaterial) Equals(other *EcdhWrapKeyMaterial) bool {
	return _this == other
}

func (_this *EcdhWrapKeyMaterial) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*EcdhWrapKeyMaterial)
	return ok && _this.Equals(other)
}

func (*EcdhWrapKeyMaterial) String() string {
	return "EcdhEdkWrapping.EcdhWrapKeyMaterial"
}

func Type_EcdhWrapKeyMaterial_() _dafny.TypeDescriptor {
	return type_EcdhWrapKeyMaterial_{}
}

type type_EcdhWrapKeyMaterial_ struct {
}

func (_this type_EcdhWrapKeyMaterial_) Default() interface{} {
	return (*EcdhWrapKeyMaterial)(nil)
}

func (_this type_EcdhWrapKeyMaterial_) String() string {
	return "EcdhEdkWrapping.EcdhWrapKeyMaterial"
}
func (_this *EcdhWrapKeyMaterial) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_MaterialWrapping.Companion_WrapMaterial_.TraitID_, m_Actions.Companion_ActionWithResult_.TraitID_, m_Actions.Companion_Action_.TraitID_}
}

var _ m_MaterialWrapping.WrapMaterial = &EcdhWrapKeyMaterial{}
var _ m_Actions.ActionWithResult = &EcdhWrapKeyMaterial{}
var _ m_Actions.Action = &EcdhWrapKeyMaterial{}
var _ _dafny.TraitOffspring = &EcdhWrapKeyMaterial{}

func (_this *EcdhWrapKeyMaterial) Ctor__(sharedSecret _dafny.Sequence, fixedInfo _dafny.Sequence, crypto *m_AtomicPrimitives.AtomicPrimitivesClient) {
	{
		(_this)._sharedSecret = sharedSecret
		(_this)._fixedInfo = fixedInfo
		(_this)._crypto = crypto
	}
}
func (_this *EcdhWrapKeyMaterial) Invoke(input interface{}) interface{} {
	{
		var input m_MaterialWrapping.WrapInput = input.(m_MaterialWrapping.WrapInput)
		_ = input
		var res m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_MaterialWrapping.Companion_WrapOutput_.Default(Companion_EcdhWrapInfo_.Default()))
		_ = res
		var _0_suite m_AwsCryptographyMaterialProvidersTypes.AlgorithmSuiteInfo
		_ = _0_suite
		_0_suite = (input).Dtor_algorithmSuite()
		var _1_valueOrError0 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _1_valueOrError0
		_1_valueOrError0 = m_CanonicalEncryptionContext.Companion_Default___.EncryptionContextToAAD((input).Dtor_encryptionContext())
		if (_1_valueOrError0).IsFailure() {
			res = (_1_valueOrError0).PropagateFailure()
			return res
		}
		var _2_canonicalizedEC _dafny.Sequence
		_ = _2_canonicalizedEC
		_2_canonicalizedEC = (_1_valueOrError0).Extract().(_dafny.Sequence)
		var _3_maybeSalt m_Wrappers.Result
		_ = _3_maybeSalt
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = ((_this).Crypto()).GenerateRandomBytes(m_AwsCryptographyPrimitivesTypes.Companion_GenerateRandomBytesInput_.Create_GenerateRandomBytesInput_(m_Constants.Companion_Default___.KDF__SALT__LEN()))
		_3_maybeSalt = _out0
		var _4_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _4_valueOrError1
		_4_valueOrError1 = (_3_maybeSalt).MapFailure(func(coer57 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg58 interface{}) interface{} {
				return coer57(arg58.(m_AwsCryptographyPrimitivesTypes.Error))
			}
		}(func(_5_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
			return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_5_e)
		}))
		if (_4_valueOrError1).IsFailure() {
			res = (_4_valueOrError1).PropagateFailure()
			return res
		}
		var _6_salt _dafny.Sequence
		_ = _6_salt
		_6_salt = (_4_valueOrError1).Extract().(_dafny.Sequence)
		var _7_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq)
		_ = _7_valueOrError2
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = Companion_Default___.DeriveSharedKeyingMaterial((_this).SharedSecret(), (_this).FixedInfo(), _6_salt, (_this).Crypto())
		_7_valueOrError2 = _out1
		if (_7_valueOrError2).IsFailure() {
			res = (_7_valueOrError2).PropagateFailure()
			return res
		}
		var _8_derivedKeyingMaterial _dafny.Sequence
		_ = _8_derivedKeyingMaterial
		_8_derivedKeyingMaterial = (_7_valueOrError2).Extract().(_dafny.Sequence)
		var _9_commitmentKey _dafny.Sequence
		_ = _9_commitmentKey
		_9_commitmentKey = (_8_derivedKeyingMaterial).Take(uint32(uint32(32)))
		var _10_sharedKeyingMaterial _dafny.Sequence
		_ = _10_sharedKeyingMaterial
		_10_sharedKeyingMaterial = (_8_derivedKeyingMaterial).Drop(uint32(uint32(32)))
		var _11_iv _dafny.Sequence
		_ = _11_iv
		_11_iv = _dafny.SeqCreate((_dafny.IntOfInt32((m_Constants.Companion_Default___.ECDH__AES__256__ENC__ALG()).Dtor_ivLength())).Uint32(), func(coer58 func(_dafny.Int) uint8) func(_dafny.Int) interface{} {
			return func(arg59 _dafny.Int) interface{} {
				return coer58(arg59)
			}
		}(func(_12___v3 _dafny.Int) uint8 {
			return uint8(0)
		}))
		var _13_maybeWrappedPdk m_Wrappers.Result
		_ = _13_maybeWrappedPdk
		var _out2 m_Wrappers.Result
		_ = _out2
		_out2 = ((_this).Crypto()).AESEncrypt(m_AwsCryptographyPrimitivesTypes.Companion_AESEncryptInput_.Create_AESEncryptInput_(m_Constants.Companion_Default___.ECDH__AES__256__ENC__ALG(), _11_iv, _10_sharedKeyingMaterial, (input).Dtor_plaintextMaterial(), (_this).FixedInfo()))
		_13_maybeWrappedPdk = _out2
		var _14_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyPrimitivesTypes.Companion_AESEncryptOutput_.Default())
		_ = _14_valueOrError3
		_14_valueOrError3 = (_13_maybeWrappedPdk).MapFailure(func(coer59 func(m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error) func(interface{}) interface{} {
			return func(arg60 interface{}) interface{} {
				return coer59(arg60.(m_AwsCryptographyPrimitivesTypes.Error))
			}
		}(func(_15_e m_AwsCryptographyPrimitivesTypes.Error) m_AwsCryptographyMaterialProvidersTypes.Error {
			return m_AwsCryptographyMaterialProvidersTypes.Companion_Error_.Create_AwsCryptographyPrimitives_(_15_e)
		}))
		if (_14_valueOrError3).IsFailure() {
			res = (_14_valueOrError3).PropagateFailure()
			return res
		}
		var _16_wrappedPdk m_AwsCryptographyPrimitivesTypes.AESEncryptOutput
		_ = _16_wrappedPdk
		_16_wrappedPdk = (_14_valueOrError3).Extract().(m_AwsCryptographyPrimitivesTypes.AESEncryptOutput)
		var _17_output m_MaterialWrapping.WrapOutput
		_ = _17_output
		_17_output = m_MaterialWrapping.Companion_WrapOutput_.Create_WrapOutput_(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_dafny.Companion_Sequence_.Concatenate(_6_salt, _9_commitmentKey), (_16_wrappedPdk).Dtor_cipherText()), (_16_wrappedPdk).Dtor_authTag()), Companion_EcdhWrapInfo_.Create_EcdhWrapInfo_())
		res = m_Wrappers.Companion_Result_.Create_Success_(_17_output)
		return res
		return res
	}
}
func (_this *EcdhWrapKeyMaterial) Crypto() *m_AtomicPrimitives.AtomicPrimitivesClient {
	{
		return _this._crypto
	}
}
func (_this *EcdhWrapKeyMaterial) FixedInfo() _dafny.Sequence {
	{
		return _this._fixedInfo
	}
}
func (_this *EcdhWrapKeyMaterial) SharedSecret() _dafny.Sequence {
	{
		return _this._sharedSecret
	}
}

// End of class EcdhWrapKeyMaterial
