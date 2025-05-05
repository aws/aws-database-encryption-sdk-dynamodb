package main

import (
	"github.com/aws/aws-database-encryption-sdk-dynamodb/examples/itemencryptor"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/examples/keyring"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/examples/misc"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/examples/utils"
)

func main() {
	keyring.AwsKmsKeyringExample(utils.KmsKeyID(), utils.DdbTableName())
	keyring.RawAesExample(utils.DdbTableName(), utils.KeyNamespace(), utils.KeyName(), utils.GenerateAes256KeyBytes())
	itemencryptor.ItemEncryptDecryptExample(utils.KmsKeyID(), utils.DdbTableName())
	misc.GetEncryptedDataKeyDescriptionExample(utils.KmsKeyID(), utils.DdbTableName())
}
