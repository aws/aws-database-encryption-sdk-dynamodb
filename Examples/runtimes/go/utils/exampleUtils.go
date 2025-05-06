// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package utils

import (
	"crypto/rand"
	"crypto/rsa"
	"crypto/x509"
	"encoding/pem"
)

const (
	kmsKeyID                = "arn:aws:kms:us-west-2:658956600833:key/b3537ef1-d8dc-4780-9f5a-55776cbb2f7f"
	ddbTableName            = "DynamoDbEncryptionInterceptorTestTableCS"
	keyNamespace            = "my-key-namespace"
	keyName                 = "my-key-name"
	aesKeyBytes             = 32 // 256 bits = 32 bytes
	testKeystoreName        = "KeyStoreDdbTable"
	testLogicalKeystoreName = "KeyStoreDdbTable"
	testKeystoreKmsKeyId    = "arn:aws:kms:us-west-2:370957321024:key/9d989aa2-2f9c-438c-a745-cc57d3ad0126"
)

func TestKeystoreName() string {
	return testKeystoreName
}

func TestLogicalKeystoreName() string {
	return testLogicalKeystoreName
}

func TestKeystoreKmsKeyId() string {
	return testKeystoreKmsKeyId
}

func KmsKeyID() string {
	return kmsKeyID
}

func DdbTableName() string {
	return ddbTableName
}

func KeyNamespace() string {
	return keyNamespace
}

func KeyName() string {
	return keyName
}

func AreMapsEqual(map1, map2 map[string]string) bool {
	if len(map1) != len(map2) {
		return false
	}

	for key, value1 := range map1 {
		value2, exists := map2[key]
		if !exists || value1 != value2 {
			return false
		}
	}
	return true
}

func HandleError(err error) {
	// Error handling is limited to panic for demonstration purposes only.
	// In your code, errors should be properly handled.
	if err != nil {
		panic(err)
	}
}

func GenerateAes256KeyBytes() []byte {
	key := make([]byte, aesKeyBytes)
	// crypto/rand is used here for demonstration.
	// In your code, you should implement a key generation strategy that meets your security needs.
	_, err := rand.Read(key)
	HandleError(err)
	return key
}

func GenerateKeyPair() (publicKeyBlock, privateKeyBlock *pem.Block) {
	privateKey, err := rsa.GenerateKey(rand.Reader, 2048)
	HandleError(err)
	// Extract public key from the private key
	publicKey := &privateKey.PublicKey
	// Encode public key to PKCS1 DER format
	publicKeyDER, err := x509.MarshalPKIXPublicKey(publicKey)
	HandleError(err)
	privateKeyDer, err := x509.MarshalPKCS8PrivateKey(privateKey)
	HandleError(err)
	// Encode to PEM format
	publicKeyBlock = &pem.Block{
		Type:  "RSA PUBLIC KEY",
		Bytes: publicKeyDER,
	}
	privateKeyBlock = &pem.Block{
		Type:  "PRIVATE KEY",
		Bytes: privateKeyDer,
	}
	return publicKeyBlock, privateKeyBlock
}
