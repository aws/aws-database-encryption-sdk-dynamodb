package main

import (
	"github.com/aws/aws-database-encryption-sdk-dynamodb/examples/keyring"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/examples/utils"
)

func main() {
	keyring.AwsKmsKeyringExample(utils.KmsKeyID(), utils.DdbTableName())
	keyring.RawAesExample(utils.DdbTableName(), utils.KeyNamespace(), utils.KeyName(), utils.GenerateAes256KeyBytes())
}
