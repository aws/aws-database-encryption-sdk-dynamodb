// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
package software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms;

import dafny.DafnyMap;
import dafny.DafnySequence;
import java.lang.Character;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.Map;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error_CollectionOfErrors;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error_DynamoDbEncryptionTransformsException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error_Opaque;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.Error_OpaqueWithText;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.IDynamoDbEncryptionTransformsClient;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchExecuteStatementInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchExecuteStatementInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchExecuteStatementOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchExecuteStatementOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchGetItemInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchGetItemInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchGetItemOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchGetItemOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchWriteItemInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchWriteItemInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchWriteItemOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.BatchWriteItemOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.CollectionOfErrors;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.DeleteItemInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.DeleteItemInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.DeleteItemOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.DeleteItemOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.DynamoDbEncryptionTransformsException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ExecuteStatementInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ExecuteStatementInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ExecuteStatementOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ExecuteStatementOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ExecuteTransactionInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ExecuteTransactionInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ExecuteTransactionOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ExecuteTransactionOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.GetItemInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.GetItemInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.GetItemOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.GetItemOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.GetNumberOfQueriesInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.GetNumberOfQueriesOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.OpaqueError;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.OpaqueWithTextError;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.PutItemInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.PutItemInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.PutItemOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.PutItemOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.QueryInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.QueryInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.QueryOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.QueryOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ResolveAttributesInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ResolveAttributesOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ScanInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ScanInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ScanOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.ScanOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.TransactGetItemsInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.TransactGetItemsInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.TransactGetItemsOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.TransactGetItemsOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.TransactWriteItemsInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.TransactWriteItemsInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.TransactWriteItemsOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.TransactWriteItemsOutputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.UpdateItemInputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.UpdateItemInputTransformOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.UpdateItemOutputTransformInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.UpdateItemOutputTransformOutput;

public class ToNative {

  public static OpaqueError Error(Error_Opaque dafnyValue) {
    OpaqueError.Builder nativeBuilder = OpaqueError.builder();
    nativeBuilder.obj(dafnyValue.dtor_obj());
    return nativeBuilder.build();
  }

  public static OpaqueWithTextError Error(Error_OpaqueWithText dafnyValue) {
    OpaqueWithTextError.Builder nativeBuilder = OpaqueWithTextError.builder();
    nativeBuilder.obj(dafnyValue.dtor_obj());
    nativeBuilder.objMessage(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_objMessage()
      )
    );
    return nativeBuilder.build();
  }

  public static CollectionOfErrors Error(Error_CollectionOfErrors dafnyValue) {
    CollectionOfErrors.Builder nativeBuilder = CollectionOfErrors.builder();
    nativeBuilder.list(
      software.amazon.smithy.dafny.conversion.ToNative.Aggregate.GenericToList(
        dafnyValue.dtor_list(),
        ToNative::Error
      )
    );
    nativeBuilder.message(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_message()
      )
    );
    return nativeBuilder.build();
  }

  public static DynamoDbEncryptionTransformsException Error(
    Error_DynamoDbEncryptionTransformsException dafnyValue
  ) {
    DynamoDbEncryptionTransformsException.Builder nativeBuilder =
      DynamoDbEncryptionTransformsException.builder();
    nativeBuilder.message(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_message()
      )
    );
    return nativeBuilder.build();
  }

  public static RuntimeException Error(Error dafnyValue) {
    if (dafnyValue.is_DynamoDbEncryptionTransformsException()) {
      return ToNative.Error(
        (Error_DynamoDbEncryptionTransformsException) dafnyValue
      );
    }
    if (dafnyValue.is_Opaque()) {
      return ToNative.Error((Error_Opaque) dafnyValue);
    }
    if (dafnyValue.is_OpaqueWithText()) {
      return ToNative.Error((Error_OpaqueWithText) dafnyValue);
    }
    if (dafnyValue.is_CollectionOfErrors()) {
      return ToNative.Error((Error_CollectionOfErrors) dafnyValue);
    }
    if (dafnyValue.is_ComAmazonawsDynamodb()) {
      return software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.Error(
        dafnyValue.dtor_ComAmazonawsDynamodb()
      );
    }
    if (dafnyValue.is_AwsCryptographyDbEncryptionSdkDynamoDb()) {
      return software.amazon.cryptography.dbencryptionsdk.dynamodb.ToNative.Error(
        dafnyValue.dtor_AwsCryptographyDbEncryptionSdkDynamoDb()
      );
    }
    if (dafnyValue.is_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor()) {
      return software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.ToNative.Error(
        dafnyValue.dtor_AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptor()
      );
    }
    if (dafnyValue.is_AwsCryptographyDbEncryptionSdkStructuredEncryption()) {
      return software.amazon.cryptography.dbencryptionsdk.structuredencryption.ToNative.Error(
        dafnyValue.dtor_AwsCryptographyDbEncryptionSdkStructuredEncryption()
      );
    }
    if (dafnyValue.is_AwsCryptographyMaterialProviders()) {
      return software.amazon.cryptography.materialproviders.ToNative.Error(
        dafnyValue.dtor_AwsCryptographyMaterialProviders()
      );
    }
    OpaqueError.Builder nativeBuilder = OpaqueError.builder();
    nativeBuilder.obj(dafnyValue);
    return nativeBuilder.build();
  }

  public static BatchExecuteStatementInputTransformInput BatchExecuteStatementInputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementInputTransformInput dafnyValue
  ) {
    BatchExecuteStatementInputTransformInput.Builder nativeBuilder =
      BatchExecuteStatementInputTransformInput.builder();
    nativeBuilder.sdkInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.BatchExecuteStatementInput(
        dafnyValue.dtor_sdkInput()
      )
    );
    return nativeBuilder.build();
  }

  public static BatchExecuteStatementInputTransformOutput BatchExecuteStatementInputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementInputTransformOutput dafnyValue
  ) {
    BatchExecuteStatementInputTransformOutput.Builder nativeBuilder =
      BatchExecuteStatementInputTransformOutput.builder();
    nativeBuilder.transformedInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.BatchExecuteStatementInput(
        dafnyValue.dtor_transformedInput()
      )
    );
    return nativeBuilder.build();
  }

  public static BatchExecuteStatementOutputTransformInput BatchExecuteStatementOutputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementOutputTransformInput dafnyValue
  ) {
    BatchExecuteStatementOutputTransformInput.Builder nativeBuilder =
      BatchExecuteStatementOutputTransformInput.builder();
    nativeBuilder.sdkOutput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.BatchExecuteStatementOutput(
        dafnyValue.dtor_sdkOutput()
      )
    );
    nativeBuilder.originalInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.BatchExecuteStatementInput(
        dafnyValue.dtor_originalInput()
      )
    );
    return nativeBuilder.build();
  }

  public static BatchExecuteStatementOutputTransformOutput BatchExecuteStatementOutputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchExecuteStatementOutputTransformOutput dafnyValue
  ) {
    BatchExecuteStatementOutputTransformOutput.Builder nativeBuilder =
      BatchExecuteStatementOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.BatchExecuteStatementOutput(
        dafnyValue.dtor_transformedOutput()
      )
    );
    return nativeBuilder.build();
  }

  public static BatchGetItemInputTransformInput BatchGetItemInputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemInputTransformInput dafnyValue
  ) {
    BatchGetItemInputTransformInput.Builder nativeBuilder =
      BatchGetItemInputTransformInput.builder();
    nativeBuilder.sdkInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.BatchGetItemInput(
        dafnyValue.dtor_sdkInput()
      )
    );
    return nativeBuilder.build();
  }

  public static BatchGetItemInputTransformOutput BatchGetItemInputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemInputTransformOutput dafnyValue
  ) {
    BatchGetItemInputTransformOutput.Builder nativeBuilder =
      BatchGetItemInputTransformOutput.builder();
    nativeBuilder.transformedInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.BatchGetItemInput(
        dafnyValue.dtor_transformedInput()
      )
    );
    return nativeBuilder.build();
  }

  public static BatchGetItemOutputTransformInput BatchGetItemOutputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemOutputTransformInput dafnyValue
  ) {
    BatchGetItemOutputTransformInput.Builder nativeBuilder =
      BatchGetItemOutputTransformInput.builder();
    nativeBuilder.sdkOutput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.BatchGetItemOutput(
        dafnyValue.dtor_sdkOutput()
      )
    );
    nativeBuilder.originalInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.BatchGetItemInput(
        dafnyValue.dtor_originalInput()
      )
    );
    return nativeBuilder.build();
  }

  public static BatchGetItemOutputTransformOutput BatchGetItemOutputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchGetItemOutputTransformOutput dafnyValue
  ) {
    BatchGetItemOutputTransformOutput.Builder nativeBuilder =
      BatchGetItemOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.BatchGetItemOutput(
        dafnyValue.dtor_transformedOutput()
      )
    );
    return nativeBuilder.build();
  }

  public static BatchWriteItemInputTransformInput BatchWriteItemInputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemInputTransformInput dafnyValue
  ) {
    BatchWriteItemInputTransformInput.Builder nativeBuilder =
      BatchWriteItemInputTransformInput.builder();
    nativeBuilder.sdkInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.BatchWriteItemInput(
        dafnyValue.dtor_sdkInput()
      )
    );
    return nativeBuilder.build();
  }

  public static BatchWriteItemInputTransformOutput BatchWriteItemInputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemInputTransformOutput dafnyValue
  ) {
    BatchWriteItemInputTransformOutput.Builder nativeBuilder =
      BatchWriteItemInputTransformOutput.builder();
    nativeBuilder.transformedInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.BatchWriteItemInput(
        dafnyValue.dtor_transformedInput()
      )
    );
    return nativeBuilder.build();
  }

  public static BatchWriteItemOutputTransformInput BatchWriteItemOutputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemOutputTransformInput dafnyValue
  ) {
    BatchWriteItemOutputTransformInput.Builder nativeBuilder =
      BatchWriteItemOutputTransformInput.builder();
    nativeBuilder.sdkOutput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.BatchWriteItemOutput(
        dafnyValue.dtor_sdkOutput()
      )
    );
    nativeBuilder.originalInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.BatchWriteItemInput(
        dafnyValue.dtor_originalInput()
      )
    );
    return nativeBuilder.build();
  }

  public static BatchWriteItemOutputTransformOutput BatchWriteItemOutputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.BatchWriteItemOutputTransformOutput dafnyValue
  ) {
    BatchWriteItemOutputTransformOutput.Builder nativeBuilder =
      BatchWriteItemOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.BatchWriteItemOutput(
        dafnyValue.dtor_transformedOutput()
      )
    );
    return nativeBuilder.build();
  }

  public static DeleteItemInputTransformInput DeleteItemInputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DeleteItemInputTransformInput dafnyValue
  ) {
    DeleteItemInputTransformInput.Builder nativeBuilder =
      DeleteItemInputTransformInput.builder();
    nativeBuilder.sdkInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.DeleteItemInput(
        dafnyValue.dtor_sdkInput()
      )
    );
    return nativeBuilder.build();
  }

  public static DeleteItemInputTransformOutput DeleteItemInputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DeleteItemInputTransformOutput dafnyValue
  ) {
    DeleteItemInputTransformOutput.Builder nativeBuilder =
      DeleteItemInputTransformOutput.builder();
    nativeBuilder.transformedInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.DeleteItemInput(
        dafnyValue.dtor_transformedInput()
      )
    );
    return nativeBuilder.build();
  }

  public static DeleteItemOutputTransformInput DeleteItemOutputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DeleteItemOutputTransformInput dafnyValue
  ) {
    DeleteItemOutputTransformInput.Builder nativeBuilder =
      DeleteItemOutputTransformInput.builder();
    nativeBuilder.sdkOutput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.DeleteItemOutput(
        dafnyValue.dtor_sdkOutput()
      )
    );
    nativeBuilder.originalInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.DeleteItemInput(
        dafnyValue.dtor_originalInput()
      )
    );
    return nativeBuilder.build();
  }

  public static DeleteItemOutputTransformOutput DeleteItemOutputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.DeleteItemOutputTransformOutput dafnyValue
  ) {
    DeleteItemOutputTransformOutput.Builder nativeBuilder =
      DeleteItemOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.DeleteItemOutput(
        dafnyValue.dtor_transformedOutput()
      )
    );
    return nativeBuilder.build();
  }

  public static ExecuteStatementInputTransformInput ExecuteStatementInputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementInputTransformInput dafnyValue
  ) {
    ExecuteStatementInputTransformInput.Builder nativeBuilder =
      ExecuteStatementInputTransformInput.builder();
    nativeBuilder.sdkInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.ExecuteStatementInput(
        dafnyValue.dtor_sdkInput()
      )
    );
    return nativeBuilder.build();
  }

  public static ExecuteStatementInputTransformOutput ExecuteStatementInputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementInputTransformOutput dafnyValue
  ) {
    ExecuteStatementInputTransformOutput.Builder nativeBuilder =
      ExecuteStatementInputTransformOutput.builder();
    nativeBuilder.transformedInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.ExecuteStatementInput(
        dafnyValue.dtor_transformedInput()
      )
    );
    return nativeBuilder.build();
  }

  public static ExecuteStatementOutputTransformInput ExecuteStatementOutputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementOutputTransformInput dafnyValue
  ) {
    ExecuteStatementOutputTransformInput.Builder nativeBuilder =
      ExecuteStatementOutputTransformInput.builder();
    nativeBuilder.sdkOutput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.ExecuteStatementOutput(
        dafnyValue.dtor_sdkOutput()
      )
    );
    nativeBuilder.originalInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.ExecuteStatementInput(
        dafnyValue.dtor_originalInput()
      )
    );
    return nativeBuilder.build();
  }

  public static ExecuteStatementOutputTransformOutput ExecuteStatementOutputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteStatementOutputTransformOutput dafnyValue
  ) {
    ExecuteStatementOutputTransformOutput.Builder nativeBuilder =
      ExecuteStatementOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.ExecuteStatementOutput(
        dafnyValue.dtor_transformedOutput()
      )
    );
    return nativeBuilder.build();
  }

  public static ExecuteTransactionInputTransformInput ExecuteTransactionInputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionInputTransformInput dafnyValue
  ) {
    ExecuteTransactionInputTransformInput.Builder nativeBuilder =
      ExecuteTransactionInputTransformInput.builder();
    nativeBuilder.sdkInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.ExecuteTransactionInput(
        dafnyValue.dtor_sdkInput()
      )
    );
    return nativeBuilder.build();
  }

  public static ExecuteTransactionInputTransformOutput ExecuteTransactionInputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionInputTransformOutput dafnyValue
  ) {
    ExecuteTransactionInputTransformOutput.Builder nativeBuilder =
      ExecuteTransactionInputTransformOutput.builder();
    nativeBuilder.transformedInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.ExecuteTransactionInput(
        dafnyValue.dtor_transformedInput()
      )
    );
    return nativeBuilder.build();
  }

  public static ExecuteTransactionOutputTransformInput ExecuteTransactionOutputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionOutputTransformInput dafnyValue
  ) {
    ExecuteTransactionOutputTransformInput.Builder nativeBuilder =
      ExecuteTransactionOutputTransformInput.builder();
    nativeBuilder.sdkOutput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.ExecuteTransactionOutput(
        dafnyValue.dtor_sdkOutput()
      )
    );
    nativeBuilder.originalInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.ExecuteTransactionInput(
        dafnyValue.dtor_originalInput()
      )
    );
    return nativeBuilder.build();
  }

  public static ExecuteTransactionOutputTransformOutput ExecuteTransactionOutputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ExecuteTransactionOutputTransformOutput dafnyValue
  ) {
    ExecuteTransactionOutputTransformOutput.Builder nativeBuilder =
      ExecuteTransactionOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.ExecuteTransactionOutput(
        dafnyValue.dtor_transformedOutput()
      )
    );
    return nativeBuilder.build();
  }

  public static GetItemInputTransformInput GetItemInputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemInputTransformInput dafnyValue
  ) {
    GetItemInputTransformInput.Builder nativeBuilder =
      GetItemInputTransformInput.builder();
    nativeBuilder.sdkInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.GetItemInput(
        dafnyValue.dtor_sdkInput()
      )
    );
    return nativeBuilder.build();
  }

  public static GetItemInputTransformOutput GetItemInputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemInputTransformOutput dafnyValue
  ) {
    GetItemInputTransformOutput.Builder nativeBuilder =
      GetItemInputTransformOutput.builder();
    nativeBuilder.transformedInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.GetItemInput(
        dafnyValue.dtor_transformedInput()
      )
    );
    return nativeBuilder.build();
  }

  public static GetItemOutputTransformInput GetItemOutputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemOutputTransformInput dafnyValue
  ) {
    GetItemOutputTransformInput.Builder nativeBuilder =
      GetItemOutputTransformInput.builder();
    nativeBuilder.sdkOutput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.GetItemOutput(
        dafnyValue.dtor_sdkOutput()
      )
    );
    nativeBuilder.originalInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.GetItemInput(
        dafnyValue.dtor_originalInput()
      )
    );
    return nativeBuilder.build();
  }

  public static GetItemOutputTransformOutput GetItemOutputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetItemOutputTransformOutput dafnyValue
  ) {
    GetItemOutputTransformOutput.Builder nativeBuilder =
      GetItemOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.GetItemOutput(
        dafnyValue.dtor_transformedOutput()
      )
    );
    return nativeBuilder.build();
  }

  public static GetNumberOfQueriesInput GetNumberOfQueriesInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetNumberOfQueriesInput dafnyValue
  ) {
    GetNumberOfQueriesInput.Builder nativeBuilder =
      GetNumberOfQueriesInput.builder();
    nativeBuilder.input(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.QueryInput(
        dafnyValue.dtor_input()
      )
    );
    return nativeBuilder.build();
  }

  public static GetNumberOfQueriesOutput GetNumberOfQueriesOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.GetNumberOfQueriesOutput dafnyValue
  ) {
    GetNumberOfQueriesOutput.Builder nativeBuilder =
      GetNumberOfQueriesOutput.builder();
    nativeBuilder.numberOfQueries((dafnyValue.dtor_numberOfQueries()));
    return nativeBuilder.build();
  }

  public static PutItemInputTransformInput PutItemInputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.PutItemInputTransformInput dafnyValue
  ) {
    PutItemInputTransformInput.Builder nativeBuilder =
      PutItemInputTransformInput.builder();
    nativeBuilder.sdkInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.PutItemInput(
        dafnyValue.dtor_sdkInput()
      )
    );
    return nativeBuilder.build();
  }

  public static PutItemInputTransformOutput PutItemInputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.PutItemInputTransformOutput dafnyValue
  ) {
    PutItemInputTransformOutput.Builder nativeBuilder =
      PutItemInputTransformOutput.builder();
    nativeBuilder.transformedInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.PutItemInput(
        dafnyValue.dtor_transformedInput()
      )
    );
    return nativeBuilder.build();
  }

  public static PutItemOutputTransformInput PutItemOutputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.PutItemOutputTransformInput dafnyValue
  ) {
    PutItemOutputTransformInput.Builder nativeBuilder =
      PutItemOutputTransformInput.builder();
    nativeBuilder.sdkOutput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.PutItemOutput(
        dafnyValue.dtor_sdkOutput()
      )
    );
    nativeBuilder.originalInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.PutItemInput(
        dafnyValue.dtor_originalInput()
      )
    );
    return nativeBuilder.build();
  }

  public static PutItemOutputTransformOutput PutItemOutputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.PutItemOutputTransformOutput dafnyValue
  ) {
    PutItemOutputTransformOutput.Builder nativeBuilder =
      PutItemOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.PutItemOutput(
        dafnyValue.dtor_transformedOutput()
      )
    );
    return nativeBuilder.build();
  }

  public static QueryInputTransformInput QueryInputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.QueryInputTransformInput dafnyValue
  ) {
    QueryInputTransformInput.Builder nativeBuilder =
      QueryInputTransformInput.builder();
    nativeBuilder.sdkInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.QueryInput(
        dafnyValue.dtor_sdkInput()
      )
    );
    return nativeBuilder.build();
  }

  public static QueryInputTransformOutput QueryInputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.QueryInputTransformOutput dafnyValue
  ) {
    QueryInputTransformOutput.Builder nativeBuilder =
      QueryInputTransformOutput.builder();
    nativeBuilder.transformedInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.QueryInput(
        dafnyValue.dtor_transformedInput()
      )
    );
    return nativeBuilder.build();
  }

  public static QueryOutputTransformInput QueryOutputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.QueryOutputTransformInput dafnyValue
  ) {
    QueryOutputTransformInput.Builder nativeBuilder =
      QueryOutputTransformInput.builder();
    nativeBuilder.sdkOutput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.QueryOutput(
        dafnyValue.dtor_sdkOutput()
      )
    );
    nativeBuilder.originalInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.QueryInput(
        dafnyValue.dtor_originalInput()
      )
    );
    return nativeBuilder.build();
  }

  public static QueryOutputTransformOutput QueryOutputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.QueryOutputTransformOutput dafnyValue
  ) {
    QueryOutputTransformOutput.Builder nativeBuilder =
      QueryOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.QueryOutput(
        dafnyValue.dtor_transformedOutput()
      )
    );
    return nativeBuilder.build();
  }

  public static ResolveAttributesInput ResolveAttributesInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ResolveAttributesInput dafnyValue
  ) {
    ResolveAttributesInput.Builder nativeBuilder =
      ResolveAttributesInput.builder();
    nativeBuilder.TableName(
      software.amazon.smithy.dafny.conversion.ToNative.Simple.String(
        dafnyValue.dtor_TableName()
      )
    );
    nativeBuilder.Item(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.AttributeMap(
        dafnyValue.dtor_Item()
      )
    );
    if (dafnyValue.dtor_Version().is_Some()) {
      nativeBuilder.Version((dafnyValue.dtor_Version().dtor_value()));
    }
    return nativeBuilder.build();
  }

  public static ResolveAttributesOutput ResolveAttributesOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ResolveAttributesOutput dafnyValue
  ) {
    ResolveAttributesOutput.Builder nativeBuilder =
      ResolveAttributesOutput.builder();
    nativeBuilder.VirtualFields(
      ToNative.StringMap(dafnyValue.dtor_VirtualFields())
    );
    nativeBuilder.CompoundBeacons(
      ToNative.StringMap(dafnyValue.dtor_CompoundBeacons())
    );
    return nativeBuilder.build();
  }

  public static ScanInputTransformInput ScanInputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ScanInputTransformInput dafnyValue
  ) {
    ScanInputTransformInput.Builder nativeBuilder =
      ScanInputTransformInput.builder();
    nativeBuilder.sdkInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.ScanInput(
        dafnyValue.dtor_sdkInput()
      )
    );
    return nativeBuilder.build();
  }

  public static ScanInputTransformOutput ScanInputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ScanInputTransformOutput dafnyValue
  ) {
    ScanInputTransformOutput.Builder nativeBuilder =
      ScanInputTransformOutput.builder();
    nativeBuilder.transformedInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.ScanInput(
        dafnyValue.dtor_transformedInput()
      )
    );
    return nativeBuilder.build();
  }

  public static ScanOutputTransformInput ScanOutputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ScanOutputTransformInput dafnyValue
  ) {
    ScanOutputTransformInput.Builder nativeBuilder =
      ScanOutputTransformInput.builder();
    nativeBuilder.sdkOutput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.ScanOutput(
        dafnyValue.dtor_sdkOutput()
      )
    );
    nativeBuilder.originalInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.ScanInput(
        dafnyValue.dtor_originalInput()
      )
    );
    return nativeBuilder.build();
  }

  public static ScanOutputTransformOutput ScanOutputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.ScanOutputTransformOutput dafnyValue
  ) {
    ScanOutputTransformOutput.Builder nativeBuilder =
      ScanOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.ScanOutput(
        dafnyValue.dtor_transformedOutput()
      )
    );
    return nativeBuilder.build();
  }

  public static TransactGetItemsInputTransformInput TransactGetItemsInputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactGetItemsInputTransformInput dafnyValue
  ) {
    TransactGetItemsInputTransformInput.Builder nativeBuilder =
      TransactGetItemsInputTransformInput.builder();
    nativeBuilder.sdkInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.TransactGetItemsInput(
        dafnyValue.dtor_sdkInput()
      )
    );
    return nativeBuilder.build();
  }

  public static TransactGetItemsInputTransformOutput TransactGetItemsInputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactGetItemsInputTransformOutput dafnyValue
  ) {
    TransactGetItemsInputTransformOutput.Builder nativeBuilder =
      TransactGetItemsInputTransformOutput.builder();
    nativeBuilder.transformedInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.TransactGetItemsInput(
        dafnyValue.dtor_transformedInput()
      )
    );
    return nativeBuilder.build();
  }

  public static TransactGetItemsOutputTransformInput TransactGetItemsOutputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactGetItemsOutputTransformInput dafnyValue
  ) {
    TransactGetItemsOutputTransformInput.Builder nativeBuilder =
      TransactGetItemsOutputTransformInput.builder();
    nativeBuilder.sdkOutput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.TransactGetItemsOutput(
        dafnyValue.dtor_sdkOutput()
      )
    );
    nativeBuilder.originalInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.TransactGetItemsInput(
        dafnyValue.dtor_originalInput()
      )
    );
    return nativeBuilder.build();
  }

  public static TransactGetItemsOutputTransformOutput TransactGetItemsOutputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactGetItemsOutputTransformOutput dafnyValue
  ) {
    TransactGetItemsOutputTransformOutput.Builder nativeBuilder =
      TransactGetItemsOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.TransactGetItemsOutput(
        dafnyValue.dtor_transformedOutput()
      )
    );
    return nativeBuilder.build();
  }

  public static TransactWriteItemsInputTransformInput TransactWriteItemsInputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactWriteItemsInputTransformInput dafnyValue
  ) {
    TransactWriteItemsInputTransformInput.Builder nativeBuilder =
      TransactWriteItemsInputTransformInput.builder();
    nativeBuilder.sdkInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.TransactWriteItemsInput(
        dafnyValue.dtor_sdkInput()
      )
    );
    return nativeBuilder.build();
  }

  public static TransactWriteItemsInputTransformOutput TransactWriteItemsInputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactWriteItemsInputTransformOutput dafnyValue
  ) {
    TransactWriteItemsInputTransformOutput.Builder nativeBuilder =
      TransactWriteItemsInputTransformOutput.builder();
    nativeBuilder.transformedInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.TransactWriteItemsInput(
        dafnyValue.dtor_transformedInput()
      )
    );
    return nativeBuilder.build();
  }

  public static TransactWriteItemsOutputTransformInput TransactWriteItemsOutputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactWriteItemsOutputTransformInput dafnyValue
  ) {
    TransactWriteItemsOutputTransformInput.Builder nativeBuilder =
      TransactWriteItemsOutputTransformInput.builder();
    nativeBuilder.sdkOutput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.TransactWriteItemsOutput(
        dafnyValue.dtor_sdkOutput()
      )
    );
    nativeBuilder.originalInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.TransactWriteItemsInput(
        dafnyValue.dtor_originalInput()
      )
    );
    return nativeBuilder.build();
  }

  public static TransactWriteItemsOutputTransformOutput TransactWriteItemsOutputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.TransactWriteItemsOutputTransformOutput dafnyValue
  ) {
    TransactWriteItemsOutputTransformOutput.Builder nativeBuilder =
      TransactWriteItemsOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.TransactWriteItemsOutput(
        dafnyValue.dtor_transformedOutput()
      )
    );
    return nativeBuilder.build();
  }

  public static UpdateItemInputTransformInput UpdateItemInputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateItemInputTransformInput dafnyValue
  ) {
    UpdateItemInputTransformInput.Builder nativeBuilder =
      UpdateItemInputTransformInput.builder();
    nativeBuilder.sdkInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.UpdateItemInput(
        dafnyValue.dtor_sdkInput()
      )
    );
    return nativeBuilder.build();
  }

  public static UpdateItemInputTransformOutput UpdateItemInputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateItemInputTransformOutput dafnyValue
  ) {
    UpdateItemInputTransformOutput.Builder nativeBuilder =
      UpdateItemInputTransformOutput.builder();
    nativeBuilder.transformedInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.UpdateItemInput(
        dafnyValue.dtor_transformedInput()
      )
    );
    return nativeBuilder.build();
  }

  public static UpdateItemOutputTransformInput UpdateItemOutputTransformInput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateItemOutputTransformInput dafnyValue
  ) {
    UpdateItemOutputTransformInput.Builder nativeBuilder =
      UpdateItemOutputTransformInput.builder();
    nativeBuilder.sdkOutput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.UpdateItemOutput(
        dafnyValue.dtor_sdkOutput()
      )
    );
    nativeBuilder.originalInput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.UpdateItemInput(
        dafnyValue.dtor_originalInput()
      )
    );
    return nativeBuilder.build();
  }

  public static UpdateItemOutputTransformOutput UpdateItemOutputTransformOutput(
    software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.internaldafny.types.UpdateItemOutputTransformOutput dafnyValue
  ) {
    UpdateItemOutputTransformOutput.Builder nativeBuilder =
      UpdateItemOutputTransformOutput.builder();
    nativeBuilder.transformedOutput(
      software.amazon.cryptography.services.dynamodb.internaldafny.ToNative.UpdateItemOutput(
        dafnyValue.dtor_transformedOutput()
      )
    );
    return nativeBuilder.build();
  }

  public static Map<String, String> StringMap(
    DafnyMap<
      ? extends DafnySequence<? extends Character>,
      ? extends DafnySequence<? extends Character>
    > dafnyValue
  ) {
    return software.amazon.smithy.dafny.conversion.ToNative.Aggregate.GenericToMap(
      dafnyValue,
      software.amazon.smithy.dafny.conversion.ToNative.Simple::String,
      software.amazon.smithy.dafny.conversion.ToNative.Simple::String
    );
  }

  public static DynamoDbEncryptionTransforms DynamoDbEncryptionTransforms(
    IDynamoDbEncryptionTransformsClient dafnyValue
  ) {
    return new DynamoDbEncryptionTransforms(dafnyValue);
  }
}
