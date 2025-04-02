package Com_Amazonaws_Dynamodb

import (
	"context"

	"github.com/aws/aws-cryptographic-material-providers-library/releases/go/dynamodb/ComAmazonawsDynamodbTypes"
	"github.com/aws/aws-cryptographic-material-providers-library/releases/go/dynamodb/DynamoDBwrapped"
	"github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Wrappers"
	"github.com/aws/aws-sdk-go-v2/config"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb"
	_dafny "github.com/dafny-lang/DafnyRuntimeGo/v4/dafny"
)

func (_static *CompanionStruct_Default___) DynamoDBClient() Wrappers.Result {
	cfg, err := config.LoadDefaultConfig(context.TODO())
	if err != nil {
		return Wrappers.Companion_Result_.Create_Failure_(ComAmazonawsDynamodbTypes.Companion_Error_.Create_InternalServerError_(Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfChars([]_dafny.Char(err.Error())...))))

	}
	return Wrappers.Companion_Result_.Create_Success_(&DynamoDBwrapped.Shim{Client: dynamodb.NewFromConfig(cfg, func(o *dynamodb.Options) {})})
}

func (_static *CompanionStruct_Default___) DDBClientForRegion(regionInput _dafny.Sequence) Wrappers.Result {
	region := *toString(regionInput)
	cfg, err := config.LoadDefaultConfig(context.TODO())
	if err != nil {
		return Wrappers.Companion_Result_.Create_Failure_(ComAmazonawsDynamodbTypes.Companion_Error_.Create_InternalServerError_(Wrappers.Companion_Option_.Create_Some_(_dafny.SeqOfChars([]_dafny.Char(err.Error())...))))

	}
	return Wrappers.Companion_Result_.Create_Success_(&DynamoDBwrapped.Shim{Client: dynamodb.NewFromConfig(cfg, func(o *dynamodb.Options) {
		o.Region = region
	})})
}

func (_static *CompanionStruct_Default___) RegionMatch(iDynamodbClient ComAmazonawsDynamodbTypes.IDynamoDBClient, regionInput _dafny.Sequence) Wrappers.Option {
	region := toString(regionInput)
	var wrappedDynamodbClient = iDynamodbClient.(*DynamoDBwrapped.Shim).Client
	return Wrappers.Companion_Option_.Create_Some_(wrappedDynamodbClient.Options().Region == *region)
}

func toString(input _dafny.Sequence) *string {
	var s string
	for i := _dafny.Iterate(input); ; {
		val, ok := i()
		if !ok {
			return &[]string{s}[0]
		} else {
			s = s + string(val.(_dafny.Char))
		}
	}
}
