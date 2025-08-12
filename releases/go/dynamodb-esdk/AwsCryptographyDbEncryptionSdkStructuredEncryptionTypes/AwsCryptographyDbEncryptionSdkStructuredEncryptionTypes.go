// Package AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes
// Dafny module AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes compiled into Go

package AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes

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
	return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) IsValid__TerminalTypeId(x _dafny.Sequence) bool {
	return ((_dafny.IntOfInt64(2)).Cmp(_dafny.IntOfUint32((x).Cardinality())) <= 0) && ((_dafny.IntOfUint32((x).Cardinality())).Cmp(_dafny.IntOfInt64(2)) <= 0)
}
func (_static *CompanionStruct_Default___) IsDummySubsetType(x _dafny.Int) bool {
	return (x).Sign() == 1
}

// End of class Default__

// Definition of datatype DafnyCallEvent
type DafnyCallEvent struct {
	Data_DafnyCallEvent_
}

func (_this DafnyCallEvent) Get_() Data_DafnyCallEvent_ {
	return _this.Data_DafnyCallEvent_
}

type Data_DafnyCallEvent_ interface {
	isDafnyCallEvent()
}

type CompanionStruct_DafnyCallEvent_ struct {
}

var Companion_DafnyCallEvent_ = CompanionStruct_DafnyCallEvent_{}

type DafnyCallEvent_DafnyCallEvent struct {
	Input  interface{}
	Output interface{}
}

func (DafnyCallEvent_DafnyCallEvent) isDafnyCallEvent() {}

func (CompanionStruct_DafnyCallEvent_) Create_DafnyCallEvent_(Input interface{}, Output interface{}) DafnyCallEvent {
	return DafnyCallEvent{DafnyCallEvent_DafnyCallEvent{Input, Output}}
}

func (_this DafnyCallEvent) Is_DafnyCallEvent() bool {
	_, ok := _this.Get_().(DafnyCallEvent_DafnyCallEvent)
	return ok
}

func (CompanionStruct_DafnyCallEvent_) Default(_default_I interface{}, _default_O interface{}) DafnyCallEvent {
	return Companion_DafnyCallEvent_.Create_DafnyCallEvent_(_default_I, _default_O)
}

func (_this DafnyCallEvent) Dtor_input() interface{} {
	return _this.Get_().(DafnyCallEvent_DafnyCallEvent).Input
}

func (_this DafnyCallEvent) Dtor_output() interface{} {
	return _this.Get_().(DafnyCallEvent_DafnyCallEvent).Output
}

func (_this DafnyCallEvent) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DafnyCallEvent_DafnyCallEvent:
		{
			return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.DafnyCallEvent.DafnyCallEvent" + "(" + _dafny.String(data.Input) + ", " + _dafny.String(data.Output) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DafnyCallEvent) Equals(other DafnyCallEvent) bool {
	switch data1 := _this.Get_().(type) {
	case DafnyCallEvent_DafnyCallEvent:
		{
			data2, ok := other.Get_().(DafnyCallEvent_DafnyCallEvent)
			return ok && _dafny.AreEqual(data1.Input, data2.Input) && _dafny.AreEqual(data1.Output, data2.Output)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DafnyCallEvent) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DafnyCallEvent)
	return ok && _this.Equals(typed)
}

func Type_DafnyCallEvent_(Type_I_ _dafny.TypeDescriptor, Type_O_ _dafny.TypeDescriptor) _dafny.TypeDescriptor {
	return type_DafnyCallEvent_{Type_I_, Type_O_}
}

type type_DafnyCallEvent_ struct {
	Type_I_ _dafny.TypeDescriptor
	Type_O_ _dafny.TypeDescriptor
}

func (_this type_DafnyCallEvent_) Default() interface{} {
	Type_I_ := _this.Type_I_
	_ = Type_I_
	Type_O_ := _this.Type_O_
	_ = Type_O_
	return Companion_DafnyCallEvent_.Default(Type_I_.Default(), Type_O_.Default())
}

func (_this type_DafnyCallEvent_) String() string {
	return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.DafnyCallEvent"
}
func (_this DafnyCallEvent) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DafnyCallEvent{}

// End of datatype DafnyCallEvent

// Definition of datatype AuthenticateAction
type AuthenticateAction struct {
	Data_AuthenticateAction_
}

func (_this AuthenticateAction) Get_() Data_AuthenticateAction_ {
	return _this.Data_AuthenticateAction_
}

type Data_AuthenticateAction_ interface {
	isAuthenticateAction()
}

type CompanionStruct_AuthenticateAction_ struct {
}

var Companion_AuthenticateAction_ = CompanionStruct_AuthenticateAction_{}

type AuthenticateAction_SIGN struct {
}

func (AuthenticateAction_SIGN) isAuthenticateAction() {}

func (CompanionStruct_AuthenticateAction_) Create_SIGN_() AuthenticateAction {
	return AuthenticateAction{AuthenticateAction_SIGN{}}
}

func (_this AuthenticateAction) Is_SIGN() bool {
	_, ok := _this.Get_().(AuthenticateAction_SIGN)
	return ok
}

type AuthenticateAction_DO__NOT__SIGN struct {
}

func (AuthenticateAction_DO__NOT__SIGN) isAuthenticateAction() {}

func (CompanionStruct_AuthenticateAction_) Create_DO__NOT__SIGN_() AuthenticateAction {
	return AuthenticateAction{AuthenticateAction_DO__NOT__SIGN{}}
}

func (_this AuthenticateAction) Is_DO__NOT__SIGN() bool {
	_, ok := _this.Get_().(AuthenticateAction_DO__NOT__SIGN)
	return ok
}

func (CompanionStruct_AuthenticateAction_) Default() AuthenticateAction {
	return Companion_AuthenticateAction_.Create_SIGN_()
}

func (_ CompanionStruct_AuthenticateAction_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_AuthenticateAction_.Create_SIGN_(), true
		case 1:
			return Companion_AuthenticateAction_.Create_DO__NOT__SIGN_(), true
		default:
			return AuthenticateAction{}, false
		}
	}
}

func (_this AuthenticateAction) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case AuthenticateAction_SIGN:
		{
			return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.AuthenticateAction.SIGN"
		}
	case AuthenticateAction_DO__NOT__SIGN:
		{
			return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.AuthenticateAction.DO_NOT_SIGN"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this AuthenticateAction) Equals(other AuthenticateAction) bool {
	switch _this.Get_().(type) {
	case AuthenticateAction_SIGN:
		{
			_, ok := other.Get_().(AuthenticateAction_SIGN)
			return ok
		}
	case AuthenticateAction_DO__NOT__SIGN:
		{
			_, ok := other.Get_().(AuthenticateAction_DO__NOT__SIGN)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this AuthenticateAction) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(AuthenticateAction)
	return ok && _this.Equals(typed)
}

func Type_AuthenticateAction_() _dafny.TypeDescriptor {
	return type_AuthenticateAction_{}
}

type type_AuthenticateAction_ struct {
}

func (_this type_AuthenticateAction_) Default() interface{} {
	return Companion_AuthenticateAction_.Default()
}

func (_this type_AuthenticateAction_) String() string {
	return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.AuthenticateAction"
}
func (_this AuthenticateAction) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = AuthenticateAction{}

// End of datatype AuthenticateAction

// Definition of datatype AuthItem
type AuthItem struct {
	Data_AuthItem_
}

func (_this AuthItem) Get_() Data_AuthItem_ {
	return _this.Data_AuthItem_
}

type Data_AuthItem_ interface {
	isAuthItem()
}

type CompanionStruct_AuthItem_ struct {
}

var Companion_AuthItem_ = CompanionStruct_AuthItem_{}

type AuthItem_AuthItem struct {
	Key    _dafny.Sequence
	Data   StructuredDataTerminal
	Action AuthenticateAction
}

func (AuthItem_AuthItem) isAuthItem() {}

func (CompanionStruct_AuthItem_) Create_AuthItem_(Key _dafny.Sequence, Data StructuredDataTerminal, Action AuthenticateAction) AuthItem {
	return AuthItem{AuthItem_AuthItem{Key, Data, Action}}
}

func (_this AuthItem) Is_AuthItem() bool {
	_, ok := _this.Get_().(AuthItem_AuthItem)
	return ok
}

func (CompanionStruct_AuthItem_) Default() AuthItem {
	return Companion_AuthItem_.Create_AuthItem_(_dafny.EmptySeq, Companion_StructuredDataTerminal_.Default(), Companion_AuthenticateAction_.Default())
}

func (_this AuthItem) Dtor_key() _dafny.Sequence {
	return _this.Get_().(AuthItem_AuthItem).Key
}

func (_this AuthItem) Dtor_data() StructuredDataTerminal {
	return _this.Get_().(AuthItem_AuthItem).Data
}

func (_this AuthItem) Dtor_action() AuthenticateAction {
	return _this.Get_().(AuthItem_AuthItem).Action
}

func (_this AuthItem) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case AuthItem_AuthItem:
		{
			return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.AuthItem.AuthItem" + "(" + _dafny.String(data.Key) + ", " + _dafny.String(data.Data) + ", " + _dafny.String(data.Action) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this AuthItem) Equals(other AuthItem) bool {
	switch data1 := _this.Get_().(type) {
	case AuthItem_AuthItem:
		{
			data2, ok := other.Get_().(AuthItem_AuthItem)
			return ok && data1.Key.Equals(data2.Key) && data1.Data.Equals(data2.Data) && data1.Action.Equals(data2.Action)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this AuthItem) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(AuthItem)
	return ok && _this.Equals(typed)
}

func Type_AuthItem_() _dafny.TypeDescriptor {
	return type_AuthItem_{}
}

type type_AuthItem_ struct {
}

func (_this type_AuthItem_) Default() interface{} {
	return Companion_AuthItem_.Default()
}

func (_this type_AuthItem_) String() string {
	return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.AuthItem"
}
func (_this AuthItem) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = AuthItem{}

// End of datatype AuthItem

// Definition of datatype CryptoAction
type CryptoAction struct {
	Data_CryptoAction_
}

func (_this CryptoAction) Get_() Data_CryptoAction_ {
	return _this.Data_CryptoAction_
}

type Data_CryptoAction_ interface {
	isCryptoAction()
}

type CompanionStruct_CryptoAction_ struct {
}

var Companion_CryptoAction_ = CompanionStruct_CryptoAction_{}

type CryptoAction_ENCRYPT__AND__SIGN struct {
}

func (CryptoAction_ENCRYPT__AND__SIGN) isCryptoAction() {}

func (CompanionStruct_CryptoAction_) Create_ENCRYPT__AND__SIGN_() CryptoAction {
	return CryptoAction{CryptoAction_ENCRYPT__AND__SIGN{}}
}

func (_this CryptoAction) Is_ENCRYPT__AND__SIGN() bool {
	_, ok := _this.Get_().(CryptoAction_ENCRYPT__AND__SIGN)
	return ok
}

type CryptoAction_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT struct {
}

func (CryptoAction_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT) isCryptoAction() {}

func (CompanionStruct_CryptoAction_) Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_() CryptoAction {
	return CryptoAction{CryptoAction_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT{}}
}

func (_this CryptoAction) Is_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT() bool {
	_, ok := _this.Get_().(CryptoAction_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT)
	return ok
}

type CryptoAction_SIGN__ONLY struct {
}

func (CryptoAction_SIGN__ONLY) isCryptoAction() {}

func (CompanionStruct_CryptoAction_) Create_SIGN__ONLY_() CryptoAction {
	return CryptoAction{CryptoAction_SIGN__ONLY{}}
}

func (_this CryptoAction) Is_SIGN__ONLY() bool {
	_, ok := _this.Get_().(CryptoAction_SIGN__ONLY)
	return ok
}

type CryptoAction_DO__NOTHING struct {
}

func (CryptoAction_DO__NOTHING) isCryptoAction() {}

func (CompanionStruct_CryptoAction_) Create_DO__NOTHING_() CryptoAction {
	return CryptoAction{CryptoAction_DO__NOTHING{}}
}

func (_this CryptoAction) Is_DO__NOTHING() bool {
	_, ok := _this.Get_().(CryptoAction_DO__NOTHING)
	return ok
}

func (CompanionStruct_CryptoAction_) Default() CryptoAction {
	return Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_()
}

func (_ CompanionStruct_CryptoAction_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_CryptoAction_.Create_ENCRYPT__AND__SIGN_(), true
		case 1:
			return Companion_CryptoAction_.Create_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT_(), true
		case 2:
			return Companion_CryptoAction_.Create_SIGN__ONLY_(), true
		case 3:
			return Companion_CryptoAction_.Create_DO__NOTHING_(), true
		default:
			return CryptoAction{}, false
		}
	}
}

func (_this CryptoAction) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case CryptoAction_ENCRYPT__AND__SIGN:
		{
			return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction.ENCRYPT_AND_SIGN"
		}
	case CryptoAction_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT:
		{
			return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT"
		}
	case CryptoAction_SIGN__ONLY:
		{
			return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction.SIGN_ONLY"
		}
	case CryptoAction_DO__NOTHING:
		{
			return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction.DO_NOTHING"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CryptoAction) Equals(other CryptoAction) bool {
	switch _this.Get_().(type) {
	case CryptoAction_ENCRYPT__AND__SIGN:
		{
			_, ok := other.Get_().(CryptoAction_ENCRYPT__AND__SIGN)
			return ok
		}
	case CryptoAction_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT:
		{
			_, ok := other.Get_().(CryptoAction_SIGN__AND__INCLUDE__IN__ENCRYPTION__CONTEXT)
			return ok
		}
	case CryptoAction_SIGN__ONLY:
		{
			_, ok := other.Get_().(CryptoAction_SIGN__ONLY)
			return ok
		}
	case CryptoAction_DO__NOTHING:
		{
			_, ok := other.Get_().(CryptoAction_DO__NOTHING)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CryptoAction) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CryptoAction)
	return ok && _this.Equals(typed)
}

func Type_CryptoAction_() _dafny.TypeDescriptor {
	return type_CryptoAction_{}
}

type type_CryptoAction_ struct {
}

func (_this type_CryptoAction_) Default() interface{} {
	return Companion_CryptoAction_.Default()
}

func (_this type_CryptoAction_) String() string {
	return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoAction"
}
func (_this CryptoAction) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CryptoAction{}

// End of datatype CryptoAction

// Definition of datatype CryptoItem
type CryptoItem struct {
	Data_CryptoItem_
}

func (_this CryptoItem) Get_() Data_CryptoItem_ {
	return _this.Data_CryptoItem_
}

type Data_CryptoItem_ interface {
	isCryptoItem()
}

type CompanionStruct_CryptoItem_ struct {
}

var Companion_CryptoItem_ = CompanionStruct_CryptoItem_{}

type CryptoItem_CryptoItem struct {
	Key    _dafny.Sequence
	Data   StructuredDataTerminal
	Action CryptoAction
}

func (CryptoItem_CryptoItem) isCryptoItem() {}

func (CompanionStruct_CryptoItem_) Create_CryptoItem_(Key _dafny.Sequence, Data StructuredDataTerminal, Action CryptoAction) CryptoItem {
	return CryptoItem{CryptoItem_CryptoItem{Key, Data, Action}}
}

func (_this CryptoItem) Is_CryptoItem() bool {
	_, ok := _this.Get_().(CryptoItem_CryptoItem)
	return ok
}

func (CompanionStruct_CryptoItem_) Default() CryptoItem {
	return Companion_CryptoItem_.Create_CryptoItem_(_dafny.EmptySeq, Companion_StructuredDataTerminal_.Default(), Companion_CryptoAction_.Default())
}

func (_this CryptoItem) Dtor_key() _dafny.Sequence {
	return _this.Get_().(CryptoItem_CryptoItem).Key
}

func (_this CryptoItem) Dtor_data() StructuredDataTerminal {
	return _this.Get_().(CryptoItem_CryptoItem).Data
}

func (_this CryptoItem) Dtor_action() CryptoAction {
	return _this.Get_().(CryptoItem_CryptoItem).Action
}

func (_this CryptoItem) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case CryptoItem_CryptoItem:
		{
			return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem.CryptoItem" + "(" + _dafny.String(data.Key) + ", " + _dafny.String(data.Data) + ", " + _dafny.String(data.Action) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this CryptoItem) Equals(other CryptoItem) bool {
	switch data1 := _this.Get_().(type) {
	case CryptoItem_CryptoItem:
		{
			data2, ok := other.Get_().(CryptoItem_CryptoItem)
			return ok && data1.Key.Equals(data2.Key) && data1.Data.Equals(data2.Data) && data1.Action.Equals(data2.Action)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this CryptoItem) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(CryptoItem)
	return ok && _this.Equals(typed)
}

func Type_CryptoItem_() _dafny.TypeDescriptor {
	return type_CryptoItem_{}
}

type type_CryptoItem_ struct {
}

func (_this type_CryptoItem_) Default() interface{} {
	return Companion_CryptoItem_.Default()
}

func (_this type_CryptoItem_) String() string {
	return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.CryptoItem"
}
func (_this CryptoItem) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = CryptoItem{}

// End of datatype CryptoItem

// Definition of datatype DecryptPathStructureInput
type DecryptPathStructureInput struct {
	Data_DecryptPathStructureInput_
}

func (_this DecryptPathStructureInput) Get_() Data_DecryptPathStructureInput_ {
	return _this.Data_DecryptPathStructureInput_
}

type Data_DecryptPathStructureInput_ interface {
	isDecryptPathStructureInput()
}

type CompanionStruct_DecryptPathStructureInput_ struct {
}

var Companion_DecryptPathStructureInput_ = CompanionStruct_DecryptPathStructureInput_{}

type DecryptPathStructureInput_DecryptPathStructureInput struct {
	TableName          _dafny.Sequence
	EncryptedStructure _dafny.Sequence
	Cmm                m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager
	EncryptionContext  m_Wrappers.Option
}

func (DecryptPathStructureInput_DecryptPathStructureInput) isDecryptPathStructureInput() {}

func (CompanionStruct_DecryptPathStructureInput_) Create_DecryptPathStructureInput_(TableName _dafny.Sequence, EncryptedStructure _dafny.Sequence, Cmm m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager, EncryptionContext m_Wrappers.Option) DecryptPathStructureInput {
	return DecryptPathStructureInput{DecryptPathStructureInput_DecryptPathStructureInput{TableName, EncryptedStructure, Cmm, EncryptionContext}}
}

func (_this DecryptPathStructureInput) Is_DecryptPathStructureInput() bool {
	_, ok := _this.Get_().(DecryptPathStructureInput_DecryptPathStructureInput)
	return ok
}

func (CompanionStruct_DecryptPathStructureInput_) Default() DecryptPathStructureInput {
	return Companion_DecryptPathStructureInput_.Create_DecryptPathStructureInput_(_dafny.EmptySeq.SetString(), _dafny.EmptySeq, (m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager)(nil), m_Wrappers.Companion_Option_.Default())
}

func (_this DecryptPathStructureInput) Dtor_tableName() _dafny.Sequence {
	return _this.Get_().(DecryptPathStructureInput_DecryptPathStructureInput).TableName
}

func (_this DecryptPathStructureInput) Dtor_encryptedStructure() _dafny.Sequence {
	return _this.Get_().(DecryptPathStructureInput_DecryptPathStructureInput).EncryptedStructure
}

func (_this DecryptPathStructureInput) Dtor_cmm() m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager {
	return _this.Get_().(DecryptPathStructureInput_DecryptPathStructureInput).Cmm
}

func (_this DecryptPathStructureInput) Dtor_encryptionContext() m_Wrappers.Option {
	return _this.Get_().(DecryptPathStructureInput_DecryptPathStructureInput).EncryptionContext
}

func (_this DecryptPathStructureInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DecryptPathStructureInput_DecryptPathStructureInput:
		{
			return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.DecryptPathStructureInput.DecryptPathStructureInput" + "(" + _dafny.String(data.TableName) + ", " + _dafny.String(data.EncryptedStructure) + ", " + _dafny.String(data.Cmm) + ", " + _dafny.String(data.EncryptionContext) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DecryptPathStructureInput) Equals(other DecryptPathStructureInput) bool {
	switch data1 := _this.Get_().(type) {
	case DecryptPathStructureInput_DecryptPathStructureInput:
		{
			data2, ok := other.Get_().(DecryptPathStructureInput_DecryptPathStructureInput)
			return ok && data1.TableName.Equals(data2.TableName) && data1.EncryptedStructure.Equals(data2.EncryptedStructure) && _dafny.AreEqual(data1.Cmm, data2.Cmm) && data1.EncryptionContext.Equals(data2.EncryptionContext)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DecryptPathStructureInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DecryptPathStructureInput)
	return ok && _this.Equals(typed)
}

func Type_DecryptPathStructureInput_() _dafny.TypeDescriptor {
	return type_DecryptPathStructureInput_{}
}

type type_DecryptPathStructureInput_ struct {
}

func (_this type_DecryptPathStructureInput_) Default() interface{} {
	return Companion_DecryptPathStructureInput_.Default()
}

func (_this type_DecryptPathStructureInput_) String() string {
	return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.DecryptPathStructureInput"
}
func (_this DecryptPathStructureInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DecryptPathStructureInput{}

// End of datatype DecryptPathStructureInput

// Definition of datatype DecryptPathStructureOutput
type DecryptPathStructureOutput struct {
	Data_DecryptPathStructureOutput_
}

func (_this DecryptPathStructureOutput) Get_() Data_DecryptPathStructureOutput_ {
	return _this.Data_DecryptPathStructureOutput_
}

type Data_DecryptPathStructureOutput_ interface {
	isDecryptPathStructureOutput()
}

type CompanionStruct_DecryptPathStructureOutput_ struct {
}

var Companion_DecryptPathStructureOutput_ = CompanionStruct_DecryptPathStructureOutput_{}

type DecryptPathStructureOutput_DecryptPathStructureOutput struct {
	PlaintextStructure _dafny.Sequence
	ParsedHeader       ParsedHeader
}

func (DecryptPathStructureOutput_DecryptPathStructureOutput) isDecryptPathStructureOutput() {}

func (CompanionStruct_DecryptPathStructureOutput_) Create_DecryptPathStructureOutput_(PlaintextStructure _dafny.Sequence, ParsedHeader ParsedHeader) DecryptPathStructureOutput {
	return DecryptPathStructureOutput{DecryptPathStructureOutput_DecryptPathStructureOutput{PlaintextStructure, ParsedHeader}}
}

func (_this DecryptPathStructureOutput) Is_DecryptPathStructureOutput() bool {
	_, ok := _this.Get_().(DecryptPathStructureOutput_DecryptPathStructureOutput)
	return ok
}

func (CompanionStruct_DecryptPathStructureOutput_) Default() DecryptPathStructureOutput {
	return Companion_DecryptPathStructureOutput_.Create_DecryptPathStructureOutput_(_dafny.EmptySeq, Companion_ParsedHeader_.Default())
}

func (_this DecryptPathStructureOutput) Dtor_plaintextStructure() _dafny.Sequence {
	return _this.Get_().(DecryptPathStructureOutput_DecryptPathStructureOutput).PlaintextStructure
}

func (_this DecryptPathStructureOutput) Dtor_parsedHeader() ParsedHeader {
	return _this.Get_().(DecryptPathStructureOutput_DecryptPathStructureOutput).ParsedHeader
}

func (_this DecryptPathStructureOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DecryptPathStructureOutput_DecryptPathStructureOutput:
		{
			return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.DecryptPathStructureOutput.DecryptPathStructureOutput" + "(" + _dafny.String(data.PlaintextStructure) + ", " + _dafny.String(data.ParsedHeader) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DecryptPathStructureOutput) Equals(other DecryptPathStructureOutput) bool {
	switch data1 := _this.Get_().(type) {
	case DecryptPathStructureOutput_DecryptPathStructureOutput:
		{
			data2, ok := other.Get_().(DecryptPathStructureOutput_DecryptPathStructureOutput)
			return ok && data1.PlaintextStructure.Equals(data2.PlaintextStructure) && data1.ParsedHeader.Equals(data2.ParsedHeader)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DecryptPathStructureOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DecryptPathStructureOutput)
	return ok && _this.Equals(typed)
}

func Type_DecryptPathStructureOutput_() _dafny.TypeDescriptor {
	return type_DecryptPathStructureOutput_{}
}

type type_DecryptPathStructureOutput_ struct {
}

func (_this type_DecryptPathStructureOutput_) Default() interface{} {
	return Companion_DecryptPathStructureOutput_.Default()
}

func (_this type_DecryptPathStructureOutput_) String() string {
	return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.DecryptPathStructureOutput"
}
func (_this DecryptPathStructureOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DecryptPathStructureOutput{}

// End of datatype DecryptPathStructureOutput

// Definition of datatype DecryptStructureInput
type DecryptStructureInput struct {
	Data_DecryptStructureInput_
}

func (_this DecryptStructureInput) Get_() Data_DecryptStructureInput_ {
	return _this.Data_DecryptStructureInput_
}

type Data_DecryptStructureInput_ interface {
	isDecryptStructureInput()
}

type CompanionStruct_DecryptStructureInput_ struct {
}

var Companion_DecryptStructureInput_ = CompanionStruct_DecryptStructureInput_{}

type DecryptStructureInput_DecryptStructureInput struct {
	TableName          _dafny.Sequence
	EncryptedStructure _dafny.Map
	AuthenticateSchema _dafny.Map
	Cmm                m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager
	EncryptionContext  m_Wrappers.Option
}

func (DecryptStructureInput_DecryptStructureInput) isDecryptStructureInput() {}

func (CompanionStruct_DecryptStructureInput_) Create_DecryptStructureInput_(TableName _dafny.Sequence, EncryptedStructure _dafny.Map, AuthenticateSchema _dafny.Map, Cmm m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager, EncryptionContext m_Wrappers.Option) DecryptStructureInput {
	return DecryptStructureInput{DecryptStructureInput_DecryptStructureInput{TableName, EncryptedStructure, AuthenticateSchema, Cmm, EncryptionContext}}
}

func (_this DecryptStructureInput) Is_DecryptStructureInput() bool {
	_, ok := _this.Get_().(DecryptStructureInput_DecryptStructureInput)
	return ok
}

func (CompanionStruct_DecryptStructureInput_) Default() DecryptStructureInput {
	return Companion_DecryptStructureInput_.Create_DecryptStructureInput_(_dafny.EmptySeq.SetString(), _dafny.EmptyMap, _dafny.EmptyMap, (m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager)(nil), m_Wrappers.Companion_Option_.Default())
}

func (_this DecryptStructureInput) Dtor_tableName() _dafny.Sequence {
	return _this.Get_().(DecryptStructureInput_DecryptStructureInput).TableName
}

func (_this DecryptStructureInput) Dtor_encryptedStructure() _dafny.Map {
	return _this.Get_().(DecryptStructureInput_DecryptStructureInput).EncryptedStructure
}

func (_this DecryptStructureInput) Dtor_authenticateSchema() _dafny.Map {
	return _this.Get_().(DecryptStructureInput_DecryptStructureInput).AuthenticateSchema
}

func (_this DecryptStructureInput) Dtor_cmm() m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager {
	return _this.Get_().(DecryptStructureInput_DecryptStructureInput).Cmm
}

func (_this DecryptStructureInput) Dtor_encryptionContext() m_Wrappers.Option {
	return _this.Get_().(DecryptStructureInput_DecryptStructureInput).EncryptionContext
}

func (_this DecryptStructureInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DecryptStructureInput_DecryptStructureInput:
		{
			return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.DecryptStructureInput.DecryptStructureInput" + "(" + _dafny.String(data.TableName) + ", " + _dafny.String(data.EncryptedStructure) + ", " + _dafny.String(data.AuthenticateSchema) + ", " + _dafny.String(data.Cmm) + ", " + _dafny.String(data.EncryptionContext) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DecryptStructureInput) Equals(other DecryptStructureInput) bool {
	switch data1 := _this.Get_().(type) {
	case DecryptStructureInput_DecryptStructureInput:
		{
			data2, ok := other.Get_().(DecryptStructureInput_DecryptStructureInput)
			return ok && data1.TableName.Equals(data2.TableName) && data1.EncryptedStructure.Equals(data2.EncryptedStructure) && data1.AuthenticateSchema.Equals(data2.AuthenticateSchema) && _dafny.AreEqual(data1.Cmm, data2.Cmm) && data1.EncryptionContext.Equals(data2.EncryptionContext)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DecryptStructureInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DecryptStructureInput)
	return ok && _this.Equals(typed)
}

func Type_DecryptStructureInput_() _dafny.TypeDescriptor {
	return type_DecryptStructureInput_{}
}

type type_DecryptStructureInput_ struct {
}

func (_this type_DecryptStructureInput_) Default() interface{} {
	return Companion_DecryptStructureInput_.Default()
}

func (_this type_DecryptStructureInput_) String() string {
	return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.DecryptStructureInput"
}
func (_this DecryptStructureInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DecryptStructureInput{}

// End of datatype DecryptStructureInput

// Definition of datatype DecryptStructureOutput
type DecryptStructureOutput struct {
	Data_DecryptStructureOutput_
}

func (_this DecryptStructureOutput) Get_() Data_DecryptStructureOutput_ {
	return _this.Data_DecryptStructureOutput_
}

type Data_DecryptStructureOutput_ interface {
	isDecryptStructureOutput()
}

type CompanionStruct_DecryptStructureOutput_ struct {
}

var Companion_DecryptStructureOutput_ = CompanionStruct_DecryptStructureOutput_{}

type DecryptStructureOutput_DecryptStructureOutput struct {
	PlaintextStructure _dafny.Map
	CryptoSchema       _dafny.Map
	ParsedHeader       ParsedHeader
}

func (DecryptStructureOutput_DecryptStructureOutput) isDecryptStructureOutput() {}

func (CompanionStruct_DecryptStructureOutput_) Create_DecryptStructureOutput_(PlaintextStructure _dafny.Map, CryptoSchema _dafny.Map, ParsedHeader ParsedHeader) DecryptStructureOutput {
	return DecryptStructureOutput{DecryptStructureOutput_DecryptStructureOutput{PlaintextStructure, CryptoSchema, ParsedHeader}}
}

func (_this DecryptStructureOutput) Is_DecryptStructureOutput() bool {
	_, ok := _this.Get_().(DecryptStructureOutput_DecryptStructureOutput)
	return ok
}

func (CompanionStruct_DecryptStructureOutput_) Default() DecryptStructureOutput {
	return Companion_DecryptStructureOutput_.Create_DecryptStructureOutput_(_dafny.EmptyMap, _dafny.EmptyMap, Companion_ParsedHeader_.Default())
}

func (_this DecryptStructureOutput) Dtor_plaintextStructure() _dafny.Map {
	return _this.Get_().(DecryptStructureOutput_DecryptStructureOutput).PlaintextStructure
}

func (_this DecryptStructureOutput) Dtor_cryptoSchema() _dafny.Map {
	return _this.Get_().(DecryptStructureOutput_DecryptStructureOutput).CryptoSchema
}

func (_this DecryptStructureOutput) Dtor_parsedHeader() ParsedHeader {
	return _this.Get_().(DecryptStructureOutput_DecryptStructureOutput).ParsedHeader
}

func (_this DecryptStructureOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case DecryptStructureOutput_DecryptStructureOutput:
		{
			return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.DecryptStructureOutput.DecryptStructureOutput" + "(" + _dafny.String(data.PlaintextStructure) + ", " + _dafny.String(data.CryptoSchema) + ", " + _dafny.String(data.ParsedHeader) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this DecryptStructureOutput) Equals(other DecryptStructureOutput) bool {
	switch data1 := _this.Get_().(type) {
	case DecryptStructureOutput_DecryptStructureOutput:
		{
			data2, ok := other.Get_().(DecryptStructureOutput_DecryptStructureOutput)
			return ok && data1.PlaintextStructure.Equals(data2.PlaintextStructure) && data1.CryptoSchema.Equals(data2.CryptoSchema) && data1.ParsedHeader.Equals(data2.ParsedHeader)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this DecryptStructureOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(DecryptStructureOutput)
	return ok && _this.Equals(typed)
}

func Type_DecryptStructureOutput_() _dafny.TypeDescriptor {
	return type_DecryptStructureOutput_{}
}

type type_DecryptStructureOutput_ struct {
}

func (_this type_DecryptStructureOutput_) Default() interface{} {
	return Companion_DecryptStructureOutput_.Default()
}

func (_this type_DecryptStructureOutput_) String() string {
	return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.DecryptStructureOutput"
}
func (_this DecryptStructureOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = DecryptStructureOutput{}

// End of datatype DecryptStructureOutput

// Definition of datatype EncryptPathStructureInput
type EncryptPathStructureInput struct {
	Data_EncryptPathStructureInput_
}

func (_this EncryptPathStructureInput) Get_() Data_EncryptPathStructureInput_ {
	return _this.Data_EncryptPathStructureInput_
}

type Data_EncryptPathStructureInput_ interface {
	isEncryptPathStructureInput()
}

type CompanionStruct_EncryptPathStructureInput_ struct {
}

var Companion_EncryptPathStructureInput_ = CompanionStruct_EncryptPathStructureInput_{}

type EncryptPathStructureInput_EncryptPathStructureInput struct {
	TableName          _dafny.Sequence
	PlaintextStructure _dafny.Sequence
	Cmm                m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager
	AlgorithmSuiteId   m_Wrappers.Option
	EncryptionContext  m_Wrappers.Option
}

func (EncryptPathStructureInput_EncryptPathStructureInput) isEncryptPathStructureInput() {}

func (CompanionStruct_EncryptPathStructureInput_) Create_EncryptPathStructureInput_(TableName _dafny.Sequence, PlaintextStructure _dafny.Sequence, Cmm m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager, AlgorithmSuiteId m_Wrappers.Option, EncryptionContext m_Wrappers.Option) EncryptPathStructureInput {
	return EncryptPathStructureInput{EncryptPathStructureInput_EncryptPathStructureInput{TableName, PlaintextStructure, Cmm, AlgorithmSuiteId, EncryptionContext}}
}

func (_this EncryptPathStructureInput) Is_EncryptPathStructureInput() bool {
	_, ok := _this.Get_().(EncryptPathStructureInput_EncryptPathStructureInput)
	return ok
}

func (CompanionStruct_EncryptPathStructureInput_) Default() EncryptPathStructureInput {
	return Companion_EncryptPathStructureInput_.Create_EncryptPathStructureInput_(_dafny.EmptySeq.SetString(), _dafny.EmptySeq, (m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager)(nil), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this EncryptPathStructureInput) Dtor_tableName() _dafny.Sequence {
	return _this.Get_().(EncryptPathStructureInput_EncryptPathStructureInput).TableName
}

func (_this EncryptPathStructureInput) Dtor_plaintextStructure() _dafny.Sequence {
	return _this.Get_().(EncryptPathStructureInput_EncryptPathStructureInput).PlaintextStructure
}

func (_this EncryptPathStructureInput) Dtor_cmm() m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager {
	return _this.Get_().(EncryptPathStructureInput_EncryptPathStructureInput).Cmm
}

func (_this EncryptPathStructureInput) Dtor_algorithmSuiteId() m_Wrappers.Option {
	return _this.Get_().(EncryptPathStructureInput_EncryptPathStructureInput).AlgorithmSuiteId
}

func (_this EncryptPathStructureInput) Dtor_encryptionContext() m_Wrappers.Option {
	return _this.Get_().(EncryptPathStructureInput_EncryptPathStructureInput).EncryptionContext
}

func (_this EncryptPathStructureInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case EncryptPathStructureInput_EncryptPathStructureInput:
		{
			return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.EncryptPathStructureInput.EncryptPathStructureInput" + "(" + _dafny.String(data.TableName) + ", " + _dafny.String(data.PlaintextStructure) + ", " + _dafny.String(data.Cmm) + ", " + _dafny.String(data.AlgorithmSuiteId) + ", " + _dafny.String(data.EncryptionContext) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this EncryptPathStructureInput) Equals(other EncryptPathStructureInput) bool {
	switch data1 := _this.Get_().(type) {
	case EncryptPathStructureInput_EncryptPathStructureInput:
		{
			data2, ok := other.Get_().(EncryptPathStructureInput_EncryptPathStructureInput)
			return ok && data1.TableName.Equals(data2.TableName) && data1.PlaintextStructure.Equals(data2.PlaintextStructure) && _dafny.AreEqual(data1.Cmm, data2.Cmm) && data1.AlgorithmSuiteId.Equals(data2.AlgorithmSuiteId) && data1.EncryptionContext.Equals(data2.EncryptionContext)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this EncryptPathStructureInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(EncryptPathStructureInput)
	return ok && _this.Equals(typed)
}

func Type_EncryptPathStructureInput_() _dafny.TypeDescriptor {
	return type_EncryptPathStructureInput_{}
}

type type_EncryptPathStructureInput_ struct {
}

func (_this type_EncryptPathStructureInput_) Default() interface{} {
	return Companion_EncryptPathStructureInput_.Default()
}

func (_this type_EncryptPathStructureInput_) String() string {
	return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.EncryptPathStructureInput"
}
func (_this EncryptPathStructureInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = EncryptPathStructureInput{}

// End of datatype EncryptPathStructureInput

// Definition of datatype EncryptPathStructureOutput
type EncryptPathStructureOutput struct {
	Data_EncryptPathStructureOutput_
}

func (_this EncryptPathStructureOutput) Get_() Data_EncryptPathStructureOutput_ {
	return _this.Data_EncryptPathStructureOutput_
}

type Data_EncryptPathStructureOutput_ interface {
	isEncryptPathStructureOutput()
}

type CompanionStruct_EncryptPathStructureOutput_ struct {
}

var Companion_EncryptPathStructureOutput_ = CompanionStruct_EncryptPathStructureOutput_{}

type EncryptPathStructureOutput_EncryptPathStructureOutput struct {
	EncryptedStructure _dafny.Sequence
	ParsedHeader       ParsedHeader
}

func (EncryptPathStructureOutput_EncryptPathStructureOutput) isEncryptPathStructureOutput() {}

func (CompanionStruct_EncryptPathStructureOutput_) Create_EncryptPathStructureOutput_(EncryptedStructure _dafny.Sequence, ParsedHeader ParsedHeader) EncryptPathStructureOutput {
	return EncryptPathStructureOutput{EncryptPathStructureOutput_EncryptPathStructureOutput{EncryptedStructure, ParsedHeader}}
}

func (_this EncryptPathStructureOutput) Is_EncryptPathStructureOutput() bool {
	_, ok := _this.Get_().(EncryptPathStructureOutput_EncryptPathStructureOutput)
	return ok
}

func (CompanionStruct_EncryptPathStructureOutput_) Default() EncryptPathStructureOutput {
	return Companion_EncryptPathStructureOutput_.Create_EncryptPathStructureOutput_(_dafny.EmptySeq, Companion_ParsedHeader_.Default())
}

func (_this EncryptPathStructureOutput) Dtor_encryptedStructure() _dafny.Sequence {
	return _this.Get_().(EncryptPathStructureOutput_EncryptPathStructureOutput).EncryptedStructure
}

func (_this EncryptPathStructureOutput) Dtor_parsedHeader() ParsedHeader {
	return _this.Get_().(EncryptPathStructureOutput_EncryptPathStructureOutput).ParsedHeader
}

func (_this EncryptPathStructureOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case EncryptPathStructureOutput_EncryptPathStructureOutput:
		{
			return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.EncryptPathStructureOutput.EncryptPathStructureOutput" + "(" + _dafny.String(data.EncryptedStructure) + ", " + _dafny.String(data.ParsedHeader) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this EncryptPathStructureOutput) Equals(other EncryptPathStructureOutput) bool {
	switch data1 := _this.Get_().(type) {
	case EncryptPathStructureOutput_EncryptPathStructureOutput:
		{
			data2, ok := other.Get_().(EncryptPathStructureOutput_EncryptPathStructureOutput)
			return ok && data1.EncryptedStructure.Equals(data2.EncryptedStructure) && data1.ParsedHeader.Equals(data2.ParsedHeader)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this EncryptPathStructureOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(EncryptPathStructureOutput)
	return ok && _this.Equals(typed)
}

func Type_EncryptPathStructureOutput_() _dafny.TypeDescriptor {
	return type_EncryptPathStructureOutput_{}
}

type type_EncryptPathStructureOutput_ struct {
}

func (_this type_EncryptPathStructureOutput_) Default() interface{} {
	return Companion_EncryptPathStructureOutput_.Default()
}

func (_this type_EncryptPathStructureOutput_) String() string {
	return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.EncryptPathStructureOutput"
}
func (_this EncryptPathStructureOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = EncryptPathStructureOutput{}

// End of datatype EncryptPathStructureOutput

// Definition of datatype EncryptStructureInput
type EncryptStructureInput struct {
	Data_EncryptStructureInput_
}

func (_this EncryptStructureInput) Get_() Data_EncryptStructureInput_ {
	return _this.Data_EncryptStructureInput_
}

type Data_EncryptStructureInput_ interface {
	isEncryptStructureInput()
}

type CompanionStruct_EncryptStructureInput_ struct {
}

var Companion_EncryptStructureInput_ = CompanionStruct_EncryptStructureInput_{}

type EncryptStructureInput_EncryptStructureInput struct {
	TableName          _dafny.Sequence
	PlaintextStructure _dafny.Map
	CryptoSchema       _dafny.Map
	Cmm                m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager
	AlgorithmSuiteId   m_Wrappers.Option
	EncryptionContext  m_Wrappers.Option
}

func (EncryptStructureInput_EncryptStructureInput) isEncryptStructureInput() {}

func (CompanionStruct_EncryptStructureInput_) Create_EncryptStructureInput_(TableName _dafny.Sequence, PlaintextStructure _dafny.Map, CryptoSchema _dafny.Map, Cmm m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager, AlgorithmSuiteId m_Wrappers.Option, EncryptionContext m_Wrappers.Option) EncryptStructureInput {
	return EncryptStructureInput{EncryptStructureInput_EncryptStructureInput{TableName, PlaintextStructure, CryptoSchema, Cmm, AlgorithmSuiteId, EncryptionContext}}
}

func (_this EncryptStructureInput) Is_EncryptStructureInput() bool {
	_, ok := _this.Get_().(EncryptStructureInput_EncryptStructureInput)
	return ok
}

func (CompanionStruct_EncryptStructureInput_) Default() EncryptStructureInput {
	return Companion_EncryptStructureInput_.Create_EncryptStructureInput_(_dafny.EmptySeq.SetString(), _dafny.EmptyMap, _dafny.EmptyMap, (m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager)(nil), m_Wrappers.Companion_Option_.Default(), m_Wrappers.Companion_Option_.Default())
}

func (_this EncryptStructureInput) Dtor_tableName() _dafny.Sequence {
	return _this.Get_().(EncryptStructureInput_EncryptStructureInput).TableName
}

func (_this EncryptStructureInput) Dtor_plaintextStructure() _dafny.Map {
	return _this.Get_().(EncryptStructureInput_EncryptStructureInput).PlaintextStructure
}

func (_this EncryptStructureInput) Dtor_cryptoSchema() _dafny.Map {
	return _this.Get_().(EncryptStructureInput_EncryptStructureInput).CryptoSchema
}

func (_this EncryptStructureInput) Dtor_cmm() m_AwsCryptographyMaterialProvidersTypes.ICryptographicMaterialsManager {
	return _this.Get_().(EncryptStructureInput_EncryptStructureInput).Cmm
}

func (_this EncryptStructureInput) Dtor_algorithmSuiteId() m_Wrappers.Option {
	return _this.Get_().(EncryptStructureInput_EncryptStructureInput).AlgorithmSuiteId
}

func (_this EncryptStructureInput) Dtor_encryptionContext() m_Wrappers.Option {
	return _this.Get_().(EncryptStructureInput_EncryptStructureInput).EncryptionContext
}

func (_this EncryptStructureInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case EncryptStructureInput_EncryptStructureInput:
		{
			return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.EncryptStructureInput.EncryptStructureInput" + "(" + _dafny.String(data.TableName) + ", " + _dafny.String(data.PlaintextStructure) + ", " + _dafny.String(data.CryptoSchema) + ", " + _dafny.String(data.Cmm) + ", " + _dafny.String(data.AlgorithmSuiteId) + ", " + _dafny.String(data.EncryptionContext) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this EncryptStructureInput) Equals(other EncryptStructureInput) bool {
	switch data1 := _this.Get_().(type) {
	case EncryptStructureInput_EncryptStructureInput:
		{
			data2, ok := other.Get_().(EncryptStructureInput_EncryptStructureInput)
			return ok && data1.TableName.Equals(data2.TableName) && data1.PlaintextStructure.Equals(data2.PlaintextStructure) && data1.CryptoSchema.Equals(data2.CryptoSchema) && _dafny.AreEqual(data1.Cmm, data2.Cmm) && data1.AlgorithmSuiteId.Equals(data2.AlgorithmSuiteId) && data1.EncryptionContext.Equals(data2.EncryptionContext)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this EncryptStructureInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(EncryptStructureInput)
	return ok && _this.Equals(typed)
}

func Type_EncryptStructureInput_() _dafny.TypeDescriptor {
	return type_EncryptStructureInput_{}
}

type type_EncryptStructureInput_ struct {
}

func (_this type_EncryptStructureInput_) Default() interface{} {
	return Companion_EncryptStructureInput_.Default()
}

func (_this type_EncryptStructureInput_) String() string {
	return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.EncryptStructureInput"
}
func (_this EncryptStructureInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = EncryptStructureInput{}

// End of datatype EncryptStructureInput

// Definition of datatype EncryptStructureOutput
type EncryptStructureOutput struct {
	Data_EncryptStructureOutput_
}

func (_this EncryptStructureOutput) Get_() Data_EncryptStructureOutput_ {
	return _this.Data_EncryptStructureOutput_
}

type Data_EncryptStructureOutput_ interface {
	isEncryptStructureOutput()
}

type CompanionStruct_EncryptStructureOutput_ struct {
}

var Companion_EncryptStructureOutput_ = CompanionStruct_EncryptStructureOutput_{}

type EncryptStructureOutput_EncryptStructureOutput struct {
	EncryptedStructure _dafny.Map
	CryptoSchema       _dafny.Map
	ParsedHeader       ParsedHeader
}

func (EncryptStructureOutput_EncryptStructureOutput) isEncryptStructureOutput() {}

func (CompanionStruct_EncryptStructureOutput_) Create_EncryptStructureOutput_(EncryptedStructure _dafny.Map, CryptoSchema _dafny.Map, ParsedHeader ParsedHeader) EncryptStructureOutput {
	return EncryptStructureOutput{EncryptStructureOutput_EncryptStructureOutput{EncryptedStructure, CryptoSchema, ParsedHeader}}
}

func (_this EncryptStructureOutput) Is_EncryptStructureOutput() bool {
	_, ok := _this.Get_().(EncryptStructureOutput_EncryptStructureOutput)
	return ok
}

func (CompanionStruct_EncryptStructureOutput_) Default() EncryptStructureOutput {
	return Companion_EncryptStructureOutput_.Create_EncryptStructureOutput_(_dafny.EmptyMap, _dafny.EmptyMap, Companion_ParsedHeader_.Default())
}

func (_this EncryptStructureOutput) Dtor_encryptedStructure() _dafny.Map {
	return _this.Get_().(EncryptStructureOutput_EncryptStructureOutput).EncryptedStructure
}

func (_this EncryptStructureOutput) Dtor_cryptoSchema() _dafny.Map {
	return _this.Get_().(EncryptStructureOutput_EncryptStructureOutput).CryptoSchema
}

func (_this EncryptStructureOutput) Dtor_parsedHeader() ParsedHeader {
	return _this.Get_().(EncryptStructureOutput_EncryptStructureOutput).ParsedHeader
}

func (_this EncryptStructureOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case EncryptStructureOutput_EncryptStructureOutput:
		{
			return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.EncryptStructureOutput.EncryptStructureOutput" + "(" + _dafny.String(data.EncryptedStructure) + ", " + _dafny.String(data.CryptoSchema) + ", " + _dafny.String(data.ParsedHeader) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this EncryptStructureOutput) Equals(other EncryptStructureOutput) bool {
	switch data1 := _this.Get_().(type) {
	case EncryptStructureOutput_EncryptStructureOutput:
		{
			data2, ok := other.Get_().(EncryptStructureOutput_EncryptStructureOutput)
			return ok && data1.EncryptedStructure.Equals(data2.EncryptedStructure) && data1.CryptoSchema.Equals(data2.CryptoSchema) && data1.ParsedHeader.Equals(data2.ParsedHeader)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this EncryptStructureOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(EncryptStructureOutput)
	return ok && _this.Equals(typed)
}

func Type_EncryptStructureOutput_() _dafny.TypeDescriptor {
	return type_EncryptStructureOutput_{}
}

type type_EncryptStructureOutput_ struct {
}

func (_this type_EncryptStructureOutput_) Default() interface{} {
	return Companion_EncryptStructureOutput_.Default()
}

func (_this type_EncryptStructureOutput_) String() string {
	return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.EncryptStructureOutput"
}
func (_this EncryptStructureOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = EncryptStructureOutput{}

// End of datatype EncryptStructureOutput

// Definition of datatype ParsedHeader
type ParsedHeader struct {
	Data_ParsedHeader_
}

func (_this ParsedHeader) Get_() Data_ParsedHeader_ {
	return _this.Data_ParsedHeader_
}

type Data_ParsedHeader_ interface {
	isParsedHeader()
}

type CompanionStruct_ParsedHeader_ struct {
}

var Companion_ParsedHeader_ = CompanionStruct_ParsedHeader_{}

type ParsedHeader_ParsedHeader struct {
	AlgorithmSuiteId        m_AwsCryptographyMaterialProvidersTypes.DBEAlgorithmSuiteId
	EncryptedDataKeys       _dafny.Sequence
	StoredEncryptionContext _dafny.Map
	EncryptionContext       _dafny.Map
}

func (ParsedHeader_ParsedHeader) isParsedHeader() {}

func (CompanionStruct_ParsedHeader_) Create_ParsedHeader_(AlgorithmSuiteId m_AwsCryptographyMaterialProvidersTypes.DBEAlgorithmSuiteId, EncryptedDataKeys _dafny.Sequence, StoredEncryptionContext _dafny.Map, EncryptionContext _dafny.Map) ParsedHeader {
	return ParsedHeader{ParsedHeader_ParsedHeader{AlgorithmSuiteId, EncryptedDataKeys, StoredEncryptionContext, EncryptionContext}}
}

func (_this ParsedHeader) Is_ParsedHeader() bool {
	_, ok := _this.Get_().(ParsedHeader_ParsedHeader)
	return ok
}

func (CompanionStruct_ParsedHeader_) Default() ParsedHeader {
	return Companion_ParsedHeader_.Create_ParsedHeader_(m_AwsCryptographyMaterialProvidersTypes.Companion_DBEAlgorithmSuiteId_.Default(), _dafny.EmptySeq, _dafny.EmptyMap, _dafny.EmptyMap)
}

func (_this ParsedHeader) Dtor_algorithmSuiteId() m_AwsCryptographyMaterialProvidersTypes.DBEAlgorithmSuiteId {
	return _this.Get_().(ParsedHeader_ParsedHeader).AlgorithmSuiteId
}

func (_this ParsedHeader) Dtor_encryptedDataKeys() _dafny.Sequence {
	return _this.Get_().(ParsedHeader_ParsedHeader).EncryptedDataKeys
}

func (_this ParsedHeader) Dtor_storedEncryptionContext() _dafny.Map {
	return _this.Get_().(ParsedHeader_ParsedHeader).StoredEncryptionContext
}

func (_this ParsedHeader) Dtor_encryptionContext() _dafny.Map {
	return _this.Get_().(ParsedHeader_ParsedHeader).EncryptionContext
}

func (_this ParsedHeader) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ParsedHeader_ParsedHeader:
		{
			return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.ParsedHeader.ParsedHeader" + "(" + _dafny.String(data.AlgorithmSuiteId) + ", " + _dafny.String(data.EncryptedDataKeys) + ", " + _dafny.String(data.StoredEncryptionContext) + ", " + _dafny.String(data.EncryptionContext) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ParsedHeader) Equals(other ParsedHeader) bool {
	switch data1 := _this.Get_().(type) {
	case ParsedHeader_ParsedHeader:
		{
			data2, ok := other.Get_().(ParsedHeader_ParsedHeader)
			return ok && data1.AlgorithmSuiteId.Equals(data2.AlgorithmSuiteId) && data1.EncryptedDataKeys.Equals(data2.EncryptedDataKeys) && data1.StoredEncryptionContext.Equals(data2.StoredEncryptionContext) && data1.EncryptionContext.Equals(data2.EncryptionContext)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ParsedHeader) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ParsedHeader)
	return ok && _this.Equals(typed)
}

func Type_ParsedHeader_() _dafny.TypeDescriptor {
	return type_ParsedHeader_{}
}

type type_ParsedHeader_ struct {
}

func (_this type_ParsedHeader_) Default() interface{} {
	return Companion_ParsedHeader_.Default()
}

func (_this type_ParsedHeader_) String() string {
	return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.ParsedHeader"
}
func (_this ParsedHeader) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ParsedHeader{}

// End of datatype ParsedHeader

// Definition of datatype PathSegment
type PathSegment struct {
	Data_PathSegment_
}

func (_this PathSegment) Get_() Data_PathSegment_ {
	return _this.Data_PathSegment_
}

type Data_PathSegment_ interface {
	isPathSegment()
}

type CompanionStruct_PathSegment_ struct {
}

var Companion_PathSegment_ = CompanionStruct_PathSegment_{}

type PathSegment_member struct {
	Member StructureSegment
}

func (PathSegment_member) isPathSegment() {}

func (CompanionStruct_PathSegment_) Create_member_(Member StructureSegment) PathSegment {
	return PathSegment{PathSegment_member{Member}}
}

func (_this PathSegment) Is_member() bool {
	_, ok := _this.Get_().(PathSegment_member)
	return ok
}

func (CompanionStruct_PathSegment_) Default() PathSegment {
	return Companion_PathSegment_.Create_member_(Companion_StructureSegment_.Default())
}

func (_this PathSegment) Dtor_member() StructureSegment {
	return _this.Get_().(PathSegment_member).Member
}

func (_this PathSegment) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case PathSegment_member:
		{
			return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.PathSegment.member" + "(" + _dafny.String(data.Member) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this PathSegment) Equals(other PathSegment) bool {
	switch data1 := _this.Get_().(type) {
	case PathSegment_member:
		{
			data2, ok := other.Get_().(PathSegment_member)
			return ok && data1.Member.Equals(data2.Member)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this PathSegment) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(PathSegment)
	return ok && _this.Equals(typed)
}

func Type_PathSegment_() _dafny.TypeDescriptor {
	return type_PathSegment_{}
}

type type_PathSegment_ struct {
}

func (_this type_PathSegment_) Default() interface{} {
	return Companion_PathSegment_.Default()
}

func (_this type_PathSegment_) String() string {
	return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.PathSegment"
}
func (_this PathSegment) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = PathSegment{}

// End of datatype PathSegment

// Definition of datatype ResolveAuthActionsInput
type ResolveAuthActionsInput struct {
	Data_ResolveAuthActionsInput_
}

func (_this ResolveAuthActionsInput) Get_() Data_ResolveAuthActionsInput_ {
	return _this.Data_ResolveAuthActionsInput_
}

type Data_ResolveAuthActionsInput_ interface {
	isResolveAuthActionsInput()
}

type CompanionStruct_ResolveAuthActionsInput_ struct {
}

var Companion_ResolveAuthActionsInput_ = CompanionStruct_ResolveAuthActionsInput_{}

type ResolveAuthActionsInput_ResolveAuthActionsInput struct {
	TableName   _dafny.Sequence
	AuthActions _dafny.Sequence
	HeaderBytes _dafny.Sequence
}

func (ResolveAuthActionsInput_ResolveAuthActionsInput) isResolveAuthActionsInput() {}

func (CompanionStruct_ResolveAuthActionsInput_) Create_ResolveAuthActionsInput_(TableName _dafny.Sequence, AuthActions _dafny.Sequence, HeaderBytes _dafny.Sequence) ResolveAuthActionsInput {
	return ResolveAuthActionsInput{ResolveAuthActionsInput_ResolveAuthActionsInput{TableName, AuthActions, HeaderBytes}}
}

func (_this ResolveAuthActionsInput) Is_ResolveAuthActionsInput() bool {
	_, ok := _this.Get_().(ResolveAuthActionsInput_ResolveAuthActionsInput)
	return ok
}

func (CompanionStruct_ResolveAuthActionsInput_) Default() ResolveAuthActionsInput {
	return Companion_ResolveAuthActionsInput_.Create_ResolveAuthActionsInput_(_dafny.EmptySeq.SetString(), _dafny.EmptySeq, _dafny.EmptySeq)
}

func (_this ResolveAuthActionsInput) Dtor_tableName() _dafny.Sequence {
	return _this.Get_().(ResolveAuthActionsInput_ResolveAuthActionsInput).TableName
}

func (_this ResolveAuthActionsInput) Dtor_authActions() _dafny.Sequence {
	return _this.Get_().(ResolveAuthActionsInput_ResolveAuthActionsInput).AuthActions
}

func (_this ResolveAuthActionsInput) Dtor_headerBytes() _dafny.Sequence {
	return _this.Get_().(ResolveAuthActionsInput_ResolveAuthActionsInput).HeaderBytes
}

func (_this ResolveAuthActionsInput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ResolveAuthActionsInput_ResolveAuthActionsInput:
		{
			return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.ResolveAuthActionsInput.ResolveAuthActionsInput" + "(" + _dafny.String(data.TableName) + ", " + _dafny.String(data.AuthActions) + ", " + _dafny.String(data.HeaderBytes) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ResolveAuthActionsInput) Equals(other ResolveAuthActionsInput) bool {
	switch data1 := _this.Get_().(type) {
	case ResolveAuthActionsInput_ResolveAuthActionsInput:
		{
			data2, ok := other.Get_().(ResolveAuthActionsInput_ResolveAuthActionsInput)
			return ok && data1.TableName.Equals(data2.TableName) && data1.AuthActions.Equals(data2.AuthActions) && data1.HeaderBytes.Equals(data2.HeaderBytes)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ResolveAuthActionsInput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ResolveAuthActionsInput)
	return ok && _this.Equals(typed)
}

func Type_ResolveAuthActionsInput_() _dafny.TypeDescriptor {
	return type_ResolveAuthActionsInput_{}
}

type type_ResolveAuthActionsInput_ struct {
}

func (_this type_ResolveAuthActionsInput_) Default() interface{} {
	return Companion_ResolveAuthActionsInput_.Default()
}

func (_this type_ResolveAuthActionsInput_) String() string {
	return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.ResolveAuthActionsInput"
}
func (_this ResolveAuthActionsInput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ResolveAuthActionsInput{}

// End of datatype ResolveAuthActionsInput

// Definition of datatype ResolveAuthActionsOutput
type ResolveAuthActionsOutput struct {
	Data_ResolveAuthActionsOutput_
}

func (_this ResolveAuthActionsOutput) Get_() Data_ResolveAuthActionsOutput_ {
	return _this.Data_ResolveAuthActionsOutput_
}

type Data_ResolveAuthActionsOutput_ interface {
	isResolveAuthActionsOutput()
}

type CompanionStruct_ResolveAuthActionsOutput_ struct {
}

var Companion_ResolveAuthActionsOutput_ = CompanionStruct_ResolveAuthActionsOutput_{}

type ResolveAuthActionsOutput_ResolveAuthActionsOutput struct {
	CryptoActions _dafny.Sequence
}

func (ResolveAuthActionsOutput_ResolveAuthActionsOutput) isResolveAuthActionsOutput() {}

func (CompanionStruct_ResolveAuthActionsOutput_) Create_ResolveAuthActionsOutput_(CryptoActions _dafny.Sequence) ResolveAuthActionsOutput {
	return ResolveAuthActionsOutput{ResolveAuthActionsOutput_ResolveAuthActionsOutput{CryptoActions}}
}

func (_this ResolveAuthActionsOutput) Is_ResolveAuthActionsOutput() bool {
	_, ok := _this.Get_().(ResolveAuthActionsOutput_ResolveAuthActionsOutput)
	return ok
}

func (CompanionStruct_ResolveAuthActionsOutput_) Default() ResolveAuthActionsOutput {
	return Companion_ResolveAuthActionsOutput_.Create_ResolveAuthActionsOutput_(_dafny.EmptySeq)
}

func (_this ResolveAuthActionsOutput) Dtor_cryptoActions() _dafny.Sequence {
	return _this.Get_().(ResolveAuthActionsOutput_ResolveAuthActionsOutput).CryptoActions
}

func (_this ResolveAuthActionsOutput) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case ResolveAuthActionsOutput_ResolveAuthActionsOutput:
		{
			return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.ResolveAuthActionsOutput.ResolveAuthActionsOutput" + "(" + _dafny.String(data.CryptoActions) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this ResolveAuthActionsOutput) Equals(other ResolveAuthActionsOutput) bool {
	switch data1 := _this.Get_().(type) {
	case ResolveAuthActionsOutput_ResolveAuthActionsOutput:
		{
			data2, ok := other.Get_().(ResolveAuthActionsOutput_ResolveAuthActionsOutput)
			return ok && data1.CryptoActions.Equals(data2.CryptoActions)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this ResolveAuthActionsOutput) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(ResolveAuthActionsOutput)
	return ok && _this.Equals(typed)
}

func Type_ResolveAuthActionsOutput_() _dafny.TypeDescriptor {
	return type_ResolveAuthActionsOutput_{}
}

type type_ResolveAuthActionsOutput_ struct {
}

func (_this type_ResolveAuthActionsOutput_) Default() interface{} {
	return Companion_ResolveAuthActionsOutput_.Default()
}

func (_this type_ResolveAuthActionsOutput_) String() string {
	return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.ResolveAuthActionsOutput"
}
func (_this ResolveAuthActionsOutput) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = ResolveAuthActionsOutput{}

// End of datatype ResolveAuthActionsOutput

// Definition of datatype StructuredDataTerminal
type StructuredDataTerminal struct {
	Data_StructuredDataTerminal_
}

func (_this StructuredDataTerminal) Get_() Data_StructuredDataTerminal_ {
	return _this.Data_StructuredDataTerminal_
}

type Data_StructuredDataTerminal_ interface {
	isStructuredDataTerminal()
}

type CompanionStruct_StructuredDataTerminal_ struct {
}

var Companion_StructuredDataTerminal_ = CompanionStruct_StructuredDataTerminal_{}

type StructuredDataTerminal_StructuredDataTerminal struct {
	Value  _dafny.Sequence
	TypeId _dafny.Sequence
}

func (StructuredDataTerminal_StructuredDataTerminal) isStructuredDataTerminal() {}

func (CompanionStruct_StructuredDataTerminal_) Create_StructuredDataTerminal_(Value _dafny.Sequence, TypeId _dafny.Sequence) StructuredDataTerminal {
	return StructuredDataTerminal{StructuredDataTerminal_StructuredDataTerminal{Value, TypeId}}
}

func (_this StructuredDataTerminal) Is_StructuredDataTerminal() bool {
	_, ok := _this.Get_().(StructuredDataTerminal_StructuredDataTerminal)
	return ok
}

func (CompanionStruct_StructuredDataTerminal_) Default() StructuredDataTerminal {
	return Companion_StructuredDataTerminal_.Create_StructuredDataTerminal_(_dafny.EmptySeq, _dafny.EmptySeq)
}

func (_this StructuredDataTerminal) Dtor_value() _dafny.Sequence {
	return _this.Get_().(StructuredDataTerminal_StructuredDataTerminal).Value
}

func (_this StructuredDataTerminal) Dtor_typeId() _dafny.Sequence {
	return _this.Get_().(StructuredDataTerminal_StructuredDataTerminal).TypeId
}

func (_this StructuredDataTerminal) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case StructuredDataTerminal_StructuredDataTerminal:
		{
			return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal.StructuredDataTerminal" + "(" + _dafny.String(data.Value) + ", " + _dafny.String(data.TypeId) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this StructuredDataTerminal) Equals(other StructuredDataTerminal) bool {
	switch data1 := _this.Get_().(type) {
	case StructuredDataTerminal_StructuredDataTerminal:
		{
			data2, ok := other.Get_().(StructuredDataTerminal_StructuredDataTerminal)
			return ok && data1.Value.Equals(data2.Value) && data1.TypeId.Equals(data2.TypeId)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this StructuredDataTerminal) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(StructuredDataTerminal)
	return ok && _this.Equals(typed)
}

func Type_StructuredDataTerminal_() _dafny.TypeDescriptor {
	return type_StructuredDataTerminal_{}
}

type type_StructuredDataTerminal_ struct {
}

func (_this type_StructuredDataTerminal_) Default() interface{} {
	return Companion_StructuredDataTerminal_.Default()
}

func (_this type_StructuredDataTerminal_) String() string {
	return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredDataTerminal"
}
func (_this StructuredDataTerminal) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = StructuredDataTerminal{}

// End of datatype StructuredDataTerminal

// Definition of class IStructuredEncryptionClientCallHistory
type IStructuredEncryptionClientCallHistory struct {
	dummy byte
}

func New_IStructuredEncryptionClientCallHistory_() *IStructuredEncryptionClientCallHistory {
	_this := IStructuredEncryptionClientCallHistory{}

	return &_this
}

type CompanionStruct_IStructuredEncryptionClientCallHistory_ struct {
}

var Companion_IStructuredEncryptionClientCallHistory_ = CompanionStruct_IStructuredEncryptionClientCallHistory_{}

func (_this *IStructuredEncryptionClientCallHistory) Equals(other *IStructuredEncryptionClientCallHistory) bool {
	return _this == other
}

func (_this *IStructuredEncryptionClientCallHistory) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*IStructuredEncryptionClientCallHistory)
	return ok && _this.Equals(other)
}

func (*IStructuredEncryptionClientCallHistory) String() string {
	return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.IStructuredEncryptionClientCallHistory"
}

func Type_IStructuredEncryptionClientCallHistory_() _dafny.TypeDescriptor {
	return type_IStructuredEncryptionClientCallHistory_{}
}

type type_IStructuredEncryptionClientCallHistory_ struct {
}

func (_this type_IStructuredEncryptionClientCallHistory_) Default() interface{} {
	return (*IStructuredEncryptionClientCallHistory)(nil)
}

func (_this type_IStructuredEncryptionClientCallHistory_) String() string {
	return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.IStructuredEncryptionClientCallHistory"
}
func (_this *IStructuredEncryptionClientCallHistory) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &IStructuredEncryptionClientCallHistory{}

// End of class IStructuredEncryptionClientCallHistory

// Definition of trait IStructuredEncryptionClient
type IStructuredEncryptionClient interface {
	String() string
	EncryptStructure(input EncryptStructureInput) m_Wrappers.Result
	DecryptStructure(input DecryptStructureInput) m_Wrappers.Result
	EncryptPathStructure(input EncryptPathStructureInput) m_Wrappers.Result
	DecryptPathStructure(input DecryptPathStructureInput) m_Wrappers.Result
	ResolveAuthActions(input ResolveAuthActionsInput) m_Wrappers.Result
}
type CompanionStruct_IStructuredEncryptionClient_ struct {
	TraitID_ *_dafny.TraitID
}

var Companion_IStructuredEncryptionClient_ = CompanionStruct_IStructuredEncryptionClient_{
	TraitID_: &_dafny.TraitID{},
}

func (CompanionStruct_IStructuredEncryptionClient_) CastTo_(x interface{}) IStructuredEncryptionClient {
	var t IStructuredEncryptionClient
	t, _ = x.(IStructuredEncryptionClient)
	return t
}

// End of trait IStructuredEncryptionClient

// Definition of datatype StructuredEncryptionConfig
type StructuredEncryptionConfig struct {
	Data_StructuredEncryptionConfig_
}

func (_this StructuredEncryptionConfig) Get_() Data_StructuredEncryptionConfig_ {
	return _this.Data_StructuredEncryptionConfig_
}

type Data_StructuredEncryptionConfig_ interface {
	isStructuredEncryptionConfig()
}

type CompanionStruct_StructuredEncryptionConfig_ struct {
}

var Companion_StructuredEncryptionConfig_ = CompanionStruct_StructuredEncryptionConfig_{}

type StructuredEncryptionConfig_StructuredEncryptionConfig struct {
}

func (StructuredEncryptionConfig_StructuredEncryptionConfig) isStructuredEncryptionConfig() {}

func (CompanionStruct_StructuredEncryptionConfig_) Create_StructuredEncryptionConfig_() StructuredEncryptionConfig {
	return StructuredEncryptionConfig{StructuredEncryptionConfig_StructuredEncryptionConfig{}}
}

func (_this StructuredEncryptionConfig) Is_StructuredEncryptionConfig() bool {
	_, ok := _this.Get_().(StructuredEncryptionConfig_StructuredEncryptionConfig)
	return ok
}

func (CompanionStruct_StructuredEncryptionConfig_) Default() StructuredEncryptionConfig {
	return Companion_StructuredEncryptionConfig_.Create_StructuredEncryptionConfig_()
}

func (_ CompanionStruct_StructuredEncryptionConfig_) AllSingletonConstructors() _dafny.Iterator {
	i := -1
	return func() (interface{}, bool) {
		i++
		switch i {
		case 0:
			return Companion_StructuredEncryptionConfig_.Create_StructuredEncryptionConfig_(), true
		default:
			return StructuredEncryptionConfig{}, false
		}
	}
}

func (_this StructuredEncryptionConfig) String() string {
	switch _this.Get_().(type) {
	case nil:
		return "null"
	case StructuredEncryptionConfig_StructuredEncryptionConfig:
		{
			return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredEncryptionConfig.StructuredEncryptionConfig"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this StructuredEncryptionConfig) Equals(other StructuredEncryptionConfig) bool {
	switch _this.Get_().(type) {
	case StructuredEncryptionConfig_StructuredEncryptionConfig:
		{
			_, ok := other.Get_().(StructuredEncryptionConfig_StructuredEncryptionConfig)
			return ok
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this StructuredEncryptionConfig) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(StructuredEncryptionConfig)
	return ok && _this.Equals(typed)
}

func Type_StructuredEncryptionConfig_() _dafny.TypeDescriptor {
	return type_StructuredEncryptionConfig_{}
}

type type_StructuredEncryptionConfig_ struct {
}

func (_this type_StructuredEncryptionConfig_) Default() interface{} {
	return Companion_StructuredEncryptionConfig_.Default()
}

func (_this type_StructuredEncryptionConfig_) String() string {
	return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructuredEncryptionConfig"
}
func (_this StructuredEncryptionConfig) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = StructuredEncryptionConfig{}

// End of datatype StructuredEncryptionConfig

// Definition of datatype StructureSegment
type StructureSegment struct {
	Data_StructureSegment_
}

func (_this StructureSegment) Get_() Data_StructureSegment_ {
	return _this.Data_StructureSegment_
}

type Data_StructureSegment_ interface {
	isStructureSegment()
}

type CompanionStruct_StructureSegment_ struct {
}

var Companion_StructureSegment_ = CompanionStruct_StructureSegment_{}

type StructureSegment_StructureSegment struct {
	Key _dafny.Sequence
}

func (StructureSegment_StructureSegment) isStructureSegment() {}

func (CompanionStruct_StructureSegment_) Create_StructureSegment_(Key _dafny.Sequence) StructureSegment {
	return StructureSegment{StructureSegment_StructureSegment{Key}}
}

func (_this StructureSegment) Is_StructureSegment() bool {
	_, ok := _this.Get_().(StructureSegment_StructureSegment)
	return ok
}

func (CompanionStruct_StructureSegment_) Default() StructureSegment {
	return Companion_StructureSegment_.Create_StructureSegment_(_dafny.EmptySeq.SetString())
}

func (_this StructureSegment) Dtor_key() _dafny.Sequence {
	return _this.Get_().(StructureSegment_StructureSegment).Key
}

func (_this StructureSegment) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case StructureSegment_StructureSegment:
		{
			return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructureSegment.StructureSegment" + "(" + _dafny.String(data.Key) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this StructureSegment) Equals(other StructureSegment) bool {
	switch data1 := _this.Get_().(type) {
	case StructureSegment_StructureSegment:
		{
			data2, ok := other.Get_().(StructureSegment_StructureSegment)
			return ok && data1.Key.Equals(data2.Key)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this StructureSegment) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(StructureSegment)
	return ok && _this.Equals(typed)
}

func Type_StructureSegment_() _dafny.TypeDescriptor {
	return type_StructureSegment_{}
}

type type_StructureSegment_ struct {
}

func (_this type_StructureSegment_) Default() interface{} {
	return Companion_StructureSegment_.Default()
}

func (_this type_StructureSegment_) String() string {
	return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.StructureSegment"
}
func (_this StructureSegment) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = StructureSegment{}

// End of datatype StructureSegment

// Definition of class TerminalTypeId
type TerminalTypeId struct {
}

func New_TerminalTypeId_() *TerminalTypeId {
	_this := TerminalTypeId{}

	return &_this
}

type CompanionStruct_TerminalTypeId_ struct {
}

var Companion_TerminalTypeId_ = CompanionStruct_TerminalTypeId_{}

func (*TerminalTypeId) String() string {
	return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.TerminalTypeId"
}

// End of class TerminalTypeId

func Type_TerminalTypeId_() _dafny.TypeDescriptor {
	return type_TerminalTypeId_{}
}

type type_TerminalTypeId_ struct {
}

func (_this type_TerminalTypeId_) Default() interface{} {
	return _dafny.EmptySeq
}

func (_this type_TerminalTypeId_) String() string {
	return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.TerminalTypeId"
}
func (_this *CompanionStruct_TerminalTypeId_) Is_(__source _dafny.Sequence) bool {
	var _0_x _dafny.Sequence = (__source)
	_ = _0_x
	return Companion_Default___.IsValid__TerminalTypeId(_0_x)
}

// Definition of datatype Error
type Error struct {
	Data_Error_
}

func (_this Error) Get_() Data_Error_ {
	return _this.Data_Error_
}

type Data_Error_ interface {
	isError()
}

type CompanionStruct_Error_ struct {
}

var Companion_Error_ = CompanionStruct_Error_{}

type Error_StructuredEncryptionException struct {
	Message _dafny.Sequence
}

func (Error_StructuredEncryptionException) isError() {}

func (CompanionStruct_Error_) Create_StructuredEncryptionException_(Message _dafny.Sequence) Error {
	return Error{Error_StructuredEncryptionException{Message}}
}

func (_this Error) Is_StructuredEncryptionException() bool {
	_, ok := _this.Get_().(Error_StructuredEncryptionException)
	return ok
}

type Error_AwsCryptographyMaterialProviders struct {
	AwsCryptographyMaterialProviders m_AwsCryptographyMaterialProvidersTypes.Error
}

func (Error_AwsCryptographyMaterialProviders) isError() {}

func (CompanionStruct_Error_) Create_AwsCryptographyMaterialProviders_(AwsCryptographyMaterialProviders m_AwsCryptographyMaterialProvidersTypes.Error) Error {
	return Error{Error_AwsCryptographyMaterialProviders{AwsCryptographyMaterialProviders}}
}

func (_this Error) Is_AwsCryptographyMaterialProviders() bool {
	_, ok := _this.Get_().(Error_AwsCryptographyMaterialProviders)
	return ok
}

type Error_AwsCryptographyPrimitives struct {
	AwsCryptographyPrimitives m_AwsCryptographyPrimitivesTypes.Error
}

func (Error_AwsCryptographyPrimitives) isError() {}

func (CompanionStruct_Error_) Create_AwsCryptographyPrimitives_(AwsCryptographyPrimitives m_AwsCryptographyPrimitivesTypes.Error) Error {
	return Error{Error_AwsCryptographyPrimitives{AwsCryptographyPrimitives}}
}

func (_this Error) Is_AwsCryptographyPrimitives() bool {
	_, ok := _this.Get_().(Error_AwsCryptographyPrimitives)
	return ok
}

type Error_CollectionOfErrors struct {
	List    _dafny.Sequence
	Message _dafny.Sequence
}

func (Error_CollectionOfErrors) isError() {}

func (CompanionStruct_Error_) Create_CollectionOfErrors_(List _dafny.Sequence, Message _dafny.Sequence) Error {
	return Error{Error_CollectionOfErrors{List, Message}}
}

func (_this Error) Is_CollectionOfErrors() bool {
	_, ok := _this.Get_().(Error_CollectionOfErrors)
	return ok
}

type Error_Opaque struct {
	Obj interface{}
}

func (Error_Opaque) isError() {}

func (CompanionStruct_Error_) Create_Opaque_(Obj interface{}) Error {
	return Error{Error_Opaque{Obj}}
}

func (_this Error) Is_Opaque() bool {
	_, ok := _this.Get_().(Error_Opaque)
	return ok
}

type Error_OpaqueWithText struct {
	Obj        interface{}
	ObjMessage _dafny.Sequence
}

func (Error_OpaqueWithText) isError() {}

func (CompanionStruct_Error_) Create_OpaqueWithText_(Obj interface{}, ObjMessage _dafny.Sequence) Error {
	return Error{Error_OpaqueWithText{Obj, ObjMessage}}
}

func (_this Error) Is_OpaqueWithText() bool {
	_, ok := _this.Get_().(Error_OpaqueWithText)
	return ok
}

func (CompanionStruct_Error_) Default() Error {
	return Companion_Error_.Create_StructuredEncryptionException_(_dafny.EmptySeq.SetString())
}

func (_this Error) Dtor_message() _dafny.Sequence {
	switch data := _this.Get_().(type) {
	case Error_StructuredEncryptionException:
		return data.Message
	default:
		return data.(Error_CollectionOfErrors).Message
	}
}

func (_this Error) Dtor_AwsCryptographyMaterialProviders() m_AwsCryptographyMaterialProvidersTypes.Error {
	return _this.Get_().(Error_AwsCryptographyMaterialProviders).AwsCryptographyMaterialProviders
}

func (_this Error) Dtor_AwsCryptographyPrimitives() m_AwsCryptographyPrimitivesTypes.Error {
	return _this.Get_().(Error_AwsCryptographyPrimitives).AwsCryptographyPrimitives
}

func (_this Error) Dtor_list() _dafny.Sequence {
	return _this.Get_().(Error_CollectionOfErrors).List
}

func (_this Error) Dtor_obj() interface{} {
	switch data := _this.Get_().(type) {
	case Error_Opaque:
		return data.Obj
	default:
		return data.(Error_OpaqueWithText).Obj
	}
}

func (_this Error) Dtor_objMessage() _dafny.Sequence {
	return _this.Get_().(Error_OpaqueWithText).ObjMessage
}

func (_this Error) String() string {
	switch data := _this.Get_().(type) {
	case nil:
		return "null"
	case Error_StructuredEncryptionException:
		{
			return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error.StructuredEncryptionException" + "(" + _dafny.String(data.Message) + ")"
		}
	case Error_AwsCryptographyMaterialProviders:
		{
			return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error.AwsCryptographyMaterialProviders" + "(" + _dafny.String(data.AwsCryptographyMaterialProviders) + ")"
		}
	case Error_AwsCryptographyPrimitives:
		{
			return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error.AwsCryptographyPrimitives" + "(" + _dafny.String(data.AwsCryptographyPrimitives) + ")"
		}
	case Error_CollectionOfErrors:
		{
			return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error.CollectionOfErrors" + "(" + _dafny.String(data.List) + ", " + _dafny.String(data.Message) + ")"
		}
	case Error_Opaque:
		{
			return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error.Opaque" + "(" + _dafny.String(data.Obj) + ")"
		}
	case Error_OpaqueWithText:
		{
			return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error.OpaqueWithText" + "(" + _dafny.String(data.Obj) + ", " + _dafny.String(data.ObjMessage) + ")"
		}
	default:
		{
			return "<unexpected>"
		}
	}
}

func (_this Error) Equals(other Error) bool {
	switch data1 := _this.Get_().(type) {
	case Error_StructuredEncryptionException:
		{
			data2, ok := other.Get_().(Error_StructuredEncryptionException)
			return ok && data1.Message.Equals(data2.Message)
		}
	case Error_AwsCryptographyMaterialProviders:
		{
			data2, ok := other.Get_().(Error_AwsCryptographyMaterialProviders)
			return ok && data1.AwsCryptographyMaterialProviders.Equals(data2.AwsCryptographyMaterialProviders)
		}
	case Error_AwsCryptographyPrimitives:
		{
			data2, ok := other.Get_().(Error_AwsCryptographyPrimitives)
			return ok && data1.AwsCryptographyPrimitives.Equals(data2.AwsCryptographyPrimitives)
		}
	case Error_CollectionOfErrors:
		{
			data2, ok := other.Get_().(Error_CollectionOfErrors)
			return ok && data1.List.Equals(data2.List) && data1.Message.Equals(data2.Message)
		}
	case Error_Opaque:
		{
			data2, ok := other.Get_().(Error_Opaque)
			return ok && _dafny.AreEqual(data1.Obj, data2.Obj)
		}
	case Error_OpaqueWithText:
		{
			data2, ok := other.Get_().(Error_OpaqueWithText)
			return ok && _dafny.AreEqual(data1.Obj, data2.Obj) && data1.ObjMessage.Equals(data2.ObjMessage)
		}
	default:
		{
			return false // unexpected
		}
	}
}

func (_this Error) EqualsGeneric(other interface{}) bool {
	typed, ok := other.(Error)
	return ok && _this.Equals(typed)
}

func Type_Error_() _dafny.TypeDescriptor {
	return type_Error_{}
}

type type_Error_ struct {
}

func (_this type_Error_) Default() interface{} {
	return Companion_Error_.Default()
}

func (_this type_Error_) String() string {
	return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.Error"
}
func (_this Error) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = Error{}

// End of datatype Error

// Definition of class OpaqueError
type OpaqueError struct {
}

func New_OpaqueError_() *OpaqueError {
	_this := OpaqueError{}

	return &_this
}

type CompanionStruct_OpaqueError_ struct {
}

var Companion_OpaqueError_ = CompanionStruct_OpaqueError_{}

func (*OpaqueError) String() string {
	return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.OpaqueError"
}

// End of class OpaqueError

func Type_OpaqueError_() _dafny.TypeDescriptor {
	return type_OpaqueError_{}
}

type type_OpaqueError_ struct {
}

func (_this type_OpaqueError_) Default() interface{} {
	return Companion_Error_.Default()
}

func (_this type_OpaqueError_) String() string {
	return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.OpaqueError"
}
func (_this *CompanionStruct_OpaqueError_) Is_(__source Error) bool {
	var _1_e Error = (__source)
	_ = _1_e
	return ((_1_e).Is_Opaque()) || ((_1_e).Is_OpaqueWithText())
}

// Definition of class DummySubsetType
type DummySubsetType struct {
}

func New_DummySubsetType_() *DummySubsetType {
	_this := DummySubsetType{}

	return &_this
}

type CompanionStruct_DummySubsetType_ struct {
}

var Companion_DummySubsetType_ = CompanionStruct_DummySubsetType_{}

func (*DummySubsetType) String() string {
	return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.DummySubsetType"
}
func (_this *CompanionStruct_DummySubsetType_) Witness() _dafny.Int {
	return _dafny.One
}

// End of class DummySubsetType

func Type_DummySubsetType_() _dafny.TypeDescriptor {
	return type_DummySubsetType_{}
}

type type_DummySubsetType_ struct {
}

func (_this type_DummySubsetType_) Default() interface{} {
	return Companion_DummySubsetType_.Witness()
}

func (_this type_DummySubsetType_) String() string {
	return "AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes.DummySubsetType"
}
func (_this *CompanionStruct_DummySubsetType_) Is_(__source _dafny.Int) bool {
	var _2_x _dafny.Int = (__source)
	_ = _2_x
	return Companion_Default___.IsDummySubsetType(_2_x)
}
