package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.config.ConfigValidator;
import aws.cryptography.dbesdk.testserver.server.config.ItemEncryptorFactory;
import aws.cryptography.dbesdk.testserver.server.config.StructuredClientFactory;
import aws.cryptography.dbesdk.testserver.server.config.TransformsClientFactory;
import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.registry.ClientRegistry;
import aws.cryptography.dbesdk.testserver.server.registry.StructuredClientRegistry;
import aws.cryptography.dbesdk.testserver.server.registry.TransformsClientRegistry;
import aws.cryptography.dbesdk.testserver.server.service.DBESDKTestServer;

/**
 * Wires the generated {@link DBESDKTestServer} service to the hand-written
 * operation handlers over one shared, thread-safe {@link ClientRegistry}. This
 * is the single assembly point the launcher (and the concurrency integration
 * test) use to obtain a fully-wired service instance.
 *
 * <p>All three handlers share the same registry so that a {@code ClientId}
 * minted by {@code CreateClient} resolves on subsequent
 * {@code EncryptItem}/{@code DecryptItem} calls, and the registry is the
 * single piece of shared mutable state exercised under concurrency.
 */
public final class DbesdkTestServerHandlers {

  private final ClientRegistry registry;
  private final TransformsClientRegistry transformsRegistry;
  private final CreateClientHandler createClient;
  private final EncryptItemHandler encryptItem;
  private final DecryptItemHandler decryptItem;
  private final GetEncryptedDataKeyDescriptionHandler getEncryptedDataKeyDescription;
  private final GetNumberOfQueriesHandler getNumberOfQueries;
  private final CreateTransformsClientHandler createTransformsClient;
  private final PutItemInputTransformHandler putItemInputTransform;
  private final PutItemOutputTransformHandler putItemOutputTransform;
  private final UpdateItemOutputTransformHandler updateItemOutputTransform;
  private final DeleteItemOutputTransformHandler deleteItemOutputTransform;
  private final TransactWriteItemsOutputTransformHandler transactWriteItemsOutputTransform;
  private final ExecuteStatementOutputTransformHandler executeStatementOutputTransform;
  private final ExecuteTransactionOutputTransformHandler executeTransactionOutputTransform;
  private final BatchExecuteStatementOutputTransformHandler batchExecuteStatementOutputTransform;
  private final BatchGetItemInputTransformHandler batchGetItemInputTransform;
  private final TransactGetItemsInputTransformHandler transactGetItemsInputTransform;
  private final TransactGetItemsOutputTransformHandler transactGetItemsOutputTransform;
  private final GetItemOutputTransformHandler getItemOutputTransform;
  private final GetItemInputTransformHandler getItemInputTransform;
  private final BatchWriteItemInputTransformHandler batchWriteItemInputTransform;
  private final BatchWriteItemOutputTransformHandler batchWriteItemOutputTransform;
  private final TransactWriteItemsInputTransformHandler transactWriteItemsInputTransform;
  private final ScanOutputTransformHandler scanOutputTransform;
  private final QueryOutputTransformHandler queryOutputTransform;
  private final BatchGetItemOutputTransformHandler batchGetItemOutputTransform;
  private final ScanInputTransformHandler scanInputTransform;
  private final QueryInputTransformHandler queryInputTransform;
  private final UpdateItemInputTransformHandler updateItemInputTransform;
  private final DeleteItemInputTransformHandler deleteItemInputTransform;
  private final ExecuteStatementInputTransformHandler executeStatementInputTransform;
  private final BatchExecuteStatementInputTransformHandler batchExecuteStatementInputTransform;
  private final ExecuteTransactionInputTransformHandler executeTransactionInputTransform;
  private final CreateStructuredClientHandler createStructuredClient;
  private final EncryptStructureHandler encryptStructure;
  private final DecryptStructureHandler decryptStructure;
  private final EncryptPathStructureHandler encryptPathStructure;
  private final DecryptPathStructureHandler decryptPathStructure;
  private final ResolveAuthActionsHandler resolveAuthActions;

  public DbesdkTestServerHandlers() {
    this(new ClientRegistry());
  }

  public DbesdkTestServerHandlers(ClientRegistry registry) {
    this.registry = registry;
    this.transformsRegistry = new TransformsClientRegistry();
    OperationWrapper wrapper = new OperationWrapper();
    ConfigValidator validator = new ConfigValidator();
    ItemEncryptorFactory factory = new ItemEncryptorFactory();
    TransformsClientFactory transformsFactory = new TransformsClientFactory(
      factory
    );
    ClientIdGuard guard = new ClientIdGuard(registry);
    TransformsClientGuard transformsGuard = new TransformsClientGuard(
      transformsRegistry
    );
    DdbItemCodec itemCodec = new DdbItemCodec();
    WriteRequestCodec writeRequestCodec = new WriteRequestCodec(itemCodec);

    this.createClient =
      new CreateClientHandler(registry, validator, factory, wrapper);
    this.encryptItem = new EncryptItemHandler(guard, wrapper, itemCodec);
    this.decryptItem = new DecryptItemHandler(guard, wrapper, itemCodec);
    this.getEncryptedDataKeyDescription =
      new GetEncryptedDataKeyDescriptionHandler(wrapper, itemCodec);
    this.getNumberOfQueries = new GetNumberOfQueriesHandler(wrapper);
    this.createTransformsClient =
      new CreateTransformsClientHandler(
        transformsRegistry,
        validator,
        transformsFactory,
        wrapper
      );
    this.putItemInputTransform =
      new PutItemInputTransformHandler(transformsGuard, wrapper, itemCodec);
    this.putItemOutputTransform =
      new PutItemOutputTransformHandler(transformsGuard, wrapper, itemCodec);
    this.updateItemOutputTransform =
      new UpdateItemOutputTransformHandler(transformsGuard, wrapper, itemCodec);
    this.deleteItemOutputTransform =
      new DeleteItemOutputTransformHandler(transformsGuard, wrapper, itemCodec);
    this.transactWriteItemsOutputTransform =
      new TransactWriteItemsOutputTransformHandler(
        transformsGuard,
        wrapper,
        itemCodec
      );
    this.executeStatementOutputTransform =
      new ExecuteStatementOutputTransformHandler(
        transformsGuard,
        wrapper,
        itemCodec
      );
    this.executeTransactionOutputTransform =
      new ExecuteTransactionOutputTransformHandler(
        transformsGuard,
        wrapper,
        itemCodec
      );
    this.batchExecuteStatementOutputTransform =
      new BatchExecuteStatementOutputTransformHandler(
        transformsGuard,
        wrapper,
        itemCodec
      );
    this.batchGetItemInputTransform =
      new BatchGetItemInputTransformHandler(
        transformsGuard,
        wrapper,
        itemCodec
      );
    this.transactGetItemsInputTransform =
      new TransactGetItemsInputTransformHandler(
        transformsGuard,
        wrapper,
        itemCodec
      );
    this.transactGetItemsOutputTransform =
      new TransactGetItemsOutputTransformHandler(
        transformsGuard,
        wrapper,
        itemCodec
      );
    this.getItemOutputTransform =
      new GetItemOutputTransformHandler(transformsGuard, wrapper, itemCodec);
    this.getItemInputTransform =
      new GetItemInputTransformHandler(transformsGuard, wrapper, itemCodec);
    this.batchWriteItemInputTransform =
      new BatchWriteItemInputTransformHandler(
        transformsGuard,
        wrapper,
        writeRequestCodec
      );
    this.batchWriteItemOutputTransform =
      new BatchWriteItemOutputTransformHandler(
        transformsGuard,
        wrapper,
        writeRequestCodec
      );
    this.transactWriteItemsInputTransform =
      new TransactWriteItemsInputTransformHandler(
        transformsGuard,
        wrapper,
        itemCodec
      );
    this.scanOutputTransform =
      new ScanOutputTransformHandler(transformsGuard, wrapper, itemCodec);
    this.queryOutputTransform =
      new QueryOutputTransformHandler(transformsGuard, wrapper, itemCodec);
    this.batchGetItemOutputTransform =
      new BatchGetItemOutputTransformHandler(
        transformsGuard,
        wrapper,
        itemCodec
      );
    this.executeStatementInputTransform =
      new ExecuteStatementInputTransformHandler(transformsGuard, wrapper);
    this.batchExecuteStatementInputTransform =
      new BatchExecuteStatementInputTransformHandler(transformsGuard, wrapper);
    this.executeTransactionInputTransform =
      new ExecuteTransactionInputTransformHandler(transformsGuard, wrapper);
    this.scanInputTransform =
      new ScanInputTransformHandler(transformsGuard, wrapper, itemCodec);
    this.queryInputTransform =
      new QueryInputTransformHandler(transformsGuard, wrapper, itemCodec);
    this.updateItemInputTransform =
      new UpdateItemInputTransformHandler(transformsGuard, wrapper, itemCodec);
    this.deleteItemInputTransform =
      new DeleteItemInputTransformHandler(transformsGuard, wrapper, itemCodec);

    StructuredClientRegistry structuredRegistry =
      new StructuredClientRegistry();
    StructuredClientFactory structuredFactory = new StructuredClientFactory(
      factory
    );
    StructuredClientGuard structuredGuard = new StructuredClientGuard(
      structuredRegistry
    );
    StructuredDataCodec structuredCodec = new StructuredDataCodec();
    this.createStructuredClient =
      new CreateStructuredClientHandler(
        structuredRegistry,
        validator,
        structuredFactory,
        wrapper
      );
    this.encryptStructure =
      new EncryptStructureHandler(structuredGuard, wrapper, structuredCodec);
    this.decryptStructure =
      new DecryptStructureHandler(structuredGuard, wrapper, structuredCodec);
    this.encryptPathStructure =
      new EncryptPathStructureHandler(
        structuredGuard,
        wrapper,
        structuredCodec
      );
    this.decryptPathStructure =
      new DecryptPathStructureHandler(
        structuredGuard,
        wrapper,
        structuredCodec
      );
    this.resolveAuthActions =
      new ResolveAuthActionsHandler(
        structuredFactory,
        wrapper,
        structuredCodec
      );
  }

  /** @return the shared registry (for inspection in tests). */
  public ClientRegistry registry() {
    return registry;
  }

  public CreateClientHandler createClientHandler() {
    return createClient;
  }

  public EncryptItemHandler encryptItemHandler() {
    return encryptItem;
  }

  public DecryptItemHandler decryptItemHandler() {
    return decryptItem;
  }

  public CreateTransformsClientHandler createTransformsClientHandler() {
    return createTransformsClient;
  }

  public PutItemInputTransformHandler putItemInputTransformHandler() {
    return putItemInputTransform;
  }

  public GetItemOutputTransformHandler getItemOutputTransformHandler() {
    return getItemOutputTransform;
  }

  public BatchWriteItemInputTransformHandler batchWriteItemInputTransformHandler() {
    return batchWriteItemInputTransform;
  }

  public TransactWriteItemsInputTransformHandler transactWriteItemsInputTransformHandler() {
    return transactWriteItemsInputTransform;
  }

  /** Build the generated service wired to these handlers. */
  public DBESDKTestServer service() {
    return DBESDKTestServer
      .builder()
      .addBatchExecuteStatementInputTransformOperation(
        batchExecuteStatementInputTransform
      )
      .addBatchExecuteStatementOutputTransformOperation(
        batchExecuteStatementOutputTransform
      )
      .addBatchGetItemInputTransformOperation(batchGetItemInputTransform)
      .addBatchGetItemOutputTransformOperation(batchGetItemOutputTransform)
      .addBatchWriteItemInputTransformOperation(batchWriteItemInputTransform)
      .addBatchWriteItemOutputTransformOperation(batchWriteItemOutputTransform)
      .addCreateClientOperation(createClient)
      .addCreateStructuredClientOperation(createStructuredClient)
      .addCreateTransformsClientOperation(createTransformsClient)
      .addDecryptItemOperation(decryptItem)
      .addDecryptPathStructureOperation(decryptPathStructure)
      .addDecryptStructureOperation(decryptStructure)
      .addDeleteItemInputTransformOperation(deleteItemInputTransform)
      .addDeleteItemOutputTransformOperation(deleteItemOutputTransform)
      .addEncryptItemOperation(encryptItem)
      .addEncryptPathStructureOperation(encryptPathStructure)
      .addEncryptStructureOperation(encryptStructure)
      .addExecuteStatementInputTransformOperation(
        executeStatementInputTransform
      )
      .addExecuteStatementOutputTransformOperation(
        executeStatementOutputTransform
      )
      .addExecuteTransactionInputTransformOperation(
        executeTransactionInputTransform
      )
      .addExecuteTransactionOutputTransformOperation(
        executeTransactionOutputTransform
      )
      .addGetEncryptedDataKeyDescriptionOperation(
        getEncryptedDataKeyDescription
      )
      .addGetItemInputTransformOperation(getItemInputTransform)
      .addGetItemOutputTransformOperation(getItemOutputTransform)
      .addGetNumberOfQueriesOperation(getNumberOfQueries)
      .addPutItemInputTransformOperation(putItemInputTransform)
      .addPutItemOutputTransformOperation(putItemOutputTransform)
      .addQueryInputTransformOperation(queryInputTransform)
      .addQueryOutputTransformOperation(queryOutputTransform)
      .addResolveAuthActionsOperation(resolveAuthActions)
      .addScanInputTransformOperation(scanInputTransform)
      .addScanOutputTransformOperation(scanOutputTransform)
      .addTransactGetItemsInputTransformOperation(
        transactGetItemsInputTransform
      )
      .addTransactGetItemsOutputTransformOperation(
        transactGetItemsOutputTransform
      )
      .addTransactWriteItemsInputTransformOperation(
        transactWriteItemsInputTransform
      )
      .addTransactWriteItemsOutputTransformOperation(
        transactWriteItemsOutputTransform
      )
      .addUpdateItemInputTransformOperation(updateItemInputTransform)
      .addUpdateItemOutputTransformOperation(updateItemOutputTransform)
      .build();
  }
}
