// Package GetKeys
// Dafny module GetKeys compiled into Go

package GetKeys

import (
	os "os"

	m_ComAmazonawsDynamodbTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/dynamodb/ComAmazonawsDynamodbTypes"
	m_ComAmazonawsKmsTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/kms/ComAmazonawsKmsTypes"
	m_AwsArnParsing "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsArnParsing"
	m_AwsCryptographyKeyStoreTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsCryptographyKeyStoreTypes"
	m_AwsCryptographyMaterialProvidersTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsCryptographyMaterialProvidersTypes"
	m_AwsKmsMrkMatchForDecrypt "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkMatchForDecrypt"
	m_AwsKmsUtils "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsUtils"
	m_CreateKeyStoreTable "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CreateKeyStoreTable"
	m_CreateKeys "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/CreateKeys"
	m_DDBKeystoreOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/DDBKeystoreOperations"
	m_KMSKeystoreOperations "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/KMSKeystoreOperations"
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
	return "GetKeys.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) GetActiveKeyAndUnwrap(input m_AwsCryptographyKeyStoreTypes.GetActiveBranchKeyInput, tableName _dafny.Sequence, logicalKeyStoreName _dafny.Sequence, kmsConfiguration m_AwsCryptographyKeyStoreTypes.KMSConfiguration, grantTokens _dafny.Sequence, kmsClient m_ComAmazonawsKmsTypes.IKMSClient, ddbClient m_ComAmazonawsDynamodbTypes.IDynamoDBClient) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyKeyStoreTypes.Companion_GetActiveBranchKeyOutput_.Default())
	_ = output
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _0_valueOrError0
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_DDBKeystoreOperations.Companion_Default___.GetActiveBranchKeyItem((input).Dtor_branchKeyIdentifier(), tableName, ddbClient)
	_0_valueOrError0 = _out0
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_branchKeyItem _dafny.Map
	_ = _1_branchKeyItem
	_1_branchKeyItem = (_0_valueOrError0).Extract().(_dafny.Map)
	var _2_encryptionContext _dafny.Map
	_ = _2_encryptionContext
	_2_encryptionContext = m_Structure.Companion_Default___.ToBranchKeyContext(_1_branchKeyItem, logicalKeyStoreName)
	var _3_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _3_valueOrError1
	_3_valueOrError1 = m_Wrappers.Companion_Default___.Need(m_KmsArn.Companion_Default___.ValidKmsArn_q((_2_encryptionContext).Get(m_Structure.Companion_Default___.KMS__FIELD()).(_dafny.Sequence)), m_AwsCryptographyKeyStoreTypes.Companion_Error_.Create_KeyStoreException_(m_KeyStoreErrorMessages.Companion_Default___.RETRIEVED__KEYSTORE__ITEM__INVALID__KMS__ARN()))
	if (_3_valueOrError1).IsFailure() {
		output = (_3_valueOrError1).PropagateFailure()
		return output
	}
	var _4_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _4_valueOrError2
	_4_valueOrError2 = m_Wrappers.Companion_Default___.Need(m_KMSKeystoreOperations.Companion_Default___.AttemptKmsOperation_q(kmsConfiguration, _2_encryptionContext), m_AwsCryptographyKeyStoreTypes.Companion_Error_.Create_KeyStoreException_(m_KeyStoreErrorMessages.Companion_Default___.GET__KEY__ARN__DISAGREEMENT()))
	if (_4_valueOrError2).IsFailure() {
		output = (_4_valueOrError2).PropagateFailure()
		return output
	}
	var _5_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsKmsTypes.Companion_DecryptResponse_.Default())
	_ = _5_valueOrError3
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_KMSKeystoreOperations.Companion_Default___.DecryptKey(_2_encryptionContext, _1_branchKeyItem, kmsConfiguration, grantTokens, kmsClient)
	_5_valueOrError3 = _out1
	if (_5_valueOrError3).IsFailure() {
		output = (_5_valueOrError3).PropagateFailure()
		return output
	}
	var _6_branchKey m_ComAmazonawsKmsTypes.DecryptResponse
	_ = _6_branchKey
	_6_branchKey = (_5_valueOrError3).Extract().(m_ComAmazonawsKmsTypes.DecryptResponse)
	var _7_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyKeyStoreTypes.Companion_BranchKeyMaterials_.Default())
	_ = _7_valueOrError4
	_7_valueOrError4 = m_Structure.Companion_Default___.ToBranchKeyMaterials(_2_encryptionContext, ((_6_branchKey).Dtor_Plaintext()).Dtor_value().(_dafny.Sequence))
	if (_7_valueOrError4).IsFailure() {
		output = (_7_valueOrError4).PropagateFailure()
		return output
	}
	var _8_branchKeyMaterials m_AwsCryptographyKeyStoreTypes.BranchKeyMaterials
	_ = _8_branchKeyMaterials
	_8_branchKeyMaterials = (_7_valueOrError4).Extract().(m_AwsCryptographyKeyStoreTypes.BranchKeyMaterials)
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyKeyStoreTypes.Companion_GetActiveBranchKeyOutput_.Create_GetActiveBranchKeyOutput_(_8_branchKeyMaterials))
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetBranchKeyVersion(input m_AwsCryptographyKeyStoreTypes.GetBranchKeyVersionInput, tableName _dafny.Sequence, logicalKeyStoreName _dafny.Sequence, kmsConfiguration m_AwsCryptographyKeyStoreTypes.KMSConfiguration, grantTokens _dafny.Sequence, kmsClient m_ComAmazonawsKmsTypes.IKMSClient, ddbClient m_ComAmazonawsDynamodbTypes.IDynamoDBClient) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyKeyStoreTypes.Companion_GetBranchKeyVersionOutput_.Default())
	_ = output
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _0_valueOrError0
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_DDBKeystoreOperations.Companion_Default___.GetVersionBranchKeyItem((input).Dtor_branchKeyIdentifier(), (input).Dtor_branchKeyVersion(), tableName, ddbClient)
	_0_valueOrError0 = _out0
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_branchKeyItem _dafny.Map
	_ = _1_branchKeyItem
	_1_branchKeyItem = (_0_valueOrError0).Extract().(_dafny.Map)
	var _2_encryptionContext _dafny.Map
	_ = _2_encryptionContext
	_2_encryptionContext = m_Structure.Companion_Default___.ToBranchKeyContext(_1_branchKeyItem, logicalKeyStoreName)
	var _3_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _3_valueOrError1
	_3_valueOrError1 = m_Wrappers.Companion_Default___.Need(m_KmsArn.Companion_Default___.ValidKmsArn_q((_2_encryptionContext).Get(m_Structure.Companion_Default___.KMS__FIELD()).(_dafny.Sequence)), m_AwsCryptographyKeyStoreTypes.Companion_Error_.Create_KeyStoreException_(m_KeyStoreErrorMessages.Companion_Default___.RETRIEVED__KEYSTORE__ITEM__INVALID__KMS__ARN()))
	if (_3_valueOrError1).IsFailure() {
		output = (_3_valueOrError1).PropagateFailure()
		return output
	}
	var _4_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _4_valueOrError2
	_4_valueOrError2 = m_Wrappers.Companion_Default___.Need(m_KMSKeystoreOperations.Companion_Default___.AttemptKmsOperation_q(kmsConfiguration, _2_encryptionContext), m_AwsCryptographyKeyStoreTypes.Companion_Error_.Create_KeyStoreException_(_dafny.SeqOfString("AWS KMS Key ARN does not match configured value")))
	if (_4_valueOrError2).IsFailure() {
		output = (_4_valueOrError2).PropagateFailure()
		return output
	}
	var _5_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsKmsTypes.Companion_DecryptResponse_.Default())
	_ = _5_valueOrError3
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_KMSKeystoreOperations.Companion_Default___.DecryptKey(_2_encryptionContext, _1_branchKeyItem, kmsConfiguration, grantTokens, kmsClient)
	_5_valueOrError3 = _out1
	if (_5_valueOrError3).IsFailure() {
		output = (_5_valueOrError3).PropagateFailure()
		return output
	}
	var _6_branchKey m_ComAmazonawsKmsTypes.DecryptResponse
	_ = _6_branchKey
	_6_branchKey = (_5_valueOrError3).Extract().(m_ComAmazonawsKmsTypes.DecryptResponse)
	var _7_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyKeyStoreTypes.Companion_BranchKeyMaterials_.Default())
	_ = _7_valueOrError4
	_7_valueOrError4 = m_Structure.Companion_Default___.ToBranchKeyMaterials(_2_encryptionContext, ((_6_branchKey).Dtor_Plaintext()).Dtor_value().(_dafny.Sequence))
	if (_7_valueOrError4).IsFailure() {
		output = (_7_valueOrError4).PropagateFailure()
		return output
	}
	var _8_branchKeyMaterials m_AwsCryptographyKeyStoreTypes.BranchKeyMaterials
	_ = _8_branchKeyMaterials
	_8_branchKeyMaterials = (_7_valueOrError4).Extract().(m_AwsCryptographyKeyStoreTypes.BranchKeyMaterials)
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyKeyStoreTypes.Companion_GetBranchKeyVersionOutput_.Create_GetBranchKeyVersionOutput_(_8_branchKeyMaterials))
	return output
	return output
}
func (_static *CompanionStruct_Default___) GetBeaconKeyAndUnwrap(input m_AwsCryptographyKeyStoreTypes.GetBeaconKeyInput, tableName _dafny.Sequence, logicalKeyStoreName _dafny.Sequence, kmsConfiguration m_AwsCryptographyKeyStoreTypes.KMSConfiguration, grantTokens _dafny.Sequence, kmsClient m_ComAmazonawsKmsTypes.IKMSClient, ddbClient m_ComAmazonawsDynamodbTypes.IDynamoDBClient) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyKeyStoreTypes.Companion_GetBeaconKeyOutput_.Default())
	_ = output
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _0_valueOrError0
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_DDBKeystoreOperations.Companion_Default___.GetBeaconKeyItem((input).Dtor_branchKeyIdentifier(), tableName, ddbClient)
	_0_valueOrError0 = _out0
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_branchKeyItem _dafny.Map
	_ = _1_branchKeyItem
	_1_branchKeyItem = (_0_valueOrError0).Extract().(_dafny.Map)
	var _2_encryptionContext _dafny.Map
	_ = _2_encryptionContext
	_2_encryptionContext = m_Structure.Companion_Default___.ToBranchKeyContext(_1_branchKeyItem, logicalKeyStoreName)
	var _3_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _3_valueOrError1
	_3_valueOrError1 = m_Wrappers.Companion_Default___.Need(m_KmsArn.Companion_Default___.ValidKmsArn_q((_2_encryptionContext).Get(m_Structure.Companion_Default___.KMS__FIELD()).(_dafny.Sequence)), m_AwsCryptographyKeyStoreTypes.Companion_Error_.Create_KeyStoreException_(m_KeyStoreErrorMessages.Companion_Default___.RETRIEVED__KEYSTORE__ITEM__INVALID__KMS__ARN()))
	if (_3_valueOrError1).IsFailure() {
		output = (_3_valueOrError1).PropagateFailure()
		return output
	}
	var _4_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _4_valueOrError2
	_4_valueOrError2 = m_Wrappers.Companion_Default___.Need(m_KMSKeystoreOperations.Companion_Default___.AttemptKmsOperation_q(kmsConfiguration, _2_encryptionContext), m_AwsCryptographyKeyStoreTypes.Companion_Error_.Create_KeyStoreException_(_dafny.SeqOfString("AWS KMS Key ARN does not match configured value")))
	if (_4_valueOrError2).IsFailure() {
		output = (_4_valueOrError2).PropagateFailure()
		return output
	}
	var _5_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsKmsTypes.Companion_DecryptResponse_.Default())
	_ = _5_valueOrError3
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_KMSKeystoreOperations.Companion_Default___.DecryptKey(_2_encryptionContext, _1_branchKeyItem, kmsConfiguration, grantTokens, kmsClient)
	_5_valueOrError3 = _out1
	if (_5_valueOrError3).IsFailure() {
		output = (_5_valueOrError3).PropagateFailure()
		return output
	}
	var _6_branchKey m_ComAmazonawsKmsTypes.DecryptResponse
	_ = _6_branchKey
	_6_branchKey = (_5_valueOrError3).Extract().(m_ComAmazonawsKmsTypes.DecryptResponse)
	var _7_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyKeyStoreTypes.Companion_BeaconKeyMaterials_.Default())
	_ = _7_valueOrError4
	_7_valueOrError4 = m_Structure.Companion_Default___.ToBeaconKeyMaterials(_2_encryptionContext, ((_6_branchKey).Dtor_Plaintext()).Dtor_value().(_dafny.Sequence))
	if (_7_valueOrError4).IsFailure() {
		output = (_7_valueOrError4).PropagateFailure()
		return output
	}
	var _8_branchKeyMaterials m_AwsCryptographyKeyStoreTypes.BeaconKeyMaterials
	_ = _8_branchKeyMaterials
	_8_branchKeyMaterials = (_7_valueOrError4).Extract().(m_AwsCryptographyKeyStoreTypes.BeaconKeyMaterials)
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyKeyStoreTypes.Companion_GetBeaconKeyOutput_.Create_GetBeaconKeyOutput_(_8_branchKeyMaterials))
	return output
	return output
}

// End of class Default__
