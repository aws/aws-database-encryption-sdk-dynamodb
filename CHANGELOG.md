# Changelog

## [3.9.1](https://github.com/aws/aws-database-encryption-sdk-dynamodb/compare/v3.9.0...v3.9.1) (2026-02-06)

This release is available in the following languages:

- .NET

### Fixes

- **java:** drop hkdf offset method ([#2011](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2011)) ([b8f29f9](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/b8f29f914d2c593de83304a186869aec12f020e3))

### Maintenance

- **java:** fix GetEncryptedDataKeyDescription java Example ([#1973](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1973)) ([ba8fcb7](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/ba8fcb7f9aca01ce20cfcd3bc4f2fc0087b5fc9d))
- move go out of pull/push/daily into its own ([#2005](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2005)) ([1b961b5](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/1b961b585e1b2491424b078add248bf7f319f2a3))
- **net:** Add plaintext to encrypted table migration example ([#1976](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1976)) ([814acbf](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/814acbf2ad5d4e0826617b6764b32b16574332ab))
- remove test against latest mpl version ([#2008](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2008)) ([728158e](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/728158e1b0ef83ae41d475bca56419f05928015b))
- **net**: pin to mpl version 1.11.2
- **rust:** add plaintext to encrypted table migration examples ([#1977](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1977)) ([5286619](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/52866190608fcec6bff17adcc01bfd6f04367464))
- **rust:** fips feature ([#1980](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1980)) ([516fd3d](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/516fd3d1e63e2e96b3c8f6feb6f1e85411ab810d))
- **rust:** improved blocking ([#2030](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2030)) ([162c86c](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/162c86c9117bd3048949fa77ab878eee4b6197ff))

## [3.9.0](https://github.com/aws/aws-database-encryption-sdk-dynamodb/compare/v3.8.1...v3.9.0) (2025-06-25)

This release is available in the following languages:

- Java

### Maintenance

- **dafny:** Add ExecuteStatement test ([#1932](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1932)) ([66a19ab](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/66a19ab7d9ddea1018cbb01da053020148e4a1e7))
- **dafny:** Add Update and delete test ([#1942](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1942)) ([3bd48ba](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/3bd48bacc6e9ca458931031062ee97f351f9de32))
- **dafny:** change nat to uint64 in many places ([#1852](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1852)) ([ec22b7d](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/ec22b7d316678f4d836837e751bdfcf41f461441))
- **dafny:** further performance enhancements ([#1834](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1834)) ([ea94693](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/ea9469327109a61e544425479dfb2c6be514ce5a))
- **dafny:** improve performance ([#1900](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1900)) ([ccf61d6](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/ccf61d6a9c49385f1cccde0cda9c0609ba050455))
- **dafny:** improve performance of searchable encryption ([#1931](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1931)) ([8b71004](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/8b710042e1bc0516b70a9f9674edab7f775d236f))
- **dafny:** reduce use of BigInteger ([#1872](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1872)) ([eb7679a](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/eb7679afa9fb6383a76fd71f9e7a4e40bbe53c8a))
- **dafny:** test ExecuteTransaction and BatchExecuteStatement ([#1941](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1941)) ([69c37c6](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/69c37c6a8491b2a5aadf74c4f80355b0593aed32))
- **deps:** Bump MPL version to 1.11.0 ([#1945](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1945)) ([efdd373](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/efdd373ab91fc7465be0f0d05d8018f59131ee6f))
- further performance improvements ([#1826](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1826)) ([3194054](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/3194054eea95c640d0ac469911e950fc76953dd6))
- improve performance ([#1622](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1622)) ([8ca2883](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/8ca288345fe7371711c1c51e1d064538686e25f1))
- update README for missing info ([#1939](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1939)) ([354f4f6](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/354f4f6c48ed6c60914f5ce0feaba64de7ed2587))

## [3.8.1](https://github.com/aws/aws-database-encryption-sdk-dynamodb/compare/v3.8.0...v3.8.1) (2025-04-01)

This release is available in the following languages:

- Java

### Fixes

- return plaintext items in UnprocessedItems in BatchWriteIttem ([#1642](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1642)) ([7c7c8a1](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/7c7c8a112ce0ba54e89eca6d235f6eae45cb9e65))

### Maintenance

- add Rust generated test vectors ([#1638](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1638)) ([a285eac](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/a285eacdd6ed9973ddfece8cfb6ffbcafda2256d))
- bump mpl and smithy-dafny ([#1762](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1762)) ([8179af4](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/8179af4f8f1d0893cccd05a6c6f2f03e45607662))
- **dafny:** let FileIO deal in uint8 rather than bv8 ([#1746](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1746)) ([428a013](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/428a013170894c4cc2ecb2ded2662fa1de1b065e))
- **deps:** bump actions/setup-java from 3 to 4 in /.github/workflows ([#1367](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1367)) ([f04bc40](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/f04bc401e3640355b1646c67380b950790f2019e))
- **deps:** bump actions/setup-java from 3 to 4 in /.github/workflows ([#1654](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1654)) ([ddb69e1](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/ddb69e17e7a70689dd1b31d586645b4834fd9948))
- **deps:** bump org.junit.jupiter:junit-jupiter-api ([#1656](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1656)) ([d988c6e](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/d988c6ebac9379d002314f66ca819e6b49b1d3c7))
- **deps:** bump org.junit.jupiter:junit-jupiter-engine ([#1650](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1650)) ([4f18689](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/4f18689f79243c9a5ab0f3a23108671defddeac4))
- **deps:** bump software.amazon.awssdk:bom ([#1643](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1643)) ([4c41746](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/4c41746db618a901018aa03c679257f52b5f3558))
- **deps:** bump software.amazon.awssdk:bom ([#1644](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1644)) ([84e2c56](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/84e2c560dbcb19eeb5cef40c1761b3d1f745841c))
- **deps:** bump software.amazon.awssdk:core ([#1645](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1645)) ([dec98d6](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/dec98d60dc642bf95b33e8a2eebd8c7ea0da41d3))
- **GHA:** Run Java CI testing for MPL Latest Release ([#1605](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1605)) ([2eb36b3](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/2eb36b32c288f3d3b014523536b99712cfa20ebc))
- **java:** allow local testing v3.8.0 ([#1628](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1628)) ([119a42b](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/119a42b430a0469f017907dde4baa10332ea1575))
- **java:** update versions of lombok and aws-sdk-ddb ([#1646](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1646)) ([099014e](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/099014edd1d3e26bc6fc1c28bab90e69f331aefe))
- re-enable Dafny for MacOS ([#1738](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1738)) ([6f729c3](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/6f729c3a00623efbd11c2584772156926233896d))
- Remove Dafny warnings ([#1742](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1742)) ([4a9d617](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/4a9d61735c1aa88b0ac60d8c066c21cea0af8f6c))
- **rust:** enable wrapped client test vectors ([#1648](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1648)) ([20fee58](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/20fee581d3278bb19416bf97a15eaf6c2a660151))

## [3.8.0](https://github.com/aws/aws-database-encryption-sdk-dynamodb/compare/v3.7.0...v3.8.0) (2025-02-05)

This release is available in the following languages:

- Java

### Features

- **SharedCache:** Shared Cache for Searchable Encryption ([#1476](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1476)) ([46076f8](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/46076f86aec77f7df204c1e06a8ecb2400f01b6f))
- bump to dafny 4.9.0 and mpl 1.9.0 ([#1627](https://github.com/aws/aws-database-encryption-sdk-dynamodb/pull/1627))

### Fixes

- ensure algorithmSuite is properly copied in getTableConfig for E… ([#1474](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1474)) ([ff3acac](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/ff3acaccbb4da8f5c693324631b085d99d8f9222))
- **Java:** Improve Collection of Errors string ([#1478](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1478)) ([562b3ef](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/562b3efbd8b5be54e21dd868dd4a1cb9539ac3a1))
- **SearchableEncryption:** disable shared cached ([#1507](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1507)) ([ffc67be](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/ffc67beac04fac031cad1cab379a3b14669dedc5))
- **SearchableEncryption:** respect CMC contract ([#1434](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1434)) ([b9333fb](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/b9333fbb20cd56a36e32b0cdd71d4e896140d996))
- support new input validation ([#1518](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1518)) ([12bbfbf](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/12bbfbff0b8640e26e188bddabefeccdb43faa95))
- Upgrade .net DDB SDK ([8aeed4e](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/8aeed4e5b901e7882da7d1c17975d77dff0bf028))

### Maintenance

- make const policy an extern ([#1587](https://github.com/aws/aws-database-encryption-sdk-dynamodb/pull/1587)) ([be3b96e](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/be3b96e7d6c441aee3b87862a2989309560413ba))
- mpl: Bump to 1.9.0 ([#1621](https://github.com/aws/aws-database-encryption-sdk-dynamodb/pull/1621)) ([04a8eb2](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/04a8eb2ec84e57b795562618331e9c7e6f0de0c4))
- release Rust 1.0.0 ([#1612](https://github.com/aws/aws-database-encryption-sdk-dynamodb/pull/1612)) ([3392200](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/3392200e2c844710a2d1b6d9c9942c8b9769f71e))
- remove unsafe from interceptor ([#1620](https://github.com/aws/aws-database-encryption-sdk-dynamodb/pull/1620)) ([f6ef3f4](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/f6ef3f4b05010aa06f5a0f7f0d48ca05db4f71f1))
- TestVectors: Reuse single KeyVectors client across TestVectors ([#1577](https://github.com/aws/aws-database-encryption-sdk-dynamodb/pull/1577)) ([dabcaf1](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/dabcaf12c198bd3dda78996a42ae5a5682f2b88a))
- update for async support ([#1560](https://github.com/aws/aws-database-encryption-sdk-dynamodb/pull/1560)) ([700f939](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/700f939e9e5c5e8ed7f7880ea74213231ab6e6ed))
- add dependabot for rust ([#1481](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1481)) ([67f3d2e](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/67f3d2e567b513a53d208f60ec6991a0b6c825d0))
- Add ECDH examples ([#1461](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1461)) ([cc937b4](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/cc937b41190c17e1087acbdcd524becc1a97e214))
- add Rust release directory ([#1479](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1479)) ([97dde01](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/97dde01a3b6d9a33a8b60dcb6e63debc5329d691))
- add rust support ([#1376](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1376)) ([98ddfe9](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/98ddfe95d5a0a3b5986f0493f013bd4edef55d87))
- always use dotnet 6 for format checking. ([#1403](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1403)) ([2b85507](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/2b855078d2fb4fd60b7ecd0c3d1a6d3f1c50e114))
- bump macos from 12 to 13 in CI ([#1472](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1472)) ([1abb2dd](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/1abb2dd7e9b2cadf6301aa5570dd5e5a0bedd4e1))
- Bump to MPL HEAD, Smithy-Dafny HEAD ([#1299](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1299)) ([b2674a9](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/b2674a96dfaa62e151637c7adcb2ab5975b44ffc))
- change exported names, update docs ([#1524](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1524)) ([640b4d7](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/640b4d70744b2d979e4976e0d54639f93fb2e19d))
- **CI:** make smithy fidd check smarter ([#1381](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1381)) ([bb399bf](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/bb399bf0a356827558b3c8a66ec92b2f4128af1c))
- **CI:** mpl head step for rust ([#1583](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1583)) ([98724d3](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/98724d3a7fb16e1d9653c2b2db3aea6dbc47ffcd))
- create Rust release runbook ([#1488](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1488)) ([e51f340](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/e51f340466dcd9ceaea6b46fbd6f127b632600a3))
- enable local testing ([#1380](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1380)) ([36f48b0](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/36f48b00dbae048bfd8f9f01cd93fbc7345d6ad1))
- **examples:** Shared cache across Hierarchical Keyrings ([#1410](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1410)) ([21f7fe1](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/21f7fe168cedc0e6553926c7e3808081f172f7b0))
- **GHA:** Add pr-ci-all-required to pull.yaml; use ubuntu-22.04 instead of ubuntu-latest in CI ([#1579](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1579)) ([c231473](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/c23147393c92686ea05e55610a4af2e9e8788e90))
- **gha:** fix workflows triggered by dafny-interop.yml ([#1598](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1598)) ([0cb009d](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/0cb009dd47266e34d8b5e3f716eec084b4bb5fcc))
- **gha:** use ubuntu-22.04 ([#1594](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1594)) ([5e24233](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/5e2423355fa792353f41b161fd037e55247e074b))
- **Java:** bump conversion library ([#1423](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1423)) ([8931e27](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/8931e274c60a5fdb045dbcf24770820ebe05f741))
- new mpl ([#1530](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1530)) ([fe03425](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/fe03425f078bdad53401c9c602cf684ab8a8e544))
- **README:** point to release examples ([#1525](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1525)) ([a4ca2f9](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/a4ca2f92b6bc79272dd56faf20c952503aa7d99e))
- **Rust-docs:** Update README ([#1520](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1520)) ([96dd848](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/96dd8481d951d1ae74e25259939aa6a4633e91cb))
- **rust:** add comments to release scripts ([7b45929](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/7b45929cf586354ded2f1629b47126e33780de8a))
- slight updates to properly publish as a crate ([#1480](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1480)) ([aa9175b](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/aa9175b14aacbd53e5b60a88f54f3a7276557ad7))
- update for complete copyright notices ([#1489](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1489)) ([c0ec84d](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/c0ec84d4404a289887f693cbda06f7a5cf3baca3))
- update Github alias ([dc6ca47](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/dc6ca479fc7389336bd582ae515233551b9d26b1))
- update Github alias ([ff4500a](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/ff4500a5a63f64788c3a79ce9d155ad3aa749ce8))
- update MPL ([#1519](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1519)) ([b0a97e0](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/b0a97e0c211e083a36791fb48de8efbbbe307b58))

## [3.7.0](https://github.com/aws/aws-database-encryption-sdk-dynamodb/compare/v3.6.2...v3.7.0) (2024-09-17)

### Features

- bump to dafny 4.8.0 and mpl 1.6.0 ([#1356](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1356)) ([fedc0ad](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/fedc0ad2d490eaa853c103cae2cb7406c526a550))

### Fixes

- remove usage of `:|` ([#1320](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1320)) ([eeb3f51](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/eeb3f513ab7a27c62a97529a0a94c1933da1422c))

### Maintenance

- add check only keyword action ([#1327](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1327)) ([5d777d6](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/5d777d6aa975831ef0ce3faeb0b848a1eb108981))
- add ddb local to dafny interop test vectors ([#1316](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1316)) ([6128a39](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/6128a39f13fbd28d25682d8cbf3d6655f1e41fb5))
- allow local testing ([#1311](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1311)) ([e758e97](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/e758e97cafdb32b911737ac73a43091b12d98e31))
- remove /// from smithy files ([#1349](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1349)) ([303a8bd](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/303a8bd4ed2d0bd1b9fd763030c7742058fb6f9f))
- remove assert to fix verification ([#1360](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1360)) ([8849c1e](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/8849c1e5d32f6580ac00cbe3ff6de065a88ca9d2))

## [3.6.2](https://github.com/aws/aws-database-encryption-sdk-dynamodb/compare/v3.6.1...v3.6.2) (2024-08-22)

### Fixes

- revert change in error type ([#1304](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1304)) ([33d7ee4](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/33d7ee4ad73f621a5fb247693981af0d35f40d54))

### Maintenance

- ...the nightly build. Again. ([#1297](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1297)) ([b7a91c9](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/b7a91c91fe5b52cbd9dbec9c3953770ed02fd0bf))
- add timing output to test vectors ([#1298](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1298)) ([30dfaa8](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/30dfaa8dad218c48b115f6244b8125dbc4dad1ea))
- Enable local testing ([#1278](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1278)) ([7093266](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/709326688b84e5255ad8758e7e5c6c25db976e12))
- fix ci mpl head gha ([#1306](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1306)) ([c572d6a](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/c572d6adbebe23ceca2097f1080940583535d286))
- fix dafny interop build steps ([#1293](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1293)) ([c6ce809](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/c6ce809e40032a864e3596ca640ef9225177f98d))
- fix nightly ([#1300](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1300)) ([a445eff](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/a445eff3ac39c4221ef60f59b6386950c06f77a7))
- **GHA:** add backwards interop dafny tests ([#1279](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1279)) ([1e6be80](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/1e6be8056083eb943830729498d55251a2ffde4b))
- **GHA:** another gha fix ([#1292](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1292)) ([df64b30](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/df64b3036d02491801cefd8950d4eda313f3e37a))
- **GHA:** fix dafny_interop_java ([#1283](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1283)) ([5a1c921](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/5a1c92180d24949932f97e9acc0bbe6797306e6e))
- **GHA:** fix test vector dafny interop ([#1291](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1291)) ([fdefaff](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/fdefaff8a66eaf134f9369f9726b4c59ab19364d))
- **GHA:** update nightlies for interop and interop action ([#1287](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1287)) ([8bec538](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/8bec538da1472aca11e06926043919a947b47dcc))

## [3.6.1](https://github.com/aws/aws-database-encryption-sdk-dynamodb/compare/v3.6.0...v3.6.1) (2024-08-12)

### Fixes

- allow multi-tenant queries with allow_plaintext ([#1240](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1240)) ([1487d7e](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/1487d7efe740920b5d8c7b30579947b6b3d26d12))
- **TestVectors:** define StartUpObject in csproj ([#1231](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1231)) ([2f97bf3](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/2f97bf365e2d027103cd9eb2b1951752a3687e3c))
- update error message ([#1270](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1270)) ([7157e4d](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/7157e4d24eb7cc164b3028ec2017074b3397e0d5))

### Maintenance

- Add examples to examine contents of query error list ([#1251](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1251)) ([b5705ee](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/b5705ee12257fb18f867478bf17ba31f50c26c8b))
- **CI:** add smithy diff checker GHA ([#1226](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1226)) ([86406f5](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/86406f5cdcdf2067a27d35f370c5844eab2e23f3))
- **deps:** bump actions/setup-dotnet from 3 to 4 in /.github/workflows ([#1191](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1191)) ([c3b736e](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/c3b736ee714199b15738defd9e37c0f6dcee15ed))
- **deps:** bump aws-actions/configure-aws-credentials ([#1190](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1190)) ([becbd0a](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/becbd0a498830758bc29c86af94790740bc0a93c))
- **deps:** bump com.amazonaws:aws-java-sdk-dynamodb ([#1230](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1230)) ([3aa25d0](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/3aa25d0a93ef5269d9d90efbc1f64de6987064c4))
- **deps:** bump dafny-lang/setup-dafny-action in /.github/workflows ([#1200](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1200)) ([5284f0b](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/5284f0ba413d8ee90289387ca55ea02e6d6d8a08))
- **deps:** bump software.amazon.awssdk:bom ([#1227](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1227)) ([abd1727](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/abd17276a3c8d8bd071edefa709903423c1af8f6))
- **deps:** bump software.amazon.awssdk:bom ([#1229](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1229)) ([bf3e1c3](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/bf3e1c368d562035fc2a093b57f648f69f7f69e8))
- **deps:** bump software.amazon.awssdk:core ([#1228](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1228)) ([9c67729](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/9c67729c58f544dd6e2bd1bf4fabf9cf080d448d))
- do not add beacons when FORCE_PLAINTEXT_WRITE is used. ([#1232](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1232)) ([23c8a18](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/23c8a18ff8d9a49d5ecebf578b3c01d03567620f))
- include bad item keys in query errors ([#1244](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1244)) ([07bba8b](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/07bba8b0415531f4d6eb6c689c6c9c173d870b3e))
- update version to snapshot ([#1225](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1225)) ([c817b5b](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/c817b5bb9bc3b4815a5d0b22939edaa06792123a))

## [3.6.0](https://github.com/aws/aws-database-encryption-sdk-dynamodb/compare/v3.5.0...v3.6.0) (2024-07-23)

### Features

- allow indirect attribute names with MultiKeyStore ([#1208](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1208)) ([4ab97bc](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/4ab97bcc43d0b906e45c487920bc7ef5ba66e505))

### Maintenance

- bump dafny verification version to 4.7 ([#1181](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1181)) ([e7801ec](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/e7801ec42b1bb212af68f9dc0c8037eed9876b5c))
- **CI/CD:** use latest conventional-changelog-conventionalcommits ([#1195](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1195)) ([510227e](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/510227eabb958ff4a17d55fc2eac83f964d6a945))
- Fix nightly build (aside from verification) ([#1029](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1029)) ([862420e](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/862420ef12ef1e764327671d839be451a7579bda))
- **GHA:** add action for testing against MPL HEAD ([#1187](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1187)) ([b2f70ca](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/b2f70ca6733ac522f622014ae6c93bd1a1c15d28))
- **GHA:** fix daily ci ([#1194](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1194)) ([a1427e0](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/a1427e0f7febc10cddd2eccb08385afb2b964367))
- **MPL:** Bump MPL to 1.5.1 ([#1201](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1201)) ([808a5b4](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/808a5b4ad1143ffb8c0bb223fde1e3770c7abe62))
- Sonatype Migration to User Tokens ([#1216](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1216)) ([a3b4ef9](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/a3b4ef9aac11f4a1e1048d938d554c669befc0a6))
- Try to update existing issues ([31c6b98](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/31c6b9806920d500861154eccca07bd8a5ac4454))
- Try to update existing issues ([4471295](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/4471295aa2b7f10e88c3742a41c947d9ad9f4cd2))
- update project.properties to be SNAPSHOT ([#1087](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1087)) ([6f2825e](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/6f2825e198c84a5b20d50e49188b5d9004a1b71a))

## [3.5.0](https://github.com/aws/aws-database-encryption-sdk-dynamodb/compare/v3.4.0...v3.5.0) (2024-05-30)

### Features

- **DynamoDbEncryption:** Add GetEncryptedDataKeyDescription operation ([#856](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/856)) ([8f8471a](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/8f8471a479d9e7526dd8aaa6f34c906d2a0e2dbb))
- Bump MPL to 1.4 ([#1067](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1067)) ([51bbab5](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/51bbab5589a5db611a3b7564a1c9703fb0de1a23)). This provides three new KMSConfiguration options when constructing a KeyStore (see <https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/use-hierarchical-keyring.html>). To KmsKeyArn are added KmsMRKeyArn, Discovery and MrDiscovery.

### Maintenance

- improve verification ([#1020](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1020)) ([cbde4ef](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/cbde4efbd83c57bbbfb96358219dd421141f1da3))
- simplify structured encryption ([#866](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/866)) ([a70a569](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/a70a569d632d051710cfeb37ce27c8785bdba7c2))
- allow Legacy to use subclass of DynamoDBEncryptor ([#1073](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1073)) ([135acd9](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/135acd9871698e76228d6c3ce925bcf589df39c6))
- **Java-Release:** update release commands and use SNAPSHOT builds ([#995](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/995)) ([ac9b79e](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/ac9b79eb18e1904962223e6add153fd49a0f188e))
- reformat and enforce formatting ([#1035](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1035)) ([8a76a9d](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/8a76a9db2e6427b46748b07e654edaf855cd4338))
- verify with Dafny 4.6 ([#1072](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1072)) ([9db6e78](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/9db6e78ee01583dd04238252c939277636fc06ad))

## [3.4.0](https://github.com/aws/aws-database-encryption-sdk-dynamodb/compare/v3.3.0...v3.4.0) (2024-04-30)

### Notes

#### .NET

- [#797](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/797) ([785481c](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/785481c73b385918c5b60301b336ac90f451d307)) Enforces User input Constraints at Type Conversion.

Prior to this fix, unset Integers defaulted to `0`, and unset Booleans defaulted to `false`.

Now, all required fields MUST be set or a Runtime Exception will be thrown.

This particularly effects Searchable Encryption's
`ConstructorPart`, who's required field previously
would have defaulted to false.
Any configuration ever created for Searchable Encryption can be re-created with the fix, but they may look different.

### Features

- **feat(.NET):** Validate user input #797 (785481c)

### Maintenance

- **format:** enforce Dafny formatting ([#865](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/865)) ([dfc0dbd](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/dfc0dbd84f3ab23bd12be6abf8600f472576173e))
- **test:** more test vectors ([#959](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/959)) ([3ca15af](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/3ca15afac59bee530dfffe832af64f5922c73e9a))
- **CI** add verify test for test vectors ([#897](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/897)) ([6c980e7](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/6c980e7f867952442fc686dfa7ef4c82f04362f3))
- **CI/CD:** add semantic release automation ([#949](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/949)) ([3f22abc](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/3f22abcc4c325a7a8df22e5e72cd859905fbd1e9))
- **deps:** bump actions/setup-dotnet from 3 to 4 in /.github/workflows ([#943](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/943)) ([f5d9748](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/f5d974833bf22fe2fcef0ce97da12a92ae9a7ec9))
- **deps:** bump aws-actions/configure-aws-credentials ([#954](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/954)) ([90d7d78](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/90d7d786e17b31ed337334a1e311babc3b63b3de))
- **deps(Java):** bump io.github.gradle-nexus.publish-plugin ([#903](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/903)) ([04c6cc4](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/04c6cc4c3db59f38ab49046abbf6c161cac5ade9))
- **deps(Java):** bump org.projectlombok:lombok ([#838](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/838)) ([56f1cd1](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/56f1cd14d84dd660a62eff7b3e346a621b731de4))
- **deps:** bump rrainn/dynamodb-action in /.github/workflows ([#932](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/932)) ([16e4d7b](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/16e4d7b8c95d0e778c2b552d63be04c1b2b066cb))
- **docs:** mention sign_and_include in javadoc for keyid supplier ([#966](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/966)) ([2796693](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/27966933f280f48ef4d4c96d0e1db065473ae34f))
- **docs:** point to the correct readme ([#845](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/845)) ([b950b4a](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/b950b4a8d1b47d7016b90525849bee77426ffa60))
- **fix:** repair json file names ([#846](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/846)) ([3ca955a](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/3ca955a088db58d336dd779927e7d622e0a4610d))
- **test(.NET):** "dotnet pack" in CI ([#851](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/851)) ([75e44d0](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/75e44d00bf73c1dfdd25f942eed57eddfeba8d65))
- **test:** add tests for attribute names that seem structured ([#964](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/964)) ([c4c0886](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/c4c088661adef70e4e87246a8592f5f49211e0bc))
- **deps(Java & .NET):** Update MPL to 1.3.0 ([#972](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/972)) ([3d8acae](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/3d8acae26c4d6af333b6e654f99baa2de47be9c7))

## 3.2.0 2024-03-20

### Features

- A fourth Crypto Action will be made available : `SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT`, to join the existing `DO_NOTHING`, `SIGN_ONLY` and `ENCRYPT_AND_SIGN`. `SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT` behaves like `SIGN_ONLY`, but also includes the value in the encryption context, making it available to the branch key selector.
- The Parsed Header, returned from EncryptItem and DecryptItem, now returns two more fields
  - encryptionContext : the full encryption context used for encryption
  - selectorContext : the encryption context as presented to the branch key selector
- The Java Enhanced Client now supports Single Table Design. When using the DynamoDbEnhancedTableEncryptionConfig builder, one can now specify `schemaOnEncrypt` multiple times, once for each class being modeled in the table.
- There was a hard limit of 100 on the size of maps and lists in Items to be encrypted. This limit has been removed.

## 3.2.0 2024-01-16

### Features

- support for .NET
- Beacon Styles :
  - PartOnly : save a little bit of space for a beacon that used as part of a Compound Beacon, but never alone
  - AsSet : turn a set of values into a set of beacons, rather than into a single beacon
  - Twinned : calculate beacons for one attribute to be compatible with those from a different attribute
  - TwinnedSet : both AsSet and Twinned
- Global Parts List : all compound beacons can now share a single list of Parts
- Test vectors to ensure cross language compatibility
- explicit error message when searching on a Compound Beacon that could never exist.
- New APIs : ResolveAttributes and GetVirtualFields to assist in development and debugging.

### Fix

- String compare for client side filtering of Scan and Query results could sometimes produce the wrong result for certain characters.

## 3.1.2 2023-11-13

### Fix

Fixed an issue where, when using the DynamoDbEncryptionInterceptor,
an encrypted item in the Attributes field of a DeleteItem, PutItem, or UpdateItem
response was passed through unmodified instead of being decrypted.

## 3.1.1 2023-11-07

### Fix

Issue when a DynamoDB Set attribute is marked as SIGN_ONLY in the AWS Database Encryption SDK (DB-ESDK) for DynamoDB.

DB-ESDK for DynamoDB supports SIGN_ONLY and ENCRYPT_AND_SIGN attribute actions. In version 3.1.0 and below, when a Set type is assigned a SIGN_ONLY attribute action, there is a chance that signature validation of the record containing a Set will fail on read, even if the Set attributes contain the same values. The probability of a failure depends on the order of the elements in the Set combined with how DynamoDB returns this data, which is undefined.

This update addresses the issue by ensuring that any Set values are canonicalized in the same order while written to DynamoDB as when read back from DynamoDB.

See: <https://github.com/aws/aws-database-encryption-sdk-dynamodb-java/tree/v3.1.1/DecryptWithPermute> for additional details for additional details

## 3.1.0 2023-09-07

### Features

- Support underscores in DynamoDB expression attribute names

### Maintenance

- Upgrade various library dependencies
- A variety of fixes to the library's CI and testing

## 3.0.0 2023-07-24

### Features

- Updates to the AWS Cryptographic Material Providers Library for Java,
  a pivotal dependency of the this library,
  introduce Thread Safe Cryptographic Materials Caches (CMCs):
  - Storm Tracking Cache  
    Safe for use in a multi threaded environment,  
    tries to prevent redundant or overly parallel backend calls.  
    See [Spec changes](https://github.com/awslabs/aws-encryption-sdk-specification/blob/ce9a4062124edc5085c66a4f10742e15aa039b34/changes/2023-06-19_thread_safe_cache/change.md) for details.
  - Multi Threaded Cache  
    Safe for use in a multi threaded environment,  
    but no extra functionality
- Examples for using the Enhanced Client via Lombok Annotation and TableSchemaBuilder
- Detection of ignored DynamoDB Encryption Configuration Tags due to Nested Data Models
- Multi Threading Example

### BREAKING CHANGES

- Updates to the AWS Cryptographic Material Providers Library for Java,
  a pivotal dependency of the this library,
  introduce the following breaking changes:
  - CMCs:
    - Original Cryptographic Materials Cache has been renamed to Single Threaded Cache
    - `CreateCryptographicMaterialsCacheInput` now ONLY accepts `CacheType`,  
      which determines which, if any, of the three implemented CMCs will be returned.
    - The `DefaultCache` is `StormTrackingCache`
  - `CreateAwsKmsHierarchicalKeyringInput`:
    - no longer has a `maxCacheSize` field
    - now has an optional `cache` field for a `CacheType`
  - Hierarchical Keyring's Key Store:
    - The Hierarchical Keyring's Key Store's Data Structure has changed.  
      As such, entries persisted in the Key Store with prior versions of this library are NOT compatible.  
      Instead, we recommend Creating a new DynamoDB Table for this version of the Key Store.
    - The Key Store's `CreateKeyInput` now takes:
      - An Optional `String branchKeyIdentifier`
      - An Optional `EncryptionContext encryptionContext`
        - This `encryptionContext` will be added to the Encryption Context sent to KMS prefixed with `aws-crypto-ec:`
    - Creating a Key now also calls KMS:ReEncrypt
    - `CreateKeyStore` no longer creates a GSI
    - The Encryption Context used with KMS' `GenerateDataKeyWithoutPlaintext` no longer includes the discarded GSI's `status`.
    - More details about the Key Store's changes are available in our Specification:
      - [2023-07-12 Update Key Store](https://github.com/awslabs/aws-encryption-sdk-specification/tree/master/changes/2023_7_12_update-keystore-structure)
      - [KeyStore Specification](https://github.com/awslabs/aws-encryption-sdk-specification/blob/master/framework/branch-key-store.md)

### Fix

- With the Enhanced Client, Identify Only Index attributes for Sign Only,
  NOT all Key Attributes, such as Auto Generated Last Modified Time Stamp.

### Maintenance

- A variety of fixes to the libraries CI and testing

## 3.0.0-preview-2 2023-06-09

### Fix

- The AWS SDK Core MUST NOT be depended on directly.

## 3.0.0-preview-1 2023-06-09

### Features

- Initial release of the AWS Database Encryption SDK.
  This release is considered a [developer preview](https://docs.aws.amazon.com/sdkref/latest/guide/maint-policy.html#version-life-cycle)
  and is not intended for production use cases.
