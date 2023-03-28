duvet: | duvet_extract duvet_report

duvet_extract:
	rm -rf compliance
	$(foreach file, $(shell find specification -name '*.md'), duvet extract -o compliance -f MARKDOWN $(file);)

# TODO add these arguments to duvet_report as the work completes
#		--ci \
#		--require-citations true \
#		--require-tests true \

duvet_report:
	duvet \
		report \
		--spec-pattern "compliance/**/*.toml" \
		--source-pattern "DynamoDbEncryption/src/**/*.dfy" \
		--source-pattern "DynamoDbEncryption/test/**/*.dfy" \
		--source-pattern "DynamoDbEncryption/Model/**/*.smithy" \
		--html specification_compliance_report.html
