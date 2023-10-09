using Amazon.DynamoDBv2;
using Amazon.DynamoDBv2.Model;
using Amazon.Runtime;
using Amazon.Runtime.Internal;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms;


public class Client
{
  public static void TransformRequest(IExecutionContext executionContext, DynamoDbEncryptionTransforms transform)
  {
    AmazonWebServiceRequest originalInput = null;
    if (executionContext.ResponseContext.Response == null)
    {
      executionContext.RequestContext.ContextAttributes["originalInput"] = executionContext.RequestContext.OriginalRequest;
    }
    else
    {
      originalInput = executionContext.RequestContext.ContextAttributes["originalInput"] as AmazonWebServiceRequest;
    }

    if (executionContext.RequestContext.OriginalRequest is GetItemRequest getItemRequest)
    {
      if (executionContext.ResponseContext.Response is GetItemResponse response)
      {
        var output = transform.GetItemOutputTransform(new GetItemOutputTransformInput
        { OriginalInput = originalInput as GetItemRequest, SdkOutput = response });
        response.Item = output.TransformedOutput.Item;
        //executionContext.ResponseContext.Response = output.TransformedOutput;
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
        executionContext.ResponseContext.Response = output.TransformedOutput;
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
        executionContext.ResponseContext.Response = output.TransformedOutput;
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
        executionContext.ResponseContext.Response = output.TransformedOutput;
      }
      else
      {
        var output = transform.ScanInputTransform(new ScanInputTransformInput { SdkInput = scanRequest });
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
      TransformRequest(executionContext, _client.Transform);
      base.InvokeSync(executionContext);
    }

    public override async Task<T> InvokeAsync<T>(IExecutionContext executionContext)
    {
      TransformRequest(executionContext, _client.Transform);
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
      TransformRequest(executionContext, _client.Transform);
    }

    public override async Task<T> InvokeAsync<T>(IExecutionContext executionContext)
    {
      var result = await base.InvokeAsync<T>(executionContext).ConfigureAwait(false);
      TransformRequest(executionContext, _client.Transform);
      return result;
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
