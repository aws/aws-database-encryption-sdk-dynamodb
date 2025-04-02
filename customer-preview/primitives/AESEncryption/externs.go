package AESEncryption

import (
	"crypto/aes"
	"crypto/cipher"
	"fmt"

	"github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/AwsCryptographyPrimitivesTypes"
	"github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Wrappers"
	"github.com/dafny-lang/DafnyRuntimeGo/v4/dafny"
)

var m_AESEncryption struct {
	AES_GCM CompanionStruct_Default___
}

func (CompanionStruct_Default___) AESDecryptExtern(algo AwsCryptographyPrimitivesTypes.AES__GCM, key dafny.Sequence,
	cipherText dafny.Sequence, authTag dafny.Sequence, iv dafny.Sequence, aad dafny.Sequence) Wrappers.Result {

	keyBytes := dafny.ToByteArray(key)
	cipherTextBytes := dafny.ToByteArray(cipherText)
	authTagBytes := dafny.ToByteArray(authTag)
	ivBytes := dafny.ToByteArray(iv)
	aadBytes := dafny.ToByteArray(aad)

	if algo.Dtor_keyLength() != int32(len(keyBytes)) {
		return Wrappers.Companion_Result_.Create_Failure_(AwsCryptographyPrimitivesTypes.Companion_Error_.Create_AwsCryptographicPrimitivesError_(
			dafny.SeqOfChars([]dafny.Char(fmt.Errorf("algorithm key length %d doesn't match actual key length %d ", algo.Dtor_keyLength(), len(keyBytes)).Error())...)))

	}

	if algo.Dtor_ivLength() != int32(len(ivBytes)) {
		return Wrappers.Companion_Result_.Create_Failure_(AwsCryptographyPrimitivesTypes.Companion_Error_.Create_AwsCryptographicPrimitivesError_(
			dafny.SeqOfChars([]dafny.Char(fmt.Errorf("algorithm iv length %d doesn't match actual iv length %d ", algo.Dtor_ivLength(), len(ivBytes)).Error())...)))
	}

	if algo.Dtor_tagLength() != int32(len(authTagBytes)) {
		return Wrappers.Companion_Result_.Create_Failure_(AwsCryptographyPrimitivesTypes.Companion_Error_.Create_AwsCryptographicPrimitivesError_(
			dafny.SeqOfChars([]dafny.Char(fmt.Errorf("algorithm tag length %d doesn't match actual tag length %d ", algo.Dtor_tagLength(), len(authTagBytes)).Error())...)))
	}

	block, err := aes.NewCipher(keyBytes)
	if err != nil {
		return Wrappers.Companion_Result_.Create_Failure_(AwsCryptographyPrimitivesTypes.Companion_Error_.Create_AwsCryptographicPrimitivesError_(
			dafny.SeqOfChars([]dafny.Char(err.Error())...)))
	}

	gcm, err := cipher.NewGCM(block)
	if err != nil {
		return Wrappers.Companion_Result_.Create_Failure_(AwsCryptographyPrimitivesTypes.Companion_Error_.Create_AwsCryptographicPrimitivesError_(
			dafny.SeqOfChars([]dafny.Char(err.Error())...)))
	}

	plaintext, err := gcm.Open(nil, ivBytes, append(cipherTextBytes, authTagBytes...), aadBytes)
	if err != nil {
		return Wrappers.Companion_Result_.Create_Failure_(AwsCryptographyPrimitivesTypes.Companion_Error_.Create_AwsCryptographicPrimitivesError_(
			dafny.SeqOfChars([]dafny.Char(err.Error())...)))
	}
	return Wrappers.Companion_Result_.Create_Success_(dafny.SeqOfBytes(plaintext))
}

func (CompanionStruct_Default___) AESEncryptExtern(algo AwsCryptographyPrimitivesTypes.AES__GCM, iv dafny.Sequence,
	key dafny.Sequence, msg dafny.Sequence, aad dafny.Sequence) Wrappers.Result {

	keyBytes := dafny.ToByteArray(key)
	ivBytes := dafny.ToByteArray(iv)
	aadBytes := dafny.ToByteArray(aad)

	if algo.Dtor_keyLength() != int32(len(keyBytes)) {
		return Wrappers.Companion_Result_.Create_Failure_(AwsCryptographyPrimitivesTypes.Companion_Error_.Create_AwsCryptographicPrimitivesError_(
			dafny.SeqOfChars([]dafny.Char(fmt.Errorf("algorithm key length %d doesn't match actual key length %d ", algo.Dtor_keyLength(), len(keyBytes)).Error())...)))

	}

	if algo.Dtor_ivLength() != int32(len(ivBytes)) {
		return Wrappers.Companion_Result_.Create_Failure_(AwsCryptographyPrimitivesTypes.Companion_Error_.Create_AwsCryptographicPrimitivesError_(
			dafny.SeqOfChars([]dafny.Char(fmt.Errorf("algorithm iv length %d doesn't match actual iv length %d ", algo.Dtor_ivLength(), len(ivBytes)).Error())...)))
	}

	block, err := aes.NewCipher(keyBytes)
	if err != nil {
		return Wrappers.Companion_Result_.Create_Failure_(AwsCryptographyPrimitivesTypes.Companion_Error_.Create_AwsCryptographicPrimitivesError_(
			dafny.SeqOfChars([]dafny.Char(err.Error())...)))
	}

	gcm, err := cipher.NewGCM(block)
	if err != nil {
		return Wrappers.Companion_Result_.Create_Failure_(AwsCryptographyPrimitivesTypes.Companion_Error_.Create_AwsCryptographicPrimitivesError_(
			dafny.SeqOfChars([]dafny.Char(err.Error())...)))
	}

	cipherText := gcm.Seal(nil, ivBytes, dafny.ToByteArray(msg), aadBytes)
	if cipherText == nil {
		return Wrappers.Companion_Result_.Create_Failure_(AwsCryptographyPrimitivesTypes.Companion_Error_.Create_AwsCryptographicPrimitivesError_(
			dafny.SeqOfChars([]dafny.Char(fmt.Errorf("failed to do AES_GCM Encrypt with the given parameters").Error())...)))
	}
	return Wrappers.Companion_Result_.Create_Success_(AwsCryptographyPrimitivesTypes.Companion_AESEncryptOutput_.Create_AESEncryptOutput_(
		dafny.SeqOfBytes(cipherText[:len(cipherText)-gcm.Overhead()]), dafny.SeqOfBytes(cipherText[len(cipherText)-gcm.Overhead():])))
}
