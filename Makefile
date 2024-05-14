# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

# This finds all Dafny projects in this repository
# This makes building root level targets for each project easy
PROJECTS = $(shell  find . -mindepth 2 -maxdepth 2 -type f -name "Makefile" | xargs dirname | xargs basename)

verify:
	$(foreach PROJECT, $(PROJECTS), \
		$(MAKE) -C $(PROJECT) verify CORES=4 && \
	) true

dafny-reportgenerator:
	$(foreach PROJECT, $(PROJECTS), \
		$(MAKE) -C $(PROJECT) dafny-reportgenerator && \
	) true

clean-dafny-report:
	$(foreach PROJECT, $(PROJECTS), \
		$(MAKE) -C $(PROJECT) clean-dafny-report && \
	) true

format_dafny:
	$(foreach PROJECT, $(PROJECTS), \
		$(MAKE) -C $(PROJECT) format_dafny && \
	) true

format_net:
	$(foreach PROJECT, $(PROJECTS), \
		$(MAKE) -C $(PROJECT) format_net && \
	) true

format_java_misc:
	npx prettier --plugin=prettier-plugin-java . --write

format_java_misc-check:
	npx prettier --plugin=prettier-plugin-java . --check

setup_prettier:
	npm i --no-save prettier prettier-plugin-java

polymorph_code_gen:
	$(foreach PROJECT, $(PROJECTS), \
		$(MAKE) -C $(PROJECT) polymorph_code_gen && \
	) true

duvet: | duvet_extract duvet_report

duvet_extract:
	rm -rf compliance
	$(foreach file, $(shell find specification -name '*.md'), duvet extract -o compliance -f MARKDOWN $(file);)

duvet_report:
	duvet \
		report \
		--spec-pattern "compliance/**/*.toml" \
		--source-pattern "DynamoDbEncryption/dafny/**/*.dfy" \
		--source-pattern "DynamoDbEncryption/dafny/**/*.smithy" \
		--source-pattern "DynamoDbEncryption/runtimes/java/src/main/java/**/*.java" \
		--source-pattern "(# //=,# //#).github/workflows/duvet.yaml" \
		--html specification_compliance_report.html
