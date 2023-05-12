duvet: | duvet_extract duvet_report

duvet_extract:
	rm -rf compliance
	$(foreach file, $(shell find specification -name '*.md'), duvet extract -o compliance -f MARKDOWN $(file);)

# TODO add these arguments to duvet_report as the work completes
#		--ci \
#		--require-citations true \
#		--require-tests true \

# Duvet only accepts Comment syntax,
# not Toml,
# or we would store compliance_exceptions as .toml instead .txt

duvet_report:
	duvet \
		report \
		--spec-pattern "compliance/**/*.toml" \
		--source-pattern "DynamoDbEncryption/dafny/**/*.dfy" \
		--source-pattern "DynamoDbEncryption/dafny/**/*.smithy" \
		--source-pattern "DynamoDbEncryption/runtimes/java/src/main/java/**/*.java" \
		--source-pattern "DynamoDbEncryption/compliance_exceptions/**/*.txt" \
		--html specification_compliance_report.html
