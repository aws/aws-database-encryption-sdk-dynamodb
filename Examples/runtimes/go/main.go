package main

import (
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dbesdk/examples/keyring"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dbesdk/examples/misc"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dbesdk/examples/utils"
)

func main() {
	misc.PutItemGetItem()
	keyring.PutItemGetItem(utils.TestKmsRsaKeyID(), utils.RsaPublicKeyFilename())
}
