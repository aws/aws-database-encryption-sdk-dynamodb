# This finds all Dafny projects in this repository
# This makes building root level targets for each project easy
# PROJECTS = $(shell  find . -mindepth 2 -maxdepth 2 -type f -name "Makefile" | xargs dirname | xargs basename)
# for the moment, just the DynamoDbEncryption directory
PROJECTS = "DynamoDbEncryption"

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

format_dafny:
	$(foreach PROJECT, $(PROJECTS), \
		$(MAKE) -C $(PROJECT) format_dafny && \
	) true
