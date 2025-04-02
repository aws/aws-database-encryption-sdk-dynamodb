// Package CreateKeys
// Dafny module CreateKeys compiled into Go

package CreateKeys

import (
	os "os"

	m_ComAmazonawsDynamodbTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/dynamodb/ComAmazonawsDynamodbTypes"
	m_ComAmazonawsKmsTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/kms/ComAmazonawsKmsTypes"
	m_AwsArnParsing "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsArnParsing"
	m_AwsCryptographyKeyStoreTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsCryptographyKeyStoreTypes"
	m_AwsCryptographyMaterialProvidersTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsCryptographyMaterialProvidersTypes"
	m_AwsKmsMrkMatchForDecrypt "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsMrkMatchForDecrypt"
	m_AwsKmsUtils "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/AwsKmsUtils"
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
	return "CreateKeys.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) CreateBranchAndBeaconKeys(branchKeyIdentifier _dafny.Sequence, customEncryptionContext _dafny.Map, timestamp _dafny.Sequence, branchKeyVersion _dafny.Sequence, ddbTableName _dafny.Sequence, logicalKeyStoreName _dafny.Sequence, kmsConfiguration m_AwsCryptographyKeyStoreTypes.KMSConfiguration, grantTokens _dafny.Sequence, kmsClient m_ComAmazonawsKmsTypes.IKMSClient, ddbClient m_ComAmazonawsDynamodbTypes.IDynamoDBClient) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyKeyStoreTypes.Companion_CreateKeyOutput_.Default())
	_ = output
	var _0_decryptOnlyEncryptionContext _dafny.Map
	_ = _0_decryptOnlyEncryptionContext
	_0_decryptOnlyEncryptionContext = m_Structure.Companion_Default___.DecryptOnlyBranchKeyEncryptionContext(branchKeyIdentifier, branchKeyVersion, timestamp, logicalKeyStoreName, m_KMSKeystoreOperations.Companion_Default___.GetKeyId(kmsConfiguration), customEncryptionContext)
	var _1_activeEncryptionContext _dafny.Map
	_ = _1_activeEncryptionContext
	_1_activeEncryptionContext = m_Structure.Companion_Default___.ActiveBranchKeyEncryptionContext(_0_decryptOnlyEncryptionContext)
	var _2_beaconEncryptionContext _dafny.Map
	_ = _2_beaconEncryptionContext
	_2_beaconEncryptionContext = m_Structure.Companion_Default___.BeaconKeyEncryptionContext(_0_decryptOnlyEncryptionContext)
	var _3_valueOrError0 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _3_valueOrError0
	_3_valueOrError0 = m_Wrappers.Companion_Default___.Need(m_KMSKeystoreOperations.Companion_Default___.AttemptKmsOperation_q(kmsConfiguration, _0_decryptOnlyEncryptionContext), m_AwsCryptographyKeyStoreTypes.Companion_Error_.Create_KeyStoreException_(_dafny.SeqOfString("Invalid KMS Key ARN configured for GenerateDataKeyWithoutPlaintext in CreateBranchAndBeaconKeys.")))
	if (_3_valueOrError0).IsFailure() {
		output = (_3_valueOrError0).PropagateFailure()
		return output
	}
	var _4_valueOrError1 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsKmsTypes.Companion_GenerateDataKeyWithoutPlaintextResponse_.Default())
	_ = _4_valueOrError1
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_KMSKeystoreOperations.Companion_Default___.GenerateKey(_0_decryptOnlyEncryptionContext, kmsConfiguration, grantTokens, kmsClient)
	_4_valueOrError1 = _out0
	if (_4_valueOrError1).IsFailure() {
		output = (_4_valueOrError1).PropagateFailure()
		return output
	}
	var _5_wrappedDecryptOnlyBranchKey m_ComAmazonawsKmsTypes.GenerateDataKeyWithoutPlaintextResponse
	_ = _5_wrappedDecryptOnlyBranchKey
	_5_wrappedDecryptOnlyBranchKey = (_4_valueOrError1).Extract().(m_ComAmazonawsKmsTypes.GenerateDataKeyWithoutPlaintextResponse)
	var _6_valueOrError2 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _6_valueOrError2
	_6_valueOrError2 = m_Wrappers.Companion_Default___.Need(m_KMSKeystoreOperations.Companion_Default___.AttemptKmsOperation_q(kmsConfiguration, _1_activeEncryptionContext), m_AwsCryptographyKeyStoreTypes.Companion_Error_.Create_KeyStoreException_(_dafny.SeqOfString("Invalid KMS Key ARN configured for ReEncrypt in CreateBranchAndBeaconKeys.")))
	if (_6_valueOrError2).IsFailure() {
		output = (_6_valueOrError2).PropagateFailure()
		return output
	}
	var _7_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsKmsTypes.Companion_ReEncryptResponse_.Default())
	_ = _7_valueOrError3
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_KMSKeystoreOperations.Companion_Default___.ReEncryptKey(((_5_wrappedDecryptOnlyBranchKey).Dtor_CiphertextBlob()).Dtor_value().(_dafny.Sequence), _0_decryptOnlyEncryptionContext, _1_activeEncryptionContext, kmsConfiguration, grantTokens, kmsClient)
	_7_valueOrError3 = _out1
	if (_7_valueOrError3).IsFailure() {
		output = (_7_valueOrError3).PropagateFailure()
		return output
	}
	var _8_wrappedActiveBranchKey m_ComAmazonawsKmsTypes.ReEncryptResponse
	_ = _8_wrappedActiveBranchKey
	_8_wrappedActiveBranchKey = (_7_valueOrError3).Extract().(m_ComAmazonawsKmsTypes.ReEncryptResponse)
	var _9_valueOrError4 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _9_valueOrError4
	_9_valueOrError4 = m_Wrappers.Companion_Default___.Need(m_KMSKeystoreOperations.Companion_Default___.AttemptKmsOperation_q(kmsConfiguration, _2_beaconEncryptionContext), m_AwsCryptographyKeyStoreTypes.Companion_Error_.Create_KeyStoreException_(_dafny.SeqOfString("Invalid KMS Key ARN configured for GenerateDataKeyWithoutPlaintext(beacon key) in CreateBranchAndBeaconKeys.")))
	if (_9_valueOrError4).IsFailure() {
		output = (_9_valueOrError4).PropagateFailure()
		return output
	}
	var _10_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsKmsTypes.Companion_GenerateDataKeyWithoutPlaintextResponse_.Default())
	_ = _10_valueOrError5
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_KMSKeystoreOperations.Companion_Default___.GenerateKey(_2_beaconEncryptionContext, kmsConfiguration, grantTokens, kmsClient)
	_10_valueOrError5 = _out2
	if (_10_valueOrError5).IsFailure() {
		output = (_10_valueOrError5).PropagateFailure()
		return output
	}
	var _11_wrappedBeaconKey m_ComAmazonawsKmsTypes.GenerateDataKeyWithoutPlaintextResponse
	_ = _11_wrappedBeaconKey
	_11_wrappedBeaconKey = (_10_valueOrError5).Extract().(m_ComAmazonawsKmsTypes.GenerateDataKeyWithoutPlaintextResponse)
	var _12_decryptOnlyBranchKeyItem _dafny.Map
	_ = _12_decryptOnlyBranchKeyItem
	_12_decryptOnlyBranchKeyItem = m_Structure.Companion_Default___.ToAttributeMap(_0_decryptOnlyEncryptionContext, ((_5_wrappedDecryptOnlyBranchKey).Dtor_CiphertextBlob()).Dtor_value().(_dafny.Sequence))
	var _13_activeBranchKeyItem _dafny.Map
	_ = _13_activeBranchKeyItem
	_13_activeBranchKeyItem = m_Structure.Companion_Default___.ToAttributeMap(_1_activeEncryptionContext, ((_8_wrappedActiveBranchKey).Dtor_CiphertextBlob()).Dtor_value().(_dafny.Sequence))
	var _14_beaconKeyItem _dafny.Map
	_ = _14_beaconKeyItem
	_14_beaconKeyItem = m_Structure.Companion_Default___.ToAttributeMap(_2_beaconEncryptionContext, ((_11_wrappedBeaconKey).Dtor_CiphertextBlob()).Dtor_value().(_dafny.Sequence))
	var _15_valueOrError6 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsDynamodbTypes.Companion_TransactWriteItemsOutput_.Default())
	_ = _15_valueOrError6
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_DDBKeystoreOperations.Companion_Default___.WriteNewKeyToStore(_12_decryptOnlyBranchKeyItem, _13_activeBranchKeyItem, _14_beaconKeyItem, ddbTableName, ddbClient)
	_15_valueOrError6 = _out3
	if (_15_valueOrError6).IsFailure() {
		output = (_15_valueOrError6).PropagateFailure()
		return output
	}
	var _16___v0 m_ComAmazonawsDynamodbTypes.TransactWriteItemsOutput
	_ = _16___v0
	_16___v0 = (_15_valueOrError6).Extract().(m_ComAmazonawsDynamodbTypes.TransactWriteItemsOutput)
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyKeyStoreTypes.Companion_CreateKeyOutput_.Create_CreateKeyOutput_(branchKeyIdentifier))
	return output
}
func (_static *CompanionStruct_Default___) VersionActiveBranchKey(input m_AwsCryptographyKeyStoreTypes.VersionKeyInput, timestamp _dafny.Sequence, branchKeyVersion _dafny.Sequence, ddbTableName _dafny.Sequence, logicalKeyStoreName _dafny.Sequence, kmsConfiguration m_AwsCryptographyKeyStoreTypes.KMSConfiguration, grantTokens _dafny.Sequence, kmsClient m_ComAmazonawsKmsTypes.IKMSClient, ddbClient m_ComAmazonawsDynamodbTypes.IDynamoDBClient) m_Wrappers.Result {
	var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyKeyStoreTypes.Companion_VersionKeyOutput_.Default())
	_ = output
	var _0_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
	_ = _0_valueOrError0
	var _out0 m_Wrappers.Result
	_ = _out0
	_out0 = m_DDBKeystoreOperations.Companion_Default___.GetActiveBranchKeyItem((input).Dtor_branchKeyIdentifier(), ddbTableName, ddbClient)
	_0_valueOrError0 = _out0
	if (_0_valueOrError0).IsFailure() {
		output = (_0_valueOrError0).PropagateFailure()
		return output
	}
	var _1_oldActiveItem _dafny.Map
	_ = _1_oldActiveItem
	_1_oldActiveItem = (_0_valueOrError0).Extract().(_dafny.Map)
	var _2_oldActiveEncryptionContext _dafny.Map
	_ = _2_oldActiveEncryptionContext
	_2_oldActiveEncryptionContext = m_Structure.Companion_Default___.ToBranchKeyContext(_1_oldActiveItem, logicalKeyStoreName)
	var _3_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _3_valueOrError1
	_3_valueOrError1 = m_Wrappers.Companion_Default___.Need((true) && (m_KMSKeystoreOperations.Companion_Default___.AttemptKmsOperation_q(kmsConfiguration, _2_oldActiveEncryptionContext)), m_AwsCryptographyKeyStoreTypes.Companion_Error_.Create_KeyStoreException_(m_KeyStoreErrorMessages.Companion_Default___.VERSION__KEY__KMS__KEY__ARN__DISAGREEMENT()))
	if (_3_valueOrError1).IsFailure() {
		output = (_3_valueOrError1).PropagateFailure()
		return output
	}
	var _4_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsKmsTypes.Companion_ReEncryptResponse_.Default())
	_ = _4_valueOrError2
	var _out1 m_Wrappers.Result
	_ = _out1
	_out1 = m_KMSKeystoreOperations.Companion_Default___.ReEncryptKey(((_1_oldActiveItem).Get(m_Structure.Companion_Default___.BRANCH__KEY__FIELD()).(m_ComAmazonawsDynamodbTypes.AttributeValue)).Dtor_B(), _2_oldActiveEncryptionContext, _2_oldActiveEncryptionContext, kmsConfiguration, grantTokens, kmsClient)
	_4_valueOrError2 = _out1
	if (_4_valueOrError2).IsFailure() {
		output = (_4_valueOrError2).PropagateFailure()
		return output
	}
	var _5___v1 m_ComAmazonawsKmsTypes.ReEncryptResponse
	_ = _5___v1
	_5___v1 = (_4_valueOrError2).Extract().(m_ComAmazonawsKmsTypes.ReEncryptResponse)
	var _6_decryptOnlyEncryptionContext _dafny.Map
	_ = _6_decryptOnlyEncryptionContext
	_6_decryptOnlyEncryptionContext = m_Structure.Companion_Default___.NewVersionFromActiveBranchKeyEncryptionContext(_2_oldActiveEncryptionContext, branchKeyVersion, timestamp)
	var _7_activeEncryptionContext _dafny.Map
	_ = _7_activeEncryptionContext
	_7_activeEncryptionContext = m_Structure.Companion_Default___.ActiveBranchKeyEncryptionContext(_6_decryptOnlyEncryptionContext)
	var _8_valueOrError3 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsKmsTypes.Companion_GenerateDataKeyWithoutPlaintextResponse_.Default())
	_ = _8_valueOrError3
	var _out2 m_Wrappers.Result
	_ = _out2
	_out2 = m_KMSKeystoreOperations.Companion_Default___.GenerateKey(_6_decryptOnlyEncryptionContext, kmsConfiguration, grantTokens, kmsClient)
	_8_valueOrError3 = _out2
	if (_8_valueOrError3).IsFailure() {
		output = (_8_valueOrError3).PropagateFailure()
		return output
	}
	var _9_wrappedDecryptOnlyBranchKey m_ComAmazonawsKmsTypes.GenerateDataKeyWithoutPlaintextResponse
	_ = _9_wrappedDecryptOnlyBranchKey
	_9_wrappedDecryptOnlyBranchKey = (_8_valueOrError3).Extract().(m_ComAmazonawsKmsTypes.GenerateDataKeyWithoutPlaintextResponse)
	var _10_valueOrError4 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsKmsTypes.Companion_ReEncryptResponse_.Default())
	_ = _10_valueOrError4
	var _out3 m_Wrappers.Result
	_ = _out3
	_out3 = m_KMSKeystoreOperations.Companion_Default___.ReEncryptKey(((_9_wrappedDecryptOnlyBranchKey).Dtor_CiphertextBlob()).Dtor_value().(_dafny.Sequence), _6_decryptOnlyEncryptionContext, _7_activeEncryptionContext, kmsConfiguration, grantTokens, kmsClient)
	_10_valueOrError4 = _out3
	if (_10_valueOrError4).IsFailure() {
		output = (_10_valueOrError4).PropagateFailure()
		return output
	}
	var _11_wrappedActiveBranchKey m_ComAmazonawsKmsTypes.ReEncryptResponse
	_ = _11_wrappedActiveBranchKey
	_11_wrappedActiveBranchKey = (_10_valueOrError4).Extract().(m_ComAmazonawsKmsTypes.ReEncryptResponse)
	var _12_decryptOnlyBranchKeyItem _dafny.Map
	_ = _12_decryptOnlyBranchKeyItem
	_12_decryptOnlyBranchKeyItem = m_Structure.Companion_Default___.ToAttributeMap(_6_decryptOnlyEncryptionContext, ((_9_wrappedDecryptOnlyBranchKey).Dtor_CiphertextBlob()).Dtor_value().(_dafny.Sequence))
	var _13_activeBranchKeyItem _dafny.Map
	_ = _13_activeBranchKeyItem
	_13_activeBranchKeyItem = m_Structure.Companion_Default___.ToAttributeMap(_7_activeEncryptionContext, ((_11_wrappedActiveBranchKey).Dtor_CiphertextBlob()).Dtor_value().(_dafny.Sequence))
	var _14_valueOrError5 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_ComAmazonawsDynamodbTypes.Companion_TransactWriteItemsOutput_.Default())
	_ = _14_valueOrError5
	var _out4 m_Wrappers.Result
	_ = _out4
	_out4 = m_DDBKeystoreOperations.Companion_Default___.WriteNewBranchKeyVersionToKeystore(_12_decryptOnlyBranchKeyItem, _13_activeBranchKeyItem, ddbTableName, ddbClient)
	_14_valueOrError5 = _out4
	if (_14_valueOrError5).IsFailure() {
		output = (_14_valueOrError5).PropagateFailure()
		return output
	}
	var _15___v2 m_ComAmazonawsDynamodbTypes.TransactWriteItemsOutput
	_ = _15___v2
	_15___v2 = (_14_valueOrError5).Extract().(m_ComAmazonawsDynamodbTypes.TransactWriteItemsOutput)
	output = m_Wrappers.Companion_Result_.Create_Success_(m_AwsCryptographyKeyStoreTypes.Companion_VersionKeyOutput_.Create_VersionKeyOutput_())
	return output
}

// End of class Default__
