package RSAEncryption

import (
	"crypto"
	"crypto/rand"
	"crypto/rsa"
	"crypto/x509"
	"encoding/pem"
	"fmt"

	"github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/AwsCryptographyPrimitivesTypes"
	"github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Wrappers"
	"github.com/dafny-lang/DafnyRuntimeGo/v4/dafny"
)

type m_RSAEncryption_Ghost struct {
	RSA CompanionStruct_Default___
}

var m_RSAEncryption = m_RSAEncryption_Ghost{}

func (CompanionStruct_Default___) GenerateKeyPairExtern(bits int32) (dafny.Sequence, dafny.Sequence) {

	privateKey, err := rsa.GenerateKey(rand.Reader, int(bits))
	if err != nil {
		panic(err)
	}
	encodePrivateKey, err := x509.MarshalPKCS8PrivateKey(privateKey)
	if err != nil {
		panic(err)
	}
	encodePublicKey, err := x509.MarshalPKIXPublicKey(&privateKey.PublicKey)
	if err != nil {
		panic(err)
	}
	return dafny.SeqOfBytes(pem.EncodeToMemory(&pem.Block{Type: "RSA PUBLIC KEY", Bytes: encodePublicKey})),
		dafny.SeqOfBytes(pem.EncodeToMemory(&pem.Block{Type: "RSA PRIVATE KEY", Bytes: encodePrivateKey}))
}

func (m_RSAEncryption_Ghost) RSA_GetRSAKeyModulusLengthExtern(publicKeyInput dafny.Sequence) Wrappers.Result {
	derPublicKey, rest := pem.Decode(dafny.ToByteArray(publicKeyInput))
	if len(rest) > 0 {
		return Wrappers.Companion_Result_.Create_Failure_(AwsCryptographyPrimitivesTypes.Companion_Error_.Create_AwsCryptographicPrimitivesError_(
			dafny.SeqOfChars([]dafny.Char(fmt.Errorf("failed to decode PEM: invalid bytes:  %s", rest).Error())...)))
	}
	publicKey, err := x509.ParsePKIXPublicKey(derPublicKey.Bytes)
	if err != nil {
		return Wrappers.Companion_Result_.Create_Failure_(AwsCryptographyPrimitivesTypes.Companion_Error_.Create_AwsCryptographicPrimitivesError_(
			dafny.SeqOfChars([]dafny.Char(err.Error())...)))
	}
	return Wrappers.Companion_Result_.Create_Success_(uint32(publicKey.(*rsa.PublicKey).N.BitLen()))
}

func (CompanionStruct_Default___) DecryptExtern(paddingMode AwsCryptographyPrimitivesTypes.RSAPaddingMode,
	key dafny.Sequence, cipher_text dafny.Sequence) Wrappers.Result {
	derPrivateKey, rest := pem.Decode(dafny.ToByteArray(key))
	if len(rest) > 0 {
		return Wrappers.Companion_Result_.Create_Failure_(AwsCryptographyPrimitivesTypes.Companion_Error_.Create_AwsCryptographicPrimitivesError_(
			dafny.SeqOfChars([]dafny.Char(fmt.Errorf("failed to decode PEM: invalid bytes:  %s", rest).Error())...)))
	}

	privateKey, err := x509.ParsePKCS8PrivateKey(derPrivateKey.Bytes)
	if err != nil {
		return Wrappers.Companion_Result_.Create_Failure_(AwsCryptographyPrimitivesTypes.Companion_Error_.Create_AwsCryptographicPrimitivesError_(
			dafny.SeqOfChars([]dafny.Char(err.Error())...)))
	}

	if paddingMode.Is_PKCS1() {
		encryptedBytes, err := rsa.DecryptPKCS1v15(rand.Reader, privateKey.(*rsa.PrivateKey), dafny.ToByteArray(cipher_text))
		if err != nil {
			return Wrappers.Companion_Result_.Create_Failure_(AwsCryptographyPrimitivesTypes.Companion_Error_.Create_AwsCryptographicPrimitivesError_(
				dafny.SeqOfChars([]dafny.Char(err.Error())...)))
		}
		return Wrappers.Companion_Result_.Create_Success_(dafny.SeqOfBytes(encryptedBytes))
	}

	mode, err := getNativeHashAlgorithm(paddingMode)
	if err != nil {
		return Wrappers.Companion_Result_.Create_Failure_(AwsCryptographyPrimitivesTypes.Companion_Error_.Create_AwsCryptographicPrimitivesError_(
			dafny.SeqOfChars([]dafny.Char(err.Error())...)))
	}

	res, err := rsa.DecryptOAEP(crypto.Hash(mode).New(), rand.Reader, privateKey.(*rsa.PrivateKey), dafny.ToByteArray(cipher_text), nil)
	if err != nil {
		return Wrappers.Companion_Result_.Create_Failure_(AwsCryptographyPrimitivesTypes.Companion_Error_.Create_AwsCryptographicPrimitivesError_(
			dafny.SeqOfChars([]dafny.Char(err.Error())...)))
	}
	return Wrappers.Companion_Result_.Create_Success_(dafny.SeqOfBytes(res))
}

func (CompanionStruct_Default___) EncryptExtern(paddingMode AwsCryptographyPrimitivesTypes.RSAPaddingMode,
	key dafny.Sequence, plainText dafny.Sequence) Wrappers.Result {
	derPublicKey, rest := pem.Decode(dafny.ToByteArray(key))
	if len(rest) > 0 {
		return Wrappers.Companion_Result_.Create_Failure_(AwsCryptographyPrimitivesTypes.Companion_Error_.Create_AwsCryptographicPrimitivesError_(
			dafny.SeqOfChars([]dafny.Char(fmt.Errorf("failed to decode PEM: invalid bytes:  %s", rest).Error())...)))
	}

	publicKey, err := x509.ParsePKIXPublicKey(derPublicKey.Bytes)
	if err != nil {
		return Wrappers.Companion_Result_.Create_Failure_(AwsCryptographyPrimitivesTypes.Companion_Error_.Create_AwsCryptographicPrimitivesError_(
			dafny.SeqOfChars([]dafny.Char(err.Error())...)))
	}
	if paddingMode.Is_PKCS1() {
		encryptedBytes, err := rsa.EncryptPKCS1v15(rand.Reader, publicKey.(*rsa.PublicKey), dafny.ToByteArray(plainText))
		if err != nil {
			return Wrappers.Companion_Result_.Create_Failure_(AwsCryptographyPrimitivesTypes.Companion_Error_.Create_AwsCryptographicPrimitivesError_(
				dafny.SeqOfChars([]dafny.Char(err.Error())...)))
		}
		return Wrappers.Companion_Result_.Create_Success_(dafny.SeqOfBytes(encryptedBytes))
	}

	hash1, err := getNativeHashAlgorithm(paddingMode)
	if err != nil {
		return Wrappers.Companion_Result_.Create_Failure_(AwsCryptographyPrimitivesTypes.Companion_Error_.Create_AwsCryptographicPrimitivesError_(
			dafny.SeqOfChars([]dafny.Char(err.Error())...)))
	}
	encryptedBytes, err := rsa.EncryptOAEP(hash1.New(), rand.Reader, publicKey.(*rsa.PublicKey), dafny.ToByteArray(plainText), nil)
	if err != nil {
		return Wrappers.Companion_Result_.Create_Failure_(AwsCryptographyPrimitivesTypes.Companion_Error_.Create_AwsCryptographicPrimitivesError_(
			dafny.SeqOfChars([]dafny.Char(err.Error())...)))
	}
	return Wrappers.Companion_Result_.Create_Success_(dafny.SeqOfBytes(encryptedBytes))
}

func getNativeHashAlgorithm(mode AwsCryptographyPrimitivesTypes.RSAPaddingMode) (crypto.Hash, error) {
	switch mode {
	case AwsCryptographyPrimitivesTypes.Companion_RSAPaddingMode_.Create_OAEP__SHA1_():
		return crypto.SHA1, nil
	case AwsCryptographyPrimitivesTypes.Companion_RSAPaddingMode_.Create_OAEP__SHA256_():
		return crypto.SHA256, nil
	case AwsCryptographyPrimitivesTypes.Companion_RSAPaddingMode_.Create_OAEP__SHA384_():
		return crypto.SHA384, nil
	case AwsCryptographyPrimitivesTypes.Companion_RSAPaddingMode_.Create_OAEP__SHA512_():
		return crypto.SHA512, nil
	default:
		return 0, fmt.Errorf("unsupported padding mode")
	}
}
