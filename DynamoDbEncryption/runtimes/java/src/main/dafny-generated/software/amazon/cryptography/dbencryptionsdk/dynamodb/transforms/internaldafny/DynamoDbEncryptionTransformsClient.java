// Class DynamoDbEncryptionTransformsClient
// Dafny class DynamoDbEncryptionTransformsClient compiled into Java
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny;

@SuppressWarnings({"unchecked", "deprecation"})
public class DynamoDbEncryptionTransformsClient implements software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.IDynamoDbEncryptionTransformsClient {
  public DynamoDbEncryptionTransformsClient() {
    this._config = DdbMiddlewareConfig_Compile.Config.Default();
  }
  public void __ctor(DdbMiddlewareConfig_Compile.Config config)
  {
    (this)._config = config;
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.PutItemInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> PutItemInputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.PutItemInputTransformInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.PutItemInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> output = (Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.PutItemInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>)null;
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.PutItemInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out0;
      _out0 = AwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations_Compile.__default.PutItemInputTransform((this).config(), input);
      output = _out0;
    }
    return output;
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.PutItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> PutItemOutputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.PutItemOutputTransformInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.PutItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.PutItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.PutItemOutputTransformOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.PutItemOutputTransformOutput.Default());
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.PutItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out0;
      _out0 = AwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations_Compile.__default.PutItemOutputTransform((this).config(), input);
      output = _out0;
    }
    return output;
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> GetItemInputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemInputTransformInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> output = (Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>)null;
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out0;
      _out0 = AwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations_Compile.__default.GetItemInputTransform((this).config(), input);
      output = _out0;
    }
    return output;
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> GetItemOutputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemOutputTransformInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemOutputTransformOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemOutputTransformOutput.Default());
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out0;
      _out0 = AwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations_Compile.__default.GetItemOutputTransform((this).config(), input);
      output = _out0;
    }
    return output;
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> BatchWriteItemInputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemInputTransformInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> output = (Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>)null;
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out0;
      _out0 = AwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations_Compile.__default.BatchWriteItemInputTransform((this).config(), input);
      output = _out0;
    }
    return output;
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> BatchWriteItemOutputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemOutputTransformInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemOutputTransformOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemOutputTransformOutput.Default());
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out0;
      _out0 = AwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations_Compile.__default.BatchWriteItemOutputTransform((this).config(), input);
      output = _out0;
    }
    return output;
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> BatchGetItemInputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemInputTransformInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> output = (Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>)null;
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out0;
      _out0 = AwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations_Compile.__default.BatchGetItemInputTransform((this).config(), input);
      output = _out0;
    }
    return output;
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> BatchGetItemOutputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemOutputTransformInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemOutputTransformOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemOutputTransformOutput.Default());
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out0;
      _out0 = AwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations_Compile.__default.BatchGetItemOutputTransform((this).config(), input);
      output = _out0;
    }
    return output;
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ScanInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> ScanInputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ScanInputTransformInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ScanInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> output = (Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ScanInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>)null;
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ScanInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out0;
      _out0 = AwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations_Compile.__default.ScanInputTransform((this).config(), input);
      output = _out0;
    }
    return output;
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ScanOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> ScanOutputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ScanOutputTransformInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ScanOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ScanOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ScanOutputTransformOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ScanOutputTransformOutput.Default());
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ScanOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out0;
      _out0 = AwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations_Compile.__default.ScanOutputTransform((this).config(), input);
      output = _out0;
    }
    return output;
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.QueryInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> QueryInputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.QueryInputTransformInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.QueryInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> output = (Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.QueryInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>)null;
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.QueryInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out0;
      _out0 = AwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations_Compile.__default.QueryInputTransform((this).config(), input);
      output = _out0;
    }
    return output;
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.QueryOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> QueryOutputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.QueryOutputTransformInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.QueryOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.QueryOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.QueryOutputTransformOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.QueryOutputTransformOutput.Default());
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.QueryOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out0;
      _out0 = AwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations_Compile.__default.QueryOutputTransform((this).config(), input);
      output = _out0;
    }
    return output;
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactWriteItemsInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> TransactWriteItemsInputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactWriteItemsInputTransformInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactWriteItemsInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> output = (Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactWriteItemsInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>)null;
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactWriteItemsInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out0;
      _out0 = AwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations_Compile.__default.TransactWriteItemsInputTransform((this).config(), input);
      output = _out0;
    }
    return output;
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactWriteItemsOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> TransactWriteItemsOutputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactWriteItemsOutputTransformInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactWriteItemsOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactWriteItemsOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactWriteItemsOutputTransformOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactWriteItemsOutputTransformOutput.Default());
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactWriteItemsOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out0;
      _out0 = AwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations_Compile.__default.TransactWriteItemsOutputTransform((this).config(), input);
      output = _out0;
    }
    return output;
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateItemInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> UpdateItemInputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateItemInputTransformInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateItemInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> output = (Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateItemInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>)null;
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateItemInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out0;
      _out0 = AwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations_Compile.__default.UpdateItemInputTransform((this).config(), input);
      output = _out0;
    }
    return output;
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> UpdateItemOutputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateItemOutputTransformInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateItemOutputTransformOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateItemOutputTransformOutput.Default());
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out0;
      _out0 = AwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations_Compile.__default.UpdateItemOutputTransform((this).config(), input);
      output = _out0;
    }
    return output;
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DeleteItemInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> DeleteItemInputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DeleteItemInputTransformInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DeleteItemInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> output = (Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DeleteItemInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>)null;
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DeleteItemInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out0;
      _out0 = AwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations_Compile.__default.DeleteItemInputTransform((this).config(), input);
      output = _out0;
    }
    return output;
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DeleteItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> DeleteItemOutputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DeleteItemOutputTransformInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DeleteItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DeleteItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DeleteItemOutputTransformOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DeleteItemOutputTransformOutput.Default());
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DeleteItemOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out0;
      _out0 = AwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations_Compile.__default.DeleteItemOutputTransform((this).config(), input);
      output = _out0;
    }
    return output;
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactGetItemsInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> TransactGetItemsInputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactGetItemsInputTransformInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactGetItemsInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> output = (Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactGetItemsInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>)null;
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactGetItemsInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out0;
      _out0 = AwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations_Compile.__default.TransactGetItemsInputTransform((this).config(), input);
      output = _out0;
    }
    return output;
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactGetItemsOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> TransactGetItemsOutputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactGetItemsOutputTransformInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactGetItemsOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactGetItemsOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactGetItemsOutputTransformOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactGetItemsOutputTransformOutput.Default());
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactGetItemsOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out0;
      _out0 = AwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations_Compile.__default.TransactGetItemsOutputTransform((this).config(), input);
      output = _out0;
    }
    return output;
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> ExecuteStatementInputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementInputTransformInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> output = (Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>)null;
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out0;
      _out0 = AwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations_Compile.__default.ExecuteStatementInputTransform((this).config(), input);
      output = _out0;
    }
    return output;
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> ExecuteStatementOutputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementOutputTransformInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementOutputTransformOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementOutputTransformOutput.Default());
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out0;
      _out0 = AwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations_Compile.__default.ExecuteStatementOutputTransform((this).config(), input);
      output = _out0;
    }
    return output;
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> BatchExecuteStatementInputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementInputTransformInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> output = (Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>)null;
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out0;
      _out0 = AwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations_Compile.__default.BatchExecuteStatementInputTransform((this).config(), input);
      output = _out0;
    }
    return output;
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> BatchExecuteStatementOutputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementOutputTransformInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementOutputTransformOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementOutputTransformOutput.Default());
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out0;
      _out0 = AwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations_Compile.__default.BatchExecuteStatementOutputTransform((this).config(), input);
      output = _out0;
    }
    return output;
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> ExecuteTransactionInputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionInputTransformInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> output = (Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>)null;
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionInputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out0;
      _out0 = AwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations_Compile.__default.ExecuteTransactionInputTransform((this).config(), input);
      output = _out0;
    }
    return output;
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> ExecuteTransactionOutputTransform(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionOutputTransformInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionOutputTransformOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionOutputTransformOutput.Default());
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionOutputTransformOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out0;
      _out0 = AwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations_Compile.__default.ExecuteTransactionOutputTransform((this).config(), input);
      output = _out0;
    }
    return output;
  }
  public Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ResolveAttributesOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> ResolveAttributes(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ResolveAttributesInput input)
  {
    Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ResolveAttributesOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> output = Wrappers_Compile.Result.<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ResolveAttributesOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error>Default(software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ResolveAttributesOutput._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error._typeDescriptor(), software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ResolveAttributesOutput.Default());
    if(true) {
      Wrappers_Compile.Result<software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ResolveAttributesOutput, software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error> _out0;
      _out0 = AwsCryptographyDbEncryptionSdkDynamoDbTransformsOperations_Compile.__default.ResolveAttributes((this).config(), input);
      output = _out0;
    }
    return output;
  }
  public DdbMiddlewareConfig_Compile.Config _config;
  public DdbMiddlewareConfig_Compile.Config config()
  {
    return this._config;
  }
  private static final dafny.TypeDescriptor<DynamoDbEncryptionTransformsClient> _TYPE = dafny.TypeDescriptor.<DynamoDbEncryptionTransformsClient>referenceWithInitializer(DynamoDbEncryptionTransformsClient.class, () -> (DynamoDbEncryptionTransformsClient) null);
  public static dafny.TypeDescriptor<DynamoDbEncryptionTransformsClient> _typeDescriptor() {
    return (dafny.TypeDescriptor<DynamoDbEncryptionTransformsClient>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  @Override
  public java.lang.String toString() {
    return "DynamoDbEncryptionTransforms.DynamoDbEncryptionTransformsClient";
  }
}
