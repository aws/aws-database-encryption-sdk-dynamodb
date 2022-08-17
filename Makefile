build:
	cd src/StructuredEncryption/src;\
	dotnet build

test: build
	cd src/StructuredEncryption/runtimes/net;\
	dotnet test -f netcoreapp3.1 Test

generate-models:
	cd polymorph/smithy-dotnet;\
	./gradlew run --args="\
		-m src/StructuredEncryption/model\
		-namespace aws.cryptography.structuredEncryption\
		--output-dotnet src/StructuredEncryption/runtimes/net/Generated\
		-d src/StructuredEncryption/model"