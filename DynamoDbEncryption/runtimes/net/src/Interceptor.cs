using Amazon.DynamoDBv2;
using Amazon.DynamoDBv2.Model;
using Amazon.Runtime;
using Amazon.Runtime.Internal;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms;


public class Client
{
  static void AssignRequest(IExecutionContext executionContext, AmazonWebServiceRequest request)
  {
    if (executionContext.RequestContext is RequestContext ctx)
    {
      ctx.OriginalRequest = request;
    }
  }

  public static void TransformRequest(IExecutionContext executionContext, DynamoDbEncryptionTransforms transform)
  {
    if (executionContext.RequestContext.OriginalRequest is GetItemRequest getItemRequest)
    {
      if (executionContext.ResponseContext.Response is GetItemResponse response)
      {
        var output = transform.GetItemOutputTransform(new GetItemOutputTransformInput
        { OriginalInput = getItemRequest, SdkOutput = response });
        response.Item = output.TransformedOutput.Item;
        //executionContext.ResponseContext.Response = output.TransformedOutput;
      }
      else
      {
        var output = transform.GetItemInputTransform(new GetItemInputTransformInput { SdkInput = getItemRequest });
        AssignRequest(executionContext, output.TransformedInput);
      }
    }
    else if (executionContext.RequestContext.OriginalRequest is PutItemRequest putItemRequest)
    {
      if (executionContext.ResponseContext.Response is PutItemResponse response)
      {
        var output = transform.PutItemOutputTransform(new PutItemOutputTransformInput
        { OriginalInput = putItemRequest, SdkOutput = response });
        executionContext.ResponseContext.Response = output.TransformedOutput;
      }
      else
      {
        var output = transform.PutItemInputTransform(new PutItemInputTransformInput { SdkInput = putItemRequest });
        AssignRequest(executionContext, output.TransformedInput);
      }
    }
    else if (executionContext.RequestContext.OriginalRequest is QueryRequest queryRequest)
    {
      if (executionContext.ResponseContext.Response is QueryResponse response)
      {
        var output = transform.QueryOutputTransform(new QueryOutputTransformInput
        { OriginalInput = queryRequest, SdkOutput = response });
        executionContext.ResponseContext.Response = output.TransformedOutput;
      }
      else
      {
        var output = transform.QueryInputTransform(new QueryInputTransformInput { SdkInput = queryRequest });
        AssignRequest(executionContext, output.TransformedInput);
      }
    }
    else if (executionContext.RequestContext.OriginalRequest is ScanRequest scanRequest)
    {
      if (executionContext.ResponseContext.Response is ScanResponse response)
      {
        var output = transform.ScanOutputTransform(new ScanOutputTransformInput
        { OriginalInput = scanRequest, SdkOutput = response });
        executionContext.ResponseContext.Response = output.TransformedOutput;
      }
      else
      {
        var output = transform.ScanInputTransform(new ScanInputTransformInput { SdkInput = scanRequest });
        AssignRequest(executionContext, output.TransformedInput);
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
      TransformRequest(executionContext, _client._transform);
      base.InvokeSync(executionContext);
    }

    public override async Task<T> InvokeAsync<T>(IExecutionContext executionContext)
    {
      TransformRequest(executionContext, _client._transform);
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
      TransformRequest(executionContext, _client._transform);
    }

    public override async Task<T> InvokeAsync<T>(IExecutionContext executionContext)
    {
      var result = await base.InvokeAsync<T>(executionContext).ConfigureAwait(false);
      TransformRequest(executionContext, _client._transform);
      return result;
    }
  }

  public class DynamoDbClient : AmazonDynamoDBClient
  {
    public readonly DynamoDbEncryptionTransforms _transform;

    public DynamoDbClient(AmazonDynamoDBConfig clientConfig, DynamoDbTablesEncryptionConfig encryptionConfig)
      : base(clientConfig)
    {
      _transform = new DynamoDbEncryptionTransforms(encryptionConfig);
    }

    public DynamoDbClient(DynamoDbTablesEncryptionConfig encryptionConfig)
    {
      _transform = new DynamoDbEncryptionTransforms(encryptionConfig);

    }
    public DynamoDbClient(AmazonDynamoDBConfig clientConfig, DynamoDbEncryptionTransforms transform)
      : base(clientConfig)
    {
      _transform = transform;
    }
    public DynamoDbClient(DynamoDbEncryptionTransforms transform)
    {
      _transform = transform;
    }

    protected override void CustomizeRuntimePipeline(RuntimePipeline pipeline)
    {
      base.CustomizeRuntimePipeline(pipeline);
      pipeline.AddHandlerBefore<Marshaller>(new RequestHandler(this));
      pipeline.AddHandlerBefore<Unmarshaller>(new ResponseHandler(this));
    }
  }
}
