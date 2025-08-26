module github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/examples

go 1.23.2

require (
	github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl v0.2.1
	github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk v0.0.0
	github.com/aws/aws-sdk-go-v2 v1.38.1
	github.com/aws/aws-sdk-go-v2/config v1.31.3
	github.com/aws/aws-sdk-go-v2/credentials v1.18.7
	github.com/aws/aws-sdk-go-v2/service/dynamodb v1.49.1
	github.com/aws/aws-sdk-go-v2/service/kms v1.44.2
	github.com/aws/aws-sdk-go-v2/service/sts v1.38.0
	github.com/aws/smithy-go v1.22.5
	github.com/google/uuid v1.6.0
)

require (
	github.com/aws/aws-cryptographic-material-providers-library/releases/go/dynamodb v0.2.2 // indirect
	github.com/aws/aws-cryptographic-material-providers-library/releases/go/kms v0.2.2 // indirect
	github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives v0.2.2 // indirect
	github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library v0.2.2 // indirect
	github.com/aws/aws-sdk-go-v2/feature/ec2/imds v1.18.4 // indirect
	github.com/aws/aws-sdk-go-v2/internal/configsources v1.4.4 // indirect
	github.com/aws/aws-sdk-go-v2/internal/endpoints/v2 v2.7.4 // indirect
	github.com/aws/aws-sdk-go-v2/internal/ini v1.8.3 // indirect
	github.com/aws/aws-sdk-go-v2/service/internal/accept-encoding v1.13.0 // indirect
	github.com/aws/aws-sdk-go-v2/service/internal/endpoint-discovery v1.11.4 // indirect
	github.com/aws/aws-sdk-go-v2/service/internal/presigned-url v1.13.4 // indirect
	github.com/aws/aws-sdk-go-v2/service/sso v1.28.2 // indirect
	github.com/aws/aws-sdk-go-v2/service/ssooidc v1.34.0 // indirect
	github.com/dafny-lang/DafnyRuntimeGo/v4 v4.11.0 // indirect
)

replace github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk => ../
