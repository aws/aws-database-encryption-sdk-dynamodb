verify:
	CORES=4 $(MAKE) -C DynamoDbItemEncryptor verify
	CORES=4 $(MAKE) -C DynamoDbEncryptionMiddlewareInternal verify
	CORES=4 $(MAKE) -C StructuredEncryption verify

duvet: | duvet_extract duvet_report

duvet_extract:
	rm -rf compliance
	$(foreach file, $(shell find specification/dynamodb-encryption-client -name '*.md'), duvet extract -o compliance -f MARKDOWN $(file);)

# TODO add Structured Encryption specs

# TODO add these arguments to duvet_report as the work completes
#		--ci \
#		--require-citations true \
#		--require-tests true \

duvet_report:
	duvet \
		report \
		--spec-pattern "compliance/**/*.toml" \
		--source-pattern "DynamoDbItemEncryptor/src/**/*.dfy" \
		--source-pattern "DynamoDbItemEncryptor/Model/**/*.smithy" \
		--source-pattern "DynamoDbItemEncryptor/compliance_exceptions/**/*.txt" \
		--source-pattern "DynamoDbEncryptionMiddlewareInternal/src/**/*.dfy" \
		--source-pattern "DynamoDbEncryptionMiddlewareInternal/Model/**/*.smithy" \
		--source-pattern "DynamoDbEncryptionMiddlewareInternal/compliance_exceptions/**/*.txt" \
		--html specification_compliance_report.html
