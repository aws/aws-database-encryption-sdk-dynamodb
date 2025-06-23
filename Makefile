# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

PROJECT_ROOT := $(abspath $(dir $(abspath $(lastword $(MAKEFILE_LIST)))))

# This finds all Dafny projects in this repository
# This makes building root level targets for each project easy
PROJECTS = $(shell  find . -mindepth 2 -maxdepth 2 -type f -name "Makefile" | xargs dirname)

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
		--html specification_compliance_report.html

format_all: format_dafny format_net format_java_misc

format_dafny:
	$(foreach PROJECT, $(PROJECTS), \
		$(MAKE) -C $(PROJECT) format_dafny && \
	) true

format_dafny-check:
	$(foreach PROJECT, $(PROJECTS), \
		$(MAKE) -C $(PROJECT) format_dafny-check && \
	) true

format_net:
	$(foreach PROJECT, $(PROJECTS), \
		$(MAKE) -C $(PROJECT) format_net && \
	) true

format_net-check:
	$(foreach PROJECT, $(PROJECTS), \
		$(MAKE) -C $(PROJECT) format_net-check && \
	) true

format_java_misc: setup_prettier
	npx prettier --plugin=prettier-plugin-java . --write

format_java_misc-check: setup_prettier
	npx prettier --plugin=prettier-plugin-java . --check

setup_prettier:
	npm i --no-save prettier@3.5.3 prettier-plugin-java@2.5

# Generate the top-level project.properties file using smithy-dafny.
# This is for the benefit of the nightly Dafny CI,
# to verify that everything works with the latest Dafny prerelease.
# We use smithy-dafny rather than just cat-ing the file directly
# because smithy-dafny currently maintains the knowledge
# of how Dafny release versions maps to Dafny runtime library versions,
# especially prerelease versions like 4.4.0-nightly-2024-01-30-908f95f.
#
# Note we generate to a different file than the checked-in project.properties,
# because in this repo that file has other properties as well,
# so we need to merge the two versions.
# See .github/actions/polymorph_codegen/action.yml.
generate_properties_file: 
	cd submodules/smithy-dafny/codegen/smithy-dafny-codegen-cli; \
	./../gradlew run --args="\
	--dafny-version ${DAFNY_VERSION} \
	--library-root $(PROJECT_ROOT)/submodules/MaterialProviders/StandardLibrary \
	--model $(PROJECT_ROOT)/submodules/MaterialProviders/StandardLibrary/Model \
	--dependent-model $(PROJECT_ROOT)/submodules/MaterialProviders/StandardLibrary/Model \
	--namespace aws.polymorph \
	--properties-file $(PROJECT_ROOT)/smithy-dafny-project.properties \
	";

setup_semantic_release:
	npm i --no-save semantic-release @semantic-release/changelog semantic-release-replace-plugin conventional-changelog-conventionalcommits @semantic-release/git

run_semantic_release:
	npx semantic-release --no-ci

dry_run_semantic_release:
	npx semantic-release --dry-run
