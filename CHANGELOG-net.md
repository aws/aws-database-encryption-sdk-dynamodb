# Changelog

## [4.0.0](https://github.com/aws/aws-database-encryption-sdk-dynamodb/compare/v3.9.1-net...v4.0.0-net) (2026-05-27)

### ⚠ BREAKING CHANGES

* **java:** add DDBEC with SDK v2 and remove DDBEC with SDK V1 (#2048)
* **.net:** Bump MPL V2 (#2145)

* **java:** add DDBEC with SDK v2 and remove DDBEC with SDK V1 ([#2048](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2048)) ([035dbe3](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/035dbe3b30135d34c94d597fb758440e6f1b5409))

### Features -- All Languages

* **.net:** Bump MPL V2 ([#2145](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2145)) ([87c534b](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/87c534bb2c6b95792b67e30b94d91865e91ffbf0))

### Fixes -- All Languages

* use UUIDs and cleanup in beacon styles example to avoid stale item collisions ([#2125](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2125)) ([773c1ff](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/773c1fff6004a2551a8bea28fd50a93515ccaaf6))

### Maintenance -- All Languages

* **.net:** add ddb local to .net release ([#2075](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2075)) ([db55bdf](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/db55bdfdcf7f74a7f2f9cc1e778448c3f9827e31))
* **.net:** comment out testvectors from release ([#2076](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2076)) ([fdaa9e3](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/fdaa9e3b9c838d7b1db7435dae585e8297038a2d))
* **.net:** fix release commands to include all json tv files ([#2072](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2072)) ([10f809d](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/10f809d1e78e96c7403e4dffc1140fc94c4e73a1))
* **.net:** pin mpl to latest ([#2065](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2065)) ([f6b64a6](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/f6b64a67f6e8e9db79cffcb166a1f18de525674b))
* **.net:** reference submoduled mpl ([#2080](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2080)) ([be3f58f](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/be3f58f8860862d03cf57b51771c0ce2a2a659f9))
* add retries to examples ([#2262](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2262)) ([ab622af](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/ab622afed8425c8c54544d09031a2dd2f8411653))
* add special-characters-workaround to avoid sigv4 failure ([#2270](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2270)) ([7223d98](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/7223d98795755337fb31c5d0592b15f006358bf4))
* bump GitHub Actions to latest versions ([#2144](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2144)) ([92615d4](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/92615d491be0f0ea6905af2a3ca828ed784e915f))
* **ci:** add concurrency control  ([#2265](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2265)) ([85d6be8](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/85d6be85756eac0b7c07aff114fe4662e229a685))
* **ci:** add more error code in infra related failure ([#2254](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2254)) ([7d3b0b5](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/7d3b0b5562d82bd55889c7ef7ef80977efb14dc9))
* **ci:** Add retries to DDB local setup steps  ([#2267](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2267)) ([7987566](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/7987566c847735f4d547f181aab3e47cf40a9a32))
* **ci:** add workflow_dispatch and remove run on PR for daily CI ([#2218](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2218)) ([d6fd0fb](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/d6fd0fbaf2cf7a49af3bdd888423f9ca7787922d))
* **ci:** daily ci for branches ([#2208](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2208)) ([fcc4b97](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/fcc4b97bf1241152cc4b6e4c1d198dbf1967f2e7))
* **ci:** fix Test Examples workflow for v3.x-java daily ci ([#2233](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2233)) ([0140037](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/0140037423dab712abb37ebb67e3b443409f9bd9))
* **ci:** remove branch default to main ([#2219](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2219)) ([1a3d1f0](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/1a3d1f0d41517c0635be261c774e570bf602f001))
* **ci:** retry failed CI only for infrastructure errors ([#2235](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2235)) ([909b34a](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/909b34a8e248e7b02628c59490852b719774bfce))
* **CI:** run clippy ([#2181](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2181)) ([6b54985](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/6b549859115b882411efa27913af8842f5cdd367))
* **ci:** run test on Java 21 and windows OS ([#2159](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2159)) ([6e702d8](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/6e702d87d5c346a6aa54a8bfbee4592361ff906c))
* **ci:** Update daily_ci to get triggered at 7AM ([#2283](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2283)) ([3ed89b5](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/3ed89b54702756f298dc970b3aa62b2e44ad95ae))
* **ci:** use snapshot builds ([#2083](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2083)) ([0124ca6](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/0124ca678782df3da577397bfc12c11ab72965e3))
* **deps:** bump actions/checkout v5->v6 and setup-docker-macos-action v1.0.2->v1.1.0 ([#2130](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2130)) ([337c776](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/337c776b2906b0f2034eb41b08ee9ae95ae4d91d))
* **deps:** update aws-lc-sys requirement from 0.38 to 0.39 in /DynamoDbEncryption/runtimes/rust ([#2149](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2149)) ([b76bcb7](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/b76bcb7833e133c5e640dd2313709f75b5281776))
* refactor non-prod CI to only run Go targets ([#2134](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2134)) ([0d2622c](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/0d2622c6dad4080cc6e977c46434f44b1336214d))
* release aws-db-esdk v1.2.3 ([#2122](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2122)) ([888aaba](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/888aabaf0cff89ce1db508b0e47db1c8515888e7))
* **release:** 4.0.0 ([#2247](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2247)) ([ddf56bf](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/ddf56bf72dd1a53dd0600e7e5e867ed4800b07e8)), closes [#2048](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2048)
* **release:** allow local testing ([#2251](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2251)) ([546b68c](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/546b68cb585dfab003395f3feab164c85459a661))
* run java test on ubuntu ([#2167](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2167)) ([cffa72c](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/cffa72c569e00e8ed976da32560792463df258c1))
* separate changelog for Java and .NET ([#2242](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2242)) ([67ed551](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/67ed55114ccfc6fb2eb44c037ca3d31492614b15))
* use install smithy dafny deps from MPL ([#2266](https://github.com/aws/aws-database-encryption-sdk-dynamodb/issues/2266)) ([4f3b542](https://github.com/aws/aws-database-encryption-sdk-dynamodb/commit/4f3b54292790b1ca17c66a6a7646e9278146e77c))
