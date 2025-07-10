package CreateInterceptedDDBClient

import (
	"context"
	"net/url"

	"github.com/aws/aws-cryptographic-material-providers-library/releases/go/dynamodb/DynamoDBwrapped"
	"github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Wrappers"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkDynamoDbTypes"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/awscryptographydbencryptionsdkdynamodbsmithygenerated"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/dbesdkmiddleware"
	"github.com/aws/aws-sdk-go-v2/config"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb"
	smithyendpoints "github.com/aws/smithy-go/endpoints"
)

type resolverV2 struct {
}

func (*resolverV2) ResolveEndpoint(ctx context.Context, params dynamodb.EndpointParameters) (
	smithyendpoints.Endpoint, error,
) {
	u, err := url.Parse("http://localhost:8000")
	if err != nil {
		return smithyendpoints.Endpoint{}, err
	}
	return smithyendpoints.Endpoint{
		URI: *u,
	}, nil
}

func CreateVanillaDDBClient() Wrappers.Result {
	cfg, err := config.LoadDefaultConfig(context.TODO())
	if err != nil {
		panic(err)
	}
	ddbClient := dynamodb.NewFromConfig(cfg, func(o *dynamodb.Options) {
		o.EndpointResolverV2 = &resolverV2{}
	})
	return Wrappers.Companion_Result_.Create_Success_(&DynamoDBwrapped.Shim{
		Client: ddbClient,
	})
}

func CreateInterceptedDDBClient(ddbEncryptionConfig AwsCryptographyDbEncryptionSdkDynamoDbTypes.DynamoDbTablesEncryptionConfig) Wrappers.Result {
	cfg, err := config.LoadDefaultConfig(context.TODO())
	if err != nil {
		panic(err)
	}
	nativeConfig := awscryptographydbencryptionsdkdynamodbsmithygenerated.DynamoDbTablesEncryptionConfig_FromDafny(ddbEncryptionConfig)
	dbEsdkMiddleware, err := dbesdkmiddleware.NewDBEsdkMiddleware(nativeConfig)
	if err != nil {
		panic(err)
	}
	ddbClient := dynamodb.NewFromConfig(cfg, dbEsdkMiddleware.CreateMiddleware(), func(o *dynamodb.Options) {
		o.EndpointResolverV2 = &resolverV2{}
	})
	return Wrappers.Companion_Result_.Create_Success_(&DynamoDBwrapped.Shim{
		Client: ddbClient,
	})
}
