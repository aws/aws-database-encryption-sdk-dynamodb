package dbesdkmiddleware

import (
	"context"

	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/awscryptographydbencryptionsdkdynamodbsmithygeneratedtypes"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/awscryptographydbencryptionsdkdynamodbtransformssmithygenerated"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/awscryptographydbencryptionsdkdynamodbtransformssmithygeneratedtypes"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb"
	"github.com/aws/smithy-go/middleware"
)

const (
	// ContextKeyOriginalInput is the key used to store the original DynamoDB input in the context
	ContextKeyOriginalInput = "originalInput"
)

type DBEsdkMiddleware struct {
	client *awscryptographydbencryptionsdkdynamodbtransformssmithygenerated.Client
}

func NewDBEsdkMiddleware(config awscryptographydbencryptionsdkdynamodbsmithygeneratedtypes.DynamoDbTablesEncryptionConfig) (*DBEsdkMiddleware, error) {
	client, err := awscryptographydbencryptionsdkdynamodbtransformssmithygenerated.NewClient(config)
	if err != nil {
		return nil, err
	}
	return &DBEsdkMiddleware{
		client: client,
	}, nil
}

func (m DBEsdkMiddleware) CreateMiddleware() func(options *dynamodb.Options) {
	return func(options *dynamodb.Options) {
		options.APIOptions = append(options.APIOptions, func(stack *middleware.Stack) error {
			// Add request interceptor at the beginning of Initialize step
			requestIntercetor := m.createRequestInterceptor()
			if err := stack.Initialize.Add(requestIntercetor, middleware.Before); err != nil {
				return err
			}
			// Add response interceptor at the end of Finalize step
			return stack.Finalize.Add(m.createResponseInterceptor(), middleware.After)
		})
	}
}

func (m DBEsdkMiddleware) createRequestInterceptor() middleware.InitializeMiddleware {
	return middleware.InitializeMiddlewareFunc("aws-dbesdk-request-interceptor", func(
		ctx context.Context, in middleware.InitializeInput, next middleware.InitializeHandler,
	) (
		out middleware.InitializeOutput, metadata middleware.Metadata, err error,
	) {
		ctx, err = m.handleRequestInterception(ctx, in.Parameters)
		if err != nil {
			return middleware.InitializeOutput{}, middleware.Metadata{}, err
		}
		return next.HandleInitialize(ctx, in)
	})
}

// handleRequestInterception handles the interception logic before the DynamoDB operation
func (m DBEsdkMiddleware) handleRequestInterception(ctx context.Context, request interface{}) (context.Context, error) {
	switch v := request.(type) {
	case *dynamodb.PutItemInput:
		ctx = middleware.WithStackValue(ctx, ContextKeyOriginalInput, *v)
		// Note: this context is not propagated downstream into dafny layer https://issues.amazon.com/CrypTool-5403
		transformedRequest, err := m.client.PutItemInputTransform(ctx, awscryptographydbencryptionsdkdynamodbtransformssmithygeneratedtypes.PutItemInputTransformInput{
			SdkInput: *v,
		})
		if err != nil {
			return nil, err
		}
		*v = transformedRequest.TransformedInput
	case *dynamodb.GetItemInput:
		ctx = middleware.WithStackValue(ctx, ContextKeyOriginalInput, *v)
		// Note: this context is not propagated downstream into dafny layer https://issues.amazon.com/CrypTool-5403
		transformedRequest, err := m.client.GetItemInputTransform(ctx, awscryptographydbencryptionsdkdynamodbtransformssmithygeneratedtypes.GetItemInputTransformInput{
			SdkInput: *v,
		})
		if err != nil {
			return nil, err
		}
		*v = transformedRequest.TransformedInput
	case *dynamodb.BatchGetItemInput:
		ctx = middleware.WithStackValue(ctx, ContextKeyOriginalInput, *v)
		// Note: this context is not propagated downstream into dafny layer https://issues.amazon.com/CrypTool-5403
		transformedRequest, err := m.client.BatchGetItemInputTransform(ctx, awscryptographydbencryptionsdkdynamodbtransformssmithygeneratedtypes.BatchGetItemInputTransformInput{
			SdkInput: *v,
		})
		if err != nil {
			return nil, err
		}
		*v = transformedRequest.TransformedInput
	case *dynamodb.BatchWriteItemInput:
		ctx = middleware.WithStackValue(ctx, ContextKeyOriginalInput, *v)
		// Note: this context is not propagated downstream into dafny layer https://issues.amazon.com/CrypTool-5403
		transformedRequest, err := m.client.BatchWriteItemInputTransform(ctx, awscryptographydbencryptionsdkdynamodbtransformssmithygeneratedtypes.BatchWriteItemInputTransformInput{
			SdkInput: *v,
		})
		if err != nil {
			return nil, err
		}
		*v = transformedRequest.TransformedInput
	case *dynamodb.BatchExecuteStatementInput:
		ctx = middleware.WithStackValue(ctx, ContextKeyOriginalInput, *v)
		// Note: this context is not propagated downstream into dafny layer https://issues.amazon.com/CrypTool-5403
		transformedRequest, err := m.client.BatchExecuteStatementInputTransform(ctx, awscryptographydbencryptionsdkdynamodbtransformssmithygeneratedtypes.BatchExecuteStatementInputTransformInput{
			SdkInput: *v,
		})
		if err != nil {
			return nil, err
		}
		*v = transformedRequest.TransformedInput
	case *dynamodb.DeleteItemInput:
		ctx = middleware.WithStackValue(ctx, ContextKeyOriginalInput, *v)
		// Note: this context is not propagated downstream into dafny layer https://issues.amazon.com/CrypTool-5403
		transformedRequest, err := m.client.DeleteItemInputTransform(ctx, awscryptographydbencryptionsdkdynamodbtransformssmithygeneratedtypes.DeleteItemInputTransformInput{
			SdkInput: *v,
		})
		if err != nil {
			return nil, err
		}
		*v = transformedRequest.TransformedInput
	case *dynamodb.ExecuteStatementInput:
		ctx = middleware.WithStackValue(ctx, ContextKeyOriginalInput, *v)
		// Note: this context is not propagated downstream into dafny layer https://issues.amazon.com/CrypTool-5403
		transformedRequest, err := m.client.ExecuteStatementInputTransform(ctx, awscryptographydbencryptionsdkdynamodbtransformssmithygeneratedtypes.ExecuteStatementInputTransformInput{
			SdkInput: *v,
		})
		if err != nil {
			return nil, err
		}
		*v = transformedRequest.TransformedInput
	case *dynamodb.ExecuteTransactionInput:
		ctx = middleware.WithStackValue(ctx, ContextKeyOriginalInput, *v)
		// Note: this context is not propagated downstream into dafny layer https://issues.amazon.com/CrypTool-5403
		transformedRequest, err := m.client.ExecuteTransactionInputTransform(ctx, awscryptographydbencryptionsdkdynamodbtransformssmithygeneratedtypes.ExecuteTransactionInputTransformInput{
			SdkInput: *v,
		})
		if err != nil {
			return nil, err
		}
		*v = transformedRequest.TransformedInput
	case *dynamodb.QueryInput:
		ctx = middleware.WithStackValue(ctx, ContextKeyOriginalInput, *v)
		// Note: this context is not propagated downstream into dafny layer https://issues.amazon.com/CrypTool-5403
		transformedRequest, err := m.client.QueryInputTransform(ctx, awscryptographydbencryptionsdkdynamodbtransformssmithygeneratedtypes.QueryInputTransformInput{
			SdkInput: *v,
		})
		if err != nil {
			return nil, err
		}
		*v = transformedRequest.TransformedInput
	case *dynamodb.ScanInput:
		ctx = middleware.WithStackValue(ctx, ContextKeyOriginalInput, *v)
		// Note: this context is not propagated downstream into dafny layer https://issues.amazon.com/CrypTool-5403
		transformedRequest, err := m.client.ScanInputTransform(ctx, awscryptographydbencryptionsdkdynamodbtransformssmithygeneratedtypes.ScanInputTransformInput{
			SdkInput: *v,
		})
		if err != nil {
			return nil, err
		}
		*v = transformedRequest.TransformedInput
	case *dynamodb.TransactGetItemsInput:
		ctx = middleware.WithStackValue(ctx, ContextKeyOriginalInput, *v)
		// Note: this context is not propagated downstream into dafny layer https://issues.amazon.com/CrypTool-5403
		transformedRequest, err := m.client.TransactGetItemsInputTransform(ctx, awscryptographydbencryptionsdkdynamodbtransformssmithygeneratedtypes.TransactGetItemsInputTransformInput{
			SdkInput: *v,
		})
		if err != nil {
			return nil, err
		}
		*v = transformedRequest.TransformedInput
	case *dynamodb.TransactWriteItemsInput:
		ctx = middleware.WithStackValue(ctx, ContextKeyOriginalInput, *v)
		// Note: this context is not propagated downstream into dafny layer https://issues.amazon.com/CrypTool-5403
		transformedRequest, err := m.client.TransactWriteItemsInputTransform(ctx, awscryptographydbencryptionsdkdynamodbtransformssmithygeneratedtypes.TransactWriteItemsInputTransformInput{
			SdkInput: *v,
		})
		if err != nil {
			return nil, err
		}
		*v = transformedRequest.TransformedInput
	case *dynamodb.UpdateItemInput:
		ctx = middleware.WithStackValue(ctx, ContextKeyOriginalInput, *v)
		// Note: this context is not propagated downstream into dafny layer https://issues.amazon.com/CrypTool-5403
		transformedRequest, err := m.client.UpdateItemInputTransform(ctx, awscryptographydbencryptionsdkdynamodbtransformssmithygeneratedtypes.UpdateItemInputTransformInput{
			SdkInput: *v,
		})
		if err != nil {
			return nil, err
		}
		*v = transformedRequest.TransformedInput
	}
	return ctx, nil
}

// createResponseInterceptor creates and returns the middleware interceptor for responses
func (m DBEsdkMiddleware) createResponseInterceptor() middleware.FinalizeMiddleware {
	return middleware.FinalizeMiddlewareFunc("aws-dbesdk-response-interceptor", func(
		ctx context.Context, in middleware.FinalizeInput, next middleware.FinalizeHandler,
	) (
		out middleware.FinalizeOutput, metadata middleware.Metadata, err error,
	) {
		// First let the request complete
		result, metadata, err := next.HandleFinalize(ctx, in)
		if err != nil {
			return result, metadata, err
		}
		// Then intercept the response
		err = m.handleResponseInterception(ctx, result.Result)
		return result, metadata, err
	})
}

// handleResponseInterception handles the interception logic after the DynamoDB operation
func (m DBEsdkMiddleware) handleResponseInterception(ctx context.Context, response interface{}) error {
	switch v := response.(type) {
	case *dynamodb.PutItemOutput:
		// Note: this context is not propagated downstream into dafny layer https://issues.amazon.com/CrypTool-5403
		transformedRequest, err := m.client.PutItemOutputTransform(ctx, awscryptographydbencryptionsdkdynamodbtransformssmithygeneratedtypes.PutItemOutputTransformInput{
			OriginalInput: middleware.GetStackValue(ctx, ContextKeyOriginalInput).(dynamodb.PutItemInput),
			SdkOutput:     *v,
		})
		if err != nil {
			return err
		}
		*v = transformedRequest.TransformedOutput
	case *dynamodb.GetItemOutput:
		// Note: this context is not propagated downstream into dafny layer https://issues.amazon.com/CrypTool-5403
		transformedRequest, err := m.client.GetItemOutputTransform(ctx, awscryptographydbencryptionsdkdynamodbtransformssmithygeneratedtypes.GetItemOutputTransformInput{
			OriginalInput: middleware.GetStackValue(ctx, ContextKeyOriginalInput).(dynamodb.GetItemInput),
			SdkOutput:     *v,
		})
		if err != nil {
			return err
		}
		*v = transformedRequest.TransformedOutput
	case *dynamodb.BatchGetItemOutput:
		// Note: this context is not propagated downstream into dafny layer https://issues.amazon.com/CrypTool-5403
		transformedRequest, err := m.client.BatchGetItemOutputTransform(ctx, awscryptographydbencryptionsdkdynamodbtransformssmithygeneratedtypes.BatchGetItemOutputTransformInput{
			OriginalInput: middleware.GetStackValue(ctx, ContextKeyOriginalInput).(dynamodb.BatchGetItemInput),
			SdkOutput:     *v,
		})
		if err != nil {
			return err
		}
		*v = transformedRequest.TransformedOutput
	case *dynamodb.BatchWriteItemOutput:
		// Note: this context is not propagated downstream into dafny layer https://issues.amazon.com/CrypTool-5403
		transformedRequest, err := m.client.BatchWriteItemOutputTransform(ctx, awscryptographydbencryptionsdkdynamodbtransformssmithygeneratedtypes.BatchWriteItemOutputTransformInput{
			OriginalInput: middleware.GetStackValue(ctx, ContextKeyOriginalInput).(dynamodb.BatchWriteItemInput),
			SdkOutput:     *v,
		})
		if err != nil {
			return err
		}
		*v = transformedRequest.TransformedOutput
	case *dynamodb.BatchExecuteStatementOutput:
		// Note: this context is not propagated downstream into dafny layer https://issues.amazon.com/CrypTool-5403
		transformedRequest, err := m.client.BatchExecuteStatementOutputTransform(ctx, awscryptographydbencryptionsdkdynamodbtransformssmithygeneratedtypes.BatchExecuteStatementOutputTransformInput{
			OriginalInput: middleware.GetStackValue(ctx, ContextKeyOriginalInput).(dynamodb.BatchExecuteStatementInput),
			SdkOutput:     *v,
		})
		if err != nil {
			return err
		}
		*v = transformedRequest.TransformedOutput
	case *dynamodb.DeleteItemOutput:
		// Note: this context is not propagated downstream into dafny layer https://issues.amazon.com/CrypTool-5403
		transformedRequest, err := m.client.DeleteItemOutputTransform(ctx, awscryptographydbencryptionsdkdynamodbtransformssmithygeneratedtypes.DeleteItemOutputTransformInput{
			OriginalInput: middleware.GetStackValue(ctx, ContextKeyOriginalInput).(dynamodb.DeleteItemInput),
			SdkOutput:     *v,
		})
		if err != nil {
			return err
		}
		*v = transformedRequest.TransformedOutput
	case *dynamodb.ExecuteStatementOutput:
		// Note: this context is not propagated downstream into dafny layer https://issues.amazon.com/CrypTool-5403
		transformedRequest, err := m.client.ExecuteStatementOutputTransform(ctx, awscryptographydbencryptionsdkdynamodbtransformssmithygeneratedtypes.ExecuteStatementOutputTransformInput{
			OriginalInput: middleware.GetStackValue(ctx, ContextKeyOriginalInput).(dynamodb.ExecuteStatementInput),
			SdkOutput:     *v,
		})
		if err != nil {
			return err
		}
		*v = transformedRequest.TransformedOutput
	case *dynamodb.ExecuteTransactionOutput:
		// Note: this context is not propagated downstream into dafny layer https://issues.amazon.com/CrypTool-5403
		transformedRequest, err := m.client.ExecuteTransactionOutputTransform(ctx, awscryptographydbencryptionsdkdynamodbtransformssmithygeneratedtypes.ExecuteTransactionOutputTransformInput{
			OriginalInput: middleware.GetStackValue(ctx, ContextKeyOriginalInput).(dynamodb.ExecuteTransactionInput),
			SdkOutput:     *v,
		})
		if err != nil {
			return err
		}
		*v = transformedRequest.TransformedOutput
	case *dynamodb.QueryOutput:
		// Note: this context is not propagated downstream into dafny layer https://issues.amazon.com/CrypTool-5403
		transformedRequest, err := m.client.QueryOutputTransform(ctx, awscryptographydbencryptionsdkdynamodbtransformssmithygeneratedtypes.QueryOutputTransformInput{
			OriginalInput: middleware.GetStackValue(ctx, ContextKeyOriginalInput).(dynamodb.QueryInput),
			SdkOutput:     *v,
		})
		if err != nil {
			return err
		}
		*v = transformedRequest.TransformedOutput
	case *dynamodb.ScanOutput:
		// Note: this context is not propagated downstream into dafny layer https://issues.amazon.com/CrypTool-5403
		transformedRequest, err := m.client.ScanOutputTransform(ctx, awscryptographydbencryptionsdkdynamodbtransformssmithygeneratedtypes.ScanOutputTransformInput{
			OriginalInput: middleware.GetStackValue(ctx, ContextKeyOriginalInput).(dynamodb.ScanInput),
			SdkOutput:     *v,
		})
		if err != nil {
			return err
		}
		*v = transformedRequest.TransformedOutput
	case *dynamodb.TransactGetItemsOutput:
		// Note: this context is not propagated downstream into dafny layer https://issues.amazon.com/CrypTool-5403
		transformedRequest, err := m.client.TransactGetItemsOutputTransform(ctx, awscryptographydbencryptionsdkdynamodbtransformssmithygeneratedtypes.TransactGetItemsOutputTransformInput{
			OriginalInput: middleware.GetStackValue(ctx, ContextKeyOriginalInput).(dynamodb.TransactGetItemsInput),
			SdkOutput:     *v,
		})
		if err != nil {
			return err
		}
		*v = transformedRequest.TransformedOutput
	case *dynamodb.TransactWriteItemsOutput:
		// Note: this context is not propagated downstream into dafny layer https://issues.amazon.com/CrypTool-5403
		transformedRequest, err := m.client.TransactWriteItemsOutputTransform(ctx, awscryptographydbencryptionsdkdynamodbtransformssmithygeneratedtypes.TransactWriteItemsOutputTransformInput{
			OriginalInput: middleware.GetStackValue(ctx, ContextKeyOriginalInput).(dynamodb.TransactWriteItemsInput),
			SdkOutput:     *v,
		})
		if err != nil {
			return err
		}
		*v = transformedRequest.TransformedOutput
	case *dynamodb.UpdateItemOutput:
		// Note: this context is not propagated downstream into dafny layer https://issues.amazon.com/CrypTool-5403
		transformedRequest, err := m.client.UpdateItemOutputTransform(ctx, awscryptographydbencryptionsdkdynamodbtransformssmithygeneratedtypes.UpdateItemOutputTransformInput{
			OriginalInput: middleware.GetStackValue(ctx, ContextKeyOriginalInput).(dynamodb.UpdateItemInput),
			SdkOutput:     *v,
		})
		if err != nil {
			return err
		}
		*v = transformedRequest.TransformedOutput
	}
	return nil
}
