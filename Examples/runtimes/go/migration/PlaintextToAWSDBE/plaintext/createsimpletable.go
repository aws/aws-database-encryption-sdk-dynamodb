package plaintext

import (
	"context"

	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/examples/utils"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb/types"
)

// CreateSimpleTable creates a DynamoDB table with partition_key (S) and sort_key (N)
func CreateSimpleTable(ddbClient *dynamodb.Client, ddbTableName string) {
	input := &dynamodb.CreateTableInput{
		TableName: &ddbTableName,
		KeySchema: []types.KeySchemaElement{
			{
				AttributeName: &[]string{"partition_key"}[0],
				KeyType:       types.KeyTypeHash,
			},
			{
				AttributeName: &[]string{"sort_key"}[0],
				KeyType:       types.KeyTypeRange,
			},
		},
		AttributeDefinitions: []types.AttributeDefinition{
			{
				AttributeName: &[]string{"partition_key"}[0],
				AttributeType: types.ScalarAttributeTypeS,
			},
			{
				AttributeName: &[]string{"sort_key"}[0],
				AttributeType: types.ScalarAttributeTypeN,
			},
		},
		BillingMode: "PAY_PER_REQUEST",
	}

	_, err := ddbClient.CreateTable(context.TODO(), input)
	utils.HandleError(err)
}
