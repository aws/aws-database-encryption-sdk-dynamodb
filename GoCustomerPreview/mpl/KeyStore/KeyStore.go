// Package KeyStore
// Dafny module KeyStore compiled into Go

package KeyStore

import (
	os "os"

	m_ComAmazonawsDynamodbTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/dynamodb/ComAmazonawsDynamodbTypes"
	m_Com_Amazonaws_Dynamodb "github.com/aws/aws-cryptographic-material-providers-library/releases/go/dynamodb/Com_Amazonaws_Dynamodb"
	m_ComAmazonawsKmsTypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/kms/ComAmazonawsKmsTypes"
	m_Com_Amazonaws_Kms "github.com/aws/aws-cryptographic-material-providers-library/releases/go/kms/Com_Amazonaws_Kms"
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
	m_UUID "github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/UUID"
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
	return "KeyStore.Default__"
}
func (_this *Default__) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){}
}

var _ _dafny.TraitOffspring = &Default__{}

func (_static *CompanionStruct_Default___) DefaultKeyStoreConfig() m_AwsCryptographyKeyStoreTypes.KeyStoreConfig {
	return m_AwsCryptographyKeyStoreTypes.Companion_KeyStoreConfig_.Create_KeyStoreConfig_(_dafny.SeqOfString("None"), m_AwsCryptographyKeyStoreTypes.Companion_KMSConfiguration_.Create_kmsKeyArn_(_dafny.SeqOfString("arn:aws:kms:us-east-2:111122223333:key/1234abcd-12ab-34cd-56ef-1234567890ab")), _dafny.SeqOfString("None"), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_(), m_Wrappers.Companion_Option_.Create_None_())
}
func (_static *CompanionStruct_Default___) KeyStore(config m_AwsCryptographyKeyStoreTypes.KeyStoreConfig) m_Wrappers.Result {
	var res m_Wrappers.Result = m_Wrappers.Result{}
	_ = res
	var _0_kmsClient m_ComAmazonawsKmsTypes.IKMSClient = (m_ComAmazonawsKmsTypes.IKMSClient)(nil)
	_ = _0_kmsClient
	var _1_ddbClient m_ComAmazonawsDynamodbTypes.IDynamoDBClient = (m_ComAmazonawsDynamodbTypes.IDynamoDBClient)(nil)
	_ = _1_ddbClient
	var _2_inferredRegion m_Wrappers.Option
	_ = _2_inferredRegion
	_2_inferredRegion = m_Wrappers.Companion_Option_.Create_None_()
	if m_KMSKeystoreOperations.Companion_Default___.HasKeyId((config).Dtor_kmsConfiguration()) {
		var _3_valueOrError0 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _3_valueOrError0
		_3_valueOrError0 = m_KmsArn.Companion_Default___.IsValidKeyArn(m_KMSKeystoreOperations.Companion_Default___.GetKeyId((config).Dtor_kmsConfiguration()))
		if (_3_valueOrError0).IsFailure() {
			res = (_3_valueOrError0).PropagateFailure()
			return res
		}
		var _4_parsedArn m_AwsArnParsing.AwsArn
		_ = _4_parsedArn
		_4_parsedArn = (_3_valueOrError0).Extract().(m_AwsArnParsing.AwsArn)
		_2_inferredRegion = m_Wrappers.Companion_Option_.Create_Some_((_4_parsedArn).Dtor_region())
	} else if ((config).Dtor_kmsConfiguration()).Is_mrDiscovery() {
		_2_inferredRegion = m_Wrappers.Companion_Option_.Create_Some_((((config).Dtor_kmsConfiguration()).Dtor_mrDiscovery()).Dtor_region())
	}
	var _5_grantTokens m_Wrappers.Result
	_ = _5_grantTokens
	_5_grantTokens = m_AwsKmsUtils.Companion_Default___.GetValidGrantTokens((config).Dtor_grantTokens())
	var _6_valueOrError1 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _6_valueOrError1
	_6_valueOrError1 = m_Wrappers.Companion_Default___.Need((true) && ((_5_grantTokens).Is_Success()), m_AwsCryptographyKeyStoreTypes.Companion_Error_.Create_KeyStoreException_(_dafny.SeqOfString("Grant Tokens passed to Key Store configuration are invalid.")))
	if (_6_valueOrError1).IsFailure() {
		res = (_6_valueOrError1).PropagateFailure()
		return res
	}
	var _7_keyStoreId _dafny.Sequence = _dafny.EmptySeq.SetString()
	_ = _7_keyStoreId
	if ((config).Dtor_id()).Is_Some() {
		_7_keyStoreId = ((config).Dtor_id()).Dtor_value().(_dafny.Sequence)
	} else {
		var _8_maybeUuid m_Wrappers.Result
		_ = _8_maybeUuid
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_UUID.GenerateUUID()
		_8_maybeUuid = _out0
		var _9_valueOrError2 m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(_dafny.EmptySeq.SetString())
		_ = _9_valueOrError2
		_9_valueOrError2 = (_8_maybeUuid).MapFailure(func(coer24 func(_dafny.Sequence) m_AwsCryptographyKeyStoreTypes.Error) func(interface{}) interface{} {
			return func(arg24 interface{}) interface{} {
				return coer24(arg24.(_dafny.Sequence))
			}
		}(func(_10_e _dafny.Sequence) m_AwsCryptographyKeyStoreTypes.Error {
			return m_AwsCryptographyKeyStoreTypes.Companion_Error_.Create_KeyStoreException_(_10_e)
		}))
		if (_9_valueOrError2).IsFailure() {
			res = (_9_valueOrError2).PropagateFailure()
			return res
		}
		var _11_uuid _dafny.Sequence
		_ = _11_uuid
		_11_uuid = (_9_valueOrError2).Extract().(_dafny.Sequence)
		_7_keyStoreId = _11_uuid
	}
	if ((config).Dtor_kmsClient()).Is_Some() {
		_0_kmsClient = m_ComAmazonawsKmsTypes.Companion_IKMSClient_.CastTo_(((config).Dtor_kmsClient()).Dtor_value())
	} else if (((config).Dtor_kmsClient()).Is_None()) && ((_2_inferredRegion).Is_Some()) {
		var _12_maybeKmsClient m_Wrappers.Result
		_ = _12_maybeKmsClient
		var _out1 m_Wrappers.Result
		_ = _out1
		_out1 = m_Com_Amazonaws_Kms.Companion_Default___.KMSClientForRegion((_2_inferredRegion).Dtor_value().(_dafny.Sequence))
		_12_maybeKmsClient = _out1
		var _13_valueOrError3 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _13_valueOrError3
		_13_valueOrError3 = (_12_maybeKmsClient).MapFailure(func(coer25 func(m_ComAmazonawsKmsTypes.Error) m_AwsCryptographyKeyStoreTypes.Error) func(interface{}) interface{} {
			return func(arg25 interface{}) interface{} {
				return coer25(arg25.(m_ComAmazonawsKmsTypes.Error))
			}
		}(func(_14_e m_ComAmazonawsKmsTypes.Error) m_AwsCryptographyKeyStoreTypes.Error {
			return m_AwsCryptographyKeyStoreTypes.Companion_Error_.Create_ComAmazonawsKms_(_14_e)
		}))
		if (_13_valueOrError3).IsFailure() {
			res = (_13_valueOrError3).PropagateFailure()
			return res
		}
		_0_kmsClient = m_ComAmazonawsKmsTypes.Companion_IKMSClient_.CastTo_((_13_valueOrError3).Extract())
	} else {
		var _15_maybeKmsClient m_Wrappers.Result
		_ = _15_maybeKmsClient
		var _out2 m_Wrappers.Result
		_ = _out2
		_out2 = m_Com_Amazonaws_Kms.Companion_Default___.KMSClient()
		_15_maybeKmsClient = _out2
		var _16_valueOrError4 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _16_valueOrError4
		_16_valueOrError4 = (_15_maybeKmsClient).MapFailure(func(coer26 func(m_ComAmazonawsKmsTypes.Error) m_AwsCryptographyKeyStoreTypes.Error) func(interface{}) interface{} {
			return func(arg26 interface{}) interface{} {
				return coer26(arg26.(m_ComAmazonawsKmsTypes.Error))
			}
		}(func(_17_e m_ComAmazonawsKmsTypes.Error) m_AwsCryptographyKeyStoreTypes.Error {
			return m_AwsCryptographyKeyStoreTypes.Companion_Error_.Create_ComAmazonawsKms_(_17_e)
		}))
		if (_16_valueOrError4).IsFailure() {
			res = (_16_valueOrError4).PropagateFailure()
			return res
		}
		_0_kmsClient = m_ComAmazonawsKmsTypes.Companion_IKMSClient_.CastTo_((_16_valueOrError4).Extract())
	}
	if ((config).Dtor_ddbClient()).Is_Some() {
		_1_ddbClient = m_ComAmazonawsDynamodbTypes.Companion_IDynamoDBClient_.CastTo_(((config).Dtor_ddbClient()).Dtor_value())
	} else if (((config).Dtor_ddbClient()).Is_None()) && ((_2_inferredRegion).Is_Some()) {
		var _18_maybeDdbClient m_Wrappers.Result
		_ = _18_maybeDdbClient
		var _out3 m_Wrappers.Result
		_ = _out3
		_out3 = m_Com_Amazonaws_Dynamodb.Companion_Default___.DDBClientForRegion((_2_inferredRegion).Dtor_value().(_dafny.Sequence))
		_18_maybeDdbClient = _out3
		var _19_valueOrError5 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _19_valueOrError5
		_19_valueOrError5 = (_18_maybeDdbClient).MapFailure(func(coer27 func(m_ComAmazonawsDynamodbTypes.Error) m_AwsCryptographyKeyStoreTypes.Error) func(interface{}) interface{} {
			return func(arg27 interface{}) interface{} {
				return coer27(arg27.(m_ComAmazonawsDynamodbTypes.Error))
			}
		}(func(_20_e m_ComAmazonawsDynamodbTypes.Error) m_AwsCryptographyKeyStoreTypes.Error {
			return m_AwsCryptographyKeyStoreTypes.Companion_Error_.Create_ComAmazonawsDynamodb_(_20_e)
		}))
		if (_19_valueOrError5).IsFailure() {
			res = (_19_valueOrError5).PropagateFailure()
			return res
		}
		_1_ddbClient = m_ComAmazonawsDynamodbTypes.Companion_IDynamoDBClient_.CastTo_((_19_valueOrError5).Extract())
	} else {
		var _21_maybeDdbClient m_Wrappers.Result
		_ = _21_maybeDdbClient
		var _out4 m_Wrappers.Result
		_ = _out4
		_out4 = m_Com_Amazonaws_Dynamodb.Companion_Default___.DynamoDBClient()
		_21_maybeDdbClient = _out4
		var _22_valueOrError6 m_Wrappers.Result = m_Wrappers.Result{}
		_ = _22_valueOrError6
		_22_valueOrError6 = (_21_maybeDdbClient).MapFailure(func(coer28 func(m_ComAmazonawsDynamodbTypes.Error) m_AwsCryptographyKeyStoreTypes.Error) func(interface{}) interface{} {
			return func(arg28 interface{}) interface{} {
				return coer28(arg28.(m_ComAmazonawsDynamodbTypes.Error))
			}
		}(func(_23_e m_ComAmazonawsDynamodbTypes.Error) m_AwsCryptographyKeyStoreTypes.Error {
			return m_AwsCryptographyKeyStoreTypes.Companion_Error_.Create_ComAmazonawsDynamodb_(_23_e)
		}))
		if (_22_valueOrError6).IsFailure() {
			res = (_22_valueOrError6).PropagateFailure()
			return res
		}
		_1_ddbClient = m_ComAmazonawsDynamodbTypes.Companion_IDynamoDBClient_.CastTo_((_22_valueOrError6).Extract())
	}
	var _24_valueOrError7 m_Wrappers.Outcome = m_Wrappers.Companion_Outcome_.Default()
	_ = _24_valueOrError7
	_24_valueOrError7 = m_Wrappers.Companion_Default___.Need(m_ComAmazonawsDynamodbTypes.Companion_Default___.IsValid__TableName((config).Dtor_ddbTableName()), m_AwsCryptographyKeyStoreTypes.Companion_Error_.Create_KeyStoreException_(_dafny.SeqOfString("Invalid Amazon DynamoDB Table Name")))
	if (_24_valueOrError7).IsFailure() {
		res = (_24_valueOrError7).PropagateFailure()
		return res
	}
	var _25_client *KeyStoreClient
	_ = _25_client
	var _nw0 *KeyStoreClient = New_KeyStoreClient_()
	_ = _nw0
	_nw0.Ctor__(m_AwsCryptographyKeyStoreOperations.Companion_Config_.Create_Config_(_7_keyStoreId, (config).Dtor_ddbTableName(), (config).Dtor_logicalKeyStoreName(), (config).Dtor_kmsConfiguration(), (_5_grantTokens).Dtor_value().(_dafny.Sequence), _0_kmsClient, _1_ddbClient))
	_25_client = _nw0
	res = m_Wrappers.Companion_Result_.Create_Success_(_25_client)
	return res
	return res
}
func (_static *CompanionStruct_Default___) CreateSuccessOfClient(client m_AwsCryptographyKeyStoreTypes.IKeyStoreClient) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Success_(client)
}
func (_static *CompanionStruct_Default___) CreateFailureOfError(error_ m_AwsCryptographyKeyStoreTypes.Error) m_Wrappers.Result {
	return m_Wrappers.Companion_Result_.Create_Failure_(error_)
}

// End of class Default__

// Definition of class KeyStoreClient
type KeyStoreClient struct {
	_config m_AwsCryptographyKeyStoreOperations.Config
}

func New_KeyStoreClient_() *KeyStoreClient {
	_this := KeyStoreClient{}

	_this._config = m_AwsCryptographyKeyStoreOperations.Config{}
	return &_this
}

type CompanionStruct_KeyStoreClient_ struct {
}

var Companion_KeyStoreClient_ = CompanionStruct_KeyStoreClient_{}

func (_this *KeyStoreClient) Equals(other *KeyStoreClient) bool {
	return _this == other
}

func (_this *KeyStoreClient) EqualsGeneric(x interface{}) bool {
	other, ok := x.(*KeyStoreClient)
	return ok && _this.Equals(other)
}

func (*KeyStoreClient) String() string {
	return "KeyStore.KeyStoreClient"
}

func Type_KeyStoreClient_() _dafny.TypeDescriptor {
	return type_KeyStoreClient_{}
}

type type_KeyStoreClient_ struct {
}

func (_this type_KeyStoreClient_) Default() interface{} {
	return (*KeyStoreClient)(nil)
}

func (_this type_KeyStoreClient_) String() string {
	return "KeyStore.KeyStoreClient"
}
func (_this *KeyStoreClient) ParentTraits_() []*_dafny.TraitID {
	return [](*_dafny.TraitID){m_AwsCryptographyKeyStoreTypes.Companion_IKeyStoreClient_.TraitID_}
}

var _ m_AwsCryptographyKeyStoreTypes.IKeyStoreClient = &KeyStoreClient{}
var _ _dafny.TraitOffspring = &KeyStoreClient{}

func (_this *KeyStoreClient) Ctor__(config m_AwsCryptographyKeyStoreOperations.Config) {
	{
		(_this)._config = config
	}
}
func (_this *KeyStoreClient) GetKeyStoreInfo() m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyKeyStoreOperations.Companion_Default___.GetKeyStoreInfo((_this).Config())
		output = _out0
		return output
	}
}
func (_this *KeyStoreClient) CreateKeyStore(input m_AwsCryptographyKeyStoreTypes.CreateKeyStoreInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Result{}
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyKeyStoreOperations.Companion_Default___.CreateKeyStore((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *KeyStoreClient) CreateKey(input m_AwsCryptographyKeyStoreTypes.CreateKeyInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyKeyStoreTypes.Companion_CreateKeyOutput_.Default())
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyKeyStoreOperations.Companion_Default___.CreateKey((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *KeyStoreClient) VersionKey(input m_AwsCryptographyKeyStoreTypes.VersionKeyInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyKeyStoreTypes.Companion_VersionKeyOutput_.Default())
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyKeyStoreOperations.Companion_Default___.VersionKey((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *KeyStoreClient) GetActiveBranchKey(input m_AwsCryptographyKeyStoreTypes.GetActiveBranchKeyInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyKeyStoreTypes.Companion_GetActiveBranchKeyOutput_.Default())
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyKeyStoreOperations.Companion_Default___.GetActiveBranchKey((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *KeyStoreClient) GetBranchKeyVersion(input m_AwsCryptographyKeyStoreTypes.GetBranchKeyVersionInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyKeyStoreTypes.Companion_GetBranchKeyVersionOutput_.Default())
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyKeyStoreOperations.Companion_Default___.GetBranchKeyVersion((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *KeyStoreClient) GetBeaconKey(input m_AwsCryptographyKeyStoreTypes.GetBeaconKeyInput) m_Wrappers.Result {
	{
		var output m_Wrappers.Result = m_Wrappers.Companion_Result_.Default(m_AwsCryptographyKeyStoreTypes.Companion_GetBeaconKeyOutput_.Default())
		_ = output
		var _out0 m_Wrappers.Result
		_ = _out0
		_out0 = m_AwsCryptographyKeyStoreOperations.Companion_Default___.GetBeaconKey((_this).Config(), input)
		output = _out0
		return output
	}
}
func (_this *KeyStoreClient) Config() m_AwsCryptographyKeyStoreOperations.Config {
	{
		return _this._config
	}
}

// End of class KeyStoreClient
