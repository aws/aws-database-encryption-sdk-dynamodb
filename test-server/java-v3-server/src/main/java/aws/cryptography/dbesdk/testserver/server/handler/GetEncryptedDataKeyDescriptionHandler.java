package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.model.EncryptedDataKeyDescription;
import aws.cryptography.dbesdk.testserver.server.model.EncryptedDataKeyDescriptionSource;
import aws.cryptography.dbesdk.testserver.server.model.GetEncryptedDataKeyDescriptionInput;
import aws.cryptography.dbesdk.testserver.server.model.GetEncryptedDataKeyDescriptionOutput;
import aws.cryptography.dbesdk.testserver.server.service.GetEncryptedDataKeyDescriptionOperation;
import java.util.ArrayList;
import java.util.List;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryption;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetEncryptedDataKeyDescriptionUnion;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Wraps the DBE product {@code DynamoDbEncryption.GetEncryptedDataKeyDescription}
 * operation. It parses the Encrypted Data Keys out of a serialized header
 * (supplied directly, or read from an encrypted item's {@code aws_dbe_head}
 * attribute) and returns one description per EDK. No client id, CMM, or keyring
 * is involved — the top-level {@code DynamoDbEncryption} client is built once
 * from an empty config and reused (the operation only parses header bytes).
 *
 * <p>A DBE failure (e.g. an item with no header attribute) is forwarded as a
 * {@code DBESDKClientError} by the surrounding {@link OperationWrapper}.
 */
public final class GetEncryptedDataKeyDescriptionHandler
  implements GetEncryptedDataKeyDescriptionOperation {

  private final OperationWrapper wrapper;
  private final DdbItemCodec itemCodec;
  private final DynamoDbEncryption dbe;

  public GetEncryptedDataKeyDescriptionHandler(
    OperationWrapper wrapper,
    DdbItemCodec itemCodec
  ) {
    this.wrapper = wrapper;
    this.itemCodec = itemCodec;
    this.dbe =
      DynamoDbEncryption
        .builder()
        .DynamoDbEncryptionConfig(DynamoDbEncryptionConfig.builder().build())
        .build();
  }

  @Override
  public GetEncryptedDataKeyDescriptionOutput getEncryptedDataKeyDescription(
    GetEncryptedDataKeyDescriptionInput input,
    RequestContext context
  ) {
    return wrapper.invoke(
      "GetEncryptedDataKeyDescription",
      () -> {
        GetEncryptedDataKeyDescriptionUnion union = toProductUnion(
          input.getInput()
        );

        software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetEncryptedDataKeyDescriptionOutput product =
          dbe.GetEncryptedDataKeyDescription(
            software.amazon.cryptography.dbencryptionsdk.dynamodb.model.GetEncryptedDataKeyDescriptionInput
              .builder()
              .input(union)
              .build()
          );

        List<EncryptedDataKeyDescription> descriptions = new ArrayList<>();
        for (software.amazon.cryptography.dbencryptionsdk.dynamodb.model.EncryptedDataKeyDescription d : product.EncryptedDataKeyDescriptionOutput()) {
          descriptions.add(
            EncryptedDataKeyDescription
              .builder()
              .keyProviderId(d.keyProviderId())
              .keyProviderInfo(d.keyProviderInfo())
              .branchKeyId(d.branchKeyId())
              .branchKeyVersion(d.branchKeyVersion())
              .build()
          );
        }
        return GetEncryptedDataKeyDescriptionOutput
          .builder()
          .descriptions(descriptions)
          .build();
      }
    );
  }

  /** Map the wire input union onto the product union (header blob or item). */
  private GetEncryptedDataKeyDescriptionUnion toProductUnion(
    EncryptedDataKeyDescriptionSource source
  ) {
    if (
      source instanceof EncryptedDataKeyDescriptionSource.HeaderMember header
    ) {
      return GetEncryptedDataKeyDescriptionUnion
        .builder()
        .header(header.header())
        .build();
    }
    if (source instanceof EncryptedDataKeyDescriptionSource.ItemMember item) {
      return GetEncryptedDataKeyDescriptionUnion
        .builder()
        .item(itemCodec.toDdb(item.item()))
        .build();
    }
    throw new IllegalArgumentException(
      "GetEncryptedDataKeyDescription input union has no supported member set"
    );
  }
}
