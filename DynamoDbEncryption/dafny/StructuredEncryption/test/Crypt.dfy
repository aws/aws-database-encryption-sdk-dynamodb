// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

include "../src/Crypt.dfy"

module TestStructuredEncryptionCrypt {
  import opened StructuredEncryptionCrypt
  import opened Wrappers
  import opened StandardLibrary
  import opened StandardLibrary.UInt
  import opened StructuredEncryptionUtil
  import opened HexStrings

  datatype FieldKeyTestItem = FieldKeyTestItem(
    nameonly input : string,
    nameonly offset : uint32,
    nameonly output : string
  )
  const FieldKeyTestVector : seq<FieldKeyTestItem> := [
    FieldKeyTestItem(
      input := "0000000000000000000000000000000000000000000000000000000000000000",
      offset := 0,
      output := "4d17ac4f80763c4f5c1523ca2322b89918d5ad8b728aea9e052b177e41570f7be7ff404ace5e9b22aa1e8968"
    ),
    FieldKeyTestItem(
      input := "0000000000000000000000000000000000000000000000000000000000000000",
      offset := 1,
      output := "18fcefe222b4d2a414c908f35c2e09153068198ad2b33fd0921596e5b02e7c1a48b2c6e720dc75167db54f46"
    ),
    FieldKeyTestItem(
      input := "0000000000000000000000000000000000000000000000000000000000000000",
      offset := 2,
      output := "ec387607afb264f56ba44abd037c469fdfff9d5861a976a4261083e6dfa48d883b6c85c440003ed094a1eee7"
    ),
    FieldKeyTestItem(
      input := "0000000000000000000000000000000000000000000000000000000000000000",
      offset := 3,
      output := "7124e0a5e057d168d17c76be6d61efff694048b301786d7952f463b509d2a542fe5cdf045f096f99ec3dca5b"
    ),
    FieldKeyTestItem(
      input := "0000000000000000000000000000000000000000000000000000000000000000",
      offset := 4,
      output := "56e053ebe6f7a937b9fec2847e82b3a9c5daa20d49d9e6eb7951595e68a0bb826277d52685464da6cf8271d8"
    ),
    FieldKeyTestItem(
      input := "0000000000000000000000000000000000000000000000000000000000000000",
      offset := 5,
      output := "8aacffc78d68c3350f510883394edfb1caaf21ddf363485dc4f6bcb4aef7a4dfaf8a0a0b9f647accc39db0f6"
    ),
    FieldKeyTestItem(
      input := "0000000000000000000000000000000000000000000000000000000000000000",
      offset := 6,
      output := "7fb8a9f5b5e8c838523944fe7da143ef0dab663df66ef22c0cec7653b541115dfda3a55fae43c4a27459909d"
    ),
    FieldKeyTestItem(
      input := "0000000000000000000000000000000000000000000000000000000000000000",
      offset := 7,
      output := "edfa5a6c99e14d131753163c2b890b135b8a6d4e310884d7d365a0670ef46686ef44b77c1c5a945797f17dd5"
    ),
    FieldKeyTestItem(
      input := "0000000000000000000000000000000000000000000000000000000000000001",
      offset := 0,
      output := "c6a8b4e10a23bac8e13ae2d4edc0311509a5ce01b4d2357f8b1e667eeef77066cb9a2c4481d66ad1ede3d50f"
    ),
    FieldKeyTestItem(
      input := "0000000000000000000000000000000000000000000000000000000000000001",
      offset := 1,
      output := "d54d4fe8e8295a523644dd49698f637a30f0c1e868c47a2a38e0e756ca0fcdee8e5aa355796debbb8fcb898b"
    ),
    FieldKeyTestItem(
      input := "0000000000000000000000000000000000000000000000000000000000000001",
      offset := 2,
      output := "254489ab5be234d848f4fb21cba3ea27962c50363c9924054fffe34bd4f87d641fdb793224ccbf3e6ca9fa60"
    ),
    FieldKeyTestItem(
      input := "0000000000000000000000000000000000000000000000000000000000000001",
      offset := 3,
      output := "b600f98e1c868209de7d563362ab8131bc8d0a5b58bf2590a8309889a94ee505515a02692824f7e32a31142f"
    ),
    FieldKeyTestItem(
      input := "0000000000000000000000000000000000000000000000000000000000000001",
      offset := 4,
      output := "0af797f151dca40bd6db2cf69d5f3fdb98f34a3efe5f4af778cb3f8b942b507bd6eca848dd8e4b62e9d2db42"
    ),
    FieldKeyTestItem(
      input := "0000000000000000000000000000000000000000000000000000000000000001",
      offset := 5,
      output := "9207c0c3dacd1b015d92689b78ba0bd49a1547f670d20097cc94cd35e569af02597a187f2ff7402f92149a19"
    ),
    FieldKeyTestItem(
      input := "0000000000000000000000000000000000000000000000000000000000000001",
      offset := 6,
      output := "ca14fb5a292ec5f76669a04811532d3ed0d09421bdce95d629b0d3259b35888cf17e28e1ed4c1c136b4e5866"
    ),
    FieldKeyTestItem(
      input := "0000000000000000000000000000000000000000000000000000000000000001",
      offset := 7,
      output := "da1188242ab66975027f11e49ecca9e7e23aaf1215855c263460a24f7d000cab89600be8ad6781d226190bed"
    ),
    FieldKeyTestItem(
      input := "ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff",
      offset := 0,
      output := "0c7e451b952b793d95c66bef5df16a7e42cd70bca33d5f9e01651751b4dbff0e4f9524335caef55a68d55f2a"
    ),
    FieldKeyTestItem(
      input := "ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff",
      offset := 1,
      output := "de3cdd84c99d3f6c011469433b2c24994e1836f2c923ee1fab47c3bedca95c1dd0fc547887cf9948efe1ffb6"
    ),
    FieldKeyTestItem(
      input := "ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff",
      offset := 2,
      output := "a088b21f062333d7a588da26ae30e11239949abd30b8a971621f2d664e5f2406212a4d51a04e63d314de54c3"
    ),
    FieldKeyTestItem(
      input := "ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff",
      offset := 3,
      output := "dc3448317b6d74b6dd662a9270fe808ab1dd7faf0f009e6e5e9f3aaac969d947d81e5bbc933819b8d6f2d76e"
    ),
    FieldKeyTestItem(
      input := "ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff",
      offset := 4,
      output := "87c5acfda18b650896588cd1f67e8f69cab31aed59df54b49c0748f4646e4789153bccb33b96ed760e9dfd44"
    ),
    FieldKeyTestItem(
      input := "ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff",
      offset := 5,
      output := "392d11b7e0884a5e42ef50f408cd79cbb0b96f792d67025527fd0ff0cfacad33c4dcead6021b34e4d0d1a3a2"
    ),
    FieldKeyTestItem(
      input := "ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff",
      offset := 6,
      output := "6092ee61588d3b1013b82c05ea7a894cdb9649d2fa8695f731c946aa75c47c4db0996bff661f8a796533c348"
    ),
    FieldKeyTestItem(
      input := "ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff",
      offset := 7,
      output := "d0270cfa0da88692a057c39b39644970786367da64008206e51a799af19f65db5b1531d01c52216431c451e5"
    ),
    FieldKeyTestItem(
      input := "0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef",
      offset := 0,
      output := "772cb513bc2bebfed36dfa3c22dec2c5cb09466dd1b5275cd1f2713339b32e9c7993c521808a0bd6faa4cb4f"
    ),
    FieldKeyTestItem(
      input := "0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef",
      offset := 1,
      output := "e93a3a5dd1633af15027c2ec078fc536ddf295110dfa5053592842a8c1f1010ad15c2462d0371ff27d98e99b"
    ),
    FieldKeyTestItem(
      input := "0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef",
      offset := 2,
      output := "66f92041859c2000b8ff492629ae1ef875666c360fcfadeefe11e9f9f257887c4d1289c43ac1a442ec14a426"
    ),
    FieldKeyTestItem(
      input := "0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef",
      offset := 3,
      output := "02dd4a565fcc6d308ce3f9a2818c8426c3476b2fb6ea66f1c4688c313b061177a6c69a2663122e4c5f3895dd"
    ),
    FieldKeyTestItem(
      input := "0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef",
      offset := 4,
      output := "010a7cd17c89ac7668ba45332bdd956e388113f1ee9d01f387c5574ffdd86ade24b0430300d4009b0802335f"
    ),
    FieldKeyTestItem(
      input := "0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef",
      offset := 5,
      output := "aecfa53a5f05f6b3b5185584573d527790c8d3504d5a0deb2af3d58c35164d58f232704851f7c9f357dcfb5b"
    ),
    FieldKeyTestItem(
      input := "0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef",
      offset := 6,
      output := "3482b90bb7ddbed3d2b1f270ea648043539d7d6797861ec12c3d0797a07d31ecf3b160aab844008934823436"
    ),
    FieldKeyTestItem(
      input := "0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef",
      offset := 7,
      output := "5c82960fb8370644b7fb7fd41f090e0098f52130379381ed4c21379fa65884e6e1367326c067856388b57589"
    ),
    FieldKeyTestItem(
      input := "59d9a5166a507f3cf0dfd60809a8b387b409d0b0c935abbfe08833fa9ffc1ecc",
      offset := 0,
      output := "d7d8c2e84dd5f56663b98501bf702a04f32451e62a1c30177d89bbf51beadd1090718c72ba120f7f20cf1e97"
    ),
    FieldKeyTestItem(
      input := "59d9a5166a507f3cf0dfd60809a8b387b409d0b0c935abbfe08833fa9ffc1ecc",
      offset := 1,
      output := "fadae5fa4f62e4cbec50d3b4572166fbccc114cb800ed066a4632e966fa18f1189a1fb7cd20ad1c93f29531d"
    ),
    FieldKeyTestItem(
      input := "59d9a5166a507f3cf0dfd60809a8b387b409d0b0c935abbfe08833fa9ffc1ecc",
      offset := 2,
      output := "14db82fab8f6f8e49a8061cf1689172b5bd37508560a8e9d42c21c507657a64a47545b155304c73198847429"
    ),
    FieldKeyTestItem(
      input := "59d9a5166a507f3cf0dfd60809a8b387b409d0b0c935abbfe08833fa9ffc1ecc",
      offset := 3,
      output := "4d83002cf87da3f9670999c707ee4ed8483c297390eb5abb989ea8cb514f4bf27e43bf1f92e6b76c3045080e"
    ),
    FieldKeyTestItem(
      input := "59d9a5166a507f3cf0dfd60809a8b387b409d0b0c935abbfe08833fa9ffc1ecc",
      offset := 4,
      output := "06fbc86f1e9716f218823710ef51b4558476a1cff4e5d706baac5ad14de544eb7e94197677f99cb46e12d63c"
    ),
    FieldKeyTestItem(
      input := "59d9a5166a507f3cf0dfd60809a8b387b409d0b0c935abbfe08833fa9ffc1ecc",
      offset := 5,
      output := "12ede6750d1f02e0aca4b159f4b7aac9fca85355ac7f21e39f44b37e4157dea6f76b9fd44aa7fe540256522b"
    ),
    FieldKeyTestItem(
      input := "59d9a5166a507f3cf0dfd60809a8b387b409d0b0c935abbfe08833fa9ffc1ecc",
      offset := 6,
      output := "7bfd555c3be12c57402b5db97cbfd897aefec952c3ba878642e5b22005cf1074ce854d210ac3c48c5fd0fbe2"
    ),
    FieldKeyTestItem(
      input := "59d9a5166a507f3cf0dfd60809a8b387b409d0b0c935abbfe08833fa9ffc1ecc",
      offset := 7,
      output := "20847d5de204cb578f3012940fa9876ddb3386ae9719cf9adcbdd611385011b2e7d5375fb6d3fd5ea77ba461"
    )
  ]

  method {:test} TestFieldKey() {
    for i := 0 to |FieldKeyTestVector| {
      expect IsHexString(FieldKeyTestVector[i].input);
      var input := FromHexString(FieldKeyTestVector[i].input);
      expect ToHexString(input) == FieldKeyTestVector[i].input;
      expect |input| == KeySize64 as nat;
      expect FieldKeyTestVector[i].offset as nat * 3 < UINT32_LIMIT;
      var result :- expect FieldKey(input, FieldKeyTestVector[i].offset);
      if ToHexString(result) != FieldKeyTestVector[i].output {
        print "\n", FieldKeyTestVector[i].input, "\n", FieldKeyTestVector[i].offset, "\n";
        print "\n", ToHexString(result), "\n", FieldKeyTestVector[i].output, "\n";
      }
      expect ToHexString(result) == FieldKeyTestVector[i].output;
    }
  }
}

/*

These tests generate with :
const crypto = require('crypto');
const fs = require('fs').promises;

function TrussFieldNonce(offset, length) {
	const nonce = Buffer.alloc(16)
	nonce[0]  = 0x41//'A'
	nonce[1]  = 0x77//'w'
	nonce[2]  = 0x73//'s'
	nonce[3]  = 0x44//'D'
	nonce[4]  = 0x62//'b'
	nonce[5]  = 0x65//'e'
	nonce[6]  = 0x46//'F'
	nonce[7]  = 0x69//'i'
	nonce[8]  = 0x65//'e'
	nonce[9]  = 0x6c//'l'
	nonce[10] = 0x64//'d'
	nonce[11] = length & 0xff
	nonce[12] = (offset >>> 24) & 0xff
	nonce[13] = (offset >>> 16) & 0xff
	nonce[14] = (offset >>>  8) & 0xff
	nonce[15] = (offset       ) & 0xff
	return nonce
}

function TrussFieldKey(IKM, offset) {
	if (IKM.length !== 32) {
		throw new Error("Key must be 32 bytes")
	}
	return aes256ctr_stream(
		44,
		IKM,
		TrussFieldNonce(offset * 3, 44)
	)
}

function aes256ctr_stream(length, key, nonce) {
	const aes = crypto.createCipheriv('aes-256-ctr', key, nonce)
	const output = aes.update(Buffer.alloc(length))
	aes.final()
	return output
}

async function generateTestVectors() {
	const inputs = [
		'0000000000000000000000000000000000000000000000000000000000000000',
		'0000000000000000000000000000000000000000000000000000000000000001',
		'ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff',
		'0123456789abcdef0123456789abcdef0123456789abcdef0123456789abcdef',
		// HMAC-SHA512(key = 0x00...00, length = 32, salt = NULL, info = NULL):
		'59d9a5166a507f3cf0dfd60809a8b387b409d0b0c935abbfe08833fa9ffc1ecc'
	]
	const outputs = []
	for (let hex_key of inputs) {
		let ikm = Buffer.from(hex_key, 'hex')
		for (let i = 0; i < 8; i++) {
			outputs.push({
				'input': hex_key,
				'offset': i,
				'output': TrussFieldKey(ikm, i).toString('hex')
			})
		}
	}
	return writeOutputs(outputs)
}

async function writeOutputs(data) {
	await fs.writeFile('truss-kdf-test-vectors.json', JSON.stringify(data, null, 4))
}

generateTestVectors()
	.then(console.log("Done"));

*/
