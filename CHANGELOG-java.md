# Changelog

## [4.0.0](https://github.com/aws/aws-database-encryption-sdk-dynamodb/compare/v3.9.0-java...v4.0.0-java) (2026-04-29)

### ⚠ BREAKING CHANGES

* **java:** add DDBEC with SDK v2 and remove DDBEC with SDK V1 (#2048)
  * The AWS Database Encryption SDK for DynamoDB will NOT support AWS SDK for Java 1.x in the embedded 2.x version (which was known as DynamoDB Encryption Client(DDBEC)). The embedded DDBEC will now use AWS SDK for Java 2.x. These changes are limited to embedded DDBEC and rest of DB-ESDK has no code changes.
  * If consumer of DB-ESDK is using APIs from namespace `com.amazonaws.services.dynamodbv2` through DB-ESDK then they have to migrate to use corresponding API from namespace `com.amazonaws.services.dynamodbv2.datamodeling.sdkv2`. If consumer of DB-ESDK are NOT using namespace `com.amazonaws.services.dynamodbv2` through DB-ESDK then there will not be any breaking change when moving to next major version.

### Features -- Java

* **java:** add DDBEC with SDK v2 and remove DDBEC with SDK V1 ([#2048](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2048)) ([035dbe3](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/035dbe3b30135d34c94d597fb758440e6f1b5409))

### Fixes -- All Languages

* use UUIDs and cleanup in beacon styles example to avoid stale item collisions ([#2125](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2125)) ([773c1ff](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/773c1fff6004a2551a8bea28fd50a93515ccaaf6))

### Fixes -- Java

* **java:** drop hkdf offset method ([#2011](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2011)) ([b8f29f9](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/b8f29f914d2c593de83304a186869aec12f020e3))

### Maintenance -- All Languages

* **dafny:** bump MPL and update mutable map ([#1974](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1974)) ([e9ea870](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/e9ea870eb2d7d885f063cb53fd17c83526ba69ca))
* **dafny:** bump smithy dafny  ([#1971](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1971)) ([85309a0](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/85309a023d4aeeeeae5106fd904a3dd23fd728cb))

### Maintenance -- Java

* **java:** Allow local testing ([#1947](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1947)) ([bf5a106](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/bf5a106ccaa816de9c1e4f0eacaf84c9f915b752))
* **java:** Attempt to reduce flaky CI ([#2220](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2220)) ([987aec6](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/987aec6183b4b8d6e83fd886a6db63d3f43a9e9b))
* **java:** attempt to reduce flaky CI failures ([#2203](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2203)) ([b4d88f1](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/b4d88f1f9e2f3adb86589cdaaa68c2b117fd7d78))
* **java:** bring back test against released MPL version ([#2226](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2226)) ([a340b34](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/a340b346b2f694193f5351e61f501da69f5b827d))
* **java:** fix GetEncryptedDataKeyDescription java Example  ([#1973](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1973)) ([ba8fcb7](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/ba8fcb7f9aca01ce20cfcd3bc4f2fc0087b5fc9d))
* **java:** retry failed workflow ([#2229](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2229)) ([2668d68](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/2668d687fbb3bfbdc7243cf5f7f7c0d085e70ebb))
* **java:** shut down local DDB in test ([#2176](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2176)) ([fa1e151](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/fa1e151fed1ca3dcd1fff14fe13af1c95d3fe61d))

### Miscellaneous

* Add go to smithy dependencies ([#1986](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1986)) ([066c0ca](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/066c0ca9b92d72897aae0699d05c4c52a1e3c8c8))
* add managed policy to cfn template ([#2012](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2012)) ([915183d](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/915183d854cf645da39083e1df374a2a27a4b776))
* bump GitHub Actions to latest versions ([#2144](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2144)) ([92615d4](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/92615d491be0f0ea6905af2a3ca828ed784e915f))
* bump mpl ([#1953](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1953)) ([4e295f9](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/4e295f96ff2165af3a73ea9d43f9c808394cbd05))
* bump MPL and reuse release script from MPL   ([#1963](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1963)) ([eb52fca](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/eb52fca2e8e05b0d65c4048b2a7fcabe8ca0a977))
* bump mpl and smithy dafny ([#1982](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1982)) ([c71fc82](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/c71fc825ff7271484cf3136dcc3c62438e9e01da))
* bump mpl to allow nightly build ([#1984](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1984)) ([208eb31](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/208eb313d88ad3eb0ed845a7e3c31beffd8a2358))
* **cfn:** add DescribeTable permission ([#1952](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1952)) ([f24a0d3](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/f24a0d3b80b34afb4f2c2e6ec97c2ac64e7e4efa))
* **CI:** add slack notifications  ([#1964](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1964)) ([139c856](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/139c856bff54ddbdb86e379d4ed762e05af5da2d))
* **ci:** add workflow_dispatch and remove run on PR for daily CI ([#2218](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2218)) ([d6fd0fb](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/d6fd0fbaf2cf7a49af3bdd888423f9ca7787922d))
* **ci:** daily ci for branches ([#2208](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2208)) ([fcc4b97](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/fcc4b97bf1241152cc4b6e4c1d198dbf1967f2e7))
* **CI:** fix dafny_interop to setup_net ([#1965](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1965)) ([e7a5a02](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/e7a5a0282d6a46e31e0b1b7604f82a1e0a1d10f5))
* **ci:** fix Test Examples workflow for v3.x-java daily ci ([#2233](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2233)) ([0140037](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/0140037423dab712abb37ebb67e3b443409f9bd9))
* **ci:** remove branch default to main ([#2219](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2219)) ([1a3d1f0](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/1a3d1f0d41517c0635be261c774e570bf602f001))
* **CI:** remove redundant dotnet run ([#2038](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2038)) ([09c3266](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/09c326695d41001d7cd747790caf4179f231a333))
* **ci:** retry failed CI only for infrastructure errors ([#2235](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2235)) ([909b34a](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/909b34a8e248e7b02628c59490852b719774bfce))
* **CI:** run clippy ([#2181](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2181)) ([6b54985](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/6b549859115b882411efa27913af8842f5cdd367))
* **ci:** run test on Java 21 and windows OS ([#2159](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2159)) ([6e702d8](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/6e702d87d5c346a6aa54a8bfbee4592361ff906c))
* **ci:** use snapshot builds ([#2083](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2083)) ([0124ca6](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/0124ca678782df3da577397bfc12c11ab72965e3))
* **deps:** bump actions/checkout v5->v6 and setup-docker-macos-action v1.0.2->v1.1.0 ([#2130](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2130)) ([337c776](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/337c776b2906b0f2034eb41b08ee9ae95ae4d91d))
* **deps:** update aws-lc-sys requirement ([#2019](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2019)) ([c397bf2](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/c397bf2d2f125d6f11460dc80a0d18c790111693))
* **deps:** update aws-lc-sys requirement from 0.38 to 0.39 in /DynamoDbEncryption/runtimes/rust ([#2149](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2149)) ([b76bcb7](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/b76bcb7833e133c5e640dd2313709f75b5281776))
* fix non prod daily CI for Go ([#2006](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2006)) ([f8d8f08](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/f8d8f088226a5e348b7a34adb88402f376b6a26b))
* fix non-prod.yml ([#2007](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2007)) ([43b5163](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/43b5163378235bf6bffe336e8a2b9482d8f03c2f))
* move go out of pull/push/daily into its own ([#2005](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2005)) ([1b961b5](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/1b961b585e1b2491424b078add248bf7f319f2a3))
* refactor non-prod CI to only run Go targets ([#2134](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2134)) ([0d2622c](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/0d2622c6dad4080cc6e977c46434f44b1336214d))
* release aws-db-esdk v1.2.3 ([#2122](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2122)) ([888aaba](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/888aabaf0cff89ce1db508b0e47db1c8515888e7))
* **release:** 3.9.1 ([#2061](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2061)) ([0e5507c](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/0e5507c61e5935b5db87cf763ba06a0f02922518))
* remove test against latest mpl version ([#2008](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2008)) ([728158e](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/728158e1b0ef83ae41d475bca56419f05928015b))
* run java test on ubuntu ([#2167](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2167)) ([cffa72c](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/cffa72c569e00e8ed976da32560792463df258c1))
* separate changelog for Java and .NET ([#2242](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2242)) ([67ed551](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/67ed55114ccfc6fb2eb44c037ca3d31492614b15))
* **TestVectors:** add config tests for new attributes ([#1967](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1967)) ([4017a97](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/4017a97f8398128350e97ecfa69ac195a8b74fcf))
* update check-files ([#2041](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2041)) ([0bafe07](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/0bafe07693359e8558a5d00f32f846f8fbe7a234))
* update mpl ([#1991](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1991)) ([fed53bf](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/fed53bfbe33633353d61dbd36551f0c37b81608d))
* use macos-14 for CI ([#1998](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1998)) ([e0d2b77](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/e0d2b77d2a8a3a5717af277133be179867bc1ca6))

### Miscellaneous -- All Languages

* **go:** change Go module name for DB-ESDK ([#1949](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/1949)) ([9825a4c](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/9825a4cc75de3989eaefae760da69a1ea9158ae5))
