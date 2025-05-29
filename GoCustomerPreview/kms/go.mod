module github.com/aws/aws-cryptographic-material-providers-library/releases/go/kms

go 1.23.0

require github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library v0.0.0

require (
	github.com/aws/aws-sdk-go-v2/config v1.29.14
	github.com/aws/aws-sdk-go-v2/service/kms v1.38.3
	github.com/aws/smithy-go v1.22.3
	github.com/dafny-lang/DafnyRuntimeGo/v4 v4.10.1
)

require (
	github.com/aws/aws-sdk-go-v2 v1.36.3 // indirect
	github.com/aws/aws-sdk-go-v2/credentials v1.17.67 // indirect
	github.com/aws/aws-sdk-go-v2/feature/ec2/imds v1.16.30 // indirect
	github.com/aws/aws-sdk-go-v2/internal/configsources v1.3.34 // indirect
	github.com/aws/aws-sdk-go-v2/internal/endpoints/v2 v2.6.34 // indirect
	github.com/aws/aws-sdk-go-v2/internal/ini v1.8.3 // indirect
	github.com/aws/aws-sdk-go-v2/service/internal/accept-encoding v1.12.3 // indirect
	github.com/aws/aws-sdk-go-v2/service/internal/presigned-url v1.12.15 // indirect
	github.com/aws/aws-sdk-go-v2/service/sso v1.25.3 // indirect
	github.com/aws/aws-sdk-go-v2/service/ssooidc v1.30.1 // indirect
	github.com/aws/aws-sdk-go-v2/service/sts v1.33.19 // indirect
)

replace github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library => ../smithy-dafny-standard-library
