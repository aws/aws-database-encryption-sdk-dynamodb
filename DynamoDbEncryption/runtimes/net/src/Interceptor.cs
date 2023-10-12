using Amazon.DynamoDBv2;
using Amazon.DynamoDBv2.Model;
using Amazon.Runtime;
using Amazon.Runtime.Internal;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms;

public class Client
{
  static void AssignResponse(IExecutionContext executionContext, AmazonWebServiceResponse response)
  {
    response.HttpStatusCode = executionContext.ResponseContext.Response.HttpStatusCode;
    response.ResponseMetadata = executionContext.ResponseContext.Response.ResponseMetadata;
    response.ContentLength = executionContext.ResponseContext.Response.ContentLength;
    executionContext.ResponseContext.Response = response;
  }

  public static void TransformForEncryption(IExecutionContext executionContext, DynamoDbEncryptionTransforms transform)
  {
    AmazonWebServiceRequest originalInput = null;
    if (executionContext.ResponseContext.Response == null)
    {
      executionContext.RequestContext.ContextAttributes["originalInput"] =
        executionContext.RequestContext.OriginalRequest;
    }
    else
    {
      originalInput = executionContext.RequestContext.ContextAttributes["originalInput"] as AmazonWebServiceRequest;
    }

    if (executionContext.RequestContext.OriginalRequest is BatchExecuteStatementRequest batchExecuteStatementRequest)
    {
      if (executionContext.ResponseContext.Response is BatchExecuteStatementResponse response)
      {
        var output = transform.BatchExecuteStatementOutputTransform(new BatchExecuteStatementOutputTransformInput
        { OriginalInput = originalInput as BatchExecuteStatementRequest, SdkOutput = response });
        AssignResponse(executionContext, output.TransformedOutput);
      }
      else
      {
        var output = transform.BatchExecuteStatementInputTransform(new BatchExecuteStatementInputTransformInput
        { SdkInput = batchExecuteStatementRequest });
        executionContext.RequestContext.OriginalRequest = output.TransformedInput;
      }
    }
    else if (executionContext.RequestContext.OriginalRequest is BatchGetItemRequest batchGetItemRequest)
    {
      if (executionContext.ResponseContext.Response is BatchGetItemResponse response)
      {
        var output = transform.BatchGetItemOutputTransform(new BatchGetItemOutputTransformInput
        { OriginalInput = originalInput as BatchGetItemRequest, SdkOutput = response });
        AssignResponse(executionContext, output.TransformedOutput);
      }
      else
      {
        var output = transform.BatchGetItemInputTransform(new BatchGetItemInputTransformInput
        { SdkInput = batchGetItemRequest });
        executionContext.RequestContext.OriginalRequest = output.TransformedInput;
      }
    }
    else if (executionContext.RequestContext.OriginalRequest is BatchWriteItemRequest batchWriteItemRequest)
    {
      if (executionContext.ResponseContext.Response is BatchWriteItemResponse response)
      {
        var output = transform.BatchWriteItemOutputTransform(new BatchWriteItemOutputTransformInput
        { OriginalInput = originalInput as BatchWriteItemRequest, SdkOutput = response });
        AssignResponse(executionContext, output.TransformedOutput);
      }
      else
      {
        var output = transform.BatchWriteItemInputTransform(new BatchWriteItemInputTransformInput
        { SdkInput = batchWriteItemRequest });
        executionContext.RequestContext.OriginalRequest = output.TransformedInput;
      }
    }
    else if (executionContext.RequestContext.OriginalRequest is DeleteItemRequest deleteItemRequest)
    {
      if (executionContext.ResponseContext.Response is DeleteItemResponse response)
      {
        var output = transform.DeleteItemOutputTransform(new DeleteItemOutputTransformInput
        { OriginalInput = originalInput as DeleteItemRequest, SdkOutput = response });
        AssignResponse(executionContext, output.TransformedOutput);
      }
      else
      {
        var output = transform.DeleteItemInputTransform(new DeleteItemInputTransformInput
        { SdkInput = deleteItemRequest });
        executionContext.RequestContext.OriginalRequest = output.TransformedInput;
      }
    }
    else if (executionContext.RequestContext.OriginalRequest is ExecuteStatementRequest executeStatementRequest)
    {
      if (executionContext.ResponseContext.Response is ExecuteStatementResponse response)
      {
        var output = transform.ExecuteStatementOutputTransform(new ExecuteStatementOutputTransformInput
        { OriginalInput = originalInput as ExecuteStatementRequest, SdkOutput = response });
        AssignResponse(executionContext, output.TransformedOutput);
      }
      else
      {
        var output = transform.ExecuteStatementInputTransform(new ExecuteStatementInputTransformInput
        { SdkInput = executeStatementRequest });
        executionContext.RequestContext.OriginalRequest = output.TransformedInput;
      }
    }
    else if (executionContext.RequestContext.OriginalRequest is ExecuteTransactionRequest executeTransactionRequest)
    {
      if (executionContext.ResponseContext.Response is ExecuteTransactionResponse response)
      {
        var output = transform.ExecuteTransactionOutputTransform(new ExecuteTransactionOutputTransformInput
        { OriginalInput = originalInput as ExecuteTransactionRequest, SdkOutput = response });
        AssignResponse(executionContext, output.TransformedOutput);
      }
      else
      {
        var output = transform.ExecuteTransactionInputTransform(new ExecuteTransactionInputTransformInput
        { SdkInput = executeTransactionRequest });
        executionContext.RequestContext.OriginalRequest = output.TransformedInput;
      }
    }
    else if (executionContext.RequestContext.OriginalRequest is GetItemRequest getItemRequest)
    {
      if (executionContext.ResponseContext.Response is GetItemResponse response)
      {
        var output = transform.GetItemOutputTransform(new GetItemOutputTransformInput
        { OriginalInput = originalInput as GetItemRequest, SdkOutput = response });
        AssignResponse(executionContext, output.TransformedOutput);
      }
      else
      {
        var output = transform.GetItemInputTransform(new GetItemInputTransformInput { SdkInput = getItemRequest });
        executionContext.RequestContext.OriginalRequest = output.TransformedInput;
      }
    }
    else if (executionContext.RequestContext.OriginalRequest is PutItemRequest putItemRequest)
    {
      if (executionContext.ResponseContext.Response is PutItemResponse response)
      {
        var output = transform.PutItemOutputTransform(new PutItemOutputTransformInput
        { OriginalInput = originalInput as PutItemRequest, SdkOutput = response });
        AssignResponse(executionContext, output.TransformedOutput);
      }
      else
      {
        var output = transform.PutItemInputTransform(new PutItemInputTransformInput { SdkInput = putItemRequest });
        executionContext.RequestContext.OriginalRequest = output.TransformedInput;
      }
    }
    else if (executionContext.RequestContext.OriginalRequest is QueryRequest queryRequest)
    {
      if (executionContext.ResponseContext.Response is QueryResponse response)
      {
        var output = transform.QueryOutputTransform(new QueryOutputTransformInput
        { OriginalInput = originalInput as QueryRequest, SdkOutput = response });
        AssignResponse(executionContext, output.TransformedOutput);
      }
      else
      {
        var output = transform.QueryInputTransform(new QueryInputTransformInput { SdkInput = queryRequest });
        executionContext.RequestContext.OriginalRequest = output.TransformedInput;
      }
    }
    else if (executionContext.RequestContext.OriginalRequest is ScanRequest scanRequest)
    {
      if (executionContext.ResponseContext.Response is ScanResponse response)
      {
        var output = transform.ScanOutputTransform(new ScanOutputTransformInput
        { OriginalInput = originalInput as ScanRequest, SdkOutput = response });
        AssignResponse(executionContext, output.TransformedOutput);
      }
      else
      {
        var output = transform.ScanInputTransform(new ScanInputTransformInput { SdkInput = scanRequest });
        executionContext.RequestContext.OriginalRequest = output.TransformedInput;
      }
    }
    else if (executionContext.RequestContext.OriginalRequest is TransactGetItemsRequest transactGetItemsRequest)
    {
      if (executionContext.ResponseContext.Response is TransactGetItemsResponse response)
      {
        var output = transform.TransactGetItemsOutputTransform(new TransactGetItemsOutputTransformInput
        { OriginalInput = originalInput as TransactGetItemsRequest, SdkOutput = response });
        AssignResponse(executionContext, output.TransformedOutput);
      }
      else
      {
        var output = transform.TransactGetItemsInputTransform(new TransactGetItemsInputTransformInput
        { SdkInput = transactGetItemsRequest });
        executionContext.RequestContext.OriginalRequest = output.TransformedInput;
      }
    }
    else if (executionContext.RequestContext.OriginalRequest is TransactWriteItemsRequest transactWriteItemsRequest)
    {
      if (executionContext.ResponseContext.Response is TransactWriteItemsResponse response)
      {
        var output = transform.TransactWriteItemsOutputTransform(new TransactWriteItemsOutputTransformInput
        { OriginalInput = originalInput as TransactWriteItemsRequest, SdkOutput = response });
        AssignResponse(executionContext, output.TransformedOutput);
      }
      else
      {
        var output = transform.TransactWriteItemsInputTransform(new TransactWriteItemsInputTransformInput
        { SdkInput = transactWriteItemsRequest });
        executionContext.RequestContext.OriginalRequest = output.TransformedInput;
      }
    }
    else if (executionContext.RequestContext.OriginalRequest is UpdateItemRequest updateItemRequest)
    {
      if (executionContext.ResponseContext.Response is UpdateItemResponse response)
      {
        var output = transform.UpdateItemOutputTransform(new UpdateItemOutputTransformInput
        { OriginalInput = originalInput as UpdateItemRequest, SdkOutput = response });
        AssignResponse(executionContext, output.TransformedOutput);
      }
      else
      {
        var output = transform.UpdateItemInputTransform(new UpdateItemInputTransformInput
        { SdkInput = updateItemRequest });
        executionContext.RequestContext.OriginalRequest = output.TransformedInput;
      }
    }
  }

  public class RequestHandler : PipelineHandler
  {
    private readonly DynamoDbClient _client;

    public RequestHandler(DynamoDbClient client)
    {
      _client = client;
    }

    public override void InvokeSync(IExecutionContext executionContext)
    {
      TransformForEncryption(executionContext, _client.Transform);
      base.InvokeSync(executionContext);
    }

    public override async Task<T> InvokeAsync<T>(IExecutionContext executionContext)
    {
      TransformForEncryption(executionContext, _client.Transform);
      return await base.InvokeAsync<T>(executionContext).ConfigureAwait(false);
    }
  }

  public class ResponseHandler : PipelineHandler
  {
    private readonly DynamoDbClient _client;

    public ResponseHandler(DynamoDbClient client)
    {
      _client = client;
    }

    public override void InvokeSync(IExecutionContext executionContext)
    {
      base.InvokeSync(executionContext);
      TransformForEncryption(executionContext, _client.Transform);
    }

    public override async Task<T> InvokeAsync<T>(IExecutionContext executionContext)
    {
      await base.InvokeAsync<T>(executionContext).ConfigureAwait(false);
      TransformForEncryption(executionContext, _client.Transform);
      return executionContext.ResponseContext.Response as T;
    }
  }

  public class DynamoDbClient : AmazonDynamoDBClient
  {
    public DynamoDbEncryptionTransforms Transform { get; }

    public DynamoDbClient(AmazonDynamoDBConfig clientConfig, DynamoDbTablesEncryptionConfig encryptionConfig)
      : base(clientConfig)
    {
      Transform = new DynamoDbEncryptionTransforms(encryptionConfig);
    }

    public DynamoDbClient(DynamoDbTablesEncryptionConfig encryptionConfig)
    {
      Transform = new DynamoDbEncryptionTransforms(encryptionConfig);
    }

    public DynamoDbClient(AmazonDynamoDBConfig clientConfig, DynamoDbEncryptionTransforms transform)
      : base(clientConfig)
    {
      Transform = transform;
    }

    public DynamoDbClient(DynamoDbEncryptionTransforms transform)
    {
      Transform = transform;
    }

    protected override void CustomizeRuntimePipeline(RuntimePipeline pipeline)
    {
      base.CustomizeRuntimePipeline(pipeline);
      pipeline.AddHandlerBefore<Marshaller>(new RequestHandler(this));
      pipeline.AddHandlerBefore<Unmarshaller>(new ResponseHandler(this));
    }
  }
}
