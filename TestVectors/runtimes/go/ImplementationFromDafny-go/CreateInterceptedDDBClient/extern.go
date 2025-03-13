package CreateInterceptedDDBClient

import (
	"context"

	"github.com/aws/aws-cryptographic-material-providers-library/releases/go/dynamodb/DynamoDBwrapped"
	"github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Wrappers"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/AwsCryptographyDbEncryptionSdkDynamoDbTypes"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/awscryptographydbencryptionsdkdynamodbsmithygenerated"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/dbesdkmiddleware"
	"github.com/aws/aws-sdk-go-v2/aws"
	"github.com/aws/aws-sdk-go-v2/config"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb"
)

func CreateVanillaDDBClient() Wrappers.Result {
	cfg, err := config.LoadDefaultConfig(context.TODO(),
		config.WithEndpointResolver(aws.EndpointResolverFunc(func(service, region string) (aws.Endpoint, error) {
			return aws.Endpoint{URL: "http://localhost:8000"}, nil
		})),
	)
	if err != nil {
		panic(err)
	}
	ddbClient := dynamodb.NewFromConfig(cfg)
	return Wrappers.Companion_Result_.Create_Success_(&DynamoDBwrapped.Shim{
		Client: ddbClient,
	})
}

func CreateInterceptedDDBClient(ddbEncryptionConfig AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTablesEncryptionConfig) Wrappers.Result {
	cfg, err := config.LoadDefaultConfig(context.TODO(),
		config.WithEndpointResolver(aws.EndpointResolverFunc(func(service, region string) (aws.Endpoint, error) {
			return aws.Endpoint{URL: "http://localhost:8000"}, nil
		})),
	)
	if err != nil {
		panic(err)
	}
	nativeConfig := awscryptographydbencryptionsdkdynamodbsmithygenerated.DynamoDbTablesEncryptionConfig_FromDafny(ddbEncryptionConfig)
	dbEsdkMiddleware, err := dbesdkmiddleware.NewDBEsdkMiddleware(nativeConfig)
	ddbClient := dynamodb.NewFromConfig(cfg, dbEsdkMiddleware.CreateMiddleware())
	return Wrappers.Companion_Result_.Create_Success_(&DynamoDBwrapped.Shim{
		Client: ddbClient,
	})
}
