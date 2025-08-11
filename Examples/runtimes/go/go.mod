module github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/examples

go 1.23.2

replace github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk => ../../../DynamoDbEncryption/runtimes/go/ImplementationFromDafny-go

// replace github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl => ../../../submodules/MaterialProviders/AwsCryptographicMaterialProviders/runtimes/go/ImplementationFromDafny-go/

// replace github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives => ../../../submodules/MaterialProviders/AwsCryptographyPrimitives/runtimes/go/ImplementationFromDafny-go/

// replace github.com/aws/aws-cryptographic-material-providers-library/releases/go/dynamodb => ../../../submodules/MaterialProviders/ComAmazonawsDynamodb/runtimes/go/ImplementationFromDafny-go/

// replace github.com/aws/aws-cryptographic-material-providers-library/releases/go/kms => ../../../submodules/MaterialProviders/ComAmazonawsKms/runtimes/go/ImplementationFromDafny-go/

// replace github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library => ../../../submodules/MaterialProviders/StandardLibrary/runtimes/go/ImplementationFromDafny-go/

require (
	github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl v0.2.1
	github.com/aws/aws-cryptographic-material-providers-library/releases/go/dynamodb v0.0.0 
	github.com/aws/aws-cryptographic-material-providers-library/releases/go/kms v0.0.0
	github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives v0.0.0
	github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk v0.0.0
	github.com/aws/aws-sdk-go-v2 v1.37.2
	github.com/aws/aws-sdk-go-v2/config v1.30.3
	github.com/aws/aws-sdk-go-v2/credentials v1.18.3
	github.com/aws/aws-sdk-go-v2/service/dynamodb v1.46.0
	github.com/aws/aws-sdk-go-v2/service/kms v1.43.0
	github.com/aws/aws-sdk-go-v2/service/sts v1.36.0
)

require (
	github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library v0.2.1 // indirect
	github.com/aws/aws-sdk-go-v2/feature/ec2/imds v1.18.2 // indirect
	github.com/aws/aws-sdk-go-v2/internal/configsources v1.4.2 // indirect
	github.com/aws/aws-sdk-go-v2/internal/endpoints/v2 v2.7.2 // indirect
	github.com/aws/aws-sdk-go-v2/internal/ini v1.8.3 // indirect
	github.com/aws/aws-sdk-go-v2/service/internal/accept-encoding v1.13.0 // indirect
	github.com/aws/aws-sdk-go-v2/service/internal/endpoint-discovery v1.11.2 // indirect
	github.com/aws/aws-sdk-go-v2/service/internal/presigned-url v1.13.2 // indirect
	github.com/aws/aws-sdk-go-v2/service/sso v1.27.0 // indirect
	github.com/aws/aws-sdk-go-v2/service/ssooidc v1.32.0 // indirect
	github.com/aws/smithy-go v1.22.5 // indirect
	github.com/dafny-lang/DafnyRuntimeGo/v4 v4.10.1 // indirect
	github.com/google/uuid v1.6.0 // indirect
)
