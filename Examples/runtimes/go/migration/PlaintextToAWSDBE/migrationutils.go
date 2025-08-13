package plaintexttoawsdbe

import (
	"fmt"

	"github.com/aws/aws-sdk-go-v2/service/dynamodb"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb/types"
)

const (
	EncryptedAndSignedValue = "􏨾먱龹龱𐀂﹌𐀁𐀂𐀂𐀁. This will be encrypted and signed. 􏨾먱龹龱𐀂﹌𐀁𐀂𐀂𐀁"
	SignOnlyValue           = "􏨾먱龹龱𐀂﹌𐀁𐀂𐀂𐀁. This will never be encrypted, but it will be signed. 􏨾먱龹龱𐀂﹌𐀁𐀂𐀂𐀁."
	DoNothingValue          = "􏨾먱龹龱𐀂﹌𐀁𐀂𐀂𐀁. This will never be encrypted nor signed. 􏨾먱龹龱𐀂﹌𐀁𐀂𐀂𐀁."
)

func VerifyReturnedItem(result *dynamodb.GetItemOutput, partitionKeyValue, sortKeyValue, encryptedAndSignedValue, signOnlyValue, doNothingValue string) error {
	returnedPartitionKey, ok := result.Item["partition_key"].(*types.AttributeValueMemberS)
	if !ok {
		// We return this error because we run test against the error.
		// When used in production code, you can decide how you want to handle errors.
		return fmt.Errorf("partition_key is not a string attribute")
	}
	returnedsortKey, ok := result.Item["sort_key"].(*types.AttributeValueMemberN)
	if !ok {
		// We return this error because we run test against the error.
		// When used in production code, you can decide how you want to handle errors.
		return fmt.Errorf("sort_key is not a number attribute")
	}
	returnedAttribute1, ok := result.Item["attribute1"].(*types.AttributeValueMemberS)
	if !ok {
		// We return this error because we run test against the error.
		// When used in production code, you can decide how you want to handle errors.
		return fmt.Errorf("attribute1 is not a string attribute")
	}
	returnedAttribute2, ok := result.Item["attribute2"].(*types.AttributeValueMemberS)
	if !ok {
		// We return this error because we run test against the error.
		// When used in production code, you can decide how you want to handle errors.
		return fmt.Errorf("attribute2 is not a string attribute")
	}
	returnedAttribute3, ok := result.Item["attribute3"].(*types.AttributeValueMemberS)
	if !ok {
		// We return this error because we run test against the error.
		// When used in production code, you can decide how you want to handle errors.
		return fmt.Errorf("attribute3 is not a string attribute")
	}

	if returnedPartitionKey.Value != partitionKeyValue {
		panic(fmt.Sprintf("Expected partition key %s, got %s", partitionKeyValue, returnedPartitionKey))
	}
	if returnedsortKey.Value != sortKeyValue {
		panic(fmt.Sprintf("Expected partition key %s, got %s", sortKeyValue, returnedsortKey))
	}
	if returnedAttribute1.Value != encryptedAndSignedValue {
		panic(fmt.Sprintf("Expected attribute1 value %s, got %s", encryptedAndSignedValue, returnedAttribute1.Value))
	}
	if returnedAttribute2.Value != signOnlyValue {
		panic(fmt.Sprintf("Expected attribute2 value %s, got %s", signOnlyValue, returnedAttribute2.Value))
	}
	if returnedAttribute3.Value != doNothingValue {
		panic(fmt.Sprintf("Expected attribute3 value %s, got %s", doNothingValue, returnedAttribute3.Value))
	}
	return nil
}
