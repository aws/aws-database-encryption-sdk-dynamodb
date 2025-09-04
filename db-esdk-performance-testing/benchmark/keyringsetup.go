package benchmark

import (
	"context"
	"crypto/rand"
	"fmt"

	mplsmithygenerated "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographymaterialproviderssmithygenerated"
	mpltypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographymaterialproviderssmithygeneratedtypes"
)

func SetupRawAESKeyring(matProv *mplsmithygenerated.Client) (mpltypes.IKeyring, error) {
	key := make([]byte, 32)
	if _, err := rand.Read(key); err != nil {
		return nil, fmt.Errorf("failed to generate AES-256 key: %w", err)
	}

	keyringInput := mpltypes.CreateRawAesKeyringInput{
		KeyName:      "test-aes-256-key",
		KeyNamespace: "DB-ESDK-performance-test",
		WrappingKey:  key,
		WrappingAlg:  mpltypes.AesWrappingAlgAlgAes256GcmIv12Tag16,
	}

	keyring, err := matProv.CreateRawAesKeyring(context.Background(), keyringInput)
	if err != nil {
		return nil, fmt.Errorf("failed to create keyring: %w", err)
	}
	return keyring, nil
}
